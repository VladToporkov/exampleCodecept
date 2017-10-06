package com.actionmedia.tests.content.newdocuments.umd;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractContentTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.newDocuments;

/**
 * User: n.tyukavkin
 * Date: 09.02.14
 * Time: 15:48
 */
public class UMD_MINI_VerifyNewDocuments extends AbstractContentTest {

    @Test(groups = {newDocuments})
    public void umd_mini_test() {
        updateSystemInfo(SystemPubs.umd);
        updateLoginAsInfo("umd.user.mini");
        updateLoginToInfo("mini");
        checkAllNewDocumentsByPubId(SystemPubs.umd_mini);
    }
}
