package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel Popov on 01/10/15.
 */
public class OSS_921_VerifySearchTipsLogic extends AbstractDomainTest {

    private final String query = "закон";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-921", testCaseVersion = "1")
    public void oss_921_test() {
        switch (getNumberOfSystem()) {
            case 0:
                testBss();
                break;
            case 1:
                testKss();
                break;
            case 2:
                testUss();
                break;
            case 3:
                testFss();
                break;
        }
    }

    private void testBss() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется OSS-921:Поисковые подсказки (Логика) БСС КУ");
        loginBss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(query)
                .checkClickKeysInToolTops()
                .navigateToRecomendPage()
                .inputTextInSearchBox(query)
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(query)
                .checkNavigateToLink()

                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(query)
                .checkNavigateToDirectLink()
                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(query)
                .checkNavigateToLinkExtended()
                .logout();
    }

    private void testKss() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется OSS-921:Поисковые подсказки (Логика) КСС КУ");
        loginKss()
                .navigateToAnswersPage()
                .inputTextInSearchBox(query)
                .checkClickKeysInToolTops()
                .inputTextInSearchBox(query)
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(query)
                .checkNavigateToLink()

                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(query)
                .checkNavigateToDirectLink()
                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(query)
                .checkNavigateToLinkExtended()
                .logout();
    }

    private void testUss() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется OSS-921:Поисковые подсказки (Логика) ЮСС КУ");
        loginUss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(query)
                .checkClickKeysInToolTops()
                .inputTextInSearchBox(query)
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(query)
                .checkNavigateToLink()

                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(query)
                .checkNavigateToDirectLink()
                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(query)
                .checkNavigateToLinkExtended()
                .logout();
    }

    private void testFss() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется OSS-921:Поисковые подсказки (Логика) ФСС КУ");
        loginFss()
                .navigateToSolutionsPage()
                .inputTextInSearchBox(query)
                .checkClickKeysInToolTops()
                .inputTextInSearchBox(query)
                .checkNavigateToDirectLink()
                .inputTextInSearchBox(query)
                .checkNavigateToLink()

                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(query)
                .checkNavigateToDirectLink()
                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(query)
                .checkNavigateToLinkExtended()
                .logout();
    }

    private int getNumberOfSystem() {
        return getMultiplicityOfWeekNumber() % 4;
    }
}
