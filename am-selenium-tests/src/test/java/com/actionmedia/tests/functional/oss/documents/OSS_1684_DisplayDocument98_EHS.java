package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 11/05/16.
 */
public class OSS_1684_DisplayDocument98_EHS extends AbstractDomainTest {

    private static final String DOCUMENT_URL = "#/document/98/1232756";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1684", testCaseVersion = "3")
    public void oss_1684_test() {
        //ehs
        updateSystemInfo(SystemPubs.ehs);
        updateLoginAsInfo("ehs.user.commercial");
        report("Проверяется  Общее отображение документов (98 модуль) ОТ КУ");
        oss_1684_ehs_test();

        updateLoginAsInfo("ehs.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется  Общее отображение документов (98 модуль) ОТ БАЗ");
        oss_1684_ehs_test();

        updateLoginAsInfo("ehs.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется  Общее отображение документов (98 модуль) ОТ ВИП");
        oss_1684_ehs_test();
    }

    private void oss_1684_ehs_test() {
        loginOT()
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
