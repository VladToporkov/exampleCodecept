package com.actionmedia.pages.uss;

import com.actionmedia.components.widgets.SearchWidgetBlock;
import com.actionmedia.components.widgets.Widget;
import com.actionmedia.components.widgets.lawbase.CivilWidget;
import com.actionmedia.components.widgets.lawbase.PopularWidget;
import com.actionmedia.components.widgets.lawbase.TaxWidget;
import com.actionmedia.pages.interfaces.ILawBasePage;
import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.components.Link;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.helpers.LawBasePageHelper;
import com.actionmedia.pages.helpers.SearchResultHelper;
import com.actionmedia.util.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: n.tyukavkin
 * Date: 28.10.13
 * Time: 12:14
 */
@Component
public class UssLawBasePage extends UssBasePage<UssLawBasePage> implements ILawBasePage {

    private static final String[] KODEX_NAME_LIST = {
            "Гражданский кодекс Российской Федерации",
            "Трудовой кодекс Российской Федерации",
            "Кодекс Российской Федерации об административных правонарушениях",
            "Налоговый кодекс Российской Федерации",
            "Уголовный кодекс Российской Федерации",
            "Гражданский процессуальный кодекс Российской Федерации",
            "Арбитражный процессуальный кодекс Российской Федерации"};

    private static final String[] BLANK_NAME_LIST = {
            "Закон о гос- контроле",
            "Закон об ООО",
            "Закон о ЗПП",
            "Закон о торговле",
            "Закон о рекламе"};

    @Step("Проверяются элементы на странице 'Правовая база'")
    public UssLawBasePage checkDefaultStateLawBasePage() {
        checkLawBaseTabIsSelected();
        checkSearchBoxPresentOnLawBasePage();
        checkSectionTitleIsPresent();
        checkCivilKodeksBlockIsPresent();
        checkOtherKodeksBlockIsPresent();
        checkLegislationBlockIsPresent();
        checkRegionBlockIsPresent();
        checkMainDocsBlockIsPresent();
        checkAllKodexRubricatorButtonIsPresent();
        checkMyFavoritesRubricatorButtonIsPresent();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Правовая база'")
    public UssLawBasePage checkLawBaseTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.LAW_BASE);
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Правовая база'")
    public UssLawBasePage checkSearchBoxPresentOnLawBasePage() {
        checkSearchBoxIsPresent("Поиск документов");
        return this;
    }

    @Step("Проверяется что заголовок раздела отображается")
    public UssLawBasePage checkSectionTitleIsPresent() {
        WebElement title = waitForPresenceOfElementLocatedBy(By.cssSelector(".main__title"), "Заголовок раздела не найден");
        postponedAssertTrue(title.isDisplayed(), "Заголовок раздела не отображается");
        postponedAssertEquals(title.getText(), "Правовая база\nЗаконы, постановления, приказы, письма", "Неправильный текст заголовка раздела");
        return this;
    }

    @Step("Проверяется работа ссылок блока 'Судебные решения'")
    public UssLawBasePage checkJudgmentBlockLinks() {
        getHelper(LawBasePageHelper.class).checkJudgmentKodeksBlockLinks();
        return this;
    }

    @Step("Проверяется работа ссылок блока 'Судебные решения'")
    public UssLawBasePage checkJudgmentKodeksBlockLinksAreWorked() {
        getHelper(LawBasePageHelper.class).checkJudgmentKodeksBlockLinksAreWorked();
        return this;
    }

    @Step("Проверяется отображение ссылок блока 'Судебные решения'")
    public UssLawBasePage checkJudgmentBlockLinksDisplayed() {
        getHelper(LawBasePageHelper.class).checkJudgmentKodeksBlockLinksDisplayed();
        return this;
    }

    @Step("Проверяется поисковая строка 'Поиск дел'")
    public UssLawBasePage checkSearchBoxPresentJudgementCode() {
        getHelper(LawBasePageHelper.class).checkSearchBoxIsPresentJudgmentBlock("Поиск дел");
        return this;
    }

    @Step("Ввести текст в строку поиска в блоке 'Судебные решения'")
    public UssLawBasePage inputTextInSearchBoxOnJudgmentBlock(String query) {
        getHelper(LawBasePageHelper.class).inputTextInSearchBoxOnJudgmentBlock(query);
        return this;
    }

    @Step("Проверяется что поисковые подсказки не отображаются в блоке 'Судебные решения'")
    public UssLawBasePage checkHintsIsNotPresentOnJudgmentBlock() {
        getHelper(LawBasePageHelper.class).checkHintsIsNotPresentOnJudgmentBlock();
        return this;
    }

    @Step("Нажать кнопку поиска в блоке 'Судебные решения'")
    public UssSearchResultPage clickSearchButtonOnJudgmentBlock() {
        getHelper(LawBasePageHelper.class).clickSearchButtonOnJudgmentBlock();
        return redirectTo(UssSearchResultPage.class);
    }

    @Step("Проверяется что блок 'Гражданский кодекс' отображается")
    public UssLawBasePage checkCivilKodeksBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkCivilKodeksBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Налоговый кодекс' отображается")
    public UssLawBasePage checkTaxKodeksBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkTaxKodeksBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Прочие кодексы' отображается")
    public UssLawBasePage checkOtherKodeksBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkOtherKodeksBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Законы' отображается")
    public UssLawBasePage checkLegislationBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkLegislationBlockIsPresent("Законы");
        return this;
    }

    @Step("Проверяется что блок 'Судебные решения' отображается")
    public UssLawBasePage checkJudgmentBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkJudgmentBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'В регионе' отображается")
    public UssLawBasePage checkRegionBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkRegionBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Главные документы' отображается")
    public UssLawBasePage checkMainDocsBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkMainDocsBlockIsPresent();
        return this;
    }

    @Step("Проверяется кнопка рубрикатора кодексов на странице 'Правовая База'")
    public UssLawBasePage checkAllKodexRubricatorButtonIsPresent() {
        getHelper(LawBasePageHelper.class).checkAllKodexRubricatorButtonIsPresent();
        return this;
    }

    @Step("Проверяется что Блок Кодексы присутсвует")
    public UssLawBasePage checkKodexBlockIsDisplayed() {
        WebElement kodexBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".law-base"), "Блок Кодексы не найден");
        postponedAssertTrue(kodexBlock.isDisplayed() && kodexBlock.isEnabled(), "Блок Кодексы не отображается");
        return this;
    }

    @Step("Проверяется что Блок Кодексы не пустой")
    public UssLawBasePage checkKodexBlockIsNotEmpty() {
        WebElement kodexBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".law-base"), "Блок Кодексы не найден");
        List<WebElement> kodexList = kodexBlock.findElements(By.cssSelector("[class*='law-codex-']"));
        postponedAssertFalse(kodexList.isEmpty(), "Блок Кодексы пустой");
        return this;
    }

    @Step("Проверяется порядок кодексов")
    public UssLawBasePage checkKodexOrder() {
        WebElement kodexBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".law-base"), "Блок Кодексы не найден");
        List<WebElement> kodexList = kodexBlock.findElements(By.tagName("li"));
        int counter = 0;
        for (int i = 0; i < KODEX_NAME_LIST.length; i++) {
            postponedAssertEquals(kodexList.get(counter).findElement(By.tagName("a")).getAttribute("title"), KODEX_NAME_LIST[i], "Неправильный порядок для '" + KODEX_NAME_LIST[i] + "'");
            WebElement kodexPartElement = findElementByNoThrow(kodexList.get(counter), By.cssSelector(".law-codex-sections"));
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
    public UssLawBasePage checkBlanksOrder() {
        WebElement kodexBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".law-base"), "Блок Кодексы не найден");
        List<WebElement> blankList = kodexBlock.findElements(By.cssSelector(".law-blank"));
        for (int i = 0; i < BLANK_NAME_LIST.length; i++) {
            postponedAssertEquals(TestUtils.replaceIllegalCharacters(blankList.get(i).getText()), BLANK_NAME_LIST[i], "Неправильный порядок для '" + BLANK_NAME_LIST[i] + "'");
        }
        return this;
    }

    @Step("Проверяется работа ссылок для блока Кодексы")
    public UssLawBasePage checkLinksForKodexBlock() {
        WebElement kodexBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".law-base"), "Блок Кодексы не найден");
        List<WebElement> kodexList = getRandomElementsInList(kodexBlock.findElements(By.tagName("li")), 3);
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

    @Step("Проверяется работа скролла в блоке Новое")
    public UssLawBasePage checkNewsBlockScrolling() {
        List<WebElement> newsBeforeScroll = mainLeftElement.findElements(By.cssSelector(".block-changes"));

        scroll(Period.month, By.tagName("h2"), 2);

        List<WebElement> newsAfterScroll = mainLeftElement.findElements(By.cssSelector(".block-changes"));
        postponedAssertTrue(newsAfterScroll.size() > newsBeforeScroll.size(), "Новости не подгружаются после скролла");
        return this;
    }

    @Step("Проверяется сортировка новостей по дате(от новых к старым)")
    public UssLawBasePage checkDateAreSortedDescending() {
        List<WebElement> elements = mainLeftElement.findElements(By.tagName("*"));
        List<WebElement> dateElementList = new ArrayList<WebElement>();
        for (WebElement element : elements) {
            if ("h2".equals(element.getTagName())) {
                dateElementList.add(element);
            }
        }

        dateElementList.remove(0);
        dateElementList.remove(0);
        postponedAssertThat(dateElementList, TestUtils.sortedDatesWithoutYearInDescendingOrder(), "Элементы отсортированы в неправильном порядке");
        return this;
    }

    @Step("Проверяется что пустых новостей нет")
    public UssLawBasePage checkNewsAreNotEmpty() {
        List<WebElement> newsList = mainLeftElement.findElements(By.cssSelector(".block-changes"));
        for (WebElement newsElement : newsList) {
            postponedAssertNotNull(findElementByNoThrow(newsElement, By.tagName("a")), "Отсутствует ссылка для новости за '" + newsList + "'");
            postponedAssertTrue(newsElement.findElement(By.tagName("a")).getAttribute("href").contains("/#/document"), "Неправильный формат ссылки");
            postponedAssertFalse(newsElement.findElement(By.tagName("a")).getText().isEmpty(), "Текст ссылки новости за пустой");
            postponedAssertTrue(newsElement.findElement(By.tagName("a")).isDisplayed(), "Ссылка для новости не отображается");
        }
        return this;
    }

    @Step("Проверяется что новости не повторяются")
    public UssLawBasePage checkNewsBlockAreNotRepeat() {
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

    @Step("Проверяется работа ссылок блока Новое")
    public UssLawBasePage checkNewsBlockLinks() {
        List<WebElement> newsTitleList = mainLeftElement.findElements(By.cssSelector(".block-changes"));
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

    @Step("Проверяется что блок Популярное показан")
    public UssLawBasePage checkPopularBlockIsDisplayed() {
        WebElement popularBlock = waitForPresenceOfElementLocatedBy(By.id("popular"), "Блок Популярное не найден");
        postponedAssertTrue(popularBlock.isDisplayed() && popularBlock.isEnabled(), "Блок Популярное не отображается");
        return this;
    }

    @Step("Проверяется что блок Популярное не пустой")
    public UssLawBasePage checkPopularBlockIsNotEmpty() {
        WebElement popularBlock = waitForPresenceOfElementLocatedBy(By.id("popular"), "Блок Популярное не найден");
        List<WebElement> popularForms = popularBlock.findElements(By.cssSelector(".news__item"));
        postponedAssertFalse(popularForms.isEmpty(), "Блок Популярное пустой");
        return this;
    }

    @Step("Проверяется работы ссылок в блоке Популярное")
    public UssLawBasePage checkLinksInPopularBlock() {
        WebElement popularBlock = waitForPresenceOfElementLocatedBy(By.id("popular"), "Блок Популярное не найден");
        List<WebElement> popularForms = popularBlock.findElements(By.cssSelector(".npd"));
        List<Link> formLinks = new ArrayList<Link>();
        for (WebElement popularForm : popularForms) {
            String url = popularForm.getAttribute("href");
            String header = popularForm.getText();
            Link link = new Link(url, header);
            formLinks.add(link);
        }
        checkLinks(formLinks);
        return this;
    }

    @Step("Открыть случайный документ из блока популярное")
    public UssLawBasePage clickRandomDocumentLink() {
        WebElement popularContent = waitForPresenceOfElementLocatedBy(By.id("popular"));
        List<WebElement> popularNews = popularContent.findElements(By.tagName("a"));
        getRandomElementInList(popularNews).click();
        waitForReloadingPage();
        return this;
    }

    @Step("Проверяется Меню поиск в тексте")
    public UssLawBasePage checkSearchInTextElementIsPresentOnLawBasePage() {
        checkSearchInTextElementIsPresent();
        return this;
    }

    @Step("Проверяется что результаты поиска отсутсвуют")
    public UssLawBasePage checkSearchResultIsNotPresentOnLawBasePage() {
        checkSearchResultIsNotPresentOnPage();
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются")
    public UssLawBasePage checkHintsIsPresent() {
        checkHintListIsPresent();
        return this;
    }

    @Step("Нажать подсказку с прямым переходом")
    public UssSearchResultPage clickHintWithJumpOnYellowPlate() {
        clickHintWithJump();
        return redirectTo(UssSearchResultPage.class);
    }

    @Step("Нажать любую подсказку с переходом")
    public UssSearchResultPage clickRandomHintOnYellowPlate() {
        clickRandomHint();
        return redirectTo(UssSearchResultPage.class);
    }

    @Step("Проверяется работа кнопки Найти на странице Правовая база")
    public UssLawBasePage checkSearchButtonFunctionalityOnSearchBox(String query) {
        setParameter(SearchResultHelper.HINT_TEXT, query);
        return clearSearchBox()
                .clickSearchButton()
                .checkLawBaseTabIsSelected()
                .checkSearchResultIsNotPresentOnLawBasePage()

                .clearSearchBox()
                .inputTextInSearchBox(query)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnLawBasePageIsOpened(true)
                .navigateToLawBasePage();
    }

    @Step("Открыть любой документ из рубрикатора")
    public UssDocumentPage openRandomDocument() {
        waitForPresenceOfElementLocatedBy(By.id("rubricator-btn")).click();
        waitForVisibilityOfElementLocatedBy(By.id("rubricator"), "Рубрикатор не найден");
        List<WebElement> links = waitForPresenceOfElementLocatedBy(By.cssSelector(".b-rubricator-list")).findElements(By.tagName("li"));
        getRandomElementInList(links).findElement(By.tagName("a")).click();

        WebElement content = waitForPresenceOfElementLocatedBy(By.id("rubricator-right"));
        WebElement link = getRandomElementInList(content.findElements(By.tagName("a")));

        String currentUrl = getCurrentUrl();
        String linkUrl = link.getAttribute("href");

        report("Открыта страница: " + currentUrl);
        report("Открывается ссылка: " + linkUrl);

        link.click();
        return redirectTo(UssDocumentPage.class);
    }

    @Step("Проверяется отбражение ссылок блока 'Прочие кодексы'")
    public UssLawBasePage checkOtherKodeksBlockLinksDisplayed() {
        getHelper(LawBasePageHelper.class).checkOtherKodeksBlockLinksDisplayed();
        return this;
    }

    @Step("Проверяется работа ссылок блока 'Прочие кодексы'")
    public UssLawBasePage checkOtherKodeksBlockLinks() {
        getHelper(LawBasePageHelper.class).checkOtherKodeksBlockLinks();
        return this;
    }

    @Step("Ввести текст в строку поиска в блоке 'Прочие кодексы'")
    public UssLawBasePage inputTextInSearchBoxOnOtherKodeksBlock(String text) {
        getHelper(LawBasePageHelper.class).inputTextInSearchBoxOnOtherKodeksBlock(text);
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются в блоке 'Прочие кодексы'")
    public UssLawBasePage checkHintsIsPresentOnOtherKodeksBlock() {
        getHelper(LawBasePageHelper.class).checkHintsIsPresentOnOtherKodeksBlock();
        return this;
    }

    @Step("Проверить подсказку в блоке 'Прочие Кодексы'")
    public UssLawBasePage checkHintOnOtherKodeksBlock() {
        getHelper(LawBasePageHelper.class).checkHintOnOtherKodeksBlock();
        return this;
    }

    @Step("Проверяется поисковая строка 'Поиск статей'")
    public UssLawBasePage checkSearchBoxPresentOtherCode() {
        getHelper(LawBasePageHelper.class).checkSearchBoxIsPresentOtherCode("Поиск статей");
        return this;
    }

    @Step("Нажать кнопку поиска в блоке 'Прочие кодексы'")
    public UssSearchResultPage clickSearchButtonOnOtherKodeksBlock() {
        getHelper(LawBasePageHelper.class).clickSearchButtonOnOtherKodeksBlock();
        return redirectTo(UssSearchResultPage.class);
    }

    @Step("Проверяется отображение ссылок блока 'Важное'")
    public UssLawBasePage checkLegislationBlockLinksDisplayed() {
        getHelper(LawBasePageHelper.class).checkLegislationBlockLinksDisplayed();
        return this;
    }

    @Step("Проверяется работа ссылок блока 'Важное'")
    public UssLawBasePage checkLegislationBlockLinks() {
        getHelper(LawBasePageHelper.class).checkLegislationBlockLinks();
        return this;
    }

    @Step("Проверяется поисковая строка блока 'Важное'")
    public UssLawBasePage checkSearchBoxPresentLegislation(String input) {
        getHelper(LawBasePageHelper.class).checkSearchBoxIsPresentLegislation(input);
        return this;
    }

    @Step("Ввести текст в строку поиска в блоке 'Важное'")
    public UssLawBasePage inputTextInSearchBoxOnLegislationBlock(String query) {
        getHelper(LawBasePageHelper.class).inputTextInSearchBoxOnLegislationBlock(query);
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются в блоке 'Важное'")
    public UssLawBasePage checkHintsIsPresentOnLegislationBlock() {
        getHelper(LawBasePageHelper.class).checkHintsIsPresentOnLegislationBlock();
        return this;
    }

    @Step("Нажать подсказку в блоке 'Важное'")
    public UssSearchResultPage clickHintOnLegislationBlock() {
        getHelper(LawBasePageHelper.class).clickHintOnLegislationBlock();
        return redirectTo(UssSearchResultPage.class);
    }

    public void clickHintWithJump(WebElement searchResult) {
        getHelper(LawBasePageHelper.class).clickHintWithJump(searchResult);
    }

    @Step("Нажать подсказку в блоке 'Важное'")
    public UssSearchResultPage clickSearchButtonOnLegislationBlock() {
        getHelper(LawBasePageHelper.class).clickSearchButtonOnLegislationBlock();
        return redirectTo(UssSearchResultPage.class);
    }

    @Step("Проверяется что блок 'Важное' отображается")
    public UssLawBasePage checkLegislationBlockIsPresent(String blockName) {
        getHelper(LawBasePageHelper.class).checkLegislationBlockIsPresent(blockName);
        return this;
    }

    @Step("Проверяется что блок 'Гражданский кодекс' изменяется при изменении размера окна")
    public UssLawBasePage checkCivilKodeksBlockResize(int widthTrue) {
        getHelper(LawBasePageHelper.class).checkCivilKodeksBlockResize(widthTrue);
        return this;
    }

    @Step("Проверяется что блок 'Трудовой кодекс' не конфликтует с другими блоками при изменении размера окна")
    public UssLawBasePage checkBlockConflict() {
        getHelper(LawBasePageHelper.class).checkConflictDisplayBlock();
        return this;
    }

    @Step("Ввести текст в строку поиска в блоке 'Налоговый кодекс'")
    public UssLawBasePage inputTextInSearchBoxOnCivilBlock(String query) {
        getHelper(LawBasePageHelper.class).inputTextInSearchBoxOnCivilBlock(query);
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются в блоке 'Гражданский кодекс'")
    public UssLawBasePage checkHintsIsPresentOnCivilKodeksBlock() {
        getHelper(LawBasePageHelper.class).checkHintsIsPresentOnCivilKodeksBlock();
        return this;
    }

    @Step("Нажать подсказку в блоке 'Гражданский кодекс'")
    public UssSearchResultPage clickHintOnCivilBlock() {
        getHelper(LawBasePageHelper.class).clickHintOnCivilBlock();
        return redirectTo(UssSearchResultPage.class);
    }

    @Step("Нажать кнопку  поиска в блоке 'Гражданский кодекс'")
    public UssSearchResultPage clickSearchButtonOnCivilBlock() {
        getHelper(LawBasePageHelper.class).clickSearchButtonOnCivilBlock();
        return redirectTo(UssSearchResultPage.class);
    }

    @Step("Проверяется что поисковые подсказки не отображаются в блоке 'Гражданский кодекс'")
    public UssLawBasePage checkHintsIsNotPresentOnCivilKodeksBlock() {
        getHelper(LawBasePageHelper.class).checkHintsIsNotPresentOnCivilKodeksBlock();
        return this;
    }

    @Step("Проверяется работа ссылок блока 'Граждаский кодекс'")
    public UssLawBasePage checkCivilKodeksBlockLinks() {
        getHelper(LawBasePageHelper.class).checkCivilKodeksBlockLinks();
        return this;
    }

    @Step("Проверяется наличие блока 'Граждаский кодекс'")
    public UssLawBasePage checkCivilBlock() {
        getHelper(LawBasePageHelper.class).checkCivilBlock();
        return this;
    }

    @Step("Проверяется работа ссылок блока 'Главные документы'")
    public UssLawBasePage checkMainDocsBlockLinks() {
        getHelper(LawBasePageHelper.class).checkMainDocsBlockLinks();
        return this;
    }

    @Step("Проверяются секции блока 'Главные документы'")
    public UssLawBasePage checkMainDocsBlockSections() {
        getHelper(LawBasePageHelper.class).checkMainDocsBlockSections();
        return this;
    }

    @Step("Открыть страницу газеты")
    public UssNewsPage clickNewsPaperHeaderLink() {
        waitForPresenceOfElementLocatedBy(By.cssSelector(".news__title")).findElement(By.tagName("a")).click();
        return redirectTo(UssNewsPage.class);
    }

    @Step("Проверяется что ссылка 'Изменить регион' отображается")
    public UssLawBasePage checkChangeRegionLinkIsPresent() {
        getHelper(LawBasePageHelper.class).checkChangeRegionLinkIsPresent();
        return this;
    }

    @Step("Проверяется работа ссылок блока 'Региональные документы'")
    public UssLawBasePage checkRegionBlockLinks() {
        getHelper(LawBasePageHelper.class).checkRegionBlockLinks();
        return this;
    }

    @Step("Проверяется поисковая строка 'Поиск региональных документов'")
    public UssLawBasePage checkSearchBoxIsPresentRegionBlock() {
        getHelper(LawBasePageHelper.class).checkSearchBoxIsPresentRegionBlock("Поиск региональных документов");
        return this;
    }

    @Step("Ввести текст в строку поиска в блоке 'Региональные документы'")
    public UssLawBasePage inputTextInSearchBoxOnRegionBlock(String query) {
        getHelper(LawBasePageHelper.class).inputTextInSearchBoxOnRegionBlock(query);
        return this;
    }

    @Step("Нажать кнопку поиска в блоке 'Региональные документы'")
    public UssSearchResultPage clickSearchButtonOnRegionBlock() {
        getHelper(LawBasePageHelper.class).clickSearchButtonOnRegionBlock();
        return redirectTo(UssSearchResultPage.class);
    }

    @Step("Кликнуть на ссылку 'Изменить регион'")
    public UssProfilePage clickLinkChangeRegion() {
        getHelper(LawBasePageHelper.class).clickLinkChangeRegion();
        return redirectTo(UssProfilePage.class);
    }

    @Step("Проверяем клик на ссылку 'Изменить регион'")
    public UssLawBasePage checkCurrentUrlContainsDocumentUrl() {
        getHelper(LawBasePageHelper.class).checkCurrentUrlContainsDocumentUrl("/#/customer/geo/");
        return this;
    }

    @Step("Проверяются заголовок блока 'Главное в регионе'")
    public UssLawBasePage checkTitleChangeRegion(String region) {
        getHelper(LawBasePageHelper.class).checkTitleChangeRegion(region);
        return this;
    }


    @Step("Проверяется что блок 'Налоговый кодекс' изменяется при изменении размера окна")
    public UssLawBasePage checkTaxKodeksBlockResize(int widthTrue) {
        getHelper(LawBasePageHelper.class).checkTaxKodeksBlockResize(widthTrue);
        return this;
    }


    @Step("Проверяется наличие блока 'Налоговый кодекс'")
    public UssLawBasePage checkTaxBlock() {
        getHelper(LawBasePageHelper.class).checkTaxBlock();
        return this;
    }

    @Step("Ввести текст в строку поиска в блоке 'Налоговый кодекс'")
    public UssLawBasePage inputTextInSearchBoxOnTaxBlock(String query) {
        getHelper(LawBasePageHelper.class).inputTextInSearchBoxOnTaxBlock(query);
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются в блоке 'Налоговый кодекс'")
    public UssLawBasePage checkHintsIsPresentOnTaxKodeksBlock() {
        getHelper(LawBasePageHelper.class).checkHintsIsPresentOnTaxKodeksBlock();
        return this;
    }

    @Step("Проверяется что поисковые подсказки не отображаются в блоке 'Налоговый кодекс'")
    public UssLawBasePage checkHintsIsNotPresentOnTaxKodeksBlock() {
        getHelper(LawBasePageHelper.class).checkHintsIsNotPresentOnTaxKodeksBlock();
        return this;
    }

    @Step("Нажать подсказку в блоке 'Налоговый кодекс'")
    public UssSearchResultPage clickHintOnTaxBlock() {
        getHelper(LawBasePageHelper.class).clickHintOnTaxBlock();
        return redirectTo(UssSearchResultPage.class);
    }

    @Step("Нажать кнопку  поиска в блоке 'Налоговый кодекс'")
    public UssSearchResultPage clickSearchButtonOnTaxBlock() {
        getHelper(LawBasePageHelper.class).clickSearchButtonOnTaxBlock();
        return redirectTo(UssSearchResultPage.class);
    }

    @Step("Проверяется работа ссылок блока 'Налоговый кодекс'")
    public UssLawBasePage checkTaxKodeksBlockLinks() {
        getHelper(LawBasePageHelper.class).checkTaxKodeksBlockLinks();
        return this;
    }

    @Step("Нажать подсказку в блоке 'Налоговый кодекс'")
    public UssSearchResultPage clickHintOnOtherBlock() {
        getHelper(LawBasePageHelper.class).clickHintOnOtherBlock();
        return redirectTo(UssSearchResultPage.class);
    }

    public UssSearchResultPage setExtended(String type, String city) {
        getHelper(SearchResultHelper.class).setExtended(type, null, city);
        return redirectTo(UssSearchResultPage.class);
    }
    public UssSearchResultPage setExtended(String type, String lobby, String region) {
        getHelper(SearchResultHelper.class).setExtended(type, lobby, region);
        return redirectTo(UssSearchResultPage.class);
    }

    public UssLawBasePage checkResultTextFiltersOnExtendedFormIsNotVisible() {
        getHelper(LawBasePageHelper.class).checkResultTextFiltersOnExtendedFormIsNotVisible();
        return this;
    }

    public UssSearchResultPage clickOnButtonSearchOnExtendedForm() {
        getHelper(SearchResultHelper.class).clickOnButtonSearchOnExtendedForm();
        return redirectTo(UssSearchResultPage.class);
    }

    public UssLawBasePage checkCivilWidgetIsPresent() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(CivilWidget.class).checkWidgetIsPresent(widget, "Гражданский");
        return this;
    }

    public UssLawBasePage checkCivilWidgetTitleIsPresent() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(CivilWidget.class).checkTitleIsLink(widget);
        return this;
    }

    public UssLawBasePage checkCivilWidgetLinksArePresent() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(CivilWidget.class).checkLinksArePresent(widget);
        return this;
    }

    public UssLawBasePage checkCivilWidgetBlockResized() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(CivilWidget.class).checkBlockSizeIsChanged(widget);
        return this;
    }

    public UssLawBasePage checkWidgetHasFourLinks() {
        getHelper(CivilWidget.class).checkWidgetHasFourLinks();
        return this;
    }

    public UssLawBasePage checkCivilWidgetLinksAreWorked() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(CivilWidget.class).checkLinksAreWorked(widget);
        return this;
    }

    public UssLawBasePage checkSearchCivilWidgetBlockIsPresent() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchWidgetBlockIsPresent(widget);
        return this;
    }

    public UssLawBasePage checkAllWidgetsDontConflictWithEachOther() {
        getHelper(Widget.class).checkAllWidgetsDontConflictWithEachOther();
        return this;
    }

    public UssLawBasePage checkCivilWidgetSearchInputHasName() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchInputHasName(widget, "Поиск статей");
        return this;
    }

    public UssLawBasePage inputCivilWidgetSearchQuery(String query) {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).inputText(widget, query);
        return this;
    }

    public UssDocumentPage clickOnCivilWidgetButtonEnterIntoSearchBox() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnButtonEnterIntoSearchBox(widget);
        return redirectTo(UssDocumentPage.class);
    }

    public UssLawBasePage checkCivilWidgetSearchResultIsVisible() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsVisible(widget);
        return this;
    }

    public UssLawBasePage checkCivilWidgetSearchResultIsNotVisible() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsNotVisible(widget);
        return this;
    }

    public UssDocumentPage clickOnCivilWidgetRandomSearchResult() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnRandomSearchResult(widget);
        return redirectTo(UssDocumentPage.class);
    }

    public UssLawBasePage checkTaxWidgetIsPresent() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkWidgetIsPresent(widget, "Налоговый");
        return this;
    }

    public UssLawBasePage checkTaxWidgetTitleIsPresent() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkTitleIsLink(widget);
        return this;
    }

    public UssLawBasePage checkTaxWidgetLinksArePresent() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkLinksArePresent(widget);
        return this;
    }

    public UssLawBasePage checkTaxWidgetBlockResized() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkBlockSizeIsChanged(widget);
        return this;
    }

    public UssLawBasePage checkTaxWidgetBlockIsNotChanged() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkBlockSizeIsNotChanged(widget);
        return this;
    }

    public UssLawBasePage checkTaxWidgetHasSixLinks() {
        getHelper(TaxWidget.class).checkWidgetHasSixLinks();
        return this;
    }

    public UssLawBasePage checkTaxWidgetHasTwoLinks() {
        getHelper(TaxWidget.class).checkWidgetHasTwoLinks();
        return this;
    }

    public UssLawBasePage checkTaxWidgetLinksAreWorked() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkLinksAreWorked(widget);
        return this;
    }

    public UssLawBasePage checkSearchTaxWidgetBlockIsPresent() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchWidgetBlockIsPresent(widget);
        return this;
    }

    public UssLawBasePage checkTaxWidgetSearchInputHasName() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchInputHasName(widget, "Поиск статей");
        return this;
    }

    public UssLawBasePage inputTaxWidgetSearchQuery(String query) {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).inputText(widget, query);
        return this;
    }

    public UssDocumentPage clickOnTaxWidgetButtonEnterIntoSearchBox() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnButtonEnterIntoSearchBox(widget);
        return redirectTo(UssDocumentPage.class);
    }

    public UssLawBasePage checkTaxWidgetSearchResultIsVisible() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsVisible(widget);
        return this;
    }

    public UssLawBasePage checkTaxWidgetSearchResultIsNotVisible() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsNotVisible(widget);
        return this;
    }

    public UssDocumentPage clickOnTaxWidgetRandomSearchResult() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnRandomSearchResult(widget);
        return redirectTo(UssDocumentPage.class);
    }

    public UssLawBasePage checkPopularWidgetIsPresent() {
        WebElement widget = getHelper(PopularWidget.class).getWidget();
        getHelper(PopularWidget.class).checkWidgetIsPresent(widget, "Популярное в");
        return this;
    }

    public UssLawBasePage checkPopularWidgetTitleHasWordPopular() {
        getHelper(PopularWidget.class).checkTitleHasWordPopular();
        return this;
    }

    public UssLawBasePage checkPopularWidgetContainsLinksWithDocuments() {
        getHelper(PopularWidget.class).checkPopularWidgetContainsLinksWithDocuments();
        return this;
    }

    public UssLawBasePage checkPopularWidgetLinkChangeRegionIsDisplayed() {
        getHelper(PopularWidget.class).checkLinkChangeRegionIsDisplayed();
        return this;
    }

    public UssLawBasePage checkPopularWidgetLinkChangeRegionIsNotDisplayed() {
        getHelper(PopularWidget.class).checkLinkChangeRegionIsNotDisplayed();
        return this;
    }

    public UssLawBasePage checkPopularWidgetCheckSearchInputHasName(String name) {
        WebElement widget = getHelper(PopularWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchInputHasName(widget, name);
        return this;
    }

    @Override
    public UssLawBasePage checkMainLawBasePageIsOpened() {
        getHelper(SearchResultHelper.class).checkMainLawBasePageIsOpened();
        return this;
    }
}
