package com.actionmedia.tests.functional.oss.rubricator.uss;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.rubricator;

public class OSS_940_VerifyRubricator extends AbstractDomainTest {

    @Test(groups = {rubricator})
    @TestLink(testCaseId = "OSS-940", testCaseVersion = "1")
    public void oss_940_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        loginUss()
                .navigateToRecomendPage()
                .clickRubricatorButton()
                .checkCurrentUrlContainsText("#/recommendations")
                .checkFirstElementIsSelected()

                .checkRubricatorButtonIsPressed() // проверяем сосотояние кнопки
                .checkSearchRubricatorInputIsPresent() // проверяем наличие строки поиска
                .checkCloseRubricatorButtonIsPresent() // проверяем наличие крестика и его работу
                .clickCloseRubricatorButton()

                // шаг 5 закртыие для оглавления
                .openDocumentByModuleIdAndDocId("#/document/99/9027690/")
                .clickRubricatorButton()
                .clickTableOfContentsButton()
                .checkRubricatorIsClosed() // убеждаемся, что закрыт
                .checkRubricatorButtonIsUnPressed() // и кнопка отжата

                // повторяем для онлайн помощника
                .clickRubricatorButton()
                .clickOnlineHelpButton()
                .checkRubricatorIsClosed() // убеждаемся, что закрыт
                .checkRubricatorButtonIsUnPressed() // и кнопка отжата

                // потовряем для избранного
                .clickRubricatorButton()
                .clickMyFavoritesButton()
                .checkRubricatorIsClosed() // убеждаемся, что закрыт
                .checkRubricatorButtonIsUnPressed() // и кнопка отжата
                .logout();

        // шаг 2
        updateSystemInfo(SystemPubs.uss_vip);
        updateLoginAsInfo("uss.user.vip");
        loginUss()
                .navigateToMagazinesPage()
                .clickRubricatorButton()
                .checkFirstElementIsSelected()
                .checkActiveItemForFirstMenuIsHighlighted()
                .checkActiveItemForSecondMenuIsHighlighted()
                .checkContentsIsPresent()

                // шаг 3
                .clickRubricFromFirstColumnByName("Журналы", "Юрист компании")
                .checkCurrentUrlContainsText("#/press")
                .checkActiveItemForFirstMenuIsHighlighted()
                .checkActiveItemForSecondMenuIsHighlighted()
                .checkActiveItemForThirdMenuIsHighlighted()
                .checkContentsIsPresent()

                // шаг 4
                .navigateToLawBasePage() // ушли на правовую базу
                .checkCurrentUrlContainsText("#/law")
                .clickRubricatorButton() // открыли рубрикатор
                .checkFirstElementIsSelected()
                .clickRubricatorButton() // закрыли его
                .checkRubricatorIsClosed()  // убеждаемся, что закрыт
                .checkRubricatorButtonIsUnPressed() // и кнопка отжата

                // повторяем для крестика
                .clickRubricatorButton() // открыли рубрикатор
                .checkCloseRubricatorButtonIsPresent()
                .clickCloseRubricatorButton() // закрыли крестом
                .checkRubricatorIsClosed()  // убеждаемся, что закрыт
                .checkRubricatorButtonIsUnPressed() // и кнопка отжата

                // повторяем для клика вне пределов
                .clickRubricatorButton()  // открыли рубрикатор
                .clickHeader() // шлепнули на заголовок
                .checkRubricatorIsClosed() // убеждаемся, что закрыт
                .checkRubricatorButtonIsUnPressed()
                .logout(); // и кнопка отжата
    }
}
