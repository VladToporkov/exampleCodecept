package com.actionmedia.pages.bss;

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
public class BssAboutSystemPage extends BssBasePage<BssAboutSystemPage> {

    private static final int TIME_TO_SCROLL = 30000;
    private static final String AUTHOR_NAME = "author.name";

    @Step("Проверяется подсветка в содере при скролле")
    public BssAboutSystemPage checkPageScroll() {
        WebElement soder = waitForVisibilityOfElementLocatedBy(By.id("side_nav"), "Содер не найден");
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
    public BssAboutSystemPage checkTryTrialTabIsSelected() {
        checkTabIsSelected("Попробовать");
        return this;
    }

    @Step("Проверяется что содержание вкладки 'Попробовать' отображается")
    public BssAboutSystemPage checkTryTrialTabIsOpened() {
        checkTabIsOpened(By.id("try"), "Попробовать");
        return this;
    }

    @Step("Проверяется что открыта вкладка 'Заказать презентацию'")
    public BssAboutSystemPage checkPresentationTabIsSelected() {
        checkTabIsSelected("Заказать презентацию");
        return this;
    }

    @Step("Проверяется что содержание вкладки 'Заказать презентацию' отображается")
    public BssAboutSystemPage checkPresentationTabIsOpened() {
        checkTabIsOpened(By.id("buy"), "Заказать презентацию");
        return this;
    }

    @Step("Проверяется что открыта вкладка 'Купить'")
    public BssAboutSystemPage checkBuyTabIsSelected() {
        checkTabIsSelected("Купить");
        return this;
    }

    @Step("Проверяется что содержание вкладки 'Купить' отображается")
    public BssAboutSystemPage checkBuyTabIsOpened() {
        checkTabIsOpened(By.id("buy-city"), "Купить");
        return this;
    }

    @Step("Проверяется что блок получить демо отображается")
    public BssAboutSystemPage checkTryTrialContentIsPresent() {
        WebElement demoBlock = waitForVisibilityOfElementLocatedBy(By.id("try"), "Содержание вкладки 'Попробовать' не отображается");
        postponedAssertNotNull(demoBlock, "Блок получить демо не найден");
        if (demoBlock != null) {
            postponedAssertTrue(demoBlock.isDisplayed(), "Блок получить демо не отображается");
            postponedAssertFalse(demoBlock.getText().isEmpty(), "Блок получить демо пустой");

            WebElement button = findElementByNoThrow(demoBlock, By.cssSelector(".b-button"));
            postponedAssertNotNull(button, "");
            if (button != null) {
                postponedAssertEquals(button.getText(), "Получить демодоступ", "Неправильный текст кнопки 'Получить демодоступ'");
            }
        }
        return this;
    }

    @Step("Проверяется что блок заказа презентации отображается")
    public BssAboutSystemPage checkPresentationContentIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("buy"), "Содержание вкладки 'Презентация' не отображается");
        WebElement presentationBlock = findElementByNoThrow(content, By.cssSelector(".help-system"));
        postponedAssertNotNull(presentationBlock, "Блок заказа презентации не найден");
        if (presentationBlock != null) {
            postponedAssertTrue(presentationBlock.isDisplayed(), "Блок заказа презентации не отображается");

            WebElement name = findElementByNoThrow(presentationBlock, By.id("name"));
            WebElement phone = findElementByNoThrow(presentationBlock, By.cssSelector(".telefon-label"));
            WebElement email = findElementByNoThrow(presentationBlock, By.id("email"));
            WebElement city = findElementByNoThrow(presentationBlock, By.id("town"));
            WebElement street = findElementByNoThrow(presentationBlock, By.id("street"));
            WebElement info = findElementByNoThrow(presentationBlock, By.id("info"));
            WebElement button = findElementByNoThrow(presentationBlock, By.cssSelector(".b-button"));

            postponedAssertNotNull(name, "Отсутсвуте поле 'Контактное лицо' в форме заказа презентации");
            postponedAssertNotNull(phone, "Отсутсвуте поле 'Телефон' в форме заказа презентации");
            postponedAssertNotNull(email, "Отсутсвуте поле 'Электронная почта' в форме заказа презентации");
            postponedAssertNotNull(city, "Отсутсвуте поле 'Город' в форме заказа презентации");
            postponedAssertNotNull(street, "Отсутсвуте поле 'Адрес проведения презентации' в форме заказа презентации");
            postponedAssertNotNull(info, "Отсутсвуте поле 'Дополнительная информация' в форме заказа презентации");
            postponedAssertNotNull(button, "Отсутсвуте кнопка 'Заказать презентацию' в форме заказа презентации");

            if (button != null) {
                postponedAssertEquals(button.getText().trim(), "Заказать презентацию", "Неправильный текст кнопки 'Заказать презентацию'");
            }
        }
        return this;
    }

    @Step("Проверяется что блок с информацией о дилере отображается")
    public BssAboutSystemPage checkBuyContentIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("buy-city"), "Содержание вкладки 'Купить' не отображается");
        WebElement dealerBlock = findElementByNoThrow(content, By.cssSelector(".dealer-item"));
        postponedAssertNotNull(dealerBlock, "Блок с информацией о дилере не найден");
        if (dealerBlock != null) {
            postponedAssertTrue(dealerBlock.isDisplayed(), "Блок с информацией о дилере не отображается");
            postponedAssertFalse(dealerBlock.getText().isEmpty(), "Блок с информацией о дилере пустой");
        }
        return this;
    }

    @Step("Проверяется что pop-up с информацией о выбранном авторе отображается")
    public BssAboutSystemPage checkAuthorPopUpIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".glavbukh"), "Блок 'Авторы' не найден");
        WebElement popUp = findElementByNoThrow(content, By.cssSelector(".b-popup_author"));
        postponedAssertNotNull(popUp, "Pop-up с информацией о выбранном авторе не отображается");
        if (popUp != null) {
            String expectedAuthorName = String.valueOf(getParameter(AUTHOR_NAME));
            String actualAuthorName = popUp.findElement(By.tagName("img")).getAttribute("alt").trim();
            postponedAssertEquals(actualAuthorName, expectedAuthorName, "Отображается Pop-up с информацией о другом авторе");
            postponedAssertFalse(popUp.getText().isEmpty(), "Пустой pop-up");
            WebElement closeButton = popUp.findElement(By.cssSelector(".b-popup__close"));
            closeButton.click();
        }
        return this;
    }

    @Step("Открыть вкладку 'Попробывать'")
    public BssAboutSystemPage clickTryTrialTab() {
        WebElement trialElement = getTrialElement();
        WebElement tryTrialTab = trialElement.findElement(By.cssSelector("[data-rel='trial']"));
        tryTrialTab.click();
        return this;
    }

    @Step("Открыть вкладку 'Заказать презентацию'")
    public BssAboutSystemPage clickPresentationTab() {
        WebElement trialElement = getTrialElement();
        WebElement presentationTab = trialElement.findElement(By.id("presentation"));
        presentationTab.click();
        return this;
    }

    @Step("Открыть вкладку 'Купить'")
    public BssAboutSystemPage clickBuyTab() {
        WebElement trialElement = getTrialElement();
        WebElement buyTab = trialElement.findElement(By.cssSelector("[data-rel='partners']"));
        buyTab.click();
        return this;
    }

    @Step("Кликнуть случайное фото с автором системы")
    public BssAboutSystemPage clickRandomAuthorPhoto() {
        WebElement authorsBlock = waitForVisibilityOfElementLocatedBy(By.id("court"), "Блок 'Авторы' не найден");
        List<WebElement> authorList = authorsBlock.findElements(By.cssSelector(".b-author"));
        WebElement randomAuthor = getRandomElementInList(authorList).findElement(By.tagName("img"));
        String authorName = randomAuthor.getAttribute("alt").trim();
        setParameter(AUTHOR_NAME, authorName);
        randomAuthor.click();
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
        postponedAssertNotNull(buyTab, "Содержание вкладки '" + tabName + "' не найдена");
        if (buyTab != null) {
            postponedAssertTrue(buyTab.isDisplayed(), "Содержание вкладки '" + tabName + "' не отображается");
        }
    }

    private WebElement getTrialElement() {
        return waitForVisibilityOfElementLocatedBy(By.id("trial"), "Блок 'Попробывать' не найден");
    }
}
