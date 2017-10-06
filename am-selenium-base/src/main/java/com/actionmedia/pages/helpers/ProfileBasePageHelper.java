package com.actionmedia.pages.helpers;

import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.base.BasePage;
import com.actionmedia.components.PersonInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: d_shmanev
 * Date: 15.01.2015
 * Time: 13:00
 */
@Component
public class ProfileBasePageHelper extends BasePage<ProfileBasePageHelper> {

    @Step("Изменяется регион")
    public void changeRegion(String region) {
        WebElement geo = findElementBy(By.id("geo"), "Блок 'Мой город' не найден");
        WebElement checkGeo = geo.findElement(By.cssSelector(".form-field_type_checkbox"));
        if (checkGeo.isSelected()) {
            checkGeo.click();
        }
        WebElement inputRegion = geo.findElement(By.cssSelector(".ui-autocomplete-input"));
        inputRegion.clear();
        inputRegion.sendKeys(region);
        waitFewSecond(2000);
        WebElement searchResult = findElementByNoThrow(geo, By.cssSelector(".ui-corner-all"));
        postponedAssertNotNull(searchResult, "Выпадающие поисковые подсказки городов не найдены");
        if (searchResult != null) {
            WebElement hintlink = searchResult.findElement(By.tagName("a"));
            hintlink.submit();
            hintlink.click();
        }
        geo.findElement(By.tagName("button")).submit();
        scrollToStart();
    }

    @Step("Вернуть определение региона автоматически")
    public void changeCheckboxAutoRegion() {
        WebElement geo = findElementBy(By.id("geo"), "Блок 'Мой город' не найден");
        WebElement checkGeo = geo.findElement(By.cssSelector(".form-field_type_checkbox"));
        if (!checkGeo.isSelected()){
            checkGeo.click();
        }
        scrollToStart();
    }

    @Step("Проверяется что блок 'Бонусы' отображается")
    public void checkBonusBlockIsPresent() {
        scrollToStart();
        WebElement bonusBlock = findElementByNoThrow(mainContentElement, By.cssSelector(".js-action-bonus"));
        assertNotNull(bonusBlock, "Блок 'Бонусы' не найден");
        postponedAssertTrue(bonusBlock.isDisplayed(), "Блок 'Бонусы' не отображается");
    }

    @Step("Проверяется что блок 'Бонусы' отображается")
    public void checkBonusBlock() {
        WebElement bonusBlock = waitForVisibilityOfElementLocatedBy(By.cssSelector(".js-action-bonus"), "Блок 'Бонусы' не найден");

        WebElement header = findElementByNoThrow(bonusBlock, By.cssSelector(".facilities__title-text"));
        postponedAssertNotNull(header, "Заголовок 'Бонусные баллы' не найден");

        WebElement pointCount = findElementByNoThrow(bonusBlock, By.cssSelector(".facilities__text"));
        postponedAssertNotNull(pointCount, "Количество доступных балло не найдено");

        WebElement spentPointButton = findElementByNoThrow(bonusBlock, By.cssSelector(".btn_type_system"));
        postponedAssertNotNull(spentPointButton, "Кнопка 'Потратить с пользой' не найдена");

        WebElement fromPointLink = findElementByNoThrow(bonusBlock, By.cssSelector(".link"));
        postponedAssertNotNull(fromPointLink, "Кнопка 'Откуда баллы?' не найдена");

        WebElement getPointLink = findElementByNoThrow(mainContentElement, By.cssSelector("[href*='promo.aspx']"));
        postponedAssertNotNull(getPointLink, "Кнопка 'Как получить баллы' не найдена");
    }

    @Step("Нажать кнопку 'Откуда баллы?'")
    public void clickFromPointLink() {
        WebElement bonusBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".js-action-bonus"), "Блок 'Бонусы' не найден");
        findElementBy(bonusBlock, By.cssSelector(".link"), "Кнопка 'Откуда баллы?' не найдена").click();
    }

    @Step("Проверяется что комментарий: 'Бонусные баллы начисляются за покупку доступа к справочным системам.' отображается")
    public void checkFromPointCommentIsAppear() {
        WebElement bonusBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".js-action-bonus"), "Блок 'Бонусы' не найден");
        WebElement comment = findElementByNoThrow(bonusBlock, By.cssSelector(".js-toggle-comment"));
        postponedAssertNotNull(comment, "Комментарий: 'Бонусные баллы начисляются за покупку доступа к справочным системам.' не найден отображается");
        if (comment != null) {
            postponedAssertNotNull(comment, "Комментарий: 'Бонусные баллы начисляются за покупку доступа к справочным системам.' не отображается");
            postponedAssertEquals(comment.getText().trim(), "Бонусные баллы начисляются за покупку доступа к справочным системам.", "Неправильный текст комментария");
        }
    }

    @Step("Нажать кнопку 'Потратить с пользой'")
    public void clickSpendPointLink() {
        WebElement bonusBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".js-action-bonus"), "Блок 'Бонусы' не найден");
        findElementBy(bonusBlock, By.cssSelector(".btn_type_system"), "Кнопка 'Потратить с пользой' не найдена").click();
        waitForWindowToBeAppearedByPartialUrlAndSwitchToIt("bonus", "Сайт 'action-bonus.ru' открылся");
    }

    @Step("Нажать кнопку 'Как получить баллы'")
    public void clickGetPointLink() {
        findElementBy(mainContentElement, By.cssSelector("[href*='promo.aspx']"), "Кнопка 'Как получить баллы' не найдена").click();
        waitForWindowToBeAppearedByPartialUrlAndSwitchToIt("bonus", "Сайт 'action-bonus.ru' открылся");
    }

    @Step("Проверяется что сайт 'action-bonus.ru' открылся")
    public void checkBonusSiteIsOpened() {
        postponedAssertTrue(getCurrentUrl().contains("action-bonus.ru"), "Сайт 'action-bonus.ru' открылся");
        closeCurrentWindow(ProfileBasePageHelper.class);
        switchToMainWindow();
    }

    @Step("Проверяется что сайт 'action-bonus.ru/promo.aspx' открылся")
    public void checkPromoBonusSiteIsOpened() {
        postponedAssertTrue(getCurrentUrl().contains("action-bonus.ru/promo.aspx"), "Сайт 'action-bonus.ru/promo.aspx' открылся");
        closeCurrentWindow(ProfileBasePageHelper.class);
        switchToMainWindow();
    }

    public PersonInfo getPersonInfo() {
        WebElement form = findElementByNoThrow(By.id("personal-data"));
        List<WebElement> fieldset = form.findElements(By.xpath(".//fieldset"));
        String login = fieldset.get(0).findElement(By.xpath(".//span[2]")).getText();
        String email = fieldset.get(0).findElement(By.xpath(".//label[2]/input")).getAttribute("value");
        String lastName = fieldset.get(1).findElement(By.id("lastName")).getAttribute("value");
        String firstName = fieldset.get(1).findElement(By.id("firstName")).getAttribute("value");
        String secondName = fieldset.get(1).findElement(By.id("secondName")).getAttribute("value");
        String access = findElementBy(By.id("accessList")).findElement(By.xpath(".//td/span")).getText();
        access = access.replace("доступ", "").trim();
        PersonInfo user = new PersonInfo(login, email, lastName, firstName, secondName, access);
        return user;
    }

    @Step("Проверяется, что в поле Эл.почта указывается значение:{0}")
    public void checkEmail(String email) {
        WebElement emailInput = findElementByNoThrow(By.cssSelector("#personal-data #email"));
        postponedAssertEquals(emailInput.getAttribute("value"), email, "Email пользователя не совпадает");
    }
}

