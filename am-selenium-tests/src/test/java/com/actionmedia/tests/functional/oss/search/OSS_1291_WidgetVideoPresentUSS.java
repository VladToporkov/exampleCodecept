package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 05/11/15.
 */
public class OSS_1291_WidgetVideoPresentUSS extends AbstractDomainTest {

    private static final String QUERY = "случаи";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1291", testCaseVersion = "1")
    public void oss_1291_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Колдунщик Видео ЮСС КУ");
        test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Колдунщик Видео ЮСС ВИП");
        test();
    }

    private void test() {
        loginUss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetVideoPresent()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkVideoSearchWidgetIsNotPresent();
    }
}
