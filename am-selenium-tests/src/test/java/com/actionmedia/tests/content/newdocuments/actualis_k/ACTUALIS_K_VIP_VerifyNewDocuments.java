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
public class ACTUALIS_K_VIP_VerifyNewDocuments extends AbstractContentTest {

    @Test(groups = {newDocuments})
    public void actualis_k_vip_test() {
        updateSystemInfo(SystemPubs.actualis_k);
        updateLoginAsInfo("actualis_k.user.vip");
        updateLoginToInfo("vip");
        checkAllNewDocumentsByPubId(SystemPubs.actualis_k_vip);
    }
}
