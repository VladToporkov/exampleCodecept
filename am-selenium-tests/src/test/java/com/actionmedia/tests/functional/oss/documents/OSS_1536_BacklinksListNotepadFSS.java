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
public class OSS_1536_BacklinksListNotepadFSS extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1536", testCaseVersion = "1")
    public void oss_1536_test() {
        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Список беклинков в блокноте ФСС КУ");
        loginFss()
                .navigateToSolutionsPage()
                .openDocumentByModuleIdAndDocId("#/document/99/902290120/XA00MFG2O8/")
                .clickOnRequiredArticleBacklink("XA00MFG2O8/")
                .checkNotepadPopupIsPresent()
                .clickOnNotepadPopupMenu(NotepadPopup.Item.SOLUTIONS)
                .checkNotepadPopupScrollTo(NotepadPopup.Item.SOLUTIONS)
                .checkNotepadPopupSolutionsBlockFirstItemHasPhotoFullNameAndPosition()
                .checkNotepadPopupRecomendationBlockHasLinks()
                .checkNotepadPopupRecomentdationBlockHasNoMoreThan10Links()

                .clickOnNotepadPopupMenu(NotepadPopup.Item.HANDBOOK)
                .checkNotepadPopupScrollTo(NotepadPopup.Item.HANDBOOK)
                .checkNotepadPopupHandbookBlockHasLinks()
                .checkNotepadPopupHandbookBlockHasNoMoreThan10Links()

                .clickOnNotepadPopupMenu(NotepadPopup.Item.PRESS)
                .checkNotepadPopupScrollTo(NotepadPopup.Item.PRESS)
                .checkNotepadPopupPressBlockHasItems()
                .checkNotepadPopupPressBlockHasNoMoreThan10Links()

                .clickOnNotepadPopupMenu(NotepadPopup.Item.LAW)
                .checkNotepadPopupScrollTo(NotepadPopup.Item.LAW)
                .checkNotepadPopupLawBlockHasLinks()
                .checkNotepadPopupLawBlockHasNoMoreThan10Links()

                .clickOnNotepadPopupMenu(NotepadPopup.Item.LAWPRACTICE)
                .checkNotepadPopupScrollTo(NotepadPopup.Item.LAWPRACTICE)
                .checkNotepadPopupLawPracticeBlockHasLinks()
                .checkNotepadPopupLawPracticeBlockHasNoMoreThan10Links()

                .hoverOnNotepadPopupFirstLinkFromLawPractice()
                .checkNotepadPopupFirstLinkFromLawPracticeBecomeOrangeAfterHoverOn()

                .clickOnNotepadPopupCloseButton()
                .logout();
    }
}
