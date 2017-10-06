package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.components.popups.NotepadPopup;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 25/03/16.
 */
public class OSS_1538_CheckLinksNotepadKSS extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1538", testCaseVersion = "1")
    public void oss_1538_test() {
        //BSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Проверка ссылок в блокноте беклинов КСС КУ");
        loginKss()
                .navigateToAnswersPage()
                .openDocumentByModuleIdAndDocId("#/document/99/901807664/XA00M4S2ML/")
                .clickOnRequiredArticleBacklink("XA00M4S2ML/")
                .checkNotepadPopupIsPresent()

                .clickOnNotepadPopupMenu(NotepadPopup.Item.ANSWERS)
                .clickOnNotepadPopupRecomendationBlockRandomLink()
                .checkDocumentIsOpened()
                .returnToBack()
                .checkNotepadPopupScrollTo(NotepadPopup.Item.ANSWERS)

                .clickOnNotepadPopupMenu(NotepadPopup.Item.FORMS)
                .clickOnNotepadPopupFormsBlockRandomLink()
                .checkDocumentIsOpened()
                .returnToBack()
                .checkNotepadPopupScrollTo(NotepadPopup.Item.FORMS)

                .clickOnNotepadPopupMenu(NotepadPopup.Item.HANDBOOK)
                .clickOnNotepadPopupHandbookBlockRandomLink()
                .checkDocumentIsOpened()
                .returnToBack()
                .checkNotepadPopupScrollTo(NotepadPopup.Item.HANDBOOK)

                .clickOnNotepadPopupMenu(NotepadPopup.Item.PRESS)
                .clickOnNotepadPopupPressBlockRandomLink()
                .checkDocumentIsOpened()
                .returnToBack()
                .checkNotepadPopupScrollTo(NotepadPopup.Item.PRESS)

                .clickOnNotepadPopupMenu(NotepadPopup.Item.LAW)
                .clickOnNotepadPopupLawBlockRandomLink()
                .checkDocumentIsOpened()
                .returnToBack()
                .checkNotepadPopupScrollTo(NotepadPopup.Item.LAW)

                .clickOnNotepadPopupMenu(NotepadPopup.Item.LAWPRACTICE)
                .clickOnNotepadPopupLawPracticeBlockRandomLink()
                .checkDocumentIsOpened()
                .returnToBack()
                .checkNotepadPopupScrollTo(NotepadPopup.Item.LAWPRACTICE)

                .logout();

    }
}
