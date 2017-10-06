package com.actionmedia.tests.functional.go.content.fas;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.fas;

public class GO_VIP_VerifyFASBlock extends AbstractDomainTest {

    @Test(groups = {fas})
    public void go_vip_fas_blocks_test() {
        updateSystemInfo(SystemPubs.go);
        updateLoginAsInfo("go.user.commercial");
        updateLoginToInfo("vip");
        loginGo()
                .navigateToLawBasePage()
                .checkFASBlocksArePresent()
                .checkFASBlockLinksAreWorked()
                .logout();
    }
}
