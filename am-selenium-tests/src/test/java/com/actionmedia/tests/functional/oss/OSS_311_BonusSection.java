package com.actionmedia.tests.functional.oss;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;


public class OSS_311_BonusSection extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-311", testCaseVersion = "1")
    public void oss_311() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("user.certificate");
        loginBss()
                .clickProfileLink()
                .checkBonusBlockIsPresent()
                .checkBonusBlock()

                .clickFromPointLink()
                .checkFromPointCommentIsAppear()

                .clickSpendPointLink()
                .checkBonusSiteIsOpened()

                .clickGetPointLink()
                .checkPromoBonusSiteIsOpened()

                .logout();

        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("user.certificate");
        loginKss()
                .clickProfileLink()
                .checkBonusBlockIsPresent()
                .checkBonusBlock()

                .clickFromPointLink()
                .checkFromPointCommentIsAppear()

                .clickSpendPointLink()
                .checkBonusSiteIsOpened()

                .clickGetPointLink()
                .checkPromoBonusSiteIsOpened()

                .logout();

        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("user.certificate");
        loginUss()
                .clickProfileLink()
                .checkBonusBlockIsPresent()
                .checkBonusBlock()

                .clickFromPointLink()
                .checkFromPointCommentIsAppear()

                .clickSpendPointLink()
                .checkBonusSiteIsOpened()

                .clickGetPointLink()
                .checkPromoBonusSiteIsOpened()

                .logout();
    }
}
