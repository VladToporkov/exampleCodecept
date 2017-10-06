package com.actionmedia.tests.functional.oss.rubricator.uss;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.rubricator;

/**
 * Created by n.minochkina
 */
public class OSS_942_UssLawBase extends AbstractDomainTest {

    @Test(groups = {rubricator})
    @TestLink(testCaseId = "OSS-942", testCaseVersion = "1")
    public void oss_942_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        loginUss()
                .navigateToLawBasePage()
                .clickRubricatorButton()
                .checkAllRubricatorSectionsHaveContent()
                .clickRandomArticle()
                .checkContentIsPresent()
                .navigateToLawBasePage()
                .clickRubricatorButton()
                .clickRandomArticle()
                .checkContentIsPresent()
                .navigateToLawBasePage()
                .clickRubricatorButton()
                .checkAllRubricsInRubricator()
                .logout();
    }
}
