package com.actionmedia.tests.functional.oss.rubricator.bss;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.rubricator;

/**
 * Created by n.minochkina
 */
public class OSS_937_BssPress extends AbstractDomainTest {

    @Test(groups = {rubricator})
    @TestLink(testCaseId = "OSS-937", testCaseVersion = "1")
    public void oss_937_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        loginBss()
                .navigateToMagazinesPage()
                .clickRubricatorButton()
                .checkAllRubricatorSectionsHaveContent()
                .clickRandomArticle()
                .checkArticleTitle()
                .checkContentIsPresent()
                .navigateToMagazinesPage()
                .clickRubricatorButton()
                .clickRandomArticle()
                .checkArticleTitle()
                .checkContentIsPresent()
                .navigateToMagazinesPage()
                .clickRubricatorButton()
                .checkAllRubricsInRubricator()
                .logout();
    }
}
