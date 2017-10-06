package com.actionmedia.tests.functional.fss.videos;

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
public class FSS_143_VerifyVideoDocument extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-143", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_143_test() {
        loginFss()
                .navigateToVideoPage()
                .clickRandomSectionInRubricator()
                .clickRandomVideoLink()
                .checkFontForDocumentHeaderIsBold(41.25)
                .checkPresentationButtonIsPresent()

                .checkLinksInRightPanel()
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
