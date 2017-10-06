package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 28/08/16.
 */
public class OSS_142_MagazinesShelf extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-142", testCaseVersion = "1")
    public void oss_142_test() {
        //ELPU VIP
        updateSystemInfo(SystemPubs.elpu);
        updateLoginAsInfo("elpu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение раздела Журналы ЭЛПУ ВИП");
        elpuVip();

        //KLPU VIP
        updateSystemInfo(SystemPubs.klpu);
        updateLoginAsInfo("klpu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение раздела Журналы ЭЛПУ ВИП");
        klpuVip();

        //UMD VIP
        updateSystemInfo(SystemPubs.umd);
        updateLoginAsInfo("umd.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение раздела Журналы УМД ВИП");
        umdVip();

        //CULT VIP
        updateSystemInfo(SystemPubs.cult);
        updateLoginAsInfo("cult.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение раздела Журналы КУЛЬТ ВИП");
        cultVip();

        //GO VIP
        updateSystemInfo(SystemPubs.go);
        updateLoginAsInfo("go.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение раздела Журналы ГО ВИП");
        goVip();
    }

    private void elpuVip() {
        loginElpu()
                .navigateToMagazinesPage()
                .checkNewInMagazinesShelfIsPresent()
                .checkMagazinesShelvesArePresent()
                .checkMagazineHasShelf("Здравоохранение")
                .checkMagazineHasShelf("Управление качеством в здравоохранении")
                .checkMagazineHasShelf("Учет в учреждении")
                .checkMagazineHasShelf("Казенные учреждения. Учет, отчетсность, налогообложение")
                .checkMagazineHasShelf("Зарплата в учреждении")
                .checkMagazineHasShelf("Экономика ЛПУ в вопросах и ответах")

                .checkMagazinesRubricatorButtonIsPresent()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .logout();
    }

    private void klpuVip() {
        loginKlpu()
                .navigateToMagazinesPage()
                .checkNewInMagazinesShelfIsPresent()
                .checkMagazinesShelvesArePresent()
                .checkMagazineHasShelf("Справочник фельдшера и акушерки")
                .checkMagazineHasShelf("Главная медицинская сестра")

                .checkMagazinesRubricatorButtonIsPresent()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .logout();
    }

    private void umdVip() {
        loginUmd()
                .navigateToMagazinesPage()
                .checkNewInMagazinesShelfIsPresent()
                .checkMagazinesShelvesArePresent()
                .checkMagazineHasShelf("Управление многоквартирным домом")
                .checkMagazineHasShelf("ЖКХ: журнал руководителя и главного бухгалтера")
                .checkMagazineHasShelf("Практика муниципального управления")

                .checkMagazinesRubricatorButtonIsPresent()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .logout();
    }

    private void cultVip() {
        loginCult()
                .navigateToMagazinesPage()
                .checkNewInMagazinesShelfIsPresent()
                .checkMagazinesShelvesArePresent()
                .checkMagazineHasShelf("Справочник руководителя учреждения культуры")
                .checkMagazineHasShelf("Госзакупки.ру")
                .checkMagazineHasShelf("Справочник кадров")

                .checkMagazinesRubricatorButtonIsPresent()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .logout();
    }

    private void goVip() {
        loginGo()
                .navigateToMagazinesPage()
                .checkNewInMagazinesShelfIsPresent()
                .checkMagazinesShelvesArePresent()
                .checkMagazineHasShelf("Госзакупки.ру")
                .checkMagazineHasShelf("Госзаказ в вопросах и ответах")
                .checkMagazineHasShelf("Административная практика ФАС")
                .checkMagazineHasShelf("Учет в учреждении")

                .checkMagazinesRubricatorButtonIsPresent()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .logout();
    }
}
