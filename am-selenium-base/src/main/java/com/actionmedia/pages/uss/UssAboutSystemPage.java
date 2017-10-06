package com.actionmedia.pages.uss;

import ru.yandex.qatools.allure.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 06.02.14
 * Time: 12:19
 */
@Component
public class UssAboutSystemPage extends UssBasePage<UssAboutSystemPage> {

    private static final int TIME_TO_SCROLL = 10000;

    @Step("Проверяется что страница 'О системе' открыта")
    public UssAboutSystemPage checkAboutSystemPageIsOpened() {
        WebElement aboutSystemPage = findElementByNoThrow(By.id("about"));
        postponedAssertNotNull(aboutSystemPage, "Страница 'О системе' не открыта");
        return this;
    }

    @Step("Проверяется подсветка в содере при скролле")
    public UssAboutSystemPage checkPageScroll() {
        WebElement soder = waitForVisibilityOfElementLocatedBy(By.id("side_nav"), "Рубрикатор содержания не найден");
        List<WebElement> itemList = soder.findElements(By.cssSelector(".side-nav__item"));

        int position = 0;
        for (WebElement item : itemList) {
            long startTime = new Date().getTime();
            while ("none".equals(item.getCssValue("background-image"))) {
                executeScript("window.scrollTo(" + 0 + ", " + position + "); return true;");
                if (new Date().getTime() - startTime > TIME_TO_SCROLL) {
                    setPostponedTestFail("Подсветка содера не переместилась к разделу " + item.getText() + " в течениии " + (TIME_TO_SCROLL / 1000) + " секунд");
                    break;
                }
                position += 100;
            }
        }
        return this;
    }

    @Step("Проверяется что открыта вкладка 'Попробовать'")
    public UssAboutSystemPage checkTryTrialTabIsSelected() {
        checkTabIsSelected("Попробовать");
        return this;
    }

    @Step("Проверяется что содержание вкладки 'Попробовать' отображается")
    public UssAboutSystemPage checkTryTrialTabIsOpened() {
        checkTabIsOpened(By.id("try"), "Попробовать");
        return this;
    }

    @Step("Проверяется что открыта вкладка 'Заказать презентацию'")
    public UssAboutSystemPage checkOrderCallTabIsSelected() {
        checkTabIsSelected("Заказать звонок");
        return this;
    }

    @Step("Проверяется что содержание вкладки 'Заказать презентацию' отображается")
    public UssAboutSystemPage checkOrderCallTabIsOpened() {
        checkTabIsOpened(By.id("order-call"), "Заказать звонок");
        return this;
    }

    @Step("Проверяется что открыта вкладка 'Купить'")
    public UssAboutSystemPage checkBuyTabIsSelected() {
        checkTabIsSelected("Купить");
        return this;
    }

    @Step("Проверяется что содержание вкладки 'Купить' отображается")
    public UssAboutSystemPage checkBuyTabIsOpened() {
        checkTabIsOpened(By.id("buy-city"), "Купить");
        return this;
    }

    @Step("Проверяется что блок получить демо отображается")
    public UssAboutSystemPage checkTryTrialContentIsPresent() {
        WebElement demoBlock = waitForVisibilityOfElementLocatedBy(By.id("try"), "Содержание вкладки 'Попробовать' не отображается");
        postponedAssertNotNull(demoBlock, "Блок получить демо не найден");
        if (demoBlock != null) {
            postponedAssertTrue(demoBlock.isDisplayed(), "Блок получить демо не отображается");
            postponedAssertFalse(demoBlock.getText().isEmpty(), "Блок получить демо пустой");

            WebElement button = findElementByNoThrow(demoBlock, By.cssSelector(".b-button"));
            postponedAssertNotNull(button, "Отсутсвуте кнопка 'Получить демодоступ' в форме заказа презентации");
            if (button != null) {
                postponedAssertEquals(button.getText(), "Получить демодоступ", "Неправильный текст кнопки 'Получить демодоступ'");
            }
        }
        return this;
    }

    @Step("Проверяется что блок 'Заказать звонок' отображается")
    public UssAboutSystemPage checkOrderCallContentIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("order-call"), "Содержание вкладки 'Заказать звонок' не отображается");
        WebElement orderCallBlock = findElementByNoThrow(content, By.cssSelector(".help-system"));
        postponedAssertNotNull(orderCallBlock, "Блок 'Заказать звонок' не найден");
        if (orderCallBlock != null) {
            postponedAssertTrue(orderCallBlock.isDisplayed(), "Блок 'Заказать звонок' не отображается");

            WebElement name = findElementByNoThrow(orderCallBlock, By.id("user-name"));
            WebElement phone = findElementByNoThrow(orderCallBlock, By.cssSelector(".telefon-label"));
            WebElement email = findElementByNoThrow(orderCallBlock, By.id("user-email"));
            WebElement info = findElementByNoThrow(orderCallBlock, By.id("user-message"));
            WebElement button = findElementByNoThrow(orderCallBlock, By.id("button-submit"));

            postponedAssertNotNull(name, "Отсутсвуте поле 'Контактное лицо' в форме заказа презентации");
            postponedAssertNotNull(phone, "Отсутсвуте поле 'Телефон' в форме заказа презентации");
            postponedAssertNotNull(email, "Отсутсвуте поле 'Электронная почта' в форме заказа презентации");
            postponedAssertNotNull(info, "Отсутсвуте поле 'Дополнительная информация' в форме заказа презентации");
            postponedAssertNotNull(button, "Отсутсвуте кнопка 'Заказать презентацию' в форме заказа презентации");

            if (button != null) {
                postponedAssertEquals(button.getText().trim(), "Заказать звонок", "Неправильный текст кнопки 'Заказать звонок'");
            }
        }
        return this;
    }

    @Step("Проверяется что блок с информацией о дилере отображается")
    public UssAboutSystemPage checkBuyContentIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("buy-city"), "Содержание вкладки 'Купить' не отображается");
        WebElement dealerBlock = findElementByNoThrow(content, By.cssSelector(".dealer-item"));
        postponedAssertNotNull(dealerBlock, "Блок с информацией о дилере не найден");
        if (dealerBlock != null) {
            postponedAssertTrue(dealerBlock.isDisplayed(), "Блок с информацией о дилере не отображается");
            postponedAssertFalse(dealerBlock.getText().isEmpty(), "Блок с информацией о дилере пустой");
        }
        return this;
    }

    @Step("Открыть вкладку 'Попробывать'")
    public UssAboutSystemPage clickTryTrialTab() {
        WebElement trialElement = waitForVisibilityOfElementLocatedBy(By.id("trial"), "Вкладка 'Попробывать' не найдена");
        WebElement tryTrialTab = trialElement.findElement(By.cssSelector("[href*='#try']"));
        tryTrialTab.click();
        return this;
    }

    @Step("Открыть вкладку 'Заказать презентацию'")
    public UssAboutSystemPage clickOrderCallTab() {
        WebElement trialElement = waitForVisibilityOfElementLocatedBy(By.id("trial"), "Вкладка 'Заказать звонок' не найдена");
        WebElement presentationTab = trialElement.findElement(By.cssSelector("[href*='#order-call']"));
        presentationTab.click();
        return this;
    }

    @Step("Открыть вкладку 'Купить'")
    public UssAboutSystemPage clickBuyTab() {
        WebElement trialElement = waitForVisibilityOfElementLocatedBy(By.id("trial"), "Вкладка купить не найдена");
        WebElement buyTab = trialElement.findElement(By.cssSelector("[href*='#buy-city']"));
        buyTab.click();
        return this;
    }

    private void checkTabIsSelected(String tabName) {
        WebElement tryAnBuyBlock = waitForVisibilityOfElementLocatedBy(By.cssSelector(".try-n-buy__switcher"), "Вкладка '" + tabName + "' не найдена");
        WebElement selectedTab = tryAnBuyBlock.findElement(By.cssSelector(".active"));
        String selectedTabName = selectedTab.getText().trim();
        postponedAssertEquals(selectedTabName, tabName, "Вкладка '" + tabName + "' не открыта");
    }

    private void checkTabIsOpened(By tabLocator, String tabName) {
        WebElement tryAnBuyBlock = waitForVisibilityOfElementLocatedBy(By.cssSelector(".try-n-buy__block"), "Вкладка '" + tabName + "' не найдена");
        WebElement buyTab = findElementByNoThrow(tryAnBuyBlock, tabLocator);
        postponedAssertNotNull(buyTab, "Содержание вкладки '" + tabName + "' не найдено");
        if (buyTab != null) {
            postponedAssertTrue(buyTab.isDisplayed(), "Содержание вкладки '" + tabName + "' не отображается");
        }
    }
}
