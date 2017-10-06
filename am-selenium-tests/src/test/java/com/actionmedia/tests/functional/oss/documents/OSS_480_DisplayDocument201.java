package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Shman4ik on 02.03.2015.
 */
public class OSS_480_DisplayDocument201 extends AbstractDomainTest {

    public static final String BUTTON_NAME = "Весь справочник";
    public static final String DOCUMENT_URL_BSS_VIP_201 = "#/document/201/7";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-480", testCaseVersion = "1")
    public void oss_480_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется отображение документов 201 модуля БСС ВИП");
        bssDocument_201();
    }

    private void bssDocument_201() {
        loginBss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_VIP_201)

                .checkSearchIn()
                .checkRevisionIsValidFrom()

                .checkPrintIcon()
                .checkWordButtonIsPresent()
                .checkShareIcon()

                .checkFastTableOfContents()
                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()

                .checkDisplayStarsSection()

                .logout();
    }
}
