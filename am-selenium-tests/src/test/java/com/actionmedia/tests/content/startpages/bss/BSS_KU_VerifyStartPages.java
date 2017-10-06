package com.actionmedia.tests.content.startpages.bss;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractContentTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.startpages;

/**
 * Created by n.tyukavkin on 02.10.2016.
 */
public class BSS_KU_VerifyStartPages extends AbstractContentTest {

    @Test(groups = {startpages})
    public void bss_ku_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        checkDocumentFromStartPages(SystemPubs.bss);
    }
}
