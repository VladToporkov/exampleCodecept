package com.actionmedia.pages.fss;

import com.actionmedia.autotest.selenium.annotations.Wait;
import com.actionmedia.autotest.selenium.context.AbstractPage;
import com.actionmedia.autotest.selenium.elements.TextField;
import com.actionmedia.base.BasePage;
import com.actionmedia.components.Link;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.components.popups.PredemoPopup;
import com.actionmedia.pages.ExtendedSearchForm;
import com.actionmedia.pages.LoginPage;
import com.actionmedia.pages.RightPanel;
import com.actionmedia.pages.helpers.DocumentHelper;
import com.actionmedia.pages.helpers.SearchResultHelper;
import com.actionmedia.pages.interfaces.ISystemBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.By.cssSelector;

@Component
public class FssBasePage<P extends BasePage> extends BasePage<P> implements ISystemBasePage {

    public static final String DOCUMENT_URL = "document.url";
    public static final String RUBRICATOR_SECTION = "rubricator.section";
    public static final String ITEM_NAME = "item.name";
    public static final String QUERY = "query";
    private RightPanel rightPanel;
    protected ExtendedSearchForm extendedSearchForm;

    @Override
    public void handleRedirect() {
        super.handleRedirect();
        rightPanel = getHelper(RightPanel.class, this);
        extendedSearchForm = getHelper(ExtendedSearchForm.class, this);
    }

    @FindBy(id = "search_find")
    protected WebElement searchButton;

    @FindBy(id = "search-input")
    @Wait
    protected TextField searchBox;

    @FindBy(id = "search-clear")
    @Wait
    protected WebElement clearSearchBoxButton;

    @FindBy(id = "show_expanded_search")
    @Wait
    protected WebElement extendedFormButton;

    @FindBy(id = "button_search_extended")
    @Wait
    private WebElement extendedSearchButton;

    public FssBasePage logout() {
        logoutBase();
        return redirectTo(FssBasePage.class);
    }

    private <T extends AbstractPage> T clickPortalTab(final MainMenuButtons portalButton, final Class<T> requiredPage) {
        scrollToStart();
        WebElement mainMenu = waitForPresenceOfElementLocatedBy(By.id("main-menu"));
        WebElement activeTab = findElementByNoThrow(mainMenu, By.cssSelector(".btn_state_active"));
        if ((activeTab != null && !activeTab.getText().equals(portalButton.getName())) || activeTab == null) {
            WebElement portalButtonWebElement = mainMenu.findElement(portalButton.getButtonLocator());
            portalButtonWebElement.click();
        }
        report("Страница '" + portalButton.getName() + "' открыта");
        if (portalButton.equals(MainMenuButtons.FSS_LAW_BASE)){
            WebElement closeExtendedCloseButton = findElementByNoThrow(By.cssSelector(".search-extended [title='Закрыть']"));
            if (closeExtendedCloseButton != null){
                closeExtendedCloseButton.click();
                waitForReloadingPage();
            }
        }
        return redirectTo(requiredPage);
    }

    @Step("Открыть главную страницу")
    public FssMainPage navigateToMainPage() {
        WebElement logo = waitForPresenceOfElementLocatedBy(cssSelector(".b-logo"));
        logo.click();
        return redirectTo(FssMainPage.class);
    }

    @Step("Открыть страницу 'Решения'")
    public FssSolutionsPage navigateToSolutionsPage() {
        return clickPortalTab(MainMenuButtons.FSS_SOLUTIONS, FssSolutionsPage.class);
    }

    @Step("Открыть страницу 'Правовая база'")
    public FssLawBasePage navigateToLawBasePage() {
        return clickPortalTab(MainMenuButtons.FSS_LAW_BASE, FssLawBasePage.class);
    }

    @Step("Открыть страницу 'Формы'")
    public FssFormsPage navigateToFormsPage() {
        return clickPortalTab(MainMenuButtons.FSS_FORMS, FssFormsPage.class);
    }

    @Step("Открыть страницу 'Справочники'")
    public FssDictionaryPage navigateToDictionaryPage() {
        return clickPortalTab(MainMenuButtons.FSS_DICTIONARY, FssDictionaryPage.class);
    }

    @Step("Открыть страницу 'Библиотека'")
    public FssMagazinesPage navigateToMagazinesPage() {
        return clickPortalTab(MainMenuButtons.LIBRARY, FssMagazinesPage.class);
    }

    @Step("Открыть страницу 'Видео'")
    public FssVideosPage navigateToVideoPage() {
        return clickPortalTab(MainMenuButtons.FSS_VIDEO, FssVideosPage.class);
    }

    @Step("Открыть страницу 'Сервисы'")
    public FssServicesPage navigateToServicesPage() {
        return clickPortalTab(MainMenuButtons.FSS_SERVICES, FssServicesPage.class);
    }

    @Step("Открыть Личную страницу")
    public FssPersonalCabinetPage navigateToPersonalCabinetPage() {
        WebElement customerLink = waitForVisibilityOfElementLocatedBy(By.id("user-enter"));
        customerLink.click();
        return redirectTo(FssPersonalCabinetPage.class);
    }


    @Step("Открыть страницу 'Промо'")
    public FssPromoPage navigateToPromoPage() {
        clickAboutSystem();
        return redirectTo(FssPromoPage.class);
    }

    @Step("Проверка выбранного пункта меню")
    public P checkCurrentItemIsSelected(MainMenuButtons mainMenuButton) {
        String actualItemName;
        actualItemName = waitForPresenceOfElementLocatedBy(cssSelector(".btn_state_active"), "Не один раздел не выбран в главном меню").getText();
        postponedAssertEquals(actualItemName.toLowerCase(), mainMenuButton.getName().toLowerCase(), "Выбран неправильный раздел в главном меню");
        return (P) this;
    }

    @Step("Открыть страницу 'Активация подписки'")
    public FssBasePage navigateToActivatePage() {
        clickActivate();
        return redirectTo(FssBasePage.class);
    }

    @Step("Проверяется что открыта нужная ссылка")
    public P checkActivateLink() {
        postponedAssertTrue(getCurrentUrl().contains("activate-code"), "Ссылка должна содержать строку activate-code, ссылка: " + getCurrentUrl());
        return (P) this;
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
    public FssBasePage navigateToFssLoginPage() {
        waitForPresenceOfElementLocatedBy(By.cssSelector(".btn__in")).click();
        return redirectTo(FssBasePage.class);
    }

    @Step("Проверка инфо пользователя")
    public P checkCustomerInfoPage() {
        postponedAssertTrue(getCurrentUrl().contains("#/customer/"), "Ссылка должна содержать customer info, ссылка: " + getCurrentUrl());
        return (P) this;
    }

    @Step("Проверка страницы промо")
    public P checkPromoPage() {
        postponedAssertTrue(getCurrentUrl().contains("about"), "Ссылка должна содержать /about/, ссылка: " + getCurrentUrl());
        return (P) this;
    }

    @Step("Проверяется что не один элемент в главном меню не выбран")
    protected void checkItemIsNotSelected() {
        WebElement mainMenu = waitForPresenceOfElementLocatedBy(By.id("main-menu"), "Не найдено главное меню");
        WebElement activeItem = findElementByNoThrow(mainMenu, cssSelector(".selected"));
        postponedAssertNull(activeItem, "Один из элементов в главном меню выбран");
    }

    @Step("Открыть рубрикатор")
    public FssRubricator clickRubricatorButtonFss() {
        waitForPresenceOfElementLocatedBy(cssSelector(".rubricator-btn"), "Не найден рубрикатор").click();
        waitForVisibilityOfElementLocatedBy(By.id("rubricator"));
        return redirectTo(FssRubricator.class);
    }

    @Step("Открыть случайный раздел в рубрикаторе")
    public FssRubricator clickRandomSectionInRubricator() {
        List<WebElement> sectionsList = getRubricatorSections();
        WebElement randomSection = getRandomRubricatorSection(sectionsList);
        report("Открывается " + randomSection.getText());
        setParameter(RUBRICATOR_SECTION, randomSection.getText());
        randomSection.findElement(By.tagName("a")).click();
        waitForVisibilityOfElementLocatedBy(By.id("rubricator"));
        return redirectTo(FssRubricator.class);
    }

    @Step("Открыть первый раздел в рубрикаторе")
    public FssRubricator clickFirstSectionInRubricator() {
        List<WebElement> sectionsList = getRubricatorSections();
        WebElement firstSection = sectionsList.get(0);
        report("Открывается " + firstSection.getText());
        setParameter(RUBRICATOR_SECTION, firstSection.getText());
        firstSection.findElement(By.tagName("a")).click();
        waitForVisibilityOfElementLocatedBy(By.id("rubricator"));
        return redirectTo(FssRubricator.class);
    }

    @Step("Проверяется что рубрикатор не отображается")
    public FssBasePage checkRubricatorIsClosed() {
        WebElement content = waitForVisibilityOfElementLocatedBy(cssSelector(".m-wrapper"));
        WebElement rubricator = findElementByNoThrow(content, By.id("rubricator"));
        postponedAssertFalse(rubricator.isDisplayed(), "Рубрикатор отображается");
        return this;
    }

    @Step("Проверяется что поисковые подсказки с переходом отображаются")
    public P checkHintsWithJumpIsPresent() {
        waitFewSecond(getTimeout() * 10);
        WebElement tips = waitForVisibilityOfElementLocatedBy(cssSelector(".search_tips"), "Выпадающие поисковые подсказки не найдены");
        List<WebElement> hintsWithJump = tips.findElements(cssSelector(".link-type"));
        postponedAssertFalse(hintsWithJump.isEmpty(), "Поисковые подсказки с прямым переходом не найдены");
        return (P) this;
    }

    @Step("Проверяется что поисковые подсказки отображаются")
    public P checkHintsIsPresent() {
        waitFewSecond(getTimeout() * 10);
        WebElement tips = waitForVisibilityOfElementLocatedBy(cssSelector(".search_tips"), "Выпадающие поисковые подсказки не найдены");
        List<WebElement> hints = tips.findElements(cssSelector(".search-type"));
        postponedAssertFalse(hints.isEmpty(), "Поисковые подсказки с переходом не найдены");
        return (P) this;
    }

    @Step("Поверяется что форма расширенного поиска отображается")
    public P checkExtendedSearchFormsIsPresent() {
        WebElement searchForm = waitForVisibilityOfElementLocatedBy(By.id("form-search"));
        postponedAssertTrue(searchForm.getAttribute("class").contains("expanded"), "Форма расширенного поиска не отображается");
        return (P) this;
    }

    @Step("Проверяется что кнопка 'Найти' работает только при наличии запроса в строке")
    public P checkSearchResultPageIsNotOpened() {
        WebElement content = getPage();
        WebElement searchResult = findElementByNoThrow(content, cssSelector(".b-search"));
        postponedAssertNull(searchResult, "Страница с результатами поиска отображается");
        return (P) this;
    }

    public P inputRegionInExtendedByName(String regionName) {
        WebElement form = waitForVisibilityOfElementLocatedBy(By.id("form-search"));
        waitForTextToBePresentIn(form, "Поиск");
        WebElement region = form.findElement(By.id("region_list"));
        region.findElement(By.xpath("//li[text()='" + regionName + "']")).click();
        return (P) this;
    }

    public P inputNumberDocument(String numberDocument) {
        WebElement form = waitForVisibilityOfElementLocatedBy(By.id("form-search"));
        waitForTextToBePresentIn(form, "Поиск");
        TextField number = getWebElementWrapper(form.findElement(By.id("search_number"))).getTextField();
        number.clearAndType(numberDocument);
        return (P) this;
    }

    public P inputStartDateDocument(String startDate) {
        WebElement form = waitForVisibilityOfElementLocatedBy(By.id("form-search"));
        waitForTextToBePresentIn(form, "Поиск");
        TextField number = getWebElementWrapper(form.findElement(By.id("sd_date_start"))).getTextField();
        number.clearAndType(startDate);
        return (P) this;
    }

    public P inputEndDateDocument(String endDate) {
        WebElement form = waitForVisibilityOfElementLocatedBy(By.id("form-search"));
        waitForTextToBePresentIn(form, "Поиск");
        TextField number = getWebElementWrapper(form.findElement(By.id("sd_date_end"))).getTextField();
        number.clearAndType(endDate);
        return (P) this;
    }

    @Step("Нажать кнопку 'Очистить поисковую строку'")
    public P clickClearSearchBoxButton() {
        clearSearchBoxButton.click();
        return (P) this;
    }

    @Step("Нажать кнопку 'Найти'")
    public FssSearchResultPage clickSearchButtonFss() {
        searchButton.click();
        return redirectTo(FssSearchResultPage.class);
    }

    @Step("Нажать кнопку 'Найти' с пустой поисковой строкой")
    public P clickSearchButtonWithEmptySearchBox() {
        searchBox.clear();
        searchButton.click();
        return (P) this;
    }

    @Step("Открыть форму расширенного поиска")
    public P clickExtendedFormButton() {
        extendedFormButton.click();
        WebElement form = waitForVisibilityOfElementLocatedBy(By.id("form-search"));
        waitForTextToBePresentIn(form);
        return (P) this;
    }

    @Step("Нажать кнопку Найти в форме расширенного поиска")
    public FssSearchResultPage clickExtendedSearchButton() {
        extendedSearchButton.click();
        return redirectTo(FssSearchResultPage.class);
    }

    @Step("Открыть подсказку с прямым переходом")
    public FssSearchResultPage clickHintWithJump() {
        waitFewSecond(getTimeout() * 10);
        WebElement tips = waitForVisibilityOfElementLocatedBy(cssSelector(".search_tips"));
        List<WebElement> hintsWithJump = tips.findElements(cssSelector(".link-type"));
        WebElement randomHintWithJump = getRandomElementInList(hintsWithJump);
        setParameter(QUERY, randomHintWithJump.getAttribute("data-text"));
        setParameter(SearchResultHelper.DOCUMENT_URL, randomHintWithJump.getAttribute("data-hash"));
        mouseClick(randomHintWithJump.findElement(By.tagName("a")));
        return redirectTo(FssSearchResultPage.class);
    }

    @Step("Открыть подсказку с переходом")
    public FssSearchResultPage clickHint() {
        waitFewSecond(getTimeout() * 10);
        WebElement tips = waitForVisibilityOfElementLocatedBy(cssSelector(".search_tips"));
        List<WebElement> hintsWithJump = tips.findElements(cssSelector(".search-type"));
        WebElement randomHint = getRandomElementInList(hintsWithJump);
        setParameter(QUERY, randomHint.getAttribute("data-text"));
        mouseClick(randomHint.findElement(By.tagName("a")));
        return redirectTo(FssSearchResultPage.class);
    }

    private List<WebElement> getRubricatorSections() {
        List<WebElement> rubricatorSections = new ArrayList<WebElement>();
        List<WebElement> sectionsList = sidebarElement.findElement(cssSelector(".b-menu")).findElements(By.tagName("li"));
        for (WebElement section : sectionsList) {
            if (section.isDisplayed()) {
                if (getParentElement(section).getAttribute("class").contains("small")) {
                    rubricatorSections.add(section);
                }
            }
        }
        return rubricatorSections;
    }

    private WebElement getRandomRubricatorSection(List<WebElement> sections) {
        List<WebElement> notSelectedSectionsList = new ArrayList<WebElement>();
        for (WebElement section : sections) {
            if (section.findElement(By.tagName("a")).getAttribute("data-tax-planning") != null) {
                continue;
            }
            if (section.getAttribute("class") == null) {
                notSelectedSectionsList.add(section);
            } else if (!section.getAttribute("class").contains("selected")) {
                notSelectedSectionsList.add(section);
            }
        }
        return getRandomElementInList(notSelectedSectionsList);
    }

    public List<Link> getLinkList(List<WebElement> linksElementList) {
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement element : linksElementList) {
            String url = element.getAttribute("href");
            Link link = new Link(url);
            linkList.add(link);
        }
        return linkList;
    }

//    @Override
//    public P checkActualDocumentCheckBoxIsSelected() {
//        extendedSearchForm.checkActualDocumentCheckBoxIsSelected();
//        return (P) this;
//    }
//
//    @Override
//    public P checkActualDocumentCheckBoxIsNotSelected() {
//        extendedSearchForm.checkActualDocumentCheckBoxIsNotSelected();
//        return (P) this;
//    }
//
//    @Override
//    public P checkOnlyInTitlesCheckBoxIsSelected() {
//        extendedSearchForm.checkOnlyInTitlesCheckBoxIsSelected();
//        return (P) this;
//    }
//
//    @Override
//    public P checkOnlyInTitlesCheckBoxIsNotSelected() {
//        extendedSearchForm.checkOnlyInTitlesCheckBoxIsNotSelected();
//        return (P) this;
//    }
//
//    @Override
//    public P checkOnlyInTitlesCheckBoxIsEnabled() {
//        extendedSearchForm.checkOnlyInTitlesCheckBoxIsEnabled();
//        return (P) this;
//    }
//
//    @Override
//    public P checkOnlyInTitlesCheckBoxIsDisabled() {
//        extendedSearchForm.checkOnlyInTitlesCheckBoxIsDisabled();
//        return (P) this;
//    }
//
//    @Override
//    public P checkSearchExtendedButtonsIsEnabled() {
//        extendedSearchForm.checkSearchExtendedButtonsIsEnabled();
//        return (P) this;
//    }
//
//    @Override
//    public P checkSearchExtendedButtonsIsDisabled() {
//        extendedSearchForm.checkSearchExtendedButtonsIsDisabled();
//        return (P) this;
//    }
//
//    @Override
//    public P checkValuesInFieldIsNotChanged() {
//        extendedSearchForm.checkValuesInFieldIsNotChanged();
//        return (P) this;
//    }
//
//    @Override
//    public P checkSearchBodyResultText() {
//        extendedSearchForm.checkSearchBodyResultText();
//        return (P) this;
//    }
//
//    @Override
//    public P checkAllFieldsDefaultState() {
//        extendedSearchForm.checkAllFieldsDefaultState();
//        return (P) this;
//    }
//
//    @Override
//    public P clearAllFields() {
//        extendedSearchForm.clearAllFields();
//        return (P) this;
//    }
//
//    @Override
//    public P clickClearFields() {
//        extendedSearchForm.clickClearFields();
//        return (P) this;
//    }
//
//    @Override
//    public P inputTextInSearchField(String text) {
//        extendedSearchForm.inputTextInSearchField(text);
//        return (P) this;
//    }
//
//    @Override
//    public P inputTextInNumberField(String text) {
//        extendedSearchForm.inputTextInNumberField(text);
//        return (P) this;
//    }
//
//    @Override
//    public P inputTextInStartDateField(String text) {
//        extendedSearchForm.inputTextInStartDateField(text);
//        return (P) this;
//    }
//
//    @Override
//    public P inputTextInEndDateField(String text) {
//        extendedSearchForm.inputTextInEndDateField(text);
//        return (P) this;
//    }
//
//    @Override
//    public P selectTypeByName(String typeName) {
//        extendedSearchForm.selectTypeByName(typeName);
//        return (P) this;
//    }
//
//    @Override
//    public P selectRandomType() {
//        extendedSearchForm.selectRandomType();
//        return (P) this;
//    }
//
//    @Override
//    public P selectLobbyByName(String lobbyName) {
//        extendedSearchForm.selectLobbyByName(lobbyName);
//        return (P) this;
//    }
//
//    @Override
//    public P selectRandomLobby() {
//        extendedSearchForm.selectRandomLobby();
//        return (P) this;
//    }
//
//    @Override
//    public P selectRegionByName(String regionName) {
//        extendedSearchForm.selectRegionByName(regionName);
//        return (P) this;
//    }
//
//    @Override
//    public P selectRandomRegion() {
//        extendedSearchForm.selectRandomRegion();
//        return (P) this;
//    }
//
//    @Override
//    public P selectActualDocumentCheckBox() {
//        extendedSearchForm.selectActualDocumentCheckBox();
//        return (P) this;
//    }
//
//    @Override
//    public P deSelectActualDocumentCheckBox() {
//        extendedSearchForm.deSelectActualDocumentCheckBox();
//        return (P) this;
//    }
//
//    @Override
//    public P selectOnlyInTitlesCheckBox() {
//        extendedSearchForm.selectOnlyInTitlesCheckBox();
//        return (P) this;
//    }
//
//    @Override
//    public P deSelectOnlyInTitlesCheckBox() {
//        extendedSearchForm.deSelectOnlyInTitlesCheckBox();
//        return (P) this;
//    }

    protected WebElement getPage() {
        return waitForVisibilityOfElementLocatedBy(cssSelector(".page"), "Страница не найдена");
    }

    protected WebElement getCollapsedRightPanel() {
        return waitForVisibilityOfElementLocatedBy(By.id("aside"), "Правая панель не найдена");
    }

    @Step("Нажать кнопку Найти")
    public FssSearchResultPage clickSearchButtonAndNavigateToSearchResultPage() {
//        WebElement searchButton = findElementBy(cssSelector(".btn_viewtype_search-submit"));
//        searchButton.click();
//        waitForReloadingPage();
        clickSearchButton();
        return redirectTo(FssSearchResultPage.class);
    }

    @Step("Открыть рубрикатор")
    public FssRubricator clickRubricatorButton() {
        waitForPresenceOfElementLocatedBy(By.id("rubricator-btn"), "Не найден рубрикатор").click();
        waitForVisibilityOfElementLocatedBy(By.id("rubricator"), "Рубрикатор не найден");
        return redirectTo(FssRubricator.class);
    }

    @Step("Открыть страницу Личного кабинета")
    public FssProfilePage clickProfileLink() {
        clickProfileLinkBase();
        return redirectTo(FssProfilePage.class);
    }

    @Step("Открыть документ с заданным урл")
    public FssDocumentPage openDocumentByModuleIdAndDocId(String partialDocUrl) {
        openDocumentByUrlWithWaiting(partialDocUrl);
        return redirectTo(FssDocumentPage.class);
    }

    @Override
    public FssSolutionsPage navigateToRecomendPage() {
        return clickPortalTab(MainMenuButtons.FSS_SOLUTIONS, FssSolutionsPage.class);
    }

    @Step("Открыть раздел 'Новости'")
    public FssNewsPage clicNewsPageLink() {
        clickNewsPageBase();
        return redirectTo(FssNewsPage.class);
    }

    public FssSearchResultPage checkErrataInSearchQuery(String queryTrue, String queryFalse) {
        getHelper(SearchResultHelper.class).checkErrataInSearchQuery(queryTrue, queryFalse);
        return redirectTo(FssSearchResultPage.class);
    }

    public FssSearchResultPage clickNoFixLink() {
        getHelper(SearchResultHelper.class).clickNoFixLink();
        return redirectTo(FssSearchResultPage.class);
    }

    public FssSearchResultPage checkSearchResultIsNotPresent() {
        getHelper(SearchResultHelper.class).checkSearchResultIsNotPresent();
        return redirectTo(FssSearchResultPage.class);
    }

    public FssSearchResultPage checkKeyboardLayoutInSearchQuery(String queryTrue, String queryFalse) {
        getHelper(SearchResultHelper.class).checkKeyboardLayoutInSearchQuery(queryTrue, queryFalse);
        return redirectTo(FssSearchResultPage.class);
    }

    public FssSearchResultPage checkErrataInSearchQueryAndFilter(String queryTrue, String queryFalse) {
        getHelper(SearchResultHelper.class).checkErrataInSearchQueryAndFilter(queryTrue, queryFalse);
        return redirectTo(FssSearchResultPage.class);
    }

    public FssSearchResultPage checkErrataInSearchQuerySwitchSection(String queryTrue, String queryFalse) {
        getHelper(SearchResultHelper.class).checkErrataInSearchQuerySwitchSection(queryTrue, queryFalse);
        return redirectTo(FssSearchResultPage.class);
    }

    @Step("Открыть документ с заданным урл")
    public FssDocumentPage openDocumentByUrl(String documentUrl) {
        report("Открывается ссылка: " + documentUrl);
        openUrl(documentUrl);
        return redirectTo(FssDocumentPage.class);
    }


    @Step("Открыть заданный урл")
    public FssDocumentPage openByPartialUrl(String partialDocUrl) {
        String currentUrl = getCurrentUrl().split("#")[0];
        if (currentUrl.contains("update")) currentUrl = currentUrl.split("update")[0];
        String documentUrl = currentUrl + partialDocUrl;
        report("Открывается ссылка: " + documentUrl);
        openUrl(documentUrl);
        return redirectToWithoutWait(FssDocumentPage.class);
    }

    @Step("Проверяется что лого системы отображается в шапке сайта")
    public P checkLogoIsPresentOnRssPage() {
        WebElement logo = waitForPresenceOfElementLocatedBy(By.id("feedTitleImage"));
        postponedAssertNotNull(logo, "Лого системы не найдено");
        if (logo != null) {
            String logoImgSrc = logo.getAttribute("src");
            postponedAssertTrue(logoImgSrc.contains("rss-logo-fss.jpg"), "Неправильная картинка для лого системы");
        }
        return (P) this;
    }

    public FssDocumentPage checkVideoPlayerIsPresent() {
        getHelper(DocumentHelper.class).checkVideoPlayerIsPresent();
        return (FssDocumentPage) this;
    }

    public FssDocumentPage checkVideoTitleIsPresent() {
        getHelper(DocumentHelper.class).checkVideoTitleIsPresent();
        return (FssDocumentPage) this;
    }

    public FssDocumentPage checkVideoPartsArePresent() {
        getHelper(DocumentHelper.class).checkVideoPartsArePresent();
        return (FssDocumentPage) this;
    }

    public FssDocumentPage checkActivePartHasPlayButton() {
        getHelper(DocumentHelper.class).checkActivePartHasPlayButton();
        return (FssDocumentPage) this;
    }

    public FssDocumentPage checkAddToFavoritesButtonIsPresent() {
        getHelper(DocumentHelper.class).checkAddToFavoritesButtonIsPresent();
        return (FssDocumentPage) this;
    }

    @Step("Нажать кнопку Найти в форме дополнительных аттрибутах поиска")
    public FssSearchResultPage clickSearchExtendedButton() {
        extendedSearchForm.clickSearchExtendedButton();
        return redirectTo(FssSearchResultPage.class);
    }

    @Step("Переключиться на страницу 'Правовая база'")
    public FssLawBasePage switchToLawBasePage() {
        return redirectTo(FssLawBasePage.class);
    }

    @Step("Проверяется шапка неавторизованного пользователя")
    public P checkMainPanelNotAuthorized() {
        WebElement mainPanel = findElementByNoThrow(cssSelector(".header__in"));
        postponedAssertEquals(mainPanel.getCssValue("background-color"), "rgba(254, 153, 47, 1)", "Шапка не оранжевая: " + "rgba(254, 153, 47, 1), " +
                "а " + mainPanel.getCssValue("background-color"));
        WebElement userEnter = findElementByNoThrow(By.id("user-enter"));
        postponedAssertEquals(userEnter.getText(), "Вход и регистрация", "Ссылка имеет текст не Вход и регистрация, а " +
                userEnter.getText());
        return (P) this;
    }

    @Step("Проверяется минимальная шапка неавторизованного пользователя")
    public P checkMainPanelMiniStateNotAuthorized() {
        WebElement mainPanel = findElementByNoThrow(cssSelector(".header__in"));
        postponedAssertEquals(mainPanel.getCssValue("background-color"), "rgba(48, 162, 159, 1)", "Шапка не голубая: " + "rgba(48, 162, 159, 1), " +
                "а " + mainPanel.getCssValue("background-color"));
        WebElement menu = findElementByNoThrow(By.id("main-menu"));
        postponedAssertFalse(menu.isDisplayed(), "Меню отображено в минимальной плашке");
        return (P) this;
    }

    @Step("Проверяется минимальная шапка после нажатия на кнопку Еще для неавторизованного пользователя")
    public P checkMainPanelMiniStateAfterClickOnMoreButtonForNotAuthorized() {
        WebElement mainPanel = findElementByNoThrow(cssSelector(".header__in"));
        postponedAssertEquals(mainPanel.getCssValue("background-color"), "rgba(48, 162, 159, 1)", "Шапка не голубая: " + "rgba(48, 162, 159, 1), " +
                "а " + mainPanel.getCssValue("background-color"));
        WebElement menu = findElementByNoThrow(cssSelector(".page_state_extended"));
        postponedAssertTrue(menu.isDisplayed(), "Меню отображено в минимальной плашке");
        return (P) this;
    }

    @Step("Проверяется шапка неавторизованного пользователя")
    public P clickButtonMoreOnMainPanel() {
        WebElement moreButton = findElementByNoThrow(cssSelector(".ico_content_more"));
        moreButton.click();
        return (P) this;
    }

    @Step("Проверяется шапка неавторизованного пользователя")
    public P checkMainPanelAuthorized() {
        WebElement mainPanel = findElementByNoThrow(cssSelector(".header__in"));
        postponedAssertEquals(mainPanel.getCssValue("background-color"), "rgba(254, 153, 47, 1)", "Шапка не оранжевая: " + "rgba(254, 153, 47, 1), " +
                "а " + mainPanel.getCssValue("background-color"));
        WebElement userEnter = findElementByNoThrow(By.id("user-enter"));
        postponedAssertFalse(userEnter.getText().contains("Вход и регистрация"), "Пользователь не авторизован!");
        return (P) this;
    }

    @Step("Проверяется шапка неавторизованного пользователя")
    public P checkMainPanelMiniStateAuthorized() {
        WebElement mainPanel = findElementByNoThrow(cssSelector(".header__in"));
        postponedAssertEquals(mainPanel.getCssValue("background-color"), "rgba(48, 162, 159, 1)", "Шапка не голубая: " + "rgba(48, 162, 159, 1), " +
                "а " + mainPanel.getCssValue("background-color"));
        WebElement userEnter = findElementByNoThrow(By.id("user-enter"));
        postponedAssertFalse(userEnter.getText().contains("Вход и регистрация"), "Пользователь не авторизован!");
        return (P) this;
    }

    @Step("Проверяется шапка неавторизованного пользователя")
    public P clickMoreButtonOnMainPanel() {
        WebElement moreButton = findElementByNoThrow(By.cssSelector("#header #more"));
        moreButton.click();
        return (P) this;
    }

    public P checkPopupPredemoCheckBoxSubscribe() {
        getHelper(PredemoPopup.class).checkCheckBoxSubscribe("Подписаться на финансовые новости");
        return (P) this;
    }

    public P checkPopupPredemoPhotoBackground() {
        getHelper(PredemoPopup.class).checkBackgroundPhoto("fss/editor-in-chief");
        return (P) this;
    }

    public P checkPopupPredemoLogo() {
        getHelper(PredemoPopup.class).checkBackgroundLogo("fss/logo-black");
        return (P) this;
    }
}
