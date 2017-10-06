package com.actionmedia.tests.functional.oss.rubricator.fss;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by n.minochkina
 */
public class OSS_1384_FssBooks extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1384", testCaseVersion = "1")
    public void oss_1384_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        loginFss()
                .navigateToMagazinesPage()
                .clickRubricatorButton()
                .openFssBooks()
                .logout();
    }
}
