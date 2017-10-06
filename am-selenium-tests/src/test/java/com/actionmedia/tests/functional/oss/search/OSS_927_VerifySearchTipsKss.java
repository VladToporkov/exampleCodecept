package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel Popov on 01/10/15.
 */
public class OSS_927_VerifySearchTipsKss extends AbstractDomainTest {

    private static final String query = "учет";
    private static final String queryLaw = "трудовая";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-927", testCaseVersion = "1")
    public void oss_927_test() {
        //step 1
        updateSystemInfo(SystemPubs.kss);
        report("Проверяется OSS-927:Поисковые подсказки (отображение) КСС КУ");
        enterToKssWithoutLogin()
                .navigateToAnswersPage()
                .inputTextInSearchBox(query)
                .checkSearchStraightTip();

        updateSystemInfo(SystemPubs.kss);
        updateLoginToInfo("budget");
        report("Проверяется OSS-927:Поисковые подсказки (отображение) КСС БУ");
        enterToKssWithoutLogin()
                .navigateToAnswersPage()
                .inputTextInSearchBox(query)
                .checkSearchStraightTip();

        updateSystemInfo(SystemPubs.kss);
        updateLoginToInfo("vip");
        report("Проверяется OSS-927:Поисковые подсказки (отображение) КСС ВИП");
        enterToKssWithoutLogin()
                .navigateToAnswersPage()
                .inputTextInSearchBox(query)
                .checkSearchStraightTip();

        //step 2
        updateSystemInfo(SystemPubs.kss);
        report("Проверяется OSS-927:Поисковые подсказки (отображение) Правовая база КСС КУ");
        enterToKssWithoutLogin()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(queryLaw)
                .checkNavigateToLinkExtended();

        updateSystemInfo(SystemPubs.kss);
        updateLoginToInfo("budget");
        report("Проверяется OSS-927:Поисковые подсказки (отображение) Правовая база КСС БУ");
        enterToKssWithoutLogin()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(queryLaw)
                .checkNavigateToLinkExtended();

        updateSystemInfo(SystemPubs.kss);
        updateLoginToInfo("vip");
        report("Проверяется OSS-927:Поисковые подсказки (отображение) Правовая база КСС ВИП");
        enterToKssWithoutLogin()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(queryLaw)
                .checkNavigateToLinkExtended();
    }
}
