package com.actionmedia.tests.functional.bss.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.bss.BssBasePage;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.inDevelopment;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 01.04.2014
 * Time: 18:51
 */
public class BSS_95_VerifyLinks extends AbstractDomainTest {

    //TODO Refactored to new implementation
    @Test(groups = {smoke, inDevelopment})
    @TestLink(testCaseId = "BSS-95", testCaseVersion = "2")
    @LoginAs(key = "bss.user.commercial")
    public void bss_95_test() {
        loginBss()
                .navigateToLawBasePage()
                .clickRandomKodeksLink()
                .checkCurrentUrlContainsDocumentUrl(String.valueOf(getParameter(BssBasePage.DOCUMENT_URL)))
                .checkDocumentIsNotEmpty()

                .navigateToLawBasePage()
                .clickRandomKodeksPartLink()
                .checkCurrentUrlContainsDocumentUrl(String.valueOf(getParameter(BssBasePage.DOCUMENT_URL)))
                .checkDocumentIsNotEmpty()

                .navigateToLawBasePage()
                .clickRandomAdditionalDocumentLink()
                .checkCurrentUrlContainsDocumentUrl(String.valueOf(getParameter(BssBasePage.DOCUMENT_URL)))
                .checkDocumentIsNotEmpty()

                .navigateToLawBasePage()
                .clickRandomPopularDocumentLink()
                .checkCurrentUrlContainsDocumentUrl(String.valueOf(getParameter(BssBasePage.DOCUMENT_URL)))
                .checkDocumentIsNotEmpty()

                .navigateToLawBasePage()
                .clickRandomDocumentFromRegionBlockLink()
                .checkCurrentUrlContainsDocumentUrl(String.valueOf(getParameter(BssBasePage.DOCUMENT_URL)))
                .checkDocumentIsNotEmpty()

                .navigateToLawBasePage()
                .clickRandomNewDocumentLink()
                .checkCurrentUrlContainsDocumentUrl(String.valueOf(getParameter(BssBasePage.DOCUMENT_URL)))
                .checkDocumentIsNotEmpty()

                .navigateToLawBasePage()
                .clickSearchOtherDocumentsLink()
                .checkExtendedSearchFormIsPresent()

                .navigateToLawBasePage()
                .clickChangeRegionLink()
                .checkProfilePageIsOpened()
                .logout();
    }
}
