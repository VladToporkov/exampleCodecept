package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Shman4ik on 02.03.1135.
 */
public class OSS_481_DisplayDocument113 extends AbstractDomainTest {

    public static final String BUTTON_NAME = "Весь справочник";
    public static final String DOCUMENT_URL_USS_113 = "#/document/113/17/";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-481", testCaseVersion = "1")
    public void oss_481_test() {
        //BSS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется отображение документов 113 модуля ЮСС КУ");
        ussDocument_113();
    }

    private void ussDocument_113() {
        loginUss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_USS_113)

                .checkRevisionIsValidFrom()

                .checkPrintIcon()
                .checkWordButtonIsPresent()

                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()

                .checkDisplayStarsSection()

                .logout();
    }
}
