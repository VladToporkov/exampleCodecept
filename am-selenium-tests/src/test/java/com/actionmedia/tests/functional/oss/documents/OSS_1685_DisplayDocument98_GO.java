package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 11/05/16.
 */
public class OSS_1685_DisplayDocument98_GO extends AbstractDomainTest {

    private static final String DOCUMENT_URL = "#/document/98/1445505";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1685", testCaseVersion = "3")
    public void oss_1685_test() {
        //go
        updateSystemInfo(SystemPubs.go);
        updateLoginAsInfo("go.user.commercial");
        report("Проверяется  Общее отображение документов (98 модуль) ГЗ КУ");
        oss_1685_go_test();

        updateLoginAsInfo("go.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется  Общее отображение документов (98 модуль) ГЗ БАЗ");
        oss_1685_go_test();

        updateLoginAsInfo("go.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется  Общее отображение документов (98 модуль) ГЗ ВИП");
        oss_1685_go_test();
    }

    private void oss_1685_go_test() {
        loginGo()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL)
                .checkDocumentIsOpened()
                .checkSearchInTextWidgetIsPresent()
                .checkExtendedSearchButtonIsPresent()
                .checkHelpWidgetIsPresent()
                .checkAddToFavoritesButtonsForDocumentArePresent()
                .checkWordButtonIsPresent()
                .checkPrintButtonInKodeksIsPresent()
                .checkSendButtonIsPresentForKodeks()
                .checkMyFavoritesRubricatorButtonIsPresent()

                .logout();
    }
}

