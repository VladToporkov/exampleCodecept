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
 * Time: 17:04
 */
public class CompareBeforeTest extends ImagesComparisonExperiment {

    @Test
    @Environment(environment = EnvironmentValue.PRODUCTION)
    public void testCreateImagesBefore() {
        String fileName = getSettings().getFileName();
        File folder = new File(FOLDER + separator + fileName);
        folder.mkdir();

        List<Doc> docList = getDocList(true);
        for (Doc doc : docList) {
            for (int pubId : doc.getPubProdIdArr()) {
                if (pubId == 6) {
                    updateLoginAsInfo("bss.user.commercial", EnvironmentValue.PRODUCTION);
                    updateLoginToInfo("", EnvironmentValue.PRODUCTION);
                } else if (pubId == 7) {
                    updateLoginAsInfo("bss.user.budget", EnvironmentValue.PRODUCTION);
                    updateLoginToInfo("budget", EnvironmentValue.PRODUCTION);
                } else if (pubId == 8) {
                    updateLoginAsInfo("bss.user.usn", EnvironmentValue.PRODUCTION);
                    updateLoginToInfo("usn", EnvironmentValue.PRODUCTION);
                } else if (pubId == 9) {
                    updateLoginAsInfo("bss.user.vip", EnvironmentValue.PRODUCTION);
                    updateLoginToInfo("vip", EnvironmentValue.PRODUCTION);
                } else {
                    continue;
                }

                loginBss()
                        .openDocumentByUrl(getCurrentUrl().split("#")[0] + "#/document/111/" + doc.getDocId() + "/")
                        .refreshPage()
                        .openAllIncuts()
                        .takeScreenShot(By.id("document-body"), "document-111-" + doc.getDocId() + "-" + pubId, getBeforeFolder())
                        .logout();
            }
            break;
        }
    }
}
