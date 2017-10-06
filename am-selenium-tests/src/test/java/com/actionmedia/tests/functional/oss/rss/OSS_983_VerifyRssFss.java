package com.actionmedia.tests.functional.oss.rss;

import com.actionmedia.autotest.annotations.FireFoxOnly;
import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.leontieva
 * Date: 24.12.15
 */
public class OSS_983_VerifyRssFss extends AbstractDomainTest  {

    @Test(groups = {regression})
    @FireFoxOnly
    @TestLink(testCaseId = "OSS-983", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void oss_983_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        loginFss()
                .openByPartialUrl("update.rss?tab=1")
                .checkRSSTitle("Решения ФСС «Система Финансовый директор»")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=2")
                .checkRSSTitle("Справочник ФСС «Система Финансовый директор»")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=3")
                .checkRSSTitle("Правовая база ФСС «Система Финансовый директор»")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=5")
                .checkRSSTitle("Библиотека ФСС «Система Финансовый директор»")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=7")
                .checkRSSTitle("Положения и регламенты ФСС «Система Финансовый директор»")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=8")
                .checkRSSTitle("Видео ФСС «Система Финансовый директор»")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=10")
                .checkRSSTitle("Новости ФСС «Система Финансовый директор»")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()
                .openByPartialUrl("")
                .logout();
    }
}
