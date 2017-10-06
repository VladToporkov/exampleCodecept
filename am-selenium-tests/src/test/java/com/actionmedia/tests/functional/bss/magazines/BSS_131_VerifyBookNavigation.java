package com.actionmedia.tests.functional.bss.magazines;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 23.04.2014
 * Time: 17:24
 */
public class BSS_131_VerifyBookNavigation extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-131", testCaseVersion = "3")
    @LoginAs(key = "bss.user.commercial")
    public void bss_131_test() {
        loginBss()
                .navigateToMagazinesPage()
                .openDocumentByUrl(getDocumentUrlByKey("bss.160.module"))
                .clickRubricatorButton()
                .clickFirstArticle()
                .checkPrevButtonInTopIsAbsent()
                .checkPrevButtonInBottomIsAbsent()

                .clickNextButtonInTop()
                .checkNextPageIsOpened()

                .clickNextButtonInBottom()
                .checkNextPageIsOpened()

                .clickRubricatorButton()
                .clickLastArticle()
                .checkNextButtonInTopIsAbsent()
                .checkNextButtonInBottomIsAbsent()

                .clickPrevButtonInTop()
                .checkPrevPageIsOpened()

                .clickPrevButtonInBottom()
                .checkPrevPageIsOpened()
                .logout();
    }
}
