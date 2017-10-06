package com.actionmedia.pages.cult;

import com.actionmedia.components.widgets.*;
import com.actionmedia.components.widgets.recomendation.*;
import com.actionmedia.pages.helpers.SearchResultHelper;
import com.actionmedia.pages.interfaces.IRecomendPage;
import com.actionmedia.util.TestUtils;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by Pavel on 28/06/16.
 */
@Component
public class CultRecomendPage extends CultBasePage<CultRecomendPage> implements IRecomendPage {

    @Override
    public CultRecomendPage checkYellowPanelIsPresent() {
        getHelper(YellowPanel.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkHandbookWidgetIsPresent() {
        getHelper(HandbookWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkFormsWidgetIsPresent() {
        getHelper(FormsWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkLawBaseWidgetIsPresent() {
        getHelper(LawBaseWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkMagazinesWidgetIsPresent() {
        getHelper(MagazinesWidget.class).checkWidgetIsPresent();
        return this;
    }

    public CultRecomendPage checkMagazinesWidgetIsNotPresent() {
        getHelper(MagazinesWidget.class).checkWidgetIsNotPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkVideoWidgetIsPresent() {
        getHelper(VideoWidget.class).checkWidgetIsPresent();
        return this;
    }

    public CultRecomendPage checkVideoWidgetIsNotPresent() {
        getHelper(VideoWidget.class).checkWidgetIsNotPresent();
        return this;
    }

    public CultRecomendPage checkHighSchoolCAWidgetIsPresent() {
        getHelper(SchoolWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkFavoritesWidgetIsPresent() {
        getHelper(FavoritesWidget.class).checkWidgetIsPresent();
        return this;
    }

    public CultRecomendPage checkFavoritesWidgetIsNotPresent() {
        getHelper(FavoritesWidget.class).checkWidgetIsNotPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkWorkingDaysWidgetIsPresent() {
        getHelper(WorkingDaysWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkWeekendDaysWidgetIsPresent() {
        getHelper(WeekendDaysWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkNewsBlockIsPresent() {
        getHelper(NewsBlock.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkHandbookWidgetTitleIsPresent() {
        getHelper(HandbookWidget.class).checkTitleIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkHandbookWidgetDocumentCountIsPresent() {
        getHelper(HandbookWidget.class).checkDocumentCountIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkHandbookWidgetDateTodayIsPresent() {
        getHelper(HandbookWidget.class).checkDateTodayIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkHandbookWidgetMonthNowIsPresent() {
        getHelper(HandbookWidget.class).checkMonthNowIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkHandbookWidgetWorkingDaysElementIsPresent() {
        getHelper(HandbookWidget.class).checkWorkingDaysElementIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkHandbookWidgetHolidaysElementIsPresent() {
        getHelper(HandbookWidget.class).checkHolidaysElementIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkHandbookWidgetExchangeRatesTitleIsPresent() {
        getHelper(HandbookWidget.class).checkExchangeRatesTitleIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkHandbookWidgetDollarRateIsPresent() {
        getHelper(HandbookWidget.class).checkDollarRateIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkHandbookWidgetEuroRateIsPresent() {
        getHelper(HandbookWidget.class).checkEuroRateIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkHandbookWidgetMinimunWageTitleIsPresent() {
        getHelper(HandbookWidget.class).checkMinimunWageTitleIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkHandbookWidgetWageIsPresent() {
        getHelper(HandbookWidget.class).checkWageIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkHandbookWidgetLinkInRegionIsPresent() {
        getHelper(HandbookWidget.class).checkLinkInRegionIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkHandbookWidgetLinkRubricIsPresent() {
        getHelper(HandbookWidget.class).checkLinkRubricIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkHandbookWidgetChangesIsPresent() {
        getHelper(HandbookWidget.class).checkLinkChangesIsPresent();
        return this;
    }

    @Override
    public CultDictionaryPage clickOnHandbookWidgetTitle() {
        getHelper(HandbookWidget.class).clickOnTitle();
        return redirectTo(CultDictionaryPage.class);
    }

    @Override
    public CultDocumentPage clickOnHandbookWidgetCalendar() {
        getHelper(HandbookWidget.class).clickOnCalendar();
        return redirectTo(CultDocumentPage.class);
    }

    @Override
    public CultDocumentPage clickOnHandbookWidgetExchangeRatesBlock() {
        getHelper(HandbookWidget.class).clickOnExchangeRatesBlock();
        return redirectTo(CultDocumentPage.class);
    }

    @Override
    public CultDocumentPage clickOnHandbookWidgetRubricLink() {
        getHelper(HandbookWidget.class).clickOnRubricLink();
        return redirectTo(CultDocumentPage.class);
    }

    @Override
    public CultDocumentPage clickOnHandbookWidgetChangesLink() {
        getHelper(HandbookWidget.class).clickOnRubricLink();
        return redirectTo(CultDocumentPage.class);
    }

    public CultRecomendPage checkYellowPanelSearchInputIsPresent() {
        getHelper(YellowPanel.class).checkSearchInputIsPresent();
        return this;
    }

    public CultRecomendPage checkYellowPanelSearchInputPlaceholderTextIsPresent() {
        getHelper(YellowPanel.class).checkSearchInputPlaceholderTextIsPresent();
        return this;
    }

    public CultRecomendPage checkYellowPanelTipIsPresent() {
        getHelper(YellowPanel.class).checkTipIsPresent();
        return this;
    }

    public CultRecomendPage checkYellowPanelTipQueryIsPresent() {
        getHelper(YellowPanel.class).checkTipQueryIsPresent();
        return this;
    }

    public CultRecomendPage checkYellowPanelAnswerIsPresent() {
        getHelper(YellowPanel.class).checkAnswerIsPresent();
        return this;
    }

    public CultRecomendPage checkYellowPanelLinkFromRecomendationIsPresent() {
        getHelper(YellowPanel.class).checkLinkFromRecomendationIsPresent();
        return this;
    }

    public CultRecomendPage checkYellowPanelRubricatorLinksArePresent() {
        getHelper(YellowPanel.class).checkRubricatorLinksArePresent();
        return this;
    }

    public CultDocumentPage clickOnYellowPanelLinkFromRecomendation() {
        getHelper(YellowPanel.class).clickOnLinkFromRecomendation();
        return redirectTo(CultDocumentPage.class);
    }

    @Override
    public CultRecomendPage checkNewsBlockFirstBlockTitleIsPresent() {
        getHelper(NewsBlock.class).checkFirstBlockTitleIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkNewsBlockNewsArePresent() {
        getHelper(NewsBlock.class).checkNewsArePresent();
        return this;
    }

    @Override
    public CultRecomendPage checkNewsBlockTodayTitleIsPresent() {
        getHelper(NewsBlock.class).checkTodayTitleIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkNewsBlockOnTheWeekTitleIsPresent() {
        getHelper(NewsBlock.class).checkOnTheWeekTitleIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkNewsBlockPerMonthTitleIsPresent() {
        getHelper(NewsBlock.class).checkPerMonthTitleIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkNewsBlockRecomendationNewsView() {
        getHelper(NewsBlock.class).checkRecomendationNewsView();
        return this;
    }

    @Override
    public CultRecomendPage checkNewsBlockNewsWithTypeArePresent() {
        getHelper(NewsBlock.class).checkNewsWithTypeArePresent();
        return this;
    }

    @Override
    public CultRecomendPage checkNewsBlockLinksAllNewsArePresent() {
        getHelper(NewsBlock.class).checkLinksAllNewsArePresent();
        return this;
    }

    @Override
    public CultRecomendPage checkNewsBlockNewsLinks() {
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
    public CultNewsPage clickOnNewsBlockFirstBlockTitle() {
        getHelper(NewsBlock.class).clickOnFirstBlockTitle();
        return redirectTo(CultNewsPage.class);
    }

    @Override
    public CultNewsPage clickOnNewsBlockLinkAllNewsInFirstBlock() {
        getHelper(NewsBlock.class).clickOnLinkAllNewsInFirstBlock();
        return redirectTo(CultNewsPage.class);
    }

    @Override
    public CultNewsPage clickOnNewsBlockLinkAllNewsInSecondBlock() {
        getHelper(NewsBlock.class).clickOnLinkAllNewsInSecondBlock();
        return redirectTo(CultNewsPage.class);
    }

    @Override
    public CultRecomendPage clearAllBookmarks() {
        removeAllBookmarksFromMenu();
        return this;
    }

    @Override
    public CultRecomendPage checkFavoritesWidgetTitleIsPresent() {
        getHelper(FavoritesWidget.class).checkTitleIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkFavoritesWidgetTextFadeIsPresent() {
        getHelper(FavoritesWidget.class).checkTextFadeIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage addLinksToFavorites(String[][] documents) {
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
    public CultRecomendPage checkFavoritesWidgetFiveLinksArePresent() {
        getHelper(FavoritesWidget.class).checkFiveLinksArePresent();
        return this;
    }

    @Override
    public CultDocumentPage clickOnFavoritesWidgetFirstDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnFirstDocumentLink();
        return redirectTo(CultDocumentPage.class);
    }

    @Override
    public CultDocumentPage clickOnFavoritesWidgetSecondDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnSecondDocumentLink();
        return redirectTo(CultDocumentPage.class);
    }

    @Override
    public CultDocumentPage clickOnFavoritesWidgetThirdDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnThirdDocumentLink();
        return redirectTo(CultDocumentPage.class);
    }

    @Override
    public CultDocumentPage clickOnFavoritesWidgetFourthDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnFourthDocumentLink();
        return redirectTo(CultDocumentPage.class);
    }

    @Override
    public CultDocumentPage clickOnFavoritesWidgetFifthDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnFifthDocumentLink();
        return redirectTo(CultDocumentPage.class);
    }

    @Override
    public CultRecomendPage clickOnFavoritesWidgetTitleLink() {
        getHelper(FavoritesWidget.class).clickOnFavoritesTitleLink();
        return this;
    }

    @Override
    public CultRecomendPage removeDocumentsFromFavorites() {
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
    public CultRecomendPage checkVideoWidgetHasNoTitle() {
        getHelper(VideoWidget.class).checkHasNoTitle();
        return this;
    }

    @Override
    public CultRecomendPage checkVideoWidgetScreenshotIsPresent() {
        getHelper(VideoWidget.class).checkScreenshotIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkVideoWidgetLink() {
        getHelper(VideoWidget.class).checkLink();
        return this;
    }

    @Override
    public CultRecomendPage checkVideoWidgetVideoDuration() {
        getHelper(VideoWidget.class).checkVideoDuration();
        return this;
    }

    @Override
    public CultDocumentPage clickOnVideoWidgetScreenshot() {
        getHelper(VideoWidget.class).clickOnScreenshot();
        return redirectTo(CultDocumentPage.class);
    }

    @Override
    public CultDocumentPage clickOnVideoWidgetLink() {
        getHelper(VideoWidget.class).clickOnLink();
        return redirectTo(CultDocumentPage.class);
    }

    @Override
    public CultRecomendPage checkLawBaseBlockIsPresent() {
        getHelper(LawBaseWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkLawBaseWidgetTitleIsPresent() {
        getHelper(LawBaseWidget.class).checkTitleIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkKodeksOrderInLawBaseBlock() {
        getHelper(LawBaseWidget.class).checkCodes();
        return this;
    }

    @Override
    public CultRecomendPage checkLawBaseWidgetSearchInputIsPresent() {
        getHelper(LawBaseWidget.class).checkSearchInputIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkLawBaseWidgetNewDocumentCounterIsPresent() {
        getHelper(LawBaseWidget.class).checkNewDocumentCounterIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkLawBaseWidgetLinksCodes() {
        getHelper(LawBaseWidget.class).checkLinksCodes();
        return this;
    }

    @Override
    public CultLawBasePage clickLawBaseWidgetLinkTitle() {
        getHelper(LawBaseWidget.class).clickLinkTitle();
        return redirectTo(CultLawBasePage.class);
    }

    @Override
    public CultLawBasePage clickLawBaseWidgetLinkNewDocumentCounter() {
        getHelper(LawBaseWidget.class).clickLinkNewDocumentCounter();
        return redirectTo(CultLawBasePage.class);
    }

    @Override
    public CultLawBasePage clickLawBaseWidgetLinkEnterIconOntoSearchInput() {
        getHelper(LawBaseWidget.class).clickLinkEnterIconOnSearchInput();
        return redirectTo(CultLawBasePage.class);
    }

    @Override
    public CultRecomendPage inputLawBaseWidgetInSearch(String query) {
        getHelper(LawBaseWidget.class).inputInSearch(query);
        return this;
    }

    @Override
    public CultRecomendPage checkLawBaseWidgetSearchResultsArePresent() {
        getHelper(LawBaseWidget.class).checkSearchResultsArePresent();
        return this;
    }

    @Override
    public CultDocumentPage clickLawBaseWidgetOnSearchResultsDirectDocument() {
        getHelper(LawBaseWidget.class).clickOnSearchResultsDirectDocument();
        return redirectTo(CultDocumentPage.class);
    }

    @Override
    public CultSearchResultPage clickLawBaseWidgetSearchResultsRandomHintLink() {
        getHelper(LawBaseWidget.class).clickSearchResultsRandomHintLink();
        return redirectTo(CultSearchResultPage.class);
    }

    @Override
    public CultSearchResultPage clickLawBaseWidgetIconEnterWithSearchQuery() {
        getHelper(LawBaseWidget.class).clickLinkEnterIconOnSearchInput();
        return redirectTo(CultSearchResultPage.class);
    }

    @Override
    public CultRecomendPage checkMagazinesWidgetTitleIsPresent() {
        getHelper(MagazinesWidget.class).checkTitleIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkMagazinesWidgetMagazinesCoversIsPresent() {
        getHelper(MagazinesWidget.class).checkMagazinesCoversIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkMagazinesWidgetMagazinesAreNotRepeated() {
        getHelper(MagazinesWidget.class).checkMagazinesAreNotRepeated();
        return this;
    }

    @Override
    public CultRecomendPage checkMagazinesWidgetRedMarkerIsPresent() {
        getHelper(MagazinesWidget.class).checkRedMarkerForNewMagazine();
        return this;
    }

    @Override
    public CultRecomendPage checkMagazinesWidgetTextNewMagazineIsPresent() {
        getHelper(MagazinesWidget.class).checkTextNewMagazineIsPresent();
        return this;
    }

    @Override
    public CultMagazinesPage clickOnMagazinesWidgetTitle() {
        getHelper(MagazinesWidget.class).clickOnTitle();
        return redirectTo(CultMagazinesPage.class);
    }

    @Override
    public CultDocumentPage clickOnMagazinesWidgetNotice() {
        getHelper(MagazinesWidget.class).clickOnNotice();
        return redirectTo(CultDocumentPage.class);
    }

    @Override
    public CultRecomendPage checkMagazinesWidgetMagazinesLinks() {
        getHelper(MagazinesWidget.class).checkMagazinesLinks();
        return this;
    }

    @Override
    public CultRecomendPage checkMagazinesWidgetMagazinesCoversWithVariantResolutions() {
        getHelper(MagazinesWidget.class).checkMagazinesCoversWithVariantResolutions();
        return this;
    }

    public CultRecomendPage checkBannerIsPresent() {
        getHelper(BannerBlock.class).checkWidgetIsPresent();
        return this;
    }

    public CultRecomendPage clickOnBanner() {
        getHelper(BannerBlock.class).clickOnBanner();
        return this;
    }

    public CultRecomendPage checkDocumentAfterClickingOnBanner() {
        String documentUrl = String.valueOf(getParameter(SearchResultHelper.DOCUMENT_URL));
        postponedAssertTrue(getDriver().getCurrentUrl().contains(documentUrl), "URL не совпадают, actual:" +
                getDriver().getCurrentUrl() + " expected:" + documentUrl);
        return this;
    }

    public CultRecomendPage checkBannerTextWithScreenResolution1024px() {
        getHelper(BannerBlock.class).checkBannerTextWithScreenResolution1024px();
        return this;
    }

    public CultRecomendPage checkBannerTextWithScreenResolution1280px() {
        getHelper(BannerBlock.class).checkBannerTextWithScreenResolution1280px();
        return this;
    }

    public CultRecomendPage checkBannerTextWithScreenResolution1366px() {
        getHelper(BannerBlock.class).checkBannerTextWithScreenResolution1366px();
        return this;
    }

    @Override
    public CultRecomendPage checkFormsBlockIsPresent() {
        getHelper(FormsWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkFormsWidgetTitleIsPresent() {
        getHelper(FormsWidget.class).checkTitleIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkFormsBlockIsNotEmpty() {
        getHelper(FormsWidget.class).checkWidgetIsNotEmpty();
        return this;
    }

    @Override
    public CultRecomendPage checkFormsWidgetSearchInputIsPresent() {
        getHelper(FormsWidget.class).checkSearchInputIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkFormsWidgetNewDocumentCounterIsPresent() {
        getHelper(FormsWidget.class).checkNewDocumentCounterIsPresent();
        return this;
    }

    @Override
    public CultRecomendPage checkFormsWidgetExamplesFormsIsPresent() {
        getHelper(FormsWidget.class).checkExamplesFormsIsPresent();
        return this;
    }

    public CultDocumentPage clickFormsWidgetRedLink() {
        getHelper(FormsWidget.class).clickOnRedLink();
        return redirectTo(CultDocumentPage.class);
    }

    public CultDocumentPage clickFormsWidgetGreenLink() {
        getHelper(FormsWidget.class).clickOnGreenLink();
        return redirectTo(CultDocumentPage.class);
    }

    public CultDocumentPage clickFormsWidgetBlueLink() {
        getHelper(FormsWidget.class).clickOnBlueLink();
        return redirectTo(CultDocumentPage.class);
    }

    public CultDocumentPage clickFormsWidgetYellowLink() {
        getHelper(FormsWidget.class).clickOnYellowLink();
        return redirectTo(CultDocumentPage.class);
    }

    @Override
    public CultFormsPage clickFormsLink() {
        getHelper(FormsWidget.class).clickOnTitle();
        return redirectTo(CultFormsPage.class);
    }

    @Override
    public CultFormsPage clickFormsWidgetLinkNewDocumentCounter() {
        getHelper(FormsWidget.class).clickLinkNewDocumentCounter();
        return redirectTo(CultFormsPage.class);
    }

    @Override
    public CultFormsPage clickFormsWidgetLinkEnterIconOntoSearchInput() {
        getHelper(FormsWidget.class).clickLinkEnterIconOnSearchInput();
        return redirectTo(CultFormsPage.class);
    }

    @Override
    public CultRecomendPage inputFormsWidgetInSearch(String query) {
        getHelper(FormsWidget.class).inputInSearch(query);
        return this;
    }

    @Override
    public CultRecomendPage checkFormsWidgetSearchResultsArePresent() {
        getHelper(FormsWidget.class).checkSearchResultsArePresent();
        return this;
    }

    @Override
    public CultDocumentPage clickFormsWidgetOnSearchResultsDirectDocument() {
        getHelper(FormsWidget.class).clickOnSearchResultsDirectDocument();
        return redirectTo(CultDocumentPage.class);
    }

    @Override
    public CultSearchResultPage clickFormsWidgetSearchResultsRandomHintLink() {
        getHelper(FormsWidget.class).clickSearchResultsRandomHintLink();
        return redirectTo(CultSearchResultPage.class);
    }

    @Override
    public CultSearchResultPage clickFormsWidgetIconEnterWithSearchQuery() {
        getHelper(FormsWidget.class).clickLinkEnterIconOnSearchInput();
        return redirectTo(CultSearchResultPage.class);
    }

    @Override
    @Step("Проверяется что ссылка 'Написать Эксперту' не отображается")
    public CultRecomendPage checkHotLineLinkIsNotPresent() {
        postponedAssertNull(findElementByNoThrow(By.className("[href*='/#/hotline/']")), "Ссылка 'Написать Эксперту' отображается");
        return this;
    }
}
