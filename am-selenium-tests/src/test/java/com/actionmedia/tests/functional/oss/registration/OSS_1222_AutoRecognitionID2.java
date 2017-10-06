package com.actionmedia.tests.functional.oss.registration;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.*;

/**
 * Created by Pavel on 02/03/16.
 */
public class OSS_1222_AutoRecognitionID2 extends AbstractDomainTest {

    private String emailUser1;
    private String emailUser2;

    @Test(groups = {regression, noProk, noProduction, noWeb13}) //just only for rt
    @TestLink(testCaseId = "OSS-1222", testCaseVersion = "3")
    public void oss_1222_test() {
        emailUser1 = getLoginProperties("user.cross.auth.1").split("\\|")[0];
        emailUser2 = getLoginProperties("user.cross.auth.2").split("\\|")[0];

        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("user.cross.auth.2");
        fss_id2();

        updateSystemInfo(SystemPubs.bss);
        report("Проверка Автоузнавание от id2 по ссылке с параметрами");
        bss_id2();

        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("user.cross.auth.2");
        uss_id2();
    }

    private void bss_id2() {
        enterToBssWithoutLogin()
                .navigateToRecomendPage()
                .openPageByUrl("https://id2.action-media.ru/fl/?user=s8vayw&app=16&rand=386234467&sign=" +
                        "73287e569fe5753ecdcc6052cd22d85a&returnurl=http%3A%2F%2Fbss-rt.actiondigital.ru")
                .clickProfileLink()
                .checkProfilePageIsOpened()
                .checkEmail(emailUser1)
                .logout();
    }

    private void uss_id2() {
        loginUss()
                .navigateToRecomendPage()
                .openDocumentByUrl("https://id2.action-media.ru/fl/?user=s8vayw&app=16&rand=386234467&sign=" +
                        "0b549b061b307b84da215d323e089ce5&returnurl=http%3A%2F%2Fuss-rt.actiondigital.ru")
                .clickProfileLink()
                .checkProfilePageIsOpened()
                .checkEmail(emailUser1)
                .logout();
    }

    private void fss_id2() {
        loginFss()
                .navigateToSolutionsPage()
                .openDocumentByUrl("https://id2.action-media.ru/fl/?user=s8vayw&app=16&rand=386234467&sign=" +
                        "0a3faa013beb2dc44dc9da33d64b98d7&returnurl=http%3A%2F%2Ffss-rt.actiondigital.ru")
                .clickProfileLink()
                .checkProfilePageIsOpened()
                .checkEmail(emailUser2)
                .logout();
    }
}
