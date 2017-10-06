package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel Popov on 30/09/15.
 */
public class OSS_926_VerifySearchTipsBss extends AbstractDomainTest {

    private static final String queryLaw = "закон";
    private static final String queryOrder = "приказ";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-926", testCaseVersion = "1")
    public void oss_926_test() {
        //step 1
        updateSystemInfo(SystemPubs.bss);
        report("Проверяется OSS-926:Поисковые подсказки (отображение) БСС КУ");
        enterToBssWithoutLogin()
                .navigateToRecomendPage()
                .inputTextInSearchBox(queryLaw)
                .checkSearchStraightTip();

        updateSystemInfo(SystemPubs.bss);
        updateLoginToInfo("usn");
        report("Проверяется OSS-926:Поисковые подсказки (отображение) БСС УСН");
        enterToBssWithoutLogin()
                .navigateToRecomendPage()
                .inputTextInSearchBox(queryLaw)
                .checkSearchStraightTip();

        updateSystemInfo(SystemPubs.bss);
        updateLoginToInfo("budget");
        report("Проверяется OSS-926:Поисковые подсказки (отображение) БСС БУ");
        enterToBssWithoutLogin()
                .navigateToRecomendPage()
                .inputTextInSearchBox(queryLaw)
                .checkSearchStraightTip();

        updateSystemInfo(SystemPubs.bss);
        updateLoginToInfo("vip");
        report("Проверяется OSS-926:Поисковые подсказки (отображение) БСС ВИП");
        enterToBssWithoutLogin()
                .navigateToRecomendPage()
                .inputTextInSearchBox(queryLaw)
                .checkSearchStraightTip();

        //step 2
        updateSystemInfo(SystemPubs.bss);
        report("Проверяется OSS-926:Поисковые подсказки (отображение) Правовая база БСС КУ ");
        enterToBssWithoutLogin()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(queryOrder)
                .checkNavigateToLinkExtended();

        updateSystemInfo(SystemPubs.bss);
        updateLoginToInfo("usn");
        report("Проверяется OSS-926:Поисковые подсказки (отображение) Правовая база БСС УСН ");
        enterToBssWithoutLogin()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(queryOrder)
                .checkNavigateToLinkExtended();

        updateSystemInfo(SystemPubs.bss);
        updateLoginToInfo("budget");
        report("Проверяется OSS-926:Поисковые подсказки (отображение) Правовая база БСС БУ ");
        enterToBssWithoutLogin()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(queryOrder)
                .checkNavigateToLinkExtended();

        updateSystemInfo(SystemPubs.bss);
        updateLoginToInfo("vip");
        report("Проверяется OSS-926:Поисковые подсказки (отображение) Правовая база БСС ВИП ");
        enterToBssWithoutLogin()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(queryOrder)
                .checkNavigateToLinkExtended();
    }
}
