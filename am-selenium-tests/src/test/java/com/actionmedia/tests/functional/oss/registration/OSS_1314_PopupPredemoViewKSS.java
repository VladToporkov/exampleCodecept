package com.actionmedia.tests.functional.oss.registration;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 01/03/16.
 */
public class OSS_1314_PopupPredemoViewKSS extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1314", testCaseVersion = "1")
    public void oss_1314_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверка Отображение формы Предемо КСС КУ");
        test();
    }

    private void test() {
        enterToKssWithoutLogin()
                .openDocumentByModuleIdAndDocId("/#/documentvideo/145/787/?utm_source=test&utm_medium=test")
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
