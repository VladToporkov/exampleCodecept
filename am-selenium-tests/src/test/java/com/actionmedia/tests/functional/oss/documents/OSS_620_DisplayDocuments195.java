package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 08/02/16.
 */
public class OSS_620_DisplayDocuments195 extends AbstractDomainTest {

    private final static String DOC_PART_URL = "#/document/195/10019";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-620", testCaseVersion = "1")
    public void oss_620_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Общее отображение документов 195 модуль КСС КУ");
        kssDocument_195();
    }

    private void kssDocument_195() {
        loginKss()
                .openDocumentByModuleIdAndDocId(DOC_PART_URL)
                .checkMenu()
                .checkWordButtonIsPresent()
                .checkMailButtonIsPresent()
                .checkPrintIcon()

                .checkDocumentTitleIsPresent()
                .checkBlockDispute()

                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkRubricatorButtonIsPresent("Все ответы")

                .checkAddToFavoritesButtonsForDocumentArePresent()

                .logout();
    }
}

