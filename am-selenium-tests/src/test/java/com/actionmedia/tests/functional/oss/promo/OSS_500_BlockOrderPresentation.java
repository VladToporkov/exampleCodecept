package com.actionmedia.tests.functional.oss.promo;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;

/**
 * Created by dShmanev on 12.03.2015.
 */
public class OSS_500_BlockOrderPresentation extends AbstractDomainTest {

    @Test(groups = {inDevelopment})
    @TestLink(testCaseId = "OSS-500", testCaseVersion = "1")
    public void oss_500_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Блок 'Заказать презентацию' КСС КУ");
        kss_500_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Блок 'Заказать презентацию' БСС КУ");
        bss_500_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Блок 'Заказать презентацию' ЮСС КУ");
        uss_500_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Блок 'Заказать презентацию' ФСС КУ");
        fss_500_test();
    }

    private void kss_500_test() {
        getKssBasePage()
                .navigateToPromoPage()

                .clickPresentationPage()
                .checkDisplayPresentationForm()
                .checkSendingForm();
    }

    private void bss_500_test() {
        getBssBasePage()
                .navigateToPromoPage()

                .clickPresentationPage()
                .checkDisplayPresentationForm()
                .checkSendingForm();
    }

    private void uss_500_test() {
        getUssBasePage()
                .navigateToPromoPage()

                .clickPresentationPage()
                .checkDisplayPresentationForm()
                .checkSendingForm();
    }

    private void fss_500_test() {
        getFssBasePage()
                .navigateToPromoPage()

                .clickPresentationPage()
                .checkDisplayPresentationForm()
                .checkSendingForm();
    }
}
