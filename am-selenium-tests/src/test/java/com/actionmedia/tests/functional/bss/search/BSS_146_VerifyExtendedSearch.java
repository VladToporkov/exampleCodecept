package com.actionmedia.tests.functional.bss.search;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 23.10.13
 * Time: 9:34
 */
public class BSS_146_VerifyExtendedSearch extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-146", testCaseVersion = "2")
    @LoginAs(key = "bss.user.commercial")
    public void bss_146_test() {
        loginBss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .checkSearchExtendedButtonIsDisabled()
                .checkOnlyInTitlesCheckBoxIsDisabled()
                .checkOnlyInTitlesCheckBoxIsNotSelected()

                .inputNumberInExtendedByName("123-фз")
                .checkOnlyInTitlesCheckBoxIsDisabled()
                .checkOnlyInTitlesCheckBoxIsNotSelected()

                .inputTextInStartDateField("01.01.2010")
                .inputTextInEndDateField("01.01.2012")
                .checkOnlyInTitlesCheckBoxIsDisabled()
                .checkOnlyInTitlesCheckBoxIsNotSelected()

                .selectRandomType()
                .checkOnlyInTitlesCheckBoxIsDisabled()
                .checkOnlyInTitlesCheckBoxIsNotSelected()

                .selectRandomLobby()
                .checkOnlyInTitlesCheckBoxIsDisabled()
                .checkOnlyInTitlesCheckBoxIsNotSelected()

                .selectRandomRegion()
                .checkOnlyInTitlesCheckBoxIsDisabled()
                .checkOnlyInTitlesCheckBoxIsNotSelected()

                .inputTextInSearchField("кодекс")
                .checkOnlyInTitlesCheckBoxIsEnabled()
                .checkOnlyInTitlesCheckBoxIsNotSelected()

                .clearAllFields()
                .inputTextInSearchField("запрос")
                .selectLobbyByName("Министерство финансов РФ")
                .selectOnlyInTitlesCheckBox()
                .checkSearchBodyResultText()

                .clickSearchExtendedButton()
                .checkExtendedHeaderText()

                .clickExtendedButtonInSearchBox()
                .checkOnlyInTitlesCheckBoxIsEnabled()
                .checkOnlyInTitlesCheckBoxIsNotSelected()
                .logout();
    }
}
