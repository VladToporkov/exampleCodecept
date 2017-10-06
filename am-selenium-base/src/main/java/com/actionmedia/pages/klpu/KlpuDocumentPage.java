package com.actionmedia.pages.klpu;

import com.actionmedia.components.info.AttachmentsInfobar;
import com.actionmedia.pages.helpers.DocumentHelper;
import com.actionmedia.pages.interfaces.IDocumentPage;
import org.springframework.stereotype.Component;

/**
 * Created by Pavel on 24/06/16.
 */
@Component
public class KlpuDocumentPage extends KlpuBasePage<KlpuDocumentPage> implements IDocumentPage {

    @Override
    public KlpuDocumentPage checkVideoPlayerIsPresent() {
        getHelper(DocumentHelper.class).checkVideoPlayerIsPresent();
        return redirectTo(KlpuDocumentPage.class);
    }

    @Override
    public KlpuDocumentPage checkVideoTitleIsPresent() {
        getHelper(DocumentHelper.class).checkVideoTitleIsPresent();
        return redirectTo(KlpuDocumentPage.class);
    }

    public KlpuDocumentPage checkDocumentIsOpened() {
        getHelper(DocumentHelper.class).checkDocumentIsOpened();
        return this;
    }

    @Override
    public KlpuDocumentPage checkDownloadShowExamplesLinkIsNotPresent() {
        getHelper(DocumentHelper.class).checkDownloadShowExamplesLinkIsNotPresent();
        return this;
    }

    @Override
    public KlpuDocumentPage checkDownloadShowExampleLinkIsNotPresent() {
        getHelper(DocumentHelper.class).checkDownloadShowExampleLinkIsNotPresent();
        return this;
    }

    @Override
    public KlpuDocumentPage checkApplicationsWidgetIsPresent() {
        getHelper(DocumentHelper.class).checkApplicationsWidgetIsPresent();
        return this;
    }

    @Override
    public KlpuDocumentPage clickOnInfobarApplicationsLink() {
        getHelper(DocumentHelper.class).clickOnInfobarApplicationsLink();
        return this;
    }

    @Override
    public KlpuDocumentPage checkApplicationsTextsArePresent() {
        getHelper(AttachmentsInfobar.class).checkApplicationsTextsArePresent();
        return this;
    }

    @Override
    public KlpuDocumentPage checkApplicationsExtensionsArePresent() {
        getHelper(AttachmentsInfobar.class).checkApplicationsExtensionsArePresent();
        return this;
    }

    @Override
    public KlpuDocumentPage checkAttachedFilesAreAvailable() {
        getHelper(AttachmentsInfobar.class).checkAttachedFilesAreAvailable();
        return this;
    }

    @Override
    public KlpuDocumentPage checkCommonView118(String name) {
        getHelper(DocumentHelper.class).checkCommonView118(name);
        return null;
    }

    public KlpuDocumentPage checkMetaTagsAndTableOfContents() {
        getHelper(DocumentHelper.class).checkMetaTagsAndTableOfContents();
        return this;
    }

    public KlpuDocumentPage checkMetaTagsAndSavedDataContent() {
        getHelper(DocumentHelper.class).checkMetaTagsAndSavedDataContent();
        return this;
    }
}
