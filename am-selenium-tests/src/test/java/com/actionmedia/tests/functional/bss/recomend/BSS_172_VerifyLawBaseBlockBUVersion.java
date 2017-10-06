package com.actionmedia.tests.functional.bss.recomend;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 16.04.2014
 * Time: 18:22
 */
public class BSS_172_VerifyLawBaseBlockBUVersion extends AbstractDomainTest {

    private static final String KODEKS_1 = "Налоговый кодекс Российской Федерации";
    private static final String KODEKS_2 = "Трудовой кодекс Российской Федерации";
    private static final String KODEKS_3 = "Гражданский кодекс Российской Федерации";
    private static final String KODEKS_4 = "Кодекс Российской Федерации об административных правонарушениях";
    private static final String KODEKS_5 = "Семейный кодекс Российской Федерации";
    private static final String KODEKS_6 = "Бюджетный кодекс Российской Федерации";

    private static final String[] kodeksName = new String[]{KODEKS_1, KODEKS_2, KODEKS_3, KODEKS_4, KODEKS_5, KODEKS_6};

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "BSS-172", testCaseVersion = "1")
    @LoginAs(key = "bss.user.budget")
    @Version(section = "budget")
    public void bss_172_test() {
        loginBss()
                .navigateToRecomendPage()
                .checkLawBaseWidgetIsPresent()
                .checkLawBaseWidgetTitleIsPresent()
                .checkKodeksOrderInLawBaseBlock()
                .checkLawBaseWidgetSearchInputIsPresent()
                .checkLawBaseWidgetNewDocumentCounterIsPresent()
                .checkKodeksOrderInLawBaseBlock(kodeksName)

                .clickKodeksByName(KODEKS_1)
                .checkDocumentIsNotEmpty()
                .checkDocumentWithNameIsOpened(KODEKS_1)
                .checkActualVersionIsPresent()
                .navigateToRecomendPage()

                .clickKodeksByName(KODEKS_2)
                .checkDocumentIsNotEmpty()
                .checkDocumentWithNameIsOpened(KODEKS_2)
                .checkActualVersionIsPresent()
                .navigateToRecomendPage()

                .clickKodeksByName(KODEKS_3)
                .checkDocumentIsNotEmpty()
                .checkDocumentWithNameIsOpened(KODEKS_3)
                .checkActualVersionIsPresent()
                .navigateToRecomendPage()

                .clickKodeksByName(KODEKS_4)
                .checkDocumentIsNotEmpty()
                .checkDocumentWithNameIsOpened(KODEKS_4)
                .checkActualVersionIsPresent()
                .navigateToRecomendPage()

                .clickKodeksByName(KODEKS_5)
                .checkDocumentIsNotEmpty()
                .checkDocumentWithNameIsOpened(KODEKS_5)
                .checkActualVersionIsPresent()
                .navigateToRecomendPage()

                .clickKodeksByName(KODEKS_6)
                .checkDocumentIsNotEmpty()
                .checkDocumentWithNameIsOpened(KODEKS_6)
                .checkActualVersionIsPresent()
                .navigateToRecomendPage()
                .logout();
    }
}
