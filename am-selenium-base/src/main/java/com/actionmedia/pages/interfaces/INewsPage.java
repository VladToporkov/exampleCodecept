package com.actionmedia.pages.interfaces;

import org.springframework.stereotype.Component;

/**
 * Created by Pavel on 11/07/16.
 */
@Component
public interface INewsPage extends ISystemBasePage {

    INewsPage checkNewsIsPresent();
}
