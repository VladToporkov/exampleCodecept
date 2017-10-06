package com.actionmedia.tests.functional.bss.news;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 11.10.13
 * Time: 10:47
 */
public class BSS_58_VerifyRssDocument extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-58", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_ku_58_test() {
        report("Проверяется наличие новости по ссылке на RSS-обновления для БСС КУ");
        loginBss()
                .navigateToRecomendPage()
                .clickNewsPaperHeaderLink()
                .clickRssLink()
                .checkRssDocumentPageIsOpened("/document/184/390/")
                .checkRssDocumentIsNotEmpty()
                .logout();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется наличие новости по ссылке на RSS-обновления для БСС ВИП");
        loginBss()
                .navigateToRecomendPage()
                .clickNewsPaperHeaderLink()
                .clickRssLink()
                .checkRssDocumentPageIsOpened("/document/184/393/")
                .checkRssDocumentIsNotEmpty()
                .logout();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется наличие новости по ссылке на RSS-обновления для БСС УПР");
        loginBss()
                .navigateToRecomendPage()
                .clickNewsPaperHeaderLink()
                .clickRssLink()
                .checkRssDocumentPageIsOpened("/document/184/392/")
                .checkRssDocumentIsNotEmpty()
                .logout();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется наличие новости по ссылке на RSS-обновления для БСС БУ");
        loginBss()
                .navigateToRecomendPage()
                .clickNewsPaperHeaderLink()
                .clickRssLink()
                .checkRssDocumentPageIsOpened("/document/184/391/")
                .checkRssDocumentIsNotEmpty()
                .logout();
    }
}
