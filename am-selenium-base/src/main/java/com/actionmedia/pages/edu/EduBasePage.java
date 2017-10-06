package com.actionmedia.pages.edu;

import com.actionmedia.autotest.selenium.context.AbstractPage;
import com.actionmedia.base.BasePage;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.interfaces.ISystemBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

@Component
public class EduBasePage<P extends BasePage> extends BasePage<P> implements ISystemBasePage {

    @Step("Открыть страницу 'Рекомендации'")
    public EduRecomendPage navigateToRecomendPage() {
        return clickPortalTab(MainMenuButtons.RECOMEND, EduRecomendPage.class);
    }

    @Step("Открыть страницу 'Журналы'")
    public EduMagazinesPage navigateToMagazinesPage() {
        return clickPortalTab(MainMenuButtons.MAGAZINES_AND_BOOKS, EduMagazinesPage.class);
    }

    @Step("Открыть страницу 'Сервисы'")
    public EduServicesPage navigateToServicesPage() {
        return clickPortalTab(MainMenuButtons.SERVICES, EduServicesPage.class);
    }

    private <T extends AbstractPage> T clickPortalTab(final MainMenuButtons portalButton, final Class<T> requiredPage) {
        scrollToStart();
        WebElement mainMenu = waitForPresenceOfElementLocatedBy(By.id("main-menu"));
        WebElement portalButtonWebElement = mainMenu.findElement(portalButton.getButtonLocator());
        portalButtonWebElement.click();
        report("Страница '" + portalButton.getName() + "' открыта");
        if (portalButton.equals(MainMenuButtons.LAW_BASE)){
            WebElement closeExtendedCloseButton = findElementByNoThrow(By.cssSelector(".search-extended [title='Закрыть']"));
            if (closeExtendedCloseButton != null){
                closeExtendedCloseButton.click();
                waitForReloadingPage();
            }
        }
        return redirectTo(requiredPage);
    }

    @Step("Открыть документ с заданным урл")
    public EduDocumentPage openDocumentByModuleIdAndDocId(String partialDocUrl) {
        openDocumentByUrlWithWaiting(partialDocUrl);
        return redirectTo(EduDocumentPage.class);
    }

    @Step("Открыть рубрикатор")
    public EduRubricatorPage clickRubricatorButton() {
        waitForPresenceOfElementLocatedBy(By.id("rubricator-btn"), "Не найден рубрикатор").click();
        waitForVisibilityOfElementLocatedBy(By.id("rubricator"), "Рубрикатор не найден");
        return redirectTo(EduRubricatorPage.class);
    }

    public EduBasePage logout() {
        logoutBase();
        return redirectToWithoutWait(EduBasePage.class);
    }

    @Step("Открыть страницу 'Формы'")
    public EduFormsPage navigateToFormsPage() {
        return clickPortalTab(MainMenuButtons.FORMS, EduFormsPage.class);
    }

    @Step("Открыть страницу 'Правовая база'")
    public EduLawBasePage navigateToLawBasePage() {
        return clickPortalTab(MainMenuButtons.LAW_BASE, EduLawBasePage.class);
    }

    @Step("Открыть страницу Написать эксперту")
    public EduQuestionPage clickAskExpertLink() {
        waitForPresenceOfElementLocatedBy(By.cssSelector("[href*='/#/hotline/']")).click();
        return redirectTo(EduQuestionPage.class);
    }

    @Step("Нажать кнопку Найти")
    public EduSearchResultPage clickSearchButtonAndNavigateToSearchResultPage() {
        clickSearchButton();
        return redirectTo(EduSearchResultPage.class);
    }

    @Step("Открыть страницу 'Справочники'")
    public EduDictionaryPage navigateToDictionaryPage() {
        return clickPortalTab(MainMenuButtons.FSS_DICTIONARY, EduDictionaryPage.class);
    }
}
