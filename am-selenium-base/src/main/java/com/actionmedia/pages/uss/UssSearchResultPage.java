package com.actionmedia.pages.uss;

import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.ExtendedSearchForm;
import com.actionmedia.pages.helpers.SearchResultHelper;
import com.actionmedia.pages.interfaces.ISearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 30.10.13
 * Time: 17:24
 */
@Component
public class UssSearchResultPage extends UssBasePage<UssSearchResultPage> implements ISearchResultPage {

    public UssSearchResultPage checkDocumentIsOpened() {
        getHelper(SearchResultHelper.class).checkDocumentIsOpened();
        return this;
    }

    public UssSearchResultPage checkSearchResultOnRecomendPageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.RECOMEND);
        getHelper(SearchResultHelper.class).checkSearchResultOnRecomendPageIsOpened();
        return this;
    }

    public UssSearchResultPage checkSearchResultOnLawBasePageIsOpened(boolean isDefault) {
        checkCurrentItemIsSelected(MainMenuButtons.LAW_BASE);
        getHelper(SearchResultHelper.class).checkSearchResultOnLawBasePageIsOpened(isDefault);
        return this;
    }

    public UssSearchResultPage checkSearchResultOnLawBasePageIsOpened(boolean isDefault, String departmentFilter) {
        checkCurrentItemIsSelected(MainMenuButtons.LAW_BASE);
        getHelper(SearchResultHelper.class).checkSearchResultOnLawBasePageIsOpened(isDefault, departmentFilter);
        return this;
    }

    public UssSearchResultPage checkSearchResultOnFormsPageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.FORMS);
        getHelper(SearchResultHelper.class).checkSearchResultOnFormsPageIsOpened();
        return this;
    }

    public UssSearchResultPage checkSearchResultOnDictionaryPageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.DICTIONARY);
        getHelper(SearchResultHelper.class).checkSearchResultOnDictionaryPageIsOpened("В справочнике найден", MainMenuButtons.DICTIONARY);
        return this;
    }

    public UssSearchResultPage checkSearchResultOnMagazinesPageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.MAGAZINES_AND_BOOKS);
        getHelper(SearchResultHelper.class).checkSearchResultOnMagazinesPageIsOpened("В журналах и книгах найден", false, MainMenuButtons.MAGAZINES_AND_BOOKS);
        return this;
    }

    public UssSearchResultPage checkSearchResultOnVideosPageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.VIDEO);
        getHelper(SearchResultHelper.class).checkSearchResultOnVideosPageIsOpened();
        return this;
    }

    public UssSearchResultPage checkSearchResultOnWizardsPageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.WIZARDS);
        getHelper(SearchResultHelper.class).checkSearchResultOnWizardsPageIsOpened();
        return this;
    }

    public UssSearchResultPage checkSearchResultOnServicesPageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.SERVICES);
        getHelper(SearchResultHelper.class).checkSearchResultOnServicesPageIsOpened();
        return this;
    }

    public UssSearchResultPage checkSearchResultOnRecomendPageIsNotPresent() {
        checkCurrentItemIsSelected(MainMenuButtons.RECOMEND);
        getHelper(SearchResultHelper.class).checkSearchResultOnRecomendPageIsNotPresent();
        return this;
    }

    public UssSearchResultPage checkSearchResultOnLawBasePageIsNotPresent() {
        checkCurrentItemIsSelected(MainMenuButtons.LAW_BASE);
        getHelper(SearchResultHelper.class).checkSearchResultOnLawBasePageIsNotPresent();
        return this;
    }

    public UssSearchResultPage checkSearchResultOnFormsPageIsNotPresent() {
        checkCurrentItemIsSelected(MainMenuButtons.FORMS);
        getHelper(SearchResultHelper.class).checkSearchResultOnFormsPageIsNotPresent();
        return this;
    }

    public UssSearchResultPage checkSearchResultOnDictionaryPageIsNotPresent() {
        checkCurrentItemIsSelected(MainMenuButtons.DICTIONARY);
        getHelper(SearchResultHelper.class).checkSearchResultOnDictionaryPageIsNotPresent();
        return this;
    }

    public UssSearchResultPage checkSearchResultOnMagazinesPageIsNotPresent() {
        checkCurrentItemIsSelected(MainMenuButtons.MAGAZINES_AND_BOOKS);
        getHelper(SearchResultHelper.class).checkSearchResultOnMagazinesPageIsNotPresent(MainMenuButtons.MAGAZINES_AND_BOOKS);
        return this;
    }

    public UssSearchResultPage checkSearchResultOnVideosPageIsNotPresent() {
        checkCurrentItemIsSelected(MainMenuButtons.VIDEO);
        getHelper(SearchResultHelper.class).checkSearchResultOnVideosPageIsNotPresent();
        return this;
    }

    public UssSearchResultPage checkSearchResultOnWizardsPageIsNotPresent() {
        checkCurrentItemIsSelected(MainMenuButtons.WIZARDS);
        getHelper(SearchResultHelper.class).checkSearchResultOnWizardsPageIsNotPresent();
        return this;
    }

    public UssSearchResultPage checkLinksFromSearchResultPage() {
        getHelper(SearchResultHelper.class).checkLinksFromSearchResultPage();
        return this;
    }

    public UssSearchResultPage checkSearchQueryIsHighlighted(String query) {
        getHelper(SearchResultHelper.class).checkSearchQueryIsHighlighted(query);
        return this;
    }

    public UssSearchResultPage checkSearchQueryIsHighlightedInDocument(String query) {
        getHelper(SearchResultHelper.class).checkSearchQueryIsHighlightedInDocument(query);
        return this;
    }

    public UssSearchResultPage checkScrollingSearchResult() {
        getHelper(SearchResultHelper.class).checkScrollingSearchResult();
        return this;
    }

    public UssSearchResultPage checkSearchResultAreNotRepeated() {
        getHelper(SearchResultHelper.class).checkSearchResultAreNotRepeated();
        return this;
    }

    public UssSearchResultPage checkLinksOnTypo() {
        getHelper(SearchResultHelper.class).checkLinksOnTypo();
        return this;
    }

    public UssSearchResultPage clickLinkOnTypoBySectionType(MainMenuButtons menuButton) {
        getHelper(SearchResultHelper.class).clickLinkOnTypoBySectionType(menuButton);
        return this;
    }

    public UssSearchResultPage checkTabIsSelected(MainMenuButtons menuButton) {
        getHelper(SearchResultHelper.class).checkTabIsSelected(menuButton);
        return this;
    }

    public UssSearchResultPage checkRubricatorLinkOnTypo() {
        getHelper(SearchResultHelper.class).checkRubricatorLinkOnTypo();
        return this;
    }

    public UssSearchResultPage checkTextInTypo(String message) {
        getHelper(SearchResultHelper.class).checkTextInTypo(message);
        return this;
    }

    public UssSearchResultPage checkDocumentWithTextIsPresent(String documentText) {
        getHelper(SearchResultHelper.class).checkDocumentWithTextIsPresent(documentText);
        return this;
    }

    public UssSearchResultPage checkDocumentWithTextIsNotPresent(String documentText) {
        getHelper(SearchResultHelper.class).checkDocumentWithTextIsNotPresent(documentText);
        return this;
    }

    public UssSearchResultPage checkTypoWasFixed(String typoString, String fixedString) {
        getHelper(SearchResultHelper.class).checkTypoWasFixed(typoString, fixedString);
        return this;
    }

    public UssSearchResultPage checkShowRelevanceLinkIsPresent() {
        getHelper(SearchResultHelper.class).checkShowRelevanceLinkIsPresent();
        return this;
    }

    public UssSearchResultPage checkShowRelevanceLinkIsAbsent() {
        getHelper(SearchResultHelper.class).checkShowRelevanceLinkIsAbsent();
        return this;
    }

    public UssSearchResultPage checkRelevanceIsAbsent() {
        getHelper(SearchResultHelper.class).checkRelevanceIsAbsent();
        return this;
    }

    public UssSearchResultPage checkRelevanceLinkWorks() {
        getHelper(SearchResultHelper.class).checkRelevanceLinkWorks();
        return this;
    }

    public UssSearchResultPage clickSearchButtonOnSearchPage() {
        getHelper(SearchResultHelper.class).clickSearchButtonOnSearchPage();
        return this;
    }

    public UssSearchResultPage clickNotActiveStatus() {
        getHelper(SearchResultHelper.class).clickNotActiveStatus();
        return this;
    }

    public UssSearchResultPage clearSearchBoxOnSearchResultPage() {
        clearSearchBox();
        return this;
    }

    public UssSearchResultPage checkSearchResultType(String type) {
        getHelper(SearchResultHelper.class).checkSearchResultType(type);
        return this;
    }

    public UssSearchResultPage checkSearchQuery(String query) {
        getHelper(SearchResultHelper.class).checkSearchQuery(query);
        return this;
    }

    public UssSearchResultPage checkRegion(String region) {
        getHelper(SearchResultHelper.class).checkRegion(region);
        return this;
    }

    public UssSearchResultPage checkSearchResultItemList() {
        getHelper(SearchResultHelper.class).checkSearchResultItemList();
        return this;
    }

    public UssSearchResultPage checkRelevanceFilterSelectedByName(String filterName) {
        getHelper(SearchResultHelper.class).checkRelevanceFilterSelectedByName(filterName);
        return this;
    }

    public UssSearchResultPage checkSearchInResultCheckBoxIsPresent() {
        getHelper(SearchResultHelper.class).checkSearchInResultCheckBoxIsPresent();
        return this;
    }

    public UssSearchResultPage checkWidgetsFolder() {
        getHelper(SearchResultHelper.class).checkWidgetsFolder();
        return this;
    }

    public UssSearchResultPage checkWidgetCodeDictionary() {
        getHelper(SearchResultHelper.class).checkWidgetCodeDictionary();
        return this;
    }

    public UssSearchResultPage clickWidgetShowMore() {
        getHelper(SearchResultHelper.class).clickWidgetShowMore();
        return this;
    }

    public UssSearchResultPage checkWidgetsFull() {
        getHelper(SearchResultHelper.class).checkWidgetsFull();
        return this;
    }

    public UssSearchResultPage checkWidgetCodesFull() {
        getHelper(SearchResultHelper.class).checkWidgetCodesFull();
        return this;
    }

    public UssSearchResultPage checkWidgetsLinks() {
        getHelper(SearchResultHelper.class).checkWidgetlsLinks();
        return this;
    }

    public UssSearchResultPage checkWidgetCodesSourceLink() {
        getHelper(SearchResultHelper.class).checkWidgetCodesSourceLink();
        return this;
    }

    public UssSearchResultPage checkSearchInResultCheckBoxIsNotPresent() {
        getHelper(SearchResultHelper.class).checkSearchInResultCheckBoxIsNotPresent();
        return this;
    }

    public UssSearchResultPage clickSearchInResultCheckBox() {
        getHelper(SearchResultHelper.class).clickSearchInResultCheckBox();
        return this;
    }

    public UssSearchResultPage checkPresentSearchResultText(String query1, String query2) {
        getHelper(SearchResultHelper.class).checkPresentSearchResultText(query1, query2);
        return this;
    }

    public UssSearchResultPage checkPresentSearchResultText(String query1, String query2, String query3) {
        getHelper(SearchResultHelper.class).checkPresentSearchResultText(query1, query2, query3);
        return this;
    }

    public UssSearchResultPage checkHighlightingRequest() {
        getHelper(SearchResultHelper.class).checkHighlightingRequest();
        return this;
    }

    public UssSearchResultPage clickСourtTag() {
        getHelper(SearchResultHelper.class).clickСourtTag();
        return this;
    }

    public UssSearchResultPage clickDateFilter() {
        getHelper(SearchResultHelper.class).clickDateFilter();
        return this;
    }

    public UssSearchResultPage checkConditionFilter() {
        getHelper(SearchResultHelper.class).checkConditionFilter();
        return this;
    }

    public UssSearchResultPage checkExtendedSearch(String type, String city, String query) {
        getHelper(SearchResultHelper.class).checkExtendedSearch(type, city, query);
        return this;
    }

    public UssSearchResultPage checkPresentFormsDocumentForHour() {
        getHelper(SearchResultHelper.class).checkPresentFormsDocumentForHour();
        return this;
    }

    public UssSearchResultPage checkClickLinkNavigateToLawPage() {
        getHelper(SearchResultHelper.class).clickLinkNavigateToLawPageLink();
        return this;
    }

    public UssSearchResultPage checkInputCorrectlyFormsDocumentForHour() {
        getHelper(SearchResultHelper.class).checkInputCorrectlyFormsDocumentForHour();
        return this;
    }

    public UssSearchResultPage checkNotPresentFormsDocumentHouse() {
        getHelper(SearchResultHelper.class).checkNotPresentFormsDocumentHouse();
        return this;
    }

    public UssSearchResultPage checkDisplaySearchResultsForDetails(String query) {
        getHelper(SearchResultHelper.class).checkDisplaySearchResultsForDetails(query);
        return this;
    }

    public UssSearchResultPage checkDisplayingSelectedTypeFilters(String type) {
        getHelper(SearchResultHelper.class).checkDisplayingSelectedTypeFilters(type);
        return this;
    }

    public UssSearchResultPage checkDisplayingText(boolean isAuthorized) {
        getHelper(SearchResultHelper.class).checkDisplayingText(isAuthorized);
        return this;
    }

    public UssSearchResultPage checkDisplayLawSectionFilter() {
        getHelper(SearchResultHelper.class).checkSectionFilter(MainMenuButtons.LAW_BASE);
        return this;
    }

    public UssSearchResultPage checkLinksMagazinFilter() {
        getHelper(SearchResultHelper.class).checkLinksMagazinesFilter();
        return this;
    }

    public UssSearchResultPage checkLinksArchiveFilter() {
        getHelper(SearchResultHelper.class).checkLinksArchiveFilter();
        return this;
    }

    public UssSearchResultPage checkMagazinesFilter() {
        getHelper(SearchResultHelper.class).checkMagazinesFilter();
        return this;
    }

    public UssSearchResultPage checkWidgetLawPresent() {
        getHelper(SearchResultHelper.class).checkWidgetLawPresent();
        return this;
    }

    public UssSearchResultPage checkClickInMainLinkInLawWidget() {
        getHelper(SearchResultHelper.class).checkClickInMainLinkInLawWidget();
        return this;
    }

    public UssSearchResultPage checkLinksWidgetLawPage() {
        getHelper(SearchResultHelper.class).checkLinksWidgetLawPage();
        return this;
    }

    public UssSearchResultPage checkWidgetFormsPresent() {
        getHelper(SearchResultHelper.class).checkWidgetFormsPresent();
        return this;
    }

    public UssSearchResultPage checkClickInMainLinkInFormsWidget() {
        getHelper(SearchResultHelper.class).checkClickInMainLinkInFormsWidget();
        return this;
    }

    public UssSearchResultPage checkLinksWidgetForms() {
        getHelper(SearchResultHelper.class).checkLinksWidgetForms();
        return this;
    }

    public UssSearchResultPage checkWidgetDictionaryPresent() {
        WebElement widget = findElementByNoThrow(By.cssSelector(".widget-handbook"));
        getHelper(SearchResultHelper.class).checkWidget(widget, "В справочнике");
        return this;
    }

    public UssSearchResultPage checkClickInMainLinkInDictionaryWidget() {
        getHelper(SearchResultHelper.class).checkClickInMainLinkInWidget(".widget-handbook", MainMenuButtons.DICTIONARY);
        return this;
    }

    public UssSearchResultPage checkLinksWidgetDictionary() {
        getHelper(SearchResultHelper.class).checkLinksWidgetDictionary();
        return this;
    }

    public UssSearchResultPage checkWidgetMagazinesPresent() {
        getHelper(SearchResultHelper.class).checkMagazinesWidget("В журналах и книгах");
        return this;
    }

    public UssSearchResultPage checkClickInMainLinkInMagazinesWidget() {
        getHelper(SearchResultHelper.class).checkClickInMainLinkInWidget(".widget-press", MainMenuButtons.MAGAZINES_AND_BOOKS);
        return this;
    }

    public UssSearchResultPage checkLinksWidgetMagazines() {
        getHelper(SearchResultHelper.class).checkLinksInWidget(".widget-press");
        return this;
    }

    public UssSearchResultPage checkWidgetVideoPresent() {
        getHelper(SearchResultHelper.class).checkVideoWidget("Видео");
        return this;
    }

    public UssSearchResultPage checkClickInMainLinkInWidgetVideo() {
        getHelper(SearchResultHelper.class).checkClickInMainLinkInWidget(".widget-videos", MainMenuButtons.VIDEO);
        return this;
    }

    public UssSearchResultPage checkLinksWidgetVideo() {
        getHelper(SearchResultHelper.class).checkLinksInWidget(".widget-videos");
        return this;
    }

    public UssSearchResultPage checkSectionFilter() {
        getHelper(SearchResultHelper.class).checkSectionFilter(MainMenuButtons.RECOMEND);
        getHelper(SearchResultHelper.class).checkImgSectionFilter();
        return this;
    }

    public UssSearchResultPage checkLinksSectionFilter() {
        getHelper(SearchResultHelper.class).checkLinksSectionFilter();
        return this;
    }

    public UssSearchResultPage checkStatusFilter() {
        getHelper(SearchResultHelper.class).checkStatusFilter();
        return this;
    }

    public UssSearchResultPage checkLinksStatusFilter() {
        getHelper(SearchResultHelper.class).checkExpiredLinksStatusFilter();
        getHelper(SearchResultHelper.class).checkActualLinksStatusFilter();
        getHelper(SearchResultHelper.class).checkActualInFutureLinksStatusFilter();
        getHelper(SearchResultHelper.class).checkUnknownLinksStatusFilter();
        return this;
    }

    public UssSearchResultPage checkActualLinksStatusFilter() {
        getHelper(SearchResultHelper.class).checkActualLinksStatusFilter();
        return this;
    }

    public UssSearchResultPage checkDateFilter() {
        getHelper(SearchResultHelper.class).checkDateFilter();
        return this;
    }

    public UssSearchResultPage checkSearchResultsDateFilter() {
        getHelper(SearchResultHelper.class).checkSearchResultsDateFilter();
        return this;
    }

    public UssSearchResultPage clickDateSortedFilter() {
        getHelper(SearchResultHelper.class).clickDateSortedFilter();
        return this;
    }

    public UssSearchResultPage clickRelevanceSortedFilter() {
        getHelper(SearchResultHelper.class).clickRelevanceSortedFilter();
        return this;
    }

    public UssSearchResultPage checkRelevanceFilter() {
        getHelper(SearchResultHelper.class).checkRelevanceFilter();
        return this;
    }

    public UssSearchResultPage checkRegionFilter(boolean isDefault) {
        getHelper(SearchResultHelper.class).checkRegionFilter(isDefault);
        return this;
    }

    public UssSearchResultPage checkRegionFilter(boolean isDefault, String region) {
        getHelper(SearchResultHelper.class).checkRegionFilter(isDefault, region);
        return this;
    }

    public UssSearchResultPage checkRegionInSearchHeader(String partRegionName, int regionId) {
        getHelper(SearchResultHelper.class).checkRegionInSearchHeader(partRegionName, regionId);
        return this;
    }

    public UssSearchResultPage checkRegionFilterInSearchExtendedStringIsNotPresent() {
        getHelper(SearchResultHelper.class).checkRegionFilterInSearchExtendedStringIsNotPresent();
        return this;
    }

    public UssSearchResultPage checkRegionFilterInSearchExtendedStringIsPresent() {
        getHelper(SearchResultHelper.class).checkRegionFilterInSearchExtendedStringIsPresent();
        return this;
    }

    public UssSearchResultPage chooseSecondRegionFilter() {
        getHelper(SearchResultHelper.class).clickSecondRegionFilter();
        return this;
    }

    public UssSearchResultPage checkMoscowRegionFilter() {
        getHelper(SearchResultHelper.class).checkMoscowRegionFilter();
        return this;
    }

    public UssSearchResultPage checkAllRegionFilter() {
        getHelper(SearchResultHelper.class).checkAllRegionFilter();
        return this;
    }

    public UssSearchResultPage clickInLawPracticeLinkFilter() {
        getHelper(SearchResultHelper.class).clickInLawPracticeLinkFilter();
        return this;
    }

    public UssSearchResultPage clickInLawLinkFilter() {
        getHelper(SearchResultHelper.class).clickInLawLinkFilter();
        return this;
    }

    public UssSearchResultPage clickInLawPracticeLinkFilterAndDoNotWaitSearchResult() {
        getHelper(SearchResultHelper.class).clickInLawPracticeLinkFilterAndDoNotWaitSearchResult();
        return this;
    }

    public UssSearchResultPage clickInLawBaseLinkFilterAndDoNotWaitSearchResult() {
        getHelper(SearchResultHelper.class).clickInLawLinkFilterAndDoNotWaitSearchResult();
        return this;
    }

    public UssSearchResultPage checkInLawAndInPracticeFilterIsPresent() {
        getHelper(SearchResultHelper.class).checkInLawAndInPracticeFilterIsPresent();
        return this;
    }

    public UssSearchResultPage checkSearchResultOnLawPracticePageIsNotPresent() {
        getHelper(SearchResultHelper.class).checkSearchResultOnLawPracticePageIsNotPresent();
        return this;
    }

    public UssSearchResultPage checkSearchInResultCheckboxIsNoSelected() {
        getHelper(SearchResultHelper.class).checkSearchInResultCheckboxIsNoSelected();
        return this;
    }

    public UssSearchResultPage clickTypeDocumentFilter(String filterName) {
        getHelper(SearchResultHelper.class).clickTypeDocumentFilter(filterName);
        return this;
    }

    public UssSearchResultPage checkSortedFilter(String filterName) {
        getHelper(SearchResultHelper.class).checkSortedFilter(filterName);
        return this;
    }

    public UssSearchResultPage checkTypeDocumentFilter(String filterName) {
        getHelper(SearchResultHelper.class).checkTypeDocumentFilter(filterName);
        return this;
    }

    public UssSearchResultPage checkTypeDocumentFilters() {
        getHelper(SearchResultHelper.class).checkTypeDocumentFilters();
        return this;
    }

    public UssSearchResultPage checkDepartmentFilter() {
        getHelper(SearchResultHelper.class).checkDepartmentFilter();
        return this;
    }

    public UssSearchResultPage checkLinksTypeDocumentFilter() {
        getHelper(SearchResultHelper.class).checkLinksTypeDocumentFilter();
        return this;
    }

    public UssSearchResultPage checkStatusFilter(String filterName) {
        getHelper(SearchResultHelper.class).checkStatusFilter(filterName);
        return this;
    }

    public UssSearchResultPage checkSearchTitle(String expectedTitle) {
        getHelper(SearchResultHelper.class).checkSearchTitle(expectedTitle);
        return this;
    }

    public UssSearchResultPage checkExtendedSearchString(String expectedString) {
        getHelper(SearchResultHelper.class).checkExtendedSearchString(expectedString);
        return this;
    }

    public UssSearchResultPage checkSectionFilter(MainMenuButtons mainMenuButton) {
        getHelper(SearchResultHelper.class).checkSectionFilter(mainMenuButton);
        return this;
    }

    public UssSearchResultPage checkLawPracticeFilter() {
        getHelper(SearchResultHelper.class).checkLawPracticeFilter();
        return this;
    }

    public UssSearchResultPage inputNameInDocumentForHourForm(String name) {
        getHelper(SearchResultHelper.class).inputNameInDocumentForHourForm(name);
        return this;
    }

    public UssSearchResultPage inputEmailInDocumentForHourForm(String email) {
        getHelper(SearchResultHelper.class).inputEmailInDocumentForHourForm(email);
        return this;
    }

    public UssSearchResultPage inputCommentInDocumentForHourForm(String comment) {
        getHelper(SearchResultHelper.class).inputCommentInDocumentForHourForm(comment);
        return this;
    }

    public UssSearchResultPage checkNameErrorInDocumentForHourForm(String expectedText) {
        getHelper(SearchResultHelper.class).checkNameErrorInDocumentForHourForm(expectedText);
        return this;
    }

    public UssSearchResultPage checkEmailErrorInDocumentForHourForm(String error) {
        getHelper(SearchResultHelper.class).checkEmailErrorInDocumentForHourForm(error);
        return this;
    }

    public UssSearchResultPage clickSendButtonInDocumentForHourForm() {
        getHelper(SearchResultHelper.class).clickSendButtonInDocumentForHourForm();
        return this;
    }

    public UssLawBasePage clickLinkNavigateToLawPageLink() {
        getHelper(SearchResultHelper.class).clickLinkNavigateToLawPageLink();
        return redirectTo(UssLawBasePage.class);
    }

    public UssSearchResultPage checkTypoBlockIsPresent() {
        getHelper(SearchResultHelper.class).checkTypoBlockIsPresent();
        return this;
    }

    public UssSearchResultPage checkLawSearchWidgetIsNotPresent() {
        getHelper(SearchResultHelper.class).checkLawSearchWidgetIsNotPresent();
        return this;
    }

    public UssSearchResultPage checkLawSearchWidgetIsPresent() {
        getHelper(SearchResultHelper.class).checkLawSearchWidgetIsPresent();
        return this;
    }

    public UssSearchResultPage checkLawSearchWidgetIsNotEmpty() {
        getHelper(SearchResultHelper.class).checkLawSearchWidgetIsNotEmpty();
        return this;
    }

    public UssSearchResultPage checkFormsSearchWidgetIsNotPresent() {
        getHelper(SearchResultHelper.class).checkFormsSearchWidgetIsNotPresent();
        return this;
    }

    public UssSearchResultPage checkFormsSearchWidgetIsPresent() {
        getHelper(SearchResultHelper.class).checkFormsSearchWidgetIsPresent();
        return this;
    }

    public UssSearchResultPage checkFormsSearchWidgetIsNotEmpty() {
        getHelper(SearchResultHelper.class).checkFormsSearchWidgetIsNotEmpty();
        return this;
    }

    public UssSearchResultPage checkMagazinesSearchWidgetIsNotPresent() {
        getHelper(SearchResultHelper.class).checkMagazinesSearchWidgetIsNotPresent();
        return this;
    }

    public UssSearchResultPage checkMagazinesSearchWidgetIsPresent() {
        getHelper(SearchResultHelper.class).checkMagazinesSearchWidgetIsPresent();
        return this;
    }

    public UssSearchResultPage checkMagazinesSearchWidgetIsNotEmpty() {
        getHelper(SearchResultHelper.class).checkMagazinesSearchWidgetIsNotEmpty();
        return this;
    }

    public UssSearchResultPage checkVideoSearchWidgetIsNotPresent() {
        getHelper(SearchResultHelper.class).checkVideoSearchWidgetIsNotPresent();
        return this;
    }

    public UssSearchResultPage checkVideoSearchWidgetIsPresent() {
        getHelper(SearchResultHelper.class).checkVideoSearchWidgetIsPresent();
        return this;
    }

    public UssSearchResultPage checkVideoSearchWidgetIsNotEmpty() {
        getHelper(SearchResultHelper.class).checkVideoSearchWidgetIsNotEmpty();
        return this;
    }

    public UssSearchResultPage checkDictionarySearchWidgetIsNotPresent() {
        getHelper(SearchResultHelper.class).checkDictionarySearchWidgetIsNotPresent();
        return this;
    }

    public UssSearchResultPage checkDictionarySearchWidgetIsPresent() {
        getHelper(SearchResultHelper.class).checkDictionarySearchWidgetIsPresent();
        return this;
    }

    public UssSearchResultPage checkSearchErrorIsNotPresent() {
        getHelper(SearchResultHelper.class).checkSearchErrorIsNotPresent();
        return this;
    }

    public UssSearchResultPage checkDictionarySearchWidgetIsNotEmpty() {
        getHelper(SearchResultHelper.class).checkDictionarySearchWidgetIsNotEmpty();
        return this;
    }

    public UssSearchResultPage checkKodySearchWidgetIsNotPresent() {
        getHelper(SearchResultHelper.class).checkKodySearchWidgetIsNotPresent();
        return this;
    }

    public UssSearchResultPage checkKodySearchWidgetIsPresent() {
        getHelper(SearchResultHelper.class).checkKodySearchWidgetIsPresent();
        return this;
    }

    public UssSearchResultPage checkKodySearchWidgetIsNotEmpty() {
        getHelper(SearchResultHelper.class).checkKodySearchWidgetIsNotEmpty();
        return this;
    }

    public UssSearchResultPage clickActualStatusInFilter() {
        getHelper(SearchResultHelper.class).clickActualStatusInFilter();
        return this;
    }

    public UssSearchResultPage clickFormsFilter() {
        getHelper(SearchResultHelper.class).clickFormsFilter();
        return this;
    }

    public UssSearchResultPage mouseHoverThirdItemFormWidget() {
        getHelper(SearchResultHelper.class).mouseHoverThirdItemFormWidget();
        return this;
    }

    public UssSearchResultPage checkThirdItemFormWidgetIsPurple() {
        getHelper(SearchResultHelper.class).checkThirdItemFormWidgetIsPurple();
        return this;
    }

    public UssSearchResultPage checkSearchResultOnLawBasePageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.LAW_BASE);
        getHelper(SearchResultHelper.class).checkSearchResultOnLawBasePageIsOpened();
        return this;
    }

    public UssSearchResultPage checkSearchResultOnLawPracticePageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.LAW_PRACTICE);
        getHelper(SearchResultHelper.class).checkSearchResultOnLawPracticePageIsOpened();
        return this;
    }

    public UssSearchResultPage checkSearchResultArePresentAfterClickAllMaterialsInReferences() {
        getHelper(SearchResultHelper.class).checkSearchResultArePresentAfterClickAllMaterialsInReferences();
        checkCurrentItemIsSelected(MainMenuButtons.LAW_PRACTICE);
        return this;
    }

    public UssSearchResultPage checkResultBlockHasDocumentsLinksAndSnippets() {
        getHelper(SearchResultHelper.class).checkSearchResultDocumentsLinksAndSnippets();
        return this;
    }

    public UssSearchResultPage checkSectionFilterIsPresent() {
        getHelper(SearchResultHelper.class).checkSectionFilterIsPresent();
        return this;
    }

    public UssSearchResultPage checkSortingFilterIsPresent() {
        getHelper(SearchResultHelper.class).checkSortingFilter();
        return this;
    }

    public UssSearchResultPage checkTypeDocumentFilterIsPresent() {
        getHelper(SearchResultHelper.class).checkTypeDocumentFilterIsPresent();
        return this;
    }

    public UssSearchResultPage checkRegionFilterIsPresent() {
        getHelper(SearchResultHelper.class).checkRegionFilterIsPresent();
        return this;
    }

    public UssSearchResultPage checkStatusFilterIsPresent() {
        getHelper(SearchResultHelper.class).checkStatusFilterIsPresent();
        return this;
    }

    public UssSearchResultPage checkRubricatorButtonIsPresent() {
        getHelper(SearchResultHelper.class).checkRubricatorButtonsIsPresent();
        return this;
    }

    public UssSearchResultPage checkRubricatorFavoritesButtonIsPresent() {
        getHelper(SearchResultHelper.class).checkRubricatorFavoritesButtonIsPresent();
        return this;
    }

    public UssSearchResultPage checkSearchResultHasStrongText() {
        getHelper(SearchResultHelper.class).checkSearchResultHasStrongText();
        return this;
    }

    public UssSearchResultPage checkSearchResultHasNOTStrongText() {
        getHelper(SearchResultHelper.class).checkSearchResultHasNOTStrongText();
        return this;
    }

    public UssSearchResultPage checkActiveSectionFilter(MainMenuButtons filterName) {
        getHelper(SearchResultHelper.class).checkActiveSectionFilter(filterName);
        return this;
    }

    public UssSearchResultPage checkDocumentsInLawPracticePageAreSortedDescending() {
        getHelper(SearchResultHelper.class).checkDocumentsInLawPracticePageAreSortedDescending();
        return this;
    }

    public UssSearchResultPage clickOnButtonSearchOnExtendedForm() {
        getHelper(SearchResultHelper.class).clickOnButtonSearchOnExtendedForm();
        return redirectTo(UssSearchResultPage.class);
    }

    public UssSearchResultPage checkExtendedSearchRemoveAllFilters() {
        getHelper(SearchResultHelper.class).checkExtendedSearchRemoveAllFilters();
        return redirectTo(UssSearchResultPage.class);
    }

    public UssSearchResultPage checkMainLawBasePageIsOpened() {
        getHelper(SearchResultHelper.class).checkMainLawBasePageIsOpened();
        return this;
    }

    public UssSearchResultPage checkMainLawPracticePageIsOpened() {
        getHelper(SearchResultHelper.class).checkMainLawBasePageIsOpened();
        return this;
    }

    public UssSearchResultPage checkStatusFilterIsNotPresent() {
        getHelper(SearchResultHelper.class).checkStatusFilterIsNotPresent();
        return this;
    }

    public UssSearchResultPage checkJudicialActsFilter() {
        getHelper(SearchResultHelper.class).checkJudicialActsFilter();
        return this;
    }

    public UssSearchResultPage checkLinksJudicialActsFilter() {
        getHelper(SearchResultHelper.class).checkLinksJudicialActsFilter();
        return this;
    }

    public UssDocumentPage clickRandomDocument() {
        getHelper(SearchResultHelper.class).clickRandomDocument();
        return redirectTo(UssDocumentPage.class);
    }

    public UssSearchResultPage checkExtendedSearchStringContains(String expectedString) {
        getHelper(SearchResultHelper.class).checkExtendedSearchStringContains(expectedString);
        return this;
    }

    public UssSearchResultPage checkSearchResultsHeadersContainDocumentNumber(String expectedString) {
        getHelper(SearchResultHelper.class).checkSearchResultsHeadersContainDocumentNumber(expectedString);
        return this;
    }

    @Step("Проверить работу подсказок, нажать на подсказку с примечанием")
    public UssSearchResultPage checkSearchAdviceListByDocumentsCountOnExtendedSearchForm() {
        checkExtendedSearchStringContains(getHelper(ExtendedSearchForm.class, this)
                .clickOnSearchAdviceListHintWithCountOfDocumentsFound());
        return this;
    }

    @Step("Проверить подсказку с примечанием название документа, документ должен быть из модулей:81,97,99")
    public UssSearchResultPage checkSearchAdviceListByDocumentNameOnExtendedSearchFormLawBase() {
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
    public UssSearchResultPage checkSearchAdviceListByDocumentNameOnExtendedSearchFormLawPractice() {
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
    public UssSearchResultPage checkSearchAdviceListNavigation() {
        String currentUrl = getCurrentUrl();
        getHelper(ExtendedSearchForm.class, this).checkNavigationByHintsWithKeysDownAndUp();
        postponedAssertNotEquals(currentUrl, getCurrentUrl(), "После нажатия на кнопку Enter в навигации по номерам " +
                "документов ничего не произошло. URL не поменялся");
        return this;
    }

    public UssSearchResultPage checkSearchResultsForExpersHasDifferentAbbr() {
        getHelper(SearchResultHelper.class).checkSearchResultsForExpersHasDifferentAbbr();
        return this;
    }

    public UssSearchResultPage checkSearchResultsForExpersHasOneAbbr() {
        getHelper(SearchResultHelper.class).checkSearchResultsForExpersHasOneAbbr();
        return this;
    }

    public UssSearchResultPage checkSearchResultsDateFilterFrom(String date) {
        getHelper(SearchResultHelper.class).checkSearchResultsDateFilterFrom(date);
        return this;
    }

    public UssSearchResultPage checkSearchResultsDateFilterTo(String date) {
        getHelper(SearchResultHelper.class).checkSearchResultsDateFilterTo(date);
        return this;
    }

    public UssSearchResultPage checkSearchResultsDateFilterBetween(String dateFrom, String dateTo) {
        getHelper(SearchResultHelper.class).checkSearchResultsDateFilterBetween(dateFrom, dateTo);
        return this;
    }
    
    public UssSearchResultPage checkSearchResultsArePresent() {
        getHelper(SearchResultHelper.class).checkSearchResultsArePresent();
        return this;
    }

    public UssSearchResultPage checkSearchResultsContainLinksOnDocuments() {
        getHelper(SearchResultHelper.class).checkSearchResultsContainLinksOnDocuments();
        return this;
    }

    public UssSearchResultPage checkSearchResultsDocumentsContainBriefTextUnderTheLinks() {
        getHelper(SearchResultHelper.class).checkSearchResultsDocumentsContainBriefTextUnderTheLinks();
        return this;
    }

    public UssSearchResultPage checkSearchResultsExtendedStringIsPresent() {
        getHelper(SearchResultHelper.class).checkSearchResultsExtendedStringIsPresent();
        return this;
    }

    public UssSearchResultPage checkSearchResultRecomendationItemIsActivated() {
        getHelper(SearchResultHelper.class).checkSearchResultRecomendationItemIsActivated();
        return this;
    }

    @Step("Проверяется, что Отображаются поисковые темы по фильтрам")
    public UssSearchResultPage checkSearchResultTypeFilterByThemesIsPresent() {
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
