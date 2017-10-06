package com.actionmedia.tests.functional.oss.law;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.helpers.SearchResultHelper;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Shman4ik on 29.12.2014.
 */
public class OSS_267_LegislationBlock extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-267", testCaseVersion = "1")
    public void oss_267_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется блок 'Важные документы' раздел Правовая база КСС КУ");
        kss_267_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется блок 'Важные документы' раздел Правовая база КСС БУ");
        kss_267_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется блок 'Важные документы' раздел Правовая база КСС ВИП");
        kss_267_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется блок 'Важные документы' раздел Правовая база БСС КУ");
        bss_267_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется блок 'Важные документы' раздел Правовая база БСС ВИП");
        bss_267_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется блок 'Важные документы' раздел Правовая база БСС УПР");
        bss_267_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется блок 'Важные документы' раздел Правовая база БСС БУ");
        bss_267_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется блок 'Важные документы' раздел Правовая база ЮСС КУ");
        uss_267_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется блок 'Важные документы' раздел Правовая база ЮСС ДОК");
        uss_267_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется блок 'Важные документы' раздел Правовая база ФСС КУ");
        fss_267_test();
    }

    private void kss_267_test() {
        loginKss()
                .navigateToLawBasePage()
                .checkLegislationBlockIsPresent("Важное")
                .checkLegislationBlockLinksDisplayed()
                .checkSearchBoxPresentLegislation("Поиск документов")

                .inputTextInSearchBoxOnLegislationBlock("1")
                .checkHintsIsPresentOnLegislationBlock()

                .clickHintOnLegislationBlock()
                .checkSearchQuery((String) getParameter(SearchResultHelper.HINT_TEXT))

                .navigateToLawBasePage()
                .inputTextInSearchBoxOnLegislationBlock("1")
                .clickSearchButtonOnLegislationBlock()
                .checkSearchQuery("1")

                .navigateToLawBasePage()
                .checkLegislationBlockLinks()

                .logout();
    }

    private void bss_267_test() {
        loginBss()
                .navigateToLawBasePage()
                .checkLegislationBlockIsPresent("Важные документы")
                .checkLegislationBlockLinksDisplayed()
                .checkSearchBoxPresentLegislation("Поиск документов")

                .inputTextInSearchBoxOnLegislationBlock("1")
                .checkHintsIsPresentOnLegislationBlock()

                .clickHintOnLegislationBlock()
                .checkSearchQuery((String) getParameter(SearchResultHelper.HINT_TEXT))

                .navigateToLawBasePage()
                .inputTextInSearchBoxOnLegislationBlock("1")
                .clickSearchButtonOnLegislationBlock()
                .checkSearchQuery("1")

                .navigateToLawBasePage()
                .checkLegislationBlockLinks()

                .logout();
    }

    private void uss_267_test() {
        loginUss()
                .navigateToLawBasePage()
                .checkLegislationBlockIsPresent("Законы")
                .checkLegislationBlockLinksDisplayed()
                .checkSearchBoxPresentLegislation("Поиск законов")

                .inputTextInSearchBoxOnLegislationBlock("о")
                .checkHintsIsPresentOnLegislationBlock()

                .clickHintOnLegislationBlock()
                .checkSearchQuery((String) getParameter(SearchResultHelper.HINT_TEXT))

                .navigateToLawBasePage()
                .inputTextInSearchBoxOnLegislationBlock("1")
                .clickSearchButtonOnLegislationBlock()
                .checkSearchQuery("1")

                .navigateToLawBasePage()
                .checkLegislationBlockLinks()

                .logout();
    }

    private void fss_267_test() {
        loginFss()
                .navigateToLawBasePage()
                .checkLegislationBlockIsPresent("Важные документы")
                .checkLegislationBlockLinksDisplayed()
                .checkSearchBoxPresentLegislation("Поиск документов")

                .inputTextInSearchBoxOnLegislationBlock("1")
                .checkHintsIsPresentOnLegislationBlock()

                .clickHintOnLegislationBlock()
                .checkSearchQuery((String) getParameter(SearchResultHelper.HINT_TEXT))

                .navigateToLawBasePage()
                .inputTextInSearchBoxOnLegislationBlock("1")
                .clickSearchButtonOnLegislationBlock()
                .checkSearchQuery("1")

                .navigateToLawBasePage()
                .checkLegislationBlockLinks()

                .logout();
    }
}
