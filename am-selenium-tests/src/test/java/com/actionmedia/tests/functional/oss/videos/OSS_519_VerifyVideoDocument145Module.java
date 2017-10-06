package com.actionmedia.tests.functional.oss.videos;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * User: a.kulakov
 * Date: 31.03.2015
 * Time: 15:46
 */
public class OSS_519_VerifyVideoDocument145Module extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-519", testCaseVersion = "1")
    public void oss_519_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется OSS-519: Документы Видео / Общее отображение документов (145 модуль) КСС КУ");
        kss_519_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется OSS-519: Документы Видео / Общее отображение документов (145 модуль) БСС КУ");
        bss_519_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется OSS-519: Документы Видео / Общее отображение документов (145 модуль) ЮСС КУ");
        uss_519_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется OSS-519: Документы Видео / Общее отображение документов (145 модуль) ФСС КУ");
        fss_519_test();
    }

    private void kss_519_test() {
        loginKss()
                .navigateToVideoPage()
                .openDocumentByModuleIdAndDocId("#/documentvideo/145/2576/actual")
                .checkDocumentIsOpened()
                .checkVideoVersionIsPresent()
                .checkVideoPlayerIsPresent()
                .checkNavigationButtonsForVideoArePresent()
                .checkVideoTitleIsPresent()
                .checkVideoPartTitleIsPresent()
                .checkVideoPartsArePresent()
                .checkActivePartHasPlayButton()
                .checkRubricatorButtonIsPresent("Все видео")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonIsPresent()

                .openDocumentByModuleIdAndDocId("#/documentvideo/145/1713/actual")
                .checkDocumentIsOpened()
                .checkVideoVersionIsPresent()
                .checkVideoPlayerIsPresent()
                .checkNavigationButtonsForVideoArePresent()
                .checkVideoTitleIsPresent()
                .checkVideoPartTitleIsPresent()
                .checkVideoPartsArePresent()
                .checkActivePartHasPlayButton()
                .checkRubricatorButtonIsPresent("Все видео")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonIsPresent()
                .logout();
    }

    private void bss_519_test() {
        loginBss()
                .navigateToVideoPage()
                .openDocumentByModuleIdAndDocId("#/documentvideo/145/3245/actual")
                .checkVideoDocumentIsOpened()
                .checkVideoVersionIsPresent()
                .checkVideoPlayerIsPresent()
                .checkNavigationButtonsForVideoArePresent()
                .checkVideoTitleIsPresent()
                .checkVideoPartTitleIsPresent()
                .checkVideoPartsArePresent()
                .checkActivePartHasPlayButton()
                .checkRubricatorButtonIsPresent("Все видеосеминары")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonIsPresent()

                .openDocumentByModuleIdAndDocId("#/documentvideo/145/1351/actual")
                .checkVideoDocumentIsOpened()
                .checkVideoVersionIsPresent()
                .checkVideoPlayerIsPresent()
                .checkNavigationButtonsForVideoArePresent()
                .checkVideoTitleIsPresent()
                .checkVideoPartTitleIsPresent()
                .checkVideoPartsArePresent()
                .checkActivePartHasPlayButton()
                .checkRubricatorButtonIsPresent("Все видеосеминары")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonIsPresent()
                .logout();
    }

    private void uss_519_test() {
        loginUss()
                .navigateToVideoPage()
                .openDocumentByModuleIdAndDocId("#/documentvideo/145/2598/actual")
                .checkDocumentIsOpened()
                .checkVideoVersionIsPresent()
                .checkVideoPlayerIsPresent()
                .checkNavigationButtonsForVideoArePresent()
                .checkVideoTitleIsPresent()
                .checkVideoPartTitleIsPresent()
                .checkVideoPartsArePresent()
                .checkActivePartHasPlayButton()
                .checkRubricatorButtonIsPresent("Все видео")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonIsPresent()

                .openDocumentByModuleIdAndDocId("#/documentvideo/145/2654/actual")
                .checkDocumentIsOpened()
                .checkVideoVersionIsPresent()
                .checkVideoPlayerIsPresent()
                .checkNavigationButtonsForVideoArePresent()
                .checkVideoTitleIsPresent()
                .checkVideoPartTitleIsPresent()
                .checkVideoPartsArePresent()
                .checkActivePartHasPlayButton()
                .checkRubricatorButtonIsPresent("Все видео")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonIsPresent()
                .logout();
    }

    private void fss_519_test() {
        loginFss()
                .navigateToVideoPage()
                .openDocumentByModuleIdAndDocId("#/documentvideo/145/2565/actual")
                .checkDocumentIsOpened()
                .checkVideoPlayerIsPresent()
                .checkVideoTitleIsPresent()
                .checkVideoPartsArePresent()
                .checkActivePartHasPlayButton()
                .checkRubricatorButtonIsPresent("Все видеосеминары")
                .checkAddToFavoritesButtonIsPresent()
                .logout();
    }
}
