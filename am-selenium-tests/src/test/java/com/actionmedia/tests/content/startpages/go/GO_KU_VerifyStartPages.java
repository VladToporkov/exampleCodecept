package com.actionmedia.tests.content.startpages.go;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractContentTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.startpages;

/**
 * User: n.tyukavkin
 * Date: 09.02.14
 * Time: 15:48
 */
public class GO_KU_VerifyStartPages extends AbstractContentTest {

    @Test(groups = {startpages})
    public void go_ku_test() {
        updateSystemInfo(SystemPubs.go);
        updateLoginAsInfo("go.user.commercial");
        checkDocumentFromStartPages(SystemPubs.go);
    }
}
