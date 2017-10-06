package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel Popov on 12/10/15.
 */
public class OSS_957_VerifyHighlightInDocumentKSS extends AbstractDomainTest {

    private static final String QUERY = "трудовая деятельность";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-957", testCaseVersion = "1")
    public void oss_957_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.demo");
        report("Проверяется Подсветка поискового запроса в документе КСС КУ");
        loginKss()
                .navigateToAnswersPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultHelper()

                        //open first random result
                .openRandomSearchDocument()
                .checkDocumentIsNotEmpty()
                .checkHighlightingWordDocument()
                .returnToSearchResultPage()
                        //open second random result
                .openRandomSearchDocument()
                .checkDocumentIsNotEmpty()
                .checkHighlightingWordDocument()
                .returnToSearchResultPage()
                        //open third random result
                .openRandomSearchDocument()
                .checkDocumentIsNotEmpty()
                .checkHighlightingWordDocument()
                .logoutBase();
    }
}
