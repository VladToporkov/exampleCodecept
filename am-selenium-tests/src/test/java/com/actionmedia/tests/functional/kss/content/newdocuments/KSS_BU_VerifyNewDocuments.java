package com.actionmedia.tests.functional.kss.content.newdocuments;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.autotest.utils.SystemPubs;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.newDocuments;

public class KSS_BU_VerifyNewDocuments extends AbstractDomainTest {

    @Test(groups = {newDocuments})
    @LoginAs(key = "kss.user.budget")
    @Version(section = "budget")
    public void test() {
        loginKss()
                .checkAllNewDocumentsByPubId(SystemPubs.kss_bu);
    }
}
