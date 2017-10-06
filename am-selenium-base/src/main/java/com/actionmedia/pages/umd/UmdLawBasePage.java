package com.actionmedia.pages.umd;

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
public class UmdLawBasePage extends UmdBasePage<UmdLawBasePage> implements ILawBasePage {

    @Step("Проверяется что блок 'Гражданский кодекс' отображается")
    public UmdLawBasePage checkCivilKodeksBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkCivilKodeksBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Прочие кодексы' отображается")
    public UmdLawBasePage checkOtherKodeksBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkOtherKodeksBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'В регионе' отображается")
    public UmdLawBasePage checkRegionBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkRegionBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Важное' отображается")
    public UmdLawBasePage checkLegislationBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkLegislationBlockIsPresent("Важные документы");
        return this;
    }

    @Step("Проверяется что блок 'Судебные решения' отображается")
    public UmdLawBasePage checkJudgmentBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkJudgmentBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Главные документы' отображается")
    public UmdLawBasePage checkMainDocsBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkMainDocsBlockIsPresent();
        return this;
    }

    @Step("Проверяется что заголовок раздела отображается")
    public UmdLawBasePage checkSectionTitleIsPresent() {
        getHelper(LawBasePageHelper.class).checkSectionTitleIsPresent();
        return this;
    }

    public UmdLawBasePage checkPopularWidgetIsPresent() {
        WebElement widget = getHelper(PopularWidget.class).getWidget();
        getHelper(PopularWidget.class).checkWidgetIsPresent(widget, "Популярное в");
        return this;
    }

    public UmdLawBasePage checkPopularWidgetTitleHasWordPopular() {
        getHelper(PopularWidget.class).checkTitleHasWordPopular();
        return this;
    }

    public UmdLawBasePage checkPopularWidgetContainsLinksWithDocuments() {
        getHelper(PopularWidget.class).checkPopularWidgetContainsLinksWithDocuments();
        return this;
    }

    public UmdLawBasePage checkPopularWidgetLinkChangeRegionIsDisplayed() {
        getHelper(PopularWidget.class).checkLinkChangeRegionIsDisplayed();
        return this;
    }

    public UmdLawBasePage checkPopularWidgetLinkChangeRegionIsNotDisplayed() {
        getHelper(PopularWidget.class).checkLinkChangeRegionIsNotDisplayed();
        return this;
    }

    public UmdLawBasePage checkPopularWidgetCheckSearchInputHasName(String name) {
        WebElement widget = getHelper(PopularWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchInputHasName(widget, name);
        return this;
    }

    public UmdLawBasePage checkCivilWidgetIsPresent() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(CivilWidget.class).checkWidgetIsPresent(widget, "Гражданский");
        return this;
    }

    public UmdLawBasePage checkCivilWidgetTitleIsPresent() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(CivilWidget.class).checkTitleIsLink(widget);
        return this;
    }

    public UmdLawBasePage checkCivilWidgetLinksArePresent() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(CivilWidget.class).checkLinksArePresent(widget);
        return this;
    }

    public UmdLawBasePage checkCivilWidgetBlockResized() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(CivilWidget.class).checkBlockSizeIsChanged(widget);
        return this;
    }

    public UmdLawBasePage checkWidgetHasFourLinks() {
        getHelper(CivilWidget.class).checkWidgetHasFourLinks();
        return this;
    }

    public UmdLawBasePage checkCivilWidgetLinksAreWorked() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(CivilWidget.class).checkLinksAreWorked(widget);
        return this;
    }

    public UmdLawBasePage checkSearchCivilWidgetBlockIsPresent() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchWidgetBlockIsPresent(widget);
        return this;
    }

    public UmdLawBasePage checkAllWidgetsDontConflictWithEachOther() {
        getHelper(Widget.class).checkAllWidgetsDontConflictWithEachOther();
        return this;
    }

    public UmdLawBasePage checkCivilWidgetSearchInputHasName() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchInputHasName(widget, "Поиск статей");
        return this;
    }

    public UmdLawBasePage inputCivilWidgetSearchQuery(String query) {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).inputText(widget, query);
        return this;
    }

    public UmdDocumentPage clickOnCivilWidgetButtonEnterIntoSearchBox() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnButtonEnterIntoSearchBox(widget);
        return redirectTo(UmdDocumentPage.class);
    }

    public UmdLawBasePage checkCivilWidgetSearchResultIsVisible() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsVisible(widget);
        return this;
    }

    public UmdLawBasePage checkCivilWidgetSearchResultIsNotVisible() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsNotVisible(widget);
        return this;
    }

    public UmdDocumentPage clickOnCivilWidgetRandomSearchResult() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnRandomSearchResult(widget);
        return redirectTo(UmdDocumentPage.class);
    }

    public UmdLawBasePage checkTaxWidgetIsPresent() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkWidgetIsPresent(widget, "Налоговый");
        return this;
    }

    public UmdLawBasePage checkTaxWidgetTitleIsPresent() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkTitleIsLink(widget);
        return this;
    }

    public UmdLawBasePage checkTaxWidgetLinksArePresent() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkLinksArePresent(widget);
        return this;
    }

    public UmdLawBasePage checkTaxWidgetBlockResized() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkBlockSizeIsChanged(widget);
        return this;
    }

    public UmdLawBasePage checkTaxWidgetBlockIsNotChanged() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkBlockSizeIsNotChanged(widget);
        return this;
    }

    public UmdLawBasePage checkTaxWidgetHasSixLinks() {
        getHelper(TaxWidget.class).checkWidgetHasSixLinks();
        return this;
    }

    public UmdLawBasePage checkTaxWidgetHasTwoLinks() {
        getHelper(TaxWidget.class).checkWidgetHasTwoLinks();
        return this;
    }

    public UmdLawBasePage checkTaxWidgetLinksAreWorked() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkLinksAreWorked(widget);
        return this;
    }

    public UmdLawBasePage checkSearchTaxWidgetBlockIsPresent() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchWidgetBlockIsPresent(widget);
        return this;
    }

    public UmdLawBasePage checkTaxWidgetSearchInputHasName() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchInputHasName(widget, "Поиск статей");
        return this;
    }

    public UmdLawBasePage inputTaxWidgetSearchQuery(String query) {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).inputText(widget, query);
        return this;
    }

    public UmdDocumentPage clickOnTaxWidgetButtonEnterIntoSearchBox() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnButtonEnterIntoSearchBox(widget);
        return redirectTo(UmdDocumentPage.class);
    }

    public UmdLawBasePage checkTaxWidgetSearchResultIsVisible() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsVisible(widget);
        return this;
    }

    public UmdLawBasePage checkTaxWidgetSearchResultIsNotVisible() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsNotVisible(widget);
        return this;
    }

    public UmdDocumentPage clickOnTaxWidgetRandomSearchResult() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnRandomSearchResult(widget);
        return redirectTo(UmdDocumentPage.class);
    }

    @Override
    public UmdLawBasePage checkMainLawBasePageIsOpened() {
        getHelper(SearchResultHelper.class).checkMainLawBasePageIsOpened();
        return this;
    }
}
