package com.actionmedia.tests.functional.oss.rss;

import com.actionmedia.autotest.annotations.FireFoxOnly;
import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by n.minochkina on 25.12.2015.
 */
public class OSS_984_VerifyRssBss extends AbstractDomainTest {

    @Test(groups = {regression})
    @FireFoxOnly
    @TestLink(testCaseId = "OSS-984", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void oss_984_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        loginBss()
                .openByPartialUrl("update.rss?tab=1")
                .checkRSSTitle("Рекомендации БСС «Система Главбух» для коммерческих организаций")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=2")
                .checkRSSTitle("Справочники БСС «Система Главбух» для коммерческих организаций")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=3")
                .checkRSSTitle("Правовая база БСС «Система Главбух» для коммерческих организаций")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=5")
                .checkRSSTitle("Журналы БСС «Система Главбух» для коммерческих организаций")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=7")
                .checkRSSTitle("Формы БСС «Система Главбух» для коммерческих организаций")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=8")
                .checkRSSTitle("Видео БСС «Система Главбух» для коммерческих организаций")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=10")
                .checkRSSTitle("Новости БСС «Система Главбух» для коммерческих организаций")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()
                .openByPartialUrl("")
                .logout();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        loginBss()
                .openByPartialUrl("update.rss?tab=1")
                .checkRSSTitle("Рекомендации БСС «Система Главбух» ВИП для коммерческих организаций")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=2")
                .checkRSSTitle("Справочники БСС «Система Главбух» ВИП для коммерческих организаций")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=3")
                .checkRSSTitle("Правовая база БСС «Система Главбух» ВИП для коммерческих организаций")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=5")
                .checkRSSTitle("Журналы БСС «Система Главбух» ВИП для коммерческих организаций")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=7")
                .checkRSSTitle("Формы БСС «Система Главбух» ВИП для коммерческих организаций")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=8")
                .checkRSSTitle("Видео БСС «Система Главбух» ВИП для коммерческих организаций")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=10")
                .checkRSSTitle("Новости БСС «Система Главбух» ВИП для коммерческих организаций")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()
                .openByPartialUrl("")
                .logout();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        loginBss()
                .openByPartialUrl("update.rss?tab=1")
                .checkRSSTitle("Рекомендации БСС «Система Главбух» для упрощенки")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=2")
                .checkRSSTitle("Справочники БСС «Система Главбух» для упрощенки")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=3")
                .checkRSSTitle("Правовая база БСС «Система Главбух» для упрощенки")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=5")
                .checkRSSTitle("Журналы БСС «Система Главбух» для упрощенки")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=7")
                .checkRSSTitle("Формы БСС «Система Главбух» для упрощенки")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=8")
                .checkRSSTitle("Видео БСС «Система Главбух» для упрощенки")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=10")
                .checkRSSTitle("Новости БСС «Система Главбух» для упрощенки")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()
                .openByPartialUrl("")
                .logout();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        loginBss()
                .openByPartialUrl("update.rss?tab=1")
                .checkRSSTitle("Рекомендации БСС «Система Главбух» для бюджетных учреждений")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=2")
                .checkRSSTitle("Справочники БСС «Система Главбух» для бюджетных учреждений")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=3")
                .checkRSSTitle("Правовая база БСС «Система Главбух» для бюджетных учреждений")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=5")
                .checkRSSTitle("Журналы БСС «Система Главбух» для бюджетных учреждений")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=7")
                .checkRSSTitle("Формы БСС «Система Главбух» для бюджетных учреждений")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=8")
                .checkRSSTitle("Видео БСС «Система Главбух» для бюджетных учреждений")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=10")
                .checkRSSTitle("Новости БСС «Система Главбух» для бюджетных учреждений")
                .checkLogoIsPresentOnRssPage()
                .ossCheckLinksRSS()
                .openByPartialUrl("")
                .logout();
    }
}
