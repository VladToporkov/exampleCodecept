package com.actionmedia.tests.content.startpages.ehs;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractContentTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.startpages;

/**
 * User: n.tyukavkin
 * Date: 09.02.14
 * Time: 15:48
 */
public class EHS_MINI_VerifyStartPages extends AbstractContentTest {

    @Test(groups = {startpages})
    public void ehs_mini_test() {
        updateSystemInfo(SystemPubs.ehs);
        updateLoginAsInfo("ehs.user.mini");
        updateLoginToInfo("mini");
        checkDocumentFromStartPages(SystemPubs.ehs_mini);
    }
}
