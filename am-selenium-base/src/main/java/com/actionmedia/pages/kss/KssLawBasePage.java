package com.actionmedia.pages.kss;

import com.actionmedia.components.Link;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.components.widgets.SearchWidgetBlock;
import com.actionmedia.components.widgets.Widget;
import com.actionmedia.components.widgets.lawbase.LaborWidget;
import com.actionmedia.components.widgets.lawbase.PopularWidget;
import com.actionmedia.components.widgets.lawbase.ProfstandartsWidget;
import com.actionmedia.pages.helpers.LawBasePageHelper;
import com.actionmedia.pages.helpers.SearchResultHelper;
import com.actionmedia.pages.interfaces.ILawBasePage;
import com.actionmedia.util.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class KssLawBasePage extends KssBasePage<KssLawBasePage> implements ILawBasePage {

    private static final String[] KODEX_NAME_LIST = {
            "Трудовой кодекс Российской Федерации",
            "Гражданский кодекс Российской Федерации",
            "Кодекс Российской Федерации об административных правонарушениях",
            "Налоговый кодекс Российской Федерации",
            "Уголовный кодекс Российской Федерации",
            "Гражданский процессуальный кодекс Российской Федерации",
            "Арбитражный процессуальный кодекс Российской Федерации"};

    private static final String[] BLANK_NAME_LIST = {
            "О типовых формах",
            "О заполнении трудовых книжек",
            "О списках вредных работ",
            "ЕКС должностей",
            "Об оценке условий труда",
            "О профессиях с льготной пенсией"};

    @Step("Проверяются элементы на странице 'Правовая база'")
    public KssLawBasePage checkDefaultStateLawBasePage() {
        checkLawBaseTabIsSelected();
        checkSearchBoxPresentOnLawBasePage();
        checkSectionTitleIsPresent();
        checkLaborKodeksBlockIsPresent();
        checkOtherKodeksBlockIsPresent();
        checkLegislationBlockIsPresent();
        checkJudgmentBlockIsPresent();
        checkRegionBlockIsPresent();
        checkMainDocsBlockIsPresent();
        checkAllKodexRubricatorButtonIsPresent();
        checkMyFavoritesRubricatorButtonIsPresent();
        checkAssistantButtonIsPresent();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Правовая база'")
    public KssLawBasePage checkLawBaseTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.LAW_BASE);
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Правовая база'")
    public KssLawBasePage checkSearchBoxPresentOnLawBasePage() {
        checkSearchBoxIsPresent("Поиск документов");
        return this;
    }

    @Step("Проверяется что заголовок раздела отображается")
    public KssLawBasePage checkSectionTitleIsPresent() {
        getHelper(LawBasePageHelper.class).checkSectionTitleIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Трудовой кодекс' отображается")
    public KssLawBasePage checkLaborKodeksBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkLaborKodeksBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Прочие кодексы' отображается")
    public KssLawBasePage checkOtherKodeksBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkOtherKodeksBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Важное' отображается")
    public KssLawBasePage checkLegislationBlockIsPresent(String blockName) {
        getHelper(LawBasePageHelper.class).checkLegislationBlockIsPresent(blockName);
        return this;
    }

    @Step("Проверяется что блок 'Важное' отображается")
    public KssLawBasePage checkLegislationBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkLegislationBlockIsPresent("Важное");
        return this;
    }

    @Step("Проверяется что блок 'Судебные решения' отображается")
    public KssLawBasePage checkJudgmentBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkJudgmentBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Профстандарты' отображается")
    public KssLawBasePage checkProfStandartsBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkProfStandartsBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Региональные документы' отображается")
    public KssLawBasePage checkRegionBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkRegionBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Трудовые споры' отображается")
    public KssLawBasePage checkLaborDisputesIsPresent() {
        getHelper(LawBasePageHelper.class).checkLaborDisputesIsPresent();
        return this;
    }

    @Step("Проверяется что ссылка 'Изменить регион' отображается")
    public KssLawBasePage checkChangeRegionLinkIsPresent() {
        getHelper(LawBasePageHelper.class).checkChangeRegionLinkIsPresent();
        return this;
    }

    @Step("Проверяется работа ссылок блока 'Региональные документы'")
    public KssLawBasePage checkRegionBlockLinks() {
        getHelper(LawBasePageHelper.class).checkRegionBlockLinks();
        return this;
    }

    @Step("Проверяется поисковая строка 'Поиск региональных документов'")
    public KssLawBasePage checkSearchBoxIsPresentRegionBlock() {
        getHelper(LawBasePageHelper.class).checkSearchBoxIsPresentRegionBlock("Поиск региональных документов");
        return this;
    }

    @Step("Ввести текст в строку поиска в блоке 'Региональные документы'")
    public KssLawBasePage inputTextInSearchBoxOnRegionBlock(String query) {
        getHelper(LawBasePageHelper.class).inputTextInSearchBoxOnRegionBlock(query);
        return this;
    }

    @Step("Нажать кнопку поиска в блоке 'Региональные документы'")
    public KssSearchResultPage clickSearchButtonOnRegionBlock() {
        getHelper(LawBasePageHelper.class).clickSearchButtonOnRegionBlock();
        return redirectTo(KssSearchResultPage.class);
    }

    @Step("Кликнуть на ссылку 'Изменить регион'")
    public KssProfilePage clickLinkChangeRegion() {
        getHelper(LawBasePageHelper.class).clickLinkChangeRegion();
        return redirectTo(KssProfilePage.class);
    }

    @Step("Проверяем клик на ссылку 'Изменить регион'")
    public KssLawBasePage checkCurrentUrlContainsDocumentUrl() {
        getHelper(LawBasePageHelper.class).checkCurrentUrlContainsDocumentUrl("/#/customer/geo/");
        return this;
    }

    @Step("Проверяется что блок 'Главные документы' отображается")
    public KssLawBasePage checkMainDocsBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkMainDocsBlockIsPresent();
        return this;
    }

    @Step("Проверяется отбражение ссылок блока 'Прочие кодексы'")
    public KssLawBasePage checkOtherKodeksBlockLinksDisplayed() {
        getHelper(LawBasePageHelper.class).checkOtherKodeksBlockLinksDisplayed();
        return this;
    }

    @Step("Проверяется работа ссылок блока 'Прочие кодексы'")
    public KssLawBasePage checkOtherKodeksBlockLinks() {
        getHelper(LawBasePageHelper.class).checkOtherKodeksBlockLinks();
        return this;
    }

    @Step("Проверяется отображение ссылок блока 'Судебные решения'")
    public KssLawBasePage checkJudgmentBlockLinksDisplayed() {
        getHelper(LawBasePageHelper.class).checkJudgmentKodeksBlockLinksDisplayed();
        return this;
    }

    @Step("Проверяется работа ссылок блока 'Судебные решения'")
    public KssLawBasePage checkJudgmentBlockLinks() {
        getHelper(LawBasePageHelper.class).checkJudgmentKodeksBlockLinks();
        return this;
    }

    @Step("Проверяется работа ссылок блока 'Судебные решения'")
    public KssLawBasePage checkJudgmentKodeksBlockLinksAreWorked() {
        getHelper(LawBasePageHelper.class).checkJudgmentKodeksBlockLinksAreWorked();
        return this;
    }

    @Step("Ввести текст в строку поиска в блоке 'Судебные решения'")
    public KssLawBasePage inputTextInSearchBoxOnJudgmentBlock(String query) {
        getHelper(LawBasePageHelper.class).inputTextInSearchBoxOnJudgmentBlock(query);
        return this;
    }

    @Step("Проверяется что поисковые подсказки не отображаются в блоке 'Судебные решения'")
    public KssLawBasePage checkHintsIsNotPresentOnJudgmentBlock() {
        getHelper(LawBasePageHelper.class).checkHintsIsNotPresentOnJudgmentBlock();
        return this;
    }

    @Step("Проверяется работа ссылок блока 'Тудовой кодекс'")
    public KssLawBasePage checkLaborKodeksBlockLinks() {
        getHelper(LawBasePageHelper.class).checkLaborKodeksBlockLinks();
        return this;
    }

    @Step("Ввести текст в строку поиска в блоке 'Прочие кодексы'")
    public KssLawBasePage inputTextInSearchBoxOnOtherKodeksBlock(String text) {
        getHelper(LawBasePageHelper.class).inputTextInSearchBoxOnOtherKodeksBlock(text);
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются в блоке 'Прочие кодексы'")
    public KssLawBasePage checkHintsIsPresentOnOtherKodeksBlock() {
        getHelper(LawBasePageHelper.class).checkHintsIsPresentOnOtherKodeksBlock();
        return this;
    }

    @Step("Проверить подсказку в блоке 'Прочие Кодексы'")
    public KssLawBasePage checkHintOnOtherKodeksBlock() {
        getHelper(LawBasePageHelper.class).checkHintOnOtherKodeksBlock();
        return this;
    }

    @Step("Нажать кнопку поиска в блоке 'Прочие кодексы'")
    public KssSearchResultPage clickSearchButtonOnOtherKodeksBlock() {
        getHelper(LawBasePageHelper.class).clickSearchButtonOnOtherKodeksBlock();
        return redirectTo(KssSearchResultPage.class);
    }

    @Step("Проверяется поисковая строка 'Поиск статей'")
    public KssLawBasePage checkSearchBoxPresentOtherCode() {
        getHelper(LawBasePageHelper.class).checkSearchBoxIsPresentOtherCode("Поиск статей");
        return this;
    }

    @Step("Проверяется поисковая строка 'Поиск дел'")
    public KssLawBasePage checkSearchBoxPresentJudgementCode() {
        getHelper(LawBasePageHelper.class).checkSearchBoxIsPresentJudgmentBlock("Поиск дел");
        return this;
    }

    @Step("Нажать кнопку поиска в блоке 'Судебные решения'")
    public KssSearchResultPage clickSearchButtonOnJudgmentBlock() {
        getHelper(LawBasePageHelper.class).clickSearchButtonOnJudgmentBlock();
        return redirectTo(KssSearchResultPage.class);
    }

    @Step("Проверяется поисковая строка блока 'Важное'")
    public KssLawBasePage checkSearchBoxPresentLegislation(String input) {
        getHelper(LawBasePageHelper.class).checkSearchBoxIsPresentLegislation(input);
        return this;
    }

    @Step("Ввести текст в строку поиска в блоке 'Важное'")
    public KssLawBasePage inputTextInSearchBoxOnLegislationBlock(String query) {
        getHelper(LawBasePageHelper.class).inputTextInSearchBoxOnLegislationBlock(query);
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются в блоке 'Важное'")
    public KssLawBasePage checkHintsIsPresentOnLegislationBlock() {
        getHelper(LawBasePageHelper.class).checkHintsIsPresentOnLegislationBlock();
        return this;
    }

    public void clickHintWithJump(WebElement searchResult) {
        getHelper(LawBasePageHelper.class).clickHintWithJump(searchResult);
    }

    @Step("Проверяется кнопка рубрикатора кодексов на странице 'Правовая База'")
    public KssLawBasePage checkAllKodexRubricatorButtonIsPresent() {
        WebElement rubricatorButton = waitForPresenceOfElementLocatedBy(By.id("rubricator-btn"), "Кнопка Все кодексы Отсутствует");
        postponedAssertEquals(rubricatorButton.getText(), "Все кодексы", "Неправильный текст кнопки Все кодексы");
        return this;
    }

    @Step("Проверяется работа скролла в блоке Новое")
    public KssLawBasePage checkNewsBlockScrolling() {
        List<WebElement> newsBeforeScroll = getNewsElements();

        scroll(Period.month, By.tagName("h2"), 2);

        List<WebElement> newsAfterScroll = getNewsElements();
        postponedAssertTrue(newsAfterScroll.size() > newsBeforeScroll.size(), "Новости не подгружаются после скролла");
        return this;
    }

    @Step("Проверяется сортировка новостей по дате(от новых к старым)")
    public KssLawBasePage checkDateAreSortedDescending() {
        List<WebElement> elements = mainLeftElement.findElements(By.tagName("*"));
        List<WebElement> dateListElement = new ArrayList<WebElement>();
        for (WebElement element : elements) {
            if ("h2".equals(element.getTagName())) {
                dateListElement.add(element);
            }
        }

        dateListElement.remove(0);
        dateListElement.remove(0);
        postponedAssertThat(dateListElement, TestUtils.sortedDatesWithoutYearInDescendingOrder(), "Элементы отсортированы в неправильном порядке");
        return this;
    }

    @Step("Проверяется что пустых новостей нет")
    public KssLawBasePage checkNewsAreNotEmpty() {
        List<WebElement> newsList = getNewsElements();
        for (WebElement newsElement : newsList) {
            postponedAssertNotNull(findElementByNoThrow(newsElement, By.tagName("a")), "Отсутствует ссылка для новости за '" + newsList + "'");
            postponedAssertTrue(newsElement.findElement(By.tagName("a")).getAttribute("href").contains("/#/document"), "Неправильный формат ссылки");
            postponedAssertFalse(newsElement.findElement(By.tagName("a")).getText().isEmpty(), "Текст ссылки новости за пустой");
            postponedAssertTrue(newsElement.findElement(By.tagName("a")).isDisplayed(), "Ссылка для новости не отображается");
        }
        return this;
    }

    @Step("Проверяется что новости не повторяются")
    public KssLawBasePage checkNewsBlockAreNotRepeat() {
        List<WebElement> dateListElement = mainLeftElement.findElements(By.tagName("*"));
        Map<String, List<String>> newsBlockMap = new HashMap<String, List<String>>();
        for (int i = 0; i < dateListElement.size(); i++) {
            if ("h2".equals(dateListElement.get(i).getTagName())) {
                String dateString = dateListElement.get(i).getText();
                List<String> newsBlockForDate = new ArrayList<String>();
                while (i + 1 < dateListElement.size() && !"h2".equals(dateListElement.get(i + 1).getTagName())) {
                    WebElement newsElement = dateListElement.get(i);
                    if (newsElement.getAttribute("class") != null && newsElement.getAttribute("class").contains("changes-list")) {
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


    @Step("Проверяется работа ссылок блока Новое")
    public KssLawBasePage checkNewsBlockLinks() {
        List<WebElement> newsTitleList = getNewsElements();
        List<Link> newsStringList = new ArrayList<Link>();
        for (WebElement newsTitleElement : newsTitleList) {
            String url = newsTitleElement.findElement(By.tagName("a")).getAttribute("href");
            String header = newsTitleElement.findElement(By.tagName("a")).getText();
            Link link = new Link(url, header);
            newsStringList.add(link);
        }
        checkLinks(newsStringList);
        return this;
    }

    @Step("Нажать подсказку в блоке 'Важное'")
    public KssSearchResultPage clickHintOnLegislationBlock() {
        getHelper(LawBasePageHelper.class).clickHintOnLegislationBlock();
        return redirectTo(KssSearchResultPage.class);
    }

    @Step("Нажать подсказку в блоке 'Важное'")
    public KssSearchResultPage clickSearchButtonOnLegislationBlock() {
        getHelper(LawBasePageHelper.class).clickSearchButtonOnLegislationBlock();
        return redirectTo(KssSearchResultPage.class);
    }


    @Step("Проверяется что блок Популярное показан")
    public KssLawBasePage checkPopularBlockIsDisplayed() {
        WebElement popularBlock = waitForPresenceOfElementLocatedBy(By.id("popular"), "Блок Популярное не найден");
        postponedAssertTrue(popularBlock.isDisplayed() && popularBlock.isEnabled(), "Блок Популярное не отображается");
        return this;
    }

    @Step("Проверяется что блок Популярное не пустой")
    public KssLawBasePage checkPopularBlockIsNotEmpty() {
        WebElement popularBlock = waitForPresenceOfElementLocatedBy(By.id("popular"), "Блок Популярное не найден");
        List<WebElement> popularForms = popularBlock.findElements(By.cssSelector(".news__item"));
        postponedAssertFalse(popularForms.isEmpty(), "Блок Популярное пустой");
        return this;
    }

    @Step("Проверяется работа ссылок в блоке Популярное")
    public KssLawBasePage checkLinksInPopularBlock() {
        WebElement popularBlock = waitForPresenceOfElementLocatedBy(By.id("popular"), "Блок Популярное не найден");
        List<WebElement> popularForms = popularBlock.findElements(By.cssSelector(".news__item"));
        List<Link> formLinks = new ArrayList<Link>();
        for (WebElement popularForm : popularForms) {
            String url = popularForm.findElement(By.tagName("a")).getAttribute("href");
            String header = popularForm.findElement(By.tagName("a")).getText();
            Link link = new Link(url, header);
            formLinks.add(link);
        }
        checkLinks(formLinks);
        return this;
    }

    @Step("Проверяется что Блок Кодексы присутсвует")
    public KssLawBasePage checkKodexBlockIsDisplayed() {
        WebElement kodexBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".codex"), "Блок Кодексы не найден");
        postponedAssertTrue(kodexBlock.isDisplayed() && kodexBlock.isEnabled(), "Блок Кодексы не отображается");
        return this;
    }

    @Step("Проверяется что Блок Кодексы не пустой")
    public KssLawBasePage checkKodexBlockIsNotEmpty() {
        WebElement kodexBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".codex"), "Блок Кодексы не найден");
        List<WebElement> kodexList = kodexBlock.findElements(By.cssSelector("[class*='codex-']"));
        postponedAssertFalse(kodexList.isEmpty(), "Блок Кодексы пустой");
        return this;
    }

    @Step("Проверяется порядок кодексов")
    public KssLawBasePage checkKodexOrder() {
        WebElement kodexBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".codex"), "Блок Кодексы не найден");
        List<WebElement> kodexList = kodexBlock.findElements(By.tagName("li"));
        int counter = 0;
        for (int i = 0; i < KODEX_NAME_LIST.length; i++) {
            postponedAssertEquals(kodexList.get(counter).findElement(By.tagName("a")).getAttribute("title"), KODEX_NAME_LIST[i], "Неправильный порядок для '" + KODEX_NAME_LIST[i] + "'");
            WebElement kodexPartElement = findElementByNoThrow(kodexList.get(counter), By.cssSelector(".codex-part-list"));
            if (kodexPartElement != null) {
                List<WebElement> kodexPartList = kodexPartElement.findElements(By.tagName("a"));
                for (int kodexPartNumber = 1; kodexPartNumber <= kodexPartList.size(); kodexPartNumber++) {
                    String actualNumberString = kodexPartList.get(kodexPartNumber - 1).getText();
                    int actualNumber = TestUtils.romanToDecimalConvert(actualNumberString);
                    postponedAssertTrue(actualNumber == kodexPartNumber, "Неправильный порядок для '" + kodexPartNumber + "' части " + KODEX_NAME_LIST[i]);
                }
                counter += kodexPartList.size();
            }
            counter++;
        }
        return this;
    }

    @Step("Проверяется порядок законов")
    public KssLawBasePage checkBlanksOrder() {
        WebElement kodexBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".codex"), "Блок Кодексы не найден");
        List<WebElement> blankList = kodexBlock.findElements(By.cssSelector(".codex-blank"));
        for (int i = 0; i < BLANK_NAME_LIST.length; i++) {
            postponedAssertEquals(TestUtils.replaceIllegalCharacters(blankList.get(i).getText()), BLANK_NAME_LIST[i], "Неправильный порядок для '" + BLANK_NAME_LIST[i] + "'");
        }
        return this;
    }

    @Step("Проверяется работа ссылок для блока Кодексы")
    public KssLawBasePage checkLinksForKodexBlock() {
        WebElement kodexBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".codex"), "Блок Кодексы не найден");
        List<WebElement> kodexList = kodexBlock.findElements(By.tagName("li"));
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement kodex : kodexList) {
            if (!kodex.getAttribute("class").contains("more")) {
                String url = kodex.findElement(By.tagName("a")).getAttribute("href");
                linkList.add(new Link(url, ""));
            }
        }
        checkLinks(linkList);
        return this;
    }

    @Step("Проверяется что результаты поиска отсутсвуют")
    public KssLawBasePage checkSearchResultIsNotPresentOnLawBasePage() {
        checkSearchResultIsNotPresentOnPage();
        return this;
    }


    @Step("Нажать кнопку Найти")
    public KssLawBasePage clickSearchButtonOnLawBasePage() {
        clickSearchButton();
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются")
    public KssLawBasePage checkHintsIsPresent() {
        checkHintListIsPresent();
        return this;
    }

    @Step("Нажать подсказку с прямым переходом")
    public KssSearchResultPage clickHintWithJumpOnYellowPlate() {
        clickHintWithJump();
        return redirectTo(KssSearchResultPage.class);
    }

    @Step("Нажать любую подсказку с переходом")
    public KssSearchResultPage clickRandomHintOnYellowPlate() {
        clickRandomHint();
        return redirectTo(KssSearchResultPage.class);
    }

    @Step("Открыть случайный документ из блока популярное")
    public KssLawBasePage clickRandomDocumentLink() {
        WebElement popularContent = waitForPresenceOfElementLocatedBy(By.cssSelector(".news__in"));
        List<WebElement> popularNews = popularContent.findElements(By.tagName("a"));
        getRandomElementInList(popularNews).click();
        return this;
    }

    @Step("Проверяется работа кнопки Найти на странице Правовая база")
    public KssLawBasePage checkSearchButtonFunctionalityOnSearchBox(String query) {
        setParameter(SearchResultHelper.HINT_TEXT, query);
        return clearSearchBox()
                .clickSearchButtonOnLawBasePage()
                .checkLawBaseTabIsSelected()
                .checkSearchResultIsNotPresentOnLawBasePage()

                .clearSearchBox()
                .inputTextInSearchBox(query)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnLawBasePageIsOpened(true)
                .navigateToLawBasePage();
    }

    @Step("Проверяется что блок 'Трудовой кодекс' изменяется при изменении размера окна")
    public KssLawBasePage checkLaborKodeksBlockResize(int widthTrue) {
        getHelper(LawBasePageHelper.class).checkLaborKodeksBlockResize(widthTrue);
        return this;
    }

    @Step("Проверяется что блок 'Гражданский кодекс' изменяется при изменении размера окна")
    public KssLawBasePage checkCivilKodeksBlockResize(int widthTrue) {
        getHelper(LawBasePageHelper.class).checkCivilKodeksBlockResize(widthTrue);
        return this;
    }

    @Step("Проверяется что блок 'Налоговый кодек' изменяется при изменении размера окна")
    public KssLawBasePage checkTaxKodeksBlockResize(int widthTrue) {
        getHelper(LawBasePageHelper.class).checkTaxKodeksBlockResize(widthTrue);
        return this;
    }

    @Step("Проверяется что блок 'Трудовой кодекс' не конфликтует с другими блоками при изменении размера окна")
    public KssLawBasePage checkBlockConflict() {
        getHelper(LawBasePageHelper.class).checkConflictDisplayBlock();
        return this;
    }

    @Step("Ввести текст в строку поиска в блоке 'Трудовой'")
    public KssLawBasePage inputTextInSearchBoxOnLaborBlock(String query) {
        getHelper(LawBasePageHelper.class).inputTextInSearchBoxOnLaborBlock(query);
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются в блоке 'Трудовой'")
    public KssLawBasePage checkHintsIsPresentOnLaborBlock() {
        getHelper(LawBasePageHelper.class).checkHintsIsPresentOnLaborBlock();
        return this;
    }

    @Step("Нажать подсказку в блоке 'Трудовой кодекс'")
    public KssSearchResultPage clickHintOnLaborBlock() {
        getHelper(LawBasePageHelper.class).clickHintOnLaborBlock();
        return redirectTo(KssSearchResultPage.class);
    }

    @Step("Нажать кнопку  поиска в блоке 'Трудовой кодекс'")
    public KssSearchResultPage clickSearchButtonOnLaborBlock() {
        getHelper(LawBasePageHelper.class).clickSearchButtonOnLaborBlock();
        return redirectTo(KssSearchResultPage.class);
    }

    @Step("Проверяется что поисковые не подсказки отображаются в блоке 'Трудовой'")
    public KssLawBasePage checkHintsIsNotPresentOnLaborBlock() {
        WebElement laborBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_labor-code"));
        WebElement searchResult = findElementByNoThrow(laborBlock, By.cssSelector(".ui-autocomplete"));
        postponedAssertNotNull(searchResult, "Выпадающие поисковые подсказки в блоке 'Трудовой' не найдены");
        if (searchResult != null) {
            searchResult.click();
            postponedAssertFalse(searchResult.isDisplayed(), "Выпадающие поисковые подсказки в блоке 'Трудовой' отображаются");
            checkHintsIsPresent(searchResult);
        }
        return this;
    }


    private List<WebElement> getNewsElements() {
        List<WebElement> news = mainLeftElement.findElements(By.tagName("*"));
        List<WebElement> actualNewsElements = new ArrayList<WebElement>();
        for (int i = 1; i < news.size(); i++) {
            if ("dt".equals(news.get(i).getTagName())) {
                actualNewsElements.add(news.get(i));
            }
        }
        postponedAssertFalse(actualNewsElements.isEmpty(), "Элементы в блоке Новое не найдены");
        return actualNewsElements;
    }

    private void checkHintsIsPresent(WebElement searchResult) {
        List<WebElement> hints = searchResult.findElements(By.cssSelector(".suggest__item"));
        for (WebElement hint : hints) {
            postponedAssertTrue(hint.isDisplayed(), "Подсказки не найдены");
        }
    }

    @Step("Проверяется наличие блока 'Трудовой кодекс'")
    public KssLawBasePage checkLaborBlock() {
        getHelper(LawBasePageHelper.class).checkLaborBlock();
        return this;
    }

    @Step("Проверяется работа ссылок блока 'Главные документы'")
    public KssLawBasePage checkMainDocsBlockLinks() {
        getHelper(LawBasePageHelper.class).checkMainDocsBlockLinks();
        return this;
    }

    @Step("Проверяются секции блока 'Главные документы'")
    public KssLawBasePage checkMainDocsBlockSections() {
        getHelper(LawBasePageHelper.class).checkMainDocsBlockSections();
        return this;
    }

    @Step("Открыть страницу газеты")
    public KssNewsPage clickNewsPaperHeaderLink() {
        waitForPresenceOfElementLocatedBy(By.cssSelector(".news__title")).findElement(By.tagName("a")).click();
        return redirectTo(KssNewsPage.class);
    }

    @Step("Проверяются заголовок блока 'Главное в регионе'")
    public KssLawBasePage checkTitleChangeRegion(String region) {
        getHelper(LawBasePageHelper.class).checkTitleChangeRegion(region);
        return this;
    }

    @Step("Проверяется отображение ссылок блока 'Важное'")
    public KssLawBasePage checkLegislationBlockLinksDisplayed() {
        getHelper(LawBasePageHelper.class).checkLegislationBlockLinksDisplayed();
        return this;
    }

    @Step("Проверяется работа ссылок блока 'Важное'")
    public KssLawBasePage checkLegislationBlockLinks() {
        getHelper(LawBasePageHelper.class).checkLegislationBlockLinks();
        return this;
    }

    @Step("Нажать подсказку в блоке 'Налоговый кодекс'")
    public KssSearchResultPage clickHintOnOtherBlock() {
        getHelper(LawBasePageHelper.class).clickHintOnOtherBlock();
        return redirectTo(KssSearchResultPage.class);
    }

    public KssSearchResultPage setExtended(String type, String lobby, String region) {
        getHelper(SearchResultHelper.class).setExtended(type, lobby, region);
        return redirectTo(KssSearchResultPage.class);
    }

    public KssLawBasePage checkResultTextFiltersOnExtendedFormIsNotVisible() {
        getHelper(LawBasePageHelper.class).checkResultTextFiltersOnExtendedFormIsNotVisible();
        return this;
    }

    public KssSearchResultPage clickOnButtonSearchOnExtendedForm() {
        getHelper(SearchResultHelper.class).clickOnButtonSearchOnExtendedForm();
        return redirectTo(KssSearchResultPage.class);
    }

    public KssLawBasePage checkLaborWidgetIsPresent() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(LaborWidget.class).checkWidgetIsPresent(widget, "Трудовой");
        return this;
    }

    public KssLawBasePage checkLaborWidgetTitleIsPresent() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(LaborWidget.class).checkTitleIsLink(widget);
        return this;
    }

    public KssLawBasePage checkLaborWidgetLinksArePresent() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(LaborWidget.class).checkLinksArePresent(widget);
        return this;
    }

    public KssLawBasePage checkLaborWidgetBlockResized() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(LaborWidget.class).checkBlockSizeIsChanged(widget);
        return this;
    }

    public KssLawBasePage checkLaborWidgetHasTenLinks() {
        getHelper(LaborWidget.class).checkWidgetHasTenLinks();
        return this;
    }

    public KssLawBasePage checkLaborWidgetHasSixLinks() {
        getHelper(LaborWidget.class).checkWidgetHasSixLinks();
        return this;
    }

    public KssLawBasePage checkLaborWidgetLinksAreWorked() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(LaborWidget.class).checkLinksAreWorked(widget);
        return this;
    }

    public KssLawBasePage checkSearchLaborWidgetBlockIsPresent() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchWidgetBlockIsPresent(widget);
        return this;
    }

    public KssLawBasePage checkLaborWidgetSearchInputHasName() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchInputHasName(widget, "Поиск статей");
        return this;
    }

    public KssLawBasePage inputLaborWidgetSearchQuery(String query) {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).inputText(widget, query);
        return this;
    }

    public KssDocumentPage clickOnLaborWidgetButtonEnterIntoSearchBox() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnButtonEnterIntoSearchBox(widget);
        return redirectTo(KssDocumentPage.class);
    }

    public KssLawBasePage checkLaborWidgetSearchResultIsVisible() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsVisible(widget);
        return this;
    }

    public KssLawBasePage checkLaborWidgetSearchResultIsNotVisible() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsNotVisible(widget);
        return this;
    }

    public KssDocumentPage clickOnLaborWidgetRandomSearchResult() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnRandomSearchResult(widget);
        return redirectTo(KssDocumentPage.class);
    }

    public KssLawBasePage checkAllWidgetsDontConflictWithEachOther() {
        getHelper(Widget.class).checkAllWidgetsDontConflictWithEachOther();
        return this;
    }

    public KssLawBasePage checkPopularWidgetIsPresent() {
        WebElement widget = getHelper(PopularWidget.class).getWidget();
        getHelper(PopularWidget.class).checkWidgetIsPresent(widget, "Популярное в");
        return this;
    }

    public KssLawBasePage checkPopularWidgetTitleHasWordPopular() {
        getHelper(PopularWidget.class).checkTitleHasWordPopular();
        return this;
    }

    public KssLawBasePage checkPopularWidgetContainsLinksWithDocuments() {
        getHelper(PopularWidget.class).checkPopularWidgetContainsLinksWithDocuments();
        return this;
    }

    public KssLawBasePage checkPopularWidgetLinkChangeRegionIsDisplayed() {
        getHelper(PopularWidget.class).checkLinkChangeRegionIsDisplayed();
        return this;
    }

    public KssLawBasePage checkPopularWidgetLinkChangeRegionIsNotDisplayed() {
        getHelper(PopularWidget.class).checkLinkChangeRegionIsNotDisplayed();
        return this;
    }

    public KssLawBasePage checkPopularWidgetCheckSearchInputHasName(String name) {
        WebElement widget = getHelper(PopularWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchInputHasName(widget, name);
        return this;
    }

    public KssLawBasePage checkProfstandartsWidgetTitleHasWordProfstandarts() {
        getHelper(ProfstandartsWidget.class).checkTitleHasWordProfstandarts();
        return this;
    }

    public KssLawBasePage checkProfstandartsWidgetTitleHasNoticeNew() {
        getHelper(ProfstandartsWidget.class).checkTitleHasNoticeNew();
        return this;
    }

    public KssLawBasePage checkProfstandartsWidgetCountProfstandartsIsPresent() {
        getHelper(ProfstandartsWidget.class).checkCountProfstandartsIsPresent();
        return this;
    }

    public KssLawBasePage checkProfstandartsWidgetLinkAllAcceptedIsPresent() {
        getHelper(ProfstandartsWidget.class).checkLinkAllAcceptedIsPresent();
        return this;
    }

    public KssLawBasePage checkProfstandartsWidgetLinkHRIsPresent() {
        getHelper(ProfstandartsWidget.class).checkLinkHRIsPresent();
        return this;
    }

    public KssLawBasePage checkProfstandartsWidgetLinkSpecialistSafetyIsPresent() {
        getHelper(ProfstandartsWidget.class).checkLinkSpecialistSafetyIsPresent();
        return this;
    }

    public KssLawBasePage checkProfstandartsWidgetLinkRecruiterIsPresent() {
        getHelper(ProfstandartsWidget.class).checkLinkRecruiterIsPresent();
        return this;
    }

    public KssLawBasePage checkProfstandartsWidgetSearchWidgetHasName(String name) {
        WebElement widget = getHelper(ProfstandartsWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchInputHasName(widget, name);
        return this;
    }

    @Override
    public KssLawBasePage checkMainLawBasePageIsOpened() {
        getHelper(SearchResultHelper.class).checkMainLawBasePageIsOpened();
        return this;
    }
}
