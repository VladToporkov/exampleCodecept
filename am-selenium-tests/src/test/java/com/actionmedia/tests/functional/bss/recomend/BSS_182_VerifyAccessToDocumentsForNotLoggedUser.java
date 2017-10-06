package com.actionmedia.tests.functional.bss.recomend;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 11.04.2014
 * Time: 13:01
 */
public class BSS_182_VerifyAccessToDocumentsForNotLoggedUser extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-103", testCaseVersion = "2")
    public void bss_103_test() {
        enterToBssWithoutLogin()
                .openDocumentByUrl(getDocumentUrlByKey("bss.184.module"))
                .checkDocumentIsAvailableForNotLoggedUsers()
                .checkAuthFormIsNotOpened()

                .openDocumentByUrl(getDocumentUrlByKey("bss.99.module"))
                .checkDocumentIsAvailableForNotLoggedUsers()
                .checkAuthFormIsNotOpened()

                .openDocumentByUrl(getDocumentUrlByKey("bss.81.module"))
                .checkDocumentIsAvailableForNotLoggedUsers()
                .checkAuthFormIsNotOpened()

                .openDocumentByUrl(getDocumentUrlByKey("bss.97.module"))
                .checkDocumentIsAvailableForNotLoggedUsers()
                .checkAuthFormIsNotOpened()

                .openDocumentByUrl(getDocumentUrlByKey("bss.98.module"))
                .checkDocumentIsAvailableForNotLoggedUsers()
                .checkAuthFormIsNotOpened()

                .openDocumentByUrl(getDocumentUrlByKey("bss.192.module"))
                .checkDocumentIsAvailableForNotLoggedUsers()
                .checkAuthFormIsNotOpened()

                .openDocumentByUrl(getDocumentUrlByKey("bss.125.module"))
                .checkDocumentIsAvailableForNotLoggedUsers()
                .checkAuthFormIsNotOpened();
    }
}
