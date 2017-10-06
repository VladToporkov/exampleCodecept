package com.actionmedia.tests.functional.fss.search.magazines;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 14.11.13
 * Time: 16:48
 */
public class FSS_31_VerifySearchOnMagazinesPage extends AbstractDomainTest {

    private static final String QUERY_MAGAZINE = "трудный рабочий день";
    private static final String DOCUMENT_MAGAZINE = "Журнал «Главбух», № 12, июнь 2013 «После трудного рабочего дня срываюсь на муже и ребенке. Помогите исправиться!»";

    private static final String QUERY_BOOK = "mckinsey инструменты";
    private static final String DOCUMENT_BOOK = "Книга «Инструменты McKinsey. Лучшая практика решения бизнес-проблем», И. Расиел, П. Фрига";

    private static final String QUERY_WITH_TAG = "мсфо";
    private static final String FILTER = "Главбух";


    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-31", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_31_test() {
        loginFss()
                .navigateToMagazinesPage()
                .checkSearchBoxPresentOnMagazinePage()
                .inputTextInSearchBox(QUERY_MAGAZINE)
                .clickSearchButtonFss()
                .checkSearchResultOnMagazinesPageIsOpened()
                .checkDocumentWithTextIsPresent(DOCUMENT_MAGAZINE)

                .inputTextInSearchBox(QUERY_BOOK)
                .clickSearchButtonFss()
                .checkSearchResultOnMagazinesPageIsOpened()
                .checkDocumentWithTextIsPresent(DOCUMENT_BOOK)

                .inputTextInSearchBox(QUERY_WITH_TAG)
                .clickSearchButtonFss()
                .clickFilterByName(FILTER)
                .checkWordFromQueryIsHighlighted(QUERY_WITH_TAG);
    }
}
