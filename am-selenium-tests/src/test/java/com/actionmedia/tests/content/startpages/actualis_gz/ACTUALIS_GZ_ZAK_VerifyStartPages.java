package com.actionmedia.tests.content.startpages.actualis_gz;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractContentTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.startpages;

/**
 * User: n.tyukavkin
 * Date: 09.02.14
 * Time: 15:48
 */
public class ACTUALIS_GZ_ZAK_VerifyStartPages extends AbstractContentTest {

    @Test(groups = {startpages})
    public void actualis_gz_zak_test() {
        updateSystemInfo(SystemPubs.actualis_gz);
        updateLoginAsInfo("actualis_gz.user.zak");
        updateLoginToInfo("zakaz");
        checkDocumentFromStartPages(SystemPubs.actualis_gz_zak);
    }
}