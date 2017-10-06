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
 * Time: 18:23
 */
public class FSS_24_VerifyCurrencyWidget extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-24", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_24_test() {
        loginFss()
                .navigateToDictionaryPage()
                .checkCurrencyWidget()
                .clickCurrencyWidget()
                .checkPreDefinedDocumentIsOpened()
                .checkCurrencyDocumentIsOpened()
                .checkDownloadButtonIsPresent()
                .checkPrintButtonIsPresent()

                .clickRubricatorButtonFss()
                .checkRubricatorIsOpened()
                .clickCloseRubricatorButton()
                .checkRubricatorIsClosed();
    }
}
