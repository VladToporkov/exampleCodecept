package com.actionmedia.tests.content.startpages.klpu;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractContentTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.startpages;

/**
 * User: n.tyukavkin
 * Date: 09.02.14
 * Time: 15:48
 */
public class KLPU_VIP_VerifyStartPages extends AbstractContentTest {

    @Test(groups = {startpages})
    public void klpu_vip_test() {
        updateSystemInfo(SystemPubs.klpu);
        updateLoginAsInfo("klpu.user.vip");
        updateLoginToInfo("vip");
        checkDocumentFromStartPages(SystemPubs.klpu_vip);
    }
}
