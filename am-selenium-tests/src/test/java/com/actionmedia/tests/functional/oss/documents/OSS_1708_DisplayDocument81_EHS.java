package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 16/05/16.
 */
public class OSS_1708_DisplayDocument81_EHS extends AbstractDomainTest {

    private static final String DOCUMENT_URL = "#/document/81/1023";
    private static final String BUTTON_NAME = "Законы и правила";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1708", testCaseVersion = "2")
    public void oss_1708_test() {
        updateSystemInfo(SystemPubs.ehs);
        updateLoginAsInfo("ehs.user.commercial");
        report("Проверяется  Общее отображение документов (81 модуль) ОТ КУ");
        oss_1708_ehs_test();

        updateLoginAsInfo("ehs.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется  Общее отображение документов (81 модуль) ОТ БАЗ");
        oss_1708_ehs_test();

        updateLoginAsInfo("ehs.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется  Общее отображение документов (81 модуль) ОТ ВИП");
        oss_1708_ehs_test();
    }

    private void oss_1708_ehs_test() {
        loginOT()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL)
                .checkDocumentIsOpened()
                .checkSearchInTextWidgetIsPresent()
                .checkExtendedSearchButtonIsPresent()
                .checkHelpWidgetIsPresent()
                .checkWordButtonIsPresent()
                .checkPrintButtonInKodeksIsPresent()
                .checkSendButtonIsPresentForKodeks()
                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonsForDocumentArePresent()

                .logout();
    }
}
