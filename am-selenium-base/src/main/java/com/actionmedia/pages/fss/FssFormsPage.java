package com.actionmedia.pages.fss;

import com.actionmedia.pages.interfaces.IFormsPage;
import com.actionmedia.pages.helpers.FormsPageHelper;
import com.actionmedia.pages.interfaces.IDocumentPage;
import com.actionmedia.pages.interfaces.IFormsPage;
import com.actionmedia.pages.interfaces.ISystemBasePage;
import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.autotest.selenium.context.ComponentProvider;
import com.actionmedia.components.Link;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.RightPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 05.11.13
 * Time: 10:52
 */
@Component
public class FssFormsPage extends FssBasePage<FssFormsPage> implements ComponentProvider, IFormsPage {

    private RightPanel rightPanel;

    @Override
    public void handleRedirect() {
        super.handleRedirect();
        rightPanel = getHelper(RightPanel.class, this);
    }

    @Step("Проверяется что открыта страница 'Положения и регламенты'")
    public FssFormsPage checkFormsPageIsOpened() {
        checkFormsTabIsSelected();
        checkSearchBoxPresentOnFormsPage();
        checkNewsBlockIsPresent();
        checkPopularBlockIsPresent();
        checkFormPictureIsPresent();
        checkFormsRubricatorButtonIsPresent();
        checkMyFavoritesRubricatorButtonIsPresent();
        return this;
    }

    @Step("Проверяются элементы на странице 'Положения и регламенты'")
    public FssFormsPage checkDefaultStateFormsPage() {
        checkFormsTabIsSelected();
        checkSearchBoxPresentOnFormsPage();
        checkNewsBlockIsPresent();
        checkPopularBlockIsPresent();
        checkFormPictureIsPresent();
        checkFormsRubricatorButtonIsPresent();
        checkMyFavoritesRubricatorButtonIsPresent();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Положения и регламенты'")
    public FssFormsPage checkFormsTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.FSS_FORMS);
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Положения и регламенты'")
    public FssFormsPage checkSearchBoxPresentOnFormsPage() {
        checkSearchBoxIsPresent("поиск форм и образцов");
        return this;
    }

    @Step("Проверяется что блок Новое на странице 'Положения и регламенты' отображается")
    public FssFormsPage checkNewsBlockIsPresent() {
        List<WebElement> newBlocks = findElementsBy(By.cssSelector("[class*='changes']"));
        postponedAssertFalse(newBlocks.isEmpty(), "Блок Новое Отсутствует");
        return this;
    }

    @Step("Проверяется что картинка для новой формы отображается")
    public FssFormsPage checkFormPictureIsPresent() {
        WebElement formPicture = findElementByNoThrow(mainLeftElement, By.cssSelector("[class*='form-']"));
        postponedAssertTrue(formPicture != null && formPicture.isDisplayed(), "Картинка с формой не отображается");
        return this;
    }

    @Step("Проверяется что кнопка рубрикатора форм отображается")
    public FssFormsPage checkFormsRubricatorButtonIsPresent() {
        WebElement rubricatorButton = waitForPresenceOfElementLocatedBy(By.id("rubricator-btn"), "Кнопка Все формы не отображается");
        postponedAssertEquals(rubricatorButton.getText(), "Все документы", "Неправильный текст кнопки Все формы");
        return this;
    }

    @Step("Проверяется что правая панель на странице 'Положения и регламенты' отображается")
    public FssFormsPage checkPopularBlockIsPresent() {
        getHelper(FormsPageHelper.class).checkPopularBlockIsPresent();
        return this;
    }

    @Override
    public FssFormsPage checkPopularBlockDocumentLinksArePresent() {
        getHelper(FormsPageHelper.class).checkPopularBlockDocumentLinksArePresent();
        return this;
    }

    @Override
    public FssFormsPage checkPopularBlockMarkersArePresent() {
        getHelper(FormsPageHelper.class).checkPopularBlockMarkersArePresentForFSS();
        return this;
    }

    public FssFormsPage checkLinksFromNewsBlock() {
        getHelper(FssHelpers.class).checkLinksFromNewsBlock();
        return this;
    }

    public FssFormsPage checkNewsBlockScrolling() {
        getHelper(FssHelpers.class).checkNewsBlockScrolling(Period.month);
        return this;
    }

    public FssFormsPage checkDateAreSortedDescending() {
        getHelper(FssHelpers.class).checkDateAreSortedDescending();
        return this;
    }

    public FssFormsPage checkNewsBlockAreNotRepeat() {
        getHelper(FssHelpers.class).checkNewsBlockAreNotRepeat();
        return this;
    }

    public FssFormsPage checkNewsAreNotEmpty() {
        getHelper(FssHelpers.class).checkNewsAreNotEmpty();
        return this;
    }

    public FssFormsPage clickExtendPopularBlock() {
        getHelper(FssHelpers.class).clickExtendPopularBlock();
        return this;
    }

    @Step("Открыть раздел Популярное в правой панели")
    public FssFormsPage clickPopularTab() {
        rightPanel.clickPopularTabInExpanded();
        return this;
    }

    @Step("Открыть раздел Просмотренное в правой панели")
    public FssFormsPage clickViewedTab() {
        rightPanel.clickViewedTabInExpanded();
        return this;
    }

    @Step("Закрыть правую панель")
    public FssFormsPage closePopularBlock() {
        rightPanel.closePopularBlock();
        return this;
    }

    @Step("Проверяется работа ссылок из раздела Просмотренное в правой панели")
    public FssFormsPage checkRandomLinksFromExtendedViewedBlock() {
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
    public FssFormsPage checkRandomLinksFromExtendedPopularBlock() {
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
    public FssFormsPage checkFiltersInRightPanel() {
        clickExtendPopularBlock();
        clickViewedTab();
        rightPanel.checkDateFilters();
        return this;
    }

    public FssFormsPage checkCollapsedRightPanel() {
        getHelper(FssHelpers.class).checkCollapsedRightPanel(rightPanel);
        return this;
    }

    public FssFormsPage checkExpandedRightPanel() {
        getHelper(FssHelpers.class).checkExpandedRightPanel(rightPanel);
        return this;
    }

    public FssFormsPage checkRandomLinksFromCollapsedPopularTab() {
        getHelper(FssHelpers.class).checkRandomLinksFromCollapsedPopularTab(rightPanel);
        return this;
    }

    public FssFormsPage checkRandomLinksFromCollapsedViewedTab() {
        getHelper(FssHelpers.class).checkRandomLinksFromCollapsedViewedTab(rightPanel);
        return this;
    }

    public FssFormsPage clickSearchButtonOnSolutionsPage() {
        searchButton.click();
        return this;
    }

    @Override
    public FssFormsPage checkTitle(String titleName) {
        getHelper(FormsPageHelper.class).checkTitle(titleName);
        return this;
    }

    @Override
    public FssFormsPage checkNewsBlocksArePresent() {
        getHelper(FormsPageHelper.class).checkNewsBlocksArePresent();
        return this;
    }

    @Override
    public FssFormsPage checkNewsBlocksTitlesArePresent() {
        getHelper(FormsPageHelper.class).checkNewsBlocksTitlesArePresent();
        return this;
    }

    @Override
    public FssFormsPage checkNewsBlocksDatesSortedInDescendingOrder() {
        getHelper(FormsPageHelper.class).checkNewsBlocksDatesSortedInDescendingOrder();
        return this;
    }

    @Override
    public FssFormsPage checkNewsBlocksHaveTitleAndDescription() {
        getHelper(FormsPageHelper.class).checkNewsBlocksHaveTitleAndDescription();
        return this;
    }

    @Override
    public FssFormsPage checkPictureForFirstNewsIsPresent() {
        getHelper(FormsPageHelper.class).checkPictureForFirstNewsIsPresent();
        return this;
    }

    @Override
    public FssFormsPage checkNewsLoadedAfterScrollingDown() {
        getHelper(FormsPageHelper.class).checkNewsLoadedAfterScrollingDown();
        return this;
    }

    @Override
    public FssDocumentPage clickOnRandomLinkFromNewsBlock() {
        getHelper(FormsPageHelper.class).clickOnRandomLinkFromNewsBlock();
        return redirectTo(FssDocumentPage.class);
    }

    @Override
    public FssDocumentPage clickOnRandomLinkFromPopularBlock() {
        getHelper(FormsPageHelper.class).clickOnRandomLinkFromPopularBlock();
        return redirectTo(FssDocumentPage.class);
    }
}