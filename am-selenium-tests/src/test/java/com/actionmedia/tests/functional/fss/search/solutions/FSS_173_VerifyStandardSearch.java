package com.actionmedia.tests.functional.fss.search.solutions;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 15.05.2014
 * Time: 14:34
 */
public class FSS_173_VerifyStandardSearch extends AbstractDomainTest {

    private static final String STANDARD_QUERY = "проверка эталонной выдачи";

    private static final String SOLUTION_DOCUMENT_1 = "Как определить аналитические признаки для справочников управленческого учета";
    private static final String SOLUTION_DOCUMENT_URL_1 = "/#/document/173/1048";

    private static final String SOLUTION_DOCUMENT_2 = "Как сократить финансовые риски инвестиционного проекта";
    private static final String SOLUTION_DOCUMENT_URL_2 = "/#/document/173/1098";

    private static final String FORM_DOCUMENT = "Методика учета затрат и калькулирования себестоимости продукции компании «Альфа»";
    private static final String FORM_DOCUMENT_URL_1 = "/#/document/174/138";

    private static final String LAW_BASE_DOCUMENT_1 = "Налоговый кодекс РФ. Часть первая";

    private static final String LAW_BASE_DOCUMENT_2 = "УСН: расходы на информационные услуги справочной правовой системы, заключающиеся в обновлении информационной базы";
    private static final String LAW_BASE_DOCUMENT_URL_2 = "/#/document/99/499010667";

    private static final String LAW_BASE_DOCUMENT_3 = "О применении положений статьи 343_1 Налогового Кодекса Российской Федерации";
    private static final String LAW_BASE_DOCUMENT_URL_3 = "/#/document/99/499008982";

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-173", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_173_test() {
        loginFss()
                .navigateToSolutionsPage()
                .inputTextInSearchBox(STANDARD_QUERY)
                .clickSearchButtonFss()
                .checkSearchResultOnSolutionsPageIsOpened()
                .checkDocumentWithTextIsPresent(SOLUTION_DOCUMENT_1)
                .checkDocumentWithUrlIsPresent(SOLUTION_DOCUMENT_URL_1)
                .checkDocumentWithTextIsPresent(SOLUTION_DOCUMENT_2)
                .checkDocumentWithUrlIsPresent(SOLUTION_DOCUMENT_URL_2)

                .navigateToFormsPage()
                .inputTextInSearchBox(STANDARD_QUERY)
                .clickSearchButtonFss()
                .checkSearchResultOnFormsPageIsOpened()
                .checkDocumentWithTextIsPresent(FORM_DOCUMENT)
                .checkDocumentWithUrlIsPresent(FORM_DOCUMENT_URL_1)

                .navigateToLawBasePage()
                .inputTextInSearchBox(STANDARD_QUERY)
                .clickSearchButtonFss()
                .checkSearchResultOnLawBasePageIsOpenedBoolean(false)
                .checkDocumentWithTextIsPresent(LAW_BASE_DOCUMENT_1)
                .checkDocumentWithTextIsPresent(LAW_BASE_DOCUMENT_2)
                .checkDocumentWithUrlIsPresent(LAW_BASE_DOCUMENT_URL_2)
                .checkDocumentWithTextIsPresent(LAW_BASE_DOCUMENT_3)
                .checkDocumentWithUrlIsPresent(LAW_BASE_DOCUMENT_URL_3);
    }
}
