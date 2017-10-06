package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 18/05/16.
 */
public class OSS_1715_StickyHeader_GF extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1715", testCaseVersion = "3")
    public void oss_1715_test() {
        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется Залипающий заголовок (Правовая база) ГФ КУ");
        test();
    }

    private void test() {
        String documentUrl = "#/document/99/901714421/actual";
        loginGF()
                .openDocumentByModuleIdAndDocId(documentUrl)
                .checkStickyHeaderIsGray()
                .checkStickyHeaderScrolling()
                .clickOnStickyHeader()
                .checkStickyHeaderIsNotPresent()

                .logout();
    }
}
