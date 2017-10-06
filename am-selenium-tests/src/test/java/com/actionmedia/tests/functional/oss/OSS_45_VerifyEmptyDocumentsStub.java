package com.actionmedia.tests.functional.oss;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.bss.BssBasePage;
import com.actionmedia.pages.kss.KssBasePage;
import com.actionmedia.pages.uss.UssBasePage;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 28.09.14
 * Time: 15:48
 */
public class OSS_45_VerifyEmptyDocumentsStub extends AbstractDomainTest {

    private static final String[] bssDocUrlList = new String[]{
            "#/document/11/000",
            "#/document/12/000",
            "#/document/111/000",
            "#/document/112/000",
            "#/document/170/000",
            "#/document/113/000",
            "#/document/197/000",
            "#/document/186/000",
            "#/document/199/000",
            "#/document/81/000",
            "#/document/97/000",
            "#/document/98/000",
            "#/document/99/000",
            "#/document/140/000",
            "#/document/118/000",
            "#/document/117/000",
            "#/document/169/000",
            "#/document/201/000",
            "#/document/199/000",
            "#/document/123/000",
            "#/document/160/000",
            "#/document/234/000",
            "#/document/119/000",
            "#/document/233/000",
            "#/document/189/000",
            "#/document/192/000",
            "#/document/133/000",
            "#/document/134/000",
            "#/document/138/000",
            "#/document/125/000",
            "#/document/126/000",
            "#/document/145/000",
            "#/document/150/000",
            "#/document/193/000",
            "#/document/184/000"
    };

    private static final String[] kssDocUrlList = new String[]{
            "#/document/161/000",
            "#/document/184/000",
            "#/document/113/000",
            "#/document/195/000",
            "#/document/140/000",
            "#/document/118/000",
            "#/document/121/000",
            "#/document/117/000",
            "#/document/122/000",
            "#/document/160/000",
            "#/document/234/000",
            "#/document/125/000",
            "#/document/119/000",
            "#/document/192/000",
            "#/document/233/000",
            "#/document/145/000",
            "#/document/150/000",
            "#/document/123/000"
    };

    private static final String[] ussDocUrlList = new String[]{
            "#/document/165/000",
            "#/document/131/000",
            "#/document/166/000",
            "#/document/167/000",
            "#/document/181/000",
            "#/document/81/000",
            "#/document/97/000",
            "#/document/99/000",
            "#/document/98/000",
            "#/document/118/000",
            "#/document/140/000",
            "#/document/113/000",
            "#/document/117/000",
            "#/document/169/000",
            "#/document/160/000",
            "#/document/234/000",
            "#/document/119/000",
            "#/document/233/000",
            "#/document/133/000",
            "#/document/134/000",
            "#/document/125/000",
            "#/document/126/000",
            "#/document/145/000",
            "#/document/163/000",
            "#/document/150/000",
            "#/document/184/000",
            "#/document/123/000"
    };

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-45", testCaseVersion = "1")
    public void oss_45_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        BssBasePage bssBasePage = loginBss();
        for (String url : bssDocUrlList) {
            bssBasePage
                    .openDocumentWithoutWaitByModuleIdAndDocId(url)
                    .checkEmptyDocumentStub();
        }
        bssBasePage.logout();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        loginBss()
                .openDocumentWithoutWaitByModuleIdAndDocId("#/document/193/000")
                .checkEmptyDocumentStub()
                .logout();

        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        KssBasePage kssBasePage = loginKss();
        for (String url : kssDocUrlList) {
            kssBasePage
                    .openDocumentWithoutWaitByModuleIdAndDocId(url)
                    .checkEmptyDocumentStub();
        }
        kssBasePage.logout();

        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        UssBasePage ussBasePage = loginUss();
        for (String url : ussDocUrlList) {
            ussBasePage
                    .openDocumentWithoutWaitByModuleIdAndDocId(url)
                    .checkEmptyDocumentStub();
        }
        ussBasePage.logout();
    }
}
