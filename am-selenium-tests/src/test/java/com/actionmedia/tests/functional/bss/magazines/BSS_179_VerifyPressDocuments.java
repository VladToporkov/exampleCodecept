package com.actionmedia.tests.functional.bss.magazines;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 23.04.2014
 * Time: 17:01
 */
public class BSS_179_VerifyPressDocuments extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-179", testCaseVersion = "3")
    @LoginAs(key = "bss.user.commercial")
    public void bss_179_test() {
        loginBss()
                .navigateToMagazinesPage()
                .openDocumentByUrl(getDocumentUrlByKey("bss.192.module"))
                .checkDocumentIsNotEmpty()
                .checkArticleListIsPresent()

                .openDocumentByUrl(getDocumentUrlByKey("bss.189.module"))
                .checkDocumentIsNotEmpty()

                .openDocumentByUrl(getDocumentUrlByKey("bss.234.module"))
                .checkDocumentIsNotEmpty()
                .checkArticleListIsPresent()

                .openDocumentByUrl(getDocumentUrlByKey("bss.160.module"))
                .checkDocumentIsNotEmpty()

                .openDocumentByUrl(getDocumentUrlByKey("bss.125.module"))
                .checkDocumentIsNotEmpty()
                .checkArticleListIsPresent()

                .openDocumentByUrl(getDocumentUrlByKey("bss.126.module"))
                .checkDocumentIsNotEmpty()
                .logout();
    }
}
