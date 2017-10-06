package com.actionmedia.tests.functional.content;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.backlinks_panel;

/**
 * Created by n.tyukavkin on 25.08.2016.
 */
public class KSS_CheckPanelWithAdditionalMaterials extends AbstractDomainTest {

    @Test(groups = {backlinks_panel})
    public void kss_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        loginKss()
                .openDocumentByModuleIdAndDocId("#/document/99/901807664/")
                .clickReferencesByArticleAndParagraph(10, 2, 2)
                .clickAllAdditionalMaterialsButton()
                .checkSearchResultArePresentAfterClickAllMaterialsInReferences()
                .logout();
    }
}
