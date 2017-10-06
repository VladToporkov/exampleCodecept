package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 28/08/16.
 */
public class OSS_143_MagazinesShelfFSS extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-143", testCaseVersion = "1")
    public void oss_143_test() {
        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Общее отображение раздела Журналы ФСС");
        fssTest();
    }

    private void fssTest() {
        loginFss()
                .navigateToMagazinesPage()
                .checkNewInMagazinesShelfIsPresent()
                .checkBooksBlockIsPresent()
                .checkMagazinesShelvesArePresent()
                .checkMagazineHasShelf("Финансовый директор")
                .checkMagazineHasShelf("Главбух")
                .checkMagazineHasShelf("Практическое налоговое планирование")
                .checkMagazineHasShelf("Арбитражная налоговая практика")
                .checkMagazineHasShelf("Налоговед")
                .checkMagazineHasShelf("МСФО на практике")
                .checkMagazineHasShelf("Генеральный директор")
                .checkMagazineHasShelf("Коммерческий директор")
                .checkMagazineHasShelf("Учет в учреждении")
                .checkMagazineHasShelf("Платные услуги учреждения")
                .checkMagazineHasShelf("Финансовый справочник бюджетной организации")

                .checkMagazinesRubricatorButtonIsPresent()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAssistantButtonIsPresent()
                .logout();
    }
}
