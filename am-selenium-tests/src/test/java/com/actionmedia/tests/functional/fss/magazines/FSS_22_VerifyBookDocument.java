package com.actionmedia.tests.functional.fss.magazines;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 15.11.13
 * Time: 17:31
 */
public class FSS_22_VerifyBookDocument extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-22", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_22_test() {
        loginFss()
                .navigateToMagazinesPage()
                .clickRandomBook()
                .clickRandomBookChapter()

                .checkPreviewButtonIsPresent()
                .checkDownloadButtonIsPresent()
                .checkPrintButtonIsPresent()
                .checkScrollButtonsArePresent()

                .setCurrentUrlToParameter()
                .clickBackButton()
                .checkPreviousPageIsOpened()
                .clickNextButton()
                .checkFirstPageIsOpened()
                .clickNextButton()
                .checkNextPageIsOpened()
                .clickBackButton()
                .checkFirstPageIsOpened()

                .clickRubricatorButtonFss()
                .checkRubricatorIsOpened();
    }
}
