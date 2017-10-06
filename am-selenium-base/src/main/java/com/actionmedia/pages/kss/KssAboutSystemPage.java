package com.actionmedia.pages.kss;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 02.12.13
 * Time: 11:18
 */
@Component
public class KssAboutSystemPage extends KssBasePage<KssAboutSystemPage> {

    @Step("Проверяется что раздел 'О системе' открыт")
    public KssAboutSystemPage checkAboutSystemPageIsOpened() {
        WebElement content = getAboutSystemPageBody();
        WebElement aboutHeader = findElementByNoThrow(content, By.id("about"));
        postponedAssertNotNull(aboutHeader, "Не найден заголовок радела 'О системе'. Раздел не открыт.");
        return this;
    }

    @Step("Проверяется что заголовок раздела 'О системе' отображается")
    public KssAboutSystemPage checkHeaderIsPresent() {
        WebElement content = getAboutSystemPageBody();
        WebElement aboutHeader = findElementByNoThrow(content, By.id("about"));
        postponedAssertNotNull(aboutHeader, "Заголовок раздела 'О системе' не найден");
        checkElementIsDisplayed(aboutHeader, "Заголовок раздела 'О системе' не отображается");
        return this;
    }

    @Step("Проверяется что лого системы отображается")
    public KssAboutSystemPage checkLogoIsPresent() {
        WebElement content = getAboutSystemPageBody();
        WebElement aboutHeader = findElementByNoThrow(content, By.id("about"));
        if (aboutHeader != null) {
            WebElement logo = findElementByNoThrow(aboutHeader, By.cssSelector(".b-logo"));
            postponedAssertNotNull(logo, "Лого системы не найдено");
            checkElementIsDisplayed(logo, "лого системы не отображается");
            if (logo != null) {
                String logoImgSrc = logo.getCssValue("background-image");
                postponedAssertTrue(logoImgSrc.contains("logo.png"), "Неправильная картинка для лого системы");
            }
        }
        return this;
    }

    @Step("Проверяется что блок с номером телефона отображается")
    public KssAboutSystemPage checkPhoneNumberBlockIsPresent() {
        WebElement content = getAboutSystemPageBody();
        WebElement aboutHeader = findElementByNoThrow(content, By.id("about"));
        if (aboutHeader != null) {
            WebElement phoneNumberBlock = findElementByNoThrow(aboutHeader, By.cssSelector(".header__right-block"));
            postponedAssertNotNull(phoneNumberBlock, "Блок с номером телефона не найден");
            checkElementIsDisplayed(phoneNumberBlock, "Блок с номером телефона не отображается");
            if (phoneNumberBlock != null) {
                postponedAssertFalse(phoneNumberBlock.getText().isEmpty(), "Блок с номером телефона пустой");
            }
        }
        return this;
    }

    @Step("Проверяется что блок с ссылками на другие версии системы отображается")
    public KssAboutSystemPage checkVersionBlockIsPresent() {
        WebElement content = getAboutSystemPageBody();
        WebElement aboutHeader = findElementByNoThrow(content, By.id("about"));
        if (aboutHeader != null) {
            WebElement versionBlock = findElementByNoThrow(aboutHeader, By.cssSelector(".b-version"));
            postponedAssertNotNull(versionBlock, "Блок с ссылками на другие версии системы не найден");
            checkElementIsDisplayed(versionBlock, "Блок с ссылками на другие версии системы не отображается");
        }
        return this;
    }

    @Step("Проверяется что блок с ссылками на другие версии системы не пустой")
    public KssAboutSystemPage checkVersionBlockIsNotEmpty() {
        WebElement content = getAboutSystemPageBody();
        WebElement versionBlock = findElementByNoThrow(content, By.cssSelector(".b-version"));
        if (versionBlock != null) {
            List<WebElement> versionLikList = versionBlock.findElements(By.tagName("li"));
            if (versionLikList.size() == 3) {
                postponedAssertEquals(versionLikList.get(0).getText(), "Для коммерческих организаций", "Неправильный текст ссылки 'Для коммерческих организаций'");
                postponedAssertEquals(versionLikList.get(1).getText().replace(" -", "-"), "ВИП-версия для коммерческих организаций", "Неправильный текст ссылки 'VIP-версия'");
                postponedAssertEquals(versionLikList.get(2).getText(), "Для бюджетных учреждений", "Неправильный текст ссылки 'Для бюджетных организаций'");
            } else {
                setPostponedTestFail("Количество ссылок в блоке другие версии системы не равно трем");
            }
        }
        return this;
    }

    @Step("Проверяется что выбранна правильная версия системы")
    public KssAboutSystemPage checkSelectedVersion() {
        WebElement content = getAboutSystemPageBody();
        WebElement versionBlock = findElementByNoThrow(content, By.cssSelector(".b-version"));
        if (versionBlock != null) {
            WebElement selectedVersion = findElementByNoThrow(versionBlock, By.cssSelector(".b-version_selected"));
            postponedAssertNotNull(selectedVersion, "Не одна из версий не выбрана");
            if (selectedVersion != null) {
                if (getCurrentUrl().contains("vip.")) {
                    postponedAssertEquals(selectedVersion.getText(), "ВИП-версия для коммерческих организаций", "Неправильный текст ссылки для выбранной версии");
                } else if (getCurrentUrl().contains("budget.") || getCurrentUrl().contains("bu.")) {
                    postponedAssertEquals(selectedVersion.getText(), "Для бюджетных учреждений", "Неправильный текст ссылки для выбранной версии");
                } else {
                    postponedAssertEquals(selectedVersion.getText(), "Для коммерческих организаций", "Неправильный текст ссылки для выбранной версии");
                }
            }
        }
        return this;
    }

    @Step("Проверяется что название системы отображается")
    public KssAboutSystemPage checkTitleIsPresent() {
        WebElement content = getAboutSystemPageBody();
        WebElement title = findElementByNoThrow(content, By.cssSelector(".gradient"));
        postponedAssertNotNull(title, "Название системы не найдено");
        checkElementIsDisplayed(title, "Название системы не отображается");
        return this;
    }

    @Step("Проверяется что кнопка 'Попробовать бесплатно' отображается")
    public KssAboutSystemPage checkDemoButtonIsPresent() {
        WebElement content = getAboutSystemPageBody();
        WebElement demoButton = findElementByNoThrow(content, By.cssSelector("[href*='/#/customer/demo']"));
        postponedAssertNotNull(demoButton, "Кнопка 'Попробовать бесплатно' не найдена");
        checkElementIsDisplayed(demoButton, "Кнопка 'Попробовать бесплатно' не отображается");
        checkTextInElement(demoButton, "Попробовать бесплатно", "Неправильный текст кнопки 'Попробовать бесплатно'");
        return this;
    }

    @Step("ПРоверяется что поисковая строка отображается")
    public KssAboutSystemPage checkSearchBoxIsPresent() {
        WebElement content = getAboutSystemPageBody();
        WebElement searchTextField = findElementByNoThrow(content, By.id("answer"));
        WebElement searchButton = findElementByNoThrow(content, By.id("yellowPanelSearch"));

        postponedAssertNotNull(searchTextField, "Поисковая строка не найдена");
        postponedAssertNotNull(searchButton, "Кнопка найти не найдена");

        checkElementIsDisplayed(searchTextField, "Поисковая строка не отображается");
        checkElementIsDisplayed(searchButton, "Кнопка найти не отображается");
        return this;
    }

    @Step("Проверяется что желтая плашка отображается")
    public KssAboutSystemPage checkYellowPlateIsPresent() {
        WebElement content = getAboutSystemPageBody();
        WebElement yellowPlate = findElementByNoThrow(content, By.cssSelector(".b-answer__box"));
        postponedAssertNotNull(yellowPlate, "Желтая плашка не найдена");
        checkElementIsDisplayed(yellowPlate, "Желтая плашка не отображается");
        if (yellowPlate != null) {
            WebElement img = yellowPlate.findElement(By.tagName("img"));
            postponedAssertFalse(yellowPlate.getText().isEmpty(), "Отсутствует текст в желтой плашке");
            postponedAssertTrue(isImageLoaded(img), "Картинка в желтой плашке не загрузилась");
        }
        return this;
    }

    @Step("Проверяется что блок 'Особенности системы' отображается")
    public KssAboutSystemPage checkFeatureBlockIsPresent() {
        WebElement content = getAboutSystemPageBody();
        WebElement yellowPlate = findElementByNoThrow(content, By.id("features"));
        postponedAssertNotNull(yellowPlate, "Блок 'Особенности системы' не найден");
        checkElementIsDisplayed(yellowPlate, "Блок 'Особенности системы' не отображается");
        if (yellowPlate != null) {
            List<WebElement> imgList = yellowPlate.findElements(By.tagName("img"));
            postponedAssertFalse(yellowPlate.getText().isEmpty(), "Отсутствует текст в блок 'Особенности системы'");
            postponedAssertFalse(imgList.isEmpty(), "Отсутсвуют картинки в блоке 'Особенности системы'");
            for (WebElement img : imgList) {
                String imgSrc = img.getAttribute("src");
                postponedAssertTrue(isImageLoaded(img), "Картинка: " + imgSrc + " в блоке 'Особенности системы' не загрузилась");
            }
        }
        return this;
    }

    @Step("Проверяется что блок 'Прелести VIP-версии' отображается")
    public KssAboutSystemPage checkVipServicesBlockIsPresent() {
        WebElement content = getAboutSystemPageBody();
        WebElement vipServicesBlock = findElementByNoThrow(content, By.id("benefits"));
        postponedAssertNotNull(vipServicesBlock, "Блок 'Прелести VIP-версии' не найден");
        checkElementIsDisplayed(vipServicesBlock, "Блок 'Прелести VIP-версии' не отображается");
        return this;
    }

    @Step("Проверяется что блок 'Больше возможностей для пользователей' отображается")
    public KssAboutSystemPage checkServicesBlockIsPresent() {
        WebElement content = getAboutSystemPageBody();
        WebElement servicesBlock = findElementByNoThrow(content, By.id("services"));
        postponedAssertNotNull(servicesBlock, "Блок 'Больше возможностей для пользователей' не найден");
        checkElementIsDisplayed(servicesBlock, "Блок 'Больше возможностей для пользователей' не отображается");
        return this;
    }

    @Step("Проверяется что блок 'В создании системы приняли участие' отображается")
    public KssAboutSystemPage checkExpertsBlockIsPresent() {
        WebElement content = getAboutSystemPageBody();
        WebElement expertsBlock = findElementByNoThrow(content, By.cssSelector(".authors-floor"));
        postponedAssertNotNull(expertsBlock, "Блок 'В создании системы приняли участие' не найден");
        checkElementIsDisplayed(expertsBlock, "Блок 'В создании системы приняли участие' не отображается");
        return this;
    }

    @Step("Проверяется что блок 'Все ответы в подробном рубрикаторе' отображается")
    public KssAboutSystemPage checkRubricatorBlockIsPresent() {
        WebElement content = getAboutSystemPageBody();
        WebElement rubricatorBlock = findElementByNoThrow(content, By.id("recommendations"));
        postponedAssertNotNull(rubricatorBlock, "Блок 'Все ответы в подробном рубрикаторе' не найден");
        checkElementIsDisplayed(rubricatorBlock, "Блок 'Все ответы в подробном рубрикаторе' не отображается");
        return this;
    }

    @Step("Проверяется что блок 'Полная бесплатная правовая база с ежедневными автоматическими обновлениями' отображается")
    public KssAboutSystemPage checkLawBaseBlockIsPresent() {
        WebElement content = getAboutSystemPageBody();
        WebElement lawBaseBlock = findElementByNoThrow(content, By.id("baza"));
        postponedAssertNotNull(lawBaseBlock, "Блок 'Полная бесплатная правовая база с ежедневными автоматическими обновлениями' не найден");
        checkElementIsDisplayed(lawBaseBlock, "Блок 'Полная бесплатная правовая база с ежедневными автоматическими обновлениями' не отображается");
        return this;
    }

    @Step("Проверяется что блок 'Пусть все узнают!' отображается")
    public KssAboutSystemPage checkMailBlockIsPresent() {
        WebElement content = getAboutSystemPageBody();
        WebElement mailBlock = findElementByNoThrow(content, By.id("mail"));
        postponedAssertNotNull(mailBlock, "Блок 'Пусть все узнают!' не найден");
        checkElementIsDisplayed(mailBlock, "Блок 'Пусть все узнают!' не отображается");
        return this;
    }

    @Step("Проверяется что блок 'Мнения пользователей' отображается")
    public KssAboutSystemPage checkOpinionsBlockIsPresent() {
        WebElement content = getAboutSystemPageBody();
        WebElement opinionsBlock = findElementByNoThrow(content, By.id("opinions"));
        postponedAssertNotNull(opinionsBlock, "Блок 'Мнения пользователей' не найден");
        checkElementIsDisplayed(opinionsBlock, "Блок 'Мнения пользователей' не отображается");
        return this;
    }

    @Step("Проверяется что блок 'Вопросы и ответы' отображается")
    public KssAboutSystemPage checkQuestionsBlockIsPresent() {
        WebElement content = getAboutSystemPageBody();
        WebElement questionsBlock = findElementByNoThrow(content, By.id("questions"));
        postponedAssertNotNull(questionsBlock, "Блок 'Вопросы и ответы' не найден");
        checkElementIsDisplayed(questionsBlock, "Блок 'Вопросы и ответы' не отображается");
        return this;
    }

    @Step("Проверяется что блок 'Попробовать/Заказать презентацию/Купить' отображается")
    public KssAboutSystemPage checkTrialBlockIsPresent() {
        WebElement content = getAboutSystemPageBody();
        WebElement trialBlock = findElementByNoThrow(content, By.id("trial"));
        postponedAssertNotNull(trialBlock, "Блок 'Попробовать/Заказать презентацию/Купить' не найден");
        checkElementIsDisplayed(trialBlock, "Блок 'Попробовать/Заказать презентацию/Купить' не отображается");
        return this;
    }

    @Step("Проверяется что футер отображается")
    public KssAboutSystemPage checkFooterIsPresent() {
        WebElement content = getAboutSystemPageBody();
        WebElement footer = findElementByNoThrow(content, By.cssSelector(".footer"));
        postponedAssertNotNull(footer, "Футер не найден");
        checkElementIsDisplayed(footer, "Футер не отображается");
        if (footer != null) {
            WebElement copyright = findElementByNoThrow(footer, By.cssSelector(".footer__action-logo"));
            postponedAssertNotNull(copyright, "Копирайт не найден");
            checkElementIsDisplayed(copyright, "Копирайт не отображается");

            WebElement techRequirementsLinkElement = findElementByNoThrow(footer, By.linkText("Технические требования"));
            postponedAssertNotNull(techRequirementsLinkElement, "Ссылка на технические требования не найдена");
            checkElementIsDisplayed(techRequirementsLinkElement, "Ссылка на технические требования не отображается");
            if (techRequirementsLinkElement != null) {
                String techRequirementsLink = techRequirementsLinkElement.getAttribute("href");
                postponedAssertEquals(techRequirementsLink, "http://partners.action-digital.ru/specification/", "Неправильный адрес ссылки 'Технические требования'");
            }
        }
        return this;
    }

    @Step("Проверяется что быстрое оглавление отображается")
    public KssAboutSystemPage checkSoderIsPresent() {
        WebElement content = getAboutSystemPageBody();
        WebElement soder = findElementByNoThrow(content, By.id("side_nav"));
        postponedAssertNotNull(soder, "Быстрое оглавление не найдено");
        checkElementIsDisplayed(soder, "Быстрое оглавление не отображается");
        if (soder != null) {
            List<WebElement> soderItemList = soder.findElements(By.cssSelector(".side-nav__item"));
            postponedAssertFalse(soderItemList.isEmpty(), "Отсутвуют элементы в быстром оглавлении");
        }
        return this;
    }

    private WebElement getAboutSystemPageBody() {
        return waitForVisibilityOfElementLocatedBy(By.tagName("body"), "Страница 'О системе' не найдена");
    }
}
