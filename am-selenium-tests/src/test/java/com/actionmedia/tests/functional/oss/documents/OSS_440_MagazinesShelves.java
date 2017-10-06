package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 24/04/16.
 */
public class OSS_440_MagazinesShelves extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-440", testCaseVersion = "4")
    public void oss_440_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Журналы Все полки БСС КУ");
        bssMagazine();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Журналы Все полки БСС БУ");
        bssMagazineBU();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Журналы Все полки БСС УСН");
        bssMagazine();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Журналы Все полки БСС ВИП");
        bssMagazine();

        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Журналы Все полки КСС КУ");
        kssMagazine();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Журналы Все полки КСС БУ");
        kssMagazine();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Журналы Все полки КСС ВИП");
        kssMagazine();

        //GF
        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется Журналы Все полки ГФ КУ");
        gfMagazine();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Журналы Все полки ЮСС КУ");
        ussMagazine();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Журналы Все полки ЮСС ВИП");
        ussMagazine();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Журналы Все полки ФСС КУ");
        fssMagazine();

        //OT
        updateSystemInfo(SystemPubs.ehs);
        updateLoginAsInfo("ehs.user.commercial");
        report("Проверяется Журналы Все полки МЦФЭР ОТ");
        otMagazine();

        updateLoginAsInfo("ehs.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Журналы Все полки МЦФЭР ОТ");
        otMagazine();

        //EDU
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Журналы Все полки МЦФЭР ОБР");
        eduMagazine();
    }

    private void bssMagazine() {
        loginBss()
                .navigateToMagazinesPage()
                .checkMagazinesShelvesArePresent()
                .checkMagazineShelfHasTitlePopular()
                .checkMagazineShelfHasTitleAllMagazines()
                .checkMagazinesShelfPopularHasMaxThreeMagazines()
                .checkMagazinesInPopularBlockAreNotRepeated()
                .checkMagazinesShelfAllMagazinesAreSortedDescending()
                .checkMagazinesShelfHasOnlyMagazines()
                .checkMagazinesEachShelfHasOneMagazine()
                .checkMagazinesShelvesHaveNumberAndYearOfPublishing()

                .clickOnMagazinesShelfRightArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .clickOnMagazinesShelfRightArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .checkMagazinesShelvesArrowsArePresent()

                .clickOnMagazinesShelvesLeftArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .clickOnMagazinesShelvesLeftArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .clickOnMagazinesShelvesRandomDisplayedMagazine()
                .checkDocumentIsOpened()

                .navigateToMagazinesPage()
                .clickOnMagazinesShelvesRandomDisplayedMagazine()
                .checkDocumentIsOpened()

                .navigateToMagazinesPage()
                .clickOnMagazinesShelvesRandomDisplayedMagazine()
                .checkDocumentIsOpened()

                .logout();
    }

    private void bssMagazineBU() {
        loginBss()
                .navigateToMagazinesPage()
                .checkMagazinesShelvesArePresent()
                .checkMagazineShelfHasTitlePopular()
                .checkMagazineShelfHasTitleAllMagazines()
                .checkMagazinesShelfPopularHasMaxThreeMagazines()
                .checkMagazinesInPopularBlockAreNotRepeated()
                .checkMagazinesShelfAllMagazinesAreSortedDescending()
                .checkMagazinesShelfHasOnlyMagazines()
                .checkMagazinesEachShelfHasOneMagazine()
                .checkMagazineHasNoShelf("Финансовый справочник бюджетной организации")
                .checkMagazinesShelvesHaveNumberAndYearOfPublishing()

                .clickOnMagazinesShelfRightArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .clickOnMagazinesShelfRightArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .checkMagazinesShelvesArrowsArePresent()

                .clickOnMagazinesShelvesLeftArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .clickOnMagazinesShelvesLeftArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .clickOnMagazinesShelvesRandomDisplayedMagazine()
                .checkDocumentIsOpened()

                .navigateToMagazinesPage()
                .clickOnMagazinesShelvesRandomDisplayedMagazine()
                .checkDocumentIsOpened()

                .navigateToMagazinesPage()
                .clickOnMagazinesShelvesRandomDisplayedMagazine()
                .checkDocumentIsOpened()

                .logout();
    }

    private void kssMagazine() {
        loginKss()
                .navigateToMagazinesPage()
                .checkMagazinesShelvesArePresent()
                .checkMagazineShelfHasTitlePopular()
                .checkMagazineShelfHasTitleAllMagazines()
                .checkMagazinesShelfPopularHasMaxThreeMagazines()
                .checkMagazinesInPopularBlockAreNotRepeated()
                .checkMagazinesShelfAllMagazinesAreSortedDescending()
                .checkMagazinesShelfHasOnlyMagazines()
                .checkMagazinesEachShelfHasOneMagazine()

                .clickOnMagazinesShelfRightArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .clickOnMagazinesShelfRightArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .checkMagazinesShelvesArrowsArePresent()

                .clickOnMagazinesShelvesLeftArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .clickOnMagazinesShelvesLeftArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .clickOnMagazinesShelvesRandomDisplayedMagazine()
                .checkDocumentIsOpened()

                .navigateToMagazinesPage()
                .clickOnMagazinesShelvesRandomDisplayedMagazine()
                .checkDocumentIsOpened()

                .navigateToMagazinesPage()
                .clickOnMagazinesShelvesRandomDisplayedMagazine()
                .checkDocumentIsOpened()

                .logout();
    }

    private void fssMagazine() {
        loginFss()
                .navigateToMagazinesPage()
                .checkMagazinesShelvesArePresent()
                .checkMagazineShelfHasTitlePopular()
                .checkMagazineShelfHasTitleAllMagazines()
                .checkMagazinesShelfPopularHasMaxThreeMagazines()
                .checkMagazinesInPopularBlockAreNotRepeated()
                .checkMagazinesShelfAllMagazinesAreSortedDescending()
                .checkMagazinesShelfHasOnlyMagazines()
                .checkMagazinesEachShelfHasOneMagazine()
                .checkMagazinesShelvesHaveNumberAndYearOfPublishing()

                .clickOnMagazinesShelfRightArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .clickOnMagazinesShelfRightArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .checkMagazinesShelvesArrowsArePresent()

                .clickOnMagazinesShelvesLeftArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .clickOnMagazinesShelvesLeftArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .clickOnMagazinesShelvesRandomDisplayedMagazine()
                .checkDocumentIsOpened()

                .navigateToMagazinesPage()
                .clickOnMagazinesShelvesRandomDisplayedMagazine()
                .checkDocumentIsOpened()

                .navigateToMagazinesPage()
                .clickOnMagazinesShelvesRandomDisplayedMagazine()
                .checkDocumentIsOpened()

                .logout();
    }

    private void ussMagazine() {
        loginUss()
                .navigateToMagazinesPage()
                .checkMagazinesShelvesArePresent()
                .checkMagazineShelfHasTitlePopular()
                .checkMagazineShelfHasTitleAllMagazines()
                .checkMagazinesShelfPopularHasMaxThreeMagazines()
                .checkMagazinesInPopularBlockAreNotRepeated()
                .checkMagazinesShelfAllMagazinesAreSortedDescending()
                .checkMagazinesShelfHasOnlyMagazines()
                .checkMagazinesEachShelfHasOneMagazine()
                .checkMagazinesShelvesHaveNumberAndYearOfPublishing()

                .clickOnMagazinesShelfRightArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .clickOnMagazinesShelfRightArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .checkMagazinesShelvesArrowsArePresent()

                .clickOnMagazinesShelvesLeftArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .clickOnMagazinesShelvesLeftArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .clickOnMagazinesShelvesRandomDisplayedMagazine()
                .checkDocumentIsOpened()

                .navigateToMagazinesPage()
                .clickOnMagazinesShelvesRandomDisplayedMagazine()
                .checkDocumentIsOpened()

                .navigateToMagazinesPage()
                .clickOnMagazinesShelvesRandomDisplayedMagazine()
                .checkDocumentIsOpened()

                .logout();
    }

    private void gfMagazine() {
        loginGF()
                .navigateToMagazinesPage()
                .checkMagazinesShelvesArePresent()
                .checkMagazineShelfHasTitlePopular()
                .checkMagazineShelfHasTitleAllMagazines()
                .checkMagazinesShelfPopularHasMaxThreeMagazines()
                .checkMagazinesInPopularBlockAreNotRepeated()
                .checkMagazinesShelfAllMagazinesAreSortedDescending()
                .checkMagazinesShelfHasOnlyMagazines()
                .checkMagazinesEachShelfHasOneMagazine()
                .checkMagazinesShelvesHaveNumberAndYearOfPublishing()

                .clickOnMagazinesShelfRightArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .clickOnMagazinesShelfRightArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .checkMagazinesShelvesArrowsArePresent()

                .clickOnMagazinesShelvesLeftArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .clickOnMagazinesShelvesLeftArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .clickOnMagazinesShelvesRandomDisplayedMagazine()
                .checkDocumentIsOpened()

                .navigateToMagazinesPage()
                .clickOnMagazinesShelvesRandomDisplayedMagazine()
                .checkDocumentIsOpened()

                .navigateToMagazinesPage()
                .clickOnMagazinesShelvesRandomDisplayedMagazine()
                .checkDocumentIsOpened()

                .logout();
    }

    private void otMagazine() {
        loginOT()
                .navigateToMagazinesPage()
                .checkMagazinesShelvesArePresent()
                .checkMagazineShelfHasTitlePopular()
                .checkMagazineShelfHasTitleAllMagazines()
                .checkMagazinesShelfPopularHasMaxThreeMagazines()
                .checkMagazinesInPopularBlockAreNotRepeated()
                .checkMagazinesShelfAllMagazinesAreSortedDescending()
                .checkMagazinesShelfHasOnlyMagazines()
                .checkMagazinesEachShelfHasOneMagazine()
                .checkMagazinesShelvesHaveNumberAndYearOfPublishing()

                .clickOnMagazinesShelfRightArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .clickOnMagazinesShelfRightArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .checkMagazinesShelvesArrowsArePresent()

                .clickOnMagazinesShelvesLeftArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .clickOnMagazinesShelvesLeftArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .clickOnMagazinesShelvesRandomDisplayedMagazine()
                .checkDocumentIsOpened()

                .navigateToMagazinesPage()
                .clickOnMagazinesShelvesRandomDisplayedMagazine()
                .checkDocumentIsOpened()

                .navigateToMagazinesPage()
                .clickOnMagazinesShelvesRandomDisplayedMagazine()
                .checkDocumentIsOpened()

                .logout();
    }

    private void eduMagazine() {
        loginEdu()
                .navigateToMagazinesPage()
                .checkMagazinesShelvesArePresent()
                .checkMagazineShelfHasTitlePopular()
                .checkMagazineShelfHasTitleAllMagazines()
                .checkMagazinesShelfPopularHasMaxThreeMagazines()
                .checkMagazinesInPopularBlockAreNotRepeated()
                .checkMagazinesShelfAllMagazinesAreSortedDescending()
                .checkMagazinesShelfHasOnlyMagazines()
                .checkMagazinesEachShelfHasOneMagazine()
                .checkMagazinesShelvesHaveNumberAndYearOfPublishing()

                .clickOnMagazinesShelfRightArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .clickOnMagazinesShelfRightArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .checkMagazinesShelvesArrowsArePresent()

                .clickOnMagazinesShelvesLeftArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .clickOnMagazinesShelvesLeftArrow()
                .checkMagazinesShelvesVisibleMagazinesIsChangedAfterClicking()

                .clickOnMagazinesShelvesRandomDisplayedMagazine()
                .checkDocumentIsOpened()

                .navigateToMagazinesPage()
                .clickOnMagazinesShelvesRandomDisplayedMagazine()
                .checkDocumentIsOpened()

                .navigateToMagazinesPage()
                .clickOnMagazinesShelvesRandomDisplayedMagazine()
                .checkDocumentIsOpened()

                .logout();
    }
}
