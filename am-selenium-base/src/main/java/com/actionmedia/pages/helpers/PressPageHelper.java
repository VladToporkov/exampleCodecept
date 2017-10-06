package com.actionmedia.pages.helpers;

import com.actionmedia.autotest.selenium.annotations.Wait;
import com.actionmedia.base.BasePage;
import com.actionmedia.util.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

/**
 * Created by Pavel on 20/04/16.
 */
@Component
public class PressPageHelper extends BasePage<PressPageHelper> {

    private static List<WebElement> magazinesAndBooksNewShelf = new ArrayList<WebElement>();
    private static List<WebElement> booksInBooksShelf = new ArrayList<WebElement>();
    private static Map<WebElement, List<WebElement>> shelvesAndMagazines = new HashMap<WebElement, List<WebElement>>();

    @Step("Проверяется, что полка Новое отображена на странице")
    public void checkNewInMagazinesShelfIsPresent() {
        WebElement newInMagazinesShelf = findElementByNoThrow(By.cssSelector("[data-type='news']"));
        postponedAssertTrue(newInMagazinesShelf != null && newInMagazinesShelf.isDisplayed(), "Полка Новое не отображена");
        magazinesAndBooksNewShelf = getVisibleMagazinesIn(newInMagazinesShelf);
        if (magazinesAndBooksNewShelf == null || magazinesAndBooksNewShelf.isEmpty()) {
            setPostponedTestFail("Журналы не найдены на полке Новое");
        }
    }

    @Step("Проверяется, что полки с Журналами отображены на странице")
    public void checkMagazinesShelvesArePresent() {
        List<WebElement> allMagazinesShelf = findElementsByNoThrow(By.cssSelector("[data-type='magazine']"));

        for (WebElement shelf : allMagazinesShelf) {
            List<WebElement> magazinesOnShelf = getVisibleMagazinesIn(shelf);
            postponedAssertFalse(magazinesOnShelf.isEmpty(), "На одной из полок не найдено ни одного журнала");
            shelvesAndMagazines.put(shelf, magazinesOnShelf);
        }
    }

    @Step("Проверяется, что полка Новое имеет заголовок")
    public void checkNewInMagazinesShelfHasTitle() {
        String content = getPropertyValueElementBefore("[data-type='news'] .list__item:first-child", "content");
        if (content == null || content.isEmpty()) {
            setPostponedTestFail("Первый журнал не найден или заголовок Новое над ним отсутствует");
        } else {
            postponedAssertEquals(content, "Новое", "Полка Новое называется не верно");
        }
    }

    @Step("Проверяется, что полка Новое не имеет заголовка")
    public void checkNewInMagazinesShelfHasNotTitle() {
        String content = getPropertyValueElementBefore("[data-type='news'] .list__item:first-child", "content");
        postponedAssertTrue(content == null || content.isEmpty() || content.equals("none"), "Название полки Новое найдено у первого элемента, " +
                "хотя быть не должно, content=" + content);
    }

    @Step("Проверяется, что на полке Новое отображаются журналы")
    public void checkNewInMagazinesShelfNewMagazinesIsPresent() {
        WebElement newInMagazinesShelf = findElementByNoThrow(By.cssSelector("[data-type='news']"));
        List<WebElement> magazines = findElementsByNoThrow(newInMagazinesShelf, By.cssSelector(".magazine"));
        postponedAssertTrue(magazines != null && !magazines.isEmpty(), "Журналы на полке Новое не найдены");
    }

    @Step("Проверяется, что на полке Новое отображаются книги")
    public void checkNewInMagazinesShelfNewBooksIsPresent() {
        WebElement newInMagazinesShelf = findElementByNoThrow(By.cssSelector("[data-type='news']"));
        List<WebElement> books = findElementsByNoThrow(newInMagazinesShelf, By.cssSelector(".book"));
        postponedAssertTrue(books != null && !books.isEmpty(), "Книги на полке Новое не найдены");
    }

    @Step("Проверяется, что на полке Новое НЕ отображаются книги")
    public void checkNewInMagazinesShelfNewBooksIsNotPresent() {
        WebElement newInMagazinesShelf = findElementByNoThrow(By.cssSelector("[data-type='news']"));
        List<WebElement> books = findElementsByNoThrow(newInMagazinesShelf, By.cssSelector(".book"));
        postponedAssertFalse(books != null && !books.isEmpty(), "Книги на полке Новое найдены");
    }

    @Step("Проверяется, что отображается определенный журнал на полке новое: {0}")
    public void checkNewInMagazinesShelfContainsMagazine(String magazineName) {
        for (WebElement magazine : magazinesAndBooksNewShelf) {
            String title = magazine.getAttribute("title");
            if (title.contains(magazineName)) {
                return;
            }
        }
        setPostponedTestFail("Журнал:" + magazineName + " не найден среди подгруженных журналов на полке Новое");
    }

    @Step("Проверяется, что журналы не повторяются")
    public void checkNewInMagazinesShelfMagazinesAreNotRepeated() {
        List<String> titles = new ArrayList<String>();
        for (WebElement magazine : magazinesAndBooksNewShelf) {
            String title = magazine.getAttribute("title");
            if (!title.isEmpty()) {
                if (titles.contains(title)) {
                    setPostponedTestFail("Журнал " + title + " повторяется на полке Новое");
                }
                titles.add(title);
            }
        }
    }

    @Step("Проверяется, что журналы расположены по порядку (от новых к старым)")
    public void checkNewInMagazinesShelfMagazinesAreDescending() {
        WebElement newInMagazinesShelf = findElementByNoThrow(By.cssSelector("[data-type='news']"));
        postponedAssertTrue(isSortedDescending(newInMagazinesShelf), "Журналы расположены не по порядку");
    }

//    private boolean isSortedDescendingShelf(WebElement shelf) {
//        Set<String> dates = new HashSet<String>();
//        postponedAssertThat(getVisibleMagazinesIn(shelf), TestUtils.sortedDatesStringsInDescendingOrder(),
//                "Журнал " + magazineName + " имеет неправильную сортировку:" + forVerifyDescending);
//
//    }

    private boolean isSortedDescending(WebElement shelf) {
        Map<String, List<String>> magazines = new HashMap<String, List<String>>();
        boolean hasMoreThanOne = false;

        for (WebElement magazine : getVisibleMagazinesIn(shelf)) {
            if (!magazine.getAttribute("class").contains("popular")) { //not working for popular block
                WebElement magazineLink = findElementByNoThrow(magazine, By.cssSelector(".magazine"));
                if (magazineLink != null) {
                    String title = magazineLink.getAttribute("title");
                    if (title.contains(",")) {
                        String[] titleAndPublishing = title.split(",");
                        String magazineName = titleAndPublishing[0].contains("№") ? titleAndPublishing[0].split("№")[0] :
                                titleAndPublishing[0]; //for magazines which contains a number
                        if (magazines.containsKey(magazineName)) {
                            List<String> oldPublishingDates = magazines.get(magazineName);
                            magazines.remove(magazineName);
                            oldPublishingDates.add(titleAndPublishing[1]);
                            magazines.put(magazineName, oldPublishingDates);
                        } else {
                            List<String> publishingDates = new ArrayList<String>();
                            publishingDates.add(titleAndPublishing[1]);
                            magazines.put(magazineName, publishingDates);
                        }
                    }
                }
            }
        }
        if (magazines.isEmpty()) {
            setPostponedTestFail("Журналы не найдены");
        } else {
            Iterator iterator = magazines.keySet().iterator();
            while (iterator.hasNext()) {
                String magazineName = iterator.next().toString();
                List<String> forVerifyDescending = magazines.get(magazineName);
                if (forVerifyDescending.size() > 1) {
                    postponedAssertThat(forVerifyDescending, TestUtils.sortedDatesStringsInDescendingOrder(), "Журнал " + magazineName + " имеет неправильную сортировку:" + forVerifyDescending);
                    hasMoreThanOne = true;
                }
            }
            if (!hasMoreThanOne) {
                setPostponedTestFail("Не найден ни один журнал на полке Новое, который представлен в нескольких изданиях. Проверка не пройдена");
            }
        }
        return hasMoreThanOne;
    }

    @Step("Проверяется, что на обожках журналов отображается номер и год издания")
    public void checkNewInMagazinesShelfMagazinesHasNumberAndYearOfPublishing() {
        WebElement newInMagazinesShelf = findElementByNoThrow(By.cssSelector("[data-type='news']"));
        checkMagazinesShelfHasNumberAndYearOfPublishing(newInMagazinesShelf);
    }

    @Step("Проверяется, что для полки Журналы отображаются номер и год издания")
    public void checkMagazinesShelvesHaveNumberAndYearOfPublishing() {
        List<WebElement> allMagazinesShelf = findElementsByNoThrow(By.cssSelector("[data-type='magazine']"));

        for (WebElement shelf : allMagazinesShelf) {
            checkMagazinesShelfHasNumberAndYearOfPublishing(shelf);
        }
    }

    private void checkMagazinesShelfHasNumberAndYearOfPublishing(WebElement shelf) {
        List<WebElement> magazines = getVisibleMagazinesIn(shelf);
        for (WebElement magazine : magazines) {
            WebElement link = findElementByNoThrow(magazine, By.cssSelector(".magazine"));
            if (link != null) {
                WebElement badge = findElementByNoThrow(magazine, By.cssSelector(".magazine__badge"));
                postponedAssertTrue(badge != null && badge.isDisplayed() && !badge.getText().isEmpty(), "Номер журнала " +
                        link.getAttribute("title") + " не отображается");
            }
        }
    }

    @Step("Проверяется, что отображаются кнопки вперед и назад если навели курсор")
    public void checkNewInMagazinesShelfArrowsArePresent() {
        WebElement newInMagazinesShelf = findElementByNoThrow(By.cssSelector("[data-type='news']"));
        checkArrowsArePresent(newInMagazinesShelf);
    }

    @Step("Проверяется, что отображаются кнопки вперед и назад, если навели курсор")
    public void checkMagazinesShelvesArrowsArePresent() {
        List<WebElement> allMagazinesShelf = findElementsByNoThrow(By.cssSelector("[data-type='magazine']"));

        for (WebElement shelf : allMagazinesShelf) {
            checkArrowsArePresent(shelf);
        }
    }

    private void checkArrowsArePresent(WebElement shelf) {
        Actions action = new Actions(getDriver());
        action.moveToElement(shelf).build().perform();
        WebElement arrowRight = findElementByNoThrow(shelf, By.cssSelector("[class*='forward']"));
        postponedAssertTrue(arrowRight != null && arrowRight.isDisplayed(), "Кнопка вправо не видна");
        WebElement arrowLeft = findElementByNoThrow(shelf, By.cssSelector("[class*='backward']"));
        postponedAssertTrue(arrowLeft != null && arrowLeft.isDisplayed(), "Кнопка влево не видна");
    }

    @Step("Нажимается кнопка вперед для полки Новое")
    public void clickOnNewInMagazinesShelfRightArrow() {
        WebElement newInMagazinesShelf = findElementByNoThrow(By.cssSelector("[data-type='news']"));
        scrollToElementLocationWithout200px(newInMagazinesShelf);
        clickOnNextArrowForShelf(newInMagazinesShelf);
    }

    @Step("Нажимается кнопка вперед")
    public void clickOnMagazinesShelfRightArrow() {
        List<WebElement> allMagazinesShelf = findElementsByNoThrow(By.cssSelector("[data-type='magazine']"));

        for (WebElement shelf : allMagazinesShelf) {
            scrollToElementLocationWithout200px(shelf);
            clickOnNextArrowForShelf(shelf);
        }
    }

    private void clickOnNextArrowForShelf(WebElement shelf) {
        Actions action = new Actions(getDriver());
        action.moveToElement(shelf).build().perform();
        waitFewSecond(1000);
        WebElement arrowRight = findElementByNoThrow(shelf, By.cssSelector("[class*='forward']"));
        postponedAssertFalse(arrowRight == null || !arrowRight.isDisplayed(), "Кнопка вправо не видна");
        if (arrowRight != null) {
            arrowRight.click();
            waitForReloadingPage();
        }
    }

    @Step("Нажимается кнопка назад для полки Новое")
    public void clickOnNewInMagazinesShelfLeftArrow() {
        WebElement newInMagazinesShelf = findElementByNoThrow(By.cssSelector("[data-type='news']"));
        scrollToElementLocationWithout200px(newInMagazinesShelf);
        clickOnBackArrowForShelf(newInMagazinesShelf);
    }

    @Step("Нажимается кнопка назад")
    public void clickOnMagazinesShelvesLeftArrow() {
        List<WebElement> allMagazinesShelf = findElementsByNoThrow(By.cssSelector("[data-type='magazine']"));
        for (WebElement shelf : allMagazinesShelf) {
            scrollToElementLocationWithout200px(shelf);
            clickOnBackArrowForShelf(shelf);
        }
    }

    private void clickOnBackArrowForShelf(WebElement shelf) {
        Actions action = new Actions(getDriver());
        action.moveToElement(shelf).build().perform();
        waitFewSecond(1000);
        WebElement arrowLeft = findElementByNoThrow(shelf, By.cssSelector("[class*='backward']"));
        postponedAssertFalse(arrowLeft == null || !arrowLeft.isDisplayed(), "Кнопка влево не видна");
        if (arrowLeft != null) {
            arrowLeft.click();
            waitForReloadingPage();
        }
    }

    @Step("Проверяется, что новые журналы подгружаются и становятся видимыми после нажатия на кнопку")
    public void checkNewInMagazinesShelfNewMagazinesArePresentAfterClicking() {
        WebElement newInMagazinesShelf = findElementByNoThrow(By.cssSelector("[data-type='news']"));
        List<WebElement> newMagazines = getVisibleMagazinesIn(newInMagazinesShelf);
        postponedAssertNotEquals(newMagazines, magazinesAndBooksNewShelf, "После нажатия на кнопку журналы не изменились");
        magazinesAndBooksNewShelf.clear();
        magazinesAndBooksNewShelf.addAll(newMagazines);
    }

    @Step("Проверяется, что новые журналы подгружаются и становятся видимыми после нажатия на кнопку")
    public void checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking() {
        List<WebElement> allMagazinesShelf = findElementsByNoThrow(By.cssSelector("[data-type='magazine']"));

        for (WebElement shelf : allMagazinesShelf) {
            List<WebElement> newMagazines = getVisibleMagazinesIn(shelf);
            postponedAssertNotEquals(newMagazines, shelvesAndMagazines.get(shelf), "После нажатия на кнопку журналы не изменились");
        }
    }

    @Step("Нажимается любой журнал с полки Новое")
    public void clickOnNewInMagazinesShelfRandomDisplayedMagazineOrBook() {
        WebElement newInMagazinesShelf = findElementByNoThrow(By.cssSelector("[data-type='news']"));
        WebElement randomMagazineOrBook = getRandomElementInList(getVisibleMagazinesIn(newInMagazinesShelf));
        WebElement link = randomMagazineOrBook.findElement(By.tagName("a"));
        setParameter(SearchResultHelper.DOCUMENT_URL, link.getAttribute("href"));
        link.click();
        waitForReloadingPage();
    }

    @Step("Нажимается любой журнал из полки Журналы")
    public void clickOnMagazinesShelvesRandomDisplayedMagazine() {
        Random generator = new Random();
        Object[] values = shelvesAndMagazines.values().toArray();
        Object randomValue = values[generator.nextInt(values.length)];
        WebElement randElement = (WebElement) randomValue;
        randElement.click();
    }

    @Step("Проверяется, что полка Журналы имеет заголовок Популярное")
    public void checkMagazineShelfHasTitlePopular() {
        String content = getPropertyValueElementBefore("[data-type='magazine'] [class*='popular-first']", "content");
        if (content == null || content.isEmpty()) {
            setPostponedTestFail("Первый журнал не найден или заголовок Новое над ним отсутствует");
        } else {
            postponedAssertEquals(content, "\"Популярные\"", "Группа Популярные называется не верно в Журналах");
        }
    }

    @Step("Проверяется, что полка Журналы имеет заголовок Все журналы")
    public void checkMagazineShelfHasTitleAllMagazines() {
        String content = getPropertyValueElementBefore("[data-type='magazine'] [class*='content_other']", "content");
        if (content == null || content.isEmpty()) {
            setPostponedTestFail("Первый журнал не найден или заголовок Новое над ним отсутствует");
        } else {
            postponedAssertEquals(content, "\"Все журналы\"", "Полка Все журналы называется не верно в Журналах");
        }
    }

    @Step("Проверяется, что блок Популярные имеет максимум три журнала")
    public void checkMagazinesShelfPopularHasMaxThreeMagazines() {
        List<WebElement> firstMagazinesShelf = findElementsByNoThrow(By.xpath("//*[@data-type='magazine'][1]//li[contains(@class,'popular')]"));
        postponedAssertTrue(firstMagazinesShelf.size() >= 1 && firstMagazinesShelf.size() <= 3, "Блок популярное имеет неверное количество элементов:" + firstMagazinesShelf.size());
    }

    @Step("Проверяется, что журналы внутри блока Популярное не повторяются")
    public void checkMagazinesInPopularBlockAreNotRepeated() {
        WebElement firstMagazinesShelf = findElementByNoThrow(By.xpath("//*[@data-type='magazine'][1]"));
        List<WebElement> popular = findElementsByNoThrow(firstMagazinesShelf, By.cssSelector(".popular a"));
        List<String> magazinesTitles = new ArrayList<String>();
        for (WebElement magazine : popular) {
            magazinesTitles.add(magazine.getAttribute("title"));
        }
        Set<String> set = new HashSet<String>(magazinesTitles);
        postponedAssertEquals(set.size(), magazinesTitles.size(), "В блоке Популярное найдены повторяющиеся журналы:" + magazinesTitles);
    }

    @Step("Проверяется, что журналы расположены по порядку (от новых к старым)")
    public void checkMagazinesShelfAllMagazinesAreSortedDescending() {
        List<WebElement> allMagazinesShelf = findElementsByNoThrow(By.cssSelector("[data-type='magazine']"));

        int countShelf = 1;
        for (WebElement shelf : allMagazinesShelf) {
            postponedAssertTrue(isSortedDescending(shelf), "Журналы на " + countShelf++ + " полке расположены не по порядку");
        }
    }

    @Step("Проверяется, что на полках Журналов отображаются только журналы")
    public void checkMagazinesShelfHasOnlyMagazines() {
        List<WebElement> allMagazinesShelf = findElementsByNoThrow(By.cssSelector("[data-type='magazine']"));

        for (WebElement shelf : allMagazinesShelf) {
            WebElement book = findElementByNoThrow(shelf, By.cssSelector(".book"));
            postponedAssertNull(book, "На полке журналы найдена книга:");
        }
    }

    @Step("Проверяется, что на каждой полке Журнала отображается только журналы одного издания")
    public void checkMagazinesEachShelfHasOneMagazine() {
        List<WebElement> allMagazinesShelf = findElementsByNoThrow(By.cssSelector("[data-type='magazine']"));

        for (WebElement shelf : allMagazinesShelf) {
            List<WebElement> visibleMagazines = getVisibleMagazinesIn(shelf);
            String previousMagazineTitle = "";
            for (WebElement magazine : visibleMagazines) {
                String title = magazine.getAttribute("title");
                if (title.contains(",")) {
                    String[] titleAndPublishing = title.split(",");
                    String magazineName = titleAndPublishing[0].contains("№") ? titleAndPublishing[0].split("№")[0] :
                            titleAndPublishing[0]; //for magazines which contains a number
                    if (previousMagazineTitle.isEmpty()) {
                        previousMagazineTitle = magazineName;
                    }
                    postponedAssertEquals(magazineName, previousMagazineTitle, "Названия журналов с одной полки не совпадают");
                }
            }
        }
    }

    @Step("Проверяется, что для журнала {0} нет отдельной полки")
    public void checkMagazineHasNoShelf(String magazineName) {
        WebElement magazine = findElementByNoThrow(By.cssSelector(String.format("[data-type='magazine'] .magazine[title*='%s']", magazineName)));
        postponedAssertNull(magazine, "Журнал: " + magazineName + " найден на полках");
    }

    @Step("Проверяется, что для журнала {0} есть отдельная полка")
    public void checkMagazineHasShelf(String magazineName) {
        WebElement magazine = findElementByNoThrow(By.cssSelector(String.format("[data-type='magazine'] .magazine[title*='%s']", magazineName)));
        postponedAssertNotNull(magazine, "Журнал: " + magazineName + " не найден");
        postponedAssertTrue(magazine != null && magazine.isDisplayed(), "Журнал " + magazineName + " не отображается");
    }

    @Step("Проверяется, что полка Книги отображается на странице")
    public void checkBookShelfIsPresent() {
        WebElement bookBlock = mainContentElement.findElement(By.cssSelector("[data-type='book']"));
        postponedAssertTrue(bookBlock.isEnabled() && bookBlock.isDisplayed(), "Блок Книги не отображается");
        List<WebElement> books = bookBlock.findElements(By.tagName("a"));
        postponedAssertFalse(books.isEmpty(), "Блок Книги пустой");
        if (books != null) {
            booksInBooksShelf.addAll(books);
        }
    }

    @Step("Проверяется, что кнопка Все журналы и книги отображается")
    public void checkMagazinesRubricatorButtonIsPresent() {
        waitForPresenceOfElementLocatedBy(By.id("rubricator-btn"), "кнопка рубрикатора журналов не найдена");
//        postponedAssertEqualsText(rubricatorButton, magazines);
    }

    @Step("Проверяется блок Книги")
    public void checkBooksBlockIsPresent() {
        WebElement bookBlock = findElementByNoThrow(mainContentElement, By.xpath("//h1[text()='Книги']"));
        assertNotNull(bookBlock, "Блок Книги не найден");
        postponedAssertTrue(bookBlock.isDisplayed(), "Блок Книги не отображается");
        List<WebElement> bookList = mainContentElement.findElement(By.cssSelector("[data-type='book']")).findElements(By.tagName("li"));
        postponedAssertFalse(bookList.isEmpty(), "Блок Книги пустой");
    }

    @Step("Отправить запрос на получение журналов с полки новое и проверить, что среди журналов есть хотя бы одна книга")
    public void sendGetRequestAndCheckThatNewShelfHasOneBookAtLeast() {
        try {
            String response = TestUtils.sendAJAXRequest_Get150MagazinesAndBooksFromPressNewShelf(getDriver());
            if (response == null || response.isEmpty()) {
                setPostponedTestFail("Не получилось сделать запрос к полке новое. Ответ пустой.");
            } else {
                postponedAssertTrue(response.contains("book"), "Не найдено ни одной книги на полке новое. " +
                        "Response=" + response);
            }
        } catch (URISyntaxException e) {
            setPostponedTestFail("Не получилось сделать запрос к полке новое");
            throw new IllegalStateException("Не удалось сделать запрос до полки новое " + e.getMessage());
        } catch (IOException e) {
            setPostponedTestFail("Не получилось сделать запрос к полке новое");
            throw new IllegalStateException("Не удалось сделать запрос до полки новое " + e.getMessage());
        }
    }

    @Step("Проверяется, что отображается заголовок блока Популярные")
    public void checkBooksShelfHasPopularTitle() {
        String content = getPropertyValueElementBefore("[data-type='book'] [class*='popular-first']", "content");
        if (content == null || content.isEmpty()) {
            setPostponedTestFail("Первая книга не найден или заголовок Популярные над ним отсутствует");
        } else {
            postponedAssertEquals(content, "\"Популярные\"", "Группа Популярные называется не верно в Книгах");
        }
    }

    @Step("Проверяется, что отображается заголовок Все книги в блоке Книги")
    public void checkBooksShelfHasAllBooksTitle() {
        String content = getPropertyValueElementBefore("[data-type='book'] [class*='content_other']", "content");
        if (content == null || content.isEmpty()) {
            setPostponedTestFail(" ");
        } else {
            postponedAssertEquals(content, "\"Все книги\"", "Полка Книги называется не верно в разделе Журналы");
        }
    }

    @Step("Проверяется, что блок Популярное в Книгах имеет три элемента")
    public void checkBooksShelfPopularBlockHasThreeItems() {
        List<WebElement> threeItems = findElementsByNoThrow(By.cssSelector("[data-type='book'] [class*='popular']"));
        if (threeItems == null || threeItems.isEmpty()) {
            setPostponedTestFail("В Книгах в блоке популярное не найдены элементы");
        } else {
            postponedAssertTrue(threeItems.size() == 3, "В книгах в блоке популярное не три элемента:" +
                    threeItems.size());
        }
    }

    @Step("Проверяется, что Книги в блоке Популярное нет повторяющихся элементов")
    public void checkBooksShelfPopularBooksAreNotRepeated() {
        WebElement booksShelf = findElementByNoThrow(By.xpath("//*[@data-type='book'][1]"));
        List<WebElement> popular = findElementsByNoThrow(booksShelf, By.cssSelector(".popular a"));
        List<String> booksTitles = new ArrayList<String>();
        for (WebElement magazine : popular) {
            booksTitles.add(magazine.getAttribute("title"));
        }
        Set<String> set = new HashSet<String>(booksTitles);
        postponedAssertEquals(set.size(), booksTitles.size(), "В блоке Популярное найдены повторяющиеся журналы:" + booksTitles);
    }

    @Step("Проверяется, что отображается блок Все книги")
    public void checkBooksShelfAllBooksBlockIsPresent() {
        List<WebElement> books = findElementsByNoThrow(By.xpath("//*[@data-type='book'][1]//li[not(contains(@class,'popular'))]"));
        postponedAssertTrue(books != null && !books.isEmpty(), "В блоке Все книги не отображены книги");
    }

    @Step("Проверяется, что на полке Книги отображаются только книги")
    public void checkBooksShelfHasOnlyBooks() {
        WebElement booksShelf = findElementByNoThrow(By.xpath("//*[@data-type='book'][1]"));
        List<WebElement> itemsOnBookShelf =  findElementsByNoThrow(booksShelf, By.tagName("a"));
        if (itemsOnBookShelf != null) {
            for (WebElement item : itemsOnBookShelf) {
                String classAttribute = item.getAttribute("class");
                postponedAssertTrue(classAttribute != null && classAttribute.contains("book") &&
                        !classAttribute.contains("magazine"), "На полке книги есть не только книги. " +
                        "Проверьте вхождение класса book для всех элементов с полки книги и отсутствие magazine в " +
                        "классе для каждого тега a");
            }
        } else {
            setPostponedTestFail("Элементы не найдены на полке книги");
        }
    }

    @Step("Нажимается кнопка вперед для полки Книги")
    public void clickOnBooksShelfRightArrow() {
        WebElement booksShelf = findElementByNoThrow(By.cssSelector("[data-type='book']"));
        scrollToElementLocationWithout200px(booksShelf);
        clickOnNextArrowForShelf(booksShelf);
    }

    @Step("Нажимается кнопка назад для полки Книги")
    public void clickOnBooksShelfLeftArrow() {
        WebElement booksShelf = findElementByNoThrow(By.cssSelector("[data-type='book']"));
        scrollToElementLocationWithout200px(booksShelf);
        clickOnBackArrowForShelf(booksShelf);
    }

    @Step("Проверяется, что новые книги подгружаются и становятся видимыми после нажатия на кнопку")
    public void checkBooksShelfNewBooksArePresentAfterClicking() {
        WebElement booksShelf = findElementByNoThrow(By.cssSelector("[data-type='book']"));
        List<WebElement> books = getVisibleMagazinesIn(booksShelf);
        postponedAssertNotEquals(books, booksShelf, "После нажатия на кнопку журналы не изменились");
        booksInBooksShelf.clear();
        booksInBooksShelf.addAll(books);
    }

    @Step("Нажимается любой журнал с полки Книги")
    public void clickOnBooksShelfRandomDisplayedBook() {
        WebElement booksShelf = findElementByNoThrow(By.cssSelector("[data-type='book']"));
        WebElement randomBook = getRandomElementInList(getVisibleMagazinesIn(booksShelf));
        WebElement link = randomBook.findElement(By.tagName("a"));
        setParameter(SearchResultHelper.DOCUMENT_URL, link.getAttribute("href"));
        link.click();
        waitForReloadingPage();
    }

    @Step("Проверяется, что отображаются кнопки вперед и назад если навели курсор")
    public void checkBooksShelfArrowsArePresent() {
        WebElement booksShelf = findElementByNoThrow(By.cssSelector("[data-type='book']"));
        checkArrowsArePresent(booksShelf);
    }

    /*
        Returns only VISIBLE magazines in the required shelf. Working with shelves that update
        themselves after clicking twice on the right arrow
     */
    private List<WebElement> getVisibleMagazinesIn(WebElement shelf) {
        List<WebElement> allMagazines = findElementsByNoThrow(shelf, By.cssSelector("ul li"));
        List<WebElement> visibleMagazines = new ArrayList<WebElement>();
        for (WebElement magazine : allMagazines) {
            if (magazine.isDisplayed()) {
                visibleMagazines.add(magazine);
            }
        }
        return visibleMagazines;
    }
}
