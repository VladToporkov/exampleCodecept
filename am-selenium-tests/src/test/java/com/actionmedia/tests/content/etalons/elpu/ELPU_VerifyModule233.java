package com.actionmedia.tests.content.etalons.elpu;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.content;

/**
 * User: n.tyukavkin
 * Date: 14.10.13
 * Time: 11:21
 */
public class ELPU_VerifyModule233 extends AbstractDomainTest {

    @Test(groups = {content}, invocationCount = 2)
    public void elpu_233_module_test() {
        updateSystemInfo(SystemPubs.elpu);
        updateLoginAsInfo("elpu.user.vip");
        updateLoginToInfo("vip");
        loginElpu()
                .checkContentLinksForModule(getDocumentUrlByKey("elpu.233.module"));
    }
}