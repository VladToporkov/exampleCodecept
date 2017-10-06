package com.actionmedia.pages.uss;

import com.actionmedia.components.Link;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 28.10.13
 * Time: 12:15
 */
@Component
public class UssServicesPage extends UssBasePage<UssServicesPage> {

    @Step("Проверяются элементы на странице 'Сервисы'")
    public UssServicesPage checkDefaultStateServicesPage() {
        checkServicesTabIsSelected();
        checkSearchBoxPresentOnWizardsPage();
        checkWizardsBlockIsPresent();
        checkPopularBlockIsPresent();
        checkServiceRubricatorButtonIsPresent();
        checkMyFavoritesRubricatorButtonIsPresent();
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Сервисы'")
    public UssServicesPage checkSearchBoxPresentOnWizardsPage() {
        checkSearchBoxIsPresent("Поиск по сервисам");
        return this;
    }

    @Step("Проверяется кнопка рубрикатора сервисов присутсвует")
    public UssServicesPage checkServiceRubricatorButtonIsPresent() {
        WebElement rubricatorButton = waitForPresenceOfElementLocatedBy(By.id("rubricator-btn"), "Кнопка Все мастера Отсутствует");
        postponedAssertEquals(rubricatorButton.getText(), "Все сервисы", "Неправильный текст кнопки Все мастера");
        return this;
    }

    @Step("Проверяется что пользователь авторизован, в правом верхнем углу отображается его имя и фамилия")
    public UssServicesPage checkUserInfoLinkIsPresent() {
        WebElement header = waitForPresenceOfElementLocatedBy(By.cssSelector(".qd-doccontrol-buttons"), "Заголовок не найден");
        WebElement userInfoLink = findElementByNoThrow(header, By.cssSelector("[title='Мои данные']"));
        postponedAssertNotNull(userInfoLink, "Поле Имя и фамилия пользователя не найдено");
        if (userInfoLink != null) {
            postponedAssertTrue(userInfoLink.isDisplayed(), "Поле Имя и фамилия пользователя не отображается");
            postponedAssertFalse(userInfoLink.getText().isEmpty(), "Поле Имя и фамилия пользователя пустое");
        }
        return this;
    }

    @Step("Проверяется что открыта страница 'Конструктор договоров'")
    public UssServicesPage checkKDPageIsOpened() {
        String currentUrl = getDriver().getCurrentUrl();
        postponedAssertTrue(currentUrl.contains("constructor"), "Страница 'Конструктор договоров' не открыта");
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Сервисы'")
    public UssServicesPage checkServicesTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.SERVICES);
        return this;
    }

    @Step("Проверяется что кнопка 'Выход' отображается")
    public UssServicesPage checkLogoutButtonIsPresent() {
        WebElement header = waitForVisibilityOfElementLocatedBy(By.cssSelector(".qd-doccontrol-buttons"), "Заголовок не найден");
        WebElement loginButton = findElementByNoThrow(header, By.cssSelector(".action-exit"));
        postponedAssertNotNull(loginButton, "Кнопка 'Выход' не найдена");
        if (loginButton != null) {
            postponedAssertTrue(loginButton.isDisplayed(), "Кнопка 'Выход' не отображается");
        }
        return this;
    }

    @Step("Проверяется что кнопка 'Войти' отображается")
    public UssServicesPage checkLoginButtonIsPresent() {
        WebElement header = waitForVisibilityOfElementLocatedBy(By.cssSelector(".qd-doccontrol-buttons"), "Заголовок не найден");
        WebElement loginButton = findElementByNoThrow(header, By.cssSelector("[title='Авторизация']"));
        postponedAssertNotNull(loginButton, "Кнопка 'Войти' не найдена");
        if (loginButton != null) {
            postponedAssertTrue(loginButton.isDisplayed(), "Кнопка 'Войти' не отображается");
        }
        return this;
    }

    @Step("Проверяется что сообщение 'Нет данных контрагентов' отображается")
    public UssServicesPage checkEmptyPartnersTextIsPresent() {
        WebElement doc = waitForPresenceOfElementLocatedBy(By.cssSelector(".qd-doccontrol-container"));
        WebElement partnersText = findElementByNoThrow(doc, By.cssSelector(".qd-catalog-empty-text"));
        postponedAssertNotNull(partnersText, "Сообщение 'Нет данных контрагентов' не найдено");
        if (partnersText != null) {
            postponedAssertTrue(partnersText.isDisplayed(), "Сообщение 'Нет данных контрагентов' не отображается");
            postponedAssertEquals(partnersText.getText(), "Нет данных контрагентов.", "Неправильный текст сообщения 'Нет данных контрагентов'");
        }
        return this;
    }

    @Step("Проверяется что окно с предупреждением об отсутствии доступа отображается")
    public UssServicesPage checkLoginAlertIsPresent() {
        WebElement doc = waitForPresenceOfElementLocatedBy(By.cssSelector(".qd-doccontrol-container"));
        WebElement alert = findElementByNoThrow(doc, By.cssSelector(".qd-auth-catalog-window"));
        postponedAssertNotNull(alert, "Окно с предупреждением об отсутствии доступа не найдено");
        if (alert != null) {
            postponedAssertTrue(alert.isDisplayed(), "Окно с предупреждением об отсутствии доступа не отображается");
        }
        return this;
    }

    @Step("Нажать на кнопку 'Выход'")
    public UssServicesPage clickLogoutLinkOnKDPage() {
        waitForPresenceOfElementLocatedBy(By.cssSelector(".action-exit"), "Кнопка 'Выход' не найдена").click();
        waitForReloadingPage();
        return this;
    }

    @Step("Нажать на кнопку 'Войти'")
    public LoginPage clickLoginLinkOnKDPage() {
        waitForPresenceOfElementLocatedBy(By.cssSelector("[title='Авторизация']"), "Кнопка 'Войти' не найдена").click();
        waitForReloadingPage();
        return redirectTo(LoginPage.class);
    }

    @Step("Нажать на кнопку 'Войти' в окне предупреждения")
    public LoginPage clickLoginLinkOnAlert() {
        WebElement alert = waitForPresenceOfElementLocatedBy(By.cssSelector(".qd-auth-catalog-window"), "Окно с предупреждением об отсутствии доступа не найдено");
        WebElement loginButton = findElementByNoThrow(alert, By.cssSelector(".qd-glb-btn-submit"));
        postponedAssertNotNull(loginButton, "Кнопка 'Войти' не найдена в окне предупреждения");
        if (loginButton != null) {
            loginButton.click();
        }
        return redirectTo(LoginPage.class);
    }

    @Step("Нажать на кнопку 'Контрагенты'")
    public UssServicesPage clickPartnersButtonButton() {
        WebElement partnersButton = waitForPresenceOfElementLocatedBy(By.xpath("//div[@class='editable-area' and text()='Контрагенты']"));
        partnersButton.click();
        waitForReloadingPage();

        partnersButton = waitForPresenceOfElementLocatedBy(By.xpath("//div[@class='editable-area' and text()='Контрагенты']"));
        partnersButton.click();
        waitForReloadingPage();
        return this;
    }

    @Step("Проверяется блока мастеров")
    public UssServicesPage checkWizardsBlockIsPresent() {
        List<WebElement> wizards = mainLeftElement.findElements(By.cssSelector("[href*='#/document/150/']"));
        postponedAssertFalse(wizards.isEmpty(), "Блок мастеров пустой");
        return this;
    }

    @Step("Проверяется работа ссылок в блоке Мастера")
    public UssServicesPage checkLinksForWizardsBlock() {
        List<WebElement> wizards = mainLeftElement.findElements(By.cssSelector("[href*='#/document/150/']"));
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement wizard : wizards) {
            linkList.add(new Link(wizard.getAttribute("href")));
        }
        checkLinks(linkList);
        return this;
    }

    @Step("Проверяется что блок Недавно открытые показан")
    public UssServicesPage checkPopularBlockIsPresent() {
        postponedAssertTrue(sidebarElement.isDisplayed() && sidebarElement.isEnabled(), "Блок Популярное не отображается");
        return this;
    }

    @Step("Проверяется что блок Недавно открытые не пустой")
    public UssServicesPage checkPopularBlockAreNotEmpty() {
        List<WebElement> popularForms = sidebarElement.findElements(By.cssSelector(".news__item"));
        postponedAssertFalse(popularForms.isEmpty(), "Блок Недавно открытые пуст");

        for (WebElement popularForm : popularForms) {
            postponedAssertFalse(popularForm.getText().isEmpty(), "Отсутствует текст для формы в блоке Недавно открытые");
        }
        return this;
    }

    @Step("Проверяется работа ссылок в блоке Недавно открытые")
    public UssServicesPage checkPopularWizardsLinks() {
        List<WebElement> popularForms = sidebarElement.findElements(By.cssSelector(".news__item"));
        List<Link> formLinks = new ArrayList<Link>();
        for (WebElement popularForm : popularForms) {
            String url = popularForm.findElement(By.tagName("a")).getAttribute("href");
            String header = popularForm.findElement(By.tagName("a")).getText();
            Link link = new Link(url, header);
            formLinks.add(link);
        }
        checkLinks(formLinks);
        return this;
    }

    @Step("Проверяется что лепестки присутсвуют")
    public UssServicesPage checkPetalBlocksIsPresent() {
        List<WebElement> petalFrameList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".petals"), "Блок с Лепестками не найден");
        for (WebElement petalFrame : petalFrameList) {
            List<WebElement> petalList = petalFrame.findElements(By.cssSelector("[class*='petal-']"));
            postponedAssertFalse(petalList.isEmpty(), "Блок лепестки пустой");
            postponedAssertTrue(petalList.get(0).isEnabled() && petalList.get(0).isDisplayed(), "Лепесток не отображается");
        }
        return this;
    }

    @Step("Проверяется работа ссылок для блока лепестков")
    public UssServicesPage checkLinksForPetalBlock() {
        List<WebElement> petalFrameList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".petals"), "Блок с Лепестками не найден");
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement petalFrame : petalFrameList) {
            List<WebElement> petalList = petalFrame.findElements(By.cssSelector("[class*='petal-']"));
            for (WebElement petal : petalList) {
                if (petal.isDisplayed()) {
                    String url = petal.findElement(By.tagName("a")).getAttribute("href");
                    String header = petal.findElement(By.tagName("a")).getText();
                    Link link = new Link(url, header);
                    linkList.add(link);
                }
            }
        }
        checkLinks(linkList);
        return this;
    }

    @Step("Открыть случайный документ из блока популярное")
    public UssServicesPage clickRandomDocumentLink() {
        WebElement popularContent = waitForPresenceOfElementLocatedBy(By.cssSelector(".petals-list"));
        List<WebElement> popularNews = new ArrayList<WebElement>();
        for (WebElement petal : popularContent.findElements(By.cssSelector("[class*='petal']"))) {
            if (petal.isDisplayed()) {
                popularNews.add(petal);
            }
        }
        getRandomElementInList(popularNews).findElement(By.tagName("a")).click();
        waitForReloadingPage();
        return this;
    }
}
