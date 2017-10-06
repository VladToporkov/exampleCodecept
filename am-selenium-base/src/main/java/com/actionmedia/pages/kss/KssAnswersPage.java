package com.actionmedia.pages.kss;

import com.actionmedia.autotest.selenium.elements.TextField;
import com.actionmedia.components.Link;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.components.widgets.*;
import com.actionmedia.components.widgets.recomendation.*;
import com.actionmedia.pages.helpers.SearchResultHelper;
import com.actionmedia.pages.interfaces.IRecomendPage;
import com.actionmedia.util.TestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class KssAnswersPage extends KssBasePage<KssAnswersPage> implements IRecomendPage {

    @Step("Проверяются элементы на странице 'Ответы'")
    public KssAnswersPage checkDefaultStateAnswersPage() {
        checkAnswersTabIsSelected();
        checkSearchBoxIsPresentOnAnswersPage();
        checkNewsBlockIsPresent();
        checkYellowPlateIsPresent();
        checkLawBaseBlockIsPresent();
        checkFormsBlockIsPresent();
        checkVideosBlockIsPresent();
        checkDictionaryBlockIsPresent();
        checkWizardsBlockIsPresent();
        checkMagazinesAndBooksBlockIsPresent();
        checkMyFavoritesBlockIsPresent();
        checkAllAnswersRubricatorButtonIsPresent();
        checkMyFavoritesRubricatorButtonIsPresent();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Ответы'")
    public KssAnswersPage checkAnswersTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.ANSWERS);
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Ответы'")
    public KssAnswersPage checkSearchBoxIsPresentOnAnswersPage() {
        checkSearchBoxIsPresent("Поиск ответов");
        return this;
    }

    @Step("Проверяется что кнопка рубрикатора ответов отображается")
    public KssAnswersPage checkAllAnswersRubricatorButtonIsPresent() {
        WebElement rubricatorButton = waitForPresenceOfElementLocatedBy(By.id("rubricator-btn"), "Кнопка 'Все ответы' Отсутствует");
        postponedAssertEquals(rubricatorButton.getText(), "Все ответы", "Неправильный текст кнопки 'Все ответы'");
        return this;
    }

    @Step("Проверяется что 'Желтая плашка' отображается")
    public KssAnswersPage checkYellowPlateIsPresent() {
        WebElement yellowPlate = getYellowPlate();
        postponedAssertTrue(yellowPlate.isEnabled() && yellowPlate.isDisplayed(), "'Желтая плашка' не отображается");
        return this;
    }

    @Step("Проверяется что 'Желтая плашка' не пустая")
    public KssAnswersPage checkYellowPlateIsNotEmpty() {
        WebElement yellowPlate = getYellowPlate();

        WebElement question = findElementByNoThrow(yellowPlate, By.cssSelector(".widget__title-text"));
        postponedAssertTrue(question != null && question.isDisplayed() && !question.getText().isEmpty(), "Вопрос в 'Желтой плашке' пустой");

        WebElement answer = findElementByNoThrow(yellowPlate, By.cssSelector(".author-comment__text"));
        postponedAssertTrue(answer != null && answer.isDisplayed() && !answer.getText().isEmpty(), "Ответ в 'Желтой плашке' пустой");

        WebElement source = getYellowPlate().findElement(By.cssSelector(".author-comment__source"));
        WebElement link = findElementByNoThrow(source, By.tagName("a"));
        postponedAssertTrue(link != null && link.isDisplayed() && !link.getText().isEmpty(), "Ссылка на полный ответ не найдена");

        return this;
    }

    @Step("Проверяются ссылки на рубрикаторы в 'Желтой плашке'")
    public KssAnswersPage checkMoreAnswersOnYellowPlate() {
        WebElement more = getYellowPlate().findElement(By.cssSelector(".widget__footer"));
        postponedAssertTrue(more.isDisplayed() && !more.getText().isEmpty(), "Блок 'Еще ответы по рубрикам' в 'Желтой плашке' пустой или не отображается");

        List<WebElement> moreList = more.findElements(By.cssSelector(".link_type_rubric"));
        postponedAssertFalse(moreList.isEmpty(), "Отсутсвуют ссылки на рубрикаторы в 'Желтой плашке'");
        postponedAssertTrue(moreList.size() == YellowPlateItem.values().length, "Не все ссылки на рубрикатор присутсвуют в 'Желтой плашке'");

        for (WebElement moreLink : moreList) {
            postponedAssertTrue(moreLink.isDisplayed() && !moreLink.getText().isEmpty(), "Ссылки на рубрикаторы в 'Желтой плашке' пустые");
        }

        for (int i = 0; i < YellowPlateItem.values().length; i++) {
            postponedAssertEquals(moreList.get(i).getText(), YellowPlateItem.values()[i].getLinkName(), "Неправильный текст ссылки на рубрикатор");
        }
        return this;
    }

    @Step("Проверяется работа ссылок в 'Желтой плашке'")
    public KssAnswersPage checkLinksOnYellowPlate() {
        WebElement source = getYellowPlate().findElement(By.cssSelector(".author-comment__source"));
        WebElement linkElement = source.findElement(By.tagName("a"));
        String url = linkElement.getAttribute("href");
        String header = linkElement.getText();
        Link link = new Link(url, header);
        checkLinks(Arrays.asList(link));
        return this;
    }

    @Step("Проверяется работа ссылок на рубрикаторы в 'Желтой плашке'")
    public KssAnswersPage checkRubricatorLinksOnYellowPlate() {
        WebElement more = getYellowPlate().findElement(By.cssSelector(".widget__footer"));
        List<WebElement> moreList = more.findElements(By.cssSelector(".link_type_rubric"));

        for (WebElement moreLink : moreList) {
            moreLink.click();
            waitForReloadingPage();
            String headerFormRubricator = getActiveHeaderFromRubricator();
            postponedAssertFalse(headerFormRubricator.isEmpty(), "В рубрикаторе не один элемент не выбран");
            postponedAssertEquals(headerFormRubricator, YellowPlateItem.getRubricatorName(moreLink.getText()).getHeaderInRubricator(), "Открыт неправильный рубрикатор");
            waitForPresenceOfElementLocatedBy(By.id("rubricator-close")).click();
            waitForInvisibilityOfElementLocatedBy(By.id("rubricator"));
        }
        return this;
    }

    @Override
    public KssAnswersPage checkYellowPanelIsPresent() {
        getHelper(YellowPanel.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkHandbookWidgetIsPresent() {
        getHelper(HandbookWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkFormsWidgetIsPresent() {
        getHelper(FormsWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkLawBaseWidgetIsPresent() {
        getHelper(LawBaseWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkMagazinesWidgetIsPresent() {
        getHelper(MagazinesWidget.class).checkWidgetIsPresent();
        return this;
    }

    public KssAnswersPage checkSeminarsWidgetIsPresent() {
        getHelper(SeminarsWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkVideoWidgetIsPresent() {
        getHelper(VideoWidget.class).checkWidgetIsPresent();
        return this;
    }

    public KssAnswersPage checkEstimatorsWidgetIsPresent() {
        getHelper(EstimatorsWidget.class).checkWidgetIsPresent();
        return this;
    }

    public KssAnswersPage checkWizardsWidgetIsPresent() {
        getHelper(WizardsWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkFavoritesWidgetIsPresent() {
        getHelper(FavoritesWidget.class).checkWidgetIsPresent();
        return this;
    }

    public KssAnswersPage checkFavoritesWidgetIsNotPresent() {
        getHelper(FavoritesWidget.class).checkWidgetIsNotPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkWorkingDaysWidgetIsPresent() {
        getHelper(WorkingDaysWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkWeekendDaysWidgetIsPresent() {
        getHelper(WeekendDaysWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkNewsBlockIsPresent() {
        getHelper(NewsBlock.class).checkWidgetIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Новое в работе' не пустой")
    public KssAnswersPage checkNewsBlockIsNotEmpty() {
        List<WebElement> newsList = sidebarElement.findElements(By.cssSelector(".news__item"));
        postponedAssertFalse(newsList.isEmpty(), "Блок 'Новое в работе' пустой");
        for (WebElement newItem : newsList) {
            postponedAssertTrue(newItem.isDisplayed() && !newItem.getText().isEmpty(), "Новость в блоке 'Новое в работе' пустая");
        }
        return this;
    }

    @Step("Проверяется что новости в блоке 'Новое в работе' не повторяются")
    public KssAnswersPage checkNewsIsNotRepeated() {
        List<WebElement> newsList = sidebarElement.findElements(By.cssSelector(".news__item"));
        List<String> newsTextList = new ArrayList<String>();
        for (WebElement newItem : newsList) {
            String newsText = newItem.getText();
            if ("Все новости".equals(newsText)) {
                continue;
            }
            postponedAssertFalse(newsTextList.contains(newsText), "Новость '" + newsText + "' в блоке 'Новое в работе' повторяется");
            newsTextList.add(newsText);
        }
        return this;
    }

    @Step("Пороверяется работы ссылок в блоке 'Новое в работе'")
    public KssAnswersPage checkLinksInNewsBlock() {
        List<WebElement> newsList = sidebarElement.findElements(By.cssSelector(".news__item"));
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement newsItem : newsList) {
            if (newsItem.getAttribute("class").contains("flag")) {
                continue;
            }
            String url = newsItem.findElement(By.tagName("a")).getAttribute("href");
            linkList.add(new Link(url));
        }
        checkLinks(linkList);
        return this;
    }

    @Step("Проверяется что ссылки 'Новое в работе' работает")
    public KssAnswersPage checkNewsPageLinkIsOpenedNewsPage() {
        WebElement newsPageLink = sidebarElement.findElement(By.tagName("h2")).findElement(By.tagName("a"));

        newsPageLink.click();
        waitForReloadingPage();

        postponedAssertTrue(getCurrentUrl().contains(getCurrentHost() + "/#/news/"), "Неправильный урл раздела 'Новости'");
        WebElement newsPaper = waitForPresenceOfElementLocatedBy(By.id("newspaper"), "Не найдены элементы раздела 'Новости'");
        postponedAssertTrue(newsPaper.isEnabled() && newsPaper.isDisplayed(), "Раздел 'Новости' не отображается");
        postponedAssertFalse(newsPaper.getText().isEmpty(), "Раздел 'Новости' пустой");
        return this;
    }

    @Step("Проверяется что блок 'Правовая база' отображается")
    public KssAnswersPage checkLawBaseBlockIsPresent() {
        WebElement lawBaseBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_law"), "Блок 'Правовая база' не найден");
        postponedAssertTrue(lawBaseBlock.isEnabled() && lawBaseBlock.isDisplayed(), "Блок 'Правовая база' не отображается");
        return this;
    }

    @Step("Проверяется что блок 'Правовая база' не пустой")
    public KssAnswersPage checkLawBaseBlockIsNotEmpty() {
        WebElement lawBaseBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_law"), "Блок 'Правовая база' не найден");
        List<WebElement> lawItemList = lawBaseBlock.findElements(By.tagName("li"));
        postponedAssertFalse(lawItemList.isEmpty(), "Блок 'Правовая база' пустой");
        for (WebElement lawItem : lawItemList) {
            postponedAssertTrue(lawItem.isDisplayed() && !lawItem.getText().isEmpty(), "Отсуствует раздел в блоке 'Правовая база'");
        }
        return this;
    }

    @Step("Проверяется что поисковая строка в блоке 'Правовая база'")
    public KssAnswersPage checkSearchBoxInLawBaseBlockIsPresent() {
        WebElement lawBaseBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_law"), "Блок 'Правовая база' не найден");
        checkSearchBoxInWidget(lawBaseBlock, "Правовая база", "Поиск документов");
        return this;
    }

    @Step("Проверяется что 'Синий шарик' отображается в блоке 'Правовая база'")
    public KssAnswersPage checkBlueBallInLawBaseBlockIsPresent() {
        WebElement lawBaseBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_law"), "Блок 'Правовая база' не найден");
        checkBlueBallIsPresent(lawBaseBlock, "Правовая база");
        return this;
    }

    @Step("Проверяется работа ссылок в блоке 'Правовая база'")
    public KssAnswersPage checkLinksInLawBaseBlock() {
        WebElement lawBaseBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_law"), "Блок 'Правовая база' не найден");
        List<WebElement> lawItemList = lawBaseBlock.findElements(By.tagName("li"));
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement lawItem : lawItemList) {
            String url = lawItem.findElement(By.tagName("a")).getAttribute("href");
            String header = lawItem.findElement(By.tagName("a")).getText();
            Link link = new Link(url, header);
            linkList.add(link);
        }
        checkLinks(linkList);
        return this;
    }

    @Step("Проверяется что ссылка 'Правовая база' работает")
    public KssAnswersPage checkLawBaseLinkIsOpenedLawBasePage() {
        WebElement lawBaseBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_law"), "Блок 'Правовая база' не найден");
        WebElement lawBaseLink = lawBaseBlock.findElement(By.cssSelector(".widget__title-text"));
        lawBaseLink.click();
        return redirectTo(KssLawBasePage.class)
                .checkDefaultStateLawBasePage()
                .navigateToAnswersPage();
    }

    @Step("Проверяется что ссылка 'Правовая база' в синем шарике работает")
    public KssAnswersPage checkBlueBallLinkIsOpenedLawBasePage() {
        WebElement lawBaseBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_law"), "Блок 'Правовая база' не найден");
        WebElement blueBallLink = lawBaseBlock.findElement(By.cssSelector(".widget__update"));
        blueBallLink.click();
        return redirectTo(KssLawBasePage.class)
                .checkDefaultStateLawBasePage()
                .navigateToAnswersPage();
    }

    @Step("Проверяется что блок 'Формы' отображается")
    public KssAnswersPage checkFormsBlockIsPresent() {
        WebElement formsBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_forms"), "Блок 'Формы' не найден");
        postponedAssertTrue(formsBlock.isEnabled() && formsBlock.isDisplayed(), "Блок 'Формы' не отображается");
        return this;
    }

    @Step("Проверяется что блок 'Формы' не пустой")
    public KssAnswersPage checkFormsBlockIsNotEmpty() {
        WebElement formsBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_forms"), "Блок 'Формы' не найден");
        List<WebElement> formItemList = formsBlock.findElements(By.tagName("li"));
        postponedAssertFalse(formItemList.isEmpty(), "Блок 'Формы' пустой");
        for (WebElement formItem : formItemList) {
            postponedAssertTrue(formItem.isDisplayed() && !formItem.getText().isEmpty(), "Отсуствует раздел в блоке 'Формы'");
        }
        return this;
    }

    @Step("Проверяется поисковая строка в блоке 'Формы'")
    public KssAnswersPage checkSearchBoxInFormsBlockIsPresent() {
        WebElement formsBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_forms"), "Блок 'Формы' не найден");
        checkSearchBoxInWidget(formsBlock, "Формы", "Поиск форм и образцов");
        return this;
    }

    @Step("Проверяется что 'Синий шарик' отображается в блоке 'Формы'")
    public KssAnswersPage checkBlueBallInFormsBlockIsPresent() {
        WebElement formsBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_forms"), "Блок 'Формы' не найден");
        checkBlueBallIsPresent(formsBlock, "Формы");
        return this;
    }

    @Step("Проверяется что общее количество документов в разделе 'Формы' отображается")
    public KssAnswersPage checkTotalAmountInFormsBlockIsPresent() {
        WebElement formsBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_forms"), "Блок 'Формы' не найден");
        WebElement totalAmountElement = findElementByNoThrow(formsBlock, By.cssSelector(".widget__count"));
        postponedAssertTrue(totalAmountElement != null && totalAmountElement.isDisplayed() && !totalAmountElement.getText().isEmpty(), "В блоке 'Формы' не отображается общее количесто документов");
        return this;
    }

    @Step("Проверяется что ссылка в блоке 'Формы' работает")
    public KssAnswersPage checkLinksInFormsBlock() {
        WebElement formsBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_forms"), "Блок 'Правовая база' не найден");
        List<WebElement> formsItemList = formsBlock.findElements(By.tagName("li"));
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement formsItem : formsItemList) {
            String url = formsItem.findElement(By.tagName("a")).getAttribute("href");
            String header = formsItem.findElement(By.tagName("a")).getText();
            Link link = new Link(url, header);
            linkList.add(link);
        }
        checkLinks(linkList);
        return this;
    }

    @Step("Проверяется работа ссылки 'Формы'")
    public KssAnswersPage checkFormsLinkIsOpenedFormsPage() {
        WebElement formsBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_forms"), "Блок 'Формы' не найден");
        WebElement formsLink = formsBlock.findElement(By.cssSelector(".widget__title-text"));
        formsLink.click();
        return redirectTo(KssFormsPage.class)
                .checkDefaultStateFormsPage()
                .navigateToAnswersPage();
    }

    @Step("Проверяется работа ссылки 'Формы' в синем шарике")
    public KssAnswersPage checkBlueBallLinkIsOpenedFormsPage() {
        WebElement formsBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_forms"), "Блок 'Формы' не найден");
        WebElement blueBallLink = formsBlock.findElement(By.cssSelector(".widget__update"));
        blueBallLink.click();
        return redirectTo(KssFormsPage.class)
                .checkDefaultStateFormsPage()
                .navigateToAnswersPage();
    }

    @Step("Проверяется что блок 'Видеосеминары' отображается")
    public KssAnswersPage checkVideosBlockIsPresent() {
        WebElement videosBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_videos"), "Блок 'Видеосеминары' не найден");
        postponedAssertTrue(videosBlock.isEnabled() && videosBlock.isDisplayed(), "Блок 'Видеосеминары' отображается");
        return this;
    }

    @Step("Проверяется что блок 'Видеосеминары' не пустой")
    public KssAnswersPage checkVideoPreviewIsPresent() {
        WebElement videosBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_videos"), "Блок 'Видеосеминары' не найден");
        WebElement videoPreview = findElementByNoThrow(videosBlock, By.cssSelector("[style*='background-image']"));
        postponedAssertTrue(videoPreview != null && videoPreview.isDisplayed(), "Отсутствует видео в блоке 'Видеосеминары'");
        return this;
    }

    @Step("Проверяется фон для видео")
    public KssAnswersPage checkBackgroundForVideo() {
        WebElement videosBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_videos"), "Блок 'Видеосеминары' не найден");
        WebElement videoPreview = findElementByNoThrow(videosBlock, By.cssSelector("[style*='background-image']"));
        postponedAssertNotNull(videoPreview, "Bидеопревью в блоке 'Видео' не найдено");
        if (videoPreview != null) {
            assertTrue(videoPreview.getTagName().equals("a"), "Ссылка для видео не найдена");
            assertNotNull(videoPreview.getAttribute("style"), "Фон для видео не отображается");
            postponedAssertTrue(videoPreview.getAttribute("style").contains("background-image:") && videoPreview.getAttribute("style").contains("system/content/feature/image/"), "Фон для видео не отображается");
        }
        return this;
    }

    @Step("Проверяется что заголовок и длительность видеосеминара отображается")
    public KssAnswersPage checkTitleAndLengthVideoIsPresent() {
        WebElement videosBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_videos"), "Блок 'Видеосеминары' не найден");
        WebElement videoPreview = videosBlock.findElement(By.cssSelector("[style*='background-image']"));
        WebElement title = findElementByNoThrow(videoPreview, By.tagName("span"));
        postponedAssertTrue(title != null && title.isDisplayed() && !title.getText().isEmpty(), "Отсутствует заголовок для видео");
        WebElement length = findElementByNoThrow(title, By.tagName("span"));
        postponedAssertTrue(length != null && length.isDisplayed() && !length.getText().isEmpty(), "Отсутствует продолжительность для видео");
        return this;
    }

    @Step("Проверяется что общее количество документов в разделе 'Видеосеминары' отображается")
    public KssAnswersPage checkTotalAmountVideosInVideoBlockIsPresent() {
        WebElement videosBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_videos"), "Блок 'Видеосеминары' не найден");
        WebElement totalAmount = findElementByNoThrow(videosBlock, By.cssSelector(".widget__count"));
        postponedAssertTrue(totalAmount != null && totalAmount.isDisplayed() && !totalAmount.getText().isEmpty(), "В блоке 'Видеосеминары' не отображается общее количесто видео");
        return this;
    }

    @Step("Проверяется что ссылка в блоке 'Видеосеминары' ведет на соответствующий видеосеминар")
    public KssAnswersPage checkVideoLink() {
        WebElement videosBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_videos"), "Блок 'Видеосеминары' не найден");
        WebElement videoPreview = videosBlock.findElement(By.cssSelector("[style*='background-image']"));
        String url = videoPreview.getAttribute("href");
        String header = videoPreview.findElement(By.tagName("span")).getText();
        Link link = new Link(url, header);
        checkLinks(Arrays.asList(link));
        return this;
    }

    @Step("Проверяется работа ссылки 'Видеосеминары'")
    public KssAnswersPage checkVideosLinkIsOpenedVideosPage() {
        WebElement videosBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_videos"), "Блок 'Видеосеминары' не найден");
        WebElement videosLink = videosBlock.findElement(By.cssSelector(".widget__title-text"));
        videosLink.click();
        return redirectTo(KssVideosPage.class)
                .checkDefaultStateVideoPage()
                .navigateToAnswersPage();
    }

    @Step("Проверяется что блок 'Журналы и книги' отображается")
    public KssAnswersPage checkMagazinesAndBooksBlockIsPresent() {
        WebElement magazinesAdBooksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_press"), "Блок 'Журналы и книги' не найден");
        postponedAssertTrue(magazinesAdBooksBlock.isEnabled() && magazinesAdBooksBlock.isDisplayed(), "Блок 'Журналы и книги' не отображается");
        return this;
    }

    @Step("Проверяется что блок 'Журналы и книги' не пустой")
    public KssAnswersPage checkMagazinesAndBooksBlockIsNotEmpty() {
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

    @Step("Проверяется что Журналы/книги не повторяются")
    public KssAnswersPage checkMagazinesAreNotRepeated() {
        WebElement magazinesAdBooksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_press"), "Блок 'Журналы и книги' не найден");
        List<WebElement> magazines = magazinesAdBooksBlock.findElements(By.tagName("li"));
        List<String> magazineUrlList = new ArrayList<String>();
        List<String> magazineImgList = new ArrayList<String>();
        for (WebElement magazine : magazines) {
            String url = magazine.findElement(By.tagName("a")).getAttribute("href");
            String img = magazine.findElement(By.tagName("img")).getAttribute("src");
            postponedAssertFalse(magazineUrlList.contains(url) || magazineImgList.contains(img), "Журнал '" + url + "' повторяется");
            magazineUrlList.add(url);
            magazineImgList.add(img);
        }
        return this;
    }

    @Step("Проверяется что общее количество документов в разделе 'Журналы и книги' отображается")
    public KssAnswersPage checkTotalAmountMagazinesInMagazineBlockIsPresent() {
        WebElement magazinesAdBooksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_press"), "Блок 'Журналы и книги' не найден");
        WebElement totalAmount = findElementByNoThrow(magazinesAdBooksBlock, By.cssSelector(".widget__count"));
        postponedAssertTrue(totalAmount != null && totalAmount.isDisplayed() && !totalAmount.getText().isEmpty(), "В блоке 'Журналы и книги' не отображается общее количесто журналов/книг");
        return this;
    }

    @Step("Проверяется работа ссылок в блоке 'Журналы и книги'")
    public KssAnswersPage checkLinksInMagazineBlock() {
        WebElement magazinesAdBooksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_press"), "Блок 'Журналы и книги' не найден");
        List<WebElement> magazines = magazinesAdBooksBlock.findElements(By.tagName("li"));
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement magazine : magazines) {
            String url = magazine.findElement(By.tagName("a")).getAttribute("href");
            linkList.add(new Link(url));
        }
        checkLinks(linkList);
        return this;
    }

    @Step("Проверяется работа ссылки 'Журналы и книги'")
    public KssMagazinesPage clickLinkInMagazineBlock() {
        WebElement magazinesAdBooksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_press"), "Блок 'Журналы и книги' не найден");
        WebElement magazineLink = magazinesAdBooksBlock.findElement(By.cssSelector(".widget__title-text"));
        magazineLink.click();
        return redirectTo(KssMagazinesPage.class);
    }

    @Step("Проверяется что блок 'Мастера' отображается")
    public KssAnswersPage checkWizardsBlockIsPresent() {
        WebElement wizardsBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_wizards"), "Блок 'Мастера' не найден");
        postponedAssertTrue(wizardsBlock.isEnabled() && wizardsBlock.isDisplayed(), "Блок 'Мастера' не отображается");
        return this;
    }

    @Step("Проверяется что блок 'Мастера' не пустой")
    public KssAnswersPage checkWizardsBlockIsNotEmpty() {
        WebElement wizardsBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_wizards"), "Блок 'Мастера' не найден");
        List<WebElement> wizards = wizardsBlock.findElements(By.tagName("li"));
        postponedAssertFalse(wizards.isEmpty(), "Блок 'Мастера' пустой");
        for (WebElement wizard : wizards) {
            assertNotNull(findElementByNoThrow(wizard, By.tagName("a")), "Отсутствует ссылка для 'Мастера'");
            postponedAssertFalse(wizard.getText().isEmpty(), "Текст ссылки пустой");
        }
        return this;
    }

    @Step("Проверяется что общее количество документов в разделе 'Мастера' отображается")
    public KssAnswersPage checkTotalAmountWizardsInWizardsBlockIsPresent() {
        WebElement wizardsBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_wizards"), "Блок 'Мастера' не найден");
        WebElement totalAmount = findElementByNoThrow(wizardsBlock, By.cssSelector(".widget__count"));
        postponedAssertTrue(totalAmount != null && totalAmount.isDisplayed() && !totalAmount.getText().isEmpty(), "В блоке 'Мастера' не отображается общее количесто мастеров");
        return this;
    }

    @Step("Проверяется работа ссылок в блоке 'Мастера'")
    public KssAnswersPage checkLinksInWizardsBlock() {
        WebElement wizardsBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_wizards"), "Блок 'Мастера' не найден");
        List<WebElement> wizards = wizardsBlock.findElements(By.tagName("li"));
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement wizard : wizards) {
            String url = wizard.findElement(By.tagName("a")).getAttribute("href");
            String header = wizard.findElement(By.tagName("a")).getText();
            Link link = new Link(url, header);
            linkList.add(link);
        }
        checkLinks(linkList);
        return this;
    }

    @Step("Проверяется работа ссылки 'Мастера'")
    public KssAnswersPage checkLinkInWizardsBlockIsOpenedWizardsPage() {
        WebElement wizardsBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_wizards"), "Блок 'Мастера' не найден");
        WebElement wizardLink = wizardsBlock.findElement(By.cssSelector(".widget__title-text"));
        wizardLink.click();
        return redirectTo(KssWizardsPage.class)
                .checkDefaultStateWizardsPage()
                .navigateToAnswersPage();
    }

    @Step("Проверяется что блок 'Справочник' отображается")
    public KssAnswersPage checkDictionaryBlockIsPresent() {
        WebElement dictionaryBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_handbook"), "Блок 'Справочник' не найден");
        postponedAssertTrue(dictionaryBlock.isEnabled() && dictionaryBlock.isDisplayed(), "Блок 'Справочник' не найден");
        return this;
    }

    @Step("Проверяется что блок 'Справочник' не пустой")
    public KssAnswersPage checkDictionaryBlockIsNotEmpty() {
        WebElement dictionaryBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_handbook"), "Блок 'Справочник' не найден");
        postponedAssertFalse(dictionaryBlock.getText().isEmpty(), "Блок 'Справочник' пустой");
        return this;
    }

    @Step("Проверяется календарь в блоке 'Справочник'")
    public KssAnswersPage checkCurrentDateInDictionaryBlockIsPresent() {
        WebElement dictionaryBlock = waitForVisibilityOfElementLocatedBy(By.cssSelector(".widget_content_handbook"), "Блок 'Справочник' не найден");

        WebElement days = findElementByNoThrow(dictionaryBlock, By.xpath("//*[contains(@class,'list_type_snippy')]/li[1]"));
        postponedAssertTrue(days != null && days.isDisplayed() && !days.getText().isEmpty(), "Сегодняшнее число не отображается в блоке 'Справочник'");

        WebElement date = findElementByNoThrow(dictionaryBlock, By.xpath("//*[contains(@class,'list_type_snippy')]/li[2]"));
        postponedAssertTrue(date != null && date.isDisplayed() && !date.getText().isEmpty(), "Дата не отображается в блоке 'Справочник'");

        if (days != null && date != null) {
            String day = days.getText();
            String month = date.getText().split("\\n")[0];

            SimpleDateFormat formatter = new SimpleDateFormat("dd MMM");
            try {
                Date dateStr = formatter.parse(String.format("%s %s", day, month));
                Date currentDate = new Date();
                postponedAssertTrue(dateStr.getDate() == currentDate.getDate(), "Неправильная дата в блоке 'Справочник'");
                postponedAssertTrue(dateStr.getMonth() == currentDate.getMonth(), "Неправильный месяц в блоке 'Справочник'");
            } catch (ParseException e) {
                logger.info("ParseException occurs");
            }
        }
        return this;
    }

    @Step("Проверяется что курс валют в блоке 'Справочник' отображается")
    public KssAnswersPage checkCurrencyInDictionaryBlockIsPresent() {
        WebElement dictionaryBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_handbook"), "Блок 'Справочник' не найден");
        WebElement currency = findElementByNoThrow(dictionaryBlock, By.xpath("//*[contains(@class,'list_type_snippy')]/li[3]"));
        postponedAssertNotNull(currency, "Курс валют не найден в блоке 'Справочник'");

        if (currency != null) {
            postponedAssertTrue(currency.isDisplayed() && !currency.getText().isEmpty(), "Курс валют не отображается в блоке 'Справочник'");

            WebElement usd = currency.findElement(By.cssSelector(".list__text_content_usd"));
            postponedAssertNotNull(usd, "Курс для доллара не найден в блоке 'Справочник'");
            if (usd != null) {
                postponedAssertTrue(usd.isDisplayed() && !usd.getText().isEmpty(), "Курс для доллара не отображается в блоке 'Справочник'");
            }

            WebElement eur = currency.findElement(By.cssSelector(".list__text_content_eur"));
            postponedAssertNotNull(eur, "Курс для евро не найден в блоке 'Справочник'");
            if (eur != null) {
                postponedAssertTrue(eur.isDisplayed() && !eur.getText().isEmpty(), "Курс для евро не отображается в блоке 'Справочник'");
            }
        }
        return this;
    }

    @Step("Проверяется что МРОТ в блоке 'Справочник' отображается")
    public KssAnswersPage checkMrotInDictionaryBlockIsPresent() {
        WebElement dictionaryBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_handbook"), "Блок 'Справочник' не найден");
        WebElement mrot = findElementByNoThrow(dictionaryBlock, By.xpath("//*[contains(@class,'list_type_snippy')]/li[4]"));
        assertNotNull(mrot != null && mrot.isDisplayed() && !mrot.getText().isEmpty(), "МРОТ не отображается в блоке 'Справочник'");
        return this;
    }

    @Step("Проверяется что 'Синий шарик' отображается в блоке 'Справочник'")
    public KssAnswersPage checkBlueBallInDictionaryBlockIsPresent() {
        WebElement dictionaryBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_handbook"), "Блок 'Справочник' не найден");
        checkBlueBallIsPresent(dictionaryBlock, "'Справочник'");
        return this;
    }

    @Step("Проверяется что общее количество документов в разделе 'Журналы и книги' отображается")
    public KssAnswersPage checkTotalAmountDictionaryInDictionaryBlockIsPresent() {
        WebElement dictionaryBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_handbook"), "Блок 'Справочник' не найден");
        WebElement totalAmount = findElementByNoThrow(dictionaryBlock, By.cssSelector(".widget__count"));
        postponedAssertTrue(totalAmount != null && totalAmount.isDisplayed() && !totalAmount.getText().isEmpty(), "В блоке 'Справочник' не отображается общее количесто 'Справочник'ов");
        return this;
    }

    @Step("Проверяется что ссылки на рубрикаторы в блоке 'Справочник' отображаются")
    public KssAnswersPage checkRubricatorLinksInDictionaryBlockArePresent() {
        WebElement dictionaryBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_handbook"), "Блок 'Справочник' не найден");
        WebElement moreLinks = findElementByNoThrow(dictionaryBlock, By.cssSelector(".list_viewtype_more"));
        postponedAssertTrue(moreLinks != null && moreLinks.isDisplayed() && !moreLinks.getText().isEmpty(), "Ссылки для рубрикаторов в Блоке 'Справочник' отсутсвуют");
        return this;
    }

    @Step("Проверяется работа ссылок в блоке 'Справочник'")
    public KssAnswersPage checkLinksInDictionaryBlock() {
        WebElement dictionaryBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_handbook"), "Блок 'Справочник' не найден");
        List<Link> linkList = new ArrayList<Link>();

        WebElement dateLink = dictionaryBlock.findElement(By.xpath("//*[contains(@class,'list_type_snippy')]/li[2]/a[1]"));
        WebElement currencyLink = dictionaryBlock.findElement(By.xpath("//*[contains(@class,'list_type_snippy')]/li[3]/a[1]"));
        WebElement mrotLink = dictionaryBlock.findElement(By.xpath("//*[contains(@class,'list_type_snippy')]/li[4]/a[1]"));

        linkList.add(new Link(dateLink.getAttribute("href")));
        linkList.add(new Link(currencyLink.getAttribute("href")));
        linkList.add(new Link(mrotLink.getAttribute("href")));

        checkLinks(linkList);
        return this;
    }

    @Step("Проверяется работа ссылок на рубрикаторы в 'Желтой плашке'")
    public KssAnswersPage checkRubricatorLinksInDictionaryBlock() {
        WebElement dictionaryBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_handbook"), "Блок 'Справочник' не найден");

        WebElement more = dictionaryBlock.findElement(By.cssSelector(".list_viewtype_more"));
        List<WebElement> moreList = more.findElements(By.cssSelector(".link_type_rubric"));

        for (WebElement moreLink : moreList) {
            String rubricator = moreLink.getText();
            moreLink.click();
            waitForReloadingPage();
            String headerFormRubricator = getActiveHeaderFromRubricator();
            postponedAssertFalse(headerFormRubricator.isEmpty(), "В рубрикаторе не один элемент не выбран");
            postponedAssertEquals(headerFormRubricator, DictionaryItem.getRubricatorName(rubricator).getHeaderInRubricator(), "Открыт неправильный рубрикатор");
            waitForPresenceOfElementLocatedBy(By.id("rubricator-close")).click();
            waitForInvisibilityOfElementLocatedBy(By.id("rubricator"));
        }
        return this;
    }

    @Step("Проверяется работа ссылки 'Справочник'")
    public KssAnswersPage checkLinkInDictionaryBlockIsOpenedDictionaryPage() {
        WebElement dictionaryBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_handbook"), "Блок 'Справочник' не найден");
        WebElement dictionaryLink = dictionaryBlock.findElement(By.cssSelector(".widget__title-text"));
        dictionaryLink.click();
        return redirectTo(KssDictionaryPage.class)
                .checkDefaultStateDictionaryPage()
                .navigateToAnswersPage();
    }

    @Step("Проверяется работа ссылки 'Справочник' в синем шарике")
    public KssAnswersPage checkBlueBallLinkIsOpenedDictionaryPage() {
        WebElement dictionaryBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_handbook"), "Блок 'Справочник' не найден");
        WebElement blueBallLink = dictionaryBlock.findElement(By.cssSelector(".widget__update"));
        blueBallLink.click();
        return redirectTo(KssDictionaryPage.class)
                .checkDefaultStateDictionaryPage()
                .navigateToAnswersPage();
    }

    @Step("Проверяется что блок 'Мое избранное' отображается для авторизованного пользователя")
    public KssAnswersPage checkMyFavoritesBlockIsPresent() {
        if (isUserLogged()) {
            WebElement myFavoritesBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_bookmarks"), "Блок 'Мое избранное' не найден");
            postponedAssertTrue(myFavoritesBlock.isEnabled() && myFavoritesBlock.isDisplayed(), "Блок 'Мое избранное' не отображается для авторизованного пользователя");
        }
        return this;
    }

    @Step("Проверяется что блок 'Мое избранное' не отображается для не авторизованного пользователя")
    public KssAnswersPage checkMyFavoritesBlockIsAbsent() {
        if (!isUserLogged()) {
            WebElement myFavoritesBlock = findElementByNoThrow(mainLeftElement, By.cssSelector(".widget_content_bookmarks"));
            if (myFavoritesBlock != null) {
                postponedAssertFalse(myFavoritesBlock.isDisplayed(), "Блок 'Мое избранное' отображается для не авторизованного пользователя");
            }
        }
        return this;
    }

    @Step("Проверяется надпись в пустом блоке Мое избранное")
    public KssAnswersPage checkEmptyMyFavoritesBlock() {
        WebElement myFavoritesBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_bookmarks"), "Блок 'Мое избранное' не найден");
        WebElement myFavoritesListElement = myFavoritesBlock.findElement(By.cssSelector(".list"));
        WebElement emptyList = findElementByNoThrow(myFavoritesListElement, By.tagName("li"));
        postponedAssertNotNull(emptyList, "Не найдена надпись 'Вы ещe не добавили ни одного документа' в пустом блоке Мое избранное");
        if (emptyList != null) {
            postponedAssertEquals(emptyList.getText(), "Вы ещё не добавили ни одного документа.", "Неправильная надпись в пустом блоке Мое избранное");
        }
        return this;
    }

    @Step("Проверяется блок 'Мое избранное' с добавленными закладками")
    public KssAnswersPage checkIsNotEmptyMyFavoritesBlock() {
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

    @Step("Проверяется что ссылка 'Мое избранное' открывает меню избранного")
    public KssAnswersPage checkMyFavoritesLinksIsOpenedMyFavoritesMenu() {
        WebElement myFavoritesBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_bookmarks"), "Блок 'Мое избранное' не найден");
        myFavoritesBlock.findElement(By.cssSelector(".widget__title-text")).click();

        WebElement myFavoritesMenu = waitForVisibilityOfElementLocatedBy(By.id("main-bookmarks"), "Меню 'Мое избранное' не отображается");
        waitForTextToBePresentIn(myFavoritesMenu, "Избранное");
        postponedAssertTrue(myFavoritesMenu.isEnabled() && myFavoritesMenu.isDisplayed() && !myFavoritesMenu.getText().isEmpty(), "Меню 'Мое избранное' не отображается");

        myFavoritesBlock.click();
        return this;
    }

    @Step("Проверяется что меню 'Мое избранное' пустое")
    public KssAnswersPage checkMyFavoritesMenuIsEmpty() {
        WebElement myFavoritesBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_bookmarks"), "Блок 'Мое избранное' не найден");
        WebElement myFavoritesLink = myFavoritesBlock.findElement(By.cssSelector(".widget__title-text"));
        myFavoritesLink.click();

        WebElement myFavoritesMenu = waitForVisibilityOfElementLocatedBy(By.id("main-bookmarks"), "Меню 'Мое избранное' не отображается");
        waitForTextToBePresentIn(myFavoritesMenu, "Все избранное");
        postponedAssertNull(findElementByNoThrow(myFavoritesMenu, By.cssSelector(".b-info__title-text")), "Отображаются закладки в пустом меню Мое избранное");
        myFavoritesBlock.click();
        return this;
    }

    @Step("Проверяется что меню 'Мое избранное' не пустое")
    public KssAnswersPage checkMyFavoritesMenuIsNotEmpty() {
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
    public KssAnswersPage checkLinkInMyFavoritesBlock() {
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

    @Step("Проверяется работа строки поиска в блоке 'Правовая база'")
    public KssAnswersPage checkTextInputInSearchBoxOnLawBase() {
        TextField searchOnLawBase = getTextFieldOnLawBaseBlock();
        searchOnLawBase.clear();
        postponedAssertTrue(searchOnLawBase.getText().isEmpty(), "Строка поиска не пустая после очистки");

        String randomString = RandomStringUtils.randomAlphabetic(5);
        searchOnLawBase.clearAndType(randomString);
        postponedAssertEquals(searchOnLawBase.getText(), randomString, "Неправильный текст в строке поиска после ввода текста");

        searchOnLawBase.clear();
        postponedAssertTrue(searchOnLawBase.getText().isEmpty(), "Строка поиска не пустая после очистки");
        return this;
    }

    @Step("Проверяется работа строки поиска в блоке 'Правовая база'")
    public KssAnswersPage checkTextInputInSearchBoxOnForms() {
        TextField searchOnLawBase = getTextFieldOnFormsBlock();
        searchOnLawBase.clear();
        postponedAssertTrue(searchOnLawBase.getText().isEmpty(), "Строка поиска не пустая после очистки");

        String randomString = RandomStringUtils.randomAlphabetic(5);
        searchOnLawBase.clearAndType(randomString);
        postponedAssertEquals(searchOnLawBase.getText(), randomString, "Неправильный текст в строке поиска после ввода текста");

        searchOnLawBase.clear();
        postponedAssertTrue(searchOnLawBase.getText().isEmpty(), "Строка поиска не пустая после очистки");
        return this;
    }

    @Step("Добавить любую закладку в меню Мое избранное")
    public KssAnswersPage addRandomBookmark() {
        List<WebElement> allDocuments = waitForPresenceOfAllElementsLocatedBy(By.cssSelector("[href*='/#/document/']"));
        WebElement randomDocument = getRandomElementInList(allDocuments);
        randomDocument.click();
        waitForReloadingPage();
        waitForPresenceOfElementLocatedBy(By.cssSelector("[data-anchor*='/document']")).click();
        return this;
    }

    @Step("Открыть страницу Новое в работе")
    public KssNewsPage clickNewsLink() {
        sidebarElement.findElement(By.tagName("h2")).findElement(By.tagName("a")).click();
        return redirectTo(KssNewsPage.class);
    }

    @Step("Нажать кнопку Найти")
    public KssAnswersPage clickSearchButtonOnAnswersPage() {
        clickSearchButton();
        return this;
    }

    @Step("Очистить строку поиска в блоке 'Правовая база'")
    public KssAnswersPage clearSearchBoxOnLawBaseBlock() {
        getTextFieldOnLawBaseBlock().clear();
        return this;
    }

    @Step("Очистить строку поиска в блоке 'Формы'")
    public KssAnswersPage clearSearchBoxOnFormsBlock() {
        getTextFieldOnFormsBlock().clear();
        return this;
    }

    @Step("Ввести текст в строку поиска в блоке 'Правовая база'")
    public KssAnswersPage inputTextInSearchBoxOnLawBaseBlock(String query) {
        getTextFieldOnLawBaseBlock().clearAndType(query);
        return this;
    }

    @Step("Ввести текст в строку поиска в блоке 'Формы'")
    public KssAnswersPage inputTextInSearchBoxOnFormsBlock(String query) {
        getTextFieldOnFormsBlock().clearAndType(query);
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются")
    public KssAnswersPage checkHintsIsPresentOnYellowPlate() {
        WebElement searchResult = waitForVisibilityOfElementLocatedBy(By.id("ui-id-1"), "Выпадающие поисковые подсказки не отображаются");
        checkHintsIsPresent(searchResult);
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются в блоке 'Правовая база'")
    public KssAnswersPage checkHintsIsPresentOnLawBaseBlock() {
        WebElement searchResult = findElementsBy(By.cssSelector(".ui-autocomplete")).get(0);
        waitForPresenceOf(searchResult);
        postponedAssertTrue(searchResult.isDisplayed(), "Выпадающие поисковые подсказки не отображаются");
        checkHintsIsPresent(searchResult);
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются в блоке 'Формы'")
    public KssAnswersPage checkHintsIsPresentOnFormsBlock() {
        WebElement searchResult = findElementsBy(By.cssSelector(".ui-autocomplete")).get(1);
        waitForPresenceOf(searchResult);
        postponedAssertTrue(searchResult.isDisplayed(), "Выпадающие поисковые подсказки не отображаются");
        checkHintsIsPresent(searchResult);
        return this;
    }

    @Step("Нажать подсказку с прямым переходом")
    public KssSearchResultPage clickHintWithJumpOnYellowPlate() {
        WebElement searchResult = waitForVisibilityOfElementLocatedBy(By.id("ui-id-1"), "Выпадающие поисковые подсказки не отображаются");
        clickHintWithJump(searchResult);
        return redirectTo(KssSearchResultPage.class);
    }

    @Step("Нажать подсказку с прямым переходом в блоке 'Правовая база'")
    public KssSearchResultPage clickHintWithJumpOnLawBaseBlock() {
        WebElement searchResult = findElementsBy(By.cssSelector(".ui-autocomplete")).get(0);
        waitForPresenceOf(searchResult);
        postponedAssertTrue(searchResult.isDisplayed(), "Выпадающие поисковые подсказки не отображаются");
        clickHintWithJump(searchResult);
        return redirectTo(KssSearchResultPage.class);
    }

    @Step("Нажать подсказку с прямым переходом в блоке 'Формы'")
    public KssSearchResultPage clickHintWithJumpOnFormsBlock() {
        WebElement searchResult = findElementsBy(By.cssSelector(".ui-autocomplete")).get(1);
        waitForPresenceOf(searchResult);
        postponedAssertTrue(searchResult.isDisplayed(), "Выпадающие поисковые подсказки не отображаются");
        clickHintWithJump(searchResult);
        return redirectTo(KssSearchResultPage.class);
    }

    @Step("Нажать любую подсказку с переходом")
    public KssSearchResultPage clickRandomHintOnYellowPlate() {
        WebElement searchResult = waitForVisibilityOfElementLocatedBy(By.id("ui-id-1"), "Выпадающие поисковые подсказки не отображаются");
        clickRandomHint(searchResult);
        return redirectTo(KssSearchResultPage.class);
    }

    @Step("Нажать любую подсказку с переходом в блоке 'Правовая база'")
    public KssSearchResultPage clickRandomHintOnLawBaseBlock() {
        WebElement searchResult = findElementsBy(By.cssSelector(".ui-autocomplete")).get(0);
        waitForPresenceOf(searchResult);
        postponedAssertTrue(searchResult.isDisplayed(), "Выпадающие поисковые подсказки не отображаются");
        clickRandomHint(searchResult);
        return redirectTo(KssSearchResultPage.class);
    }

    @Step("Нажать любую подсказку с переходомв блоке 'Формы'")
    public KssSearchResultPage clickRandomHintOnFormsBlock() {
        WebElement searchResult = findElementsBy(By.cssSelector(".ui-autocomplete")).get(1);
        waitForPresenceOf(searchResult);
        postponedAssertTrue(searchResult.isDisplayed(), "Выпадающие поисковые подсказки не отображаются");
        clickRandomHint(searchResult);
        return redirectTo(KssSearchResultPage.class);
    }

    @Step("Нажать кнопку Найти в блоке 'Правовая база'")
    public KssLawBasePage clickSearchButtonOnLawBaseBlock() {
        WebElement lawBaseWidget = waitForPresenceOfElementLocatedBy(By.id("widget-law-search-form"));
        WebElement submit = lawBaseWidget.findElement(By.cssSelector("[type='submit']"));
        submit.click();
        return redirectTo(KssLawBasePage.class);
    }

    @Step("Нажать кнопку Найти в блоке 'Правовая база'")
    public KssSearchResultPage clickSearchLawBaseBlockAndNavigateToSearchresultPage() {
        WebElement lawBaseWidget = waitForPresenceOfElementLocatedBy(By.id("widget-law-search-form"));
        WebElement submit = lawBaseWidget.findElement(By.cssSelector("[type='submit']"));
        submit.click();
        return redirectTo(KssSearchResultPage.class);
    }

    @Step("Нажать кнопку Найти в блоке 'Формы'")
    public KssFormsPage clickSearchButtonOnFormsBlock() {
        WebElement lawBaseWidget = waitForPresenceOfElementLocatedBy(By.id("widget-forms-search-form"));
        WebElement submit = lawBaseWidget.findElement(By.cssSelector("[type='submit']"));
        submit.click();
        return redirectTo(KssFormsPage.class);
    }

    @Step("Нажать кнопку Найти в блоке 'Формы'")
    public KssSearchResultPage clickSearchFormsBlockAndNavigateToSearchResultPage() {
        WebElement lawBaseWidget = waitForPresenceOfElementLocatedBy(By.id("widget-forms-search-form"));
        WebElement submit = lawBaseWidget.findElement(By.cssSelector("[type='submit']"));
        submit.click();
        return redirectTo(KssSearchResultPage.class);
    }

    @Step("Проверяется работа кнопки найти в блоке 'Правовая база'")
    public KssAnswersPage checkSubmitButtonOnSearchBoxInLawBaseBlock(String query) {
        setParameter(SearchResultHelper.HINT_TEXT, query);
        return clearSearchBoxOnLawBaseBlock()
                .clickSearchButtonOnLawBaseBlock()
                .checkLawBaseTabIsSelected()
                .navigateToAnswersPage()

                .clearSearchBoxOnLawBaseBlock()
                .inputTextInSearchBoxOnLawBaseBlock(query)
                .clickSearchLawBaseBlockAndNavigateToSearchresultPage()
                .checkSearchResultOnLawBasePageIsOpened(true)
                .navigateToAnswersPage();
    }

    @Step("Проверяется работа кнопки найти в блоке 'Формы'")
    public KssAnswersPage checkSubmitButtonOnSearchBoxInFormsBlock(String query) {
        setParameter(SearchResultHelper.HINT_TEXT, query);
        return clearSearchBoxOnFormsBlock()
                .clickSearchButtonOnFormsBlock()
                .checkFormsTabIsSelected()
                .navigateToAnswersPage()

                .clearSearchBoxOnFormsBlock()
                .inputTextInSearchBoxOnFormsBlock(query)
                .clickSearchFormsBlockAndNavigateToSearchResultPage()
                .checkSearchResultOnFormsPageIsOpened()
                .navigateToAnswersPage();
    }

    @Step("Проверяется работа кнопки найти")
    public KssAnswersPage checkSearchButtonFunctionalityOnSearchBox(String query) {
        setParameter(SearchResultHelper.HINT_TEXT, query);
        return clearSearchBox()
                .clickSearchButtonOnAnswersPage()
                .checkAnswersTabIsSelected()
                .checkSearchResultIsNotPresentOnAnswersPage()

                .clearSearchBox()
                .inputTextInSearchBox(query)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnAnswersPageIsOpened()
                .navigateToAnswersPage();
    }

    @Step("Проверяется что результаты поиска отсутсвуют")
    public KssAnswersPage checkSearchResultIsNotPresentOnAnswersPage() {
        WebElement searchResultHeader = findElementByNoThrow(mainContentElement, By.cssSelector(".search-result"));
        WebElement searchResult = findElementByNoThrow(mainContentElement, By.cssSelector(".widget-search"));
        postponedAssertNull(searchResultHeader, "Заголовок результатов поиска отображается");
        postponedAssertNull(searchResult, "Результаты поиска отображаются");
        return this;
    }

    private void clickRandomHint(WebElement searchResult) {
        List<WebElement> hints = searchResult.findElements(By.cssSelector(".ui-menu-item"));
        hints.remove(0);
        WebElement randomHint = getRandomElementInList(hints);
        setParameter(SearchResultHelper.HINT_TEXT, randomHint.getText());
        randomHint.click();
    }

    private void checkSearchBoxInWidget(WebElement widget, String widgetName, String textInSearchBox) {
        WebElement searchBox = widget.findElement(By.tagName("form"));
        postponedAssertTrue(searchBox.isEnabled() && searchBox.isDisplayed(), "Строка поиска в блоке '" + widgetName + "' не отображаетсяа");

        WebElement inputSearchBox = findElementByNoThrow(searchBox, By.id("widget-search--text"));
        assertNotNull(inputSearchBox, "Отсутствует строка поиска для блока '" + widgetName + "'");
        postponedAssertEquals(inputSearchBox.getAttribute("value"), textInSearchBox, "Неправильный текст в строке поиска для блока '" + widgetName + "'");

        WebElement submit = findElementByNoThrow(searchBox, By.cssSelector("[type='submit']"));
        assertNotNull(submit, "Отсутствует кнопка Найти в строке поиска для блока '" + widgetName + "'");
    }

    private void checkBlueBallIsPresent(WebElement widget, String widgetName) {
        WebElement blueBall = widget.findElement(By.cssSelector(".widget__update"));
        postponedAssertTrue(blueBall.isEnabled() && blueBall.isDisplayed(), "Синий шарик в блоке '" + widgetName + "' не отображается");
        postponedAssertFalse(blueBall.getText().isEmpty(), "Количество новых документов не отображается в 'Синем шарике' в блоке '" + widgetName + "'");
    }

    private String getActiveHeaderFromRubricator() {
        WebElement currentSection = getParentElement(getParentElement(findElementsBy(By.cssSelector(".b-link_state_active")).get(0)));
        int index = findElementsBy(By.cssSelector(".b-list_type_rubricator")).indexOf(currentSection);
        return findElementsBy(By.cssSelector(".b-rubricator-list__title-rubric")).get(index).getText();
    }

    @Step("Проверяется что баннер отображается")
    public KssAnswersPage checkBannerDefaultState() {
        WebElement banner = findElementByNoThrow(sidebarElement, By.cssSelector(".wrapper-advert"));
        if (banner != null) {
            WebElement bannerLink = findElementByNoThrow(banner, By.tagName("a"));
            postponedAssertTrue(banner.isDisplayed(), "Баннер не отображается");
            postponedAssertNotNull(bannerLink, "Не найдена ссылка в баннере");
            postponedAssertFalse(banner.getText().isEmpty(), "Отсутствует текст в баннере");
        } else {
            warning("Баннер Отсутствует. Проверка не проводилась.");
        }
        return this;
    }

    @Override
    public KssAnswersPage checkHandbookWidgetTitleIsPresent() {
        getHelper(HandbookWidget.class).checkTitleIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkHandbookWidgetDocumentCountIsPresent() {
        getHelper(HandbookWidget.class).checkDocumentCountIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkHandbookWidgetDateTodayIsPresent() {
        getHelper(HandbookWidget.class).checkDateTodayIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkHandbookWidgetMonthNowIsPresent() {
        getHelper(HandbookWidget.class).checkMonthNowIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkHandbookWidgetWorkingDaysElementIsPresent() {
        getHelper(HandbookWidget.class).checkWorkingDaysElementIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkHandbookWidgetHolidaysElementIsPresent() {
        getHelper(HandbookWidget.class).checkHolidaysElementIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkHandbookWidgetExchangeRatesTitleIsPresent() {
        getHelper(HandbookWidget.class).checkExchangeRatesTitleIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkHandbookWidgetDollarRateIsPresent() {
        getHelper(HandbookWidget.class).checkDollarRateIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkHandbookWidgetEuroRateIsPresent() {
        getHelper(HandbookWidget.class).checkEuroRateIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkHandbookWidgetMinimunWageTitleIsPresent() {
        getHelper(HandbookWidget.class).checkMinimunWageTitleIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkHandbookWidgetWageIsPresent() {
        getHelper(HandbookWidget.class).checkWageIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkHandbookWidgetLinkInRegionIsPresent() {
        getHelper(HandbookWidget.class).checkLinkInRegionIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkHandbookWidgetLinkRubricIsPresent() {
        getHelper(HandbookWidget.class).checkLinkRubricIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkHandbookWidgetChangesIsPresent() {
        getHelper(HandbookWidget.class).checkLinkChangesIsPresent();
        return this;
    }

    @Override
    public KssDictionaryPage clickOnHandbookWidgetTitle() {
        getHelper(HandbookWidget.class).clickOnTitle();
        return redirectTo(KssDictionaryPage.class);
    }

    @Override
    public KssDocumentPage clickOnHandbookWidgetCalendar() {
        getHelper(HandbookWidget.class).clickOnCalendar();
        return redirectTo(KssDocumentPage.class);
    }

    @Override
    public KssDocumentPage clickOnHandbookWidgetExchangeRatesBlock() {
        getHelper(HandbookWidget.class).clickOnExchangeRatesBlock();
        return redirectTo(KssDocumentPage.class);
    }

    @Override
    public KssDocumentPage clickOnHandbookWidgetRubricLink() {
        getHelper(HandbookWidget.class).clickOnRubricLink();
        return redirectTo(KssDocumentPage.class);
    }

    @Override
    public KssDocumentPage clickOnHandbookWidgetChangesLink() {
        getHelper(HandbookWidget.class).clickOnRubricLink();
        return redirectTo(KssDocumentPage.class);
    }

    private enum YellowPlateItem {

        laborRelations("Трудовые отношения"),
        accounting("Кадровый документооборот"),
        personal("Проверки", "Проверки инспекцией"),
        staff("Охрана труда"),
        law("Трудовые споры");

        private String headerInRubricator;
        private String linkName;

        private YellowPlateItem(String headerInRubricator, String linkName) {
            this.headerInRubricator = headerInRubricator;
            this.linkName = linkName;
        }

        private YellowPlateItem(String headerInRubricator) {
            this.headerInRubricator = headerInRubricator;
            this.linkName = headerInRubricator;
        }

        private String getHeaderInRubricator() {
            return headerInRubricator;
        }

        private String getLinkName() {
            return linkName;
        }

        public static YellowPlateItem getRubricatorName(String linkName) {
            for (YellowPlateItem rubricator : YellowPlateItem.values()) {
                if (rubricator.getLinkName().equals(linkName)) {
                    return rubricator;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    private enum DictionaryItem {
        calendary("Календари"),
        responsibility("Ответственность");

        private String headerInRubricator;
        private String linkName;

        private DictionaryItem(String headerInRubricator, String linkName) {
            this.headerInRubricator = headerInRubricator;
            this.linkName = linkName;
        }

        private DictionaryItem(String headerInRubricator) {
            this.headerInRubricator = headerInRubricator;
            this.linkName = headerInRubricator;
        }

        private String getHeaderInRubricator() {
            return headerInRubricator;
        }

        private String getLinkName() {
            return linkName;
        }

        public static DictionaryItem getRubricatorName(String linkName) {
            for (DictionaryItem rubricator : DictionaryItem.values()) {
                if (rubricator.getLinkName().equals(linkName)) {
                    return rubricator;
                }
            }
            throw new IllegalArgumentException();
        }

    }

    private TextField getTextFieldOnLawBaseBlock() {
        WebElement lawBaseWidget = waitForPresenceOfElementLocatedBy(By.id("widget-law-search-form"));
        return getWebElementWrapper(lawBaseWidget.findElement(By.id("widget-search--text"))).getTextField();
    }

    private TextField getTextFieldOnFormsBlock() {
        WebElement formsWidget = waitForPresenceOfElementLocatedBy(By.id("widget-forms-search-form"));
        return getWebElementWrapper(formsWidget.findElement(By.id("widget-search--text"))).getTextField();
    }

    private void checkHintsIsPresent(WebElement searchResult) {
        List<WebElement> hintsWith = searchResult.findElements(By.cssSelector(".hint-doc"));
        List<WebElement> hints = searchResult.findElements(By.cssSelector(".ui-menu-item"));
        postponedAssertFalse(hintsWith.isEmpty(), "Подсказки с переходом не найдены");
        for (WebElement hint : hints) {
            postponedAssertTrue(hint.isDisplayed(), "Подсказки не найдены");
        }
    }

    private void clickHintWithJump(WebElement searchResult) {
        WebElement hintsWith = searchResult.findElement(By.cssSelector(".hint-doc"));
        WebElement hintsWithJumpLink = hintsWith.findElement(By.tagName("a"));
        setParameter(SearchResultHelper.DOCUMENT_URL, hintsWithJumpLink.getAttribute("href"));
        hintsWithJumpLink.click();
    }

    private WebElement getYellowPlate() {
        return waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_note"), "'Желтая плашка' не найдена");
    }

    @Step("Открыть страницу газеты")
    public KssNewsPage clickNewsPaperHeaderLink() {
        waitForPresenceOfElementLocatedBy(By.cssSelector(".news .news__title a")).click();
        return redirectTo(KssNewsPage.class);
    }

    public KssAnswersPage checkYellowPanelSearchInputIsPresent() {
        getHelper(YellowPanel.class).checkSearchInputIsPresent();
        return this;
    }

    public KssAnswersPage checkYellowPanelSearchInputPlaceholderTextIsPresent() {
        getHelper(YellowPanel.class).checkSearchInputPlaceholderTextIsPresent();
        return this;
    }

    public KssAnswersPage checkYellowPanelTipIsPresent() {
        getHelper(YellowPanel.class).checkTipIsPresent();
        return this;
    }

    public KssAnswersPage checkYellowPanelTipQueryIsPresent() {
        getHelper(YellowPanel.class).checkTipQueryIsPresent();
        return this;
    }

    public KssAnswersPage checkYellowPanelAnswerIsPresent() {
        getHelper(YellowPanel.class).checkAnswerIsPresent();
        return this;
    }

    public KssAnswersPage checkYellowPanelLinkFromRecomendationIsPresent() {
        getHelper(YellowPanel.class).checkLinkFromRecomendationIsPresent();
        return this;
    }

    public KssAnswersPage checkYellowPanelRubricatorLinksArePresent() {
        getHelper(YellowPanel.class).checkRubricatorLinksArePresent();
        return this;
    }

    public KssDocumentPage clickOnYellowPanelLinkFromRecomendation() {
        getHelper(YellowPanel.class).clickOnLinkFromRecomendation();
        return redirectTo(KssDocumentPage.class);
    }

    @Override
    public KssAnswersPage checkNewsBlockFirstBlockTitleIsPresent() {
        getHelper(NewsBlock.class).checkFirstBlockTitleIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkNewsBlockNewsArePresent() {
        getHelper(NewsBlock.class).checkNewsArePresent();
        return this;
    }

    @Override
    public KssAnswersPage checkNewsBlockTodayTitleIsPresent() {
        getHelper(NewsBlock.class).checkTodayTitleIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkNewsBlockOnTheWeekTitleIsPresent() {
        getHelper(NewsBlock.class).checkOnTheWeekTitleIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkNewsBlockPerMonthTitleIsPresent() {
        getHelper(NewsBlock.class).checkPerMonthTitleIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkNewsBlockRecomendationNewsView() {
        getHelper(NewsBlock.class).checkRecomendationNewsView();
        return this;
    }

    @Override
    public KssAnswersPage checkNewsBlockNewsWithTypeArePresent() {
        getHelper(NewsBlock.class).checkNewsWithTypeArePresent();
        return this;
    }

    @Override
    public KssAnswersPage checkNewsBlockLinksAllNewsArePresent() {
        getHelper(NewsBlock.class).checkLinksAllNewsArePresent();
        return this;
    }

    @Override
    public KssAnswersPage checkNewsBlockNewsLinks() {
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

    @Override
    public KssNewsPage clickOnNewsBlockFirstBlockTitle() {
        getHelper(NewsBlock.class).clickOnFirstBlockTitle();
        return redirectTo(KssNewsPage.class);
    }

    @Override
    public KssNewsPage clickOnNewsBlockLinkAllNewsInFirstBlock() {
        getHelper(NewsBlock.class).clickOnLinkAllNewsInFirstBlock();
        return redirectTo(KssNewsPage.class);
    }

    @Override
    public KssNewsPage clickOnNewsBlockLinkAllNewsInSecondBlock() {
        getHelper(NewsBlock.class).clickOnLinkAllNewsInSecondBlock();
        return redirectTo(KssNewsPage.class);
    }

    @Override
    public KssAnswersPage clearAllBookmarks() {
        removeAllBookmarksFromMenu();
        return this;
    }

    @Override
    public KssAnswersPage checkFavoritesWidgetTitleIsPresent() {
        getHelper(FavoritesWidget.class).checkTitleIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkFavoritesWidgetTextFadeIsPresent() {
        getHelper(FavoritesWidget.class).checkTextFadeIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage addLinksToFavorites(String[][] documents) {
        try {
            TestUtils.addDocumentsToFavorites(documents, getDriver());
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Не удалось добавить ссылки в избранное" + e.getMessage());
        } catch (IOException e) {
            throw new IllegalStateException("Не удалось добавить ссылки в избранное" + e.getMessage());
        }
        return this;
    }

    @Override
    public KssAnswersPage checkFavoritesWidgetFiveLinksArePresent() {
        getHelper(FavoritesWidget.class).checkFiveLinksArePresent();
        return this;
    }

    @Override
    public KssDocumentPage clickOnFavoritesWidgetFirstDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnFirstDocumentLink();
        return redirectTo(KssDocumentPage.class);
    }

    @Override
    public KssDocumentPage clickOnFavoritesWidgetSecondDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnSecondDocumentLink();
        return redirectTo(KssDocumentPage.class);
    }

    @Override
    public KssDocumentPage clickOnFavoritesWidgetThirdDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnThirdDocumentLink();
        return redirectTo(KssDocumentPage.class);
    }

    @Override
    public KssDocumentPage clickOnFavoritesWidgetFourthDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnFourthDocumentLink();
        return redirectTo(KssDocumentPage.class);
    }

    @Override
    public KssDocumentPage clickOnFavoritesWidgetFifthDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnFifthDocumentLink();
        return redirectTo(KssDocumentPage.class);
    }

    @Override
    public KssAnswersPage clickOnFavoritesWidgetTitleLink() {
        getHelper(FavoritesWidget.class).clickOnFavoritesTitleLink();
        return this;
    }

    @Override
    public KssAnswersPage removeDocumentsFromFavorites() {
        try {
            TestUtils.removeDocumentsFromFavorites(getDriver());
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Не удалось добавить ссылки в избранное" + e.getMessage());
        } catch (IOException e) {
            throw new IllegalStateException("Не удалось добавить ссылки в избранное" + e.getMessage());
        }
        return this;
    }

    @Override
    public KssAnswersPage checkVideoWidgetHasNoTitle() {
        getHelper(VideoWidget.class).checkHasNoTitle();
        return this;
    }

    @Override
    public KssAnswersPage checkVideoWidgetScreenshotIsPresent() {
        getHelper(VideoWidget.class).checkScreenshotIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkVideoWidgetLink() {
        getHelper(VideoWidget.class).checkLink();
        return this;
    }

    @Override
    public KssAnswersPage checkVideoWidgetVideoDuration() {
        getHelper(VideoWidget.class).checkVideoDuration();
        return this;
    }

    @Override
    public KssDocumentPage clickOnVideoWidgetScreenshot() {
        getHelper(VideoWidget.class).clickOnScreenshot();
        return redirectTo(KssDocumentPage.class);
    }

    @Override
    public KssDocumentPage clickOnVideoWidgetLink() {
        getHelper(VideoWidget.class).clickOnLink();
        return redirectTo(KssDocumentPage.class);
    }

    @Override
    public KssAnswersPage checkLawBaseWidgetTitleIsPresent() {
        getHelper(LawBaseWidget.class).checkTitleIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkKodeksOrderInLawBaseBlock() {
        getHelper(LawBaseWidget.class).checkCodes();
        return this;
    }

    @Override
    public KssAnswersPage checkLawBaseWidgetSearchInputIsPresent() {
        getHelper(LawBaseWidget.class).checkSearchInputIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkLawBaseWidgetNewDocumentCounterIsPresent() {
        getHelper(LawBaseWidget.class).checkNewDocumentCounterIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkLawBaseWidgetLinksCodes() {
        getHelper(LawBaseWidget.class).checkLinksCodes();
        return this;
    }

    @Override
    public KssLawBasePage clickLawBaseWidgetLinkTitle() {
        getHelper(LawBaseWidget.class).clickLinkTitle();
        return redirectTo(KssLawBasePage.class);
    }

    @Override
    public KssLawBasePage clickLawBaseWidgetLinkNewDocumentCounter() {
        getHelper(LawBaseWidget.class).clickLinkNewDocumentCounter();
        return redirectTo(KssLawBasePage.class);
    }

    @Override
    public KssLawBasePage clickLawBaseWidgetLinkEnterIconOntoSearchInput() {
        getHelper(LawBaseWidget.class).clickLinkEnterIconOnSearchInput();
        return redirectTo(KssLawBasePage.class);
    }

    @Override
    public KssAnswersPage inputLawBaseWidgetInSearch(String query) {
        getHelper(LawBaseWidget.class).inputInSearch(query);
        return this;
    }

    @Override
    public KssAnswersPage checkLawBaseWidgetSearchResultsArePresent() {
        getHelper(LawBaseWidget.class).checkSearchResultsArePresent();
        return this;
    }

    @Override
    public KssDocumentPage clickLawBaseWidgetOnSearchResultsDirectDocument() {
        getHelper(LawBaseWidget.class).clickOnSearchResultsDirectDocument();
        return redirectTo(KssDocumentPage.class);
    }

    @Override
    public KssSearchResultPage clickLawBaseWidgetSearchResultsRandomHintLink() {
        getHelper(LawBaseWidget.class).clickSearchResultsRandomHintLink();
        return redirectTo(KssSearchResultPage.class);
    }

    @Override
    public KssSearchResultPage clickLawBaseWidgetIconEnterWithSearchQuery() {
        getHelper(LawBaseWidget.class).clickLinkEnterIconOnSearchInput();
        return redirectTo(KssSearchResultPage.class);
    }

    @Override
    public KssAnswersPage checkMagazinesWidgetTitleIsPresent() {
        getHelper(MagazinesWidget.class).checkTitleIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkMagazinesWidgetMagazinesCoversIsPresent() {
        getHelper(MagazinesWidget.class).checkMagazinesCoversIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkMagazinesWidgetMagazinesAreNotRepeated() {
        getHelper(MagazinesWidget.class).checkMagazinesAreNotRepeated();
        return this;
    }

    @Override
    public KssAnswersPage checkMagazinesWidgetRedMarkerIsPresent() {
        getHelper(MagazinesWidget.class).checkRedMarkerForNewMagazine();
        return this;
    }

    @Override
    public KssAnswersPage checkMagazinesWidgetTextNewMagazineIsPresent() {
        getHelper(MagazinesWidget.class).checkTextNewMagazineIsPresent();
        return this;
    }

    @Override
    public KssMagazinesPage clickOnMagazinesWidgetTitle() {
        getHelper(MagazinesWidget.class).clickOnTitle();
        return redirectTo(KssMagazinesPage.class);
    }

    @Override
    public KssDocumentPage clickOnMagazinesWidgetNotice() {
        getHelper(MagazinesWidget.class).clickOnNotice();
        return redirectTo(KssDocumentPage.class);
    }

    @Override
    public KssAnswersPage checkMagazinesWidgetMagazinesLinks() {
        getHelper(MagazinesWidget.class).checkMagazinesLinks();
        return this;
    }

    @Override
    public KssAnswersPage checkMagazinesWidgetMagazinesCoversWithVariantResolutions() {
        getHelper(MagazinesWidget.class).checkMagazinesCoversWithVariantResolutions();
        return this;
    }

    public KssAnswersPage checkBannerIsPresent() {
        getHelper(BannerBlock.class).checkWidgetIsPresent();
        return this;
    }

    public KssAnswersPage clickOnBanner() {
        getHelper(BannerBlock.class).clickOnBanner();
        return this;
    }

    public KssAnswersPage checkDocumentAfterClickingOnBanner() {
        String documentUrl = String.valueOf(getParameter(SearchResultHelper.DOCUMENT_URL));
        postponedAssertTrue(getDriver().getCurrentUrl().contains(documentUrl), "URL не совпадают, actual:" +
                getDriver().getCurrentUrl() + " expected:" + documentUrl);
        return this;
    }

    public KssAnswersPage checkBannerTextWithScreenResolution1024px() {
        getHelper(BannerBlock.class).checkBannerTextWithScreenResolution1024px();
        return this;
    }

    public KssAnswersPage checkBannerTextWithScreenResolution1280px() {
        getHelper(BannerBlock.class).checkBannerTextWithScreenResolution1280px();
        return this;
    }

    public KssAnswersPage checkBannerTextWithScreenResolution1366px() {
        getHelper(BannerBlock.class).checkBannerTextWithScreenResolution1366px();
        return this;
    }

    @Override
    public KssAnswersPage checkFormsWidgetTitleIsPresent() {
        getHelper(FormsWidget.class).checkTitleIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkFormsWidgetSearchInputIsPresent() {
        getHelper(FormsWidget.class).checkSearchInputIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkFormsWidgetNewDocumentCounterIsPresent() {
        getHelper(FormsWidget.class).checkNewDocumentCounterIsPresent();
        return this;
    }

    @Override
    public KssAnswersPage checkFormsWidgetExamplesFormsIsPresent() {
        getHelper(FormsWidget.class).checkExamplesFormsIsPresent();
        return this;
    }

    public KssDocumentPage clickFormsWidgetRedLink() {
        getHelper(FormsWidget.class).clickOnRedLink();
        return redirectTo(KssDocumentPage.class);
    }

    public KssDocumentPage clickFormsWidgetGreenLink() {
        getHelper(FormsWidget.class).clickOnGreenLink();
        return redirectTo(KssDocumentPage.class);
    }

    public KssDocumentPage clickFormsWidgetBlueLink() {
        getHelper(FormsWidget.class).clickOnBlueLink();
        return redirectTo(KssDocumentPage.class);
    }

    public KssDocumentPage clickFormsWidgetYellowLink() {
        getHelper(FormsWidget.class).clickOnYellowLink();
        return redirectTo(KssDocumentPage.class);
    }

    @Override
    public KssFormsPage clickFormsLink() {
        getHelper(FormsWidget.class).clickOnTitle();
        return redirectTo(KssFormsPage.class);
    }

    @Override
    public KssFormsPage clickFormsWidgetLinkNewDocumentCounter() {
        getHelper(FormsWidget.class).clickLinkNewDocumentCounter();
        return redirectTo(KssFormsPage.class);
    }

    @Override
    public KssFormsPage clickFormsWidgetLinkEnterIconOntoSearchInput() {
        getHelper(FormsWidget.class).clickLinkEnterIconOnSearchInput();
        return redirectTo(KssFormsPage.class);
    }

    @Override
    public KssAnswersPage inputFormsWidgetInSearch(String query) {
        getHelper(FormsWidget.class).inputInSearch(query);
        return this;
    }

    @Override
    public KssAnswersPage checkFormsWidgetSearchResultsArePresent() {
        getHelper(FormsWidget.class).checkSearchResultsArePresent();
        return this;
    }

    @Override
    public KssDocumentPage clickFormsWidgetOnSearchResultsDirectDocument() {
        getHelper(FormsWidget.class).clickOnSearchResultsDirectDocument();
        return redirectTo(KssDocumentPage.class);
    }

    @Override
    public KssSearchResultPage clickFormsWidgetSearchResultsRandomHintLink() {
        getHelper(FormsWidget.class).clickSearchResultsRandomHintLink();
        return redirectTo(KssSearchResultPage.class);
    }

    @Override
    public KssSearchResultPage clickFormsWidgetIconEnterWithSearchQuery() {
        getHelper(FormsWidget.class).clickLinkEnterIconOnSearchInput();
        return redirectTo(KssSearchResultPage.class);
    }

    public KssAnswersPage checkEstimatorsWidgetLinksArePresent() {
        getHelper(EstimatorWidget.class).checkFiveLinksArePresent();
        return this;
    }

    public KssAnswersPage checkEstimatorsCountIsPresent() {
        getHelper(EstimatorWidget.class).checkEstimatorsCountIsPresent();
        return this;
    }

    public KssDocumentPage clickOnEstimatorWidgetFirstEstimatorLink() {
        getHelper(EstimatorWidget.class).clickOnFirstEstimatorLink();
        return redirectTo(KssDocumentPage.class);
    }

    public KssDocumentPage clickOnEstimatorWidgetSecondEstimatorLink() {
        getHelper(EstimatorWidget.class).clickOnSecondEstimatorLink();
        return redirectTo(KssDocumentPage.class);
    }

    public KssDocumentPage clickOnEstimatorWidgetThirdEstimatorLink() {
        getHelper(EstimatorWidget.class).clickOnThirdEstimatorLink();
        return redirectTo(KssDocumentPage.class);
    }

    public KssDocumentPage clickOnEstimatorWidgetFourthEstimatorLink() {
        getHelper(EstimatorWidget.class).clickOnFourthEstimatorLink();
        return redirectTo(KssDocumentPage.class);
    }

    public KssDocumentPage clickOnEstimatorWidgetFifthEstimatorLink() {
        getHelper(EstimatorWidget.class).clickOnFifthEstimatorLink();
        return redirectTo(KssDocumentPage.class);
    }

    public KssServicesPage clickOnEstimatorsWidgetTitle() {
        getHelper(EstimatorWidget.class).clickOnTitle();
        return redirectTo(KssServicesPage.class);
    }

    @Override
    @Step("Проверяется что ссылка 'Написать Эксперту' не отображается")
    public KssAnswersPage checkHotLineLinkIsNotPresent() {
        postponedAssertNull(findElementByNoThrow(By.className("[href*='/#/hotline/']")), "Ссылка 'Написать Эксперту' отображается");
        return this;
    }
}
