package com.actionmedia.pages.fss;

import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.components.Link;
import com.actionmedia.pages.RightPanel;
import com.actionmedia.util.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: n.tyukavkin
 * Date: 11.11.13
 * Time: 11:16
 */
@Component
public class FssHelpers extends FssBasePage<FssHelpers> {

    @Step("Проверяется работассылок из блока Новое")
    public void checkLinksFromNewsBlock() {
        WebElement newsBlock = waitForVisibilityOfElementLocatedBy(By.id("main-article"));
        List<WebElement> newsItemList = newsBlock.findElements(By.cssSelector(".b-news"));
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement newsItem : newsItemList) {
            String url = newsItem.findElement(By.tagName("a")).getAttribute("href");
            String header = newsItem.findElement(By.tagName("a")).getText();
            Link link = new Link(url, header);
            linkList.add(link);
        }
        checkLinks(linkList);
    }

    @Step("Проверяется работа скролла в блоке Новое")
    public void checkNewsBlockScrolling(Period period) {
        WebElement newsBlock = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"), "Блок Новое не найден");
        List<WebElement> newsBeforeScroll = newsBlock.findElements(By.cssSelector(".b-news"));
        postponedAssertFalse(newsBeforeScroll.isEmpty(), "Блок Новое пустой");

        scroll(period, By.cssSelector(".b-date"));

        List<WebElement> newsAfterScroll = newsBlock.findElements(By.cssSelector(".b-news"));
        postponedAssertTrue(newsAfterScroll.size() > newsBeforeScroll.size(), "Новости не подгружаются после скролла");
    }

    @Step("Проверяется сортировка новостей по дате(от новых к старым)")
    public void checkDateAreSortedDescending() {
        WebElement newsBlock = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"), "Блок Новое не найден");
        List<WebElement> dateListElement = newsBlock.findElements(By.cssSelector(".b-date"));

        postponedAssertThat(dateListElement, TestUtils.sortedDatesWithoutYearInDescendingOrder(), "Элементы отсортированы в неправильном порядке");
    }

    @Step("Проверяется что новости не повторяются")
    public void checkNewsBlockAreNotRepeat() {
        WebElement newsContent = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"), "Блок Новое не найден");
        List<WebElement> dateListElement = newsContent.findElements(By.tagName("*"));
        Map<String, List<String>> newsBlockMap = new HashMap<String, List<String>>();
        for (int i = 0; i < dateListElement.size(); i++) {
            WebElement dateElement = dateListElement.get(i);
            if (dateElement.getAttribute("class") != null && dateElement.getAttribute("class").contains("b-date")) {
                String dateString = dateElement.getText();
                List<String> newsBlockForDate = new ArrayList<String>();
                while (i + 1 < dateListElement.size() &&
                        (dateListElement.get(i + 1).getAttribute("class") != null && !dateListElement.get(i + 1).getAttribute("class").contains("b-date"))) {
                    WebElement newsElement = dateListElement.get(i);
                    if (newsElement.getAttribute("class") != null && newsElement.getAttribute("class").contains("b-news")) {
                        newsBlockForDate.add(newsElement.getText());
                    }
                    i++;
                }
                postponedAssertFalse(newsBlockMap.containsValue(newsBlockForDate), "Блок новостей за '" + dateString + "' повторяется");
                if (!newsBlockForDate.isEmpty()) {
                    newsBlockMap.put(dateString, newsBlockForDate);
                }
            }
        }
    }

    @Step("Проверяется что пустых новостей нет")
    public void checkNewsAreNotEmpty() {
        List<WebElement> newsItemList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".b-news"));
        for (WebElement newsItem : newsItemList) {
            WebElement newsLink = findElementByNoThrow(newsItem, By.tagName("a"));
            postponedAssertNotNull(newsLink, "Не найдена сслыка для новости '" + newsItem.getText() + "'");
            postponedAssertTrue(newsItem.isDisplayed() && !newsItem.getText().isEmpty(), "Новость '" + newsItem.getText() + "' не отображается");
        }
    }

    @Step("Открыть правую панель")
    public void clickExtendPopularBlock() {
        WebElement block = getCollapsedRightPanel();
        block.findElement(By.cssSelector(".xx-small")).click();
        waitForVisibilityOfElementLocatedBy(By.cssSelector(".b-expanded-wrapper"), "Правая панель не найдена");
    }

    @Step("Проверяется отображение свернутой правой панели")
    public void checkCollapsedRightPanel(RightPanel rightPanel) {
        getCollapsedRightPanel();
        rightPanel.checkPanelIsCollapsed();

        rightPanel.clickPopularTabInCollapsed();
        rightPanel.checkPopularTabInCollapsedIsOpened();
        rightPanel.checkPopularTabInCollapsedIsNotEmpty();

        rightPanel.clickViewedTabInCollapsed();
        rightPanel.checkViewedTabInCollapsedIsOpened();
        rightPanel.checkViewedTabInCollapsedIsNotEmpty();

        rightPanel.clickPopularTabInCollapsed();
        rightPanel.checkPopularTabInCollapsedIsOpened();
        rightPanel.checkPopularTabInCollapsedIsNotEmpty();

        rightPanel.clickViewedTabInCollapsed();
        rightPanel.checkViewedTabInCollapsedIsOpened();
        rightPanel.checkViewedTabInCollapsedIsNotEmpty();
    }

    @Step("Проверяется отображение развернутой правой панели")
    public void checkExpandedRightPanel(RightPanel rightPanel) {
        clickExtendPopularBlock();
        rightPanel.checkPanelIsExpanded();

        rightPanel.clickPopularTabInExpanded();
        rightPanel.checkPopularTabInExpandedIsOpened();
        rightPanel.checkActiveTabInExpandedIsNotEmpty();

        rightPanel.clickViewedTabInExpanded();
        rightPanel.checkViewedTabInExpandedIsOpened();
        rightPanel.checkActiveTabInExpandedIsNotEmpty();

        rightPanel.clickPopularTabInExpanded();
        rightPanel.checkPopularTabInExpandedIsOpened();
        rightPanel.checkActiveTabInExpandedIsNotEmpty();

        rightPanel.clickViewedTabInExpanded();
        rightPanel.checkViewedTabInExpandedIsOpened();
        rightPanel.checkActiveTabInExpandedIsNotEmpty();
    }

    @Step("Проверяется работа ссылок из вкладки Популярное свернутой правой панели")
    public void checkRandomLinksFromCollapsedPopularTab(RightPanel rightPanel) {
        rightPanel.clickPopularTabInCollapsed();
        List<Link> randomLinks = getRandomElementsInList(rightPanel.getLinksFromCollapsedTabByName("Популярное"), 3);
        checkLinks(randomLinks);
    }

    @Step("Проверяется работа ссылок из вкладки Просмотренное свернутой правой панели")
    public void checkRandomLinksFromCollapsedViewedTab(RightPanel rightPanel) {
        rightPanel.clickViewedTabInCollapsed();
        List<Link> randomLinks = getRandomElementsInList(rightPanel.getLinksFromCollapsedTabByName("Просмотренное"), 3);
        checkLinks(randomLinks);
    }
}
