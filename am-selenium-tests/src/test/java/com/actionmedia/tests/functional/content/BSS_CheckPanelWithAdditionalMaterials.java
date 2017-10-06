package com.actionmedia.tests.functional.content;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.backlinks_panel;

/**
 * Created by n.tyukavkin on 25.08.2016.
 */
public class BSS_CheckPanelWithAdditionalMaterials extends AbstractDomainTest {

    @Test(groups = {backlinks_panel})
    public void bss_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        loginBss()
                .openDocumentByModuleIdAndDocId("#/document/99/901714421/")
                .clickReferencesByArticleAndParagraph(1, 3, 7)
                .clickAllAdditionalMaterialsButton()
                .checkSearchResultArePresentAfterClickAllMaterialsInReferences()
                .logout();
    }
}
