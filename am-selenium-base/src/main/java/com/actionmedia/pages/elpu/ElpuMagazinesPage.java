package com.actionmedia.pages.elpu;

import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.cult.CultBasePage;
import com.actionmedia.pages.helpers.PressPageHelper;
import com.actionmedia.pages.interfaces.IDocumentPage;
import com.actionmedia.pages.interfaces.IMagazinesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Pavel on 15/07/16.
 */
@Component
public class ElpuMagazinesPage extends ElpuBasePage<ElpuMagazinesPage> implements IMagazinesPage {

    @Override
    @Step("Проверяется, что страница журналы открыта")
    public ElpuMagazinesPage checkDefaultStateMagazinesPage() {
        checkMagazineTabIsSelected();
        checkMagazinesBlockIsPresent();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Журналы и книги'")
    public ElpuMagazinesPage checkMagazineTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.MAGAZINES);
        return this;
    }

    @Step("Проверяется блок Журналы")
    public ElpuMagazinesPage checkMagazinesBlockIsPresent() {
        WebElement magazinesBlock = mainContentElement.findElement(By.xpath("//h1[text()='Журналы']"));
        assertNotNull(magazinesBlock, "Блок Журналы не найден");
        postponedAssertTrue(magazinesBlock.isEnabled() && magazinesBlock.isDisplayed(), "Блок Журналы не отображается");
        return this;
    }

    @Override
    public ElpuMagazinesPage checkNewInMagazinesShelfIsPresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfIsPresent();
        return this;
    }

    @Override
    public ElpuMagazinesPage checkNewInMagazinesShelfNewMagazinesIsPresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfNewMagazinesIsPresent();
        return this;
    }

    @Override
    public ElpuMagazinesPage checkNewInMagazinesShelfMagazinesAreNotRepeated() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfMagazinesAreNotRepeated();
        return this;
    }

    @Override
    public ElpuMagazinesPage checkNewInMagazinesShelfMagazinesAreDescending() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfMagazinesAreDescending();
        return this;
    }

    @Override
    public ElpuMagazinesPage checkNewInMagazinesShelfMagazinesHasNumberAndYearOfPublishing() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfMagazinesHasNumberAndYearOfPublishing();
        return this;
    }

    @Override
    public ElpuMagazinesPage clickOnNewInMagazinesShelfRightArrow() {
        getHelper(PressPageHelper.class).clickOnNewInMagazinesShelfRightArrow();
        return this;
    }

    @Override
    public ElpuMagazinesPage checkNewInMagazinesShelfNewMagazinesArePresentAfterClicking() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfNewMagazinesArePresentAfterClicking();
        return this;
    }

    @Override
    public ElpuMagazinesPage clickOnNewInMagazinesShelfLeftArrow() {
        getHelper(PressPageHelper.class).clickOnNewInMagazinesShelfLeftArrow();
        return this;
    }

    @Override
    public ElpuMagazinesPage checkNewInMagazinesShelfArrowsArePresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfArrowsArePresent();
        return this;
    }

    @Override
    public ElpuDocumentPage clickOnNewInMagazinesShelfRandomDisplayedMagazineOrBook() {
        getHelper(PressPageHelper.class).clickOnNewInMagazinesShelfRandomDisplayedMagazineOrBook();
        return redirectTo(ElpuDocumentPage.class);
    }

    @Override
    public ElpuMagazinesPage checkBookShelfIsPresent() {
        getHelper(PressPageHelper.class).checkBookShelfIsPresent();
        return this;
    }

    @Override
    public ElpuMagazinesPage checkBooksShelfHasPopularTitle() {
        getHelper(PressPageHelper.class).checkBooksShelfHasPopularTitle();
        return this;
    }

    @Override
    public ElpuMagazinesPage checkBooksShelfHasAllBooksTitle() {
        getHelper(PressPageHelper.class).checkBooksShelfHasAllBooksTitle();
        return this;
    }

    @Override
    public ElpuMagazinesPage checkBooksShelfPopularBlockHasThreeItems() {
        getHelper(PressPageHelper.class).checkBooksShelfPopularBlockHasThreeItems();
        return this;
    }

    @Override
    public ElpuMagazinesPage checkBooksShelfPopularBooksAreNotRepeated() {
        getHelper(PressPageHelper.class).checkBooksShelfPopularBooksAreNotRepeated();
        return this;
    }

    @Override
    public ElpuMagazinesPage checkBooksShelfAllBooksBlockIsPresent() {
        getHelper(PressPageHelper.class).checkBooksShelfAllBooksBlockIsPresent();
        return this;
    }

    @Override
    public ElpuMagazinesPage checkBooksShelfHasOnlyBooks() {
        getHelper(PressPageHelper.class).checkBooksShelfHasOnlyBooks();
        return this;
    }

    @Override
    public ElpuMagazinesPage clickOnBooksShelfRightArrow() {
        getHelper(PressPageHelper.class).clickOnBooksShelfRightArrow();
        return this;
    }

    @Override
    public ElpuMagazinesPage clickOnBooksShelfLeftArrow() {
        getHelper(PressPageHelper.class).clickOnBooksShelfLeftArrow();
        return this;
    }

    @Override
    public ElpuMagazinesPage checkBooksShelfNewBooksArePresentAfterClicking() {
        getHelper(PressPageHelper.class).checkBooksShelfNewBooksArePresentAfterClicking();
        return this;
    }

    @Override
    public ElpuMagazinesPage checkBooksShelfArrowsArePresent() {
        getHelper(PressPageHelper.class).checkBooksShelfArrowsArePresent();
        return this;
    }

    @Override
    public ElpuDocumentPage clickOnBooksShelfRandomBook() {
        getHelper(PressPageHelper.class).clickOnBooksShelfRandomDisplayedBook();
        return redirectTo(ElpuDocumentPage.class);
    }

    public ElpuMagazinesPage checkMagazinesShelvesArePresent() {
        getHelper(PressPageHelper.class).checkMagazinesShelvesArePresent();
        return this;
    }

    public ElpuMagazinesPage checkMagazineHasShelf(String shelfName) {
        getHelper(PressPageHelper.class).checkMagazineHasShelf(shelfName);
        return this;
    }

    public ElpuMagazinesPage checkMagazinesRubricatorButtonIsPresent() {
        getHelper(PressPageHelper.class).checkMagazinesRubricatorButtonIsPresent();
        return this;
    }
}
