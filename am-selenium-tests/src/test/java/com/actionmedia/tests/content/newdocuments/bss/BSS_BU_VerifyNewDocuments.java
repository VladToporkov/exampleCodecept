package com.actionmedia.tests.content.newdocuments.bss;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractContentTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.newDocuments;

public class BSS_BU_VerifyNewDocuments extends AbstractContentTest {

    @Test(groups = {newDocuments})
    public void test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        checkAllNewDocumentsByPubId(SystemPubs.bss_bu);
    }
}
