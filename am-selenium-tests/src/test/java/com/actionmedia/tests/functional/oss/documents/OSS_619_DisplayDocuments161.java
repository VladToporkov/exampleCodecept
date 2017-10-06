package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 07/02/16.
 */
public class OSS_619_DisplayDocuments161 extends AbstractDomainTest {

    private final static String DOC_PART_URL = "#/document/161/73091";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-619", testCaseVersion = "1")
    public void oss_619_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Общее отображение документов 161 модуль КСС КУ");
        kssDocument_161();
    }

    private void kssDocument_161() {
        loginKss()
                .openDocumentByModuleIdAndDocId(DOC_PART_URL)
                .checkMenu()
                .checkWordButtonIsPresent()
                .checkMailButtonIsPresent()
                .checkPrintIcon()

                .checkDocumentTitleIsPresent()
                .checkContentIsPresent()

                .checkParentDocumentLinkIsPresent()
                .checkDocumentRatingIsPresent()

                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkRubricatorButtonIsPresent("Все ответы")

                .checkAddToFavoritesButtonsForDocumentArePresent()

                .logout();
    }
}
