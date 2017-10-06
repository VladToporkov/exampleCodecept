package com.actionmedia.pages.fss;

import com.actionmedia.pages.helpers.PressPageHelper;
import com.actionmedia.pages.interfaces.IMagazinesPage;
import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.autotest.selenium.context.ComponentProvider;
import com.actionmedia.components.Link;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.RightPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 05.11.13
 * Time: 10:53
 */
@Component
public class FssMagazinesPage extends FssBasePage<FssMagazinesPage> implements ComponentProvider, IMagazinesPage {

    private RightPanel rightPanel;

    @Override
    public void handleRedirect() {
        super.handleRedirect();
        rightPanel = getHelper(RightPanel.class, this);
    }

    @Step("Проверяется что открыта страница 'Библиотека'")
    public FssMagazinesPage checkMagazinesPageIsOpened() {
        checkMagazinesTabIsSelected();
        checkSearchBoxPresentOnMagazinePage();
        checkHeaderDefaultState();
        checkNewMagazinesAndBooksShelfIsPresent();
        checkNewMagazinesAndBooksShelfIsNotEmpty();
        checkBooksShelfIsPresent();
        checkBooksShelfIsNotEmpty();
        checkMagazinesShelvesIsPresent();
        checkMagazinesShelvesIsNotEmpty();
        checkRubricatorMenuIsPresent();
        checkRubricatorMenuIsNotEmpty();
        checkPopularBlockIsPresent();
        checkPopularBlockIsNotEmpty();
        return this;
    }

    @Step("Проверяются элементы на странице 'Библиотека'")
    public FssMagazinesPage checkDefaultStateMagazinesPage() {
        checkMagazinesTabIsSelected();
        checkSearchBoxPresentOnMagazinePage();
        checkHeaderDefaultState();
        checkNewMagazinesAndBooksShelfIsPresent();
        checkNewMagazinesAndBooksShelfIsNotEmpty();
        checkBooksShelfIsPresent();
        checkBooksShelfIsNotEmpty();
        checkMagazinesShelvesIsPresent();
        checkMagazinesShelvesIsNotEmpty();
        checkSliderIsPresentOnNewMagazinesShelf();
        checkSliderIsPresentOnBooksShelf();
        checkRubricatorMenuIsPresent();
        checkRubricatorMenuIsNotEmpty();
        checkPopularBlockIsPresent();
        checkPopularBlockIsNotEmpty();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Библиотека'")
    public FssMagazinesPage checkMagazinesTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.LIBRARY);
        return this;
    }

    @Step("Проверяется заголовок страницы 'Библиотека'")
    public FssMagazinesPage checkHeaderDefaultState() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement header = findElementByNoThrow(content, By.cssSelector(".doc-header"));
        assertNotNull(header, "Заголовок страницы 'Библиотека' не найден");
        postponedAssertTrue(header.isDisplayed(), "Заголовок страницы 'Библиотека' не отображается");
        postponedAssertEquals(header.findElement(By.tagName("h1")).getText().trim(), "НОВЫЕ ЖУРНАЛЫ И КНИГИ", "Неправильный текст заголовка страницы 'Библиотека'");
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Библиотека'")
    public FssMagazinesPage checkSearchBoxPresentOnMagazinePage() {
        checkSearchBoxIsPresent("Поиск по журналам и книгам");
        return this;
    }

    @Step("Проверяется что блок Новое на странице 'Библиотека' отображается")
    public FssMagazinesPage checkNewsBlockIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement newsBlock = findElementByNoThrow(content, By.id("main-article"));
        assertNotNull(newsBlock, "Блок Новое на странице 'Библиотека' не найден");
        postponedAssertTrue(newsBlock.isDisplayed(), "Блок Новое на странице 'Библиотека' не отображается");
        return this;
    }

    @Step("Проверяется что полка с новыми журналами и книгами отображается")
    public FssMagazinesPage checkNewMagazinesAndBooksShelfIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("main-article"));
        WebElement newMagazinesAndBooks = findElementByNoThrow(content, By.id("newmagazineandbook"));
        assertNotNull(newMagazinesAndBooks, "Полка с новыми журналами и книгами не найдена");
        postponedAssertTrue(newMagazinesAndBooks.isDisplayed(), "Полка с новыми журналами и книгами не отображается");
        return this;
    }

    @Step("Проверяется что полка с новыми журналами и книгами не пустая")
    public FssMagazinesPage checkNewMagazinesAndBooksShelfIsNotEmpty() {
        WebElement newMagazinesAndBooks = waitForVisibilityOfElementLocatedBy(By.id("newmagazineandbook"));
        List<WebElement> magazines = newMagazinesAndBooks.findElements(By.tagName("li"));
        postponedAssertFalse(magazines.isEmpty(), "Полка с новыми журналами и книгами пустая");
        return this;
    }

    @Step("Проверяется что полка с книгами отображается")
    public FssMagazinesPage checkBooksShelfIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("main-article"));
        WebElement newMagazinesAndBooks = findElementByNoThrow(content, By.id("allbook"));
        assertNotNull(newMagazinesAndBooks, "Полка с книгами не найдена");
        postponedAssertTrue(newMagazinesAndBooks.isDisplayed(), "Полка с книгами не отображается");
        return this;
    }

    @Step("Проверяется что полка с книгами не пустая")
    public FssMagazinesPage checkBooksShelfIsNotEmpty() {
        WebElement booksShelf = waitForVisibilityOfElementLocatedBy(By.id("allbook"));
        List<WebElement> magazines = booksShelf.findElements(By.tagName("li"));
        postponedAssertFalse(magazines.isEmpty(), "Полка с книгами пустая");
        return this;
    }

    @Step("Проверяется что полка с журналами отображается")
    public FssMagazinesPage checkMagazinesShelvesIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("main-article"));
        List<WebElement> magazinesShelves = findElementsByNoThrow(content, By.cssSelector(".b-news"));
        assertNotNull(magazinesShelves.size() == 4, "Полки с журналами не найдена");
        for (int i = 0; i < magazinesShelves.size(); i++) {
            postponedAssertTrue(magazinesShelves.get(i).isDisplayed(), (i + 1) + " полка с журналами не отображается");
        }
        return this;
    }

    @Step("Проверяется что полка с журналами не пустая")
    public FssMagazinesPage checkMagazinesShelvesIsNotEmpty() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("main-article"));
        List<WebElement> magazinesShelves = content.findElements(By.cssSelector(".b-news"));
        for (int i = 0; i < magazinesShelves.size(); i++) {
            List<WebElement> magazines = magazinesShelves.get(i).findElements(By.tagName("li"));
            postponedAssertFalse(magazines.isEmpty(), (i + 1) + " полка с журналами пустая");
        }
        return this;
    }

    @Step("Проверяется что блок Новое на странице 'Библиотека' не пустой")
    public FssMagazinesPage checkNewsBlockIsNotEmpty() {
        WebElement newsBlock = waitForVisibilityOfElementLocatedBy(By.id("main-article"));
        List<WebElement> newsItemList = newsBlock.findElements(By.cssSelector(".b-news"));
        postponedAssertFalse(newsItemList.isEmpty(), "Блок Новое на странице 'Библиотека' пустой");
        return this;
    }

    @Step("Проверяется что меню Рубрикатора на странице 'Библиотека' отображается")
    public FssMagazinesPage checkRubricatorMenuIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement rubricatorMenu = findElementByNoThrow(content, By.id("sidebar"));
        assertNotNull(rubricatorMenu, "Меню Рубрикатора на странице 'Библиотека' не найдено");
        postponedAssertTrue(rubricatorMenu.isDisplayed(), "Меню Рубрикатора на странице 'Библиотека' не отображается");
        return this;
    }

    @Step("Проверяется что меню Рубрикатора на странице 'Библиотека' не пустое")
    public FssMagazinesPage checkRubricatorMenuIsNotEmpty() {
        List<WebElement> newsItemList = sidebarElement.findElements(By.tagName("li"));
        postponedAssertFalse(newsItemList.isEmpty(), "Меню Рубрикатора на странице 'Библиотека' пустое");
        return this;
    }

    @Step("Проверяется что правая панель на странице 'Библиотека' отображается")
    public FssMagazinesPage checkPopularBlockIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement rubricatorMenu = findElementByNoThrow(content, By.id("aside"));
        assertNotNull(rubricatorMenu, "Правая панель на странице 'Библиотека' не найдена");
        postponedAssertTrue(rubricatorMenu.isDisplayed(), "Правая панель на странице 'Библиотека' не отображается");
        return this;
    }

    @Step("Проверяется что правая панель на странице 'Библиотека' не пустая")
    public FssMagazinesPage checkPopularBlockIsNotEmpty() {
        WebElement newsBlock = getCollapsedRightPanel();
        List<WebElement> newsItemList = newsBlock.findElements(By.cssSelector(".go"));
        postponedAssertFalse(newsItemList.isEmpty(), "Правая панель на странице 'Библиотека' пустая");
        return this;
    }

    @Step("Проверяется что слайдер на полке Новые журналы и книги отображается")
    public FssMagazinesPage checkSliderIsPresentOnNewMagazinesShelf() {
        WebElement newMagazineShelf = waitForVisibilityOfElementLocatedBy(By.id("newmagazineandbook"));
        WebElement slider = findElementByNoThrow(newMagazineShelf, By.cssSelector(".b-switch-list"));
        assertNotNull(slider, "Слайдер на полке Новые журналы и книги не найден");
        postponedAssertTrue(slider.isDisplayed(), "Слайдер на полке Новые журналы и книги не отображается");
        return this;
    }

    @Step("Проверяется что слайдер на полке книги отображается")
    public FssMagazinesPage checkSliderIsPresentOnBooksShelf() {
        WebElement newMagazineShelf = waitForVisibilityOfElementLocatedBy(By.id("allbook"));
        WebElement slider = findElementByNoThrow(newMagazineShelf, By.cssSelector(".b-switch-list"));
        assertNotNull(slider, "Слайдер на полке книги не найден");
        postponedAssertTrue(slider.isDisplayed(), "Слайдер на полке книги не отображается");
        return this;
    }

    @Step("Проверяется начальное состояние для полки с новыми книгами и журналами")
    public FssMagazinesPage checkFirstScreenInNewMagazinesShelf() {
        checkScreenInNewMagazinesShelf(0, 0, 5);
        return this;
    }

    @Step("Проверяется второй экран для полки с новыми книгами и журналами")
    public FssMagazinesPage checkSecondScreenInNewMagazinesShelf() {
        checkScreenInNewMagazinesShelf(-695, 5, 10);
        return this;
    }

    @Step("Проверяется третий экран для полки с новыми книгами и журналами")
    public FssMagazinesPage checkThirdScreenInNewMagazinesShelf() {
        checkScreenInNewMagazinesShelf(-1390, 10, 15);
        return this;
    }

    @Step("Проверяется первый экран для полки Все книги")
    public FssMagazinesPage checkFirstScreenInBooksShelf() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("allbook"));
        WebElement booksShelf = content.findElement(By.cssSelector(".b-slider"));
        List<WebElement> books = booksShelf.findElements(By.tagName("a"));
        int startOffset = Integer.parseInt(getOffset(booksShelf.findElement(By.tagName("ul"))));
        postponedAssertTrue(startOffset == 0, "Неправильное начальное положение книг");
        for (int i = 0; i < books.size(); i++) {
            WebElement book = books.get(i);
            WebElement bookImg = book.findElement(By.tagName("img"));
            if (i < 8) {
                postponedAssertTrue(isImageLoaded(bookImg), "Картинка не загружена для книги номер " + (i + 1) + " на полке Все книги");
            }
        }
        return this;
    }

    @Step("Проверяется второй экран для полки Все книги")
    public FssMagazinesPage checkSecondScreenInBooksShelf() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("allbook"));
        WebElement booksShelf = content.findElement(By.cssSelector(".b-slider"));
        List<WebElement> books = booksShelf.findElements(By.tagName("a"));
        int startOffset = Integer.parseInt(getOffset(booksShelf.findElement(By.tagName("ul"))));
        postponedAssertTrue(startOffset == -696, "Неправильное начальное положение книг");
        for (int i = 8; i < books.size(); i++) {
            WebElement book = books.get(i);
            WebElement bookImg = book.findElement(By.tagName("img"));
            if (i < 16) {
                postponedAssertTrue(isImageLoaded(bookImg), "Картинка не загружена для книги номер " + (i + 1) + " на полке Все книги");
            }
        }
        return this;
    }

    @Step("Проверяется третий экран для полки Все книги")
    public FssMagazinesPage checkThirdScreenInBooksShelf() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("allbook"));
        WebElement booksShelf = content.findElement(By.cssSelector(".b-slider"));
        List<WebElement> books = booksShelf.findElements(By.tagName("a"));
        int startOffset = Integer.parseInt(getOffset(booksShelf.findElement(By.tagName("ul"))));
        postponedAssertTrue(startOffset == -1392, "Неправильное начальное положение книг");
        for (int i = 16; i < books.size(); i++) {
            WebElement book = books.get(i);
            WebElement bookImg = book.findElement(By.tagName("img"));
            if (i > 16) {
                postponedAssertTrue(isImageLoaded(bookImg), "Картинка не загружена для книги номер " + (i + 1) + " на полке Все книги");
            }
        }
        return this;
    }

    @Step("Открыть первый экран на полке Новые журналы и книги")
    public FssMagazinesPage clickFirstScreenOnNewMagazinesAndBooks() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("newmagazineandbook"));
        WebElement slider = content.findElement(By.cssSelector(".b-switch-list"));
        slider.findElements(By.tagName("li")).get(0).findElement(By.tagName("a")).click();
        return this;
    }

    @Step("Открыть второй экран на полке Новые журналы и книги")
    public FssMagazinesPage clickSecondScreenOnNewMagazinesAndBooks() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("newmagazineandbook"));
        WebElement slider = content.findElement(By.cssSelector(".b-switch-list"));
        slider.findElements(By.tagName("li")).get(1).findElement(By.tagName("a")).click();
        return this;
    }

    @Step("Открыть третий экран на полке Новые журналы и книги")
    public FssMagazinesPage clickThirdScreenOnNewMagazinesAndBooks() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("newmagazineandbook"));
        WebElement slider = content.findElement(By.cssSelector(".b-switch-list"));
        slider.findElements(By.tagName("li")).get(2).findElement(By.tagName("a")).click();
        return this;
    }

    @Step("Открыть первый экран на полке Все книги")
    public FssMagazinesPage clickFirstScreenOnBooks() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("allbook"));
        WebElement slider = content.findElement(By.cssSelector(".b-switch-list"));
        slider.findElements(By.tagName("li")).get(0).findElement(By.tagName("a")).click();
        return this;
    }

    @Step("Открыть второй экран на полке Все книги")
    public FssMagazinesPage clickSecondScreenOnBooks() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("allbook"));
        WebElement slider = content.findElement(By.cssSelector(".b-switch-list"));
        slider.findElements(By.tagName("li")).get(1).findElement(By.tagName("a")).click();
        return this;
    }

    @Step("Открыть третий экран на полке Все книги")
    public FssMagazinesPage clickThirdScreenOnBooks() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("allbook"));
        WebElement slider = content.findElement(By.cssSelector(".b-switch-list"));
        slider.findElements(By.tagName("li")).get(2).findElement(By.tagName("a")).click();
        return this;
    }

    public FssMagazinesPage clickExtendPopularBlock() {
        getHelper(FssHelpers.class).clickExtendPopularBlock();
        return this;
    }

    @Step("Открыть раздел Популярное в правой панели")
    public FssMagazinesPage clickPopularTab() {
        rightPanel.clickPopularTabInExpanded();
        return this;
    }

    @Step("Открыть раздел Просмотренное в правой панели")
    public FssMagazinesPage clickViewedTab() {
        rightPanel.clickViewedTabInExpanded();
        return this;
    }

    @Step("Закрыть правую панель")
    public FssMagazinesPage closePopularBlock() {
        rightPanel.closePopularBlock();
        return this;
    }

    @Step("Проверяется работа ссылок из раздела Просмотренное в правой панели")
    public FssMagazinesPage checkRandomLinksFromExpandedViewedBlock() {
        clickExtendPopularBlock();
        clickViewedTab();
        List<Link> linkList = getRandomElementsInList(rightPanel.getLinks(), 3);
        for (Link link : linkList) {
            checkLink(link);
            clickExtendPopularBlock();
            clickViewedTab();
        }
        return this;
    }

    @Step("Проверяется работа ссылок из раздела Популярное в правой панели")
    public FssMagazinesPage checkRandomLinksFromExpandedPopularBlock() {
        clickExtendPopularBlock();
        clickPopularTab();
        List<Link> linkList = getRandomElementsInList(rightPanel.getLinks(), 3);
        for (Link link : linkList) {
            checkLink(link);
            clickExtendPopularBlock();
            clickPopularTab();
        }
        return this;
    }

    @Step("Проверяются фильтры в правой панели")
    public FssMagazinesPage checkFiltersInRightPanel() {
        clickExtendPopularBlock();
        clickViewedTab();
        rightPanel.checkDateFilters();
        return this;
    }

    @Step("Проверяется что у всех документов отображаются скриншоты, у книг отображаются авторы")
    public FssMagazinesPage checkContentForMagazinesAndBooks() {
        clickExtendPopularBlock();
        clickViewedTab();
        rightPanel.checkContentForMagazinesAndBooks();
        clickPopularTab();
        rightPanel.checkContentForMagazinesAndBooks();
        return this;
    }

    private String getOffset(WebElement element) {
        return element.getAttribute("style").split(":")[1].split("px")[0].trim();
    }

    @Step("Проверяется работа ссылок для полки Новые журналы и книги")
    public FssMagazinesPage checkRandomLinkFromNewMagazinesAndBooks() {
        WebElement newMagazinesAndBooks = waitForVisibilityOfElementLocatedBy(By.id("newmagazineandbook"));
        List<WebElement> magazinesAndBooks = newMagazinesAndBooks.findElement(By.cssSelector(".b-slider ")).findElements(By.tagName("li"));
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement magazineAndBook : magazinesAndBooks) {
            String url = magazineAndBook.findElement(By.tagName("a")).getAttribute("href");
            String title = magazineAndBook.findElement(By.tagName("a")).getAttribute("title");
            String header = magazineAndBook.findElement(By.tagName("a")).getText();
            String rubricatorId = magazineAndBook.findElement(By.tagName("a")).getAttribute("data-rubricator-id");
            if (title != null && title.toLowerCase().contains("практическое налоговое планирование")) {
                continue;
            }
            if (header != null && header.toLowerCase().contains("практическое налоговое планирование")) {
                continue;
            }
            if (rubricatorId != null && rubricatorId.equals("156")) {
                continue;
            }
            Link link = new Link(url, title);
            linkList.add(link);
        }
        checkLinks(getRandomElementsInList(linkList, 3));
        return this;
    }

    @Step("Проверяется работа ссылок для полки Все книги")
    public FssMagazinesPage checkRandomLinkFromBooks() {
        WebElement bookShelf = waitForVisibilityOfElementLocatedBy(By.id("allbook"));
        List<WebElement> booksList = bookShelf.findElement(By.cssSelector(".b-slider ")).findElements(By.tagName("a"));
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement book : booksList) {
            String url = book.getAttribute("href");
            String header = book.getAttribute("title");
            Link link = new Link(url, header);
            linkList.add(link);
        }
        checkLinks(getRandomElementsInList(linkList, 3));
        return this;
    }

    @Step("Проверяется работа ссылок для полки Журналы")
    public FssMagazinesPage checkRandomLinkFromMagazines() {
        List<WebElement> magazinesColumnList = waitForVisibilityOfAllElementsLocatedBy(By.cssSelector(".dual"));
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement magazinesColumn : magazinesColumnList) {
            List<WebElement> magazines = magazinesColumn.findElements(By.cssSelector(".b-preview"));
            for (WebElement magazine : magazines) {
                String url = magazine.findElement(By.tagName("a")).getAttribute("href");
                String title = magazine.findElement(By.tagName("a")).getAttribute("title");
                String header = magazine.findElement(By.tagName("a")).getAttribute("title");
                String rubricatorId = magazine.findElement(By.tagName("a")).getAttribute("data-rubricator-id");
                if (title != null && title.contains("Практическое налоговое планирование")) {
                    continue;
                }
                if (header != null && header.toLowerCase().contains("практическое налоговое планирование")) {
                    continue;
                }
                if (rubricatorId != null && rubricatorId.equals("156")) {
                    continue;
                }
                Link link = new Link(url, title);
                linkList.add(link);
            }
        }
        checkLinks(linkList);
        return this;
    }

    @Step("Поверяется что клик по году раскрывает рубрикатор раздела Журналы и книги")
    public FssMagazinesPage checkRandomYearLink() {
        List<WebElement> magazinesColumnList = waitForVisibilityOfAllElementsLocatedBy(By.cssSelector(".column"));
        List<WebElement> newList = new ArrayList<WebElement>();
        for (WebElement magazineColumn : magazinesColumnList) {
            WebElement magazineNameLink = magazineColumn.findElement(By.tagName("a"));
            String magazineName = magazineNameLink.getText().toLowerCase();
            if (magazineName.contains("практическое налоговое планирование")) {
                continue;
            }
            newList.add(magazineColumn);
        }
        WebElement randomMagazine = getRandomElementInList(newList);
        WebElement yearBlock = randomMagazine.findElement(By.cssSelector(".years"));
        String magazineName = yearBlock.findElement(By.cssSelector(".go")).getText().split("«")[1].split("»")[0];
        report("Проверяется ссылка на рубрикатор для журнала " + magazineName);
        List<WebElement> yearsLinkList = yearBlock.findElement(By.cssSelector(".x-small")).findElements(By.tagName("a"));
        WebElement yearLink = getRandomElementInList(yearsLinkList);
        String year = yearLink.getText();
        yearLink.click();
        WebElement rubricator = waitForVisibilityOfElementLocatedBy(By.id("rubricator"), "Рубрикатор не найден");
        waitForTextToBePresentIn(rubricator);
        checkRubricator(magazineName);
        checkRubricatorMenu(magazineName, year);
        rubricator.findElement(By.cssSelector("[data-close='true']")).click();
        return this;
    }

    @Step("Открыть случайный журнал")
    public FssDocumentPage clickRandomMagazine() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("main-article"));
        List<WebElement> magazinesList = content.findElements(By.cssSelector(".mag"));
        List<WebElement> newList = new ArrayList<WebElement>();
        for (WebElement magazine : magazinesList) {
            WebElement link = magazine.findElement(By.tagName("a"));
            String title = link.getAttribute("title");
            if (title != null && title.toLowerCase().contains("практическое налоговое планирование")) {
                continue;
            }
            newList.add(magazine);
        }
        WebElement randomMagazine = getRandomElementInList(newList);
        randomMagazine.findElement(By.tagName("a")).click();
        return redirectTo(FssDocumentPage.class);
    }

    @Step("Открыть случайный журнал")
    public FssDocumentPage clickRandomBook() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("main-article"));
        List<WebElement> bookList = content.findElements(By.cssSelector(".book"));
        WebElement randomBook = getRandomElementInList(bookList);
        randomBook.findElement(By.tagName("a")).click();
        return redirectTo(FssDocumentPage.class);
    }

    public FssMagazinesPage checkCollapsedRightPanel() {
        getHelper(FssHelpers.class).checkCollapsedRightPanel(rightPanel);
        return this;
    }

    public FssMagazinesPage checkExpandedRightPanel() {
        getHelper(FssHelpers.class).checkExpandedRightPanel(rightPanel);
        return this;
    }

    public FssMagazinesPage checkRandomLinksFromCollapsedPopularTab() {
        getHelper(FssHelpers.class).checkRandomLinksFromCollapsedPopularTab(rightPanel);
        return this;
    }

    public FssMagazinesPage checkRandomLinksFromCollapsedViewedTab() {
        getHelper(FssHelpers.class).checkRandomLinksFromCollapsedViewedTab(rightPanel);
        return this;
    }

    private void checkRubricator(String magazineName) {
        WebElement rubricator = waitForVisibilityOfElementLocatedBy(By.id("rubricator"));
        List<WebElement> magazinesNumberList = getMagazineNumber(rubricator.findElement(By.tagName("ul")).findElements(By.tagName("li")));
        for (WebElement magazineNumber : magazinesNumberList) {
            String magazineNumberString = magazineNumber.findElement(By.tagName("h3")).getText();
            WebElement magazineImg = magazineNumber.findElement(By.tagName("img"));
            postponedAssertTrue(isImageLoaded(magazineImg), "Картинка не загружена для " + magazineName + " номер " + magazineNumberString);
        }
    }

    private void checkRubricatorMenu(String magazineName, String year) {
        WebElement rubricatorMenu = sidebarElement.findElement(By.cssSelector(".b-menu"));
        WebElement selectedItem = rubricatorMenu.findElement(By.cssSelector(".selected"));
        String activeMagazineName = selectedItem.findElement(By.tagName("a")).getText();
        String activeMagazineYear = selectedItem.findElement(By.cssSelector(".selected")).findElement(By.tagName("a")).getText();
        postponedAssertEquals(activeMagazineName, magazineName, "В рубрикаторе выбран неправильный журнал");
        postponedAssertEquals(activeMagazineYear, year, "В рубрикаторе выбран неправильный год");
    }

    private List<WebElement> getMagazineNumber(List<WebElement> rubricatorElementList) {
        List<WebElement> magazineNumberList = new ArrayList<WebElement>();
        for (WebElement element : rubricatorElementList) {
            scrollIntoView(element);
            if ("clear".equals(element.getAttribute("class"))) {
                magazineNumberList.add(element);
            }
        }
        return magazineNumberList;
    }

    private void checkScreenInNewMagazinesShelf(int expectedStartOffset, int startIndex, int endIndex) {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("newmagazineandbook"));
        WebElement newMagazineShelf = content.findElement(By.cssSelector(".b-slider"));
        List<WebElement> magazinesAndBook = newMagazineShelf.findElements(By.tagName("li"));
        int startOffset = Integer.parseInt(getOffset(newMagazineShelf.findElement(By.tagName("ul"))));
        postponedAssertTrue(startOffset == expectedStartOffset, "Неправильное начальное положение книг/журналов");
        for (int i = 0; i < magazinesAndBook.size(); i++) {
            WebElement magazine = magazinesAndBook.get(i);
            WebElement magazineImg = magazine.findElement(By.tagName("img"));
            if (i >= startIndex && i < endIndex) {
                postponedAssertFalse(magazine.getAttribute("class").contains("hide"), (i + 1) + " книга/журнал не отображается");
                postponedAssertTrue(isImageLoaded(magazineImg), "Картинка не загружена для книги/журнала номер " + (i + 1) + " на полке Новые книги и журналы");
            } else {
                postponedAssertTrue(magazine.getAttribute("class").contains("hide"), (i + 1) + " книга/журнал отображается");
            }
        }
    }

    public FssMagazinesPage checkNewInMagazinesShelfIsPresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfIsPresent();
        return this;
    }

    public FssMagazinesPage checkNewInMagazinesShelfHasTitle() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfHasTitle();
        return this;
    }

    public FssMagazinesPage checkNewInMagazinesShelfNewMagazinesIsPresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfNewMagazinesIsPresent();
        return this;
    }

    public FssMagazinesPage checkNewInMagazinesShelfHasNotTitle() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfHasNotTitle();
        return this;
    }

    public FssMagazinesPage checkNewInMagazinesShelfNewBooksIsPresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfNewBooksIsPresent();
        return this;
    }

    public FssMagazinesPage checkNewInMagazinesShelfContainsMagazine(String magazineName) {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfContainsMagazine(magazineName);
        return this;
    }

    public FssMagazinesPage checkNewInMagazinesShelfMagazinesAreNotRepeated() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfMagazinesAreNotRepeated();
        return this;
    }

    public FssMagazinesPage checkNewInMagazinesShelfMagazinesAreDescending() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfMagazinesAreDescending();
        return this;
    }

    public FssMagazinesPage checkNewInMagazinesShelfMagazinesHasNumberAndYearOfPublishing() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfMagazinesHasNumberAndYearOfPublishing();
        return this;
    }

    public FssMagazinesPage checkNewInMagazinesShelfArrowsArePresent() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfArrowsArePresent();
        return this;
    }

    public FssMagazinesPage clickOnNewInMagazinesShelfRightArrow() {
        getHelper(PressPageHelper.class).clickOnNewInMagazinesShelfRightArrow();
        return this;
    }

    public FssMagazinesPage clickOnNewInMagazinesShelfLeftArrow() {
        getHelper(PressPageHelper.class).clickOnNewInMagazinesShelfLeftArrow();
        return this;
    }

    public FssMagazinesPage checkNewInMagazinesShelfNewMagazinesArePresentAfterClicking() {
        getHelper(PressPageHelper.class).checkNewInMagazinesShelfNewMagazinesArePresentAfterClicking();
        return this;
    }

    public FssDocumentPage clickOnNewInMagazinesShelfRandomDisplayedMagazineOrBook() {
        getHelper(PressPageHelper.class).clickOnNewInMagazinesShelfRandomDisplayedMagazineOrBook();
        return redirectTo(FssDocumentPage.class);
    }

    public FssMagazinesPage checkMagazinesShelvesArePresent() {
        getHelper(PressPageHelper.class).checkMagazinesShelvesArePresent();
        return this;
    }

    public FssMagazinesPage checkMagazineShelfHasTitlePopular() {
        getHelper(PressPageHelper.class).checkMagazineShelfHasTitlePopular();
        return this;
    }

    public FssMagazinesPage checkMagazineShelfHasTitleAllMagazines() {
        getHelper(PressPageHelper.class).checkMagazineShelfHasTitleAllMagazines();
        return this;
    }

    public FssMagazinesPage checkMagazinesShelfPopularHasMaxThreeMagazines() {
        getHelper(PressPageHelper.class).checkMagazinesShelfPopularHasMaxThreeMagazines();
        return this;
    }

    public FssMagazinesPage checkMagazinesInPopularBlockAreNotRepeated() {
        getHelper(PressPageHelper.class).checkMagazinesInPopularBlockAreNotRepeated();
        return this;
    }

    public FssMagazinesPage checkMagazinesShelfAllMagazinesAreSortedDescending() {
        getHelper(PressPageHelper.class).checkMagazinesShelfAllMagazinesAreSortedDescending();
        return this;
    }

    public FssMagazinesPage checkMagazinesShelfHasOnlyMagazines() {
        getHelper(PressPageHelper.class).checkMagazinesShelfHasOnlyMagazines();
        return this;
    }

    public FssMagazinesPage checkMagazinesEachShelfHasOneMagazine() {
        getHelper(PressPageHelper.class).checkMagazinesEachShelfHasOneMagazine();
        return this;
    }

    public FssMagazinesPage checkMagazineHasNoShelf(String shelfName) {
        getHelper(PressPageHelper.class).checkMagazineHasNoShelf(shelfName);
        return this;
    }

    public FssMagazinesPage checkMagazinesShelvesHaveNumberAndYearOfPublishing() {
        getHelper(PressPageHelper.class).checkMagazinesShelvesHaveNumberAndYearOfPublishing();
        return this;
    }

    public FssMagazinesPage checkMagazinesShelvesArrowsArePresent() {
        getHelper(PressPageHelper.class).checkMagazinesShelvesArrowsArePresent();
        return this;
    }

    public FssMagazinesPage clickOnMagazinesShelfRightArrow() {
        getHelper(PressPageHelper.class).clickOnMagazinesShelfRightArrow();
        return this;
    }

    public FssMagazinesPage clickOnMagazinesShelvesLeftArrow() {
        getHelper(PressPageHelper.class).clickOnMagazinesShelvesLeftArrow();
        return this;
    }

    public FssMagazinesPage checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking() {
        getHelper(PressPageHelper.class).checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking();
        return this;
    }

    public FssDocumentPage clickOnMagazinesShelvesRandomDisplayedMagazine() {
        getHelper(PressPageHelper.class).clickOnMagazinesShelvesRandomDisplayedMagazine();
        return redirectTo(FssDocumentPage.class);
    }

    public FssMagazinesPage checkBooksBlockIsPresent() {
        getHelper(PressPageHelper.class).checkBooksBlockIsPresent();
        return this;
    }

    public FssMagazinesPage checkMagazineHasShelf(String shelfName) {
        getHelper(PressPageHelper.class).checkMagazineHasShelf(shelfName);
        return this;
    }

    public FssMagazinesPage checkMagazinesRubricatorButtonIsPresent() {
        getHelper(PressPageHelper.class).checkMagazinesRubricatorButtonIsPresent();
        return this;
    }

    public FssMagazinesPage sendGetRequestAndCheckThatNewShelfHasOneBookAtLeast() {
        getHelper(PressPageHelper.class).sendGetRequestAndCheckThatNewShelfHasOneBookAtLeast();
        return this;
    }

    @Override
    public FssMagazinesPage checkBookShelfIsPresent() {
        getHelper(PressPageHelper.class).checkBookShelfIsPresent();
        return this;
    }

    @Override
    public FssMagazinesPage checkBooksShelfHasPopularTitle() {
        getHelper(PressPageHelper.class).checkBooksShelfHasPopularTitle();
        return this;
    }

    @Override
    public FssMagazinesPage checkBooksShelfHasAllBooksTitle() {
        getHelper(PressPageHelper.class).checkBooksShelfHasAllBooksTitle();
        return this;
    }

    @Override
    public FssMagazinesPage checkBooksShelfPopularBlockHasThreeItems() {
        getHelper(PressPageHelper.class).checkBooksShelfPopularBlockHasThreeItems();
        return this;
    }

    @Override
    public FssMagazinesPage checkBooksShelfPopularBooksAreNotRepeated() {
        getHelper(PressPageHelper.class).checkBooksShelfPopularBooksAreNotRepeated();
        return this;
    }

    @Override
    public FssMagazinesPage checkBooksShelfAllBooksBlockIsPresent() {
        getHelper(PressPageHelper.class).checkBooksShelfAllBooksBlockIsPresent();
        return this;
    }

    @Override
    public FssMagazinesPage checkBooksShelfHasOnlyBooks() {
        getHelper(PressPageHelper.class).checkBooksShelfHasOnlyBooks();
        return this;
    }

    @Override
    public FssMagazinesPage clickOnBooksShelfRightArrow() {
        getHelper(PressPageHelper.class).clickOnBooksShelfRightArrow();
        return this;
    }

    @Override
    public FssMagazinesPage clickOnBooksShelfLeftArrow() {
        getHelper(PressPageHelper.class).clickOnBooksShelfLeftArrow();
        return this;
    }

    @Override
    public FssMagazinesPage checkBooksShelfNewBooksArePresentAfterClicking() {
        getHelper(PressPageHelper.class).checkBooksShelfNewBooksArePresentAfterClicking();
        return this;
    }

    @Override
    public FssMagazinesPage checkBooksShelfArrowsArePresent() {
        getHelper(PressPageHelper.class).checkBooksShelfArrowsArePresent();
        return this;
    }

    @Override
    public FssDocumentPage clickOnBooksShelfRandomBook() {
        getHelper(PressPageHelper.class).clickOnBooksShelfRandomDisplayedBook();
        return redirectTo(FssDocumentPage.class);
    }
}
