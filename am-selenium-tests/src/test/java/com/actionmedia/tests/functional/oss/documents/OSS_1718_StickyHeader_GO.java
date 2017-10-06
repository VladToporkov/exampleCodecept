package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 18/05/16.
 */
public class OSS_1718_StickyHeader_GO extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1718", testCaseVersion = "3")
    public void oss_1718_test() {
        updateSystemInfo(SystemPubs.go);
        updateLoginAsInfo("go.user.commercial");
        report("Проверяется Залипающий заголовок (Правовая база) ГЗ КУ");
        test();

        updateLoginAsInfo("go.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется Залипающий заголовок (Правовая база) ГЗ БАЗ");
        test();

        updateLoginAsInfo("go.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Залипающий заголовок (Правовая база) ГЗ ВИП");
        test();
    }

    private void test() {
        String documentUrl = "#/document/99/901799839/actual";
        loginGo()
                .openDocumentByModuleIdAndDocId(documentUrl)
                .checkStickyHeaderIsGray()
                .checkStickyHeaderScrolling()
                .clickOnStickyHeader()
                .checkStickyHeaderIsNotPresent()

                .logout();
    }
}
