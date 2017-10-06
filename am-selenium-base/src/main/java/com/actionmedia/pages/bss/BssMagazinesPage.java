package com.actionmedia.pages.bss;

import com.actionmedia.components.Link;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.helpers.PressPageHelper;
import com.actionmedia.pages.interfaces.IDocumentPage;
import com.actionmedia.pages.interfaces.IMagazinesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 11.10.13
 * Time: 9:37
 */
@Component
public class BssMagazinesPage extends BssBasePage<BssMagazinesPage> implements IMagazinesPage {

    public static final String DOCUMENT_URL = "document.url";

    @Step("Проверяются элементы на странице 'Журналы'")
    public BssMagazinesPage checkDefaultStateMagazinesPage() {
        checkMagazineTabIsSelected();
        checkSearchBoxIsPresentOnMagazinePage();
        checkBooksBlockIsPresent();
        checkMagazinesBlockIsPresent();
        checkShelvesIsNotEmpty();
        checkMobileReadButtonIsPresent();
        checkAllMagazinesButtonIsPresent();
        checkMyFavoritesRubricatorButtonIsPresent();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Журналы и книги'")
    public BssMagazinesPage checkMagazineTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.MAGAZINES);
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Журналы'")
    public BssMagazinesPage checkSearchBoxIsPresentOnMagazinePage() {
        checkSearchBoxIsPresent("Поиск по журналам и книгам");
        return this;
    }

    @Step("Проверяется блок Книги")
    public BssMagazinesPage checkBooksBlockIsPresent() {
        WebElement bookBlock = findElementByNoThrow(mainContentElement, By.xpath("//h1[text()='Книги']"));
        assertNotNull(bookBlock, "Блок Книги не найден");
        postponedAssertTrue(bookBlock.isEnabled() && bookBlock.isDisplayed(), "Блок Книги не отображается");
        return this;
    }

    @Step("Проверяется блок Журналы")
    public BssMagazinesPage checkMagazinesBlockIsPresent() {
        WebElement magazinesBlock = mainContentElement.findElement(By.xpath("//h1[text()='Журналы']"));
        assertNotNull(magazinesBlock, "Блок Журналы не найден");
        postponedAssertTrue(magazinesBlock.isEnabled() && magazinesBlock.isDisplayed(), "Блок Журналы не отображается");
        return this;
    }

    @Step("Проверяются что полки с книгами и журналами не пустые")
    public BssMagazinesPage checkShelvesIsNotEmpty() {
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

    @Step("Проверяется правильный порядок журналов на полках")
    public BssMagazinesPage checkMagazinesArePresentInDescendingOrder() {
        List<WebElement> magazineShelves = waitForPresenceOfAllElementsLocatedBy(By.cssSelector("[data-type='magazine']"));
        for (int shelfCounter = 0; shelfCounter < magazineShelves.size(); shelfCounter++) {
            List<WebElement> magazines = magazineShelves.get(shelfCounter).findElements(By.cssSelector(".magazine"));
            for (int magazineCounter = 3; magazineCounter < magazines.size() - 1; magazineCounter++) {
                int firstMagazineId = Integer.parseInt(magazines.get(magazineCounter).getAttribute("href").split("/document/")[1].replaceAll("/", ""));
                int nextMagazineId = Integer.parseInt(magazines.get(magazineCounter + 1).getAttribute("href").split("/document/")[1].replaceAll("/", ""));
                postponedAssertTrue(firstMagazineId - nextMagazineId > 0, "Неправильный порядок журналов. Полка номер - " + (shelfCounter + 1) + ". Журнал номер - " + (magazineCounter + 1));
            }
        }
        return this;
    }

    @Step("Нажать кнопку 'Мобильное чтение'")
    public BssDocumentPage clickMobileReadButton() {
        WebElement mobileReadBlock = findElementByNoThrow(mainLeftElement, By.cssSelector(".mobile-reader"));
        assertNotNull(mobileReadBlock, "Ссылка Мобильное чтение не найдена");
        WebElement mobileReadLink = findElementByNoThrow(mobileReadBlock, By.tagName("a"));
        assertNotNull(mobileReadLink, "Ссылка Мобильное чтение не найдена");
        mobileReadLink.click();
        return redirectTo(BssDocumentPage.class);
    }

    @Step("Проверяется что кнопка 'Мобильное чтение' присутсвует")
    public BssMagazinesPage checkMobileReadButtonIsPresent() {
        WebElement mobileReadBlock = findElementByNoThrow(mainLeftElement, By.cssSelector(".mobile-reader"));
        assertNotNull(mobileReadBlock, "Ссылка Мобильное чтение не найдена");
        WebElement mobileReadLink = findElementByNoThrow(mobileReadBlock, By.tagName("a"));
        assertNotNull(mobileReadLink, "Ссылка Мобильное чтение не найдена");
        postponedAssertTrue(mobileReadLink.isEnabled() && mobileReadLink.isDisplayed(), "Ссылка Мобильное чтение не отображается");
        return this;
    }

    @Step("Проверяется что рядом с кнопкой 'Мобильное чтение' присутсвует иконка телефона")
    public BssMagazinesPage checkMobileReadIconIsPresent() {
        WebElement mobileReadBlock = findElementByNoThrow(mainLeftElement, By.cssSelector(".mobile-reader"));
        assertNotNull(mobileReadBlock, "Ссылка Мобильное чтение не найдена");
        WebElement mobileReadIcon = findElementByNoThrow(mobileReadBlock, By.cssSelector(".ico_content_iphone"));
        assertNotNull(mobileReadIcon, "Иконка телефона рядом с кнопкой 'Мобильное чтение' не найдена");
        postponedAssertTrue(mobileReadIcon.isEnabled() && mobileReadIcon.isDisplayed(), "Иконка телефона рядом с кнопкой 'Мобильное чтение' не отображается");
        return this;
    }

    @Step("Проверяется тултип для кнопки 'Мобильное чтение'")
    public BssMagazinesPage checkMobileReadButtonTooltip() {
        WebElement mobileReadBlock = findElementByNoThrow(mainLeftElement, By.cssSelector(".mobile-reader"));
        postponedAssertNotNull(mobileReadBlock, "Ссылка Мобильное чтение не найдена");
        if (mobileReadBlock != null) {
            WebElement mobileReadLink = findElementByNoThrow(mobileReadBlock, By.tagName("a"));
            assertNotNull(mobileReadLink, "Ссылка Мобильное чтение не найдена");
            postponedAssertEquals(mobileReadLink.getAttribute("title"), "Установите бесплатное мобильное приложение «Бухгалтерская справочная система: профиздания»", "Неправильный тултип для кнопки 'Мобильное чтение'");
        }
        return this;
    }

    @Step("Проверяется кнопка рубрикатора журналов присутсвует")
    public BssMagazinesPage checkAllMagazinesButtonIsPresent() {
        WebElement rubricatorButton = waitForPresenceOfElementLocatedBy(By.id("rubricator-btn"), "кнопка Все журналы и книги не найдена");
        postponedAssertTrue("Все журналы и книги".equals(rubricatorButton.getText()), "кнопка Все журналы и книги Отсутствует");
        return this;
    }

    @Step("Проверяются работа ссылок из блока Новые")
    public BssMagazinesPage checkLinksFromNewsBlock() {
        WebElement newShelf = waitForVisibilityOfElementLocatedBy(By.cssSelector("[data-type='news']"), "Полка 'Новое' не найдена");
        checkLinksFromShelf(newShelf);
        return this;
    }

    @Step("Проверяется работа слайдеров на журнальных полках")
    public BssMagazinesPage checkScrollOnShelves() {
        List<WebElement> magazineShelves = waitForPresenceOfAllElementsLocatedBy(By.cssSelector("[data-type='magazine']"));
        for (WebElement magazineShelf : magazineShelves) {
            if (magazineShelf.findElements(By.tagName("li")).size() < 10) {
                continue;
            }
            checkRightSlide(magazineShelf);
            checkLeftSlide(magazineShelf);
        }
        return this;
    }

    @Step("Проверяются работа ссылок из блока Книги")
    public BssMagazinesPage checkLinksFromBooksBlock() {
        WebElement booksShelves = waitForPresenceOfElementLocatedBy(By.cssSelector("[data-type='book']"));
        checkLinksFromShelf(booksShelves);
        return this;
    }

    @Step("Проверяются работа ссылок из блока Книги")
    public BssMagazinesPage checkLinksFromMagazinesBlock() {
        List<WebElement> shelves = waitForPresenceOfAllElementsLocatedBy(By.cssSelector("[data-type='magazine']"));
        WebElement magazineShelf = getRandomElementInList(shelves);
        checkLinksFromShelf(magazineShelf);
        return this;
    }

    @Step("Проверяется работа ссылки Мобильное чтение")
    public BssMagazinesPage checkLinksFromMobileReadBlock() {
        WebElement mobileReadLink = waitForVisibilityOfElementLocatedBy(By.cssSelector(".mobile-reader"), "Ссылка 'Мобильное чтение' не найдена").findElement(By.tagName("a"));
        String url = mobileReadLink.getAttribute("href");
        checkLink(new Link(url));
        return this;
    }

    @Step("Открыть случайную книгу")
    public BssDocumentPage clickRandomBook() {
        List<WebElement> bookList = mainContentElement.findElements(By.cssSelector(".book"));
        WebElement randomBook = getRandomElementInList(bookList);
        String url = randomBook.getAttribute("href");
        setParameter(DOCUMENT_URL, url);
        report("Открывается " + url);
        randomBook.click();
        return redirectTo(BssDocumentPage.class);
    }

    @Step("Открыть случайный журнал")
    public BssDocumentPage clickRandomMagazine() {
        List<WebElement> magazinesList = mainContentElement.findElements(By.cssSelector(".magazine"));
        WebElement randomMagazine = getRandomElementInList(magazinesList);
        String url = randomMagazine.getAttribute("href");
        setParameter(DOCUMENT_URL, url);
        report("Открывается " + url);
        randomMagazine.click();
        return redirectTo(BssDocumentPage.class);
    }

    private void checkRightSlide(WebElement magazineShelf) {
        report("Проверяется правый слайдер");
        WebElement pressList = magazineShelf.findElement(By.cssSelector(".magazine-list"));
        WebElement rightSlider = magazineShelf.findElement(By.cssSelector(".shelf-scroller__control_type_forward"));
        int startPosition = 0;
        boolean isRightSliderDisabled = false;

        long currentTime = new Date().getTime();
        while (!rightSlider.getAttribute("class").contains("disabled")) {
            moveMouseToElement(magazineShelf);
            postponedAssertTrue(rightSlider.isEnabled() && rightSlider.isDisplayed(), "Правый слайдер не найден");
            scrollIntoView(rightSlider);
            mouseClick(rightSlider);
            isRightSliderDisabled = true;
            if (currentTime - new Date().getTime() > 20000) {
                break;
            }
        }

        if (isRightSliderDisabled) {
            int endPosition = getOffsetAfterClick(pressList);
            postponedAssertTrue(startPosition > endPosition, "Скролл вправо не работает");
            postponedAssertFalse(rightSlider.isDisplayed(), "Показан правый слайдер после скролла до конца полки");
        }
    }

    private void checkLeftSlide(WebElement magazineShelf) {
        report("Проверяется левый слайдер");

        WebElement pressList = magazineShelf.findElement(By.cssSelector(".magazine-list"));
        int startPosition = getOffsetAfterClick(pressList);
        WebElement leftSlider = magazineShelf.findElement(By.cssSelector(".shelf-scroller__control_type_backward"));
        boolean isLeftSliderDisabled = false;

        long currentTime = new Date().getTime();
        while (!leftSlider.getAttribute("class").contains("disabled")) {
            moveMouseToElement(magazineShelf);
            postponedAssertTrue(leftSlider.isEnabled() && leftSlider.isDisplayed(), "Левый слайдер не найден");
            scrollIntoView(leftSlider);
            mouseClick(leftSlider);
            isLeftSliderDisabled = true;
            if (currentTime - new Date().getTime() > 20000) {
                break;
            }
        }

        if (isLeftSliderDisabled) {
            int endPosition = getOffsetAfterClick(pressList);
            postponedAssertTrue(startPosition < endPosition, "Скролл влево не работает");
            postponedAssertTrue(endPosition == 0, "Неправильное положение левого слайдера после скролла");
            postponedAssertFalse(leftSlider.isDisplayed(), "Показан левый слайдер после скролла до конца полки");
        }
    }

    private int getOffsetAfterClick(WebElement element) {
        return Integer.parseInt(element.getAttribute("style").split("margin-left:")[1].split("px;")[0].trim());
    }

    private void checkLinksFromShelf(WebElement magazineShelves) {
        List<WebElement> itemList = magazineShelves.findElements(By.tagName("li"));
        itemList = itemList.subList(0, itemList.size() - 1);
        itemList = getRandomElementsInList(itemList, 3);
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement item : itemList) {
            if (findElementByNoThrow(item, By.cssSelector(".loader")) != null) {
                continue;
            }
            String url = item.findElement(By.tagName("a")).getAttribute("href");
            Link link = new Link(url);
            linkList.add(link);
        }
        checkLinks(linkList);
    }

    public BssMagazinesPage checkNewInMagazinesShelfIsPresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfIsPresent();
        return this;
    }

    public BssMagazinesPage checkNewInMagazinesShelfNewMagazinesIsPresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfNewMagazinesIsPresent();
        return this;
    }

    public BssMagazinesPage checkNewInMagazinesShelfHasNotTitle() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfHasNotTitle();
        return this;
    }

    public BssMagazinesPage checkNewInMagazinesShelfNewBooksIsPresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfNewBooksIsPresent();
        return this;
    }

    public BssMagazinesPage checkNewInMagazinesShelfContainsMagazine(String magazineName) {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfContainsMagazine(magazineName);
        return this;
    }

    public BssMagazinesPage checkNewInMagazinesShelfMagazinesAreNotRepeated() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfMagazinesAreNotRepeated();
        return this;
    }

    public BssMagazinesPage checkNewInMagazinesShelfMagazinesAreDescending() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfMagazinesAreDescending();
        return this;
    }

    public BssMagazinesPage checkNewInMagazinesShelfMagazinesHasNumberAndYearOfPublishing() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfMagazinesHasNumberAndYearOfPublishing();
        return this;
    }

    public BssMagazinesPage checkNewInMagazinesShelfArrowsArePresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfArrowsArePresent();
        return this;
    }

    public BssMagazinesPage clickOnNewInMagazinesShelfRightArrow() {
        getHelper(PressPageHelper.class).clickOnNewInMagazinesShelfRightArrow();
        return this;
    }

    public BssMagazinesPage clickOnNewInMagazinesShelfLeftArrow() {
        getHelper(PressPageHelper.class).clickOnNewInMagazinesShelfLeftArrow();
        return this;
    }

    public BssMagazinesPage checkNewInMagazinesShelfNewMagazinesArePresentAfterClicking() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfNewMagazinesArePresentAfterClicking();
        return this;
    }

    public BssDocumentPage clickOnNewInMagazinesShelfRandomDisplayedMagazineOrBook() {
        getHelper(PressPageHelper.class).clickOnNewInMagazinesShelfRandomDisplayedMagazineOrBook();
        return redirectTo(BssDocumentPage.class);
    }

    public BssMagazinesPage checkMagazinesShelvesArePresent() {
        getHelper(PressPageHelper.class).checkMagazinesShelvesArePresent();
        return this;
    }

    public BssMagazinesPage checkMagazineShelfHasTitlePopular() {
        getHelper(PressPageHelper.class).checkMagazineShelfHasTitlePopular();
        return this;
    }

    public BssMagazinesPage checkMagazineShelfHasTitleAllMagazines() {
        getHelper(PressPageHelper.class).checkMagazineShelfHasTitleAllMagazines();
        return this;
    }

    public BssMagazinesPage checkMagazinesShelfPopularHasMaxThreeMagazines() {
        getHelper(PressPageHelper.class).checkMagazinesShelfPopularHasMaxThreeMagazines();
        return this;
    }

    public BssMagazinesPage checkMagazinesInPopularBlockAreNotRepeated() {
        getHelper(PressPageHelper.class).checkMagazinesInPopularBlockAreNotRepeated();
        return this;
    }

    public BssMagazinesPage checkMagazinesShelfAllMagazinesAreSortedDescending() {
        getHelper(PressPageHelper.class).checkMagazinesShelfAllMagazinesAreSortedDescending();
        return this;
    }

    public BssMagazinesPage checkMagazinesShelfHasOnlyMagazines() {
        getHelper(PressPageHelper.class).checkMagazinesShelfHasOnlyMagazines();
        return this;
    }

    public BssMagazinesPage checkMagazinesEachShelfHasOneMagazine() {
        getHelper(PressPageHelper.class).checkMagazinesEachShelfHasOneMagazine();
        return this;
    }

    public BssMagazinesPage checkMagazineHasNoShelf(String shelfName) {
        getHelper(PressPageHelper.class).checkMagazineHasNoShelf(shelfName);
        return this;
    }

    public BssMagazinesPage checkMagazinesShelvesHaveNumberAndYearOfPublishing() {
        getHelper(PressPageHelper.class).checkMagazinesShelvesHaveNumberAndYearOfPublishing();
        return this;
    }

    public BssMagazinesPage checkMagazinesShelvesArrowsArePresent() {
        getHelper(PressPageHelper.class).checkMagazinesShelvesArrowsArePresent();
        return this;
    }

    public BssMagazinesPage clickOnMagazinesShelfRightArrow() {
        getHelper(PressPageHelper.class).clickOnMagazinesShelfRightArrow();
        return this;
    }

    public BssMagazinesPage clickOnMagazinesShelvesLeftArrow() {
        getHelper(PressPageHelper.class).clickOnMagazinesShelvesLeftArrow();
        return this;
    }

    public BssMagazinesPage checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking() {
        getHelper(PressPageHelper.class).checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking();
        return this;
    }

    public BssDocumentPage clickOnMagazinesShelvesRandomDisplayedMagazine() {
        getHelper(PressPageHelper.class).clickOnMagazinesShelvesRandomDisplayedMagazine();
        return redirectTo(BssDocumentPage.class);
    }

    public BssMagazinesPage checkMagazineHasShelf(String shelfName) {
        getHelper(PressPageHelper.class).checkMagazineHasShelf(shelfName);
        return this;
    }

    public BssMagazinesPage checkMagazinesRubricatorButtonIsPresent() {
        getHelper(PressPageHelper.class).checkMagazinesRubricatorButtonIsPresent();
        return this;
    }

    public BssMagazinesPage sendGetRequestAndCheckThatNewShelfHasOneBookAtLeast() {
        getHelper(PressPageHelper.class).sendGetRequestAndCheckThatNewShelfHasOneBookAtLeast();
        return this;
    }

    @Override
    public BssMagazinesPage checkBookShelfIsPresent() {
        getHelper(PressPageHelper.class).checkBookShelfIsPresent();
        return this;
    }

    @Override
    public BssMagazinesPage checkBooksShelfHasPopularTitle() {
        getHelper(PressPageHelper.class).checkBooksShelfHasPopularTitle();
        return this;
    }

    @Override
    public BssMagazinesPage checkBooksShelfHasAllBooksTitle() {
        getHelper(PressPageHelper.class).checkBooksShelfHasAllBooksTitle();
        return this;
    }

    @Override
    public BssMagazinesPage checkBooksShelfPopularBlockHasThreeItems() {
        getHelper(PressPageHelper.class).checkBooksShelfPopularBlockHasThreeItems();
        return this;
    }

    @Override
    public BssMagazinesPage checkBooksShelfPopularBooksAreNotRepeated() {
        getHelper(PressPageHelper.class).checkBooksShelfPopularBooksAreNotRepeated();
        return this;
    }

    @Override
    public BssMagazinesPage checkBooksShelfAllBooksBlockIsPresent() {
        getHelper(PressPageHelper.class).checkBooksShelfAllBooksBlockIsPresent();
        return this;
    }

    @Override
    public BssMagazinesPage checkBooksShelfHasOnlyBooks() {
        getHelper(PressPageHelper.class).checkBooksShelfHasOnlyBooks();
        return this;
    }

    @Override
    public BssMagazinesPage clickOnBooksShelfRightArrow() {
        getHelper(PressPageHelper.class).clickOnBooksShelfRightArrow();
        return this;
    }

    @Override
    public BssMagazinesPage clickOnBooksShelfLeftArrow() {
        getHelper(PressPageHelper.class).clickOnBooksShelfLeftArrow();
        return this;
    }

    @Override
    public BssMagazinesPage checkBooksShelfNewBooksArePresentAfterClicking() {
        getHelper(PressPageHelper.class).checkBooksShelfNewBooksArePresentAfterClicking();
        return this;
    }

    @Override
    public BssMagazinesPage checkBooksShelfArrowsArePresent() {
        getHelper(PressPageHelper.class).checkBooksShelfArrowsArePresent();
        return this;
    }

    @Override
    public BssDocumentPage clickOnBooksShelfRandomBook() {
        getHelper(PressPageHelper.class).clickOnBooksShelfRandomDisplayedBook();
        return redirectTo(BssDocumentPage.class);
    }
}
