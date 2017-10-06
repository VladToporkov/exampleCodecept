package com.actionmedia.tests.content.etalons.edu;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.content;

/**
 * User: n.tyukavkin
 * Date: 14.10.13
 * Time: 11:21
 */
public class EDU_VerifyModule95 extends AbstractDomainTest {

    @Test(groups = {content}, invocationCount = 2)
    public void edu_95_module_test() {
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.commercial");
        loginEdu()
                .checkContentLinksForModule(getDocumentUrlByKey("edu.95.module"));
    }
}
