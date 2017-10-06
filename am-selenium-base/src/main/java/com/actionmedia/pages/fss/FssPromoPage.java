package com.actionmedia.pages.fss;


import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.pages.helpers.PromoPageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;


@Component
public class FssPromoPage extends FssBasePage<FssPromoPage> {

    @Step("Проверка отображения Промо страницы")
    public FssPromoPage checkPromoPageDisplayed() {
        getHelper(PromoPageHelper.class).checkPromoPageDisplayed();
        return this;
    }

    @Step("Проверка отображения логотипа Промо страницы")
    public FssPromoPage checkPromoPageLogoDisplayed() {
        getHelper(PromoPageHelper.class).checkPromoPageLogoDisplayed();
        return this;
    }

    @Step("Проверка отображения номера на Промо страницы")
    public FssPromoPage checkNumberDisplayed() {
        getHelper(PromoPageHelper.class).checkNumberDisplayed();
        return this;
    }

    @Step("Проверка отображения заголовка на Промо страницы")
    public FssPromoPage checkTitleDisplayed() {
        WebElement mainColumn = findElementByNoThrow(By.cssSelector(".main-column-layout"));
        if (mainColumn != null) {
            postponedAssertTrue(mainColumn.isDisplayed() && mainColumn.getText().contains("Финансовая справочная система") && mainColumn.getText().contains("Готовые решения для финансовых директоров"), "Отображается неверный заголовок");
        } else {
            setPostponedTestFail("Заголовок не найден");
        }
        return this;
    }

    @Step("Проверка отображения плашки 'Отвечает...'")
    public FssPromoPage checkAnswerDisplayed() {
        getHelper(PromoPageHelper.class).checkAnswerDisplayed();
        return this;
    }

    @Step("Проверка отображения кнопки 'Получить демодоступ'")
    public FssPromoPage checkDemoButtonDisplayed() {
        getHelper(PromoPageHelper.class).checkDemoButtonDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Особенности системы'")
    public FssPromoPage checkSiteFeaturesDisplayed() {
        getHelper(PromoPageHelper.class).checkSiteFeaturesDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Преимущества'")
    public FssPromoPage checkServicesDisplayed() {
        getHelper(PromoPageHelper.class).checkServicesDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Авторы'")
    public FssPromoPage checkCourtDisplayed() {
        getHelper(PromoPageHelper.class).checkCourtDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Решения'")
    public FssPromoPage checkRecommendationsDisplayed() {
        getHelper(PromoPageHelper.class).checkRecommendationsDisplayed("Решения");
        return this;
    }

    @Step("Проверка отображения блока 'Формы'")
    public FssPromoPage checkFormsDisplayed() {
        WebElement forms = findElementByNoThrow(By.id("formy"));
        if (forms != null) {
            postponedAssertTrue(forms.isDisplayed(), "Блок 'Формы' не отображается");
        } else {
            setPostponedTestFail("Блок 'Формы' не найден");
        }
        return this;
    }

    @Step("Проверка отображения блока 'Правовая база'")
    public FssPromoPage checkBazaDisplayed() {
        getHelper(PromoPageHelper.class).checkLawBaseDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Письмо колеге'")
    public FssPromoPage checkMailDisplayed() {
        getHelper(PromoPageHelper.class).checkMailDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Вопросы и Ответы'")
    public FssPromoPage checkQuestionsDisplayed() {
        getHelper(PromoPageHelper.class).checkQuestionsDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Попробовать/Заказать презентацию/Купить'")
    public FssPromoPage checkTrialDisplayed() {
        getHelper(PromoPageHelper.class).checkTrialDisplayed();
        return this;
    }

    public FssPromoPage checkBuyDisplay() {
        getHelper(PromoPageHelper.class).checkBuyDisplay();
        return this;
    }

    public FssPromoPage checkCityBlock() {
        getHelper(PromoPageHelper.class).checkCityBlock();
        return this;
    }

    public FssPromoPage checkUserDealer() {
        getHelper(PromoPageHelper.class).checkUserDealer("usual");
        return this;
    }

    public FssPromoPage checkPromoDealer() {
        getHelper(PromoPageHelper.class).checkUserDealer("promo");
        return this;
    }

    @Step("Проверка отображения блоков 'копирайт' и 'ссылки на тех.требования'")
    public FssPromoPage checkFooterDisplayed() {
        getHelper(PromoPageHelper.class).checkFooterDisplayed();
        return this;
    }

    @Step("Проверка отображения быстрого оглавления")
    public FssPromoPage checkSideNavDisplayed() {
        getHelper(PromoPageHelper.class).checkSideNavDisplayed();
        return this;
    }

    public FssPromoPage checkStrap() {
        getHelper(PromoPageHelper.class).checkStrap();
        return this;
    }

    public FssPromoPage checkStrapSearch() {
        getHelper(PromoPageHelper.class).checkStrapSearch();
        return this;
    }

    public FssPromoPage checkStrapSearchRandom() {
        getHelper(PromoPageHelper.class).checkStrapSearchRandom();
        return this;
    }

    public FssPromoPage checkStrapLinks() {
        getHelper(PromoPageHelper.class).checkStrapLinks();
        return this;
    }

    public FssPromoPage clickAuthorPage() {
        getHelper(PromoPageHelper.class).clickAuthorPage();
        return this;
    }

    public FssPromoPage checkDisplayAuthor() {
        getHelper(PromoPageHelper.class).checkDisplayAuthor();
        return this;
    }

    public FssPromoPage checkDisplayTextAuthor() {
        getHelper(PromoPageHelper.class).checkDisplayTextAuthor();
        return this;
    }

    public FssPromoPage checkScrollFastContents() {
        getHelper(PromoPageHelper.class).checkScrollFastContents();
        return this;
    }

    public FssPromoPage checkClickFastContents() {
        getHelper(PromoPageHelper.class).checkClickFastContents();
        return this;
    }

    public FssPromoPage clickPresentationPage() {
        getHelper(PromoPageHelper.class).clickPresentationPage();
        return this;
    }

    @Step("Проверяется отображение формы заказа презентации")
    public FssPromoPage checkDisplayPresentationForm() {
        WebElement form = waitForPresenceOfElementLocatedBy(By.id("buy"));
        postponedAssertEqualsText(form.findElement(By.tagName("h2")), "Первая финансовая справочная система для финансового директора");
        postponedAssertEqualsText(form.findElement(By.tagName("p")), "Специалисты «Системы Финансовый директор» проведут бесплатную демонстрацию системы у вас в офисе и ответят на все вопросы");

        postponedAssertEqualsText(findElementBy(form, By.xpath(".//label[@for='name']")), "Контактное лицо");
        postponedAssertEqualsText(findElementBy(form, By.xpath(".//label[@for='tel']")), "Моб. телефон");
        postponedAssertEqualsText(findElementBy(form, By.xpath(".//label[@for='email']")), "Электронная почта");
        postponedAssertEqualsText(findElementBy(form, By.xpath(".//label[@for='town']")), "Город");
        postponedAssertEqualsText(findElementBy(form, By.xpath(".//label[@for='street']")), "Адрес проведения презентации");
        postponedAssertEqualsText(findElementBy(form, By.xpath("//form/div/div[6]/label")), "Дополнительная информация");
        postponedAssertEqualsText(findElementBy(form, By.tagName("button")), "Заказать презентацию");

        return this;
    }

    @Step("Проверяется заполнение формы заказа презентации")
    public FssBasePage checkSendingForm() {
        WebElement form = waitForPresenceOfElementLocatedBy(By.id("buy"));
        findElementBy(form, By.xpath(".//input[@id='name']")).sendKeys("автотест");
        findElementBy(form, By.xpath(".//input[@id='p-phoneprefix']")).sendKeys("123");
        findElementBy(form, By.xpath(".//input[@id='p-phonenumber']")).sendKeys("1234567");
        findElementBy(form, By.xpath(".//input[@id='p-phonepostfix']")).sendKeys("123");
        findElementBy(form, By.xpath(".//input[@id='email']")).sendKeys("test15@test.ru");
        findElementBy(form, By.xpath(".//input[@id='town']")).sendKeys("автотест");
        findElementBy(form, By.xpath(".//input[@id='street']")).sendKeys("автотест");
        findElementBy(form, By.xpath(".//textarea[@id='info']")).sendKeys("автотест");
        findElementBy(form, By.tagName("button")).click();
        waitFewSecond(2000);
        String text = waitForPresenceOfElementLocatedBy(By.id("help-system-success")).getText();
        postponedAssertTrue(text.contains("Спасибо за интерес!") && text.contains("Мы свяжемся с вами в ближайшее время"), "Не отображается текст об успешном заказе");
        WebElement returnLink = findElementBy(By.id("help-system-return"));
        postponedAssertTrue(returnLink.isDisplayed() && returnLink.getText().contains("ещё одну презентацию"), "Не отображается линк на заказ еще одной презентации");
        returnLink.click();
        waitForReloadingPage();
        checkDisplayPresentationForm();
        return this;
    }

}