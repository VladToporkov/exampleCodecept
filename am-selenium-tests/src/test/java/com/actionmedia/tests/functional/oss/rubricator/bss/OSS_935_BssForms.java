package com.actionmedia.tests.functional.oss.rubricator.bss;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.rubricator;

/**
 * Created by n.minochkina
 */
public class OSS_935_BssForms extends AbstractDomainTest {

    @Test(groups = {rubricator})
    @TestLink(testCaseId = "OSS-935", testCaseVersion = "1")
    public void oss_935_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        loginBss()
                .navigateToFormsPage()
                .clickRubricatorButton()
                .checkAllRubricatorSectionsHaveContent()
                .clickRandomArticle()
                .checkDocumentTitleIsPresent()
                .navigateToFormsPage()
                .clickRubricatorButton()
                .clickRandomArticle()
                .checkDocumentTitleIsPresent()
                .navigateToFormsPage()
                .clickRubricatorButton()
                .checkAllRubricsInRubricator()
                .logout();
    }
}
