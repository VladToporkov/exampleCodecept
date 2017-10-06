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
public class OSS_1539_CheckLinksNotepadUSS extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1539", testCaseVersion = "1")
    public void oss_1539_test() {
        //BSS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Проверка ссылок в блокноте беклинов ЮСС КУ");
        loginUss()
                .navigateToRecomendPage()
                .openDocumentByModuleIdAndDocId("#/document/99/9027690/XA00M8U2MR/")
                .clickOnRequiredArticleBacklink("XA00M8U2MR/")
                .checkNotepadPopupIsPresent()

                .clickOnNotepadPopupMenu(NotepadPopup.Item.RECOMMENDATIONS)
                .clickOnNotepadPopupRecomendationBlockRandomLink()
                .checkDocumentIsOpened()
                .returnToBack()
                .checkNotepadPopupScrollTo(NotepadPopup.Item.RECOMMENDATIONS)

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