package com.actionmedia.tests.content.startpages.kss;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractContentTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.startpages;

/**
 * User: n.tyukavkin
 * Date: 09.02.14
 * Time: 15:48
 */
public class KSS_BU_VerifyStartPages extends AbstractContentTest {

    @Test(groups = {startpages})
    public void kss_budget_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        checkDocumentFromStartPages(SystemPubs.kss_bu);
    }
}
