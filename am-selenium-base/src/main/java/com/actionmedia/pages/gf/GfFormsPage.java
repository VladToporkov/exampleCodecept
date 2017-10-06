package com.actionmedia.pages.gf;

import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.helpers.FormsPageHelper;
import com.actionmedia.pages.interfaces.IFormsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

/**
 * Created by Pavel on 28/03/16.
 */
@Component
public class GfFormsPage extends GFBasePage<GfFormsPage> implements IFormsPage {

    @Step("Проверяются элементы на странице 'Формы'")
    public GfFormsPage checkDefaultStateFormsPage() {
        checkFormsTabIsSelected();
        checkSearchBoxPresentOnFormsPage();
        checkNewsBlockIsPresent();
        checkPopularBlocksIsPresent();
        checkFormPictureIsPresent();
        checkFormsRubricatorButtonIsPresent();
        checkMyFavoritesRubricatorButtonIsPresent();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Формы'")
    public GfFormsPage checkFormsTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.FORMS);
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Формы'")
    public GfFormsPage checkSearchBoxPresentOnFormsPage() {
        checkSearchBoxIsPresent("Поиск форм и образцов");
        return this;
    }

    @Step("Проверяется блок 'Новое' на странице 'Формы'")
    public GfFormsPage checkNewsBlockIsPresent() {
        List<WebElement> newBlocks = findElementsBy(By.cssSelector("[class*='changes']"));
        postponedAssertFalse(newBlocks.isEmpty(), "Блок Новое Отсутствует");
        return this;
    }

    @Step("Проверяется блок 'Популярное' на странице 'Формы'")
    public GfFormsPage checkPopularBlocksIsPresent() {
        List<WebElement> popularBlocks = sidebarElement.findElements(By.cssSelector(".news__item"));
        postponedAssertFalse(popularBlocks.isEmpty(), "Блок Популярное пустой");
        return this;
    }

    @Step("Проверяется что картинка для новой формы отображается")
    public GfFormsPage checkFormPictureIsPresent() {
        WebElement formPicture = findElementByNoThrow(mainLeftElement, By.cssSelector("[class*='form-']"));
        postponedAssertTrue(formPicture != null && formPicture.isDisplayed(), "Картинка с формой не отображается");
        return this;
    }

    @Step("Проверяется что кнопка рубрикатора форм отображается")
    public GfFormsPage checkFormsRubricatorButtonIsPresent() {
        WebElement rubricatorButton = waitForPresenceOfElementLocatedBy(By.id("rubricator-btn"), "Кнопка Все формы не отображается");
        postponedAssertEquals(rubricatorButton.getText(), "Все формы", "Неправильный текст кнопки Все формы");
        return this;
    }

    @Override
    public GfFormsPage checkTitle(String titleName) {
        getHelper(FormsPageHelper.class).checkTitle(titleName);
        return this;
    }

    @Override
    public GfFormsPage checkNewsBlocksArePresent() {
        getHelper(FormsPageHelper.class).checkNewsBlocksArePresent();
        return this;
    }

    @Override
    public GfFormsPage checkNewsBlocksTitlesArePresent() {
        getHelper(FormsPageHelper.class).checkNewsBlocksTitlesArePresent();
        return this;
    }

    @Override
    public GfFormsPage checkNewsBlocksDatesSortedInDescendingOrder() {
        getHelper(FormsPageHelper.class).checkNewsBlocksDatesSortedInDescendingOrder();
        return this;
    }

    @Override
    public GfFormsPage checkNewsBlocksHaveTitleAndDescription() {
        getHelper(FormsPageHelper.class).checkNewsBlocksHaveTitleAndDescription();
        return this;
    }

    @Override
    public GfFormsPage checkPictureForFirstNewsIsPresent() {
        getHelper(FormsPageHelper.class).checkPictureForFirstNewsIsPresent();
        return this;
    }

    @Override
    public GfFormsPage checkNewsLoadedAfterScrollingDown() {
        getHelper(FormsPageHelper.class).checkNewsLoadedAfterScrollingDown();
        return this;
    }

    @Override
    public GfDocumentPage clickOnRandomLinkFromNewsBlock() {
        getHelper(FormsPageHelper.class).clickOnRandomLinkFromNewsBlock();
        return redirectTo(GfDocumentPage.class);
    }

    public GfFormsPage checkPopularBlockIsPresent() {
        getHelper(FormsPageHelper.class).checkPopularBlockIsPresent();
        return this;
    }

    @Override
    public GfFormsPage checkPopularBlockDocumentLinksArePresent() {
        getHelper(FormsPageHelper.class).checkPopularBlockDocumentLinksArePresent();
        return this;
    }

    @Override
    public GfFormsPage checkPopularBlockMarkersArePresent() {
        getHelper(FormsPageHelper.class).checkPopularBlockMarkersArePresent();
        return this;
    }

    @Override
    public GfDocumentPage clickOnRandomLinkFromPopularBlock() {
        getHelper(FormsPageHelper.class).clickOnRandomLinkFromPopularBlock();
        return redirectTo(GfDocumentPage.class);
    }
}
