package com.actionmedia.tests.functional.oss.promo;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by dShmanev on 13.03.2015.
 */
public class OSS_504_BlockOpinions extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-504", testCaseVersion = "1")
    public void oss_504_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Блок 'Мнения' КСС КУ");
        kss_504_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Блок 'Мнения' БСС КУ");
        bss_504_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Блок 'Мнения' ЮСС КУ");
        uss_504_test();
    }

    public void kss_504_test() {
        getKssBasePage()
                .navigateToPromoPage()

                .clickOpinionsPage()
                .checkBlockOpinions();
    }

    public void bss_504_test() {
        getBssBasePage()
                .navigateToPromoPage()

                .clickOpinionsPage()
                .checkBlockOpinions();
    }

    public void uss_504_test() {
        getUssBasePage()
                .navigateToPromoPage()

                .clickOpinionsPage()
                .checkBlockOpinions();
    }
}
