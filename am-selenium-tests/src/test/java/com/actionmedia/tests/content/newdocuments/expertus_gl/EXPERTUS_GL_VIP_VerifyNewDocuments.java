package com.actionmedia.tests.content.newdocuments.expertus_gl;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractContentTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.newDocuments;

/**
 * User: n.tyukavkin
 * Date: 09.02.14
 * Time: 15:48
 */
public class EXPERTUS_GL_VIP_VerifyNewDocuments extends AbstractContentTest {

    @Test(groups = {newDocuments})
    public void expertus_gl_vip_test() {
        updateSystemInfo(SystemPubs.expertus_gl);
        updateLoginAsInfo("expertus_gl.user.vip");
        updateLoginToInfo("vip");
        checkAllNewDocumentsByPubId(SystemPubs.expertus_gl_vip);
    }
}
