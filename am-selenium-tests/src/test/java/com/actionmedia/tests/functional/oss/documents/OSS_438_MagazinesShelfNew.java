package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.interfaces.ISystemBasePage;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;
import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 19/04/16.
 */
public class OSS_438_MagazinesShelfNew extends AbstractDomainTest {

    @Test(groups = {inDevelopment})
    @TestLink(testCaseId = "OSS-438", testCaseVersion = "4")
    public void oss_438_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Журналы Полка Новое БСС КУ");
        unifiedTest(loginBss());

        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Журналы Полка Новое  КСС КУ");
        unifiedTest(loginKss());

        //GF
        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется Журналы Полка Новое ГФ КУ");
        unifiedTest(loginGF());

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Журналы Полка Новое ЮСС КУ");
        unifiedTest(loginUss());

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Журналы Полка Новое ФСС КУ");
        unifiedTest(loginFss());

        //OT
        updateSystemInfo(SystemPubs.ehs);
        updateLoginAsInfo("ehs.user.commercial");
        report("Проверяется Журналы Полка Новое МЦФЭР ОТ");
        unifiedTest(loginOT());

        //EDU
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.commercial");
        report("Проверяется Журналы Полка Новое МЦФЭР ОБР");
        unifiedTest(loginEdu());

        //GO
        updateSystemInfo(SystemPubs.go);
        updateLoginAsInfo("go.user.commercial");
        report("Проверяется Журналы Полка Новое МЦФЭР ГЗ");
        unifiedTest(loginGo());

        //ELPU
        updateSystemInfo(SystemPubs.elpu);
        updateLoginAsInfo("elpu.user.commercial");
        report("Проверяется Журналы Полка Новое МЦФЭР ЭЛПУ");
        unifiedTest(loginElpu());

        //CULT
        updateSystemInfo(SystemPubs.cult);
        updateLoginAsInfo("cult.user.commercial");
        report("Проверяется Журналы Полка Новое МЦФЭР КУЛЬТ");
        unifiedTest(loginCult());

        //KLPU
        updateSystemInfo(SystemPubs.klpu);
        updateLoginAsInfo("klpu.user.commercial");
        report("Проверяется Журналы Полка Новое МЦФЭР КЛПУ");
        unifiedTest(loginKlpu());

        //UMD
        updateSystemInfo(SystemPubs.umd);
        updateLoginAsInfo("umd.user.commercial");
        report("Проверяется Журналы Полка Новое МЦФЭР УМД");
        unifiedTest(loginUmd());

        //EHS
        updateSystemInfo(SystemPubs.ehs);
        updateLoginAsInfo("ehs.user.commercial");
        report("Проверяется Журналы Полка Новое МЦФЭР ОТ");
        unifiedTest(loginOT());

    }


    private <T extends ISystemBasePage> void unifiedTest(T page) {
        page
                .navigateToMagazinesPage()
                .checkNewInMagazinesShelfIsPresent()
                .checkNewInMagazinesShelfNewMagazinesIsPresent()
                .checkNewInMagazinesShelfMagazinesAreNotRepeated()
                .checkNewInMagazinesShelfMagazinesAreDescending()
                .checkNewInMagazinesShelfMagazinesHasNumberAndYearOfPublishing()

                .clickOnNewInMagazinesShelfRightArrow()
                .checkNewInMagazinesShelfNewMagazinesArePresentAfterClicking()

                .clickOnNewInMagazinesShelfRightArrow()
                .checkNewInMagazinesShelfNewMagazinesArePresentAfterClicking()

                .clickOnNewInMagazinesShelfLeftArrow()
                .checkNewInMagazinesShelfNewMagazinesArePresentAfterClicking()

                .checkNewInMagazinesShelfArrowsArePresent()

                .clickOnNewInMagazinesShelfRandomDisplayedMagazineOrBook()
                .checkDocumentIsOpened()

                .navigateToMagazinesPage()

                .clickOnNewInMagazinesShelfRandomDisplayedMagazineOrBook()
                .checkDocumentIsOpened()

                .logout();
    }
}
