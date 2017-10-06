package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.components.popups.NotepadPopup;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inTesting;

/**
 * Created by Pavel on 18/03/16.
 */
public class OSS_1529_BacklinksAndNotepadUSS extends AbstractDomainTest {

    @Test(groups = {inTesting})
    @TestLink(testCaseId = "OSS-1529", testCaseVersion = "1")
    public void oss_1529_test() {
        //KSS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Отображение числа беклинков и блокнота ЮСС КУ");
        loginUss()
                .navigateToRecomendPage()
                .openDocumentByModuleIdAndDocId("#/document/99/9027690/")
                .checkBacklinksArePresent()
                .checkBacklinkHasCssStyles()

                .clickOnBacklinkWithReferencesCount(2)
                .checkParagraphAndButtonAreYellow()
                .checkNotepadPopupIsPresent()
                .checkNotepadPopupHasShadow()
                .checkNotepadPopupHeaderIsWhite()
                .checkNotepadPopupTitleIsPresent()
                .checkNotepadPopupCloseIconIsPresent()
                .checkNotepadPopupBodyIsYellow()
                .checkNotepadPopupBodyHasBacklinks()

                .clickOnNotepadPopupCloseButton()
                .checkNotepadPopupIsNotPresent()
                .checkParagraphAndButtonAreNotYellow()

                .refreshPage()

                .openDocumentByModuleIdAndDocId("#/document/99/9027690/")
                .clickOnRequiredArticleBacklink("XA00M2O2MP")
                .checkNotepadPopupIsPresent()
                .checkNotepadPopupHasShadow()
                .checkNotepadPopupHeaderIsWhite()
                .checkNotepadPopupTitleIsPresent()
                .checkNotepadPopupCloseIconIsPresent()
                .checkNotepadPopupBodyIsYellow()
                .checkNotepadPopupBodyHasBacklinks()
                .checkNotepadPopupMenuBlockIsPresent()
                .checkNotepadPopupMenuItemsInOrder(NotepadPopup.Item.RECOMMENDATIONS, NotepadPopup.Item.FORMS,
                        NotepadPopup.Item.PRESS, NotepadPopup.Item.LAW,
                        NotepadPopup.Item.LAWPRACTICE)
                .checkNotepadPopupMenuItemIcon(NotepadPopup.Item.RECOMMENDATIONS, NotepadPopup.Item.FORMS,
                        NotepadPopup.Item.PRESS, NotepadPopup.Item.LAW,
                        NotepadPopup.Item.LAWPRACTICE)

                .hoverOnNotepadPopupMenuItem(NotepadPopup.Item.FORMS)
                .checkNotepadPopupMenuItemIsRed(NotepadPopup.Item.FORMS)
                .clickOnNotepadPopupMenu(NotepadPopup.Item.FORMS)
                .checkNotepadPopupMenuItemIsNotRed(NotepadPopup.Item.FORMS)
                .checkNotepadPopupMenuItemHasRightName(NotepadPopup.Item.FORMS)
                .checkNotepadPopupMenuItemIsYellow(NotepadPopup.Item.FORMS)
                .checkNotepadPopupScrollTo(NotepadPopup.Item.FORMS)

                .hoverOnNotepadPopupMenuItem(NotepadPopup.Item.PRESS)
                .checkNotepadPopupMenuItemIsRed(NotepadPopup.Item.PRESS)
                .clickOnNotepadPopupMenu(NotepadPopup.Item.PRESS)
                .checkNotepadPopupMenuItemIsNotRed(NotepadPopup.Item.PRESS)
                .checkNotepadPopupMenuItemHasRightName(NotepadPopup.Item.PRESS)
                .checkNotepadPopupMenuItemIsYellow(NotepadPopup.Item.PRESS)
                .checkNotepadPopupScrollTo(NotepadPopup.Item.PRESS)

                .hoverOnNotepadPopupMenuItem(NotepadPopup.Item.LAW)
                .checkNotepadPopupMenuItemIsRed(NotepadPopup.Item.LAW)
                .clickOnNotepadPopupMenu(NotepadPopup.Item.LAW)
                .checkNotepadPopupMenuItemIsNotRed(NotepadPopup.Item.LAW)
                .checkNotepadPopupMenuItemHasRightName(NotepadPopup.Item.LAW)
                .checkNotepadPopupMenuItemIsYellow(NotepadPopup.Item.LAW)
                .checkNotepadPopupScrollTo(NotepadPopup.Item.LAW)

                .hoverOnNotepadPopupMenuItem(NotepadPopup.Item.LAWPRACTICE)
                .checkNotepadPopupMenuItemIsRed(NotepadPopup.Item.LAWPRACTICE)
                .clickOnNotepadPopupMenu(NotepadPopup.Item.LAWPRACTICE)
                .checkNotepadPopupMenuItemIsNotRed(NotepadPopup.Item.LAWPRACTICE)
                .checkNotepadPopupMenuItemHasRightName(NotepadPopup.Item.LAWPRACTICE)
                .checkNotepadPopupMenuItemIsYellow(NotepadPopup.Item.LAWPRACTICE)
                .checkNotepadPopupScrollTo(NotepadPopup.Item.LAWPRACTICE)

                .hoverOnNotepadPopupMenuItem(NotepadPopup.Item.RECOMMENDATIONS)
                .checkNotepadPopupMenuItemIsRed(NotepadPopup.Item.RECOMMENDATIONS)
                .clickOnNotepadPopupMenu(NotepadPopup.Item.RECOMMENDATIONS)
                .checkNotepadPopupMenuItemIsNotRed(NotepadPopup.Item.RECOMMENDATIONS)
                .checkNotepadPopupMenuItemHasRightName(NotepadPopup.Item.RECOMMENDATIONS)
                .checkNotepadPopupMenuItemIsYellow(NotepadPopup.Item.RECOMMENDATIONS)
                .checkNotepadPopupScrollTo(NotepadPopup.Item.RECOMMENDATIONS)

                .checkNotepadPopupMenuItemIsSelectedAfterScrolling(NotepadPopup.Item.RECOMMENDATIONS)

                .logout();
    }
}
