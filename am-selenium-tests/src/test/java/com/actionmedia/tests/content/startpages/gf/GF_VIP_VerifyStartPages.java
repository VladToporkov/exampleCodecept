package com.actionmedia.tests.content.startpages.gf;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractContentTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.startpages;

/**
 * User: n.tyukavkin
 * Date: 09.02.14
 * Time: 15:48
 */
public class GF_VIP_VerifyStartPages extends AbstractContentTest {

    @Test(groups = {startpages})
    public void gf_vip_test() {
        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.vip");
        updateLoginToInfo("vip");
        checkDocumentFromStartPages(SystemPubs.gf_vip);
    }
}
