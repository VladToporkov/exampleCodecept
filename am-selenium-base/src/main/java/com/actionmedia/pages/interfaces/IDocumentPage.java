package com.actionmedia.pages.interfaces;

/**
 * Created by Alex on 27.05.2016 027.
 */
public interface IDocumentPage extends ISystemBasePage {

    IDocumentPage checkApplicationsWidgetIsPresent();

    IDocumentPage clickOnInfobarApplicationsLink();

    IDocumentPage checkCurrentUrlContainsDocumentUrl(String url);

    IDocumentPage checkApplicationsTextsArePresent();

    IDocumentPage checkApplicationsExtensionsArePresent();

    IDocumentPage checkAttachedFilesAreAvailable();

    IDocumentPage checkDownloadShowExamplesLinkIsNotPresent();

    IDocumentPage checkDownloadShowExampleLinkIsNotPresent();

    IDocumentPage checkRubricatorButtonIsPresent(String name);

    IDocumentPage checkCommonView118(String name);

    IDocumentPage checkDocumentIsOpened();

    IDocumentPage checkVideoPlayerIsPresent();

    IDocumentPage checkVideoTitleIsPresent();

    IDocumentPage checkMetaTagsAndTableOfContents();

    IDocumentPage checkMetaTagsAndSavedDataContent();
}
