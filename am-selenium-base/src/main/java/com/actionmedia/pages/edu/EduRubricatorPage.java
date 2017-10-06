package com.actionmedia.pages.edu;

import com.actionmedia.pages.helpers.RubricatorHelper;
import com.actionmedia.pages.interfaces.IRubricator;
import org.springframework.stereotype.Component;

/**
 * Created by Pavel on 18/04/16.
 */
@Component
public class EduRubricatorPage extends EduBasePage<EduRubricatorPage> implements IRubricator {

    public EduDocumentPage clickFirstArticle() {
        getHelper(RubricatorHelper.class).clickFirstArticle();
        return redirectTo(EduDocumentPage.class);
    }

    public EduDocumentPage clickLastArticle() {
        getHelper(RubricatorHelper.class).clickLastArticle();
        return redirectTo(EduDocumentPage.class);
    }

    public EduDocumentPage clickRandomNotFirstAndNotLastArticle() {
        getHelper(RubricatorHelper.class).clickRandomNotFirstAndNotLastArticle();
        return redirectTo(EduDocumentPage.class);
    }

    @Override
    public EduRubricatorPage checkRubricatorIsOpened() {
        getHelper(RubricatorHelper.class).checkRubricatorIsOpened();
        return this;
    }

    @Override
    public EduRubricatorPage openRubricInNewTab() {
        getHelper(RubricatorHelper.class).openRubricInNewTab();
        return this;
    }
}
