package com.actionmedia.pages.uss;

import com.actionmedia.components.info.AttachmentsInfobar;
import com.actionmedia.components.popups.NotepadPopup;
import com.actionmedia.pages.bss.BssDocumentPage;
import com.actionmedia.pages.interfaces.IDocumentPage;
import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.pages.helpers.DocumentHelper;
import org.openqa.selenium.WebElement;
import com.actionmedia.pages.interfaces.IDocumentPage;
import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.util.TestUtils;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 15.10.13
 * Time: 11:55
 */
@Component
public class UssDocumentPage extends UssBasePage<UssDocumentPage> implements IDocumentPage {

    public UssDocumentPage checkPrintButtonIsPresent() {
        getHelper(DocumentHelper.class).checkPrintButtonIsPresent();
        return this;
    }

    public UssDocumentPage checkPrintButtonInKodeksIsPresent() {
        getHelper(DocumentHelper.class).checkPrintButtonInKodeksIsPresent();
        return this;
    }

    public UssDocumentPage checkWordButtonIsPresent() {
        getHelper(DocumentHelper.class).checkWordButtonIsPresent();
        return this;
    }

    public UssDocumentPage checkWordButtonInKodeksIsPresent() {
        getHelper(DocumentHelper.class).checkWordButtonInKodeksIsPresent();
        return this;
    }

    public UssDocumentPage checkMailButtonIsPresent() {
        getHelper(DocumentHelper.class).checkMailButtonIsPresent();
        return this;
    }

    public UssDocumentPage checkMailButtonInKodeksIsPresent() {
        getHelper(DocumentHelper.class).checkMailButtonInKodeksIsPresent();
        return this;
    }

    public UssDocumentPage checkMailFormIsPresent() {
        getHelper(DocumentHelper.class).checkMailFormIsPresent();
        return this;
    }

    public UssDocumentPage checkMailFormIsNotPresent() {
        getHelper(DocumentHelper.class).checkMailFormIsNotPresent();
        return this;
    }

    public UssDocumentPage inputEmailInMailForm(String email) {
        getHelper(DocumentHelper.class).inputEmailInMailForm(email);
        return this;
    }

    public UssDocumentPage clickSendInMailForm() {
        getHelper(DocumentHelper.class).clickSendInMailForm();
        return this;
    }

    public UssDocumentPage checkErrorMessageInMailForm(String expectedErrorMessaege) {
        getHelper(DocumentHelper.class).checkErrorMessageInMailForm(expectedErrorMessaege);
        return this;
    }

    public UssDocumentPage checkInCut() {
        getHelper(DocumentHelper.class).checkInCut();
        return this;
    }

    public UssDocumentPage checkInfoBarWidget() {
        getHelper(DocumentHelper.class).checkInfoBarWidget();
        return this;
    }

    public UssDocumentPage checkInfoBarWidgetWork() {
        getHelper(DocumentHelper.class).checkInfoBarWidgetWork();
        return this;
    }

    public UssDocumentPage checkChangeHistoryWidget() {
        getHelper(DocumentHelper.class).checkChangeHistoryWidget();
        return this;
    }

    public UssDocumentPage checkScrolling() {
        getHelper(DocumentHelper.class).checkScrolling();
        return this;
    }

    public UssDocumentPage checkStickyHeader() {
        getHelper(DocumentHelper.class).checkStickyHeaderScrolling();
        return this;
    }

    public UssDocumentPage clickMailButton() {
        getHelper(DocumentHelper.class).clickMailButton();
        return this;
    }

    public UssDocumentPage clickMailButtonInKodeks() {
        getHelper(DocumentHelper.class).clickMailButtonInKodeks();
        return this;
    }

    public UssDocumentPage scrollAllDocument() {
        getHelper(DocumentHelper.class).scrollAllDocument();
        return this;
    }

    public UssDocumentPage checkTableOfContents() {
        getHelper(DocumentHelper.class).checkTableOfContents();
        return this;
    }

    public UssDocumentPage checkReferencesForChapter() {
        getHelper(DocumentHelper.class).checkReferencesForChapter();
        return this;
    }

    public UssDocumentPage checkReferencesForArticle() {
        getHelper(DocumentHelper.class).checkReferencesForArticle();
        return this;
    }

    public UssDocumentPage checkReferencesForParagraph() {
        getHelper(DocumentHelper.class).checkReferencesForParagraph();
        return this;
    }

    public UssDocumentPage checkLinksFromNotebookForChapter() {
        getHelper(DocumentHelper.class).checkLinksFromNotebookForChapter();
        return this;
    }

    public UssDocumentPage checkLinksFromNotebookForArticle() {
        getHelper(DocumentHelper.class).checkLinksFromNotebookForArticle();
        return this;
    }

    public UssDocumentPage checkLinksFromNotebookForParagraph() {
        getHelper(DocumentHelper.class).checkLinksFromNotebookForParagraph();
        return this;
    }

    public UssDocumentPage checkEditLinksForChapter() {
        getHelper(DocumentHelper.class).checkEditLinksForChapter();
        return this;
    }

    public UssDocumentPage checkEditLinksForArticle() {
        getHelper(DocumentHelper.class).checkEditLinksForArticle();
        return this;
    }

    public UssDocumentPage checkEditLinksForParagraph() {
        getHelper(DocumentHelper.class).checkEditLinksForParagraph();
        return this;
    }

    public UssDocumentPage checkDownloadButtonIsPresent() {
        getHelper(DocumentHelper.class).checkDownloadButtonIsPresent();
        return this;
    }

    public UssDocumentPage checkFormsPreview() {
        getHelper(DocumentHelper.class).checkFormsPreview();
        return this;
    }

    public UssDocumentPage checkExpiredWarningIsPresent() {
        getHelper(DocumentHelper.class).checkExpiredWarningIsPresent();
        return this;
    }

    public UssDocumentPage checkFutureWarningIsPresent() {
        getHelper(DocumentHelper.class).checkFutureWarningIsPresent();
        return this;
    }

    public UssDocumentPage checkSearchInTextWidgetIsPresent() {
        getHelper(DocumentHelper.class).checkSearchInTextWidgetIsPresent();
        return this;
    }

    public UssDocumentPage checkSearchInTextWidgetWork(boolean fullcheck) {
        getHelper(DocumentHelper.class).checkSearchInTextWidgetWork(fullcheck);
        return this;
    }

    public UssDocumentPage checkMyFavoritesRubricatorButtonIsPresent() {
        getHelper(DocumentHelper.class).checkMyFavoritesRubricatorButtonIsPresent();
        return this;
    }

    public UssDocumentPage checkAddToFavoritesButtonsForDocumentArePresent() {
        getHelper(DocumentHelper.class).checkAddToFavoritesButtonsForDocumentArePresent();
        return this;
    }

    public UssDocumentPage checkAddToFavoritesButtonForMagazinesIsPresent() {
        getHelper(DocumentHelper.class).checkAddToFavoritesButtonForMagazinesIsPresent();
        return this;
    }

    public UssDocumentPage checkAddToFavoritesButtonForMagazinesIsAbsent() {
        getHelper(DocumentHelper.class).checkAddToFavoritesButtonForMagazinesIsAbsent();
        return this;
    }

    public UssDocumentPage checkAddToFavoritesButtonIsPresent() {
        getHelper(DocumentHelper.class).checkAddToFavoritesButtonIsPresent();
        return this;
    }

    public UssDocumentPage checkAddToFavoritesButtonIsHighlighted() {
        getHelper(DocumentHelper.class).checkAddToFavoritesButtonIsHighlighted();
        return this;
    }

    public UssDocumentPage checkAddToFavoritesButtonForMagazinesIsHighlighted() {
        getHelper(DocumentHelper.class).checkAddToFavoritesButtonForMagazinesIsHighlighted();
        return this;
    }

    public UssDocumentPage checkAddedItemIsPresentInMyFavoritesMenu() {
        getHelper(DocumentHelper.class).checkAddedItemIsPresentInMyFavoritesMenu();
        return this;
    }

    public UssDocumentPage checkEmptyDocumentStub() {
        getHelper(DocumentHelper.class).checkEmptyDocumentStub();
        return this;
    }

    public UssDocumentPage checkPublicationBlockIsNotPresent() {
        getHelper(DocumentHelper.class).checkPublicationBlockIsNotPresent();
        return this;
    }

    public UssSearchResultPage returnToSearchResultPage() {
        getHelper(DocumentHelper.class).returnToSearchResultPage();
        return redirectTo(UssSearchResultPage.class);
    }

    public UssDocumentPage clickRandomAddToFavoritesForDocumentButton() {
        getHelper(DocumentHelper.class).clickRandomAddToFavoritesForDocumentButton();
        return this;
    }

    public UssDocumentPage clickRandomAddToFavoritesForMagazinesButton() {
        getHelper(DocumentHelper.class).clickRandomAddToFavoritesForMagazinesButton();
        return this;
    }

    public UssDocumentPage clickRandomAddToFavoritesButton() {
        getHelper(DocumentHelper.class).clickRandomAddToFavoritesButton();
        return this;
    }

    public UssDocumentPage checkTableOfContentsIsNotEmpty() {
        String bookUrl = String.valueOf(getParameter(UssMagazinesPage.BOOK_URL));
        getHelper(DocumentHelper.class).checkTableOfContentsIsNotEmpty(bookUrl);
        return this;
    }

    @Step("Проверяется что Шарики отображаются")
    public UssDocumentPage checkReferencesBallIsPresent() {
        WebElement document = waitForVisibilityOfElementLocatedBy(By.id("document-body"), "Документ не найден");
        List<WebElement> referencesBall = document.findElements(By.cssSelector(".references"));
        postponedAssertFalse(referencesBall.isEmpty(), "Шарики не отображаются");
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Ответы'")
    public UssDocumentPage checkSearchBoxIsPresentInDocument(String textInSearchBox) {
        checkSearchBoxIsPresent(textInSearchBox);
        return this;
    }

    @Step("Проверяется что кнопка 'Полистать' отображается")
    public UssDocumentPage checkBrowseButtonIsPresent() {
        WebElement header = getDocumentHeader();
        WebElement browserButton = findElementByNoThrow(header, By.cssSelector(".browse"));
        postponedAssertNotNull(browserButton, "Кнопка 'Полистать' не найдена");
        if (browserButton != null) {
            postponedAssertTrue(browserButton.isDisplayed(), "кнопка 'Полистать' не отображается");
            postponedAssertEquals(browserButton.getText(), "Полистать", "Неправильный текст кнопки 'Полистать'");
        }
        return this;
    }

    @Step("Проверяется что кнопка 'Полистать' не отображается")
    public UssDocumentPage checkBrowseButtonIsAbsent() {
        WebElement header = getDocumentHeader();
        WebElement browserButton = findElementByNoThrow(header, By.cssSelector(".browse"));
        postponedAssertNull(browserButton, "Кнопка 'Полистать' отображается");
        return this;
    }

    @Step("Проверяется что кнопка 'Распечатать' отображается")
    public UssDocumentPage checkPrintMagazineButtonIsPresent() {
        WebElement header = getDocumentHeader();
        WebElement browserButton = findElementByNoThrow(header, By.cssSelector(".print"));
        postponedAssertNotNull(browserButton, "Кнопка 'Распечатать' не найдена");
        postponedAssertTrue(browserButton.isDisplayed(), "кнопка 'Распечатать' не отображается");
        postponedAssertEquals(browserButton.getText(), "Распечатать", "Неправильный текст кнопки 'Распечатать'");
        return this;
    }

    @Step("Проверяется что кнопка 'Распечатать' отображается")
    public UssDocumentPage checkPrintAllMagazineButtonIsPresent() {
        WebElement header = getDocumentHeader();
        WebElement browserButton = findElementByNoThrow(header, By.id("print-journal"));
        postponedAssertNotNull(browserButton, "Кнопка 'Распечатать весь журнал' не найдена");
        postponedAssertTrue(browserButton.isDisplayed(), "кнопка 'Распечатать весь журнал' не отображается");
        postponedAssertEquals(browserButton.getText(), "Распечатать весь журнал", "Неправильный текст кнопки 'Распечатать весь журнал'");
        return this;
    }

    @Step("Проверяется что кнопка 'Распечатать' не отображается")
    public UssDocumentPage checkPrintAllMagazineButtonIsAbsent() {
        WebElement header = getDocumentHeader();
        WebElement browserButton = findElementByNoThrow(header, By.id("print-journal"));
        postponedAssertNull(browserButton, "Кнопка 'Распечатать весь журнал' отображается");
        return this;
    }

    @Step("Проверяется что кнопка 'Сохранить' отображается")
    public UssDocumentPage checkSaveButtonIsPresent() {
        WebElement header = getDocumentHeader();
        WebElement browserButton = findElementByNoThrow(header, By.cssSelector(".save"));
        postponedAssertNotNull(browserButton, "Кнопка 'Сохранить' не найдена");
        postponedAssertTrue(browserButton.isDisplayed(), "кнопка 'Сохранить' не отображается");
        postponedAssertEquals(browserButton.getText(), "Сохранить", "Неправильный текст кнопки 'Сохранить'");
        return this;
    }

    @Step("Проверяется что кнопка 'Отправить' отображается")
    public UssDocumentPage checkSendButtonIsPresent() {
        WebElement header = getDocumentHeader();
        WebElement browserButton = findElementByNoThrow(header, By.cssSelector(".mail"));
        postponedAssertNotNull(browserButton, "Кнопка 'Отправить' не найдена");
        postponedAssertTrue(browserButton.isDisplayed(), "кнопка 'Отправить' не отображается");
        postponedAssertEquals(browserButton.getText(), "Отправить", "Неправильный текст кнопки 'Отправить'");
        return this;
    }

    @Step("Проверяется что кнопка 'Отправить' отображается")
    public UssDocumentPage checkSendButtonIsPresentForKodeks() {
        WebElement header = waitForPresenceOfElementLocatedBy(By.id("document-header"), "Заголовок документа не найден");
        WebElement browserButton = findElementByNoThrow(header, By.cssSelector(".ico_content_mail"));
        postponedAssertNotNull(browserButton, "Кнопка 'Отправить' не найдена");
        postponedAssertTrue(browserButton.isDisplayed(), "Кнопка 'Отправить' не отображается");
        return this;
    }

    @Step("Проверяется что кнопка 'Отправить' не отображается")
    public UssDocumentPage checkSendButtonIsAbsent() {
        WebElement header = getDocumentHeader();
        WebElement browserButton = findElementByNoThrow(header, By.cssSelector(".mail"));
        postponedAssertNull(browserButton, "Кнопка 'Отправить' отображается");
        return this;
    }

    public UssDocumentPage checkNavigationButtonsArePresent() {
        getHelper(DocumentHelper.class).checkNavigationButtonsForMagazinesArePresent();
        return this;
    }

    public UssDocumentPage checkNavigationButtonFunctionality() {
        getHelper(DocumentHelper.class).checkNavigationButtonFunctionality();
        return this;
    }

    @Step("Проверяется что календарь отображается")
    public UssDocumentPage checkCalendarIsPresent() {
        WebElement calendar = findElementByNoThrow(mainContentElement, By.cssSelector(".b-calendar"));
        postponedAssertNotNull(calendar, "Календарь не найден");
        if (calendar != null) {
            postponedAssertTrue(calendar.isDisplayed(), "Календарь не отображается");
        }
        return this;
    }

    @Step("Проверяются элементы на календаре")
    public UssDocumentPage checkCalendarElements() {
        WebElement calendar = findElementByNoThrow(mainContentElement, By.cssSelector(".b-calendar"));
        if (calendar != null) {
            WebElement calendarBox = getDisplayedMonthBlock(calendar);
            if (calendarBox != null) {

                WebElement day = findElementByNoThrow(calendarBox, By.cssSelector(".today"));
                WebElement month = findElementByNoThrow(calendarBox, By.id("monthName"));
                WebElement year = findElementByNoThrow(calendarBox, By.id("year"));
                WebElement nextBtn = findElementByNoThrow(mainContentElement, By.id("forward"));
                WebElement prevBtn = findElementByNoThrow(mainContentElement, By.id("back"));
                WebElement workDays = findElementByNoThrow(calendarBox, By.cssSelector(".b-calendar-lh"));
                WebElement calendarDays = findElementByNoThrow(calendarBox, By.id("yearview-days-switch"));
                WebElement holidays = findElementByNoThrow(calendarBox, By.cssSelector(".red"));

                postponedAssertNotNull(day, "Текущая дата на календаре не найдена");
                postponedAssertNotNull(month, "Текущий месяц на календаре не найден");
                postponedAssertNotNull(year, "Текущий год на календаре не найден");
                postponedAssertNotNull(nextBtn, "Кнопка Следующий месяц на календаре не найдена");
                postponedAssertNotNull(prevBtn, "Кнопка Предыдущий месяц на календаре не найдена");
                postponedAssertNotNull(workDays, "Количество Рабочих дней на календаре не найдено");
                postponedAssertNotNull(calendarDays, "Количество Календарных дней на календаре не найдено ");
                postponedAssertNotNull(holidays, "Количество Выходных и праздничных дней на календаре не найдено");

                if (day != null) {
                    postponedAssertTrue(day.isDisplayed(), "Текущая дата на календаре не отображается");
                }
                if (month != null) {
                    postponedAssertTrue(month.isDisplayed(), "Текущий месяц на календаре не отображается");
                }
                if (year != null) {
                    postponedAssertTrue(year.isDisplayed(), "Текущий год на календаре не отображается");
                }
                if (nextBtn != null) {
                    postponedAssertTrue(nextBtn.isDisplayed(), "Кнопка Следующий месяц на календаре не отображается");
                }
                if (prevBtn != null) {
                    postponedAssertTrue(prevBtn.isDisplayed(), "Кнопка Предыдущий месяц на календаре не отображается");
                }
                if (workDays != null) {
                    postponedAssertTrue(workDays.isDisplayed(), "Количество Рабочих дней на календаре не отображается");
                }
                if (calendarDays != null) {
                    postponedAssertTrue(calendarDays.isDisplayed(), "Количество Календарных дней на календаре не отображается");
                }
                if (holidays != null) {
                    postponedAssertTrue(holidays.isDisplayed(), "Количество Выходных и праздничных дней на календаре не отображается");
                }
            } else {
                setPostponedTestFail("Текущий месяц не отображается на календаре");
            }
        } else {
            setPostponedTestFail("Календарь не найден");
        }
        return this;
    }

    @Step("Проверяется что отображается правильная дата в календаре")
    public UssDocumentPage checkCurrentDate() {
        WebElement calendar = findElementByNoThrow(mainContentElement, By.cssSelector(".b-calendar"));
        if (calendar != null) {
            WebElement monthBlock = getDisplayedMonthBlock(calendar);
            if (monthBlock != null) {
                String day = monthBlock.findElement(By.cssSelector(".today")).getText().trim();
                String month = monthBlock.findElement(By.id("monthName")).getText().trim();
                String year = monthBlock.findElement(By.id("year")).getText().trim();

                Date dateStr = TestUtils.parseDate(String.format("%s %s %s", day, month, year), "dd MMM yyyy");
                Date currentDate = new Date();
                postponedAssertTrue(dateStr.getDate() == currentDate.getDate(), "Выбран неправильный день в календаре");
                postponedAssertTrue(dateStr.getMonth() == currentDate.getMonth(), "Выбран неправильный месяц в календаре");
                postponedAssertTrue(dateStr.getYear() == currentDate.getYear(), "Выбран неправильный год в календаре");
            } else {
                setPostponedTestFail("Текущий месяц не отображается на календаре");
            }
        } else {
            setPostponedTestFail("Календарь не найден");
        }
        return this;
    }

    public UssDocumentPage checkCurrentItemIsHighlightedInTableOfContents() {
        getHelper(DocumentHelper.class).checkCurrentItemIsHighlightedInTableOfContents();
        return this;
    }

    public UssDocumentPage checkSelectedArticleIsOpened() {
        getHelper(DocumentHelper.class).checkSelectedArticleIsOpened();
        return this;
    }

    public UssDocumentPage checkMagazineNameIsPresent() {
        getHelper(DocumentHelper.class).checkMagazineNameIsPresent();
        return this;
    }

    public UssDocumentPage checkListOfArticlesOnMainMagazinesPageArePresent() {
        getHelper(DocumentHelper.class).checkListOfArticlesOnMainMagazinesPageArePresent();
        return this;
    }

    public UssDocumentPage checkMagazineNumberIsPresent() {
        getHelper(DocumentHelper.class).checkMagazineNumberIsPresent();
        return this;
    }

    public UssDocumentPage checkAuthFormIsPresent() {
        getHelper(DocumentHelper.class).checkAuthFormIsPresent();
        return this;
    }

    public UssDocumentPage clickTableOfContentsButton() {
        getHelper(DocumentHelper.class).clickTableOfContentsButton();
        return this;
    }

    public UssDocumentPage clickRandomArticleFromTableOfContents() {
        getHelper(DocumentHelper.class).clickRandomArticleFromTableOfContents();
        return this;
    }

    public UssDocumentPage clickRandomArticleFromMagazinesMainPage() {
        getHelper(DocumentHelper.class).clickRandomArticleFromMagazinesMainPage();
        return this;
    }

    private WebElement getDisplayedMonthBlock(WebElement calendar) {
        List<WebElement> elementList = calendar.findElements(By.cssSelector(".month-block"));
        for (WebElement element : elementList) {
            if (element.isDisplayed()) {
                return element;
            }
        }
        return null;
    }

    public UssDocumentPage clickRandomArticle() {
        getHelper(DocumentHelper.class).clickRandomArticle();
        return this;
    }

    public UssDocumentPage clickInformationLink() {
        getHelper(DocumentHelper.class).clickInformationLink();
        return this;
    }

    private WebElement getDocumentHeader() {
        return waitForVisibilityOfElementLocatedBy(By.cssSelector(".e-header"), "Заголовок документа не найден");
    }

    public UssDocumentPage checkBooksNameAndAuthor() {
        getHelper(DocumentHelper.class).checkBooksNameAndAuthor();
        return this;
    }

    public UssDocumentPage checkImageBook() {
        getHelper(DocumentHelper.class).checkImageBook();
        return this;
    }

    public UssDocumentPage checkNameDocument() {
        getHelper(DocumentHelper.class).checkNameDocument();
        return this;
    }

    public UssDocumentPage checkDisplayStars() {
        getHelper(DocumentHelper.class).checkDisplayStars();
        return this;
    }

    public UssDocumentPage checkDisplayTextDocumentInParagraphs() {
        getHelper(DocumentHelper.class).checkDisplayTextDocumentInParagraphs();
        return this;
    }

    public UssDocumentPage checkInMyFavoritesIcon() {
        getHelper(DocumentHelper.class).checkInMyFavoritesIcon();
        return this;
    }

    public UssDocumentPage checkPrintIcon() {
        getHelper(DocumentHelper.class).checkPrintIcon();
        return this;
    }

    public UssDocumentPage checkBackwardIcon() {
        getHelper(DocumentHelper.class).checkBackwardIcon();
        return this;
    }

    public UssDocumentPage checkForwardIcon() {
        getHelper(DocumentHelper.class).checkForwardIcon();
        return this;
    }

    public UssDocumentPage checkBrowseIcon() {
        getHelper(DocumentHelper.class).checkBrowseIcon();
        return this;
    }

    @Step("Проверяется что кнопка 'Обсудить' отображается")
    public UssDocumentPage checkRubricatorButtonIsPresent(String buttonName) {
        getHelper(DocumentHelper.class).checkRubricatorButtonIsPresent(buttonName);
        return this;
    }

    @Step("Проверяется что кнопка 'Обсудить' отображается")
    public UssDocumentPage checkCommentsRubricatorButtonIsPresent(String buttonName) {
        WebElement rubricatorButton = waitForPresenceOfElementLocatedBy(By.id("comments-btn"), "Кнопка '" + buttonName + "' Отсутствует");
        postponedAssertEquals(rubricatorButton.getText(), buttonName, "Неправильный текст кнопки '" + buttonName + "'");
        return this;
    }

    public UssDocumentPage checkTableOfContentsButtonIsPresent(){
        getHelper(DocumentHelper.class).checkTableOfContentsButtonIsPresent();
        return this;
    }

    public UssDocumentPage checkSoderButtonIsPresent() {
        getHelper(DocumentHelper.class).checkSoderButtonIsPresent();
        return this;
    }

    public UssDocumentPage checkBooksName() {
        getHelper(DocumentHelper.class).checkBooksName();
        return this;
    }

    public UssDocumentPage checkAuthor() {
        getHelper(DocumentHelper.class).checkAuthor();
        return this;
    }

    public UssDocumentPage checkDisplayTableOfContents() {
        getHelper(DocumentHelper.class).checkDisplayTableOfContents();
        return this;
    }

    public UssDocumentPage checkDisplayDescriptionList() {
        getHelper(DocumentHelper.class).checkDisplayDescriptionList();
        return this;
    }

    public UssDocumentPage checkShareIcon() {
        getHelper(DocumentHelper.class).checkShareIcon();
        return this;
    }

    public UssDocumentPage checkDisplayNameJournal() {
        getHelper(DocumentHelper.class).checkDisplayNameJournal();
        return this;
    }

    public UssDocumentPage checkPudDateJournal() {
        getHelper(DocumentHelper.class).checkPudDateJournal();
        return this;
    }

    public UssDocumentPage checkArticleTitle() {
        getHelper(DocumentHelper.class).checkArticleTitle();
        return this;
    }

    public UssDocumentPage checkRSSTitle(String expectedRssTitle) {
        getHelper(DocumentHelper.class).checkRSSTitle(expectedRssTitle);
        return this;
    }

    public UssDocumentPage checkDisplayTextInJournal() {
        getHelper(DocumentHelper.class).checkDisplayTextInJournal();
        return this;
    }

    public UssDocumentPage checkDisplayNameJournal_119() {
        getHelper(DocumentHelper.class).checkDisplayNameJournal_119();
        return this;
    }

    public UssDocumentPage checkArticleTitle_119() {
        getHelper(DocumentHelper.class).checkArticleTitle_119();
        return this;
    }

    public UssDocumentPage checkDisplayTextDocumentInParagraphs_119() {
        getHelper(DocumentHelper.class).checkDisplayNameJournal_119();
        return this;
    }

    public UssDocumentPage checkDisplayStarsSection() {
        getHelper(DocumentHelper.class).checkDisplayStarsSection();
        return this;
    }

    public UssDocumentPage checkDisplayNameJournal_192() {
        getHelper(DocumentHelper.class).checkDisplayNameJournal_192();
        return this;
    }

    public UssDocumentPage checkNumberJournal_192() {
        getHelper(DocumentHelper.class).checkNumberJournal_192();
        return this;
    }

    public UssDocumentPage checkDisplayTableOfContents_192() {
        getHelper(DocumentHelper.class).checkDisplayTableOfContents_192();
        return this;
    }

    public UssDocumentPage checkNameAndNumberJournal() {
        getHelper(DocumentHelper.class).checkNameAndNumberJournal();
        return this;
    }

    public UssDocumentPage checkSearchIn() {
        getHelper(DocumentHelper.class).checkSearchIn();
        return this;
    }

    public UssDocumentPage checkRevisionIsValidFrom() {
        getHelper(DocumentHelper.class).checkRevisionIsValidFrom();
        return this;
    }

    public UssDocumentPage checkMenu() {
        getHelper(DocumentHelper.class).checkMenu();
        return this;
    }

    public UssDocumentPage checkDisplayStarsTable() {
        getHelper(DocumentHelper.class).checkDisplayStarsTable();
        return this;
    }

    public UssDocumentPage checkNotPresentShareIcon() {
        getHelper(DocumentHelper.class).checkNotPresentShareIcon();
        return this;
    }

    public UssDocumentPage checkDisplayCover() {
        getHelper(DocumentHelper.class).checkDisplayCover();
        return this;
    }

    public UssDocumentPage checkVideoPlayerParts() {
        getHelper(DocumentHelper.class).checkVideoPlayerParts();
        return this;
    }

    public UssDocumentPage checkQuickToc() {
        getHelper(DocumentHelper.class).checkQuickToc();
        return this;
    }

    public UssDocumentPage checkQuickTocScroll() {
        getHelper(DocumentHelper.class).checkQuickTocScroll();
        return this;
    }

    public UssDocumentPage checkFooter(){
        getHelper(DocumentHelper.class).checkFooter();
        return this;
    }

    public UssDocumentPage checkTitleOfFormImage(){
        getHelper(DocumentHelper.class).checkTitleOfFormImage();
        return this;
    }

    public UssDocumentPage checkFormGaleryOpen(){
        getHelper(DocumentHelper.class).checkFormGaleryOpen();
        return this;
    }

    public UssDocumentPage checkCommonView118(String name){
        getHelper(DocumentHelper.class).checkCommonView118(name);
        return this;
    }

    public UssDocumentPage checkCommonView140(){
        getHelper(DocumentHelper.class).checkCommonView140();
        return this;
    }

    public UssDocumentPage checkAsNeedBlock(){
        getHelper(DocumentHelper.class).checkAsNeedBlock();
        return this;
    }

    public UssDocumentPage checkFormComments(){
        getHelper(DocumentHelper.class).checkFormComments();
        return this;
    }

    public UssDocumentPage checkCommonViewForms(){
        getHelper(DocumentHelper.class).checkCommonViewForms();
        return this;
    }

    public UssDocumentPage checkParentDocumentLinkIsPresent(){
        getHelper(DocumentHelper.class).checkParentDocumentLinkIsPresent();
        return this;
    }

    public UssDocumentPage checkParentDocumentLinkFormat(String expectedDocType){
        getHelper(DocumentHelper.class).checkParentDocumentLinkFormat(expectedDocType);
        return this;
    }

    public UssDocumentPage checkParentDocumentLinkIsItalicStyle(){
        getHelper(DocumentHelper.class).checkParentDocumentLinkIsItalicStyle();
        return this;
    }

    public UssDocumentPage checkParentDocumentLinkInBottom(){
        getHelper(DocumentHelper.class).checkParentDocumentLinkInBottom();
        return this;
    }

    public UssDocumentPage clickParentDocumentLink(){
        getHelper(DocumentHelper.class).clickParentDocumentLink();
        return this;
    }

    public UssDocumentPage checkParentDocumentTitle(){
        getHelper(DocumentHelper.class).checkParentDocumentTitle();
        return this;
    }

    public UssDocumentPage checkDocumentIsOpened() {
        getHelper(DocumentHelper.class).checkDocumentIsOpened();
        return this;
    }

    @Override
    public UssDocumentPage checkDownloadShowExamplesLinkIsNotPresent() {
        getHelper(DocumentHelper.class).checkDownloadShowExamplesLinkIsNotPresent();
        return this;
    }

    @Override
    public UssDocumentPage checkDownloadShowExampleLinkIsNotPresent() {
        getHelper(DocumentHelper.class).checkDownloadShowExampleLinkIsNotPresent();
        return this;
    }

    public UssDocumentPage checkWarningPanelIsLocatedAboveThanHeader() {
        getHelper(DocumentHelper.class).checkWarningPanelIsLocatedAboveThanHeader();
        return this;
    }

    public UssDocumentPage checkWarningPanelWidthIsEqualsBrowserWidth() {
        getHelper(DocumentHelper.class).checkWarningPanelWidthIsEqualsBrowserWidth();
        return this;
    }

    public UssDocumentPage checkWarningPanelIsYellow() {
        getHelper(DocumentHelper.class).checkWarningPanelIsYellow();
        return this;
    }

    public UssDocumentPage checkWarningPanelHasText(String text) {
        getHelper(DocumentHelper.class).checkWarningPanelHasText(text);
        return this;
    }

    public UssDocumentPage checkWarningPanelHasLink(String textLink) {
        getHelper(DocumentHelper.class).checkWarningPanelHasLink(textLink);
        return this;
    }

    public UssDocumentPage checkWarningPanelDemoLinkIsOpened() {
        getHelper(DocumentHelper.class).checkWarningPanelDemoLinkIsOpened();
        return this;
    }

    public UssDocumentPage checkDocumentHasTitleWithoutBody() {
        getHelper(DocumentHelper.class).checkDocumentHasTitleWithoutBody();
        return this;
    }

    public UssDocumentPage checkTryTrialFormIsPresent() {
        getHelper(DocumentHelper.class).checkTryTrialFormIsPresent();
        return this;
    }

    public UssDocumentPage checkArrowsInSearchInText(String query) {
        getHelper(DocumentHelper.class).checkArrowsInSearchInText(query);
        return this;
    }

    public UssDocumentPage checkDocumentSearchWithNoResult() {
        getHelper(DocumentHelper.class).checkDocumentSearchWithNoResult();
        return this;
    }

    public UssDocumentPage checkVersionsBlockForDictionaryDocumentIsPresent() {
        getHelper(DocumentHelper.class).checkVersionsBlockForDictionaryDocumentIsPresent();
        return this;
    }

    public UssDocumentPage checkOtherVersionsForDictionaryDocumentIsPresent() {
        getHelper(DocumentHelper.class).checkOtherVersionsForDictionaryDocumentIsPresent();
        return this;
    }

    public UssDocumentPage checkExpiredVersionsForDictionaryDocumentIsPresent() {
        getHelper(DocumentHelper.class).checkExpiredVersionsForDictionaryDocumentIsPresent();
        return this;
    }

    public UssDocumentPage checkCurrentItemIsHighlightedInTableOfContentsForKodeks() {
        getHelper(DocumentHelper.class).checkCurrentItemIsHighlightedInTableOfContentsForKodeks();
        return this;
    }

    public UssDocumentPage checkTableOfContentsButtonIsPressed() {
        getHelper(DocumentHelper.class).checkTableOfContentsButtonIsPressed();
        return this;
    }

    public UssDocumentPage checkTableOfContentsButtonIsUnPressed() {
        getHelper(DocumentHelper.class).checkTableOfContentsButtonIsUnPressed();
        return this;
    }

    public UssDocumentPage clickDocumentHeader() {
        getHelper(DocumentHelper.class).clickDocumentHeader();
        return this;
    }

    public UssDocumentPage checkDisplayTableOfContentsForKodeks() {
        getHelper(DocumentHelper.class).checkDisplayTableOfContentsForKodeks();
        return this;
    }

    public UssDocumentPage clickAboutBookButton() {
        getHelper(DocumentHelper.class).clickAboutBookButton();
        return this;
    }

    public UssDocumentPage checkAboutBookBlock() {
        getHelper(DocumentHelper.class).checkAboutBookBlock();
        return this;
    }

    public UssDocumentPage setBrowserSize(int width, int height) {
        getHelper(DocumentHelper.class).setBrowserSize(width, height);
        return this;
    }

    public UssDocumentPage checkSizeOfAboutBookBlockIsNotChanged() {
        getHelper(DocumentHelper.class).checkSizeOfAboutBookBlockIsNotChanged();
        return this;
    }

    public UssDocumentPage checkDocumentContainsText(String expectedText) {
        getHelper(DocumentHelper.class).checkDocumentContainsText(expectedText);
        return this;
    }

    public UssDocumentPage checkDocumentIsNotEmpty() {
        getHelper(DocumentHelper.class).checkDocumentIsNotEmpty();
        return this;
    }

    public UssDocumentPage checkExtendedSearchButtonIsPresent(){
        getHelper(DocumentHelper.class).checkExtendedSearchButtonIsPresent();
        return this;
    }

    public UssDocumentPage checkHelpWidgetIsPresent(){
        getHelper(DocumentHelper.class).checkHelpWidgetIsPresent();
        return this;
    }

    public UssDocumentPage checkTitleAndAuthorInformationPresent(){
        getHelper(DocumentHelper.class).checkTitleAndAuthorInformationPresent();
        return this;
    }

    public UssDocumentPage checkContentIsPresent(){
        getHelper(DocumentHelper.class).checkContentIsPresent();
        return this;
    }

    public UssDocumentPage checkSoderIsPresent(){
        getHelper(DocumentHelper.class).checkSoderIsPresent();
        return this;
    }

    public UssDocumentPage checkCommentsRubricatorButtonIsPresent(){
        getHelper(DocumentHelper.class).checkCommentsRubricatorButtonIsPresent();
        return this;
    }

    public UssDocumentPage checkDocumentRatingIsPresent(){
        getHelper(DocumentHelper.class).checkDocumentRatingIsPresent();
        return this;
    }

    public UssDocumentPage checkCurrencyDocument() {
        getHelper(DocumentHelper.class).checkCurrencyDocument();
        return this;
    }

    public UssDocumentPage selectFirstCurrencyByCode(String code) {
        getHelper(DocumentHelper.class).selectFirstCurrencyByCode(code);
        return this;
    }

    public UssDocumentPage selectSecondCurrencyByCode(String code) {
        getHelper(DocumentHelper.class).selectSecondCurrencyByCode(code);
        return this;
    }

    public UssDocumentPage clickChangeCurrencyOrderButton() {
        getHelper(DocumentHelper.class).clickChangeCurrencyOrderButton();
        return this;
    }

    public UssDocumentPage checkFirstCurrencyLabel(String code) {
        getHelper(DocumentHelper.class).checkFirstCurrencyLabel(code);
        return this;
    }

    public UssDocumentPage checkSecondCurrencyLabel(String code) {
        getHelper(DocumentHelper.class).checkSecondCurrencyLabel(code);
        return this;
    }

    public UssDocumentPage checkTableCourseLabel(String codeFirstCurrency, String codeSecondCurrency) {
        getHelper(DocumentHelper.class).checkTableCourseLabel(codeFirstCurrency, codeSecondCurrency);
        return this;
    }

    public UssDocumentPage checkLastCourseTableIsChanged() {
        getHelper(DocumentHelper.class).checkLastCourseTableIsChanged();
        return this;
    }

    public UssDocumentPage setLastCourseTableToParameter() {
        getHelper(DocumentHelper.class).setLastCourseTableToParameter();
        return this;
    }

    public UssDocumentPage clickDocumentInfobarLink() {
        getHelper(DocumentHelper.class).clickDocumentInfobarLink();
        return this;
    }

    public UssDocumentPage checkTextDocumentEditionFrom() {
        getHelper(DocumentHelper.class).checkTextDocumentEditionFrom();
        return this;
    }

    public UssDocumentPage checkDocumentIsBlurred() {
        getHelper(DocumentHelper.class).checkDocumentIsBlurred();
        return this;
    }

    public UssDocumentPage checkDocPreviewTextStatus() {
        getHelper(DocumentHelper.class).checkDocPreviewTextStatus();
        return this;
    }

    public UssDocumentPage checkTryTrialForm() {
        getHelper(DocumentHelper.class).checkTryTrialForm();
        return this;
    }

    public UssDocumentPage checkSubscribeActivationFormIsPresent() {
        getHelper(DocumentHelper.class).checkSubscribeActivateFormIsPresent();
        return this;
    }

    public UssDocumentPage checkSubscribeActivationForm() {
        getHelper(DocumentHelper.class).checkSubscribeActivationFormCellPhoneNumberIsPresent();
        return this;
    }

    public UssDocumentPage checkDocBriefIsPresent(String brief) {
        getHelper(DocumentHelper.class).checkDocBriefIsPresent(brief);
        return this;
    }

    public UssDocumentPage checkBacklinksArePresent() {
        getHelper(DocumentHelper.class).checkBacklinksArePresent();
        return this;
    }

    public UssDocumentPage checkBacklinkHasCssStyles() {
        getHelper(DocumentHelper.class).checkBacklinkHasCssStyles();
        return this;
    }

    public UssDocumentPage clickOnBacklinkWithReferencesCount(int count) {
        getHelper(DocumentHelper.class).clickOnBacklinkWithReferencesCount(count);
        return this;
    }

    public UssDocumentPage checkNotepadPopupIsPresent() {
        getHelper(NotepadPopup.class).checkPopupIsPresent();
        return this;
    }

    public UssDocumentPage checkParagraphAndButtonAreYellow() {
        getHelper(DocumentHelper.class).checkParagraphAndButtonAreYellow();
        return this;
    }

    public UssDocumentPage checkParagraphAndButtonAreNotYellow() {
        getHelper(DocumentHelper.class).checkParagraphAndButtonAreNotYellow();
        return this;
    }

    /**
     * @param phraseAnchor - the part of link in the data-anchor attribute for the tag 'a'
     *                     example: <a data-anchor="/document/99/9027690/bssPhr143/"...,
     *                     for this, phraseAnchor = bssPhr143
     */
    public UssDocumentPage clickOnRequiredArticleBacklink(String phraseAnchor) {
        getHelper(DocumentHelper.class).clickOnRequiredArticleBacklink(phraseAnchor);
        return this;
    }

    public UssDocumentPage checkNotepadPopupHasShadow() {
        getHelper(NotepadPopup.class).checkPopupHasShadow();
        return this;
    }

    public UssDocumentPage checkNotepadPopupHeaderIsWhite() {
        getHelper(NotepadPopup.class).checkHeaderIsWhite();
        return this;
    }

    public UssDocumentPage checkNotepadPopupTitleIsPresent() {
        getHelper(NotepadPopup.class).checkTitleIsPresent();
        return this;
    }

    public UssDocumentPage checkNotepadPopupCloseIconIsPresent() {
        getHelper(NotepadPopup.class).checkCloseIconIsPresent();
        return this;
    }

    public UssDocumentPage checkNotepadPopupBodyIsYellow() {
        getHelper(NotepadPopup.class).checkBodyIsYellow();
        return this;
    }

    public UssDocumentPage checkNotepadPopupBodyHasBacklinks() {
        getHelper(NotepadPopup.class).checkBodyHasBacklinks();
        return this;
    }

    public UssDocumentPage checkNotepadPopupIsNotPresent() {
        getHelper(NotepadPopup.class).checkPopupIsNotPresent();
        return this;
    }

    public UssDocumentPage clickOnNotepadPopupCloseButton() {
        getHelper(NotepadPopup.class).clickOnCloseButton();
        return this;
    }

    public UssDocumentPage checkNotepadPopupMenuBlockIsPresent() {
        getHelper(NotepadPopup.class).checkMenuBlockIsPresent();
        return this;
    }

    public UssDocumentPage checkNotepadPopupMenuBlockIsNotPresent() {
        getHelper(NotepadPopup.class).checkMenuBlockIsNotPresent();
        return this;
    }

    public UssDocumentPage checkNotepadPopupMenuItemsInOrder(NotepadPopup.Item... items) {
        getHelper(NotepadPopup.class).checkMenuItemsInOrder(items);
        return this;
    }

    public UssDocumentPage checkNotepadPopupMenuItemIcon(NotepadPopup.Item... items) {
        getHelper(NotepadPopup.class).checkMenuItemIcon(items);
        return this;
    }

    public UssDocumentPage hoverOnNotepadPopupMenuItem(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).hoverOnMenuItem(item);
        return this;
    }

    public UssDocumentPage checkNotepadPopupMenuItemIsRed(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).checkMenuItemIsRed(item);
        return this;
    }

    public UssDocumentPage clickOnNotepadPopupMenu(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).clickOnMenu(item);
        return this;
    }

    public UssDocumentPage checkNotepadPopupMenuItemHasRightName(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).checkMenuItemHasRightName(item);
        return this;
    }

    public UssDocumentPage checkNotepadPopupMenuItemIsYellow(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).checkMenuItemIsYellow(item);
        return this;
    }

    public UssDocumentPage checkNotepadPopupMenuItemIsNotRed(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).checkMenuItemIsNotRed(item);
        return this;
    }

    public UssDocumentPage checkNotepadPopupScrollTo(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).checkScrollTo(item);
        return this;
    }

    public UssDocumentPage checkNotepadPopupMenuItemIsSelectedAfterScrolling(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).checkMenuItemIsSelectedAfterScrolling(item);
        return this;
    }

    public UssDocumentPage checkNotepadPopupTitleHasWhiteSpaceCSSValue() {
        getHelper(NotepadPopup.class).checkTitleHasWhiteSpaceCSSValue();
        return this;
    }

    public UssDocumentPage checkNotepadTitleEqualsWithPhraseTitle(String phraseAnchor) {
        getHelper(NotepadPopup.class).checkTitle(phraseAnchor);
        return this;
    }

    public UssDocumentPage checkNotepadTitleContainsWord(String phraseAnchor, String word) {
        getHelper(NotepadPopup.class).checkTitleContainsWord(phraseAnchor, word);
        return this;
    }

    public UssDocumentPage checkNotepadTitleIsAdditionalInformation() {
        getHelper(NotepadPopup.class).checkTitleIsAdditionalInformation();
        return this;
    }

    public UssDocumentPage clickOnBackLinkFromTitle() {
        getHelper(DocumentHelper.class).clickOnBackLinkFromTitle();
        return this;
    }

    public UssDocumentPage checkNotepadPopupRecomendationBlockFirstItemHasPhotoFullNameAndPosition() {
        getHelper(NotepadPopup.class).checkRecomendationBlockFirstItemHasPhotoFullNameAndPosition();
        return this;
    }

    public UssDocumentPage checkNotepadPopupRecomentdationBlockHasNoMoreThan10Links() {
        getHelper(NotepadPopup.class).checkRecomentdationBlockHasNoMoreThan10Links();
        return this;
    }

    public UssDocumentPage checkNotepadPopupRecomendationBlockHasLinks() {
        getHelper(NotepadPopup.class).checkRecomendationBlockHasLinks();
        return this;
    }

    public UssDocumentPage checkNotepadPopupFormsBlockHasLinks() {
        getHelper(NotepadPopup.class).checkFormsBlockHasLinks();
        return this;
    }

    public UssDocumentPage checkNotepadPopupFormsBlockHasNoMoreThan10Links() {
        getHelper(NotepadPopup.class).checkFormsBlockHasNoMoreThan10Links();
        return this;
    }

    public UssDocumentPage checkNotepadPopupHandbookBlockHasLinks() {
        getHelper(NotepadPopup.class).checkHandbookBlockHasLinks();
        return this;
    }

    public UssDocumentPage checkNotepadPopupHandbookBlockHasNoMoreThan10Links() {
        getHelper(NotepadPopup.class).checkHandbookBlockHasNoMoreThan10Links();
        return this;
    }

    public UssDocumentPage checkNotepadPopupPressBlockHasItems() {
        getHelper(NotepadPopup.class).checkPressBlockHasItems();
        return this;
    }

    public UssDocumentPage checkNotepadPopupPressBlockHasNoMoreThan10Links() {
        getHelper(NotepadPopup.class).checkPressBlockHasNoMoreThan10Links();
        return this;
    }

    public UssDocumentPage checkNotepadPopupLawBlockHasLinks() {
        getHelper(NotepadPopup.class).checkLawBlockHasLinks();
        return this;
    }

    public UssDocumentPage checkNotepadPopupLawBlockHasNoMoreThan10Links() {
        getHelper(NotepadPopup.class).checkLawBlockHasNoMoreThan10Links();
        return this;
    }

    public UssDocumentPage checkNotepadPopupLawPracticeBlockHasLinks() {
        getHelper(NotepadPopup.class).checkLawPracticeBlockHasLinks();
        return this;
    }

    public UssDocumentPage checkNotepadPopupLawPracticeBlockHasNoMoreThan10Links() {
        getHelper(NotepadPopup.class).checkLawPracticeBlockHasNoMoreThan10Links();
        return this;
    }

    public UssDocumentPage hoverOnNotepadPopupFirstLinkFromLawPractice() {
        getHelper(NotepadPopup.class).hoverOnFirstLinkFromLawPractice();
        return this;
    }

    public UssDocumentPage checkNotepadPopupFirstLinkFromLawPracticeBecomeRedAfterHoverOn() {
        getHelper(NotepadPopup.class).checkFirstLinkFromLawPracticeBecomeRedAfterHoverOn();
        return this;
    }

    public UssDocumentPage clickOnNotepadPopupFormsBlockRandomLink() {
        getHelper(NotepadPopup.class).clickOnFormsBlockRandomLink();
        return this;
    }

    public UssDocumentPage clickOnNotepadPopupHandbookBlockRandomLink() {
        getHelper(NotepadPopup.class).clickOnHandbookBlockRandomLink();
        return this;
    }

    public UssDocumentPage clickOnNotepadPopupLawBlockRandomLink() {
        getHelper(NotepadPopup.class).clickOnLawBlockRandomLink();
        return this;
    }

    public UssDocumentPage clickOnNotepadPopupPressBlockRandomLink() {
        getHelper(NotepadPopup.class).clickOnPressBlockRandomLink();
        return this;
    }

    public UssDocumentPage clickOnNotepadPopupLawPracticeBlockRandomLink() {
        getHelper(NotepadPopup.class).clickOnLawPracticeBlockRandomLink();
        return this;
    }

    public UssDocumentPage clickOnNotepadPopupRecomendationBlockRandomLink() {
        getHelper(NotepadPopup.class).clickOnRecomendationBlockRandomLink();
        return this;
    }

    public UssDocumentPage checkVideoVersionIsPresent() {
        getHelper(DocumentHelper.class).checkVideoVersionIsPresent();
        return this;
    }

    public UssDocumentPage checkVideoPlayerIsPresent() {
        getHelper(DocumentHelper.class).checkVideoPlayerIsPresent();
        return this;
    }

    public UssDocumentPage checkNavigationButtonsForVideoArePresent() {
        getHelper(DocumentHelper.class).checkNavigationButtonsForVideoArePresent();
        return this;
    }

    public UssDocumentPage checkVideoTitleIsPresent() {
        getHelper(DocumentHelper.class).checkVideoTitleIsPresent();
        return this;
    }

    public UssDocumentPage checkVideoPartTitleIsPresent() {
        getHelper(DocumentHelper.class).checkVideoPartTitleIsPresent();
        return this;
    }

    public UssDocumentPage checkVideoPartsArePresent() {
        getHelper(DocumentHelper.class).checkVideoPartsArePresent();
        return this;
    }

    public UssDocumentPage checkActivePartHasPlayButton() {
        getHelper(DocumentHelper.class).checkActivePartHasPlayButton();
        return this;
    }

    public UssDocumentPage clickOnPrevButtonInTopMenu() {
        getHelper(DocumentHelper.class).clickOnPrevButtonInTopMenu();
        return this;
    }

    public UssDocumentPage clickOnNextButtonInTopMenu() {
        getHelper(DocumentHelper.class).clickOnNextButtonInTopMenu();
        return this;
    }

    public UssDocumentPage clickOnPreviousButtonInBottomMenu() {
        getHelper(DocumentHelper.class).clickOnPreviousButtonInBottomMenu();
        return this;
    }

    public UssDocumentPage clickOnNextButtonInBottomMenu() {
        getHelper(DocumentHelper.class).clickOnNextButtonInBottomMenu();
        return this;
    }

    public UssDocumentPage checkNextAndPrevButtonsInTopMenuArePresent() {
        getHelper(DocumentHelper.class).checkNextAndPrevButtonsInTopMenuArePresent();
        return this;
    }

    public UssDocumentPage checkNextAndPrevButtonsInBottomMenuArePresent() {
        getHelper(DocumentHelper.class).checkNextAndPrevButtonsInBottomMenuArePresent();
        return this;
    }

    public UssDocumentPage checkPrevButtonInTopIsAbsent() {
        getHelper(DocumentHelper.class).checkButtonPreviousInTopMenuIsNotPresent();
        return this;
    }

    public UssDocumentPage checkNextButtonInTopIsAbsent() {
        getHelper(DocumentHelper.class).checkButtonNextInTopMenuIsNotPresent();
        return this;
    }

    public UssDocumentPage checkNextButtonInBottomIsAbsent() {
        getHelper(DocumentHelper.class).checkButtonNextInBottomMenuIsNotPresent();
        return this;
    }

    public UssDocumentPage checkPrevButtonInBottomIsAbsent() {
        getHelper(DocumentHelper.class).checkButtonPreviousInBottomMenuIsNotPresent();
        return this;
    }

    public UssDocumentPage clickFirstArticleFromTableOfContents() {
        getHelper(DocumentHelper.class).clickFirstArticleFromTableOfContents();
        return this;
    }

    public UssDocumentPage clickLastArticleFromTableOfContents() {
        getHelper(DocumentHelper.class).clickLastArticleFromTableOfContents();
        return this;
    }

    public UssDocumentPage checkMoreOnTheTopicIsPresent() {
        getHelper(DocumentHelper.class).checkMoreOnTheTopicIsPresent();
        return this;
    }

    public UssDocumentPage checkCommentsArePresent() {
        getHelper(DocumentHelper.class).checkCommentsArePresent();
        return this;
    }

    public UssDocumentPage checkRevisionHistoryIsPresent() {
        getHelper(DocumentHelper.class).checkRevisionHistoryLinkIsPresent();
        return this;
    }

    public UssDocumentPage clickOnRevisionHistoryLink() {
        getHelper(DocumentHelper.class).clickOnRevisionHistoryLink();
        return this;
    }

    public UssDocumentPage checkRevisionHistoryBlockIsOpened() {
        getHelper(DocumentHelper.class).checkRevisionHistoryBlockIsOpened();
        return this;
    }

    public UssDocumentPage checkRevisionHistoryTitleSpeciallyActionsIsPresent() {
        getHelper(DocumentHelper.class).checkRevisionHistoryTitleSpeciallyActionsIsPresent();
        return this;
    }

    public UssDocumentPage checkRevisionHistoryTitleContainsInDocumentIsPresent() {
        getHelper(DocumentHelper.class).checkRevisionHistoryTitleContainsInDocumentIsPresent();
        return this;
    }

    public UssDocumentPage clickOnRandomDocumentFromRevisionHistoryList() {
        getHelper(DocumentHelper.class).clickOnRandomDocumentFromRevisionHistoryList();
        return this;
    }

    public UssDocumentPage clickOnMoreLinksFromInfobarOfTheDocument() {
        getHelper(DocumentHelper.class).clickOnMoreLinksFromInfobarOfTheDocument();
        return this;
    }

    public UssDocumentPage checkMoreLinksLinkHasYellowHighlightAfterClicking() {
        getHelper(DocumentHelper.class).checkMoreLinksLinkHasYellowHighlightAfterClicking();
        return this;
    }

    public UssDocumentPage checkMoreLinksBlockIsOpened() {
        getHelper(DocumentHelper.class).checkMoreLinksBlockIsOpened();
        return this;
    }

    public UssDocumentPage checkMoreLinksHasTitleLinks() {
        getHelper(DocumentHelper.class).checkMoreLinksHasTitleLinks();
        return this;
    }

    public UssDocumentPage clickOnMoreLinksRandomLink() {
        getHelper(DocumentHelper.class).clickOnMoreLinksRandomLink();
        return this;
    }

    public UssDocumentPage checkMoreLinksAreDuplicatedBelowOfTheDocument() {
        getHelper(DocumentHelper.class).checkMoreLinksAreDuplicatedBelowOfTheDocument();
        return this;
    }

    public UssDocumentPage clickOnLinksFromInfobarInBottom() {
        getHelper(DocumentHelper.class).clickOnLinksFromInfobarInBottom();
        return this;
    }

    public UssDocumentPage checkStickyHeaderIsGray() {
        getHelper(DocumentHelper.class).checkStickyHeaderIsGray();
        return this;
    }

    public UssDocumentPage clickOnStickyHeader() {
        getHelper(DocumentHelper.class).clickOnStickyHeader();
        return this;
    }

    public UssDocumentPage checkStickyHeaderIsNotPresent() {
        getHelper(DocumentHelper.class).checkStickyHeaderIsNotPresent();
        return this;
    }

    public UssDocumentPage checkStickyHeaderScrolling() {
        getHelper(DocumentHelper.class).checkStickyHeaderScrolling();
        return this;
    }

    public UssDocumentPage checkQuickTocHasNumbers() {
        getHelper(DocumentHelper.class).checkQuickTocHasNumbers();
        return this;
    }

    public UssDocumentPage checkQuickTocDoesNotContainItemsReferencesAndLinks() {
        getHelper(DocumentHelper.class).checkQuickTocDoesNotContainItemsReferencesAndLinks();
        return this;
    }

    public UssDocumentPage checkApplicationsWidgetIsPresent() {
        getHelper(DocumentHelper.class).checkApplicationsWidgetIsPresent();
        return this;
    }

    public UssDocumentPage clickOnInfobarApplicationsLink() {
        getHelper(DocumentHelper.class).clickOnInfobarApplicationsLink();
        return this;
    }

    public UssDocumentPage checkApplicationsTextsArePresent() {
        getHelper(AttachmentsInfobar.class).checkApplicationsTextsArePresent();
        return this;
    }

    public UssDocumentPage checkAttachedFilesAreAvailable() {
        getHelper(AttachmentsInfobar.class).checkAttachedFilesAreAvailable();
        return this;
    }

    public UssDocumentPage checkApplicationsExtensionsArePresent() {
        getHelper(AttachmentsInfobar.class).checkApplicationsExtensionsArePresent();
        return this;
    }

    public UssDocumentPage checkMetaTagsAndTableOfContents() {
        getHelper(DocumentHelper.class).checkMetaTagsAndTableOfContents();
        return this;
    }

    public UssDocumentPage checkMetaTagsAndSavedDataContent() {
        getHelper(DocumentHelper.class).checkMetaTagsAndSavedDataContent();
        return this;
    }

    public UssDocumentPage clickReferencesByArticleAndParagraph(int chapterNumber, int articleNumber, int paragraphNumber) {
        getHelper(DocumentHelper.class).clickReferencesByArticleAndParagraph(chapterNumber, articleNumber, paragraphNumber);
        return this;
    }

    public UssSearchResultPage clickAllAdditionalMaterialsButton() {
        getHelper(DocumentHelper.class).clickAllAdditionalMaterialsButton();
        return redirectTo(UssSearchResultPage.class);
    }
}


