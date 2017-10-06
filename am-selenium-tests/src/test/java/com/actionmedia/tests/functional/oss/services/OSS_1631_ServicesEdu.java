package com.actionmedia.tests.functional.oss.services;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel on 05/05/16.
 */
public class OSS_1631_ServicesEdu extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1631", testCaseVersion = "4")
    public void oss_1631_test() {
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.commercial");
        report("Проверяется Общее отображение раздела Сервисы OSS-1631 ОБР КУ");
        edu_test();

        updateLoginAsInfo("edu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение раздела Сервисы OSS-1631 ОБР ВИП");
        edu_test();
    }

    private void edu_test() {
        loginEdu()
                .navigateToServicesPage()
                .checkTitleServicesIsPresent()
                .checkConstructorsTitleIsPresent()

                .checkRightBlockIsPresent()
                .checkAllServicesRubricatorButtonIsPresent()
                .checkConstructorsBlockIsPresent()

                .clickOnRandomConstructorsLink()
                .checkDocumentIsOpened()
                .checkOpenedLinkHasRequiredTitle()

                .navigateToServicesPage()
                .clickOnRandomPopularLink()
                .checkDocumentIsOpened()
                .checkOpenedLinkHasRequiredTitle()

                .logout();

        enterToEduWithoutLogin()
                .navigateToServicesPage()
                .checkRightBlockIsPresent();
    }
}
