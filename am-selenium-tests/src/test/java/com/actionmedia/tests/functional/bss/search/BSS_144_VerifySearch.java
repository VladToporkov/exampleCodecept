package com.actionmedia.tests.functional.bss.search;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 22.10.13
 * Time: 14:40
 */
public class BSS_144_VerifySearch extends AbstractDomainTest {

    private static final String QUERY = "документ";

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-144", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_144_test() {
        loginBss()
                .navigateToRecomendPage()
                .checkTextInputInSearchBox()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnRecomendPageIsOpened()

                .clickLawBaseFilter()
                .checkSearchResultOnLawBasePageIsOpened(true)

                .clickFormsFilter()
                .checkSearchResultOnFormsPageIsOpened()

                .clickDictionaryFilter()
                .checkSearchResultOnDictionaryPageIsOpened()

                .clickMagazinesFilter()
                .checkSearchResultOnMagazinesPageIsOpened()

                .clickVideoFilter()
                .checkSearchResultOnVideosPageIsOpened()
                .logout();
    }
}
