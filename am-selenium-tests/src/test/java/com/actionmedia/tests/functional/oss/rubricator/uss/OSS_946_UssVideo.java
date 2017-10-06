package com.actionmedia.tests.functional.oss.rubricator.uss;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.rubricator;

/**
 * Created by n.minochkina
 */
public class OSS_946_UssVideo extends AbstractDomainTest {

    @Test(groups = {rubricator})
    @TestLink(testCaseId = "OSS-946", testCaseVersion = "1")
    public void oss_946_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        loginUss()
                .navigateToVideoPage()
                .clickRubricatorButton()
                .checkAllRubricatorSectionsHaveContent()
                .clickRandomArticle()
                .checkContentIsPresent()
                .navigateToVideoPage()
                .clickRubricatorButton()
                .clickRandomArticle()
                .checkContentIsPresent()
                .navigateToVideoPage()
                .clickRubricatorButton()
                .checkAllRubricsInRubricator()
                .logout();
    }
}
