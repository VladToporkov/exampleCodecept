package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 11.01.16
 * Time: 20:47
 */
public class OSS_446_VerifyMobileReadDocument extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-446", testCaseVersion = "1")
    public void oss_446_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Мобильное чтение на Айфон БСС КУ");
        oss_446_bss_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Мобильное чтение на Айфон ЮСС КУ");
        oss_446_uss_test();
    }

    private void oss_446_bss_test() {
        loginBss()
                .navigateToMagazinesPage()
                .checkMobileReadButtonIsPresent()
                .checkMobileReadIconIsPresent()
                .checkMobileReadButtonTooltip()

                .clickMobileReadButton()
                .checkDocumentIsNotEmpty()
                .checkDocumentContainsText("Читайте наши журналы на мобильных устройствах!")
                .checkCurrentUrlContainsDocumentUrl("/document/184/182/")

                .logout();
    }

    private void oss_446_uss_test() {
        loginUss()
                .navigateToMagazinesPage()
                .checkMobileReadButtonIsPresent()
                .checkMobileReadIconIsPresent()
                .checkMobileReadButtonTooltip()

                .clickMobileReadButton()
                .checkDocumentIsNotEmpty()
                .checkDocumentContainsText("Смотрите полную правовую базу и читайте наши журналы на мобильных устройствах!")
                .checkCurrentUrlContainsDocumentUrl("/document/184/1395/")

                .logout();
    }
}