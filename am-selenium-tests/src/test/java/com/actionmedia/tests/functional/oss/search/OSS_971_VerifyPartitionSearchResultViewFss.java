package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel Popov on 07/10/15.
 */
public class OSS_971_VerifyPartitionSearchResultViewFss extends AbstractDomainTest {

    private static final String QUERY = "1";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-971", testCaseVersion = "1")
    public void oss_971_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.expert");
        report("Проверяется Подгрузка результатов поисковой выдачи (Отображение) ФСС");
        loginFss()
                .navigateToSolutionsPage()
                .checkSearchBlocksArePresentAndNewBlocksAreLoaded(QUERY)
                .logout();
    }
}