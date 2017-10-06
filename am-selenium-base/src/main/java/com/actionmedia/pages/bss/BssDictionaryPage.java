package com.actionmedia.pages.bss;

import com.actionmedia.autotest.selenium.annotations.ErrorMessage;
import com.actionmedia.autotest.selenium.annotations.Wait;
import com.actionmedia.components.Link;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.helpers.DictionaryPageHelper;
import com.actionmedia.pages.helpers.DocumentHelper;
import com.actionmedia.pages.interfaces.IDictionaryPage;
import com.actionmedia.util.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * User: n.tyukavkin
 * Date: 11.10.13
 * Time: 9:36
 */
@Component
public class BssDictionaryPage extends BssBasePage<BssDictionaryPage> implements IDictionaryPage {

    @FindBy(css = ".calendar__in")
    @Wait
    @CacheLookup
    @ErrorMessage("Не найден элемент с class = calendar__in")
    protected WebElement documentCalendar;

    @FindBy(id = "document-body")
    @Wait
    @CacheLookup
    @ErrorMessage("Не найден элемент с id = documentBody")
    protected WebElement documentBody;

    @Step("Проверяются элементы на странице 'Справочники'")
    public BssDictionaryPage checkDefaultStateDictionaryPage() {
        checkDictionaryTabIsSelected();
        checkSearchBoxPresentOnDictionaryPage();
        checkDictionaryBoardIsDisplayed();
        checkNewsBlockIsPresent();
        checkPopularBlockIsDisplayed();
        checkKBKStickerIsPresent();
        checkOKTMOStickerIsPresent();
        checkAllDictionaryRubricatorButtonIsPresent();
        checkMyFavoritesRubricatorButtonIsPresent();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Справочник'")
    public BssDictionaryPage checkDictionaryTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.DICTIONARIES);
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Справочник'")
    public BssDictionaryPage checkSearchBoxPresentOnDictionaryPage() {
        checkSearchBoxIsPresent("Поиск справочной информации");
        return this;
    }

    @Step("Проверяется блок 'Новое' на странице 'Справочник'")
    public BssDictionaryPage checkNewsBlockIsPresent() {
        List<WebElement> newBlocks = mainLeftElement.findElements(By.cssSelector(".block-changes"));
        postponedAssertFalse(newBlocks.isEmpty(), "Блок Новое пустой");
        return this;
    }

    @Step("Проверяется блок 'Популярное' на странице 'Справочник'")
    public BssDictionaryPage checkPopularBlockIsDisplayed() {
        getHelper(DictionaryPageHelper.class).checkPopularBlockIsDisplayed();
        return this;
    }

    @Step("Проверяется что справочная доска отображается")
    public BssDictionaryPage checkDictionaryBoardIsDisplayed() {
        getHelper(DictionaryPageHelper.class).checkDictionaryBoardIsDisplayed();
        return this;
    }

    @Step("Проверяется что справочная доска отображается")
    public BssDictionaryPage checkKBKStickerIsPresent() {
        WebElement kbkSticker = findElementByNoThrow(mainContentElement, By.cssSelector(".ico_content_kbk"));
        postponedAssertNotNull(kbkSticker, "Стикер 'КБК' на странице 'Справочники' не найден");
        if (kbkSticker != null) {
            postponedAssertTrue(kbkSticker.isEnabled() && kbkSticker.isDisplayed(), "Стикер 'КБК' на странице 'Справочники' не отображается");
        }
        return this;
    }

    @Step("Проверяется что справочная доска отображается")
    public BssDictionaryPage checkOKTMOStickerIsPresent() {
        if (!getSettings().isRunProduction()) {
            WebElement oktmoSticker = findElementByNoThrow(mainContentElement, By.cssSelector(".ico_content_oktmo"));
            postponedAssertNotNull(oktmoSticker, "Стикер 'ОКТМО' на странице 'Справочники' не найден");
            if (oktmoSticker != null) {
                postponedAssertTrue(oktmoSticker.isEnabled() && oktmoSticker.isDisplayed(), "Стикер 'ОКТМО' на странице 'Справочники' не отображается");
            }
        }
        return this;
    }

    @Step("Проверяется что кнопка рубрикатора справочника отображается")
    public BssDictionaryPage checkAllDictionaryRubricatorButtonIsPresent() {
        getHelper(DictionaryPageHelper.class).checkAllDictionaryRubricatorButtonIsPresent();
        return this;
    }

    @Step("Проверяются элементы на справочной доске")
    public BssDictionaryPage checkElementsOnDictionaryBoard() {
        getHelper(DictionaryPageHelper.class).checkCalendarOnDictionaryBoard();
        getHelper(DictionaryPageHelper.class).checkDisplayReviewOnDictionaryBoard();
        if (getCurrentUrl().contains("/u")) {
            getHelper(DictionaryPageHelper.class).checkDisplayCurrencyOnDictionaryBoard();
            getHelper(DictionaryPageHelper.class).checkDisplayRefinancingRateOnDictionaryBoard();
        } else if (getCurrentUrl().contains("/bu")) {
            getHelper(DictionaryPageHelper.class).checkDisplayCurrencyOnDictionaryBoard();
            getHelper(DictionaryPageHelper.class).checkDisplayRefinancingRateOnDictionaryBoard();
        } else {
            getHelper(DictionaryPageHelper.class).checkDisplayCurrencyOnDictionaryBoard();
            getHelper(DictionaryPageHelper.class).checkDisplayRefinancingRateOnDictionaryBoard();
        }
        return this;
    }

    @Step("Проверяются элементы на справочной доске для БУ версии")
    public BssDictionaryPage checkElementsOnDictionaryBoardBUVersion() {
        WebElement board = waitForPresenceOfElementLocatedBy(By.id("board"), "Справочная доска не найдена");

        WebElement calendar = findElementByNoThrow(board, By.cssSelector(".widget_content_calendar"));
        assertNotNull(calendar, "Календарь не найден на справочной доске");
        postponedAssertTrue(calendar.isEnabled() && calendar.isDisplayed(), "Календарь не отображается на справочной доске");

        checkCalendarWidget();
        checkReviewsSticker();
        checkMrotWidget();
        checkCurrencyWidgetIsAbsent();
        return this;
    }

    @Step("Проверяются элементы на справочной доске для УСН версии")
    public BssDictionaryPage checkElementsOnDictionaryBoardUSNVersion() {
        WebElement board = waitForPresenceOfElementLocatedBy(By.id("board"), "Справочная доска не найдена");

        WebElement calendar = findElementByNoThrow(board, By.cssSelector(".widget_content_calendar"));
        assertNotNull(calendar, "Календарь не найден на справочной доске");
        postponedAssertTrue(calendar.isEnabled() && calendar.isDisplayed(), "Календарь не отображается на справочной доске");

        checkCalendarWidget();
        checkCurrencyWidget();
        checkReviewsSticker();
        checkMrotWidget();
        checkRateWidgetIsAbsent();
        return this;
    }

    @Step("Проверяются элементы в блоке Популярное для КУ/УСН версии")
    public BssDictionaryPage checkElementsOnPopularBlock() {
        List<WebElement> popularDictionaryList = sidebarElement.findElements(By.cssSelector(".handbook"));
        List<String> popularTitleList = new ArrayList<String>();
        String firstItem = popularDictionaryList.get(0).getText();
        postponedAssertEquals(firstItem, "13 200 бухгалтерских проводок с комментариями", "Неправильная первая ссылка в блоке популярное для КУ/УСН версии");
        for (WebElement popularDictionary : popularDictionaryList) {
            String popularTitle = popularDictionary.getText();
            postponedAssertFalse(popularTitleList.contains(popularTitle), "Ссылка повторяется '" + popularTitle + "' в блоке Популярное");
            popularTitleList.add(popularTitle);
        }
        return this;
    }

    @Step("Проверяются элементы в блоке Популярное для БУ версии")
    public BssDictionaryPage checkElementsOnPopularBlockBUVersion() {
        List<WebElement> popularDictionaryList = sidebarElement.findElements(By.cssSelector(".handbook"));
        List<String> popularTitleList = new ArrayList<String>();
        String firstItem = popularDictionaryList.get(0).getText();
        postponedAssertEquals(firstItem, "4000 бухгалтерских проводок с комментариями", "Неправильная первая ссылка в блоке популярное для БУ версии");
        for (WebElement popularDictionary : popularDictionaryList) {
            String popularTitle = popularDictionary.getText();
            postponedAssertFalse(popularTitleList.contains(popularTitle), "Ссылка повторяется '" + popularTitle + "' в блоке Популярное");
            popularTitleList.add(popularTitle);
        }
        return this;
    }

    @Step("Проверяется работа скролла в блоке Новое")
    public BssDictionaryPage checkNewsBlockScrolling() {
        List<WebElement> newsBeforeScroll = mainLeftElement.findElements(By.cssSelector(".block-changes"));
        postponedAssertFalse(newsBeforeScroll.isEmpty(), "Блок Новое пустой");

        scroll(Period.month, By.tagName("h2"));

        List<WebElement> newsAfterScroll = mainLeftElement.findElements(By.cssSelector(".block-changes"));
        postponedAssertTrue(newsAfterScroll.size() > newsBeforeScroll.size(), "Новости не подгружаются после скролла");
        return this;
    }

    @Step("Проверяется сортировка новостей по дате(от новых к старым)")
    public BssDictionaryPage checkDateAreSortedDescending() {
        List<WebElement> dateListElement = mainLeftElement.findElements(By.tagName("h2"));
        postponedAssertThat(dateListElement, TestUtils.sortedDatesWithoutYearInDescendingOrder(), "Элементы отсортированы в неправильном порядке");
        return this;
    }

    @Step("Проверяется работа ссылок из блока Новое")
    public BssDictionaryPage checkLinksFromNewsBlock() {
        List<WebElement> newsTitleList = getRandomElementsInList(mainLeftElement.findElements(By.cssSelector(".block-changes")), 3);
        List<Link> newsStringList = new ArrayList<Link>();
        for (WebElement newsTitleElement : newsTitleList) {
            String url = newsTitleElement.findElement(By.tagName("a")).getAttribute("href");
            String header = newsTitleElement.findElement(By.tagName("a")).getText();
            Link link = new Link(url, header);
            newsStringList.add(link);
        }
        checkLinks(newsStringList);
        return this;
    }

    @Step("Проверяется работа ссылок из блока Популярное")
    public BssDictionaryPage checkLinksFromPopularBlock() {
        List<WebElement> popularLinkList = getRandomElementsInList(sidebarElement.findElements(By.cssSelector(".handbook")), 3);
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement popularLink : popularLinkList) {
            String url = popularLink.findElement(By.tagName("a")).getAttribute("href");
            String header = popularLink.findElement(By.tagName("a")).getText();
            Link link = new Link(url, header);
            linkList.add(link);
        }
        checkLinks(linkList);
        return this;
    }

    @Step("Проверяется работа ссылок в стикерах")
    public BssDictionaryPage checkLinksInStickers() {
        checkLinksInCalendarStickers();
        checkLinksInRateStickers();
        checkLinksInCurrencyStickers();
        checkLinksInReviewsStickers();
        return this;
    }

    @Step("Проверяется работа ссылок в стикерах")
    public BssDictionaryPage checkLinksInStickersBUVersion() {
        checkLinksInCalendarStickers();
        checkLinksInReviewsStickers();
        checkLinksInMrotStickers();
        return this;
    }

    @Step("Проверяется работа ссылок в стикерах")
    public BssDictionaryPage checkLinksInStickersUSNVersion() {
        checkLinksInCalendarStickers();
        checkLinksInReviewsStickers();
        checkLinksInCurrencyStickers();
        checkLinksInMrotStickers();
        return this;
    }

    @Step("Проверяется что виджет календаря отображется на справочной доске")
    public BssDictionaryPage checkCalendarWidgetIsPresent() {
        WebElement board = getBoard();
        WebElement calendar = findElementByNoThrow(board, By.cssSelector(".widget_content_calendar"));
        postponedAssertNotNull(calendar, "Виджет календаря не найден на справочной доске");
        if (calendar != null) {
            postponedAssertTrue(calendar.isDisplayed(), "Виджет календаря не отображется на справочной доске");
        }
        return this;
    }

    @Step("Открыть календарь")
    public BssDocumentPage clickCalendarWidget() {
        WebElement board = getBoard();
        WebElement calendar = board.findElement(By.cssSelector(".widget_content_calendar"));
        WebElement calendarLink = calendar.findElement(By.tagName("a"));
        calendarLink.click();
        return redirectTo(BssDocumentPage.class);
    }

    @Step("Открыть случайный документ из блока Новое")
    public BssDocumentPage clickRandomDocumentFromNewsBlock(String exceptDocumentName) {
        List<WebElement> documentFromNewsBlock = mainContentElement.findElements(By.cssSelector("[href*='/#/document/'"));
        List<WebElement> newDocumentList = new ArrayList<WebElement>();
        for (WebElement document : documentFromNewsBlock) {
            if (!document.getText().contains(exceptDocumentName)) {
                newDocumentList.add(document);
            }
        }
        WebElement randomDocument = getRandomElementInList(newDocumentList);
        String documentName = randomDocument.getText();
        report("Открывается '" + documentName + "'");
        setParameter(BssDocumentPage.BOOK_NAME, documentName);
        randomDocument.click();
        return redirectTo(BssDocumentPage.class);
    }

    @Step("Открыть случайный документ из блока Новое")
    public BssDocumentPage clickDocumentFromNewsBlockWithName(String exceptDocumentName) {
        List<WebElement> documentFromNewsBlock = mainContentElement.findElements(By.cssSelector("[href*='/#/document/'"));
        List<WebElement> newDocumentList = new ArrayList<WebElement>();
        for (WebElement document : documentFromNewsBlock) {
            if (document.getText().contains(exceptDocumentName)) {
                newDocumentList.add(document);
            }
        }
        WebElement randomDocument = getRandomElementInList(newDocumentList);
        String documentName = randomDocument.getText();
        report("Открывается '" + documentName + "'");
        randomDocument.click();
        return redirectTo(BssDocumentPage.class);
    }

    @Step("Проверяется отображение новостной ленты и заголовка новостной ленты")
    public BssDictionaryPage checkDictionaryNewsBlockIsDisplayed() {
        getHelper(DictionaryPageHelper.class).checkDictionaryNewsBlockIsDisplayed();
        return this;
    }

    @Step("Проверяется отображение поощников и их ссылок")
    public BssDictionaryPage checkHelpersIsDisplayed() {
        getHelper(DictionaryPageHelper.class).checkHelpersIsDisplayed();
        return this;
    }

    @Step("Проверяется дата в календаре")
    public BssDictionaryPage checkDateOnCalendar() {
        getHelper(DictionaryPageHelper.class).checkToDayDate();
        return this;
    }

    @Step("Проверяется отображение календаря за текущий месяц")
    public BssDictionaryPage checkMonthCalendar() {
        getHelper(DictionaryPageHelper.class).checkMonthCalendar();
        return this;
    }

    @Step("Проверяется отображение праздников и выходных в календаре")
    public BssDictionaryPage checkRedDays() {
        getHelper(DictionaryPageHelper.class).checkRedDays();
        return this;
    }

    @Step("Проверяется отображение таблицы календарных дней")
    public BssDictionaryPage checkMonthDayTable() {
        getHelper(DictionaryPageHelper.class).checkMonthDayTable();
        return this;
    }

    @Step("Проверяется отображение таблицы календарных дней")
    public BssDictionaryPage checkMonthHourTable() {
        getHelper(DictionaryPageHelper.class).checkMonthHourTable();
        return this;
    }

    @Step("Проверяется открытие производственного календаря")
    public BssDictionaryPage checkFactoryCalendar() {
        getHelper(DictionaryPageHelper.class).checkFactoryCalendar();
        return this;
    }

    @Step("Проверяется блок новостей новостной ленты")
    public BssDictionaryPage checkNewsList() {
        getHelper(DictionaryPageHelper.class).checkDatesInDescendingOrderInNewsList();
        getHelper(DictionaryPageHelper.class).checkNewsBlocks();
        return this;
    }

    @Step("Проверяется подгрузка блока новостей новостной ленты")
    public BssDictionaryPage checkScrollNewsList() {
        scrollScript(1000);
        getHelper(DictionaryPageHelper.class).checkDatesInDescendingOrderInNewsList();
        return this;
    }

    @Step("Проверяется работа ссылок в блоке Популярное")
    public BssDictionaryPage checkPopularFormLinks() {
        getHelper(DictionaryPageHelper.class).checkPopularFormLinks();
        return this;
    }

    public BssDictionaryPage checkTitle() {
        getHelper(DictionaryPageHelper.class).checkTitle();
        return this;
    }

    public BssDictionaryPage checkCalendarBlock() {
        getHelper(DictionaryPageHelper.class).checkCalendarBlock();
        return this;
    }

    public BssDictionaryPage checkHolydays() {
        getHelper(DictionaryPageHelper.class).checkHolydays();
        return this;
    }

    public BssDictionaryPage checkEventsTitle() {
        getHelper(DictionaryPageHelper.class).checkEventsTitle();
        return this;
    }

    @Step("Проверяется отображение блока 'События'")
    public BssDictionaryPage checkEvents() {
        WebElement events = findElementByNoThrow(By.id("task-block"));
        WebElement column = findElementByNoThrow(events, By.xpath(".//tr"));
        if ((events != null) && (column != null)) {
            List<WebElement> columnTitle = findElementsByNoThrow(column, By.tagName("th"));
            for (WebElement title : columnTitle) {
                postponedAssertTrue(title.getText().contains("Кто платит налог") || title.getText().contains("Что сделать организации или предпринимателю")
                        || title.getText().contains("Рекомендации") || title.getText().contains("Документ"), "Неверное наименование колонок блока 'События' " + title);
            }
        } else {
            setPostponedTestFail("Элемент 'Блок События' не найден");
        }
        return this;
    }

    public BssDictionaryPage checkRubricatorButtonIsPresent(String buttonName) {
        getHelper(DocumentHelper.class).checkRubricatorButtonIsPresent(buttonName);
        return this;
    }

    public BssDictionaryPage checkDisplayStars() {
        getHelper(DictionaryPageHelper.class).checkDisplayStars();
        return this;
    }

    public BssDictionaryPage checkNotDisplayStars() {
        getHelper(DictionaryPageHelper.class).checkNotDisplayStars();
        return this;
    }

    public BssDictionaryPage checkEventsBlock() {
        getHelper(DictionaryPageHelper.class).checkEventsBlock();
        return this;
    }

    public BssDictionaryPage checkFactoryCalendarBlock() {
        getHelper(DictionaryPageHelper.class).checkFactoryCalendarBlock();
        return this;
    }

    public BssDictionaryPage checkDates() {
        getHelper(DictionaryPageHelper.class).checkDates();
        return this;
    }

    public BssDictionaryPage checkCalendarInfoDays() {
        getHelper(DictionaryPageHelper.class).checkCalendarInfoDays();
        return this;
    }

    public BssDictionaryPage checkCalendarInfoHour() {
        getHelper(DictionaryPageHelper.class).checkCalendarInfoHour();
        return this;
    }

    public BssDictionaryPage checkCalendarWeekKoment() {
        getHelper(DictionaryPageHelper.class).checkCalendarWeekKoment();
        return this;
    }

    public BssDictionaryPage checkNavigationButtons() {
        getHelper(DictionaryPageHelper.class).checkNavigationButtons();
        return this;
    }

    @Step("Проверяется навигация 'Вперед' блока 'Календарь'")
    public BssDictionaryPage checkCalendarNavigationForward() {
        WebElement forward = findElementByNoThrow(documentCalendar, By.id("forward"));
        String[] urlCheck = getCurrentUrl().split("=");
        forward.click();
        waitForPresenceOf(documentCalendar);
        getHelper(DictionaryPageHelper.class).checkCalendarNavigation(urlCheck[0]);
        return this;
    }

    @Step("Проверяется навигация 'назад' блока 'Календарь'")
    public BssDictionaryPage checkCalendarNavigationBackward() {
        WebElement backward = findElementByNoThrow(documentCalendar, By.id("back"));
        String[] urlCheck = getCurrentUrl().split("=");
        backward.click();
        waitForPresenceOf(documentCalendar);
        getHelper(DictionaryPageHelper.class).checkCalendarNavigation(urlCheck[0]);
        return this;
    }

    @Step("Проверяется первая страница блока 'Календарь'")
    public BssDictionaryPage checkFirstCalendarPage() {
        WebElement backward = findElementByNoThrow(documentCalendar, By.id("back"));
        String[] urlCheck = getCurrentUrl().split("=");
        while (!findElementByNoThrow(documentCalendar, By.id("back")).getAttribute("class").contains("disabled")) {
            backward.click();
            waitForReloadingPage();
            documentCalendar = findElementByNoThrow(By.cssSelector(".calendar__in"));
            if (documentCalendar == null) {
                setPostponedTestFail("Не удалось докликать до начала календаря");
                return navigateToDictionaryPage().checkFactoryCalendar();
            }
            backward = findElementByNoThrow(documentCalendar, By.id("back"));
        }
        WebElement forward = findElementByNoThrow(documentCalendar, By.id("forward"));
        WebElement displayedMonth = findElementByNoThrow(documentCalendar, By.xpath(".//div[contains(@class, 'displayed') and contains(@class, 'month-block')]"));
        WebElement title = findElementByNoThrow(displayedMonth, By.cssSelector(".clearfix"));
        String month = findElementByNoThrow(title, By.id("monthName")).getText().toLowerCase();
        String year = findElementByNoThrow(title, By.id("year")).getText();
        postponedAssertTrue(month.contains("январь") && year.contains("2014"), "Не верная дата на первой странице календаря");
        postponedAssertTrue(forward.isEnabled(), "На самой ранней странице календаря нет отображается кнопка '>' ");
        getHelper(DictionaryPageHelper.class).checkCalendarNavigation(urlCheck[0]);
        return this;
    }

    @Step("Проверяется последняя страница блока 'Календарь'")
    public BssDictionaryPage checkLastCalendarPage() {
        WebElement forward = findElementByNoThrow(By.id("forward"));
        String[] urlCheck = getCurrentUrl().split("=");
        while (!forward.getAttribute("class").contains("disabled")) {
            forward.click();
            waitForReloadingPage();
            documentCalendar = findElementByNoThrow(By.cssSelector(".calendar__in"));
            if (documentCalendar == null) {
                setPostponedTestFail("Не удалось докликать до конца календаря");
                return navigateToDictionaryPage().checkFactoryCalendar();
            }
            forward = waitForPresenceOfElementLocatedBy(By.id("forward"));
        }
        WebElement backward = findElementByNoThrow(documentCalendar, By.id("back"));
        WebElement displayedMonth = findElementByNoThrow(documentCalendar, By.xpath(".//div[contains(@class, 'displayed') and contains(@class, 'month-block')]"));
        WebElement title = findElementByNoThrow(displayedMonth, By.cssSelector(".clearfix"));
        String month = findElementByNoThrow(title, By.id("monthName")).getText().toLowerCase();
        String year = findElementByNoThrow(title, By.id("year")).getText();
        int yearNow = Calendar.getInstance().get(Calendar.YEAR);
        postponedAssertTrue(month.contains("декабрь") && year.equals(String.valueOf(yearNow)), "Не верная дата на последней странице календаря");
        postponedAssertTrue(backward.isEnabled(), "На самой поздней странице календаря нет отображается кнопка '<' ");
        getHelper(DictionaryPageHelper.class).checkCalendarNavigation(urlCheck[0]);
        return this;
    }

    public BssDictionaryPage checkDailyEvent() {
        getHelper(DictionaryPageHelper.class).checkDailyEvent();
        return this;
    }

    public BssDictionaryPage checkNumberOf() {
        getHelper(DictionaryPageHelper.class).checkNumberOf();
        return this;
    }

    @Step("Проверка отображения кнопки 'Настроить календарь' в блоке 'Календарь'")
    public BssDictionaryPage checkSetupCalendarButton() {
        SetDefoultCalendarFilter();

        WebElement setupButton = findElementByNoThrow(documentBody, By.cssSelector(".calendar__control"));
        if (setupButton != null) {
            postponedAssertTrue(setupButton.isDisplayed(), "Кнопка 'Настроить календарь' не отображается");
        } else setPostponedTestFail("Элемент кнопка 'Настроить календарь не найдена'");
        return this;
    }


    @Step("Проверка отображения фильтров в блоке 'Календарь'")
    public BssDictionaryPage checkSetupCalendar() {
        SetDefoultCalendarFilter();

        WebElement setupButton = findElementByNoThrow(documentBody, By.xpath(".//a[contains(@class, 'js-no-active-hidden-filters')]"));
        if (setupButton != null) {
            setupButton.click();
            waitForReloadingPage();
            WebElement filterBlockTitle = findElementByNoThrow(documentBody, By.cssSelector(".calendar-filters__title"));
            postponedAssertTrue(filterBlockTitle.isDisplayed(), "Заголовок блока 'Фильтры' не отображается");
            postponedAssertTrue(filterBlockTitle.getText().contains("Налоги и отчетность"), "Неверный заголовок блока 'Фильтры'");

            WebElement checkbox = findElementByNoThrow(documentBody, By.cssSelector(".calendar-filters__checkbox"));
            postponedAssertTrue(checkbox.isDisplayed(), "Чекбокс 'Не показывать статистическую отчетность' блока 'Фильтры' не отображается");
            postponedAssertTrue(checkbox.getText().contains("Не показывать статистическую отчетность"), "Неверное наименование чекбокса 'Не показывать статистическую отчетность' блока 'Фильтры'");

            WebElement filterClear = findElementByNoThrow(documentBody, By.xpath(".//a[contains(@class, 'js-clear-filters')]"));
            postponedAssertTrue(filterClear.isDisplayed(), "Кнопка 'Сбросить настроки' блока 'Фильтры' не отображается");
            postponedAssertTrue(filterClear.getText().trim().contains("Сбросить настройки"), "Неверное наименования кнопки 'Сбросить настройки' блока 'Фильтры'");

            List<WebElement> filters = findElementsByNoThrow(documentBody, By.cssSelector(".list__item"));
            if (filters.size() != 0) {
                for (WebElement filter : filters) {
                    postponedAssertTrue(filter.isDisplayed(), "Фильтр не отображается");
                }
            } else
                setPostponedTestFail("Элементы фильтры не найдены");
        } else
            setPostponedTestFail("Элемент кнопка 'Настроить календарь не найдена'");
        return this;
    }

    private void SetDefoultCalendarFilter() {
        if (waitForPresenceOfElementLocatedBy(By.cssSelector(".js-active-hidden-filters")).isDisplayed()) {
            findElementBy(By.cssSelector(".js-toggle-filters")).click();
            waitForPresenceOfElementLocatedBy(By.cssSelector(".js-clear-filters")).click();
            findElementBy(By.cssSelector(".js-toggle-filters")).click();
        }
    }

    @Step("Проверка работы чекбокса фильтров в блоке 'Календарь'")
    public BssDictionaryPage checkFiltersCheckbox() {
        WebElement checkbox = findElementByNoThrow(documentBody, By.cssSelector(".calendar-filters__checkbox"));
        if (checkbox != null) {
            List<WebElement> eventsTitles = findElementsByNoThrow(documentBody, By.cssSelector(".task-paragraph"));
            WebElement reporting = null;
            for (WebElement title : eventsTitles) {
                if (title.getText().contains("Статистическая отчетность"))
                    reporting = title;
            }
            checkbox.click();
            postponedAssertTrue(reporting != null && !reporting.isDisplayed(), "Раздел 'Статистическая отчетность отображается'");
            WebElement setupWarning = findElementByNoThrow(documentBody, By.xpath(".//span[contains(@class, 'js-active-hidden-filters')]"));
            postponedAssertTrue(setupWarning.isDisplayed(), "Предупреждение 'Не все события показаны (настроить)' не отображается");

        } else setPostponedTestFail("Элемент чекбокс не найден");
        return this;
    }

    @Step("Проверка работы фильтров в блоке 'Календарь'")
    public BssDictionaryPage checkFilters() {
        List<WebElement> filters = findElementsByNoThrow(documentBody, By.xpath(".//a[contains(@class, 'js-sub-filter')]"));
        if (filters.size() != 0) {
            List<WebElement> dailyEvents = findElementsByNoThrow(documentBody, By.cssSelector(".task"));
            List<String> eventTitles = new ArrayList<String>();
            for (WebElement dailyEvent : dailyEvents) {
                if (findElementBy(dailyEvent, By.tagName("td")).isDisplayed()) {
                    String eventTitle = findElementBy(dailyEvent, By.tagName("td")).getText();
                    eventTitles.add(eventTitle);
                }
            }

            List<WebElement> randomFilters = getRandomElementsInList(filters, 3);
            for (WebElement filter : randomFilters) {
                filter.click();
            }
            List<WebElement> newDailyEvents = findElementsByNoThrow(documentBody, By.cssSelector(".task"));
            List<String> newEventTitles = new ArrayList<String>();
            for (WebElement dailyEvent : newDailyEvents) {
                if (findElementBy(dailyEvent, By.tagName("td")).isDisplayed()) {
                    String newEventTitle = findElementBy(dailyEvent, By.tagName("td")).getText();
                    newEventTitles.add(newEventTitle);
                }
            }

            postponedAssertTrue(!eventTitles.equals(newEventTitles), "Отображаются события не только для выбранных фильтров");
        } else
            setPostponedTestFail("Элементы фильтры не найдены");

        List<WebElement> activeFilters = findElementsByNoThrow(documentBody, By.xpath(".//a[contains(@class, 'link_state_active')]"));
        List<String> filtersNames = new ArrayList<String>();
        for (WebElement filter : activeFilters) {
            filtersNames.add(filter.getText());
        }

        WebElement forward = findElementByNoThrow(documentCalendar, By.id("forward"));
        forward.click();
        waitForReloadingPage();
        WebElement filtersBlock = findElementByNoThrow(By.id("filters-block"));
        if (!filtersBlock.isDisplayed()) {
            findElementByNoThrow(documentCalendar, By.cssSelector(".link js-toggle-filters")).click();
        }
        activeFilters = waitForPresenceOfAllElementsLocatedBy(By.xpath(".//a[contains(@class, 'link_state_active')]"));
        for (int i = 0; i < activeFilters.size(); i++) {
            postponedAssertEquals(activeFilters.get(i).getText(), filtersNames.get(i), "Выбранный фильтр не сохранился при переходе на следующую страницу Календаря");
        }

        for (int i = 0; i < 3; i++) {
            WebElement backward = findElementByNoThrow(documentCalendar, By.id("back"));
            backward.click();
            waitForReloadingPage();
        }

        filtersBlock = findElementByNoThrow(By.id("filters-block"));
        if (!filtersBlock.isDisplayed()) {
            findElementByNoThrow(documentCalendar, By.cssSelector(".link js-toggle-filters")).click();
        }
        activeFilters = findElementsByNoThrow(documentBody, By.xpath(".//a[contains(@class, 'link_state_active')]"));
        for (int i = 0; i < activeFilters.size(); i++) {
            postponedAssertEquals(activeFilters.get(i).getText(), filtersNames.get(i), "Выбранный фильтр не сохранился при переходе предидущую страницу Календаря");
        }
        return this;
    }

    @Step("Проверка работы кнопки 'Сбросить настройки' блока Фильтры")
    public BssDictionaryPage checkClearSettings() {
        WebElement clear = findElementByNoThrow(documentBody, By.xpath(".//a[contains(@class, 'js-clear-filters')]"));
        if (clear != null) {
            List<WebElement> dailyEvents = findElementsByNoThrow(documentBody, By.cssSelector(".task"));
            List<String> eventTitles = new ArrayList<String>();
            for (WebElement dailyEvent : dailyEvents) {
                if (findElementBy(dailyEvent, By.tagName("td")).isDisplayed()) {
                    String eventTitle = findElementBy(dailyEvent, By.tagName("td")).getText();
                    eventTitles.add(eventTitle);
                }
            }

            clear.click();

            List<WebElement> newDailyEvents = findElementsByNoThrow(documentBody, By.cssSelector(".task"));
            List<String> newEventTitles = new ArrayList<String>();
            for (WebElement dailyEvent : newDailyEvents) {
                if (findElementBy(dailyEvent, By.tagName("td")).isDisplayed()) {
                    String newEventTitle = findElementBy(dailyEvent, By.tagName("td")).getText();
                    newEventTitles.add(newEventTitle);
                }
            }

            postponedAssertTrue(!eventTitles.equals(newEventTitles), "Отображаются не все события");
        } else setPostponedTestFail("Элемент кнопка 'Сбросить настройки' не найден");
        return this;
    }

    private void checkLinksInCalendarStickers() {
        WebElement rateSticker = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_calendar"), "Не найден стикер Календарь");
        String url = rateSticker.findElement(By.tagName("a")).getAttribute("href");
        String header = rateSticker.findElement(By.tagName("a")).getText();
        checkLinks(Arrays.asList(new Link(url, header)));
        navigateToDictionaryPage();
    }

    private void checkLinksInRateStickers() {
        WebElement rateSticker = waitForPresenceOfElementLocatedBy(By.cssSelector(".sticker_content_refinancing-rate"), "Не найден стикер Ставка рефинансирования");
        String url = rateSticker.findElement(By.tagName("a")).getAttribute("href");
        String header = rateSticker.findElement(By.tagName("a")).getText();
        checkLinks(Arrays.asList(new Link(url, header)));
        navigateToDictionaryPage();
    }

    private void checkLinksInCurrencyStickers() {
        WebElement currencySticker = waitForPresenceOfElementLocatedBy(By.cssSelector(".sticker_content_currency"), "Не найден стикер Курс валют");
        String url = currencySticker.findElement(By.tagName("a")).getAttribute("href");
        String header = currencySticker.findElement(By.tagName("a")).getText();
        checkLinks(Arrays.asList(new Link(url, header)));
        navigateToDictionaryPage();
    }

    private void checkLinksInMrotStickers() {
        WebElement mrotSticker = waitForPresenceOfElementLocatedBy(By.cssSelector(".sticker_content_wage"), "Не найден стикер МРОТ");
        String url = mrotSticker.findElement(By.tagName("a")).getAttribute("href");
        String header = mrotSticker.findElement(By.tagName("a")).getText();
        checkLinks(Arrays.asList(new Link(url, header)));
        navigateToDictionaryPage();
    }

    private void checkLinksInReviewsStickers() {
        WebElement mrotSticker = waitForPresenceOfElementLocatedBy(By.cssSelector(".sticker_content_review"), "Не найден стикер Обзоры");
        String url = mrotSticker.findElement(By.tagName("a")).getAttribute("href");
        String header = mrotSticker.findElement(By.tagName("a")).getText();
        checkLinks(Arrays.asList(new Link(url, header)));
        navigateToDictionaryPage();
    }

    private void checkCalendarWidget() {
        WebElement calendar = waitForVisibilityOfElementLocatedBy(By.cssSelector(".widget_content_calendar"), "Виджет календаря не найден");

        WebElement dateInfo = calendar.findElement(By.cssSelector(".date-block"));
        String day = dateInfo.findElement(By.cssSelector(".day")).getText().trim();
        String month = dateInfo.findElement(By.cssSelector(".month")).getText().substring(0, 3).trim();
        String year = dateInfo.findElement(By.cssSelector(".year")).getText().trim();
        String dayOfWeek = dateInfo.findElement(By.cssSelector(".day-of-week")).getText().trim();

        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy EEE");
        try {
            Date dateStr = formatter.parse(String.format("%s %s %s %s", day, month, year, dayOfWeek));
            Date currentDate = new Date();
            postponedAssertTrue(dateStr.getDay() == currentDate.getDay(), "Неправильный день недели");
            postponedAssertTrue(dateStr.getDate() == currentDate.getDate(), "Неправильный день месяца");
            postponedAssertTrue(dateStr.getMonth() == currentDate.getMonth(), "Неправильный месяц");
            postponedAssertTrue(dateStr.getYear() == currentDate.getYear(), "Неправильный год");
        } catch (ParseException e) {
            logger.info("ParseException occurs");
        }

        WebElement dayInfo = waitForPresenceOfElementLocatedBy(By.cssSelector(".calendar-table"), "Не найдена текущая дата на календаре");
        String selectedDay = dayInfo.findElement(By.cssSelector(".current-day")).getText().trim();
        postponedAssertEquals(selectedDay, day, "На календаре выделено не правильное число");
    }

    private void checkRateWidget() {
        WebElement board = waitForPresenceOfElementLocatedBy(By.id("board"), "Справочная доска не найдена");
        WebElement rate = findElementByNoThrow(board, By.cssSelector(".sticker_content_refinancing-rate"));
        assertNotNull(rate, "Ставка не найдена на справочной доске");
        postponedAssertTrue(rate.isEnabled() && rate.isDisplayed(), "Ставка не отображается на справочной доске");
        postponedAssertFalse(rate.getText().isEmpty(), "Стикер Ставка пустой");
        assertNotNull(findElementByNoThrow(rate, By.tagName("a")), "Не найдена ссылка в стикере Ставка");
    }

    private void checkCurrencyWidget() {
        WebElement board = waitForPresenceOfElementLocatedBy(By.id("board"), "Справочная доска не найдена");
        WebElement currency = findElementByNoThrow(board, By.cssSelector(".sticker_content_currency"));
        assertNotNull(currency, "Курс валют не найден на справочной доске");
        postponedAssertTrue(currency.isEnabled() && currency.isDisplayed(), "Курс валют не отображается на справочной доске");
        postponedAssertFalse(currency.getText().isEmpty(), "Стикер Курс валют пустой");
        assertNotNull(findElementByNoThrow(currency, By.tagName("a")), "Не найдена ссылка в стикере Курс валют");
    }

    private void checkReviewsSticker() {
        WebElement board = waitForPresenceOfElementLocatedBy(By.id("board"), "Справочная доска не найдена");
        WebElement reviews = findElementByNoThrow(board, By.cssSelector(".sticker_content_review"));
        assertNotNull(reviews, "Обзоры не найдены на справочной доске");
        postponedAssertTrue(reviews.isEnabled() && reviews.isDisplayed(), "Обзоры не отображаются на справочной доске");
        postponedAssertFalse(reviews.getText().isEmpty(), "Стикер Обзоры пустой");
        assertNotNull(findElementByNoThrow(reviews, By.tagName("a")), "Не найдена ссылка в стикере Обзоры");
    }

    private void checkMrotWidget() {
        WebElement board = waitForPresenceOfElementLocatedBy(By.id("board"), "Справочная доска не найдена");
        WebElement mrot = findElementByNoThrow(board, By.cssSelector(".sticker_content_wage"));
        assertNotNull(mrot, "МРОТ не найден на справочной доске");
        postponedAssertTrue(mrot.isEnabled() && mrot.isDisplayed(), "МРОТ не отображается на справочной доске");
        postponedAssertFalse(mrot.getText().isEmpty(), "Стикер МРОТ пустой");
        assertNotNull(findElementByNoThrow(mrot, By.tagName("a")), "Не найдена ссылка в стикере МРОТ");
    }

    private void checkRateWidgetIsAbsent() {
        WebElement board = waitForPresenceOfElementLocatedBy(By.id("board"), "Справочная доска не найдена");
        WebElement rate = findElementByNoThrow(board, By.cssSelector(".sticker_content_refinancing-rate"));
        if (rate != null) {
            postponedAssertFalse(rate.isDisplayed(), "Ставка отображается на справочной доске");
        }
    }

    private void checkCurrencyWidgetIsAbsent() {
        WebElement board = waitForPresenceOfElementLocatedBy(By.id("board"), "Справочная доска не найдена");
        WebElement currency = findElementByNoThrow(board, By.cssSelector(".sticker_content_currency"));
        if (currency != null) {
            postponedAssertFalse(currency.isDisplayed(), "Курс валют отображается на справочной доске");
        }
    }

    private void checkRewiewsWidgetIsAbsent() {
        WebElement board = waitForPresenceOfElementLocatedBy(By.id("board"), "Справочная доска не найдена");
        WebElement reviews = findElementByNoThrow(board, By.cssSelector(".sticker_content_review"));
        if (reviews != null) {
            postponedAssertFalse(reviews.isDisplayed(), "Обзоры отображается на справочной доске");
        }
    }

    private void checkMrotWidgetIsAbsent() {
        WebElement board = waitForPresenceOfElementLocatedBy(By.id("board"), "Справочная доска не найдена");
        WebElement mrot = findElementByNoThrow(board, By.cssSelector(".sticker_content_wage"));
        if (mrot != null) {
            postponedAssertFalse(mrot.isDisplayed(), "МРОТ отображается на справочной доске");
        }
    }

    public BssDocumentPage clickKBKService() {
        WebElement kbkService = mainContentElement.findElement(By.cssSelector(".kbk"));
        kbkService.click();
        return redirectTo(BssDocumentPage.class);
    }

    private WebElement getBoard() {
        return waitForVisibilityOfElementLocatedBy(By.id("board"), "Справочная доска не найдена");
    }

    @Step("Проверяется отображение блока валют")
    public BssDictionaryPage checkDisplayCurrencyOnDictionaryBoard() {
        getHelper(DictionaryPageHelper.class).checkDisplayCurrencyOnDictionaryBoard();
        return this;
    }

    @Step("Проверяется содержимое блока ставка рефинансирования")
    public BssDictionaryPage checkRefinancingRateOnDictionaryBoard() {
        getHelper(DictionaryPageHelper.class).checkRefinancingRateOnDictionaryBoard();
        return this;
    }

    @Step("Проверяется отображения виджета МРОТ")
    public BssDictionaryPage checkDisplayMrotOnDictionaryBoard() {
        getHelper(DictionaryPageHelper.class).checkDisplayMrotOnDictionaryBoard();
        return this;
    }

    @Step("Проверяется содержание виджета МРОТ")
    public BssDictionaryPage checkTextMrotOnDictionaryBoard() {
        getHelper(DictionaryPageHelper.class).checkTextMrotOnDictionaryBoard();
        return this;
    }

    @Step("Проверяется отображение виджета 'Ставики рефенансирования'")
    public BssDictionaryPage checkDisplayRefinancingRateOnDictionaryBoard() {
        getHelper(DictionaryPageHelper.class).checkDisplayRefinancingRateOnDictionaryBoard();
        return this;
    }

    @Step("Проверяется отображение виджета 'Обзор'")
    public BssDictionaryPage checkDisplayReviewOnDictionaryBoard() {
        getHelper(DictionaryPageHelper.class).checkDisplayReviewOnDictionaryBoard();
        return this;
    }

    @Step("Проверяется содержимое виджета 'Обзор'")
    public BssDictionaryPage checkReviewOnDictionaryBoard() {
        String textNew = getPropertyValueElementBefore(".sticker_state_new", "content").replace("\"", "");
        postponedAssertEquals(textNew, "Новое", "Не отображается 'Новое'");

        WebElement widget = findElementBy(By.cssSelector(".sticker_state_new"));

        String stickerTitle = widget.findElement(By.cssSelector(".sticker__title")).getText();
        postponedAssertEquals(stickerTitle, "Обзоры", "Не соответвует текс виджета: " + stickerTitle + "Ожидалось: Обзоры");

        WebElement linkText = widget.findElement(By.cssSelector(".sticker__text")).findElement(By.tagName("a"));
        String linkHead = linkText.getText();
        String linkUrl = linkText.getAttribute("href");
        Link link = new Link(linkUrl, linkHead);
        postponedAssertEquals(linkHead, "изменений законодательства", "Не соответсвует текст заголовка");

        checkLink(link);
        return this;
    }

    @Step("Проверяется содержимое блока Помощник")
    public BssDictionaryPage checkHelperOnDictionaryBoard() {
        List<Link> links = new ArrayList<Link>();

        WebElement linkKbk = waitForPresenceOfElementLocatedBy(By.xpath("//*[contains(@class,'ico_content_kbk')]/.."), "Виджет 'Узнайте КБК' не найден");
        String linkHead = linkKbk.getText();
        String linkUrl = linkKbk.getAttribute("href");
        links.add(new Link(linkUrl, linkHead));
        postponedAssertEquals(linkHead, "Узнайте верный КБК", "Неправильый тектс в блоке 'Узнайте КБК'");

        WebElement linkOktmo = waitForPresenceOfElementLocatedBy(By.xpath("//*[contains(@class,'ico_content_oktmo')]/.."), "Виджет 'Узнайте ОКТМО' не найден");
        String linkHeadOktmo = linkOktmo.getText();
        String linkUrlOktmo = linkOktmo.getAttribute("href");
        links.add(new Link(linkUrlOktmo, linkHeadOktmo));
        postponedAssertEquals(linkHeadOktmo, "Узнайте свой ОКТМО", "Неправильый текст в блоке 'Узнайте КБК'");

        checkLinks(links);
        return this;
    }

    @Step("Нажимается ссылка на календарь")
    public BssDictionaryPage clickFactoryCalendarLink() {
        getHelper(DictionaryPageHelper.class).clickFactoryCalendarLink();
        return this;
    }
}
