package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel Popov on 06/10/15.
 */
public class OSS_968_VerifyPartitionSearchResultViewBss extends AbstractDomainTest {

    private static final String QUERY = "закон";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-968", testCaseVersion = "1")
    public void oss_968_test() {
        updateSystemInfo(SystemPubs.bss);

        switch (getNumberOfSystem()) {
            case 0: {
                updateLoginAsInfo("bss.user.expert");
                report("Проверяется Подгрузка результатов поисковой выдачи (Отображение) БСС КУ ");
                break;
            }
            case 1: {
                updateLoginAsInfo("bss.user.budget");
                updateLoginToInfo("budget");
                report("Проверяется Подгрузка результатов поисковой выдачи (Отображение) БСС БУ");
                break;
            }
            case 2: {
                updateLoginAsInfo("bss.user.usn");
                updateLoginToInfo("usn");
                report("Проверяется Подгрузка результатов поисковой выдачи (Отображение) БСС УСН");
                break;
            }
            case 3: {
                updateLoginAsInfo("bss.user.vip");
                updateLoginToInfo("vip");
                report("Проверяется Подгрузка результатов поисковой выдачи (Отображение) БСС ВИП");
                break;
            }
        }

        loginBss()
                .navigateToLawBasePage()
                .checkSearchBlocksArePresentAndNewBlocksAreLoaded(QUERY)
                .logout();
    }

    private int getNumberOfSystem() {
        return getMultiplicityOfWeekNumber() % 4;
    }
}
