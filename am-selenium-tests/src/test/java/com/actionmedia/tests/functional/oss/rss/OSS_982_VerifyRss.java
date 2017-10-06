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
 * Date: 21.12.15
 */
public class OSS_982_VerifyRss extends AbstractDomainTest {

    @Test(groups = {regression})
    @FireFoxOnly
    @TestLink(testCaseId = "OSS-982", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void oss_982_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        loginUss()
                .openByPartialUrl("update.rss?tab=1")
                .checkRSSTitle("Рекомендации ЮСС «Система Юрист»")
                .checkLogoIsPresentOnRssPage()
                .checkLinksRSS(1)

                .openByPartialUrl("update.rss?tab=2")
                .checkRSSTitle("Справочник ЮСС «Система Юрист»")
                .checkLogoIsPresentOnRssPage()
                .checkLinksRSS(2)

                .openByPartialUrl("update.rss?tab=3")
                .checkRSSTitle("Правовая база ЮСС «Система Юрист»")
                .checkLogoIsPresentOnRssPage()
                .checkLinksRSS(3)

                .openByPartialUrl("update.rss?tab=5")
                .checkRSSTitle("Журналы и книги ЮСС «Система Юрист»")
                .checkLogoIsPresentOnRssPage()
                .checkLinksRSS(5)

                .openByPartialUrl("update.rss?tab=7")
                .checkRSSTitle("Формы ЮСС «Система Юрист»")
                .checkLogoIsPresentOnRssPage()
                .checkLinksRSS(7)

                .openByPartialUrl("update.rss?tab=8")
                .checkRSSTitle("Видео ЮСС «Система Юрист»")
                .checkLogoIsPresentOnRssPage()
                .checkLinksRSS(8)

                .openByPartialUrl("update.rss?tab=9")
                .checkRSSTitle("Сервисы ЮСС «Система Юрист»")
                .checkLogoIsPresentOnRssPage()
                .checkLinksRSS(9)

                .openByPartialUrl("update.rss?tab=10")
                .checkRSSTitle("Новости ЮСС «Система Юрист»")
                .checkLogoIsPresentOnRssPage()
                .checkLinksRSS(10)
                .logout();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        loginUss()
                .openByPartialUrl("update.rss?tab=1")
                .checkRSSTitle("Рекомендации ЮСС «Система Юрист» с Конструктором договоров")
                .checkLogoIsPresentOnRssPage()
                .checkLinksRSS(1)

                .openByPartialUrl("update.rss?tab=2")
                .checkRSSTitle("Справочник ЮСС «Система Юрист» с Конструктором договоров")
                .checkLogoIsPresentOnRssPage()
                .checkLinksRSS(2)

                .openByPartialUrl("update.rss?tab=3")
                .checkRSSTitle("Правовая база ЮСС «Система Юрист» с Конструктором договоров")
                .checkLogoIsPresentOnRssPage()
                .checkLinksRSS(3)

                .openByPartialUrl("update.rss?tab=5")
                .checkRSSTitle("Журналы и книги ЮСС «Система Юрист» с Конструктором договоров")
                .checkLogoIsPresentOnRssPage()
                .checkLinksRSS(5)

                .openByPartialUrl("update.rss?tab=7")
                .checkRSSTitle("Формы ЮСС «Система Юрист» с Конструктором договоров")
                .checkLogoIsPresentOnRssPage()
                .checkLinksRSS(7)

                .openByPartialUrl("update.rss?tab=8")
                .checkRSSTitle("Видео ЮСС «Система Юрист» с Конструктором договоров")
                .checkLogoIsPresentOnRssPage()
                .checkLinksRSS(8)

                .openByPartialUrl("update.rss?tab=9")
                .checkRSSTitle("Сервисы ЮСС «Система Юрист» с Конструктором договоров")
                .checkLogoIsPresentOnRssPage()
                .checkLinksRSS(9)

                .openByPartialUrl("update.rss?tab=10")
                .checkRSSTitle("Новости ЮСС «Система Юрист» с Конструктором договоров")
                .checkLogoIsPresentOnRssPage()
                .checkLinksRSS(10)
                .logout();
    }
}




