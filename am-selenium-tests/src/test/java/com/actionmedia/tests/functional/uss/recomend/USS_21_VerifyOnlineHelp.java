package com.actionmedia.tests.functional.uss.recomend;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.uss.UssRecomendPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 06.12.13
 * Time: 15:49
 */
public class USS_21_VerifyOnlineHelp extends AbstractDomainTest {

    private static final String QUESTION = "AUTOTEST " + RandomStringUtils.randomAlphabetic(5);

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "USS-21", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_21_test() {
        UssRecomendPage recomendPage = loginUss()
                .navigateToRecomendPage()
                .clickOnlineHelpButton()
                .checkFormOnlineHelpIsPresentNew();
        if (recomendPage.isAssistantOnlineNew()) {
            recomendPage
                    .inputTextInOnlineHelpFormNew(QUESTION)
                    .clickSendButtonNew()
                    .checkMessageIsAppearInFormNew(QUESTION);
        }
        recomendPage
                .logout();
    }
}
