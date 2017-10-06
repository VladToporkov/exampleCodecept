package com.actionmedia.pages.ot;

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
 * Created by Pavel on 13/03/16.
 */
@Component
public class OtRecomendPage extends OTBasePage<OtRecomendPage> implements IRecomendPage {

    @Override
    public OtRecomendPage checkYellowPanelIsPresent() {
        getHelper(YellowPanel.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkHandbookWidgetIsPresent() {
        getHelper(HandbookWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkFormsWidgetIsPresent() {
        getHelper(FormsWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkLawBaseWidgetIsPresent() {
        getHelper(LawBaseWidget.class).checkWidgetIsPresent();
        return this;
    }

    public OtRecomendPage checkSchoolIsPresent() {
        getHelper(SchoolWidget.class).checkWidgetIsPresent();
        return this;
    }

    public OtRecomendPage checkSchoolIsNotPresent() {
        getHelper(SchoolWidget.class).checkWidgetIsNotPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkMagazinesWidgetIsPresent() {
        getHelper(MagazinesWidget.class).checkWidgetIsPresent();
        return this;
    }

    public OtRecomendPage checkMagazinesWidgetIsNotPresent() {
        getHelper(MagazinesWidget.class).checkWidgetIsNotPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkVideoWidgetIsPresent() {
        getHelper(VideoWidget.class).checkWidgetIsPresent();
        return this;
    }

    public OtRecomendPage checkVideoWidgetIsNotPresent() {
        getHelper(VideoWidget.class).checkWidgetIsNotPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkFavoritesWidgetIsPresent() {
        getHelper(FavoritesWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkWorkingDaysWidgetIsPresent() {
        getHelper(WorkingDaysWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkWeekendDaysWidgetIsPresent() {
        getHelper(WeekendDaysWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkNewsBlockIsPresent() {
        getHelper(NewsBlock.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkHandbookWidgetTitleIsPresent() {
        getHelper(HandbookWidget.class).checkTitleIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkHandbookWidgetDocumentCountIsPresent() {
        getHelper(HandbookWidget.class).checkDocumentCountIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkHandbookWidgetDateTodayIsPresent() {
        getHelper(HandbookWidget.class).checkDateTodayIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkHandbookWidgetMonthNowIsPresent() {
        getHelper(HandbookWidget.class).checkMonthNowIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkHandbookWidgetWorkingDaysElementIsPresent() {
        getHelper(HandbookWidget.class).checkWorkingDaysElementIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkHandbookWidgetHolidaysElementIsPresent() {
        getHelper(HandbookWidget.class).checkHolidaysElementIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkHandbookWidgetExchangeRatesTitleIsPresent() {
        getHelper(HandbookWidget.class).checkExchangeRatesTitleIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkHandbookWidgetDollarRateIsPresent() {
        getHelper(HandbookWidget.class).checkDollarRateIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkHandbookWidgetEuroRateIsPresent() {
        getHelper(HandbookWidget.class).checkEuroRateIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkHandbookWidgetMinimunWageTitleIsPresent() {
        getHelper(HandbookWidget.class).checkMinimunWageTitleIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkHandbookWidgetWageIsPresent() {
        getHelper(HandbookWidget.class).checkWageIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkHandbookWidgetLinkInRegionIsPresent() {
        getHelper(HandbookWidget.class).checkLinkInRegionIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkHandbookWidgetLinkRubricIsPresent() {
        getHelper(HandbookWidget.class).checkLinkRubricIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkHandbookWidgetChangesIsPresent() {
        getHelper(HandbookWidget.class).checkLinkChangesIsPresent();
        return this;
    }

    @Override
    public OtDictionaryPage clickOnHandbookWidgetTitle() {
        getHelper(HandbookWidget.class).clickOnTitle();
        return redirectTo(OtDictionaryPage.class);
    }

    @Override
    public OtDocumentPage clickOnHandbookWidgetCalendar() {
        getHelper(HandbookWidget.class).clickOnCalendar();
        return redirectTo(OtDocumentPage.class);
    }

    @Override
    public OtDocumentPage clickOnHandbookWidgetExchangeRatesBlock() {
        getHelper(HandbookWidget.class).clickOnExchangeRatesBlock();
        return redirectTo(OtDocumentPage.class);
    }

    @Override
    public OtDocumentPage clickOnHandbookWidgetRubricLink() {
        getHelper(HandbookWidget.class).clickOnRubricLink();
        return redirectTo(OtDocumentPage.class);
    }

    @Override
    public OtDocumentPage clickOnHandbookWidgetChangesLink() {
        getHelper(HandbookWidget.class).clickOnRubricLink();
        return redirectTo(OtDocumentPage.class);
    }

    public OtRecomendPage checkYellowPanelSearchInputIsPresent() {
        getHelper(YellowPanel.class).checkSearchInputIsPresent();
        return this;
    }

    public OtRecomendPage checkYellowPanelSearchInputPlaceholderTextIsPresent() {
        getHelper(YellowPanel.class).checkSearchInputPlaceholderTextIsPresent();
        return this;
    }

    public OtRecomendPage checkYellowPanelTipIsPresent() {
        getHelper(YellowPanel.class).checkTipIsPresent();
        return this;
    }

    public OtRecomendPage checkYellowPanelTipQueryIsPresent() {
        getHelper(YellowPanel.class).checkTipQueryIsPresent();
        return this;
    }

    public OtRecomendPage checkYellowPanelAnswerIsPresent() {
        getHelper(YellowPanel.class).checkAnswerIsPresent();
        return this;
    }

    public OtRecomendPage checkYellowPanelLinkFromRecomendationIsPresent() {
        getHelper(YellowPanel.class).checkLinkFromRecomendationIsPresent();
        return this;
    }

    public OtRecomendPage checkYellowPanelRubricatorLinksArePresent() {
        getHelper(YellowPanel.class).checkRubricatorLinksArePresent();
        return this;
    }

    public OtDocumentPage clickOnYellowPanelLinkFromRecomendation() {
        getHelper(YellowPanel.class).clickOnLinkFromRecomendation();
        return redirectTo(OtDocumentPage.class);
    }

    @Override
    public OtRecomendPage checkNewsBlockFirstBlockTitleIsPresent() {
        getHelper(NewsBlock.class).checkFirstBlockTitleIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkNewsBlockNewsArePresent() {
        getHelper(NewsBlock.class).checkNewsArePresent();
        return this;
    }

    @Override
    public OtRecomendPage checkNewsBlockTodayTitleIsPresent() {
        getHelper(NewsBlock.class).checkTodayTitleIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkNewsBlockOnTheWeekTitleIsPresent() {
        getHelper(NewsBlock.class).checkOnTheWeekTitleIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkNewsBlockPerMonthTitleIsPresent() {
        getHelper(NewsBlock.class).checkPerMonthTitleIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkNewsBlockRecomendationNewsView() {
        getHelper(NewsBlock.class).checkRecomendationNewsView();
        return this;
    }

    @Override
    public OtRecomendPage checkNewsBlockNewsWithTypeArePresent() {
        getHelper(NewsBlock.class).checkNewsWithTypeArePresent();
        return this;
    }

    @Override
    public OtRecomendPage checkNewsBlockLinksAllNewsArePresent() {
        getHelper(NewsBlock.class).checkLinksAllNewsArePresent();
        return this;
    }

    @Override
    public OtRecomendPage checkNewsBlockNewsLinks() {
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
    public OtNewsPage clickOnNewsBlockFirstBlockTitle() {
        getHelper(NewsBlock.class).clickOnFirstBlockTitle();
        return redirectTo(OtNewsPage.class);
    }

    @Override
    public OtNewsPage clickOnNewsBlockLinkAllNewsInFirstBlock() {
        getHelper(NewsBlock.class).clickOnLinkAllNewsInFirstBlock();
        return redirectTo(OtNewsPage.class);
    }

    @Override
    public OtNewsPage clickOnNewsBlockLinkAllNewsInSecondBlock() {
        getHelper(NewsBlock.class).clickOnLinkAllNewsInSecondBlock();
        return redirectTo(OtNewsPage.class);
    }

    @Override
    public OtRecomendPage clearAllBookmarks() {
        removeAllBookmarksFromMenu();
        return this;
    }

    @Override
    public OtRecomendPage checkFavoritesWidgetTitleIsPresent() {
        getHelper(FavoritesWidget.class).checkTitleIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkFavoritesWidgetTextFadeIsPresent() {
        getHelper(FavoritesWidget.class).checkTextFadeIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage addLinksToFavorites(String[][] documents) {
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
    public OtRecomendPage checkFavoritesWidgetFiveLinksArePresent() {
        getHelper(FavoritesWidget.class).checkFiveLinksArePresent();
        return this;
    }

    @Override
    public OtDocumentPage clickOnFavoritesWidgetFirstDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnFirstDocumentLink();
        return redirectTo(OtDocumentPage.class);
    }

    @Override
    public OtDocumentPage clickOnFavoritesWidgetSecondDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnSecondDocumentLink();
        return redirectTo(OtDocumentPage.class);
    }

    @Override
    public OtDocumentPage clickOnFavoritesWidgetThirdDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnThirdDocumentLink();
        return redirectTo(OtDocumentPage.class);
    }

    @Override
    public OtDocumentPage clickOnFavoritesWidgetFourthDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnFourthDocumentLink();
        return redirectTo(OtDocumentPage.class);
    }

    @Override
    public OtDocumentPage clickOnFavoritesWidgetFifthDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnFifthDocumentLink();
        return redirectTo(OtDocumentPage.class);
    }

    @Override
    public OtRecomendPage clickOnFavoritesWidgetTitleLink() {
        getHelper(FavoritesWidget.class).clickOnFavoritesTitleLink();
        return this;
    }

    @Override
    public OtRecomendPage removeDocumentsFromFavorites() {
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
    public OtRecomendPage checkFavoritesWidgetIsNotPresent() {
        getHelper(FavoritesWidget.class).checkWidgetIsNotPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkVideoWidgetHasNoTitle() {
        getHelper(VideoWidget.class).checkHasNoTitle();
        return this;
    }

    @Override
    public OtRecomendPage checkVideoWidgetScreenshotIsPresent() {
        getHelper(VideoWidget.class).checkScreenshotIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkVideoWidgetLink() {
        getHelper(VideoWidget.class).checkLink();
        return this;
    }

    @Override
    public OtRecomendPage checkVideoWidgetVideoDuration() {
        getHelper(VideoWidget.class).checkVideoDuration();
        return this;
    }

    @Override
    public OtDocumentPage clickOnVideoWidgetScreenshot() {
        getHelper(VideoWidget.class).clickOnScreenshot();
        return redirectTo(OtDocumentPage.class);
    }

    @Override
    public OtDocumentPage clickOnVideoWidgetLink() {
        getHelper(VideoWidget.class).clickOnLink();
        return redirectTo(OtDocumentPage.class);
    }

    @Override
    public OtRecomendPage checkLawBaseBlockIsPresent() {
        getHelper(LawBaseWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkLawBaseWidgetTitleIsPresent() {
        getHelper(LawBaseWidget.class).checkTitleIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkKodeksOrderInLawBaseBlock() {
        getHelper(LawBaseWidget.class).checkCodes();
        return this;
    }

    @Override
    public OtRecomendPage checkLawBaseWidgetSearchInputIsPresent() {
        getHelper(LawBaseWidget.class).checkSearchInputIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkLawBaseWidgetNewDocumentCounterIsPresent() {
        getHelper(LawBaseWidget.class).checkNewDocumentCounterIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkLawBaseWidgetLinksCodes() {
        getHelper(LawBaseWidget.class).checkLinksCodes();
        return this;
    }

    @Override
    public OtLawBasePage clickLawBaseWidgetLinkTitle() {
        getHelper(LawBaseWidget.class).clickLinkTitle();
        return redirectTo(OtLawBasePage.class);
    }

    @Override
    public OtLawBasePage clickLawBaseWidgetLinkNewDocumentCounter() {
        getHelper(LawBaseWidget.class).clickLinkNewDocumentCounter();
        return redirectTo(OtLawBasePage.class);
    }

    @Override
    public OtLawBasePage clickLawBaseWidgetLinkEnterIconOntoSearchInput() {
        getHelper(LawBaseWidget.class).clickLinkEnterIconOnSearchInput();
        return redirectTo(OtLawBasePage.class);
    }

    @Override
    public OtRecomendPage inputLawBaseWidgetInSearch(String query) {
        getHelper(LawBaseWidget.class).inputInSearch(query);
        return this;
    }

    @Override
    public OtRecomendPage checkLawBaseWidgetSearchResultsArePresent() {
        getHelper(LawBaseWidget.class).checkSearchResultsArePresent();
        return this;
    }

    @Override
    public OtDocumentPage clickLawBaseWidgetOnSearchResultsDirectDocument() {
        getHelper(LawBaseWidget.class).clickOnSearchResultsDirectDocument();
        return redirectTo(OtDocumentPage.class);
    }

    @Override
    public OtSearchResultPage clickLawBaseWidgetSearchResultsRandomHintLink() {
        getHelper(LawBaseWidget.class).clickSearchResultsRandomHintLink();
        return redirectTo(OtSearchResultPage.class);
    }

    @Override
    public OtSearchResultPage clickLawBaseWidgetIconEnterWithSearchQuery() {
        getHelper(LawBaseWidget.class).clickLinkEnterIconOnSearchInput();
        return redirectTo(OtSearchResultPage.class);
    }

    @Override
    public OtRecomendPage checkMagazinesWidgetTitleIsPresent() {
        getHelper(MagazinesWidget.class).checkTitleIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkMagazinesWidgetMagazinesCoversIsPresent() {
        getHelper(MagazinesWidget.class).checkMagazinesCoversIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkMagazinesWidgetMagazinesAreNotRepeated() {
        getHelper(MagazinesWidget.class).checkMagazinesAreNotRepeated();
        return this;
    }

    @Override
    public OtRecomendPage checkMagazinesWidgetRedMarkerIsPresent() {
        getHelper(MagazinesWidget.class).checkRedMarkerForNewMagazine();
        return this;
    }

    @Override
    public OtRecomendPage checkMagazinesWidgetTextNewMagazineIsPresent() {
        getHelper(MagazinesWidget.class).checkTextNewMagazineIsPresent();
        return this;
    }

    @Override
    public OtMagazinesPage clickOnMagazinesWidgetTitle() {
        getHelper(MagazinesWidget.class).clickOnTitle();
        return redirectTo(OtMagazinesPage.class);
    }

    @Override
    public OtDocumentPage clickOnMagazinesWidgetNotice() {
        getHelper(MagazinesWidget.class).clickOnNotice();
        return redirectTo(OtDocumentPage.class);
    }

    @Override
    public OtRecomendPage checkMagazinesWidgetMagazinesLinks() {
        getHelper(MagazinesWidget.class).checkMagazinesLinks();
        return this;
    }

    @Override
    public OtRecomendPage checkMagazinesWidgetMagazinesCoversWithVariantResolutions() {
        getHelper(MagazinesWidget.class).checkMagazinesCoversWithVariantResolutions();
        return this;
    }

    public OtRecomendPage checkBannerIsPresent() {
        getHelper(BannerBlock.class).checkWidgetIsPresent();
        return this;
    }

    public OtRecomendPage clickOnBanner() {
        getHelper(BannerBlock.class).clickOnBanner();
        return this;
    }

    public OtRecomendPage checkDocumentAfterClickingOnBanner() {
        String documentUrl = String.valueOf(getParameter(SearchResultHelper.DOCUMENT_URL));
        postponedAssertTrue(getDriver().getCurrentUrl().contains(documentUrl), "URL не совпадают, actual:" +
                getDriver().getCurrentUrl() + " expected:" + documentUrl);
        return this;
    }

    public OtRecomendPage checkBannerTextWithScreenResolution1024px() {
        getHelper(BannerBlock.class).checkBannerTextWithScreenResolution1024px();
        return this;
    }

    public OtRecomendPage checkBannerTextWithScreenResolution1280px() {
        getHelper(BannerBlock.class).checkBannerTextWithScreenResolution1280px();
        return this;
    }

    public OtRecomendPage checkBannerTextWithScreenResolution1366px() {
        getHelper(BannerBlock.class).checkBannerTextWithScreenResolution1366px();
        return this;
    }

    @Override
    public OtRecomendPage checkFormsBlockIsPresent() {
        getHelper(FormsWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkFormsWidgetTitleIsPresent() {
        getHelper(FormsWidget.class).checkTitleIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkFormsBlockIsNotEmpty() {
        getHelper(FormsWidget.class).checkWidgetIsNotEmpty();
        return this;
    }

    @Override
    public OtRecomendPage checkFormsWidgetSearchInputIsPresent() {
        getHelper(FormsWidget.class).checkSearchInputIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkFormsWidgetNewDocumentCounterIsPresent() {
        getHelper(FormsWidget.class).checkNewDocumentCounterIsPresent();
        return this;
    }

    @Override
    public OtRecomendPage checkFormsWidgetExamplesFormsIsPresent() {
        getHelper(FormsWidget.class).checkExamplesFormsIsPresent();
        return this;
    }

    public OtDocumentPage clickFormsWidgetRedLink() {
        getHelper(FormsWidget.class).clickOnRedLink();
        return redirectTo(OtDocumentPage.class);
    }

    public OtDocumentPage clickFormsWidgetGreenLink() {
        getHelper(FormsWidget.class).clickOnGreenLink();
        return redirectTo(OtDocumentPage.class);
    }

    public OtDocumentPage clickFormsWidgetBlueLink() {
        getHelper(FormsWidget.class).clickOnBlueLink();
        return redirectTo(OtDocumentPage.class);
    }

    public OtDocumentPage clickFormsWidgetYellowLink() {
        getHelper(FormsWidget.class).clickOnYellowLink();
        return redirectTo(OtDocumentPage.class);
    }

    @Override
    public OtFormsPage clickFormsLink() {
        getHelper(FormsWidget.class).clickOnTitle();
        return redirectTo(OtFormsPage.class);
    }

    @Override
    public OtFormsPage clickFormsWidgetLinkNewDocumentCounter() {
        getHelper(FormsWidget.class).clickLinkNewDocumentCounter();
        return redirectTo(OtFormsPage.class);
    }

    @Override
    public OtFormsPage clickFormsWidgetLinkEnterIconOntoSearchInput() {
        getHelper(FormsWidget.class).clickLinkEnterIconOnSearchInput();
        return redirectTo(OtFormsPage.class);
    }

    @Override
    public OtRecomendPage inputFormsWidgetInSearch(String query) {
        getHelper(FormsWidget.class).inputInSearch(query);
        return this;
    }

    @Override
    public OtRecomendPage checkFormsWidgetSearchResultsArePresent() {
        getHelper(FormsWidget.class).checkSearchResultsArePresent();
        return this;
    }

    @Override
    public OtDocumentPage clickFormsWidgetOnSearchResultsDirectDocument() {
        getHelper(FormsWidget.class).clickOnSearchResultsDirectDocument();
        return redirectTo(OtDocumentPage.class);
    }

    @Override
    public OtSearchResultPage clickFormsWidgetSearchResultsRandomHintLink() {
        getHelper(FormsWidget.class).clickSearchResultsRandomHintLink();
        return redirectTo(OtSearchResultPage.class);
    }

    @Override
    public OtSearchResultPage clickFormsWidgetIconEnterWithSearchQuery() {
        getHelper(FormsWidget.class).clickLinkEnterIconOnSearchInput();
        return redirectTo(OtSearchResultPage.class);
    }

    @Override
    @Step("Проверяется что ссылка 'Написать Эксперту' не отображается")
    public OtRecomendPage checkHotLineLinkIsNotPresent() {
        postponedAssertNull(findElementByNoThrow(By.className("[href*='/#/hotline/']")), "Ссылка 'Написать Эксперту' отображается");
        return this;
    }
}
