package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 18/05/16.
 */
public class OSS_1717_StickyHeader_EDU extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1717", testCaseVersion = "3")
    public void oss_1717_test() {
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.commercial");
        report("Проверяется Залипающий заголовок (Правовая база) ОБР КУ");
        test();

        updateLoginAsInfo("edu.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется Залипающий заголовок (Правовая база) ОБР БАЗ");
        test();

        updateLoginAsInfo("edu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Залипающий заголовок (Правовая база) ОБР ВИП");
        test();
    }

    private void test() {
        String documentUrl = "#/document/99/901714421/actual";
        loginEdu()
                .openDocumentByModuleIdAndDocId(documentUrl)
                .checkStickyHeaderIsGray()
                .checkStickyHeaderScrolling()
                .clickOnStickyHeader()
                .checkStickyHeaderIsNotPresent()

                .logout();
    }
}
