package com.actionmedia.tests.functional.oss.rubricator.kss;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;
import static com.actionmedia.autotest.Group.rubricator;

/**
 * Created by Alex on 25.06.2015 025.
 * Тест OSS-910 - общего отображения и поведения рубрикатора.
 */
public class OSS_910_VerifyRubricator extends AbstractDomainTest {

    @Test(groups = {rubricator})
    @TestLink(testCaseId = "OSS-910", testCaseVersion = "1")
    public void oss_910_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        loginKss()
                // шаг 1 - отображение с 2 колонками
                .navigateToAnswersPage()
                .clickRubricatorButton()        // открываем рубрикатор
                .checkCurrentUrlContainsText("#/answers")
                .checkFirstElementIsSelected()

                .checkRubricatorButtonIsPressed() // проверяем сосотояние кнопки
                .checkSearchRubricatorInputIsPresent() // проверяем наличие строки поиска
                .checkCloseRubricatorButtonIsPresent() // проверяем наличие крестика и его работу
                .clickCloseRubricatorButton()
                .logout();

        // шаг 2
        updateLoginToInfo("budget");
        updateLoginAsInfo("kss.user.budget");
        loginKss()
                .navigateToAnswersPage()
                .clickRubricatorButton()
                .checkAllRubricatorSectionsHaveContent() // проверяем, что все три уровня потенциально с контентом
                .logout();

        // шаг 3
        updateLoginToInfo("vip");
        updateLoginAsInfo("kss.user.vip");
        loginKss()
                .navigateToMagazinesPage()
                .clickRubricatorButton()
                .checkCurrentUrlContainsText("#/press")
                .checkNameOfSelectedElementIs("Кадровое дело".trim(), 0)
                .checkActiveItemForFirstMenuIsHighlighted() // для проверки выбранных по умолчанию значений, нужно поработать с датой, получать год, месяц.
                .checkActiveItemForSecondMenuIsHighlighted()
                .checkActiveItemForThirdMenuIsHighlighted()
                .checkContentsIsPresent()
                .clickCloseRubricatorButton()

                // шаг 4
                .navigateToLawBasePage() // ушли на правовую базу
                .checkCurrentUrlContainsText("#/law")
                .clickRubricatorButton() // открыли рубрикатор
                .checkNameOfSelectedElementIs("Трудовой".trim(), 0)
                .clickRubricatorButton() // закрыли его
                .checkRubricatorIsClosed()  // убеждаемся, что закрыт
                .checkRubricatorButtonIsUnPressed() // и кнопка отжата

                // повторяем для крестика
                .clickRubricatorButton() // открыли рубрикатор
                .clickCloseRubricatorButton() // закрыли крестом
                .checkRubricatorIsClosed()  // убеждаемся, что закрыт
                .checkRubricatorButtonIsUnPressed() // и кнопка отжата

                // повторяем для клика вне пределов
                .clickRubricatorButton()  // открыли рубрикатор
                .clickHeader() // шлепнули на заголовок
                .checkRubricatorIsClosed() // убеждаемся, что закрыт
                .checkRubricatorButtonIsUnPressed() // и кнопка отжата

                // потовряем для избранного
                .clickRubricatorButton()
                .clickMyFavoritesButton()
                .checkRubricatorIsClosed() // убеждаемся, что закрыт
                .checkRubricatorButtonIsUnPressed() // и кнопка отжата

                // шаг 5 повторяем для оглавления
                .openDocumentByModuleIdAndDocId("#/document/99/901807664/")
                .clickRubricatorButton()
                .clickTableOfContentsButton()
                .checkRubricatorIsClosed() // убеждаемся, что закрыт
                .checkRubricatorButtonIsUnPressed() // и кнопка отжата

                // повторяем для онлайн помощника
                .clickRubricatorButton()
                .clickOnlineHelpButton()
                .checkRubricatorIsClosed() // убеждаемся, что закрыт
                .checkRubricatorButtonIsUnPressed() // и кнопка отжата
                .logout();
    }
}
