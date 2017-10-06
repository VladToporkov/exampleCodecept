package com.actionmedia.tests.functional.kss.content.newdocuments;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.autotest.utils.SystemPubs;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.newDocuments;

public class KSS_KU_VerifyNewDocuments extends AbstractDomainTest {

    @Test(groups = {newDocuments})
    @LoginAs(key = "kss.user.commercial")
    public void test() {
        loginKss()
                .checkAllNewDocumentsByPubId(SystemPubs.kss);
    }
}
