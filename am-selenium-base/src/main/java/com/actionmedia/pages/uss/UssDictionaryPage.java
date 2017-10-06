package com.actionmedia.pages.uss;

import com.actionmedia.autotest.selenium.annotations.ErrorMessage;
import com.actionmedia.components.Link;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.helpers.DictionaryPageHelper;
import com.actionmedia.pages.helpers.DocumentHelper;
import com.actionmedia.pages.helpers.SearchResultHelper;
import com.actionmedia.pages.interfaces.IDictionaryPage;
import com.actionmedia.util.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.*;

/**
 * User: n.tyukavkin
 * Date: 28.10.13
 * Time: 12:14
 */
@Component
public class UssDictionaryPage extends UssBasePage<UssDictionaryPage> implements IDictionaryPage {

    @FindBy(css = ".calendar__in")
    @CacheLookup
    @ErrorMessage("Не найден элемент с class = calendar__in")
    protected WebElement documentCalendar;

    @Step("Проверяются элементы на странице 'Справочники'")
    public UssDictionaryPage checkDefaultStateDictionaryPage() {
        checkDictionaryTabIsSelected();
        checkSearchBoxPresentOnDictionaryPage();
        checkDictionaryBoardIsDisplayed();
        checkNewsBlock();
        checkPopularBlocks();
        checkAllDictionaryRubricatorButtonIsPresent();
        checkMyFavoritesRubricatorButtonIsPresent();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Справочник'")
    public UssDictionaryPage checkDictionaryTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.DICTIONARY);
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Справочник'")
    public UssDictionaryPage checkSearchBoxPresentOnDictionaryPage() {
        checkSearchBoxIsPresent("Поиск справочной информации");
        return this;
    }

    @Step("Проверяется блок 'Новое' на странице 'Справочник'")
    public UssDictionaryPage checkNewsBlock() {
        List<WebElement> newBlocks = mainLeftElement.findElements(By.cssSelector(".block-changes"));
        postponedAssertFalse(newBlocks.isEmpty(), "Блок Новое пустой");
        return this;
    }

    @Step("Проверяется блок 'Популярное' на странице 'Справочник'")
    public UssDictionaryPage checkPopularBlocks() {
        List<WebElement> popularBlocks = sidebarElement.findElements(By.cssSelector(".news__item"));
        postponedAssertFalse(popularBlocks.isEmpty(), "Блок Популярное пустой");
        return this;
    }

    @Step("Проверяется что справочная доска отображается")
    public UssDictionaryPage checkDictionaryBoardIsDisplayed() {
        getHelper(DictionaryPageHelper.class).checkDictionaryBoardIsDisplayed();
        return this;
    }

    @Step("Проверяется что кнопка рубрикатора справочника отображается")
    public UssDictionaryPage checkAllDictionaryRubricatorButtonIsPresent() {
        getHelper(DictionaryPageHelper.class).checkAllDictionaryRubricatorButtonIsPresent();
        return this;
    }

    @Step("Проверяется работа скролла в блоке Новое")
    public UssDictionaryPage checkNewsBlockScrolling() {
        List<WebElement> newsBeforeScroll = mainLeftElement.findElements(By.cssSelector(".block-changes"));
        postponedAssertFalse(newsBeforeScroll.isEmpty(), "Блок Новое пустой");

        scroll(Period.month, By.tagName("h2"));

        List<WebElement> newsAfterScroll = mainLeftElement.findElements(By.cssSelector(".block-changes"));
        postponedAssertTrue(newsAfterScroll.size() > newsBeforeScroll.size(), "Новости не подгружаются после скролла");
        return this;
    }

    @Step("Проверяется сортировка новостей по дате(от новых к старым)")
    public UssDictionaryPage checkDateAreSortedDescending() {
        List<WebElement> dateListElement = mainLeftElement.findElements(By.tagName("h2"));
        postponedAssertThat(dateListElement, TestUtils.sortedDatesWithoutYearInDescendingOrder(), "Элементы отсортированы в неправильном порядке");
        return this;
    }

    @Step("Проверяется что пустые новости не отображается")
    public UssDictionaryPage checkNewsAreNotEmpty() {
        List<WebElement> dateListElement = mainLeftElement.findElements(By.tagName("*"));
        for (int i = 0; i < dateListElement.size(); i++) {
            if ("h2".equals(dateListElement.get(i).getTagName())) {
                String dateString = dateListElement.get(i).getText();
                boolean isNewsNotEmpty = false;
                while (i + 1 < dateListElement.size() && !"h2".equals(dateListElement.get(i + 1).getTagName())) {
                    WebElement newsElement = dateListElement.get(i);
                    if (newsElement.getAttribute("class") != null && newsElement.getAttribute("class").contains("block-changes")) {
                        isNewsNotEmpty = true;
                        postponedAssertFalse(newsElement.findElement(By.tagName("a")).getText().isEmpty(), "Блок новое для '" + dateString + "' пустой");
                    }
                    i++;
                }
                postponedAssertTrue(isNewsNotEmpty, "Блок новое для '" + dateString + "' пустой");
            }
        }
        return this;
    }

    @Step("Проверяется что новости не повторяются")
    public UssDictionaryPage checkNewsBlockAreNotRepeat() {
        List<WebElement> dateListElement = mainLeftElement.findElements(By.tagName("*"));
        Map<String, List<String>> newsBlockMap = new HashMap<String, List<String>>();
        for (int i = 0; i < dateListElement.size(); i++) {
            if ("h2".equals(dateListElement.get(i).getTagName())) {
                String dateString = dateListElement.get(i).getText();
                List<String> newsBlockForDate = new ArrayList<String>();
                while (i + 1 < dateListElement.size() && !"h2".equals(dateListElement.get(i + 1).getTagName())) {
                    WebElement newsElement = dateListElement.get(i);
                    if (newsElement.getAttribute("class") != null && newsElement.getAttribute("class").contains("block-changes")) {
                        newsBlockForDate.add(newsElement.getText());
                    }
                    i++;
                }
                postponedAssertFalse(newsBlockMap.containsValue(newsBlockForDate), "Блок новостей за '" + dateString + "' повторяется");
                newsBlockMap.put(dateString, newsBlockForDate);
            }
        }
        return this;
    }

    @Step("Проверяется работа ссылок блока Новое")
    public UssDictionaryPage checkNewsBlockLinks() {
        List<WebElement> newsTitleList = mainLeftElement.findElements(By.cssSelector(".block-changes"));
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

    @Step("Проверяется что блок Популярное отображается")
    public UssDictionaryPage checkPopularBlockIsDisplayed() {
        getHelper(DictionaryPageHelper.class).checkPopularBlockIsDisplayed();
        return this;
    }

    @Step("Проверяется что блок Популярное не пустой")
    public UssDictionaryPage checkPopularBlockAreNotEmpty() {
        List<WebElement> popularForms = sidebarElement.findElements(By.cssSelector(".news__item"));
        postponedAssertFalse(popularForms.isEmpty(), "Блок Популярное пустой");

        for (WebElement popularForm : popularForms) {
            postponedAssertFalse(popularForm.getText().isEmpty(), "Отсутствует текст для формы в блоке Популярное");
        }
        return this;
    }

    @Step("Проверяется работа ссылок в блоке Популярное")
    public UssDictionaryPage checkPopularFormLinks() {
        getHelper(DictionaryPageHelper.class).checkPopularFormLinks();
        return this;
    }

    @Step("Проверяются элементы на странице Справочник")
    public UssDictionaryPage checkElementsOnDictionaryBoard() {
        WebElement boardContent = waitForVisibilityOfElementLocatedBy(By.id("board"), "Не найдена справочная доска");
        WebElement refinancingCurrency = findElementByNoThrow(boardContent, By.cssSelector(".sticker_content_refinancing-rate"));
        postponedAssertTrue(refinancingCurrency != null && refinancingCurrency.isDisplayed(), "'Ставка Рефинансирования' не отображается на справочной доске");

        getHelper(DictionaryPageHelper.class).checkCalendarOnDictionaryBoard();
        getHelper(DictionaryPageHelper.class).checkDisplayAddressOnDictionaryBoard();
        getHelper(DictionaryPageHelper.class).checkDisplayManualOnDictionaryBoard();
        return this;
    }

    @Step("Проверяется отображение курса валют")
    public UssDictionaryPage checkHelpersIsDisplayed() {
        WebElement currency = findElementByNoThrow(sidebarElement, By.cssSelector(".list_type_helpers a"));
        postponedAssertTrue(currency != null && currency.isDisplayed(), "'Курс валют' не отображается");
        postponedAssertEquals(currency.getText(), "Курсы валют", "Неправильный текст в виджете 'Курсы валют'");
        return this;
    }

    @Step("Проверяется дата в календаре")
    public UssDictionaryPage checkDateOnCalendar() {
        getHelper(DictionaryPageHelper.class).checkToDayDate();
        return this;
    }

    @Step("Проверяются элементы на справочной доске")
    public UssDictionaryPage checkStickersArePresent() {
        checkAddressSticker();
        checkCurrencySticker();
        checkRateSticker();
        return this;
    }

    @Step("Проверяется работа ссылок в стикерах")
    public UssDictionaryPage checkLinksInStickers() {
        checkLinksInAddressStickers();
        checkLinksInCurrencyStickers();
        checkLinksInRateStickers();
        return this;
    }

    @Step("Проверяется что результаты поиска отсутсвуют")
    public UssDictionaryPage checkSearchResultIsNotPresentOnDictionaryPage() {
        checkSearchResultIsNotPresentOnPage();
        return this;
    }

    @Step("Нажать кнопку Найти")
    public UssDictionaryPage clickSearchButtonOnDictionaryPage() {
        clickSearchButton();
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются")
    public UssDictionaryPage checkHintsIsPresent() {
        checkHintListIsPresent();
        return this;
    }

    @Step("Нажать подсказку с прямым переходом")
    public UssSearchResultPage clickHintWithJumpOnDictionaryPage() {
        clickHintWithJump();
        return redirectTo(UssSearchResultPage.class);
    }

    @Step("Нажать любую подсказку с переходом")
    public UssSearchResultPage clickRandomHintOnDictionaryPage() {
        clickRandomHint();
        return redirectTo(UssSearchResultPage.class);
    }

    @Step("Открыть любой документ из блока популярное")
    public UssDictionaryPage clickRandomDocumentLink() {
        List<WebElement> popularNews = mainLeftElement.findElements(By.tagName("a"));
        getRandomElementInList(popularNews).click();
        waitForReloadingPage();
        return this;
    }

    @Step("Проверяется что Меню поиск в тексте отображается в поисковой строке")
    public UssDictionaryPage checkSearchInTextElementIsPresentOnDictionaryPage() {
        checkSearchInTextElementIsPresent();
        return this;
    }

    @Step("Проверяется работа кнопки Найти на странице Справочник")
    public UssDictionaryPage checkSearchButtonFunctionalityOnSearchBox(String query) {
        setParameter(SearchResultHelper.HINT_TEXT, query);
        return clearSearchBox()
                .clickSearchButtonOnDictionaryPage()
                .checkDictionaryTabIsSelected()
                .checkSearchResultIsNotPresentOnDictionaryPage()

                .clearSearchBox()
                .inputTextInSearchBox(query)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnDictionaryPageIsOpened()
                .navigateToDictionaryPage();
    }

    @Step("Открыть календарь")
    public UssDocumentPage clickCalendarLink() {
        WebElement calendarWidget = waitForVisibilityOfElementLocatedBy(By.cssSelector(".widget_content_calendar"), "Виджет календаря не найден");
        calendarWidget.findElement(By.tagName("a")).click();
        return redirectTo(UssDocumentPage.class);
    }

    @Step("Проверяем отображение новостной ленты")
    public UssDictionaryPage checkDictionaryNewsBlockIsDisplayed() {
        getHelper(DictionaryPageHelper.class).checkDictionaryNewsBlockIsDisplayed();
        return this;
    }

    @Step("Проверяется отображение календаря за текущий месяц")
    public UssDictionaryPage checkMonthCalendar() {
        getHelper(DictionaryPageHelper.class).checkMonthCalendar();
        return this;
    }

    @Step("Проверяется отображение праздников и выходных в календаре")
    public UssDictionaryPage checkRedDays() {
        getHelper(DictionaryPageHelper.class).checkRedDays();
        return this;
    }

    @Step("Проверяется отображение таблицы календарных дней")
    public UssDictionaryPage checkMonthDayTable() {
        getHelper(DictionaryPageHelper.class).checkMonthDayTable();
        return this;
    }

    @Step("Проверяется отображение таблицы календарных дней")
    public UssDictionaryPage checkMonthHourTable() {
        getHelper(DictionaryPageHelper.class).checkMonthHourTable();
        return this;
    }

    @Step("Проверяется открытие производственного календаря")
    public UssDictionaryPage checkFactoryCalendar() {
        getHelper(DictionaryPageHelper.class).checkFactoryCalendar();
        return this;
    }

    @Step("Проверяется блок новостей новостной ленты")
    public UssDictionaryPage checkNewsList() {
        getHelper(DictionaryPageHelper.class).checkDatesInDescendingOrderInNewsList();
        getHelper(DictionaryPageHelper.class).checkNewsBlocks();
        return this;
    }

    @Step("Проверяется подгрузка блока новостей новостной ленты")
    public UssDictionaryPage checkScrollNewsList() {
        scrollScript(1000);
        getHelper(DictionaryPageHelper.class).checkDatesInDescendingOrderInNewsList();
        return this;
    }

    public UssDictionaryPage checkTitle() {
        getHelper(DictionaryPageHelper.class).checkTitle();
        return this;
    }

    public UssDictionaryPage checkCalendarBlock() {
        getHelper(DictionaryPageHelper.class).checkCalendarBlock();
        return this;
    }

    public UssDictionaryPage checkHolydays() {
        getHelper(DictionaryPageHelper.class).checkHolydays();
        return this;
    }

    public UssDictionaryPage checkEventsTitle() {
        getHelper(DictionaryPageHelper.class).checkEventsTitle();
        return this;
    }

    @Step("Проверяется отображение блока 'События'")
    public UssDictionaryPage checkEvents() {
        WebElement events = findElementByNoThrow(By.cssSelector("#document-body .js-table_content_scheduler-task"));
        WebElement column = findElementByNoThrow(events, By.xpath(".//tr"));
        if ((events != null) && (column != null)) {
            List<WebElement> columnTitle = findElementsByNoThrow(column, By.tagName("th"));
            for (WebElement title : columnTitle) {
                postponedAssertTrue(title.getText().contains("Что произойдет") || title.getText().contains("Что нужно сделать") || title.getText().contains("См. подробнее") || title.getText().contains("Документ"), "Неверное наименование колонок блока 'События' " + title);
            }
        } else {
            setPostponedTestFail("Элемент 'Блок События' не найден");
        }
        return this;
    }

    public UssDictionaryPage checkRubricatorButtonIsPresent(String buttonName) {
        getHelper(DocumentHelper.class).checkRubricatorButtonIsPresent(buttonName);
        return this;
    }

    public UssDictionaryPage checkDisplayStars() {
        getHelper(DictionaryPageHelper.class).checkDisplayStars();
        return this;
    }

    public UssDictionaryPage checkNotDisplayStars() {
        getHelper(DictionaryPageHelper.class).checkNotDisplayStars();
        return this;
    }

    public UssDictionaryPage checkEventsBlock() {
        getHelper(DictionaryPageHelper.class).checkEventsBlock();
        return this;
    }

    public UssDictionaryPage checkFactoryCalendarBlock() {
        getHelper(DictionaryPageHelper.class).checkFactoryCalendarBlock();
        return this;
    }

    public UssDictionaryPage checkDates() {
        getHelper(DictionaryPageHelper.class).checkDates();
        return this;
    }

    public UssDictionaryPage checkCalendarInfoDays() {
        getHelper(DictionaryPageHelper.class).checkCalendarInfoDays();
        return this;
    }

    public UssDictionaryPage checkCalendarInfoHour() {
        getHelper(DictionaryPageHelper.class).checkCalendarInfoHour();
        return this;
    }

    public UssDictionaryPage checkCalendarWeekKoment() {
        getHelper(DictionaryPageHelper.class).checkCalendarWeekKoment();
        return this;
    }

    public UssDictionaryPage checkNavigationButtons() {
        getHelper(DictionaryPageHelper.class).checkNavigationButtons();
        return this;
    }

    @Step("Проверяется навигация 'Вперед' блока 'Календарь'")
    public UssDictionaryPage checkCalendarNavigationForward() {
        WebElement forward = findElementByNoThrow(documentCalendar, By.id("forward"));
        if (documentCalendar != null) {
            String[] urlCheck = getCurrentUrl().split("=");
            forward.click();
            waitForPresenceOf(documentCalendar);
            getHelper(DictionaryPageHelper.class).checkCalendarNavigation(urlCheck[0]);
        } else setPostponedTestFail("Календарь не отобразился");
        return this;
    }

    @Step("Проверяется навигация 'назад' блока 'Календарь'")
    public UssDictionaryPage checkCalendarNavigationBackward() {
        WebElement backward = findElementByNoThrow(documentCalendar, By.id("back"));
        if (documentCalendar != null) {
            String[] urlCheck = getCurrentUrl().split("=");
            backward.click();
            waitForPresenceOf(documentCalendar);
            getHelper(DictionaryPageHelper.class).checkCalendarNavigation(urlCheck[0]);
        } else setPostponedTestFail("Календарь не отобразился");
        return this;
    }

    @Step("Проверяется первая страница блока 'Календарь'")
    public UssDictionaryPage checkFirstCalendarPage() {
        WebElement backward = findElementByNoThrow(documentCalendar, By.id("back"));
        String[] urlCheck = getCurrentUrl().split("=");
        while (!findElementByNoThrow(documentCalendar, By.id("back")).getAttribute("class").contains("disabled")) {
            backward.click();
            try {
                waitForPresenceOf(documentCalendar);
            } catch (Exception ex) {
                setPostponedTestFail("Элемент Календарь не отобразился");
                return this;
            }
            backward = findElementByNoThrow(documentCalendar, By.id("back"));
        }
        WebElement forward = findElementByNoThrow(documentCalendar, By.id("forward"));
        WebElement displayedMonth = findElementByNoThrow(documentCalendar, By.xpath(".//div[contains(@class, 'displayed') and contains(@class, 'month-block')]"));
        WebElement title = findElementByNoThrow(displayedMonth, By.cssSelector(".clearfix"));
        String month = findElementByNoThrow(title, By.id("monthName")).getText().toLowerCase();
        String year = findElementByNoThrow(title, By.id("year")).getText();
        postponedAssertTrue(month.contains("январь") && year.contains("2013"), "Не верная дата на первой странице календаря");
        postponedAssertTrue(forward.isEnabled(), "На самой ранней странице календаря нет отображается кнопка '>' ");
        getHelper(DictionaryPageHelper.class).checkCalendarNavigation(urlCheck[0]);
        return this;
    }

    @Step("Проверяется последняя страница блока 'Календарь'")
    public UssDictionaryPage checkLastCalendarPage() {
        WebElement forward = findElementByNoThrow(documentCalendar, By.id("forward"));
        String[] urlCheck = getCurrentUrl().split("=");
        while (!findElementByNoThrow(documentCalendar, By.id("forward")).getAttribute("class").contains("disabled")) {
            forward.click();
            try {
                waitForPresenceOf(documentCalendar);
            } catch (Exception ex) {
                setPostponedTestFail("Элемент Календарь не отобразился");
                return this;
            }
            forward = findElementByNoThrow(documentCalendar, By.id("forward"));
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

    public UssDictionaryPage checkDailyEvent() {
        getHelper(DictionaryPageHelper.class).checkDailyEvent();
        return this;
    }

    public UssDictionaryPage checkNumberOf() {
        getHelper(DictionaryPageHelper.class).checkNumberOf();
        return this;
    }

    private void checkLinksInAddressStickers() {
        WebElement addressSticker = waitForPresenceOfElementLocatedBy(By.cssSelector(".sticker_content_address"), "Стикер Адреса и телефоны судов не найден");
        List<WebElement> addressList = addressSticker.findElements(By.tagName("a"));
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement address : addressList) {
            String url = address.getAttribute("href");
            String header = address.getText();
            Link link = new Link(url, header);
            linkList.add(link);
        }
        checkLinks(linkList);
    }

    private void checkLinksInCurrencyStickers() {
        WebElement currencySticker = waitForPresenceOfElementLocatedBy(By.cssSelector(".sticker_content_currency-rate"), "Стикер Курс валют не найден");
        String url = currencySticker.findElement(By.tagName("a")).getAttribute("href");
        String header = currencySticker.findElement(By.tagName("a")).getText();
        checkLinks(Arrays.asList(new Link(url, header)));
        navigateToDictionaryPage();
    }

    private void checkLinksInRateStickers() {
        WebElement rateSticker = waitForPresenceOfElementLocatedBy(By.cssSelector(".sticker_content_manual"), "Стикер Ставка рефинансирования не найден");
        String url = rateSticker.findElement(By.tagName("a")).getAttribute("href");
        String header = rateSticker.findElement(By.tagName("a")).getText();
        checkLinks(Arrays.asList(new Link(url, header)));
        navigateToDictionaryPage();
    }

    private void checkAddressSticker() {
        WebElement addressSticker = waitForPresenceOfElementLocatedBy(By.cssSelector(".sticker_content_address"), "Стикер Адреса и телефоны судов не найден");
        String addressStickerText = addressSticker.getText().trim();
        postponedAssertFalse(addressStickerText.isEmpty(), "Стикер Адреса и телефоны судов пустой");
    }

    private void checkCurrencySticker() {
        WebElement currencySticker = waitForPresenceOfElementLocatedBy(By.cssSelector(".sticker_content_currency-rate"), "Стикер Курс валют не найден");
        String currencyStickerText = currencySticker.getText().trim();
        postponedAssertFalse(currencyStickerText.isEmpty(), "Стикер Курс валют пустой");
    }

    private void checkRateSticker() {
        WebElement rateSticker = waitForPresenceOfElementLocatedBy(By.cssSelector(".sticker_content_manual"), "Стикер 'Как работать с «СИСТЕМОЙ ЮРИСТ»' не найден");
        String rateStickerText = rateSticker.getText().trim();
        postponedAssertFalse(rateStickerText.isEmpty(), "Стикер Ставка рефинансирования пустой");
    }

    @Step("Проверяется отображение блока валют")
    public UssDictionaryPage checkDisplayCurrencyOnDictionaryBoard() {
        getHelper(DictionaryPageHelper.class).checkDisplayCurrencyOnDictionaryBoard();
        return this;
    }

    @Step("Проверяется содержимое блока ставка рефинансирования")
    public UssDictionaryPage checkRefinancingRateOnDictionaryBoard() {
        getHelper(DictionaryPageHelper.class).checkRefinancingRateOnDictionaryBoard();
        return this;
    }

    @Step("Проверяется отображение блока 'Адреса и телефоны судов'")
    public UssDictionaryPage checkDisplayAddressOnDictionaryBoard() {
        getHelper(DictionaryPageHelper.class).checkDisplayAddressOnDictionaryBoard();
        return this;
    }

    @Step("Проверяется содержимое блока 'Адреса и телефоны судов'")
    public UssDictionaryPage checkAddressOnDictionaryBoard() {
        WebElement widget = findElementByNoThrow(By.cssSelector(".sticker_content_address"));
        if (widget != null) {
            String title = findElementBy(widget, By.cssSelector(".sticker__title")).getText();
            postponedAssertEquals(title, "Адреса и телефоны судов", "Текст не совпадает");

            List<WebElement> texts = findElementsBy(widget, By.cssSelector(".sticker__text"));
            List<Link> links = new ArrayList<Link>();
            for (WebElement text : texts) {
                WebElement link = text.findElement(By.tagName("a"));
                String linkHead = link.getText();
                String linkUrl = link.getAttribute("href");
                links.add(new Link(linkUrl, linkHead));
            }
            postponedAssertEquals(links.get(0).getHeader(), "Арбитражных", "Текст не совпадает");
            postponedAssertEquals(links.get(1).getHeader(), "Апелляционных", "Текст не совпадает");
            postponedAssertEquals(links.get(2).getHeader(), "Суды округов и ВС", "Текст не совпадает");

            checkLinks(links);
        }
        return this;
    }

    @Step("Проверяется отображение блока 'Адреса и телефоны судов'")
    public UssDictionaryPage checkDisplayManualOnDictionaryBoard() {
        getHelper(DictionaryPageHelper.class).checkDisplayManualOnDictionaryBoard();
        return this;
    }

    @Step("Проверяется содержимое блока 'Адреса и телефоны судов'")
    public UssDictionaryPage checkManualOnDictionaryBoard() {
        WebElement widget = findElementBy(By.cssSelector(".sticker_content_manual"));
        String title = findElementBy(widget, By.cssSelector(".sticker__title")).getText();
        postponedAssertEquals(title, "КАК РАБОТАТЬ С СИСТЕМОЙ\n" +
                "ЮРИСТ", "Текст не совпадает");

        WebElement linkText = widget.findElement(By.cssSelector(".sticker__text")).findElement(By.tagName("a"));
        String linkHead = linkText.getText();
        String linkUrl = linkText.getAttribute("href");
        Link link = new Link(linkUrl, linkHead);
        postponedAssertEquals(linkHead, "инструкция", "Текст не совпадает");

        checkLink(link);
        return this;
    }

    @Step("Нажимается ссылка на календарь")
    public UssDictionaryPage clickFactoryCalendarLink() {
        getHelper(DictionaryPageHelper.class).clickFactoryCalendarLink();
        return this;
    }

}
