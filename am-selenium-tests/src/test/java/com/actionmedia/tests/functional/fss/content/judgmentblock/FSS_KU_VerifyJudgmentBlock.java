package com.actionmedia.tests.functional.fss.content.judgmentblock;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.judgment;

public class FSS_KU_VerifyJudgmentBlock extends AbstractDomainTest {

    @Test(groups = {judgment})
    @LoginAs(key = "fss.user.commercial")
    public void test() {
        loginFss()
                .navigateToLawBasePage()
                .checkJudgmentBlockIsPresent()
                .checkJudgmentKodeksBlockLinksAreWorked();
    }
}
