package com.actionmedia.pages.uss;

import com.actionmedia.autotest.selenium.annotations.Wait;
import com.actionmedia.autotest.selenium.context.AbstractPage;
import com.actionmedia.autotest.selenium.elements.TextField;
import com.actionmedia.base.BasePage;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.components.popups.PredemoPopup;
import com.actionmedia.pages.LoginPage;
import com.actionmedia.pages.helpers.RubricatorHelper;
import com.actionmedia.pages.helpers.SearchResultHelper;
import com.actionmedia.pages.interfaces.ISystemBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

@Component
public class UssBasePage<P extends BasePage> extends BasePage<P> implements ISystemBasePage{

    @FindBy(id = "search-text")
    @Wait
    protected TextField searchBox;

    private static final String ACCESS_TAB_TEXT = "Система требует ввести код, поскольку у Вас есть оплаченный доступ к другой версии Системы Юрист.\n" +
            "Если Вы хотите поменять версию Системы, обратитесь к своему менеджеру или по телефону единого сервисного центра 8 800 333-01-15.";

    public UssBasePage logout() {
        logoutBase();
        return redirectToWithoutWait(UssBasePage.class);
    }

    private <T extends AbstractPage> T clickPortalTab(final MainMenuButtons portalButton, final Class<T> requiredPage) {
        scrollToStart();
        WebElement mainMenu = waitForPresenceOfElementLocatedBy(By.id("main-menu"));
        WebElement portalButtonWebElement = mainMenu.findElement(portalButton.getButtonLocator());
        portalButtonWebElement.click();
        report("Страница '" + portalButton.getName() + "' открыта");
        if (portalButton.equals(MainMenuButtons.LAW_BASE) || portalButton.equals(MainMenuButtons.LAW_PRACTICE)){
            WebElement closeExtendedCloseButton = findElementByNoThrow(By.cssSelector(".search-extended [title='Закрыть']"));
            if (closeExtendedCloseButton != null){
                closeExtendedCloseButton.click();
                waitForReloadingPage();
            }
        }
        return redirectTo(requiredPage);
    }

    @Step("Проверяется что лого системы отображается в шапке сайта")
    public P checkLogoIsPresentOnRssPage() {
        WebElement logo = waitForPresenceOfElementLocatedBy(By.id("feedTitleImage"));
        postponedAssertNotNull(logo, "Лого системы не найдено");
        if (logo != null) {
            String logoImgSrc = logo.getAttribute("src");
            postponedAssertTrue(logoImgSrc.contains("rss-logo-uss.jpg"), "Неправильная картинка для лого системы");
        }

        return (P) this;
    }

    @Step("Открыть страницу 'Рекомендации'")
    public UssRecomendPage navigateToRecomendPage() {
        return clickPortalTab(MainMenuButtons.RECOMEND, UssRecomendPage.class);
    }

    @Step("Открыть страницу 'Правовая база'")
    public UssLawBasePage navigateToLawBasePage() {
        return clickPortalTab(MainMenuButtons.LAW_BASE, UssLawBasePage.class);
    }

    @Step("Открыть страницу 'Судебная практика'")
    public UssLawPracticePage navigateToLawPracticePage() {
        return clickPortalTab(MainMenuButtons.LAW_PRACTICE, UssLawPracticePage.class);
    }

    @Step("Открыть страницу 'Формы'")
    public UssFormsPage navigateToFormsPage() {
        return clickPortalTab(MainMenuButtons.FORMS, UssFormsPage.class);
    }

    @Step("Открыть страницу 'Справочники'")
    public UssDictionaryPage navigateToDictionaryPage() {
        return clickPortalTab(MainMenuButtons.DICTIONARY, UssDictionaryPage.class);
    }

    @Step("Открыть страницу 'Журналы'")
    public UssMagazinesPage navigateToMagazinesPage() {
        return clickPortalTab(MainMenuButtons.MAGAZINES_AND_BOOKS, UssMagazinesPage.class);
    }

    @Step("Открыть страницу 'Видео'")
    public UssVideosPage navigateToVideoPage() {
        return clickPortalTab(MainMenuButtons.VIDEO, UssVideosPage.class);
    }

    @Step("Открыть страницу 'Сервисы'")
    public UssServicesPage navigateToServicesPage() {
        return clickPortalTab(MainMenuButtons.SERVICES, UssServicesPage.class);
    }

    @Step("Открыть страницу 'Мастера'")
    public UssWizardsPage navigateToWizardsPage() {
        return clickPortalTab(MainMenuButtons.WIZARDS, UssWizardsPage.class);
    }

    @Step("Открыть страницу 'Промо'")
    public UssPromoPage navigateToPromoPage() {
        clickAboutSystem();
        return redirectTo(UssPromoPage.class);
    }

    @Step("Проверка выбранного пункта меню")
    public P checkCurrentItemIsSelected(MainMenuButtons mainMenuButton) {
        String actualItemName;
        actualItemName = waitForPresenceOfElementLocatedBy(By.cssSelector(".btn_state_active"), "Не один раздел не выбран в главном меню").getText();
        postponedAssertEquals(actualItemName, mainMenuButton.getName(), "Выбран неправильный раздел в главном меню");
        return (P) this;
    }

    @Step("Проверяется Меню поиск в тексте")
    protected P checkSearchInTextElementIsPresent() {
        WebElement searchBox = waitForPresenceOfElementLocatedBy(By.id("search-form"));
        WebElement searchIn = findElementByNoThrow(searchBox, By.cssSelector(".search-in"));
        assertNotNull(searchIn, "Меню Поиск в тексте не найден");
        waitForTextToBePresentIn(searchIn, "текст");
        postponedAssertEquals(searchIn.findElement(By.cssSelector(".msg")).getText(), "Поиск в тексте", "Неправильный текст меню Поиск в тексте");
        return (P) this;
    }

    @Step("Нажать любую простую подсказку")
    protected UssSearchResultPage clickRandomHint() {
        waitForHints();
        WebElement searchResult = waitForVisibilityOfElementLocatedBy(By.id("ui-id-1"), "Выпадающие поисковые подсказки не отображаются");
        waitForTextToBePresentIn(searchResult);
        List<WebElement> hints = searchResult.findElements(By.cssSelector(".ui-menu-item"));
        List<WebElement> randomHints = new ArrayList<WebElement>();

        for (WebElement hint : hints) {
            if (!hint.getAttribute("class").contains("hint-doc") && !hint.getAttribute("class").contains("history-doc")) {
                randomHints.add(hint);
            }
        }

        assertFalse(randomHints.isEmpty(), "Простые поисковые подсказки не найдены");
        WebElement randomHint = getRandomElementInList(randomHints);
        setParameter(SearchResultHelper.HINT_TEXT, randomHint.getText());
        randomHint.click();
        return redirectTo(UssSearchResultPage.class);
    }

    @Step("Нажать подсказку с прямым переходом")
    protected UssSearchResultPage clickHintWithJump() {
        waitForHints();
        WebElement searchResult = waitForVisibilityOfElementLocatedBy(By.id("ui-id-1"), "Выпадающие поисковые подсказки не отображаются");
        waitForTextToBePresentIn(searchResult);
        List<WebElement> hintsWith = searchResult.findElements(By.cssSelector(".hint-doc"));
        if (!hintsWith.isEmpty()) {
            WebElement hintsWithJumpLink = hintsWith.get(0).findElement(By.tagName("a"));
            setParameter(SearchResultHelper.DOCUMENT_URL, hintsWithJumpLink.getAttribute("href"));
            hintsWithJumpLink.click();
        } else {
            fail("Подсказки с прямым переходом не отображаются");
        }
        return redirectTo(UssSearchResultPage.class);
    }

    @Step("Проверяется что поисковые подсказки отображаются")
    protected P checkHintListIsPresent() {
        waitForHints();
        WebElement searchResult = waitForVisibilityOfElementLocatedBy(By.id("ui-id-1"), "Выпадающие поисковые подсказки не отображаются");
        waitForTextToBePresentIn(searchResult);
        List<WebElement> hintsWith = searchResult.findElements(By.cssSelector(".hint-doc"));
        List<WebElement> hints = searchResult.findElements(By.cssSelector(".ui-menu-item"));
        postponedAssertFalse(hintsWith.isEmpty(), "Подсказки с прямым переходом не найдены");
        for (WebElement hint : hints) {
            postponedAssertTrue(hint.isDisplayed(), "Простые подсказки не найдены");
        }
        return (P) this;
    }

    @Step("Нажать кнопку Найти")
    public UssSearchResultPage clickSearchButtonAndNavigateToSearchResultPage() {
        clickSearchButton();
        return redirectTo(UssSearchResultPage.class);
    }

    @Step("Проверяется что результаты поиска отсутсвуют")
    protected P checkSearchResultIsNotPresentOnPage() {
        WebElement searchResultHeader = findElementByNoThrow(mainContentElement, By.cssSelector(".search-result"));
        WebElement searchResult = findElementByNoThrow(mainContentElement, By.cssSelector(".widget-search"));
        postponedAssertNull(searchResultHeader, "Заголовок результатов поиска отображается");
        postponedAssertNull(searchResult, "Результаты поиска отображаются");
        return (P) this;
    }

    @Step("Открыть страницу Написать эксперту")
    public UssQuestionPage clickAskExpertLink() {
        waitForPresenceOfElementLocatedBy(By.cssSelector("[href*='/#/hotline/']")).click();
        return redirectTo(UssQuestionPage.class);
    }

    @Step("Открыть страницу 'Активация подписки'")
    public LoginPage navigateToLoginPage() {
        clickLoginLink();
        return redirectTo(LoginPage.class);
    }

    @Step("Проверка открытия страницы написать эксперту")
    public P checkAskPage() {
        postponedAssertTrue(getCurrentUrl().contains("#/hotline/"), "Ссылка должна содержать hotline, ссылка: " + getCurrentUrl());
        return (P) this;
    }

    @Step("Открыть страницу 'Активация подписки'")
    public UssBasePage navigateToUssLoginPage() {
        waitForPresenceOfElementLocatedBy(By.cssSelector(".btn__in")).click();
        return redirectTo(UssBasePage.class);
    }

    @Step("Открыть страницу Личного кабинета")
    public UssProfilePage clickProfileLink() {
        clickProfileLinkBase();
        return redirectTo(UssProfilePage.class);
    }

    @Step("Открыть документ с заданным урл")
    public UssDocumentPage openDocumentByUrl(String documentUrl) {
        report("Открывается ссылка: " + documentUrl);
        openUrl(documentUrl);
        return redirectTo(UssDocumentPage.class);
    }

    @Step("Открыть заданный урл")
    public UssDocumentPage openByPartialUrl(String partialDocUrl) {
        String currentUrl = getCurrentUrl().split("#")[0];
        String documentUrl = currentUrl + partialDocUrl;
        report("Открывается ссылка: " + documentUrl);
        openUrl(documentUrl);
        return redirectToWithoutWait(UssDocumentPage.class);
    }

    @Step("Открыть документ с заданным урл")
    public UssDocumentPage openDocumentByModuleIdAndDocId(String partialDocUrl) {
        String currentUrl = getCurrentUrl().split("#")[0];
        String documentUrl = currentUrl + partialDocUrl;
        report("Открывается ссылка: " + documentUrl);
        openUrl(documentUrl);
        return redirectTo(UssDocumentPage.class);
    }

    @Step("Открыть документ с заданным урл")
    public UssDocumentPage openDocumentWithoutWaitByModuleIdAndDocId(String partialDocUrl) {
        String currentUrl = getCurrentUrl().split("#")[0];
        String documentUrl = currentUrl + partialDocUrl;
        report("Открывается ссылка: " + documentUrl);
        openUrl(documentUrl);
        return redirectToWithoutWait(UssDocumentPage.class);
    }

    @Step("Открыть рубрикатор")
    public UssRubricator clickRubricatorButton() {
        waitForPresenceOfElementLocatedBy(By.id("rubricator-btn")).click();
        waitForVisibilityOfElementLocatedBy(By.id("rubricator"), "Рубрикатор не найден");
        return redirectTo(UssRubricator.class);
    }

    public UssRubricator checkAllRubricsInRubricator() {
        getHelper(RubricatorHelper.class).checkAllRubrics();
        return redirectTo(UssRubricator.class);
    }

    @Step("Открыть раздел 'О системе'")
    public UssAboutSystemPage clickAboutSystemLink() {
        clickAboutSystemLinkBase();
        return redirectTo(UssAboutSystemPage.class);
    }

    @Step("Проверяеттся что желтая плашка отображается")
    public P checkWarningPanelIsPresent() {
        WebElement content = waitForPresenceOfElementLocatedBy(By.cssSelector(".page"), "Желтая плашка не найдена");
        WebElement warningPanel = findElementByNoThrow(content, By.id("warning-panel"));
        postponedAssertNotNull(warningPanel, "Желтая плашка не найдена");
        if (warningPanel != null) {
            postponedAssertTrue(warningPanel.isDisplayed(), "Желтая плашка не отображается");
            postponedAssertEquals(warningPanel.getText().trim(), "У вас есть доступ к другой версии: ЮСС «Система Юрист»", "Неправильный текст в желтой плашке");
        }
        return (P) this;
    }

    @Step("Проверяется что открыта вкладка активации подписки")
    public P checkActivationTabIsPresent() {
        WebElement registerControl = findElementByNoThrow(mainLeftElement, By.cssSelector(".whiteboard-control"));
        WebElement accessMessageElement = findElementByNoThrow(mainLeftElement, By.cssSelector(".page-noaccess-preambula"));
        waitForPresenceOfElementLocatedBy(By.id("wf-activate"), "Вкладка 'Активация подписки' не найдена").click();
        postponedAssertNotNull(registerControl, "Вкладка активации подписки не найдена");
        postponedAssertNotNull(accessMessageElement, "Вкладка активации подписки не найдена");
        if (registerControl != null) {
            WebElement activeTab = registerControl.findElement(By.cssSelector(".pressed"));
            String activeTabName = activeTab.findElement(By.tagName("a")).getText();
            postponedAssertEquals(activeTabName, "Активация подписки", "Неправильный текст заголовка вкладки 'Активация подписки'");
        }
        if (accessMessageElement != null) {
            String accessText = accessMessageElement.getText().trim();
            postponedAssertEquals(accessText, ACCESS_TAB_TEXT, "Неправильный текст заголовка вкладки 'Активация подписки'");
        }
        return (P) this;
    }

    @Step("Проверяется что кнопка 'Активировать' не активна")
    public P checkActivationButtonIsDisabled() {
        WebElement activationButton = findElementByNoThrow(mainLeftElement, By.id("button-activate"));
        postponedAssertNotNull(activationButton, "Кнопка 'Активировать' не найдена");
        if (activationButton != null) {
            postponedAssertTrue(activationButton.isDisplayed(), "Кнопка 'Активировать' не отображается");
            postponedAssertTrue(activationButton.getAttribute("class").contains("disabled"), "Кнопка 'Активировать' активна");
        }
        return (P) this;
    }

    @Step("Проверяется что открыто превью документа")
    public P checkPreviewDocumentIsOpened() {
        WebElement fullDocBody = findElementByNoThrow(mainLeftElement, By.id("document-body"));
        WebElement previewDocBody = findElementByNoThrow(mainLeftElement, By.cssSelector(".doc-preview"));
        postponedAssertNull(fullDocBody, "Открыт полный документ");
        postponedAssertNotNull(previewDocBody, "Открыт полный документ");
        return (P) this;
    }

    @Step("Проверяеттся что желтая плашка отображается")
    public P checkWarningPanelIsNotPresent() {
        WebElement content = waitForPresenceOfElementLocatedBy(By.cssSelector(".page"), "Желтая плашка не найдена");
        WebElement warningPanel = findElementByNoThrow(content, By.id("warning-panel"));
        if (warningPanel != null) {
            postponedAssertFalse(warningPanel.isDisplayed(), "Желтая плашка отображается");
        }
        return (P) this;
    }

    @Step("Проверяется что вкладка активации подписки не отображается")
    public P checkActivationTabIsNotPresent() {
        WebElement registerControl = findElementByNoThrow(mainLeftElement, By.cssSelector(".whiteboard-control"));
        WebElement accessMessageElement = findElementByNoThrow(mainLeftElement, By.cssSelector(".page-noaccess-preambula"));
        postponedAssertNull(registerControl, "Вкладка активации подписки отображается");
        postponedAssertNull(accessMessageElement, "Вкладка активации подписки отображается");
        return (P) this;
    }

    @Step("Проверяется что открыт полный документа")
    public P checkFullDocumentIsOpened() {
        WebElement fullDocBody = findElementByNoThrow(mainLeftElement, By.id("document-body"));
        WebElement previewDocBody = findElementByNoThrow(mainLeftElement, By.cssSelector(".doc-preview"));
        postponedAssertNull(previewDocBody, "Открыто превью документ");
        postponedAssertNotNull(fullDocBody, "Открыто превью документ");
        return (P) this;
    }

    @Step("Проверяется что открыта страница активации кода доступа")
    public P checkActivationCodePageIsOpened() {
        WebElement activationCodeElement = findElementByNoThrow(mainLeftElement, By.id("fields-activate"));
        WebElement activationButton = findElementByNoThrow(mainLeftElement, By.id("button-activate"));
        postponedAssertNotNull(activationCodeElement, "Поля для ввода кода доступа не найдены");
        postponedAssertNotNull(activationButton, "Кнопка 'Активировать' не найдена");
        postponedAssertTrue(getCurrentUrl().contains("activate-code"), "Страница активации кода доступа не открыта");
        return (P) this;
    }

    @Step("Проверяется порядок разделов на плашке")
    public P checkSectionOrderInMainHeader() {
        WebElement header = getHeader();
        WebElement mainMenu = header.findElement(By.id("main-menu"));
        List<WebElement> menuItemList = mainMenu.findElements(By.tagName("li"));

        WebElement recomendTab = menuItemList.get(0);
        WebElement lawTab = menuItemList.get(1);
        WebElement lawPracticeTab = menuItemList.get(2);
        WebElement formsTab = menuItemList.get(3);
        WebElement dictionaryTab = menuItemList.get(4);
        WebElement magazineTab = menuItemList.get(5);
        WebElement videoTab = menuItemList.get(6);
        WebElement wizardTab = menuItemList.get(7);
        WebElement dogovorTab = menuItemList.get(8);

        postponedAssertEquals(recomendTab.getText(), MainMenuButtons.RECOMEND.getName(), "Неправильный порядок раздела '" + MainMenuButtons.RECOMEND.getName() + "' в главной плашке системы");
        postponedAssertEquals(lawTab.getText(), MainMenuButtons.LAW_BASE.getName(), "Неправильный порядок раздела '" + MainMenuButtons.LAW_BASE.getName() + "' в главной плашке системы");
        postponedAssertEquals(lawPracticeTab.getText(), MainMenuButtons.LAW_PRACTICE.getName(), "Неправильный порядок раздела '" + MainMenuButtons.LAW_PRACTICE.getName() + "' в главной плашке системы");
        postponedAssertEquals(formsTab.getText(), MainMenuButtons.FORMS.getName(), "Неправильный порядок раздела '" + MainMenuButtons.FORMS.getName() + "' в главной плашке системы");
        postponedAssertEquals(dictionaryTab.getText(), MainMenuButtons.DICTIONARY.getName(), "Неправильный порядок раздела '" + MainMenuButtons.DICTIONARY.getName() + "' в главной плашке системы");
        postponedAssertEquals(magazineTab.getText(), MainMenuButtons.MAGAZINES_AND_BOOKS.getName(), "Неправильный порядок раздела '" + MainMenuButtons.MAGAZINES_AND_BOOKS.getName() + "' в главной плашке системы");
        postponedAssertEquals(videoTab.getText(), MainMenuButtons.VIDEO.getName(), "Неправильный порядок раздела '" + MainMenuButtons.VIDEO.getName() + "' в главной плашке системы");
        postponedAssertEquals(wizardTab.getText(), MainMenuButtons.WIZARDS.getName(), "Неправильный порядок раздела '" + MainMenuButtons.WIZARDS.getName() + "' в главной плашке системы");
        postponedAssertEquals(dogovorTab.getText(), MainMenuButtons.DOGOVOR.getName(), "Неправильный порядок раздела '" + MainMenuButtons.DOGOVOR.getName() + "' в главной плашке системы");
        return (P) this;
    }

    @Step("Проверяется что логотип системы отображается на плашке")
    public P checkLogoIsPresent() {
        WebElement header = getHeader();
        WebElement logo = findElementByNoThrow(header, By.cssSelector(".logo"));
        postponedAssertNotNull(logo, "Логотип системы не найден");
        if (logo != null) {
            postponedAssertTrue(logo.isDisplayed(), "Логотип системы не отображается");
        }
        return (P) this;
    }


    @Step("Проверяется что цитата отображается на плашке")
    public P checkBalloonPhraseIsPresent() {
        WebElement header = getHeader();
        WebElement balloon = findElementByNoThrow(header, By.id("latin"));
        postponedAssertNotNull(balloon, "Цитата не найдена");
        if (balloon != null) {
            postponedAssertTrue(balloon.isDisplayed(), "Цитата не отображается");
        }
        return (P) this;
    }

    @Step("Проверяется что кнопка Личного кабинета отображается на плашке")
    public P checkProfileButtonIsPresent() {
        WebElement header = getHeader();
        WebElement profileLink = findElementByNoThrow(header, By.id("user-enter"));
        postponedAssertNotNull(profileLink, "Кнопка Личного кабинета не найдена");
        if (profileLink != null) {
            postponedAssertTrue(profileLink.isDisplayed(), "Кнопка 'Личного кабинета' не отображается");
            postponedAssertFalse(profileLink.getText().isEmpty(), "Текст кнокпи 'Личного кабинета' пустой");
        }
        return (P) this;
    }

    @Step("Проверяется что кнопка 'О системе' отображается на плашке")
    public P checkAboutSystemButtonIsPresent() {
        WebElement header = getHeader();
        WebElement aboutSystemLink = findElementByNoThrow(header, By.cssSelector("[href*='/about/']"));
        postponedAssertNotNull(aboutSystemLink, "Кнопка 'О системе' не найдена");
        if (aboutSystemLink != null) {
            postponedAssertTrue(aboutSystemLink.isDisplayed(), "Кнопка 'О системе' не отображается");
            postponedAssertFalse(aboutSystemLink.getText().isEmpty(), "Текст кнокпи 'О системе' пустой");
        }
        return (P) this;
    }

    @Step("Проверяется что кнопка 'Написать эксперту' отображается на плашке")
    public P checkAskExpertButtonIsPresent() {
        WebElement header = getHeader();
        WebElement askExpertButton = findElementByNoThrow(header, By.cssSelector("[href*='/hotline/']"));
        postponedAssertNotNull(askExpertButton, "Кнопка 'Написать эксперту' не найдена");
        if (askExpertButton != null) {
            postponedAssertTrue(askExpertButton.isDisplayed(), "Кнопка 'Написать эксперту' не отображается");
            postponedAssertFalse(askExpertButton.getText().isEmpty(), "Текст кнокпи 'Написать эксперту' пустой");
        }
        return (P) this;
    }

    @Step("Нажать на лого системы")
    public UssRecomendPage clickLogoButton() {
        WebElement header = getHeader();
        WebElement logo = findElementByNoThrow(header, By.cssSelector(".logo"));
        logo.click();
        return redirectTo(UssRecomendPage.class);
    }

    @Step("Нажать на лого системы")
    public UssRecomendPage checkPhraseIsChangedAfterClick() {
        WebElement header = getHeader();
        WebElement balloon = findElementByNoThrow(header, By.cssSelector(".balloon-big"));
        WebElement latin = balloon.findElement(By.id("latin"));
        WebElement rus = balloon.findElement(By.id("rus"));

        boolean isLatinSelected = latin.isDisplayed();
        boolean isRusSelected = rus.isDisplayed();

        balloon.click();

        if (isLatinSelected) {
            postponedAssertTrue(rus.isDisplayed(), "Язык цитаты не изменился после нажатия на нее");
        }
        if (isRusSelected) {
            postponedAssertTrue(latin.isDisplayed(), "Язык цитаты не изменился после нажатия на нее");
        }
        return redirectTo(UssRecomendPage.class);
    }

    @Step("Проверяется размер для стандартной плашки")
    public P checkMainHeaderHasDefaultSize() {
        WebElement header = getHeader();
        postponedAssertEquals(header.getSize().getHeight(), 80, "Размер плашки неправильный");
        return (P) this;
    }

    @Step("Проверяется размер для свернутой плашки")
    public P checkMainHeaderHasMinSize() {
        WebElement header = getHeader();
        postponedAssertEquals(header.getSize().getHeight(), 120, "Размер плашки неправильный");
        return (P) this;
    }

    @Step("Проверяется размер для развернутой плашки")
    public P checkMainHeaderHasMaxSize() {
        WebElement header = getHeader();
        postponedAssertEquals(header.getSize().getHeight(), 217, "Размер плашки неправильный");
        return (P) this;
    }

    @Step("Нажать на кнопку 'Еще' на плашке")
    public P clickMoreButton() {
        WebElement header = getHeader();
        WebElement moreButton = header.findElement(By.id("more"));
        moreButton.click();
        return (P) this;
    }

    @Step("Вернутся на главную страницу системы")
    public UssRecomendPage returnToMainPage() {
        returnToBack();
        navigateToRecomendPage();
        return redirectTo(UssRecomendPage.class);
    }

    private WebElement getHeader() {
        return waitForVisibilityOfElementLocatedBy(By.id("header"), "Header сайта не найден");
    }

    @Step("Открыть раздел 'Новости'")
    public UssNewsPage clickNewsPageLink() {
        clickNewsPageBase();
        return redirectTo(UssNewsPage.class);
    }

    public UssSearchResultPage checkErrataInSearchQuery(String queryTrue, String queryFalse) {
        getHelper(SearchResultHelper.class).checkErrataInSearchQuery(queryTrue, queryFalse);
        return redirectTo(UssSearchResultPage.class);
    }

    public UssSearchResultPage clickNoFixLink() {
        getHelper(SearchResultHelper.class).clickNoFixLink();
        return redirectTo(UssSearchResultPage.class);
    }

    public UssSearchResultPage checkSearchResultIsNotPresent() {
        getHelper(SearchResultHelper.class).checkSearchResultIsNotPresent();
        return redirectTo(UssSearchResultPage.class);
    }

    public UssSearchResultPage checkKeyboardLayoutInSearchQuery(String queryTrue, String queryFalse) {
        getHelper(SearchResultHelper.class).checkKeyboardLayoutInSearchQuery(queryTrue, queryFalse);
        return redirectTo(UssSearchResultPage.class);
    }

    public UssSearchResultPage checkErrataInSearchQueryAndFilter(String queryTrue, String queryFalse) {
        getHelper(SearchResultHelper.class).checkErrataInSearchQueryAndFilter(queryTrue, queryFalse);
        return redirectTo(UssSearchResultPage.class);
    }

    public UssSearchResultPage checkErrataInSearchQuerySwitchSection(String queryTrue, String queryFalse) {
        getHelper(SearchResultHelper.class).checkErrataInSearchQuerySwitchSection(queryTrue, queryFalse);
        return redirectTo(UssSearchResultPage.class);
    }

    @Step("Нажать кнопку Найти в форме дополнительных аттрибутах поиска")
    public UssSearchResultPage clickSearchExtendedButton() {
        extendedSearchForm.clickSearchExtendedButton();
        return redirectTo(UssSearchResultPage.class);
    }

    @Step("Переключиться на страницу 'Правовая база'")
    public UssLawBasePage switchToLawBasePage() {
        return redirectTo(UssLawBasePage.class);
    }

    @Step("Проверяется шапка неавторизованного пользователя")
    public P clickMoreButtonOnMainPanel() {
        WebElement moreButton = findElementByNoThrow(By.cssSelector("#header #more"));
        moreButton.click();
        return (P) this;
    }

    public P checkPopupPredemoCheckBoxSubscribe() {
        getHelper(PredemoPopup.class).checkCheckBoxSubscribe("Подписаться на юридические новости");
        return (P) this;
    }

    public P checkPopupPredemoPhotoBackground() {
        getHelper(PredemoPopup.class).checkBackgroundPhoto("editor-in-chief");
        return (P) this;
    }

    public P checkPopupPredemoLogo() {
        getHelper(PredemoPopup.class).checkBackgroundLogo("uss/uss-logo-popup");
        return (P) this;
    }
}
