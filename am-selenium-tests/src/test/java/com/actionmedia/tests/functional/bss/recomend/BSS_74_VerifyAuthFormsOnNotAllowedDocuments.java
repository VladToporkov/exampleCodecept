package com.actionmedia.tests.functional.bss.recomend;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 22.04.2014
 * Time: 16:59
 */
public class BSS_74_VerifyAuthFormsOnNotAllowedDocuments extends AbstractDomainTest {

    private static final String RUBRIC_NAME = "Личная бухгалтерия";
    private static final String ONLY_AUTH_TEXT = "Документ доступен только зарегистрированным пользователям";
    private static final String ONLY_PAIED_TEXT = "Документ в платном доступе";
    private static final String SEARCH_QUERY = "документ";
    private static final String[] EXCLUDED_MODULE = new String[]{"113", "197", "199", "170"};

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-74", testCaseVersion = "2")
    @Version(section = "vip")
    public void bss_74_test() {
        enterToBssWithoutLogin()
                .navigateToRecomendPage()
                .clickRubricatorButton()
                .clickRubricFromFirstMenuByName(RUBRIC_NAME)
                .clickRandomArticle()
                .checkAuthFormIsOpened()
                .checkDocPreviewIsOpened()
                .checkTextAroundLockInDocPreview(ONLY_PAIED_TEXT, ONLY_AUTH_TEXT)

                .navigateToRecomendPage()
                .inputTextInSearchField(SEARCH_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickRandomDocumentByModuleExclude(EXCLUDED_MODULE)
                .checkAuthFormIsOpened()
                .checkDocPreviewIsOpened()
                .checkTextAroundLockInDocPreview(ONLY_PAIED_TEXT, ONLY_AUTH_TEXT)

                .navigateToRecomendPage()
                .clickNewsPaperHeaderLink()
                .clickRecomendSection()
                .clickRandomDocumentByModuleExclude(EXCLUDED_MODULE)
                .checkAuthFormIsOpened()
                .checkDocPreviewIsOpened()
                .checkTextAroundLockInDocPreview(ONLY_PAIED_TEXT, ONLY_AUTH_TEXT)

                .navigateToRecomendPage()
                .clickLinkFromYellowPlate()
                .checkAuthFormIsOpened()
                .checkDocPreviewIsOpened()
                .checkTextAroundLockInDocPreview(ONLY_PAIED_TEXT, ONLY_AUTH_TEXT)

                .openDocumentByUrl(getDocumentUrlByKey("bss.170.module"))
                .checkAuthFormIsOpened()
                .checkDocPreviewIsNotOpened()
                .checkTextAroundLockInDocPreview(ONLY_PAIED_TEXT)

                .openDocumentByUrl(getDocumentUrlByKey("bss.199.module"))
                .checkAuthFormIsOpened()
                .checkDocPreviewIsNotOpened()
                .checkTextAroundLockInDocPreview(ONLY_PAIED_TEXT)

                .openDocumentByUrl(getDocumentUrlByKey("bss.197.module"))
                .checkAuthFormIsOpened()
                .checkDocPreviewIsNotOpened()
                .checkTextAroundLockInDocPreview(ONLY_PAIED_TEXT)

                .openDocumentByUrl(getDocumentUrlByKey("bss.113.module"))
                .checkAuthFormIsOpened()
                .checkDocPreviewIsNotOpened()
                .checkTextAroundLockInDocPreview(ONLY_PAIED_TEXT);
    }
}
