package com.actionmedia.tests.functional.oss.registration;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 02/03/16.
 */
public class USS_1316_PopupPredemoFSS extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1316", testCaseVersion = "1")
    public void oss_1316_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверка Отображение формы Предемо ФСС КУ");
        test();
    }

    private void test() {
        enterToFssWithoutLogin()
                .openDocumentByModuleIdAndDocId("/?utm_source=test&utm_medium=test#/document/207/2012/")
                .checkPopupPredemoIsPresent()
                .checkPopupPredemoPhotoBackground()
                .checkPopupPredemoLogo()
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
