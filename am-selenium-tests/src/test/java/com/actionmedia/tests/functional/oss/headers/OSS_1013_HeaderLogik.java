package com.actionmedia.tests.functional.oss.headers;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;


/**
 * User: n.leontieva
 * Date: 15.01.16
 */
public class OSS_1013_HeaderLogik extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1013", testCaseVersion = "3")
    public void oss_1013_test() {
        switch (getNumberOfSystem()) {
            case 0: {
                test_uss();
                break;
            }
            case 1: {
                test_fss();
                break;
            }
            case 2: {
                test_bss();
                break;
            }
            case 3: {
                test_kss();
                break;
            }
        }
    }

    private int getNumberOfSystem() {
        return getMultiplicityOfWeekNumber() % 4;
    }

    private void test_uss() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        getUssBasePage()
                .clickAskExpertLink()
                .checkAskPage();

        getUssBasePage()
                .navigateToLoginPage()
                .checkLoginPage();

        getUssBasePage()
                .navigateToPromoPage()
                .checkPromoPage();

        loginUss()
                .navigateToUssLoginPage()
                .checkCustomerInfoPage()
                .goBack()

                .navigateToCustomerPage()
                .goBack()

                .navigateToDocumentPage()
                .scrollToEnd()
                .openMenu()
                .checkMenuIsOpened()
                .goToCurrentTab()
                .checkMenuIsNotOpened()

                //перейти в другой раздел
                .goBack()
                .scrollToEnd()
                .openMenu()
                .checkMenuIsOpened()
                .goToDifferentTab()
                .checkMenuIsNotOpened()

                .logoutBase();
    }

    private void test_kss() {

        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        getKssBasePage()
                .clickAskExpertLink()
                .checkAskPage();

        getKssBasePage()
                .navigateToLoginPage()
                .checkLoginPage();

        getKssBasePage()
                .navigateToPromoPage()
                .checkPromoPage();

        loginKss()
                .navigateToKssLoginPage()
                .checkCustomerInfoPage()
                .goBack()

                .navigateToCustomerPage()
                .goBack()

                .navigateToDocumentPage()
                .scrollToEnd()
                .openMenu()
                .checkMenuIsOpened()
                .goToCurrentTab()
                .checkMenuIsNotOpened()

                //перейти в другой раздел
                .goBack()
                .scrollToEnd()
                .openMenu()
                .checkMenuIsOpened()
                .goToDifferentTab()
                .checkMenuIsNotOpened()
                .logoutBase();

    }

    private void test_bss() {

        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");

        //Нажать "Активация подписки" (только БСС и ФСС).
        getBssBasePage()
                .navigateToActivatePage()
                .checkActivateLink();

        //Нажать "Написать эксперту" (кроме ФСС).
        getBssBasePage()
                .clickAskExpertLink()
                .checkAskPage();

        //Нажать "Вход и регистрация".
        getBssBasePage()
                .navigateToLoginPage()
                .checkLoginPage();

        //Нажать "О системе" (кроме ЮСС ВИП)
        getBssBasePage()
                .navigateToPromoPage()
                .checkPromoPage();

        //Войти и нажать на ИО пользователя (вместо кнопки "Вход и регистрация").
        loginBss()
                .navigateToBssLoginPage()
                .checkCustomerInfoPage()
                .goBack()

                .navigateToCustomerPage()
                .goBack()

                .navigateToDocumentPage()
                .scrollToEnd()
                .openMenu()
                .checkMenuIsOpened()
                .goToCurrentTab()
                .checkMenuIsNotOpened()

                //перейти в другой раздел
                .goBack()
                .scrollToEnd()
                .openMenu()
                .checkMenuIsOpened()
                .goToDifferentTab()
                .checkMenuIsNotOpened()

                .logoutBase();
    }

    private void test_fss() {

        updateSystemInfo(SystemPubs.fss);
        getFssBasePage()
                .navigateToActivatePage()
                .checkActivateLink();

        getFssBasePage()
                .navigateToLoginPage()
                .checkLoginPage();

        getFssBasePage()
                .navigateToPromoPage()
                .checkPromoPage();

        updateLoginAsInfo("fss.user.commercial");
        loginFss()
                .navigateToFssLoginPage()
                .checkCustomerInfoPage()
                .goBack()

                .navigateToCustomerPage()
                .goBack()

                .navigateToDocumentPage()
                .scrollToEnd()
                .openMenu()
                .checkMenuIsOpened()
                .goToCurrentTab()
                .checkMenuIsNotOpened()

                //перейти в другой раздел
                .goBack()
                .scrollToEnd()
                .openMenu()
                .checkMenuIsOpened()
                .goToDifferentTab()
                .checkMenuIsNotOpened()

                .logoutBase();
    }
}