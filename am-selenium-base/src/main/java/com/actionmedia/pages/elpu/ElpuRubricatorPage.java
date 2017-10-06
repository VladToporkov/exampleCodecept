package com.actionmedia.pages.elpu;

import com.actionmedia.pages.helpers.RubricatorHelper;
import com.actionmedia.pages.interfaces.IRubricator;
import org.springframework.stereotype.Component;

/**
 * Created by n.tyukavkin on 21.08.2016.
 */
@Component
public class ElpuRubricatorPage extends ElpuBasePage<ElpuRubricatorPage> implements IRubricator {

    @Override
    public ElpuRubricatorPage checkRubricatorIsOpened() {
        getHelper(RubricatorHelper.class).checkRubricatorIsOpened();
        return this;
    }

    @Override
    public ElpuRubricatorPage openRubricInNewTab() {
        getHelper(RubricatorHelper.class).openRubricInNewTab();
        return this;
    }
}
