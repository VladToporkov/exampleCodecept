package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Shman4ik on 03.03.2015.
 */
public class OSS_366_SearchFiltersTopicVideo extends AbstractDomainTest {

    public static final String QUERY = "1";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-366", testCaseVersion = "1")
    public void oss_366_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Поисковые фильтры По темам (Видео) ФСС КУ");
        loginFss()
                .navigateToVideoPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkVideosFilter()
                .checkLinksTopicFilter()
                .logout();
    }
}
