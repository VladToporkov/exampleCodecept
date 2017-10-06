package com.actionmedia.pages.umd;

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
public class UmdBasePage<P extends BasePage> extends BasePage<P> implements ISystemBasePage {

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

    @Step("Открыть страницу 'Рекомендации'")
    public UmdRecomendPage navigateToRecomendPage() {
        return clickPortalTab(MainMenuButtons.RECOMEND, UmdRecomendPage.class);
    }

    @Step("Открыть документ с заданным урл")
    public UmdDocumentPage openDocumentByModuleIdAndDocId(String partialDocUrl) {
        String currentUrl = getCurrentUrl().split("#")[0];
        String documentUrl = currentUrl + partialDocUrl;
        report("Открывается ссылка: " + documentUrl);
        openUrl(documentUrl);
        return redirectTo(UmdDocumentPage.class);
    }

    @Step("Открыть страницу 'Формы'")
    public UmdFormsPage navigateToFormsPage() {
        return clickPortalTab(MainMenuButtons.FORMS, UmdFormsPage.class);
    }

    @Step("Открыть страницу 'Журналы'")
    @Override
    public UmdMagazinesPage navigateToMagazinesPage() {
        return clickPortalTab(MainMenuButtons.MAGAZINES, UmdMagazinesPage.class);
    }

    @Override
    public UmdRubricatorPage clickRubricatorButton() {
        waitForPresenceOfElementLocatedBy(By.id("rubricator-btn")).click();
        waitForVisibilityOfElementLocatedBy(By.id("rubricator"), "Рубрикатор не найден");
        return redirectTo(UmdRubricatorPage.class);
    }

    public UmdBasePage logout() {
        logoutBase();
        return redirectToWithoutWait(UmdBasePage.class);
    }

    @Step("Открыть страницу Написать эксперту")
    public UmdQuestionPage clickAskExpertLink() {
        waitForPresenceOfElementLocatedBy(By.cssSelector("[href*='/#/hotline/']")).click();
        return redirectTo(UmdQuestionPage.class);
    }

    @Step("Нажать кнопку Найти")
    public UmdSearchResultPage clickSearchButtonAndNavigateToSearchResultPage() {
        clickSearchButton();
        return redirectTo(UmdSearchResultPage.class);
    }
}
