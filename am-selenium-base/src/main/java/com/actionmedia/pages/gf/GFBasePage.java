package com.actionmedia.pages.gf;

import com.actionmedia.autotest.selenium.context.AbstractPage;
import com.actionmedia.base.BasePage;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.helpers.DocumentHelper;
import com.actionmedia.pages.interfaces.ISystemBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

@Component
public class GFBasePage<P extends BasePage> extends BasePage<P> implements ISystemBasePage {

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
    public GfRecomendPage navigateToRecomendPage() {
        return clickPortalTab(MainMenuButtons.RECOMEND, GfRecomendPage.class);
    }

    @Step("Открыть страницу 'Журналы'")
    public GfMagazinesPage navigateToMagazinesPage() {
        return clickPortalTab(MainMenuButtons.MAGAZINES_AND_BOOKS, GfMagazinesPage.class);
    }

    @Step("Открыть страницу Написать эксперту")
    public GfQuestionPage clickAskExpertLink() {
        waitForPresenceOfElementLocatedBy(By.cssSelector("[href*='/#/hotline/']")).click();
        return redirectTo(GfQuestionPage.class);
    }

    public GfDocumentPage checkVideoPlayerIsPresent() {
        getHelper(DocumentHelper.class).checkVideoPlayerIsPresent();
        return (GfDocumentPage) this;
    }

    public GfDocumentPage checkVideoTitleIsPresent() {
        getHelper(DocumentHelper.class).checkVideoTitleIsPresent();
        return (GfDocumentPage) this;
    }

    @Step("Открыть документ с заданным урл")
    public GfDocumentPage openDocumentByModuleIdAndDocId(String partialDocUrl) {
        openDocumentByUrlWithWaiting(partialDocUrl);
        return redirectTo(GfDocumentPage.class);
    }

    @Step("Открыть страницу 'Формы'")
    public GfFormsPage navigateToFormsPage() {
        return clickPortalTab(MainMenuButtons.FORMS, GfFormsPage.class);
    }

    @Step("Открыть заданный урл")
    public GfDocumentPage openByPartialUrl(String partialDocUrl) {
        String currentUrl = getCurrentUrl().split("#")[0];
        if(currentUrl.contains("update")) currentUrl = currentUrl.split("update")[0];
        String documentUrl = currentUrl + partialDocUrl;
        report("Открывается ссылка: " + documentUrl);
        openUrl(documentUrl);
        return redirectToWithoutWait(GfDocumentPage.class);
    }

    @Step("Проверяется текст тега title на стартовой странице системы")
    public P checkTagTitle() {
        String title = "Cправочная система «Госфинансы». Рекомендации, ответы чиновников на бухгалтерские вопросы";
        checkTagTitle(title);
        return (P) this;
    }

    @Step("Проверка выбранного пункта меню")
    public P checkCurrentItemIsSelected(MainMenuButtons mainMenuButton) {
        String actualItemName = waitForPresenceOfElementLocatedBy(By.cssSelector(".btn_state_active"), "Не один раздел не выбран в главном меню").getText();
        postponedAssertEquals(actualItemName, mainMenuButton.getName(), "Выбран неправильный раздел в главном меню");
        return (P) this;
    }

    @Step("Открыть личный кабинет")
    public GfProfilePage clickProfileLink() {
        clickProfileLinkBase();
        return redirectTo(GfProfilePage.class);
    }

    public GFBasePage logout() {
        logoutBase();
        return redirectToWithoutWait(GFBasePage.class);
    }

    @Step("Открыть рубрикатор")
    public GfRubricatorPage clickRubricatorButton() {
        waitForPresenceOfElementLocatedBy(By.id("rubricator-btn")).click();
        waitForVisibilityOfElementLocatedBy(By.id("rubricator"), "Рубрикатор не найден");
        return redirectTo(GfRubricatorPage.class);
    }

    @Step("Открыть страницу 'Правовая база'")
    public GfLawBasePage navigateToLawBasePage() {
        return clickPortalTab(MainMenuButtons.LAW_BASE, GfLawBasePage.class);
    }

    @Step("Нажать кнопку и перейти на страницу результатов поиска")
    public GfSearchResultPage clickSearchButtonAndNavigateToSearchResultPage() {
        clickSearchButton();
        return redirectTo(GfSearchResultPage.class);
    }
}
