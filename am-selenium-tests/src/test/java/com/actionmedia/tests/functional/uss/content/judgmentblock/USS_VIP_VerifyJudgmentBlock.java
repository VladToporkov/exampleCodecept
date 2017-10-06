package com.actionmedia.tests.functional.uss.content.judgmentblock;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.judgment;

public class USS_VIP_VerifyJudgmentBlock extends AbstractDomainTest {

//    @Test(groups = {judgment})
    @LoginAs(key = "uss.user.vip")
    @Version(section = "doc")
    public void test() {
        loginUss()
                .navigateToLawBasePage()
                .checkJudgmentBlockIsPresent()
                .checkJudgmentKodeksBlockLinksAreWorked();
    }
}
