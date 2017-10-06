package com.actionmedia.tests.functional.fss.dictionary;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 12.11.13
 * Time: 18:49
 */
public class FSS_25_VerifyRateWidget extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-25", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_25_test() {
        loginFss()
                .navigateToDictionaryPage()
                .clickSecondScreenInWidgets()
                .checkRateWidget()
                .clickRateWidget()
                .checkPreDefinedDocumentIsOpened()
                .checkRateDocumentIsOpened()
                .checkDownloadButtonIsPresent()
                .checkPrintButtonIsPresent()

                .clickRubricatorButtonFss()
                .checkRubricatorIsOpened()
                .clickCloseRubricatorButton()
                .checkRubricatorIsClosed();
    }
}
