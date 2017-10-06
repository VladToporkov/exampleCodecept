package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Shman4ik on 17.12.2014.
 */
public class OSS_318_VerifySearchOutputResultLawPagePresent extends AbstractDomainTest {

    private static final String QUERY_KSS = "трудовой кодекс";
    private static final String QUERY_BSS = "налоговый кодекс";
    private static final String QUERY_USS = "гражданский кодекс";
    private static final String QUERY_FSS = "налоговый кодекс";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-318", testCaseVersion = "1")
    public void oss_318_test() {
//        KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Правовая база) КСС КУ");
        kss_318_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Правовая база)  КСС БУ");
        kss_318_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Правовая база) КСС ВИП");
        kss_318_test();

//        BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Правовая база) БСС КУ");
        bss_318_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Правовая база) БСС ВИП");
        bss_318_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Правовая база) БСС УПР");
        bss_318_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Правовая база) БСС БУ");
        bss_318_test();

//        USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Правовая база) ЮСС КУ");
        uss_318_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Правовая база) ЮСС ДОК");
        uss_318_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Правовая база) ФСС КУ");
        fss_318_test();
    }

    private void kss_318_test() {
        loginKss()
                // step1
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY_KSS)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkSearchResultOnLawBasePageIsOpened()
                .checkResultBlockHasDocumentsLinksAndSnippets()
                .checkInLawAndInPracticeFilterIsPresent()

                .checkSectionFilterIsPresent()
                .checkSortingFilterIsPresent()
                .checkTypeDocumentFilterIsPresent()
                .checkRegionFilterIsPresent()
                .checkStatusFilterIsPresent()

                .checkRubricatorButtonIsPresent()
                .checkRubricatorFavoritesButtonIsPresent()

                .checkSearchResultHasStrongText()

                .checkSearchInResultCheckBoxIsPresent()

                //step2
                .clickInLawPracticeLinkFilter()
                .checkSearchResultOnLawPracticePageIsOpened()

                .checkResultBlockHasDocumentsLinksAndSnippets()
                .checkInLawAndInPracticeFilterIsPresent()

                .checkSectionFilterIsPresent()
                .checkSortingFilterIsPresent()
                .checkTypeDocumentFilterIsPresent()
                .checkRegionFilterIsPresent()

                .checkRubricatorFavoritesButtonIsPresent()

                .checkSearchInResultCheckBoxIsPresent()

                .checkSearchResultHasNOTStrongText()

                .logout();
    }

    private void bss_318_test() {
        loginBss()
                // step1
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY_BSS)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkSearchResultOnLawBasePageIsOpened()
                .checkResultBlockHasDocumentsLinksAndSnippets()
                .checkInLawAndInPracticeFilterIsPresent()

                .checkSectionFilterIsPresent()
                .checkSortingFilterIsPresent()
                .checkTypeDocumentFilterIsPresent()
                .checkRegionFilterIsPresent()
                .checkBranchFilterIsPresent()
                .checkStatusFilterIsPresent()

                .checkRubricatorButtonIsPresent()
                .checkRubricatorFavoritesButtonIsPresent()

                .checkSearchResultHasStrongText()

                .checkSearchInResultCheckBoxIsPresent()

                //step2
                .clickInLawPracticeLinkFilter()
                .checkSearchResultOnLawPracticePageIsOpened()

                .checkResultBlockHasDocumentsLinksAndSnippets()
                .checkInLawAndInPracticeFilterIsPresent()

                .checkSectionFilterIsPresent()
                .checkSortingFilterIsPresent()
                .checkTypeDocumentFilterIsPresent()
                .checkRegionFilterIsPresent()

                .checkRubricatorFavoritesButtonIsPresent()

                .checkSearchInResultCheckBoxIsPresent()

                .checkSearchResultHasNOTStrongText()

                .logout();
    }

    private void uss_318_test() {
        loginUss()
                // step1
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY_USS)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkSearchResultOnLawBasePageIsOpened()
                .checkInLawAndInPracticeFilterIsPresent()
                .checkResultBlockHasDocumentsLinksAndSnippets()
                .checkInLawAndInPracticeFilterIsPresent()

                .checkSectionFilterIsPresent()
                .checkSortingFilterIsPresent()
                .checkTypeDocumentFilterIsPresent()
                .checkRegionFilterIsPresent()
                .checkStatusFilterIsPresent()

                .checkRubricatorButtonIsPresent()
                .checkRubricatorFavoritesButtonIsPresent()

                .checkSearchResultHasStrongText()

                .checkSearchInResultCheckBoxIsPresent()

                //step2
                .clickInLawPracticeLinkFilter()
                .checkSearchResultOnLawPracticePageIsOpened()

                .checkResultBlockHasDocumentsLinksAndSnippets()
                .checkInLawAndInPracticeFilterIsPresent()

                .checkSectionFilterIsPresent()
                .checkSortingFilterIsPresent()
                .checkTypeDocumentFilterIsPresent()
                .checkRegionFilterIsPresent()

                .checkRubricatorFavoritesButtonIsPresent()

                .checkSearchInResultCheckBoxIsPresent()

                .checkSearchResultHasNOTStrongText()

                .logout();
    }

    private void fss_318_test() {
        loginFss()
                // step1
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY_FSS)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkSearchResultOnLawBasePageIsOpened()
                .checkResultBlockHasDocumentsLinksAndSnippets()
                .checkInLawAndInPracticeFilterIsPresent()

                .checkSectionFilterIsPresent()
                .checkSortingFilterIsPresent()
                .checkTypeDocumentFilterIsPresent()
                .checkRegionFilterIsPresent()
                .checkStatusFilterIsPresent()

                .checkRubricatorButtonIsPresent()
                .checkRubricatorFavoritesButtonIsPresent()

                .checkSearchResultHasStrongText()

                .checkSearchInResultCheckBoxIsPresent()

                //step2
                .clickInLawPracticeLinkFilter()
                .checkSearchResultOnLawPracticePageIsOpened()

                .checkResultBlockHasDocumentsLinksAndSnippets()
                .checkInLawAndInPracticeFilterIsPresent()

                .checkSectionFilterIsPresent()
                .checkSortingFilterIsPresent()
                .checkTypeDocumentFilterIsPresent()
                .checkRegionFilterIsPresent()

                .checkRubricatorFavoritesButtonIsPresent()

                .checkSearchInResultCheckBoxIsPresent()

                .checkSearchResultHasNOTStrongText()

                .logout();
    }
}
