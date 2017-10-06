package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel on 04/02/16.
 */
public class OSS_617_DisplayDocuments130 extends AbstractDomainTest {

    private final static String DOC_PART_URL = "#/document/130/51380";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-617", testCaseVersion = "1")
    public void oss_617_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Общее отображение документов 130 модуль КСС КУ");
        kssDocument_130();
    }

    private void kssDocument_130() {
        loginKss()
                .openDocumentByModuleIdAndDocId(DOC_PART_URL)
                .checkMenu()
                .checkWordButtonIsPresent()
                .checkMailButtonIsPresent()
                .checkPrintIcon()

                .checkTitleAndAuthorInformationPresent()
                .checkContentIsPresent()
                .checkInCut()

                .checkDocumentRatingIsPresent()

                .checkSoderIsPresent()

                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkRubricatorButtonIsPresent("Все ответы")

                .checkAddToFavoritesButtonsForDocumentArePresent()

                .logout();
    }
}
