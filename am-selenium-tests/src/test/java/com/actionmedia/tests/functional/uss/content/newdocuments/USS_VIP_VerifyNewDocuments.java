package com.actionmedia.tests.functional.uss.content.newdocuments;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.autotest.utils.SystemPubs;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.newDocuments;

public class USS_VIP_VerifyNewDocuments extends AbstractDomainTest {

    @Test(groups = {newDocuments})
    @LoginAs(key = "uss.user.vip")
    @Version(section = "doc")
    public void test() {
        loginUss()
                .checkAllNewDocumentsByPubId(SystemPubs.uss_vip);
    }
}
