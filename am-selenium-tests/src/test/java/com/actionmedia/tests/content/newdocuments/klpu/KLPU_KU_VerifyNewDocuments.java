package com.actionmedia.tests.content.newdocuments.klpu;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractContentTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.newDocuments;

/**
 * User: n.tyukavkin
 * Date: 09.02.14
 * Time: 15:48
 */
public class KLPU_KU_VerifyNewDocuments extends AbstractContentTest {

    @Test(groups = {newDocuments})
    public void klpu_ku_test() {
        updateSystemInfo(SystemPubs.klpu);
        updateLoginAsInfo("klpu.user.commercial");
        checkAllNewDocumentsByPubId(SystemPubs.klpu);
    }
}
