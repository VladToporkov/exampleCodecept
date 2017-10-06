package com.actionmedia.tests.content.newdocuments.kss;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractContentTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.newDocuments;

/**
 * User: n.tyukavkin
 * Date: 09.02.14
 * Time: 15:48
 */
public class KSS_BU_VerifyNewDocuments extends AbstractContentTest {

    @Test(groups = {newDocuments})
    public void kss_budget_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        checkAllNewDocumentsByPubId(SystemPubs.kss_bu);
    }
}
