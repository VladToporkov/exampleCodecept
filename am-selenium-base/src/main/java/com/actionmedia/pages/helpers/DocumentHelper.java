package com.actionmedia.pages.helpers;

import com.actionmedia.autotest.screenshots.Screenshoter;
import com.actionmedia.autotest.selenium.annotations.ErrorMessage;
import com.actionmedia.autotest.selenium.annotations.Report;
import com.actionmedia.base.BasePage;
import com.actionmedia.components.Link;
import com.actionmedia.util.TestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 28.11.13
 * Time: 14:37
 */


@Component
public class DocumentHelper extends BasePage<DocumentHelper> {

    private static final String PARENT_DOCUMENT_TITLE = "parent.document.title";
    private static final String BUTTON_LOCATOR = "button.locator";
    private static final String RANDOM_ITEM_URL = "random.item.url";
    private static final String DOCUMENT_CHAPTER = "document.chapter";
    private static final By TABLE_OF_CONTENTS_BUTTON_LOCATOR = By.id("description-btn");
    public static final String COURSE_TABLE_TEXT = "course.table.text";

    private static int referencesCount;

    @FindBy(css = ".btn_type_references")
    @CacheLookup
    @ErrorMessage("Ни одного беклинка не найдено")
    public static List<WebElement> backlinks;

    @FindBy(id = "document-body")
    @ErrorMessage("Не найден элемент document-body")
    protected WebElement documentBody;

    @FindBy(id = "document-header")
    @ErrorMessage("Не найден элемент document-header")
    protected WebElement documentHeader;

    public static final String COUNT_SEARCH_IN_TEXT = "count.search.in.text";

    @Step("Проверяется что кнопка Распечатать отображается")
    public void checkPrintButtonIsPresent() {
        WebElement document = getDocumentHeader();
        WebElement printButton = findElementByNoThrow(document, By.cssSelector("[href*='window.print();']"));
        assertNotNull(printButton, "Кнопка Распечатать не найдена");
        postponedAssertTrue(printButton.isDisplayed(), "Кнопка Распечатать не отображаеся");
        postponedAssertEquals(printButton.getAttribute("title"), "Распечатать", "Неправильный тултип для кнопки Распечатать");
    }

    @Step("Проверяется что кнопка Распечатать отображается")
    public void checkPrintButtonInKodeksIsPresent() {
        WebElement document = getDocumentHeader();
        WebElement printButton = findElementByNoThrow(document, By.cssSelector(".ico_content_print"));
        assertNotNull(printButton, "Кнопка Распечатать не найдена");
        postponedAssertTrue(printButton.isDisplayed(), "Кнопка Распечатать не отображаеся");
        postponedAssertEquals(printButton.getAttribute("title"), "Распечатать", "Неправильный тултип для кнопки Распечатать");
    }

    @Step("Проверяется что кнопка Скачать в Word отображается")
    public void checkWordButtonIsPresent() {
        WebElement document = getDocumentHeader();
        WebElement wordButton = findElementByNoThrow(document, By.cssSelector(".word"));
        WebElement saveButton = findElementByNoThrow(document, By.cssSelector(".save"));
        WebElement wordButtonNew = findElementByNoThrow(document, By.cssSelector(".export-to-word"));
        WebElement downloadButton = findElementByNoThrow(document, By.cssSelector(".js-export"));

        if (wordButton != null) {
            postponedAssertTrue(wordButton.isDisplayed(), "Кнопка Скачать в Word не отображаеся");
            postponedAssertEquals(wordButton.getAttribute("title"), "Скачать в формате MS Word", "Неправильный тултип для кнопки Скачать в Word");
            return;
        }

        if (wordButtonNew != null) {
            postponedAssertTrue(wordButtonNew.isDisplayed(), "Кнопка Скачать в Word не отображаеся");
            postponedAssertEquals(wordButtonNew.getAttribute("title"), "Скачать в формате MS Word", "Неправильный тултип для кнопки Скачать в Word");
            return;
        }

        if (saveButton != null) {
            postponedAssertTrue(saveButton.isDisplayed(), "Кнопка Скачать в Word не отображаеся");
            postponedAssertEquals(saveButton.getAttribute("title"), "Скачать в формате MS Word", "Неправильный тултип для кнопки Скачать в Word");
            return;
        }

        if (downloadButton != null) {
            postponedAssertTrue(downloadButton.isDisplayed(), "Кнопка Скачать в Word не отображаеся");
//            postponedAssertEquals(downloadButton.getAttribute("title"), "Скачать в формате MS Word", "Неправильный тултип для кнопки Скачать в Word");
            return;
        }
        setPostponedTestFail("Кнопка Скачать в Word не найдена");
    }

    @Step("Проверяется что кнопка Скачать в Word отображается")
    public void checkWordButtonInKodeksIsPresent() {
        WebElement document = getDocumentHeader();
        WebElement downloadButton = findElementByNoThrow(document, By.xpath("//*[contains(@class,'ico_content_download')]/.."));
        if (downloadButton != null) {
            postponedAssertTrue(downloadButton.isDisplayed(), "Кнопка Скачать в Word не отображаеся");
            postponedAssertEquals(downloadButton.getAttribute("title"), "Скачать в формате MS Word", "Неправильный тултип для кнопки Скачать в Word");
            return;
        }
        setPostponedTestFail("Кнопка Скачать в Word не найдена");
    }

    @Step("Проверяется что кнопка Отправить ссылку коллеге отображается")
    public void checkMailButtonIsPresent() {
        WebElement document = getDocumentHeader();
        WebElement printButton = findElementByNoThrow(document, By.cssSelector(".ico_content_mail"));
        assertNotNull(printButton, "Кнопка Отправить ссылку коллеге не найдена");
        postponedAssertTrue(printButton.isDisplayed(), "Кнопка Отправить ссылку коллеге не отображаеся");
    }

    @Step("Проверяется что кнопка Отправить ссылку коллеге отображается")
    public void checkMailButtonInKodeksIsPresent() {
        WebElement document = getDocumentHeader();
        WebElement printButton = findElementByNoThrow(document, By.cssSelector(".ico_content_mail"));
        assertNotNull(printButton, "Кнопка Отправить ссылку коллеге не найдена");
        postponedAssertTrue(printButton.isDisplayed(), "Кнопка Отправить ссылку коллеге не отображаеся");
        postponedAssertEquals(printButton.getAttribute("title"), "Отправить ссылку коллеге", "Неправильный тултип для кнопки Отправить ссылку коллеге");
    }

    @Step("Проверяется что кнопка Отправить ссылку коллеге не отображается")
    public void checkMailButtonIsNotPresent() {
        WebElement document = getDocumentHeader();
        WebElement printButton = findElementByNoThrow(document, By.cssSelector(".mail"));
        postponedAssertNull(printButton, "Кнопка Отправить ссылку коллеге отображается");
    }

    @Step("Проверяется что кнопка Отправить ссылку коллеге не отображается")
    public void checkMailButtonInKodeksIsNotPresent() {
        WebElement document = getDocumentHeader();
        WebElement printButton = findElementByNoThrow(document, By.cssSelector(".ico_content_mail"));
        postponedAssertNull(printButton, "Кнопка Отправить ссылку коллеге отображается");
    }

    @Step("Проверяется что конверт отображается")
    public void checkMailFormIsPresent() {
        WebElement body = waitForVisibilityOfElementLocatedBy(By.tagName("body"), "Страница не найдена");
        WebElement mailForm = findElementByNoThrow(body, By.id("main-mail-content"));
        postponedAssertNotNull(mailForm, "Конверт не найден");
        if (mailForm != null) {
            waitForTextToBePresentIn(mailForm);
            postponedAssertTrue(mailForm.isDisplayed(), "Конверт не отображется");

            WebElement inputField = findElementByNoThrow(mailForm, By.id("email"));
            assertNotNull(inputField, "Поле для ввода email не найдено");
            postponedAssertTrue(inputField.isDisplayed(), "Поле для ввода email не отображается");

            WebElement sendButton = findElementByNoThrow(mailForm, By.id("mail-send"));
            assertNotNull(sendButton, "Кнопка Отправить не найдена");
            postponedAssertTrue(sendButton.isDisplayed(), "Кнопка Отправить не отображается");
        }
    }

    @Step("Проверяется что конверт не отображается")
    public void checkMailFormIsNotPresent() {
        WebElement body = waitForVisibilityOfElementLocatedBy(By.tagName("body"), "Страница не найдена");
        WebElement mailForm = findElementByNoThrow(body, By.id("main-mail-content"));
        postponedAssertTrue(mailForm == null || (mailForm != null && !mailForm.isDisplayed()), "Конверт отображается");
    }

    @Step("Ввести email в форму 'Отправить коллеге'")
    public void inputEmailInMailForm(String email) {
        WebElement mailForm = waitForPresenceOfElementLocatedBy(By.id("main-mail-content"), "Конверт не найден");
        WebElement inputField = mailForm.findElement(By.id("email"));
        inputField.clear();
        inputField.sendKeys(email);
    }

    @Step("Нажать 'Отправить' в форме 'Отправить коллеге'")
    public void clickSendInMailForm() {
        WebElement mailForm = waitForPresenceOfElementLocatedBy(By.id("main-mail-content"), "Конверт не найден");
        WebElement sendButton = mailForm.findElement(By.id("mail-send"));
        sendButton.click();
        waitFewSecond(5000);
    }

    @Step("Проверяется что ошибка в форме 'Отправить коллеге' отображается")
    public void checkErrorMessageInMailForm(String expectedErrorMessaege) {
        WebElement mailForm = waitForPresenceOfElementLocatedBy(By.id("main-mail-content"), "Конверт не найден");
        WebElement errorMessage = findElementByNoThrow(mailForm, By.cssSelector(".form-error-text"));
        postponedAssertNotNull(errorMessage, "Ошибка в форме 'Отправить коллеге' не найдена");
        if (errorMessage != null) {
            postponedAssertTrue(errorMessage.isDisplayed(), "Ошибка в форме 'Отправить коллеге' не отображается");
            postponedAssertEquals(errorMessage.getText(), expectedErrorMessaege, "Текст ошибки в форме 'Отправить коллеге' неправильный");
        }
    }

    @Step("Проверяется работа врезов")
    public void checkInCut() {
        WebElement document = getDocumentBody();
        double documentSizeBefore = getHeightFromString(document.getCssValue("height"));
        List<WebElement> inCuts = document.findElements(By.cssSelector(".incut"));
        for (WebElement inCut : inCuts) {
            if (!inCut.isDisplayed()) {
                continue;
            }
            waitFewSecond(1000);
            List<WebElement> headerList = inCut.findElements(By.cssSelector(".incut-head"));
            if (headerList.isEmpty()) {
                continue;
            }
            String inCutTitle = headerList.get(0).getText();
            report("Проверяется врез '" + inCutTitle + "'");
            scrollToElementLocationWithout200px(inCut);
            List<WebElement> inCutButtonList = inCut.findElements(By.cssSelector(".incut-button"));
            if (!inCutButtonList.isEmpty()) {
                double inCutSizeBefore = getHeightFromString(inCut.getCssValue("height"));
                WebElement inCutButton = inCutButtonList.get(0);
                inCutButton.click();
                waitForReloadingPage();
                double documentSizeAfter = getHeightFromString(document.getCssValue("height"));
                double inCutSizeAfter = getHeightFromString(inCut.getCssValue("height"));
                WebElement inCutBody = inCut.findElement(By.cssSelector(".incut-body"));
                postponedAssertTrue(inCutBody.isDisplayed(), "Открытый врез не отображается");
                postponedAssertFalse(inCutBody.getText().isEmpty(), "В открытом врезе отвсутсвует текст");
                postponedAssertTrue(inCutSizeBefore < inCutSizeAfter, "После открытия вреза размер вреза не изменился");
                postponedAssertTrue(documentSizeAfter - documentSizeBefore == inCutSizeAfter - inCutSizeBefore, "После открытия вреза размер документа не изменился");
                inCutButton.click();
                waitForReloadingPage();
            }
        }
    }

    @Step("Проверяется работа виджета см. также")
    public void checkInfoBarWidget() {
        WebElement document = getDocumentHeader();

        WebElement infoBarWidget;
        if (getSettings().isRunKss()) {
            infoBarWidget = findElementByNoThrow(document, By.cssSelector("[data-rel='infobar-links']"));
        } else {
            infoBarWidget = findElementByNoThrow(document, By.cssSelector(".doc-list"));
        }

        if (infoBarWidget != null && infoBarWidget.isDisplayed()) {
            WebElement infoBarLink = infoBarWidget.findElement(By.tagName("a"));
            infoBarLink.click();
            waitForReloadingPage();
            WebElement infoBar;
            if (getSettings().isRunKss()) {
                infoBar = waitForPresenceOfElementLocatedBy(By.id("infobar-links"));
            } else {
                infoBar = waitForPresenceOfElementLocatedBy(By.id("infobar-top"));
            }

            postponedAssertTrue(infoBar.isDisplayed(), "Содержание виджета не отображается");
            postponedAssertFalse(infoBar.getText().isEmpty(), "Содержание виджета пустое");
            if (!infoBarWidget.findElements(By.xpath("//u[text()='Другие редакции']")).isEmpty()) {
                WebElement editions = findElementByNoThrow(infoBar, By.id("editions"));
                assertNotNull(editions, "Блок Редакции документа не найден в виджете");
                postponedAssertTrue(editions.isDisplayed(), "Блок Редакции документа не отображается в виджете");
                postponedAssertFalse(editions.getText().isEmpty(), "Блок Редакции документа пуст");
            }
            if (!infoBarWidget.findElements(By.xpath("//u[text()='см. также']")).isEmpty()) {
                WebElement seeAlso = findElementByNoThrow(infoBar, By.xpath("//h4[text()='См. также']"));
                assertNotNull(seeAlso, "Блок см.также не найден в виджете");
                WebElement seeAlsoParent = getParentElement(seeAlso);
                postponedAssertTrue(seeAlsoParent.isDisplayed(), "Блок см.также не отображается в виджете");
                postponedAssertFalse(seeAlsoParent.getText().isEmpty(), "Блок см.также пуст");
            }
            if (!infoBarWidget.findElements(By.xpath(".//u[text()='бланки']")).isEmpty() || !infoBarWidget.findElements(By.xpath(".//u[text()='Бланки']")).isEmpty()) {
                WebElement forms = findElementByNoThrow(infoBar, By.cssSelector(".ico_content_forms"));
                assertNotNull(forms, "Блок Бланки не найден в виджете");
                WebElement formsParent = getParentElement(forms);
                postponedAssertTrue(formsParent.isDisplayed(), "Блок Бланки не отображается в виджете");
                postponedAssertFalse(formsParent.getText().isEmpty(), "Блок Бланки пуст");
            }
            infoBarLink.click();
            postponedAssertFalse(infoBar.isDisplayed(), "Содержание виджета отображается после закрытия виджета");
        } else {
            warning("Проверка не проводилась, так как виджета см. также нет в документе");
        }
    }

    @Step("Проверяется работа виджетов в заголовке документа")
    public void checkInfoBarWidgetWork() {
        WebElement document = getDocumentHeader();
        WebElement infoBarBlock;
        if (!getSettings().isRunFss()) {
            infoBarBlock = document.findElement(By.cssSelector(".doc-menu"));
        } else {
            infoBarBlock = document.findElement(By.cssSelector(".doc-list"));
        }
        List<WebElement> infoBarWidgetList = infoBarBlock.findElements(By.tagName("li"));
        for (WebElement infoBarWidget : infoBarWidgetList) {
            WebElement link = findElementByNoThrow(infoBarWidget, By.tagName("a"));
            if (link == null) {
                continue;
            }
            if (link.getText().equals("Сравнить с предыдущей редакцией")) {
                continue;
            }
            if (link.getText().equals("Недавние изменения")) {
                break;
            }
            String widgetName = infoBarWidget.getText();
            report("Проверяется работа виджета " + widgetName);
            String widgetLocator = infoBarWidget.getAttribute("data-rel");
            link.click();
            waitForReloadingPage();
            WebElement infoBarForWidget = waitForPresenceOfElementLocatedBy(By.id(widgetLocator));
            postponedAssertTrue(infoBarForWidget.isDisplayed(), "Содержание виджета " + widgetName + " не отображается");
            postponedAssertFalse(infoBarForWidget.getText().isEmpty(), "Виджет " + widgetName + " пуст");
            link.click();
        }
    }

    @Step("Проверяется работа виджета Справка и другие редакции")
    public void checkHelpWidgetIsPresent() {
        WebElement document = getDocumentHeader();
        WebElement infoBarWidget = findElementByNoThrow(document, By.cssSelector("[data-rel='infobar-card']"));
        if (infoBarWidget != null && infoBarWidget.isDisplayed()) {
            WebElement infoBarLink = infoBarWidget.findElement(By.tagName("a"));
            infoBarLink.click();
            waitForReloadingPage();
            WebElement infoBar = waitForPresenceOfElementLocatedBy(By.id("infobar-card"));
            postponedAssertTrue(infoBar.isDisplayed(), "Содержание виджета Справка и другие редакции не отображается");
            postponedAssertFalse(infoBar.getText().isEmpty(), "Содержание виджета пустое");
            findElementBy(By.cssSelector("[data-rel='infobar-card']")).findElement(By.tagName("a")).click();
            postponedAssertFalse(infoBar.isDisplayed(), "Содержание виджета Справка и другие редакции отображается после закрытия виджета");
        } else {
            warning("Проверка не проводилась, так как виджета Справка и другие редакции нет в документе");
        }
    }

    @Step("Проверяется работа виджета Приложения")
    public void checkApplicationsWidgetIsPresent() {
        WebElement document = getDocumentHeader();
        WebElement infoBarWidget = findElementByNoThrow(document, By.cssSelector("[data-rel='infobar-attachment']"));
        if (infoBarWidget != null && infoBarWidget.isDisplayed()) {
            WebElement infoBarLink = infoBarWidget.findElement(By.tagName("a"));
            infoBarLink.click();
            waitForReloadingPage();
            WebElement infoBar = waitForPresenceOfElementLocatedBy(By.id("infobar-attachment"));
            postponedAssertTrue(infoBar.isDisplayed(), "Содержание виджета Приложения не отображается");
            postponedAssertFalse(infoBar.getText().isEmpty(), "Содержание виджета пустое");

            WebElement seeAlso = findElementByNoThrow(infoBar, By.xpath("//h3[text()='Приложения']"));
            assertNotNull(seeAlso, "Блок Приложения не найден в виджете");
            WebElement seeAlsoParent = getParentElement(seeAlso);
            postponedAssertTrue(seeAlsoParent.isDisplayed(), "Блок Приложения не отображается в виджете");
            postponedAssertFalse(seeAlsoParent.getText().isEmpty(), "Блок Приложения пуст");

            infoBarLink.click();
            postponedAssertFalse(infoBar.isDisplayed(), "Содержание виджета Приложения отображается после закрытия виджета");
        } else {
            warning("Проверка не проводилась, так как виджета Приложения нет в документе");
        }
    }

    @Step("Проверяется работа блока История изменений")
    public void checkChangeHistoryWidget() {
        WebElement document = waitForPresenceOfElementLocatedBy(By.id("document-body"), "Страница не найдена");
        WebElement changeHistoryWidget = document.findElement(By.cssSelector(".incut-changesnpd"));
        WebElement changeHistoryLink = changeHistoryWidget.findElement(By.cssSelector(".incut-head-control"));
        changeHistoryLink.click();
        WebElement changeHistoryBody = changeHistoryWidget.findElement(By.cssSelector(".incut-body"));
        postponedAssertTrue(changeHistoryBody.isDisplayed(), "Список историй изменений не отображается");
        postponedAssertFalse(changeHistoryBody.findElements(By.tagName("a")).isEmpty(), "Список историй изменений пуст");
        changeHistoryLink.click();
    }

    @Step("Проверяется работа ссылок в содере")
    public void checkScrolling() {
        List<WebElement> chapters = sidebarElement.findElements(By.tagName("li"));

        for (WebElement chapter : chapters) {
            chapter.findElement(By.tagName("a")).click();
        }
        if (!chapters.isEmpty()) {
            chapters.get(0).findElement(By.tagName("a")).click();
        }
        for (int i = 1; i < chapters.size() - 2; i++) {
            WebElement chapter = chapters.get(i);
            WebElement chapterLink = chapter.findElement(By.tagName("a"));
            String url = chapterLink.getAttribute("href").split("#")[1];
            chapterLink.click();
            waitForReloadingPage();
            int chapterTitlePosition = waitForPresenceOfElementLocatedBy(By.cssSelector("[data-anchor='" + url + "']")).getLocation().getY();
            int headerPosition = waitForPresenceOfElementLocatedBy(By.id("header")).getLocation().getY();
            postponedAssertTrue(chapterTitlePosition - headerPosition < DOCUMENT_LOCATION, "Документ не проскроллился к главе '" + chapter.getText() + "'");
        }
    }

    @Step("Проверяется работа залипающего заголовка при скролле")
    public void checkStickyHeaderScrolling() {
        List<WebElement> articles = getArticlesContentList();
        if (articles.size() > 5) {
            articles = articles.subList(0, 5); //subtract to get only first 5 articles
        }
        for (WebElement article : articles) {
            waitForTextToBePresentIn(article);
            String chapterTitle = article.getText().split("\n")[0].trim();
            //the search input has 50 px and the document header menu has 50 px length. 80 px needs for scrolling usage
            executeScript("window.scrollTo(" + 0 + ", " + (article.getLocation().getY() - 80) + "); return true;");
            WebElement stickyHeader = waitForElementToBeEnabled(By.id("sticky-header"));
            int stickyHeaderPosition = stickyHeader.getLocation().getY();
            int headerPosition = waitForPresenceOfElementLocatedBy(By.id("header")).getLocation().getY();
            waitFewSecond(200);
            postponedAssertTrue(chapterTitle.contains(stickyHeader.getText().replace("...", "")), "Неправильная глава в залипающем заголовоке. Наблюдаемая - " + stickyHeader.getText() + ". Ожидаемая - " + chapterTitle);
            postponedAssertTrue(stickyHeaderPosition - headerPosition < DOCUMENT_LOCATION, "Неправильное положение залипающего заголовка");
        }
    }

    @Step("Нажать кнопку Отправить ссылку коллеге")
    public void clickMailButton() {
        scrollIntoView(getDocumentHeader());
        waitForVisibilityOfElementLocatedBy(By.cssSelector(".mail"), "Конверт не найден").click();
    }

    @Step("Нажать кнопку Отправить ссылку коллеге")
    public void clickMailButtonInKodeks() {
        scrollIntoView(getDocumentHeader());
        waitForVisibilityOfElementLocatedBy(By.cssSelector(".ico_content_mail"), "Конверт не найден").click();
    }

    public void scrollAllDocument() {
        WebElement document = getDocumentBody();
        List<WebElement> documentPartList = document.findElements(By.cssSelector("[id*='doc-part-']"));
        for (WebElement documentPart : documentPartList) {
            scrollIntoView(documentPart);
            waitForDocumentReloaded(documentPart);
        }
        scrollIntoView(waitForVisibilityOfElementLocatedBy(By.id("header"), "Заголовок не найден"));
    }

    @Step("Проверяется работа Оглавления")
    public void checkTableOfContents() {
        waitForPresenceOfElementLocatedBy(TABLE_OF_CONTENTS_BUTTON_LOCATOR).click();
        waitForInvisibilityOfElementLocatedBy(By.id("description-preloader"));
        WebElement description = getDescription();
        WebElement randomItems = getRandomElementInList(description.findElements(By.cssSelector(".article")));
        String title = randomItems.getText();
        String url = randomItems.findElement(By.tagName("a")).getAttribute("href").split("#")[1];
        randomItems.findElement(By.tagName("a")).click();
        int itemPosition = waitForPresenceOfElementLocatedBy(By.cssSelector("[data-anchor='" + url + "']")).getLocation().getY();
        int headerPosition = waitForPresenceOfElementLocatedBy(By.id("header")).getLocation().getY();
        postponedAssertTrue(itemPosition - headerPosition < DOCUMENT_LOCATION, "Документ не проскроллился после выбора в Оглавлении статьи '" + title + "'");
    }

    @Step("Проверяется работа Оглавления")
    public void checkTableOfContentsForPlan() {
        waitForPresenceOfElementLocatedBy(TABLE_OF_CONTENTS_BUTTON_LOCATOR).click();
        waitForInvisibilityOfElementLocatedBy(By.id("description-preloader"));
        WebElement description = getDescription();
        waitForTextToBePresentIn(description);
        List<WebElement> items = description.findElements(By.cssSelector("[href*='#/document/']"));
        if (!items.isEmpty()) {
            WebElement randomItems = getRandomElementInList(items);
            String title = randomItems.getText();
            String url = randomItems.getAttribute("href").split("#")[1];
            randomItems.click();
            int itemPosition = waitForPresenceOfElementLocatedBy(By.cssSelector("[data-anchor='" + url + "']")).getLocation().getY();
            int headerPosition = waitForPresenceOfElementLocatedBy(By.id("header")).getLocation().getY();
            postponedAssertTrue(itemPosition - headerPosition < DOCUMENT_LOCATION, "Документ не проскроллился после выбора в Оглавлении статьи '" + title + "'");
        } else {
            setPostponedTestFail("Отсутсвуют элементы в содержании");
        }
    }

    @Step("Проверяется работа шариков для Главы")
    public void checkReferencesForChapter() {
        WebElement chapter = getElementWithReferences(By.cssSelector(".header-chapter"));
        if (chapter != null) {
            checkBallsForElement(chapter);
        } else {
            warning("Не найдена глава с шариками, проверка не проводилась");
        }
    }

    @Step("Проверяется работа шариков для Статьи")
    public void checkReferencesForArticle() {
        WebElement article = getElementWithReferences(By.cssSelector(".header-article"));
        if (article != null) {
            checkBallsForElement(article);
        } else {
            warning("Не найдена статья с шариками, проверка не проводилась");
        }
    }

    @Step("Проверяется работа шариков для Абзаца")
    public void checkReferencesForParagraph() {
        WebElement paragraph = getElementWithReferences(By.cssSelector(".formattext"));
        if (paragraph != null) {
            checkBallsForElement(paragraph);
        } else {
            warning("Не найден абзац с шариками, проверка не проводилась");
        }
    }

    @Step("Проверяется работа ссылок из блокнота для главы")
    public void checkLinksFromNotebookForChapter() {
        WebElement chapter = getElementWithReferences(By.cssSelector(".header-chapter"));
        if (chapter != null) {
            checkLinksFromNotebook(chapter);
        } else {
            warning("Не найдена главы с шариками, проверка не проводилась");
        }
    }

    @Step("Проверяется работа ссылок из блокнота для статьи")
    public void checkLinksFromNotebookForArticle() {
        WebElement article = getElementWithReferences(By.cssSelector(".header-article"));
        if (article != null) {
            checkLinksFromNotebook(article);
        } else {
            warning("Не найдена статья с шариками, проверка не проводилась");
        }
    }

    @Step("Проверяется работа ссылок из блокнота для абзаца")
    public void checkLinksFromNotebookForParagraph() {
        WebElement paragraph = getElementWithReferences(By.cssSelector(".formattext"));
        if (paragraph != null) {
            checkLinksFromNotebook(paragraph);
        } else {
            warning("Не найден абзац с шариками, проверка не проводилась");
        }
    }

    @Step("Проверяется работа редакторских ссылок для главы")
    public void checkEditLinksForChapter() {
        WebElement article = getElementWithEditLink(By.cssSelector(".header-chapter"));
        if (article != null) {
            checkEditLinkForElement(article);
        } else {
            warning("Не найдены редакторские ссылки для главы, проверка не проводилась");
        }
    }

    @Step("Проверяется работа редакторских ссылок для статьи")
    public void checkEditLinksForArticle() {
        WebElement article = getElementWithEditLink(By.cssSelector(".header-article"));
        if (article != null) {
            checkEditLinkForElement(article);
        } else {
            warning("Не найдены редакторские ссылки для статьи, проверка не проводилась");
        }
    }

    @Step("Проверяется работа редакторских ссылок для абзаца")
    public void checkEditLinksForParagraph() {
        WebElement article = getElementWithEditLink(By.cssSelector(".formattext"));
        if (article != null) {
            checkEditLinkForElement(article);
        } else {
            warning("Не найдены редакторские ссылки для абзаца, проверка не проводилась");
        }
    }

    @Step("Проверяется что кнопка Скачать бланк отображается")
    public void checkDownloadButtonIsPresent() {
        WebElement document = getDocumentBody();
        WebElement downloadBlock = document.findElement(By.cssSelector(".forms-download"));
        WebElement downloadFormButton = findElementByNoThrow(downloadBlock, By.cssSelector(".button"));
        assertNotNull(downloadFormButton, "Кнопка Скачать бланк не найдена");
        postponedAssertTrue(downloadFormButton.isDisplayed(), "Кнопка Скачать бланк не отображаеся");
//        postponedAssertEquals(downloadFormButton.getText(), "Скачать бланк", "Неправильный текст кнопки Скачать бланк");
    }

    @Step("Проверяется что ссылка Скачать заполненный образец отображается")
    public void checkDownloadExampleButtonIsPresent() {
        WebElement document = getDocumentBody();
        WebElement downloadBlock = document.findElement(By.cssSelector(".forms-download"));
        WebElement downloadFormButton = findElementByNoThrow(downloadBlock, By.cssSelector(".dashed"));
        assertNotNull(downloadFormButton, "Ссылка Скачать заполненный образец не найдена");
        postponedAssertTrue(downloadFormButton.isDisplayed(), "Ссылка Скачать заполненный образец не отображаеся");
        postponedAssertEquals(downloadFormButton.getText().trim(), "заполненный образец", "Неправильный текст ссылки Скачать заполненный образец");
    }

    @Step("Проверяется что элемент 'Редакция действует' отображается")
    public void checkDocumentVersionIsPresent() {
        WebElement document = getDocumentHeader();
        WebElement infoCardBlock = findElementByNoThrow(mainContentElement, By.id("infobar-card"));
        WebElement editions = findElementByNoThrow(mainContentElement, By.id("editions"));
        WebElement version = findElementByNoThrow(document, By.cssSelector("[class*='link_viewtype']"));
        WebElement versionInInfoCardBlock = infoCardBlock != null ? findElementByNoThrow(infoCardBlock, By.cssSelector(".redaction-info")) : null;
        if (version != null) {
            postponedAssertTrue(version.isDisplayed(), "Элемент 'Редакция действует' не отображается");
            postponedAssertFalse(version.getText().isEmpty(), "Текст элемента 'Редакция действует' пустой");
            return;
        }
        if (versionInInfoCardBlock != null) {
            findElementBy(By.cssSelector(".link_type_pseudo")).click();
            waitForReloadingPage();
            postponedAssertTrue(versionInInfoCardBlock.isDisplayed(), "Элемент 'Редакция действует' не отображается");
            postponedAssertFalse(versionInInfoCardBlock.getText().isEmpty(), "Текст элемента 'Редакция действует' пустой");
            findElementBy(By.cssSelector(".link_type_pseudo")).click();
            waitForReloadingPage();
            return;
        }
        if (editions != null) {
            findElementBy(By.cssSelector("[data-rel='infobar-links'] .btn_viewtype_link")).click();
            waitForReloadingPage();
            postponedAssertTrue(editions.isDisplayed(), "Элемент 'Редакция действует' не отображается");
            postponedAssertFalse(editions.getText().isEmpty(), "Текст элемента 'Редакция действует' пустой");
            findElementBy(By.cssSelector("[data-rel='infobar-links'] .btn_viewtype_link")).click();
            waitForReloadingPage();
            return;
        }
        setPostponedTestFail("Элемент 'Редакция действует' не найден");
    }

    private boolean isYoutubeVideo() {
        WebElement document = getDocumentBody();
        WebElement player = findElementByNoThrow(document, By.id("video-player-youtube"));
        return player != null;
    }

    @Step("Проверяется что элемент 'Видео размещено...' отображается")
    public void checkVideoVersionIsPresent() {
        WebElement doc = getDocumentHeader();
        boolean youtubePlayer = isYoutubeVideo();

        WebElement ver;
        if (youtubePlayer) {
            ver = findElementByNoThrow(doc, By.cssSelector(".doc-menu"));
        } else {
            ver = findElementByNoThrow(doc, By.cssSelector(".list"));
        }

        postponedAssertNotNull(ver, "Элемент 'Видео размещено...' не найден");
        if (ver != null) {
            postponedAssertTrue(ver.isDisplayed(), "Элемент 'Видео размещено...' не отображается");
            postponedAssertFalse(ver.getText().isEmpty(), "Текст элемента 'Видео размещено...' пустой");
            postponedAssertTrue(ver.getText().startsWith("Видео размещено"), "Неправильный текст элемента 'Видео размещено...'");
        }
    }

    @Step("Проверяется страница просмотра формы")
    public void checkFormsPreview() {
        WebElement document = getDocumentBody();
        List<WebElement> formsImgList = document.findElements(By.cssSelector(".forms-img"));
        formsImgList.get(0).click();

        waitForInvisibilityOfElementLocatedBy(By.id("lightbox-loading"));
        WebElement documentPreview = waitForVisibilityOfElementLocatedBy(By.id("lightbox-container-image-box"), "Форма превью документа не найдена");
        String firstImgSrc = documentPreview.findElement(By.id("lightbox-image")).getAttribute("src");
        WebElement closeButton = findElementByNoThrow(documentPreview, By.id("lightbox-secNav-btnClose"));
        assertNotNull(closeButton, "Кнопка Закрыть не найдена на странице просмотра формы");
        postponedAssertTrue(closeButton.isDisplayed(), "Кнопка Закрыть не отображается на странице просмотра формы");

        if (formsImgList.size() > 1) {
            WebElement nextButton = documentPreview.findElement(By.id("lightbox-nav-btnNext"));
            WebElement previousButton = documentPreview.findElement(By.id("lightbox-nav-btnPrev"));

            moveMouseToElement(nextButton);
            waitFewSecond(2000);
            nextButton.click();
            waitFewSecond(2000);
            String nextImgSrc = documentPreview.findElement(By.id("lightbox-image")).getAttribute("src");
            postponedAssertFalse(firstImgSrc.equals(nextImgSrc), "Отображается предыдущая страница на просмотре формы");

            moveMouseToElement(previousButton);
            waitFewSecond(2000);
            previousButton.click();
            waitFewSecond(2000);
            String prevImgSrc = documentPreview.findElement(By.id("lightbox-image")).getAttribute("src");
            postponedAssertTrue(firstImgSrc.equals(prevImgSrc), "Отображается предыдущая страница на просмотре формы");
        } else {
            warning("Всего 1 страница на просмотре формы, стрелки-листалки не проверялись");
        }

        documentPreview.click();
        postponedAssertNull(findElementByNoThrow(By.id("lightbox-loading")), "Страница просмотра отображается после закрытия");
        postponedAssertTrue(formsImgList.get(0).isDisplayed(), "Страница формы не отображается после закрытия просмотра");
    }

    @Step("Проверяется что в открытом документе отображается статус Утратил силу")
    public void checkExpiredWarningIsPresent() {
        WebElement documentHeader = getDocumentHeader();
        WebElement expiredWidget = findElementByNoThrow(documentHeader, By.cssSelector("[class*='_viewtype_expired']"));
        WebElement inFutureWidget = findElementByNoThrow(documentHeader, By.cssSelector(".in-future"));
        if (expiredWidget != null) {
            postponedAssertTrue(expiredWidget.getText().startsWith("Редакция утратила силу"), "Неправильный текст статуса 'Утратил силу'");
        } else if (inFutureWidget != null) {
            postponedAssertTrue(inFutureWidget.getText().startsWith("Редакция не действует на"), "Неправильный текст статуса 'Утратил силу'");
        } else {
            setPostponedTestFail("Не найден статус Утратил силу в документе. Может статус не ссылка? Нужно " +
                    "воспользоваться другим методом (не для ссылки)");
        }
    }

    @Step("Проверяется, что в открытом документе отображается статус Редакция утратила силу (не ссылка)")
    public void checkExpiredWarningNOTLinkIsPresent() {
        WebElement documentHeader = getDocumentHeader();
        WebElement expiredStatus = findElementByNoThrow(documentHeader, By.cssSelector(".list__item_viewtype_expired"));
        postponedAssertNotNull(expiredStatus, "Статус Редакция утратила силу не найден. Может статус имеет ссылку? " +
                "Нужно воспользоваться другим методом");
        if (expiredStatus != null) {
            postponedAssertTrue(expiredStatus.getText().startsWith("Редакция утратила силу"), "Неправильный текст " +
                    "статуса Редакция утратила силу");
        }
    }

    @Step("Проверяется что в открытом документе отображается статус Не вступил в силу")
    public void checkFutureWarningIsPresent() {
        WebElement documentHeader = getDocumentHeader();
        WebElement inFutureWidget = findElementByNoThrow(documentHeader, By.cssSelector("[class*='_viewtype_future']"));
        postponedAssertNotNull(inFutureWidget, "Не найден статус документа Не вступил в силу");
        if (inFutureWidget != null) {
            postponedAssertTrue(inFutureWidget.getText().startsWith("Редакция не вступила в силу на") ||
                    inFutureWidget.getText().startsWith("Редакция вступает в силу"), "Неправильный текст статуса 'Не вступил в силу'");
        }
    }

    @Step("Проверяется что в открытом документе отображается статус 'Редакция действует'")
    public void checkActualVersionIsPresent() {
        WebElement documentHeader = getDocumentHeader();
        WebElement infoBlock = findElementByNoThrow(mainContentElement, By.id("infobar-card"));
        WebElement actualVersionWithDate = findElementByNoThrow(documentHeader, By.xpath("//*[contains(text(),'Редакция действует')]"));
        WebElement actualVersion = findElementByNoThrow(documentHeader, By.xpath("//*[contains(text(),'Действующая редакция')]"));
        WebElement actualVersionInInfoBlock = infoBlock != null ? findElementByNoThrow(infoBlock, By.xpath("//*[contains(text(),'Действующая редакция')]")) : null;
        postponedAssertTrue(actualVersionWithDate != null || actualVersion != null || actualVersionInInfoBlock != null, "Не найден статус документа 'Редакция действует'");
        if (actualVersionWithDate != null) {
            postponedAssertTrue(actualVersionWithDate.getText().startsWith("Редакция действует"), "Неправильный текст статуса 'Редакция действует'");
        }
        if (actualVersion != null) {
            postponedAssertTrue(actualVersion.getText().startsWith("Действующая редакция"), "Неправильный текст статуса 'Действующая редакция'");
        }
        if (actualVersionInInfoBlock != null) {
            findElementBy(By.cssSelector(".link_type_pseudo")).click();
            waitForReloadingPage();
            postponedAssertTrue(actualVersionInInfoBlock.getText().startsWith("Редакция действует"), "Неправильный текст статуса 'Редакция действует'");
        }
    }

    @Step("Проверяется что виджет Поиск в тексте присутсвует в поисковой строке")
    public void checkSearchInTextWidgetIsPresent() {
        WebElement searchBox = waitForPresenceOfElementLocatedBy(By.id("search-form"), "Поисковая строка не найдена");
        WebElement searchInText = findElementByNoThrow(searchBox, By.cssSelector(".search-in"));
        postponedAssertNotNull(searchInText, "Виджет Поиск в тексте не найден в поисковой строке");
        if (searchInText != null) {
            postponedAssertTrue(searchInText.isDisplayed(), "Виджет Поиск в тексте не отображается в поисковой строке");
            if (searchInText.isDisplayed()) {
                waitForTextToBePresentIn(searchInText, "текст");
                postponedAssertEquals(searchInText.findElement(By.cssSelector(".msg")).getText(), "Поиск в тексте", "Неправильный текст в виджете Поиск в тексте");

                WebElement nextBtn = findElementByNoThrow(searchInText, By.cssSelector(".next"));
                assertNotNull(nextBtn, "Стрелка Вперед не найдена в виджете Поиск в тексте");
                postponedAssertTrue(nextBtn.isDisplayed(), "Стрелка Вперед не отображается в виджете Поиск в тексте");

                WebElement prevBtn = findElementByNoThrow(searchInText, By.cssSelector(".prev"));
                assertNotNull(prevBtn, "Стрелка Назад не найдена в виджете Поиск в тексте");
                postponedAssertTrue(prevBtn.isDisplayed(), "Стрелка Назад не отображается в виджете Поиск в тексте");
            }
        }
    }

    @Step("Проверяется работа виджета Поиск в тексте с дополнительными запросами в случае не найденных результатов")
    public void checkSearchInTextWithSeveralQueries(String[] queries) {
        boolean isTextFound = false;
        int i;
        for (i = 0; i < queries.length; i++) {
            inputTextInSearchBox(queries[i]);
            clickHeader();
            report("Поиск слова:" + queries[i] + " в документе.");
            if (isTextFoundInDocument()) {
                report("Поиск в тексте будет проходить по слову");
                isTextFound = true;
                break;
            }
        }
        if (!isTextFound) {
            setPostponedTestFail("Из предложенного списка запросов:" + queries + " ни один не подходит для проверки " +
                    "в документе. Ни одно слово не найдено внутри документа.");
        } else {
            report("Поиск в документе будет проходить по слову:" + queries[i]);
            checkSearchInTextWidgetWork(false);
        }
    }

    private boolean isTextFoundInDocument() {
        waitFewSecond(getTimeout());
        WebElement searchBox = waitForVisibilityOfElementLocatedBy(By.id("search-form"), "Поисковая строка не найдена");
        WebElement searchInTextWidget = searchBox.findElement(By.cssSelector(".search-in"));
        waitForTextToBePresentIn(searchInTextWidget, "найдено");

        WebElement textInWidgetElement = searchInTextWidget.findElement(By.cssSelector(".msg"));
        String textInWidget = searchInTextWidget.findElement(By.cssSelector(".msg")).getText().trim();
        if (textInWidgetElement.getAttribute("class").contains("active")) {
            if (textInWidget.contains("В тексте найдено ~")) {
                return true;
            }
        }
        return false;
    }

    @Step("Проверяется работа виджета Поиск в тексте")
    public void checkSearchInTextWidgetWork(boolean fullCheck) {
        waitFewSecond(getTimeout());
        WebElement searchBox = waitForVisibilityOfElementLocatedBy(By.id("search-form"), "Поисковая строка не найдена");
        WebElement searchInTextWidget = searchBox.findElement(By.cssSelector(".search-in"));
        waitForTextToBePresentIn(searchInTextWidget, "найдено");

        WebElement textInWidgetElement = searchInTextWidget.findElement(By.cssSelector(".msg"));
        String textInWidget = searchInTextWidget.findElement(By.cssSelector(".msg")).getText().trim();
        if (textInWidgetElement.getAttribute("class").contains("active")) {
            postponedAssertTrue(textInWidget.contains("В тексте найдено ~"), "Неправильный текст в виджете Поиск в тексте");

            WebElement searchInTextIntoMenu = findElementByNoThrow(By.cssSelector(".found-total"));

            if (fullCheck) {
                String countTextInWidget = textInWidget.replace("В тексте найдено ~", "");
                String parameterCount = (String) getParameter(COUNT_SEARCH_IN_TEXT);
                if (parameterCount != null) {
                    postponedAssertNotEquals(parameterCount, countTextInWidget, "В предыдущем поиске было найдено столько " +
                            "же слов, сколько и в этом поиске. Проверьте работу поиска в документе.");
                }

                setParameter(COUNT_SEARCH_IN_TEXT, countTextInWidget);


                if (searchInTextIntoMenu == null || !searchInTextIntoMenu.isDisplayed()) {
                    executeScript("document.getElementById('elementID').setAttribute('style', 'display: block;')");
                }

                String countSearchInTextIntoMenu = searchInTextIntoMenu.getText().replace("В тексте найдено ~", "");

                postponedAssertEquals(getParameter(COUNT_SEARCH_IN_TEXT), countSearchInTextIntoMenu, "Значение в меню" +
                        countSearchInTextIntoMenu + " не совпадает со значением в поиске:" + getParameter(COUNT_SEARCH_IN_TEXT));
            }

            WebElement nextBtn = searchInTextWidget.findElement(By.cssSelector(".next"));
            postponedAssertTrue(nextBtn.getAttribute("class").contains("active"), "Стрелка Вперед в виджете Поиск в тексте не активна");

            WebElement prevBtn = searchInTextWidget.findElement(By.cssSelector(".prev"));
            postponedAssertTrue(prevBtn.getAttribute("class").contains("active"), "Стрелка Назад в виджете Поиск в тексте не активна");

            report("Проверяется скролл к результат поиска из виджета Поиск в тексте");

            if (fullCheck) {
                int startPosition = waitForVisibilityOfElementLocatedBy(By.id("header"), "Заголовок не найден").getLocation().getY();
                clickUseJS(nextBtn);
                waitForAttributeUpdate(textInWidgetElement, "class", "part-preloader", true);
                startPosition = clickOnWidgetSearchInText(startPosition, false);

                clickUseJS(searchInTextIntoMenu);
                waitForAttributeUpdate(textInWidgetElement, "class", "part-preloader", true);
                startPosition = clickOnWidgetSearchInText(startPosition, false);

                clickUseJS(prevBtn);
                waitForAttributeUpdate(textInWidgetElement, "class", "part-preloader", true);
                clickOnWidgetSearchInText(startPosition, true);
            }

            scrollToStart();
        } else {
            postponedAssertTrue("В тексте не найдено".equals(textInWidget), "Неправильный текст в виджете Поиск в тексте");
            warning("Результаты поиска отсутсвуют проверка скролла не проводилась");
        }
    }

    /*
        Check document after click on widget: forward, back or click on the widget(forward action)
        If goback is true - start location must be more then end location
     */
    private int clickOnWidgetSearchInText(int startPosition, boolean goBack) {
        WebElement matches = waitForPresenceOfElementLocatedBy(By.cssSelector(".matches"));
//        String backgroundMatches = matches.getCssValue("background-color");
//        postponedAssertEquals(backgroundMatches, "rgba(255, 240, 176, 1)", "Цвет найденного слова в поиске не желтый");

        int wordPosition = matches.getLocation().getY();
        int endPosition = waitForVisibilityOfElementLocatedBy(By.id("header"), "Заголовок не найден").getLocation().getY();
        if (goBack) {
            postponedAssertTrue(endPosition != startPosition && endPosition - wordPosition < DOCUMENT_LOCATION ||
                    endPosition == startPosition && endPosition - wordPosition < DOCUMENT_LOCATION, "Документ не проскроллился к результатам поиска");
        } else {
            postponedAssertTrue(endPosition != startPosition && wordPosition - endPosition < DOCUMENT_LOCATION ||
                    endPosition == startPosition && wordPosition - endPosition < DOCUMENT_LOCATION, "Документ не проскроллился к результатам поиска");
        }

        return wordPosition;
    }

    @Step("Проверяется что 'Быстрое оглавление' отображается")
    public void checkSoderIsPresent() {
        WebElement soder = findElementByNoThrow(mainContentElement, By.cssSelector(".list_type_contents"));
        assertNotNull(soder, "'Быстрое оглавление' не найдено");
        postponedAssertTrue(soder.isDisplayed(), "'Быстрое оглавление' не отображается");

        List<WebElement> soderElementList = soder.findElements(By.tagName("li"));
        postponedAssertFalse(soderElementList.isEmpty(), "Список элементов в 'Быстрое оглавление' пуст");

        WebElement activeItem = findElementByNoThrow(soder, By.cssSelector(".link_state_active"));
        postponedAssertNotNull(activeItem, "Не один элемент не выбран в 'Быстрое оглавление'");
    }

    @Step("Проверяется что кнопка Помощник отображается")
    public void checkHelperButtonIsPresent() {
        WebElement footer = waitForPresenceOfElementLocatedBy(By.cssSelector(".toolbar"));
        WebElement myHelperBtn = findElementByNoThrow(footer, By.id("assistant-btn"));
        assertNotNull(myHelperBtn, "Кнопка Помощник не найдена");
        postponedAssertTrue(myHelperBtn.isDisplayed(), "Кнопка Помощник не отображается");
        postponedAssertEquals(myHelperBtn.getText(), "Помощник", "Неправильный текст кнопки Помощник");
    }

    @Step("Проверяется что кнопка 'Содержание' отображается")
    public void checkSoderButtonIsPresent() {
        WebElement content = waitForPresenceOfElementLocatedBy(By.cssSelector(".toolbar"));
        WebElement soderButton = findElementByNoThrow(content, TABLE_OF_CONTENTS_BUTTON_LOCATOR);
        postponedAssertNotNull(soderButton, "Кнопка 'Содержание' не найдена");
        postponedAssertTrue(soderButton.isDisplayed(), "Кнопка 'Содержание' не отображается");
    }

    @Step("Проверяется что кнопки добавить в избранное отображается")
    public void checkAddToFavoritesButtonsForDocumentArePresent() {
        List<WebElement> addToFavoritesBtnList = getAddToFavoritesButtonList();
        postponedAssertFalse(addToFavoritesBtnList.isEmpty(), "Кнопка добавить в избранное Отсутствует");
    }

    @Step("Проверяется что кнопка добавить в избранное отображается")
    public void checkAddToFavoritesButtonForMagazinesIsPresent() {
        WebElement favBtn = findElementByNoThrow(mainContentElement, By.id("fav-marker"));

        postponedAssertNotNull(favBtn, "Кнопка добавить в избранное не найдена");
        postponedAssertTrue(favBtn.isDisplayed(), "Кнопка добавить в избранное не отображается");
    }

    @Step("Проверяется что кнопка добавить в избранное не отображается")
    public void checkAddToFavoritesButtonForMagazinesIsAbsent() {
        WebElement favBtn = findElementByNoThrow(mainContentElement, By.id("fav-marker"));
        postponedAssertNull(favBtn, "Кнопка добавить в избранное отображается");
    }

    @Step("Проверяется что кнопки добавить в избранное отображается")
    public void checkAddToFavoritesButtonIsPresent() {
        WebElement document = getDocumentBody();
        WebElement addToFavoritesBtn = findElementByNoThrow(document, By.cssSelector("[data-anchor*='/document']"));
        assertNotNull(addToFavoritesBtn, "Кнопка добавить в избранное Отсутствует");
    }

    @Step("Проверяется что кнопка добавить в избранное подсвечена для добавленной статьи")
    public void checkAddToFavoritesButtonIsHighlighted() {
        scrollToStart();
        String btnLocator = String.valueOf(getParameter(BUTTON_LOCATOR));
        WebElement button = waitForPresenceOfElementLocatedBy(By.cssSelector("[data-anchor='" + btnLocator + "']"));
        postponedAssertTrue(button.getAttribute("class") != null && button.getAttribute("class").contains("added"), "Кнопка добавить в избранное не подсвечена");
    }

    @Step("Проверяется что кнопка добавить в избранное не подсвечена для статьи удаленной из избранного")
    public void checkAddToFavoritesButtonIsNotHighlighted() {
        String btnLocator = String.valueOf(getParameter(BUTTON_LOCATOR));
        if (getCurrentUrl().contains("video")) {
            btnLocator = btnLocator.replaceAll("documentvideo", "document");
        } else if (getCurrentUrl().contains("wizard")) {
            btnLocator = btnLocator.replaceAll("wizard", "document");
        }
        WebElement button = waitForPresenceOfElementLocatedBy(By.cssSelector("[data-anchor='" + btnLocator + "']"));
        postponedAssertTrue(button.getAttribute("class") != null && !button.getAttribute("class").contains("added"), "Кнопка добавить в избранное подсвечена после удаления из Избранного");
    }

    @Step("Проверяется что кнопка добавить в избранное не подсвечена для статьи удаленной из избранного")
    public void checkAddToFavoritesButtonForMagazinesIsNotHighlighted() {
        waitForReloadingPage();
        scrollToStart();
        WebElement button = findElementByNoThrow(By.id("fav-marker"));
        postponedAssertTrue(button.getAttribute("data-bookmarkid") == null, "Кнопка добавить в избранное подсвечена после удаления из Избранного");
    }

    @Step("Проверяется что кнопка добавить в избранное подсвечена для добавленной статьи")
    public void checkAddToFavoritesButtonForMagazinesIsHighlighted() {
        waitForReloadingPage();
        scrollToStart();
        WebElement button = findElementByNoThrow(By.id("fav-marker"));
        postponedAssertTrue(button.getAttribute("data-bookmarkid") != null, "Кнопка добавить в избранное не подсвечена");
    }

    @Step("Проверяется что добавленный в Мое избранное документ отображается в меню Мое избранное")
    public void checkAddedItemIsPresentInMyFavoritesMenu() {
        String addedItemLocator = String.valueOf(getParameter(BUTTON_LOCATOR));
        WebElement favoritesMenu = getBookmarkRubricator();
        List<WebElement> addToFavoritesList = favoritesMenu.findElements(By.cssSelector(".b-info__title-text"));
        postponedAssertFalse(addToFavoritesList.isEmpty(), "Меню Мое избранное пустое");
        if (getCurrentUrl().contains("video")) {
            addedItemLocator = addedItemLocator.replaceAll("document", "documentvideo");
        } else if (getCurrentUrl().contains("wizard")) {
            addedItemLocator = addedItemLocator.replaceAll("document", "wizard");
        } else if (getCurrentUrl().contains("calculator")) {
            addedItemLocator = addedItemLocator.replaceAll("document", "calculator");
        }
        WebElement addedItemInMenu = findElementByNoThrow(favoritesMenu, By.cssSelector("[href*='" + addedItemLocator + "']"));
        postponedAssertNotNull(addedItemInMenu, "Добавленная статья не найдена в меню Мое избранное");
        waitForPresenceOfElementLocatedBy(By.id("favorites-btn")).click();
    }

    @Step("Проверяется что удаленный из избранного документ не отображается в меню Мое избранное")
    public void checkDeletedItemIsAbsentInMyFavoritesMenu() {
        String addedItemLocator = String.valueOf(getParameter(BUTTON_LOCATOR));
        WebElement favoritesMenu = getBookmarkRubricator();
        List<WebElement> addToFavoritesList = favoritesMenu.findElements(By.cssSelector(".b-info__title-text"));
        if (!addToFavoritesList.isEmpty()) {
            if (getCurrentUrl().contains("video")) {
                addedItemLocator = addedItemLocator.replaceAll("document", "documentvideo");
            } else if (getCurrentUrl().contains("wizard")) {
                addedItemLocator = addedItemLocator.replaceAll("document", "wizard");
            } else if (getCurrentUrl().contains("calculator")) {
                addedItemLocator = addedItemLocator.replaceAll("document", "calculator");
            }
            WebElement addedItemInMenu = findElementByNoThrow(favoritesMenu, By.cssSelector("[href*='" + addedItemLocator + "']"));
            postponedAssertNull(addedItemInMenu, "Удаленный из избранного документ отображается в меню Мое избранное");
        }
        waitForPresenceOfElementLocatedBy(By.id("favorites-btn")).click();
    }

    @Step("Проверяется что комментарии отображаются")
    public void checkCommentsArePresentOld() {
        WebElement document = getDocumentBody();
        WebElement commentsElement = findElementByNoThrow(document, By.cssSelector(".forms-comments"));
        if (commentsElement != null) {
            List<WebElement> comments = commentsElement.findElements(By.cssSelector(".comment"));
            postponedAssertFalse(comments.isEmpty(), "Список комментариев пуст");
            for (WebElement comment : comments) {
                postponedAssertTrue(comment.isDisplayed(), "Комментарий не отображается");
                postponedAssertFalse(comment.getText().isEmpty(), "Текст коментария пуст");
            }
        } else {
            warning("В документе отсутсвуют комментарии. Проверка не проводилась.");
        }
    }

    @Step("Проверяется что видеоплеер отображается")
    public void checkVideoPlayerIsPresent() {
        boolean youtubePlayer = isYoutubeVideo();
        WebElement player;
        if (youtubePlayer) {
            player = findElementByNoThrow(mainLeftElement, By.id("video-player-youtube"));
        } else {
            player = findElementByNoThrow(mainLeftElement, By.id("video-player-object"));
        }
        assertNotNull(player, "Видеоплеер не найден");
        postponedAssertTrue(player.isDisplayed(), "Видеоплеер не отображается");
    }

    @Step("Проверяется что кнопки переключения частей отображаются")
    public void checkNavigationButtonsForVideoArePresent() {
        WebElement nextButton;
        WebElement prevButton;
        if (!getSettings().isRunKss()) {
            // BSS
            nextButton = findElementByNoThrow(mainLeftElement, By.cssSelector(".play-forward"));
            prevButton = findElementByNoThrow(mainLeftElement, By.cssSelector(".play-backward"));
        } else {
            // KSS
            nextButton = findElementByNoThrow(mainLeftElement, By.cssSelector(".play-forward"));
            prevButton = findElementByNoThrow(mainLeftElement, By.cssSelector(".play-backward"));
        }
        WebElement eNextButton = findElementByNoThrow(mainLeftElement, By.cssSelector(".e-next"));

        postponedAssertTrue(nextButton != null || eNextButton != null, "Кнопка Следующая часть не найдена");
        if (nextButton != null) {
            postponedAssertTrue(nextButton.isDisplayed(), "Кнопка Следующая часть не отображается");
        }

        if (eNextButton != null) {
            postponedAssertTrue(eNextButton.isDisplayed(), "Кнопка Следующая часть не отображается");
        }

        WebElement ePrevButton = findElementByNoThrow(mainLeftElement, By.cssSelector(".e-prev"));
        postponedAssertTrue(prevButton != null || ePrevButton != null, "Кнопка Предыдущая часть не найдена");
        if (prevButton != null) {
            postponedAssertTrue(prevButton.isDisplayed(), "Кнопка Предыдущая часть не отображается");
        }

        if (ePrevButton != null) {
            postponedAssertTrue(ePrevButton.isDisplayed(), "Кнопка Предыдущая часть не отображается");
        }
    }

    @Step("Проверяется что кнопки переключения частей отображаются")
    public void checkNavigationButtonsForBookArePresent() {
        WebElement content = waitForPresenceOfElementLocatedBy(By.id("document-header"), "Заголовок документа не найден");
        WebElement nextButton = findElementByNoThrow(content, By.cssSelector(".btn_viewtype_forward"));
        WebElement eNextButton = findElementByNoThrow(content, By.cssSelector(".e-next"));

        postponedAssertTrue(nextButton != null || eNextButton != null, "Кнопка Следующая часть не найдена");
        if (nextButton != null) {
            postponedAssertTrue(nextButton.isDisplayed(), "Кнопка Следующая часть не отображается");
        }

        if (eNextButton != null) {
            postponedAssertTrue(eNextButton.isDisplayed(), "Кнопка Следующая часть не отображается");
        }

        WebElement prevButton = findElementByNoThrow(content, By.cssSelector(".btn_viewtype_backward"));
        WebElement ePrevButton = findElementByNoThrow(content, By.cssSelector(".e-prev"));
        postponedAssertTrue(prevButton != null || ePrevButton != null, "Кнопка Предыдущая часть не найдена");
        if (prevButton != null) {
            postponedAssertTrue(prevButton.isDisplayed(), "Кнопка Предыдущая часть не отображается");
        }

        if (ePrevButton != null) {
            postponedAssertTrue(ePrevButton.isDisplayed(), "Кнопка Предыдущая часть не отображается");
        }
    }

    @Step("Проверяется что заголовок видеосеминара отображается")
    public void checkVideoTitleIsPresent() {
        WebElement header = mainLeftElement.findElement(By.id("document-body"));
        WebElement videoTitle = findElementByNoThrow(header, By.tagName("h1"));
        assertNotNull(videoTitle, "Заголовок видеосеминара не найден");
        postponedAssertTrue(videoTitle.isDisplayed(), "Заголовок видеосеминара не отображается");
        postponedAssertFalse(videoTitle.getText().isEmpty(), "Заголовок видеосеминара пуст");
    }

    @Step("Проверяется что заголовок части видеосеминара отображается")
    public void checkVideoPartTitleIsPresent() {
        WebElement header = mainLeftElement.findElement(By.id("document-body"));
        WebElement videoPartTitle = findElementByNoThrow(header, By.tagName("p"));
        assertNotNull(videoPartTitle, "Заголовок части видеосеминара не найден");
        postponedAssertTrue(videoPartTitle.isDisplayed(), "Заголовок части видеосеминара не отображается");
        postponedAssertFalse(videoPartTitle.getText().isEmpty(), "Заголовок части видеосеминара пуст");
    }

    @Step("Проверяется что Список частей отображается")
    public void checkVideoPartsArePresent() {
        WebElement partsElement = findElementByNoThrow(mainLeftElement, By.cssSelector(".video-list"));
        postponedAssertNotNull(partsElement, "Список частей не найден");
        if (partsElement != null) {
            postponedAssertTrue(partsElement.isDisplayed(), "Список частей не отображается");
            List<WebElement> videoParts = partsElement.findElements(By.tagName("li"));
            postponedAssertFalse(videoParts.isEmpty(), "Список частей пуст");
        }
    }

    @Step("Проверяется что напротив проигрываемой части отображается значек 'play'")
    public void checkActivePartHasPlayButton() {
        WebElement partsElement = findElementByNoThrow(mainLeftElement, By.cssSelector(".video-list"));
        postponedAssertNotNull(partsElement, "Список частей не найден");
        if (partsElement != null) {
            WebElement activePart = findElementByNoThrow(partsElement, By.cssSelector(".selected"));
            postponedAssertNotNull(activePart, "Проигрываемая часть не найдена в Списке частей");
            if (activePart != null) {
                String currentUrl = getCurrentUrl();
                String activePartUrl = activePart.findElement(By.tagName("a")).getAttribute("href");
                postponedAssertTrue(currentUrl.contains(activePartUrl), "Кнопка play отображается для другой части");
            }
        }
    }

    @Step("Нажать любую кнопку добавить в избранное")
    public void clickRandomAddToFavoritesForKodeksButton() {
        scrollToStart();
        List<WebElement> addToFavoritesButtonList = getAddToFavoritesButtonListForKodeks();
        WebElement randomBtn = addToFavoritesButtonList.get(0);
        String btnLocator = randomBtn.getAttribute("data-anchor");
        setParameter(BUTTON_LOCATOR, btnLocator);
        waitForFavButtonWillBeAdded(By.cssSelector("[data-anchor*='" + btnLocator + "']"));
    }

    @Step("Нажать любую кнопку добавить в избранное")
    public void clickRandomAddToFavoritesForDocumentButton() {
        List<WebElement> addToFavoritesButtonList = getAddToFavoritesButtonList();
        WebElement randomBtn = addToFavoritesButtonList.get(0);
        String btnLocator = randomBtn.getAttribute("data-anchor");
        setParameter(BUTTON_LOCATOR, btnLocator);
        waitForFavButtonWillBeAdded(randomBtn);
    }

    @Step("Нажать любую кнопку добавить в избранное")
    public void clickRandomAddToFavoritesForMagazinesButton() {
        waitForReloadingPage();
        WebElement randomBtn = findElementByNoThrow(By.id("fav-marker"));
        String btnLocator = getCurrentUrl().split("#")[1].split("\\?")[0];
        setParameter(BUTTON_LOCATOR, btnLocator);
        randomBtn.click();
//        waitForFavButtonWillBeAdded(randomBtn);
    }

    @Step("Нажать любую кнопку добавить в избранное")
    public void clickRandomAddToFavoritesButton() {
        WebElement randomBtn = findElementBy(By.cssSelector("[data-anchor*='/document']"));
        String btnLocator = randomBtn.getAttribute("data-anchor");
        setParameter(BUTTON_LOCATOR, btnLocator);
        randomBtn.click();
        waitForFavButtonWillBeAdded(randomBtn);
    }

    @Step("Проверяется что контент отображается для открытого документа")
    public void checkContentIsPresent() {
        WebElement documentBody = findElementByNoThrow(By.id("document-body"));
        postponedAssertNotNull(documentBody, "Элемент документа не найден");
        if (documentBody != null) {
            postponedAssertFalse(documentBody.getText().isEmpty(), "Отсутствует контент для документа: " + getCurrentUrl());
        }
    }

    @Step("Проверяется что текст в рубрикаторе содержания отображается")
    public void checkTableOfContentsIsNotEmpty(String bookUrl) {
        WebElement content = waitForPresenceOfElementLocatedBy(By.cssSelector(".toolbar"));
        WebElement tableOfContentsButton = content.findElement(TABLE_OF_CONTENTS_BUTTON_LOCATOR);
        tableOfContentsButton.click();
        WebElement tableOfContents = getDescription();
        waitForTextToBePresentInWithErrorMessage(tableOfContents, "Отсутствует текст в рубрикаторе содержания");
        postponedAssertFalse(tableOfContents.getText().isEmpty(), "Отсутствует текст в рубрикаторе содержания");
    }

    @Step("Проверяется что Меню навигации отображается")
    public void checkNavigationButtonsForMagazinesArePresent() {
        WebElement header = getDocumentHeaderForMagazines();
        WebElement navigationElement = findElementByNoThrow(header, By.cssSelector(".e-pages"));
        postponedAssertNotNull(navigationElement, "Меню навигации не найдено");
        if (navigationElement != null) {
            WebElement info = findElementByNoThrow(navigationElement, By.tagName("p"));
            postponedAssertNotNull(info, "Информация о текущей статье в Меню навигции не найдена");
            postponedAssertTrue(info.isDisplayed(), "Информация о текущей статье в Меню навигции не отображается");
            postponedAssertFalse(info.getText().isEmpty(), "Текст информации о текущей статье в Меню навигции пуст");

            WebElement nextButton = findElementByNoThrow(navigationElement, By.cssSelector(".e-next"));
            if (isLastArticle(info.getText())) {
                postponedAssertNull(nextButton, "Кнопка Следующая статья в Меню навигации отображается для последней статьи");
            } else {
                postponedAssertNotNull(nextButton, "Кнопка Следующая статья в Меню навигации не найдена");
                postponedAssertTrue(nextButton.isDisplayed(), "Кнопка Следующая статья в Меню навигации не отображается");
            }

            WebElement prevButton = findElementByNoThrow(navigationElement, By.cssSelector(".e-prev"));
            if (isFirstArticle(info.getText())) {
                postponedAssertNull(prevButton, "Кнопка Предыдущая статья в Меню навигации не найдена отображается для первой статьи");
            } else {
                postponedAssertNotNull(prevButton, "Кнопка Предыдущая статья в Меню навигации не найдена");
                postponedAssertTrue(prevButton.isDisplayed(), "Кнопка Предыдущая статья в Меню навигации не отображается");
            }
        }
    }

    @Step("Проверяется что список статей на главной странице журнала отображается")
    public void checkListOfArticlesOnMainMagazinesPageArePresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".e-content"), "Документ не найден");
        List<WebElement> articles = content.findElements(By.tagName("a"));
        postponedAssertFalse(articles.isEmpty(), "Список статей пуст");
    }

    @Step("Проверяется что список статей на главной странице книги отображается")
    public void checkListOfArticlesOnMainBookPageArePresent() {
        WebElement content = getDocumentBody();
        List<WebElement> articles = content.findElements(By.tagName("a"));
        postponedAssertFalse(articles.isEmpty(), "Список статей пуст");
    }

    @Step("Проверяется работа стрелок-листалок")
    public void checkNavigationButtonFunctionality() {
        WebElement header = getDocumentHeaderForMagazines();
        WebElement navigationElement = header.findElement(By.cssSelector(".e-pages"));
        WebElement nextButton = findElementByNoThrow(navigationElement, By.cssSelector(".e-next"));
        WebElement prevButton = findElementByNoThrow(navigationElement, By.cssSelector(".e-prev"));

        String currentUrl = getCurrentUrl().split("\\?")[0];

        if (nextButton != null) {
            String nextUrl = nextButton.getAttribute("href");
            String prevUrl = prevButton.getAttribute("href");

            clickNextButton();
            postponedAssertTrue(getCurrentUrl().contains(nextUrl), "Следующая статья не открыта");

            clickPreviousButton();
            postponedAssertTrue(getCurrentUrl().contains(currentUrl), "Предыдущая статья не открыта");

            clickPreviousButton();
            postponedAssertTrue(getCurrentUrl().contains(prevUrl), "Предыдущая статья не открыта");

            clickNextButton();
            postponedAssertTrue(getCurrentUrl().contains(currentUrl), "Следующая статья не открыта");
        }
    }

    @Step("Проверяется что открытая статья подсвечена в рубрикаторе Содержания")
    public void checkCurrentItemIsHighlightedInTableOfContents() {
        String currentUrl = getCurrentUrl();
        WebElement content = getDescriptionElement();
        WebElement highlightedItem = findElementByNoThrow(content, By.cssSelector(".highlight"));
        if (highlightedItem != null) {
            String highlightedUrl = highlightedItem.findElement(By.tagName("a")).getAttribute("href");
            postponedAssertTrue(currentUrl.contains(highlightedUrl), "Открытая статья неподсвечена в рубрикаторе Содержания");
        } else {
            setPostponedTestFail("Не один элемент не выбран в рубрикаторе содержания");
        }
    }

    @Step("Проверяется что открытая статья подсвечена в рубрикаторе Содержания")
    public void checkCurrentItemIsHighlightedInTableOfContentsForKodeks() {
        String currentUrl = getCurrentUrl().split("#")[1].split("\\?")[0];
        WebElement content = getDescriptionElement();
        List<WebElement> itemList = content.findElements(By.cssSelector(".article"));

        WebElement highlightedItem = content.findElement(By.cssSelector(".highlight"));
        WebElement currentItem = getParentElement(content.findElement(By.cssSelector("[href*='" + currentUrl + "']")));

        int highlightItemIndex = itemList.indexOf(highlightedItem);
        int currentItemIndex = itemList.indexOf(currentItem);

        postponedAssertTrue(highlightItemIndex - 5 < currentItemIndex && highlightItemIndex + 5 > currentItemIndex, "Текущая статья не выбрана в рубрикаторе Содержания");
    }

    @Step("Проверяется что форма авторизации отображается")
    public void checkAuthFormIsPresent() {
        WebElement authForm = findElementByNoThrow(mainLeftElement, By.cssSelector(".whiteboard-control"));
        postponedAssertNotNull(authForm, "Форма авторизации не найдена");
        if (authForm != null) {
            postponedAssertTrue(authForm.isDisplayed(), "Форма авторизации не отображается");
        }
    }

    @Step("Проверяется что открыта выбранная статья")
    public void checkSelectedArticleIsOpened() {
        String selectedItemUrl = String.valueOf(getParameter(RANDOM_ITEM_URL));
        String currentUrl = getCurrentUrl();
        postponedAssertTrue(currentUrl.contains(selectedItemUrl), "Статья, выбранная в рубрикаторе Содержания, не открыта");
    }

    @Step("Проверяется что название журнала отображается")
    public void checkMagazineNameIsPresent() {
        WebElement header = waitForVisibilityOfAllElementsLocatedBy(By.cssSelector(".e-wrapper"), "Заголовок документа не найден").get(1);
        WebElement title = findElementByNoThrow(header, By.cssSelector("[class*='top']"));
        WebElement oldTitle = findElementByNoThrow(header, By.tagName("h2"));
        postponedAssertTrue(title != null || oldTitle != null, "Заголовок документа не найден");

        WebElement logo = findElementByNoThrow(header, By.cssSelector("[class*='-logo']"));
        WebElement oldLogo = findElementByNoThrow(header, By.cssSelector(".description-image"));

        postponedAssertTrue(logo != null || oldLogo != null, "Название журнала не найдено");

        if (logo != null) {
            WebElement logoImg = logo.findElement(By.tagName("img"));
            waitForImageLoadedWithErrorMessage(logoImg, "Название журнала не отображается");
        }

        if (oldLogo != null) {
            WebElement logoImg = oldLogo.findElement(By.tagName("img"));
            waitForImageLoadedWithErrorMessage(logoImg, "Название журнала не отображается");
        }
    }

    @Step("Проверяется что номер журнала отображается")
    public void checkMagazineNumberIsPresent() {
        WebElement header = waitForVisibilityOfAllElementsLocatedBy(By.cssSelector(".e-wrapper"), "Заголовок документа не найден").get(1);
        WebElement title = findElementByNoThrow(header, By.cssSelector("[class*='top']"));
        if (title != null) {
            WebElement number = findElementByNoThrow(title, By.cssSelector("[class*='date']"));
            postponedAssertNotNull(number, "Номер журнала не найден");
            if (number != null) {
                waitForTextToBePresentInWithErrorMessage(number, "Текст с номером журнала пустой");
            }
        }
    }

    @Step("Проверяется что документ не пустой")
    public DocumentHelper checkDocumentIsNotEmpty() {
        checkEmptyDocumentHeader();
        checkEmptyDocument();
        return this;
    }

    @Step("Проверяется заглушка для 'Документ не найден'")
    public void checkEmptyDocumentStub() {
        try {
            waitForVisibilityOfElementLocatedBy(By.id("main-container"));
        } catch (TimeoutException ignored) {
        }
        WebElement body = findElementByNoThrow(mainContentElement, By.cssSelector(".main-content"));
        postponedAssertNotNull(body != null, "Заглушка не найдена. Урл документа - " + getCurrentUrl());
        if (body != null) {
            WebElement header = findElementByNoThrow(body, By.tagName("h1"));
            postponedAssertNotNull(header, "Заголовок заглушки не найден. Урл документа - " + getCurrentUrl());
            if (header != null) {
                postponedAssertTrue(header.getText().trim().equals("Документ не найден") || header.getText().trim().equals("Сервис временно не работает"), "Неправильный текст заглушки. Урл документа - " + getCurrentUrl());
            }
        }
    }

    @Step("Провереятся что блок 'Публикации' не отображается в блоке 'Справка'")
    public void checkPublicationBlockIsNotPresent() {
        WebElement informationBlock = waitForVisibilityOfElementLocatedBy(By.id("infobar-card"), "Блок 'Справка' не найден в заголовке документа");
        WebElement publicationBlock = findElementByNoThrow(informationBlock, By.xpath("//strong[text()='Публикации']"));
        postponedAssertNull(publicationBlock, "Блок 'Публикации' присутсвует в блоке 'Справка'");
    }

    @Step("Открыть случайную статью из содержания книги")
    public void clickRandomArticle() {
        List<WebElement> chapterList = mainContentElement.findElements(By.cssSelector(".description-list"));
        List<WebElement> articleList = new ArrayList<WebElement>();
        for (WebElement chapter : chapterList) {
            articleList.addAll(chapter.findElements(By.tagName("a")));
        }
        WebElement randomArticle = getRandomElementInList(articleList);
        String articleUrl = randomArticle.getAttribute("href");
        report("Открывается " + articleUrl);
        randomArticle.click();
    }

    @Step("Нажать на кнопку рубрикатор содержания")
    public void clickTableOfContentsButton() {
        WebElement footer = waitForPresenceOfElementLocatedBy(By.cssSelector(".toolbar"));
        WebElement tableOfContentsButton = footer.findElement(TABLE_OF_CONTENTS_BUTTON_LOCATOR);
        tableOfContentsButton.click();
        waitForReloadingPage();
//        WebElement content = getDescriptionElement();
//        waitForTextToBePresentIn(content);
    }

    @Step("Открыть случайную статью из рубрикатора Содержания")
    public void clickRandomArticleFromTableOfContents() {
        WebElement content = getDescriptionElement();
        List<WebElement> items = content.findElements(By.tagName("a"));
        items = items.subList(2, items.size() - 1);
        WebElement randomItem = getRandomElementInList(items);
        String randomItemUrl = randomItem.getAttribute("href");
        setParameter(RANDOM_ITEM_URL, randomItemUrl);
        randomItem.click();
        waitForReloadingPage();
    }

    @Step("Открыть случайную статью с главной страницы журнала")
    public void clickRandomArticleFromMagazinesMainPage() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".e-content"), "Страница не найдена");
        List<WebElement> articles = content.findElements(By.tagName("a"));
        WebElement randomArticle = getRandomElementInList(articles);
        String randomUrl = randomArticle.getAttribute("href");
        setParameter(RANDOM_ITEM_URL, randomUrl);
        randomArticle.click();
        waitForReloadingPage();
    }

    @Step("Удалить документ из избранного")
    public void clickDeleteFromFavoritesButton() {
        WebElement deleteFromFavoritesButton = findElementByNoThrow(mainContentElement, By.cssSelector(".added"));
        if (deleteFromFavoritesButton != null) {
            if (deleteFromFavoritesButton.getAttribute("id") != null) {
                String btnLocator = getCurrentUrl().split("#")[1].split("\\?")[0];
                setParameter(BUTTON_LOCATOR, btnLocator);
            } else {
                setParameter(BUTTON_LOCATOR, deleteFromFavoritesButton.getAttribute("data-anchor"));
            }
            waitForFavButtonWillBeRemoved(deleteFromFavoritesButton);
        } else {
            setPostponedTestFail("В документе нет ни одной выбранной звездочки");
        }
    }

    public void clickNextButton() {
        WebElement navigationElement = waitForVisibilityOfElementLocatedBy(By.cssSelector(".e-pages"), "Блок навигации по страницам не найден");
        WebElement nextButton = navigationElement.findElement(By.cssSelector(".e-next"));
        nextButton.click();
        waitForReloadingPage();
    }

    public void clickPreviousButton() {
        WebElement navigationElement = waitForVisibilityOfElementLocatedBy(By.cssSelector(".e-pages"), "Блок навигации по страницам не найден");
        WebElement prevButton = navigationElement.findElement(By.cssSelector(".e-prev"));
        prevButton.click();
        waitForReloadingPage();
    }

    @Step("Открыть блок 'Справка' в заголовке документа")
    public void clickInformationLink() {
        WebElement document = getDocumentHeader();
        WebElement infoBarWidget = document.findElement(By.cssSelector("[data-rel='infobar-card']"));
        infoBarWidget.findElement(By.tagName("a")).click();
    }

    private boolean isFirstArticle(String navigationInfo) {
        String[] infoArr = navigationInfo.split(" ");
        if (infoArr.length == 4) {
            return Integer.parseInt(infoArr[1]) == 1;
        } else {
            return Integer.parseInt(infoArr[0]) == 1;
        }
    }

    private boolean isLastArticle(String navigationInfo) {
        String[] infoArr = navigationInfo.split(" ");
        if (infoArr.length == 4) {
            return Integer.parseInt(infoArr[1]) == Integer.parseInt(infoArr[3]);
        } else {
            return Integer.parseInt(infoArr[0]) == Integer.parseInt(infoArr[2]);
        }
    }

    private void checkEditLinkForElement(WebElement article) {
        WebElement editLink = article.findElement(By.cssSelector(".references")).findElement(By.tagName("a"));
        String url = editLink.getAttribute("href");
        checkLink(new Link(url));
    }

    private void checkBallsForElement(WebElement element) {
        clickBalls(element);
        waitFewSecond(1000);
        WebElement noteBook;
        noteBook = waitForPresenceOfElementLocatedBy(By.cssSelector(".m-references"));
        waitForTextToBePresentInWithErrorMessage(noteBook, "Блокнот не отображается");
        postponedAssertFalse(noteBook.getAttribute("style").isEmpty(), "Блокнот не отображается");
        postponedAssertFalse(noteBook.getText().isEmpty(), "Блокнот пуст");
    }

    private void checkLinksFromNotebook(WebElement chapter) {
        clickBalls(chapter);
        waitFewSecond(1000);
        WebElement noteBook = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-references-content"), "Блокнот не найден");
        waitForTextToBePresentIn(noteBook);
        List<WebElement> notebookLinks = noteBook.findElements(By.cssSelector("[href*='#/document']"));
        if (!notebookLinks.isEmpty()) {
            WebElement linkElement = getRandomElementInList(notebookLinks);
            String url = linkElement.getAttribute("href");
            if (url != null) {
                Link link = new Link(url);
                checkLink(link);
            }
        } else {
            warning("Отсутсвуют ссылки в блокноте");
        }
    }

    private WebElement getElementWithReferences(By by) {
        WebElement document = getDocumentBody();
        List<WebElement> elements = document.findElements(by);
        for (WebElement element : elements) {
            if (findElementByNoThrow(element, By.cssSelector(".backlink")) != null) {
                return element;
            }
        }
        return null;
    }

    private WebElement getElementWithEditLink(By by) {
        WebElement document = getDocumentBody();
        List<WebElement> chapters = document.findElements(by);
        for (WebElement chapter : chapters) {
            List<WebElement> references = chapter.findElements(By.cssSelector(".references"));
            if (!references.isEmpty()) {
                if (findElementByNoThrow(references.get(0), By.tagName("a")) != null) {
                    return chapter;
                }
            }
        }
        return null;
    }

    private WebElement getDocumentBody() {
        return waitForVisibilityOfElementLocatedBy(By.id("document-body"), "Документ не найден");
    }

    private WebElement getDocumentFooter() {
        return waitForVisibilityOfElementLocatedBy(By.id("document-footer"), "Нижний колонтитул не найден");
    }

    private double getHeightFromString(String heightString) {
        return Double.parseDouble(heightString.replace("px", ""));
    }

    private void clickBalls(WebElement element) {
        WebElement balls = element.findElement(By.cssSelector(".backlink")).findElement(By.cssSelector(".references"));
        if (getSettings().isRunKss()) {
            scrollIntoView(balls);
            balls.click();
        } else {
            int ballsY = balls.getLocation().getY();
            executeScript("window.scrollTo(" + 0 + ", " + (ballsY - 400) + "); return true;");

            Locatable button = (Locatable) balls;
            Mouse mouse = ((HasInputDevices) getDriver()).getMouse();
            mouse.click(button.getCoordinates());
        }
    }

    private List<WebElement> getArticlesContentList() {
        WebElement document = waitForPresenceOfElementLocatedBy(By.id("document-body"));
        return document.findElements(By.cssSelector(".doc__article"));
    }

    private List<WebElement> getAddToFavoritesButtonList() {
        WebElement document = waitForPresenceOfElementLocatedBy(By.id("document-body"));
        List<WebElement> elementList = document.findElements(By.cssSelector("[data-anchor*='/document']"));
        List<WebElement> addToFavoritesBtnList = new ArrayList<WebElement>();
        for (WebElement element : elementList) {
            if (element.getAttribute("data-role") != null) {
                String attribute = element.getAttribute("data-role");
                if (attribute.contains("anchor") && !attribute.contains("position")) {
                    addToFavoritesBtnList.add(element);
                }
            }
            if (addToFavoritesBtnList.size() >= 10) {
                break;
            }
        }
        return addToFavoritesBtnList;
    }

    private List<WebElement> getAddToFavoritesButtonListForKodeks() {
        WebElement document = waitForPresenceOfElementLocatedBy(By.id("document-body"));
        List<WebElement> elementList = document.findElements(By.cssSelector("[data-anchor*='/document']"));
        List<WebElement> addToFavoritesBtnList = new ArrayList<WebElement>();
        for (WebElement element : elementList) {
            if (element.getAttribute("data-role") != null) {
                String attribute = element.getAttribute("data-role");
                String phraseIdAttr = element.getAttribute("data-phrase-id");
                int phraseId = -1;
                if (phraseIdAttr != null && !phraseIdAttr.isEmpty()) {
                    try {
                        phraseId = Integer.parseInt(phraseIdAttr);
                    } catch (NumberFormatException ignored) {
                        continue;
                    }
                }
                if (attribute.contains("anchor") && !attribute.contains("position") && phraseId != -1 && phraseId > 10) {
                    addToFavoritesBtnList.add(element);
                }
            }
            if (addToFavoritesBtnList.size() >= 10) {
                break;
            }
        }
        return addToFavoritesBtnList;
    }

    private void waitForFavButtonWillBeAdded(By locator) {
        String addedAttribute = "added";
        int count = 0;
        while (count < 5) {
            WebElement randomBtn = waitForPresenceOfElementLocatedBy(locator);
            if (randomBtn.getAttribute("class").contains(addedAttribute)) {
                break;
            } else {
                scrollIntoView(randomBtn);
                waitFewSecond(10000);
                randomBtn.click();
                if (isAdded(locator, addedAttribute)) {
                    break;
                }
            }
            count++;
        }
    }

    private boolean isAdded(By locator, String addedAttribute) {
        try {
            refreshPage();
            WebElement randomBtn = waitForPresenceOfElementLocatedBy(locator);
            waitForAttributeUpdate(randomBtn, addedAttribute, 10);
            return true;
        } catch (TimeoutException ignored) {
            return false;
        }
    }

    private void waitForFavButtonWillBeAdded(WebElement randomBtn) {
        String addedAttribute = "added";
        int count = 0;
        while (count < 10) {
            scrollToElementLocationWithout200px(randomBtn);
            if (randomBtn.getAttribute("class").contains(addedAttribute)) {
                break;
            } else {
                randomBtn.click();
            }
            try {
                waitForAttributeUpdate(randomBtn, addedAttribute, 10);
                break;
            } catch (TimeoutException ignored) {
            }
            count++;
        }
    }

    private void waitForFavButtonWillBeRemoved(WebElement favBtn) {
        String addedAttribute = "added";
        int count = 0;
        while (count < 10) {
            scrollIntoView(favBtn);
            if (!favBtn.getAttribute("class").contains(addedAttribute)) {
                break;
            } else {
                favBtn.click();
            }
            try {
                waitForAttributeUpdate(favBtn, "class", addedAttribute, 10, true);
                break;
            } catch (TimeoutException ignored) {
            }
            count++;
        }
    }

    private WebElement getDocumentHeader() {
        WebElement headerWithClassLocator = findElementByNoThrow(mainContentElement, By.cssSelector(".document-header"));
        WebElement eHeader = findElementByNoThrow(mainContentElement, By.cssSelector(".e-header"));
        if (headerWithClassLocator != null) {
            return waitForPresenceOfElementLocatedBy(By.cssSelector(".document-header"));
        } else if (eHeader != null) {
            return waitForPresenceOfElementLocatedBy(By.cssSelector(".e-header"));
        } else {
            return waitForPresenceOfElementLocatedBy(By.id("document-header"));
        }
    }

    private WebElement getDescriptionElement() {
        return waitForVisibilityOfElementLocatedBy(By.cssSelector(".main-description-content"), "Рубрикатор содержания не найден");
    }

    private WebElement getBookmarkRubricator() {
        return waitForVisibilityOfElementLocatedBy(By.id("my-documents-bookmarks"), "Рубрикатор избранного не найден");
    }

    private WebElement getDocumentHeaderForMagazines() {
        return waitForVisibilityOfElementLocatedBy(By.cssSelector(".e-header"), "Заголовок документа не найден");
    }

    private WebElement getDescription() {
        return waitForVisibilityOfElementLocatedBy(By.id("main-description"), "Рубрикатор содержания не найден");
    }

    public void takeScreenShot(String imageName, String folder) {
        new Screenshoter().takeScreenshotForComparison(folder, imageName + ".png");
    }

    public void takeScreenShot(WebElement element, String imageName, String folder) {
        new Screenshoter().takeScreenshotForComparison(element, folder, imageName + ".png");
    }

    public DocumentHelper checkHighlightingWordDocument() {
        List<WebElement> searchWordList = findElementsBy(By.xpath("//span[@class='search-word' or @class='auto-matches']"));
        postponedAssertFalse(searchWordList.isEmpty(), "Слова поискового запроса не подсвечены в документе");
        return this;
    }

    public SearchResultHelper returnToSearchResultPage() {
        returnToBack();
        return redirectTo(SearchResultHelper.class);
    }

    @Step("Проверяется отображение названия и автора документа")
    public void checkBooksNameAndAuthor() {
        WebElement nameBooksAndAuthor = findElementByNoThrow(documentBody, By.xpath(".//div/div[@class='caps']"));
        if (nameBooksAndAuthor != null && nameBooksAndAuthor.isDisplayed()) {
            String nameBooksAndAuthorText = nameBooksAndAuthor.getText();
            postponedAssertTrue(!nameBooksAndAuthorText.isEmpty() && nameBooksAndAuthorText != null, "Не отображается название книги и автор");
        } else {
            setPostponedTestFail("Не найден элемент с названием и автором книги");
        }
    }

    public void checkBooksName() {
        WebElement nameBooksH1 = findElementByNoThrow(documentBody, By.tagName("h1"));
        if (nameBooksH1 != null && nameBooksH1.isDisplayed()) {
            String nameBooks = nameBooksH1.getText();
            postponedAssertTrue(!nameBooks.isEmpty() && nameBooks != null, "Не отображается название книги");
        } else {
            setPostponedTestFail("Не найден элемент название книги");
        }
    }

    public void checkAuthor() {
        WebElement author = findElementByNoThrow(documentBody, By.cssSelector(".author"));
        if (author != null && author.isDisplayed()) {
            String autorText = author.getText();
            postponedAssertTrue(!autorText.isEmpty() && autorText != null, "Не отображается автор");
        } else {
            setPostponedTestFail("Не найден элемент автор");
        }
    }

    @Step("Проверяется отображение обложки книги")
    public void checkImageBook() {
        WebElement descriptionImage = findElementByNoThrow(documentBody, By.cssSelector(".description-image"));
        if (descriptionImage != null && descriptionImage.isDisplayed()) {
            String urlBook = getPropertyValueElementAfter(".book", "background-image");
            postponedAssertTrue(urlBook != null && !urlBook.isEmpty(), "Не найдена ссылка обложку книги");
        } else {
            setPostponedTestFail("Не найден элемент обложка книги");
        }
    }

    @Step("Проверяется отображение названия документа")
    public void checkNameDocument() {
        WebElement nameDocument = findElementByNoThrow(documentBody, By.tagName("h2"));
        if (nameDocument != null && nameDocument.isDisplayed()) {
            String nameDocumentText = nameDocument.getText();
            postponedAssertTrue(nameDocumentText != null && !nameDocumentText.isEmpty(), "Не найдено название документа");
        } else {
            setPostponedTestFail("Не найден элемент Название документа");
        }
    }

    @Step("Проверяется отображение текста документа")
    public void checkDisplayTextDocumentInParagraphs() {
        List<WebElement> paragraphs = findElementsBy(documentBody, By.xpath(".//div/p"));
        for (WebElement paragraph : paragraphs) {
            String text = paragraph.getText();
            postponedAssertTrue(!text.isEmpty() && text != null, "Параграф не содержит текста");
        }
    }

    public void checkDisplayTextInJournal() {
        WebElement textElement = findElementByNoThrow(By.cssSelector(".e-content"));
        if (textElement != null && textElement.isDisplayed()) {
            String text = textElement.getText();
            postponedAssertTrue(text != null && !text.isEmpty(), "Не отображается текст статьи");
        } else
            setPostponedTestFail("Не отображается текст статьи");
    }

    @Step("Проверяется отображение звезд у параграфов")
    public void checkDisplayStars() {
        List<WebElement> paragraphs = findElementsBy(documentBody, By.xpath(".//div/p"));
        for (WebElement paragraph : paragraphs) {
            WebElement star = findElementBy(paragraph, By.xpath(".//a[@data-role='phrase-anchor']"));
            scrollToElementLocationWithout200px(paragraph);
            moveMouseToElement(paragraph.findElement(By.tagName("span")));
            waitForPresenceOf(star);
            postponedAssertTrue(star.isDisplayed(), "Не отображается звезда рядом с параграфом");
        }
    }

    @Step("Проверяется отображение звезд у параграфов")
    public void checkDisplayStarsInDictionary() {
        List<WebElement> paragraphs = documentBody.findElements(By.xpath(".//block/p"));
        for (WebElement paragraph : paragraphs) {
            WebElement star = findElementBy(paragraph, By.xpath(".//a[@data-role='phrase-anchor']"));
            moveMouseToElement(paragraph.findElement(By.tagName("span")));
            waitForPresenceOf(star);
            postponedAssertTrue(star.isDisplayed(), "Не отображается звезда рядом с параграфом");
        }
    }

    @Step("Проверяется отображение 'В избранное'")
    public void checkInMyFavoritesIcon() {
        WebElement inMyFavorites = findElementByNoThrow(By.id("fav-marker"));
        if (inMyFavorites != null) {
            postponedAssertTrue(inMyFavorites.isDisplayed(), "'В избранное' не отображается");
            postponedAssertEqualsText(inMyFavorites, "В избранное");
        } else {
            setPostponedTestFail("Не найден элемент 'В избранное'");
        }
    }

    @Step("Проверяется отображение 'Распечатать'")
    public void checkPrintIcon() {
        WebElement print;
        print = findElementByNoThrow(By.cssSelector("[title*='Распечатать']"));
        if (print == null) {
            print = findElementByNoThrow(By.id("print-journal"));
        }
        if (print != null) {
            postponedAssertTrue(print.isDisplayed(), "'Распечатать' не отображается");
        } else {
            setPostponedTestFail("Не найден элемент 'Распечатать'");
        }
    }

    @Step("Проверяется отображение 'Отправить'")
    public void checkShareIcon() {
        WebElement word = findElementByNoThrow(By.id("toggle-cover"));
        if (word != null) {
            postponedAssertTrue(word.isDisplayed(), "'Отправить' не отображается");
            if (!word.getText().isEmpty()) {
                postponedAssertEqualsText(word, "Отправить");
            }
        } else {
            setPostponedTestFail("Не найден элемент 'Отправить'");
        }
    }

    @Step("Проверяется отображение 'Предыдущая статья'")
    public void checkBackwardIcon() {
        List<WebElement> backwards = findElementsBy(By.cssSelector("[title*='Предыдущая статья']"), "Не найден элемент 'Предыдущая статья'");
        for (WebElement backward : backwards) {
            postponedAssertTrue(backward.isDisplayed(), "'Предыдущая статья' не отображается");
            String url = backward.getCssValue("background-image");
            postponedAssertTrue(url != null && !url.isEmpty(), "Не отображается стрелочка назад");
        }
        postponedAssertTrue(backwards.size() == 2, "Должно быть 2 меню навигации");
    }

    @Step("Проверяется отображение 'Следующая статья'")
    public void checkForwardIcon() {
        List<WebElement> forwards = findElementsBy(By.cssSelector("[title*='Следующая статья']"), "Не найден элемент 'Следующая статья'");
        for (WebElement forward : forwards) {
            postponedAssertTrue(forward.isDisplayed(), "'Следующая статья' не отображается");
            String url = forward.getCssValue("background-image");
            postponedAssertTrue(url != null && !url.isEmpty(), "Не отображается стрелочка назад");
        }
        postponedAssertTrue(forwards.size() == 2, "Должно быть 2 меню навигации");
    }

    @Step("Проверяется отображение 'Полистать'")
    public void checkBrowseIcon() {
        WebElement word = findElementByNoThrow(By.cssSelector(".btn_content_browse"));
        if (word != null) {
            postponedAssertTrue(word.isDisplayed(), "'Полистать' не отображается");
            postponedAssertEqualsText(word, "Полистать");
        } else {
            setPostponedTestFail("Не найден элемент 'Полистать'");
        }
    }

    @Step("Проверяется отображение содержания")
    public void checkDisplayTableOfContents() {
        List<WebElement> texts = findElementsBy(documentBody, By.xpath(".//li[@data-tocavailable='true']"));
        List<WebElement> titleTexts = findElementsBy(documentBody, By.tagName("h2"));
        for (WebElement text : texts) {
            String tempText = text.getText();
            postponedAssertTrue(tempText != null && !tempText.isEmpty(), "Нет текста в Подпунктах");
        }
        for (WebElement text : titleTexts) {
            String tempText = text.getText();
            postponedAssertTrue(tempText != null && !tempText.isEmpty(), "Нет текста в Главных пунктах");
        }
    }

    @Step("Проверяется отображение содержания")
    public void checkDisplayTableOfContentsForKodeks() {
        List<WebElement> sections = getDescriptionElement().findElements(By.cssSelector(".section"));
        List<WebElement> chapters = getDescriptionElement().findElements(By.cssSelector(".chapter"));
        List<WebElement> articles = getDescriptionElement().findElements(By.cssSelector(".article"));
        assertFalse(sections.isEmpty(), "Отсутсвуют разделы в оглавлении");
        assertFalse(chapters.isEmpty(), "Отсутсвуют главы в оглавлении");
        assertFalse(articles.isEmpty(), "Отсутсвуют статьи в оглавлении");
        for (WebElement section : sections) {
            String tempText = section.getText();
            postponedAssertTrue(tempText != null && !tempText.isEmpty(), "Нет текста в Разделах");
        }
        for (WebElement chapter : chapters) {
            String tempText = chapter.getText();
            postponedAssertTrue(tempText != null && !tempText.isEmpty(), "Нет текста в Главах");
        }
        for (WebElement article : articles) {
            String tempText = article.getText();
            postponedAssertTrue(tempText != null && !tempText.isEmpty(), "Нет текста в Статьях");
        }
    }

    @Step("Проверяется отображение содержания")
    public void checkDisplayDescriptionList() {
        List<WebElement> texts = findElementsBy(documentBody, By.xpath(".//li[@class='description-list']"));
        for (WebElement text : texts) {
            String tempText = text.getText();
            postponedAssertTrue(tempText != null && !tempText.isEmpty(), "Нет текста в Подпунктах");
        }
    }

    @Step("Проверяется отображение названия журнала")
    public void checkDisplayNameJournal() {
        WebElement logo = findElementByNoThrow(By.cssSelector(".e-logo"));
        if (logo != null) {
            postponedAssertTrue(logo.isDisplayed(), "Название журнала не отображается");
        } else {
            setPostponedTestFail("Не найдено название Журнала");
        }
    }

    @Step("Проверяется отображение даты публикации журнала")
    public void checkPudDateJournal() {
        WebElement date = findElementByNoThrow(By.cssSelector(".e-date"));
        if (date != null && date.isDisplayed()) {
            String dateText = date.getText();
            postponedAssertTrue(dateText != null && !dateText.isEmpty(), "Нет текста даты");
        } else {
            setPostponedTestFail("Не найдена дата публикации журнала");
        }
    }

    @Step("Проверяется отображение названия статьи")
    public void checkArticleTitle() {
        WebElement articleTitle = findElementByNoThrow(By.id("e-header"));
        if (articleTitle != null && articleTitle.isDisplayed()) {
            String articleTitleText = articleTitle.getText();
            postponedAssertTrue(articleTitleText != null && !articleTitleText.isEmpty(), "Не найден текст заголовка статьи");
        } else {
            setPostponedTestFail("Не найден заголовок статьи");
        }
    }

    @Step("Проверяется отображение названия документа")
    public void checkDocumentTitleIsPresent() {
        WebElement articleTitle = findElementByNoThrow(By.cssSelector(".main__title"));
        if (articleTitle != null && articleTitle.isDisplayed()) {
            String articleTitleText = articleTitle.getText();
            postponedAssertTrue(articleTitleText != null && !articleTitleText.isEmpty(), "Не найден текст заголовка статьи");
        } else {
            setPostponedTestFail("Не найден заголовок статьи");
        }
    }

    @Step("Проверяется заголовок RSS")
    public void checkRSSTitle(String expectedRssTitle) {
        WebElement title = waitForPresenceOfElementLocatedBy(By.id("feedTitleText"));
        assertTrue(title != null && title.isDisplayed(), "Не найден заголовок");
        if (title != null && title.isDisplayed()) {
            String articleTitleText = title.getText();
            postponedAssertEquals(articleTitleText, expectedRssTitle, "Неправильный текст заголовка RSS");
        }
    }

    @Step("Проверяется отображение названия журнала 119")
    public void checkDisplayNameJournal_119() {
        WebElement logo = findElementByNoThrow(By.cssSelector(".media__image"));
        if (logo != null && logo.isDisplayed()) {
            String name = logo.getText();
            postponedAssertTrue(name != null && !name.isEmpty(), "Нет текста 'Название журнала'");
        } else {
            setPostponedTestFail("Не найдено название Журнала");
        }
    }

    @Step("Проверяется отображение названия статьи")
    public void checkArticleTitle_119() {
        WebElement articleTitle = findElementByNoThrow(By.cssSelector("[data-role='main__title']"));
        if (articleTitle != null && articleTitle.isDisplayed()) {
            String articleTitleText = articleTitle.getText();
            postponedAssertTrue(articleTitleText != null && !articleTitleText.isEmpty(), "Не найден текст заголовка статьи");
        } else {
            setPostponedTestFail("Не найден заголовок статьи");
        }
    }

    @Step("Проверяется отображение текста документа 119")
    public void checkDisplayTextDocumentInParagraphs_119() {
        List<WebElement> paragraphs = findElementsBy(documentBody, By.xpath(".//section/p"));
        for (WebElement paragraph : paragraphs) {
            if (paragraph.isDisplayed()) {
                String text = paragraph.getText();
                postponedAssertTrue(text != null && !text.isEmpty(), "Параграф не содержит текста");
            }
        }
    }

    @Step("Проверяется отображение звезд у параграфов")
    public void checkDisplayStarsSection() {
        List<WebElement> paragraphs = findElementsBy(documentBody, By.xpath(".//section/p"));
        for (WebElement paragraph : getRandomElementsInList(paragraphs, paragraphs.size() < 3 ? paragraphs.size() : 3)) {
            WebElement star = findElementByNoThrow(paragraph, By.xpath(".//a[@data-role='phrase-anchor']"));
            if (star != null) {
                moveMouseToElement(paragraph.findElement(By.tagName("span")));
                waitForPresenceOf(star, "Не отображается звезда рядом с параграфом");
                postponedAssertTrue(star.isDisplayed(), "Не отображается звезда рядом с параграфом");
            } else {
                setPostponedTestFail("Не найден элемент 'звездочка'");
            }
        }
    }

    @Step("Проверяется отображение звезд у строк таблиц")
    public void checkDisplayStarsTable() {
        List<WebElement> paragraphs = findElementsBy(documentBody, By.xpath(".//tr[@data-role='phrase-row']"));
        for (WebElement paragraph : paragraphs) {
            WebElement star = findElementBy(paragraph, By.xpath(".//a[@data-role='phrase-anchor']"));
            moveMouseToElement(paragraph);
            waitForPresenceOf(star, "Не отображается звезда рядом с параграфом");
            postponedAssertTrue(star.isDisplayed(), "Не отображается звезда рядом с параграфом");
            if (getSettings().isRunKss()) {
                scrollScript(100);
            }
        }
    }

    @Step("Проверяется отображение звезд у строк таблиц")
    public void checkDisplayStarsTableWithScroll() {
        List<WebElement> paragraphs = findElementsBy(documentBody, By.xpath(".//tr[@data-role='phrase-row']"));
        for (WebElement paragraph : paragraphs) {
            WebElement star = findElementBy(paragraph, By.xpath(".//a[@data-role='phrase-anchor']"));
            scrollToElementLocationWithout200px(star);
            moveMouseToElement(star);
            waitForPresenceOf(star, "Не отображается звезда рядом с параграфом");
            postponedAssertTrue(star.isDisplayed(), "Не отображается звезда рядом с параграфом");
        }
    }

    @Step("Проверяется отображение названия журнала")
    public void checkDisplayNameJournal_192() {
        WebElement logo = findElementByNoThrow(By.cssSelector(".e-main-logo"));
        if (logo != null) {
            postponedAssertTrue(logo.isDisplayed(), "Название журнала не отображается");
        } else {
            WebElement elogo = findElementByNoThrow(By.cssSelector(".e-logo"));
            if (elogo != null) {
                postponedAssertTrue(elogo.isDisplayed(), "Название журнала не отображается");
            } else {
                setPostponedTestFail("Не найдено название Журнала");
            }
        }
    }

    @Step("Проверяется отображение номер журнала")
    public void checkNumberJournal_192() {
        WebElement date = findElementByNoThrow(By.cssSelector(".e-number-block"));
        if (date != null && date.isDisplayed()) {
            String dateText = date.getText();
            postponedAssertTrue(dateText != null && !dateText.isEmpty(), "Нет текста Номер журнала");
        } else {
            setPostponedTestFail("Не найдена номер журнала");
        }
    }

    @Step("Проверяется отображение содержания")
    public void checkDisplayTableOfContents_192() {
        List<WebElement> texts = findElementsBy(documentBody, By.xpath(".//li[@data-tocexists='true']"));
        List<WebElement> titleTexts = findElementsBy(documentBody, By.tagName("h2"));
        for (WebElement text : texts) {
            String tempText = text.getText();
            postponedAssertTrue(!tempText.isEmpty() && tempText != null, "Нет текста в Подпунктах");
        }
        for (WebElement text : titleTexts) {
            String tempText = text.getText();
            postponedAssertTrue(!tempText.isEmpty() && tempText != null, "Нет текста в Главных пунктах");
        }
    }

    @Step("Проверяется отображение названия и номера журнала")
    public void checkNameAndNumberJournal() {
        WebElement nameBooksH1 = findElementByNoThrow(documentBody, By.tagName("h1"));
        if (nameBooksH1 != null && nameBooksH1.isDisplayed()) {
            String nameBooks = nameBooksH1.getText();
            postponedAssertTrue(!nameBooks.isEmpty() && nameBooks != null, "Не отображается название журнала");
            postponedAssertTrue(nameBooks.contains("№"), "Не найден номер журнала");
        } else {
            setPostponedTestFail("Не найден элемент название и номер журнала");
        }
    }

    @Step("Проверяется, что В поисковой строке отображается меню 'поиск в тексте'")
    public void checkSearchIn() {
        WebElement searchIn = findElementByNoThrow(By.cssSelector(".search-in"));
        if (searchIn != null) {
            postponedAssertTrue(searchIn.isDisplayed(), "В поисковой строке НЕ отображается меню 'поиск в тексте'");
        } else {
            setPostponedTestFail("В поисковой строке НЕ отображается меню 'поиск в тексте'");
        }
    }

    @Step("Отображается 'Редакция действует с ...'")
    public void checkRevisionIsValidFrom() {
        WebElement revision = findElementByNoThrow(documentHeader, By.cssSelector("[data-rel='infobar-links']"));
        postponedAssertNotNull(revision, "Ссылка 'Другие редакции' не найдена");
        if (revision != null) {
            postponedAssertTrue(revision.getText().contains("Другие редакции"), "Ссылка 'Другие редакции' не найдена");
        }
    }

    @Step("Отображается меню \"Ответы/Рекомендации/Решения, Правовая база, см. также\" ")
    public void checkMenu() {
        WebElement revision = findElementByNoThrow(By.cssSelector("[data-rel='infobar-links']"));
        postponedAssertNotNull(revision, "Меню 'Другие редакции/Ответы/Рекомендации/Решения, Правовая база, см. также' не найдено");
        if (revision != null) {
            postponedAssertTrue(revision.getText().contains("Другие редакции") ||
                    revision.getText().contains("Ответы") ||
                    revision.getText().contains("Редакция утратила силу") ||
                    revision.getText().contains("Рекомендации") ||
                    revision.getText().contains("Решения") ||
                    revision.getText().contains("Правовая база") ||
                    revision.getText().contains("справочники") ||
                    revision.getText().contains("Справочник") ||
                    revision.getText().contains("Справочники") ||
                    revision.getText().contains("См. также") ||
                    revision.getText().contains("см. также"), "Меню ' Другие редакции/Ответы/Рекомендации/Решения, Правовая база, см. также' не найдено");
        }
    }

    @Step("Проверяется НЕ отображается 'Отправить'")
    public void checkNotPresentShareIcon() {
        WebElement word = findElementByNoThrow(By.id("toggle-cover"));
        postponedAssertNull(word, "'Отправить' отображается");
    }

    @Step("Проверятеся наличие обложки")
    public void checkDisplayCover() {
        WebElement cover = findElementByNoThrow(By.cssSelector(".description-image img"));
        if (cover != null) {
            postponedAssertTrue(cover.isDisplayed(), "Не отображается обложка журнала");
        } else {
            setPostponedTestFail("Не найдена обложка журнала");
        }
    }

    @Step("Проверяется наличие на странице видеоплееров")
    public void checkVideoPlayerParts() {
        WebElement doc = getDocumentBody();
        List<WebElement> videoParts = doc.findElements(By.cssSelector(".video-part"));
        postponedAssertFalse(videoParts.isEmpty(), "В документе не отображаются видео-плееры");
    }

    @Step("Проверяется 'быстрое оглавление'")
    public void checkQuickToc() {
        WebElement qToc = findElementByNoThrow(By.cssSelector(".main-sidebar-content"));
        if (qToc == null) {
            setPostponedTestFail("Не найдена обложка журнала");
        } else {
            List<WebElement> elementsMenu = qToc.findElements(By.tagName("li"));
            postponedAssertNotNull(elementsMenu, "Быстрое оглавление не содержит элементов");
        }
    }

    @Step("Проверяется нижний колонтитул (footer)")
    public void checkFooter() {
        WebElement foo = getDocumentFooter();
        if (foo == null) {
            setPostponedTestFail("Не найден нижний колонтитул");
        } else {
            // проверка работы ссылок в колонтитуле
            List<WebElement> wrappers = foo.findElements(By.cssSelector("wrapper"));
            for (WebElement wrapper : wrappers) {
                WebElement list = wrapper.findElement(By.tagName("ul"));
                List<WebElement> itemsList = list.findElements(By.tagName("li"));

                for (WebElement item : itemsList) {
                    WebElement link = findElementByNoThrow(item, By.tagName("a"));
                    if (link == null) {
                        continue;
                    }
                    String itemName = wrapper.getText();
                    postponedAssertFalse(itemName.isEmpty(), "Раздел колонтитула пуст");
                    link.click();
                    waitForReloadingPage();
                    // проверяем открывшийся документ
                    WebElement linkedDoc = getDocumentBody();
                    postponedAssertTrue(linkedDoc.getText().isEmpty(), "Ссылка на пустой документ");
                    returnToBack();
                }
            }

            // проверка поэлементного совпадения с верхним колонтитулом
            List<String> fooItems = getFooterItems();
            postponedAssertFalse(fooItems == null || fooItems.isEmpty(), "Нет элементов нижнего колонтитула");

            List<String> topItems = getDocMenuItems();
            postponedAssertFalse(topItems == null || topItems.isEmpty(), "Нет элементов верхнего колонтитула");
            // Первым элементом здесь - "Видео размещено..."
            if (topItems.get(0).startsWith("Видео размещено")) {
                topItems.remove(0);
            }

//            postponedAssertTrue(fooItems.size() == topItems.size(), "Количество элементов в колонтитулах не совпадает");

            for (int i = 0; i < fooItems.size(); i++) {
                String topName = topItems.get(i);
                String fooName = fooItems.get(i);
                postponedAssertTrue(fooName.equalsIgnoreCase(topName), "Колонтитулы-несовпадение: " + fooName + " != " + topName);
            }
        }
    }

    @Step("Возвращает список _названий_ пунктов меню (верхний колонтитул) видеодокумента")
    private ArrayList<String> getDocMenuItems() {

        WebElement document = getDocumentHeader();
        WebElement menuBlock;
        if (!getSettings().isRunFss()) {
            menuBlock = document.findElement(By.cssSelector(".doc-menu"));
        } else {
            menuBlock = document.findElement(By.cssSelector(".doc-list"));
        }

        List<WebElement> menuLinks = menuBlock.findElements(By.tagName("a"));
        ArrayList<String> menuItems = new ArrayList<String>();
        for (WebElement link : menuLinks) {
            menuItems.add(link.findElement(By.tagName("u")).getText());
        }

        return menuItems;
    }

    @Step("Возвращает список _названий_ пунктов нижнего колонтитула видеодокумента")
    private ArrayList<String> getFooterItems() {

        WebElement foo = getDocumentFooter();
        List<WebElement> wrappers = foo.findElements(By.tagName("div"));
        ArrayList<String> footerItems = new ArrayList<String>();
        for (WebElement wrapper : wrappers) {
            WebElement item = wrapper.findElement(By.tagName("h4"));
            footerItems.add(item.getText());
        }

        return footerItems;
    }

    @Step("Возвращает вебэлемент с персональными настройками видео")
    private WebElement getCustomerVideoSettings() {
        return waitForVisibilityOfElementLocatedBy(By.id("settings-form_video"), "Настройки видео не найдены");
    }

    private void setYoutubeHosts(Boolean enableYoutube) {
        //File hosts = new File("C:\\Save\\hosts.");
        File hosts = new File(System.getenv("windir") + "\\system32\\drivers\\etc\\hosts");
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(hosts));

            if (!hosts.exists()) {
                setPostponedTestFail("Файл hosts не найден");
            } else {
                if (!hosts.canRead()) {
                    setPostponedTestFail("Невозможно прочесть файл hosts");
                }
                String crntLine = "";
                String orgLine = "";
                String[] split;
                ArrayList<String> hostBody = new ArrayList<String>();

                boolean alreadyPatched = false;

                while ((crntLine = in.readLine()) != null) {
                    orgLine = crntLine;
                    if (crntLine.contains("#")) {
                        split = crntLine.split("#");
                        if (split.length > 0) {
                            if (split[0].length() > 0) {
                                crntLine = split[0] = split[0].trim();
                            } else {
                                crntLine = "";
                            }
                        } else {
                            crntLine = "";
                        }
                    }
                    if (crntLine.contains("www.youtube.com") || crntLine.contains("gdata.youtube.com")) {
                        alreadyPatched = true;
                    }
                    hostBody.add(orgLine);
                }

                if ((!alreadyPatched && enableYoutube) || (alreadyPatched && !enableYoutube)) {
                    // очистка файла
                    /* Clears the hosts file for re-population */
                    FileOutputStream erasor = new FileOutputStream(hosts);
                    try {
                        erasor.write((new String()).getBytes());
                        erasor.flush();
                    } finally {
                        erasor.close();
                    }

                    FileWriter wrt = null;
                    try {
                        wrt = new FileWriter(hosts);
                        if (enableYoutube) {
                            hostBody.add("127.0.0.1 www.youtube.com");
                            hostBody.add("127.0.0.1 gdata.youtube.com");
                        }

                        for (String str : hostBody) {
                            crntLine = str;
                            if (crntLine.contains("#")) {
                                split = crntLine.split("#");
                                if (split.length > 0) {
                                    if (split[0].length() > 0) {
                                        crntLine = split[0] = split[0].trim();
                                    } else {
                                        crntLine = "";
                                    }
                                } else {
                                    crntLine = "";
                                }
                            }
                            if (crntLine.contains("www.youtube.com") || crntLine.contains("gdata.youtube.com")) {
                                if (!enableYoutube)
                                    continue;
                            }
                            wrt.write(str + "\r\n");
                        }

                        wrt.flush();
                        wrt.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Step("Запретить доступ к Ютубу через файл hosts")
    public void disableYoutubeHosts() {
        setYoutubeHosts(true);
    }

    @Step("Убрать запрет Ютуба через файл hosts")
    public void enableYoutubeHosts() {
        setYoutubeHosts(false);
    }

    @Step("Убедиться, что видео берётся с Ютуба")
    public void videoYoutubeIsEnabled() {
        // video-player-youtube
        WebElement doc = getDocumentBody();
        WebElement player = findElementByNoThrow(doc, By.id("video-player-youtube"));
        postponedAssertFalse(player == null, "Youtube плеер не найден");
    }

    @Step("Убедиться, что видео берётся НЕ с Ютуба")
    public void videoYoutubeIsDisabled() {
        // video-player-object
        WebElement doc = getDocumentBody();
        WebElement player = findElementByNoThrow(doc, By.id("video-player-object"));
        postponedAssertFalse(player == null, "Системный плеер не найден");
    }

    @Step("Выставить на личной странице источник видео - Ютуб")
    public void enableVideoSourceYoutube() {
        WebElement videoSettings = getCustomerVideoSettings();
        List<WebElement> videoRadios = videoSettings.findElements(By.tagName("fieldset"));
        WebElement youtubeRadio = videoRadios.get(0);
        WebElement youtubeRadioButton = youtubeRadio.findElement(By.name("use-youtube"));
        if (youtubeRadioButton.getAttribute("checked") == null) {
            // Youtube RadioButton not checked
            youtubeRadioButton.click();
            WebElement submitBtn = videoSettings.findElement(By.className("button"));
            submitBtn.click();
        }
    }

    @Step("Выставить на личной странице источник видео - с сервера системы")
    public void disableVideoSourceYoutube() {
        WebElement videoSettings = getCustomerVideoSettings();
        List<WebElement> videoRadios = videoSettings.findElements(By.tagName("fieldset"));
        WebElement systemRadio = videoRadios.get(1);
        WebElement systemRadioButton = systemRadio.findElement(By.name("use-youtube"));
        if (systemRadioButton.getAttribute("checked") == null) {
            systemRadioButton.click();
            WebElement submitBtn = videoSettings.findElement(By.className("button"));
            submitBtn.click();
        }
    }

    @Step("Быстрое оглавление (Видео)")
    public void checkQuickTocScroll() {
        List<WebElement> tocItems = mainContentElement.findElements(By.xpath(".//*[@id='sidebar']/div/ul/li"));
        assertFalse(tocItems.isEmpty(), "Отсутсвуют элементы в быстром оглавлении");
        WebElement firstTocItem = tocItems.get(0);
        postponedAssertTrue(firstTocItem.getAttribute("class").equals("active") || !firstTocItem.findElements(By.cssSelector(".link_state_active")).isEmpty(), "Первый элемент быстрого оглавления не активен");
        scrollToEnd();
        boolean isActive = false;
        for (WebElement soderItem : tocItems) {
            WebElement link = findElementByNoThrow(soderItem, By.tagName("a"));
            if (link.getAttribute("class").contains("active")) {
                postponedAssertTrue(tocItems.indexOf(soderItem) != 0, "Быстрое оглавление не проскролилось");
                isActive = true;
                break;
            }
        }
        if (!isActive) {
            setPostponedTestFailWithoutScreen("Не найден активный элемент в Быстром оглавлении");
        }
    }

    @Step("Галерея (Формы): проверка подсказки 'Нажмите для увеличения изображения'")
    public void checkTitleOfFormImage() {
        WebElement doc = getDocumentBody();
        // получаем первый элемент галереи
        WebElement galeryItem = doc.findElement(By.className("lightbox"));
        postponedAssertFalse(galeryItem == null, "Не найдены элементы галереи");
        postponedAssertTrue(galeryItem.getAttribute("title").equals("Нажмите для увеличения изображения"), "Подсказки галереи нет или она не верна");
    }

    @Step("Галерея (Формы)")
    public void checkFormGaleryOpen() {
        WebElement doc = getDocumentBody();
        // получаем элементы галереи
        List<WebElement> galeryItems = doc.findElements(By.className("lightbox"));
        // открываем изображение
        WebElement galeryItem = galeryItems.get(0);
        galeryItem.click();
        waitFewSecond(200);
        WebElement bigImg = waitForVisibilityOfElementLocatedBy(By.id("jquery-overlay")); //doc.findElement(By.id("jquery-overlay"));
        // Задний фон страницы затемнен
        postponedAssertTrue(bigImg.getAttribute("style").contains("background-color: rgb(0, 0, 0)"), "Фон изображения в галерее должен быть чёрным");
        // Отображение соответствует элеметну на странице
        WebElement img = waitForVisibilityOfElementLocatedBy(By.id("lightbox-image"));
        postponedAssertTrue(img.getAttribute("src").equals(galeryItem.getAttribute("href")), "В галерее показано неверное изображение");
        // изображение можно скроллить
        scrollToEnd();
        scrollToStart();

        WebElement container = waitForVisibilityOfElementLocatedBy(By.id("lightbox-container-image-box"));

        // проверка кнопок 'вперёд' 'назад'
        WebElement btnNext = waitForPresenceOfElementLocatedBy(By.id("lightbox-nav-btnNext"), "Элемент отсутствует: Кнопка назад");


        WebElement btnPrev = waitForPresenceOfElementLocatedBy(By.id("lightbox-nav-btnPrev"), "Элемент отсутствует: Кнопка вперед");

        // первый элемент: кнопки назад не должно быть
        moveMouseToElement(btnPrev);
        String stylePrev = btnPrev.getAttribute("style");
        postponedAssertTrue(stylePrev.contains("lightbox-blank.gif"), "Кнопки 'Назад' не должно быть");

        moveMouseToElement(btnNext);
        String styleNext = btnNext.getAttribute("style");
        if (galeryItems.size() > 1)
            postponedAssertTrue(styleNext.contains("lightbox-btn-next-1.gif"), "Кнопка 'Вперёд' отсутствует");

        for (int i = 0; i < galeryItems.size() - 1; i++) {
            // далее...
            btnNext.click();
            waitFewSecond(2000);
        }

        moveMouseToElement(btnPrev);
        stylePrev = btnPrev.getAttribute("style");
        if (galeryItems.size() > 1)
            postponedAssertTrue(stylePrev.contains("lightbox-btn-prev-1.gif"), "Кнопка 'Назад' отсутствует");

        moveMouseToElement(btnNext);
        styleNext = btnNext.getAttribute("style");
        postponedAssertTrue(styleNext.contains("lightbox-blank.gif"), "Кнопки 'Вперёд' не должно быть");

        // закрыть галерею
        WebElement btnClose = container.findElement(By.id("lightbox-secNav-btnClose"));
        btnClose.click();
    }

    @Step("Проверка общего отображения документа 118 модуля")
    public void checkCommonView118(String name) {
        WebElement doc = getDocumentBody();
        //  1. Отображается заголовок документа
        WebElement title = doc.findElement(By.className("main__title"));
        postponedAssertTrue((title != null) && (!title.getText().isEmpty()), "Отсутствует заголовок документа");

        // 2. Отображается блок "Когда понадобится:" (Может не быть, индивидуально для каждого документа)
        WebElement needTitle = findElementByNoThrow(By.className("forms-snippet"));
        if (needTitle != null)
            postponedAssertFalse(needTitle.getText().isEmpty(), "Блок 'Когда понадобится:' пустой");

        // 3. Отображается текст документа
        postponedAssertFalse(doc.getText().isEmpty(), "Отсутствует текст документа");

        // 4. Отображаются комментарии к документу (сноски сбоку)(Может не быть, индивидуально для каждого документа)
        WebElement commentPresent = findElementByNoThrow(By.className("forms-comments-text"));
        if (commentPresent != null) {
            List<WebElement> comments = doc.findElements(By.className("forms-comments-text"));
            if (comments != null && comments.size() > 0) {
                for (WebElement comment : comments) {
                    postponedAssertFalse(comment.getText().isEmpty(), "Пустой комментарий к документу");
                }
            }
        }

        // 5. Отображается меню "Доп. материалы" (Другие редакции, см. также, приложения и пр.)
        WebElement docHeader = getDocumentHeader();
        postponedAssertTrue(docHeader.findElement(By.className("doc-menu")).isDisplayed(), "Меню доп. материалов не отображается");

        // 7. Отображается кнопка "Печать"
        checkPrintButtonIsPresent();

        // 8. Отображается кнопка "Скачать бланк"
        checkDownloadButtonIsPresent();

        // 9. Отображается ссылка "заполненный образец"
        WebElement exampleLink = doc.findElement(By.className("forms-download")).findElement(By.tagName("a"));
        postponedAssertTrue(exampleLink.isDisplayed(), "Ссылка 'заполненный образец' не отображается");

        // 10. Отображается ссылка "памятку к документу" (Может не быть, индивидуально для каждого документа)
        WebElement rememberLink = findElementByNoThrow(By.xpath("//div[@class='no-print forms-download']/a[@class='']"));
        if (rememberLink != null && rememberLink.isDisplayed()) {
            postponedAssertFalse(rememberLink.getText().isEmpty(), "Ссылка 'памятку к документу' без текста");
        }

        // 11. Отображается кнопка рубрикатора "Все формы"
        checkRubricatorButtonIsPresent(name);

        // 12. Отображается кнопка избранного "Мое избранное" (для авторизованных)
        checkMyFavoritesRubricatorButtonIsPresent();

        // 13. Отображаются "звездочки" избранного около заголовка документа (для авторизованных)
        WebElement star = findElementBy(title, By.xpath(".//a[@data-role='phrase-anchor']"));
        moveMouseToElement(title);
        waitForPresenceOf(star);
        postponedAssertTrue(star.isDisplayed(), "Не отображается звезда рядом с заголовком");
    }

    @Step("Проверка общего отображения документа 140 модуля")
    public void checkCommonView140() {
        WebElement doc = getDocumentBody();
        //  1. Отображается заголовок документа
        WebElement title = doc.findElement(By.className("main__title"));
        postponedAssertTrue((title != null) && (!title.getText().isEmpty()), "Отсутствует заголовок документа");

        // 2. Отображается блок "Когда понадобится:" (Может не быть, индивидуально для каждого документа)
        WebElement needTitle = findElementByNoThrow(By.className("forms-snippet"));
        if (needTitle != null) {
            postponedAssertFalse(needTitle.getText().isEmpty(), "Блок 'Когда понадобится:' пустой");
        }

        // 3. Отображается текст документа
        postponedAssertFalse(doc.getText().isEmpty(), "Отсутствует текст документа");

        // 4. Отображается меню "Доп. материалы" (Другие редакции, см. также, приложения и пр.)
        WebElement docHeader = getDocumentHeader();
        postponedAssertTrue(docHeader.findElement(By.className("doc-menu")).isDisplayed(), "Меню доп. материалов не отображается");

        // 5. Отображается кнопка "Печать"
        checkPrintButtonIsPresent();

        // 6. Отображается кнопка "Скачать бланк"
        checkDownloadButtonIsPresent();

        // 7. Отображается ссылка "заполненный образец" (Может не быть, индивидуально для каждого документа)
        WebElement downloadBlock = doc.findElement(By.cssSelector(".forms-download"));
        WebElement exampleLink = findElementByNoThrow(downloadBlock, By.tagName("a"));
        if (exampleLink != null) {
            postponedAssertTrue(exampleLink.isDisplayed(), "Ссылка 'заполненный образец' не отображается");
        }

        // 8. Отображается ссылка "памятку к документу" (Может не быть, индивидуально для каждого документа)
        WebElement rememberLink = findElementByNoThrow(By.xpath("//div[@class='no-print forms-download']/a[@class='']"));
        if (rememberLink != null && rememberLink.isDisplayed()) {
            postponedAssertFalse(rememberLink.getText().isEmpty(), "Ссылка 'памятку к документу' без текста");
        }

        // 9. Отображается кнопка рубрикатора "Все формы"
        checkRubricatorButtonIsPresent("Все формы");

        // 10. Отображается кнопка избранного "Мое избранное" (для авторизованных)
        checkMyFavoritesRubricatorButtonIsPresent();

        // 13. Отображаются "звездочки" избранного около заголовка документа (для авторизованных)
        WebElement star = findElementBy(title, By.xpath(".//a[@data-role='phrase-anchor']"));
        moveMouseToElement(title);
        waitForPresenceOf(star);
        postponedAssertTrue(star.isDisplayed(), "Не отображается звезда рядом с заголовком");
    }

    @Step("Проверка отображения блока 'Когда понадобится'")
    public void checkAsNeedBlock() {
        WebElement doc = getDocumentBody();
        // 1. Блок "Когда понадобится:" отображается
        WebElement needTitle = doc.findElement(By.cssSelector(".forms-snippet"));
        postponedAssertFalse(needTitle.getText().isEmpty(), "Блок 'Когда понадобится' пустой");
        postponedAssertTrue(needTitle.isDisplayed(), "Блок 'Когда понадобится' не отображается");

        // 2. Отображение соответствует скриншоту (например - выделение жирным)
        postponedAssertTrue(needTitle.getAttribute("innerHTML").contains("<b>Когда понадобится:"), "Фраза 'Когда понадобится:' не выделена жирным");
    }

    @Step("Проверка отображения комментариев на форме")
    public void checkFormComments() {
        WebElement doc = getDocumentBody();
        // 1. Комментарии отображаются
        List<WebElement> comments = doc.findElements(By.cssSelector(".forms-comments-text"));
        postponedAssertTrue(comments.size() > 0, "Комментарии отсутствуют");
        for (WebElement comment : comments) {
            // проверяем найденные комментарии
            postponedAssertTrue(comment.isDisplayed(), "Комментарий не отображается");
            // 1a. Комментарии открываются/закрываются
            WebElement commentText = findElementByNoThrow(comment, By.cssSelector(".expand"));
            if (commentText != null) {
                // 1b. Доп. текст к комментариям появляется/исчезает
                // ...и его можно раскрыть
                WebElement extraText = comment.findElement(By.tagName("span"));
                // сейчас он д.б. скрыт
                postponedAssertFalse(extraText.isDisplayed(), "Дополнительный текст комментария уже раскрыт");
                // открываем
                commentText.click();
                waitFewSecond(200);
                postponedAssertTrue(extraText.isDisplayed(), "Дополнительный текст комментария не раскрылся");
                // возвращаем в прежний вид
                commentText.click();
            }
        }

        // 2. Отображаются указатели для каждого комментария (указывают на часть документа, к которой относится комментарий)
        List<WebElement> lines = doc.findElements(By.cssSelector(".forms-svg"));
        postponedAssertTrue(lines.size() > 0, "Не отрисованы указатели комментариев");
    }

    @Step("Проверка отображения комментариев на форме FSS")
    public void checkFormCommentsFss() {
        WebElement doc = getDocumentBody();
        WebElement commentArea = doc.findElement(By.cssSelector(".fixed"));
        List<WebElement> elements = doc.findElements(By.cssSelector(".sfwc"));

        WebElement element = elements.get(0);
        String elementId = element.getAttribute("id");
        element.click();
        postponedAssertTrue(doc.findElement(By.id(elementId + "-c")).isDisplayed(), "Комментарий к элементу не отображается");

        if (elements.size() > 1) {
            // попытка переключения комметариев с другим элементом
            WebElement otherElement = elements.get(1);
            String otherElementId = otherElement.getAttribute("id");
            otherElement.click();
            postponedAssertTrue(doc.findElement(By.id(otherElementId + "-c")).isDisplayed(), "Комментарий к элементу не отображается");
            postponedAssertFalse(doc.findElement(By.id(elementId + "-c")).isDisplayed(), "Комментарий к предыдущему элементу не скрылся");
            // вернуть предыдущий комментарий
            element.click();
        }

        // убрать комментарий первого элемента
        commentArea.click();
        postponedAssertFalse(doc.findElement(By.id(elementId + "-c")).isDisplayed(), "Комментарий к первому элементу не скрылся");
    }

    @Step("Общее отображение документов (174 модуль)")
    public void checkCommonView174() {
        WebElement doc = getDocumentBody();
        //  1. Отображается заголовок документа
        WebElement docTitle = doc.findElement(By.className("main__title"));
        postponedAssertTrue((docTitle != null) && (!docTitle.getText().isEmpty()), "Отсутствует заголовок документа");

        // 2. Отображается автор документа author
        WebElement author = doc.findElement(By.className("author"));
        postponedAssertTrue((author != null) && (!author.getText().isEmpty()), "Отсутствует автор документа");

        // 3. Отображается блок "Чем полезен этот документ"
        // 4. Отображается блок "Преимущества и недостатки"
        WebElement preamble = doc.findElement(By.className("preamble"));
        List<WebElement> preambleColumns = preamble.findElements(By.className("preamble__column"));
        boolean titlePresent = false;
        boolean advantagePresent = false;
        for (WebElement col : preambleColumns) {
            WebElement title = col.findElement(By.tagName("h4"));
            String titleText = title.getText();
            if (titleText.equals("Чем полезен этот документ")) {
                titlePresent = true;
            } else if (titleText.equals("Преимущества и недостатки")) {
                advantagePresent = true;
            }
        }
        postponedAssertTrue(titlePresent, "Нет блока 'Чем полезен этот документ'");
        postponedAssertTrue(advantagePresent, "Нет блока 'Преимущества и недостатки'");

        // 5. Отображается текст документа
        WebElement docText = doc.findElement(By.className("table-wide"));
        postponedAssertTrue(!docText.getText().isEmpty(), "Нет текста документа");

        // 7. Отображается ссылка См. также (Может не быть, индивидуально для каждого документа)
        WebElement docHead = getDocumentHeader();
        WebElement link = findElementByNoThrow(docHead, By.cssSelector("[data-rel='infobar-links']"));
        postponedAssertTrue(link != null && link.getText().equals("См. также"), "Нет ссылки 'См. также'");

        // 8. Отображается кнопка "Печать"
        checkPrintButtonIsPresent();

        // 9. Отображается кнопка "Скачать образец"
        WebElement downloadButton = findElementByNoThrow(doc, By.cssSelector(".js-export"));
        if (downloadButton != null) {
            postponedAssertTrue(downloadButton.isDisplayed(), "Кнопка Скачать образец не отображаеся");
        }

        // 10. Отображается кнопка рубрикатора "Все документы"
        checkRubricatorButtonIsPresent("Все документы");

        // 11. Отображается кнопка избранного "Мое избранное" (для авторизованных)
        checkMyFavoritesRubricatorButtonIsPresent();

        // 12. Отображаются "звездочки" избранного около _заголовка_ документа
        WebElement star = findElementBy(docTitle, By.xpath(".//a[@data-role='phrase-anchor']"));
        moveMouseToElement(docTitle);
        waitForPresenceOf(star);
        postponedAssertTrue(star.isDisplayed(), "Не отображается звезда рядом с _заголовком_");

    }

    @Report("Общее отображение документов (191 модуль)")
    public void checkCommonView191() {
        WebElement doc = getDocumentBody();
        //  1. Отображается заголовок документа
        WebElement docTitle = doc.findElement(By.className("main__title"));
        postponedAssertTrue((docTitle != null) && (!docTitle.getText().isEmpty()), "Отсутствует заголовок документа");

        // 2. Отображается автор документа author
        WebElement author = doc.findElement(By.className("author"));
        postponedAssertTrue((author != null) && (!author.getText().isEmpty()), "Отсутствует автор документа");

        // 3. Отображается блок "Чем полезен этот документ"
        // 4. Отображается блок "Преимущества и недостатки"
        WebElement preamble = doc.findElement(By.className("preamble"));
        List<WebElement> preambleColumns = preamble.findElements(By.className("preamble__column"));
        boolean titlePresent = false;
        boolean advantagePresent = false;
        for (WebElement col : preambleColumns) {
            WebElement title = col.findElement(By.tagName("h4"));
            String titleText = title.getText();
            if (titleText.equals("Чем полезен этот документ")) {
                titlePresent = true;
            } else if (titleText.equals("Преимущества и недостатки")) {
                advantagePresent = true;
            }
        }
        postponedAssertTrue(titlePresent, "Нет блока 'Чем полезен этот документ'");
        postponedAssertTrue(advantagePresent, "Нет блока 'Преимущества и недостатки'");

        // 5. Отображается текст документа
        WebElement docText = doc.findElement(By.className("table-wide"));
        postponedAssertTrue(!docText.getText().isEmpty(), "Нет текста документа");

        // 7. Отображается ссылка См. также (Может не быть, индивидуально для каждого документа)
        WebElement docHead = getDocumentHeader();
        WebElement link = findElementByNoThrow(docHead, By.cssSelector("[data-rel='infobar-links']"));
        postponedAssertTrue(link != null && link.getText().equals("См. также"), "Нет ссылки 'См. также'");

        // 8. Отображается кнопка "Печать"
        checkPrintButtonIsPresent();

        // 9. Отображается кнопка "Скачать образец"
        WebElement downloadButton = findElementByNoThrow(doc, By.cssSelector(".js-export"));
        if (downloadButton != null) {
            postponedAssertTrue(downloadButton.isDisplayed(), "Кнопка Скачать образец не отображаеся");
        }

        // 10. Отображается кнопка рубрикатора "Все документы"
        checkRubricatorButtonIsPresent("Все документы");

        // 11. Отображается кнопка избранного "Мое избранное" (для авторизованных)
        checkMyFavoritesRubricatorButtonIsPresent();

        // 12. Отображаются "звездочки" избранного около _заголовка_ документа
        WebElement star = findElementBy(docTitle, By.xpath(".//a[@data-role='phrase-anchor']"));
        moveMouseToElement(docTitle);
        waitForPresenceOf(star);
        postponedAssertTrue(star.isDisplayed(), "Не отображается звезда рядом с _заголовком_");

    }

    @Report("Общее отображение раздела (Формы)")
    public void checkCommonViewForms() {
        // 1. Отображается "Новостная лента"
        WebElement doc = waitForVisibilityOfElementLocatedBy(By.id("main-container"), "Контейнер не найден");

        List<WebElement> blocks;
        if (getSettings().isRunBss() || getSettings().isRunFss()) {
            blocks = doc.findElements(By.className("block-changes"));
        } else {
            blocks = doc.findElements(By.className("block-half"));
        }
        postponedAssertFalse(blocks.isEmpty(), "Новостная лента пуста");

        // 2. Отображается блок "Популярное"
        WebElement sidebar = doc.findElement(By.id("sidebar"));
        WebElement header = sidebar.findElement(By.tagName("h3"));
        if (getSettings().isRunFss()) {
            postponedAssertTrue(header.getText().equals("Популярные"), "Не найден блок 'Популярные'");
        } else {
            postponedAssertTrue(header.getText().equals("Популярное"), "Не найден блок 'Популярное'");
        }

        postponedAssertTrue(header.isDisplayed(), "Блок 'Популярное/ые' не отображается");
        // forms
        List<WebElement> forms = sidebar.findElements(By.className("forms"));
        postponedAssertFalse(forms.isEmpty(), "Блок 'Популярное/ые' пустой");

        // 3. Отображается кнопка рубрикатора
        //  БСС/КСС/ЮСС - "Все формы"
        //  ФСС - "Все документы"
        if (getSettings().isRunFss()) {
            checkRubricatorButtonIsPresent("Все документы");
        } else {
            checkRubricatorButtonIsPresent("Все формы");
        }

        // 4. Отображается кнопка избранного "Мое избранное" (для авторизованных)
        checkMyFavoritesRubricatorButtonIsPresent();

        // 5. Отображается кнопка онлайн консультанта "Помощник" (Только БСС/КСС/ЮСС)
        if (!getSettings().isRunFss()) {
            checkHelperButtonIsPresent();
        }
    }

    @Step("Проверяется что ссылка на родительский документ отображается")
    public void checkParentDocumentLinkIsPresent() {
        WebElement parentDocElement = findElementByNoThrow(getDocumentBody(), By.cssSelector(".from-link"));
        postponedAssertNotNull(parentDocElement, "Ссылка на родительский документ не найдена");
        if (parentDocElement != null) {
            postponedAssertTrue(parentDocElement.isDisplayed(), "Ссылка на родительский документ не отображается");
        }
    }

    @Step("Проверяется формат ссылки на родительский документ")
    public void checkParentDocumentLinkFormat(String expectedDocType) {
        WebElement parentDocElement = findElementByNoThrow(getDocumentBody(), By.cssSelector(".from-link"));
        postponedAssertNotNull(parentDocElement, "Ссылка на родительский документ не найдена");
        if (parentDocElement != null) {
            String actualParentDocType = parentDocElement.getText().split("«")[0].trim();
            postponedAssertEquals(actualParentDocType, expectedDocType, "Неправильный формат ссылки на родительский документ");
        }
    }

    @Step("Проверяется что ссылка на родительский документ выделена курсивом")
    public void checkParentDocumentLinkIsItalicStyle() {
        WebElement parentDocElement = findElementByNoThrow(getDocumentBody(), By.cssSelector(".from-link"));
        postponedAssertNotNull(parentDocElement, "Ссылка на родительский документ не найдена");
        if (parentDocElement != null) {
            String fontStyle = parentDocElement.getCssValue("font-style");
            postponedAssertEquals(fontStyle, "italic", "Ссылка на родительский документ не выделена курсивом");
        }
    }

    @Step("Проверяется что ссылка на родительский документ находится внизу тела документа")
    public void checkParentDocumentLinkInBottom() {
        WebElement parentDocElement = findElementByNoThrow(getDocumentBody(), By.cssSelector(".from-link"));
        postponedAssertNotNull(parentDocElement, "Ссылка на родительский документ не найдена");
        if (parentDocElement != null) {
            List<WebElement> docElements = getDocumentBody().findElements(By.tagName("*"));
            int previousElementLocation = docElements.get(docElements.size() - 3).getLocation().getY();
            int parentDocLinkLocation = parentDocElement.getLocation().getY();
            postponedAssertTrue(parentDocLinkLocation > previousElementLocation, "Ссылка на родительский документ находится не внизу тела документа");
        }
    }

    @Step("Открыть ссылку на родительский документ")
    public void clickParentDocumentLink() {
        WebElement parentDocElement = findElementByNoThrow(getDocumentBody(), By.cssSelector(".from-link"));
        postponedAssertNotNull(parentDocElement, "Ссылка на родительский документ не найдена");
        if (parentDocElement != null) {
            WebElement parentDocLink = parentDocElement.findElement(By.tagName("a"));
            String parentDocTitle = parentDocLink.getText();
            setParameter(PARENT_DOCUMENT_TITLE, parentDocTitle);
            parentDocLink.click();
            waitForReloadingPage();
        }
    }

    @Step("Проверяется что заголовок родительского документа")
    public void checkParentDocumentTitle() {
        String expectedDocTitle = String.valueOf(getParameter(PARENT_DOCUMENT_TITLE));
        WebElement docTitleElement = findElementByNoThrow(getDocumentBody(), By.cssSelector(".main__title"));
        postponedAssertNotNull(docTitleElement, "Заголовок родительского документа не найден");
        if (docTitleElement != null) {
            String actualDocTitle = docTitleElement.getText().replace("В избранное", "").trim();
            postponedAssertEquals(actualDocTitle, expectedDocTitle, "Неправильный заголовок родительского документа");
        }
    }

    @Step("Проверяется что документ отображается")
    public void checkDocumentIsOpened() {
        WebElement documentBody = findElementByNoThrow(mainContentElement, By.id("document-body"));
        String documentUrl = String.valueOf(getParameter(SearchResultHelper.DOCUMENT_URL));
        if (documentUrl != null && documentUrl.isEmpty()) {
            postponedAssertTrue(getCurrentUrl().contains(documentUrl), String.format("В URL:%s нет совпадения URL документа:%s", getCurrentUrl(), documentUrl));
        }
        assertNotNull(documentBody, "Документ не открыт");
        postponedAssertTrue(documentBody.isDisplayed(), "Документ не отображается");
    }

    @Step("Над главной шапкой присутствует плашка.")
    public void checkWarningPanelIsLocatedAboveThanHeader() {
        WebElement warningPanel = findElementBy(By.id("warning-panel"));
        WebElement header = findElementBy(By.xpath("//*[@id='warning-panel']/following::*[1]"));
        postponedAssertTrue(warningPanel.isDisplayed(), "Информативная плашка не отображается");
        postponedAssertEquals(header.getAttribute("id"), "header", "Элемент внизу плашки не Header");
        int headerLocation = header.getLocation().getY();
        int warningPanelLocation = warningPanel.getLocation().getY();
        postponedAssertTrue(warningPanelLocation < headerLocation, "Плашка выше чем главная шапка");
    }

    @Step("Ширина плашки равна ширине экрана")
    public void checkWarningPanelWidthIsEqualsBrowserWidth() {
        WebElement warningPanel = findElementBy(By.id("warning-panel"));
        postponedAssertEquals(warningPanel.getSize().getWidth(), getBrowserWidthWithoutScroll(), "Ширина информационной плашки не равна ширине браузера");
    }

    private int getBrowserWidthWithoutScroll() {
        String script = "return $('body').innerWidth();";
        long content = (Long) executeScript(script);
        return (int) content;
    }

    @Step("Внешний вид соответствует скрин 1")
    public void checkWarningPanelIsRed() {
        WebElement warningPanel = findElementBy(By.id("warning-panel"));
        postponedAssertEquals(warningPanel.getCssValue("background-color"), "rgba(176, 33, 48, 1)", "Цвет плашки не " +
                "rgba(176, 33, 48, 1)");
    }

    /**
     * for kss. bss and kss have different background colours: bss:rgba(176, 33, 48, 1), kss:rgba(202, 0, 23, 1)
     */
    @Step("Внешний вид соответствует скрин 1")
    public void checkWarningPanelIsVinous() {
        WebElement warningPanel = findElementBy(By.id("warning-panel"));
        postponedAssertEquals(warningPanel.getCssValue("background-color"), "rgba(202, 0, 23, 1)", "Цвет плашки не " +
                "rgba(202, 0, 23, 1)");
    }

    @Step("Внешний вид соответствует скрин 3")
    public void checkWarningPanelIsYellow() {
        WebElement warningPanel = findElementBy(By.id("warning-panel"));
        postponedAssertEquals(warningPanel.getCssValue("background-color"), "rgba(255, 192, 48, 1)", "Цвет плашки не " +
                "rgba(255, 192, 48, 1)");
    }

    @Step("Текст соответствует скрину 1")
    public void checkWarningPanelHasText(String text) {
        WebElement warningPanel = findElementBy(By.id("warning-panel"));
        postponedAssertEquals(warningPanel.getText(), text, "Плашка содержит текст, отличающийся от эталонного");
    }

    @Step("Присутствует ссылка на информационной панели")
    public void checkWarningPanelHasLink(String textLink) {
        WebElement link = findElementByNoThrow(By.xpath("//*[@id='warning-panel']//a[@class='link']"));
        postponedAssertTrue(link != null && link.isDisplayed(), "Ссылка \"демодоступ на три дня\" в плашке не отображена");
        if (link != null) {
            postponedAssertEquals(link.getText(), textLink, "В ссылке \"" + textLink + "\" на плашке отстутствует текст \"" + textLink + "\"");
        }
    }

    @Step("Происходит переход на /#/customer/demo в той же системе, где был открыт документ")
    public void checkWarningPanelDemoLinkIsOpened() {
        WebElement linkDemo = findElementByNoThrow(By.xpath("//*[@id='warning-panel']//a[@class='link']"));
        assertTrue(linkDemo != null && linkDemo.isDisplayed(), "Ссылка в плашке не отображена");
        if (linkDemo != null) {
            linkDemo.click();
            postponedAssertTrue(getDriver().getCurrentUrl().contains(getSettings().getHost() + "/#/customer/demo"), "Переход по ссылке демодоступ на три дня произошел не в той же системе, где был открыт документ");
        }
    }

    @Step("Выводится только заголовок документа")
    public void checkDocumentHasTitleWithoutBody() {
        WebElement header = waitForPresenceOfElementLocatedBy(By.id("pagewf-header"), "Форма авторизации не отобразилась");
        WebElement title = header.findElement(By.tagName("h1"));
        postponedAssertTrue(title.isDisplayed(), "Заголовок документа не отображен");
        WebElement documentBody = findElementByNoThrow(By.id("document-body"));
        if (documentBody != null) {
            postponedAssertFalse(documentBody.isDisplayed(), "Документ отображен на странице недоступный для другого" +
                    " издания ");
        }
    }

    @Step("Форма авторизации открыта на вкладке \"демодоступ\"")
    public void checkTryTrialFormIsPresent() {
        WebElement tabs = findElementBy(By.cssSelector(".whiteboard-control"));
        postponedAssertTrue(tabs.isDisplayed(), "Вкладка \"демодоступ\" не отображена на странице");
        WebElement tryTrialTab = tabs.findElement(By.cssSelector(".tab-1"));
        postponedAssertTrue(tryTrialTab.getAttribute("class").contains("pressed"), "Форма авторизации не открыта" +
                "на владке \"демодоступ\"");
    }

    @Step("Форма авторизации открыта на вкладке Активация подписки")
    public void checkSubscribeActivateFormIsPresent() {
        WebElement tabs = findElementBy(By.cssSelector(".whiteboard-control"));
        postponedAssertTrue(tabs.isDisplayed(), "Вкладка \"Активация подписки\" не отображена на странице");
        WebElement tryTrialTab = tabs.findElement(By.cssSelector(".tab-2"));
        postponedAssertTrue(tryTrialTab.getAttribute("class").contains("pressed"), "Форма авторизации не открыта" +
                "на владке \"Активация подписки\"");
    }

    @Step("Присутствует специальный текст на вкладке \"демодоступ\"")
    public void checkTryTrialFormHasText(String text) {
        WebElement textOtherSystem = findElementBy(By.cssSelector("#get-demo-with-mobilephone-notice .other-system"));
        postponedAssertTrue(textOtherSystem.isDisplayed(), "Специальный текст не присутствует на вкладке \"демодоступ\"");
        postponedAssertEquals(textOtherSystem.getText(), text, "Специальный текст не соответсует эталонному тексту");
    }

    @Step("Проверить, что на вкладке демодоступ отображаются все элементы")
    public void checkTryTrialForm() {
        postponedAssertTrue(findElementBy(By.cssSelector("#get-demo-with-mobilephone #mobilePhoneCode")).isDisplayed(), "Код моб.телефона не отображен");
        postponedAssertTrue(findElementBy(By.cssSelector("#get-demo-with-mobilephone #mobilePhonePrefix")).isDisplayed(), "Префикс моб.телефона не отображен");
        postponedAssertTrue(findElementBy(By.cssSelector("#get-demo-with-mobilephone #mobilePhoneNumber")).isDisplayed(), "Номер моб.телефона не отображен");
        postponedAssertTrue(findElementBy(By.id("button-sms")).isDisplayed(), "Кнопка Подтвердить не отображена");
        postponedAssertTrue(findElementBy(By.id("activationCode")).isDisplayed(), "Поле Код из смс не отображено");
        postponedAssertTrue(findElementBy(By.id("button-demo")).isDisplayed(), "Кнопка Получить демодоступ не отображена");
    }

    @Step("Присутствует ссылка на БСС УСН")
    public void checkTryTrialFormBSSLinkIsPresent() {
        WebElement link = findElementBy(By.cssSelector("#get-demo-with-mobilephone .other-system a"));
        postponedAssertTrue(link.isDisplayed(), "Ссылка БСС Система Главбух для упрощенки не отображена");
    }

    @Step("Присутствует специальный текст на вкладке \"Активация подписки\"")
    public void checkSubscribeActivationFormHasText(String text) {
        WebElement textOtherSystem = findElementBy(By.cssSelector("#page-noaccess .other-system"));
        postponedAssertTrue(textOtherSystem.isDisplayed(), "Специальный текст не присутствует на вкладке \"Активация подписки\"");
        postponedAssertEquals(textOtherSystem.getText(), text, "Специальный текст не соответсует эталонному тексту");
    }

    @Step("Проверить, что на вкладке Активация подписки все элементы ")
    public void checkSubscribeActivationFormCellPhoneNumberIsPresent() {
        postponedAssertTrue(findElementBy(By.cssSelector("#page-noaccess #mobilePhoneCode")).isDisplayed(), "Код моб.телефона не отображен");
        postponedAssertTrue(findElementBy(By.cssSelector("#page-noaccess #mobilePhonePrefix")).isDisplayed(), "Префикс моб.телефона не отображен");
        postponedAssertTrue(findElementBy(By.cssSelector("#page-noaccess #mobilePhoneNumber")).isDisplayed(), "Номер моб.телефона не отображен");
        postponedAssertTrue(findElementBy(By.id("fields-activate")).isDisplayed(), "Код доступа не отображена");
        postponedAssertTrue(findElementBy(By.id("button-activate")).isDisplayed(), "Кнопка Активировать не отображена");
    }

    @Step("Присутствует ссылка на БСС УСН")
    public void checkSubscribeActivationFormBSSLinkIsPresent() {
        WebElement link = findElementBy(By.cssSelector("#page-noaccess a"));
        postponedAssertTrue(link.isDisplayed(), "Ссылка БСС Система Главбух для упрощенки не отображена");
    }

    @Step("Стрелками в поиске осуществить переход по результатам поиска в тексте")
    public void checkArrowsInSearchInText(String query) {
        if (query.matches("^\\s*$")) {
            throw new IllegalArgumentException("Данный метод не работает с словосочетаниями и предложениями в запросе:" + query);
        }

        waitFewSecond(getTimeout() * 500);
        WebElement searchBox = waitForVisibilityOfElementLocatedBy(By.id("search-form"), "Поисковая строка не найдена");
        WebElement searchInTextWidget = searchBox.findElement(By.cssSelector(".search-in"));
        waitForTextToBePresentIn(searchInTextWidget, "найдено");

        WebElement textInWidgetElement = searchInTextWidget.findElement(By.cssSelector(".msg"));
        String textInWidget = searchInTextWidget.findElement(By.cssSelector(".msg")).getText().trim();
        if (textInWidgetElement.getAttribute("class").contains("active")) {
            String numberSearchIn = textInWidget.replace("В тексте найдено ~", "");
            int numberSearch = Integer.parseInt(numberSearchIn);
            if (numberSearch > 5) { //check only five first results
                numberSearch = 5;
            }

            WebElement nextBtn = searchInTextWidget.findElement(By.cssSelector(".next"));
            WebElement prevBtn = searchInTextWidget.findElement(By.cssSelector(".prev"));
            int startPosition = waitForVisibilityOfElementLocatedBy(By.id("header"), "Заголовок не найден").getLocation().getY();

            waitFewSecond(5000);

            List<WebElement> matchesWords = findElementsBy(By.cssSelector(".matches"));

            //clicks on button next
            for (int i = 0; i < numberSearch; i++) {
                clickUseJS(nextBtn);

                waitForAttributeUpdate(textInWidgetElement, "class", "part-preloader", true);

                int wordPosition = waitForPresenceOfElementLocatedBy(By.xpath("(//*[@class='matches'])[" + (i + 1) + "]")).getLocation().getY();
                int endPosition = waitForVisibilityOfElementLocatedBy(By.id("header"), "Заголовок не найден").getLocation().getY();

                postponedAssertTrue(endPosition != startPosition && wordPosition - endPosition < DOCUMENT_LOCATION ||
                        endPosition == startPosition && wordPosition - endPosition < DOCUMENT_LOCATION, "Документ не проскроллился к результатам поиска");

                postponedAssertTrue(query.equalsIgnoreCase(matchesWords.get(i).getText()), "После нажатия на кнопку next в поиске по документу. " +
                        "Найденное слово в результатах поиска:" + matchesWords.get(i).getText() + ", а искомое слово:" + query);
            }

            //clicks one time on button prev
            clickUseJS(prevBtn);

            waitForAttributeUpdate(textInWidgetElement, "class", "part-preloader", true);

            int wordPosition = waitForPresenceOfElementLocatedBy(By.xpath("(//*[@class='matches'])[" + (numberSearch - 2) + "]")).getLocation().getY();
            int endPosition = waitForVisibilityOfElementLocatedBy(By.id("header"), "Заголовок не найден").getLocation().getY();

            postponedAssertTrue(endPosition != startPosition && endPosition - wordPosition < DOCUMENT_LOCATION ||
                    endPosition == startPosition && endPosition - wordPosition < DOCUMENT_LOCATION, "Документ не проскроллился к результату поиска");

            scrollToStart();

        } else {
            postponedAssertTrue("В тексте не найдено".equals(textInWidget), "Неправильный текст в виджете Поиск в тексте");
            warning("Результаты поиска отсутсвуют проверка скролла не проводилась");
        }
    }

    @Step("Проверяется что поиск в тексте не дает результата")
    public void checkDocumentSearchWithNoResult() {
        String withNoResult = "В тексте не найдено";
        waitFewSecond(getTimeout());
        WebElement searchBox = waitForVisibilityOfElementLocatedBy(By.id("search-form"), "Поисковая строка не найдена");
        WebElement searchInTextWidget = searchBox.findElement(By.cssSelector(".search-in"));
        waitForTextToBePresentIn(searchInTextWidget, "найдено");
        String textInWidget = searchInTextWidget.findElement(By.cssSelector(".msg")).getText().trim();
        postponedAssertTrue(withNoResult.equals(textInWidget), "В виджете Поиск в тексте неправильный текст. Должен быть:" + withNoResult + ", но найдено:" + textInWidget);
        WebElement matches = findElementByNoThrow(By.cssSelector(".matches"));
        if (matches != null) {
            String backgroundMatches = matches.getCssValue("background-color");
            postponedAssertNotEquals(backgroundMatches, "rgba(255, 240, 176, 1)", "Цвет найденного слова в поиске желтый, а не должен быть подкрашен");
        }
    }

    @Step("Проверяется что поиск в тексте не отображается")
    public void checkDocumentSearchIsNotPresent() {
        WebElement searchBox = findElementByNoThrow(By.cssSelector(".search-in"));
        postponedAssertTrue(searchBox == null || !searchBox.isDisplayed(), "Виджет Поиск в тексте отображен на странице");
    }

    @Step("Проверяется что блок с редакцией документа отображается")
    public void checkVersionsBlockForDictionaryDocumentIsPresent() {
        WebElement documentHeader = getDocumentHeader();
        WebElement expiredWarning = findElementByNoThrow(documentHeader, By.cssSelector("[data-rel='infobar-links']"));
        postponedAssertNotNull(expiredWarning, "Блок с редакцией документа не найден");
        if (expiredWarning != null) {
            postponedAssertTrue(expiredWarning.isDisplayed(), "Блок с редакцией документа не отображается");
        }
    }

    @Step("Проверяется что ссылка 'Другие редакции' в блоке с редакцией документа отображается")
    public void checkOtherVersionsForDictionaryDocumentIsPresent() {
        WebElement documentHeader = getDocumentHeader();
        WebElement expiredWarning = findElementByNoThrow(documentHeader, By.xpath(".//*[text()='Другие редакции']"));
        postponedAssertNotNull(expiredWarning, "Ссылка 'Другие редакции' в блоке с редакцией документа не найдена");
        if (expiredWarning != null) {
            postponedAssertTrue(expiredWarning.isDisplayed(), "Ссылка 'Другие редакции' в блоке с редакцией документа не отображается");
        }
    }

    @Step("Проверяется что ссылка 'Редакция утратила силу...' в блоке с редакцией документа отображается")
    public void checkExpiredVersionsForDictionaryDocumentIsPresent() {
        WebElement documentHeader = getDocumentHeader();
        WebElement expiredWarning = findElementByNoThrow(documentHeader, By.xpath(".//*[contains(text(),'Редакция утратила силу')]"));
        postponedAssertNotNull(expiredWarning, "Ссылка 'Редакция утратила силу...' в блоке с редакцией документа не найдена");
        if (expiredWarning != null) {
            postponedAssertTrue(expiredWarning.isDisplayed(), "Ссылка 'Редакция утратила силу...' в блоке с редакцией документа не отображается");
        }
    }

    @Step("Теги meta name='description' и meta name='keywords' заполнены идентично быстрому оглавлению")
    public void checkMetaTagsAndTableOfContents() {
        waitForPresenceOfElementLocatedBy(By.cssSelector(".list_type_contents"), "Отсутсвует быстрое оглавление");
        WebElement soder = findElementByNoThrow(mainContentElement, By.cssSelector(".list_type_contents"));

        List<WebElement> menuItems = soder.findElements(By.tagName("li"));

        WebElement metaKeyWords = findElementBy(By.name("keywords"));
        WebElement metaDescription = findElementBy(By.name("description"));

        String strMetaKeywords = metaKeyWords.getAttribute("content");
        String strMetaDescription = metaDescription.getAttribute("content");

        for (int i = 0; i < menuItems.size(); i++) {
            String menuItem = menuItems.get(i).getText();
            postponedAssertTrue(strMetaDescription.trim().startsWith(menuItem), "Заголовок в оглавлении:" + menuItem + " не содержится в теге meta name='description'");
            postponedAssertTrue(strMetaKeywords.trim().startsWith(menuItem), "Заголовок в оглавлении:" + menuItem + " не содержится в теге meta name='keywords'");

            strMetaDescription = strMetaDescription.replaceFirst(menuItem, "");
            strMetaKeywords = strMetaKeywords.replaceFirst(menuItem, "");
//            strMetaDescription = strMetaDescription.trim();
//            strMetaKeywords = strMetaKeywords.trim();

            if ((i != (menuItems.size() - 1) && !menuItems.get(i + 1).getText().equals("Бланки")) &&
                    !menuItems.get(i + 1).getText().equals("См. также") && !menuItems.get(i + 1).getText().equals("Справочники")) {
                postponedAssertTrue(strMetaDescription.startsWith(";"), "Заголовок в оглавлении:" + menuItem + " не " +
                        "отделен от остальных заголовоков знаком ; в теге meta name='description'");

                postponedAssertTrue(strMetaKeywords.startsWith(" "), "Заголовок в оглавлении:" + menuItem + " не " +
                        "отделен от остальных заголовоков пробелом в теге meta name='keywords'");

                strMetaDescription = strMetaDescription.replaceFirst("; ", "");
                strMetaKeywords = strMetaKeywords.replaceFirst(" ", "");
            } else {
                break; // The items Бланки and Ответственность do not contain into the table of contents (the end attribute of table of contents)
                //Бланки, Содержание, см.также не содержатся в мета теге
            }
        }
    }

    @Step("Теги <meta name='description'> и <meta name='keywords'> заполнены идентично документам")
    public void checkMetaTagsAndSavedDataContent() {
        String pathToFiles = "/documents/";

        WebElement metaKeyWords = findElementBy(By.name("keywords"));
        WebElement metaDescription = findElementBy(By.name("description"));

        String strMetaKeywords = new String(metaKeyWords.getAttribute("content"));
        String strMetaDescription = metaDescription.getAttribute("content");

        String expectedKeywords = "";
        String expectedDescription = "";

        String prefix = "";
        String system = "";

        if (getSettings().isRunBss()) {
            system = "bss";
            if (getCurrentUrl().contains("vip.") || getCurrentUrl().contains("doc.")) {
                prefix = "_vip";
            } else if (getCurrentUrl().contains("bu.") || getCurrentUrl().contains("budget.")) {
                prefix = "_bu";
            } else if (getCurrentUrl().contains("u.") || getCurrentUrl().contains("usn.")) {
                prefix = "_usn";
            }
        } else if (getSettings().isRunGf()) {
            system = "gf";
        } else if (getSettings().isRunKss()) {
            system = "kss";
        } else if (getSettings().isRunUss()) {
            system = "uss";
        } else if (getSettings().isRunFss()) {
            system = "fss";
        } else if (getSettings().isRunEhs()) {
            system = "ehs";
        } else if (getSettings().isRunEdu()) {
            system = "edu";
            if (getCurrentUrl().contains("vip.") || getCurrentUrl().contains("doc.")) {
                prefix = "_vip";
            }
        } else if (getSettings().isRunGo()) {
            system = "go";
        } else if (getSettings().isRunElpu()) {
            system = "elpu";
        } else if (getSettings().isRunKlpu()) {
            system = "klpu";
        } else if (getSettings().isRunCult()) {
            system = "cult";
        } else if (getSettings().isRunUmd()) {
            system = "umd";
        }

        try {
            InputStream reqStream = DocumentHelper.class.getClass().getResourceAsStream(pathToFiles + String.format("meta_name_keywords_%s%s.txt", system, prefix));
            expectedKeywords = IOUtils.toString(reqStream);
            expectedDescription = IOUtils.toString(DocumentHelper.class.getClass().getResourceAsStream(pathToFiles + String.format("meta_name_description_%s%s.txt", system, prefix)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        postponedAssertEquals(strMetaDescription.replaceAll(" ", " "), expectedDescription, "Контент из тега мета:" + strMetaDescription +
                " не совпадает с эталонным:" + expectedDescription);
        postponedAssertEquals(strMetaKeywords.replaceAll(" ", " "), expectedKeywords, "Контент из тега мета:" + strMetaKeywords +
                " не совпадает с эталонным:" + expectedKeywords);
    }

    @Step("Проверяется что кнопка 'Оглавление' отображается")
    public void checkTableOfContentsButtonIsPresent() {
        WebElement rubricatorButton = waitForPresenceOfElementLocatedBy(TABLE_OF_CONTENTS_BUTTON_LOCATOR, "Кнопка 'Оглавление' Отсутствует");
        postponedAssertEquals(rubricatorButton.getText(), "Оглавление", "Неправильный текст кнопки 'Оглавление'");
    }

    @Step("Проверяется что кнопка рубрикатора нажата")
    public void checkTableOfContentsButtonIsPressed() {
        WebElement rubricatorBtn = waitForVisibilityOfElementLocatedBy(TABLE_OF_CONTENTS_BUTTON_LOCATOR, "Кнопка 'Оглавление' не найдена");
        postponedAssertTrue(rubricatorBtn.getAttribute("class").contains("pressed") || rubricatorBtn.getAttribute("class").contains("btn_state_active"), "Кнопка 'Оглавление' не нажата");
    }

    @Step("Проверяется что кнопка рубрикатора не нажата")
    public void checkTableOfContentsButtonIsUnPressed() {
        WebElement rubricatorBtn = waitForVisibilityOfElementLocatedBy(TABLE_OF_CONTENTS_BUTTON_LOCATOR, "Кнопка 'Оглавление' не найдена");
        postponedAssertFalse(rubricatorBtn.getAttribute("class").contains("pressed") || rubricatorBtn.getAttribute("class").contains("btn_state_active"), "Кнопка 'Оглавление' нажата");
    }

    @Step("Нажать на заголовок документа")
    public void clickDocumentHeader() {
        waitForPresenceOfElementLocatedBy(By.cssSelector("#document-body .main__title"), "Заголовок документа не найден").click();
    }

    @Step("Нажать кнопку 'О книге'")
    public void clickAboutBookButton() {
        waitForPresenceOfElementLocatedBy(By.id("book-annotation-toggle"), "кнопка 'О книге' не найдена").click();
    }

    @Step("Проверяется блок 'О книге'")
    public void checkAboutBookBlock() {
        WebElement aboutBookBlock = waitForPresenceOfElementLocatedBy(By.id("doc-info-about"), "Блок 'О книге' не найден");
        WebElement year = findElementByNoThrow(aboutBookBlock, By.cssSelector(".book-annotation-year"));
        WebElement annotation = findElementByNoThrow(aboutBookBlock, By.cssSelector(".book-annotation-description"));
        assertTrue(year != null || annotation != null, "Блок 'О книге' не содержит 'Год издания' и 'Аннотация'");
        if (year != null) {
            postponedAssertTrue(year.isDisplayed(), "Блок 'Год издания' не отобраажется");
            postponedAssertFalse(year.getText().isEmpty(), "Блок 'Год издания' пустой");
        }
        if (annotation != null) {
            postponedAssertTrue(annotation.isDisplayed(), "Блок 'Аннотация' не отобраажется");
            postponedAssertFalse(annotation.getText().isEmpty(), "Блок 'Аннотация' пустой");
        }
    }

    @Step("Изменить размер онка браузера")
    public void setBrowserSize(int width, int height) {
        setSizeWindows(width, height);
    }

    @Step("Проверяется что текст блока 'О книге' не выезжает за его пределы")
    public void checkSizeOfAboutBookBlockIsNotChanged() {
        WebElement documentBody = waitForPresenceOfElementLocatedBy(By.id("document-body"), "Блок 'О книге' не найден");
        WebElement aboutBookBlock = waitForPresenceOfElementLocatedBy(By.id("doc-info-about"), "Блок 'О книге' не найден");
        postponedAssertTrue(documentBody.getSize().getWidth() >= aboutBookBlock.getSize().getWidth(), "Блок 'О книге' выезжает за пределы документа");
        postponedAssertTrue(documentBody.getSize().getHeight() >= aboutBookBlock.getSize().getHeight(), "Блок 'О книге' выезжает за пределы документа");
        postponedAssertTrue((documentBody.getLocation().getX() >= aboutBookBlock.getLocation().getX())
                && ((documentBody.getLocation().getX() + documentBody.getSize().getWidth()) >= (aboutBookBlock.getLocation().getX() + aboutBookBlock.getSize().getWidth())), "Блок 'О книге' выезжает за пределы документа");
        postponedAssertTrue((documentBody.getLocation().getY() >= aboutBookBlock.getLocation().getY())
                && ((documentBody.getLocation().getY() + documentBody.getSize().getHeight()) >= (aboutBookBlock.getLocation().getY() + aboutBookBlock.getSize().getHeight())), "Блок 'О книге' выезжает за пределы документа");
    }

    @Step("Проверяется что документ содержит текст")
    public void checkDocumentContainsText(String expectedText) {
        String actualText = documentBody.getText().toLowerCase();
        postponedAssertTrue(actualText.contains(expectedText.toLowerCase()), "Документ не содержит текст - " + expectedText);
    }

    @Step("Проверяется что кнопка 'Поиск по реквизитам' отобраажется")
    public void checkExtendedSearchButtonIsPresent() {
        WebElement searchBlock = waitForPresenceOfElementLocatedBy(By.cssSelector(".search"));
        WebElement extendedSearchButton = findElementByNoThrow(searchBlock, By.id("search-button-extended"));
        postponedAssertNotNull(extendedSearchButton, "Кнопка 'Поиск по реквизитам' не найдена");
        if (extendedSearchButton != null) {
            postponedAssertTrue(extendedSearchButton.isEnabled() && extendedSearchButton.isDisplayed(), "Кнопка 'Поиск по реквизитам' не отобраажется");
        }
    }

    @Step("Нажать ссылку Другие редакции в колонтитуле документа")
    public void clickDocumentInfobarLink() {
        WebElement infobarLink = findElementBy(By.xpath("//*[@data-rel='infobar-links']"));
        infobarLink.click();
        waitForPresenceOf(findElementBy(By.id("infobar-links")));
    }

    @Step("В меню Доп.материалы отображаются разделы Бланки и См.также, ссылки на документы в каждом разделе")
    public void checkInfobarCardIsPresent() {
        WebElement editions = findElementBy(By.id("editions"));
        postponedAssertTrue(editions.isDisplayed(), "Раздел Редакции документа не отображен");
        WebElement chainRecomendations = findElementBy(By.cssSelector(".doc-info_content_links " +
                ".document-chain-column-recommendations"));
        WebElement chainForms = findElementBy(By.cssSelector(".doc-info_content_links " +
                ".document-chain-column-forms"));
        postponedAssertTrue(chainRecomendations.isDisplayed(), "Блок См.также не отображен в доп.материалах");
        postponedAssertTrue(chainForms.isDisplayed(), "Блок Бланки не отображен в доп.материалах");

        List<WebElement> linksRecommendations = chainRecomendations.findElements(By.xpath("//*[contains(@href,'document')]"));
        List<WebElement> linksForms = chainForms.findElements(By.xpath("//*[contains(@href,'document')]"));
        postponedAssertTrue(linksRecommendations.size() > 0, "Ссылки в блоке См.также не отображены");
        postponedAssertTrue(linksForms.size() > 0, "Ссылки в блоке Бланки не отображены");
    }

    @Step("Нажать несколько ссылок внутри меню См.также и Бланки")
    public void checkInfobarBlocksLinks() {
        checkBlockLinks(getInfobarRecomendationLinks());
        checkBlockLinks(getInfobarFormsLinks());
    }

    private List<WebElement> getInfobarRecomendationLinks() {
        WebElement chainRecomendations = findElementBy(By.cssSelector(".doc-info_content_links " +
                ".document-chain-column-recommendations"));
        List<WebElement> linksRecommendations = chainRecomendations.findElements(By.xpath("./li/a"));
        return linksRecommendations;
    }

    private List<WebElement> getInfobarFormsLinks() {
        WebElement chainForms = findElementBy(By.cssSelector(".doc-info_content_links " +
                ".document-chain-column-forms"));
        List<WebElement> linksForms = chainForms.findElements(By.xpath("./li/a"));
        return linksForms;
    }

    private void checkBlockLinks(List<WebElement> blockLinks) {
        List<Link> links = new ArrayList<Link>();
        for (WebElement elementLink : blockLinks) {
            String href = elementLink.getAttribute("href");
            String header = elementLink.getText();
            links.add(new Link(href, header));
        }
        checkLinks(links);
    }

    @Step("Проверить что блоки Бланки, См.также отображаются в конце документа и список документов соответствует меню доп.материалы")
    public void checkDocumentInfobarBottom() {
        WebElement footer = findElementBy(By.id("infobar-bottom"));
        postponedAssertTrue(footer.isDisplayed(), "Допматериалы не отображаются в колонтитуле документа");

        WebElement chainForms = footer.findElement(By.cssSelector(".document-chain-column-forms"));
        List<WebElement> linksForms = chainForms.findElements(By.xpath("./li/a"));

        WebElement chainRecomendations = findElementBy(By.cssSelector(".doc-info_content_links " +
                ".document-chain-column-recommendations"));
        List<WebElement> linksRecommendations = chainRecomendations.findElements(By.xpath("./li/a"));

        postponedAssertEquals(getTextListFromWebElementList(linksForms), getTextListFromWebElementList(
                getInfobarFormsLinks()), "Бланки:Ссылки в колонтитуле документа не совпадают с ссылками в футере документа");
        postponedAssertEquals(getTextListFromWebElementList(linksRecommendations), getTextListFromWebElementList(
                getInfobarRecomendationLinks()), "См.также:Ссылки в колонтитуле документа не совпадают с ссылками в футере документа");
    }

    private List<String> getTextListFromWebElementList(List<WebElement> elements) {
        List<String> stringList = new ArrayList<String>();
        for (WebElement element : elements) {
            stringList.add(element.getText());
        }
        return stringList;
    }

    @Step("Внутри инфобара отображается надпись Редакция от")
    public void checkTextDocumentEditionFrom() {
        String expectedText = "Редакция от";
        WebElement editions = findElementByNoThrow(By.id("editions"));
        postponedAssertTrue(editions != null && editions.isDisplayed(), "Блок Редакция от не отображен в документе");
        String textEditionFrom = editions.findElement(By.tagName("h3")).getText();
        postponedAssertTrue(textEditionFrom.contains(expectedText), "В тексте:" + textEditionFrom + " не содержится " +
                "текст:" + expectedText);
    }

    @Step("В инфобаре документа отображена надпись Редакция от")
    public void checkTextDocumentEditionFromInDocHeader() {
        String expectedText = "Редакция от";
        WebElement editions = findElementByNoThrow(By.cssSelector("[data-rel='infobar-links']"));
        postponedAssertTrue(editions != null && editions.isDisplayed(), "Блок Редакция от не отображен в документе");
        String textEditionFrom = editions.getText();
        postponedAssertTrue(textEditionFrom.contains(expectedText), "В тексте:" + textEditionFrom + " не содержится " +
                "текст:" + expectedText);
    }

    @Step("Проверить, что в теге title содержится текст <Заголовок документа>. +префикс системы")
    public void checkTitleTag() {
        String systemPrefix = "";
        if (getSettings().isRunBss()) {
            systemPrefix = ". Бухгалтерская справочная система «Система Главбух»";
        } else if (getSettings().isRunGf()) {
            systemPrefix = ". Справочная система «Госфинансы»";
        }
        WebElement title = waitForPresenceOfElementLocatedBy(By.cssSelector("#document-body .main__title"),
                "Не найден заголовок у документа");
        String documentTitle = hookForGettingTextWithoutIncludingChildElementsText(title);
        documentTitle = TestUtils.replaceIllegalCharacters(documentTitle);
        checkTagTitle(documentTitle + systemPrefix);
    }

    @Step("Проверить, что заголовок документа содержит название документа, фото, фио и должность автора")
    public void checkTitleAndAuthorInformationPresent() {
        WebElement title = findElementByNoThrow(By.cssSelector(".main__title"));
        postponedAssertTrue(title.isDisplayed() && title.getText().length() != 0, "Заголовок документа не отображен");
        WebElement authorPhoto = findElementByNoThrow(By.cssSelector(".author__portrait"));
        postponedAssertTrue(authorPhoto.isDisplayed(), "Фотография автора не отображена");
        WebElement authorName = findElementByNoThrow(By.cssSelector(".author__name"));
        postponedAssertTrue(authorName.isDisplayed() && authorName.getText().length() != 0, "Имя автора не отображено " +
                "в документе");
        WebElement authorProps = findElementByNoThrow(By.cssSelector(".author__props"));
        postponedAssertTrue(authorProps.isDisplayed() && authorProps.getText().length() != 0, "Должность автора не " +
                "отображена в документе");
    }

    @Step("Проверить, что для документа из модуля 11 номер документа 13565 сторнированные проводки обведены в рамку")
    public void checkProvodkiForDocument11_13565() {
        WebElement paragraphWithStyle = findElementByNoThrow(By.xpath("//*[@data-role='phrase-incut']//p[@style]"));
        postponedAssertTrue(paragraphWithStyle != null && paragraphWithStyle.isDisplayed(), "Сторнированные проводки " +
                "не отображаюся в документе");
        WebElement border = paragraphWithStyle.findElement(By.cssSelector(".storno"));
        postponedAssertEquals(border.getCssValue("border-top-width"), "1px", "Сторнированные проводки не обведены в рамку");
    }

    @Step("Проверить, что во врезе документа 11/14355 открывается расчетчик Транспортного налога")
    public void checkTransportTaxForDoc_11_14355() {
        WebElement calculateLink = findElementByNoThrow(By.xpath("(//*[@data-document-id='4'])[1]"));
        calculateLink.click();
        WebElement region = waitForPresenceOfElementLocatedBy(By.id("regionId"), "Расчетчик транспортного налога не появился после " +
                "нажатия на ссылку Рассчитать на моих данных");
        Select selectRegion = new Select(region);
        assertFalse(selectRegion.getOptions().size() == 1 && selectRegion.getOptions().get(0).getText().contains("Выберите регион"), "Отсутствует список регионов в выпадающем списке");
        selectRegion.selectByValue("89");

        Select selectYear = new Select(findElementBy(By.id("year")));
        selectYear.selectByValue("2015");

        Select selectVehicle = new Select(findElementBy(By.id("vehicle")));
        selectVehicle.selectByValue("automobile");

        WebElement power = waitForPresenceOfElementLocatedBy(By.id("power"));
        power.sendKeys("75");

        WebElement dateInputField = findElementBy(By.id("registerInPoliceDate"));
        dateInputField.clear();
        dateInputField.sendKeys("01-01-2014");

        WebElement buttonCalculate = findElementByNoThrow(By.cssSelector(".estimator-button"));
        buttonCalculate.click();

        WebElement errors = findElementByNoThrow(By.cssSelector(".estimator-form-errors"));

        if (errors != null && errors.isDisplayed()) {
            setPostponedTestFail("После нажатия на кнопку Рассчитать появилась ошибка:" + errors.getText());
        }

        WebElement bill = waitForPresenceOfElementLocatedBy(By.id("estimator-bill"));
        postponedAssertTrue(bill.isDisplayed(), "После нажатия на кнопку Рассчитать результат не появился.");
    }

    @Step("Проверяется отображение 'Конвертера валют'")
    public void checkCurrencyDocument() {
        WebElement header = findElementByNoThrow(documentBody, By.cssSelector(".main__title"));
        WebElement text = findElementByNoThrow(documentBody, By.tagName("xmlcontent"));
        WebElement sendBlockHeader = findElementByNoThrow(documentBody, By.cssSelector("[for='currency-1']"));
        WebElement dropDownForFirstCurrency = findElementByNoThrow(documentBody, By.id("currency-dropbox-1"));
        WebElement changeCurrencyPlaceButton = findElementByNoThrow(documentBody, By.id("swap-currencies"));
        WebElement dropDownForSecondCurrency = findElementByNoThrow(documentBody, By.id("currency-dropbox-2"));
        WebElement totalBlockHeader = findElementByNoThrow(documentBody, By.cssSelector("[for='currency-1-sum']"));
        WebElement firstCurrencyTotalField = findElementByNoThrow(documentBody, By.id("currency-1-sum"));
        WebElement firstCurrencyNameField = findElementByNoThrow(documentBody, By.id("currency-iso-code-1"));
        WebElement equalSign = findElementByNoThrow(documentBody, By.cssSelector(".ico_content_equally"));
        WebElement secondCurrencyTotalField = findElementByNoThrow(documentBody, By.id("currency-2-sum"));
        WebElement secondCurrencyNameField = findElementByNoThrow(documentBody, By.id("currency-iso-code-2"));
        WebElement calendarLabelField = findElementByNoThrow(documentBody, By.cssSelector("[for='currency-date']"));
        WebElement calendarField = findElementByNoThrow(documentBody, By.id("currency-date"));
        WebElement lastCourseTableHeader = findElementByNoThrow(documentBody, By.cssSelector(".main__title-part"));
        WebElement lastCourseTable = findElementByNoThrow(documentBody, By.cssSelector(".table_content_currency"));

        postponedAssertNotNull(header, "Заголовок 'Конвертер валют' не найден");
        if (header != null) {
            postponedAssertTrue(header.isDisplayed(), "Заголовок 'Конвертер валют' не отображается");
            postponedAssertEquals(header.getText(), "Курсы валют", "Неправильный текст заголовка 'Конвертер валют'");
        }

        postponedAssertNotNull(text, "Текст 'Здесь вы можете посмотреть курс любой...' не найден");
        if (text != null) {
            postponedAssertTrue(text.isDisplayed(), "Текст 'Здесь вы можете посмотреть курс любой...' не отображается");
            postponedAssertEquals(text.getText(), "Здесь вы можете посмотреть курс любой валюты на текущий день или на предыдущие даты и легко пересчитать нужную сумму по выбранному курсу. Все данные в этот сервис загружаются с сайта Банка России.", "Неправильный текст 'Здесь вы можете посмотреть курс любой...'");
        }

        postponedAssertNotNull(sendBlockHeader, "Заголовок 'Перевести:' не найден");
        if (sendBlockHeader != null) {
            postponedAssertTrue(sendBlockHeader.isDisplayed(), "Заголовок 'Перевести:' не отображается");
            postponedAssertEquals(sendBlockHeader.getText(), "Перевести:", "Неправильный текст заголовка 'Перевести:'");
        }

        postponedAssertNotNull(dropDownForFirstCurrency, "Дропдаун выбора 1ой валюты не найден");
        if (dropDownForFirstCurrency != null) {
            postponedAssertTrue(dropDownForFirstCurrency.isDisplayed(), "Дропдаун выбора 1ой валюты не отображается");
            postponedAssertEquals(dropDownForFirstCurrency.getText(), "Доллар США", "Неправильное значение по-умолчанию в дропдауне для выбора 1ой валюты");
        }

        postponedAssertNotNull(changeCurrencyPlaceButton, "Кнопка 'Поменять валюты местами' не найдена");
        if (changeCurrencyPlaceButton != null) {
            postponedAssertTrue(changeCurrencyPlaceButton.isDisplayed(), "Кнопка 'Поменять валюты местами' не отображается");
        }

        postponedAssertNotNull(dropDownForSecondCurrency, "Дропдаун выбора 2ой валюты не найден");
        if (dropDownForSecondCurrency != null) {
            postponedAssertTrue(dropDownForSecondCurrency.isDisplayed(), "Дропдаун выбора 2ой валюты не отображается");
            postponedAssertEquals(dropDownForSecondCurrency.getText(), "Российский рубль", "Неправильное значение по-умолчанию в дропдауне для выбора 2ой валюты");
        }

        postponedAssertNotNull(totalBlockHeader, "Заголовок 'Сумма:' не найден");
        if (totalBlockHeader != null) {
            postponedAssertTrue(totalBlockHeader.isDisplayed(), "Заголовок 'Сумма:' не отображается");
            postponedAssertEquals(totalBlockHeader.getText(), "Сумма:", "Неправильный текст заголовка 'Сумма:'");
        }

        postponedAssertNotNull(firstCurrencyTotalField, "Поле для суммы 1ой валюты не найден");
        if (firstCurrencyTotalField != null) {
            postponedAssertTrue(firstCurrencyTotalField.isDisplayed(), "Поле для суммы 1ой валюты не отображается");
            postponedAssertEquals(firstCurrencyTotalField.getAttribute("value"), "100", "Неправильное значение по-умолчанию в поле для суммы 1ой валюты");
        }

        postponedAssertNotNull(firstCurrencyNameField, "Наименование для 1ой валюты не найдено");
        if (firstCurrencyNameField != null) {
            postponedAssertTrue(firstCurrencyNameField.isDisplayed(), "Наименование для 1ой валюты не отображается");
            postponedAssertEquals(firstCurrencyNameField.getText(), "USD", "Неправильное значение по-умолчанию в наименовании для 1ой валюты");
        }

        postponedAssertNotNull(equalSign, "Знак '=' (между полями сумм) не найден");
        if (equalSign != null) {
            postponedAssertTrue(equalSign.isDisplayed(), "Знак '=' (между полями сумм) не отображается");
        }

        postponedAssertNotNull(secondCurrencyTotalField, "Поле для суммы 2ой валюты не найден");
        if (secondCurrencyTotalField != null) {
            postponedAssertTrue(secondCurrencyTotalField.isDisplayed(), "Поле для суммы 2ой валюты не отображается");
        }

        postponedAssertNotNull(secondCurrencyNameField, "Наименование для 2ой валюты не найдено");
        if (secondCurrencyNameField != null) {
            postponedAssertTrue(secondCurrencyNameField.isDisplayed(), "Наименование для 2ой валюты не отображается");
            postponedAssertEquals(secondCurrencyNameField.getText(), "RUB", "Неправильное значение по-умолчанию в наименовании для 2ой валюты");
        }

        postponedAssertNotNull(calendarLabelField, "Заголовок поля календаря 'По курсу ЦБ РФ на:' не найден");
        if (calendarLabelField != null) {
            postponedAssertTrue(calendarLabelField.isDisplayed(), "Заголовок поля календаря 'По курсу ЦБ РФ на:' не отображается");
            postponedAssertEquals(calendarLabelField.getText(), "По курсу \n" +
                    "ЦБ РФ на", "Неправильный текст заголовка 'По курсу ЦБ РФ на:'");
        }

        postponedAssertNotNull(calendarField, "Поле календарь не найдено");
        if (calendarField != null) {
            postponedAssertTrue(calendarField.isDisplayed(), "Поле календарь не отображается");
            DateTimeFormatter dateTimeFormat = DateTimeFormat.forPattern("dd.MM.yyyy");
            DateTime today = new DateTime();
            DateTime tomorrow = new DateTime().plusDays(1);

            String actualValueInCalendar = calendarField.getAttribute("value");
            postponedAssertTrue(actualValueInCalendar.equals(today.toString(dateTimeFormat)) || actualValueInCalendar.equals(tomorrow.toString(dateTimeFormat)), "Неправильное значение по-умолчанию в поле календарь");
        }

        postponedAssertNotNull(lastCourseTableHeader, "Заголовок таблицы не найден");
        if (lastCourseTableHeader != null) {
            postponedAssertTrue(lastCourseTableHeader.isDisplayed(), "Заголовок таблицы не отображается");
            postponedAssertEquals(lastCourseTableHeader.getText(), "Курс RUB за 1 USD\n" +
                    "за предыдущие дни", "Неправильный текст заголовка таблицы");
        }

        postponedAssertNotNull(lastCourseTable, "Таблица курсов за предыдущие дни не найдена");
        if (lastCourseTable != null) {
            postponedAssertTrue(lastCourseTable.isDisplayed(), "Таблица курсов за предыдущие дни не отображается");
        }
    }

    @Step("Выбрать 1ую валюту по коду")
    public void selectFirstCurrencyByCode(String code) {
        WebElement dropDownForFirstCurrency = findElementByNoThrow(documentBody, By.cssSelector("#currency-dropbox-1 .list_type_dropdown [data-virtual-iso-code='" + code + "']"));
        dropDownForFirstCurrency.click();
        waitForReloadingPage();
    }

    @Step("Выбрать 2ую валюту по коду")
    public void selectSecondCurrencyByCode(String code) {
        WebElement dropDownForSecondCurrency = findElementByNoThrow(documentBody, By.cssSelector("#currency-dropbox-2 .list_type_dropdown [data-virtual-iso-code='" + code + "']"));
        dropDownForSecondCurrency.click();
        waitForReloadingPage();
    }

    @Step("Поменять местами валюты ")
    public void clickChangeCurrencyOrderButton() {
        WebElement changeCurrencyPlaceButton = findElementByNoThrow(documentBody, By.id("swap-currencies"));
        changeCurrencyPlaceButton.click();
    }

    @Step("Проверяется текст для 1го поля суммы валют")
    public void checkFirstCurrencyLabel(String code) {
        WebElement firstCurrencyNameField = findElementByNoThrow(documentBody, By.id("currency-iso-code-1"));
        postponedAssertEquals(firstCurrencyNameField.getText(), code, "Неправильный текст для 1го поля суммы валют");
    }

    @Step("Проверяется текст для 1го поля суммы валют")
    public void checkSecondCurrencyLabel(String code) {
        WebElement secondCurrencyNameField = findElementByNoThrow(documentBody, By.id("currency-iso-code-2"));
        postponedAssertEquals(secondCurrencyNameField.getText(), code, "Неправильный текст для 2го поля суммы валют");
    }

    @Step("Проверяется заголовок таблицы курсов валют")
    public void checkTableCourseLabel(String codeFirstCurrency, String codeSecondCurrency) {
        WebElement lastCourseTableHeader = findElementByNoThrow(documentBody, By.cssSelector(".main__title-part"));
        String lastCourseTableHeaderText = lastCourseTableHeader.getText();
        postponedAssertTrue(lastCourseTableHeaderText.startsWith("Курс " + codeSecondCurrency + " за ") && lastCourseTableHeaderText.endsWith(codeFirstCurrency + "\nза предыдущие дни"), "Неправильный заголовок таблицы курсов валют");
    }

    @Step("Проверяется что значения в таблице за предыдущие дни изменились")
    public void checkLastCourseTableIsChanged() {
        String previousTableText = String.valueOf(getParameter(COURSE_TABLE_TEXT));
        WebElement lastCourseTable = findElementByNoThrow(documentBody, By.cssSelector(".table_content_currency"));
        postponedAssertNotEquals(lastCourseTable.getText(), previousTableText, "Значения в таблице за предыдущие дни не изменились");
    }

    public void setLastCourseTableToParameter() {
        WebElement lastCourseTable = findElementByNoThrow(documentBody, By.cssSelector(".table_content_currency"));
        setParameter(COURSE_TABLE_TEXT, lastCourseTable.getText());
    }

    @Step("Проверить, что лого Главбуха отображается в контенте документа")
    public void checkLogoGlavbukhInDocumentContentFooter() {
        String logoName = "gb-new.png";
        WebElement contentFooter = findElementByNoThrow(By.cssSelector(".rssGlavbukh-footer img"));
        postponedAssertNotNull(contentFooter, "Лого Главбух не отображено в футере документа");
        String href = contentFooter.getAttribute("src");
        postponedAssertTrue(href.contains(logoName), "Отображено не то лого документа:" +
                "ссылка на лого:" + href + " ищем вхождение: " + logoName);
        WebElement link = findElementByNoThrow(By.cssSelector(".rssGlavbukh-footer a"));
        postponedAssertEquals(link.getAttribute("href"), "http://www.glavbukh.ru/", "Ссылка на картинке не ведет на " +
                "сайт http://www.glavbukh.ru/");
    }

    @Step("Проверить, что блок с уровнем риска отображается в документе")
    public void checkSafetyLightsIsPresent() {
        WebElement safetyLigths = findElementByNoThrow(By.cssSelector(".safety-light"));
        postponedAssertTrue(safetyLigths.isDisplayed(), "Светофор не отображается в документе");
    }

    @Step("Проверить, что документ 9598 из модуля 170 содержит врезы")
    public void checkControlBlockIncutForDocument170_9598() {
        List<WebElement> controlBlocksIncut = findElementsByNoThrow(
                By.cssSelector("[data-control-name='tax-broadcast-control']"));
        postponedAssertTrue(controlBlocksIncut != null && controlBlocksIncut.size() == 2, "Врезы в документе не найдены");
        postponedAssertTrue(controlBlocksIncut.get(0).isDisplayed(), "Врез обоснование не отображен на странице");
        postponedAssertTrue(controlBlocksIncut.get(1).isDisplayed(), "Врез В деталях не отображен на странице");
    }

    @Step("Проверить блок Оценка безопасности")
    public void checkSafetyResultIsPresent() {
        WebElement safetyResult = findElementByNoThrow(By.xpath("//section[@class='safety-result']"));
        postponedAssertTrue(safetyResult.isDisplayed(), "Блок Оценка Безопасности не отображен в документе");
    }

    @Step("Проверить, что отображается блок с оценкой ред.материалов")
    public void checkDocumentRatingIsPresent() {
        WebElement docRating = findElementByNoThrow(By.cssSelector(".doc-rating"));
        postponedAssertTrue(docRating.isDisplayed(), "Блок Оценка Редакционных материалов не отображен в документе");
    }

    @Step("Проверить, что блок выигрывает сотрудник и работодатель")
    public void checkBlockDispute() {
        List<WebElement> disputeLegend = findElementsByNoThrow(By.cssSelector(".dispute-header-legend"));
        postponedAssertTrue(disputeLegend.size() == 2, "В блоке Выигрывает: сотрудник, работодатель находится не " +
                "два элемента");
        postponedAssertTrue(disputeLegend.get(0).getText().contains("сотрудник"), "Текст сотрудник не найден в " +
                "блоке Выигрывает: сотрудник, работодатель");
        postponedAssertTrue(disputeLegend.get(1).getText().contains("работодатель"), "Текст работодатель не найден в " +
                "блоке Выигрывает: сотрудник, работодатель");

        List<WebElement> disputeLinks = findElementsByNoThrow(By.cssSelector(".dispute-header-block a"));
        checkBlockLinks(disputeLinks);
    }

    @Step("Проверить, что кнопка рубрикатора Обсудить отображена на странице")
    public void checkCommentsRubricatorButtonIsPresent() {
        WebElement commentBtn = findElementByNoThrow(By.id("comments-btn"));
        postponedAssertTrue(commentBtn.isDisplayed(), "Кнопка рубрикатора Обсудить не отображена на странице");
    }

    @Step("Проверить, что блок с датой и ссылка на НПД Утверждающий документ отображены на странице")
    public void checkBriefBlockIsPresent() {
        WebElement briefBlock = findElementByNoThrow(By.cssSelector(".brief"));
        postponedAssertTrue(briefBlock.isDisplayed(), "Блок с датой и НПД не отображен на странице");
        WebElement briefDate = findElementByNoThrow(briefBlock, By.cssSelector(".brief-date"));
        postponedAssertTrue(briefDate.isDisplayed(), "Блок с датой не отображен на странице");
        WebElement briefLink = findElementByNoThrow(briefBlock, By.cssSelector(".brief-text a"));
        postponedAssertTrue(briefLink.isDisplayed(), "Ссылка на НПД документ не отображена на странице");
    }

    @Step("Проверить, что текстовые блоки документа 10304: Что изменилось, Как сдать, Кто сдает... отображены в документе")
    public void checkTextBlocksForDocument199_10304() {
        String[] textBlockesTitles = {"Что изменилось", "Как сдать", "Кто сдает", "Как заполнить", "В правовой базе"};
        List<WebElement> textTitles = findElementsByNoThrow(By.cssSelector(".toc"));
        postponedAssertTrue(textTitles.size() == textBlockesTitles.length, "Количество блоков в документе 10304 не " +
                "совпадает с количеством блоков, которые должны быть в документе");
        boolean isFirstBlockFound = false;
        for (WebElement title : textTitles) {
            String text = title.getText();
            if (text.contains("Что изменилось")) {
                isFirstBlockFound = true;
            } else {
                postponedAssertTrue(TestUtils.isElementContainsInArray(text, textBlockesTitles), "Блока: " + text +
                        " нет в списке искомых блоков:" + textBlockesTitles);
            }
        }
        postponedAssertTrue(isFirstBlockFound, "Блок Что изменилось за... не найден в документе");

    }

    @Step("Проверить, что текстовые блоки документа 10182: Что изменилось, Как сдать, Кто сдает... отображены в документе")
    public void checkTextBlocksForDocument199_10182() {
        String[] textBlockesTitles = {"Как сдать", "Кто сдает"};
        List<WebElement> textTitles = findElementsByNoThrow(By.cssSelector(".toc"));
        postponedAssertTrue(textTitles.size() == textBlockesTitles.length, "Количество блоков в документе 10304 не " +
                "совпадает с количеством блоков, которые должны быть в документе");
        for (WebElement title : textTitles) {
            String text = title.getText();
            postponedAssertTrue(TestUtils.isElementContainsInArray(text, textBlockesTitles), "Блока: " + text +
                    " нет в списке искомых блоков:" + textBlockesTitles);
        }

    }

    @Step("Проверить, что блок Поделитесь с друзьями отображен на странице")
    public void checkSocialBlockIsPresent() {
        WebElement socialBlock = findElementByNoThrow(By.cssSelector(".doc-social-block"));
        postponedAssertTrue(socialBlock.isDisplayed(), "Блок Поделиться с друзьями не отображен на странице");
    }

    @Step("Проверить, что заголовок документа содержит название документа, фото, фио и должность автора")
    public void checkTitleWithModIdPubForRedactorUser() {
        WebElement title = findElementByNoThrow(By.cssSelector(".main__title"));
        postponedAssertTrue(title.isDisplayed() && title.getText().length() != 0, "Заголовок документа не отображен");
        String titleWithPubId = title.getText();
        if (!titleWithPubId.contains("(")) {
            setPostponedTestFail("В заголовке документа:" + titleWithPubId + " не присутствует mod, id и pub. Возможно " +
                    "пользователь не имеет редакторских прав?");
        } else {
            String intoTheBrackets = titleWithPubId.split("\\(")[1].split("\\)")[0];
            postponedAssertTrue(intoTheBrackets.length() > 0, "В заголовке документа, в скобках, не присутствуют " +
                    "данные для проверки");
        }
    }

    @Step("Проверить, что колонтитул документа отсутствует")
    public void сheckInfobarLinksIsNotPresent() {
        WebElement editions = findElementByNoThrow(By.cssSelector("[data-rel='infobar-links']"));
        postponedAssertTrue(editions == null || !editions.isDisplayed(), "Колонтитул документа присутствует на странице");
    }

    @Step("Присутствует желтый блок с названием и описанием фактоида")
    public void checkYellowBlockFactoid() {
        WebElement blockFactoid = findElementByNoThrow(By.cssSelector(".widget_type_factoids"));
        postponedAssertTrue(blockFactoid != null && blockFactoid.isDisplayed(), "Блок фактоид не отображен на странице");
        WebElement yellowBlock = findElementByNoThrow(blockFactoid, By.cssSelector(".widget__summary"));
        postponedAssertEquals(yellowBlock.getCssValue("background-color"), "rgba(253, 255, 233, 1)", "Блок фактоид не " +
                "желтого цвета");
        WebElement title = findElementByNoThrow(yellowBlock, By.tagName("h3"));
        postponedAssertTrue(title.getText().length() > 0, "Заголовок желтого блока пуст");
        postponedAssertEquals(title.getCssValue("border-bottom-width"), "1px", "Черта, отделяющая название от блока, " +
                "не найдена или больше 1 пикселя");
        WebElement description = findElementByNoThrow(yellowBlock, By.tagName("p"));
        postponedAssertTrue(description.getText().length() > 0, "Описание желтого блока пустое");
    }

    @Step("Проверить отображение блока Как сэкономить")
    public void checkSavingMoneyBlock() {
        WebElement savingMoneyBlock = findElementByNoThrow(By.cssSelector(".saving-money"));
        postponedAssertTrue(savingMoneyBlock.isDisplayed(), "Блок Как сэкономить не отображен в документе");
        List<WebElement> savingMoneyItems = findElementsByNoThrow(savingMoneyBlock, By.cssSelector(".saving-money-item"));
        postponedAssertTrue(savingMoneyItems.size() > 0, "В блоке Как сэкономить нет ни одной записи");
        List<Link> links = new ArrayList<Link>();
        for (int i = 0; i < savingMoneyItems.size(); i++) {
            WebElement titleLink = findElementByNoThrow(savingMoneyItems.get(i), By.cssSelector(".saving-money-title a"));
            postponedAssertEquals(titleLink.getCssValue("color"), "rgba(43, 121, 217, 1)", "Цвет ссылки в блоке не " +
                    "синий");
            links.add(new Link(titleLink.getAttribute("href")));
            WebElement text = findElementByNoThrow(savingMoneyItems.get(i), By.cssSelector(".saving-money-text"));
            postponedAssertTrue(text.getText().length() > 0, "У ссылки: " + titleLink.getText() + " нет описания");
        }
        report("Проверка ссылок внутри блока Как сэкономить");
        checkLinks(links);
    }

    @Step("Проверить отображение двух и более авторов")
    public void checkAuthorsInformationIsPresent() {
        WebElement docAuthorBlock = findElementByNoThrow(By.cssSelector(".doc-author"));
        List<WebElement> authors = findElementsByNoThrow(docAuthorBlock, By.cssSelector(".author"));
        postponedAssertTrue(authors.size() >= 2, "Авторов документа меньше двух");
        WebElement authorPhoto = findElementByNoThrow(docAuthorBlock, By.cssSelector(".author__portrait"));
        postponedAssertTrue(authorPhoto == null || !authorPhoto.isDisplayed(), "Фотография автора отображена в " +
                "документе");
    }

    @Step("Проверить документ 173 модуля 2148")
    public void checkCommonViewDocument_173_2148() {
        report("Присутствует преамбула: Ситуация, Параметры выбора");
        WebElement preambleBlock = findElementByNoThrow(By.cssSelector(".preamble"));
        postponedAssertTrue(preambleBlock.isDisplayed(), "Блок Преамбула не отображен в документе");
        List<WebElement> titles = findElementsByNoThrow(preambleBlock, By.cssSelector(".preamble__title"));
        List<String> actualTitles = new ArrayList<String>();
        for (WebElement title : titles) {
            actualTitles.add(title.getText());
        }
        String[] expectedTitles = {"Ситуация", "Параметры выбора"};
        postponedAssertEquals(actualTitles.toArray(new String[actualTitles.size()]), expectedTitles, "В преамбуле не " +
                "совпадают заголовки");

        report("Присутствует Таблица принятия решений");
        List<WebElement> tables = findElementsByNoThrow(By.cssSelector("#document-body > .b-table"));
        postponedAssertTrue(tables.size() > 0, "Ни одна Таблица принятия решений не найдена в документе");

        report("Присутствует Схема");
        WebElement scheme = findElementByNoThrow(By.cssSelector("[data-role='idiagram']"));
        postponedAssertTrue(scheme.isDisplayed(), "Схема не найдена в документе");

        report("Присутствует Врез Сравнение");
        WebElement incutCompare = findElementByNoThrow(By.cssSelector(".incut-compare"));
        postponedAssertTrue(incutCompare.isDisplayed(), "Врез Сравнение не найден в документе");

        //Проверка вреза сравнение
        report("Проверяется врез Сравнение");
        WebElement incutButton = findElementBy(incutCompare, By.cssSelector(".incut-button"));

        report("Врез раскрывается");
        double documentSizeBefore = getHeightFromString(getDocumentBody().getCssValue("height"));
        double inCutSizeBefore = getHeightFromString(incutCompare.getCssValue("height"));
        scrollToElementLocationWithout200px(incutCompare);
        incutButton.click();
        waitForReloadingPage();
        double documentSizeAfter = getHeightFromString(getDocumentBody().getCssValue("height"));
        double inCutSizeAfter = getHeightFromString(incutCompare.getCssValue("height"));
        WebElement inCutBody = incutCompare.findElement(By.cssSelector(".incut-body"));
        postponedAssertTrue(inCutBody.isDisplayed(), "Открытый врез не отображается");
        postponedAssertFalse(inCutBody.getText().isEmpty(), "В открытом врезе Отсутствует текст");
        postponedAssertTrue(inCutSizeBefore < inCutSizeAfter, "После открытия вреза размер вреза не изменился");
        postponedAssertTrue(documentSizeAfter - documentSizeBefore == inCutSizeAfter - inCutSizeBefore, "После " +
                "открытия вреза размер документа не изменился");

        report("Врез содержит название");
        WebElement titleIncutCompare = findElementByNoThrow(incutCompare, By.cssSelector(".incut-head-control"));
        postponedAssertTrue(titleIncutCompare.getText().length() > 0, "Врез не содержит название");

        report("Врез содержит автора");
        WebElement authorIncutCompare = findElementByNoThrow(incutCompare, By.cssSelector(".author"));
        postponedAssertTrue(authorIncutCompare.getText().length() > 0, "Врез не содержит автора");

        report("Врез содержит 2 колонки с текстом");
        WebElement tableIncutCompare = findElementByNoThrow(incutCompare, By.cssSelector(".table_content_compare"));
        postponedAssertTrue(authorIncutCompare.getText().length() > 0, "Врез не содержит таблицу");

        WebElement tdWithWordOr = findElementByNoThrow(tableIncutCompare, By.xpath("//thead//td[2]"));
        postponedAssertEquals(tdWithWordOr.getText(), "или", "Колонки с текстом не разделены словом 'или'");

        report("Осмотреть элементы на наличие звездочек избранного: схема");

        WebElement titleScheme = findElementByNoThrow(By.xpath("//*[@data-role='idiagram']/preceding-sibling::p[1]"));
        WebElement starTitleScheme = findElementBy(titleScheme, By.xpath(".//a[@data-role='phrase-anchor']"));
        scrollToElementLocationWithout200px(starTitleScheme);
        moveMouseToElement(titleScheme.findElement(By.tagName("span")));
        waitForPresenceOf(starTitleScheme);
        postponedAssertTrue(starTitleScheme.isDisplayed(), "Не отображается звезда рядом с заголовком Схемы");

        WebElement starScheme = findElementByNoThrow(scheme, By.xpath(".//a[@data-role='phrase-anchor']"));
        postponedAssertTrue(starScheme == null, "Найдена звезда рядом со схемой");

        report("Осмотреть элементы на наличие звездочек избранного: врез");

        List<WebElement> starIncutCompare = findElementsByNoThrow(incutCompare,
                By.xpath(".//a[@data-role='phrase-anchor']"));

        scrollToElementLocationWithout200px(incutCompare);
        moveMouseToElement(titleIncutCompare);
        waitForPresenceOf(starIncutCompare.get(0)); //first star near of the incut title
        postponedAssertTrue(starIncutCompare.get(0).isDisplayed(), "Не отображается звезда рядом с заголовком Вреза");
        starIncutCompare.remove(0);

        for (WebElement starNotVisible : starIncutCompare) { //stars near the incut body table
            scrollToElementLocationWithout200px(starNotVisible);
            try {
                moveMouseToElement(starNotVisible);
            } catch (MoveTargetOutOfBoundsException exception) {
                //do nothing if the star is not visible
            }
            postponedAssertTrue(!starNotVisible.isDisplayed(), "Звезда избранного отображается внутри вреза");
        }

        report("Осмотреть элементы на наличие звездочек избранного: таблица");

        if (tables.size() == 2) {
            //apologize that the second table is decision table in the document 173/2148
            WebElement tableDecision = tables.get(1);
            WebElement titleDecisionTable = findElementByNoThrow(tableDecision, By.cssSelector(".title"));
            WebElement starTitleTable = findElementBy(titleDecisionTable, By.xpath(".//a[@data-role='phrase-anchor']"));
            scrollToElementLocationWithout200px(titleDecisionTable);
            moveMouseToElement(titleDecisionTable.findElement(By.tagName("span")));
            waitForPresenceOf(starTitleTable);
            postponedAssertTrue(starTitleTable.isDisplayed(), "Не отображается звезда рядом с заголовком Таблицы");

            List<WebElement> rows = findElementsBy(tableDecision, By.xpath(".//table//tr"));
            for (WebElement tr : rows) {
                WebElement star = findElementBy(tr, By.xpath(".//a[@data-role='phrase-anchor']"));
                scrollToElementLocationWithout200px(tr);
                moveMouseToElement(tr.findElement(By.tagName("span")));
                waitForPresenceOf(star);
                postponedAssertTrue(star.isDisplayed(), "Не отображается звезда рядом со строкой таблицы");
            }
        } else {
            warning("Звездочки избранного у таблицы не проверены, требуется рефакторинг теста!");
        }
    }

    @Step("Проверить, что заголовок документа содержит название документа, фото, фио и должность автора")
    public void checkTitleAndAuthorInformationWithoutPhotoPresent() {
        WebElement title = findElementByNoThrow(By.cssSelector(".main__title"));
        postponedAssertTrue(title.isDisplayed() && title.getText().length() != 0, "Заголовок документа не отображен");
        WebElement authorName = findElementByNoThrow(By.cssSelector(".author__name"));
        postponedAssertTrue(authorName.isDisplayed() && authorName.getText().length() != 0, "Имя автора не отображено " +
                "в документе");
        WebElement authorProps = findElementByNoThrow(By.cssSelector(".author__props"));
        postponedAssertTrue(authorProps.isDisplayed() && authorProps.getText().length() != 0, "Должность автора не " +
                "отображена в документе");
    }

    @Step("Проверить загрузку inline вложений в документе 178/2547")
    public void checkInlineDownloadsFromDocument178_2547() {
        final String docModule = "178";
        final String expectedLink = String.format("/system/content/feature/attachment/%s/-", docModule);
        List<WebElement> inlineLinks = findElementsByNoThrow(By.cssSelector("#document-body .js-export"));
        postponedAssertTrue(inlineLinks.size() > 0, "Inline ссылки не найдены в документе");
        for (WebElement link : inlineLinks) {
            postponedAssertTrue(link.getAttribute("href").contains(expectedLink), "Ссылка файла не содержит:" + expectedLink);
        }
    }

    @Step("Проверить, что документ \"заблюрен\"")
    public void checkDocumentIsBlurred() {
        postponedAssertTrue(mainContentElement.getAttribute("class").contains("blurring"), "Документ незаблюрен");
    }

    @Step("Проверить что Отображается заглушка Документ в платном доступе")
    public void checkDocPreviewTextStatus() {
        WebElement docPreview = findElementByNoThrow(By.id("pagewf-tooltip"));
        postponedAssertTrue(docPreview.isDisplayed(), "Заглушка не отображается");
        WebElement text = findElementBy(docPreview, By.cssSelector(".doc-preview__status-text"),
                "Текст заглушки не отображается");
        postponedAssertEquals(text.getText(), "Документ в платном доступе", "Текст заглушки написан неверно");
        WebElement lockIcon = findElementBy(docPreview, By.cssSelector(".ico_content_lock"));
        postponedAssertTrue(lockIcon.isDisplayed(), "Иконка замка не отображается");
    }

    @Step("Проверить, что Отображается блок Брифинг: {0}")
    public void checkDocBriefIsPresent(String expectedString) {
        WebElement docBrief = findElementByNoThrow(By.cssSelector(".doc-preview__brief"));
        postponedAssertNotNull(docBrief, "Блок:" + expectedString + " не отображается");
        if (docBrief != null) {
            postponedAssertTrue(docBrief.isDisplayed(), "Блок:" + expectedString + " не виден");
            postponedAssertTrue(docBrief.getText().contains(expectedString), "Текст " + expectedString + " не отображен");
        }
    }

    @Step("Проверить, что кнопки с беклинками отображаются в документе")
    public void checkBacklinksArePresent() {
        postponedAssertFalse(backlinks.isEmpty(), "Беклинки не найдены в документе");
    }

    @Step("Проверить, что беклинк имеет свойства css: border-top-color, border-top-style, border-top-width")
    public void checkBacklinkHasCssStyles() {
        WebElement backlink = getRandomElementInList(backlinks);
        postponedAssertEquals(backlink.getCssValue("border-top-color"), "rgba(89, 89, 89, 0.2)", "Цвет ячейки " +
                "беклинка не верный");
        postponedAssertEquals(backlink.getCssValue("border-top-style"), "solid", "Стиль ячейки " +
                "беклинка не верный");
        postponedAssertEquals(backlink.getCssValue("border-top-width"), "1px", "Ширина ячейки " +
                "беклинка не верна");
    }

    @Step("Нажать на кнопку с числом беклинков:{0}")
    public void clickOnBacklinkWithReferencesCount(int count) {
        this.referencesCount = count;
        WebElement backLinkWithCount = findElementByNoThrow(By.xpath(String.format("//*[contains(@class,'btn_type_references')][text()='%d']", count)));
        assertNotNull(backLinkWithCount, "Не найдена ни одна с числом беклинков:" + count);
        backLinkWithCount.click();
        waitForReloadingPage();
    }

    @Step("Проверить, что параграф и кнопка стали желтые")
    public void checkParagraphAndButtonAreYellow() {
        WebElement backLinkWithCount = findElementByNoThrow(By.xpath(String.format("//*[contains(@class,'btn_type_references')][text()='%d']", referencesCount)));
        postponedAssertEquals(backLinkWithCount.getCssValue("background-color"), "rgba(254, 235, 133, 1)", "Цвет кнопки беклинка не желтый");
        String paragraphBackground = (String) executeScript("return window.getComputedStyle(document.querySelector('.references_state_selected'),':after').getPropertyValue('background-color')");
        postponedAssertEquals(paragraphBackground, "rgb(255, 252, 237)", "Цвет параграфа не желтый");
    }

    @Step("Проверить, что параграф и кнопка стали серые")
    public void checkParagraphAndButtonAreGray() {
        WebElement backLinkWithCount = findElementByNoThrow(By.xpath(String.format("//*[contains(@class,'btn_type_references')][text()='%d']", referencesCount)));
        postponedAssertEquals(backLinkWithCount.getCssValue("background-color"), "rgba(238, 238, 238, 1)", "Цвет кнопки беклинка не серый");
        String paragraphBackground = (String) executeScript("return window.getComputedStyle(document.querySelector('.references_state_selected'),':after').getPropertyValue('background-color')");
        postponedAssertEquals(paragraphBackground, "rgb(245, 245, 245)", "Цвет параграфа не серый");
    }

    @Step("Проверить, что параграф НЕ желтый")
    public void checkParagraphAndButtonAreNotYellow() {
        WebElement backLinkWithCount = findElementByNoThrow(By.xpath(String.format("//*[contains(@class,'btn_type_references')][text()='%d']", referencesCount)));
        postponedAssertNotEquals(backLinkWithCount.getCssValue("background-color"), "rgba(254, 235, 133, 1)", "Цвет кнопки беклинка желтый");
    }

    @Step("Кликнуть на беклинк у статьи с якорем:{0}")
    public void clickOnRequiredArticleBacklink(String phraseAnchor) {
        waitForReloadingPage();
        WebElement anchorElement = findElementByNoThrow(By.xpath(String.format("//*[contains(@data-anchor,'%s')]", phraseAnchor)));
        assertNotNull(anchorElement, "Не найдена статья с якорем:" + phraseAnchor);
        if (anchorElement != null) {
            WebElement backlinkButton = findElementByNoThrow(anchorElement, By.xpath("./../span[contains(@class,'doc__references')]/span"));
            assertNotNull(backlinkButton, "Кнопка с беклинками не найдена для статьи с якорем:" + phraseAnchor);
            scrollToElementLocationWithout200px(backlinkButton);
            backlinkButton.click();
            waitForReloadingPage();
        }
    }

    @Step("Кликнуть на беклинк в шапке документа")
    public void clickOnTitleBacklink(String documentIdWithoutHashSymbol) {
        waitForReloadingPage();
        WebElement anchorElement = findElementByNoThrow(By.xpath(String.format("//*[@data-anchor='%s']",
                documentIdWithoutHashSymbol)));
        assertNotNull(anchorElement, "Не найдена статья с якорем:" + documentIdWithoutHashSymbol);
        if (anchorElement != null) {
            WebElement backlinkButton = findElementByNoThrow(anchorElement, By.xpath("./../span[contains(@class,'doc__references')]/span"));
            assertNotNull(backlinkButton, "Кнопка с беклинками не найдена для статьи с якорем:" + documentIdWithoutHashSymbol);
            scrollToElementLocationWithout200px(backlinkButton);
            backlinkButton.click();
            waitForReloadingPage();
        }
    }

    @Step("Открыть беклинк заголовка документа")
    public void clickOnBackLinkFromTitle() {
        waitForReloadingPage();
        WebElement title = findElementByNoThrow(By.cssSelector("h1.main__title"));
        WebElement backlink = findElementByNoThrow(title, By.cssSelector(".doc__references span"));
        postponedAssertNotNull(backlink, "Беклинк заголовка не найден");
        backlink.click();
    }

    @Step("Проверить, что текст документа содержит блоки: Как правильно, Что делать")
    public void checkTextContainsBlocksHowToAndWhatToDo() {
        String howToText = "Как правильно";
        WebElement howToElement = findElementByNoThrow(getDocumentBody(), By.xpath(String.format("//*[text()='%s']", howToText)));
        postponedAssertNotNull(howToElement, "Блок:" + howToText + " не найден в документе");
        String whatToDoText = "Что делать";
        WebElement whatToDoElement = findElementByNoThrow(getDocumentBody(), By.xpath(String.format("//*[text()='%s']", whatToDoText)));
        postponedAssertNotNull(whatToDoElement, "Блок:" + whatToDoText + " не найден в документе");
    }

    @Step("Проверить, что во врезе Совет есть слова:{0}")
    public void checkIncutAdviceContainsText(String text) {
        WebElement incutPrefix = findElementByNoThrow(By.cssSelector(".incut-head-prefix"));
        postponedAssertEqualsText(incutPrefix, text);
    }

    @Step("Проверить, что кнопка назад (Предыдущая статья) в Верхнем меню навигации не активна или отсуствует")
    public void checkButtonPreviousInTopMenuIsNotPresent() {
        WebElement prevButtonTop = findElementByNoThrow(mainLeftElement, By.cssSelector(".doc-pages [class*=backward]"));
        postponedAssertTrue(prevButtonTop == null || prevButtonTop.getAttribute("class").contains("disabled"),
                "Кнопка назад в верхнем меню активна");
    }

    @Step("Проверить, что кнопка вперед (Следующая статья) в Верхнем меню навигации не активна или отсуствует")
    public void checkButtonNextInTopMenuIsNotPresent() {
        WebElement nextButtonTop = findElementByNoThrow(mainLeftElement, By.cssSelector(".doc-pages [class*=forward]"));
        postponedAssertTrue(nextButtonTop == null || nextButtonTop.getAttribute("class").contains("disabled"),
                "Кнопка назад в верхнем меню активна");
    }

    @Step("Проверить, что кнопка вперед (Следующая статья) в Нижнем меню навигации  отсуствует")
    public void checkButtonNextInBottomMenuIsNotPresent() {
        WebElement nextButtonBottom = findElementByNoThrow(mainLeftElement, By.cssSelector(".doc-chapters [class*=forward]"));
        postponedAssertTrue(nextButtonBottom == null || nextButtonBottom.getAttribute("class").contains("disabled"),
                "Кнопка назад в верхнем меню активна");
    }

    @Step("Проверить, что кнопка назад (Предыдущая статья) в Нижнем меню навигации  отсуствует")
    public void checkButtonPreviousInBottomMenuIsNotPresent() {
        WebElement prevButtonBottom = findElementByNoThrow(mainLeftElement, By.cssSelector(".doc-chapters [class*=backward]"));
        postponedAssertTrue(prevButtonBottom == null || prevButtonBottom.getAttribute("class").contains("disabled"),
                "Кнопка назад в верхнем меню активна");
    }

    @Step("Нажать на кнопку назад (Предыдущая статья) в Верхнем меню навигации")
    public void clickOnPrevButtonInTopMenu() {
        WebElement prevButtonTop = findElementByNoThrow(mainLeftElement, By.cssSelector(".doc-pages [class*=backward]"));
        if (prevButtonTop != null) {
            setParameter(SearchResultHelper.DOCUMENT_URL, prevButtonTop.getAttribute("href"));
            prevButtonTop.click();
            waitForReloadingPage();
        } else {
            setPostponedTestFail("Кнопка назад не найдена");
        }
    }

    @Step("Нажать на кнопку вперед (Следующая статья) в Верхнем меню навигации")
    public void clickOnNextButtonInTopMenu() {
        WebElement nextButtonTop = findElementByNoThrow(mainLeftElement, By.cssSelector(".doc-pages [class*=forward]"));
        if (nextButtonTop != null) {
            setParameter(SearchResultHelper.DOCUMENT_URL, nextButtonTop.getAttribute("href"));
            nextButtonTop.click();
            waitForReloadingPage();
        } else {
            setPostponedTestFail("Кнопка вперед не найдена");
        }
    }

    @Step("Нажать на кнопку назад (Предыдущая статья) в Нижнем меню навигации")
    public void clickOnPreviousButtonInBottomMenu() {
        WebElement prevButtonBottom = findElementByNoThrow(mainLeftElement, By.cssSelector(".doc-chapters [class*=backward] a"));
        if (prevButtonBottom != null) {
            setParameter(SearchResultHelper.DOCUMENT_URL, prevButtonBottom.getAttribute("href"));
            prevButtonBottom.click();
            waitForReloadingPage();
        } else {
            setPostponedTestFail("Кнопка назад не найдена");
        }
    }

    @Step("Нажать на кнопку вперед (Следующая статья) в Нижнем меню навигации")
    public void clickOnNextButtonInBottomMenu() {
        WebElement nextButtonBottom = findElementByNoThrow(mainLeftElement, By.cssSelector(".doc-chapters [class*=forward] a"));
        if (nextButtonBottom != null) {
            setParameter(SearchResultHelper.DOCUMENT_URL, nextButtonBottom.getAttribute("href"));
            nextButtonBottom.click();
            waitForReloadingPage();
        } else {
            setPostponedTestFail("Кнопка вперед не найдена");
        }
    }

    @Step("Проверяется, что отображаются обе кнопки вперед и назад в Верхнем меню навигации")
    public void checkNextAndPrevButtonsInTopMenuArePresent() {
        WebElement prevButtonTop = findElementByNoThrow(mainLeftElement, By.cssSelector(".doc-pages [class*=backward]"));
        WebElement nextButtonTop = findElementByNoThrow(mainLeftElement, By.cssSelector(".doc-pages [class*=forward]"));
        postponedAssertTrue(prevButtonTop != null && prevButtonTop.isDisplayed() &&
                !prevButtonTop.getAttribute("class").contains("disabled"), "Кнопка назад не активна или не " +
                "отображена на странице:" + getCurrentUrl());
        postponedAssertTrue(nextButtonTop != null && nextButtonTop.isDisplayed() &&
                !nextButtonTop.getAttribute("class").contains("disabled"), "Кнопка вперед не активна или не " +
                "отображена на странице" + getCurrentUrl());
    }

    @Step("Проверяется, что отображаются обе кнопки вперед и назад в Верхнем меню навигации")
    public void checkNextAndPrevButtonsInBottomMenuArePresent() {
        WebElement prevButtonBottom = findElementByNoThrow(mainLeftElement, By.cssSelector(".doc-chapters [class*=backward]"));
        WebElement nextButtonBottom = findElementByNoThrow(mainLeftElement, By.cssSelector(".doc-chapters [class*=forward]"));
        postponedAssertTrue(prevButtonBottom != null && prevButtonBottom.isDisplayed() &&
                !prevButtonBottom.getAttribute("class").contains("disabled"), "Кнопка назад не активна или не " +
                "отображена на странице" + getCurrentUrl());
        postponedAssertTrue(nextButtonBottom != null && nextButtonBottom.isDisplayed() &&
                !nextButtonBottom.getAttribute("class").contains("disabled"), "Кнопка вперед не активна или не " +
                "отображена на странице" + getCurrentUrl());
    }

    @Step("Открыть первую статью из рубрикатора Содержания")
    public void clickFirstArticleFromTableOfContents() {
        WebElement content = getDescriptionElement();
        List<WebElement> items = content.findElements(By.tagName("a"));
        if (items.get(0).getText().isEmpty()) { // for several magazines which don't contain the main title (the main title is empty)
            items.get(2).click();
        } else {
            items.get(1).click();
        }
        waitForReloadingPage();
    }

    @Step("Открыть последнюю статью из рубрикатора Содержания")
    public void clickLastArticleFromTableOfContents() {
        WebElement content = getDescriptionElement();
        List<WebElement> items = content.findElements(By.tagName("a"));
        items.get(items.size() - 1).click();
        waitForReloadingPage();
    }


    @Step("Проверить, что название открытого расчетчика/теста соответствует названию ссылки")
    public void checkOpenedLinkHasRequiredTitle() {
        WebElement h1 = getDocumentBody().findElement(By.tagName("h1"));
        String linkTitle = (String) getParameter(ServicesHelper.LINK_TITLE);
        postponedAssertEqualsText(h1, linkTitle);
    }

    @Step("Проверяется, что Еще по теме в залипающем колонтитуле отображено")
    public void checkMoreOnTheTopicIsPresent() {
        WebElement moreOnTheTopicLink = findElementByNoThrow(getDocumentHeader(), By.cssSelector("[data-rel='infobar-links']"));
        postponedAssertTrue(moreOnTheTopicLink != null && moreOnTheTopicLink.isDisplayed(), "Еще по теме не отображается в колонтитуле документа");
        if (moreOnTheTopicLink != null) {
            postponedAssertEqualsText(moreOnTheTopicLink, "Ещё по теме");
        }
    }

    @Step("Проверить, что отображаются Комментарии к статье")
    public void checkCommentsArePresent() {
        List<WebElement> comments = findElementsByNoThrow(By.cssSelector(".doc__references-link"));
        postponedAssertTrue(comments != null && !comments.isEmpty(), "Ни одного комментария не найдено для документа");
    }

    @Step("Проверить, что История изменений отображается в колонтитуле документа")
    public void checkRevisionHistoryLinkIsPresent() {
        WebElement revisionHistory = findElementByNoThrow(By.cssSelector("[data-rel='infobar-changes']"));
        postponedAssertTrue(revisionHistory != null && revisionHistory.isDisplayed(), "История изменений не " +
                "отображается в колонтитуле документа");
    }

    @Step("Проверяется что кнопка 'Отправить' отображается")
    public void checkSendButtonIsPresentForKodeks() {
        WebElement header = waitForPresenceOfElementLocatedBy(By.id("document-header"), "Заголовок документа не найден");
        WebElement browserButton = findElementByNoThrow(header, By.cssSelector(".ico_content_mail"));
        postponedAssertNotNull(browserButton, "Кнопка 'Отправить' не найдена");
        postponedAssertTrue(browserButton.isDisplayed(), "Кнопка 'Отправить' не отображается");
    }

    @Step("Проверить, что плашка залипающего заголовка серая")
    public void checkStickyHeaderIsGray() {
        WebElement stickyHeader = getStickyHeader();
        postponedAssertNotNull(stickyHeader, "Плашка залипающего заголовка не отобразилась.");
        if (stickyHeader != null) {
            postponedAssertEquals(stickyHeader.getCssValue("background-color"), "rgba(239, 239, 239, 1)", "Цвет плашки не серый");
        }
    }

    @Step("Нажать на серую плашку")
    public void clickOnStickyHeader() {
        WebElement stickyHeader = getStickyHeader(false);
        postponedAssertNotNull(stickyHeader, "Плашка залипающего заголовка не отобразилась.");
        if (stickyHeader != null) {
            stickyHeader.click();
            waitForReloadingPage();
        }
    }

    @Step("Проверить, что после нажатия на серую плашку, плашка исчезает")
    public void checkStickyHeaderIsNotPresent() {
        WebElement stickyHeader = getStickyHeader(false);
        if (stickyHeader != null || stickyHeader.isDisplayed()) {
            clickOnStickyHeader();
        }
        postponedAssertTrue(stickyHeader == null || !stickyHeader.isDisplayed(), "Серая плашка не исчезла после нажатия");
    }

    /**
     * Returns the sticky header element
     */
    private WebElement getStickyHeader(boolean doScroll) {
        WebElement stickyHeader = findElementByNoThrow(By.id("sticky-header"));
        if (stickyHeader == null && doScroll == true) {
            scrollScript(500); // try to get visible sticky header
            stickyHeader = findElementByNoThrow(By.id("sticky-header"));
        }
        return stickyHeader;
    }

    private WebElement getStickyHeader() {
        return getStickyHeader(true);
    }

    @Step("Нажать на ссылку Еще по теме в инфобаре документа")
    public void clickOnMoreLinksFromInfobarOfTheDocument() {
        WebElement moreLinksLink = findElementByNoThrow(getDocumentHeader(), By.cssSelector("[data-rel='infobar-links']"));
        if (moreLinksLink != null) {
            moreLinksLink.click();
            waitForReloadingPage();
        } else {
            setPostponedTestFail("Ссылка Еще по теме не найдена в документе");
        }
    }

    @Step("Проверить, что ссылка Еще по теме подсвечивается желтым")
    public void checkMoreLinksLinkHasYellowHighlightAfterClicking() {
        WebElement moreLinksLink = findElementByNoThrow(getDocumentHeader(), By.cssSelector("[data-rel='infobar-links'] a"));
        String highlightColor = moreLinksLink.getCssValue("background-color");
        postponedAssertEquals(highlightColor, "rgba(241, 233, 161, 1)", "Еще по теме не подсветилась желтым после нажатия");
    }

    @Step("Проверить, что открылись ссылки Еще по теме и отображаются документы")
    public void checkMoreLinksBlockIsOpened() {
        WebElement moreLinksBlock = findElementByNoThrow(By.id("infobar-links"));
        postponedAssertTrue(moreLinksBlock != null && moreLinksBlock.isDisplayed(), "Блок Еще по теме не отображается");
        List<WebElement> links = findElementsByNoThrow(By.cssSelector("#infobar-links .doc-info__in a[href*='document']"));
        postponedAssertTrue(links != null && !links.isEmpty(), "В блоке Еще по теме не найдено ни одной ссылки на документы");
    }

    @Step("Проверить, что отображается заголовок Ссылки в блоке Еще по теме")
    public void checkMoreLinksHasTitleLinks() {
        String requiredTitle = "Ссылки";
        List<WebElement> h3Tags = findElementsByNoThrow(By.cssSelector("#infobar-links h3"));
        if (h3Tags != null && !h3Tags.isEmpty()) {
            for (WebElement h3 : h3Tags) {
                if (h3.getText().trim().equals(requiredTitle)) {
                    return;
                }
            }
        } else {
            setPostponedTestFail("Ни один заголовок не найден в блоке Еще по теме");
        }
    }

    @Step("Нажать на случайную ссылку из блока Еще по теме")
    public void clickOnMoreLinksRandomLink() {
        List<WebElement> links = findElementsByNoThrow(By.cssSelector("#infobar-links .doc-info__in a[href*='document']"));
        if (links != null && !links.isEmpty()) {
            WebElement randomLink = getRandomElementInList(links);
            setParameter(SearchResultHelper.DOCUMENT_URL, randomLink.getAttribute("href"));
            randomLink.click();
            waitForReloadingPage();
        } else {
            setPostponedTestFail("Не найдено ни одной ссылки в блоке Еще по теме");
        }
    }

    @Step("Проверить, что Список документов из инфо-бара Еще по теме дублируется внизу документа в блоке Ссылки/Упоминания")
    public void checkMoreLinksAreDuplicatedBelowOfTheDocument() {
        List<WebElement> moreLinksBlock = findElementsByNoThrow(By.cssSelector("#infobar-links .doc-info__in a[href*='document']"));
        List<WebElement> moreLinksBelowDocument = findElementsByNoThrow(By.cssSelector("#infobar-bottom a[href*='document']"));

        postponedAssertEquals(moreLinksBlock.size(), moreLinksBelowDocument.size(), "Разное количество документов в Еще по теме и Внизу документа. Проверка на дублирование остановлена.");
        if (moreLinksBelowDocument.size() == moreLinksBlock.size()) {
            List<String> blockNameList = getTextListFromWebElementList(moreLinksBlock);
            List<String> belowDocumentNameList = getTextListFromWebElementList(moreLinksBelowDocument);
            postponedAssertEquals(blockNameList, belowDocumentNameList, "Ссылки не идентичны");
        }
    }

    @Step("Нажать на случайную ссылку из инфобара Ссылки внизу документа")
    public void clickOnLinksFromInfobarInBottom() {
        List<WebElement> moreLinksBelowDocument = findElementsByNoThrow(By.cssSelector("#infobar-bottom a[href*='document']"));
        WebElement randomLink = getRandomElementInList(moreLinksBelowDocument);
        setParameter(SearchResultHelper.DOCUMENT_URL, randomLink.getAttribute("href"));
        randomLink.click();
        waitForReloadingPage();
    }

    @Step("Проверяется, что быстрое оглавление отображается")
    public void checkQuickTocIsPresent() {
        WebElement sidebar = sidebarElement;
        postponedAssertTrue(sidebar != null && sidebar.isDisplayed(), "Быстрое оглавление не отображается");
    }

    @Step("Проверяется, что в быстром оглавлении отображаются цифры")
    public void checkQuickTocHasNumbers() {
        List<WebElement> items = findElementsByNoThrow(sidebarElement, By.cssSelector(".list__item"));

        //items contain two last items: Links and References, subtract these items from the list
        if (items.size() > 2) {
            items = items.subList(0, items.size() - 2); //without Links and References
        } else {
            setPostponedTestFail("Не найдены элементы в быстром оглавлении или элементов всего два");
            return;
        }

        for (WebElement item : items) {
            String itemText = item.getText();
            itemText = itemText.replace("Статья", "").replace("Глава", "").trim();
            postponedAssertTrue(NumberUtils.isNumber(itemText), "Увы, в оглавлении найдены не только цифры:" + itemText);
        }
    }

    @Step("Проверяется, что в быстром оглавлении отсутствуют пункты Ссылки и Упоминания")
    public void checkQuickTocDoesNotContainItemsReferencesAndLinks() {
        boolean hasReferences = false;
        boolean hasLinks = false;
        List<WebElement> items = findElementsByNoThrow(sidebarElement, By.cssSelector(".list__item"));
        for (WebElement item : items) {
            String itemText = item.getText();
            if (itemText.contains("Ссылки")) {
                hasLinks = true;
            } else if (itemText.contains("Упоминания")) {
                hasReferences = true;
            }
        }
        postponedAssertFalse(hasLinks, "Быстрое оглавление содержит пункт Ссылки");
        postponedAssertFalse(hasReferences, "Быстрое оглавление содержит пункт Упоминания");
    }

    @Step("Нажать на кнопку История изменений")
    public void clickOnRevisionHistoryLink() {
        WebElement revisionHistory = findElementByNoThrow(By.cssSelector("[data-rel='infobar-changes']"));
        revisionHistory.click();
        waitForReloadingPage();
    }

    @Step("Проверить, что открылся блок История изменений (Список документов)")
    public void checkRevisionHistoryBlockIsOpened() {
        WebElement infobarChanges = findElementByNoThrow(By.id("infobar-changes"));
        postponedAssertTrue(infobarChanges != null && infobarChanges.isDisplayed(), "Список документов не открыт");
        if (infobarChanges != null) {
            List<WebElement> documents = findElementsByNoThrow(infobarChanges, By.cssSelector(".doc-info__in li a[href*='document']"));
            postponedAssertTrue(documents != null && !documents.isEmpty(), "Ни один документ не найден в истории изменений");
        }
    }

    @Step("Проверить, что отображается заголовок Особенности действия в инфобаре История изменений")
    public void checkRevisionHistoryTitleSpeciallyActionsIsPresent() {
        String requiredTitle = "Особенности действия";
        WebElement h3Tag = getWebElementWithRevisionHistoryRequiredTitleIntoH3Tag(requiredTitle);
        postponedAssertTrue(h3Tag != null && h3Tag.isDisplayed(), requiredTitle + " не найдены в инфобаре История изменений");
    }

    @Step("Проверить, что отображается заголовок В документе учтено в инфобаре История изменений")
    public void checkRevisionHistoryTitleContainsInDocumentIsPresent() {
        String requiredTitle = "В документе также учтено:";
        WebElement h3Tag = getWebElementWithRevisionHistoryRequiredTitleIntoH3Tag(requiredTitle);
        postponedAssertTrue(h3Tag != null && h3Tag.isDisplayed(), requiredTitle + " не найдены в инфобаре История изменений");
    }

    @Step("Открыть случайный документ из Истории изменений")
    public void clickOnRandomDocumentFromRevisionHistoryList() {
        List<WebElement> documents = findElementsByNoThrow(By.cssSelector("#infobar-changes .doc-info__in li a[href*='document']"));
        postponedAssertTrue(documents != null && !documents.isEmpty(), "Ни один документ не найден в истории изменений");
        WebElement randomDocument = getRandomElementInList(documents);
        setParameter(SearchResultHelper.DOCUMENT_URL, randomDocument.getAttribute("href"));
        randomDocument.click();
        waitForReloadingPage();
    }

    private WebElement getWebElementWithRevisionHistoryRequiredTitleIntoH3Tag(String requiredTitle) {
        List<WebElement> h3 = findElementsByNoThrow(By.cssSelector("#infobar-changes h3"));
        if (h3 == null && h3.isEmpty()) {
            setPostponedTestFail("Не найден ни один заголовок в инфобаре История изменений");
        } else {
            for (WebElement title : h3) {
                if (title.getText().trim().equals(requiredTitle)) {
                    return title;
                }
            }
        }
        return null;
    }

    @Step("Проверить, что Выделяется нужный регион в документе 117/21269: {0}")
    public void checkDocumentRegionYellowTipFor(String region) {
        WebElement table = findElementByNoThrow(By.cssSelector("table.bdAll"));
        postponedAssertNotNull(table, "Таблица с регионами не найдена");
        if (table == null) {
            return;
        }
        WebElement yellowTr = findElementByNoThrow(table, By.xpath(".//tr[@style]"));
        postponedAssertNotNull(yellowTr, "Не найден подкрашенный элемент в таблице");
        if (yellowTr == null) {
            return;
        }
        WebElement tdWithName = findElementByNoThrow(yellowTr, By.xpath(".//td[1]/span"));
        postponedAssertEqualsText(tdWithName, region);
    }


    @Step("Кликнуть на кнопку инфобара Приложения")
    public void clickOnInfobarApplicationsLink() {
        WebElement document = getDocumentHeader();
        WebElement infoBarWidget = findElementByNoThrow(document, By.cssSelector("[data-rel='infobar-attachment']"));
        if (infoBarWidget != null && infoBarWidget.isDisplayed()) {
            WebElement infoBarLink = infoBarWidget.findElement(By.tagName("a"));
            infoBarLink.click();
            waitForReloadingPage();
        } else {
            warning("Проверка не проводилась, так как виджета Приложения нет в документе");
        }
    }

    @Step("Проверяется, что под кнопкой Скачать шаблон присутствует ссылка Заполненный образец")
    public void checkDownloadShowExampleLinkIsPresent() {
        WebElement exampleLink = findElementByNoThrow(documentBody, By.cssSelector(".forms-download > p > a"));
        postponedAssertTrue(exampleLink != null && exampleLink.isDisplayed(),
                "Ссылка заполненный образец не присутствует под кнопкой Скачать шаблон");
    }

    @Step("Проверяется, что под кнопкой Скачать шаблон присутствует ссылка Заполненные примеры")
    public void checkDownloadShowExamplesLinkIsPresent() {
        WebElement exampleLink = findElementByNoThrow(documentBody, By.cssSelector(".forms-download .js-show-samples"));
        postponedAssertTrue(exampleLink != null && exampleLink.isDisplayed(),
                "Ссылка заполненный образец не присутствует под кнопкой Скачать шаблон");
    }

    @Step("Проверяется, что под кнопкой Скачать шаблон НЕ присутствует ссылка Заполненный образец")
    public void checkDownloadShowExampleLinkIsNotPresent() {
        WebElement exampleLink = findElementByNoThrow(documentBody, By.cssSelector(".forms-download .js-show-samples"));
        postponedAssertTrue(exampleLink == null || !exampleLink.isDisplayed(),
                "Ссылка заполненный образец присутствует под кнопкой Скачать шаблон");
    }

    @Step("Проверяется, что под кнопкой Скачать шаблон НЕ присутствует ссылка Заполненные примеры")
    public void checkDownloadShowExamplesLinkIsNotPresent() {
        WebElement exampleLink = findElementByNoThrow(documentBody, By.cssSelector(".forms-download .js-show-samples"));
        postponedAssertTrue(exampleLink == null || !exampleLink.isDisplayed(),
                "Ссылка заполненный образец присутствует под кнопкой Скачать шаблон");
    }

    @Step("Нажать на беклинк")
    public void clickReferencesByArticleAndParagraph(int chapterNumber, int articleNumber, int paragraphNumber) {
        for (WebElement docPart : findElementsBy(By.cssSelector(".doc-part"))) {
            scrollIntoView(docPart);
            waitForReloadingPage();
            for (WebElement article : findElementsBy(docPart, By.cssSelector(".doc__article"))) {
                scrollIntoView(article);
                waitForReloadingPage();
            }
            if (docPart.getText().contains("Глава " + chapterNumber)) {
                break;
            }
        }
        report("Открыть беклинк для 'Глава " + chapterNumber + "' 'Статья  " + articleNumber + "' 'Пункт " + paragraphNumber + "'");
        WebElement references = findElementByNoThrow(By.xpath("(//div[contains(@class,'doc__chapter') and @data-type='chapter'])[" + chapterNumber + "]/following-sibling::*[@class='doc__article'][" + articleNumber + "]/following-sibling::*[contains(@data-id,'')][" + paragraphNumber + "]//*[contains(@class,'btn_type_references')]"));
        assertNotNull(references, "Кнопка беклинков не найдена");
        report("Открыть беклинк с числом " + references.getText());
        references.click();
        waitForReloadingPage();
    }

    @Step("Нажать 'Все ...' в блокноте")
    public void clickAllAdditionalMaterialsButton() {
        WebElement searchAdditionalMaterialsButton = findElementByNoThrow(By.cssSelector("#references-body .list_content_lawpractice .list__item_viewtype_search a"));
        assertNotNull(searchAdditionalMaterialsButton, "Кнопка 'Все ...' не найдена");
        report("Урл для перехода - " + searchAdditionalMaterialsButton.getAttribute("href"));
        searchAdditionalMaterialsButton.click();
        waitForReloadingPage();
    }
}
