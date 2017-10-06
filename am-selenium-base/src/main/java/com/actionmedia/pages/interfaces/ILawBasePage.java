package com.actionmedia.pages.interfaces;

import org.springframework.stereotype.Component;

/**
 * Created by Pavel on 13/07/16.
 */
@Component
public interface ILawBasePage extends ISystemBasePage {

    ILawBasePage checkMainLawBasePageIsOpened();
}
