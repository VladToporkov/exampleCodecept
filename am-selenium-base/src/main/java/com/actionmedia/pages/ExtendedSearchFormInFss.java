package com.actionmedia.pages;

import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.autotest.selenium.annotations.Wait;
import com.actionmedia.autotest.selenium.context.AbstractComponent;
import com.actionmedia.autotest.selenium.elements.Button;
import com.actionmedia.autotest.selenium.elements.CheckBox;
import com.actionmedia.autotest.selenium.elements.TextField;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 29.01.14
 * Time: 11:00
 */
@Component
public class ExtendedSearchFormInFss extends AbstractComponent<ExtendedSearchFormInFss> {

    public static final String TYPE_VALUE = "type.value";
    public static final String LOBBY_VALUE = "lobby.value";
    public static final String REGION_VALUE = "region.value";
    public static final String SEARCH_TEXT = "search.text";
    public static final String SEARCH_NUMBER = "search.number";
    public static final String START_DATE = "start.date";
    public static final String END_DATE = "end.date";
    public static final String ACTUAL_DOCUMENTS = "actual.documents";
    public static final String ONLY_IN_TITLES = "only.in.titles";

    @Wait
    @FindBy(id = "form-search")
    private WebElement extendedFrom;

    @Wait
    @FindBy(id = "sd_search_real")
    private CheckBox actualDocumentCheckBox;

    @Wait
    @FindBy(id = "sd_search_title")
    private CheckBox onlyInTitlesCheckBox;

    @Wait
    @FindBy(id = "button_search_extended")
    private Button searchButton;

    @Wait
    @FindBy(id = "search-input")
    private TextField searchField;

    @Wait
    @FindBy(id = "search_number")
    private TextField searchNmbrField;

    @Wait
    @FindBy(id = "sd_date_start")
    private TextField startDateField;

    @Wait
    @FindBy(id = "sd_date_end")
    private TextField endDateField;

    @Wait
    @FindBy(id = "search_body_result")
    private WebElement searchBodyResultText;

    @Wait
    @FindBy(id = "type_list")
    private WebElement typelist;

    @Wait
    @FindBy(id = "entity_list")
    private WebElement lobbylist;

    @Wait
    @FindBy(id = "region_list")
    private WebElement regionlist;

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
                            "Ожидаемый: " + "Найти действующие документы" + getSearchBodyResultText() +
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
    }

    @Step("Ввести текст в строку поиска")
    public void inputTextInSearchField(String text) {
        searchField.clearAndType(text);
        setParameter(SEARCH_TEXT, text);
        report("Текст в строке поиска -  " + text);
    }

    @Step("Ввести текст в поле 'Номер'")
    public void inputTextInNumberField(String text) {
        searchNmbrField.clearAndType(text);
        setParameter(SEARCH_NUMBER, text);
        report("Текст в поле 'Номер' -  " + text);
        findElementBy(By.id("searchNmbr")).sendKeys(Keys.ESCAPE);
    }

    @Step("Ввести текст в поле 'Дата начала'")
    public void inputTextInStartDateField(String text) {
        startDateField.clearAndType(text);
        setParameter(START_DATE, text);
        report("Текст в поле 'Дата начала' -  " + text);
    }

    @Step("Ввести текст в поле 'Дата конца'")
    public void inputTextInEndDateField(String text) {
        endDateField.clearAndType(text);
        setParameter(END_DATE, text);
        report("Текст в поле 'Дата конца' -  " + text);
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
        clearParameter(END_DATE);
    }

    @Step("Выбрать 'Вид'")
    public void selectTypeByName(String name) {
        typelist.findElement(By.xpath("//li[text()='" + name + "']")).click();
        setParameter(TYPE_VALUE, name);
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
    }

    @Step("Выбрать 'Орган'")
    public void selectLobbyByName(String name) {
        lobbylist.findElement(By.xpath("//li[text()='" + name + "']")).click();
        setParameter(LOBBY_VALUE, name);
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
    }

    @Step("Выбрать 'Регион'")
    public void selectRegionByName(String name) {
        regionlist.findElement(By.xpath("//li[text()='" + name + "']")).click();
        setParameter(REGION_VALUE, name);
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
    }

    @Step("Нажать на кнопку 'сбросить все'")
    public void clickClearFields() {
        clearParameter(TYPE_VALUE);
        clearParameter(LOBBY_VALUE);
        clearParameter(REGION_VALUE);
        clearParameter(SEARCH_TEXT);
        clearParameter(SEARCH_NUMBER);
        clearParameter(START_DATE);
        clearParameter(END_DATE);
    }

    @Step("Выбрать чекбокс 'искать только в заголовках документа'")
    public void selectOnlyInTitlesCheckBox() {
        if (!onlyInTitlesCheckBox.isSelected()) {
            onlyInTitlesCheckBox.click();
            setParameter(ONLY_IN_TITLES, true);
        }
    }

    @Step("Отменить выбор чекбокс 'искать только в заголовках документа'")
    public void deSelectOnlyInTitlesCheckBox() {
        if (onlyInTitlesCheckBox.isSelected()) {
            onlyInTitlesCheckBox.click();
            setParameter(ONLY_IN_TITLES, false);
        }
    }

    @Step("Выбрать чекбокс 'искать только в дейсвтующих документа'")
    public void selectActualDocumentCheckBox() {
        if (!actualDocumentCheckBox.isSelected()) {
            actualDocumentCheckBox.click();
            setParameter(ACTUAL_DOCUMENTS, true);
        }
    }

    @Step("Отменить выбор чекбокс 'искать только в дейсвтующих документа'")
    public void deSelectActualDocumentCheckBox() {
        if (actualDocumentCheckBox.isSelected()) {
            actualDocumentCheckBox.click();
            setParameter(ACTUAL_DOCUMENTS, true);
        }
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
        return resultText + ".";
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
}
