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
public class OSS_1530_BacklinksAndNotepadFSS extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1530", testCaseVersion = "1")
    public void oss_1530_test() {
        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Отображение числа беклинков и блокнота ФСС КУ");
        loginFss()
                .navigateToSolutionsPage()
                .openDocumentByModuleIdAndDocId("#/document/99/901714421/")
                .checkBacklinksArePresent()
                .checkBacklinkHasCssStyles()

                .clickOnBacklinkWithReferencesCount(1)
                .checkParagraphAndButtonAreGray()
                .checkNotepadPopupIsPresent()
                .checkNotepadPopupHasShadowFss()
                .checkNotepadPopupHeaderIsWhite()
                .checkNotepadPopupTitleIsPresent()
                .checkNotepadPopupCloseIconIsPresent()
                .checkNotepadPopupBodyIsYellow()
                .checkNotepadPopupBodyHasBacklinks()

                .clickOnNotepadPopupCloseButton()
                .checkNotepadPopupIsNotPresent()
                .checkParagraphAndButtonAreNotYellow()

                .openDocumentByModuleIdAndDocId("#/document/99/902290120/XA00MFG2O8/")
                .clickOnRequiredArticleBacklink("XA00MFG2O8")
                .checkNotepadPopupIsPresent()
                .checkNotepadPopupHasShadowFss()
                .checkNotepadPopupHeaderIsWhite()
                .checkNotepadPopupTitleIsPresent()
                .checkNotepadPopupCloseIconIsPresent()
                .checkNotepadPopupBodyIsYellow()
                .checkNotepadPopupBodyHasBacklinks()
                .checkNotepadPopupMenuBlockIsPresent()
                .checkNotepadPopupMenuItemsInOrder(NotepadPopup.Item.SOLUTIONS, NotepadPopup.Item.PRESS,
                        NotepadPopup.Item.HANDBOOK, NotepadPopup.Item.LAW,
                        NotepadPopup.Item.LAWPRACTICE)
                .checkNotepadPopupMenuItemIcon(NotepadPopup.Item.SOLUTIONS, NotepadPopup.Item.PRESS,
                        NotepadPopup.Item.HANDBOOK, NotepadPopup.Item.LAW,
                        NotepadPopup.Item.LAWPRACTICE)

                .hoverOnNotepadPopupMenuItem(NotepadPopup.Item.PRESS)
                .checkNotepadPopupMenuItemIsOrange(NotepadPopup.Item.PRESS)
                .clickOnNotepadPopupMenu(NotepadPopup.Item.PRESS)
                .checkNotepadPopupMenuItemIsNotOrange(NotepadPopup.Item.PRESS)
                .checkNotepadPopupMenuItemHasRightName(NotepadPopup.Item.PRESS)
                .checkNotepadPopupMenuItemIsYellow(NotepadPopup.Item.PRESS)
                .checkNotepadPopupScrollTo(NotepadPopup.Item.PRESS)

                .hoverOnNotepadPopupMenuItem(NotepadPopup.Item.HANDBOOK)
                .checkNotepadPopupMenuItemIsOrange(NotepadPopup.Item.HANDBOOK)
                .clickOnNotepadPopupMenu(NotepadPopup.Item.HANDBOOK)
                .checkNotepadPopupMenuItemIsNotOrange(NotepadPopup.Item.HANDBOOK)
                .checkNotepadPopupMenuItemHasRightName(NotepadPopup.Item.HANDBOOK)
                .checkNotepadPopupMenuItemIsYellow(NotepadPopup.Item.HANDBOOK)
                .checkNotepadPopupScrollTo(NotepadPopup.Item.HANDBOOK)

                .hoverOnNotepadPopupMenuItem(NotepadPopup.Item.LAW)
                .checkNotepadPopupMenuItemIsOrange(NotepadPopup.Item.LAW)
                .clickOnNotepadPopupMenu(NotepadPopup.Item.LAW)
                .checkNotepadPopupMenuItemIsNotOrange(NotepadPopup.Item.LAW)
                .checkNotepadPopupMenuItemHasRightName(NotepadPopup.Item.LAW)
                .checkNotepadPopupMenuItemIsYellow(NotepadPopup.Item.LAW)
                .checkNotepadPopupScrollTo(NotepadPopup.Item.LAW)

                .hoverOnNotepadPopupMenuItem(NotepadPopup.Item.LAWPRACTICE)
                .checkNotepadPopupMenuItemIsOrange(NotepadPopup.Item.LAWPRACTICE)
                .clickOnNotepadPopupMenu(NotepadPopup.Item.LAWPRACTICE)
                .checkNotepadPopupMenuItemIsNotOrange(NotepadPopup.Item.LAWPRACTICE)
                .checkNotepadPopupMenuItemHasRightName(NotepadPopup.Item.LAWPRACTICE)
                .checkNotepadPopupMenuItemIsYellow(NotepadPopup.Item.LAWPRACTICE)
                .checkNotepadPopupScrollTo(NotepadPopup.Item.LAWPRACTICE)

                .hoverOnNotepadPopupMenuItem(NotepadPopup.Item.SOLUTIONS)
                .checkNotepadPopupMenuItemIsOrange(NotepadPopup.Item.SOLUTIONS)
                .clickOnNotepadPopupMenu(NotepadPopup.Item.SOLUTIONS)
                .checkNotepadPopupMenuItemIsNotOrange(NotepadPopup.Item.SOLUTIONS)
                .checkNotepadPopupMenuItemHasRightName(NotepadPopup.Item.SOLUTIONS)
                .checkNotepadPopupMenuItemIsYellow(NotepadPopup.Item.SOLUTIONS)
                .checkNotepadPopupScrollTo(NotepadPopup.Item.SOLUTIONS)

                .checkNotepadPopupMenuItemIsSelectedAfterScrolling(NotepadPopup.Item.SOLUTIONS)

                .logout();
    }
}
