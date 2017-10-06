package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.interfaces.ISystemBasePage;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;

/**
 * Created by Pavel on 23/08/16.
 */
public class OSS_439_BooksShelf extends AbstractDomainTest {

    @Test(groups = {inDevelopment})
    @TestLink(testCaseId = "OSS-439", testCaseVersion = "3")
    public void oss_439_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Журналы Полка Книги БСС КУ");
        unifiedTest(loginBss());

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Журналы Полка Новое БСС БУ");
        unifiedTest(loginBss());

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Журналы Полка Новое БСС УСН");
        unifiedTest(loginBss());

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Журналы Полка Новое БСС ВИП");
        unifiedTest(loginBss());

        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Журналы Полка Новое КСС КУ");
        unifiedTest(loginKss());

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Журналы Полка Новое КСС БУ");
        unifiedTest(loginKss());

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Журналы Полка Новое КСС ВИП");
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

        updateLoginAsInfo("uss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Журналы Полка Новое ЮСС БУ");
        unifiedTest(loginUss());

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Журналы Полка Новое ФСС КУ");
        unifiedTest(loginFss());
    }


    private <T extends ISystemBasePage> void unifiedTest(T page) {
        page
                .navigateToMagazinesPage()

                .checkBookShelfIsPresent()
                .checkBooksShelfHasPopularTitle()
                .checkBooksShelfHasAllBooksTitle()
                .checkBooksShelfPopularBlockHasThreeItems()
                .checkBooksShelfPopularBooksAreNotRepeated()
                .checkBooksShelfAllBooksBlockIsPresent()
                .checkBooksShelfHasOnlyBooks()

                .clickOnBooksShelfRightArrow()
                .checkBooksShelfNewBooksArePresentAfterClicking()

                .clickOnBooksShelfRightArrow()
                .checkBooksShelfNewBooksArePresentAfterClicking()

                .clickOnBooksShelfLeftArrow()
                .checkBooksShelfNewBooksArePresentAfterClicking()

                .checkBooksShelfArrowsArePresent()

                .clickOnBooksShelfRandomBook()
                .checkDocumentIsOpened()

                .logout();
    }


}
