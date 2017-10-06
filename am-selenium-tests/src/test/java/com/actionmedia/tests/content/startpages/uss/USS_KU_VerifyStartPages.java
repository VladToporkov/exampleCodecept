package com.actionmedia.tests.content.startpages.uss;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractContentTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.startpages;

/**
 * User: n.tyukavkin
 * Date: 09.02.14
 * Time: 15:48
 */
public class USS_KU_VerifyStartPages extends AbstractContentTest {

    @Test(groups = {startpages})
    public void uss_ku_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        checkDocumentFromStartPages(SystemPubs.uss);
    }
}
