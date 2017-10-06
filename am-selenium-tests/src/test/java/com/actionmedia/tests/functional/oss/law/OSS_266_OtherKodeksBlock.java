package com.actionmedia.tests.functional.oss.law;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Shman4ik on 23.12.2014.
 */
public class OSS_266_OtherKodeksBlock extends AbstractDomainTest {

    public static final String QUERY = "101";
    public static final String RESULT_TYPE = "Кодекс";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-266", testCaseVersion = "1")
    public void oss_266_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется блок 'Прочие кодексы' раздел Правовая база КСС КУ");
        kss_266_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется блок 'Прочие кодексы' раздел Правовая база КСС БУ");
        kss_266_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется блок 'Прочие кодексы' раздел Правовая база КСС ВИП");
        kss_266_test();

//        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется блок 'Прочие кодексы' раздел Правовая база БСС КУ");
        bss_266_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется блок 'Прочие кодексы' раздел Правовая база БСС ВИП");
        bss_266_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется блок 'Прочие кодексы' раздел Правовая база БСС УПР");
        bss_266_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется блок 'Прочие кодексы' раздел Правовая база БСС БУ");
        bss_266_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется блок 'Прочие кодексы' раздел Правовая база ЮСС КУ");
        uss_266_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется блок 'Прочие кодексы' раздел Правовая база ЮСС ДОК");
        uss_266_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется блок 'Прочие кодексы' раздел Правовая база ФСС КУ");
        fss_266_test();
    }


    private void kss_266_test() {
        loginKss()
                .navigateToLawBasePage()
                .checkOtherKodeksBlockIsPresent()
                .checkOtherKodeksBlockLinksDisplayed()
                .checkSearchBoxPresentOtherCode()

                .inputTextInSearchBoxOnOtherKodeksBlock(QUERY)
                .checkHintsIsPresentOnOtherKodeksBlock()
                .clickHintOnOtherBlock()
                .checkDocumentIsOpened()

                .navigateToLawBasePage()
                .inputTextInSearchBoxOnOtherKodeksBlock(QUERY)
                .clickSearchButtonOnOtherKodeksBlock()
                .checkSearchResultType(RESULT_TYPE)

                .navigateToLawBasePage()
                .checkOtherKodeksBlockLinks()

                .logout();
    }

    private void bss_266_test() {
        loginBss()
                .navigateToLawBasePage()
                .checkOtherKodeksBlockIsPresent()
                .checkOtherKodeksBlockLinksDisplayed()
                .checkSearchBoxPresentOtherCode()

                .inputTextInSearchBoxOnOtherKodeksBlock(QUERY)
                //.checkHintsIsPresentOnOtherKodeksBlock() TODO Доделать после обновления тест кейса
                .clickHintOnOtherBlock()
                .checkDocumentIsOpened()

                .navigateToLawBasePage()
                .inputTextInSearchBoxOnOtherKodeksBlock(QUERY)
                .clickSearchButtonOnOtherKodeksBlock()
                .checkSearchResultType(RESULT_TYPE)

                .navigateToLawBasePage()
                .checkOtherKodeksBlockLinks()

                .logout();
    }

    private void uss_266_test() {
        loginUss()
                .navigateToLawBasePage()
                .checkOtherKodeksBlockIsPresent()
                .checkOtherKodeksBlockLinksDisplayed()
                .checkSearchBoxPresentOtherCode()

                .inputTextInSearchBoxOnOtherKodeksBlock(QUERY)
                //.checkHintsIsPresentOnOtherKodeksBlock() TODO Доделать после обновления тест кейса
                .clickHintOnOtherBlock()
                .checkDocumentIsOpened()

                .navigateToLawBasePage()
                .inputTextInSearchBoxOnOtherKodeksBlock(QUERY)
                .clickSearchButtonOnOtherKodeksBlock()
                .checkSearchResultType(RESULT_TYPE)

                .navigateToLawBasePage()
                .checkOtherKodeksBlockLinks()

                .logout();
    }

    private void fss_266_test() {
        loginFss()
                .navigateToLawBasePage()
                .checkOtherKodeksBlockIsPresent()
                .checkOtherKodeksBlockLinksDisplayed()
                .checkSearchBoxPresentOtherCode()

                .inputTextInSearchBoxOnOtherKodeksBlock(QUERY)
                .checkHintsIsPresentOnOtherKodeksBlock()
                .clickHintOnOtherBlock()
                .checkDocumentIsOpened()

                .navigateToLawBasePage()
                .inputTextInSearchBoxOnOtherKodeksBlock(QUERY)
                .clickSearchButtonOnOtherKodeksBlock()
                .checkSearchResultType(RESULT_TYPE)

                .navigateToLawBasePage()
                .checkOtherKodeksBlockLinks()

                .logout();
    }
}
