package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

public class OSS_484_DisplayDocument205 extends AbstractDomainTest {

    private static final String BUTTON_NAME = "Весь справочник";
    private static final String DOCUMENT_URL = "#/document/205/1";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-484", testCaseVersion = "1")
    public void oss_484_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется отображение документов 205 модуля БСС КУ");
        loginBss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL)
                .checkDocumentIsOpened()
                .checkDocumentIsNotEmpty()
                .checkSearchIn()
                .checkOtherVersionsForDictionaryDocumentIsPresent()
                .checkPrintIcon()
                .checkWordButtonIsPresent()
                .checkMailButtonIsPresent()
                .checkDownloadButtonIsPresent()
                .checkDownloadExampleButtonIsPresent()
                .checkSoderIsPresent()
                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkDisplayStarsInDictionary()
                .logout();
    }
}
