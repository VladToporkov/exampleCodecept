package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.components.MainMenuButtons;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

public class OSS_1061_VerifyDocumentForHourUss extends AbstractDomainTest {

    private static final String QUERY = "654564546";
    private static final String LOBBY = "Правительство РФ";
    private static final String TYPE = "Постановление";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1061", testCaseVersion = "1")
    public void oss_1061_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("bss.user.commercial");
        report("Документ за час. Отображение. ЮСС");
        loginUss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .inputTextInSearchField(QUERY)
                .selectLobbyByName(LOBBY)
                .clickSearchExtendedButton()
                .checkSearchTitle("Результаты поиска по реквизитам: «" + QUERY + "»")
                .checkExtendedSearchString("Орган — «" + LOBBY + "»")
                .checkInLawAndInPracticeFilterIsPresent()
                .checkDisplayingText(true)
                .checkPresentFormsDocumentForHour()
                .checkSectionFilter(MainMenuButtons.LAW_BASE)

                .clickExtendedButtonInSearchBox()
                .clickInLawPracticeButton()
                .clearAllExtendedAttributes()
                .inputTextInSearchField(QUERY)
                .selectTypeByName(TYPE)
                .clickSearchExtendedButton()
                .checkSearchTitle("Результаты поиска по реквизитам: «" + QUERY + "»")
                .checkExtendedSearchString("Вид —  «" + TYPE + "»")
                .checkInLawAndInPracticeFilterIsPresent()
                .checkDisplayingText(true)
                .checkPresentFormsDocumentForHour()
                .checkSectionFilter(MainMenuButtons.LAW_PRACTICE)

                .logout();
    }
}
