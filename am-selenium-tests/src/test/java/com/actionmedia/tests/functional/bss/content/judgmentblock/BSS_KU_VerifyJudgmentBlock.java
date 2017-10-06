package com.actionmedia.tests.functional.bss.content.judgmentblock;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.judgment;

public class BSS_KU_VerifyJudgmentBlock extends AbstractDomainTest {

    @Test(groups = {judgment})
    @LoginAs(key = "bss.user.commercial")
    public void test() {
        loginBss()
                .navigateToLawBasePage()
                .checkJudgmentBlockIsPresent()
                .checkJudgmentKodeksBlockLinksAreWorked();
    }
}
