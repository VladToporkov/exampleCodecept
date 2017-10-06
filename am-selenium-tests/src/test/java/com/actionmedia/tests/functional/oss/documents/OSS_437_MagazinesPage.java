package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel on 26/04/16.
 */
public class OSS_437_MagazinesPage extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-437", testCaseVersion = "6")
    public void oss_437_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Общее отображение раздела Журналы КСС КУ");
        kssTest();

        updateLoginToInfo("budget");
        updateLoginAsInfo("kss.user.budget");
        report("Проверяется Общее отображение раздела Журналы КСС БУ");
        kssTestBu();

        updateLoginToInfo("vip");
        updateLoginAsInfo("kss.user.vip");
        report("Проверяется Общее отображение раздела Журналы КСС ВИП");
        kssTestVip();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Общее отображение раздела Журналы ЮСС КУ");
        ussTest();

        updateLoginToInfo("budget");
        updateLoginAsInfo("uss.user.budget");
        report("Проверяется Общее отображение раздела Журналы ЮСС БУ");
        ussTest();
    }

    private void kssTest() {
        loginKss()
                .navigateToMagazinesPage()
                .checkNewInMagazinesShelfIsPresent()
                .checkBooksBlockIsPresent()
                .checkMagazinesShelvesArePresent()
                .checkMagazineHasShelf("Кадровое дело")
                .checkMagazineHasShelf("Тематическое приложение к журналу «Кадровое дело»")
                .checkMagazineHasShelf("Справочник кадровика")
                .checkMagazineHasShelf("Директор по персоналу")
                .checkMagazineHasShelf("Трудовые споры")
                .checkMagazineHasShelf("Зарплата")
                .checkMagazineHasShelf("Справочник специалиста по охране труда")
                .checkMagazineHasShelf("Охрана труда")
                .checkMagazineHasShelf("Охрана труда в вопросах и ответах")
                .checkMagazineHasShelf("Справочник секретаря и офис-менеджера")

                .checkMagazinesRubricatorButtonIsPresent()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAssistantButtonIsPresent()
                .logout();
    }

    private void kssTestBu() {
        loginKss()
                .navigateToMagazinesPage()
                .checkNewInMagazinesShelfIsPresent()
                .checkBooksBlockIsPresent()
                .checkMagazinesShelvesArePresent()
                .checkMagazineHasShelf("Кадровое дело")
                .checkMagazineHasShelf("Тематическое приложение к журналу «Кадровое дело»")
                .checkMagazineHasShelf("Справочник кадровика")
                .checkMagazineHasShelf("Директор по персоналу")
                .checkMagazineHasShelf("Трудовые споры")
                .checkMagazineHasShelf("Зарплата в учреждении")
                .checkMagazineHasShelf("Справочник специалиста по охране труда")
                .checkMagazineHasShelf("Охрана труда")
                .checkMagazineHasShelf("Охрана труда в вопросах и ответах")
                .checkMagazineHasShelf("Справочник секретаря и офис-менеджера")

                .checkMagazinesRubricatorButtonIsPresent()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAssistantButtonIsPresent()
                .logout();
    }

    private void kssTestVip() {
        loginKss()
                .navigateToMagazinesPage()
                .checkNewInMagazinesShelfIsPresent()
                .checkBooksBlockIsPresent()
                .checkMagazinesShelvesArePresent()
                .checkMagazineHasShelf("Кадровое дело")
                .checkMagazineHasShelf("Тематическое приложение к журналу «Кадровое дело»")
                .checkMagazineHasShelf("Справочник кадровика")
                .checkMagazineHasShelf("Директор по персоналу")
                .checkMagazineHasShelf("Трудовые споры")
                .checkMagazineHasShelf("Генеральный директор")
                .checkMagazineHasShelf("Зарплата")
                .checkMagazineHasShelf("Справочник специалиста по охране труда")
                .checkMagazineHasShelf("Охрана труда")
                .checkMagazineHasShelf("Охрана труда в вопросах и ответах")
                .checkMagazineHasShelf("Справочник секретаря и офис-менеджера")

                .checkMagazinesRubricatorButtonIsPresent()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAssistantButtonIsPresent()
                .logout();
    }

    private void ussTest() {
        loginUss()
                .navigateToMagazinesPage()
                .checkNewInMagazinesShelfIsPresent()
                .checkBooksBlockIsPresent()
                .checkMagazinesShelvesArePresent()
                .checkMagazineHasShelf("Юрист компании")
                .checkMagazineHasShelf("Арбитражная практика")
                .checkMagazineHasShelf("Коммерческое право")
                .checkMagazineHasShelf("Трудовые споры")
                .checkMagazineHasShelf("Госзакупки")
                .checkMagazineHasShelf("Уголовный процесс")
                .checkMagazineHasShelf("Налоговед")
                .checkMagazineHasShelf("Арбитражная налоговая практика")

                .checkMagazinesRubricatorButtonIsPresent()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAssistantButtonIsPresent()
                .logout();
    }
}
