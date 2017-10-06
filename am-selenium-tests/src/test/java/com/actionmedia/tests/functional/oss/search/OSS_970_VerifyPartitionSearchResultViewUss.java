package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel Popov on 07/10/15.
 */
public class OSS_970_VerifyPartitionSearchResultViewUss extends AbstractDomainTest {

    private static final String QUERY = "календарь";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-970", testCaseVersion = "1")
    public void oss_970_test() {
        updateSystemInfo(SystemPubs.uss);

        switch (getNumberOfSystem()) {
            case 0: {
                updateLoginAsInfo("uss.user.expert");
                report("Проверяется Подгрузка результатов поисковой выдачи (Отображение) ЮСС КУ ");
                break;
            }
            case 1: {
                updateLoginAsInfo("uss.user.vip");
                updateLoginToInfo("doc");
                report("Проверяется Подгрузка результатов поисковой выдачи (Отображение) ЮСС ВИП");
                break;
            }
        }

        loginUss()
                .navigateToDictionaryPage()
                .checkSearchBlocksArePresentAndNewBlocksAreLoaded(QUERY)
                .logout();
    }

    private int getNumberOfSystem() {
        return getMultiplicityOfWeekNumber() % 2;
    }
}
