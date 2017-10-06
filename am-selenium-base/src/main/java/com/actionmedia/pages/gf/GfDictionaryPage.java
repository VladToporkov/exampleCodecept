package com.actionmedia.pages.gf;

import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.helpers.DictionaryPageHelper;
import com.actionmedia.pages.interfaces.IDictionaryPage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Pavel on 06/04/16.
 */
@Component
public class GfDictionaryPage extends GFBasePage<GfDictionaryPage> implements IDictionaryPage {

    @Step("Проверяется что в главном меню выбрана страница 'Справочник'")
    public GfDictionaryPage checkDictionaryTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.DICTIONARIES);
        return this;
    }

    @Step("Проверяется что справочная доска отображается")
    public GfDictionaryPage checkDictionaryBoardIsDisplayed() {
        getHelper(DictionaryPageHelper.class).checkDictionaryBoardIsDisplayed();
        return this;
    }
}
