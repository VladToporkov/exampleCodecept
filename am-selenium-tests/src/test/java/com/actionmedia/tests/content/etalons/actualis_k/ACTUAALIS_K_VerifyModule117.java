package com.actionmedia.tests.content.etalons.actualis_k;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.content;

/**
 * User: n.tyukavkin
 * Date: 14.10.13
 * Time: 11:21
 */
public class ACTUAALIS_K_VerifyModule117 extends AbstractDomainTest {

    @Test(groups = {content}, invocationCount = 2)
    public void actualis_k_117_module_test() {
        updateSystemInfo(SystemPubs.actualis_k);
        updateLoginAsInfo("actualis_k.user.commercial");
        loginElpu()
                .checkContentLinksForModule(getDocumentUrlByKey("actualis_k.117.module"));
    }
}
