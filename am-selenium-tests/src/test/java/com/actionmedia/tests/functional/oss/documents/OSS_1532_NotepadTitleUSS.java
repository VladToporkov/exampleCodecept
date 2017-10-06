package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 23/03/16.
 */
public class OSS_1532_NotepadTitleUSS extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1532", testCaseVersion = "1")
    public void oss_1532_test() {
        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Заголовок блокнота ЮСС КУ");
        loginUss()
                .navigateToRecomendPage()
                .openDocumentByModuleIdAndDocId("#/document/99/901714421/XA00M8G2N9/")
                .clickOnRequiredArticleBacklink("XA00M8G2N9/")
                .checkNotepadPopupIsPresent()
                .checkNotepadPopupTitleHasWhiteSpaceCSSValue()
                .clickOnNotepadPopupCloseButton()

                .openDocumentByModuleIdAndDocId("#/document/99/901714421/XA00LTK2M0/")
                .clickOnRequiredArticleBacklink("XA00LTK2M0/")
                .checkNotepadPopupIsPresent()
                .checkNotepadTitleEqualsWithPhraseTitle("XA00LTK2M0/")
                .clickOnNotepadPopupCloseButton()

                .openDocumentByModuleIdAndDocId("#/document/99/901714421/XA00LU62M3/")
                .clickOnRequiredArticleBacklink("XA00LU62M3/")
                .checkNotepadPopupIsPresent()
                .checkNotepadTitleEqualsWithPhraseTitle("XA00LU62M3/")
                .clickOnNotepadPopupCloseButton()

                .openDocumentByModuleIdAndDocId("#/document/99/901821334/XA00MGC2O8/")
                .clickOnRequiredArticleBacklink("XA00MGC2O8/")
                .checkNotepadPopupIsPresent()
                .checkNotepadTitleEqualsWithPhraseTitle("XA00MGC2O8/")
                .clickOnNotepadPopupCloseButton()

                .openDocumentByModuleIdAndDocId("#/document/99/901821334/XA00M7G2N5/")
                .clickOnRequiredArticleBacklink("XA00M7G2N5/")
                .checkNotepadPopupIsPresent()
                .checkNotepadTitleEqualsWithPhraseTitle("XA00M7G2N5/")
                .clickOnNotepadPopupCloseButton()

                .openDocumentByModuleIdAndDocId("#/document/99/901821334/XA00M822N8/")
                .clickOnRequiredArticleBacklink("XA00M822N8/")
                .checkNotepadPopupIsPresent()
                .checkNotepadTitleContainsWord("XA00M822N8/", "Пункт")
                .clickOnNotepadPopupCloseButton()

                .openDocumentByModuleIdAndDocId("#/document/99/901821334/XA00M842MU/")
                .clickOnRequiredArticleBacklink("XA00M842MU/")
                .checkNotepadPopupIsPresent()
                .checkNotepadTitleContainsWord("XA00M842MU/", "Абзац")
                .clickOnNotepadPopupCloseButton()

                .openDocumentByModuleIdAndDocId("#/document/99/901748877/")
                .clickOnBackLinkFromTitle()
                .checkNotepadPopupIsPresent()
                .checkNotepadTitleIsAdditionalInformation()
                .clickOnNotepadPopupCloseButton()

                .logout();
    }
}
