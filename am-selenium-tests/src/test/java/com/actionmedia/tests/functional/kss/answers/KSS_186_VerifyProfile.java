package com.actionmedia.tests.functional.kss.answers;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 29.11.13
 * Time: 18:08
 */
public class KSS_186_VerifyProfile extends AbstractDomainTest {

    @Test(groups = {smoke, inDevelopment})
    @TestLink(testCaseId = "KSS-186", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_186_test() {
        loginKss()
                .clickProfileLink()
                .checkPersonalInfoIsPresent()
                .checkFieldsInPersonalInfoBlock()
                .checkGeoBlockIsPresent()

                .checkMyEducationBlockIsPresent()

                .checkMySubsriptionBlockIsPresent()

                .checkMyAccessListBlockIsPresent()

                .checkMyFavoritesRubricatorButtonIsPresent()

                .checkOnlineHelpButtonIsPresent()

                .logout();
    }
}

