package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel Popov on 07/10/15.
 */
public class OSS_969_VerifyPartitionSearchResultViewKss extends AbstractDomainTest {

    private static final String QUERY = "форма";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-969", testCaseVersion = "1")
    public void oss_969_test() {
        updateSystemInfo(SystemPubs.kss);

        switch (getNumberOfSystem()) {
            case 0: {
                updateLoginAsInfo("kss.user.expert");
                report("Проверяется Подгрузка результатов поисковой выдачи (Отображение) КСС КУ ");
                break;
            }
            case 1: {
                updateLoginAsInfo("kss.user.budget");
                updateLoginToInfo("budget");
                report("Проверяется Подгрузка результатов поисковой выдачи (Отображение) КСС БУ");
                break;
            }
            case 2: {
                updateLoginAsInfo("kss.user.vip");
                updateLoginToInfo("vip");
                report("Проверяется Подгрузка результатов поисковой выдачи (Отображение) КСС ВИП");
                break;
            }
        }

        loginKss()
                .navigateToFormsPage()
                .checkSearchBlocksArePresentAndNewBlocksAreLoaded(QUERY)
                .logout();
    }

    private int getNumberOfSystem() {
        return getMultiplicityOfWeekNumber() % 3;
    }

}
