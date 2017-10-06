package com.actionmedia.pages.gf;

import com.actionmedia.pages.helpers.RubricatorHelper;
import com.actionmedia.pages.interfaces.IRubricator;
import org.springframework.stereotype.Component;

/**
 * Created by Pavel on 18/04/16.
 */
@Component
public class GfRubricatorPage extends GFBasePage<GfRubricatorPage> implements IRubricator {

    public GfDocumentPage clickFirstArticle() {
        getHelper(RubricatorHelper.class).clickFirstArticle();
        return redirectTo(GfDocumentPage.class);
    }

    public GfDocumentPage clickLastArticle() {
        getHelper(RubricatorHelper.class).clickLastArticle();
        return redirectTo(GfDocumentPage.class);
    }

    public GfDocumentPage clickRandomNotFirstAndNotLastArticle() {
        getHelper(RubricatorHelper.class).clickRandomNotFirstAndNotLastArticle();
        return redirectTo(GfDocumentPage.class);
    }

    @Override
    public GfRubricatorPage checkRubricatorIsOpened() {
        getHelper(RubricatorHelper.class).checkRubricatorIsOpened();
        return this;
    }

    @Override
    public GfRubricatorPage openRubricInNewTab() {
        getHelper(RubricatorHelper.class).openRubricInNewTab();
        return this;
    }
}
