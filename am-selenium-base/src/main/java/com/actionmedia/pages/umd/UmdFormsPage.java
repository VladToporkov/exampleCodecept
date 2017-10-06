package com.actionmedia.pages.umd;

import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.cult.CultDocumentPage;
import com.actionmedia.pages.helpers.FormsPageHelper;
import com.actionmedia.pages.interfaces.IFormsPage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Pavel on 28/06/16.
 */
@Component
public class UmdFormsPage extends UmdBasePage<UmdFormsPage> implements IFormsPage {

    @Override
    public UmdFormsPage checkDefaultStateFormsPage() {
        checkFormsTabIsSelected();
        checkSearchBoxIsPresent("Поиск форм и образцов");
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Формы'")
    public UmdFormsPage checkFormsTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.TEMPLATES);
        return this;
    }

    @Override
    public UmdFormsPage checkTitle(String titleName) {
        getHelper(FormsPageHelper.class).checkTitle(titleName);
        return this;
    }

    @Override
    public UmdFormsPage checkNewsBlocksArePresent() {
        getHelper(FormsPageHelper.class).checkNewsBlocksArePresent();
        return this;
    }

    @Override
    public UmdFormsPage checkNewsBlocksTitlesArePresent() {
        getHelper(FormsPageHelper.class).checkNewsBlocksTitlesArePresent();
        return this;
    }

    @Override
    public UmdFormsPage checkNewsBlocksDatesSortedInDescendingOrder() {
        getHelper(FormsPageHelper.class).checkNewsBlocksDatesSortedInDescendingOrder();
        return this;
    }

    @Override
    public UmdFormsPage checkNewsBlocksHaveTitleAndDescription() {
        getHelper(FormsPageHelper.class).checkNewsBlocksHaveTitleAndDescription();
        return this;
    }

    @Override
    public UmdFormsPage checkPictureForFirstNewsIsPresent() {
        getHelper(FormsPageHelper.class).checkPictureForFirstNewsIsPresent();
        return this;
    }

    @Override
    public UmdFormsPage checkNewsLoadedAfterScrollingDown() {
        getHelper(FormsPageHelper.class).checkNewsLoadedAfterScrollingDown();
        return this;
    }

    @Override
    public CultDocumentPage clickOnRandomLinkFromNewsBlock() {
        getHelper(FormsPageHelper.class).clickOnRandomLinkFromNewsBlock();
        return redirectTo(CultDocumentPage.class);
    }

    @Override
    public UmdFormsPage checkPopularBlockIsPresent() {
        getHelper(FormsPageHelper.class).checkPopularBlockIsPresent();
        return this;
    }

    @Override
    public UmdFormsPage checkPopularBlockDocumentLinksArePresent() {
        getHelper(FormsPageHelper.class).checkPopularBlockDocumentLinksArePresent();
        return this;
    }

    @Override
    public UmdFormsPage checkPopularBlockMarkersArePresent() {
        getHelper(FormsPageHelper.class).checkPopularBlockMarkersArePresent();
        return this;
    }

    @Override
    public CultDocumentPage clickOnRandomLinkFromPopularBlock() {
        getHelper(FormsPageHelper.class).clickOnRandomLinkFromPopularBlock();
        return redirectTo(CultDocumentPage.class);
    }
}
