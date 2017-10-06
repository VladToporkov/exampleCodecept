package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Shman4ik on 02.03.2015.
 */
public class OSS_479_DisplayDocument169 extends AbstractDomainTest {

    public static final String BUTTON_NAME = "Весь справочник";
    public static final String DOCUMENT_URL_BSS_VIP_169 = "#/document/169/8/";
    public static final String DOCUMENT_URL_USS_169 = "#/document/169/14/";


    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-479", testCaseVersion = "1")
    public void oss_479_test() {

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется отображение документов 169 модуля БСС ВИП");
        bssDocument_169();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется  отображение документов 169 модуля ЮСС КУ");
        ussDocument_169();
    }

    private void bssDocument_169() {
        loginBss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_VIP_169)

                .checkSearchIn()
                .checkRevisionIsValidFrom()

                .checkPrintIcon()
                .checkWordButtonIsPresent()

                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()

                .checkDisplayStarsSection()
                .checkDisplayStarsTable()

                .logout();
    }

    private void ussDocument_169() {
        loginUss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_USS_169)
                .checkSearchIn()
                .checkRevisionIsValidFrom()

                .checkPrintIcon()
                .checkWordButtonIsPresent()

                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()

                .checkDisplayStarsSection()
                .checkDisplayStarsTable()

                .logout();
    }
}
