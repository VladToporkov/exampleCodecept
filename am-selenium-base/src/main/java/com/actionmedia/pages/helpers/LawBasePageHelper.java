package com.actionmedia.pages.helpers;

import com.actionmedia.autotest.selenium.elements.TextField;
import com.actionmedia.base.BasePage;
import com.actionmedia.components.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 16.09.2014
 * Time: 22:21
 */
@Component
public class LawBasePageHelper extends BasePage<LawBasePageHelper> {

    public void checkSectionTitleIsPresent() {
        WebElement title = waitForPresenceOfElementLocatedBy(By.cssSelector(".main__title"), "Заголовок раздела не найден");
        postponedAssertTrue(title.isDisplayed(), "Заголовок раздела не отображается");
        postponedAssertEquals(title.getText(), "Правовая база и судебная практика\n" +
                "Законы, постановления, письма. ВАС, ФАСы, апелляционные суды", "Неправильный текст заголовка раздела");
    }

    public void checkSectionTitleIsPresent(String reqTitle) {
        WebElement title = waitForPresenceOfElementLocatedBy(By.cssSelector(".main__title"), "Заголовок раздела не найден");
        postponedAssertTrue(title.isDisplayed(), "Заголовок раздела не отображается");
        postponedAssertEquals(title.getText(), reqTitle, "Неправильный текст заголовка раздела");
    }

    public void checkTaxKodeksBlockIsPresent() {
        WebElement laborKodeks = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_tax-code"), "Блок 'Налоговый кодекс' не найден");
        postponedAssertTrue(laborKodeks.isDisplayed(), "Блок 'Налоговый кодекс' не отображается");

        WebElement title = findElementByNoThrow(laborKodeks, By.cssSelector(".widget__title-text"));
        postponedAssertNotNull(title, "Заголовок блока 'Налоговый кодекс' не найден");
        if (title != null) {
            postponedAssertEquals(title.getText(), "Налоговый", "Неправильный текст заголовка блока 'Налоговый кодекс'");
        }
    }

    public void checkBudgetKodeksBlockIsPresent() {
        WebElement budgetKodeks = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_budget-code"), "Блок 'Бюджетный кодекс' не найден");
        postponedAssertTrue(budgetKodeks.isDisplayed(), "Блок 'Бюджетный кодекс' не отображается");

        WebElement title = findElementByNoThrow(budgetKodeks, By.cssSelector(".widget__title-text"));
        postponedAssertNotNull(title, "Заголовок блока 'Бюджетный кодекс' не найден");
        if (title != null) {
            postponedAssertEquals(title.getText(), "Бюджетный", "Неправильный текст заголовка блока 'Налоговый кодекс'");
        }
    }

    public void checkStandartsBlockIsPresent() {
        WebElement laborKodeks = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_standarts"), "Блок " +
                "'Стандарты' не найден");
        postponedAssertTrue(laborKodeks.isDisplayed(), "Блок 'Стандарты' не отображается");

        WebElement title = findElementByNoThrow(laborKodeks, By.cssSelector(".widget__title-text"));
        postponedAssertNotNull(title, "Заголовок блока 'Стандарты' не найден");
        if (title != null) {
            postponedAssertEquals(title.getText(), "Стандарты", "Неправильный текст заголовка блока 'Стандарты'");
        }
    }

    public void checkLaborKodeksBlockIsPresent() {
        WebElement laborKodeks = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_labor-code"), "Блок 'Трудовой кодекс' не найден");
        postponedAssertTrue(laborKodeks.isDisplayed(), "Блок 'Трудовой кодекс' не отображается");

        WebElement title = findElementByNoThrow(laborKodeks, By.cssSelector(".widget__title-text"));
        postponedAssertNotNull(title, "Заголовок блока 'Трудовой кодекс' не найден");
        if (title != null) {
            postponedAssertEquals(title.getText(), "Трудовой", "Неправильный текст заголовка блока 'Трудовой кодекс'");
        }
    }

    public void checkLaborKodeksBlockResize(int widthTrue) {
        WebElement laborKodeks = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_labor-code"), "Блок 'Трудовой кодекс' не найден");
        postponedAssertTrue(widthTrue == laborKodeks.getSize().getWidth(), "Блок 'Трудовой кодекс' не того размера");
    }

    public void checkTaxKodeksBlockResize(int widthTrue) {
        WebElement TaxKodeks = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_tax-code"), "Блок 'Налоговый кодекс' не найден");
        postponedAssertTrue(widthTrue == TaxKodeks.getSize().getWidth(), "Блок 'Налоговый кодекс' не того размера");
    }

    public void checkBudgetKodeksBlockResize(int widthTrue) {
        WebElement budgetKodeks = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_budget-code"), "Блок 'Бюджетный кодекс' не найден");

        postponedAssertTrue(widthTrue == budgetKodeks.getSize().getWidth(), "Блок 'Бюджетный кодекс' не того размера");
    }

    public void checkCivilKodeksBlockResize(int widthTrue) {
        WebElement CivilKodeks = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_civil-code"), "Блок 'Гражданский кодекс' не найден");
        postponedAssertTrue(widthTrue == CivilKodeks.getSize().getWidth(), "Блок 'Гражданский кодекс' не того размера");
    }

    public void checkCivilKodeksBlockIsPresent() {
        WebElement laborKodeks = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_civil-code"), "Блок 'Гражданский кодекс' не найден");
        postponedAssertTrue(laborKodeks.isDisplayed(), "Блок 'Гражданский кодекс' не отображается");

        WebElement title = findElementByNoThrow(laborKodeks, By.cssSelector(".widget__title-text"));
        postponedAssertNotNull(title, "Заголовок блока 'Гражданский кодекс' не найден");
        if (title != null) {
            postponedAssertEquals(title.getText(), "Гражданский", "Неправильный текст заголовка блока 'Гражданский кодекс'");
        }
    }

    public void checkOtherKodeksBlockIsPresent() {
        WebElement laborKodeks = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_other-code"), "Блок 'Прочие кодексы' не найден");
        postponedAssertTrue(laborKodeks.isDisplayed(), "Блок 'Прочие кодексы' не отображается");

        WebElement title = findElementByNoThrow(laborKodeks, By.cssSelector(".widget__title-text"));
        postponedAssertNotNull(title, "Заголовок блока 'Прочие кодексы' не найден");
        if (title != null) {
            postponedAssertTrue(title.getText().equals("Прочие кодексы") || title.getText().contains("Прочие"), "Неправильный текст заголовка блока 'Прочие кодексы'");
        }
    }

    public void checkLegislationBlockIsPresent(String titleName) {
        WebElement laborKodeks = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_legislation"), "Блок 'Важное' не найден");
        postponedAssertTrue(laborKodeks.isDisplayed(), "Блок 'Важное' не отображается");

        WebElement title = findElementByNoThrow(laborKodeks, By.cssSelector(".widget__title-text"));
        postponedAssertNotNull(title, "Заголовок блока '" + titleName + "' не найден");
        if (title != null) {
            postponedAssertEquals(title.getText(), titleName, "Неправильный текст заголовка блока '" + titleName + "'");
        }
    }

    public void checkProfStandartsBlockIsPresent() {
        WebElement laborKodeks = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_profstandarts"),
                "Блок 'Профстандарты' не найден");
        postponedAssertTrue(laborKodeks.isDisplayed(), "Блок 'Профстандарты' не отображается");

        WebElement title = findElementByNoThrow(laborKodeks, By.cssSelector(".widget__title-text"));
        postponedAssertNotNull(title, "Заголовок блока 'Профстандарты' не найден");
        if (title != null) {
            String titleName = hookForGettingTextWithoutIncludingChildElementsText(title).trim();
            postponedAssertEquals(titleName, "Профстандарты", "Неправильный текст заголовка блока 'Профстандарты'");
        }
    }

    public void checkJudgmentBlockIsPresent() {
        WebElement laborKodeks = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_judgment"), "Блок 'Судебные решения' не найден");
        postponedAssertTrue(laborKodeks.isDisplayed(), "Блок 'Судебные решения' не отображается");

        WebElement title = findElementByNoThrow(laborKodeks, By.cssSelector(".widget__title-text"));
        postponedAssertNotNull(title, "Заголовок блока 'Судебные решения' не найден");
        if (title != null) {
            String actualTitle = title.getText().split("\n")[0].trim();
            postponedAssertEquals(actualTitle, "Судебные решения", "Неправильный текст заголовка блока 'Судебные решения'");
        }
    }

    public void checkFASBlocksArePresent() {
        List<WebElement> fasBlocks = waitForPresenceOfAllElementsLocatedBy(By.cssSelector("[class*='widget_content_fas']"), "Блоки 'ФАС' не найдены");
        for (WebElement fasBlock : fasBlocks) {
            WebElement title = findElementByNoThrow(fasBlock, By.cssSelector(".widget__title-text"));
            postponedAssertNotNull(title, "Заголовок блока 'ФАС' не найден");

            String titleText = title != null ? title.getText() : "ФАС";
            postponedAssertTrue(fasBlock.isDisplayed(), "Блок '" + titleText + "' не отображается");
        }
    }

    public void checkRegionBlockIsPresent() {
        WebElement regionBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_region"), "Блок 'Региональные документы' не найден");
        postponedAssertTrue(regionBlock.isDisplayed(), "Блок 'Региональные документы' не отображается");

        WebElement title = findElementByNoThrow(regionBlock, By.cssSelector(".widget__title-text"));
        postponedAssertNotNull(title, "Заголовок блока 'Региональные документы' не найден");
        if (title != null) {
            postponedAssertEquals(title.getText(), "Популярное в Москве", "Неправильный текст заголовка блока 'Региональные документы'");
        }
    }

    public void checkFederalLawsBlockIsPresent() {
        WebElement regionBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_federallaws"),
                "Блок 'Федеральные законы' не найден");
        postponedAssertTrue(regionBlock.isDisplayed(), "Блок 'Федеральные законы' не отображается");

        WebElement title = findElementByNoThrow(regionBlock, By.cssSelector(".widget__title-text"));
        postponedAssertNotNull(title, "Заголовок блока 'Федеральные законы' не найден");
        if (title != null) {
            postponedAssertEquals(title.getText(), "Федеральные законы",
                    "Неправильный текст заголовка блока 'Федеральные законы'");
        }
    }

    public void checkIndustrialSafetyBlockIsPresent() {
        WebElement regionBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_industrial_safety"),
                "Блок 'Промышленная безопасность' не найден");
        postponedAssertTrue(regionBlock.isDisplayed(), "Блок 'Промышленная безопасность' не отображается");

        WebElement title = findElementByNoThrow(regionBlock, By.cssSelector(".widget__title-text"));
        postponedAssertNotNull(title, "Заголовок блока 'Промышленная безопасность' не найден");
        if (title != null) {
            postponedAssertEquals(title.getText(), "Промышленная безопасность",
                    "Неправильный текст заголовка блока 'Промышленная безопасность'");
        }
    }

    public void checkIndustryDocsBlockIsPresent() {
        WebElement regionBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_industry_doc"),
                "Блок 'Отраслевые документы' не найден");
        postponedAssertTrue(regionBlock.isDisplayed(), "Блок 'Отраслевые документы' не отображается");

        WebElement title = findElementByNoThrow(regionBlock, By.cssSelector(".widget__title-text"));
        postponedAssertNotNull(title, "Заголовок блока 'Отраслевые документы' не найден");
        if (title != null) {
            postponedAssertEquals(title.getText(), "Отраслевые документы",
                    "Неправильный текст заголовка блока 'Отраслевые документы'");
        }
    }

    public void checkLaborDisputesIsPresent() {
        WebElement regionBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_tspor"),
                "Блок 'Трудовые споры' не найден");
        postponedAssertTrue(regionBlock.isDisplayed(), "Блок 'Трудовые споры' не отображается");

        WebElement title = findElementByNoThrow(regionBlock, By.cssSelector(".widget__title-text"));
        postponedAssertNotNull(title, "Заголовок блока 'Трудовые споры' не найден");
        if (title != null) {
            postponedAssertEquals(title.getText(), "Трудовые споры", "Неправильный текст заголовка блока 'Трудовые споры'");
        }
    }

    public void checkRegionBlockIsPresent(String region) {
        WebElement regionBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_region"), "Блок 'Региональные документы' не найден");
        postponedAssertTrue(regionBlock.isDisplayed(), "Блок 'Региональные документы' не отображается");

        WebElement title = findElementByNoThrow(regionBlock, By.cssSelector(".widget__title-text"));
        postponedAssertNotNull(title, "Заголовок блока 'Региональные документы' не найден");
        if (title != null) {
            postponedAssertEquals(title.getText(), "Популярное в " + region, "Неправильный текст заголовка блока 'Региональные документы'");
        }
    }

    public void checkChangeRegionLinkIsPresent() {
        WebElement regionBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_region"), "Блок 'Региональные документы' не найден");
        postponedAssertTrue(regionBlock.isDisplayed(), "Блок 'Региональные документы' не отображается");

        WebElement changeRegionLink = findElementByNoThrow(regionBlock, By.linkText("Изменить регион"));
        postponedAssertNotNull(changeRegionLink, "Ссылка 'Изменить регион' не найдена");
        if (changeRegionLink != null) {
            postponedAssertTrue(changeRegionLink.isDisplayed(), "Ссылка 'Изменить регион' не отображается");
        }
    }

    public void checkAllKodexRubricatorButtonIsPresent() {
        WebElement rubricatorButton = waitForPresenceOfElementLocatedBy(By.id("rubricator-btn"), "Кнопка Все кодексы Отсутствует");
        postponedAssertEquals(rubricatorButton.getText(), "Все кодексы", "Неправильный текст кнопки Все кодексы");
    }


    @Step("Проверяется работа ссылок блока 'Региональные документы'")
    public void checkRegionBlockLinks() {
        WebElement regionBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_region"),
                "Блок 'Региональные документы' не найден");
        List<WebElement> budgetKodeksTitleList = regionBlock.findElements(By.cssSelector(".list__item"));

        postponedAssertTrue(budgetKodeksTitleList.size() > 0, "Ссылки в блоке 'Региональные документы' не отображаются");

        List<Link> budgetKodeksLinkList = new ArrayList<Link>();
        for (WebElement kodeksElement : budgetKodeksTitleList) {
            String url = kodeksElement.findElement(By.tagName("a")).getAttribute("href");
            String header = kodeksElement.findElement(By.tagName("a")).getText();
            Link link = new Link(url, header);
            budgetKodeksLinkList.add(link);
        }
        checkLinks(budgetKodeksLinkList);
    }

    @Step("Проверяется строка поиска блока 'Региональные документы'")
    public void checkSearchBoxIsPresentRegionBlock(String textInSearchBox) {

        WebElement regionBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_region"), "Блок 'Региональные документы' не найден");
        WebElement searchForm = findElementBy(regionBlock, By.cssSelector(".form_type_search-custom"));
        WebElement searchBox = findElementByNoThrow(searchForm, By.cssSelector("[type='text']"));
        postponedAssertTrue(searchBox != null && searchBox.isDisplayed(), "Строка поиска не найдена");
        WebElement searchBoxTextElement = findElementBy(By.id("widget-search-regional-popular-text"));

        String valueInSearchBox;
        if (searchBoxTextElement.getAttribute("value").isEmpty() && !textInSearchBox.isEmpty()) {
            valueInSearchBox = searchBoxTextElement.getAttribute("placeholder").toLowerCase();
        } else {
            valueInSearchBox = searchBoxTextElement.getAttribute("value").toLowerCase();
        }

        postponedAssertEquals(valueInSearchBox, textInSearchBox.toLowerCase(), "Неправильный текст в строке поиска");
        postponedAssertTrue(findElementByNoThrow(searchForm, By.cssSelector("[type='submit']")) != null &&
                searchForm.findElement(By.cssSelector("[type='submit']")).isDisplayed(), "Кнопка 'Найти' не найдена");
    }

    @Step("Ввести текст в строку поиска в блоке 'Региональные документы'")
    public void inputTextInSearchBoxOnRegionBlock(String query) {
        WebElement regionBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_region"));
        WebElement searchBox = regionBlock.findElement(By.id("widget-search-regional-popular-text"));
        TextField textField = getWebElementWrapper(searchBox).getTextField();
        textField.clearAndType(query);
        searchBox.sendKeys(Keys.ARROW_DOWN);
        setParameter(SearchResultHelper.HINT_TEXT, query);
    }

    @Step("Кликнуть на ссылку 'Изменить регион'")
    public void clickLinkChangeRegion() {
        WebElement regionBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_region"), "Блок 'Региональные документы' не найден");
        postponedAssertTrue(regionBlock.isDisplayed(), "Блок 'Региональные документы' не отображается");

        WebElement changeRegionLink = findElementByNoThrow(regionBlock, By.cssSelector(".link"));
        postponedAssertNotNull(changeRegionLink, "Ссылка 'Изменить регион' не найдена");
        if (changeRegionLink != null) {
            changeRegionLink.click();
        }
    }


    public void checkMainDocsBlockIsPresent() {
        WebElement laborKodeks = waitForPresenceOfElementLocatedBy(By.cssSelector(".news"), "Блок 'Главные документы' не найден");
        postponedAssertTrue(laborKodeks.isDisplayed(), "Блок 'Главные документы' не отображается");

        WebElement title = findElementByNoThrow(laborKodeks, By.cssSelector(".news__title-text"));
        postponedAssertNotNull(title, "Заголовок блока 'Главные документы' не найден");
        if (title != null) {
            postponedAssertEquals(title.getText(), "Главные документы", "Неправильный текст заголовка блока 'Главные документы'");
        }
    }

    @Step("Проверяется строка поиска блока 'Прочие кодексы'")
    public void checkSearchBoxIsPresentOtherCode(String textInSearchBox) {

        WebElement otherKodeks = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_other-code"), "Блок 'Прочие кодексы' не найден");
        WebElement searchForm = findElementBy(otherKodeks, By.cssSelector(".form_type_search-custom"));
        WebElement searchBox = findElementByNoThrow(searchForm, By.cssSelector("[type='text']"));
        postponedAssertTrue(searchBox != null && searchBox.isDisplayed(), "Строка поиска не найдена");
        WebElement searchBoxTextElement = findElementBy(By.id("widget-search-other-code-text"));

        String valueInSearchBox;
        if (searchBoxTextElement.getAttribute("value").isEmpty() && !textInSearchBox.isEmpty()) {
            valueInSearchBox = searchBoxTextElement.getAttribute("placeholder").toLowerCase();
        } else {
            valueInSearchBox = searchBoxTextElement.getAttribute("value").toLowerCase();
        }

        postponedAssertEquals(valueInSearchBox, textInSearchBox.toLowerCase(), "Неправильный текст в строке поиска");
        postponedAssertTrue(findElementByNoThrow(searchForm, By.cssSelector("[type='submit']")) != null &&
                searchForm.findElement(By.cssSelector("[type='submit']")).isDisplayed(), "Кнопка 'Найти' не найдена");
    }

    @Step("Проверяется строка поиска блока 'Судебные решения'")
    public void checkSearchBoxIsPresentJudgmentBlock(String textInSearchBox) {

        WebElement judgmentBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_judgment"), "Блок 'Судебные решения' не найден");
        WebElement searchForm = findElementBy(judgmentBlock, By.cssSelector(".form_type_search-custom"));
        WebElement searchBox = findElementByNoThrow(searchForm, By.cssSelector("[type='text']"));
        postponedAssertTrue(searchBox != null && searchBox.isDisplayed(), "Строка поиска не найдена");
        WebElement searchBoxTextElement = findElementBy(By.id("widget-search-judgment-text"));

        String valueInSearchBox;
        if (searchBoxTextElement.getAttribute("value").isEmpty() && !textInSearchBox.isEmpty()) {
            valueInSearchBox = searchBoxTextElement.getAttribute("placeholder").toLowerCase();
        } else {
            valueInSearchBox = searchBoxTextElement.getAttribute("value").toLowerCase();
        }

        postponedAssertEquals(valueInSearchBox, textInSearchBox.toLowerCase(), "Неправильный текст в строке поиска");
        postponedAssertTrue(findElementByNoThrow(searchForm, By.cssSelector("[type='submit']")) != null &&
                searchForm.findElement(By.cssSelector("[type='submit']")).isDisplayed(), "Кнопка 'Найти' не найдена");
    }

    @Step("Проверяется работа ссылок блока 'Прочие кодексы'")
    public void checkOtherKodeksBlockLinks() {
        WebElement otherKodeksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_other-code"),
                "Блок 'Прочие кодексы' не найден");
        List<WebElement> otherKodeksTitleList = otherKodeksBlock.findElements(By.cssSelector(".list__item"));

        postponedAssertTrue(otherKodeksTitleList.size() > 0, "Ссылки в блоке 'Прочие кодексы' не отображаются");

        List<Link> otherKodeksLinkList = new ArrayList<Link>();
        for (WebElement kodeksElement : otherKodeksTitleList) {
            String url = kodeksElement.findElement(By.tagName("a")).getAttribute("href");
            String header = kodeksElement.findElement(By.tagName("a")).getText();
            Link link = new Link(url, header);
            otherKodeksLinkList.add(link);
        }
        checkLinks(otherKodeksLinkList);
    }

    @Step("Проверяется отображение ссылок блока 'Прочие кодексы'")
    public void checkOtherKodeksBlockLinksDisplayed() {
        WebElement otherKodeksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_other-code"),
                "Блок 'Прочие кодексы' не найден");
        List<WebElement> otherKodeksTitleList = otherKodeksBlock.findElements(By.cssSelector(".list__item"));

        postponedAssertTrue(otherKodeksTitleList.size() > 0, "Ссылки в блоке 'Прочие кодексы' не отображаются");
    }

    @Step("Проверяется работа ссылок блока 'Трудовой'")
    public void checkLaborKodeksBlockLinks() {
        WebElement laborKodeksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_labor-code"),
                "Блок 'Трудовой кодекс' не найден");
        List<WebElement> laborKodeksTitleList = laborKodeksBlock.findElements(By.cssSelector(".list__item"));

        postponedAssertTrue(laborKodeksTitleList.size() > 0, "Ссылки в блоке 'Трудовой кодек' не отображаются");

        List<Link> laborKodeksLinkList = new ArrayList<Link>();
        for (WebElement kodeksElement : laborKodeksTitleList) {
            String url = kodeksElement.findElement(By.tagName("a")).getAttribute("href");
            String header = kodeksElement.findElement(By.tagName("a")).getText();
            Link link = new Link(url, header);
            laborKodeksLinkList.add(link);
        }
        checkLinks(laborKodeksLinkList);
    }

    @Step("Проверяется работа ссылок блока 'Налоговый кодекс'")
    public void checkTaxKodeksBlockLinks() {
        WebElement taxKodeksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_tax-code"),
                "Блок 'Налоговый кодекс' не найден");
        List<WebElement> taxKodeksTitleList = taxKodeksBlock.findElements(By.cssSelector(".list__item"));

        postponedAssertTrue(taxKodeksTitleList.size() > 0, "Ссылки в блоке 'Налоговый кодекс' не отображаются");

        List<Link> taxKodeksLinkList = new ArrayList<Link>();
        for (WebElement kodeksElement : taxKodeksTitleList) {
            String url = kodeksElement.findElement(By.tagName("a")).getAttribute("href");
            String header = kodeksElement.findElement(By.tagName("a")).getText();
            Link link = new Link(url, header);
            taxKodeksLinkList.add(link);
        }
        checkLinks(taxKodeksLinkList);
    }

    @Step("Проверяется работа ссылок блока 'Бюджетный кодекс'")
    public void checkBudgetKodeksBlockLinks() {
        WebElement budgetKodeksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_budget-code"),
                "Блок 'Бюджетный кодекс' не найден");
        List<WebElement> budgetKodeksTitleList = budgetKodeksBlock.findElements(By.cssSelector(".list__item"));

        postponedAssertTrue(budgetKodeksTitleList.size() > 0, "Ссылки в блоке 'Бюджетный кодекс' не отображаются");

        List<Link> budgetKodeksLinkList = new ArrayList<Link>();
        for (WebElement kodeksElement : budgetKodeksTitleList) {
            String url = kodeksElement.findElement(By.tagName("a")).getAttribute("href");
            String header = kodeksElement.findElement(By.tagName("a")).getText();
            Link link = new Link(url, header);
            budgetKodeksLinkList.add(link);
        }
        checkLinks(budgetKodeksLinkList);
    }

    @Step("Проверяется работа ссылок блока 'Гражданский кодекс'")
    public void checkCivilKodeksBlockLinks() {
        WebElement civilKodeksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_civil-code"),
                "Блок 'Гражданский кодекс' не найден");
        List<WebElement> civilKodeksTitleList = civilKodeksBlock.findElements(By.cssSelector(".list__item"));

        postponedAssertTrue(civilKodeksTitleList.size() > 0, "Ссылки в блоке 'Гражданский кодекс' не отображаются");

        List<Link> civilKodeksLinkList = new ArrayList<Link>();
        for (WebElement kodeksElement : civilKodeksTitleList) {
            String url = kodeksElement.findElement(By.tagName("a")).getAttribute("href");
            String header = kodeksElement.findElement(By.tagName("a")).getText();
            Link link = new Link(url, header);
            civilKodeksLinkList.add(link);
        }
        checkLinks(civilKodeksLinkList);
    }

    @Step("Проверяется отображение ссылок блока 'Судебные решения'")
    public void checkJudgmentKodeksBlockLinksDisplayed() {
        WebElement judgmentKodeksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_judgment"),
                "Блок 'Судебные решения' не найден");
        List<WebElement> judgmentKodeksTitleList = judgmentKodeksBlock.findElements(By.cssSelector(".list__item"));
        postponedAssertTrue(judgmentKodeksTitleList.size() > 0, "Ссылки в блоке 'Судебные решения' не отображаются");
    }

    @Step("Проверяется работа ссылок блока 'Судебные решения'")
    public void checkJudgmentKodeksBlockLinks() {
        WebElement judgmentKodeksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_judgment"),
                "Блок 'Судебные решения' не найден");
        List<WebElement> judgmentKodeksTitleList = judgmentKodeksBlock.findElements(By.cssSelector(".list__item"));

        postponedAssertTrue(judgmentKodeksTitleList.size() > 0, "Ссылки в блоке 'Судебные решения' не отображаются");

        List<Link> judgmentKodeksLinkList = new ArrayList<Link>();
        for (WebElement kodeksElement : judgmentKodeksTitleList) {
            String url = kodeksElement.findElement(By.tagName("a")).getAttribute("href");
            String header = kodeksElement.findElement(By.tagName("a")).getText();
            Link link = new Link(url, header);
            judgmentKodeksLinkList.add(link);
        }
        checkLinks(judgmentKodeksLinkList);
    }

    @Step("Проверяется работа ссылок блока 'Судебные решения'")
    public void checkJudgmentKodeksBlockLinksAreWorked() {
        WebElement judgmentKodeksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_judgment"), "Блок 'Судебные решения' не найден");
        List<WebElement> judgmentKodeksLinkList = judgmentKodeksBlock.findElements(By.cssSelector(".list__item"));
        postponedAssertTrue(judgmentKodeksLinkList.size() > 0, "Ссылки в блоке 'Судебные решения' не отображаются");

        for (int i = 0; i < judgmentKodeksLinkList.size(); i++) {
            WebElement judgmentKodeks = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_judgment"), "Блок 'Судебные решения' не найден");
            List<WebElement> judgmentKodeksLink = judgmentKodeks.findElements(By.cssSelector(".list__item"));
            WebElement link = judgmentKodeksLink.get(i).findElement(By.tagName("a"));
            String url = link.getAttribute("href");
            if (url.contains("/document/")) {
                continue;
            }
            report("Проверяется работа ссылки '" + url + "' из блока 'Судебные решения'");
            link.click();
            waitForReloadingPage();
            WebElement page = waitForPresenceOfElementLocatedBy(By.id("main-left"));
            waitForTextToBePresentIn(page);

            WebElement searchResult = findElementByNoThrow(mainContentElement, By.id("searchResultsSection"));
            WebElement filterBlock = findElementByNoThrow(mainContentElement, By.id("sidebar"));
            WebElement errorBlock = findElementByNoThrow(mainContentElement, By.xpath("//h1[text()='При поиске произошла техническая ошибка.']"));
            assertNull(errorBlock, "При поиске произошла техническая ошибка. Урл - " + url);
            postponedAssertNotNull(searchResult, "Результаты поиска не найдены. Урл - " + url);
            postponedAssertNotNull(filterBlock, "Фильтры не найдены. Урл - " + url);
            if (searchResult != null) {
                List<WebElement> searchResultItemList = searchResult.findElements(By.cssSelector(".widget-header"));
                postponedAssertFalse(searchResultItemList.isEmpty(), "Результаты поиска не найдены. Урл - " + url);
            }
            if (filterBlock != null) {
                List<WebElement> searchResultItemList = filterBlock.findElements(By.tagName("li"));
                postponedAssertFalse(searchResultItemList.isEmpty(), "Список фильтров пустой. Урл - " + url);
            }
            returnToBack();
            waitForReloadingPage();
        }
    }

    @Step("Проверяется работа ссылок блока 'ФАС'")
    public void checkFASBlockLinksAreWorked() {
        List<WebElement> fasBlocks = waitForPresenceOfAllElementsLocatedBy(By.cssSelector("[class*='widget_content_fas']"), "Блоки 'ФАС' не найдены");

        for (int blockCounter = 0; blockCounter < fasBlocks.size(); blockCounter++) {
            WebElement fasBlock = fasBlocks.get(blockCounter);

            WebElement title = findElementByNoThrow(fasBlock, By.cssSelector(".widget__title-text"));
            String titleText = title != null ? title.getText() : "ФАС";

            List<WebElement> judgmentKodeksLinkList = fasBlock.findElements(By.cssSelector(".list__item"));
            postponedAssertTrue(judgmentKodeksLinkList.size() > 0, "Ссылки в блоке '" + titleText + "' не отображаются");

            for (int i = 0; i < judgmentKodeksLinkList.size(); i++) {
                fasBlocks = waitForPresenceOfAllElementsLocatedBy(By.cssSelector("[class*='widget_content_fas']"), "Блоки 'ФАС' не найдены");
                fasBlock = fasBlocks.get(blockCounter);

                List<WebElement> judgmentKodeksLink = fasBlock.findElements(By.cssSelector(".list__item"));
                WebElement link = judgmentKodeksLink.get(i).findElement(By.tagName("a"));
                String linkText = link.getText();
                String url = link.getAttribute("href");
                report("Проверяется работа ссылки. Блок - " + titleText + ", Текст - " + linkText + ", Урл - " + url);
                link.click();
                waitForReloadingPage();
                WebElement page = waitForPresenceOfElementLocatedBy(By.id("main-left"));
                waitForTextToBePresentIn(page);

                WebElement searchResult = findElementByNoThrow(mainContentElement, By.id("searchResultsSection"));
                WebElement filterBlock = findElementByNoThrow(mainContentElement, By.id("sidebar"));
                WebElement errorBlock = findElementByNoThrow(mainContentElement, By.xpath("//h1[text()='При поиске произошла техническая ошибка.']"));
                assertNull(errorBlock, "При поиске произошла техническая ошибка. Блок - " + titleText + ", Текст - " + linkText + ", Урл - " + url);
                postponedAssertNotNull(searchResult, "Результаты поиска не найдены. Блок - " + titleText + ", Текст - " + linkText + ", Урл - " + url);
                postponedAssertNotNull(filterBlock, "Фильтры не найдены. Блок - " + titleText + ", Текст - " + linkText + ", Урл - " + url);
                if (searchResult != null) {
                    List<WebElement> searchResultItemList = searchResult.findElements(By.cssSelector(".widget-header"));
                    postponedAssertFalse(searchResultItemList.isEmpty(), "Результаты поиска не найдены. Блок - " + titleText + ", Текст - " + linkText + ", Урл - " + url);
                }
                if (filterBlock != null) {
                    List<WebElement> searchResultItemList = filterBlock.findElements(By.tagName("li"));
                    postponedAssertFalse(searchResultItemList.isEmpty(), "Список фильтров пустой. Блок - " + titleText + ", Текст - " + linkText + ", Урл - " + url);
                }
                returnToBack();
                waitForReloadingPage();
            }
        }
    }

    @Step("Ввести текст в строку поиска в блоке 'Прочие кодексы'")
    public void inputTextInSearchBoxOnOtherKodeksBlock(String query) {
        WebElement otherKodeksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_other-code"));
        WebElement searchBox = otherKodeksBlock.findElement(By.id("widget-search-other-code-text"));
        TextField textField = getWebElementWrapper(searchBox).getTextField();
        textField.clearAndType(query);
        searchBox.sendKeys(Keys.ARROW_DOWN);
        setParameter(SearchResultHelper.HINT_TEXT, query);
    }

    @Step("Ввести текст в строку поиска в блоке 'Судебные решения'")
    public void inputTextInSearchBoxOnJudgmentBlock(String query) {
        WebElement judgmentBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_judgment"));
        WebElement searchBox = judgmentBlock.findElement(By.id("widget-search-judgment-text"));
        TextField textField = getWebElementWrapper(searchBox).getTextField();
        textField.clearAndType(query);
        searchBox.sendKeys(Keys.ARROW_DOWN);
        setParameter(SearchResultHelper.HINT_TEXT, query);
    }

    @Step("Проверяется что поисковые подсказки не отображаются в блоке 'Судебные решения'")
    public void checkHintsIsNotPresentOnJudgmentBlock() {
        WebElement judgmentBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_judgment"));
        hookSearchResultVisible();
        WebElement searchResult = findElementByNoThrow(judgmentBlock, By.cssSelector(".ui-autocomplete"));
        postponedAssertNull(searchResult, "Выпадающие поисковые подсказки в блоке 'Судебные решения' найдены");
        if (searchResult != null) {
            searchResult.click();
            postponedAssertFalse(searchResult.isDisplayed(), "Выпадающие поисковые подсказки в блоке 'Судебные решения' отображаются");
        }
    }

    @Step("Проверяется что поисковые подсказки отображаются в блоке 'Прочие кодексы'")
    public void checkHintsIsPresentOnOtherKodeksBlock() {
        waitFewSecond(2000);
        WebElement otherKodeksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_other-code"));
        hookSearchResultVisible();
        WebElement searchResult = findElementByNoThrow(otherKodeksBlock, By.cssSelector(".ui-autocomplete"));
        postponedAssertNotNull(searchResult, "Выпадающие поисковые подсказки в блоке 'Прочие кодексы' не найдены");

        if (searchResult != null) {
            postponedAssertTrue(searchResult.isDisplayed(), "Выпадающие поисковые подсказки в блоке 'Прочие кодексы' не отображаются");
            checkHintsIsPresent(searchResult);
            checkTKHints(searchResult);
        }
    }

    @Step("Проверяется что поисковые подсказки отображаются в блоке 'Налоговый кодекс'")
    public void checkHintsIsPresentOnTaxKodeksBlock() {
        waitFewSecond(2000);
        WebElement taxKodeksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_tax-code"));
        hookSearchResultVisible();
        WebElement searchResult = findElementByNoThrow(taxKodeksBlock, By.cssSelector(".ui-autocomplete"));
        postponedAssertNotNull(searchResult, "Выпадающие поисковые подсказки в блоке 'Налоговый кодекс' не найдены");

        if (searchResult != null) {
            postponedAssertTrue(searchResult.isDisplayed(), "Выпадающие поисковые подсказки в блоке 'Налоговый кодекс' не отображаются");
            checkHintsIsPresent(searchResult);
        }
    }

    @Step("Проверяется что поисковые подсказки отображаются в блоке 'Бюджетный кодекс'")
    public void checkHintsIsPresentOnBudgetKodeksBlock() {
        waitFewSecond(2000);
        WebElement budgetKodeksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_budget-code"));
        hookSearchResultVisible();
        WebElement searchResult = findElementByNoThrow(budgetKodeksBlock, By.cssSelector(".ui-autocomplete"));
        postponedAssertNotNull(searchResult, "Выпадающие поисковые подсказки в блоке 'Бюджетный кодекс' не найдены");

        if (searchResult != null) {
            postponedAssertTrue(searchResult.isDisplayed(), "Выпадающие поисковые подсказки в блоке 'Бюджетный кодекс' не отображаются");
            checkHintsIsPresent(searchResult);
        }
    }

    @Step("Проверяется что поисковые подсказки отображаются в блоке 'Трудовой кодекс'")
    public void checkHintsIsPresentOnLaborBlock() {
        waitFewSecond(2000);
        WebElement laborKodeksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_labor-code"));
        hookSearchResultVisible();
        WebElement searchResult = findElementByNoThrow(laborKodeksBlock, By.cssSelector(".ui-autocomplete"));
        postponedAssertNotNull(searchResult, "Выпадающие поисковые подсказки в блоке 'Трудовой кодекс' не найдены");

        if (searchResult != null) {
            postponedAssertTrue(searchResult.isDisplayed(), "Выпадающие поисковые подсказки в блоке 'Трудовой кодекс' не отображаются");
            checkHintsIsPresent(searchResult);
        }
    }

    @Step("Проверяется что поисковые не подсказки отображаются в блоке 'Гражданский кодекс'")
    public void checkHintsIsNotPresentOnCivilKodeksBlock() {
        waitFewSecond(2000);
        WebElement civilKodeksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_civil-code"));
        hookSearchResultVisible();
        WebElement searchResult = findElementByNoThrow(civilKodeksBlock, By.cssSelector(".ui-autocomplete"));
        postponedAssertNotNull(searchResult, "Выпадающие поисковые подсказки в блоке 'Гражданский кодекс' не найдены");

        if (searchResult != null) {
            postponedAssertFalse(searchResult.isDisplayed(), "Выпадающие поисковые подсказки в блоке 'Гражданский кодекс' отображаются");
            checkHintsIsPresent(searchResult);
        }
    }

    @Step("Проверяется что поисковые подсказки не отображаются в блоке 'Налоговый кодекс'")
    public void checkHintsIsNotPresentOnTaxKodeksBlock() {
        waitFewSecond(2000);
        WebElement taxKodeksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_tax-code"));
        hookSearchResultVisible();
        WebElement searchResult = findElementByNoThrow(taxKodeksBlock, By.cssSelector(".ui-autocomplete"));
        postponedAssertNotNull(searchResult, "Выпадающие поисковые подсказки в блоке 'Налоговый кодекс' не найдены");

        if (searchResult != null) {
            postponedAssertFalse(searchResult.isDisplayed(), "Выпадающие поисковые подсказки в блоке 'Налоговый кодекс' отображаются");
            checkHintsIsPresent(searchResult);
        }
    }

    @Step("Проверяется что поисковые подсказки не отображаются в блоке 'Бюджет кодекс'")
    public void checkHintsIsNotPresentOnBudgetKodeksBlock() {
        waitFewSecond(2000);
        WebElement butgetKodeksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_budget-code"));
        hookSearchResultVisible();
        WebElement searchResult = findElementByNoThrow(butgetKodeksBlock, By.cssSelector(".ui-autocomplete"));
        postponedAssertNotNull(searchResult, "Выпадающие поисковые подсказки в блоке 'Бюджетный кодекс' не найдены");
        if (searchResult != null) {
            postponedAssertFalse(searchResult.isDisplayed(), "Выпадающие поисковые подсказки в блоке 'Бюджетный кодекс' отображаются");
            checkHintsIsPresent(searchResult);
        }
    }

    @Step("Проверяется что поисковые подсказки не отображаются в блоке 'Трудовой кодекс'")
    public void checkHintsIsNotPresentOnLaborKodeksBlock() {
        waitFewSecond(2000);
        WebElement laborKodeksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_labor-code"));
        hookSearchResultVisible();
        WebElement searchResult = findElementByNoThrow(laborKodeksBlock, By.cssSelector(".ui-autocomplete"));
        postponedAssertNotNull(searchResult, "Выпадающие поисковые подсказки в блоке 'Трудовой кодекс' не найдены");

        if (searchResult != null) {
            postponedAssertFalse(searchResult.isDisplayed(), "Выпадающие поисковые подсказки в блоке 'Трудовой кодекс' не отображаются");
            checkHintsIsPresent(searchResult);
        }
    }

    @Step("Проверяется что поисковые подсказки отображаются в блоке 'Гражданский кодекс'")
    public void checkHintsIsPresentOnCivilKodeksBlock() {
        waitFewSecond(2000);
        WebElement civilKodeksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_civil-code"));
        hookSearchResultVisible();
        WebElement searchResult = findElementByNoThrow(civilKodeksBlock, By.cssSelector(".ui-autocomplete"));
        postponedAssertNotNull(searchResult, "Выпадающие поисковые подсказки в блоке 'Гражданский кодекс' не найдены");

        if (searchResult != null) {
            postponedAssertTrue(searchResult.isDisplayed(), "Выпадающие поисковые подсказки в блоке 'Гражданский кодекс' не отображаются");
            checkHintsIsPresent(searchResult);

        }
    }

    @Step("Проверить подсказку в блоке 'Прочие Кодексы'")
    public void checkHintOnOtherKodeksBlock() {
        WebElement otherKodeksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_other-code"));
        hookSearchResultVisible();
        WebElement searchResult = findElementByNoThrow(otherKodeksBlock, By.cssSelector(".ui-autocomplete"));
        postponedAssertNotNull(searchResult, "Выпадающие поисковые подсказки в блоке 'Прочие кодексы' не найдены");
        if (searchResult != null) {
            WebElement hintlink = searchResult.findElement(By.tagName("a"));
            String url = hintlink.getAttribute("href");
            String header = hintlink.getText();
            List<Link> links = new ArrayList<Link>();
            links.add(new Link(url, header));
            checkLinks(links);
        }
    }


    @Step("Проверяется строка поиска блока 'Важное'")
    public void checkSearchBoxIsPresentLegislation(String textInSearchBox) {
        WebElement searchForm = waitForPresenceOfElementLocatedBy(By.cssSelector(".form_type_search-custom"), "Поисковая строка 'Важные документы' не найдена");
        hookSearchResultVisible();
        postponedAssertTrue(searchForm != null && searchForm.isDisplayed(), "Строка поиска не найдена");
        WebElement searchBoxTextElement = findElementBy(By.id("widget-search-legislation-text"));

        String valueInSearchBox;
        if (searchBoxTextElement.getAttribute("value").isEmpty() && !textInSearchBox.isEmpty()) {
            valueInSearchBox = searchBoxTextElement.getAttribute("placeholder").toLowerCase();
        } else {
            valueInSearchBox = searchBoxTextElement.getAttribute("value").toLowerCase();
        }

        postponedAssertEquals(valueInSearchBox, textInSearchBox.toLowerCase(), "Неправильный текст в строке поиска");
        postponedAssertTrue(findElementByNoThrow(searchForm, By.cssSelector("[type='submit']")) != null &&
                searchForm.findElement(By.cssSelector("[type='submit']")).isDisplayed(), "Кнопка 'Найти' не найдена");
    }

    @Step("Ввести текст в строку поиска в блоке 'Важное'")
    public void inputTextInSearchBoxOnLegislationBlock(String query) {
        WebElement legislationBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_legislation"));
        WebElement searchBox = legislationBlock.findElement(By.id("widget-search-legislation-text"));
        TextField textField = getWebElementWrapper(searchBox).getTextField();
        textField.clearAndType(query);
        searchBox.sendKeys(Keys.ARROW_DOWN);
        setParameter(SearchResultHelper.HINT_TEXT, query);
    }

    @Step("Проверяется что поисковые подсказки отображаются в блоке 'Важное'")
    public void checkHintsIsPresentOnLegislationBlock() {
        waitFewSecond(2000);
        WebElement legislationBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_legislation"));
        hookSearchResultVisible();
        WebElement searchResult = findElementByNoThrow(legislationBlock, By.cssSelector(".ui-autocomplete"));
        postponedAssertNotNull(searchResult, "Выпадающие поисковые подсказки в блоке 'Важное' не найдены");
        if (searchResult != null) {
            postponedAssertTrue(searchResult.isDisplayed(), "Выпадающие поисковые подсказки в блоке 'Важное' не отображаются");
            checkHintsIsPresent(searchResult);
        }
    }


    @Step("Проверяется отображение ссылок блока 'Важное'")
    public void checkLegislationBlockLinksDisplayed() {
        WebElement legislationBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_legislation"), "");
        List<WebElement> legislationTitleList = legislationBlock.findElements(By.cssSelector(".list__item"));
        postponedAssertTrue(legislationTitleList.size() > 0, "Ссылки в блоке 'Судебные решения' не отображаются");
    }

    @Step("Проверяется отображение ссылок блока 'Важное'")
    public void checkLegislationBlockLinks() {
        WebElement legislationBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_legislation"), "");
        List<WebElement> legislationTitleList = legislationBlock.findElements(By.cssSelector(".list__item"));
        postponedAssertTrue(legislationTitleList.size() > 0, "Ссылки в блоке 'Судебные решения' не отображаются");

        List<Link> LegislationLinkList = new ArrayList<Link>();
        for (WebElement newsTitleElement : legislationTitleList) {
            String url = newsTitleElement.findElement(By.tagName("a")).getAttribute("href");
            String header = newsTitleElement.findElement(By.tagName("a")).getText();
            Link link = new Link(url, header);
            LegislationLinkList.add(link);
        }
        checkLinks(LegislationLinkList);
    }

    private void checkHintsIsPresent(WebElement searchResult) {
        List<WebElement> hints = searchResult.findElements(By.cssSelector(".suggest__item"));
        for (WebElement hint : hints) {
            postponedAssertTrue(hint.isDisplayed(), "Подсказки не найдены");
        }
    }

    private void checkTKHints(WebElement searchResult) {
        List<WebElement> hints = searchResult.findElements(By.cssSelector(".suggest__item"));
        for (WebElement hint : hints) {
            postponedAssertFalse(hint.findElement(By.tagName("abbr")).getText().equals("ТК"), "Выявлены подсказки для трудового кодекса");
        }
    }

    public void clickHintWithJump(WebElement searchResult) {
        WebElement hintsWith = searchResult.findElement(By.cssSelector(".suggest__item"));
        WebElement hintsWithJumpLink = hintsWith.findElement(By.tagName("a"));
        setParameter(SearchResultHelper.HINT_TEXT, hintsWithJumpLink.getText());
        if (hintsWithJumpLink.getAttribute("href") != null) {
            setParameter(SearchResultHelper.DOCUMENT_URL, hintsWithJumpLink.getAttribute("href"));
        }
        hintsWithJumpLink.click();
        waitForReloadingPage();
    }

    public void checkConflictDisplayBlock() {
        List<WebElement> wrapper = waitForPresenceOfAllElementsLocatedBy(By.xpath("//div[@class='main__in']/article"), "Блок с кодексами не найден");
        int[][] points = new int[wrapper.size()][4];
        for (int i = 0; i < wrapper.size(); i++) {
            points[i][0] = wrapper.get(i).getLocation().getX();
            points[i][1] = wrapper.get(i).getLocation().getX() + wrapper.get(i).getSize().getWidth();
            points[i][2] = wrapper.get(i).getLocation().getY();
            points[i][3] = wrapper.get(i).getLocation().getY() + wrapper.get(i).getSize().getHeight();
        }
        for (int i = 0; i < wrapper.size(); i++) {
            for (int j = 0; j < wrapper.size(); j++) {
                if (j != i) {
                    postponedAssertFalse((points[i][0] <= points[j][0] && points[i][1] >= points[j][1])
                            && (points[i][2] <= points[j][2] && points[i][3] >= points[j][3]), "Какой-то из блоков наезжает на другой");
                }
            }
        }
    }

    @Step("Проверяется работа ссылок блока 'Главные документы'")
    public void checkMainDocsBlockLinks() {
        WebElement mainDocsLink = waitForPresenceOfElementLocatedBy(By.cssSelector(".news a"), "Ссылка 'Главные документы' не найден");
        checkLinks(Collections.singletonList(new Link(mainDocsLink.getAttribute("href"))));
    }

    @Step("Проверяются секции блока 'Главные документы'")
    public void checkMainDocsBlockSections() {
        WebElement mainDocsBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".news"), "Блок 'Главные документы' не найден");
        List<WebElement> mainDocsSectionsList = mainDocsBlock.findElements(By.cssSelector(".news__date"));

        postponedAssertTrue(mainDocsSectionsList.size() > 0, "Секции в блоке 'Главные документы' не отображаются");

        List<String> headings = new ArrayList<String>();
        headings.addAll(getTextFromWebElementList(mainDocsSectionsList));

        postponedAssertTrue(headings.contains("Cегодня"), "Секция 'Сегодня' не отображается");
        postponedAssertTrue(headings.contains("На неделе"), "Секция 'На неделе' не отображается");
        postponedAssertTrue(headings.contains("За месяц"), "Секция 'За месяц' не отображается");
    }

    @Step("Проверка что изменился заголов региона")
    public void checkTitleChangeRegion(String region) {
        WebElement regionBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_region"), "Блок 'Региональные документы' не найден");
        WebElement title = regionBlock.findElement(By.className("widget__title-text"));
        postponedAssertEquals(title.getText(), region, "Заголовок блока регион не совпадает");
    }

    @Step("Проверяется наличие блока 'Налоговый кодекс'")
    public void checkTaxBlock() {
        WebElement taxKodeksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_tax-code"));
        WebElement taxKodeksLink = taxKodeksBlock.findElement(By.cssSelector(".link"));
        postponedAssertEquals(taxKodeksLink.getText(), "Налоговый", "Текст заголовка первого блока не верен");
        List<WebElement> taxKodeksTitleList = taxKodeksBlock.findElements(By.cssSelector(".list__item"));
        postponedAssertTrue(taxKodeksTitleList.size() > 0, "Ссылки в блоке 'Налоговый кодекс' не отображаются");
        WebElement searchBox = taxKodeksBlock.findElement(By.id("widget-search-tax-code-text"));
        TextField textField = getWebElementWrapper(searchBox).getTextField();
        postponedAssertEquals(textField.getText(), "Поиск статей", "'Поиск статей' не отображается");
    }

    @Step("Проверяется наличие блока 'Бюджетный кодекс'")
    public void checkBudgetBlock() {
        WebElement budgetKodeksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_budget-code"));
        WebElement budgetKodeksLink = budgetKodeksBlock.findElement(By.cssSelector(".link"));
        postponedAssertEquals(budgetKodeksLink.getText(), "Бюджетный", "Текст заголовка первого блока не верен");
        List<WebElement> budgetKodeksTitleList = budgetKodeksBlock.findElements(By.cssSelector(".list__item"));
        postponedAssertTrue(budgetKodeksTitleList.size() > 0, "Ссылки в блоке 'Бюджетный кодекс' не отображаются");
        WebElement searchBox = budgetKodeksBlock.findElement(By.id("widget-search-budget-code-text"));
        TextField textField = getWebElementWrapper(searchBox).getTextField();
        postponedAssertEquals(textField.getText(), "Поиск статей", "'Поиск статей' не отображается");
    }

    @Step("Ввести текст в строку поиска в блоке 'Налоговый кодекс'")
    public void inputTextInSearchBoxOnTaxBlock(String query) {
        WebElement taxBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_tax-code"));
        WebElement searchBox = taxBlock.findElement(By.id("widget-search-tax-code-text"));
        TextField textField = getWebElementWrapper(searchBox).getTextField();
        textField.clearAndType(query);
        searchBox.sendKeys(Keys.ARROW_DOWN);
        setParameter(SearchResultHelper.HINT_TEXT, query);
    }

    @Step("Проверяется наличие блока 'Трудовой кодекс'")
    public void checkLaborBlock() {
        WebElement laborKodeksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_labor-code"));
        WebElement laborKodeksLink = laborKodeksBlock.findElement(By.cssSelector(".link"));
        postponedAssertEquals(laborKodeksLink.getText(), "Трудовой", "Текст заголовка второго блока не верен");
        List<WebElement> laborKodeksTitleList = laborKodeksBlock.findElements(By.cssSelector(".list__item"));
        postponedAssertTrue(laborKodeksTitleList.size() > 0, "Ссылки в блоке 'Трудовой кодекс' не отображаются");
        WebElement searchBox = laborKodeksBlock.findElement(By.id("widget-search-labor-code-text"));
        TextField textField = getWebElementWrapper(searchBox).getTextField();
        postponedAssertEquals(textField.getText(), "Поиск статей", "'Поиск статей' не отображается");
    }

    @Step("Ввести текст в строку поиска в блоке 'Трудовой кодекс'")
    public void inputTextInSearchBoxOnLaborBlock(String query) {
        WebElement laborBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_labor-code"));
        WebElement searchBox = laborBlock.findElement(By.id("widget-search-labor-code-text"));
        TextField textField = getWebElementWrapper(searchBox).getTextField();
        textField.clearAndType(query);
        searchBox.sendKeys(Keys.ARROW_DOWN);
        setParameter(SearchResultHelper.HINT_TEXT, query);
    }

    @Step("Нажать подсказку в блоке 'Трудовой кодекс'")
    public void clickHintOnLaborBlock() {
        WebElement laborBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_labor-code"));
        hookSearchResultVisible();
        WebElement searchResult = findElementByNoThrow(laborBlock, By.cssSelector(".ui-autocomplete"));
        postponedAssertNotNull(searchResult, "Выпадающие поисковые подсказки в блоке 'Трудовой кодекс' не найдены");
        if (searchResult != null) {
            clickHintWithJump(searchResult);
        }
    }

    @Step("Нажать кнопку  поиска в блоке 'Трудовой кодекс'")
    public void clickSearchButtonOnLaborBlock() {
        WebElement legislationBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_labor-code"));
        WebElement searchResult = legislationBlock.findElement(By.cssSelector(".form-field_type_submit"));
        searchResult.click();
    }

    @Step("Нажать кнопку поиска в блоке 'Региональные документы'")
    public void clickSearchButtonOnRegionBlock() {
        WebElement regionBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_region"));
        WebElement searchResult = regionBlock.findElement(By.cssSelector(".form-field_type_submit"));
        searchResult.click();
    }

    @Step("Нажать кнопку  поиска в блоке 'Налоговый кодекс'")
    public void clickSearchButtonOnTaxBlock() {
        WebElement legislationBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_tax-code"));
        WebElement searchResult = legislationBlock.findElement(By.cssSelector(".form-field_type_submit"));
        searchResult.click();
    }

    @Step("Нажать подсказку в блоке 'Налоговый кодекс'")
    public void clickHintOnTaxBlock() {
        WebElement taxBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_tax-code"));
        WebElement searchResult = findElementByNoThrow(taxBlock, By.cssSelector(".ui-autocomplete"));
        postponedAssertNotNull(searchResult, "Выпадающие поисковые подсказки в блоке 'Налоговый кодекс' не найдены");
        if (searchResult != null)
            clickHintWithJump(searchResult);
    }

    @Step("Проверяется наличие блока 'Граждаский кодекс'")
    public void checkCivilBlock() {
        WebElement civilKodeksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_civil-code"));
        WebElement civilKodeksLink = civilKodeksBlock.findElement(By.cssSelector(".link"));
        postponedAssertEquals(civilKodeksLink.getText(), "Гражданский", "Текст заголовка первого блока не верен");
        List<WebElement> civilKodeksTitleList = civilKodeksBlock.findElements(By.cssSelector(".list__item"));
        postponedAssertTrue(civilKodeksTitleList.size() > 0, "Ссылки в блоке 'Граждаский кодекс' не отображаются");
        WebElement searchBox = civilKodeksBlock.findElement(By.id("widget-search-civil-code-text"));
        TextField textField = getWebElementWrapper(searchBox).getTextField();
        postponedAssertEquals(textField.getText(), "Поиск статей", "'Поиск статей' не отображается");
    }

    @Step("Нажать кнопку  поиска в блоке 'Гражданский кодекс'")
    public void clickSearchButtonOnCivilBlock() {
        WebElement legislationBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_civil-code"));
        WebElement searchResult = legislationBlock.findElement(By.cssSelector(".form-field_type_submit"));
        searchResult.click();
    }

    @Step("Нажать подсказку в блоке 'Гражданский кодекс'")
    public void clickHintOnCivilBlock() {
        WebElement civilBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_civil-code"));
        WebElement searchResult = findElementByNoThrow(civilBlock, By.cssSelector(".ui-autocomplete"));
        postponedAssertNotNull(searchResult, "Выпадающие поисковые подсказки в блоке 'Гражданский кодекс' не найдены");
        if (searchResult != null)
            clickHintWithJump(searchResult);
    }

    @Step("Ввести текст в строку поиска в блоке 'Налоговый кодекс'")
    public void inputTextInSearchBoxOnCivilBlock(String query) {
        WebElement civilBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_civil-code"));
        WebElement searchBox = civilBlock.findElement(By.id("widget-search-civil-code-text"));
        TextField textField = getWebElementWrapper(searchBox).getTextField();
        textField.clearAndType(query);
        searchBox.sendKeys(Keys.ARROW_DOWN);
        setParameter(SearchResultHelper.HINT_TEXT, query);
    }

    @Step("Нажать подсказку в блоке 'Важное'")
    public void clickSearchButtonOnLegislationBlock() {
        WebElement legislationBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_legislation"));
        WebElement searchResult = legislationBlock.findElement(By.cssSelector(".form-field_type_submit"));
        searchResult.click();
    }

    @Step("Нажать подсказку в блоке 'Важное'")
    public void clickHintOnLegislationBlock() {
        WebElement legislationBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_legislation"));
        WebElement searchResult = findElementByNoThrow(legislationBlock, By.cssSelector(".ui-autocomplete"));
        postponedAssertNotNull(searchResult, "Выпадающие поисковые подсказки в блоке 'Важное' не найдены");
        if (searchResult != null)
            clickHintWithJump(searchResult);
    }

    @Step("Нажать кнопку поиска в блоке 'Прочие кодексы'")
    public void clickSearchButtonOnOtherKodeksBlock() {
        WebElement otherKodeksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_other-code"));
        WebElement searchResult = otherKodeksBlock.findElement(By.cssSelector(".form-field_type_submit"));
        searchResult.click();
    }

    @Step("Нажать кнопку поиска в блоке 'Судебные решения'")
    public void clickSearchButtonOnJudgmentBlock() {
        WebElement judgmentBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_judgment"));
        WebElement searchResult = judgmentBlock.findElement(By.cssSelector(".form-field_type_submit"));
        searchResult.click();
    }

    @Step("Нажать подсказку в блоке 'Прочие кодексы'")
    public void clickHintOnOtherBlock() {
        WebElement otherBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_other-code"));
        WebElement searchResult = findElementByNoThrow(otherBlock, By.cssSelector(".ui-autocomplete"));
        postponedAssertNotNull(searchResult, "Выпадающие поисковые подсказки в блоке 'Налоговый кодекс' не найдены");
        if (searchResult != null)
            clickHintWithJump(searchResult);
    }

    @Step("Значения фильтра в поиске по реквизитам сбрасываются'")
    public void checkResultTextFiltersOnExtendedFormIsNotVisible() {
        WebElement typeList = findElementByNoThrow(By.xpath("//*[@id='typelist']/li[1]"));
        postponedAssertTrue(typeList.getAttribute("class").contains("selected"), "Первый элемент в списке Вид не подкрашен");
        WebElement lobbyList = findElementByNoThrow(By.xpath("//*[@id='lobbylist']/li[1]"));
        postponedAssertTrue(lobbyList.getAttribute("class").contains("selected"), "Первый элемент в поле Орган не подкрашен");
        WebElement regionList = findElementByNoThrow(By.xpath("//*[@id='regionlist']/li[1]"));
        postponedAssertTrue(regionList.getAttribute("class").contains("selected"), "Первый элемент в поле Регион не подкрашен");
    }
}
