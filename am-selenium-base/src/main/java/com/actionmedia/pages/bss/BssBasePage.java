package com.actionmedia.pages.bss;

import com.actionmedia.autotest.selenium.annotations.Wait;
import com.actionmedia.autotest.selenium.context.AbstractPage;
import com.actionmedia.autotest.selenium.elements.TextField;
import com.actionmedia.base.BasePage;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.components.popups.PredemoPopup;
import com.actionmedia.pages.LoginPage;
import com.actionmedia.pages.helpers.DocumentHelper;
import com.actionmedia.pages.helpers.SearchResultHelper;
import com.actionmedia.pages.interfaces.ISystemBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

@Component
public class BssBasePage<P extends BasePage> extends BasePage<P> implements ISystemBasePage {

    public static final String DOCUMENT_URL = "document.url";

    @FindBy(css = ".search-text")
    @Wait
    protected TextField searchBox;

    public BssBasePage logout() {
        logoutBase();
        return redirectToWithoutWait(BssBasePage.class);
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

    @Step("Открыть страницу 'Рекомендации'")
    public BssRecomendPage navigateToRecomendPage() {
        return clickPortalTab(MainMenuButtons.RECOMEND, BssRecomendPage.class);
    }

    @Step("Открыть страницу 'Правовая база'")
    public BssLawBasePage navigateToLawBasePage() {
        return clickPortalTab(MainMenuButtons.LAW_BASE, BssLawBasePage.class);
    }

    @Step("Переключиться на страницу 'Правовая база'")
    public BssLawBasePage switchToLawBasePage() {
        return redirectTo(BssLawBasePage.class);
    }

    @Override
    @Step("Открыть страницу 'Формы'")
    public BssFormsPage navigateToFormsPage() {
        return clickPortalTab(MainMenuButtons.FORMS, BssFormsPage.class);
    }

    @Step("Открыть страницу 'Справочники'")
    public BssDictionaryPage navigateToDictionaryPage() {
        return clickPortalTab(MainMenuButtons.DICTIONARIES, BssDictionaryPage.class);
    }

    @Step("Открыть страницу 'Журналы'")
    public BssMagazinesPage navigateToMagazinesPage() {
        return clickPortalTab(MainMenuButtons.MAGAZINES, BssMagazinesPage.class);
    }

    @Step("Открыть страницу 'Видео'")
    public BssVideosPage navigateToVideoPage() {
        return clickPortalTab(MainMenuButtons.VIDEO, BssVideosPage.class);
    }

    @Step("Открыть страницу 'Сервисы'")
    public BssServicesPage navigateToServicesPage() {
        return clickPortalTab(MainMenuButtons.SERVICES, BssServicesPage.class);
    }

    @Step("Открыть страницу 'Отчеты'")
    public BssDocumentPage navigateToOtchetPage() {
        return clickPortalTab(MainMenuButtons.OTCHET, BssDocumentPage.class);
    }

    @Step("Открыть страницу 'Промо'")
    public BssPromoPage navigateToPromoPage() {
        clickAboutSystem();
        return redirectTo(BssPromoPage.class);
    }

    @Step("Нажать кнопку и перейти на страницу результатов поиска")
    public BssSearchResultPage clickSearchButtonAndNavigateToSearchResultPage() {
        clickSearchButton();
        return redirectTo(BssSearchResultPage.class);
    }

    @Step("Нажать кнопку Найти в форме дополнительных аттрибутах поиска")
    public BssSearchResultPage clickSearchExtendedButton() {
        extendedSearchForm.clickSearchExtendedButton();
        return redirectTo(BssSearchResultPage.class);
    }

    @Step("Открыть страницу Написать эксперту")
    public BssQuestionPage clickAskExpertLink() {
        waitForPresenceOfElementLocatedBy(By.cssSelector("[href*='/#/hotline/']")).click();
        return redirectTo(BssQuestionPage.class);
    }

    @Step("Открыть страницу 'Активация подписки'")
    public BssBasePage navigateToActivatePage() {
        clickActivate();
        return redirectTo(BssBasePage.class);
    }

    @Step("Открыть страницу 'Логин'")
    public LoginPage navigateToLoginPage() {
        clickLoginLink();
        return redirectTo(LoginPage.class);
    }

    @Step("Открыть страницу ''")
    public BssBasePage navigateToBssLoginPage() {
        waitForPresenceOfElementLocatedBy(By.cssSelector(".btn__in")).click();
        return redirectTo(BssBasePage.class);
    }

    @Step("Открыть документ с заданным урл")
    public BssDocumentPage openDocumentByUrl(String documentUrl) {
        waitForReloadingPage();
        report("Открывается ссылка: " + documentUrl);
        openUrl(documentUrl);
        return redirectTo(BssDocumentPage.class);
    }

    @Step("Открыть заданный урл")
    public BssDocumentPage openByPartialUrl(String partialDocUrl) {
        String currentUrl = getCurrentUrl().split("#")[0];
        if (currentUrl.contains("update")) currentUrl = currentUrl.split("update")[0];
        String documentUrl = currentUrl + partialDocUrl;
        report("Открывается ссылка: " + documentUrl);
        openUrl(documentUrl);
        return redirectToWithoutWait(BssDocumentPage.class);
    }

    @Step("Проверяется что лого системы отображается в шапке сайта")
    public P checkLogoIsPresentOnRssPage() {
        WebElement logo = waitForPresenceOfElementLocatedBy(By.id("feedTitleImage"));
        postponedAssertNotNull(logo, "Лого системы не найдено");
        if (logo != null) {
            String logoImgSrc = logo.getAttribute("src");
            postponedAssertTrue(logoImgSrc.contains("rss-logo-bss.jpg"), "Неправильная картинка для лого системы");
        }
        return (P) this;
    }

    @Step("Открыть документ с заданным урл")
    public BssDocumentPage openDocumentByModuleIdAndDocId(String partialDocUrl) {
        openDocumentByUrlWithWaiting(partialDocUrl);
        return redirectTo(BssDocumentPage.class);
    }

    @Step("Открыть документ с заданным урл")
    public BssDocumentPage openDocumentWithoutWaitByModuleIdAndDocId(String partialDocUrl) {
        String currentUrl = getCurrentUrl().split("#")[0];
        String documentUrl = currentUrl + partialDocUrl;
        report("Открывается ссылка: " + documentUrl);
        openUrl(documentUrl);
        return redirectToWithoutWait(BssDocumentPage.class);
    }

    @Step("Открыть рубрикатор")
    public BssRubricator clickRubricatorButton() {
        waitForPresenceOfElementLocatedBy(By.id("rubricator-btn")).click();
        return redirectTo(BssRubricator.class);
    }

    @Step("Открыть раздел 'О системе'")
    public BssAboutSystemPage clickAboutSystemLink() {
        clickAboutSystemLinkBase();
        return redirectTo(BssAboutSystemPage.class);
    }

    @Step("Проверяется что превью документа доступно")
    public P checkDocPreviewIsOpened() {
        WebElement docPart = findElementByNoThrow(mainContentElement, By.cssSelector(".doc-preview"));
        postponedAssertNotNull(docPart, "Превью документа не доступно");
        if (docPart != null) {
            postponedAssertFalse(docPart.getText().isEmpty(), "Отсутствует текст в превью документа");
        }
        return (P) this;
    }

    @Step("Проверяется что превью документа не доступно")
    public P checkDocPreviewIsNotOpened() {
        WebElement docPart = findElementByNoThrow(mainContentElement, By.cssSelector(".doc-author_viewtype_single"));
        postponedAssertNull(docPart, "Превью документа доступно");
        return (P) this;
    }

    @Step("Проверяется текст рядом с замком на превью документа")
    public P checkTextAroundLockInDocPreview(String... lockTextArr) {
        WebElement lockElement = findElementByNoThrow(mainContentElement, By.id("pagewf-tooltip"));
        postponedAssertNotNull(lockElement, "Текст рядом с замком на превью документа не найден");
        if (lockElement != null) {
            boolean isContains = false;
            for (String lockText : lockTextArr) {
                if (lockElement.getText().equals(lockText)) {
                    isContains = true;
                    break;
                }
            }
            postponedAssertTrue(isContains, "Неправильный текст около замка в превью документа.");
        }
        return (P) this;
    }

    @Step("Проверяется что открыта страница авторизации")
    public P checkAuthFormIsOpened() {
        WebElement access = findElementByNoThrow(mainLeftElement, By.cssSelector(".whiteboard-control"));
        postponedAssertNotNull(access, "Страница авторизации не открыта");
        if (access != null) {
            postponedAssertTrue(access.isDisplayed(), "Страница авторизации не открыта");
        }
        return (P) this;
    }

    @Step("Проверяется что страница авторизации не открыта")
    public P checkAuthFormIsNotOpened() {
        WebElement access = findElementByNoThrow(mainLeftElement, By.cssSelector(".whiteboard-control"));
        postponedAssertNull(access, "Открыта Страница авторизации ");
        return (P) this;
    }

    @Step("Проверяется что Содержание документа отсутствует")
    public P checkDocumentIsNotAvailableForNotLoggedUsers() {
        WebElement headerForNotLoggedDocument = findElementByNoThrow(mainContentElement, By.id("pagewf-header"));
        WebElement documentForLoggedDocument = findElementByNoThrow(mainContentElement, By.id("document-body"));

        postponedAssertNotNull(headerForNotLoggedDocument, "Содержание документа отображается для неаутентифицированного пользователя");
        postponedAssertNull(documentForLoggedDocument, "Содержание документа отображается для неаутентифицированного пользователя");
        return (P) this;
    }

    @Step("Проверяется что Содержание документа отсутствует")
    public P checkDocumentIsAvailableForNotLoggedUsers() {
        WebElement headerForNotLoggedDocument = findElementByNoThrow(mainContentElement, By.id("pagewf-header"));
        WebElement documentForLoggedDocument = findElementByNoThrow(mainContentElement, By.id("document-body"));

        postponedAssertNull(headerForNotLoggedDocument, "Содержание документа не отображается для неаутентифицированного пользователя");
        postponedAssertNotNull(documentForLoggedDocument, "Содержание документа не отображается для неаутентифицированного пользователя");
        return (P) this;
    }

    @Step("Проверяется что описание версии системы присутсвует в шапке сайта")
    public P checkTextVersionInHeader(String versionText) {
        WebElement header = waitForVisibilityOfElementLocatedBy(By.id("header"), "Header не найден");
        WebElement version = findElementByNoThrow(header, By.cssSelector(".pub"));
        postponedAssertNotNull(version, "Описание версии системы Отсутствует на шапке сайта");
        if (version != null) {
            String actualVersionText = version.getText();
            postponedAssertEquals(actualVersionText, versionText, "Неправильный текст описания версии системы на шапке сайта");
        }
        return (P) this;
    }

    @Step("Проверяется что лого системы отображается в шапке сайта")
    public P checkLogoIsPresent() {
        WebElement header = getHeader();
        WebElement logo = findElementByNoThrow(header, By.cssSelector(".logo"));
        postponedAssertNotNull(logo, "Лого системы не найдено");
        if (logo != null) {
            String logoImgSrc = logo.getCssValue("background-image");
            postponedAssertTrue(logoImgSrc.contains("/bss/logo.png"), "Неправильная картинка для лого системы");
        }
        return (P) this;
    }

    @Step("Проверяется что ссылка 'Написать эксперту' отображается в шапке сайта")
    public P checkAskExpertLinkIsPresent() {
        WebElement header = getHeader();
        WebElement askExpertLink = findElementByNoThrow(header, By.cssSelector("[href*='/#/hotline/']"));
        postponedAssertNotNull(askExpertLink, "Ссылка 'Написать эксперту' не найдена");
        if (askExpertLink != null) {
            postponedAssertFalse(askExpertLink.getText().isEmpty(), "Отсутствует текст ссылки 'Написать эксперту'");
        }
        return (P) this;
    }

    @Step("Проверяется что ссылка 'О системе' отображается в шапке сайта")
    public P checkAboutSystemLinkIsPresent() {
        WebElement header = getHeader();
        WebElement aboutSystemLink = findElementByNoThrow(header, By.cssSelector("[href*='/about/']"));
        postponedAssertNotNull(aboutSystemLink, "Ссылка 'О системе' не найдена");
        if (aboutSystemLink != null) {
            postponedAssertFalse(aboutSystemLink.getText().isEmpty(), "Отсутствует текст ссылки 'О системе'");
        }
        return (P) this;
    }

    @Step("Проверяется что ссылка 'Активировать код' отображается в шапке сайта")
    public P checkActivateCodeLinkIsPresent() {
        WebElement header = getHeader();
        WebElement activateCodeLink = findElementByNoThrow(header, By.cssSelector("[href*='#/customer/activate-code/']"));
        postponedAssertNotNull(activateCodeLink, "Ссылка 'Активировать код' не найдена");
        if (activateCodeLink != null) {
            postponedAssertFalse(activateCodeLink.getText().isEmpty(), "Отсутствует текст ссылки 'Активировать код'");
        }
        return (P) this;
    }

    @Step("Проверяется что ссылка 'Войти' отображается в шапке сайта")
    public P checkEnterLinkIsPresent() {
        WebElement header = getHeader();
        WebElement enterLink = findElementByNoThrow(header, By.cssSelector("[href*='#/customer/auth/']"));
        postponedAssertNotNull(enterLink, "Ссылка 'Войти' не найдена");
        if (enterLink != null) {
            postponedAssertFalse(enterLink.getText().isEmpty(), "Отсутствует текст ссылки 'Войти'");
        }
        return (P) this;
    }

    @Step("Открыть случайный документ рекомендаций из рубрикатора избранного")
    public BssDocumentPage clickRecomendDocument() {
        clickDocumentFromMyFavoritesMenuByType("recommendations");
        return redirectTo(BssDocumentPage.class);
    }

    @Step("Открыть случайный документ правовой базы из рубрикатора избранного")
    public BssDocumentPage clickLawBaseDocument() {
        clickDocumentFromMyFavoritesMenuByType("law");
        return redirectTo(BssDocumentPage.class);
    }

    @Step("Открыть случайный документ форм из рубрикатора избранного")
    public BssDocumentPage clickFormsDocument() {
        clickDocumentFromMyFavoritesMenuByType("forms");
        return redirectTo(BssDocumentPage.class);
    }

    @Step("Открыть случайный документ справочников из рубрикатора избранного")
    public BssDocumentPage clickDictionaryDocument() {
        clickDocumentFromMyFavoritesMenuByType("handbook");
        return redirectTo(BssDocumentPage.class);
    }

    @Step("Открыть случайный документ журналов из рубрикатора избранного")
    public BssDocumentPage clickMagazinesDocument() {
        clickDocumentFromMyFavoritesMenuByType("press");
        return redirectTo(BssDocumentPage.class);
    }

    @Step("Открыть случайный документ видео из рубрикатора избранного")
    public BssDocumentPage clickVideosDocument() {
        clickDocumentFromMyFavoritesMenuByType("videos");
        return redirectTo(BssDocumentPage.class);
    }

    @Step("Открыть случайный документ мастеров из рубрикатора избранного")
    public BssDocumentPage clickWizardsDocument() {
        clickDocumentFromMyFavoritesMenuByType("wizards");
        return redirectTo(BssDocumentPage.class);
    }

    @Step("Открыть случайный документ расчетчиков из рубрикатора избранного")
    public BssDocumentPage clickCalculatorDocument() {
        clickDocumentFromMyFavoritesMenuByType("services");
        return redirectTo(BssDocumentPage.class);
    }

    private void clickDocumentFromMyFavoritesMenuByType(String type) {
        WebElement myFavorites = waitForVisibilityOfElementLocatedBy(By.cssSelector("[class*='bookmarks-content']"), "Рубрикатор избранного не найден");
        waitForTextToBePresentIn(myFavorites);
        List<WebElement> documentByTypeList = myFavorites.findElements(By.cssSelector("[class*='b-ico_content_" + type + "']"));
        if (!documentByTypeList.isEmpty()) {
            WebElement randomDocument = getRandomElementInList(documentByTypeList);
            scrollIntoView(randomDocument);
            WebElement parentElement = getParentElement(randomDocument);
            setParameter(DOCUMENT_URL, parentElement.getAttribute("href"));
            parentElement.click();
        } else {
            setPostponedTestFail("В меню 'Мое избранное' Отсутствует необходимый тип документа");
        }
    }

    private WebElement getHeader() {
        return waitForVisibilityOfElementLocatedBy(By.tagName("header"), "Header не найден");
    }

    @Step("Открыть личный кабинет")
    public BssProfilePage clickProfileLink() {
        clickProfileLinkBase();
        return redirectTo(BssProfilePage.class);
    }

    @Step("Открыть раздел 'Новости'")
    public BssNewsPage clicNewsPageLink() {
        clickNewsPageBase();
        return redirectTo(BssNewsPage.class);
    }

    public BssSearchResultPage checkErrataInSearchQuery(String queryTrue, String queryFalse) {
        getHelper(SearchResultHelper.class).checkErrataInSearchQuery(queryTrue, queryFalse);
        return redirectTo(BssSearchResultPage.class);
    }

    public BssSearchResultPage clickNoFixLink() {
        getHelper(SearchResultHelper.class).clickNoFixLink();
        return redirectTo(BssSearchResultPage.class);
    }

    public BssSearchResultPage checkSearchResultIsNotPresent() {
        getHelper(SearchResultHelper.class).checkSearchResultIsNotPresent();
        return redirectTo(BssSearchResultPage.class);
    }

    public BssSearchResultPage checkKeyboardLayoutInSearchQuery(String queryTrue, String queryFalse) {
        getHelper(SearchResultHelper.class).checkKeyboardLayoutInSearchQuery(queryTrue, queryFalse);
        return redirectTo(BssSearchResultPage.class);
    }

    public BssSearchResultPage checkErrataInSearchQueryAndFilter(String queryTrue, String queryFalse) {
        getHelper(SearchResultHelper.class).checkErrataInSearchQueryAndFilter(queryTrue, queryFalse);
        return redirectTo(BssSearchResultPage.class);
    }

    public BssSearchResultPage checkErrataInSearchQuerySwitchSection(String queryTrue, String queryFalse) {
        getHelper(SearchResultHelper.class).checkErrataInSearchQuerySwitchSection(queryTrue, queryFalse);
        return redirectTo(BssSearchResultPage.class);
    }

    @Step("Проверяется что документ отображается")
    public BssDocumentPage checkVideoDocumentIsOpened() {
        WebElement documentBody = findElementByNoThrow(mainContentElement, By.id("document-body"));
        assertNotNull(documentBody, "Документ не открыт");
        postponedAssertTrue(documentBody.isDisplayed(), "Документ не отображается");
        return (BssDocumentPage) this;
    }

    public BssDocumentPage checkVideoVersionIsPresent() {
        getHelper(DocumentHelper.class).checkVideoVersionIsPresent();
        return (BssDocumentPage) this;
    }

    public BssDocumentPage checkVideoPlayerIsPresent() {
        getHelper(DocumentHelper.class).checkVideoPlayerIsPresent();
        return (BssDocumentPage) this;
    }

    public BssDocumentPage checkNavigationButtonsForVideoArePresent() {
        getHelper(DocumentHelper.class).checkNavigationButtonsForVideoArePresent();
        return (BssDocumentPage) this;
    }

    public BssDocumentPage checkVideoTitleIsPresent() {
        getHelper(DocumentHelper.class).checkVideoTitleIsPresent();
        return (BssDocumentPage) this;
    }

    public BssDocumentPage checkVideoPartTitleIsPresent() {
        getHelper(DocumentHelper.class).checkVideoPartTitleIsPresent();
        return (BssDocumentPage) this;
    }

    public BssDocumentPage checkVideoPartsArePresent() {
        getHelper(DocumentHelper.class).checkVideoPartsArePresent();
        return (BssDocumentPage) this;
    }

    public BssDocumentPage checkActivePartHasPlayButton() {
        getHelper(DocumentHelper.class).checkActivePartHasPlayButton();
        return (BssDocumentPage) this;
    }

    public BssDocumentPage checkTitleOfFormImage() {
        getHelper(DocumentHelper.class).checkTitleOfFormImage();
        return (BssDocumentPage) this;
    }

    public BssDocumentPage checkFormGaleryOpen() {
        getHelper(DocumentHelper.class).checkFormGaleryOpen();
        return (BssDocumentPage) this;
    }

    @Step("Проверяется шапка неавторизованного пользователя")
    public P checkMainPanelNotAuthorized() {
        WebElement mainPanel = findElementByNoThrow(By.cssSelector(".header__in"));
        postponedAssertEquals(mainPanel.getCssValue("background-color"), "rgba(254, 153, 47, 1)", "Шапка не оранжевая: " + "rgba(254, 153, 47, 1), " +
                "а " + mainPanel.getCssValue("background-color"));
        WebElement userEnter = findElementByNoThrow(By.id("user-enter"));
        postponedAssertEquals(userEnter.getText(), "Вход и регистрация", "Ссылка имеет текст не Вход и регистрация, а " +
                userEnter.getText());
        return (P) this;
    }

    @Step("Проверяется минимальная шапка неавторизованного пользователя")
    public P checkMainPanelMiniStateNotAuthorized() {
        WebElement mainPanel = findElementByNoThrow(By.cssSelector(".header__in"));
        postponedAssertEquals(mainPanel.getCssValue("background-color"), "rgba(48, 162, 159, 1)", "Шапка не голубая: " + "rgba(48, 162, 159, 1), " +
                "а " + mainPanel.getCssValue("background-color"));
        WebElement menu = findElementByNoThrow(By.id("main-menu"));
        postponedAssertFalse(menu.isDisplayed(), "Меню отображено в минимальной плашке");
        return (P) this;
    }

    @Step("Проверяется минимальная шапка после нажатия на кнопку Еще для неавторизованного пользователя")
    public P checkMainPanelMiniStateAfterClickOnMoreButtonForNotAuthorized() {
        WebElement mainPanel = findElementByNoThrow(By.cssSelector(".header__in"));
        postponedAssertEquals(mainPanel.getCssValue("background-color"), "rgba(48, 162, 159, 1)", "Шапка не голубая: " + "rgba(48, 162, 159, 1), " +
                "а " + mainPanel.getCssValue("background-color"));
        WebElement menu = findElementByNoThrow(By.cssSelector(".page_state_extended"));
        postponedAssertTrue(menu.isDisplayed(), "Меню отображено в минимальной плашке");
        return (P) this;
    }

    @Step("Проверяется шапка неавторизованного пользователя")
    public P clickMoreButtonOnMainPanel() {
        WebElement moreButton = findElementByNoThrow(By.cssSelector("#header #more"));
        moreButton.click();
        return (P) this;
    }

    @Step("Проверяется шапка неавторизованного пользователя")
    public P checkMainPanelAuthorized() {
        WebElement mainPanel = findElementByNoThrow(By.cssSelector(".header__in"));
        postponedAssertEquals(mainPanel.getCssValue("background-color"), "rgba(254, 153, 47, 1)", "Шапка не оранжевая: " + "rgba(254, 153, 47, 1), " +
                "а " + mainPanel.getCssValue("background-color"));
        WebElement userEnter = findElementByNoThrow(By.id("user-enter"));
        postponedAssertFalse(userEnter.getText().contains("Вход и регистрация"), "Пользователь не авторизован!");
        return (P) this;
    }

    @Step("Проверяется шапка неавторизованного пользователя")
    public P checkMainPanelMiniStateAuthorized() {
        WebElement mainPanel = findElementByNoThrow(By.cssSelector(".header__in"));
        postponedAssertEquals(mainPanel.getCssValue("background-color"), "rgba(48, 162, 159, 1)", "Шапка не голубая: " + "rgba(48, 162, 159, 1), " +
                "а " + mainPanel.getCssValue("background-color"));
        WebElement userEnter = findElementByNoThrow(By.id("user-enter"));
        postponedAssertFalse(userEnter.getText().contains("Вход и регистрация"), "Пользователь не авторизован!");
        return (P) this;
    }

    @Step("Проверяется текст тега title на стартовой странице системы")
    public P checkTagTitle() {
        String title = "";
        if (getCurrentUrl().contains("vip.") || getCurrentUrl().contains("doc.")) {
            title = "Бухгалтерская справочная система «Система Главбух» — ВИП-версия. Рекомендации, ответы " +
                    "чиновников на бухгалтерские вопросы";
        } else if (getCurrentUrl().contains("bu.") || getCurrentUrl().contains("budget.")) {
            title = "Бухгалтерская справочная система «Система Главбух» для бюджетных учреждений. Рекомендации, " +
                    "ответы чиновников на бухгалтерские вопросы";
        } else if (getCurrentUrl().contains("u.") || getCurrentUrl().contains("usn.")) {
            title = "Бухгалтерская справочная система «Система Главбух» для упрощенки. Рекомендации, ответы " +
                    "чиновников на бухгалтерские вопросы";
        } else {
            title = "Бухгалтерская справочная система «Система Главбух» для коммерческих организаций. Рекомендации, " +
                    "ответы чиновников на бухгалтерские вопросы";
        }
        checkTagTitle(title);
        return (P) this;
    }

    public P checkPopupPredemoCheckBoxSubscribe() {
        getHelper(PredemoPopup.class).checkCheckBoxSubscribe("Подписаться на бухгалтерские новости");
        return (P) this;
    }

}
