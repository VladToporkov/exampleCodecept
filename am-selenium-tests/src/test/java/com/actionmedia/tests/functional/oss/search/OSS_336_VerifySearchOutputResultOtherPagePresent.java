package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Shman4ik on 28.01.2015.
 */
public class OSS_336_VerifySearchOutputResultOtherPagePresent extends AbstractDomainTest {

    private static final String QUERY = "123";
    public static final String DOC_URL_KSS = "#/document/184/1133/actual";
    public static final String DOC_URL_BSS = "#/document/184/1822/actual";
    public static final String DOC_URL_USS = "#/document/184/1956/actual";
    public static final String DOC_URL_FSS = "#/document/184/1881/actual";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-336", testCaseVersion = "1")
    public void oss_336_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Поиск в других разделах КСС КУ");
        kss_336_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Поиск в других разделах КСС БУ");
        kss_336_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Поиск в других разделах КСС ВИП");
        kss_336_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Поиск в других разделах БСС КУ");
        bss_336_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Поиск в других разделах БСС ВИП");
        bss_336_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Поиск в других разделах БСС УПР");
        bss_336_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Поиск в других разделах БСС БУ");
        bss_336_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Поиск в других разделах ЮСС КУ");
        uss_336_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Поиск в других разделах ЮСС ДОК");
        uss_336_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Поиск в других разделах ФСС КУ");
        fss_336_test();
    }

    private void kss_336_test() {
        loginKss()
                .clickProfileLink()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnAnswersPageIsOpened()

                .openDocumentByModuleIdAndDocId(DOC_URL_KSS)
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnAnswersPageIsOpened()

                .clickAskExpertLink()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnAnswersPageIsOpened()

                .navigateToLawBasePage()
                .navigateToAnswersPage()
                .clickNewsPageLink()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnAnswersPageIsOpened()

                .logout();
    }

    private void bss_336_test() {
        loginBss()
                .clickProfileLink()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnRecomendPageIsOpened()

                .openDocumentByModuleIdAndDocId(DOC_URL_BSS)
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnRecomendPageIsOpened()

                .clickAskExpertLink()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnRecomendPageIsOpened()

                .navigateToLawBasePage()
                .navigateToRecomendPage()
                .clicNewsPageLink()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnRecomendPageIsOpened()

                .logout();
    }

    private void uss_336_test() {
        loginUss()
                .clickProfileLink()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnRecomendPageIsOpened()

                .openDocumentByModuleIdAndDocId(DOC_URL_USS)
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnRecomendPageIsOpened()

                .clickAskExpertLink()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnRecomendPageIsOpened()

                .navigateToLawBasePage()
                .navigateToRecomendPage()
                .clickNewsPageLink()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnRecomendPageIsOpened()

                .logout();
    }

    private void fss_336_test() {
        loginFss()
                .clickProfileLink()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnSolutionsPageIsOpened()

                .openDocumentByModuleIdAndDocId(DOC_URL_FSS)
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnSolutionsPageIsOpened()

                .navigateToLawBasePage()
                .navigateToSolutionsPage()
                .clicNewsPageLink()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnSolutionsPageIsOpened()

                .logout();
    }
}
