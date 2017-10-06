package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inTesting;
import static com.actionmedia.autotest.Group.regression;

public class OSS_471_DisplayDocument122 extends AbstractDomainTest {


    public static final String BUTTON_NAME = "Весь справочник";
    public static final String DOCUMENT_URL_KSS_122 = "#/document/122/23/";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-471", testCaseVersion = "1")
    public void oss_471_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется  Общее отображение документов (122 модуль Журналы) КСС КУ");
        kssDocument_122();
    }

    private void kssDocument_122(){
        loginKss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_KSS_122)

                .checkDocumentVersionIsPresent()

                .checkPrintIcon()

                .checkWordButtonIsPresent()

                .checkRubricatorButtonIsPresent(BUTTON_NAME)

                .checkMyFavoritesRubricatorButtonIsPresent()

                .checkDisplayStarsTable();
    }
}
