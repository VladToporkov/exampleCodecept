package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.components.popups.NotepadPopup;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 18/03/16.
 */
public class OSS_1525_BacklinksAndNotepadKSS extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1525", testCaseVersion = "1")
    public void oss_1525_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Отображение числа беклинков и блокнота КСС КУ");
        loginKss()
                .navigateToAnswersPage()
                .openDocumentByModuleIdAndDocId("#/document/99/901807664/")
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

                .openDocumentByModuleIdAndDocId("#/document/99/901807664/XA00M6A2MF/")
                .clickOnRequiredArticleBacklink("XA00M6A2MF")
                .checkNotepadPopupIsPresent()
                .checkNotepadPopupHasShadow()
                .checkNotepadPopupHeaderIsWhite()
                .checkNotepadPopupTitleIsPresent()
                .checkNotepadPopupCloseIconIsPresent()
                .checkNotepadPopupBodyIsYellow()
                .checkNotepadPopupBodyHasBacklinks()
                .checkNotepadPopupMenuBlockIsPresent()
                .checkNotepadPopupMenuItemsInOrder(NotepadPopup.Item.ANSWERS, NotepadPopup.Item.HANDBOOK,
                        NotepadPopup.Item.PRESS, NotepadPopup.Item.LAW,
                        NotepadPopup.Item.LAWPRACTICE)
                .checkNotepadPopupMenuItemIcon(NotepadPopup.Item.ANSWERS, NotepadPopup.Item.HANDBOOK,
                        NotepadPopup.Item.PRESS, NotepadPopup.Item.LAW,
                        NotepadPopup.Item.LAWPRACTICE)

                .hoverOnNotepadPopupMenuItem(NotepadPopup.Item.HANDBOOK)
                .checkNotepadPopupMenuItemIsRed(NotepadPopup.Item.HANDBOOK)
                .clickOnNotepadPopupMenu(NotepadPopup.Item.HANDBOOK)
                .checkNotepadPopupMenuItemIsNotRed(NotepadPopup.Item.HANDBOOK)
                .checkNotepadPopupMenuItemHasRightName(NotepadPopup.Item.HANDBOOK)
                .checkNotepadPopupMenuItemIsYellow(NotepadPopup.Item.HANDBOOK)
                .checkNotepadPopupScrollTo(NotepadPopup.Item.HANDBOOK)

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

                .hoverOnNotepadPopupMenuItem(NotepadPopup.Item.ANSWERS)
                .checkNotepadPopupMenuItemIsRed(NotepadPopup.Item.ANSWERS)
                .clickOnNotepadPopupMenu(NotepadPopup.Item.ANSWERS)
                .checkNotepadPopupMenuItemIsNotRed(NotepadPopup.Item.ANSWERS)
                .checkNotepadPopupMenuItemHasRightName(NotepadPopup.Item.ANSWERS)
                .checkNotepadPopupMenuItemIsYellow(NotepadPopup.Item.ANSWERS)
                .checkNotepadPopupScrollTo(NotepadPopup.Item.ANSWERS)

                .checkNotepadPopupMenuItemIsSelectedAfterScrolling(NotepadPopup.Item.ANSWERS)

                .logout();
    }
}
