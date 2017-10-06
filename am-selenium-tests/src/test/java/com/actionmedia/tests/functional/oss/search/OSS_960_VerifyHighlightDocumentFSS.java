package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel Popov on 12/10/15.
 */
public class OSS_960_VerifyHighlightDocumentFSS extends AbstractDomainTest {

    private static final String QUERY = "ндс";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-960", testCaseVersion = "1")
    public void oss_960_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.demo");
        report("Проверяется Подсветка поискового запроса в документе ФСС КУ");
        loginFss()
                .navigateToMagazinesPage()
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
