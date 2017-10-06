package com.actionmedia.tests.functional.oss.videos;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * User: a.kulakov
 * Date: 03.04.2015
 * Time: 11:56
 */
public class OSS_525_VerifyVideoDocument163Module extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-525", testCaseVersion = "1")
    public void oss_525_test() {
        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется OSS-525:Общее отображение документов (163 модуль)");
        uss_519_test_36();
        uss_519_test_40();
    }

    private void uss_519_test_36() {
        loginUss()
                .openDocumentByModuleIdAndDocId("#/document/163/36/actual")
                .checkDocumentIsOpened()
                .checkInfoBarWidgetWork()
                .checkPrintButtonInKodeksIsPresent()
                .checkWordButtonInKodeksIsPresent()
                .checkVideoPlayerParts()
                .checkSoderIsPresent()
                .checkRubricatorButtonIsPresent("Все видео")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkDisplayStars()
                .logout();
    }

    private void uss_519_test_40() {
        loginUss()
                .openDocumentByModuleIdAndDocId("#/document/163/40/actual")
                .checkDocumentIsOpened()
                .checkInfoBarWidgetWork()
                .checkPrintButtonInKodeksIsPresent()
                .checkWordButtonInKodeksIsPresent()
                .checkVideoPlayerParts()
                .checkSoderIsPresent()
                .checkRubricatorButtonIsPresent("Все видео")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkDisplayStars()
                .logout();
    }
}