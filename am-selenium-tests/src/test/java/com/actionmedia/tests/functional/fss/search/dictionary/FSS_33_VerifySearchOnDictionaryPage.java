package com.actionmedia.tests.functional.fss.search.dictionary;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 14.11.13
 * Time: 16:48
 */
public class FSS_33_VerifySearchOnDictionaryPage extends AbstractDomainTest {

    private static final String QUERY = "расчет свободного денежного потока";
    private static final String DOCUMENT = "Расчет свободного денежного потока прямым методом";

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-33", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_33_test() {
        loginFss()
                .navigateToDictionaryPage()
                .checkSearchBoxPresentOnDictionaryPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonFss()
                .checkSearchResultOnDictionaryPageIsOpened()
                .checkDocumentWithTextIsPresent(DOCUMENT);
    }
}
