package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Shman4ik on 02.03.2015.
 */
public class OSS_483_DisplayDocument175 extends AbstractDomainTest {

    private static final String BUTTON_NAME = "Весь справочник";
    private static final String DOCUMENT_URL_FSS_175 = "#/document/175/14";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-483", testCaseVersion = "1")
    public void oss_483_test() {
        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется отображение документов 175 модуля ФСС КУ");
        fssDocument_175();
    }

    private void fssDocument_175() {
        loginFss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_FSS_175)
                .checkSearchIn()
                .checkMenu()

                .checkPrintIcon()
                .checkWordButtonIsPresent()

                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()

                .checkDisplayStarsSection()

                .logout();
    }
}
