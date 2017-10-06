package com.actionmedia.tests.content.newdocuments.elpu;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractContentTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.newDocuments;

/**
 * User: n.tyukavkin
 * Date: 09.02.14
 * Time: 15:48
 */
public class ELPU_KU_VerifyNewDocuments extends AbstractContentTest {

    @Test(groups = {newDocuments})
    public void elpu_ku_test() {
        updateSystemInfo(SystemPubs.elpu);
        updateLoginAsInfo("elpu.user.commercial");
        checkAllNewDocumentsByPubId(SystemPubs.elpu);
    }
}
