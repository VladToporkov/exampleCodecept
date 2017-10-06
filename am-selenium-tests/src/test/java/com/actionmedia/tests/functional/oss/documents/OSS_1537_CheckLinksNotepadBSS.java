package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.components.popups.NotepadPopup;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 24/03/16.
 */
public class OSS_1537_CheckLinksNotepadBSS extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1537", testCaseVersion = "1")
    public void oss_1537_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Проверка ссылок в блокноте беклинов БСС КУ");
        loginBss()
                .navigateToRecomendPage()
                .openDocumentByModuleIdAndDocId("#/document/99/901807664/XA00M5O2MC/")
                .clickOnRequiredArticleBacklink("XA00M5O2MC/")
                .checkNotepadPopupIsPresent()

                .clickOnNotepadPopupMenu(NotepadPopup.Item.RECOMMENDATIONS)
                .clickOnNotepadPopupRecomendationBlockRandomLink()
                .checkDocumentIsOpened()
                .returnToBack()
                .checkNotepadPopupScrollTo(NotepadPopup.Item.RECOMMENDATIONS)

//                .clickOnNotepadPopupMenu(NotepadPopup.Item.FORMS)
//                .clickOnNotepadPopupFormsBlockRandomLink()
//                .checkDocumentIsOpened()
//                .returnToBack()
//                .checkNotepadPopupScrollTo(NotepadPopup.Item.FORMS)

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
