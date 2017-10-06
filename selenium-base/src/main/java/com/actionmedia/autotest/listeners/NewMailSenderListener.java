package com.actionmedia.autotest.listeners;

import com.actionmedia.autotest.screenshots.ScreenshotInfo;
import com.actionmedia.autotest.utils.TestMethodUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import static com.actionmedia.autotest.Group.content;
import static com.actionmedia.autotest.screenshots.ScreenShotsPathsHolder.getScreenShotPathsForTest;
import static java.lang.String.format;

/**
 * User: n.tyukavkin
 * Date: 21.12.13
 * Time: 10:04
 */
public class NewMailSenderListener implements ITestListener {

    private final Log logger = LogFactory.getLog(getClass());

    private static ThreadLocal<List<String>> testsNameList = new ThreadLocal<List<String>>(){
        @Override
        protected List<String> initialValue() {
            return new ArrayList<String>();
        }
    };

    private static ThreadLocal<List<File>> attachList = new ThreadLocal<List<File>>(){
        @Override
        protected List<File> initialValue() {
            return new ArrayList<File>();
        }
    };

    private static ThreadLocal<List<Result>> resultList = new ThreadLocal<List<Result>>(){
        @Override
        protected List<Result> initialValue() {
            return new ArrayList<Result>();
        }
    };

    @Override
    public void onFinish(ITestContext context) {
        if (context.getCurrentXmlTest().getSuite().getFileName().contains("customsuite.xml")) {
            return;
        }

        int numberOfTests = testsNameList.get().size();
        List<String> allTestNameList = new ArrayList<String>();
        List<String> reFallingTestNameList = new ArrayList<String>();
        for (Result result : resultList.get()) {
            if (!allTestNameList.contains(result.getTestName())) {
                allTestNameList.add(result.getTestName());
            }
        }

        for (String testName : allTestNameList) {
            List<ErrorInfo> errorInfoList = getErrorInfoListForTest(testName);
            List<String> errorMessage = new ArrayList<String>();
            int failCount = 0;
            for (ErrorInfo errorInfo : errorInfoList) {
                if (errorMessage.contains(errorInfo.getError())) {
                    failCount++;
                } else {
                    errorMessage.add(errorInfo.getError());
                }
            }

            if (errorInfoList.size() > 1 && failCount == errorInfoList.size() - 1) {
                reFallingTestNameList.add(testName);
            }
        }

        if (!reFallingTestNameList.isEmpty() && ((reFallingTestNameList.size() * 100) / numberOfTests) > 20) {

            final Properties mailProperties = (Properties) context.getAttribute("mailProperties");
            List<File> fileList = new ArrayList<File>();
            String errorSend = "";

            for (String testName : reFallingTestNameList) {
                List<ErrorInfo> errorInfoList = getErrorInfoListForTest(testName);
                fileList.addAll(errorInfoList.iterator().next().getAttach());
                errorSend = errorSend + errorInfoList.iterator().next().getError();
            }

            String systemName = context.getCurrentXmlTest().getName();
            if (fileList.isEmpty()) {
                return;
            }

            if (errorSend.isEmpty()) {
                return;
            }

            String smsMessage = systemName + ". Отсутствует контент. Упало " + reFallingTestNameList.size() + " тестов из " + numberOfTests;
//            sendSms(mailProperties, smsMessage);

            sendEmail(mailProperties, errorSend, fileList, systemName);
        }
    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        if (!isContentTest(testResult.getMethod())) {
            return;
        }

        String testName = getTestName(testResult);
        List<ScreenshotInfo> screenshotInfoList = getScreenShotPathsForTest(testName);
        List<File> fileList = new ArrayList<File>();
        StringBuilder builder = new StringBuilder();
        for (ScreenshotInfo screenshotInfo : screenshotInfoList) {
            if (!isPostponedFailed(testResult.getTestContext(), testName)) {
                continue;
            }

            File file = getAttachFile(screenshotInfo);
            if (isFileExist(file.getName())) {
                continue;
            }

            builder
                    .append("\n")
                    .append(screenshotInfo.getMessage().replaceAll("expected:", "").replaceAll("but", "").replaceAll("was:", ""))
                    .append("\n")
                    .append("_______________________________________________________________________________________________")
                    .append("\n");

            fileList.add(file);
            attachList.get().add(file);
        }

        Result result = new Result(testName, builder.toString(), fileList);
        resultList.get().add(result);
    }

    private Boolean isPostponedFailed(ITestContext testContext, String testName) {
        testName = testName.split(".browser")[0];
        Boolean postponedFailed = (Boolean) testContext.getAttribute(format("%s postpone fail", testName));
        return postponedFailed != null ? postponedFailed : false;
    }

    private void sendEmail(final Properties mailProperties, String text, List<File> attachFileList, String systemName) {

        String from = mailProperties.getProperty("mail.user");
        String to = "";
        if (systemName.contains("БСС")) {
            to = mailProperties.getProperty("mail.to.bss");
        } else if (systemName.contains("КСС")) {
            to = mailProperties.getProperty("mail.to.kss");
        } else if (systemName.contains("ЮСС")) {
            to = mailProperties.getProperty("mail.to.uss");
        } else if (systemName.contains("ФСС")) {
            to = mailProperties.getProperty("mail.to.fss");
        } else if (systemName.contains("ГФ")) {
            to = mailProperties.getProperty("mail.to.gf");
        } else if (systemName.contains("ОТ")) {
            to = mailProperties.getProperty("mail.to.ehs");
        } else if (systemName.contains("ОБР")) {
            to = mailProperties.getProperty("mail.to.edu");
        } else if (systemName.contains("ЕЛПУ")) {
            to = mailProperties.getProperty("mail.to.elpu");
        } else if (systemName.contains("КЛПУ")) {
            to = mailProperties.getProperty("mail.to.klpu");
        } else if (systemName.contains("КУЛЬТУРА")) {
            to = mailProperties.getProperty("mail.to.cult");
        } else if (systemName.contains("ГЗ")) {
            to = mailProperties.getProperty("mail.to.go");
        } else if (systemName.contains("УМД")) {
            to = mailProperties.getProperty("mail.to.umd");
        } else if (systemName.contains("EX: Кадри")) {
            to = mailProperties.getProperty("mail.to.expertus_k");
        } else if (systemName.contains("EX: Головбух")) {
            to = mailProperties.getProperty("mail.to.expertus_gl");
        } else if (systemName.contains("ACT: Образование")) {
            to = mailProperties.getProperty("mail.to.actualis_edu");
        } else if (systemName.contains("ACT: Кадровое дело")) {
            to = mailProperties.getProperty("mail.to.actualis_k");
        } else if (systemName.contains("ACT: Госзакупки")) {
            to = mailProperties.getProperty("mail.to.actualis_gz");
        }

        String[] recipientArr = to.split(",");

        String subject = systemName + ". Отсутствует контент";

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
        InternetAddress[] toAddress = new InternetAddress[recipientArr.length];
        try {
            fromAddress = new InternetAddress(from);

            for (int i = 0; i < recipientArr.length; i++) {
                toAddress[i] = new InternetAddress(recipientArr[i].trim());
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
            for (File file : attachFileList) {
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

    private void sendSms(final Properties mailProperties, String message) {
        String login = mailProperties.getProperty("sms.login");
        String password = mailProperties.getProperty("sms.password");
        String phones = "";
        if (message.contains("БСС")) {
            phones = mailProperties.getProperty("sms.phones.bss");
        } else if (message.contains("КСС")) {
            phones = mailProperties.getProperty("sms.phones.kss");
        } else if (message.contains("ЮСС")) {
            phones = mailProperties.getProperty("sms.phones.uss");
        } else if (message.contains("ФСС")) {
            phones = mailProperties.getProperty("sms.phones.fss");
        } else if (message.contains("ГФ")) {
            phones = mailProperties.getProperty("sms.phones.gf");
        } else if (message.contains("ОТ")) {
            phones = mailProperties.getProperty("sms.phones.ot");
        } else if (message.contains("ОБР")) {
            phones = mailProperties.getProperty("sms.phones.edu");
        } else if (message.contains("ЕЛПУ")) {
            phones = mailProperties.getProperty("sms.phones.gf");
        } else if (message.contains("КЛПУ")) {
            phones = mailProperties.getProperty("sms.phones.gf");
        } else if (message.contains("КУЛЬТУРА")) {
            phones = mailProperties.getProperty("sms.phones.gf");
        } else if (message.contains("ГЗ")) {
            phones = mailProperties.getProperty("sms.phones.gf");
        } else if (message.contains("УМД")) {
            phones = mailProperties.getProperty("sms.phones.gf");
        } else if (message.contains("EX: Кадри")) {
            phones = mailProperties.getProperty("sms.phones.gf");
        } else if (message.contains("EX: Головбух")) {
            phones = mailProperties.getProperty("sms.phones.gf");
        } else if (message.contains("ACT: Образование")) {
            phones = mailProperties.getProperty("sms.phones.gf");
        } else if (message.contains("ACT: Кадровое дело")) {
            phones = mailProperties.getProperty("sms.phones.gf");
        } else if (message.contains("ACT: Госзакупки")) {
            phones = mailProperties.getProperty("sms.phones.gf");
        }

        Smsc smsc = new Smsc(login, password);

        /**
         * Отправка SMS
         *
         * @param phones   - список телефонов через запятую или точку с запятой
         * @param message  - отправляемое сообщение
         * @param translit - переводить или нет в транслит (1,2 или 0)
         * @param time     - необходимое время доставки в виде строки (DDMMYYhhmm, h1-h2, 0ts, +m)
         * @param id       - идентификатор сообщения. Представляет собой 32-битное число в диапазоне от 1 до 2147483647.
         * @param format   - формат сообщения (0 - обычное sms, 1 - flash-sms, 2 - wap-push, 3 - hlr, 4 - bin, 5 - bin-hex, 6 - ping-sms)
         * @param sender   - имя отправителя (Sender ID). Для отключения Sender ID по умолчанию необходимо в качестве имени передать пустую строку или точку.
         * @param query    - строка дополнительных параметров, добавляемая в URL-запрос ("valid=01:00&maxsms=3&tz=2")
         * @return array (<id>, <количество sms>, <стоимость>, <баланс>) в случае успешной отправки
         * или массив (<id>, -<код ошибки>) в случае ошибки
         */

        String[] answer = smsc.send_sms(phones, message, 0, "", "", 0, "autotester", "");

        if (answer.length > 2) {
            String id = answer[0];
            String count = answer[1];
            String cost = answer[2];
            String balance = answer[3];

            String response = "Сообщение отправлено. id: " + id + " количество sms: " + count + " стоимость: " + cost + " баланс:" + balance;
            logger.info(response);
            Reporter.log(response);
        } else {
            String id = answer[0];
            String error = answer[1];

            String response = "Сообщение не отправлено. id: " + id + " номер ошибки:" + error;
            logger.info(response);
            Reporter.log(response);
        }
    }

    private List<ErrorInfo> getErrorInfoListForTest(String testName) {
        List<ErrorInfo> errorInfoList = new ArrayList<ErrorInfo>();
        for (Result result : resultList.get()) {
            if (result.getTestName().equals(testName)) {
                ErrorInfo errorInfo = new ErrorInfo(result.getErrorMessage(), result.getAttachList());
                errorInfoList.add(errorInfo);
            }
        }
        return errorInfoList;
    }

    private boolean isFileExist(String fileName) {
        for (File file : attachList.get()) {
            if (file.getName().equals(fileName)) {
                return true;
            }
        }
        return false;
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

    private boolean isContentTest(ITestNGMethod method) {
        for (String group : method.getGroups()) {
            if (group.contains(content)) {
                return true;
            }
        }
        return false;
    }

    private class Result {
        String testName;
        String errorMessage;
        List<File> attachList;

        Result(String testName, String errorMessage, List<File> attachList) {
            this.testName = testName;
            this.errorMessage = errorMessage;
            this.attachList = attachList;
        }

        public String getTestName() {
            return testName;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public List<File> getAttachList() {
            return attachList;
        }
    }

    private class ErrorInfo {
        String error;
        List<File> attach;

        ErrorInfo(String error, List<File> attach) {
            this.error = error;
            this.attach = attach;
        }

        public String getError() {
            return error;
        }

        public List<File> getAttach() {
            return attach;
        }

    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = getTestName(result);
        if (!testsNameList.get().contains(testName)) {
            testsNameList.get().add(testName);
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }
}
