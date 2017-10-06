package com.actionmedia.pages.klpu;

import com.actionmedia.pages.helpers.RubricatorHelper;
import com.actionmedia.pages.interfaces.IRubricator;
import org.springframework.stereotype.Component;

/**
 * Created by n.tyukavkin on 21.08.2016.
 */
@Component
public class KlpuRubricatorPage extends KlpuBasePage<KlpuRubricatorPage> implements IRubricator {

    @Override
    public KlpuRubricatorPage checkRubricatorIsOpened() {
        getHelper(RubricatorHelper.class).checkRubricatorIsOpened();
        return this;
    }

    @Override
    public KlpuRubricatorPage openRubricInNewTab() {
        getHelper(RubricatorHelper.class).openRubricInNewTab();
        return this;
    }
}
