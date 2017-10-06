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
public class UMD_VerifyModule189 extends AbstractDomainTest {

    @Test(groups = {content}, invocationCount = 2)
    public void umd_189_module_test() {
        updateSystemInfo(SystemPubs.umd);
        updateLoginAsInfo("umd.user.vip");
        updateLoginToInfo("vip");
        loginElpu()
                .checkContentLinksForModule(getDocumentUrlByKey("umd.189.module"));
    }
}
