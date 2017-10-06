package com.actionmedia.tests.functional.oss.rubricator.fss;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by n.minochkina
 */
public class OSS_955_FssServices extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-955", testCaseVersion = "2")
    public void oss_955_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        loginFss()
                .navigateToServicesPage()
                .clickRubricatorButton()
                .checkAllRubricatorSectionsHaveContent()
                .clickRandomArticle()
                .checkContentIsPresent()
                .navigateToServicesPage()
                .clickRubricatorButton()
                .clickRandomArticle()
                .checkContentIsPresent()
                .navigateToServicesPage()
                .clickRubricatorButton()
                .checkAllRubricsInRubricator()
                .logout();
    }
}
