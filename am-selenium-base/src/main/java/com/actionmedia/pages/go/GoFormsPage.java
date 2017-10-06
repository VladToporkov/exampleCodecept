package com.actionmedia.pages.go;

import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.elpu.ElpuFormsPage;
import com.actionmedia.pages.helpers.FormsPageHelper;
import com.actionmedia.pages.interfaces.IFormsPage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Pavel on 24/06/16.
 */
@Component
public class GoFormsPage extends GoBasePage<GoFormsPage> implements IFormsPage {

    @Override
    public GoFormsPage checkDefaultStateFormsPage() {
        checkFormsTabIsSelected();
        checkSearchBoxIsPresent("Поиск форм и образцов");
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Формы'")
    public GoFormsPage checkFormsTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.TEMPLATES);
        return this;
    }

    @Override
    public GoFormsPage checkTitle(String titleName) {
        getHelper(FormsPageHelper.class).checkTitle(titleName);
        return this;
    }

    @Override
    public GoFormsPage checkNewsBlocksArePresent() {
        getHelper(FormsPageHelper.class).checkNewsBlocksArePresent();
        return this;
    }

    @Override
    public GoFormsPage checkNewsBlocksTitlesArePresent() {
        getHelper(FormsPageHelper.class).checkNewsBlocksTitlesArePresent();
        return this;
    }

    @Override
    public GoFormsPage checkNewsBlocksDatesSortedInDescendingOrder() {
        getHelper(FormsPageHelper.class).checkNewsBlocksDatesSortedInDescendingOrder();
        return this;
    }

    @Override
    public GoFormsPage checkNewsBlocksHaveTitleAndDescription() {
        getHelper(FormsPageHelper.class).checkNewsBlocksHaveTitleAndDescription();
        return this;
    }

    @Override
    public GoFormsPage checkPictureForFirstNewsIsPresent() {
        getHelper(FormsPageHelper.class).checkPictureForFirstNewsIsPresent();
        return this;
    }

    @Override
    public GoFormsPage checkNewsLoadedAfterScrollingDown() {
        getHelper(FormsPageHelper.class).checkNewsLoadedAfterScrollingDown();
        return this;
    }

    @Override
    public GoDocumentPage clickOnRandomLinkFromNewsBlock() {
        getHelper(FormsPageHelper.class).clickOnRandomLinkFromNewsBlock();
        return redirectTo(GoDocumentPage.class);
    }

    public GoFormsPage checkPopularBlockIsPresent() {
        getHelper(FormsPageHelper.class).checkPopularBlockIsPresent();
        return this;
    }

    @Override
    public GoFormsPage checkPopularBlockDocumentLinksArePresent() {
        getHelper(FormsPageHelper.class).checkPopularBlockDocumentLinksArePresent();
        return this;
    }

    @Override
    public GoFormsPage checkPopularBlockMarkersArePresent() {
        getHelper(FormsPageHelper.class).checkPopularBlockMarkersArePresent();
        return this;
    }

    @Override
    public GoDocumentPage clickOnRandomLinkFromPopularBlock() {
        getHelper(FormsPageHelper.class).clickOnRandomLinkFromPopularBlock();
        return redirectTo(GoDocumentPage.class);
    }
}
