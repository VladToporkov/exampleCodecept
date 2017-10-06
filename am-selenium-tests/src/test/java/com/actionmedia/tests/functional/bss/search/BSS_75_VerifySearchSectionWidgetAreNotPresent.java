package com.actionmedia.tests.functional.bss.search;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 01.06.2014
 * Time: 13:51
 */
public class BSS_75_VerifySearchSectionWidgetAreNotPresent extends AbstractDomainTest {

    private static final String QUERY_LAW = "форма";
    private static final String QUERY_FORMS = "закон";
    private static final String QUERY_DICTIONARY = "ндфл";
    private static final String QUERY_MAGAZINES = "форма";
    private static final String QUERY_VIDEO = "Персонифицированный отчёт";
    private static final String QUERY_SERVICES = "Аванс";

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "BSS-75", testCaseVersion = "1")
    @LoginAs(key = "bss.user.expert")
    @Version(section = "vip")
    public void bss_75_test() {
        loginBss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY_LAW)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnLawBasePageIsOpened(true)
                .checkLawSearchWidgetIsNotPresent()
                .checkFormsSearchWidgetIsNotPresent()
                .checkMagazinesSearchWidgetIsNotPresent()
                .checkVideoSearchWidgetIsNotPresent()
                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(QUERY_LAW)
                .clickSearchExtendedButton()
                .checkSearchResultOnLawBasePageIsOpened(true)
                .checkLawSearchWidgetIsNotPresent()
                .checkFormsSearchWidgetIsNotPresent()
                .checkMagazinesSearchWidgetIsNotPresent()
                .checkVideoSearchWidgetIsNotPresent()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY_FORMS)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnFormsPageIsOpened()
                .checkLawSearchWidgetIsNotPresent()
                .checkFormsSearchWidgetIsNotPresent()
                .checkMagazinesSearchWidgetIsNotPresent()
                .checkVideoSearchWidgetIsNotPresent()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY_DICTIONARY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnDictionaryPageIsOpened()
                .checkLawSearchWidgetIsNotPresent()
                .checkFormsSearchWidgetIsNotPresent()
                .checkMagazinesSearchWidgetIsNotPresent()
                .checkVideoSearchWidgetIsNotPresent()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERY_MAGAZINES)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnMagazinesPageIsOpened()
                .checkLawSearchWidgetIsNotPresent()
                .checkFormsSearchWidgetIsNotPresent()
                .checkMagazinesSearchWidgetIsNotPresent()
                .checkVideoSearchWidgetIsNotPresent()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERY_VIDEO)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnVideosPageIsOpened()
                .checkLawSearchWidgetIsNotPresent()
                .checkFormsSearchWidgetIsNotPresent()
                .checkMagazinesSearchWidgetIsNotPresent()
                .checkVideoSearchWidgetIsNotPresent()

                .navigateToServicesPage()
                .inputTextInSearchBox(QUERY_SERVICES)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnServicesPageIsOpened()
                .checkLawSearchWidgetIsNotPresent()
                .checkFormsSearchWidgetIsNotPresent()
                .checkMagazinesSearchWidgetIsNotPresent()
                .checkVideoSearchWidgetIsNotPresent()
                .logout();
    }
}
