package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.components.MainMenuButtons;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

public class OSS_1062_VerifyDocumentForHourFss extends AbstractDomainTest {

    private static final String NUMBER = "1";
    private static final String TYPE = "Кодекс";
    private static final String TYPE_LAW_PRACTICE = "Письмо";
    private static final String REGION = "Республика Башкортостан";
    private static final String LOBBY = "Верховный Совет Республики Башкортостан";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1062", testCaseVersion = "1")
    public void oss_1062_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Документ за час. Отображение. ФСС");
        loginFss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .inputTextInNumberField(NUMBER)
                .selectTypeByName(TYPE)
                .selectRegionByName(REGION)
                .selectLobbyByName(LOBBY)
                .clickSearchExtendedButton()
                .checkSearchTitle("Результаты поиска по реквизитам")
                .checkExtendedSearchString("Номер документа —  «" + NUMBER + "», вид —  «" + TYPE + "», регион —  «" + REGION + "», орган — «" + LOBBY + "»")
                .checkInLawAndInPracticeFilterIsPresent()
                .checkDisplayingText(true)
                .checkPresentFormsDocumentForHour()
                .checkSectionFilter(MainMenuButtons.LAW_BASE)

                .clickExtendedButtonInSearchBox()
                .clickInLawPracticeButton()
                .clearAllExtendedAttributes()
                .inputTextInNumberField(NUMBER)
                .selectTypeByName(TYPE_LAW_PRACTICE)
                .clickSearchExtendedButton()
                .checkSearchTitle("Результаты поиска по реквизитам")
                .checkExtendedSearchString("Номер документа —  «" + NUMBER + "», вид —  «" + TYPE_LAW_PRACTICE + "»")
                .checkInLawAndInPracticeFilterIsPresent()
                .checkDisplayingText(true)
                .checkPresentFormsDocumentForHour()
                .checkSectionFilter(MainMenuButtons.LAW_PRACTICE)

                .logout();
    }
}
