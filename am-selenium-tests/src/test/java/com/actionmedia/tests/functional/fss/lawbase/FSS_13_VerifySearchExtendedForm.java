package com.actionmedia.tests.functional.fss.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 15.11.13
 * Time: 16:00
 */
public class FSS_13_VerifySearchExtendedForm extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-13", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_13_test() {
        loginFss()
                .navigateToLawBasePage()
                .clickExtendedFormButton()
                .checkElementsInExtendedFormArePresent()
                .checkDefaultStateForElementsInExtendedSearchForm()
                .checkFirstElementsAreHighlightedInExtendedForm()
                .checkSortingInExtendedForm();
    }
}
