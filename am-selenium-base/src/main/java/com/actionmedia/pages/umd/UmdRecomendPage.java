package com.actionmedia.pages.umd;

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
 * Created by Pavel on 29/06/16.
 */
@Component
public class UmdRecomendPage extends UmdBasePage<UmdRecomendPage> implements IRecomendPage {

    @Override
    public UmdRecomendPage checkYellowPanelIsPresent() {
        getHelper(YellowPanel.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkHandbookWidgetIsPresent() {
        getHelper(HandbookWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkFormsWidgetIsPresent() {
        getHelper(FormsWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkLawBaseWidgetIsPresent() {
        getHelper(LawBaseWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkMagazinesWidgetIsPresent() {
        getHelper(MagazinesWidget.class).checkWidgetIsPresent();
        return this;
    }

    public UmdRecomendPage checkMagazinesWidgetIsNotPresent() {
        getHelper(MagazinesWidget.class).checkWidgetIsNotPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkVideoWidgetIsPresent() {
        getHelper(VideoWidget.class).checkWidgetIsPresent();
        return this;
    }

    public UmdRecomendPage checkVideoWidgetIsNotPresent() {
        getHelper(VideoWidget.class).checkWidgetIsNotPresent();
        return this;
    }

    public UmdRecomendPage checkHighSchoolCAWidgetIsPresent() {
        getHelper(SchoolWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkFavoritesWidgetIsPresent() {
        getHelper(FavoritesWidget.class).checkWidgetIsPresent();
        return this;
    }

    public UmdRecomendPage checkFavoritesWidgetIsNotPresent() {
        getHelper(FavoritesWidget.class).checkWidgetIsNotPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkWorkingDaysWidgetIsPresent() {
        getHelper(WorkingDaysWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkWeekendDaysWidgetIsPresent() {
        getHelper(WeekendDaysWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkNewsBlockIsPresent() {
        getHelper(NewsBlock.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkHandbookWidgetTitleIsPresent() {
        getHelper(HandbookWidget.class).checkTitleIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkHandbookWidgetDocumentCountIsPresent() {
        getHelper(HandbookWidget.class).checkDocumentCountIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkHandbookWidgetDateTodayIsPresent() {
        getHelper(HandbookWidget.class).checkDateTodayIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkHandbookWidgetMonthNowIsPresent() {
        getHelper(HandbookWidget.class).checkMonthNowIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkHandbookWidgetWorkingDaysElementIsPresent() {
        getHelper(HandbookWidget.class).checkWorkingDaysElementIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkHandbookWidgetHolidaysElementIsPresent() {
        getHelper(HandbookWidget.class).checkHolidaysElementIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkHandbookWidgetExchangeRatesTitleIsPresent() {
        getHelper(HandbookWidget.class).checkExchangeRatesTitleIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkHandbookWidgetDollarRateIsPresent() {
        getHelper(HandbookWidget.class).checkDollarRateIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkHandbookWidgetEuroRateIsPresent() {
        getHelper(HandbookWidget.class).checkEuroRateIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkHandbookWidgetMinimunWageTitleIsPresent() {
        getHelper(HandbookWidget.class).checkMinimunWageTitleIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkHandbookWidgetWageIsPresent() {
        getHelper(HandbookWidget.class).checkWageIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkHandbookWidgetLinkInRegionIsPresent() {
        getHelper(HandbookWidget.class).checkLinkInRegionIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkHandbookWidgetLinkRubricIsPresent() {
        getHelper(HandbookWidget.class).checkLinkRubricIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkHandbookWidgetChangesIsPresent() {
        getHelper(HandbookWidget.class).checkLinkChangesIsPresent();
        return this;
    }

    @Override
    public UmdDictionaryPage clickOnHandbookWidgetTitle() {
        getHelper(HandbookWidget.class).clickOnTitle();
        return redirectTo(UmdDictionaryPage.class);
    }

    @Override
    public UmdDocumentPage clickOnHandbookWidgetCalendar() {
        getHelper(HandbookWidget.class).clickOnCalendar();
        return redirectTo(UmdDocumentPage.class);
    }

    @Override
    public UmdDocumentPage clickOnHandbookWidgetExchangeRatesBlock() {
        getHelper(HandbookWidget.class).clickOnExchangeRatesBlock();
        return redirectTo(UmdDocumentPage.class);
    }

    @Override
    public UmdDocumentPage clickOnHandbookWidgetRubricLink() {
        getHelper(HandbookWidget.class).clickOnRubricLink();
        return redirectTo(UmdDocumentPage.class);
    }

    @Override
    public UmdDocumentPage clickOnHandbookWidgetChangesLink() {
        getHelper(HandbookWidget.class).clickOnRubricLink();
        return redirectTo(UmdDocumentPage.class);
    }

    public UmdRecomendPage checkYellowPanelSearchInputIsPresent() {
        getHelper(YellowPanel.class).checkSearchInputIsPresent();
        return this;
    }

    public UmdRecomendPage checkYellowPanelSearchInputPlaceholderTextIsPresent() {
        getHelper(YellowPanel.class).checkSearchInputPlaceholderTextIsPresent();
        return this;
    }

    public UmdRecomendPage checkYellowPanelTipIsPresent() {
        getHelper(YellowPanel.class).checkTipIsPresent();
        return this;
    }

    public UmdRecomendPage checkYellowPanelTipQueryIsPresent() {
        getHelper(YellowPanel.class).checkTipQueryIsPresent();
        return this;
    }

    public UmdRecomendPage checkYellowPanelAnswerIsPresent() {
        getHelper(YellowPanel.class).checkAnswerIsPresent();
        return this;
    }

    public UmdRecomendPage checkYellowPanelLinkFromRecomendationIsPresent() {
        getHelper(YellowPanel.class).checkLinkFromRecomendationIsPresent();
        return this;
    }

    public UmdRecomendPage checkYellowPanelRubricatorLinksArePresent() {
        getHelper(YellowPanel.class).checkRubricatorLinksArePresent();
        return this;
    }

    public UmdDocumentPage clickOnYellowPanelLinkFromRecomendation() {
        getHelper(YellowPanel.class).clickOnLinkFromRecomendation();
        return redirectTo(UmdDocumentPage.class);
    }

    @Override
    public UmdRecomendPage checkNewsBlockFirstBlockTitleIsPresent() {
        getHelper(NewsBlock.class).checkFirstBlockTitleIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkNewsBlockNewsArePresent() {
        getHelper(NewsBlock.class).checkNewsArePresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkNewsBlockTodayTitleIsPresent() {
        getHelper(NewsBlock.class).checkTodayTitleIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkNewsBlockOnTheWeekTitleIsPresent() {
        getHelper(NewsBlock.class).checkOnTheWeekTitleIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkNewsBlockPerMonthTitleIsPresent() {
        getHelper(NewsBlock.class).checkPerMonthTitleIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkNewsBlockRecomendationNewsView() {
        getHelper(NewsBlock.class).checkRecomendationNewsView();
        return this;
    }

    @Override
    public UmdRecomendPage checkNewsBlockNewsWithTypeArePresent() {
        getHelper(NewsBlock.class).checkNewsWithTypeArePresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkNewsBlockLinksAllNewsArePresent() {
        getHelper(NewsBlock.class).checkLinksAllNewsArePresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkNewsBlockNewsLinks() {
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
    public UmdNewsPage clickOnNewsBlockFirstBlockTitle() {
        getHelper(NewsBlock.class).clickOnFirstBlockTitle();
        return redirectTo(UmdNewsPage.class);
    }

    @Override
    public UmdNewsPage clickOnNewsBlockLinkAllNewsInFirstBlock() {
        getHelper(NewsBlock.class).clickOnLinkAllNewsInFirstBlock();
        return redirectTo(UmdNewsPage.class);
    }

    @Override
    public UmdNewsPage clickOnNewsBlockLinkAllNewsInSecondBlock() {
        getHelper(NewsBlock.class).clickOnLinkAllNewsInSecondBlock();
        return redirectTo(UmdNewsPage.class);
    }

    @Override
    public UmdRecomendPage clearAllBookmarks() {
        removeAllBookmarksFromMenu();
        return this;
    }

    @Override
    public UmdRecomendPage checkFavoritesWidgetTitleIsPresent() {
        getHelper(FavoritesWidget.class).checkTitleIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkFavoritesWidgetTextFadeIsPresent() {
        getHelper(FavoritesWidget.class).checkTextFadeIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage addLinksToFavorites(String[][] documents) {
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
    public UmdRecomendPage checkFavoritesWidgetFiveLinksArePresent() {
        getHelper(FavoritesWidget.class).checkFiveLinksArePresent();
        return this;
    }

    @Override
    public UmdDocumentPage clickOnFavoritesWidgetFirstDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnFirstDocumentLink();
        return redirectTo(UmdDocumentPage.class);
    }

    @Override
    public UmdDocumentPage clickOnFavoritesWidgetSecondDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnSecondDocumentLink();
        return redirectTo(UmdDocumentPage.class);
    }

    @Override
    public UmdDocumentPage clickOnFavoritesWidgetThirdDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnThirdDocumentLink();
        return redirectTo(UmdDocumentPage.class);
    }

    @Override
    public UmdDocumentPage clickOnFavoritesWidgetFourthDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnFourthDocumentLink();
        return redirectTo(UmdDocumentPage.class);
    }

    @Override
    public UmdDocumentPage clickOnFavoritesWidgetFifthDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnFifthDocumentLink();
        return redirectTo(UmdDocumentPage.class);
    }

    @Override
    public UmdRecomendPage clickOnFavoritesWidgetTitleLink() {
        getHelper(FavoritesWidget.class).clickOnFavoritesTitleLink();
        return this;
    }

    @Override
    public UmdRecomendPage removeDocumentsFromFavorites() {
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
    public UmdRecomendPage checkVideoWidgetHasNoTitle() {
        getHelper(VideoWidget.class).checkHasNoTitle();
        return this;
    }

    @Override
    public UmdRecomendPage checkVideoWidgetScreenshotIsPresent() {
        getHelper(VideoWidget.class).checkScreenshotIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkVideoWidgetLink() {
        getHelper(VideoWidget.class).checkLink();
        return this;
    }

    @Override
    public UmdRecomendPage checkVideoWidgetVideoDuration() {
        getHelper(VideoWidget.class).checkVideoDuration();
        return this;
    }

    @Override
    public UmdDocumentPage clickOnVideoWidgetScreenshot() {
        getHelper(VideoWidget.class).clickOnScreenshot();
        return redirectTo(UmdDocumentPage.class);
    }

    @Override
    public UmdDocumentPage clickOnVideoWidgetLink() {
        getHelper(VideoWidget.class).clickOnLink();
        return redirectTo(UmdDocumentPage.class);
    }

    @Override
    public UmdRecomendPage checkLawBaseBlockIsPresent() {
        getHelper(LawBaseWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkLawBaseWidgetTitleIsPresent() {
        getHelper(LawBaseWidget.class).checkTitleIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkKodeksOrderInLawBaseBlock() {
        getHelper(LawBaseWidget.class).checkCodes();
        return this;
    }

    @Override
    public UmdRecomendPage checkLawBaseWidgetSearchInputIsPresent() {
        getHelper(LawBaseWidget.class).checkSearchInputIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkLawBaseWidgetNewDocumentCounterIsPresent() {
        getHelper(LawBaseWidget.class).checkNewDocumentCounterIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkLawBaseWidgetLinksCodes() {
        getHelper(LawBaseWidget.class).checkLinksCodes();
        return this;
    }

    @Override
    public UmdLawBasePage clickLawBaseWidgetLinkTitle() {
        getHelper(LawBaseWidget.class).clickLinkTitle();
        return redirectTo(UmdLawBasePage.class);
    }

    @Override
    public UmdLawBasePage clickLawBaseWidgetLinkNewDocumentCounter() {
        getHelper(LawBaseWidget.class).clickLinkNewDocumentCounter();
        return redirectTo(UmdLawBasePage.class);
    }

    @Override
    public UmdLawBasePage clickLawBaseWidgetLinkEnterIconOntoSearchInput() {
        getHelper(LawBaseWidget.class).clickLinkEnterIconOnSearchInput();
        return redirectTo(UmdLawBasePage.class);
    }

    @Override
    public UmdRecomendPage inputLawBaseWidgetInSearch(String query) {
        getHelper(LawBaseWidget.class).inputInSearch(query);
        return this;
    }

    @Override
    public UmdRecomendPage checkLawBaseWidgetSearchResultsArePresent() {
        getHelper(LawBaseWidget.class).checkSearchResultsArePresent();
        return this;
    }

    @Override
    public UmdDocumentPage clickLawBaseWidgetOnSearchResultsDirectDocument() {
        getHelper(LawBaseWidget.class).clickOnSearchResultsDirectDocument();
        return redirectTo(UmdDocumentPage.class);
    }

    @Override
    public UmdSearchResultPage clickLawBaseWidgetSearchResultsRandomHintLink() {
        getHelper(LawBaseWidget.class).clickSearchResultsRandomHintLink();
        return redirectTo(UmdSearchResultPage.class);
    }

    @Override
    public UmdSearchResultPage clickLawBaseWidgetIconEnterWithSearchQuery() {
        getHelper(LawBaseWidget.class).clickLinkEnterIconOnSearchInput();
        return redirectTo(UmdSearchResultPage.class);
    }

    @Override
    public UmdRecomendPage checkMagazinesWidgetTitleIsPresent() {
        getHelper(MagazinesWidget.class).checkTitleIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkMagazinesWidgetMagazinesCoversIsPresent() {
        getHelper(MagazinesWidget.class).checkMagazinesCoversIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkMagazinesWidgetMagazinesAreNotRepeated() {
        getHelper(MagazinesWidget.class).checkMagazinesAreNotRepeated();
        return this;
    }

    @Override
    public UmdRecomendPage checkMagazinesWidgetRedMarkerIsPresent() {
        getHelper(MagazinesWidget.class).checkRedMarkerForNewMagazine();
        return this;
    }

    @Override
    public UmdRecomendPage checkMagazinesWidgetTextNewMagazineIsPresent() {
        getHelper(MagazinesWidget.class).checkTextNewMagazineIsPresent();
        return this;
    }

    @Override
    public UmdMagazinesPage clickOnMagazinesWidgetTitle() {
        getHelper(MagazinesWidget.class).clickOnTitle();
        return redirectTo(UmdMagazinesPage.class);
    }

    @Override
    public UmdDocumentPage clickOnMagazinesWidgetNotice() {
        getHelper(MagazinesWidget.class).clickOnNotice();
        return redirectTo(UmdDocumentPage.class);
    }

    @Override
    public UmdRecomendPage checkMagazinesWidgetMagazinesLinks() {
        getHelper(MagazinesWidget.class).checkMagazinesLinks();
        return this;
    }

    @Override
    public UmdRecomendPage checkMagazinesWidgetMagazinesCoversWithVariantResolutions() {
        getHelper(MagazinesWidget.class).checkMagazinesCoversWithVariantResolutions();
        return this;
    }

    public UmdRecomendPage checkBannerIsPresent() {
        getHelper(BannerBlock.class).checkWidgetIsPresent();
        return this;
    }

    public UmdRecomendPage clickOnBanner() {
        getHelper(BannerBlock.class).clickOnBanner();
        return this;
    }

    public UmdRecomendPage checkDocumentAfterClickingOnBanner() {
        String documentUrl = String.valueOf(getParameter(SearchResultHelper.DOCUMENT_URL));
        postponedAssertTrue(getDriver().getCurrentUrl().contains(documentUrl), "URL не совпадают, actual:" +
                getDriver().getCurrentUrl() + " expected:" + documentUrl);
        return this;
    }

    public UmdRecomendPage checkBannerTextWithScreenResolution1024px() {
        getHelper(BannerBlock.class).checkBannerTextWithScreenResolution1024px();
        return this;
    }

    public UmdRecomendPage checkBannerTextWithScreenResolution1280px() {
        getHelper(BannerBlock.class).checkBannerTextWithScreenResolution1280px();
        return this;
    }

    public UmdRecomendPage checkBannerTextWithScreenResolution1366px() {
        getHelper(BannerBlock.class).checkBannerTextWithScreenResolution1366px();
        return this;
    }

    @Override
    public UmdRecomendPage checkFormsBlockIsPresent() {
        getHelper(FormsWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkFormsWidgetTitleIsPresent() {
        getHelper(FormsWidget.class).checkTitleIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkFormsBlockIsNotEmpty() {
        getHelper(FormsWidget.class).checkWidgetIsNotEmpty();
        return this;
    }

    @Override
    public UmdRecomendPage checkFormsWidgetSearchInputIsPresent() {
        getHelper(FormsWidget.class).checkSearchInputIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkFormsWidgetNewDocumentCounterIsPresent() {
        getHelper(FormsWidget.class).checkNewDocumentCounterIsPresent();
        return this;
    }

    @Override
    public UmdRecomendPage checkFormsWidgetExamplesFormsIsPresent() {
        getHelper(FormsWidget.class).checkExamplesFormsIsPresent();
        return this;
    }

    public UmdDocumentPage clickFormsWidgetRedLink() {
        getHelper(FormsWidget.class).clickOnRedLink();
        return redirectTo(UmdDocumentPage.class);
    }

    public UmdDocumentPage clickFormsWidgetGreenLink() {
        getHelper(FormsWidget.class).clickOnGreenLink();
        return redirectTo(UmdDocumentPage.class);
    }

    public UmdDocumentPage clickFormsWidgetBlueLink() {
        getHelper(FormsWidget.class).clickOnBlueLink();
        return redirectTo(UmdDocumentPage.class);
    }

    public UmdDocumentPage clickFormsWidgetYellowLink() {
        getHelper(FormsWidget.class).clickOnYellowLink();
        return redirectTo(UmdDocumentPage.class);
    }

    @Override
    public UmdFormsPage clickFormsLink() {
        getHelper(FormsWidget.class).clickOnTitle();
        return redirectTo(UmdFormsPage.class);
    }

    @Override
    public UmdFormsPage clickFormsWidgetLinkNewDocumentCounter() {
        getHelper(FormsWidget.class).clickLinkNewDocumentCounter();
        return redirectTo(UmdFormsPage.class);
    }

    @Override
    public UmdFormsPage clickFormsWidgetLinkEnterIconOntoSearchInput() {
        getHelper(FormsWidget.class).clickLinkEnterIconOnSearchInput();
        return redirectTo(UmdFormsPage.class);
    }

    @Override
    public UmdRecomendPage inputFormsWidgetInSearch(String query) {
        getHelper(FormsWidget.class).inputInSearch(query);
        return this;
    }

    @Override
    public UmdRecomendPage checkFormsWidgetSearchResultsArePresent() {
        getHelper(FormsWidget.class).checkSearchResultsArePresent();
        return this;
    }

    @Override
    public UmdDocumentPage clickFormsWidgetOnSearchResultsDirectDocument() {
        getHelper(FormsWidget.class).clickOnSearchResultsDirectDocument();
        return redirectTo(UmdDocumentPage.class);
    }

    @Override
    public UmdSearchResultPage clickFormsWidgetSearchResultsRandomHintLink() {
        getHelper(FormsWidget.class).clickSearchResultsRandomHintLink();
        return redirectTo(UmdSearchResultPage.class);
    }

    @Override
    public UmdSearchResultPage clickFormsWidgetIconEnterWithSearchQuery() {
        getHelper(FormsWidget.class).clickLinkEnterIconOnSearchInput();
        return redirectTo(UmdSearchResultPage.class);
    }

    @Override
    @Step("Проверяется что ссылка 'Написать Эксперту' не отображается")
    public UmdRecomendPage checkHotLineLinkIsNotPresent() {
        postponedAssertNull(findElementByNoThrow(By.className("[href*='/#/hotline/']")), "Ссылка 'Написать Эксперту' отображается");
        return this;
    }
}
