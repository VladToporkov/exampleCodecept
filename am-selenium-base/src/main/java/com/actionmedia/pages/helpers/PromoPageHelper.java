package com.actionmedia.pages.helpers;

import com.actionmedia.autotest.selenium.annotations.Wait;
import com.actionmedia.base.BasePage;
import com.actionmedia.components.Link;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Component
public class PromoPageHelper extends BasePage<DictionaryPageHelper> {

    @FindBy(id = "court")
    @Wait
    protected WebElement court;

    public void checkPromoPageDisplayed() {
        WebElement promoPage = findElementByNoThrow(By.tagName("body"));
        if (promoPage != null) {
            postponedAssertTrue(promoPage.isDisplayed(), "Страница Промо не отображается");
        } else {
            setPostponedTestFail("Страница Промо не найдена");
        }
    }

    public void checkPromoPageLogoDisplayed() {
        WebElement logo;
        if (getSettings().isRunUss()) {
            logo = findElementByNoThrow(By.xpath(".//div[contains(@class, 'b-logo-uss')]"));
        } else {
            logo = findElementByNoThrow(By.cssSelector(".b-logo"));
        }

        if (logo != null) {
            postponedAssertTrue(logo.isDisplayed(), "Логотип системы не отображается");
        } else {
            setPostponedTestFail("Логотип системы не найден");
        }
    }

    public void checkNumberDisplayed() {
        WebElement number = findElementByNoThrow(By.cssSelector(".header__right-block__number"));
        if (number != null) {
            if (getSettings().isRunKss()) {
                postponedAssertTrue(number.isDisplayed() && number.getText().contains("8 800 333-01-14"), "Отображается неверный номер");
            } else if (getSettings().isRunUss()) {
                postponedAssertTrue(number.isDisplayed() && number.getText().contains("8 800 333-01-15"), "Отображается неверный номер");
            } else if (getSettings().isRunBss()) {
                WebElement numberUpper = findElementBy(By.cssSelector(".header__right-block__number__upper"));
                postponedAssertTrue(numberUpper.isDisplayed() && numberUpper.getText().contains("8 800"), "Отображается не верный код города");
                postponedAssertTrue(number.isDisplayed() && number.getText().contains("333-01-13"), "Отображается неверный номер");
            } else {
                WebElement numberUpper = findElementBy(By.cssSelector(".header__right-block__number__upper"));
                postponedAssertTrue(numberUpper.isDisplayed() && numberUpper.getText().contains("8 800"), "Отображается не верный код города");
                postponedAssertTrue(number.isDisplayed() && number.getText().contains("333-01-15"), "Отображается неверный номер");
            }
        } else {
            setPostponedTestFail("Номер телефона на странице промо не найден");
        }
    }

    public void checkAnswerDisplayed() {
        WebElement answers = findElementByNoThrow(By.cssSelector(".b-answer"));
        if (answers != null) {
            postponedAssertTrue(answers.isDisplayed(), "Плашка 'Отвечает...' не отображается");
        } else {
            setPostponedTestFail("Плашка 'Отвечает...' не найдена");
        }
    }

    public void checkDemoButtonDisplayed() {
        WebElement demoButton;
        if (getSettings().isRunFss()) {
            demoButton = findElementByNoThrow(By.cssSelector(".btn__in"));
        } else {
            demoButton = findElementByNoThrow(By.cssSelector(".b-button"));
        }
        if (demoButton != null) {
            postponedAssertTrue(demoButton.isDisplayed(), "Кнопка 'Получить демодоступ' не отображается");
        } else {
            setPostponedTestFail("Кнопка 'Получить демодоступ' не найдена");
        }
    }

    public void checkSiteFeaturesDisplayed() {
        if (getSettings().isRunKss()) {
            WebElement SiteFeatures = findElementBy(By.id("features"));
            postponedAssertTrue(SiteFeatures.isDisplayed(), "Блок 'Особенности системы' не отображается");
        } else {
            WebElement MainLeft = findElementBy(By.cssSelector(".main-column-layout__left"));
            WebElement MainRight = findElementBy(By.cssSelector(".main-column-layout__right"));
            WebElement MainMid = findElementBy(By.cssSelector(".main-column-layout__mid"));
            postponedAssertTrue(MainLeft.isDisplayed(), "Левая колонка блока 'Особенности системы' не отображается");
            postponedAssertTrue(MainRight.isDisplayed(), "Правая колонка блока 'Особенности системы' не отображается");
            postponedAssertTrue(MainMid.isDisplayed(), "Срединная колонка блока 'Особенности системы' не отображается");
        }
    }

    public void checkServicesDisplayed() {
        if (!getSettings().isRunUss() && !getCurrentUrl().contains("vip.")) {
            WebElement services = findElementByNoThrow(By.id("services"));
            if (services != null) {
                postponedAssertTrue(services.isDisplayed(), "Блок 'Возможности' не отображается");
            } else {
                setPostponedTestFail("Блок 'Возможности' не найден");
            }
        }
    }

    public void checkCourtDisplayed() {
        WebElement court = findElementByNoThrow(By.id("court"));
        if (court != null) {
            postponedAssertTrue(court.isDisplayed(), "Блок 'Авторы' не отображается");
        } else {
            setPostponedTestFail("Блок 'Авторы' не найден");
        }
    }

    public void checkRecommendationsDisplayed(String title) {
        WebElement recommendations = findElementByNoThrow(By.id("recommendations"));
        if (recommendations != null) {
            postponedAssertTrue(recommendations.isDisplayed(), "Блок '" + title + "' не отображается");
        } else {
            setPostponedTestFail("Блок '" + title + "' не найден");
        }
    }

    public void checkLawBaseDisplayed() {
        WebElement baza = findElementByNoThrow(By.id("baza"));
        if (baza != null) {
            postponedAssertTrue(baza.isDisplayed(), "Блок 'Правовая база' не отображается");
        } else {
            setPostponedTestFail("Блок 'Правовая база' не найден");
        }
    }

    public void checkMailDisplayed() {
        WebElement mail = findElementByNoThrow(By.id("mail"));
        if (mail != null) {
            postponedAssertTrue(mail.isDisplayed(), "Блок 'Письмо колеге' не отображается");
        } else {
            setPostponedTestFail("Блок 'Письмо колеге' не найден");
        }
    }

    public void checkOpinionsDisplayed() {
        WebElement opinions = findElementByNoThrow(By.id("reviews"));
        if (opinions != null) {
            postponedAssertTrue(opinions.isDisplayed(), "Блок 'Мнения' не отображается");
        } else {
            setPostponedTestFail("Блок 'Мнения' не найден");
        }
    }

    public void checkReviewsDisplayed() {
        WebElement reviewsTitle = findElementByNoThrow(By.id("reviews"));
        WebElement reviews = findElementByNoThrow(By.cssSelector(".reviews"));
        if ((reviews != null) && (reviewsTitle != null)) {
            postponedAssertTrue(reviewsTitle.isDisplayed() && reviews.isDisplayed(), "Блок 'Почему специалисты рекомендуют Систему' не отображается");
        } else {
            setPostponedTestFail("Блок 'Почему специалисты рекомендуют Систему' не найден");
        }
    }

    public void checkQuestionsDisplayed() {
        WebElement questions = findElementByNoThrow(By.id("questions"));
        if (questions != null) {
            postponedAssertTrue(questions.isDisplayed(), "Блок 'Вопросы и ответы' не отображается");
        } else {
            setPostponedTestFail("Блок 'Вопросы и ответы' не найден");
        }
    }

    public void checkTrialDisplayed() {
        WebElement trial = findElementByNoThrow(By.id("trial"));
        if (trial != null) {
            postponedAssertTrue(trial.isDisplayed(), "Блок 'Попробовать/Заказать презентацию/Купить' не отображается");
        } else {
            setPostponedTestFail("Блок 'Попробовать/Заказать презентацию/Купить' не найден");
        }
    }

    public void checkFooterDisplayed() {
        WebElement copyRight = findElementByNoThrow(By.cssSelector(".footer__action-logo"));
        if (copyRight != null) {
            String link = copyRight.findElements(By.tagName("a")).get(1).getAttribute("href");
            postponedAssertTrue(copyRight.getText().contains("Медиагруппа Актион, 2007—2016"), "Копирайт не отображается неверно");
            postponedAssertTrue(link.contains("/specification"), "Ссылка на технические требования не отображается");
        } else {
            setPostponedTestFail("Копирайт не найден");
        }
    }

    public void checkSideNavDisplayed() {
        WebElement sideNav = findElementByNoThrow(By.id("side_nav"));
        if (sideNav != null) {
            postponedAssertTrue(sideNav.isDisplayed(), "Быстрое оглавление не отображается");
        } else {
            setPostponedTestFail("Быстрое оглавление не найдено");
        }
    }

    @Step("Проверка отображения элементов внутри желтой плашки")
    public void checkStrap() {
        WebElement answers = findElementByNoThrow(By.cssSelector(".b-answer"));
        if (answers != null) {
            WebElement photo = findElementByNoThrow(answers, By.cssSelector(".b-answer__photo"));
            WebElement text = findElementByNoThrow(answers, By.cssSelector(".b-answer__text"));
            if (photo != null && text != null) {
                postponedAssertTrue(photo.isDisplayed(), "Фото не отображается");
                postponedAssertFalse(text.findElement(By.tagName("p")).getText().isEmpty(), "ФИО и должность автора не отображается");
                postponedAssertFalse(text.findElement(By.xpath(".//p[2]")).getText().isEmpty(), "Краткое содержание статьи не отображается");
                postponedAssertFalse(text.findElement(By.tagName("a")).getText().isEmpty(), "Ссылка на статью не отображается");
            } else {
                setPostponedTestFail("Не найден элемент фото и текст");
            }
        } else {
            setPostponedTestFail("Не найден элемент плашка ответов");
        }
    }

    @Step("Проверка отображения поисковой строки внутри желтой плашки")
    public void checkStrapSearch() {
        WebElement answers = findElementByNoThrow(By.cssSelector(".b-answer"));
        WebElement search = findElementByNoThrow(answers, By.id("answer"));
        String hint = search.findElement(By.id("answer")).getAttribute("value").toLowerCase();
        hint = hint.replaceAll(" ", " ");
        postponedAssertTrue(!search.getAttribute("value").isEmpty() && search.isDisplayed(), "Поисковый запрос - подсказка не отображается");
        WebElement searchButton = findElementByNoThrow(answers, By.id("yellowPanelSearch"));
        boolean hasTargetBlank = searchButton.getAttribute("target") == null ? false : true;
        if (searchButton != null) {
            String originalWindow = getDriver().getWindowHandle();
            searchButton.click();
            for (String handler : getDriver().getWindowHandles()) {
                if (!handler.equals(originalWindow)) {
                    getDriver().switchTo().window(handler);
                    break;
                }
            }
            waitForReloadingPage();
            waitForPresenceOfElementLocatedBy(By.xpath("//*[contains(@class, 'active')]"));
            WebElement section = findElementByNoThrow(By.xpath("//*[contains(@class, 'active')]"));
            if (section != null) {
                String attribute = section.getAttribute("data-tabid");
                postponedAssertTrue(attribute != null && attribute.contains("1"), "Поисковая выдача в неверном разделе");
                WebElement searchResult = findElementByNoThrow(By.cssSelector(".search-result"));
                String hintCheck = searchResult.findElement(By.tagName("h1")).getText();
                hintCheck = hintCheck.replaceAll("\\»", "");
                hintCheck = hintCheck.replaceAll("\\«", "");
                postponedAssertTrue(hintCheck.contains(hint), "Запрос из поисковой строки не идентичен запросу с промо страницы");
                List<WebElement> resultHead = findElementsByNoThrow(By.cssSelector(".widget-header"));
                List<WebElement> resultText = findElementsByNoThrow(By.cssSelector(".widget-text"));
                postponedAssertTrue((resultHead.size() != 0) && (resultText.size() != 0), "Запрос не выдал документов");
            } else {
                setPostponedTestFail("Элемент 'активная закладка навигации' не найден");
            }
            if (hasTargetBlank) {
                closeBrowserWindow();
                getDriver().switchTo().window(originalWindow);
            } else {
                returnToBack();
            }
        } else {
            setPostponedTestFail("Кнопка 'Найти' не найдена");
        }
    }

    @Step("Проверка отображения произвольного запроса")
    public void checkStrapSearchRandom() {
        WebElement answers = findElementByNoThrow(By.cssSelector(".b-answer"));
        WebElement search = findElementByNoThrow(answers, By.id("answer"));
        search.clear();
        search.sendKeys("1");
        WebElement searchButton = findElementByNoThrow(answers, By.id("yellowPanelSearch"));
        boolean hasTargetBlank = searchButton.getAttribute("target") == null ? false : true;
        if (searchButton != null) {
            String originalWindow = getDriver().getWindowHandle();
            searchButton.click();
            for (String handler : getDriver().getWindowHandles()) {
                if (!handler.equals(originalWindow)) {
                    getDriver().switchTo().window(handler);
                    break;
                }
            }
            waitForReloadingPage();
            waitForPresenceOfElementLocatedBy(By.xpath("//*[contains(@class, 'active')]"));
            WebElement section = findElementByNoThrow(By.xpath("//*[contains(@class, 'active')]"));
            if (section != null) {
                String dataTabid = section.getAttribute("data-tabid");
                postponedAssertTrue(dataTabid != null && dataTabid.contains("1"), "Поисковая выдача в неверном разделе");
                WebElement searchResult = findElementByNoThrow(By.cssSelector(".search-result"));
                postponedAssertTrue(searchResult.getText().contains("1"), "Запрос из поисковой строки не идентичен запросу с промо страницы");
                List<WebElement> resultHead = findElementsByNoThrow(By.cssSelector(".widget-header"));
                List<WebElement> resultText = findElementsByNoThrow(By.cssSelector(".widget-text"));
                postponedAssertTrue((resultHead.size() != 0) && (resultText.size() != 0), "Запрос не выдал документов");
            } else {
                setPostponedTestFail("Элемент 'активная закладка навигации' не найден");
            }
            if (hasTargetBlank) {
                closeBrowserWindow();
                getDriver().switchTo().window(originalWindow);
            } else {
                returnToBack();
            }
        } else {
            setPostponedTestFail("Кнопка 'Найти' не найдена");
        }
    }

    @Step("Проверка работы ссылок внутри желтой плашки")
    public void checkStrapLinks() {
        WebElement answers = findElementByNoThrow(By.cssSelector(".b-answer__text"));
        List<WebElement> linkElements = findElementsByNoThrow(answers, By.xpath(".//*[contains(@href,'/#/document/')]"));
        List<Link> links = new ArrayList<Link>();
        if (linkElements != null) {
            for (WebElement element : linkElements) {
                Link link = new Link(element.getAttribute("href"));
                links.add(link);
            }
        } else {
            setPostponedTestFail("нет ссылки на документ и описания документа");
            checkLinks(links);
        }
    }

    @Step("Проверка отображения блока 'Купить'")
    public void checkBuyDisplay() {
        WebElement switcher = findElementByNoThrow(By.cssSelector(".try-n-buy__switcher"));
        if (switcher != null) {
            WebElement buySwitcher = findElementByNoThrow(switcher, By.xpath(".//a[contains(@href,'#buy-city')]"));
            buySwitcher.click();
            waitForReloadingPage();
            if (getSettings().isRunBss() && getCurrentUrl().contains("vip.")) {
                WebElement dialerItem = findElementByNoThrow(By.cssSelector(".b-buy__desc"));
                if (dialerItem != null) {
                    postponedAssertTrue(dialerItem.isDisplayed(), "Блок 'Возможности версий' не отображается");
                } else
                    setPostponedTestFail("Элемент Блок 'Возможности версий' не найден");
            } else {
                WebElement dialerItem = findElementByNoThrow(By.cssSelector(".b-sale-main"));
                if (dialerItem != null) {
                    postponedAssertTrue(dialerItem.isDisplayed(), "Блок 'Диллер пользователя' не отображается");
                } else {
                    setPostponedTestFail("Элемент Блок 'Диллер пользователя' не найден");
                }
            }
            WebElement salePrice;
            if (getSettings().isRunBss() && getCurrentUrl().contains("vip.")) {
                salePrice = findElementByNoThrow(By.cssSelector(".b-vip-price"));
            } else {
                salePrice = findElementByNoThrow(By.cssSelector(".b-sale__price"));
            }
            if (salePrice != null) {
                postponedAssertTrue(salePrice.isDisplayed(), "Блок 'Рекомендованная цена' не отображается");
            } else {
                setPostponedTestFail("Элемент Блок 'Рекомендованная цена' не найден");
            }
            WebElement townForm = findElementByNoThrow(By.cssSelector(".city-subscribe__input"));
            WebElement citySubscribe = findElementByNoThrow(By.cssSelector(".city-subscribe__example"));
            if ((citySubscribe != null) && (townForm != null)) {
                postponedAssertTrue(townForm.isDisplayed() && citySubscribe.isDisplayed(), "Блок 'Выбор региона' не отображается'");
            } else {
                setPostponedTestFail("Элемент Блок 'Выбор региона' не найден");
            }
            WebElement cityContent = findElementByNoThrow(By.id("citycontent"));
            if (cityContent != null) {
                postponedAssertTrue(cityContent.isDisplayed(), "Блок 'Список диллеров для выбранного региона' не отображается");
            } else {
                setPostponedTestFail("Элемент 'Список диллеров для выбранного региона' не найден");
            }
            WebElement dealerLegend = findElementByNoThrow(By.cssSelector(".dealers-legend"));
            if (dealerLegend != null) {
                postponedAssertTrue(dealerLegend.isDisplayed(), "Блок 'Некоторыми партнерами мы гордимся особенно' не отображается");
            } else {
                setPostponedTestFail("Элемент Блок 'Некоторыми партнерами мы гордимся особенно' не найден");
            }
        } else {
            setPostponedTestFail("Элементы 'переключатели' не найден");
        }
    }

    @Step("Переход к блоку Авторы")
    public void clickAuthorPage() {
        waitForPresenceOfElementLocatedBy(By.cssSelector("[href='#court']"), "Ссылка на блок Авторы не найдена").click();
    }

    @Step("Переход к блоку Мнения")
    public void clickOpinionsPage(By locator) {
        waitForPresenceOfElementLocatedBy(locator, "Ссылка на блок Мнения не найдена").click();
    }

    @Step("Проверка работы блока 'Выбор города'")
    public void checkCityBlock() {
        WebElement townForm = findElementByNoThrow(By.cssSelector(".city-subscribe__input"));
        WebElement citySubscribe = findElementByNoThrow(By.cssSelector(".city-subscribe__example"));
        WebElement mainCities = findElementByNoThrow(By.cssSelector(".mainCities"));
        if ((townForm != null) && (citySubscribe != null) && (mainCities != null)) {
            WebElement cityDefault = findElementBy(townForm, By.cssSelector(".city-find"));
            WebElement cityDisplay = findElementByNoThrow(mainCities, By.id("moscow"));
            if (cityDefault != null) {
                postponedAssertTrue(cityDefault.getAttribute("value").contains("Москва") && cityDisplay.isDisplayed(), "Москва не отображается по умолчанию");
            } else
                setPostponedTestFail("Элемент 'отображаемый по умолчанию город' не найден");
            List<WebElement> citySubscribeLinks = findElementsByNoThrow(citySubscribe, By.tagName("a"));
            for (WebElement city : citySubscribeLinks) {
                city.click();
                сityDillerCheck();
            }

            cityDefault.clear();
            cityDefault.sendKeys("К");
            сityDillerCheck();
        } else {
            setPostponedTestFail("Элементы выбора города не найдены");
        }
    }

    @Step("Нажать кнопку Заказать звонок")
    public void clickPresentationPage() {
        waitForPresenceOfElementLocatedBy(By.id("trial")).findElement(By.cssSelector("div:nth-of-type(2) a")).click();
    }


    public void checkDisplayAuthor() {
        postponedAssertEqualsText(court.findElement(By.tagName("h2")), "В создании системы приняли участие");
        for (WebElement img : findElementsBy(court, By.tagName("img"))) {
            postponedAssertTrue(img.isDisplayed(), "Фотография не отображается");
        }
    }

    @Step("Проверяется отображение текста в блоке авторы")
    public void checkDisplayTextAuthor() {
        for (WebElement li : findElementsBy(court, By.tagName("li"))) {

            String filterFss = "";
            if (getSettings().isRunFss())
                filterFss = li.findElement(By.tagName("img")).getCssValue("filter");

            moveMouseToElement(li);

            WebElement text = li.findElement(By.cssSelector(".b-author-tooltip"));
            waitForPresenceOf(text);
            postponedAssertTrue(text.isDisplayed() && !text.getText().equals(""), "Текст об авторе не отображается");

            if (getSettings().isRunFss())
                postponedAssertNotEquals(filterFss, li.findElement(By.tagName("img")).getCssValue("filter"), "Картинка не стала цветной при наведении");

            if (getSettings().isRunBss() || getSettings().isRunUss()) {
                WebElement more = findElementByNoThrow(li, By.cssSelector(".b-author__show"));
                if (more != null) {
                    more.click();
                    WebElement additionalBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".b-popup_author__wrapper"));
                    postponedAssertTrue(additionalBlock.findElement(By.tagName("img")).isDisplayed(), "Фото не отображается");

                    postponedAssertTrue(additionalBlock.findElement(By.tagName("h2")).isDisplayed()
                            && !additionalBlock.findElement(By.tagName("h2")).getText().equals(""), "ФИО не отображается");

                    postponedAssertTrue(additionalBlock.findElement(By.id("text")).isDisplayed()
                            && !additionalBlock.findElement(By.id("text")).getText().equals(""), "Текс не отображается");

                    additionalBlock.findElement(By.cssSelector(".b-popup__close")).click();
                }
            }
        }
    }

    @Step("Проверяется отображение блока Мнения")
    public void checkBlockOpinions(String text) {
        By locator = By.xpath("//*[@id='reviews']/div[3]/h2");
        if (getSettings().isRunBss()) {
            locator = By.xpath("//*[@id='reviews']/div[3]/h2");
        } else if (getSettings().isRunKss() || getSettings().isRunUss()) {
            locator = By.xpath("//*[@id='reviews']/h2");
        }
        WebElement opinionBlock = waitForPresenceOfElementLocatedBy(locator, "Блок '" + text + "' не найден");
        postponedAssertEquals(opinionBlock.getText(), text, "Неправильный текст в блоке '" + text + "'");

        List<WebElement> opinions = findElementsBy(By.xpath(".//div[@class='reviews']/div"));
        List<String> comments = new ArrayList<String>();
        List<String> authors = new ArrayList<String>();
        int flag = 0;
        for (int i = 0; i < opinions.size(); i++) {
            WebElement opinion = opinions.get(i);
            if (opinion.isDisplayed()) {
                WebElement author = opinion.findElement(By.cssSelector(".review-info"));
                postponedAssertTrue(author.isDisplayed() && !author.getText().isEmpty(), "Имя автора комментария не отображается>");

                WebElement comment = opinion.findElement(By.cssSelector(".review-block"));
                postponedAssertTrue(comment.isDisplayed() && !comment.getText().isEmpty(), "Текст комментария не отображается");

                postponedAssertFalse(comments.contains(comment.getText()), "Комментарий не изменился");
                postponedAssertFalse(authors.contains(author.getText()), "Имя автора комментария не изменилось");

                comments.add(comment.getText());
                authors.add(author.getText());

                DateTime currentTime = new DateTime();
                while (new DateTime().getMillis() - currentTime.getMillis() < 120000) {
                    if (!author.getText().equals(opinion.findElement(By.cssSelector(".review-info")).getText())) {
                        break;
                    }
                    waitFewSecond(3000);
                }
                flag++;
                if (flag >= 3) {
                    break;
                }
            }
        }
    }

    @Step("Проверяется подсветки элементов меню при скроле")
    public void checkScrollFastContents() {
        List<WebElement> navBarItems = findElementsBy(findElementsBy(By.id("side_nav")).get(0), By.cssSelector(".side-nav__item"));
        String url = getCurrentUrl();
        for (WebElement navItem : navBarItems) {
            moveMouseToElement(findElementBy(By.id(navItem.findElement(By.tagName("a")).getAttribute("href").replace(url + "#", ""))));
            postponedAssertTrue(!navItem.getCssValue("background-image").equals(""), "Не подсвечивается нужное меню при скроле");
        }
    }

    @Step("Проверяеться работа ссылок меню")
    public void checkClickFastContents() {
        List<WebElement> navBarItems = findElementsByNoThrow(findElementsBy(By.id("side_nav")).get(0), By.cssSelector(".side-nav__item"));
        String url = getCurrentUrl();
        List<String> list = new LinkedList<String>();

        for (int i = 0; i < navBarItems.size(); i++) {
            list.add(navBarItems.get(i).findElement(By.tagName("a")).getAttribute("href").replace(url + "#", ""));
        }
        for (int i = 0; i < navBarItems.size(); i++) {
            navBarItems.get(i).findElement(By.tagName("a")).click();
            postponedAssertTrue(findElementBy(By.id(list.get(i))).isDisplayed(), "Блок не отображается");
        }
    }

    @Step("Проверка логики отображения 'Пользовательского диллера'")
    public void checkUserDealer(String user) {
        if (getSettings().isRunBss() && !getCurrentUrl().contains("vip.")) {
            WebElement dialerItem = findElementByNoThrow(By.cssSelector(".b-sale-main"));
            if (dialerItem != null) {
                postponedAssertTrue(dialerItem.isDisplayed(), "Блок 'Диллер пользователя' не отображается");
                String text = dialerItem.getText();
                if (user.contains("promo")) {
                    if (getSettings().isRunUss()) {
                        postponedAssertTrue(text.contains("Столица\n" +
                                "г. Москва, Волоколамское ш., д. 2\n" +
                                "8 (495) 972-41-14; 8 (495) 978-23-78\n" +
                                "info@2gl.ru"), "Неверная информация о диллере " + text);
                    } else if (getSettings().isRunBss()) {
                        postponedAssertTrue(text.contains("Актион-пресс\n" +
                                "г. Москва, ул. Новодмитровская, д. 5А, стр. 8\n" +
                                "8 (495) 785-01-13") || text.contains("МЦФЭР Пресс\n" +
                                "МОСКВА, Новодмитровская\n" +
                                "8 (495) 937-90-80"), "Неверная информация о диллере " + text);
                    } else {
                        postponedAssertTrue(text.contains("Столица, Волоколамское ш., д. 2\n" +
                                "8 (495) 972-41-14; 8 (495) 978-23-78\n" +
                                "info@2gl.ru"), "Неверная информация о диллере " + text);
                    }
                } else {
                    postponedAssertTrue(text.contains("Актион-пресс\n" +
                            "г. Москва, ул. Новодмитровская, д. 5А, стр. 8\n" +
                            "8 (495) 785-01-13") || text.contains("МЦФЭР Пресс\n" +
                            "МОСКВА, Новодмитровская\n" +
                            "8 (495) 937-90-80"), "Неверная информация о диллере " + text);
                }
            } else {
                setPostponedTestFail("Элемент Блок 'Диллер пользователя' не найден");
            }
        }
    }

    private void сityDillerCheck() {
        WebElement cityContent = findElementByNoThrow(By.id("citycontent"));
        List<WebElement> displayedCity = findElementsByNoThrow(cityContent, By.xpath(".//div[contains(@style, 'block')]"));

        if (displayedCity.size() != 0) {
            for (WebElement city : displayedCity) {
                String cityName = city.getAttribute("data-city");
                List<WebElement> dillers = findElementsByNoThrow(city, By.cssSelector(".dealer-item"));
                if (dillers.size() != 0) {
                    for (WebElement diller : dillers) {
                        String dillerCity = findElementByNoThrow(diller, By.cssSelector(".city")).getText();
                        postponedAssertTrue(dillerCity.toLowerCase().contains(cityName.toLowerCase()), "Дилер не соответствует выбранному городу");
                        WebElement nowrap = findElementByNoThrow(diller, By.cssSelector(".nowrap"));
                        if (nowrap != null) {
                            WebElement iconDealer = findElementByNoThrow(nowrap, By.cssSelector(".icon-dealer"));
                            if (iconDealer != null) {
                                postponedAssertTrue(iconDealer.isDisplayed() &&
                                        (iconDealer.getAttribute("src").contains("silver.png") ||
                                                iconDealer.getAttribute("src").contains("gold.png")), "Значок Золотой/Серебрянный партнер не отображается");
                            }
                            WebElement iconOtchet = findElementByNoThrow(nowrap, By.cssSelector(".icon-otchet"));
                            if (iconOtchet != null) {
                                if (getSettings().isRunUss()) {
                                    postponedAssertTrue(iconOtchet.isDisplayed() &&
                                            iconOtchet.getAttribute("src").contains("icon-kd.png"), "Значок 'Аттестованный партнер по сервису «Конструктор договоров»' не отображается");
                                } else {
                                    postponedAssertTrue(iconOtchet.isDisplayed() &&
                                            iconOtchet.getAttribute("src").contains("icon-otchet.png"), "Значок 'Имеет право работать с программой Система Главбух Отчеты' не отображается");
                                }
                            }
                        }
                    }
                }
            }
        } else {
            setPostponedTestFail("Выборка городов не отображается");
        }
    }

    @Step("Текст на странице для приложения соответсвует эталонному")
    public void checkTextAboutSystem() {
        waitForPresenceOf(findElementBy(By.xpath("//body/p/strong")));
        String text = findElementBy(By.xpath("//body")).getText();
        text = new String(text.getBytes(Charset.defaultCharset()));
        String actualText = "";
        String resources = "/service/";

        if (getSettings().isRunBss()) {
            try {
                actualText = new String(Files.readAllBytes(Paths.get(PromoPageHelper.class.getResource(resources +
                        "about_sys_bss.txt").getFile())), Charset.defaultCharset());
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (getSettings().isRunUss()) {
            try {
                actualText = new String(Files.readAllBytes(Paths.get(PromoPageHelper.class.getResource(resources +
                        "about_sys_uss.txt").getFile())), Charset.defaultCharset());
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (getSettings().isRunFss()) {
            try {
                actualText = new String(Files.readAllBytes(Paths.get(PromoPageHelper.class.getResource(resources +
                        "about_sys_fss.txt").getFile())), Charset.defaultCharset());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        postponedAssertEquals(actualText, text, "Текст на странице приложения не совпадает. Должен быть:" + text
                + ", но имеет значение:" + actualText);
    }
}
