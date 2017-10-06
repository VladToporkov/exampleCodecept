package com.actionmedia.pages.helpers;

import com.actionmedia.base.BasePage;
import com.actionmedia.util.TestUtils;
import com.actionmedia.webservice.buhonline.Search;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel on 22/06/16.
 */
@Component
public class FormsPageHelper extends BasePage<FormsPageHelper> {

    private List<WebElement> newsBlocks;
    private List<WebElement> titlesNewsBlocks;

    private static String OLD_NEWS_BLOCKS_COUNT = "old.news.blocks.count";

    @Step("Проверяется, что отображается заголовок новостного блока:{0}")
    public void checkTitle(String title) {
        WebElement mainTitle = findElementByNoThrow(mainLeftElement, By.cssSelector("h1.main__title"));
        postponedAssertTrue(mainTitle != null && mainTitle.isDisplayed(), "Заголовок новостного блока не отображается");
        if (mainTitle != null) {
            postponedAssertEqualsText(mainTitle, title);
        }
    }

    @Step("Проверяется, что отображаются новостные блоки")
    public void checkNewsBlocksArePresent() {
        newsBlocks = getNewsBlocks();
        postponedAssertNotNull(newsBlocks, "Ни один новостной блок не найден.");
        if (newsBlocks != null) {
            postponedAssertTrue(newsBlocks.size() > 1, "Найден всего один новостной блок на странице");
            setParameter(OLD_NEWS_BLOCKS_COUNT, newsBlocks.size());
        }
    }

    @Step("Проверяется, что заголовки новостных блоков отображаются")
    public void checkNewsBlocksTitlesArePresent() {
        titlesNewsBlocks = getTitlesNewsBlocks();
        postponedAssertNotNull(titlesNewsBlocks, "Ни одного заголовка новостного блока не найдено в виде даты");
        if (titlesNewsBlocks != null) {
            if (newsBlocks != null) {   //check that titles count equals news blocks count, if the newsBlocks is null,
                                        // than just verify that the titles count more than one
                postponedAssertEquals(titlesNewsBlocks.size(), newsBlocks.size(),
                        "Количество Заголовоков новостей не равно количеству самих новостей!");
            } else {
                postponedAssertTrue(titlesNewsBlocks.size() > 1,
                        "Найден всего один заголовок на странице, т.е. показана всего одна новость");
            }
        }
    }

    @Step("Проверяется, что блоки с новостями отсортированы по порядку (по датам, от большей к меньшей)")
    public void checkNewsBlocksDatesSortedInDescendingOrder() {
        String todayInRussian = "сегодня";
        String yesterdayInRussian = "вчера";
        titlesNewsBlocks = getTitlesNewsBlocks();
        if (titlesNewsBlocks != null && titlesNewsBlocks.size() > 1) {
            List<String> preparedArray = new ArrayList<String>();   // the titlesNewsBlock may contain words вчера
                                                                    // or сегодня. Remove these words from the array;
            for (WebElement title : titlesNewsBlocks) {
                String strTitle = title.getText();
                if (strTitle.contains(todayInRussian) || strTitle.contains(yesterdayInRussian)) {
                    strTitle = strTitle.split(",[ ]*")[1].trim();
                }
                preparedArray.add(strTitle);
            }
            postponedAssertThat(preparedArray, TestUtils.sortedDatesStringsInDescendingOrderWithoutYear(),
                    "Элементы отсортированы в неправильном порядке");
        }
    }

    @Step("Проверяется, что отображаются новости с ссылками и описанием")
    public void checkNewsBlocksHaveTitleAndDescription() {
        newsBlocks = getNewsBlocks();
        if (newsBlocks != null) {
            for (WebElement newsBlock : newsBlocks) {
                WebElement link = findElementByNoThrow(newsBlock, By.cssSelector("a"));
                postponedAssertTrue(link != null && link.isDisplayed(), "Ссылка в новостном блоке:" +
                        newsBlock.getText() + " не отображается");
                WebElement description = findElementByNoThrow(newsBlock, By.xpath("//p[2]"));
                postponedAssertTrue(description != null && description.isDisplayed(), "Описание новостного блока:" +
                        description.getText() + " не отображается");
                if (link != null) {
                    postponedAssertTrue(link.getAttribute("href").contains("/document/"),
                            "В ссылке заголовка новости ссылка на документ не присутствует:" + link.getAttribute("href"));
                }
            }
        }
    }

    @Step("Проверяется, что первая новость имеет большую картинку")
    public void checkPictureForFirstNewsIsPresent() {
        WebElement picture = findElementByNoThrow(mainLeftElement,
                By.cssSelector("[class*='block']:nth-of-type(1) a.form-float"));
        postponedAssertTrue(picture != null && picture.isDisplayed(), "Первая новость не имеет большую картинку");
    }

    @Step("Проверяется, что новостные блоки подгружаются после скролла")
    public void checkNewsLoadedAfterScrollingDown() {
        List<WebElement> newsBlocksAfterScrolling = getNewsBlocks();
        postponedAssertTrue(newsBlocksAfterScrolling.size() > (Integer) getParameter(OLD_NEWS_BLOCKS_COUNT), "Блоки не подгрузились после скролла");
    }

    @Step("Нажимаем на случайную ссылку новостной ленты")
    public void clickOnRandomLinkFromNewsBlock() {
        WebElement randomLink = getRandomElementInList(getNewsBlocks());
        WebElement link = findElementByNoThrow(randomLink, By.cssSelector("a"));
        setParameter(SearchResultHelper.DOCUMENT_URL, link.getAttribute("href"));
        clickUseJS(link);
        waitForReloadingPage();
    }

    @Step("Проверяется, что отображается блок Популярное с заголовком")
    public void checkPopularBlockIsPresent() {
        WebElement popularBlock = findElementByNoThrow(sidebarElement, By.cssSelector(".news"));
        postponedAssertTrue(popularBlock != null && popularBlock.isDisplayed(), "Блок Популярное не отображен на странице");

        if (popularBlock != null) {
            WebElement title = findElementByNoThrow(popularBlock, By.cssSelector(".news__title"));
            if (getSettings().isRunFss()) {
                postponedAssertEqualsText(title, "Популярные");
            } else {
                postponedAssertEqualsText(title, "Популярное");
            }
        }
    }

    @Step("Проверяется, что отображаются ссылки на документы в блоке Популярное")
    public void checkPopularBlockDocumentLinksArePresent() {
        WebElement popularBlock = findElementByNoThrow(sidebarElement, By.cssSelector(".news"));

        if (popularBlock != null) {
            List<WebElement> documentLinks = findElementsByNoThrow(popularBlock,
                    By.cssSelector(".news__item a[href*='/document']"));
            postponedAssertTrue(documentLinks != null && documentLinks.size() > 0,
                    "В блоке Популярное не отображаются ссылки на документы");
        }
    }

    @Step("Проверяется, что напротив каждой ссылки отображается маркер")
    public void checkPopularBlockMarkersArePresent() {
        WebElement popularBlock = findElementByNoThrow(sidebarElement, By.cssSelector(".news"));

        if (popularBlock != null) {
            List<WebElement> documentLinks = findElementsByNoThrow(popularBlock,
                    By.cssSelector(".news__item a[href*='/document']"));
            if (documentLinks != null && documentLinks.size() > 0) {
                for (WebElement link : documentLinks) {
                    WebElement parentLink = getParentElement(link);
                    postponedAssertTrue(parentLink.getCssValue("background-image").contains("icon"),
                            "Маркер не отображается для ссылки в Блоке Популярное:" + link.getText());
                }
            }
        }
    }

    @Step("Проверяется, что напротив каждой ссылки отображается маркер")
    public void checkPopularBlockMarkersArePresentForFSS() {
        List<WebElement> documentLinks = findElementsByNoThrow(By.cssSelector("#sidebar .news__item a[href*='/document']"));
        if (documentLinks == null) {
            postponedAssertTrue(documentLinks == null, "Не найдены элементы ссылки");
        }

        for (int i = 0; i < documentLinks.size(); i++) {
            String backgroundImage = getPropertyValueElementBefore(
                    String.format("#sidebar .news__item:nth-of-type(%s)", String.valueOf(i+1)),
                    "background-image"
            );
            postponedAssertTrue(backgroundImage.contains("icon"),
                    "Маркер не отображается для ссылки в Блоке Популярное:" + documentLinks.get(i).getText());
        }
    }

    @Step("Нажать на случайную ссылку из блока популярное")
    public void clickOnRandomLinkFromPopularBlock() {
        WebElement popularBlock = findElementByNoThrow(sidebarElement, By.cssSelector(".news"));
        List<WebElement> documentLinks = findElementsByNoThrow(popularBlock,
                By.cssSelector(".news__item a[href*='/document']"));
        if (documentLinks != null && documentLinks.size() > 0) {
            WebElement randomDocument = getRandomElementInList(documentLinks);
            setParameter(SearchResultHelper.DOCUMENT_URL, randomDocument.getAttribute("href"));
            randomDocument.click();
            waitForReloadingPage();
        }
    }

    private List<WebElement> getNewsBlocks() {
        if (newsBlocks == null) {
            newsBlocks = findElementsByNoThrow(mainLeftElement, By.cssSelector("[class*='block']"));
        }
        return newsBlocks;
    }

    private List<WebElement> getTitlesNewsBlocks() {
        if (titlesNewsBlocks == null) {
            titlesNewsBlocks = findElementsByNoThrow(mainLeftElement, By.cssSelector(".main__title-section"));
        }
        return titlesNewsBlocks;
    }

}
