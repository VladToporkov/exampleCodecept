package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inTesting;

/**
 * Created by Pavel on 24/08/16.
 */
public class OSS_2146_CheckBookIsPresentOnNewShelf extends AbstractDomainTest {

    @Test(groups = {inTesting})
    @TestLink(testCaseId = "OSS-2146", testCaseVersion = "1")
    public void oss_2146_test() {
        updateSystemInfo(SystemPubs.bss);
        report("Проверяется наличие книги на полке Новое БСС КУ");
        testBss();

        updateSystemInfo(SystemPubs.kss);
        report("Проверяется наличие книги на полке Новое КСС КУ");
        testKss();

        updateSystemInfo(SystemPubs.uss);
        report("Проверяется наличие книги на полке Новое ЮСС КУ");
        testUss();

        updateSystemInfo(SystemPubs.fss);
        report("Проверяется наличие книги на полке Новое ФСС КУ");
        testFss();
    }

    private void testBss() {
        enterToBssWithoutLogin()
                .navigateToMagazinesPage()
                .sendGetRequestAndCheckThatNewShelfHasOneBookAtLeast();
    }

    private void testKss() {
        enterToKssWithoutLogin()
                .navigateToMagazinesPage()
                .sendGetRequestAndCheckThatNewShelfHasOneBookAtLeast();
    }

    private void testFss() {
        enterToFssWithoutLogin()
                .navigateToMagazinesPage()
                .sendGetRequestAndCheckThatNewShelfHasOneBookAtLeast();
    }

    private void testUss() {
        enterToUssWithoutLogin()
                .navigateToMagazinesPage()
                .sendGetRequestAndCheckThatNewShelfHasOneBookAtLeast();
    }


}
