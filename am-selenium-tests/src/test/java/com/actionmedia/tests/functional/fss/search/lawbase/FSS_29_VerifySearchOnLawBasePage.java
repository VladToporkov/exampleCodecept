package com.actionmedia.tests.functional.fss.search.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 15.11.13
 * Time: 09:48
 */
public class FSS_29_VerifySearchOnLawBasePage extends AbstractDomainTest {

    private static final String QUERY = "учетная политика";
    private static final String DOCUMENT = "ПРИКАЗ, ПБУ МИНФИНА РОССИИ от 06.10.2008 №№ 106н, ПБУ1/2008, ПБУ21/2008 " +
            "Об утверждении положений по бухгалтерскому учету";

    private static final String QUERY_WITH_TAG = "плата за образование ребенка";
    private static final String DOCUMENT_WITH_TAG = "ПИСЬМО ФНС РОССИИ от 17.09.2009 № ШС-22-3/719 " +
            "По вопросу освобождения от налогообложения компенсации части родительской платы за содержание ребенка в образовательных учреждениях";

    private static final String FILTER_NAME = "ФНС";

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-29", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_29_test() {
        loginFss()
                .navigateToLawBasePage()
                .checkSearchBoxPresentOnLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonFss()
                .checkSearchResultOnLawBasePageIsOpenedBoolean(false)
                .checkDocumentWithTextIsPresent(DOCUMENT)

                .inputTextInSearchBox(QUERY_WITH_TAG)
                .clickSearchButtonFss()
                .checkSearchResultOnLawBasePageIsOpenedBoolean(false)
                .clickFilterByName(FILTER_NAME)
                .checkDocumentWithTextIsPresent(DOCUMENT_WITH_TAG);
    }
}
