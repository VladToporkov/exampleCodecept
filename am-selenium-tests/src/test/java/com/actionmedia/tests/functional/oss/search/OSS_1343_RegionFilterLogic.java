package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 30/11/15.
 */
public class OSS_1343_RegionFilterLogic extends AbstractDomainTest {

    private static final String QUERY = "1";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1343", testCaseVersion = "1")
    public void oss_1343_test() {
        switch (getNumberOfSystem()) {
            case 0: {
                test_uss();
                break;
            }
            case 1: {
                test_fss();
                break;
            }
            case 2: {
                test_bss();
                break;
            }
            case 3: {
                test_kss();
                break;
            }
        }
    }

    public void test_uss() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Поисковые фильтры По регионам (Логика) ЮСС КУ");
        loginUss()
                .clickProfileLink()
                .changeRegion("Калининград")
                .goBack()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkRegionFilter(true, "Калининградская область")
                .checkRegionFilterInSearchExtendedStringIsNotPresent()
                .checkRegionInSearchHeader("калининград", 125)
                .checkRegionFilterInSearchExtendedStringIsPresent()

                .clickInLawPracticeLinkFilter()
                .checkRegionFilterInSearchExtendedStringIsNotPresent()
                .chooseSecondRegionFilter()
                .checkRegionFilterInSearchExtendedStringIsPresent()

                .clickProfileLink()
                .changeRegion("Москва")

                .logout();
    }

    public void test_fss() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Поисковые фильтры По регионам (Логика) ФСС КУ");
        loginFss()
                .clickProfileLink()
                .changeRegion("Калининград")
                .goBack()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkRegionFilter(true, "Калининградская область")
                .checkRegionFilterInSearchExtendedStringIsNotPresent()
                .checkRegionInSearchHeader("калининград", 125)
                .checkRegionFilterInSearchExtendedStringIsPresent()

                .clickInLawPracticeLinkFilter()
                .checkRegionFilterInSearchExtendedStringIsNotPresent()
                .chooseSecondRegionFilter()
                .checkRegionFilterInSearchExtendedStringIsPresent()

                .clickProfileLink()
                .changeRegion("Москва")

                .logout();
    }

    public void test_bss() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Поисковые фильтры По регионам (Логика) БСС КУ");
        loginBss()
                .clickProfileLink()
                .changeRegion("Калининград")
                .goBack()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkRegionFilter(true, "Калининградская область")
                .checkRegionFilterInSearchExtendedStringIsNotPresent()
                .checkRegionInSearchHeader("калининград", 125)
                .checkRegionFilterInSearchExtendedStringIsPresent()

                .clickInLawPracticeLinkFilter()
                .checkRegionFilterInSearchExtendedStringIsNotPresent()
                .chooseSecondRegionFilter()
                .checkRegionFilterInSearchExtendedStringIsPresent()

                .clickProfileLink()
                .changeRegion("Москва")

                .logout();
    }

    private void test_kss() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Поисковые фильтры По регионам (Логика) КСС КУ");
        loginKss()
                .clickProfileLink()
                .changeRegion("Калининград")
                .goBack()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkRegionFilter(true, "Калининградская область")
                .checkRegionFilterInSearchExtendedStringIsNotPresent()
                .checkRegionInSearchHeader("калининград", 125)
                .checkRegionFilterInSearchExtendedStringIsPresent()

                .clickInLawPracticeLinkFilter()
                .checkRegionFilterInSearchExtendedStringIsNotPresent()
                .chooseSecondRegionFilter()
                .checkRegionFilterInSearchExtendedStringIsPresent()

                .clickProfileLink()
                .changeRegion("Москва")

                .logout();
    }


    private int getNumberOfSystem() {
        return getMultiplicityOfWeekNumber() % 4;
    }
}
