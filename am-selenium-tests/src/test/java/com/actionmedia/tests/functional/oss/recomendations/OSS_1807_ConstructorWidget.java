package com.actionmedia.tests.functional.oss.recomendations;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 21/07/16.
 */
public class OSS_1807_ConstructorWidget extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1807", testCaseVersion = "1")
    public void oss_1807_test() {
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Конструктор документов ОБР КУ");
        test();

        updateLoginToInfo("vip");
        updateLoginAsInfo("edu.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Конструктор документов ОБР ВИП");
        test();
    }

    private void test() {
        loginEdu()
                .navigateToRecomendPage()
                .checkConstructorWidgetIsPresent()
                .checkConstructorLinksArePresent()

                .clickOnConstructorTitleLink()
                .checkConstructorsBlockIsPresent()

                .navigateToRecomendPage()
                .checkConstructorServicesLinksAreWorked()
                .logout();
    }
}
