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
public class BSS_103_VerifyAccessToDocumentsForNotLoggedUser extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-103", testCaseVersion = "2")
    public void bss_103_test() {
        enterToBssWithoutLogin()
                .openDocumentByUrl(getDocumentUrlByKey("bss.111.module"))
                .checkDocumentIsNotAvailableForNotLoggedUsers()
                .checkAuthFormIsOpened()

                .openDocumentByUrl(getDocumentUrlByKey("bss.118.module"))
                .checkDocumentIsNotAvailableForNotLoggedUsers()
                .checkAuthFormIsOpened()

                .openDocumentByUrl(getDocumentUrlByKey("bss.140.module"))
                .checkDocumentIsNotAvailableForNotLoggedUsers()
                .checkAuthFormIsOpened()

                .openDocumentByUrl(getDocumentUrlByKey("bss.117.module"))
                .checkDocumentIsNotAvailableForNotLoggedUsers()
                .checkAuthFormIsOpened()

                .openDocumentByUrl(getDocumentUrlByKey("bss.189.module"))
                .checkDocumentIsNotAvailableForNotLoggedUsers()
                .checkAuthFormIsOpened()

                .openDocumentByUrl(getDocumentUrlByKey("bss.126.module"))
                .checkDocumentIsNotAvailableForNotLoggedUsers()
                .checkAuthFormIsOpened()

                .openDocumentByUrl(getDocumentUrlByKey("bss.145.module"))
                .checkDocumentIsNotAvailableForNotLoggedUsers()
                .checkAuthFormIsOpened();
    }
}
