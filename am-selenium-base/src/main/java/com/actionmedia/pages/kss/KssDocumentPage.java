package com.actionmedia.pages.kss;

import com.actionmedia.components.info.AttachmentsInfobar;
import com.actionmedia.components.popups.NotepadPopup;
import com.actionmedia.pages.interfaces.IDocumentPage;
import com.actionmedia.pages.interfaces.ISystemBasePage;
import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.helpers.DocumentHelper;
import com.actionmedia.pages.helpers.SearchResultHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 15.10.13
 * Time: 11:55
 */
@Component
public class KssDocumentPage extends KssBasePage<KssDocumentPage> implements IDocumentPage {

    public KssDocumentPage checkPrintButtonIsPresent() {
        getHelper(DocumentHelper.class).checkPrintButtonIsPresent();
        return this;
    }

    public KssDocumentPage checkPrintButtonInKodeksIsPresent() {
        getHelper(DocumentHelper.class).checkPrintButtonInKodeksIsPresent();
        return this;
    }

    public KssDocumentPage checkWordButtonIsPresent() {
        getHelper(DocumentHelper.class).checkWordButtonIsPresent();
        return this;
    }

    public KssDocumentPage checkWordButtonInKodeksIsPresent() {
        getHelper(DocumentHelper.class).checkWordButtonInKodeksIsPresent();
        return this;
    }

    public KssDocumentPage checkMailButtonIsPresent() {
        getHelper(DocumentHelper.class).checkMailButtonIsPresent();
        return this;
    }

    public KssDocumentPage checkMailButtonInKodeksIsPresent() {
        getHelper(DocumentHelper.class).checkMailButtonInKodeksIsPresent();
        return this;
    }

    public KssDocumentPage checkDownloadFormButtonIsPresent() {
        getHelper(DocumentHelper.class).checkDownloadButtonIsPresent();
        return this;
    }

    public KssDocumentPage checkDownloadExampleButtonIsPresent() {
        getHelper(DocumentHelper.class).checkDownloadExampleButtonIsPresent();
        return this;
    }

    public KssDocumentPage checkMailFormIsPresent() {
        getHelper(DocumentHelper.class).checkMyFavoritesRubricatorButtonIsPresent();
        return this;
    }

    public KssDocumentPage checkMailFormIsNotPresent() {
        getHelper(DocumentHelper.class).checkMailFormIsNotPresent();
        return this;
    }

    public KssDocumentPage inputEmailInMailForm(String email) {
        getHelper(DocumentHelper.class).inputEmailInMailForm(email);
        return this;
    }

    public KssDocumentPage clickSendInMailForm() {
        getHelper(DocumentHelper.class).clickSendInMailForm();
        return this;
    }

    public KssDocumentPage checkErrorMessageInMailForm(String expectedErrorMessaege) {
        getHelper(DocumentHelper.class).checkErrorMessageInMailForm(expectedErrorMessaege);
        return this;
    }

    public KssDocumentPage checkInCut() {
        getHelper(DocumentHelper.class).checkInCut();
        return this;
    }

    public KssDocumentPage checkHelpWidgetIsPresent() {
        getHelper(DocumentHelper.class).checkHelpWidgetIsPresent();
        return this;
    }

    public KssDocumentPage checkApplicationsWidgetIsPresent() {
        getHelper(DocumentHelper.class).checkApplicationsWidgetIsPresent();
        return this;
    }

    public KssDocumentPage checkInfoBarWidgetIsPresent() {
        getHelper(DocumentHelper.class).checkInfoBarWidget();
        return this;
    }

    public KssDocumentPage checkInfoBarWidgetWork() {
        getHelper(DocumentHelper.class).checkInfoBarWidgetWork();
        return this;
    }

    public KssDocumentPage checkChangeHistoryWidget() {
        getHelper(DocumentHelper.class).checkChangeHistoryWidget();
        return this;
    }

    public KssDocumentPage checkScrolling() {
        getHelper(DocumentHelper.class).checkScrolling();
        return this;
    }

    public KssDocumentPage checkStickyHeader() {
        getHelper(DocumentHelper.class).checkStickyHeaderScrolling();
        return this;
    }

    public KssDocumentPage clickMailButton() {
        getHelper(DocumentHelper.class).clickMailButton();
        return this;
    }

    public KssDocumentPage clickMailButtonInKodeks() {
        getHelper(DocumentHelper.class).clickMailButtonInKodeks();
        return this;
    }

    public KssDocumentPage scrollAllDocument() {
        getHelper(DocumentHelper.class).scrollAllDocument();
        return this;
    }

    public KssDocumentPage checkTableOfContents() {
        getHelper(DocumentHelper.class).checkTableOfContents();
        return this;
    }

    public KssDocumentPage checkReferencesForChapter() {
        getHelper(DocumentHelper.class).checkReferencesForChapter();
        return this;
    }

    public KssDocumentPage checkReferencesForArticle() {
        getHelper(DocumentHelper.class).checkReferencesForArticle();
        return this;
    }

    public KssDocumentPage checkReferencesForParagraph() {
        getHelper(DocumentHelper.class).checkReferencesForParagraph();
        return this;
    }

    public KssDocumentPage checkLinksFromNotebookForChapter() {
        getHelper(DocumentHelper.class).checkLinksFromNotebookForChapter();
        return this;
    }

    public KssDocumentPage checkLinksFromNotebookForArticle() {
        getHelper(DocumentHelper.class).checkLinksFromNotebookForArticle();
        return this;
    }

    public KssDocumentPage checkLinksFromNotebookForParagraph() {
        getHelper(DocumentHelper.class).checkLinksFromNotebookForParagraph();
        return this;
    }

    public KssDocumentPage checkEditLinksForChapter() {
        getHelper(DocumentHelper.class).checkEditLinksForChapter();
        return this;
    }

    public KssDocumentPage checkEditLinksForArticle() {
        getHelper(DocumentHelper.class).checkEditLinksForArticle();
        return this;
    }

    public KssDocumentPage checkEditLinksForParagraph() {
        getHelper(DocumentHelper.class).checkEditLinksForParagraph();
        return this;
    }

    public KssDocumentPage checkDocumentVersionIsPresent() {
        getHelper(DocumentHelper.class).checkDocumentVersionIsPresent();
        return this;
    }

    public KssDocumentPage checkVideoVersionIsPresent() {
        getHelper(DocumentHelper.class).checkVideoVersionIsPresent();
        return this;
    }

    public KssDocumentPage checkFormsPreview() {
        getHelper(DocumentHelper.class).checkFormsPreview();
        return this;
    }

    public KssDocumentPage checkExpiredWarningIsPresent() {
        getHelper(DocumentHelper.class).checkExpiredWarningIsPresent();
        return this;
    }

    public KssDocumentPage checkFutureWarningIsPresent() {
        getHelper(DocumentHelper.class).checkFutureWarningIsPresent();
        return this;
    }

    public KssDocumentPage checkActualVersionIsPresent() {
        getHelper(DocumentHelper.class).checkActualVersionIsPresent();
        return this;
    }

    public KssDocumentPage checkSearchInTextWidgetWork(boolean fullcheck) {
        getHelper(DocumentHelper.class).checkSearchInTextWidgetWork(fullcheck);
        return this;
    }

    public KssDocumentPage checkSoderIsPresent() {
        getHelper(DocumentHelper.class).checkSoderIsPresent();
        return this;
    }

    public KssDocumentPage checkMyFavoritesRubricatorButtonIsPresent() {
        getHelper(DocumentHelper.class).checkMyFavoritesRubricatorButtonIsPresent();
        return this;
    }

    public KssDocumentPage checkAddToFavoritesButtonsForDocumentArePresent() {
        getHelper(DocumentHelper.class).checkAddToFavoritesButtonsForDocumentArePresent();
        return this;
    }

    public KssDocumentPage checkAddToFavoritesButtonForMagazinesIsPresent() {
        getHelper(DocumentHelper.class).checkAddToFavoritesButtonForMagazinesIsPresent();
        return this;
    }

    public KssDocumentPage checkAddToFavoritesButtonIsPresent() {
        getHelper(DocumentHelper.class).checkAddToFavoritesButtonIsPresent();
        return this;
    }

    public KssDocumentPage checkAddToFavoritesButtonIsHighlighted() {
        getHelper(DocumentHelper.class).checkAddToFavoritesButtonIsHighlighted();
        return this;
    }

    public KssDocumentPage checkAddToFavoritesButtonForMagazinesIsHighlighted() {
        getHelper(DocumentHelper.class).checkAddToFavoritesButtonForMagazinesIsHighlighted();
        return this;
    }

    public KssDocumentPage checkAddToFavoritesButtonIsNotHighlighted() {
        getHelper(DocumentHelper.class).checkAddToFavoritesButtonIsNotHighlighted();
        return this;
    }

    public KssDocumentPage checkAddToFavoritesButtonForMagazinesIsNotHighlighted() {
        getHelper(DocumentHelper.class).checkAddToFavoritesButtonForMagazinesIsNotHighlighted();
        return this;
    }

    public KssDocumentPage checkAddedItemIsPresentInMyFavoritesMenu() {
        getHelper(DocumentHelper.class).checkAddedItemIsPresentInMyFavoritesMenu();
        return this;
    }

    public KssDocumentPage checkDeletedItemIsAbsentInMyFavoritesMenu() {
        getHelper(DocumentHelper.class).checkDeletedItemIsAbsentInMyFavoritesMenu();
        return this;
    }

    public KssDocumentPage checkListOfArticlesOnMainMagazinesPageArePresent() {
        getHelper(DocumentHelper.class).checkListOfArticlesOnMainMagazinesPageArePresent();
        return this;
    }

    public KssDocumentPage checkListOfArticlesOnMainBookPageArePresent() {
        getHelper(DocumentHelper.class).checkListOfArticlesOnMainBookPageArePresent();
        return this;
    }

    public KssSearchResultPage returnToSearchResultPage() {
        getHelper(DocumentHelper.class).returnToSearchResultPage();
        return redirectTo(KssSearchResultPage.class);
    }

    public KssDocumentPage clickRandomAddToFavoritesForKodeksButton() {
        getHelper(DocumentHelper.class).clickRandomAddToFavoritesForKodeksButton();
        return this;
    }

    public KssDocumentPage clickRandomAddToFavoritesForDocumentButton() {
        getHelper(DocumentHelper.class).clickRandomAddToFavoritesForDocumentButton();
        return this;
    }

    public KssDocumentPage clickRandomAddToFavoritesForMagazinesButton() {
        getHelper(DocumentHelper.class).clickRandomAddToFavoritesForMagazinesButton();
        return this;
    }

    public KssDocumentPage clickRandomAddToFavoritesButton() {
        getHelper(DocumentHelper.class).clickRandomAddToFavoritesButton();
        return this;
    }

    public KssDocumentPage checkCommentsArePresentOld() {
        getHelper(DocumentHelper.class).checkCommentsArePresentOld();
        return this;
    }

    public KssDocumentPage checkVideoPlayerIsPresent() {
        getHelper(DocumentHelper.class).checkVideoPlayerIsPresent();
        return this;
    }

    public KssDocumentPage checkNavigationButtonsForVideoArePresent() {
        getHelper(DocumentHelper.class).checkNavigationButtonsForVideoArePresent();
        return this;
    }

    public KssDocumentPage checkNavigationButtonsForBookArePresent() {
        getHelper(DocumentHelper.class).checkNavigationButtonsForBookArePresent();
        return this;
    }

    public KssDocumentPage checkVideoTitleIsPresent() {
        getHelper(DocumentHelper.class).checkVideoTitleIsPresent();
        return this;
    }

    public KssDocumentPage checkVideoPartTitleIsPresent() {
        getHelper(DocumentHelper.class).checkVideoPartTitleIsPresent();
        return this;
    }

    public KssDocumentPage checkVideoPartsArePresent() {
        getHelper(DocumentHelper.class).checkVideoPartsArePresent();
        return this;
    }

    public KssDocumentPage checkActivePartHasPlayButton() {
        getHelper(DocumentHelper.class).checkActivePartHasPlayButton();
        return this;
    }

    public KssDocumentPage checkTableOfContentsIsNotEmpty() {
        String bookUrl = String.valueOf(getParameter(KssMagazinesPage.BOOK_URL));
        getHelper(DocumentHelper.class).checkTableOfContentsIsNotEmpty(bookUrl);
        return this;
    }

    @Step("Проверяется что Шарики отображаются")
    public KssDocumentPage checkReferencesBallIsPresent() {
        WebElement document = waitForVisibilityOfElementLocatedBy(By.id("document-body"), "Документ не найден");
        List<WebElement> referencesBall = document.findElements(By.cssSelector(".btn_type_references"));
        postponedAssertFalse(referencesBall.isEmpty(), "Шарики не отображаются");
        return this;
    }

    public KssDocumentPage checkDocumentIsOpened() {
        getHelper(DocumentHelper.class).checkDocumentIsOpened();
        return this;
    }

    @Override
    public KssDocumentPage checkDownloadShowExamplesLinkIsNotPresent() {
        getHelper(DocumentHelper.class).checkDownloadShowExamplesLinkIsNotPresent();
        return this;
    }

    @Override
    public KssDocumentPage checkDownloadShowExampleLinkIsNotPresent() {
        getHelper(DocumentHelper.class).checkDownloadShowExampleLinkIsNotPresent();
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Ответы'")
    public KssDocumentPage checkSearchBoxIsPresentInDocument(String textInSearchBox) {
        checkSearchBoxIsPresent(textInSearchBox);
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются")
    public KssDocumentPage checkHintsIsPresentOnYellowPlate() {
        WebElement searchResult = waitForVisibilityOfElementLocatedBy(By.id("ui-id-1"), "Выпадающие поисковые подсказки не отображаются");
        checkHintsIsPresent(searchResult);
        return this;
    }

    @Step("Проверяется что кнопка 'Поиск по реквизитам' отображается")
    public KssDocumentPage checkExtendedSearchFormButtonIsPresent() {
        WebElement searchForm = waitForPresenceOfElementLocatedBy(By.id("search-form"));
        WebElement extendedButton = findElementByNoThrow(searchForm, By.id("search-button-extended"));

        assertNotNull(extendedButton, "Кнопка 'Поиск по реквизитам' не найдена");
        postponedAssertTrue(extendedButton.isDisplayed(), "кнопка 'Поиск по реквизитам' не отображается");
        return this;
    }

    @Step("Проверяется что кнопка 'Полистать' отображается")
    public KssDocumentPage checkBrowseButtonIsPresent() {
        WebElement header = getDocumentHeader();
        WebElement browserButton = findElementByNoThrow(header, By.cssSelector(".browse"));
        if (browserButton != null) {
            postponedAssertTrue(browserButton.isDisplayed(), "кнопка 'Полистать' не отображается");
            postponedAssertEquals(browserButton.getText(), "Полистать", "Неправильный текст кнопки 'Полистать'");
        }
        return this;
    }

    @Step("Проверяется что кнопка 'Сохранить' отображается")
    public KssDocumentPage checkSaveButtonIsPresent() {
        WebElement header = getDocumentHeader();
        WebElement browserButton = findElementByNoThrow(header, By.cssSelector(".js-export"));
        postponedAssertNotNull(browserButton, "Кнопка 'Сохранить' не найдена");
        postponedAssertTrue(browserButton.isDisplayed(), "кнопка 'Сохранить' не отображается");
        postponedAssertEquals(browserButton.getText(), "Сохранить", "Неправильный текст кнопки 'Сохранить'");
        return this;
    }

    @Step("Проверяется что кнопка 'Отправить' отображается")
    public KssDocumentPage checkSendButtonIsPresent() {
        WebElement header = getDocumentHeader();
        WebElement browserButton = findElementByNoThrow(header, By.cssSelector(".btn_content_mail"));
        postponedAssertNotNull(browserButton, "Кнопка 'Отправить' не найдена");
        postponedAssertTrue(browserButton.isDisplayed(), "кнопка 'Отправить' не отображается");
        postponedAssertEquals(browserButton.getText(), "Отправить", "Неправильный текст кнопки 'Отправить'");
        return this;
    }

    @Step("Проверяется что Меню навигации отображается")
    public KssDocumentPage checkNavigationButtonsForMagazinesArePresent() {
        getHelper(DocumentHelper.class).checkNavigationButtonsForMagazinesArePresent();
        return this;
    }

    @Step("Проверяется работа кнопки найти")
    public KssDocumentPage checkSearchButtonFunctionalityOnAnswerPage(String query) {
        setParameter(SearchResultHelper.HINT_TEXT, query);
        return clearSearchBox()
                .clickSearchButton()
                .checkAnswersTabIsSelected()
                .checkSearchResultIsNotPresentOnAnswersPage()

                .clearSearchBox()
                .inputTextInSearchBox(query)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnAnswersPageIsOpened()
                .navigateToAnswersPage()
                .clickRubricatorButton()
                .clickRandomItemFromFirstMenu()
                .clickRandomArticle();
    }

    @Step("Проверяется работа кнопки Найти на странице Справочник")
    public KssDocumentPage checkSearchButtonFunctionalityOnDictionaryPage(String query) {
        setParameter(SearchResultHelper.HINT_TEXT, query);
        return clearSearchBox()
                .clickSearchButton()
                .checkDictionaryTabIsSelected()
                .checkSearchResultIsNotPresentOnPage()

                .clearSearchBox()
                .inputTextInSearchBox(query)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnDictionaryPageIsOpened()
                .navigateToDictionaryPage()
                .clickRubricatorButton()
                .clickRandomItemFromFirstMenu()
                .clickRandomArticle();
    }

    @Step("Проверяется что результаты поиска отсутсвуют")
    public KssDocumentPage checkSearchResultIsNotPresentOnAnswersPage() {
        WebElement searchResultHeader = findElementByNoThrow(mainContentElement, By.cssSelector(".search-result"));
        WebElement searchResult = findElementByNoThrow(mainContentElement, By.cssSelector(".widget-search"));
        postponedAssertNull(searchResultHeader, "Заголовок результатов поиска отображается");
        postponedAssertNull(searchResult, "Результаты поиска отображается");
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Ответы'")
    public KssDocumentPage checkAnswersTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.ANSWERS);
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Справочник'")
    public KssDocumentPage checkDictionaryTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.DICTIONARY);
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются")
    public KssDocumentPage checkHintsIsPresent() {
        checkHintListIsPresent();
        return this;
    }

    public KssDocumentPage checkCurrentItemIsHighlightedInTableOfContents() {
        getHelper(DocumentHelper.class).checkCurrentItemIsHighlightedInTableOfContents();
        return this;
    }

    public KssDocumentPage checkCurrentItemIsHighlightedInTableOfContentsForKodeks() {
        getHelper(DocumentHelper.class).checkCurrentItemIsHighlightedInTableOfContentsForKodeks();
        return this;
    }

    public KssDocumentPage checkSelectedArticleIsOpened() {
        getHelper(DocumentHelper.class).checkSelectedArticleIsOpened();
        return this;
    }

    public KssDocumentPage checkEmptyDocumentStub() {
        getHelper(DocumentHelper.class).checkEmptyDocumentStub();
        return this;
    }

    public KssDocumentPage checkPublicationBlockIsNotPresent() {
        getHelper(DocumentHelper.class).checkPublicationBlockIsNotPresent();
        return this;
    }

    @Step("Нажать подсказку с прямым переходом")
    public KssSearchResultPage clickHintWithJumpOnYellowPlate() {
        WebElement searchResult = waitForVisibilityOfElementLocatedBy(By.id("ui-id-1"), "Выпадающие поисковые подсказки не отображаются");
        clickHintWithJump(searchResult);
        return redirectTo(KssSearchResultPage.class);
    }

    @Step("Нажать любую подсказку с переходом")
    public KssSearchResultPage clickRandomHintOnYellowPlate() {
        WebElement searchResult = waitForVisibilityOfElementLocatedBy(By.id("ui-id-1"), "Выпадающие поисковые подсказки не отображаются");
        clickRandomHint(searchResult);
        return redirectTo(KssSearchResultPage.class);
    }

    @Step("Нажать подсказку с прямым переходом")
    public KssSearchResultPage clickHintWithJumpOnDictionaryPage() {
        clickHintWithJump();
        return redirectTo(KssSearchResultPage.class);
    }

    public KssDocumentPage clickRandomArticle() {
        getHelper(DocumentHelper.class).clickRandomArticle();
        return this;
    }

    public KssDocumentPage clickTableOfContentsButton() {
        getHelper(DocumentHelper.class).clickTableOfContentsButton();
        return this;
    }

    public KssDocumentPage clickDeleteFromFavoritesButton() {
        getHelper(DocumentHelper.class).clickDeleteFromFavoritesButton();
        return this;
    }

    public KssDocumentPage clickRandomArticleFromTableOfContents() {
        getHelper(DocumentHelper.class).clickRandomArticleFromTableOfContents();
        return this;
    }

    public KssDocumentPage clickInformationLink() {
        getHelper(DocumentHelper.class).clickInformationLink();
        return this;
    }

    private void clickHintWithJump(WebElement searchResult) {
        WebElement hintsWith = searchResult.findElement(By.cssSelector(".hint-doc"));
        WebElement hintsWithJumpLink = hintsWith.findElement(By.tagName("a"));
        setParameter(SearchResultHelper.DOCUMENT_URL, hintsWithJumpLink.getAttribute("href"));
        hintsWithJumpLink.click();
    }

    private void clickRandomHint(WebElement searchResult) {
        List<WebElement> hints = searchResult.findElements(By.cssSelector(".ui-menu-item"));
        hints.remove(0);
        WebElement randomHint = getRandomElementInList(hints);
        setParameter(SearchResultHelper.HINT_TEXT, randomHint.getText());
        randomHint.click();
    }

    private void checkHintsIsPresent(WebElement searchResult) {
        List<WebElement> hintsWith = searchResult.findElements(By.cssSelector(".hint-doc"));
        List<WebElement> hints = searchResult.findElements(By.cssSelector(".ui-menu-item"));
        postponedAssertFalse(hintsWith.isEmpty(), "Подсказки с переходом не найдены");
        for (WebElement hint : hints) {
            postponedAssertTrue(hint.isDisplayed(), "Подсказки не найдены");
        }
    }

    private WebElement getDocumentHeader() {
        return waitForPresenceOfElementLocatedBy(By.id("document-header"), "Заголовок документ не найден");
    }

    public void checkHighlightingWordDocument() {
        getHelper(DocumentHelper.class).checkHighlightingWordDocument();
    }


    public KssDocumentPage checkBooksNameAndAuthor() {
        getHelper(DocumentHelper.class).checkBooksNameAndAuthor();
        return this;
    }

    public KssDocumentPage checkImageBook() {
        getHelper(DocumentHelper.class).checkImageBook();
        return this;
    }

    public KssDocumentPage checkNameDocument() {
        getHelper(DocumentHelper.class).checkNameDocument();
        return this;
    }

    public KssDocumentPage checkDisplayStars() {
        getHelper(DocumentHelper.class).checkDisplayStars();
        return this;
    }

    public KssDocumentPage checkDisplayTextDocumentInParagraphs() {
        getHelper(DocumentHelper.class).checkDisplayTextDocumentInParagraphs();
        return this;
    }

    public KssDocumentPage checkInMyFavoritesIcon() {
        getHelper(DocumentHelper.class).checkInMyFavoritesIcon();
        return this;
    }

    public KssDocumentPage checkPrintIcon() {
        getHelper(DocumentHelper.class).checkPrintIcon();
        return this;
    }

    public KssDocumentPage checkBackwardIcon() {
        getHelper(DocumentHelper.class).checkBackwardIcon();
        return this;
    }

    public KssDocumentPage checkForwardIcon() {
        getHelper(DocumentHelper.class).checkForwardIcon();
        return this;
    }

    public KssDocumentPage checkBrowseIcon() {
        getHelper(DocumentHelper.class).checkBrowseIcon();
        return this;
    }

    public KssDocumentPage checkShareIcon() {
        getHelper(DocumentHelper.class).checkShareIcon();
        return this;
    }

    public KssDocumentPage checkRubricatorButtonIsPresent(String buttonName) {
        getHelper(DocumentHelper.class).checkRubricatorButtonIsPresent(buttonName);
        return this;
    }

    public KssDocumentPage checkSoderButtonIsPresent() {
        getHelper(DocumentHelper.class).checkSoderButtonIsPresent();
        return this;
    }

    public KssDocumentPage checkBooksName() {
        getHelper(DocumentHelper.class).checkBooksName();
        return this;
    }

    public KssDocumentPage checkAuthor() {
        getHelper(DocumentHelper.class).checkAuthor();
        return this;
    }

    public KssDocumentPage checkDisplayTableOfContents() {
        getHelper(DocumentHelper.class).checkDisplayTableOfContents();
        return this;
    }

    public KssDocumentPage checkDisplayDescriptionList() {
        getHelper(DocumentHelper.class).checkDisplayDescriptionList();
        return this;
    }

    public KssDocumentPage checkRSSTitle(String Name) {
        getHelper(DocumentHelper.class).checkRSSTitle(Name);
        return this;
    }

    public KssDocumentPage checkDisplayNameJournal() {
        getHelper(DocumentHelper.class).checkDisplayNameJournal();
        return this;
    }

    public KssDocumentPage checkPudDateJournal() {
        getHelper(DocumentHelper.class).checkPudDateJournal();
        return this;
    }

    public KssDocumentPage checkArticleTitle() {
        getHelper(DocumentHelper.class).checkArticleTitle();
        return this;
    }

    public KssDocumentPage checkDisplayTextInJournal() {
        getHelper(DocumentHelper.class).checkDisplayTextInJournal();
        return this;
    }

    public KssDocumentPage checkDisplayNameJournal_119() {
        getHelper(DocumentHelper.class).checkDisplayNameJournal_119();
        return this;
    }

    public KssDocumentPage checkArticleTitle_119() {
        getHelper(DocumentHelper.class).checkArticleTitle_119();
        return this;
    }

    public KssDocumentPage checkDisplayTextDocumentInParagraphs_119() {
        getHelper(DocumentHelper.class).checkDisplayNameJournal_119();
        return this;
    }

    public KssDocumentPage checkDisplayStarsSection() {
        getHelper(DocumentHelper.class).checkDisplayStarsSection();
        return this;
    }

    public KssDocumentPage checkDisplayNameJournal_192() {
        getHelper(DocumentHelper.class).checkDisplayNameJournal_192();
        return this;
    }

    public KssDocumentPage checkNumberJournal_192() {
        getHelper(DocumentHelper.class).checkNumberJournal_192();
        return this;
    }

    public KssDocumentPage checkDisplayTableOfContents_192() {
        getHelper(DocumentHelper.class).checkDisplayTableOfContents_192();
        return this;
    }

    public KssDocumentPage checkNameAndNumberJournal() {
        getHelper(DocumentHelper.class).checkNameAndNumberJournal();
        return this;
    }

    public KssDocumentPage checkSearchIn() {
        getHelper(DocumentHelper.class).checkSearchIn();
        return this;
    }

    public KssDocumentPage checkRevisionIsValidFrom() {
        getHelper(DocumentHelper.class).checkRevisionIsValidFrom();
        return this;
    }

    public KssDocumentPage checkMenu() {
        getHelper(DocumentHelper.class).checkMenu();
        return this;
    }

    public KssDocumentPage checkDisplayStarsTable() {
        getHelper(DocumentHelper.class).checkDisplayStarsTable();
        return this;
    }

    public KssDocumentPage checkNotPresentShareIcon() {
        getHelper(DocumentHelper.class).checkNotPresentShareIcon();
        return this;
    }

    public KssDocumentPage checkDisplayCover() {
        getHelper(DocumentHelper.class).checkDisplayCover();
        return this;
    }

    public KssDocumentPage checkFooter(){
        getHelper(DocumentHelper.class).checkFooter();
        return this;
    }

    public KssDocumentPage disableYoutubeHosts(){
        getHelper(DocumentHelper.class).disableYoutubeHosts();
        return this;
    }

    public KssDocumentPage enableYoutubeHosts(){
        getHelper(DocumentHelper.class).enableYoutubeHosts();
        return this;
    }

    public KssDocumentPage videoYoutubeIsEnabled(){
        getHelper(DocumentHelper.class).videoYoutubeIsEnabled();
        return this;
    }

    public KssDocumentPage videoYoutubeIsDisabled(){
        getHelper(DocumentHelper.class).videoYoutubeIsDisabled();
        return this;
    }

    public KssDocumentPage enableVideoSourceYoutube(){
        getHelper(DocumentHelper.class).enableVideoSourceYoutube();
        return this;
    }

    public KssDocumentPage disableVideoSourceYoutube(){
        getHelper(DocumentHelper.class).disableVideoSourceYoutube();
        return this;
    }

    public KssDocumentPage checkTitleOfFormImage(){
        getHelper(DocumentHelper.class).checkTitleOfFormImage();
        return this;
    }

    public KssDocumentPage checkFormGaleryOpen(){
        getHelper(DocumentHelper.class).checkFormGaleryOpen();
        return this;
    }

    public KssDocumentPage checkCommonView118(String name){
        getHelper(DocumentHelper.class).checkCommonView118(name);
        return this;
    }

    public KssDocumentPage checkCommonView140(){
        getHelper(DocumentHelper.class).checkCommonView140();
        return this;
    }

    public KssDocumentPage checkAsNeedBlock(){
        getHelper(DocumentHelper.class).checkAsNeedBlock();
        return this;
    }

    public KssDocumentPage checkFormComments(){
        getHelper(DocumentHelper.class).checkFormComments();
        return this;
    }

    public KssDocumentPage checkCommonViewForms(){
        getHelper(DocumentHelper.class).checkCommonViewForms();
        return this;
    }

    public KssDocumentPage checkParentDocumentLinkIsPresent(){
        getHelper(DocumentHelper.class).checkParentDocumentLinkIsPresent();
        return this;
    }

    public KssDocumentPage checkParentDocumentLinkFormat(String expectedDocType){
        getHelper(DocumentHelper.class).checkParentDocumentLinkFormat(expectedDocType);
        return this;
    }

    public KssDocumentPage checkParentDocumentLinkIsItalicStyle(){
        getHelper(DocumentHelper.class).checkParentDocumentLinkIsItalicStyle();
        return this;
    }

    public KssDocumentPage checkParentDocumentLinkInBottom(){
        getHelper(DocumentHelper.class).checkParentDocumentLinkInBottom();
        return this;
    }

    public KssDocumentPage clickParentDocumentLink(){
        getHelper(DocumentHelper.class).clickParentDocumentLink();
        return this;
    }

    public KssDocumentPage checkParentDocumentTitle(){
        getHelper(DocumentHelper.class).checkParentDocumentTitle();
        return this;
    }

    public KssDocumentPage checkWarningPanelIsLocatedAboveThanHeader() {
        getHelper(DocumentHelper.class).checkWarningPanelIsLocatedAboveThanHeader();
        return this;
    }

    public KssDocumentPage checkWarningPanelWidthIsEqualsBrowserWidth() {
        getHelper(DocumentHelper.class).checkWarningPanelWidthIsEqualsBrowserWidth();
        return this;
    }

    public KssDocumentPage checkWarningPanelIsYellow() {
        getHelper(DocumentHelper.class).checkWarningPanelIsYellow();
        return this;
    }

    public KssDocumentPage checkWarningPanelHasText(String text) {
        getHelper(DocumentHelper.class).checkWarningPanelHasText(text);
        return this;
    }

    public KssDocumentPage checkWarningPanelHasLink(String textLink) {
        getHelper(DocumentHelper.class).checkWarningPanelHasLink(textLink);
        return this;
    }

    public KssDocumentPage checkDocumentHasTitleWithoutBody() {
        getHelper(DocumentHelper.class).checkDocumentHasTitleWithoutBody();
        return this;
    }

    public KssDocumentPage checkTryTrialFormIsPresent() {
        getHelper(DocumentHelper.class).checkTryTrialFormIsPresent();
        return this;
    }

    public KssDocumentPage checkArrowsInSearchInText(String query) {
        getHelper(DocumentHelper.class).checkArrowsInSearchInText(query);
        return this;
    }

    public KssDocumentPage checkDocumentSearchWithNoResult() {
        getHelper(DocumentHelper.class).checkDocumentSearchWithNoResult();
        return this;
    }

    public KssDocumentPage checkVersionsBlockForDictionaryDocumentIsPresent() {
        getHelper(DocumentHelper.class).checkVersionsBlockForDictionaryDocumentIsPresent();
        return this;
    }

    public KssDocumentPage checkOtherVersionsForDictionaryDocumentIsPresent() {
        getHelper(DocumentHelper.class).checkOtherVersionsForDictionaryDocumentIsPresent();
        return this;
    }

    public KssDocumentPage checkExpiredVersionsForDictionaryDocumentIsPresent() {
        getHelper(DocumentHelper.class).checkExpiredVersionsForDictionaryDocumentIsPresent();
        return this;
    }

    public KssDocumentPage checkTableOfContentsButtonIsPressed() {
        getHelper(DocumentHelper.class).checkTableOfContentsButtonIsPressed();
        return this;
    }

    public KssDocumentPage checkTableOfContentsButtonIsUnPressed() {
        getHelper(DocumentHelper.class).checkTableOfContentsButtonIsUnPressed();
        return this;
    }

    public KssDocumentPage clickDocumentHeader() {
        getHelper(DocumentHelper.class).clickDocumentHeader();
        return this;
    }

    public KssDocumentPage checkDisplayTableOfContentsForKodeks() {
        getHelper(DocumentHelper.class).checkDisplayTableOfContentsForKodeks();
        return this;
    }

    public KssDocumentPage clickAboutBookButton() {
        getHelper(DocumentHelper.class).clickAboutBookButton();
        return this;
    }

    public KssDocumentPage checkAboutBookBlock() {
        getHelper(DocumentHelper.class).checkAboutBookBlock();
        return this;
    }

    public KssDocumentPage setBrowserSize(int width, int height) {
        getHelper(DocumentHelper.class).setBrowserSize(width, height);
        return this;
    }

    public KssDocumentPage checkSizeOfAboutBookBlockIsNotChanged() {
        getHelper(DocumentHelper.class).checkSizeOfAboutBookBlockIsNotChanged();
        return this;
    }

    public KssDocumentPage checkExtendedSearchButtonIsPresent(){
        getHelper(DocumentHelper.class).checkExtendedSearchButtonIsPresent();
        return this;
    }

    @Step("Проверяется что кнопка 'Отправить' отображается")
    public KssDocumentPage checkSendButtonIsPresentForKodeks() {
        WebElement header = waitForPresenceOfElementLocatedBy(By.id("document-header"), "Заголовок документа не найден");
        WebElement browserButton = findElementByNoThrow(header, By.cssSelector(".ico_content_mail"));
        postponedAssertNotNull(browserButton, "Кнопка 'Отправить' не найдена");
        postponedAssertTrue(browserButton.isDisplayed(), "Кнопка 'Отправить' не отображается");
        return this;
    }

    public KssDocumentPage checkTableOfContentsButtonIsPresent(){
        getHelper(DocumentHelper.class).checkTableOfContentsButtonIsPresent();
        return this;
    }

    public KssDocumentPage clickDocumentInfobarLink() {
        getHelper(DocumentHelper.class).clickDocumentInfobarLink();
        return this;
    }

    public KssDocumentPage checkTextDocumentEditionFrom() {
        getHelper(DocumentHelper.class).checkTextDocumentEditionFrom();
        return this;
    }

    public KssDocumentPage checkTitleAndAuthorInformationPresent() {
        getHelper(DocumentHelper.class).checkTitleAndAuthorInformationPresent();
        return this;
    }

    public KssDocumentPage checkContentIsPresent() {
        getHelper(DocumentHelper.class).checkContentIsPresent();
        return this;
    }

    public KssDocumentPage checkDocumentRatingIsPresent() {
        getHelper(DocumentHelper.class).checkDocumentRatingIsPresent();
        return this;
    }

    public KssDocumentPage checkDocumentTitleIsPresent() {
        getHelper(DocumentHelper.class).checkDocumentTitleIsPresent();
        return this;
    }

    public KssDocumentPage checkBlockDispute() {
        getHelper(DocumentHelper.class).checkBlockDispute();
        return this;
    }

    public KssDocumentPage checkCurrencyDocument() {
        getHelper(DocumentHelper.class).checkCurrencyDocument();
        return this;
    }

    public KssDocumentPage selectFirstCurrencyByCode(String code) {
        getHelper(DocumentHelper.class).selectFirstCurrencyByCode(code);
        return this;
    }

    public KssDocumentPage selectSecondCurrencyByCode(String code) {
        getHelper(DocumentHelper.class).selectSecondCurrencyByCode(code);
        return this;
    }

    public KssDocumentPage clickChangeCurrencyOrderButton() {
        getHelper(DocumentHelper.class).clickChangeCurrencyOrderButton();
        return this;
    }

    public KssDocumentPage checkFirstCurrencyLabel(String code) {
        getHelper(DocumentHelper.class).checkFirstCurrencyLabel(code);
        return this;
    }

    public KssDocumentPage checkSecondCurrencyLabel(String code) {
        getHelper(DocumentHelper.class).checkSecondCurrencyLabel(code);
        return this;
    }

    public KssDocumentPage checkTableCourseLabel(String codeFirstCurrency, String codeSecondCurrency) {
        getHelper(DocumentHelper.class).checkTableCourseLabel(codeFirstCurrency, codeSecondCurrency);
        return this;
    }

    public KssDocumentPage checkLastCourseTableIsChanged() {
        getHelper(DocumentHelper.class).checkLastCourseTableIsChanged();
        return this;
    }

    public KssDocumentPage setLastCourseTableToParameter() {
        getHelper(DocumentHelper.class).setLastCourseTableToParameter();
        return this;
    }

    public KssDocumentPage checkDocumentIsBlurred() {
        getHelper(DocumentHelper.class).checkDocumentIsBlurred();
        return this;
    }

    public KssDocumentPage checkAuthFormIsPresent() {
        getHelper(DocumentHelper.class).checkAuthFormIsPresent();
        return this;
    }

    public KssDocumentPage checkDocPreviewTextStatus() {
        getHelper(DocumentHelper.class).checkDocPreviewTextStatus();
        return this;
    }

    public KssDocumentPage checkTryTrialForm() {
        getHelper(DocumentHelper.class).checkTryTrialForm();
        return this;
    }

    public KssDocumentPage checkSubscribeActivationFormIsPresent() {
        getHelper(DocumentHelper.class).checkSubscribeActivateFormIsPresent();
        return this;
    }

    public KssDocumentPage checkSubscribeActivationForm() {
        getHelper(DocumentHelper.class).checkSubscribeActivationFormCellPhoneNumberIsPresent();
        return this;
    }

    public KssDocumentPage checkTryTrialFormHasText(String text) {
        getHelper(DocumentHelper.class).checkTryTrialFormHasText(text);
        return this;
    }

    public KssDocumentPage checkDocBriefIsPresent(String brief) {
        getHelper(DocumentHelper.class).checkDocBriefIsPresent(brief);
        return this;
    }

    public KssDocumentPage checkBacklinksArePresent() {
        getHelper(DocumentHelper.class).checkBacklinksArePresent();
        return this;
    }

    public KssDocumentPage checkBacklinkHasCssStyles() {
        getHelper(DocumentHelper.class).checkBacklinkHasCssStyles();
        return this;
    }

    public KssDocumentPage clickOnBacklinkWithReferencesCount(int count) {
        getHelper(DocumentHelper.class).clickOnBacklinkWithReferencesCount(count);
        return this;
    }

    public KssDocumentPage checkNotepadPopupIsPresent() {
        getHelper(NotepadPopup.class).checkPopupIsPresent();
        return this;
    }

    public KssDocumentPage checkParagraphAndButtonAreYellow() {
        getHelper(DocumentHelper.class).checkParagraphAndButtonAreYellow();
        return this;
    }

    public KssDocumentPage checkParagraphAndButtonAreNotYellow() {
        getHelper(DocumentHelper.class).checkParagraphAndButtonAreNotYellow();
        return this;
    }

    /**
     * @param phraseAnchor - the part of link in the data-anchor attribute for the tag 'a'
     *                     example: <a data-anchor="/document/99/9027690/bssPhr143/"...,
     *                     for this, phraseAnchor = bssPhr143
     */
    public KssDocumentPage clickOnRequiredArticleBacklink(String phraseAnchor) {
        getHelper(DocumentHelper.class).clickOnRequiredArticleBacklink(phraseAnchor);
        return this;
    }

    public KssDocumentPage checkNotepadPopupHasShadow() {
        getHelper(NotepadPopup.class).checkPopupHasShadow();
        return this;
    }

    public KssDocumentPage checkNotepadPopupHeaderIsWhite() {
        getHelper(NotepadPopup.class).checkHeaderIsWhite();
        return this;
    }

    public KssDocumentPage checkNotepadPopupTitleIsPresent() {
        getHelper(NotepadPopup.class).checkTitleIsPresent();
        return this;
    }

    public KssDocumentPage checkNotepadPopupCloseIconIsPresent() {
        getHelper(NotepadPopup.class).checkCloseIconIsPresent();
        return this;
    }

    public KssDocumentPage checkNotepadPopupBodyIsYellow() {
        getHelper(NotepadPopup.class).checkBodyIsYellow();
        return this;
    }

    public KssDocumentPage checkNotepadPopupBodyHasBacklinks() {
        getHelper(NotepadPopup.class).checkBodyHasBacklinks();
        return this;
    }

    public KssDocumentPage checkNotepadPopupIsNotPresent() {
        getHelper(NotepadPopup.class).checkPopupIsNotPresent();
        return this;
    }

    public KssDocumentPage clickOnNotepadPopupCloseButton() {
        getHelper(NotepadPopup.class).clickOnCloseButton();
        return this;
    }

    public KssDocumentPage checkNotepadPopupMenuBlockIsPresent() {
        getHelper(NotepadPopup.class).checkMenuBlockIsPresent();
        return this;
    }

    public KssDocumentPage checkNotepadPopupMenuBlockIsNotPresent() {
        getHelper(NotepadPopup.class).checkMenuBlockIsNotPresent();
        return this;
    }

    public KssDocumentPage checkNotepadPopupMenuItemsInOrder(NotepadPopup.Item... items) {
        getHelper(NotepadPopup.class).checkMenuItemsInOrder(items);
        return this;
    }

    public KssDocumentPage checkNotepadPopupMenuItemIcon(NotepadPopup.Item... items) {
        getHelper(NotepadPopup.class).checkMenuItemIcon(items);
        return this;
    }

    public KssDocumentPage hoverOnNotepadPopupMenuItem(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).hoverOnMenuItem(item);
        return this;
    }

    public KssDocumentPage checkNotepadPopupMenuItemIsRed(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).checkMenuItemIsRed(item);
        return this;
    }

    public KssDocumentPage clickOnNotepadPopupMenu(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).clickOnMenu(item);
        return this;
    }

    public KssDocumentPage checkNotepadPopupMenuItemHasRightName(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).checkMenuItemHasRightName(item);
        return this;
    }

    public KssDocumentPage checkNotepadPopupMenuItemIsYellow(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).checkMenuItemIsYellow(item);
        return this;
    }

    public KssDocumentPage checkNotepadPopupMenuItemIsNotRed(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).checkMenuItemIsNotRed(item);
        return this;
    }

    public KssDocumentPage checkNotepadPopupScrollTo(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).checkScrollTo(item);
        return this;
    }

    public KssDocumentPage checkNotepadPopupMenuItemIsSelectedAfterScrolling(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).checkMenuItemIsSelectedAfterScrolling(item);
        return this;
    }

    public KssDocumentPage checkNotepadPopupTitleHasWhiteSpaceCSSValue() {
        getHelper(NotepadPopup.class).checkTitleHasWhiteSpaceCSSValue();
        return this;
    }

    public KssDocumentPage checkNotepadTitleEqualsWithPhraseTitle(String phraseAnchor) {
        getHelper(NotepadPopup.class).checkTitle(phraseAnchor);
        return this;
    }

    public KssDocumentPage checkNotepadTitleContainsWord(String phraseAnchor, String word) {
        getHelper(NotepadPopup.class).checkTitleContainsWord(phraseAnchor, word);
        return this;
    }

    public KssDocumentPage checkNotepadTitleIsAdditionalInformation() {
        getHelper(NotepadPopup.class).checkTitleIsAdditionalInformation();
        return this;
    }

    public KssDocumentPage clickOnBackLinkFromTitle() {
        getHelper(DocumentHelper.class).clickOnBackLinkFromTitle();
        return this;
    }

    public KssDocumentPage checkNotepadPopupRecomendationBlockFirstItemHasPhotoFullNameAndPosition() {
        getHelper(NotepadPopup.class).checkRecomendationBlockFirstItemHasPhotoFullNameAndPosition();
        return this;
    }

    public KssDocumentPage checkNotepadPopupRecomentdationBlockHasNoMoreThan10Links() {
        getHelper(NotepadPopup.class).checkRecomentdationBlockHasNoMoreThan10Links();
        return this;
    }

    public KssDocumentPage checkNotepadPopupRecomendationBlockHasLinks() {
        getHelper(NotepadPopup.class).checkRecomendationBlockHasLinks();
        return this;
    }

    public KssDocumentPage checkNotepadPopupFormsBlockHasLinks() {
        getHelper(NotepadPopup.class).checkFormsBlockHasLinks();
        return this;
    }

    public KssDocumentPage checkNotepadPopupFormsBlockHasNoMoreThan10Links() {
        getHelper(NotepadPopup.class).checkFormsBlockHasNoMoreThan10Links();
        return this;
    }

    public KssDocumentPage checkNotepadPopupHandbookBlockHasLinks() {
        getHelper(NotepadPopup.class).checkHandbookBlockHasLinks();
        return this;
    }

    public KssDocumentPage checkNotepadPopupHandbookBlockHasNoMoreThan10Links() {
        getHelper(NotepadPopup.class).checkHandbookBlockHasNoMoreThan10Links();
        return this;
    }

    public KssDocumentPage checkNotepadPopupPressBlockHasItems() {
        getHelper(NotepadPopup.class).checkPressBlockHasItems();
        return this;
    }

    public KssDocumentPage checkNotepadPopupPressBlockHasNoMoreThan10Links() {
        getHelper(NotepadPopup.class).checkPressBlockHasNoMoreThan10Links();
        return this;
    }

    public KssDocumentPage checkNotepadPopupLawBlockHasLinks() {
        getHelper(NotepadPopup.class).checkLawBlockHasLinks();
        return this;
    }

    public KssDocumentPage checkNotepadPopupLawBlockHasNoMoreThan10Links() {
        getHelper(NotepadPopup.class).checkLawBlockHasNoMoreThan10Links();
        return this;
    }

    public KssDocumentPage checkNotepadPopupLawPracticeBlockHasLinks() {
        getHelper(NotepadPopup.class).checkLawPracticeBlockHasLinks();
        return this;
    }

    public KssDocumentPage checkNotepadPopupLawPracticeBlockHasNoMoreThan10Links() {
        getHelper(NotepadPopup.class).checkLawPracticeBlockHasNoMoreThan10Links();
        return this;
    }

    public KssDocumentPage hoverOnNotepadPopupFirstLinkFromLawPractice() {
        getHelper(NotepadPopup.class).hoverOnFirstLinkFromLawPractice();
        return this;
    }

    public KssDocumentPage checkNotepadPopupFirstLinkFromLawPracticeBecomeRedAfterHoverOn() {
        getHelper(NotepadPopup.class).checkFirstLinkFromLawPracticeBecomeRedAfterHoverOn();
        return this;
    }

    public KssDocumentPage clickOnNotepadPopupFormsBlockRandomLink() {
        getHelper(NotepadPopup.class).clickOnFormsBlockRandomLink();
        return this;
    }

    public KssDocumentPage clickOnNotepadPopupHandbookBlockRandomLink() {
        getHelper(NotepadPopup.class).clickOnHandbookBlockRandomLink();
        return this;
    }

    public KssDocumentPage clickOnNotepadPopupLawBlockRandomLink() {
        getHelper(NotepadPopup.class).clickOnLawBlockRandomLink();
        return this;
    }

    public KssDocumentPage clickOnNotepadPopupPressBlockRandomLink() {
        getHelper(NotepadPopup.class).clickOnPressBlockRandomLink();
        return this;
    }

    public KssDocumentPage clickOnNotepadPopupLawPracticeBlockRandomLink() {
        getHelper(NotepadPopup.class).clickOnLawPracticeBlockRandomLink();
        return this;
    }

    public KssDocumentPage clickOnNotepadPopupRecomendationBlockRandomLink() {
        getHelper(NotepadPopup.class).clickOnRecomendationBlockRandomLink();
        return this;
    }

    public KssDocumentPage clickOnPrevButtonInTopMenu() {
        getHelper(DocumentHelper.class).clickOnPrevButtonInTopMenu();
        return this;
    }

    public KssDocumentPage clickOnNextButtonInTopMenu() {
        getHelper(DocumentHelper.class).clickOnNextButtonInTopMenu();
        return this;
    }

    public KssDocumentPage clickOnPreviousButtonInBottomMenu() {
        getHelper(DocumentHelper.class).clickOnPreviousButtonInBottomMenu();
        return this;
    }

    public KssDocumentPage clickOnNextButtonInBottomMenu() {
        getHelper(DocumentHelper.class).clickOnNextButtonInBottomMenu();
        return this;
    }

    public KssDocumentPage checkNextAndPrevButtonsInTopMenuArePresent() {
        getHelper(DocumentHelper.class).checkNextAndPrevButtonsInTopMenuArePresent();
        return this;
    }

    public KssDocumentPage checkNextAndPrevButtonsInBottomMenuArePresent() {
        getHelper(DocumentHelper.class).checkNextAndPrevButtonsInBottomMenuArePresent();
        return this;
    }

    public KssDocumentPage checkPrevButtonInTopIsAbsent() {
        getHelper(DocumentHelper.class).checkButtonPreviousInTopMenuIsNotPresent();
        return this;
    }

    public KssDocumentPage checkNextButtonInTopIsAbsent() {
        getHelper(DocumentHelper.class).checkButtonNextInTopMenuIsNotPresent();
        return this;
    }

    public KssDocumentPage checkNextButtonInBottomIsAbsent() {
        getHelper(DocumentHelper.class).checkButtonNextInBottomMenuIsNotPresent();
        return this;
    }

    public KssDocumentPage checkPrevButtonInBottomIsAbsent() {
        getHelper(DocumentHelper.class).checkButtonPreviousInBottomMenuIsNotPresent();
        return this;
    }

    public KssDocumentPage clickFirstArticleFromTableOfContents() {
        getHelper(DocumentHelper.class).clickFirstArticleFromTableOfContents();
        return this;
    }

    public KssDocumentPage clickLastArticleFromTableOfContents() {
        getHelper(DocumentHelper.class).clickLastArticleFromTableOfContents();
        return this;
    }

    public KssDocumentPage checkDocumentIsNotEmpty() {
        getHelper(DocumentHelper.class).checkDocumentIsNotEmpty();
        return this;
    }

    public KssDocumentPage checkMoreOnTheTopicIsPresent() {
        getHelper(DocumentHelper.class).checkMoreOnTheTopicIsPresent();
        return this;
    }

    public KssDocumentPage checkCommentsArePresent() {
        getHelper(DocumentHelper.class).checkCommentsArePresent();
        return this;
    }

    public KssDocumentPage checkRevisionHistoryIsPresent() {
        getHelper(DocumentHelper.class).checkRevisionHistoryLinkIsPresent();
        return this;
    }

    public KssDocumentPage clickOnRevisionHistoryLink() {
        getHelper(DocumentHelper.class).clickOnRevisionHistoryLink();
        return this;
    }

    public KssDocumentPage checkRevisionHistoryBlockIsOpened() {
        getHelper(DocumentHelper.class).checkRevisionHistoryBlockIsOpened();
        return this;
    }

    public KssDocumentPage checkRevisionHistoryTitleSpeciallyActionsIsPresent() {
        getHelper(DocumentHelper.class).checkRevisionHistoryTitleSpeciallyActionsIsPresent();
        return this;
    }

    public KssDocumentPage checkRevisionHistoryTitleContainsInDocumentIsPresent() {
        getHelper(DocumentHelper.class).checkRevisionHistoryTitleContainsInDocumentIsPresent();
        return this;
    }

    public KssDocumentPage clickOnRandomDocumentFromRevisionHistoryList() {
        getHelper(DocumentHelper.class).clickOnRandomDocumentFromRevisionHistoryList();
        return this;
    }

    public KssDocumentPage clickOnMoreLinksFromInfobarOfTheDocument() {
        getHelper(DocumentHelper.class).clickOnMoreLinksFromInfobarOfTheDocument();
        return this;
    }

    public KssDocumentPage checkMoreLinksLinkHasYellowHighlightAfterClicking() {
        getHelper(DocumentHelper.class).checkMoreLinksLinkHasYellowHighlightAfterClicking();
        return this;
    }

    public KssDocumentPage checkMoreLinksBlockIsOpened() {
        getHelper(DocumentHelper.class).checkMoreLinksBlockIsOpened();
        return this;
    }

    public KssDocumentPage checkMoreLinksHasTitleLinks() {
        getHelper(DocumentHelper.class).checkMoreLinksHasTitleLinks();
        return this;
    }

    public KssDocumentPage clickOnMoreLinksRandomLink() {
        getHelper(DocumentHelper.class).clickOnMoreLinksRandomLink();
        return this;
    }

    public KssDocumentPage checkMoreLinksAreDuplicatedBelowOfTheDocument() {
        getHelper(DocumentHelper.class).checkMoreLinksAreDuplicatedBelowOfTheDocument();
        return this;
    }

    public KssDocumentPage clickOnLinksFromInfobarInBottom() {
        getHelper(DocumentHelper.class).clickOnLinksFromInfobarInBottom();
        return this;
    }

    public KssDocumentPage checkStickyHeaderIsGray() {
        getHelper(DocumentHelper.class).checkStickyHeaderIsGray();
        return this;
    }

    public KssDocumentPage clickOnStickyHeader() {
        getHelper(DocumentHelper.class).clickOnStickyHeader();
        return this;
    }

    public KssDocumentPage checkStickyHeaderIsNotPresent() {
        getHelper(DocumentHelper.class).checkStickyHeaderIsNotPresent();
        return this;
    }

    public KssDocumentPage checkStickyHeaderScrolling() {
        getHelper(DocumentHelper.class).checkStickyHeaderScrolling();
        return this;
    }

    public KssDocumentPage checkQuickTocHasNumbers() {
        getHelper(DocumentHelper.class).checkQuickTocHasNumbers();
        return this;
    }

    public KssDocumentPage checkQuickTocDoesNotContainItemsReferencesAndLinks() {
        getHelper(DocumentHelper.class).checkQuickTocDoesNotContainItemsReferencesAndLinks();
        return this;
    }

    public KssDocumentPage clickOnInfobarApplicationsLink() {
        getHelper(DocumentHelper.class).clickOnInfobarApplicationsLink();
        return this;
    }

    public KssDocumentPage checkApplicationsTextsArePresent() {
        getHelper(AttachmentsInfobar.class).checkApplicationsTextsArePresent();
        return this;
    }

    public KssDocumentPage checkAttachedFilesAreAvailable() {
        getHelper(AttachmentsInfobar.class).checkAttachedFilesAreAvailable();
        return this;
    }

    public KssDocumentPage checkApplicationsExtensionsArePresent() {
        getHelper(AttachmentsInfobar.class).checkApplicationsExtensionsArePresent();
        return this;
    }

    public KssDocumentPage checkMetaTagsAndTableOfContents() {
        getHelper(DocumentHelper.class).checkMetaTagsAndTableOfContents();
        return this;
    }

    public KssDocumentPage checkMetaTagsAndSavedDataContent() {
        getHelper(DocumentHelper.class).checkMetaTagsAndSavedDataContent();
        return this;
    }

    public KssDocumentPage clickReferencesByArticleAndParagraph(int chapterNumber, int articleNumber, int paragraphNumber) {
        getHelper(DocumentHelper.class).clickReferencesByArticleAndParagraph(chapterNumber, articleNumber, paragraphNumber);
        return this;
    }

    public KssSearchResultPage clickAllAdditionalMaterialsButton() {
        getHelper(DocumentHelper.class).clickAllAdditionalMaterialsButton();
        return redirectTo(KssSearchResultPage.class);
    }
}


