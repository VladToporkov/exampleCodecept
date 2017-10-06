package com.actionmedia.tests.functional.bss.magazines;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.bss.BssRubricator;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 15.04.2014
 * Time: 11:42
 */
public class BSS_133_VerifyBookFunctionality extends AbstractDomainTest {

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "BSS-133", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_133_test() {
        BssRubricator bssRubricator = loginBss()
                .navigateToMagazinesPage()
                .clickRubricatorButton()
                .clickRandomBook();

        while (!bssRubricator.isNotFirstAndNotLastArticle()) {
            bssRubricator
                    .clickRandomBook();
        }

        bssRubricator
                .clickRandomNotFirstAndNotLastArticle()

                .clickNextButtonInTop()
                .checkNextPageIsOpened()

                .clickPrevButtonInTop()
                .checkPrevPageIsOpened()

                .clickNextButtonInBottom()
                .checkNextPageIsOpened()

                .clickPrevButtonInBottom()
                .checkPrevPageIsOpened()

                .clickRubricatorButton()
                .clickFirstArticle()
                .checkPrevButtonInTopIsAbsent()
                .checkPrevButtonInBottomIsAbsent()

                .clickRubricatorButton()
                .clickLastArticle()
                .checkNextButtonInTopIsAbsent()
                .checkNextButtonInBottomIsAbsent()

                .openDocumentByUrl(getDocumentUrlByKey("bss.magazine.incut"))
                .checkInCutInMagazinesArticle()
                .logout();
    }
}
