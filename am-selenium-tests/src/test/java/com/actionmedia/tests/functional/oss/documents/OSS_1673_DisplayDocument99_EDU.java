package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 10/05/16.
 */
public class OSS_1673_DisplayDocument99_EDU extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1673", testCaseVersion = "2")
    public void oss_1673_test() {
        //edu
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.commercial");
        report("Проверяется  Общее отображение документов (99 модуль) ОБР КУ");
        oss_1673_edu_test("#/document/99/9015517/actual");

        updateLoginAsInfo("edu.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется  Общее отображение документов (99 модуль) ОБР Баз");
        oss_1673_edu_test("#/document/99/901807664/actual");

        //edu VIP
        updateLoginAsInfo("edu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется  Общее отображение документов (99 модуль) ОБР ВИП");
        oss_1673_edu_test("#/document/99/901714433/actual");
    }

    private void oss_1673_edu_test(String documentId) {
        loginEdu()
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

                .checkRubricatorButtonIsPresent("Правовая база")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent()

                .logout();
    }
}
