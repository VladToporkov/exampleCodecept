package com.actionmedia.tests.functional.oss;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.selenium.SeleniumHolder;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.apache.commons.collections.list.SetUniqueList;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.Test;

import java.util.*;

import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 28.09.14
 * Time: 15:48
 */
public class OSS_341_AutoReplacementPublicationBlock extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-341", testCaseVersion = "1")
    public void oss_341_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        loginBss()
                .checkPublicationBlockInDocuments();

        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        loginKss()
                .checkPublicationBlockInDocuments();

        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        loginUss()
                .checkPublicationBlockInDocuments();
    }

}
