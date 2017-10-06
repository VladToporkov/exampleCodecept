package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;

/**
 * Created by Shman4ik on 28.01.2015.
 */

public class OSS_337_VerifyErrataInSearchQuery extends AbstractDomainTest {

    private static final String QUERYFALSE = "зокон";
    private static final String QUERYTRUE = "закон";

    private static final String QUERYFALSE2 = "yfkjujdsq rjltrc";
    private static final String QUERYTRUE2 = "налоговый кодекс";

    private static final String QUERYFALSE3 = "dhblyst eckfdbz трода";
    private static final String QUERYTRUE3 = "вредные условия труда";

    @Test(groups = {inDevelopment})
    @TestLink(testCaseId = "OSS-337", testCaseVersion = "1")
    public void oss_337_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Исправление опечаток КСС КУ");
        kss_337_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Исправление опечаток КСС БУ");
        kss_337_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Исправление опечаток КСС ВИП");
        kss_337_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Исправление опечаток БСС КУ");
        bss_337_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Исправление опечаток БСС ВИП");
        bss_337_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Исправление опечаток БСС УПР");
        bss_337_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Исправление опечаток БСС БУ");
        bss_337_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Исправление опечаток ЮСС КУ");
        uss_337_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Исправление опечаток ЮСС ДОК");
        uss_337_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Исправление опечаток ФСС КУ");
        fss_337_test();
    }

    private void kss_337_test() {
        loginKss()
                .navigateToAnswersPage()
                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE, QUERYFALSE)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE, QUERYFALSE)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE, QUERYFALSE)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE, QUERYFALSE)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE, QUERYFALSE)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE, QUERYFALSE)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()


                //3-4 шаг
                .navigateToAnswersPage()
                .inputTextInSearchBox(QUERYFALSE2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkKeyboardLayoutInSearchQuery(QUERYTRUE2, QUERYFALSE2)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERYFALSE2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkKeyboardLayoutInSearchQuery(QUERYTRUE2, QUERYFALSE2)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERYFALSE2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkKeyboardLayoutInSearchQuery(QUERYTRUE2, QUERYFALSE2)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERYFALSE2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkKeyboardLayoutInSearchQuery(QUERYTRUE2, QUERYFALSE2)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERYFALSE2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkKeyboardLayoutInSearchQuery(QUERYTRUE2, QUERYFALSE2)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERYFALSE2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkKeyboardLayoutInSearchQuery(QUERYTRUE2, QUERYFALSE2)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                //5 шаг
                .navigateToAnswersPage()
                .inputTextInSearchBox(QUERYFALSE3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE3, QUERYFALSE3)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERYFALSE3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE3, QUERYFALSE3)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERYFALSE3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE3, QUERYFALSE3)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERYFALSE3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE3, QUERYFALSE3)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERYFALSE3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE3, QUERYFALSE3)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERYFALSE3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE3, QUERYFALSE3)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()
                //шаг 6
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERYFALSE3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQueryAndFilter(QUERYTRUE3, QUERYFALSE3)
                //шаг 7
                .checkErrataInSearchQuerySwitchSection(QUERYTRUE3, QUERYFALSE3)
                //шаг 8
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .logout();
    }

    private void bss_337_test() {
        loginBss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE, QUERYFALSE)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE, QUERYFALSE)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE, QUERYFALSE)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE, QUERYFALSE)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE, QUERYFALSE)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE, QUERYFALSE)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()


                //3-4 шаг
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERYFALSE2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkKeyboardLayoutInSearchQuery(QUERYTRUE2, QUERYFALSE2)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERYFALSE2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkKeyboardLayoutInSearchQuery(QUERYTRUE2, QUERYFALSE2)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERYFALSE2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkKeyboardLayoutInSearchQuery(QUERYTRUE2, QUERYFALSE2)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERYFALSE2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkKeyboardLayoutInSearchQuery(QUERYTRUE2, QUERYFALSE2)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERYFALSE2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkKeyboardLayoutInSearchQuery(QUERYTRUE2, QUERYFALSE2)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERYFALSE2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkKeyboardLayoutInSearchQuery(QUERYTRUE2, QUERYFALSE2)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                //5 шаг
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERYFALSE3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE3, QUERYFALSE3)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERYFALSE3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE3, QUERYFALSE3)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERYFALSE3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE3, QUERYFALSE3)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERYFALSE3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE3, QUERYFALSE3)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERYFALSE3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE3, QUERYFALSE3)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERYFALSE3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE3, QUERYFALSE3)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()
                //шаг 6
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERYFALSE3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQueryAndFilter(QUERYTRUE3, QUERYFALSE3)
                //шаг 7
                .checkErrataInSearchQuerySwitchSection(QUERYTRUE3, QUERYFALSE3)
                //шаг 8
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .logout();
    }

    private void uss_337_test() {
        loginUss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE, QUERYFALSE)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE, QUERYFALSE)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE, QUERYFALSE)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE, QUERYFALSE)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE, QUERYFALSE)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE, QUERYFALSE)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()


                //3-4 шаг
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERYFALSE2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkKeyboardLayoutInSearchQuery(QUERYTRUE2, QUERYFALSE2)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERYFALSE2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkKeyboardLayoutInSearchQuery(QUERYTRUE2, QUERYFALSE2)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERYFALSE2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkKeyboardLayoutInSearchQuery(QUERYTRUE2, QUERYFALSE2)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERYFALSE2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkKeyboardLayoutInSearchQuery(QUERYTRUE2, QUERYFALSE2)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERYFALSE2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkKeyboardLayoutInSearchQuery(QUERYTRUE2, QUERYFALSE2)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERYFALSE2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkKeyboardLayoutInSearchQuery(QUERYTRUE2, QUERYFALSE2)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                //5 шаг
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERYFALSE3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE3, QUERYFALSE3)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERYFALSE3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE3, QUERYFALSE3)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERYFALSE3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE3, QUERYFALSE3)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERYFALSE3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE3, QUERYFALSE3)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERYFALSE3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE3, QUERYFALSE3)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERYFALSE3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE3, QUERYFALSE3)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()
                //шаг 6
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERYFALSE3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQueryAndFilter(QUERYTRUE3, QUERYFALSE3)
                //шаг 7
                .checkErrataInSearchQuerySwitchSection(QUERYTRUE3, QUERYFALSE3)
                //шаг 8
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .logout();
    }

    private void fss_337_test() {
        loginFss()
                .navigateToSolutionsPage()
                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE, QUERYFALSE)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE, QUERYFALSE)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE, QUERYFALSE)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE, QUERYFALSE)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE, QUERYFALSE)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE, QUERYFALSE)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()


                //3-4 шаг
                .navigateToSolutionsPage()
                .inputTextInSearchBox(QUERYFALSE2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkKeyboardLayoutInSearchQuery(QUERYTRUE2, QUERYFALSE2)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERYFALSE2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkKeyboardLayoutInSearchQuery(QUERYTRUE2, QUERYFALSE2)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERYFALSE2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkKeyboardLayoutInSearchQuery(QUERYTRUE2, QUERYFALSE2)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERYFALSE2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkKeyboardLayoutInSearchQuery(QUERYTRUE2, QUERYFALSE2)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERYFALSE2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkKeyboardLayoutInSearchQuery(QUERYTRUE2, QUERYFALSE2)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERYFALSE2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkKeyboardLayoutInSearchQuery(QUERYTRUE2, QUERYFALSE2)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                //5 шаг
                .navigateToSolutionsPage()
                .inputTextInSearchBox(QUERYFALSE3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE3, QUERYFALSE3)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERYFALSE3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE3, QUERYFALSE3)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERYFALSE3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE3, QUERYFALSE3)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERYFALSE3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE3, QUERYFALSE3)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERYFALSE3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE3, QUERYFALSE3)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERYFALSE3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(QUERYTRUE3, QUERYFALSE3)
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()
                //шаг 6
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERYFALSE3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQueryAndFilter(QUERYTRUE3, QUERYFALSE3)
                //шаг 7
                .checkErrataInSearchQuerySwitchSection(QUERYTRUE3, QUERYFALSE3)
                //шаг 8
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()

                .logout();
    }
}
