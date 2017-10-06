package com.actionmedia.tests.functional.oss.warningpanel;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel Popov on 23/09/15.
 */
public class OSS_1004_WarningPanelFreeView extends AbstractDomainTest {


    private final String documentBss = "#/document/99/901714421/";
    private final String documentUss = "#/document/96/679701659/";
    private final String documentKss = "#/document/99/499088031/";
    private final String documentFss = "#/document/99/902316088/";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1004", testCaseVersion = "2")
    public void oss_1004_test() {
        updateSystemInfo(SystemPubs.bss);
        report("Проверяется плашка в BSS");
        enterToBssWithoutLogin()
                .navigateToRecomendPage()
                .openDocumentByModuleIdAndDocId(documentBss)
                .checkWarningPanelIsLocatedAboveThanHeader()
                .checkWarningPanelWidthIsEqualsBrowserWidth()
                .checkWarningPanelIsRed()
                .checkWarningPanelHasText("Материал для бесплатного просмотра. Для получения полного доступа " +
                        "(включая скачивание) оформите демодоступ на три дня.")
                .checkWarningPanelHasLink("демодоступ на три дня");

        updateSystemInfo(SystemPubs.uss);
        report("Проверяется плашка в USS");
        enterToUssWithoutLogin()
                .navigateToRecomendPage()
                .openDocumentByModuleIdAndDocId(documentUss)
                .checkWarningPanelIsLocatedAboveThanHeader()
                .checkWarningPanelWidthIsEqualsBrowserWidth()
                .checkWarningPanelIsYellow()
                .checkWarningPanelHasText("Материал для бесплатного просмотра. Для получения полного доступа " +
                        "(включая скачивание) оформите демодоступ на три дня.")
                .checkWarningPanelHasLink("демодоступ на три дня")
                .checkWarningPanelDemoLinkIsOpened();

        updateSystemInfo(SystemPubs.kss);
        report("Проверяется плашка в KSS");
        enterToKssWithoutLogin()
                .navigateToAnswersPage()
                .openDocumentByModuleIdAndDocId(documentKss)
                .checkWarningPanelIsLocatedAboveThanHeader()
                .checkWarningPanelWidthIsEqualsBrowserWidth()
                .checkWarningPanelIsYellow()
                .checkWarningPanelHasText("Материал для бесплатного просмотра. Для получения полного доступа " +
                        "(включая скачивание) оформите демодоступ на три дня.")
                .checkWarningPanelHasLink("демодоступ на три дня");

        updateSystemInfo(SystemPubs.fss);
        report("Проверяется плашка в FSS");
        enterToFssWithoutLogin()
                .navigateToSolutionsPage()
                .openDocumentByModuleIdAndDocId(documentFss)
                .checkWarningPanelIsLocatedAboveThanHeader()
                .checkWarningPanelWidthIsEqualsBrowserWidth()
                .checkWarningPanelIsRed()
                .checkWarningPanelHasText("Материал для бесплатного просмотра. Для получения полного доступа " +
                        "(включая скачивание) оформите демодоступ на три дня.")
                .checkWarningPanelHasLink("демодоступ на три дня");

    }
}
