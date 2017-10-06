package com.actionmedia.pages.go;

import com.actionmedia.components.info.AttachmentsInfobar;
import com.actionmedia.pages.helpers.DocumentHelper;
import com.actionmedia.pages.interfaces.IDocumentPage;
import org.springframework.stereotype.Component;

/**
 * Created by Pavel on 11/05/16.
 */
@Component
public class GoDocumentPage extends GoBasePage<GoDocumentPage> implements IDocumentPage {

    public GoDocumentPage checkDocumentIsOpened() {
        getHelper(DocumentHelper.class).checkDocumentIsOpened();
        return this;
    }

    @Override
    public GoDocumentPage checkDownloadShowExamplesLinkIsNotPresent() {
        getHelper(DocumentHelper.class).checkDownloadShowExamplesLinkIsNotPresent();
        return this;
    }

    @Override
    public GoDocumentPage checkDownloadShowExampleLinkIsNotPresent() {
        getHelper(DocumentHelper.class).checkDownloadShowExampleLinkIsNotPresent();
        return this;
    }

    @Override
    public IDocumentPage checkCommonView118(String name) {
        getHelper(DocumentHelper.class).checkCommonView118(name);
        return this;
    }

    public GoDocumentPage checkExtendedSearchButtonIsPresent() {
        getHelper(DocumentHelper.class).checkExtendedSearchButtonIsPresent();
        return this;
    }

    public GoDocumentPage checkAddToFavoritesButtonsForDocumentArePresent() {
        getHelper(DocumentHelper.class).checkAddToFavoritesButtonsForDocumentArePresent();
        return this;
    }

    public GoDocumentPage checkHelpWidgetIsPresent() {
        getHelper(DocumentHelper.class).checkHelpWidgetIsPresent();
        return this;
    }

    public GoDocumentPage checkSearchInTextWidgetIsPresent() {
        getHelper(DocumentHelper.class).checkSearchInTextWidgetIsPresent();
        return this;
    }

    public GoDocumentPage checkRevisionHistoryIsPresent() {
        getHelper(DocumentHelper.class).checkRevisionHistoryLinkIsPresent();
        return this;
    }

    public GoDocumentPage checkMoreOnTheTopicIsPresent() {
        getHelper(DocumentHelper.class).checkMoreOnTheTopicIsPresent();
        return this;
    }

    public GoDocumentPage checkPrintButtonInKodeksIsPresent() {
        getHelper(DocumentHelper.class).checkPrintButtonInKodeksIsPresent();
        return this;
    }

    public GoDocumentPage checkSendButtonIsPresentForKodeks() {
        getHelper(DocumentHelper.class).checkSendButtonIsPresentForKodeks();
        return this;
    }

    public GoDocumentPage checkBacklinksArePresent() {
        getHelper(DocumentHelper.class).checkBacklinksArePresent();
        return this;
    }

    public GoDocumentPage checkCommentsArePresent() {
        getHelper(DocumentHelper.class).checkCommentsArePresent();
        return this;
    }

    public GoDocumentPage checkWordButtonIsPresent() {
        getHelper(DocumentHelper.class).checkWordButtonIsPresent();
        return this;
    }

    public GoDocumentPage checkSoderIsPresent() {
        getHelper(DocumentHelper.class).checkSoderIsPresent();
        return this;
    }

    public GoDocumentPage checkRubricatorButtonIsPresent(String buttonName) {
        getHelper(DocumentHelper.class).checkRubricatorButtonIsPresent(buttonName);
        return this;
    }

    public GoDocumentPage checkSoderButtonIsPresent() {
        getHelper(DocumentHelper.class).checkSoderButtonIsPresent();
        return this;
    }

    public GoDocumentPage clickOnMoreLinksFromInfobarOfTheDocument() {
        getHelper(DocumentHelper.class).clickOnMoreLinksFromInfobarOfTheDocument();
        return this;
    }

    public GoDocumentPage checkMoreLinksLinkHasYellowHighlightAfterClicking() {
        getHelper(DocumentHelper.class).checkMoreLinksLinkHasYellowHighlightAfterClicking();
        return this;
    }

    public GoDocumentPage checkMoreLinksBlockIsOpened() {
        getHelper(DocumentHelper.class).checkMoreLinksBlockIsOpened();
        return this;
    }

    public GoDocumentPage checkMoreLinksHasTitleLinks() {
        getHelper(DocumentHelper.class).checkMoreLinksHasTitleLinks();
        return this;
    }

    public GoDocumentPage clickOnMoreLinksRandomLink() {
        getHelper(DocumentHelper.class).clickOnMoreLinksRandomLink();
        return this;
    }

    public GoDocumentPage checkMoreLinksAreDuplicatedBelowOfTheDocument() {
        getHelper(DocumentHelper.class).checkMoreLinksAreDuplicatedBelowOfTheDocument();
        return this;
    }

    public GoDocumentPage clickOnLinksFromInfobarInBottom() {
        getHelper(DocumentHelper.class).clickOnLinksFromInfobarInBottom();
        return this;
    }

    public GoDocumentPage checkStickyHeaderIsGray() {
        getHelper(DocumentHelper.class).checkStickyHeaderIsGray();
        return this;
    }

    public GoDocumentPage clickOnStickyHeader() {
        getHelper(DocumentHelper.class).clickOnStickyHeader();
        return this;
    }

    public GoDocumentPage checkStickyHeaderIsNotPresent() {
        getHelper(DocumentHelper.class).checkStickyHeaderIsNotPresent();
        return this;
    }

    public GoDocumentPage checkStickyHeaderScrolling() {
        getHelper(DocumentHelper.class).checkStickyHeaderScrolling();
        return this;
    }

    public GoDocumentPage checkQuickTocHasNumbers() {
        getHelper(DocumentHelper.class).checkQuickTocHasNumbers();
        return this;
    }

    public GoDocumentPage checkQuickTocDoesNotContainItemsReferencesAndLinks() {
        getHelper(DocumentHelper.class).checkQuickTocDoesNotContainItemsReferencesAndLinks();
        return this;
    }

    public GoDocumentPage checkScrolling() {
        getHelper(DocumentHelper.class).checkScrolling();
        return this;
    }

    public GoDocumentPage clickOnRevisionHistoryLink() {
        getHelper(DocumentHelper.class).clickOnRevisionHistoryLink();
        return this;
    }

    public GoDocumentPage checkRevisionHistoryBlockIsOpened() {
        getHelper(DocumentHelper.class).checkRevisionHistoryBlockIsOpened();
        return this;
    }

    public GoDocumentPage checkRevisionHistoryTitleSpeciallyActionsIsPresent() {
        getHelper(DocumentHelper.class).checkRevisionHistoryTitleSpeciallyActionsIsPresent();
        return this;
    }

    public GoDocumentPage checkRevisionHistoryTitleContainsInDocumentIsPresent() {
        getHelper(DocumentHelper.class).checkRevisionHistoryTitleContainsInDocumentIsPresent();
        return this;
    }

    public GoDocumentPage clickOnRandomDocumentFromRevisionHistoryList() {
        getHelper(DocumentHelper.class).clickOnRandomDocumentFromRevisionHistoryList();
        return this;
    }

    public GoDocumentPage checkApplicationsWidgetIsPresent() {
        getHelper(DocumentHelper.class).checkApplicationsWidgetIsPresent();
        return this;
    }

    public GoDocumentPage clickOnInfobarApplicationsLink() {
        getHelper(DocumentHelper.class).clickOnInfobarApplicationsLink();
        return this;
    }

    public GoDocumentPage checkApplicationsTextsArePresent() {
        getHelper(AttachmentsInfobar.class).checkApplicationsTextsArePresent();
        return this;
    }

    public GoDocumentPage checkAttachedFilesAreAvailable() {
        getHelper(AttachmentsInfobar.class).checkAttachedFilesAreAvailable();
        return this;
    }

    public GoDocumentPage checkApplicationsExtensionsArePresent() {
        getHelper(AttachmentsInfobar.class).checkApplicationsExtensionsArePresent();
        return this;
    }

    @Override
    public GoDocumentPage checkVideoPlayerIsPresent() {
        getHelper(DocumentHelper.class).checkVideoPlayerIsPresent();
        return redirectTo(GoDocumentPage.class);
    }

    @Override
    public GoDocumentPage checkVideoTitleIsPresent() {
        getHelper(DocumentHelper.class).checkVideoTitleIsPresent();
        return redirectTo(GoDocumentPage.class);
    }

    public GoDocumentPage checkMetaTagsAndTableOfContents() {
        getHelper(DocumentHelper.class).checkMetaTagsAndTableOfContents();
        return this;
    }

    public GoDocumentPage checkMetaTagsAndSavedDataContent() {
        getHelper(DocumentHelper.class).checkMetaTagsAndSavedDataContent();
        return this;
    }

    public GoDocumentPage checkPudDateJournal() {
        getHelper(DocumentHelper.class).checkPudDateJournal();
        return this;
    }

    public GoDocumentPage checkArticleTitle() {
        getHelper(DocumentHelper.class).checkArticleTitle();
        return this;
    }

    public GoDocumentPage checkDisplayTextInJournal() {
        getHelper(DocumentHelper.class).checkDisplayTextInJournal();
        return this;
    }

    public GoDocumentPage checkInMyFavoritesIcon() {
        getHelper(DocumentHelper.class).checkInMyFavoritesIcon();
        return this;
    }

    public GoDocumentPage checkBrowseIcon() {
        getHelper(DocumentHelper.class).checkBrowseIcon();
        return this;
    }

    public GoDocumentPage checkShareIcon() {
        getHelper(DocumentHelper.class).checkShareIcon();
        return this;
    }

    public GoDocumentPage checkBackwardIcon() {
        getHelper(DocumentHelper.class).checkBackwardIcon();
        return this;
    }

    public GoDocumentPage checkForwardIcon() {
        getHelper(DocumentHelper.class).checkForwardIcon();
        return this;
    }

    public GoDocumentPage checkPrintIcon() {
        getHelper(DocumentHelper.class).checkPrintIcon();
        return this;
    }
}
