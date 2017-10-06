package com.actionmedia.pages.elpu;

import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.go.GoBasePage;
import com.actionmedia.pages.helpers.DictionaryPageHelper;
import com.actionmedia.pages.interfaces.IDictionaryPage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Pavel on 04/07/16.
 */
@Component
public class ElpuDictionaryPage extends ElpuBasePage<ElpuDictionaryPage> implements IDictionaryPage {

    @Step("Проверяется что в главном меню выбрана страница 'Справочник'")
    public ElpuDictionaryPage checkDictionaryTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.DICTIONARIES);
        return this;
    }

    @Step("Проверяется что справочная доска отображается")
    public ElpuDictionaryPage checkDictionaryBoardIsDisplayed() {
        getHelper(DictionaryPageHelper.class).checkDictionaryBoardIsDisplayed();
        return this;
    }
}
