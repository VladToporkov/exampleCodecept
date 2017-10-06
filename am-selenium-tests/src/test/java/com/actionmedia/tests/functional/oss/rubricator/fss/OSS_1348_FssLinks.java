package com.actionmedia.tests.functional.oss.rubricator.fss;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.fss.FssRubricator;
import com.actionmedia.pages.interfaces.ISystemBasePage;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by n.minochkina
 * Modified by Alex Plekhov 31.05.2016
 */
public class OSS_1348_FssLinks extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1345", testCaseVersion = "1")
    public void oss_1345_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Тест ОСС-1345: проверка открытия рубрикатора в новой вкладке KСС КУ");
        unifiedTest(loginKss());

        updateLoginToInfo("vip");
        updateLoginAsInfo("kss.user.vip");
        report("Тест ОСС-1345: проверка открытия рубрикатора в новой вкладке KСС ВИП");
        unifiedTest(loginKss());

        updateLoginToInfo("budget");
        updateLoginAsInfo("kss.user.budget");
        report("Тест ОСС-1345: проверка открытия рубрикатора в новой вкладке KСС БУ");
        unifiedTest(loginKss());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1346", testCaseVersion = "1")
    public void oss_1346_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Тест ОСС-1346: проверка открытия рубрикатора в новой вкладке БСС КУ");
        unifiedTest(loginBss());

        updateLoginToInfo("vip");
        updateLoginAsInfo("bss.user.vip");
        report("Тест ОСС-1346: проверка открытия рубрикатора в новой вкладке БСС ВИП");
        unifiedTest(loginBss());

        updateLoginToInfo("usn");
        updateLoginAsInfo("bss.user.usn");
        report("Тест ОСС-1346: проверка открытия рубрикатора в новой вкладке БСС УПР");
        unifiedTest(loginBss());

        updateLoginToInfo("budget");
        updateLoginAsInfo("bss.user.budget");
        report("Тест ОСС-1346: проверка открытия рубрикатора в новой вкладке БСС БУ");
        unifiedTest(loginBss());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1347", testCaseVersion = "1")
    public void oss_1347_test() {
        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Тест ОСС-1347: проверка открытия рубрикатора в новой вкладке ЮСС КУ");
        unifiedTest(loginUss());

        updateLoginToInfo("doc");
        updateLoginAsInfo("uss.user.vip");
        report("Тест ОСС-1347: проверка открытия рубрикатора в новой вкладке ЮСС ВИП");
        unifiedTest(loginUss());

        updateLoginToInfo("budget");
        updateLoginAsInfo("uss.user.budget");
        report("Тест ОСС-1347: проверка открытия рубрикатора в новой вкладке ЮСС БУ");
        unifiedTest(loginUss());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1348", testCaseVersion = "1")
    public void oss_1348_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Тест ОСС-1348: проверка открытия рубрикатора в новой вкладке ФСС");
        unifiedTest(loginFss());
    }

    private <T extends ISystemBasePage> void unifiedTest(T page) {
        page
                .clickRubricatorButton()
                .checkRubricatorIsOpened()

                .openRubricInNewTab()
                .checkRubricatorIsOpened()
                .closeCurrentWindow(FssRubricator.class)
                .logout();
    }
}
