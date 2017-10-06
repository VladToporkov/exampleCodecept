package com.actionmedia.tests.content.etalons.umd;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.content;

/**
 * User: n.tyukavkin
 * Date: 14.10.13
 * Time: 11:21
 */
public class UMD_VerifyModule190 extends AbstractDomainTest {

    @Test(groups = {content}, invocationCount = 2)
    public void umd_190_module_test() {
        updateSystemInfo(SystemPubs.umd);
        updateLoginAsInfo("umd.user.commercial");
        loginElpu()
                .checkContentLinksForModule(getDocumentUrlByKey("umd.190.module"));
    }
}
