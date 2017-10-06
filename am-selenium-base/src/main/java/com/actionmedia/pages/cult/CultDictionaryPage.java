package com.actionmedia.pages.cult;

import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.elpu.ElpuBasePage;
import com.actionmedia.pages.helpers.DictionaryPageHelper;
import com.actionmedia.pages.interfaces.IDictionaryPage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Pavel on 04/07/16.
 */
@Component
public class CultDictionaryPage extends CultBasePage<CultDictionaryPage> implements IDictionaryPage {

    @Step("Проверяется что в главном меню выбрана страница 'Справочник'")
    public CultDictionaryPage checkDictionaryTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.DICTIONARIES);
        return this;
    }

    @Step("Проверяется что справочная доска отображается")
    public CultDictionaryPage checkDictionaryBoardIsDisplayed() {
        getHelper(DictionaryPageHelper.class).checkDictionaryBoardIsDisplayed();
        return this;
    }
}
