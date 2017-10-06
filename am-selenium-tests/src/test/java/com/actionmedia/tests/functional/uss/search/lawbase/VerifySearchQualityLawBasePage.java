package com.actionmedia.tests.functional.uss.search.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;

/**
 * User: n.tyukavkin
 * Date: 01.10.13
 * Time: 10:38
 */
public class VerifySearchQualityLawBasePage extends AbstractDomainTest {

    private static final String QUALITY_QUERY = "мсфо";
    private static final String QUALITY_EXPECTED_RESULT = "ПОСТАНОВЛЕНИЕ ПРАВИТЕЛЬСТВА РФ ОТ 25.02.2011 № 107\n" +
            "Об утверждении Положения о признании Международных стандартов финансовой отчетности и " +
            "Разъяснений Международных стандартов финансовой отчетности для применения на территории Российской Федерации (с изменениями на 26 августа 2013 года)";


    private static final String QUERY_WITH_ATTRIBUTE = "об образовании";
    private static final String ATTRIBUTE = "Закон";
    private static final String SEARCH_WITH_ATTRIBUTE_RESULT_1 = "ФЕДЕРАЛЬНЫЙ ЗАКОН ОТ 29.12.2012 № 273-ФЗ\n" +
            "Об образовании в Российской Федерации";

//    private static final String SEARCH_WITH_ATTRIBUTE_RESULT_2 = "ФЕДЕРАЛЬНЫЙ ЗАКОН ОТ 22.08.1996 № 125-ФЗ\n" +
//            "О высшем и послевузовском профессиональном образовании";


    private static final String QUERY_WITHOUT_TEXT = "123-фз";
    private static final String ATTRIBUTE_WITHOUT_TEXT = "Федеральный закон";
    private static final String SEARCH_WITHOUT_TEXT_RESULT_1 = "ФЕДЕРАЛЬНЫЙ ЗАКОН ОТ 07.06.2013 № 123-ФЗ\n" +
            "О внесении изменений в Земельный кодекс Российской Федерации и статью 3 Федерального закона \"О введении в действие Земельного кодекса Российской Федерации\"";
    private static final String SEARCH_WITHOUT_TEXT_RESULT_2 = "ФЕДЕРАЛЬНЫЙ ЗАКОН ОТ 20.07.2012 № 123-ФЗ\n" +
            "О создании Троицкого и Щербинского районных судов города Москвы и об определении территорий, на которые распространяется юрисдикция отдельных районных судов города Москвы и городских судов Московской области";
    private static final String SEARCH_WITHOUT_TEXT_RESULT_3 = "ФЕДЕРАЛЬНЫЙ ЗАКОН ОТ 04.06.2011 № 123-ФЗ\n" +
            "О внесении изменений в Жилищный кодекс Российской Федерации и отдельные законодательные акты Российской Федерации (с изменениями на 25 июня 2012 года)";


    private static final String QUERY_WITH_TAG = "плата за образование ребенка";
    private static final String TAG = "Федеральная налоговая служба";
    private static final String SEARCH_WITH_TAG_RESULT = "ПИСЬМО ФНС РОССИИ ОТ 17.09.2009 № ШС-22-3/719\n" +
            "По вопросу освобождения от налогообложения компенсации части родительской платы за содержание ребенка в образовательных учреждениях";


    private static final String QUERY_WITH_STATUS_FILTER = "закон о бухучете";
    private static final String SEARCH_WITH_STATUS_RESULT = "ФЕДЕРАЛЬНЫЙ ЗАКОН ОТ 21.11.1996 № 129-ФЗ\n" +
            "О бухгалтерском учете";


    private static final String TYPO_QUERY = "ext";
    private static final String TYPO_EXPECTED_RESULT = "учет";


    private static final String NOT_PRESENT_QUERY = "А55-2000/2010";
    private static final String NOT_PRESENT_RESULT_1 = "ПОСТАНОВЛЕНИЕ ФАС ПО ОТ 20.10.2010";
    private static final String NOT_PRESENT_RESULT_2 = "№ А55-2000/2010";
    private static final String NOT_PRESENT_RESULT_3 = "Дело А55-2000/2010";
    private static final String NOT_PRESENT_RESULT_4 = "А55-2000/2010";


    //    @Test(groups = {smoke, implemented})
    @LoginAs(key = "uss.user.commercial")
    public void uss_test() {
        loginKss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUALITY_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnLawBasePageIsOpened(true)
                .checkDocumentWithTextIsPresent(QUALITY_EXPECTED_RESULT)

                .report("Проверяется поиск по реквизитам с текстом")
                .clickExtendedButtonInSearchBox()
                .clearAllExtendedAttributes()
                .inputTextInSearchBox(QUERY_WITH_ATTRIBUTE)
                .inputViewInExtendedByName(ATTRIBUTE)
                .clickSearchExtendedButton()
                .checkDocumentWithTextIsPresent(SEARCH_WITH_ATTRIBUTE_RESULT_1)
//                .checkDocumentWithTextIsPresent(SEARCH_WITH_ATTRIBUTE_RESULT_2)

                .report("Проверяется поиск по реквизитам без текста")
                .clickExtendedButtonInSearchBox()
                .clearSearchBoxOnSearchResultPage()
                .clearAllExtendedAttributes()
                .inputNumberInExtendedByName(QUERY_WITHOUT_TEXT)
                .inputViewInExtendedByName(ATTRIBUTE_WITHOUT_TEXT)
                .clickSearchExtendedButton()
                .checkDocumentWithTextIsPresent(SEARCH_WITHOUT_TEXT_RESULT_1)
                .checkDocumentWithTextIsPresent(SEARCH_WITHOUT_TEXT_RESULT_2)
                .checkDocumentWithTextIsPresent(SEARCH_WITHOUT_TEXT_RESULT_3)

                .report("Проверяется поиск с тегами")
                .clickExtendedButtonInSearchBox()
                .clearAllExtendedAttributes()
                .inputTextInSearchBox(QUERY_WITH_TAG)
                .inputDepartmentInExtendedByName(TAG)
                .clickSearchExtendedButton()
                .checkDocumentWithTextIsPresent(SEARCH_WITH_TAG_RESULT)

                .report("Проверяется поиск по статусу")
                .inputTextInSearchBox(QUERY_WITH_STATUS_FILTER)
                .clickSearchButtonOnSearchPage()
                .clickNotActiveStatus()
                .checkDocumentWithTextIsPresent(SEARCH_WITH_STATUS_RESULT)

                .report("Проверяется опечатки и раскладка клавиатуры")
                .inputTextInSearchBox(TYPO_QUERY)
                .clickSearchButtonOnSearchPage()
                .checkTypoWasFixed(TYPO_QUERY, TYPO_EXPECTED_RESULT)
                .checkDocumentWithTextIsPresent(TYPO_EXPECTED_RESULT)

                .report("Проверяется специфические для ЮСС документы")
                .inputTextInSearchBox(NOT_PRESENT_QUERY)
                .clickSearchButtonOnSearchPage()
                .checkDocumentWithTextIsNotPresent(NOT_PRESENT_RESULT_1)
                .checkDocumentWithTextIsNotPresent(NOT_PRESENT_RESULT_2)
                .checkDocumentWithTextIsNotPresent(NOT_PRESENT_RESULT_3)
                .checkDocumentWithTextIsNotPresent(NOT_PRESENT_RESULT_4)
                .logout();
    }
}
