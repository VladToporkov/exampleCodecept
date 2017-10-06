package com.actionmedia.pages.bss;

import com.actionmedia.components.KBK;
import com.actionmedia.components.KbkTable;
import com.actionmedia.components.Link;
import com.actionmedia.components.info.AttachmentsInfobar;
import com.actionmedia.components.popups.NotepadPopup;
import com.actionmedia.pages.helpers.DocumentHelper;
import com.actionmedia.pages.interfaces.IDocumentPage;
import com.actionmedia.util.TestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 15.10.13
 * Time: 11:55
 */
@Component
public class BssDocumentPage extends BssBasePage<BssDocumentPage> implements IDocumentPage {

    public static final String KBK_TABLE = "kbk.table";
    public static final String ARTICLE_URL = "article.url";
    public static final String BOOK_NAME = "book.name";
    public static final String BROWSE_URL = "browse.url";
    public static final String NEXT_URL = "next.url";
    public static final String PREV_URL = "prev.url";
    public static final String LEFT_COUNT = "left.count";
    public static final String COMPLETE_COUNT = "complete.count";
    public static final String ACTIVE_DAY = "active.day";
    public static final String CURRENT_MONTH = "current.month";

    public BssDocumentPage checkPrintButtonIsPresent() {
        getHelper(DocumentHelper.class).checkPrintButtonIsPresent();
        return this;
    }

    public BssDocumentPage checkPrintButtonInKodeksIsPresent() {
        getHelper(DocumentHelper.class).checkPrintButtonInKodeksIsPresent();
        return this;
    }

    public BssDocumentPage checkWordButtonIsPresent() {
        getHelper(DocumentHelper.class).checkWordButtonIsPresent();
        return this;
    }

    public BssDocumentPage checkWordButtonInKodeksIsPresent() {
        getHelper(DocumentHelper.class).checkWordButtonInKodeksIsPresent();
        return this;
    }

    public BssDocumentPage checkMailButtonIsPresent() {
        getHelper(DocumentHelper.class).checkMailButtonIsPresent();
        return this;
    }

    public BssDocumentPage checkMailButtonInKodeksIsPresent() {
        getHelper(DocumentHelper.class).checkMailButtonInKodeksIsPresent();
        return this;
    }

    public BssDocumentPage checkMailButtonIsNotPresent() {
        getHelper(DocumentHelper.class).checkMailButtonIsNotPresent();
        return this;
    }

    public BssDocumentPage checkMailButtonInKodeksIsNotPresent() {
        getHelper(DocumentHelper.class).checkMailButtonInKodeksIsNotPresent();
        return this;
    }

    public BssDocumentPage checkMailFormIsPresent() {
        getHelper(DocumentHelper.class).checkMailFormIsPresent();
        return this;
    }

    public BssDocumentPage checkMailFormIsNotPresent() {
        getHelper(DocumentHelper.class).checkMailFormIsNotPresent();
        return this;
    }

    public BssDocumentPage inputEmailInMailForm(String email) {
        getHelper(DocumentHelper.class).inputEmailInMailForm(email);
        return this;
    }

    public BssDocumentPage clickSendInMailForm() {
        getHelper(DocumentHelper.class).clickSendInMailForm();
        return this;
    }

    public BssDocumentPage checkErrorMessageInMailForm(String expectedErrorMessaege) {
        getHelper(DocumentHelper.class).checkErrorMessageInMailForm(expectedErrorMessaege);
        return this;
    }

    public BssDocumentPage checkInCut() {
        getHelper(DocumentHelper.class).checkInCut();
        return this;
    }

    public BssDocumentPage checkInfoBarWidget() {
        getHelper(DocumentHelper.class).checkInfoBarWidget();
        return this;
    }

    public BssDocumentPage checkInfoBarWidgetWork() {
        getHelper(DocumentHelper.class).checkInfoBarWidgetWork();
        return this;
    }

    public BssDocumentPage checkChangeHistoryWidget() {
        getHelper(DocumentHelper.class).checkChangeHistoryWidget();
        return this;
    }

    public BssDocumentPage checkScrolling() {
        getHelper(DocumentHelper.class).checkScrolling();
        return this;
    }

    public BssDocumentPage checkStickyHeaderScrolling() {
        getHelper(DocumentHelper.class).checkStickyHeaderScrolling();
        return this;
    }

    public BssDocumentPage clickMailButton() {
        getHelper(DocumentHelper.class).clickMailButton();
        return this;
    }

    public BssDocumentPage clickMailButtonInKodeks() {
        getHelper(DocumentHelper.class).clickMailButtonInKodeks();
        return this;
    }

    public BssDocumentPage scrollAllDocument() {
        getHelper(DocumentHelper.class).scrollAllDocument();
        return this;
    }

    public BssDocumentPage checkTableOfContents() {
        getHelper(DocumentHelper.class).checkTableOfContents();
        return this;
    }

    public BssDocumentPage checkMetaTagsAndTableOfContents() {
        getHelper(DocumentHelper.class).checkMetaTagsAndTableOfContents();
        return this;
    }

    public BssDocumentPage checkMetaTagsAndSavedDataContent() {
        getHelper(DocumentHelper.class).checkMetaTagsAndSavedDataContent();
        return this;
    }

    public BssDocumentPage checkTableOfContentsForPlan() {
        getHelper(DocumentHelper.class).checkTableOfContentsForPlan();
        return this;
    }

    public BssDocumentPage checkReferencesForChapter() {
        getHelper(DocumentHelper.class).checkReferencesForChapter();
        return this;
    }

    public BssDocumentPage checkReferencesForArticle() {
        getHelper(DocumentHelper.class).checkReferencesForArticle();
        return this;
    }

    public BssDocumentPage checkReferencesForParagraph() {
        getHelper(DocumentHelper.class).checkReferencesForParagraph();
        return this;
    }

    public BssDocumentPage checkLinksFromNotebookForChapter() {
        getHelper(DocumentHelper.class).checkLinksFromNotebookForChapter();
        return this;
    }

    public BssDocumentPage checkLinksFromNotebookForArticle() {
        getHelper(DocumentHelper.class).checkLinksFromNotebookForArticle();
        return this;
    }

    public BssDocumentPage checkLinksFromNotebookForParagraph() {
        getHelper(DocumentHelper.class).checkLinksFromNotebookForParagraph();
        return this;
    }

    public BssDocumentPage checkEditLinksForChapter() {
        getHelper(DocumentHelper.class).checkEditLinksForChapter();
        return this;
    }

    public BssDocumentPage checkEditLinksForArticle() {
        getHelper(DocumentHelper.class).checkEditLinksForArticle();
        return this;
    }

    public BssDocumentPage checkEditLinksForParagraph() {
        getHelper(DocumentHelper.class).checkEditLinksForParagraph();
        return this;
    }

    public BssDocumentPage checkDownloadButtonIsPresent() {
        getHelper(DocumentHelper.class).checkDownloadButtonIsPresent();
        return this;
    }

    public BssDocumentPage checkDownloadExampleButtonIsPresent() {
        getHelper(DocumentHelper.class).checkDownloadExampleButtonIsPresent();
        return this;
    }

    public BssDocumentPage checkSoderIsPresent() {
        getHelper(DocumentHelper.class).checkSoderIsPresent();
        return this;
    }

    public BssDocumentPage checkFormsPreview() {
        getHelper(DocumentHelper.class).checkFormsPreview();
        return this;
    }

    public BssDocumentPage checkExpiredWarningIsPresent() {
        getHelper(DocumentHelper.class).checkExpiredWarningIsPresent();
        return this;
    }

    public BssDocumentPage checkExpiredWarningNOTLinkIsPresent() {
        getHelper(DocumentHelper.class).checkExpiredWarningNOTLinkIsPresent();
        return this;
    }

    public BssDocumentPage checkFutureWarningIsPresent() {
        getHelper(DocumentHelper.class).checkFutureWarningIsPresent();
        return this;
    }

    public BssDocumentPage checkActualVersionIsPresent() {
        getHelper(DocumentHelper.class).checkActualVersionIsPresent();
        return this;
    }

    public BssDocumentPage checkSearchInTextWidgetIsPresent() {
        getHelper(DocumentHelper.class).checkSearchInTextWidgetIsPresent();
        return this;
    }

    public BssDocumentPage checkDocumentSearchIsNotPresent() {
        getHelper(DocumentHelper.class).checkDocumentSearchIsNotPresent();
        return this;
    }

    public BssDocumentPage checkSearchInTextWidgetWork(boolean fullcheck) {
        getHelper(DocumentHelper.class).checkSearchInTextWidgetWork(fullcheck);
        return this;
    }

    public BssDocumentPage checkSearchInTextWithSeveralQueries(String[] queries) {
        getHelper(DocumentHelper.class).checkSearchInTextWithSeveralQueries(queries);
        return this;
    }

    public BssDocumentPage checkMyFavoritesRubricatorButtonIsPresent() {
        getHelper(DocumentHelper.class).checkMyFavoritesRubricatorButtonIsPresent();
        return this;
    }

    public BssDocumentPage checkAddToFavoritesButtonsForDocumentArePresent() {
        getHelper(DocumentHelper.class).checkAddToFavoritesButtonsForDocumentArePresent();
        return this;
    }

    public BssDocumentPage checkAddToFavoritesButtonForMagazinesIsPresent() {
        getHelper(DocumentHelper.class).checkAddToFavoritesButtonForMagazinesIsPresent();
        return this;
    }

    public BssDocumentPage checkAddToFavoritesButtonIsPresent() {
        getHelper(DocumentHelper.class).checkAddToFavoritesButtonIsPresent();
        return this;
    }

    public BssDocumentPage checkAddToFavoritesButtonIsHighlighted() {
        getHelper(DocumentHelper.class).checkAddToFavoritesButtonIsHighlighted();
        return this;
    }

    public BssDocumentPage checkAddToFavoritesButtonForMagazinesIsHighlighted() {
        getHelper(DocumentHelper.class).checkAddToFavoritesButtonForMagazinesIsHighlighted();
        return this;
    }

    public BssDocumentPage checkAddedItemIsPresentInMyFavoritesMenu() {
        getHelper(DocumentHelper.class).checkAddedItemIsPresentInMyFavoritesMenu();
        return this;
    }

    public BssSearchResultPage returnToSearchResultPage() {
        getHelper(DocumentHelper.class).returnToSearchResultPage();
        return redirectTo(BssSearchResultPage.class);
    }

    public BssDocumentPage clickRandomAddToFavoritesForKodeksButton() {
        getHelper(DocumentHelper.class).clickRandomAddToFavoritesForKodeksButton();
        return this;
    }

    public BssDocumentPage clickRandomAddToFavoritesForDocumentButton() {
        getHelper(DocumentHelper.class).clickRandomAddToFavoritesForDocumentButton();
        return this;
    }

    public BssDocumentPage clickRandomAddToFavoritesForMagazinesButton() {
        getHelper(DocumentHelper.class).clickRandomAddToFavoritesForMagazinesButton();
        return this;
    }

    public BssDocumentPage clickRandomAddToFavoritesButton() {
        getHelper(DocumentHelper.class).clickRandomAddToFavoritesButton();
        return this;
    }

    public BssDocumentPage checkContentIsPresent() {
        checkEmptyDocumentHeader();
        checkEmptyDocument();
        return this;
    }

    @Step("Проверяется что заголовок документа не пустой")
    public BssDocumentPage checkEmptyHeader() {
        checkEmptyDocumentHeader();
        return this;
    }

    @Step("")
    public BssDocumentPage parseKbk() {
        WebElement document = getDocumentBody();
        WebElement table = document.findElement(By.cssSelector(".bdAll"));
        KBK kbk = new KBK(table);

        setParameterForGroup(KBK_TABLE, kbk);
        return this;
    }

    @Step("")
    public BssDocumentPage clickFirstTab() {
        WebElement document = getDocumentBody();
        WebElement tab = document.findElements(By.cssSelector(".kbk-tabs-item")).get(0);
        tab.click();
        return this;
    }

    @Step("")
    public BssDocumentPage clickSecondtTab() {
        WebElement document = getDocumentBody();
        WebElement tab = document.findElements(By.cssSelector(".kbk-tabs-item")).get(1);
        tab.click();
        return this;
    }

    @Step("Проверяется КБК сервис")
    public BssDocumentPage checkKBKService() {
        KBK kbk = (KBK) getParameterForGroup(KBK_TABLE);
        WebElement document = getDocumentBody();
        WebElement sectionDropDown = document.findElement(By.name("taxType"));
        List<WebElement> sectionOptions = sectionDropDown.findElements(By.tagName("option"));
        for (int i = 1; i < sectionOptions.size(); i++) {
            WebElement option = sectionOptions.get(i);
            String sectionName = option.getText();
            report("Выбираем '" + sectionName + "' в Виде платежа");
            sectionDropDown.sendKeys(option.getText());

            findElementBy(By.cssSelector(".estimator-form-row")).sendKeys(Keys.ENTER);
            findElementBy(By.cssSelector(".estimator-form-row")).sendKeys(Keys.ENTER);

            waitFewSecond(1000);

            List<WebElement> radioButtons = waitForPresenceOfAllElementsLocatedBy(By.name("ndfl-type"));
            for (WebElement radioButton : radioButtons) {
                String id = radioButton.getAttribute("id");
                String payName = findElementBy(By.cssSelector("[for='" + id + "']")).getText();
                report("Выбираем '" + payName + "' в Наименование платежа");
                radioButton.click();

                waitFewSecond(1000);

                WebElement payDropDown = document.findElement(By.name("payType"));
                List<WebElement> payOptions = payDropDown.findElements(By.tagName("option"));
                for (WebElement payOption : payOptions) {
                    String typeName = payOption.getText();
                    report("Выбираем '" + typeName + "' в Типе перечисления");
                    payDropDown.sendKeys(payOption.getText());

                    getParentElement(getParentElement(payDropDown)).sendKeys(Keys.ENTER);
                    getParentElement(getParentElement(payDropDown)).sendKeys(Keys.ENTER);

                    WebElement findBtn = findElementBy(By.cssSelector(".estimator-button"));
                    findBtn.click();

                    waitFewSecond(1000);

                    WebElement error = findElementBy(By.cssSelector(".estimator-form-errors"));

                    if (!error.getText().isEmpty()) {
                        setPostponedTestFail("Ошибка при получении КБК. " +
                                "Вид платежа - " + sectionName + ". " +
                                "Наименование платежа - " + payName + ". " +
                                "Тип платежа - " + typeName + ".");
                    }

                    WebElement printer = findElementBy(By.id("estimator-printer"));
                    waitForAttributeUpdate(printer, "class", "printing", true);

                    WebElement kbkElement = findElementBy(By.cssSelector(".estimator-bill-total-value"));

                    String actualKbk = kbkElement.getText().trim();

                    postponedAssertFalse(actualKbk.isEmpty(), "КБК не найден");

                    try {
                        if (!actualKbk.isEmpty()) {
                            KBK.Value value = kbk.getValueByKbk(actualKbk);

                            if (value.getSection().equals(sectionName)) {
                                success("Вид платежа для КБК '" + actualKbk + "' правильный");
                            } else {
                                error("Выбран неправильный вид платежа. " +
                                        "Ожидаемый: " + value.getSection() +
                                        " Наблюдаемый: " + sectionName);
//                            setPostponedTestFail("Выбран неправильный вид платежа");
                            }

                            if (value.getPaymentName().equals(payName)) {
                                success("Наименование платежа для КБК '" + actualKbk + "' правильный");
                            } else {
                                error("Выбран неправильный наименование платежа " +
                                        "Ожидаемый: " + value.getPaymentName() +
                                        " Наблюдаемый: " + payName);
//                            setPostponedTestFail("Выбран неправильный наименование платежа");
                            }

                            if (value.getType().replaceAll(" \\(", ", ").replaceAll("\\)", "").contains(typeName)) {
                                success("Тип перечисления для КБК '" + actualKbk + "' правильный");
                            } else {
                                error("Выбран неправильный тип перечисления " +
                                        "Ожидаемый: " + value.getType() +
                                        " Наблюдаемый: " + typeName);
//                            setPostponedTestFail("Выбран неправильный тип перечисления");
                            }
                        }

                        report("___________________________________________________________________\n");
                    } catch (NullPointerException e) {
                        logger.error("NullPointerException occurs", e);
                        error("КБК '" + actualKbk + "' не найден в таблице");
//                        setPostponedTestFail("КБК '" + actualKbk + "' не найден в таблице");
                    } catch (UndeclaredThrowableException e) {
                        logger.error("UndeclaredThrowableException occurs", e);
                        error("КБК '" + actualKbk + "' не найден в таблице");
//                        setPostponedTestFail("КБК '" + actualKbk + "' не найден в таблице");
                    }
                }
            }
        }
        return this;
    }

    @Step("")
    public BssDocumentPage checkKBKService(int sectionNumber) {
        KBK kbk = (KBK) getParameterForGroup(KBK_TABLE);
        WebElement document = getDocumentBody();
        WebElement sectionDropDown = document.findElement(By.name("taxType"));
        List<WebElement> sectionOptions = sectionDropDown.findElements(By.tagName("option"));

        WebElement option = sectionOptions.get(sectionNumber);
        sectionDropDown.sendKeys(option.getText());

        String sectionName = getWebElementWrapper(sectionDropDown).getSelect().getSelectedText();
        report("Выбран '" + sectionName + "' в Виде платежа");

        findElementBy(By.cssSelector(".estimator-form-row")).sendKeys(Keys.ENTER);
        findElementBy(By.cssSelector(".estimator-form-row")).sendKeys(Keys.ENTER);

        waitFewSecond(1000);

        List<WebElement> radioButtons = waitForPresenceOfAllElementsLocatedBy(By.name("ndfl-type"));
        for (WebElement radioButton : radioButtons) {
            String id = radioButton.getAttribute("id");
            String payName = findElementBy(By.cssSelector("[for='" + id + "']")).getText();
            report("Выбираем '" + payName + "' в Наименование платежа");
            radioButton.click();

            waitFewSecond(1000);

            WebElement payDropDown = document.findElement(By.name("payType"));
            List<WebElement> payOptions = payDropDown.findElements(By.tagName("option"));
            for (WebElement payOption : payOptions) {
                payDropDown.sendKeys(payOption.getText());

                getParentElement(getParentElement(payDropDown)).sendKeys(Keys.ENTER);
                getParentElement(getParentElement(payDropDown)).sendKeys(Keys.ENTER);

                String typeName = getWebElementWrapper(payDropDown).getSelect().getSelectedText();
                report("Выбираем '" + typeName + "' в Типе перечисления");

                WebElement findBtn = findElementBy(By.cssSelector(".estimator-button"));
                findBtn.click();

                waitFewSecond(1000);

                WebElement error = findElementBy(By.cssSelector(".estimator-form-errors"));

                if (!error.getText().isEmpty()) {
                    setPostponedTestFail("Ошибка при получении КБК. " +
                            "Вид платежа - " + sectionName + ". " +
                            "Наименование платежа - " + payName + ". " +
                            "Тип платежа - " + typeName + ".");
                }

                WebElement printer = findElementBy(By.id("estimator-printer"));
                waitForAttributeUpdate(printer, "class", "printing", true);

                WebElement kbkElement = findElementBy(By.cssSelector(".estimator-bill-total-value"));

                String actualKbk = kbkElement.getText().trim();

                postponedAssertFalse(actualKbk.isEmpty(), "КБК не найден");

                try {
                    if (!actualKbk.isEmpty()) {
                        KBK.Value value = kbk.getValueByKbk(actualKbk);

                        if (value.getSection().equals(sectionName) || value.getSection().contains(sectionName)) {
                            success("Вид платежа для КБК '" + actualKbk + "' правильный");
                        } else {
                            error("Неправильный Вид платежа. " +
                                    "Ожидаемый: " + value.getSection() +
                                    " Наблюдаемый: " + sectionName);
                            setPostponedTestFail("Неправильный Вид платежа");
                        }

                        if (value.getPaymentName().equals(payName) || value.getPaymentName().contains(payName)) {
                            success("Наименование платежа для КБК '" + actualKbk + "' правильное");
                        } else {
                            error("Неправильное наименование платежа " +
                                    "Ожидаемый: " + value.getPaymentName() +
                                    " Наблюдаемый: " + payName);
                            setPostponedTestFail("Неправильное наименование платежа");
                        }

                        if (value.getType().replaceAll(" \\(", ", ").replaceAll("\\)", "").contains(typeName)) {
                            success("Тип перечисления для КБК '" + actualKbk + "' правильный");
                        } else {
                            error("Неправильный тип перечисления " +
                                    "Ожидаемый: " + value.getType() +
                                    " Наблюдаемый: КБК для перечисления " + typeName);
                            setPostponedTestFail("Неправильный тип перечисления");
                        }
                    }

                    report("___________________________________________________________________\n");
                } catch (NullPointerException e) {
                    logger.error("NullPointerException occurs", e);
                    error("КБК '" + actualKbk + "' не найден в таблице");
                    setPostponedTestFail("КБК '" + actualKbk + "' не найден в таблице");
                } catch (UndeclaredThrowableException e) {
                    logger.error("NullPointerException occurs", e);
                    error("КБК '" + actualKbk + "' не найден в таблице");
                    setPostponedTestFail("КБК '" + actualKbk + "' не найден в таблице");
                }
            }
        }
        return this;
    }

    public BssDocumentPage checkKBKFoundService() {
        KBK kbk = (KBK) getParameter(KBK_TABLE);

        for (KBK.PaymentName paymentName : kbk.getPaymentNameList()) {
            for (KBK.PaymentType paymentType : paymentName.getPaymentTypeList()) {
                WebElement kbkField = waitForPresenceOfElementLocatedBy(By.name("kbkValue"));
                WebElement fndBtn = waitForPresenceOfElementLocatedBy(By.cssSelector(".estimator-button"));

                report("Проверется назначение платежа для КБК '" + paymentType.getKbk() + "'");
                kbkField.sendKeys(paymentType.getKbk());
                fndBtn.click();

                WebElement payNameElement = waitForPresenceOfElementLocatedBy(By.cssSelector(".estimator-bill-total-value"));
                String payName = payNameElement.getText();
                postponedAssertFalse(payName.isEmpty(), "Назначение платежа пустое");

                if (paymentName.getName().equals(payName)) {
                    success("Назначение платежа правильное");
                } else {
                    error("Назначение платежа неправильное");
                    setPostponedTestFail("Назначение платежа неправильное");
                }
            }
        }
        return this;
    }

    public BssDocumentPage checkKBK(List<KbkTable> kbkList) {
        WebElement document = getDocumentBody();
        WebElement sectionDropDown = document.findElement(By.name("taxType"));
        List<WebElement> sectionOptions = sectionDropDown.findElements(By.tagName("option"));

        List<String> actualCodeList = new ArrayList<String>();
        for (int i = 1; i < sectionOptions.size(); i++) {
            String sectionName = sectionOptions.get(i).getText();
            sectionDropDown.sendKeys(sectionName);
            sectionOptions.get(i).click();

            findElementBy(By.cssSelector(".estimator-form-row")).sendKeys(Keys.ENTER);
            findElementBy(By.cssSelector(".estimator-form-row")).sendKeys(Keys.ENTER);

            waitFewSecond(3000);

            WebElement idListElement = waitForVisibilityOfElementLocatedBy(By.cssSelector(".estimator-form-radios"));
            List<WebElement> radioButtonList = idListElement.findElements(By.tagName("input"));

            for (WebElement radioButton : radioButtonList) {
                int id = Integer.parseInt(radioButton.getAttribute("value"));

                List<KbkTable> kbkTableListWithId = getKbkById(kbkList, id);

                radioButton.click();

                waitFewSecond(3000);

                if (kbkTableListWithId.size() == 1) {
                    WebElement submit = waitForVisibilityOfElementLocatedBy(By.cssSelector(".estimator-button"));

                    submit.click();
                    submit.click();

                    waitFewSecond(3000);

                    WebElement valueElement = waitForVisibilityOfElementLocatedBy(By.cssSelector(".estimator-bill-total-value"));
                    String actualValue = valueElement.getText();
                    String expectedValue = getKbkCodeByPayType(kbkTableListWithId, "tax");

                    actualCodeList.add(actualValue);
                    postponedAssertEquals(actualValue, expectedValue, "Неправильный код КБК для ид = " + id + ", перечисление = обязательный платеж");
                } else {
                    WebElement payTypeElement = waitForVisibilityOfElementLocatedBy(By.name("payType"));

                    waitFewSecond(3000);

                    List<WebElement> payOptionsList = payTypeElement.findElements(By.tagName("option"));

                    for (WebElement payOption : payOptionsList) {
                        String payType = payOption.getAttribute("value");

                        payTypeElement.sendKeys(payOption.getText());
                        payOption.click();

                        getParentElement(getParentElement(payTypeElement)).sendKeys(Keys.ENTER);
                        getParentElement(getParentElement(payTypeElement)).sendKeys(Keys.ENTER);

                        waitFewSecond(3000);

                        WebElement submit = waitForVisibilityOfElementLocatedBy(By.cssSelector(".estimator-button"));

                        submit.click();
                        submit.click();

                        waitFewSecond(3000);

                        WebElement valueElement = waitForVisibilityOfElementLocatedBy(By.cssSelector(".estimator-bill-total-value"));
                        String actualValue = valueElement.getText();
                        String expectedValue = getKbkCodeByPayType(kbkTableListWithId, payType);

                        actualCodeList.add(actualValue);
                        postponedAssertEquals(actualValue, expectedValue, "Неправильный код КБК для ид = " + id + ", перечисление = " + payOption.getText());
                    }
                }
            }
        }
        postponedAssertEquals(actualCodeList.size(), kbkList.size(), "Не все коды были проверены");

        for (KbkTable kbk : kbkList) {
            String expectedCode = kbk.getCode();
            if (!actualCodeList.contains(expectedCode)) {
                setPostponedTestFail("Код '" + expectedCode + "' не был проверен");
            }
        }
        return this;
    }

    private List<KbkTable> getKbkById(List<KbkTable> kbkTableList, int id) {
        List<KbkTable> kbkTableListWithId = new ArrayList<KbkTable>();

        for (KbkTable kbkTable : kbkTableList) {
            if (kbkTable.getIdPayment() == id) {
                kbkTableListWithId.add(kbkTable);
            }
        }
        return kbkTableListWithId;
    }

    private String getKbkCodeByPayType(List<KbkTable> kbkTableList, String payType) {
        String codeWithType = "";
        for (KbkTable kbkTable : kbkTableList) {
            if (payType.equals("tax")) {
                if (kbkTable.isTax()) {
                    codeWithType = kbkTable.getCode();
                }
            }
            if (payType.equals("penalties")) {
                if (kbkTable.isPenalties()) {
                    codeWithType = kbkTable.getCode();
                }
            }
            if (payType.equals("fine")) {
                if (kbkTable.isFine()) {
                    codeWithType = kbkTable.getCode();
                }
            }
        }

        return codeWithType;
    }

    @Step("Проверяется что картинка с книгой отображается в содержании книги")
    public BssDocumentPage checkBookImageIsPresent() {
        WebElement image = findElementByNoThrow(mainContentElement, By.cssSelector(".description-image"));
        postponedAssertNotNull(image, "Картинка в содержании книги не найдена");
        if (image != null) {
            postponedAssertTrue(image.isDisplayed(), "Картинка в содержании книги не отображается");
            postponedAssertTrue(isImageLoaded(image.findElement(By.tagName("img"))), "Картинка в содержании книги не загрузилась");
        }
        return this;
    }

    @Step("Проверяется что список статей отображается в содержании")
    public BssDocumentPage checkArticleListIsPresent() {
        List<WebElement> chapterList = mainContentElement.findElements(By.cssSelector(".description-list"));
        postponedAssertFalse(chapterList.isEmpty(), "В содержании книги Отсутствует список глав");
        if (!chapterList.isEmpty()) {
            List<WebElement> articleList = new ArrayList<WebElement>();
            for (WebElement chapter : chapterList) {
                articleList.addAll(chapter.findElements(By.tagName("a")));
            }
            postponedAssertFalse(articleList.isEmpty(), "В содержании книги Отсутствует список статей");
        }
        return this;
    }

    @Step("Проверяется название открытой статьи")
    public BssDocumentPage checkArticleWithNameIsOpened(String expectedArticleName) {
        WebElement articleNameElement = mainContentElement.findElement(By.tagName("h2"));
        postponedAssertEquals(articleNameElement.getText(), expectedArticleName, "Неправильное название открытой статьи");
        return this;
    }

    @Step("Проверяется что название книги отображается в открытой статье")
    public BssDocumentPage checkBookTitleIsPresentInArticle(String expectedBookName) {
        WebElement bookNameElement = findElementByNoThrow(mainContentElement, By.cssSelector(".caps"));
        postponedAssertNotNull(bookNameElement, "Название книги не найдено в открытой статье");
        if (bookNameElement != null) {
            postponedAssertTrue(bookNameElement.isDisplayed(), "Название книги не отображается в открытой статье");
            postponedAssertEquals(bookNameElement.getText().toLowerCase(), expectedBookName.toLowerCase(), "Неправильное название книги в открытой статье");
        }
        return this;
    }

    public BssDocumentPage checkTableOfContentsIsNotEmpty() {
        String bookUrl = String.valueOf(getParameter(BssMagazinesPage.DOCUMENT_URL));
        getHelper(DocumentHelper.class).checkTableOfContentsIsNotEmpty(bookUrl);
        return this;
    }

    public BssDocumentPage checkMagazineNameIsPresent() {
        getHelper(DocumentHelper.class).checkMagazineNameIsPresent();
        return this;
    }

    public BssDocumentPage checkMagazineNumberIsPresent() {
        getHelper(DocumentHelper.class).checkMagazineNumberIsPresent();
        return this;
    }

    public BssDocumentPage checkDocumentIsNotEmpty() {
        getHelper(DocumentHelper.class).checkDocumentIsNotEmpty();
        return this;
    }

    public BssDocumentPage checkDocumentContainsText(String expectedText) {
        getHelper(DocumentHelper.class).checkDocumentContainsText(expectedText);
        return this;
    }

    @Step("Проверяется что открыт документ с заданным названием")
    public BssDocumentPage checkDocumentWithNameIsOpened(String documentName) {
        WebElement document = waitForPresenceOfElementLocatedBy(By.id("document-body"));
        WebElement header = document.findElement(By.tagName("h1"));
        String actualDocumentName = header.getText();
        actualDocumentName = actualDocumentName.replaceAll("РФ", "Российской Федерации");
        postponedAssertTrue(actualDocumentName.contains(documentName), "Открыт неправильный документ");
        return this;
    }

    @Step("Проверяется врез в журнальной статье")
    public BssDocumentPage checkInCutInMagazinesArticle() {
        WebElement document = waitForPresenceOfElementLocatedBy(By.id("document-body"));
        WebElement inCut = findElementByNoThrow(document, By.cssSelector(".e-example"));
        if (inCut != null) {
            Dimension documentSize = document.getSize();
            Dimension inCutSize = inCut.getSize();

            postponedAssertTrue(documentSize.getHeight() > inCutSize.getHeight(), "Высота вреза больше высоты документа");
            postponedAssertTrue(documentSize.getWidth() > inCutSize.getWidth(), "Ширина вреза больше ширина документа");
        } else {
            setPostponedTestFail("В документе Отсутствует врез");
        }
        return this;
    }

    @Step("Проверяется что открыта следующая статья")
    public BssDocumentPage checkNextPageIsOpened() {
        WebElement body = waitForPresenceOfElementLocatedBy(By.id("document-body"));
        String currentUrl = getCurrentUrl().split("\\?")[0];
        postponedAssertFalse(body.getText().isEmpty(), "Документ не найден: <a href=" + currentUrl + ">" + currentUrl + "</a>\n");

        String nextUrl = String.valueOf(getParameter(NEXT_URL));
        postponedAssertEquals(currentUrl, nextUrl, "Страница следующей статьи не открыта");
        return this;
    }

    @Step("Проверяется что открыта предыдущая статья")
    public BssDocumentPage checkPrevPageIsOpened() {
        WebElement body = waitForPresenceOfElementLocatedBy(By.id("document-body"));
        String currentUrl = getCurrentUrl().split("\\?")[0];
        postponedAssertFalse(body.getText().isEmpty(), "Документ не найден: " + currentUrl);

        String prevUrl = String.valueOf(getParameter(PREV_URL));
        postponedAssertEquals(currentUrl, prevUrl, "Страница предыдущей статьи не открыта");
        return this;
    }

    @Step("Проверяется что верхняя кнопка 'Вперед' Отсутствует")
    public BssDocumentPage checkNextButtonInTopIsAbsent() {
        WebElement header;
        WebElement nextButtonTop;

        if (findElementByNoThrow(mainLeftElement, By.cssSelector(".e-pages")) != null) {
            header = findElementByNoThrow(mainLeftElement, By.cssSelector(".e-pages"));
            nextButtonTop = findElementByNoThrow(header, By.cssSelector(".e-next"));
            postponedAssertNull(nextButtonTop, "Кнопка 'Вперед' в верхнем правом углу отображается на последней странице");
        } else {
            getHelper(DocumentHelper.class).checkButtonNextInTopMenuIsNotPresent();
        }
        return this;
    }

    @Step("Проверяется что нижняя кнопка 'Вперед' Отсутствует")
    public BssDocumentPage checkNextButtonInBottomIsAbsent() {
        WebElement footer;
        WebElement nextButtonBottom;

        if (findElementByNoThrow(mainLeftElement, By.cssSelector(".e-under")) != null) {
            footer = mainLeftElement.findElement(By.cssSelector(".e-under"));
            nextButtonBottom = findElementByNoThrow(footer, By.cssSelector(".e-next"));
            postponedAssertNull(nextButtonBottom, "Кнопка 'Вперед' в нижнем правом углу отображается на последней странице");
        } else {
            getHelper(DocumentHelper.class).checkButtonNextInBottomMenuIsNotPresent();
        }
        return this;
    }

    @Step("Проверяется что верхняя кнопка 'Назад' Отсутствует")
    public BssDocumentPage checkPrevButtonInTopIsAbsent() {
        WebElement header;
        WebElement prevButtonTop;

        if (findElementByNoThrow(mainLeftElement, By.cssSelector(".e-pages")) != null) {
            header = findElementByNoThrow(mainLeftElement, By.cssSelector(".e-pages"));
            prevButtonTop = findElementByNoThrow(header, By.cssSelector(".e-prev"));
            postponedAssertNull(prevButtonTop, "Кнопка 'Назад' в верхнем правом углу отображается на первой странице");
        } else {
            getHelper(DocumentHelper.class).checkButtonPreviousInTopMenuIsNotPresent();
        }
        return this;
    }

    @Step("Проверяется что нижняя кнопка 'Назад' Отсутствует")
    public BssDocumentPage checkPrevButtonInBottomIsAbsent() {
        WebElement footer;
        WebElement prevButtonBottom;

        if (findElementByNoThrow(mainLeftElement, By.cssSelector(".e-under")) != null) {
            footer = mainLeftElement.findElement(By.cssSelector(".e-under"));
            prevButtonBottom = findElementByNoThrow(footer, By.cssSelector(".e-prev"));
            postponedAssertNull(prevButtonBottom, "Кнопка 'Назад' в нижнем левом углу отображается на первой странице");
        } else {
            getHelper(DocumentHelper.class).checkButtonPreviousInBottomMenuIsNotPresent();
        }
        return this;
    }

    @Step("Проверяется работа кнопки 'Полистать'")
    public BssDocumentPage checkBrowserButton() {
        WebElement header = mainContentElement.findElement(By.cssSelector(".e-header"));
        WebElement browseButton = findElementByNoThrow(header, By.cssSelector(".browse"));

        if (browseButton != null) {
            String magUrl = String.valueOf(getParameter(BssMagazinesPage.DOCUMENT_URL)).split("document")[1];

            String browseUrl = browseButton.getAttribute("href");
//            BrowserMobProxy proxyServer = SeleniumHolder.getServer();
//            proxyServer.newHar(browseUrl);
            openUrl(browseUrl, false);

            String currentUrl = getCurrentUrl();
            postponedAssertTrue(currentUrl.contains(magUrl), "'Листалка' открыта не для текущего журнала");

//            Har har = proxyServer.getHar();
//            List<HarEntry> harEntryList = har.getLog().getEntries();
//            for (HarEntry harEntry : harEntryList) {
//                if (harEntry.getPageref().equals(browseUrl)) {
//                    int status = harEntry.getResponse().getStatus();
//                    String url = harEntry.getRequest().getUrl();
//                    if (status != -999 && status != -998) {
//                        if (!isCorrectResponseCode(status) && !url.contains("/survey/") && !url.contains("author-mask.png")) {
//                            setPostponedTestFail("Incorrect http status code: " + status + " url: <a href=" + url + ">" + url + "</a>\n");
//                        }
//                    }
//                }
//            }
            returnToBack();
        } else {
            setPostponedTestFail("Кнопка 'Полистать' не найдена");
        }
        return this;
    }

    @Step("Проверяется что отсутсвуют ошибки на форме рассчетчика")
    public BssDocumentPage checkErrorsAreNotPresent() {
        WebElement document = getDocumentBody();
        List<WebElement> errorList = document.findElements(By.cssSelector("[class*='error']"));
        List<WebElement> newErrorList = new ArrayList<WebElement>();
        for (WebElement error : errorList) {
            if (error.isDisplayed()) {
                newErrorList.add(error);
            }
            if (!error.getText().isEmpty()) {
                newErrorList.add(error);
            }
        }
        postponedAssertTrue(newErrorList.isEmpty(), "На форме рассчетчика присутсвуют ошибки");
        return this;
    }

    @Step("Проверяется что рассчитанный чек отображается")
    public BssDocumentPage checkBillIsPresent() {
        WebElement document = waitForPresenceOfElementLocatedBy(By.id("document-body"));
        WebElement bill = findElementByNoThrow(document, By.id("estimator-bill"));
        if (bill != null) {
            postponedAssertTrue(bill.isDisplayed(), "Рассчитанный чек не отображается");
            postponedAssertFalse(bill.getText().isEmpty(), "Рассчитанный чек пустой");
        } else {
            setPostponedTestFail("Рассчитанный чек не найден");
        }
        return this;
    }

    @Step("Проверяется что при переходе по шагам, закрашивается соответствующее количество Лепестков")
    public BssDocumentPage checkPetalsCountIsChanged() {
        WebElement flower = mainContentElement.findElement(By.id("wizards-flower"));
        if (flower.isDisplayed()) {
            List<WebElement> allPetals = flower.findElements(By.cssSelector("[id*='petal']"));
            List<WebElement> completePetals = new ArrayList<WebElement>();
            for (WebElement petal : allPetals) {
                if (petal.getAttribute("class").contains("visible")) {
                    completePetals.add(petal);
                }
            }

            String leftPetalsCountText = flower.findElement(By.id("need-answers")).getText();
            int leftPetalsCount = getNumberPetalsFromText(leftPetalsCountText);
            int completePetalsCount = completePetals.size();

            postponedAssertTrue(allPetals.size() - completePetalsCount == leftPetalsCount, "Количество закрашенных Лепестков не равну количеству пройденных шагов");
        }
        return this;
    }

    @Step("Проверяется работа ссылок из блока Правовая база/См.также")
    public BssDocumentPage checkLinksFromAdditionalBlock() {
        WebElement additionalBlock = findElementByNoThrow(mainContentElement, By.cssSelector(".document-chain-column"));
        if (additionalBlock != null) {
            List<WebElement> elementList = additionalBlock.findElements(By.cssSelector("[href*='/#/document']"));
            List<Link> linkList = new ArrayList<Link>();
            for (WebElement element : elementList) {
                String url = element.getAttribute("href");
                String header = element.getText();
                Link link = new Link(url, header);
                linkList.add(link);
            }
            if (linkList.size() > 3) {
                checkLinks(linkList, 3);
            } else {
                checkLinks(linkList);
            }
        } else {
            warning("Блок Правовая база/См.также не найден в документе. Проверка не проводилась.");
        }
        return this;
    }

    @Step("Проверяется что открыт заданный документ из рубрикатора избранного")
    public BssDocumentPage checkPreDefinedDocumentIsOpened() {
        waitForReloadingPage();
        String expectedUrl = String.valueOf(getParameter(BssBasePage.DOCUMENT_URL));
        String actualUrl = getCurrentUrl();
        postponedAssertTrue(actualUrl.contains(expectedUrl), "Заданный документ из рубрикатора избранного не открыт");
        return this;
    }

    @Step("Нажать стрелку 'Вперёд' в верхнем правом углу")
    public BssDocumentPage clickNextButtonInTop() {
        WebElement header;
        WebElement nextButton;

        if (findElementByNoThrow(mainLeftElement, By.cssSelector(".e-pages")) != null) {
            header = findElementByNoThrow(mainLeftElement, By.cssSelector(".e-pages"));
            nextButton = findElementByNoThrow(header, By.cssSelector(".e-next"));
        } else {
            header = findElementByNoThrow(mainLeftElement, By.cssSelector(".doc-pages"));
            nextButton = findElementByNoThrow(header, By.cssSelector(".forward"));
        }

        if (nextButton != null) {
            String nextUrl = nextButton.getAttribute("href");
            setParameter(NEXT_URL, nextUrl);
            nextButton.click();
        } else {
            warning("Стрелка 'Вперёд' в верхнем правом углу не найдена.");
        }
        waitForReloadingPage();
        return this;
    }

    @Step("Нажать стрелку 'Назад' в верхнем правом углу")
    public BssDocumentPage clickPrevButtonInTop() {
        WebElement header;
        WebElement prevButton;

        if (findElementByNoThrow(mainLeftElement, By.cssSelector(".e-pages")) != null) {
            header = findElementByNoThrow(mainLeftElement, By.cssSelector(".e-pages"));
            prevButton = findElementByNoThrow(header, By.cssSelector(".e-prev"));
        } else {
            header = findElementByNoThrow(mainLeftElement, By.cssSelector(".doc-pages"));
            prevButton = findElementByNoThrow(header, By.cssSelector(".backward"));
        }

        if (prevButton != null) {
            String prevUrl = prevButton.getAttribute("href");
            setParameter(PREV_URL, prevUrl);
            prevButton.click();
        } else {
            warning("Стрелка 'Назад' в верхнем правом углу не найдена.");
        }
        waitForReloadingPage();
        return this;
    }

    @Step("Нажать стрелку 'Вперёд' в правом нижнем углу")
    public BssDocumentPage clickNextButtonInBottom() {
        WebElement footer;
        WebElement nextButton;

        if (findElementByNoThrow(mainLeftElement, By.cssSelector(".e-under")) != null) {
            footer = mainLeftElement.findElement(By.cssSelector(".e-under"));
            nextButton = findElementByNoThrow(footer, By.cssSelector(".e-next"));
        } else {
            footer = mainLeftElement.findElement(By.id("document-footer"));
            nextButton = findElementByNoThrow(footer, By.cssSelector(".forward"));
        }

        if (nextButton != null) {
            WebElement nextLink = nextButton.findElement(By.tagName("a"));
            String nextUrl = nextLink.getAttribute("href");
            setParameter(NEXT_URL, nextUrl);
            nextLink.click();
        } else {
            warning("Стрелка 'Вперёд' в верхнем правом углу не найдена.");
        }
        return this;
    }

    @Step("Нажать стрелку 'Назад' в левом нижнем углу")
    public BssDocumentPage clickPrevButtonInBottom() {
        WebElement footer;
        WebElement prevButton;

        if (findElementByNoThrow(mainLeftElement, By.cssSelector(".e-under")) != null) {
            footer = mainLeftElement.findElement(By.cssSelector(".e-under"));
            prevButton = findElementByNoThrow(footer, By.cssSelector(".e-prev"));
        } else {
            footer = mainLeftElement.findElement(By.id("document-footer"));
            prevButton = findElementByNoThrow(footer, By.cssSelector(".backward"));
        }

        if (prevButton != null) {
            WebElement nextLink = prevButton.findElement(By.tagName("a"));
            String nextUrl = nextLink.getAttribute("href");
            setParameter(PREV_URL, nextUrl);
            nextLink.click();
        } else {
            warning("Стрелка 'Назад' в верхнем правом углу не найдена.");
        }
        return this;
    }

    public BssDocumentPage clickTableOfContentsButton() {
        getHelper(DocumentHelper.class).clickTableOfContentsButton();
        return this;
    }

    public BssDocumentPage clickRandomArticleFromMagazinesMainPage() {
        getHelper(DocumentHelper.class).clickRandomArticleFromMagazinesMainPage();
        return this;
    }

    public BssDocumentPage clickRandomArticleFromTableOfContents() {
        getHelper(DocumentHelper.class).clickRandomArticleFromTableOfContents();
        return this;
    }

    public BssDocumentPage clickRandomArticle() {
        getHelper(DocumentHelper.class).clickRandomArticle();
        return this;
    }

    @Step("Заполнить все поля в расчетчике")
    public BssDocumentPage inputAllFieldInCalculator() {
        WebElement document = waitForPresenceOfElementLocatedBy(By.id("document-body"));
        WebElement form = document.findElement(By.cssSelector(".estimator"));

        List<WebElement> dropDownList = form.findElements(By.tagName("select"));

        for (WebElement select : dropDownList) {
            if (dropDownList.indexOf(select) == 4) {
                continue;
            }
            if (select.getAttribute("disabled") != null || !select.isDisplayed()) {
                continue;
            }
            List<WebElement> typeValueList = select.findElements(By.tagName("option"));
            select.sendKeys(typeValueList.get(1).getText());
            waitForReloadingPage();
        }

        List<WebElement> numericFields = form.findElements(By.cssSelector("[type='text']"));
        List<WebElement> dateFields = form.findElements(By.cssSelector(".datepicker"));

        for (WebElement numericField : numericFields) {
            if (numericField.getAttribute("class").contains("date")) {
                continue;
            }
            if (!numericField.isDisplayed()) {
                continue;
            }
            numericField.sendKeys(RandomStringUtils.randomNumeric(3));
        }

        for (int i = 0; i < dateFields.size(); i++) {
            WebElement dateField = dateFields.get(i);
            String month = "0" + String.valueOf(i + 1);
            String date = "01." + month + ".2014";
            dateField.sendKeys(date);
        }
        return this;
    }

    @Step("Ввести мощность")
    public BssDocumentPage inputPower(String powerValue) {
        WebElement document = waitForPresenceOfElementLocatedBy(By.id("document-body"));
        WebElement powerInputField = document.findElement(By.id("power"));
        powerInputField.clear();
        powerInputField.sendKeys(powerValue);
        return this;
    }

    @Step("Ввести дату регистрации")
    public BssDocumentPage inputDateRegistration(String date) {
        WebElement document = waitForPresenceOfElementLocatedBy(By.id("document-body"));
        WebElement dateInputField = document.findElement(By.id("registerInPoliceDate"));
        dateInputField.clear();
        dateInputField.sendKeys(date);
        return this;
    }

    @Step("Нажать на кнопку рассчитать")
    public BssDocumentPage clickCalculateButton() {
        WebElement document = waitForPresenceOfElementLocatedBy(By.id("document-body"));
        WebElement printForm = document.findElement(By.id("estimator-printer"));
        WebElement calculateButton = printForm.findElement(By.cssSelector(".estimator-button"));
        calculateButton.click();
        waitForReloadingPage();
        return this;
    }

    @Step("Выбрать случайный вариант в мастере на первом шаге")
    public BssDocumentPage clickRandomQuestionInWizardOnStepOne() {
        clickRandomQuestionOnStepByNumber(1);
        return this;
    }

    @Step("Выбрать случайный вариант в мастере на втором шаге")
    public BssDocumentPage clickRandomQuestionInWizardOnStepTwo() {
        clickRandomQuestionOnStepByNumber(2);
        return this;
    }

    @Step("Выбрать случайный вариант в мастере на третьем шаге")
    public BssDocumentPage clickRandomQuestionInWizardOnStepThree() {
        clickRandomQuestionOnStepByNumber(3);
        return this;
    }

    @Step("Выбрать случайный вариант в мастере на четвертом шаге")
    public BssDocumentPage clickRandomQuestionInWizardOnStepFour() {
        clickRandomQuestionOnStepByNumber(4);
        return this;
    }

    @Step("Выбрать случайный вариант в мастере на пятом шаге")
    public BssDocumentPage clickRandomQuestionInWizardOnStepFive() {
        clickRandomQuestionOnStepByNumber(5);
        return this;
    }

    @Step("Выбрать случайный вариант в мастере на шестом шаге")
    public BssDocumentPage clickRandomQuestionInWizardOnStepSix() {
        clickRandomQuestionOnStepByNumber(6);
        return this;
    }

    @Step("Выбрать случайный вариант в мастере на седьмом шаге")
    public BssDocumentPage clickRandomQuestionInWizardOnStepSeven() {
        clickRandomQuestionOnStepByNumber(7);
        return this;
    }

    private void clickRandomQuestionOnStepByNumber(int stepNumber) {
        List<WebElement> wizardQuestionList = mainContentElement.findElements(By.cssSelector(".wizards-questions"));
        List<WebElement> visibleWizardsQuestions = new ArrayList<WebElement>();
        for (WebElement wizard : wizardQuestionList) {
            if (wizard.isDisplayed()) {
                visibleWizardsQuestions.add(wizard);
            }
        }
        if (visibleWizardsQuestions.size() > stepNumber - 1) {
            List<WebElement> questions = visibleWizardsQuestions.get(stepNumber - 1).findElements(By.tagName("li"));
            WebElement randomQuestion = getRandomElementInList(questions);
            report("Выбран вариант '" + randomQuestion.getText() + "'");
            randomQuestion.click();
            waitForReloadingPage();
        }
    }

    private int getNumberPetalsFromText(String textCount) {
        int count;
        if (textCount.contains("последний")) {
            count = 1;
        } else if (textCount.contains("двух")) {
            count = 2;
        } else if (textCount.contains("трёх")) {
            count = 3;
        } else if (textCount.contains("четырёх")) {
            count = 4;
        } else if (textCount.contains("пяти")) {
            count = 5;
        } else if (textCount.contains("шести")) {
            count = 6;
        } else if (textCount.contains("семи")) {
            count = 7;
        } else if (textCount.contains("восьми")) {
            count = 8;
        } else if (textCount.contains("девяти")) {
            count = 9;
        } else {
            count = 0;
        }
        return count;
    }

    @Step("Проверяется элементы на странице календаря")
    public BssDocumentPage checkCalendarPageDefaultState() {
        checkCurrentDateOnCalendarPage();
        checkCalendarDaysLinkIsPresent();
        checkWorkHoursLinkIsPresent();
        checkSelectTaxLinkIsPresent();
        checkNavigationLinksArePresent();
        checkTaskListOnCalendarPageIsPresent();
        return this;
    }

    @Step("Проверяется что в календаре присутсвует текущая дата")
    public BssDocumentPage checkCurrentDateOnCalendarPage() {
        WebElement currentPage = getCurrentCalendarPage();
        if (currentPage != null) {
            WebElement month = findElementByNoThrow(currentPage, By.id("monthName"));
            WebElement year = findElementByNoThrow(currentPage, By.id("year"));
            WebElement day = findElementByNoThrow(currentPage, By.cssSelector(".today"));
            postponedAssertNotNull(month, "На календаре Отсутствует текущий месяц");
            postponedAssertNotNull(year, "На календаре Отсутствует текущий год");
            postponedAssertNotNull(day, "На календаре Отсутствует текущая дата");
            if (month != null && year != null && day != null) {
                Date actual = TestUtils.parseDate(year.getText() + "-" + month.getText() + "-" + day.getText(), "yyyy-MMM-dd");
                Date currentDate = new Date();
                postponedAssertTrue(actual.getDay() == currentDate.getDay(), "Неправильный день недели");
                postponedAssertTrue(actual.getDate() == currentDate.getDate(), "Неправильный день месяца");
                postponedAssertTrue(actual.getMonth() == currentDate.getMonth(), "Неправильный месяц");
                postponedAssertTrue(actual.getYear() == currentDate.getYear(), "Неправильный год");
            }
        } else {
            setPostponedTestFail("На календаре не найден страница текущего месяца");
        }
        return this;
    }

    @Step("Проверяется что ссылка 'Календарные дни' отображается")
    public BssDocumentPage checkCalendarDaysLinkIsPresent() {
        WebElement currentPage = getCurrentCalendarPage();
        WebElement calendarDaysLink = findElementByNoThrow(currentPage, By.id("yearview-days-switch"));
        postponedAssertNotNull(calendarDaysLink, "Ссылка 'Календарные дни' не найдена на календаре");
        if (calendarDaysLink != null) {
            postponedAssertTrue(calendarDaysLink.isDisplayed(), "Ссылка 'Календарные дни' не отображается");
        }
        return this;
    }

    @Step("Проверяется что ссылка 'Рабочие часы' отображается")
    public BssDocumentPage checkWorkHoursLinkIsPresent() {
        WebElement currentPage = getCurrentCalendarPage();
        WebElement workHoursLink = findElementByNoThrow(currentPage, By.id("yearview-hours-switch"));
        postponedAssertNotNull(workHoursLink, "Ссылка 'Рабочие часы' не найдена на календаре");
        if (workHoursLink != null) {
            postponedAssertTrue(workHoursLink.isDisplayed(), "Ссылка 'Рабочие часы' не отображается");
        }
        return this;
    }

    @Step("Проверяется что ссылка 'Выбрать налоги' отображается")
    public BssDocumentPage checkSelectTaxLinkIsPresent() {
        WebElement currentPage = waitForVisibilityOfElementLocatedBy(By.cssSelector(".calendar__control"), "Ссылка 'Выбрать налоги' не найдена");
        WebElement selectTaxLink = findElementByNoThrow(currentPage, By.cssSelector(".js-toggle-filters"));
        postponedAssertNotNull(selectTaxLink, "Ссылка 'Выбрать налоги' не найдена на календаре");
        if (selectTaxLink != null) {
            postponedAssertTrue(selectTaxLink.isDisplayed(), "Ссылка 'Выбрать налоги' не отображается");
        }
        return this;
    }

    @Step("Проверяется что ссылки Предыдуший и Следующий месяц отображаются")
    public BssDocumentPage checkNavigationLinksArePresent() {
        WebElement currentPage = getCalendar();
        WebElement backLink = findElementByNoThrow(currentPage, By.id("back"));
        WebElement nextLink = findElementByNoThrow(currentPage, By.id("forward"));
        postponedAssertNotNull(backLink, "Ссылка 'Предыдущий месяц' не найдена на календаре");
        postponedAssertNotNull(nextLink, "Ссылка 'Следующий месяц' не найдена на календаре");
        if (backLink != null) {
            postponedAssertTrue(backLink.isDisplayed(), "Ссылка 'Предыдущий месяц' не отображается на календаре");
        }
        if (nextLink != null) {
            postponedAssertTrue(nextLink.isDisplayed(), "Ссылка 'Следующий месяц' не отображается на календаре");
        }
        return this;
    }

    @Step("Проверяется что таблица с датами отчетности отображается в календаре")
    public BssDocumentPage checkTaskListOnCalendarPageIsPresent() {
        WebElement taskTable = findElementByNoThrow(mainContentElement, By.id("task-block"));
        postponedAssertNotNull(taskTable, "Таблица с датами отчетности не найдена в календаре");
        if (taskTable != null) {
            List<WebElement> taskList = taskTable.findElements(By.cssSelector(".task"));
            postponedAssertFalse(taskList.isEmpty(), "Таблица с датами отчетности пустая");
        }
        return this;
    }

    @Step("Проверяется что список фильтров налогов отображается")
    public BssDocumentPage checkTaxFilterListIsPresent() {
        waitFewSecond(getTimeout() * 10);
        WebElement filterListBlock = findElementByNoThrow(mainContentElement, By.id("filters-block"));
        postponedAssertNotNull(filterListBlock, "Список фильтров налогов не найден");
        if (filterListBlock != null) {
            List<WebElement> filterList = filterListBlock.findElements(By.cssSelector(".list__text"));
            postponedAssertTrue(filterListBlock.isDisplayed(), "Список фильтров налогов не отображается");
            postponedAssertFalse(filterList.isEmpty(), "Список фильтров налогов пуст");
        }
        return this;
    }

    @Step("Проверяется что список фильтров налогов не отображается")
    public BssDocumentPage checkTaxFilterListIsNotPresent() {
        waitFewSecond(getTimeout() * 10);
        WebElement filterListBlock = findElementByNoThrow(mainContentElement, By.id("filters-block"));
        if (filterListBlock != null) {
            postponedAssertFalse(filterListBlock.isDisplayed(), "Список фильтров налогов отображается");
        }
        return this;
    }

    @Step("Проверяется что за выбранный день есть записи в таблице")
    public BssDocumentPage checkTaskTableForActiveDayIsPresent() {
        WebElement table = mainContentElement.findElement(By.id("task-block"));
        WebElement dayInTable = table.findElement(By.cssSelector(".day-title"));

        String expectedDay = String.valueOf(getParameter(ACTIVE_DAY));
        String actualDay = dayInTable.getText().split(" ")[0];
        postponedAssertEquals(actualDay, expectedDay, "За выбранный день нет записей в таблице");
        return this;
    }

    @Step("Проверяется что показана страница календаря за предыдущий месяц")
    public BssDocumentPage checkPrevMonthPageIsOpened() {
        int prevMonth = Integer.parseInt(String.valueOf(getParameter(CURRENT_MONTH)));

        WebElement currentMonthPage = getCurrentCalendarPage();
        int currentMonth = Integer.parseInt(currentMonthPage.getAttribute("data-month"));

        if (prevMonth == 1) {
            postponedAssertTrue(currentMonth == 12, "Календарь за предыдущий месяц не показан");
        } else {
            postponedAssertTrue(prevMonth - 1 == currentMonth, "Календарь за предыдущий месяц не показан");
        }
        return this;
    }

    @Step("Проверяется что показана страница календаря за следующий месяц")
    public BssDocumentPage checkNextMonthPageIsOpened() {
        int prevMonth = Integer.parseInt(String.valueOf(getParameter(CURRENT_MONTH)));

        WebElement currentMonthPage = getCurrentCalendarPage();
        int currentMonth = Integer.parseInt(currentMonthPage.getAttribute("data-month"));

        if (prevMonth == 12) {
            postponedAssertTrue(currentMonth == 1, "Календарь за следующий месяц не показан");
        } else {
            postponedAssertTrue(prevMonth + 1 == currentMonth, "Календарь за следующий месяц не показан");
        }
        return this;
    }

    @Step("Проверяется что открыта таблица за предыдущий месяц")
    public BssDocumentPage checkTaskTableForPrevMonthIsOpened() {
        int prevMonth = Integer.parseInt(String.valueOf(getParameter(CURRENT_MONTH)));

        WebElement taskTable = mainContentElement.findElement(By.id("task-block"));
        WebElement currentMonthTaskTable = taskTable.findElement(By.cssSelector(".current-month"));
        int currentMonth = Integer.parseInt(currentMonthTaskTable.getAttribute("data-month"));

        if (prevMonth == 1) {
            postponedAssertTrue(currentMonth == 12, "Таблица за предыдущий месяц не показана");
        } else {
            postponedAssertTrue(prevMonth - 1 == currentMonth, "Таблица за предыдущий месяц не показана");
        }
        return this;
    }

    @Step("Проверяется что открыта таблица за следующий месяц")
    public BssDocumentPage checkTaskTableForNextMonthIsOpened() {
        int prevMonth = Integer.parseInt(String.valueOf(getParameter(CURRENT_MONTH)));

        WebElement taskTable = mainContentElement.findElement(By.id("task-block"));
        WebElement currentMonthTaskTable = taskTable.findElement(By.cssSelector(".current-month"));
        int currentMonth = Integer.parseInt(currentMonthTaskTable.getAttribute("data-month"));

        if (prevMonth == 12) {
            postponedAssertTrue(currentMonth == 1, "Таблица за следующий месяц не показана");
        } else {
            postponedAssertTrue(prevMonth + 1 == currentMonth, "Таблица за следующий месяц не показана");
        }
        return this;
    }

    public BssDocumentPage checkEmptyDocumentStub() {
        getHelper(DocumentHelper.class).checkEmptyDocumentStub();
        return this;
    }

    public BssDocumentPage checkPublicationBlockIsNotPresent() {
        getHelper(DocumentHelper.class).checkPublicationBlockIsNotPresent();
        return this;
    }

    @Step("Нажать на ссылку 'Выбрать налоги'")
    public BssDocumentPage clickTaxFilterLinkInCalendar() {
        WebElement calendar = mainContentElement.findElement(By.cssSelector(".calendar__control"));
        WebElement taxFilterLink = calendar.findElement(By.cssSelector(".js-toggle-filters"));
        taxFilterLink.click();
        waitForReloadingPage();
        return this;
    }

    @Step("Выбрать в календаре случайный день")
    public BssDocumentPage clickRandomActiveDayInCalendar() {
        WebElement currentPage = getCurrentCalendarPage();
        if (currentPage != null) {
            List<WebElement> activeDayList = currentPage.findElements(By.cssSelector(".daylink"));
            WebElement randomActiveDay = getRandomElementInList(activeDayList);
            String day = randomActiveDay.getText();
            setParameter(ACTIVE_DAY, day);
            report("Выбрано '" + day + "' число в календаре");
            mouseClick(randomActiveDay);
            waitForReloadingPage();
        }
        return this;
    }

    @Step("Нажать на ссылку 'Следующий месяц'")
    public BssDocumentPage clickNextMonthButton() {
        WebElement currentMonthPage = getCurrentCalendarPage();
        String currentMonth = currentMonthPage.getAttribute("data-month");
        setParameter(CURRENT_MONTH, currentMonth);

        WebElement currentPage = getCalendar();
        WebElement nextLink = currentPage.findElement(By.id("forward"));
        nextLink.click();
        waitForReloadingPage();
        return this;
    }

    @Step("Нажать на ссылку 'Предыдущий месяц'")
    public BssDocumentPage clickPrevMonthButton() {
        WebElement currentMonthPage = getCurrentCalendarPage();
        String currentMonth = currentMonthPage.getAttribute("data-month");
        setParameter(CURRENT_MONTH, currentMonth);

        WebElement currentPage = getCalendar();
        WebElement backLink = currentPage.findElement(By.id("back"));
        backLink.click();
        waitForReloadingPage();
        return this;
    }

    @Step("Нажать на ссылку воврата к текущей дате")
    public BssDocumentPage clickGetToCurrentDayLink() {
        WebElement currentCalendarPage = getCurrentCalendarPage();
        WebElement returnLink = currentCalendarPage.findElement(By.id("rewind-month"));
        returnLink.click();
        waitForReloadingPage();
        return this;
    }

    public BssDocumentPage clickInformationLink() {
        getHelper(DocumentHelper.class).clickInformationLink();
        return this;
    }

    private WebElement getCurrentCalendarPage() {
        List<WebElement> pageList = mainContentElement.findElements(By.cssSelector(".b-calendar-center"));
        for (WebElement page : pageList) {
            if (page.isDisplayed()) {
                return page;
            }
        }
        return null;
    }

    private WebElement getDocumentBody() {
        return waitForVisibilityOfElementLocatedBy(By.id("document-body"), "Страница не найдена");
    }

    private WebElement getCalendar() {
        return waitForVisibilityOfElementLocatedBy(By.cssSelector(".calendar__in"), "Текущий месяц в календаре не найден");
    }

    public BssDocumentPage openAllIncuts() {
//        WebElement openAllIncutButton = mainContentElement.findElement(By.id("incuts-show-all"));
//        openAllIncutButton.click();
        List<WebElement> incutButtonList = mainContentElement.findElements(By.cssSelector(".incut-button"));
        for (WebElement incutButton : incutButtonList) {
            incutButton.click();
        }
        return this;
    }

    public BssDocumentPage takeScreenShot(String imageName, String folder) {
        getHelper(DocumentHelper.class).takeScreenShot(imageName, folder);
        return this;
    }

    public BssDocumentPage takeScreenShot(By locator, String imageName, String folder) {
        WebElement element = mainContentElement.findElement(locator);
        getHelper(DocumentHelper.class).takeScreenShot(element, imageName, folder);
        return this;
    }

    public BssDocumentPage checkBooksNameAndAuthor() {
        getHelper(DocumentHelper.class).checkBooksNameAndAuthor();
        return this;
    }

    public BssDocumentPage checkImageBook() {
        getHelper(DocumentHelper.class).checkImageBook();
        return this;
    }

    public BssDocumentPage checkNameDocument() {
        getHelper(DocumentHelper.class).checkNameDocument();
        return this;
    }

    public BssDocumentPage checkDisplayStars() {
        getHelper(DocumentHelper.class).checkDisplayStars();
        return this;
    }

    public BssDocumentPage checkDisplayStarsInDictionary() {
        getHelper(DocumentHelper.class).checkDisplayStarsInDictionary();
        return this;
    }

    public BssDocumentPage checkDisplayTextDocumentInParagraphs() {
        getHelper(DocumentHelper.class).checkDisplayTextDocumentInParagraphs();
        return this;
    }

    public BssDocumentPage checkInMyFavoritesIcon() {
        getHelper(DocumentHelper.class).checkInMyFavoritesIcon();
        return this;
    }

    public BssDocumentPage checkPrintIcon() {
        getHelper(DocumentHelper.class).checkPrintIcon();
        return this;
    }

    public BssDocumentPage checkBackwardIcon() {
        getHelper(DocumentHelper.class).checkBackwardIcon();
        return this;
    }

    public BssDocumentPage checkForwardIcon() {
        getHelper(DocumentHelper.class).checkForwardIcon();
        return this;
    }

    public BssDocumentPage checkBrowseIcon() {
        getHelper(DocumentHelper.class).checkBrowseIcon();
        return this;
    }

    public BssDocumentPage checkSoderButtonIsPresent() {
        getHelper(DocumentHelper.class).checkSoderButtonIsPresent();
        return this;
    }

    public BssDocumentPage checkShareIcon() {
        getHelper(DocumentHelper.class).checkShareIcon();
        return this;
    }

    public BssDocumentPage checkBooksName() {
        getHelper(DocumentHelper.class).checkBooksName();
        return this;
    }

    public BssDocumentPage checkAuthor() {
        getHelper(DocumentHelper.class).checkAuthor();
        return this;
    }

    public BssDocumentPage checkDisplayTableOfContents() {
        getHelper(DocumentHelper.class).checkDisplayTableOfContents();
        return this;
    }

    public BssDocumentPage checkDisplayTableOfContentsForKodeks() {
        getHelper(DocumentHelper.class).checkDisplayTableOfContentsForKodeks();
        return this;
    }

    public BssDocumentPage checkDisplayDescriptionList() {
        getHelper(DocumentHelper.class).checkDisplayDescriptionList();
        return this;
    }

    public BssDocumentPage checkDisplayNameJournal() {
        getHelper(DocumentHelper.class).checkDisplayNameJournal();
        return this;
    }

    public BssDocumentPage checkPudDateJournal() {
        getHelper(DocumentHelper.class).checkPudDateJournal();
        return this;
    }

    public BssDocumentPage checkArticleTitle() {
        getHelper(DocumentHelper.class).checkArticleTitle();
        return this;
    }

    public BssDocumentPage checkDocumentTitleIsPresent() {
        getHelper(DocumentHelper.class).checkDocumentTitleIsPresent();
        return this;
    }

    public BssDocumentPage checkRSSTitle(String Name) {
        getHelper(DocumentHelper.class).checkRSSTitle(Name);
        return this;
    }

    public BssDocumentPage checkDispalyTextInJournal() {
        getHelper(DocumentHelper.class).checkDisplayTextInJournal();
        return this;
    }

    public BssDocumentPage checkDisplayNameJournal_119() {
        getHelper(DocumentHelper.class).checkDisplayNameJournal_119();
        return this;
    }

    public BssDocumentPage checkArticleTitle_119() {
        getHelper(DocumentHelper.class).checkArticleTitle_119();
        return this;
    }

    public BssDocumentPage checkDisplayTextDocumentInParagraphs_119() {
        getHelper(DocumentHelper.class).checkDisplayNameJournal_119();
        return this;
    }

    public BssDocumentPage checkDisplayStarsSection() {
        getHelper(DocumentHelper.class).checkDisplayStarsSection();
        return this;
    }

    public BssDocumentPage checkDisplayNameJournal_192() {
        getHelper(DocumentHelper.class).checkDisplayNameJournal_192();
        return this;
    }

    public BssDocumentPage checkNumberJournal_192() {
        getHelper(DocumentHelper.class).checkNumberJournal_192();
        return this;
    }

    public BssDocumentPage checkDisplayTableOfContents_192() {
        getHelper(DocumentHelper.class).checkDisplayTableOfContents_192();
        return this;
    }

    public BssDocumentPage checkNameAndNumberJournal() {
        getHelper(DocumentHelper.class).checkNameAndNumberJournal();
        return this;
    }

    public BssDocumentPage checkSearchIn() {
        getHelper(DocumentHelper.class).checkSearchIn();
        return this;
    }

    public BssDocumentPage checkRevisionIsValidFrom() {
        getHelper(DocumentHelper.class).checkRevisionIsValidFrom();
        return this;
    }

    public BssDocumentPage checkMenu() {
        getHelper(DocumentHelper.class).checkMenu();
        return this;
    }

    public BssDocumentPage checkDisplayStarsTable() {
        getHelper(DocumentHelper.class).checkDisplayStarsTable();
        return this;
    }

    public BssDocumentPage checkNotPresentShareIcon() {
        getHelper(DocumentHelper.class).checkNotPresentShareIcon();
        return this;
    }

    public BssDocumentPage checkFastTableOfContents() {
        WebElement nav = findElementByNoThrow(By.id("sidebar"));
        if (nav != null) {
            List<WebElement> li = findElementsBy(nav, By.tagName("li"));
            postponedAssertTrue(li.size() > 0, "Нет элементов оглавения");
            for (WebElement text : li) {
                postponedAssertNotEquals(text.getText(), "", "Элемент оглавления не содержит текст");
            }
        } else setPostponedTestFail("Не найден элемент быстрого оглавления");

        return this;
    }

    public BssDocumentPage checkDisplayCover() {
        getHelper(DocumentHelper.class).checkDisplayCover();
        return this;
    }

    public BssDocumentPage checkFooter() {
        getHelper(DocumentHelper.class).checkFooter();
        return this;
    }

    public BssDocumentPage checkCommonView140() {
        getHelper(DocumentHelper.class).checkCommonView140();
        return this;
    }

    public BssDocumentPage checkAsNeedBlock() {
        getHelper(DocumentHelper.class).checkAsNeedBlock();
        return this;
    }

    public BssDocumentPage checkFormComments() {
        getHelper(DocumentHelper.class).checkFormComments();
        return this;
    }

    public BssDocumentPage checkCommonViewForms() {
        getHelper(DocumentHelper.class).checkCommonViewForms();
        return this;
    }

    public BssDocumentPage checkParentDocumentLinkIsPresent() {
        getHelper(DocumentHelper.class).checkParentDocumentLinkIsPresent();
        return this;
    }

    public BssDocumentPage checkParentDocumentLinkFormat(String expectedDocType) {
        getHelper(DocumentHelper.class).checkParentDocumentLinkFormat(expectedDocType);
        return this;
    }

    public BssDocumentPage checkParentDocumentLinkIsItalicStyle() {
        getHelper(DocumentHelper.class).checkParentDocumentLinkIsItalicStyle();
        return this;
    }

    public BssDocumentPage checkParentDocumentLinkInBottom() {
        getHelper(DocumentHelper.class).checkParentDocumentLinkInBottom();
        return this;
    }

    public BssDocumentPage clickParentDocumentLink() {
        getHelper(DocumentHelper.class).clickParentDocumentLink();
        return this;
    }

    public BssDocumentPage checkParentDocumentTitle() {
        getHelper(DocumentHelper.class).checkParentDocumentTitle();
        return this;
    }

    public BssDocumentPage checkDocumentIsOpened() {
        getHelper(DocumentHelper.class).checkDocumentIsOpened();
        return this;
    }

    @Override
    public BssDocumentPage checkDownloadShowExamplesLinkIsNotPresent() {
        getHelper(DocumentHelper.class).checkDownloadShowExamplesLinkIsNotPresent();
        return this;
    }

    @Override
    public BssDocumentPage checkDownloadShowExampleLinkIsNotPresent() {
        getHelper(DocumentHelper.class).checkDownloadShowExampleLinkIsNotPresent();
        return this;
    }

    @Override
    public BssDocumentPage checkCommonView118(String name) {
        getHelper(DocumentHelper.class).checkCommonView118(name);
        return this;
    }

    public BssDocumentPage checkWarningPanelIsLocatedAboveThanHeader() {
        getHelper(DocumentHelper.class).checkWarningPanelIsLocatedAboveThanHeader();
        return this;
    }

    public BssDocumentPage checkWarningPanelWidthIsEqualsBrowserWidth() {
        getHelper(DocumentHelper.class).checkWarningPanelWidthIsEqualsBrowserWidth();
        return this;
    }

    public BssDocumentPage checkWarningPanelIsRed() {
        getHelper(DocumentHelper.class).checkWarningPanelIsRed();
        return this;
    }

    public BssDocumentPage checkWarningPanelHasText(String text) {
        getHelper(DocumentHelper.class).checkWarningPanelHasText(text);
        return this;
    }

    public BssDocumentPage checkWarningPanelHasLink(String textLink) {
        getHelper(DocumentHelper.class).checkWarningPanelHasLink(textLink);
        return this;
    }

    public BssDocumentPage checkDocumentHasTitleWithoutBody() {
        getHelper(DocumentHelper.class).checkDocumentHasTitleWithoutBody();
        return this;
    }

    public BssDocumentPage checkTryTrialFormIsPresent() {
        getHelper(DocumentHelper.class).checkTryTrialFormIsPresent();
        return this;
    }

    public BssDocumentPage checkTryTrialFormHasText(String text) {
        getHelper(DocumentHelper.class).checkTryTrialFormHasText(text);
        return this;
    }

    public BssDocumentPage checkTryTrialForm() {
        getHelper(DocumentHelper.class).checkTryTrialForm();
        return this;
    }

    public BssDocumentPage checkTryTrialFormBSSLinkIsPresent() {
        getHelper(DocumentHelper.class).checkTryTrialFormBSSLinkIsPresent();
        return this;
    }

    public BssDocumentPage checkSubscribeActivationFormIsPresent() {
        getHelper(DocumentHelper.class).checkSubscribeActivateFormIsPresent();
        return this;
    }

    public BssDocumentPage checkSubscribeActivationFormHasText(String text) {
        getHelper(DocumentHelper.class).checkSubscribeActivationFormHasText(text);
        return this;
    }

    public BssDocumentPage checkSubscribeActivationFormCellPhoneNumberIsPresent() {
        getHelper(DocumentHelper.class).checkSubscribeActivationFormCellPhoneNumberIsPresent();
        return this;
    }

    public BssDocumentPage checkSubscribeActivationFormBSSLinkIsPresent() {
        getHelper(DocumentHelper.class).checkSubscribeActivationFormBSSLinkIsPresent();
        return this;
    }

    public BssDocumentPage checkArrowsInSearchInText(String query) {
        getHelper(DocumentHelper.class).checkArrowsInSearchInText(query);
        return this;
    }

    public BssDocumentPage checkDocumentSearchWithNoResult() {
        getHelper(DocumentHelper.class).checkDocumentSearchWithNoResult();
        return this;
    }

    public BssDocumentPage checkVersionsBlockForDictionaryDocumentIsPresent() {
        getHelper(DocumentHelper.class).checkVersionsBlockForDictionaryDocumentIsPresent();
        return this;
    }

    public BssDocumentPage checkOtherVersionsForDictionaryDocumentIsPresent() {
        getHelper(DocumentHelper.class).checkOtherVersionsForDictionaryDocumentIsPresent();
        return this;
    }

    public BssDocumentPage checkExpiredVersionsForDictionaryDocumentIsPresent() {
        getHelper(DocumentHelper.class).checkExpiredVersionsForDictionaryDocumentIsPresent();
        return this;
    }

    public BssDocumentPage clickDocumentInfobarLink() {
        getHelper(DocumentHelper.class).clickDocumentInfobarLink();
        return this;
    }

    public BssDocumentPage checkInfobarCardIsPresent() {
        getHelper(DocumentHelper.class).checkInfobarCardIsPresent();
        return this;
    }

    public BssDocumentPage checkInfobarBlocksLinks() {
        getHelper(DocumentHelper.class).checkInfobarBlocksLinks();
        return this;
    }

    public BssDocumentPage checkDocumentInfobarBottom() {
        getHelper(DocumentHelper.class).checkDocumentInfobarBottom();
        return this;
    }

    public BssDocumentPage checkTextDocumentEditionFrom() {
        getHelper(DocumentHelper.class).checkTextDocumentEditionFrom();
        return this;
    }

    public BssDocumentPage checkTextDocumentEditionFromInDocHeader() {
        getHelper(DocumentHelper.class).checkTextDocumentEditionFromInDocHeader();
        return this;
    }

    public BssDocumentPage checkTitleTag() {
        getHelper(DocumentHelper.class).checkTitleTag();
        return this;
    }

    public BssDocumentPage checkTitleAndAuthorInformationPresent() {
        getHelper(DocumentHelper.class).checkTitleAndAuthorInformationPresent();
        return this;
    }

    public BssDocumentPage checkProvodkiForDocument11_13565() {
        getHelper(DocumentHelper.class).checkProvodkiForDocument11_13565();
        return this;
    }

    public BssDocumentPage checkTransportTaxForDoc_11_14355() {
        getHelper(DocumentHelper.class).checkTransportTaxForDoc_11_14355();
        return this;
    }

    public BssDocumentPage checkCurrentItemIsHighlightedInTableOfContents() {
        getHelper(DocumentHelper.class).checkCurrentItemIsHighlightedInTableOfContents();
        return this;
    }

    public BssDocumentPage checkCurrentItemIsHighlightedInTableOfContentsForKodeks() {
        getHelper(DocumentHelper.class).checkCurrentItemIsHighlightedInTableOfContentsForKodeks();
        return this;
    }

    public BssDocumentPage checkTableOfContentsButtonIsPressed() {
        getHelper(DocumentHelper.class).checkTableOfContentsButtonIsPressed();
        return this;
    }

    public BssDocumentPage checkTableOfContentsButtonIsUnPressed() {
        getHelper(DocumentHelper.class).checkTableOfContentsButtonIsUnPressed();
        return this;
    }

    public BssDocumentPage clickDocumentHeader() {
        getHelper(DocumentHelper.class).clickDocumentHeader();
        return this;
    }

    public BssDocumentPage clickAboutBookButton() {
        getHelper(DocumentHelper.class).clickAboutBookButton();
        return this;
    }

    public BssDocumentPage checkAboutBookBlock() {
        getHelper(DocumentHelper.class).checkAboutBookBlock();
        return this;
    }

    public BssDocumentPage setBrowserSize(int width, int height) {
        getHelper(DocumentHelper.class).setBrowserSize(width, height);
        return this;
    }

    public BssDocumentPage checkSizeOfAboutBookBlockIsNotChanged() {
        getHelper(DocumentHelper.class).checkSizeOfAboutBookBlockIsNotChanged();
        return this;
    }

    public BssDocumentPage checkExtendedSearchButtonIsPresent() {
        getHelper(DocumentHelper.class).checkExtendedSearchButtonIsPresent();
        return this;
    }

    public BssDocumentPage checkHelpWidgetIsPresent() {
        getHelper(DocumentHelper.class).checkHelpWidgetIsPresent();
        return this;
    }

    @Step("Проверяется что кнопка 'Отправить' отображается")
    public BssDocumentPage checkSendButtonIsPresent() {
        WebElement header = getDocumentHeaderForMagazine();
        WebElement browserButton = findElementByNoThrow(header, By.cssSelector(".mail"));
        postponedAssertNotNull(browserButton, "Кнопка 'Отправить' не найдена");
        postponedAssertTrue(browserButton.isDisplayed(), "кнопка 'Отправить' не отображается");
        postponedAssertEquals(browserButton.getText(), "Отправить", "Неправильный текст кнопки 'Отправить'");
        return this;
    }

    @Step("Проверяется что кнопка 'Отправить' отображается")
    public BssDocumentPage checkSendButtonIsPresentForKodeks() {
        WebElement header = waitForPresenceOfElementLocatedBy(By.id("document-header"), "Заголовок документа не найден");
        WebElement browserButton = findElementByNoThrow(header, By.cssSelector(".ico_content_mail"));
        postponedAssertNotNull(browserButton, "Кнопка 'Отправить' не найдена");
        postponedAssertTrue(browserButton.isDisplayed(), "Кнопка 'Отправить' не отображается");
        return this;
    }

    public BssDocumentPage checkTableOfContentsButtonIsPresent() {
        getHelper(DocumentHelper.class).checkTableOfContentsButtonIsPresent();
        return this;
    }

    public BssDocumentPage checkCurrencyDocument() {
        getHelper(DocumentHelper.class).checkCurrencyDocument();
        return this;
    }

    public BssDocumentPage selectFirstCurrencyByCode(String code) {
        getHelper(DocumentHelper.class).selectFirstCurrencyByCode(code);
        return this;
    }

    public BssDocumentPage selectSecondCurrencyByCode(String code) {
        getHelper(DocumentHelper.class).selectSecondCurrencyByCode(code);
        return this;
    }

    public BssDocumentPage clickChangeCurrencyOrderButton() {
        getHelper(DocumentHelper.class).clickChangeCurrencyOrderButton();
        return this;
    }

    public BssDocumentPage checkFirstCurrencyLabel(String code) {
        getHelper(DocumentHelper.class).checkFirstCurrencyLabel(code);
        return this;
    }

    public BssDocumentPage checkSecondCurrencyLabel(String code) {
        getHelper(DocumentHelper.class).checkSecondCurrencyLabel(code);
        return this;
    }

    public BssDocumentPage checkTableCourseLabel(String codeFirstCurrency, String codeSecondCurrency) {
        getHelper(DocumentHelper.class).checkTableCourseLabel(codeFirstCurrency, codeSecondCurrency);
        return this;
    }

    public BssDocumentPage checkLastCourseTableIsChanged() {
        getHelper(DocumentHelper.class).checkLastCourseTableIsChanged();
        return this;
    }

    public BssDocumentPage setLastCourseTableToParameter() {
        getHelper(DocumentHelper.class).setLastCourseTableToParameter();
        return this;
    }

    private WebElement getDocumentHeaderForMagazine() {
        return waitForVisibilityOfElementLocatedBy(By.cssSelector(".e-header"), "Заголовок документ не найден");
    }

    public BssDocumentPage checkLogoGlavbukhInDocumentContentFooter() {
        getHelper(DocumentHelper.class).checkLogoGlavbukhInDocumentContentFooter();
        return this;
    }

    public BssDocumentPage checkSafetyLightsIsPresent() {
        getHelper(DocumentHelper.class).checkSafetyLightsIsPresent();
        return this;
    }

    public BssDocumentPage checkControlBlockIncutForDocument170_9598() {
        getHelper(DocumentHelper.class).checkControlBlockIncutForDocument170_9598();
        return this;
    }

    public BssDocumentPage checkSafetyResultIsPresent() {
        getHelper(DocumentHelper.class).checkSafetyResultIsPresent();
        return this;
    }

    public BssDocumentPage checkBriefBlockIsPresent() {
        getHelper(DocumentHelper.class).checkBriefBlockIsPresent();
        return this;
    }

    public BssDocumentPage checkTextBlocksForDocument199_10304() {
        getHelper(DocumentHelper.class).checkTextBlocksForDocument199_10304();
        return this;
    }

    public BssDocumentPage checkDocumentRatingIsPresent() {
        getHelper(DocumentHelper.class).checkDocumentRatingIsPresent();
        return this;
    }

    public BssDocumentPage checkSocialBlockIsPresent() {
        getHelper(DocumentHelper.class).checkSocialBlockIsPresent();
        return this;
    }

    public BssDocumentPage checkTitleWithModIdPubForRedactorUser() {
        getHelper(DocumentHelper.class).checkTitleWithModIdPubForRedactorUser();
        return this;
    }

    public BssDocumentPage сheckInfobarLinksIsNotPresent() {
        getHelper(DocumentHelper.class).сheckInfobarLinksIsNotPresent();
        return this;
    }

    public BssDocumentPage checkYellowBlockFactoid() {
        getHelper(DocumentHelper.class).checkYellowBlockFactoid();
        return this;
    }

    public BssDocumentPage checkDocumentIsBlurred() {
        getHelper(DocumentHelper.class).checkDocumentIsBlurred();
        return this;
    }

    public BssDocumentPage checkDocPreviewTextStatus() {
        getHelper(DocumentHelper.class).checkDocPreviewTextStatus();
        return this;
    }

    public BssDocumentPage checkAuthFormIsPresent() {
        getHelper(DocumentHelper.class).checkAuthFormIsPresent();
        return this;
    }

    public BssDocumentPage checkDocBriefIsPresent(String brief) {
        getHelper(DocumentHelper.class).checkDocBriefIsPresent(brief);
        return this;
    }

    public BssDocumentPage checkBacklinksArePresent() {
        getHelper(DocumentHelper.class).checkBacklinksArePresent();
        return this;
    }

    public BssDocumentPage checkBacklinkHasCssStyles() {
        getHelper(DocumentHelper.class).checkBacklinkHasCssStyles();
        return this;
    }

    public BssDocumentPage clickOnBacklinkWithReferencesCount(int count) {
        getHelper(DocumentHelper.class).clickOnBacklinkWithReferencesCount(count);
        return this;
    }

    public BssDocumentPage checkNotepadPopupIsPresent() {
        getHelper(NotepadPopup.class).checkPopupIsPresent();
        return this;
    }

    public BssDocumentPage checkParagraphAndButtonAreYellow() {
        getHelper(DocumentHelper.class).checkParagraphAndButtonAreYellow();
        return this;
    }

    public BssDocumentPage checkParagraphAndButtonAreNotYellow() {
        getHelper(DocumentHelper.class).checkParagraphAndButtonAreNotYellow();
        return this;
    }

    /**
     * @param phraseAnchor - the part of link in the data-anchor attribute for the tag 'a'
     *                     example: <a data-anchor="/document/99/9027690/bssPhr143/"...,
     *                     for this, phraseAnchor = bssPhr143
     */
    public BssDocumentPage clickOnRequiredArticleBacklink(String phraseAnchor) {
        getHelper(DocumentHelper.class).clickOnRequiredArticleBacklink(phraseAnchor);
        return this;
    }

    public BssDocumentPage checkTextContainsBlocksHowToAndWhatToDo() {
        getHelper(DocumentHelper.class).checkTextContainsBlocksHowToAndWhatToDo();
        return this;
    }

    public BssDocumentPage checkIncutAdviceContainsText(String text) {
        getHelper(DocumentHelper.class).checkIncutAdviceContainsText(text);
        return this;
    }

    public BssDocumentPage checkNotepadPopupHasShadow() {
        getHelper(NotepadPopup.class).checkPopupHasShadow();
        return this;
    }

    public BssDocumentPage checkNotepadPopupHeaderIsWhite() {
        getHelper(NotepadPopup.class).checkHeaderIsWhite();
        return this;
    }

    public BssDocumentPage checkNotepadPopupTitleIsPresent() {
        getHelper(NotepadPopup.class).checkTitleIsPresent();
        return this;
    }

    public BssDocumentPage checkNotepadPopupCloseIconIsPresent() {
        getHelper(NotepadPopup.class).checkCloseIconIsPresent();
        return this;
    }

    public BssDocumentPage checkNotepadPopupBodyIsYellow() {
        getHelper(NotepadPopup.class).checkBodyIsYellow();
        return this;
    }

    public BssDocumentPage checkNotepadPopupBodyHasBacklinks() {
        getHelper(NotepadPopup.class).checkBodyHasBacklinks();
        return this;
    }

    public BssDocumentPage checkNotepadPopupIsNotPresent() {
        getHelper(NotepadPopup.class).checkPopupIsNotPresent();
        return this;
    }

    public BssDocumentPage clickOnNotepadPopupCloseButton() {
        getHelper(NotepadPopup.class).clickOnCloseButton();
        return this;
    }

    public BssDocumentPage checkNotepadPopupMenuBlockIsPresent() {
        getHelper(NotepadPopup.class).checkMenuBlockIsPresent();
        return this;
    }

    public BssDocumentPage checkNotepadPopupMenuBlockIsNotPresent() {
        getHelper(NotepadPopup.class).checkMenuBlockIsNotPresent();
        return this;
    }

    public BssDocumentPage checkNotepadPopupMenuItemsInOrder(NotepadPopup.Item... items) {
        getHelper(NotepadPopup.class).checkMenuItemsInOrder(items);
        return this;
    }

    public BssDocumentPage checkNotepadPopupMenuItemIcon(NotepadPopup.Item... items) {
        getHelper(NotepadPopup.class).checkMenuItemIcon(items);
        return this;
    }

    public BssDocumentPage hoverOnNotepadPopupMenuItem(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).hoverOnMenuItem(item);
        return this;
    }

    public BssDocumentPage checkNotepadPopupMenuItemIsRed(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).checkMenuItemIsRed(item);
        return this;
    }

    public BssDocumentPage clickOnNotepadPopupMenu(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).clickOnMenu(item);
        return this;
    }

    public BssDocumentPage checkNotepadPopupMenuItemHasRightName(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).checkMenuItemHasRightName(item);
        return this;
    }

    public BssDocumentPage checkNotepadPopupMenuItemIsYellow(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).checkMenuItemIsYellow(item);
        return this;
    }

    public BssDocumentPage checkNotepadPopupMenuItemIsNotRed(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).checkMenuItemIsNotRed(item);
        return this;
    }

    public BssDocumentPage checkNotepadPopupScrollTo(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).checkScrollTo(item);
        return this;
    }

    public BssDocumentPage checkNotepadPopupMenuItemIsSelectedAfterScrolling(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).checkMenuItemIsSelectedAfterScrolling(item);
        return this;
    }

    public BssDocumentPage checkNotepadPopupTitleHasWhiteSpaceCSSValue() {
        getHelper(NotepadPopup.class).checkTitleHasWhiteSpaceCSSValue();
        return this;
    }

    public BssDocumentPage checkNotepadTitleEqualsWithPhraseTitle(String phraseAnchor) {
        getHelper(NotepadPopup.class).checkTitle(phraseAnchor);
        return this;
    }

    public BssDocumentPage checkNotepadTitleContainsWord(String phraseAnchor, String word) {
        getHelper(NotepadPopup.class).checkTitleContainsWord(phraseAnchor, word);
        return this;
    }

    public BssDocumentPage checkNotepadTitleIsAdditionalInformation() {
        getHelper(NotepadPopup.class).checkTitleIsAdditionalInformation();
        return this;
    }

    public BssDocumentPage clickOnBackLinkFromTitle() {
        getHelper(DocumentHelper.class).clickOnBackLinkFromTitle();
        return this;
    }

    public BssDocumentPage checkNotepadPopupRecomendationBlockFirstItemHasPhotoFullNameAndPosition() {
        getHelper(NotepadPopup.class).checkRecomendationBlockFirstItemHasPhotoFullNameAndPosition();
        return this;
    }

    public BssDocumentPage checkNotepadPopupRecomentdationBlockHasNoMoreThan10Links() {
        getHelper(NotepadPopup.class).checkRecomentdationBlockHasNoMoreThan10Links();
        return this;
    }

    public BssDocumentPage checkNotepadPopupRecomendationBlockHasLinks() {
        getHelper(NotepadPopup.class).checkRecomendationBlockHasLinks();
        return this;
    }

    public BssDocumentPage checkNotepadPopupFormsBlockHasLinks() {
        getHelper(NotepadPopup.class).checkFormsBlockHasLinks();
        return this;
    }

    public BssDocumentPage checkNotepadPopupFormsBlockHasNoMoreThan10Links() {
        getHelper(NotepadPopup.class).checkFormsBlockHasNoMoreThan10Links();
        return this;
    }

    public BssDocumentPage checkNotepadPopupHandbookBlockHasLinks() {
        getHelper(NotepadPopup.class).checkHandbookBlockHasLinks();
        return this;
    }

    public BssDocumentPage checkNotepadPopupHandbookBlockHasNoMoreThan10Links() {
        getHelper(NotepadPopup.class).checkHandbookBlockHasNoMoreThan10Links();
        return this;
    }

    public BssDocumentPage checkNotepadPopupPressBlockHasItems() {
        getHelper(NotepadPopup.class).checkPressBlockHasItems();
        return this;
    }

    public BssDocumentPage checkNotepadPopupPressBlockHasNoMoreThan10Links() {
        getHelper(NotepadPopup.class).checkPressBlockHasNoMoreThan10Links();
        return this;
    }

    public BssDocumentPage checkNotepadPopupLawBlockHasLinks() {
        getHelper(NotepadPopup.class).checkLawBlockHasLinks();
        return this;
    }

    public BssDocumentPage checkNotepadPopupLawBlockHasNoMoreThan10Links() {
        getHelper(NotepadPopup.class).checkLawBlockHasNoMoreThan10Links();
        return this;
    }

    public BssDocumentPage checkNotepadPopupLawPracticeBlockHasLinks() {
        getHelper(NotepadPopup.class).checkLawPracticeBlockHasLinks();
        return this;
    }

    public BssDocumentPage checkNotepadPopupLawPracticeBlockHasNoMoreThan10Links() {
        getHelper(NotepadPopup.class).checkLawPracticeBlockHasNoMoreThan10Links();
        return this;
    }

    public BssDocumentPage hoverOnNotepadPopupFirstLinkFromLawPractice() {
        getHelper(NotepadPopup.class).hoverOnFirstLinkFromLawPractice();
        return this;
    }

    public BssDocumentPage checkNotepadPopupFirstLinkFromLawPracticeBecomeRedAfterHoverOn() {
        getHelper(NotepadPopup.class).checkFirstLinkFromLawPracticeBecomeRedAfterHoverOn();
        return this;
    }

    public BssDocumentPage clickOnNotepadPopupFormsBlockRandomLink() {
        getHelper(NotepadPopup.class).clickOnFormsBlockRandomLink();
        return this;
    }

    public BssDocumentPage clickOnNotepadPopupHandbookBlockRandomLink() {
        getHelper(NotepadPopup.class).clickOnHandbookBlockRandomLink();
        return this;
    }

    public BssDocumentPage clickOnNotepadPopupLawBlockRandomLink() {
        getHelper(NotepadPopup.class).clickOnLawBlockRandomLink();
        return this;
    }

    public BssDocumentPage clickOnNotepadPopupPressBlockRandomLink() {
        getHelper(NotepadPopup.class).clickOnPressBlockRandomLink();
        return this;
    }

    public BssDocumentPage clickOnNotepadPopupLawPracticeBlockRandomLink() {
        getHelper(NotepadPopup.class).clickOnLawPracticeBlockRandomLink();
        return this;
    }

    public BssDocumentPage clickOnNotepadPopupRecomendationBlockRandomLink() {
        getHelper(NotepadPopup.class).clickOnRecomendationBlockRandomLink();
        return this;
    }

    public BssDocumentPage clickOnPrevButtonInTopMenu() {
        getHelper(DocumentHelper.class).clickOnPrevButtonInTopMenu();
        return this;
    }

    public BssDocumentPage clickOnNextButtonInTopMenu() {
        getHelper(DocumentHelper.class).clickOnNextButtonInTopMenu();
        return this;
    }

    public BssDocumentPage clickOnPreviousButtonInBottomMenu() {
        getHelper(DocumentHelper.class).clickOnPreviousButtonInBottomMenu();
        return this;
    }

    public BssDocumentPage clickOnNextButtonInBottomMenu() {
        getHelper(DocumentHelper.class).clickOnNextButtonInBottomMenu();
        return this;
    }

    public BssDocumentPage checkNextAndPrevButtonsInTopMenuArePresent() {
        getHelper(DocumentHelper.class).checkNextAndPrevButtonsInTopMenuArePresent();
        return this;
    }

    public BssDocumentPage checkNextAndPrevButtonsInBottomMenuArePresent() {
        getHelper(DocumentHelper.class).checkNextAndPrevButtonsInBottomMenuArePresent();
        return this;
    }

    public BssDocumentPage clickFirstArticleFromTableOfContents() {
        getHelper(DocumentHelper.class).clickFirstArticleFromTableOfContents();
        return this;
    }

    public BssDocumentPage clickLastArticleFromTableOfContents() {
        getHelper(DocumentHelper.class).clickLastArticleFromTableOfContents();
        return this;
    }

    public BssDocumentPage checkMoreOnTheTopicIsPresent() {
        getHelper(DocumentHelper.class).checkMoreOnTheTopicIsPresent();
        return this;
    }

    public BssDocumentPage checkCommentsArePresent() {
        getHelper(DocumentHelper.class).checkCommentsArePresent();
        return this;
    }

    public BssDocumentPage checkRevisionHistoryIsPresent() {
        getHelper(DocumentHelper.class).checkRevisionHistoryLinkIsPresent();
        return this;
    }

    public BssDocumentPage clickOnRevisionHistoryLink() {
        getHelper(DocumentHelper.class).clickOnRevisionHistoryLink();
        return this;
    }

    public BssDocumentPage checkRevisionHistoryBlockIsOpened() {
        getHelper(DocumentHelper.class).checkRevisionHistoryBlockIsOpened();
        return this;
    }

    public BssDocumentPage checkRevisionHistoryTitleSpeciallyActionsIsPresent() {
        getHelper(DocumentHelper.class).checkRevisionHistoryTitleSpeciallyActionsIsPresent();
        return this;
    }

    public BssDocumentPage checkRevisionHistoryTitleContainsInDocumentIsPresent() {
        getHelper(DocumentHelper.class).checkRevisionHistoryTitleContainsInDocumentIsPresent();
        return this;
    }

    public BssDocumentPage clickOnRandomDocumentFromRevisionHistoryList() {
        getHelper(DocumentHelper.class).clickOnRandomDocumentFromRevisionHistoryList();
        return this;
    }

    public BssDocumentPage clickOnMoreLinksFromInfobarOfTheDocument() {
        getHelper(DocumentHelper.class).clickOnMoreLinksFromInfobarOfTheDocument();
        return this;
    }

    public BssDocumentPage checkMoreLinksLinkHasYellowHighlightAfterClicking() {
        getHelper(DocumentHelper.class).checkMoreLinksLinkHasYellowHighlightAfterClicking();
        return this;
    }

    public BssDocumentPage checkMoreLinksBlockIsOpened() {
        getHelper(DocumentHelper.class).checkMoreLinksBlockIsOpened();
        return this;
    }

    public BssDocumentPage checkMoreLinksHasTitleLinks() {
        getHelper(DocumentHelper.class).checkMoreLinksHasTitleLinks();
        return this;
    }

    public BssDocumentPage clickOnMoreLinksRandomLink() {
        getHelper(DocumentHelper.class).clickOnMoreLinksRandomLink();
        return this;
    }

    public BssDocumentPage checkMoreLinksAreDuplicatedBelowOfTheDocument() {
        getHelper(DocumentHelper.class).checkMoreLinksAreDuplicatedBelowOfTheDocument();
        return this;
    }

    public BssDocumentPage clickOnLinksFromInfobarInBottom() {
        getHelper(DocumentHelper.class).clickOnLinksFromInfobarInBottom();
        return this;
    }

    public BssDocumentPage checkStickyHeaderIsGray() {
        getHelper(DocumentHelper.class).checkStickyHeaderIsGray();
        return this;
    }

    public BssDocumentPage clickOnStickyHeader() {
        getHelper(DocumentHelper.class).clickOnStickyHeader();
        return this;
    }

    public BssDocumentPage checkStickyHeaderIsNotPresent() {
        getHelper(DocumentHelper.class).checkStickyHeaderIsNotPresent();
        return this;
    }

    public BssDocumentPage checkQuickTocIsPresent() {
        getHelper(DocumentHelper.class).checkQuickTocIsPresent();
        return this;
    }

    public BssDocumentPage checkQuickTocHasNumbers() {
        getHelper(DocumentHelper.class).checkQuickTocHasNumbers();
        return this;
    }

    public BssDocumentPage checkQuickTocDoesNotContainItemsReferencesAndLinks() {
        getHelper(DocumentHelper.class).checkQuickTocDoesNotContainItemsReferencesAndLinks();
        return this;
    }

    public BssDocumentPage checkApplicationsWidgetIsPresent() {
        getHelper(DocumentHelper.class).checkApplicationsWidgetIsPresent();
        return this;
    }

    public BssDocumentPage clickOnInfobarApplicationsLink() {
        getHelper(DocumentHelper.class).clickOnInfobarApplicationsLink();
        return this;
    }

    public BssDocumentPage checkApplicationsTextsArePresent() {
        getHelper(AttachmentsInfobar.class).checkApplicationsTextsArePresent();
        return this;
    }

    public BssDocumentPage checkAttachedFilesAreAvailable() {
        getHelper(AttachmentsInfobar.class).checkAttachedFilesAreAvailable();
        return this;
    }

    public BssDocumentPage checkApplicationsExtensionsArePresent() {
        getHelper(AttachmentsInfobar.class).checkApplicationsExtensionsArePresent();
        return this;
    }

    public BssDocumentPage checkDocumentRegionYellowTipFor(String region) {
        getHelper(DocumentHelper.class).checkDocumentRegionYellowTipFor(region);
        return this;
    }

    public BssDocumentPage clickReferencesByArticleAndParagraph(int chapterNumber, int articleNumber, int paragraphNumber) {
        getHelper(DocumentHelper.class).clickReferencesByArticleAndParagraph(chapterNumber, articleNumber, paragraphNumber);
        return this;
    }

    public BssSearchResultPage clickAllAdditionalMaterialsButton() {
        getHelper(DocumentHelper.class).clickAllAdditionalMaterialsButton();
        return redirectTo(BssSearchResultPage.class);
    }
}


