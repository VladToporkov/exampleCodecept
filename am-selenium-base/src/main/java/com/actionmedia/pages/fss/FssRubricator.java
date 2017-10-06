package com.actionmedia.pages.fss;

import com.actionmedia.pages.helpers.RubricatorHelper;
import com.actionmedia.pages.interfaces.IRubricator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 12.11.13
 * Time: 17:35
 */
@Component
public class FssRubricator extends FssBasePage<FssRubricator> implements IRubricator {

    public static final String SUB_SECTION_NAME = "sub.section.name";
    public static final String ICON_ID = "icon.id";
    public static final String OPEN_MAGAZINE = "open.magazine";
    public static final String CLOSE_MAGAZINE = "close.magazine";

    @Step("Проверяется что первый элемент в выбранном разделе подсвечен")
    public FssRubricator checkFirstItemIsSelected() {
        WebElement rubricatorMenu = waitForVisibilityOfElementLocatedBy(By.cssSelector(".b-menu"));
        WebElement selectedSection = rubricatorMenu.findElement(By.cssSelector(".selected"));
        if (!selectedSection.findElements(By.tagName("li")).isEmpty()) {
            List<WebElement> itemsList = selectedSection.findElement(By.cssSelector(".b-menu")).findElements(By.tagName("li"));
            WebElement firstItem = itemsList.get(0);
            postponedAssertTrue(firstItem.getAttribute("class") != null && "selected".equals(firstItem.getAttribute("class")), "Первый элемент не подсвечен");
        }
        return this;
    }

    @Step("Проверяется что раздел/подраздел имееет содержание")
    public FssRubricator checkContentIsPresent() {
        String sectionName = String.valueOf(getParameter(FssBasePage.RUBRICATOR_SECTION));
        WebElement rubricator = getRubricator();
        waitForTextToBePresentIn(rubricator);
        List<WebElement> itemsList = rubricator.findElement(By.cssSelector("[class*='rubric-']")).findElements(By.tagName("li"));
        postponedAssertFalse(itemsList.isEmpty(), "Содержание для " + sectionName + " Отсутствует");
        return this;
    }

    @Step("Проверяется что открытый элемент в рубрикаторе подсвечен")
    public FssRubricator checkOpenedItemIsHighlighted() {
        WebElement rubricator = getRubricator();
        String curItem = rubricator.findElement(By.cssSelector(".cur-position")).getText();
        String openedItem = String.valueOf(getParameter(ITEM_NAME));
        postponedAssertEquals(curItem, openedItem, "Открытый элемент в рубрикаторе не подсвечен");
        return this;
    }

    @Step("Проверяется что открытый элемент в рубрикаторе подсвечен")
    public FssRubricator checkOpenedKodeksItemIsHighlighted() {
        WebElement rubricator = getRubricator();
        String curItem = rubricator.findElement(By.cssSelector(".cur-position")).findElement(By.tagName("a")).getText();
        String openedItem = String.valueOf(getParameter(ITEM_NAME));
        postponedAssertEquals(curItem, openedItem, "Открытый элемент в рубрикаторе не подсвечен");
        return this;
    }

    @Step("Проверяется что открытый подраздел посвечен")
    public FssRubricator checkOpenedSubSectionsIsHighlighted() {
        WebElement selectedSection = sidebarElement.findElement(By.cssSelector(".selected"));
        if (!selectedSection.findElements(By.tagName("li")).isEmpty()) {
            WebElement selectedSubSection = sidebarElement.findElement(By.cssSelector(".b-menu")).findElement(By.cssSelector(".active")).findElement(By.cssSelector(".selected"));
            String openedSubSectionName = String.valueOf(getParameter(SUB_SECTION_NAME));
            postponedAssertEquals(selectedSubSection.getText(), openedSubSectionName, "Открытый подраздел не подсвечен");
        }
        return this;
    }

    @Step("Проверяется что всплывающее меню отображается после открытия случайной пиктограммы Другой подход")
    public FssRubricator checkDiffApproachContentIsPresent() {
        WebElement rubricator = waitForVisibilityOfElementLocatedBy(By.id("rubricator"), "Рубрикатор не найден");
        waitForTextToBePresentIn(rubricator);

        String iconId = String.valueOf(getParameter(ICON_ID));
        WebElement diffApproachContent = rubricator.findElement(By.cssSelector("[incut-id='" + iconId + "']"));
        postponedAssertTrue(diffApproachContent.isDisplayed(), "Всплывающее меню с ссылками на альтернативные (дополнительные) материалы не отображается");
        postponedAssertEquals(diffApproachContent.findElement(By.cssSelector(".caps")).getText(), "ДРУГОЙ ПОДХОД", "Неправильный текст заголовка всплывающего меню");
        postponedAssertFalse(diffApproachContent.findElement(By.cssSelector(".small")).getText().isEmpty(), "Отсутсвуют ссылки в всплывающем меню");
        return this;
    }

    @Step("Проверяется что всплывающее меню отображается после открытия случайной пиктограммы Другое решение")
    public FssRubricator checkAnotherSolutionsContentIsPresent() {
        WebElement rubricator = waitForVisibilityOfElementLocatedBy(By.id("rubricator"), "Рубрикатор не найден");
        waitForTextToBePresentIn(rubricator);

        String iconId = String.valueOf(getParameter(ICON_ID));
        WebElement diffApproachContent = rubricator.findElement(By.cssSelector("[incut-id='" + iconId + "']"));
        postponedAssertTrue(diffApproachContent.isDisplayed(), "Всплывающее меню с ссылками на альтернативные (дополнительные) материалы не отображается");
        postponedAssertEquals(diffApproachContent.findElement(By.cssSelector(".caps")).getText(), "ДОКУМЕНТЫ С РЕШЕНИЕМ", "Неправильный текст заголовка всплывающего меню");
        postponedAssertFalse(diffApproachContent.findElement(By.cssSelector(".small")).getText().isEmpty(), "Отсутсвуют ссылки в всплывающем меню");
        return this;
    }

    @Step("Проверяется что Содержание открыто")
    public FssRubricator checkSoderContentIsPresent() {
        WebElement randomMagazine = (WebElement) getParameter(OPEN_MAGAZINE);
        WebElement inCut = randomMagazine.findElement(By.cssSelector(".b-incut"));
        WebElement inCutContent = inCut.findElement(By.cssSelector(".body")).findElement(By.cssSelector(".small"));
        waitForTextToBePresentIn(inCut);
        List<WebElement> linksInInCut = inCut.findElements(By.tagName("a"));
        postponedAssertTrue(inCutContent.isDisplayed(), "Содержание книги/журнала не раскрылось");
        postponedAssertFalse(linksInInCut.isEmpty(), "Отсутсвуют ссылки в содержании");
        return this;
    }

    @Step("Проверяется что Содержание закрыто")
    public FssRubricator checkSoderContentIsNotPresent() {
        WebElement randomMagazine = (WebElement) getParameter(CLOSE_MAGAZINE);
        WebElement inCut = randomMagazine.findElement(By.cssSelector(".b-incut"));
        WebElement inCutContent = inCut.findElement(By.cssSelector(".body"));
        postponedAssertFalse(inCutContent.isDisplayed(), "Содержание книги/журнала не закрылось");
        return this;
    }

    @Step("Проверяется что открытое видео в рубрикаторе подсвечено")
    public FssRubricator checkOpenedVideoIsHighlighted() {
        WebElement rubricator = getRubricator();
        waitForTextToBePresentIn(rubricator);
        WebElement curItemInSoder = rubricator.findElement(By.cssSelector(".cur-position"));
        WebElement videoItem = getParentElement(getParentElement(getParentElement(getParentElement(curItemInSoder))));
        WebElement itemHeader = videoItem.findElement(By.tagName("h3"));
        String selectedVideoName = itemHeader.getText();
        String openedVideoName = String.valueOf(getParameter(ITEM_NAME));
        postponedAssertEquals(selectedVideoName, openedVideoName, "Открытое видео в рубрикаторе не подсвечено");
        return this;
    }

    @Step("Закрыть рубрикатор")
    public FssRubricator clickCloseRubricatorButton() {
        getHelper(RubricatorHelper.class).clickCloseRubricatorButton();
        return this;
    }

    @Step("Открыть случайный элемент из рубрикатора")
    public FssDocumentPage clickRandomItemFromRubricator() {
        List<WebElement> itemsList = getItems();
        WebElement randomItem = getRandomElementInList(itemsList);
        report("Открывается " + randomItem.getText());
        setParameter(ITEM_NAME, randomItem.getText());
        randomItem.click();
        waitForReloadingPage();
        return redirectTo(FssDocumentPage.class);
    }

    @Step("Открыть случайный элемент из рубрикатора")
    public FssDocumentPage clickRandomItemFromKodeksRubricator() {
        List<WebElement> itemsList = getKodeksItems();
        WebElement randomItem = getRandomElementInList(itemsList);
        report("Открывается " + randomItem.getText());
        setParameter(ITEM_NAME, randomItem.getText());
        randomItem.click();
        waitForReloadingPage();
        return redirectTo(FssDocumentPage.class);
    }

    @Step("Открыть случайное Содержание")
    public FssRubricator openRandomSoderLink() {
        List<WebElement> magazines = getMagazinesItems();
        WebElement randomMagazine = getRandomElementInList(magazines);
        WebElement inCut = randomMagazine.findElement(By.cssSelector(".b-incut"));
        WebElement soder = inCut.findElement(By.cssSelector(".switch"));
        setParameter(OPEN_MAGAZINE, randomMagazine);
        scrollIntoView(soder);
        soder.click();
        scrollIntoView(inCut);
        waitForTextToBePresentIn(inCut);
        return this;
    }

    @Step("Закрыть открытое Содержание")
    public FssRubricator closeOpenedSoderLink() {
        WebElement inCut = waitForVisibilityOfElementLocatedBy(By.cssSelector(".opened"));
        WebElement soder = inCut.findElement(By.cssSelector(".switch"));
        setParameter(CLOSE_MAGAZINE, getParentElement(inCut));
        soder.click();
        return this;
    }

    @Step("Открыть случайную статью из содержания")
    public FssDocumentPage clickRandomLinkFromSoder() {
        WebElement inCut = waitForVisibilityOfElementLocatedBy(By.cssSelector(".opened"));
        WebElement soder = inCut.findElement(By.cssSelector(".body"));
        List<WebElement> articleLinks = soder.findElements(By.tagName("a"));
        WebElement randomArticleLink = getRandomArticle(articleLinks);
        String randomArticleName = randomArticleLink.getText();
        setParameter(ITEM_NAME, randomArticleName);
        randomArticleLink.click();
        return redirectTo(FssDocumentPage.class);
    }

    //TODO: add scroll for invisible video items
    @Step("Открыть случайное видео")
    public FssDocumentPage clickRandomVideoLink() {
        WebElement rubricator = getRubricator();
        List<WebElement> videosLinkList = rubricator.findElements(By.tagName("h3"));
        videosLinkList = videosLinkList.subList(0, 3);
        WebElement randomVideoLink = getRandomElementInList(videosLinkList);
        String randomVideoName = randomVideoLink.getText();
        setParameter(ITEM_NAME, randomVideoName);
        randomVideoLink.findElement(By.tagName("a")).click();
        return redirectTo(FssDocumentPage.class);
    }

    @Step("Открыть случайный подраздел в рубрикаторе")
    public FssRubricator clickRandomSubSectionsInRubricator() {
        List<WebElement> subSectionsList = sidebarElement.findElement(By.cssSelector(".b-menu")).findElement(By.cssSelector(".selected")).findElements(By.tagName("li"));
        if (!subSectionsList.isEmpty()) {
            subSectionsList.remove(0);
            WebElement randomSubSection = getRandomElementInList(subSectionsList);
            String randomSubSectionName = randomSubSection.getText();
            report("Открывается " + randomSubSectionName);
            setParameter(SUB_SECTION_NAME, randomSubSectionName);
            randomSubSection.findElement(By.tagName("a")).click();
        }
        return this;
    }

    @Step("Открыть случайную пиктограмму Другой подход")
    public FssRubricator clickFirstDifferentApproach() {
        clickFirstAdditionalElement(By.cssSelector(".alt"));
        return this;
    }

    @Step("Открыть случайную пиктограмму Другое решение")
    public FssRubricator clickFirstAnotherSolutions() {
        clickFirstAdditionalElement(By.cssSelector(".solutions"));
        return this;
    }

    @Step("Закрыть рубрикатор на странице результатов поиска")
    public FssSearchResultPage closeAndNavigateToSearchResultPage() {
        clickCloseRubricatorButton();
        return redirectTo(FssSearchResultPage.class);
    }

    public FssRubricator checkNameOfSelectedElementIs(String name, int i) {
        getHelper(RubricatorHelper.class).checkNameOfSelectedElementIs(name, i);
        return this;
    }

    public FssRubricator checkAllRubricatorSectionsHaveContent() {
        getHelper(RubricatorHelper.class).checkAllRubricatorSectionsHaveContent();
        return this;
    }

    public FssRubricator openFssBooks() {
        getHelper(RubricatorHelper.class).openFssExcel();
        return this;
    }

    public FssRubricator openRubricInNewTab() {
        getHelper(RubricatorHelper.class).openRubricInNewTab();
        return this;
    }

    public FssRubricator checkAllRubricsInRubricator() {
        getHelper(RubricatorHelper.class).checkAllRubrics();
        return this;
    }

    private void clickFirstAdditionalElement(By by) {
        List<WebElement> rubricatorSectionList = getRubricatorSections();
        int sectionsCounter = 0;
        while (!isDiffApproachPresent(by)) {
            rubricatorSectionList.get(sectionsCounter).findElement(By.tagName("a")).click();
            List<WebElement> subSectionsList = sidebarElement.findElement(By.cssSelector(".b-menu")).findElement(By.cssSelector(".selected")).findElements(By.tagName("li"));

            for (WebElement subSection : subSectionsList) {
                if (isDiffApproachPresent(by)) {
                    break;
                }
                subSection.findElement(By.tagName("a")).click();
            }

            sectionsCounter++;
        }

        WebElement firstAdditionalElement = getFirstAdditionalElement(by);
        String iconId = firstAdditionalElement.getAttribute("icon-id");
        setParameter(ICON_ID, iconId);
        WebElement rubricator = findElementBy(By.cssSelector(".b-rubricator"));
        while (!firstAdditionalElement.isDisplayed()) {
            rubricator.click();
            rubricator.sendKeys(Keys.ARROW_DOWN);
        }
        firstAdditionalElement.click();
        waitFewSecond(1000);
    }

    private List<WebElement> getItems() {
        List<WebElement> items = new ArrayList<WebElement>();
        WebElement rubricator = getRubricator();
        waitForTextToBePresentIn(rubricator);
        List<WebElement> itemsList = rubricator.findElement(By.cssSelector(".rubric-list")).findElements(By.cssSelector(".small"));
        for (WebElement item : itemsList) {
            if (item.isDisplayed()) {
                items.add(item);
            }
        }
        return items;
    }

    private List<WebElement> getKodeksItems() {
        List<WebElement> items = new ArrayList<WebElement>();
        WebElement rubricator = getRubricator();
        waitForTextToBePresentIn(rubricator);
        List<WebElement> itemsList = rubricator.findElement(By.cssSelector(".rubric-law")).findElements(By.cssSelector(".go"));
        for (WebElement item : itemsList) {
            if (item.isDisplayed()) {
                items.add(item);
            }
        }
        return items;
    }

    private List<WebElement> getMagazinesItems() {
        List<WebElement> items = new ArrayList<WebElement>();
        WebElement rubricator = getRubricator();
        waitForTextToBePresentIn(rubricator);
        List<WebElement> itemsList = rubricator.findElement(By.cssSelector("[class*='rubric-']")).findElements(By.tagName("li"));
        for (WebElement item : itemsList) {
            if (item.isDisplayed() && item.getAttribute("class") != null && "clear".equals(item.getAttribute("class"))) {
                items.add(item);
            }
        }
        return items;
    }

    private WebElement getRandomArticle(List<WebElement> articleLinks) {
        List<WebElement> showedArticleLinks = new ArrayList<WebElement>();
        for (WebElement articleLink : articleLinks) {
            if (articleLink.isDisplayed()) {
                showedArticleLinks.add(articleLink);
            }
        }
        return getRandomElementInList(showedArticleLinks);
    }

    private WebElement getFirstAdditionalElement(By by) {
        WebElement rubricator = getRubricator();
        List<WebElement> diffApproachIconList = rubricator.findElements(by);
        return diffApproachIconList.get(0);
    }

    private boolean isDiffApproachPresent(By by) {
        WebElement rubricator = getRubricator();
        waitForTextToBePresentIn(rubricator);
        List<WebElement> diffApproachIconList = rubricator.findElements(by);
        return !diffApproachIconList.isEmpty();
    }

    private List<WebElement> getRubricatorSections() {
        List<WebElement> rubricatorSections = new ArrayList<WebElement>();
        List<WebElement> sectionsList = sidebarElement.findElement(By.cssSelector(".b-menu")).findElements(By.tagName("li"));
        for (WebElement section : sectionsList) {
            if (section.isDisplayed()) {
                if (getParentElement(section).getAttribute("class").contains("small")) {
                    rubricatorSections.add(section);
                }
            }
        }
        return rubricatorSections;
    }

    protected WebElement getRubricator() {
        return waitForVisibilityOfElementLocatedBy(By.id("rubricator"), "Рубрикатор не найден");
    }

    public FssRubricator checkRubricatorIsOpened() {
        getHelper(RubricatorHelper.class).checkRubricatorIsOpened();
        return this;
    }

    public FssRubricator clickRandomItemFromFirstMenu() {
        getHelper(RubricatorHelper.class).clickRandomItemFromFirstMenu();
        return this;
    }

    public FssDocumentPage clickRandomArticle() {
        getHelper(RubricatorHelper.class).clickRandomArticle();
        return redirectTo(FssDocumentPage.class);
    }

    public FssDocumentPage clickFirstArticle() {
        getHelper(RubricatorHelper.class).clickFirstArticle();
        return redirectTo(FssDocumentPage.class);
    }

    public FssDocumentPage clickLastArticle() {
        getHelper(RubricatorHelper.class).clickLastArticle();
        return redirectTo(FssDocumentPage.class);
    }

    public FssDocumentPage clickRandomNotFirstAndNotLastArticle() {
        getHelper(RubricatorHelper.class).clickRandomNotFirstAndNotLastArticle();
        return redirectTo(FssDocumentPage.class);
    }
}
