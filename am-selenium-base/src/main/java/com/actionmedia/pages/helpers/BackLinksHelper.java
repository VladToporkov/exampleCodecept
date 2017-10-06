package com.actionmedia.pages.helpers;

import com.actionmedia.autotest.selenium.SeleniumHolder;
import com.actionmedia.autotest.utils.Pair;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.BasePage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

/**
 * User: n.tyukavkin
 * Date: 28.04.2015
 * Time: 00:02
 */
@Component
public class BackLinksHelper extends BasePage<CheckDocumentHelper> {

    private Map<String, String> cookies = new HashMap<String, String>();

    public void checkBackLinks(SystemPubs systemPub) {
        List<String> checkDocUrlList = new ArrayList<String>();
        String baseUrl = getCurrentUrl().split("#/")[0];
        WebElement recomendDoc;
        if (getSettings().isRunFss()) {
            recomendDoc = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget__title a"));
        } else {
            recomendDoc = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget__answer a"));
        }

        String href = recomendDoc.getAttribute("href");
        String docUrl = baseUrl + "system/content/doc/";
        String module = href.split("#/")[1].split("/")[1].trim();
        String id = href.split("#/")[1].split("/")[2].trim();
        docUrl = docUrl + module + "/" + id + "/";
        String correctDocUrl = baseUrl + "#/document/" + module + "/" + id + "/";

        try {
            Document document = getHtmlDocumentByUrl(docUrl);
            Elements npdDocList = document.select(".npd");
            for (Element npd : npdDocList) {
                String npdDocId = npd.attr("documentid");
                String npdDocModuleId = npd.attr("moduleid");
                String npdAnchorId = npd.attr("anchor");
                String correctNpdDocUrl = baseUrl + "#/document/" + npdDocModuleId + "/" + npdDocId + "/" + npdAnchorId + "/";
                checkDocUrlList.add(correctNpdDocUrl);

                String npdUrl = baseUrl + "system/content/doc/" + npdDocModuleId + "/" + npdDocId + "/" + npdAnchorId + "/";
                Document npdDoc;
                try {
                    npdDoc = getHtmlDocumentByUrl(npdUrl);
                } catch (IOException e) {
                    continue;
                }
                Elements anchorElementList = npdDoc.getElementsByAttribute("data-anchor");

                boolean isBackLinkPresent = false;

                for (Element anchor : anchorElementList) {
                    String phraseId;
                    if (!anchor.parent().attr("data-phrase-id").isEmpty()) {
                        phraseId = anchor.parent().attr("data-phrase-id");
                    } else {
                        phraseId = anchor.parent().parent().attr("data-phrase-id");
                    }

                    String backLinkUrl = baseUrl + "/system/content/feature/backlinks-note/" + npdDocModuleId + "/" + npdDocId + "/" + phraseId + "/";
                    Document backLinkDoc;
                    try {
                        backLinkDoc = getHtmlDocumentByUrl(backLinkUrl);
                    } catch (IOException e) {
                        continue;
                    }

                    Elements allRecomendButton = backLinkDoc.select(".js_plural[data-group-name=recommendations]");
                    if (!allRecomendButton.isEmpty()) {
                        String dataCount = allRecomendButton.get(0).attr("data-count");
                        Document searchDoc;
                        try {
                            searchDoc = getHtmlDocumentByUrl(backLinkUrl + "?count=" + dataCount + "&pdid=1&position=1");
                        } catch (IOException e) {
                            continue;
                        }
                        Elements links = searchDoc.select("[href*=/document/" + module + "/" + id + "/]");
                        isBackLinkPresent = !links.isEmpty();
                    } else {
                        Elements links = backLinkDoc.select("[href*=/document/" + module + "/" + id + "/]");
                        isBackLinkPresent = !links.isEmpty();
                    }
                    if (isBackLinkPresent) {
                        break;
                    }
                }

                postponedAssertTrueWithoutScreen(isBackLinkPresent, "Для рекомендации " + correctDocUrl + " Отсутствует бэклинк в документе " + correctNpdDocUrl);
            }
        } catch (IOException e) {
            logger.error("IOException occurs.", e);
        } finally {
            Pair<SystemPubs, List<String>> pair = new Pair<SystemPubs, List<String>>(systemPub, checkDocUrlList);
            SeleniumHolder.setDocUrls(pair);
        }
    }

    private Document getHtmlDocumentByUrl(String pageUrl) throws IOException {
        return Jsoup.connect(pageUrl)
                .cookies(getCookies())
                .timeout(600000)
                .ignoreContentType(true)
                .ignoreHttpErrors(true)
                .get();
    }

    private Map<String, String> getCookies() {
        if (cookies.isEmpty()) {
            Iterator iterator = getDriver().manage().getCookies().iterator();
            while (iterator.hasNext()) {
                Cookie cookie = (Cookie) iterator.next();
                if (cookie.getDomain().startsWith(".")) {
                    cookies.put(cookie.getName(), cookie.getValue());
                }
            }
        }
        return cookies;
    }
}
