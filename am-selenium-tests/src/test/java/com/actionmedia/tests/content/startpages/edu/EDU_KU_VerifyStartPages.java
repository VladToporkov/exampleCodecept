package com.actionmedia.tests.content.startpages.edu;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractContentTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.startpages;

/**
 * User: n.tyukavkin
 * Date: 09.02.14
 * Time: 15:48
 */
public class EDU_KU_VerifyStartPages extends AbstractContentTest {

    @Test(groups = {startpages})
    public void edu_ku_test() {
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.commercial");
        checkDocumentFromStartPages(SystemPubs.edu);
    }
}
