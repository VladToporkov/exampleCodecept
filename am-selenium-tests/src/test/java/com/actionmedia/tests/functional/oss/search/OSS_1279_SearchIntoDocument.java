package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel on 21/12/15.
 */
public class OSS_1279_SearchIntoDocument extends AbstractDomainTest {

    private static final String QUERY = "суд";
    private static final String PART_DOC_URL = "/#/document/98/5058589";

    private static final String QUERY_DOC_DETAILS = "ЭКОНОМИЧЕСКИМ";
    private static final String QUERY_COLLOCATION = "В судебном заседании";

    //special characters
    private static final String SC_SLASH = "/";
    private static final String SC_FULL_STOP = ".";
    private static final String SC_COMMA = ",";
    private static final String SC_APOSTROPHE = "\'";
    private static final String SC_LEFT_PARENTHESIS = Keys.chord(Keys.SHIFT, "9");
    private static final String SC_RIGHT_PARENTHESIS = ")";
    private static final String SC_HYPHEN_MINUS = "-";
    private static final String SC_PLUS_SIGN = "+";
    private static final String SC_LESS_THAN_SIGN = "<";
    private static final String SC_GREATER_THAN_SIGN = ">";
    private static final String SC_QUESTION_MARK = "?";
    private static final String SC_AMPERSAND = Keys.chord(Keys.SHIFT, "7");
    private static final String SC_CIRCUMFLEX_ACCENT = "^";
    private static final String SC_PERCENT_SIGN = "%";
    private static final String SC_DOLLAR_SIGN = "$";
    private static final String SC_HASH_TAG = "#";
    private static final String SC_AT_SIGN = Keys.chord(Keys.SHIFT, "2");
    private static final String SC_EXCLAMATION_SIGN = Keys.chord(Keys.SHIFT, "1");

    private static final String QUERY_LAW_PRACTICE = "российской";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1279", testCaseVersion = "1")
    public void oss_1279_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.expert");
        report("Проверяется Подгрузка результатов поисковой выдачи КСС КУ");
        kss_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.expert");
        report("Проверяется Подгрузка результатов поисковой выдачи БСС КУ");
        bss_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.expert");
        report("Проверяется Подгрузка результатов поисковой выдачи ЮСС КУ");
        uss_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.expert");
        report("Проверяется Подгрузка результатов поисковой выдачи ФСС КУ");
        fss_test();
    }

    private void kss_test() {
        loginKss()
                .navigateToAnswersPage()
                .openDocumentByModuleIdAndDocId(PART_DOC_URL)
                .checkSearchInTextWidgetIsPresent()
                .inputTextInSearchBoxForSearchInText(QUERY)
                .clickHeader()
                .checkArrowsInSearchInText(QUERY)
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(QUERY_DOC_DETAILS)
                .clickHeader()
                .checkSearchInTextWidgetWork(false)
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(QUERY_COLLOCATION)
                .clickHeader()
                .checkSearchInTextWidgetWork(false)
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_SLASH)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_FULL_STOP)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_COMMA)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_APOSTROPHE)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_LEFT_PARENTHESIS)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_RIGHT_PARENTHESIS)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_HYPHEN_MINUS)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_PLUS_SIGN)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_LESS_THAN_SIGN)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_GREATER_THAN_SIGN)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_QUESTION_MARK)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_CIRCUMFLEX_ACCENT)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_PERCENT_SIGN)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_DOLLAR_SIGN)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_HASH_TAG)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_AT_SIGN)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_EXCLAMATION_SIGN)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_AMPERSAND)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY_LAW_PRACTICE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickInLawPracticeLinkFilter()
                .clickRandomDocument()
                .inputTextInSearchBox(QUERY_LAW_PRACTICE)
                .checkArrowsInSearchInText(QUERY_LAW_PRACTICE)
                .clearSearchBox()

                .logout();
    }

    private void bss_test() {
        loginBss()
                .navigateToRecomendPage()
                .openDocumentByModuleIdAndDocId(PART_DOC_URL)
                .checkSearchInTextWidgetIsPresent()
                .inputTextInSearchBoxForSearchInText(QUERY)
                .clickHeader()
                .checkArrowsInSearchInText(QUERY)
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(QUERY_DOC_DETAILS)
                .clickHeader()
                .checkSearchInTextWidgetWork(false)
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(QUERY_COLLOCATION)
                .clickHeader()
                .checkSearchInTextWidgetWork(false)
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_SLASH)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_FULL_STOP)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_COMMA)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_APOSTROPHE)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_LEFT_PARENTHESIS)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_RIGHT_PARENTHESIS)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_HYPHEN_MINUS)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_PLUS_SIGN)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_LESS_THAN_SIGN)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_GREATER_THAN_SIGN)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_QUESTION_MARK)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_CIRCUMFLEX_ACCENT)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_PERCENT_SIGN)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_DOLLAR_SIGN)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_HASH_TAG)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_AT_SIGN)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_EXCLAMATION_SIGN)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_AMPERSAND)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY_LAW_PRACTICE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickInLawPracticeLinkFilter()
                .clickRandomDocument()
                .inputTextInSearchBox(QUERY_LAW_PRACTICE)
                .checkArrowsInSearchInText(QUERY_LAW_PRACTICE)
                .clearSearchBox()

                .logout();
    }

    private void fss_test() {
        loginFss()
                .navigateToSolutionsPage()
                .openDocumentByModuleIdAndDocId(PART_DOC_URL)
                .checkSearchInTextWidgetIsPresent()
                .inputTextInSearchBoxForSearchInText(QUERY)
                .clickHeader()
                .checkArrowsInSearchInText(QUERY)
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(QUERY_DOC_DETAILS)
                .clickHeader()
                .checkSearchInTextWidgetWork(false)
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(QUERY_COLLOCATION)
                .clickHeader()
                .checkSearchInTextWidgetWork(false)
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_SLASH)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_FULL_STOP)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_COMMA)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_APOSTROPHE)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_LEFT_PARENTHESIS)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_RIGHT_PARENTHESIS)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_HYPHEN_MINUS)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_PLUS_SIGN)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_LESS_THAN_SIGN)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_GREATER_THAN_SIGN)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_QUESTION_MARK)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_CIRCUMFLEX_ACCENT)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_PERCENT_SIGN)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_DOLLAR_SIGN)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_HASH_TAG)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_AT_SIGN)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_EXCLAMATION_SIGN)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_AMPERSAND)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY_LAW_PRACTICE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickInLawPracticeLinkFilter()
                .clickRandomDocument()
                .inputTextInSearchBox(QUERY_LAW_PRACTICE)
                .checkArrowsInSearchInText(QUERY_LAW_PRACTICE)
                .clearSearchBox()

                .logout();
    }

    private void uss_test() {
        loginUss()
                .navigateToRecomendPage()
                .openDocumentByModuleIdAndDocId(PART_DOC_URL)
                .checkSearchInTextWidgetIsPresent()
                .inputTextInSearchBoxForSearchInText(QUERY)
                .clickHeader()
                .checkArrowsInSearchInText(QUERY)
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(QUERY_DOC_DETAILS)
                .clickHeader()
                .checkSearchInTextWidgetWork(false)
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(QUERY_COLLOCATION)
                .clickHeader()
                .checkSearchInTextWidgetWork(false)
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_SLASH)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_FULL_STOP)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_COMMA)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_APOSTROPHE)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_LEFT_PARENTHESIS)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_RIGHT_PARENTHESIS)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_HYPHEN_MINUS)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_PLUS_SIGN)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_LESS_THAN_SIGN)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_GREATER_THAN_SIGN)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_QUESTION_MARK)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_CIRCUMFLEX_ACCENT)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_PERCENT_SIGN)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_DOLLAR_SIGN)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_HASH_TAG)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_AT_SIGN)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_EXCLAMATION_SIGN)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .inputTextInSearchBoxForSearchInText(SC_AMPERSAND)
                .clickHeader()
                .checkDocumentSearchWithNoResult()
                .clearSearchBox()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY_LAW_PRACTICE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickInLawPracticeLinkFilter()
                .clickRandomDocument()
                .inputTextInSearchBox(QUERY_LAW_PRACTICE)
                .checkArrowsInSearchInText(QUERY_LAW_PRACTICE)
                .clearSearchBox()

                .logout();
    }
}