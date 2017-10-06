package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel on 08/02/16.
 */
public class OSS_621_DisplayDocuments165 extends AbstractDomainTest {

    private final static String DOC_PART_URL = "#/document/165/1519";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-621", testCaseVersion = "1")
    public void oss_621_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Общее отображение документов 165 модуль ЮСС КУ");
        ussDocument_165();
    }

    private void ussDocument_165() {
        loginUss()
                .openDocumentByModuleIdAndDocId(DOC_PART_URL)
                .checkMenu()
                .checkWordButtonIsPresent()
                .checkMailButtonIsPresent()
                .checkPrintIcon()

                .checkTitleAndAuthorInformationPresent()
                .checkContentIsPresent()

                .checkDocumentRatingIsPresent()

                .checkSoderIsPresent()

                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkCommentsRubricatorButtonIsPresent()
                .checkRubricatorButtonIsPresent("Все рекомендации")

                .checkDocumentRatingIsPresent()

                .checkAddToFavoritesButtonsForDocumentArePresent()

                .logout();
    }
}
