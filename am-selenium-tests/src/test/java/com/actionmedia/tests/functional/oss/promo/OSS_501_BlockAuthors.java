package com.actionmedia.tests.functional.oss.promo;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by dShmanev on 12.03.2015.
 */
public class OSS_501_BlockAuthors extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-501", testCaseVersion = "1")
    public void oss_501_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Блок 'Авторы' КСС КУ");
        kss_501_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Блок 'Авторы' БСС КУ");
        bss_501_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Блок 'Авторы' ЮСС КУ");
        uss_501_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Блок 'Авторы' ФСС КУ");
        fss_501_test();
    }

    public void kss_501_test() {
        getKssBasePage()
                .navigateToPromoPage()

                .clickAuthorPage()
                .checkDisplayAuthor()
                .checkDisplayTextAuthor();

    }

    public void bss_501_test() {
        getBssBasePage()
                .navigateToPromoPage()

                .clickAuthorPage()
                .checkDisplayAuthor()
                .checkDisplayTextAuthor();
    }

    public void uss_501_test() {
        getUssBasePage()
                .navigateToPromoPage()

                .clickAuthorPage()
                .checkDisplayAuthor()
                .checkDisplayTextAuthor();
    }

    public void fss_501_test() {
        getFssBasePage()
                .navigateToPromoPage()

                .clickAuthorPage()
                .checkDisplayAuthor()
                .checkDisplayTextAuthor();
    }
}
