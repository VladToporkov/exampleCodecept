package com.actionmedia.tests.functional.oss.registration;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 03/03/16.
 */
public class OSS_1182_AuthorizationBlock extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1182", testCaseVersion = "1")
    public void oss_1182_test() {
//        updateSystemInfo(SystemPubs.kss);
//        updateLoginAsInfo("kss.user.commercial");
//        report("Проверка Авторизация на сайте через форму входа КСС");
//        kss_step1();
//        kss_step2();
//        kss_step3();

        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверка Авторизация на сайте через форму входа БСС");
        bss_step1();
        bss_step2();
        bss_step3();

//        updateSystemInfo(SystemPubs.fss);
//        updateLoginAsInfo("fss.user.commercial");
//        report("Проверка Авторизация на сайте через форму входа ФСС");
//        fss_step1();
//        fss_step2();
//        fss_step3();
//
//        updateSystemInfo(SystemPubs.uss);
//        updateLoginAsInfo("uss.user.commercial");
//        report("Проверка Авторизация на сайте через форму входа ЮСС");
//        uss_step1();
//        uss_step2();
//        uss_step3();
    }

    private void kss_step1() {
        report("Страница аутентификации для документов, в которых есть быстрое оглавление");
        enterToKssWithoutLogin()
                .navigateToAnswersPage()
                .openDocumentByModuleIdAndDocId("#/document/130/50685/actual")
                .checkTitleAndAuthorInformationPresent()
                .checkDocBriefIsPresent("В этом ответе")
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent();
    }

    private void kss_step2() {
        report("Страница аутентификации для документов со сниппетами");
        enterToKssWithoutLogin()
                .navigateToAnswersPage()
                .openDocumentByModuleIdAndDocId("#/document/140/13817/actual")
                .checkDocumentHasTitleWithoutBody()
                .checkDocBriefIsPresent("Когда понадобится")
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent();
    }

    private void kss_step3() {
        report("Страница аутентификации для документов");
        enterToKssWithoutLogin()
                .navigateToAnswersPage()
                .openDocumentByModuleIdAndDocId("#/document/131/2926/actual")
                .checkDocumentHasTitleWithoutBody()
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent()

                .openDocumentByModuleIdAndDocId("#/document/140/988/actual")
                .checkDocumentHasTitleWithoutBody()
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent()

                .openDocumentByModuleIdAndDocId("#/document/117/13136/actual/")
                .checkDocumentHasTitleWithoutBody()
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent()

                .openDocumentByModuleIdAndDocId("#/document/160/15343/actual")
                .checkDocumentHasTitleWithoutBody()
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent()

                .openDocumentByModuleIdAndDocId("#/documentvideo/145/1438/actual")
                .checkDocumentHasTitleWithoutBody()
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent()

                .openDocumentByModuleIdAndDocId("#/wizard/150/120/actual")
                .checkDocumentHasTitleWithoutBody()
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent();
    }

    private void fss_step1() {
        report("Страница аутентификации для документов, в которых есть быстрое оглавление");
        enterToFssWithoutLogin()
                .navigateToSolutionsPage()
                .openDocumentByModuleIdAndDocId("#/document/173/1764/actual")
                .checkTitleAndAuthorInformationPresent()
                .checkDocBriefIsPresent("В этом решении")
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent();
    }

    private void fss_step2() {
        report("Страница аутентификации для документов со сниппетами");
        enterToFssWithoutLogin()
                .navigateToSolutionsPage()
                .openDocumentByModuleIdAndDocId("#/document/174/12/actual")
                .checkDocumentHasTitleWithoutBody()
                .checkDocBriefIsPresent("В этом решении")
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent();
    }

    private void fss_step3() {
        report("Страница аутентификации для документов со сниппетами");
        enterToFssWithoutLogin()
                .navigateToSolutionsPage()
                .openDocumentByModuleIdAndDocId("#/document/207/1991/actual")
                .checkDocumentHasTitleWithoutBody()
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent()

                .openDocumentByModuleIdAndDocId("#/document/191/192/actual")
                .checkDocumentHasTitleWithoutBody()
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent()

                .openDocumentByModuleIdAndDocId("#/document/176/102/actual")
                .checkDocumentHasTitleWithoutBody()
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent()

                .openDocumentByModuleIdAndDocId("#/document/189/405714/actual")
                .checkDocumentHasTitleWithoutBody()
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent()

                .openDocumentByModuleIdAndDocId("#/documentvideo/145/2967/actual")
                .checkDocumentHasTitleWithoutBody()
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent();
    }

    private void uss_step1() {
        report("Страница аутентификации для документов, в которых есть быстрое оглавление");
        enterToUssWithoutLogin()
                .navigateToRecomendPage()
                .openDocumentByModuleIdAndDocId("#/document/165/3055/actual")
                .checkTitleAndAuthorInformationPresent()
                .checkDocBriefIsPresent("В этой рекомендации")
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent();
    }

    private void uss_step2() {
        report("Страница аутентификации для документов со сниппетами");
        enterToUssWithoutLogin()
                .navigateToRecomendPage()
                .openDocumentByModuleIdAndDocId("#/document/118/25950/actual")
                .checkDocumentHasTitleWithoutBody()
                .checkDocBriefIsPresent("Когда понадобится")
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent();
    }

    private void uss_step3() {
        report("Страница аутентификации для документов со сниппетами");
        enterToUssWithoutLogin()
                .navigateToRecomendPage()
                .openDocumentByModuleIdAndDocId("#/document/165/3107/actual")
                .checkDocumentHasTitleWithoutBody()
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent()

                .openDocumentByModuleIdAndDocId("#/document/118/26687/actual")
                .checkDocumentHasTitleWithoutBody()
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent()

                .openDocumentByModuleIdAndDocId("#/document/169/134/actual")
                .checkDocumentHasTitleWithoutBody()
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent()

                .openDocumentByModuleIdAndDocId("#/document/189/403603/actual")
                .checkDocumentHasTitleWithoutBody()
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent()

                .openDocumentByModuleIdAndDocId("#/documentvideo/145/3282/actual")
                .checkDocumentHasTitleWithoutBody()
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent()

                .openDocumentByModuleIdAndDocId("#/wizard/150/204/actual")
                .checkDocumentHasTitleWithoutBody()
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent();
    }

    private void bss_step1() {
        report("Страница аутентификации для документов, в которых есть быстрое оглавление");
        enterToBssWithoutLogin()
                .navigateToRecomendPage()
                .openDocumentByModuleIdAndDocId("#/document/11/13695/actual")
                .checkTitleAndAuthorInformationPresent()
                .checkDocBriefIsPresent("В этой рекомендации")
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent();
    }

    private void bss_step2() {
        report("Страница аутентификации для документов со сниппетами");
        enterToBssWithoutLogin()
                .navigateToRecomendPage()
                .openDocumentByModuleIdAndDocId("#/document/118/24599/actual")
                .checkDocumentHasTitleWithoutBody()
                .checkDocBriefIsPresent("Когда понадобится")
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent();
    }

    private void bss_step3() {
        report("Страница аутентификации для документов со сниппетами");
        enterToBssWithoutLogin()
                .navigateToRecomendPage()
                .openDocumentByModuleIdAndDocId("#/document/11/14217/actual")
                .checkDocumentHasTitleWithoutBody()
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent()

                .openDocumentByModuleIdAndDocId("#/document/118/27362/actual")
                .checkDocumentHasTitleWithoutBody()
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent()

                .openDocumentByModuleIdAndDocId("#/document/117/19839/actual")
                .checkDocumentHasTitleWithoutBody()
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent()

                .openDocumentByModuleIdAndDocId("#/document/189/405876/actual")
                .checkDocumentHasTitleWithoutBody()
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent();

//                .openDocumentByModuleIdAndDocId("#/documentvideo/145/2951/actual")
//                .checkDocumentHasTitleWithoutBody()
//                .checkDocPreviewTextStatus()
//                .checkAuthFormIsPresent();
    }
}
