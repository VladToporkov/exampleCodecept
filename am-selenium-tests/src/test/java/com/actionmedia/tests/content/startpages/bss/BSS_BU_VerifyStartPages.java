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
public class BSS_BU_VerifyStartPages extends AbstractContentTest {

    @Test(groups = {startpages})
    public void bss_budget_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        checkDocumentFromStartPages(SystemPubs.bss_bu);
    }
}
