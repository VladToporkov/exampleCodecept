package com.actionmedia.pages.fss;

import com.actionmedia.autotest.selenium.context.ComponentProvider;
import com.actionmedia.components.Link;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.RightPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 05.11.13
 * Time: 10:53
 */
@Component
public class FssVideosPage extends FssBasePage<FssVideosPage> implements ComponentProvider {

    private RightPanel rightPanel;

    @Override
    public void handleRedirect() {
        super.handleRedirect();
        rightPanel = getHelper(RightPanel.class, this);
    }

    @Step("Проверяется что открыта страница 'Видео'")
    public FssVideosPage checkVideosPageIsOpened() {
        checkVideosTabIsSelected();
        checkSearchBoxPresentOnVideoPage();
        checkHeaderDefaultState();
        checkNewsBlockIsPresent();
        checkNewsBlockIsNotEmpty();
        checkRubricatorMenuIsPresent();
        checkRubricatorMenuIsNotEmpty();
        checkPopularBlockIsPresent();
        checkPopularBlockIsNotEmpty();
        return this;
    }

    @Step("Проверяются элементы на странице 'Видео'")
    public FssVideosPage checkDefaultStateVideosPage() {
        checkVideosTabIsSelected();
        checkSearchBoxPresentOnVideoPage();
        checkHeaderDefaultState();
        checkNewsBlockIsPresent();
        checkNewsBlockIsNotEmpty();
        checkRubricatorMenuIsPresent();
        checkRubricatorMenuIsNotEmpty();
        checkPopularBlockIsPresent();
        checkPopularBlockIsNotEmpty();
        checkFirstVideoTitle();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Видео'")
    public FssVideosPage checkVideosTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.FSS_VIDEO);
        return this;
    }

    @Step("Проверяется заголовок страницы 'Видео'")
    public FssVideosPage checkHeaderDefaultState() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement header = findElementByNoThrow(content, By.cssSelector(".doc-header"));
        assertNotNull(header, "Заголовок страницы 'Видео' не найден");
        postponedAssertTrue(header.isDisplayed(), "Заголовок страницы 'Видео' не отображается");
        postponedAssertEquals(header.findElement(By.tagName("h1")).getText().trim(), "НОВЫЕ ВИДЕО", "Неправильный текст заголовка страницы 'Видео'");
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Видео'")
    public FssVideosPage checkSearchBoxPresentOnVideoPage() {
        checkSearchBoxIsPresent("Поиск видео");
        return this;
    }

    @Step("Проверяется что блок Новое на странице 'Видео' отображается")
    public FssVideosPage checkNewsBlockIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement newsBlock = findElementByNoThrow(content, By.id("main-article"));
        assertNotNull(newsBlock, "Блок Новое на странице 'Видео' не найден");
        postponedAssertTrue(newsBlock.isDisplayed(), "Блок Новое на странице 'Видео' не отображается");
        return this;
    }

    @Step("Проверяется что блок Новое на странице 'Видео' не пустой")
    public FssVideosPage checkNewsBlockIsNotEmpty() {
        WebElement newsBlock = waitForVisibilityOfElementLocatedBy(By.id("main-article"));
        List<WebElement> newsItemList = newsBlock.findElements(By.cssSelector(".b-news"));
        postponedAssertFalse(newsItemList.isEmpty(), "Блок Новое на странице 'Видео' пустой");
        return this;
    }

    @Step("Проверяется что меню Рубрикатора на странице 'Видео' отображается")
    public FssVideosPage checkRubricatorMenuIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement rubricatorMenu = findElementByNoThrow(content, By.id("sidebar"));
        assertNotNull(rubricatorMenu, "Меню Рубрикатора на странице 'Видео' не найдено");
        postponedAssertTrue(rubricatorMenu.isDisplayed(), "Меню Рубрикатора на странице 'Видео' не отображается");
        return this;
    }

    @Step("Проверяется что меню Рубрикатора на странице 'Видео' не пустое")
    public FssVideosPage checkRubricatorMenuIsNotEmpty() {
        List<WebElement> newsItemList = sidebarElement.findElements(By.tagName("li"));
        postponedAssertFalse(newsItemList.isEmpty(), "Меню Рубрикатора на странице 'Видео' пустое");
        return this;
    }

    @Step("Проверяется что правая панель на странице 'Видео' отображается")
    public FssVideosPage checkPopularBlockIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement rubricatorMenu = findElementByNoThrow(content, By.id("aside"));
        assertNotNull(rubricatorMenu, "Правая панель на странице 'Видео' не найдена");
        postponedAssertTrue(rubricatorMenu.isDisplayed(), "Правая панель на странице 'Видео' не отображается");
        return this;
    }

    @Step("Проверяется что правая панель на странице 'Видео' не пустая")
    public FssVideosPage checkPopularBlockIsNotEmpty() {
        WebElement newsBlock = getCollapsedRightPanel();
        List<WebElement> newsItemList = newsBlock.findElements(By.cssSelector(".go"));
        postponedAssertFalse(newsItemList.isEmpty(), "Правая панель на странице 'Видео' пустая");
        return this;
    }

    @Step("Проверяется заголовок для верхнего документа")
    public FssVideosPage checkFirstVideoTitle() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".doc-header"));
        WebElement firstVideoBlock = content.findElement(By.cssSelector(".b-news"));
        String fontSizeString = firstVideoBlock.findElement(By.cssSelector(".white")).getCssValue("font-size").split("px")[0];
        double actualFontSize = Double.parseDouble(fontSizeString);
        double expectedFontSize = 22.5;
        postponedAssertTrue(actualFontSize == expectedFontSize ||
                actualFontSize < expectedFontSize + 1 ||
                actualFontSize > expectedFontSize - 1, "Неправильный размер шрифта для первого документа." +
                " Ожидаемый: " + expectedFontSize +
                " Наблюдаемый: " + actualFontSize);
        return this;
    }

    @Step("Проверяется что кнопка Презентация отображается для первого видео")
    public FssVideosPage checkPresentationLinkIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".doc-header"));
        WebElement firstVideoBlock = content.findElement(By.cssSelector(".b-news"));

        WebElement materials = findElementByNoThrow(firstVideoBlock, By.cssSelector(".materials"));
        assertNotNull(materials, "Блок материалы не найден");
        postponedAssertTrue(materials.isDisplayed(), "Блок материалы не отображается");
        WebElement presentationLink = findElementByNoThrow(materials, By.cssSelector(".go"));
        assertNotNull(presentationLink, "Кнопка Презентация не найдена");
        postponedAssertTrue(presentationLink.isDisplayed(), "Кнопка Презентация не отображается");
        return this;
    }

    @Step("Проверяется что темы видео отображаются")
    public FssVideosPage checkThemesIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".doc-header"));
        WebElement firstVideoBlock = content.findElement(By.cssSelector(".b-news"));

        WebElement themes = findElementByNoThrow(firstVideoBlock, By.cssSelector(".themes"));
        assertNotNull(themes, "Темы видео не найдены");
        postponedAssertTrue(themes.isDisplayed(), "Темы видео не отображаются");
        List<WebElement> themesList = themes.findElements(By.tagName("li"));
        postponedAssertFalse(themesList.isEmpty(), "Список тем видео пустой");
        return this;
    }

    @Step("Проверяется что кнопка показать/скрыть все темы видео отображается")
    public FssVideosPage checkHideButtonIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".doc-header"));
        WebElement firstVideoBlock = content.findElement(By.cssSelector(".b-news"));
        WebElement hideButton = findElementByNoThrow(firstVideoBlock, By.cssSelector(".switch"));
        assertNotNull(hideButton, "Кнопка показать/скрыть все темы видео не найдена");
        postponedAssertTrue(hideButton.isDisplayed(), "Кнопка показать/скрыть все темы видео не отображается");
        return this;
    }

    @Step("Проверятся что не все темы видео отображаются")
    public FssVideosPage checkNotAllThemesIsDisplayed() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".doc-header"));
        WebElement firstVideoBlock = content.findElement(By.cssSelector(".b-news"));
        WebElement themes = firstVideoBlock.findElement(By.cssSelector(".themes"));
        List<WebElement> themesList = themes.findElements(By.tagName("li"));
        for (int i = 4; i < themesList.size(); i++) {
            postponedAssertFalse(themesList.get(i).isDisplayed(), "Тема видео '" + themesList.get(i).getText() + "' отображается");
        }
        return this;
    }

    @Step("Проверятся что все темы видео отображаются")
    public FssVideosPage checkAllThemesIsDisplayed() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".doc-header"));
        WebElement firstVideoBlock = content.findElement(By.cssSelector(".b-news"));
        WebElement themes = firstVideoBlock.findElement(By.cssSelector(".themes"));
        List<WebElement> themesList = themes.findElements(By.tagName("li"));
        for (WebElement theme : themesList) {
            postponedAssertTrue(theme.isDisplayed(), "Тема видео '" + theme.getText() + "' не отображается");
        }
        return this;
    }

    public FssVideosPage checkLinksFromNewsBlock() {
        getHelper(FssHelpers.class).checkLinksFromNewsBlock();
        return this;
    }

    public FssVideosPage checkNewsBlockScrolling() {
        getHelper(FssHelpers.class).checkNewsBlockScrolling(Period.threeMonth);
        return this;
    }

    public FssVideosPage checkDateAreSortedDescending() {
        getHelper(FssHelpers.class).checkDateAreSortedDescending();
        return this;
    }

    public FssVideosPage checkNewsBlockAreNotRepeat() {
        getHelper(FssHelpers.class).checkNewsBlockAreNotRepeat();
        return this;
    }

    public FssVideosPage checkNewsAreNotEmpty() {
        getHelper(FssHelpers.class).checkNewsAreNotEmpty();
        return this;
    }

    public FssVideosPage clickExtendPopularBlock() {
        getHelper(FssHelpers.class).clickExtendPopularBlock();
        return this;
    }

    @Step("Открыть раздел Популярное в правой панели")
    public FssVideosPage clickPopularTab() {
        rightPanel.clickPopularTabInExpanded();
        return this;
    }

    @Step("Открыть раздел Просмотренное в правой панели")
    public FssVideosPage clickViewedTab() {
        rightPanel.clickViewedTabInExpanded();
        return this;
    }

    @Step("Закрыть правую панель")
    public FssVideosPage closePopularBlock() {
        rightPanel.closePopularBlock();
        return this;
    }

    @Step("Проверяется работа ссылок из раздела Просмотренное в правой панели")
    public FssVideosPage checkRandomLinksFromExpandedViewedBlock() {
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
    public FssVideosPage checkRandomLinksFromExpandedPopularBlock() {
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
    public FssVideosPage checkFiltersInRightPanel() {
        clickExtendPopularBlock();
        clickViewedTab();
        rightPanel.checkDateFilters();
        return this;
    }

    @Step("Показать все темы видео")
    public FssVideosPage clickHideButton() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".doc-header"));
        WebElement hideButton = content.findElement(By.cssSelector(".b-news")).findElement(By.cssSelector(".switch"));
        hideButton.click();
        return this;
    }

    public FssVideosPage checkCollapsedRightPanel() {
        getHelper(FssHelpers.class).checkCollapsedRightPanel(rightPanel);
        return this;
    }

    public FssVideosPage checkExpandedRightPanel() {
        getHelper(FssHelpers.class).checkExpandedRightPanel(rightPanel);
        return this;
    }

    public FssVideosPage checkRandomLinksFromCollapsedPopularTab() {
        getHelper(FssHelpers.class).checkRandomLinksFromCollapsedPopularTab(rightPanel);
        return this;
    }

    public FssVideosPage checkRandomLinksFromCollapsedViewedTab() {
        getHelper(FssHelpers.class).checkRandomLinksFromCollapsedViewedTab(rightPanel);
        return this;
    }

    @Step("Проверяется наличие большого превью")
    public FssVideosPage checkNewVideoBlock() {
        WebElement newVideoBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".video-big-pic"), "Не найдена большая картинка");
        postponedAssertNotNull(newVideoBlock, "Блок 'Новое видео' не найден");
        return this;
    }

    @Step("Проверяется наличие названия видео и ссылка на него")
    public FssVideosPage checkNewVideoName() {
        WebElement newVideoName = waitForPresenceOfElementLocatedBy(By.cssSelector(".video-preview-text"), "Нет видео");
        WebElement name = newVideoName.findElement(By.tagName("a"));
        postponedAssertNotNull(name, "Не найдена ссылка на видео");
        postponedAssertTrue(!name.getText().isEmpty(), "Название видео - пустое");

        String url = name.getAttribute("href");
        postponedAssertTrue(!url.isEmpty(), "Ссылка на видео - пустая");
        return this;
    }

    @Step("Проверяется блок видеосеминаров")
    public FssVideosPage checkVideoBlocksIsNotEmpty() {
        WebElement videoBlocks = waitForPresenceOfElementLocatedBy(By.cssSelector(".video-preview-list"), "Не найден блок видеосеминаров");
        List<WebElement> videos = videoBlocks.findElements(By.cssSelector(".block-videos"));
        postponedAssertFalse(videos.isEmpty(), "Блок видеосеминаров пустой");
        return this;
    }

    @Step("Проверяется формат блока видео")
    public FssVideosPage checkVideoBlockFormat() {
        WebElement videoBlocks = waitForPresenceOfElementLocatedBy(By.cssSelector(".video-preview-list"), "Не найден блок видеосеминаров");
        List<WebElement> videos = videoBlocks.findElements(By.cssSelector(".block-videos"));
        WebElement randomVideoBlock = getRandomElementInList(videos);

        assertNotNull(findElementByNoThrow(randomVideoBlock, By.tagName("img")), "Неправильный формат видеоблока. Отсутствует ссылка в виде картинки.");

        WebElement videoDetails = findElementByNoThrow(videoBlocks, By.cssSelector(".rubric-list"));
        assertNotNull(videoDetails, "Неправильный формат видеоблока. Отсутствует описание видео");

        postponedAssertTrue(!videoDetails.findElement(By.tagName("a")).getText().isEmpty(), "Неправильный формат видеоблока. Отсутствует заголовок видео");
        postponedAssertTrue(!videoDetails.getText().isEmpty(), "Неправильный формат видеоблока. Отсутствует описание видео");
        return this;
    }

    @Step("Проверяется кнопка рубрикатора видеосеминаров присутсвует")
    public FssVideosPage checkVideoRubricatorButtonIsPresent() {
        WebElement rubricatorButton = waitForPresenceOfElementLocatedBy(By.id("rubricator-btn"), "Кнопка 'Все видеосеминары' не найдена");
        postponedAssertEquals(rubricatorButton.getText(), "Все видеосеминары", "Неправильный текст кнопки 'Все видеосеминары'");
        return this;
    }
}
