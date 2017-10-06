package com.actionmedia.pages.fss;

import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.autotest.selenium.context.ComponentProvider;
import com.actionmedia.components.Link;
import com.actionmedia.pages.RightPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 06.11.13
 * Time: 14:20
 */
@Component
public class FssMainPage extends FssBasePage<FssMainPage> implements ComponentProvider {

    private RightPanel rightPanel;

    private static final String FOOTER_DEALER_EXPECTED_TEXT = "OOO «Актион-диджитал». Единый сервисный центр\n" +
            "ул. Новодмитровская, д. 5A, стр. 8, 8 800 333-01-15\n" +
            "www.1fd.ru\n" +
            "tp@1fd.ru\n" +
            "Все партнеры";
    private static final String FOOTER_HELP_EXPECTED_TEXT = "Служба поддержки\n" +
            "8 800 333-01-15\n" +
            "с 9 до 18 по Москве\n" +
            "tp@1fd.ru";
    private static final String FOOTER_COPYRIGHT_EXPECTED_TEXT = "© Актион-диджитал. 2011 —  2014\n" +
            "Стать партнером\n" +
            "Интерфейс спроектирован в Greensight";

    @Override
    public void handleRedirect() {
        super.handleRedirect();
        rightPanel = getHelper(RightPanel.class, this);
    }

    @Step("Проверяются элементы на главной странице")
    public FssMainPage checkDefaultStateMainPage() {
        checkItemIsNotSelected();
        checkSearchBoxPresentOnMainPage();

        checkSolutionsBlockIsPresent();
        checkSolutionsBlockIsNotEmpty();
        checkBreadcrumbInSolutionsBlockIsNotEmpty();

        checkFormsWidgetIsPresent();
        checkFormsWidgetIsNotEmpty();

        checkMagazinesWidgetIsPresent();
        checkMagazinesWidgetIsNotEmpty();

        checkLawBaseWidgetIsPresent();
        checkLawBaseWidgetIsNotEmpty();

        checkVideoWidgetIsPresent();
        checkVideoWidgetIsNotEmpty();

        checkDictionaryWidgetIsPresent();
        checkDictionaryWidgetIsNotEmpty();

        checkRightPanelBlockIsPresent();
        checkRightPanelBlockIsNotEmpty();
        return this;
    }

    @Step("Проверяется поисковая строка на Главной странице")
    public FssMainPage checkSearchBoxPresentOnMainPage() {
        checkSearchBoxIsPresent("Поиск решений");
        return this;
    }

    @Step("Проверяется что блок Решения на Главной странице отображается")
    public FssMainPage checkSolutionsBlockIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement solutionsBlock = findElementByNoThrow(content, By.cssSelector(".wide-column"));
        assertNotNull(solutionsBlock, "Блок Решения на Главной странице не найден");
        postponedAssertTrue(solutionsBlock.isDisplayed(), "Блок Решения на Главной странице не отображается");
        return this;
    }

    @Step("Проверяется что блок Решения не пустой")
    public FssMainPage checkSolutionsBlockIsNotEmpty() {
        WebElement solutionsBlock = waitForVisibilityOfElementLocatedBy(By.cssSelector(".wide-column"));
        WebElement solutions = solutionsBlock.findElement(By.cssSelector(".unequal"));
        postponedAssertFalse(solutions.getText().isEmpty(), "Блок Решения на Главной странице пустой");
        postponedAssertEquals(solutions.findElement(By.cssSelector(".caps")).findElement(By.tagName("a")).getText(), "РЕШЕНИЯ", "Неправильный текст заголовка для блока Решения");
        return this;
    }

    @Step("Проверяется что блок Хлебных крошек не пустой")
    public FssMainPage checkBreadcrumbInSolutionsBlockIsNotEmpty() {
        WebElement solutionsBlock = waitForVisibilityOfElementLocatedBy(By.cssSelector(".wide-column"));
        WebElement breadcrumbBlock = solutionsBlock.findElement(By.cssSelector(".under"));
        List<WebElement> breadcrumbList = breadcrumbBlock.findElements(By.tagName("li"));
        postponedAssertFalse(breadcrumbList.isEmpty(), "Блок Хлебных крошек в Решении на Главной странице пустой");
        return this;
    }

    @Step("Проверяется что виджет Положения и регламенты на Главной странице отображается")
    public FssMainPage checkFormsWidgetIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement formsWidget = findElementByNoThrow(content, By.cssSelector(".forms"));
        assertNotNull(formsWidget, "Виджет Положения и регламенты на Главной странице не найден");
        postponedAssertTrue(formsWidget.isDisplayed(), "Виджет Положения и регламенты на Главной странице не отображается");
        return this;
    }

    @Step("Проверяется что виджет Положения и регламенты на Главной странице не пустой")
    public FssMainPage checkFormsWidgetIsNotEmpty() {
        WebElement formsWidget = waitForVisibilityOfElementLocatedBy(By.cssSelector(".forms"));
        List<WebElement> formsLink = formsWidget.findElements(By.tagName("a"));
        postponedAssertFalse(formsLink.isEmpty(), "Виджет Положения и регламенты на Главной странице пустой");
        postponedAssertEquals(formsWidget.findElement(By.cssSelector(".caps")).findElement(By.tagName("a")).getText(), "ПОЛОЖЕНИЯ И РЕГЛАМЕНТЫ", "Неправильный текст заголовка для виджета Положения и регламенты");
        return this;
    }

    @Step("Проверяется что виджет Библиотека на Главной странице отображается")
    public FssMainPage checkMagazinesWidgetIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement magazinesWidget = findElementByNoThrow(content, By.cssSelector(".press"));
        assertNotNull(magazinesWidget, "Виджет Библиотека на Главной странице не найден");
        postponedAssertTrue(magazinesWidget.isDisplayed(), "Виджет Библиотека на Главной странице не отображается");
        return this;
    }

    @Step("Проверяется что виджет Библиотека на Главной странице не пустой")
    public FssMainPage checkMagazinesWidgetIsNotEmpty() {
        WebElement pressWidget = waitForVisibilityOfElementLocatedBy(By.cssSelector(".press"));
        List<WebElement> pressLink = pressWidget.findElements(By.cssSelector(".page"));
        postponedAssertFalse(pressLink.isEmpty(), "Виджет Библиотека на Главной странице пустой");
        postponedAssertEquals(pressWidget.findElement(By.cssSelector(".caps")).findElement(By.tagName("a")).getText(), "БИБЛИОТЕКА", "Неправильный текст заголовка для виджета Библиотека");
        return this;
    }

    @Step("Проверяется что виджет Правовая База на Главной странице отображается")
    public FssMainPage checkLawBaseWidgetIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement lawBaseWidget = findElementByNoThrow(content, By.cssSelector(".box"));
        assertNotNull(lawBaseWidget, "Виджет Правовая База на Главной странице не найден");
        postponedAssertTrue(lawBaseWidget.isDisplayed(), "Виджет Правовая База на Главной странице не отображается");
        return this;
    }

    @Step("Проверяется что виджет Правовая База на Главной странице не пустой")
    public FssMainPage checkLawBaseWidgetIsNotEmpty() {
        WebElement lawBaseWidget = waitForVisibilityOfElementLocatedBy(By.cssSelector(".box"));
        List<WebElement> lawBaseWidgetLink = lawBaseWidget.findElements(By.tagName("a"));
        postponedAssertFalse(lawBaseWidgetLink.isEmpty(), "Виджет Правовая База на Главной странице пустой");
        postponedAssertEquals(lawBaseWidget.findElement(By.cssSelector(".caps")).findElement(By.tagName("a")).getText(), "ПРАВОВАЯ БАЗА", "Неправильный текст заголовка для виджета Правовая База");
        return this;
    }

    @Step("Проверяется что виджет Видео на Главной странице отображается")
    public FssMainPage checkVideoWidgetIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement videoWidget = findElementByNoThrow(content, By.cssSelector("div.video"));
        assertNotNull(videoWidget, "Виджет Видео на Главной странице не найден");
        postponedAssertTrue(videoWidget.isDisplayed(), "Виджет Видео на Главной странице не отображается");
        return this;
    }

    @Step("Проверяется что виджет Видео на Главной странице не пустой")
    public FssMainPage checkVideoWidgetIsNotEmpty() {
        WebElement videoWidget = waitForVisibilityOfElementLocatedBy(By.cssSelector("div.video"));
        List<WebElement> lawBaseWidgetLink = videoWidget.findElements(By.cssSelector(".page"));
        postponedAssertFalse(lawBaseWidgetLink.isEmpty(), "Виджет Видео на Главной странице пустой");
        postponedAssertEquals(videoWidget.findElement(By.cssSelector(".caps")).findElement(By.tagName("a")).getText(), "ВИДЕО", "Неправильный текст заголовка для виджета Видео");
        return this;
    }

    @Step("Проверяется что виджет Справочник на Главной странице отображается")
    public FssMainPage checkDictionaryWidgetIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        List<WebElement> dictionaryWidget = findElementsByNoThrow(content, By.cssSelector(".two-columns"));
        postponedAssertTrue(dictionaryWidget.size() > 1 && dictionaryWidget.get(1).isDisplayed(), "Виджет Справочник на Главной странице не отображается");
        return this;
    }

    @Step("Проверяется что виджет Справочник на Главной странице не пустой")
    public FssMainPage checkDictionaryWidgetIsNotEmpty() {
        WebElement dictionaryWidget = waitForVisibilityOfAllElementsLocatedBy(By.cssSelector(".two-columns")).get(1);
        List<WebElement> dictionaryWidgetLink = dictionaryWidget.findElements(By.tagName("a"));
        postponedAssertFalse(dictionaryWidgetLink.isEmpty(), "Виджет Справочник на Главной странице пустой");
        postponedAssertEquals(dictionaryWidget.findElement(By.cssSelector(".caps")).findElement(By.tagName("a")).getText(), "СПРАВОЧНИК", "Неправильный текст заголовка для виджета Справочник");
        return this;
    }

    @Step("Проверяется что Правая панель на Главной странице отображается")
    public FssMainPage checkRightPanelBlockIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement rubricatorMenu = findElementByNoThrow(content, By.id("aside"));
        assertNotNull(rubricatorMenu, "Правая панель на странице 'Решения' не найдена");
        postponedAssertTrue(rubricatorMenu.isDisplayed(), "Правая панель на странице 'Решения' не отображается");
        return this;
    }

    @Step("Проверяется что Правая панель на Главной странице не пустая")
    public FssMainPage checkRightPanelBlockIsNotEmpty() {
        WebElement newsBlock = getCollapsedRightPanel();
        List<WebElement> newsItemList = newsBlock.findElements(By.cssSelector(".go"));
        postponedAssertFalse(newsItemList.isEmpty(), "Правая панель на странице 'Решения' пустая");
        return this;
    }

    public FssMainPage clickExtendPopularBlock() {
        getHelper(FssHelpers.class).clickExtendPopularBlock();
        return this;
    }

    @Step("Открыть раздел Популярное в правой панели")
    public FssMainPage clickPopularTab() {
        rightPanel.clickPopularTabInExpanded();
        return this;
    }

    @Step("Открыть раздел Просмотренное в правой панели")
    public FssMainPage clickViewedTab() {
        rightPanel.clickViewedTabInExpanded();
        return this;
    }

    @Step("Открыть раздел Новое в работе в правой панели")
    public FssMainPage clickNewInWorkTab() {
        rightPanel.clickNewInWorkTabInExpanded();
        return this;
    }

    @Step("Закрыть правую панель")
    public FssMainPage closePopularBlock() {
        rightPanel.closePopularBlock();
        return this;
    }

    @Step("Проверяется работа ссылок из раздела Просмотренное в правой панели")
    public FssMainPage checkRandomLinksFromViewedBlock() {
        clickExtendPopularBlock();
        clickPopularTab();
        List<Link> linkList = getRandomElementsInList(rightPanel.getLinks(), 3);
        for (Link link : linkList) {
            checkLink(link);
            clickExtendPopularBlock();
            clickViewedTab();
        }
        return this;
    }

    @Step("Проверяется работа ссылок из раздела Популярное в правой панели")
    public FssMainPage checkRandomLinksFromPopularBlock() {
        clickExtendPopularBlock();
        clickViewedTab();
        List<Link> linkList = getRandomElementsInList(rightPanel.getLinks(), 3);
        for (Link link : linkList) {
            checkLink(link);
            clickExtendPopularBlock();
            clickPopularTab();
        }
        return this;
    }

    @Step("Проверяется работа ссылок из раздела Популярное в правой панели")
    public FssMainPage checkRandomLinksFromNewInWorkBlock() {
        clickExtendPopularBlock();
        clickNewInWorkTab();
        List<Link> linkList = getRandomElementsInList(rightPanel.getLinks(), 3);
        for (Link link : linkList) {
            checkLink(link);
            clickExtendPopularBlock();
            clickNewInWorkTab();
        }
        return this;
    }

    @Step("Проверяются фильтры в правой панели")
    public FssMainPage checkFiltersInRightPanel() {
        clickExtendPopularBlock();
        clickPopularTab();
        rightPanel.checkSectionFilter();

        clickViewedTab();
        rightPanel.checkDateFilters();
        return this;
    }

    @Step("Проверяется что картинки для журналов/книг загруженны")
    public FssMainPage checkMagazinesContent() {
        clickExtendPopularBlock();
        clickPopularTab();
        rightPanel.checkContentForMagazinesAndBooks();

        clickViewedTab();
        rightPanel.checkContentForMagazinesAndBooks();

        clickNewInWorkTab();
        rightPanel.checkContentForMagazinesAndBooks();
        return this;
    }

    @Step("Проверяется работа ссылок в блоке Решения")
    public FssMainPage checkSolutionsLinks() {
        WebElement solutionsBlock = waitForVisibilityOfElementLocatedBy(By.cssSelector(".solutions"));
        List<WebElement> columnList = solutionsBlock.findElements(By.cssSelector(".column"));
        List<Link> linkList = new ArrayList<Link>();

        WebElement solutionsLink = columnList.get(0).findElement(By.tagName("a"));
        String solutionUrl = solutionsLink.getAttribute("href");
        String solutionHeader = solutionsLink.getAttribute("href");
        linkList.add(new Link(solutionUrl, solutionHeader));

        List<WebElement> withThisSolutionsLinkList = columnList.get(1).findElements(By.cssSelector(".go"));
        postponedAssertFalse(withThisSolutionsLinkList.isEmpty(), "Отсутсвуют ссылки в блоке Вместе с этим решением");
        for (WebElement withThisSolutionLink : withThisSolutionsLinkList) {
            String url = withThisSolutionLink.getAttribute("href");
            String header = withThisSolutionLink.getText();
            Link link = new Link(url, header);
            linkList.add(link);
        }
        checkLinks(linkList);
        return this;
    }

    @Step("Проверяется работа ссылок из блока Все Решения")
    public FssMainPage checkBreadcrumbLinks() {
        WebElement solutionsBlock = waitForVisibilityOfElementLocatedBy(By.cssSelector(".wide-column"));
        WebElement breadcrumbBlock = solutionsBlock.findElement(By.cssSelector(".under"));
        WebElement moreLink = breadcrumbBlock.findElement(By.cssSelector(".more"));
        moreLink.click();
        List<WebElement> breadcrumbLinkList = breadcrumbBlock.findElements(By.cssSelector(".black"));
        for (WebElement breadcrumbLink : breadcrumbLinkList) {
            String breadcrumbLinkName = breadcrumbLink.getText();
            report("Открывается " + breadcrumbLinkName);
            breadcrumbLink.click();
            WebElement rubricator = waitForVisibilityOfElementLocatedBy(By.id("rubricator"), "Рубрикатор не найден");
            WebElement rubricatorMenu = waitForVisibilityOfElementLocatedBy(By.cssSelector(".b-menu"), "Меню рубрикатора не найдено");
            WebElement selectedItem = rubricatorMenu.findElement(By.cssSelector(".selected"));
            postponedAssertTrue(waitForTextToBePresentIn(selectedItem, breadcrumbLinkName), "Ожидается: " + breadcrumbLinkName + "Открыт: " + selectedItem.findElement(By.tagName("a")).getText());
            List<WebElement> sectionList = selectedItem.findElement(By.cssSelector(".b-menu")).findElements(By.tagName("li"));
            WebElement firstSection = sectionList.get(0);
            postponedAssertTrue(firstSection.getAttribute("class") != null && "selected".equals(firstSection.getAttribute("class")), "В рубрикаторе выбран не первый раздел");
            rubricator.findElement(By.cssSelector("[data-close='true']")).click();
        }
        return this;
    }

    @Step("Проверяется что ссылка в блоке Решения открывает страницу Решения")
    public FssMainPage checkSolutionsLinkIsOpenedSolutionsPage() {
        WebElement solutionsBlock = waitForVisibilityOfElementLocatedBy(By.cssSelector(".solutions"));
        WebElement headerLink = solutionsBlock.findElement(By.cssSelector(".caps")).findElement(By.tagName("a"));
        headerLink.click();
        return redirectTo(FssSolutionsPage.class)
                .checkSolutionsPageIsOpened()
                .navigateToMainPage();
    }

    @Step("Проверяется что ссылка в блоке Положения и регламенты открывает страницу Положения и регламенты")
    public FssMainPage checkFormsLinkIsOpenedFormsPage() {
        WebElement formsBlock = waitForVisibilityOfElementLocatedBy(By.cssSelector(".two-columns"));
        WebElement headerLink = formsBlock.findElement(By.cssSelector(".caps")).findElement(By.tagName("a"));
        headerLink.click();
        return redirectTo(FssFormsPage.class)
                .checkFormsPageIsOpened()
                .navigateToMainPage();
    }

    @Step("Проверяется что ссылка в блоке Библиотека открывает страницу Библиотека")
    public FssMainPage checkMagazinesLinkIsOpenedMagazinesPage() {
        WebElement magazinesBlock = waitForVisibilityOfElementLocatedBy(By.cssSelector(".press"));
        WebElement headerLink = magazinesBlock.findElement(By.cssSelector(".caps")).findElement(By.tagName("a"));
        headerLink.click();
        return redirectTo(FssMagazinesPage.class)
                .checkMagazinesPageIsOpened()
                .navigateToMainPage();
    }

    @Step("Проверяется что ссылка в блоке Правовая База открывает страницу Правовая База")
    public FssMainPage checkLawBaseLinkIsOpenedLawBasePage() {
        WebElement lawBaseBlock = waitForVisibilityOfElementLocatedBy(By.cssSelector(".box"));
        WebElement headerLink = lawBaseBlock.findElement(By.cssSelector(".caps")).findElement(By.tagName("a"));
        headerLink.click();
        return redirectTo(FssLawBasePage.class)
                .checkLawBasePageIsOpened()
                .navigateToMainPage();
    }

    @Step("Проверяется что ссылка в блоке Видео открывает страницу Видео")
    public FssMainPage checkVideoLinkIsOpenedVideoPage() {
        WebElement videoBlock = waitForVisibilityOfElementLocatedBy(By.cssSelector("div.video"));
        WebElement headerLink = videoBlock.findElement(By.cssSelector(".caps")).findElement(By.tagName("a"));
        headerLink.click();
        return redirectTo(FssVideosPage.class)
                .checkVideosPageIsOpened()
                .navigateToMainPage();
    }

    @Step("Проверяется что ссылка в блоке Справочник открывает страницу Справочник")
    public FssMainPage checkDictionaryLinkIsOpenedDictionaryPage() {
        List<WebElement> dictionaryWidget = waitForVisibilityOfAllElementsLocatedBy(By.cssSelector(".two-columns"));
        WebElement dictionaryBlock = dictionaryWidget.get(1);
        WebElement headerLink = dictionaryBlock.findElement(By.cssSelector(".caps")).findElement(By.tagName("a"));
        headerLink.click();
        return redirectTo(FssDictionaryPage.class)
                .checkDefaultStateDictionaryPage()
                .navigateToMainPage();
    }

    @Step("Проверяется что футер отображается")
    public FssMainPage checkFooterIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement footer = findElementByNoThrow(content, By.cssSelector(".m-footer"));
        postponedAssertNotNull(footer, "Футер не найден");
        checkElementIsDisplayed(footer, "Футер не отображается");
        if (footer != null) {
            postponedAssertFalse(footer.getText().isEmpty(), "Отсутствует текст в футере");
        }
        return this;
    }

    @Step("Проверяется информация в футере")
    public FssMainPage checkFooterInfo() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement footer = content.findElement(By.cssSelector(".m-footer"));
        String footerDealerActualText = footer.findElement(By.cssSelector(".b-dealer")).getText();
        String footerHelpActualText = footer.findElement(By.cssSelector(".b-help")).getText();
        String footerCopyrightActualText = footer.findElement(By.cssSelector(".b-copyright")).getText();

        postponedAssertEquals(footerDealerActualText, FOOTER_DEALER_EXPECTED_TEXT, "Неправильный текст информации о дилере в футере");
        postponedAssertEquals(footerHelpActualText, FOOTER_HELP_EXPECTED_TEXT, "Неправильный текст информации о Службе поддержки в футере");
        postponedAssertEquals(footerCopyrightActualText, FOOTER_COPYRIGHT_EXPECTED_TEXT, "Неправильный текст информации о копирайте в футере");
        return this;
    }

    @Step("Проверяется работа ссылок из футера")
    public FssMainPage checkLinksFromFooter() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement footer = content.findElement(By.cssSelector(".m-footer"));
        List<WebElement> linksElementList = footer.findElements(By.cssSelector("[href*='http://']"));
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement linkElement : linksElementList) {
            String url = linkElement.getAttribute("href");
            Link link = new Link(url);
            linkList.add(link);
        }
        checkLinks(linkList);
        return this;
    }

    @Step("Открыть решение из анонса на главной")
    public FssDocumentPage clickSolutionDocumentLink() {
        WebElement content = getPage();
        WebElement solution = content.findElement(By.cssSelector(".solutions"));
        WebElement document = solution.findElement(By.tagName("h2"));
        WebElement link = document.findElement(By.tagName("a"));
        link.click();
        return redirectTo(FssDocumentPage.class);
    }

}
