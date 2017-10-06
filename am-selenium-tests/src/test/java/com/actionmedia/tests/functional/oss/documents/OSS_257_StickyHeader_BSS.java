package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inTesting;

/**
 * Created by Pavel on 17/05/16.
 */
public class OSS_257_StickyHeader_BSS extends AbstractDomainTest {

    private static String DOCUMENT_URL = "#/document/99/901714421/actual";

    @Test(groups = {inTesting})
    @TestLink(testCaseId = "OSS-257", testCaseVersion = "3")
    public void oss_257_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Залипающий заголовок (Правовая база) БСС КУ");
        test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Залипающий заголовок (Правовая база) БСС КУ");
        test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Залипающий заголовок (Правовая база) БСС КУ");
        test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Залипающий заголовок (Правовая база) БСС КУ");
        test();
    }

    private void test() {
        loginBss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL)
                .checkStickyHeaderIsGray()
                .checkStickyHeaderScrolling()
                .clickOnStickyHeader()
                .checkStickyHeaderIsNotPresent()

                .logout();
    }
}
