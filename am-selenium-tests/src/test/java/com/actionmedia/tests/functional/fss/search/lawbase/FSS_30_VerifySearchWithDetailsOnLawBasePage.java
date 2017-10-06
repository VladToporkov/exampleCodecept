package com.actionmedia.tests.functional.fss.search.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 15.11.13
 * Time: 09:48
 */
public class FSS_30_VerifySearchWithDetailsOnLawBasePage extends AbstractDomainTest {

    private static final String QUERY = "об образовании";
    private static final String DOCUMENT_1 = "ФЕДЕРАЛЬНЫЙ ЗАКОН от 29.12.2012 № 273-ФЗ Об образовании в Российской Федерации";

    private static final String DOCUMENT_2 = "ФЕДЕРАЛЬНЫЙ ЗАКОН от 22.08.1996 № 125-ФЗ О высшем и послевузовском профессиональном образовании";

    private static final String DOCUMENT_WITH_1 = "ФЕДЕРАЛЬНЫЙ ЗАКОН от 20.07.2012 № 123-ФЗ " +
            "О создании Троицкого и Щербинского районных судов города Москвы и об определении территорий, " +
            "на которые распространяется юрисдикция отдельных районных судов города Москвы и городских судов Московской области";

    private static final String DOCUMENT_WITH_2 = "ФЕДЕРАЛЬНЫЙ ЗАКОН от 04.06.2011 № 123-ФЗ " +
            "О внесении изменений в Жилищный кодекс Российской Федерации и отдельные законодательные акты Российской Федерации";

    private static final String NUMBER = "123-фз";
    private static final String VIEW = "Закон";
    private static final String REGION = "РФ";

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-30", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_30_test() {
        loginFss()
                .navigateToLawBasePage()
                .checkSearchBoxPresentOnLawBasePage()
                .clickExtendedFormButton()
                .inputTextInSearchBox(QUERY)
                .inputViewInExtendedByName(VIEW)
                .clickExtendedSearchButton()
                .checkSearchResultOnLawBasePageIsOpenedBoolean(true)
                .checkDocumentWithTextIsPresent(DOCUMENT_1)
                .checkDocumentWithTextIsPresent(DOCUMENT_2)

                .clearSearchBox()
                .clickExtendedFormButton()
                .inputNumberDocument(NUMBER)
                .inputViewInExtendedByName(VIEW)
                .inputRegionInExtendedByName(REGION)
                .clickExtendedSearchButton()
                .checkSearchResultOnLawBasePageIsOpenedBoolean(true)
                .checkDocumentWithTextIsPresent(DOCUMENT_WITH_1)
                .checkDocumentWithTextIsPresent(DOCUMENT_WITH_2);
    }
}
