package com.actionmedia.pages.gf;

import com.actionmedia.components.info.AttachmentsInfobar;
import com.actionmedia.pages.helpers.DocumentHelper;
import com.actionmedia.pages.interfaces.IDocumentPage;
import org.springframework.stereotype.Component;

/**
 * Created by Pavel on 28/03/16.
 */
@Component
public class GfDocumentPage extends GFBasePage<GfDocumentPage> implements IDocumentPage {

    public GfDocumentPage checkDocumentIsOpened() {
        getHelper(DocumentHelper.class).checkDocumentIsOpened();
        return this;
    }

    @Override
    public GfDocumentPage checkDownloadShowExamplesLinkIsNotPresent() {
        getHelper(DocumentHelper.class).checkDownloadShowExamplesLinkIsNotPresent();
        return this;
    }

    @Override
    public GfDocumentPage checkDownloadShowExampleLinkIsNotPresent() {
        getHelper(DocumentHelper.class).checkDownloadShowExamplesLinkIsNotPresent();
        return this;
    }

    @Override
    public IDocumentPage checkCommonView118(String name) {
        getHelper(DocumentHelper.class).checkCommonView118(name);
        return this;
    }

    public GfDocumentPage checkMenu() {
        getHelper(DocumentHelper.class).checkMenu();
        return this;
    }

    public GfDocumentPage checkWordButtonIsPresent() {
        getHelper(DocumentHelper.class).checkWordButtonIsPresent();
        return this;
    }

    public GfDocumentPage checkMailButtonIsPresent() {
        getHelper(DocumentHelper.class).checkMailButtonIsPresent();
        return this;
    }

    public GfDocumentPage checkPrintIcon() {
        getHelper(DocumentHelper.class).checkPrintIcon();
        return this;
    }

    public GfDocumentPage checkDocumentTitleIsPresent() {
        getHelper(DocumentHelper.class).checkDocumentTitleIsPresent();
        return this;
    }

    public GfDocumentPage checkBriefBlockIsPresent() {
        getHelper(DocumentHelper.class).checkBriefBlockIsPresent();
        return this;
    }

    public GfDocumentPage checkDocumentRatingIsPresent() {
        getHelper(DocumentHelper.class).checkDocumentRatingIsPresent();
        return this;
    }

    public GfDocumentPage checkSoderIsPresent() {
        getHelper(DocumentHelper.class).checkSoderIsPresent();
        return this;
    }

    public GfDocumentPage checkRubricatorButtonIsPresent(String buttonName) {
        getHelper(DocumentHelper.class).checkRubricatorButtonIsPresent(buttonName);
        return this;
    }

    public GfDocumentPage checkAddToFavoritesButtonsForDocumentArePresent() {
        getHelper(DocumentHelper.class).checkAddToFavoritesButtonsForDocumentArePresent();
        return this;
    }

    public GfDocumentPage checkMetaTagsAndTableOfContents() {
        getHelper(DocumentHelper.class).checkMetaTagsAndTableOfContents();
        return this;
    }

    public GfDocumentPage checkMetaTagsAndSavedDataContent() {
        getHelper(DocumentHelper.class).checkMetaTagsAndSavedDataContent();
        return this;
    }

    public GfDocumentPage checkTitleAndAuthorInformationPresent() {
        getHelper(DocumentHelper.class).checkTitleAndAuthorInformationPresent();
        return this;
    }

    public GfDocumentPage checkContentIsPresent() {
        checkEmptyDocumentHeader();
        checkEmptyDocument();
        return this;
    }

    public GfDocumentPage checkParentDocumentLinkIsPresent() {
        getHelper(DocumentHelper.class).checkParentDocumentLinkIsPresent();
        return this;
    }

    public GfDocumentPage checkTextBlocksForDocument199_10182() {
        getHelper(DocumentHelper.class).checkTextBlocksForDocument199_10182();
        return this;
    }

    public GfDocumentPage checkTransportTaxForDoc_11_14355() {
        getHelper(DocumentHelper.class).checkTransportTaxForDoc_11_14355();
        return this;
    }

    public GfDocumentPage checkTextContainsBlocksHowToAndWhatToDo() {
        getHelper(DocumentHelper.class).checkTextContainsBlocksHowToAndWhatToDo();
        return this;
    }

    public GfDocumentPage checkInCut() {
        getHelper(DocumentHelper.class).checkInCut();
        return this;
    }

    public GfDocumentPage clickDocumentInfobarLink() {
        getHelper(DocumentHelper.class).clickDocumentInfobarLink();
        return this;
    }

    public GfDocumentPage checkInfobarCardIsPresent() {
        getHelper(DocumentHelper.class).checkInfobarCardIsPresent();
        return this;
    }

    public GfDocumentPage checkInfobarBlocksLinks() {
        getHelper(DocumentHelper.class).checkInfobarBlocksLinks();
        return this;
    }

    public GfDocumentPage checkDocumentInfobarBottom() {
        getHelper(DocumentHelper.class).checkDocumentInfobarBottom();
        return this;
    }

    public GfDocumentPage checkTitleTag() {
        getHelper(DocumentHelper.class).checkTitleTag();
        return this;
    }

    public GfDocumentPage checkIncutAdviceContainsText(String text) {
        getHelper(DocumentHelper.class).checkIncutAdviceContainsText(text);
        return this;
    }

    public GfDocumentPage checkTextDocumentEditionFromInDocHeader() {
        getHelper(DocumentHelper.class).checkTextDocumentEditionFromInDocHeader();
        return this;
    }

    public GfDocumentPage checkLogoGlavbukhInDocumentContentFooter() {
        getHelper(DocumentHelper.class).checkLogoGlavbukhInDocumentContentFooter();
        return this;
    }

    public GfDocumentPage clickOnPrevButtonInTopMenu() {
        getHelper(DocumentHelper.class).clickOnPrevButtonInTopMenu();
        return this;
    }

    public GfDocumentPage clickOnNextButtonInTopMenu() {
        getHelper(DocumentHelper.class).clickOnNextButtonInTopMenu();
        return this;
    }

    public GfDocumentPage clickOnPreviousButtonInBottomMenu() {
        getHelper(DocumentHelper.class).clickOnPreviousButtonInBottomMenu();
        return this;
    }

    public GfDocumentPage clickOnNextButtonInBottomMenu() {
        getHelper(DocumentHelper.class).clickOnNextButtonInBottomMenu();
        return this;
    }

    public GfDocumentPage checkNextAndPrevButtonsInTopMenuArePresent() {
        getHelper(DocumentHelper.class).checkNextAndPrevButtonsInTopMenuArePresent();
        return this;
    }

    public GfDocumentPage checkNextAndPrevButtonsInBottomMenuArePresent() {
        getHelper(DocumentHelper.class).checkNextAndPrevButtonsInBottomMenuArePresent();
        return this;
    }

    public GfDocumentPage checkPrevButtonInTopIsAbsent() {
        getHelper(DocumentHelper.class).checkButtonPreviousInTopMenuIsNotPresent();
        return this;
    }

    public GfDocumentPage checkNextButtonInTopIsAbsent() {
        getHelper(DocumentHelper.class).checkButtonNextInTopMenuIsNotPresent();
        return this;
    }

    public GfDocumentPage checkNextButtonInBottomIsAbsent() {
        getHelper(DocumentHelper.class).checkButtonNextInBottomMenuIsNotPresent();
        return this;
    }

    public GfDocumentPage checkPrevButtonInBottomIsAbsent() {
        getHelper(DocumentHelper.class).checkButtonPreviousInBottomMenuIsNotPresent();
        return this;
    }

    public GfDocumentPage clickTableOfContentsButton() {
        getHelper(DocumentHelper.class).clickTableOfContentsButton();
        return this;
    }

    public GfDocumentPage clickFirstArticleFromTableOfContents() {
        getHelper(DocumentHelper.class).clickFirstArticleFromTableOfContents();
        return this;
    }

    public GfDocumentPage clickLastArticleFromTableOfContents() {
        getHelper(DocumentHelper.class).clickLastArticleFromTableOfContents();
        return this;
    }

    public GfDocumentPage checkTableOfContentsButtonIsPressed() {
        getHelper(DocumentHelper.class).checkTableOfContentsButtonIsPressed();
        return this;
    }

    public GfDocumentPage checkTableOfContentsIsNotEmpty() {
        getHelper(DocumentHelper.class).checkTableOfContentsIsNotEmpty("");
        return this;
    }

    public GfDocumentPage checkDocumentIsNotEmpty() {
        getHelper(DocumentHelper.class).checkDocumentIsNotEmpty();
        return this;
    }

    public GfDocumentPage checkTableOfContentsButtonIsUnPressed() {
        getHelper(DocumentHelper.class).checkTableOfContentsButtonIsUnPressed();
        return this;
    }

    public GfDocumentPage clickRandomArticleFromTableOfContents() {
        getHelper(DocumentHelper.class).clickRandomArticleFromTableOfContents();
        return this;
    }

    public GfDocumentPage checkDisplayNameJournal() {
        getHelper(DocumentHelper.class).checkDisplayNameJournal();
        return this;
    }

    public GfDocumentPage checkPudDateJournal() {
        getHelper(DocumentHelper.class).checkPudDateJournal();
        return this;
    }

    public GfDocumentPage checkArticleTitle() {
        getHelper(DocumentHelper.class).checkArticleTitle();
        return this;
    }

    public GfDocumentPage checkDisplayTextInJournal() {
        getHelper(DocumentHelper.class).checkDisplayTextInJournal();
        return this;
    }

    public GfDocumentPage checkInMyFavoritesIcon() {
        getHelper(DocumentHelper.class).checkInMyFavoritesIcon();
        return this;
    }

    public GfDocumentPage checkBrowseIcon() {
        getHelper(DocumentHelper.class).checkBrowseIcon();
        return this;
    }

    public GfDocumentPage checkShareIcon() {
        getHelper(DocumentHelper.class).checkShareIcon();
        return this;
    }

    public GfDocumentPage checkBackwardIcon() {
        getHelper(DocumentHelper.class).checkBackwardIcon();
        return this;
    }

    public GfDocumentPage checkForwardIcon() {
        getHelper(DocumentHelper.class).checkForwardIcon();
        return this;
    }

    public GfDocumentPage checkSoderButtonIsPresent() {
        getHelper(DocumentHelper.class).checkSoderButtonIsPresent();
        return this;
    }

    public GfDocumentPage checkDisplayNameJournal_119() {
        getHelper(DocumentHelper.class).checkDisplayNameJournal_119();
        return this;
    }

    public GfDocumentPage checkDisplayCover() {
        getHelper(DocumentHelper.class).checkDisplayCover();
        return this;
    }

    public GfDocumentPage checkArticleTitle_119() {
        getHelper(DocumentHelper.class).checkArticleTitle_119();
        return this;
    }

    public GfDocumentPage checkDisplayTextDocumentInParagraphs_119() {
        getHelper(DocumentHelper.class).checkDisplayNameJournal_119();
        return this;
    }

    public GfDocumentPage checkDisplayStarsSection() {
        getHelper(DocumentHelper.class).checkDisplayStarsSection();
        return this;
    }

    public GfDocumentPage checkDisplayNameJournal_192() {
        getHelper(DocumentHelper.class).checkDisplayNameJournal_192();
        return this;
    }

    public GfDocumentPage checkNumberJournal_192() {
        getHelper(DocumentHelper.class).checkNumberJournal_192();
        return this;
    }

    public GfDocumentPage checkDisplayTableOfContents_192() {
        getHelper(DocumentHelper.class).checkDisplayTableOfContents_192();
        return this;
    }

    public GfDocumentPage checkNameAndNumberJournal() {
        getHelper(DocumentHelper.class).checkNameAndNumberJournal();
        return this;
    }

    public GfDocumentPage checkDisplayTableOfContents() {
        getHelper(DocumentHelper.class).checkDisplayTableOfContents();
        return this;
    }

    public GfDocumentPage checkInfoBarWidgetWork() {
        getHelper(DocumentHelper.class).checkInfoBarWidgetWork();
        return this;
    }

    public GfDocumentPage checkFooter() {
        getHelper(DocumentHelper.class).checkFooter();
        return this;
    }

    public GfDocumentPage checkExtendedSearchButtonIsPresent() {
        getHelper(DocumentHelper.class).checkExtendedSearchButtonIsPresent();
        return this;
    }

    public GfDocumentPage checkHelpWidgetIsPresent() {
        getHelper(DocumentHelper.class).checkHelpWidgetIsPresent();
        return this;
    }

    public GfDocumentPage checkSearchInTextWidgetIsPresent() {
        getHelper(DocumentHelper.class).checkSearchInTextWidgetIsPresent();
        return this;
    }

    public GfDocumentPage checkRevisionHistoryIsPresent() {
        getHelper(DocumentHelper.class).checkRevisionHistoryLinkIsPresent();
        return this;
    }

    public GfDocumentPage checkMoreOnTheTopicIsPresent() {
        getHelper(DocumentHelper.class).checkMoreOnTheTopicIsPresent();
        return this;
    }

    public GfDocumentPage checkPrintButtonInKodeksIsPresent() {
        getHelper(DocumentHelper.class).checkPrintButtonInKodeksIsPresent();
        return this;
    }

    public GfDocumentPage checkSendButtonIsPresentForKodeks() {
        getHelper(DocumentHelper.class).checkSendButtonIsPresentForKodeks();
        return this;
    }

    public GfDocumentPage checkBacklinksArePresent() {
        getHelper(DocumentHelper.class).checkBacklinksArePresent();
        return this;
    }

    public GfDocumentPage checkCommentsArePresent() {
        getHelper(DocumentHelper.class).checkCommentsArePresent();
        return this;
    }

    public GfDocumentPage clickOnMoreLinksFromInfobarOfTheDocument() {
        getHelper(DocumentHelper.class).clickOnMoreLinksFromInfobarOfTheDocument();
        return this;
    }

    public GfDocumentPage checkMoreLinksLinkHasYellowHighlightAfterClicking() {
        getHelper(DocumentHelper.class).checkMoreLinksLinkHasYellowHighlightAfterClicking();
        return this;
    }

    public GfDocumentPage checkMoreLinksBlockIsOpened() {
        getHelper(DocumentHelper.class).checkMoreLinksBlockIsOpened();
        return this;
    }

    public GfDocumentPage checkMoreLinksHasTitleLinks() {
        getHelper(DocumentHelper.class).checkMoreLinksHasTitleLinks();
        return this;
    }

    public GfDocumentPage clickOnMoreLinksRandomLink() {
        getHelper(DocumentHelper.class).clickOnMoreLinksRandomLink();
        return this;
    }

    public GfDocumentPage checkMoreLinksAreDuplicatedBelowOfTheDocument() {
        getHelper(DocumentHelper.class).checkMoreLinksAreDuplicatedBelowOfTheDocument();
        return this;
    }

    public GfDocumentPage clickOnLinksFromInfobarInBottom() {
        getHelper(DocumentHelper.class).clickOnLinksFromInfobarInBottom();
        return this;
    }

    public GfDocumentPage checkStickyHeaderIsGray() {
        getHelper(DocumentHelper.class).checkStickyHeaderIsGray();
        return this;
    }

    public GfDocumentPage clickOnStickyHeader() {
        getHelper(DocumentHelper.class).clickOnStickyHeader();
        return this;
    }

    public GfDocumentPage checkStickyHeaderIsNotPresent() {
        getHelper(DocumentHelper.class).checkStickyHeaderIsNotPresent();
        return this;
    }

    public GfDocumentPage checkStickyHeaderScrolling() {
        getHelper(DocumentHelper.class).checkStickyHeaderScrolling();
        return this;
    }

    public GfDocumentPage checkQuickTocHasNumbers() {
        getHelper(DocumentHelper.class).checkQuickTocHasNumbers();
        return this;
    }

    public GfDocumentPage checkQuickTocDoesNotContainItemsReferencesAndLinks() {
        getHelper(DocumentHelper.class).checkQuickTocDoesNotContainItemsReferencesAndLinks();
        return this;
    }

    public GfDocumentPage checkScrolling() {
        getHelper(DocumentHelper.class).checkScrolling();
        return this;
    }

    public GfDocumentPage clickOnRevisionHistoryLink() {
        getHelper(DocumentHelper.class).clickOnRevisionHistoryLink();
        return this;
    }

    public GfDocumentPage checkRevisionHistoryBlockIsOpened() {
        getHelper(DocumentHelper.class).checkRevisionHistoryBlockIsOpened();
        return this;
    }

    public GfDocumentPage checkRevisionHistoryTitleSpeciallyActionsIsPresent() {
        getHelper(DocumentHelper.class).checkRevisionHistoryTitleSpeciallyActionsIsPresent();
        return this;
    }

    public GfDocumentPage checkRevisionHistoryTitleContainsInDocumentIsPresent() {
        getHelper(DocumentHelper.class).checkRevisionHistoryTitleContainsInDocumentIsPresent();
        return this;
    }

    public GfDocumentPage clickOnRandomDocumentFromRevisionHistoryList() {
        getHelper(DocumentHelper.class).clickOnRandomDocumentFromRevisionHistoryList();
        return this;
    }

    public GfDocumentPage checkDocumentRegionYellowTipFor(String region) {
        getHelper(DocumentHelper.class).checkDocumentRegionYellowTipFor(region);
        return this;
    }

    public GfDocumentPage checkApplicationsWidgetIsPresent() {
        getHelper(DocumentHelper.class).checkApplicationsWidgetIsPresent();
        return this;
    }

    public GfDocumentPage clickOnInfobarApplicationsLink() {
        getHelper(DocumentHelper.class).clickOnInfobarApplicationsLink();
        return this;
    }

    public GfDocumentPage checkApplicationsTextsArePresent() {
        getHelper(AttachmentsInfobar.class).checkApplicationsTextsArePresent();
        return this;
    }

    public GfDocumentPage checkAttachedFilesAreAvailable() {
        getHelper(AttachmentsInfobar.class).checkAttachedFilesAreAvailable();
        return this;
    }

    public GfDocumentPage checkApplicationsExtensionsArePresent() {
        getHelper(AttachmentsInfobar.class).checkApplicationsExtensionsArePresent();
        return this;
    }
}
