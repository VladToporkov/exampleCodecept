package com.actionmedia.tests.functional.fss.mainpage;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 30.04.2014
 * Time: 11:18
 */
public class FSS_150_VerifyAccessList extends AbstractDomainTest {

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "FSS-150", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_150_test() {
        loginFss()
                .navigateToPersonalCabinetPage()
                .clickAccessListTabInCollapsed()
                .openRandomItemInAccessList()
                .checkAccessInfoInCollapsedIsDisplayed()
                .closeRandomItemInAccessList()
                .checkAccessInfoIsCollapsedNotDisplayed()

                .openRandomItemInAccessList()
                .checkAccessInfoInCollapsedContainsValue("Период действия")
                .checkAccessInfoInCollapsedContainsValue("Оплаченный доступ")
                .checkAccessInfoInCollapsedContainsValue("Количество лицензий")

                .clickViewedTabInCollapsed()
                .checkViewedTabInCollapsedIsOpened()
                .checkViewedTabInCollapsedIsNotEmpty()

                .clickExtendPopularBlock()
                .clickAccessListTabInExpanded()
                .checkAccessInfoInExpandedIsDisplayed()
                .checkAccessInfoInExpandedContainsValue("Доступ к материалам")
                .checkAccessInfoInExpandedContainsValue("Период доступа")
                .checkAccessInfoInExpandedContainsValue("Тип доступа")
                .checkAccessInfoInExpandedContainsValue("Количество лицензий")

                .clickViewedTabInExpanded()
                .checkViewedTabInExpandedIsOpened()
                .checkActiveTabInExpandedIsNotEmpty()

                .closePopularBlock()
                .checkViewedTabInCollapsedIsOpened()
                .checkViewedTabInCollapsedIsNotEmpty();
    }
}
