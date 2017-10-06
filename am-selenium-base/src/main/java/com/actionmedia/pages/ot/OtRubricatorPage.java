package com.actionmedia.pages.ot;

import com.actionmedia.pages.helpers.RubricatorHelper;
import com.actionmedia.pages.interfaces.IRubricator;
import org.springframework.stereotype.Component;

/**
 * Created by Pavel on 18/04/16.
 */
@Component
public class OtRubricatorPage extends OTBasePage<OtRubricatorPage> implements IRubricator {

    public OtDocumentPage clickFirstArticle() {
        getHelper(RubricatorHelper.class).clickFirstArticle();
        return redirectTo(OtDocumentPage.class);
    }

    public OtDocumentPage clickLastArticle() {
        getHelper(RubricatorHelper.class).clickLastArticle();
        return redirectTo(OtDocumentPage.class);
    }

    public OtDocumentPage clickRandomNotFirstAndNotLastArticle() {
        getHelper(RubricatorHelper.class).clickRandomNotFirstAndNotLastArticle();
        return redirectTo(OtDocumentPage.class);
    }

    @Override
    public OtRubricatorPage checkRubricatorIsOpened() {
        getHelper(RubricatorHelper.class).checkRubricatorIsOpened();
        return this;
    }

    @Override
    public OtRubricatorPage openRubricInNewTab() {
        getHelper(RubricatorHelper.class).openRubricInNewTab();
        return this;
    }
}
