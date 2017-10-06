package com.actionmedia.pages.edu;

import com.actionmedia.pages.helpers.ServicesHelper;
import org.springframework.stereotype.Component;

/**
 * Created by Pavel on 05/05/16.
 */
@Component
public class EduServicesPage extends EduBasePage<EduServicesPage> {

    public EduServicesPage checkTitleServicesIsPresent() {
        getHelper(ServicesHelper.class).checkTitleServicesIsPresent();
        return this;
    }

    public EduServicesPage checkConstructorsTitleIsPresent() {
        getHelper(ServicesHelper.class).checkConstructorsTitleIsPresent();
        return this;
    }

    public EduDocumentPage clickOnRandomConstructorsLink() {
        getHelper(ServicesHelper.class).clickOnRandomConstructorsLink();
        return redirectTo(EduDocumentPage.class);
    }

    public EduServicesPage checkRightBlockIsPresent() {
        getHelper(ServicesHelper.class).checkRightBlockIsPresent();
        return this;
    }

    public EduServicesPage checkAllServicesRubricatorButtonIsPresent() {
        getHelper(ServicesHelper.class).checkAllServicesRubricatorButtonIsPresent();
        return this;
    }

    public EduServicesPage checkConstructorsBlockIsPresent() {
        getHelper(ServicesHelper.class).checkConstructorsBlockIsPresent();
        return this;
    }

    public EduDocumentPage clickOnRandomPopularLink() {
        getHelper(ServicesHelper.class).clickOnRandomPopularLink();
        return redirectTo(EduDocumentPage.class);
    }
}
