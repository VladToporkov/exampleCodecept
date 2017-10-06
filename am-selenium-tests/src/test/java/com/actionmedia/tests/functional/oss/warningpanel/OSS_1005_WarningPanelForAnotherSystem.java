package com.actionmedia.tests.functional.oss.warningpanel;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel Popov on 24/09/15.
 */
public class OSS_1005_WarningPanelForAnotherSystem extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1005", testCaseVersion = "1")
    public void oss_1005_test() {
        //step1
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("oss.user.panel");
        report("Проверяется плашка в BSS \"для другого издания\"");
        String documentBss = "#/document/140/12594/";
        loginBss()
                .navigateToRecomendPage()
                .openDocumentByModuleIdAndDocId(documentBss)
                .checkWarningPanelIsLocatedAboveThanHeader()
                .checkWarningPanelWidthIsEqualsBrowserWidth()
                .checkWarningPanelHasText("У вас есть доступ к другой версии: БСС «Система Главбух» для упрощенки")
                .checkWarningPanelIsRed()
                .checkWarningPanelHasLink("БСС «Система Главбух» для упрощенки")
                .checkDocumentHasTitleWithoutBody()
                .checkAuthFormIsOpened()
                .checkTryTrialFormIsPresent()

                        //step2
                .report("Осмотреть форму авторизации")
                .checkTryTrialFormHasText("Вы сейчас находитесь в Справочной системе БСС «Система Главбух» для коммерческих организаций.\n" +
                        "A оплаченный доступ у вас есть к БСС «Система Главбух» для упрощенки.")
                .checkTryTrialForm()
                .checkTryTrialFormBSSLinkIsPresent()
                .logout();

        //step3
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("oss.user.panel");
        updateLoginToInfo("budget");
        report("Проверяется плашка в БСС БУ \"для другого издания\"");
        String documentBssBu = "#/document/11/42634/";
        loginBss()
                .navigateToRecomendPage()
                .openDocumentByModuleIdAndDocId(documentBssBu)
                .checkWarningPanelIsLocatedAboveThanHeader()
                .checkWarningPanelWidthIsEqualsBrowserWidth()
                .checkWarningPanelHasText("У вас есть доступ к другой версии: БСС «Система Главбух» для упрощенки")
                .checkWarningPanelIsRed()
                .checkWarningPanelHasLink("БСС «Система Главбух» для упрощенки")
                .checkDocumentHasTitleWithoutBody()

                        //step4
                .report("Осмотреть форму авторизации")
                .checkSubscribeActivationFormIsPresent()
                .checkSubscribeActivationFormHasText("Система требует ввести код, так как у Вас оплачен доступ к другой версии Системы Главбух.\n" +
                        "Перейти в свою версию\n" +
                        "Всего у Cистемы Главбух 4 версии:\n" +
                        "базовая для коммерческих организаций\n" +
                        "для упрощенки  —  ваша версия\n" +
                        "ВИП для коммерческих организаций\n" +
                        "для бюджетных учреждений")
                .checkSubscribeActivationFormCellPhoneNumberIsPresent()
                .checkSubscribeActivationFormBSSLinkIsPresent()
                .logout();

        //step5
        updateSystemInfo(SystemPubs.kss);
        updateLoginToInfo("vip");
        updateLoginAsInfo("oss.user.panel");
        report("Проверяется плашка в КСС ВИП \"для другого издания\"");
        String documentKssVIP = "#/document/130/51306/";
        loginKss()
                .navigateToAnswersPage()
                .openDocumentByModuleIdAndDocId(documentKssVIP)
                .checkWarningPanelIsLocatedAboveThanHeader()
                .checkWarningPanelWidthIsEqualsBrowserWidth()
                .checkWarningPanelHasText("У вас есть доступ к другой версии: КСС «Система Кадры» для коммерческих организаций")
                .checkWarningPanelIsYellow()
                .checkWarningPanelHasLink("КСС «Система Кадры» для коммерческих организаций")
                .checkDocumentHasTitleWithoutBody()
                .checkTryTrialFormIsPresent()
                .logout();

        //step6
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("oss.user.panel");
        report("Проверяется плашка в ЮСС \"для другого издания\"");
        String documentUss = "#/documentvideo/145/2757/";
        loginUss()
                .navigateToRecomendPage()
                .openDocumentByModuleIdAndDocId(documentUss)
                .checkWarningPanelIsLocatedAboveThanHeader()
                .checkWarningPanelWidthIsEqualsBrowserWidth()
                .checkWarningPanelHasText("У вас есть доступ к другой версии: ЮСС «Система Юрист» с Конструктором договоров")
                .checkWarningPanelIsYellow()
                .checkWarningPanelHasLink("ЮСС «Система Юрист» с Конструктором договоров")
                .checkDocumentHasTitleWithoutBody()
                .checkTryTrialFormIsPresent()
                .logout();
    }
}
