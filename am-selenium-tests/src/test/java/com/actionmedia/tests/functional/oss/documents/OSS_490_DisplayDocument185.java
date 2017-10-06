package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Shman4ik on 02.03.2015.
 */
public class OSS_490_DisplayDocument185 extends AbstractDomainTest {

    public static final String BUTTON_NAME = "Весь справочник";
    public static final String DOCUMENT_URL_FSS_185 = "#/document/185/63";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-490", testCaseVersion = "1")
    public void oss_490_test() {
        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется отображение документов 185 модуля ФСС КУ");
        fssDocument_185();
    }

    private void fssDocument_185() {
        loginFss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_FSS_185)
                .checkSearchIn()

                .checkPrintIcon()
                .checkWordButtonIsPresent()

                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()

                .checkDisplayStarsSection()

                .logout();
    }
}
