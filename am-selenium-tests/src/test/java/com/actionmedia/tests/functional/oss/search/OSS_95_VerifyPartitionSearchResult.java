package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;

/**
 * Created by Shman4ik on 03.02.2015.
 */
public class OSS_95_VerifyPartitionSearchResult extends AbstractDomainTest {

    private static final String QUERY = "фамилия";
    private static final String QUERYKSS = "труд";
    private static final String QUERYBSS = "налог";
    private static final String QUERYUSS = "суд";
    private static final String QUERYFSS = "финансы";

    @Test(groups = {inDevelopment})
    @TestLink(testCaseId = "OSS-95", testCaseVersion = "1")
    public void oss_95_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.expert");
        report("Проверяется Подгрузка результатов поисковой выдачи КСС КУ");
        kss_95_test();

        updateLoginAsInfo("kss.user.expert");
        updateLoginToInfo("budget");
        report("Проверяется Подгрузка результатов поисковой выдачи КСС БУ");
        kss_95_test();

        updateLoginAsInfo("kss.user.expert");
        updateLoginToInfo("vip");
        report("Проверяется Подгрузка результатов поисковой выдачи КСС ВИП");
        kss_95_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.expert");
        report("Проверяется Подгрузка результатов поисковой выдачи БСС КУ");
        bss_95_test();

        updateLoginAsInfo("bss.user.expert");
        updateLoginToInfo("vip");
        report("Проверяется Подгрузка результатов поисковой выдачи БСС ВИП");
        bss_95_test();

        updateLoginAsInfo("bss.user.expert");
        updateLoginToInfo("usn");
        report("Проверяется Подгрузка результатов поисковой выдачи БСС УПР");
        bss_95_test();

        updateLoginAsInfo("bss.user.expert");
        updateLoginToInfo("budget");
        report("Проверяется Подгрузка результатов поисковой выдачи БСС БУ");
        bss_95_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.expert");
        report("Проверяется Подгрузка результатов поисковой выдачи ЮСС КУ");
        uss_95_test();

        updateLoginAsInfo("uss.user.expert");
        updateLoginToInfo("doc");
        report("Проверяется Подгрузка результатов поисковой выдачи ЮСС ДОК");
        uss_95_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.expert");
        report("Проверяется Подгрузка результатов поисковой выдачи ФСС КУ");
        fss_95_test();
    }

    private void kss_95_test() {
        loginKss()
                .navigateToAnswersPage()
                .checkSearchBlockNotWidget(QUERY)
                .navigateToLawBasePage()
                .checkSearchBlockNotWidget(QUERY)
                .navigateToFormsPage()
                .checkSearchBlockNotWidget(QUERY)
                .navigateToDictionaryPage()
                .checkSearchBlockNotWidget(QUERYKSS)
                .navigateToMagazinesPage()
                .checkSearchBlockNotWidget(QUERYKSS)
                .navigateToVideoPage()
                .checkSearchBlockNotWidget(QUERYKSS)
                //Пропустили из-за маленькой поисковой выдачи
                /*.navigateToWizardsPage()
                .checkSearchBlockNotWidget(QUERYKSS)
                .navigateToAnswersPage()
                .checkSearchBlockWidget("Договор")*/
                .logout();
    }

    private void bss_95_test() {
        loginBss()
                .navigateToRecomendPage()
                .checkSearchBlockNotWidget(QUERY)
                .navigateToLawBasePage()
                .checkSearchBlockNotWidget(QUERY)
                .navigateToFormsPage()
                .checkSearchBlockNotWidget(QUERY)
                .navigateToDictionaryPage()
                .checkSearchBlockNotWidget(QUERYBSS)
                .navigateToMagazinesPage()
                .checkSearchBlockNotWidget(QUERYBSS)
                .navigateToVideoPage()
                .checkSearchBlockNotWidget(QUERYBSS)
                //Пропустили из-за маленькой поисковой выдачи
               /*.navigateToRecomendPage()
                .checkSearchBlockWidget("Договор")*/
                .logout();
    }

    private void uss_95_test() {
        loginUss()
                .navigateToRecomendPage()
                .checkSearchBlockNotWidget(QUERY)
                .navigateToLawBasePage()
                .checkSearchBlockNotWidget(QUERY)
                .navigateToFormsPage()
                .checkSearchBlockNotWidget(QUERY)
                .navigateToDictionaryPage()
                .checkSearchBlockNotWidget(QUERYUSS)
                .navigateToMagazinesPage()
                .checkSearchBlockNotWidget(QUERYUSS)
                .navigateToVideoPage()
                .checkSearchBlockNotWidget(QUERYUSS)
                //Пропустили из-за маленькой поисковой выдачи
              /*.navigateToWizardsPage()
                .checkSearchBlockNotWidget(QUERYUSS)
                .navigateToRecomendPage()
                .checkSearchBlockWidget("Договор")*/
                .logout();
    }

    private void fss_95_test() {
        loginFss()
                //Пропустили из-за маленькой поисковой выдачи из-за маленькой поисковой выдачи
             /*   .navigateToSolutionsPage()
                .checkSearchBlockNotWidget(QUERY)*/
                .navigateToFormsPage()
                .checkSearchBlockNotWidget(QUERYFSS)
                .navigateToLawBasePage()
                .checkSearchBlockNotWidget(QUERYFSS)
                .navigateToMagazinesPage()
                .checkSearchBlockNotWidget(QUERYFSS)
                .navigateToDictionaryPage()
                .checkSearchBlockNotWidget(QUERYFSS)
                //Пропустили из-за маленькой поисковой выдачи
                /*.navigateToVideoPage()
                .checkSearchBlockNotWidget(QUERYFSS)
                .navigateToServicesPage()
                .checkSearchBlockNotWidget(QUERYFSS)
                .navigateToSolutionsPage()
                .checkSearchBlockWidget("труд")*/
                .logout();
    }
}