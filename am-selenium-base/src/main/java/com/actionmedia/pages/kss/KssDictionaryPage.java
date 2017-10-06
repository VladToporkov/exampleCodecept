package com.actionmedia.pages.kss;

import com.actionmedia.autotest.selenium.annotations.ErrorMessage;
import com.actionmedia.autotest.selenium.annotations.Wait;
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

@Component
public class KssDictionaryPage extends KssBasePage<KssDictionaryPage> implements IDictionaryPage {

    @FindBy(css = ".calendar__in")
    @Wait
    @CacheLookup
    @ErrorMessage("Не найден элемент с class = b-calendar-center")
    protected WebElement documentCalendar;

    @Step("Проверяются элементы на странице 'Справочники'")
    public KssDictionaryPage checkDefaultStateDictionaryPage() {
        checkDictionaryTabIsSelected();
        checkSearchBoxPresentOnDictionaryPage();
        checkDictionaryBoardIsDisplayed();
        checkNewBlock();
        checkPopularBlocks();
        checkAllDictionaryRubricatorButtonIsPresent();
        checkMyFavoritesRubricatorButtonIsPresent();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Справочник'")
    public KssDictionaryPage checkDictionaryTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.DICTIONARY);
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Справочник'")
    public KssDictionaryPage checkSearchBoxPresentOnDictionaryPage() {
        checkSearchBoxIsPresent("Поиск справочной информации");
        return this;
    }

    @Step("Проверяется блок 'Новое' на странице 'Справочник'")
    public KssDictionaryPage checkNewBlock() {
        List<WebElement> newBlocks = mainLeftElement.findElements(By.cssSelector("[class*='changes']"));
        postponedAssertFalse(newBlocks.isEmpty(), "Блок Новое пустой");
        return this;
    }

    @Step("Проверяется блок 'Популярное' на странице 'Справочник'")
    public KssDictionaryPage checkPopularBlocks() {
        List<WebElement> popularBlocks = sidebarElement.findElements(By.cssSelector(".news__item"));
        postponedAssertFalse(popularBlocks.isEmpty(), "Блок Популярное пустой");
        return this;
    }

    @Step("Проверяется что справочная доска отображается")
    public KssDictionaryPage checkDictionaryBoardIsDisplayed() {
        getHelper(DictionaryPageHelper.class).checkDictionaryBoardIsDisplayed();
        return this;
    }

    @Step("Проверяется что кнопка рубрикатора весь справочник отображается")
    public KssDictionaryPage checkAllDictionaryRubricatorButtonIsPresent() {
        getHelper(DictionaryPageHelper.class).checkAllDictionaryRubricatorButtonIsPresent();
        return this;
    }

    @Step("Проверяются элементы на странице Справочник")
    public KssDictionaryPage checkElementsOnDictionaryBoard() {
        getHelper(DictionaryPageHelper.class).checkCalendarOnDictionaryBoard();
        getHelper(DictionaryPageHelper.class).checkDisplayMrotOnDictionaryBoard();
        getHelper(DictionaryPageHelper.class).checkDisplayPostOnDictionaryBoard();
        getHelper(DictionaryPageHelper.class).checkDisplayCurrencyOnDictionaryBoard();
        return this;
    }

    @Step("Проверяется дата в календаре")
    public KssDictionaryPage checkDateOnCalendar() {
        getHelper(DictionaryPageHelper.class).checkToDayDate();
        return this;
    }

    @Step("Проверяются элементы на справочной доске")
    public KssDictionaryPage checkStickersArePresent() {
        checkMrotSticker();
        checkCurrencySticker();
        checkJobCardSticker();
//        checkInformerSticker();
//        checkRateSticker();
        return this;
    }

    @Step("Проверяется работа ссылок в стикерах")
    public KssDictionaryPage checkLinksInStickers() {
        checkLinksInMrotStickers();
        checkLinksInCurrencyStickers();
        checkLinksInJobCardStickers();
//        checkLinksInInformerStickers();
//        checkLinksInRateStickers();
        return this;
    }

    @Step("Проверяется работа скролла в блоке Новое")
    public KssDictionaryPage checkNewsBlockScrolling() {
        List<WebElement> newsBeforeScroll = mainLeftElement.findElements(By.cssSelector("[class*='changes']"));
        postponedAssertFalse(newsBeforeScroll.isEmpty(), "Блок Новое пустой");

        scroll(Period.month, By.tagName("h2"));

        List<WebElement> newsAfterScroll = mainLeftElement.findElements(By.cssSelector("[class*='changes']"));
        postponedAssertTrue(newsAfterScroll.size() > newsBeforeScroll.size(), "Новости не подгружаются после скролла");
        return this;
    }

    @Step("Проверяется сортировка новостей по дате(от новых к старым)")
    public KssDictionaryPage checkDateAreSortedDescending() {
        List<WebElement> dateListElement = mainLeftElement.findElements(By.tagName("h2"));

        postponedAssertThat(dateListElement, TestUtils.sortedDatesWithoutYearInDescendingOrder(), "Элементы отсортированы в неправильном порядке");
        return this;
    }

    @Step("Проверяется что пустые новости не отображается")
    public KssDictionaryPage checkNewsAreNotEmpty() {
        List<WebElement> dateListElement = mainLeftElement.findElements(By.tagName("*"));
        for (int i = 0; i < dateListElement.size(); i++) {
            if ("h2".equals(dateListElement.get(i).getTagName())) {
                String dateString = dateListElement.get(i).getText();
                boolean isNewsNotEmpty = false;
                while (i + 1 < dateListElement.size() && !"h2".equals(dateListElement.get(i + 1).getTagName())) {
                    WebElement newsElement = dateListElement.get(i);
                    if (newsElement.getAttribute("class") != null && newsElement.getAttribute("class").contains("block-changes")) {
                        isNewsNotEmpty = true;
                        postponedAssertNotNull(findElementByNoThrow(newsElement, By.tagName("a")), "Отсутствует ссылка для новости за '" + dateListElement + "'");
                        postponedAssertTrue(newsElement.findElement(By.tagName("a")).getAttribute("href").contains("/#/document"), "Неправильный формат ссылки");
                        postponedAssertFalse(newsElement.findElement(By.tagName("a")).getText().isEmpty(), "Текст ссылки новости за '" + dateString + "' пустой");
                        postponedAssertTrue(newsElement.findElement(By.tagName("a")).isDisplayed(), "Ссылка для новости за '" + dateString + "' не отображается");
                    }
                    i++;
                }
                postponedAssertTrue(isNewsNotEmpty, "Блок новое для '" + dateString + "' пустой");
            }
        }
        return this;
    }

    @Step("Проверяется что новости не повторяются")
    public KssDictionaryPage checkNewsBlockAreNotRepeat() {
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
    public KssDictionaryPage checkNewsBlockLinks() {
        List<WebElement> newsTitleList = mainLeftElement.findElements(By.tagName("dt"));
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
    public KssDictionaryPage checkPopularBlockIsDisplayed() {
        getHelper(DictionaryPageHelper.class).checkPopularBlockIsDisplayed();
        return this;
    }

    @Step("Проверяется что блок Популярное не пустой")
    public KssDictionaryPage checkPopularBlockAreNotEmpty() {
        List<WebElement> popularForms = sidebarElement.findElements(By.cssSelector(".news__item"));
        postponedAssertFalse(popularForms.isEmpty(), "Блок Популярное пустой");

        for (WebElement popularForm : popularForms) {
            postponedAssertFalse(popularForm.getText().isEmpty(), "Отсутствует текст для формы в блоке Популярное");
        }
        return this;
    }

    @Step("Проверяется работа ссылок в блоке Популярное")
    public KssDictionaryPage checkPopularFormLinks() {
        getHelper(DictionaryPageHelper.class).checkPopularFormLinks();
        return this;
    }

    @Step("Проверяется что результаты поиска отсутсвуют")
    public KssDictionaryPage checkSearchResultIsNotPresentOnDictionaryPage() {
        checkSearchResultIsNotPresentOnPage();
        return this;
    }

    @Step("Нажать кнопку Найти")
    public KssDictionaryPage clickSearchButtonOnDictionaryPage() {
        clickSearchButton();
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются")
    public KssDictionaryPage checkHintsIsPresent() {
        checkHintListIsPresent();
        return this;
    }

    @Step("Нажать подсказку с прямым переходом")
    public KssSearchResultPage clickHintWithJumpOnDictionaryPage() {
        clickHintWithJump();
        return redirectTo(KssSearchResultPage.class);
    }

    @Step("Нажать любую подсказку с переходом")
    public KssSearchResultPage clickRandomHintOnDictionaryPage() {
        clickRandomHint();
        return redirectTo(KssSearchResultPage.class);
    }

    @Step("Открыть любой документ из блока популярное")
    public KssDictionaryPage clickRandomDocumentLink() {
        WebElement popularContent = waitForPresenceOfElementLocatedBy(By.cssSelector("#sidebar .news"));
        List<WebElement> popularNews = popularContent.findElements(By.tagName("a"));
        getRandomElementInList(popularNews).click();
        waitForReloadingPage();
        return this;
    }

    @Step("Проверяется работа кнопки Найти на странице Справочник")
    public KssDictionaryPage checkSearchButtonFunctionalityOnSearchBox(String query) {
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

    @Step("Проверяется отображение новостной ленты и заголовка новостной ленты")
    public KssDictionaryPage checkDictionaryNewsBlockIsDisplayed() {
        getHelper(DictionaryPageHelper.class).checkDictionaryNewsBlockIsDisplayed();
        return this;
    }

    @Step("Проверяется отображение календаря за текущий месяц")
    public KssDictionaryPage checkMonthCalendar() {
        getHelper(DictionaryPageHelper.class).checkMonthCalendar();
        return this;
    }

    @Step("Проверяется отображение праздников и выходных в календаре")
    public KssDictionaryPage checkRedDays() {
        getHelper(DictionaryPageHelper.class).checkRedDays();
        return this;
    }

    @Step("Проверяется отображение таблицы календарных дней")
    public KssDictionaryPage checkMonthDayTable() {
        getHelper(DictionaryPageHelper.class).checkMonthDayTable();
        return this;
    }

    @Step("Проверяется отображение таблицы календарных дней")
    public KssDictionaryPage checkMonthHourTable() {
        getHelper(DictionaryPageHelper.class).checkMonthHourTable();
        return this;
    }

    @Step("Проверяется открытие производственного календаря")
    public KssDictionaryPage checkFactoryCalendar() {
        getHelper(DictionaryPageHelper.class).checkFactoryCalendar();
        return this;
    }

    @Step("Нажимается ссылка на календарь")
    public KssDictionaryPage clickFactoryCalendarLink() {
        getHelper(DictionaryPageHelper.class).clickFactoryCalendarLink();
        return this;
    }

    @Step("Проверяется блок новостей новостной ленты")
    public KssDictionaryPage checkNewsList() {
        getHelper(DictionaryPageHelper.class).checkDatesInDescendingOrderInNewsList();
        getHelper(DictionaryPageHelper.class).checkNewsBlocks();
        return this;
    }

    @Step("Проверяется подгрузка блока новостей новостной ленты")
    public KssDictionaryPage checkScrollNewsList() {
        scrollScript(1000);
        getHelper(DictionaryPageHelper.class).checkDatesInDescendingOrderInNewsList();
        return this;
    }


    public KssDictionaryPage checkTitle() {
        getHelper(DictionaryPageHelper.class).checkTitle();
        return this;
    }

    public KssDictionaryPage checkCalendarBlock() {
        getHelper(DictionaryPageHelper.class).checkCalendarBlock();
        return this;
    }

    public KssDictionaryPage checkHolydays() {
        getHelper(DictionaryPageHelper.class).checkHolydays();
        return this;
    }

    public KssDictionaryPage checkEventsTitle() {
        getHelper(DictionaryPageHelper.class).checkEventsTitle();
        return this;
    }

    @Step("Проверяется отображение блока 'События'")
    public KssDictionaryPage checkEvents() {
        WebElement events = findElementByNoThrow(By.cssSelector("#document-body .js-table_content_scheduler-task"));
        WebElement column = findElementByNoThrow(events, By.xpath(".//tr"));
        if ((events != null) && (column != null)) {
            List<WebElement> columnTitle = findElementsByNoThrow(column, By.tagName("th"));
            for (WebElement title : columnTitle) {
                postponedAssertTrue(title.getText().contains("Событие") || title.getText().contains("Описание"), "Неверное наименование колонок блока 'События' " + title);
            }
        } else {
            setPostponedTestFail("Элемент 'Блок Событие' не найден");
        }
        return this;
    }

    public KssDictionaryPage checkRubricatorButtonIsPresent(String buttonName) {
        getHelper(DocumentHelper.class).checkRubricatorButtonIsPresent(buttonName);
        return this;
    }

    public KssDictionaryPage checkDisplayStars() {
        getHelper(DictionaryPageHelper.class).checkDisplayStars();
        return this;
    }

    public KssDictionaryPage checkNotDisplayStars() {
        getHelper(DictionaryPageHelper.class).checkNotDisplayStars();
        return this;
    }

    public KssDictionaryPage checkEventsBlock() {
        getHelper(DictionaryPageHelper.class).checkEventsBlock();
        return this;
    }

    public KssDictionaryPage checkDailyEvent() {
        getHelper(DictionaryPageHelper.class).checkDailyEvent();
        return this;
    }

    public KssDictionaryPage checkFactoryCalendarBlock() {
        getHelper(DictionaryPageHelper.class).checkFactoryCalendarBlock();
        return this;
    }

    public KssDictionaryPage checkDates() {
        getHelper(DictionaryPageHelper.class).checkDates();
        return this;
    }

    public KssDictionaryPage checkCalendarInfoDays() {
        getHelper(DictionaryPageHelper.class).checkCalendarInfoDays();
        return this;
    }

    public KssDictionaryPage checkCalendarInfoHour() {
        getHelper(DictionaryPageHelper.class).checkCalendarInfoHour();
        return this;
    }

    public KssDictionaryPage checkCalendarWeekKoment() {
        getHelper(DictionaryPageHelper.class).checkCalendarWeekKoment();
        return this;
    }

    public KssDictionaryPage checkNavigationButtons() {
        getHelper(DictionaryPageHelper.class).checkNavigationButtons();
        return this;
    }

    @Step("Проверяется навигация 'Вперед' блока 'Календарь'")
    public KssDictionaryPage checkCalendarNavigationForward() {
        WebElement forward = findElementByNoThrow(documentCalendar, By.id("forward"));
        String[] urlCheck = getCurrentUrl().split("=");
        forward.click();
        waitForPresenceOf(documentCalendar);
        getHelper(DictionaryPageHelper.class).checkCalendarNavigation(urlCheck[0]);
        return this;
    }

    @Step("Проверяется навигация 'назад' блока 'Календарь'")
    public KssDictionaryPage checkCalendarNavigationBackward() {
        WebElement backward = findElementByNoThrow(documentCalendar, By.id("back"));
        String[] urlCheck = getCurrentUrl().split("=");
        backward.click();
        waitForPresenceOf(documentCalendar);
        getHelper(DictionaryPageHelper.class).checkCalendarNavigation(urlCheck[0]);
        return this;
    }

    @Step("Проверяется первая страница блока 'Календарь'")
    public KssDictionaryPage checkFirstCalendarPage() {
        WebElement backward = findElementByNoThrow(documentCalendar, By.id("back"));
        String[] urlCheck = getCurrentUrl().split("=");
        while (!findElementByNoThrow(documentCalendar, By.id("back")).getAttribute("class").contains("disabled")) {
            backward.click();
            waitForPresenceOf(documentCalendar);
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
    public KssDictionaryPage checkLastCalendarPage() {
        WebElement forward = findElementByNoThrow(documentCalendar, By.id("forward"));
        String[] urlCheck = getCurrentUrl().split("=");
        while (!findElementByNoThrow(documentCalendar, By.id("forward")).getAttribute("class").contains("disabled")) {
            forward.click();
            waitForPresenceOf(documentCalendar);
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

    public KssDictionaryPage checkNumberOf() {
        getHelper(DictionaryPageHelper.class).checkNumberOf();
        return this;
    }

    private void checkLinksInRateStickers() {
        WebElement rateSticker = waitForPresenceOfElementLocatedBy(By.cssSelector(".rate"), "Не найден стикер Ставка рефинансирования");
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

    private void checkLinksInJobCardStickers() {
        WebElement mrotSticker = waitForPresenceOfElementLocatedBy(By.cssSelector(".sticker_content_post"), "Не найден стикер Карточка Должностей");
        String url = mrotSticker.findElement(By.tagName("a")).getAttribute("href");
        String header = mrotSticker.findElement(By.tagName("a")).getText();
        checkLinks(Arrays.asList(new Link(url, header)));
        navigateToDictionaryPage();
    }

    private void checkLinksInInformerStickers() {
        WebElement informerSticker = waitForPresenceOfElementLocatedBy(By.cssSelector(".salaries"), "Не найден стикер Информер зарплат");
        String url = informerSticker.findElement(By.tagName("a")).getAttribute("href");
        checkLinks(Arrays.asList(new Link(url)));
        navigateToDictionaryPage();
    }

    private void checkRateSticker() {
        WebElement rateSticker = waitForPresenceOfElementLocatedBy(By.cssSelector(".rate"), "Не найден стикер Ставка рефинансирования");
        String rateStickerText = rateSticker.getText().trim();
        postponedAssertFalse(rateStickerText.isEmpty(), "Стикер Ставка рефинансирования пустой");
    }

    private void checkCurrencySticker() {
        WebElement currencySticker = waitForPresenceOfElementLocatedBy(By.cssSelector(".sticker_content_currency"), "Не найден стикер Курс валют");
        String rateStickerText = currencySticker.getText().trim();
        postponedAssertFalse(rateStickerText.isEmpty(), "Стикер Курс валют пустой");
    }

    private void checkMrotSticker() {
        WebElement mrotSticker = waitForPresenceOfElementLocatedBy(By.cssSelector(".sticker_content_wage"), "Не найден стикер МРОТ");
        String rateStickerText = mrotSticker.getText().trim();
        postponedAssertFalse(rateStickerText.isEmpty(), "Стикер МРОТ пустой");
    }

    private void checkJobCardSticker() {
        WebElement mrotSticker = waitForPresenceOfElementLocatedBy(By.cssSelector(".sticker_content_post"), "Не найден стикер Карточка Должностей");
        String rateStickerText = mrotSticker.getText().trim();
        postponedAssertFalse(rateStickerText.isEmpty(), "Стикер МРОТ пустой");
    }

    private void checkInformerSticker() {
        WebElement informerSticker = waitForPresenceOfElementLocatedBy(By.cssSelector(".salaries"), "Не найден стикер Информер зарплат");
        WebElement img = informerSticker.findElement(By.tagName("img"));
        postponedAssertTrue(isImageLoaded(img), "Картинка не загрузилась для стикера Информер зарплат");
    }

    @Step("Проверяется отображения виджета МРОТ")
    public KssDictionaryPage checkDisplayMrotOnDictionaryBoard() {
        getHelper(DictionaryPageHelper.class).checkDisplayMrotOnDictionaryBoard();
        return this;
    }

    @Step("Проверяется содержание виджета МРОТ")
    public KssDictionaryPage checkTextMrotOnDictionaryBoard() {
        getHelper(DictionaryPageHelper.class).checkTextMrotOnDictionaryBoard();
        return this;
    }

    @Step("Проверяется отображение виджета 'Карточки должности'")
    public KssDictionaryPage checkDisplayPostOnDictionaryBoard() {
        getHelper(DictionaryPageHelper.class).checkDisplayPostOnDictionaryBoard();
        return this;
    }

    @Step("Проверяется содержание виджета 'Карточки должности'")
    public KssDictionaryPage checkPostOnDictionaryBoard() {
        getHelper(DictionaryPageHelper.class).checkPostOnDictionaryBoard();
        return this;
    }

    @Step("Проверяется отображение блока валют")
    public KssDictionaryPage checkDisplayCurrencyOnDictionaryBoard() {
        getHelper(DictionaryPageHelper.class).checkDisplayCurrencyOnDictionaryBoard();
        return this;
    }

    @Step("Проверяется содержимое блока ставка рефинансирования")
    public KssDictionaryPage checkRefinancingRateOnDictionaryBoard() {
        getHelper(DictionaryPageHelper.class).checkRefinancingRateOnDictionaryBoard();
        return this;
    }
}
