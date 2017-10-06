package com.actionmedia.pages.helpers;

import com.actionmedia.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import javax.annotation.Nullable;
import java.util.List;
import java.util.regex.Pattern;

/**
 * User: n.tyukavkin
 * Date: 09.01.14
 * Time: 17:49
 */
@Component
public class RubricatorHelper extends BasePage<RubricatorHelper> {

    public static final String OPEN_KODEKS = "open.kodeks";
    public static final String OPEN_PART = "open.part";
    public static final String SELECTED_ITEM = "selected.item";
    public static final String OPEN_ARTICLE = "open.article";

    private static final By RUBRICATOR_MENU_LOCATOR = By.cssSelector(".b-rubricator-list");
    private static final By RUBRICATOR_ACTIVE_SECTION_LOCATOR = By.cssSelector(".b-link_state_active");
    private static final By RUBRICATOR_LOCATOR = By.id("rubricator");
    private static final By RUBRICATOR_BUTTON_LOCATOR = By.id("rubricator-btn");
    private static final By RUBRICATOR_SECTION_LOCATOR = By.cssSelector(".b-list_type_rubricator");
    private static final By RUBRICATOR_SEARCH_INPUT = By.id("searchstr");
    private static final By RUBRICATOR_CLOSE_BTN = By.id("rubricator-close");
    private static final By DOCUMENT_BODY_LOCATOR = By.id("document-body");

    @Step("Проверяется что кнопка рубрикатора нажата")
    public void checkRubricatorButtonIsPressed() {
        WebElement rubricatorBtn = waitForVisibilityOfElementLocatedBy(RUBRICATOR_BUTTON_LOCATOR, "Кнопка рубрикатора не найдена");
        postponedAssertTrue(rubricatorBtn.getAttribute("class").contains("pressed") || rubricatorBtn.getAttribute("class").contains("active"), "кнопка рубрикатора не нажата");
    }

    @Step("Проверяется подсветка выбранного элемента")
    public void checkActiveItemForFirstMenuIsHighlighted() {
        checkActiveItem(getMainMenu());
    }

    @Step("Проверяется подсветка выбранного элемента")
    public void checkActiveItemForSecondMenuIsHighlighted() {
        List<WebElement> columnList = getRubricator().findElements(RUBRICATOR_MENU_LOCATOR);
        if (columnList.size() > 1) {
            checkActiveItem(columnList.get(1));
        }
    }

    @Step("Проверяется подсветка выбранного элемента")
    public void checkActiveItemForThirdMenuIsHighlighted() {
        List<WebElement> columnList = getRubricator().findElements(RUBRICATOR_MENU_LOCATOR);
        if (columnList.size() > 2) {
            checkActiveItem(columnList.get(2));
        }
    }

    @Step("Проверяется что выбран первый элемент")
    public void checkFirstElementIsSelected() {
        WebElement firstElement = getMainMenu().findElements(By.tagName("li")).get(0);
        postponedAssertTrue(findElementByNoThrow(firstElement, RUBRICATOR_ACTIVE_SECTION_LOCATOR) != null, "Первый элемент не выбран");
    }

    /**
     * Проверяет, что подсвеченный элемент (в указанной колонке) = name
     *
     * @param name имя элемента
     * @param i    - "колонка" рубриктора, отсчет от 0.
     */
    @Step("Проверяется что у выбраного элемента имя = name")
    public void checkNameOfSelectedElementIs(String name, int i) {
        postponedAssertEquals(getMainMenu().findElements(RUBRICATOR_ACTIVE_SECTION_LOCATOR).get(i).getText(), name, "Выбранная рубрика не соответствует " + name);
    }

    @Step("Проверяется что кодекс имееет содержание")
    public void checkKodeksContentsIsPresent() {
        List<WebElement> contentsItemList = getContents().findElements(By.tagName("a"));
        String kodeksName = String.valueOf(getParameter(OPEN_KODEKS)) + " кодекс";
        if (getParameter(OPEN_PART) != null) {
            kodeksName = kodeksName + " " + String.valueOf(getParameter(OPEN_PART));
        }
        postponedAssertFalse(contentsItemList.isEmpty(), "Содержание для " + kodeksName + " Отсутствует");
    }

    @Step("Проверяется что документ имееет содержание")
    public void checkContentsIsPresent() {
        List<WebElement> contentsItemList = getContents().findElements(By.tagName("a"));
        String pbuName = String.valueOf(getParameter(SELECTED_ITEM));
        postponedAssertFalse(contentsItemList.isEmpty(), "Содержание для " + pbuName + " Отсутствует");
    }

    @Step("Проверяется что подсветка установлена на текущей статье")
    public void checkKodeksArticleIsHighlighted() {
        postponedAssertEquals(getOpenedKodeksName(), String.valueOf(getParameter(OPEN_KODEKS)), "Выбран неправильный кодекс в рубрикаторе");
        postponedAssertEquals(getOpenedPartName(), String.valueOf(getParameter(OPEN_PART)), "Выбрана неправильная часть кодекса в рубрикаторе");

        String selectedArticle = String.valueOf(getParameter(OPEN_ARTICLE));
        int selectedArticleNumber = getArticleByName(selectedArticle);
        int highlightedArticleNumber = getHighlightedArticleNumber();
        postponedAssertTrue(highlightedArticleNumber - 7 < selectedArticleNumber && highlightedArticleNumber + 7 > selectedArticleNumber, "Текущая статья не выбрана в рубрикаторе");
    }

    @Step("Проверяется что открытый элемент подсвечен")
    public void checkOpenedItemIsHighlighted() {
        List<WebElement> activeItem = getContents().findElements(By.cssSelector(".b-link_state_current"));
        postponedAssertFalse(activeItem.isEmpty(), "Не один элемент не выбран в содержании");
        if ((getSettings().isRunUss() || getSettings().isRunKss()) && getCurrentUrl().contains("wizard") && activeItem.size() > 1) {
            postponedAssertEquals(activeItem.get(1).getText(), String.valueOf(getParameter(OPEN_ARTICLE)), "Выбран неправильный элемент");
        } else {
            postponedAssertEquals(activeItem.get(0).getText(), String.valueOf(getParameter(OPEN_ARTICLE)), "Выбран неправильный элемент");
        }
    }

    @Step("Проверяется что рубрикатор закрыт")
    public void checkRubricatorIsClosed() {
        waitForReloadingPage();
        WebElement rubricator = findElementByNoThrow(RUBRICATOR_LOCATOR);
        postponedAssertTrue(rubricator != null && !rubricator.isDisplayed(), "Рубрикатор отображается");
    }

    @Step("Проверяется что рубрикатор открыт")
    public void checkRubricatorIsOpened() {
        WebElement rubricator = waitForVisibilityOfElementLocatedBy(By.id("rubricator"), "Рубрикатор не найден");
        WebElement activeItem = findElementByNoThrow(rubricator, By.cssSelector(".b-link_state_active"));
        assertNotNull(activeItem, "Не один элемент не выбран в меню рубрикатора");
    }

    @Step("Проверяется что кнопка рубрикатора не нажата")
    public void checkRubricatorButtonIsUnPressed() {
        waitForReloadingPage();
        WebElement rubricatorBtn = waitForVisibilityOfElementLocatedBy(RUBRICATOR_BUTTON_LOCATOR, "Кнопка рубрикатора не найдена");
        postponedAssertFalse(rubricatorBtn.getAttribute("class").contains("pressed"), "Кнопка рубрикатора нажата");
    }

    ///#/rubric/5/57/1928 getAttribute("href").contains("rubric/5/57/1928"))    getText() == "Microsoft Excel: Готовые решения — бери и пользуйся!"
    @Step("Проверяется отображаение книги 'Miscrosoft Excel: Готовые решения - бери и пользуйся' в новой вкладке")
    public void openFssExcel() {
        List<WebElement> links1 = waitForPresenceOfElementLocatedBy(RUBRICATOR_MENU_LOCATOR).findElements(By.tagName("li"));

        //Integer ind1 = links1.indexOf(findElementBy(By.tagName("a")).findElement(By.tagName("span")).getText().contains("Финансовый анализ и оценка"));

        List<WebElement> links = links1.subList(12, 13);//12.13

        for (WebElement section : links) {
            WebElement sectionLink = section.findElement(By.tagName("a"));

            if (sectionLink.getAttribute("class") != null && sectionLink.getAttribute("class").contains("no-rubric")) {
                continue;
            }

            String sectionName = sectionLink.getText();
            report("Открывается рубрика первого уровня '" + sectionName + "'");
            clickUseJS(sectionLink);
            List<WebElement> itemFromFirstSectionList = getContents().findElements(By.tagName("a"));
            postponedAssertFalse(itemFromFirstSectionList.isEmpty(), "Отсутсвуют элементы для рубрики первого уровня '" + sectionName + "'");
            List<WebElement> secondSubSections = findElementsBy(RUBRICATOR_MENU_LOCATOR);
            if (secondSubSections.size() > 1) {
                report("Проверяются элементы для рубрики второго уровня");
                List<WebElement> secondSubSectionLinks = secondSubSections.get(1).findElements(By.tagName("li"));

                List<WebElement> ssl = secondSubSectionLinks.subList(5, 6);

                for (WebElement secondSubSectionLink : ssl) {
                    WebElement secondSectionLink = secondSubSectionLink.findElement(By.tagName("a"));
                    String secondSectionName = secondSectionLink.getText();
                    report("Открывается рубрика второго уровня '" + secondSectionName + "'");
                    clickUseJS(secondSectionLink);
                    List<WebElement> itemList = getContents().findElements(By.tagName("a"));
                    postponedAssertNotNull(itemList, "Отсуствуют элементы в третьем уровне!");
                    WebElement linksToProv = getRandomElementInList(itemList);
                    //for (WebElement linksToProv : itemList) {
                    String linkText = linksToProv.getAttribute("href");
                    report("Open " + linkText);
                    openInNewWindow(linkText);
                    waitForDocumentIsOpened();
                    //postponedAssertTrue(getCurrentUrl().contains(linkText), "Открыта не правильная страница");
                    checkDocumentStyle();
                    checkDocumentHeader();
                    //goBack();
                }
            }
        }
    }

    @Step("Проверяется что рубрики всех уровней содержат контент")
    public void checkAllRubricatorSectionsHaveContent() {
        List<WebElement> links = waitForPresenceOfElementLocatedBy(RUBRICATOR_MENU_LOCATOR).findElements(By.tagName("li"));
        for (WebElement section : links) {
            WebElement sectionLink = section.findElement(By.tagName("a"));
            if (sectionLink.getAttribute("class") != null && sectionLink.getAttribute("class").contains("no-rubric")) {
                continue;
            }
            String sectionName = sectionLink.getText();
            report("Открывается рубрика первого уровня '" + sectionName + "'");
            clickUseJS(sectionLink);
            List<WebElement> itemFromFirstSectionList = getContents().findElements(By.tagName("a"));
            postponedAssertFalse(itemFromFirstSectionList.isEmpty(), "Отсутсвуют элементы для рубрики первого уровня '" + sectionName + "'");
            List<WebElement> secondSubSections = findElementsBy(RUBRICATOR_MENU_LOCATOR);
            if (secondSubSections.size() > 1) {
                report("Проверяются элементы для рубрики второго уровня");
                List<WebElement> secondSubSectionLinks = secondSubSections.get(1).findElements(By.tagName("li"));
                List<WebElement> randomSecondSectionLinks;
                if (secondSubSectionLinks.size() > 3) {
                    randomSecondSectionLinks = getRandomElementsInList(secondSubSectionLinks, 3);
                } else {
                    randomSecondSectionLinks = secondSubSectionLinks;
                }
                for (WebElement secondSubSectionLink : randomSecondSectionLinks) {
                    WebElement secondSectionLink = secondSubSectionLink.findElement(By.tagName("a"));
                    String secondSectionName = secondSectionLink.getText();
                    report("Открывается рубрика второго уровня '" + secondSectionName + "'");
                    clickUseJS(secondSectionLink);
                    List<WebElement> itemFromSecondSectionList = getContents().findElements(By.tagName("a"));
                    postponedAssertFalse(itemFromSecondSectionList.isEmpty(), "Отсутсвуют элементы для рубрики второго уровня '" + secondSectionName + "'");
                    List<WebElement> thirdSubSections = findElementsBy(RUBRICATOR_MENU_LOCATOR);
                    if (thirdSubSections.size() > 2) {
                        report("Проверяются элементы для рубрики третьего уровня");
                        List<WebElement> thirdSubSectionLinks = thirdSubSections.get(2).findElements(By.tagName("li"));
                        WebElement thirdSubSectionLink = getRandomElementInList(thirdSubSectionLinks);
                        WebElement thirdSectionLink = thirdSubSectionLink.findElement(By.tagName("a"));
                        String thirdSectionName = thirdSectionLink.getText();
                        report("Открывается рубрика третьего уровня '" + thirdSectionName + "'");
                        clickUseJS(thirdSectionLink);
                        List<WebElement> itemList = getContents().findElements(By.tagName("a"));
                        postponedAssertFalse(itemList.isEmpty(), "Отсутсвуют элементы для рубрики третьего уровня '" + thirdSectionName + "'");
                    }
                }
            }
        }
    }

    @Step("Открыть в новом окне рубрикатор")
    public void openRubricInNewTab() {
        List<WebElement> links = waitForPresenceOfElementLocatedBy(RUBRICATOR_MENU_LOCATOR).findElements(By.tagName("li"));
        WebElement sectionLink = getRandomElementInList(links).findElement(By.tagName("a"));
        String sectionName = sectionLink.getText();
        report("Открывается рубрика первого уровня '" + sectionName + "'");

        openInNewWindow(sectionLink.getAttribute("href"));
        waitFewSecond(1000);
        postponedAssertTrue(getCurrentUrl().contains("rubric"), "Не открылся рубрикатор");
    }

    @Step("Проверяется что рубрики всех уровней содержат контент")
    public void checkAllRubricator() {
        List<WebElement> links = waitForPresenceOfElementLocatedBy(RUBRICATOR_MENU_LOCATOR).findElements(By.tagName("li"));
        for (WebElement section : links) {
            WebElement sectionLink = section.findElement(By.tagName("a"));

            if (sectionLink.getAttribute("class") != null && sectionLink.getAttribute("class").contains("no-rubric")) {
                continue;
            }

            String sectionName = sectionLink.getText();
            report("Открывается рубрика первого уровня '" + sectionName + "'");
            clickUseJS(sectionLink);
            List<WebElement> itemFromFirstSectionList = getContents().findElements(By.tagName("a"));
            postponedAssertFalse(itemFromFirstSectionList.isEmpty(), "Отсутсвуют элементы для рубрики первого уровня '" + sectionName + "'");
            List<WebElement> secondSubSections = findElementsBy(RUBRICATOR_MENU_LOCATOR);
            if (secondSubSections.size() > 1) {
                report("Проверяются элементы для рубрики второго уровня");
                List<WebElement> secondSubSectionLinks = secondSubSections.get(1).findElements(By.tagName("li"));
                for (WebElement secondSubSectionLink : secondSubSections) {
                    WebElement secondSectionLink = secondSubSectionLink.findElement(By.tagName("a"));
                    String secondSectionName = secondSectionLink.getText();
                    report("Открывается рубрика второго уровня '" + secondSectionName + "'");
                    clickUseJS(secondSectionLink);
                    List<WebElement> itemFromSecondSectionList = getContents().findElements(By.tagName("a"));
                    postponedAssertFalse(itemFromSecondSectionList.isEmpty(), "Отсутсвуют элементы для рубрики второго уровня '" + secondSectionName + "'");
                    List<WebElement> thirdSubSections = findElementsBy(RUBRICATOR_MENU_LOCATOR);
                    if (thirdSubSections.size() > 2) {
                        report("Проверяются элементы для рубрики третьего уровня");
                        List<WebElement> thirdSubSectionLinks = thirdSubSections.get(2).findElements(By.tagName("li"));
                        for (WebElement linksItem : thirdSubSectionLinks) {
                            WebElement thirdSectionLink = linksItem.findElement(By.tagName("a"));
                            String thirdSectionName = thirdSectionLink.getText();
                            report("Открывается рубрика третьего уровня '" + thirdSectionName + "'");
                            clickUseJS(thirdSectionLink);
                            List<WebElement> itemList = getContents().findElements(By.tagName("a"));
                            postponedAssertNotNull(itemList, "Отсуствуют элементы в третьем уровне!");
                            for (WebElement linksToProv : itemList) {
                                String linkText = linksToProv.getAttribute("href").toString();
                                report("Open " + linkText);
                                linksToProv.click();
                                waitForDocumentIsOpened();
                                postponedAssertTrue(getCurrentUrl().contains(linkText), "Открыта не правильная страница");
                                goBack();
                            }
                        }
                    }
                }
            }
        }
    }

    @Step("Открыть случайный кодекс")
    public void clickRandomKodeks() {
        List<WebElement> kodeksList = getMainMenu().findElement(RUBRICATOR_SECTION_LOCATOR).findElements(By.tagName("li"));
        WebElement randomKodeks = getRandomElementInList(kodeksList);
        String kodeksName = randomKodeks.getText();
        setParameter(OPEN_KODEKS, kodeksName);
        report("Открывается '" + kodeksName + "' кодекс");
        randomKodeks.findElement(By.tagName("a")).click();
    }

    @Step("Открыть случайный ПБУ")
    public void clickRandomPBU() {
        List<WebElement> pbuList = getMainMenu().findElements(RUBRICATOR_SECTION_LOCATOR).get(1).findElements(By.tagName("li"));
        WebElement randomPbu = getRandomElementInList(pbuList);
        String pbuName = randomPbu.getText();
        setParameter(SELECTED_ITEM, pbuName);
        report("Открывается документ '" + pbuName + "'");
        randomPbu.findElement(By.tagName("a")).click();
    }

    @Step("Открыть случайную часть кодекса")
    public void clickRandomPart() {
        List<WebElement> columnList = getRubricator().findElements(RUBRICATOR_MENU_LOCATOR);
        if (columnList.size() > 1) {
            WebElement partColumn = getRubricatorMenuItemByNumber(1);
            WebElement randomPart = getRandomElementInList(partColumn.findElements(By.tagName("li")));
            String partName = randomPart.getText();
            setParameter(OPEN_PART, partName);
            randomPart.findElement(By.tagName("a")).click();
        } else {
            warning("В кодексе отсутсвуют части");
        }
    }

    @Step("Открыть случайную статью")
    public void clickRandomArticle() {
        List<WebElement> links = getContents().findElements(By.cssSelector("[href*='#/']"));
        if (links.size() > 1) {
            links.remove(0);
        }
        assertFalse(links.isEmpty(), "Список статей в рубрикаторе пустой");
        WebElement randomItem = getRandomElementInList(links);
        String itemName = randomItem.getText();
        String url = randomItem.getAttribute("href");
        setParameter(OPEN_KODEKS, getOpenedKodeksName());
        setParameter(OPEN_PART, getOpenedPartName());
        setParameter(OPEN_ARTICLE, itemName);
        report(getArticleNameReport(itemName, url));
        randomItem.click();
        waitForDocumentIsOpened();
    }

    @Step("Открыть случайную статью")
    public void clickRandomNotFirstAndNotLastArticle() {
        List<WebElement> links = getContents().findElements(By.cssSelector("[href*='#/']"));
        if (links.size() > 2) {
            links = links.subList(1, links.size() - 1);
            WebElement randomItem = getRandomElementInList(links);
            String itemName = randomItem.getText();
            String url = randomItem.getAttribute("href");
            setParameter(OPEN_KODEKS, getOpenedKodeksName());
            setParameter(OPEN_PART, getOpenedPartName());
            setParameter(OPEN_ARTICLE, itemName);
            report(getArticleNameReport(itemName, url));
            randomItem.click();
            waitForDocumentIsOpened();
        } else {
            getRandomElementInList(links).click();
        }
    }

    public boolean isNotFirstAndNotLastArticle() {
        return getContents().findElements(By.cssSelector("[href*='#/']")).size() > 2;
    }

    @Step("Открыть первую статью")
    public void clickFirstArticle() {
        List<WebElement> links = getContents().findElements(By.tagName("a"));
        WebElement randomItem;
        if (getParentElement(links.get(0)).getTagName().equals("h1")) {
            randomItem = links.get(1);
        } else {
            randomItem = links.get(0);
        }
        String itemName = randomItem.getText();
        String url = randomItem.getAttribute("href");
        setParameter(OPEN_KODEKS, getOpenedKodeksName());
        setParameter(OPEN_PART, getOpenedPartName());
        setParameter(OPEN_ARTICLE, itemName);
        report(getArticleNameReport(itemName, url));
        randomItem.click();
        waitForDocumentIsOpened();
    }

    @Step("Открыть последнюю статью")
    public void clickLastArticle() {
        List<WebElement> links = getContents().findElements(By.tagName("a"));
        WebElement randomItem = links.get(links.size() - 1);
        String itemName = randomItem.getText();
        String url = randomItem.getAttribute("href");
        setParameter(OPEN_KODEKS, getOpenedKodeksName());
        setParameter(OPEN_PART, getOpenedPartName());
        setParameter(OPEN_ARTICLE, itemName);
        report(getArticleNameReport(itemName, url));
        randomItem.click();
        waitForDocumentIsOpened();
    }

    @Step("Открыть расчетчик по номеру")
    public void clickCalculatorByNumber(int number) {
        report("Открывается " + number + " расчетчик");
        WebElement randomItem = getContents().findElements(By.tagName("a")).get(number - 1);
        String itemName = randomItem.getText();
        setParameter(OPEN_KODEKS, getOpenedKodeksName());
        setParameter(OPEN_PART, getOpenedPartName());
        setParameter(OPEN_ARTICLE, itemName);
        randomItem.click();
        waitForDocumentIsOpened();
    }

    @Step("Нажать на выбранный раздел в главном меню.")
    public void clickActiveMenuItem() {
        WebElement userProfileLink = waitForPresenceOfElementLocatedBy(By.id("main-menu"));
        userProfileLink.findElement(By.cssSelector(".btn_state_active")).click();
    }

    @Step("Открыть случайную рубрику первого уровня")
    public void clickRubricFromFirstMenuByName(String rubricName) {
        WebElement firstMenu = getRubricatorMenuItemByNumber(0);
        int numberOfRubricByName = -1;
        List<WebElement> mainRubricList = firstMenu.findElements(By.cssSelector(".b-rubricator-list__title-rubric"));
        List<WebElement> subRubricList = firstMenu.findElements(By.cssSelector(".b-list_type_rubricator"));
        for (int i = 0; i < mainRubricList.size(); i++) {
            WebElement mainRubric = mainRubricList.get(i);
            if (mainRubric.getText().equals(rubricName)) {
                numberOfRubricByName = i;
                break;
            }
        }
        if (numberOfRubricByName != -1) {
            List<WebElement> itemsInSubRubric = subRubricList.get(numberOfRubricByName).findElements(By.cssSelector(".b-link"));
            WebElement randomItem = getRandomElementInList(itemsInSubRubric);
            report("Открывается раздел '" + rubricName + "' в рубрике '" + rubricName + "'");
            randomItem.click();
        } else {
            fail("Рубрика '" + rubricName + "' не найдена в рубрикаторе");
        }
    }

    /**
     * Кликает по рубрике из первой колонки.
     *
     * @param rubricName - рубрика из первой колонки.
     */
    @Step("Открыть рубрику первого уровня по имени")
    public void clickRubricFromFirstColumnByName(String rubricName) {
        WebElement firstMenu = getRubricatorMenuItemByNumber(0);
        List<WebElement> subRubricList = firstMenu.findElements(By.cssSelector(".b-list_type_rubricator"));
        for (WebElement rubric_list_element : subRubricList) {
            List<WebElement> rubrics = rubric_list_element.findElements(By.cssSelector(".b-link"));
            for (WebElement rubric : rubrics) {
                if (rubric.getText().equals(rubricName)) {
                    report("Открывается раздел '" + rubricName + "' в рубрике '" + rubric_list_element.getText() + "'");
                    rubric.click();
                    return;
                }
            }
        }
        fail("Рубрика '" + rubricName + "' не найдена в рубрикаторе");
    }

    /**
     * Кликает по рубрике из первой колонки. Благодаря указанию метарубрики поиск осуществляется быстрее.
     *
     * @param metaRubric - рубрика самого верхнего уровня (некликабельная). Типа "Налоги" в БСС-рекомендациях.
     * @param rubricName - рубрика из первой колонки.
     */
    @Step("Открыть рубрику первого уровня")
    public void clickRubricFromFirstColumnByName(String metaRubric, String rubricName) {
        WebElement firstMenu = getRubricatorMenuItemByNumber(0);
        int numberOfRubricByName = -1;
        List<WebElement> mainRubricList = firstMenu.findElements(By.cssSelector(".b-rubricator-list__title-rubric"));
        List<WebElement> subRubricList = firstMenu.findElements(By.cssSelector(".b-list_type_rubricator:not(.b-list_type_rubricator-multigroup)"));
        for (int i = 0; i < mainRubricList.size(); i++) {
            WebElement mainRubric = mainRubricList.get(i);
            if (mainRubric.getText().equals(metaRubric)) {
                numberOfRubricByName = i;
                break;
            }
        }
        if (numberOfRubricByName != -1) {
            List<WebElement> itemsInSubRubric = subRubricList.get(numberOfRubricByName).findElements(By.cssSelector(".b-link"));
            WebElement rubricItem = null;
            for (WebElement rubric : itemsInSubRubric) {
                if (rubric.getText().equals(rubricName)) {
                    rubricItem = rubric;
                    report("Открывается раздел '" + rubricName + "' в рубрике '" + metaRubric + "'");
                    rubricItem.click();
                    break;
                }
            }
            if (rubricItem == null) fail("Рубрика '" + rubricName + "' не найдена в рубрикаторе");
        } else {
            fail("Рубрика '" + rubricName + "' не найдена в рубрикаторе");
        }
    }

    @Step("Открыть случайную рубрику первого уровня")
    public void clickRandomItemFromFirstMenu() {
        WebElement firstMenu = getRubricatorMenuItemByNumber(0);
        WebElement randomItem = getRandomElementInList(firstMenu.findElements(By.tagName("li")));
        WebElement randomItemLink = randomItem.findElement(By.tagName("a"));
        report("Открывается " + randomItemLink.getText());
        randomItemLink.click();
    }

    @Step("Открыть случайный журнал")
    public void clickRandomMagazine() {
        WebElement magazineMenu = getMainMenu().findElements(RUBRICATOR_SECTION_LOCATOR).get(0);
        WebElement randomItem = getRandomElementInList(magazineMenu.findElements(By.tagName("li")));
        report("Открывается " + randomItem.getText());
        randomItem.findElement(By.tagName("a")).click();
    }

    @Step("Открыть случайный журнал")
    public void clickRandomMagazineUss() {
        WebElement magazineMenu = getMainMenu().findElements(RUBRICATOR_SECTION_LOCATOR).get(2);
        WebElement randomItem = getRandomElementInList(magazineMenu.findElements(By.tagName("li")));
        report("Открывается " + randomItem.getText());
        randomItem.findElement(By.tagName("a")).click();
    }

    @Step("Открыть случайный комментарий")
    public void clickRandomCommentaries() {
        WebElement commentariesMenu = getMainMenu().findElements(RUBRICATOR_SECTION_LOCATOR).get(0);
        WebElement commentariesItem = commentariesMenu.findElement(By.tagName("li"));
        report("Открывается " + commentariesMenu.getText());
        commentariesItem.findElement(By.tagName("a")).click();
    }

    @Step("Открыть случайную книгу")
    public void clickRandomBook() {
        WebElement magazineMenu = getMainMenu().findElements(RUBRICATOR_SECTION_LOCATOR).get(1);
        WebElement randomItem = getRandomElementInList(magazineMenu.findElements(By.tagName("li")));
        report("Открывается " + randomItem.getText());
        randomItem.findElement(By.tagName("a")).click();
    }

    @Step("Открыть случайную книгу из Библиотека Журнала 'Главбух'")
    public void clickRandomBJGBook() {
        WebElement bookMenu = getMainMenu().findElements(RUBRICATOR_SECTION_LOCATOR).get(1);
        WebElement bookName = bookMenu.findElement(By.xpath("//span[text()='Библиотека журнала «Главбух»']"));
        report("Открывается " + bookName.getText());
        bookName.click();
    }

    @Step("Открыть случайный Мастер")
    public void clickRandomWizard() {
        WebElement wizardMenu = getMainMenu().findElements(RUBRICATOR_SECTION_LOCATOR).get(1);
        WebElement randomItem = getRandomElementInList(wizardMenu.findElements(By.tagName("li")));
        report("Открывается " + randomItem.getText());
        randomItem.findElement(By.tagName("a")).click();
    }

    @Step("Открыть случайный Мастер")
    public void clickRandomWizardKss() {
        WebElement wizardMenu = getMainMenu().findElements(RUBRICATOR_SECTION_LOCATOR).get(0);
        WebElement randomItem = getRandomElementInList(wizardMenu.findElements(By.tagName("li")));
        report("Открывается " + randomItem.getText());
        randomItem.findElement(By.tagName("a")).click();
    }

    @Step("Открыть случайный расчетчик")
    public void clickCalculatorSection() {
        WebElement calculatorMenu = getMainMenu().findElement(RUBRICATOR_SECTION_LOCATOR);
        WebElement randomItem = calculatorMenu.findElements(By.tagName("li")).get(1);
        report("Открывается " + randomItem.getText());
        randomItem.findElement(By.tagName("a")).click();
    }

    @Step("Открыть случайную рубрику второго уровня")
    public void clickRandomItemFromSecondMenu() {
        List<WebElement> columnList = getRubricator().findElements(RUBRICATOR_MENU_LOCATOR);
        if (columnList.size() > 1) {
            WebElement secondMenu = getRubricatorMenuItemByNumber(1);
            WebElement randomItem = getRandomElementInList(secondMenu.findElements(By.tagName("li")));
            report("Открывается " + randomItem.getText());
            randomItem.findElement(By.tagName("a")).click();
        } else {
            warning("Меню второго уровня Отсутствует");
        }
    }

    @Step("Открыть случайную рубрику третьего уровня")
    public void clickRandomItemFromThirdMenu() {
        List<WebElement> columnList = getRubricator().findElements(RUBRICATOR_MENU_LOCATOR);
        if (columnList.size() > 2) {
            WebElement thirdMenu = getRubricatorMenuItemByNumber(2);
            WebElement randomItem = getRandomElementInList(thirdMenu.findElements(By.tagName("li")));
            report("Открывается " + randomItem.getText());
            randomItem.findElement(By.tagName("a")).click();
        } else {
            warning("Меню третьего уровня Отсутствует");
        }
    }

    @Step("Найти кнопку Х для рубрикатора")
    public void checkCloseRubricatorButtonIsPresent() {
        WebElement closeBtn = findElementByNoThrow(RUBRICATOR_CLOSE_BTN);
        postponedAssertTrue(closeBtn.isDisplayed(), "Кнопка \"Закрыть рубрикатор\" не найдена");
    }

    public boolean checkString(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Step("Проверка, что строка являеься ссылкой на документ")
    public void checkDocumentLink(String link) {
        if (getCurrentUrl().contains("video") && link.contains("/163/")) {
            String pattern = "(.*?)\\/document\\/([0-9]*)\\/([0-9]*)\\/(.*?)*";
            Pattern p = Pattern.compile(pattern);
            postponedAssertTrue(p.matcher(link).find(), "Ссылка на документ не соответствует формату.");
        } else {
            if (getCurrentUrl().contains("video") && !link.contains("/163/")) {
                link = link.substring(0, link.length() - 1);
                postponedAssertTrue(link.contains("/documentvideo/"), "Не содержит ссылку на документ");
                postponedAssertTrue(checkString(link.substring(link.indexOf("documentvideo/") + 14, link.lastIndexOf("/"))), "Неверная ссылка " + link + " должно быть число: " + link.substring(link.indexOf("document/") + 9));
                postponedAssertTrue(checkString(link.substring(link.lastIndexOf("/") + 1)), "Неверная ссылка " + link + " должно быть число: " + link.substring(link.lastIndexOf("/") + 1));
            } else {
                // postponedAssertTrue(link.contains("/document/"), "Не содержит ссылку на документ");
                String pattern = "(.*?)\\/document\\/([0-9]*)\\/([0-9]*)\\/(.*?)*";
                Pattern p = Pattern.compile(pattern);
                //Matcher m = p.matcher(link);
                postponedAssertTrue(p.matcher(link).find(), "Ссылка на документ не соответствует формату.");
                //if (!getCurrentUrl().contains("law")) {
                //link = link.substring(0, link.lastIndexOf("/")); //для правовой базы - убираем якоря
                //
                // postponedAssertTrue(checkString(link.substring(link.indexOf("document/") + 9, link.lastIndexOf("/"))), "Неверная ссылка " + link + " должно быть число: " + link.substring(link.indexOf("document/") + 9));
                // postponedAssertTrue(checkString(link.substring(link.lastIndexOf("/") + 1)), "Неверная ссылка " + link + " должно быть число: " + link.substring(link.lastIndexOf("/") + 1));
            }
        }
    }


    @Step("Проверяется что рубрики всех уровней содержат контент")
    public void checkAllRubrics() {
        List<WebElement> links = waitForPresenceOfElementLocatedBy(RUBRICATOR_MENU_LOCATOR).findElements(By.tagName("li"));

        for (WebElement section : links) {
            WebElement sectionLink = section.findElement(By.tagName("a"));

            if (sectionLink.getAttribute("class") != null && sectionLink.getAttribute("class").contains("no-rubric")) {
                continue;
            }

            String sectionName = sectionLink.getText();
            report("Открывается рубрика первого уровня '" + sectionName + "'");
            clickUseJS(sectionLink);
            List<WebElement> itemFromFirstSectionList = getContents().findElements(By.tagName("a"));
            postponedAssertFalse(itemFromFirstSectionList.isEmpty(), "Отсутсвуют элементы для рубрики первого уровня '" + sectionName + "'");

            for (WebElement doclink : itemFromFirstSectionList) {
                if (doclink.getAttribute("href").contains("document")) {
                    checkDocumentLink(doclink.getAttribute("href"));
                }
            }

            List<WebElement> secondSubSections = findElementsBy(RUBRICATOR_MENU_LOCATOR);
            if (secondSubSections.size() > 1) {
                report("Проверяются элементы для рубрики второго уровня");
                List<WebElement> secondSubSectionLinks = secondSubSections.get(1).findElements(By.tagName("li"));
                for (WebElement secondSubSectionLink : secondSubSectionLinks) {
                    WebElement secondSectionLink = secondSubSectionLink.findElement(By.tagName("a"));
                    String secondSectionName = secondSectionLink.getText();
                    report("Открывается рубрика второго уровня '" + secondSectionName + "'");
                    clickUseJS(secondSectionLink);
                    List<WebElement> itemFromSecondSectionList = getContents().findElements(By.tagName("a"));
                    postponedAssertFalse(itemFromSecondSectionList.isEmpty(), "Отсутсвуют элементы для рубрики второго уровня '" + secondSectionName + "'");

                    for (WebElement doclink : itemFromSecondSectionList) {
                        if (doclink.getAttribute("href").contains("document")) {
                            checkDocumentLink(doclink.getAttribute("href"));
                        }
                    }

                    List<WebElement> thirdSubSections = findElementsBy(RUBRICATOR_MENU_LOCATOR);
                    if (thirdSubSections.size() > 2) {
                        report("Проверяются элементы для рубрики третьего уровня");
                        List<WebElement> thirdSubSectionLinks = thirdSubSections.get(2).findElements(By.tagName("li"));

                        for (WebElement thirdSubSectionLink : thirdSubSectionLinks) {
                            WebElement thirdSectionLink = thirdSubSectionLink.findElement(By.tagName("a"));
                            String thirdSectionName = thirdSectionLink.getText();
                            report("Открывается рубрика третьего уровня '" + thirdSectionName + "'");
                            clickUseJS(thirdSectionLink);
                            List<WebElement> itemList = getContents().findElements(By.tagName("a"));
                            postponedAssertFalse(itemList.isEmpty(), "Отсутсвуют элементы для рубрики третьего уровня '" + thirdSectionName + "'");

                            for (WebElement doclink : itemList) {
                                if (doclink.getAttribute("href").contains("document")) {
                                    checkDocumentLink(doclink.getAttribute("href"));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Step("Закрыть Рубрикатор")
    public void clickCloseRubricatorButton() {
        waitForVisibilityOfElementLocatedBy(RUBRICATOR_CLOSE_BTN, "Кнопка закрыть рубрикатор не найдена").click();
        waitForReloadingPage();
    }

    private String getOpenedKodeksName() {
        return getMainMenu().findElements(RUBRICATOR_ACTIVE_SECTION_LOCATOR).get(0).getText();
    }

    private String getOpenedPartName() {
        List<WebElement> columnList = getRubricator().findElements(RUBRICATOR_MENU_LOCATOR);
        if (columnList.size() > 1) {
            return columnList.get(1).findElement(RUBRICATOR_ACTIVE_SECTION_LOCATOR).getText();
        } else {
            return "";
        }
    }

    private int getArticleByName(String articleName) {
        List<WebElement> articleList = getContents().findElements(By.tagName("a"));
        for (WebElement article : articleList) {
            if (article.getText().equals(articleName)) {
                String numberString = getParentElement(article).findElement(By.cssSelector(".number")).getText().split("\\.")[0].trim();
                return Integer.parseInt(numberString);
            }
        }
        return -1;
    }

    private int getHighlightedArticleNumber() {
        WebElement highlightedArticle = getContents().findElement(By.cssSelector(".highlight"));
        String numberString = highlightedArticle.findElement(By.cssSelector(".number")).getText().split("\\.")[0].trim();
        return Integer.parseInt(numberString);
    }

    private void checkActiveItem(WebElement element) {
        WebElement activeItem = findElementByNoThrow(element, RUBRICATOR_ACTIVE_SECTION_LOCATOR);
        assertNotNull(activeItem, "Выбранный элемент не найден");
        postponedAssertTrue(activeItem.isEnabled() && activeItem.isDisplayed(), "Выбранный элемент не отображается");

        String backgroundColor = activeItem.getCssValue("background-color");
        postponedAssertTrue(backgroundColor != null && !backgroundColor.isEmpty(), "Выбранный элемент не подсвечен");
        if (backgroundColor != null && backgroundColor.contains("rgba(159, 180, 200,")) {
            warning("Неправильный цвет подсветки для выбранного элемента." +
                    " Expected: rgba(159, 180, 200, 0.25)" +
                    " Actual: " + backgroundColor);
        }
    }

    private WebElement getContents() {
        WebElement contents = waitForPresenceOfElementLocatedBy(By.id("rubricator-right"));
        waitForTextToBePresentInWithErrorMessage(contents, "Отсутствует текст в рубрикаторе");
        if (findElementByNoThrow(contents, By.cssSelector(".article")) != null) {
            WebElement articleElement = contents.findElement(By.cssSelector(".article"));
            waitForTextToBePresentInWithErrorMessage(articleElement, "Отсутствует текст в рубрикаторе");
        } else if (findElementByNoThrow(contents, By.tagName("ul")) != null) {
            List<WebElement> articleListElement = contents.findElements(By.tagName("ul"));
            for (WebElement article : articleListElement) {
                if (!article.findElements(By.tagName("a")).isEmpty()) {
                    waitForTextToBePresentInWithErrorMessage(article, "Отсутствует текст в рубрикаторе");
                    break;
                }
            }
        }
        return contents;
    }

    private WebElement getRubricator() {
        WebElement contents = waitForPresenceOfElementLocatedBy(RUBRICATOR_LOCATOR);
        waitForTextToBePresentInWithErrorMessage(contents, "Отсутствует текст в рубрикаторе");
        return contents;
    }

    private WebElement getMainMenu() {
        WebElement contents = waitForPresenceOfElementLocatedBy(RUBRICATOR_MENU_LOCATOR);
        waitForTextToBePresentInWithErrorMessage(contents, "Отсутствует текст в рубрикаторе");
        return contents;
    }

    private String getArticleNameReport(String itemName, String url) {
        if (itemName.isEmpty()) {
            return "Открывается документ " + url;
        } else {
            return "Открывается документ " + itemName;
        }
    }

    private WebElement getRubricatorMenuItemByNumber(final int itemNumber) {
        WebElement rubricator = waitForPresenceOfElementLocatedBy(By.id("rubricator"));
        waitForTextToBePresentInWithErrorMessage(rubricator, "Отсутствует текст в рубрикаторе");
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), getTimeout());
        try {
            wait.until(isRubricatorMenuReloaded(itemNumber));
            return findElementsBy(RUBRICATOR_MENU_LOCATOR).get(itemNumber);
        } catch (TimeoutException e) {
            logger.error("TimeoutException occurs", e);
            fail("Рубрикатор не обновился в течении " + getTimeout() + ".");
        }
        return null;
    }

    private ExpectedCondition<Boolean> isRubricatorMenuReloaded(final int itemNumber) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(@Nullable WebDriver driver) {
                try {
                    return !findElementsBy(RUBRICATOR_MENU_LOCATOR).get(itemNumber).getText().isEmpty();
                } catch (StaleElementReferenceException e) {
                    logger.error("StaleElementReferenceException occurs", e);
                    return false;
                }
            }
        };
    }

    private void waitForDocumentIsOpened() {
        waitForTextToBePresentIn(mainLeftElement);
        if (findElementByNoThrow(mainLeftElement, DOCUMENT_BODY_LOCATOR) != null) {
            waitForVisibilityOfElementLocatedBy(DOCUMENT_BODY_LOCATOR, "Документ не найден");
        } else {
            waitForVisibilityOfElementLocatedBy(By.cssSelector(".doc-preview"), "Документ не найден");
        }
    }

    @Step("Найти поле поиска для рубрикатора")
    public void checkSearchRubricatorInputIsPresent() {
        WebElement closeBtn = findElementByNoThrow(RUBRICATOR_SEARCH_INPUT);
        postponedAssertTrue(closeBtn.isDisplayed(), "Поле для поиска не найдено");
    }

    @Step("Кликнуть в поиск по рубриктору")
    public void clickSearchRubricatorInput() {
        waitForVisibilityOfElementLocatedBy(RUBRICATOR_SEARCH_INPUT, "Поле для поиска не найдено").click();
    }
}
