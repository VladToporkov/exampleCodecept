package com.actionmedia.tests.functional.kss.answers;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.kss.KssAnswersPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 01.10.13
 * Time: 10:38
 */
public class KSS_162_VerifyOnlineHelp extends AbstractDomainTest {

    private static final String QUESTION = "AUTOTEST " + RandomStringUtils.randomAlphabetic(5);

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-162", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_162_test() {
        KssAnswersPage recomendPage = loginKss()
                .navigateToAnswersPage()
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
