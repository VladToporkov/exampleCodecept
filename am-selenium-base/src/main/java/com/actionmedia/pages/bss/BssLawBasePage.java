package com.actionmedia.pages.bss;

import com.actionmedia.components.widgets.SearchWidgetBlock;
import com.actionmedia.components.widgets.Widget;
import com.actionmedia.components.widgets.lawbase.BudgetWidget;
import com.actionmedia.components.widgets.lawbase.LaborWidget;
import com.actionmedia.components.widgets.lawbase.PopularWidget;
import com.actionmedia.components.widgets.lawbase.TaxWidget;
import com.actionmedia.pages.interfaces.ILawBasePage;
import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.autotest.selenium.elements.TextField;
import com.actionmedia.components.Link;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.helpers.LawBasePageHelper;
import com.actionmedia.pages.helpers.SearchResultHelper;
import com.actionmedia.util.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: n.tyukavkin
 * Date: 11.10.13
 * Time: 9:34
 */
@Component
public class BssLawBasePage extends BssBasePage<BssLawBasePage> implements ILawBasePage {

    @Step("Проверяются элементы на странице 'Правовая база'")
    public BssLawBasePage checkDefaultStateLawBasePage() {
        checkLawBaseTabIsSelected();
        checkSearchBoxPresentOnLawBasePage();
        checkSectionTitleIsPresent();
        checkTaxKodeksBlockIsPresent();
        checkLaborKodeksBlockIsPresent();
        checkOtherKodeksBlockIsPresent();
        checkLegislationBlockIsPresent();
        checkJudgmentBlockIsPresent();
        checkRegionBlockIsPresent();
        checkMainDocsBlockIsPresent();
        checkAllKodeksRubricatorButtonIsPresent();
        checkMyFavoritesRubricatorButtonIsPresent();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Правовая база'")
    public BssLawBasePage checkLawBaseTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.LAW_BASE);
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Правовая база'")
    public BssLawBasePage checkSearchBoxPresentOnLawBasePage() {
        checkSearchBoxIsPresent("Поиск документов");
        return this;
    }

    @Step("Проверяется что заголовок раздела отображается")
    public BssLawBasePage checkSectionTitleIsPresent() {
        getHelper(LawBasePageHelper.class).checkSectionTitleIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Налоговый кодекс' отображается")
    public BssLawBasePage checkTaxKodeksBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkTaxKodeksBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Бюджетный кодекс' отображается")
    public BssLawBasePage checkBudgetKodeksBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkBudgetKodeksBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Трудовой кодекс' отображается")
    public BssLawBasePage checkLaborKodeksBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkLaborKodeksBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Прочие кодексы' отображается")
    public BssLawBasePage checkOtherKodeksBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkOtherKodeksBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Важное' отображается")
    public BssLawBasePage checkLegislationBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkLegislationBlockIsPresent("Важные документы");
        return this;
    }

    @Step("Проверяется что блок 'Важное' отображается")
    public BssLawBasePage checkLegislationBlockIsPresent(String blockName) {
        getHelper(LawBasePageHelper.class).checkLegislationBlockIsPresent(blockName);
        return this;
    }

    @Step("Проверяется что блок 'Судебные решения' отображается")
    public BssLawBasePage checkJudgmentBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkJudgmentBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'В регионе' отображается")
    public BssLawBasePage checkRegionBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkRegionBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Главные документы' отображается")
    public BssLawBasePage checkMainDocsBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkMainDocsBlockIsPresent();
        return this;
    }

    @Step("Проверяется кнопка рубрикатора кодексов на странице 'Правовая База'")
    public BssLawBasePage checkAllKodeksRubricatorButtonIsPresent() {
        WebElement rubricatorButton = waitForPresenceOfElementLocatedBy(By.id("rubricator-btn"), "Кнопка Все кодексы Отсутствует");
        postponedAssertEquals(rubricatorButton.getText(), "Все кодексы и ПБУ", "Неправильный текст кнопки Все кодексы");
        return this;
    }

    @Step("Проверяется кнопка рубрикатора кодексов на странице 'Правовая База'")
    public BssLawBasePage checkAllKodeksBudgetRubricatorButtonIsPresent() {
        getHelper(LawBasePageHelper.class).checkAllKodexRubricatorButtonIsPresent();
        return this;
    }

    @Step("Проверяется работа скролаа в блоке Новое")
    public BssLawBasePage checkNewsBlockScrolling() {
        List<WebElement> newsBeforeScroll = mainLeftElement.findElements(By.cssSelector(".block-changes"));

        scroll(Period.month, By.tagName("h2"), 2);

        List<WebElement> newsAfterScroll = mainLeftElement.findElements(By.cssSelector(".block-changes"));
        postponedAssertTrue(newsAfterScroll.size() > newsBeforeScroll.size(), "Новости не подгружаются после скролла");
        return this;
    }

    @Step("Проверяется сортировка новостей по дате(от новых к старым)")
    public BssLawBasePage checkDateAreSortedDescending() {
        List<WebElement> dateListElement = mainLeftElement.findElements(By.tagName("h2"));
        dateListElement.remove(0);
        dateListElement.remove(0);
        postponedAssertThat(dateListElement, TestUtils.sortedDatesWithoutYearInDescendingOrder(), "Элементы отсортированы в неправильном порядке");
        return this;
    }

    @Step("Проверяется что новости не повторяются")
    public BssLawBasePage checkNewsBlockAreNotRepeat() {
        List<WebElement> dateListElement = mainLeftElement.findElements(By.tagName("*"));
        Map<String, List<String>> newsBlockMap = new HashMap<String, List<String>>();
        for (int i = 0; i < dateListElement.size(); i++) {
            if ("h2".equals(dateListElement.get(i).getTagName())) {
                String dateString = dateListElement.get(i).getText();
                if (dateString.contains("Популярные") || dateString.contains("В вашем регионе")) {
                    continue;
                }
                List<String> newsBlockForDate = new ArrayList<String>();
                while (i + 1 < dateListElement.size() && !"h2".equals(dateListElement.get(i + 1).getTagName())) {
                    WebElement newsElement = dateListElement.get(i);
                    if (newsElement.getAttribute("class") != null && newsElement.getAttribute("class").contains("block-changes")) {
                        newsBlockForDate.add(newsElement.getText());
                    }
                    i++;
                }
                postponedAssertFalse(newsBlockMap.containsValue(newsBlockForDate), "Блок новостей за '" + dateString + "' повторяется");
                newsBlockMap.put(dateString, newsBlockForDate);
            }
        }
        return this;
    }

    @Step("Проверяется работа ссылок из блока Кодексы")
    public BssLawBasePage checkLinksFromKodeksBlock() {
        WebElement kodeksFrame = waitForVisibilityOfElementLocatedBy(By.cssSelector(".law-base"), "Блок Кодексы не найден");
        List<WebElement> kodeksList = kodeksFrame.findElements(By.tagName("li"));
        kodeksList.remove(kodeksList.size() - 1);
        List<WebElement> randomKodeksList = getRandomElementsInList(kodeksList, 3);
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement kodeksElement : randomKodeksList) {
            WebElement kodeksLink = kodeksElement.findElement(By.tagName("a"));
            String url = kodeksLink.getAttribute("href");
            String header;

            if (kodeksLink.getAttribute("title") != null) {
                header = kodeksLink.getAttribute("title");
            } else {
                header = kodeksLink.getText();
            }

            Link link = new Link(url, header);
            linkList.add(link);
        }
        checkLinks(linkList);
        return this;
    }

    @Step("Проверяется работа ссылок из блока Популярное")
    public BssLawBasePage checkLinksFromPopularBlock() {
        WebElement popularBlock = waitForVisibilityOfElementLocatedBy(By.id("popular"), "Блок 'Попурное' не найден");
        List<WebElement> newsList = popularBlock.findElements(By.cssSelector(".npd"));
        List<WebElement> randomNewsList = getRandomElementsInList(newsList, 3);
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement kodeksElement : randomNewsList) {
            String url = kodeksElement.getAttribute("href");
            String header = kodeksElement.getText();
            Link link = new Link(url, header);
            linkList.add(link);
        }
        checkLinks(linkList);
        return this;
    }

    @Step("Проверяется работа ссылок из блока Новое")
    public BssLawBasePage checkLinksFromNewsBlock() {
        List<WebElement> newsList = mainLeftElement.findElements(By.cssSelector(".block-changes"));
        List<WebElement> randomNewsList = getRandomElementsInList(newsList, 3);
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement kodeksElement : randomNewsList) {
            WebElement kodeksLink = kodeksElement.findElement(By.tagName("a"));
            String url = kodeksLink.getAttribute("href");
            String header = kodeksLink.getText();
            Link link = new Link(url, header);
            linkList.add(link);
        }
        checkLinks(linkList);
        return this;
    }

    @Step("Проверяется начальное состояние формы расширенного поиска")
    public BssLawBasePage checkExtendedForm() {
        WebElement header = waitForVisibilityOfElementLocatedBy(By.id("header"), "Header не найден");
        WebElement extendedForm = findElementByNoThrow(header, By.id("search-form-extended"));
        assertNotNull(extendedForm, "Форма расширенного поиска не найдена");
        postponedAssertTrue(extendedForm.isEnabled() && extendedForm.isDisplayed(), "Форма расширенного поиска не отображается");

        WebElement numberField = findElementByNoThrow(extendedForm, By.id("sd-num"));
        assertNotNull(numberField, "Поле Номер документа не найдено в форме расширенного поиска");
        postponedAssertTrue(numberField.isEnabled() && numberField.isDisplayed(), "Поле Номер документа не отображается в форме расширенного поиска");

        WebElement dateField = findElementByNoThrow(extendedForm, By.cssSelector(".dates"));
        assertNotNull(dateField, "Поле Дата не найдено в форме расширенного поиска");
        postponedAssertTrue(dateField.isEnabled() && dateField.isDisplayed(), "Поле Дата не отображается в форме расширенного поиска");

        WebElement viewField = findElementByNoThrow(extendedForm, By.id("input-type"));
        assertNotNull(viewField, "Поле Вид документа не найдено в форме расширенного поиска");
        postponedAssertTrue(viewField.isEnabled() && viewField.isDisplayed(), "Поле Вид документа не отображается в форме расширенного поиска");
        WebElement viewList = findElementByNoThrow(extendedForm, By.id("typelist"));
        assertNotNull(viewList, "Список Вид документа не найден в форме расширенного поиска");
        postponedAssertTrue(viewList.isEnabled() && viewList.isDisplayed(), "Список Вид документа не отображается в форме расширенного поиска");
        postponedAssertFalse(viewList.findElements(By.tagName("li")).isEmpty(), "Список Вид документа в форме расширенного поиска пустой");

        WebElement departmentField = findElementByNoThrow(extendedForm, By.id("input-lobby"));
        assertNotNull(departmentField, "Поле Орган не найдено в форме расширенного поиска");
        postponedAssertTrue(departmentField.isEnabled() && departmentField.isDisplayed(), "Поле Орган не отображается в форме расширенного поиска");
        WebElement departmentList = findElementByNoThrow(extendedForm, By.id("lobbylist"));
        assertNotNull(departmentList, "Список Органы не найден в форме расширенного поиска");
        postponedAssertTrue(departmentList.isEnabled() && departmentList.isDisplayed(), "Список Органы не отображается в форме расширенного поиска");
        postponedAssertFalse(departmentList.findElements(By.tagName("li")).isEmpty(), "Список Органы в форме расширенного поиска пустой");

        WebElement regionField = findElementByNoThrow(extendedForm, By.id("input-region"));
        assertNotNull(regionField, "Поле Регион не найдено в форме расширенного поиска");
        postponedAssertTrue(regionField.isEnabled() && regionField.isDisplayed(), "Поле Регион не отображается в форме расширенного поиска");
        WebElement regionList = findElementByNoThrow(extendedForm, By.id("regionlist"));
        assertNotNull(regionList, "Список Регионов не найден в форме расширенного поиска");
        postponedAssertTrue(regionList.isEnabled() && regionList.isDisplayed(), "Список Регионов не отображается в форме расширенного поиска");
        postponedAssertFalse(regionList.findElements(By.tagName("li")).isEmpty(), "Список Регионов в форме расширенного поиска пустой");
        return this;
    }

    @Step("Проверяется что кнопка Найти отображется в форме расширенного поиска")
    public BssLawBasePage checkSearchButtonInExtendedFormIsPresent() {
        WebElement extendedForm = waitForVisibilityOfElementLocatedBy(By.id("search-form-extended"), "Форма расширенного поиска не найден");
        WebElement searchButton = findElementByNoThrow(extendedForm, By.id("button-search-extended"));
        assertNotNull(searchButton, "Кнопка Найти в форме расширенного поиска не найдена");
        postponedAssertTrue(searchButton.isEnabled() && searchButton.isDisplayed(), "Кнопка Найти в форме расширенного поиска не отображается");
        return this;
    }

    @Step("Проверяется что кнопка Найти в форме расширенного поиска не активна")
    public BssLawBasePage checkSearchExtendedButtonIsDisabled() {
        WebElement searchButton = waitForVisibilityOfElementLocatedBy(By.id("button-search-extended"), "Кнопка 'Найти' в форме расширенного поиска не найдена");
        postponedAssertTrue(searchButton.getAttribute("class") != null && "disabled".equals(searchButton.getAttribute("class")), "Кнопка Найти в форме расширенного поиска активна");
        return this;
    }

    @Step("Проверяется что кнопка Найти в форме расширенного поиска активна")
    public BssLawBasePage checkSearchExtendedButtonIsEnabled() {
        WebElement searchButton = waitForVisibilityOfElementLocatedBy(By.id("button-search-extended"), "Кнопка 'Найти' в форме расширенного поиска не найдена");
        postponedAssertTrue(searchButton.getAttribute("class") != null && searchButton.getAttribute("class").isEmpty(), "Кнопка Найти в форме расширенного поиска не активна");
        return this;
    }

    @Step("Открыть случайный кодекс со страницы 'Правовая база'")
    public BssDocumentPage clickRandomKodeksLink() {
        List<WebElement> allKodeksList = mainLeftElement.findElements(By.cssSelector("[class*='law-codex-']"));
        List<WebElement> kodeksList = new ArrayList<WebElement>();
        for (WebElement kodeks : allKodeksList) {
            if (!kodeks.getAttribute("class").contains("sections")) {
                kodeksList.add(kodeks);
            }
        }
        WebElement randomKodeks = getRandomElementInList(kodeksList);
        List<WebElement> kodeksLinks = randomKodeks.findElements(By.tagName("a"));
        WebElement randomKodeksLink = kodeksLinks.get(0);
        String url = randomKodeksLink.getAttribute("href");
        setParameter(DOCUMENT_URL, url);
        randomKodeksLink.click();
        return redirectTo(BssDocumentPage.class);
    }

    @Step("Открыть случайную часть кодекса со страницы 'Правовая база'")
    public BssDocumentPage clickRandomKodeksPartLink() {
        List<WebElement> partLinks = mainLeftElement.findElements(By.cssSelector(".law-codex-sections__text"));
        WebElement randomKodeksPartLink = getRandomElementInList(partLinks);
        String url = randomKodeksPartLink.getAttribute("href");
        setParameter(DOCUMENT_URL, url);
        randomKodeksPartLink.click();
        return redirectTo(BssDocumentPage.class);
    }

    @Step("Открыть случайный дополнительный документ со страницы 'Правовая база'")
    public BssDocumentPage clickRandomAdditionalDocumentLink() {
        List<WebElement> addDocsList = mainLeftElement.findElements(By.cssSelector("[class*='law-blank']"));
        WebElement randomAddDocLink = getRandomElementInList(addDocsList);
        WebElement addDocLink = randomAddDocLink.findElement(By.tagName("a"));
        String url = addDocLink.getAttribute("href");
        setParameter(DOCUMENT_URL, url);
        addDocLink.click();
        return redirectTo(BssDocumentPage.class);
    }

    @Step("Открыть случайный документ из блока 'Популярное' со страницы 'Правовая база'")
    public BssDocumentPage clickRandomPopularDocumentLink() {
        List<WebElement> elementsInPopularBlock = mainLeftElement.findElements(By.cssSelector(".document-chain-column"));
        WebElement popularBlock = elementsInPopularBlock.get(0);
        List<WebElement> links = popularBlock.findElements(DOCUMENT_LOCATOR);
        WebElement popularDocLink = getRandomElementInList(links);
        String url = popularDocLink.getAttribute("href");
        setParameter(DOCUMENT_URL, url);
        popularDocLink.click();
        return redirectTo(BssDocumentPage.class);
    }

    @Step("Открыть случайный документ из блока 'В вашем регионе' со страницы 'Правовая база'")
    public BssDocumentPage clickRandomDocumentFromRegionBlockLink() {
        List<WebElement> elementsInPopularBlock = mainLeftElement.findElements(By.cssSelector(".document-chain-column"));
        WebElement regionBlock = elementsInPopularBlock.get(1);
        List<WebElement> links = regionBlock.findElements(DOCUMENT_LOCATOR);
        WebElement regionDcLink = getRandomElementInList(links);
        String url = regionDcLink.getAttribute("href");
        setParameter(DOCUMENT_URL, url);
        regionDcLink.click();
        return redirectTo(BssDocumentPage.class);
    }

    @Step("Открыть случайный документ из блока 'Новое' со страницы 'Правовая база'")
    public BssDocumentPage clickRandomNewDocumentLink() {
        List<WebElement> newBlockList = mainLeftElement.findElements(By.cssSelector(".block-changes"));
        List<WebElement> newDocumentLinkList = new ArrayList<WebElement>();
        for (WebElement newBlock : newBlockList) {
            List<WebElement> links = newBlock.findElements(DOCUMENT_LOCATOR);
            newDocumentLinkList.addAll(links);
        }
        WebElement newDocLink = getRandomElementInList(newDocumentLinkList);
        String url = newDocLink.getAttribute("href");
        setParameter(DOCUMENT_URL, url);
        newDocLink.click();
        return redirectTo(BssDocumentPage.class);
    }

    @Step("Кликнуть по ссылке 'найти другие документы'")
    public BssLawBasePage clickSearchOtherDocumentsLink() {
        WebElement searchOtherDocsLink = mainLeftElement.findElement(By.id("extendedSearchOpen"));
        searchOtherDocsLink.click();
        return this;
    }

    @Step("Кликнуть по ссылке 'найти другие документы'")
    public BssProfilePage clickChangeRegionLink() {
        WebElement changeRegionLink = mainLeftElement.findElement(By.cssSelector("[href*='/#/customer/geo/']"));
        changeRegionLink.click();
        return redirectTo(BssProfilePage.class);
    }

    @Step("Проверяется отбражение ссылок блока 'Прочие кодексы'")
    public BssLawBasePage checkOtherKodeksBlockLinksDisplayed() {
        getHelper(LawBasePageHelper.class).checkOtherKodeksBlockLinksDisplayed();
        return this;
    }

    @Step("Проверяется работа ссылок блока 'Прочие кодексы'")
    public BssLawBasePage checkOtherKodeksBlockLinks() {
        getHelper(LawBasePageHelper.class).checkOtherKodeksBlockLinks();
        return this;
    }

    @Step("Ввести текст в строку поиска в блоке 'Прочие кодексы'")
    public BssLawBasePage inputTextInSearchBoxOnOtherKodeksBlock(String text) {
        getHelper(LawBasePageHelper.class).inputTextInSearchBoxOnOtherKodeksBlock(text);
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются в блоке 'Прочие кодексы'")
    public BssLawBasePage checkHintsIsPresentOnOtherKodeksBlock() {
        getHelper(LawBasePageHelper.class).checkHintsIsPresentOnOtherKodeksBlock();
        return this;
    }

    @Step("Проверить подсказку в блоке 'Прочие Кодексы'")
    public BssLawBasePage checkHintOnOtherKodeksBlock() {
        getHelper(LawBasePageHelper.class).checkHintOnOtherKodeksBlock();
        return this;
    }

    @Step("Проверяется поисковая строка 'Поиск статей'")
    public BssLawBasePage checkSearchBoxPresentOtherCode() {
        getHelper(LawBasePageHelper.class).checkSearchBoxIsPresentOtherCode("Поиск статей");
        return this;
    }

    @Step("Проверяется отображение ссылок блока 'Судебные решения'")
    public BssLawBasePage checkJudgmentBlockLinksDisplayed() {
        getHelper(LawBasePageHelper.class).checkJudgmentKodeksBlockLinksDisplayed();
        return this;
    }

    @Step("Проверяется работа ссылок блока 'Судебные решения'")
    public BssLawBasePage checkJudgmentBlockLinks() {
        getHelper(LawBasePageHelper.class).checkJudgmentKodeksBlockLinks();
        return this;
    }

    @Step("Проверяется работа ссылок блока 'Судебные решения'")
    public BssLawBasePage checkJudgmentKodeksBlockLinksAreWorked() {
        getHelper(LawBasePageHelper.class).checkJudgmentKodeksBlockLinksAreWorked();
        return this;
    }

    @Step("Проверяется поисковая строка 'Поиск дел'")
    public BssLawBasePage checkSearchBoxPresentJudgementCode() {
        getHelper(LawBasePageHelper.class).checkSearchBoxIsPresentJudgmentBlock("Поиск дел");
        return this;
    }

    @Step("Ввести текст в строку поиска в блоке 'Судебные решения'")
    public BssLawBasePage inputTextInSearchBoxOnJudgmentBlock(String query) {
        getHelper(LawBasePageHelper.class).inputTextInSearchBoxOnJudgmentBlock(query);
        return this;
    }

    @Step("Проверяется что поисковые подсказки не отображаются в блоке 'Судебные решения'")
    public BssLawBasePage checkHintsIsNotPresentOnJudgmentBlock() {
        getHelper(LawBasePageHelper.class).checkHintsIsNotPresentOnJudgmentBlock();
        return this;
    }

    @Step("Нажать кнопку поиска в блоке 'Судебные решения'")
    public BssSearchResultPage clickSearchButtonOnJudgmentBlock() {
        getHelper(LawBasePageHelper.class).clickSearchButtonOnJudgmentBlock();
        return redirectTo(BssSearchResultPage.class);
    }

    @Step("Нажать кнопку поиска в блоке 'Прочие кодексы'")
    public BssSearchResultPage clickSearchButtonOnOtherKodeksBlock() {
        getHelper(LawBasePageHelper.class).clickSearchButtonOnOtherKodeksBlock();
        return redirectTo(BssSearchResultPage.class);
    }

    @Step("Проверяется отображение ссылок блока 'Важное'")
    public BssLawBasePage checkLegislationBlockLinksDisplayed() {
        getHelper(LawBasePageHelper.class).checkLegislationBlockLinksDisplayed();
        return this;
    }

    @Step("Проверяется работа ссылок блока 'Важное'")
    public BssLawBasePage checkLegislationBlockLinks() {
        getHelper(LawBasePageHelper.class).checkLegislationBlockLinks();
        return this;
    }

    @Step("Проверяется поисковая строка блока 'Важное'")
    public BssLawBasePage checkSearchBoxPresentLegislation(String input) {
        getHelper(LawBasePageHelper.class).checkSearchBoxIsPresentLegislation(input);
        return this;
    }

    @Step("Ввести текст в строку поиска в блоке 'Важное'")
    public BssLawBasePage inputTextInSearchBoxOnLegislationBlock(String query) {
        getHelper(LawBasePageHelper.class).inputTextInSearchBoxOnLegislationBlock(query);
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются в блоке 'Важное'")
    public BssLawBasePage checkHintsIsPresentOnLegislationBlock() {
        getHelper(LawBasePageHelper.class).checkHintsIsPresentOnLegislationBlock();
        return this;
    }

    @Step("Нажать подсказку в блоке 'Важное'")
    public BssSearchResultPage clickHintOnLegislationBlock() {
        getHelper(LawBasePageHelper.class).clickHintOnLegislationBlock();
        return redirectTo(BssSearchResultPage.class);
    }

    public void clickHintWithJump(WebElement searchResult) {
        getHelper(LawBasePageHelper.class).clickHintWithJump(searchResult);
    }


    @Step("Нажать подсказку в блоке 'Важное'")
    public BssSearchResultPage clickSearchButtonOnLegislationBlock() {
        getHelper(LawBasePageHelper.class).clickSearchButtonOnLegislationBlock();
        return redirectTo(BssSearchResultPage.class);
    }

    @Step("Проверяется что блок 'Налоговый кодекс' изменяется при изменении размера окна")
    public BssLawBasePage checkTaxKodeksBlockResize(int widthTrue) {
        getHelper(LawBasePageHelper.class).checkTaxKodeksBlockResize(widthTrue);
        return this;
    }

    @Step("Проверяется что блок 'Налоговый кодекс' не конфликтует с другими блоками при изменении размера окна")
    public BssLawBasePage checkBlockConflict() {
        getHelper(LawBasePageHelper.class).checkConflictDisplayBlock();
        return this;
    }

    @Step("Ввести текст в строку поиска в блоке 'Налоговый кодекс'")
    public BssLawBasePage inputTextInSearchBoxOnTaxBlock(String query) {
        getHelper(LawBasePageHelper.class).inputTextInSearchBoxOnTaxBlock(query);
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются в блоке 'Налоговый кодекс'")
    public BssLawBasePage checkHintsIsPresentOnTaxKodeksBlock() {
        getHelper(LawBasePageHelper.class).checkHintsIsPresentOnTaxKodeksBlock();
        return this;
    }

    @Step("Проверяется что поисковые подсказки не отображаются в блоке 'Налоговый кодекс'")
    public BssLawBasePage checkHintsIsNotPresentOnTaxKodeksBlock() {
        getHelper(LawBasePageHelper.class).checkHintsIsNotPresentOnTaxKodeksBlock();
        return this;
    }

    @Step("Нажать подсказку в блоке 'Налоговый кодекс'")
    public BssSearchResultPage clickHintOnTaxBlock() {
        getHelper(LawBasePageHelper.class).clickHintOnTaxBlock();
        return redirectTo(BssSearchResultPage.class);
    }

    @Step("Нажать кнопку  поиска в блоке 'Налоговый кодекс'")
    public BssSearchResultPage clickSearchButtonOnTaxBlock() {
        getHelper(LawBasePageHelper.class).clickSearchButtonOnTaxBlock();
        return redirectTo(BssSearchResultPage.class);
    }

    @Step("Проверяется работа ссылок блока 'Налоговый кодекс'")
    public BssLawBasePage checkTaxKodeksBlockLinks() {
        getHelper(LawBasePageHelper.class).checkTaxKodeksBlockLinks();
        return this;
    }

    @Step("Проверяется что блок 'Бюджетный кодекс' изменяется при изменении размера окна")
    public BssLawBasePage checkBudgetKodeksBlockResize(int widthTrue) {
        getHelper(LawBasePageHelper.class).checkBudgetKodeksBlockResize(widthTrue);
        return this;
    }

    @Step("Проверяется что блок 'Бюджетный' не конфликтует с другими блоками при изменении размера окна")
    public BssLawBasePage checkBudgetKodeksBlockСonflict() {
        getHelper(LawBasePageHelper.class).checkConflictDisplayBlock();
        return this;
    }

    @Step("Ввести текст в строку поиска в блоке 'Бюджетный кодекс'")
    public BssLawBasePage inputTextInSearchBoxOnBudgetBlock(String query) {
        WebElement budgetBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_budget-code"));
        WebElement searchBox = budgetBlock.findElement(By.id("widget-search-budget-code-text"));
        TextField textField = getWebElementWrapper(searchBox).getTextField();
        textField.clearAndType(query);
        searchBox.sendKeys(Keys.ARROW_DOWN);
        setParameter(SearchResultHelper.HINT_TEXT, query);
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются в блоке 'Бюджетный кодекс'")
    public BssLawBasePage checkHintsIsPresentOnBudgetKodeksBlock() {
        getHelper(LawBasePageHelper.class).checkHintsIsPresentOnBudgetKodeksBlock();
        return this;
    }

    @Step("Проверяется что поисковые подсказки не отображаются в блоке 'Бюджетный кодекс'")
    public BssLawBasePage checkHintsIsNotPresentOnBudgetKodeksBlock() {
        getHelper(LawBasePageHelper.class).checkHintsIsNotPresentOnBudgetKodeksBlock();
        return this;
    }

    @Step("Нажать подсказку в блоке 'Бюджетный кодекс'")
    public BssSearchResultPage clickHintOnBudgetBlock() {
        WebElement budgetBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_budget-code"));
        WebElement searchResult = findElementByNoThrow(budgetBlock, By.cssSelector(".ui-autocomplete"));
        postponedAssertNotNull(searchResult, "Выпадающие поисковые подсказки в блоке 'Бюджетный кодекс' не найдены");
        if (searchResult != null) {
            clickHintWithJump(searchResult);
        }
        return redirectTo(BssSearchResultPage.class);
    }

    @Step("Нажать кнопку  поиска в блоке 'Бюджетный кодекс'")
    public BssSearchResultPage clickSearchButtonOnBudgetBlock() {
        WebElement legislationBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_budget-code"));
        WebElement searchResult = legislationBlock.findElement(By.cssSelector(".form-field_type_submit"));
        searchResult.click();
        return redirectTo(BssSearchResultPage.class);
    }

    @Step("Проверяется работа ссылок блока 'Бюджетный кодекс'")
    public BssLawBasePage checkBudgetKodeksBlockLinks() {
        getHelper(LawBasePageHelper.class).checkBudgetKodeksBlockLinks();
        return this;
    }

    @Step("Проверяется наличие блока 'Бюджетный кодекс'")
    public BssLawBasePage checkBudgetBlock() {
        getHelper(LawBasePageHelper.class).checkBudgetBlock();
        return this;
    }

    @Step("Проверяется наличие блока 'Налоговый кодекс'")
    public BssLawBasePage checkTaxBlock() {
        getHelper(LawBasePageHelper.class).checkTaxBlock();
        return this;
    }

    @Step("Проверяется работа ссылок блока 'Главные документы'")
    public BssLawBasePage checkMainDocsBlockLinks() {
        getHelper(LawBasePageHelper.class).checkMainDocsBlockLinks();
        return this;
    }

    @Step("Проверяются секции блока 'Главные документы'")
    public BssLawBasePage checkMainDocsBlockSections() {
        getHelper(LawBasePageHelper.class).checkMainDocsBlockSections();
        return this;
    }

    @Step("Открыть страницу газеты")
    public BssNewsPage clickNewsPaperHeaderLink() {
        waitForPresenceOfElementLocatedBy(By.cssSelector(".news__title")).findElement(By.tagName("a")).click();
        return redirectTo(BssNewsPage.class);
    }

    @Step("Проверяется что ссылка 'Изменить регион' отображается")
    public BssLawBasePage checkChangeRegionLinkIsPresent() {
        getHelper(LawBasePageHelper.class).checkChangeRegionLinkIsPresent();
        return this;
    }

    @Step("Проверяется работа ссылок блока 'Региональные документы'")
    public BssLawBasePage checkRegionBlockLinks() {
        getHelper(LawBasePageHelper.class).checkRegionBlockLinks();
        return this;
    }

    @Step("Проверяется поисковая строка 'Поиск региональных документов'")
    public BssLawBasePage checkSearchBoxIsPresentRegionBlock() {
        getHelper(LawBasePageHelper.class).checkSearchBoxIsPresentRegionBlock("Поиск региональных документов");
        return this;
    }

    @Step("Ввести текст в строку поиска в блоке 'Региональные документы'")
    public BssLawBasePage inputTextInSearchBoxOnRegionBlock(String query) {
        getHelper(LawBasePageHelper.class).inputTextInSearchBoxOnRegionBlock(query);
        return this;
    }

    @Step("Нажать кнопку поиска в блоке 'Региональные документы'")
    public BssSearchResultPage clickSearchButtonOnRegionBlock() {
        getHelper(LawBasePageHelper.class).clickSearchButtonOnRegionBlock();
        return redirectTo(BssSearchResultPage.class);
    }

    @Step("Кликнуть на ссылку 'Изменить регион'")
    public BssProfilePage clickLinkChangeRegion() {
        getHelper(LawBasePageHelper.class).clickLinkChangeRegion();
        return redirectTo(BssProfilePage.class);
    }

    @Step("Проверяем клик на ссылку 'Изменить регион'")
    public BssLawBasePage checkCurrentUrlContainsDocumentUrl() {
        getHelper(LawBasePageHelper.class).checkCurrentUrlContainsDocumentUrl("/#/customer/geo/");
        return this;
    }

    @Step("Проверяются заголовок блока 'Главное в регионе'")
    public BssLawBasePage checkTitleChangeRegion(String region) {
        getHelper(LawBasePageHelper.class).checkTitleChangeRegion(region);
        return this;
    }

    @Step("Проверяется размер блока 'Трудовой кодекс'")
    public BssLawBasePage checkLaborKodeksBlockResize(int widthTrue) {
        getHelper(LawBasePageHelper.class).checkLaborKodeksBlockResize(widthTrue);
        return this;
    }

    @Step("Проверяется наличие блока 'Трудовой кодекс'")
    public BssLawBasePage checkLaborBlock() {
        getHelper(LawBasePageHelper.class).checkLaborBlock();
        return this;
    }

    @Step("Ввести текст в строку поиска в блоке 'Трудовой кодекс'")
    public BssLawBasePage inputTextInSearchBoxOnLaborBlock(String query) {
        getHelper(LawBasePageHelper.class).inputTextInSearchBoxOnLaborBlock(query);
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются в блоке 'Трудовой кодекс'")
    public BssLawBasePage checkHintsIsPresentOnLaborBlock() {
        getHelper(LawBasePageHelper.class).checkHintsIsPresentOnLaborBlock();
        return this;
    }

    @Step("Нажать подсказку в блоке 'Трудовой кодекс'")
    public BssSearchResultPage clickHintOnLaborBlock() {
        getHelper(LawBasePageHelper.class).clickHintOnLaborBlock();
        return redirectTo(BssSearchResultPage.class);
    }

    @Step("Нажать кнопку  поиска в блоке 'Трудовой кодекс'")
    public BssSearchResultPage clickSearchButtonOnLaborBlock() {
        getHelper(LawBasePageHelper.class).clickSearchButtonOnLaborBlock();
        return redirectTo(BssSearchResultPage.class);
    }

    @Step("Проверяется что поисковые подсказки не отображаются в блоке 'Трудовой кодекс'")
    public BssLawBasePage checkHintsIsNotPresentOnLaborKodeksBlock() {
        getHelper(LawBasePageHelper.class).checkHintsIsNotPresentOnLaborKodeksBlock();
        return this;
    }

    @Step("Проверяется работа ссылок блока 'Трудовой кодекс'")
    public BssLawBasePage checkLaborKodeksBlockLinks() {
        getHelper(LawBasePageHelper.class).checkLaborKodeksBlockLinks();
        return this;
    }

    @Step("Нажать подсказку в блоке 'Налоговый кодекс'")
    public BssSearchResultPage clickHintOnOtherBlock() {
        getHelper(LawBasePageHelper.class).clickHintOnOtherBlock();
        return redirectTo(BssSearchResultPage.class);
    }

    public BssLawBasePage setExtended(String type, String city) {
        getHelper(SearchResultHelper.class).setExtended(type, null, city);
        return redirectTo(BssLawBasePage.class);
    }

    public BssLawBasePage setExtended(String type, String lobby, String region) {
        getHelper(SearchResultHelper.class).setExtended(type, lobby, region);
        return this;
    }

    public BssSearchResultPage clickOnButtonSearchOnExtendedForm() {
        getHelper(SearchResultHelper.class).clickOnButtonSearchOnExtendedForm();
        return redirectTo(BssSearchResultPage.class);
    }

    public BssLawBasePage checkResultTextFiltersOnExtendedFormIsNotVisible() {
        getHelper(LawBasePageHelper.class).checkResultTextFiltersOnExtendedFormIsNotVisible();
        return this;
    }

    public BssLawBasePage checkMainLawBasePageIsOpened() {
        getHelper(SearchResultHelper.class).checkMainLawBasePageIsOpened();
        return this;
    }

    public BssLawBasePage checkTaxWidgetIsPresent() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkWidgetIsPresent(widget, "Налоговый");
        return this;
    }

    public BssLawBasePage checkTaxWidgetTitleIsPresent() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkTitleIsLink(widget);
        return this;
    }

    public BssLawBasePage checkTaxWidgetLinksArePresent() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkLinksArePresent(widget);
        return this;
    }

    public BssLawBasePage checkTaxWidgetBlockResized() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkBlockSizeIsChanged(widget);
        return this;
    }

    public BssLawBasePage checkTaxWidgetBlockIsNotChanged() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkBlockSizeIsNotChanged(widget);
        return this;
    }

    public BssLawBasePage checkTaxWidgetHasSixLinks() {
        getHelper(TaxWidget.class).checkWidgetHasSixLinks();
        return this;
    }

    public BssLawBasePage checkTaxWidgetHasTwoLinks() {
        getHelper(TaxWidget.class).checkWidgetHasTwoLinks();
        return this;
    }

    public BssLawBasePage checkTaxWidgetLinksAreWorked() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkLinksAreWorked(widget);
        return this;
    }

    public BssLawBasePage checkSearchTaxWidgetBlockIsPresent() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchWidgetBlockIsPresent(widget);
        return this;
    }

    public BssLawBasePage checkAllWidgetsDontConflictWithEachOther() {
        getHelper(Widget.class).checkAllWidgetsDontConflictWithEachOther();
        return this;
    }

    public BssLawBasePage checkTaxWidgetSearchInputHasName() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchInputHasName(widget, "Поиск статей");
        return this;
    }

    public BssLawBasePage inputTaxWidgetSearchQuery(String query) {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).inputText(widget, query);
        return this;
    }

    public BssDocumentPage clickOnTaxWidgetButtonEnterIntoSearchBox() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnButtonEnterIntoSearchBox(widget);
        return redirectTo(BssDocumentPage.class);
    }

    public BssLawBasePage checkTaxWidgetSearchResultIsVisible() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsVisible(widget);
        return this;
    }

    public BssLawBasePage checkTaxWidgetSearchResultIsNotVisible() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsNotVisible(widget);
        return this;
    }

    public BssDocumentPage clickOnTaxWidgetRandomSearchResult() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnRandomSearchResult(widget);
        return redirectTo(BssDocumentPage.class);
    }

    public BssLawBasePage checkBudgetWidgetIsPresent() {
        WebElement widget = getHelper(BudgetWidget.class).getWidget();
        getHelper(BudgetWidget.class).checkWidgetIsPresent(widget, "Бюджетный");
        return this;
    }

    public BssLawBasePage checkBudgetWidgetTitleIsPresent() {
        WebElement widget = getHelper(BudgetWidget.class).getWidget();
        getHelper(BudgetWidget.class).checkTitleIsLink(widget);
        return this;
    }

    public BssLawBasePage checkBudgetWidgetLinksArePresent() {
        WebElement widget = getHelper(BudgetWidget.class).getWidget();
        getHelper(BudgetWidget.class).checkLinksArePresent(widget);
        return this;
    }

    public BssLawBasePage checkBudgetWidgetBlockResized() {
        WebElement widget = getHelper(BudgetWidget.class).getWidget();
        getHelper(BudgetWidget.class).checkBlockSizeIsChanged(widget);
        return this;
    }

    public BssLawBasePage checkBudgetWidgetBlockIsNotChanged() {
        WebElement widget = getHelper(BudgetWidget.class).getWidget();
        getHelper(BudgetWidget.class).checkBlockSizeIsNotChanged(widget);
        return this;
    }

    public BssLawBasePage checkBudgetWidgetHasEightLinks() {
        getHelper(BudgetWidget.class).checkWidgetHasEightLinks();
        return this;
    }

    public BssLawBasePage checkBudgetWidgetHasSixLinks() {
        getHelper(BudgetWidget.class).checkWidgetHasSixLinks();
        return this;
    }

    public BssLawBasePage checkBudgetWidgetHasFourLinks() {
        getHelper(BudgetWidget.class).checkWidgetHasFourLinks();
        return this;
    }

    public BssLawBasePage checkBudgetWidgetLinksAreWorked() {
        WebElement widget = getHelper(BudgetWidget.class).getWidget();
        getHelper(BudgetWidget.class).checkLinksAreWorked(widget);
        return this;
    }

    public BssLawBasePage checkSearchBudgetWidgetBlockIsPresent() {
        WebElement widget = getHelper(BudgetWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchWidgetBlockIsPresent(widget);
        return this;
    }

    public BssLawBasePage checkBudgetWidgetSearchInputHasName() {
        WebElement widget = getHelper(BudgetWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchInputHasName(widget, "Поиск статей");
        return this;
    }

    public BssLawBasePage inputBudgetWidgetSearchQuery(String query) {
        WebElement widget = getHelper(BudgetWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).inputText(widget, query);
        return this;
    }

    public BssDocumentPage clickOnBudgetWidgetButtonEnterIntoSearchBox() {
        WebElement widget = getHelper(BudgetWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnButtonEnterIntoSearchBox(widget);
        return redirectTo(BssDocumentPage.class);
    }

    public BssLawBasePage checkBudgetWidgetSearchResultIsVisible() {
        WebElement widget = getHelper(BudgetWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsVisible(widget);
        return this;
    }

    public BssLawBasePage checkBudgetWidgetSearchResultIsNotVisible() {
        WebElement widget = getHelper(BudgetWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsNotVisible(widget);
        return this;
    }

    public BssDocumentPage clickOnBudgetWidgetRandomSearchResult() {
        WebElement widget = getHelper(BudgetWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnRandomSearchResult(widget);
        return redirectTo(BssDocumentPage.class);
    }

    public BssLawBasePage checkLaborWidgetIsPresent() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(LaborWidget.class).checkWidgetIsPresent(widget, "Трудовой");
        return this;
    }

    public BssLawBasePage checkLaborWidgetTitleIsPresent() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(LaborWidget.class).checkTitleIsLink(widget);
        return this;
    }

    public BssLawBasePage checkLaborWidgetLinksArePresent() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(LaborWidget.class).checkLinksArePresent(widget);
        return this;
    }

    public BssLawBasePage checkLaborWidgetBlockResized() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(LaborWidget.class).checkBlockSizeIsChanged(widget);
        return this;
    }

    public BssLawBasePage checkLaborWidgetHasFourLinks() {
        getHelper(LaborWidget.class).checkWidgetHasFourLinks();
        return this;
    }

    public BssLawBasePage checkLaborWidgetLinksAreWorked() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(LaborWidget.class).checkLinksAreWorked(widget);
        return this;
    }

    public BssLawBasePage checkSearchLaborWidgetBlockIsPresent() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchWidgetBlockIsPresent(widget);
        return this;
    }

    public BssLawBasePage checkLaborWidgetSearchInputHasName() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchInputHasName(widget, "Поиск статей");
        return this;
    }

    public BssLawBasePage inputLaborWidgetSearchQuery(String query) {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).inputText(widget, query);
        return this;
    }

    public BssDocumentPage clickOnLaborWidgetButtonEnterIntoSearchBox() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnButtonEnterIntoSearchBox(widget);
        return redirectTo(BssDocumentPage.class);
    }

    public BssLawBasePage checkLaborWidgetSearchResultIsVisible() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsVisible(widget);
        return this;
    }

    public BssLawBasePage checkLaborWidgetSearchResultIsNotVisible() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsNotVisible(widget);
        return this;
    }

    public BssLawBasePage checkLaborWidgetBlockIsNotChanged() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(LaborWidget.class).checkBlockSizeIsNotChanged(widget);
        return this;
    }

    public BssDocumentPage clickOnLaborWidgetRandomSearchResult() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnRandomSearchResult(widget);
        return redirectTo(BssDocumentPage.class);
    }

    public BssLawBasePage checkPopularWidgetIsPresent() {
        WebElement widget = getHelper(PopularWidget.class).getWidget();
        getHelper(PopularWidget.class).checkWidgetIsPresent(widget, "Популярное в");
        return this;
    }

    public BssLawBasePage checkPopularWidgetTitleHasWordPopular() {
        getHelper(PopularWidget.class).checkTitleHasWordPopular();
        return this;
    }

    public BssLawBasePage checkPopularWidgetContainsLinksWithDocuments() {
        getHelper(PopularWidget.class).checkPopularWidgetContainsLinksWithDocuments();
        return this;
    }

    public BssLawBasePage checkPopularWidgetLinkChangeRegionIsDisplayed() {
        getHelper(PopularWidget.class).checkLinkChangeRegionIsDisplayed();
        return this;
    }

    public BssLawBasePage checkPopularWidgetLinkChangeRegionIsNotDisplayed() {
        getHelper(PopularWidget.class).checkLinkChangeRegionIsNotDisplayed();
        return this;
    }

    public BssLawBasePage checkPopularWidgetCheckSearchInputHasName(String name) {
        WebElement widget = getHelper(PopularWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchInputHasName(widget, name);
        return this;
    }
}
