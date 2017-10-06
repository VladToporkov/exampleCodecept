package com.actionmedia.base;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.autotest.event.postpone.failure.PostponedFailureEvent;
import com.actionmedia.autotest.event.postpone.failure.StorePostponeFailureSubscriber;
import com.actionmedia.autotest.listeners.ReportTestInvocationListener;
import com.actionmedia.autotest.listeners.ServicesPostponedFailureListener;
import com.actionmedia.autotest.selenium.SeleniumHolder;
import com.actionmedia.autotest.selenium.context.ErrorSender;
import com.actionmedia.autotest.selenium.context.Login;
import com.actionmedia.autotest.spring.SeleniumSettings;
import com.actionmedia.autotest.utils.Pair;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.components.PublicationDocument;
import com.actionmedia.util.DBUtils;
import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.UnknownHostException;
import java.util.*;

/**
 * User: n.tyukavkin
 * Date: 23.12.13
 * Time: 17:04
 */
@ContextConfiguration(locations = {
        "classpath*:/META-INF/spring/context-selenium.xml",
        "classpath*:/META-INF/spring/testlink.xml",
        "classpath*:/META-INF/spring/mail.xml"
})
@Listeners({
        ReportTestInvocationListener.class,
        ServicesPostponedFailureListener.class
})
public class AbstractContentTest extends AbstractTestNGSpringContextTests implements ErrorSender {

    @Autowired
    private PostponedFailureEvent postponeFailureEvent;

    @Autowired
    private SeleniumSettings settings;

    @Qualifier("mailProperties")
    @Autowired
    private Properties mailProperties;

    private ThreadLocal<Map<String, String>> cookies = new ThreadLocal<Map<String, String>>() {
        @Override
        protected Map<String, String> initialValue() {
            return new HashMap<String, String>();
        }
    };

    private static final ThreadLocal<Login> loginHolder = new ThreadLocal<Login>();

    @BeforeMethod(alwaysRun = true)
    public final void beforeMethod(final Method test, final Object[] params, final ITestContext context) {
        postponeFailureEvent.subscribe(new StorePostponeFailureSubscriber(test, params, context));
    }

    @BeforeMethod(alwaysRun = true)
    public final void setMailProperties(final ITestContext context) {
        context.setAttribute("mailProperties", mailProperties);
    }

    @BeforeMethod(alwaysRun = true)
    public final void doBeforeMethods(final Method test) {
        getLoginData(test);
    }

    @AfterMethod(alwaysRun = true)
    public final void afterMethod() {
        postponeFailureEvent.unsubscribeAll();
    }

    private void getLoginData(Method test) {
        loginHolder.set(new Login(getSettings()));
        checkLoginAsAnnotations(test);
        checkLoginToAnnotations(test);
    }

    private synchronized void checkLoginAsAnnotations(final Method method) {
        final LoginAs loginAs = method.getAnnotation(LoginAs.class);
        if (loginAs != null) {
            updateLoginAsInfo(loginAs.key());
        }
    }

    protected synchronized void updateLoginAsInfo(String loginAs) {
        loginHolder.get().setLogin(getLoginProperties(loginAs));
    }

    protected synchronized void updateLoginToInfo(String loginTo) {
        if (getSettings().isRunUss() && loginTo.equals("vip")) {
            loginTo = "doc";
        } else if (!getSettings().isRunUss() && loginTo.equals("doc")) {
            loginTo = "vip";
        }
        String url = getSectionFromProperties(loginTo) == null ? "" : getSectionFromProperties(loginTo);
        loginHolder.get().setUrl(url);
    }

    private String getLoginProperties(String key) {
        return getSettings().getProperty(key);
    }

    private synchronized void checkLoginToAnnotations(final Method method) {
        String url = "";
        final Version version = method.getAnnotation(Version.class);
        if (version != null) {
            url = getSectionFromProperties(version.section());
        }
        loginHolder.get().setUrl(url);
    }

    private String getSectionFromProperties(String section) {
        return getSettings().getProperty(section);
    }

    protected synchronized void updateSystemInfo(SystemPubs system) {
        setSystemToSettings(system);
        loginHolder.set(new Login(getSettings()));
    }

    public SeleniumSettings getSettings() {
        return settings;
    }

    public String getCurrentUrl() {
        return loginHolder.get().getUrl();
    }

    public void waitFewSecond(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            logger.error(e);
        }
    }

    protected void assertTrue(boolean condition, String errorMessage) {
        try {
            Assert.assertTrue(condition, errorMessage);
        } catch (AssertionError e) {
            logger.error("AssertionError occurs", e);
            fail(e.getMessage());
        }
    }

    protected void assertFalse(boolean condition, String errorMessage) {
        try {
            Assert.assertFalse(condition, errorMessage);
        } catch (AssertionError e) {
            logger.error("AssertionError occurs", e);
            fail(e.getMessage());
        }
    }

    @Override
    public void setPostponedTestFail(final String message) {
        postponeFailureEvent.fire(message);
    }

    protected void postponedAssertNotNull(Object object, String errorMessage) {
        try {
            Assert.assertNotNull(object, errorMessage);
        } catch (AssertionError e) {
            logger.info("AssertionError occurs");
            setPostponedTestFail(e.getMessage());
        }
    }

    protected void postponedAssertNull(Object object, String errorMessage) {
        try {
            Assert.assertNull(object, (errorMessage));
        } catch (AssertionError e) {
            logger.info("AssertionError occurs");
            setPostponedTestFail(e.getMessage());
        }
    }

    protected void postponedAssertTrue(boolean condition, String errorMessage) {
        try {
            Assert.assertTrue(condition, errorMessage);
        } catch (AssertionError e) {
            logger.info("AssertionError occurs");
            setPostponedTestFail(e.getMessage());
        }
    }

    protected void postponedAssertFalse(boolean condition, String errorMessage) {
        try {
            Assert.assertFalse(condition, errorMessage);
        } catch (AssertionError e) {
            logger.info("AssertionError occurs");
            setPostponedTestFail(e.getMessage());
        }
    }

    protected void postponedAssertEquals(Object actual, Object expected, String errorMessage) {
        try {
            Assert.assertEquals(actual, expected, errorMessage);
        } catch (AssertionError e) {
            logger.info("AssertionError occurs");
            setPostponedTestFail(e.getMessage());
        }
    }

    @Step("{0}")
    protected final void fail(final String errorMessage) {
        report(errorMessage);
        throw new AssertionError(errorMessage);
    }

    @Step("{0}")
    protected final void fail(final String errorMessage, Throwable cause) {
        report(errorMessage + cause.getMessage());
        throw new Error(errorMessage + cause.getMessage(), cause);
    }

    @Step("{0}")
    public void report(final String message) {
        Reporter.log(message);
    }

    private List<String> checkDocUrlList = new ArrayList<String>();
    private List<String> checkDocUrlForSectionList = new ArrayList<String>();
    private Map<String, List<String>> checkDocUrlMap = new HashMap<String, List<String>>();

    public void login() {
        try {
            Connection.Response response = loginBySendPost(loginHolder.get().getUrl() + "/site/customer/login/");

            Elements isSuccess = response.parse().getElementsByAttributeValue("data-name", "isSuccess");

            if (isSuccess.isEmpty()) {
                waitFewSecond(1000);
                response = loginBySendPost(loginHolder.get().getUrl().replace("//", "//www.") + "/site/customer/login/");
                isSuccess = response.parse().getElementsByAttributeValue("data-name", "isSuccess");
                System.out.println("isSuccess is empty, again - " + isSuccess);
            }

            if (!isSuccess.isEmpty() && isSuccess.get(0).text().equals("false")) {
                waitFewSecond(1000);
                response = loginBySendPost(loginHolder.get().getUrl() + "/site/customer/login/");
                isSuccess = response.parse().getElementsByAttributeValue("data-name", "isSuccess");
                System.out.println("isSuccess is false, again - " + isSuccess);
            }

            cookies.set(response.cookies());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    private void logout() {
        try {
            Jsoup
                    .connect(loginHolder.get().getUrl() + "/site/customer/logout/")
                    .ignoreHttpErrors(true)
                    .timeout(0)
                    .cookies(cookies.get())
                    .method(Connection.Method.GET)
                    .execute();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    private Connection.Response loginBySendPost(String url) throws IOException {
        return Jsoup
                .connect(url)
                .ignoreHttpErrors(true)
                .timeout(0)
                .data("login", loginHolder.get().getUser())
                .data("password", loginHolder.get().getPassword())
                .data("isremember", "no")
                .method(Connection.Method.POST)
                .execute();
    }

    public void checkDocumentFromStartPages(SystemPubs systemPub) {
        login();
        String baseUrl = getCurrentUrl().split("#/")[0];
        Section[] sectionsArr = getSectionsForSystem(systemPub);
        if (sectionsArr == null || sectionsArr.length == 0) {
            setPostponedTestFail("Не найден список разделов для текущей системы.");
            return;
        }

        for (Section section : sectionsArr) {
            checkDocUrlForSectionList.clear();
            String pageUrl = baseUrl + section.getUrl();
            try {
                report("Проверяются документы для страницы " + pageUrl);
                logger.info("Проверяются документы для страницы " + pageUrl);
                Document page = getHtmlDocumentByUrl(pageUrl);

                Elements elements = new Elements();
                String[] locatorArr = new String[]{"#/document/", "#/documentvideo/", "#/documentmag/", "#/book/", "#/wizard/", "#/calculator/", "#/report/", "#/service/"};
                for (String locator : locatorArr) {
                    elements.addAll(page.getElementsByAttributeValueContaining("href", locator));
                }

                Elements emptyUrls = page.getElementsByAttributeValueContaining("href", "#/document///");
                if (!emptyUrls.isEmpty()) {
                    for (Element emptyUrlElement : emptyUrls) {
                        String idAttr = emptyUrlElement.attr("id");
                        String classAttr = emptyUrlElement.attr("class");

                        if (idAttr != null && !idAttr.isEmpty()) {
                            setPostponedTestFail("Раздел - " + section.getName() + ". Пустой урл документа для элемента с id = " + idAttr);
                        } else if (classAttr != null && !classAttr.isEmpty()) {
                            setPostponedTestFail("Раздел - " + section.getName() + ". Пустой урл документа для элемента с className = " + classAttr);
                        } else {
                            setPostponedTestFail("Раздел - " + section.getName() + ". Пустой урл документа " + emptyUrlElement.attr("href"));
                        }
                    }
                }

                checkDocumentUrls(baseUrl, elements, section.getName());
                logger.info("Found - " + elements.size());
            } catch (HttpStatusException e) {
                if (e.getStatusCode() == 500 || e.getStatusCode() == 404) {
                    setPostponedTestFail("Incorrect Http Status code " + e.getStatusCode() + " : <a href=" + pageUrl + ">" + pageUrl + "</a>\n");
                }
                logger.error("HttpStatusException occurs. ", e);
            } catch (IOException e) {
                logger.error("IOException occurs.", e);
            }
            checkDocUrlMap.put(section.getName(), new ArrayList<String>(checkDocUrlForSectionList));
        }

        Pair<SystemPubs, List<String>> pair = new Pair<SystemPubs, List<String>>(systemPub, checkDocUrlList);
        Pair<SystemPubs, Map<String, List<String>>> pairMap = new Pair<SystemPubs, Map<String, List<String>>>(systemPub, checkDocUrlMap);
        SeleniumHolder.setDocUrls(pair);
        SeleniumHolder.setDocUrlsMap(pairMap);
        logout();
    }

    public void checkAllNewDocumentsByPubId(SystemPubs systemPub) {
        login();
        List<PublicationDocument> publicationDocumentList = DBUtils.getNewPublicationDocument(systemPub.getPubId(), getSettings());
        List<String> checkedDocs = new ArrayList<String>();
        for (PublicationDocument publicationDocument : publicationDocumentList) {
            String checkDoc = "/" + publicationDocument.getModuleId() + "/" + publicationDocument.getDocumentId() + "/";
            if (checkedDocs.contains(checkDoc)) {
                continue;
            }

            int modId = publicationDocument.getModuleId();

            if (modId == 41 ||
                    modId == 44 ||
                    modId == 45 ||
                    modId == 46 ||
                    modId == 47 ||
                    modId == 196 ||
                    modId == 194) {
                continue;
            }

            if (getSettings().isRunBss() && (
                    modId == 79 || modId == 88)) {
                continue;
            }

            if ((getSettings().isRunUss() ||
                    getSettings().isRunFss()) && (
                    modId == 194 ||
                            modId == 166 ||
                            modId == 167)) {
                continue;
            }

            int docId = publicationDocument.getDocumentId();
            String currentUrl = getCurrentUrl().split("#/")[0];
            String docUrl = correctUrl(modId, docId);
            String currentDocUrl = getDocUrl(docUrl, currentUrl);
            try {
                String correctUrl = currentUrl + "/#" + (modId == 145 ? "/documentvideo/" : "/document/") + modId + "/" + docId + "/";
                Document doc = getHtmlDocumentByUrl(currentDocUrl);
                checkDocUrlList.add(correctUrl);
                checkDocument(doc, correctUrl, "");
                if (modId == 99) {
                    checkReferencesInLawDocument(doc, correctUrl);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                logger.error("ArrayIndexOutOfBoundsException occurs. url - " + docUrl, e);
            } catch (HttpStatusException e) {
                if (e.getStatusCode() == 500 || e.getStatusCode() == 404) {
                    setPostponedTestFail("Incorrect Http Status code " + e.getStatusCode() + " : <a href=" + currentDocUrl + ">" + currentDocUrl + "</a>\n");
                }
                logger.error("HttpStatusException occurs. url - " + currentDocUrl);
            } catch (IOException e) {
                logger.error("IOException occurs.", e);
            }

            checkedDocs.add(checkDoc);
        }
        Pair<SystemPubs, List<String>> pair = new Pair<SystemPubs, List<String>>(systemPub, checkDocUrlList);
        SeleniumHolder.setDocUrls(pair);
        logout();
    }

    private void checkDocumentUrls(String baseUrl, Elements elements, String sectionName) throws IOException {
        for (Element element : elements) {
            String href = element.attr("href");
            String currentUrl = baseUrl + href.replace("//", "/");

            if (href.contains("//") || href.contains("#/report/new/")) {
                continue;
            }

            href = href.replace("/constanthighlight/", "/");

            String docUrl;
            try {
                docUrl = getDocUrl(href, baseUrl);
            } catch (ArrayIndexOutOfBoundsException e) {
                logger.error("ArrayIndexOutOfBoundsException occurs. href - '" + href + "', baseUrl - '" + baseUrl + "'", e);
                continue;
            }

            try {
                if (href.contains("mar")) {
                    docUrl = docUrl + "mar" + href.split("/mar")[1];
                }
                Document doc = getHtmlDocumentByUrl(docUrl);
                checkDocUrlList.add(currentUrl);
                checkDocUrlForSectionList.add(currentUrl);

                if (isEmptyDocument(doc)) {
                    System.out.println("Document is empty, url -  " + href);
                    waitFewSecond(5000);
                    doc = getHtmlDocumentByUrl(docUrl);
                }

                if (isEmptyDocument(doc)) {
                    System.out.println("Document is empty, url -  " + href);
                    waitFewSecond(5000);
                    doc = getHtmlDocumentByUrl(docUrl);
                }

                checkDocument(doc, currentUrl, sectionName);
            } catch (ArrayIndexOutOfBoundsException e) {
                logger.error("ArrayIndexOutOfBoundsException occurs. url - " + docUrl, e);
            } catch (HttpStatusException e) {
                if (e.getStatusCode() == 500 || e.getStatusCode() == 404) {
                    setPostponedTestFail("Incorrect Http Status code " + e.getStatusCode() + " : <a href=" + currentUrl + ">" + currentUrl + "</a>\n");
                }
                logger.error("HttpStatusException occurs. url - " + currentUrl, e);
            } catch (UnknownHostException e) {
                logger.error("UnknownHostException occurs. url - " + currentUrl, e);
            }
        }
    }

    private void checkReferencesInLawDocument(Document document, String parentDocUrl) {
        String baseUrl = getCurrentUrl().split("#/")[0];
        Elements elements = document.getElementsByClass("backlink");
        for (Element element : elements) {
            try {
                String phraseId = element.attr("data-phrase-id");
                String anchorAttribute = element.select("[data-phrase-id=" + phraseId + "]").attr("data-anchor");

                String anchor;
                if (anchorAttribute.isEmpty()) {
                    anchor = element.child(0).child(0).attr("data-anchor").split("/", 3)[2] + phraseId + "/";
                } else {
                    anchor = anchorAttribute.split("/", 3)[2].replace("bssphr", "");
                }

                String docUrl = baseUrl + "system/content/feature/backlinks/" + anchor;
                Document referencesDoc = getHtmlDocumentByUrl(docUrl);
                postponedAssertTrue(referencesDoc.hasText(), "Отсутствует текст в блокноте(шарики в правовой базе): <a href=" + docUrl + ">" + docUrl + "</a>\n" +
                        ", в документе: <a href=" + parentDocUrl + ">" + parentDocUrl + "</a>\n");

                Element comments = referencesDoc.getElementById("coments");
                Element content = referencesDoc.getElementById("cont");

                boolean isCommentsNotEmpty = comments.hasText();
                boolean isContentNotEmpty = content.hasText();

                postponedAssertTrue(isCommentsNotEmpty || isContentNotEmpty, "Отсутствует текст в блокноте(шарики в правовой базе): <a href=" + docUrl + ">" + docUrl + "</a>\n" +
                        ", в документе: <a href=" + parentDocUrl + ">" + parentDocUrl + "</a>\n");

                Elements links = referencesDoc.getElementsByTag("a");
                for (Element link : links) {
                    String href = link.attr("href");

                    if (href.isEmpty()) {
                        continue;
                    }

                    String referenceUrl;
                    try {
                        referenceUrl = getDocUrl(href, baseUrl);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        logger.error("ArrayIndexOutOfBoundsException occurs. href - '" + href + "', baseUrl - '" + baseUrl + "'", e);
                        continue;
                    }

                    Document doc = getHtmlDocumentByUrl(referenceUrl);
                    checkDocUrlList.add(referenceUrl);
                    checkDocument(doc, href, "");
                }
            } catch (IOException e) {
                logger.error("IOException occurs.", e);
            } catch (ArrayIndexOutOfBoundsException e) {
                logger.error("ArrayIndexOutOfBoundsException occurs. url - " + parentDocUrl, e);
            }
        }
    }

    private void checkDocument(Document doc, String correctDocUrl, String sectionName) {
        Element body = doc.getElementById("document-body");
        String text = body != null ? (body.text().length() > 100 ? body.text().substring(0, 100) : body.text()) : "";

        postponedAssertFalse(
                isEmptyDocument(doc),
                sectionName.isEmpty() ? "Документ не найден: <a href=" + correctDocUrl + ">" + correctDocUrl + "</a>\n"
                        : "Раздел - " + sectionName + ". Документ не найден: <a href=" + correctDocUrl + ">" + correctDocUrl + "</a>\n" +
                        " Текст: " + text);
    }

    private boolean isEmptyDocument(Document doc) {
        Element header = doc.getElementById("document-header");
        Element body = doc.getElementById("document-body");
        Element headerNotLogged = doc.getElementById("pagewf-header");
        Element wizardQuestions = doc.getElementById("wizards-questions");

        return isHeaderIsEmpty(header) ||
                isBodyIsEmpty(body) ||
                isHeaderIsEmpty(headerNotLogged) ||
                isBodyIsEmpty(wizardQuestions);
    }

    private String correctUrl(int moduleId, int documentId) {
        String currentUrl = getCurrentUrl();
        String context = "#/document/";
        if (moduleId == 145) {
            context = "#/documentvideo/";
        } else if (moduleId == 150) {
            context = "#/wizard/";
        } else if (moduleId == 192) {
            context = "#/documentmag/";
        }

        return currentUrl.split("#/")[0] + context + moduleId + "/" + documentId;
    }

    private String getDocUrl(String href, String baseUrl) {
        String docUrl = baseUrl + "/system/content/doc/";
        String module = href.split("#/")[1].split("/")[1].trim();
        docUrl = docUrl + module + "/";
        if (href.contains("video/")) {
            docUrl = docUrl.replace("doc/", "doc-video/");
            String id = href.split("#/")[1].split("/")[2].trim();
            docUrl = docUrl + id + "/";
        } else if (href.contains("wizard/")) {
            docUrl = docUrl.split("content/doc/")[0] + "service/hr-wizard/" + module + "/";
            String id = href.split("#/")[1].split("/")[2].trim();
            docUrl = docUrl + id + "/";
        } else if (href.contains("calculator/193/1")) {
            docUrl = baseUrl + "/system/content/calculator/benefitEmployeeLoan/?mod=193&id=1";
        } else if (href.contains("calculator/193/2")) {
            docUrl = baseUrl + "/system/content/calculator/taxDeclarationPenalty/?mod=193&id=2";
        } else if (href.contains("calculator/193/3")) {
            docUrl = baseUrl + "/system/content/calculator/taxPenalty/?mod=193&id=3";
        } else if (href.contains("calculator/193/4")) {
            docUrl = baseUrl + "/system/content/calculator/vehicletaxes/?mod=193&id=4";
        } else if (href.contains("service/finan/")) {
            docUrl = baseUrl + "/site/finan/?period=5";
        } else if (href.contains("service/finbudget/")) {
            docUrl = baseUrl + "/site/finbudget/?period=5";
        } else if (href.contains("report/")) {
            docUrl = baseUrl + "/site/finan/report/data/" + href.split("report/")[1] + "/";
        } else if (href.contains("service/fd-school/")) {
            docUrl = baseUrl + "/site/fd-school/?period=5";
        } else {
            String id = href.split("#/")[1].split("/")[2].trim();
            docUrl = docUrl + id + "/";
        }
        return docUrl;
    }

    public void checkPublicationBlockInDocuments() {
        List<com.actionmedia.components.Document> documentList = getRandomElementsInList(DBUtils.getDocumentList(), 300);
        assertFalse(documentList.isEmpty(), "Список документов пуст.");
        String currentUrl = getCurrentUrl().split("/#")[0];
        for (com.actionmedia.components.Document document : documentList) {
            String correctDocUrl = currentUrl + "/#/document/" + document.getModuleId() + "/" + document.getDocumentId();
            String docUrl = currentUrl + "/system/content/doc/" + document.getModuleId() + "/" + document.getDocumentId() + "/infobar-card/";
            try {
                Document page = getHtmlDocumentByUrl(docUrl);
                if (isDocumentNotFounded(page.text())) {
                    setPostponedTestFail("Документ не найден - " + correctDocUrl);
                    continue;
                }
                Element infoCard = page.getElementById("infobar-card");
                Elements pubBlocks = infoCard.getElementsContainingOwnText("Публикации");
                for (Element pubBlock : pubBlocks) {
                    String pubBlockText = pubBlock.parent().text().toLowerCase();
                    postponedAssertTrue(pubBlockText.contains("рассылка официального органа") ||
                            !pubBlockText.contains("документ опубликован не был") ||
                            !pubBlockText.contains("официально опубликован не был"), "Блок 'Публикации' присутсвует в блоке 'Справка' для документа <a href=" + correctDocUrl + ">" + correctDocUrl + "</a>");
                }
            } catch (IOException e) {
                setPostponedTestFail("Ошибка при открытии документа - " + correctDocUrl);
            }
        }
        List<com.actionmedia.components.Document> randomElementsInList = getRandomElementsInList(documentList, 20);
        for (com.actionmedia.components.Document document : randomElementsInList) {
            String correctDocUrl = currentUrl + "/#/document/" + document.getModuleId() + "/" + document.getDocumentId();
            report("Пример проверенного документа: <a href=" + correctDocUrl + ">" + correctDocUrl + "</a>\n");
        }
    }

    private Document getHtmlDocumentByUrl(String pageUrl) throws IOException {
        return Jsoup.connect(pageUrl)
                .cookies(cookies.get())
                .timeout(600000)
                .ignoreContentType(true)
                .ignoreHttpErrors(true)
                .get();
    }

    private boolean isHeaderIsEmpty(Element header) {
        if (header != null) {
            String headerText = getAllText(header);
            return isDocumentNotFounded(headerText);
        } else {
            return false;
        }
    }

    private boolean isBodyIsEmpty(Element body) {
        if (body != null) {
            String bodyText = getAllText(body);
            return (bodyText.isEmpty() && body.getElementsByTag("img").isEmpty()) || isDocumentNotFounded(bodyText);
        } else {
            return false;
        }
    }

    private String getAllText(Element element) {
        String allText = element.text();
        for (Element child : element.children()) {
            allText = allText + child.text();
        }
        return allText;
    }

    private boolean isDocumentNotFounded(String docText) {
        return docText.contains("Документ не найден") ||
                docText.contains("Документ не знайдений") ||
                docText.contains("Ссылка на документ не работает") ||
                ((docText.contains("Техническая ошибка") && !docText.contains("Техническая ошибка и") &&
                        !docText.contains("Техническая ошибка в") &&
                        !docText.contains(". Техническая ошибка") &&
                        docText.length() < 200)) ||
                docText.contains("Мы будем благодарны, если Вы сообщите об ошибке по адресу") ||
                docText.contains("Мы будем благодарны, если Вы сообщите нам о необходимости дополнить базу данных этим документом") ||
                docText.contains("Ми будемо вдячні, якщо Ви повідомите нам про необхідність доповнити базу даних цим документом") ||
                docText.contains("Сервис временно не работает");
    }

    private <T> List<T> getRandomElementsInList(final List<T> sourceList, final int itemNumberToSelect) {
        final ArrayList<T> resultArray = new ArrayList<T>(sourceList.size());
        resultArray.addAll(sourceList);
        Collections.shuffle(resultArray);

        if (sourceList.size() <= itemNumberToSelect) {
            return resultArray;
        }

        return resultArray.subList(0, itemNumberToSelect);
    }

    private void setSystemToSettings(SystemPubs system) {
        getSettings().setRunOss(true);
        getSettings().setSystemPubs(system);
    }

    private Section[] getSectionsForSystem(SystemPubs systemPubs) {
        Section[] sectionList = new Section[]{};
        switch (systemPubs) {
            case bss:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.magazines, Section.video, Section.newsAll};
                break;
            case bss_bu:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.magazines, Section.video, Section.newsAll};
                break;
            case bss_usn:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.magazines, Section.video, Section.newsAll};
                break;
            case bss_vip:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.magazines, Section.video, Section.services, Section.newsAll};
                break;
            case kss:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.magazines, Section.video, Section.wizards, Section.newsAll};
                break;
            case kss_bu:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.magazines, Section.video, Section.wizards, Section.newsAll};
                break;
            case kss_vip:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.magazines, Section.video, Section.wizards, Section.services, Section.newsAll};
                break;
            case uss:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.lawPractice, Section.forms, Section.dictionary, Section.magazines, Section.video, Section.wizards, Section.newsAll};
                break;
            case uss_bu:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.lawPractice, Section.forms, Section.dictionary, Section.magazines, Section.video, Section.wizards, Section.newsAll};
                break;
            case uss_vip:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.lawPractice, Section.forms, Section.dictionary, Section.magazines, Section.video, Section.wizards, Section.newsAll};
                break;
            case fss:
                sectionList = new Section[]{Section.solutionsFss, Section.formsFss, Section.lawBaseFss, Section.booksFss, Section.videoFss, Section.dictionaryFss, Section.servicesGF};
                break;
            case gf:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.magazines, Section.video, Section.newsAll, Section.servicesGF};
                break;
            case gf_vip:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.magazines, Section.video, Section.newsAll, Section.servicesGF};
                break;
            case ehs:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.magazines, Section.newsAll, Section.wizards};
                break;
            case ehs_mini:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.newsAll};
                break;
            case ehs_bu:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.magazines, Section.newsAll, Section.wizards};
                break;
            case ehs_vip:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.magazines, Section.newsAll, Section.wizards};
                break;
            case edu:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.video, Section.newsAll, Section.wizards};
                break;
            case edu_mini:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.newsAll};
                break;
            case edu_vip:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.magazines, Section.video, Section.newsAll, Section.wizards};
                break;
            case elpu:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.newsAll, Section.servicesGF};
                break;
            case elpu_vip:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.magazines, Section.video, Section.newsAll, Section.servicesGF};
                break;
            case klpu:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.newsAll, Section.servicesGF};
                break;
            case klpu_vip:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.magazines, Section.video, Section.newsAll, Section.servicesGF};
                break;
            case cult:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.newsAll};
                break;
            case cult_vip:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.magazines, Section.video, Section.newsAll, Section.servicesGF};
                break;
            case go:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.video, Section.newsAll, Section.wizards};
                break;
            case go_mini:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.newsAll, Section.wizards};
                break;
            case go_vip:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.magazines, Section.video, Section.newsAll, Section.wizards};
                break;
            case umd:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.video, Section.newsAll, Section.servicesGF};
                break;
            case umd_mini:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.video, Section.newsAll, Section.servicesGF};
                break;
            case umd_vip:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.magazines, Section.video, Section.newsAll, Section.servicesGF};
                break;
            case expertus_k:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.magazines, Section.newsAll};
                break;
            case expertus_k_vip:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.magazines, Section.newsAll};
                break;
            case expertus_gl:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.magazines, Section.newsAll};
                break;
            case expertus_gl_vip:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.magazines, Section.newsAll};
                break;
            case actualis_edu:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.video, Section.newsAll};
                break;
            case actualis_edu_mini:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.video, Section.newsAll};
                break;
            case actualis_edu_vip:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.video, Section.newsAll};
                break;
            case actualis_k:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.newsAll};
                break;
            case actualis_k_mini:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.newsAll};
                break;
            case actualis_k_vip:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.video, Section.newsAll};
                break;
            case actualis_gz:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.newsAll};
                break;
            case actualis_gz_zak:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.newsAll};
                break;
            case actualis_gz_vip:
                sectionList = new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.video, Section.newsAll};
                break;
        }
        return sectionList;
    }

    private enum Section {
        recomend("/system/content/tab/1/", "Рекомендации/Ответы"),
        lawBase("/system/content/tab-law/3/", "Правовая база"),
        lawPractice("/system/content/tab/13/", "Судебная практика"),
        forms("/system/content/tab-forms/7/", "Формы"),
        dictionary("/system/content/tab-handbook/2/", "Справочники"),
        magazines("/system/content/tab-books/5/", "Журналы"),
        video("/system/content/tab-video/8/", "Видео"),
        services("/system/content/tab-services/6/", "Сервисы"),
        servicesGF("/system/content/tab-services/9/", "Сервисы"),
        wizards("/system/content/tab-wizards/9/", "Мастера"),
        newsAll("/system/content/news/?period=10", "Газета"),
        solutionsFss("/system/content/tab/1/", "Решения"),
        formsFss("/system/content/tab-forms/7/", "Положения и регламенты"),
        lawBaseFss("/system/content/tab-law/3/", "Правовая база"),
        booksFss("/system/content/tab-books/5/", "Библиотека"),
        videoFss("/system/content/tab-video/8/", "Видео"),
        dictionaryFss("/system/content/tab-handbook/2/", "Справочник"),
        servicesFss("/system/content/tab-services/6/", "Сервисы");

        private String url;
        private String name;

        Section(String url, String name) {
            this.url = url;
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public String getName() {
            return name;
        }
    }
}
