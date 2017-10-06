package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 22/05/16.
 */
public class OSS_1728_MoreOnTheTopicLinks_USS extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1728", testCaseVersion = "2")
    public void oss_1728_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Еще по теме (Правовая база) ЮСС КУ");
        test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Еще по теме (Правовая база) ЮСС ВИП");
        test();
    }

    private void test() {
        // because the link will be used below on the test
        // for calling another function
        String documentUrl = "#/document/99/9027690/";
        loginUss()
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
