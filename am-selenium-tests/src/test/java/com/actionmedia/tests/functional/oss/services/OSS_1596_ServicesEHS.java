package com.actionmedia.tests.functional.oss.services;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel on 04/05/16.
 */
public class OSS_1596_ServicesEHS extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1596", testCaseVersion = "4")
    public void oss_1596_test() {
        updateSystemInfo(SystemPubs.ehs);
        updateLoginAsInfo("ehs.user.commercial");
        report("Проверяется Общее отображение раздела Сервисы OSS-1596 ОТ КУ");
        ot_test();

        updateLoginToInfo("vip");
        updateLoginAsInfo("ehs.user.vip");
        report("Проверяется Общее отображение раздела Сервисы OSS-1596 ОТ ВИП");
        ot_test();
    }

    private void ot_test() {
        loginOT()
                .navigateToServicesPage()
                .checkTitleServicesIsPresent()
                .checkCalculatorsTitleIsPresent()
                .checkTestsTitleIsPresent()
                .checkRightBlockIsPresent()
                .checkAllServicesRubricatorButtonIsPresent()
                .checkCalculatorsBlockIsPresent()
                .checkTestsBlockIsPresent()

                .clickOnRandomCalculatorLink()
                .checkDocumentIsOpened()
                .checkOpenedLinkHasRequiredTitle()

                .navigateToServicesPage()
                .clickOnRandomTestsLink()
                .checkDocumentIsOpened()
                .checkOpenedLinkHasRequiredTitle()

                .navigateToServicesPage()
                .clickOnRandomPopularLink()
                .checkDocumentIsOpened()
                .checkOpenedLinkHasRequiredTitle()

                .logout();

        enterToOtWithoutLogin()
                .navigateToServicesPage()
                .checkRightBlockIsPresent();
    }
}
