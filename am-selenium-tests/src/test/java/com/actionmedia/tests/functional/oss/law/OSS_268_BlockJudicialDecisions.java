package com.actionmedia.tests.functional.oss.law;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Shman4ik on 17.12.2014.
 */
public class OSS_268_BlockJudicialDecisions extends AbstractDomainTest {

    public static final String QUERY = "«Пленум Верховного суда РФ», «Пленум Высшего арбитражного суда РФ», «Президиум Высшего арбитражного суда РФ», «Суд по интеллектуальным правам», «Верховный и ВАС», «Окружные суды», «Апелляционные суды»";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-268", testCaseVersion = "1")
    public void oss_268_test() {

        // KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется блок блок 'Судебные решения' раздел Правовая база КСС КУ");
        kss_268_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется блок блок 'Судебные решения' раздел Правовая база КСС БУ");
        kss_268_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется блок блок 'Судебные решения' раздел Правовая база КСС ВИП");
        kss_268_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется блок блок 'Судебные решения' раздел Правовая база БСС КУ");
        bss_268_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется блок блок 'Судебные решения' раздел Правовая база БСС ВИП");
        bss_268_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется блок блок 'Судебные решения' раздел Правовая база БСС УПР");
        bss_268_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется блок блок 'Судебные решения' раздел Правовая база БСС БУ");
        bss_268_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется блок блок 'Судебные решения' раздел Правовая база ЮСС КУ");
        uss_268_test();
        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется блок блок 'Судебные решения' раздел Правовая база ЮСС ДОК");
        uss_268_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется блок блок 'Судебные решения' раздел Правовая база ФСС КУ");
        fss_268_test();
    }

    private void fss_268_test() {
        loginFss()
                .navigateToLawBasePage()
                .checkJudgmentBlockIsPresent()
                .checkJudgmentBlockLinksDisplayed()
                .checkSearchBoxPresentJudgementCode()

                .inputTextInSearchBoxOnJudgmentBlock("1")
                .checkHintsIsNotPresentOnJudgmentBlock()

                .clickSearchButtonOnJudgmentBlock()
                .checkSearchResultOnLawBasePageIsOpened(false, "Решения судов")

                .navigateToLawBasePage()
                .checkJudgmentBlockLinks()

                .logout();
    }

    private void uss_268_test() {
        loginUss()
                .navigateToLawBasePage()
                .checkJudgmentBlockIsPresent()
                .checkJudgmentBlockLinksDisplayed()
                .checkSearchBoxPresentJudgementCode()

                .inputTextInSearchBoxOnJudgmentBlock("1")
                .checkHintsIsNotPresentOnJudgmentBlock()

                .clickSearchButtonOnJudgmentBlock()
                .checkSearchResultOnLawBasePageIsOpened(false, "Решения судов")

                .navigateToLawBasePage()
                .checkJudgmentBlockLinks()

                .logout();
    }

    private void bss_268_test() {
        loginBss()
                .navigateToLawBasePage()
                .checkJudgmentBlockIsPresent()
                .checkJudgmentBlockLinksDisplayed()
                .checkSearchBoxPresentJudgementCode()

                .inputTextInSearchBoxOnJudgmentBlock("1")
                .checkHintsIsNotPresentOnJudgmentBlock()

                .clickSearchButtonOnJudgmentBlock()
                .checkSearchResultOnLawBasePageIsOpened(false, "Решения судов")

                .navigateToLawBasePage()
                .checkJudgmentBlockLinks()

                .logout();
    }

    private void kss_268_test() {
        loginKss()
                .navigateToLawBasePage()
                .checkJudgmentBlockIsPresent()
                .checkJudgmentBlockLinksDisplayed()
                .checkSearchBoxPresentJudgementCode()

                .inputTextInSearchBoxOnJudgmentBlock("1")
                .checkHintsIsNotPresentOnJudgmentBlock()

                .clickSearchButtonOnJudgmentBlock()
                .checkSearchResultOnLawBasePageIsOpened(false, "Решения судов")

                .navigateToLawBasePage()
                .checkJudgmentBlockLinks()

                .logout();
    }
}
