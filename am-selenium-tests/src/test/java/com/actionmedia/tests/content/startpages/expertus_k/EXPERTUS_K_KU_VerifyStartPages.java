package com.actionmedia.tests.content.startpages.expertus_k;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractContentTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.startpages;

/**
 * User: n.tyukavkin
 * Date: 09.02.14
 * Time: 15:48
 */
public class EXPERTUS_K_KU_VerifyStartPages extends AbstractContentTest {

    @Test(groups = {startpages})
    public void expertus_k_ku_test() {
        updateSystemInfo(SystemPubs.expertus_k);
        updateLoginAsInfo("expertus_k.user.commercial");
        checkDocumentFromStartPages(SystemPubs.expertus_k);
    }
}
