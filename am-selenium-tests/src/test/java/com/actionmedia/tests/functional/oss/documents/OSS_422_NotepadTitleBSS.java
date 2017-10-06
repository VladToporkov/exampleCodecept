package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 21/03/16.
 */
public class OSS_422_NotepadTitleBSS extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-422", testCaseVersion = "2")
    public void oss_422_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Заголовок блокнота БСС КУ");
        loginBss()
                .navigateToRecomendPage()
                .openDocumentByModuleIdAndDocId("#/document/99/901821334/XA00MKK2OE/")
                .clickOnRequiredArticleBacklink("XA00MKK2OE/")
                .checkNotepadPopupIsPresent()
                .checkNotepadPopupTitleHasWhiteSpaceCSSValue()
                .clickOnNotepadPopupCloseButton()

                .openDocumentByModuleIdAndDocId("#/document/99/901821334/XA00LTK2M0/")
                .clickOnRequiredArticleBacklink("XA00LTK2M0/")
                .checkNotepadPopupIsPresent()
                .checkNotepadTitleEqualsWithPhraseTitle("XA00LTK2M0/")
                .clickOnNotepadPopupCloseButton()

                .openDocumentByModuleIdAndDocId("#/document/99/901821334/XA00LU62M3/")
                .clickOnRequiredArticleBacklink("XA00LU62M3/")
                .checkNotepadPopupIsPresent()
                .checkNotepadTitleEqualsWithPhraseTitle("XA00LU62M3/")
                .clickOnNotepadPopupCloseButton()

                .openDocumentByModuleIdAndDocId("#/document/99/901821334/XA00LUO2M6/")
                .clickOnRequiredArticleBacklink("XA00LUO2M6/")
                .checkNotepadPopupIsPresent()
                .checkNotepadTitleEqualsWithPhraseTitle("XA00LUO2M6/")
                .clickOnNotepadPopupCloseButton()

                .openDocumentByModuleIdAndDocId("#/document/99/901821334/XA00MGC2O8/")
                .clickOnRequiredArticleBacklink("XA00MGC2O8/")
                .checkNotepadPopupIsPresent()
                .checkNotepadTitleEqualsWithPhraseTitle("XA00MGC2O8/")
                .clickOnNotepadPopupCloseButton()

                .openDocumentByModuleIdAndDocId("#/document/99/901821334/XA00M902MS/")
                .clickOnRequiredArticleBacklink("XA00M902MS/")
                .checkNotepadPopupIsPresent()
                .checkNotepadTitleContainsWord("XA00M902MS/", "Пункт")
                .clickOnNotepadPopupCloseButton()

                .openDocumentByModuleIdAndDocId("#/document/99/901821334/XA00MK02OL/")
                .clickOnRequiredArticleBacklink("XA00MK02OL/")
                .checkNotepadPopupIsPresent()
                .checkNotepadTitleContainsWord("XA00MK02OL/", "Абзац")
                .clickOnNotepadPopupCloseButton()

                .openDocumentByModuleIdAndDocId("#/document/99/901748877/")
                .clickOnBackLinkFromTitle()
                .checkNotepadPopupIsPresent()
                .checkNotepadTitleIsAdditionalInformation()
                .clickOnNotepadPopupCloseButton()

                .logout();
    }
}
