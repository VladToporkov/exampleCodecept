package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 18/05/16.
 */
public class OSS_1712_StickyHeader_KSS extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1712", testCaseVersion = "3")
    public void oss_1712_test() {
            updateSystemInfo(SystemPubs.kss);
            updateLoginAsInfo("kss.user.commercial");
            report("Проверяется Залипающий заголовок (Правовая база) КСС КУ");
            test();

            updateLoginAsInfo("kss.user.budget");
            updateLoginToInfo("budget");
            report("Проверяется Залипающий заголовок (Правовая база) КСС БУ");
            test();

            updateLoginAsInfo("kss.user.vip");
            updateLoginToInfo("vip");
            report("Проверяется Залипающий заголовок (Правовая база) КСС ВИП");
            test();
    }

    private void test() {
        String documentUrl = "#/document/99/901714421/actual";
        loginKss()
                .openDocumentByModuleIdAndDocId(documentUrl)
                .checkStickyHeaderIsGray()
                .checkStickyHeaderScrolling()
                .clickOnStickyHeader()
                .checkStickyHeaderIsNotPresent()

                .logout();
    }
}