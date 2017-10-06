package com.actionmedia.tests.content.etalons.expertus_gl;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.content;

/**
 * User: n.tyukavkin
 * Date: 14.10.13
 * Time: 11:21
 */
public class EXPERTUS_GL_VerifyModule189 extends AbstractDomainTest {

    @Test(groups = {content}, invocationCount = 2)
    public void expertus_gl_189_module_test() {
        updateSystemInfo(SystemPubs.expertus_gl);
        updateLoginAsInfo("expertus_gl.user.commercial");
        loginElpu()
                .checkContentLinksForModule(getDocumentUrlByKey("expertus_gl.189.module"));
    }
}
