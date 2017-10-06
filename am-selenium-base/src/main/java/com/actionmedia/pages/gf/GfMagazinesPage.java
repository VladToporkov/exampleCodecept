package com.actionmedia.pages.gf;

import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.helpers.PressPageHelper;
import com.actionmedia.pages.interfaces.IMagazinesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

/**
 * Created by Pavel on 28/03/16.
 */
@Component
public class GfMagazinesPage extends GFBasePage<GfMagazinesPage> implements IMagazinesPage {

    @Step("Проверяются элементы на странице 'Журналы'")
    public GfMagazinesPage checkDefaultStateMagazinesPage() {
        checkMagazineTabIsSelected();
        checkSearchBoxIsPresentOnMagazinePage();
        checkBooksBlockIsPresent();
        checkMagazinesBlockIsPresent();
        checkShelvesIsNotEmpty();
//        checkMobileReadButtonIsPresent();
        checkAllMagazinesButtonIsPresent();
        checkMyFavoritesRubricatorButtonIsPresent();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Журналы и книги'")
    public GfMagazinesPage checkMagazineTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.MAGAZINES);
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Журналы'")
    public GfMagazinesPage checkSearchBoxIsPresentOnMagazinePage() {
        checkSearchBoxIsPresent("Поиск по журналам и книгам");
        return this;
    }

    @Step("Проверяется блок Книги")
    public GfMagazinesPage checkBooksBlockIsPresent() {
        WebElement bookBlock = findElementByNoThrow(mainContentElement, By.xpath("//h1[text()='Книги']"));
        assertNotNull(bookBlock, "Блок Книги не найден");
        postponedAssertTrue(bookBlock.isEnabled() && bookBlock.isDisplayed(), "Блок Книги не отображается");
        return this;
    }

    @Step("Проверяется блок Журналы")
    public GfMagazinesPage checkMagazinesBlockIsPresent() {
        WebElement magazinesBlock = mainContentElement.findElement(By.xpath("//h1[text()='Журналы']"));
        assertNotNull(magazinesBlock, "Блок Журналы не найден");
        postponedAssertTrue(magazinesBlock.isEnabled() && magazinesBlock.isDisplayed(), "Блок Журналы не отображается");
        return this;
    }

    @Step("Проверяются что полки с книгами и журналами не пустые")
    public GfMagazinesPage checkShelvesIsNotEmpty() {
        List<WebElement> shelves = mainContentElement.findElements(By.cssSelector(".shelf-scroller"));
        for (int shelfCounter = 0; shelfCounter < shelves.size(); shelfCounter++) {
            List<WebElement> elementsOnShelf = shelves.get(shelfCounter).findElements(By.tagName("li"));
            postponedAssertFalse(elementsOnShelf.isEmpty(), "Не найдены книги/журналы на полке '" + (shelfCounter + 1) + "'");
            for (int magazinesCounter = 0; magazinesCounter < elementsOnShelf.size(); magazinesCounter++) {
                WebElement magazine = elementsOnShelf.get(magazinesCounter);
                if ("preloader".equals(magazine.getAttribute("class"))) {
                    continue;
                }

                if (findElementByNoThrow(magazine, By.cssSelector(".loader")) != null) {
                    continue;
                }

                assertNotNull(findElementByNoThrow(magazine, By.tagName("a")), "Отсутствует ссылка для журнала. " +
                        "Полка номер - " + (shelfCounter + 1) + ". Журнал номер - " + (magazinesCounter + 1) + ".");
                WebElement magazineImg = findElementByNoThrow(magazine, By.tagName("img"));
                postponedAssertTrue(isImageLoaded(magazineImg), "Отсутствует обложка для журнала. " +
                        "Полка номер - " + (shelfCounter + 1) + ". Журнал номер - " + (magazinesCounter + 1) + ".");
            }
        }
        return this;
    }

    @Step("Проверяется что кнопка 'Мобильное чтение' присутсвует")
    public GfMagazinesPage checkMobileReadButtonIsPresent() {
        WebElement mobileReadBlock = findElementByNoThrow(mainLeftElement, By.cssSelector(".mobile-reader"));
        assertNotNull(mobileReadBlock, "Ссылка Мобильное чтение не найдена");
        WebElement mobileReadLink = findElementByNoThrow(mobileReadBlock, By.tagName("a"));
        assertNotNull(mobileReadLink, "Ссылка Мобильное чтение не найдена");
        postponedAssertTrue(mobileReadLink.isEnabled() && mobileReadLink.isDisplayed(), "Ссылка Мобильное чтение не отображается");
        return this;
    }

    @Step("Проверяется кнопка рубрикатора журналов присутсвует")
    public GfMagazinesPage checkAllMagazinesButtonIsPresent() {
        WebElement rubricatorButton = waitForPresenceOfElementLocatedBy(By.id("rubricator-btn"), "кнопка Все журналы и книги не найдена");
        postponedAssertTrue("Все журналы и книги".equals(rubricatorButton.getText()), "кнопка Все журналы и книги Отсутствует");
        return this;
    }

    public GfMagazinesPage checkNewInMagazinesShelfIsPresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfIsPresent();
        return this;
    }

    public GfMagazinesPage checkNewInMagazinesShelfHasTitle() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfHasTitle();
        return this;
    }

    public GfMagazinesPage checkNewInMagazinesShelfNewMagazinesIsPresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfNewMagazinesIsPresent();
        return this;
    }

    public GfMagazinesPage checkNewInMagazinesShelfHasNotTitle() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfHasNotTitle();
        return this;
    }

    public GfMagazinesPage checkNewInMagazinesShelfNewBooksIsPresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfNewBooksIsPresent();
        return this;
    }

    public GfMagazinesPage checkNewInMagazinesShelfContainsMagazine(String magazineName) {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfContainsMagazine(magazineName);
        return this;
    }

    public GfMagazinesPage checkNewInMagazinesShelfMagazinesAreNotRepeated() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfMagazinesAreNotRepeated();
        return this;
    }

    public GfMagazinesPage checkNewInMagazinesShelfMagazinesAreDescending() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfMagazinesAreDescending();
        return this;
    }

    public GfMagazinesPage checkNewInMagazinesShelfMagazinesHasNumberAndYearOfPublishing() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfMagazinesHasNumberAndYearOfPublishing();
        return this;
    }

    public GfMagazinesPage checkNewInMagazinesShelfArrowsArePresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfArrowsArePresent();
        return this;
    }

    public GfMagazinesPage clickOnNewInMagazinesShelfRightArrow() {
        getHelper(PressPageHelper.class).clickOnNewInMagazinesShelfRightArrow();
        return this;
    }

    public GfMagazinesPage clickOnNewInMagazinesShelfLeftArrow() {
        getHelper(PressPageHelper.class).clickOnNewInMagazinesShelfLeftArrow();
        return this;
    }

    public GfMagazinesPage checkNewInMagazinesShelfNewMagazinesArePresentAfterClicking() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfNewMagazinesArePresentAfterClicking();
        return this;
    }

    public GfDocumentPage clickOnNewInMagazinesShelfRandomDisplayedMagazineOrBook() {
        getHelper(PressPageHelper.class).clickOnNewInMagazinesShelfRandomDisplayedMagazineOrBook();
        return redirectTo(GfDocumentPage.class);
    }

    public GfMagazinesPage checkMagazinesShelvesArePresent() {
        getHelper(PressPageHelper.class).checkMagazinesShelvesArePresent();
        return this;
    }

    public GfMagazinesPage checkMagazineShelfHasTitlePopular() {
        getHelper(PressPageHelper.class).checkMagazineShelfHasTitlePopular();
        return this;
    }

    public GfMagazinesPage checkMagazineShelfHasTitleAllMagazines() {
        getHelper(PressPageHelper.class).checkMagazineShelfHasTitleAllMagazines();
        return this;
    }

    public GfMagazinesPage checkMagazinesShelfPopularHasMaxThreeMagazines() {
        getHelper(PressPageHelper.class).checkMagazinesShelfPopularHasMaxThreeMagazines();
        return this;
    }

    public GfMagazinesPage checkMagazinesInPopularBlockAreNotRepeated() {
        getHelper(PressPageHelper.class).checkMagazinesInPopularBlockAreNotRepeated();
        return this;
    }

    public GfMagazinesPage checkMagazinesShelfAllMagazinesAreSortedDescending() {
        getHelper(PressPageHelper.class).checkMagazinesShelfAllMagazinesAreSortedDescending();
        return this;
    }

    public GfMagazinesPage checkMagazinesShelfHasOnlyMagazines() {
        getHelper(PressPageHelper.class).checkMagazinesShelfHasOnlyMagazines();
        return this;
    }

    public GfMagazinesPage checkMagazinesEachShelfHasOneMagazine() {
        getHelper(PressPageHelper.class).checkMagazinesEachShelfHasOneMagazine();
        return this;
    }

    public GfMagazinesPage checkMagazineHasNoShelf(String shelfName) {
        getHelper(PressPageHelper.class).checkMagazineHasNoShelf(shelfName);
        return this;
    }

    public GfMagazinesPage checkMagazinesShelvesHaveNumberAndYearOfPublishing() {
        getHelper(PressPageHelper.class).checkMagazinesShelvesHaveNumberAndYearOfPublishing();
        return this;
    }

    public GfMagazinesPage checkMagazinesShelvesArrowsArePresent() {
        getHelper(PressPageHelper.class).checkMagazinesShelvesArrowsArePresent();
        return this;
    }

    public GfMagazinesPage clickOnMagazinesShelfRightArrow() {
        getHelper(PressPageHelper.class).clickOnMagazinesShelfRightArrow();
        return this;
    }

    public GfMagazinesPage clickOnMagazinesShelvesLeftArrow() {
        getHelper(PressPageHelper.class).clickOnMagazinesShelvesLeftArrow();
        return this;
    }

    public GfMagazinesPage checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking() {
        getHelper(PressPageHelper.class).checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking();
        return this;
    }

    public GfDocumentPage clickOnMagazinesShelvesRandomDisplayedMagazine() {
        getHelper(PressPageHelper.class).clickOnMagazinesShelvesRandomDisplayedMagazine();
        return redirectTo(GfDocumentPage.class);
    }

    public GfMagazinesPage checkMagazineHasShelf(String shelfName) {
        getHelper(PressPageHelper.class).checkMagazineHasShelf(shelfName);
        return this;
    }

    public GfMagazinesPage checkMagazinesRubricatorButtonIsPresent() {
        getHelper(PressPageHelper.class).checkMagazinesRubricatorButtonIsPresent();
        return this;
    }

    @Override
    public GfMagazinesPage checkBookShelfIsPresent() {
        getHelper(PressPageHelper.class).checkBookShelfIsPresent();
        return this;
    }

    @Override
    public GfMagazinesPage checkBooksShelfHasPopularTitle() {
        getHelper(PressPageHelper.class).checkBooksShelfHasPopularTitle();
        return this;
    }

    @Override
    public GfMagazinesPage checkBooksShelfHasAllBooksTitle() {
        getHelper(PressPageHelper.class).checkBooksShelfHasAllBooksTitle();
        return this;
    }

    @Override
    public GfMagazinesPage checkBooksShelfPopularBlockHasThreeItems() {
        getHelper(PressPageHelper.class).checkBooksShelfPopularBlockHasThreeItems();
        return this;
    }

    @Override
    public GfMagazinesPage checkBooksShelfPopularBooksAreNotRepeated() {
        getHelper(PressPageHelper.class).checkBooksShelfPopularBooksAreNotRepeated();
        return this;
    }

    @Override
    public GfMagazinesPage checkBooksShelfAllBooksBlockIsPresent() {
        getHelper(PressPageHelper.class).checkBooksShelfAllBooksBlockIsPresent();
        return this;
    }

    @Override
    public GfMagazinesPage checkBooksShelfHasOnlyBooks() {
        getHelper(PressPageHelper.class).checkBooksShelfHasOnlyBooks();
        return this;
    }

    @Override
    public GfMagazinesPage clickOnBooksShelfRightArrow() {
        getHelper(PressPageHelper.class).clickOnBooksShelfRightArrow();
        return this;
    }

    @Override
    public GfMagazinesPage clickOnBooksShelfLeftArrow() {
        getHelper(PressPageHelper.class).clickOnBooksShelfLeftArrow();
        return this;
    }

    @Override
    public GfMagazinesPage checkBooksShelfNewBooksArePresentAfterClicking() {
        getHelper(PressPageHelper.class).checkBooksShelfNewBooksArePresentAfterClicking();
        return this;
    }

    @Override
    public GfMagazinesPage checkBooksShelfArrowsArePresent() {
        getHelper(PressPageHelper.class).checkBooksShelfArrowsArePresent();
        return this;
    }

    @Override
    public GfDocumentPage clickOnBooksShelfRandomBook() {
        getHelper(PressPageHelper.class).clickOnBooksShelfRandomDisplayedBook();
        return redirectTo(GfDocumentPage.class);
    }
}
