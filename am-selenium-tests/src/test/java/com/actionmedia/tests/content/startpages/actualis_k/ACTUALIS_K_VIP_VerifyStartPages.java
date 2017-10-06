package com.actionmedia.tests.content.startpages.actualis_k;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractContentTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.startpages;

/**
 * User: n.tyukavkin
 * Date: 09.02.14
 * Time: 15:48
 */
public class ACTUALIS_K_VIP_VerifyStartPages extends AbstractContentTest {

    @Test(groups = {startpages})
    public void actualis_k_vip_test() {
        updateSystemInfo(SystemPubs.actualis_k);
        updateLoginAsInfo("actualis_k.user.vip");
        updateLoginToInfo("vip");
        checkDocumentFromStartPages(SystemPubs.actualis_k_vip);
    }
}
