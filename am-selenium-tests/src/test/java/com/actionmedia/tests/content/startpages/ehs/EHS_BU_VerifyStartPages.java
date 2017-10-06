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
public class EHS_BU_VerifyStartPages extends AbstractContentTest {

    @Test(groups = {startpages})
    public void ehs_bu_test() {
        updateSystemInfo(SystemPubs.ehs);
        updateLoginAsInfo("ehs.user.budget");
        updateLoginToInfo("budget");
        checkDocumentFromStartPages(SystemPubs.ehs_bu);
    }
}
