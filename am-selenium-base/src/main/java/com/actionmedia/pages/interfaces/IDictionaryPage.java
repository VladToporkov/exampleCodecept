package com.actionmedia.pages.interfaces;

import org.springframework.stereotype.Component;

/**
 * Created by Pavel on 04/07/16.
 */
@Component
public interface IDictionaryPage extends ISystemBasePage {

    IDictionaryPage checkDictionaryTabIsSelected();

    IDictionaryPage checkDictionaryBoardIsDisplayed();
}
