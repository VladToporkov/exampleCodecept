package com.actionmedia.pages.edu;

import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.helpers.SearchResultHelper;
import com.actionmedia.pages.interfaces.ISearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

/**
 * Created by Pavel on 18/04/16.
 */
@Component
public class EduSearchResultPage extends EduBasePage<EduSearchResultPage> implements ISearchResultPage {

    @Override
    public EduSearchResultPage checkSearchResultOnLawBasePageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.LAW_BASE);
        getHelper(SearchResultHelper.class).checkSearchResultOnLawBasePageIsOpened();
        return this;
    }

    @Override
    public EduSearchResultPage checkSearchResultOnFormsPageIsOpened() {
        checkCurrentItemIsSelected(MainMenuButtons.TEMPLATES);
        getHelper(SearchResultHelper.class).checkSearchResultOnTemplatesPageIsOpened();
        return this;
    }

    public EduSearchResultPage checkSectionFilterIsPresent() {
        getHelper(SearchResultHelper.class).checkSectionFilterIsPresent();
        return this;
    }

    public EduSearchResultPage checkSearchResultHasStrongText() {
        getHelper(SearchResultHelper.class).checkSearchResultHasStrongText();
        return this;
    }

    public EduSearchResultPage checkSearchFiltersArePresent() {
        getHelper(SearchResultHelper.class).checkBranchFilterIsPresent();
        return this;
    }

    public EduSearchResultPage checkSearchResultOnRecomendPageIsOpened() {
        getHelper(SearchResultHelper.class).checkSearchResultOnRecomendPageIsOpened();
        return this;
    }

    public EduSearchResultPage checkSearchResultsContainLinksOnDocuments() {
        getHelper(SearchResultHelper.class).checkSearchResultsContainLinksOnDocuments();
        return this;
    }

    public EduSearchResultPage checkSearchResultsDocumentsContainBriefTextUnderTheLinks() {
        getHelper(SearchResultHelper.class).checkSearchResultsDocumentsContainBriefTextUnderTheLinks();
        return this;
    }

    public EduSearchResultPage checkSearchResultsExtendedStringIsPresent() {
        getHelper(SearchResultHelper.class).checkSearchResultsExtendedStringIsPresent();
        return this;
    }

    public EduSearchResultPage checkSearchResultRecomendationItemIsActivated() {
        getHelper(SearchResultHelper.class).checkSearchResultRecomendationItemIsActivated();
        return this;
    }

    @Step("Проверяется, что Отображаются поисковые темы по НКО")
    public EduSearchResultPage checkSearchResultTypeFilterByNKOIsPresent() {
        String[] typeFilterNames = {"Все НКО", "Автономные", "Бюджетные", "Казенные", "Частные"};
        WebElement typeFilter = findElementByNoThrow(By.cssSelector(".menu [data-filtr-name='tags'][data-current-filtr-state='1060']"));
        postponedAssertTrue(typeFilter != null && typeFilter.isDisplayed(), "Поисковые фильтры по НКО не отображены");
        if (typeFilter != null) {
            List<WebElement> filters = typeFilter.findElements(By.cssSelector("li a"));
            postponedAssertEquals(filters.size(), typeFilterNames.length, "Количество НКО по фильтрам не " +
                    "соовтетствут с ожидаемым количеством");
            int i = 0;
            for (WebElement filter: filters) {
                postponedAssertEqualsText(filter, typeFilterNames[i]);
                i++;
            }
        }
        return this;
    }

    @Step("Проверяется, что Отображаются поисковые темы по НКО")
    public EduSearchResultPage checkSearchResultTypeFilterByOrganizationsIsPresent() {
        String[] typeFilterNames = {"Все организации", "Детские сады", "Школы", "Образовательные центры"};
        WebElement typeFilter = findElementByNoThrow(By.cssSelector(".menu [data-filtr-name='tags'][data-current-filtr-state='1080']"));
        postponedAssertTrue(typeFilter != null && typeFilter.isDisplayed(), "Поисковые фильтры по организациям не отображены");
        if (typeFilter != null) {
            List<WebElement> filters = typeFilter.findElements(By.cssSelector("li a"));
            postponedAssertEquals(filters.size(), typeFilterNames.length, "Количество организаций по фильтрам не " +
                    "соовтетствут с ожидаемым количеством");
            int i = 0;
            for (WebElement filter: filters) {
                postponedAssertEqualsText(filter, typeFilterNames[i]);
                i++;
            }
        }
        return this;
    }

    public EduSearchResultPage checkSearchTitle(String expectedTitle) {
        getHelper(SearchResultHelper.class).checkSearchTitle(expectedTitle);
        return this;
    }

    @Step("Нажать кнопку и перейти на страницу результатов поиска")
    public EduSearchResultPage clickSearchButtonAndNavigateToSearchResultPage() {
        clickSearchButton();
        return redirectTo(EduSearchResultPage.class);
    }

}
