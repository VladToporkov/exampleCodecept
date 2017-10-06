package com.actionmedia.tests.functional.oss.rubricator.kss;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.rubricator;

/**
 * Created by n.minochkina
 */
public class OSS_913_KssHandbook extends AbstractDomainTest {

    @Test(groups = {rubricator})
    @TestLink(testCaseId = "OSS-913", testCaseVersion = "1")
    public void oss_913_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        loginKss()
                .navigateToDictionaryPage()
                .clickRubricatorButton()
                .checkAllRubricatorSectionsHaveContent()
                .clickRandomArticle()
                .checkDocumentTitleIsPresent()
                .navigateToDictionaryPage()
                .clickRubricatorButton()
                .clickRandomArticle()
                .checkDocumentTitleIsPresent()
                .navigateToDictionaryPage()
                .clickRubricatorButton()
                .checkAllRubricsInRubricator()
                .logout();
    }
}
