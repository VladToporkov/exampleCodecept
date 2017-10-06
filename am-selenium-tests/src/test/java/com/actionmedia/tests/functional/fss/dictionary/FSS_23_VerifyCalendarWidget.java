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
 * Time: 17:10
 */
public class FSS_23_VerifyCalendarWidget extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-23", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_23_test() {
        loginFss()
                .navigateToDictionaryPage()
                .checkCalendarWidget()
                .clickCalendarWidget()
                .checkPreDefinedDocumentIsOpened()
                .checkCalendarIsOpened()
                .checkDownloadButtonIsPresent()
                .checkPrintButtonIsPresent()

                .clickRubricatorButtonFss()
                .checkRubricatorIsOpened()
                .clickCloseRubricatorButton()
                .checkRubricatorIsClosed();
    }
}
