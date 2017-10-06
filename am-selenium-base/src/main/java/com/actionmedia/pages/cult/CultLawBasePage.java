package com.actionmedia.pages.cult;

import com.actionmedia.components.widgets.SearchWidgetBlock;
import com.actionmedia.components.widgets.Widget;
import com.actionmedia.components.widgets.lawbase.CivilWidget;
import com.actionmedia.components.widgets.lawbase.PopularWidget;
import com.actionmedia.components.widgets.lawbase.TaxWidget;
import com.actionmedia.pages.helpers.LawBasePageHelper;
import com.actionmedia.pages.helpers.SearchResultHelper;
import com.actionmedia.pages.interfaces.ILawBasePage;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Pavel on 24/05/16.
 */
@Component
public class CultLawBasePage extends CultBasePage<CultLawBasePage> implements ILawBasePage {

    @Step("Проверяется что блок 'Гражданский кодекс' отображается")
    public CultLawBasePage checkCivilKodeksBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkCivilKodeksBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Прочие кодексы' отображается")
    public CultLawBasePage checkOtherKodeksBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkOtherKodeksBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'В регионе' отображается")
    public CultLawBasePage checkRegionBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkRegionBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Важное' отображается")
    public CultLawBasePage checkLegislationBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkLegislationBlockIsPresent("Важные документы");
        return this;
    }

    @Step("Проверяется что блок 'Судебные решения' отображается")
    public CultLawBasePage checkJudgmentBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkJudgmentBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Главные документы' отображается")
    public CultLawBasePage checkMainDocsBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkMainDocsBlockIsPresent();
        return this;
    }

    @Step("Проверяется что заголовок раздела отображается")
    public CultLawBasePage checkSectionTitleIsPresent() {
        getHelper(LawBasePageHelper.class).checkSectionTitleIsPresent();
        return this;
    }

    public CultLawBasePage checkPopularWidgetIsPresent() {
        WebElement widget = getHelper(PopularWidget.class).getWidget();
        getHelper(PopularWidget.class).checkWidgetIsPresent(widget, "Популярное в");
        return this;
    }

    public CultLawBasePage checkPopularWidgetTitleHasWordPopular() {
        getHelper(PopularWidget.class).checkTitleHasWordPopular();
        return this;
    }

    public CultLawBasePage checkPopularWidgetContainsLinksWithDocuments() {
        getHelper(PopularWidget.class).checkPopularWidgetContainsLinksWithDocuments();
        return this;
    }

    public CultLawBasePage checkPopularWidgetLinkChangeRegionIsDisplayed() {
        getHelper(PopularWidget.class).checkLinkChangeRegionIsDisplayed();
        return this;
    }

    public CultLawBasePage checkPopularWidgetLinkChangeRegionIsNotDisplayed() {
        getHelper(PopularWidget.class).checkLinkChangeRegionIsNotDisplayed();
        return this;
    }

    public CultLawBasePage checkPopularWidgetCheckSearchInputHasName(String name) {
        WebElement widget = getHelper(PopularWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchInputHasName(widget, name);
        return this;
    }

    public CultLawBasePage checkCivilWidgetIsPresent() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(CivilWidget.class).checkWidgetIsPresent(widget, "Гражданский");
        return this;
    }

    public CultLawBasePage checkCivilWidgetTitleIsPresent() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(CivilWidget.class).checkTitleIsLink(widget);
        return this;
    }

    public CultLawBasePage checkCivilWidgetLinksArePresent() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(CivilWidget.class).checkLinksArePresent(widget);
        return this;
    }

    public CultLawBasePage checkCivilWidgetBlockResized() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(CivilWidget.class).checkBlockSizeIsChanged(widget);
        return this;
    }

    public CultLawBasePage checkWidgetHasFourLinks() {
        getHelper(CivilWidget.class).checkWidgetHasFourLinks();
        return this;
    }

    public CultLawBasePage checkCivilWidgetLinksAreWorked() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(CivilWidget.class).checkLinksAreWorked(widget);
        return this;
    }

    public CultLawBasePage checkSearchCivilWidgetBlockIsPresent() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchWidgetBlockIsPresent(widget);
        return this;
    }

    public CultLawBasePage checkAllWidgetsDontConflictWithEachOther() {
        getHelper(Widget.class).checkAllWidgetsDontConflictWithEachOther();
        return this;
    }

    public CultLawBasePage checkCivilWidgetSearchInputHasName() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchInputHasName(widget, "Поиск статей");
        return this;
    }

    public CultLawBasePage inputCivilWidgetSearchQuery(String query) {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).inputText(widget, query);
        return this;
    }

    public CultDocumentPage clickOnCivilWidgetButtonEnterIntoSearchBox() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnButtonEnterIntoSearchBox(widget);
        return redirectTo(CultDocumentPage.class);
    }

    public CultLawBasePage checkCivilWidgetSearchResultIsVisible() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsVisible(widget);
        return this;
    }

    public CultLawBasePage checkCivilWidgetSearchResultIsNotVisible() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsNotVisible(widget);
        return this;
    }

    public CultDocumentPage clickOnCivilWidgetRandomSearchResult() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnRandomSearchResult(widget);
        return redirectTo(CultDocumentPage.class);
    }

    public CultLawBasePage checkTaxWidgetIsPresent() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkWidgetIsPresent(widget, "Налоговый");
        return this;
    }

    public CultLawBasePage checkTaxWidgetTitleIsPresent() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkTitleIsLink(widget);
        return this;
    }

    public CultLawBasePage checkTaxWidgetLinksArePresent() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkLinksArePresent(widget);
        return this;
    }

    public CultLawBasePage checkTaxWidgetBlockResized() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkBlockSizeIsChanged(widget);
        return this;
    }

    public CultLawBasePage checkTaxWidgetBlockIsNotChanged() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkBlockSizeIsNotChanged(widget);
        return this;
    }

    public CultLawBasePage checkTaxWidgetHasSixLinks() {
        getHelper(TaxWidget.class).checkWidgetHasSixLinks();
        return this;
    }

    public CultLawBasePage checkTaxWidgetHasTwoLinks() {
        getHelper(TaxWidget.class).checkWidgetHasTwoLinks();
        return this;
    }

    public CultLawBasePage checkTaxWidgetLinksAreWorked() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkLinksAreWorked(widget);
        return this;
    }

    public CultLawBasePage checkSearchTaxWidgetBlockIsPresent() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchWidgetBlockIsPresent(widget);
        return this;
    }

    public CultLawBasePage checkTaxWidgetSearchInputHasName() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchInputHasName(widget, "Поиск статей");
        return this;
    }

    public CultLawBasePage inputTaxWidgetSearchQuery(String query) {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).inputText(widget, query);
        return this;
    }

    public CultDocumentPage clickOnTaxWidgetButtonEnterIntoSearchBox() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnButtonEnterIntoSearchBox(widget);
        return redirectTo(CultDocumentPage.class);
    }

    public CultLawBasePage checkTaxWidgetSearchResultIsVisible() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsVisible(widget);
        return this;
    }

    public CultLawBasePage checkTaxWidgetSearchResultIsNotVisible() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsNotVisible(widget);
        return this;
    }

    public CultDocumentPage clickOnTaxWidgetRandomSearchResult() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnRandomSearchResult(widget);
        return redirectTo(CultDocumentPage.class);
    }

    @Override
    public CultLawBasePage checkMainLawBasePageIsOpened() {
        getHelper(SearchResultHelper.class).checkMainLawBasePageIsOpened();
        return this;
    }
}
