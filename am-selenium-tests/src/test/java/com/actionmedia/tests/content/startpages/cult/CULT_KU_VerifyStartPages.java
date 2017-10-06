package com.actionmedia.tests.content.startpages.cult;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractContentTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.startpages;

/**
 * User: n.tyukavkin
 * Date: 09.02.14
 * Time: 15:48
 */
public class CULT_KU_VerifyStartPages extends AbstractContentTest {

    @Test(groups = {startpages})
    public void cult_ku_test() {
        updateSystemInfo(SystemPubs.cult);
        updateLoginAsInfo("cult.user.commercial");
        checkDocumentFromStartPages(SystemPubs.cult);
    }
}
