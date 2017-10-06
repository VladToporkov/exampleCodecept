package com.actionmedia.pages.elpu;

import com.actionmedia.autotest.selenium.context.AbstractPage;
import com.actionmedia.base.BasePage;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.gf.GfRecomendPage;
import com.actionmedia.pages.go.GoDocumentPage;
import com.actionmedia.pages.interfaces.IMagazinesPage;
import com.actionmedia.pages.interfaces.ISystemBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Pavel on 10/05/16.
 */
@Component
public class ElpuBasePage<P extends BasePage> extends BasePage<P> implements ISystemBasePage {

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
    public ElpuRecomendPage navigateToRecomendPage() {
        return clickPortalTab(MainMenuButtons.RECOMEND, ElpuRecomendPage.class);
    }

    @Step("Открыть документ с заданным урл")
    public ElpuDocumentPage openDocumentByModuleIdAndDocId(String partialDocUrl) {
        String currentUrl = getCurrentUrl().split("#")[0];
        String documentUrl = currentUrl + partialDocUrl;
        report("Открывается ссылка: " + documentUrl);
        openUrl(documentUrl);
        return redirectTo(ElpuDocumentPage.class);
    }

    @Step("Открыть страницу 'Формы'")
    public ElpuFormsPage navigateToFormsPage() {
        return clickPortalTab(MainMenuButtons.FORMS, ElpuFormsPage.class);
    }

    @Step("Открыть страницу 'Журналы'")
    @Override
    public ElpuMagazinesPage navigateToMagazinesPage() {
        return clickPortalTab(MainMenuButtons.MAGAZINES, ElpuMagazinesPage.class);
    }

    @Override
    public ElpuRubricatorPage clickRubricatorButton() {
        waitForPresenceOfElementLocatedBy(By.id("rubricator-btn")).click();
        waitForVisibilityOfElementLocatedBy(By.id("rubricator"), "Рубрикатор не найден");
        return redirectTo(ElpuRubricatorPage.class);
    }

    public ElpuBasePage logout() {
        logoutBase();
        return redirectToWithoutWait(ElpuBasePage.class);
    }

    @Step("Открыть страницу Написать эксперту")
    public ElpuQuestionPage clickAskExpertLink() {
        waitForPresenceOfElementLocatedBy(By.cssSelector("[href*='/#/hotline/']")).click();
        return redirectTo(ElpuQuestionPage.class);
    }

    @Step("Нажать кнопку Найти")
    public ElpuSearchResultPage clickSearchButtonAndNavigateToSearchResultPage() {
        clickSearchButton();
        return redirectTo(ElpuSearchResultPage.class);
    }
}
