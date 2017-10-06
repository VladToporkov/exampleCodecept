package com.actionmedia.pages.fss;

import com.actionmedia.autotest.selenium.SeleniumHolder;
import com.actionmedia.autotest.selenium.context.ComponentProvider;
import com.actionmedia.components.info.AttachmentsInfobar;
import com.actionmedia.components.Link;
import com.actionmedia.components.popups.NotepadPopup;
import com.actionmedia.pages.RightPanel;
import com.actionmedia.pages.helpers.DocumentHelper;
import com.actionmedia.pages.interfaces.IDocumentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 12.11.13
 * Time: 17:09
 */
@Component
public class FssDocumentPage extends FssBasePage<FssDocumentPage> implements ComponentProvider, IDocumentPage {

    public static final String CURRENT_URL = "current.url";
    public static final String BACK_URL = "back.url";
    public static final String NEXT_URL = "next.url";

    private RightPanel rightPanel;

    @Override
    public void handleRedirect() {
        super.handleRedirect();
        rightPanel = getHelper(RightPanel.class, this);
    }

    @Step("Проверяется что документ открыт")
    public FssDocumentPage checkPreDefinedDocumentIsOpened() {
        String url = String.valueOf(getParameter(FssBasePage.DOCUMENT_URL));
        checkCurrentUrlContainsDocumentUrl(url);
        checkEmptyDocumentHeader();
        return this;
    }

    @Step("Проверяется что кнопка экспорт отображается")
    public FssDocumentPage checkDownloadButtonIsPresent() {
        WebElement content = getPage();
        WebElement downloadButton = findElementByNoThrow(content, By.cssSelector(".download"));
        String url = getCurrentUrl().split("#/document/")[1].split("\\?")[0];
        assertNotNull(downloadButton, "Кнопка экспорт не найдена");
        postponedAssertEquals(downloadButton.getAttribute("title"), "Сохранить в файл", "Неправильный тултип для кнопки экспорт");
        String attribute = downloadButton.getAttribute("href");
        postponedAssertTrue(attribute.contains("/system/content/feature/attachment/" + url.split("/")[0]) || attribute.contains("/system/content/export/doc/" + url), "Неправильный урл для экспорта документа");
        return this;
    }

    @Step("Проверяется что кнопка печать отображается")
    public FssDocumentPage checkPrintButtonIsPresent() {
        WebElement content = getPage();
        WebElement printButton = findElementByNoThrow(content, By.cssSelector(".print"));
        assertNotNull(printButton, "Кнопка печать не найдена");
        postponedAssertEquals(printButton.getAttribute("title"), "Распечатать", "Неправильный тултип для кнопки печать");
        postponedAssertEquals(printButton.getAttribute("onclick"), "window.print();", "Неправильный атрибут onclick для кнопки печать");
        return this;
    }

    @Step("Проверяется что кнопка Полистать оригинал отображается")
    public FssDocumentPage checkPreviewButtonIsPresent() {
        WebElement content = getPage();
        WebElement previewButton = findElementByNoThrow(content, By.cssSelector(".view"));
        assertNotNull(previewButton, "Кнопка Полистать оригинал не найдена");
        postponedAssertEquals(previewButton.getAttribute("title"), "Полистать оригинал", "Неправильный тултип для кнопки Полистать оригинал");
        if (!previewButton.getAttribute("class").contains("disabled")) {
            postponedAssertTrue(previewButton.getAttribute("href").contains("/system/content/magviewer"), "Неправильный ссылка для кнокпи Полистать оригинал");
        }
        return this;
    }

    @Step("Проверяется что кнопка Презентация отображается")
    public FssDocumentPage checkPresentationButtonIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".doc-body"));
        WebElement presentationButton = findElementByNoThrow(content, By.cssSelector(".presentation"));
        postponedAssertNotNull(presentationButton, "Кнопка Презентация не найдена");
        postponedAssertTrue(presentationButton.isDisplayed(), "Кнопка Презентация не отображается");
        postponedAssertTrue(presentationButton.getText().contains("Презентация"), "Неправильный текст для кнопки Презентация");
        return this;
    }

    @Step("Проверяется что календарь открыт")
    public FssDocumentPage checkCalendarIsOpened() {
        WebElement content = getPage();
        WebElement header = content.findElement(By.id("document-header")).findElement(By.tagName("h1"));
        postponedAssertTrue(header.getText().toLowerCase().contains("календарь"), "Календарь не открыт");
        return this;
    }

    @Step("Проверяется что курс валют открыт")
    public FssDocumentPage checkCurrencyDocumentIsOpened() {
        WebElement content = getPage();
        WebElement header = content.findElement(By.id("document-header")).findElement(By.tagName("h1"));
        postponedAssertTrue(header.getText().toLowerCase().contains("курсы валют"), "Курс валют не открыт");
        return this;
    }

    @Step("Проверяется что формула открыта")
    public FssDocumentPage checkFormulaDocumentIsOpened() {
        WebElement content = getPage();
        WebElement header = content.findElement(By.id("document-header")).findElement(By.tagName("h1"));
        postponedAssertTrue(header.getText().toLowerCase().contains("расчет"), "формула не открыта");
        return this;
    }

    @Step("Проверяется что ставка рефинансирования открыта")
    public FssDocumentPage checkRateDocumentIsOpened() {
        WebElement content = getPage();
        WebElement header = content.findElement(By.id("document-header")).findElement(By.tagName("h1"));
        postponedAssertTrue(header.getText().toLowerCase().contains("ставка рефинансирования"), "Ставка рефинансирования не открыта");
        return this;
    }

    @Step("Проверяется что кнопки перехода между следующей и предыдущей статьями отображаются")
    public FssDocumentPage checkScrollButtonsArePresent() {
        WebElement content = getPage();
        WebElement backButton = findElementByNoThrow(content, By.cssSelector(".backward"));

        assertNotNull(backButton, "Кнопка перехода к предыдущей статье не найдена");

        WebElement nextButton = findElementByNoThrow(content, By.cssSelector(".forward"));
        assertNotNull(nextButton, "Кнопка перехода к следующей статье не найдена");
        return this;
    }

    @Step("Проверяется что открыто содержание")
    public FssDocumentPage checkMagazineSoderIsPresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("main-article"));
        WebElement mainLogo = findElementByNoThrow(content, By.cssSelector(".e-main-logo"));
        assertNotNull(mainLogo, "Отсутствует лого на странице оглавления журнала");

        List<WebElement> chapterList = content.findElements(By.cssSelector(".description-list"));
        postponedAssertFalse(chapterList.isEmpty(), "Отсутсвуют статьи в оглавлении");
        return this;
    }

    @Step("Проверяется что открыта предыдущая статья")
    public FssDocumentPage checkPreviousPageIsOpened() {
        String backUrl = String.valueOf(getParameter(BACK_URL));
        postponedAssertTrue(getCurrentUrl().contains(backUrl), "Предыдущая статья не открыта");
        return this;
    }

    @Step("Проверяется что открыта следующая статья")
    public FssDocumentPage checkNextPageIsOpened() {
        String nextUrl = String.valueOf(getParameter(NEXT_URL));
        postponedAssertTrue(getCurrentUrl().contains(nextUrl), "Следующая статья не открыта");
        return this;
    }

    @Step("Проверяется что открыта начальная статья")
    public FssDocumentPage checkFirstPageIsOpened() {
        String currentUrl = String.valueOf(getParameter(CURRENT_URL));
        postponedAssertTrue(getCurrentUrl().contains(currentUrl), "Начальная статья не открылась");
        return this;
    }

    @Step("Проверяется размер шрифта для заголовка документа")
    public FssDocumentPage checkFontForDocumentHeaderIsBold(double fontSize) {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("main-article"));
        WebElement header = content.findElement(By.id("document-header"));
        WebElement documentTitle = header.findElement(By.tagName("h1"));
        double actualSize = Double.parseDouble(documentTitle.getCssValue("font-size").split("px")[0]);
        postponedAssertTrue(actualSize == fontSize ||
                actualSize < fontSize + 1 ||
                actualSize > fontSize - 1, "Неправильный размер шрифта для заголовка документа." +
                " Ожидаемый: " + fontSize +
                " Наблюдаемый: " + actualSize);
        return this;
    }

    @Step("Проверяются врезы")
    public FssDocumentPage checkInCutLink() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("main-article"));
        WebElement inCutLink = content.findElement(By.cssSelector(".b-incut"));

        inCutLink.findElement(By.tagName("a")).click();
        postponedAssertTrue(inCutLink.getAttribute("class").contains("opened"), "Врез не открылся после нажатия на ссылку");
        inCutLink.findElement(By.tagName("a")).click();
        postponedAssertFalse(inCutLink.getAttribute("class").contains("opened"), "Врез не закрылся после нажатия на ссылку");
        return this;
    }

    @Step("Проверяются ссылки в правой панели")
    public FssDocumentPage checkLinksInRightPanel() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        WebElement rightPanel = findElementByNoThrow(content, By.id("aside"));
        if (rightPanel != null) {
            List<Link> linkList = new ArrayList<Link>();
            List<WebElement> linksInRightPanelList = rightPanel.findElements(By.cssSelector(".go"));
            for (WebElement linkInRightPanel : linksInRightPanelList) {
                String url = linkInRightPanel.getAttribute("href");
                String header = linkInRightPanel.getText();
                Link link = new Link(url, header);
                linkList.add(link);
            }
            if (linkList.size() > 3) {
                checkLinks(getRandomElementsInList(linkList, 3));
            } else {
                checkLinks(linkList);
            }
        } else {
            warning("Правая панель отсутсвет в документе.Проверка не проводилась.");
        }
        return this;
    }

    @Step("Проверяются работа ссылок в документе")
    public FssDocumentPage checkRandomLinksInDocument() {
        List<Link> linkList = new ArrayList<Link>();
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("main-article"));
        List<WebElement> linksInRightPanelList = content.findElements(By.cssSelector(".doc"));
        for (WebElement linkInRightPanel : linksInRightPanelList) {
            String url = linkInRightPanel.getAttribute("href");
            String header = linkInRightPanel.getText();
            Link link = new Link(url, header);
            linkList.add(link);
        }
        if (linkList.size() > 3) {
            checkLinks(getRandomElementsInList(linkList, 3));
        } else {
            checkLinks(linkList);
        }
        return this;
    }

    @Step("Нажать кнопку к предыдущей статье")
    public FssDocumentPage clickBackButton() {
        WebElement content = getPage();
        WebElement backButton = content.findElement(By.cssSelector(".backward"));
        String backUrl = backButton.getAttribute("href");
        setParameter(BACK_URL, backUrl);
        backButton.click();
        waitForReloadingPage();
        return this;
    }

    @Step("Нажать кнопку к предыдущей статье")
    public FssDocumentPage clickNextButton() {
        WebElement content = getPage();
        WebElement nextButton = content.findElement(By.cssSelector(".forward"));
        String nextUrl = nextButton.getAttribute("href");
        setParameter(NEXT_URL, nextUrl);
        nextButton.click();
        waitForReloadingPage();
        return this;
    }

    @Step("Открыть случайную статью в журнале")
    public FssDocumentPage clickRandomMagazineArticle() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("document-body"));
        List<WebElement> chapterList = content.findElements(By.cssSelector(".description-list"));
        chapterList.remove(chapterList.size() - 1);
        chapterList.remove(0);
        WebElement randomChapter = getRandomElementInList(chapterList);
        randomChapter.findElement(By.tagName("a")).click();
        return this;
    }

    @Step("Открыть случайную статью в журнале")
    public FssDocumentPage clickRandomBookChapter() {
        WebElement content = getCollapsedRightPanel();
        List<WebElement> chapterList = content.findElements(By.cssSelector(".aside-toc-item"));

        chapterList.remove(chapterList.size() - 1);
        chapterList.remove(0);

        WebElement randomChapter = getRandomElementInList(chapterList);
        randomChapter.findElement(By.tagName("a")).click();
        return this;
    }

    public FssDocumentPage setCurrentUrlToParameter() {
        String currentUrl = getCurrentUrl().split("\\?")[0];
        setParameter(CURRENT_URL, currentUrl);
        return this;
    }

    @Step("Нажать на лого,номер или дату журнала")
    public FssDocumentPage clickMagazineHeaderLink() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("main-article"));
        WebElement header = content.findElement(By.cssSelector(".e-header-top"));
        List<WebElement> headerLinks = header.findElements(By.tagName("a"));
        getRandomElementInList(headerLinks).click();
        return this;
    }

    public FssDocumentPage clickRightPanel() {
        getHelper(FssHelpers.class).clickExtendPopularBlock();
        return this;
    }

    @Step("Проверяется что правая панель открыта")
    public FssDocumentPage checkRightPanelIsOpened() {
        WebElement content = getCollapsedRightPanel();
        WebElement rightPanel = findElementByNoThrow(content, By.cssSelector(".b-expanded-wrapper"));
        postponedAssertNotNull(rightPanel, "Правая панель не найдена");
        postponedAssertTrue(rightPanel.isDisplayed(), "Правая панель не отображается");
        postponedAssertTrue(rightPanel.getAttribute("class").contains("opened"), "Правая панель не открыта");
        return this;
    }

    @Step("Проверяется что правая панель закрыта")
    public FssDocumentPage checkRightPanelIsClosed() {
        WebElement content = getCollapsedRightPanel();
        WebElement rightPanel = findElementByNoThrow(content, By.cssSelector(".b-expanded-wrapper"));
        if (rightPanel != null) {
            postponedAssertFalse(rightPanel.isDisplayed(), "Правая панель отображается");
            postponedAssertFalse(rightPanel.getAttribute("class").contains("opened"), "Правая панель открыта");
        }
        return this;
    }

    @Step("Закрыть правую панель")
    public FssDocumentPage closeRightPanel() {
        WebElement rightPanel = getCollapsedRightPanel();
        List<WebElement> buttonList = rightPanel.findElements(By.cssSelector(".xx-small"));
        for (WebElement button : buttonList) {
            if (getParentElement(button).getAttribute("class").contains("expanded")) {
                button.click();
                waitForInvisibilityOfElementLocatedBy(By.cssSelector(".b-expanded-wrapper"));
                break;
            }
        }
        return this;
    }

    public boolean isRightPanelPresent() {
        WebElement content = waitForPresenceOfElementLocatedBy(By.id("aside"));
        return findElementByNoThrow(content, By.cssSelector(".b-extra")) != null;
    }

    @Step("Проверяется работа Оглавления")
    public FssDocumentPage checkScrollInSoder() {
        if (isRightPanelPresent()) {
            WebElement rightPanel = getCollapsedRightPanel();
            if (findElementByNoThrow(rightPanel, By.xpath("//a[text()='Оглавление']")) != null) {
                WebElement soder = rightPanel.findElement(By.cssSelector(".b-contents-list"));
                List<WebElement> chapters = soder.findElements(By.cssSelector("[href*='/#/document/']"));

                WebElement random = getRandomElementInList(chapters);
                random.click();

                WebElement document = waitForVisibilityOfElementLocatedBy(By.id("main-article"));
                int curPosition = document.findElement(By.cssSelector(".highlight")).getLocation().getY();
                int header = findElementBy(By.id("header")).getLocation().getY();
                postponedAssertTrue(curPosition - header < DOCUMENT_LOCATION, "Документ не проскроллился после выбора в Оглавлении статьи '" + random.getText() + "'");
            } else {
                warning("Отсутствует оглавление в документе. Проверка не проводилась.");
            }
        }
        return this;
    }

    @Step("Проверяется отображение свернутой правой панели")
    public FssDocumentPage checkCollapsedRightPanelInMagazine() {
        getCollapsedRightPanel();
        rightPanel.checkPanelIsCollapsedInMagazine();
        rightPanel.checkSoderTabInCollapsedIsOpened();
        rightPanel.checkSoderTabInCollapsedIsNotEmpty();
        return this;
    }

    @Step("Проверяется отображение свернутой правой панели")
    public FssDocumentPage checkCollapsedRightPanelInVideo() {
        rightPanel.checkPanelIsCollapsed();

        rightPanel.clickSoderTabInCollapsed();
        rightPanel.checkSoderTabInCollapsedIsOpened();
        rightPanel.checkSoderTabInCollapsedIsNotEmpty();

        rightPanel.clickWithThisVideoTabInCollapsed();
        rightPanel.checkWithThisVideoTabInCollapsedIsOpened();
        rightPanel.checkWithThisVideoTabInCollapsedIsNotEmpty();

        rightPanel.clickSoderTabInCollapsed();
        rightPanel.checkSoderTabInCollapsedIsOpened();
        rightPanel.checkSoderTabInCollapsedIsNotEmpty();

        rightPanel.clickWithThisVideoTabInCollapsed();
        rightPanel.checkWithThisVideoTabInCollapsedIsOpened();
        rightPanel.checkWithThisVideoTabInCollapsedIsNotEmpty();
        return this;
    }

    @Step("Проверяется отображение свернутой правой панели")
    public FssDocumentPage checkCollapsedRightPanelInSolution() {
        rightPanel.checkPanelIsCollapsed();

        rightPanel.clickSoderTabInCollapsed();
        rightPanel.checkSoderTabInCollapsedIsOpened();
        rightPanel.checkSoderTabInCollapsedIsNotEmpty();

        rightPanel.clickWithThisSolutionTabInCollapsed();
        rightPanel.checkWithThisSolutionTabInCollapsedIsOpened();
        rightPanel.checkWithThisSolutionTabInCollapsedIsNotEmpty();

        rightPanel.clickSoderTabInCollapsed();
        rightPanel.checkSoderTabInCollapsedIsOpened();
        rightPanel.checkSoderTabInCollapsedIsNotEmpty();

        rightPanel.clickWithThisSolutionTabInCollapsed();
        rightPanel.checkWithThisSolutionTabInCollapsedIsOpened();
        rightPanel.checkWithThisSolutionTabInCollapsedIsNotEmpty();
        return this;
    }

    @Step("Проверяется отображение свернутой правой панели")
    public FssDocumentPage checkCollapsedRightPanelInForms() {
        rightPanel.checkPanelIsCollapsed();

        rightPanel.clickSoderTabInCollapsed();
        rightPanel.checkSoderTabInCollapsedIsOpened();
        rightPanel.checkSoderTabInCollapsedIsNotEmpty();

        rightPanel.clickWithThisDocumentTabInCollapsed();
        rightPanel.checkWithThisDocumentTabInCollapsedIsOpened();
        rightPanel.checkWithThisDocumentTabInCollapsedIsNotEmpty();

        rightPanel.clickSoderTabInCollapsed();
        rightPanel.checkSoderTabInCollapsedIsOpened();
        rightPanel.checkSoderTabInCollapsedIsNotEmpty();

        rightPanel.clickWithThisDocumentTabInCollapsed();
        rightPanel.checkWithThisDocumentTabInCollapsedIsOpened();
        rightPanel.checkWithThisDocumentTabInCollapsedIsNotEmpty();
        return this;
    }

    @Step("Проверяется отображение развернутой правой панели")
    public FssDocumentPage checkExpandedRightPanel() {
        getHelper(FssHelpers.class).clickExtendPopularBlock();

        rightPanel.clickSoderTabInExpanded();
        rightPanel.checkSoderTabInExpandedIsOpened();
        rightPanel.checkActiveTabInExpandedIsNotEmpty();

        rightPanel.clickWithThisSolutionTabInExpanded();
        rightPanel.checkWithThisSolutionTabInExpandedIsOpened();
        rightPanel.checkActiveTabInExpandedIsNotEmpty();

        rightPanel.clickSoderTabInExpanded();
        rightPanel.checkSoderTabInExpandedIsOpened();
        rightPanel.checkActiveTabInExpandedIsNotEmpty();

        rightPanel.clickWithThisSolutionTabInExpanded();
        rightPanel.checkWithThisSolutionTabInExpandedIsOpened();
        rightPanel.checkActiveTabInExpandedIsNotEmpty();
        return this;
    }

    @Step("Проверяется отображение развернутой правой панели")
    public FssDocumentPage checkExpandedRightPanelInVideo() {
        getHelper(FssHelpers.class).clickExtendPopularBlock();

        rightPanel.clickSoderTabInExpanded();
        rightPanel.checkSoderTabInExpandedIsOpened();
        rightPanel.checkActiveTabInExpandedIsNotEmpty();

        rightPanel.clickWithThisVideoTabInExpanded();
        rightPanel.checkWithThisVideoTabInExpandedIsOpened();
        rightPanel.checkActiveTabInExpandedIsNotEmpty();

        rightPanel.clickSoderTabInExpanded();
        rightPanel.checkSoderTabInExpandedIsOpened();
        rightPanel.checkActiveTabInExpandedIsNotEmpty();

        rightPanel.clickWithThisVideoTabInExpanded();
        rightPanel.checkWithThisVideoTabInExpandedIsOpened();
        rightPanel.checkActiveTabInExpandedIsNotEmpty();
        return this;
    }

    @Step("Проверяется отображение развернутой правой панели")
    public FssDocumentPage checkExpandedRightPanelInMagazine() {
        getHelper(FssHelpers.class).clickExtendPopularBlock();

        rightPanel.clickSoderTabInExpanded();
        rightPanel.checkSoderTabInExpandedIsOpened();
        rightPanel.checkActiveTabInExpandedIsNotEmpty();
        return this;
    }

    @Step("Проверяется отображение развернутой правой панели")
    public FssDocumentPage checkExpandedRightPanelInForms() {
        getHelper(FssHelpers.class).clickExtendPopularBlock();

        rightPanel.clickSoderTabInExpanded();
        rightPanel.checkSoderTabInExpandedIsOpened();
        rightPanel.checkActiveTabInExpandedIsNotEmpty();

        rightPanel.clickWithThisDocumentTabInExpanded();
        rightPanel.checkWithThisDocumentTabInExpandedIsOpened();
        rightPanel.checkActiveTabInExpandedIsNotEmpty();

        rightPanel.clickSoderTabInExpanded();
        rightPanel.checkSoderTabInExpandedIsOpened();
        rightPanel.checkActiveTabInExpandedIsNotEmpty();

        rightPanel.clickWithThisDocumentTabInExpanded();
        rightPanel.checkWithThisDocumentTabInExpandedIsOpened();
        rightPanel.checkActiveTabInExpandedIsNotEmpty();
        return this;
    }

    @Step("Проверяется работа ссылок из вкладки 'Оглавление' свернутой правой панели")
    public FssDocumentPage checkLinksFromCollapsedSoderTab() {
        WebElement document = waitForVisibilityOfElementLocatedBy(By.id("document-body"));
        WebElement header = waitForVisibilityOfElementLocatedBy(By.id("header"));
        int startHeaderPosition = header.getLocation().getY();
        rightPanel.clickSoderTabInCollapsed();
        List<WebElement> linkList = rightPanel.getItemsFromCollapsedTabByName("Оглавление");
        List<WebElement> randomLinkList;
        if (linkList.size() > 10) {
            randomLinkList = getRandomElementsInList(linkList, 10);
        } else {
            randomLinkList = linkList;
        }
        for (WebElement link : randomLinkList) {
            if (getParentElement(link).getAttribute("class") != null && "cur-position".equals(getParentElement(link).getAttribute("class"))) {
                continue;
            }
            if (link.getAttribute("class") != null && link.getAttribute("class").contains("arrow")) {
                link.click();
                continue;
            }
            report("Проверяется что после нажатия ссылки во вкладке Оглавление документ проскроллися");
            report("Открывается " + link.getText());
            link.click();
            waitFewSecond(1000);
            WebElement highlightedElement = findElementByNoThrow(document, By.cssSelector(".highlight"));
            if (highlightedElement != null) {
                int headerPosition = header.getLocation().getY();
                int elementPosition = highlightedElement.getLocation().getY();
                postponedAssertTrue(startHeaderPosition != headerPosition, "Документ не проскроллися");
                postponedAssertTrue(elementPosition - headerPosition < DOCUMENT_LOCATION, "Документ не проскроллися");
            } else {
                setPostponedTestFail("Не один элемент не подсвечен");
            }
        }
        return this;
    }

    @Step("Проверяется работа ссылок из вкладки 'Оглавление' свернутой правой панели")
    public FssDocumentPage checkLinksFromCollapsedSoderTabInMagazine() {
        rightPanel.clickSoderTabInCollapsed();
        checkLinks(rightPanel.getLinksFromCollapsedTabByName("Оглавление"));
        return this;
    }

    @Step("Проверяется работа ссылок из вкладки 'С этим решением свернутой' правой панели")
    public FssDocumentPage checkRandomLinksFromCollapsedWithThisSolutionTab() {
        rightPanel.clickWithThisSolutionTabInCollapsed();
        checkLinks(rightPanel.getLinksFromCollapsedTabByName("C этим решением"));
        return this;
    }

    @Step("Проверяется работа ссылок из вкладки 'C этим документом' свернутой правой панели")
    public FssDocumentPage checkRandomLinksFromCollapsedWithThisDocumentTab() {
        rightPanel.clickWithThisDocumentTabInCollapsed();
        checkLinks(rightPanel.getLinksFromCollapsedTabByName("C этим документом"));
        return this;
    }

    @Step("Проверяется работа ссылок из вкладки 'С этим видео' свернутой правой панели")
    public FssDocumentPage checkRandomLinksFromCollapsedWithThisVideoTab() {
        rightPanel.clickWithThisVideoTabInCollapsed();
        checkLinks(rightPanel.getLinksFromCollapsedTabByName("С этим видео"));
        return this;
    }

    @Step("Проверяется работа ссылок из вкладки 'С этим решением' развернутой правой панели")
    public FssDocumentPage checkRandomLinksFromExpandedWithThisSolutionTab() {
        getHelper(FssHelpers.class).clickExtendPopularBlock();
        rightPanel.clickWithThisSolutionTabInExpanded();
        checkLinks(rightPanel.getLinks());
        return this;
    }

    @Step("Проверяется работа ссылок из вкладки 'С этим видео' развернутой правой панели")
    public FssDocumentPage checkRandomLinksFromExpandedWithThisVideoTab() {
        getHelper(FssHelpers.class).clickExtendPopularBlock();
        rightPanel.clickWithThisVideoTabInExpanded();
        checkLinks(rightPanel.getLinks());
        return this;
    }

    @Step("Проверяется работа ссылок из вкладки 'С этим документом' развернутой правой панели")
    public FssDocumentPage checkRandomLinksFromExpandedWithThisDocumentTab() {
        getHelper(FssHelpers.class).clickExtendPopularBlock();
        rightPanel.clickWithThisDocumentTabInExpanded();
        checkLinks(rightPanel.getLinks());
        return this;
    }

    @Step("Проверяется работа ссылок из вкладки 'Оглавление' развернутой правой панели")
    public FssDocumentPage checkLinksFromExpandedSoderTab() {
        WebElement document = waitForVisibilityOfElementLocatedBy(By.id("document-body"));
        WebElement header = waitForVisibilityOfElementLocatedBy(By.id("header"));

        getHelper(FssHelpers.class).clickExtendPopularBlock();
        rightPanel.clickSoderTabInExpanded();
        List<Link> linkList = rightPanel.getLinks();
        List<Link> randomLinkList;
        if (linkList.size() > 10) {
            randomLinkList = getRandomElementsInList(linkList, 10);
        } else {
            randomLinkList = linkList;
        }
        for (Link link : randomLinkList) {
            getHelper(FssHelpers.class).clickExtendPopularBlock();
            rightPanel.clickSoderTabInExpanded();

            WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".b-expanded"));
            WebElement linkElement = content.findElement(By.cssSelector("[href*='" + link.getUrl().split(getCurrentHost())[1] + "']"));

            report("Проверяется что после нажатия ссылки во вкладке Оглавление документ проскроллися");
            report("Открывается " + link.getHeader());
            linkElement.click();
            waitFewSecond(1000);
            WebElement highlightedElement = findElementByNoThrow(document, By.cssSelector(".highlight"));
            if (highlightedElement != null) {
                int headerPosition = header.getLocation().getY();
                int elementPosition = highlightedElement.getLocation().getY();
                postponedAssertTrue(elementPosition - headerPosition < DOCUMENT_LOCATION, "Документ не проскроллися к " + link.getHeader());
            } else {
                setPostponedTestFail("Не один элемент не подсвечен");
            }
        }
        return this;
    }

    @Step("Проверяется работа ссылок из вкладки 'Оглавление' развернутой правой панели")
    public FssDocumentPage checkLinksFromExpandedSoderTabInMagazine() {
        getHelper(FssHelpers.class).clickExtendPopularBlock();
        rightPanel.clickSoderTabInExpanded();
        checkLinks(rightPanel.getLinks());
        return this;
    }

    @Step("Проверяется что свернутое Оглавление не пустое")
    public FssDocumentPage checkCollapsedTableOfContentsIsNotEmpty() {
        WebElement soderTab = getCollapsedRightPanel();
        WebElement soderTabContent = soderTab.findElement(By.cssSelector(".b-contents-list"));
        postponedAssertFalse(soderTabContent.getText().isEmpty(), "В свернутом Оглавлении Отсутствует текст");
        return this;
    }

    @Step("Проверяется что свернутое Оглавление не пустое")
    public FssDocumentPage checkExpandedTableOfContentsIsNotEmpty() {
        getHelper(FssHelpers.class).clickExtendPopularBlock();
        rightPanel.clickSoderTabInExpanded();
        WebElement soderTab = getCollapsedRightPanel();
        WebElement soderTabContent = soderTab.findElement(By.cssSelector(".b-content"));
        postponedAssertFalse(soderTabContent.getText().isEmpty(), "В развернутом Оглавлении Отсутствует текст");
        return this;
    }

    @Step("Проверяется поисковая строка на странице документа раздела 'Справочник'")
    public FssDocumentPage checkSearchBoxPresentInDictionaryDocument() {
        checkSearchBoxIsPresent("Поиск справочной информации");
        return this;
    }

    @Step("Проверяется поисковая строка на странице документа раздела 'Положения и регламенты'")
    public FssDocumentPage checkSearchBoxPresentInFormsDocument() {
        checkSearchBoxIsPresent("Поиск положений и регламентов");
        return this;
    }

    @Step("Проверяется поисковая строка на странице документа раздела 'Правовая база'")
    public FssDocumentPage checkSearchBoxPresentInLawBaseDocument() {
        checkSearchBoxIsPresent("Поиск документов");
        checkExtendedSearchButtonIsPresent();
        return this;
    }

    @Step("Проверяется поисковая строка на странице документа раздела 'Библиотека'")
    public FssDocumentPage checkSearchBoxPresentInMagazinesDocument() {
        checkSearchBoxIsPresent("Поиск по журналам и книгам");
        return this;
    }

    @Step("Проверяется поисковая строка на странице документа раздела 'Решения'")
    public FssDocumentPage checkSearchBoxPresentInSolutionsDocument() {
        checkSearchBoxIsPresent("Поиск решений");
        return this;
    }

    @Step("Проверяется поисковая строка на странице документа раздела 'Видео'")
    public FssDocumentPage checkSearchBoxPresentInVideoDocument() {
        checkSearchBoxIsPresent("Поиск видео");
        return this;
    }

    @Step("Проверяется что виджет 'Поиск в тексте' отображается в поисковой строке")
    public FssDocumentPage checkSearchInTextWidgetIsPresent() {
        getHelper(DocumentHelper.class).checkSearchInTextWidgetIsPresent();
        return this;
    }

    @Step("Проверяется работа виджета 'Поиск в тексте'")
    public FssDocumentPage checkSearchInTextWidgetWork(boolean fullcheck) {
        getHelper(DocumentHelper.class).checkSearchInTextWidgetWork(fullcheck);
        return this;
    }

    @Step("Проверяется что кнопка отключения/включения подсветки отображается в поисковой строке")
    public FssDocumentPage checkEnableHighlightsButtonIsPresent() {
        WebElement searchForm = waitForVisibilityOfElementLocatedBy(By.id("form-search"));
        WebElement toggleButton = findElementByNoThrow(searchForm, By.id("highlight-toggler"));
        postponedAssertNotNull(toggleButton, "Кнопка отключения/включения подсветки не найдена в поисковой строке");
        if (toggleButton != null) {
            postponedAssertTrue(toggleButton.isDisplayed(), "Кнопка отключения/включения подсветки не отображается в поисковой строке");
        }
        return this;
    }

    @Step("Проверяется работа кнопки отключения/включения подсветки результатов поиска")
    public FssDocumentPage checkEnableHighlightsButtonFunctionality() {
        WebElement content = getPage();

        WebElement searchForm = waitForVisibilityOfElementLocatedBy(By.id("form-search"));
        WebElement toggleButton = searchForm.findElement(By.id("highlight-toggler"));

        List<WebElement> searchWordList = content.findElements(By.cssSelector(".search-word"));

        String highlightedWordColor = "rgba(192, 241, 254, 1)";
        String notHighlightedWordColor;
        if (SeleniumHolder.getDriverName().equals("chrome")) {
            notHighlightedWordColor = "rgba(0, 0, 0, 0)";
        } else {
            notHighlightedWordColor = "transparent";
        }

        if (toggleButton.getAttribute("class").contains("active")) {
            report("Проверяется подсветка результатов поиска при включенной 'лампочке'");
            checkBackgroundColor(searchWordList, highlightedWordColor, "Отсутствует подсветка результатов поиска");
            report("Отключить подсветку");
            toggleButton.click();
            waitFewSecond(3000);
            report("Проверяется подсветка результатов поиска при отключенной 'лампочке'");
            checkBackgroundColor(searchWordList, notHighlightedWordColor, "Подсветка результатов поиска присутсвует после отключения подсветки");
            report("Включить подсветку");
            toggleButton.click();
            waitFewSecond(3000);
            report("Проверяется подсветка результатов поиска при включенной 'лампочке'");
            checkBackgroundColor(searchWordList, highlightedWordColor, "Отсутствует подсветка результатов поиска");
        } else {
            report("Проверяется подсветка результатов поиска при отключенной 'лампочке'");
            checkBackgroundColor(searchWordList, notHighlightedWordColor, "Подсветка результатов поиска присутсвует после отключения подсветки");
            report("Включить подсветку");
            toggleButton.click();
            waitFewSecond(3000);
            report("Проверяется подсветка результатов поиска при включенной 'лампочке'");
            checkBackgroundColor(searchWordList, highlightedWordColor, "Отсутствует подсветка результатов поиска");
            report("Отключить подсветку");
            toggleButton.click();
            waitFewSecond(3000);
            report("Проверяется подсветка результатов поиска при отключенной 'лампочке'");
            checkBackgroundColor(searchWordList, notHighlightedWordColor, "Подсветка результатов поиска присутсвует после отключения подсветки");
        }
        return this;
    }

    private void checkBackgroundColor(List<WebElement> searchWordList, String expectedColor, String errorMessage) {
        waitFewSecond(getTimeout() * 10);
        for (WebElement searchWord : searchWordList) {
            String backgroundColor = searchWord.getCssValue("background-color");
            assertEquals(backgroundColor, expectedColor, errorMessage);
        }
    }

    @Step("Проверяется что форма авторизации отображается")
    public FssDocumentPage checkAuthFormIsPresent() {
        getHelper(DocumentHelper.class).checkAuthFormIsPresent();
        return this;
    }

    @Step("Проверяется что форма авторизации не отображается")
    public FssDocumentPage checkAuthFormIsNotPresent() {
        WebElement content = getPage();
        WebElement authForm = findElementByNoThrow(content, By.id("whiteboard"));
        postponedAssertNull(authForm, "Форма авторизации отображается");
        return this;
    }

    @Step("Проверяется что форма авторизации содержит текст")
    public FssDocumentPage checkAuthFormContainsText(String text) {
        report("Проверяется что форма авторизации содержит текст '" + text + "'");
        WebElement content = getPage();
        WebElement authForm = content.findElement(By.id("whiteboard"));
        String authFormText = authForm.getText().toLowerCase();
        postponedAssertTrue(authFormText.contains(text.toLowerCase()), "В форме авторизации Отсутствует текст '" + text + "'");
        return this;
    }

    @Step("Проверяется что превью документа на форме авторизации отображается")
    public FssDocumentPage checkPreviewDocumentIsPresent() {
        WebElement content = getPage();
        WebElement docPreview = findElementByNoThrow(content, By.id("document-header"));
        postponedAssertNotNull(docPreview, "Превью документа на форме авторизации не найдено");
        if (docPreview != null) {
            postponedAssertTrue(docPreview.isDisplayed(), "Превью документа на форме авторизации не отображается");
            postponedAssertFalse(docPreview.getText().isEmpty(), "Превью документа на форме авторизации пустое");
        }
        return this;
    }

    @Step("Проверяется что превью документа на форме авторизации не отображается")
    public FssDocumentPage checkPreviewDocumentIsNotPresent() {
        WebElement content = getPage();
        WebElement docPreview = findElementByNoThrow(content, By.id("document-header"));
        postponedAssertNull(docPreview, "Превью документа на форме авторизации отображается");
        return this;
    }

    @Step("Проверяется что вкладки на странице авторизации отображаются")
    public FssDocumentPage checkTabsOnAuthFormArePresent() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("sidebar"));
        WebElement tabMenu = findElementByNoThrow(content, By.cssSelector(".b-menu"));
        postponedAssertNotNull(tabMenu, "Вкладки на форме авторизации не найдены");
        if (tabMenu != null) {
            postponedAssertTrue(tabMenu.isDisplayed(), "Вкладки на форме авторизации не отображаются");
        }
        return this;
    }

    @Step("Проверяется что вкладка 'Вход в систмеу' на странице авторизации отображается")
    public FssDocumentPage checkAuthTabOnAuthFormIsPresent() {
        checkTabOnAuthFormIsPresent(By.cssSelector("[data-action='WFAuth']"), "Вход в систему");
        return this;
    }

    @Step("Проверяется что вкладка 'Активировать код' на странице авторизации отображается")
    public FssDocumentPage checkActivateTabOnAuthFormIsPresent() {
        checkTabOnAuthFormIsPresent(By.cssSelector("[data-action='WFActivate']"), "Активировать код");
        return this;
    }

    @Step("Проверяется что вкладка 'Демодоступ' на странице авторизации отображается")
    public FssDocumentPage checkDemoAccessTabOnAuthFormIsPresent() {
        checkTabOnAuthFormIsPresent(By.cssSelector("[data-action='WFRegister']"), "Демодоступ");
        return this;
    }

    @Step("Проверяется что открыта вкладка 'Вход в систему' на странице авторизации")
    public FssDocumentPage checkAuthTabOnAuthFormIsOpened() {
        checkTabIsOpened(By.id("authorization-auth"), "Вход в систему");
        return this;
    }

    @Step("Проверяется что открыта вкладка 'Активировать код' на странице авторизации")
    public FssDocumentPage checkActivateTabOnAuthFormIsOpened() {
        checkTabIsOpened(By.id("authorization-activate"), "Активация подписки");
        return this;
    }

    @Step("Проверяется что открыта вкладка 'Демодоступ' на странице авторизации")
    public FssDocumentPage checkDemoAccessTabOnAuthFormIsOpened() {
        checkTabIsOpened(By.id("authorization-register"), "Демодоступ");
        return this;
    }

    @Step("Проверяется что выбрана вкладка 'Вход в систему' на странице авторизации")
    public FssDocumentPage checkAuthTabOnAuthFormIsSelected() {
        checkTabIsSelected(By.cssSelector("[data-action='WFAuth']"), "Вход в систему");
        return this;
    }

    @Step("Проверяется что выбрана вкладка 'Активировать код' на странице авторизации")
    public FssDocumentPage checkActivateTabOnAuthFormIsSelected() {
        checkTabIsSelected(By.cssSelector("[data-action='WFActivate']"), "Активация подписки");
        return this;
    }

    @Step("Проверяется что выбрана вкладка 'Демодоступ' на странице авторизации")
    public FssDocumentPage checkDemoAccessTabOnAuthFormIsSelected() {
        checkTabIsSelected(By.cssSelector("[data-action='WFRegister']"), "Демодоступ");
        return this;
    }

    @Step("Открыть вкладку 'Вход в систему' на странице авторизации")
    public FssDocumentPage clickAuthTabOnAuthFormIsPresent() {
        clickTabOnAuthFormIsPresent(By.cssSelector("[data-action='WFAuth']"));
        return this;
    }

    @Step("Открыть вкладку 'Активировать код' на странице авторизации")
    public FssDocumentPage clickActivateTabOnAuthFormIsPresent() {
        clickTabOnAuthFormIsPresent(By.cssSelector("[data-action='WFActivate']"));
        return this;
    }

    @Step("Открыть вкладку 'Демодоступ' на странице авторизации")
    public FssDocumentPage clickDemoAccessTabOnAuthFormIsPresent() {
        clickTabOnAuthFormIsPresent(By.cssSelector("[data-action='WFRegister']"));
        return this;
    }

    private void checkTabOnAuthFormIsPresent(By tabLocator, String tabName) {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("sidebar"));
        WebElement tabMenu = content.findElement(By.cssSelector(".b-menu"));
        WebElement tab = findElementByNoThrow(tabMenu, tabLocator);
        postponedAssertNotNull(tab, "Вкладка '" + tabName + "' на форме авторизации не найдена");
        if (tabMenu != null) {
            postponedAssertTrue(tabMenu.isDisplayed(), "Вкладка '" + tabName + "' на форме авторизации не отображается");
        }
    }

    private void clickTabOnAuthFormIsPresent(By tabLocator) {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("sidebar"));
        WebElement tabMenu = content.findElement(By.cssSelector(".b-menu"));
        WebElement tab = tabMenu.findElement(tabLocator);
        tab.click();
        waitForReloadingPage();
    }

    private void checkTabIsOpened(By tabLocator, String tabName) {
        WebElement content = getPage();
        WebElement tab = content.findElement(tabLocator);
        postponedAssertTrue(tab.isDisplayed(), "Вкладка '" + tabName + "' на форме авторизации не открыта");

        WebElement header = tab.findElement(By.cssSelector(".doc-header"));
        postponedAssertEquals(tabName.toLowerCase(), header.getText().toLowerCase(), "Вкладка '" + tabName + "' на форме авторизации не открыта");
    }

    private void checkTabIsSelected(By tabLocator, String tabName) {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("sidebar"));
        WebElement tabMenu = content.findElement(By.cssSelector(".b-menu"));
        WebElement tab = tabMenu.findElement(tabLocator);

        WebElement parent = getParentElement(getParentElement(tab));
        postponedAssertEquals(parent.getAttribute("class"), "selected", "Вкладка '" + tabName + "' на форме авторизации не выбрана");
    }

    public FssDocumentPage checkBooksNameAndAuthor() {
        getHelper(DocumentHelper.class).checkBooksNameAndAuthor();
        return this;
    }

    public FssDocumentPage checkImageBook() {
        getHelper(DocumentHelper.class).checkImageBook();
        return this;
    }

    public FssDocumentPage checkNameDocument() {
        getHelper(DocumentHelper.class).checkNameDocument();
        return this;
    }

    public FssDocumentPage checkDisplayStars() {
        getHelper(DocumentHelper.class).checkDisplayStars();
        return this;
    }

    public FssDocumentPage checkDisplayTextDocumentInParagraphs() {
        getHelper(DocumentHelper.class).checkDisplayTextDocumentInParagraphs();
        return this;
    }

    public FssDocumentPage checkInMyFavoritesIcon() {
        getHelper(DocumentHelper.class).checkInMyFavoritesIcon();
        return this;
    }

    public FssDocumentPage checkPrintIcon() {
        getHelper(DocumentHelper.class).checkPrintIcon();
        return this;
    }

    public FssDocumentPage checkWordButtonIsPresent() {
        getHelper(DocumentHelper.class).checkWordButtonIsPresent();
        return this;
    }

    public FssDocumentPage checkBackwardIcon() {
        getHelper(DocumentHelper.class).checkBackwardIcon();
        return this;
    }

    public FssDocumentPage checkForwardIcon() {
        getHelper(DocumentHelper.class).checkForwardIcon();
        return this;
    }

    public FssDocumentPage checkBrowseIcon() {
        getHelper(DocumentHelper.class).checkBrowseIcon();
        return this;
    }

    public FssDocumentPage checkRubricatorButtonIsPresent(String buttonName) {
        getHelper(DocumentHelper.class).checkRubricatorButtonIsPresent(buttonName);
        return this;
    }

    public FssDocumentPage checkSoderButtonIsPresent() {
        getHelper(DocumentHelper.class).checkSoderButtonIsPresent();
        return this;
    }

    public FssDocumentPage checkBooksName() {
        getHelper(DocumentHelper.class).checkBooksName();
        return this;
    }

    public FssDocumentPage checkAuthor() {
        getHelper(DocumentHelper.class).checkAuthor();
        return this;
    }

    public FssDocumentPage checkDisplayTableOfContents() {
        getHelper(DocumentHelper.class).checkDisplayTableOfContents();
        return this;
    }

    public FssDocumentPage checkDisplayDescriptionList() {
        getHelper(DocumentHelper.class).checkDisplayDescriptionList();
        return this;
    }

    public FssDocumentPage checkShareIcon() {
        getHelper(DocumentHelper.class).checkShareIcon();
        return this;
    }

    public FssDocumentPage checkDisplayNameJournal() {
        getHelper(DocumentHelper.class).checkDisplayNameJournal();
        return this;
    }

    public FssDocumentPage checkPudDateJournal() {
        getHelper(DocumentHelper.class).checkPudDateJournal();
        return this;
    }

    public FssDocumentPage checkArticleTitle() {
        getHelper(DocumentHelper.class).checkArticleTitle();
        return this;
    }

    public FssDocumentPage checkRSSTitle(String title) {
        getHelper(DocumentHelper.class).checkRSSTitle(title);
        return this;
    }

    public FssDocumentPage checkDispalyTextInJournal() {
        getHelper(DocumentHelper.class).checkDisplayTextInJournal();
        return this;
    }

    public FssDocumentPage checkDisplayNameJournal_119() {
        getHelper(DocumentHelper.class).checkDisplayNameJournal_119();
        return this;
    }

    public FssDocumentPage checkArticleTitle_119() {
        getHelper(DocumentHelper.class).checkArticleTitle_119();
        return this;
    }

    public FssDocumentPage checkDisplayTextDocumentInParagraphs_119() {
        getHelper(DocumentHelper.class).checkDisplayNameJournal_119();
        return this;
    }

    public FssDocumentPage checkDisplayStarsSection() {
        getHelper(DocumentHelper.class).checkDisplayStarsSection();
        return this;
    }

    public FssDocumentPage checkDisplayNameJournal_192() {
        getHelper(DocumentHelper.class).checkDisplayNameJournal_192();
        return this;
    }

    public FssDocumentPage checkNumberJournal_192() {
        getHelper(DocumentHelper.class).checkNumberJournal_192();
        return this;
    }

    public FssDocumentPage checkDisplayTableOfContents_192() {
        getHelper(DocumentHelper.class).checkDisplayTableOfContents_192();
        return this;
    }

    public FssDocumentPage checkNameAndNumberJournal() {
        getHelper(DocumentHelper.class).checkNameAndNumberJournal();
        return this;
    }

    public FssDocumentPage checkSearchIn() {
        getHelper(DocumentHelper.class).checkSearchIn();
        return this;
    }

    public FssDocumentPage checkRevisionIsValidFrom() {
        getHelper(DocumentHelper.class).checkRevisionIsValidFrom();
        return this;
    }

    public FssDocumentPage checkMenu() {
        getHelper(DocumentHelper.class).checkMenu();
        return this;
    }

    public FssDocumentPage checkDisplayStarsTable() {
        getHelper(DocumentHelper.class).checkDisplayStarsTable();
        return this;
    }

    public FssDocumentPage checkDisplayStarsTableWithScroll() {
        getHelper(DocumentHelper.class).checkDisplayStarsTableWithScroll();
        return this;
    }

    public FssDocumentPage checkNotPresentShareIcon() {
        getHelper(DocumentHelper.class).checkNotPresentShareIcon();
        return this;
    }

    @Step("Проверяется отображение звезд у строк таблиц")
    public FssDocumentPage checkDisplayStarsTable_117() {
        WebElement documentBody = findElementBy(By.id("document-body"));
        List<WebElement> paragraphs = findElementsBy(documentBody, By.xpath(".//tr[@data-role='phrase-row']"));
        for (int i = 0; i < (paragraphs.size() < 3 ? paragraphs.size() : 3); i++) {
            WebElement star = findElementBy(paragraphs.get(i), By.xpath(".//a[@data-role='phrase-anchor']"));
            WebElement span = paragraphs.get(i).findElement(By.xpath(".//span[@data-role='phrase']"));
            moveMouseToElement(span);
            waitForPresenceOf(star);
            postponedAssertTrue(star.isDisplayed(), "Не отображается звезда рядом с параграфом");
            scrollScript(50);
            break;
        }
        return this;
    }

    public FssDocumentPage checkDisplayCover() {
        getHelper(DocumentHelper.class).checkDisplayCover();
        return this;
    }

    public FssDocumentPage checkFormCommentsFss() {
        getHelper(DocumentHelper.class).checkFormCommentsFss();
        return this;
    }

    public FssDocumentPage checkCommonView174(){
        getHelper(DocumentHelper.class).checkCommonView174();
        return this;
    }

    public FssDocumentPage checkCommonView191(){
        getHelper(DocumentHelper.class).checkCommonView191();
        return this;
    }

    public FssDocumentPage checkCommonViewForms(){
        getHelper(DocumentHelper.class).checkCommonViewForms();
        return this;
    }

    public FssDocumentPage checkParentDocumentLinkIsPresent(){
        getHelper(DocumentHelper.class).checkParentDocumentLinkIsPresent();
        return this;
    }

    public FssDocumentPage checkParentDocumentLinkFormat(String expectedDocType){
        getHelper(DocumentHelper.class).checkParentDocumentLinkFormat(expectedDocType);
        return this;
    }

    public FssDocumentPage checkParentDocumentLinkIsItalicStyle(){
        getHelper(DocumentHelper.class).checkParentDocumentLinkIsItalicStyle();
        return this;
    }

    public FssDocumentPage checkParentDocumentLinkInBottom(){
        getHelper(DocumentHelper.class).checkParentDocumentLinkInBottom();
        return this;
    }

    public FssDocumentPage clickParentDocumentLink(){
        getHelper(DocumentHelper.class).clickParentDocumentLink();
        return this;
    }

    public FssDocumentPage checkParentDocumentTitle(){
        getHelper(DocumentHelper.class).checkParentDocumentTitle();
        return this;
    }

    public FssDocumentPage checkDocumentIsOpened() {
        getHelper(DocumentHelper.class).checkDocumentIsOpened();
        return this;
    }

    @Override
    public FssDocumentPage checkDownloadShowExamplesLinkIsNotPresent() {
        getHelper(DocumentHelper.class).checkDownloadShowExamplesLinkIsNotPresent();
        return this;
    }

    @Override
    public FssDocumentPage checkDownloadShowExampleLinkIsNotPresent() {
        getHelper(DocumentHelper.class).checkDownloadShowExampleLinkIsNotPresent();
        return this;
    }

    @Override
    public IDocumentPage checkCommonView118(String name) {
        getHelper(DocumentHelper.class).checkCommonView118(name);
        return this;
    }

    public FssDocumentPage checkWarningPanelIsLocatedAboveThanHeader() {
        getHelper(DocumentHelper.class).checkWarningPanelIsLocatedAboveThanHeader();
        return this;
    }

    public FssDocumentPage checkWarningPanelWidthIsEqualsBrowserWidth() {
        getHelper(DocumentHelper.class).checkWarningPanelWidthIsEqualsBrowserWidth();
        return this;
    }

    public FssDocumentPage checkWarningPanelIsRed() {
        getHelper(DocumentHelper.class).checkWarningPanelIsRed();
        return this;
    }

    public FssDocumentPage checkWarningPanelHasText(String text) {
        getHelper(DocumentHelper.class).checkWarningPanelHasText(text);
        return this;
    }

    public FssDocumentPage checkWarningPanelHasLink(String textLink) {
        getHelper(DocumentHelper.class).checkWarningPanelHasLink(textLink);
        return this;
    }

    public FssDocumentPage checkArrowsInSearchInText(String query) {
        getHelper(DocumentHelper.class).checkArrowsInSearchInText(query);
        return this;
    }

    public FssDocumentPage checkDocumentSearchWithNoResult() {
        getHelper(DocumentHelper.class).checkDocumentSearchWithNoResult();
        return this;
    }

    public FssDocumentPage checkVersionsBlockForDictionaryDocumentIsPresent() {
        getHelper(DocumentHelper.class).checkVersionsBlockForDictionaryDocumentIsPresent();
        return this;
    }

    public FssDocumentPage checkOtherVersionsForDictionaryDocumentIsPresent() {
        getHelper(DocumentHelper.class).checkOtherVersionsForDictionaryDocumentIsPresent();
        return this;
    }

    public FssDocumentPage checkExpiredVersionsForDictionaryDocumentIsPresent() {
        getHelper(DocumentHelper.class).checkExpiredVersionsForDictionaryDocumentIsPresent();
        return this;
    }

    public FssDocumentPage checkMailButtonIsPresent() {
        getHelper(DocumentHelper.class).checkMailButtonIsPresent();
        return this;
    }

    public FssDocumentPage clickMailButtonInKodeks() {
        getHelper(DocumentHelper.class).clickMailButtonInKodeks();
        return this;
    }

    public FssDocumentPage checkMailButtonInKodeksIsPresent() {
        getHelper(DocumentHelper.class).checkMailButtonInKodeksIsPresent();
        return this;
    }

    public FssDocumentPage checkMailFormIsPresent() {
        getHelper(DocumentHelper.class).checkMailFormIsPresent();
        return this;
    }

    public FssDocumentPage checkMailFormIsNotPresent() {
        getHelper(DocumentHelper.class).checkMailFormIsNotPresent();
        return this;
    }

    public FssDocumentPage inputEmailInMailForm(String email) {
        getHelper(DocumentHelper.class).inputEmailInMailForm(email);
        return this;
    }

    public FssDocumentPage clickSendInMailForm() {
        getHelper(DocumentHelper.class).clickSendInMailForm();
        return this;
    }

    public FssDocumentPage checkErrorMessageInMailForm(String expectedErrorMessaege) {
        getHelper(DocumentHelper.class).checkErrorMessageInMailForm(expectedErrorMessaege);
        return this;
    }

    public FssDocumentPage clickRandomArticle() {
        getHelper(DocumentHelper.class).clickRandomArticle();
        return this;
    }

    public FssDocumentPage clickTableOfContentsButton() {
        getHelper(DocumentHelper.class).clickTableOfContentsButton();
        return this;
    }

    public FssDocumentPage checkCurrentItemIsHighlightedInTableOfContentsForKodeks() {
        getHelper(DocumentHelper.class).checkCurrentItemIsHighlightedInTableOfContentsForKodeks();
        return this;
    }

    public FssDocumentPage checkTableOfContentsButtonIsPressed() {
        getHelper(DocumentHelper.class).checkTableOfContentsButtonIsPressed();
        return this;
    }

    public FssDocumentPage checkTableOfContentsButtonIsUnPressed() {
        getHelper(DocumentHelper.class).checkTableOfContentsButtonIsUnPressed();
        return this;
    }

    public FssDocumentPage clickDocumentHeader() {
        getHelper(DocumentHelper.class).clickDocumentHeader();
        return this;
    }

    public FssDocumentPage checkDisplayTableOfContentsForKodeks() {
        getHelper(DocumentHelper.class).checkDisplayTableOfContentsForKodeks();
        return this;
    }

    public FssDocumentPage clickRandomArticleFromTableOfContents() {
        getHelper(DocumentHelper.class).clickRandomArticleFromTableOfContents();
        return this;
    }

    public FssDocumentPage clickAboutBookButton() {
        getHelper(DocumentHelper.class).clickAboutBookButton();
        return this;
    }

    public FssDocumentPage checkAboutBookBlock() {
        getHelper(DocumentHelper.class).checkAboutBookBlock();
        return this;
    }

    public FssDocumentPage setBrowserSize(int width, int height) {
        getHelper(DocumentHelper.class).setBrowserSize(width, height);
        return this;
    }

    public FssDocumentPage checkSizeOfAboutBookBlockIsNotChanged() {
        getHelper(DocumentHelper.class).checkSizeOfAboutBookBlockIsNotChanged();
        return this;
    }

    public FssDocumentPage checkPrintButtonInKodeksIsPresent() {
        getHelper(DocumentHelper.class).checkPrintButtonInKodeksIsPresent();
        return this;
    }

    @Step("Проверяется что кнопка 'Отправить' отображается")
    public FssDocumentPage checkSendButtonIsPresent() {
        WebElement header = getDocumentHeaderForMagazine();
        WebElement browserButton = findElementByNoThrow(header, By.cssSelector(".mail"));
        postponedAssertNotNull(browserButton, "Кнопка 'Отправить' не найдена");
        postponedAssertTrue(browserButton.isDisplayed(), "кнопка 'Отправить' не отображается");
        postponedAssertEquals(browserButton.getText(), "Отправить", "Неправильный текст кнопки 'Отправить'");
        return this;
    }

    public FssDocumentPage checkExtendedSearchButtonIsPresent(){
        getHelper(DocumentHelper.class).checkExtendedSearchButtonIsPresent();
        return this;
    }

    public FssDocumentPage checkHelpWidgetIsPresent(){
        getHelper(DocumentHelper.class).checkHelpWidgetIsPresent();
        return this;
    }

    @Step("Проверяется что кнопка 'Отправить' отображается")
    public FssDocumentPage checkSendButtonIsPresentForKodeks() {
        WebElement header = waitForPresenceOfElementLocatedBy(By.id("document-header"), "Заголовок документа не найден");
        WebElement browserButton = findElementByNoThrow(header, By.cssSelector(".ico_content_mail"));
        postponedAssertNotNull(browserButton, "Кнопка 'Отправить' не найдена");
        postponedAssertTrue(browserButton.isDisplayed(), "Кнопка 'Отправить' не отображается");
        return this;
    }

    public FssDocumentPage checkTableOfContentsButtonIsPresent(){
        getHelper(DocumentHelper.class).checkTableOfContentsButtonIsPresent();
        return this;
    }

    public FssDocumentPage checkCurrencyDocument() {
        getHelper(DocumentHelper.class).checkCurrencyDocument();
        return this;
    }

    public FssDocumentPage selectFirstCurrencyByCode(String code) {
        getHelper(DocumentHelper.class).selectFirstCurrencyByCode(code);
        return this;
    }

    public FssDocumentPage selectSecondCurrencyByCode(String code) {
        getHelper(DocumentHelper.class).selectSecondCurrencyByCode(code);
        return this;
    }

    public FssDocumentPage clickChangeCurrencyOrderButton() {
        getHelper(DocumentHelper.class).clickChangeCurrencyOrderButton();
        return this;
    }

    public FssDocumentPage checkFirstCurrencyLabel(String code) {
        getHelper(DocumentHelper.class).checkFirstCurrencyLabel(code);
        return this;
    }

    public FssDocumentPage checkSecondCurrencyLabel(String code) {
        getHelper(DocumentHelper.class).checkSecondCurrencyLabel(code);
        return this;
    }

    public FssDocumentPage checkTableCourseLabel(String codeFirstCurrency, String codeSecondCurrency) {
        getHelper(DocumentHelper.class).checkTableCourseLabel(codeFirstCurrency, codeSecondCurrency);
        return this;
    }

    public FssDocumentPage checkLastCourseTableIsChanged() {
        getHelper(DocumentHelper.class).checkLastCourseTableIsChanged();
        return this;
    }

    public FssDocumentPage setLastCourseTableToParameter() {
        getHelper(DocumentHelper.class).setLastCourseTableToParameter();
        return this;
    }

    public FssDocumentPage checkMyFavoritesRubricatorButtonIsPresent() {
        getHelper(DocumentHelper.class).checkMyFavoritesRubricatorButtonIsPresent();
        return this;
    }

    public FssDocumentPage checkAddToFavoritesButtonsForDocumentArePresent() {
        getHelper(DocumentHelper.class).checkAddToFavoritesButtonsForDocumentArePresent();
        return this;
    }

    private WebElement getDocumentHeaderForMagazine() {
        return waitForVisibilityOfElementLocatedBy(By.cssSelector(".e-header"), "Заголовок документ не найден");
    }

    public FssDocumentPage clickDocumentInfobarLink() {
        getHelper(DocumentHelper.class).clickDocumentInfobarLink();
        return this;
    }

    public FssDocumentPage checkTitleAndAuthorInformationPresent() {
        getHelper(DocumentHelper.class).checkTitleAndAuthorInformationPresent();
        return this;
    }

    public FssDocumentPage checkContentIsPresent() {
        getHelper(DocumentHelper.class).checkContentIsPresent();
        return this;
    }

    public FssDocumentPage checkSoderIsPresent() {
        getHelper(DocumentHelper.class).checkSoderIsPresent();
        return this;
    }

    public FssDocumentPage checkDocumentRatingIsPresent()  {
        getHelper(DocumentHelper.class).checkDocumentRatingIsPresent();
        return this;
    }

    public FssDocumentPage checkSavingMoneyBlock() {
        getHelper(DocumentHelper.class).checkSavingMoneyBlock();
        return this;
    }

    public FssDocumentPage checkAuthorsInformationIsPresent() {
        getHelper(DocumentHelper.class).checkAuthorsInformationIsPresent();
        return this;
    }

    public FssDocumentPage checkCommonViewDocument_173_2148() {
        getHelper(DocumentHelper.class).checkCommonViewDocument_173_2148();
        return this;
    }

    public FssDocumentPage checkTitleAndAuthorInformationWithoutPhotoPresent() {
        getHelper(DocumentHelper.class).checkTitleAndAuthorInformationWithoutPhotoPresent();
        return this;
    }

    public FssDocumentPage checkInCut() {
        getHelper(DocumentHelper.class).checkInCut();
        return this;
    }

    public FssDocumentPage checkInlineDownloadsFromDocument178_2547() {
        getHelper(DocumentHelper.class).checkInlineDownloadsFromDocument178_2547();
        return this;
    }

    public FssDocumentPage checkDocPreviewTextStatus() {
        getHelper(DocumentHelper.class).checkDocPreviewTextStatus();
        return this;
    }

    public FssDocumentPage checkDocBriefIsPresent(String brief) {
        getHelper(DocumentHelper.class).checkDocBriefIsPresent(brief);
        return this;
    }

    public FssDocumentPage checkDocumentHasTitleWithoutBody() {
        getHelper(DocumentHelper.class).checkDocumentHasTitleWithoutBody();
        return this;
    }

    public FssDocumentPage checkDocumentIsBlurred() {
        getHelper(DocumentHelper.class).checkDocumentIsBlurred();
        return this;
    }

    public FssDocumentPage checkBacklinksArePresent() {
        getHelper(DocumentHelper.class).checkBacklinksArePresent();
        return this;
    }

    public FssDocumentPage checkBacklinkHasCssStyles() {
        getHelper(DocumentHelper.class).checkBacklinkHasCssStyles();
        return this;
    }

    public FssDocumentPage clickOnBacklinkWithReferencesCount(int count) {
        getHelper(DocumentHelper.class).clickOnBacklinkWithReferencesCount(count);
        return this;
    }

    public FssDocumentPage checkNotepadPopupIsPresent() {
        getHelper(NotepadPopup.class).checkPopupIsPresent();
        return this;
    }

    public FssDocumentPage checkParagraphAndButtonAreGray() {
        getHelper(DocumentHelper.class).checkParagraphAndButtonAreGray();
        return this;
    }

    public FssDocumentPage checkParagraphAndButtonAreNotYellow() {
        getHelper(DocumentHelper.class).checkParagraphAndButtonAreNotYellow();
        return this;
    }

    /**
     * @param phraseAnchor - the part of link in the data-anchor attribute for the tag 'a'
     *                     example: <a data-anchor="/document/99/9027690/bssPhr143/"...,
     *                     for this, phraseAnchor = bssPhr143
     */
    public FssDocumentPage clickOnRequiredArticleBacklink(String phraseAnchor) {
        getHelper(DocumentHelper.class).clickOnRequiredArticleBacklink(phraseAnchor);
        return this;
    }

    public FssDocumentPage clickOnTitleBacklink(String phraseAnchor) {
        getHelper(DocumentHelper.class).clickOnTitleBacklink(phraseAnchor);
        return this;
    }

    public FssDocumentPage checkNotepadPopupHasShadowFss() {
        getHelper(NotepadPopup.class).checkPopupHasShadowFSS();
        return this;
    }

    public FssDocumentPage checkNotepadPopupHeaderIsWhite() {
        getHelper(NotepadPopup.class).checkHeaderIsWhite();
        return this;
    }

    public FssDocumentPage checkNotepadPopupTitleIsPresent() {
        getHelper(NotepadPopup.class).checkTitleIsPresent();
        return this;
    }

    public FssDocumentPage checkNotepadPopupCloseIconIsPresent() {
        getHelper(NotepadPopup.class).checkCloseIconIsPresent();
        return this;
    }

    public FssDocumentPage checkNotepadPopupBodyIsYellow() {
        getHelper(NotepadPopup.class).checkBodyIsYellow();
        return this;
    }

    public FssDocumentPage checkNotepadPopupBodyHasBacklinks() {
        getHelper(NotepadPopup.class).checkBodyHasBacklinks();
        return this;
    }

    public FssDocumentPage checkNotepadPopupIsNotPresent() {
        getHelper(NotepadPopup.class).checkPopupIsNotPresent();
        return this;
    }

    public FssDocumentPage clickOnNotepadPopupCloseButton() {
        getHelper(NotepadPopup.class).clickOnCloseButton();
        return this;
    }

    public FssDocumentPage checkNotepadPopupMenuBlockIsPresent() {
        getHelper(NotepadPopup.class).checkMenuBlockIsPresent();
        return this;
    }

    public FssDocumentPage checkNotepadPopupMenuBlockIsNotPresent() {
        getHelper(NotepadPopup.class).checkMenuBlockIsNotPresent();
        return this;
    }

    public FssDocumentPage checkNotepadPopupMenuItemsInOrder(NotepadPopup.Item... items) {
        getHelper(NotepadPopup.class).checkMenuItemsInOrder(items);
        return this;
    }

    public FssDocumentPage checkNotepadPopupMenuItemIcon(NotepadPopup.Item... items) {
        getHelper(NotepadPopup.class).checkMenuItemIcon(items);
        return this;
    }

    public FssDocumentPage hoverOnNotepadPopupMenuItem(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).hoverOnMenuItem(item);
        return this;
    }

    public FssDocumentPage checkNotepadPopupMenuItemIsOrange(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).checkMenuItemIsOrange(item);
        return this;
    }

    public FssDocumentPage clickOnNotepadPopupMenu(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).clickOnMenu(item);
        return this;
    }

    public FssDocumentPage checkNotepadPopupMenuItemHasRightName(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).checkMenuItemHasRightName(item);
        return this;
    }

    public FssDocumentPage checkNotepadPopupMenuItemIsYellow(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).checkMenuItemIsYellow(item);
        return this;
    }

    public FssDocumentPage checkNotepadPopupMenuItemIsNotOrange(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).checkMenuItemIsNotOrange(item);
        return this;
    }

    public FssDocumentPage checkNotepadPopupScrollTo(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).checkScrollTo(item);
        return this;
    }

    public FssDocumentPage checkNotepadPopupMenuItemIsSelectedAfterScrolling(NotepadPopup.Item item) {
        getHelper(NotepadPopup.class).checkMenuItemIsSelectedAfterScrolling(item);
        return this;
    }

    public FssDocumentPage checkNotepadPopupTitleHasWhiteSpaceCSSValue() {
        getHelper(NotepadPopup.class).checkTitleHasWhiteSpaceCSSValue();
        return this;
    }

    public FssDocumentPage checkNotepadTitleEqualsWithPhraseTitle(String phraseAnchor) {
        getHelper(NotepadPopup.class).checkTitle(phraseAnchor);
        return this;
    }

    public FssDocumentPage checkNotepadTitleContainsWord(String phraseAnchor, String word) {
        getHelper(NotepadPopup.class).checkTitleContainsWord(phraseAnchor, word);
        return this;
    }

    public FssDocumentPage checkNotepadTitleIsAdditionalInformation() {
        getHelper(NotepadPopup.class).checkTitleIsAdditionalInformation();
        return this;
    }

    public FssDocumentPage clickOnBackLinkFromTitle() {
        getHelper(DocumentHelper.class).clickOnBackLinkFromTitle();
        return this;
    }

    public FssDocumentPage checkNotepadPopupSolutionsBlockFirstItemHasPhotoFullNameAndPosition() {
        getHelper(NotepadPopup.class).checkSolutionsBlockFirstItemHasPhotoFullNameAndPosition();
        return this;
    }

    public FssDocumentPage checkNotepadPopupRecomentdationBlockHasNoMoreThan10Links() {
        getHelper(NotepadPopup.class).checkRecomentdationBlockHasNoMoreThan10Links();
        return this;
    }

    public FssDocumentPage checkNotepadPopupRecomendationBlockHasLinks() {
        getHelper(NotepadPopup.class).checkRecomendationBlockHasLinks();
        return this;
    }

    public FssDocumentPage checkNotepadPopupFormsBlockHasLinks() {
        getHelper(NotepadPopup.class).checkFormsBlockHasLinks();
        return this;
    }

    public FssDocumentPage checkNotepadPopupFormsBlockHasNoMoreThan10Links() {
        getHelper(NotepadPopup.class).checkFormsBlockHasNoMoreThan10Links();
        return this;
    }

    public FssDocumentPage checkNotepadPopupHandbookBlockHasLinks() {
        getHelper(NotepadPopup.class).checkHandbookBlockHasLinks();
        return this;
    }

    public FssDocumentPage checkNotepadPopupHandbookBlockHasNoMoreThan10Links() {
        getHelper(NotepadPopup.class).checkHandbookBlockHasNoMoreThan10Links();
        return this;
    }

    public FssDocumentPage checkNotepadPopupPressBlockHasItems() {
        getHelper(NotepadPopup.class).checkPressBlockHasItems();
        return this;
    }

    public FssDocumentPage checkNotepadPopupPressBlockHasNoMoreThan10Links() {
        getHelper(NotepadPopup.class).checkPressBlockHasNoMoreThan10Links();
        return this;
    }

    public FssDocumentPage checkNotepadPopupLawBlockHasLinks() {
        getHelper(NotepadPopup.class).checkLawBlockHasLinks();
        return this;
    }

    public FssDocumentPage checkNotepadPopupLawBlockHasNoMoreThan10Links() {
        getHelper(NotepadPopup.class).checkLawBlockHasNoMoreThan10Links();
        return this;
    }

    public FssDocumentPage checkNotepadPopupLawPracticeBlockHasLinks() {
        getHelper(NotepadPopup.class).checkLawPracticeBlockHasLinks();
        return this;
    }

    public FssDocumentPage checkNotepadPopupLawPracticeBlockHasNoMoreThan10Links() {
        getHelper(NotepadPopup.class).checkLawPracticeBlockHasNoMoreThan10Links();
        return this;
    }

    public FssDocumentPage hoverOnNotepadPopupFirstLinkFromLawPractice() {
        getHelper(NotepadPopup.class).hoverOnFirstLinkFromLawPractice();
        return this;
    }

    public FssDocumentPage checkNotepadPopupFirstLinkFromLawPracticeBecomeAfterHoverOn() {
        getHelper(NotepadPopup.class).checkFirstLinkFromLawPracticeBecomeOrangeAfterHoverOn();
        return this;
    }

    public FssDocumentPage clickOnNotepadPopupFormsBlockRandomLink() {
        getHelper(NotepadPopup.class).clickOnFormsBlockRandomLink();
        return this;
    }

    public FssDocumentPage clickOnNotepadPopupHandbookBlockRandomLink() {
        getHelper(NotepadPopup.class).clickOnHandbookBlockRandomLink();
        return this;
    }

    public FssDocumentPage clickOnNotepadPopupLawBlockRandomLink() {
        getHelper(NotepadPopup.class).clickOnLawBlockRandomLink();
        return this;
    }

    public FssDocumentPage clickOnNotepadPopupPressBlockRandomLink() {
        getHelper(NotepadPopup.class).clickOnPressBlockRandomLink();
        return this;
    }

    public FssDocumentPage clickOnNotepadPopupLawPracticeBlockRandomLink() {
        getHelper(NotepadPopup.class).clickOnLawPracticeBlockRandomLink();
        return this;
    }

    public FssDocumentPage clickOnNotepadPopupSolutionsBlockRandomLink() {
        getHelper(NotepadPopup.class).clickOnSolutionsBlockRandomLink();
        return this;
    }

    public FssDocumentPage clickOnNotepadPopupVideosBlockRandomLink() {
        getHelper(NotepadPopup.class).clickOnVideosBlockRandomLink();
        return this;
    }

    public FssDocumentPage checkNotepadPopupFirstLinkFromLawPracticeBecomeOrangeAfterHoverOn() {
        getHelper(NotepadPopup.class).checkFirstLinkFromLawPracticeBecomeOrangeAfterHoverOn();
        return this;
    }

    public FssDocumentPage clickOnPrevButtonInTopMenu() {
        getHelper(DocumentHelper.class).clickOnPrevButtonInTopMenu();
        return this;
    }

    public FssDocumentPage clickOnNextButtonInTopMenu() {
        getHelper(DocumentHelper.class).clickOnNextButtonInTopMenu();
        return this;
    }

    public FssDocumentPage clickOnPreviousButtonInBottomMenu() {
        getHelper(DocumentHelper.class).clickOnPreviousButtonInBottomMenu();
        return this;
    }

    public FssDocumentPage clickOnNextButtonInBottomMenu() {
        getHelper(DocumentHelper.class).clickOnNextButtonInBottomMenu();
        return this;
    }

    public FssDocumentPage checkNextAndPrevButtonsInTopMenuArePresent() {
        getHelper(DocumentHelper.class).checkNextAndPrevButtonsInTopMenuArePresent();
        return this;
    }

    public FssDocumentPage checkNextAndPrevButtonsInBottomMenuArePresent() {
        getHelper(DocumentHelper.class).checkNextAndPrevButtonsInBottomMenuArePresent();
        return this;
    }

    public FssDocumentPage checkPrevButtonInTopIsAbsent() {
        getHelper(DocumentHelper.class).checkButtonPreviousInTopMenuIsNotPresent();
        return this;
    }

    public FssDocumentPage checkNextButtonInTopIsAbsent() {
        getHelper(DocumentHelper.class).checkButtonNextInTopMenuIsNotPresent();
        return this;
    }

    public FssDocumentPage checkNextButtonInBottomIsAbsent() {
        getHelper(DocumentHelper.class).checkButtonNextInBottomMenuIsNotPresent();
        return this;
    }

    public FssDocumentPage checkPrevButtonInBottomIsAbsent() {
        getHelper(DocumentHelper.class).checkButtonPreviousInBottomMenuIsNotPresent();
        return this;
    }

    public FssDocumentPage clickFirstArticleFromTableOfContents() {
        getHelper(DocumentHelper.class).clickFirstArticleFromTableOfContents();
        return this;
    }

    public FssDocumentPage clickLastArticleFromTableOfContents() {
        getHelper(DocumentHelper.class).clickLastArticleFromTableOfContents();
        return this;
    }

    public FssDocumentPage checkTableOfContentsIsNotEmpty() {
        getHelper(DocumentHelper.class).checkTableOfContentsIsNotEmpty("");
        return this;
    }

    public FssDocumentPage checkDocumentIsNotEmpty() {
        getHelper(DocumentHelper.class).checkDocumentIsNotEmpty();
        return this;
    }

    public FssDocumentPage checkMoreOnTheTopicIsPresent() {
        getHelper(DocumentHelper.class).checkMoreOnTheTopicIsPresent();
        return this;
    }

    public FssDocumentPage checkCommentsArePresent() {
        getHelper(DocumentHelper.class).checkCommentsArePresent();
        return this;
    }

    public FssDocumentPage checkRevisionHistoryIsPresent() {
        getHelper(DocumentHelper.class).checkRevisionHistoryLinkIsPresent();
        return this;
    }

    public FssDocumentPage clickOnRevisionHistoryLink() {
        getHelper(DocumentHelper.class).clickOnRevisionHistoryLink();
        return this;
    }

    public FssDocumentPage checkRevisionHistoryBlockIsOpened() {
        getHelper(DocumentHelper.class).checkRevisionHistoryBlockIsOpened();
        return this;
    }

    public FssDocumentPage checkRevisionHistoryTitleSpeciallyActionsIsPresent() {
        getHelper(DocumentHelper.class).checkRevisionHistoryTitleSpeciallyActionsIsPresent();
        return this;
    }

    public FssDocumentPage checkRevisionHistoryTitleContainsInDocumentIsPresent() {
        getHelper(DocumentHelper.class).checkRevisionHistoryTitleContainsInDocumentIsPresent();
        return this;
    }

    public FssDocumentPage clickOnRandomDocumentFromRevisionHistoryList() {
        getHelper(DocumentHelper.class).clickOnRandomDocumentFromRevisionHistoryList();
        return this;
    }

    public FssDocumentPage clickOnMoreLinksFromInfobarOfTheDocument() {
        getHelper(DocumentHelper.class).clickOnMoreLinksFromInfobarOfTheDocument();
        return this;
    }

    public FssDocumentPage checkMoreLinksLinkHasYellowHighlightAfterClicking() {
        getHelper(DocumentHelper.class).checkMoreLinksLinkHasYellowHighlightAfterClicking();
        return this;
    }

    public FssDocumentPage checkMoreLinksBlockIsOpened() {
        getHelper(DocumentHelper.class).checkMoreLinksBlockIsOpened();
        return this;
    }

    public FssDocumentPage checkMoreLinksHasTitleLinks() {
        getHelper(DocumentHelper.class).checkMoreLinksHasTitleLinks();
        return this;
    }

    public FssDocumentPage clickOnMoreLinksRandomLink() {
        getHelper(DocumentHelper.class).clickOnMoreLinksRandomLink();
        return this;
    }

    public FssDocumentPage checkMoreLinksAreDuplicatedBelowOfTheDocument() {
        getHelper(DocumentHelper.class).checkMoreLinksAreDuplicatedBelowOfTheDocument();
        return this;
    }

    public FssDocumentPage clickOnLinksFromInfobarInBottom() {
        getHelper(DocumentHelper.class).clickOnLinksFromInfobarInBottom();
        return this;
    }

    public FssDocumentPage checkStickyHeaderIsGray() {
        getHelper(DocumentHelper.class).checkStickyHeaderIsGray();
        return this;
    }

    public FssDocumentPage clickOnStickyHeader() {
        getHelper(DocumentHelper.class).clickOnStickyHeader();
        return this;
    }

    public FssDocumentPage checkStickyHeaderIsNotPresent() {
        getHelper(DocumentHelper.class).checkStickyHeaderIsNotPresent();
        return this;
    }

    public FssDocumentPage checkStickyHeaderScrolling() {
        getHelper(DocumentHelper.class).checkStickyHeaderScrolling();
        return this;
    }

    public FssDocumentPage checkQuickTocHasNumbers() {
        getHelper(DocumentHelper.class).checkQuickTocHasNumbers();
        return this;
    }

    public FssDocumentPage checkQuickTocDoesNotContainItemsReferencesAndLinks() {
        getHelper(DocumentHelper.class).checkQuickTocDoesNotContainItemsReferencesAndLinks();
        return this;
    }

    public FssDocumentPage checkScrolling() {
        getHelper(DocumentHelper.class).checkScrolling();
        return this;
    }

    public FssDocumentPage checkApplicationsWidgetIsPresent() {
        getHelper(DocumentHelper.class).checkApplicationsWidgetIsPresent();
        return this;
    }

    public FssDocumentPage clickOnInfobarApplicationsLink() {
        getHelper(DocumentHelper.class).clickOnInfobarApplicationsLink();
        return this;
    }

    public FssDocumentPage checkApplicationsTextsArePresent() {
        getHelper(AttachmentsInfobar.class).checkApplicationsTextsArePresent();
        return this;
    }

    public FssDocumentPage checkAttachedFilesAreAvailable() {
        getHelper(AttachmentsInfobar.class).checkAttachedFilesAreAvailable();
        return this;
    }

    public FssDocumentPage checkApplicationsExtensionsArePresent() {
        getHelper(AttachmentsInfobar.class).checkApplicationsExtensionsArePresent();
        return this;
    }

    @Override
    public FssDocumentPage checkVideoPlayerIsPresent() {
        getHelper(DocumentHelper.class).checkVideoPlayerIsPresent();
        return redirectTo(FssDocumentPage.class);
    }

    @Override
    public FssDocumentPage checkVideoTitleIsPresent() {
        getHelper(DocumentHelper.class).checkVideoTitleIsPresent();
        return redirectTo(FssDocumentPage.class);
    }

    public FssDocumentPage checkMetaTagsAndTableOfContents() {
        getHelper(DocumentHelper.class).checkMetaTagsAndTableOfContents();
        return this;
    }

    public FssDocumentPage checkMetaTagsAndSavedDataContent() {
        getHelper(DocumentHelper.class).checkMetaTagsAndSavedDataContent();
        return this;
    }
}
