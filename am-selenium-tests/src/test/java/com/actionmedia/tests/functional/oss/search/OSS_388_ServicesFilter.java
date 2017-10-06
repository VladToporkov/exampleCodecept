package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inTesting;
import static com.actionmedia.autotest.Group.regression;


public class OSS_388_ServicesFilter extends AbstractDomainTest {

    private static final String QUERY = "финансовый";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-388", testCaseVersion = "2")
    public void oss_388_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Поисковые фильтры По темам (Сервисы) ФСС КУ");
        fss_388_test();
    }

    private void fss_388_test() {
        loginFss()
                .navigateToServicesPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkServicesFilter()
                .checkLinksServicesFilter()

                .logout();
    }
}
