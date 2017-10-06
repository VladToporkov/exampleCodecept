package com.actionmedia.tests.functional.bss.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 21.10.13
 * Time: 13:51
 */
public class BSS_30_VerifyExtendedSearch extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-30", testCaseVersion = "2")
    @LoginAs(key = "bss.user.commercial")
    public void bss_30_test() {
        loginBss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .checkOnlyInTitlesCheckBoxIsNotSelected()
                .checkSearchExtendedButtonsIsDisabled()

                .inputTextInSearchField("мсфо часть 1")
                .checkSearchBodyResultText()
                .checkSearchExtendedButtonIsEnabled()
                .clickSearchExtendedButton()
                .checkExtendedSearchResultIsPresent()
                .checkExtendedHeaderText()

                .clickExtendedButtonInSearchBox()
                .checkValuesInFieldIsNotChanged()
                .clearAllFields()
                .inputTextInNumberField("123-фз")
                .checkSearchBodyResultText()
                .clickSearchExtendedButton()
                .checkExtendedSearchResultIsPresent()
                .checkExtendedHeaderText()

                .clickExtendedButtonInSearchBox()
                .checkValuesInFieldIsNotChanged()
                .clearAllFields()
                .inputTextInStartDateField("01.01.2005")
                .inputTextInEndDateField("01.01.2013")
                .checkSearchBodyResultText()
                .clickSearchExtendedButton()
                .checkExtendedSearchResultIsPresent()
                .checkExtendedHeaderText()

                .clickExtendedButtonInSearchBox()
                .checkValuesInFieldIsNotChanged()
                .clearAllFields()
                .selectTypeByName("Федеральный закон")
                .selectLobbyByName("Государственная дума Федерального собрания РФ")
                .selectRegionByName("РФ")
                .clickSearchExtendedButton()
                .checkExtendedSearchResultIsPresent()
                .checkExtendedHeaderText()

                .clickExtendedButtonInSearchBox()
                .checkValuesInFieldIsNotChanged()
                .clickClearFields()
                .checkAllFieldsDefaultState()
                .checkOnlyInTitlesCheckBoxIsNotSelected()
                .checkSearchExtendedButtonsIsDisabled()
                .logout();
    }
}
