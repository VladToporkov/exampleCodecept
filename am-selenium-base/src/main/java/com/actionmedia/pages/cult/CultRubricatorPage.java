package com.actionmedia.pages.cult;

import com.actionmedia.pages.helpers.RubricatorHelper;
import com.actionmedia.pages.interfaces.IRubricator;
import com.actionmedia.pages.ot.OTBasePage;
import com.actionmedia.pages.ot.OtRubricatorPage;
import org.springframework.stereotype.Component;

/**
 * Created by n.tyukavkin on 21.08.2016.
 */
@Component
public class CultRubricatorPage extends CultBasePage<CultRubricatorPage> implements IRubricator {

    @Override
    public CultRubricatorPage checkRubricatorIsOpened() {
        getHelper(RubricatorHelper.class).checkRubricatorIsOpened();
        return this;
    }

    @Override
    public CultRubricatorPage openRubricInNewTab() {
        getHelper(RubricatorHelper.class).openRubricInNewTab();
        return this;
    }
}
