package com.actionmedia.tests.functional.oss.promo;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by dShmanev on 12.03.2015.
 */
public class OSS_503_FastContents extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-503", testCaseVersion = "1")
    public void oss_503_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        report("Проверяется Быстрое оглавление Промо КСС КУ");
        kss_503_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Быстрое оглавление (Промо) БСС КУ");
        bss_503_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Быстрое оглавление (Промо) ЮСС КУ");
        uss_503_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Быстрое оглавление (Промо) ФСС КУ");
        fss_503_test();
    }

    public void kss_503_test() {
        getKssBasePage()
                .navigateToPromoPage()
                .checkScrollFastContents()
                .checkClickFastContents();

    }

    public void bss_503_test() {
        getBssBasePage()
                .navigateToPromoPage()
                .checkScrollFastContents()
                .checkClickFastContents();
    }

    public void uss_503_test() {
        getUssBasePage()
                .navigateToPromoPage()
                .checkScrollFastContents()
                .checkClickFastContents();
    }

    public void fss_503_test() {
        getFssBasePage()
                .navigateToPromoPage()
                .checkScrollFastContents()
                .checkClickFastContents();
    }
}
