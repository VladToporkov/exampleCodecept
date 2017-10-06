package com.actionmedia.tests.content.startpages.expertus_gl;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractContentTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.startpages;

/**
 * User: n.tyukavkin
 * Date: 09.02.14
 * Time: 15:48
 */
public class EXPERTUS_GL_VIP_VerifyStartPages extends AbstractContentTest {

    @Test(groups = {startpages})
    public void expertus_gl_vip_test() {
        updateSystemInfo(SystemPubs.expertus_gl);
        updateLoginAsInfo("expertus_gl.user.vip");
        updateLoginToInfo("vip");
        checkDocumentFromStartPages(SystemPubs.expertus_gl_vip);
    }
}
