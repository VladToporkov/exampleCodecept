package com.actionmedia.tests.functional.oss.rubricator.bss;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.rubricator;

/**
 * Created by n.minochkina
 */
public class OSS_939_BssServices extends AbstractDomainTest {

    @Test(groups = {rubricator})
    @TestLink(testCaseId = "OSS-939", testCaseVersion = "1")
    public void oss_939_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        loginBss()
                .navigateToServicesPage()
                .clickRubricatorButton()
                .checkAllRubricatorSectionsHaveContent()
                .clickRandomArticle()
                .checkDocumentTitleIsPresent()
                .navigateToServicesPage()
                .clickRubricatorButton()
                .clickRandomArticle()
                .checkDocumentTitleIsPresent()
                .navigateToServicesPage()
                .clickRubricatorButton()
                .checkAllRubricsInRubricator()
                .logout();
    }
}
