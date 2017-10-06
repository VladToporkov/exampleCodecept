package com.actionmedia.pages.interfaces;

/**
 * Created by Alex on 27.05.2016 027.
 */
public interface ISystemBasePage {

    IDocumentPage openDocumentByModuleIdAndDocId(String documentUrl);

    IRecomendPage navigateToRecomendPage();

    IFormsPage navigateToFormsPage();
    IMagazinesPage navigateToMagazinesPage();

    IRubricator clickRubricatorButton();

    ISystemBasePage logout();
}
