package com.actionmedia.tests.functional.oss.rubricator.kss;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.rubricator;

/**
 * Created by n.minochkina
 */
public class OSS_912_KssForms extends AbstractDomainTest {

    @Test(groups = {rubricator})
    @TestLink(testCaseId = "OSS-912", testCaseVersion = "1")
    public void oss_912_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        loginKss()
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
