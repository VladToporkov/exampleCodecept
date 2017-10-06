package com.actionmedia.pages.go;

import com.actionmedia.autotest.selenium.context.AbstractPage;
import com.actionmedia.base.BasePage;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.interfaces.ISystemBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Pavel on 10/05/16.
 */
@Component
public class GoBasePage<P extends BasePage> extends BasePage<P> implements ISystemBasePage {

    private <T extends AbstractPage> T clickPortalTab(final MainMenuButtons portalButton, final Class<T> requiredPage) {
        scrollToStart();
        WebElement mainMenu = waitForPresenceOfElementLocatedBy(By.id("main-menu"));
        WebElement portalButtonWebElement = mainMenu.findElement(portalButton.getButtonLocator());
        portalButtonWebElement.click();
        report("Страница '" + portalButton.getName() + "' открыта");
        if (portalButton.equals(MainMenuButtons.LAW_BASE)) {
            WebElement closeExtendedCloseButton = findElementByNoThrow(By.cssSelector(".search-extended [title='Закрыть']"));
            if (closeExtendedCloseButton != null) {
                closeExtendedCloseButton.click();
                waitForReloadingPage();
            }
        }
        return redirectTo(requiredPage);
    }

    @Step("Открыть страницу 'Рекомендации'")
    public GoRecomendPage navigateToRecomendPage() {
        return clickPortalTab(MainMenuButtons.RECOMEND, GoRecomendPage.class);
    }

    @Step("Открыть документ с заданным урл")
    public GoDocumentPage openDocumentByModuleIdAndDocId(String partialDocUrl) {
        openDocumentByUrlWithWaiting(partialDocUrl);
        return redirectTo(GoDocumentPage.class);
    }

    @Step("Открыть страницу 'Формы'")
    public GoFormsPage navigateToFormsPage() {
        return clickPortalTab(MainMenuButtons.TEMPLATES, GoFormsPage.class);
    }

    @Step("Открыть страницу 'Журналы'")
    @Override
    public GoMagazinesPage navigateToMagazinesPage() {
        return clickPortalTab(MainMenuButtons.MAGAZINES, GoMagazinesPage.class);
    }

    public GoBasePage logout() {
        logoutBase();
        return redirectToWithoutWait(GoBasePage.class);
    }

    @Step("Открыть страницу 'Правовая база'")
    public GoLawBasePage navigateToLawBasePage() {
        return clickPortalTab(MainMenuButtons.LAW_BASE, GoLawBasePage.class);
    }

    @Override
    public GoRubricatorPage clickRubricatorButton() {
        waitForPresenceOfElementLocatedBy(By.id("rubricator-btn")).click();
        waitForVisibilityOfElementLocatedBy(By.id("rubricator"), "Рубрикатор не найден");
        return redirectTo(GoRubricatorPage.class);
    }

    @Step("Открыть страницу Написать эксперту")
    public GoQuestionPage clickAskExpertLink() {
        waitForPresenceOfElementLocatedBy(By.cssSelector("[href*='/#/hotline/']")).click();
        return redirectTo(GoQuestionPage.class);
    }

    @Step("Нажать кнопку Найти")
    public GoSearchResultPage clickSearchButtonAndNavigateToSearchResultPage() {
        clickSearchButton();
        return redirectTo(GoSearchResultPage.class);
    }

    @Step("Открыть страницу 'Справочники'")
    public GoDictionaryPage navigateToDictionaryPage() {
        return clickPortalTab(MainMenuButtons.FSS_DICTIONARY, GoDictionaryPage.class);
    }
}