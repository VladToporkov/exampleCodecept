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
public class OSS_1535_BacklinksListNotepadUSS extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1535", testCaseVersion = "1")
    public void oss_1535_test() {
        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Список беклинков в блокноте ЮСС КУ");
        loginUss()
                .navigateToRecomendPage()
                .openDocumentByModuleIdAndDocId("#/document/99/9027690/XA00M8U2MR/")
                .clickOnRequiredArticleBacklink("XA00M8U2MR/")
                .checkNotepadPopupIsPresent()
                .clickOnNotepadPopupMenu(NotepadPopup.Item.RECOMMENDATIONS)
                .checkNotepadPopupScrollTo(NotepadPopup.Item.RECOMMENDATIONS)
                .checkNotepadPopupRecomendationBlockFirstItemHasPhotoFullNameAndPosition()
                .checkNotepadPopupRecomendationBlockHasLinks()
                .checkNotepadPopupRecomentdationBlockHasNoMoreThan10Links()

                .clickOnNotepadPopupMenu(NotepadPopup.Item.FORMS)
                .checkNotepadPopupScrollTo(NotepadPopup.Item.FORMS)
                .checkNotepadPopupFormsBlockHasLinks()
                .checkNotepadPopupFormsBlockHasNoMoreThan10Links()

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
                .checkNotepadPopupFirstLinkFromLawPracticeBecomeRedAfterHoverOn()

                .clickOnNotepadPopupCloseButton()
                .logout();
    }
}