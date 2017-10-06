package com.actionmedia.pages;

import com.actionmedia.autotest.selenium.annotations.Wait;
import com.actionmedia.autotest.selenium.context.AbstractComponent;
import com.actionmedia.autotest.selenium.elements.Button;
import com.actionmedia.autotest.selenium.elements.CheckBox;
import com.actionmedia.autotest.selenium.elements.TextField;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 29.01.14
 * Time: 11:00
 */
@Component
public class ExtendedSearchForm extends AbstractComponent<ExtendedSearchForm> {

    public static final String TYPE_VALUE = "type.value";
    public static final String LOBBY_VALUE = "lobby.value";
    public static final String REGION_VALUE = "region.value";
    public static final String CATEGORY_VALUE = "category.value";
    public static final String SEARCH_TEXT = "search.text";
    public static final String SEARCH_NUMBER = "search.number";
    public static final String START_DATE = "start.date";
    public static final String START_DATE_NOT_FORMATTED = "start.date.not.formatted";
    public static final String END_DATE = "end.date";
    public static final String END_DATE_NOT_FORMATTED = "end.date.not.formatted";
    public static final String ACTUAL_DOCUMENTS = "actual.documents";
    public static final String ONLY_IN_TITLES = "only.in.titles";

    @Wait
    @FindBy(id = "search-form-extended")
    private WebElement extendedFrom;

    @Wait
    @FindBy(id = "onlyReal")
    private CheckBox actualDocumentCheckBox;

    @Wait
    @FindBy(id = "onlyTitle")
    private CheckBox onlyInTitlesCheckBox;

    @Wait
    @FindBy(id = "exactPhrase")
    private CheckBox exactPhraseCheckBox;

    @Wait
    @FindBy(id = "button-search-extended")
    private Button searchButton;

    @Wait
    @FindBy(id = "search-text")
    private TextField searchField;

    @Wait
    @FindBy(id = "sd-num")
    private TextField searchNmbrField;

    @Wait
    @FindBy(id = "sd-datestart")
    private TextField startDateField;

    @Wait
    @FindBy(id = "sd-dateend")
    private TextField endDateField;

    @Wait
    @FindBy(css = ".search-body-result-text")
    private WebElement searchBodyResultText;

    @Wait
    @FindBy(id = "typelist")
    private WebElement typelist;

    @Wait
    @FindBy(id = "sd-type")
    private WebElement typeInput;

    @Wait
    @FindBy(id = "lobbylist")
    private WebElement lobbylist;

    @Wait
    @FindBy(id = "sd-entity")
    private WebElement lobbyInput;

    @Wait
    @FindBy(id = "regionlist")
    private WebElement regionlist;

    @Wait
    @FindBy(id = "sd-region")
    private WebElement regionInput;

    @Wait
    @FindBy(id = "sd-category")
    private WebElement categoryInput;

    @Wait
    @FindBy(id = "categorylist")
    private WebElement categoryList;


    @Wait
    @FindBy(css = "#law-practice-switch .in-law")
    private WebElement inLawBase;

    @Wait
    @FindBy(css = "#law-practice-switch .in-practice")
    private WebElement inLawPractice;

    @Wait
    @FindBy(id = "search-clear-all")
    private WebElement clearAll;


    @Step("Проверяется что чекбокс 'искать в действующих' выбран")
    public void checkActualDocumentCheckBoxIsSelected() {
        postponedAssertTrue(actualDocumentCheckBox.isClickable(), "Чекбокс 'искать в действующих' не активен");
        postponedAssertTrue(actualDocumentCheckBox.isSelected(), "Чекбокс 'искать в действующих' не выбран");
    }

    @Step("Проверяется что чекбокс 'искать в действующих' не выбран")
    public void checkActualDocumentCheckBoxIsNotSelected() {
        postponedAssertFalse(actualDocumentCheckBox.isSelected(), "Чекбокс 'искать в действующих' выбран");
    }

    @Step("Проверяется что чекбокс 'искать только в заголовках документов' выбран")
    public void checkOnlyInTitlesCheckBoxIsSelected() {
        postponedAssertTrue(onlyInTitlesCheckBox.isClickable(), "Чекбокс 'искать только в заголовках документов' не активен");
        postponedAssertTrue(onlyInTitlesCheckBox.isSelected(), "Чекбокс 'искать только в заголовках документов' не выбран");
    }

    @Step("Проверяется что чекбокс 'искать только в заголовках документов' выбран")
    public void checkOnlyInTitlesCheckBoxIsNotSelected() {
        postponedAssertFalse(onlyInTitlesCheckBox.isSelected(), "Чекбокс 'искать только в заголовках документов' выбран");
    }

    @Step("Проверяется что чекбокс 'искать только в заголовках документов' активен")
    public void checkOnlyInTitlesCheckBoxIsEnabled() {
        postponedAssertTrue(onlyInTitlesCheckBox.isEnabled(), "Чекбокс 'искать только в заголовках документов' не активен");
    }

    @Step("Проверяется что чекбокс 'искать только в заголовках документов' не активен")
    public void checkOnlyInTitlesCheckBoxIsDisabled() {
        postponedAssertFalse(onlyInTitlesCheckBox.isEnabled(), "Чекбокс 'искать только в заголовках документов' активен");
    }

    @Step("Проверяется что кнопка 'Найти' в форме расширенного поиска активна")
    public void checkSearchExtendedButtonsIsEnabled() {
        postponedAssertTrue("".equals(searchButton.getWrappedWebElement().getAttribute("class")), "Кнопка 'Найти' не активна");
    }

    @Step("Проверяется что кнопка 'Найти' в форме расширенного поиска не активна")
    public void checkSearchExtendedButtonsIsDisabled() {
        postponedAssertTrue("disabled".equals(searchButton.getWrappedWebElement().getAttribute("class")), "Кнопка 'Найти' активна");
    }

    @Step("Провереятся текст атрибутов поиска")
    public void checkSearchBodyResultText(String text) {
        if (actualDocumentCheckBox.isSelected()) {
            postponedAssertEquals(searchBodyResultText.getText().split("\n")[0].trim(), "Найти действующие документы" + text, "Неправильный текст ");
        } else {
            postponedAssertEquals(searchBodyResultText.getText().split("\n")[0].trim(), "Найти все документы" + text, "Неправильный текст ");
        }
    }

    @Step("Провереятся текст атрибутов поиска")
    public void checkSearchBodyResultText() {
        String actualResultText = searchBodyResultText.getText().split("\n")[0].trim();
        postponedAssertEquals(actualResultText, "Найти документы" + getSearchBodyResultText(),
                "Неправильный текст строки с атрибутами поиска. " +
                        "Ожидаемый: " + "Найти документы" + getSearchBodyResultText() +
                        "Наблюдаемый: " + actualResultText);
    }

    @Step("Провереятся текст атрибутов поиска в судебной практике")
    public void checkSearchBodyResultTextInPractice() {
        String actualResultText = searchBodyResultText.getText().split("\n")[0].trim();
        postponedAssertEquals(actualResultText, "Найти документы" + getSearchBodyResultInPracticeText(),
                "Неправильный текст строки с атрибутами поиска. " +
                        "Ожидаемый: " + "Найти документы" + getSearchBodyResultInPracticeText() +
                        "Наблюдаемый: " + actualResultText);
    }

    @Step("Провереятся что значения на форме расширенного поиска не изменились")
    public void checkValuesInFieldIsNotChanged() {
        if (getParameter(TYPE_VALUE) != null) {
            postponedAssertEquals(getSelectedItem(typelist), String.valueOf(getParameter(TYPE_VALUE)), "Значение для поля 'Вид' изменилось");
        }
        if (getParameter(LOBBY_VALUE) != null) {
            postponedAssertEquals(getSelectedItem(lobbylist), String.valueOf(getParameter(LOBBY_VALUE)), "Значение для поля 'Орган' изменилось");
        }
        if (getParameter(REGION_VALUE) != null) {
            postponedAssertEquals(getSelectedItem(regionlist), String.valueOf(getParameter(REGION_VALUE)), "Значение для поля 'Регион' изменилось");
        }
        if (getParameter(SEARCH_TEXT) != null) {
            postponedAssertEquals(searchField.getText(), String.valueOf(getParameter(SEARCH_TEXT)), "Значение для поля 'Поисковая строка' изменилось");
        }
        if (getParameter(SEARCH_NUMBER) != null) {
            postponedAssertEquals(searchNmbrField.getText(), String.valueOf(getParameter(SEARCH_NUMBER)), "Значение для поля 'Номер' изменилось");
        }
        if (getParameter(START_DATE) != null) {
            postponedAssertEquals(startDateField.getText(), String.valueOf(getParameter(START_DATE)), "Значение для поля 'Дата начала создания документа' изменилось");
        }
        if (getParameter(END_DATE) != null) {
            postponedAssertEquals(endDateField.getText(), String.valueOf(getParameter(END_DATE)), "Значение для поля 'Дата конца создания документа' изменилось");
        }
    }

    @Step("Провереятся значения по-умолчанию на форме расширенного поиска")
    public void checkAllFieldsDefaultState() {
        postponedAssertTrue(searchField.getText().isEmpty(), "Неправильное значение по-умолчанию для поля 'Строка поиска'");
        postponedAssertTrue(searchNmbrField.getText().isEmpty(), "Неправильное значение по-умолчанию для поля 'Номер'");
        postponedAssertTrue(startDateField.getText().isEmpty() || "дд.мм.гггг".equals(startDateField.getText()), "Неправильное значение по-умолчанию для поля 'Дата начала'");
        postponedAssertTrue(endDateField.getText().isEmpty() || "дд.мм.гггг".equals(endDateField.getText()), "Неправильное значение по-умолчанию для поля 'Дата конца'");
    }

    @Step("Нажать кнопку 'Найти' на форме расширенного поиска")
    public void clickSearchExtendedButton() {
        searchButton.click();
        waitForReloadingPage();
    }

    @Step("Ввести текст в строку поиска")
    public void inputTextInSearchField(String text) {
        searchField.clearAndType(text);
        setParameter(SEARCH_TEXT, text);
        report("Текст в строке поиска -  " + text);
        waitForReloadingPage();
    }

    @Step("Ввести текст в поле 'Номер'")
    public void inputTextInNumberField(String text) {
        searchNmbrField.clearAndType(text);
        setParameter(SEARCH_NUMBER, text);
        report("Текст в поле 'Номер' -  " + text);
        findElementBy(By.id("sd-num")).sendKeys(Keys.ESCAPE);
        waitForReloadingPage();
    }

    @Step("Ввести текст в поле 'Номер' не убирая подсказки")
    public void inputTextInNumberFieldWithoutCloseTheAdviceList(String text) {
        searchNmbrField.clearAndType(text);
        setParameter(SEARCH_NUMBER, text);
        waitForReloadingPage();
    }

    @Step("Ввести текст в поле 'Дата начала'")
    public void inputTextInStartDateField(String text) {
        startDateField.clearAndType(text);
//        JavascriptExecutor js = (JavascriptExecutor)getDriver();
//        js.executeScript("arguments[0].value = '';", startDateField);
        String result = "";

        String[] textArr = text.split("\\.");
        if (textArr[0].startsWith("0")) {
            result = result + textArr[0].replace("0", "");
            result = result + ".";
        } else {
            result = result + textArr[0];
        }

        if (textArr[1].startsWith("0")) {
            result = result + textArr[1].replace("0", "");
            result = result + ".";
        } else {
            result = result + textArr[1];
        }

        result = result + textArr[2];

        setParameter(START_DATE_NOT_FORMATTED, text);
        setParameter(START_DATE, result);
        report("Текст в поле 'Дата начала' -  " + text);
        waitForReloadingPage();
    }

    @Step("Ввести текст в поле 'Дата конца'")
    public void inputTextInEndDateField(String text) {
        endDateField.clearAndType(text);
//        JavascriptExecutor js = (JavascriptExecutor)getDriver();
//        js.executeScript("arguments[0].value = '';", endDateField);
        String result = "";

        String[] textArr = text.split("\\.");
        if (textArr[0].startsWith("0")) {
            result = result + textArr[0].replace("0", "");
            result = result + ".";
        } else {
            result = result + textArr[0];
        }

        if (textArr[1].startsWith("0")) {
            result = result + textArr[1].replace("0", "");
            result = result + ".";
        } else {
            result = result + textArr[1];
        }

        result = result + textArr[2];

        setParameter(END_DATE_NOT_FORMATTED, text);
        setParameter(END_DATE, result);
        report("Текст в поле 'Дата конца' -  " + text);
        waitForReloadingPage();
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    @Step("Очистить все поля")
    public void clearAllFields() {
        searchField.clearAndType("");
        searchNmbrField.clearAndType("");
        startDateField.clearAndType("");
        endDateField.clearAndType("");
        startDateField.clearAndType("");
        endDateField.clearAndType("");

        typelist.findElement(By.tagName("li")).click();
        lobbylist.findElement(By.tagName("li")).click();
        regionlist.findElement(By.tagName("li")).click();

        clearParameter(TYPE_VALUE);
        clearParameter(LOBBY_VALUE);
        clearParameter(REGION_VALUE);
        clearParameter(SEARCH_TEXT);
        clearParameter(SEARCH_NUMBER);
        clearParameter(START_DATE);
        clearParameter(START_DATE_NOT_FORMATTED);
        clearParameter(END_DATE);
        clearParameter(END_DATE_NOT_FORMATTED);
        waitForReloadingPage();
    }

    @Step("Выбрать 'Вид'")
    public void selectTypeByName(String name) {
        waitForPresenceOfElementLocatedBy(By.xpath("//*[@id='typelist']/li[text()='" + name + "']"), "Не найден 'Вид' - " + name).click();
        setParameter(TYPE_VALUE, name);
        waitForReloadingPage();
    }

    @Step("Выбрать случайное значение из поля 'Вид'")
    public void selectRandomType() {
        List<WebElement> typeValueList = typelist.findElements(By.tagName("li"));
        if (typeValueList.size() > 1) {
            typeValueList = typeValueList.subList(1, typeValueList.size());
        }
        WebElement randomValue = getRandomElementInList(typeValueList);
        setParameter(TYPE_VALUE, randomValue.getText());
        report("Выбран '" + randomValue.getText() + "' в поле 'Вид'");
        randomValue.click();
        waitForReloadingPage();
    }

    @Step("Выбрать 'Орган'")
    public void selectLobbyByName(String name) {
        waitForPresenceOfElementLocatedBy(By.xpath("//*[@id='lobbylist']/li[text()='" + name + "']"), "Не найден 'Орган' - " + name).click();
        setParameter(LOBBY_VALUE, name);
        waitForReloadingPage();
    }

    @Step("Выбрать случайное значение из поля 'Орган'")
    public void selectRandomLobby() {
        List<WebElement> lobbyValueList = lobbylist.findElements(By.tagName("li"));
        if (lobbyValueList.size() > 1) {
            lobbyValueList = lobbyValueList.subList(1, lobbyValueList.size());
        }
        WebElement randomValue = getRandomElementInList(lobbyValueList);
        setParameter(LOBBY_VALUE, randomValue.getText());
        report("Выбран '" + randomValue.getText() + "' в поле 'Орган'");
        randomValue.click();
        waitForReloadingPage();
    }

    @Step("Выбрать случайное значение из поля 'Категория дела'")
    public void selectRandomCategory() {
        List<WebElement> lobbyValueList = categoryList.findElements(By.tagName("li"));
        if (lobbyValueList.size() > 1) {
            lobbyValueList = lobbyValueList.subList(1, lobbyValueList.size());
        }
        WebElement randomValue = getRandomElementInList(lobbyValueList);
        setParameter(CATEGORY_VALUE, randomValue.getText());
        report("Выбран '" + randomValue.getText() + "' в поле 'Категория'");
        randomValue.click();
        waitForReloadingPage();
    }

    @Step("Выбрать 'Регион'")
    public void selectRegionByName(String name) {
        waitForPresenceOfElementLocatedBy(By.xpath("//*[@id='regionlist']/li[text()='" + name + "']"), "Не найден 'Регион' - " + name).click();
        setParameter(REGION_VALUE, name);
        waitForReloadingPage();
    }

    @Step("Выбрать случайное значение из поля 'Регион'")
    public void selectRandomRegion() {
        List<WebElement> regionValueList = regionlist.findElements(By.tagName("li"));
        if (regionValueList.size() > 1) {
            regionValueList = regionValueList.subList(1, regionValueList.size());
        }
        WebElement randomValue = getRandomElementInList(regionValueList);
        setParameter(REGION_VALUE, randomValue.getText());
        report("Выбран '" + randomValue.getText() + "' в поле 'Регион'");
        randomValue.click();
        waitForReloadingPage();
    }

    @Step("Нажать на кнопку 'сбросить все'")
    public void clickClearFields() {
        clearAll.click();
        clearParameter(TYPE_VALUE);
        clearParameter(LOBBY_VALUE);
        clearParameter(REGION_VALUE);
        clearParameter(SEARCH_TEXT);
        clearParameter(SEARCH_NUMBER);
        clearParameter(START_DATE);
        clearParameter(START_DATE_NOT_FORMATTED);
        clearParameter(END_DATE);
        clearParameter(END_DATE_NOT_FORMATTED);
        waitForReloadingPage();
    }

    @Step("Проверяется что ссылка Сбросить все отображена")
    public void checkClearFieldsIsPresent() {
        postponedAssertTrue(clearAll.isDisplayed(), "Ссылка Сбросить все не отображена");
    }

    @Step("Выбрать чекбокс 'искать только в заголовках документа'")
    public void selectOnlyInTitlesCheckBox() {
        if (!onlyInTitlesCheckBox.isSelected()) {
            onlyInTitlesCheckBox.click();
            setParameter(ONLY_IN_TITLES, true);
        }
        waitForReloadingPage();
    }

    @Step("Отменить выбор чекбокс 'искать только в заголовках документа'")
    public void deSelectOnlyInTitlesCheckBox() {
        if (onlyInTitlesCheckBox.isSelected()) {
            onlyInTitlesCheckBox.click();
            setParameter(ONLY_IN_TITLES, false);
        }
        waitForReloadingPage();
    }

    @Step("Выбрать чекбокс 'искать только в дейсвтующих документа'")
    public void selectActualDocumentCheckBox() {
        if (!actualDocumentCheckBox.isSelected()) {
            actualDocumentCheckBox.click();
            setParameter(ACTUAL_DOCUMENTS, true);
        }
        waitForReloadingPage();
    }

    @Step("Отменить выбор чекбокс 'искать только в дейсвтующих документа'")
    public void deSelectActualDocumentCheckBox() {
        if (actualDocumentCheckBox.isSelected()) {
            actualDocumentCheckBox.click();
            setParameter(ACTUAL_DOCUMENTS, true);
        }
        waitForReloadingPage();
    }

    private String getSearchBodyResultText() {
        String resultText = "";
        if (!searchField.getText().isEmpty() && !searchField.getText().toLowerCase().contains("поиск документов")) {
            resultText = resultText + " с текстом «" + searchField.getText() + "»";
        }
        if (onlyInTitlesCheckBox.isSelected()) {
            resultText = resultText + ", только в заголовках документов";
        }
        if (!searchNmbrField.getText().isEmpty()) {
            resultText = resultText + ", с номером «" + searchNmbrField.getText() + "»";
        }
        if (!startDateField.getText().contains("дд.мм.гггг") && !startDateField.getText().isEmpty()) {
            resultText = resultText + ", созданные с " + getDateStringFromField(startDateField) + " года";
        }
        if (!endDateField.getText().contains("дд.мм.гггг") && !endDateField.getText().isEmpty()) {
            resultText = resultText + " до " + getDateStringFromField(endDateField) + " года";
        }
        if (!isFirstItemForListSelected(typelist)) {
            resultText = resultText + ", вид — «" + getSelectedItem(typelist) + "»";
        }
        if (!isFirstItemForListSelected(lobbylist)) {
            resultText = resultText + ", принявший орган — «" + getSelectedItem(lobbylist) + "»";
        }
        if (!isFirstItemForListSelected(regionlist)) {
            resultText = resultText + ", регион — «" + getSelectedItem(regionlist) + "»";
        }
        return resultText;
    }

    private String getSearchBodyResultInPracticeText() {
        String resultText = "";
        if (!searchField.getText().isEmpty() && !searchField.getText().toLowerCase().contains("поиск документов")) {
            resultText = resultText + " с текстом «" + searchField.getText() + "»";
        }
        if (onlyInTitlesCheckBox.isSelected()) {
            resultText = resultText + ", только в заголовках документов";
        }
        if (!searchNmbrField.getText().isEmpty()) {
            resultText = resultText + ", с номером «" + searchNmbrField.getText() + "»";
        }
        if (!startDateField.getText().contains("дд.мм.гггг") && !startDateField.getText().isEmpty()) {
            resultText = resultText + ", созданные с " + getDateStringFromField(startDateField) + " года";
        }
        if (!endDateField.getText().contains("дд.мм.гггг") && !endDateField.getText().isEmpty()) {
            resultText = resultText + " до " + getDateStringFromField(endDateField) + " года";
        }
        if (!isFirstItemForListSelected(typelist)) {
            resultText = resultText + ", вид — «" + getSelectedItem(typelist) + "»";
        }
        if (!isFirstItemForListSelected(categoryList)) {
            resultText = resultText + ", категория дела — «" + getSelectedItem(categoryList) + "»";
        }
        if (!isFirstItemForListSelected(lobbylist)) {
            resultText = resultText + ", принявший орган — «" + getSelectedItem(lobbylist) + "»";
        }
        return resultText;
    }

    private boolean isFirstItemForListSelected(WebElement value) {
        return value.findElements(By.tagName("li")).get(0).getAttribute("class").contains("selected");
    }

    private String getSelectedItem(WebElement value) {
        return value.findElement(By.cssSelector(".selected")).getText();
    }

    private String getDateStringFromField(TextField field) {
        String[] dateArr = field.getText().split("\\.");
        int numberFromField = Integer.parseInt(dateArr[1]);
        String monthName = "";
        for (Month month : Month.values()) {
            if (month.getMonthNumber() == numberFromField) {
                monthName = month.getMonthName();
                break;
            }
        }
        String day = dateArr[0].startsWith("0") ? dateArr[0].replace("0", "") : dateArr[0];

        return day + " " + monthName + " " + dateArr[2];
    }

    enum Month {
        january("января", 1),
        february("февраля", 2),
        march("марта", 3),
        april("апреля", 4),
        may("мая", 5),
        june("июня", 6),
        jule("июля", 7),
        august("августа", 8),
        september("сентября", 9),
        october("октября", 10),
        november("ноября", 11),
        december("декабря", 12);

        private String monthName;
        private int monthNumber;

        private Month(String monthName, int monthNumber) {
            this.monthName = monthName;
            this.monthNumber = monthNumber;
        }

        public String getMonthName() {
            return monthName;
        }

        public int getMonthNumber() {
            return monthNumber;
        }
    }

    @Step("Проверяется что отображается форме расширенного поиска")
    public void checkOpenedSearchExtended() {
        postponedAssertTrue(extendedFrom.isDisplayed(), "Форма расширенного поиска не отображается");
    }

    @Step("Проверяется что 'Найти' в поисковой строке НЕ отображается")
    public void checkNotDisplaySearchButton() {
        postponedAssertTrue(getSearchButton() == null || !getSearchButton().isDisplayed(), "Отображается кнопка 'Найти'");
    }

    @Step("Проверяется отображение чексбокса Только в заголовках")
    public void checkDisplayCheckboxOnlyTitle() {
        WebElement checkbox = findElementByNoThrow(extendedFrom, By.xpath(".//label[@for='onlyTitle']"));
        if (checkbox != null) {
            postponedAssertTrue(checkbox.isDisplayed(), "Не отображается чекбокс Только в заголовках");
        } else setPostponedTestFail("Не найден чекбокс Только в заголовках");
    }

    @Step("Проверяется отображение поля №")
    public void checkDisplayNumber() {
        WebElement number = findElementByNoThrow(extendedFrom, By.xpath(".//fieldset[@class='numer']"));
        if (number != null) {
            postponedAssertTrue(number.isDisplayed(), "Не отображается поле №");

        } else {
            setPostponedTestFail("Не найдено поле №");
        }
    }

    @Step("Проверяется поля с датой")
    public void checkDisplayDate() {
        WebElement date = findElementByNoThrow(extendedFrom, By.cssSelector(".data"));
        if (date != null) {
            postponedAssertEqualsText(findElementBy(date, By.cssSelector(".both")), "Дата");
            postponedAssertTrue(startDateField.getText().isEmpty() || "дд.мм.гггг".equals(startDateField.getText()), "Неправильное значение по-умолчанию для поля 'Дата начала'");
            postponedAssertTrue(endDateField.getText().isEmpty() || "дд.мм.гггг".equals(endDateField.getText()), "Неправильное значение по-умолчанию для поля 'Дата конца'");
        } else {
            setPostponedTestFail("Не найден поле Дата");
        }
    }

    @Step("Проверяется поля Вид")
    public void checkDisplayLabelType() {
        WebElement type = findElementByNoThrow(extendedFrom, By.xpath(".//label[@for='sd-type']"));
        if (type != null) {
            postponedAssertTrue(type.isDisplayed(), "Не отображется Тип");
            postponedAssertEqualsText(type, "Вид");
            postponedAssertEquals(typeInput.getAttribute("value"), "письмо, закон, акт", "Текст не совпадает");
        } else {
            setPostponedTestFail("Не найден элемент Тип");
        }
    }

    @Step("Проверяется отображение поля Орган")
    public void checkDisplayLabelLobby() {
        WebElement lobby = findElementByNoThrow(extendedFrom, By.xpath(".//label[@for='sd-entity']"));
        if (lobby != null) {
            postponedAssertTrue(lobby.isDisplayed(), "Не отображется Орган");
            postponedAssertEqualsText(lobby, "Орган");
            postponedAssertEquals(lobbyInput.getAttribute("value"), "минздрав, правительство", "Текст не совпадает");
        } else {
            setPostponedTestFail("Не найден элемент Орган");
        }
    }

    @Step("Проверяется отображение поля Регион")
    public void checkDisplayLabelRegion() {
        WebElement region = findElementByNoThrow(extendedFrom, By.xpath(".//label[@for='sd-region']"));
        if (region != null) {
            postponedAssertTrue(region.isDisplayed(), "Не отображется Регион");
            postponedAssertEqualsText(region, "Регион");
            postponedAssertEquals(regionInput.getAttribute("value"), "край или область", "Текст не совпадает");
        } else {
            setPostponedTestFail("Не найден элемент Регион");
        }
    }

    @Step("Проверяется строки результов")
    public void checkSearchDescription() {
        WebElement searchDescription = findElementByNoThrow(extendedFrom, By.cssSelector(".search-description"));
        if (searchDescription != null) {
            postponedAssertTrue(searchDescription.isDisplayed(), "Не отображается строка результатов");
            postponedAssertNotEquals(searchDescription.getText(), "", "Нет текста в строке резутатов");
        } else {
            setPostponedTestFail("Не найден элемент строка результатов");
        }
    }

    @Step("Проверяется что кнопка Найти отображется в форме расширенного поиска")
    public void checkSearchButtonInExtendedFormIsPresent() {
        WebElement searchButton = findElementByNoThrow(extendedFrom, By.id("button-search-extended"));
        assertNotNull(searchButton, "Кнопка Найти в форме расширенного поиска не найдена");
        postponedAssertTrue(searchButton.isEnabled() && searchButton.isDisplayed(), "Кнопка Найти в форме расширенного поиска не отображается");
    }

    @Step("Нажать кнопку 'В законадательстве'")
    public void clickInLawBaseButton() {
        inLawBase.click();
        waitForReloadingPage();
    }

    @Step("Нажать кнопку 'В судебной практике'")
    public void clickInLawPracticeButton() {
        inLawPractice.click();
        waitForReloadingPage();
    }

    @Step("Ввести в поле Вид название")
    public void inputInTypeTextField(String type) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].value = '';", typeInput);
//        typeInput.click();
        typeInput.sendKeys(type);
        lobbyInput.click();
    }

    @Step("Ввести в поле орган название")
    public void inputInLobbyTextField(String lobby) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].value = '';", lobbyInput);
        lobbyInput.sendKeys(lobby);
        regionInput.click();
    }

    @Step("Ввести в поле регион название")
    public void inputInRegionTextField(String region) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].value = '';", regionInput);
//        regionInput.clear();
//        regionInput.click();
        regionInput.sendKeys(region);
        typeInput.click();
    }

    @Step("Проверить что в листе Орган остались отсортированные результаты")
    public void checkLobbyListItemsContainText(String expectedLobby) {
        List<WebElement> lobbyElements = lobbylist.findElements(By.tagName("li"));
        postponedAssertTrue(lobbyElements.size() > 1, "В листе Органов найдено менее двух элементов, и первый элемент не является искомым.");
        boolean hasMultiplicitlyExpectedLobbies = false;
        if (expectedLobby.contains(",")) {
            hasMultiplicitlyExpectedLobbies = true;
        }
        for (int i = 1; i < lobbyElements.size(); i++) {
            String actualLobby = lobbyElements.get(i).getText();
            if (hasMultiplicitlyExpectedLobbies) {
                boolean isFound = false;
                for (String lobby : expectedLobby.split(",")) {
                    if (actualLobby.contains(lobby.trim())) {
                        postponedAssertTrue(actualLobby.contains(lobby.trim()), "Нет вхождения в листе выбора Органов, ищем " +
                                "вхождение '" + lobby + "' в данной строке: '" + actualLobby + "'.");
                        isFound = true;
                    }
                }
                if (isFound == false) {
                    setPostponedTestFail("Нет вхождения в листе выбора Органов, ищем " +
                            "вхождение одного из слов '" + expectedLobby + "' в данной строке: '" + actualLobby + "'.");
                }
            } else {
                postponedAssertTrue(actualLobby.contains(expectedLobby), "Нет вхождения в листе выбора Органов, ищем " +
                        "вхождение '" + expectedLobby + "' в данной строке: '" + actualLobby + "'.");
            }
        }
    }


    private WebElement getSearchButton() {
        WebElement searchButton;
        if (getSettings().isRunFss()) {
            searchButton = findElementByNoThrow(By.xpath(".//form[@id='search-form']/input[@value='Найти']"));
        } else if (getSettings().isRunBss() || getSettings().isRunUss()) {
            searchButton = findElementByNoThrow(By.xpath(".//form[@id='search-form']/button[@class='button-search js-search-button']"));
        } else {
            searchButton = findElementByNoThrow(By.id("button-search"));
        }
        return searchButton;
    }

    public void checkExactPhraseIsNotActivated() {
        postponedAssertFalse(exactPhraseCheckBox.isEnabled(), "Чекбокс Только точную фразу активен");
    }

    public void checkExactPhraseIsActivated() {
        postponedAssertTrue(exactPhraseCheckBox.isEnabled(), "Чекбокс Только точную фразу не активен");
    }

    public void checkExactPhraseIsNotChecked() {
        postponedAssertFalse(exactPhraseCheckBox.isSelected(), "Чекбокс Только точную фразу активен");
    }

    public void checkSearchAdviceListHasLensIcon() {
        SearchAdviceList searchAdviceList = new SearchAdviceList();
        postponedAssertTrue(searchAdviceList.isLensVisible(), "Иконка увеличительной лупы не отображается в поисковых " +
                "подсказках фильтра документа расширенного поиска");
    }

    public void checkSearchAdviceListHasSearchQuery(String query) {
        SearchAdviceList searchAdviceList = new SearchAdviceList();
        postponedAssertEquals(searchAdviceList.getSearchQueryInAdviceList(), query, "В поисковых подсказках найдено " +
                "значение запроса:" + searchAdviceList.getSearchQueryInAdviceList() + ", а должно быть:" + query);
    }

    public void checkSearchAdviceListHasTextGoToTheDocument() {
        String textGoToTheDocument = "Перейти в документ:";
        SearchAdviceList searchAdviceList = new SearchAdviceList();
        postponedAssertEquals(searchAdviceList.getTextGoToDocument(), textGoToTheDocument, "В поисковых подсказках " +
                "ожидался текст:" + textGoToTheDocument + ", но был найден:" + searchAdviceList.getTextGoToDocument());
    }

    public void checkSearchAdviceListHasMax10Advices() {
        SearchAdviceList searchAdviceList = new SearchAdviceList();
        postponedAssertTrue(searchAdviceList.getCountOfResults() <= 10, "В поисковых подсказках фильтра документа " +
                "расширенного поиска отображено более 10 результатов");
    }

    public void checkSearchAdviceListHasHints() {
        SearchAdviceList searchAdviceList = new SearchAdviceList();
        Iterator iterator = searchAdviceList.getHintResults().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            String hint = (String) iterator.next();
            i++;
            if (hint.toString() == null || hint.equals("")) {
                setPostponedTestFail("Напротив подсказки с номером документа:" + searchAdviceList.getSearchResults().get(i) + " отображается пустое примечание.");
            }
        }
    }

    public String clickOnSearchAdviceListHintWithCountOfDocumentsFound() {
        SearchAdviceList searchAdviceList = new SearchAdviceList();
        int number = searchAdviceList.clickOnSearchResultWithExtendedSearch();
        return searchAdviceList.getSearchResults().get(number);
    }

    public void clickOnSearchAdviceListRemarkWithDocumentName() {
        SearchAdviceList searchAdviceList = new SearchAdviceList();
        searchAdviceList.clickOnSearchResultWithDocumentName();
    }

    public void checkNavigationByHintsWithKeysDownAndUp() {
        SearchAdviceList searchAdviceList = new SearchAdviceList();
        int countOfPressKeyDown = 3;

        Actions actions = new Actions(getDriver());
        actions.sendKeys(Keys.ARROW_DOWN).build().perform();

        for (int i = 0; i < countOfPressKeyDown; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).build().perform();
            waitForReloadingPage();
            postponedAssertEquals(searchAdviceList.getResults().get(i).getAttribute("class"), "over", "Выбранная " +
                    "подсказка не выделена желтым цветом");
            String text = searchAdviceList.getSearchResults().get(i);
            postponedAssertEquals(searchNmbrField.getText(), text, "Выбранная подсказка отображается некоректно в поле " +
                    "ввода номера документа. Отображено в поле:" + searchNmbrField.getText() + ", а должно быть:" + text);
        }
        actions.sendKeys(Keys.ARROW_UP).build().perform();
        waitForReloadingPage();
        postponedAssertEquals(searchAdviceList.getResults().get(countOfPressKeyDown - 2).getAttribute("class"), "over", "Выбранная " +
                "подсказка не выделена желтым цветом");
        String text = searchAdviceList.getSearchResults().get(countOfPressKeyDown - 2);
        postponedAssertEquals(searchNmbrField.getText(), text, "Выбранная подсказка отображается некоректно в поле " +
                "ввода номера документа. Отображено в поле:" + searchNmbrField.getText() + ", а должно быть:" + text);

        actions.sendKeys(Keys.ENTER).build().perform();
        waitForReloadingPage();
    }

    private class SearchAdviceList {

        @FindBy(id = "ac1")
        private WebElement searchAdviceList;

        private List<String> searchResults;

        private List<String> hintResults;

        public SearchAdviceList() {
            fillAdviceList();
        }

        public boolean isSearchAdviceListPresent() {
            return searchAdviceList.isDisplayed();
        }

        public List<String> getSearchResults() {
            return searchResults;
        }

        public List<String> getHintResults() {
            return hintResults;
        }

        /**
         * Returns true if lens is visible in the first search result in the advice list
         */
        public boolean isLensVisible() {
            String nameLensFile = "lens.gif"; //name of lens file
            WebElement firstResult = findElementBy(By.cssSelector(".search-advice-list li.normal-search"));
            String attributeElement = firstResult.getCssValue("background-image");
            if (attributeElement.contains(nameLensFile)) {
                return true;
            } else {
                return false;
            }
        }

        public String getSearchQueryInAdviceList() {
            return findElementBy(By.xpath("//*[@id='sd-helper-list']/li[1]")).getText();
        }

        public String getTextGoToDocument() {
            return findElementBy(By.xpath("//*[@id='sd-helper-list']/li[2]")).getText();
        }

        public int getCountOfResults() {
            return getResults().size();
        }

        public void clickOnSearchResult(int number) {
            getResults().get(number).click();
        }

        public int clickOnSearchResultWithDocumentName() {
            String documentExtendedSearch = "Найдено";
            for (int i = 0; i < hintResults.size(); i++) {
                if (!hintResults.get(i).contains(documentExtendedSearch)) {
                    getResults().get(i).click();
                    return i;
                }
            }
            throw new IllegalStateException("Found '" + documentExtendedSearch + "' in the advice list:"
                    + hintResults);
        }

        public int clickOnSearchResultWithExtendedSearch() {
            String documentExtendedSearch = "Найдено";
            for (int i = 0; i < hintResults.size(); i++) {
                if (hintResults.get(i).contains(documentExtendedSearch)) {
                    getResults().get(i).click();
                    return i;
                }
            }
            throw new IllegalStateException("Cannot find '" + documentExtendedSearch + "' in the advice list:"
                    + hintResults);
        }

        public void pressKeyArrowDown() {
            searchAdviceList.sendKeys(Keys.ARROW_DOWN);
        }

        public void pressKeyArrowUp() {
            searchAdviceList.sendKeys(Keys.ARROW_UP);
        }

        public void pressKeyEnter() {
            searchAdviceList.sendKeys(Keys.ENTER);
        }

        private List<WebElement> getResults() {
            return searchAdviceList.findElements(By.xpath("//*[@id='sd-helper-list']/li[@data-role]" +
                    "[not(contains(@data-role,'normal-search'))]"));
        }

        private void fillAdviceList() {
            if (searchAdviceList == null) {
                executeScript("document.getElementById('ac1').setAttribute('style','display:block;')");
                searchAdviceList = findElementBy(By.id("ac1"));
            }

            List<WebElement> results = getResults();
            searchResults = new ArrayList<String>();
            hintResults = new ArrayList<String>();

            if (results.size() == 0) {
                throw new IllegalStateException("Search Advice List в правовой базе расширенного поиска (для номеров " +
                        "документов) не отображает .");
            }

            for (int i = 0; i < results.size(); i++) {
                searchResults.add(i, results.get(i).findElement(By.xpath("./span")).getText());
                hintResults.add(i, results.get(i).findElement(By.xpath("./i")).getText());
            }
        }
    }
}
