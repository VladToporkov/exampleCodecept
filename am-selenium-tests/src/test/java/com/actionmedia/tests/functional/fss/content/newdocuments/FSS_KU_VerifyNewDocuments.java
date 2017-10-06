package com.actionmedia.tests.functional.fss.content.newdocuments;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.autotest.utils.SystemPubs;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.newDocuments;

public class FSS_KU_VerifyNewDocuments extends AbstractDomainTest {

    @Test(groups = {newDocuments})
    @LoginAs(key = "fss.user.commercial")
    public void test() {
        loginFss()
                .checkAllNewDocumentsByPubId(SystemPubs.fss);
    }
}
