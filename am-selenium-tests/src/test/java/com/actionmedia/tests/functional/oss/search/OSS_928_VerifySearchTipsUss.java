package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel Popov on 01/10/15.
 */
public class OSS_928_VerifySearchTipsUss extends AbstractDomainTest {

    private static final String query = "вы";
    private static final String queryLaw = "налог";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-928", testCaseVersion = "1")
    public void oss_928_test() {
        //step 1
        updateSystemInfo(SystemPubs.uss);
        report("Проверяется OSS-928:Поисковые подсказки (отображение) ЮСС КУ");
        enterToUssWithoutLogin()
                .navigateToRecomendPage()
                .inputTextInSearchBox(query)
                .checkSearchStraightTip();

        updateSystemInfo(SystemPubs.uss);
        updateLoginToInfo("doc");
        report("Проверяется OSS-928:Поисковые подсказки (отображение) ЮСС ВИП");
        enterToUssWithoutLogin()
                .navigateToRecomendPage()
                .inputTextInSearchBox(query)
                .checkSearchStraightTip();

        //step 2
        updateSystemInfo(SystemPubs.uss);
        report("Проверяется OSS-928:Поисковые подсказки (отображение) Правовая база ЮСС КУ");
        enterToUssWithoutLogin()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(queryLaw)
                .checkSearchStraightTip();

        updateSystemInfo(SystemPubs.uss);
        updateLoginToInfo("doc");
        report("Проверяется OSS-928:Поисковые подсказки (отображение) Правовая база ЮСС ВИП");
        enterToUssWithoutLogin()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(queryLaw)
                .checkSearchStraightTip();
    }
}
