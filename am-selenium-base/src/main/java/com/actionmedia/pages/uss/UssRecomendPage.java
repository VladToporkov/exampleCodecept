package com.actionmedia.pages.uss;

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
import java.util.*;

/**
 * User: n.tyukavkin
 * Date: 28.10.13
 * Time: 12:13
 */
@Component
public class UssRecomendPage extends UssBasePage<UssRecomendPage> implements IRecomendPage {

    @Step("Проверяются элементы на странице 'Ответы'")
    public UssRecomendPage checkDefaultStateRecomendPage() {
        checkRecomendTabIsSelected();
        checkSearchBoxIsPresentOnRecomendPage();
        checkNewsBlockIsPresent();
        checkYellowPlateIsPresent();
        checkLawBaseBlockIsPresent();
        checkFormsBlockIsPresent();
        checkVideosBlockIsPresent();
        checkDictionaryBlockIsPresent();
        checkWizardsBlockIsPresent();
        checkMagazinesAndBooksBlockIsPresent();
        checkMyFavoritesBlockIsPresent();
        checkAllRecomendRubricatorButtonIsPresent();
        checkMyFavoritesRubricatorButtonIsPresent();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Ответы'")
    public UssRecomendPage checkRecomendTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.RECOMEND);
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Ответы'")
    public UssRecomendPage checkSearchBoxIsPresentOnRecomendPage() {
        checkSearchBoxIsPresent("Поиск рекомендаций");
        return this;
    }

    @Override
    public UssRecomendPage checkYellowPanelIsPresent() {
        getHelper(YellowPanel.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkHandbookWidgetIsPresent() {
        getHelper(HandbookWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkFormsWidgetIsPresent() {
        getHelper(FormsWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkLawBaseWidgetIsPresent() {
        getHelper(LawBaseWidget.class).checkWidgetIsPresent();
        return this;
    }

    public UssRecomendPage checkAgreementsWidgetIsPresent() {
        getHelper(AgreementsWidget.class).checkWidgetIsPresent();
        return this;
    }

    public UssRecomendPage checkSeminarsWidgetIsPresent() {
        getHelper(SeminarsWidget.class).checkWidgetIsPresent();
        return this;
    }

    public UssRecomendPage checkWizardsWidgetIsPresent() {
        getHelper(WizardsWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkMagazinesWidgetIsPresent() {
        getHelper(MagazinesWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkVideoWidgetIsPresent() {
        getHelper(VideoWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkFavoritesWidgetIsPresent() {
        getHelper(FavoritesWidget.class).checkWidgetIsPresent();
        return this;
    }

    public UssRecomendPage checkFavoritesWidgetIsNotPresent() {
        getHelper(FavoritesWidget.class).checkWidgetIsNotPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkWorkingDaysWidgetIsPresent() {
        getHelper(WorkingDaysWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkWeekendDaysWidgetIsPresent() {
        getHelper(WeekendDaysWidget.class).checkWidgetIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkNewsBlockIsPresent() {
        getHelper(NewsBlock.class).checkWidgetIsPresent();
        return this;
    }

    @Step("Проверяется что 'Желтая плашка' отображается")
    public UssRecomendPage checkYellowPlateIsPresent() {
        WebElement yellowPlate = getYellowPlate();
        postponedAssertTrue(yellowPlate.isEnabled() && yellowPlate.isDisplayed(), "'Желтая плашка' не отображается");
        return this;
    }

    @Step("Проверяется что блок 'Правовая база' отображается")
    public UssRecomendPage checkLawBaseBlockIsPresent() {
        WebElement lawBaseBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_law"), "Блок 'Правовая база' не найден");
        postponedAssertTrue(lawBaseBlock.isEnabled() && lawBaseBlock.isDisplayed(), "Блок 'Правовая база' не отображается");
        return this;
    }

    @Step("Проверяется что блок 'Формы' отображается")
    public UssRecomendPage checkFormsBlockIsPresent() {
        WebElement formsBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_forms"), "Блок 'Формы' не найден");
        postponedAssertTrue(formsBlock.isEnabled() && formsBlock.isDisplayed(), "Блок 'Формы' не отображается");
        return this;
    }

    @Step("Проверяется что блок 'Видеосеминары' отображается")
    public UssRecomendPage checkVideosBlockIsPresent() {
        WebElement videosBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_videos"), "Блок 'Видеосеминары' не найден");
        postponedAssertTrue(videosBlock.isEnabled() && videosBlock.isDisplayed(), "Блок 'Видеосеминары' отображается");
        return this;
    }

    @Step("Проверяется что блок 'Справочник' отображается")
    public UssRecomendPage checkDictionaryBlockIsPresent() {
        WebElement dictionaryBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_handbook"), "Блок 'Справочник' не найден");
        postponedAssertTrue(dictionaryBlock.isEnabled() && dictionaryBlock.isDisplayed(), "Блок 'Справочник' не найден");
        return this;
    }

    @Step("Проверяется что блок 'Мастера' отображается")
    public UssRecomendPage checkWizardsBlockIsPresent() {
        WebElement wizardsBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_wizards"), "Блок 'Мастера' не найден");
        postponedAssertTrue(wizardsBlock.isEnabled() && wizardsBlock.isDisplayed(), "Блок 'Мастера' не отображается");
        return this;
    }

    @Step("Проверяется что блок 'Журналы и книги' отображается")
    public UssRecomendPage checkMagazinesAndBooksBlockIsPresent() {
        WebElement magazinesAdBooksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_press"), "Блок 'Журналы и книги' не найден");
        postponedAssertTrue(magazinesAdBooksBlock.isEnabled() && magazinesAdBooksBlock.isDisplayed(), "Блок 'Журналы и книги' не отображается");
        return this;
    }

    @Step("Проверяется что кнопка рубрикатора рекомендаций отображается")
    public UssRecomendPage checkAllRecomendRubricatorButtonIsPresent() {
        WebElement rubricatorButton = waitForPresenceOfElementLocatedBy(By.id("rubricator-btn"), "Кнопка 'Все рекомендации' Отсутствует");
        postponedAssertEquals(rubricatorButton.getText(), "Все рекомендации", "Неправильный текст кнопки 'Все рекомендации'");
        return this;
    }

    @Step("Проверяется что 'Желтая плашка' не пустая")
    public UssRecomendPage checkYellowPlateIsNotEmpty() {
        WebElement yellowPlate = getYellowPlate();

        WebElement question = findElementByNoThrow(yellowPlate, By.cssSelector(".widget__title"));
        postponedAssertTrue(question != null && question.isDisplayed() && !question.getText().isEmpty(), "Вопрос в 'Желтой плашке' пустой");

        WebElement answer = findElementByNoThrow(yellowPlate, By.cssSelector(".author-comment__text"));
        postponedAssertTrue(answer != null && answer.isDisplayed() && !answer.getText().isEmpty(), "Ответ в 'Желтой плашке' пустой");

        WebElement link = findElementByNoThrow(yellowPlate, By.cssSelector(".author-comment__source"));
        postponedAssertTrue(link != null && link.isDisplayed() && !link.getText().isEmpty(), "Ссылка на полный ответ не найдена");
        return this;
    }

    @Step("Проверяется работа ссылок в 'Желтой плашке'")
    public UssRecomendPage checkLinksOnYellowPlate() {
        WebElement source = getYellowPlate().findElement(By.cssSelector(".author-comment__source"));
        WebElement linkElement = source.findElement(By.cssSelector("[href*='#']"));
        String url = linkElement.getAttribute("href");
        String header = linkElement.getText();
        Link link = new Link(url, header);
        checkLinks(Arrays.asList(link));
        return this;
    }

    @Step("Проверяется работа ссылок на рубрикаторы из желтой плашки")
    public UssRecomendPage checkRubricatorLinksFromYellowPlate() {
        List<WebElement> rubricatorLinkList = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget__footer")).findElements(By.cssSelector(".link_type_rubric"));
        postponedAssertFalse(rubricatorLinkList.isEmpty(), "Ссылки на рубрикаторы в желтой плашки не найдены");
        for (WebElement rubricatorLink : rubricatorLinkList) {
            String rubricatorName = rubricatorLink.getText();
            report("Проверяется работа ссылки для '" + rubricatorName + "'");
            rubricatorLink.click();
            checkSelectedItemInRubricator(rubricatorName);
            waitForPresenceOfElementLocatedBy(By.id("rubricator-close")).click();
        }
        return this;
    }

    @Step("Проверяется что блок 'Правовая база' не пустой")
    public UssRecomendPage checkLawBaseBlockIsNotEmpty() {
        WebElement lawBaseBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_law"), "Блок 'Правовая база' не найден");
        List<WebElement> lawItemList = lawBaseBlock.findElements(By.tagName("li"));
        postponedAssertFalse(lawItemList.isEmpty(), "Блок 'Правовая база' пустой");
        for (WebElement lawItem : lawItemList) {
            postponedAssertTrue(lawItem.isDisplayed(), "Один из разделов в блоке 'Правовая база' не отображается");
        }
        return this;
    }

    @Step("Проверяется работа ссылок в блоке 'Правовая база'")
    public UssRecomendPage checkLinksInLawBaseBlock() {
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
    public UssRecomendPage checkLawBaseLinkIsOpenedLawBasePage() {
        WebElement lawBaseBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_law"), "Блок 'Правовая база' не найден");
        WebElement lawBaseLink = lawBaseBlock.findElement(By.cssSelector(".widget__title-text"));
        lawBaseLink.click();
        return redirectTo(UssLawBasePage.class)
                .checkDefaultStateLawBasePage()
                .navigateToRecomendPage();
    }

    @Step("Проверяется что блок 'Формы' не пустой")
    public UssRecomendPage checkFormsBlockIsNotEmpty() {
        WebElement formsBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_forms"), "Блок 'Формы' не найден");
        List<WebElement> formItemList = formsBlock.findElements(By.tagName("li"));
        postponedAssertFalse(formItemList.isEmpty(), "Блок 'Формы' пустой");
        for (WebElement formItem : formItemList) {
            postponedAssertTrue(formItem.isDisplayed() && !formItem.getText().isEmpty(), "Отсуствует раздел в блоке 'Формы'");
        }
        return this;
    }

    @Step("Проверяется что ссылка в блоке 'Формы' работает")
    public UssRecomendPage checkRubricatorLinksFromFormsBlock() {
        WebElement formsBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_forms"), "Блок 'Формы' не найден");
        List<WebElement> rubricatorLinkList = formsBlock.findElements(By.cssSelector(".link_type_rubric"));
        postponedAssertFalse(rubricatorLinkList.isEmpty(), "Ссылки на рубрикаторы в блоке Формы не найдены");
        for (WebElement rubricatorLink : rubricatorLinkList) {
            String rubricatorName = rubricatorLink.getText();
            report("Проверяется работа ссылки для '" + rubricatorName + "'");
            rubricatorLink.click();
            WebElement rubricator = waitForVisibilityOfElementLocatedBy(By.id("rubricator"), "Рубрикатор для '" + rubricatorName + "' не отображается");
            waitForTextToBePresentIn(rubricator);
            WebElement activeItem = findElementByNoThrow(rubricator, By.cssSelector(".b-link_state_active"));
            assertNotNull(activeItem, "Не один элемент в рурикаторе форм не выбран");
            String btnName = waitForPresenceOfElementLocatedBy(By.id("rubricator-btn")).getText();
            postponedAssertEquals(btnName, "Все формы", "Название кнопки рубрикатора не изменилось");
            waitForPresenceOfElementLocatedBy(By.id("rubricator-close")).click();
        }
        return this;
    }

    @Step("Проверяется работа ссылки 'Формы'")
    public UssRecomendPage checkFormsLinkIsOpenedFormsPage() {
        WebElement formsBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_forms"), "Блок 'Формы' не найден");
        WebElement formsLink = formsBlock.findElement(By.cssSelector(".widget__title-text"));
        formsLink.click();
        return redirectTo(UssFormsPage.class)
                .checkDefaultStateFormsPage()
                .navigateToRecomendPage();
    }

    @Step("Проверяется что блок 'Видеосеминары' не пустой")
    public UssRecomendPage checkVideoPreviewIsPresent() {
        WebElement videosBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_videos"), "Блок 'Видео' не найден");
        WebElement videoPreview = findElementByNoThrow(videosBlock, By.cssSelector(".video__image"));
        postponedAssertNotNull(videoPreview, "Bидеопревью в блоке 'Видео' не найдено");
        if (videoPreview != null) {
            assertTrue(videoPreview.getTagName().equals("a"), "Ссылка для видео не найдена");
            assertNotNull(videoPreview.getAttribute("style"), "Фон для видео не отображается");
            postponedAssertTrue(videoPreview.getAttribute("style").contains("background-image:") && videoPreview.getAttribute("style").contains("system/content/feature/image/"), "Фон для видео не отображается");
        }
        return this;
    }

    @Step("Проверяется что ссылка в блоке 'Видеосеминары' ведет на соответствующий видеосеминар")
    public UssRecomendPage checkVideoLink() {
        WebElement videosBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_videos"), "Блок 'Видеосеминары' не найден");
        WebElement videoPreview = videosBlock.findElement(By.cssSelector(".video__image"));
        String url = videoPreview.getAttribute("href");
        Link link = new Link(url);
        checkLinks(Arrays.asList(link));
        return this;
    }

    @Step("Проверяется работа ссылки 'Видеосеминары'")
    public UssRecomendPage checkVideosLinkIsOpenedVideosPage() {
        WebElement videosBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_videos"), "Блок 'Видеосеминары' не найден");
        WebElement videosLink = videosBlock.findElement(By.cssSelector(".widget__title-text"));
        videosLink.click();
        return redirectTo(UssVideosPage.class)
                .checkDefaultStateVideoPage()
                .navigateToRecomendPage();
    }

    @Step("Проверяется что блок 'Журналы и книги' не пустой")
    public UssRecomendPage checkMagazinesAndBooksBlockIsNotEmpty() {
        WebElement magazinesAdBooksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_press"), "Блок 'Журналы и книги' не найден");
        List<WebElement> magazines = magazinesAdBooksBlock.findElements(By.tagName("li"));
        postponedAssertFalse(magazines.isEmpty(), "Блок 'Журналы и книги' пустой");
        for (WebElement magazine : magazines) {
            assertNotNull(findElementByNoThrow(magazine, By.tagName("a")), "Отсутствует ссылка для журнала");
            assertNotNull(findElementByNoThrow(magazine, By.tagName("img")), "Отсутствует картинка для журнала");
        }
        return this;
    }

    @Step("Проверяется что Журналы/книги не повторяются")
    public UssRecomendPage checkMagazinesAreNotRepeated() {
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

    @Step("Проверяется работа ссылок в блоке 'Журналы и книги'")
    public UssRecomendPage checkLinksInMagazineBlock() {
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
    public UssRecomendPage checkMagazinesLinkIsOpenedMagazinesPage() {
        WebElement magazinesAdBooksBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_press"), "Блок 'Журналы и книги' не найден");
        WebElement magazineLink = magazinesAdBooksBlock.findElement(By.cssSelector(".widget__title-text"));
        magazineLink.click();
        return redirectTo(UssMagazinesPage.class)
                .checkMagazineTabIsSelected()
                .checkSearchBoxIsPresentOnMagazinePage()
                .checkNewBookAndMagazinesBlockIsPresent()
                .checkCommentariesBlockIsPresent()
                .checkBooksBlockIsPresent()
                .checkMagazinesBlockIsPresent()
                .navigateToRecomendPage();
    }

    @Step("Проверяется что блок 'Мастера' не пустой")
    public UssRecomendPage checkWizardsBlockIsNotEmpty() {
        WebElement wizardsBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_wizards"), "Блок 'Мастера' не найден");
        List<WebElement> wizards = wizardsBlock.findElements(By.tagName("li"));
        postponedAssertFalse(wizards.isEmpty(), "Блок 'Мастера' пустой");
        for (WebElement wizard : wizards) {
            assertNotNull(findElementByNoThrow(wizard, By.tagName("a")), "Отсутствует ссылка для 'Мастера'");
            postponedAssertFalse(wizard.getText().isEmpty(), "Текст ссылки пустой");
        }
        return this;
    }

    @Step("Проверяется работа ссылок в блоке 'Мастера'")
    public UssRecomendPage checkLinksInWizardsBlock() {
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
    public UssRecomendPage checkLinkInWizardsBlockIsOpenedServicesPage() {
        WebElement wizardsBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_wizards"), "Блок 'Мастера' не найден");
        WebElement wizardLink = wizardsBlock.findElement(By.cssSelector(".widget__title-text"));
        wizardLink.click();
        return redirectTo(UssServicesPage.class)
                .checkDefaultStateServicesPage()
                .navigateToRecomendPage();
    }

    @Step("Проверяется что блок 'Справочник' не пустой")
    public UssRecomendPage checkDictionaryBlockIsNotEmpty() {
        WebElement dictionaryBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_handbook"), "Блок 'Справочник' не найден");
        List<WebElement> dictionaryLinks = dictionaryBlock.findElement(By.cssSelector(".list")).findElements(By.tagName("li"));
        postponedAssertFalse(dictionaryLinks.isEmpty(), "Блок 'Справочник' пустой");
        return this;
    }

    @Step("Проверяется что курс валют в блоке 'Справочник' отображается")
    public UssRecomendPage checkCurrencyInDictionaryBlockIsPresent() {
        WebElement dictionaryBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_handbook"), "Блок 'Справочник' не найден");
        WebElement currency = findElementByNoThrow(dictionaryBlock, By.cssSelector(".list__item_viewtype_green"));
        assertNotNull(currency != null, "Курс валют не отображается в блоке 'Справочник'");
        if (currency != null) {
            WebElement usd = findElementByNoThrow(currency, By.cssSelector(".list__text_content_usd"));
            WebElement eur = findElementByNoThrow(currency, By.cssSelector(".list__text_content_eur"));
            postponedAssertTrue(usd != null && usd.isDisplayed() && !usd.getText().isEmpty(), "Отсутствует курс для доллра в блоке 'Справочник'");
            postponedAssertTrue(eur != null && eur.isDisplayed() && !eur.getText().isEmpty(), "Отсутствует курс для евро в блоке 'Справочник'");
        }
        return this;
    }

    @Step("Проверяется работа ссылок в блоке 'Справочник'")
    public UssRecomendPage checkLinksInDictionaryBlock() {
        WebElement dictionaryBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_handbook"), "Блок 'Справочник' не найден");
        List<WebElement> dictionaryLinks = dictionaryBlock.findElement(By.cssSelector(".list")).findElements(By.tagName("li"));
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement dictionaryLink : dictionaryLinks) {
            if ("Адреса и телефоны судов".equals(dictionaryLink.getText())) {
                continue;
            }
            String url = dictionaryLink.findElement(By.tagName("a")).getAttribute("href");
            String header = dictionaryLink.findElement(By.tagName("a")).getText();
            Link link = new Link(url, header);
            linkList.add(link);
        }
        checkLinks(linkList);
        return this;
    }

    @Step("Проверяется работа ссылки 'Справочник'")
    public UssRecomendPage checkLinkInDictionaryBlockIsOpenedDictionaryPage() {
        WebElement dictionaryBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_handbook"), "Блок 'Справочник' не найден");
        WebElement dictionaryLink = dictionaryBlock.findElement(By.cssSelector(".widget__title-text"));
        dictionaryLink.click();
        return redirectTo(UssDictionaryPage.class)
                .checkDefaultStateDictionaryPage()
                .navigateToRecomendPage();
    }

    @Step("Проверяется что блок 'Избранное' отображается для авторизованного пользователя")
    public UssRecomendPage checkMyFavoritesBlockIsPresent() {
        if (isUserLogged()) {
            WebElement myFavoritesBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_bookmarks"), "Блок 'Избранное' не найден");
            postponedAssertTrue(myFavoritesBlock.isEnabled() && myFavoritesBlock.isDisplayed(), "Блок 'Избранное' не отображается для авторизованного пользователя");
        }
        return this;
    }

    @Step("Проверяется что блок 'Избранное' не отображается для не авторизованного пользователя")
    public UssRecomendPage checkMyFavoritesBlockIsAbsent() {
        if (!isUserLogged()) {
            WebElement myFavoritesBlock = findElementByNoThrow(mainLeftElement, By.cssSelector(".widget_content_bookmarks"));
            if (myFavoritesBlock != null) {
                postponedAssertFalse(myFavoritesBlock.isDisplayed(), "Блок 'Избранное' отображается для не авторизованного пользователя");
            }
        }
        return this;
    }

    @Step("Проверяется надпись в пустом блоке Избранное")
    public UssRecomendPage checkEmptyMyFavoritesBlock() {
        WebElement myFavoritesBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_bookmarks"), "Блок 'Избранное' не найден");
        WebElement myFavoritesListElement = myFavoritesBlock.findElement(By.cssSelector(".list"));
        WebElement emptyList = findElementByNoThrow(myFavoritesListElement, By.tagName("li"));
        assertNotNull(emptyList, "Не найдена надпись 'Вы ещe не добавили ни одного документа' в пустом блоке Избранное");
        postponedAssertEquals(emptyList.getText(), "Вы ещё не добавили ни одного документа.", "Неправильная надпись в пустом блоке Избранное");
        return this;
    }

    @Step("Проверяется блок 'Избранное' с добавленными закладками")
    public UssRecomendPage checkIsNotEmptyMyFavoritesBlock() {
        refreshPage();
        WebElement myFavoritesBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_bookmarks"), "Блок 'Избранное' не найден");
        WebElement myFavoritesListElement = myFavoritesBlock.findElement(By.cssSelector(".list"));
        List<WebElement> bookmarks = myFavoritesListElement.findElements(By.tagName("a"));
        postponedAssertFalse(bookmarks.isEmpty(), "Блок 'Избранное' пустой");
        for (WebElement bookmark : bookmarks) {
            postponedAssertTrue(bookmark.getAttribute("href") != null && !bookmark.getText().isEmpty(), "Текст ссылки для закладки пустой");
        }
        return this;
    }

    @Step("Проверяется что ссылка 'Избранное' открывает меню избранного")
    public UssRecomendPage checkMyFavoritesLinksIsOpenedMyFavoritesMenu() {
        WebElement myFavoritesBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_bookmarks"), "Блок 'Избранное' не найден");
        myFavoritesBlock.findElement(By.cssSelector(".widget__title-text")).click();

        WebElement myFavoritesMenu = waitForVisibilityOfElementLocatedBy(By.id("main-bookmarks"), "Меню 'Избранное' не отображается");
        waitForTextToBePresentIn(myFavoritesMenu, "Избранное");
        postponedAssertTrue(myFavoritesMenu.isEnabled() && myFavoritesMenu.isDisplayed() && !myFavoritesMenu.getText().isEmpty(), "Меню 'Избранное' не отображается");

        myFavoritesBlock.click();
        return this;
    }

    @Step("Проверяется что меню 'Избранное' пустое")
    public UssRecomendPage checkMyFavoritesMenuIsEmpty() {
        WebElement myFavoritesBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_bookmarks"), "Блок 'Избранное' не найден");
        WebElement myFavoritesLink = myFavoritesBlock.findElement(By.cssSelector(".widget__title-text"));
        myFavoritesLink.click();

        WebElement menuContent = waitForVisibilityOfElementLocatedBy(By.id("main-bookmarks"), "Меню 'Избранное' не отображается");
        waitForTextToBePresentIn(menuContent, "Избранное");
        postponedAssertNull(findElementByNoThrow(menuContent, By.cssSelector(".b-info__title-text")), "Отображаются закладки в пустом меню Избранное");
        myFavoritesBlock.click();
        return this;
    }

    @Step("Проверяется что меню 'Избранное' не пустое")
    public UssRecomendPage checkMyFavoritesMenuIsNotEmpty() {
        WebElement myFavoritesBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_bookmarks"), "Блок 'Избранное' не найден");
        WebElement myFavoritesLink = myFavoritesBlock.findElement(By.cssSelector(".widget__title-text"));
        myFavoritesLink.click();

        WebElement menuContent = waitForVisibilityOfElementLocatedBy(By.id("my-documents-bookmarks"), "Меню 'Избранное' не отображается");
        waitForTextToBePresentIn(menuContent, "Избранное");
        List<WebElement> bookmarks = menuContent.findElements(By.cssSelector(".b-info__title-text"));
        postponedAssertFalse(bookmarks.isEmpty(), "Меню 'Избранное' пустое");
        for (WebElement bookmark : bookmarks) {
            postponedAssertTrue(bookmark.getAttribute("href") != null && !bookmark.getText().isEmpty(), "Текст ссылки для закладки пустой");
        }
        myFavoritesBlock.click();
        return this;
    }

    @Step("Проверяется работа ссылок в блоке Избранное")
    public UssRecomendPage checkLinkInMyFavoritesBlock() {
        WebElement myFavoritesBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_bookmarks"), "Блок 'Избранное' не найден");
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

    @Step("Проверяется что блок 'Новое в работе' не пустой")
    public UssRecomendPage checkNewsBlockIsNotEmpty() {
        List<WebElement> newsList = sidebarElement.findElements(By.cssSelector(".news__item"));
        postponedAssertFalse(newsList.isEmpty(), "Блок 'Новое в работе' пустой");
        for (WebElement newItem : newsList) {
            postponedAssertTrue(newItem.isDisplayed() && !newItem.getText().isEmpty(), "Новость в блоке 'Новое в работе' пустая");
        }
        return this;
    }

    @Step("Проверяется что новости в блоке 'Новое в работе' не повторяются")
    public UssRecomendPage checkNewsIsNotRepeated() {
        List<WebElement> elementList = sidebarElement.findElements(By.cssSelector(".news__item"));
        Map<String, List<String>> newsBlockMap = new HashMap<String, List<String>>();
        for (int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).getAttribute("class").contains("newspaper-date")) {
                String date = elementList.get(i).getText();
                List<String> newsBlockForDate = new ArrayList<String>();
                while (i + 1 < elementList.size() && !elementList.get(i + 1).getAttribute("class").contains("newspaper-date")) {
                    if (elementList.get(i).getAttribute("class").contains("newspaper-item")) {
                        newsBlockForDate.add(elementList.get(i).getText());
                    }
                    i++;
                }
                postponedAssertFalse(newsBlockMap.containsValue(newsBlockForDate), "Блок новостей за '" + date + "' повторяется");
                newsBlockMap.put(date, newsBlockForDate);
            }
        }
        return this;
    }

    @Step("Пороверяется работы ссылок в блоке 'Новое в работе'")
    public UssRecomendPage checkLinksInNewsBlock() {
        List<WebElement> newsList = getRandomElementsInList(sidebarElement.findElements(By.cssSelector(".news__item")), 5);
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement newsItem : newsList) {
            String url = newsItem.findElement(By.tagName("a")).getAttribute("href");
            linkList.add(new Link(url));
        }
        checkLinks(linkList);
        return this;
    }

    @Step("Проверяется что ссылки 'Новое у юристов' работает")
    public UssRecomendPage checkNewsPageLinkIsOpenedNewsPage() {
        WebElement newsPageLink = sidebarElement.findElement(By.tagName("h2")).findElement(By.tagName("a"));

        newsPageLink.click();
        waitForReloadingPage();

        postponedAssertTrue(getCurrentUrl().contains(getCurrentHost() + "/#/news/"), "Неправильный урл раздела 'Новости'");
        WebElement newsPaper = waitForPresenceOfElementLocatedBy(By.id("newspaper"), "Не найдены элементы раздела 'Новости'");
        postponedAssertTrue(newsPaper.isEnabled() && newsPaper.isDisplayed(), "Раздел 'Новости' не отображается");
        postponedAssertFalse(newsPaper.getText().isEmpty(), "Раздел 'Новости' пустой");
        return this;
    }

    @Step("Проверяется работа скролла в газете")
    public UssRecomendPage checkNewsPaperScrolling() {
        WebElement newsPaper = waitForVisibilityOfElementLocatedBy(By.cssSelector(".main-sidebar-content"), "Газета не найдена");
        List<WebElement> newsBeforeScroll = newsPaper.findElements(By.cssSelector(".newspaper-item"));
        postponedAssertFalse(newsBeforeScroll.isEmpty(), "Отсутсвуют новости в газете");

        scroll(Period.twoWeeks, By.cssSelector(".newspaper-date"));

        List<WebElement> newsAfterScroll = newsPaper.findElements(By.cssSelector(".newspaper-item"));
        postponedAssertTrue(newsAfterScroll.size() > newsBeforeScroll.size(), "Новости не подгружаются после скролла");
        return this;
    }

    @Step("Проверяется что Меню поиск в тексте отображается в поисковой строке")
    public UssRecomendPage checkSearchInTextElementIsPresentOnAnswersPage() {
        WebElement searchBox = waitForPresenceOfElementLocatedBy(By.id("search-form"));
        WebElement searchIn = findElementByNoThrow(searchBox, By.cssSelector(".search-in"));
        assertNotNull(searchIn, "Меню Поиск в тексте не найден");
        waitForTextToBePresentIn(searchIn, "текст");
        postponedAssertEquals(searchIn.findElement(By.cssSelector(".msg")).getText(), "Поиск в тексте", "Неправильный текст меню Поиск в тексте");
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются")
    public UssRecomendPage checkHintsIsPresentOnYellowPlate() {
        checkHintListIsPresent();
        return this;
    }

    @Step("Нажать подсказку с прямым переходом")
    public UssSearchResultPage clickHintWithJumpOnYellowPlate() {
        clickHintWithJump();
        return redirectTo(UssSearchResultPage.class);
    }

    @Step("Нажать любую подсказку с переходом")
    public UssSearchResultPage clickRandomHintOnYellowPlate() {
        clickRandomHint();
        return redirectTo(UssSearchResultPage.class);
    }

    @Step("Проверяется что результаты поиска отсутсвуют")
    public UssRecomendPage checkSearchResultIsNotPresentOnAnswersPage() {
        WebElement searchResultHeader = findElementByNoThrow(mainContentElement, By.cssSelector(".search-result"));
        WebElement searchResult = findElementByNoThrow(mainContentElement, By.cssSelector(".widget-search"));
        postponedAssertNull(searchResultHeader, "Заголовок результатов поиска отображается");
        postponedAssertNull(searchResult, "Результаты поиска отображаются");
        return this;
    }

    @Step("Проверяется работа кнопки найти")
    public UssRecomendPage checkSearchButtonFunctionalityOnSearchBox(String query) {
        setParameter(SearchResultHelper.HINT_TEXT, query);
        return clearSearchBox()
                .clickSearchButton()
                .checkRecomendTabIsSelected()
                .checkSearchResultIsNotPresentOnAnswersPage()

                .clearSearchBox()
                .inputTextInSearchBox(query)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnRecomendPageIsOpened()
                .navigateToRecomendPage();
    }

    @Step("Открыть страницу Новое в работе")
    public UssNewsPage clickNewsLink() {
        sidebarElement.findElement(By.tagName("h2")).findElement(By.tagName("a")).click();
        return redirectTo(UssNewsPage.class);
    }

    @Step("Открыть документ из желтой плашки")
    public UssRecomendPage clickDocumentLinkFromYellowPlate() {
        WebElement source = getYellowPlate().findElement(By.cssSelector(".author-comment__source"));
        WebElement linkElement = source.findElement(By.cssSelector("[href*='#']"));
        linkElement.click();
        waitForReloadingPage();
        return this;
    }

    private WebElement getYellowPlate() {
        return waitForPresenceOfElementLocatedBy(By.cssSelector(".widget_content_note"), "'Желтая плашка' не найдена");
    }

    @Step("Открыть страницу газеты")
    public UssNewsPage clickNewsPaperHeaderLink() {
        waitForPresenceOfElementLocatedBy(By.cssSelector(".news .news__title a")).click();
        return redirectTo(UssNewsPage.class);
    }

    @Override
    public UssRecomendPage checkHandbookWidgetTitleIsPresent() {
        getHelper(HandbookWidget.class).checkTitleIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkHandbookWidgetDocumentCountIsPresent() {
        getHelper(HandbookWidget.class).checkDocumentCountIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkHandbookWidgetDateTodayIsPresent() {
        getHelper(HandbookWidget.class).checkDateTodayIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkHandbookWidgetMonthNowIsPresent() {
        getHelper(HandbookWidget.class).checkMonthNowIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkHandbookWidgetWorkingDaysElementIsPresent() {
        getHelper(HandbookWidget.class).checkWorkingDaysElementIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkHandbookWidgetHolidaysElementIsPresent() {
        getHelper(HandbookWidget.class).checkHolidaysElementIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkHandbookWidgetExchangeRatesTitleIsPresent() {
        getHelper(HandbookWidget.class).checkExchangeRatesTitleIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkHandbookWidgetDollarRateIsPresent() {
        getHelper(HandbookWidget.class).checkDollarRateIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkHandbookWidgetEuroRateIsPresent() {
        getHelper(HandbookWidget.class).checkEuroRateIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkHandbookWidgetMinimunWageTitleIsPresent() {
        getHelper(HandbookWidget.class).checkMinimunWageTitleIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkHandbookWidgetWageIsPresent() {
        getHelper(HandbookWidget.class).checkWageIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkHandbookWidgetLinkInRegionIsPresent() {
        getHelper(HandbookWidget.class).checkLinkInRegionIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkHandbookWidgetLinkRubricIsPresent() {
        getHelper(HandbookWidget.class).checkLinkRubricIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkHandbookWidgetChangesIsPresent() {
        getHelper(HandbookWidget.class).checkLinkChangesIsPresent();
        return this;
    }

    @Override
    public UssDictionaryPage clickOnHandbookWidgetTitle() {
        getHelper(HandbookWidget.class).clickOnTitle();
        return redirectTo(UssDictionaryPage.class);
    }

    @Override
    public UssDocumentPage clickOnHandbookWidgetCalendar() {
        getHelper(HandbookWidget.class).clickOnCalendar();
        return redirectTo(UssDocumentPage.class);
    }

    @Override
    public UssDocumentPage clickOnHandbookWidgetExchangeRatesBlock() {
        getHelper(HandbookWidget.class).clickOnExchangeRatesBlock();
        return redirectTo(UssDocumentPage.class);
    }

    @Override
    public UssDocumentPage clickOnHandbookWidgetRubricLink() {
        getHelper(HandbookWidget.class).clickOnRubricLink();
        return redirectTo(UssDocumentPage.class);
    }

    @Override
    public UssDocumentPage clickOnHandbookWidgetChangesLink() {
        getHelper(HandbookWidget.class).clickOnRubricLink();
        return redirectTo(UssDocumentPage.class);
    }

    public UssRecomendPage checkYellowPanelSearchInputIsPresent() {
        getHelper(YellowPanel.class).checkSearchInputIsPresent();
        return this;
    }

    public UssRecomendPage checkYellowPanelSearchInputPlaceholderTextIsPresent() {
        getHelper(YellowPanel.class).checkSearchInputPlaceholderTextIsPresent();
        return this;
    }

    public UssRecomendPage checkYellowPanelTipIsPresent() {
        getHelper(YellowPanel.class).checkTipIsPresent();
        return this;
    }

    public UssRecomendPage checkYellowPanelTipQueryIsPresent() {
        getHelper(YellowPanel.class).checkTipQueryIsPresent();
        return this;
    }

    public UssRecomendPage checkYellowPanelAnswerIsPresent() {
        getHelper(YellowPanel.class).checkAnswerIsPresent();
        return this;
    }

    public UssRecomendPage checkYellowPanelLinkFromRecomendationIsPresent() {
        getHelper(YellowPanel.class).checkLinkFromRecomendationIsPresent();
        return this;
    }

    public UssRecomendPage checkYellowPanelRubricatorLinksArePresent() {
        getHelper(YellowPanel.class).checkRubricatorLinksArePresent();
        return this;
    }

    public UssDocumentPage clickOnYellowPanelLinkFromRecomendation() {
        getHelper(YellowPanel.class).clickOnLinkFromRecomendation();
        return redirectTo(UssDocumentPage.class);
    }

    @Override
    public UssRecomendPage checkNewsBlockFirstBlockTitleIsPresent() {
        getHelper(NewsBlock.class).checkFirstBlockTitleIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkNewsBlockNewsArePresent() {
        getHelper(NewsBlock.class).checkNewsArePresent();
        return this;
    }

    @Override
    public UssRecomendPage checkNewsBlockTodayTitleIsPresent() {
        getHelper(NewsBlock.class).checkTodayTitleIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkNewsBlockOnTheWeekTitleIsPresent() {
        getHelper(NewsBlock.class).checkOnTheWeekTitleIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkNewsBlockPerMonthTitleIsPresent() {
        getHelper(NewsBlock.class).checkPerMonthTitleIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkNewsBlockRecomendationNewsView() {
        getHelper(NewsBlock.class).checkRecomendationNewsView();
        return this;
    }

    @Override
    public UssRecomendPage checkNewsBlockNewsWithTypeArePresent() {
        getHelper(NewsBlock.class).checkNewsWithTypeArePresent();
        return this;
    }

    @Override
    public UssRecomendPage checkNewsBlockLinksAllNewsArePresent() {
        getHelper(NewsBlock.class).checkLinksAllNewsArePresent();
        return this;
    }

    @Override
    public UssRecomendPage checkNewsBlockNewsLinks() {
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
    public UssNewsPage clickOnNewsBlockFirstBlockTitle() {
        getHelper(NewsBlock.class).clickOnFirstBlockTitle();
        return redirectTo(UssNewsPage.class);
    }

    @Override
    public UssNewsPage clickOnNewsBlockLinkAllNewsInFirstBlock() {
        getHelper(NewsBlock.class).clickOnLinkAllNewsInFirstBlock();
        return redirectTo(UssNewsPage.class);
    }

    @Override
    public UssNewsPage clickOnNewsBlockLinkAllNewsInSecondBlock() {
        getHelper(NewsBlock.class).clickOnLinkAllNewsInSecondBlock();
        return redirectTo(UssNewsPage.class);
    }

    @Override
    public UssRecomendPage clearAllBookmarks() {
        removeAllBookmarksFromMenu();
        return this;
    }

    @Override
    public UssRecomendPage checkFavoritesWidgetTitleIsPresent() {
        getHelper(FavoritesWidget.class).checkTitleIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkFavoritesWidgetTextFadeIsPresent() {
        getHelper(FavoritesWidget.class).checkTextFadeIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage addLinksToFavorites(String[][] documents) {
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
    public UssRecomendPage checkFavoritesWidgetFiveLinksArePresent() {
        getHelper(FavoritesWidget.class).checkFiveLinksArePresent();
        return this;
    }

    @Override
    public UssDocumentPage clickOnFavoritesWidgetFirstDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnFirstDocumentLink();
        return redirectTo(UssDocumentPage.class);
    }

    @Override
    public UssDocumentPage clickOnFavoritesWidgetSecondDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnSecondDocumentLink();
        return redirectTo(UssDocumentPage.class);
    }

    @Override
    public UssDocumentPage clickOnFavoritesWidgetThirdDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnThirdDocumentLink();
        return redirectTo(UssDocumentPage.class);
    }

    @Override
    public UssDocumentPage clickOnFavoritesWidgetFourthDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnFourthDocumentLink();
        return redirectTo(UssDocumentPage.class);
    }

    @Override
    public UssDocumentPage clickOnFavoritesWidgetFifthDocumentLink() {
        getHelper(FavoritesWidget.class).clickOnFifthDocumentLink();
        return redirectTo(UssDocumentPage.class);
    }

    @Override
    public UssRecomendPage clickOnFavoritesWidgetTitleLink() {
        getHelper(FavoritesWidget.class).clickOnFavoritesTitleLink();
        return this;
    }

    @Override
    public UssRecomendPage removeDocumentsFromFavorites() {
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
    public UssRecomendPage checkVideoWidgetHasNoTitle() {
        getHelper(VideoWidget.class).checkHasNoTitle();
        return this;
    }

    @Override
    public UssRecomendPage checkVideoWidgetScreenshotIsPresent() {
        getHelper(VideoWidget.class).checkScreenshotIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkVideoWidgetLink() {
        getHelper(VideoWidget.class).checkLink();
        return this;
    }

    @Override
    public UssRecomendPage checkVideoWidgetVideoDuration() {
        getHelper(VideoWidget.class).checkVideoDuration();
        return this;
    }

    @Override
    public UssDocumentPage clickOnVideoWidgetScreenshot() {
        getHelper(VideoWidget.class).clickOnScreenshot();
        return redirectTo(UssDocumentPage.class);
    }

    @Override
    public UssDocumentPage clickOnVideoWidgetLink() {
        getHelper(VideoWidget.class).clickOnLink();
        return redirectTo(UssDocumentPage.class);
    }

    @Override
    public UssRecomendPage checkLawBaseWidgetTitleIsPresent() {
        getHelper(LawBaseWidget.class).checkTitleIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkKodeksOrderInLawBaseBlock() {
        getHelper(LawBaseWidget.class).checkCodes();
        return this;
    }

    @Override
    public UssRecomendPage checkLawBaseWidgetSearchInputIsPresent() {
        getHelper(LawBaseWidget.class).checkSearchInputIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkLawBaseWidgetNewDocumentCounterIsPresent() {
        getHelper(LawBaseWidget.class).checkNewDocumentCounterIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkLawBaseWidgetLinksCodes() {
        getHelper(LawBaseWidget.class).checkLinksCodes();
        return this;
    }

    @Override
    public UssLawBasePage clickLawBaseWidgetLinkTitle() {
        getHelper(LawBaseWidget.class).clickLinkTitle();
        return redirectTo(UssLawBasePage.class);
    }

    @Override
    public UssLawBasePage clickLawBaseWidgetLinkNewDocumentCounter() {
        getHelper(LawBaseWidget.class).clickLinkNewDocumentCounter();
        return redirectTo(UssLawBasePage.class);
    }

    @Override
    public UssLawBasePage clickLawBaseWidgetLinkEnterIconOntoSearchInput() {
        getHelper(LawBaseWidget.class).clickLinkEnterIconOnSearchInput();
        return redirectTo(UssLawBasePage.class);
    }

    @Override
    public UssRecomendPage inputLawBaseWidgetInSearch(String query) {
        getHelper(LawBaseWidget.class).inputInSearch(query);
        return this;
    }

    @Override
    public UssRecomendPage checkLawBaseWidgetSearchResultsArePresent() {
        getHelper(LawBaseWidget.class).checkSearchResultsArePresent();
        return this;
    }

    @Override
    public UssDocumentPage clickLawBaseWidgetOnSearchResultsDirectDocument() {
        getHelper(LawBaseWidget.class).clickOnSearchResultsDirectDocument();
        return redirectTo(UssDocumentPage.class);
    }

    @Override
    public UssSearchResultPage clickLawBaseWidgetSearchResultsRandomHintLink() {
        getHelper(LawBaseWidget.class).clickSearchResultsRandomHintLink();
        return redirectTo(UssSearchResultPage.class);
    }

    @Override
    public UssSearchResultPage clickLawBaseWidgetIconEnterWithSearchQuery() {
        getHelper(LawBaseWidget.class).clickLinkEnterIconOnSearchInput();
        return redirectTo(UssSearchResultPage.class);
    }

    @Override
    public UssRecomendPage checkMagazinesWidgetTitleIsPresent() {
        getHelper(MagazinesWidget.class).checkTitleIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkMagazinesWidgetMagazinesCoversIsPresent() {
        getHelper(MagazinesWidget.class).checkMagazinesCoversIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkMagazinesWidgetMagazinesAreNotRepeated() {
        getHelper(MagazinesWidget.class).checkMagazinesAreNotRepeated();
        return this;
    }

    @Override
    public UssRecomendPage checkMagazinesWidgetRedMarkerIsPresent() {
        getHelper(MagazinesWidget.class).checkRedMarkerForNewMagazine();
        return this;
    }

    @Override
    public UssRecomendPage checkMagazinesWidgetTextNewMagazineIsPresent() {
        getHelper(MagazinesWidget.class).checkTextNewMagazineIsPresent();
        return this;
    }

    @Override
    public UssMagazinesPage clickOnMagazinesWidgetTitle() {
        getHelper(MagazinesWidget.class).clickOnTitle();
        return redirectTo(UssMagazinesPage.class);
    }

    @Override
    public UssDocumentPage clickOnMagazinesWidgetNotice() {
        getHelper(MagazinesWidget.class).clickOnNotice();
        return redirectTo(UssDocumentPage.class);
    }

    @Override
    public UssRecomendPage checkMagazinesWidgetMagazinesLinks() {
        getHelper(MagazinesWidget.class).checkMagazinesLinks();
        return this;
    }

    @Override
    public UssRecomendPage checkMagazinesWidgetMagazinesCoversWithVariantResolutions() {
        getHelper(MagazinesWidget.class).checkMagazinesCoversWithVariantResolutions();
        return this;
    }

    public UssRecomendPage checkBannerIsPresent() {
        getHelper(BannerBlock.class).checkWidgetIsPresent();
        return this;
    }

    public UssRecomendPage clickOnBanner() {
        getHelper(BannerBlock.class).clickOnBanner();
        return this;
    }

    public UssRecomendPage checkDocumentAfterClickingOnBanner() {
        String documentUrl = String.valueOf(getParameter(SearchResultHelper.DOCUMENT_URL));
        postponedAssertTrue(getDriver().getCurrentUrl().contains(documentUrl), "URL не совпадают, actual:" +
                getDriver().getCurrentUrl() + " expected:" + documentUrl);
        return this;
    }

    public UssRecomendPage checkBannerTextWithScreenResolution1024px() {
        getHelper(BannerBlock.class).checkBannerTextWithScreenResolution1024px();
        return this;
    }

    public UssRecomendPage checkBannerTextWithScreenResolution1280px() {
        getHelper(BannerBlock.class).checkBannerTextWithScreenResolution1280px();
        return this;
    }

    public UssRecomendPage checkBannerTextWithScreenResolution1366px() {
        getHelper(BannerBlock.class).checkBannerTextWithScreenResolution1366px();
        return this;
    }

    @Override
    public UssRecomendPage checkFormsWidgetTitleIsPresent() {
        getHelper(FormsWidget.class).checkTitleIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkFormsWidgetSearchInputIsPresent() {
        getHelper(FormsWidget.class).checkSearchInputIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkFormsWidgetNewDocumentCounterIsPresent() {
        getHelper(FormsWidget.class).checkNewDocumentCounterIsPresent();
        return this;
    }

    @Override
    public UssRecomendPage checkFormsWidgetExamplesFormsIsPresent() {
        getHelper(FormsWidget.class).checkExamplesFormsIsPresent();
        return this;
    }

    public UssDocumentPage clickFormsWidgetRedLink() {
        getHelper(FormsWidget.class).clickOnRedLink();
        return redirectTo(UssDocumentPage.class);
    }

    public UssDocumentPage clickFormsWidgetGreenLink() {
        getHelper(FormsWidget.class).clickOnGreenLink();
        return redirectTo(UssDocumentPage.class);
    }

    public UssDocumentPage clickFormsWidgetBlueLink() {
        getHelper(FormsWidget.class).clickOnBlueLink();
        return redirectTo(UssDocumentPage.class);
    }

    public UssDocumentPage clickFormsWidgetYellowLink() {
        getHelper(FormsWidget.class).clickOnYellowLink();
        return redirectTo(UssDocumentPage.class);
    }

    @Override
    public UssFormsPage clickFormsLink() {
        getHelper(FormsWidget.class).clickOnTitle();
        return redirectTo(UssFormsPage.class);
    }

    @Override
    public UssFormsPage clickFormsWidgetLinkNewDocumentCounter() {
        getHelper(FormsWidget.class).clickLinkNewDocumentCounter();
        return redirectTo(UssFormsPage.class);
    }

    @Override
    public UssFormsPage clickFormsWidgetLinkEnterIconOntoSearchInput() {
        getHelper(FormsWidget.class).clickLinkEnterIconOnSearchInput();
        return redirectTo(UssFormsPage.class);
    }

    @Override
    public UssRecomendPage inputFormsWidgetInSearch(String query) {
        getHelper(FormsWidget.class).inputInSearch(query);
        return this;
    }

    @Override
    public UssRecomendPage checkFormsWidgetSearchResultsArePresent() {
        getHelper(FormsWidget.class).checkSearchResultsArePresent();
        return this;
    }

    @Override
    public UssDocumentPage clickFormsWidgetOnSearchResultsDirectDocument() {
        getHelper(FormsWidget.class).clickOnSearchResultsDirectDocument();
        return redirectTo(UssDocumentPage.class);
    }

    @Override
    public UssSearchResultPage clickFormsWidgetSearchResultsRandomHintLink() {
        getHelper(FormsWidget.class).clickSearchResultsRandomHintLink();
        return redirectTo(UssSearchResultPage.class);
    }

    @Override
    public UssSearchResultPage clickFormsWidgetIconEnterWithSearchQuery() {
        getHelper(FormsWidget.class).clickLinkEnterIconOnSearchInput();
        return redirectTo(UssSearchResultPage.class);
    }

    public UssRecomendPage checkWizardWidgetIsPresent() {
        WebElement widget = getHelper(WizardWidget.class).getWidget();
        getHelper(WizardWidget.class).checkWidgetIsPresent(widget, "Мастера");
        return this;
    }

    public UssRecomendPage checkWizardWidgetFiveLinksArePresent() {
        getHelper(WizardWidget.class).checkFiveLinksArePresent();
        return this;
    }

    public UssRecomendPage checkWizardWidgetHasTitle() {
        getHelper(WizardWidget.class).checkWidgetHasTitle();
        return this;
    }

    public UssRecomendPage checkWizardWidgetSolutionsCountIsPresent() {
        getHelper(WizardWidget.class).checkSolutionsCountIsPresent();
        return this;
    }

    public UssDocumentPage clickOnWizardWidgetFirstSolution() {
        getHelper(WizardWidget.class).clickOnFirstSolution();
        return redirectTo(UssDocumentPage.class);
    }

    public UssDocumentPage clickOnWizardWidgetSecondSolution() {
        getHelper(WizardWidget.class).clickOnSecondSolution();
        return redirectTo(UssDocumentPage.class);
    }

    public UssDocumentPage clickOnWizardWidgetThirdSolution() {
        getHelper(WizardWidget.class).clickOnThirdSolution();
        return redirectTo(UssDocumentPage.class);
    }

    public UssDocumentPage clickOnWizardWidgetFourthSolution() {
        getHelper(WizardWidget.class).clickOnFourthSolution();
        return redirectTo(UssDocumentPage.class);
    }

    public UssDocumentPage clickOnWizardWidgetFifthSolution() {
        getHelper(WizardWidget.class).clickOnFifthSolution();
        return redirectTo(UssDocumentPage.class);
    }

    public UssServicesPage clickOnWizardWidgetClickOnTitle() {
        getHelper(WizardWidget.class).clickOnTitle();
        return redirectTo(UssServicesPage.class);
    }

    @Override
    @Step("Проверяется что ссылка 'Написать Эксперту' не отображается")
    public UssRecomendPage checkHotLineLinkIsNotPresent() {
        postponedAssertNull(findElementByNoThrow(By.className("[href*='/#/hotline/']")), "Ссылка 'Написать Эксперту' отображается");
        return this;
    }
}
