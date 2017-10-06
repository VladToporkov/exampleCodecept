package com.actionmedia.pages.edu;

import com.actionmedia.components.info.AttachmentsInfobar;
import com.actionmedia.pages.helpers.DocumentHelper;
import com.actionmedia.pages.helpers.SearchResultHelper;
import com.actionmedia.pages.interfaces.IDocumentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Pavel on 18/04/16.
 */
@Component
public class EduDocumentPage extends EduBasePage<EduDocumentPage> implements IDocumentPage {

    public static String CURRENT_URL = "edu.document.current.url";

    public EduDocumentPage checkDocumentIsOpened() {
        getHelper(DocumentHelper.class).checkDocumentIsOpened();
        return this;
    }

    @Override
    public EduDocumentPage checkDownloadShowExamplesLinkIsNotPresent() {
        getHelper(DocumentHelper.class).checkDownloadShowExamplesLinkIsNotPresent();
        return this;
    }

    @Override
    public EduDocumentPage checkDownloadShowExampleLinkIsNotPresent() {
        getHelper(DocumentHelper.class).checkDownloadShowExampleLinkIsNotPresent();
        return this;
    }

    public EduDocumentPage checkMenu() {
        getHelper(DocumentHelper.class).checkMenu();
        return this;
    }

    public EduDocumentPage checkWordButtonIsPresent() {
        getHelper(DocumentHelper.class).checkWordButtonIsPresent();
        return this;
    }

    public EduDocumentPage checkMailButtonIsPresent() {
        getHelper(DocumentHelper.class).checkMailButtonIsPresent();
        return this;
    }

    public EduDocumentPage checkPrintIcon() {
        getHelper(DocumentHelper.class).checkPrintIcon();
        return this;
    }

    public EduDocumentPage checkDocumentTitleIsPresent() {
        getHelper(DocumentHelper.class).checkDocumentTitleIsPresent();
        return this;
    }

    public EduDocumentPage checkBriefBlockIsPresent() {
        getHelper(DocumentHelper.class).checkBriefBlockIsPresent();
        return this;
    }

    public EduDocumentPage checkDocumentRatingIsPresent() {
        getHelper(DocumentHelper.class).checkDocumentRatingIsPresent();
        return this;
    }

    public EduDocumentPage checkSoderIsPresent() {
        getHelper(DocumentHelper.class).checkSoderIsPresent();
        return this;
    }

    public EduDocumentPage checkRubricatorButtonIsPresent(String buttonName) {
        getHelper(DocumentHelper.class).checkRubricatorButtonIsPresent(buttonName);
        return this;
    }

    public EduDocumentPage checkAddToFavoritesButtonsForDocumentArePresent() {
        getHelper(DocumentHelper.class).checkAddToFavoritesButtonsForDocumentArePresent();
        return this;
    }

    public EduDocumentPage checkMetaTagsAndTableOfContents() {
        getHelper(DocumentHelper.class).checkMetaTagsAndTableOfContents();
        return this;
    }

    public EduDocumentPage checkMetaTagsAndSavedDataContent() {
        getHelper(DocumentHelper.class).checkMetaTagsAndSavedDataContent();
        return this;
    }

    public EduDocumentPage checkTitleAndAuthorInformationPresent() {
        getHelper(DocumentHelper.class).checkTitleAndAuthorInformationPresent();
        return this;
    }

    public EduDocumentPage checkContentIsPresent() {
        checkEmptyDocumentHeader();
        checkEmptyDocument();
        return this;
    }

    public EduDocumentPage checkParentDocumentLinkIsPresent() {
        getHelper(DocumentHelper.class).checkParentDocumentLinkIsPresent();
        return this;
    }

    public EduDocumentPage checkTextBlocksForDocument199_10182() {
        getHelper(DocumentHelper.class).checkTextBlocksForDocument199_10182();
        return this;
    }

    public EduDocumentPage checkTransportTaxForDoc_11_14355() {
        getHelper(DocumentHelper.class).checkTransportTaxForDoc_11_14355();
        return this;
    }

    public EduDocumentPage checkTextContainsBlocksHowToAndWhatToDo() {
        getHelper(DocumentHelper.class).checkTextContainsBlocksHowToAndWhatToDo();
        return this;
    }

    public EduDocumentPage checkInCut() {
        getHelper(DocumentHelper.class).checkInCut();
        return this;
    }

    public EduDocumentPage clickDocumentInfobarLink() {
        getHelper(DocumentHelper.class).clickDocumentInfobarLink();
        return this;
    }

    public EduDocumentPage checkInfobarCardIsPresent() {
        getHelper(DocumentHelper.class).checkInfobarCardIsPresent();
        return this;
    }

    public EduDocumentPage checkInfobarBlocksLinks() {
        getHelper(DocumentHelper.class).checkInfobarBlocksLinks();
        return this;
    }

    public EduDocumentPage checkDocumentInfobarBottom() {
        getHelper(DocumentHelper.class).checkDocumentInfobarBottom();
        return this;
    }

    public EduDocumentPage checkTitleTag() {
        getHelper(DocumentHelper.class).checkTitleTag();
        return this;
    }

    public EduDocumentPage checkIncutAdviceContainsText(String text) {
        getHelper(DocumentHelper.class).checkIncutAdviceContainsText(text);
        return this;
    }

    public EduDocumentPage checkTextDocumentEditionFromInDocHeader() {
        getHelper(DocumentHelper.class).checkTextDocumentEditionFromInDocHeader();
        return this;
    }

    public EduDocumentPage checkLogoGlavbukhInDocumentContentFooter() {
        getHelper(DocumentHelper.class).checkLogoGlavbukhInDocumentContentFooter();
        return this;
    }

    public EduDocumentPage clickOnPrevButtonInTopMenu() {
        getHelper(DocumentHelper.class).clickOnPrevButtonInTopMenu();
        return this;
    }

    public EduDocumentPage clickOnNextButtonInTopMenu() {
        getHelper(DocumentHelper.class).clickOnNextButtonInTopMenu();
        return this;
    }

    public EduDocumentPage clickOnPreviousButtonInBottomMenu() {
        getHelper(DocumentHelper.class).clickOnPreviousButtonInBottomMenu();
        return this;
    }

    public EduDocumentPage clickOnNextButtonInBottomMenu() {
        getHelper(DocumentHelper.class).clickOnNextButtonInBottomMenu();
        return this;
    }

    public EduDocumentPage checkNextAndPrevButtonsInTopMenuArePresent() {
        getHelper(DocumentHelper.class).checkNextAndPrevButtonsInTopMenuArePresent();
        return this;
    }

    public EduDocumentPage checkNextAndPrevButtonsInBottomMenuArePresent() {
        getHelper(DocumentHelper.class).checkNextAndPrevButtonsInBottomMenuArePresent();
        return this;
    }

    public EduDocumentPage checkPrevButtonInTopIsAbsent() {
        getHelper(DocumentHelper.class).checkButtonPreviousInTopMenuIsNotPresent();
        return this;
    }

    public EduDocumentPage checkNextButtonInTopIsAbsent() {
        getHelper(DocumentHelper.class).checkButtonNextInTopMenuIsNotPresent();
        return this;
    }

    public EduDocumentPage checkNextButtonInBottomIsAbsent() {
        getHelper(DocumentHelper.class).checkButtonNextInBottomMenuIsNotPresent();
        return this;
    }

    public EduDocumentPage checkPrevButtonInBottomIsAbsent() {
        getHelper(DocumentHelper.class).checkButtonPreviousInBottomMenuIsNotPresent();
        return this;
    }

    public EduDocumentPage clickTableOfContentsButton() {
        getHelper(DocumentHelper.class).clickTableOfContentsButton();
        return this;
    }

    public EduDocumentPage clickFirstArticleFromTableOfContents() {
        getHelper(DocumentHelper.class).clickFirstArticleFromTableOfContents();
        return this;
    }

    public EduDocumentPage clickLastArticleFromTableOfContents() {
        getHelper(DocumentHelper.class).clickLastArticleFromTableOfContents();
        return this;
    }

    public EduDocumentPage checkTableOfContentsButtonIsPressed() {
        getHelper(DocumentHelper.class).checkTableOfContentsButtonIsPressed();
        return this;
    }

    public EduDocumentPage checkTableOfContentsIsNotEmpty() {
        getHelper(DocumentHelper.class).checkTableOfContentsIsNotEmpty("");
        return this;
    }

    public EduDocumentPage checkDocumentIsNotEmpty() {
        getHelper(DocumentHelper.class).checkDocumentIsNotEmpty();
        return this;
    }

    public EduDocumentPage checkTableOfContentsButtonIsUnPressed() {
        getHelper(DocumentHelper.class).checkTableOfContentsButtonIsUnPressed();
        return this;
    }

    public EduDocumentPage clickRandomArticleFromTableOfContents() {
        getHelper(DocumentHelper.class).clickRandomArticleFromTableOfContents();
        return this;
    }

    public EduDocumentPage checkPudDateJournal() {
        getHelper(DocumentHelper.class).checkPudDateJournal();
        return this;
    }

    public EduDocumentPage checkArticleTitle() {
        getHelper(DocumentHelper.class).checkArticleTitle();
        return this;
    }

    public EduDocumentPage checkDisplayTextInJournal() {
        getHelper(DocumentHelper.class).checkDisplayTextInJournal();
        return this;
    }

    public EduDocumentPage checkInMyFavoritesIcon() {
        getHelper(DocumentHelper.class).checkInMyFavoritesIcon();
        return this;
    }

    public EduDocumentPage checkBrowseIcon() {
        getHelper(DocumentHelper.class).checkBrowseIcon();
        return this;
    }

    public EduDocumentPage checkShareIcon() {
        getHelper(DocumentHelper.class).checkShareIcon();
        return this;
    }

    public EduDocumentPage checkBackwardIcon() {
        getHelper(DocumentHelper.class).checkBackwardIcon();
        return this;
    }

    public EduDocumentPage checkForwardIcon() {
        getHelper(DocumentHelper.class).checkForwardIcon();
        return this;
    }

    public EduDocumentPage checkSoderButtonIsPresent() {
        getHelper(DocumentHelper.class).checkSoderButtonIsPresent();
        return this;
    }

    public EduDocumentPage checkDisplayNameJournal() {
        getHelper(DocumentHelper.class).checkDisplayNameJournal();
        return this;
    }

    public EduDocumentPage checkDisplayNameJournal_192() {
        getHelper(DocumentHelper.class).checkDisplayNameJournal_192();
        return this;
    }

    public EduDocumentPage checkNumberJournal_192() {
        getHelper(DocumentHelper.class).checkNumberJournal_192();
        return this;
    }

    public EduDocumentPage checkDisplayTableOfContents_192() {
        getHelper(DocumentHelper.class).checkDisplayTableOfContents_192();
        return this;
    }

    public EduDocumentPage checkInfoBarWidgetWork() {
        getHelper(DocumentHelper.class).checkInfoBarWidgetWork();
        return this;
    }

    public EduDocumentPage checkFooter() {
        getHelper(DocumentHelper.class).checkFooter();
        return this;
    }

    public EduDocumentPage checkOpenedLinkHasRequiredTitle() {
        getHelper(DocumentHelper.class).checkOpenedLinkHasRequiredTitle();
        return this;
    }

    public EduDocumentPage checkPrintButtonIsPresent() {
        getHelper(DocumentHelper.class).checkPrintButtonIsPresent();
        return this;
    }

    @Step("Проверяется, что ссылка на шаблон формата doc.e-mcfr.ru/template присутствует на странице")
    public EduDocumentPage checkLinkTemplateDocEMCFRIsPresent() {
        WebElement link = findElementByNoThrow(By.cssSelector("a[href*='doc.e-mcfr.ru/template']"));
        postponedAssertTrue(link != null && link.isDisplayed(), "Ссылка на шаблон формата doc.e-mcfr.ru/template/ не найдена");
        return this;
    }

    @Step("Проверяется, что ссылка на шаблон формата services.e-mcfr.ru/test присутствует на странице")
    public EduDocumentPage checkLinkServicesDocEMCFRIsPresent() {
        WebElement link = findElementByNoThrow(By.cssSelector("a[href*='services.e-mcfr.ru/test']"));
        postponedAssertTrue(link != null && link.isDisplayed(), "Ссылка на шаблон формата services.e-mcfr.ru/test не найдена");
        return this;
    }

    @Step("Проверяется, что ссылка на шаблон формата doc.e-mcfr.ru/template имеет аттрибут target=_blank (для новой вкладки)")
    public EduDocumentPage checkLinkTemplateDocEMCFRHasAttributeTargetBlank() {
        WebElement link = findElementByNoThrow(By.cssSelector("a[href*='doc.e-mcfr.ru/template']"));
        postponedAssertTrue(link != null && link.isDisplayed(), "Ссылка на шаблон формата doc.e-mcfr.ru/template/ не найдена");
        if (link != null) {
            String targetAttribute = link.getAttribute("target");
            postponedAssertTrue(!targetAttribute.isEmpty() && targetAttribute.contains("blank"), "Аттрибут target не найден для ссылки на шаблон или ссылка не ведет на новую вкладку");
        }
        return this;
    }

    @Step("Проверяется, что ссылка на шаблон формата services.e-mcfr.ru/test имеет аттрибут target=_blank (для новой вкладки)")
    public EduDocumentPage checkLinkServicesDocEMCFRHasAttributeTargetBlank() {
        WebElement link = findElementByNoThrow(By.cssSelector("a[href*='services.e-mcfr.ru/test']"));
        postponedAssertTrue(link != null && link.isDisplayed(), "Ссылка на шаблон формата services.e-mcfr.ru/test не найдена");
        if (link != null) {
            String targetAttribute = link.getAttribute("target");
            postponedAssertTrue(!targetAttribute.isEmpty() && targetAttribute.contains("blank"), "Аттрибут target не найден для ссылки на шаблон или ссылка не ведет на новую вкладку");
        }
        return this;
    }

    @Step("Нажимается ссылка на шаблон")
    public EduDocumentPage clickOnLinkTemplateDocEMCFR() {
        WebElement link = findElementByNoThrow(By.cssSelector("a[href*='doc.e-mcfr.ru/template']"));
        postponedAssertTrue(link != null && link.isDisplayed(), "Ссылка на шаблон формата doc.e-mcfr.ru/template/ не найдена");
        if (link != null) {
            String targetAttribute = link.getAttribute("target");
            if (!targetAttribute.isEmpty()) {
                report("Удаление параметра target=_blank для ссылки на шаблон");
                executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", link, "target", "_self");
                setParameter(EduDocumentPage.CURRENT_URL, getCurrentUrl());
                report("Нажимается ссылка на шаблон");
                setParameter(SearchResultHelper.DOCUMENT_URL, link.getAttribute("href"));
                link.click();
                waitForReloadingPage();
            }
        }
        return this;
    }

    @Step("Нажимается ссылка Перейти в тест")
    public EduDocumentPage clickOnLinkServicesDocEMCFR() {
        WebElement link = findElementByNoThrow(By.cssSelector("a[href*='services.e-mcfr.ru/test']"));
        postponedAssertTrue(link != null && link.isDisplayed(), "Ссылка на шаблон формата services.e-mcfr.ru/test не найдена");
        if (link != null) {
            String targetAttribute = link.getAttribute("target");
            if (!targetAttribute.isEmpty()) {
                report("Удаление параметра target=_blank для ссылки на шаблон");
                executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", link, "target", "_self");
                report("Нажимается ссылка на шаблон");
                setParameter(SearchResultHelper.DOCUMENT_URL, link.getAttribute("href"));
                link.click();
                waitForReloadingPage();
            }
        }
        return this;
    }

    @Step("Проверяется, что открылся сервис Конструктор документов")
    public EduDocumentPage checkConstructorTemplateEMCFRIsOpened() {
        WebElement pageContent = findElementByNoThrow(By.id("page-content"));
        postponedAssertTrue(pageContent != null && pageContent.isDisplayed(), "Сервис Конструктора документов не открылся");
        String expectedUrl = (String) getParameter(SearchResultHelper.DOCUMENT_URL);
        postponedAssertEquals(getCurrentUrl(), expectedUrl, "URL Конструктора документов не совпадают");
        return this;
    }

    @Step("Проверяется, что открылся сервис Тест")
    public EduDocumentPage checkTestEMCFRIsOpened() {
        WebElement pageContent = findElementByNoThrow(By.cssSelector(".content-area"));
        postponedAssertTrue(pageContent != null && pageContent.isDisplayed(), "Сервис Тест не открылся");
        String expectedUrl = (String) getParameter(SearchResultHelper.DOCUMENT_URL);
        postponedAssertEquals(getCurrentUrl(), expectedUrl, "URL Тест не совпадают");
        return this;
    }

    public EduDocumentPage checkExtendedSearchButtonIsPresent() {
        getHelper(DocumentHelper.class).checkExtendedSearchButtonIsPresent();
        return this;
    }

    public EduDocumentPage checkHelpWidgetIsPresent() {
        getHelper(DocumentHelper.class).checkHelpWidgetIsPresent();
        return this;
    }

    public EduDocumentPage checkSearchInTextWidgetIsPresent() {
        getHelper(DocumentHelper.class).checkSearchInTextWidgetIsPresent();
        return this;
    }

    public EduDocumentPage checkRevisionHistoryIsPresent() {
        getHelper(DocumentHelper.class).checkRevisionHistoryLinkIsPresent();
        return this;
    }

    public EduDocumentPage checkMoreOnTheTopicIsPresent() {
        getHelper(DocumentHelper.class).checkMoreOnTheTopicIsPresent();
        return this;
    }

    public EduDocumentPage checkPrintButtonInKodeksIsPresent() {
        getHelper(DocumentHelper.class).checkPrintButtonInKodeksIsPresent();
        return this;
    }

    public EduDocumentPage checkSendButtonIsPresentForKodeks() {
        getHelper(DocumentHelper.class).checkSendButtonIsPresentForKodeks();
        return this;
    }

    public EduDocumentPage checkBacklinksArePresent() {
        getHelper(DocumentHelper.class).checkBacklinksArePresent();
        return this;
    }

    public EduDocumentPage checkCommentsArePresent() {
        getHelper(DocumentHelper.class).checkCommentsArePresent();
        return this;
    }

    public EduDocumentPage clickOnMoreLinksFromInfobarOfTheDocument() {
        getHelper(DocumentHelper.class).clickOnMoreLinksFromInfobarOfTheDocument();
        return this;
    }

    public EduDocumentPage checkMoreLinksLinkHasYellowHighlightAfterClicking() {
        getHelper(DocumentHelper.class).checkMoreLinksLinkHasYellowHighlightAfterClicking();
        return this;
    }

    public EduDocumentPage checkMoreLinksBlockIsOpened() {
        getHelper(DocumentHelper.class).checkMoreLinksBlockIsOpened();
        return this;
    }

    public EduDocumentPage checkMoreLinksHasTitleLinks() {
        getHelper(DocumentHelper.class).checkMoreLinksHasTitleLinks();
        return this;
    }

    public EduDocumentPage clickOnMoreLinksRandomLink() {
        getHelper(DocumentHelper.class).clickOnMoreLinksRandomLink();
        return this;
    }

    public EduDocumentPage checkMoreLinksAreDuplicatedBelowOfTheDocument() {
        getHelper(DocumentHelper.class).checkMoreLinksAreDuplicatedBelowOfTheDocument();
        return this;
    }

    public EduDocumentPage clickOnLinksFromInfobarInBottom() {
        getHelper(DocumentHelper.class).clickOnLinksFromInfobarInBottom();
        return this;
    }

    public EduDocumentPage checkStickyHeaderIsGray() {
        getHelper(DocumentHelper.class).checkStickyHeaderIsGray();
        return this;
    }

    public EduDocumentPage clickOnStickyHeader() {
        getHelper(DocumentHelper.class).clickOnStickyHeader();
        return this;
    }

    public EduDocumentPage checkStickyHeaderIsNotPresent() {
        getHelper(DocumentHelper.class).checkStickyHeaderIsNotPresent();
        return this;
    }

    public EduDocumentPage checkStickyHeaderScrolling() {
        getHelper(DocumentHelper.class).checkStickyHeaderScrolling();
        return this;
    }

    public EduDocumentPage checkQuickTocHasNumbers() {
        getHelper(DocumentHelper.class).checkQuickTocHasNumbers();
        return this;
    }

    public EduDocumentPage checkQuickTocDoesNotContainItemsReferencesAndLinks() {
        getHelper(DocumentHelper.class).checkQuickTocDoesNotContainItemsReferencesAndLinks();
        return this;
    }

    public EduDocumentPage checkScrolling() {
        getHelper(DocumentHelper.class).checkScrolling();
        return this;
    }

    public EduDocumentPage clickOnRevisionHistoryLink() {
        getHelper(DocumentHelper.class).clickOnRevisionHistoryLink();
        return this;
    }

    public EduDocumentPage checkRevisionHistoryBlockIsOpened() {
        getHelper(DocumentHelper.class).checkRevisionHistoryBlockIsOpened();
        return this;
    }

    public EduDocumentPage checkRevisionHistoryTitleSpeciallyActionsIsPresent() {
        getHelper(DocumentHelper.class).checkRevisionHistoryTitleSpeciallyActionsIsPresent();
        return this;
    }

    public EduDocumentPage checkRevisionHistoryTitleContainsInDocumentIsPresent() {
        getHelper(DocumentHelper.class).checkRevisionHistoryTitleContainsInDocumentIsPresent();
        return this;
    }

    public EduDocumentPage clickOnRandomDocumentFromRevisionHistoryList() {
        getHelper(DocumentHelper.class).clickOnRandomDocumentFromRevisionHistoryList();
        return this;
    }

    public EduDocumentPage checkApplicationsWidgetIsPresent() {
        getHelper(DocumentHelper.class).checkApplicationsWidgetIsPresent();
        return this;
    }

    public EduDocumentPage clickOnInfobarApplicationsLink() {
        getHelper(DocumentHelper.class).clickOnInfobarApplicationsLink();
        return this;
    }

    public EduDocumentPage checkApplicationsTextsArePresent() {
        getHelper(AttachmentsInfobar.class).checkApplicationsTextsArePresent();
        return this;
    }

    public EduDocumentPage checkAttachedFilesAreAvailable() {
        getHelper(AttachmentsInfobar.class).checkAttachedFilesAreAvailable();
        return this;
    }

    public EduDocumentPage checkApplicationsExtensionsArePresent() {
        getHelper(AttachmentsInfobar.class).checkApplicationsExtensionsArePresent();
        return this;
    }

    @Override
    public EduDocumentPage checkVideoPlayerIsPresent() {
        getHelper(DocumentHelper.class).checkVideoPlayerIsPresent();
        return redirectTo(EduDocumentPage.class);
    }

    @Override
    public EduDocumentPage checkVideoTitleIsPresent() {
        getHelper(DocumentHelper.class).checkVideoTitleIsPresent();
        return redirectTo(EduDocumentPage.class);
    }

    @Override
    public EduDocumentPage checkCommonView118(String name) {
        getHelper(DocumentHelper.class).checkCommonView118(name);
        return this;
    }
}
