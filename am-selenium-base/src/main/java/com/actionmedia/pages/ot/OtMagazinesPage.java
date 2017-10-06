package com.actionmedia.pages.ot;

import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.helpers.PressPageHelper;
import com.actionmedia.pages.interfaces.IMagazinesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Pavel on 21/04/16.
 */
@Component
public class OtMagazinesPage extends OTBasePage<OtMagazinesPage> implements IMagazinesPage {

    public OtMagazinesPage checkNewInMagazinesShelfIsPresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfIsPresent();
        return this;
    }

    public OtMagazinesPage checkNewInMagazinesShelfHasTitle() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfHasTitle();
        return this;
    }

    public OtMagazinesPage checkNewInMagazinesShelfNewMagazinesIsPresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfNewMagazinesIsPresent();
        return this;
    }

    public OtMagazinesPage checkNewInMagazinesShelfHasNotTitle() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfHasNotTitle();
        return this;
    }

    public OtMagazinesPage checkNewInMagazinesShelfNewBooksIsPresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfNewBooksIsPresent();
        return this;
    }

    public OtMagazinesPage checkNewInMagazinesShelfContainsMagazine(String magazineName) {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfContainsMagazine(magazineName);
        return this;
    }

    public OtMagazinesPage checkNewInMagazinesShelfMagazinesAreNotRepeated() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfMagazinesAreNotRepeated();
        return this;
    }

    public OtMagazinesPage checkNewInMagazinesShelfMagazinesAreDescending() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfMagazinesAreDescending();
        return this;
    }

    public OtMagazinesPage checkNewInMagazinesShelfMagazinesHasNumberAndYearOfPublishing() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfMagazinesHasNumberAndYearOfPublishing();
        return this;
    }

    public OtMagazinesPage checkNewInMagazinesShelfArrowsArePresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfArrowsArePresent();
        return this;
    }

    public OtMagazinesPage clickOnNewInMagazinesShelfRightArrow() {
        getHelper(PressPageHelper.class).clickOnNewInMagazinesShelfRightArrow();
        return this;
    }

    public OtMagazinesPage clickOnNewInMagazinesShelfLeftArrow() {
        getHelper(PressPageHelper.class).clickOnNewInMagazinesShelfLeftArrow();
        return this;
    }

    public OtMagazinesPage checkNewInMagazinesShelfNewMagazinesArePresentAfterClicking() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfNewMagazinesArePresentAfterClicking();
        return this;
    }

    public OtMagazinesPage checkNewInMagazinesShelfNewBooksIsNotPresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfNewBooksIsNotPresent();
        return this;
    }

    public OtDocumentPage clickOnNewInMagazinesShelfRandomDisplayedMagazineOrBook() {
        getHelper(PressPageHelper.class).clickOnNewInMagazinesShelfRandomDisplayedMagazineOrBook();
        return redirectTo(OtDocumentPage.class);
    }

    public OtMagazinesPage checkMagazinesShelvesArePresent() {
        getHelper(PressPageHelper.class).checkMagazinesShelvesArePresent();
        return this;
    }

    public OtMagazinesPage checkMagazineShelfHasTitlePopular() {
        getHelper(PressPageHelper.class).checkMagazineShelfHasTitlePopular();
        return this;
    }

    public OtMagazinesPage checkMagazineShelfHasTitleAllMagazines() {
        getHelper(PressPageHelper.class).checkMagazineShelfHasTitleAllMagazines();
        return this;
    }

    public OtMagazinesPage checkMagazinesShelfPopularHasMaxThreeMagazines() {
        getHelper(PressPageHelper.class).checkMagazinesShelfPopularHasMaxThreeMagazines();
        return this;
    }

    public OtMagazinesPage checkMagazinesInPopularBlockAreNotRepeated() {
        getHelper(PressPageHelper.class).checkMagazinesInPopularBlockAreNotRepeated();
        return this;
    }

    public OtMagazinesPage checkMagazinesShelfAllMagazinesAreSortedDescending() {
        getHelper(PressPageHelper.class).checkMagazinesShelfAllMagazinesAreSortedDescending();
        return this;
    }

    public OtMagazinesPage checkMagazinesShelfHasOnlyMagazines() {
        getHelper(PressPageHelper.class).checkMagazinesShelfHasOnlyMagazines();
        return this;
    }

    public OtMagazinesPage checkMagazinesEachShelfHasOneMagazine() {
        getHelper(PressPageHelper.class).checkMagazinesEachShelfHasOneMagazine();
        return this;
    }

    public OtMagazinesPage checkMagazineHasNoShelf(String shelfName) {
        getHelper(PressPageHelper.class).checkMagazineHasNoShelf(shelfName);
        return this;
    }

    public OtMagazinesPage checkMagazinesShelvesHaveNumberAndYearOfPublishing() {
        getHelper(PressPageHelper.class).checkMagazinesShelvesHaveNumberAndYearOfPublishing();
        return this;
    }

    public OtMagazinesPage checkMagazinesShelvesArrowsArePresent() {
        getHelper(PressPageHelper.class).checkMagazinesShelvesArrowsArePresent();
        return this;
    }

    public OtMagazinesPage clickOnMagazinesShelfRightArrow() {
        getHelper(PressPageHelper.class).clickOnMagazinesShelfRightArrow();
        return this;
    }

    public OtMagazinesPage clickOnMagazinesShelvesLeftArrow() {
        getHelper(PressPageHelper.class).clickOnMagazinesShelvesLeftArrow();
        return this;
    }

    public OtMagazinesPage checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking() {
        getHelper(PressPageHelper.class).checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking();
        return this;
    }

    public OtDocumentPage clickOnMagazinesShelvesRandomDisplayedMagazine() {
        getHelper(PressPageHelper.class).clickOnMagazinesShelvesRandomDisplayedMagazine();
        return redirectTo(OtDocumentPage.class);
    }

    public OtMagazinesPage checkBooksBlockIsPresent() {
        getHelper(PressPageHelper.class).checkBooksBlockIsPresent();
        return this;
    }

    public OtMagazinesPage checkMagazineHasShelf(String shelfName) {
        getHelper(PressPageHelper.class).checkMagazineHasShelf(shelfName);
        return this;
    }

    public OtMagazinesPage checkMagazinesRubricatorButtonIsPresent() {
        WebElement rubricatorButton = waitForPresenceOfElementLocatedBy(By.id("rubricator-btn"), "кнопка Все журналы не найдена");
        postponedAssertTrue("Все журналы".equals(rubricatorButton.getText()), "кнопка Все журналы и книги отсутсвует");
        return this;
    }

    @Override
    @Step("Проверяется, что страница журналы открыта")
    public OtMagazinesPage checkDefaultStateMagazinesPage() {
        checkMagazineTabIsSelected();
        checkMagazinesBlockIsPresent();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Журналы и книги'")
    public OtMagazinesPage checkMagazineTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.MAGAZINES);
        return this;
    }

    @Step("Проверяется блок Журналы")
    public OtMagazinesPage checkMagazinesBlockIsPresent() {
        WebElement magazinesBlock = mainContentElement.findElement(By.xpath("//h1[text()='Журналы']"));
        assertNotNull(magazinesBlock, "Блок Журналы не найден");
        postponedAssertTrue(magazinesBlock.isEnabled() && magazinesBlock.isDisplayed(), "Блок Журналы не отображается");
        return this;
    }

    @Override
    public OtMagazinesPage checkBookShelfIsPresent() {
        getHelper(PressPageHelper.class).checkBookShelfIsPresent();
        return this;
    }

    @Override
    public OtMagazinesPage checkBooksShelfHasPopularTitle() {
        getHelper(PressPageHelper.class).checkBooksShelfHasPopularTitle();
        return this;
    }

    @Override
    public OtMagazinesPage checkBooksShelfHasAllBooksTitle() {
        getHelper(PressPageHelper.class).checkBooksShelfHasAllBooksTitle();
        return this;
    }

    @Override
    public OtMagazinesPage checkBooksShelfPopularBlockHasThreeItems() {
        getHelper(PressPageHelper.class).checkBooksShelfPopularBlockHasThreeItems();
        return this;
    }

    @Override
    public OtMagazinesPage checkBooksShelfPopularBooksAreNotRepeated() {
        getHelper(PressPageHelper.class).checkBooksShelfPopularBooksAreNotRepeated();
        return this;
    }

    @Override
    public OtMagazinesPage checkBooksShelfAllBooksBlockIsPresent() {
        getHelper(PressPageHelper.class).checkBooksShelfAllBooksBlockIsPresent();
        return this;
    }

    @Override
    public OtMagazinesPage checkBooksShelfHasOnlyBooks() {
        getHelper(PressPageHelper.class).checkBooksShelfHasOnlyBooks();
        return this;
    }

    @Override
    public OtMagazinesPage clickOnBooksShelfRightArrow() {
        getHelper(PressPageHelper.class).clickOnBooksShelfRightArrow();
        return this;
    }

    @Override
    public OtMagazinesPage clickOnBooksShelfLeftArrow() {
        getHelper(PressPageHelper.class).clickOnBooksShelfLeftArrow();
        return this;
    }

    @Override
    public OtMagazinesPage checkBooksShelfNewBooksArePresentAfterClicking() {
        getHelper(PressPageHelper.class).checkBooksShelfNewBooksArePresentAfterClicking();
        return this;
    }

    @Override
    public OtMagazinesPage checkBooksShelfArrowsArePresent() {
        getHelper(PressPageHelper.class).checkBooksShelfArrowsArePresent();
        return this;
    }

    @Override
    public OtDocumentPage clickOnBooksShelfRandomBook() {
        getHelper(PressPageHelper.class).clickOnBooksShelfRandomDisplayedBook();
        return redirectTo(OtDocumentPage.class);
    }
}
