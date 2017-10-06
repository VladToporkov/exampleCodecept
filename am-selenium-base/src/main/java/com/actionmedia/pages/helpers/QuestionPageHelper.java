package com.actionmedia.pages.helpers;

import com.actionmedia.autotest.selenium.elements.TextField;
import com.actionmedia.base.BasePage;
import com.actionmedia.util.SgcrmUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 29.11.13
 * Time: 12:00
 */
@Component
public class QuestionPageHelper extends BasePage<QuestionPageHelper> {

    private static String questionId;
    private static String question;

    @Step("Проверяется что форма отправки сообщения эксперту активна")
    public void checkSendWindowsIsEnabled() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".hl-board"));
        WebElement sendForm = findElementByNoThrow(content, By.cssSelector(".hl-form"));
        postponedAssertFalse(sendForm.getAttribute("class").contains("disabled"), "Форма для отправки сообщения не активна");
        postponedAssertTrue(sendForm.isEnabled() && sendForm.isDisplayed(), "Форма отправки сообщений не отображается");
    }

    @Step("Проверяется что форма отправки сообщения эксперту не активна")
    public void checkSendWindowsIsDisabled() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".hl-board"));
        WebElement sendForm = findElementByNoThrow(content, By.cssSelector(".hl-form"));
        postponedAssertTrue(sendForm.getAttribute("class").contains("disabled"), "Форма для отправки сообщения активна");
        postponedAssertTrue(findElementBy(By.id("message")).getAttribute("disabled") != null &&
                "true".equals(findElementBy(By.id("message")).getAttribute("disabled")), "Форма для отправки сообщения активна");
    }

    @Step("Проверяется текст в форме отправки сообщения")
    public void checkTextInSendForm(String expectedText) {
        WebElement sendForm = waitForPresenceOfElementLocatedBy(By.cssSelector(".hl-form"));
        postponedAssertTrue(sendForm.getText().replaceAll("\n", "").contains(expectedText), "Неправильный текст сообщения в форме отправки");
    }

    @Step("Проверяется что кнопка Отправить активна")
    public void checkSendButtonIsEnabled() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".hl-board"));
        WebElement button = findElementByNoThrow(content, By.cssSelector(".button"));
        assertNotNull(button, "Кнопка Отправить не найдена");
        postponedAssertTrue(button.isEnabled() && button.isDisplayed(), "Кнопка Отправить не отображается");
        postponedAssertTrue(button.getAttribute("disabled") == null, "Кнопка Отправить не активна");
    }

    @Step("Проверяется что кнопка Отправить не активна")
    public void checkSendButtonIsDisabled() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".hl-board"));
        WebElement button = findElementByNoThrow(content, By.cssSelector(".button"));
        assertNotNull(button, "Кнопка Отправить не найдена");
        postponedAssertTrue(button.isDisplayed(), "Кнопка Отправить не отображается");
        postponedAssertTrue(!button.isEnabled() && button.getAttribute("disabled") != null && "true".equals(button.getAttribute("disabled")), "Кнопка Отправить активна");
    }

    @Step("Проверяется что информации о персональном эксперте отображается")
    public void checkPersonalExpertInfoIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".hl-info"));
        WebElement personalInfo = findElementByNoThrow(content, By.cssSelector(".hl-personal"));
        assertNotNull(personalInfo, "Информации о персональном эксперте не найдена");
        postponedAssertTrue(personalInfo.isEnabled() && personalInfo.isDisplayed(), "Информации о персональном эксперте не отображается");
    }

    @Step("Проверяется что информации о авторах системы отображается")
    public void checkAuthorsInfoIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".hl-info"));
        WebElement personalInfo = findElementByNoThrow(content, By.cssSelector(".hl-authors"));
        assertNotNull(personalInfo, "Информации о авторах системы не найдена");
        postponedAssertTrue(personalInfo.isEnabled() && personalInfo.isDisplayed(), "Информации о авторах системы не отображается");
    }


    @Step("Проверяется что страница пресонального эксперта отображается по-умолчанию")
    public void checkPersonalTabIsSelected() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".hl-tab"));
        WebElement personalTab = content.findElement(By.cssSelector(".active"));
        postponedAssertTrue("письменно".equals(personalTab.getText().trim()), "страница пресонального эксперта не отображается по-умолчанию");
    }

    @Step("Проверяется что страница авторам системы отображается")
    public void checkAuthorsTabIsSelected() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".hl-tab"));
        WebElement authorsTab = content.findElement(By.cssSelector(".active"));
        postponedAssertTrue("от автора системы".equals(authorsTab.getText().trim()), "страница авторам системы не отображается");
    }

    @Step("Проверяется что заданный вопрос отображается и запоминается номер запроса")
    public void checkSendMessageIsPresent(String message) {
        List<WebElement> answers = findElementsByNoThrow(By.cssSelector(".answer"));
        if (answers.isEmpty()) {
            setPostponedTestFail("Заданный вопрос не отображается");
            return;
        }
        for (WebElement answer : answers) {
            if (answer.findElement(By.cssSelector(".question")).getText().equals(message)) {
                WebElement questionInfo = findElementByNoThrow(answer, By.cssSelector(".question-info"));
                assertNotNull(questionInfo, "Информация об отправленном собщении не найдена");
                postponedAssertTrue(questionInfo.isEnabled() && questionInfo.isDisplayed(), "Информация об отправленном собщении не отображается");
                questionId = questionInfo.getText().split("№")[1];
                this.question = message;
                return;
            }
        }
        setPostponedTestFail("Вопрос:" + message + " не найден в списке заданных вопросов");
    }

    @Step("Выбрать раздел авторам системы")
    public void clickAuthorsTab() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".hl-tab"));
        content.findElement(By.cssSelector("[rel='tabs-3']")).click();
    }

    @Step("Нажать на кнопку Письменно")
    public void clickPersonalTab() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".hl-tab"));
        content.findElement(By.cssSelector("[rel='tabs-2']")).click();
    }

    @Step("Нажать на поле ввода текста сообщения")
    public void clickTextForm() {
        WebElement sendForm = waitForVisibilityOfElementLocatedBy(By.cssSelector(".hl-form"));
        sendForm.findElement(By.id("message")).sendKeys(Keys.ENTER);
    }

    @Step("Нажать кнопку Отправить")
    public void clickSendButtonOnQuestionPage() {
        waitForReloadingPage();
        waitFewSecond(5000);
        waitForVisibilityOfElementLocatedBy(By.cssSelector(".button")).click();
        waitFewSecond(5000);
        waitForReloadingPage();
    }

    @Step("Ввести текст в форму отправки сообщения")
    public void inputTextInSendForm(String inputText) {
        WebElement textForm = waitForVisibilityOfElementLocatedBy(By.id("message"));
        if (!findElementBy(By.id("phonePrefix")).isDisplayed()) {
            textForm.click();
            waitForReloadingPage();
        }
        textForm.clear();
        textForm.sendKeys(inputText);
//        TextField textField = getWebElementWrapper(waitForVisibilityOfElementLocatedBy(By.id("message"))).getTextField();
//        textField.clearAndType(inputText);
    }

    @Step("Ввести номер телефона")
    public void inputRandomPhoneNumber() {
        TextField phonePrefix = getWebElementWrapper(waitForVisibilityOfElementLocatedBy(By.id("phonePrefix"))).getTextField();
        TextField phoneNumber = getWebElementWrapper(waitForVisibilityOfElementLocatedBy(By.id("phoneNumber"))).getTextField();
        phonePrefix.clearAndType(RandomStringUtils.randomNumeric(3));
        phoneNumber.clearAndType(RandomStringUtils.randomNumeric(7));
    }

    public boolean isWeekendOrEndOfDay() {
        DateTime currentTime = new DateTime();
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".hl-board"));
        WebElement sendForm = findElementByNoThrow(content, By.cssSelector(".hl-form"));
        return (sendForm != null && sendForm.getText().contains("По выходным помощник на связи\nс 9 до 18 по московскому времени")) ||
                (sendForm != null && (currentTime.getDayOfWeek() == 6 || currentTime.getDayOfWeek() == 7) && (currentTime.getHourOfDay() > 18 || currentTime.getHourOfDay() < 9));
    }

    public boolean isWeekend() {
        DateTime currentTime = new DateTime();
        return (currentTime.getDayOfWeek() == 6 || currentTime.getDayOfWeek() == 7);
    }


    @Step("Выводится ошибка: {0}")
    public void checkErrorMessage(String message) {
        WebElement error = waitForPresenceOfElementLocatedBy(By.cssSelector(".hl-form-errors"), "Ошибка не появилась");
        postponedAssertEquals(error.getText(), message, "Текст ошибки не совпадает с текстом на форме");
    }

    @Step("Присутствует placeholder error у текстового поля")
    public void checkErrorTextBoxPlaceholder() {
        WebElement messageBox = findElementBy(By.id("message"));
        postponedAssertTrue(messageBox.getAttribute("class").contains("error"), "Класс error не появился у текстового поля");
        postponedAssertEquals(messageBox.getCssValue("border-top-color"), "rgba(187, 0, 0, 1)", "Цвет плейсхолдера не красный");
    }

    @Step("Очистить поля номер телефона")
    public void clearFieldsPhoneNumber() {
        TextField phonePrefix = getWebElementWrapper(waitForVisibilityOfElementLocatedBy(By.id("phonePrefix"))).getTextField();
        TextField phoneNumber = getWebElementWrapper(waitForVisibilityOfElementLocatedBy(By.id("phoneNumber"))).getTextField();
        phonePrefix.clear();
        phoneNumber.clear();
    }

    @Step("Присутствует placeholder error у полей номера телефона")
    public void checkErrorPhoneNumberPlaceholder() {
        WebElement phonePrefix = waitForVisibilityOfElementLocatedBy(By.id("phonePrefix"));
        WebElement phoneNumber = waitForVisibilityOfElementLocatedBy(By.id("phoneNumber"));

        postponedAssertTrue(phonePrefix.getAttribute("class").contains("error"), "Класс error не появился у текстового поля");
        postponedAssertEquals(phonePrefix.getCssValue("border-top-color"), "rgba(187, 0, 0, 1)", "Цвет плейсхолдера " +
                "не красный");

        postponedAssertTrue(phoneNumber.getAttribute("class").contains("error"), "Класс error не появился у текстового поля");
        postponedAssertEquals(phoneNumber.getCssValue("border-top-color"), "rgba(187, 0, 0, 1)", "Цвет плейсхолдера " +
                "не красный");
    }

    @Step("Ввести email:{0}")
    public void inputEmail(String email) {
        TextField emailField = getWebElementWrapper(waitForVisibilityOfElementLocatedBy(By.id("email"))).getTextField();
        emailField.clearAndType(email);
    }

    @Step("Очистить поле Электронная почта")
    public void clearEmailField() {
        TextField emailField = getWebElementWrapper(waitForVisibilityOfElementLocatedBy(By.id("email"))).getTextField();
        emailField.clear();
    }

    @Step("Проверить, что присутствует красная рамка у поля почты")
    public void checkErrorEmailPlaceholder() {
        WebElement emailField = waitForVisibilityOfElementLocatedBy(By.id("email"));
        postponedAssertTrue(emailField.getAttribute("class").contains("error"), "Класс error не появился у текстового поля");
        postponedAssertEquals(emailField.getCssValue("border-top-color"), "rgba(187, 0, 0, 1)", "Цвет плейсхолдера " +
                "не красный");
    }

    @Step("Проверить, что созданный запрос присутствует в SGCRM в статусе Новый")
    public void checkCreatedQuestionInSGCRM() {
        if (checkQuestionIdIsExist()) {
            return;
        }
        report("Ищем запрос в SGCRM под номером:" + questionId);
        Document document;
        try {
            document = SgcrmUtils.getQuestionFromHotline(questionId);
        } catch (IOException e) {
            setPostponedTestFail("Запрос на поиск вопроса под номером:" + questionId + " не выполнился. Техническая ошибка: " + e.getMessage());
            return;
        }

        postponedAssertEquals(document.select(".q").text(), question, "Текст вопроса не совпадает с текстом в SGCRM");
        postponedAssertEquals(document.select(".s").text(), "Новый", "Запрос находится не в статусе Новый в SGCRM");
    }

    @Step("Удалить запрос в ГЛ SGCRM")
    public void removeQuestionFromSGCRM() {
        if (checkQuestionIdIsExist()) {
            return;
        }
        report("Удаляем запрос в SGCRM под номером:" + questionId);
        try {
            SgcrmUtils.removeQuestionFromHotline(questionId);
        } catch (IOException e) {
            setPostponedTestFail("Запрос на удаление вопроса под номером:" + questionId + " не выполнился. Техническая ошибка: " + e.getMessage());
        }
    }

    @Step("Проверить, что запрос удален из ГЛ SGCRM")
    public void checkQuestionIsRemovedFromSGCRM() {
        if (checkQuestionIdIsExist()) {
            return;
        }
        report("Проверяем, что запрос в SGCRM: " + questionId + " в статусе Удален");
        Document document;
        try {
            document = SgcrmUtils.getQuestionFromHotline(questionId);
        } catch (IOException e) {
            setPostponedTestFail("Запрос на поиск вопроса под номером:" + questionId + " не выполнился. Техническая ошибка: " + e.getMessage());
            return;
        }

        postponedAssertEquals(document.select(".s").text(), "Удален", "Запрос в ГЛ:" + questionId + " не удален после выполнения запроса на удаление!");
    }

    private boolean checkQuestionIdIsExist() {
        if (questionId == null || questionId.isEmpty()) {
            setPostponedTestFail("Номер запроса неизвестен. Может быть он не был отправлен?");
            return false;
        } else {
            return true;
        }
    }

    @Step("Проверить, что отображается заголовок {0}")
    public void checkTitleIsPresent(String title) {
        WebElement titleGetAnswer = findElementByNoThrow(By.cssSelector(".hotline-board__header-title"));
        postponedAssertNotNull(titleGetAnswer, "Заголовок отсутсвует на странице");
        if (titleGetAnswer != null) {
            postponedAssertEqualsText(titleGetAnswer, title);
        }
    }

    @Step("Отображается кнопка Онлайн")
    public void checkButtonTabOnlineIsPresent() {
        WebElement tabOnline = findElementByNoThrow(By.cssSelector("[rel='tabs-1']"));
        postponedAssertEqualsText(tabOnline, "онлайн");
    }

    @Step("Отображается кнопка Письменно")
    public void checkButtonTabWritingIsPresent() {
        WebElement tabWriting = findElementByNoThrow(By.cssSelector("[rel='tabs-2']"));
        postponedAssertEqualsText(tabWriting, "письменно");
    }

    @Step("Отображается кнопка От автора системы")
    public void checkButtonTabFromAuthorsIsPresent() {
        WebElement tabFromAuthors = findElementByNoThrow(By.cssSelector("[rel='tabs-3']"));
        postponedAssertEqualsText(tabFromAuthors, "от автора системы");
    }

    @Step("Проверить, что не отображается кнопка От автора системы")
    public void checkButtonTabFromAuthorsIsNotPresent() {
        WebElement tabFromAuthors = findElementByNoThrow(By.cssSelector("[rel='tabs-3']"));
        postponedAssertTrue(tabFromAuthors == null || !tabFromAuthors.isDisplayed(), "Кнопка От автора системы " +
                "отображается");
    }

    @Step("Отображается текстовое окно")
    public void checkTextFormIsPresent() {
        WebElement messageForm = findElementBy(By.id("message-form"));
        postponedAssertTrue(messageForm.isDisplayed(), "Текстовое окно не отображается");
    }

    @Step("Отображается стикер Готовые ответы")
    public void checkStickerIsPresent() {
        WebElement sticker = findElementBy(By.cssSelector(".hl-sticker"));
        postponedAssertTrue(sticker.isDisplayed(), "Стикер не отображен");
        WebElement readyAnswers = findElementByNoThrow(sticker, By.tagName("a"));
        postponedAssertEqualsText(readyAnswers, "ГОТОВЫЕ ОТВЕТЫ");
    }

    @Step("Отображается текст на вкладке Онлайн")
    public void checkTextOnTabOnline(String text) {
        WebElement textOnline = findElementByNoThrow(By.cssSelector(".hl-text-online"));
        postponedAssertEqualsText(textOnline, text);
    }

    @Step("Отображается текст на вкладке Письменно")
    public void checkTextOnTabWriting(String text) {
        WebElement tabWriting = findElementBy(By.id("tabs-2"));
        WebElement textOnline = findElementByNoThrow(tabWriting, By.cssSelector(".hl-text"));
        postponedAssertEqualsText(textOnline, text);
    }

    @Step("Отображается текст на вкладке от автора системы")
    public void checkTextOnTabFromAuthors(String text) {
        WebElement tabWriting = findElementBy(By.id("tabs-3"));
        WebElement textOnline = findElementByNoThrow(tabWriting, By.cssSelector(".hl-text"));
        postponedAssertEqualsText(textOnline, text);
    }

    @Step("Отображается ссылка Правила работы экспертов")
    public void checkLinkExpertsWorkingRules() {
        WebElement link = findElementByNoThrow(By.cssSelector(".hl-rules a"));
        postponedAssertTrue(link.isDisplayed(), "Ссылка Правила работы экспертов не отображается");
        WebElement container = findElementByNoThrow(By.cssSelector(".hl-rules"));
        postponedAssertEqualsText(container, "Правила работы экспертов");
    }

    @Step("Проверяется, что отображается метка ВИП в тексте на вкладке Письменно")
    public void checkVIPLabelOnTabWriting() {
        WebElement tabWriting = findElementBy(By.id("tabs-2"));
        WebElement vipLabel = findElementBy(tabWriting, By.cssSelector(".hl-vip"));
        postponedAssertTrue(vipLabel.isDisplayed(), "Метка ВИП не отображается");
    }

    @Step("Проверяется, что отображается метка ВИП в тексте на вкладке от автора системы")
    public void checkVIPLabelOnTabFromAuthors() {
        WebElement tabFromAuthors = findElementBy(By.id("tabs-3"));
        WebElement vipLabel = findElementBy(tabFromAuthors, By.cssSelector(".hl-vip"));
        postponedAssertTrue(vipLabel.isDisplayed(), "Метка ВИП не отображается");
    }

    @Step("Проверяется наличие ФОТО персонального эксперта на вкладке Письменно")
    public void checkExpertInfoPhotoIsPresent() {
        WebElement tabWriting = findElementBy(By.id("tabs-2"));
        WebElement photo = findElementByNoThrow(tabWriting, By.cssSelector(".hl-personal img"));
        assertNotNull(photo, "Фото персонального эксперта не отображается");
        postponedAssertTrue(photo.isDisplayed(), "Фото персонального эксперта не видно");
    }

    @Step("Проверяется наличие ФИО персонального эксперта на вкладке Письменно")
    public void checkExpertInfoFullNameIsPresent() {
        WebElement tabWriting = findElementBy(By.id("tabs-2"));
        WebElement personalInfoBlock = findElementBy(tabWriting, By.cssSelector(".hl-personal-info"));
        String fullName = hookForGettingTextWithoutIncludingChildElementsText(personalInfoBlock);
        postponedAssertFalse(fullName.isEmpty(), "ФИО персонального эксперта не найдено в блоке");
    }

    @Step("Проверяется наличие Должность персонального эксперта на вкладке Письменно")
    public void checkExpertInfoPositionIsPresent() {
        WebElement tabWriting = findElementBy(By.id("tabs-2"));
        WebElement personalInfoBlock = findElementBy(tabWriting, By.cssSelector(".hl-personal-info"));
        WebElement position = findElementByNoThrow(personalInfoBlock, By.cssSelector(".hl-personal-position"));
        assertNotNull(position, "Должность персонального эксперта не найдена");
        postponedAssertTrue(position.isDisplayed(), "Должность персонального эксперта не отображается");
        postponedAssertFalse(position.getText().isEmpty(), "Должность персонального эксперта пустая");
    }

    @Step("Проверяется наличие Телефонный номер персонального эксперта на вкладке Письменно")
    public void checkExpertInfoPhoneNumberIsPresent() {
        WebElement tabWriting = findElementBy(By.id("tabs-2"));
        WebElement personalInfoBlock = findElementBy(tabWriting, By.cssSelector(".hl-personal-info"));
        WebElement personalContacts = findElementBy(personalInfoBlock, By.cssSelector(".hl-personal-contacts small"));
        String phoneNumber = hookForGettingTextWithoutIncludingChildElementsText(personalContacts);
        postponedAssertFalse(phoneNumber.isEmpty(), "Номер телефона персонального эксперта не найден");
    }

    @Step("Проверяется наличие Email персонального эксперта на вкладке Письменно")
    public void checkExpertInfoEmailIsPresent() {
        WebElement tabWriting = findElementBy(By.id("tabs-2"));
        WebElement personalInfoBlock = findElementBy(tabWriting, By.cssSelector(".hl-personal-info"));
        WebElement personalContacts = findElementBy(personalInfoBlock, By.cssSelector(".hl-personal-contacts small"));
        WebElement email = findElementByNoThrow(personalContacts, By.tagName("a"));
        assertNotNull(email, "Email не найден");
        postponedAssertTrue(email.isDisplayed(), "Email не отображен");
        postponedAssertFalse(email.getText().isEmpty(), "Email пустой");
    }

    @Step("Проверяется что Email персонального эксперта на вкладке Письменно не отображен")
    public void checkExpertInfoEmailIsNotPresent() {
        WebElement tabWriting = findElementBy(By.id("tabs-2"));
        WebElement personalInfoBlock = findElementBy(tabWriting, By.cssSelector(".hl-personal-info"));
        WebElement personalContacts = findElementBy(personalInfoBlock, By.cssSelector(".hl-personal-contacts small"));
        WebElement email = findElementByNoThrow(personalContacts, By.tagName("a"));
        postponedAssertTrue(email == null || !email.isDisplayed(), "Email отображен");
    }

    @Step("Проверяется отображение очков на вкладке Письменно")
    public void checkGlassesIsVisible() {
//        WebElement tabWriting = findElementBy(By.id("tabs-2"));
        WebElement glasses = findElementByNoThrow(By.cssSelector(".hl-text img"));
        assertNotNull(glasses, "Очки не найдены");
        postponedAssertTrue(glasses.isDisplayed(), "Очки не отображаются");
        postponedAssertTrue(glasses.getAttribute("src").contains("glasses"), "Картинка не содержит слово glasses " +
                "в названии. Может отображены не очки?");
    }

    @Step("Проверяется отображение фотографий авторов в зависимости от разрешения")
    public void checkPhotoAuthorsOnFromAuthors() {
        WebElement tabFromAuthors = findElementBy(By.id("tabs-3"));
        List<WebElement> photos = findElementsByNoThrow(tabFromAuthors, By.cssSelector(".hl-authors > div"));
        Dimension resolutionNow = getDriver().manage().window().getSize();
        if (resolutionNow.getWidth() < 1315) {
            setPostponedTestFail("Разрешение экрана в максимальном состоянии:" + resolutionNow + ". Невозможно " +
                    "проверить отображение фотографий авторов.");
            return;
        }
        if (getSettings().isRunBss()) {
            checkPhotosAreVisible(5, photos);
        }
        setSizeWindows(1205, resolutionNow.getHeight());
        checkPhotosAreVisible(4, photos);
        setSizeWindows(1024, resolutionNow.getHeight());
        checkPhotosAreVisible(3, photos);
        maximize();
    }

    @Step("Проверяется, что меню переключения Онлайн/письменно отсутствует")
    public void checkTabsMenuIsNotPresent() {
        WebElement tabsMenu = findElementByNoThrow(By.cssSelector(".hl-tab ul"));
        postponedAssertNull(tabsMenu, "Меню переключения Онлайн/письменно присутствует на странице");
    }

    @Step("Проверяется текст на основной вкладке для УСН")
    public void checkTextTabForUSN() {
        WebElement text = waitForPresenceOfElementLocatedBy(By.cssSelector("#tabs-1 .hl-text"));
        if (isWeekend()) {
            postponedAssertEqualsText(text, "Ответим на ваши вопросы");
        } else {
            postponedAssertEqualsText(text, "Быстро отвечаем на ваши вопросы");
        }
    }

    private void checkPhotosAreVisible(int maxCountPhotosAreVisible, List<WebElement> photos) {
        int i = 0;
        for (WebElement photo : photos) {
            if (i >= maxCountPhotosAreVisible) {
                postponedAssertFalse(photo.isDisplayed(), "Фотография автора:" + photo.getText() + " видна, хотя " +
                        "должна быть скрыта при данном разрешении экрана.");
            } else {
                postponedAssertTrue(photo.getText() != null || !photo.getText().isEmpty(), "ФИО автора не отображается");
                postponedAssertTrue(photo.isDisplayed(), "Фотография автора:" + photo.getText() + " не видна, хотя " +
                        "должна быть видна при данном разрешении экрана.");
            }
            i++;
        }
    }

    public void checkOnlinePlaceholderText(String message) {
        WebElement textareaWithPlaceholders = findElementByNoThrow(By.cssSelector("#message-form textarea"));
        if (textareaWithPlaceholders == null) {
            setPostponedTestFail("Не найдена форма отправки текста");
            return;
        }
        String attributePlaceholder = textareaWithPlaceholders.getAttribute("data-placeholder-onlineconsultant");
        postponedAssertTrue(StringUtils.containsIgnoreCase(message, attributePlaceholder),
                "Сообщение в форме отправки текста написано некоррекnно. Ожидалось вхождение строки:" +
                        attributePlaceholder + " в строку:" + message);
    }

    public void checkUsualPlaceholderText(String message) {
        WebElement textareaWithPlaceholders = findElementByNoThrow(By.cssSelector("#message-form textarea"));
        if (textareaWithPlaceholders == null) {
            setPostponedTestFail("Не найдена форма отправки текста");
            return;
        }
        String attributePlaceholder = textareaWithPlaceholders.getAttribute("data-placeholder-hotline-usual");
        postponedAssertTrue(StringUtils.containsIgnoreCase(message, attributePlaceholder),
                "Сообщение в форме отправки текста написано некоррекnно. Ожидалось вхождение строки:" +
                        attributePlaceholder + " в строку:" + message);
    }

    public void checkQuestionPlaceholderText(String message) {
        WebElement textareaWithPlaceholders = findElementByNoThrow(By.cssSelector("#message-form textarea"));
        if (textareaWithPlaceholders == null) {
            setPostponedTestFail("Не найдена форма отправки текста");
            return;
        }
        String attributePlaceholder = textareaWithPlaceholders.getAttribute("data-placeholder-hotline-newquestion");
        postponedAssertTrue(StringUtils.containsIgnoreCase(message, attributePlaceholder),
                "Сообщение в форме отправки текста написано некоррекnно. Ожидалось вхождение строки:" +
                        attributePlaceholder + " в строку:" + message);
    }

    public void checkExpertsAnswersArePresent() {
        List<WebElement> expertsAnswers = findElementsByNoThrow(By.cssSelector("section.answer"));
        if (expertsAnswers == null || expertsAnswers.size() == 0) {
            setPostponedTestFail("Не найдено ни одного ответа экспертов");
            return;
        }
        postponedAssertTrue(expertsAnswers.size() > 0, "Не найдено ни одного ответа экспертов или ответы экспертов " +
                "невидимы");
    }
}
