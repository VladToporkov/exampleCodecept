package com.actionmedia.tests.content.startpages.umd;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractContentTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.startpages;

/**
 * User: n.tyukavkin
 * Date: 09.02.14
 * Time: 15:48
 */
public class UMD_VIP_VerifyStartPages extends AbstractContentTest {

    @Test(groups = {startpages})
    public void umd_vip_test() {
        updateSystemInfo(SystemPubs.umd);
        updateLoginAsInfo("umd.user.vip");
        updateLoginToInfo("vip");
        checkDocumentFromStartPages(SystemPubs.umd_vip);
    }
}
