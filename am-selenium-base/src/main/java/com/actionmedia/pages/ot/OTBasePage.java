package com.actionmedia.pages.ot;

import com.actionmedia.autotest.selenium.context.AbstractPage;
import com.actionmedia.base.BasePage;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.interfaces.ISystemBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

@Component
public class OTBasePage<P extends BasePage> extends BasePage<P> implements ISystemBasePage {

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
    public OtRecomendPage navigateToRecomendPage() {
        return clickPortalTab(MainMenuButtons.RECOMEND, OtRecomendPage.class);
    }

    @Step("Открыть страницу 'Сервисы'")
    public OtServicesPage navigateToServicesPage() {
        return clickPortalTab(MainMenuButtons.SERVICES, OtServicesPage.class);
    }

    @Step("Открыть страницу Написать эксперту")
    public OtQuestionPage clickAskExpertLink() {
        waitForPresenceOfElementLocatedBy(By.cssSelector("[href*='/#/hotline/']")).click();
        return redirectTo(OtQuestionPage.class);
    }

    @Step("Открыть страницу 'Журналы'")
    public OtMagazinesPage navigateToMagazinesPage() {
        return clickPortalTab(MainMenuButtons.MAGAZINES_AND_BOOKS, OtMagazinesPage.class);
    }

    public OTBasePage logout() {
        logoutBase();
        return redirectToWithoutWait(OTBasePage.class);
    }


    @Step("Открыть документ с заданным урл")
    public OtDocumentPage openDocumentByModuleIdAndDocId(String partialDocUrl) {
        String currentUrl = getCurrentUrl().split("#")[0];
        String documentUrl = currentUrl + partialDocUrl;
        report("Открывается ссылка: " + documentUrl);
        openUrl(documentUrl);
        return redirectTo(OtDocumentPage.class);
    }

    @Step("Открыть страницу 'Формы'")
    public OtFormsPage navigateToFormsPage() {
        return clickPortalTab(MainMenuButtons.TEMPLATES, OtFormsPage.class);
    }

    @Step("Открыть рубрикатор")
    public OtRubricatorPage clickRubricatorButton() {
        waitForPresenceOfElementLocatedBy(By.id("rubricator-btn"), "Не найден рубрикатор").click();
        waitForVisibilityOfElementLocatedBy(By.id("rubricator"), "Рубрикатор не найден");
        return redirectTo(OtRubricatorPage.class);
    }

    @Step("Открыть страницу 'Правовая база'")
    public OtLawBasePage navigateToLawBasePage() {
        return clickPortalTab(MainMenuButtons.LAW_BASE, OtLawBasePage.class);
    }

    @Step("Нажать кнопку Найти")
    public OtSearchResultPage clickSearchButtonAndNavigateToSearchResultPage() {
        clickSearchButton();
        return redirectTo(OtSearchResultPage.class);
    }

    @Step("Открыть страницу 'Справочники'")
    public OtDictionaryPage navigateToDictionaryPage() {
        return clickPortalTab(MainMenuButtons.FSS_DICTIONARY, OtDictionaryPage.class);
    }
}
