package com.actionmedia.tests.functional.uss.recomend;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 27.02.14
 * Time: 14:31
 */
public class USS_174_VerifyAccessToDocumentsInKD extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "USS-174", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    @Version(section = "doc")
    public void uss_174_test() {
        report("Проверяется доступ к документам ЮСС КД для пользователя с доступом от ЮСС");
        loginUss()
                .clickRubricatorButton()
                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()

                .checkWarningPanelIsPresent()
                .checkPreviewDocumentIsOpened()
                .checkActivationTabIsPresent()
                .checkActivationButtonIsDisabled()
                .logout();

        report("Проверяется доступ к документам ЮСС КД для пользователя оплаченным доступом");
        updateLoginAsInfo("uss.user.vip");
        loginUss()
                .clickRubricatorButton()
                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()

                .checkWarningPanelIsNotPresent()
                .checkActivationTabIsNotPresent()
                .checkFullDocumentIsOpened()
                .logout();

        report("Проверяется доступ к документам ЮСС КД для пользователя со всеми доступами");
        updateLoginAsInfo("uss.user.all");
        loginUss()
                .clickRubricatorButton()
                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()

                .checkWarningPanelIsNotPresent()
                .checkActivationTabIsNotPresent()
                .checkFullDocumentIsOpened()
                .logout();
    }
}
