package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;

/**
 * User: n.tyukavkin
 * Date: 03.02.16
 * Time: 21:24
 */
public class OSS_67_VerifyConverterCurrency extends AbstractDomainTest {

    private static final String DOCUMENT_URL = "#/document/123/3";

    @Test(groups = {inDevelopment})
    @TestLink(testCaseId = "OSS-67", testCaseVersion = "1")
    public void oss_67_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Конвертер валют БСС КУ");
        oss_67_bss_test();

        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Конвертер валют КСС КУ");
        oss_67_kss_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Конвертер валют ЮСС КУ");
        oss_67_uss_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Конвертер валют ФСС КУ");
        oss_67_fss_test();
    }

    private void oss_67_bss_test() {
        loginBss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL)
                .checkDocumentIsOpened()
                .checkCurrencyDocument()
                .checkRubricatorButtonIsPresent("Весь справочник")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonsForDocumentArePresent()

                .setLastCourseTableToParameter()
                .selectFirstCurrencyByCode("EUR")
                .checkFirstCurrencyLabel("EUR")
                .checkSecondCurrencyLabel("RUB")
                .checkTableCourseLabel("EUR", "RUB")
                .checkLastCourseTableIsChanged()

                .setLastCourseTableToParameter()
                .selectSecondCurrencyByCode("BGN")
                .checkFirstCurrencyLabel("EUR")
                .checkSecondCurrencyLabel("BGN")
                .checkTableCourseLabel("EUR", "BGN")
                .checkLastCourseTableIsChanged()

                .setLastCourseTableToParameter()
                .clickChangeCurrencyOrderButton()
                .checkFirstCurrencyLabel("BGN")
                .checkSecondCurrencyLabel("EUR")
                .checkTableCourseLabel("BGN", "EUR")
                .checkLastCourseTableIsChanged()


                //Step 7
                .setLastCourseTableToParameter()
                .selectFirstCurrencyByCode("EUR")
                .selectSecondCurrencyByCode("EUR")
                .checkFirstCurrencyLabel("EUR")
                .checkSecondCurrencyLabel("EUR")
                .checkTableCourseLabel("EUR", "EUR")
                .checkLastCourseTableIsChanged()

                .logout();
    }

    private void oss_67_kss_test() {
        loginKss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL)
                .checkDocumentIsOpened()
                .checkCurrencyDocument()
                .checkRubricatorButtonIsPresent("Весь справочник")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonsForDocumentArePresent()

                .setLastCourseTableToParameter()
                .selectFirstCurrencyByCode("EUR")
                .checkFirstCurrencyLabel("EUR")
                .checkSecondCurrencyLabel("RUB")
                .checkTableCourseLabel("EUR", "RUB")
                .checkLastCourseTableIsChanged()

                .setLastCourseTableToParameter()
                .selectSecondCurrencyByCode("BGN")
                .checkFirstCurrencyLabel("EUR")
                .checkSecondCurrencyLabel("BGN")
                .checkTableCourseLabel("EUR", "BGN")
                .checkLastCourseTableIsChanged()

                .setLastCourseTableToParameter()
                .clickChangeCurrencyOrderButton()
                .checkFirstCurrencyLabel("BGN")
                .checkSecondCurrencyLabel("EUR")
                .checkTableCourseLabel("BGN", "EUR")
                .checkLastCourseTableIsChanged()


                //Step 7
                .setLastCourseTableToParameter()
                .selectFirstCurrencyByCode("EUR")
                .selectSecondCurrencyByCode("EUR")
                .checkFirstCurrencyLabel("EUR")
                .checkSecondCurrencyLabel("EUR")
                .checkTableCourseLabel("EUR", "EUR")
                .checkLastCourseTableIsChanged()

                .logout();
    }

    private void oss_67_uss_test() {
        loginUss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL)
                .checkDocumentIsOpened()
                .checkCurrencyDocument()
                .checkRubricatorButtonIsPresent("Весь справочник")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonsForDocumentArePresent()

                .setLastCourseTableToParameter()
                .selectFirstCurrencyByCode("EUR")
                .checkFirstCurrencyLabel("EUR")
                .checkSecondCurrencyLabel("RUB")
                .checkTableCourseLabel("EUR", "RUB")
                .checkLastCourseTableIsChanged()

                .setLastCourseTableToParameter()
                .selectSecondCurrencyByCode("BGN")
                .checkFirstCurrencyLabel("EUR")
                .checkSecondCurrencyLabel("BGN")
                .checkTableCourseLabel("EUR", "BGN")
                .checkLastCourseTableIsChanged()

                .setLastCourseTableToParameter()
                .clickChangeCurrencyOrderButton()
                .checkFirstCurrencyLabel("BGN")
                .checkSecondCurrencyLabel("EUR")
                .checkTableCourseLabel("BGN", "EUR")
                .checkLastCourseTableIsChanged()


                //Step 7
                .setLastCourseTableToParameter()
                .selectFirstCurrencyByCode("EUR")
                .selectSecondCurrencyByCode("EUR")
                .checkFirstCurrencyLabel("EUR")
                .checkSecondCurrencyLabel("EUR")
                .checkTableCourseLabel("EUR", "EUR")
                .checkLastCourseTableIsChanged()

                .logout();
    }

    private void oss_67_fss_test() {
        loginFss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL)
                .checkDocumentIsOpened()
                .checkCurrencyDocument()
                .checkRubricatorButtonIsPresent("Весь справочник")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonsForDocumentArePresent()

                .setLastCourseTableToParameter()
                .selectFirstCurrencyByCode("EUR")
                .checkFirstCurrencyLabel("EUR")
                .checkSecondCurrencyLabel("RUB")
                .checkTableCourseLabel("EUR", "RUB")
                .checkLastCourseTableIsChanged()

                .setLastCourseTableToParameter()
                .selectSecondCurrencyByCode("BGN")
                .checkFirstCurrencyLabel("EUR")
                .checkSecondCurrencyLabel("BGN")
                .checkTableCourseLabel("EUR", "BGN")
                .checkLastCourseTableIsChanged()

                .setLastCourseTableToParameter()
                .clickChangeCurrencyOrderButton()
                .checkFirstCurrencyLabel("BGN")
                .checkSecondCurrencyLabel("EUR")
                .checkTableCourseLabel("BGN", "EUR")
                .checkLastCourseTableIsChanged()


                //Step 7
                .setLastCourseTableToParameter()
                .selectFirstCurrencyByCode("EUR")
                .selectSecondCurrencyByCode("EUR")
                .checkFirstCurrencyLabel("EUR")
                .checkSecondCurrencyLabel("EUR")
                .checkTableCourseLabel("EUR", "EUR")
                .checkLastCourseTableIsChanged()

                .logout();
    }
}