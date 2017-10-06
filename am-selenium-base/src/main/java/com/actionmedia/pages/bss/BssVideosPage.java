package com.actionmedia.pages.bss;

import com.actionmedia.components.Link;
import com.actionmedia.components.MainMenuButtons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 11.10.13
 * Time: 9:38
 */
@Component
public class BssVideosPage extends BssBasePage<BssVideosPage> {

    @Step("Проверяются элементы на странице 'Видео'")
    public BssVideosPage checkDefaultStateVideoPage() {
        checkVideoTabIsSelected();
        checkSearchBoxOnVideoPage();
        checkLastVideoIsPresent();
        checkVideoBlocksIsNotEmpty();
        checkAllVideosButtonIsPresent();
        checkMyFavoritesRubricatorButtonIsPresent();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Видео'")
    public BssVideosPage checkVideoTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.VIDEO);
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Видео'")
    public BssVideosPage checkSearchBoxOnVideoPage() {
        checkSearchBoxIsPresent("Поиск видео");
        return this;
    }

    @Step("Проверяется что последнее видео отображается")
    public BssVideosPage checkLastVideoIsPresent() {
        WebElement lastVideo = findElementByNoThrow(mainLeftElement, By.cssSelector(".video-preview-big"));
        assertNotNull(lastVideo, "Блок с последним видео не найден");
        postponedAssertTrue(lastVideo.isEnabled() && lastVideo.isDisplayed(), "Блок с последним видео не отображается");
        return this;
    }

    @Step("Проверяется блок видеосеминаров")
    public BssVideosPage checkVideoBlocksIsNotEmpty() {
        WebElement videoBlocks = waitForPresenceOfElementLocatedBy(By.cssSelector(".video-preview-list"));
        List<WebElement> videos = videoBlocks.findElements(By.cssSelector(".block-videos"));
        postponedAssertFalse(videos.isEmpty(), "Блок видеосеминаров пустой");
        return this;
    }

    @Step("Проверяется кнопка рубрикатора видеосеминаров присутсвует")
    public BssVideosPage checkAllVideosButtonIsPresent() {
        WebElement rubricatorButton = waitForPresenceOfElementLocatedBy(By.id("rubricator-btn"), "Кнопка Все видео не найдена");
        postponedAssertEquals(rubricatorButton.getText(), "Все видеосеминары", "Неправильный текст кнопки Все видео");
        return this;
    }

    @Step("Проверяется счетчик видеосеминаров в футере")
    public BssVideosPage checkVideoCounter() {
        WebElement page = waitForPresenceOfElementLocatedBy(By.cssSelector(".main-wrapper"));
        WebElement videoCounter = page.findElement(By.cssSelector(".factoids__digit"));
        String videoCounterText = videoCounter.getText().trim();
        postponedAssertFalse(videoCounterText.isEmpty(), "Счетчик видеосеминаров в футере пустой");
        int footerCounter = Integer.parseInt(videoCounterText);
        int rubricatorCounter = getNumberOfVideosFromRubricator();
        postponedAssertTrue(footerCounter == rubricatorCounter, "Количество видеосеминаров в футере не равно количеству в рубрикаторе." +
                " Видеосеминаров в футере: " + footerCounter +
                " Видеосеминаров в рубрикаторе: " + rubricatorCounter);
        return this;
    }

    @Step("Проверяется содержание для видео/описания видео")
    public BssVideosPage checkVideoBlocksContent() {
        List<WebElement> videoList = waitForVisibilityOfAllElementsLocatedBy(By.cssSelector(".block-videos"));
        for (WebElement video : videoList) {
            String videoUrl = video.findElement(By.tagName("a")).getAttribute("href");
            WebElement videoPreviewImg = video.findElement(By.cssSelector(".video-preview")).findElement(By.tagName("img"));
            postponedAssertTrue(isImageLoaded(videoPreviewImg), "Отсутствует картинка для видео превью. Видео - '" + videoUrl + "'");

            String videoDescribe;
            if (findElementByNoThrow(video, By.cssSelector(".rubric-list")) != null) {
                assertNotNull(findElementByNoThrow(video, By.cssSelector(".rubric-list")), "Отсутствует описание для видео '" + videoUrl + "'");
                videoDescribe = video.findElement(By.cssSelector(".rubric-list")).getText();
            } else {
                assertNotNull(findElementByNoThrow(video, By.cssSelector(".video-preview-text")), "Отсутствует описание для видео '" + videoUrl + "'");
                videoDescribe = video.findElement(By.cssSelector(".video-preview-text")).getText();
            }
            //TODO update check for describe
            postponedAssertFalse(videoDescribe.contains("‐"), "Некорректные символы в описании видео '" + videoUrl + "");
        }
        return this;
    }

    @Step("Проверяется работа ссылки в плеере для последнего видео")
    public BssVideosPage checkPlayerLinkForLastVideo() {
        WebElement lastVideoBlock = mainLeftElement.findElement(By.cssSelector(".video-preview-big"));
        WebElement lastVideoPreview = lastVideoBlock.findElement(By.cssSelector(".video-preview"));
        WebElement lastVideoPlayerLink = lastVideoPreview.findElement(By.tagName("a"));
        String url = lastVideoPlayerLink.getAttribute("href");
        checkLink(new Link(url));
        return this;
    }

    @Step("Проверяется работа ссылок в плеере")
    public BssVideosPage checkLinksInVideoPlayer() {
        List<WebElement> videoPlayerList = getRandomElementsInList(mainLeftElement.findElements(By.cssSelector(".block-videos")), 3);
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement videoPlayer : videoPlayerList) {
            WebElement videoPlayerLink = videoPlayer.findElement(By.tagName("a"));
            String url = videoPlayerLink.getAttribute("href");
            Link link = new Link(url);
            linkList.add(link);
        }
        checkLinks(linkList);
        return this;
    }

    @Step("Проверяется работа ссылок в плеере")
    public BssVideosPage checkLinksInVideoDescribe() {
        List<WebElement> videoDescribeList = getRandomElementsInList(mainLeftElement.findElements(By.cssSelector(".block-videos .rubric-list")), 3);
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement videoPlayer : videoDescribeList) {
            WebElement videoPlayerLink = videoPlayer.findElement(By.tagName("a"));
            String url = videoPlayerLink.getAttribute("href");
            Link link = new Link(url);
            linkList.add(link);
        }
        checkLinks(linkList);
        return this;
    }

    private int getNumberOfVideosFromRubricator() {
        waitForVisibilityOfElementLocatedBy(By.id("rubricator-btn"), "Кнопка рубрикатора не найдена").click();
        WebElement rubricator = waitForVisibilityOfElementLocatedBy(By.id("rubricator"), "Рубрикатор не найден");
        waitForTextToBePresentIn(rubricator);
        int itemsNumber = rubricator.findElement(By.cssSelector(".b-rubricator-list")).findElements(By.tagName("li")).size();
        waitForVisibilityOfElementLocatedBy(By.id("rubricator-close"), "Кнопка закрыть рубрикатор не найдена").click();
        return itemsNumber;
    }

    @Step("Проверяется наличие большого превью")
    public BssVideosPage checkNewVideoBlock() {
        WebElement newVideoBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".video-big-pic"), "Нет большой картинки");
        postponedAssertNotNull(newVideoBlock, "Блок 'Новое видео' не найден");
        return this;
    }

    @Step("Проверяется наличие названия видео и ссылка на него")
    public BssVideosPage checkNewVideoName() {
        WebElement newVideoName = waitForPresenceOfElementLocatedBy(By.cssSelector(".video-preview-text"), "Нет видео");
        WebElement name = newVideoName.findElement(By.tagName("a"));
        postponedAssertNotNull(name, "Не найдена ссылка на видео");
        postponedAssertTrue(!name.getText().isEmpty(), "Название видео - пустое");

        String url = name.getAttribute("href");
        postponedAssertTrue(!url.isEmpty(), "Ссылка на видео - пустая");
        return this;
    }

    @Step("Проверяется кнопка онлайн консультанта 'Помощник' присутсвует")
    public BssVideosPage checkHelperButtonIsPresent() {
        WebElement helperButton = waitForPresenceOfElementLocatedBy(By.id("assistant-btn"), "Кнопка 'Помощник' не найдена");
        postponedAssertEquals(helperButton.getText(), "Помощник", "Неправильный текст кнопки 'Помощник'");
        return this;
    }

}
