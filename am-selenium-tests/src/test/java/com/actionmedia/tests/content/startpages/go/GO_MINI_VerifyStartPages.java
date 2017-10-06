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
public class GO_MINI_VerifyStartPages extends AbstractContentTest {

    @Test(groups = {startpages})
    public void go_mini_test() {
        updateSystemInfo(SystemPubs.go);
        updateLoginAsInfo("go.user.mini");
        updateLoginToInfo("mini");
        checkDocumentFromStartPages(SystemPubs.go_mini);
    }
}
