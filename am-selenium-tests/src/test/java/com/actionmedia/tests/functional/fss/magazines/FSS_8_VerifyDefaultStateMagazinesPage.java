package com.actionmedia.tests.functional.fss.magazines;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 11.11.13
 * Time: 17:17
 */
public class FSS_8_VerifyDefaultStateMagazinesPage extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-8", testCaseVersion = "1")
    @LoginAs(key = "fss.user.panel")
    public void fss_8_test() {
        loginFss()
                .navigateToMagazinesPage()
                .checkDefaultStateMagazinesPage()

                .checkFirstScreenInNewMagazinesShelf()
                .clickSecondScreenOnNewMagazinesAndBooks()
                .checkSecondScreenInNewMagazinesShelf()
                .clickThirdScreenOnNewMagazinesAndBooks()
                .checkThirdScreenInNewMagazinesShelf()
                .clickSecondScreenOnNewMagazinesAndBooks()
                .checkSecondScreenInNewMagazinesShelf()
                .clickFirstScreenOnNewMagazinesAndBooks()
                .checkFirstScreenInNewMagazinesShelf()

                .checkFirstScreenInBooksShelf()
                .clickSecondScreenOnBooks()
                .checkSecondScreenInBooksShelf()
                .clickThirdScreenOnBooks()
                .checkThirdScreenInBooksShelf()
                .clickSecondScreenOnBooks()
                .checkSecondScreenInBooksShelf()
                .clickFirstScreenOnBooks()
                .checkFirstScreenInBooksShelf()

                .checkRandomLinkFromNewMagazinesAndBooks()
                .checkRandomLinkFromBooks()
                .checkRandomLinkFromMagazines()
                .checkRandomYearLink()

                .checkFiltersInRightPanel()
                .checkContentForMagazinesAndBooks()
                .checkRandomLinksFromExpandedPopularBlock()
                .checkRandomLinksFromExpandedViewedBlock();
    }
}
