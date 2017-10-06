package com.actionmedia.tests.functional.bss.magazines;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 13.12.13
 * Time: 17:36
 */
public class BSS_VerifyMagazinesRubricator extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @LoginAs(key = "bss.user.commercial")
    public void bss_magazines_rubricator_test() {
        loginBss()
                .navigateToMagazinesPage()
                .clickRubricatorButton()
                .clickRandomMagazine()
                .clickRandomItemFromSecondMenu()
                .clickRandomItemFromThirdMenu()
                .clickRandomArticle()
                .checkEmptyHeader()

                .clickRubricatorButton()
                .clickRandomBook()
                .clickRandomItemFromSecondMenu()
                .clickRandomItemFromThirdMenu()
                .clickRandomArticle()
                .checkEmptyHeader()

                .clickRubricatorButton()
                .clickRandomBJGBook()
                .clickRandomItemFromSecondMenu()
                .clickRandomItemFromThirdMenu()
                .clickRandomArticle()
                .checkEmptyHeader()
                .logout();
    }
}
