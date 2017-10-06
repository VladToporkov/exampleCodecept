package com.actionmedia.pages.bss;

import com.actionmedia.components.Link;
import com.actionmedia.components.MainMenuButtons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 11.10.13
 * Time: 9:38
 */
@Component
public class BssServicesPage extends BssBasePage<BssServicesPage> {

    @Step("Проеряются элементы на странице 'Сервисы'")
    public BssServicesPage checkDefaultStateServicesPage() {
        checkRecomendTabIsSelected();
        checkSearchBoxIsPresentOnServicesPage();
        checkReportIsPresent();
        checkCalculatorIsPresent();
        checkWizardsIsPresent();
        checkAllServicesButtonIsPresent();
        checkMyFavoritesRubricatorButtonIsPresent();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Сервисы'")
    public BssServicesPage checkRecomendTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.SERVICES);
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Сервисы'")
    public BssServicesPage checkSearchBoxIsPresentOnServicesPage() {
        checkSearchBoxIsPresent("");
        return this;
    }

    @Step("Проверяется что сервис Электронная отчетность отображается")
    public BssServicesPage checkReportIsPresent() {
        int sectionIndex = getIndexOfSectionByName("Электронная отчетность");
        postponedAssertTrue(sectionIndex != -1, "Сервис Электронная отчетность не найден");
        List<WebElement> sectionElements = getElementsOfSectionByName("Электронная отчетность");
        postponedAssertFalse(sectionElements.isEmpty(), "Сервис Электронная отчетность пустой");
        return this;
    }

    @Step("Проверяется что сервис Расчетчики отображается")
    public BssServicesPage checkCalculatorIsPresent() {
        int sectionIndex = getIndexOfSectionByName("Расчетчики");
        postponedAssertTrue(sectionIndex != -1, "Сервис Расчетчики не найден");
        List<WebElement> sectionElements = getElementsOfSectionByName("Расчетчики");
        postponedAssertFalse(sectionElements.isEmpty(), "Сервис Расчетчики пустой");
        return this;
    }

    @Step("Проверяется что сервис Налоговые мастера отображается")
    public BssServicesPage checkWizardsIsPresent() {
        int sectionIndex = getIndexOfSectionByName("Мастера");
        postponedAssertTrue(sectionIndex != -1, "Сервис Налоговые мастера не найден");
        List<WebElement> sectionElements = getElementsOfSectionByName("Мастера");
        postponedAssertFalse(sectionElements.isEmpty(), "Сервис Налоговые мастера пустой");
        return this;
    }

    @Step("Проверяется что кнопка Все сервисы отображается")
    public BssServicesPage checkAllServicesButtonIsPresent() {
        WebElement recomendButton = waitForVisibilityOfElementLocatedBy(By.id("rubricator-btn"), "Кнопка Все рекомендации не найдена");
        postponedAssertTrue(recomendButton.isEnabled() && recomendButton.isDisplayed(), "Кнопка Все рекомендации не найдена");
        postponedAssertEquals(recomendButton.getText(), "Все сервисы", "Неправильный текст кнопки Все рекомендации не найдена");
        return this;
    }

    @Step("Проверяется работа ссылки в сервисе Электронная отчетность")
    public BssServicesPage checkLinksFromReportSection() {
        WebElement reportLink = getRandomElementInList(getElementsOfSectionByName("Электронная отчетность")).findElement(By.tagName("a"));
        String url = reportLink.getAttribute("href").replace("http", "https");
        checkLink(new Link(url));
        return this;
    }

    @Step("Проверяется работа ссылки в сервисе Расчетчики")
    public BssServicesPage checkLinksFromCalculatorSection() {
        WebElement calculatorLink = getRandomElementInList(getElementsOfSectionByName("Расчетчики")).findElement(By.tagName("a"));
        String url = calculatorLink.getAttribute("href");
        String header = calculatorLink.getText();
        checkLink(new Link(url, header));
        return this;
    }

    @Step("Проверяется работа ссылки в сервисе Налоговые мастера")
    public BssServicesPage checkLinksFromWizardsSection() {
        List<WebElement> wizardLinkList = getRandomElementsInList(getElementsOfSectionByName("Мастера"), 3);
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement wizardLink : wizardLinkList) {
            String url = wizardLink.findElement(By.tagName("a")).getAttribute("href");
            String header = wizardLink.findElement(By.tagName("a")).getText();
            Link link = new Link(url, header);
            linkList.add(link);
        }
        checkLinks(linkList);
        return this;
    }

    @Step("Открыть случайный мастер со страницы сервисов")
    public BssDocumentPage clickRandomWizard() {
        List<WebElement> wizards = mainContentElement.findElements(By.cssSelector("[href*='#/document/150/']"));
        WebElement randomWizard = getRandomElementInList(wizards);
        report("Открывается мастер '" + randomWizard.getText() + "'");
        randomWizard.click();
        return redirectTo(BssDocumentPage.class);
    }

    private List<WebElement> getElementsOfSectionByName(String sectionName) {
        List<WebElement> elements = mainLeftElement.findElements(By.tagName("*"));
        List<WebElement> sectionElements = new ArrayList<WebElement>();
        for (int i = getIndexOfSectionByName(sectionName) + 1; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            if ("li".equals(element.getTagName())) {
                sectionElements.add(element);
            }
            if ("h2".equals(element.getTagName())) {
                break;
            }
        }
        return sectionElements;
    }

    private int getIndexOfSectionByName(String sectionName) {
        List<WebElement> elements = mainLeftElement.findElements(By.tagName("*"));
        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            if ("h2".equals(element.getTagName()) && element.getText().equals(sectionName)) {
                return i;
            }
        }
        return -1;
    }
}
