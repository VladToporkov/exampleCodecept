package com.actionmedia.tests.content.newdocuments.actualis_k;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractContentTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.newDocuments;

/**
 * User: n.tyukavkin
 * Date: 09.02.14
 * Time: 15:48
 */
public class ACTUALIS_K_MINI_VerifyNewDocuments extends AbstractContentTest {

    @Test(groups = {newDocuments})
    public void actualis_k_mini_test() {
        updateSystemInfo(SystemPubs.actualis_k);
        updateLoginAsInfo("actualis_k.user.mini");
        updateLoginToInfo("mini");
        checkAllNewDocumentsByPubId(SystemPubs.actualis_k_mini);
    }
}
