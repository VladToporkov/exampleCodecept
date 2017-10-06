package com.actionmedia.pages.helpers;

import com.actionmedia.autotest.selenium.SeleniumHolder;
import com.actionmedia.autotest.utils.Pair;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.BasePage;
import com.actionmedia.components.PublicationDocument;
import com.actionmedia.util.DBUtils;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.Cookie;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.*;

/**
 * User: n.tyukavkin
 * Date: 21.09.2014
 * Time: 17:02
 */
@Component
public class CheckDocumentHelper extends BasePage<CheckDocumentHelper> {

    private List<String> checkDocUrlList = new ArrayList<String>();
    private List<String> checkDocUrlForSectionList = new ArrayList<String>();
    private Map<String, List<String>> checkDocUrlMap = new HashMap<String, List<String>>();

    public void checkDocumentFromStartPages(SystemPubs systemPub) {
        String baseUrl = getCurrentUrl().split("#/")[0];
        Section[] sectionsArr = getSectionsForSystem();
        if (sectionsArr == null || sectionsArr.length == 0) {
            setPostponedTestFailWithoutScreen("Не найден список разделов для текущей системы.");
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
                            setPostponedTestFailWithoutScreen("Раздел - " + section.getName() + ". Пустой урл документа для элемента с id = " + idAttr);
                        } else if (classAttr != null && !classAttr.isEmpty()) {
                            setPostponedTestFailWithoutScreen("Раздел - " + section.getName() + ". Пустой урл документа для элемента с className = " + classAttr);
                        } else {
                            setPostponedTestFailWithoutScreen("Раздел - " + section.getName() + ". Пустой урл документа " + emptyUrlElement.attr("href"));
                        }
                    }
                }

                checkDocumentUrls(baseUrl, elements, section.getName());
                logger.info("Found - " + elements.size());
            } catch (HttpStatusException e) {
                if (e.getStatusCode() == 500 || e.getStatusCode() == 404) {
                    setPostponedTestFailWithoutScreen("Incorrect Http Status code " + e.getStatusCode() + " : <a href=" + pageUrl + ">" + pageUrl + "</a>\n");
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
    }

    public void checkAllNewDocumentsByPubId(SystemPubs systemPub) {
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
                String correctUrl = currentUrl + "#" + (modId == 145 ? "/documentvideo/" : "/document/") + modId + "/" + docId + "/";
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
                    setPostponedTestFailWithoutScreen("Incorrect Http Status code " + e.getStatusCode() + " : <a href=" + currentDocUrl + ">" + currentDocUrl + "</a>\n");
                }
                logger.error("HttpStatusException occurs. url - " + currentDocUrl);
            } catch (IOException e) {
                logger.error("IOException occurs.", e);
            }

            checkedDocs.add(checkDoc);
        }
        Pair<SystemPubs, List<String>> pair = new Pair<SystemPubs, List<String>>(systemPub, checkDocUrlList);
        SeleniumHolder.setDocUrls(pair);
    }

    private void checkDocumentUrls(String baseUrl, Elements elements, String sectionName) throws IOException {
        for (Element element : elements) {
            String href = element.attr("href");
            String currentUrl = baseUrl + href.replace("/#/", "#/");

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

                checkDocument(doc, currentUrl, sectionName);
            } catch (ArrayIndexOutOfBoundsException e) {
                logger.error("ArrayIndexOutOfBoundsException occurs. url - " + docUrl, e);
            } catch (HttpStatusException e) {
                if (e.getStatusCode() == 500 || e.getStatusCode() == 404) {
                    setPostponedTestFailWithoutScreen("Incorrect Http Status code " + e.getStatusCode() + " : <a href=" + currentUrl + ">" + currentUrl + "</a>\n");
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

                postponedAssertTrueWithoutScreen(isCommentsNotEmpty || isContentNotEmpty, "Отсутствует текст в блокноте(шарики в правовой базе): <a href=" + docUrl + ">" + docUrl + "</a>\n" +
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
        String text = body != null ? body.text() : "";

        postponedAssertFalseWithoutScreen(
                isEmptyDocument(doc),
                sectionName.isEmpty() ? "Документ не найден: <a href=" + correctDocUrl + ">" + correctDocUrl + "</a>\n"
                        : "Раздел - " + sectionName + ". Документ не найден: <a href=" + correctDocUrl + ">" + correctDocUrl + "</a>\n" +
                        " Текст: " + (text.length() > 100 ? text.substring(0, 100) : text));
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
        String docUrl = baseUrl + "system/content/doc/";
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
            docUrl = baseUrl + "system/content/calculator/benefitEmployeeLoan/?mod=193&id=1";
        } else if (href.contains("calculator/193/2")) {
            docUrl = baseUrl + "system/content/calculator/taxDeclarationPenalty/?mod=193&id=2";
        } else if (href.contains("calculator/193/3")) {
            docUrl = baseUrl + "system/content/calculator/taxPenalty/?mod=193&id=3";
        } else if (href.contains("calculator/193/4")) {
            docUrl = baseUrl + "system/content/calculator/vehicletaxes/?mod=193&id=4";
        } else if (href.contains("service/finan/")) {
            docUrl = baseUrl + "site/finan/?period=5";
        } else if (href.contains("service/finbudget/")) {
            docUrl = baseUrl + "site/finbudget/?period=5";
        } else if (href.contains("report/")) {
            docUrl = baseUrl + "site/finan/report/data/" + href.split("report/")[1] + "/";
        } else if (href.contains("service/fd-school/")) {
            docUrl = baseUrl + "site/fd-school/?period=5";
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
                    setPostponedTestFailWithoutScreen("Документ не найден - " + correctDocUrl);
                    continue;
                }
                Element infoCard = page.getElementById("infobar-card");
                Elements pubBlocks = infoCard.getElementsContainingOwnText("Публикации");
                for (Element pubBlock : pubBlocks) {
                    String pubBlockText = pubBlock.parent().text().toLowerCase();
                    postponedAssertTrueWithoutScreen(pubBlockText.contains("рассылка официального органа") ||
                            !pubBlockText.contains("документ опубликован не был") ||
                            !pubBlockText.contains("официально опубликован не был"), "Блок 'Публикации' присутсвует в блоке 'Справка' для документа <a href=" + correctDocUrl + ">" + correctDocUrl + "</a>");
                }
            } catch (IOException e) {
                setPostponedTestFailWithoutScreen("Ошибка при открытии документа - " + correctDocUrl);
            }
        }
        List<com.actionmedia.components.Document> randomElementsInList = getRandomElementsInList(documentList, 20);
        for (com.actionmedia.components.Document document : randomElementsInList) {
            String correctDocUrl = currentUrl + "/#/document/" + document.getModuleId() + "/" + document.getDocumentId();
            report("Пример проверенного документа: <a href=" + correctDocUrl + ">" + correctDocUrl + "</a>\n");
        }
        getDriver().manage().deleteAllCookies();
    }

    private Document getHtmlDocumentByUrl(String pageUrl) throws IOException {
        return Jsoup.connect(pageUrl)
                .cookies(getCookies())
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

    private Map<String, String> getCookies() {
        Map<String, String> cookies = new HashMap<String, String>();
        Iterator iterator = getDriver().manage().getCookies().iterator();
        while (iterator.hasNext()) {
            Cookie cookie = (Cookie) iterator.next();
            if (cookie.getDomain().startsWith(".")) {
                cookies.put(cookie.getName(), cookie.getValue());
            }
        }
        return cookies;
    }

    private boolean isDocumentNotFounded(String docText) {
        return docText.contains("Документ не найден") ||
                docText.contains("Ссылка на документ не работает") ||
                ((docText.contains("Техническая ошибка") && !docText.contains("Техническая ошибка и") &&
                        !docText.contains("Техническая ошибка в") &&
                        !docText.contains(". Техническая ошибка") &&
                        docText.length() < 200)) ||
                docText.contains("Мы будем благодарны, если Вы сообщите об ошибке по адресу") ||
                docText.contains("Мы будем благодарны, если Вы сообщите нам о необходимости дополнить базу данных этим документом") ||
                docText.contains("Сервис временно не работает");
    }

    private Section[] getSectionsForSystem() {
        if (getSettings().isRunBss()) {
            if (!getCurrentUrl().contains("vip.")) {
                return new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.magazines, Section.video, Section.newsAll};
            } else {
                return new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.magazines, Section.video, Section.services, Section.newsAll};
            }
        } else if (getSettings().isRunKss()) {
            if (!getCurrentUrl().contains("vip.")) {
                return new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.magazines, Section.video, Section.wizards, Section.newsAll};
            } else {
                return new Section[]{Section.recomend, Section.lawBase, Section.forms, Section.dictionary, Section.magazines, Section.video, Section.wizards, Section.services, Section.newsAll};
            }
        } else if (getSettings().isRunUss()) {
            return new Section[]{Section.recomend, Section.lawBase, Section.lawPractice, Section.forms, Section.dictionary, Section.magazines, Section.video, Section.wizards, Section.newsAll};
        } else if (getSettings().isRunFss()) {
            return new Section[]{Section.solutionsFss, Section.formsFss, Section.lawBaseFss, Section.booksFss, Section.videoFss, Section.dictionaryFss, Section.servicesFss};
        }

        return new Section[]{};
    }

    private enum Section {
        recomend("system/content/tab/1/", "Рекомендации/Ответы"),
        lawBase("system/content/tab-law/3/", "Правовая база"),
        lawPractice("system/content/tab/13/", "Судебная практика"),
        forms("system/content/tab-forms/7/", "Формы"),
        dictionary("system/content/tab-handbook/2/", "Справочники"),
        magazines("system/content/tab-books/5/", "Журналы"),
        video("system/content/tab-video/8/", "Видео"),
        services("system/content/tab-services/6/", "Сервисы"),
        wizards("system/content/tab-wizards/9/", "Мастера"),
        newsAll("system/content/news/?period=10", "Газета"),
        solutionsFss("system/content/tab/1/", "Решения"),
        formsFss("system/content/tab-forms/7/", "Положения и регламенты"),
        lawBaseFss("system/content/tab-law/3/", "Правовая база"),
        booksFss("system/content/tab-books/5/", "Библиотека"),
        videoFss("system/content/tab-video/8/", "Видео"),
        dictionaryFss("system/content/tab-handbook/2/", "Справочник"),
        servicesFss("system/content/tab-services/6/", "Сервисы");

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
