package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 09/12/15.
 */
public class OSS_532_ExtendedSearchResultText extends AbstractDomainTest {

    private static final String QUERY = "123";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-532", testCaseVersion = "1")
    public void oss_532_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Поисковые фильтры Строка результатов КСС КУ");
        kss_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Поисковые фильтры Строка результатов  КСС БУ");
        kss_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Поисковые фильтры Строка результатов КСС ВИП");
        kss_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Поисковые фильтры Строка результатов БСС КУ");
        bss_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Поисковые фильтры Строка результатов БСС ВИП");
        bss_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Поисковые фильтры Строка результатов БСС УПР");
        bss_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Поисковые фильтры Строка результатов БСС БУ");
        bss_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Поисковые фильтры Строка результатов ЮСС КУ");
        uss_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Поисковые фильтры Строка результатов ЮСС ДОК");
        uss_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Поисковые фильтры Строка результатов ФСС КУ");
        fss_test();
    }

    private void kss_test() {
        loginKss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .checkResultTextFiltersOnExtendedFormIsNotVisible()

                .inputTextInSearchBox(QUERY)
                .inputTextInNumberField(QUERY)
                .inputTextInStartDateField("13.11.2015")
                .inputTextInEndDateField("14.11.2015")
                .selectRandomRegion()
                .selectRandomType()
                .selectRandomLobby()

                .checkSearchBodyResultText()
                .checkClearFieldsIsPresent()

                .clickClearFields()
                .checkClearFieldsIsPresent()
                .checkResultTextFiltersOnExtendedFormIsNotVisible()

                .inputTextInStartDateField("11.11.1111")
                .inputTextInEndDateField("11.11.1111")
                .inputInLobbyTextField("123")
                .inputInTypeTextField("123")
                .inputInRegionTextField("123")
                .checkClearFieldsIsPresent()
                .checkResultTextFiltersOnExtendedFormIsNotVisible()

                .clickClearFields()

                .inputInLobbyTextField("Минфин")
                .checkLobbyListItemsContainText("финансов, Минфин")
                .inputInLobbyTextField("Фсин")
                .checkLobbyListItemsContainText("исполнения наказаний")
                .inputInLobbyTextField("Минздрав")
                .checkLobbyListItemsContainText("здравоохранения, Минздрав")
                .clickClearFields()

                .clickInLawPracticeButton()

                .inputTextInSearchBox(QUERY)
                .inputTextInNumberField(QUERY)
                .inputTextInStartDateField("13.11.2015")
                .inputTextInEndDateField("14.11.2015")
                .selectRandomCategory()
                .selectRandomType()
                .selectRandomLobby()

                .checkSearchBodyResultTextInPractice()
                .checkClearFieldsIsPresent()

                .logout();
    }

    private void bss_test() {
        loginBss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .checkResultTextFiltersOnExtendedFormIsNotVisible()

                .inputTextInSearchBox(QUERY)
                .inputTextInNumberField(QUERY)
                .inputTextInStartDateField("13.11.2015")
                .inputTextInEndDateField("14.11.2015")
                .selectRandomRegion()
                .selectRandomType()
                .selectRandomLobby()

                .checkSearchBodyResultText()
                .checkClearFieldsIsPresent()

                .clickClearFields()
                .checkClearFieldsIsPresent()
                .checkResultTextFiltersOnExtendedFormIsNotVisible()

                .inputTextInStartDateField("11.11.1111")
                .inputTextInEndDateField("11.11.1111")
                .inputInLobbyTextField("123")
                .inputInTypeTextField("123")
                .inputInRegionTextField("123")
                .checkClearFieldsIsPresent()
                .checkResultTextFiltersOnExtendedFormIsNotVisible()

                .clickClearFields()

                .inputInLobbyTextField("Минфин")
                .checkLobbyListItemsContainText("финансов")
                .inputInLobbyTextField("Фсин")
                .checkLobbyListItemsContainText("исполнения наказаний")
                .inputInLobbyTextField("Минздрав")
                .checkLobbyListItemsContainText("здравоохранения, Минздрав")
                .clickClearFields()

                .clickInLawPracticeButton()

                .inputTextInSearchBox(QUERY)
                .inputTextInNumberField(QUERY)
                .inputTextInStartDateField("13.11.2015")
                .inputTextInEndDateField("14.11.2015")
                .selectRandomCategory()
                .selectRandomType()
                .selectRandomLobby()

                .checkSearchBodyResultTextInPractice()
                .checkClearFieldsIsPresent()

                .logout();
    }

    private void uss_test() {
        loginUss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .checkResultTextFiltersOnExtendedFormIsNotVisible()

                .inputTextInSearchBox(QUERY)
                .inputTextInNumberField(QUERY)
                .inputTextInStartDateField("13.11.2015")
                .inputTextInEndDateField("14.11.2015")
                .selectRandomRegion()
                .selectRandomType()
                .selectRandomLobby()

                .checkSearchBodyResultText()
                .checkClearFieldsIsPresent()

                .clickClearFields()
                .checkClearFieldsIsPresent()
                .checkResultTextFiltersOnExtendedFormIsNotVisible()

                .inputTextInStartDateField("11.11.1111")
                .inputTextInEndDateField("11.11.1111")
                .inputInLobbyTextField("123")
                .inputInTypeTextField("123")
                .inputInRegionTextField("123")
                .checkClearFieldsIsPresent()
                .checkResultTextFiltersOnExtendedFormIsNotVisible()

                .clickClearFields()

                .inputInLobbyTextField("Минфин")
                .checkLobbyListItemsContainText("финансов")
                .inputInLobbyTextField("Фсин")
                .checkLobbyListItemsContainText("исполнения наказаний")
                .inputInLobbyTextField("Минздрав")
                .checkLobbyListItemsContainText("здравоохранения, Минздрав")
                .clickClearFields()

                .clickInLawPracticeButton()

                .inputTextInSearchBox(QUERY)
                .inputTextInNumberField(QUERY)
                .inputTextInStartDateField("13.11.2015")
                .inputTextInEndDateField("14.11.2015")
                .selectRandomCategory()
                .selectRandomType()
                .selectRandomLobby()

                .checkSearchBodyResultTextInPractice()
                .checkClearFieldsIsPresent()

                .logout();
    }

    private void fss_test() {
        loginFss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .checkResultTextFiltersOnExtendedFormIsNotVisible()

                .inputTextInSearchBox(QUERY)
                .inputTextInNumberField(QUERY)
                .inputTextInStartDateField("13.11.2015")
                .inputTextInEndDateField("14.11.2015")
                .selectRandomRegion()
                .selectRandomType()
                .selectRandomLobby()

                .checkSearchBodyResultText()
                .checkClearFieldsIsPresent()

                .clickClearFields()
                .checkClearFieldsIsPresent()
                .checkResultTextFiltersOnExtendedFormIsNotVisible()

                .inputTextInStartDateField("11.11.1111")
                .inputTextInEndDateField("11.11.1111")
                .inputInLobbyTextField("123")
                .inputInTypeTextField("123")
                .inputInRegionTextField("123")
                .checkClearFieldsIsPresent()
                .checkResultTextFiltersOnExtendedFormIsNotVisible()

                .clickClearFields()

                .inputInLobbyTextField("Минфин")
                .checkLobbyListItemsContainText("финансов")
                .inputInLobbyTextField("Фсин")
                .checkLobbyListItemsContainText("исполнения наказаний")
                .inputInLobbyTextField("Минздрав")
                .checkLobbyListItemsContainText("здравоохранения, Минздрав")
                .clickClearFields()

                .clickInLawPracticeButton()

                .inputTextInSearchBox(QUERY)
                .inputTextInNumberField(QUERY)
                .inputTextInStartDateField("13.11.2015")
                .inputTextInEndDateField("14.11.2015")
                .selectRandomCategory()
                .selectRandomType()
                .selectRandomLobby()

                .checkSearchBodyResultTextInPractice()
                .checkClearFieldsIsPresent()

                .logout();
    }
}
