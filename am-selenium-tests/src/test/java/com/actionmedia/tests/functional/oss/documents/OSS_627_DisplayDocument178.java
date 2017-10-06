package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 16/02/16.
 */
public class OSS_627_DisplayDocument178 extends AbstractDomainTest {

    private final static String DOC_PART_URL = "#/document/178/41";
    private final static String DOC_PART_URL_INLINE = "#/document/178/2547";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-627", testCaseVersion = "1")
    public void oss_627_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Общее отображение документов 178 модуль ФСС КУ");
        fssDocument_178();
    }

    private void fssDocument_178() {
        loginFss()
                .openDocumentByModuleIdAndDocId(DOC_PART_URL)
                .checkMenu()
                .checkWordButtonIsPresent()
                .checkMailButtonIsPresent()
                .checkPrintIcon()

                .checkTitleAndAuthorInformationPresent()
                .checkContentIsPresent()

                .checkParentDocumentLinkInBottom()

                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkRubricatorButtonIsPresent("Все решения")

                .checkAddToFavoritesButtonsForDocumentArePresent()

                .openDocumentByModuleIdAndDocId(DOC_PART_URL_INLINE)
                .checkInlineDownloadsFromDocument178_2547()

                .logout();
    }
}
