package com.actionmedia.tests.functional.oss.rubricator.bss;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.rubricator;

/**
 * Created by Alex on 23.06.2015 023.
 * Тест OSS-932 - общего отображения и поведения рубрикатора.
 */
public class OSS_932_VerifyRubricator extends AbstractDomainTest {

    @Test(groups = {rubricator})
    @TestLink(testCaseId = "OSS-932", testCaseVersion = "1")
    public void oss_932_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        loginBss()
                // шаг 1 - отображение с 2 колонками
                .navigateToRecomendPage()
                .clickRubricatorButton()        // открываем рубрикатор
                .checkFirstElementIsSelected()

                .checkRubricatorButtonIsPressed() // проверяем сосотояние кнопки
                .checkSearchRubricatorInputIsPresent() // проверяем наличие строки поиска
                .checkCloseRubricatorButtonIsPresent() // проверяем наличие крестика и его работу
                .clickCloseRubricatorButton()

                // шаги 2 и 3
                .clickRubricatorButton()
                .checkAllRubricatorSectionsHaveContent() // проверяем, что все три уровня потенциально с контентом
                .clickCloseRubricatorButton()

                // шаг 4
                .navigateToLawBasePage() // ушли на правовую базу
                .clickRubricatorButton() // открыли рубрикатор
                .checkFirstElementIsSelected()
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

                // повторяем для оглавления
                .openDocumentByModuleIdAndDocId("#/document/99/901714421")
                .clickRubricatorButton()
                .clickTableOfContentsButton()
                .checkRubricatorIsClosed() // убеждаемся, что закрыт
                .checkRubricatorButtonIsUnPressed() // и кнопка отжата

                // повторяем для онлайн помощника
                .clickRubricatorButton()
                .clickOnlineHelpButton()
                // убеждаемся, что закрыт
                .checkRubricatorIsClosed()
                // и кнопка отжата
                .checkRubricatorButtonIsUnPressed()
                .logout();
    }
}
