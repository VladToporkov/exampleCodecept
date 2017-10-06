package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel Popov on 01/10/15.
 */
public class OSS_929_VerifySearchTipsFss extends AbstractDomainTest {

    private static final String query = "вы";
    private static final String queryLaw = "налог";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-929", testCaseVersion = "1")
    public void oss_929_test() {
        //step 1
        updateSystemInfo(SystemPubs.fss);
        report("Проверяется OSS-929:Поисковые подсказки (отображение) ФСС КУ");
        enterToFssWithoutLogin()
                .navigateToSolutionsPage()
                .inputTextInSearchBox(query)
                .checkSearchStraightTip();

        updateSystemInfo(SystemPubs.fss);
        report("Проверяется OSS-929:Поисковые подсказки (отображение) Правовая база ФСС КУ");
        enterToFssWithoutLogin()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(queryLaw)
                .checkSearchStraightTip();
    }
}
