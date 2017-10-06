package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.components.MainMenuButtons;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

public class OSS_1059_VerifyDocumentForHourBss extends AbstractDomainTest {

    private static final String QUERY = "65432";
    private static final String NUMBER = "1";
    private static final String TYPE = "Закон";
    private static final String TYPE_LAW_PRACTICE = "Письмо";
    private static final String REGION = "Забайкальский край";
    private static final String LOBBY = "Агинская Бурятская окружная дума";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1059", testCaseVersion = "1")
    public void oss_1059_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Документ за час. Отображение. БСС");
        loginBss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .inputTextInSearchField(QUERY)
                .inputTextInNumberField(NUMBER)
                .selectTypeByName(TYPE)
                .selectRegionByName(REGION)
                .selectLobbyByName(LOBBY)
                .clickSearchExtendedButton()
                .checkSearchTitle("Результаты поиска по реквизитам: «" + QUERY + "»")
                .checkExtendedSearchString("Номер документа —  «" + NUMBER + "», вид —  «" + TYPE + "», регион —  «" + REGION + "», орган — «" + LOBBY + "»")
                .checkInLawAndInPracticeFilterIsPresent()
                .checkDisplayingText(true)
                .checkPresentFormsDocumentForHour()
                .checkSectionFilter(MainMenuButtons.LAW_BASE)

                .clickExtendedButtonInSearchBox()
                .clickInLawPracticeButton()
                .clearAllExtendedAttributes()
                .inputTextInSearchField(QUERY)
                .inputTextInNumberField(NUMBER)
                .selectTypeByName(TYPE_LAW_PRACTICE)
                .clickSearchExtendedButton()
                .checkSearchTitle("Результаты поиска по реквизитам: «" + QUERY + "»")
                .checkExtendedSearchString("Номер документа —  «" + NUMBER + "», вид —  «" + TYPE_LAW_PRACTICE + "»")
                .checkInLawAndInPracticeFilterIsPresent()
                .checkDisplayingText(true)
                .checkPresentFormsDocumentForHour()
                .checkSectionFilter(MainMenuButtons.LAW_PRACTICE)

                .logout();
    }
}
