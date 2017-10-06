package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 25/08/16.
 */
public class OSS_141_MagazinesShelf extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-141", testCaseVersion = "1")
    public void oss_141_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Общее отображение раздела Журналы БСС КУ");
        bssTest();

        updateLoginToInfo("budget");
        updateLoginAsInfo("bss.user.budget");
        report("Проверяется Общее отображение раздела Журналы БСС БУ");
        bssTestBu();

        updateLoginToInfo("vip");
        updateLoginAsInfo("bss.user.vip");
        report("Проверяется Общее отображение раздела Журналы БСС ВИП");
        bssTestUsn();

        updateLoginToInfo("vip");
        updateLoginAsInfo("bss.user.vip");
        report("Проверяется Общее отображение раздела Журналы БСС ВИП");
        bssTestVip();

        //GF
        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется Общее отображение раздела Журналы ГФ");
        bssTestBu();

        //OT
        updateSystemInfo(SystemPubs.ehs);
        updateLoginAsInfo("ehs.user.commercial");
        report("Проверяется Общее отображение раздела Журналы ОТ КУ");
        otTest();

        updateLoginToInfo("vip");
        updateLoginAsInfo("ehs.user.vip");
        report("Проверяется Общее отображение раздела Журналы ОТ БУ");
        otTest();

        updateLoginToInfo("vip");
        updateLoginAsInfo("ehs.user.vip");
        report("Проверяется Общее отображение раздела Журналы ОТ ВИП");
        otTest();

        //EDU VIP
        updateLoginToInfo("vip");
        updateLoginAsInfo("edu.user.vip");
        report("Проверяется Общее отображение раздела Журналы ОБР ВИП");
        eduTest();
    }

    private void bssTest() {
        loginBss()
                .navigateToMagazinesPage()
                .checkNewInMagazinesShelfIsPresent()
                .checkBooksBlockIsPresent()
                .checkMagazinesShelvesArePresent()
                .checkMagazineHasShelf("Главбух")
                .checkMagazineHasShelf("Учет в строительстве")
                .checkMagazineHasShelf("Учет в образовании")
                .checkMagazineHasShelf("Учет в сельском хозяйстве")
                .checkMagazineHasShelf("Упрощенка")
                .checkMagazineHasShelf("Вмененка")
                .checkMagazineHasShelf("Бухгалтерия ИП")
                .checkMagazineHasShelf("Госзакупки")

                .checkMobileReadButtonIsPresent()
                .checkMagazinesRubricatorButtonIsPresent()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAssistantButtonIsPresent()
                .logout();
    }

    private void bssTestBu() {
        loginBss()
                .navigateToMagazinesPage()
                .checkNewInMagazinesShelfIsPresent()
                .checkBooksBlockIsPresent()
                .checkMagazinesShelvesArePresent()
                .checkMagazineHasShelf("Главбух")
                .checkMagazineHasShelf("Учет в учреждении")
                .checkMagazineHasShelf("Зарплата в учреждении")
                .checkMagazineHasShelf("Учет в образовании")
                .checkMagazineHasShelf("Учет в сельском хозяйстве")
                .checkMagazineHasShelf("Справочник руководителя образовательного учреждения")
                .checkMagazineHasShelf("Учет в казенных учреждениях")
                .checkMagazineHasShelf("Госзакупки")
                .checkMagazineHasShelf("Платные услуги учреждения")

                .checkMobileReadButtonIsPresent()
                .checkMagazinesRubricatorButtonIsPresent()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAssistantButtonIsPresent()
                .logout();
    }

    private void bssTestUsn() {
        loginBss()
                .navigateToMagazinesPage()
                .checkNewInMagazinesShelfIsPresent()
                .checkBooksBlockIsPresent()
                .checkMagazinesShelvesArePresent()
                .checkMagazineHasShelf("Упрощенка")
                .checkMagazineHasShelf("Вмененка")
                .checkMagazineHasShelf("Бухгалтерия ИП")
                .checkMagazineHasShelf("Учет в сельском хозяйстве")

                .checkMobileReadButtonIsPresent()
                .checkMagazinesRubricatorButtonIsPresent()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAssistantButtonIsPresent()
                .logout();
    }

    private void bssTestVip() {
        loginBss()
                .navigateToMagazinesPage()
                .checkNewInMagazinesShelfIsPresent()
                .checkBooksBlockIsPresent()
                .checkMagazinesShelvesArePresent()
                .checkMagazineHasShelf("Главбух")
                .checkMagazineHasShelf("Учет. Налоги. Право")
                .checkMagazineHasShelf("Российский налоговый курьер")
                .checkMagazineHasShelf("Кадровое дело")
                .checkMagazineHasShelf("Зарплата")
                .checkMagazineHasShelf("Охрана труда")
                .checkMagazineHasShelf("Трудовые споры")
                .checkMagazineHasShelf("МСФО на практике")
                .checkMagazineHasShelf("Генеральный директор")
                .checkMagazineHasShelf("Финансовый директор")
                .checkMagazineHasShelf("Коммерческий директор")
                .checkMagazineHasShelf("Юрист компании")
                .checkMagazineHasShelf("Практическое налоговое планирование")
                .checkMagazineHasShelf("Налоговед")
                .checkMagazineHasShelf("Учет в строительстве")
                .checkMagazineHasShelf("Учет в образовании")
                .checkMagazineHasShelf("Учет в сельском хозяйстве")
                .checkMagazineHasShelf("Упрощенка")
                .checkMagazineHasShelf("Вмененка")
                .checkMagazineHasShelf("Бухгалтерия ИП")
                .checkMagazineHasShelf("Госзакупки")

                .checkMobileReadButtonIsPresent()
                .checkMagazinesRubricatorButtonIsPresent()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAssistantButtonIsPresent()
                .logout();
    }

    private void otTest() {
        loginOT()
                .navigateToMagazinesPage()
                .checkNewInMagazinesShelfIsPresent()
                .checkMagazinesShelvesArePresent()
                .checkMagazineHasShelf("Охрана труда в вопросах и ответах")
                .checkMagazineHasShelf("«Охрана труда»")
                .checkMagazineHasShelf("Справочник специалиста по охране труда")
                .checkMagazineHasShelf("Справочник кадровика")
                .checkMagazineHasShelf("Вопросы Севера")

                .checkMagazinesRubricatorButtonIsPresent()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .logout();
    }

    private void eduTest() {
        loginEdu()
                .navigateToMagazinesPage()
                .checkNewInMagazinesShelfIsPresent()
                .checkMagazinesShelvesArePresent()
                .checkMagazineHasShelf("Справочник руководителя образовательного учреждения")
                .checkMagazineHasShelf("Справочник заместителя директора школы")
                .checkMagazineHasShelf("Нормативные документы образовательного учреждения")
                .checkMagazineHasShelf("Справочник классного руководителя")
                .checkMagazineHasShelf("Управление начальной школой")
                .checkMagazineHasShelf("Управление образовательным учреждением в вопросах и ответах")
                .checkMagazineHasShelf("Справочник педагога-психолога. Школа")
                .checkMagazineHasShelf("Справочник педагога-психолога. Детский сад")
                .checkMagazineHasShelf("Справочник руководителя дошкольного учреждения")
                .checkMagazineHasShelf("Справочник старшего воспитателя дошкольного учреждения")
                .checkMagazineHasShelf("Медицинское обслуживание и организация питания детей ДОУ")
                .checkMagazineHasShelf("Справочник музыкального руководителя")

                .checkMagazinesRubricatorButtonIsPresent()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .logout();
    }
}
