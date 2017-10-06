package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 18/05/16.
 */
public class OSS_1716_StickyHeader_EHS extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1716", testCaseVersion = "3")
    public void oss_1716_test() {
        updateSystemInfo(SystemPubs.ehs);
        updateLoginAsInfo("ehs.user.commercial");
        report("Проверяется Залипающий заголовок (Правовая база) ОТ КУ");
        test();

        updateLoginAsInfo("ehs.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется Залипающий заголовок (Правовая база) ОТ БАЗ");
        test();

        updateLoginAsInfo("ehs.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Залипающий заголовок (Правовая база) ОТ ВИП");
        test();
    }

    private void test() {
        String documentUrl = "#/document/99/901714421/actual";
        loginOT()
                .openDocumentByModuleIdAndDocId(documentUrl)
                .checkStickyHeaderIsGray()
                .checkStickyHeaderScrolling()
                .clickOnStickyHeader()
                .checkStickyHeaderIsNotPresent()

                .logout();
    }
}
