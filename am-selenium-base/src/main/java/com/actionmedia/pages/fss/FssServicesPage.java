package com.actionmedia.pages.fss;

import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.autotest.selenium.context.ComponentProvider;
import com.actionmedia.components.Link;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.RightPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 05.11.13
 * Time: 10:54
 */
@Component
public class FssServicesPage extends FssBasePage<FssServicesPage> implements ComponentProvider {

    private RightPanel rightPanel;

    @Override
    public void handleRedirect() {
        super.handleRedirect();
        rightPanel = getHelper(RightPanel.class, this);
    }

    @Step("Проверяются элементы на странице 'Сервисы'")
    public FssServicesPage checkDefaultStateServicesPage() {
        checkServicesTabIsSelected();
        checkSearchBoxPresentOnDictionaryPage();
        checkServicesBlockIsPresent();
        checkServicesBlockIsNotEmpty();
        checkHeaderDefaultState();
        checkNewsBlockIsPresent();
        checkNewsBlockIsNotEmpty();
        checkRubricatorMenuIsPresent();
        checkRubricatorMenuIsNotEmpty();
        checkPopularBlockIsPresent();
        checkPopularBlockIsNotEmpty();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Сервисы'")
    public FssServicesPage checkServicesTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.FSS_SERVICES);
        return this;
    }

    @Step("Проверяется заголовок страницы 'Сервисы'")
    public FssServicesPage checkHeaderDefaultState() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement header = findElementByNoThrow(content, By.cssSelector(".doc-header"));
        assertNotNull(header, "Заголовок страницы 'Сервисы' не найден");
        postponedAssertTrue(header.isDisplayed(), "Заголовок страницы 'Сервисы' не отображается");
        postponedAssertEquals(header.getText().trim(), "СЕРВИСЫ", "Неправильный текст заголовка страницы 'Сервисы'");
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Сервисы'")
    public FssServicesPage checkSearchBoxPresentOnDictionaryPage() {
        checkSearchBoxIsPresent("");
        return this;
    }

    @Step("Проверяется что Блок Сервисы отображается")
    public FssServicesPage checkServicesBlockIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("main-article"));
        WebElement servicesBlock = findElementByNoThrow(content, By.cssSelector(".services-startpage"));
        assertNotNull(servicesBlock, "Блок Сервисы не найден");
        postponedAssertTrue(servicesBlock.isDisplayed(), "Блок Сервисы не отображается");
        return this;
    }

    @Step("Проверяется что Блок Сервисы не пустой")
    public FssServicesPage checkServicesBlockIsNotEmpty() {
        WebElement servicesBlock = waitForVisibilityOfElementLocatedBy(By.cssSelector(".services-startpage"));
        List<WebElement> servicesList = servicesBlock.findElements(By.cssSelector(".b-news"));
        postponedAssertFalse(servicesList.isEmpty(), "Блок Сервисы пустой");
        return this;
    }

    @Step("Проверяется что блок Новое на странице 'Сервисы' отображается")
    public FssServicesPage checkNewsBlockIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement newsBlock = findElementByNoThrow(content, By.id("main-article"));
        assertNotNull(newsBlock, "Блок Новое на странице 'Сервисы' не найден");
        postponedAssertTrue(newsBlock.isDisplayed(), "Блок Новое на странице 'Сервисы' не отображается");
        return this;
    }

    @Step("Проверяется что блок Новое на странице 'Сервисы' не пустой")
    public FssServicesPage checkNewsBlockIsNotEmpty() {
        WebElement newsBlock = waitForVisibilityOfElementLocatedBy(By.id("main-article"));
        List<WebElement> newsItemList = newsBlock.findElements(By.cssSelector(".b-news"));
        postponedAssertFalse(newsItemList.isEmpty(), "Блок Новое на странице 'Сервисы' пустой");
        return this;
    }

    @Step("Проверяется что меню Рубрикатора на странице 'Сервисы' отображается")
    public FssServicesPage checkRubricatorMenuIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement rubricatorMenu = findElementByNoThrow(content, By.id("sidebar"));
        assertNotNull(rubricatorMenu, "Меню Рубрикатора на странице 'Сервисы' не найдено");
        postponedAssertTrue(rubricatorMenu.isDisplayed(), "Меню Рубрикатора на странице 'Сервисы' не отображается");
        return this;
    }

    @Step("Проверяется что меню Рубрикатора на странице 'Сервисы' не пустое")
    public FssServicesPage checkRubricatorMenuIsNotEmpty() {
        List<WebElement> newsItemList = sidebarElement.findElements(By.tagName("li"));
        postponedAssertFalse(newsItemList.isEmpty(), "Меню Рубрикатора на странице 'Сервисы' пустое");
        return this;
    }

    @Step("Проверяется что правая панель на странице 'Сервисы' отображается")
    public FssServicesPage checkPopularBlockIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement rubricatorMenu = findElementByNoThrow(content, By.id("aside"));
        assertNotNull(rubricatorMenu, "Правая панель на странице 'Сервисы' не найдена");
        postponedAssertTrue(rubricatorMenu.isDisplayed(), "Правая панель на странице 'Сервисы' не отображается");
        return this;
    }

    @Step("Проверяется что правая панель на странице 'Сервисы' не пустая")
    public FssServicesPage checkPopularBlockIsNotEmpty() {
        WebElement newsBlock = getCollapsedRightPanel();
        List<WebElement> newsItemList = newsBlock.findElements(By.cssSelector(".go"));
        postponedAssertFalse(newsItemList.isEmpty(), "Правая панель на странице 'Сервисы' пустая");
        return this;
    }

    @Step("Проверяется работа ссылок из Блока Сервисы")
    public FssServicesPage checkLinksFromServicesBlock() {
        WebElement servicesBlock = waitForVisibilityOfElementLocatedBy(By.cssSelector(".services-startpage"));
        List<WebElement> servicesItemsList = servicesBlock.findElements(By.cssSelector(".service-news-preview"));
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement serviceItem : servicesItemsList) {
            String url = serviceItem.findElement(By.tagName("a")).getAttribute("href");
            String header = serviceItem.findElement(By.tagName("a")).getText();
            Link link = new Link(url, header);
            linkList.add(link);
        }
        checkLinks(linkList);
        return this;
    }

    public FssServicesPage checkDateAreSortedDescending() {
        getHelper(FssHelpers.class).checkDateAreSortedDescending();
        return this;
    }

    public FssServicesPage checkNewsBlockAreNotRepeat() {
        getHelper(FssHelpers.class).checkNewsBlockAreNotRepeat();
        return this;
    }

    public FssServicesPage checkNewsAreNotEmpty() {
        getHelper(FssHelpers.class).checkNewsAreNotEmpty();
        return this;
    }

    public FssServicesPage clickExtendPopularBlock() {
        getHelper(FssHelpers.class).clickExtendPopularBlock();
        return this;
    }

    @Step("Открыть раздел Популярное в правой панели")
    public FssServicesPage clickAdditionalTab() {
        rightPanel.clickAdditionalTabInExpanded();
        return this;
    }

    @Step("Открыть раздел Просмотренное в правой панели")
    public FssServicesPage clickExampleTab() {
        rightPanel.clickExampleTabInExpanded();
        return this;
    }

    @Step("Закрыть правую панель")
    public FssServicesPage closePopularBlock() {
        rightPanel.closePopularBlock();
        return this;
    }

    @Step("Проверяется работа ссылок из раздела Просмотренное в правой панели")
    public FssServicesPage checkRandomLinksFromExpandedAdditionalBlock() {
        clickExtendPopularBlock();
        clickExampleTab();
        List<Link> linkList = getRandomElementsInList(rightPanel.getLinks(), 3);
        for (Link link : linkList) {
            checkLink(link);
            clickExtendPopularBlock();
            clickExampleTab();
        }
        return this;
    }

    @Step("Проверяется работа ссылок из раздела Популярное в правой панели")
    public FssServicesPage checkRandomLinksFromExpandedExamplesBlock() {
        clickExtendPopularBlock();
        clickAdditionalTab();
        List<Link> linkList = getRandomElementsInList(rightPanel.getLinks(), 3);
        for (Link link : linkList) {
            checkLink(link);
            clickExtendPopularBlock();
            clickAdditionalTab();
        }
        return this;
    }

    @Step("Проверяется свернутая правая панель")
    public FssServicesPage checkCollapsedRightPanel() {
        clickExtendPopularBlock();

        rightPanel.clickAdditionalTabInCollapsed();
        rightPanel.checkAdditionalTabInCollapsedIsOpened();
        rightPanel.checkAdditionalTabInCollapsedIsNotEmpty();

        rightPanel.clickExampleTabInCollapsed();
        rightPanel.checkExampleTabInCollapsedIsOpened();
        rightPanel.checkExampleTabInCollapsedIsNotEmpty();

        rightPanel.clickAdditionalTabInCollapsed();
        rightPanel.checkAdditionalTabInCollapsedIsOpened();
        rightPanel.checkAdditionalTabInCollapsedIsNotEmpty();

        rightPanel.clickExampleTabInCollapsed();
        rightPanel.checkExampleTabInCollapsedIsOpened();
        rightPanel.checkExampleTabInCollapsedIsNotEmpty();
        return this;
    }

    @Step("Проверяется правая панель")
    public FssServicesPage checkExpandedRightPanel() {
        clickExtendPopularBlock();
        rightPanel.checkPanelIsExpanded();

        rightPanel.clickAdditionalTabInExpanded();
        rightPanel.checkAdditionalTabInExpandedIsOpened();
        rightPanel.checkActiveTabInExpandedIsNotEmpty();

        rightPanel.clickExampleTabInExpanded();
        rightPanel.checkExampleTabInExpandedIsOpened();
        rightPanel.checkActiveTabInExpandedIsNotEmpty();

        rightPanel.clickAdditionalTabInExpanded();
        rightPanel.checkAdditionalTabInExpandedIsOpened();
        rightPanel.checkActiveTabInExpandedIsNotEmpty();

        rightPanel.clickExampleTabInExpanded();
        rightPanel.checkExampleTabInExpandedIsOpened();
        rightPanel.checkActiveTabInExpandedIsNotEmpty();
        return this;
    }

    @Step("Проверяется работа ссылок из вкладки Дополнительно свернутой правой панели")
    public FssServicesPage checkRandomLinksFromCollapsedAdditionalTab() {
        rightPanel.clickAdditionalTabInCollapsed();
        checkLinks(rightPanel.getLinksFromCollapsedTabByName("Дополнительно"));
        return this;
    }

    @Step("Проверяется работа ссылок из вкладки Примеры свернутой правой панели")
    public FssServicesPage checkRandomLinksFromCollapsedExampleTab() {
        rightPanel.clickAdditionalTabInCollapsed();
        checkLinks(rightPanel.getLinksFromCollapsedTabByName("Примеры"));
        return this;
    }
}
