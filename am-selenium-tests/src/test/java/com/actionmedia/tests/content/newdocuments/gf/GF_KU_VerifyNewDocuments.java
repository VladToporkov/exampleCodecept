package com.actionmedia.tests.content.newdocuments.gf;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractContentTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.newDocuments;

/**
 * User: n.tyukavkin
 * Date: 09.02.14
 * Time: 15:48
 */
public class GF_KU_VerifyNewDocuments extends AbstractContentTest {

    @Test(groups = {newDocuments})
    public void gf_ku_test() {
        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        checkAllNewDocumentsByPubId(SystemPubs.gf);
    }
}