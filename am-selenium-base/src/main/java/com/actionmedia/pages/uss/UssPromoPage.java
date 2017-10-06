package com.actionmedia.pages.uss;


import com.actionmedia.pages.helpers.PromoPageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;


@Component
public class UssPromoPage extends UssBasePage<UssPromoPage> {

    @Step("Проверка отображения Промо страницы")
    public UssPromoPage checkPromoPageDisplayed() {
        getHelper(PromoPageHelper.class).checkPromoPageDisplayed();
        return this;
    }

    @Step("Проверка отображения логотипа Промо страницы")
    public UssPromoPage checkPromoPageLogoDisplayed() {
        getHelper(PromoPageHelper.class).checkPromoPageLogoDisplayed();
        return this;
    }

    @Step("Проверка отображения номера на Промо страницы")
    public UssPromoPage checkNumberDisplayed() {
        getHelper(PromoPageHelper.class).checkNumberDisplayed();
        return this;
    }


    @Step("Проверка отображения ссылок на другие версии Промо страницы, блоков 'Договоры' и 'Конструктор договоров'")
    public UssPromoPage checkLinksDisplayed() {
        if (getCurrentUrl().contains("doc") || getCurrentUrl().contains("vip")) {
            WebElement konstruktor = findElementByNoThrow(By.id("konstrukteur-block"));
            postponedAssertTrue(konstruktor != null && konstruktor.isDisplayed(), "Блок 'Конструктор договоров' отображается");
        } else {
            WebElement dogovor = findElementByNoThrow(By.id("contracts-block"));
            postponedAssertTrue(dogovor != null && dogovor.isDisplayed(), "Блок 'Договоры' отображается");
        }
        return this;
    }

    @Step("Проверка отображения заголовка на Промо страницы")
    public UssPromoPage checkTitleDisplayed() {
        WebElement mainColumn = findElementByNoThrow(By.cssSelector(".b-title-uss"));
        if (mainColumn != null) {
            postponedAssertTrue(mainColumn.isDisplayed() && mainColumn.getText().contains("Первая юридическая справочная система")
                    && mainColumn.getText().contains("практических разъяснений от судей"), "Отображается неверный заголовок");
        } else {
            setPostponedTestFail("Заголовок не найден");
        }
        return this;
    }

    @Step("Проверка отображения плашки 'Отвечает...'")
    public UssPromoPage checkAnswerDisplayed() {
        getHelper(PromoPageHelper.class).checkAnswerDisplayed();
        return this;
    }

    @Step("Проверка отображения кнопки 'Получить демодоступ'")
    public UssPromoPage checkDemoButtonDisplayed() {
        getHelper(PromoPageHelper.class).checkDemoButtonDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Особенности системы'")
    public UssPromoPage checkSiteFeaturesDisplayed() {
        getHelper(PromoPageHelper.class).checkSiteFeaturesDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Преимущества'")
    public UssPromoPage checkServicesDisplayed() {
        getHelper(PromoPageHelper.class).checkServicesDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Авторы'")
    public UssPromoPage checkCourtDisplayed() {
        getHelper(PromoPageHelper.class).checkCourtDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Рекомендации'")
    public UssPromoPage checkRecommendationsDisplayed() {
        getHelper(PromoPageHelper.class).checkRecommendationsDisplayed("Рекомендации");
        return this;
    }

    @Step("Проверка отображения блока 'Правовая база'")
    public UssPromoPage checkBazaDisplayed() {
        getHelper(PromoPageHelper.class).checkLawBaseDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Письмо колеге'")
    public UssPromoPage checkMailDisplayed() {
        getHelper(PromoPageHelper.class).checkMailDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Мнения'")
    public UssPromoPage checkOpinionsDisplayed() {
        getHelper(PromoPageHelper.class).checkOpinionsDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Почему юристы рекомендуют Систему'")
    public UssPromoPage checkReviewsDisplayed() {
        getHelper(PromoPageHelper.class).checkReviewsDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Вопросы и Ответы'")
    public UssPromoPage checkQuestionsDisplayed() {
        getHelper(PromoPageHelper.class).checkQuestionsDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Попробовать/Заказать презентацию/Купить'")
    public UssPromoPage checkTrialDisplayed() {
        getHelper(PromoPageHelper.class).checkTrialDisplayed();
        return this;
    }

    public UssPromoPage checkBuyDisplay() {
        getHelper(PromoPageHelper.class).checkBuyDisplay();
        return this;
    }

    public UssPromoPage checkCityBlock() {
        getHelper(PromoPageHelper.class).checkCityBlock();
        return this;
    }

    public UssPromoPage checkUserDealer() {
        getHelper(PromoPageHelper.class).checkUserDealer("usual");
        return this;
    }

    public UssPromoPage checkPromoDealer() {
        getHelper(PromoPageHelper.class).checkUserDealer("promo");
        return this;
    }

    @Step("Проверка отображения блоков 'копирайт' и 'ссылки на тех.требования'")
    public UssPromoPage checkFooterDisplayed() {
        WebElement designer = findElementByNoThrow(By.cssSelector(".footer__bureau-logo__designed-at"));
        WebElement name = findElementByNoThrow(By.cssSelector(".footer__bureau-logo__logo"));
        if ((designer != null) && (name != null)) {
            postponedAssertTrue(designer.isDisplayed() && name.isDisplayed() && designer.getText().contains("Спроектировано") && designer.getText().contains("и оформлено")
                    && name.getText().contains("в Дизайн-бюро") && name.getText().contains("Артема Горбунова"), "Неверно отображается копирайт(Имя дизайнерской студии)");
            getHelper(PromoPageHelper.class).checkFooterDisplayed();
        } else {
            setPostponedTestFail("Блок 'Копирайт' не найден");
        }
        return this;
    }

    @Step("Проверка отображения быстрого оглавления")
    public UssPromoPage checkSideNavDisplayed() {
        getHelper(PromoPageHelper.class).checkSideNavDisplayed();
        return this;
    }

    public UssPromoPage checkStrap() {
        getHelper(PromoPageHelper.class).checkStrap();
        return this;
    }

    public UssPromoPage checkStrapSearch() {
        getHelper(PromoPageHelper.class).checkStrapSearch();
        return this;
    }

    public UssPromoPage checkStrapSearchRandom() {
        getHelper(PromoPageHelper.class).checkStrapSearchRandom();
        return this;
    }

    public UssPromoPage checkStrapLinks() {
        getHelper(PromoPageHelper.class).checkStrapLinks();
        return this;
    }

    public UssPromoPage clickAuthorPage() {
        getHelper(PromoPageHelper.class).clickAuthorPage();
        return this;
    }

    public UssPromoPage checkDisplayAuthor() {
        getHelper(PromoPageHelper.class).checkDisplayAuthor();
        return this;
    }

    public UssPromoPage checkDisplayTextAuthor() {
        getHelper(PromoPageHelper.class).checkDisplayTextAuthor();
        return this;
    }

    public UssPromoPage clickOpinionsPage() {
        getHelper(PromoPageHelper.class).clickOpinionsPage(By.cssSelector("[href='#opinions']"));
        return this;
    }

    public UssPromoPage checkBlockOpinions() {
        getHelper(PromoPageHelper.class).checkBlockOpinions("Почему юристы рекомендуют Систему Юрист...");
        return this;
    }

    public UssPromoPage checkScrollFastContents() {
        getHelper(PromoPageHelper.class).checkScrollFastContents();
        return this;
    }

    public UssPromoPage checkClickFastContents() {
        getHelper(PromoPageHelper.class).checkClickFastContents();
        return this;
    }

    public UssPromoPage clickPresentationPage() {
        waitForPresenceOfElementLocatedBy(By.cssSelector("[href='#order-call']")).click();
        return this;
    }

    @Step("Проверяется отображение формы заказа презентации")
    public UssPromoPage checkDisplayPresentationForm() {
        WebElement form = waitForPresenceOfElementLocatedBy(By.id("order-call"));
        postponedAssertEqualsText(form.findElement(By.tagName("h1")), "Закажите звонок, и мы перезвоним\n" +
                "в удобное для Вас время.");
        postponedAssertEqualsText(form.findElement(By.tagName("p")), "Звонок ни к чему Вас не обязывает – мы расскажем о Системе,\n" +
                "предложим самые выгодные условия покупки\n" +
                "и ответим на все вопросы.");

        postponedAssertEqualsText(findElementBy(form, By.xpath(".//label[@for='user-name']")), "Как к Вам обратиться *");
        postponedAssertEqualsText(findElementBy(form, By.xpath(".//label[@for='tel']")), "Телефон для связи *");
        postponedAssertEqualsText(findElementBy(form, By.xpath(".//label[@for='user-email']")), "Электронная почта\n" +
                "(чтобы Вам не пришлось ее диктовать при необходимости)");
        postponedAssertEqualsText(findElementBy(form, By.xpath(".//label[@for='user-message']")), "Дополнительная информация\n" +
                "(когда Вам позвонить, какие вопросы у Вас возникли и т.п.");
        postponedAssertEqualsText(findElementBy(form, By.tagName("button")), "Заказать звонок");

        return this;
    }

    @Step("Проверяется заполнение формы заказа презентации")
    public UssBasePage checkSendingForm() {
        WebElement form = waitForPresenceOfElementLocatedBy(By.id("order-call"));
        findElementBy(form, By.xpath(".//input[@id='user-name']")).sendKeys("автотест");
        findElementBy(form, By.xpath(".//input[@id='user-phoneprefix']")).sendKeys("123");
        findElementBy(form, By.xpath(".//input[@id='user-phonenumber']")).sendKeys("1234567");
        findElementBy(form, By.xpath(".//input[@id='user-phonepostfix']")).sendKeys("123");
        findElementBy(form, By.xpath(".//input[@id='user-email']")).sendKeys("test15@test.ru");
        findElementBy(form, By.xpath(".//textarea[@id='user-message']")).sendKeys("автотест");
        findElementBy(form, By.tagName("button")).click();
        waitFewSecond(2000);
        String text = waitForPresenceOfElementLocatedBy(By.id("help-system-success")).getText();
        postponedAssertTrue(text.contains("Спасибо за Ваш интерес к «Системе Юрист»!") && text.contains("Мы обязательно позвоним в удобное для Вас время."), "Не отображается текст об успешном заказе");
        return this;
    }
}

