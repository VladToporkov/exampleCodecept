package com.actionmedia.pages.go;

import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.helpers.SearchResultHelper;
import com.actionmedia.pages.interfaces.ISearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

/**
 * Created by Pavel on 13/07/16.
 */
@Component
public class GoSearchResultPage extends GoBasePage<GoSearchResultPage> implements ISearchResultPage {
    @Override
    public GoSearchResultPage checkSearchResultOnLawBasePageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.LAW_BASE);
        getHelper(SearchResultHelper.class).checkSearchResultOnLawBasePageIsOpened();
        return this;
    }

    @Override
    public GoSearchResultPage checkSearchResultOnFormsPageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.TEMPLATES);
        getHelper(SearchResultHelper.class).checkSearchResultOnTemplatesPageIsOpened();
        return this;
    }

    public GoSearchResultPage checkSectionFilterIsPresent() {
        getHelper(SearchResultHelper.class).checkSectionFilterIsPresent();
        return this;
    }

    public GoSearchResultPage checkSearchResultHasStrongText() {
        getHelper(SearchResultHelper.class).checkSearchResultHasStrongText();
        return this;
    }

    public GoSearchResultPage checkSearchFiltersArePresent() {
        getHelper(SearchResultHelper.class).checkBranchFilterIsPresent();
        return this;
    }

    public GoSearchResultPage checkSearchResultOnRecomendPageIsOpened() {
        getHelper(SearchResultHelper.class).checkSearchResultOnRecomendPageIsOpened();
        return this;
    }

    public GoSearchResultPage checkSearchResultsContainLinksOnDocuments() {
        getHelper(SearchResultHelper.class).checkSearchResultsContainLinksOnDocuments();
        return this;
    }

    public GoSearchResultPage checkSearchResultsDocumentsContainBriefTextUnderTheLinks() {
        getHelper(SearchResultHelper.class).checkSearchResultsDocumentsContainBriefTextUnderTheLinks();
        return this;
    }

    public GoSearchResultPage checkSearchResultsExtendedStringIsPresent() {
        getHelper(SearchResultHelper.class).checkSearchResultsExtendedStringIsPresent();
        return this;
    }

    public GoSearchResultPage checkSearchResultRecomendationItemIsActivated() {
        getHelper(SearchResultHelper.class).checkSearchResultRecomendationItemIsActivated();
        return this;
    }

    @Step("Проверяется, что Отображаются поисковые темы по Рекомендациям")
    public GoSearchResultPage checkSearchResultTypeFilterByRecomendationsIsPresent() {
        String[] typeFilterNames = {"Все рекомендации", "44-ФЗ", "223-ФЗ"};
        WebElement typeFilter = findElementByNoThrow(By.cssSelector(".menu [data-filtr-name='tags'][data-current-filtr-state='1120']"));
        postponedAssertTrue(typeFilter != null && typeFilter.isDisplayed(), "Поисковые фильтры по рекомендациям не отображены");
        if (typeFilter != null) {
            List<WebElement> filters = typeFilter.findElements(By.cssSelector("li a"));
            postponedAssertEquals(filters.size(), typeFilterNames.length, "Количество рекомендациям по фильтрам не " +
                    "соовтетствут с ожидаемым количеством");
            int i = 0;
            for (WebElement filter: filters) {
                postponedAssertEqualsText(filter, typeFilterNames[i]);
                i++;
            }
        }
        return this;
    }

    @Step("Проверяется, что Отображаются поисковые темы по практикам")
    public GoSearchResultPage checkSearchResultTypeFilterByJudgesIsPresent() {
        String[] typeFilterNames = {"Все извлечения из практики", "Суды", "ФАС", "Органы финконтроля"};
        WebElement typeFilter = findElementByNoThrow(By.cssSelector(".menu [data-filtr-name='tags'][data-current-filtr-state='1130']"));
        postponedAssertTrue(typeFilter != null && typeFilter.isDisplayed(), "Поисковые фильтры по практикам не отображены");
        if (typeFilter != null) {
            List<WebElement> filters = typeFilter.findElements(By.cssSelector("li a"));
            postponedAssertEquals(filters.size(), typeFilterNames.length, "Количество практик по фильтрам не " +
                    "соовтетствут с ожидаемым количеством");
            int i = 0;
            for (WebElement filter: filters) {
                postponedAssertEqualsText(filter, typeFilterNames[i]);
                i++;
            }
        }
        return this;
    }

    public GoSearchResultPage checkSearchTitle(String expectedTitle) {
        getHelper(SearchResultHelper.class).checkSearchTitle(expectedTitle);
        return this;
    }

    @Step("Нажать кнопку и перейти на страницу результатов поиска")
    public GoSearchResultPage clickSearchButtonAndNavigateToSearchResultPage() {
        clickSearchButton();
        return redirectTo(GoSearchResultPage.class);
    }
}