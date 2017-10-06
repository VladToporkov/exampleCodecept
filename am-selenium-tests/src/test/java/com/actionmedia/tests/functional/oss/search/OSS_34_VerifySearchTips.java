package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;

/**
 * Created by Shman4ik on 29.01.2015.
 */
public class OSS_34_VerifySearchTips extends AbstractDomainTest {

    private static final String QUERY = "а";

    @Test(groups = {inDevelopment})
    @TestLink(testCaseId = "OSS-34", testCaseVersion = "1")
    public void oss_34_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется OSS-34:Поисковые подсказки КСС КУ");
        kss_34_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется OSS-34:Поисковые подсказки  КСС БУ");
        kss_34_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется OSS-34:Поисковые подсказки КСС ВИП");
        kss_34_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется OSS-34:Поисковые подсказки БСС КУ");
        bss_34_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется OSS-34:Поисковые подсказки БСС ВИП");
        bss_34_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется OSS-34:Поисковые подсказки БСС УПР");
        bss_34_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется OSS-34:Поисковые подсказки БСС БУ");
        bss_34_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется OSS-34:Поисковые подсказки ЮСС КУ");
        uss_34_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется OSS-34:Поисковые подсказки ЮСС ДОК");
        uss_34_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется OSS-34:Поисковые подсказки ФСС КУ");
        fss_34_test();
    }

    private void kss_34_test() {
        loginKss()
                .navigateToAnswersPage()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(QUERY)
                .checkNavigateToLink()
                .inputTextInSearchBox(QUERY)
                .checkClickKeysInToolTops()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(QUERY)
                .checkNavigateToLink()
                .inputTextInSearchBox(QUERY)
                .checkClickKeysInToolTops()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(QUERY)
                .checkNavigateToLink()
                .inputTextInSearchBox(QUERY)
                .checkClickKeysInToolTops()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(QUERY)
                .checkNavigateToLink()
                .inputTextInSearchBox(QUERY)
                .checkClickKeysInToolTops()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(QUERY)
                .checkNavigateToLink()
                .inputTextInSearchBox(QUERY)
                .checkClickKeysInToolTops()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(QUERY)
                .checkClickKeysInToolTops()

                .navigateToServicesPage()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(QUERY)
                .checkClickKeysInToolTops()

                .navigateToRabotaruPage()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(QUERY)
                .checkClickKeysInToolTops()

                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(QUERY)
                .checkNavigateToLinkExtended()

                .logout();
    }

    private void bss_34_test() {
        loginBss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(QUERY)
                .checkNavigateToLink()
                .inputTextInSearchBox(QUERY)
                .checkClickKeysInToolTops()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(QUERY)
                .checkNavigateToLink()
                .inputTextInSearchBox(QUERY)
                .checkClickKeysInToolTops()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(QUERY)
                .checkNavigateToLink()
                .inputTextInSearchBox(QUERY)
                .checkClickKeysInToolTops()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(QUERY)
                .checkNavigateToLink()
                .inputTextInSearchBox(QUERY)
                .checkClickKeysInToolTops()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(QUERY)
                .checkNavigateToLink()
                .inputTextInSearchBox(QUERY)
                .checkClickKeysInToolTops()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(QUERY)
                .checkClickKeysInToolTops()

                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(QUERY)
                .checkNavigateToLinkExtended()

                .logout();
    }

    private void uss_34_test() {
        loginUss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(QUERY)
                .checkNavigateToLink()
                .inputTextInSearchBox(QUERY)
                .checkClickKeysInToolTops()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(QUERY)
                .checkNavigateToLink()
                .inputTextInSearchBox(QUERY)
                .checkClickKeysInToolTops()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(QUERY)
                .checkNavigateToLink()
                .inputTextInSearchBox(QUERY)
                .checkClickKeysInToolTops()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(QUERY)
                .checkNavigateToLink()
                .inputTextInSearchBox(QUERY)
                .checkClickKeysInToolTops()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(QUERY)
                .checkNavigateToLink()
                .inputTextInSearchBox(QUERY)
                .checkClickKeysInToolTops()

                .navigateToServicesPage()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(QUERY)
                .checkNavigateToLink()
                .inputTextInSearchBox(QUERY)
                .checkClickKeysInToolTops()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(QUERY)
                .checkClickKeysInToolTops()

                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(QUERY)
                .checkNavigateToLinkExtended()

                .logout();
    }

    private void fss_34_test() {
        loginFss()
                .navigateToSolutionsPage()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(QUERY)
                .checkNavigateToLink()
                .inputTextInSearchBox(QUERY)
                .checkClickKeysInToolTops()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(QUERY)
                .checkNavigateToLink()
                .inputTextInSearchBox(QUERY)
                .checkClickKeysInToolTops()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(QUERY)
                .checkNavigateToLink()
                .inputTextInSearchBox(QUERY)
                .checkClickKeysInToolTops()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(QUERY)
                .checkNavigateToLink()
                .inputTextInSearchBox(QUERY)
                .checkClickKeysInToolTops()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(QUERY)
                .checkNavigateToLink()
                .inputTextInSearchBox(QUERY)
                .checkClickKeysInToolTops()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(QUERY)
                .checkClickKeysInToolTops()

                .navigateToServicesPage()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(QUERY)
                .checkClickKeysInToolTops()

                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(QUERY)
                .checkSearchStraightTip()
                .checkNavigateToDirectLink()
                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(QUERY)
                .checkNavigateToLinkExtended()

                .logout();
    }

}
