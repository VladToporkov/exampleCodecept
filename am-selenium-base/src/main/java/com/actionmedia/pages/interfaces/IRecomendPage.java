package com.actionmedia.pages.interfaces;

import com.actionmedia.pages.ot.OtRecomendPage;

/**
 * Created by Pavel on 28/06/16.
 */
public interface IRecomendPage extends ISystemBasePage {

    IRecomendPage checkFormsWidgetIsPresent();

    IRecomendPage checkLawBaseWidgetIsPresent();

    IRecomendPage checkWorkingDaysWidgetIsPresent();

    IRecomendPage checkWeekendDaysWidgetIsPresent();

    IRecomendPage checkNewsBlockIsPresent();

    IRecomendPage checkMyFavoritesRubricatorButtonIsPresent();

    IRecomendPage checkRubricatorButtonIsPresent(String name);

    IRecomendPage checkHandbookWidgetIsPresent();

    IRecomendPage checkHandbookWidgetTitleIsPresent();

    IRecomendPage checkHandbookWidgetDocumentCountIsPresent();

    IRecomendPage checkHandbookWidgetDateTodayIsPresent();

    IRecomendPage checkHandbookWidgetMonthNowIsPresent();

    IRecomendPage checkHandbookWidgetWorkingDaysElementIsPresent();

    IRecomendPage checkHandbookWidgetHolidaysElementIsPresent();

    IRecomendPage checkHandbookWidgetExchangeRatesTitleIsPresent();

    IRecomendPage checkHandbookWidgetDollarRateIsPresent();

    IRecomendPage checkHandbookWidgetEuroRateIsPresent();

    IRecomendPage checkHandbookWidgetMinimunWageTitleIsPresent();

    IRecomendPage checkHandbookWidgetWageIsPresent();

    IRecomendPage checkHandbookWidgetLinkInRegionIsPresent();

    IRecomendPage checkHandbookWidgetLinkRubricIsPresent();

    IRecomendPage checkHandbookWidgetChangesIsPresent();

    IDictionaryPage clickOnHandbookWidgetTitle();

    IDocumentPage clickOnHandbookWidgetCalendar();

    IDocumentPage clickOnHandbookWidgetExchangeRatesBlock();

    IDocumentPage clickOnHandbookWidgetRubricLink();

    IDocumentPage clickOnHandbookWidgetChangesLink();

    IRecomendPage checkYellowPanelIsPresent();

    IRecomendPage checkYellowPanelSearchInputIsPresent();

    IRecomendPage checkYellowPanelSearchInputPlaceholderTextIsPresent();

    IRecomendPage checkYellowPanelTipIsPresent();

    IRecomendPage checkYellowPanelTipQueryIsPresent();

    IRecomendPage checkYellowPanelAnswerIsPresent();

    IRecomendPage checkYellowPanelLinkFromRecomendationIsPresent();

    IRecomendPage checkYellowPanelRubricatorLinksArePresent();

    IDocumentPage clickOnYellowPanelLinkFromRecomendation();

    IRecomendPage checkRubricatorLinksFromYellowPlate();

    IRecomendPage checkNewsBlockFirstBlockTitleIsPresent();

    IRecomendPage checkNewsBlockNewsArePresent();

    IRecomendPage checkNewsBlockTodayTitleIsPresent();

    IRecomendPage checkNewsBlockOnTheWeekTitleIsPresent();

    IRecomendPage checkNewsBlockPerMonthTitleIsPresent();

    IRecomendPage checkNewsBlockRecomendationNewsView();

    IRecomendPage checkNewsBlockNewsWithTypeArePresent();

    IRecomendPage checkNewsBlockLinksAllNewsArePresent();

    IRecomendPage checkNewsBlockNewsLinks();

    INewsPage clickOnNewsBlockFirstBlockTitle();

    INewsPage clickOnNewsBlockLinkAllNewsInFirstBlock();

    INewsPage clickOnNewsBlockLinkAllNewsInSecondBlock();

    IRecomendPage clickMyFavoritesButton();

    IRecomendPage clearAllBookmarks();

    IRecomendPage checkFavoritesWidgetIsPresent();

    IRecomendPage checkFavoritesWidgetTitleIsPresent();

    IRecomendPage checkFavoritesWidgetTextFadeIsPresent();

    IRecomendPage addLinksToFavorites(String[][] documents);

    IRecomendPage refreshPage();

    IRecomendPage checkFavoritesWidgetFiveLinksArePresent();

    IDocumentPage clickOnFavoritesWidgetFirstDocumentLink();

    IDocumentPage clickOnFavoritesWidgetSecondDocumentLink();

    IDocumentPage clickOnFavoritesWidgetThirdDocumentLink();

    IDocumentPage clickOnFavoritesWidgetFourthDocumentLink();

    IDocumentPage clickOnFavoritesWidgetFifthDocumentLink();

    IRecomendPage clickOnFavoritesWidgetTitleLink();

    IRecomendPage checkFavoritesRubricatorIsPresent();

    IRecomendPage removeDocumentsFromFavorites();

    IRecomendPage checkFavoritesWidgetIsNotPresent();

    IRecomendPage removeAllTrainingHands();

    IRecomendPage checkVideoWidgetIsPresent();

    IRecomendPage checkVideoWidgetHasNoTitle();

    IRecomendPage checkVideoWidgetScreenshotIsPresent();

    IRecomendPage checkVideoWidgetLink();

    IRecomendPage checkVideoWidgetVideoDuration();

    IDocumentPage clickOnVideoWidgetScreenshot();

    IDocumentPage clickOnVideoWidgetLink();

    IRecomendPage checkLawBaseBlockIsPresent();

    IRecomendPage checkLawBaseWidgetTitleIsPresent();

    IRecomendPage checkKodeksOrderInLawBaseBlock();

    IRecomendPage checkLawBaseWidgetSearchInputIsPresent();

    IRecomendPage checkLawBaseWidgetNewDocumentCounterIsPresent();

    IRecomendPage checkLawBaseWidgetLinksCodes();

    ILawBasePage clickLawBaseWidgetLinkTitle();

    ILawBasePage clickLawBaseWidgetLinkNewDocumentCounter();

    ILawBasePage clickLawBaseWidgetLinkEnterIconOntoSearchInput();

    IRecomendPage inputLawBaseWidgetInSearch(String query);

    IRecomendPage checkLawBaseWidgetSearchResultsArePresent();

    IDocumentPage clickLawBaseWidgetOnSearchResultsDirectDocument();

    ISearchResultPage clickLawBaseWidgetSearchResultsRandomHintLink();

    ISearchResultPage clickLawBaseWidgetIconEnterWithSearchQuery();

    IRecomendPage checkMagazinesWidgetIsPresent();

    IRecomendPage checkMagazinesWidgetTitleIsPresent();

    IRecomendPage checkMagazinesWidgetMagazinesCoversIsPresent();

    IRecomendPage checkMagazinesWidgetMagazinesAreNotRepeated();

    IRecomendPage checkMagazinesWidgetRedMarkerIsPresent();

    IRecomendPage checkMagazinesWidgetTextNewMagazineIsPresent();

    IMagazinesPage clickOnMagazinesWidgetTitle();

    IDocumentPage clickOnMagazinesWidgetNotice();

    IRecomendPage checkMagazinesWidgetMagazinesLinks();

    IRecomendPage checkMagazinesWidgetMagazinesCoversWithVariantResolutions();

    IRecomendPage checkBannerIsPresent();

    IRecomendPage clickOnBanner();

    IRecomendPage checkDocumentAfterClickingOnBanner();

    IRecomendPage returnToBack();

    IRecomendPage checkBannerTextWithScreenResolution1024px();

    IRecomendPage checkBannerTextWithScreenResolution1280px();

    IRecomendPage checkBannerTextWithScreenResolution1366px();

    IRecomendPage checkFormsBlockIsPresent();

    IRecomendPage checkFormsWidgetTitleIsPresent();

    IRecomendPage checkFormsBlockIsNotEmpty();

    IRecomendPage checkFormsWidgetSearchInputIsPresent();

    IRecomendPage checkFormsWidgetNewDocumentCounterIsPresent();

    IRecomendPage checkFormsWidgetExamplesFormsIsPresent();

    IDocumentPage clickFormsWidgetRedLink();

    IDocumentPage clickFormsWidgetGreenLink();

    IDocumentPage clickFormsWidgetBlueLink();

    IDocumentPage clickFormsWidgetYellowLink();

    IFormsPage clickFormsLink();

    IFormsPage clickFormsWidgetLinkNewDocumentCounter();

    IFormsPage clickFormsWidgetLinkEnterIconOntoSearchInput();

    IRecomendPage inputFormsWidgetInSearch(String query);

    IRecomendPage checkFormsWidgetSearchResultsArePresent();

    IDocumentPage clickFormsWidgetOnSearchResultsDirectDocument();

    ISearchResultPage clickFormsWidgetSearchResultsRandomHintLink();

    ISearchResultPage clickFormsWidgetIconEnterWithSearchQuery();

    IRecomendPage checkHotLineLinkIsNotPresent();
}
