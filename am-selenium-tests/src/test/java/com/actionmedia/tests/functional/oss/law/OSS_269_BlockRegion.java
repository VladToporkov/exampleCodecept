package com.actionmedia.tests.functional.oss.law;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Shman4ik on 17.12.2014.
 */
public class OSS_269_BlockRegion extends AbstractDomainTest {

    public static final String QUERY = "1";
    public static final String REGION_1 = "Москва";
    public static final String REGION_2 = "Санкт-Петербург";
    public static final String REGION_3 = "Колпино";
    public static final String CHECK_REGION_2 = "Популярное в Санкт-Петербурге";
    public static final String CHECK_REGION_3 = "Популярное в Ленинградской обл.";
    public static final String CHECK_REGION_1 = "Популярное в Москве";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-269", testCaseVersion = QUERY)
    public void oss_269_test() {
        // KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется блок 'Региональных документов' раздел Правовая база КСС КУ");
        kss_269_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется блок 'Региональных документов' раздел Правовая база КСС БУ");
        kss_269_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется блок 'Региональных документов' раздел Правовая база КСС ВИП");
        kss_269_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется блок 'Региональных документов' раздел Правовая база БСС КУ");
        bss_269_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется блок 'Региональных документов' раздел Правовая база БСС ВИП");
        bss_269_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется блок 'Региональных документов' раздел Правовая база БСС УПР");
        bss_269_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется блок 'Региональных документов' раздел Правовая база БСС БУ");
        bss_269_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется блок 'Региональных документов' раздел Правовая база ЮСС КУ");
        uss_269_test();
        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется блок 'Региональных документов' раздел Правовая база ЮСС ДОК");
        uss_269_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется блок 'Региональных документов' раздел Правовая база ФСС КУ");
        fss_269_test();
    }

    private void fss_269_test() {
        loginFss()
                //Приведение состояния пользователя по умолчанию
                .navigateToLawBasePage()
                .clickLinkChangeRegion()
                .changeCheckboxAutoRegion()

                .navigateToLawBasePage()
                .checkRegionBlockIsPresent()
                .checkChangeRegionLinkIsPresent()
                .checkSearchBoxIsPresentRegionBlock()

                .inputTextInSearchBoxOnRegionBlock(QUERY)
                .clickSearchButtonOnRegionBlock()
                .checkRegion(REGION_1)

                .navigateToLawBasePage()
                .clickLinkChangeRegion()
                .checkCurrentUrlContainsDocumentUrl()

                .changeRegion(REGION_2)
                .navigateToLawBasePage()
                .checkTitleChangeRegion(CHECK_REGION_2)

                .clickLinkChangeRegion()
                .checkCurrentUrlContainsDocumentUrl()
                .changeRegion(REGION_3)
                .navigateToLawBasePage()
                .checkTitleChangeRegion(CHECK_REGION_3)
                .clickLinkChangeRegion()
                .checkCurrentUrlContainsDocumentUrl()
                .changeRegion(REGION_1)
                .navigateToLawBasePage()
                .checkTitleChangeRegion(CHECK_REGION_1)

                .navigateToLawBasePage()
                .checkRegionBlockLinks()

                //Приведение состояния пользователя по умолчанию
                .clickLinkChangeRegion()
                .changeCheckboxAutoRegion()

                .logout();
    }

    private void uss_269_test() {
        loginUss()
                //Приведение состояния пользователя по умолчанию
                .navigateToLawBasePage()
                .clickLinkChangeRegion()
                .changeCheckboxAutoRegion()

                .navigateToLawBasePage()
                .checkRegionBlockIsPresent()
                .checkChangeRegionLinkIsPresent()
                .checkSearchBoxIsPresentRegionBlock()

                .inputTextInSearchBoxOnRegionBlock(QUERY)
                .clickSearchButtonOnRegionBlock()
                .checkRegion(REGION_1)

                .navigateToLawBasePage()
                .clickLinkChangeRegion()
                .checkCurrentUrlContainsDocumentUrl()

                .changeRegion(REGION_2)
                .navigateToLawBasePage()
                .checkTitleChangeRegion(CHECK_REGION_2)

                .clickLinkChangeRegion()
                .checkCurrentUrlContainsDocumentUrl()
                .changeRegion(REGION_3)
                .navigateToLawBasePage()
                .checkTitleChangeRegion(CHECK_REGION_3)
                .clickLinkChangeRegion()
                .checkCurrentUrlContainsDocumentUrl()
                .changeRegion(REGION_1)
                .navigateToLawBasePage()
                .checkTitleChangeRegion(CHECK_REGION_1)

                .navigateToLawBasePage()
                .checkRegionBlockLinks()

                //Приведение состояния пользователя по умолчанию
                .clickLinkChangeRegion()
                .changeCheckboxAutoRegion()

                .logout();
    }

    private void bss_269_test() {
        loginBss()
                //Приведение состояния пользователя по умолчанию
                .navigateToLawBasePage()
                .clickLinkChangeRegion()
                .changeCheckboxAutoRegion()

                .navigateToLawBasePage()
                .checkRegionBlockIsPresent()
                .checkChangeRegionLinkIsPresent()
                .checkSearchBoxIsPresentRegionBlock()

                .inputTextInSearchBoxOnRegionBlock(QUERY)
                .clickSearchButtonOnRegionBlock()
                .checkRegion(REGION_1)

                .navigateToLawBasePage()
                .clickLinkChangeRegion()
                .checkCurrentUrlContainsDocumentUrl()

                .changeRegion(REGION_2)
                .navigateToLawBasePage()
                .checkTitleChangeRegion(CHECK_REGION_2)

                .clickLinkChangeRegion()
                .checkCurrentUrlContainsDocumentUrl()
                .changeRegion(REGION_3)
                .navigateToLawBasePage()
                .checkTitleChangeRegion(CHECK_REGION_3)
                .clickLinkChangeRegion()
                .checkCurrentUrlContainsDocumentUrl()
                .changeRegion(REGION_1)
                .navigateToLawBasePage()
                .checkTitleChangeRegion(CHECK_REGION_1)

                .navigateToLawBasePage()
                .checkRegionBlockLinks()

                //Приведение состояния пользователя по умолчанию
                .clickLinkChangeRegion()
                .changeCheckboxAutoRegion()

                .logout();
    }

    private void kss_269_test() {
        loginKss()
                //Приведение состояния пользователя по умолчанию
                .navigateToLawBasePage()
                .clickLinkChangeRegion()
                .changeCheckboxAutoRegion()

                .navigateToLawBasePage()
                .checkRegionBlockIsPresent()
                .checkChangeRegionLinkIsPresent()
                .checkSearchBoxIsPresentRegionBlock()

                .inputTextInSearchBoxOnRegionBlock(QUERY)
                .clickSearchButtonOnRegionBlock()
                .checkRegion(REGION_1)

                .navigateToLawBasePage()
                .clickLinkChangeRegion()
                .checkCurrentUrlContainsDocumentUrl()

                .changeRegion(REGION_2)
                .navigateToLawBasePage()
                .checkTitleChangeRegion(CHECK_REGION_2)

                .clickLinkChangeRegion()
                .checkCurrentUrlContainsDocumentUrl()
                .changeRegion(REGION_3)
                .navigateToLawBasePage()
                .checkTitleChangeRegion(CHECK_REGION_3)
                .clickLinkChangeRegion()
                .checkCurrentUrlContainsDocumentUrl()
                .changeRegion(REGION_1)
                .navigateToLawBasePage()
                .checkTitleChangeRegion(CHECK_REGION_1)

                .navigateToLawBasePage()
                .checkRegionBlockLinks()

                //Приведение состояния пользователя по умолчанию
                .clickLinkChangeRegion()
                .changeCheckboxAutoRegion()

                .logout();
    }
}
