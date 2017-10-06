package com.actionmedia.tests.functional.bss.recomend;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.bss.BssRecomendPage;
import com.actionmedia.pages.kss.KssAnswersPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 24.10.13
 * Time: 10:03
 */
public class BSS_52_VerifyOnlineHelp extends AbstractDomainTest {

    private static final String QUESTION = "AUTOTEST " + RandomStringUtils.randomAlphabetic(5);

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "BSS-52", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_52_test() {
        BssRecomendPage recomendPage = loginBss()
                .navigateToRecomendPage()
                .clickOnlineHelpButton()
                .checkFormOnlineHelpIsPresentNew();
        if (recomendPage.isAssistantOnlineNew()) {
            recomendPage
                    .inputTextInOnlineHelpFormNew(QUESTION)
                    .clickSendButtonNew()
                    .checkMessageIsAppearInFormNew(QUESTION)
                    .logout();
        }
    }
}
