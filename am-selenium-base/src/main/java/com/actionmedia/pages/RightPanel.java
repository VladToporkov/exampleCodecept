package com.actionmedia.pages;

import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.autotest.selenium.context.AbstractComponent;
import com.actionmedia.components.Link;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 07.11.13
 * Time: 9:46
 */
@Component
public class RightPanel extends AbstractComponent<RightPanel> {

    private final Log logger = LogFactory.getLog(getClass());

    @Step("Закрыть правую панель")
    public void closePopularBlock() {
        List<WebElement> expandedPanelList = findElementsBy(By.cssSelector(".opened"));
        for (WebElement expandedPanel : expandedPanelList) {
            if (expandedPanel.isDisplayed()) {
                expandedPanel.findElement(By.cssSelector(".xx-small")).click();
                break;
            }
        }
    }

    @Step("Открыть вкладку 'Популярное' в развернутой правой панели")
    public void clickPopularTabInExpanded() {
        clickTabByNameInExpandedPanel("Популярное");
    }

    @Step("Открыть вкладку 'Просмотренное' в развернутой правой панели")
    public void clickViewedTabInExpanded() {
        clickTabByNameInExpandedPanel("Просмотренное");
    }

    @Step("Открыть вкладку 'Новое в работе' в развернутой правой панели")
    public void clickNewInWorkTabInExpanded() {
        clickTabByNameInExpandedPanel("Новое в работе");
    }

    @Step("Открыть вкладку 'Дополнительно' в развернутой правой панели")
    public void clickAdditionalTabInExpanded() {
        clickTabByNameInExpandedPanel("Дополнительно");
    }

    @Step("Открыть вкладку 'Примеры' в развернутой правой панели")
    public void clickExampleTabInExpanded() {
        clickTabByNameInExpandedPanel("Примеры");
    }

    @Step("Открыть вкладку 'Оглавление' в развернутой правой панели")
    public void clickSoderTabInExpanded() {
        clickTabByNameInExpandedPanel("Оглавление");
    }

    @Step("Открыть вкладку 'C этим решением' в развернутой правой панели")
    public void clickWithThisSolutionTabInExpanded() {
        clickTabByNameInExpandedPanel("C этим решением");
    }

    @Step("Открыть вкладку 'С этим видео' в развернутой правой панели")
    public void clickWithThisVideoTabInExpanded() {
        clickTabByNameInExpandedPanel("С этим видео");
    }

    @Step("Открыть вкладку 'C этим документом' в развернутой правой панели")
    public void clickWithThisDocumentTabInExpanded() {
        clickTabByNameInExpandedPanel("C этим документом");
    }

    @Step("Открыть вкладку 'Ваши доступы' в развернутой правой панели")
    public void clickAccessListTabInExpanded() {
        clickTabByNameInExpandedPanel("Ваши доступы");
    }

    @Step("Открыть вкладку 'Популярное' в свернутой правой панели")
    public void clickPopularTabInCollapsed() {
        clickTabByNameInCollapsedPanel("Популярное");
    }

    @Step("Открыть вкладку 'Просмотренное' в свернутой правой панели")
    public void clickViewedTabInCollapsed() {
        clickTabByNameInCollapsedPanel("Просмотренное");
    }

    @Step("Открыть вкладку 'Новое в работе' в свернутой правой панели")
    public void clickNewInWorkTabInCollapsed() {
        clickTabByNameInCollapsedPanel("Новое в работе");
    }

    @Step("Открыть вкладку 'Дополнительно' в свернутой правой панели")
    public void clickAdditionalTabInCollapsed() {
        clickTabByNameInCollapsedPanel("Дополнительно");
    }

    @Step("Открыть вкладку 'Примеры' в свернутой правой панели")
    public void clickExampleTabInCollapsed() {
        clickTabByNameInCollapsedPanel("Примеры");
    }

    @Step("Открыть вкладку 'Оглавление' в свернутой правой панели")
    public void clickSoderTabInCollapsed() {
        clickTabByNameInCollapsedPanel("Оглавление");
    }

    @Step("Открыть вкладку 'C этим решением' в свернутой правой панели")
    public void clickWithThisSolutionTabInCollapsed() {
        clickTabByNameInCollapsedPanel("C этим решением");
    }

    @Step("Открыть вкладку 'С этим видео' в свернутой правой панели")
    public void clickWithThisVideoTabInCollapsed() {
        clickTabByNameInCollapsedPanel("С этим видео");
    }

    @Step("Открыть вкладку 'C этим документом' в свернутой правой панели")
    public void clickWithThisDocumentTabInCollapsed() {
        clickTabByNameInCollapsedPanel("C этим документом");
    }

    @Step("Открыть вкладку 'Ваши доступы' в свернутой правой панели")
    public void clickAccessListTabInCollapsed() {
        clickTabByNameInCollapsedPanel("Ваши доступы");
    }

    public List<Link> getLinks() {
        List<WebElement> dataPageList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".b-content"));
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement dataPage : dataPageList) {
            if (dataPage.isDisplayed()) {
                waitFewSecond(1000);
                waitForTextToBePresentIn(dataPage);
                List<WebElement> itemList = dataPage.findElements(By.cssSelector(".go"));
                for (WebElement item : itemList) {
                    if (item.getAttribute("target") == null || !item.getAttribute("target").contains("blank")) {
                        String url = item.getAttribute("href");
                        String header = item.getText();
                        WebElement parent = getParentElement(item);
                        WebElement author = findElementByNoThrow(parent, By.cssSelector(".author"));

                        if (author != null && author.getText().toLowerCase().contains("практическое налоговое планирование")) {
                            continue;
                        }

                        if (header != null && header.toLowerCase().contains("практическое налоговое планирование")) {
                            continue;
                        }

                        Link link = new Link(url, header);
                        linkList.add(link);
                    }
                }
                break;
            }
        }
        return linkList;
    }

    public List<Link> getLinksFromCollapsedTabByName(String tabName) {
        WebElement tab = getTabByNameInCollapsed(tabName);
        List<Link> linkList = new ArrayList<Link>();
        if (tab != null) {
            waitForTextToBePresentIn(tab);
            wait(tab);
            List<WebElement> linksElementList = tab.findElements(By.cssSelector(".go"));
            for (WebElement linkElement : linksElementList) {
                String url = linkElement.getAttribute("href");
                String header = linkElement.getText();
                Link link = new Link(url, header);
                linkList.add(link);
            }
        } else {
            setPostponedTestFail("Вкладка '" + tabName + "' не найдена");
        }
        return linkList;
    }

    public List<WebElement> getElementListFromCollapsedTabByName(String tabName) {
        WebElement tab = getTabByNameInCollapsed(tabName);
        List<WebElement> elementList = new ArrayList<WebElement>();
        if (tab != null) {
            waitForTextToBePresentIn(tab);
            wait(tab);
            return tab.findElements(By.cssSelector(".go"));
        } else {
            setPostponedTestFail("Вкладка '" + tabName + "' не найдена");
        }
        return elementList;
    }

    public List<WebElement> getElementListFromCollapsedNewInWorkTab(String tabName) {
        WebElement tab = getTabByNameInCollapsed(tabName);
        List<WebElement> elementList = new ArrayList<WebElement>();
        if (tab != null) {
            waitForTextToBePresentIn(tab);
            wait(tab);
            return tab.findElements(By.cssSelector("[href*='#/']"));
        } else {
            setPostponedTestFail("Вкладка '" + tabName + "' не найдена");
        }
        return elementList;
    }

    public List<WebElement> getItemsFromCollapsedTabByName(String tabName) {
        WebElement tab = getTabByNameInCollapsed(tabName);
        List<WebElement> linkList = new ArrayList<WebElement>();
        if (tab != null) {
            wait(tab);
            WebElement content = tab.findElement(By.cssSelector(".jspPane"));
            linkList = content.findElements(By.tagName("a"));
            return linkList;
        } else {
            setPostponedTestFail("Вкладка '" + tabName + "' не найдена");
        }
        return linkList;
    }

    public List<String> getItems() {
        waitForReloading();
        List<String> itemsStringList = new ArrayList<String>();
        List<WebElement> dataPageList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".b-content"));
        for (WebElement dataPage : dataPageList) {
            if (dataPage.isDisplayed()) {
                waitForTextToBePresentIn(dataPage);
                List<WebElement> itemsElementList = dataPage.findElements(By.cssSelector(".go"));
                for (WebElement item : itemsElementList) {
                    scrollIntoView(item);
                    itemsStringList.add(item.getAttribute("href"));
                }
                break;
            }
        }
        return itemsStringList;
    }

    public void clickTodayFilter() {
        report("Выбрать фильтр Сегодня");
        clickFilterByName("Сегодня");
    }

    public void clickYesterdayFilter() {
        report("Выбрать фильтр Вчера");
        clickFilterByName("Вчера");
    }

    public void clickWeekFilter() {
        report("Выбрать фильтр За неделю");
        clickFilterByName("За неделю");
    }

    public void clickMonthFilter() {
        report("Выбрать фильтр За месяц");
        clickFilterByName("За месяц");
    }

    public void clickAllTimeFilter() {
        report("Выбрать фильтр За все время");
        clickFilterByName("За все время");
    }

    public void clickAllSectionsFilter() {
        report("Выбрать фильтр Все разделы");
        clickFilterByName("Все разделы");
    }

    public void clickSolutionsFilter() {
        report("Выбрать фильтр Решения");
        clickFilterByName("Решения");
    }

    public void clickFormsFilter() {
        report("Выбрать фильтр Положения и регламенты");
        clickFilterByName("Положения и регламенты");
    }

    public void clickLawBaseFilter() {
        report("Выбрать фильтр Правовая база");
        clickFilterByName("Правовая база");
    }

    public void clickMagazinesFilter() {
        report("Выбрать фильтр Библиотека");
        clickFilterByName("Библиотека");
    }

    public void clickVideoFilter() {
        report("Выбрать фильтр Видео");
        clickFilterByName("Видео");
    }

    public void openRandomItemInAccessList() {
        report("Открыть информацию по случайному доступу");
        List<WebElement> accessList = getTabByNameInCollapsed("Ваши доступы").findElements(By.cssSelector(".middle"));
        WebElement randomAccess = getRandomElementInList(accessList);
        WebElement accessInfo = randomAccess.findElement(By.cssSelector(".expanding"));
        if (!accessInfo.getAttribute("class").contains("opened")) {
            WebElement randomAccessLink = randomAccess.findElement(By.cssSelector(".arrow"));
            report("Открывается " + randomAccessLink.getText());
            randomAccessLink.click();
        }
    }

    public void closeRandomItemInAccessList() {
        report("Закрыть информацию по случайному доступу");
        List<WebElement> accessList = getTabByNameInCollapsed("Ваши доступы").findElements(By.cssSelector(".middle"));
        WebElement randomAccess = getRandomElementInList(accessList);
        WebElement accessInfo = randomAccess.findElement(By.cssSelector(".expanding"));
        if (accessInfo.getAttribute("class").contains("opened")) {
            WebElement randomAccessLink = randomAccess.findElement(By.cssSelector(".arrow"));
            report("Закрывается " + randomAccessLink.getText());
            randomAccessLink.click();
        }
    }

    public void checkAccessInfoInExpandedIsDisplayed() {
        report("Проверяется что информация о доступе отображается");
        WebElement tab = getActiveTab();
        WebElement accessInfo = tab.findElement(By.cssSelector(".b-table"));
        postponedAssertTrue(accessInfo.isDisplayed(), "Информация о доступе не отображается");
    }

    public void checkAccessInfoInExpandedContainsValue(String value) {
        report("Проверяется что информация о доступе отображается");
        WebElement tab = getActiveTab();
        WebElement accessInfo = tab.findElement(By.cssSelector(".b-table"));

        int valueColumnNumber = -1;
        List<WebElement> headerItemList = accessInfo.findElements(By.tagName("tr")).get(0).findElements(By.tagName("td"));
        for (int i = 0; i < headerItemList.size(); i++) {
            WebElement header = headerItemList.get(i);
            if (header.getText().equals(value)) {
                valueColumnNumber = i;
                break;
            }
        }

        if (valueColumnNumber != -1) {
            WebElement table = accessInfo.findElement(By.tagName("tbody"));
            List<WebElement> rowList = table.findElements(By.tagName("tr"));
            for (WebElement row : rowList) {
                List<WebElement> itemList = row.findElements(By.tagName("td"));
                WebElement item = itemList.get(valueColumnNumber);
                postponedAssertFalse(item.getText().isEmpty(), "В таблице доступов Отсутствует значение для параметра '" + value + "'");
            }
        } else {
            setPostponedTestFail("В таблице доступов Отсутствует параметр '" + value + "'");
        }
    }

    public void checkAccessInfoInCollapsedIsDisplayed() {
        report("Проверяется что информация о доступе отображается");
        WebElement tab = getTabByNameInCollapsed("Ваши доступы");
        WebElement accessInfo = tab.findElement(By.cssSelector(".expanding"));
        if (accessInfo.getAttribute("class").contains("opened")) {
            postponedAssertTrue(accessInfo.isDisplayed(), "Информация о доступе не отображается");
        }
    }

    public void checkAccessInfoIsCollapsedNotDisplayed() {
        report("Проверяется что информация о доступе не отображается");
        WebElement tab = getTabByNameInCollapsed("Ваши доступы");
        WebElement accessInfo = tab.findElement(By.cssSelector(".expanding"));
        if (!accessInfo.getAttribute("class").contains("opened")) {
            postponedAssertFalse(accessInfo.isDisplayed(), "Информация о доступе отображается");
        }
    }

    public void checkAccessInfoInCollapsedContainsValue(String value) {
        WebElement tab = getTabByNameInCollapsed("Ваши доступы");
        WebElement accessInfo = tab.findElement(By.cssSelector(".expanding"));
        if (accessInfo.getAttribute("class").contains("opened")) {
            postponedAssertTrue(accessInfo.getText().contains(value), "В информации о доступе Отсутствует параметр '" + value + "'");
        }
    }

    @Step("Проверяются фильтры по дате")
    public void checkDateFilters() {
//        List<String> todayItemsList = getItems();
//        List<String> yesterdayItemsList = new ArrayList<String>();
//        clickYesterdayFilter();
//        if (isYesterdayViewed()) {
//            report("Проверяются элементы для фильтра Вчера");
//            yesterdayItemsList = getItems();
//            postponedAssertTrue(isDifferentLists(todayItemsList, yesterdayItemsList), "Для фильтра Вчера показаны элементы за Сегодня");
//        }
//
//        clickWeekFilter();
//        List<String> weekItemsList = getItems();
//        report("Проверяются элементы для фильтра За неделю");
//        postponedAssertTrue(isContainsAllItems(weekItemsList, getAllItems(weekItemsList.size(), todayItemsList, yesterdayItemsList)) ||
//                weekItemsList.containsAll(getAllItems(weekItemsList.size(), todayItemsList, yesterdayItemsList)), "Для фильтра За неделю не отображаются элементы за Сегодня");
//
//        clickMonthFilter();
//        List<String> monthItemsList = getItems();
//        report("Проверяются элементы для фильтра За месяц");
//        postponedAssertTrue(isContainsAllItems(monthItemsList, getAllItems(monthItemsList.size(), todayItemsList, yesterdayItemsList, weekItemsList)) ||
//                monthItemsList.containsAll(getAllItems(monthItemsList.size(), todayItemsList, yesterdayItemsList, weekItemsList)), "Для фильтра За месяц не отображаются элементы за Сегодня");
//
//        clickAllTimeFilter();
//        List<String> allItemsList = getItems();
//        report("Проверяются элементы для фильтра За все время");
//        postponedAssertTrue(isContainsAllItems(allItemsList, getAllItems(allItemsList.size(), todayItemsList, yesterdayItemsList, weekItemsList, monthItemsList)) ||
//                allItemsList.containsAll(getAllItems(allItemsList.size(), todayItemsList, yesterdayItemsList, weekItemsList, monthItemsList)), "Для фильтра За все время не отображаются элементы за Сегодня");
//
//        clickTodayFilter();
//        List<String> currentItemsList = getItems();
//        report("Проверяются элементы для фильтра Сегодня");
//        postponedAssertTrue(currentItemsList.equals(todayItemsList), "Для фильтра Сегодня не отображаются элементы за сегодня");
    }

    @Step("Проверяются фильтры по разделам")
    public void checkSectionFilter() {
        List<String> allSectionsItemList = getItems();
        clickSolutionsFilter();
        List<String> solutionsItemList = getItems();
        clickFormsFilter();
        List<String> formsItemList = getItems();
        clickLawBaseFilter();
        List<String> lawBaseItemList = getItems();
        clickMagazinesFilter();
        List<String> magazinesItemList = getItems();
        clickVideoFilter();
        List<String> videosItemList = getItems();

        postponedAssertTrue(allSectionsItemList.containsAll(solutionsItemList), "Фильтр Все разделы не содержит элементы из Решения");
        postponedAssertTrue(allSectionsItemList.containsAll(formsItemList), "Фильтр Все разделы не содержит элементы из Положения и регламенты");
        postponedAssertTrue(allSectionsItemList.containsAll(lawBaseItemList), "Фильтр Все разделы не содержит элементы из Правовая база");
        postponedAssertTrue(allSectionsItemList.containsAll(magazinesItemList), "Фильтр Все разделы не содержит элементы из Библиотека");
        postponedAssertTrue(allSectionsItemList.containsAll(videosItemList), "Фильтр Все разделы не содержит элементы из Видео");

        postponedAssertFalse(isContains(solutionsItemList, formsItemList), "Фильтр Решешия содержит элементы из Положения и регламенты");
        postponedAssertFalse(isContains(solutionsItemList, lawBaseItemList), "Фильтр Решешия содержит элементы из Правовая база");
        postponedAssertFalse(isContains(solutionsItemList, magazinesItemList), "Фильтр Решешия содержит элементы из Библиотека");
        postponedAssertFalse(isContains(solutionsItemList, videosItemList), "Фильтр Решешия содержит элементы из Видео");

        postponedAssertFalse(isContains(formsItemList, solutionsItemList), "Фильтр Положения и регламенты содержит элементы из Решешия");
        postponedAssertFalse(isContains(formsItemList, lawBaseItemList), "Фильтр Положения и регламенты содержит элементы из Правовая база");
        postponedAssertFalse(isContains(formsItemList, magazinesItemList), "Фильтр Положения и регламенты содержит элементы из Библиотека");
        postponedAssertFalse(isContains(formsItemList, videosItemList), "Фильтр Положения и регламенты содержит элементы из Видео");

        postponedAssertFalse(isContains(lawBaseItemList, solutionsItemList), "Фильтр Правовая база содержит элементы из Решешия");
        postponedAssertFalse(isContains(lawBaseItemList, formsItemList), "Фильтр Правовая база содержит элементы из ");
        postponedAssertFalse(isContains(lawBaseItemList, magazinesItemList), "Фильтр Правовая база содержит элементы из ");
        postponedAssertFalse(isContains(lawBaseItemList, videosItemList), "Фильтр Правовая база содержит элементы из ");

        postponedAssertFalse(isContains(magazinesItemList, solutionsItemList), "Фильтр Библиотека содержит элементы из Решешия");
        postponedAssertFalse(isContains(magazinesItemList, formsItemList), "Фильтр Библиотека содержит элементы из Положения и регламенты");
        postponedAssertFalse(isContains(magazinesItemList, lawBaseItemList), "Фильтр Библиотека содержит элементы из Правовая база");
        postponedAssertFalse(isContains(magazinesItemList, videosItemList), "Фильтр Библиотека содержит элементы из Видео");

        postponedAssertFalse(isContains(videosItemList, solutionsItemList), "Фильтр Видео содержит элементы из Решешия");
        postponedAssertFalse(isContains(videosItemList, formsItemList), "Фильтр Видео содержит элементы из Положения и регламенты");
        postponedAssertFalse(isContains(videosItemList, lawBaseItemList), "Фильтр Видео содержит элементы из Правовая база");
        postponedAssertFalse(isContains(videosItemList, magazinesItemList), "Фильтр Видео содержит элементы из Библиотека");

        clickAllSectionsFilter();
        List<String> allSectionItemsAfter = getItems();
        postponedAssertTrue(allSectionsItemList.size() == allSectionItemsAfter.size(), "Количество элементов фильтра Все разделы не равно количеству элементов после выбора другого " +
                "фильтра и возврата на фильтр Все разделы");
        postponedAssertTrue(allSectionsItemList.containsAll(allSectionItemsAfter), "Фильтр Все разделы содержит элементы после выбора другого " +
                "фильтра и возврата на фильтр Все разделы");
    }

    @Step("Проверяется отображение контента в правой панели для книг и журналов")
    public void checkContentForMagazinesAndBooks() {
        List<WebElement> dataPageList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".b-content"));
        for (WebElement dataPage : dataPageList) {
            if (dataPage.isDisplayed()) {
                waitForTextToBePresentIn(dataPage);
                List<WebElement> itemsElementList = dataPage.findElements(By.cssSelector(".preview"));
                for (WebElement item : itemsElementList) {
                    scrollIntoView(item);
                    String magazineName = item.findElement(By.cssSelector(".go")).getText();
                    WebElement itemImg = item.findElement(By.tagName("img"));
                    postponedAssertTrue(isImageLoaded(itemImg), "Картинка не загружена для " + magazineName);
                    WebElement author = findElementByNoThrow(item, By.cssSelector(".author"));
                    if (item.getText().toLowerCase().contains("книга")) {
                        postponedAssertNotNull(author, "Автор не найден для книги " + magazineName);
                        postponedAssertTrue(author.isDisplayed(), "Автор не отображается для книги " + magazineName);
                        postponedAssertFalse(author.getText().isEmpty(), "Поле Автор пустое для книги " + magazineName);
                    } else if (item.getText().toLowerCase().contains("журнал")) {
                        postponedAssertTrue(author == null || author.getText().isEmpty(), "Автор отображается для журнала " + magazineName);
                    }

                }
                break;
            }
        }
    }

    @Step("Проверяется что развернутая правая панель отображается")
    public void checkPanelIsExpanded() {
        WebElement expandedPanel = waitForPresenceOfElementLocatedBy(By.cssSelector(".b-expanded"));
        postponedAssertTrue(expandedPanel.isDisplayed(), "Развернутая правая панель не отображается");
    }

    @Step("Проверяется что свернутая правая панель отображается")
    public void checkPanelIsCollapsed() {
        WebElement expandedPanel = waitForPresenceOfElementLocatedBy(By.cssSelector(".b-expanded"));
        WebElement collapsedPanel = waitForPresenceOfElementLocatedBy(By.cssSelector(".collapsed"), "Не найдена вкладка в свернутой правой панели");
        postponedAssertTrue(collapsedPanel.isDisplayed(), "Свернутая правая панель не отображается");
        postponedAssertFalse(expandedPanel.isDisplayed(), "Развернутая правая панель отображается");
    }

    @Step("Проверяется что свернутая правая панель отображается")
    public void checkPanelIsCollapsedInMagazine() {
        WebElement expandedPanel = waitForPresenceOfElementLocatedBy(By.cssSelector(".b-expanded"));
        WebElement collapsedPanel = waitForPresenceOfElementLocatedBy(By.cssSelector(".b-extra-wrapper"), "Не найдена вкладка в свернутой правой панели");
        postponedAssertTrue(collapsedPanel.isDisplayed(), "Свернутая правая панель не отображается");
        postponedAssertFalse(expandedPanel.isDisplayed(), "Развернутая правая панель отображается");
    }

    @Step("Проверяется что вкладка 'Популярное' в развернутой правой панели открыта")
    public void checkPopularTabInExpandedIsOpened() {
        checkExpandedTabIsOpenedByName("Популярное");
    }

    @Step("Проверяется что вкладка 'Просмотренное' в развернутой правой панели открыта")
    public void checkViewedTabInExpandedIsOpened() {
        checkExpandedTabIsOpenedByName("Просмотренное");
    }

    @Step("Проверяется что вкладка 'Оглавление' в развернутой правой панели открыта")
    public void checkSoderTabInExpandedIsOpened() {
        checkExpandedTabIsOpenedByName("Оглавление");
    }

    @Step("Проверяется что вкладка 'C этим решением' в развернутой правой панели открыта")
    public void checkWithThisSolutionTabInExpandedIsOpened() {
        checkExpandedTabIsOpenedByName("C этим решением");
    }

    @Step("Проверяется что вкладка 'С этим видео' в развернутой правой панели открыта")
    public void checkWithThisVideoTabInExpandedIsOpened() {
        checkExpandedTabIsOpenedByName("С этим видео");
    }

    @Step("Проверяется что вкладка 'C этим документом' в развернутой правой панели открыта")
    public void checkWithThisDocumentTabInExpandedIsOpened() {
        checkExpandedTabIsOpenedByName("C этим документом");
    }

    @Step("Проверяется что вкладка 'Дополнительно' в развернутой правой панели открыта")
    public void checkAdditionalTabInExpandedIsOpened() {
        checkExpandedTabIsOpenedByName("Дополнительно");
    }

    @Step("Проверяется что вкладка 'Примеры' в развернутой правой панели открыта")
    public void checkExampleTabInExpandedIsOpened() {
        checkExpandedTabIsOpenedByName("Примеры");
    }

    @Step("Проверяется что вкладка 'Популярное' в свернутой правой панели открыта")
    public void checkPopularTabInCollapsedIsOpened() {
        checkCollapsedTabIsOpenedByName("Популярное");
    }

    @Step("Проверяется что вкладка 'Просмотренное' в свернутой правой панели открыта")
    public void checkViewedTabInCollapsedIsOpened() {
        checkCollapsedTabIsOpenedByName("Просмотренное");
    }

    @Step("Проверяется что вкладка 'Оглавление' в свернутой правой панели открыта")
    public void checkSoderTabInCollapsedIsOpened() {
        checkCollapsedTabIsOpenedByName("Оглавление");
    }

    @Step("Проверяется что вкладка 'C этим решением' в свернутой правой панели открыта")
    public void checkWithThisSolutionTabInCollapsedIsOpened() {
        checkCollapsedTabIsOpenedByName("C этим решением");
    }

    @Step("Проверяется что вкладка 'С этим видео' в свернутой правой панели открыта")
    public void checkWithThisVideoTabInCollapsedIsOpened() {
        checkCollapsedTabIsOpenedByName("С этим видео");
    }

    @Step("Проверяется что вкладка 'C этим документом' в свернутой правой панели открыта")
    public void checkWithThisDocumentTabInCollapsedIsOpened() {
        checkCollapsedTabIsOpenedByName("C этим документом");
    }

    @Step("Проверяется что вкладка 'Дополнительно' в свернутой правой панели открыта")
    public void checkAdditionalTabInCollapsedIsOpened() {
        checkCollapsedTabIsOpenedByName("Дополнительно");
    }

    @Step("Проверяется что вкладка 'Примеры' в свернутой правой панели открыта")
    public void checkExampleTabInCollapsedIsOpened() {
        checkCollapsedTabIsOpenedByName("Примеры");
    }

    @Step("Проверяется что вкладка 'Популярное' в свернутой правой панели не пустая")
    public void checkPopularTabInCollapsedIsNotEmpty() {
        checkCollapsedTabIsNotEmptyByName("Популярное");
    }

    @Step("Проверяется что вкладка 'Просмотренное' в свернутой правой панели не пустая")
    public void checkViewedTabInCollapsedIsNotEmpty() {
        checkCollapsedTabIsNotEmptyByName("Просмотренное");
    }

    @Step("Проверяется что вкладка 'Оглавление' в свернутой правой панели не пустая")
    public void checkSoderTabInCollapsedIsNotEmpty() {
        checkCollapsedTabIsNotEmptyByName("Оглавление");
    }

    @Step("Проверяется что вкладка 'C этим решением' в свернутой правой панели не пустая")
    public void checkWithThisSolutionTabInCollapsedIsNotEmpty() {
        checkCollapsedTabIsNotEmptyByName("C этим решением");
    }

    @Step("Проверяется что вкладка 'С этим видео' в свернутой правой панели не пустая")
    public void checkWithThisVideoTabInCollapsedIsNotEmpty() {
        checkCollapsedTabIsNotEmptyByName("С этим видео");
    }

    @Step("Проверяется что вкладка 'C этим документом' в свернутой правой панели не пустая")
    public void checkWithThisDocumentTabInCollapsedIsNotEmpty() {
        checkCollapsedTabIsNotEmptyByName("C этим документом");
    }

    @Step("Проверяется что вкладка 'Дополнительно' в свернутой правой панели не пустая")
    public void checkAdditionalTabInCollapsedIsNotEmpty() {
        checkCollapsedTabIsNotEmptyByName("Дополнительно");
    }

    @Step("Проверяется что вкладка 'Примеры' в свернутой правой панели не пустая")
    public void checkExampleTabInCollapsedIsNotEmpty() {
        checkCollapsedTabIsNotEmptyByName("Примеры");
    }

    @Step("Проверяется что выбранная вкладка в развернутой правой панели не пустая")
    public void checkActiveTabInExpandedIsNotEmpty() {
        List<Link> links = getLinks();
        postponedAssertFalse(links.isEmpty(), "Во вкладке отсутсвуют ссылки");
    }

    private WebElement getTabByNameInCollapsed(String tabName) {
        WebElement panel = waitForVisibilityOfElementLocatedBy(By.cssSelector(".b-extra-wrapper"),"Правая панель не найдена");
        waitFewSecond(1000);
        List<WebElement> tabs = panel.findElements(By.cssSelector(".b-extra"));
        for (WebElement tab : tabs) {
            WebElement tabHeader = tab.findElement(By.tagName("h2"));
            if (tabHeader.getText().equalsIgnoreCase(tabName)) {
                return tab;
            }
        }
        return null;
    }

    private void waitForReloading() {
        waitForInvisibilityOfElementLocatedBy(By.cssSelector(".b-preloader"));
    }

    private void wait(WebElement element) {
        WebElement loader = findElementByNoThrow(element, By.cssSelector(".b-preloader"));
        if (loader != null) {
            String style = loader.getAttribute("style");
            if (!style.isEmpty()) {
                waitForAttributeUpdate(loader, "style", "none");
            }
            waitFewSecond(1000);
            waitForInvisibilityOfElementLocatedBy(loader);
        }
    }

    private void clickTabByNameInExpandedPanel(String tabName) {
        WebElement tab = waitForPresenceOfAllElementsLocatedBy(By.xpath("//a[text()='" + tabName + "']")).get(1);
        if (!"active".equals(getParentElement(getParentElement(tab)).getAttribute("class"))) {
            tab.click();
            waitForReloading();
            waitFewSecond(1000);
        }
    }

    private void clickTabByNameInCollapsedPanel(String tabName) {
        WebElement tab = waitForPresenceOfAllElementsLocatedBy(By.xpath("//a[text()='" + tabName + "']")).get(0);
        if (!"active".equals(getParentElement(getParentElement(tab)).getAttribute("class"))) {
            tab.click();
            waitForReloading();
            waitFewSecond(1000);
        }
    }

    private void clickFilterByName(String filterName) {
        List<WebElement> filterList = getFilter().findElements(By.tagName("a"));
        for (WebElement filter : filterList) {
            if (filter.getText().equals(filterName) && !"active".equals(getParentElement(filter).getAttribute("class"))) {
                filter.click();
                break;
            }
        }
    }

    private WebElement getFilter() {
        WebElement rightPanel = waitForVisibilityOfElementLocatedBy(By.cssSelector(".b-expanded"),"Правая панель не найдена");
        List<WebElement> filterList = rightPanel.findElements(By.cssSelector(".b-sidebar"));
        for (WebElement filter : filterList) {
            if (filter.isDisplayed()) {
                return filter;
            }
        }
        return null;
    }

    private void scrollIntoView(WebElement element) {
        executeScript("arguments[0].scrollIntoView(true);", element);
    }

    private boolean isYesterdayViewed() {
        WebElement filterItem = getFilter().findElements(By.cssSelector(".black")).get(1);
        return !filterItem.getAttribute("class").contains("disabled");
    }

    private void scroll(WebElement element) {
        if (findElementByNoThrow(element, By.cssSelector(".jspDrag")) != null) {
            waitForTextToBePresentIn(element);
            double yOffset = getYOffset(element);
            WebElement loader = findElementByNoThrow(element, By.cssSelector(".b-preloader"));
            element.sendKeys(Keys.ARROW_DOWN);
            while (!isScrollInBottom(element, yOffset)) {
                element.sendKeys(Keys.ARROW_DOWN);
                if (loader != null) {
                    waitForAttributeUpdate(loader, "style", "none");
                }
            }
        }
    }

    private double getYOffset(WebElement element) {
        WebElement slider = element.findElement(By.cssSelector(".jspTrack"));
        return Double.parseDouble(slider.getAttribute("style").split(":")[1].split("px")[0].trim());
    }

    private boolean isScrollInBottom(WebElement element, double scrollBarBottom) {
        waitForElementUpdated(element);
        String styleAttr = element.findElement(By.cssSelector(".jspDrag")).getAttribute("style");

        double currentPosition = Double.parseDouble(styleAttr
                .split("top:")[1]
                .split("px")[0]
                .trim());

        double height = Double.parseDouble(styleAttr
                .split("height:")[1]
                .split("px")[0]
                .trim());

        return currentPosition + height == scrollBarBottom;
    }

    private boolean waitForElementUpdated(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), getTimeout());
        return wait.until(isUpdated(element));
    }

    private ExpectedCondition<Boolean> isUpdated(final WebElement element) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(@Nullable WebDriver driver) {
                try {
                    element.findElement(By.cssSelector(".jspDrag")).getAttribute("style");
                    return true;
                } catch (StaleElementReferenceException e) {
                    logger.error("AssertionError occurs", e);
                    return false;
                }
            }
        };
    }

    private boolean isContains(List<String> arr1, List<String> arr2) {
        for (String arr1Item : arr1) {
            for (String arr2Item : arr2) {
                if (arr1Item.equals(arr2Item)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void checkCollapsedTabIsOpenedByName(String tabName) {
        WebElement tab = getTabByNameInCollapsed(tabName);
        if (tab != null) {
            waitFewSecond(1000);
            waitForTextToBePresentIn(tab);
            wait(tab);
            postponedAssertTrue(tab.isDisplayed(), "Вкладка '" + tabName + "' не отображается");
            postponedAssertTrue(tab.getSize().getHeight() > 50, "Вкладка '" + tabName + "' не открыта");
            postponedAssertFalse(tab.getAttribute("class").contains("collapsed"), "Вкладка '" + tabName + "' не открыта");
        } else {
            setPostponedTestFail("Вкладка '" + tabName + "' не найдена");
        }
    }

    private void checkCollapsedTabIsNotEmptyByName(String tabName) {
        WebElement tab = getTabByNameInCollapsed(tabName);
        if (tab != null) {
            waitFewSecond(1000);
            waitForTextToBePresentIn(tab);
            wait(tab);
            WebElement content = tab.findElement(By.cssSelector(".jspPane"));
            List<WebElement> links = content.findElements(By.tagName("a"));
            postponedAssertFalse(tab.getText().isEmpty(), "Во вкладке '" + tabName + "' Отсутствует текст");
            postponedAssertFalse(links.isEmpty(), "Во вкладке '" + tabName + "' отсутсвуют ссылки");
        } else {
            setPostponedTestFail("Вкладка '" + tabName + "' не найдена");
        }
    }

    private void checkExpandedTabIsOpenedByName(String tabName) {
        WebElement panel = waitForVisibilityOfElementLocatedBy(By.cssSelector(".b-expanded"),"Правая панель не найдена");
        WebElement headerTab = panel.findElement(By.cssSelector(".b-tabs"));
        WebElement activeTab = headerTab.findElement(By.cssSelector(".active"));
        postponedAssertTrue(activeTab.getText().equalsIgnoreCase(tabName), "Вкладка '" + tabName + "' не открыта");
    }

    private boolean isDifferentLists(List<String> firstList, List<String> secondList) {
        if (firstList.size() == secondList.size()) {
            for (int i = 0; i < firstList.size(); i++) {
                if (!firstList.get(i).equals(secondList.get(i))) {
                    return true;
                }
            }
            return false;
        } else {
            return true;
        }
    }

    private boolean isContainsAllItems(List<String> itemsForTime, List<String> allItems) {
        boolean is = true;
        for (String item : itemsForTime) {
            if (!allItems.contains(item)) {
                is = false;
            }
        }
        return is;
    }

    private List<String> getAllItems(int itemsForTimeSize, List<String>... itemsArray) {
        List<String> allItems = new ArrayList<String>();
        for (List<String> arr : itemsArray) {
            for (String item : arr) {
                if (!allItems.contains(item)) {
                    allItems.add(item);
                }
            }
        }
        if (allItems.size() > itemsForTimeSize) {
            allItems = allItems.subList(0, itemsForTimeSize);
        }
        return allItems;
    }

    private WebElement getActiveTab() {
        List<WebElement> dataPageList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".b-content"));
        for (WebElement dataPage : dataPageList) {
            if (dataPage.isDisplayed()) {
                waitForTextToBePresentIn(dataPage);
                return dataPage;
            }
        }
        return null;
    }
}
