package com.actionmedia.tests.functional.bss.content.newdocuments;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.autotest.utils.SystemPubs;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.newDocuments;

public class BSS_VIP_VerifyNewDocuments extends AbstractDomainTest {

    @Test(groups = {newDocuments})
    @LoginAs(key = "bss.user.vip")
    @Version(section = "vip")
    public void test() {
        loginBss()
                .checkAllNewDocumentsByPubId(SystemPubs.bss_vip);
    }
}
