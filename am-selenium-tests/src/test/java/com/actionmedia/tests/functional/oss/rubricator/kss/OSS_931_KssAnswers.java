package com.actionmedia.tests.functional.oss.rubricator.kss;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.rubricator;

/**
 * Created by n.minochkina
 */
public class OSS_931_KssAnswers extends AbstractDomainTest {

    @Test(groups = {rubricator})
    @TestLink(testCaseId = "OSS-931", testCaseVersion = "1")
    public void oss_931_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        loginKss()
                .navigateToAnswersPage()
                .clickRubricatorButton()
                .checkAllRubricatorSectionsHaveContent()
                .clickRandomArticle()
                .checkDocumentTitleIsPresent()
                .navigateToAnswersPage()
                .clickRubricatorButton()
                .clickRandomArticle()
                .checkDocumentTitleIsPresent()
                .navigateToAnswersPage()
                .clickRubricatorButton()
                .checkAllRubricsInRubricator()
                .logout();
    }
}
