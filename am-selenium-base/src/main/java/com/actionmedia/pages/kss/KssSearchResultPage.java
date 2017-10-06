package com.actionmedia.pages.kss;

import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.ExtendedSearchForm;
import com.actionmedia.pages.helpers.SearchResultHelper;
import com.actionmedia.pages.interfaces.ISearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

@Component
public class KssSearchResultPage extends KssBasePage<KssSearchResultPage> implements ISearchResultPage {

    public KssSearchResultPage checkDocumentIsOpened() {
        getHelper(SearchResultHelper.class).checkDocumentIsOpened();
        return this;
    }

    public KssSearchResultPage checkSearchResultOnAnswersPageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.ANSWERS);
        getHelper(SearchResultHelper.class).checkSearchResultOnAnswersPageIsOpened();
        return this;
    }

    public KssSearchResultPage checkSearchResultOnLawBasePageIsOpened(boolean isDefault) {
        checkCurrentItemIsSelected(MainMenuButtons.LAW_BASE);
        getHelper(SearchResultHelper.class).checkSearchResultOnLawBasePageIsOpened(isDefault);
        return this;
    }

    public KssSearchResultPage checkSearchResultOnLawBasePageIsOpened(boolean isDefault, String departmentFilter) {
        checkCurrentItemIsSelected(MainMenuButtons.LAW_BASE);
        getHelper(SearchResultHelper.class).checkSearchResultOnLawBasePageIsOpened(isDefault, departmentFilter);
        return this;
    }

    public KssSearchResultPage checkSearchResultOnLawBasePageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.LAW_BASE);
        getHelper(SearchResultHelper.class).checkSearchResultOnLawBasePageIsOpened();
        return this;
    }

    public KssSearchResultPage checkSearchResultOnLawPracticePageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.LAW_BASE);
        getHelper(SearchResultHelper.class).checkSearchResultOnLawPracticePageIsOpened();
        return this;
    }

    public KssSearchResultPage checkSearchResultArePresentAfterClickAllMaterialsInReferences() {
        getHelper(SearchResultHelper.class).checkSearchResultArePresentAfterClickAllMaterialsInReferences();
        checkCurrentItemIsSelected(MainMenuButtons.LAW_BASE);
        return this;
    }

    public KssSearchResultPage checkResultBlockHasDocumentsLinksAndSnippets() {
        getHelper(SearchResultHelper.class).checkSearchResultDocumentsLinksAndSnippets();
        return this;
    }

    public KssSearchResultPage checkSearchResultOnFormsPageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.FORMS);
        getHelper(SearchResultHelper.class).checkSearchResultOnFormsPageIsOpened();
        return this;
    }

    public KssSearchResultPage checkSearchResultOnDictionaryPageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.DICTIONARY);
        getHelper(SearchResultHelper.class).checkSearchResultOnDictionaryPageIsOpened("В справочниках найден", MainMenuButtons.DICTIONARY);
        return this;
    }

    public KssSearchResultPage checkSearchResultOnMagazinesPageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.MAGAZINES_AND_BOOKS);
        getHelper(SearchResultHelper.class).checkSearchResultOnMagazinesPageIsOpened("В журналах и книгах найдено", false, MainMenuButtons.MAGAZINES_AND_BOOKS);
        return this;
    }

    public KssSearchResultPage checkSearchResultOnVideosPageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.VIDEO);
        getHelper(SearchResultHelper.class).checkSearchResultOnVideosPageIsOpened();
        return this;
    }

    public KssSearchResultPage checkSearchResultOnServicesPageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.SERVICES);
        getHelper(SearchResultHelper.class).checkSearchResultOnServicesPageIsOpened();
        return this;
    }

    public KssSearchResultPage checkSearchResultOnWizardsPageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.WIZARDS);
        getHelper(SearchResultHelper.class).checkSearchResultOnWizardsPageIsOpened();
        return this;
    }

    public KssSearchResultPage checkSearchResultOnAnswersPageIsNotPresent() {
        checkCurrentItemIsSelected(MainMenuButtons.ANSWERS);
        getHelper(SearchResultHelper.class).checkSearchResultOnAnswersPageIsNotPresent();
        return this;
    }

    public KssSearchResultPage checkSearchResultOnLawBasePageIsNotPresent() {
        checkCurrentItemIsSelected(MainMenuButtons.LAW_BASE);
        getHelper(SearchResultHelper.class).checkSearchResultOnLawBasePageIsNotPresent();
        return this;
    }

    public KssSearchResultPage checkSearchResultOnFormsPageIsNotPresent() {
        checkCurrentItemIsSelected(MainMenuButtons.FORMS);
        getHelper(SearchResultHelper.class).checkSearchResultOnFormsPageIsNotPresent();
        return this;
    }

    public KssSearchResultPage checkSearchResultOnDictionaryPageIsNotPresent() {
        checkCurrentItemIsSelected(MainMenuButtons.DICTIONARY);
        getHelper(SearchResultHelper.class).checkSearchResultOnDictionaryPageIsNotPresent();
        return this;
    }

    public KssSearchResultPage checkSearchResultOnMagazinesPageIsNotPresent() {
        checkCurrentItemIsSelected(MainMenuButtons.MAGAZINES_AND_BOOKS);
        getHelper(SearchResultHelper.class).checkSearchResultOnMagazinesPageIsNotPresent(MainMenuButtons.MAGAZINES_AND_BOOKS);
        return this;
    }

    public KssSearchResultPage checkSearchResultOnVideosPageIsNotPresent() {
        checkCurrentItemIsSelected(MainMenuButtons.VIDEO);
        getHelper(SearchResultHelper.class).checkSearchResultOnVideosPageIsNotPresent();
        return this;
    }

    public KssSearchResultPage checkSearchResultOnWizardsPageIsNotPresent() {
        checkCurrentItemIsSelected(MainMenuButtons.WIZARDS);
        getHelper(SearchResultHelper.class).checkSearchResultOnWizardsPageIsNotPresent();
        return this;
    }

    public KssSearchResultPage checkLinksFromSearchResultPage() {
        getHelper(SearchResultHelper.class).checkLinksFromSearchResultPage();
        return this;
    }

    public KssSearchResultPage checkSearchQueryIsHighlighted(String query) {
        getHelper(SearchResultHelper.class).checkSearchQueryIsHighlighted(query);
        return this;
    }

    public KssSearchResultPage checkSearchQueryIsHighlightedInDocument(String query) {
        getHelper(SearchResultHelper.class).checkSearchQueryIsHighlightedInDocument(query);
        return this;
    }

    public KssSearchResultPage checkScrollingSearchResult() {
        getHelper(SearchResultHelper.class).checkScrollingSearchResult();
        return this;
    }

    public KssSearchResultPage checkSearchResultAreNotRepeated() {
        getHelper(SearchResultHelper.class).checkSearchResultAreNotRepeated();
        return this;
    }

    public KssSearchResultPage checkLinksOnTypo() {
        getHelper(SearchResultHelper.class).checkLinksOnTypo();
        return this;
    }

    public KssSearchResultPage clickLinkOnTypoBySectionType(MainMenuButtons menuButton) {
        getHelper(SearchResultHelper.class).clickLinkOnTypoBySectionType(menuButton);
        return this;
    }

    public KssSearchResultPage checkTabIsSelected(MainMenuButtons menuButton) {
        getHelper(SearchResultHelper.class).checkTabIsSelected(menuButton);
        return this;
    }

    public KssSearchResultPage checkRubricatorLinkOnTypo() {
        getHelper(SearchResultHelper.class).checkRubricatorLinkOnTypo();
        return this;
    }

    public KssSearchResultPage checkTextInTypo(String message) {
        getHelper(SearchResultHelper.class).checkTextInTypo(message);
        return this;
    }

    public KssSearchResultPage checkDocumentWithTextIsPresent(String documentText) {
        getHelper(SearchResultHelper.class).checkDocumentWithTextIsPresent(documentText);
        return this;
    }

    public KssSearchResultPage checkDocumentWithTextIsNotPresent(String documentText) {
        getHelper(SearchResultHelper.class).checkDocumentWithTextIsNotPresent(documentText);
        return this;
    }

    public KssSearchResultPage checkTypoWasFixed(String typoString, String fixedString) {
        getHelper(SearchResultHelper.class).checkTypoWasFixed(typoString, fixedString);
        return this;
    }

    public KssSearchResultPage checkShowRelevanceLinkIsPresent() {
        getHelper(SearchResultHelper.class).checkShowRelevanceLinkIsPresent();
        return this;
    }

    public KssSearchResultPage checkShowRelevanceLinkIsAbsent() {
        getHelper(SearchResultHelper.class).checkShowRelevanceLinkIsAbsent();
        return this;
    }

    public KssSearchResultPage checkRelevanceIsAbsent() {
        getHelper(SearchResultHelper.class).checkRelevanceIsAbsent();
        return this;
    }

    public KssSearchResultPage checkRelevanceLinkWorks() {
        getHelper(SearchResultHelper.class).checkRelevanceLinkWorks();
        return this;
    }

    public KssSearchResultPage clickSearchButtonOnSearchPage() {
        getHelper(SearchResultHelper.class).clickSearchButtonOnSearchPage();
        return this;
    }

    public KssSearchResultPage clickNotActiveStatus() {
        getHelper(SearchResultHelper.class).clickNotActiveStatus();
        return this;
    }

    public KssSearchResultPage clearSearchBoxOnSearchResultPage() {
        clearSearchBox();
        return this;
    }

    public KssSearchResultPage checkSearchResultType(String type) {
        getHelper(SearchResultHelper.class).checkSearchResultType(type);
        return this;
    }

    public KssSearchResultPage checkSearchQuery(String query) {
        getHelper(SearchResultHelper.class).checkSearchQuery(query);
        return this;
    }

    public KssSearchResultPage checkRegion(String region) {
        getHelper(SearchResultHelper.class).checkRegion(region);
        return this;
    }

    public KssSearchResultPage checkTopicFilter() {
        getHelper(SearchResultHelper.class).checkTopicFilter();
        return this;
    }

    public KssSearchResultPage checkLinksTopicFilter() {
        getHelper(SearchResultHelper.class).checkLinksTopicFilter();
        return this;
    }

    public KssSearchResultPage checkSearchResultItemList() {
        getHelper(SearchResultHelper.class).checkSearchResultItemList();
        return this;
    }


    public KssSearchResultPage checkRelevanceFilterSelectedByName(String filterName) {
        getHelper(SearchResultHelper.class).checkRelevanceFilterSelectedByName(filterName);
        return this;
    }

    public KssSearchResultPage checkSearchInResultCheckBoxIsPresent() {
        getHelper(SearchResultHelper.class).checkSearchInResultCheckBoxIsPresent();
        return this;
    }

    public KssSearchResultPage checkSearchResultOnEducationPageIsNotPresent() {
        checkCurrentItemIsSelected(MainMenuButtons.KSS_SERVICES);
        getHelper(SearchResultHelper.class).checkSearchResultIsNotPresent("В обучении", MainMenuButtons.KSS_SERVICES);
        getHelper(SearchResultHelper.class).checkSectionFilterIsPresent();
        return this;
    }

    public KssSearchResultPage checkSearchResultOnRabotaruPageIsNotPresent() {
        checkCurrentItemIsSelected(MainMenuButtons.RABOTARU);
        getHelper(SearchResultHelper.class).checkSearchResultIsNotPresent("В подборе персонала", MainMenuButtons.RABOTARU);
        getHelper(SearchResultHelper.class).checkSectionFilterIsPresent();
        return this;
    }

    public KssSearchResultPage checkWidgetsFolder() {
        getHelper(SearchResultHelper.class).checkWidgetsFolder();
        return this;
    }

    public KssSearchResultPage checkWidgetCodeDictionary() {
        getHelper(SearchResultHelper.class).checkWidgetCodeDictionary();
        return this;
    }

    public KssSearchResultPage clickWidgetShowMore() {
        getHelper(SearchResultHelper.class).clickWidgetShowMore();
        return this;
    }

    public KssSearchResultPage checkWidgetsFull() {
        getHelper(SearchResultHelper.class).checkWidgetsFull();
        return this;
    }

    public KssSearchResultPage checkWidgetCodesFull() {
        getHelper(SearchResultHelper.class).checkWidgetCodesFull();
        return this;
    }

    public KssSearchResultPage checkWidgetCodesSourceLink() {
        getHelper(SearchResultHelper.class).checkWidgetCodesSourceLink();
        return this;
    }

    public KssSearchResultPage checkWidgetsLinks() {
        getHelper(SearchResultHelper.class).checkWidgetlsLinks();
        return this;
    }

    public KssSearchResultPage checkSearchInResultCheckBoxIsNotPresent() {
        getHelper(SearchResultHelper.class).checkSearchInResultCheckBoxIsNotPresent();
        return this;
    }

    public KssSearchResultPage clickSearchInResultCheckBox() {
        getHelper(SearchResultHelper.class).clickSearchInResultCheckBox();
        return this;
    }

    public KssSearchResultPage checkPresentSearchResultText(String query1, String query2) {
        getHelper(SearchResultHelper.class).checkPresentSearchResultText(query1, query2);
        return this;
    }

    public KssSearchResultPage checkPresentSearchResultText(String query1, String query2, String query3) {
        getHelper(SearchResultHelper.class).checkPresentSearchResultText(query1, query2, query3);
        return this;
    }

    public KssSearchResultPage checkHighlightingRequest() {
        getHelper(SearchResultHelper.class).checkHighlightingRequest();
        return this;
    }

    public KssSearchResultPage clickСourtTag() {
        getHelper(SearchResultHelper.class).clickСourtTag();
        return this;
    }

    public KssSearchResultPage clickDateFilter() {
        getHelper(SearchResultHelper.class).clickDateFilter();
        return this;
    }

    public KssSearchResultPage checkConditionFilter() {
        getHelper(SearchResultHelper.class).checkConditionFilter();
        return this;
    }

    public KssSearchResultPage checkExtendedSearch(String type, String city, String query) {
        getHelper(SearchResultHelper.class).checkExtendedSearch(type, city, query);
        return this;
    }

    public KssSearchResultPage checkPresentFormsDocumentForHour() {
        getHelper(SearchResultHelper.class).checkPresentFormsDocumentForHour();
        return this;
    }

    public KssSearchResultPage checkClickLinkNavigateToLawPage() {
        getHelper(SearchResultHelper.class).clickLinkNavigateToLawPageLink();
        return this;
    }

    public KssSearchResultPage checkInputCorrectlyFormsDocumentForHour() {
        getHelper(SearchResultHelper.class).checkInputCorrectlyFormsDocumentForHour();
        return this;
    }

    public KssSearchResultPage checkNotPresentFormsDocumentHouse() {
        getHelper(SearchResultHelper.class).checkNotPresentFormsDocumentHouse();
        return this;
    }

    public KssSearchResultPage checkDisplaySearchResultsForDetails(String query) {
        getHelper(SearchResultHelper.class).checkDisplaySearchResultsForDetails(query);
        return this;
    }

    public KssSearchResultPage checkDisplayingSelectedTypeFilters(String type) {
        getHelper(SearchResultHelper.class).checkDisplayingSelectedTypeFilters(type);
        return this;
    }

    public KssSearchResultPage checkDisplayingText(boolean isAuthorized) {
        getHelper(SearchResultHelper.class).checkDisplayingText(isAuthorized);
        return this;
    }

    public KssSearchResultPage checkDisplayLawSectionFilter() {
        getHelper(SearchResultHelper.class).checkSectionFilterIsPresent();
        return this;
    }

    public KssSearchResultPage checkDisplayingSelectedRegionFilters(String region) {
        getHelper(SearchResultHelper.class).checkDisplayingSelectedTypeFilters(region);
        return this;
    }

    public KssSearchResultPage checkLinksMagazinFilter() {
        getHelper(SearchResultHelper.class).checkLinksMagazinesFilter();
        return this;
    }

    public KssSearchResultPage checkLinksArchiveFilter() {
        getHelper(SearchResultHelper.class).checkLinksArchiveFilter();
        return this;
    }

    public KssSearchResultPage checkMagazinesFilter() {
        getHelper(SearchResultHelper.class).checkMagazinesFilter();
        return this;
    }

    public KssSearchResultPage checkWidgetLawPresent() {
        getHelper(SearchResultHelper.class).checkWidgetLawPresent();
        return this;
    }

    public KssSearchResultPage checkClickInMainLinkInLawWidget() {
        getHelper(SearchResultHelper.class).checkClickInMainLinkInLawWidget();
        return this;
    }

    public KssSearchResultPage checkLinksWidgetLawPage() {
        getHelper(SearchResultHelper.class).checkLinksWidgetLawPage();
        return this;
    }

    public KssSearchResultPage checkWidgetFormsPresent() {
        getHelper(SearchResultHelper.class).checkWidgetFormsPresent();
        return this;
    }

    public KssSearchResultPage checkClickInMainLinkInFormsWidget() {
        getHelper(SearchResultHelper.class).checkClickInMainLinkInFormsWidget();
        return this;
    }

    public KssSearchResultPage checkLinksWidgetForms() {
        getHelper(SearchResultHelper.class).checkLinksWidgetForms();
        return this;
    }

    public KssSearchResultPage checkWidgetDictionaryPresent() {
        getHelper(SearchResultHelper.class).checkWidgetDictionaryPresent();
        return this;
    }

    public KssSearchResultPage checkClickInMainLinkInDictionaryWidget() {
        getHelper(SearchResultHelper.class).checkClickInMainLinkInWidget(".widget-handbook", MainMenuButtons.DICTIONARY);
        return this;
    }

    public KssSearchResultPage checkLinksWidgetDictionary() {
        getHelper(SearchResultHelper.class).checkLinksWidgetDictionary();
        return this;
    }

    public KssSearchResultPage checkWidgetMagazinesPresent() {
        getHelper(SearchResultHelper.class).checkMagazinesWidget("В журналах и книгах");
        return this;
    }

    public KssSearchResultPage checkClickInMainLinkInMagazinesWidget() {
        getHelper(SearchResultHelper.class).checkClickInMainLinkInWidget(".widget-press", MainMenuButtons.MAGAZINES_AND_BOOKS);
        return this;
    }

    public KssSearchResultPage checkLinksWidgetMagazines() {
        getHelper(SearchResultHelper.class).checkLinksInWidget(".widget-press");
        return this;
    }

    public KssSearchResultPage checkWidgetVideoPresent() {
        getHelper(SearchResultHelper.class).checkVideoWidget("Видео");
        return this;
    }

    public KssSearchResultPage checkClickInMainLinkInWidgetVideo() {
        getHelper(SearchResultHelper.class).checkClickInMainLinkInWidget(".widget-videos", MainMenuButtons.VIDEO);
        return this;
    }

    public KssSearchResultPage checkLinksWidgetVideo() {
        getHelper(SearchResultHelper.class).checkLinksInWidget(".widget-videos");
        return this;
    }

    public KssSearchResultPage checkSectionFilterIsPresent() {
        getHelper(SearchResultHelper.class).checkSectionFilterIsPresent();
        return this;
    }

    public KssSearchResultPage checkLinksSectionFilter() {
        getHelper(SearchResultHelper.class).checkLinksSectionFilter();
        return this;
    }

    public KssSearchResultPage checkStatusFilter() {
        getHelper(SearchResultHelper.class).checkStatusFilter();
        return this;
    }

    public KssSearchResultPage checkStatusFilterIsPresent() {
        getHelper(SearchResultHelper.class).checkStatusFilterIsPresent();
        return this;
    }

    public KssSearchResultPage checkRubricatorButtonIsPresent() {
        getHelper(SearchResultHelper.class).checkRubricatorButtonsIsPresent();
        return this;
    }

    public KssSearchResultPage checkRubricatorFavoritesButtonIsPresent() {
        getHelper(SearchResultHelper.class).checkRubricatorFavoritesButtonIsPresent();
        return this;
    }

    public KssSearchResultPage checkLinksStatusFilter() {
        getHelper(SearchResultHelper.class).checkExpiredLinksStatusFilter();
        getHelper(SearchResultHelper.class).checkActualLinksStatusFilter();
        getHelper(SearchResultHelper.class).checkActualInFutureLinksStatusFilter();
        getHelper(SearchResultHelper.class).checkUnknownLinksStatusFilter();
        return this;
    }

    public KssSearchResultPage checkDateFilter() {
        getHelper(SearchResultHelper.class).checkDateFilter();
        return this;
    }

    public KssSearchResultPage checkSearchResultsDateFilter() {
        getHelper(SearchResultHelper.class).checkSearchResultsDateFilter();
        return this;
    }

    public KssSearchResultPage clickDateSortedFilter() {
        getHelper(SearchResultHelper.class).clickDateSortedFilter();
        return this;
    }

    public KssSearchResultPage clickRelevanceSortedFilter() {
        getHelper(SearchResultHelper.class).clickRelevanceSortedFilter();
        return this;
    }

    public KssSearchResultPage checkRelevanceFilter() {
        getHelper(SearchResultHelper.class).checkRelevanceFilter();
        return this;
    }

    public KssSearchResultPage checkRegionFilter(boolean isDefault) {
        getHelper(SearchResultHelper.class).checkRegionFilter(isDefault);
        return this;
    }

    public KssSearchResultPage checkRegionFilter(boolean isDefault, String region) {
        getHelper(SearchResultHelper.class).checkRegionFilter(isDefault, region);
        return this;
    }

    public KssSearchResultPage checkRegionInSearchHeader(String partRegionName, int regionId) {
        getHelper(SearchResultHelper.class).checkRegionInSearchHeader(partRegionName, regionId);
        return this;
    }

    public KssSearchResultPage checkRegionFilterInSearchExtendedStringIsNotPresent() {
        getHelper(SearchResultHelper.class).checkRegionFilterInSearchExtendedStringIsNotPresent();
        return this;
    }

    public KssSearchResultPage checkRegionFilterInSearchExtendedStringIsPresent() {
        getHelper(SearchResultHelper.class).checkRegionFilterInSearchExtendedStringIsPresent();
        return this;
    }

    public KssSearchResultPage chooseSecondRegionFilter() {
        getHelper(SearchResultHelper.class).clickSecondRegionFilter();
        return this;
    }

    public KssSearchResultPage checkRegionFilterIsPresent() {
        getHelper(SearchResultHelper.class).checkRegionFilterIsPresent();
        return this;
    }

    public KssSearchResultPage checkMoscowRegionFilter() {
        getHelper(SearchResultHelper.class).checkMoscowRegionFilter();
        return this;
    }

    public KssSearchResultPage checkAllRegionFilter() {
        getHelper(SearchResultHelper.class).checkAllRegionFilter();
        return this;
    }

    public KssSearchResultPage clickInLawPracticeLinkFilter() {
        getHelper(SearchResultHelper.class).clickInLawPracticeLinkFilter();
        return this;
    }

    public KssSearchResultPage clickInLawPracticeLinkFilterAndDoNotWaitingSearchResult() {
        getHelper(SearchResultHelper.class).clickInLawPracticeLinkFilterAndDoNotWaitSearchResult();
        return this;
    }

    public KssSearchResultPage clickInLawLinkFilter() {
        getHelper(SearchResultHelper.class).clickInLawLinkFilter();
        return this;
    }

    public KssSearchResultPage checkInLawAndInPracticeFilterIsPresent() {
        getHelper(SearchResultHelper.class).checkInLawAndInPracticeFilterIsPresent();
        return this;
    }

    public KssSearchResultPage checkSearchResultOnLawPracticePageIsNotPresent() {
        getHelper(SearchResultHelper.class).checkSearchResultOnLawPracticePageIsNotPresent();
        return this;
    }

    public KssSearchResultPage checkSearchInResultCheckboxIsNoSelected() {
        getHelper(SearchResultHelper.class).checkSearchInResultCheckboxIsNoSelected();
        return this;
    }

    public KssSearchResultPage clickTypeDocumentFilter(String filterName) {
        getHelper(SearchResultHelper.class).clickTypeDocumentFilter(filterName);
        return this;
    }

    public KssSearchResultPage checkSortedFilter(String filterName){
        getHelper(SearchResultHelper.class).checkSortedFilter(filterName);
        return this;
    }

    public KssSearchResultPage checkSortingFilterIsPresent(){
        getHelper(SearchResultHelper.class).checkSortingFilter();
        return this;
    }

    public KssSearchResultPage checkTypeDocumentFilter(String filterName){
        getHelper(SearchResultHelper.class).checkTypeDocumentFilter(filterName);
        return this;
    }

    public KssSearchResultPage checkTypeDocumentFilters(){
        getHelper(SearchResultHelper.class).checkTypeDocumentFilters();
        return this;
    }

    public KssSearchResultPage checkDepartmentFilter() {
        getHelper(SearchResultHelper.class).checkDepartmentFilter();
        return this;
    }

    public KssSearchResultPage checkTypeDocumentFilterIsPresent(){
        getHelper(SearchResultHelper.class).checkTypeDocumentFilterIsPresent();
        return this;
    }

    public KssSearchResultPage checkLinksTypeDocumentFilter(){
        getHelper(SearchResultHelper.class).checkLinksTypeDocumentFilter();
        return this;
    }

    public KssSearchResultPage checkStatusFilter(String filterName){
        getHelper(SearchResultHelper.class).checkStatusFilter(filterName);
        return this;
    }

    public KssSearchResultPage checkSearchTitle(String expectedTitle){
        getHelper(SearchResultHelper.class).checkSearchTitle(expectedTitle);
        return this;
    }

    public KssSearchResultPage checkExtendedSearchString(String expectedString){
        getHelper(SearchResultHelper.class).checkExtendedSearchString(expectedString);
        return this;
    }

    public KssSearchResultPage checkExtendedSearchStringContains(String expectedString){
        getHelper(SearchResultHelper.class).checkExtendedSearchStringContains(expectedString);
        return this;
    }

    public KssSearchResultPage checkSearchResultsHeadersContainDocumentNumber(String expectedString){
        getHelper(SearchResultHelper.class).checkSearchResultsHeadersContainDocumentNumber(expectedString);
        return this;
    }

    public KssSearchResultPage checkSectionFilter(MainMenuButtons mainMenuButton) {
        getHelper(SearchResultHelper.class).checkSectionFilter(mainMenuButton);
        return this;
    }

    public KssSearchResultPage checkLawPracticeFilter() {
        getHelper(SearchResultHelper.class).checkLawPracticeFilter();
        return this;
    }

    public KssSearchResultPage inputNameInDocumentForHourForm(String name) {
        getHelper(SearchResultHelper.class).inputNameInDocumentForHourForm(name);
        return this;
    }

    public KssSearchResultPage inputEmailInDocumentForHourForm(String email) {
        getHelper(SearchResultHelper.class).inputEmailInDocumentForHourForm(email);
        return this;
    }

    public KssSearchResultPage inputCommentInDocumentForHourForm(String comment) {
        getHelper(SearchResultHelper.class).inputCommentInDocumentForHourForm(comment);
        return this;
    }

    public KssSearchResultPage checkNameErrorInDocumentForHourForm(String expectedText) {
        getHelper(SearchResultHelper.class).checkNameErrorInDocumentForHourForm(expectedText);
        return this;
    }

    public KssSearchResultPage checkEmailErrorInDocumentForHourForm(String error) {
        getHelper(SearchResultHelper.class).checkEmailErrorInDocumentForHourForm(error);
        return this;
    }

    public KssSearchResultPage clickSendButtonInDocumentForHourForm() {
        getHelper(SearchResultHelper.class).clickSendButtonInDocumentForHourForm();
        return this;
    }

    public KssLawBasePage clickLinkNavigateToLawPageLink() {
        getHelper(SearchResultHelper.class).clickLinkNavigateToLawPageLink();
        return redirectTo(KssLawBasePage.class);
    }

    public KssSearchResultPage checkTypoBlockIsPresent() {
        getHelper(SearchResultHelper.class).checkTypoBlockIsPresent();
        return this;
    }

    public KssSearchResultPage checkLawSearchWidgetIsNotPresent() {
        getHelper(SearchResultHelper.class).checkLawSearchWidgetIsNotPresent();
        return this;
    }

    public KssSearchResultPage checkLawSearchWidgetIsPresent() {
        getHelper(SearchResultHelper.class).checkLawSearchWidgetIsPresent();
        return this;
    }

    public KssSearchResultPage checkLawSearchWidgetIsNotEmpty() {
        getHelper(SearchResultHelper.class).checkLawSearchWidgetIsNotEmpty();
        return this;
    }

    public KssSearchResultPage checkFormsSearchWidgetIsNotPresent() {
        getHelper(SearchResultHelper.class).checkFormsSearchWidgetIsNotPresent();
        return this;
    }

    public KssSearchResultPage checkFormsSearchWidgetIsPresent() {
        getHelper(SearchResultHelper.class).checkFormsSearchWidgetIsPresent();
        return this;
    }

    public KssSearchResultPage checkFormsSearchWidgetIsNotEmpty() {
        getHelper(SearchResultHelper.class).checkFormsSearchWidgetIsNotEmpty();
        return this;
    }

    public KssSearchResultPage checkMagazinesSearchWidgetIsNotPresent() {
        getHelper(SearchResultHelper.class).checkMagazinesSearchWidgetIsNotPresent();
        return this;
    }

    public KssSearchResultPage checkMagazinesSearchWidgetIsPresent() {
        getHelper(SearchResultHelper.class).checkMagazinesSearchWidgetIsPresent();
        return this;
    }

    public KssSearchResultPage checkMagazinesSearchWidgetIsNotEmpty() {
        getHelper(SearchResultHelper.class).checkMagazinesSearchWidgetIsNotEmpty();
        return this;
    }

    public KssSearchResultPage checkVideoSearchWidgetIsNotPresent() {
        getHelper(SearchResultHelper.class).checkVideoSearchWidgetIsNotPresent();
        return this;
    }

    public KssSearchResultPage checkVideoSearchWidgetIsPresent() {
        getHelper(SearchResultHelper.class).checkVideoSearchWidgetIsPresent();
        return this;
    }

    public KssSearchResultPage checkVideoSearchWidgetIsNotEmpty() {
        getHelper(SearchResultHelper.class).checkVideoSearchWidgetIsNotEmpty();
        return this;
    }

    public KssSearchResultPage checkDictionarySearchWidgetIsNotPresent() {
        getHelper(SearchResultHelper.class).checkDictionarySearchWidgetIsNotPresent();
        return this;
    }

    public KssSearchResultPage checkDictionarySearchWidgetIsPresent() {
        getHelper(SearchResultHelper.class).checkDictionarySearchWidgetIsPresent();
        return this;
    }

    public KssSearchResultPage checkSearchErrorIsNotPresent(){
        getHelper(SearchResultHelper.class).checkSearchErrorIsNotPresent();
        return this;
    }

    public KssSearchResultPage checkDictionarySearchWidgetIsNotEmpty() {
        getHelper(SearchResultHelper.class).checkDictionarySearchWidgetIsNotEmpty();
        return this;
    }

    public KssSearchResultPage checkKodySearchWidgetIsNotPresent() {
        getHelper(SearchResultHelper.class).checkKodySearchWidgetIsNotPresent();
        return this;
    }

    public KssSearchResultPage checkKodySearchWidgetIsPresent() {
        getHelper(SearchResultHelper.class).checkKodySearchWidgetIsPresent();
        return this;
    }

    public KssSearchResultPage checkKodySearchWidgetIsNotEmpty() {
        getHelper(SearchResultHelper.class).checkKodySearchWidgetIsNotEmpty();
        return this;
    }

    public KssSearchResultPage clickActualStatusInFilter() {
        getHelper(SearchResultHelper.class).clickActualStatusInFilter();
        return this;
    }

    public KssSearchResultPage clickFormsFilter() {
        getHelper(SearchResultHelper.class).clickFormsFilter();
        return this;
    }

    public KssSearchResultPage mouseHoverSecondItemFormWidget() {
        getHelper(SearchResultHelper.class).mouseHoverSecondItemFormWidget();
        return this;
    }

    public KssSearchResultPage checkSecondItemFormWidgetIsGreen() {
        getHelper(SearchResultHelper.class).checkSecondItemFormWidgetIsGreen();
        return this;
    }

    public KssSearchResultPage checkSearchResultHasStrongText() {
        getHelper(SearchResultHelper.class).checkSearchResultHasStrongText();
        return this;
    }

    public KssSearchResultPage checkSearchResultHasNOTStrongText() {
        getHelper(SearchResultHelper.class).checkSearchResultHasNOTStrongText();
        return this;
    }

    public KssSearchResultPage checkDocumentsInLawPracticePageAreSortedDescending() {
        getHelper(SearchResultHelper.class).checkDocumentsInLawPracticePageAreSortedDescending();
        return this;
    }

    public KssSearchResultPage clickOnButtonSearchOnExtendedForm() {
        getHelper(SearchResultHelper.class).clickOnButtonSearchOnExtendedForm();
        return redirectTo(KssSearchResultPage.class);
    }

    public KssSearchResultPage checkExtendedSearchRemoveAllFilters() {
        getHelper(SearchResultHelper.class).checkExtendedSearchRemoveAllFilters();
        return this;
    }

    public KssSearchResultPage checkMainLawBasePageIsOpened() {
        getHelper(SearchResultHelper.class).checkMainLawBasePageIsOpened();
        return this;
    }

    public KssSearchResultPage checkStatusFilterIsNotPresent() {
        getHelper(SearchResultHelper.class).checkStatusFilterIsNotPresent();
        return this;
    }

    public KssSearchResultPage checkJudicialActsFilter() {
        getHelper(SearchResultHelper.class).checkJudicialActsFilter();
        return this;
    }

    public KssSearchResultPage checkLinksJudicialActsFilter() {
        getHelper(SearchResultHelper.class).checkLinksJudicialActsFilter();
        return this;
    }

    public KssDocumentPage clickRandomDocument() {
        getHelper(SearchResultHelper.class).clickRandomDocument();
        return redirectTo(KssDocumentPage.class);
    }


    @Step("Проверить работу подсказок, нажать на подсказку с примечанием")
    public KssSearchResultPage checkSearchAdviceListByDocumentsCountOnExtendedSearchForm() {
        checkExtendedSearchStringContains(getHelper(ExtendedSearchForm.class, this)
                .clickOnSearchAdviceListHintWithCountOfDocumentsFound());
        return this;
    }

    @Step("Проверить подсказку с примечанием название документа, документ должен быть из модулей:81,97,99")
    public KssSearchResultPage checkSearchAdviceListByDocumentNameOnExtendedSearchFormLawBase() {
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
    public KssSearchResultPage checkSearchAdviceListByDocumentNameOnExtendedSearchFormLawPractice() {
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
    public KssSearchResultPage checkSearchAdviceListNavigation() {
        String currentUrl = getCurrentUrl();
        getHelper(ExtendedSearchForm.class, this).checkNavigationByHintsWithKeysDownAndUp();
        postponedAssertNotEquals(currentUrl, getCurrentUrl(), "После нажатия на кнопку Enter в навигации по номерам " +
                "документов ничего не произошло. URL не поменялся");
        return this;
    }

    public KssSearchResultPage checkSearchResultsForExpersHasDifferentAbbr() {
        getHelper(SearchResultHelper.class).checkSearchResultsForExpersHasDifferentAbbr();
        return this;
    }

    public KssSearchResultPage checkSearchResultsForExpersHasOneAbbr() {
        getHelper(SearchResultHelper.class).checkSearchResultsForExpersHasOneAbbr();
        return this;
    }

    public KssSearchResultPage checkSearchResultsDateFilterFrom(String date) {
        getHelper(SearchResultHelper.class).checkSearchResultsDateFilterFrom(date);
        return this;
    }

    public KssSearchResultPage checkSearchResultsDateFilterTo(String date) {
        getHelper(SearchResultHelper.class).checkSearchResultsDateFilterTo(date);
        return this;
    }

    public KssSearchResultPage checkSearchResultsDateFilterBetween(String dateFrom, String dateTo) {
        getHelper(SearchResultHelper.class).checkSearchResultsDateFilterBetween(dateFrom, dateTo);
        return this;
    }

    public KssSearchResultPage checkSearchResultsContainLinksOnDocuments() {
        getHelper(SearchResultHelper.class).checkSearchResultsContainLinksOnDocuments();
        return this;
    }

    public KssSearchResultPage checkSearchResultsDocumentsContainBriefTextUnderTheLinks() {
        getHelper(SearchResultHelper.class).checkSearchResultsDocumentsContainBriefTextUnderTheLinks();
        return this;
    }

    public KssSearchResultPage checkSearchResultsExtendedStringIsPresent() {
        getHelper(SearchResultHelper.class).checkSearchResultsExtendedStringIsPresent();
        return this;
    }

    public KssSearchResultPage checkSearchResultAnswersItemIsActivated() {
        getHelper(SearchResultHelper.class).checkSearchResultAnswersItemIsActivated();
        return this;
    }

    @Step("Проверяется, что Отображаются поисковые темы по фильтрам")
    public KssSearchResultPage checkSearchResultTypeFilterByThemesIsPresent() {
        String[] typeFilterNames = {"Все темы", "Кадровое дело", "Трудовые споры"};
        String[] typeFilterNamesVIP = {"Все темы", "Кадровое дело", "Управление персоналом", "Трудовые споры"};
        WebElement typeFilter = findElementByNoThrow(By.cssSelector(".menu [data-filtr-name='tags']"));
        postponedAssertTrue(typeFilter != null && typeFilter.isDisplayed(), "Поисковые фильтры по темам не отображены");
        if (typeFilter != null) {
            List<WebElement> filters = typeFilter.findElements(By.cssSelector("li a"));
            boolean isVip = false;
            if (getCurrentUrl().contains("vip.")) {
                isVip = true;
            }
            String[] arrFilters = isVip == true ? typeFilterNamesVIP : typeFilterNames;
            postponedAssertEquals(filters.size(), arrFilters.length, "Количество тем по фильтрам не " +
                    "соответствует с ожидаемым количеством");
            int i = 0;
            for (WebElement filter: filters) {
                postponedAssertEqualsText(filter, arrFilters[i]);
                i++;
            }
        }
        return this;
    }

}

