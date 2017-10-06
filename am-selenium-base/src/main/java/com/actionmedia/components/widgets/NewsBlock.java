package com.actionmedia.components.widgets;

import com.actionmedia.autotest.selenium.annotations.Wait;
import com.actionmedia.base.BasePage;
import com.actionmedia.pages.helpers.SearchResultHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

/**
 * Created by Pavel on 12/04/16.
 */
@Component
public class NewsBlock extends BasePage<BannerBlock> {

    private int linkid;

    @FindBy(css = ".news_viewtype_feed")
    @Wait
    @CacheLookup
    private WebElement newsBlock;

    @FindBy(css = ".news_viewtype_feed > .news__in:nth-of-type(1)")
    @Wait
    @CacheLookup
    private WebElement newsFirstBlock;

    @FindBy(css = ".news_viewtype_feed > .news__in:nth-of-type(2)")
    @Wait
    @CacheLookup
    private WebElement newsSecondBlock;

    @Step("Проверяется что Газета отображается")
    public void checkWidgetIsPresent() {
        postponedAssertTrue(newsFirstBlock.isEnabled() && newsFirstBlock.isDisplayed(), "Первая часть газеты не отображается");
        postponedAssertTrue(newsSecondBlock.isEnabled() && newsSecondBlock.isDisplayed(), "Вторая часть газеты не отображается");
    }

    @Step("Проверяется заголовок верхнего блока")
    public void checkFirstBlockTitleIsPresent() {
        WebElement firstBlockTitle = findElementByNoThrow(newsFirstBlock, By.tagName("h2"));
        String expectedString = "";
        if (getSettings().isRunBss()) {
            expectedString = "Новое у бухгалтеров";
        } else if (getSettings().isRunUss()) {
            expectedString = "Новое у юристов";
        } else if (getSettings().isRunUss()) {
            expectedString = "Новое у юристов";
        } else {
            expectedString = "Новое в работе";
        }
        postponedAssertEqualsText(firstBlockTitle, expectedString);
    }

    @Step("Проверяется, что отображаются новости (ссылки на документы)")
    public void checkNewsArePresent() {
        List<WebElement> news = findElementsByNoThrow(newsBlock, By.tagName("article"));
        postponedAssertFalse(news.isEmpty(), "Блок с ссылками пустой");
        postponedAssertTrue(getRandomElementInList(news).isDisplayed(), "Ссылки не отображаются");
    }

    @Step("Проверяется, что в верхнем блоке есть раздел Сегодня")
    public void checkTodayTitleIsPresent() {
        WebElement todayTitle = findElementByNoThrow(newsFirstBlock, By.tagName("h3"));
        postponedAssertEqualsText(todayTitle, "Сегодня");
    }

    @Step("Проверяется, что в нижнем блоке есть раздел На неделе")
    public void checkOnTheWeekTitleIsPresent() {
        WebElement todayTitle = findElementByNoThrow(newsSecondBlock, By.cssSelector("h3:nth-of-type(1)"));
        postponedAssertEqualsText(todayTitle, "На неделе");
    }

    @Step("Проверяется, что в нижнем блоке есть раздел За месяц")
    public void checkPerMonthTitleIsPresent() {
        WebElement todayTitle = findElementByNoThrow(newsSecondBlock, By.cssSelector("h3:nth-of-type(2)"));
        postponedAssertEqualsText(todayTitle, "За месяц");
    }

    @Step("Проверяется отображение документов Рекомендаций")
    public void checkRecomendationNewsView() {
        List<WebElement> recomendationNews = findElementsBy(newsBlock, By.xpath(".//*[(@data-mod-id='11') or (@data-mod-id='12')]"));
        if (recomendationNews.isEmpty()) {
            report("В новостях не найдены документы Рекомендаций, проверка не пройдена");
            return;
        }

        for (WebElement news : recomendationNews) {
            WebElement photo = findElementByNoThrow(news, By.cssSelector(".news__image"));
            postponedAssertTrue(photo != null && photo.isDisplayed(), "Фотография не отображается для новости:" + news.getText());
            WebElement newsType = findElementByNoThrow(news, By.cssSelector(".news__item-type"));
            postponedAssertTrue(newsType == null || !newsType.isDisplayed(), "Тип новости отображен для новости" + news.getText());
        }
    }

    @Step("Проверяется, что для новостей выводится тип документа справа от новости, фото автора не выводится")
    public void checkNewsWithTypeArePresent() {
        List<WebElement> news = findElementsByNoThrow(newsBlock, By.xpath(".//*[contains(@class,'news__item_type') or contains(@class,'js-news-item')][not(contains(@class,'news__item_type_recommendations'))]"));
        for (WebElement item : news) {
            WebElement photo = findElementByNoThrow(item, By.cssSelector(".news__image"));
            postponedAssertTrue(photo == null, "Фотография отображается для новости:" + item.getText());
            if (!item.getAttribute("class").contains("js-news-item")) {//without divs with colored background
                WebElement newsType = findElementByNoThrow(item, By.cssSelector(".news__item-type"));
                postponedAssertTrue(newsType == null, "Тип новости не отображен для новости" + item.getText());
            }
        }
    }

    @Step("Проверяется, что внизу верхнего и нижнего блока отображается ссылка Все новости")
    public void checkLinksAllNewsArePresent() {
        WebElement topAllNews = findElementByNoThrow(newsFirstBlock, By.cssSelector(".news__item_type_all-news a"));
        postponedAssertTrue(topAllNews != null && topAllNews.isDisplayed(), "Ссылка Все новости не отображается для верхнего блока");

        WebElement bottomAllNews = findElementByNoThrow(newsSecondBlock, By.cssSelector(".news__item_type_all-news a"));
        postponedAssertTrue(bottomAllNews != null && bottomAllNews.isDisplayed(), "Ссылка Все новости не отображается для нижнего блока");
    }

    @Step("Нажать на следующую ссылку в новостях")
    public boolean clickOnNewsLink() {
        List<WebElement> news = findElementsByNoThrow(newsBlock, By.xpath(".//*[contains(@class,'news__item_type')]/a"));
        if (news.size() <= linkid) {
            return false;
        }
        WebElement item = news.get(linkid++);
        report("Открывается новость:" + item.getText());
        setParameter(SearchResultHelper.DOCUMENT_URL, item.getAttribute("href"));
        executeScript("arguments[0].setAttribute('target','_self')", item);
        item.click();
        waitForReloadingPage();
        return true;
    }

    @Step("Нажать на ссылку заголовка первого блока")
    public void clickOnFirstBlockTitle() {
        WebElement firstBlockTitle = findElementByNoThrow(newsFirstBlock, By.cssSelector("h2 a"));
        firstBlockTitle.click();
        waitForReloadingPage();
    }

    @Step("Нажать на ссылку Все новости в первом блоке")
    public void clickOnLinkAllNewsInFirstBlock() {
        WebElement topAllNews = findElementByNoThrow(newsFirstBlock, By.cssSelector(".news__item_type_all-news a"));
        topAllNews.click();
        waitForReloadingPage();
    }

    @Step("Нажать на ссылку Все новости во втором блоке")
    public void clickOnLinkAllNewsInSecondBlock() {
        WebElement topAllNews = findElementByNoThrow(newsSecondBlock, By.cssSelector(".news__item_type_all-news a"));
        topAllNews.click();
        waitForReloadingPage();
    }
}
