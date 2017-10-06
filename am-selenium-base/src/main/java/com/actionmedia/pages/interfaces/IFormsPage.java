package com.actionmedia.pages.interfaces;

/**
 * Created by Pavel on 22/06/16.
 */
public interface IFormsPage extends ISystemBasePage {

    IFormsPage checkTitle(String titleName);

    IFormsPage checkNewsBlocksArePresent();

    IFormsPage checkNewsBlocksTitlesArePresent();

    IFormsPage checkNewsBlocksDatesSortedInDescendingOrder();

    IFormsPage checkNewsBlocksHaveTitleAndDescription();

    IFormsPage checkPictureForFirstNewsIsPresent();

    IFormsPage checkNewsLoadedAfterScrollingDown();

    IDocumentPage clickOnRandomLinkFromNewsBlock();

    IFormsPage scrollSeveralTimes(int times);

    IFormsPage checkPopularBlockIsPresent();

    IFormsPage checkPopularBlockDocumentLinksArePresent();

    IFormsPage checkPopularBlockMarkersArePresent();

    IDocumentPage clickOnRandomLinkFromPopularBlock();

    IFormsPage checkMyFavoritesRubricatorButtonIsPresent();

    IFormsPage checkRubricatorButtonIsPresent(String name);

    IFormsPage checkDefaultStateFormsPage();
}
