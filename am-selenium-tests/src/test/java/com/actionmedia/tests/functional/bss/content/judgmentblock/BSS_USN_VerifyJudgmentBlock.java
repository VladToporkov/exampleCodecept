package com.actionmedia.tests.functional.bss.content.judgmentblock;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.judgment;

public class BSS_USN_VerifyJudgmentBlock extends AbstractDomainTest {

    @Test(groups = {judgment})
    @LoginAs(key = "bss.user.usn")
    @Version(section = "usn")
    public void test() {
        loginBss()
                .navigateToLawBasePage()
                .checkJudgmentBlockIsPresent()
                .checkJudgmentKodeksBlockLinksAreWorked();
    }
}
