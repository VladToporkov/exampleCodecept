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
public class OSS_1540_CheckLinksNotepadFSS extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1540", testCaseVersion = "1")
    public void oss_1540_test() {
        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Проверка ссылок в блокноте беклинов ФСС КУ");
        loginFss()
                .navigateToSolutionsPage()
                .openDocumentByModuleIdAndDocId("#/document/99/901810503/")
                .clickOnTitleBacklink("/document/99/901810503/")
                .checkNotepadPopupIsPresent()

                .clickOnNotepadPopupMenu(NotepadPopup.Item.SOLUTIONS)
                .clickOnNotepadPopupSolutionsBlockRandomLink()
                .checkDocumentIsOpened()
                .returnToBack()
                .checkNotepadPopupScrollTo(NotepadPopup.Item.SOLUTIONS)

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

                .clickOnNotepadPopupMenu(NotepadPopup.Item.FORMS)
                .clickOnNotepadPopupFormsBlockRandomLink()
                .checkDocumentIsOpened()
                .returnToBack()
                .checkNotepadPopupScrollTo(NotepadPopup.Item.FORMS_FSS)

                .logout();
    }
}
