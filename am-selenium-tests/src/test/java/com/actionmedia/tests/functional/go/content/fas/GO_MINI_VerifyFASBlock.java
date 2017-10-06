package com.actionmedia.tests.functional.go.content.fas;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.fas;

public class GO_MINI_VerifyFASBlock extends AbstractDomainTest {

    @Test(groups = {fas})
    public void go_mini_fas_blocks_test() {
        updateSystemInfo(SystemPubs.go);
        updateLoginAsInfo("go.user.mini");
        updateLoginToInfo("mini");
        loginGo()
                .navigateToLawBasePage()
                .checkFASBlocksArePresent()
                .checkFASBlockLinksAreWorked()
                .logout();
    }
}
