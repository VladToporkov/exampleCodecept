package com.actionmedia.pages.kss;

import com.actionmedia.autotest.selenium.context.AbstractPage;
import com.actionmedia.base.BasePage;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.components.popups.PredemoPopup;
import com.actionmedia.pages.LoginPage;
import com.actionmedia.pages.helpers.DocumentHelper;
import com.actionmedia.pages.helpers.SearchResultHelper;
import com.actionmedia.pages.interfaces.ISystemBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

@Component
public class KssBasePage<P extends BasePage> extends BasePage<P> implements ISystemBasePage {

    @Step
    public KssBasePage logout() {
        logoutBase();
        return redirectToWithoutWait(KssBasePage.class);
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

    @Step("Открыть страницу 'Правовая база'")
    public KssLawBasePage navigateToLawBasePage() {
        return clickPortalTab(MainMenuButtons.LAW_BASE, KssLawBasePage.class);
    }

    @Step("Переключиться на страницу 'Правовая база'")
    public KssLawBasePage switchToLawBasePage() {
        return redirectTo(KssLawBasePage.class);
    }

    @Step("Открыть страницу 'Формы'")
    public KssFormsPage navigateToFormsPage() {
        return clickPortalTab(MainMenuButtons.FORMS, KssFormsPage.class);
    }

    @Step("Открыть страницу 'Справочники'")
    public KssDictionaryPage navigateToDictionaryPage() {
        return clickPortalTab(MainMenuButtons.DICTIONARY, KssDictionaryPage.class);
    }

    @Step("Открыть страницу 'Журналы'")
    public KssMagazinesPage navigateToMagazinesPage() {
        return clickPortalTab(MainMenuButtons.MAGAZINES_AND_BOOKS, KssMagazinesPage.class);
    }

    @Step("Открыть страницу 'Видео'")
    public KssVideosPage navigateToVideoPage() {
        return clickPortalTab(MainMenuButtons.VIDEO, KssVideosPage.class);
    }

    @Step("Открыть страницу 'Сервисы'")
    public KssServicesPage navigateToServicesPage() {
        return clickPortalTab(MainMenuButtons.SERVICES, KssServicesPage.class);
    }

    @Step("Открыть страницу 'Ответы'")
    public KssAnswersPage navigateToAnswersPage() {
        return clickPortalTab(MainMenuButtons.ANSWERS, KssAnswersPage.class);
    }

    @Step("Открыть страницу 'Мастера'")
    public KssWizardsPage navigateToWizardsPage() {
        return clickPortalTab(MainMenuButtons.WIZARDS, KssWizardsPage.class);
    }

    @Step("Открыть страницу 'Подбор персонала'")
    public KssWizardsPage navigateToRabotaruPage() {
        return clickPortalTab(MainMenuButtons.RABOTARU, KssWizardsPage.class);
    }

    @Step("Открыть страницу 'Обучение'")
    public KssEducationPage navigateToEducationPage() {
        return clickPortalTab(MainMenuButtons.EDU, KssEducationPage.class);
    }

    public KssAnswersPage navigateToRecomendPage() {
        return clickPortalTab(MainMenuButtons.ANSWERS, KssAnswersPage.class);
    }

    @Step("Открыть страницу 'Промо'")
    public KssPromoPage navigateToPromoPage() {
        clickAboutSystem();
        return redirectTo(KssPromoPage.class);
    }


    @Step("Открыть страницу 'Активация подписки'")
    public LoginPage navigateToLoginPage() {
        clickLoginLink();
        return redirectTo(LoginPage.class);
    }

    @Step("Проверка страницы логина")
    public P checkLoginPage() {
        postponedAssertTrue(getCurrentUrl().contains("#/customer/auth"), "Ссылка должна содержать /customer/auth, ссылка: " + getCurrentUrl());
        String loginTab = findElementBy(By.id("wf-enter")).getAttribute("class");
        postponedAssertEquals(loginTab, "dashed pressed", "Выделена не та вкладка! Class = " + loginTab + " а должен быть dashed pressed");
        return (P) this;
    }

    @Step("Открыть страницу 'Активация подписки'")
    public KssBasePage navigateToKssLoginPage() {
        waitForPresenceOfElementLocatedBy(By.cssSelector(".btn__in")).click();
        return redirectTo(KssBasePage.class);
    }

    @Step("Открыть Личную страницу")
    public KssDocumentPage navigateToPersonalCabinetPage() {
        WebElement customerLink = waitForVisibilityOfElementLocatedBy(By.cssSelector("#user-enter a"), "Ссылка на личный кабинет не найдена");
        customerLink.click();
        return redirectTo(KssDocumentPage.class);
    }

    @Step("Проверка выбранного пункта меню")
    public P checkCurrentItemIsSelected(MainMenuButtons MainMenuButtons) {
        WebElement content = waitForPresenceOfElementLocatedBy(By.id("header"));
        WebElement mainMenu = content.findElement(By.id("main-menu"));
        WebElement activeItem = mainMenu.findElement(By.cssSelector(".btn_state_active"));
        assertNotNull(activeItem, "Не один раздел не выбран в главном меню");
        if (activeItem != null) {
            postponedAssertEquals(activeItem.getText(), MainMenuButtons.getName(), "Выбран неправильный раздел в главном меню");
        }
        return (P) this;
    }

    @Step("Проверяется Меню поиск в тексте")
    public P checkSearchInTextWidgetIsPresent() {
        getHelper(DocumentHelper.class).checkSearchInTextWidgetIsPresent();
        return (P) this;
    }

    @Step("Нажать любую простую подсказку")
    protected KssSearchResultPage clickRandomHint() {
        waitForHints();
        WebElement searchResult = waitForVisibilityOfElementLocatedBy(By.id("ui-id-1"), "Выпадающие поисковые подсказки не отображаются");
        waitForTextToBePresentIn(searchResult);
        List<WebElement> hints = searchResult.findElements(By.cssSelector(".ui-menu-item"));
        hints.remove(0);

        assertFalse(hints.isEmpty(), "Простые поисковые подсказки не найдены");
        WebElement randomHint = getRandomElementInList(hints);
        setParameter(SearchResultHelper.HINT_TEXT, randomHint.getText());
        randomHint.click();
        return redirectTo(KssSearchResultPage.class);
    }

    @Step("Нажать подсказку с прямым переходом")
    protected KssSearchResultPage clickHintWithJump() {
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
        return redirectTo(KssSearchResultPage.class);
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
    public KssSearchResultPage clickSearchButtonAndNavigateToSearchResultPage() {
        clickSearchButton();
        return redirectTo(KssSearchResultPage.class);
    }

    @Step("Проверяется что результаты поиска отсутсвуют")
    protected P checkSearchResultIsNotPresentOnPage() {
        WebElement searchResultHeader = findElementByNoThrow(mainContentElement, By.cssSelector(".search-result"));
        WebElement searchResult = findElementByNoThrow(mainContentElement, By.cssSelector(".widget-search"));
        postponedAssertNull(searchResultHeader, "Заголовок результатов поиска отображается");
        postponedAssertNull(searchResult, "Результаты поиска отображаются");
        return (P) this;
    }

    @Step("Нажать кнопку Найти в форме дополнительных аттрибутах поиска")
    public KssSearchResultPage clickSearchExtendedButton() {
        extendedSearchForm.clickSearchExtendedButton();
        return redirectTo(KssSearchResultPage.class);
    }

    public KssDocumentPage openModuleByNumber(String moduleNumber) {
        report("Открыть любой документ " + moduleNumber + " модуля");
        waitForPresenceOfElementLocatedBy(By.id("rubricator-btn")).click();
        waitForVisibilityOfElementLocatedBy(By.id("rubricator"), "Рубрикатор не найден");
        List<WebElement> links = waitForPresenceOfElementLocatedBy(By.cssSelector(".b-rubricator-list")).findElements(By.tagName("li"));
        List<String> docUrlByModuleIdList = new ArrayList<String>();
        for (WebElement section : links) {
            if (docUrlByModuleIdList.size() > 20) {
                break;
            }
            section.findElement(By.tagName("a")).click();
            List<WebElement> subSections = findElementsBy(By.cssSelector(".b-rubricator-list"));
            if (subSections.size() > 1) {
                List<WebElement> subSectionLinks = subSections.get(1).findElements(By.tagName("li"));
                for (WebElement subSectionLink : subSectionLinks) {
                    subSectionLink.findElement(By.tagName("a")).click();
                    WebElement content = waitForPresenceOfElementLocatedBy(By.id("rubricator-right"));
                    waitForTextToBePresentIn(content);
                    List<WebElement> documentLinkList = content.findElements(By.tagName("li"));
                    for (WebElement documentLink : documentLinkList) {
                        WebElement link = documentLink.findElement(By.tagName("a"));
                        String linkUrl = link.getAttribute("href");
                        if (linkUrl.contains("/document/" + moduleNumber) || linkUrl.contains("/wizard/" + moduleNumber) || linkUrl.contains("/documentvideo/" + moduleNumber)) {
                            docUrlByModuleIdList.add(linkUrl);
                        }
                    }
                    List<WebElement> kodeksLinkList = content.findElements(By.cssSelector(".article"));
                    for (WebElement kodeksLink : kodeksLinkList) {
                        WebElement link = kodeksLink.findElement(By.tagName("a"));
                        String linkUrl = link.getAttribute("href");
                        if (linkUrl.contains("/document/" + moduleNumber)) {
                            docUrlByModuleIdList.add(linkUrl);
                        }
                    }
                }
            } else {
                WebElement content = waitForPresenceOfElementLocatedBy(By.id("rubricator-right"));
                waitForTextToBePresentIn(content);
                List<WebElement> documentLinkList = content.findElements(By.tagName("li"));
                for (WebElement documentLink : documentLinkList) {
                    WebElement link = documentLink.findElement(By.tagName("a"));
                    String linkUrl = link.getAttribute("href");
                    if (linkUrl.contains("/document/" + moduleNumber) || linkUrl.contains("/wizard/" + moduleNumber) || linkUrl.contains("/documentvideo/" + moduleNumber)) {
                        docUrlByModuleIdList.add(linkUrl);
                    }
                }
                List<WebElement> kodeksLinkList = content.findElements(By.cssSelector(".article"));
                for (WebElement kodeksLink : kodeksLinkList) {
                    WebElement link = kodeksLink.findElement(By.tagName("a"));
                    String linkUrl = link.getAttribute("href");
                    if (linkUrl.contains("/document/" + moduleNumber)) {
                        docUrlByModuleIdList.add(linkUrl);
                    }
                }
            }
        }

        if (!docUrlByModuleIdList.isEmpty()) {
            String currentUrl = getCurrentUrl();
            String docUrl = getRandomElementInList(docUrlByModuleIdList);
            report("Открыта страница: " + currentUrl);
            report("Открывается ссылка: " + docUrl);
            openUrl(docUrl);
        } else {
            fail("Документ " + moduleNumber + " модуля не найден в рубрикаторе");
        }
        return redirectTo(KssDocumentPage.class);
    }

    @Step("Открыть документ с заданным урл")
    public KssDocumentPage openDocumentByUrl(String documentUrl) {
        waitForReloadingPage();
        report("Открывается ссылка: " + documentUrl);
        openUrl(documentUrl);
        return redirectTo(KssDocumentPage.class);
    }

    @Step("Открыть заданный урл")
    public KssDocumentPage openByPartialUrl(String partialDocUrl) {
        String currentUrl = getCurrentUrl().split("#")[0];
        if (currentUrl.contains("update")) currentUrl = currentUrl.split("update")[0];
        String documentUrl = currentUrl + partialDocUrl;
        report("Открывается ссылка: " + documentUrl);
        openUrl(documentUrl);
        return redirectToWithoutWait(KssDocumentPage.class);
    }

    @Step("Открыть документ с заданным урл")
    public KssDocumentPage openDocumentByModuleIdAndDocId(String partialDocUrl) {
        String currentUrl = getCurrentUrl().split("#")[0];
        String documentUrl = currentUrl + partialDocUrl;
        report("Открывается ссылка: " + documentUrl);
        openUrl(documentUrl, true);
        return redirectTo(KssDocumentPage.class);
    }

    @Step("Открыть документ с заданным урл")
    public KssDocumentPage openDocumentWithoutWaitByModuleIdAndDocId(String partialDocUrl) {
        String currentUrl = getCurrentUrl().split("#")[0];
        String documentUrl = currentUrl + partialDocUrl;
        report("Открывается ссылка: " + documentUrl);
        openUrl(documentUrl);
        return redirectToWithoutWait(KssDocumentPage.class);
    }

    @Step("Открыть страницу Написать эксперту")
    public KssQuestionPage clickAskExpertLink() {
        WebElement header = waitForVisibilityOfElementLocatedBy(By.cssSelector(".menu_type_user"), "Блок ссылок в заголовке сайта не найден");
        header.findElement(By.cssSelector("[href*='/#/hotline/']")).click();
        return redirectTo(KssQuestionPage.class);
    }

    @Step("Открыть личный кабинет")
    public KssProfilePage clickProfileLink() {
        clickProfileLinkBase();
        return redirectTo(KssProfilePage.class);
    }

    @Step("Открыть раздел 'О системе'")
    public KssAboutSystemPage clickAboutSystemLink() {
        clickAboutSystemLinkBase();
        return redirectTo(KssAboutSystemPage.class);
    }

    @Step("Открыть раздел 'Новости'")
    public KssNewsPage clickNewsPageLink() {
        clickNewsPageBase();
        return redirectTo(KssNewsPage.class);
    }

    @Step("Открыть рубрикатор")
    public KssRubricator clickRubricatorButton() {
        waitForPresenceOfElementLocatedBy(By.id("rubricator-btn")).click();
        waitForVisibilityOfElementLocatedBy(By.id("rubricator"), "Рубрикатор не найден");
        return redirectTo(KssRubricator.class);
    }

    @Step("Открыть случайный документ рекомендаций")
    public KssDocumentPage clickRecomendDocument() {
        clickDocumentFromMyFavoritesMenuByType("answers");
        return redirectTo(KssDocumentPage.class);
    }

    @Step("Открыть случайный документ правовой базы")
    public KssDocumentPage clickLawBaseDocument() {
        clickDocumentFromMyFavoritesMenuByType("law");
        return redirectTo(KssDocumentPage.class);
    }

    @Step("Открыть случайный документ форм")
    public KssDocumentPage clickFormsDocument() {
        clickDocumentFromMyFavoritesMenuByType("forms");
        return redirectTo(KssDocumentPage.class);
    }

    @Step("Открыть случайный документ справочников")
    public KssDocumentPage clickDictionaryDocument() {
        clickDocumentFromMyFavoritesMenuByType("handbook");
        return redirectTo(KssDocumentPage.class);
    }

    @Step("Открыть случайный документ журналов")
    public KssDocumentPage clickMagazinesDocument() {
        clickDocumentFromMyFavoritesMenuByType("press");
        return redirectTo(KssDocumentPage.class);
    }

    @Step("Проверяется что лого системы отображается в шапке сайта")
    public P kssCheckLogoIsPresent() {
        WebElement logo = waitForPresenceOfElementLocatedBy(By.id("feedTitleImage"));
        postponedAssertNotNull(logo, "Лого системы не найдено");
        if (logo != null) {
            String logoImgSrc = logo.getAttribute("src");
            postponedAssertTrue(logoImgSrc.contains("rss-logo-kss.jpg"), "Неправильная картинка для лого системы");
        }

        return (P) this;
    }

    @Step("Открыть случайный документ видео")
    public KssDocumentPage clickVideosDocument() {
        clickDocumentFromMyFavoritesMenuByType("videos");
        return redirectTo(KssDocumentPage.class);
    }

    @Step("Открыть случайный документ мастеров")
    public KssDocumentPage clickWizardsDocument() {
        clickDocumentFromMyFavoritesMenuByType("wizards");
        return redirectTo(KssDocumentPage.class);
    }

    private void clickDocumentFromMyFavoritesMenuByType(String type) {
        WebElement myFavorites = waitForVisibilityOfElementLocatedBy(By.cssSelector("[class*='bookmarks-content']"), "Рубрикатор избранного не найден");
        waitForTextToBePresentIn(myFavorites);
        List<WebElement> documentByTypeList = myFavorites.findElements(By.cssSelector("[class*='b-ico_content_" + type + "']"));
        if (!documentByTypeList.isEmpty()) {
            WebElement randomDocument = getRandomElementInList(documentByTypeList);
            scrollIntoView(randomDocument);
            getParentElement(randomDocument).click();
        } else {
            setPostponedTestFail("В меню 'Мое избранное' Отсутствует необходимый тип документа");
        }
    }

    public KssSearchResultPage checkErrataInSearchQuery(String queryTrue, String queryFalse) {
        getHelper(SearchResultHelper.class).checkErrataInSearchQuery(queryTrue, queryFalse);
        return redirectTo(KssSearchResultPage.class);
    }

    public KssSearchResultPage clickNoFixLink() {
        getHelper(SearchResultHelper.class).clickNoFixLink();
        return redirectTo(KssSearchResultPage.class);
    }

    public KssSearchResultPage checkSearchResultIsNotPresent() {
        getHelper(SearchResultHelper.class).checkSearchResultIsNotPresent();
        return redirectTo(KssSearchResultPage.class);
    }

    public KssSearchResultPage checkKeyboardLayoutInSearchQuery(String queryTrue, String queryFalse) {
        getHelper(SearchResultHelper.class).checkKeyboardLayoutInSearchQuery(queryTrue, queryFalse);
        return redirectTo(KssSearchResultPage.class);
    }

    public KssSearchResultPage checkErrataInSearchQueryAndFilter(String queryTrue, String queryFalse) {
        getHelper(SearchResultHelper.class).checkErrataInSearchQueryAndFilter(queryTrue, queryFalse);
        return redirectTo(KssSearchResultPage.class);
    }

    public KssSearchResultPage checkErrataInSearchQuerySwitchSection(String queryTrue, String queryFalse) {
        getHelper(SearchResultHelper.class).checkErrataInSearchQuerySwitchSection(queryTrue, queryFalse);
        return redirectTo(KssSearchResultPage.class);
    }

    @Step("Проверяется шапка неавторизованного пользователя")
    public P clickMoreButtonOnMainPanel() {
        WebElement moreButton = findElementByNoThrow(By.cssSelector("#header #more"));
        moreButton.click();
        return (P) this;
    }

    public P checkPopupPredemoCheckBoxSubscribe() {
        getHelper(PredemoPopup.class).checkCheckBoxSubscribe("Подписаться на профессиональные новости");
        return (P) this;
    }

    public P checkPopupPredemoPhotoBackground() {
        getHelper(PredemoPopup.class).checkBackgroundPhoto("shatrova");
        return (P) this;
    }

    public P checkPopupPredemoLogo() {
        getHelper(PredemoPopup.class).checkBackgroundLogo("kss/logo");
        return (P) this;
    }
}
