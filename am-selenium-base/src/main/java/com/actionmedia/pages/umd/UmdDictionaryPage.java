package com.actionmedia.pages.umd;

import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.helpers.DictionaryPageHelper;
import com.actionmedia.pages.interfaces.IDictionaryPage;
import com.actionmedia.pages.klpu.KlpuBasePage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Pavel on 04/07/16.
 */
@Component
public class UmdDictionaryPage extends UmdBasePage<UmdDictionaryPage> implements IDictionaryPage {

    @Step("Проверяется что в главном меню выбрана страница 'Справочник'")
    public UmdDictionaryPage checkDictionaryTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.DICTIONARIES);
        return this;
    }

    @Step("Проверяется что справочная доска отображается")
    public UmdDictionaryPage checkDictionaryBoardIsDisplayed() {
        getHelper(DictionaryPageHelper.class).checkDictionaryBoardIsDisplayed();
        return this;
    }
}
