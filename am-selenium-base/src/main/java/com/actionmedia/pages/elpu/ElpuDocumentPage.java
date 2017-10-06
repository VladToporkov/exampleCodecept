package com.actionmedia.pages.elpu;

import com.actionmedia.components.info.AttachmentsInfobar;
import com.actionmedia.pages.helpers.DocumentHelper;
import com.actionmedia.pages.interfaces.IDocumentPage;
import org.springframework.stereotype.Component;

/**
 * Created by Pavel on 24/06/16.
 */
@Component
public class ElpuDocumentPage extends ElpuBasePage<ElpuDocumentPage> implements IDocumentPage {

    @Override
    public ElpuDocumentPage checkVideoPlayerIsPresent() {
        getHelper(DocumentHelper.class).checkVideoPlayerIsPresent();
        return redirectTo(ElpuDocumentPage.class);
    }

    @Override
    public ElpuDocumentPage checkVideoTitleIsPresent() {
        getHelper(DocumentHelper.class).checkVideoTitleIsPresent();
        return redirectTo(ElpuDocumentPage.class);
    }

    public ElpuDocumentPage checkDocumentIsOpened() {
        getHelper(DocumentHelper.class).checkDocumentIsOpened();
        return this;
    }

    @Override
    public ElpuDocumentPage checkDownloadShowExamplesLinkIsNotPresent() {
        getHelper(DocumentHelper.class).checkDownloadShowExamplesLinkIsNotPresent();
        return this;
    }

    @Override
    public ElpuDocumentPage checkDownloadShowExampleLinkIsNotPresent() {
        getHelper(DocumentHelper.class).checkDownloadShowExampleLinkIsNotPresent();
        return this;
    }

    @Override
    public ElpuDocumentPage checkApplicationsWidgetIsPresent() {
        getHelper(DocumentHelper.class).checkApplicationsWidgetIsPresent();
        return this;
    }

    @Override
    public ElpuDocumentPage clickOnInfobarApplicationsLink() {
        getHelper(DocumentHelper.class).clickOnInfobarApplicationsLink();
        return this;
    }

    @Override
    public ElpuDocumentPage checkApplicationsTextsArePresent() {
        getHelper(AttachmentsInfobar.class).checkApplicationsTextsArePresent();
        return this;
    }

    @Override
    public ElpuDocumentPage checkApplicationsExtensionsArePresent() {
        getHelper(AttachmentsInfobar.class).checkApplicationsExtensionsArePresent();
        return this;
    }

    @Override
    public ElpuDocumentPage checkAttachedFilesAreAvailable() {
        getHelper(AttachmentsInfobar.class).checkAttachedFilesAreAvailable();
        return this;
    }

    @Override
    public ElpuDocumentPage checkCommonView118(String name) {
        getHelper(DocumentHelper.class).checkCommonView118(name);
        return null;
    }

    public ElpuDocumentPage checkMetaTagsAndTableOfContents() {
        getHelper(DocumentHelper.class).checkMetaTagsAndTableOfContents();
        return this;
    }

    public ElpuDocumentPage checkMetaTagsAndSavedDataContent() {
        getHelper(DocumentHelper.class).checkMetaTagsAndSavedDataContent();
        return this;
    }

    public ElpuDocumentPage checkPudDateJournal() {
        getHelper(DocumentHelper.class).checkPudDateJournal();
        return this;
    }

    public ElpuDocumentPage checkArticleTitle() {
        getHelper(DocumentHelper.class).checkArticleTitle();
        return this;
    }

    public ElpuDocumentPage checkDisplayTextInJournal() {
        getHelper(DocumentHelper.class).checkDisplayTextInJournal();
        return this;
    }

    public ElpuDocumentPage checkInMyFavoritesIcon() {
        getHelper(DocumentHelper.class).checkInMyFavoritesIcon();
        return this;
    }

    public ElpuDocumentPage checkBrowseIcon() {
        getHelper(DocumentHelper.class).checkBrowseIcon();
        return this;
    }

    public ElpuDocumentPage checkShareIcon() {
        getHelper(DocumentHelper.class).checkShareIcon();
        return this;
    }

    public ElpuDocumentPage checkBackwardIcon() {
        getHelper(DocumentHelper.class).checkBackwardIcon();
        return this;
    }

    public ElpuDocumentPage checkForwardIcon() {
        getHelper(DocumentHelper.class).checkForwardIcon();
        return this;
    }

    public ElpuDocumentPage checkPrintIcon() {
        getHelper(DocumentHelper.class).checkPrintIcon();
        return this;
    }

    public ElpuDocumentPage checkWordButtonIsPresent() {
        getHelper(DocumentHelper.class).checkWordButtonIsPresent();
        return this;
    }

    public ElpuDocumentPage checkSoderButtonIsPresent() {
        getHelper(DocumentHelper.class).checkSoderButtonIsPresent();
        return this;
    }
}
