package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 22/05/16.
 */
public class OSS_1729_MoreOnTheTopicLinks_FSS extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1729", testCaseVersion = "2")
    public void oss_1729_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Еще по теме (Правовая база) ФСС КУ");
        test();
    }

    private void test() {
        // do not use /actual or any document functions,
        // because the link will be used below on the test
        // for calling another function
        String documentUrl = "#/document/99/901807667/";
        loginFss()
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
