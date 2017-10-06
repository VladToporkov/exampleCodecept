package com.actionmedia.pages.klpu;

import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.elpu.ElpuBasePage;
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
public class KlpuMagazinesPage extends KlpuBasePage<KlpuMagazinesPage> implements IMagazinesPage {

    @Override
    @Step("Проверяется, что страница журналы открыта")
    public KlpuMagazinesPage checkDefaultStateMagazinesPage() {
        checkMagazineTabIsSelected();
        checkMagazinesBlockIsPresent();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Журналы и книги'")
    public KlpuMagazinesPage checkMagazineTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.MAGAZINES);
        return this;
    }

    @Step("Проверяется блок Журналы")
    public KlpuMagazinesPage checkMagazinesBlockIsPresent() {
        WebElement magazinesBlock = mainContentElement.findElement(By.xpath("//h1[text()='Журналы']"));
        assertNotNull(magazinesBlock, "Блок Журналы не найден");
        postponedAssertTrue(magazinesBlock.isEnabled() && magazinesBlock.isDisplayed(), "Блок Журналы не отображается");
        return this;
    }

    @Override
    public KlpuMagazinesPage checkNewInMagazinesShelfIsPresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfIsPresent();
        return this;
    }

    @Override
    public KlpuMagazinesPage checkNewInMagazinesShelfNewMagazinesIsPresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfNewMagazinesIsPresent();
        return this;
    }

    @Override
    public KlpuMagazinesPage checkNewInMagazinesShelfMagazinesAreNotRepeated() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfMagazinesAreNotRepeated();
        return this;
    }

    @Override
    public KlpuMagazinesPage checkNewInMagazinesShelfMagazinesAreDescending() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfMagazinesAreDescending();
        return this;
    }

    @Override
    public KlpuMagazinesPage checkNewInMagazinesShelfMagazinesHasNumberAndYearOfPublishing() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfMagazinesHasNumberAndYearOfPublishing();
        return this;
    }

    @Override
    public KlpuMagazinesPage clickOnNewInMagazinesShelfRightArrow() {
        getHelper(PressPageHelper.class).clickOnNewInMagazinesShelfRightArrow();
        return this;
    }

    @Override
    public KlpuMagazinesPage checkNewInMagazinesShelfNewMagazinesArePresentAfterClicking() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfNewMagazinesArePresentAfterClicking();
        return this;
    }

    @Override
    public KlpuMagazinesPage clickOnNewInMagazinesShelfLeftArrow() {
        getHelper(PressPageHelper.class).clickOnNewInMagazinesShelfLeftArrow();
        return this;
    }

    @Override
    public KlpuMagazinesPage checkNewInMagazinesShelfArrowsArePresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfArrowsArePresent();
        return this;
    }

    @Override
    public KlpuDocumentPage clickOnNewInMagazinesShelfRandomDisplayedMagazineOrBook() {
        getHelper(PressPageHelper.class).clickOnNewInMagazinesShelfRandomDisplayedMagazineOrBook();
        return redirectTo(KlpuDocumentPage.class);
    }

    @Override
    public KlpuMagazinesPage checkBookShelfIsPresent() {
        getHelper(PressPageHelper.class).checkBookShelfIsPresent();
        return this;
    }

    @Override
    public KlpuMagazinesPage checkBooksShelfHasPopularTitle() {
        getHelper(PressPageHelper.class).checkBooksShelfHasPopularTitle();
        return this;
    }

    @Override
    public KlpuMagazinesPage checkBooksShelfHasAllBooksTitle() {
        getHelper(PressPageHelper.class).checkBooksShelfHasAllBooksTitle();
        return this;
    }

    @Override
    public KlpuMagazinesPage checkBooksShelfPopularBlockHasThreeItems() {
        getHelper(PressPageHelper.class).checkBooksShelfPopularBlockHasThreeItems();
        return this;
    }

    @Override
    public KlpuMagazinesPage checkBooksShelfPopularBooksAreNotRepeated() {
        getHelper(PressPageHelper.class).checkBooksShelfPopularBooksAreNotRepeated();
        return this;
    }

    @Override
    public KlpuMagazinesPage checkBooksShelfAllBooksBlockIsPresent() {
        getHelper(PressPageHelper.class).checkBooksShelfAllBooksBlockIsPresent();
        return this;
    }

    @Override
    public KlpuMagazinesPage checkBooksShelfHasOnlyBooks() {
        getHelper(PressPageHelper.class).checkBooksShelfHasOnlyBooks();
        return this;
    }

    @Override
    public KlpuMagazinesPage clickOnBooksShelfRightArrow() {
        getHelper(PressPageHelper.class).clickOnBooksShelfRightArrow();
        return this;
    }

    @Override
    public KlpuMagazinesPage clickOnBooksShelfLeftArrow() {
        getHelper(PressPageHelper.class).clickOnBooksShelfLeftArrow();
        return this;
    }

    @Override
    public KlpuMagazinesPage checkBooksShelfNewBooksArePresentAfterClicking() {
        getHelper(PressPageHelper.class).checkBooksShelfNewBooksArePresentAfterClicking();
        return this;
    }

    @Override
    public KlpuMagazinesPage checkBooksShelfArrowsArePresent() {
        getHelper(PressPageHelper.class).checkBooksShelfArrowsArePresent();
        return this;
    }

    @Override
    public KlpuDocumentPage clickOnBooksShelfRandomBook() {
        getHelper(PressPageHelper.class).clickOnBooksShelfRandomDisplayedBook();
        return redirectTo(KlpuDocumentPage.class);
    }

    public KlpuMagazinesPage checkMagazinesShelvesArePresent() {
        getHelper(PressPageHelper.class).checkMagazinesShelvesArePresent();
        return this;
    }

    public KlpuMagazinesPage checkMagazineHasShelf(String shelfName) {
        getHelper(PressPageHelper.class).checkMagazineHasShelf(shelfName);
        return this;
    }

    public KlpuMagazinesPage checkMagazinesRubricatorButtonIsPresent() {
        getHelper(PressPageHelper.class).checkMagazinesRubricatorButtonIsPresent();
        return this;
    }
}
