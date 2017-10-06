package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 15/01/16.
 */
public class OSS_73_SearchInTextYellowMatches extends AbstractDomainTest {

    private static final String QUERY = "пособие";
    private static final String DOC_NUMBER = "#/document/11/12197/actual";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-73", testCaseVersion = "1")
    public void oss_73_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется виджет Поиск в тексте в документах БСС КУ");
        bss_test();
    }

    public void bss_test() {
        loginBss()
                .navigateToRecomendPage()
                .openDocumentByModuleIdAndDocId(DOC_NUMBER)
                .checkSearchInTextWidgetIsPresent()
                .inputTextInSearchBoxForSearchInText(QUERY)
                .clickHeader()
                .checkSearchInTextWidgetWork(true)
                .clearSearchBox()

                .logout();
    }
}
