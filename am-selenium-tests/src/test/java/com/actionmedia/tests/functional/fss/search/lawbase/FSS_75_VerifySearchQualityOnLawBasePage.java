package com.actionmedia.tests.functional.fss.search.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 28.04.2014
 * Time: 13:25
 */
public class FSS_75_VerifySearchQualityOnLawBasePage extends AbstractDomainTest {

    private static final String QUERY = "учетная политика";
    private static final String DOCUMENT = "ПРИКАЗ, ПБУ МИНФИНА РОССИИ от 06.10.2008 №№ 106н, ПБУ1/2008, ПБУ21/2008 Об утверждении положений по бухгалтерскому учету";

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "FSS-75", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_75_test() {
        loginFss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonFss()
                .checkSearchResultOnLawBasePageIsOpenedBoolean(false)
                .checkDocumentWithTextIsPresent(DOCUMENT);
    }
}
