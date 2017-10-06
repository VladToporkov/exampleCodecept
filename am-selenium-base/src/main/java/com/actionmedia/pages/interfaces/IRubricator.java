package com.actionmedia.pages.interfaces;

import com.actionmedia.autotest.selenium.context.AbstractPage;

/**
 * Created by n.tyukavkin on 21.08.2016.
 */
public interface IRubricator extends ISystemBasePage {

    IRubricator checkRubricatorIsOpened();

    IRubricator openRubricInNewTab();

    <P extends AbstractPage> P closeCurrentWindow(final Class<P> target);
}
