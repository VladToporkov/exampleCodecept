package com.actionmedia.pages.cult;

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
public class CultBasePage<P extends BasePage> extends BasePage<P> implements ISystemBasePage {

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

    @Override
    public CultDocumentPage openDocumentByModuleIdAndDocId(String documentUrl) {
        openDocumentByUrlWithWaiting(documentUrl);
        return redirectTo(CultDocumentPage.class);
    }

    @Step("Открыть страницу 'Рекомендации'")
    public CultRecomendPage navigateToRecomendPage() {
        return clickPortalTab(MainMenuButtons.RECOMEND, CultRecomendPage.class);
    }

    @Step("Открыть страницу 'Формы'")
    public CultFormsPage navigateToFormsPage() {
        return clickPortalTab(MainMenuButtons.FORMS, CultFormsPage.class);
    }

    @Step("Открыть страницу 'Журналы'")
    @Override
    public CultMagazinesPage navigateToMagazinesPage() {
        return clickPortalTab(MainMenuButtons.MAGAZINES, CultMagazinesPage.class);
    }
    @Override
    public CultRubricatorPage clickRubricatorButton() {
        waitForPresenceOfElementLocatedBy(By.id("rubricator-btn")).click();
        waitForVisibilityOfElementLocatedBy(By.id("rubricator"), "Рубрикатор не найден");
        return redirectTo(CultRubricatorPage.class);
    }

    public CultBasePage logout() {
        logoutBase();
        return redirectToWithoutWait(CultBasePage.class);
    }

    @Step("Открыть страницу Написать эксперту")
    public CultQuestionPage clickAskExpertLink() {
        waitForPresenceOfElementLocatedBy(By.cssSelector("[href*='/#/hotline/']")).click();
        return redirectTo(CultQuestionPage.class);
    }

    @Step("Нажать кнопку Найти")
    public CultSearchResultPage clickSearchButtonAndNavigateToSearchResultPage() {
        clickSearchButton();
        return redirectTo(CultSearchResultPage.class);
    }
}
