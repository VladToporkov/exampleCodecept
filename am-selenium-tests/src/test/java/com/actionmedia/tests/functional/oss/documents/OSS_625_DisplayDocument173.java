package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel on 14/02/16.
 */
public class OSS_625_DisplayDocument173 extends AbstractDomainTest {

    private final static String DOC_PART_URL = "#/document/173/1483";
    private final static String DOC_PART_URL_SAVING_BLOCK_1 = "#/document/173/1964";
    private final static String DOC_PART_URL_SAVING_BLOCK_2 = "#/document/173/1945";
    private final static String DOC_PART_URL_SAVING_BLOCK_3 = "#/document/173/1942";
    private final static String DOC_PART_URL_SAVING_BLOCK_4 = "#/document/173/1916";
    private final static String DOC_PART_URL_SAVING_BLOCK_5 = "#/document/173/1902";
    private final static String DOC_PART_URL_SAVING_BLOCK_6 = "#/document/173/1899";
    private final static String DOC_PART_URL_TWO_AUTHORS = "#/document/173/54";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-625", testCaseVersion = "1")
    public void oss_625_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Общее отображение документов 173 модуль ФСС КУ");
        fssDocument_173();
    }

    private void fssDocument_173() {
        loginFss()
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
                .checkRubricatorButtonIsPresent("Все решения")

                .checkAddToFavoritesButtonsForDocumentArePresent()

                .openDocumentByModuleIdAndDocId(DOC_PART_URL_SAVING_BLOCK_1)
                .checkSavingMoneyBlock()

                .openDocumentByModuleIdAndDocId(DOC_PART_URL_SAVING_BLOCK_2)
                .checkSavingMoneyBlock()

                .openDocumentByModuleIdAndDocId(DOC_PART_URL_SAVING_BLOCK_3)
                .checkSavingMoneyBlock()

                .openDocumentByModuleIdAndDocId(DOC_PART_URL_SAVING_BLOCK_4)
                .checkSavingMoneyBlock()

                .openDocumentByModuleIdAndDocId(DOC_PART_URL_SAVING_BLOCK_5)
                .checkSavingMoneyBlock()

                .openDocumentByModuleIdAndDocId(DOC_PART_URL_SAVING_BLOCK_6)
                .checkSavingMoneyBlock()

                .openDocumentByModuleIdAndDocId(DOC_PART_URL_TWO_AUTHORS)
                .checkAuthorsInformationIsPresent()

                .logout();
    }
}
