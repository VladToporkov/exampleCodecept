package com.actionmedia.pages.uss;

import com.actionmedia.components.Link;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.helpers.FormsPageHelper;
import com.actionmedia.pages.helpers.SearchResultHelper;
import com.actionmedia.pages.interfaces.IFormsPage;
import com.actionmedia.util.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: n.tyukavkin
 * Date: 28.10.13
 * Time: 12:14
 */
@Component
public class UssFormsPage extends UssBasePage<UssFormsPage> implements IFormsPage {

    @Step("Проверяются элементы на странице 'Формы'")
    public UssFormsPage checkDefaultStateFormsPage() {
        checkFormsTabIsSelected();
        checkSearchBoxPresentOnFormsPage();
        checkNewBlock();
        checkPopularBlocks();
        checkFormPictureIsPresent();
        checkFormsRubricatorButtonIsPresent();
        checkMyFavoritesRubricatorButtonIsPresent();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Формы'")
    public UssFormsPage checkFormsTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.FORMS);
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Формы'")
    public UssFormsPage checkSearchBoxPresentOnFormsPage() {
        checkSearchBoxIsPresent("Поиск форм и образцов");
        return this;
    }

    @Step("Проверяется блок 'Новое' на странице 'Формы'")
    public UssFormsPage checkNewBlock() {
        List<WebElement> newBlocks = findElementsBy(By.cssSelector("[class*='changes']"));
        postponedAssertFalse(newBlocks.isEmpty(), "Блок Новое Отсутствует");
        return this;
    }

    @Step("Проверяется блок 'Популярное' на странице 'Формы'")
    public UssFormsPage checkPopularBlocks() {
        List<WebElement> popularBlocks = sidebarElement.findElements(By.cssSelector(".news__item"));
        postponedAssertFalse(popularBlocks.isEmpty(), "Блок Популярное пустой");
        return this;
    }

    @Step("Проверяется что картинка для новой формы отображается")
    public UssFormsPage checkFormPictureIsPresent() {
        WebElement formPicture = findElementByNoThrow(mainLeftElement, By.cssSelector("[class*='form-']"));
        postponedAssertTrue(formPicture != null && formPicture.isDisplayed(), "Картинка с формой не отображается");
        return this;
    }

    @Step("Проверяется что кнопка рубрикатора форм отображается")
    public UssFormsPage checkFormsRubricatorButtonIsPresent() {
        WebElement rubricatorButton = waitForPresenceOfElementLocatedBy(By.id("rubricator-btn"), "Кнопка Все формы не отображается");
        postponedAssertEquals(rubricatorButton.getText(), "Все формы", "Неправильный текст кнопки Все формы");
        return this;
    }

    @Step("Проверяется работа скролла в блоке Новое")
    public UssFormsPage checkNewsBlockScrolling() {
        List<WebElement> newsBeforeScroll = mainLeftElement.findElements(By.cssSelector("[class*='changes']"));
        postponedAssertFalse(newsBeforeScroll.isEmpty(), "Блок Новое пустой");

        scroll(Period.month, By.cssSelector(".main__in h2"));

        List<WebElement> newsAfterScroll = mainLeftElement.findElements(By.cssSelector("[class*='changes']"));
        postponedAssertTrue(newsAfterScroll.size() > newsBeforeScroll.size(), "Новости не подгружаются после скролла");
        return this;
    }

    @Step("Проверяется сортировка новостей")
    public UssFormsPage checkDateAreSortedDescending() {
        List<WebElement> dateListElement = mainLeftElement.findElements(By.cssSelector(".main__in h2"));
        postponedAssertThat(dateListElement, TestUtils.sortedDatesWithoutYearInDescendingOrder(), "Элементы отсортированы в неправильном порядке");
        return this;
    }

    @Step("Проверяется что новости не пустые")
    public UssFormsPage checkNewsAreNotEmpty() {
        WebElement newsBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".main__in"), "Блок Новое не найден");
        List<WebElement> elementList = newsBlock.findElements(By.tagName("*"));
        for (int i = 0; i < elementList.size(); i++) {
            if ("h2".equals(elementList.get(i).getTagName())) {
                String date = elementList.get(i).getText();
                boolean isNotEmpty = false;
                while (i + 1 < elementList.size() && !"h2".equals(elementList.get(i + 1).getTagName())) {
                    if (elementList.get(i).getAttribute("class") != null && elementList.get(i).getAttribute("class").contains("block-changes")) {
                        postponedAssertTrue(!elementList.get(i).getText().isEmpty(), "Блок Новое для '" + date + "' пуст");
                        isNotEmpty = true;
                    }
                    i++;
                }
                postponedAssertTrue(isNotEmpty, "Блок Новое для '" + date + "' пуст");
            }
        }
        return this;
    }

    @Step("Проверяется что новости не повторяются")
    public UssFormsPage checkNewsBlockAreNotRepeat() {
        List<WebElement> elementList = mainLeftElement.findElements(By.tagName("*"));
        Map<String, List<String>> newsBlockMap = new HashMap<String, List<String>>();
        for (int i = 0; i < elementList.size(); i++) {
            if ("h2".equals(elementList.get(i).getTagName())) {
                String date = elementList.get(i).getText();
                List<String> newsBlockForDate = new ArrayList<String>();
                while (i + 1 < elementList.size() && !"h2".equals(elementList.get(i + 1).getTagName())) {
                    if (elementList.get(i).getAttribute("class") != null && elementList.get(i).getAttribute("class").contains("block-changes")) {
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

    @Step("Проверяется работа ссылок блока новые")
    public UssFormsPage checkNewsFormLinks() {
        List<WebElement> newsTitleList = mainLeftElement.findElements(By.cssSelector(".changes-list"));
        List<Link> newsStringList = new ArrayList<Link>();
        for (WebElement newsTitleElement : newsTitleList) {
            String url = newsTitleElement.findElement(By.tagName("a")).getAttribute("href");
            String header = newsTitleElement.findElement(By.tagName("a")).getText();
            Link link = new Link(url, header);
            newsStringList.add(link);
        }
        checkLinks(newsStringList);
        return this;
    }

    @Step("Проверяется что блок Популярное отображается")
    public UssFormsPage checkPopularBlockIsDisplayed() {
        postponedAssertTrue(sidebarElement.isDisplayed() && sidebarElement.isEnabled(), "Блок Популярное не отображается");
        return this;
    }

    @Step("Проверяется что блок Популярное не пустой")
    public UssFormsPage checkPopularBlockIsNotEmpty() {
        List<WebElement> popularForms = sidebarElement.findElements(By.cssSelector(".news__item"));
        postponedAssertFalse(popularForms.isEmpty(), "Блок Популярное пустой");
        return this;
    }

    @Step("Проверяется работа ссылок в блоке Популярное")
    public UssFormsPage checkPopularFormLinks() {
        List<WebElement> popularForms = sidebarElement.findElements(By.cssSelector(".news__item"));
        List<Link> formLinks = new ArrayList<Link>();
        for (WebElement popularForm : popularForms) {
            String url = popularForm.findElement(By.tagName("a")).getAttribute("href");
            String header = popularForm.findElement(By.tagName("a")).getText();
            Link link = new Link(url, header);
            formLinks.add(link);
        }
        checkLinks(formLinks);
        return this;
    }

    @Step("Открыть случайный документ из блока популярное")
    public UssFormsPage clickRandomDocumentLink() {
        List<WebElement> popularNews = sidebarElement.findElements(By.tagName("a"));
        getRandomElementInList(popularNews).click();
        waitForReloadingPage();
        return this;
    }

    @Step("Проверяется что результаты поиска отсутсвуют")
    public UssFormsPage checkSearchResultIsNotPresentOnFormsPage() {
        checkSearchResultIsNotPresentOnPage();
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются")
    public UssFormsPage checkHintsIsPresent() {
        checkHintListIsPresent();
        return this;
    }

    @Step("Нажать подсказку с прямым переходом")
    public UssSearchResultPage clickHintWithJumpOnFormsPage() {
        clickHintWithJump();
        return redirectTo(UssSearchResultPage.class);
    }

    @Step("Нажать любую подсказку с переходом")
    public UssSearchResultPage clickRandomHintOnFormsPage() {
        clickRandomHint();
        return redirectTo(UssSearchResultPage.class);
    }

    @Step("Проверяется работа кнопки Найти на странице Правовая база")
    public UssFormsPage checkSearchButtonFunctionalityOnSearchBox(String query) {
        setParameter(SearchResultHelper.HINT_TEXT, query);
        return clearSearchBox()
                .clickSearchButton()
                .checkFormsTabIsSelected()
                .checkSearchResultIsNotPresentOnFormsPage()

                .clearSearchBox()
                .inputTextInSearchBox(query)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnFormsPageIsOpened()
                .navigateToFormsPage();
    }

    @Step("Открыть любой документ из рубрикатора")
    public UssDocumentPage open140Module() {
        waitForPresenceOfElementLocatedBy(By.id("rubricator-btn")).click();
        waitForVisibilityOfElementLocatedBy(By.id("rubricator"), "Рубрикатор не найден");
        List<WebElement> links = waitForPresenceOfElementLocatedBy(By.cssSelector(".b-rubricator-list")).findElements(By.tagName("li"));
        for (WebElement section : links) {
            section.findElement(By.tagName("a")).click();
            WebElement content = waitForPresenceOfElementLocatedBy(By.id("rubricator-right"));
            List<WebElement> documentLinkList = content.findElements(By.tagName("li"));
            for (WebElement documentLink : documentLinkList) {
                WebElement link = documentLink.findElement(By.tagName("a"));
                String linkUrl = link.getAttribute("href");
                if (linkUrl.contains("/document/140")) {
                    String currentUrl = getCurrentUrl();
                    report("Открыта страница: " + currentUrl);
                    report("Открывается ссылка: " + linkUrl);
                    link.click();
                    return redirectTo(UssDocumentPage.class);
                }
            }
        }
        fail("Не найден 140 модуль");
        return redirectTo(UssDocumentPage.class);
    }

    @Override
    public UssFormsPage checkTitle(String titleName) {
        getHelper(FormsPageHelper.class).checkTitle(titleName);
        return this;
    }

    @Override
    public UssFormsPage checkNewsBlocksArePresent() {
        getHelper(FormsPageHelper.class).checkNewsBlocksArePresent();
        return this;
    }

    @Override
    public UssFormsPage checkNewsBlocksTitlesArePresent() {
        getHelper(FormsPageHelper.class).checkNewsBlocksTitlesArePresent();
        return this;
    }

    @Override
    public UssFormsPage checkNewsBlocksDatesSortedInDescendingOrder() {
        getHelper(FormsPageHelper.class).checkNewsBlocksDatesSortedInDescendingOrder();
        return this;
    }

    @Override
    public UssFormsPage checkNewsBlocksHaveTitleAndDescription() {
        getHelper(FormsPageHelper.class).checkNewsBlocksHaveTitleAndDescription();
        return this;
    }

    @Override
    public UssFormsPage checkPictureForFirstNewsIsPresent() {
        getHelper(FormsPageHelper.class).checkPictureForFirstNewsIsPresent();
        return this;
    }

    @Override
    public UssFormsPage checkNewsLoadedAfterScrollingDown() {
        getHelper(FormsPageHelper.class).checkNewsLoadedAfterScrollingDown();
        return this;
    }

    @Override
    public UssDocumentPage clickOnRandomLinkFromNewsBlock() {
        getHelper(FormsPageHelper.class).clickOnRandomLinkFromNewsBlock();
        return redirectTo(UssDocumentPage.class);
    }

    public UssFormsPage checkPopularBlockIsPresent() {
        getHelper(FormsPageHelper.class).checkPopularBlockIsPresent();
        return this;
    }

    @Override
    public UssFormsPage checkPopularBlockDocumentLinksArePresent() {
        getHelper(FormsPageHelper.class).checkPopularBlockDocumentLinksArePresent();
        return this;
    }

    @Override
    public UssFormsPage checkPopularBlockMarkersArePresent() {
        getHelper(FormsPageHelper.class).checkPopularBlockMarkersArePresent();
        return this;
    }

    @Override
    public UssDocumentPage clickOnRandomLinkFromPopularBlock() {
        getHelper(FormsPageHelper.class).clickOnRandomLinkFromPopularBlock();
        return redirectTo(UssDocumentPage.class);
    }
}
