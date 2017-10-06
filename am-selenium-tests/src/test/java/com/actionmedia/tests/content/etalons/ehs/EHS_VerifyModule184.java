package com.actionmedia.tests.content.etalons.ehs;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.content;

/**
 * User: n.tyukavkin
 * Date: 14.10.13
 * Time: 11:21
 */
public class EHS_VerifyModule184 extends AbstractDomainTest {

    @Test(groups = {content}, invocationCount = 2)
    public void ot_184_module_test() {
        updateSystemInfo(SystemPubs.ehs);
        updateLoginAsInfo("ehs.user.commercial");
        loginOT()
                .checkContentLinksForModule(getDocumentUrlByKey("ot.184.module"));
    }
}
