package com.actionmedia.tests.functional.kss.search.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 01.04.2014
 * Time: 11:22
 */
public class KSS_216_VerifySearchOnLawBaseResultIsNotPresent extends AbstractDomainTest {

    @Test(groups = {smoke, inDevelopment})
    @TestLink(testCaseId = "KSS-216", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_216_test() {
        enterToKssWithoutLogin()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .inputTextInSearchField("123")
                .selectTypeByName("Постановление")
                .selectLobbyByName("Министерство здравоохранения РФ")
                .selectRegionByName("Смоленская область")
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkSearchResultOnLawBasePageIsNotPresent()
                .logout();
    }
}
