package com.actionmedia.tests.functional.oss.headers;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;


/**
 * User: n.leontieva
 * Date: 27.01.16
 */
public class OSS_1014_npdHeaders extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1014", testCaseVersion = "1")
    public void oss_1014_test() {
        //Перейти в раздел НПД, открыть любой кодекс и пролистать вниз до сворачивания шапки.
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        loginBss()
                .navigateToLawBasePage()
                .navigateToDocumentPage()
                .scrollToEnd()

                //Нажать "еще".
                .clickMoreButtonOnMainPanel()
                .checkMenuIsOpened()

                //Нажать "По реквизитам".
                .clickRequisite()
                .checkRequisite()

                //Нажать "Свернуть".
                .clickRequisite()

                .сheckRollUp()
                .logout();

        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        loginUss()
                .navigateToLawBasePage()
                .navigateToDocumentPage()
                .scrollToEnd()

                //Нажать "еще".
                .clickMoreButtonOnMainPanel()
                .checkMenuIsOpened()

                //Нажать "По реквизитам".
                .clickRequisite()
                .checkRequisite()

                //Нажать "Свернуть".
                .clickRequisite()
                .сheckRollUp()
                .logout();

        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        loginKss()
                .navigateToLawBasePage()
                .navigateToDocumentPage()
                .scrollToEnd()

                //Нажать "еще".
                .clickMoreButtonOnMainPanel()
                .checkMenuIsOpened()

                //Нажать "По реквизитам".
                .clickRequisite()
                .checkRequisite()

                //Нажать "Свернуть".
                .clickRequisite()
                .сheckRollUp()
                .logout();

        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        loginFss()
                .navigateToLawBasePage()
                .navigateToDocumentPage()
                .scrollToEnd()

                //Нажать "еще".
                .clickMoreButtonOnMainPanel()
                .checkMenuIsOpened()

                //Нажать "По реквизитам".
                .clickRequisite()
                .checkRequisite()

                //Нажать "Свернуть".
                .clickRequisite()
                .сheckRollUp()
                .logout();
    }
}