package com.actionmedia.tests.functional.kss.wizards;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 28.11.13
 * Time: 15:10
 */
public class KSS_72_VerifyWizardsDocument150Module extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-72", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_72_test() {
        loginKss()
                .openDocumentByUrl(getDocumentUrlByKey("kss.150.module"))
                .checkDocumentIsOpened()
                .checkPrintButtonIsPresent()
                .checkWordButtonIsPresent()
                .checkMailButtonIsPresent()
                .checkRubricatorButtonIsPresent("Все сервисы")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonIsPresent()
                .logout();
    }
}
