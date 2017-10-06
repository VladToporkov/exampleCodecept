package com.actionmedia.autotest.listeners;

import com.actionmedia.autotest.spring.SeleniumSettings;
import com.actionmedia.autotest.utils.TestMethodUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.*;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;

import static java.lang.String.format;

/**
 * User: n.tyukavkin
 * Date: 17.01.14
 * Time: 15:55
 */
public class ServicesMailSenderListener implements ISuiteListener {

    private static final SeleniumSettings SELENIUM_SETTINGS = new ClassPathXmlApplicationContext(new String[]{"classpath*:/META-INF/spring/context-selenium.xml"}).getBean(SeleniumSettings.class);
    private final Log logger = LogFactory.getLog(getClass());
    private static int counter = 0;

    @Override
    public void onFinish(ISuite suite) {
        if (counter == 0) {

            StringBuilder builder = new StringBuilder();

            if (suite.getXmlSuite().getFileName().contains("customsuite") || !suite.getXmlSuite().getFileName().contains("service")) {
                return;
            }

            if (SELENIUM_SETTINGS.isRunProk1()) {
                return;
            }

            if (SELENIUM_SETTINGS.isRunCI()) {
                return;
            }

            for (Map.Entry<String, ISuiteResult> entry : suite.getResults().entrySet()) {
                ISuiteResult value = entry.getValue();
                Set<ITestResult> failResults = value.getTestContext().getFailedTests().getAllResults();
                for (Object result : failResults) {
                    ITestNGMethod testNGMethod = ((ITestResult) result).getMethod();
                    builder
                            .append("\n")
                            .append(testNGMethod.getMethodName())
                            .append("\n");
                    List<String> reportOutputList = Reporter.getOutput((ITestResult) result);
                    for (int i = 0; i < reportOutputList.size(); i++) {
                        builder
                                .append(reportOutputList.get(i))
                                .append("\n");
                    }
                    builder
                            .append("_________________________________________________________________________")
                            .append("\n");
                }

                Set<ITestResult> allResults = value.getTestContext().getPassedTests().getAllResults();
                for (Object result : allResults) {
                    final String testName = getTestName((ITestResult) result).split(".browser")[0];
                    if (!isPostponedFailed(value.getTestContext(), testName)){
                        continue;
                    }
                    ITestNGMethod testNGMethod = ((ITestResult) result).getMethod();
                    builder
                            .append("\n")
                            .append(testNGMethod.getMethodName())
                            .append("\n");
                    List<String> reportOutputList = Reporter.getOutput((ITestResult) result);
                    for (int i = 0; i < reportOutputList.size(); i++) {
                        builder
                                .append(reportOutputList.get(i))
                                .append("\n");
                    }
                    builder
                            .append("_________________________________________________________________________")
                            .append("\n");
                }
            }

            final Properties mailProperties = (Properties) suite.getResults().values().iterator().next().getTestContext().getAttribute("mailProperties");
            String text = builder.toString();

            DateTime dateTime = new DateTime();

            String serviceName = "";
            String[] emails = new String[]{};
            for (String group : suite.getAllMethods().get(0).getGroups()) {
                if ("search".equals(group)) {
                    serviceName = "Сервис поиска.";
                    emails = mailProperties.getProperty("mail.to.search.service").split(",");
                    break;
                } else if ("index".equals(group)) {
                    serviceName = "Сервис поиска. Проверка поиска документов.";
                    emails = mailProperties.getProperty("mail.to.search.service").split(",");
                    break;
                } else if ("glavbukh".equals(group)) {
                    serviceName = "Сервис ГлавБуха.";
                    emails = mailProperties.getProperty("mail.to.glavbukh.service").split(",");
                    break;
                } else if ("event".equals(group)) {
                    serviceName = "Сервис Автописем.";
                    emails = mailProperties.getProperty("mail.to.event.service").split(",");
                    break;
                } else if ("npd".equals(group)) {
                    serviceName = "Сервис Экспорта НПД.";
                    emails = mailProperties.getProperty("mail.to.npd.service").split(",");
                    break;
                } else if ("buhonline".equals(group)) {
                    serviceName = "Сервис Программа Главбух.";
                    emails = mailProperties.getProperty("mail.to.buhonline.service").split(",");
                    break;
                }
            }

            String subject = serviceName + " Упавшие тесты " + dateTime.toString("dd-MM-yyyy HH:mm", new Locale("ru"));
            if (!text.isEmpty()) {
                send(mailProperties, subject, text, emails);
            }
            counter++;
        }
    }

    private void send(final Properties mailProperties, String subject, String text, String[] emails) {

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
                toAddress[i] = new InternetAddress(emails[i]);
            }

        } catch (AddressException e) {
            logger.error("AddressException occurs", e);
        }

        try {
            simpleMessage.setSentDate(new Date());
            simpleMessage.setFrom(fromAddress);
            simpleMessage.setRecipients(Message.RecipientType.TO, toAddress);
            simpleMessage.setSubject(subject);
            simpleMessage.setText(text);

            Transport.send(simpleMessage);
        } catch (MessagingException e) {
            logger.error("MessagingException occurs", e);
        }
    }

    private Boolean isPostponedFailed(ITestContext testContext, String testName) {
        Boolean postponedFailed = (Boolean) testContext.getAttribute(format("%s postpone fail", testName));
        return postponedFailed != null ? postponedFailed : false;
    }

    private String getTestName(ITestResult testResult) {
        return TestMethodUtils.getTestName(testResult);
    }

    @Override
    public void onStart(ISuite suite) {
    }
}
