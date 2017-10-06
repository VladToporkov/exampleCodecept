package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inTesting;
import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel on 22/05/16.
 */
public class OSS_360_MoreOnTheTopicLinks_BSS extends AbstractDomainTest {

    private static String DOCUMENT_URL = "#/document/99/901714421/";// do not use /actual or any document functions,
                                                                    // because the link will be used below on the test
                                                                    // for calling another function

    @Test(groups = {inTesting})
    @TestLink(testCaseId = "OSS-360", testCaseVersion = "2")
    public void oss_360_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Еще по теме (Правовая база) БСС КУ");
        test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Еще по теме (Правовая база) БСС БУ");
        test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Еще по теме (Правовая база) БСС УСН");
        test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Еще по теме (Правовая база) БСС ВИП");
        test();
    }

    private void test() {
        loginBss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL)
                .checkDocumentIsOpened()
                .checkMoreOnTheTopicIsPresent()

                .clickOnMoreLinksFromInfobarOfTheDocument()
                .checkMoreLinksLinkHasYellowHighlightAfterClicking()
                .checkMoreLinksBlockIsOpened()
                .checkMoreLinksHasTitleLinks()

                .clickOnMoreLinksRandomLink()
                .checkDocumentIsOpened()

                .returnToBack()

                .clickOnMoreLinksRandomLink()
                .checkDocumentIsOpened()

                .returnToBack()

                .openDocumentByModuleIdAndDocId(DOCUMENT_URL + "/links-to/")
                .checkMoreLinksAreDuplicatedBelowOfTheDocument()

                .clickOnLinksFromInfobarInBottom()
                .checkDocumentIsOpened()

                .returnToBack()

                .clickOnLinksFromInfobarInBottom()
                .checkDocumentIsOpened()

                .logout();
    }
}
