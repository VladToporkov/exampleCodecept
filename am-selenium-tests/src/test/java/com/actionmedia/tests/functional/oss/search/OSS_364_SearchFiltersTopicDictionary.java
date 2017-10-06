package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Shman4ik on 03.03.2015.
 */
public class OSS_364_SearchFiltersTopicDictionary extends AbstractDomainTest {

    public static final String QUERY = "1";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-364", testCaseVersion = "1")
    public void oss_364_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginToInfo("budget");
        updateLoginAsInfo("bss.user.budget");
        report("Проверяется Поисковые фильтры По темам (Справочник)  БСС БУ");
        loginBss()
                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkTopicFilter()
                .checkLinksTopicFilter()
                .logout();

        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Поисковые фильтры По темам (Справочники) ФСС КУ");
        loginFss()
                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkTopicFilter()
                .checkLinksTopicFilter()
                .logout();
    }
}
