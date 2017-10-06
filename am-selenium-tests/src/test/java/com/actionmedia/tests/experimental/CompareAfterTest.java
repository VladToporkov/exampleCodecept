package com.actionmedia.tests.experimental;

import com.actionmedia.autotest.EnvironmentValue;
import com.actionmedia.autotest.annotations.Environment;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

import static java.io.File.separator;

/**
 * User: n.tyukavkin
 * Date: 17.08.2014
 * Time: 17:06
 */
public class CompareAfterTest extends ImagesComparisonExperiment {

    @Test
    @Environment(environment = EnvironmentValue.TBD)
    public void testCreateImagesAfter() {
        String fileName = getSettings().getFileName();
        File folder = new File(FOLDER + separator + fileName.split(".xls")[0]);
        folder.mkdir();

        List<Doc> docList = getDocList(false);
        for (Doc doc : docList) {
            for (int pubId : doc.getPubIdArr()) {
                if (pubId == 6) {
                    updateLoginAsInfo("bss.user.commercial", EnvironmentValue.TBD);
                    updateLoginToInfo("", EnvironmentValue.TBD);
                } else if (pubId == 7) {
                    updateLoginAsInfo("bss.user.budget", EnvironmentValue.TBD);
                    updateLoginToInfo("budget", EnvironmentValue.TBD);
                } else if (pubId == 8) {
                    updateLoginAsInfo("bss.user.usn", EnvironmentValue.TBD);
                    updateLoginToInfo("usn", EnvironmentValue.TBD);
                } else if (pubId == 9) {
                    updateLoginAsInfo("bss.user.vip", EnvironmentValue.TBD);
                    updateLoginToInfo("vip", EnvironmentValue.TBD);
                } else {
                    continue;
                }

                loginBss()
                        .openDocumentByUrl(getCurrentUrl().split("#")[0] + "#/document/11/" + doc.getDocId() + "/")
                        .refreshPage()
                        .openAllIncuts()
                        .takeScreenShot(By.id("document-body"), "document-111-" + doc.getDocId() + "-" + pubId, getAfterFolder())
                        .logout();
            }
            break;
        }
    }
}
