package com.actionmedia.pages.uss;

import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.components.Link;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.components.Size;
import com.actionmedia.pages.helpers.SearchResultHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 28.10.13
 * Time: 12:14
 */
@Component
public class UssVideosPage extends UssBasePage<UssVideosPage> {

    @Step("Проверяются элементы на странице 'Видео'")
    public UssVideosPage checkDefaultStateVideoPage() {
        checkVideoTabIsSelected();
        checkSearchBoxOnVideoPage();
        checkVideoBlocksIsNotEmpty();
        checkVideoBlockFormat();
        checkVideoRubricatorButtonIsPresent();
        checkMyFavoritesRubricatorButtonIsPresent();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Видео'")
    public UssVideosPage checkVideoTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.VIDEO);
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Видео'")
    public UssVideosPage checkSearchBoxOnVideoPage() {
        checkSearchBoxIsPresent("Поиск видео");
        return this;
    }

    @Step("Проверяется блок видеосеминаров")
    public UssVideosPage checkVideoBlocksIsNotEmpty() {
        WebElement videoBlocks = waitForPresenceOfElementLocatedBy(By.cssSelector(".video-preview-list"), "Не найден блок видеосеминаров");
        List<WebElement> videos = videoBlocks.findElements(By.cssSelector(".block-videos"));
        postponedAssertFalse(videos.isEmpty(), "Блок видеосеминаров пустой");
        return this;
    }

    @Step("Проверяется формат блока видео")
    public UssVideosPage checkVideoBlockFormat() {
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
    public UssVideosPage checkVideoRubricatorButtonIsPresent() {
        WebElement rubricatorButton = waitForPresenceOfElementLocatedBy(By.id("rubricator-btn"), "Кнопка Все видео не найдена");
        postponedAssertEquals(rubricatorButton.getText(), "Все видео", "Неправильный текст кнопки Все видео");
        return this;
    }

    @Step("Проверяется размер картинки для последнего видео")
    public UssVideosPage checkLastVideo() {
        WebElement lastVideoFrame = waitForPresenceOfElementLocatedBy(By.cssSelector(".video-preview-big"), "Нет большой картинки");
        WebElement lastVideoPicture = lastVideoFrame.findElement(By.tagName("img"));
        Size sizeLastVideo = new Size(lastVideoPicture.getCssValue("width"), lastVideoPicture.getCssValue("height"));
        Size sizeVideoFromList = getVideoSizeFromList();
        postponedAssertTrue(sizeLastVideo.getWidth() > sizeVideoFromList.getWidth(), "Размер картинки для последнего видео меньше чем для видео в списке");
        postponedAssertTrue(sizeLastVideo.getHeight() > sizeVideoFromList.getHeight(), "Размер картинки для последнего видео меньше чем для видео в списке");
        return this;
    }

    @Step("Проверяется что работы ссылок для видео")
    public UssVideosPage checkVideoLinks() {
        WebElement videoBlocks = waitForPresenceOfElementLocatedBy(By.cssSelector(".video-preview-list"), "Не найден блок видеосеминаров");
        List<WebElement> videos = getRandomElementsInList(videoBlocks.findElements(By.cssSelector(".block-videos")), 3);
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement videoElement : videos) {
            WebElement videoInfo = videoElement.findElement(By.cssSelector(".rubric-list")).findElement(By.tagName("a"));
            String url = videoInfo.getAttribute("href");
            String header = videoInfo.getText();
            Link link = new Link(url, header);
            linkList.add(link);
        }
        checkLinks(linkList);
        return this;
    }

    @Step("Проверяется что результаты поиска отсутсвуют")
    public UssVideosPage checkSearchResultIsNotPresentOnVideoPage() {
        checkSearchResultIsNotPresentOnPage();
        return this;
    }

    @Step("Нажать кнопку Найти")
    public UssVideosPage clickSearchButtonOnVideoPage() {
        clickSearchButton();
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются")
    public UssVideosPage checkHintsIsPresent() {
        checkHintListIsPresent();
        return this;
    }

    @Step("Нажать подсказку с прямым переходом")
    public UssSearchResultPage clickHintWithJumpOnVideoPage() {
        clickHintWithJump();
        return redirectTo(UssSearchResultPage.class);
    }

    @Step("Нажать любую подсказку с переходом")
    public UssSearchResultPage clickRandomHintOnVideoPage() {
        clickRandomHint();
        return redirectTo(UssSearchResultPage.class);
    }

    @Step("Открыть случайный документ из блока популярное")
    public UssVideosPage clickRandomVideoLink() {
        List<WebElement> popularNews = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".block-videos"));
        WebElement randomVideo = getRandomElementInList(popularNews).findElement(By.tagName("a"));
        randomVideo.click();
        waitForReloadingPage();
        return this;
    }

    @Step("Проверяется работа кнопки Найти на странице Правовая база")
    public UssVideosPage checkSearchButtonFunctionalityOnSearchBox(String query) {
        setParameter(SearchResultHelper.HINT_TEXT, query);
        return clearSearchBox()
                .clickSearchButtonOnVideoPage()
                .checkVideoTabIsSelected()
                .checkSearchResultIsNotPresentOnVideoPage()

                .clearSearchBox()
                .inputTextInSearchBox(query)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnVideosPageIsOpened()
                .navigateToVideoPage();
    }

    private Size getVideoSizeFromList() {
        WebElement videoBlocks = waitForPresenceOfElementLocatedBy(By.cssSelector(".video-preview-list"), "Не найден блок видеосеминаров");
        List<WebElement> videos = videoBlocks.findElements(By.cssSelector(".block-videos"));
        WebElement randomVideoBlock = getRandomElementInList(videos).findElement(By.tagName("img"));
        return new Size(randomVideoBlock.getCssValue("width"), randomVideoBlock.getCssValue("height"));
    }
    @Step("Проверяется наличие большого превью")
    public UssVideosPage checkNewVideoBlock(){
        WebElement newVideoBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".video-big-pic"), "Нет большой картинки");
        postponedAssertNotNull(newVideoBlock, "Блок 'Новое видео' не найден");
        return this;
    }

    @Step("Проверяется наличие названия видео и ссылка на него")
    public UssVideosPage checkNewVideoName(){
        WebElement newVideoName = waitForPresenceOfElementLocatedBy(By.cssSelector(".video-preview-text"), "Нет видео");
        WebElement name = newVideoName.findElement(By.tagName("a"));
        postponedAssertNotNull(name, "Не найдена ссылка на видео");
        postponedAssertTrue(!name.getText().isEmpty(), "Название видео - пустое");

        String url = name.getAttribute("href");
        postponedAssertTrue(!url.isEmpty(), "Ссылка на видео - пустая");
        return this;
    }

    @Step("Проверяется кнопка онлайн консультанта 'Помощник' присутсвует")
    public UssVideosPage checkHelperButtonIsPresent() {
        WebElement helperButton = waitForPresenceOfElementLocatedBy(By.id("assistant-btn"), "Кнопка 'Помощник' не найдена");
        postponedAssertEquals(helperButton.getText(), "Помощник", "Неправильный текст кнопки 'Помощник'");
        return this;
    }
}
