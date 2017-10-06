package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

public class OSS_482_DisplayDocument176 extends AbstractDomainTest {

    private static final String BUTTON_NAME = "Весь справочник";
    private static final String DOCUMENT_URL_FSS_176 = "#/document/176/random";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-482", testCaseVersion = "1")
    public void oss_482_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется  Общее отображение документов (176 модуль Журналы) ФСС КУ");
        loginFss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_FSS_176)

                .checkSearchIn()

//                .checkRevisionIsValidFrom()

//                .checkMenu()

                .checkPrintIcon()

                .checkWordButtonIsPresent()

                .checkRubricatorButtonIsPresent(BUTTON_NAME)

                .checkMyFavoritesRubricatorButtonIsPresent()

                .checkDisplayStarsTableWithScroll();

    }
}