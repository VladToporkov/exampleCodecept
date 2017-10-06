package com.actionmedia.pages.fss;

import com.actionmedia.autotest.selenium.annotations.ErrorMessage;
import com.actionmedia.autotest.selenium.context.ComponentProvider;
import com.actionmedia.components.Link;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.RightPanel;
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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 05.11.13
 * Time: 10:53
 */
@Component
public class FssDictionaryPage extends FssBasePage<FssDictionaryPage> implements ComponentProvider, IDictionaryPage {

    @FindBy(css = ".widget_content_calendar")
    @CacheLookup
    @ErrorMessage("Не найден календарь")
    protected WebElement documentCalendar;

    private RightPanel rightPanel;

    @Override
    public void handleRedirect() {
        super.handleRedirect();
        rightPanel = getHelper(RightPanel.class, this);
    }

    @Step("Проверяются элементы на странице 'Справочник'")
    public FssDictionaryPage checkDefaultStateDictionaryPage() {
        checkDictionaryTabIsSelected();
        checkSearchBoxPresentOnDictionaryPage();
        checkDictionaryBlockIsPresent();
        checkHeaderDefaultState();
        checkNewsBlockIsPresent();
        checkNewsBlockIsNotEmpty();
        checkRubricatorMenuIsPresent();
        checkRubricatorMenuIsNotEmpty();
        checkPopularBlockIsPresent();
        checkPopularBlockIsNotEmpty();
        checkDictionaryBlock();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Справочник'")
    public FssDictionaryPage checkDictionaryTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.FSS_DICTIONARY);
        return this;
    }

    @Step("Проверяется заголовок страницы 'Справочник'")
    public FssDictionaryPage checkHeaderDefaultState() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement docBody = content.findElement(By.cssSelector(".doc-body"));
        WebElement header = findElementByNoThrow(docBody, By.tagName("h2"));
        assertNotNull(header, "Заголовок страницы 'Справочник' не найден");
        postponedAssertTrue(header.isDisplayed(), "Заголовок страницы 'Справочник' не отображается");
        postponedAssertEquals(header.getText().trim(), "НОВОЕ В СПРАВОЧНИКЕ", "Неправильный текст заголовка страницы 'Справочник'");
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Справочник'")
    public FssDictionaryPage checkSearchBoxPresentOnDictionaryPage() {
        checkSearchBoxIsPresent("Поиск справочной информации");
        return this;
    }

    @Step("Проверяется что Блок Справочник отображается")
    public FssDictionaryPage checkDictionaryBlockIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement dictionaryBlock = findElementByNoThrow(content, By.cssSelector(".doc-header"));
        assertNotNull(dictionaryBlock, "Блок Справочник не найден");
        postponedAssertTrue(dictionaryBlock.isDisplayed(), "Блок Справочник не отображается");
        return this;
    }

    @Step("Проверяется что блок Новое на странице 'Справочник' отображается")
    public FssDictionaryPage checkNewsBlockIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement newsBlock = findElementByNoThrow(content, By.id("main-article"));
        assertNotNull(newsBlock, "Блок Новое на странице 'Справочник' не найден");
        postponedAssertTrue(newsBlock.isDisplayed(), "Блок Новое на странице 'Справочник' не отображается");
        return this;
    }

    @Step("Проверяется что блок Новое на странице 'Справочник' не пустой")
    public FssDictionaryPage checkNewsBlockIsNotEmpty() {
        WebElement newsBlock = waitForVisibilityOfElementLocatedBy(By.id("main-article"));
        List<WebElement> newsItemList = newsBlock.findElements(By.cssSelector(".b-news"));
        postponedAssertFalse(newsItemList.isEmpty(), "Блок Новое на странице 'Справочник' пустой");
        return this;
    }

    @Step("Проверяется что меню Рубрикатора на странице 'Справочник' отображается")
    public FssDictionaryPage checkRubricatorMenuIsPresent() {
        WebElement content = waitForPresenceOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement rubricatorMenu = findElementByNoThrow(content, By.id("sidebar"));
        assertNotNull(rubricatorMenu, "Меню Рубрикатора на странице 'Справочник' не найдено");
        postponedAssertTrue(rubricatorMenu.isDisplayed(), "Меню Рубрикатора на странице 'Справочник' не отображается");
        return this;
    }

    @Step("Проверяется что меню Рубрикатора на странице 'Справочник' не пустое")
    public FssDictionaryPage checkRubricatorMenuIsNotEmpty() {
        List<WebElement> newsItemList = sidebarElement.findElements(By.tagName("li"));
        postponedAssertFalse(newsItemList.isEmpty(), "Меню Рубрикатора на странице 'Справочник' пустое");
        return this;
    }

    @Step("Проверяется что правая панель на странице 'Справочник' отображается")
    public FssDictionaryPage checkPopularBlockIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement rubricatorMenu = findElementByNoThrow(content, By.id("aside"));
        assertNotNull(rubricatorMenu, "Правая панель на странице 'Справочник' не найдена");
        postponedAssertTrue(rubricatorMenu.isDisplayed(), "Правая панель на странице 'Справочник' не отображается");
        return this;
    }

    @Step("Проверяется что правая панель на странице 'Справочник' не пустая")
    public FssDictionaryPage checkPopularBlockIsNotEmpty() {
        WebElement newsBlock = getCollapsedRightPanel();
        List<WebElement> newsItemList = newsBlock.findElements(By.cssSelector(".go"));
        postponedAssertFalse(newsItemList.isEmpty(), "Правая панель на странице 'Справочник' пустая");
        return this;
    }

    @Step("Проверяется Блок Справочник")
    public FssDictionaryPage checkDictionaryBlock() {
        WebElement dictionaryBlock = waitForVisibilityOfElementLocatedBy(By.cssSelector(".doc-header"));
        String header = dictionaryBlock.findElement(By.tagName("h1")).getText();
        postponedAssertEquals(header, "СПРАВОЧНИК", "Неправильный текст заголовка блока Справочник");

        WebElement widgetBlock = findElementByNoThrow(dictionaryBlock, By.cssSelector(".handbook"));
        assertNotNull(widgetBlock, "Блок виджетов не не найден в Блоке Справочник");
        List<WebElement> widgetList = widgetBlock.findElements(By.tagName("li"));
        postponedAssertFalse(widgetList.isEmpty(), "Список виджетов пуст");

        WebElement scrollElement = findElementByNoThrow(dictionaryBlock, By.cssSelector(".b-switch-list"));
        assertNotNull(scrollElement, "Скролл не найден в Блоке Справочник");
        List<WebElement> scrollList = scrollElement.findElements(By.tagName("li"));
        postponedAssertFalse(scrollList.isEmpty(), "Элементы скролла не найдены");
        return this;
    }

    @Step("Проверяется начальное состояние виджетов")
    public FssDictionaryPage checkFirstScreenInWidgetIsDisplayed() {
        WebElement dictionaryBlock = waitForVisibilityOfElementLocatedBy(By.cssSelector(".doc-header"));
        WebElement widgetBlock = dictionaryBlock.findElement(By.cssSelector(".handbook"));
        List<WebElement> widgetList = widgetBlock.findElements(By.tagName("li"));
        WebElement scrollElement = dictionaryBlock.findElement(By.cssSelector(".b-switch-list"));
        List<WebElement> scrollList = scrollElement.findElements(By.tagName("li"));

        postponedAssertTrue("selected".equals(scrollList.get(0).findElement(By.tagName("a")).getAttribute("class")), "Выбран не первый экран в виджетах");

        String startOffsetString = TestUtils.getOffset(widgetBlock.findElement(By.tagName("ul")));
        int startOffset = Integer.parseInt(startOffsetString);
        postponedAssertTrue(startOffset == 0, "Неправильное начальное положение виджетов");

        postponedAssertTrue(widgetList.get(0).isDisplayed(), "Виджет Календарь не отображается до скролла");
        postponedAssertTrue(widgetList.get(1).isDisplayed(), "Виджет Курс валют не отображается до скролла");
        postponedAssertFalse(widgetList.get(2).isDisplayed(), "Виджет Формула отображается до скролла");
        postponedAssertFalse(widgetList.get(3).isDisplayed(), "Виджет Цифра отображается до скролла");
        return this;
    }

    @Step("Проверяется состояние виджетов после скролла")
    public FssDictionaryPage checkSecondScreenInWidgetIsDisplayed() {
        WebElement dictionaryBlock = waitForVisibilityOfElementLocatedBy(By.cssSelector(".doc-header"));
        WebElement widgetBlock = dictionaryBlock.findElement(By.cssSelector(".handbook"));
        List<WebElement> widgetList = widgetBlock.findElements(By.tagName("li"));
        WebElement scrollElement = dictionaryBlock.findElement(By.cssSelector(".b-switch-list"));
        List<WebElement> scrollList = scrollElement.findElements(By.tagName("li"));

        postponedAssertTrue("selected".equals(scrollList.get(1).findElement(By.tagName("a")).getAttribute("class")), "Выбран не второй экран в виджетах");

        String endOffsetString = TestUtils.getOffset(widgetBlock.findElement(By.tagName("ul")));
        int endOffset = Integer.parseInt(endOffsetString);
        postponedAssertTrue(0 > endOffset, "Неправильное положение виджетов после скролла");

        postponedAssertTrue(widgetList.get(0).isDisplayed(), "Виджет Календарь отображается после скролла");
        postponedAssertTrue(widgetList.get(1).isDisplayed(), "Виджет Курс валют не отображается после скролла");
        postponedAssertTrue(widgetList.get(2).isDisplayed(), "Виджет Формула не отображается после скролла");
        postponedAssertTrue(widgetList.get(3).isDisplayed(), "Виджет Цифра не отображается после скролла");
        return this;
    }

    public FssDictionaryPage checkLinksFromNewsBlock() {
        getHelper(FssHelpers.class).checkLinksFromNewsBlock();
        return this;
    }

    public FssDictionaryPage checkNewsBlockScrolling() {
        getHelper(FssHelpers.class).checkNewsBlockScrolling(Period.month);
        return this;
    }

    public FssDictionaryPage checkDateAreSortedDescending() {
        getHelper(FssHelpers.class).checkDateAreSortedDescending();
        return this;
    }

    public FssDictionaryPage checkNewsBlockAreNotRepeat() {
        getHelper(FssHelpers.class).checkNewsBlockAreNotRepeat();
        return this;
    }

    public FssDictionaryPage checkNewsAreNotEmpty() {
        getHelper(FssHelpers.class).checkNewsAreNotEmpty();
        return this;
    }

    public FssDictionaryPage clickExtendPopularBlock() {
        getHelper(FssHelpers.class).clickExtendPopularBlock();
        return this;
    }

    @Step("Открыть раздел Популярное в правой панели")
    public FssDictionaryPage clickPopularTab() {
        rightPanel.clickPopularTabInExpanded();
        return this;
    }

    @Step("Открыть раздел Просмотренное в правой панели")
    public FssDictionaryPage clickViewedTab() {
        rightPanel.clickViewedTabInExpanded();
        return this;
    }

    @Step("Закрыть правую панель")
    public FssDictionaryPage closePopularBlock() {
        rightPanel.closePopularBlock();
        return this;
    }

    @Step("Проверяется работа ссылок из раздела Просмотренное в правой панели")
    public FssDictionaryPage checkRandomLinksFromExpandedViewedBlock() {
        clickExtendPopularBlock();
        clickViewedTab();
        List<Link> linkList = getRandomElementsInList(rightPanel.getLinks(), 3);
        for (Link link : linkList) {
            checkLink(link);
            clickExtendPopularBlock();
            clickViewedTab();
        }
        return this;
    }

    @Step("Проверяется работа ссылок из раздела Популярное в правой панели")
    public FssDictionaryPage checkRandomLinksFromExpandedPopularBlock() {
        clickExtendPopularBlock();
        clickPopularTab();
        List<Link> linkList = getRandomElementsInList(rightPanel.getLinks(), 3);
        for (Link link : linkList) {
            checkLink(link);
            clickExtendPopularBlock();
            clickPopularTab();
        }
        return this;
    }

    @Step("Проверяются фильтры в правой панели")
    public FssDictionaryPage checkFiltersInRightPanel() {
        clickExtendPopularBlock();
        clickViewedTab();
        rightPanel.checkDateFilters();
        return this;
    }

    @Step("Выбрать второй экран в виджетах")
    public FssDictionaryPage clickSecondScreenInWidgets() {
        WebElement scrollElement = waitForVisibilityOfElementLocatedBy(By.cssSelector(".b-switch-list"));
        List<WebElement> scrollList = scrollElement.findElements(By.tagName("li"));
        scrollList.get(1).findElement(By.tagName("a")).click();
        waitFewSecond(1000);
        return this;
    }

    @Step("Выбрать первый экран в виджетах")
    public FssDictionaryPage clickFirstScreenInWidgets() {
        WebElement scrollElement = waitForVisibilityOfElementLocatedBy(By.cssSelector(".b-switch-list"));
        List<WebElement> scrollList = scrollElement.findElements(By.tagName("li"));
        scrollList.get(0).findElement(By.tagName("a")).click();
        waitFewSecond(1000);
        return this;
    }

    @Step("Проверяется виджет календаря")
    public FssDictionaryPage checkCalendarWidget() {
        WebElement widget = waitForVisibilityOfElementLocatedBy(By.cssSelector(".handbook"));
        WebElement dateElement = findElementByNoThrow(widget, By.cssSelector(".b_calendar_date"));
        assertNotNull(dateElement, "Текущая дата не найдена в виджете календаря");
        postponedAssertTrue(dateElement.isDisplayed(), "Текущая дата не отображается в виджете календаря");

        WebElement daysInfoElement = findElementByNoThrow(widget, By.cssSelector(".b_calendar_info"));
        assertNotNull(daysInfoElement, "Информция о рабочих днях не найдена в виджете календаря");
        postponedAssertTrue(daysInfoElement.isDisplayed(), "Информция о рабочих днях не отображается в виджете календаря");

        int date = TestUtils.parseDate(dateElement.findElement(By.cssSelector(".date")).getText(), "dd").getDate();
        int month = TestUtils.parseDate(dateElement.findElement(By.cssSelector(".month")).getText(), "MMM").getMonth();
        int dayOfWeek = TestUtils.parseDate(dateElement.findElement(By.cssSelector(".day")).getText(), "EEE").getDay();

        Date currentDate = new Date();
        postponedAssertTrue(date == currentDate.getDate(), "Неправильный день месяца");
        postponedAssertTrue(month == currentDate.getMonth(), "Неправильный месяц");
        postponedAssertTrue(dayOfWeek == currentDate.getDay(), "Неправильный день недели");
        return this;
    }

    @Step("Проверяется виджет курса валют")
    public FssDictionaryPage checkCurrencyWidget() {
        WebElement widget = waitForVisibilityOfElementLocatedBy(By.cssSelector(".handbook"));
        WebElement currencyWidget = widget.findElements(By.tagName("li")).get(1);
        postponedAssertTrue(currencyWidget.isDisplayed(), "Виджет курса валют не отображается");

        String header = currencyWidget.findElement(By.cssSelector(".underline")).getText();
        postponedAssertEquals(header, "КУРС ВАЛЮТ", "Неправильный текст заголовка виджета курса валют");

        String currency = currencyWidget.findElement(By.cssSelector(".info-text")).getText();
        postponedAssertFalse(currency.isEmpty(), "Виджет круса валют пустой");
        postponedAssertTrue(currency.contains("USD"), "Отсутствует курс для USD");
        postponedAssertTrue(currency.contains("EUR"), "Отсутствует курс для EUR");

        String date = currencyWidget.findElement(By.cssSelector(".small")).getText();
        Date actualDate = TestUtils.parseDate(date, "dd MMM yyyy");
        Date currentDate = new Date();

        postponedAssertTrue(actualDate.getDate() == currentDate.getDate(), "Неправильный день месяца");
        postponedAssertTrue(actualDate.getMonth() == currentDate.getMonth(), "Неправильный месяц");
        postponedAssertTrue(actualDate.getDay() == currentDate.getDay(), "Неправильный день недели");
        return this;
    }

    @Step("Проверяется виджет Формула")
    public FssDictionaryPage checkFormulaWidget() {
        WebElement widget = waitForVisibilityOfElementLocatedBy(By.cssSelector(".handbook"));
        WebElement formulaWidget = widget.findElements(By.tagName("li")).get(2);
        postponedAssertTrue(formulaWidget.isDisplayed(), "Виджет Формула не отображается");

        String header = formulaWidget.findElement(By.cssSelector(".underline")).getText();
        postponedAssertEquals(header, "ФОРМУЛА", "Неправильный текст заголовка виджета Формула");

        WebElement formulaImg = formulaWidget.findElement(By.cssSelector(".info-text")).findElement(By.tagName("img"));
        postponedAssertTrue(isImageLoaded(formulaImg), "Картинка с формулой не загрузилась в виджете Формула");
        return this;
    }

    @Step("Проверяется виджет Ставка рефинансирования")
    public FssDictionaryPage checkRateWidget() {
        WebElement widget = waitForVisibilityOfElementLocatedBy(By.cssSelector(".handbook"));
        WebElement rateWidget = widget.findElements(By.tagName("li")).get(3);
        postponedAssertTrue(rateWidget.isDisplayed(), "Виджет Ставки рефинансирования не отображается");

        String header = rateWidget.findElement(By.cssSelector(".underline")).getText();
        postponedAssertEquals(header, "ЦИФРА", "Неправильный текст заголовка виджета Ставки рефинансирования");

        String currency = rateWidget.findElement(By.cssSelector(".info-text")).getText();
        postponedAssertFalse(currency.isEmpty(), "Виджет Ставки рефинансирования пустой");

        String bottom = rateWidget.findElement(By.cssSelector(".small")).getText();
        postponedAssertEquals(bottom, "Ставка рефинансирования", "Неправильный текст названия виджета Ставки рефинансирования");
        return this;
    }

    @Step("Нажать на виджет календаря")
    public FssDocumentPage clickCalendarWidget() {
        clickWidgetByIndex(0);
        return redirectTo(FssDocumentPage.class);
    }

    @Step("Нажать на виджет курса валют")
    public FssDocumentPage clickCurrencyWidget() {
        clickWidgetByIndex(1);
        return redirectTo(FssDocumentPage.class);
    }

    @Step("Нажать на виджет Формула")
    public FssDocumentPage clickFormulaWidget() {
        clickWidgetByIndex(2);
        return redirectTo(FssDocumentPage.class);
    }

    @Step("Нажать на виджет Ставка рефинансирования")
    public FssDocumentPage clickRateWidget() {
        clickWidgetByIndex(3);
        return redirectTo(FssDocumentPage.class);
    }

    @Step("Проверяется открытие производственного календаря")
    public FssDictionaryPage checkFactoryCalendar() {
        clickUseJS(documentCalendar.findElement(By.cssSelector(".widget__in")));
        postponedAssertTrue(getCurrentUrl().contains("#/document/190/"), "Производственный календарь не открылся");
        return this;
    }

    public FssDictionaryPage checkCollapsedRightPanel() {
        getHelper(FssHelpers.class).checkCollapsedRightPanel(rightPanel);
        return this;
    }

    public FssDictionaryPage checkExpandedRightPanel() {
        getHelper(FssHelpers.class).checkExpandedRightPanel(rightPanel);
        return this;
    }

    public FssDictionaryPage checkRandomLinksFromCollapsedPopularTab() {
        getHelper(FssHelpers.class).checkRandomLinksFromCollapsedPopularTab(rightPanel);
        return this;
    }

    public FssDictionaryPage checkRandomLinksFromCollapsedViewedTab() {
        getHelper(FssHelpers.class).checkRandomLinksFromCollapsedViewedTab(rightPanel);
        return this;
    }

    @Step("Проверяется отображение Справочной доски")
    public FssDictionaryPage checkDictionaryBoardIsDisplayed() {
        getHelper(DictionaryPageHelper.class).checkDictionaryBoardIsDisplayed();
        return this;
    }

    @Step("Проверяется отображение элементов Справочной доски")
    public FssDictionaryPage checkElementsOnDictionaryBoard() {
        getHelper(DictionaryPageHelper.class).checkCalendarOnDictionaryBoard();
        getHelper(DictionaryPageHelper.class).checkDisplayCurrencyOnDictionaryBoard();
        getHelper(DictionaryPageHelper.class).checkDisplayKeyRateOnDictionaryBoard();
        getHelper(DictionaryPageHelper.class).checkDisplayFormulaOnDictionaryBoard();
        return this;
    }

    @Step("Проверяется отображение новостной ленты")
    public FssDictionaryPage checkDictionaryNewsBlockIsDisplayed() {
        getHelper(DictionaryPageHelper.class).checkDictionaryNewsBlockIsDisplayed();
        return this;
    }

    @Step("Проверяется отображение блока 'Популярное'")
    public FssDictionaryPage checkPopularBlockIsDisplayed() {
        getHelper(DictionaryPageHelper.class).checkPopularBlockIsDisplayed();
        return this;
    }

    @Step("Проверяется отображение кнопки рубрикатора 'Весь справочник'")
    public FssDictionaryPage checkAllDictionaryRubricatorButtonIsPresent() {
        getHelper(DictionaryPageHelper.class).checkAllDictionaryRubricatorButtonIsPresent();
        return this;
    }

    @Step("Проверяется отображение 'Помошников'")
    public FssDictionaryPage checkFssAssistantButtonIsPresent() {
        WebElement assistants = findElementByNoThrow(By.cssSelector(".helpers"));
        WebElement kbk = findElementByNoThrow(assistants, By.cssSelector(".ico_content_kbk"));
        WebElement oktmo = findElementByNoThrow(assistants, By.cssSelector(".ico_content_oktmo"));
        WebElement currency = findElementByNoThrow(assistants, By.xpath("//a[text()='Курсы валют']"));
        postponedAssertTrue(assistants != null && assistants.isDisplayed(), "Блок'Помощники' не отображается ");
        postponedAssertTrue(assistants.getText().contains("Помощники"), "Неправильный заголовок блока 'Помощники'");
        postponedAssertTrue(kbk != null && kbk.isDisplayed(), "'Узнай верный КБК' не отображается");
        postponedAssertTrue(oktmo != null && oktmo.isDisplayed(), "'Узнай верный ОКТМО' не отображается");
        postponedAssertTrue(currency != null && currency.isDisplayed(), "'Курсы валют' не отображается");
        return this;
    }

    @Step("Проверяется дата в календаре")
    public FssDictionaryPage checkDateOnCalendar() {
        getHelper(DictionaryPageHelper.class).checkToDayDate();
        return this;
    }

    @Step("Проверяется отображение календаря за текущий месяц")
    public FssDictionaryPage checkMonthCalendar() {
        getHelper(DictionaryPageHelper.class).checkMonthCalendar();
        return this;
    }

    @Step("Проверяется отображение праздников и выходных в календаре")
    public FssDictionaryPage checkRedDays() {
        getHelper(DictionaryPageHelper.class).checkRedDays();
        return this;
    }

    @Step("Проверяется отображение таблицы календарных дней")
    public FssDictionaryPage checkMonthDayTable() {
        getHelper(DictionaryPageHelper.class).checkMonthDayTable();
        return this;
    }

    @Step("Проверяется отображение таблицы календарных дней")
    public FssDictionaryPage checkMonthHourTable() {
        getHelper(DictionaryPageHelper.class).checkMonthHourTable();
        return this;
    }

    @Step("Проверяется блок новостей новостной ленты")
    public FssDictionaryPage checkNewsList() {
        getHelper(DictionaryPageHelper.class).checkDatesInDescendingOrderInNewsList();
        getHelper(DictionaryPageHelper.class).checkNewsBlocks();
        return this;
    }

    @Step("Проверяется подгрузка блока новостей новостной ленты")
    public FssDictionaryPage checkScrollNewsList() {
        scrollScript(1000);
        getHelper(DictionaryPageHelper.class).checkDatesInDescendingOrderInNewsList();
        return this;
    }

    @Step("Проверяется работа ссылок в блоке Популярное")
    public FssDictionaryPage checkPopularFormLinks() {
        getHelper(DictionaryPageHelper.class).checkPopularFormLinks();
        return this;
    }

    public FssDictionaryPage checkTitle() {
        getHelper(DictionaryPageHelper.class).checkTitle();
        return this;
    }

    public FssDictionaryPage checkCalendarBlock() {
        getHelper(DictionaryPageHelper.class).checkCalendarBlock();
        return this;
    }

    public FssDictionaryPage checkHolydays() {
        getHelper(DictionaryPageHelper.class).checkHolydays();
        return this;
    }

    public FssDictionaryPage checkEventsTitle() {
        getHelper(DictionaryPageHelper.class).checkEventsTitle();
        return this;
    }

    @Step("Проверяется отображение блока 'События'")
    public FssDictionaryPage checkEvents() {
        WebElement events = findElementByNoThrow(By.id("task-block"));
        WebElement column = findElementByNoThrow(events, By.xpath(".//tr"));
        if ((events != null) && (column != null)) {
            List<WebElement> columnTitle = findElementsByNoThrow(column, By.tagName("th"));
            for (int i = 0; i < (columnTitle.size() - 1); i++) {
                postponedAssertTrue(columnTitle.get(i).getText().contains("Не забыть") || columnTitle.get(i).getText().contains("Что сделать")
                        || columnTitle.get(i).getText().contains("Комментарий"), "Неверное наименование колонок блока 'События' " + columnTitle);
            }
        } else {
            setPostponedTestFail("Элемент 'Блок События' не найден");
        }
        return this;
    }

    public FssDictionaryPage checkRubricatorButtonIsPresent(String buttonName) {
        getHelper(DocumentHelper.class).checkRubricatorButtonIsPresent(buttonName);
        return this;
    }

    public FssDictionaryPage checkDisplayStars() {
        getHelper(DictionaryPageHelper.class).checkDisplayStars();
        return this;
    }

    public FssDictionaryPage checkNotDisplayStars() {
        getHelper(DictionaryPageHelper.class).checkNotDisplayStars();
        return this;
    }

    public FssDictionaryPage checkEventsBlock() {
        getHelper(DictionaryPageHelper.class).checkEventsBlock();
        return this;
    }

    public FssDictionaryPage checkFactoryCalendarBlock() {
        getHelper(DictionaryPageHelper.class).checkFactoryCalendarBlock();
        return this;
    }

    public FssDictionaryPage checkDates() {
        getHelper(DictionaryPageHelper.class).checkDates();
        return this;
    }

    public FssDictionaryPage checkCalendarInfoDays() {
        getHelper(DictionaryPageHelper.class).checkCalendarInfoDays();
        return this;
    }

    public FssDictionaryPage checkCalendarInfoHour() {
        getHelper(DictionaryPageHelper.class).checkCalendarInfoHour();
        return this;
    }

    public FssDictionaryPage checkCalendarWeekKoment() {
        getHelper(DictionaryPageHelper.class).checkCalendarWeekKoment();
        return this;
    }

    public FssDictionaryPage checkNavigationButtons() {
        getHelper(DictionaryPageHelper.class).checkNavigationButtons();
        return this;
    }

    @Step("Проверяется навигация 'Вперед' блока 'Календарь'")
    public FssDictionaryPage checkCalendarNavigationForward() {
        documentCalendar = findElementByNoThrow(By.cssSelector(".calendar__in"));
        if (documentCalendar != null) {
            WebElement forward = findElementByNoThrow(documentCalendar, By.id("forward"));
            String[] urlCheck = getCurrentUrl().split("=");
            forward.click();
            waitForPresenceOf(documentCalendar);
            getHelper(DictionaryPageHelper.class).checkCalendarNavigation(urlCheck[0]);
        } else
            setPostponedTestFail("Календарь не отобразился");
        return this;
    }

    @Step("Проверяется навигация 'назад' блока 'Календарь'")
    public FssDictionaryPage checkCalendarNavigationBackward() {
        documentCalendar = findElementByNoThrow(By.cssSelector(".calendar__in"));
        if (documentCalendar != null) {
            WebElement backward = findElementByNoThrow(documentCalendar, By.id("back"));
            String[] urlCheck = getCurrentUrl().split("=");
            backward.click();
            waitForPresenceOf(documentCalendar);
            getHelper(DictionaryPageHelper.class).checkCalendarNavigation(urlCheck[0]);
        } else
            setPostponedTestFail("Календарь не отобразился");
        return this;
    }

    @Step("Проверяется первая страница блока 'Календарь'")
    public FssDictionaryPage checkFirstCalendarPage() {
        documentCalendar = findElementByNoThrow(By.cssSelector(".calendar__in"));
        if (documentCalendar != null) {
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
        } else
            setPostponedTestFail("Календарь не отобразился");
        return this;
    }

    @Step("Проверяется последняя страница блока 'Календарь'")
    public FssDictionaryPage checkLastCalendarPage() {
        documentCalendar = findElementByNoThrow(By.cssSelector(".calendar__in"));
        if (documentCalendar != null) {
            WebElement forward = findElementByNoThrow(documentCalendar, By.id("forward"));
            String[] urlCheck = getCurrentUrl().split("=");
            while (!findElementByNoThrow(documentCalendar, By.id("forward")).getAttribute("class").contains("disabled")) {
                forward.click();
                waitForReloadingPage();
                documentCalendar = findElementByNoThrow(By.cssSelector(".calendar__in"));
                if (documentCalendar == null) {
                    setPostponedTestFail("Не удалось докликать до конца календаря");
                    return navigateToDictionaryPage().checkFactoryCalendar();
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
        } else
            setPostponedTestFail("Календарь не отобразился");
        return this;
    }

    public FssDictionaryPage checkDailyEvent() {
        getHelper(DictionaryPageHelper.class).checkDailyEvent();
        return this;
    }

    public FssDictionaryPage checkNumberOf() {
        getHelper(DictionaryPageHelper.class).checkNumberOf();
        return this;
    }

    private void clickWidgetByIndex(int index) {
        WebElement widgetList = waitForVisibilityOfElementLocatedBy(By.cssSelector(".handbook"));
        WebElement widget = widgetList.findElements(By.tagName("li")).get(index);
        WebElement widgetLink = widget.findElement(By.tagName("a"));
        String url = widgetLink.getAttribute("href");
        setParameter(DOCUMENT_URL, url);
        widgetLink.click();
    }

    @Step("Проверяется отображение блока валют")
    public FssDictionaryPage checkDisplayCurrencyOnDictionaryBoard() {
        getHelper(DictionaryPageHelper.class).checkDisplayCurrencyOnDictionaryBoard();
        return this;
    }

    @Step("Проверяется содержимое блока ставка рефинансирования")
    public FssDictionaryPage checkRefinancingRateOnDictionaryBoard() {
        getHelper(DictionaryPageHelper.class).checkRefinancingRateOnDictionaryBoard();
        return this;
    }

    @Step("Проверяется отображение блока Ключевая ставка")
    public FssDictionaryPage checkDisplayKeyRateOnDictionaryBoard() {
        getHelper(DictionaryPageHelper.class).checkDisplayKeyRateOnDictionaryBoard();
        return this;
    }

    @Step("Проверяется содержимое блока Ключевая ставка")
    public FssDictionaryPage checkKeyRateOnDictionaryBoard() {
        WebElement widget = findElementByNoThrow(By.cssSelector(".sticker_content_key-rate"));
        if (widget != null) {
            String titleText = widget.findElement(By.cssSelector(".sticker__title")).findElement(By.cssSelector(".sticker-key-rate-date")).getText();
            postponedAssertTrue(titleText != null && !titleText.isEmpty(), "Нет даты изменения ключевой даты");

            WebElement linkText = widget.findElement(By.cssSelector(".sticker__title")).findElement(By.tagName("a"));
            String linkHead = linkText.getText();
            String linkUrl = linkText.getAttribute("href");
            Link link = new Link(linkUrl, linkHead);
            postponedAssertEqualsText(linkText, "Ключевая ставка");

            String rate = widget.findElement(By.cssSelector(".sticker__text")).getTagName();
            postponedAssertTrue(rate != null && !rate.isEmpty(), "Не отображается ключевая ставка");

            checkLink(link);
        }
        return this;
    }

    @Step("Проверяется отображение блока Формула")
    public FssDictionaryPage checkDisplayFormulaOnDictionaryBoard() {
        getHelper(DictionaryPageHelper.class).checkDisplayFormulaOnDictionaryBoard();
        return this;
    }

    @Step("Проверяется содержимое блока Формула")
    public FssDictionaryPage checkFormulaOnDictionaryBoard() {
        WebElement widget = findElementByNoThrow(By.cssSelector(".sticker_content_formula"));
        if (widget != null) {
            WebElement title = widget.findElement(By.cssSelector(".sticker__title"));
            postponedAssertEqualsText(title, "Формула");

            WebElement linkText = widget.findElement(By.cssSelector(".sticker__text")).findElement(By.tagName("a"));
            String linkHead = linkText.getText();
            String linkUrl = linkText.getAttribute("href");
            Link link = new Link(linkUrl, linkHead);
            postponedAssertEqualsText(linkText, "Расчет показателя EVA");

            String img = widget.findElement(By.cssSelector(".sticker__image_content_formula")).getCssValue("background-image");
            postponedAssertTrue(img != null && !img.isEmpty(), "Не найдена картинка");

            checkLink(link);
        }
        return this;
    }

    @Step("Проверяется содержимое блока Помощник")
    public FssDictionaryPage checkHelperOnDictionaryBoard() {
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
    public FssDictionaryPage clickFactoryCalendarLink() {
        getHelper(DictionaryPageHelper.class).clickFactoryCalendarLink();
        return this;
    }
}
