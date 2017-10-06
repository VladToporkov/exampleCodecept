package com.actionmedia.pages.gf;

import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.helpers.SearchResultHelper;
import com.actionmedia.pages.interfaces.ISearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

/**
 * Created by Pavel on 28/03/16.
 */
@Component
public class GfSearchResultPage extends GFBasePage<GfSearchResultPage> implements ISearchResultPage {

    public GfSearchResultPage checkSearchResultOnLawBasePageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.LAW_BASE);
        getHelper(SearchResultHelper.class).checkSearchResultOnLawBasePageIsOpened();
        return this;
    }

    public GfSearchResultPage checkSearchResultOnFormsPageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.FORMS);
        getHelper(SearchResultHelper.class).checkSearchResultOnFormsPageIsOpened();
        return this;
    }

    public GfSearchResultPage checkSearchResultOnRecomendPageIsOpened() {
        getHelper(SearchResultHelper.class).checkSearchResultOnRecomendPageIsOpened();
        return this;
    }

    public GfSearchResultPage checkSearchResultsContainLinksOnDocuments() {
        getHelper(SearchResultHelper.class).checkSearchResultsContainLinksOnDocuments();
        return this;
    }

    public GfSearchResultPage checkSearchResultsDocumentsContainBriefTextUnderTheLinks() {
        getHelper(SearchResultHelper.class).checkSearchResultsDocumentsContainBriefTextUnderTheLinks();
        return this;
    }

    public GfSearchResultPage checkSearchResultsExtendedStringIsPresent() {
        getHelper(SearchResultHelper.class).checkSearchResultsExtendedStringIsPresent();
        return this;
    }

    public GfSearchResultPage checkSearchResultRecomendationItemIsActivated() {
        getHelper(SearchResultHelper.class).checkSearchResultRecomendationItemIsActivated();
        return this;
    }

    @Step("Проверяется, что Отображаются поисковые темы по фильтрам")
    public GfSearchResultPage checkSearchResultTypeFilterByThemesIsPresent() {
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

    public GfSearchResultPage checkSearchTitle(String expectedTitle) {
        getHelper(SearchResultHelper.class).checkSearchTitle(expectedTitle);
        return this;
    }

    public GfSearchResultPage checkSearchResultHasStrongText() {
        getHelper(SearchResultHelper.class).checkSearchResultHasStrongText();
        return this;
    }

    public GfSearchResultPage checkSectionFilterIsPresent() {
        getHelper(SearchResultHelper.class).checkSectionFilterIsPresent();
        return this;
    }

    @Step("Нажать кнопку и перейти на страницу результатов поиска")
    public GfSearchResultPage clickSearchButtonAndNavigateToSearchResultPage() {
        clickSearchButton();
        return redirectTo(GfSearchResultPage.class);
    }

}
