package com.actionmedia.pages.bss;

import com.actionmedia.components.Link;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.components.widgets.*;
import com.actionmedia.components.widgets.recomendation.*;
import com.actionmedia.pages.helpers.SearchResultHelper;
import com.actionmedia.pages.interfaces.IRecomendPage;
import com.actionmedia.util.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class BssRecomendPage extends BssBasePage<BssRecomendPage> implements IRecomendPage {

    @Step("Проеряются элементы на странице 'Рекомендации'")
    public BssRecomendPage checkDefaultStateRecomendPage() {
        checkRecomendTabIsSelected();
        checkSearchBoxIsPresentOnRecomendPage();
        checkYellowPlateIsPresent();
        checkNewsPaperIsPreset();
        checkLawBaseWidgetIsPresent();
        checkFormsWidgetIsPresent();
        checkMagazinesBlockIsPresent();
        checkDictionaryBlockIsPresent();
        checkVideosBlockIsPresent();
        checkFavoritesBlockIsPresent();
        checkAllRecomendButtonIsPresent();
        checkMyFavoritesRubricatorButtonIsPresent();
        return this;
    }

    @Step("Проеряются элементы на странице 'Рекомендации'")
    public BssRecomendPage checkDefaultStateRecomendPageForNotLoggedUser() {
        checkRecomendTabIsSelected();
        checkSearchBoxIsPresentOnRecomendPage();
        checkYellowPlateIsPresent();
        checkNewsPaperIsPreset();
        checkLawBaseWidgetIsPresent();
        checkFormsWidgetIsPresent();
        checkMagazinesBlockIsPresent();
        checkDictionaryBlockIsPresent();
        checkVideosBlockIsPresent();
        checkAllRecomendButtonIsPresent();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Рекомендации'")
    public BssRecomendPage checkRecomendTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.RECOMEND);
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Рекомендации'")
    public BssRecomendPage checkSearchBoxIsPresentOnRecomendPage() {
        checkSearchBoxIsPresent("Поиск рекомендаций");
        return this;
    }

    @Step("Проверяется что желтая плашка отображается")
    public BssRecomendPage checkYellowPlateIsPresent() {
        getHelper(YellowPanel.class).checkWidgetIsPresent();
        return this;
    }

    @Step("Проверяется что газета отображается")
    public BssRecomendPage checkNewsPaperIsPreset() {
        WebElement newsPaper = waitForVisibilityOfElementLocatedBy(By.cssSelector("#sidebar .news"), "Газета не найдена");
        postponedAssertTrue(newsPaper.isEnabled() && newsPaper.isDisplayed(), "Газета не отображается");
        return this;
    }

    @Step("Проверяется что блок Правовая база отображается")
    public BssRecomendPage checkLawBaseWidgetIsPresent() {
        getHelper(LawBaseWidget.class).checkWidgetIsPresent();
        return this;
    }

    public BssRecomendPage checkFormsWidgetIsPresent() {
        getHelper(FormsWidget.class).checkWidgetIsPresent();
        return this;
    }

    public BssRecomendPage checkFormsBlockIsNotEmpty() {
        getHelper(FormsWidget.class).checkWidgetIsNotEmpty();
        return this;
    }


    @Step("Проверяется что блок Журналы и книги отображается")
    public BssRecomendPage checkMagazinesBlockIsPresent() {
        WebElement magazinesBlock = waitForVisibilityOfElementLocatedBy(By.cssSelector(".widget_content_press"), "Блок Журналы и книги не найден");
        postponedAssertTrue(magazinesBlock.isEnabled() && magazinesBlock.isDisplayed(), "Блок Журналы и книги не отображается");
        return this;
    }

    @Step("Проверяется что блок 'Журналы и книги' не пустой")
    public BssRecomendPage checkMagazinesAndBooksBlockIsNotEmpty() {
        WebElement magazinesAdBooksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_press"), "Блок 'Журналы и книги' не найден");
        List<WebElement> magazines = magazinesAdBooksBlock.findElements(By.tagName("li"));
        postponedAssertFalse(magazines.isEmpty(), "Блок 'Журналы и книги' пустой");
        for (WebElement magazine : magazines) {
            WebElement link = findElementByNoThrow(magazine, By.tagName("a"));
            WebElement img = findElementByNoThrow(magazine, By.tagName("img"));
            postponedAssertNotNull(link, "Отсутствует ссылка для журнала");
            postponedAssertNotNull(img, "Отсутствует картинка для журнала");
            if (link != null && img != null) {
                postponedAssertTrue(isImageLoaded(img), "Картинка не загрузилась для " + link.getAttribute("href"));
            }
        }
        return this;
    }

    @Step("Проверяется что блок Справочник отображается")
    public BssRecomendPage checkDictionaryBlockIsPresent() {
        WebElement dictionaryBlock = waitForVisibilityOfElementLocatedBy(By.cssSelector(".widget_content_handbook"), "Блок Справочник не найден");
        postponedAssertTrue(dictionaryBlock.isEnabled() && dictionaryBlock.isDisplayed(), "Блок Справочник не отображается");
        return this;
    }

    public BssRecomendPage checkVideosBlockIsPresent() {
        getHelper(VideoWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Step("Проверяется что блок Мое избранное отображается")
    public BssRecomendPage checkFavoritesBlockIsPresent() {
        WebElement dictionaryBlock = waitForVisibilityOfElementLocatedBy(By.cssSelector(".widget_content_bookmarks"), "Блок Мое избранное не найден");
        postponedAssertTrue(dictionaryBlock.isEnabled() && dictionaryBlock.isDisplayed(), "Блок Мое избранное не отображается");
        return this;
    }

    @Step("Проверяется что кнопка Все рекомендации отображается")
    public BssRecomendPage checkAllRecomendButtonIsPresent() {
        WebElement recomendButton = waitForVisibilityOfElementLocatedBy(By.id("rubricator-btn"), "Кнопка Все рекомендации не найдена");
        postponedAssertTrue(recomendButton.isEnabled() && recomendButton.isDisplayed(), "Кнопка Все рекомендации не найдена");
        postponedAssertEquals(recomendButton.getText(), "Все рекомендации", "Неправильный текст кнопки Все рекомендации не найдена");
        return this;
    }

    @Step("Проверяется отображаение картинок")
    public BssRecomendPage checkAllImagesWereLoaded() {
        List<WebElement> imageList = waitForPresenceOfAllElementsLocatedBy(By.tagName("img"));
        for (WebElement image : imageList) {
            String imgUrl = image.getAttribute("src");
            postponedAssertTrue(isImageLoaded(image), "Картинка с урл '" + imgUrl + "' не загрузилась");
        }
        return this;
    }

    @Step("Проверяется работа ссылок на рубрикаторы из блока Формы")
    public BssRecomendPage checkRubricatorLinksFromFormsBlock() {
        List<WebElement> rubricatorLinkList = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_forms")).findElements(By.cssSelector(".link_type_rubric"));
        postponedAssertFalse(rubricatorLinkList.isEmpty(), "Ссылки на рубрикаторы в блоке Формы не найдены");
        for (WebElement rubricatorLink : rubricatorLinkList) {
            String rubricatorName = rubricatorLink.getText();
            report("Проверяется работа ссылки для '" + rubricatorName + "'");
            if ("Договоры, иски".equals(rubricatorName)) {
                rubricatorName = "Юридические вопросы";
            }
            if ("Кадровые вопросы".equals(rubricatorName)) {
                rubricatorName = "Кадровое дело";
            }
            if ("Финансовые вопросы".equals(rubricatorName)) {
                continue;
            }
            rubricatorLink.click();
            checkSelectedItemInRubricator(rubricatorName);

            String btnName = waitForPresenceOfElementLocatedBy(By.id("rubricator-btn")).getText();
            postponedAssertEquals(btnName, "Все формы", "Название кнопки рубрикатора не изменилось");

            waitForPresenceOfElementLocatedBy(By.id("rubricator-close")).click();
        }
        return this;
    }

    @Step("Проверяется работа ссылок на рубрикаторы из блока Справочник")
    public BssRecomendPage checkRubricatorLinksFromDictionaryBlock() {
        List<WebElement> rubricatorLinkList = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_handbook")).findElements(By.cssSelector(".link_type_rubric"));
        postponedAssertFalse(rubricatorLinkList.isEmpty(), "Ссылки на рубрикаторы в блоке Справочник не найдены");

        String rubricatorName = rubricatorLinkList.get(0).getText();
        report("Проверяется работа ссылки для '" + rubricatorName + "'");
        rubricatorLinkList.get(0).click();

        WebElement rubricator = waitForVisibilityOfElementLocatedBy(By.id("rubricator"), "Рубрикатор для '" + rubricatorName + "' не отображается");
        waitForTextToBePresentIn(rubricator);
        String activeFirstColumnItem = rubricator.findElements(By.cssSelector(".b-rubricator-list")).get(0).findElement(By.cssSelector(".b-link_state_active")).getText();
        postponedAssertEquals(activeFirstColumnItem, "Действующие налоги и взносы", "Выбран неправильный рубрикатор");

        String activeSecondColumnItem = rubricator.findElements(By.cssSelector(".b-rubricator-list")).get(1).findElement(By.cssSelector(".b-link_state_active")).getText();
        postponedAssertEquals(activeSecondColumnItem, "Тарифы взносов", "Выбран неправильный дополнительный рубрикатор");

        String btnName = waitForPresenceOfElementLocatedBy(By.id("rubricator-btn")).getText();
        postponedAssertEquals(btnName, "Весь справочник", "Название кнопки рубрикатора не изменилось");

        waitForPresenceOfElementLocatedBy(By.id("rubricator-close")).click();
        return this;
    }

    @Step("Проверяется работа ссылки для рубрикатора Мое избранное")
    public BssRecomendPage checkRubricatorLinksFromMyFavoritesBlock() {
        WebElement myFavoritesBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_bookmarks"), "Блок 'Мое избранное' не найден");
        WebElement myFavoritesLink = myFavoritesBlock.findElement(By.cssSelector(".widget__title-text"));
        myFavoritesLink.click();
        waitForVisibilityOfElementLocatedBy(By.id("main-bookmarks"), "Рубрикатор Мое избранное не отображается");
        waitForPresenceOfElementLocatedBy(By.id("favorites-btn")).click();
        return this;
    }

    @Step("Проверяется работа ссылки для рубрикатора раздела")
    public BssRecomendPage checkRubricatorLinksForSection() {
        WebElement rubricatorBtn = waitForPresenceOfElementLocatedBy(By.id("rubricator-btn"));
        rubricatorBtn.click();
        waitForVisibilityOfElementLocatedBy(By.id("rubricator"), "Рубрикатор не отображается");
        rubricatorBtn.click();
        return this;
    }

    @Step("Проверяется работа ссылки из желтой плашки")
    public BssRecomendPage checkLinkFromYellowPlate() {
        WebElement yellowPlate = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_note"));
        WebElement recomendLink = yellowPlate.findElement(By.cssSelector(".author-comment__source")).findElement(By.tagName("a"));
        String url = recomendLink.getAttribute("href");
        String header = recomendLink.getText();
        checkLink(new Link(url, header));
        return this;
    }

    @Step("Проверяется работа ссылки из блока Правовая база")
    public BssRecomendPage checkLinkFromLawBaseBlock() {
        getHelper(LawBaseWidget.class).clickLinkTitle();
        return this;
    }

    @Step("Проверяется порядок кодексов в блоке 'Правовая база'")
    public BssRecomendPage checkKodeksOrderInLawBaseBlock(String[] expectedKodeksName) {
        getHelper(LawBaseWidget.class).checkCodes();
        return this;
    }

    @Step("Проверяется порядок кодексов в блоке 'Правовая база'")
    public BssRecomendPage checkKodeksOrderInLawBaseBlock() {
        getHelper(LawBaseWidget.class).checkCodes();
        return this;
    }

    public BssFormsPage clickFormsLink() {
        getHelper(FormsWidget.class).clickOnTitle();
        return redirectTo(BssFormsPage.class);
    }

    @Step("Нажать на ссылку 'Журналы и книги'")
    public BssMagazinesPage clickMagazinesLink() {
        WebElement magazineBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_press"), "Блок 'Журналы и книги' не найден");
        WebElement magazineTitle = magazineBlock.findElement(By.cssSelector(".widget__title"));
        WebElement magazineLink = magazineTitle.findElement(By.tagName("a"));
        magazineLink.click();
        return redirectTo(BssMagazinesPage.class);
    }

    @Step("Нажать на ссылку 'Видео'")
    public BssVideosPage clickVideoLink() {
        WebElement videoBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_videos"), "Блок 'Видео' не найден");
        WebElement videoLink = videoBlock.findElement(By.cssSelector(".widget__title-text"));
        videoLink.click();
        return redirectTo(BssVideosPage.class);
    }

    @Step("Нажать на ссылку 'Справочник'")
    public BssDictionaryPage clickDictionaryLink() {
        WebElement lawBaseBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_handbook"), "Блок 'Справочник' не найден");
        WebElement lawBaseLink = lawBaseBlock.findElement(By.cssSelector(".widget__title-text"));
        lawBaseLink.click();
        return redirectTo(BssDictionaryPage.class);
    }

    @Step("Проверяется работа ссылок из блока Журналы и книги")
    public BssRecomendPage checkLinkFromMagazinesBlock() {
        WebElement magazinesBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_press"));
        List<WebElement> magazines = magazinesBlock.findElements(By.tagName("li"));
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement magazine : magazines) {
            String url = magazine.findElement(By.tagName("a")).getAttribute("href");
            linkList.add(new Link(url));
        }
        checkLinks(linkList);
        return this;
    }

    @Step("Проверяется работа ссылки из блока Справочник")
    public BssRecomendPage checkLinkFromDictionaryBlock() {
        WebElement dictionaryBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_handbook"));
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement linkElement : dictionaryBlock.findElements(By.tagName("a"))) {
            if (linkElement.getAttribute("class") == null || linkElement.getAttribute("class").isEmpty()) {
                String url = linkElement.getAttribute("href");
                String header = linkElement.getText();
                Link link = new Link(url, header);
                linkList.add(link);
            }
        }
        checkLinks(linkList);
        return this;
    }

    @Step("Проверяется работа ссылки из блока Видео")
    public BssRecomendPage checkLinkFromVideoBlock() {
        WebElement videosBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_videos"), "Блок 'Видео' не найден");
        WebElement videoPreview = videosBlock.findElement(By.cssSelector(".video__image"));
        String url = videoPreview.getAttribute("href");
        Link link = new Link(url);
        checkLinks(Arrays.asList(link));
        return this;
    }

    @Step("Проверяется работа ссылок из газеты")
    public BssRecomendPage checkLinksFromNewsPaper() {
        WebElement newsPaper = waitForVisibilityOfElementLocatedBy(By.cssSelector("#sidebar .news"), "Газета не найдена");
        List<WebElement> newsPaperLinkList = getRandomElementsInList(newsPaper.findElements(By.cssSelector(".news__item")), 10);
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement newsPaperLink : newsPaperLinkList) {
            String url = newsPaperLink.findElement(By.tagName("a")).getAttribute("href");
            String header = newsPaperLink.findElement(By.tagName("a")).getText();
            Link link = new Link(url, header);
            linkList.add(link);
        }
        checkLinks(linkList);
        return this;
    }

    @Step("Проверяется работа скролла в газете")
    public BssRecomendPage checkNewsPaperScrolling() {
        WebElement newsPaper = waitForVisibilityOfElementLocatedBy(By.cssSelector("#sidebar .news"), "Газета не найдена");
        List<WebElement> newsBeforeScroll = newsPaper.findElements(By.cssSelector(".news__item"));
        postponedAssertFalse(newsBeforeScroll.isEmpty(), "Отсутсвуют новости в газете");

        scroll(Period.week, By.cssSelector(".news__date"));

        List<WebElement> newsAfterScroll = newsPaper.findElements(By.cssSelector(".news__item"));
        postponedAssertTrue(newsAfterScroll.size() > newsBeforeScroll.size(), "Новости не подгружаются после скролла");
        return this;
    }

    @Step("Проверяется что новости отсортированны по убыванию")
    public BssRecomendPage checkDateAreSortedDescending() {
        WebElement newsPaper = waitForVisibilityOfElementLocatedBy(By.cssSelector("#sidebar .news"), "Газета не найдена");
        List<WebElement> dateListElement = newsPaper.findElements(By.cssSelector(".news__date"));

        postponedAssertThat(dateListElement, TestUtils.sortedDatesWithoutYearInDescendingOrder(), "Элементы отсортированы в неправильном порядке");
        return this;
    }

    @Step("Проверяется что новости не повторяются")
    public BssRecomendPage checkNewsBlockAreNotRepeated() {
        WebElement newsPaper = waitForVisibilityOfElementLocatedBy(By.cssSelector("#sidebar .news"), "Газета не найдена");
        List<WebElement> newsTitleList = newsPaper.findElements(By.cssSelector(".news__item"));
        List<String> newsStringList = new ArrayList<String>();
        for (WebElement newsTitleElement : newsTitleList) {
            String newsTitle = newsTitleElement.findElement(By.cssSelector(".news__item-text")).getText();
            if ("Все новости".equals(newsTitle)) {
                continue;
            }
            postponedAssertFalse(newsStringList.contains(newsTitle), "Новость '" + newsTitle + "' повторяется");
            newsStringList.add(newsTitle);
        }
        return this;
    }

    @Step("Проверяется что пустых новостей нет")
    public BssRecomendPage checkNewsAreNotEmpty() {
        List<WebElement> newsItemList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".news__item"));
        for (WebElement newsItem : newsItemList) {
            postponedAssertFalse(newsItem.getText().isEmpty(), "Пустая новость");
        }
        return this;
    }

    @Step("Проверяется что блок 'Мое избранное' отображается для авторизованного пользователя")
    public BssRecomendPage checkMyFavoritesBlockIsPresent() {
        if (isUserLogged()) {
            WebElement myFavoritesBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_bookmarks"), "Блок 'Мое избранное' не найден");
            postponedAssertTrue(myFavoritesBlock.isEnabled() && myFavoritesBlock.isDisplayed(), "Блок 'Мое избранное' не отображается для авторизованного пользователя");
        }
        return this;
    }

    @Step("Проверяется что меню 'Мое избранное' пустое")
    public BssRecomendPage checkMyFavoritesMenuIsEmpty() {
        WebElement myFavoritesBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_bookmarks"), "Блок 'Мое избранное' не найден");
        WebElement myFavoritesLink = myFavoritesBlock.findElement(By.cssSelector(".widget__title-text"));
        myFavoritesLink.click();

        WebElement myFavoritesMenu = waitForVisibilityOfElementLocatedBy(By.id("main-bookmarks"), "Меню 'Мое избранное' не отображается");
        waitForTextToBePresentIn(myFavoritesMenu, "Избранное");
        postponedAssertNull(findElementByNoThrow(myFavoritesMenu, By.cssSelector(".b-info__title-text")), "Отображаются закладки в пустом меню Мое избранное");
        myFavoritesBlock.click();
        return this;
    }

    @Step("Проверяется блок 'Мое избранное' с добавленными закладками")
    public BssRecomendPage checkIsNotEmptyMyFavoritesBlock() {
        refreshPage();
        WebElement myFavoritesBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_bookmarks"), "Блок 'Мое избранное' не найден");
        waitForTextToBePresentIn(myFavoritesBlock);
        WebElement myFavoritesListElement = myFavoritesBlock.findElement(By.cssSelector(".list"));
        List<WebElement> bookmarks = myFavoritesListElement.findElements(By.tagName("a"));
        postponedAssertFalse(bookmarks.isEmpty(), "Блок 'Мое избранное' пустой");
        for (WebElement bookmark : bookmarks) {
            postponedAssertTrue(bookmark.getAttribute("href") != null && !bookmark.getText().isEmpty(), "Текст ссылки для закладки пустой");
        }
        return this;
    }

    @Step("Проверяется что меню 'Мое избранное' не пустое")
    public BssRecomendPage checkMyFavoritesMenuIsNotEmpty() {
        WebElement myFavoritesBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_bookmarks"), "Блок 'Мое избранное' не найден");
        WebElement myFavoritesLink = myFavoritesBlock.findElement(By.cssSelector(".widget__title-text"));
        myFavoritesLink.click();

        WebElement menuContent = waitForVisibilityOfElementLocatedBy(By.id("my-documents-bookmarks"), "Меню 'Мое избранное' не отображается");
        waitForTextToBePresentIn(menuContent, "Избранное");
        List<WebElement> bookmarks = menuContent.findElements(By.cssSelector(".b-info__title-text"));
        postponedAssertFalse(bookmarks.isEmpty(), "меню 'Мое избранное' пустое");
        for (WebElement bookmark : bookmarks) {
            postponedAssertTrue(bookmark.getAttribute("href") != null && !bookmark.getText().isEmpty(), "Текст ссылки для закладки пустой");
        }
        myFavoritesBlock.click();
        return this;
    }

    @Step("Проверяется работа ссылок в блоке Мое избранное")
    public BssRecomendPage checkLinkInMyFavoritesBlock() {
        WebElement myFavoritesBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_bookmarks"), "Блок 'Мое избранное' не найден");
        WebElement myFavoritesListElement = myFavoritesBlock.findElement(By.cssSelector(".list"));
        List<WebElement> bookmarks = myFavoritesListElement.findElements(By.tagName("li"));
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement bookmark : bookmarks) {
            String url = bookmark.findElement(By.tagName("a")).getAttribute("href");
            String header = bookmark.findElement(By.tagName("a")).getText();
            Link link = new Link(url, header);
            linkList.add(link);
        }
        checkLinks(linkList);
        return this;
    }

    @Step("Проверяется надпись в пустом блоке Мое избранное")
    public BssRecomendPage checkEmptyMyFavoritesBlock() {
        WebElement myFavoritesBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_bookmarks"), "Блок 'Мое избранное' не найден");
        WebElement myFavoritesListElement = myFavoritesBlock.findElement(By.cssSelector(".list"));
        WebElement emptyList = findElementByNoThrow(myFavoritesListElement, By.tagName("li"));
        postponedAssertNotNull(emptyList, "Не найдена надпись 'Вы ещe не добавили ни одного документа' в пустом блоке Мое избранное");
        if (emptyList != null) {
            postponedAssertEquals(emptyList.getText(), "Вы ещё не добавили ни одного документа.", "Неправильная надпись в пустом блоке Мое избранное");
        }
        return this;
    }

    @Step("Проверяется что ссылка 'Мое избранное' открывает меню избранного")
    public BssRecomendPage checkMyFavoritesLinksIsOpenedMyFavoritesMenu() {
        WebElement myFavoritesBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_bookmarks"), "Блок 'Мое избранное' не найден");
        myFavoritesBlock.findElement(By.cssSelector(".widget__title-text")).click();

        WebElement myFavoritesMenu = waitForVisibilityOfElementLocatedBy(By.id("main-bookmarks"), "Меню 'Мое избранное' не отображается");
        waitForTextToBePresentIn(myFavoritesMenu, "Избранное");
        postponedAssertTrue(myFavoritesMenu.isEnabled() && myFavoritesMenu.isDisplayed() && !myFavoritesMenu.getText().isEmpty(), "Меню 'Мое избранное' не отображается");

        myFavoritesBlock.click();
        return this;
    }

    @Step("Открыть страницу газеты")
    public BssNewsPage clickNewsPaperHeaderLink() {
        waitForPresenceOfElementLocatedBy(By.cssSelector(".news .news__title a")).click();
        return redirectTo(BssNewsPage.class);
    }

    @Step("Открыть кодекс из блока Правовая база по имени")
    public BssDocumentPage clickKodeksByName(String kodeksName) {
        WebElement lawBaseBlock = mainContentElement.findElement(By.cssSelector(".widget_content_law"));
        WebElement bookList = lawBaseBlock.findElement(By.cssSelector(".list"));
        List<WebElement> kodeksList = bookList.findElements(By.cssSelector(".list__item"));
        for (WebElement kodeks : kodeksList) {
            WebElement kodeksLink = kodeks.findElement(By.tagName("a"));
            if (kodeksLink.getAttribute("title").equals(kodeksName)) {
                kodeksLink.click();
                report("Открывается " + kodeksName);
                return redirectTo(BssDocumentPage.class);
            }
        }
        fail(kodeksName + " не найден в блоке Правовая база");
        return redirectTo(BssDocumentPage.class);
    }

    @Step("Открыть документ с желтой плашки")
    public BssDocumentPage clickLinkFromYellowPlate() {
        WebElement yellowPlate = mainContentElement.findElement(By.cssSelector(".author-comment__source"));
        WebElement link = yellowPlate.findElement(By.cssSelector("[href*='/#/document']"));
        link.click();
        return redirectTo(BssDocumentPage.class);
    }

    public BssRecomendPage checkLawBaseWidgetTitleIsPresent() {
        getHelper(LawBaseWidget.class).checkTitleIsPresent();
        return this;
    }

    public BssRecomendPage checkLawBaseWidgetSearchInputIsPresent() {
        getHelper(LawBaseWidget.class).checkSearchInputIsPresent();
        return this;
    }

    public BssRecomendPage checkLawBaseWidgetNewDocumentCounterIsPresent() {
        getHelper(LawBaseWidget.class).checkNewDocumentCounterIsPresent();
        return this;
    }

    public BssRecomendPage checkLawBaseWidgetLinksCodes() {
        getHelper(LawBaseWidget.class).checkLinksCodes();
        return this;
    }

    public BssLawBasePage clickLawBaseWidgetLinkTitle() {
        getHelper(LawBaseWidget.class).clickLinkTitle();
        return redirectTo(BssLawBasePage.class);
    }

    public BssLawBasePage clickLawBaseWidgetLinkNewDocumentCounter() {
        getHelper(LawBaseWidget.class).clickLinkNewDocumentCounter();
        return redirectTo(BssLawBasePage.class);
    }

    public BssLawBasePage clickLawBaseWidgetLinkEnterIconOntoSearchInput() {
        getHelper(LawBaseWidget.class).clickLinkEnterIconOnSearchInput();
        return redirectTo(BssLawBasePage.class);
    }

    public BssRecomendPage inputLawBaseWidgetInSearch(String query) {
        getHelper(LawBaseWidget.class).inputInSearch(query);
        return this;
    }

    public BssRecomendPage checkLawBaseWidgetSearchResultsArePresent() {
        getHelper(LawBaseWidget.class).checkSearchResultsArePresent();
        return this;
    }

    public BssDocumentPage clickLawBaseWidgetOnSearchResultsDirectDocument() {
        getHelper(LawBaseWidget.class).clickOnSearchResultsDirectDocument();
        return redirectTo(BssDocumentPage.class);
    }

    public BssSearchResultPage clickLawBaseWidgetSearchResultsRandomHintLink() {
        getHelper(LawBaseWidget.class).clickSearchResultsRandomHintLink();
        return redirectTo(BssSearchResultPage.class);
    }

    public BssSearchResultPage clickLawBaseWidgetIconEnterWithSearchQuery() {
        getHelper(LawBaseWidget.class).clickLinkEnterIconOnSearchInput();
        return redirectTo(BssSearchResultPage.class);
    }

    public BssRecomendPage checkFormsWidgetTitleIsPresent() {
        getHelper(FormsWidget.class).checkTitleIsPresent();
        return this;
    }

    public BssRecomendPage checkFormsWidgetSearchInputIsPresent() {
        getHelper(FormsWidget.class).checkSearchInputIsPresent();
        return this;
    }

    public BssRecomendPage checkFormsWidgetNewDocumentCounterIsPresent() {
        getHelper(FormsWidget.class).checkNewDocumentCounterIsPresent();
        return this;
    }

    public BssFormsPage clickFormsWidgetLinkNewDocumentCounter() {
        getHelper(FormsWidget.class).clickLinkNewDocumentCounter();
        return redirectTo(BssFormsPage.class);
    }

    public BssFormsPage clickFormsWidgetLinkEnterIconOntoSearchInput() {
        getHelper(FormsWidget.class).clickLinkEnterIconOnSearchInput();
        return redirectTo(BssFormsPage.class);
    }

    public BssRecomendPage inputFormsWidgetInSearch(String query) {
        getHelper(FormsWidget.class).inputInSearch(query);
        return this;
    }

    public BssRecomendPage checkFormsWidgetSearchResultsArePresent() {
        getHelper(FormsWidget.class).checkSearchResultsArePresent();
        return this;
    }

    public BssDocumentPage clickFormsWidgetOnSearchResultsDirectDocument() {
        getHelper(FormsWidget.class).clickOnSearchResultsDirectDocument();
        return redirectTo(BssDocumentPage.class);
    }

    public BssSearchResultPage clickFormsWidgetSearchResultsRandomHintLink() {
        getHelper(FormsWidget.class).clickSearchResultsRandomHintLink();
        return redirectTo(BssSearchResultPage.class);
    }

    public BssSearchResultPage clickFormsWidgetIconEnterWithSearchQuery() {
        getHelper(FormsWidget.class).clickLinkEnterIconOnSearchInput();
        return redirectTo(BssSearchResultPage.class);
    }

    public BssRecomendPage checkFormsWidgetExamplesFormsIsPresent() {
        getHelper(FormsWidget.class).checkExamplesFormsIsPresent();
        return this;
    }

    public BssDocumentPage clickFormsWidgetRedLink() {
        getHelper(FormsWidget.class).clickOnRedLink();
        return redirectTo(BssDocumentPage.class);
    }

    public BssDocumentPage clickFormsWidgetGreenLink() {
        getHelper(FormsWidget.class).clickOnGreenLink();
        return redirectTo(BssDocumentPage.class);
    }

    public BssDocumentPage clickFormsWidgetBlueLink() {
        getHelper(FormsWidget.class).clickOnBlueLink();
        return redirectTo(BssDocumentPage.class);
    }

    public BssDocumentPage clickFormsWidgetYellowLink() {
        getHelper(FormsWidget.class).clickOnYellowLink();
        return redirectTo(BssDocumentPage.class);
    }

    public BssRecomendPage checkVideoWidgetIsPresent() {
        getHelper(VideoWidget.class).checkWidgetIsPresent();
        return this;
    }

    public BssRecomendPage checkReportsWidgetIsPresent() {
        getHelper(ReportsWidget.class).checkWidgetIsPresent();
        return this;
    }

    public BssRecomendPage checkVideoWidgetScreenshotIsPresent() {
        getHelper(VideoWidget.class).checkScreenshotIsPresent();
        return this;
    }

    public BssRecomendPage checkVideoWidgetLink() {
        getHelper(VideoWidget.class).checkLink();
        return this;
    }

    public BssRecomendPage checkVideoWidgetVideoDuration() {
        getHelper(VideoWidget.class).checkVideoDuration();
        return this;
    }

    public BssDocumentPage clickOnVideoWidgetScreenshot() {
        getHelper(VideoWidget.class).clickOnScreenshot();
        return redirectTo(BssDocumentPage.class);
    }

    public BssDocumentPage clickOnVideoWidgetLink() {
        getHelper(VideoWidget.class).clickOnLink();
        return redirectTo(BssDocumentPage.class);
    }

    @Override
    public BssRecomendPage checkLawBaseBlockIsPresent() {
        WebElement lawBaseBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_law"), "Блок 'Правовая база' не найден");
        postponedAssertTrue(lawBaseBlock.isEnabled() && lawBaseBlock.isDisplayed(), "Блок 'Правовая база' не отображается");
        return this;
    }

    public BssRecomendPage checkVideoWidgetHasNoTitle() {
        getHelper(VideoWidget.class).checkHasNoTitle();
        return this;
    }

    public BssRecomendPage checkMagazinesWidgetIsPresent() {
        getHelper(MagazinesWidget.class).checkWidgetIsPresent();
        return this;
    }

    public BssRecomendPage checkMagazinesWidgetTitleIsPresent() {
        getHelper(MagazinesWidget.class).checkTitleIsPresent();
        return this;
    }

    public BssRecomendPage checkMagazinesWidgetMagazinesCoversIsPresent() {
        getHelper(MagazinesWidget.class).checkMagazinesCoversIsPresent();
        return this;
    }

    public BssRecomendPage checkMagazinesWidgetMagazinesAreNotRepeated() {
        getHelper(MagazinesWidget.class).checkMagazinesAreNotRepeated();
        return this;
    }

    public BssRecomendPage checkMagazinesWidgetRedMarkerIsPresent() {
        getHelper(MagazinesWidget.class).checkRedMarkerForNewMagazine();
        return this;
    }

    public BssRecomendPage checkMagazinesWidgetTextNewMagazineIsPresent() {
        getHelper(MagazinesWidget.class).checkTextNewMagazineIsPresent();
        return this;
    }

    public BssMagazinesPage clickOnMagazinesWidgetTitle() {
        getHelper(MagazinesWidget.class).clickOnTitle();
        return redirectTo(BssMagazinesPage.class);
    }

    public BssDocumentPage clickOnMagazinesWidgetNotice() {
        getHelper(MagazinesWidget.class).clickOnNotice();
        return redirectTo(BssDocumentPage.class);
    }

    public BssRecomendPage checkMagazinesWidgetMagazinesLinks() {
        getHelper(MagazinesWidget.class).checkMagazinesLinks();
        return this;
    }

    public BssRecomendPage checkMagazinesWidgetMagazinesCoversWithVariantResolutions() {
        getHelper(MagazinesWidget.class).checkMagazinesCoversWithVariantResolutions();
        return this;
    }

    public BssRecomendPage checkHandbookWidgetIsPresent() {
        getHelper(HandbookWidget.class).checkWidgetIsPresent();
        return this;
    }

    public BssRecomendPage checkSeminarsWidgetIsPresent() {
        getHelper(SeminarsWidget.class).checkWidgetIsPresent();
        return this;
    }

    public BssRecomendPage checkHandbookWidgetTitleIsPresent() {
        getHelper(HandbookWidget.class).checkTitleIsPresent();
        return this;
    }

    public BssRecomendPage checkHandbookWidgetDocumentCountIsPresent() {
        getHelper(HandbookWidget.class).checkDocumentCountIsPresent();
        return this;
    }

    public BssRecomendPage checkHandbookWidgetDateTodayIsPresent() {
        getHelper(HandbookWidget.class).checkDateTodayIsPresent();
        return this;
    }

    public BssRecomendPage checkHandbookWidgetMonthNowIsPresent() {
        getHelper(HandbookWidget.class).checkMonthNowIsPresent();
        return this;
    }

    public BssRecomendPage checkHandbookWidgetWorkingDaysElementIsPresent() {
        getHelper(HandbookWidget.class).checkWorkingDaysElementIsPresent();
        return this;
    }

    public BssRecomendPage checkHandbookWidgetHolidaysElementIsPresent() {
        getHelper(HandbookWidget.class).checkHolidaysElementIsPresent();
        return this;
    }

    public BssRecomendPage checkHandbookWidgetExchangeRatesTitleIsPresent() {
        getHelper(HandbookWidget.class).checkExchangeRatesTitleIsPresent();
        return this;
    }

    public BssRecomendPage checkHandbookWidgetDollarRateIsPresent() {
        getHelper(HandbookWidget.class).checkDollarRateIsPresent();
        return this;
    }

    public BssRecomendPage checkHandbookWidgetEuroRateIsPresent() {
        getHelper(HandbookWidget.class).checkEuroRateIsPresent();
        return this;
    }

    public BssRecomendPage checkHandbookWidgetMinimunWageTitleIsPresent() {
        getHelper(HandbookWidget.class).checkMinimunWageTitleIsPresent();
        return this;
    }

    public BssRecomendPage checkHandbookWidgetWageIsPresent() {
        getHelper(HandbookWidget.class).checkWageIsPresent();
        return this;
    }

    public BssRecomendPage checkHandbookWidgetLinkInRegionIsPresent() {
        getHelper(HandbookWidget.class).checkLinkInRegionIsPresent();
        return this;
    }

    public BssRecomendPage checkHandbookWidgetLinkRubricIsPresent() {
        getHelper(HandbookWidget.class).checkLinkRubricIsPresent();
        return this;
    }

    public BssRecomendPage checkHandbookWidgetChangesIsPresent() {
        getHelper(HandbookWidget.class).checkLinkChangesIsPresent();
        return this;
    }

    public BssDictionaryPage clickOnHandbookWidgetTitle() {
        getHelper(HandbookWidget.class).clickOnTitle();
        return redirectTo(BssDictionaryPage.class);
    }

    public BssDocumentPage clickOnHandbookWidgetCalendar() {
        getHelper(HandbookWidget.class).clickOnCalendar();
        return redirectTo(BssDocumentPage.class);
    }

    public BssDocumentPage clickOnHandbookWidgetExchangeRatesBlock() {
        getHelper(HandbookWidget.class).clickOnExchangeRatesBlock();
        return redirectTo(BssDocumentPage.class);
    }

    public BssDocumentPage clickOnHandbookWidgetRubricLink() {
        getHelper(HandbookWidget.class).clickOnRubricLink();
        return redirectTo(BssDocumentPage.class);
    }

    public BssDocumentPage clickOnHandbookWidgetChangesLink() {
        getHelper(HandbookWidget.class).clickOnChangesLink();
        return redirectTo(BssDocumentPage.class);
    }

    public BssDocumentPage clickOnHandbookWidgetInRegionLink() {
        getHelper(HandbookWidget.class).clickOnInRegionLink();
        return redirectTo(BssDocumentPage.class);
    }

    @Step("Добавить ссылки в избранное")
    public BssRecomendPage addLinksToFavorites(String[][] documents) {
        try {
            TestUtils.addDocumentsToFavorites(documents, getDriver());
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Не удалось добавить ссылки в избранное" + e.getMessage());
        } catch (IOException e) {
            throw new IllegalStateException("Не удалось добавить ссылки в избранное" + e.getMessage());
        }
        return this;
    }

    @Step("Удалить ссылки из избранного")
    public BssRecomendPage removeDocumentsFromFavorites() {
        try {
            TestUtils.removeDocumentsFromFavorites(getDriver());
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Не удалось добавить ссылки в избранное" + e.getMessage());
        } catch (IOException e) {
            throw new IllegalStateException("Не удалось добавить ссылки в избранное" + e.getMessage());
        }
        return this;
    }

    public BssRecomendPage checkFavoritesWidgetIsPresent() {
        getHelper(FavoritesWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public BssRecomendPage checkWorkingDaysWidgetIsPresent() {
        getHelper(WorkingDaysWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public BssRecomendPage checkWeekendDaysWidgetIsPresent() {
        getHelper(WeekendDaysWidget.class).checkWidgetIsPresent();
        return this;
    }

    public BssRecomendPage checkFavoritesWidgetIsNotPresent() {
        getHelper(FavoritesWidget.class).checkWidgetIsNotPresent();
        return this;
    }

    public BssRecomendPage checkFavoritesWidgetTitleIsPresent() {
        getHelper(FavoritesWidget.class).checkTitleIsPresent();
        return this;
    }

    public BssRecomendPage checkFavoritesWidgetTextFadeIsPresent() {
        getHelper(FavoritesWidget.class).checkTextFadeIsPresent();
        return this;
    }

    public BssRecomendPage checkFavoritesWidgetFiveLinksArePresent() {
        getHelper(FavoritesWidget.class).checkFiveLinksArePresent();
        return this;
    }

    public BssDocumentPage clickOnFavoritesWidgetFirstDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnFirstDocumentLink();
        return redirectTo(BssDocumentPage.class);
    }

    public BssDocumentPage clickOnFavoritesWidgetSecondDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnSecondDocumentLink();
        return redirectTo(BssDocumentPage.class);
    }

    public BssDocumentPage clickOnFavoritesWidgetThirdDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnThirdDocumentLink();
        return redirectTo(BssDocumentPage.class);
    }

    public BssDocumentPage clickOnFavoritesWidgetFourthDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnFourthDocumentLink();
        return redirectTo(BssDocumentPage.class);
    }

    public BssDocumentPage clickOnFavoritesWidgetFifthDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnFifthDocumentLink();
        return redirectTo(BssDocumentPage.class);
    }

    public BssRecomendPage clickOnFavoritesWidgetTitleLink() {
        getHelper(FavoritesWidget.class).clickOnFavoritesTitleLink();
        return this;
    }

    public BssRecomendPage checkYellowPanelIsPresent() {
        getHelper(YellowPanel.class).checkWidgetIsPresent();
        return this;
    }

    public BssRecomendPage checkSchoolWidgetIsPresent() {
        getHelper(SchoolWidget.class).checkWidgetIsPresent();
        return this;
    }

    public BssRecomendPage checkSchoolWidgetIsNotPresent() {
        getHelper(SchoolWidget.class).checkWidgetIsNotPresent();
        return this;
    }

    public BssRecomendPage checkYellowPanelSearchInputIsPresent() {
        getHelper(YellowPanel.class).checkSearchInputIsPresent();
        return this;
    }

    public BssRecomendPage checkYellowPanelSearchInputPlaceholderTextIsPresent() {
        getHelper(YellowPanel.class).checkSearchInputPlaceholderTextIsPresent();
        return this;
    }

    public BssRecomendPage checkYellowPanelTipIsPresent() {
        getHelper(YellowPanel.class).checkTipIsPresent();
        return this;
    }

    public BssRecomendPage checkYellowPanelAuthorsPhotoIsPresent() {
        getHelper(YellowPanel.class).checkAuthorsPhotoIsPresent();
        return this;
    }

    public BssRecomendPage checkYellowPanelTipQueryIsPresent() {
        getHelper(YellowPanel.class).checkTipQueryIsPresent();
        return this;
    }

    public BssRecomendPage checkYellowPanelAuthorsFullNameIsPresent() {
        getHelper(YellowPanel.class).checkAuthorsFullNameIsPresent();
        return this;
    }

    public BssRecomendPage checkYellowPanelAuthorsPositionIsPresent() {
        getHelper(YellowPanel.class).checkAuthorsPositionIsPresent();
        return this;
    }

    public BssRecomendPage checkYellowPanelAnswerIsPresent() {
        getHelper(YellowPanel.class).checkAnswerIsPresent();
        return this;
    }

    public BssRecomendPage checkYellowPanelLinkFromRecomendationIsPresent() {
        getHelper(YellowPanel.class).checkLinkFromRecomendationIsPresent();
        return this;
    }

    public BssRecomendPage checkYellowPanelRubricatorLinksArePresent() {
        getHelper(YellowPanel.class).checkRubricatorLinksArePresent();
        return this;
    }

    public BssDocumentPage clickOnYellowPanelLinkFromRecomendation() {
        getHelper(YellowPanel.class).clickOnLinkFromRecomendation();
        return redirectTo(BssDocumentPage.class);
    }

    public BssRecomendPage checkBannerIsPresent() {
        getHelper(BannerBlock.class).checkWidgetIsPresent();
        return this;
    }

    public BssRecomendPage clickOnBanner() {
        getHelper(BannerBlock.class).clickOnBanner();
        return this;
    }

    public BssRecomendPage checkDocumentAfterClickingOnBanner() {
        String documentUrl = String.valueOf(getParameter(SearchResultHelper.DOCUMENT_URL));
        postponedAssertTrue(getDriver().getCurrentUrl().contains(documentUrl), "URL не совпадают, actual:" +
                getDriver().getCurrentUrl() + " expected:" + documentUrl);
        return this;
    }

    public BssRecomendPage checkBannerTextWithScreenResolution1024px() {
        getHelper(BannerBlock.class).checkBannerTextWithScreenResolution1024px();
        return this;
    }

    public BssRecomendPage checkBannerTextWithScreenResolution1280px() {
        getHelper(BannerBlock.class).checkBannerTextWithScreenResolution1280px();
        return this;
    }

    public BssRecomendPage checkBannerTextWithScreenResolution1366px() {
        getHelper(BannerBlock.class).checkBannerTextWithScreenResolution1366px();
        return this;
    }

    @Override
    public BssRecomendPage checkFormsBlockIsPresent() {
        WebElement formsBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_forms"), "Блок 'Формы' не найден");
        postponedAssertTrue(formsBlock.isEnabled() && formsBlock.isDisplayed(), "Блок 'Формы' не отображается");
        return this;
    }

    public BssRecomendPage checkNewsBlockIsPresent() {
        getHelper(NewsBlock.class).checkWidgetIsPresent();
        return this;
    }

    public BssRecomendPage checkNewsBlockFirstBlockTitleIsPresent() {
        getHelper(NewsBlock.class).checkFirstBlockTitleIsPresent();
        return this;
    }

    public BssRecomendPage checkNewsBlockNewsArePresent() {
        getHelper(NewsBlock.class).checkNewsArePresent();
        return this;
    }

    public BssRecomendPage checkNewsBlockTodayTitleIsPresent() {
        getHelper(NewsBlock.class).checkTodayTitleIsPresent();
        return this;
    }

    public BssRecomendPage checkNewsBlockOnTheWeekTitleIsPresent() {
        getHelper(NewsBlock.class).checkOnTheWeekTitleIsPresent();
        return this;
    }

    public BssRecomendPage checkNewsBlockPerMonthTitleIsPresent() {
        getHelper(NewsBlock.class).checkPerMonthTitleIsPresent();
        return this;
    }

    public BssRecomendPage checkNewsBlockRecomendationNewsView() {
        getHelper(NewsBlock.class).checkRecomendationNewsView();
        return this;
    }

    public BssRecomendPage checkNewsBlockNewsWithTypeArePresent() {
        getHelper(NewsBlock.class).checkNewsWithTypeArePresent();
        return this;
    }

    public BssRecomendPage checkNewsBlockLinksAllNewsArePresent() {
        getHelper(NewsBlock.class).checkLinksAllNewsArePresent();
        return this;
    }

    public BssRecomendPage checkNewsBlockNewsLinks() {
        boolean hasNext = getHelper(NewsBlock.class).clickOnNewsLink();
        while (hasNext) {
            String documentUrl = String.valueOf(getParameter(SearchResultHelper.DOCUMENT_URL));
            postponedAssertTrue(getDriver().getCurrentUrl().contains(documentUrl) || documentUrl.contains(getDriver().getCurrentUrl()), "Ссылка на документ не совпадает:" +
                    getDriver().getCurrentUrl() + " " + documentUrl);
            returnToBack();
            hasNext = getHelper(NewsBlock.class).clickOnNewsLink();
        }
        return this;
    }

    public BssNewsPage clickOnNewsBlockFirstBlockTitle() {
        getHelper(NewsBlock.class).clickOnFirstBlockTitle();
        return redirectTo(BssNewsPage.class);
    }

    public BssNewsPage clickOnNewsBlockLinkAllNewsInFirstBlock() {
        getHelper(NewsBlock.class).clickOnLinkAllNewsInFirstBlock();
        return redirectTo(BssNewsPage.class);
    }

    public BssNewsPage clickOnNewsBlockLinkAllNewsInSecondBlock() {
        getHelper(NewsBlock.class).clickOnLinkAllNewsInSecondBlock();
        return redirectTo(BssNewsPage.class);
    }

    public BssRecomendPage clearAllBookmarks() {
        removeAllBookmarksFromMenu();
        return this;
    }

    @Override
    @Step("Проверяется что ссылка 'Написать Эксперту' не отображается")
    public BssRecomendPage checkHotLineLinkIsNotPresent() {
        postponedAssertNull(findElementByNoThrow(By.className("[href*='/#/hotline/']")), "Ссылка 'Написать Эксперту' отображается");
        return this;
    }
}
