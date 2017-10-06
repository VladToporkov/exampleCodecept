package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 05/02/16.
 */
public class OSS_618_DisplayDocuments131 extends AbstractDomainTest {

    private final static String DOC_PART_URL = "#/document/131/77158";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-618", testCaseVersion = "1")
    public void oss_618_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Общее отображение документов 131 модуль КСС КУ");
        kssDocument_131();
    }

    private void kssDocument_131() {
        loginKss()
                .openDocumentByModuleIdAndDocId(DOC_PART_URL)
                .checkMenu()
                .checkWordButtonIsPresent()
                .checkMailButtonIsPresent()
                .checkPrintIcon()

                .checkTitleAndAuthorInformationPresent()
                .checkContentIsPresent()

                .checkParentDocumentLinkIsPresent()
                .checkDocumentRatingIsPresent()

                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkRubricatorButtonIsPresent("Все ответы")

                .checkAddToFavoritesButtonsForDocumentArePresent()

                .logout();
    }
}
