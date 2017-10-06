package com.actionmedia.pages.helpers;

import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.base.BasePage;
import com.actionmedia.components.Link;
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
 * Date: 22.10.13
 * Time: 14:21
 */
@Component
@SuppressWarnings("unchecked")
public class NewsPageHelper extends BasePage<NewsPageHelper> {

    @Step("Проверяется что блок Новое в работе не пустой")
    public void checkNewsIsPresent() {
        WebElement newsContent = waitForPresenceOfElementLocatedBy(By.id("newspaper"), "Блок новостей на странице Новое в работе не найден");
        waitForVisibilityOfElementLocatedBy(By.id("newspaper-data"), "Блок новостей на странице Новое в работе не найден");
        postponedAssertTrue(newsContent.isEnabled() && newsContent.isDisplayed(), "Новости не отображаются");
        List<WebElement> newsItemList = newsContent.findElements(By.cssSelector(".newspaper-item"));
        postponedAssertFalse(newsItemList.isEmpty(), "Список новостей пуст на странице Новое в работе");
        for (WebElement newsItem : newsItemList) {
            postponedAssertTrue(newsItem.isDisplayed() && !newsItem.getText().isEmpty(), "Новость не отображается");
        }
    }

    @Step("Проверяется работа ссылок на странице Новое в работе")
    public void checkLinksOnNewsPage() {
        WebElement newsBlock = waitForPresenceOfElementLocatedBy(By.id("newspaper"), "Новости не найдены");
        List<WebElement> newsBlockForDayList = newsBlock.findElements(By.cssSelector(".layout-container"));
        List<Link> linkList = new ArrayList<Link>();
        for (int i = 0; i < newsBlockForDayList.size(); i++) {
            WebElement newsBlockForDay = newsBlockForDayList.get(i);
            List<WebElement> newsForDay = newsBlockForDay.findElements(By.cssSelector(".newspaper-item"));
            if (newsForDay.isEmpty()) {
                String date;
                List<WebElement> dateElementList = newsBlock.findElements(By.cssSelector(".newspaper-date"));
                if (getSettings().isRunKss()) {
                    if (i == 0) {
                        date = dateElementList.get(i).getText();
                    } else {
                        date = dateElementList.get(i * 2).getText();
                    }
                } else {
                    date = dateElementList.get(i).getText();
                }
                setPostponedTestFail("Блок новостей пуст для '" + date + "'");
            } else {
                WebElement randomNews = getRandomElementInList(newsForDay);
                String url = randomNews.findElement(By.cssSelector(".content")).findElement(By.tagName("a")).getAttribute("href");
                String header = randomNews.findElement(By.cssSelector(".content")).findElement(By.tagName("a")).getText();
                Link link = new Link(url, header);
                linkList.add(link);
            }
        }
        checkLinks(linkList);
    }

    @Step("Проверяется что новости отсортированны по убыванию")
    public void checkDateAreSortedDescending() {
        WebElement newsContent = waitForPresenceOfElementLocatedBy(By.id("newspaper"), "Не найден блок новостей на странице Новое в работе");
        List<WebElement> dateListElement = newsContent.findElements(By.cssSelector(".newspaper-date"));

        postponedAssertThat(dateListElement, TestUtils.sortedDatesWithoutYearInDescendingOrder(), "Элементы отсортированы в неправильном порядке");
    }

    @Step("Проверяется что новости отсортированны по убыванию")
    public void checkDateAreSortedDescendingForFirstNumberOfDate(int numberOfDate) {
        WebElement newsContent = waitForPresenceOfElementLocatedBy(By.id("newspaper"), "Не найден блок новостей на странице Новое в работе");
        List<WebElement> dateListElement = newsContent.findElements(By.cssSelector(".newspaper-date"));

        postponedAssertThat(dateListElement.subList(0, numberOfDate), TestUtils.sortedDatesWithoutYearInDescendingOrder(), "Элементы отсортированы в неправильном порядке");
    }

    @Step("Проверяется что новости отсортированны по убыванию")
    public void checkDateAreSortedDescendingForOneYear() {
        WebElement newsContent = waitForPresenceOfElementLocatedBy(By.id("newspaper"), "Не найден блок новостей на странице Новое в работе");
        List<WebElement> dateListElement = newsContent.findElements(By.cssSelector(".newspaper-date"));
        List<WebElement> dateListElementForOneYear = new ArrayList<WebElement>();
        for (WebElement date : dateListElement) {
            if (date.getText().contains("декабря")) {
                break;
            }
            dateListElementForOneYear.add(date);
        }

        postponedAssertThat(dateListElementForOneYear, TestUtils.sortedDatesInDescendingOrder(), "Элементы отсортированы в неправильном порядке");
    }

    @Step("Проверяется что пустых новостей нет")
    public void checkNewsAreNotEmpty() {
        List<WebElement> newsItemList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".newspaper-item"));
        for (WebElement newsItem : newsItemList) {
            WebElement newsContent = findElementByNoThrow(newsItem, By.cssSelector(".content"));
            postponedAssertNotNull(newsContent, "Не найден контент для блока '" + newsItem.getText() + "'");
            if (newsContent != null) {
                WebElement newsLink = findElementByNoThrow(newsContent, By.tagName("a"));
                postponedAssertNotNull(newsLink, "Не найдена ссылка для новости '" + newsContent.getText() + "'");
                postponedAssertTrue(newsContent.isDisplayed() && !newsContent.getText().isEmpty(), "Новость '" + newsContent.getText() + "' не отображается");
            }
        }
    }

    @Step("Проверяется что новости не повторяются")
    public void checkNewsBlockAreNotRepeated() {
        WebElement newsContent = waitForPresenceOfElementLocatedBy(By.id("newspaper"), "Блок Новое не найден");
        List<WebElement> divElementList = newsContent.findElements(By.tagName("div"));

        Map<String, List<String>> newsItems = new HashMap<String, List<String>>();

        Map<String, Integer[]> newsPaperDateMap = getNewsPaperDateMap();
        for (Map.Entry<String, Integer[]> entry : newsPaperDateMap.entrySet()) {
            String dateString = entry.getKey();
            Integer[] arr = entry.getValue();
            List<String> newsForDate = new ArrayList<String>();
            for (int i = arr[0]; i < arr[1]; i++) {
                WebElement divElement = divElementList.get(i);
                if (divElement.getAttribute("class") != null && divElement.getAttribute("class").contains("newspaper-item")) {
                    newsForDate.add(divElement.getText());
                }
            }
            if (!newsItems.containsKey(dateString)) {
                postponedAssertFalse(newsItems.containsValue(newsForDate), "Блок новостей за '" + dateString + "' повторяется");
            }
            if (!newsForDate.isEmpty()) {
                newsItems.put(dateString, newsForDate);
            }
        }
    }

    @Step("Проверяется работа скролла в блоке Новое")
    public void checkNewsScrolling() {
        List<WebElement> newsBeforeScroll = mainLeftElement.findElements(By.cssSelector(".layout-container"));
        postponedAssertFalse(newsBeforeScroll.isEmpty(), "Блок Новое пустой");

        scroll(Period.month, By.cssSelector(".newspaper-date"));

        List<WebElement> newsAfterScroll = mainLeftElement.findElements(By.cssSelector(".layout-container"));
        postponedAssertTrue(newsAfterScroll.size() > newsBeforeScroll.size(), "Новости не подгружаются после скролла");
    }

    private Map<String, Integer[]> getNewsPaperDateMap() {
        WebElement newsContent = waitForPresenceOfElementLocatedBy(By.id("newspaper"), "Блок Новое не найден");
        List<WebElement> divElementList = newsContent.findElements(By.tagName("div"));

        Map<String, Integer[]> map = new HashMap<String, Integer[]>();
        boolean isFirstIndex = false;
        boolean isLastIndex = false;
        int firstIndex = 0;
        int lastIndex = 0;
        String dateString = "";

        for (int i = 0; i < divElementList.size(); i++) {
            WebElement divElement = divElementList.get(i);

            WebElement nextDiv;
            if (i + 1 < divElementList.size()) {
                nextDiv = divElementList.get(i + 1);
            } else {
                nextDiv = null;
            }

            if (divElement.getAttribute("class") != null && divElement.getAttribute("class").contains("newspaper-date") && !isFirstIndex) {
                firstIndex = i + 1;
                isFirstIndex = true;
                dateString = divElement.getText();
            }

            if (nextDiv != null && nextDiv.getAttribute("class") != null && nextDiv.getAttribute("class").contains("newspaper-date") && !isLastIndex || nextDiv == null) {
                lastIndex = i;
                isLastIndex = true;
            }

            if (isFirstIndex && isLastIndex) {
                isFirstIndex = false;
                isLastIndex = false;
                map.put(dateString, new Integer[]{firstIndex, lastIndex});
            }

        }
        return map;
    }

    @Step("Проверяется открытие раздела 'Правовая база'")
    public void checkLawBaseNewsSection() {
        WebElement header = waitForPresenceOfElementLocatedBy(By.id("newspaper-menu"), "Меню газеты не найдено");
        List<WebElement> lawList = header.findElements(By.xpath(".//li[@data-filter='law']"));

        boolean lawbasePresent = lawList != null && lawList.size() == 1;
        postponedAssertTrue(lawbasePresent, "Раздел 'Правовая база' не найден");

        if (lawbasePresent) {
            WebElement law = lawList.get(0);
            postponedAssertTrue(law.getAttribute("class").equals("selected"), "Выделен не тот раздел");
        }
    }

    @Step("Открыть последний документ из найденных в газете")
    public void clickLastDocumentByModuleId(String module) {
        WebElement result = mainContentElement.findElement(By.id("newspaper"));
        List<WebElement> docList = result.findElements(By.cssSelector(".title-link"));
        List<WebElement> newDocList = new ArrayList<WebElement>();
        for (WebElement doc : docList) {
            String docHref = doc.getAttribute("href");
            if (docHref.contains("/#/document/")) {
                String moduleText = docHref.split("/#/document/")[1].split("/")[0];
                if (moduleText.equals(module)) {
                    newDocList.add(doc);
                }
            }
        }
        if (newDocList.size() == 0) {
            setPostponedTestFail("Документ с модулем:" + module + " не найден в новостях.");
        }
        WebElement lastDoc = newDocList.get(newDocList.size()-1);
        lastDoc.click();
    }

}
