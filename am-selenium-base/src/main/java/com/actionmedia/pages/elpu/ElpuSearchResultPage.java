package com.actionmedia.pages.elpu;

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
public class ElpuSearchResultPage extends ElpuBasePage<ElpuSearchResultPage> implements ISearchResultPage {
    @Override
    public ElpuSearchResultPage checkSearchResultOnLawBasePageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.LAW_BASE);
        getHelper(SearchResultHelper.class).checkSearchResultOnLawBasePageIsOpened();
        return this;
    }

    @Override
    public ElpuSearchResultPage checkSearchResultOnFormsPageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.FORMS);
        getHelper(SearchResultHelper.class).checkSearchResultOnFormsPageIsOpened();
        return this;
    }

    public ElpuSearchResultPage checkSearchResultOnRecomendPageIsOpened() {
        getHelper(SearchResultHelper.class).checkSearchResultOnRecomendPageIsOpened();
        return this;
    }

    public ElpuSearchResultPage checkSearchResultsContainLinksOnDocuments() {
        getHelper(SearchResultHelper.class).checkSearchResultsContainLinksOnDocuments();
        return this;
    }

    public ElpuSearchResultPage checkSearchResultsDocumentsContainBriefTextUnderTheLinks() {
        getHelper(SearchResultHelper.class).checkSearchResultsDocumentsContainBriefTextUnderTheLinks();
        return this;
    }

    public ElpuSearchResultPage checkSearchResultsExtendedStringIsPresent() {
        getHelper(SearchResultHelper.class).checkSearchResultsExtendedStringIsPresent();
        return this;
    }

    public ElpuSearchResultPage checkSearchResultRecomendationItemIsActivated() {
        getHelper(SearchResultHelper.class).checkSearchResultRecomendationItemIsActivated();
        return this;
    }

    @Step("Проверяется, что Отображаются поисковые темы по Источникам финансирования")
    public ElpuSearchResultPage checkSearchResultTypeFilterByRecomendationsIsPresent() {
        String[] typeFilterNames = {"Все источники финансирования", "ОМС", "Бюджет", "Приносящая доход деятельность"};
        WebElement typeFilter = findElementByNoThrow(By.cssSelector(".menu [data-filtr-name='tags'][data-current-filtr-state='1150']"));
        postponedAssertTrue(typeFilter != null && typeFilter.isDisplayed(), "Поисковые фильтры по Источникам финансирования не отображены");
        if (typeFilter != null) {
            List<WebElement> filters = typeFilter.findElements(By.cssSelector("li a"));
            postponedAssertEquals(filters.size(), typeFilterNames.length, "Количество Источникам финансирования по фильтрам не " +
                    "соовтетствут с ожидаемым количеством");
            int i = 0;
            for (WebElement filter : filters) {
                postponedAssertEqualsText(filter, typeFilterNames[i]);
                i++;
            }
        }
        return this;
    }

    public ElpuSearchResultPage checkSearchTitle(String expectedTitle) {
        getHelper(SearchResultHelper.class).checkSearchTitle(expectedTitle);
        return this;
    }

    public ElpuSearchResultPage checkSearchResultHasStrongText() {
        getHelper(SearchResultHelper.class).checkSearchResultHasStrongText();
        return this;
    }

    public ElpuSearchResultPage checkSectionFilterIsPresent() {
        getHelper(SearchResultHelper.class).checkSectionFilterIsPresent();
        return this;
    }

    @Step("Нажать кнопку и перейти на страницу результатов поиска")
    public ElpuSearchResultPage clickSearchButtonAndNavigateToSearchResultPage() {
        clickSearchButton();
        return redirectTo(ElpuSearchResultPage.class);
    }
}