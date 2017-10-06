package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 15/02/16.
 */
public class OSS_626_DisplayDocument177 extends AbstractDomainTest {

    private final static String DOC_PART_URL = "#/document/177/154";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-626", testCaseVersion = "1")
    public void oss_626_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Общее отображение документов 177 модуль ФСС КУ");
        fssDocument_173();
    }

    private void fssDocument_173() {
        loginFss()
                .openDocumentByModuleIdAndDocId(DOC_PART_URL)
                .checkMenu()
                .checkWordButtonIsPresent()
                .checkMailButtonIsPresent()
                .checkPrintIcon()

                .checkTitleAndAuthorInformationWithoutPhotoPresent()
                .checkContentIsPresent()

                .checkInCut()

                .checkSoderIsPresent()

                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkRubricatorButtonIsPresent("Все решения")

                .checkAddToFavoritesButtonsForDocumentArePresent()

                .logout();
    }
}
