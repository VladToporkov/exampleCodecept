package com.actionmedia.tests.content.startpages.bss;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractContentTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.startpages;

/**
 * User: n.tyukavkin
 * Date: 09.02.14
 * Time: 15:48
 */
public class BSS_USN_VerifyStartPages extends AbstractContentTest {

    @Test(groups = {startpages})
    public void bss_usn_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        checkDocumentFromStartPages(SystemPubs.bss_usn);
    }
}
