package com.actionmedia.pages.fss;

import com.actionmedia.autotest.selenium.SeleniumHolder;
import com.actionmedia.components.widgets.SearchWidgetBlock;
import com.actionmedia.components.widgets.Widget;
import com.actionmedia.components.widgets.lawbase.LaborWidget;
import com.actionmedia.components.widgets.lawbase.PopularWidget;
import com.actionmedia.components.widgets.lawbase.TaxWidget;
import com.actionmedia.pages.interfaces.ILawBasePage;
import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.autotest.selenium.context.ComponentProvider;
import com.actionmedia.autotest.selenium.elements.CheckBox;
import com.actionmedia.autotest.selenium.elements.TextField;
import com.actionmedia.components.Link;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.RightPanel;
import com.actionmedia.pages.helpers.LawBasePageHelper;
import com.actionmedia.pages.helpers.SearchResultHelper;
import com.actionmedia.util.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 05.11.13
 * Time: 10:52
 */
@Component
public class FssLawBasePage extends FssBasePage<FssLawBasePage> implements ComponentProvider, ILawBasePage {

    private RightPanel rightPanel;

    @Override
    public void handleRedirect() {
        super.handleRedirect();
        rightPanel = getHelper(RightPanel.class, this);
    }

    @Step("Проверяется что открыта страница 'Правовая База'")
    public FssLawBasePage checkLawBasePageIsOpened() {
        checkLawBaseTabIsSelected();
        checkSearchBoxPresentOnLawBasePage();
        checkHeaderDefaultState();
        checkNewsBlockIsPresent();
        checkNewsBlockIsNotEmpty();
        checkRubricatorMenuIsPresent();
        checkRubricatorMenuIsNotEmpty();
        checkPopularBlockIsPresent();
        checkPopularBlockIsNotEmpty();
        return this;
    }

    @Step("Проверяются элементы на странице 'Правовая База'")
    public FssLawBasePage checkDefaultStateLawBasePage() {
        checkLawBaseTabIsSelected();
        checkSearchBoxPresentOnLawBasePage();
        checkHeaderDefaultState();
        checkNewsBlockIsPresent();
        checkNewsBlockIsNotEmpty();
        checkRubricatorMenuIsPresent();
        checkRubricatorMenuIsNotEmpty();
        checkPopularBlockIsPresent();
        checkPopularBlockIsNotEmpty();
        checkFirstNewsTitle();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Правовая База'")
    public FssLawBasePage checkLawBaseTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.FSS_LAW_BASE);
        return this;
    }

    @Step("Проверяется заголовок страницы 'Правовая База'")
    public FssLawBasePage checkHeaderDefaultState() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement header = findElementByNoThrow(content, By.cssSelector(".doc-header"));
        postponedAssertNotNull(header, "Заголовок страницы 'Правовая База' не найден");
        postponedAssertTrue(header.isDisplayed(), "Заголовок страницы 'Правовая База' не отображается");
        postponedAssertEquals(header.getText().trim(), "НОВОЕ В ПРАВОВОЙ БАЗЕ", "Неправильный текст заголовка страницы 'Правовая База'");
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Правовая База'")
    public FssLawBasePage checkSearchBoxPresentOnLawBasePage() {
        checkSearchBoxIsPresent("Поиск документов");
        return this;
    }

    @Step("Проверяется что блок Новое на странице 'Правовая База' отображается")
    public FssLawBasePage checkNewsBlockIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement newsBlock = findElementByNoThrow(content, By.id("main-article"));
        postponedAssertNotNull(newsBlock, "Блок Новое на странице 'Правовая База' не найден");
        postponedAssertTrue(newsBlock.isDisplayed(), "Блок Новое на странице 'Правовая База' не отображается");
        return this;
    }

    @Step("Проверяется что блок Новое на странице 'Правовая База' не пустой")
    public FssLawBasePage checkNewsBlockIsNotEmpty() {
        WebElement newsBlock = waitForVisibilityOfElementLocatedBy(By.id("main-article"));
        List<WebElement> newsItemList = newsBlock.findElements(By.cssSelector(".b-news"));
        postponedAssertFalse(newsItemList.isEmpty(), "Блок Новое на странице 'Правовая База' пустой");
        return this;
    }

    @Step("Проверяется что меню Рубрикатора на странице 'Правовая База' отображается")
    public FssLawBasePage checkRubricatorMenuIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement rubricatorMenu = findElementByNoThrow(content, By.id("sidebar"));
        postponedAssertNotNull(rubricatorMenu, "Меню Рубрикатора на странице 'Правовая База' не найдено");
        postponedAssertTrue(rubricatorMenu.isDisplayed(), "Меню Рубрикатора на странице 'Правовая База' не отображается");
        return this;
    }

    @Step("Проверяется что меню Рубрикатора на странице 'Правовая База' не пустое")
    public FssLawBasePage checkRubricatorMenuIsNotEmpty() {
        List<WebElement> newsItemList = sidebarElement.findElements(By.tagName("li"));
        postponedAssertFalse(newsItemList.isEmpty(), "Меню Рубрикатора на странице 'Правовая База' пустое");
        return this;
    }

    @Step("Проверяется что правая панель на странице 'Правовая База' отображается")
    public FssLawBasePage checkPopularBlockIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement rubricatorMenu = findElementByNoThrow(content, By.id("aside"));
        postponedAssertNotNull(rubricatorMenu, "Правая панель на странице 'Правовая База' не найдена");
        postponedAssertTrue(rubricatorMenu.isDisplayed(), "Правая панель на странице 'Правовая База' не отображается");
        return this;
    }

    @Step("Проверяется что правая панель на странице 'Правовая База' не пустая")
    public FssLawBasePage checkPopularBlockIsNotEmpty() {
        WebElement newsBlock = getCollapsedRightPanel();
        List<WebElement> newsItemList = newsBlock.findElements(By.cssSelector(".go"));
        postponedAssertFalse(newsItemList.isEmpty(), "правая панель на странице 'Правовая База' пустая");
        return this;
    }

    @Step("Проверяется заголовок для верхнего документа")
    public FssLawBasePage checkFirstNewsTitle() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("main-article"));
        WebElement firstNews = content.findElement(By.cssSelector(".b-news"));
        String fontSize = firstNews.findElement(By.tagName("a")).getCssValue("font-size");
        if ("chrome".equalsIgnoreCase(SeleniumHolder.getDriverName())) {
            postponedAssertEquals(TestUtils.getHeightFromString(fontSize), 23.0, "Неправильный размер шрифта для верхнего документа");
        } else {
            postponedAssertEquals(TestUtils.getHeightFromString(fontSize), 22.5, "Неправильный размер шрифта для верхнего документа");
        }
        return this;
    }

    @Step("Проверяется что заголовок раздела отображается")
    public FssLawBasePage checkSectionTitleIsPresent() {
        getHelper(LawBasePageHelper.class).checkSectionTitleIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Налоговый кодекс' отображается")
    public FssLawBasePage checkTaxKodeksBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkTaxKodeksBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Трудовой кодекс' отображается")
    public FssLawBasePage checkLaborKodeksBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkLaborKodeksBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Прочие кодексы' отображается")
    public FssLawBasePage checkOtherKodeksBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkOtherKodeksBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Важное' отображается")
    public FssLawBasePage checkLegislationBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkLegislationBlockIsPresent("Важные документы");
        return this;
    }

    @Step("Проверяется что блок 'Судебные решения' отображается")
    public FssLawBasePage checkJudgmentBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkJudgmentBlockIsPresent();
        return this;
    }

    @Step("Проверяется отображение ссылок блока 'Судебные решения'")
    public FssLawBasePage checkJudgmentBlockLinksDisplayed() {
        getHelper(LawBasePageHelper.class).checkJudgmentKodeksBlockLinksDisplayed();
        return this;
    }
    @Step("Проверяется работа ссылок блока 'Судебные решения'")
    public FssLawBasePage checkJudgmentBlockLinks() {
        getHelper(LawBasePageHelper.class).checkJudgmentKodeksBlockLinks();
        return this;
    }

    @Step("Проверяется работа ссылок блока 'Судебные решения'")
    public FssLawBasePage checkJudgmentKodeksBlockLinksAreWorked() {
        getHelper(LawBasePageHelper.class).checkJudgmentKodeksBlockLinksAreWorked();
        return this;
    }

    @Step("Проверяется поисковая строка 'Поиск дел'")
    public FssLawBasePage checkSearchBoxPresentJudgementCode() {
        getHelper(LawBasePageHelper.class).checkSearchBoxIsPresentJudgmentBlock("Поиск дел");
        return this;
    }

    @Step("Ввести текст в строку поиска в блоке 'Судебные решения'")
    public FssLawBasePage inputTextInSearchBoxOnJudgmentBlock(String query) {
        getHelper(LawBasePageHelper.class).inputTextInSearchBoxOnJudgmentBlock(query);
        return this;
    }

    @Step("Проверяется что поисковые подсказки не отображаются в блоке 'Судебные решения'")
    public FssLawBasePage checkHintsIsNotPresentOnJudgmentBlock() {
        getHelper(LawBasePageHelper.class).checkHintsIsNotPresentOnJudgmentBlock();
        return this;
    }

    @Step("Нажать кнопку поиска в блоке 'Судебные решения'")
    public FssSearchResultPage clickSearchButtonOnJudgmentBlock() {
        getHelper(LawBasePageHelper.class).clickSearchButtonOnJudgmentBlock();
        return redirectTo(FssSearchResultPage.class);
    }

    @Step("Проверяется что блок 'В регионе' отображается")
    public FssLawBasePage checkRegionBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkRegionBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Главные документы' отображается")
    public FssLawBasePage checkMainDocsBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkMainDocsBlockIsPresent();
        return this;
    }

    @Step("Проверяется кнопка рубрикатора кодексов на странице 'Правовая База'")
    public FssLawBasePage checkAllKodexRubricatorButtonIsPresent() {
        WebElement rubricatorButton = waitForPresenceOfElementLocatedBy(By.id("rubricator-btn"), "Кнопка Все кодексы Отсутствует");
        postponedAssertEquals(rubricatorButton.getText(), "Все кодексы", "Неправильный текст кнопки Все кодексы");
        return this;
    }

    public FssLawBasePage checkLinksFromNewsBlock() {
        getHelper(FssHelpers.class).checkLinksFromNewsBlock();
        return this;
    }

    public FssLawBasePage checkNewsBlockScrolling() {
        getHelper(FssHelpers.class).checkNewsBlockScrolling(Period.month);
        return this;
    }

    public FssLawBasePage checkDateAreSortedDescending() {
        getHelper(FssHelpers.class).checkDateAreSortedDescending();
        return this;
    }

    public FssLawBasePage checkNewsBlockAreNotRepeat() {
        getHelper(FssHelpers.class).checkNewsBlockAreNotRepeat();
        return this;
    }

    public FssLawBasePage checkNewsAreNotEmpty() {
        getHelper(FssHelpers.class).checkNewsAreNotEmpty();
        return this;
    }

    public FssLawBasePage clickExtendPopularBlock() {
        getHelper(FssHelpers.class).clickExtendPopularBlock();
        return this;
    }

    @Step("Открыть раздел Популярное в правой панели")
    public FssLawBasePage clickPopularTab() {
        rightPanel.clickPopularTabInExpanded();
        return this;
    }

    @Step("Открыть раздел Просмотренное в правой панели")
    public FssLawBasePage clickViewedTab() {
        rightPanel.clickViewedTabInExpanded();
        return this;
    }

    @Step("Закрыть правую панель")
    public FssLawBasePage closePopularBlock() {
        rightPanel.closePopularBlock();
        return this;
    }

    @Step("Проверяется работа ссылок из раздела Просмотренное в правой панели")
    public FssLawBasePage checkRandomLinksFromExtendedViewedBlock() {
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
    public FssLawBasePage checkRandomLinksFromExtendedPopularBlock() {
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
    public FssLawBasePage checkFiltersInRightPanel() {
        clickExtendPopularBlock();
        clickViewedTab();
        rightPanel.checkDateFilters();
        return this;
    }

    @Step("Проверяется начальное состояние элементов в форме расширенного поиска")
    public FssLawBasePage checkDefaultStateForElementsInExtendedSearchForm() {
        WebElement extendedSearchForm = waitForVisibilityOfElementLocatedBy(By.id("form-search"));

        TextField searchInputFiled = getWebElementWrapper(extendedSearchForm.findElement(By.id("search-input"))).getTextField();
        TextField numberInputFiled = getWebElementWrapper(extendedSearchForm.findElement(By.id("search_number"))).getTextField();
        TextField startDateInputFiled = getWebElementWrapper(extendedSearchForm.findElement(By.id("sd_date_start"))).getTextField();
        TextField endDateInputFiled = getWebElementWrapper(extendedSearchForm.findElement(By.id("sd_date_end"))).getTextField();
        TextField viewInputFiled = getWebElementWrapper(extendedSearchForm.findElement(By.id("sd_type"))).getTextField();
        TextField departmentInputFiled = getWebElementWrapper(extendedSearchForm.findElement(By.id("sd_entity"))).getTextField();
        TextField regionInputFiled = getWebElementWrapper(extendedSearchForm.findElement(By.id("sd_region"))).getTextField();
        CheckBox checkBox = getWebElementWrapper(extendedSearchForm.findElement(By.id("sd_search_real"))).getCheckBox();
        WebElement searchButton = extendedSearchForm.findElement(By.id("button_search_extended"));

        postponedAssertEquals(searchInputFiled.getText(), "Поиск документов", "Неправильное начальное состояние для поисковой строки");
        postponedAssertEquals(numberInputFiled.getText(), "", "Неправильное начальное состояние для формы ввода Номера");
        postponedAssertEquals(startDateInputFiled.getText(), "дд.мм.гггг", "Неправильное начальное состояние для формы ввода Даты начала");
        postponedAssertEquals(endDateInputFiled.getText(), "дд.мм.гггг", "Неправильное начальное состояние для формы ввода Даты");
        postponedAssertEquals(viewInputFiled.getText(), "письмо, закон, акт", "Неправильное начальное состояние для формы ввода Вида");
        postponedAssertEquals(departmentInputFiled.getText(), "минздрав, правительство", "Неправильное начальное состояние для формы ввода Органа");
        postponedAssertEquals(regionInputFiled.getText(), "край или область", "Неправильное начальное состояние для формы ввода Региона");
        postponedAssertTrue(checkBox.isSelected(), "Чекбокс не выбран");
        postponedAssertTrue(searchButton.getAttribute("class").contains("disabled"), "Кнопка Найти в форме расширенного поиска активна");
        return this;
    }

    @Step("Проверяются элементы в форме расширенного поиска")
    public FssLawBasePage checkElementsInExtendedFormArePresent() {
        WebElement extendedSearchForm = waitForVisibilityOfElementLocatedBy(By.id("form-search"));

        WebElement searchInputFiled = findElementByNoThrow(extendedSearchForm, By.id("search-input"));
        WebElement numberInputFiled = findElementByNoThrow(extendedSearchForm, By.id("search_number"));
        WebElement startDateInputFiled = findElementByNoThrow(extendedSearchForm, By.id("sd_date_start"));
        WebElement endDateInputFiled = findElementByNoThrow(extendedSearchForm, By.id("sd_date_end"));
        WebElement viewInputFiled = findElementByNoThrow(extendedSearchForm, By.id("sd_type"));
        WebElement departmentInputFiled = findElementByNoThrow(extendedSearchForm, By.id("sd_entity"));
        WebElement regionInputFiled = findElementByNoThrow(extendedSearchForm, By.id("sd_region"));
        WebElement checkBox = findElementByNoThrow(extendedSearchForm, By.id("sd_search_real"));
        WebElement viewDropDown = findElementByNoThrow(extendedSearchForm, By.id("type_list"));
        WebElement departmentDropDown = findElementByNoThrow(extendedSearchForm, By.id("entity_list"));
        WebElement regionDropDown = findElementByNoThrow(extendedSearchForm, By.id("region_list"));
        WebElement searchButton = findElementByNoThrow(extendedSearchForm, By.id("button_search_extended"));

        postponedAssertNotNull(searchInputFiled, "Поисковая строка в форме расширенного поиска не найдена");
        postponedAssertNotNull(numberInputFiled, "Форма для ввода Номера в форме расширенного поиска не найдена");
        postponedAssertNotNull(startDateInputFiled, "Форма для ввода Даты начала в форме расширенного поиска не найдена");
        postponedAssertNotNull(endDateInputFiled, "Форма для ввода Даты в форме расширенного поиска не найдена");
        postponedAssertNotNull(viewInputFiled, "Форма для ввода Вида в форме расширенного поиска не найдена");
        postponedAssertNotNull(departmentInputFiled, "Форма для ввода Органа в форме расширенного поиска не найдена");
        postponedAssertNotNull(regionInputFiled, "Форма для ввода Региона в форме расширенного поиска не найдена");
        postponedAssertNotNull(checkBox, "Чекбокс в форме расширенного поиска не найден");
        postponedAssertNotNull(viewDropDown, "Форма для выбора Вида в форме расширенного поиска не найдена");
        postponedAssertNotNull(departmentDropDown, "Форма для выбора Органа в форме расширенного поиска не найдена");
        postponedAssertNotNull(regionDropDown, "Форма для выбора Региона в форме расширенного поиска не найдена");
        postponedAssertNotNull(searchButton, "Кнопка найти в форме расширенного поиска не найдена");
        return this;
    }

    @Step("Проверяется что элементы в форме выбора Вида отсортированы в алфавитном порядке")
    public FssLawBasePage checkSortingInExtendedForm() {
        WebElement extendedSearchForm = waitForVisibilityOfElementLocatedBy(By.id("form-search"));
        WebElement viewDropDown = extendedSearchForm.findElement(By.id("type_list"));
        List<WebElement> items = viewDropDown.findElements(By.tagName("li"));
        List<WebElement> newItemsList = new ArrayList<WebElement>();
        for (WebElement item : items) {
            if (item.getAttribute("class") == null) {
                newItemsList.add(item);
            }
        }
        postponedAssertThat(newItemsList, TestUtils.sortedInAscendingOrder(), "Элементы в форме выбора Вида отсортированы не в алфавитном порядке");
        return this;
    }

    @Step("Проверяется выделение болдом первых элементов в формах")
    public FssLawBasePage checkFirstElementsAreHighlightedInExtendedForm() {
        WebElement extendedSearchForm = waitForVisibilityOfElementLocatedBy(By.id("form-search"));
        WebElement viewDropDown = extendedSearchForm.findElement(By.id("type_list"));
        List<WebElement> viewItems = viewDropDown.findElements(By.tagName("li"));
        postponedAssertEquals(viewItems.get(0).getText(), "Любой", "Неправильный первый элемент в форме Вид");

        for (int i = 0; i < 3; i++) {
            WebElement item = viewItems.get(i);
            postponedAssertTrue(item.getAttribute("class") != null && item.getAttribute("class").contains("bold"), (i + 1) + " элемент в форме Вид не выделен болдом");
        }

        WebElement departmentDropDown = extendedSearchForm.findElement(By.id("type_list"));
        List<WebElement> departmentItems = departmentDropDown.findElements(By.tagName("li"));
        postponedAssertEquals(departmentItems.get(0).getText(), "Любой", "Неправильный первый элемент в форме Орган");
        for (int i = 0; i < 3; i++) {
            WebElement item = departmentItems.get(i);
            postponedAssertTrue(item.getAttribute("class") != null && item.getAttribute("class").contains("bold"), (i + 1) + " элемент в форме Орган не выделен болдом");
        }

        WebElement regionDropDown = extendedSearchForm.findElement(By.id("type_list"));
        List<WebElement> regionItems = regionDropDown.findElements(By.tagName("li"));
        postponedAssertEquals(regionItems.get(0).getText(), "Любой", "Неправильный первый элемент в форме Регион");
        for (int i = 0; i < 3; i++) {
            WebElement item = regionItems.get(i);
            postponedAssertTrue(item.getAttribute("class") != null && item.getAttribute("class").contains("bold"), (i + 1) + " элемент в форме Регион не выделен болдом");
        }
        return this;
    }

    public FssLawBasePage checkCollapsedRightPanel() {
        getHelper(FssHelpers.class).checkCollapsedRightPanel(rightPanel);
        return this;
    }

    public FssLawBasePage checkExpandedRightPanel() {
        getHelper(FssHelpers.class).checkExpandedRightPanel(rightPanel);
        return this;
    }

    public FssLawBasePage checkRandomLinksFromCollapsedPopularTab() {
        getHelper(FssHelpers.class).checkRandomLinksFromCollapsedPopularTab(rightPanel);
        return this;
    }

    public FssLawBasePage checkRandomLinksFromCollapsedViewedTab() {
        getHelper(FssHelpers.class).checkRandomLinksFromCollapsedViewedTab(rightPanel);
        return this;
    }

    @Step("Проверяется отбражение ссылок блока 'Прочие кодексы'")
    public FssLawBasePage checkOtherKodeksBlockLinksDisplayed() {
        getHelper(LawBasePageHelper.class).checkOtherKodeksBlockLinksDisplayed();
        return this;
    }

    @Step("Проверяется работа ссылок блока 'Прочие кодексы'")
    public FssLawBasePage checkOtherKodeksBlockLinks() {
        getHelper(LawBasePageHelper.class).checkOtherKodeksBlockLinks();
        return this;
    }

    @Step("Ввести текст в строку поиска в блоке 'Прочие кодексы'")
    public FssLawBasePage inputTextInSearchBoxOnOtherKodeksBlock(String text) {
        getHelper(LawBasePageHelper.class).inputTextInSearchBoxOnOtherKodeksBlock(text);
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются в блоке 'Прочие кодексы'")
    public FssLawBasePage checkHintsIsPresentOnOtherKodeksBlock() {
        getHelper(LawBasePageHelper.class).checkHintsIsPresentOnOtherKodeksBlock();
        return this;
    }

    @Step("Проверить подсказку в блоке 'Прочие Кодексы'")
    public FssLawBasePage checkHintOnOtherKodeksBlock() {
        getHelper(LawBasePageHelper.class).checkHintOnOtherKodeksBlock();
        return this;
    }

    @Step("Проверяется поисковая строка 'Поиск статей'")
    public FssLawBasePage checkSearchBoxPresentOtherCode() {
        getHelper(LawBasePageHelper.class).checkSearchBoxIsPresentOtherCode("Поиск статей");
        return this;
    }

    @Step("Нажать кнопку поиска в блоке 'Прочие кодексы'")
    public FssSearchResultPage clickSearchButtonOnOtherKodeksBlock() {
        getHelper(LawBasePageHelper.class).clickSearchButtonOnOtherKodeksBlock();
        return redirectTo(FssSearchResultPage.class);
    }

    @Step("Проверяется отображение ссылок блока 'Важное'")
    public FssLawBasePage checkLegislationBlockLinksDisplayed() {
        getHelper(LawBasePageHelper.class).checkLegislationBlockLinksDisplayed();
        return this;
    }

    @Step("Проверяется работа ссылок блока 'Важное'")
    public FssLawBasePage checkLegislationBlockLinks() {
        getHelper(LawBasePageHelper.class).checkLegislationBlockLinks();
        return this;
    }

    @Step("Проверяется поисковая строка блока 'Важное'")
    public FssLawBasePage checkSearchBoxPresentLegislation(String input) {
        getHelper(LawBasePageHelper.class).checkSearchBoxIsPresentLegislation(input);
        return this;
    }

    @Step("Ввести текст в строку поиска в блоке 'Важное'")
    public FssLawBasePage inputTextInSearchBoxOnLegislationBlock(String query) {
        getHelper(LawBasePageHelper.class).inputTextInSearchBoxOnLegislationBlock(query);
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются в блоке 'Важное'")
    public FssLawBasePage checkHintsIsPresentOnLegislationBlock() {
        getHelper(LawBasePageHelper.class).checkHintsIsPresentOnLegislationBlock();
        return this;
    }

    @Step("Нажать подсказку в блоке 'Важное'")
    public FssSearchResultPage clickHintOnLegislationBlock() {
        getHelper(LawBasePageHelper.class).clickHintOnLegislationBlock();
        return redirectTo(FssSearchResultPage.class);
    }

    public void clickHintWithJump(WebElement searchResult) {
        getHelper(LawBasePageHelper.class).clickHintWithJump(searchResult);
    }

    @Step("Нажать подсказку в блоке 'Важное'")
    public FssSearchResultPage clickSearchButtonOnLegislationBlock() {
        getHelper(LawBasePageHelper.class).clickSearchButtonOnLegislationBlock();
        return redirectTo(FssSearchResultPage.class);
    }

    @Step("Проверяется что блок 'Важное' отображается")
    public FssLawBasePage checkLegislationBlockIsPresent(String blockName) {
        getHelper(LawBasePageHelper.class).checkLegislationBlockIsPresent(blockName);
        return this;
    }

    @Step("Проверяется что блок 'Налоговый кодекс' изменяется при изменении размера окна")
    public FssLawBasePage checkTaxKodeksBlockResize(int widthTrue) {
        getHelper(LawBasePageHelper.class).checkTaxKodeksBlockResize(widthTrue);
        return this;
    }

    @Step("Проверяется что блок 'Налоговый кодекс' не конфликтует с другими блоками при изменении размера окна")
    public FssLawBasePage checkBlockConflict() {
        getHelper(LawBasePageHelper.class).checkConflictDisplayBlock();
        return this;
    }

    @Step("Ввести текст в строку поиска в блоке 'Налоговый кодекс'")
    public FssLawBasePage inputTextInSearchBoxOnTaxBlock(String query) {
        getHelper(LawBasePageHelper.class).inputTextInSearchBoxOnTaxBlock(query);
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются в блоке 'Налоговый кодекс'")
    public FssLawBasePage checkHintsIsPresentOnTaxKodeksBlock() {
        getHelper(LawBasePageHelper.class).checkHintsIsPresentOnTaxKodeksBlock();
        return this;
    }

    @Step("Нажать подсказку в блоке 'Налоговый кодекс'")
    public FssSearchResultPage clickHintOnTaxBlock() {
        getHelper(LawBasePageHelper.class).clickHintOnTaxBlock();
        return redirectTo(FssSearchResultPage.class);
    }

    @Step("Проверяется что поисковые подсказки не отображаются в блоке 'Налоговый кодекс'")
    public FssLawBasePage checkHintsIsNotPresentOnTaxKodeksBlock() {
        getHelper(LawBasePageHelper.class).checkHintsIsNotPresentOnTaxKodeksBlock();
        return this;
    }

    @Step("Проверяется работа ссылок блока 'Налоговый кодекс'")
    public FssLawBasePage checkTaxKodeksBlockLinks() {
        getHelper(LawBasePageHelper.class).checkTaxKodeksBlockLinks();
        return this;
    }

    @Step("Нажать кнопку  поиска в блоке 'Налоговый кодекс'")
    public FssSearchResultPage clickSearchButtonOnTaxBlock() {
        getHelper(LawBasePageHelper.class).clickSearchButtonOnRegionBlock();
        return redirectTo(FssSearchResultPage.class);
    }

    @Step("Проверяется наличие блока 'Налоговый кодекс'")
    public FssLawBasePage checkTaxBlock() {
        getHelper(LawBasePageHelper.class).checkTaxBlock();
        return this;
    }

    @Step("Проверяется работа ссылок блока 'Главные документы'")
    public FssLawBasePage checkMainDocsBlockLinks() {
        getHelper(LawBasePageHelper.class).checkMainDocsBlockLinks();
        return this;
    }

    @Step("Проверяются секции блока 'Главные документы'")
    public FssLawBasePage checkMainDocsBlockSections() {
        getHelper(LawBasePageHelper.class).checkMainDocsBlockSections();
        return this;
    }

    @Step("Открыть страницу газеты")
    public FssNewsPage clickNewsPaperHeaderLink() {
        waitForPresenceOfElementLocatedBy(By.cssSelector(".news__title")).findElement(By.tagName("a")).click();
        return redirectTo(FssNewsPage.class);
    }

    @Step("Проверяется что ссылка 'Изменить регион' отображается")
    public FssLawBasePage checkChangeRegionLinkIsPresent() {
        getHelper(LawBasePageHelper.class).checkChangeRegionLinkIsPresent();
        return this;
    }

    @Step("Проверяется работа ссылок блока 'Региональные документы'")
         public FssLawBasePage checkRegionBlockLinks() {
        getHelper(LawBasePageHelper.class).checkRegionBlockLinks();
        return this;
    }

    @Step("Проверяется поисковая строка 'Поиск региональных документов'")
    public FssLawBasePage checkSearchBoxIsPresentRegionBlock() {
        getHelper(LawBasePageHelper.class).checkSearchBoxIsPresentRegionBlock("Поиск региональных документов");
        return this;
    }

    @Step("Ввести текст в строку поиска в блоке 'Региональные документы'")
    public FssLawBasePage inputTextInSearchBoxOnRegionBlock(String query) {
        getHelper(LawBasePageHelper.class).inputTextInSearchBoxOnRegionBlock(query);
        return this;
    }

    @Step("Нажать кнопку поиска в блоке 'Региональные документы'")
    public FssSearchResultPage clickSearchButtonOnRegionBlock() {
        getHelper(LawBasePageHelper.class).clickSearchButtonOnRegionBlock();
        return redirectTo(FssSearchResultPage.class);
    }

    @Step("Кликнуть на ссылку 'Изменить регион'")
    public FssProfilePage clickLinkChangeRegion() {
        getHelper(LawBasePageHelper.class).clickLinkChangeRegion();
        return redirectTo(FssProfilePage.class);
    }

    @Step("Проверяем клик на ссылку 'Изменить регион'")
    public FssLawBasePage checkCurrentUrlContainsDocumentUrl() {
        getHelper(LawBasePageHelper.class).checkCurrentUrlContainsDocumentUrl("/#/customer/geo/");
        return this;
    }

    @Step("Проверяются заголовок блока 'Главное в регионе'")
    public FssLawBasePage checkTitleChangeRegion(String region) {
        getHelper(LawBasePageHelper.class).checkTitleChangeRegion(region);
        return this;
    }


    @Step("Проверяется что блок 'Трудовой кодекс' изменяется при изменении размера окна")
    public FssLawBasePage checkLaborKodeksBlockResize(int widthTrue) {
        getHelper(LawBasePageHelper.class).checkLaborKodeksBlockResize(widthTrue);
        return this;
    }

    @Step("Проверяется наличие блока 'Трудовой кодекс'")
    public FssLawBasePage checkLaborBlock() {
        getHelper(LawBasePageHelper.class).checkLaborBlock();
        return this;
    }

    @Step("Ввести текст в строку поиска в блоке 'Трудовой кодекс'")
    public FssLawBasePage inputTextInSearchBoxOnLaborBlock(String query) {
        getHelper(LawBasePageHelper.class).inputTextInSearchBoxOnLaborBlock(query);
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются в блоке 'Трудовой кодекс'")
    public FssLawBasePage checkHintsIsPresentOnLaborBlock() {
        getHelper(LawBasePageHelper.class).checkHintsIsPresentOnLaborBlock();
        return this;
    }

    @Step("Нажать подсказку в блоке 'Трудовой кодекс'")
    public FssSearchResultPage clickHintOnLaborBlock() {
        getHelper(LawBasePageHelper.class).clickHintOnLaborBlock();
        return redirectTo(FssSearchResultPage.class);
    }

    @Step("Нажать кнопку  поиска в блоке 'Трудовой кодекс'")
    public FssSearchResultPage clickSearchButtonOnLaborBlock() {
        getHelper(LawBasePageHelper.class).clickSearchButtonOnLaborBlock();
        return redirectTo(FssSearchResultPage.class);
    }

    @Step("Проверяется что поисковые подсказки не отображаются в блоке 'Трудовой кодекс'")
    public FssLawBasePage checkHintsIsNotPresentOnLaborKodeksBlock() {
        getHelper(LawBasePageHelper.class).checkHintsIsNotPresentOnLaborKodeksBlock();
        return this;
    }

    @Step("Проверяется работа ссылок блока 'Трудовой кодекс'")
    public FssLawBasePage checkLaborKodeksBlockLinks() {
        getHelper(LawBasePageHelper.class).checkLaborKodeksBlockLinks();
        return this;
    }

    @Step("Нажать подсказку в блоке 'Налоговый кодекс'")
    public FssSearchResultPage clickHintOnOtherBlock() {
        getHelper(LawBasePageHelper.class).clickHintOnOtherBlock();
        return redirectTo(FssSearchResultPage.class);
    }

    public FssSearchResultPage setExtended(String type, String city) {
        getHelper(SearchResultHelper.class).setExtended(type, null, city);
        return redirectTo(FssSearchResultPage.class);
    }

    public FssSearchResultPage setExtended(String type, String lobby, String region) {
        getHelper(SearchResultHelper.class).setExtended(type, lobby, region);
        return redirectTo(FssSearchResultPage.class);
    }

    public FssSearchResultPage clickOnButtonSearchOnExtendedForm() {
        getHelper(SearchResultHelper.class).clickOnButtonSearchOnExtendedForm();
        return redirectTo(FssSearchResultPage.class);
    }

    public FssLawBasePage checkResultTextFiltersOnExtendedFormIsNotVisible() {
        getHelper(LawBasePageHelper.class).checkResultTextFiltersOnExtendedFormIsNotVisible();
        return this;
    }

    public FssLawBasePage checkMainLawBasePageIsOpened() {
        getHelper(SearchResultHelper.class).checkMainLawBasePageIsOpened();
        return this;
    }

    public FssLawBasePage checkTaxWidgetIsPresent() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkWidgetIsPresent(widget, "Налоговый");
        return this;
    }

    public FssLawBasePage checkTaxWidgetTitleIsPresent() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkTitleIsLink(widget);
        return this;
    }

    public FssLawBasePage checkTaxWidgetLinksArePresent() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkLinksArePresent(widget);
        return this;
    }

    public FssLawBasePage checkTaxWidgetBlockResized() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkBlockSizeIsChanged(widget);
        return this;
    }

    public FssLawBasePage checkTaxWidgetHasSixLinks() {
        getHelper(TaxWidget.class).checkWidgetHasSixLinks();
        return this;
    }

    public FssLawBasePage checkTaxWidgetHasTwoLinks() {
        getHelper(TaxWidget.class).checkWidgetHasTwoLinks();
        return this;
    }

    public FssLawBasePage checkTaxWidgetLinksAreWorked() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkLinksAreWorked(widget);
        return this;
    }

    public FssLawBasePage checkSearchTaxWidgetBlockIsPresent() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchWidgetBlockIsPresent(widget);
        return this;
    }

    public FssLawBasePage checkAllWidgetsDontConflictWithEachOther() {
        getHelper(Widget.class).checkAllWidgetsDontConflictWithEachOther();
        return this;
    }

    public FssLawBasePage checkTaxWidgetSearchInputHasName() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchInputHasName(widget, "Поиск статей");
        return this;
    }

    public FssLawBasePage inputTaxWidgetSearchQuery(String query) {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).inputText(widget, query);
        return this;
    }

    public FssDocumentPage clickOnTaxWidgetButtonEnterIntoSearchBox() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnButtonEnterIntoSearchBox(widget);
        return redirectTo(FssDocumentPage.class);
    }

    public FssLawBasePage checkTaxWidgetSearchResultIsVisible() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsVisible(widget);
        return this;
    }

    public FssLawBasePage checkTaxWidgetSearchResultIsNotVisible() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsNotVisible(widget);
        return this;
    }

    public FssDocumentPage clickOnTaxWidgetRandomSearchResult() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnRandomSearchResult(widget);
        return redirectTo(FssDocumentPage.class);
    }

    public FssLawBasePage checkLaborWidgetIsPresent() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(LaborWidget.class).checkWidgetIsPresent(widget, "Трудовой");
        return this;
    }

    public FssLawBasePage checkLaborWidgetTitleIsPresent() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(LaborWidget.class).checkTitleIsLink(widget);
        return this;
    }

    public FssLawBasePage checkLaborWidgetLinksArePresent() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(LaborWidget.class).checkLinksArePresent(widget);
        return this;
    }

    public FssLawBasePage checkLaborWidgetBlockResized() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(LaborWidget.class).checkBlockSizeIsChanged(widget);
        return this;
    }

    public FssLawBasePage checkLaborWidgetHasFourLinks() {
        getHelper(LaborWidget.class).checkWidgetHasFourLinks();
        return this;
    }

    public FssLawBasePage checkLaborWidgetLinksAreWorked() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(LaborWidget.class).checkLinksAreWorked(widget);
        return this;
    }

    public FssLawBasePage checkSearchLaborWidgetBlockIsPresent() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchWidgetBlockIsPresent(widget);
        return this;
    }

    public FssLawBasePage checkLaborWidgetSearchInputHasName() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchInputHasName(widget, "Поиск статей");
        return this;
    }

    public FssLawBasePage inputLaborWidgetSearchQuery(String query) {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).inputText(widget, query);
        return this;
    }

    public FssDocumentPage clickOnLaborWidgetButtonEnterIntoSearchBox() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnButtonEnterIntoSearchBox(widget);
        return redirectTo(FssDocumentPage.class);
    }

    public FssLawBasePage checkLaborWidgetSearchResultIsVisible() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsVisible(widget);
        return this;
    }

    public FssLawBasePage checkLaborWidgetSearchResultIsNotVisible() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsNotVisible(widget);
        return this;
    }

    public FssLawBasePage checkLaborWidgetBlockIsNotChanged() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(LaborWidget.class).checkBlockSizeIsNotChanged(widget);
        return this;
    }

    public FssDocumentPage clickOnLaborWidgetRandomSearchResult() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnRandomSearchResult(widget);
        return redirectTo(FssDocumentPage.class);
    }

    public FssLawBasePage checkPopularWidgetIsPresent() {
        WebElement widget = getHelper(PopularWidget.class).getWidget();
        getHelper(PopularWidget.class).checkWidgetIsPresent(widget, "Популярное в");
        return this;
    }

    public FssLawBasePage checkPopularWidgetTitleHasWordPopular() {
        getHelper(PopularWidget.class).checkTitleHasWordPopular();
        return this;
    }

    public FssLawBasePage checkPopularWidgetContainsLinksWithDocuments() {
        getHelper(PopularWidget.class).checkPopularWidgetContainsLinksWithDocuments();
        return this;
    }

    public FssLawBasePage checkPopularWidgetLinkChangeRegionIsDisplayed() {
        getHelper(PopularWidget.class).checkLinkChangeRegionIsDisplayed();
        return this;
    }

    public FssLawBasePage checkPopularWidgetLinkChangeRegionIsNotDisplayed() {
        getHelper(PopularWidget.class).checkLinkChangeRegionIsNotDisplayed();
        return this;
    }

    public FssLawBasePage checkPopularWidgetCheckSearchInputHasName(String name) {
        WebElement widget = getHelper(PopularWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchInputHasName(widget, name);
        return this;
    }
}
