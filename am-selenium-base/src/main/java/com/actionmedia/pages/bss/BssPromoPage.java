package com.actionmedia.pages.bss;


import com.actionmedia.pages.helpers.PromoPageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;


@Component
public class BssPromoPage extends BssBasePage<BssPromoPage> {

    @Step("Проверка отображения Промо страницы")
    public BssPromoPage checkPromoPageDisplayed() {
        getHelper(PromoPageHelper.class).checkPromoPageDisplayed();
        return this;
    }

    @Step("Проверка отображения логотипа Промо страницы")
    public BssPromoPage checkPromoPageLogoDisplayed() {
        getHelper(PromoPageHelper.class).checkPromoPageLogoDisplayed();
        return this;
    }

    @Step("Проверка отображения номера на Промо страницы")
    public BssPromoPage checkNumberDisplayed() {
        getHelper(PromoPageHelper.class).checkNumberDisplayed();
        return this;
    }

    @Step("Проверка отображения ссылок на другие версии Промо страницы и отображение блока 'Прелести VIP версии' и Отчетность экспертов'")
    public BssPromoPage checkLinksDisplayed() {
        WebElement linksStore = findElementByNoThrow(By.xpath(".//ul[contains(@class,'b-version')]"));
        if (linksStore != null) {
            List<WebElement> links = findElementsBy(linksStore, By.tagName("a"));
            if (getCurrentUrl().contains("vip.")) {
                WebElement VIPBlock = findElementByNoThrow(By.cssSelector(".vip-stage"));
                WebElement VIPExpertPic = findElementByNoThrow(By.cssSelector(".b-online-help__pic"));
                WebElement VIPExpertText = findElementByNoThrow(By.cssSelector(".b-online-help__text"));

                postponedAssertTrue(VIPBlock != null && VIPBlock.isDisplayed(), "Блок 'Прелести VIP версии' не отображается");
                postponedAssertTrue(VIPExpertPic != null && VIPExpertPic.isDisplayed() && VIPExpertText != null && VIPExpertText.isDisplayed(), "Блок 'Помощь экспертов' не отображается");
                if (!links.isEmpty()) {
                    postponedAssertTrue(links.get(0).isDisplayed() && links.get(0).getAttribute("href").contains("http://www.1gl.ru/about/"), "Отображается неверная ссылка");
                    postponedAssertTrue(links.get(1).isDisplayed() && links.get(1).getAttribute("href").contains("budget.1gl.ru/about/"), "Отображается неверная ссылка");
                    postponedAssertTrue(links.get(2).isDisplayed() && links.get(2).getAttribute("href").contains("usn.1gl.ru/about/"), "Отображается неверная ссылка");
                } else {
                    setPostponedTestFail("Ссылки на другие версии Промо страницы не найдены");
                }
            } else if (getCurrentUrl().contains("bu.") || getCurrentUrl().contains("budget.")) {
                if (!links.isEmpty()) {
                    postponedAssertTrue(links.get(0).isDisplayed() && links.get(0).getAttribute("href").contains("http://www.1gl.ru/about/"), "Отображается неверная ссылка");
                    postponedAssertTrue(links.get(1).isDisplayed() && links.get(1).getAttribute("href").contains("usn.1gl.ru/about/"), "Отображается неверная ссылка");
                    postponedAssertTrue(links.get(2).isDisplayed() && links.get(2).getAttribute("href").contains("vip.1gl.ru/about/"), "Отображается неверная ссылка");
                } else {
                    setPostponedTestFail("Ссылки на другие версии Промо страницы не найдены");
                }
            } else if (getCurrentUrl().contains("u.") || getCurrentUrl().contains("usn.")) {
                if (!links.isEmpty()) {
                    postponedAssertTrue(links.get(0).isDisplayed() && links.get(0).getAttribute("href").contains("http://www.1gl.ru/about/"), "Отображается неверная ссылка");
                    postponedAssertTrue(links.get(1).isDisplayed() && links.get(1).getAttribute("href").contains("budget.1gl.ru/about/"), "Отображается неверная ссылка");
                    postponedAssertTrue(links.get(2).isDisplayed() && links.get(2).getAttribute("href").contains("vip.1gl.ru/about/"), "Отображается неверная ссылка");
                } else {
                    setPostponedTestFail("Ссылки на другие версии Промо страницы не найдены");
                }
            } else {
                if (!links.isEmpty()) {
                    postponedAssertTrue(links.get(0).isDisplayed() && links.get(0).getAttribute("href").contains("budget.1gl.ru/about/"), "Отображается неверная ссылка");
                    postponedAssertTrue(links.get(1).isDisplayed() && links.get(1).getAttribute("href").contains("usn.1gl.ru/about/"), "Отображается неверная ссылка");
                    postponedAssertTrue(links.get(2).isDisplayed() && links.get(2).getAttribute("href").contains("vip.1gl.ru/about/"), "Отображается неверная ссылка");
                } else {
                    setPostponedTestFail("Ссылки на другие версии Промо страницы не найдены");
                }
            }
        } else {
            setPostponedTestFail("Блок 'Другие версии' не найден");
        }
        return this;
    }

    @Step("Проверка отображения заголовка на Промо страницы")
    public BssPromoPage checkTitleDisplayed() {
        WebElement mainColumn = findElementByNoThrow(By.cssSelector(".uss"));
        if (mainColumn != null) {
            postponedAssertTrue(mainColumn.isDisplayed() && mainColumn.getText().contains("Самая бухгалтерская") && mainColumn.getText().contains("справочная система")
                    && mainColumn.getText().contains("с ответами в виде практических рекомендаций"), "Отображается неверный заголовок");
        } else {
            setPostponedTestFail("Заголовок не найден");
        }
        return this;
    }

    @Step("Проверка отображения плашки 'Отвечает...'")
    public BssPromoPage checkAnswerDisplayed() {
        getHelper(PromoPageHelper.class).checkAnswerDisplayed();
        return this;
    }

    @Step("Проверка отображения кнопки 'Получить демодоступ'")
    public BssPromoPage checkDemoButtonDisplayed() {
        getHelper(PromoPageHelper.class).checkDemoButtonDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Особенности системы'")
    public BssPromoPage checkSiteFeaturesDisplayed() {
        getHelper(PromoPageHelper.class).checkSiteFeaturesDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Преимущества'")
    public BssPromoPage checkServicesDisplayed() {
        getHelper(PromoPageHelper.class).checkServicesDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Отчетность'")
    public BssPromoPage checkOtchetDisplayed() {
        if (!getCurrentUrl().contains("usn.") && !getCurrentUrl().contains("u.")) {
            WebElement otchet = findElementByNoThrow(By.xpath("//*[contains(@src, 'otchet-icon.png') or contains(text(),'Система Главбух Отчеты')]"));
            postponedAssertTrue(otchet != null && otchet.isDisplayed(), "Блок 'Отчетность' не отображается");
        }
        return this;
    }

    @Step("Проверка отображения блока 'Авторы'")
    public BssPromoPage checkCourtDisplayed() {
        getHelper(PromoPageHelper.class).checkCourtDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Рекомендации'")
    public BssPromoPage checkRecommendationsDisplayed() {
        getHelper(PromoPageHelper.class).checkRecommendationsDisplayed("Рекомендации");
        return this;
    }

    @Step("Проверка отображения блока 'Правовая база'")
    public BssPromoPage checkLawBaseDisplayed() {
        getHelper(PromoPageHelper.class).checkLawBaseDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Письмо колеге'")
    public BssPromoPage checkMailDisplayed() {
        if (!getCurrentUrl().contains("vip.")) {
            getHelper(PromoPageHelper.class).checkMailDisplayed();
        }
        return this;
    }

    @Step("Проверка отображения блока 'Видео'")
    public BssPromoPage checkVideoDisplayed() {
        if (!getCurrentUrl().contains("vip.")) {
            WebElement video = findElementByNoThrow(By.id("video"));
            postponedAssertTrue(video != null && video.isDisplayed(), "Блок 'Видео' не отображается");
        }
        return this;
    }

    @Step("Проверка отображения блока 'Мнения'")
    public BssPromoPage checkOpinionsDisplayed() {
        if ((!getCurrentUrl().contains("bu.") || !getCurrentUrl().contains("budget.")) && (!getCurrentUrl().contains("u.") || !getCurrentUrl().contains("usn."))) {
            getHelper(PromoPageHelper.class).checkOpinionsDisplayed();
        }
        return this;
    }

    @Step("Проверка отображения блока 'Почему юристы рекомендуют Систему'")
    public BssPromoPage checkReviewsDisplayed() {
        getHelper(PromoPageHelper.class).checkReviewsDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Вопросы и Ответы'")
    public BssPromoPage checkQuestionsDisplayed() {
        getHelper(PromoPageHelper.class).checkQuestionsDisplayed();
        return this;
    }

    @Step("Проверка отображения блока 'Попробовать/Заказать презентацию/Купить'")
    public BssPromoPage checkTrialDisplayed() {
        getHelper(PromoPageHelper.class).checkTrialDisplayed();
        return this;
    }

    public BssPromoPage checkBuyDisplay() {
        getHelper(PromoPageHelper.class).checkBuyDisplay();
        return this;
    }

    public BssPromoPage checkCityBlock() {
        getHelper(PromoPageHelper.class).checkCityBlock();
        return this;
    }

    public BssPromoPage checkUserDealer() {
        getHelper(PromoPageHelper.class).checkUserDealer("usual");
        return this;
    }

    public BssPromoPage checkPromoDealer() {
        getHelper(PromoPageHelper.class).checkUserDealer("promo");
        return this;
    }

    @Step("Проверка отображения блоков 'копирайт' и 'ссылки на тех.требования'")
    public BssPromoPage checkFooterDisplayed() {
        getHelper(PromoPageHelper.class).checkFooterDisplayed();
        return this;
    }

    @Step("Проверка отображения быстрого оглавления")
    public BssPromoPage checkSideNavDisplayed() {
        getHelper(PromoPageHelper.class).checkSideNavDisplayed();
        return this;
    }

    public BssPromoPage checkStrap() {
        getHelper(PromoPageHelper.class).checkStrap();
        return this;
    }

    public BssPromoPage checkStrapSearch() {
        getHelper(PromoPageHelper.class).checkStrapSearch();
        return this;
    }

    public BssPromoPage checkStrapSearchRandom() {
        getHelper(PromoPageHelper.class).checkStrapSearchRandom();
        return this;
    }

    public BssPromoPage checkStrapLinks() {
        getHelper(PromoPageHelper.class).checkStrapLinks();
        return this;
    }

    public BssPromoPage clickAuthorPage() {
        getHelper(PromoPageHelper.class).clickAuthorPage();
        return this;
    }

    public BssPromoPage checkDisplayAuthor() {
        getHelper(PromoPageHelper.class).checkDisplayAuthor();
        return this;
    }

    public BssPromoPage checkDisplayTextAuthor() {
        getHelper(PromoPageHelper.class).checkDisplayTextAuthor();
        return this;
    }

    public BssPromoPage clickOpinionsPage() {
        getHelper(PromoPageHelper.class).clickOpinionsPage(By.cssSelector("[href='#reviews']"));
        return this;
    }

    public BssPromoPage checkBlockOpinionsIsPresent() {
        By locator = By.xpath("//*[@id='reviews']/div[3]/h2");
        if (getCurrentUrl().contains("usn.") || getCurrentUrl().contains("u.") || getCurrentUrl().contains("bu.") || getCurrentUrl().contains("budget.")) {
            locator = By.xpath("//*[@id='reviews']/div/h2");
        }
        WebElement opinionBlock = waitForPresenceOfElementLocatedBy(locator, "Блок 'Почему бухгалтеры рекомендуют Систему Главбух...' не найден");
        postponedAssertTrue(opinionBlock.isDisplayed(), "Блок 'Почему бухгалтеры рекомендуют Систему Главбух...' не отображается");
        return this;
    }

    public BssPromoPage checkBlockOpinions() {
        getHelper(PromoPageHelper.class).checkBlockOpinions("Почему бухгалтеры рекомендуют Систему Главбух...");
        return this;
    }

    public BssPromoPage checkScrollFastContents() {
        getHelper(PromoPageHelper.class).checkScrollFastContents();
        return this;
    }

    public BssPromoPage checkClickFastContents() {
        getHelper(PromoPageHelper.class).checkClickFastContents();
        return this;
    }

    public BssPromoPage clickPresentationPage() {
        getHelper(PromoPageHelper.class).clickPresentationPage();
        return this;
    }

    @Step("Проверяется отображение формы заказа презентации")
    public BssPromoPage checkDisplayPresentationForm() {
        WebElement form = waitForPresenceOfElementLocatedBy(By.id("buy"));
        postponedAssertEqualsText(form.findElement(By.tagName("h1")), "Бухгалтерская справочная система\n" +
                "для коммерческих организаций");
        postponedAssertEqualsText(form.findElement(By.tagName("p")), "Специалисты «Системы Главбух» проведут\n" +
                "бесплатную демонстрацию системы у вас в офисе\n" +
                "и ответят на все вопросы");

        postponedAssertEqualsText(findElementBy(form, By.xpath(".//label[@for='name']")), "Контактное лицо");
        postponedAssertEqualsText(findElementBy(form, By.xpath(".//label[@for='tel']")), "Телефон");
        postponedAssertEqualsText(findElementBy(form, By.xpath(".//label[@for='email']")), "Электронная почта");
        postponedAssertEqualsText(findElementBy(form, By.xpath(".//label[@for='town']")), "Город");
        postponedAssertEqualsText(findElementBy(form, By.xpath(".//label[@for='street']")), "Адрес проведения презентации");
        postponedAssertEqualsText(findElementBy(form, By.xpath("//form/div/div[6]/label")), "Дополнительная информация");
        postponedAssertEqualsText(findElementBy(form, By.tagName("button")), "Заказать презентацию");

        return this;
    }

    @Step("Проверяется заполнение формы заказа презентации")
    public BssBasePage checkSendingForm() {
        WebElement form = waitForPresenceOfElementLocatedBy(By.id("buy"));
        findElementBy(form, By.xpath(".//input[@id='name']")).sendKeys("автотест");
        findElementBy(form, By.xpath(".//input[@id='p-phoneprefix']")).sendKeys("123");
        findElementBy(form, By.xpath(".//input[@id='p-phonenumber']")).sendKeys("1234567");
        findElementBy(form, By.xpath(".//input[@id='p-phonepostfix']")).sendKeys("123");
        findElementBy(form, By.xpath(".//input[@id='email']")).sendKeys("test125@test.ru");
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

    public BssPromoPage checkTextAboutSystem() {
        getHelper(PromoPageHelper.class).checkTextAboutSystem();
        return this;
    }
}