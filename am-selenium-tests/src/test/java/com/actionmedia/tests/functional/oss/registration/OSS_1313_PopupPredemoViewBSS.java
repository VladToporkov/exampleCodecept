package com.actionmedia.tests.functional.oss.registration;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 29/02/16.
 */
public class OSS_1313_PopupPredemoViewBSS extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1313", testCaseVersion = "1")
    public void oss_1313_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверка Отображение формы Предемо БСС КУ");
        test();
    }

    private void test() {
        enterToBssWithoutLogin()
                .openDocumentByModuleIdAndDocId("/?utm_source=test&utm_medium=test#/document/11/14438/")
                .checkPopupPredemoIsPresent()
                .checkPopupPredemoContentHasText()
                .checkPopupPredemoFullNameIsPresent()
                .checkPopupPredemoEmailIsPresent()
                .checkPopupPredemoCheckBoxSubscribe()
                .checkPopupPredemoButtonGetAccessIsPresent()
                .checkPopupPredemoButtonCloseIsPresent()
                .checkDocumentIsOpened()
                .checkDocumentIsBlurred()

                .checkPopupPredemoWithResolution1000x500();
    }
}
