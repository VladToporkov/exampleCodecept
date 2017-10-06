package com.actionmedia.pages.umd;

import com.actionmedia.pages.helpers.RubricatorHelper;
import com.actionmedia.pages.interfaces.IRubricator;
import com.actionmedia.pages.klpu.KlpuBasePage;
import org.springframework.stereotype.Component;

/**
 * Created by n.tyukavkin on 21.08.2016.
 */
@Component
public class UmdRubricatorPage extends UmdBasePage<UmdRubricatorPage> implements IRubricator {

    @Override
    public UmdRubricatorPage checkRubricatorIsOpened() {
        getHelper(RubricatorHelper.class).checkRubricatorIsOpened();
        return this;
    }

    @Override
    public UmdRubricatorPage openRubricInNewTab() {
        getHelper(RubricatorHelper.class).openRubricInNewTab();
        return this;
    }
}
