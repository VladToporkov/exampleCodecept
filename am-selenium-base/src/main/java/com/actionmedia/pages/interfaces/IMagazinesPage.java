package com.actionmedia.pages.interfaces;

import org.springframework.stereotype.Component;

/**
 * Created by Pavel on 15/07/16.
 */
@Component
public interface IMagazinesPage extends ISystemBasePage {

    IMagazinesPage checkDefaultStateMagazinesPage();

    IMagazinesPage checkNewInMagazinesShelfIsPresent();
    IMagazinesPage checkNewInMagazinesShelfNewMagazinesIsPresent();
    IMagazinesPage checkNewInMagazinesShelfMagazinesAreNotRepeated();
    IMagazinesPage checkNewInMagazinesShelfMagazinesAreDescending();
    IMagazinesPage checkNewInMagazinesShelfMagazinesHasNumberAndYearOfPublishing();

    IMagazinesPage clickOnNewInMagazinesShelfRightArrow();
    IMagazinesPage checkNewInMagazinesShelfNewMagazinesArePresentAfterClicking();
    IMagazinesPage clickOnNewInMagazinesShelfLeftArrow();
    IMagazinesPage checkNewInMagazinesShelfArrowsArePresent();
    IDocumentPage clickOnNewInMagazinesShelfRandomDisplayedMagazineOrBook();

    IMagazinesPage checkBookShelfIsPresent();
    IMagazinesPage checkBooksShelfHasPopularTitle();
    IMagazinesPage checkBooksShelfHasAllBooksTitle();
    IMagazinesPage checkBooksShelfPopularBlockHasThreeItems();
    IMagazinesPage checkBooksShelfPopularBooksAreNotRepeated();
    IMagazinesPage checkBooksShelfAllBooksBlockIsPresent();
    IMagazinesPage checkBooksShelfHasOnlyBooks();

    IMagazinesPage clickOnBooksShelfRightArrow();
    IMagazinesPage clickOnBooksShelfLeftArrow();
    IMagazinesPage checkBooksShelfNewBooksArePresentAfterClicking();
    IMagazinesPage checkBooksShelfArrowsArePresent();
    IDocumentPage clickOnBooksShelfRandomBook();
}
