package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.components.MainMenuButtons;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

public class OSS_1060_VerifyDocumentForHourKss extends AbstractDomainTest {

    private static final String NUMBER = "23123132121";
    private static final String START_DATE = "01.01.2015";
    private static final String END_DATE = "01.02.2015";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1060", testCaseVersion = "1")
    public void oss_1060_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Документ за час. Отображение. КСС");
        loginKss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .inputTextInNumberField(NUMBER)
                .inputTextInStartDateField(START_DATE)
                .inputTextInEndDateField(END_DATE)
                .clickSearchExtendedButton()
                .checkSearchTitle("Результаты поиска по реквизитам")
                .checkExtendedSearchString("Номер документа —  «" + NUMBER + "», дата принятия: с " + START_DATE + " по " + END_DATE)
                .checkInLawAndInPracticeFilterIsPresent()
                .checkDisplayingText(true)
                .checkPresentFormsDocumentForHour()
                .checkSectionFilter(MainMenuButtons.LAW_BASE)

                .clickExtendedButtonInSearchBox()
                .clickInLawPracticeButton()
                .clearAllExtendedAttributes()
                .inputTextInNumberField(NUMBER)
                .inputTextInStartDateField(START_DATE)
                .inputTextInEndDateField(END_DATE)
                .clickSearchExtendedButton()
                .checkSearchTitle("Результаты поиска по реквизитам")
                .checkExtendedSearchString("Номер документа —  «" + NUMBER + "», дата принятия: с " + START_DATE + " по " + END_DATE)
                .checkInLawAndInPracticeFilterIsPresent()
                .checkDisplayingText(true)
                .checkPresentFormsDocumentForHour()
                .checkSectionFilter(MainMenuButtons.LAW_PRACTICE)

                .logout();
    }
}
