package com.actionmedia.tests.functional.fss.dictionary;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.fss.FssDocumentPage;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 18.11.13
 * Time: 15:44
 */
public class FSS_144_VerifyDictionaryDocument extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-144", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_144_test() {
        FssDocumentPage fssDocumentPage = loginFss()
                .navigateToDictionaryPage()
                .clickRandomSectionInRubricator()
                .clickRandomItemFromRubricator()
                .checkFontForDocumentHeaderIsBold(41.25)
                .checkDownloadButtonIsPresent()
                .checkPrintButtonIsPresent()
                .checkRandomLinksInDocument();

        if (fssDocumentPage.isRightPanelPresent()) {
            fssDocumentPage
                    .checkLinksInRightPanel()
                    .clickRightPanel()
                    .checkRightPanelIsOpened()
                    .closeRightPanel()
                    .checkRightPanelIsClosed();
        }

        fssDocumentPage.clickRubricatorButtonFss()
                .checkRubricatorIsOpened()

                .clickCloseRubricatorButton()
                .checkRubricatorIsClosed();
    }
}
