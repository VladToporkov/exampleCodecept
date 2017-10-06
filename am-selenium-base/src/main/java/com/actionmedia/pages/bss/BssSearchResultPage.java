package com.actionmedia.pages.bss;

import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.ExtendedSearchForm;
import com.actionmedia.pages.helpers.SearchResultHelper;
import com.actionmedia.pages.interfaces.ISearchResultPage;
import com.actionmedia.util.TestUtils;
import com.actionmedia.webservice.buhonline.Search;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 11.10.13
 * Time: 9:39
 */
@Component
public class BssSearchResultPage extends BssBasePage<BssSearchResultPage> implements ISearchResultPage {

    public BssSearchResultPage checkSearchResultOnRecomendPageIsOpened() {
        getHelper(SearchResultHelper.class).checkSearchResultOnRecomendPageIsOpened();
        return this;
    }

    public BssSearchResultPage checkSearchResultOnLawBasePageIsOpened(boolean isDefault) {
        checkCurrentItemIsSelected(MainMenuButtons.LAW_BASE);
        getHelper(SearchResultHelper.class).checkSearchResultOnLawBasePageIsOpened(isDefault);
        return this;
    }

    public BssSearchResultPage checkSearchResultOnLawBasePageIsOpened(boolean isDefault, String departmentFilter) {
        checkCurrentItemIsSelected(MainMenuButtons.LAW_BASE);
        getHelper(SearchResultHelper.class).checkSearchResultOnLawBasePageIsOpened(isDefault, departmentFilter);
        return this;
    }

    public BssSearchResultPage checkSearchResultOnFormsPageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.FORMS);
        getHelper(SearchResultHelper.class).checkSearchResultOnFormsPageIsOpened();
        return this;
    }

    public BssSearchResultPage checkSearchResultOnDictionaryPageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.DICTIONARIES);
        getHelper(SearchResultHelper.class).checkSearchResultOnDictionaryPageIsOpened("В справочниках найден", MainMenuButtons.DICTIONARIES);
        return this;
    }

    public BssSearchResultPage checkSearchResultOnMagazinesPageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.MAGAZINES);
        getHelper(SearchResultHelper.class).checkSearchResultOnMagazinesPageIsOpened("В журналах найден", true, MainMenuButtons.MAGAZINES);
        return this;
    }

    public BssSearchResultPage checkSearchResultOnVideosPageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.VIDEO);
        getHelper(SearchResultHelper.class).checkSearchResultOnVideosPageIsOpened();
        return this;
    }

    public BssSearchResultPage checkSearchResultOnServicesPageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.SERVICES);
        getHelper(SearchResultHelper.class).checkSearchResultOnServicesPageIsOpened();
        return this;
    }

    public BssSearchResultPage checkSearchResultOnRecomendPageIsNotPresent() {
        checkCurrentItemIsSelected(MainMenuButtons.RECOMEND);
        getHelper(SearchResultHelper.class).checkSearchResultOnRecomendPageIsNotPresent();
        return this;
    }

    public BssSearchResultPage checkSearchResultOnLawBasePageIsNotPresent() {
        checkCurrentItemIsSelected(MainMenuButtons.LAW_BASE);
        getHelper(SearchResultHelper.class).checkSearchResultOnLawBasePageIsNotPresent();
        return this;
    }

    public BssSearchResultPage checkSectionIsNotPresentIn(String sectionName) {
        getHelper(SearchResultHelper.class).checkSectionIsNotPresentIn(sectionName);
        return this;
    }

    public BssSearchResultPage checkSearchResultOnFormsPageIsNotPresent() {
        checkCurrentItemIsSelected(MainMenuButtons.FORMS);
        getHelper(SearchResultHelper.class).checkSearchResultOnFormsPageIsNotPresent();
        return this;
    }

    public BssSearchResultPage checkSearchResultOnDictionaryPageIsNotPresent() {
        checkCurrentItemIsSelected(MainMenuButtons.DICTIONARIES);
        getHelper(SearchResultHelper.class).checkSearchResultOnDictionaryBssPageIsNotPresent();
        return this;
    }

    public BssSearchResultPage checkSearchResultOnMagazinesPageIsNotPresent() {
        checkCurrentItemIsSelected(MainMenuButtons.MAGAZINES);
        getHelper(SearchResultHelper.class).checkSearchResultOnMagazinesPageIsNotPresent(MainMenuButtons.MAGAZINES);
        return this;
    }

    public BssSearchResultPage checkSearchResultOnVideosPageIsNotPresent() {
        checkCurrentItemIsSelected(MainMenuButtons.VIDEO);
        getHelper(SearchResultHelper.class).checkSearchResultOnVideosPageIsNotPresent();
        return this;
    }

    public BssSearchResultPage checkSearchResultOnServicesPageIsNotPresent() {
        checkCurrentItemIsSelected(MainMenuButtons.SERVICES);
        getHelper(SearchResultHelper.class).checkSearchResultOnServicesPageIsNotPresent();
        return this;
    }

    public BssSearchResultPage checkLinksFromSearchResultPage() {
        getHelper(SearchResultHelper.class).checkLinksFromSearchResultPage();
        return this;
    }

    public BssSearchResultPage checkSearchQueryIsHighlighted(String query) {
        getHelper(SearchResultHelper.class).checkSearchQueryIsHighlighted(query);
        return this;
    }

    public BssSearchResultPage checkSearchQueryIsHighlightedInDocument(String query) {
        getHelper(SearchResultHelper.class).checkSearchQueryIsHighlightedInDocument(query);
        return this;
    }

    public BssSearchResultPage checkScrollingSearchResult() {
        getHelper(SearchResultHelper.class).checkScrollingSearchResult();
        return this;
    }

    public BssSearchResultPage checkSearchResultAreNotRepeated() {
        getHelper(SearchResultHelper.class).checkSearchResultAreNotRepeated();
        return this;
    }

    public BssSearchResultPage checkLinksOnTypo() {
        getHelper(SearchResultHelper.class).checkLinksOnTypo();
        return this;
    }

    public BssSearchResultPage clickLinkOnTypoBySectionType(MainMenuButtons menuButton) {
        getHelper(SearchResultHelper.class).clickLinkOnTypoBySectionType(menuButton);
        return this;
    }

    public BssSearchResultPage checkTabIsSelected(MainMenuButtons menuButton) {
        getHelper(SearchResultHelper.class).checkTabIsSelected(menuButton);
        return this;
    }

    public BssSearchResultPage checkRubricatorLinkOnTypo() {
        getHelper(SearchResultHelper.class).checkRubricatorLinkOnTypo();
        return this;
    }

    public BssSearchResultPage checkTextInTypo(String message) {
        getHelper(SearchResultHelper.class).checkTextInTypo(message);
        return this;
    }

    public BssSearchResultPage checkStatusFilterSelectedByName(String filterName) {
        getHelper(SearchResultHelper.class).checkStatusFilterSelectedByName(filterName);

        return this;
    }

    public BssSearchResultPage checkRelevanceFilterSelectedByName(String filterName) {
        getHelper(SearchResultHelper.class).checkRelevanceFilterSelectedByName(filterName);
        return this;
    }

    public BssSearchResultPage checkDepartmentFilterSelectedByName(String filterName) {
        getHelper(SearchResultHelper.class).checkDepartmentFilterSelectedByName(filterName);
        return this;
    }

    public BssSearchResultPage checkDocumentWithTextIsPresent(String documentText) {
        getHelper(SearchResultHelper.class).checkDocumentWithTextIsPresent(documentText);
        return this;
    }

    public BssSearchResultPage checkExtendedSearchResultIsPresent() {
        getHelper(SearchResultHelper.class).checkExtendedSearchResultIsPresent();
        return this;
    }

    public BssSearchResultPage checkExtendedHeaderText() {
        getHelper(SearchResultHelper.class).checkExtendedHeaderText();
        return this;
    }

    public BssSearchResultPage checkResultAreSortedDescending() {
        getHelper(SearchResultHelper.class).checkResultAreSortedDescending();
        return this;
    }

    public BssSearchResultPage checkShowRelevanceLinkIsPresent() {
        getHelper(SearchResultHelper.class).checkShowRelevanceLinkIsPresent();
        return this;
    }

    public BssSearchResultPage checkShowRelevanceLinkIsAbsent() {
        getHelper(SearchResultHelper.class).checkShowRelevanceLinkIsAbsent();
        return this;
    }

    public BssSearchResultPage checkSearchWithStandardQueryCheckBoxIsPresent() {
        getHelper(SearchResultHelper.class).checkSearchWithStandardQueryCheckBoxIsPresent();
        return this;
    }

    public BssSearchResultPage checkSearchWithStandardQueryCheckBoxIsNotPresent() {
        getHelper(SearchResultHelper.class).checkSearchWithStandardQueryCheckBoxIsNotPresent();
        return this;
    }

    public BssSearchResultPage checkSearchWithStandardQueryCheckBoxIsSelected() {
        getHelper(SearchResultHelper.class).checkSearchWithStandardQueryCheckBoxIsSelected();
        return this;
    }

    public BssSearchResultPage checkSearchWithStandardQueryCheckBoxIsNotSelected() {
        getHelper(SearchResultHelper.class).checkSearchWithStandardQueryCheckBoxIsNotSelected();
        return this;
    }

    public BssSearchResultPage checkRelevanceArePresent() {
        getHelper(SearchResultHelper.class).checkRelevanceArePresent();
        return this;
    }

    @Step("Проверяется что у каждого из результатов поиска отображается порядковый номер")
    public BssSearchResultPage checkNumberAroundSearchResultItemIsPresent() {
        List<WebElement> searchWidgetList = mainContentElement.findElements(By.cssSelector(".widget-search"));
        for (WebElement searchWidget : searchWidgetList) {
            List<WebElement> itemList = searchWidget.findElements(By.cssSelector(".widget-header"));
            for (WebElement item : itemList) {
                String itemName = item.findElement(By.cssSelector("[href*='/#/document']")).getText();
                WebElement numberElement = findElementByNoThrow(item, By.cssSelector(".expert-list-number"));
                postponedAssertNotNull(numberElement, "Порядковый номер результата для '" + itemName + "' не найден");
                if (numberElement != null) {
                    postponedAssertTrue(numberElement.isDisplayed(), "Порядковый номер результата для '" + itemName + "' не отображается");
                    postponedAssertFalse(numberElement.getText().isEmpty(), "Порядковый номер результата для '" + itemName + "' пуст");
                }
            }
        }
        return this;
    }

    @Step("Проверяется что у каждого из результатов поиска отображается тип поиска")
    public BssSearchResultPage checkSearchTypeAroundSearchResultItemIsPresent() {
        List<WebElement> searchWidgetList = mainContentElement.findElements(By.cssSelector(".widget-search"));
        for (WebElement searchWidget : searchWidgetList) {
            List<WebElement> itemList = searchWidget.findElements(By.cssSelector(".widget-header"));
            for (WebElement item : itemList) {
                String itemName = item.findElement(By.cssSelector("[href*='/#/document']")).getText();
                WebElement searchType = findElementByNoThrow(item, By.cssSelector(".expert-search-type"));
                postponedAssertNotNull(searchType, "Тип поиска для '" + itemName + "' не найден");
                if (searchType != null) {
                    postponedAssertTrue(searchType.isDisplayed(), "Тип поиска для '" + itemName + "' не отображается");
                    postponedAssertFalse(searchType.getText().isEmpty(), "Тип поиска для '" + itemName + "' пуст");
                }
            }
        }
        return this;
    }

    @Step("Проверяется что у каждого из результатов поиска отображается порядковый номер в выдаче")
    public BssSearchResultPage checkNumbersAroundSearchResultAreSortedAscending() {
        List<WebElement> searchWidgetList = mainContentElement.findElements(By.cssSelector(".widget-search"));
        List<WebElement> numbers = new ArrayList<WebElement>();
        for (WebElement searchWidget : searchWidgetList) {
            List<WebElement> itemList = searchWidget.findElements(By.cssSelector(".widget-header"));
            for (WebElement item : itemList) {
                WebElement numberElement = findElementByNoThrow(item, By.cssSelector(".expert-list-number"));
                numbers.add(numberElement);
            }
        }
        postponedAssertThat(numbers, TestUtils.sortedInAscendingOrder(), "Номера у результатов поиска отсротированы не по порядку");
        return this;
    }

    public BssSearchResultPage checkLawSearchWidgetIsNotPresent() {
        getHelper(SearchResultHelper.class).checkLawSearchWidgetIsNotPresent();
        return this;
    }

    public BssSearchResultPage checkLawSearchWidgetIsPresent() {
        getHelper(SearchResultHelper.class).checkLawSearchWidgetIsPresent();
        return this;
    }

    public BssSearchResultPage checkLawSearchWidgetIsNotEmpty() {
        getHelper(SearchResultHelper.class).checkLawSearchWidgetIsNotEmpty();
        return this;
    }

    public BssSearchResultPage checkFormsSearchWidgetIsNotPresent() {
        getHelper(SearchResultHelper.class).checkFormsSearchWidgetIsNotPresent();
        return this;
    }

    public BssSearchResultPage checkFormsSearchWidgetIsPresent() {
        getHelper(SearchResultHelper.class).checkFormsSearchWidgetIsPresent();
        return this;
    }

    public BssSearchResultPage checkFormsSearchWidgetIsNotEmpty() {
        getHelper(SearchResultHelper.class).checkFormsSearchWidgetIsNotEmpty();
        return this;
    }

    public BssSearchResultPage checkMagazinesSearchWidgetIsNotPresent() {
        getHelper(SearchResultHelper.class).checkMagazinesSearchWidgetIsNotPresent();
        return this;
    }

    public BssSearchResultPage checkMagazinesSearchWidgetIsPresent() {
        getHelper(SearchResultHelper.class).checkMagazinesSearchWidgetIsPresent();
        return this;
    }

    public BssSearchResultPage checkMagazinesSearchWidgetIsNotEmpty() {
        getHelper(SearchResultHelper.class).checkMagazinesSearchWidgetIsNotEmpty();
        return this;
    }

    public BssSearchResultPage checkVideoSearchWidgetIsNotPresent() {
        getHelper(SearchResultHelper.class).checkVideoSearchWidgetIsNotPresent();
        return this;
    }

    public BssSearchResultPage checkVideoSearchWidgetIsPresent() {
        getHelper(SearchResultHelper.class).checkVideoSearchWidgetIsPresent();
        return this;
    }

    public BssSearchResultPage checkVideoSearchWidgetIsNotEmpty() {
        getHelper(SearchResultHelper.class).checkVideoSearchWidgetIsNotEmpty();
        return this;
    }

    public BssSearchResultPage checkDictionarySearchWidgetIsNotPresent() {
        getHelper(SearchResultHelper.class).checkDictionarySearchWidgetIsNotPresent();
        return this;
    }

    public BssSearchResultPage checkDictionarySearchWidgetIsPresent() {
        getHelper(SearchResultHelper.class).checkDictionarySearchWidgetIsPresent();
        return this;
    }

    public BssSearchResultPage checkDictionarySearchWidgetIsNotEmpty() {
        getHelper(SearchResultHelper.class).checkDictionarySearchWidgetIsNotEmpty();
        return this;
    }

    public BssSearchResultPage checkKodySearchWidgetIsNotPresent() {
        getHelper(SearchResultHelper.class).checkKodySearchWidgetIsNotPresent();
        return this;
    }

    public BssSearchResultPage checkKodySearchWidgetIsPresent() {
        getHelper(SearchResultHelper.class).checkKodySearchWidgetIsPresent();
        return this;
    }

    public BssSearchResultPage checkSearchErrorIsNotPresent(){
        getHelper(SearchResultHelper.class).checkSearchErrorIsNotPresent();
        return this;
    }

    public BssSearchResultPage checkKodySearchWidgetIsNotEmpty() {
        getHelper(SearchResultHelper.class).checkKodySearchWidgetIsNotEmpty();
        return this;
    }

    public BssSearchResultPage checkSearchResultItemList() {
        getHelper(SearchResultHelper.class).checkSearchResultItemList();
        return this;
    }

    public BssSearchResultPage clickAllStatusInFilter() {
        getHelper(SearchResultHelper.class).clickAllStatusInFilter();
        return this;
    }

    public BssSearchResultPage clickExpiredStatusInFilter() {
        getHelper(SearchResultHelper.class).clickExpiredStatusInFilter();
        return this;
    }

    public BssSearchResultPage clickActualStatusInFilter() {
        getHelper(SearchResultHelper.class).clickActualStatusInFilter();
        return this;
    }

    public BssSearchResultPage clickInFutureStatusInFilter() {
        getHelper(SearchResultHelper.class).clickInFutureStatusInFilter();
        return this;
    }

    public BssSearchResultPage clickRecomendFilter() {
        getHelper(SearchResultHelper.class).clickRecomendFilter();
        return this;
    }

    public BssSearchResultPage clickLawBaseFilter() {
        getHelper(SearchResultHelper.class).clickLawBaseFilter();
        return this;
    }

    public BssSearchResultPage clickFormsFilter() {
        getHelper(SearchResultHelper.class).clickFormsFilter();
        return this;
    }

    public BssSearchResultPage clickDictionaryFilter() {
        getHelper(SearchResultHelper.class).clickDictionaryFilter();
        return this;
    }

    public BssSearchResultPage clickMagazinesFilter() {
        getHelper(SearchResultHelper.class).clickMagazinesFilter();
        return this;
    }

    public BssSearchResultPage clickVideoFilter() {
        getHelper(SearchResultHelper.class).clickVideoFilter();
        return this;
    }

    public BssSearchResultPage clickServicesFilter() {
        getHelper(SearchResultHelper.class).clickServicesFilter();
        return this;
    }

    public BssDocumentPage clickRandomDocument() {
        getHelper(SearchResultHelper.class).clickRandomDocument();
        return redirectTo(BssDocumentPage.class);
    }

    public BssSearchResultPage clickAllDepartmentsFilter() {
        getHelper(SearchResultHelper.class).clickAllDepartmentsFilter();
        return this;
    }

    public BssSearchResultPage clickFederalDepartmentsFilter() {
        getHelper(SearchResultHelper.class).clickFederalDepartmentsFilter();
        return this;
    }

    public BssSearchResultPage clickRegionalDepartmentsFilter() {
        getHelper(SearchResultHelper.class).clickRegionalDepartmentsFilter();
        return this;
    }

    public BssSearchResultPage clickMinFinDepartmentsFilter() {
        getHelper(SearchResultHelper.class).clickMinFinDepartmentsFilter();
        return this;
    }

    public BssSearchResultPage clickFNSDepartmentsFilter() {
        getHelper(SearchResultHelper.class).clickFNSDepartmentsFilter();
        return this;
    }

    public BssSearchResultPage clickCourtsDepartmentsFilter() {
        getHelper(SearchResultHelper.class).clickCourtsDepartmentsFilter();
        return this;
    }

    public BssSearchResultPage clickDateSortedFilter() {
        getHelper(SearchResultHelper.class).clickDateSortedFilter();
        return this;
    }

    public BssSearchResultPage clickRelevanceSortedFilter() {
        getHelper(SearchResultHelper.class).clickRelevanceSortedFilter();
        return this;
    }

    public BssSearchResultPage clickShowRelevanceLink() {
        getHelper(SearchResultHelper.class).clickShowRelevanceLink();
        return this;
    }

    public BssSearchResultPage checkRelevanceLinkWorks() {
        getHelper(SearchResultHelper.class).checkRelevanceLinkWorks();
        return this;
    }

    @Step("Открыть случайный документ из поисковой выдачи")
    public BssDocumentPage clickRandomDocumentByModuleExclude(String[] excludedModule) {
        WebElement result = mainContentElement.findElement(By.id("searchResultsSection"));
        List<WebElement> docList = result.findElements(By.cssSelector("[href*='/#/document/']"));
        List<WebElement> newDocList = new ArrayList<WebElement>();
        for (WebElement doc : docList) {
            String moduleText = doc.getAttribute("href").split("/#/document/")[1].split("/")[0];
            if (!TestUtils.isElementContainsInArray(moduleText, excludedModule)) {
                newDocList.add(doc);
            }
        }
        WebElement randomDoc = getRandomElementInList(newDocList);
        randomDoc.click();
        return redirectTo(BssDocumentPage.class);
    }

    @Step("Проверяется что заглушка о максимальном размере поисковой выдаче отображается")
    public BssSearchResultPage checkMaxSizeOfResultsWarningIsPresent() {
        waitFewSecond(3000);
        WebElement maxSizeOfResults = findElementByNoThrow(mainContentElement, By.cssSelector(".limit"));
        postponedAssertNotNull(maxSizeOfResults, "Заглушка о максимальном размере поисковой выдаче не найден");
        if (maxSizeOfResults != null) {
            postponedAssertTrue(maxSizeOfResults.isDisplayed(), "заглушка о максимальном размере поисковой выдаче не отображается");
        }
        return this;
    }

    @Step("Проверяется что текст в заглушке о максимальном размере поисковой выдаче")
    public BssSearchResultPage checkMaxSizeOfResultsWarningText() {
        WebElement maxSizeOfResults = mainContentElement.findElement(By.cssSelector(".limit"));
        String expectedText = "Максимальный предел поисковой выдачи 1000 документов. Попробуйте уточнить запрос.";
        String actualText = maxSizeOfResults.getText();
        postponedAssertEquals(actualText, expectedText, "Неправильный текст в загулшке о максимальном размере поисковой выдаче");
        return this;
    }

    public BssSearchResultPage waitForSearchResult() {
        waitForVisibilityOfAllElementsLocatedBy(By.cssSelector(".widget-search"));
        return this;
    }

    public BssSearchResultPage checkSearchResultType(String type) {
        getHelper(SearchResultHelper.class).checkSearchResultType(type);
        return this;
    }

    public BssSearchResultPage checkSearchQuery(String query) {
        getHelper(SearchResultHelper.class).checkSearchQuery(query);
        return this;
    }

    public BssSearchResultPage checkRegion(String region) {
        getHelper(SearchResultHelper.class).checkRegion(region);
        return this;
    }

    public BssSearchResultPage checkTopicFilter() {
        getHelper(SearchResultHelper.class).checkTopicFilter();
        return this;
    }

    public BssSearchResultPage checkLinksTopicFilter() {
        getHelper(SearchResultHelper.class).checkLinksTopicFilter();
        return this;
    }

    public BssSearchResultPage checkRelevanceIsAbsent() {
        getHelper(SearchResultHelper.class).checkRelevanceIsAbsent();
        return this;
    }


    public BssSearchResultPage checkDocumentIsOpened() {
        getHelper(SearchResultHelper.class).checkDocumentIsOpened();
        return this;
    }

    public BssSearchResultPage checkSearchInResultCheckBoxIsPresent() {
        getHelper(SearchResultHelper.class).checkSearchInResultCheckBoxIsPresent();
        return this;
    }

    public BssSearchResultPage checkWidgetsFolder() {
        getHelper(SearchResultHelper.class).checkWidgetsFolder();
        return this;
    }

    public BssSearchResultPage checkWidgetCodeDictionary() {
        getHelper(SearchResultHelper.class).checkWidgetCodeDictionary();
        return this;
    }

    public BssSearchResultPage clickWidgetShowMore() {
        getHelper(SearchResultHelper.class).clickWidgetShowMore();
        return this;
    }

    public BssSearchResultPage checkWidgetsFull() {
        getHelper(SearchResultHelper.class).checkWidgetsFull();
        return this;
    }

    public BssSearchResultPage checkWidgetCodesFull() {
        getHelper(SearchResultHelper.class).checkWidgetCodesFull();
        return this;
    }

    public BssSearchResultPage checkWidgetlsLinks() {
        getHelper(SearchResultHelper.class).checkWidgetlsLinks();
        return this;
    }

    public BssSearchResultPage checkWidgetCodesSoureLink() {
        getHelper(SearchResultHelper.class).checkWidgetCodesSourceLink();
        return this;
    }

    public BssSearchResultPage checkSearchInResultCheckBoxIsNotPresent() {
        getHelper(SearchResultHelper.class).checkSearchInResultCheckBoxIsNotPresent();
        return this;
    }

    public BssSearchResultPage clickSearchInResultCheckBox() {
        getHelper(SearchResultHelper.class).clickSearchInResultCheckBox();
        return this;
    }

    public BssSearchResultPage checkPresentSearchResultText(String query1, String query2) {
        getHelper(SearchResultHelper.class).checkPresentSearchResultText(query1, query2);
        return this;
    }

    public BssSearchResultPage checkPresentSearchResultText(String query1, String query2, String query3) {
        getHelper(SearchResultHelper.class).checkPresentSearchResultText(query1, query2, query3);
        return this;
    }

    public BssSearchResultPage checkHighlightingRequest() {
        getHelper(SearchResultHelper.class).checkHighlightingRequest();
        return this;
    }

    public BssSearchResultPage clickСourtTag() {
        getHelper(SearchResultHelper.class).clickСourtTag();
        return this;
    }

    public BssSearchResultPage clickDateFilter() {
        getHelper(SearchResultHelper.class).clickDateFilter();
        return this;
    }

    public BssSearchResultPage checkConditionFilter() {
        getHelper(SearchResultHelper.class).checkConditionFilter();
        return this;
    }

    public BssSearchResultPage checkExtendedSearch(String type, String city, String query) {
        getHelper(SearchResultHelper.class).checkExtendedSearch(type, city, query);
        return this;
    }

    public BssSearchResultPage clickNotActiveStatus() {
        getHelper(SearchResultHelper.class).clickNotActiveStatus();
        return this;
    }

    public BssSearchResultPage checkPresentFormsDocumentForHour() {
        getHelper(SearchResultHelper.class).checkPresentFormsDocumentForHour();
        return this;
    }

    public BssSearchResultPage checkInputCorrectlyFormsDocumentForHour() {
        getHelper(SearchResultHelper.class).checkInputCorrectlyFormsDocumentForHour();
        return this;
    }

    public BssSearchResultPage checkNotPresentFormsDocumentHouse() {
        getHelper(SearchResultHelper.class).checkNotPresentFormsDocumentHouse();
        return this;
    }

    public BssSearchResultPage checkDisplaySearchResultsForDetails(String query) {
        getHelper(SearchResultHelper.class).checkDisplaySearchResultsForDetails(query);
        return this;
    }

    public BssSearchResultPage checkDisplayingSelectedTypeFilters(String type) {
        getHelper(SearchResultHelper.class).checkDisplayingSelectedTypeFilters(type);
        return this;
    }

    public BssSearchResultPage checkDisplayingText(boolean isAuthorized) {
        getHelper(SearchResultHelper.class).checkDisplayingText(isAuthorized);
        return this;
    }

    public BssSearchResultPage checkDisplayLawSectionFilter() {
        getHelper(SearchResultHelper.class).checkSectionFilterIsPresent();
        return this;
    }

    public BssSearchResultPage checkLinksMagazinFilter() {
        getHelper(SearchResultHelper.class).checkLinksMagazinesFilter();
        return this;
    }

    public BssSearchResultPage checkLinksArchiveFilter() {
        getHelper(SearchResultHelper.class).checkLinksArchiveFilter();
        return this;
    }

    public BssSearchResultPage checkMagazinesFilter() {
        getHelper(SearchResultHelper.class).checkMagazinesFilter();
        return this;
    }

    public BssSearchResultPage checkWidgetLawPresent() {
        getHelper(SearchResultHelper.class).checkWidgetLawPresent();
        return this;
    }

    public BssSearchResultPage checkClickInMainLinkInLawWidget() {
        getHelper(SearchResultHelper.class).checkClickInMainLinkInLawWidget();
        return this;
    }

    public BssSearchResultPage checkLinksWidgetLawPage() {
        getHelper(SearchResultHelper.class).checkLinksWidgetLawPage();
        return this;
    }

    public BssSearchResultPage checkWidgetFormsPresent() {
        getHelper(SearchResultHelper.class).checkWidgetFormsPresent();
        return this;
    }

    public BssSearchResultPage checkClickInMainLinkInFormsWidget() {
        getHelper(SearchResultHelper.class).checkClickInMainLinkInFormsWidget();
        return this;
    }

    public BssSearchResultPage checkLinksWidgetForms() {
        getHelper(SearchResultHelper.class).checkLinksWidgetForms();
        return this;
    }

    public BssSearchResultPage checkWidgetDictionaryPresent() {
        getHelper(SearchResultHelper.class).checkWidgetDictionaryPresent();
        return this;
    }

    public BssSearchResultPage checkClickInMainLinkInDictionaryWidget() {
        getHelper(SearchResultHelper.class).checkClickInMainLinkInWidget(".widget-handbook", MainMenuButtons.DICTIONARIES);
        return this;
    }

    public BssSearchResultPage checkLinksWidgetDictionary() {
        getHelper(SearchResultHelper.class).checkLinksWidgetDictionary();
        return this;
    }

    public BssSearchResultPage checkWidgetMagazinesPresent() {
        getHelper(SearchResultHelper.class).checkMagazinesWidget("В журналах");
        return this;
    }

    public BssSearchResultPage checkClickInMainLinkInMagazinesWidget() {
        getHelper(SearchResultHelper.class).checkClickInMainLinkInWidget(".widget-press", MainMenuButtons.MAGAZINES);
        return this;
    }

    public BssSearchResultPage checkLinksWidgetMagazines() {
        getHelper(SearchResultHelper.class).checkLinksInWidget(".widget-press");
        return this;
    }

    public BssSearchResultPage checkWidgetVideoPresent() {
        getHelper(SearchResultHelper.class).checkVideoWidget("Видео");
        return this;
    }

    public BssSearchResultPage checkClickInMainLinkInWidgetVideo() {
        getHelper(SearchResultHelper.class).checkClickInMainLinkInWidget(".widget-videos", MainMenuButtons.VIDEO);
        return this;
    }

    public BssSearchResultPage checkLinksWidgetVideo() {
        getHelper(SearchResultHelper.class).checkLinksInWidget(".widget-videos");
        return this;
    }

    public BssSearchResultPage checkSectionFilter() {
        getHelper(SearchResultHelper.class).checkSectionFilter(MainMenuButtons.RECOMEND);
        getHelper(SearchResultHelper.class).checkImgSectionFilter();
        return this;
    }

    public BssSearchResultPage checkLinksSectionFilter() {
        getHelper(SearchResultHelper.class).checkLinksSectionFilter();
        return this;
    }

    public BssSearchResultPage checkStatusFilter() {
        getHelper(SearchResultHelper.class).checkStatusFilter();
        return this;
    }

    public BssSearchResultPage checkLinksStatusFilter() {
        getHelper(SearchResultHelper.class).checkExpiredLinksStatusFilter();
        getHelper(SearchResultHelper.class).checkActualLinksStatusFilter();
        getHelper(SearchResultHelper.class).checkActualInFutureLinksStatusFilter();
        getHelper(SearchResultHelper.class).checkUnknownLinksStatusFilter();
        return this;
    }

    public BssSearchResultPage checkBranchFilter() {
        getHelper(SearchResultHelper.class).checkBranchFilter();
        return this;
    }

    public BssSearchResultPage checkLinksBranchFilter() {
        getHelper(SearchResultHelper.class).checkLinksBranchFilter();
        return this;
    }

    public BssSearchResultPage checkDateFilter() {
        getHelper(SearchResultHelper.class).checkDateFilter();
        return this;
    }

    public BssSearchResultPage checkSearchResultsDateFilter() {
        getHelper(SearchResultHelper.class).checkSearchResultsDateFilter();
        return this;
    }

    public BssSearchResultPage checkRelevanceFilter() {
        getHelper(SearchResultHelper.class).checkRelevanceFilter();
        return this;
    }

    public BssSearchResultPage checkRegionFilter(boolean isDefault) {
        getHelper(SearchResultHelper.class).checkRegionFilter(isDefault);
        return this;
    }

    public BssSearchResultPage checkMoscowRegionFilter() {
        getHelper(SearchResultHelper.class).checkMoscowRegionFilter();
        return this;
    }

    public BssSearchResultPage checkRegionInSearchHeader(String partRegionName, int regionId) {
        getHelper(SearchResultHelper.class).checkRegionInSearchHeader(partRegionName, regionId);
        return this;
    }

    public BssSearchResultPage checkRegionFilter(boolean isDefault, String region) {
        getHelper(SearchResultHelper.class).checkRegionFilter(isDefault, region);
        return this;
    }

    public BssSearchResultPage checkRegionFilterInSearchExtendedStringIsNotPresent() {
        getHelper(SearchResultHelper.class).checkRegionFilterInSearchExtendedStringIsNotPresent();
        return this;
    }

    public BssSearchResultPage checkRegionFilterInSearchExtendedStringIsPresent() {
        getHelper(SearchResultHelper.class).checkRegionFilterInSearchExtendedStringIsPresent();
        return this;
    }

    public BssSearchResultPage chooseSecondRegionFilter() {
        getHelper(SearchResultHelper.class).clickSecondRegionFilter();
        return this;
    }

    public BssSearchResultPage checkAllRegionFilter() {
        getHelper(SearchResultHelper.class).checkAllRegionFilter();
        return this;
    }

    public BssSearchResultPage clickInLawPracticeLinkFilter() {
        getHelper(SearchResultHelper.class).clickInLawPracticeLinkFilter();
        return this;
    }

    public BssSearchResultPage clickInLawPracticeLinkFilterAndDoNotWaitingSearchResult() {
        getHelper(SearchResultHelper.class).clickInLawPracticeLinkFilterAndDoNotWaitSearchResult();
        return this;
    }

    public BssSearchResultPage clickInLawLinkFilter() {
        getHelper(SearchResultHelper.class).clickInLawLinkFilter();
        return this;
    }

    public BssSearchResultPage checkInLawAndInPracticeFilterIsPresent() {
        getHelper(SearchResultHelper.class).checkInLawAndInPracticeFilterIsPresent();
        return this;
    }

    public BssSearchResultPage checkSearchResultOnLawPracticePageIsNotPresent() {
        getHelper(SearchResultHelper.class).checkSearchResultOnLawPracticePageIsNotPresent();
        return this;
    }

    public BssSearchResultPage checkSearchInResultCheckboxIsNoSelected() {
        getHelper(SearchResultHelper.class).checkSearchInResultCheckboxIsNoSelected();
        return this;
    }

    public BssSearchResultPage clickTypeDocumentFilter(String filterName) {
        getHelper(SearchResultHelper.class).clickTypeDocumentFilter(filterName);
        return this;
    }

    public BssSearchResultPage checkSortedFilter(String filterName) {
        getHelper(SearchResultHelper.class).checkSortedFilter(filterName);
        return this;
    }

    public BssSearchResultPage checkTypeDocumentFilter(String filterName) {
        getHelper(SearchResultHelper.class).checkTypeDocumentFilter(filterName);
        return this;
    }

    public BssSearchResultPage checkTypeDocumentFilters(){
        getHelper(SearchResultHelper.class).checkTypeDocumentFilters();
        return this;
    }

    public BssSearchResultPage checkDepartmentFilter() {
        getHelper(SearchResultHelper.class).checkDepartmentFilter();
        return this;
    }

    public BssSearchResultPage checkLinksTypeDocumentFilter(){
        getHelper(SearchResultHelper.class).checkLinksTypeDocumentFilter();
        return this;
    }

    public BssSearchResultPage checkStatusFilter(String filterName) {
        getHelper(SearchResultHelper.class).checkStatusFilter(filterName);
        return this;
    }

    public BssSearchResultPage checkSearchTitle(String expectedTitle) {
        getHelper(SearchResultHelper.class).checkSearchTitle(expectedTitle);
        return this;
    }

    public BssSearchResultPage checkExtendedSearchString(String expectedString) {
        getHelper(SearchResultHelper.class).checkExtendedSearchString(expectedString);
        return this;
    }

    public BssSearchResultPage checkTypoWasFixed(String typoString, String fixedString) {
        getHelper(SearchResultHelper.class).checkTypoWasFixed(typoString, fixedString);
        return this;
    }

    public BssSearchResultPage checkSectionFilter(MainMenuButtons mainMenuButton) {
        getHelper(SearchResultHelper.class).checkSectionFilter(mainMenuButton);
        return this;
    }

    public BssSearchResultPage checkLawPracticeFilter() {
        getHelper(SearchResultHelper.class).checkLawPracticeFilter();
        return this;
    }

    public BssSearchResultPage inputNameInDocumentForHourForm(String name) {
        getHelper(SearchResultHelper.class).inputNameInDocumentForHourForm(name);
        return this;
    }

    public BssSearchResultPage inputEmailInDocumentForHourForm(String email) {
        getHelper(SearchResultHelper.class).inputEmailInDocumentForHourForm(email);
        return this;
    }

    public BssSearchResultPage inputCommentInDocumentForHourForm(String comment) {
        getHelper(SearchResultHelper.class).inputCommentInDocumentForHourForm(comment);
        return this;
    }

    public BssSearchResultPage checkNameErrorInDocumentForHourForm(String expectedText) {
        getHelper(SearchResultHelper.class).checkNameErrorInDocumentForHourForm(expectedText);
        return this;
    }

    public BssSearchResultPage checkEmailErrorInDocumentForHourForm(String error) {
        getHelper(SearchResultHelper.class).checkEmailErrorInDocumentForHourForm(error);
        return this;
    }

    public BssSearchResultPage clickSendButtonInDocumentForHourForm() {
        getHelper(SearchResultHelper.class).clickSendButtonInDocumentForHourForm();
        return this;
    }

    public BssLawBasePage clickLinkNavigateToLawPageLink() {
        getHelper(SearchResultHelper.class).clickLinkNavigateToLawPageLink();
        return redirectTo(BssLawBasePage.class);
    }

    public BssSearchResultPage checkTypoBlockIsPresent() {
        getHelper(SearchResultHelper.class).checkTypoBlockIsPresent();
        return this;
    }

    public BssSearchResultPage mouseHoverFirstItemFormWidget() {
        getHelper(SearchResultHelper.class).mouseHoverFirstItemFormWidget();
        return this;
    }

    public BssBasePage checkFirstItemFormWidgetIsRed() {
        getHelper(SearchResultHelper.class).checkFirstItemFormWidgetIsRed();
        return this;
    }

    public BssSearchResultPage checkSearchResultOnLawBasePageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.LAW_BASE);
        getHelper(SearchResultHelper.class).checkSearchResultOnLawBasePageIsOpened();
        return this;
    }

    public BssSearchResultPage checkSearchResultOnLawPracticePageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.LAW_BASE);
        getHelper(SearchResultHelper.class).checkSearchResultOnLawPracticePageIsOpened();
        return this;
    }

    public BssSearchResultPage checkSearchResultArePresentAfterClickAllMaterialsInReferences() {
        getHelper(SearchResultHelper.class).checkSearchResultArePresentAfterClickAllMaterialsInReferences();
        checkCurrentItemIsSelected(MainMenuButtons.LAW_BASE);
        return this;
    }

    public BssSearchResultPage checkResultBlockHasDocumentsLinksAndSnippets() {
        getHelper(SearchResultHelper.class).checkSearchResultDocumentsLinksAndSnippets();
        return this;
    }

    public BssSearchResultPage checkSectionFilterIsPresent() {
        getHelper(SearchResultHelper.class).checkSectionFilterIsPresent();
        return this;
    }

    public BssSearchResultPage checkSortingFilterIsPresent() {
        getHelper(SearchResultHelper.class).checkSortingFilter();
        return this;
    }

    public BssSearchResultPage checkTypeDocumentFilterIsPresent() {
        getHelper(SearchResultHelper.class).checkTypeDocumentFilterIsPresent();
        return this;
    }

    public BssSearchResultPage checkRegionFilterIsPresent() {
        getHelper(SearchResultHelper.class).checkRegionFilterIsPresent();
        return this;
    }

    public BssSearchResultPage checkStatusFilterIsPresent() {
        getHelper(SearchResultHelper.class).checkStatusFilterIsPresent();
        return this;
    }

    public BssSearchResultPage checkStatusFilterIsNotPresent() {
        getHelper(SearchResultHelper.class).checkStatusFilterIsNotPresent();
        return this;
    }

    public BssSearchResultPage checkRubricatorButtonIsPresent() {
        getHelper(SearchResultHelper.class).checkRubricatorButtonsIsPresent();
        return this;
    }

    public BssSearchResultPage checkRubricatorFavoritesButtonIsPresent() {
        getHelper(SearchResultHelper.class).checkRubricatorFavoritesButtonIsPresent();
        return this;
    }

    public BssSearchResultPage checkSearchResultHasStrongText() {
        getHelper(SearchResultHelper.class).checkSearchResultHasStrongText();
        return this;
    }

    public BssSearchResultPage checkSearchResultHasNOTStrongText() {
        getHelper(SearchResultHelper.class).checkSearchResultHasNOTStrongText();
        return this;
    }

    public BssSearchResultPage checkBranchFilterIsPresent() {
        getHelper(SearchResultHelper.class).checkBranchFilterIsPresent();
        return this;
    }

    public BssSearchResultPage checkBranchFilterIsNotPresent() {
        getHelper(SearchResultHelper.class).checkBranchFilterIsNotPresent();
        return this;
    }

    public BssSearchResultPage checkDocumentsInLawPracticePageAreSortedDescending() {
        getHelper(SearchResultHelper.class).checkDocumentsInLawPracticePageAreSortedDescending();
        return this;
    }

    public BssSearchResultPage checkExtendedSearchRemoveAllFilters() {
        getHelper(SearchResultHelper.class).checkExtendedSearchRemoveAllFilters();
        return redirectTo(BssSearchResultPage.class);
    }

    public BssSearchResultPage checkMainLawBasePageIsOpened() {
        getHelper(SearchResultHelper.class).checkMainLawBasePageIsOpened();
        return this;
    }

    public BssSearchResultPage checkJudicialActsFilter() {
        getHelper(SearchResultHelper.class).checkJudicialActsFilter();
        return this;
    }

    public BssSearchResultPage checkLinksJudicialActsFilter() {
        getHelper(SearchResultHelper.class).checkLinksJudicialActsFilter();
        return this;
    }

    public BssSearchResultPage checkExtendedSearchStringContains(String expectedString){
        getHelper(SearchResultHelper.class).checkExtendedSearchStringContains(expectedString);
        return this;
    }

    public BssSearchResultPage checkSearchResultsHeadersContainDocumentNumber(String expectedString){
        getHelper(SearchResultHelper.class).checkSearchResultsHeadersContainDocumentNumber(expectedString);
        return this;
    }

    @Step("Проверить работу подсказок, нажать на подсказку с примечанием")
    public BssSearchResultPage checkSearchAdviceListByDocumentsCountOnExtendedSearchForm() {
        checkExtendedSearchStringContains(getHelper(ExtendedSearchForm.class, this)
                .clickOnSearchAdviceListHintWithCountOfDocumentsFound());
        return this;
    }

    @Step("Проверить подсказку с примечанием название документа, документ должен быть из модулей:81,97,99")
    public BssSearchResultPage checkSearchAdviceListByDocumentNameOnExtendedSearchFormLawBase() {
        getHelper(ExtendedSearchForm.class, this).clickOnSearchAdviceListRemarkWithDocumentName();
        String currentURL = getCurrentUrl();
        currentURL.replace("document//", "document/");
        String[] urlArr = currentURL.split("#")[1].split("/");
        int moduleId = Integer.parseInt(urlArr[2]);
        if (moduleId!=81 && moduleId!=97 && moduleId!=99) {
            setPostponedTestFail("Текущий URL не содержит модуля документа: 81, 97 или 99");
        }
        return this;
    }

    @Step("Проверить подсказку с примечанием название документа, документ должен быть из модулей:96,98")
    public BssSearchResultPage checkSearchAdviceListByDocumentNameOnExtendedSearchFormLawPractice() {
        getHelper(ExtendedSearchForm.class, this).clickOnSearchAdviceListRemarkWithDocumentName();
        String currentURL = getCurrentUrl();
        currentURL.replace("document//", "document/");
        String[] urlArr = currentURL.split("#")[1].split("/");
        int moduleId = Integer.parseInt(urlArr[2]);
        if (moduleId!=96 && moduleId!=98) {
            setPostponedTestFail("Текущий URL не содержит модуля документа: 96,98");
        }
        return this;
    }

    @Step("Проверить навигацию по подсказкам")
    public BssSearchResultPage checkSearchAdviceListNavigation() {
        String currentUrl = getCurrentUrl();
        getHelper(ExtendedSearchForm.class, this).checkNavigationByHintsWithKeysDownAndUp();
        postponedAssertNotEquals(currentUrl, getCurrentUrl(), "После нажатия на кнопку Enter в навигации по номерам " +
                "документов ничего не произошло. URL не поменялся");
        return this;
    }

    public BssSearchResultPage checkSearchResultsForExpersHasDifferentAbbr() {
        getHelper(SearchResultHelper.class).checkSearchResultsForExpersHasDifferentAbbr();
        return this;
    }

    public BssSearchResultPage checkSearchResultsForExpersHasOneAbbr() {
        getHelper(SearchResultHelper.class).checkSearchResultsForExpersHasOneAbbr();
        return this;
    }

    public BssSearchResultPage checkSearchResultsDateFilterFrom(String date) {
        getHelper(SearchResultHelper.class).checkSearchResultsDateFilterFrom(date);
        return this;
    }

    public BssSearchResultPage checkSearchResultsDateFilterTo(String date) {
        getHelper(SearchResultHelper.class).checkSearchResultsDateFilterTo(date);
        return this;
    }

    public BssSearchResultPage checkSearchResultsDateFilterBetween(String dateFrom, String dateTo) {
        getHelper(SearchResultHelper.class).checkSearchResultsDateFilterBetween(dateFrom, dateTo);
        return this;
    }

    public BssSearchResultPage clickOnButtonSearchOnExtendedForm() {
        getHelper(SearchResultHelper.class).clickOnButtonSearchOnExtendedForm();
        return redirectTo(BssSearchResultPage.class);
    }

    public BssSearchResultPage checkSearchResultsArePresent() {
        getHelper(SearchResultHelper.class).checkSearchResultsArePresent();
        return this;
    }

    public BssSearchResultPage checkSearchResultsContainLinksOnDocuments() {
        getHelper(SearchResultHelper.class).checkSearchResultsContainLinksOnDocuments();
        return this;
    }

    public BssSearchResultPage checkSearchResultsDocumentsContainBriefTextUnderTheLinks() {
        getHelper(SearchResultHelper.class).checkSearchResultsDocumentsContainBriefTextUnderTheLinks();
        return this;
    }

    public BssSearchResultPage checkSearchResultsExtendedStringIsPresent() {
        getHelper(SearchResultHelper.class).checkSearchResultsExtendedStringIsPresent();
        return this;
    }

    public BssSearchResultPage checkSearchResultRecomendationItemIsActivated() {
        getHelper(SearchResultHelper.class).checkSearchResultRecomendationItemIsActivated();
        return this;
    }

    @Step("Проверяется, что Отображаются поисковые темы по фильтрам")
    public BssSearchResultPage checkSearchResultTypeFilterByThemesIsPresent() {
        String[] typeFilterNames = {"Все темы", "Проводки"};
        WebElement typeFilter = findElementByNoThrow(By.cssSelector(".menu [data-filtr-name='tags']"));
        postponedAssertTrue(typeFilter != null && typeFilter.isDisplayed(), "Поисковые фильтры по темам не отображены");
        if (typeFilter != null) {
            List<WebElement> filters = typeFilter.findElements(By.cssSelector("li a"));
            postponedAssertEquals(filters.size(), typeFilterNames.length, "Количество тем по фильтрам не " +
                    "соовтетствут с ожидаемым количеством");
            int i = 0;
            for (WebElement filter: filters) {
                postponedAssertEqualsText(filter, typeFilterNames[i]);
                i++;
            }
        }
        return this;
    }
}