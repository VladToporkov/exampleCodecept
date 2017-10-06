package com.actionmedia.pages.go;

import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.helpers.DictionaryPageHelper;
import com.actionmedia.pages.interfaces.IDictionaryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

/**
 * Created by Pavel on 04/07/16.
 */
@Component
public class GoDictionaryPage extends GoBasePage<GoDictionaryPage> implements IDictionaryPage {

    @Step("Проверяется что в главном меню выбрана страница 'Справочник'")
    public GoDictionaryPage checkDictionaryTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.DICTIONARIES);
        return this;
    }

    @Step("Проверяется что справочная доска отображается")
    public GoDictionaryPage checkDictionaryBoardIsDisplayed() {
        getHelper(DictionaryPageHelper.class).checkDictionaryBoardIsDisplayed();
        return this;
    }

    @Step("Нажимается ссылка на календарь")
    public GoDictionaryPage clickFactoryCalendarLink() {
        getHelper(DictionaryPageHelper.class).clickFactoryCalendarLink();
        return this;
    }

    @Step("Проверяется открытие производственного календаря")
    public GoDictionaryPage checkFactoryCalendar() {
        getHelper(DictionaryPageHelper.class).checkFactoryCalendar();
        return this;
    }

    public GoDictionaryPage checkTitle() {
        getHelper(DictionaryPageHelper.class).checkTitle();
        return this;
    }

    public GoDictionaryPage checkCalendarBlock() {
        getHelper(DictionaryPageHelper.class).checkCalendarBlock();
        return this;
    }

    public GoDictionaryPage checkEventsTitle() {
        getHelper(DictionaryPageHelper.class).checkEventsTitle();
        return this;
    }

    @Step("Проверяется отображение блока 'События'")
    public GoDictionaryPage checkEvents() {
        WebElement events = findElementByNoThrow(By.cssSelector("#document-body .js-table_content_scheduler-task"));
        WebElement column = findElementByNoThrow(events, By.xpath(".//tr"));
        if ((events != null) && (column != null)) {
            List<WebElement> columnTitle = findElementsByNoThrow(column, By.tagName("th"));
            for (WebElement title : columnTitle) {
                postponedAssertTrue(title.getText().contains("Название") || title.getText().contains("Описание") || title.getText().contains("Дополнительная информация"), "Неверное наименование колонок блока 'События' " + title);
            }
        } else {
            setPostponedTestFail("Элемент 'Блок События' не найден");
        }
        return this;
    }

    public GoDictionaryPage checkNotDisplayStars() {
        getHelper(DictionaryPageHelper.class).checkNotDisplayStars();
        return this;
    }

    public GoDictionaryPage checkEventsBlock() {
        getHelper(DictionaryPageHelper.class).checkEventsBlock();
        return this;
    }
}
