package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel on 21/01/16.
 */
public class OSS_631_TableOfContents extends AbstractDomainTest {

    private static final String DOCUMENT_URL_BSS_TABLE_OF_CONTENTS_1 = "#/document/11/13621";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-631", testCaseVersion = "1")
    public void oss_631_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Быстрое оглавление БСС КУ");
        bss_test();
    }

    public void bss_test() {
        loginBss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_TABLE_OF_CONTENTS_1)
                .checkScrolling()

                .logout();
    }
}
