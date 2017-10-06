package com.actionmedia.tests.content.newdocuments.expertus_k;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractContentTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.newDocuments;

/**
 * User: n.tyukavkin
 * Date: 09.02.14
 * Time: 15:48
 */
public class EXPERTUS_K_KU_VerifyNewDocuments extends AbstractContentTest {

    @Test(groups = {newDocuments})
    public void expertus_k_ku_test() {
        updateSystemInfo(SystemPubs.expertus_k);
        updateLoginAsInfo("expertus_k.user.commercial");
        checkAllNewDocumentsByPubId(SystemPubs.expertus_k);
    }
}
