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
public class OSS_985_VerifyRssKss extends AbstractDomainTest {

    @Test(groups = {regression})
    @FireFoxOnly
    @TestLink(testCaseId = "OSS-985", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void oss_985_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        loginKss()
                .openByPartialUrl("update.rss?tab=1")
                .checkRSSTitle("Ответы КСС «Система Кадры» для коммерческих организаций")
                .kssCheckLogoIsPresent()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=2")
                .checkRSSTitle("Справочник КСС «Система Кадры» для коммерческих организаций")
                .kssCheckLogoIsPresent()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=3")
                .checkRSSTitle("Правовая база КСС «Система Кадры» для коммерческих организаций")
                .kssCheckLogoIsPresent()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=5")
                .checkRSSTitle("Журналы и книги КСС «Система Кадры» для коммерческих организаций")
                .kssCheckLogoIsPresent()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=7")
                .checkRSSTitle("Формы КСС «Система Кадры» для коммерческих организаций")
                .kssCheckLogoIsPresent()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=8")
                .checkRSSTitle("Видео КСС «Система Кадры» для коммерческих организаций")
                .kssCheckLogoIsPresent()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=9")
                .checkRSSTitle("Сервисы КСС «Система Кадры» для коммерческих организаций")
                .kssCheckLogoIsPresent()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=10")
                .checkRSSTitle("Новости КСС «Система Кадры» для коммерческих организаций")
                .kssCheckLogoIsPresent()
                .ossCheckLinksRSS()
                .openByPartialUrl("")
                .logout();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        loginKss()
                .openByPartialUrl("update.rss?tab=1")
                .checkRSSTitle("Ответы КСС «Система Кадры» VIP для коммерческих организаций")
                .kssCheckLogoIsPresent()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=2")
                .checkRSSTitle("Справочник КСС «Система Кадры» VIP для коммерческих организаций")
                .kssCheckLogoIsPresent()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=3")
                .checkRSSTitle("Правовая база КСС «Система Кадры» VIP для коммерческих организаций")
                .kssCheckLogoIsPresent()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=5")
                .checkRSSTitle("Журналы и книги КСС «Система Кадры» VIP для коммерческих организаций")
                .kssCheckLogoIsPresent()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=7")
                .checkRSSTitle("Формы КСС «Система Кадры» VIP для коммерческих организаций")
                .kssCheckLogoIsPresent()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=8")
                .checkRSSTitle("Видео КСС «Система Кадры» VIP для коммерческих организаций")
                .kssCheckLogoIsPresent()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=9")
                .checkRSSTitle("Сервисы КСС «Система Кадры» VIP для коммерческих организаций")
                .kssCheckLogoIsPresent()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=10")
                .checkRSSTitle("Новости КСС «Система Кадры» VIP для коммерческих организаций")
                .kssCheckLogoIsPresent()
                .ossCheckLinksRSS()
                .openByPartialUrl("")
                .logout();

        //для бюджетных учреждений
        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        loginKss()
                .openByPartialUrl("update.rss?tab=1")
                .checkRSSTitle("Ответы КСС «Система Кадры» для бюджетных учреждений")
                .kssCheckLogoIsPresent()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=2")
                .checkRSSTitle("Справочник КСС «Система Кадры» для бюджетных учреждений")
                .kssCheckLogoIsPresent()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=3")
                .checkRSSTitle("Правовая база КСС «Система Кадры» для бюджетных учреждений")
                .kssCheckLogoIsPresent()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=5")
                .checkRSSTitle("Журналы и книги КСС «Система Кадры» для бюджетных учреждений")
                .kssCheckLogoIsPresent()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=7")
                .checkRSSTitle("Формы КСС «Система Кадры» для бюджетных учреждений")
                .kssCheckLogoIsPresent()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=8")
                .checkRSSTitle("Видео КСС «Система Кадры» для бюджетных учреждений")
                .kssCheckLogoIsPresent()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=9")
                .checkRSSTitle("Сервисы КСС «Система Кадры» для бюджетных учреждений")
                .kssCheckLogoIsPresent()
                .ossCheckLinksRSS()

                .openByPartialUrl("update.rss?tab=10")
                .checkRSSTitle("Новости КСС «Система Кадры» для бюджетных учреждений")
                .kssCheckLogoIsPresent()
                .ossCheckLinksRSS()
                .openByPartialUrl("")
                .logout();
    }
}
