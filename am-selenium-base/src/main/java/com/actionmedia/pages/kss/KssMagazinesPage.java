package com.actionmedia.pages.kss;

import com.actionmedia.pages.helpers.PressPageHelper;
import com.actionmedia.pages.interfaces.IMagazinesPage;
import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.components.Link;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.helpers.SearchResultHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class KssMagazinesPage extends KssBasePage<KssMagazinesPage> implements IMagazinesPage {

    public static final String BOOK_URL = "book.url";

    @Step("Проверяются элементы на странице 'Журналы'")
    public KssMagazinesPage checkDefaultStateMagazinesPage() {
        checkMagazineTabIsSelected();
        checkSearchBoxIsPresentOnMagazinePage();
        checkNewBlockIsPresent();
        checkBooksBlockIsPresent();
        checkMagazinesBlockIsPresent();
        checkMagazinesRubricatorButtonIsPresent();
        checkMyFavoritesRubricatorButtonIsPresent();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Журналы и книги'")
    public KssMagazinesPage checkMagazineTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.MAGAZINES_AND_BOOKS);
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Журналы'")
    public KssMagazinesPage checkSearchBoxIsPresentOnMagazinePage() {
        checkSearchBoxIsPresent("Поиск по журналам и книгам");
        return this;
    }

    @Step("Проверяются блок новые книги и журналы")
    public KssMagazinesPage checkNewBlockIsPresent() {
        WebElement newBlock = mainContentElement.findElement(By.cssSelector("[data-type='news']"));
        postponedAssertTrue(newBlock.isEnabled() && newBlock.isDisplayed(), "Блок Новые книги и журналы не отображается");
        List<WebElement> newBooksAndMagazines = newBlock.findElements(By.tagName("li"));
        postponedAssertFalse(newBooksAndMagazines.isEmpty(), "Блок Новые книги и журналы пустой");
        return this;
    }

    @Step("Проверяются блок Книги")
    public KssMagazinesPage checkBooksBlockIsPresent() {
        getHelper(PressPageHelper.class).checkBookShelfIsPresent();
        return this;
    }

    @Step("Проверяются блок Журналы")
    public KssMagazinesPage checkMagazinesBlockIsPresent() {
        WebElement magazinesBlock = mainContentElement.findElement(By.cssSelector("[data-type='magazine']"));
        postponedAssertTrue(magazinesBlock.isEnabled() && magazinesBlock.isDisplayed(), "Блок Журналы не отображается");
        List<WebElement> magazines = magazinesBlock.findElements(By.tagName("li"));
        postponedAssertFalse(magazines.isEmpty(), "Блок Журналы пустой");
        return this;
    }

    @Step("Проверяется что блок Популярное на журнальных полках отображается")
    public KssMagazinesPage checkPopularMagazinesBlockIsPresent() {
        List<WebElement> magazinesShelves = waitForPresenceOfAllElementsLocatedBy(By.cssSelector("[data-type='magazine']"));
        for (int i = 0; i < magazinesShelves.size(); i++) {
            WebElement magazineShelf = magazinesShelves.get(i);
            List<WebElement> popularElement = magazineShelf.findElements(By.cssSelector(".popular"));
            postponedAssertTrue(popularElement.size() == 3, "Неправильное количество журналов в блоке Популярное на '" + (i + 3) + "' полке");
        }
        return this;
    }

    @Step("Проверяется что журналы в блоке Популярное на журнальных полках не повторяются")
    public KssMagazinesPage checkPopularMagazinesAreNotRepeated() {
        List<WebElement> magazinesShelves = waitForPresenceOfAllElementsLocatedBy(By.cssSelector("[data-type='magazine']"));
        for (int i = 0; i < magazinesShelves.size(); i++) {
            WebElement magazineShelf = magazinesShelves.get(i);
            List<WebElement> magazineList = magazineShelf.findElements(By.cssSelector(".popular"));
            List<String> magazineUrlList = new ArrayList<String>();
            for (WebElement magazine : magazineList) {
                String url = magazine.findElement(By.tagName("a")).getAttribute("href");
                postponedAssertFalse(magazineUrlList.contains(url), "Журнал из блока популярное на полке номер " + (i + 3) + " повторяется");
                magazineUrlList.add(url);
            }
        }
        return this;
    }

    @Step("Проверяется правильный порядок журналов на полках")
    public KssMagazinesPage checkMagazinesArePresentInDescendingOrder() {
        List<WebElement> magazineShelves = waitForPresenceOfAllElementsLocatedBy(By.cssSelector("[data-type='magazine']"));
        for (int shelfCounter = 0; shelfCounter < magazineShelves.size(); shelfCounter++) {
            List<WebElement> magazines = magazineShelves.get(shelfCounter).findElements(By.cssSelector(".magazine"));
            for (int magazineCounter = 0; magazineCounter < magazines.size() - 1; magazineCounter++) {
                if (getParentElement(magazines.get(magazineCounter)).getAttribute("class").contains("popular")) {
                    continue;
                }
                int firstMagazineId = Integer.parseInt(magazines.get(magazineCounter).findElement(By.tagName("a")).getAttribute("href").split("/document/")[1].replaceAll("/", ""));
                int nextMagazineId = Integer.parseInt(magazines.get(magazineCounter + 1).findElement(By.tagName("a")).getAttribute("href").split("/document/")[1].replaceAll("/", ""));
                postponedAssertTrue(firstMagazineId - nextMagazineId > 0, "Неправильный порядок журналов. Полка номер - " + (shelfCounter + 3) + ". Журнал номер - " + (magazineCounter + 1));
            }
        }
        return this;
    }

    @Step("Проверяется работа слайдеров на полке 'Новое'")
    public KssMagazinesPage checkScrollOnNewShelf() {
        WebElement shelfOfNewsItems = waitForPresenceOfElementLocatedBy(By.cssSelector("[data-type='news']"));
        checkRightSlide(shelfOfNewsItems);
        checkLeftSlide(shelfOfNewsItems);
        return this;
    }

    @Step("Проверяется работа слайдеров на полке 'Книги'")
    public KssMagazinesPage checkScrollOnBookShelf() {
        WebElement shelfOfNewsItems = waitForPresenceOfElementLocatedBy(By.cssSelector("[data-type='book']"));
        checkRightSlide(shelfOfNewsItems);
        checkLeftSlide(shelfOfNewsItems);
        return this;
    }

    @Step("Проверяется работа слайдеров на журнальных полках")
    public KssMagazinesPage checkScrollOnMagazinesShelves() {
        List<WebElement> magazineShelves = waitForPresenceOfAllElementsLocatedBy(By.cssSelector("[data-type='magazine']"));
        for (WebElement magazineShelf : magazineShelves) {
            checkRightSlide(magazineShelf);
            checkLeftSlide(magazineShelf);
        }
        return this;
    }

    private void checkRightSlide(WebElement magazineShelf) {
        report("Проверяется правый слайдер");

        List<WebElement> magazinesBeforeClick = magazineShelf.findElements(By.tagName("li"));
        WebElement pressList = magazineShelf.findElement(By.tagName("ul"));
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
            List<WebElement> magazinesAfterClick = magazineShelf.findElements(By.tagName("li"));
            postponedAssertTrue(magazinesAfterClick.size() > magazinesBeforeClick.size(), "Список журналов/книг не изменился после скролла полки");
            postponedAssertTrue(startPosition > endPosition, "Скролл вправо не работает");
            postponedAssertFalse(rightSlider.isDisplayed(), "Показан правый слайдер после скролла до конца полки");
        }
    }

    private void checkLeftSlide(WebElement magazineShelf) {
        report("Проверяется левый слайдер");

        WebElement pressList = magazineShelf.findElement(By.tagName("ul"));
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

    @Step("Проверяется заголовок журнала")
    public KssMagazinesPage checkMagazineHeader() {
        String header = waitForPresenceOfElementLocatedBy(By.cssSelector(".e-main-top")).getText();
        postponedAssertFalse(header.isEmpty(), "Заголовок журнала пустой");
        return this;
    }

    @Step("Проверяется содержание журнала не пустое")
    public KssMagazinesPage checkMagazineContent() {
        String header = waitForPresenceOfElementLocatedBy(By.cssSelector(".e-content")).getText();
        postponedAssertFalse(header.isEmpty(), "Содержание журнала пустое");
        return this;
    }

    @Step("Проверяется что элементы на полке 'Новое' не повторяются")
    public KssMagazinesPage checkItemsOnNewShelfAreNotRepeated() {
        WebElement shelfOfNewItems = waitForPresenceOfElementLocatedBy(By.cssSelector("[data-type='news']"));
        List<WebElement> newItems = shelfOfNewItems.findElements(By.tagName("li"));
        List<String> itemsUrlList = new ArrayList<String>();
        for (WebElement item : newItems) {
            if (item.getAttribute("class").contains("preloader")) {
                continue;
            }
            if (findElementByNoThrow(item, By.cssSelector(".loader")) != null) {
                continue;
            }
            String url = item.findElement(By.tagName("a")).getAttribute("href");
            postponedAssertFalse(itemsUrlList.contains(url), "Книга/журнал: " + url + " на полке 'Новое' повторяется");
            itemsUrlList.add(url);
        }
        return this;
    }

    @Step("Проверяется что элементы на полке 'Книги' не повторяются")
    public KssMagazinesPage checkItemsOnBookShelfAreNotRepeated() {
        WebElement bookShelf = waitForPresenceOfElementLocatedBy(By.cssSelector("[data-type='book']"));
        List<WebElement> newItems = bookShelf.findElements(By.tagName("li"));
        List<String> itemsUrlList = new ArrayList<String>();
        for (int i = 3; i < newItems.size(); i++) {
            WebElement item = newItems.get(i);
            if (item.getAttribute("class").contains("preloader") || item.getAttribute("class").contains("popular\n")) {
                continue;
            }
            if (findElementByNoThrow(item, By.cssSelector(".loader")) != null) {
                continue;
            }
            if (findElementByNoThrow(item, By.tagName("a")) == null) {
                continue;
            }
            String url = item.findElement(By.tagName("a")).getAttribute("href");
            postponedAssertFalse(itemsUrlList.contains(url), "Книга: " + url + " на полке 'Книги' повторяется");
            itemsUrlList.add(url);
        }
        return this;
    }

    @Step("Проверяется что элементы на полке 'Журналы' не повторяются")
    public KssMagazinesPage checkItemsOnMagazinesShelvesAreNotRepeated() {
        List<WebElement> magazinesShelves = waitForPresenceOfAllElementsLocatedBy(By.cssSelector("[data-type='magazine']"));
        for (WebElement shelf : magazinesShelves) {
            List<WebElement> newItems = shelf.findElements(By.cssSelector(".list__item"));
            List<String> itemsUrlList = new ArrayList<String>();
            for (int i = 3; i < newItems.size(); i++) {
                WebElement item = newItems.get(i);
                if (item.getAttribute("class").contains("preloader") || item.getAttribute("class").contains("popular\n")) {
                    continue;
                }
                if (findElementByNoThrow(item, By.cssSelector(".loader")) != null) {
                    continue;
                }
                if (findElementByNoThrow(item, By.tagName("a")) == null) {
                    continue;
                }
                WebElement link = findElementByNoThrow(item, By.tagName("a"));
                String url = link.getAttribute("href");
                postponedAssertFalse(itemsUrlList.contains(url), "Книга: " + url + " на полке 'Журналы' повторяется");
                itemsUrlList.add(url);
            }
        }
        return this;
    }

    @Step("Проверяется что картинки загружены для книг/журналов на полке 'Новое'")
    public KssMagazinesPage checkImageLoadedForNewShelf() {
        WebElement shelfOfNewItems = waitForPresenceOfElementLocatedBy(By.cssSelector("[data-type='news']"));
        List<WebElement> newItems = shelfOfNewItems.findElements(By.tagName("li"));
        for (WebElement item : newItems) {
            if (item.getAttribute("class").contains("preloader")) {
                continue;
            }
            if (findElementByNoThrow(item, By.cssSelector(".loader")) != null) {
                continue;
            }
            if (findElementByNoThrow(item, By.tagName("a")) == null) {
                continue;
            }
            WebElement image = item.findElement(By.tagName("img"));
            String imgUrl = image.getAttribute("src");
            postponedAssertTrue(isImageLoaded(image), "Картинка с урл на полке 'Новое' " + imgUrl + " не загрузилась");
        }
        return this;
    }

    @Step("Проверяется что картинки загружены для книг на полке 'Книги'")
    public KssMagazinesPage checkImageLoadedForBookShelf() {
        WebElement bookShelf = waitForPresenceOfElementLocatedBy(By.cssSelector("[data-type='book']"));
        List<WebElement> newItems = bookShelf.findElements(By.tagName("li"));
        for (WebElement item : newItems) {
            if (item.getAttribute("class").contains("preloader")) {
                continue;
            }
            if (findElementByNoThrow(item, By.cssSelector(".loader")) != null) {
                continue;
            }
            if (findElementByNoThrow(item, By.tagName("a")) == null) {
                continue;
            }
            WebElement image = item.findElement(By.tagName("img"));
            String imgUrl = image.getAttribute("src");
            postponedAssertTrue(isImageLoaded(image), "Картинка с урл на полке 'Книги' " + imgUrl + " не загрузилась");
        }
        return this;
    }

    @Step("Проверяется что картинки загружены для книг на полке 'Журналы'")
    public KssMagazinesPage checkImageLoadedForMagazinesShelves() {
        List<WebElement> magazinesShelves = waitForPresenceOfAllElementsLocatedBy(By.cssSelector("[data-type='magazine']"));
        for (WebElement magazineShelf : magazinesShelves) {
            List<WebElement> magazineItems = magazineShelf.findElements(By.cssSelector(".list__item"));
            for (WebElement item : magazineItems) {
                if (item.getAttribute("class").contains("preloader")) {
                    continue;
                }
                if (findElementByNoThrow(item, By.cssSelector(".loader")) != null) {
                    continue;
                }
                if (findElementByNoThrow(item, By.tagName("a")) == null) {
                    continue;
                }
                WebElement image = findElementByNoThrow(item, By.tagName("img"));
                String imgUrl = image.getAttribute("src");
                postponedAssertTrue(isImageLoaded(image), "Картинка с урл на полке 'Журналы' " + imgUrl + " не загрузилась");
            }
        }
        return this;
    }

    @Step("Проверяется работа ссылок на полке 'Новое'")
    public KssMagazinesPage checkLinkOnNewsShelf() {
        WebElement shelfOfNewItems = waitForPresenceOfElementLocatedBy(By.cssSelector("[data-type='news']"));
        List<Link> linkList = new ArrayList<Link>();
        List<WebElement> newItems = shelfOfNewItems.findElements(By.tagName("li"));
        for (WebElement newItem : newItems) {
            if (newItem.getAttribute("class").contains("preloader")) {
                continue;
            }
            if (findElementByNoThrow(newItem, By.cssSelector(".loader")) != null) {
                continue;
            }
            if (findElementByNoThrow(newItem, By.tagName("a")) == null) {
                continue;
            }
            scrollIntoView(newItem);
            String url = newItem.findElement(By.tagName("a")).getAttribute("href");
            Link link = new Link(url);
            linkList.add(link);
        }
        checkLinks(linkList, 5);
        return this;
    }

    @Step("Проверяется работа ссылок на полке 'Новое'")
    public KssMagazinesPage checkLinkOnBookShelf() {
        WebElement shelfOfNewItems = waitForPresenceOfElementLocatedBy(By.cssSelector("[data-type='book']"));
        List<Link> linkList = new ArrayList<Link>();
        List<WebElement> bookItems = shelfOfNewItems.findElements(By.tagName("li"));
        for (WebElement newItem : bookItems) {
            if (newItem.getAttribute("class").contains("preloader")) {
                continue;
            }
            if (findElementByNoThrow(newItem, By.cssSelector(".loader")) != null) {
                continue;
            }
            if (findElementByNoThrow(newItem, By.tagName("a")) == null) {
                continue;
            }
            scrollIntoView(newItem);
            String url = newItem.findElement(By.tagName("a")).getAttribute("href");
            Link link = new Link(url);
            linkList.add(link);
        }
        checkLinks(linkList, 5);
        return this;
    }

    @Step("Проверяется что работа ссылок журналов")
    public KssMagazinesPage checkMagazinesLink() {
        List<WebElement> shelves = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".shelf-scroller"));
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement shelf : shelves) {
            List<WebElement> magazinesAndBooksOnShelf = shelf.findElements(By.cssSelector(".list__item"));
            WebElement magazine = getRandomElementInList(magazinesAndBooksOnShelf);
            if (magazine.getAttribute("class").contains("preloader")) {
                continue;
            }
            if (findElementByNoThrow(magazine, By.cssSelector(".loader")) != null) {
                continue;
            }
            if (findElementByNoThrow(magazine, By.tagName("a")) == null) {
                continue;
            }
            scrollIntoView(magazine);
            String url = magazine.findElement(By.tagName("a")).getAttribute("href");
            Link link = new Link(url);
            linkList.add(link);
        }
        checkLinks(linkList);
        return this;
    }

    @Step("Проверяется что результаты поиска отсутсвуют")
    public KssMagazinesPage checkSearchResultIsNotPresentOnMagazinesPage() {
        checkSearchResultIsNotPresentOnPage();
        return this;
    }

    @Step("Нажать кнопку Найти")
    public KssMagazinesPage clickSearchButtonOnMagazinesPage() {
        clickSearchButton();
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются")
    public KssMagazinesPage checkHintsIsPresent() {
        checkHintListIsPresent();
        return this;
    }

    @Step("Нажать подсказку с прямым переходом")
    public KssSearchResultPage clickHintWithJumpOnMagazinesPage() {
        clickHintWithJump();
        return redirectTo(KssSearchResultPage.class);
    }

    @Step("Нажать любую подсказку с переходом")
    public KssSearchResultPage clickRandomHintOnMagazinesPage() {
        clickRandomHint();
        return redirectTo(KssSearchResultPage.class);
    }

    @Step("Открыть случайный документ из блока популярное")
    public KssMagazinesPage clickRandomMagazineLink() {
        List<WebElement> magazines = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".magazine"));
        WebElement randomMagazine = getRandomElementInList(magazines);
        randomMagazine.click();
        waitForReloadingPage();
        return this;
    }

    @Step("Открыть случайный документ из блока популярное")
    public KssDocumentPage clickRandomMagazineLinkAndNavigateToDocumentPage() {
        List<WebElement> magazines = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".magazine"));
        WebElement randomMagazine = getRandomElementInList(magazines);
        randomMagazine.click();
        waitForReloadingPage();
        return redirectTo(KssDocumentPage.class);
    }

    @Step("Открыть случайную книгу")
    public KssDocumentPage clickRandomBook() {
        List<WebElement> bookList = mainContentElement.findElements(By.cssSelector(".book"));
        WebElement randomBook = getRandomElementInList(bookList);
        String url = randomBook.getAttribute("href");
        setParameter(BOOK_URL, url);
        report("Открывается " + url);
        randomBook.click();
        return redirectTo(KssDocumentPage.class);
    }

    @Step("Проверяется работа кнопки Найти на странице Правовая база")
    public KssMagazinesPage checkSearchButtonFunctionalityOnSearchBox(String query) {
        setParameter(SearchResultHelper.HINT_TEXT, query);
        return clearSearchBox()
                .clickSearchButtonOnMagazinesPage()
                .checkMagazineTabIsSelected()
                .checkSearchResultIsNotPresentOnMagazinesPage()

                .clearSearchBox()
                .inputTextInSearchBox(query)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnMagazinesPageIsOpened()
                .navigateToMagazinesPage();
    }

    public KssDocumentPage clickRandomMagazine() {
        List<WebElement> magazinesList = mainContentElement.findElements(By.cssSelector(".magazine"));
        WebElement randomMagazine = getRandomElementInList(magazinesList);
        String url = randomMagazine.getAttribute("href");
        report("Открывается " + url);
        randomMagazine.click();
        return redirectTo(KssDocumentPage.class);
    }

    public KssMagazinesPage checkNewInMagazinesShelfIsPresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfIsPresent();
        return this;
    }

    public KssMagazinesPage checkNewInMagazinesShelfHasTitle() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfHasTitle();
        return this;
    }

    public KssMagazinesPage checkNewInMagazinesShelfNewMagazinesIsPresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfNewMagazinesIsPresent();
        return this;
    }

    public KssMagazinesPage checkNewInMagazinesShelfHasNotTitle() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfHasNotTitle();
        return this;
    }

    public KssMagazinesPage checkNewInMagazinesShelfNewBooksIsPresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfNewBooksIsPresent();
        return this;
    }

    public KssMagazinesPage checkNewInMagazinesShelfContainsMagazine(String magazineName) {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfContainsMagazine(magazineName);
        return this;
    }

    public KssMagazinesPage checkNewInMagazinesShelfMagazinesAreNotRepeated() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfMagazinesAreNotRepeated();
        return this;
    }

    public KssMagazinesPage checkNewInMagazinesShelfMagazinesAreDescending() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfMagazinesAreDescending();
        return this;
    }

    public KssMagazinesPage checkNewInMagazinesShelfMagazinesHasNumberAndYearOfPublishing() {
        // do nothing
        // hook for duplicating tests; The kss system has not numbers for published magazines
        return this;
    }

    public KssMagazinesPage checkNewInMagazinesShelfArrowsArePresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfArrowsArePresent();
        return this;
    }

    public KssMagazinesPage clickOnNewInMagazinesShelfRightArrow() {
        getHelper(PressPageHelper.class).clickOnNewInMagazinesShelfRightArrow();
        return this;
    }

    public KssMagazinesPage clickOnNewInMagazinesShelfLeftArrow() {
        getHelper(PressPageHelper.class).clickOnNewInMagazinesShelfLeftArrow();
        return this;
    }

    public KssMagazinesPage checkNewInMagazinesShelfNewMagazinesArePresentAfterClicking() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfNewMagazinesArePresentAfterClicking();
        return this;
    }

    public KssDocumentPage clickOnNewInMagazinesShelfRandomDisplayedMagazineOrBook() {
        getHelper(PressPageHelper.class).clickOnNewInMagazinesShelfRandomDisplayedMagazineOrBook();
        return redirectTo(KssDocumentPage.class);
    }

    public KssMagazinesPage checkMagazinesShelvesArePresent() {
        getHelper(PressPageHelper.class).checkMagazinesShelvesArePresent();
        return this;
    }

    public KssMagazinesPage checkMagazineShelfHasTitlePopular() {
        getHelper(PressPageHelper.class).checkMagazineShelfHasTitlePopular();
        return this;
    }

    public KssMagazinesPage checkMagazineShelfHasTitleAllMagazines() {
        getHelper(PressPageHelper.class).checkMagazineShelfHasTitleAllMagazines();
        return this;
    }

    public KssMagazinesPage checkMagazinesShelfPopularHasMaxThreeMagazines() {
        getHelper(PressPageHelper.class).checkMagazinesShelfPopularHasMaxThreeMagazines();
        return this;
    }

    public KssMagazinesPage checkMagazinesInPopularBlockAreNotRepeated() {
        getHelper(PressPageHelper.class).checkMagazinesInPopularBlockAreNotRepeated();
        return this;
    }

    public KssMagazinesPage checkMagazinesShelfAllMagazinesAreSortedDescending() {
        getHelper(PressPageHelper.class).checkMagazinesShelfAllMagazinesAreSortedDescending();
        return this;
    }

    public KssMagazinesPage checkMagazinesShelfHasOnlyMagazines() {
        getHelper(PressPageHelper.class).checkMagazinesShelfHasOnlyMagazines();
        return this;
    }

    public KssMagazinesPage checkMagazinesEachShelfHasOneMagazine() {
        getHelper(PressPageHelper.class).checkMagazinesEachShelfHasOneMagazine();
        return this;
    }

    public KssMagazinesPage checkMagazineHasNoShelf(String shelfName) {
        getHelper(PressPageHelper.class).checkMagazineHasNoShelf(shelfName);
        return this;
    }

    public KssMagazinesPage checkMagazinesShelvesHaveNumberAndYearOfPublishing() {
        getHelper(PressPageHelper.class).checkMagazinesShelvesHaveNumberAndYearOfPublishing();
        return this;
    }

    public KssMagazinesPage checkMagazinesShelvesArrowsArePresent() {
        getHelper(PressPageHelper.class).checkMagazinesShelvesArrowsArePresent();
        return this;
    }

    public KssMagazinesPage clickOnMagazinesShelfRightArrow() {
        getHelper(PressPageHelper.class).clickOnMagazinesShelfRightArrow();
        return this;
    }

    public KssMagazinesPage clickOnMagazinesShelvesLeftArrow() {
        getHelper(PressPageHelper.class).clickOnMagazinesShelvesLeftArrow();
        return this;
    }

    public KssMagazinesPage checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking() {
        getHelper(PressPageHelper.class).checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking();
        return this;
    }

    public KssDocumentPage clickOnMagazinesShelvesRandomDisplayedMagazine() {
        getHelper(PressPageHelper.class).clickOnMagazinesShelvesRandomDisplayedMagazine();
        return redirectTo(KssDocumentPage.class);
    }

    public KssMagazinesPage checkMagazineHasShelf(String shelfName) {
        getHelper(PressPageHelper.class).checkMagazineHasShelf(shelfName);
        return this;
    }

    public KssMagazinesPage checkMagazinesRubricatorButtonIsPresent() {
        getHelper(PressPageHelper.class).checkMagazinesRubricatorButtonIsPresent();
        return this;
    }

    public KssMagazinesPage sendGetRequestAndCheckThatNewShelfHasOneBookAtLeast() {
        getHelper(PressPageHelper.class).sendGetRequestAndCheckThatNewShelfHasOneBookAtLeast();
        return this;
    }

    @Override
    public KssMagazinesPage checkBookShelfIsPresent() {
        getHelper(PressPageHelper.class).checkBookShelfIsPresent();
        return this;
    }

    @Override
    public KssMagazinesPage checkBooksShelfHasPopularTitle() {
        getHelper(PressPageHelper.class).checkBooksShelfHasPopularTitle();
        return this;
    }

    @Override
    public KssMagazinesPage checkBooksShelfHasAllBooksTitle() {
        getHelper(PressPageHelper.class).checkBooksShelfHasAllBooksTitle();
        return this;
    }

    @Override
    public KssMagazinesPage checkBooksShelfPopularBlockHasThreeItems() {
        getHelper(PressPageHelper.class).checkBooksShelfPopularBlockHasThreeItems();
        return this;
    }

    @Override
    public KssMagazinesPage checkBooksShelfPopularBooksAreNotRepeated() {
        getHelper(PressPageHelper.class).checkBooksShelfPopularBooksAreNotRepeated();
        return this;
    }

    @Override
    public KssMagazinesPage checkBooksShelfAllBooksBlockIsPresent() {
        getHelper(PressPageHelper.class).checkBooksShelfAllBooksBlockIsPresent();
        return this;
    }

    @Override
    public KssMagazinesPage checkBooksShelfHasOnlyBooks() {
        getHelper(PressPageHelper.class).checkBooksShelfHasOnlyBooks();
        return this;
    }

    @Override
    public KssMagazinesPage clickOnBooksShelfRightArrow() {
        getHelper(PressPageHelper.class).clickOnBooksShelfRightArrow();
        return this;
    }

    @Override
    public KssMagazinesPage clickOnBooksShelfLeftArrow() {
        getHelper(PressPageHelper.class).clickOnBooksShelfLeftArrow();
        return this;
    }

    @Override
    public KssMagazinesPage checkBooksShelfNewBooksArePresentAfterClicking() {
        getHelper(PressPageHelper.class).checkBooksShelfNewBooksArePresentAfterClicking();
        return this;
    }

    @Override
    public KssMagazinesPage checkBooksShelfArrowsArePresent() {
        getHelper(PressPageHelper.class).checkBooksShelfArrowsArePresent();
        return this;
    }

    @Override
    public KssDocumentPage clickOnBooksShelfRandomBook() {
        getHelper(PressPageHelper.class).clickOnBooksShelfRandomDisplayedBook();
        return redirectTo(KssDocumentPage.class);
    }
    
    
}
