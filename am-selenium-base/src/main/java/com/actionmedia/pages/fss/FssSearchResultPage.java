package com.actionmedia.pages.fss;

import com.actionmedia.components.Link;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.ExtendedSearchForm;
import com.actionmedia.pages.helpers.SearchResultHelper;
import com.actionmedia.pages.interfaces.ISearchResultPage;
import com.actionmedia.util.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 14.11.13
 * Time: 16:52
 */
@Component
public class FssSearchResultPage extends FssBasePage<FssSearchResultPage> implements ISearchResultPage {

    public static final String FILTER_NAME = "filter.name";
    public static final String RESULT_NUMBER = "result.number";

    @Step("Проверяется что результаты поиска на странице 'Решения' отображаются")
    public FssSearchResultPage checkSearchResultOnSolutionsPageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.FSS_SOLUTIONS);
        getHelper(SearchResultHelper.class).checkSearchResultOnSolutionsPageIsOpened();
        return this;
    }

    @Step("Проверяется пустая поисковая выдача на странице 'Решения'")
    public FssSearchResultPage checkSearchResultOnSolutionsPageIsNotPresent() {
        checkCurrentItemIsSelected(MainMenuButtons.FSS_SOLUTIONS);
        getHelper(SearchResultHelper.class).checkSearchResultOnSolutionPageIsNotPresent();
        return this;
    }

    @Step("Проверяется что результаты поиска на странице 'Справочник' отображаются")
    public FssSearchResultPage checkSearchResultOnDictionaryPageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.DICTIONARY);
        getHelper(SearchResultHelper.class).checkSearchResultOnDictionaryPageIsOpened("В справочнике найден", MainMenuButtons.DICTIONARY);
        return this;
    }

    @Step("Проверяется пустая поисковая выдача на странице 'Справочник'")
    public FssSearchResultPage checkSearchResultOnDictionaryPageIsNotPresent() {
        checkCurrentItemIsSelected(MainMenuButtons.DICTIONARY);
        getHelper(SearchResultHelper.class).checkSearchResultOnDictionaryPageIsNotPresent();
        return this;
    }

    @Step("Проверяется что результаты поиска на странице 'Положения и регламенты' отображаются")
    public FssSearchResultPage checkSearchResultOnFormsPageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.FSS_FORMS);
        getHelper(SearchResultHelper.class).checkSearchResultIsPresent("В положениях и регламентах");
        return this;
    }

    @Step("Проверяется пустая поисковая выдача на странице 'Положения и регламенты'")
    public FssSearchResultPage checkSearchResultOnFormsPageIsNotPresent() {
        checkCurrentItemIsSelected(MainMenuButtons.FSS_FORMS);
        getHelper(SearchResultHelper.class).checkSearchResultOnFormsFssPageIsNotPresent();
        return this;
    }

    @Step("Проверяется что результаты поиска на странице 'Правовая база' отображаются")
    public FssSearchResultPage checkSearchResultOnLawBasePageIsOpenedBoolean(boolean isWithAttribute) {
        checkCurrentItemIsSelected(MainMenuButtons.FSS_LAW_BASE);
        checkSearchResultIsPresent(isWithAttribute);
        checkSearchResultCounter(isWithAttribute);
        return this;
    }

    @Step("Проверяется пустая поисковая выдача на странице 'Правовая база'")
    public FssSearchResultPage checkSearchResultOnLawBasePageIsNotPresent(boolean isWithAttribute) {
        checkCurrentItemIsSelected(MainMenuButtons.FSS_LAW_BASE);
        checkSearchResultOnLawBaseIsNotPresent(isWithAttribute);
        checkPopularBlockIsPresent();
        checkImageLoadedInPopularBlock();
        return this;
    }

    public FssSearchResultPage checkSearchResultOnLawBasePageIsNotPresent() {
        checkCurrentItemIsSelected(MainMenuButtons.LAW_BASE);
        getHelper(SearchResultHelper.class).checkSearchResultOnLawBasePageIsNotPresent();
        return this;
    }

    @Step("Проверяется что результаты поиска на странице 'Библиотека' отображаются")
    public FssSearchResultPage checkSearchResultOnMagazinesPageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.LIBRARY);
        getHelper(SearchResultHelper.class).checkSearchResultOnMagazinesPageIsOpened("В библиотеке найден", true, MainMenuButtons.LIBRARY);
        return this;
    }

    @Step("Проверяется пустая поисковая выдача на странице 'Библиотека'")
    public FssSearchResultPage checkSearchResultOnMagazinesPageIsNotPresent() {
        checkCurrentItemIsSelected(MainMenuButtons.LIBRARY);
        getHelper(SearchResultHelper.class).checkSearchResultOnMagazinesPageIsNotPresent(MainMenuButtons.LIBRARY);
        return this;
    }

    @Step("Проверяется что результаты поиска на странице 'Видео' отображаются")
    public FssSearchResultPage checkSearchResultOnVideoPageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.VIDEO);
        getHelper(SearchResultHelper.class).checkSectionFilterIsPresent();
        getHelper(SearchResultHelper.class).checkSearchResultIsPresent("В видео найден");
        getHelper(SearchResultHelper.class).checkVideosFilter();
        return this;
    }

    @Step("Проверяется пустая поисковая выдача на странице 'Видео'")
    public FssSearchResultPage checkSearchResultOnVideoPageIsNotPresent() {
        checkCurrentItemIsSelected(MainMenuButtons.VIDEO);
        getHelper(SearchResultHelper.class).checkSearchResultOnVideosPageIsNotPresent();
        return this;
    }

    @Step("Проверяется что документ присутсвует в поисковой выдаче")
    public FssSearchResultPage checkDocumentWithTextIsPresent(String documentText) {
        report("Проверяется что документ с текстом '" + documentText + "' присутсвует в поисковой выдаче");
        List<WebElement> resultHeaderList = findElementsBy(By.cssSelector(".widget-header"));
        boolean isDocumentPresent = false;

        for (WebElement result : resultHeaderList) {
            if (TestUtils.replaceIllegalCharacters(result.getText().toLowerCase()).contains(documentText.toLowerCase())) {
                isDocumentPresent = true;
                break;
            }
        }

        postponedAssertTrue(isDocumentPresent, "Документ с текстом '" + documentText + "' Отсутствует в поисковой выдаче");
        if (isDocumentPresent) {
            report("Документ с текстом '" + documentText + "' присутсвует в поисковой выдаче");
        }
        return this;
    }

    @Step("Проверяется что документы присутсвует в поисковой выдаче")
    public FssSearchResultPage checkDocumentsWithTextIsPresent(String documentText) {
        report("Проверяется что документ с текстом '" + documentText + "' присутсвует в поисковой выдаче");
        List<WebElement> resultHeaderList = findElementsBy(By.cssSelector(".widget-header u"));
        boolean isDocumentPresent = false;

        for (WebElement result : resultHeaderList) {
            if (!TestUtils.replaceIllegalCharacters(result.getText().toLowerCase()).contains(documentText.toLowerCase())) {
                setPostponedTestFail("Документ '" + result.getText() + "' не удовлетворяет условиям поиска в поисковой " +
                        "выдаче. В заголовке документа отсуствует текст:" + documentText);
            }
        }

        postponedAssertTrue(isDocumentPresent, "Документ с текстом '" + documentText + "' Отсутствует в поисковой выдаче");
        if (isDocumentPresent) {
            report("Документ с текстом '" + documentText + "' присутсвует в поисковой выдаче");
        }
        return this;
    }

    @Step("Проверяется что в выдаче документы из модуля")
    public FssSearchResultPage checkDocumentModuleId(String moduleId) {
        report("Проверяется что документ с модулем '" + moduleId + "' присутсвует в поисковой выдаче");
        List<WebElement> resultHeaderList = findElementsBy(By.cssSelector(".widget-header a"));
        boolean isDocumentPresent = false;

        for (WebElement result : resultHeaderList) {
            if (TestUtils.replaceIllegalCharacters(result.getAttribute("href")).contains(moduleId)) {
                isDocumentPresent = true;
                break;
            }
        }

        postponedAssertTrue(isDocumentPresent, "Документ с модулем '" + moduleId + "' Отсутствует в поисковой выдаче");
        if (isDocumentPresent) {
            report("Документ с модулем '" + moduleId + "' присутсвует в поисковой выдаче");
        }
        return this;
    }

    @Step("Проверяется что документ с заданным url присутсвует в поисковой выдаче")
    public FssSearchResultPage checkDocumentWithUrlIsPresent(String documentUrl) {
        report("Проверяется что документ с url '" + documentUrl + "' присутсвует в поисковой выдаче");
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".b-search"));
        List<WebElement> resultHeaderList = content.findElements(By.cssSelector(".clear"));
        boolean isDocumentPresent = false;

        for (WebElement result : resultHeaderList) {
            WebElement link = findElementByNoThrow(result, By.tagName("a"));
            if (link != null) {
                String actualUrl = link.getAttribute("href");
                if (actualUrl.contains(documentUrl)) {
                    isDocumentPresent = true;
                    break;
                }
            }
        }

        postponedAssertTrue(isDocumentPresent, "Документ с url '" + documentUrl + "' Отсутствует в поисковой выдаче");
        if (isDocumentPresent) {
            report("Документ с url '" + documentUrl + "' присутсвует в поисковой выдаче");
        }
        return this;
    }

    @Step("Проверяется исправления опечаток/раскладки клавиатуры в поисковом запросе")
    public FssSearchResultPage checkTypoWasFixed(String typoString, String fixedString) {
        getHelper(SearchResultHelper.class).checkTypoWasFixed(typoString, fixedString);
        return this;
    }

    @Step("Проверяется что слова из поискового запроса подсвечены")
    public FssSearchResultPage checkWordFromQueryIsHighlighted(String query) {
        List<WebElement> resultItemsList = getResultItemsWithoutScroll();
        List<String> highlightedWordList = new ArrayList<String>();

        for (WebElement result : resultItemsList) {
            WebElement header = result.findElement(By.cssSelector(".title-link"));
            String[] urlArr = header.getAttribute("href").split("#")[1].split("\\/");
            int moduleId = Integer.parseInt(urlArr[2]);
            int documentId = Integer.parseInt(urlArr[3]);
            highlightedWordList.addAll(getHighlightsWordListForDocument(query, moduleId, documentId));
        }

        for (WebElement result : resultItemsList) {
            List<WebElement> highlightedElementsList = result.findElements(By.tagName("b"));
            for (WebElement highlightedElement : highlightedElementsList) {
                String highlightedWord = highlightedElement.getText().toLowerCase();
                postponedAssertTrue(highlightedWordList.contains(highlightedWord),
                        "Выделено слово не из поискового запроса. Поисковый запрос: " + query + "' . Выделенное слово: '" + highlightedWord + "'");
            }
        }
        return this;
    }

    @Step("Проверяется что слова из поискового запроса в документе подсвечены")
    public FssSearchResultPage checkWordFromQueryIsHighlightedInDocument(String query) {
        checkHighlightedInDocument(query, getRandomDocumentLinkFromSearchResult());
        checkHighlightedInDocument(query, getRandomDocumentLinkFromSearchResult());
        checkHighlightedInDocument(query, getRandomDocumentLinkFromSearchResult());
        return this;
    }

    @Step("Проверяется что првеью для видео отображается")
    public FssSearchResultPage checkImageLoaded() {
        List<WebElement> imgList = new ArrayList<WebElement>();
        List<WebElement> resultItemsList = getResultItems();
        for (WebElement resultItem : resultItemsList) {
            imgList.addAll(resultItem.findElements(By.tagName("img")));
        }

        for (WebElement img : imgList) {
            String url = getParentElement(img).getAttribute("href");
            postponedAssertTrue(isImageLoaded(img), "Превью не отображается для " + url);
        }
        return this;
    }

    //TODO refactoring
    @Step("Проверяется заголовок результатов поиска с фильтрами")
    public FssSearchResultPage checkNumberOfResults(String query) {
        String filterName = String.valueOf(getParameter(FILTER_NAME));
        int numberOfResults = (Integer) getParameter(RESULT_NUMBER);
//        int resultItemsSize = getResultItems().size();
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".doc-body"));
        WebElement header = content.findElement(By.tagName("h3"));
        List<WebElement> countArr = header.findElements(By.tagName("strong"));

        String queryInHeader = countArr.get(0).getText();
        String filterInHeader = countArr.get(1).getText();
        int numberOfResultsInHeader = 0;
        if (countArr.size() == 3) {
            numberOfResultsInHeader = Integer.parseInt(countArr.get(2).getText());
        } else if (countArr.size() == 4) {
            numberOfResultsInHeader += Integer.parseInt(countArr.get(2).getText());
            numberOfResultsInHeader += Integer.parseInt(countArr.get(3).getText());
        }

        postponedAssertEquals(queryInHeader, query, "Неправильный поисковый запрос в заголовке результатов поиска");
        postponedAssertEquals(filterInHeader, filterName, "Неправильное название фильтра в заголовке результатов поиска");
        postponedAssertEquals(numberOfResultsInHeader, numberOfResults, "Неправильное количество найденных результатов в заголовке результатов поиска");
//        postponedAssertEquals(numberOfResultsInHeader, resultItemsSize, "Количество ссылок в результатах поиска не равно количеству в заголовке");

        postponedAssertTrue(header.getText().contains("По запросу «" + query + "» с учётом фильтра " + filterName + " найдено "),
                "Неправильный формат заголовка результата поиска");
        return this;
    }

    @Step("Проверяется заголовок результатов поиска с фильтрами")
    public FssSearchResultPage checkNumberOfResultsInLawBase(String query) {
        String filterName = String.valueOf(getParameter(FILTER_NAME));
        int resultItemsSize = getResultItems().size();
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".doc-body"));
        WebElement header = content.findElement(By.tagName("h3"));
        List<WebElement> countArr = header.findElements(By.tagName("strong"));

        String queryInHeader = countArr.get(0).getText();
        String filterInHeader = countArr.get(1).getText();
        int numberOfResultsInHeader = 0;
        if (countArr.size() == 3) {
            numberOfResultsInHeader = Integer.parseInt(countArr.get(2).getText());
        } else if (countArr.size() == 4) {
            numberOfResultsInHeader += Integer.parseInt(countArr.get(2).getText());
            numberOfResultsInHeader += Integer.parseInt(countArr.get(3).getText());
        }

        postponedAssertEquals(queryInHeader, query, "Неправильный поисковый запрос в заголовке результатов поиска");
        postponedAssertEquals(filterInHeader, filterName, "Неправильное название фильтра в заголовке результатов поиска");
        if (header.getText().contains("более 55")) {
            postponedAssertTrue(resultItemsSize > 55, "Количество ссылок в результатах поиска не равно количеству в заголовке");
        } else {
            postponedAssertEquals(numberOfResultsInHeader, resultItemsSize, "Количество ссылок в результатах поиска не равно количеству в заголовке");
        }

        postponedAssertTrue(header.getText().contains("В правовой базе по запросу «" + query + "» с учётом фильтра " + filterName + " найдено "),
                "Неправильный формат заголовка результата поиска");
        return this;
    }

    @Step("Проверяются хлебные крошки в поисковой выдаче")
    public FssSearchResultPage checkBreadcrumb() {
        String filterName = String.valueOf(getParameter(FILTER_NAME));
        List<WebElement> resultItemsList = getResultItems();
        boolean isBreadcrumbPresent = false;
        for (WebElement resultItem : resultItemsList) {
            List<WebElement> linFssectionList = resultItem.findElements(By.cssSelector(".b-links"));
            String itemLink = resultItem.findElement(By.cssSelector(".title-link")).getText();
            if (!linFssectionList.isEmpty() && "Из раздела".equalsIgnoreCase(linFssectionList.get(0).findElement(By.tagName("h4")).getText())) {
                String sectionName = linFssectionList.get(0).findElement(By.tagName("a")).getText();
                if (sectionName.equals("Остальные")) {
                    isBreadcrumbPresent = true;
                    continue;
                }
                postponedAssertEquals(sectionName, filterName, "Неправильное значение хлебных крошек для " + itemLink);
                isBreadcrumbPresent = true;
            }
        }
        postponedAssertTrue(isBreadcrumbPresent, "Хлебные крошки для раздела отсутсвуют");
        return this;
    }

    @Step("Проверяются хлебные крошки в поисковой выдаче")
    public FssSearchResultPage checkBreadcrumbInMagazines() {
        String filterName = String.valueOf(getParameter(FILTER_NAME));
        List<WebElement> resultItemsList = getResultItems();
        boolean isBreadcrumbPresent = false;
        for (WebElement resultItem : resultItemsList) {
            String titleLink = resultItem.findElement(By.cssSelector(".title-link")).getText();
            WebElement linFssection = resultItem.findElement(By.cssSelector(".faint"));
            String itemLink = linFssection.getText();
            if ("Книги".equals(filterName)) {
                postponedAssertTrue(itemLink.contains("Книга"), "Неправильное значение хлебных крошек для " + titleLink);
                isBreadcrumbPresent = true;
            } else {
                String magazineName = itemLink.split("«")[1].split("»")[0];
                postponedAssertEquals(magazineName, filterName, "Неправильное значение хлебных крошек для " + titleLink);
                isBreadcrumbPresent = true;
            }
        }
        postponedAssertTrue(isBreadcrumbPresent, "Хлебные крошки для раздела отсутсвуют");
        return this;
    }

    @Step("Проверяется что фильтры для переключения поиска по разделам отображаются")
    public FssSearchResultPage checkSearchFiltersArePresent() {
        getHelper(SearchResultHelper.class).checkBranchFilterIsPresent();
        return this;
    }

    @Step("Проверяется работа ссылок на странице результатов поиска")
    public FssSearchResultPage checkRandomLinksOnSearchResultPage() {
        List<Link> linkList = new ArrayList<Link>();
        List<WebElement> resultItems = getResultItemsWithoutScroll();
        for (WebElement resultItem : resultItems) {
            String url = resultItem.findElement(By.tagName("a")).getAttribute("href");
            String header = resultItem.findElement(By.tagName("a")).getText();
            Link link = new Link(url, header);
            linkList.add(link);
        }
        linkList = linkList.subList(0, 5);
        checkLinks(linkList);
        refreshPage();
        return this;
    }

    @Step("Проверяется работа ссылок из блока 'Популярное' при пустой поисковой выдаче")
    public FssSearchResultPage checkRandomLinksFromPopularBlock() {
        WebElement content = getPage();
        WebElement popularBlock = content.findElement(By.cssSelector(".doc-body"));
        List<WebElement> popularItems = popularBlock.findElements(By.cssSelector("[href*='/#/document']"));
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement item : popularItems) {
            String url = item.getAttribute("href");
            String header = item.getText();
            Link link = new Link(url, header);
            linkList.add(link);
        }
        linkList = linkList.subList(0, 5);
        checkLinks(linkList);
        return this;
    }

    @Step("Выбрать фильтр в рубрикаторе")
    public FssSearchResultPage clickFilterByName(String filterName) {
        WebElement filter = sidebarElement.findElement(By.cssSelector(".active"));
        filter.findElement(By.xpath("//a[text()='" + filterName + "']")).click();
        waitForReloadingPage();
        return this;
    }

    @Step("Выбрать случайный раздел в фильтре")
    public FssSearchResultPage clickRandomFilter() {
        WebElement filterSection = sidebarElement.findElement(By.cssSelector(".active"));
        WebElement randomFilter = getRandomElementInList(filterSection.findElements(By.tagName("li")));
        String randomFilterName = randomFilter.findElement(By.tagName("a")).getText();
        String numberOfResultInFilterString = randomFilter.findElement(By.cssSelector(".b-update")).findElement(By.tagName("a")).getText();
        int numberOfResult = Integer.parseInt(numberOfResultInFilterString);
        setParameter(FILTER_NAME, randomFilterName);
        setParameter(RESULT_NUMBER, numberOfResult);
        randomFilter.findElement(By.tagName("a")).click();
        report("Выбран " + randomFilterName);
        waitForReloadingPage();
        return this;
    }

    @Step("Выбрать случайный раздел в фильтре")
    public FssSearchResultPage clickRandomFilterInLawBase() {
        WebElement filterSection = sidebarElement.findElement(By.cssSelector(".active"));
        WebElement randomFilter = getRandomElementInList(filterSection.findElements(By.tagName("li")));
        String randomFilterName = randomFilter.findElement(By.tagName("a")).getText();
        setParameter(FILTER_NAME, randomFilterName);
        randomFilter.findElement(By.tagName("a")).click();
        report("Выбран " + randomFilterName);
        waitForReloadingPage();
        return this;
    }

    @Step("Выбрать раздел в рубрикаторе поиска")
    public FssSearchResultPage clickSectionInRubricatorByName(String sectionName) {
        WebElement rubricatorMenu = sidebarElement.findElement(By.cssSelector(".b-menu"));
        rubricatorMenu.findElement(By.xpath("//a[text()='" + sectionName + "']")).click();
        report("Выбран " + sectionName);
        waitForReloadingPage();
        return this;
    }

    @Step("Проверяется что результаты поиска отображаются")
    public FssSearchResultPage checkSearchResultIsPresent(boolean isWithAttribute) {
        if (getParameter(FssBasePage.QUERY) != null) {
            String query = String.valueOf(getParameter(FssBasePage.QUERY));
            checkSearchBox(query);
        }
        WebElement content = getPage();
        WebElement contentBody = content.findElement(By.id("main-article"));
        WebElement searchResult = findElementByNoThrow(contentBody, By.cssSelector(".b-search"));

        postponedAssertNotNull(searchResult, "Результаты поиска не найдены");
        postponedAssertTrue(searchResult.isDisplayed(), "Результаты поиска не отображаются");

        WebElement searchResultHeader = contentBody.findElement(By.cssSelector(".doc-header"));
        String searchResultHeaderText = searchResultHeader.getText().split("\n")[0];
        if (isWithAttribute) {
            postponedAssertEquals(searchResultHeaderText, "РЕЗУЛЬТАТЫ ПОИСКА ПО РЕКВИЗИТАМ", "Неправильный заголовок сраницы результатов поиска по реквизитам");
        } else {
            postponedAssertEquals(searchResultHeaderText, "РЕЗУЛЬТАТЫ ПОИСКА", "Неправильный заголовок сраницы результатов поиска");
        }
        return this;
    }

    public FssSearchResultPage checkSearchResultOnLawBasePageIsOpened(boolean isDefault) {
        checkCurrentItemIsSelected(MainMenuButtons.LAW_BASE);
        getHelper(SearchResultHelper.class).checkSearchResultOnLawBasePageIsOpened(isDefault);
        return this;
    }

    public FssSearchResultPage checkSearchResultOnLawBasePageIsOpened(boolean isDefault, String departmentFilter) {
        checkCurrentItemIsSelected(MainMenuButtons.LAW_BASE);
        getHelper(SearchResultHelper.class).checkSearchResultOnLawBasePageIsOpened(isDefault, departmentFilter);
        return this;
    }

    @Step("Проверяется что результаты поиска отсутвуют")
    public FssSearchResultPage checkSearchResultOnLawBaseIsNotPresent(boolean isWithAttribute) {
        String query = String.valueOf(getParameter(FssBasePage.QUERY));
        WebElement content = getPage();

        WebElement result = findElementByNoThrow(content, By.cssSelector(".doc-header"));
        assertNotNull(result, "Отсутствует страница результатов поиска при пустой поисковой выдаче");

        WebElement header = findElementByNoThrow(result, By.tagName("h1"));
        postponedAssertNotNull(header, "Отсутствует заголовок результатов поиска при пустой поисковой выдаче");
        if (header != null) {
            if (isWithAttribute) {
                postponedAssertEquals(header.getText(), "РЕЗУЛЬТАТЫ ПОИСКА ПО РЕКВИЗИТАМ", "Неправильный заголовок сраницы результатов поиска по реквизитам");
            } else {
                postponedAssertEquals(header.getText(), "РЕЗУЛЬТАТЫ ПОИСКА", "Неправильный заголовок сраницы результатов поиска");
            }
        }

        WebElement bodyFirstPart = findElementByNoThrow(result, By.tagName("h2"));
        WebElement bodySecondPart = findElementByNoThrow(result, By.tagName("p"));
        postponedAssertNotNull(bodyFirstPart, "Отсутствует заглушка при пустой поисковой выдаче");
        postponedAssertNotNull(bodySecondPart, "Отсутствует заглушка при пустой поисковой выдаче");
        if (bodyFirstPart != null) {
            postponedAssertTrue(bodyFirstPart.getText().trim().contains(query) &&
                            (bodyFirstPart.getText().trim().contains("В правовой базе ничего не найдено.") || bodyFirstPart.getText().trim().contains("К сожалению, по запросу «" + query + "» ничего не найдено.")),
                    "Неправильный текст заглушки при пустой поисковой выдаче");
        }
        if (bodySecondPart != null) {
            postponedAssertEquals(bodySecondPart.getText().trim(), "Пожалуйста, посмотрите в других разделах, переформулируйте запрос или поищите через рубрикатор.", "Неправильный текст заглушки при пустой поисковой выдаче");
        }
        return this;
    }

    @Step("Проверяется что количество найденных документов")
    public FssSearchResultPage checkSearchResultCounter(boolean isWithAttribute) {
        String query = String.valueOf(getParameter(FssBasePage.QUERY));
        WebElement content = getPage();
        WebElement searchResult = content.findElement(By.id("main-article"));
        WebElement searchResultBody = searchResult.findElement(By.cssSelector(".doc-body"));
        WebElement searchResultCounter = searchResultBody.findElement(By.tagName("h3"));
        String searchResultCounterText = searchResultCounter.getText();
        if (!isWithAttribute) {
            postponedAssertTrue(searchResultCounterText.contains("По запросу «" + query.toLowerCase() + "» найдено") ||
                            searchResultCounterText.contains("по запросу «" + query.toLowerCase() + "» найдено более 55") &&
                                    searchResultCounterText.contains("Попробуйте уточнить запрос.")
                    , "Неправильный формат заголовка результатов поиска");
        }
        if (!searchResultCounterText.contains("более 55")) {
            postponedAssertTrue(isResultCountContainsNumber(searchResultCounter), "В заголоке результатов поиска Отсутствует количество найденных документов");
        }
        return this;
    }

    @Step("Проверяется что подсказка с прямым переходом открывает документ")
    public FssSearchResultPage checkDocumentIsOpened() {
        getHelper(SearchResultHelper.class).checkDocumentIsOpened();
        return this;
    }

    @Step("Проверяется скролл на странице результатов поиска")
    public FssSearchResultPage checkScrollingOnSearchResultPage() {
        List<WebElement> beforeScroll = getResultItemsWithoutScroll();

        scroll(5);

        List<WebElement> afterScroll = getResultItemsWithoutScroll();
        postponedAssertTrue(afterScroll.size() > beforeScroll.size(), "Результаты поиска не подгружаются после скролла");
        return this;
    }

    @Step("Проверяется что ссылки в поисковой выдаче не повторяются")
    public FssSearchResultPage checkSearchResultsAreNotRepeated() {
        List<WebElement> resultsList = waitForVisibilityOfAllElementsLocatedBy(By.cssSelector(".title-link"));
        List<String> linkList = new ArrayList<String>();
        for (WebElement result : resultsList) {
            if (findElementByNoThrow(result, By.tagName("img")) != null) {
                continue;
            }
            String itemLink = result.getAttribute("href");
            postponedAssertFalse(linkList.contains(itemLink), "Ссылка '" + result.getText() + "' повторяется");
            linkList.add(itemLink);
        }
        return this;
    }

    @Step("Проверяется что блок 'Популярное' присутсвует в пустой поисковой выдачи.")
    public FssSearchResultPage checkPopularBlockIsPresent() {
        WebElement content = getPage();
        WebElement popularBlock = findElementByNoThrow(content, By.cssSelector(".doc-body"));
        postponedAssertNotNull(popularBlock, "Блок 'Популярное' не найден");
        if (popularBlock != null) {
            WebElement header = popularBlock.findElement(By.tagName("h1"));
            postponedAssertEquals(header.getText().trim(), "ПОПУЛЯРНОЕ", "Неправильный заголовок блока 'Популярное'");

            List<WebElement> popularItems = popularBlock.findElements(By.cssSelector(".b-news"));
            postponedAssertFalse(popularItems.isEmpty(), "Отсутсвуют элементы в блоке 'Популярное'");
        }
        return this;
    }

    @Step("Проверяется что картинки отображаются в блоке 'Популярное'")
    public FssSearchResultPage checkImageLoadedInPopularBlock() {
        WebElement content = getPage();
        WebElement popularBlock = content.findElement(By.cssSelector(".doc-body"));
        List<WebElement> imgList = popularBlock.findElements(By.tagName("img"));
        for (WebElement img : imgList) {
            postponedAssertTrue(isImageLoaded(img), "Картинка не загружена '" + img.getAttribute("src") + "'");
        }
        return this;
    }

    @Step("Проверяется что чекбокс 'Искать с эталонными запросами' отображается")
    public FssSearchResultPage checkSearchWithStandardCheckboxIsPresent() {
        WebElement content = getPage();
        WebElement standardCheckBox = findElementByNoThrow(content, By.id("with-etalon"));
        postponedAssertNotNull(standardCheckBox, "Чекбокс 'Искать с эталонными запросами' не найден");
        if (standardCheckBox != null) {
            postponedAssertTrue(standardCheckBox.isDisplayed(), "Чекбокс 'Искать с эталонными запросами' не отображается");
            postponedAssertTrue(standardCheckBox.isSelected(), "Чекбокс 'Искать с эталонными запросами' не выбран");
        }
        return this;
    }

    @Step("Проверяется что ссылка 'Показать релевантности' отображается")
    public FssSearchResultPage checkShowRelevanceLinkCheckboxIsPresent() {
        WebElement content = getPage();
        WebElement standardCheckBox = findElementByNoThrow(content, By.id("with-etalon"));
        postponedAssertNotNull(standardCheckBox, "Ссылка 'Показать релевантности' не найдена");
        if (standardCheckBox != null) {
            postponedAssertTrue(standardCheckBox.isDisplayed(), "Ссылка 'Показать релевантности' не отображается");
        }
        return this;
    }

    @Step("Проверяется что чекбокс 'Искать с эталонными запросами' отображается")
    public FssSearchResultPage checkSearchTypesArePresent() {
        List<WebElement> searchResultList = getResultItemsWithoutScroll();
        for (WebElement result : searchResultList) {
            String resultName = result.findElement(By.cssSelector(".title-link")).getText();
            WebElement searchType = findElementByNoThrow(result, By.cssSelector(".expert-search-type"));
            postponedAssertNotNull(searchType, "Отсутствует тип поиска для '" + resultName + "'");
        }
        return this;
    }

    @Step("Поверяется что в заголовке результатов поиска отображается надпись")
    public FssSearchResultPage checkSearchResultHeaderContainsText(String expectedText) {
        WebElement content = getPage();
        WebElement header = content.findElement(By.cssSelector(".doc-body"));
        String headerText = header.getText().toLowerCase();
        postponedAssertTrue(headerText.contains(expectedText.toLowerCase()), "В заголовке результатов поиска не отображается надпись '" + expectedText + "'");
        return this;
    }

    @Step("Поверяется что в заголовке результатов поиска не отображается надпись")
    public FssSearchResultPage checkSearchResultHeaderNotContainsText(String expectedText) {
        WebElement content = getPage();
        WebElement header = content.findElement(By.cssSelector(".doc-body"));
        String headerText = header.getText().toLowerCase();
        postponedAssertFalse(headerText.contains(expectedText.toLowerCase()), "В заголовке результатов поиска отображается надпись '" + expectedText + "'");
        return this;
    }

    @Step("Проверяется что в поисковой выдачи присутсвуют различные типы поиска")
    public FssSearchResultPage checkSearchTypeListContainsDefinedTypes(String... definedTypeList) {
        WebElement content = getPage();
        List<WebElement> searchTypeList = content.findElements(By.cssSelector(".expert-search-type"));
        for (String definedType : definedTypeList) {
            boolean isContains = false;
            for (WebElement searchType : searchTypeList) {
                String actualSearchType = searchType.findElement(By.tagName("abbr")).getAttribute("title");
                if (definedType.equals(actualSearchType)) {
                    isContains = true;
                    break;
                }
            }
            postponedAssertTrue(isContains, "В поисковой выдачи Отсутствует '" + definedType + "'");
        }
        return this;
    }

    @Step("Проверяется что в поисковой выдачи Отсутствует заданный тип поиска")
    public FssSearchResultPage checkSearchTypeListNotContainsDefinedTypes(String... definedTypeList) {
        WebElement content = getPage();
        List<WebElement> searchTypeList = content.findElements(By.cssSelector(".expert-search-type"));
        for (String definedType : definedTypeList) {
            boolean isContains = false;
            for (WebElement searchType : searchTypeList) {
                String actualSearchType = searchType.findElement(By.tagName("abbr")).getAttribute("title");
                if (definedType.equals(actualSearchType)) {
                    isContains = true;
                    break;
                }
            }
            postponedAssertFalse(isContains, "В поисковой выдачи присутсвует '" + definedType + "'");
        }
        return this;
    }

    @Step("Проверяется что чекбокс 'Искать в найденом' отображется")
    public FssSearchResultPage checkSearchInResultsCheckBoxIsPresent() {
        WebElement searchBox = waitForVisibilityOfElementLocatedBy(By.id("form-search"));
        WebElement searchInResultsCheckbox = findElementByNoThrow(searchBox, By.name("holdreq"));
        postponedAssertNotNull(searchInResultsCheckbox, "Чекбокс 'Искать в найденом' не найден");
        if (searchInResultsCheckbox != null) {
            postponedAssertTrue(searchInResultsCheckbox.isDisplayed(), "Чекбокс 'Искать в найденом' не отображется");
            postponedAssertTrue(searchInResultsCheckbox.isEnabled(), "Чекбокс 'Искать в найденом' не активен");
        }
        return this;
    }

    @Step("Проверяется что чекбокс 'Искать в найденом' не выбран")
    public FssSearchResultPage checkSearchInResultsCheckBoxIsNotSelected() {
        WebElement searchBox = waitForVisibilityOfElementLocatedBy(By.id("form-search"));
        WebElement searchInResultsCheckbox = searchBox.findElement(By.cssSelector(".holdreq"));
        postponedAssertTrue(searchInResultsCheckbox.isEnabled(), "Чекбокс 'Искать в найденом' не активен");
        postponedAssertFalse(searchInResultsCheckbox.isSelected(), "Чекбокс 'Искать в найденом' выбран");
        return this;
    }

    @Step("Проверяется что чекбокс 'Искать в найденом' выбран")
    public FssSearchResultPage checkSearchInResultsCheckBoxIsSelected() {
        WebElement searchBox = waitForVisibilityOfElementLocatedBy(By.id("form-search"));
        WebElement searchInResultsCheckbox = searchBox.findElement(By.cssSelector(".holdreq"));
        postponedAssertTrue(searchInResultsCheckbox.isEnabled(), "Чекбокс 'Искать в найденом' не активен");
        postponedAssertTrue(searchInResultsCheckbox.isSelected(), "Чекбокс 'Искать в найденом' не выбран");
        return this;
    }

    @Step("Проверяется что чекбокс 'Искать в найденом' не отображется")
    public FssSearchResultPage checkSearchInResultsCheckBoxIsNotPresent() {
        WebElement searchBox = waitForVisibilityOfElementLocatedBy(By.id("form-search"));
        WebElement searchInResultsCheckbox = findElementByNoThrow(searchBox, By.name("holdreq"));
        postponedAssertFalse(searchInResultsCheckbox != null && searchInResultsCheckbox.isDisplayed(), "Чекбокс 'Искать в найденом' отображется");
        return this;
    }

    @Step("Проверяется что релевантности отображаются")
    public FssSearchResultPage checkRelevanceAreDisplayed() {
        List<WebElement> searchResultList = getResultItemsWithoutScroll();
        for (WebElement result : searchResultList) {
            String resultName = result.findElement(By.cssSelector(".title-link")).getText();
            WebElement relevance = findElementByNoThrow(getParentElement(result), By.cssSelector(".item-relevance"));
            postponedAssertNotNull(relevance, "Релевантности для '" + resultName + "' не найдены");
            if (relevance != null) {
                postponedAssertTrue(relevance.isDisplayed(), "Релевантности для '" + resultName + "' не отображаются");
                postponedAssertFalse(relevance.getText().isEmpty(), "Релевантности для '" + resultName + "' пустые");
            }
        }
        return this;
    }

    @Step("Нажать на ссылку 'Рубрикатор' из заглушки при пустой поисковой выдаче.")
    public FssRubricator clickRubricatorLink() {
        WebElement content = getPage();
        WebElement header = content.findElement(By.cssSelector(".doc-header"));
        WebElement rubricatorLink = findElementByNoThrow(header, By.cssSelector("[data-rubricator='true']"));
        postponedAssertNotNull(rubricatorLink, "Ссылка 'Рубрикатор' в заглушки при пустой поисковой выдаче не найдена.");
        if (rubricatorLink != null) {
            rubricatorLink.click();
        }
        return redirectTo(FssRubricator.class);
    }

    @Step("Открыть случайный документ из поисковой выдачи")
    public FssDocumentPage clickRandomDocument() {
        getHelper(SearchResultHelper.class).clickRandomDocument();
        return redirectTo(FssDocumentPage.class);
    }

    @Step("Нажать на ссылку 'Показать релевантности'")
    public FssSearchResultPage clickShowRelevanceLink() {
        WebElement content = getPage();
        WebElement showRelevance = content.findElement(By.cssSelector(".show-items-relevance"));
        WebElement showRelevanceLink = showRelevance.findElement(By.tagName("a"));
        showRelevanceLink.click();
        return this;
    }

    @Step("Выбрать чекбокс 'Искать в найденом'")
    public FssSearchResultPage clickSearchInResultsCheckBox() {
        WebElement searchBox = waitForVisibilityOfElementLocatedBy(By.id("form-search"));
        WebElement searchInResultsCheckbox = searchBox.findElement(By.cssSelector(".holdreq"));
        searchInResultsCheckbox.click();
        return this;
    }

    private List<WebElement> getResultItems() {
        scroll();
        List<WebElement> resultsItems = new ArrayList<WebElement>();
        List<WebElement> contentList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".b-search"));
        for (WebElement content : contentList) {
            List<WebElement> results = content.findElements(By.tagName("li"));
            for (WebElement result : results) {
                if (result.getAttribute("class") != null && "clear".equals(result.getAttribute("class"))) {
                    resultsItems.add(result);
                }
            }
        }
        return resultsItems;
    }

    private List<WebElement> getResultItemsWithoutScroll() {
        WebElement mainContent = waitForPresenceOfElementLocatedBy(By.cssSelector(".m-wrapper"));
        List<WebElement> resultsItems = new ArrayList<WebElement>();
        List<WebElement> contentList = mainContent.findElements(By.cssSelector(".b-search"));
        for (WebElement content : contentList) {
            List<WebElement> results = content.findElements(By.tagName("li"));
            for (WebElement result : results) {
                if (result.getAttribute("class") != null && "clear".equals(result.getAttribute("class"))) {
                    WebElement videoLink = findElementByNoThrow(result, By.tagName("h3"));
                    if (videoLink != null) {
                        resultsItems.add(videoLink);
                    } else {
                        resultsItems.add(result);
                    }
                }
            }
        }
        return resultsItems;
    }

    private boolean isResultCountContainsNumber(WebElement searchResultCounter) {
        List<WebElement> counterList = searchResultCounter.findElements(By.tagName("strong"));
        int resultCount = 0;
        for (WebElement counter : counterList) {
            try {
                resultCount += Integer.parseInt(counter.getText());
            } catch (NumberFormatException ignored) {
            }
        }
        return resultCount > 0;
    }

    private void checkSearchBox(String textInSearchBox) {
        WebElement searchForm = waitForVisibilityOfElementLocatedBy(By.id("form-search"), "Строка поиска не найдена");
        postponedAssertTrue(findElementByNoThrow(searchForm, By.id("search-input")) != null &&
                searchForm.findElement(By.id("search-input")).isDisplayed(), "Строка поиска не найдена");
        postponedAssertEquals(findElementBy(By.id("search-input")).getAttribute("value").toLowerCase(), textInSearchBox.toLowerCase(), "Неправильный текст в строке поиска");
        postponedAssertTrue(findElementByNoThrow(searchForm, By.id("search_find")) != null &&
                searchForm.findElement(By.id("search_find")).isDisplayed(), "Кнопка 'Найти' не найдена");
    }

    private void checkHighlightedInDocument(String query, WebElement randomDocumentLink) {
        String currentUrl = getCurrentUrl().split("\\?step=")[0];
        String documentUrl = randomDocumentLink.getAttribute("href");
        report("Открыта страница: " + currentUrl);
        report("Открывается ссылка: " + documentUrl);
        randomDocumentLink.click();
        waitForReloadingPage();

        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("main-article"));
        List<WebElement> highlightedElementList = content.findElements(By.cssSelector(".search-word"));
        checkEmptyDocumentHeader();
        postponedAssertFalse(highlightedElementList.isEmpty(), "Не одно слово в документе не подсвеченно");
        String[] urlArr = getCurrentUrl().split("#")[1].split("\\/");
        int moduleId = Integer.parseInt(urlArr[2]);
        int documentId = Integer.parseInt(urlArr[3]);
        List<String> highlightsWordList = getHighlightsWordListForDocument(query, moduleId, documentId);
        for (WebElement highlightedElement : highlightedElementList) {
            if (highlightedElement.isDisplayed()) {
                String highlightedWord = highlightedElement.getText().toLowerCase();
                postponedAssertTrue(highlightsWordList.contains(highlightedWord),
                        "Выделено слово не из поискового запроса. Поисковый запрос: " + query + "' . Выделенное слово: '" + highlightedWord + "'");
            }
        }
        returnToBack();
    }

    private WebElement getRandomDocumentLinkFromSearchResult() {
        return getRandomElementInList(getResultItemsWithoutScroll()).findElement(By.tagName("a"));
    }

    public boolean isSearchResultPresent() {
        return !getResultItemsWithoutScroll().isEmpty();
    }

    public FssSearchResultPage checkSearchResultType(String type) {
        getHelper(SearchResultHelper.class).checkSearchResultType(type);
        return this;
    }

    public FssSearchResultPage checkSearchQuery(String query) {
        getHelper(SearchResultHelper.class).checkSearchQuery(query);
        return this;
    }

    public FssSearchResultPage checkRegion(String region) {
        getHelper(SearchResultHelper.class).checkRegion(region);
        return this;
    }

    public FssSearchResultPage checkRelevanceIsAbsent() {
        getHelper(SearchResultHelper.class).checkRelevanceIsAbsent();
        return this;
    }

    public FssSearchResultPage checkShowRelevanceLinkIsAbsent() {
        getHelper(SearchResultHelper.class).checkShowRelevanceLinkIsAbsent();
        return this;
    }

    public FssSearchResultPage checkLinksOnTypo() {
        getHelper(SearchResultHelper.class).checkLinksOnTypo();
        return this;
    }

    public FssSearchResultPage clickLinkOnTypoBySectionType(MainMenuButtons menuButton) {
        getHelper(SearchResultHelper.class).clickLinkOnTypoBySectionType(menuButton);
        return this;
    }

    public FssSearchResultPage checkTabIsSelected(MainMenuButtons menuButton) {
        getHelper(SearchResultHelper.class).checkTabIsSelected(menuButton);
        return this;
    }

    public FssSearchResultPage checkRubricatorLinkOnTypo() {
        getHelper(SearchResultHelper.class).checkRubricatorLinkOnTypo();
        return this;
    }

    public FssSearchResultPage checkTextInTypo(String message) {
        getHelper(SearchResultHelper.class).checkTextInTypo(message);
        return this;
    }

    public FssSearchResultPage checkTopicFilter() {
        getHelper(SearchResultHelper.class).checkTopicFilter();
        return this;
    }

    public FssSearchResultPage checkLinksTopicFilter() {
        getHelper(SearchResultHelper.class).checkLinksTopicFilter();
        return this;
    }

    public FssSearchResultPage checkSearchResultItemList() {
        getHelper(SearchResultHelper.class).checkSearchResultItemList();
        return this;
    }

    public FssSearchResultPage checkRelevanceFilterSelectedByName(String filterName) {
        getHelper(SearchResultHelper.class).checkRelevanceFilterSelectedByName(filterName);
        return this;
    }

    public FssSearchResultPage checkSearchInResultCheckBoxIsPresent() {
        getHelper(SearchResultHelper.class).checkSearchInResultCheckBoxIsPresent();
        return this;
    }

    public FssSearchResultPage checkWidgetsFolder() {
        getHelper(SearchResultHelper.class).checkWidgetsFolder();
        return this;
    }

    public FssSearchResultPage checkWidgetCodeDictionary() {
        getHelper(SearchResultHelper.class).checkWidgetCodeDictionary();
        return this;
    }

    public FssSearchResultPage clickWidgetShowMore() {
        getHelper(SearchResultHelper.class).clickWidgetShowMore();
        return this;
    }

    public FssSearchResultPage checkWidgetsFull() {
        getHelper(SearchResultHelper.class).checkWidgetsFull();
        return this;
    }

    public FssSearchResultPage checkWidgetCodesFull() {
        getHelper(SearchResultHelper.class).checkWidgetCodesFull();
        return this;
    }

    public FssSearchResultPage checkWidgetsLinks() {
        getHelper(SearchResultHelper.class).checkWidgetlsLinks();
        return this;
    }

    public FssSearchResultPage checkWidgetCodesSourceLink() {
        getHelper(SearchResultHelper.class).checkWidgetCodesSourceLink();
        return this;
    }

    public FssSearchResultPage checkSearchInResultCheckBoxIsNotPresent() {
        getHelper(SearchResultHelper.class).checkSearchInResultCheckBoxIsNotPresent();
        return this;
    }

    public FssSearchResultPage clickSearchInResultCheckBox() {
        getHelper(SearchResultHelper.class).clickSearchInResultCheckBox();
        return this;
    }

    public FssSearchResultPage checkPresentSearchResultText(String query1, String query2) {
        getHelper(SearchResultHelper.class).checkPresentSearchResultText(query1, query2);
        return this;
    }

    public FssSearchResultPage checkPresentSearchResultText(String query1, String query2, String query3) {
        getHelper(SearchResultHelper.class).checkPresentSearchResultText(query1, query2, query3);
        return this;
    }

    public FssSearchResultPage checkHighlightingRequest() {
        getHelper(SearchResultHelper.class).checkHighlightingRequest();
        return this;
    }

    public FssSearchResultPage clickСourtTag() {
        getHelper(SearchResultHelper.class).clickСourtTag();
        return this;
    }

    public FssSearchResultPage clickDateFilter() {
        getHelper(SearchResultHelper.class).clickDateFilter();
        return this;
    }

    public FssSearchResultPage checkConditionFilter() {
        getHelper(SearchResultHelper.class).checkConditionFilter();
        return this;
    }

    public FssSearchResultPage checkExtendedSearch(String type, String city, String query) {
        getHelper(SearchResultHelper.class).checkExtendedSearch(type, city, query);
        return this;
    }

    public FssSearchResultPage clickNotActiveStatus() {
        getHelper(SearchResultHelper.class).clickNotActiveStatus();
        return this;
    }

    public FssSearchResultPage checkPresentFormsDocumentForHour() {
        getHelper(SearchResultHelper.class).checkPresentFormsDocumentForHour();
        return this;
    }

    public FssSearchResultPage checkClickLinkNavigateToLawPage() {
        getHelper(SearchResultHelper.class).clickLinkNavigateToLawPageLink();
        return this;
    }

    public FssSearchResultPage checkInputCorrectlyFormsDocumentForHour() {
        getHelper(SearchResultHelper.class).checkInputCorrectlyFormsDocumentForHour();
        return this;
    }

    public FssSearchResultPage checkNotPresentFormsDocumentHouse() {
        getHelper(SearchResultHelper.class).checkNotPresentFormsDocumentHouse();
        return this;
    }

    public FssSearchResultPage checkDisplaySearchResultsForDetails(String query) {
        getHelper(SearchResultHelper.class).checkDisplaySearchResultsForDetails(query);
        return this;
    }

    public FssSearchResultPage checkDisplayingSelectedTypeFilters(String type) {
        getHelper(SearchResultHelper.class).checkDisplayingSelectedTypeFilters(type);
        return this;
    }

    public FssSearchResultPage checkDisplayingText(boolean isAuthorized) {
        getHelper(SearchResultHelper.class).checkDisplayingText(isAuthorized);
        return this;
    }

    public FssSearchResultPage checkDisplayLawSectionFilter() {
        getHelper(SearchResultHelper.class).checkSectionFilter(MainMenuButtons.LAW_BASE);
        return this;
    }

    public FssSearchResultPage checkLinksMagazinFilter() {
        getHelper(SearchResultHelper.class).checkLinksMagazinesFilter();
        return this;
    }

    public FssSearchResultPage checkLinksArchiveFilter() {
        getHelper(SearchResultHelper.class).checkLinksArchiveFilter();
        return this;
    }

    public FssSearchResultPage checkMagazinesFilter() {
        getHelper(SearchResultHelper.class).checkMagazinesFilter();
        return this;
    }

    public FssSearchResultPage checkVideosFilter() {
        getHelper(SearchResultHelper.class).checkVideosFilter();
        return this;
    }

    public FssSearchResultPage checkLinksVideoFilter() {
        getHelper(SearchResultHelper.class).checkLinksVideoFilter();
        return this;
    }

    public FssSearchResultPage checkSearchResultOnServicesPageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.FSS_SERVICES);
        getHelper(SearchResultHelper.class).checkSearchResultOnServicesPageIsOpened();
        return this;
    }

    public FssSearchResultPage checkSearchResultOnServicesPageIsNotPresent() {
        checkCurrentItemIsSelected(MainMenuButtons.FSS_SERVICES);
        getHelper(SearchResultHelper.class).checkSearchResultOnServicesPageIsNotPresent();
        return this;
    }

    public FssSearchResultPage checkWidgetLawPresent() {
        getHelper(SearchResultHelper.class).checkWidgetLawPresent();
        return this;
    }

    public FssSearchResultPage checkClickInMainLinkInLawWidget() {
        getHelper(SearchResultHelper.class).checkClickInMainLinkInLawWidget();
        return this;
    }

    public FssSearchResultPage checkLinksWidgetLawPage() {
        getHelper(SearchResultHelper.class).checkLinksWidgetLawPage();
        return this;
    }

    public FssSearchResultPage checkWidgetFormsPresent() {
        WebElement widget = findElementByNoThrow(By.cssSelector(".widget-forms"));
        getHelper(SearchResultHelper.class).checkWidget(widget, "В положениях и регламентах");
        return this;
    }

    public FssSearchResultPage checkClickInMainLinkInFormsWidget() {
        getHelper(SearchResultHelper.class).checkClickInMainLinkInWidget(".widget-forms", MainMenuButtons.FSS_FORMS);
        return this;
    }

    public FssSearchResultPage checkLinksWidgetForms() {
        getHelper(SearchResultHelper.class).checkLinksWidgetForms();
        return this;
    }

    public FssSearchResultPage checkWidgetDictionaryPresent() {
        WebElement widget = findElementByNoThrow(By.cssSelector(".widget-handbook"));
        getHelper(SearchResultHelper.class).checkWidget(widget, "В справочнике");
        return this;
    }

    public FssSearchResultPage checkClickInMainLinkInDictionaryWidget() {
        getHelper(SearchResultHelper.class).checkClickInMainLinkInWidget(".widget-handbook", MainMenuButtons.FSS_DICTIONARY);
        return this;
    }

    public FssSearchResultPage checkLinksWidgetDictionary() {
        getHelper(SearchResultHelper.class).checkLinksWidgetDictionary();
        return this;
    }

    public FssSearchResultPage checkWidgetMagazinesPresent() {
        getHelper(SearchResultHelper.class).checkMagazinesWidget("В библиотеке");
        return this;
    }

    public FssSearchResultPage checkClickInMainLinkInMagazinesWidget() {
        getHelper(SearchResultHelper.class).checkClickInMainLinkInWidget(".widget-press", MainMenuButtons.LIBRARY);
        return this;
    }

    public FssSearchResultPage checkLinksWidgetMagazines() {
        getHelper(SearchResultHelper.class).checkLinksInWidget(".widget-press");
        return this;
    }

    public FssSearchResultPage checkWidgetVideoPresent() {
        getHelper(SearchResultHelper.class).checkVideoWidget("Видео");
        return this;
    }

    public FssSearchResultPage checkClickInMainLinkInWidgetVideo() {
        getHelper(SearchResultHelper.class).checkClickInMainLinkInWidget(".widget-videos", MainMenuButtons.FSS_VIDEO);
        return this;
    }

    public FssSearchResultPage checkLinksWidgetVideo() {
        getHelper(SearchResultHelper.class).checkLinksInWidget(".widget-videos");
        return this;
    }

    public FssSearchResultPage checkSectionFilter() {
        getHelper(SearchResultHelper.class).checkSectionFilter(MainMenuButtons.FSS_SOLUTIONS);
        getHelper(SearchResultHelper.class).checkImgSectionFilter();
        return this;
    }

    public FssSearchResultPage checkLinksSectionFilter() {
        getHelper(SearchResultHelper.class).checkLinksSectionFilter();
        return this;
    }

    public FssSearchResultPage checkStatusFilter() {
        getHelper(SearchResultHelper.class).checkStatusFilter();
        return this;
    }

    public FssSearchResultPage checkLinksStatusFilter() {
        getHelper(SearchResultHelper.class).checkExpiredLinksStatusFilter();
        getHelper(SearchResultHelper.class).checkActualLinksStatusFilter();
        getHelper(SearchResultHelper.class).checkActualInFutureLinksStatusFilter();
        getHelper(SearchResultHelper.class).checkUnknownLinksStatusFilter();
        return this;
    }

    public FssSearchResultPage checkServicesFilter() {
        getHelper(SearchResultHelper.class).checkServicesFilter();
        return this;
    }

    public FssSearchResultPage checkLinksServicesFilter() {
        getHelper(SearchResultHelper.class).checkLinksServicesFilter();
        return this;
    }

    public FssSearchResultPage checkDateFilter() {
        getHelper(SearchResultHelper.class).checkDateFilter();
        return this;
    }

    public FssSearchResultPage checkSearchResultsDateFilter() {
        getHelper(SearchResultHelper.class).checkSearchResultsDateFilter();
        return this;
    }

    public FssSearchResultPage clickDateSortedFilter() {
        getHelper(SearchResultHelper.class).clickDateSortedFilter();
        return this;
    }

    public FssSearchResultPage clickRelevanceSortedFilter() {
        getHelper(SearchResultHelper.class).clickRelevanceSortedFilter();
        return this;
    }

    public FssSearchResultPage checkRelevanceFilter() {
        getHelper(SearchResultHelper.class).checkRelevanceFilter();
        return this;
    }

    public FssSearchResultPage checkRegionFilter(boolean isDefault) {
        getHelper(SearchResultHelper.class).checkRegionFilter(isDefault);
        return this;
    }

    public FssSearchResultPage checkRegionFilter(boolean isDefault, String region) {
        getHelper(SearchResultHelper.class).checkRegionFilter(isDefault, region);
        return this;
    }

    public FssSearchResultPage checkRegionInSearchHeader(String partRegionName, int regionId) {
        getHelper(SearchResultHelper.class).checkRegionInSearchHeader(partRegionName, regionId);
        return this;
    }

    public FssSearchResultPage checkRegionFilterInSearchExtendedStringIsNotPresent() {
        getHelper(SearchResultHelper.class).checkRegionFilterInSearchExtendedStringIsNotPresent();
        return this;
    }

    public FssSearchResultPage checkRegionFilterInSearchExtendedStringIsPresent() {
        getHelper(SearchResultHelper.class).checkRegionFilterInSearchExtendedStringIsPresent();
        return this;
    }

    public FssSearchResultPage chooseSecondRegionFilter() {
        getHelper(SearchResultHelper.class).clickSecondRegionFilter();
        return this;
    }

    public FssSearchResultPage checkMoscowRegionFilter() {
        getHelper(SearchResultHelper.class).checkMoscowRegionFilter();
        return this;
    }

    public FssSearchResultPage checkAllRegionFilter() {
        getHelper(SearchResultHelper.class).checkAllRegionFilter();
        return this;
    }

    public FssSearchResultPage clickInLawPracticeLinkFilter() {
        getHelper(SearchResultHelper.class).clickInLawPracticeLinkFilter();
        return this;
    }

    public FssSearchResultPage clickInLawPracticeLinkFilterAndDoNotWaitingSearchResult() {
        getHelper(SearchResultHelper.class).clickInLawPracticeLinkFilterAndDoNotWaitSearchResult();
        return this;
    }

    public FssSearchResultPage clickInLawLinkFilter() {
        getHelper(SearchResultHelper.class).clickInLawLinkFilter();
        return this;
    }

    public FssSearchResultPage checkInLawAndInPracticeFilterIsPresent() {
        getHelper(SearchResultHelper.class).checkInLawAndInPracticeFilterIsPresent();
        return this;
    }

    public FssSearchResultPage checkSearchResultOnLawPracticePageIsNotPresent() {
        getHelper(SearchResultHelper.class).checkSearchResultOnLawPracticePageIsNotPresent();
        return this;
    }

    public FssSearchResultPage checkSearchInResultCheckboxIsNoSelected() {
        getHelper(SearchResultHelper.class).checkSearchInResultCheckboxIsNoSelected();
        return this;
    }

    public FssSearchResultPage clickTypeDocumentFilter(String filterName) {
        getHelper(SearchResultHelper.class).clickTypeDocumentFilter(filterName);
        return this;
    }

    public FssSearchResultPage checkSortedFilter(String filterName) {
        getHelper(SearchResultHelper.class).checkSortedFilter(filterName);
        return this;
    }

    public FssSearchResultPage checkTypeDocumentFilter(String filterName) {
        getHelper(SearchResultHelper.class).checkTypeDocumentFilter(filterName);
        return this;
    }

    public FssSearchResultPage checkTypeDocumentFilters() {
        getHelper(SearchResultHelper.class).checkTypeDocumentFilters();
        return this;
    }

    public FssSearchResultPage checkDepartmentFilter() {
        getHelper(SearchResultHelper.class).checkDepartmentFilter();
        return this;
    }

    public FssSearchResultPage checkLinksTypeDocumentFilter() {
        getHelper(SearchResultHelper.class).checkLinksTypeDocumentFilter();
        return this;
    }

    public FssSearchResultPage checkStatusFilter(String filterName) {
        getHelper(SearchResultHelper.class).checkStatusFilter(filterName);
        return this;
    }

    public FssSearchResultPage checkSearchTitle(String expectedTitle) {
        getHelper(SearchResultHelper.class).checkSearchTitle(expectedTitle);
        return this;
    }

    public FssSearchResultPage checkExtendedSearchString(String expectedString) {
        getHelper(SearchResultHelper.class).checkExtendedSearchString(expectedString);
        return this;
    }

    public FssSearchResultPage checkSectionFilter(MainMenuButtons mainMenuButton) {
        getHelper(SearchResultHelper.class).checkSectionFilter(mainMenuButton);
        return this;
    }

    public FssSearchResultPage checkLawPracticeFilter() {
        getHelper(SearchResultHelper.class).checkLawPracticeFilter();
        return this;
    }

    public FssSearchResultPage inputNameInDocumentForHourForm(String name) {
        getHelper(SearchResultHelper.class).inputNameInDocumentForHourForm(name);
        return this;
    }

    public FssSearchResultPage inputEmailInDocumentForHourForm(String email) {
        getHelper(SearchResultHelper.class).inputEmailInDocumentForHourForm(email);
        return this;
    }

    public FssSearchResultPage inputCommentInDocumentForHourForm(String comment) {
        getHelper(SearchResultHelper.class).inputCommentInDocumentForHourForm(comment);
        return this;
    }

    public FssSearchResultPage checkNameErrorInDocumentForHourForm(String expectedText) {
        getHelper(SearchResultHelper.class).checkNameErrorInDocumentForHourForm(expectedText);
        return this;
    }

    public FssSearchResultPage checkEmailErrorInDocumentForHourForm(String error) {
        getHelper(SearchResultHelper.class).checkEmailErrorInDocumentForHourForm(error);
        return this;
    }

    public FssSearchResultPage clickSendButtonInDocumentForHourForm() {
        getHelper(SearchResultHelper.class).clickSendButtonInDocumentForHourForm();
        return this;
    }

    public FssLawBasePage clickLinkNavigateToLawPageLink() {
        getHelper(SearchResultHelper.class).clickLinkNavigateToLawPageLink();
        return redirectTo(FssLawBasePage.class);
    }

    public FssSearchResultPage checkTypoBlockIsPresent() {
        getHelper(SearchResultHelper.class).checkTypoBlockIsPresent();
        return this;
    }

    public FssSearchResultPage checkLawSearchWidgetIsNotPresent() {
        getHelper(SearchResultHelper.class).checkLawSearchWidgetIsNotPresent();
        return this;
    }

    public FssSearchResultPage checkLawSearchWidgetIsPresent() {
        getHelper(SearchResultHelper.class).checkLawSearchWidgetIsPresent();
        return this;
    }

    public FssSearchResultPage checkLawSearchWidgetIsNotEmpty() {
        getHelper(SearchResultHelper.class).checkLawSearchWidgetIsNotEmpty();
        return this;
    }

    public FssSearchResultPage checkFormsSearchWidgetIsNotPresent() {
        getHelper(SearchResultHelper.class).checkFormsSearchWidgetIsNotPresent();
        return this;
    }

    public FssSearchResultPage checkFormsSearchWidgetIsPresent() {
        getHelper(SearchResultHelper.class).checkFormsSearchWidgetIsPresent();
        return this;
    }

    public FssSearchResultPage checkFormsSearchWidgetIsNotEmpty() {
        getHelper(SearchResultHelper.class).checkFormsSearchWidgetIsNotEmpty();
        return this;
    }

    public FssSearchResultPage checkMagazinesSearchWidgetIsNotPresent() {
        getHelper(SearchResultHelper.class).checkMagazinesSearchWidgetIsNotPresent();
        return this;
    }

    public FssSearchResultPage checkMagazinesSearchWidgetIsPresent() {
        getHelper(SearchResultHelper.class).checkMagazinesSearchWidgetIsPresent();
        return this;
    }

    public FssSearchResultPage checkMagazinesSearchWidgetIsNotEmpty() {
        getHelper(SearchResultHelper.class).checkMagazinesSearchWidgetIsNotEmpty();
        return this;
    }

    public FssSearchResultPage checkVideoSearchWidgetIsNotPresent() {
        getHelper(SearchResultHelper.class).checkVideoSearchWidgetIsNotPresent();
        return this;
    }

    public FssSearchResultPage checkVideoSearchWidgetIsPresent() {
        getHelper(SearchResultHelper.class).checkVideoSearchWidgetIsPresent();
        return this;
    }

    public FssSearchResultPage checkVideoSearchWidgetIsNotEmpty() {
        getHelper(SearchResultHelper.class).checkVideoSearchWidgetIsNotEmpty();
        return this;
    }

    public FssSearchResultPage checkDictionarySearchWidgetIsNotPresent() {
        getHelper(SearchResultHelper.class).checkDictionarySearchWidgetIsNotPresent();
        return this;
    }

    public FssSearchResultPage checkDictionarySearchWidgetIsPresent() {
        getHelper(SearchResultHelper.class).checkDictionarySearchWidgetIsPresent();
        return this;
    }

    public FssSearchResultPage checkSearchErrorIsNotPresent(){
        getHelper(SearchResultHelper.class).checkSearchErrorIsNotPresent();
        return this;
    }

    public FssSearchResultPage checkDictionarySearchWidgetIsNotEmpty() {
        getHelper(SearchResultHelper.class).checkDictionarySearchWidgetIsNotEmpty();
        return this;
    }

    public FssSearchResultPage checkKodySearchWidgetIsNotPresent() {
        getHelper(SearchResultHelper.class).checkKodySearchWidgetIsNotPresent();
        return this;
    }

    public FssSearchResultPage checkKodySearchWidgetIsPresent() {
        getHelper(SearchResultHelper.class).checkKodySearchWidgetIsPresent();
        return this;
    }

    public FssSearchResultPage checkKodySearchWidgetIsNotEmpty() {
        getHelper(SearchResultHelper.class).checkKodySearchWidgetIsNotEmpty();
        return this;
    }

    public FssSearchResultPage clickActualStatusInFilter() {
        getHelper(SearchResultHelper.class).clickActualStatusInFilter();
        return this;
    }

    public FssSearchResultPage clickFormsFilter() {
        getHelper(SearchResultHelper.class).clickFormsFilter();
        return this;
    }

    public FssSearchResultPage mouseHoverSecondItemFormWidget() {
        getHelper(SearchResultHelper.class).mouseHoverSecondItemFormWidget();
        return this;
    }

    public FssSearchResultPage checkSecondItemFormWidgetIsGreen() {
        getHelper(SearchResultHelper.class).checkSecondItemFormWidgetIsGreen();
        return this;
    }

    public FssSearchResultPage checkSearchResultOnLawBasePageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.LAW_BASE);
        getHelper(SearchResultHelper.class).checkSearchResultOnLawBasePageIsOpened();
        return this;
    }

    public FssSearchResultPage checkSearchResultOnLawPracticePageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.LAW_BASE);
        getHelper(SearchResultHelper.class).checkSearchResultOnLawPracticePageIsOpened();
        return this;
    }

    public FssSearchResultPage checkResultBlockHasDocumentsLinksAndSnippets() {
        getHelper(SearchResultHelper.class).checkSearchResultDocumentsLinksAndSnippets();
        return this;
    }

    public FssSearchResultPage checkSectionFilterIsPresent() {
        getHelper(SearchResultHelper.class).checkSectionFilterIsPresent();
        return this;
    }

    public FssSearchResultPage checkSortingFilterIsPresent() {
        getHelper(SearchResultHelper.class).checkSortingFilter();
        return this;
    }

    public FssSearchResultPage checkTypeDocumentFilterIsPresent() {
        getHelper(SearchResultHelper.class).checkTypeDocumentFilterIsPresent();
        return this;
    }

    public FssSearchResultPage checkRegionFilterIsPresent() {
        getHelper(SearchResultHelper.class).checkRegionFilterIsPresent();
        return this;
    }

    public FssSearchResultPage checkStatusFilterIsPresent() {
        getHelper(SearchResultHelper.class).checkStatusFilterIsPresent();
        return this;
    }

    public FssSearchResultPage checkRubricatorButtonIsPresent() {
        getHelper(SearchResultHelper.class).checkRubricatorButtonsIsPresent();
        return this;
    }

    public FssSearchResultPage checkRubricatorFavoritesButtonIsPresent() {
        getHelper(SearchResultHelper.class).checkRubricatorFavoritesButtonIsPresent();
        return this;
    }

    public FssSearchResultPage checkSearchResultHasStrongText() {
        getHelper(SearchResultHelper.class).checkSearchResultHasStrongText();
        return this;
    }

    public FssSearchResultPage checkSearchResultHasNOTStrongText() {
        getHelper(SearchResultHelper.class).checkSearchResultHasNOTStrongText();
        return this;
    }

    public FssSearchResultPage checkActiveSectionFilter(MainMenuButtons filterName) {
        getHelper(SearchResultHelper.class).checkActiveSectionFilter(filterName);
        return this;
    }

    public FssSearchResultPage checkRelevanceLinkWorks() {
        getHelper(SearchResultHelper.class).checkRelevanceLinkWorks();
        return this;
    }

    public FssSearchResultPage checkDocumentsInLawPracticePageAreSortedDescending() {
        getHelper(SearchResultHelper.class).checkDocumentsInLawPracticePageAreSortedDescending();
        return this;
    }

    public FssSearchResultPage checkExtendedSearchRemoveAllFilters() {
        getHelper(SearchResultHelper.class).checkExtendedSearchRemoveAllFilters();
        return redirectTo(FssSearchResultPage.class);
    }

    public FssSearchResultPage checkMainLawBasePageIsOpened() {
        getHelper(SearchResultHelper.class).checkMainLawBasePageIsOpened();
        return this;
    }

    public FssSearchResultPage checkStatusFilterIsNotPresent() {
        getHelper(SearchResultHelper.class).checkStatusFilterIsNotPresent();
        return this;
    }

    public FssSearchResultPage checkJudicialActsFilter() {
        getHelper(SearchResultHelper.class).checkJudicialActsFilter();
        return this;
    }

    public FssSearchResultPage checkLinksJudicialActsFilter() {
        getHelper(SearchResultHelper.class).checkLinksJudicialActsFilter();
        return this;
    }

    public FssSearchResultPage checkExtendedSearchStringContains(String expectedString) {
        getHelper(SearchResultHelper.class).checkExtendedSearchStringContains(expectedString);
        return this;
    }

    public FssSearchResultPage checkSearchResultsHeadersContainDocumentNumber(String expectedString) {
        getHelper(SearchResultHelper.class).checkSearchResultsHeadersContainDocumentNumber(expectedString);
        return this;
    }

    @Step("Проверить работу подсказок, нажать на подсказку с примечанием")
    public FssSearchResultPage checkSearchAdviceListByDocumentsCountOnExtendedSearchForm() {
        checkExtendedSearchStringContains(getHelper(ExtendedSearchForm.class, this)
                .clickOnSearchAdviceListHintWithCountOfDocumentsFound());
        return this;
    }

    @Step("Проверить подсказку с примечанием название документа, документ должен быть из модулей:81,97,99")
    public FssSearchResultPage checkSearchAdviceListByDocumentNameOnExtendedSearchFormLawBase() {
        getHelper(ExtendedSearchForm.class, this).clickOnSearchAdviceListRemarkWithDocumentName();
        String currentURL = getCurrentUrl();
        currentURL.replace("document//", "document/");
        String[] urlArr = currentURL.split("#")[1].split("/");
        int moduleId = Integer.parseInt(urlArr[2]);
        if (moduleId != 81 && moduleId != 97 && moduleId != 99) {
            setPostponedTestFail("Текущий URL не содержит модуля документа: 81, 97 или 99");
        }
        return this;
    }

    @Step("Проверить подсказку с примечанием название документа, документ должен быть из модулей:96,98")
    public FssSearchResultPage checkSearchAdviceListByDocumentNameOnExtendedSearchFormLawPractice() {
        getHelper(ExtendedSearchForm.class, this).clickOnSearchAdviceListRemarkWithDocumentName();
        String currentURL = getCurrentUrl();
        currentURL.replace("document//", "document/");
        String[] urlArr = currentURL.split("#")[1].split("/");
        int moduleId = Integer.parseInt(urlArr[2]);
        if (moduleId != 96 && moduleId != 98) {
            setPostponedTestFail("Текущий URL не содержит модуля документа: 96,98");
        }
        return this;
    }

    @Step("Проверить навигацию по подсказкам")
    public FssSearchResultPage checkSearchAdviceListNavigation() {
        String currentUrl = getCurrentUrl();
        getHelper(ExtendedSearchForm.class, this).checkNavigationByHintsWithKeysDownAndUp();
        postponedAssertNotEquals(currentUrl, getCurrentUrl(), "После нажатия на кнопку Enter в навигации по номерам " +
                "документов ничего не произошло. URL не поменялся");
        return this;
    }

    public FssSearchResultPage checkSearchResultsForExpersHasDifferentAbbr() {
        getHelper(SearchResultHelper.class).checkSearchResultsForExpersHasDifferentAbbr();
        return this;
    }

    public FssSearchResultPage checkSearchResultsForExpersHasOneAbbr() {
        getHelper(SearchResultHelper.class).checkSearchResultsForExpersHasOneAbbr();
        return this;
    }

    public FssSearchResultPage checkSearchResultsDateFilterFrom(String date) {
        getHelper(SearchResultHelper.class).checkSearchResultsDateFilterFrom(date);
        return this;
    }

    public FssSearchResultPage checkSearchResultsDateFilterTo(String date) {
        getHelper(SearchResultHelper.class).checkSearchResultsDateFilterTo(date);
        return this;
    }

    public FssSearchResultPage checkSearchResultsDateFilterBetween(String dateFrom, String dateTo) {
        getHelper(SearchResultHelper.class).checkSearchResultsDateFilterBetween(dateFrom, dateTo);
        return this;
    }

    public FssSearchResultPage clickOnButtonSearchOnExtendedForm() {
        getHelper(SearchResultHelper.class).clickOnButtonSearchOnExtendedForm();
        return redirectTo(FssSearchResultPage.class);
    }

    public FssSearchResultPage checkSearchResultsContainLinksOnDocuments() {
        getHelper(SearchResultHelper.class).checkSearchResultsContainLinksOnDocuments();
        return this;
    }

    public FssSearchResultPage checkSearchResultsDocumentsContainBriefTextUnderTheLinks() {
        getHelper(SearchResultHelper.class).checkSearchResultsDocumentsContainBriefTextUnderTheLinks();
        return this;
    }

    public FssSearchResultPage checkSearchResultsExtendedStringIsPresent() {
        getHelper(SearchResultHelper.class).checkSearchResultsExtendedStringIsPresent();
        return this;
    }

    @Step("Проверяется, что Отображаются поисковые темы по фильтрам")
    public FssSearchResultPage checkSearchResultTypeFilterByThemesIsPresent() {
        String[] typeFilterNames = {"Все темы", "Денежные потоки", "Финансовый анализ и оценка", "Бюджетирование",
                "Управленческий учет", "Налоговое планирование", "Стратегия компании", "Организация и менеджмент",
                "Рабочие инструменты", "Контроль и управление рисками", "Отраслевые решения", "Разработка регламентов"};
        WebElement typeFilter = findElementByNoThrow(By.cssSelector(".menu [data-filtr-name='tags']"));
        postponedAssertTrue(typeFilter != null && typeFilter.isDisplayed(), "Поисковые фильтры по темам не отображены");
        if (typeFilter != null) {
            List<WebElement> filters = typeFilter.findElements(By.cssSelector("li a"));
            postponedAssertEquals(filters.size(), typeFilterNames.length, "Количество тем по фильтрам не " +
                    "соответствует с ожидаемым количеством");
            int i = 0;
            for (WebElement filter: filters) {
                postponedAssertEqualsText(filter, typeFilterNames[i]);
                i++;
            }
        }
        return this;
    }

    public FssSearchResultPage checkSearchResultSolutionsItemIsActivated() {
        getHelper(SearchResultHelper.class).checkSearchResultSolutionsItemIsActivated();
        return this;
    }

}
