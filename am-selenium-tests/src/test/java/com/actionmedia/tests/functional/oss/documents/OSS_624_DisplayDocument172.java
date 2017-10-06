package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 14/02/16.
 */
public class OSS_624_DisplayDocument172 extends AbstractDomainTest {

    private final static String DOC_PART_URL = "#/document/172/4";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-624", testCaseVersion = "1")
    public void oss_624_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Общее отображение документов 172 модуль ФСС КУ");
        fssDocument_172();
    }

    private void fssDocument_172() {
        loginFss()
                .openDocumentByModuleIdAndDocId(DOC_PART_URL)
                .checkMenu()
                .checkWordButtonIsPresent()
                .checkMailButtonIsPresent()
                .checkPrintIcon()

                .checkTitleAndAuthorInformationPresent()
                .checkContentIsPresent()

                .checkSoderIsPresent()

                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkRubricatorButtonIsPresent("Все решения")

                .checkAddToFavoritesButtonsForDocumentArePresent()

                .logout();
    }
}
