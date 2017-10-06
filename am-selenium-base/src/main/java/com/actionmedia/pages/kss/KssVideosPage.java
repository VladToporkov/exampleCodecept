package com.actionmedia.pages.kss;

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

@Component
public class KssVideosPage extends KssBasePage<KssVideosPage> {

    @Step("Проверяются элементы на странице 'Видео'")
    public KssVideosPage checkDefaultStateVideoPage() {
        checkVideoTabIsSelected();
        checkSearchBoxOnVideoPage();
        checkVideoRubricatorButtonIsPresent();
        checkMyFavoritesRubricatorButtonIsPresent();
        checkVideoBlocksIsNotEmpty();
        checkVideoBlockFormat();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Видео'")
    public KssVideosPage checkVideoTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.VIDEO);
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Видео'")
    public KssVideosPage checkSearchBoxOnVideoPage() {
        checkSearchBoxIsPresent("Поиск видео");
        return this;
    }

    @Step("Проверяется кнопка рубрикатора видеосеминаров присутсвует")
    public KssVideosPage checkVideoRubricatorButtonIsPresent() {
        WebElement rubricatorButton = waitForPresenceOfElementLocatedBy(By.id("rubricator-btn"), "Кнопка 'Все видео' не найдена");
        postponedAssertEquals(rubricatorButton.getText(), "Все видео", "Неправильный текст кнопки 'Все видео'");
        return this;
    }

    @Step("Проверяется блок видеосеминаров")
    public KssVideosPage checkVideoBlocksIsNotEmpty() {
        WebElement videoBlocks = waitForPresenceOfElementLocatedBy(By.cssSelector(".video-preview-list"), "Не найден блок видеосеминаров");
        List<WebElement> videos = videoBlocks.findElements(By.cssSelector(".block-videos"));
        postponedAssertFalse(videos.isEmpty(), "Блок видеосеминаров пустой");
        return this;
    }

    @Step("Проверяется формат блока видео")
    public KssVideosPage checkVideoBlockFormat() {
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

    @Step("Проверяется размер картинки для последнего видео")
    public KssVideosPage checkLastVideo() {
        WebElement lastVideoFrame = waitForPresenceOfElementLocatedBy(By.cssSelector(".video-preview-big"), "Нет большой картинки");
        WebElement lastVideoPicture = lastVideoFrame.findElement(By.tagName("img"));
        Size sizeLastVideo = new Size(lastVideoPicture.getCssValue("width"), lastVideoPicture.getCssValue("height"));
        Size sizeVideoFromList = getVideoSizeFromList();
        postponedAssertTrue(sizeLastVideo.getWidth() > sizeVideoFromList.getWidth(), "Размер картинки для последнего видео меньше чем для видео в списке");
        postponedAssertTrue(sizeLastVideo.getHeight() > sizeVideoFromList.getHeight(), "Размер картинки для последнего видео меньше чем для видео в списке");
        return this;
    }

    @Step("Проверяется работа ссылок для видео")
    public KssVideosPage checkVideoLinks() {
        WebElement videoBlocks = waitForPresenceOfElementLocatedBy(By.cssSelector(".video-preview-list"), "Не найден блок видеосеминаров");
        List<WebElement> videos = videoBlocks.findElements(By.cssSelector(".block-videos"));
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

    private Size getVideoSizeFromList() {
        WebElement videoBlocks = waitForPresenceOfElementLocatedBy(By.cssSelector(".video-preview-list"), "Не найден блок видеосеминаров");
        List<WebElement> videos = videoBlocks.findElements(By.cssSelector(".block-videos"));
        WebElement randomVideoBlock = getRandomElementInList(videos).findElement(By.tagName("img"));
        return new Size(randomVideoBlock.getCssValue("width"), randomVideoBlock.getCssValue("height"));
    }

    @Step("Проверяется что результаты поиска отсутсвуют")
    public KssVideosPage checkSearchResultIsNotPresentOnVideoPage() {
        checkSearchResultIsNotPresentOnPage();
        return this;
    }

    @Step("Нажать кнопку Найти")
    public KssVideosPage clickSearchButtonOnVideoPage() {
        clickSearchButton();
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются")
    public KssVideosPage checkHintsIsPresent() {
        checkHintListIsPresent();
        return this;
    }

    @Step("Нажать подсказку с прямым переходом")
    public KssSearchResultPage clickHintWithJumpOnVideoPage() {
        clickHintWithJump();
        return redirectTo(KssSearchResultPage.class);
    }

    @Step("Нажать любую подсказку с переходом")
    public KssSearchResultPage clickRandomHintOnVideoPage() {
        clickRandomHint();
        return redirectTo(KssSearchResultPage.class);
    }

    @Step("Открыть случайный документ из блока популярное")
    public KssVideosPage clickRandomVideoLink() {
        List<WebElement> popularNews = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".block-videos"));
        WebElement randomVideo = getRandomElementInList(popularNews).findElement(By.tagName("a"));
        randomVideo.click();
        waitForReloadingPage();
        return this;
    }

    @Step("Проверяется работа кнопки Найти на странице Правовая база")
    public KssVideosPage checkSearchButtonFunctionalityOnSearchBox(String query) {
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

    @Step("Проверяется наличие большого превью")
    public KssVideosPage checkNewVideoBlock(){
        WebElement newVideoBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".video-big-pic"), "Нет большой картинки");
        postponedAssertNotNull(newVideoBlock, "Блок 'Новое видео' не найден");
        return this;
    }

    @Step("Проверяется наличие названия видео и ссылка на него")
    public KssVideosPage checkNewVideoName(){
        WebElement newVideoName = waitForPresenceOfElementLocatedBy(By.cssSelector(".video-preview-text"), "Нет видео");
        WebElement name = newVideoName.findElement(By.tagName("a"));
        postponedAssertNotNull(name, "Не найдена ссылка на видео");
        postponedAssertTrue(!name.getText().isEmpty(), "Название видео - пустое");

        String url = name.getAttribute("href");
        postponedAssertTrue(!url.isEmpty(), "Ссылка на видео - пустая");
        return this;
    }

    @Step("Проверяется кнопка онлайн консультанта 'Помощник' присутсвует")
    public KssVideosPage checkHelperButtonIsPresent() {
        WebElement helperButton = waitForPresenceOfElementLocatedBy(By.id("assistant-btn"), "Кнопка 'Помощник' не найдена");
        postponedAssertEquals(helperButton.getText(), "Помощник", "Неправильный текст кнопки 'Помощник'");
        return this;
    }
}
