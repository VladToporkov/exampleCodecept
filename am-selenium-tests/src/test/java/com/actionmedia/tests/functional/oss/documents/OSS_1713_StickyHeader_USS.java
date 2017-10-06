package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 18/05/16.
 */
public class OSS_1713_StickyHeader_USS extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1713", testCaseVersion = "3")
    public void oss_1713_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Залипающий заголовок (Правовая база) ЮСС КУ");
        test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Залипающий заголовок (Правовая база) ЮСС ВИП");
        test();
    }

    private void test() {
        String documentUrl = "#/document/99/901714421/actual";
        loginUss()
                .openDocumentByModuleIdAndDocId(documentUrl)
                .checkStickyHeaderScrolling()
                .checkStickyHeaderIsGray()
                .clickOnStickyHeader()
                .checkStickyHeaderIsNotPresent()

                .logout();
    }
}