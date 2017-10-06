package com.actionmedia.tests.functional.fss.forms;

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
public class FSS_145_VerifyFormsDocument extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-145", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_145_test() {
        loginFss()
                .navigateToFormsPage()
                .clickRandomSectionInRubricator()
                .clickRandomSubSectionsInRubricator()
                .clickRandomItemFromRubricator()
                .checkFontForDocumentHeaderIsBold(41.25)
                .checkDownloadButtonIsPresent()
                .checkPrintButtonIsPresent()
                .checkInCutLink()

                .checkScrollInSoder()

                .clickRightPanel()
                .checkRightPanelIsOpened()
                .closeRightPanel()
                .checkRightPanelIsClosed()

                .clickRubricatorButtonFss()
                .checkRubricatorIsOpened()

                .clickCloseRubricatorButton()
                .checkRubricatorIsClosed();
    }
}
