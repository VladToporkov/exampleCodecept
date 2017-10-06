package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.components.popups.NotepadPopup;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel on 17/03/16.
 */
public class OSS_421_BacklinksAndNotepadBSS extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-421", testCaseVersion = "1")
    public void oss_421_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Отображение числа беклинков и блокнота БСС КУ");
        loginBss()
                .navigateToRecomendPage()
                .openDocumentByModuleIdAndDocId("#/document/99/901765862/actual")
                .checkBacklinksArePresent()
                .checkBacklinkHasCssStyles()

                .clickOnBacklinkWithReferencesCount(1)
                .checkParagraphAndButtonAreYellow()
                .checkNotepadPopupIsPresent()
                .checkNotepadPopupHasShadow()
                .checkNotepadPopupHeaderIsWhite()
                .checkNotepadPopupTitleIsPresent()
                .checkNotepadPopupCloseIconIsPresent()
                .checkNotepadPopupBodyIsYellow()
                .checkNotepadPopupBodyHasBacklinks()
                .checkNotepadPopupMenuBlockIsNotPresent()

                .clickOnNotepadPopupCloseButton()
                .checkNotepadPopupIsNotPresent()
                .checkParagraphAndButtonAreNotYellow()

                .openDocumentByModuleIdAndDocId("#/document/99/9027690/actual")
                .clickOnRequiredArticleBacklink("XA00M8U2MR")
                .checkNotepadPopupIsPresent()
                .checkNotepadPopupHasShadow()
                .checkNotepadPopupHeaderIsWhite()
                .checkNotepadPopupTitleIsPresent()
                .checkNotepadPopupCloseIconIsPresent()
                .checkNotepadPopupBodyIsYellow()
                .checkNotepadPopupBodyHasBacklinks()
                .checkNotepadPopupMenuBlockIsPresent()
                .checkNotepadPopupMenuItemsInOrder(
                        NotepadPopup.Item.RECOMMENDATIONS,
                        NotepadPopup.Item.HANDBOOK,
                        NotepadPopup.Item.PRESS,
                        NotepadPopup.Item.FORMS,
                        NotepadPopup.Item.LAWPRACTICE,
                        NotepadPopup.Item.LAW)
                .checkNotepadPopupMenuItemIcon(
                        NotepadPopup.Item.RECOMMENDATIONS,
                        NotepadPopup.Item.HANDBOOK,
                        NotepadPopup.Item.PRESS,
                        NotepadPopup.Item.FORMS,
                        NotepadPopup.Item.LAWPRACTICE,
                        NotepadPopup.Item.LAW)

                .hoverOnNotepadPopupMenuItem(NotepadPopup.Item.FORMS)
                .checkNotepadPopupMenuItemIsRed(NotepadPopup.Item.FORMS)
                .clickOnNotepadPopupMenu(NotepadPopup.Item.FORMS)
                .checkNotepadPopupMenuItemIsNotRed(NotepadPopup.Item.FORMS)
                .checkNotepadPopupMenuItemHasRightName(NotepadPopup.Item.FORMS)
                .checkNotepadPopupMenuItemIsYellow(NotepadPopup.Item.FORMS)
                .checkNotepadPopupScrollTo(NotepadPopup.Item.FORMS)

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
