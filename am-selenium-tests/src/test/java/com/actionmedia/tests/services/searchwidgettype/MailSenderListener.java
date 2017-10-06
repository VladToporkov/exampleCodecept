package com.actionmedia.tests.services.searchwidgettype;

import com.actionmedia.autotest.screenshots.ScreenshotInfo;
import com.actionmedia.autotest.utils.TestMethodUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.testng.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.mail.*;
import javax.mail.internet.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static com.actionmedia.autotest.screenshots.ScreenShotsPathsHolder.getScreenShotPathsForTest;
import static java.lang.String.format;

/**
 * User: n.tyukavkin
 * Date: 17.01.14
 * Time: 15:55
 */
public class MailSenderListener implements ISuiteListener {

    private final Log logger = LogFactory.getLog(getClass());

    @Override
    public void onFinish(ISuite suite) {
        StringBuilder builder = new StringBuilder();

        if (suite.getXmlSuite().getFileName().contains("customsuite") || !suite.getXmlSuite().getFileName().contains("service")) {
            return;
        }

        List<File> attachList = new ArrayList<File>();
        for (Map.Entry<String, ISuiteResult> entry : suite.getResults().entrySet()) {
            ISuiteResult value = entry.getValue();
            Set<ITestResult> allResults = value.getTestContext().getFailedTests().getAllResults();
            for (ITestResult result : allResults) {
                String error = result.getThrowable().getMessage();
                String systemName = getSystemName(result.getName());
                builder
                        .append(systemName + ":")
                        .append("\n")
                        .append(error)
                        .append("_________________________________________________________________________")
                        .append("\n");
                attachList.addAll(getAttachList(result));
            }
        }

        final Properties mailProperties = (Properties) suite.getResults().values().iterator().next().getTestContext().getAttribute("mailProperties");
        String text = builder.toString();

        DateTime dateTime = new DateTime();
        String[] emails = mailProperties.getProperty("mail.to.search.service").split(",");

        String subject = "Сервис поиска. Проверка колдунщиков. Упавшие тесты " + dateTime.toString("dd-MM-yyyy HH:mm", new Locale("ru"));
        if (!text.isEmpty()) {
            send(mailProperties, subject, text, emails, attachList);
        }
    }

    private void send(final Properties mailProperties, String subject, String text, String[] emails, List<File> attachList) {

        String from = mailProperties.getProperty("mail.user");

        Properties props = new Properties();
        props.put("mail.smtp.host", mailProperties.getProperty("mail.smtp.host"));
        props.put("mail.smtp.port", mailProperties.getProperty("mail.smtp.port"));
        props.put("mail.smtp.auth", mailProperties.getProperty("mail.smtp.auth"));
        props.put("mail.smtp.starttls.enable", mailProperties.getProperty("mail.smtp.starttls.enable"));

        Session mailSession = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return (new PasswordAuthentication(mailProperties.getProperty("mail.user"), mailProperties.getProperty("mail.user.password")));
            }
        });

        Message simpleMessage = new MimeMessage(mailSession);

        InternetAddress fromAddress = null;
        InternetAddress[] toAddress = new InternetAddress[emails.length];
        try {
            fromAddress = new InternetAddress(from);

            for (int i = 0; i < emails.length; i++) {
                toAddress[i] = new InternetAddress(emails[i].trim());
            }

        } catch (AddressException e) {
            logger.error("AddressException occurs", e);
        }

        try {
            simpleMessage.setSentDate(new Date());
            simpleMessage.setFrom(fromAddress);
            simpleMessage.setRecipients(Message.RecipientType.TO, toAddress);
            simpleMessage.setSubject(subject);

            MimeBodyPart mbp1 = new MimeBodyPart();
            mbp1.setText(text);

            List<MimeBodyPart> attachBodyPartList = new ArrayList<MimeBodyPart>();
            for (File file : attachList) {
                MimeBodyPart mbp2 = new MimeBodyPart();
                DataSource fds = new FileDataSource(file);
                mbp2.setDataHandler(new DataHandler(fds));
                mbp2.setFileName(fds.getName());

                attachBodyPartList.add(mbp2);
            }

            Multipart mp = new MimeMultipart();
            mp.addBodyPart(mbp1);

            for (MimeBodyPart bodyPart : attachBodyPartList) {
                mp.addBodyPart(bodyPart);
            }

            simpleMessage.setText(text);
            simpleMessage.setContent(mp);

            Transport.send(simpleMessage);
        } catch (MessagingException e) {
            logger.error("MessagingException occurs", e);
        }
    }

    private List<File> getAttachList(ITestResult testResult) {
        String testName = getTestName(testResult);
        List<ScreenshotInfo> screenshotInfoList = getScreenShotPathsForTest(testName);
        List<File> fileList = new ArrayList<File>();
        for (ScreenshotInfo screenshotInfo : screenshotInfoList) {
            if (!isPostponedFailed(testResult.getTestContext(), testName)) {
                continue;
            }

            File file = getAttachFile(screenshotInfo);
            fileList.add(file);
        }
        return fileList;
    }

    private Boolean isPostponedFailed(ITestContext testContext, String testName) {
        testName = testName.split(".browser")[0];
        Boolean postponedFailed = (Boolean) testContext.getAttribute(format("%s postpone fail", testName));
        return postponedFailed != null ? postponedFailed : false;
    }

    private String getTestName(ITestResult testResult) {
        return TestMethodUtils.getTestName(testResult);
    }

    private File getAttachFile(ScreenshotInfo screenshotInfo) {
        File attachmentFile = new File(screenshotInfo.getPath().split("//../")[1]);
        BufferedImage image;
        try {
            image = ImageIO.read(new File(screenshotInfo.getPath()));

            int width = image.getWidth();
            int height;
            if (image.getHeight() < 1080) {
                height = image.getHeight();
            } else {
                height = 1080;
            }
            image = image.getSubimage(0, 0, width, height);
            ImageIO.write(image, "png", attachmentFile);
        } catch (IOException e) {
            logger.error("IOException occurs", e);
        }
        return attachmentFile;
    }

    private String getSystemName(String methodName) {
        String systemName = "";
        if (methodName.contains("bss")) {
            systemName = "БСС";
        } else if (methodName.contains("kss")) {
            systemName = "КСС";
        } else if (methodName.contains("uss")) {
            systemName = "ЮСС";
        } else if (methodName.contains("fss")) {
            systemName = "ФСС";
        }
        return systemName;
    }

    @Override
    public void onStart(ISuite suite) {
    }
}
