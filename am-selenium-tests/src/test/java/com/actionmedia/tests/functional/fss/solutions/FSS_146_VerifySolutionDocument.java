package com.actionmedia.tests.functional.fss.solutions;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 18.11.13
 * Time: 15:44
 */
public class FSS_146_VerifySolutionDocument extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-146", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_146_test() {
        loginFss()
                .navigateToSolutionsPage()
                .clickRandomSectionInRubricator()
                .clickRandomSubSectionsInRubricator()
                .clickRandomItemFromRubricator()
                .checkFontForDocumentHeaderIsBold(41.25)
                .checkInCutLink()
                .checkDownloadButtonIsPresent()
                .checkPrintButtonIsPresent()
                .checkRandomLinksInDocument()

                .clickRubricatorButtonFss()
                .checkRubricatorIsOpened()

                .clickCloseRubricatorButton()
                .checkRubricatorIsClosed();
    }
}
