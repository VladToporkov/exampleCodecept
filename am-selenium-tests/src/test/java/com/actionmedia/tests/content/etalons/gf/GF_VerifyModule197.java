package com.actionmedia.tests.content.etalons.gf;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.content;

/**
 * User: n.tyukavkin
 * Date: 14.10.13
 * Time: 11:21
 */
public class GF_VerifyModule197 extends AbstractDomainTest {

    @Test(groups = {content}, invocationCount = 2)
    public void gf_197_module_test() {
        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        loginGF()
                .checkContentLinksForModule(getDocumentUrlByKey("gf.197.module"));
    }
}
