package com.actionmedia.pages.umd;

import com.actionmedia.components.info.AttachmentsInfobar;
import com.actionmedia.pages.helpers.DocumentHelper;
import com.actionmedia.pages.interfaces.IDocumentPage;
import org.springframework.stereotype.Component;

/**
 * Created by Pavel on 24/06/16.
 */
@Component
public class UmdDocumentPage extends UmdBasePage<UmdDocumentPage> implements IDocumentPage {

    public UmdDocumentPage checkDocumentIsOpened() {
        getHelper(DocumentHelper.class).checkDocumentIsOpened();
        return this;
    }

    @Override
    public UmdDocumentPage checkVideoPlayerIsPresent() {
        getHelper(DocumentHelper.class).checkVideoPlayerIsPresent();
        return redirectTo(UmdDocumentPage.class);
    }

    @Override
    public UmdDocumentPage checkVideoTitleIsPresent() {
        getHelper(DocumentHelper.class).checkVideoTitleIsPresent();
        return redirectTo(UmdDocumentPage.class);
    }

    @Override
    public UmdDocumentPage checkDownloadShowExamplesLinkIsNotPresent() {
        getHelper(DocumentHelper.class).checkDownloadShowExamplesLinkIsNotPresent();
        return this;
    }

    @Override
    public UmdDocumentPage checkDownloadShowExampleLinkIsNotPresent() {
        getHelper(DocumentHelper.class).checkDownloadShowExampleLinkIsNotPresent();
        return this;
    }

    @Override
    public UmdDocumentPage checkApplicationsWidgetIsPresent() {
        getHelper(DocumentHelper.class).checkApplicationsWidgetIsPresent();
        return this;
    }

    @Override
    public UmdDocumentPage clickOnInfobarApplicationsLink() {
        getHelper(DocumentHelper.class).clickOnInfobarApplicationsLink();
        return this;
    }

    @Override
    public UmdDocumentPage checkApplicationsTextsArePresent() {
        getHelper(AttachmentsInfobar.class).checkApplicationsTextsArePresent();
        return this;
    }

    @Override
    public UmdDocumentPage checkApplicationsExtensionsArePresent() {
        getHelper(AttachmentsInfobar.class).checkApplicationsExtensionsArePresent();
        return this;
    }

    @Override
    public UmdDocumentPage checkAttachedFilesAreAvailable() {
        getHelper(AttachmentsInfobar.class).checkAttachedFilesAreAvailable();
        return this;
    }

    @Override
    public UmdDocumentPage checkCommonView118(String name) {
        getHelper(DocumentHelper.class).checkCommonView118(name);
        return null;
    }

    public UmdDocumentPage checkMetaTagsAndTableOfContents() {
        getHelper(DocumentHelper.class).checkMetaTagsAndTableOfContents();
        return this;
    }

    public UmdDocumentPage checkMetaTagsAndSavedDataContent() {
        getHelper(DocumentHelper.class).checkMetaTagsAndSavedDataContent();
        return this;
    }

    public UmdDocumentPage checkPudDateJournal() {
        getHelper(DocumentHelper.class).checkPudDateJournal();
        return this;
    }

    public UmdDocumentPage checkArticleTitle() {
        getHelper(DocumentHelper.class).checkArticleTitle();
        return this;
    }

    public UmdDocumentPage checkDisplayTextInJournal() {
        getHelper(DocumentHelper.class).checkDisplayTextInJournal();
        return this;
    }

    public UmdDocumentPage checkInMyFavoritesIcon() {
        getHelper(DocumentHelper.class).checkInMyFavoritesIcon();
        return this;
    }

    public UmdDocumentPage checkBrowseIcon() {
        getHelper(DocumentHelper.class).checkBrowseIcon();
        return this;
    }

    public UmdDocumentPage checkShareIcon() {
        getHelper(DocumentHelper.class).checkShareIcon();
        return this;
    }

    public UmdDocumentPage checkBackwardIcon() {
        getHelper(DocumentHelper.class).checkBackwardIcon();
        return this;
    }

    public UmdDocumentPage checkForwardIcon() {
        getHelper(DocumentHelper.class).checkForwardIcon();
        return this;
    }

    public UmdDocumentPage checkPrintIcon() {
        getHelper(DocumentHelper.class).checkPrintIcon();
        return this;
    }

    public UmdDocumentPage checkWordButtonIsPresent() {
        getHelper(DocumentHelper.class).checkWordButtonIsPresent();
        return this;
    }

    public UmdDocumentPage checkSoderButtonIsPresent() {
        getHelper(DocumentHelper.class).checkSoderButtonIsPresent();
        return this;
    }
}
