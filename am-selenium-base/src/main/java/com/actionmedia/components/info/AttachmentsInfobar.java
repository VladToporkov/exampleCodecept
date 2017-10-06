package com.actionmedia.components.info;

import com.actionmedia.base.BasePage;
import com.actionmedia.util.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.net.HttpURLConnection;
import java.util.List;

/**
 * Created by Alex on 26.05.2016 026.
 */
@Component
public class AttachmentsInfobar extends BasePage<AttachmentsInfobar> {

    @FindBy(id = "infobar-attachment")
    private WebElement infoBar;

    /**
     * Агрегирующий метод для проверки n первых текстов и расширений, а также их ссылок..
     */
    @Step("Проверить несколько первых приложений в инфобаре: наличие, стили, расширения.")
    public void checkAllApplicationsArePresent() {
        List<WebElement> applications = findElementsByNoThrow(infoBar, By.tagName("li"));
        if (applications != null) {
            checkApplicationsTextsArePresent();
            checkApplicationsExtensionsArePresent();
            checkAttachedFilesAreAvailable();
        } else {
            warning("Инфобар пуст");
            setPostponedTestFail("Инфобар пуст");
        }
    }

    /**
     * Метод проверки текстов приложений и их CSS-стилей. Текстам главное, чтобы не были пусты.
     */
    @Step("Проверить тексты приложений: наличие и стили.")
    public void checkApplicationsTextsArePresent() {
        List<WebElement> applications = findElementsByNoThrow(infoBar, By.tagName("li"));
        if (applications != null) {
            for (WebElement application : applications) {
                WebElement textElement = application.findElement(By.tagName("a"));

                String color = textElement.getCssValue("color");
                String fontFamily = textElement.getCssValue("font-family");
                String fontSize = textElement.getCssValue("font-size");

                postponedAssertFalse(textElement.getText().isEmpty(), "Текста ссылки нет");
                if (getSettings().isRunFss()) {
                    postponedAssertEquals(color, "rgba(0, 0, 0, 1)", "Неверно вычислен цвет текста.");
                } else {
                    postponedAssertEquals(color, "rgba(43, 121, 217, 1)", "Неверно вычислен цвет текста.");
                }
                postponedAssertTrue(fontFamily.equals("Arial,Helvetica,sans-serif") || fontFamily.equals("Arial, Helvetica, sans-serif"), "Неверный шрифт текста.");
                postponedAssertEquals(fontSize, "13px", "Неверный размер текста.");
            }
        } else {
            warning("Инфобар пуст");
            setPostponedTestFail("Инфобар пуст");
        }
    }

    /**
     * Проверяется доступность приложений по указанным в них ссылках в инфобаре Приложения.
     */
    @Step("Проверить доступность нескольких файлов приложений.")
    public void checkAttachedFilesAreAvailable() {
        List<WebElement> applications = findElementsByNoThrow(infoBar, By.tagName("li"));

        if (applications != null) {
            for (WebElement application : applications) {
                String urlExtension = application.findElement(By.tagName("a")).getAttribute("href");
                int responseCode = TestUtils.getUrlResponseCode(urlExtension);
                postponedAssertEquals(responseCode, HttpURLConnection.HTTP_OK, "неверный ответ сервера по ссылке на приложение. Сервер вернул : " + responseCode);
            }
        } else {
            warning("Инфобар пуст");
            setPostponedTestFail("Инфобар пуст");
        }
    }

    /**
     * Метод проверяет надпись-расширение возле каждого прилежния и ее CSS-стили.
     */
    @Step("Проверить расширения нескольких приложений: наличие и стили.")
    public void checkApplicationsExtensionsArePresent() {
        List<WebElement> applications = findElementsByNoThrow(infoBar, By.tagName("li"));

        if (applications != null) {
            for (WebElement application : applications) {
                WebElement extensionElement = application.findElement(By.className("extension"));

                String backgroundColor = extensionElement.getCssValue("background-color");
                String color = extensionElement.getCssValue("color");
                String fontFamily = extensionElement.getCssValue("font-family");
                String fontSize = extensionElement.getCssValue("font-size");
                String extension = extensionElement.getText();

                postponedAssertTrue(extension.equals(".DOC") || extension.equals(".XLS"), "Расширение неизвестного типа или отсутствует. Найдено:" + extensionElement.getText());
                postponedAssertTrue(backgroundColor.equals("rgba(0, 83, 158, 1)") || backgroundColor.equals("rgba(46, 155, 0, 1)"), "Неверно вычислен цвет заливки. Найден:" + backgroundColor);
                postponedAssertEquals(color, "rgba(255, 255, 255, 1)", "Неверно вычислен цвет текста расширения. Найден:" + color);
                postponedAssertTrue(fontFamily.equals("Arial,Helvetica,sans-serif") || fontFamily.equals("Arial, Helvetica, sans-serif"), "Неверно вычислен шрифт текста расширения.");
                postponedAssertEquals(fontSize, "11px", "Неверно вычислен размер текста расширения.");
            }
        } else {
            warning("Инфобар пуст");
            setPostponedTestFail("Инфобар пуст");
        }
    }
}
