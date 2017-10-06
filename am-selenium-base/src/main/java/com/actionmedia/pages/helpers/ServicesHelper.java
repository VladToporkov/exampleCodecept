package com.actionmedia.pages.helpers;

import com.actionmedia.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

/**
 * Created by Pavel on 04/05/16.
 */
@Component
public class ServicesHelper<P extends BasePage> extends BasePage<P> {

    public static final String LINK_TITLE = "link.title";

    @Step("Проверить, что заголовок Сервисы отображается на странице")
    public void checkTitleServicesIsPresent() {
        WebElement titleServices = findElementByNoThrow(By.xpath("//h1[text()='Сервисы']"));
        postponedAssertTrue(titleServices != null && titleServices.isDisplayed(), "Заголовок Сервисы не найден");
    }

    @Step("Проверить, что отображается подзаголовок Расчетчики")
    public void checkCalculatorsTitleIsPresent() {
        WebElement calculatorsTitle = findElementByNoThrow(By.xpath("//h2[text()='Расчетчики']"));
        postponedAssertTrue(calculatorsTitle != null && calculatorsTitle.isDisplayed(), "Заголовок Расчетчики не найден");
    }

    @Step("Проверить, что отображается подзаголовок Конструкторы")
    public void checkConstructorsTitleIsPresent() {
        WebElement constructorsTitle = findElementByNoThrow(By.xpath("//h2[text()='Конструкторы']"));
        postponedAssertTrue(constructorsTitle != null && constructorsTitle.isDisplayed(), "Заголовок Конструкторы не найден");
    }

    @Step("Проверить, что отображается подзаголовок Тесты")
    public void checkTestsTitleIsPresent() {
        WebElement testsTitle = findElementByNoThrow(By.xpath("//h2[text()='Тесты']"));
        postponedAssertTrue(testsTitle != null && testsTitle.isDisplayed(), "Заголовок Тесты не найден");
    }

    @Step("Проверить, что отображается блок Популярное или Недавно открытые")
    public void checkRightBlockIsPresent() {
        WebElement rightBlock = findElementByNoThrow(By.cssSelector(".news_viewtype_old-school"));
        postponedAssertTrue(rightBlock != null && rightBlock.isDisplayed(), "Блок Популярное или Недавно открытые не отображается на странице");
    }

    @Step("Проверить, что отображается кнопка рубрикатора Все сервисы")
    public void checkAllServicesRubricatorButtonIsPresent() {
        WebElement rubricatorButton = findElementByNoThrow(By.id("rubricator-btn"));
        postponedAssertTrue(rubricatorButton != null && rubricatorButton.isDisplayed(), "Кнопка Рубрикатора Все сервисы не отображается");
        if (rubricatorButton != null) {
            postponedAssertEqualsText(rubricatorButton, "Все сервисы");
        }
    }

    @Step("Проверить, что отображается блок Расчетчики")
    public void checkCalculatorsBlockIsPresent() {
        List<WebElement> calculators = getCalculatorsLinks();
        postponedAssertTrue(calculators != null && !calculators.isEmpty(), "Расчетчики на странице не найдены. Возможно проблема работы селектора");
    }

    @Step("Проверить, что отображается блок Тесты и Конструкторы")
    public void checkTestsBlockIsPresent() {
        List<WebElement> tests = getTestsLinks();
        postponedAssertTrue(tests != null && !tests.isEmpty(), "Тесты на странице не найдены. Возможно проблема работы селектора");
    }

    @Step("Проверить, что отображается блок Конструкторы")
    public void checkConstructorsBlockIsPresent() {
        List<WebElement> tests = getConstructorsLinks();
        postponedAssertTrue(tests != null && !tests.isEmpty(), "Конструкторы на странице не найдены. Возможно проблема работы селектора");
    }

    @Step("Кликнуть по любой ссылке раздела Расчетчики")
    public void clickOnRandomCalculatorLink() {
        WebElement randomLink = getRandomElementInList(getCalculatorsLinks());
        setParameter(LINK_TITLE, randomLink.getText());
        setParameter(SearchResultHelper.DOCUMENT_URL, randomLink.getAttribute("href"));
        randomLink.click();
        waitForReloadingPage();
    }

    @Step("Кликнуть по любой ссылке раздела Тесты")
    public void clickOnRandomTestsLink() {
        WebElement randomLink = getRandomElementInList(getTestsLinks());
        setParameter(LINK_TITLE, randomLink.getText());
        setParameter(SearchResultHelper.DOCUMENT_URL, randomLink.getAttribute("href"));
        randomLink.click();
        waitForReloadingPage();
    }

    @Step("Кликнуть по любой ссылке раздела Недавно открытые/Популярные")
    public void clickOnRandomPopularLink() {
        WebElement randomLink = getRandomElementInList(getPopularOrRecentlyLinks());
        setParameter(LINK_TITLE, randomLink.getText());
        setParameter(SearchResultHelper.DOCUMENT_URL, randomLink.getAttribute("href"));
        randomLink.click();
        waitForReloadingPage();
    }

    @Step("Кликнуть по любой ссылке раздела Конструкторы")
    public void clickOnRandomConstructorsLink() {
        WebElement randomLink = getRandomElementInList(getConstructorsLinks());
        setParameter(LINK_TITLE, randomLink.getText());
        setParameter(SearchResultHelper.DOCUMENT_URL, randomLink.getAttribute("href"));
        randomLink.click();
        waitForReloadingPage();
    }

    @Step("Проверить все ссылки на странице Сервисы")
    public void checkAllLinks() {
        checkLinks();
    }

    private List<WebElement> getCalculatorsLinks() {
        return findElementsBy(By.xpath("//div[@class='main__in']/child::h2[2]/preceding-sibling::ul//a"));
    }

    private List<WebElement> getTestsLinks() {
        return findElementsBy(By.xpath("//div[@class='main__in']/child::h2[2]/following-sibling::ul//a"));
    }

    private List<WebElement> getPopularOrRecentlyLinks() {
        return findElementsBy(By.cssSelector(".news_viewtype_old-school .news__item a"));
    }

    private List<WebElement> getConstructorsLinks() {
        return findElementsBy(By.cssSelector(".list_type_articles a"));
    }
}
