package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 11/05/16.
 */
public class OSS_1675_DisplayDocument99_GO extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1675", testCaseVersion = "2")
    public void oss_1675_test() {
        //go
        updateSystemInfo(SystemPubs.go);
        updateLoginAsInfo("go.user.commercial");
        report("Проверяется  Общее отображение документов (99 модуль) ГЗ КУ");
        oss_1675_gz_test("#/document/99/9015517/actual");

        updateLoginAsInfo("go.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется  Общее отображение документов (99 модуль) ГЗ Баз");
        oss_1675_gz_test("#/document/99/901807664/actual");

        //go VIP
        updateLoginAsInfo("go.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется  Общее отображение документов (99 модуль) ГЗ ВИП");
        oss_1675_gz_test("#/document/99/901714433/actual");
    }

    private void oss_1675_gz_test(String documentId) {
        loginGo()
                .openDocumentByModuleIdAndDocId(documentId)
                .checkDocumentIsOpened()
                .checkExtendedSearchButtonIsPresent()
                .checkAddToFavoritesButtonsForDocumentArePresent()
                .checkHelpWidgetIsPresent()
                .checkSearchInTextWidgetIsPresent()
                .checkRevisionHistoryIsPresent()
                .checkMoreOnTheTopicIsPresent()
                .checkWordButtonIsPresent()
                .checkPrintButtonInKodeksIsPresent()
                .checkSendButtonIsPresentForKodeks()
                .checkSoderIsPresent()
                .checkBacklinksArePresent()

                .checkRubricatorButtonIsPresent("Основные акты")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent()

                .logout();
    }
}
