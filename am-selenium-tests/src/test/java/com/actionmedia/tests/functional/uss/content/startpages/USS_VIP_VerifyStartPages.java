package com.actionmedia.tests.functional.uss.content.startpages;

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
public class USS_VIP_VerifyStartPages extends AbstractDomainTest {

    @Test(groups = {startpages})
    @LoginAs(key = "uss.user.vip")
    @Version(section = "doc")
    public void uss_doc_test() {
        loginUss()
                .checkDocumentFromStartPages(SystemPubs.uss_vip);
    }
}
