package com.actionmedia.tests.functional.kss.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 01.04.2014
 * Time: 12:17
 */
public class KSS_85_VerifyRedactionVersion extends AbstractDomainTest {

    private static final String ACTUAL_SECOND = "/#/document/99/499019335/";
    private static final String EXPIRE = "/#/document/99/902262807/";
    private static final String FUTURE = "/#/document/97/57099/";

    @Test(groups = {smoke, inDevelopment})
    @TestLink(testCaseId = "KSS-85", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_85_test() {
        String baseUrl = "http://" + getSettings().getHost();
        loginKss()
                .openDocumentByUrl(baseUrl + ACTUAL_SECOND)
                .checkDocumentVersionIsPresent()
                .checkActualVersionIsPresent()

                .openDocumentByUrl(baseUrl + EXPIRE)
                .checkDocumentVersionIsPresent()
                .checkExpiredWarningIsPresent()

                .openDocumentByUrl(baseUrl + FUTURE)
                .checkDocumentVersionIsPresent()
                .checkFutureWarningIsPresent()
                .logout();
    }
}
