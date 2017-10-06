package com.actionmedia.pages.go;

import com.actionmedia.pages.helpers.RubricatorHelper;
import com.actionmedia.pages.interfaces.IRubricator;
import org.springframework.stereotype.Component;

/**
 * Created by n.tyukavkin on 21.08.2016.
 */
@Component
public class GoRubricatorPage extends GoBasePage<GoRubricatorPage> implements IRubricator {

    @Override
    public GoRubricatorPage checkRubricatorIsOpened() {
        getHelper(RubricatorHelper.class).checkRubricatorIsOpened();
        return this;
    }

    @Override
    public GoRubricatorPage openRubricInNewTab() {
        getHelper(RubricatorHelper.class).openRubricInNewTab();
        return this;
    }
}
