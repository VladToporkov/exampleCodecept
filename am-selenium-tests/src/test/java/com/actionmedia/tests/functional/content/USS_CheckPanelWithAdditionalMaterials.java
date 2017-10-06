package com.actionmedia.tests.functional.content;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.backlinks_panel;

/**
 * Created by n.tyukavkin on 25.08.2016.
 */
public class USS_CheckPanelWithAdditionalMaterials extends AbstractDomainTest {

    @Test(groups = {backlinks_panel})
    public void uss_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        loginUss()
                .openDocumentByModuleIdAndDocId("#/document/99/9027690/")
                .clickReferencesByArticleAndParagraph(1, 1, 1)
                .clickAllAdditionalMaterialsButton()
                .checkSearchResultArePresentAfterClickAllMaterialsInReferences()
                .logout();
    }
}
