package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel Popov on 11/10/15.
 */
public class OSS_956_VerifyHighlightInDocumentBSS extends AbstractDomainTest {

    private static final String QUERY = "кодекс";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-956", testCaseVersion = "1")
    public void oss_956_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Подсветка поискового запроса в документе БСС КУ");
        loginBss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultHelper()
                .checkSearchQueryIsHighlighted(QUERY)

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
