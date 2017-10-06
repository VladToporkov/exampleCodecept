package com.actionmedia.tests.functional.bss.recomend;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;

/**
 * User: n.tyukavkin
 * Date: 22.10.13
 * Time: 13:54
 */
public class BSS_183_VerifyRubricator extends AbstractDomainTest {

    @Test(groups = {implemented})
//    @TestLink(testCaseId = "BSS-183", testCaseVersion = "1")
    @LoginAs(key = "bss.user.vip")
    @Version(section = "vip")
    public void bss_183_test() {
        loginBss()
                .navigateToRecomendPage()
                .clickRubricatorButton()
                .checkRubricatorButtonIsPressed()
                .checkFirstElementIsSelected()
                .checkActiveItemForFirstMenuIsHighlighted()
                .checkContentsIsPresent()
                .clickRandomItemFromFirstMenu()
                .checkContentsIsPresent()
                .clickCloseRubricatorButton()

                .navigateToLawBasePage()
                .clickRubricatorButton()
                .checkRubricatorButtonIsPressed()
                .checkFirstElementIsSelected()
                .checkActiveItemForFirstMenuIsHighlighted()
                .checkContentsIsPresent()
                .clickRandomPBU()
                .checkContentsIsPresent()
                .clickRandomKodeks()
                .checkKodeksContentsIsPresent()
                .clickCloseRubricatorButton()

                .navigateToFormsPage()
                .clickRubricatorButton()
                .checkRubricatorButtonIsPressed()
                .checkFirstElementIsSelected()
                .checkActiveItemForFirstMenuIsHighlighted()
                .checkContentsIsPresent()
                .clickRandomItemFromFirstMenu()
                .checkContentsIsPresent()
                .clickCloseRubricatorButton()

                .navigateToDictionaryPage()
                .clickRubricatorButton()
                .checkRubricatorButtonIsPressed()
                .checkFirstElementIsSelected()
                .checkActiveItemForFirstMenuIsHighlighted()
                .checkContentsIsPresent()
                .clickRandomItemFromFirstMenu()
                .checkContentsIsPresent()
                .clickCloseRubricatorButton()

                .navigateToMagazinesPage()
                .clickRubricatorButton()
                .checkRubricatorButtonIsPressed()
                .checkFirstElementIsSelected()
                .checkActiveItemForFirstMenuIsHighlighted()
                .checkContentsIsPresent()
                .clickRandomBook()
                .checkContentsIsPresent()
                .clickRandomItemFromFirstMenu()
                .checkContentsIsPresent()
                .clickCloseRubricatorButton()

                .navigateToVideoPage()
                .clickRubricatorButton()
                .checkRubricatorButtonIsPressed()
                .checkFirstElementIsSelected()
                .checkActiveItemForFirstMenuIsHighlighted()
                .checkContentsIsPresent()
                .clickRandomItemFromFirstMenu()
                .checkContentsIsPresent()
                .clickCloseRubricatorButton()

                .navigateToServicesPage()
                .clickRubricatorButton()
                .checkRubricatorButtonIsPressed()
                .checkActiveItemForFirstMenuIsHighlighted()
                .checkContentsIsPresent()
                .clickRandomItemFromFirstMenu()
                .checkContentsIsPresent()
                .clickCloseRubricatorButton()
                .logout();
    }
}
