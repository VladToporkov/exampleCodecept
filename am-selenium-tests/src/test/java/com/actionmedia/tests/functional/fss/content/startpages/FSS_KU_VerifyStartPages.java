package com.actionmedia.tests.functional.fss.content.startpages;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.autotest.utils.SystemPubs;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.startpages;

/**
 * User: n.tyukavkin
 * Date: 09.02.14
 * Time: 15:48
 */
public class FSS_KU_VerifyStartPages extends AbstractDomainTest {

    @Test(groups = {startpages})
    @LoginAs(key = "fss.user.commercial")
    public void fss_ku_test() {
        loginFss()
                .checkDocumentFromStartPages(SystemPubs.fss);
    }
}
