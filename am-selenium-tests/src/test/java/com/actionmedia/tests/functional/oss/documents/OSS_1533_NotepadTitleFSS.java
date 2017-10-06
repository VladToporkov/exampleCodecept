package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 23/03/16.
 */
public class OSS_1533_NotepadTitleFSS extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1533", testCaseVersion = "1")
    public void oss_1533_test() {
        //USS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Заголовок блокнота ФСС КУ");
        loginFss()
                .navigateToSolutionsPage()
                .openDocumentByModuleIdAndDocId("#/document/99/901714421/XA00LUO2M6/")
                .clickOnRequiredArticleBacklink("XA00LUO2M6/")
                .checkNotepadPopupIsPresent()
                .checkNotepadPopupTitleHasWhiteSpaceCSSValue()
                .clickOnNotepadPopupCloseButton()

                .openDocumentByModuleIdAndDocId("#/document/99/901807667/XA00LTK2M0/")
                .clickOnRequiredArticleBacklink("XA00LTK2M0/")
                .checkNotepadPopupIsPresent()
                .checkNotepadTitleEqualsWithPhraseTitle("XA00LTK2M0/")
                .clickOnNotepadPopupCloseButton()

                .openDocumentByModuleIdAndDocId("#/document/99/901807667/XA00LU62M3/")
                .clickOnRequiredArticleBacklink("XA00LU62M3/")
                .checkNotepadPopupIsPresent()
                .checkNotepadTitleEqualsWithPhraseTitle("XA00LU62M3/")
                .clickOnNotepadPopupCloseButton()

                .openDocumentByModuleIdAndDocId("#/document/99/902019731/XA00LUO2M6/")
                .clickOnRequiredArticleBacklink("XA00LUO2M6/")
                .checkNotepadPopupIsPresent()
                .checkNotepadTitleEqualsWithPhraseTitle("XA00LUO2M6/")
                .clickOnNotepadPopupCloseButton()

                .openDocumentByModuleIdAndDocId("#/document/99/902019731/XA00MD82NS/")
                .clickOnRequiredArticleBacklink("XA00MD82NS/")
                .checkNotepadPopupIsPresent()
                .checkNotepadTitleEqualsWithPhraseTitle("XA00MD82NS/")
                .clickOnNotepadPopupCloseButton()

                .openDocumentByModuleIdAndDocId("#/document/99/901821334/XA00M8G2N0/")
                .clickOnRequiredArticleBacklink("XA00M8G2N0/")
                .checkNotepadPopupIsPresent()
                .checkNotepadTitleContainsWord("XA00M8G2N0/", "Пункт")
                .clickOnNotepadPopupCloseButton()

                .openDocumentByModuleIdAndDocId("#/document/99/901821334/XA00MJC2NQ/")
                .clickOnRequiredArticleBacklink("XA00MJC2NQ/")
                .checkNotepadPopupIsPresent()
                .checkNotepadTitleContainsWord("XA00MJC2NQ/", "Абзац")
                .clickOnNotepadPopupCloseButton()

                .openDocumentByModuleIdAndDocId("#/document/99/901748877/")
                .clickOnBackLinkFromTitle()
                .checkNotepadPopupIsPresent()
                .checkNotepadTitleIsAdditionalInformation()
                .clickOnNotepadPopupCloseButton()

                .logout();
    }
}
