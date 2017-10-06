package com.actionmedia.pages.cult;

import com.actionmedia.components.info.AttachmentsInfobar;
import com.actionmedia.pages.helpers.DocumentHelper;
import com.actionmedia.pages.interfaces.IDocumentPage;
import org.springframework.stereotype.Component;

/**
 * Created by Pavel on 29/06/16.
 */
@Component
public class CultDocumentPage extends CultBasePage<CultDocumentPage> implements IDocumentPage {

    @Override
    public CultDocumentPage checkVideoPlayerIsPresent() {
        getHelper(DocumentHelper.class).checkVideoPlayerIsPresent();
        return redirectTo(CultDocumentPage.class);
    }

    @Override
    public CultDocumentPage checkVideoTitleIsPresent() {
        getHelper(DocumentHelper.class).checkVideoTitleIsPresent();
        return redirectTo(CultDocumentPage.class);
    }

    @Override
    public CultDocumentPage checkApplicationsWidgetIsPresent() {
        getHelper(DocumentHelper.class).checkApplicationsWidgetIsPresent();
        return this;
    }

    @Override
    public CultDocumentPage clickOnInfobarApplicationsLink() {
        getHelper(DocumentHelper.class).clickOnInfobarApplicationsLink();
        return this;
    }

    @Override
    public CultDocumentPage checkApplicationsTextsArePresent() {
        getHelper(AttachmentsInfobar.class).checkApplicationsTextsArePresent();
        return this;
    }

    @Override
    public CultDocumentPage checkApplicationsExtensionsArePresent() {
        getHelper(AttachmentsInfobar.class).checkApplicationsExtensionsArePresent();
        return this;
    }

    @Override
    public CultDocumentPage checkAttachedFilesAreAvailable() {
        getHelper(AttachmentsInfobar.class).checkAttachedFilesAreAvailable();
        return this;
    }

    @Override
    public IDocumentPage checkDocumentIsOpened() {
        getHelper(DocumentHelper.class).checkDocumentIsOpened();
        return this;
    }

    @Override
    public CultDocumentPage checkCommonView118(String name) {
        getHelper(DocumentHelper.class).checkCommonView118(name);
        return this;
    }

    @Override
    public CultDocumentPage checkDownloadShowExamplesLinkIsNotPresent() {
        getHelper(DocumentHelper.class).checkDownloadShowExamplesLinkIsNotPresent();
        return this;
    }

    @Override
    public CultDocumentPage checkDownloadShowExampleLinkIsNotPresent() {
        getHelper(DocumentHelper.class).checkDownloadShowExampleLinkIsNotPresent();
        return this;
    }

    public CultDocumentPage checkMetaTagsAndTableOfContents() {
        getHelper(DocumentHelper.class).checkMetaTagsAndTableOfContents();
        return this;
    }

    public CultDocumentPage checkMetaTagsAndSavedDataContent() {
        getHelper(DocumentHelper.class).checkMetaTagsAndSavedDataContent();
        return this;
    }
    
    public CultDocumentPage checkPudDateJournal() {
        getHelper(DocumentHelper.class).checkPudDateJournal();
        return this;
    }

    public CultDocumentPage checkArticleTitle() {
        getHelper(DocumentHelper.class).checkArticleTitle();
        return this;
    }

    public CultDocumentPage checkDisplayTextInJournal() {
        getHelper(DocumentHelper.class).checkDisplayTextInJournal();
        return this;
    }

    public CultDocumentPage checkInMyFavoritesIcon() {
        getHelper(DocumentHelper.class).checkInMyFavoritesIcon();
        return this;
    }

    public CultDocumentPage checkBrowseIcon() {
        getHelper(DocumentHelper.class).checkBrowseIcon();
        return this;
    }

    public CultDocumentPage checkShareIcon() {
        getHelper(DocumentHelper.class).checkShareIcon();
        return this;
    }

    public CultDocumentPage checkBackwardIcon() {
        getHelper(DocumentHelper.class).checkBackwardIcon();
        return this;
    }

    public CultDocumentPage checkForwardIcon() {
        getHelper(DocumentHelper.class).checkForwardIcon();
        return this;
    }

    public CultDocumentPage checkSoderButtonIsPresent() {
        getHelper(DocumentHelper.class).checkSoderButtonIsPresent();
        return this;
    }

    public CultDocumentPage checkPrintIcon() {
        getHelper(DocumentHelper.class).checkPrintIcon();
        return this;
    }

    public CultDocumentPage checkWordButtonIsPresent() {
        getHelper(DocumentHelper.class).checkWordButtonIsPresent();
        return this;
    }
}
