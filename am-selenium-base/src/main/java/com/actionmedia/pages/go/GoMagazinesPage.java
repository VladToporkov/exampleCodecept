package com.actionmedia.pages.go;

import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.helpers.PressPageHelper;
import com.actionmedia.pages.interfaces.IMagazinesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Pavel on 15/07/16.
 */
@Component
public class GoMagazinesPage extends GoBasePage<GoMagazinesPage> implements IMagazinesPage {

    @Override
    @Step("Проверяется, что страница журналы открыта")
    public GoMagazinesPage checkDefaultStateMagazinesPage() {
        checkMagazineTabIsSelected();
        checkMagazinesBlockIsPresent();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Журналы и книги'")
    public GoMagazinesPage checkMagazineTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.MAGAZINES);
        return this;
    }

    @Step("Проверяется блок Журналы")
    public GoMagazinesPage checkMagazinesBlockIsPresent() {
        WebElement magazinesBlock = mainContentElement.findElement(By.xpath("//h1[text()='Журналы']"));
        assertNotNull(magazinesBlock, "Блок Журналы не найден");
        postponedAssertTrue(magazinesBlock.isEnabled() && magazinesBlock.isDisplayed(), "Блок Журналы не отображается");
        return this;
    }

    @Override
    public GoMagazinesPage checkNewInMagazinesShelfIsPresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfIsPresent();
        return this;
    }

    @Override
    public GoMagazinesPage checkNewInMagazinesShelfNewMagazinesIsPresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfNewMagazinesIsPresent();
        return this;
    }

    @Override
    public GoMagazinesPage checkNewInMagazinesShelfMagazinesAreNotRepeated() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfMagazinesAreNotRepeated();
        return this;
    }

    @Override
    public GoMagazinesPage checkNewInMagazinesShelfMagazinesAreDescending() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfMagazinesAreDescending();
        return this;
    }

    @Override
    public GoMagazinesPage checkNewInMagazinesShelfMagazinesHasNumberAndYearOfPublishing() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfMagazinesHasNumberAndYearOfPublishing();
        return this;
    }

    @Override
    public GoMagazinesPage clickOnNewInMagazinesShelfRightArrow() {
        getHelper(PressPageHelper.class).clickOnNewInMagazinesShelfRightArrow();
        return this;
    }

    @Override
    public GoMagazinesPage checkNewInMagazinesShelfNewMagazinesArePresentAfterClicking() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfNewMagazinesArePresentAfterClicking();
        return this;
    }

    @Override
    public GoMagazinesPage clickOnNewInMagazinesShelfLeftArrow() {
        getHelper(PressPageHelper.class).clickOnNewInMagazinesShelfLeftArrow();
        return this;
    }

    @Override
    public GoMagazinesPage checkNewInMagazinesShelfArrowsArePresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfArrowsArePresent();
        return this;
    }

    @Override
    public GoDocumentPage clickOnNewInMagazinesShelfRandomDisplayedMagazineOrBook() {
        getHelper(PressPageHelper.class).clickOnNewInMagazinesShelfRandomDisplayedMagazineOrBook();
        return redirectTo(GoDocumentPage.class);
    }

    @Override
    public GoMagazinesPage checkBookShelfIsPresent() {
        getHelper(PressPageHelper.class).checkBookShelfIsPresent();
        return this;
    }

    @Override
    public GoMagazinesPage checkBooksShelfHasPopularTitle() {
        getHelper(PressPageHelper.class).checkBooksShelfHasPopularTitle();
        return this;
    }

    @Override
    public GoMagazinesPage checkBooksShelfHasAllBooksTitle() {
        getHelper(PressPageHelper.class).checkBooksShelfHasAllBooksTitle();
        return this;
    }

    @Override
    public GoMagazinesPage checkBooksShelfPopularBlockHasThreeItems() {
        getHelper(PressPageHelper.class).checkBooksShelfPopularBlockHasThreeItems();
        return this;
    }

    @Override
    public GoMagazinesPage checkBooksShelfPopularBooksAreNotRepeated() {
        getHelper(PressPageHelper.class).checkBooksShelfPopularBooksAreNotRepeated();
        return this;
    }

    @Override
    public GoMagazinesPage checkBooksShelfAllBooksBlockIsPresent() {
        getHelper(PressPageHelper.class).checkBooksShelfAllBooksBlockIsPresent();
        return this;
    }

    @Override
    public GoMagazinesPage checkBooksShelfHasOnlyBooks() {
        getHelper(PressPageHelper.class).checkBooksShelfHasOnlyBooks();
        return this;
    }

    @Override
    public GoMagazinesPage clickOnBooksShelfRightArrow() {
        getHelper(PressPageHelper.class).clickOnBooksShelfRightArrow();
        return this;
    }

    @Override
    public GoMagazinesPage clickOnBooksShelfLeftArrow() {
        getHelper(PressPageHelper.class).clickOnBooksShelfLeftArrow();
        return this;
    }

    @Override
    public GoMagazinesPage checkBooksShelfNewBooksArePresentAfterClicking() {
        getHelper(PressPageHelper.class).checkBooksShelfNewBooksArePresentAfterClicking();
        return this;
    }

    @Override
    public GoMagazinesPage checkBooksShelfArrowsArePresent() {
        getHelper(PressPageHelper.class).checkBooksShelfArrowsArePresent();
        return this;
    }

    @Override
    public GoDocumentPage clickOnBooksShelfRandomBook() {
        getHelper(PressPageHelper.class).clickOnBooksShelfRandomDisplayedBook();
        return redirectTo(GoDocumentPage.class);
    }

    public GoMagazinesPage checkMagazinesShelvesArePresent() {
        getHelper(PressPageHelper.class).checkMagazinesShelvesArePresent();
        return this;
    }

    public GoMagazinesPage checkMagazineHasShelf(String shelfName) {
        getHelper(PressPageHelper.class).checkMagazineHasShelf(shelfName);
        return this;
    }

    public GoMagazinesPage checkMagazinesRubricatorButtonIsPresent() {
        getHelper(PressPageHelper.class).checkMagazinesRubricatorButtonIsPresent();
        return this;
    }
}
