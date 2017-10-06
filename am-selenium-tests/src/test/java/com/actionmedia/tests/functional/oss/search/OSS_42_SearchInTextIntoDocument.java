package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel on 13/01/16.
 */
public class OSS_42_SearchInTextIntoDocument extends AbstractDomainTest {

    private static final String[] QUERIES_1 = {"работа", "учет", "год", "закон", "кодекс"};
    private static final String[] QUERIES_2 = {"год", "закон", "кодекс", "учет", "работа"};
    private static final String QUERY_DICTIONARY = "изменение";
    private static final String DOC_DICTIONARY_URL = "#/document/117/random";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-42", testCaseVersion = "1")
    public void oss_42_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется виджет Поиск в тексте в документах БСС КУ");
        bss_test();
    }

    public void bss_test() {
        loginBss()
                .navigateToRecomendPage()
                .clickNewsPaperHeaderLink()
                .clickRecomendSection()
                .clickRandomDocument()
                .checkSearchInTextWidgetIsPresent()
                .checkSearchInTextWithSeveralQueries(QUERIES_1)
                .clearSearchBox()

                .navigateToRecomendPage()
                .clickNewsPaperHeaderLink()
                .clickLawBaseSection()
                .clickRandomDocument()
                .checkSearchInTextWidgetIsPresent()
                .checkSearchInTextWithSeveralQueries(QUERIES_2)
                .clearSearchBox()

                .openDocumentByModuleIdAndDocId(DOC_DICTIONARY_URL)
                .checkSearchInTextWidgetIsPresent()
                .inputTextInSearchBox(QUERY_DICTIONARY)
                .checkSearchInTextWidgetWork(true)
                .clearSearchBox()

                .navigateToRecomendPage()
                .clickNewsPaperHeaderLink()
                .clickNewsSection()
                .clickLastDocumentByModule("184")
                .checkSearchInTextWidgetIsPresent()

                .navigateToMagazinesPage()
                .clickRandomMagazine()
                .clickRandomArticle()
                .checkSearchInTextWidgetIsPresent()

                .logout();
    }
}
