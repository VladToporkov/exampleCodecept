package com.actionmedia.tests.functional.kss.content.judgmentblock;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.judgment;

public class KSS_BU_VerifyJudgmentBlock extends AbstractDomainTest {

    @Test(groups = {judgment})
    @LoginAs(key = "kss.user.budget")
    @Version(section = "budget")
    public void test() {
        loginKss()
                .navigateToLawBasePage()
                .checkJudgmentBlockIsPresent()
                .checkJudgmentKodeksBlockLinksAreWorked();
    }
}
