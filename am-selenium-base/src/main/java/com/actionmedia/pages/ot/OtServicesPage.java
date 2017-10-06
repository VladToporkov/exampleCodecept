package com.actionmedia.pages.ot;

import com.actionmedia.pages.helpers.ServicesHelper;
import org.springframework.stereotype.Component;

/**
 * Created by Pavel on 04/05/16.
 */
@Component
public class OtServicesPage extends OTBasePage<OtServicesPage> {

    public OtServicesPage checkTitleServicesIsPresent() {
        getHelper(ServicesHelper.class).checkTitleServicesIsPresent();
        return this;
    }

    public OtServicesPage checkCalculatorsTitleIsPresent() {
        getHelper(ServicesHelper.class).checkCalculatorsTitleIsPresent();
        return this;
    }

    public OtServicesPage checkTestsTitleIsPresent() {
        getHelper(ServicesHelper.class).checkTestsTitleIsPresent();
        return this;
    }

    public OtServicesPage checkRightBlockIsPresent() {
        getHelper(ServicesHelper.class).checkRightBlockIsPresent();
        return this;
    }

    public OtServicesPage checkAllServicesRubricatorButtonIsPresent() {
        getHelper(ServicesHelper.class).checkAllServicesRubricatorButtonIsPresent();
        return this;
    }

    public OtServicesPage checkCalculatorsBlockIsPresent() {
        getHelper(ServicesHelper.class).checkCalculatorsBlockIsPresent();
        return this;
    }

    public OtServicesPage checkTestsBlockIsPresent() {
        getHelper(ServicesHelper.class).checkTestsBlockIsPresent();
        return this;
    }

    public OtServicesPage checkAllLinks() {
        getHelper(ServicesHelper.class).checkAllLinks();
        return this;
    }

    public OtDocumentPage clickOnRandomCalculatorLink() {
        getHelper(ServicesHelper.class).clickOnRandomCalculatorLink();
        return redirectTo(OtDocumentPage.class);
    }

    public OtDocumentPage clickOnRandomTestsLink() {
        getHelper(ServicesHelper.class).clickOnRandomTestsLink();
        return redirectTo(OtDocumentPage.class);
    }

    public OtDocumentPage clickOnRandomPopularLink() {
        getHelper(ServicesHelper.class).clickOnRandomPopularLink();
        return redirectTo(OtDocumentPage.class);
    }

}
