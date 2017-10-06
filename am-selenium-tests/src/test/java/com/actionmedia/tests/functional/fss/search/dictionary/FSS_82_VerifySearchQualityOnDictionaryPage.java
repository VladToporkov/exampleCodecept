package com.actionmedia.tests.functional.fss.search.dictionary;

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
public class FSS_82_VerifySearchQualityOnDictionaryPage extends AbstractDomainTest {

    private static final String QUERY = "расчет свободного денежного потока";
    private static final String DOCUMENT = "Расчет свободного денежного потока прямым методом";

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "FSS-82", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_82_test() {
        loginFss()
                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonFss()
                .checkSearchResultOnDictionaryPageIsOpened()
                .checkDocumentWithTextIsPresent(DOCUMENT);
    }
}
