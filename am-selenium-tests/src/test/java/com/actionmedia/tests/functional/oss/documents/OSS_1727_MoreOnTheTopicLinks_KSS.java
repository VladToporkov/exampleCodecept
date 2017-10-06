package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 22/05/16.
 */
public class OSS_1727_MoreOnTheTopicLinks_KSS extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1727", testCaseVersion = "2")
    public void oss_1727_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Еще по теме (Правовая база) КСС КУ");
        test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Еще по теме (Правовая база) КСС БУ");
        test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Еще по теме (Правовая база) КСС ВИП");
        test();
    }

    private void test() {
        // do not use /actual or any document functions,
        // because the link will be used below on the test
        // for calling another function
        String documentUrl = "#/document/99/901807664/";
        loginKss()
                .openDocumentByModuleIdAndDocId(documentUrl)
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

                .openDocumentByModuleIdAndDocId(documentUrl + "/links-to/")
                .checkMoreLinksAreDuplicatedBelowOfTheDocument()

                .clickOnLinksFromInfobarInBottom()
                .checkDocumentIsOpened()

                .returnToBack()

                .clickOnLinksFromInfobarInBottom()
                .checkDocumentIsOpened()

                .logout();
    }
}