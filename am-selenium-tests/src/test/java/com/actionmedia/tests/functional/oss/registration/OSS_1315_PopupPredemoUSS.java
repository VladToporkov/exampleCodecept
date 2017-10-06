package com.actionmedia.tests.functional.oss.registration;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 02/03/16.
 */
public class OSS_1315_PopupPredemoUSS extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1315", testCaseVersion = "1")
    public void oss_1315_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверка Отображение формы Предемо ЮСС КУ");
        test();
    }

    private void test() {
        enterToUssWithoutLogin()
                .openDocumentByModuleIdAndDocId("/?utm_source=test&utm_medium=test#/documentvideo/145/3383/")
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
