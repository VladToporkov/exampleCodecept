package com.actionmedia.pages.uss;

import com.actionmedia.components.Link;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.helpers.PressPageHelper;
import com.actionmedia.pages.helpers.SearchResultHelper;
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
 * Date: 28.10.13
 * Time: 12:14
 */
@Component
public class UssMagazinesPage extends UssBasePage<UssMagazinesPage> implements IMagazinesPage {

    public static final String BOOK_URL = "book.url";

    @Step("Проверяются элементы на странице 'Журналы'")
    public UssMagazinesPage checkDefaultStateMagazinesPage() {
        checkMagazineTabIsSelected();
        checkSearchBoxIsPresentOnMagazinePage();
        checkNewBookAndMagazinesBlockIsPresent();
        checkCommentariesBlockIsPresent();
        checkBooksBlockIsPresent();
        checkMagazinesBlockIsPresent();
        checkShelvesIsNotEmpty();
//        checkMagazinesArePresentInDescendingOrder();
        checkMagazinesRubricatorButtonIsPresent();
        checkMyFavoritesRubricatorButtonIsPresent();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Журналы и книги'")
    public UssMagazinesPage checkMagazineTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.MAGAZINES_AND_BOOKS);
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Журналы'")
    public UssMagazinesPage checkSearchBoxIsPresentOnMagazinePage() {
        checkSearchBoxIsPresent("Поиск по журналам и книгам");
        return this;
    }

    @Step("Проверяются блок новые книги и журналы")
    public UssMagazinesPage checkNewBookAndMagazinesBlockIsPresent() {
        WebElement newBookAndMagazinesBlock = mainContentElement.findElement(By.cssSelector("[data-type='news']"));
        postponedAssertTrue(newBookAndMagazinesBlock.isDisplayed(), "Блок Новые книги и журналы не отображается");
        List<WebElement> newBooksAndMagazines = mainContentElement.findElement(By.cssSelector("[data-type='news']")).findElements(By.tagName("li"));
        postponedAssertFalse(newBooksAndMagazines.isEmpty(), "Блок Новые книги и журналы пустой");
        return this;
    }

    @Step("Проверяется блок Постатейные комментарии")
    public UssMagazinesPage checkCommentariesBlockIsPresent() {
        WebElement commentariesBlock = findElementByNoThrow(mainContentElement, By.xpath("//h1[text()='Постатейные комментарии']"));
        assertNotNull(commentariesBlock, "Блок Постатейные комментарии не найден");
        postponedAssertTrue(commentariesBlock.isDisplayed(), "Блок Постатейные комментарии не отображается");
        List<WebElement> commentariesList = mainContentElement.findElement(By.cssSelector(".shelf-scroller_content_comments")).findElements(By.tagName("li"));
        postponedAssertFalse(commentariesList.isEmpty(), "Блок Постатейные комментарии пустой");
        return this;
    }

    @Step("Проверяется блок Книги")
    public UssMagazinesPage checkBooksBlockIsPresent() {
        getHelper(PressPageHelper.class).checkBooksBlockIsPresent();
        return this;
    }

    @Step("Проверяется блок Журналы")
    public UssMagazinesPage checkMagazinesBlockIsPresent() {
        WebElement magazinesBlock = mainContentElement.findElement(By.xpath("//h1[text()='Журналы']"));
        assertNotNull(magazinesBlock, "Блок Журналы не найден");
        postponedAssertTrue(magazinesBlock.isDisplayed(), "Блок Журналы не отображается");
        List<WebElement> magazinesList = mainContentElement.findElement(By.cssSelector("[data-type='magazine']")).findElements(By.tagName("li"));
        postponedAssertFalse(magazinesList.isEmpty(), "Блок Журналы пустой");
        return this;
    }

    @Step("Проверяются что полки с книгами и журналами не пустые")
    public UssMagazinesPage checkShelvesIsNotEmpty() {
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
    public UssMagazinesPage checkMagazinesArePresentInDescendingOrder() {
        List<WebElement> magazineShelves = waitForPresenceOfAllElementsLocatedBy(By.cssSelector("[data-type='magazine']"));
        for (int shelfCounter = 2; shelfCounter < magazineShelves.size(); shelfCounter++) {
            List<WebElement> magazines = magazineShelves.get(shelfCounter).findElements(By.cssSelector(".magazine"));
            for (int magazineCounter = 3; magazineCounter < magazines.size() - 1; magazineCounter++) {
                int firstMagazineId = Integer.parseInt(magazines.get(magazineCounter).getAttribute("href").split("/document/")[1].replaceAll("/", ""));
                int nextMagazineId = Integer.parseInt(magazines.get(magazineCounter + 1).getAttribute("href").split("/document/")[1].replaceAll("/", ""));
                postponedAssertTrue(firstMagazineId - nextMagazineId > 0, "Неправильный порядок журналов. Полка номер - " + (shelfCounter + 1) + ". Журнал номер - " + (magazineCounter + 1));
            }
        }
        return this;
    }

    @Step("Проверяется работа ссылок журналов")
    public UssMagazinesPage checkMagazinesLink() {
        List<WebElement> shelves = waitForPresenceOfAllElementsLocatedBy(By.cssSelector("[data-type='magazine']"));
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement shelf : shelves) {
            List<WebElement> magazinesAndBooksOnShelf = shelf.findElements(By.tagName("li"));
            WebElement magazine = getRandomElementInList(magazinesAndBooksOnShelf);
            if (magazine.getAttribute("class").contains("preloader")) {
                continue;
            }
            if (findElementByNoThrow(magazine, By.cssSelector(".loader")) != null) {
                continue;
            }
            scrollIntoView(magazine);
            String url = magazine.findElement(By.tagName("a")).getAttribute("href");
            Link link = new Link(url, "");
            linkList.add(link);
        }
        checkLinks(linkList, 5);
        return this;
    }

    @Step("Проверяется работа слайдеров на журнальных полках")
    public UssMagazinesPage checkScrollOnShelves() {
        List<WebElement> magazineShelves = waitForPresenceOfAllElementsLocatedBy(By.cssSelector("[data-type='magazine']"));
        for (WebElement magazineShelf : magazineShelves) {
            if (magazineShelf.findElements(By.tagName("li")).size() < 15) {
                continue;
            }
            checkRightSlide(magazineShelf);
            checkLeftSlide(magazineShelf);
        }
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются")
    public UssMagazinesPage checkHintsIsPresent() {
        checkHintListIsPresent();
        return this;
    }

    @Step("Нажать подсказку с прямым переходом")
    public UssSearchResultPage clickHintWithJumpOnMagazinesPage() {
        clickHintWithJump();
        return redirectTo(UssSearchResultPage.class);
    }

    @Step("Нажать любую подсказку с переходом")
    public UssSearchResultPage clickRandomHintOnMagazinesPage() {
        clickRandomHint();
        return redirectTo(UssSearchResultPage.class);
    }

    @Step("Открыть случайный документ из блока популярное")
    public UssMagazinesPage clickRandomMagazineLink() {
        List<WebElement> magazines = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".magazine"));
        WebElement randomMagazine = getRandomElementInList(magazines);
        randomMagazine.click();
        waitForReloadingPage();
        return this;
    }

    @Step("Открыть случайную книгу")
    public UssDocumentPage clickRandomBook() {
        List<WebElement> bookList = mainContentElement.findElements(By.cssSelector(".book"));
        WebElement randomBook = getRandomElementInList(bookList);
        String url = randomBook.getAttribute("href");
        setParameter(BOOK_URL, url);
        report("Открывается " + url);
        randomBook.click();
        return redirectTo(UssDocumentPage.class);
    }

    public UssDocumentPage clickRandomMagazine() {
        List<WebElement> magazineList = mainContentElement.findElements(By.cssSelector(".magazine"));
        WebElement randomMagazine = getRandomElementInList(magazineList);
        String url = randomMagazine.getAttribute("href");
        setParameter(BOOK_URL, url);
        report("Открывается " + url);
        randomMagazine.click();
        return redirectTo(UssDocumentPage.class);
    }

    @Step("Проверяется что результаты поиска отсутсвуют")
    public UssMagazinesPage checkSearchResultIsNotPresentOnMagazinesPage() {
        checkSearchResultIsNotPresentOnPage();
        return this;
    }

    @Step("Проверяется работа кнопки Найти на странице Правовая база")
    public UssMagazinesPage checkSearchButtonFunctionalityOnSearchBox(String query) {
        setParameter(SearchResultHelper.HINT_TEXT, query);
        return clearSearchBox()
                .clickSearchButton()
                .checkMagazineTabIsSelected()
                .checkSearchResultIsNotPresentOnMagazinesPage()

                .clearSearchBox()
                .inputTextInSearchBox(query)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnMagazinesPageIsOpened()
                .navigateToMagazinesPage();
    }

    @Step("Нажать кнопку 'Мобильное чтение'")
    public UssDocumentPage clickMobileReadButton() {
        WebElement mobileReadBlock = findElementByNoThrow(mainLeftElement, By.cssSelector(".mobile-reader"));
        assertNotNull(mobileReadBlock, "Ссылка Мобильное чтение не найдена");
        WebElement mobileReadLink = findElementByNoThrow(mobileReadBlock, By.tagName("a"));
        assertNotNull(mobileReadLink, "Ссылка Мобильное чтение не найдена");
        mobileReadLink.click();
        return redirectTo(UssDocumentPage.class);
    }

    @Step("Проверяется что кнопка 'Мобильное чтение' присутсвует")
    public UssMagazinesPage checkMobileReadButtonIsPresent() {
        WebElement mobileReadBlock = findElementByNoThrow(mainLeftElement, By.cssSelector(".mobile-reader"));
        assertNotNull(mobileReadBlock, "Ссылка Мобильное чтение не найдена");
        WebElement mobileReadLink = findElementByNoThrow(mobileReadBlock, By.tagName("a"));
        assertNotNull(mobileReadLink, "Ссылка Мобильное чтение не найдена");
        postponedAssertTrue(mobileReadLink.isEnabled() && mobileReadLink.isDisplayed(), "Ссылка Мобильное чтение не отображается");
        return this;
    }

    @Step("Проверяется что рядом с кнопкой 'Мобильное чтение' присутсвует иконка телефона")
    public UssMagazinesPage checkMobileReadIconIsPresent() {
        WebElement mobileReadBlock = findElementByNoThrow(mainLeftElement, By.cssSelector(".mobile-reader"));
        assertNotNull(mobileReadBlock, "Ссылка Мобильное чтение не найдена");
        WebElement mobileReadIcon = findElementByNoThrow(mobileReadBlock, By.cssSelector(".ico_content_iphone"));
        assertNotNull(mobileReadIcon, "Иконка телефона рядом с кнопкой 'Мобильное чтение' не найдена");
        postponedAssertTrue(mobileReadIcon.isEnabled() && mobileReadIcon.isDisplayed(), "Иконка телефона рядом с кнопкой 'Мобильное чтение' не отображается");
        return this;
    }

    @Step("Проверяется тултип для кнопки 'Мобильное чтение'")
    public UssMagazinesPage checkMobileReadButtonTooltip() {
        WebElement mobileReadBlock = findElementByNoThrow(mainLeftElement, By.cssSelector(".mobile-reader"));
        postponedAssertNotNull(mobileReadBlock, "Ссылка Мобильное чтение не найдена");
        if (mobileReadBlock != null) {
            WebElement mobileReadLink = findElementByNoThrow(mobileReadBlock, By.tagName("a"));
            assertNotNull(mobileReadLink, "Ссылка Мобильное чтение не найдена");
            postponedAssertEquals(mobileReadLink.getAttribute("title"), "Установите бесплатное мобильное приложение «Система Юрист Профиздания»", "Неправильный тултип для кнопки 'Мобильное чтение'");
        }
        return this;
    }

    private void checkRightSlide(WebElement magazineShelf) {
        report("Проверяется правый слайдер");
        WebElement pressList = magazineShelf.findElement(By.cssSelector("[data-type='magazine']"));
        WebElement rightSlider = magazineShelf.findElement(By.cssSelector(".shelf-scroller__control_type_forward"));
        int startPosition = 0;
        boolean isRightSliderDisabled = false;

        long currentTime = new Date().getTime();
        while (!rightSlider.getAttribute("class").contains("disabled")) {
            moveMouseToElement(magazineShelf);
            postponedAssertTrue(rightSlider.isEnabled() && rightSlider.isDisplayed(), "Правый слайдер не найден");
            scrollIntoView(rightSlider);
            rightSlider.click();
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

        WebElement pressList = magazineShelf.findElement(By.cssSelector("[data-type='magazine']"));
        int startPosition = getOffsetAfterClick(pressList);
        WebElement leftSlider = magazineShelf.findElement(By.cssSelector(".shelf-scroller__control_type_backward"));
        boolean isLeftSliderDisabled = false;

        long currentTime = new Date().getTime();
        while (!leftSlider.getAttribute("class").contains("disabled")) {
            moveMouseToElement(magazineShelf);
            postponedAssertTrue(leftSlider.isEnabled() && leftSlider.isDisplayed(), "Левый слайдер не найден");
            scrollIntoView(leftSlider);
            leftSlider.click();
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

    public UssMagazinesPage checkNewInMagazinesShelfIsPresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfIsPresent();
        return this;
    }

    public UssMagazinesPage checkNewInMagazinesShelfHasTitle() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfHasTitle();
        return this;
    }

    public UssMagazinesPage checkNewInMagazinesShelfNewMagazinesIsPresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfNewMagazinesIsPresent();
        return this;
    }

    public UssMagazinesPage checkNewInMagazinesShelfHasNotTitle() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfHasNotTitle();
        return this;
    }

    public UssMagazinesPage checkNewInMagazinesShelfNewBooksIsPresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfNewBooksIsPresent();
        return this;
    }

    public UssMagazinesPage checkNewInMagazinesShelfContainsMagazine(String magazineName) {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfContainsMagazine(magazineName);
        return this;
    }

    public UssMagazinesPage checkNewInMagazinesShelfMagazinesAreNotRepeated() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfMagazinesAreNotRepeated();
        return this;
    }

    public UssMagazinesPage checkNewInMagazinesShelfMagazinesAreDescending() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfMagazinesAreDescending();
        return this;
    }

    public UssMagazinesPage checkNewInMagazinesShelfMagazinesHasNumberAndYearOfPublishing() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfMagazinesHasNumberAndYearOfPublishing();
        return this;
    }

    public UssMagazinesPage checkNewInMagazinesShelfArrowsArePresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfArrowsArePresent();
        return this;
    }

    public UssMagazinesPage clickOnNewInMagazinesShelfRightArrow() {
        getHelper(PressPageHelper.class).clickOnNewInMagazinesShelfRightArrow();
        return this;
    }

    public UssMagazinesPage clickOnNewInMagazinesShelfLeftArrow() {
        getHelper(PressPageHelper.class).clickOnNewInMagazinesShelfLeftArrow();
        return this;
    }

    public UssMagazinesPage checkNewInMagazinesShelfNewMagazinesArePresentAfterClicking() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfNewMagazinesArePresentAfterClicking();
        return this;
    }

    public UssDocumentPage clickOnNewInMagazinesShelfRandomDisplayedMagazineOrBook() {
        getHelper(PressPageHelper.class).clickOnNewInMagazinesShelfRandomDisplayedMagazineOrBook();
        return redirectTo(UssDocumentPage.class);
    }

    public UssMagazinesPage checkMagazinesShelvesArePresent() {
        getHelper(PressPageHelper.class).checkMagazinesShelvesArePresent();
        return this;
    }

    public UssMagazinesPage checkMagazineShelfHasTitlePopular() {
        getHelper(PressPageHelper.class).checkMagazineShelfHasTitlePopular();
        return this;
    }

    public UssMagazinesPage checkMagazineShelfHasTitleAllMagazines() {
        getHelper(PressPageHelper.class).checkMagazineShelfHasTitleAllMagazines();
        return this;
    }

    public UssMagazinesPage checkMagazinesShelfPopularHasMaxThreeMagazines() {
        getHelper(PressPageHelper.class).checkMagazinesShelfPopularHasMaxThreeMagazines();
        return this;
    }

    public UssMagazinesPage checkMagazinesInPopularBlockAreNotRepeated() {
        getHelper(PressPageHelper.class).checkMagazinesInPopularBlockAreNotRepeated();
        return this;
    }

    public UssMagazinesPage checkMagazinesShelfAllMagazinesAreSortedDescending() {
        getHelper(PressPageHelper.class).checkMagazinesShelfAllMagazinesAreSortedDescending();
        return this;
    }

    public UssMagazinesPage checkMagazinesShelfHasOnlyMagazines() {
        getHelper(PressPageHelper.class).checkMagazinesShelfHasOnlyMagazines();
        return this;
    }

    public UssMagazinesPage checkMagazinesEachShelfHasOneMagazine() {
        getHelper(PressPageHelper.class).checkMagazinesEachShelfHasOneMagazine();
        return this;
    }

    public UssMagazinesPage checkMagazineHasNoShelf(String shelfName) {
        getHelper(PressPageHelper.class).checkMagazineHasNoShelf(shelfName);
        return this;
    }

    public UssMagazinesPage checkMagazinesShelvesHaveNumberAndYearOfPublishing() {
        getHelper(PressPageHelper.class).checkMagazinesShelvesHaveNumberAndYearOfPublishing();
        return this;
    }

    public UssMagazinesPage checkMagazinesShelvesArrowsArePresent() {
        getHelper(PressPageHelper.class).checkMagazinesShelvesArrowsArePresent();
        return this;
    }

    public UssMagazinesPage clickOnMagazinesShelfRightArrow() {
        getHelper(PressPageHelper.class).clickOnMagazinesShelfRightArrow();
        return this;
    }

    public UssMagazinesPage clickOnMagazinesShelvesLeftArrow() {
        getHelper(PressPageHelper.class).clickOnMagazinesShelvesLeftArrow();
        return this;
    }

    public UssMagazinesPage checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking() {
        getHelper(PressPageHelper.class).checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking();
        return this;
    }

    public UssDocumentPage clickOnMagazinesShelvesRandomDisplayedMagazine() {
        getHelper(PressPageHelper.class).clickOnMagazinesShelvesRandomDisplayedMagazine();
        return redirectTo(UssDocumentPage.class);
    }

    public UssMagazinesPage checkMagazineHasShelf(String shelfName) {
        getHelper(PressPageHelper.class).checkMagazineHasShelf(shelfName);
        return this;
    }

    public UssMagazinesPage checkMagazinesRubricatorButtonIsPresent() {
        getHelper(PressPageHelper.class).checkMagazinesRubricatorButtonIsPresent();
        return this;
    }

    public UssMagazinesPage sendGetRequestAndCheckThatNewShelfHasOneBookAtLeast() {
        getHelper(PressPageHelper.class).sendGetRequestAndCheckThatNewShelfHasOneBookAtLeast();
        return this;
    }

    @Override
    public UssMagazinesPage checkBookShelfIsPresent() {
        getHelper(PressPageHelper.class).checkBookShelfIsPresent();
        return this;
    }

    @Override
    public UssMagazinesPage checkBooksShelfHasPopularTitle() {
        getHelper(PressPageHelper.class).checkBooksShelfHasPopularTitle();
        return this;
    }

    @Override
    public UssMagazinesPage checkBooksShelfHasAllBooksTitle() {
        getHelper(PressPageHelper.class).checkBooksShelfHasAllBooksTitle();
        return this;
    }

    @Override
    public UssMagazinesPage checkBooksShelfPopularBlockHasThreeItems() {
        getHelper(PressPageHelper.class).checkBooksShelfPopularBlockHasThreeItems();
        return this;
    }

    @Override
    public UssMagazinesPage checkBooksShelfPopularBooksAreNotRepeated() {
        getHelper(PressPageHelper.class).checkBooksShelfPopularBooksAreNotRepeated();
        return this;
    }

    @Override
    public UssMagazinesPage checkBooksShelfAllBooksBlockIsPresent() {
        getHelper(PressPageHelper.class).checkBooksShelfAllBooksBlockIsPresent();
        return this;
    }

    @Override
    public UssMagazinesPage checkBooksShelfHasOnlyBooks() {
        getHelper(PressPageHelper.class).checkBooksShelfHasOnlyBooks();
        return this;
    }

    @Override
    public UssMagazinesPage clickOnBooksShelfRightArrow() {
        getHelper(PressPageHelper.class).clickOnBooksShelfRightArrow();
        return this;
    }

    @Override
    public UssMagazinesPage clickOnBooksShelfLeftArrow() {
        getHelper(PressPageHelper.class).clickOnBooksShelfLeftArrow();
        return this;
    }

    @Override
    public UssMagazinesPage checkBooksShelfNewBooksArePresentAfterClicking() {
        getHelper(PressPageHelper.class).checkBooksShelfNewBooksArePresentAfterClicking();
        return this;
    }

    @Override
    public UssMagazinesPage checkBooksShelfArrowsArePresent() {
        getHelper(PressPageHelper.class).checkBooksShelfArrowsArePresent();
        return this;
    }

    @Override
    public UssDocumentPage clickOnBooksShelfRandomBook() {
        getHelper(PressPageHelper.class).clickOnBooksShelfRandomDisplayedBook();
        return redirectTo(UssDocumentPage.class);
    }
}
