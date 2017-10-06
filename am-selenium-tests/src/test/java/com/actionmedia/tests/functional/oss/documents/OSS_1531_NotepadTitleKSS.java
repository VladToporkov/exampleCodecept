package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 23/03/16.
 */
public class OSS_1531_NotepadTitleKSS extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1531", testCaseVersion = "1")
    public void oss_1531_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Заголовок блокнота КСС КУ");
        loginKss()
                .navigateToAnswersPage()
                .openDocumentByModuleIdAndDocId("#/document/99/901807664/XA00M2U2M0/")
                .clickOnRequiredArticleBacklink("XA00M2U2M0/")
                .checkNotepadPopupIsPresent()
                .checkNotepadPopupTitleHasWhiteSpaceCSSValue()
                .clickOnNotepadPopupCloseButton()

                .openDocumentByModuleIdAndDocId("#/document/99/9027690/XA00LTK2M0/")
                .clickOnRequiredArticleBacklink("XA00LTK2M0/")
                .checkNotepadPopupIsPresent()
                .checkNotepadTitleEqualsWithPhraseTitle("XA00LTK2M0/")
                .clickOnNotepadPopupCloseButton()

                .openDocumentByModuleIdAndDocId("#/document/99/9027690/XA00LUO2M6")
                .clickOnRequiredArticleBacklink("XA00LUO2M6")
                .checkNotepadPopupIsPresent()
                .checkNotepadTitleEqualsWithPhraseTitle("XA00LUO2M6")
                .clickOnNotepadPopupCloseButton()

                .openDocumentByModuleIdAndDocId("#/document/99/9027690/XA00MDG2O0/")
                .clickOnRequiredArticleBacklink("XA00MDG2O0/")
                .checkNotepadPopupIsPresent()
                .checkNotepadTitleEqualsWithPhraseTitle("XA00MDG2O0/")
                .clickOnNotepadPopupCloseButton()

                .openDocumentByModuleIdAndDocId("#/document/99/9027690/XA00ME22O3/")
                .clickOnRequiredArticleBacklink("XA00ME22O3/")
                .checkNotepadPopupIsPresent()
                .checkNotepadTitleEqualsWithPhraseTitle("XA00ME22O3/")
                .clickOnNotepadPopupCloseButton()

                .openDocumentByModuleIdAndDocId("#/document/99/9027690/XA00MCA2N0/")
                .clickOnRequiredArticleBacklink("XA00MCA2N0/")
                .checkNotepadPopupIsPresent()
                .checkNotepadTitleContainsWord("XA00MCA2N0/", "Пункт")
                .clickOnNotepadPopupCloseButton()

                .openDocumentByModuleIdAndDocId("#/document/99/9027690/XA00MHS2NO/")
                .clickOnRequiredArticleBacklink("XA00MHS2NO/")
                .checkNotepadPopupIsPresent()
                .checkNotepadTitleContainsWord("XA00MHS2NO/", "Абзац")
                .clickOnNotepadPopupCloseButton()

                .openDocumentByModuleIdAndDocId("#/document/99/901748877/")
                .clickOnBackLinkFromTitle()
                .checkNotepadPopupIsPresent()
                .checkNotepadTitleIsAdditionalInformation()
                .clickOnNotepadPopupCloseButton()

                .logout();
    }
}
