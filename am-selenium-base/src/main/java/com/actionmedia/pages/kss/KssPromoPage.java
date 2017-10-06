package com.actionmedia.pages.kss;


import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.pages.helpers.PromoPageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class KssPromoPage extends KssBasePage<KssPromoPage> {

    @Step("Проверка отображения Промо страницы")
    public KssPromoPage checkPromoPageDisplayed() {
        getHelper(PromoPageHelper.class).checkPromoPageDisplayed();
        return this;
    }

    @Step("Проверка отображения логотипа Промо страницы")
    public KssPromoPage checkPromoPageLogoDisplayed() {
        getHelper(PromoPageHelper.class).checkPromoPageLogoDisplayed();
        return this;
    }

    @Step("Проверка отображения номера на Промо страницы")
    public KssPromoPage checkNumberDisplayed() {
        getHelper(PromoPageHelper.class).checkNumberDisplayed();
        return this;
    }

    @Step("Проверка отображения ссылок на другие версии Промо страницы и отображение блока 'Прелести VIP версии'")
    public KssPromoPage checkLinksDisplayed() {
        WebElement linksStore = findElementByNoThrow(By.xpath(".//ul[contains(@class,'b-version')]"));
        if (linksStore != null) {
            List<WebElement> links = linksStore.findElements(By.tagName("a"));
            if (getCurrentUrl().contains("vip.")) {
                WebElement vipBlock = findElementByNoThrow(By.cssSelector(".vip-block"));
                postponedAssertTrue(vipBlock != null && vipBlock.isDisplayed(), "Блок 'Прелести VIP версии' не отображается");
                postponedAssertTrue(links.get(0).isDisplayed() && links.get(0).getAttribute("href").contains("www.1kadry.ru/about/"), "Отображается неверная ссылка");
                postponedAssertTrue(links.get(1).isDisplayed() && links.get(1).getAttribute("href").contains("budget.1kadry.ru/about/"), "Отображается неверная ссылка");
            } else if (getCurrentUrl().contains("bu.") || getCurrentUrl().contains("budget.")) {
                postponedAssertTrue(links.get(0).isDisplayed() && links.get(0).getAttribute("href").contains("www.1kadry.ru/about/"), "Отображается неверная ссылка");
                postponedAssertTrue(links.get(1).isDisplayed() && links.get(1).getAttribute("href").contains("vip.1kadry.ru/about/"), "Отображается неверная ссылка");
            } else {
                postponedAssertTrue(links.get(1).isDisplayed() && links.get(1).getAttribute("href").contains("budget.1kadry.ru/about/"), "Отображается неверная ссылка");
                postponedAssertTrue(links.get(0).isDisplayed() && links.get(0).getAttribute("href").contains("vip.1kadry.ru/about/"), "Отображается неверная ссылка");
            }
        } else {
            setPostponedTestFail("Блок 'Другие версии' не найден");
        }
        return this;
    }

    @Step("Проверка отображения плашки 'Отвечает...'")
    public KssPromoPage checkAnswerDisplayed() {
        getHelper(PromoPageHelper.class).checkAnswerDisplayed();
        return this;
    }

    @Step("Проверка отображения кнопки 'Получить демодоступ'")
    public KssPromoPage checkDemoButtonDisplayed() {
        getHelper(PromoPageHelper.class).checkDemoButtonDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Особенности системы'")
    public KssPromoPage checkSiteFeaturesDisplayed() {
        getHelper(PromoPageHelper.class).checkSiteFeaturesDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Преимущества'")
    public KssPromoPage checkServicesDisplayed() {
        getHelper(PromoPageHelper.class).checkServicesDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Авторы'")
    public KssPromoPage checkCourtDisplayed() {
        getHelper(PromoPageHelper.class).checkCourtDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Ответы'")
    public KssPromoPage checkRecommendationsDisplayed() {
        getHelper(PromoPageHelper.class).checkRecommendationsDisplayed("Ответы");
        return this;
    }

    @Step("Проверка отображения блока 'Правовая база'")
    public KssPromoPage checkBazaDisplayed() {
        getHelper(PromoPageHelper.class).checkLawBaseDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Письмо колеге'")
    public KssPromoPage checkMailDisplayed() {
        getHelper(PromoPageHelper.class).checkMailDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Мнения'")
    public KssPromoPage checkOpinionsDisplayed() {
        getHelper(PromoPageHelper.class).checkOpinionsDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Почему юристы рекомендуют Систему'")
    public KssPromoPage checkReviewsDisplayed() {
        getHelper(PromoPageHelper.class).checkReviewsDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Вопросы и Ответы'")
    public KssPromoPage checkQuestionsDisplayed() {
        getHelper(PromoPageHelper.class).checkQuestionsDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Попробовать/Заказать презентацию/Купить'")
    public KssPromoPage checkTrialDisplayed() {
        getHelper(PromoPageHelper.class).checkTrialDisplayed();
        return this;
    }

    @Step("Проверка отображения блоков 'копирайт' и 'ссылки на тех.требования'")
    public KssPromoPage checkFooterDisplayed() {
        getHelper(PromoPageHelper.class).checkFooterDisplayed();
        return this;
    }

    @Step("Проверка отображения быстрого оглавления")
    public KssPromoPage checkSideNavDisplayed() {
        getHelper(PromoPageHelper.class).checkSideNavDisplayed();
        return this;
    }

    public KssPromoPage checkStrap() {
        getHelper(PromoPageHelper.class).checkStrap();
        return this;
    }

    public KssPromoPage checkStrapSearch() {
        getHelper(PromoPageHelper.class).checkStrapSearch();
        return this;
    }

    public KssPromoPage checkStrapSearchRandom() {
        getHelper(PromoPageHelper.class).checkStrapSearchRandom();
        return this;
    }

    public KssPromoPage checkStrapLinks() {
        getHelper(PromoPageHelper.class).checkStrapLinks();
        return this;
    }

    public KssPromoPage checkBuyDisplay() {
        getHelper(PromoPageHelper.class).checkBuyDisplay();
        return this;
    }

    public KssPromoPage checkCityBlock() {
        getHelper(PromoPageHelper.class).checkCityBlock();
        return this;
    }

    public KssPromoPage checkUserDealer() {
        getHelper(PromoPageHelper.class).checkUserDealer("usual");
        return this;
    }

    public KssPromoPage checkPromoDealer() {
        getHelper(PromoPageHelper.class).checkUserDealer("promo");
        return this;
    }

    public KssPromoPage clickAuthorPage() {
        getHelper(PromoPageHelper.class).clickAuthorPage();
        return this;
    }

    public KssPromoPage checkDisplayAuthor() {
        getHelper(PromoPageHelper.class).checkDisplayAuthor();
        return this;
    }

    public KssPromoPage checkDisplayTextAuthor() {
        getHelper(PromoPageHelper.class).checkDisplayTextAuthor();
        return this;
    }

    public KssPromoPage clickOpinionsPage() {
        getHelper(PromoPageHelper.class).clickOpinionsPage(By.cssSelector("[href='#opinions']"));
        return this;
    }

    public KssPromoPage checkBlockOpinions() {
        getHelper(PromoPageHelper.class).checkBlockOpinions("Почему специалисты рекомендуют Систему Кадры...");
        return this;
    }

    public KssPromoPage checkScrollFastContents() {
        getHelper(PromoPageHelper.class).checkScrollFastContents();
        return this;
    }

    public KssPromoPage checkClickFastContents() {
        getHelper(PromoPageHelper.class).checkClickFastContents();
        return this;
    }

    public KssPromoPage clickPresentationPage() {
        getHelper(PromoPageHelper.class).clickPresentationPage();
        return this;
    }

    @Step("Проверяется отображение формы заказа презентации")
    public KssPromoPage checkDisplayPresentationForm() {
        WebElement form = waitForPresenceOfElementLocatedBy(By.id("buy"));
        postponedAssertEqualsText(form.findElement(By.tagName("h1")), "Первая кадровая справочная система");
        postponedAssertEqualsText(form.findElement(By.tagName("p")), "Заказ презентации вас ни к чему не обязывает.\n" +
                "Мы перезвоним в удобное для вас время, расскажем о Системе\n" +
                "и предложим самые выгодные условия покупки");

        postponedAssertEqualsText(findElementBy(form, By.xpath(".//label[@for='name']")), "Контактное лицо");
        postponedAssertEqualsText(findElementBy(form, By.xpath(".//label[@for='tel']")), "Телефон");
        postponedAssertEqualsText(findElementBy(form, By.xpath(".//label[@for='email']")), "Электронная почта");
        postponedAssertEqualsText(findElementBy(form, By.xpath(".//label[@for='town']")), "Город");
        postponedAssertEqualsText(findElementBy(form, By.xpath(".//label[@for='street']")), "Дополнительная информация");
        postponedAssertEqualsText(findElementBy(form, By.tagName("button")), "Заказать презентацию");

        return this;
    }

    @Step("Проверяется заполнение формы заказа презентации")
    public KssBasePage checkSendingForm() {
        WebElement form = waitForPresenceOfElementLocatedBy(By.id("buy"));
        findElementBy(form, By.xpath(".//input[@id='name']")).sendKeys("автотест");
        findElementBy(form, By.xpath(".//input[@id='p-phoneprefix']")).sendKeys("123");
        findElementBy(form, By.xpath(".//input[@id='p-phonenumber']")).sendKeys("1234567");
        findElementBy(form, By.xpath(".//input[@id='p-phonepostfix']")).sendKeys("123");
        findElementBy(form, By.xpath(".//input[@id='email']")).sendKeys("test@test.ru");
        findElementBy(form, By.xpath(".//input[@id='town']")).sendKeys("автотест");
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
