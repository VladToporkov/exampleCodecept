package com.actionmedia.tests.functional.bss.content.startpages;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.autotest.utils.SystemPubs;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.startpages;

/**
 * User: n.tyukavkin
 * Date: 09.02.14
 * Time: 15:48
 */
public class BSS_BU_VerifyStartPages extends AbstractDomainTest {

    @Test(groups = {startpages})
    @LoginAs(key = "bss.user.budget")
    @Version(section = "budget")
    public void bss_budget_test() {
        loginBss()
                .checkDocumentFromStartPages(SystemPubs.bss_bu);
    }
}
