package com.actionmedia.tests.functional.bss.recomend;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 01.06.2014
 * Time: 13:34
 */
public class BSS_201_VerifyOldAuthFormInDocuments extends AbstractDomainTest {

    private static final String ONLY_PAIED_TEXT = "Документ в платном доступе";

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "BSS-201", testCaseVersion = "1")
    @Version(section = "vip")
    public void bss_201_test() {
        enterToBssWithoutLogin()
                .openDocumentByUrl(getDocumentUrlByKey("bss.118.module"))
                .checkAuthFormIsOpened()
                .checkDocPreviewIsNotOpened()
                .checkTextAroundLockInDocPreview(ONLY_PAIED_TEXT)

                .openDocumentByUrl(getDocumentUrlByKey("bss.140.module"))
                .checkAuthFormIsOpened()
                .checkDocPreviewIsNotOpened()
                .checkTextAroundLockInDocPreview(ONLY_PAIED_TEXT)

                .openDocumentByUrl(getDocumentUrlByKey("bss.117.module"))
                .checkAuthFormIsOpened()
                .checkDocPreviewIsNotOpened()
                .checkTextAroundLockInDocPreview(ONLY_PAIED_TEXT)

                .openDocumentByUrl(getDocumentUrlByKey("bss.189.module"))
                .checkAuthFormIsOpened()
                .checkDocPreviewIsNotOpened()
                .checkTextAroundLockInDocPreview(ONLY_PAIED_TEXT)

                .openDocumentByUrl(getDocumentUrlByKey("bss.160.module"))
                .checkAuthFormIsOpened()
                .checkDocPreviewIsNotOpened()
                .checkTextAroundLockInDocPreview(ONLY_PAIED_TEXT)

                .openDocumentByUrl(getDocumentUrlByKey("bss.145.module"))
                .checkAuthFormIsOpened()
                .checkDocPreviewIsNotOpened()
                .checkTextAroundLockInDocPreview(ONLY_PAIED_TEXT)

                .openDocumentByUrl(getDocumentUrlByKey("bss.193.module"))
                .checkAuthFormIsOpened()
                .checkDocPreviewIsNotOpened()
                .checkTextAroundLockInDocPreview(ONLY_PAIED_TEXT)

                .openDocumentByUrl(getDocumentUrlByKey("bss.150.module"))
                .checkAuthFormIsOpened()
                .checkDocPreviewIsNotOpened()
                .checkTextAroundLockInDocPreview(ONLY_PAIED_TEXT);
    }
}
