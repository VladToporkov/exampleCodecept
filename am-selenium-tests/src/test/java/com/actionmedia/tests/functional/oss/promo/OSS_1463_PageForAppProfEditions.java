package com.actionmedia.tests.functional.oss.promo;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 12/01/16.
 */
public class OSS_1463_PageForAppProfEditions extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1463", testCaseVersion = "1")
    public void oss_1463_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Страница для приложения Профиздания (Промо) БСС КУ");
        bss_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Страница для приложения Профиздания (Промо) ЮСС КУ");
        uss_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Страница для приложения Профиздания (Промо) ФСС КУ");
        fss_test();
    }


    public void bss_test() {
        getBssBasePage()
                .checkProfEditionsPage();
    }

    public void uss_test() {
        getUssBasePage()
                .checkProfEditionsPage();
    }

    public void fss_test() {
        getFssBasePage()
                .checkProfEditionsPage();
    }
}
