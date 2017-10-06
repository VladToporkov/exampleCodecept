package com.actionmedia.tests.functional.fss.search.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 13.05.2014
 * Time: 10:08
 */
public class FSS_185_VerifySearchOnlyInTitles extends AbstractDomainTest {

    private static final String TEMP_QUERY = "123";
    private static final String QUERY = "о рассмотрении проекта федерального закона";

    private static final String ONLY_TITLES_HEADER = "Вы искали только в заголовках документов.";
    private static final String LAB_BASE_SEARCH_HEADER = "В правовой базе по запросу «";
    private static final String FOUNDED = "» найдено";

    private static final String SEARCH_TYPE_PHRASE = "Поиск по фразному индексу без УСС";
    private static final String SEARCH_TYPE_TITLES = "Поиск по заголовкам";

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "FSS-185", testCaseVersion = "1")
    @LoginAs(key = "fss.user.expert")
    public void fss_185_test() {
        loginFss()
                .navigateToLawBasePage()
                .clickExtendedFormButton()
                .checkOnlyInTitlesCheckBoxIsEnabled()
                .checkOnlyInTitlesCheckBoxIsNotSelected()

                .inputTextInSearchBox(TEMP_QUERY)
                .checkOnlyInTitlesCheckBoxIsEnabled()
                .checkOnlyInTitlesCheckBoxIsNotSelected()

                .selectOnlyInTitlesCheckBox()
                .clickExtendedSearchButton()
                .clickExtendedFormButton()
                .checkOnlyInTitlesCheckBoxIsEnabled()
                .checkOnlyInTitlesCheckBoxIsNotSelected()

                .inputTextInSearchBox(QUERY)
                .deSelectOnlyInTitlesCheckBox()
                .clickExtendedSearchButton()
                .checkSearchResultHeaderContainsText(LAB_BASE_SEARCH_HEADER + QUERY + FOUNDED)
                .checkSearchResultHeaderNotContainsText(ONLY_TITLES_HEADER)
                .checkSearchTypeListContainsDefinedTypes(SEARCH_TYPE_PHRASE, SEARCH_TYPE_TITLES)

                .clickExtendedFormButton()
                .inputTextInSearchBox(QUERY)
                .selectOnlyInTitlesCheckBox()
                .clickExtendedSearchButton()
                .checkSearchResultHeaderContainsText(LAB_BASE_SEARCH_HEADER + QUERY + FOUNDED)
                .checkSearchResultHeaderContainsText(ONLY_TITLES_HEADER)
                .checkSearchTypeListContainsDefinedTypes(SEARCH_TYPE_TITLES)
                .checkSearchTypeListNotContainsDefinedTypes(SEARCH_TYPE_PHRASE)

                .clickExtendedFormButton()
                .inputTextInSearchBox(TEMP_QUERY)
                .selectOnlyInTitlesCheckBox()
                .clickExtendedSearchButton()
                .checkSearchResultHeaderContainsText(LAB_BASE_SEARCH_HEADER + TEMP_QUERY + FOUNDED)
                .checkSearchResultHeaderContainsText(ONLY_TITLES_HEADER)
                .checkSearchTypeListContainsDefinedTypes(SEARCH_TYPE_TITLES)
                .checkSearchTypeListNotContainsDefinedTypes(SEARCH_TYPE_PHRASE);
    }
}
