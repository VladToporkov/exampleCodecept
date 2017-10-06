package com.actionmedia.pages.edu;

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
public class EduDictionaryPage extends EduBasePage<EduDictionaryPage> implements IDictionaryPage {
    @Override
    public EduDictionaryPage checkDictionaryTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.DICTIONARIES);
        return this;
    }

    @Override
    public EduDictionaryPage checkDictionaryBoardIsDisplayed() {
        getHelper(DictionaryPageHelper.class).checkDictionaryBoardIsDisplayed();
        return this;
    }

    @Step("Нажимается ссылка на календарь")
    public EduDictionaryPage clickFactoryCalendarLink() {
        getHelper(DictionaryPageHelper.class).clickFactoryCalendarLink();
        return this;
    }

    @Step("Проверяется открытие производственного календаря")
    public EduDictionaryPage checkFactoryCalendar() {
        getHelper(DictionaryPageHelper.class).checkFactoryCalendar();
        return this;
    }

    public EduDictionaryPage checkTitle() {
        getHelper(DictionaryPageHelper.class).checkTitle();
        return this;
    }

    public EduDictionaryPage checkCalendarBlock() {
        getHelper(DictionaryPageHelper.class).checkCalendarBlock();
        return this;
    }

    public EduDictionaryPage checkEventsTitle() {
        getHelper(DictionaryPageHelper.class).checkEventsTitle();
        return this;
    }

    @Step("Проверяется отображение блока 'События'")
    public EduDictionaryPage checkEvents() {
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

    public EduDictionaryPage checkNotDisplayStars() {
        getHelper(DictionaryPageHelper.class).checkNotDisplayStars();
        return this;
    }

    public EduDictionaryPage checkEventsBlock() {
        getHelper(DictionaryPageHelper.class).checkEventsBlock();
        return this;
    }
}
