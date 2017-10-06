package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;

/**
 * Created by Shman4ik on 29.01.2015.
 */
public class OSS_316_VerifySearchInFound extends AbstractDomainTest {

    private static final String QUERY = "1";
    private static final String QUERYFALSE = "313211512116161";
    private static final String QUERY3 = "налог";
    private static final String QUERY4 = "закон";
    private static final String QUERY5 = "постановление";
    public static final String TYPE = "Закон";
    public static final String CITY = "Москва";
    public static final String QUERY6 = "О внесение изменений в закон";

    @Test(groups = {inDevelopment})
    @TestLink(testCaseId = "OSS-316", testCaseVersion = "1")
    public void oss_316_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("user.expert");
        report("Проверяется Поиск в найденом КСС КУ");
        kss_316_test();

        updateLoginAsInfo("user.expert");
        updateLoginToInfo("budget");
        report("Проверяется Поиск в найденом  КСС БУ");
        kss_316_test();

        updateLoginAsInfo("user.expert");
        updateLoginToInfo("vip");
        report("Проверяется Поиск в найденом КСС ВИП");
        kss_316_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("user.expert");
        report("Проверяется Поиск в найденом БСС КУ");
        bss_316_test();

        updateLoginAsInfo("user.expert");
        updateLoginToInfo("vip");
        report("Проверяется Поиск в найденом БСС ВИП");
        bss_316_test();

        updateLoginAsInfo("user.expert");
        updateLoginToInfo("usn");
        report("Проверяется Поиск в найденом БСС УПР");
        bss_316_test();

        updateLoginAsInfo("user.expert");
        updateLoginToInfo("budget");
        report("Проверяется Поиск в найденом БСС БУ");
        bss_316_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("user.expert");
        report("Проверяется Поиск в найденом ЮСС КУ");
        uss_316_test();

        updateLoginAsInfo("user.expert");
        updateLoginToInfo("doc");
        report("Проверяется Поиск в найденом ЮСС ДОК");
        uss_316_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("user.expert");
        report("Проверяется Поиск в найденом ФСС КУ");
        fss_316_test();
    }

    private void kss_316_test() {
        loginKss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchInResultCheckBoxIsPresent()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchInResultCheckBoxIsNotPresent()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickSearchInResultCheckBox()
                .inputTextInSearchBox(QUERY4)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchInResultCheckBoxIsPresent()
                .checkPresentSearchResultText(QUERY3, QUERY4)
                .checkHighlightingRequest()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickSearchInResultCheckBox()
                .inputTextInSearchBox(QUERY4)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickСourtTag()
                .clickNotActiveStatus()
                .clickDateFilter()
                .clickSearchInResultCheckBox()
                .inputTextInSearchBox(QUERY5)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkPresentSearchResultText(QUERY3, QUERY4, QUERY5)
                .checkConditionFilter()
                .checkHighlightingRequest()

                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .setExtended(TYPE, null, CITY)
                .clickOnButtonSearchOnExtendedForm()
                .inputTextInSearchBox(QUERY6)
                .clickSearchInResultCheckBox()
                .clickSearchButton()
                .checkExtendedSearch(TYPE, CITY, QUERY6)

                .logout();
    }

    private void bss_316_test() {
        loginBss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchInResultCheckBoxIsPresent()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchInResultCheckBoxIsNotPresent()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickSearchInResultCheckBox()
                .inputTextInSearchBox(QUERY4)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchInResultCheckBoxIsPresent()
                .checkPresentSearchResultText(QUERY3, QUERY4)
                .checkHighlightingRequest()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickSearchInResultCheckBox()
                .inputTextInSearchBox(QUERY4)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickСourtTag()
                .clickNotActiveStatus()
                .clickDateFilter()
                .clickSearchInResultCheckBox()
                .inputTextInSearchBox(QUERY5)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkPresentSearchResultText(QUERY3, QUERY4, QUERY5)
                .checkConditionFilter()
                .checkHighlightingRequest()

                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .setExtended(TYPE, CITY)
                .clickOnButtonSearchOnExtendedForm()
                .inputTextInSearchBox(QUERY6)
                .clickSearchInResultCheckBox()
                .clickSearchButton()
                .checkExtendedSearch(TYPE, CITY, QUERY6)

                .logout();
    }

    private void uss_316_test() {
        loginUss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchInResultCheckBoxIsPresent()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchInResultCheckBoxIsNotPresent()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickSearchInResultCheckBox()
                .inputTextInSearchBox(QUERY4)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchInResultCheckBoxIsPresent()
                .checkPresentSearchResultText(QUERY3, QUERY4)
                .checkHighlightingRequest()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickSearchInResultCheckBox()
                .inputTextInSearchBox(QUERY4)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickСourtTag()
                .clickNotActiveStatus()
                .clickDateFilter()
                .clickSearchInResultCheckBox()
                .inputTextInSearchBox(QUERY5)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkPresentSearchResultText(QUERY3, QUERY4, QUERY5)
                .checkConditionFilter()
                .checkHighlightingRequest()

                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .setExtended(TYPE, CITY)
                .clickOnButtonSearchOnExtendedForm()
                .inputTextInSearchBox(QUERY6)
                .clickSearchInResultCheckBox()
                .clickSearchButton()
                .checkExtendedSearch(TYPE, CITY, QUERY6)

                .logout();
    }

    private void fss_316_test() {
        loginFss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchInResultCheckBoxIsPresent()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchInResultCheckBoxIsNotPresent()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickSearchInResultCheckBox()
                .inputTextInSearchBox(QUERY4)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchInResultCheckBoxIsPresent()
                .checkPresentSearchResultText(QUERY3, QUERY4)
                .checkHighlightingRequest()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickSearchInResultCheckBox()
                .inputTextInSearchBox(QUERY4)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickСourtTag()
                .clickNotActiveStatus()
                .clickDateFilter()
                .clickSearchInResultCheckBox()
                .inputTextInSearchBox(QUERY5)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkPresentSearchResultText(QUERY3, QUERY4, QUERY5)
                .checkConditionFilter()
                .checkHighlightingRequest()

                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .setExtended(TYPE, CITY)
                .clickOnButtonSearchOnExtendedForm()
                .inputTextInSearchBox(QUERY6)
                .clickSearchInResultCheckBox()
                .clickSearchButton()
                .checkExtendedSearch(TYPE, CITY, QUERY6)

                .logout();
    }

}
