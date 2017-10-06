package com.actionmedia.autotest.listeners;

import com.actionmedia.autotest.event.postpone.failure.ServicesPostponedErrorMessageHolder;
import com.actionmedia.autotest.selenium.SeleniumHolder;
import com.actionmedia.autotest.utils.Pair;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.autotest.utils.TestMethodUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.*;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

import static com.actionmedia.autotest.Group.*;

/**
 * User: n.tyukavkin
 * Date: 21.12.13
 * Time: 10:04
 */
public class NewStartPagesMailSenderListener implements ITestListener {

    private static final String LINE = "_______________________________________________________________________________________________";
    private static final String N_TAG = "\n";
    private final Log logger = LogFactory.getLog(getClass());
    private static ThreadLocal<StringBuilder> result = new ThreadLocal<StringBuilder>() {
        @Override
        protected StringBuilder initialValue() {
            return new StringBuilder();
        }
    };
    private static boolean isStartPagesTests = false;
    private static boolean isNewDocumentsTests = false;
    private static boolean isBackLinksTests = false;

    private static ThreadLocal<Map<String, List<String>>> checkedDocsForSystem = new ThreadLocal<Map<String, List<String>>>() {
        @Override
        protected Map<String, List<String>> initialValue() {
            return new HashMap<String, List<String>>();
        }
    };

    private static ThreadLocal<Map<String, Map<String, List<String>>>> checkedDocsMapForSystem = new ThreadLocal<Map<String, Map<String, List<String>>>>() {
        @Override
        protected Map<String, Map<String, List<String>>> initialValue() {
            return new HashMap<String, Map<String, List<String>>>();
        }
    };

    @Override
    public void onFinish(ITestContext context) {
        if (context.getCurrentXmlTest().getSuite().getFileName().contains("customsuite.xml")) {
            return;
        }

        if (!isStartPagesTests && !isNewDocumentsTests && !isBackLinksTests) {
            return;
        }

        final Properties mailProperties = (Properties) context.getAttribute("mailProperties");
        String systemName = context.getCurrentXmlTest().getName();

        String typeCheck = "";
        if (isStartPagesTests) {
            typeCheck = "Проверка стартовых страниц.";
        }
        if (isNewDocumentsTests) {
            typeCheck = "Проверка опубликованных документов.";
        }
        if (isBackLinksTests) {
            typeCheck = "Проверка бэклинков.";
        }

        if (result.get().toString().isEmpty()) {
            sendEmail(mailProperties, isStartPagesTests ? getTextForSuccessResultForStartPages() : getTextForSuccessResult(), systemName, systemName + ". Контент ОК. " + typeCheck);
        } else {
            sendEmail(mailProperties, result.get().toString() + (isStartPagesTests ? getTextForSuccessResultForStartPages() : getTextForSuccessResult()), systemName, systemName + ". Отсутствует контент. " + typeCheck);
        }
    }

    private void sendEmail(final Properties mailProperties, String text, String systemName, String subject) {

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
        } else if (systemName.contains("EX: Кадри")){
            to = mailProperties.getProperty("mail.to.expertus_k");
        } else if (systemName.contains("EX: Головбух")){
            to = mailProperties.getProperty("mail.to.expertus_gl");
        } else if (systemName.contains("ACT: Образование")){
            to = mailProperties.getProperty("mail.to.actualis_edu");
        } else if (systemName.contains("ACT: Кадровое дело")){
            to = mailProperties.getProperty("mail.to.actualis_k");
        } else if (systemName.contains("ACT: Госзакупки")){
            to = mailProperties.getProperty("mail.to.actualis_gz");
        }

        if (isBackLinksTests) {
            to = to + "," + mailProperties.getProperty("mail.to.backlinks");
        }

        String[] recipientArr = to.split(",");

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
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(mbp1);
            simpleMessage.setText(text);
            simpleMessage.setContent(mp);
            Transport.send(simpleMessage);
        } catch (MessagingException e) {
            logger.error("MessagingException occurs", e);
        }
    }

    private String getTestName(ITestResult testResult) {
        return TestMethodUtils.getTestNameNotUI(testResult);
    }

    private boolean isTestVerifyStartPages(ITestNGMethod method) {
        for (String group : method.getGroups()) {
            if (group.contains(startpages)) {
                return true;
            }
        }
        return false;
    }

    private boolean isTestVerifyNewDocuments(ITestNGMethod method) {
        for (String group : method.getGroups()) {
            if (group.contains(newDocuments)) {
                return true;
            }
        }
        return false;
    }

    private boolean isTestVerifyBackLinks(ITestNGMethod method) {
        for (String group : method.getGroups()) {
            if (group.contains(backlinks)) {
                return true;
            }
        }
        return false;
    }

    private String getTextForSuccessResult() {
        StringBuilder result = new StringBuilder();
        int numberOfAllDocuments = 0;

        for (Map.Entry<String, List<String>> entry : checkedDocsForSystem.get().entrySet()) {
            String systemName = entry.getKey();
            int count = entry.getValue().size();
            numberOfAllDocuments += count;

            result
                    .append(N_TAG)
                    .append(systemName)
                    .append(" - ")
                    .append(count)
                    .append(N_TAG)
                    .append(LINE)
                    .append(N_TAG);
        }

        return N_TAG + "Всего проверено - " + numberOfAllDocuments + N_TAG + LINE + N_TAG + result.toString();
    }

    private String getTextForSuccessResultForStartPages() {
        StringBuilder result = new StringBuilder();
        int numberOfAllDocuments = 0;

        for (Map.Entry<String, Map<String, List<String>>> entry : checkedDocsMapForSystem.get().entrySet()) {
            String systemName = entry.getKey();
            int count = 0;
            for (Map.Entry<String, List<String>> docsForSection : entry.getValue().entrySet()) {
                count += docsForSection.getValue().size();
            }
            numberOfAllDocuments += count;
            result
                    .append(N_TAG)
                    .append(systemName)
                    .append(" - ")
                    .append(count)
                    .append(" : ")
                    .append(N_TAG);

            for (Map.Entry<String, List<String>> docsForSection : entry.getValue().entrySet()) {
                result
                        .append(docsForSection.getKey())
                        .append(" - ")
                        .append(docsForSection.getValue().size())
                        .append(N_TAG);
            }

            result
                    .append(LINE)
                    .append(N_TAG);
        }

        return N_TAG + "Всего проверено - " + numberOfAllDocuments + N_TAG + LINE + N_TAG + result.toString();
    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        if (!isTestVerifyStartPages(testResult.getMethod()) && !isTestVerifyNewDocuments(testResult.getMethod()) && !isTestVerifyBackLinks(testResult.getMethod())) {
            return;
        }

        isStartPagesTests = isTestVerifyStartPages(testResult.getMethod());
        isNewDocumentsTests = isTestVerifyNewDocuments(testResult.getMethod());
        isBackLinksTests = isTestVerifyBackLinks(testResult.getMethod());

        Pair<SystemPubs, List<String>> pair = SeleniumHolder.getDocUrls().get();
        Pair<SystemPubs, Map<String, List<String>>> pairMap = SeleniumHolder.getDocUrlsMap().get();
        checkedDocsForSystem.get().put(pair.getLeft().getDescription(), pair.getRight());

        String testName = getTestName(testResult);

        List<String> errorMessageListForTest = ServicesPostponedErrorMessageHolder.getErrorMessageListForTest(testName);
        for (String message : errorMessageListForTest) {
            result.get()
                    .append(N_TAG)
                    .append(message.replaceAll("<.*?>", "").replaceAll("expected:", "").replaceAll("but", "").replaceAll("was:", "").replaceAll("expected \\[false\\]  found \\[true\\]", "").trim())
                    .append(N_TAG)
                    .append(LINE)
                    .append(N_TAG);
        }

        if (isTestVerifyStartPages(testResult.getMethod())) {
            checkedDocsMapForSystem.get().put(pairMap.getLeft().getDescription(), pairMap.getRight());
        }
    }

    @Override
    public void onTestSuccess(ITestResult testResult) {
        if (!isTestVerifyStartPages(testResult.getMethod()) && !isTestVerifyNewDocuments(testResult.getMethod()) && !isTestVerifyBackLinks(testResult.getMethod())) {
            return;
        }

        isStartPagesTests = isTestVerifyStartPages(testResult.getMethod());
        isNewDocumentsTests = isTestVerifyNewDocuments(testResult.getMethod());
        isBackLinksTests = isTestVerifyBackLinks(testResult.getMethod());

        Pair<SystemPubs, List<String>> pair = SeleniumHolder.getDocUrls().get();
        Pair<SystemPubs, Map<String, List<String>>> pairMap = SeleniumHolder.getDocUrlsMap().get();
        checkedDocsForSystem.get().put(pair.getLeft().getDescription(), pair.getRight());
        if (isTestVerifyStartPages(testResult.getMethod())) {
            checkedDocsMapForSystem.get().put(pairMap.getLeft().getDescription(), pairMap.getRight());
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
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
