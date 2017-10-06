package com.actionmedia.tests.functional.oss.warningpanel;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inTesting;

/**
 * Created by Pavel Popov on 30/09/15.
 */
public class OSS_1007_WarningPanelShareWithColleague extends AbstractDomainTest {

    private final String documentBss = "#/document/140/12594/";
    private final String documentBssBu = "#/document/11/42634/";
    private final String documentKssVIP = "#/document/130/51306/";
    private final String documentUss = "#/documentvideo/145/2757/";

    @Test(groups = {inTesting})
    @TestLink(testCaseId = "OSS-1007", testCaseVersion = "2")
    public void oss_1007_test() {

    }

    private int getNumberOfSystem() {
        return getMultiplicityOfWeekNumber() % 4;
    }
}
