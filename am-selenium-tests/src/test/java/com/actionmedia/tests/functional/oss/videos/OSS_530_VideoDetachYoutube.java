package com.actionmedia.tests.functional.oss.videos;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * User: a.kulakov
 * Date: 10.04.2015
 * Time: 16:02
 */
public class OSS_530_VideoDetachYoutube extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-530", testCaseVersion = "1")
    public void oss_530_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("OSS-530:Отключение загрузки с Youtube КСС КУ");
        kss_530_test();
    }

    private void kss_530_test() {
        loginKss()
                .navigateToPersonalCabinetPage()
                .enableVideoSourceYoutube()

                .openDocumentByUrl(getDocumentUrlByKey("kss.145.youtube.module"))
                .videoYoutubeIsEnabled()

                .disableYoutubeHosts()

                .navigateToPersonalCabinetPage() // для перезагрузки страницы с видео
                .openDocumentByUrl(getDocumentUrlByKey("kss.145.youtube.module"))

                .videoYoutubeIsDisabled()

                .enableYoutubeHosts()

                .navigateToPersonalCabinetPage()
                .disableVideoSourceYoutube()

                .openDocumentByUrl(getDocumentUrlByKey("kss.145.youtube.module"))

                .videoYoutubeIsDisabled()

                .logout();
    }
}
