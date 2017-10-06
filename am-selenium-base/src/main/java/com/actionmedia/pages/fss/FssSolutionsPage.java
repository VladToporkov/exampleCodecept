package com.actionmedia.pages.fss;

import com.actionmedia.autotest.selenium.SeleniumHolder;
import com.actionmedia.autotest.selenium.context.ComponentProvider;
import com.actionmedia.components.Link;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.components.widgets.*;
import com.actionmedia.components.widgets.recomendation.*;
import com.actionmedia.pages.RightPanel;
import com.actionmedia.pages.helpers.SearchResultHelper;
import com.actionmedia.pages.interfaces.IRecomendPage;
import com.actionmedia.util.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 05.11.13
 * Time: 10:49
 */
@Component
public class FssSolutionsPage extends FssBasePage<FssSolutionsPage> implements ComponentProvider, IRecomendPage {

    private RightPanel rightPanel;

    @Override
    public void handleRedirect() {
        super.handleRedirect();
        rightPanel = getHelper(RightPanel.class, this);
    }

    @Step("Проверяется что открыта страница 'Решения'")
    public FssSolutionsPage checkSolutionsPageIsOpened() {
        checkSolutionsTabIsSelected();
        checkSearchBoxPresentOnSolutionsPage();
        checkHeaderDefaultState();
        checkNewsBlockIsPresent();
        checkNewsBlockIsNotEmpty();
        checkRubricatorMenuIsPresent();
        checkRubricatorMenuIsNotEmpty();
        checkPopularBlockIsPresent();
        checkPopularBlockIsNotEmpty();
        return this;
    }

    @Step("Проверяются элементы на странице 'Решения'")
    public FssSolutionsPage checkDefaultStateSolutionsPage() {
        checkSolutionsTabIsSelected();
        checkSearchBoxPresentOnSolutionsPage();
        checkHeaderDefaultState();
        checkNewsBlockIsPresent();
        checkNewsBlockIsNotEmpty();
        checkRubricatorMenuIsPresent();
        checkRubricatorMenuIsNotEmpty();
        checkPopularBlockIsPresent();
        checkPopularBlockIsNotEmpty();
        checkFirstNewsTitle();
        checkBlockWithThisSolutionIsPresent();
        checkBubbleIsPresent();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Решения'")
    public FssSolutionsPage checkSolutionsTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.FSS_SOLUTIONS);
        return this;
    }

    @Step("Проверяется заголовок страницы 'Решения'")
    public FssSolutionsPage checkHeaderDefaultState() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement header = findElementByNoThrow(content, By.cssSelector(".doc-header"));
        assertNotNull(header, "Заголовок страницы 'Решения' не найден");
        postponedAssertTrue(header.isDisplayed(), "Заголовок страницы 'Решения' не отображается");
        postponedAssertEquals(header.getText().trim(), "НОВЫЕ РЕШЕНИЯ", "Неправильный текст заголовка страницы 'Решения'");
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Решения'")
    public FssSolutionsPage checkSearchBoxPresentOnSolutionsPage() {
        checkSearchBoxIsPresent("Поиск решений");
        return this;
    }

    @Override
    public FssSolutionsPage checkYellowPanelIsPresent() {
        getHelper(YellowPanel.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkHandbookWidgetIsPresent() {
        getHelper(HandbookWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkFormsWidgetIsPresent() {
        getHelper(FormsWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkLawBaseWidgetIsPresent() {
        getHelper(LawBaseWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkVideoWidgetIsPresent() {
        getHelper(VideoWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkFavoritesWidgetIsPresent() {
        getHelper(FavoritesWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkWorkingDaysWidgetIsPresent() {
        getHelper(WorkingDaysWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkWeekendDaysWidgetIsPresent() {
        getHelper(WeekendDaysWidget.class).checkWidgetIsPresent();
        return this;
    }

    public FssSolutionsPage checkSchoolWidgetIsPresent() {
        getHelper(SchoolWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkNewsBlockIsPresent() {
        getHelper(NewsBlock.class).checkWidgetIsPresent();
        return this;
    }

    public FssSolutionsPage checkSeminarsWidgetIsPresent() {
        getHelper(SeminarsWidget.class).checkWidgetIsPresent();
        return this;
    }

    public FssSolutionsPage checkFavoritesWidgetIsNotPresent() {
        getHelper(FavoritesWidget.class).checkWidgetIsNotPresent();
        return this;
    }

    @Step("Проверяется что блок Новое на странице 'Решения' не пустой")
    public FssSolutionsPage checkNewsBlockIsNotEmpty() {
        WebElement newsBlock = waitForVisibilityOfElementLocatedBy(By.id("main-article"));
        List<WebElement> newsItemList = newsBlock.findElements(By.cssSelector(".b-news"));
        postponedAssertFalse(newsItemList.isEmpty(), "Блок Новое на странице 'Решения' пустой");
        return this;
    }

    @Step("Проверяется что меню Рубрикатора на странице 'Решения' отображается")
    public FssSolutionsPage checkRubricatorMenuIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement rubricatorMenu = findElementByNoThrow(content, By.id("sidebar"));
        assertNotNull(rubricatorMenu, "Меню Рубрикатора на странице 'Решения' не найдено");
        postponedAssertTrue(rubricatorMenu.isDisplayed(), "Меню Рубрикатора на странице 'Решения' не отображается");
        return this;
    }

    @Step("Проверяется что меню Рубрикатора на странице 'Решения' не пустое")
    public FssSolutionsPage checkRubricatorMenuIsNotEmpty() {
        List<WebElement> newsItemList = sidebarElement.findElements(By.tagName("li"));
        postponedAssertFalse(newsItemList.isEmpty(), "Меню Рубрикатора на странице 'Решения' пустое");
        return this;
    }

    @Step("Проверяется что правая панель на странице 'Решения' отображается")
    public FssSolutionsPage checkPopularBlockIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement rubricatorMenu = findElementByNoThrow(content, By.id("aside"));
        assertNotNull(rubricatorMenu, "Правая панель на странице 'Решения' не найдена");
        postponedAssertTrue(rubricatorMenu.isDisplayed(), "Правая панель на странице 'Решения' не отображается");
        return this;
    }

    @Step("Проверяется что правая панель на странице 'Решения' не пустая")
    public FssSolutionsPage checkPopularBlockIsNotEmpty() {
        WebElement newsBlock = getCollapsedRightPanel();
        List<WebElement> newsItemList = newsBlock.findElements(By.cssSelector(".go"));
        postponedAssertFalse(newsItemList.isEmpty(), "Правая панель на странице 'Решения' пустая");
        return this;
    }

    @Step("Проверяется заголовок для верхнего документа")
    public FssSolutionsPage checkFirstNewsTitle() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("main-article"));
        WebElement firstNews = content.findElement(By.cssSelector(".b-news"));
        String fontSize = firstNews.findElement(By.tagName("a")).getCssValue("font-size");
        if ("chrome".equalsIgnoreCase(SeleniumHolder.getDriverName())) {
            postponedAssertEquals(TestUtils.getHeightFromString(fontSize), 23.0, "Неправильный размер шрифта для верхнего документа");
        } else {
            postponedAssertEquals(TestUtils.getHeightFromString(fontSize), 22.5, "Неправильный размер шрифта для верхнего документа");
        }
        return this;
    }

    @Step("Проверяется что блок Вместе с этим решением отображается")
    public FssSolutionsPage checkBlockWithThisSolutionIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("main-article"));
        WebElement firstNews = content.findElement(By.cssSelector(".b-news"));
        WebElement with = findElementByNoThrow(firstNews, By.cssSelector(".b-links"));
        postponedAssertNotNull(with, "Блок Вместе с этим решением не найден");
        if (with != null) {
            postponedAssertTrue(with.isDisplayed(), "Блок Вместе с этим решением не отображается");
        }
        return this;
    }

    @Step("Проверяются что Балоны с примерами отображаются")
    public FssSolutionsPage checkBubbleIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("main-article"));
        List<WebElement> bubbleList = content.findElements(By.cssSelector(".bubble"));
        postponedAssertFalse(bubbleList.isEmpty(), "Балоны с примерами не найдены");
        for (WebElement bubble : bubbleList) {
            postponedAssertTrue(bubble.isDisplayed(), "Балон с примерами не отображается");
            postponedAssertFalse(bubble.getText().isEmpty(), "Балоны с примерами пустой");
        }
        return this;
    }

    public FssSolutionsPage checkLinksFromNewsBlock() {
        getHelper(FssHelpers.class).checkLinksFromNewsBlock();
        return this;
    }

    public FssSolutionsPage checkNewsBlockScrolling() {
        getHelper(FssHelpers.class).checkNewsBlockScrolling(Period.month);
        return this;
    }

    public FssSolutionsPage checkDateAreSortedDescending() {
        getHelper(FssHelpers.class).checkDateAreSortedDescending();
        return this;
    }

    public FssSolutionsPage checkNewsBlockAreNotRepeat() {
        getHelper(FssHelpers.class).checkNewsBlockAreNotRepeat();
        return this;
    }

    public FssSolutionsPage checkNewsAreNotEmpty() {
        getHelper(FssHelpers.class).checkNewsAreNotEmpty();
        return this;
    }

    public FssSolutionsPage clickExtendPopularBlock() {
        getHelper(FssHelpers.class).clickExtendPopularBlock();
        return this;
    }

    @Step("Открыть раздел Популярное в правой панели")
    public FssSolutionsPage clickPopularTab() {
        rightPanel.clickPopularTabInExpanded();
        return this;
    }

    @Step("Открыть раздел Просмотренное в правой панели")
    public FssSolutionsPage clickViewedTab() {
        rightPanel.clickViewedTabInExpanded();
        return this;
    }

    @Step("Закрыть правую панель")
    public FssSolutionsPage closePopularBlock() {
        rightPanel.closePopularBlock();
        return this;
    }

    @Step("Проверяется работа ссылок из раздела Просмотренное в правой панели")
    public FssSolutionsPage checkRandomLinksFromExtendedViewedBlock() {
        clickExtendPopularBlock();
        clickViewedTab();
        List<Link> linkList = getRandomElementsInList(rightPanel.getLinks(), 3);
        for (Link link : linkList) {
            checkLink(link);
            clickExtendPopularBlock();
            clickViewedTab();
        }
        return this;
    }

    @Step("Проверяется работа ссылок из раздела Популярное в правой панели")
    public FssSolutionsPage checkRandomLinksFromExtendedPopularBlock() {
        clickExtendPopularBlock();
        clickPopularTab();
        List<Link> linkList = getRandomElementsInList(rightPanel.getLinks(), 3);
        for (Link link : linkList) {
            checkLink(link);
            clickExtendPopularBlock();
            clickPopularTab();
        }
        return this;
    }

    @Step("Проверяются фильтры в правой панели")
    public FssSolutionsPage checkFiltersInRightPanel() {
        clickExtendPopularBlock();
        clickViewedTab();
        rightPanel.checkDateFilters();
        return this;
    }

    @Step("Проверяется работа кнопки найти")
    public FssSolutionsPage checkSearchButtonFunctionalityOnSearchBox(String query) {
        return clearSearchBox()
                .clickSearchButtonOnSolutionsPage()
                .checkSearchResultIsNotPresentOnSolutionsPage()

                .clearSearchBox()
                .inputTextInSearchBox(query)
                .clickSearchButtonFss()
                .checkSearchResultIsPresent(false)
                .navigateToSolutionsPage();
    }

    @Step("Проверяется что результаты поиска отсутсвуют")
    public FssSolutionsPage checkSearchResultIsNotPresentOnSolutionsPage() {
        WebElement content = getPage();
        WebElement solutionsPage = content.findElement(By.id("main-article"));
        WebElement searchResult = findElementByNoThrow(solutionsPage, By.cssSelector(".b-search"));
        postponedAssertNull(searchResult, "Результаты поиска отображаются");
        return this;
    }

    public FssSolutionsPage checkCollapsedRightPanel() {
        getHelper(FssHelpers.class).checkCollapsedRightPanel(rightPanel);
        return this;
    }

    public FssSolutionsPage checkExpandedRightPanel() {
        getHelper(FssHelpers.class).checkExpandedRightPanel(rightPanel);
        return this;
    }

    public FssSolutionsPage checkRandomLinksFromCollapsedPopularTab() {
        getHelper(FssHelpers.class).checkRandomLinksFromCollapsedPopularTab(rightPanel);
        return this;
    }

    public FssSolutionsPage checkRandomLinksFromCollapsedViewedTab() {
        getHelper(FssHelpers.class).checkRandomLinksFromCollapsedViewedTab(rightPanel);
        return this;
    }

    public FssSolutionsPage clickSearchButtonOnSolutionsPage() {
        searchButton.click();
        return this;
    }

    private void checkHintsIsPresent(WebElement searchResult) {
        List<WebElement> hintsWith = searchResult.findElements(By.cssSelector(".hint-doc"));
        List<WebElement> hints = searchResult.findElements(By.cssSelector(".ui-menu-item"));
        postponedAssertFalse(hintsWith.isEmpty(), "Подсказки с переходом не найдены");
        for (WebElement hint : hints) {
            postponedAssertTrue(hint.isDisplayed(), "Подсказки не найдены");
        }
    }

    @Step("Открыть страницу газеты")
    public FssNewsPage clickNewsPaperHeaderLink() {
        waitForPresenceOfElementLocatedBy(By.cssSelector(".news .news__title a")).click();
        return redirectTo(FssNewsPage.class);
    }

    @Override
    public FssSolutionsPage checkHandbookWidgetTitleIsPresent() {
        getHelper(HandbookWidget.class).checkTitleIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkHandbookWidgetDocumentCountIsPresent() {
        getHelper(HandbookWidget.class).checkDocumentCountIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkHandbookWidgetDateTodayIsPresent() {
        getHelper(HandbookWidget.class).checkDateTodayIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkHandbookWidgetMonthNowIsPresent() {
        getHelper(HandbookWidget.class).checkMonthNowIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkHandbookWidgetWorkingDaysElementIsPresent() {
        getHelper(HandbookWidget.class).checkWorkingDaysElementIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkHandbookWidgetHolidaysElementIsPresent() {
        getHelper(HandbookWidget.class).checkHolidaysElementIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkHandbookWidgetExchangeRatesTitleIsPresent() {
        getHelper(HandbookWidget.class).checkExchangeRatesTitleIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkHandbookWidgetDollarRateIsPresent() {
        getHelper(HandbookWidget.class).checkDollarRateIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkHandbookWidgetEuroRateIsPresent() {
        getHelper(HandbookWidget.class).checkEuroRateIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkHandbookWidgetMinimunWageTitleIsPresent() {
        getHelper(HandbookWidget.class).checkMinimunWageTitleIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkHandbookWidgetWageIsPresent() {
        getHelper(HandbookWidget.class).checkWageIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkHandbookWidgetLinkInRegionIsPresent() {
        getHelper(HandbookWidget.class).checkLinkInRegionIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkHandbookWidgetLinkRubricIsPresent() {
        getHelper(HandbookWidget.class).checkLinkRubricIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkHandbookWidgetChangesIsPresent() {
        getHelper(HandbookWidget.class).checkLinkChangesIsPresent();
        return this;
    }

    @Override
    public FssDictionaryPage clickOnHandbookWidgetTitle() {
        getHelper(HandbookWidget.class).clickOnTitle();
        return redirectTo(FssDictionaryPage.class);
    }

    @Override
    public FssDocumentPage clickOnHandbookWidgetCalendar() {
        getHelper(HandbookWidget.class).clickOnCalendar();
        return redirectTo(FssDocumentPage.class);
    }

    @Override
    public FssDocumentPage clickOnHandbookWidgetExchangeRatesBlock() {
        getHelper(HandbookWidget.class).clickOnExchangeRatesBlock();
        return redirectTo(FssDocumentPage.class);
    }

    @Override
    public FssDocumentPage clickOnHandbookWidgetRubricLink() {
        getHelper(HandbookWidget.class).clickOnRubricLink();
        return redirectTo(FssDocumentPage.class);
    }

    @Override
    public FssDocumentPage clickOnHandbookWidgetChangesLink() {
        getHelper(HandbookWidget.class).clickOnRubricLink();
        return redirectTo(FssDocumentPage.class);
    }

    public FssSolutionsPage checkYellowPanelSearchInputIsPresent() {
        getHelper(YellowPanel.class).checkSearchInputIsPresent();
        return this;
    }

    public FssSolutionsPage checkYellowPanelSearchInputPlaceholderTextIsPresent() {
        getHelper(YellowPanel.class).checkSearchInputPlaceholderTextIsPresent("Найти решения");
        return this;
    }

    public FssSolutionsPage checkYellowPanelTipIsPresent() {
        getHelper(YellowPanel.class).checkTipIsPresent();
        return this;
    }

    public FssSolutionsPage checkYellowPanelTipQueryIsPresent() {
        getHelper(YellowPanel.class).checkTipQueryIsPresent();
        return this;
    }

    public FssSolutionsPage checkYellowPanelAnswerIsPresent() {
        getHelper(YellowPanel.class).checkAnswerIsPresent();
        return this;
    }

    public FssSolutionsPage checkYellowPanelLinkFromRecomendationIsPresent() {
        getHelper(YellowPanel.class).checkLinkFromRecomendationIsPresent();
        return this;
    }

    public FssSolutionsPage checkYellowPanelRubricatorLinksArePresent() {
        getHelper(YellowPanel.class).checkRubricatorLinksArePresent();
        return this;
    }

    public FssDocumentPage clickOnYellowPanelLinkFromRecomendation() {
        getHelper(YellowPanel.class).clickOnLinkFromRecomendation();
        return redirectTo(FssDocumentPage.class);
    }

    @Override
    public FssSolutionsPage checkNewsBlockFirstBlockTitleIsPresent() {
        getHelper(NewsBlock.class).checkFirstBlockTitleIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkNewsBlockNewsArePresent() {
        getHelper(NewsBlock.class).checkNewsArePresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkNewsBlockTodayTitleIsPresent() {
        getHelper(NewsBlock.class).checkTodayTitleIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkNewsBlockOnTheWeekTitleIsPresent() {
        getHelper(NewsBlock.class).checkOnTheWeekTitleIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkNewsBlockPerMonthTitleIsPresent() {
        getHelper(NewsBlock.class).checkPerMonthTitleIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkNewsBlockRecomendationNewsView() {
        getHelper(NewsBlock.class).checkRecomendationNewsView();
        return this;
    }

    @Override
    public FssSolutionsPage checkNewsBlockNewsWithTypeArePresent() {
        getHelper(NewsBlock.class).checkNewsWithTypeArePresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkNewsBlockLinksAllNewsArePresent() {
        getHelper(NewsBlock.class).checkLinksAllNewsArePresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkNewsBlockNewsLinks() {
        boolean hasNext = getHelper(NewsBlock.class).clickOnNewsLink();
        while (hasNext) {
            String documentUrl = String.valueOf(getParameter(SearchResultHelper.DOCUMENT_URL));
            postponedAssertTrue(getDriver().getCurrentUrl().contains(documentUrl) || documentUrl.contains(getDriver().getCurrentUrl()), "Ссылка на документ не совпадает:" +
                    getDriver().getCurrentUrl() + " " + documentUrl);
            returnToBack();
            hasNext = getHelper(NewsBlock.class).clickOnNewsLink();
        }
        return this;
    }

    @Override
    public FssNewsPage clickOnNewsBlockFirstBlockTitle() {
        getHelper(NewsBlock.class).clickOnFirstBlockTitle();
        return redirectTo(FssNewsPage.class);
    }

    @Override
    public FssNewsPage clickOnNewsBlockLinkAllNewsInFirstBlock() {
        getHelper(NewsBlock.class).clickOnLinkAllNewsInFirstBlock();
        return redirectTo(FssNewsPage.class);
    }

    @Override
    public FssNewsPage clickOnNewsBlockLinkAllNewsInSecondBlock() {
        getHelper(NewsBlock.class).clickOnLinkAllNewsInSecondBlock();
        return redirectTo(FssNewsPage.class);
    }

    @Override
    public FssSolutionsPage clearAllBookmarks() {
        removeAllBookmarksFromMenu();
        return this;
    }

    @Override
    public FssSolutionsPage checkFavoritesWidgetTitleIsPresent() {
        getHelper(FavoritesWidget.class).checkTitleIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkFavoritesWidgetTextFadeIsPresent() {
        getHelper(FavoritesWidget.class).checkTextFadeIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage addLinksToFavorites(String[][] documents) {
        try {
            TestUtils.addDocumentsToFavorites(documents, getDriver());
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Не удалось добавить ссылки в избранное" + e.getMessage());
        } catch (IOException e) {
            throw new IllegalStateException("Не удалось добавить ссылки в избранное" + e.getMessage());
        }
        return this;
    }

    @Override
    public FssSolutionsPage checkFavoritesWidgetFiveLinksArePresent() {
        getHelper(FavoritesWidget.class).checkFiveLinksArePresent();
        return this;
    }

    @Override
    public FssDocumentPage clickOnFavoritesWidgetFirstDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnFirstDocumentLink();
        return redirectTo(FssDocumentPage.class);
    }

    @Override
    public FssDocumentPage clickOnFavoritesWidgetSecondDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnSecondDocumentLink();
        return redirectTo(FssDocumentPage.class);
    }

    @Override
    public FssDocumentPage clickOnFavoritesWidgetThirdDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnThirdDocumentLink();
        return redirectTo(FssDocumentPage.class);
    }

    @Override
    public FssDocumentPage clickOnFavoritesWidgetFourthDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnFourthDocumentLink();
        return redirectTo(FssDocumentPage.class);
    }

    @Override
    public FssDocumentPage clickOnFavoritesWidgetFifthDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnFifthDocumentLink();
        return redirectTo(FssDocumentPage.class);
    }

    @Override
    public FssSolutionsPage clickOnFavoritesWidgetTitleLink() {
        getHelper(FavoritesWidget.class).clickOnFavoritesTitleLink();
        return this;
    }

    @Override
    public FssSolutionsPage removeDocumentsFromFavorites() {
        try {
            TestUtils.removeDocumentsFromFavorites(getDriver());
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Не удалось добавить ссылки в избранное" + e.getMessage());
        } catch (IOException e) {
            throw new IllegalStateException("Не удалось добавить ссылки в избранное" + e.getMessage());
        }
        return this;
    }

    @Override
    public FssSolutionsPage checkVideoWidgetHasNoTitle() {
        getHelper(VideoWidget.class).checkHasNoTitle();
        return this;
    }

    @Override
    public FssSolutionsPage checkVideoWidgetScreenshotIsPresent() {
        getHelper(VideoWidget.class).checkScreenshotIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkVideoWidgetLink() {
        getHelper(VideoWidget.class).checkLink();
        return this;
    }

    @Override
    public FssSolutionsPage checkVideoWidgetVideoDuration() {
        getHelper(VideoWidget.class).checkVideoDuration();
        return this;
    }

    @Override
    public FssDocumentPage clickOnVideoWidgetScreenshot() {
        getHelper(VideoWidget.class).clickOnScreenshot();
        return redirectTo(FssDocumentPage.class);
    }

    @Override
    public FssDocumentPage clickOnVideoWidgetLink() {
        getHelper(VideoWidget.class).clickOnLink();
        return redirectTo(FssDocumentPage.class);
    }

    @Override
    public FssSolutionsPage checkLawBaseBlockIsPresent() {
        getHelper(LawBaseWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkLawBaseWidgetTitleIsPresent() {
        getHelper(LawBaseWidget.class).checkTitleIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkKodeksOrderInLawBaseBlock() {
        getHelper(LawBaseWidget.class).checkCodes();
        return this;
    }

    @Override
    public FssSolutionsPage checkLawBaseWidgetSearchInputIsPresent() {
        getHelper(LawBaseWidget.class).checkSearchInputIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkLawBaseWidgetNewDocumentCounterIsPresent() {
        getHelper(LawBaseWidget.class).checkNewDocumentCounterIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkLawBaseWidgetLinksCodes() {
        getHelper(LawBaseWidget.class).checkLinksCodes();
        return this;
    }

    @Override
    public FssLawBasePage clickLawBaseWidgetLinkTitle() {
        getHelper(LawBaseWidget.class).clickLinkTitle();
        return redirectTo(FssLawBasePage.class);
    }

    @Override
    public FssLawBasePage clickLawBaseWidgetLinkNewDocumentCounter() {
        getHelper(LawBaseWidget.class).clickLinkNewDocumentCounter();
        return redirectTo(FssLawBasePage.class);
    }

    @Override
    public FssLawBasePage clickLawBaseWidgetLinkEnterIconOntoSearchInput() {
        getHelper(LawBaseWidget.class).clickLinkEnterIconOnSearchInput();
        return redirectTo(FssLawBasePage.class);
    }

    @Override
    public FssSolutionsPage inputLawBaseWidgetInSearch(String query) {
        getHelper(LawBaseWidget.class).inputInSearch(query);
        return this;
    }

    @Override
    public FssSolutionsPage checkLawBaseWidgetSearchResultsArePresent() {
        getHelper(LawBaseWidget.class).checkSearchResultsArePresent();
        return this;
    }

    @Override
    public FssDocumentPage clickLawBaseWidgetOnSearchResultsDirectDocument() {
        getHelper(LawBaseWidget.class).clickOnSearchResultsDirectDocument();
        return redirectTo(FssDocumentPage.class);
    }

    @Override
    public FssSearchResultPage clickLawBaseWidgetSearchResultsRandomHintLink() {
        getHelper(LawBaseWidget.class).clickSearchResultsRandomHintLink();
        return redirectTo(FssSearchResultPage.class);
    }

    @Override
    public FssSearchResultPage clickLawBaseWidgetIconEnterWithSearchQuery() {
        getHelper(LawBaseWidget.class).clickLinkEnterIconOnSearchInput();
        return redirectTo(FssSearchResultPage.class);
    }

    @Override
    public FssSolutionsPage checkMagazinesWidgetIsPresent() {
        getHelper(MagazinesWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkMagazinesWidgetTitleIsPresent() {
        getHelper(MagazinesWidget.class).checkTitleIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkMagazinesWidgetMagazinesCoversIsPresent() {
        getHelper(MagazinesWidget.class).checkMagazinesCoversIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkMagazinesWidgetMagazinesAreNotRepeated() {
        getHelper(MagazinesWidget.class).checkMagazinesAreNotRepeated();
        return this;
    }

    @Override
    public FssSolutionsPage checkMagazinesWidgetRedMarkerIsPresent() {
        getHelper(MagazinesWidget.class).checkRedMarkerForNewMagazine();
        return this;
    }

    @Override
    public FssSolutionsPage checkMagazinesWidgetTextNewMagazineIsPresent() {
        getHelper(MagazinesWidget.class).checkTextNewMagazineIsPresent();
        return this;
    }

    @Override
    public FssMagazinesPage clickOnMagazinesWidgetTitle() {
        getHelper(MagazinesWidget.class).clickOnTitle();
        return redirectTo(FssMagazinesPage.class);
    }

    @Override
    public FssDocumentPage clickOnMagazinesWidgetNotice() {
        getHelper(MagazinesWidget.class).clickOnNotice();
        return redirectTo(FssDocumentPage.class);
    }

    @Override
    public FssSolutionsPage checkMagazinesWidgetMagazinesLinks() {
        getHelper(MagazinesWidget.class).checkMagazinesLinks();
        return this;
    }

    @Override
    public FssSolutionsPage checkMagazinesWidgetMagazinesCoversWithVariantResolutions() {
        getHelper(MagazinesWidget.class).checkMagazinesCoversWithVariantResolutions();
        return this;
    }

    public FssSolutionsPage checkBannerIsPresent() {
        getHelper(BannerBlock.class).checkWidgetIsPresent();
        return this;
    }

    public FssSolutionsPage clickOnBanner() {
        getHelper(BannerBlock.class).clickOnBanner();
        return this;
    }

    public FssSolutionsPage checkDocumentAfterClickingOnBanner() {
        String documentUrl = String.valueOf(getParameter(SearchResultHelper.DOCUMENT_URL));
        postponedAssertTrue(getDriver().getCurrentUrl().contains(documentUrl), "URL не совпадают, actual:" +
                getDriver().getCurrentUrl() + " expected:" + documentUrl);
        return this;
    }

    public FssSolutionsPage checkBannerTextWithScreenResolution1024px() {
        getHelper(BannerBlock.class).checkBannerTextWithScreenResolution1024px();
        return this;
    }

    public FssSolutionsPage checkBannerTextWithScreenResolution1280px() {
        getHelper(BannerBlock.class).checkBannerTextWithScreenResolution1280px();
        return this;
    }

    public FssSolutionsPage checkBannerTextWithScreenResolution1366px() {
        getHelper(BannerBlock.class).checkBannerTextWithScreenResolution1366px();
        return this;
    }

    @Override
    public FssSolutionsPage checkFormsBlockIsPresent() {
        getHelper(FormsWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkFormsWidgetTitleIsPresent() {
        getHelper(FormsWidget.class).checkTitleIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkFormsBlockIsNotEmpty() {
        getHelper(FormsWidget.class).checkWidgetIsNotEmpty();
        return this;
    }

    @Override
    public FssSolutionsPage checkFormsWidgetSearchInputIsPresent() {
        getHelper(FormsWidget.class).checkSearchInputIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkFormsWidgetNewDocumentCounterIsPresent() {
        getHelper(FormsWidget.class).checkNewDocumentCounterIsPresent();
        return this;
    }

    @Override
    public FssSolutionsPage checkFormsWidgetExamplesFormsIsPresent() {
        getHelper(FormsWidget.class).checkExamplesFormsIsPresent();
        return this;
    }

    public FssDocumentPage clickFormsWidgetRedLink() {
        getHelper(FormsWidget.class).clickOnRedLink();
        return redirectTo(FssDocumentPage.class);
    }

    public FssDocumentPage clickFormsWidgetGreenLink() {
        getHelper(FormsWidget.class).clickOnGreenLink();
        return redirectTo(FssDocumentPage.class);
    }

    public FssDocumentPage clickFormsWidgetBlueLink() {
        getHelper(FormsWidget.class).clickOnBlueLink();
        return redirectTo(FssDocumentPage.class);
    }

    public FssDocumentPage clickFormsWidgetYellowLink() {
        getHelper(FormsWidget.class).clickOnYellowLink();
        return redirectTo(FssDocumentPage.class);
    }

    @Override
    public FssFormsPage clickFormsLink() {
        getHelper(FormsWidget.class).clickOnTitle();
        return redirectTo(FssFormsPage.class);
    }

    @Override
    public FssFormsPage clickFormsWidgetLinkNewDocumentCounter() {
        getHelper(FormsWidget.class).clickLinkNewDocumentCounter();
        return redirectTo(FssFormsPage.class);
    }

    @Override
    public FssFormsPage clickFormsWidgetLinkEnterIconOntoSearchInput() {
        getHelper(FormsWidget.class).clickLinkEnterIconOnSearchInput();
        return redirectTo(FssFormsPage.class);
    }

    @Override
    public FssSolutionsPage inputFormsWidgetInSearch(String query) {
        getHelper(FormsWidget.class).inputInSearch(query);
        return this;
    }

    @Override
    public FssSolutionsPage checkFormsWidgetSearchResultsArePresent() {
        getHelper(FormsWidget.class).checkSearchResultsArePresent();
        return this;
    }

    @Override
    public FssDocumentPage clickFormsWidgetOnSearchResultsDirectDocument() {
        getHelper(FormsWidget.class).clickOnSearchResultsDirectDocument();
        return redirectTo(FssDocumentPage.class);
    }

    @Override
    public FssSearchResultPage clickFormsWidgetSearchResultsRandomHintLink() {
        getHelper(FormsWidget.class).clickSearchResultsRandomHintLink();
        return redirectTo(FssSearchResultPage.class);
    }

    @Override
    public FssSearchResultPage clickFormsWidgetIconEnterWithSearchQuery() {
        getHelper(FormsWidget.class).clickLinkEnterIconOnSearchInput();
        return redirectTo(FssSearchResultPage.class);
    }

    public FssSolutionsPage checkServicesWidgetThreeLinksArePresent() {
        getHelper(ServicesWidget.class).checkThreeLinksArePresent();
        return this;
    }

    public FssSolutionsPage checkServicesWidgetTitleIsPresent() {
        getHelper(ServicesWidget.class).checkTitleIsPresent();
        return this;
    }

    public FssDocumentPage clickOnServicesWidgetFinanceLink() {
        getHelper(ServicesWidget.class).clickOnFinanceLink();
        return redirectTo(FssDocumentPage.class);
    }

    public FssDocumentPage clickOnServicesWidgetBudgetLink() {
        getHelper(ServicesWidget.class).clickOnBudgetLink();
        return redirectTo(FssDocumentPage.class);
    }

    public FssDocumentPage clickOnServicesWidgetExcelLink() {
        getHelper(ServicesWidget.class).clickOnExcelLink();
        return redirectTo(FssDocumentPage.class);
    }

    public FssServicesPage clickOnServicesWidgetTitleLink() {
        getHelper(ServicesWidget.class).clickOnTitle();
        return redirectTo(FssServicesPage.class);
    }

    @Override
    @Step("Проверяется что ссылка 'Написать Эксперту' не отображается")
    public FssSolutionsPage checkHotLineLinkIsNotPresent() {
        postponedAssertNull(findElementByNoThrow(By.className("[href*='/#/hotline/']")), "Ссылка 'Написать Эксперту' отображается");
        return this;
    }
}
