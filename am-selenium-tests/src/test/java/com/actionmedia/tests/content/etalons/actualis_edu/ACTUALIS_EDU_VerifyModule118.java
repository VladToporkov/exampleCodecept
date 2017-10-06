package com.actionmedia.tests.content.etalons.actualis_edu;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.content;

/**
 * User: n.tyukavkin
 * Date: 14.10.13
 * Time: 11:21
 */
public class ACTUALIS_EDU_VerifyModule118 extends AbstractDomainTest {

    @Test(groups = {content}, invocationCount = 2)
    public void actualis_edu_118_module_test() {
        updateSystemInfo(SystemPubs.actualis_edu);
        updateLoginAsInfo("actualis_edu.user.commercial");
        loginElpu()
                .checkContentLinksForModule(getDocumentUrlByKey("actualis_edu.118.module"));
    }
}
