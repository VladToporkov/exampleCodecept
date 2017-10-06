package com.actionmedia.tests.functional.fss.dictionary;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 13.11.13
 * Time: 9:34
 */
public class FSS_26_VerifyFormulaWidget extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-26", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_26_test() {
        loginFss()
                .navigateToDictionaryPage()
                .clickSecondScreenInWidgets()
                .checkFormulaWidget()
                .clickFormulaWidget()
                .checkPreDefinedDocumentIsOpened()
                .checkFormulaDocumentIsOpened()
                .checkDownloadButtonIsPresent()
                .checkPrintButtonIsPresent()

                .clickRubricatorButtonFss()
                .checkRubricatorIsOpened()
                .clickCloseRubricatorButton()
                .checkRubricatorIsClosed();
    }
}
