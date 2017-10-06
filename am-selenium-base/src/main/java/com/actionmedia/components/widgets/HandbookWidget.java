package com.actionmedia.components.widgets;

import com.actionmedia.autotest.selenium.annotations.Wait;
import com.actionmedia.base.BasePage;
import com.actionmedia.pages.helpers.SearchResultHelper;
import com.actionmedia.util.TestUtils;
import com.ibm.icu.util.Calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Pavel on 06/04/16.
 */
@Component
public class HandbookWidget extends BasePage<HandbookWidget> {

    @FindBy(id = "widget-handbook")
    @Wait
    @CacheLookup
    private WebElement widget;

    private final String titleText = "Справочник";

    @Step("Проверяется что виджет Справочник отображается")
    public void checkWidgetIsPresent() {
        postponedAssertTrue(widget.isEnabled() && widget.isDisplayed(), "Виджет " + titleText + " не отображается");
    }

    @Step("Проверяется, что отображается заголовок виджета")
    public void checkTitleIsPresent() {
        WebElement titleLink = findElementByNoThrow(widget, By.cssSelector(".widget__title-text"));
        postponedAssertEqualsText(titleLink, titleText);
    }

    @Step("Проверяется, что отображается количество документов в разделе")
    public void checkDocumentCountIsPresent() {
        WebElement documentCount = findElementByNoThrow(widget, By.cssSelector(".widget__count"));
        postponedAssertNotNull(documentCount, "Общее Количество документов не найдено");
        if (documentCount == null) {
            return;
        }
        postponedAssertTrue(documentCount.isDisplayed(), "Общее количество документов не отображается");
    }

    @Step("Проверяется, что отображается сегодняшняя дата и элемент не кликабелен")
    public void checkDateTodayIsPresent() {
        WebElement dayElement = findElementByNoThrow(widget, By.cssSelector(".list__text_content_date"));
        WebElement dateElement = findElementByNoThrow(widget, By.cssSelector(".list__text_content_day"));
        postponedAssertNotNull(dayElement, "Дата не найдена");
        postponedAssertNotNull(dateElement, "День не найден");
        postponedAssertFalse(dateElement.getText().isEmpty(), "День не найден");
        postponedAssertEqualsText(dayElement, String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)));
        postponedAssertEqualsText(dateElement, TestUtils.getShortDayNameByNumberDayOfWeek(Calendar.getInstance().get(Calendar.DAY_OF_WEEK)));
        WebElement anyLinkInBlockOrder1 = findElementByNoThrow(widget, By.cssSelector(".list__item_order_1 a"));
        postponedAssertNull(anyLinkInBlockOrder1, "Ссылка в блоке найдена!");
    }

    @Step("Проверяется, что отображается заголовок текущий месяц")
    public void checkMonthNowIsPresent() {
        WebElement monthElement = findElementByNoThrow(widget, By.cssSelector(".list__item_order_2 .list__title"));
        postponedAssertNotNull(monthElement, "Месяц в виджете не найден");
        postponedAssertTrue(monthElement.isDisplayed(), "Месяц в виджете не отображается");
//        postponedAssertEqualsText(monthElement, TestUtils.getMonthNameInRussian(Calendar.getInstance().get(Calendar.MONTH) + 1)); // +1 because Calendar returns Month number started from zero
    }

    @Step("Проверяется, что отображается количество рабочих дней")
    public void checkWorkingDaysElementIsPresent() {
        WebElement weekdays = findElementByNoThrow(widget, By.cssSelector(".list__item_order_2 .list__text_content_weekdays"));
        postponedAssertNotNull(weekdays, "Количество рабочих дней не найдено");
        postponedAssertTrue(weekdays.isDisplayed(), "Количество рабочих дней не отображено");
    }

    @Step("Проверяется, что отображается количество выходных дней")
    public void checkHolidaysElementIsPresent() {
        WebElement holidays = findElementByNoThrow(widget, By.cssSelector(".list__item_order_2 .list__text_content_holidays"));
        postponedAssertNotNull(holidays, "Количество выходных дней не найдено");
        postponedAssertTrue(holidays.isDisplayed(), "Количество выходных дней не отображено");
    }

    @Step("Проверяется, что отображается заголовок Курс валют")
    public void checkExchangeRatesTitleIsPresent() {
        WebElement exchangeRatesTitle = findElementByNoThrow(widget, By.cssSelector(".list__item_order_3 .list__title"));
        postponedAssertNotNull(exchangeRatesTitle, "Курсы валют в виджете не найден");
        postponedAssertTrue(exchangeRatesTitle.isDisplayed(), "Курсы валют в виджете не отображается");
        postponedAssertEqualsText(exchangeRatesTitle, "Курс валют");
    }

    @Step("Проверяется, что отображается курс доллара")
    public void checkDollarRateIsPresent() {
        WebElement dollarRateElement = findElementByNoThrow(widget, By.cssSelector(".list__item_order_3 .list__text_content_usd"));
        postponedAssertNotNull(dollarRateElement, "Курс доллара не найден");
        postponedAssertTrue(dollarRateElement.isDisplayed(), "Курс доллара не отображается");
    }

    @Step("Проверяется, что отображается курс евро")
    public void checkEuroRateIsPresent() {
        WebElement euroRateElement = findElementByNoThrow(widget, By.cssSelector(".list__item_order_3 .list__text_content_eur"));
        postponedAssertNotNull(euroRateElement, "Курс евро не найден");
        postponedAssertTrue(euroRateElement.isDisplayed(), "Курс евро не отображается");
    }

    @Step("Проверяется, что отображается заголовок МРОТ")
    public void checkMinimunWageTitleIsPresent() {
        WebElement wageTitle = findElementByNoThrow(widget, By.cssSelector(".list__item_order_4 .list__title"));
        postponedAssertNotNull(wageTitle, "МРОТт в виджете не найден");
        postponedAssertTrue(wageTitle.isDisplayed(), "МРОТ в виджете не отображается");
        postponedAssertEqualsText(wageTitle, "МРОТ");
    }

    @Step("Проверяется, что отображена ставка МРОТ")
    public void checkWageIsPresent() {
        WebElement minWageElement = findElementByNoThrow(widget, By.cssSelector(".list__item_order_4 .list__text_content_rub"));
        postponedAssertNotNull(minWageElement, "Ставка МРОТ не найден");
        postponedAssertTrue(minWageElement.isDisplayed(), "Ставка МРОТ не отображается");
    }

    @Step("Проверяется, что отбражается ссылка В регионе")
    public void checkLinkInRegionIsPresent() {
        WebElement inRegionLink = findElementByNoThrow(widget, By.cssSelector(".list__item_order_4 a.js-widget-wage-region"));
        postponedAssertEqualsText(inRegionLink, "в регионе");
    }

    @Step("Проверяется, что отображается ссылка на рубрику")
    public void checkLinkRubricIsPresent() {
        WebElement rubricElement = findElementByNoThrow(widget, By.cssSelector(".list_viewtype_more li:nth-of-type(1) > a"));
        postponedAssertNotNull(rubricElement, "Рубрика не найден");
        postponedAssertTrue(rubricElement.isDisplayed(), "Рубрика не отображается");
    }

    @Step("Проверяется, что отображается ссылка Изменения")
    public void checkLinkChangesIsPresent() {
        WebElement changesElement = findElementByNoThrow(widget, By.cssSelector(".list_viewtype_more li:nth-of-type(2) > a"));
        postponedAssertNotNull(changesElement, "Изменения не найден");
        postponedAssertTrue(changesElement.isDisplayed(), "Изменения не отображается");
        postponedAssertEqualsText(changesElement, "Изменения");
    }

    @Step("Нажать на ссылку Заголовок")
    public void clickOnTitle() {
        WebElement titleLink = findElementByNoThrow(widget, By.cssSelector(".widget__title-text"));
        titleLink.click();
        waitForReloadingPage();
    }

    @Step("Нажать на ссылку Блок календаря")
    public void clickOnCalendar() {
        WebElement calendarBlock = findElementByNoThrow(widget, By.cssSelector(".list__item_order_2 > a"));
        setParameter(SearchResultHelper.DOCUMENT_URL, calendarBlock.getAttribute("href"));
        calendarBlock.click();
        waitForReloadingPage();
    }

    @Step("Нажать на ссылку Блок МРОТ")
    public void clickOnExchangeRatesBlock() {
        WebElement minWageBlock = findElementByNoThrow(widget, By.cssSelector(".list__item_order_4 > a"));
        setParameter(SearchResultHelper.DOCUMENT_URL, minWageBlock.getAttribute("href"));
        minWageBlock.click();
        waitForReloadingPage();
    }

    @Step("Нажать на ссылку Рубрики")
    public void clickOnRubricLink() {
        WebElement rubricElement = findElementByNoThrow(widget, By.cssSelector(".list_viewtype_more li:nth-of-type(1) > a"));
        setParameter(SearchResultHelper.DOCUMENT_URL, rubricElement.getAttribute("href"));
        rubricElement.click();
        waitForReloadingPage();
    }

    @Step("Нажать на ссылку Изменения")
    public void clickOnChangesLink() {
        WebElement changesElement = findElementByNoThrow(widget, By.cssSelector(".list_viewtype_more li:nth-of-type(2) > a"));
        setParameter(SearchResultHelper.DOCUMENT_URL, changesElement.getAttribute("href"));
        changesElement.click();
        waitForReloadingPage();
    }

    @Step("Нажать на ссылку В регионе")
    public void clickOnInRegionLink() {
        WebElement inRegionLink = findElementByNoThrow(widget, By.cssSelector(".list__item_order_4 a.js-widget-wage-region"));
        inRegionLink.click();
    }
}
