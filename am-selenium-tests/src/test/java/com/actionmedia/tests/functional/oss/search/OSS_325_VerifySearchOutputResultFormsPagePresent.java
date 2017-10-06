package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Shman4ik on 17.12.2014.
 */
public class OSS_325_VerifySearchOutputResultFormsPagePresent extends AbstractDomainTest {

    private static final String QUERYKSS = "трудовой";
    private static final String QUERYBSS = "соглашение";
    private static final String QUERYUSS = "положение";
    private static final String QUERYFSS = "отчет";
    private static final String QUERY = "1";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-325", testCaseVersion = "3")
    public void oss_325_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Форма) КСС КУ");
        kss_325_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Форма) БСС КУ");
        bss_325_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Форма) ЮСС КУ");
        uss_325_test();

        //UMD
        updateSystemInfo(SystemPubs.umd);
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Форма) УМД КУ");
        umd_325_test();

        //ELPU
        updateSystemInfo(SystemPubs.elpu);
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Форма) ЭЛПУ КУ");
        elpu_325_test();

        //KLPU
        updateSystemInfo(SystemPubs.klpu);
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Форма) КЛПУ КУ");
        klpu_325_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Форма) ФСС КУ");
        fss_325_test();

        //OT
        updateSystemInfo(SystemPubs.ehs);
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Форма) ОТ КУ");
        ot_325_test();

        //GO
        updateSystemInfo(SystemPubs.go);
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Форма) ГЗ КУ");
        go_325_test();

        //CULT
        updateSystemInfo(SystemPubs.cult);
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Форма) КУЛЬТ КУ");
        cult_325_test();

        //EDU
        updateSystemInfo(SystemPubs.edu);
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Форма) ОБР КУ");
        edu_325_test();
    }

    private void kss_325_test() {
        enterToKssWithoutLogin()
                .navigateToFormsPage()
                .inputTextInSearchBox(QUERYKSS)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkSearchResultOnFormsPageIsOpened()
                .checkSectionFilterIsPresent()

                .checkSearchResultHasStrongText();
    }

    private void bss_325_test() {
        enterToBssWithoutLogin()
                .navigateToFormsPage()
                .inputTextInSearchBox(QUERYBSS)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkSearchResultOnFormsPageIsOpened()
                .checkSectionFilterIsPresent()

                .checkSearchResultHasStrongText();
    }

    private void uss_325_test() {
        enterToUssWithoutLogin()
                .navigateToFormsPage()
                .inputTextInSearchBox(QUERYUSS)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkSearchResultOnFormsPageIsOpened()
                .checkSectionFilterIsPresent()

                .checkSearchResultHasStrongText();
    }

    private void umd_325_test() {
        enterToUmdWithoutLogin()
                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkSearchResultOnFormsPageIsOpened()
                .checkSectionFilterIsPresent()

                .checkSearchResultHasStrongText();
    }

    private void elpu_325_test() {
        enterToElpuWithoutLogin()
                .navigateToFormsPage()
                .inputTextInSearchBox(QUERYUSS)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkSearchResultOnFormsPageIsOpened()
                .checkSectionFilterIsPresent()

                .checkSearchResultHasStrongText();
    }

    private void klpu_325_test() {
        enterToKlpuWithoutLogin()
                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkSearchResultOnFormsPageIsOpened()
                .checkSectionFilterIsPresent()

                .checkSearchResultHasStrongText();
    }

    private void fss_325_test() {
        enterToFssWithoutLogin()
                .navigateToFormsPage()
                .inputTextInSearchBox(QUERYFSS)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkSearchResultOnFormsPageIsOpened()
                .checkSectionFilterIsPresent()

                .checkSearchResultHasStrongText()

                .checkSearchFiltersArePresent();
    }

    private void ot_325_test() {
        enterToOtWithoutLogin()
                .navigateToFormsPage()
                .inputTextInSearchBox(QUERYFSS)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkSearchResultOnFormsPageIsOpened()
                .checkSectionFilterIsPresent()

                .checkSearchResultHasStrongText()

                .checkSearchFiltersArePresent();
    }

    private void go_325_test() {
        enterToGoWithoutLogin()
                .navigateToFormsPage()
                .inputTextInSearchBox(QUERYFSS)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkSearchResultOnFormsPageIsOpened()
                .checkSectionFilterIsPresent()

                .checkSearchResultHasStrongText()

                .checkSearchFiltersArePresent();
    }

    private void cult_325_test() {
        enterToCultWithoutLogin()
                .navigateToFormsPage()
                .inputTextInSearchBox(QUERYFSS)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkSearchResultOnFormsPageIsOpened()
                .checkSectionFilterIsPresent()

                .checkSearchResultHasStrongText()

                .checkSearchFiltersArePresent();
    }

    private void edu_325_test() {
        enterToEduWithoutLogin()
                .navigateToFormsPage()
                .inputTextInSearchBox(QUERYFSS)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkSearchResultOnFormsPageIsOpened()
                .checkSectionFilterIsPresent()

                .checkSearchResultHasStrongText()

                .checkSearchFiltersArePresent();
    }
}
