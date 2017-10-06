package com.actionmedia.pages.gf;

import com.actionmedia.pages.helpers.LawBasePageHelper;
import com.actionmedia.components.widgets.SearchWidgetBlock;
import com.actionmedia.components.widgets.Widget;
import com.actionmedia.components.widgets.lawbase.BudgetWidget;
import com.actionmedia.components.widgets.lawbase.PopularWidget;
import com.actionmedia.components.widgets.lawbase.TaxWidget;
import com.actionmedia.pages.helpers.SearchResultHelper;
import com.actionmedia.pages.interfaces.ILawBasePage;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Pavel on 28/03/16.
 */
@Component
public class GfLawBasePage extends GFBasePage<GfLawBasePage> implements ILawBasePage {

    public GfLawBasePage checkMainLawBasePageIsOpened() {
        getHelper(SearchResultHelper.class).checkMainLawBasePageIsOpened();
        return this;
    }

    @Step("Проверяется что заголовок раздела отображается")
    public GfLawBasePage checkSectionTitleIsPresent() {
        getHelper(LawBasePageHelper.class).checkSectionTitleIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Бюджетный кодекс' отображается")
    public GfLawBasePage checkBudgetKodeksBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkBudgetKodeksBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Налоговый кодекс' отображается")
    public GfLawBasePage checkTaxKodeksBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkTaxKodeksBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Прочие кодексы' отображается")
    public GfLawBasePage checkOtherKodeksBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkOtherKodeksBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Важное' отображается")
    public GfLawBasePage checkLegislationBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkLegislationBlockIsPresent("Важные документы");
        return this;
    }

    @Step("Проверяется что блок 'Судебные решения' отображается")
    public GfLawBasePage checkJudgmentBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkJudgmentBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'В регионе' отображается")
    public GfLawBasePage checkRegionBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkRegionBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Главные документы' отображается")
    public GfLawBasePage checkMainDocsBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkMainDocsBlockIsPresent();
        return this;
    }

    @Step("Проверяется кнопка рубрикатора кодексов на странице 'Правовая База'")
    public GfLawBasePage checkAllKodeksBudgetRubricatorButtonIsPresent() {
        getHelper(LawBasePageHelper.class).checkAllKodexRubricatorButtonIsPresent();
        return this;
    }

    public GfLawBasePage checkBudgetWidgetIsPresent() {
        WebElement widget = getHelper(BudgetWidget.class).getWidget();
        getHelper(BudgetWidget.class).checkWidgetIsPresent(widget, "Бюджетный");
        return this;
    }

    public GfLawBasePage checkBudgetWidgetTitleIsPresent() {
        WebElement widget = getHelper(BudgetWidget.class).getWidget();
        getHelper(BudgetWidget.class).checkTitleIsLink(widget);
        return this;
    }

    public GfLawBasePage checkBudgetWidgetLinksArePresent() {
        WebElement widget = getHelper(BudgetWidget.class).getWidget();
        getHelper(BudgetWidget.class).checkLinksArePresent(widget);
        return this;
    }

    public GfLawBasePage checkBudgetWidgetBlockResized() {
        WebElement widget = getHelper(BudgetWidget.class).getWidget();
        getHelper(BudgetWidget.class).checkBlockSizeIsChanged(widget);
        return this;
    }

    public GfLawBasePage checkBudgetWidgetHasEightLinks() {
        getHelper(BudgetWidget.class).checkWidgetHasEightLinks();
        return this;
    }

    public GfLawBasePage checkBudgetWidgetHasSixLinks() {
        getHelper(BudgetWidget.class).checkWidgetHasSixLinks();
        return this;
    }

    public GfLawBasePage checkBudgetWidgetHasTwoLinks() {
        getHelper(BudgetWidget.class).checkWidgetHasFourLinks();
        return this;
    }

    public GfLawBasePage checkBudgetWidgetLinksAreWorked() {
        WebElement widget = getHelper(BudgetWidget.class).getWidget();
        getHelper(BudgetWidget.class).checkLinksAreWorked(widget);
        return this;
    }

    public GfLawBasePage checkSearchBudgetWidgetBlockIsPresent() {
        WebElement widget = getHelper(BudgetWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchWidgetBlockIsPresent(widget);
        return this;
    }

    public GfLawBasePage checkBudgetWidgetSearchInputHasName() {
        WebElement widget = getHelper(BudgetWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchInputHasName(widget, "Поиск статей");
        return this;
    }

    public GfLawBasePage inputBudgetWidgetSearchQuery(String query) {
        WebElement widget = getHelper(BudgetWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).inputText(widget, query);
        return this;
    }

    public GfDocumentPage clickOnBudgetWidgetButtonEnterIntoSearchBox() {
        WebElement widget = getHelper(BudgetWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnButtonEnterIntoSearchBox(widget);
        return redirectTo(GfDocumentPage.class);
    }

    public GfLawBasePage checkBudgetWidgetSearchResultIsVisible() {
        WebElement widget = getHelper(BudgetWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsVisible(widget);
        return this;
    }

    public GfLawBasePage checkBudgetWidgetSearchResultIsNotVisible() {
        WebElement widget = getHelper(BudgetWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsNotVisible(widget);
        return this;
    }

    public GfDocumentPage clickOnBudgetWidgetRandomSearchResult() {
        WebElement widget = getHelper(BudgetWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnRandomSearchResult(widget);
        return redirectTo(GfDocumentPage.class);
    }

    public GfLawBasePage checkTaxWidgetIsPresent() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkWidgetIsPresent(widget, "Налоговый");
        return this;
    }

    public GfLawBasePage checkTaxWidgetTitleIsPresent() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkTitleIsLink(widget);
        return this;
    }

    public GfLawBasePage checkTaxWidgetLinksArePresent() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkLinksArePresent(widget);
        return this;
    }

    public GfLawBasePage checkTaxWidgetBlockResized() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkBlockSizeIsChanged(widget);
        return this;
    }

    public GfLawBasePage checkTaxWidgetBlockIsNotChanged() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkBlockSizeIsNotChanged(widget);
        return this;
    }

    public GfLawBasePage checkTaxWidgetHasSixLinks() {
        getHelper(TaxWidget.class).checkWidgetHasSixLinks();
        return this;
    }

    public GfLawBasePage checkTaxWidgetHasTwoLinks() {
        getHelper(TaxWidget.class).checkWidgetHasTwoLinks();
        return this;
    }

    public GfLawBasePage checkTaxWidgetLinksAreWorked() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkLinksAreWorked(widget);
        return this;
    }

    public GfLawBasePage checkSearchTaxWidgetBlockIsPresent() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchWidgetBlockIsPresent(widget);
        return this;
    }

    public GfLawBasePage checkAllWidgetsDontConflictWithEachOther() {
        getHelper(Widget.class).checkAllWidgetsDontConflictWithEachOther();
        return this;
    }

    public GfLawBasePage checkTaxWidgetSearchInputHasName() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchInputHasName(widget, "Поиск статей");
        return this;
    }

    public GfLawBasePage inputTaxWidgetSearchQuery(String query) {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).inputText(widget, query);
        return this;
    }

    public GfDocumentPage clickOnTaxWidgetButtonEnterIntoSearchBox() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnButtonEnterIntoSearchBox(widget);
        return redirectTo(GfDocumentPage.class);
    }

    public GfLawBasePage checkTaxWidgetSearchResultIsVisible() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsVisible(widget);
        return this;
    }

    public GfLawBasePage checkTaxWidgetSearchResultIsNotVisible() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsNotVisible(widget);
        return this;
    }

    public GfDocumentPage clickOnTaxWidgetRandomSearchResult() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnRandomSearchResult(widget);
        return redirectTo(GfDocumentPage.class);
    }

    public GfLawBasePage checkPopularWidgetIsPresent() {
        WebElement widget = getHelper(PopularWidget.class).getWidget();
        getHelper(PopularWidget.class).checkWidgetIsPresent(widget, "Популярное в");
        return this;
    }

    public GfLawBasePage checkPopularWidgetTitleHasWordPopular() {
        getHelper(PopularWidget.class).checkTitleHasWordPopular();
        return this;
    }

    public GfLawBasePage checkPopularWidgetContainsLinksWithDocuments() {
        getHelper(PopularWidget.class).checkPopularWidgetContainsLinksWithDocuments();
        return this;
    }

    public GfLawBasePage checkPopularWidgetLinkChangeRegionIsDisplayed() {
        getHelper(PopularWidget.class).checkLinkChangeRegionIsDisplayed();
        return this;
    }

    public GfLawBasePage checkPopularWidgetLinkChangeRegionIsNotDisplayed() {
        getHelper(PopularWidget.class).checkLinkChangeRegionIsNotDisplayed();
        return this;
    }

    public GfLawBasePage checkPopularWidgetCheckSearchInputHasName(String name) {
        WebElement widget = getHelper(PopularWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchInputHasName(widget, name);
        return this;
    }
}
