package com.actionmedia.tests.content.etalons.actualis_gz;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.content;

/**
 * User: n.tyukavkin
 * Date: 14.10.13
 * Time: 11:21
 */
public class ACTUALIS_GZ_VerifyModule145 extends AbstractDomainTest {

    @Test(groups = {content}, invocationCount = 2)
    public void actualis_gz_145_module_test() {
        updateSystemInfo(SystemPubs.actualis_gz);
        updateLoginAsInfo("actualis_gz.user.vip");
        updateLoginToInfo("vip");
        loginElpu()
                .checkContentLinksForModule(getDocumentUrlByKey("actualis_gz.145.module"));
    }
}
