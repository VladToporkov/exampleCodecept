package com.actionmedia.tests.content.etalons.go;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.content;

/**
 * User: n.tyukavkin
 * Date: 14.10.13
 * Time: 11:21
 */
public class GO_VerifyModule113 extends AbstractDomainTest {

    @Test(groups = {content}, invocationCount = 2)
    public void go_113_module_test() {
        updateSystemInfo(SystemPubs.go);
        updateLoginAsInfo("go.user.commercial");
        loginElpu()
                .checkContentLinksForModule(getDocumentUrlByKey("go.113.module"));
    }
}
