package com.actionmedia.tests.functional.kss.answers;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 02.12.13
 * Time: 11:17
 */
public class KSS_148_VerifyAboutSystemPageDefaultState extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-148", testCaseVersion = "1")
    @LoginAs(key = "kss.user.vip")
    @Version(section = "vip")
    public void kss_148_test() {
        loginKss()
                .clickAboutSystemLink()
                .checkAboutSystemPageIsOpened()

                .checkHeaderIsPresent()
                .checkLogoIsPresent()
                .checkPhoneNumberBlockIsPresent()

                .checkVersionBlockIsPresent()
                .checkVersionBlockIsNotEmpty()
                .checkSelectedVersion()

                .checkTitleIsPresent()

                .checkDemoButtonIsPresent()

                .checkSearchBoxIsPresent()
                .checkYellowPlateIsPresent()

                .checkFeatureBlockIsPresent()

                .checkVipServicesBlockIsPresent()

                .checkServicesBlockIsPresent()

                .checkExpertsBlockIsPresent()

                .checkRubricatorBlockIsPresent()

                .checkLawBaseBlockIsPresent()

                .checkMailBlockIsPresent()

                .checkOpinionsBlockIsPresent()

                .checkQuestionsBlockIsPresent()

                .checkTrialBlockIsPresent()

                .checkFooterIsPresent()

                .checkSoderIsPresent();
    }
}
