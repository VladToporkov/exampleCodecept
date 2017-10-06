package com.actionmedia.tests.functional.uss.recomend;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.uss.UssProfilePage;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.inDevelopment;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 10.04.2014
 * Time: 14:26
 */
public class USS_202_VerifyGiftCodesToServices extends AbstractDomainTest {

    @Test(groups = {smoke, inDevelopment})
    @TestLink(testCaseId = "USS-202", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void uss_202_test() {
        report("Зайти в личный кабинет пользователя без оплаченного доступа к системе ЮСС");
        loginUss()
                .navigateToRecomendPage()
                .clickProfileLink()
                .checkTrainingBlockIsPresent()
                .checkCourseInTrainingBlockIsPresent("Путеводитель по неустойке")
                .checkCourseInTrainingBlockIsPresent("Академия «Юриста Компании»")
                .logout();

        report("Зайти в личный кабинет пользователя с демо доступом");
        updateLoginAsInfo("uss.user.demo");
        loginUss()
                .navigateToRecomendPage()
                .clickProfileLink()
                .checkTrainingBlockIsPresent()
                .checkCourseInTrainingBlockIsPresent("Путеводитель по неустойке")
                .checkCourseInTrainingBlockIsPresent("Академия «Юриста Компании»")
                .logout();

        report("Зайти в личный кабинет пользователя с оплаченным доступом  к ЮСС ");
        updateLoginAsInfo("uss.user.commercial");
        loginUss()
                .navigateToRecomendPage()
                .clickProfileLink()
                .checkTrainingBlockIsPresent()
                .checkCourseInTrainingBlockIsPresent("Путеводитель по неустойке")
                .checkCourseInTrainingBlockIsPresent("Академия «Юриста Компании»")
                .logout();

        report("Зайти пользователем с оплаченным доступом к ЮСС КД в обычный ЮСС");
        updateLoginToInfo("doc");
        updateLoginAsInfo("uss.user.vip");
        loginUss()
                .navigateToRecomendPage()
                .clickProfileLink()
                .checkTrainingBlockIsPresent()
                .checkCourseInTrainingBlockIsPresent("Путеводитель по неустойке")
                .checkCourseInTrainingBlockIsPresent("Академия «Юриста Компании»")

                .clickLinkByName("Путеводитель по неустойке")
                .checkCurrentUrlContainsDocumentUrl("lawyercom.ru/service/putevoditel-po-neustojke/")
                .closeCurrentWindow(UssProfilePage.class)

                .clickLinkByName("Академия «Юриста Компании»")
                .checkCurrentUrlContainsDocumentUrl("lawyercom.ru/uracademy/video-lectures")

                .clickEnterButton()
                .inputEmail(getLoginByKey("uss.user.vip"))
                .inputPassword(getPasswordByKey("uss.user.vip"))
                .clickLoginButton()
                .checkLinkToProfileIsPresent()

                .closeCurrentWindow(UssProfilePage.class)
                .logout();
    }
}
