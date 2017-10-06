package com.actionmedia.pages.kss;

import com.actionmedia.pages.helpers.FormsPageHelper;
import com.actionmedia.pages.interfaces.IDocumentPage;
import com.actionmedia.pages.interfaces.IFormsPage;
import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.components.Link;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.helpers.SearchResultHelper;
import com.actionmedia.util.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class KssFormsPage extends KssBasePage<KssFormsPage> implements IFormsPage {

    @Step("Проверяются элементы на странице 'Формы'")
    public KssFormsPage checkDefaultStateFormsPage() {
        checkFormsTabIsSelected();
        checkSearchBoxPresentOnFormsPage();
        checkNewBlock();
        checkPopularBlocks();
//        checkFormPictureIsPresent();
        checkFormsRubricatorButtonIsPresent();
        checkMyFavoritesRubricatorButtonIsPresent();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Формы'")
    public KssFormsPage checkFormsTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.FORMS);
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Формы'")
    public KssFormsPage checkSearchBoxPresentOnFormsPage() {
        checkSearchBoxIsPresent("Поиск форм и образцов");
        return this;
    }

    @Step("Проверяется блок 'Новое' на странице 'Формы'")
    public KssFormsPage checkNewBlock() {
        List<WebElement> newBlocks = findElementsBy(By.cssSelector("[class*='changes']"));
        postponedAssertFalse(newBlocks.isEmpty(), "Блок Новое Отсутствует");
        return this;
    }

    @Step("Проверяется блок 'Популярное' на странице 'Формы'")
    public KssFormsPage checkPopularBlocks() {
        List<WebElement> popularBlocks = sidebarElement.findElements(By.cssSelector(".news__item"));
        postponedAssertFalse(popularBlocks.isEmpty(), "Блок Популярное пустой");
        return this;
    }

    @Step("Проверяется что картинка для новой формы отображается")
    public KssFormsPage checkFormPictureIsPresent() {
        WebElement formPicture = findElementByNoThrow(mainLeftElement, By.cssSelector("[class*='form-']"));
        postponedAssertTrue(formPicture != null && formPicture.isDisplayed(), "Картинка с формой не отображается");
        return this;
    }

    @Step("Проверяется что кнопка рубрикатора форм отображается")
    public KssFormsPage checkFormsRubricatorButtonIsPresent() {
        WebElement rubricatorButton = waitForPresenceOfElementLocatedBy(By.id("rubricator-btn"), "Кнопка Все формы не отображается");
        postponedAssertEquals(rubricatorButton.getText(), "Все формы", "Неправильный текст кнопки Все формы");
        return this;
    }

    @Step("Проверяется работа скролла в блоке Новое")
    public KssFormsPage checkNewsBlockScrolling() {
        List<WebElement> newsBeforeScroll = mainLeftElement.findElements(By.cssSelector("[class*='changes']"));
        postponedAssertFalse(newsBeforeScroll.isEmpty(), "Блок Новое пустой");

        scroll(Period.month, By.tagName("h2"));

        List<WebElement> newsAfterScroll = mainLeftElement.findElements(By.cssSelector("[class*='changes']"));
        postponedAssertTrue(newsAfterScroll.size() > newsBeforeScroll.size(), "Новости не подгружаются после скролла");
        return this;
    }

    @Step("Проверяется сортировка новостей")
    public KssFormsPage checkDateAreSortedDescending() {
        List<WebElement> dateListElement = mainLeftElement.findElements(By.tagName("h2"));
        postponedAssertThat(dateListElement, TestUtils.sortedDatesWithoutYearInDescendingOrder(), "Элементы отсортированы в неправильном порядке");
        return this;
    }

    @Step("Проверяется что новости не пустые")
    public KssFormsPage checkNewsAreNotEmpty() {
        List<WebElement> dateListElement = mainLeftElement.findElements(By.tagName("h2"));
        List<WebElement> newsColumnList = mainLeftElement.findElements(By.cssSelector(".block-changes"));
        for (int i = 0; i < dateListElement.size(); i++) {
            String dateString = dateListElement.get(i).getText();
            WebElement leftNewsColumn = newsColumnList.get(i);
            assertNotNull(leftNewsColumn, "Блок Новое для '" + dateString + "' не найден");
            postponedAssertFalse(leftNewsColumn.getText().isEmpty(), "Блок Новое для '" + dateString + "' пуст");
        }
        return this;
    }

    @Step("Проверяется что новости не повторяются")
    public KssFormsPage checkNewsBlockAreNotRepeat() {
        List<WebElement> dateListElement = mainLeftElement.findElements(By.tagName("h2"));
        List<WebElement> newsColumnList = mainLeftElement.findElements(By.cssSelector(".block-changes"));
        Map<String, List<String>> newsBlockMap = new HashMap<String, List<String>>();
        for (int i = 0; i < dateListElement.size(); i++) {
            String dateString = dateListElement.get(i).getText();
            List<String> newsBlockForDate = new ArrayList<String>();
            newsBlockForDate.add(newsColumnList.get(i).getText());
            postponedAssertFalse(newsBlockMap.containsValue(newsBlockForDate), "Блок новостей за '" + dateString + "' повторяется");
            newsBlockMap.put(dateString, newsBlockForDate);
        }
        return this;
    }

    @Step("Проверяется работа ссылок блока новые")
    public KssFormsPage checkNewFormLinks() {
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
    public KssFormsPage checkPopularBlockIsDisplayed() {
        postponedAssertTrue(sidebarElement.isDisplayed() && sidebarElement.isEnabled(), "Блок Популярное не отображается");
        return this;
    }

    @Step("Проверяется что блок Популярное не пустой")
    public KssFormsPage checkPopularBlockAreNotEmpty() {
        List<WebElement> popularForms = sidebarElement.findElements(By.cssSelector(".news__item"));
        postponedAssertFalse(popularForms.isEmpty(), "Блок Популярное пустой");

        for (WebElement popularForm : popularForms) {
            postponedAssertFalse(popularForm.getText().isEmpty(), "Отсутствует текст для формы в блоке Популярное");
        }
        return this;
    }

    @Step("Проверяется работа ссылок в блоке Популярное")
    public KssFormsPage checkPopularFormLinks() {
        List<WebElement> popularForms = sidebarElement.findElements(By.cssSelector(".forms"));
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

    @Step("Проверяется что результаты поиска отсутсвуют")
    public KssFormsPage checkSearchResultIsNotPresentOnFormsPage() {
        checkSearchResultIsNotPresentOnPage();
        return this;
    }

    @Step("Нажать кнопку Найти")
    public KssFormsPage clickSearchButtonOnFormsPage() {
        clickSearchButton();
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются")
    public KssFormsPage checkHintsIsPresent() {
        checkHintListIsPresent();
        return this;
    }

    @Step("Нажать подсказку с прямым переходом")
    public KssSearchResultPage clickHintWithJumpOnFormsPage() {
        clickHintWithJump();
        return redirectTo(KssSearchResultPage.class);
    }

    @Step("Нажать любую подсказку с переходом")
    public KssSearchResultPage clickRandomHintOnFormsPage() {
        clickRandomHint();
        return redirectTo(KssSearchResultPage.class);
    }

    @Step("Открыть случайный документ из блока популярное")
    public KssFormsPage clickRandomDocumentLink() {
        WebElement popularContent = waitForPresenceOfElementLocatedBy(By.cssSelector(".popular-list"));
        List<WebElement> popularNews = popularContent.findElements(By.tagName("a"));
        getRandomElementInList(popularNews).click();
        waitForReloadingPage();
        return this;
    }

    @Step("Проверяется работа кнопки Найти на странице Правовая база")
    public KssFormsPage checkSearchButtonFunctionalityOnSearchBox(String query) {
        setParameter(SearchResultHelper.HINT_TEXT, query);
        return clearSearchBox()
                .clickSearchButtonOnFormsPage()
                .checkFormsTabIsSelected()
                .checkSearchResultIsNotPresentOnFormsPage()

                .clearSearchBox()
                .inputTextInSearchBox(query)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnFormsPageIsOpened()
                .navigateToFormsPage();
    }

    @Override
    public KssFormsPage checkTitle(String titleName) {
        getHelper(FormsPageHelper.class).checkTitle(titleName);
        return this;
    }

    @Override
    public KssFormsPage checkNewsBlocksArePresent() {
        getHelper(FormsPageHelper.class).checkNewsBlocksArePresent();
        return this;
    }

    @Override
    public KssFormsPage checkNewsBlocksTitlesArePresent() {
        getHelper(FormsPageHelper.class).checkNewsBlocksTitlesArePresent();
        return this;
    }

    @Override
    public KssFormsPage checkNewsBlocksDatesSortedInDescendingOrder() {
        getHelper(FormsPageHelper.class).checkNewsBlocksDatesSortedInDescendingOrder();
        return this;
    }

    @Override
    public KssFormsPage checkNewsBlocksHaveTitleAndDescription() {
        getHelper(FormsPageHelper.class).checkNewsBlocksHaveTitleAndDescription();
        return this;
    }

    @Override
    public KssFormsPage checkPictureForFirstNewsIsPresent() {
        getHelper(FormsPageHelper.class).checkPictureForFirstNewsIsPresent();
        return this;
    }

    @Override
    public KssFormsPage checkNewsLoadedAfterScrollingDown() {
        getHelper(FormsPageHelper.class).checkNewsLoadedAfterScrollingDown();
        return this;
    }

    @Override
    public KssDocumentPage clickOnRandomLinkFromNewsBlock() {
        getHelper(FormsPageHelper.class).clickOnRandomLinkFromNewsBlock();
        return redirectTo(KssDocumentPage.class);
    }

    public KssFormsPage checkPopularBlockIsPresent() {
        getHelper(FormsPageHelper.class).checkPopularBlockIsPresent();
        return this;
    }

    @Override
    public KssFormsPage checkPopularBlockDocumentLinksArePresent() {
        getHelper(FormsPageHelper.class).checkPopularBlockDocumentLinksArePresent();
        return this;
    }

    @Override
    public KssFormsPage checkPopularBlockMarkersArePresent() {
        getHelper(FormsPageHelper.class).checkPopularBlockMarkersArePresent();
        return this;
    }

    @Override
    public KssDocumentPage clickOnRandomLinkFromPopularBlock() {
        getHelper(FormsPageHelper.class).clickOnRandomLinkFromPopularBlock();
        return redirectTo(KssDocumentPage.class);
    }
}
