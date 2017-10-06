package com.actionmedia.pages.klpu;

import com.actionmedia.components.widgets.SearchWidgetBlock;
import com.actionmedia.components.widgets.Widget;
import com.actionmedia.components.widgets.lawbase.CivilWidget;
import com.actionmedia.components.widgets.lawbase.PopularWidget;
import com.actionmedia.components.widgets.lawbase.TaxWidget;
import com.actionmedia.pages.elpu.ElpuBasePage;
import com.actionmedia.pages.elpu.ElpuDocumentPage;
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
public class KlpuLawBasePage extends KlpuBasePage<KlpuLawBasePage> implements ILawBasePage {

    @Step("Проверяется что блок 'Гражданский кодекс' отображается")
    public KlpuLawBasePage checkCivilKodeksBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkCivilKodeksBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Прочие кодексы' отображается")
    public KlpuLawBasePage checkOtherKodeksBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkOtherKodeksBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'В регионе' отображается")
    public KlpuLawBasePage checkRegionBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkRegionBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Важное' отображается")
    public KlpuLawBasePage checkLegislationBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkLegislationBlockIsPresent("Важные документы");
        return this;
    }

    @Step("Проверяется что блок 'Судебные решения' отображается")
    public KlpuLawBasePage checkJudgmentBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkJudgmentBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Главные документы' отображается")
    public KlpuLawBasePage checkMainDocsBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkMainDocsBlockIsPresent();
        return this;
    }

    @Step("Проверяется что заголовок раздела отображается")
    public KlpuLawBasePage checkSectionTitleIsPresent() {
        getHelper(LawBasePageHelper.class).checkSectionTitleIsPresent();
        return this;
    }

    public KlpuLawBasePage checkPopularWidgetIsPresent() {
        WebElement widget = getHelper(PopularWidget.class).getWidget();
        getHelper(PopularWidget.class).checkWidgetIsPresent(widget, "Популярное в");
        return this;
    }

    public KlpuLawBasePage checkPopularWidgetTitleHasWordPopular() {
        getHelper(PopularWidget.class).checkTitleHasWordPopular();
        return this;
    }

    public KlpuLawBasePage checkPopularWidgetContainsLinksWithDocuments() {
        getHelper(PopularWidget.class).checkPopularWidgetContainsLinksWithDocuments();
        return this;
    }

    public KlpuLawBasePage checkPopularWidgetLinkChangeRegionIsDisplayed() {
        getHelper(PopularWidget.class).checkLinkChangeRegionIsDisplayed();
        return this;
    }

    public KlpuLawBasePage checkPopularWidgetLinkChangeRegionIsNotDisplayed() {
        getHelper(PopularWidget.class).checkLinkChangeRegionIsNotDisplayed();
        return this;
    }

    public KlpuLawBasePage checkPopularWidgetCheckSearchInputHasName(String name) {
        WebElement widget = getHelper(PopularWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchInputHasName(widget, name);
        return this;
    }

    public KlpuLawBasePage checkCivilWidgetIsPresent() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(CivilWidget.class).checkWidgetIsPresent(widget, "Гражданский");
        return this;
    }

    public KlpuLawBasePage checkCivilWidgetTitleIsPresent() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(CivilWidget.class).checkTitleIsLink(widget);
        return this;
    }

    public KlpuLawBasePage checkCivilWidgetLinksArePresent() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(CivilWidget.class).checkLinksArePresent(widget);
        return this;
    }

    public KlpuLawBasePage checkCivilWidgetBlockResized() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(CivilWidget.class).checkBlockSizeIsChanged(widget);
        return this;
    }

    public KlpuLawBasePage checkWidgetHasFourLinks() {
        getHelper(CivilWidget.class).checkWidgetHasFourLinks();
        return this;
    }

    public KlpuLawBasePage checkCivilWidgetLinksAreWorked() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(CivilWidget.class).checkLinksAreWorked(widget);
        return this;
    }

    public KlpuLawBasePage checkSearchCivilWidgetBlockIsPresent() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchWidgetBlockIsPresent(widget);
        return this;
    }

    public KlpuLawBasePage checkAllWidgetsDontConflictWithEachOther() {
        getHelper(Widget.class).checkAllWidgetsDontConflictWithEachOther();
        return this;
    }

    public KlpuLawBasePage checkCivilWidgetSearchInputHasName() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchInputHasName(widget, "Поиск статей");
        return this;
    }

    public KlpuLawBasePage inputCivilWidgetSearchQuery(String query) {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).inputText(widget, query);
        return this;
    }

    public ElpuDocumentPage clickOnCivilWidgetButtonEnterIntoSearchBox() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnButtonEnterIntoSearchBox(widget);
        return redirectTo(ElpuDocumentPage.class);
    }

    public KlpuLawBasePage checkCivilWidgetSearchResultIsVisible() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsVisible(widget);
        return this;
    }

    public KlpuLawBasePage checkCivilWidgetSearchResultIsNotVisible() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsNotVisible(widget);
        return this;
    }

    public ElpuDocumentPage clickOnCivilWidgetRandomSearchResult() {
        WebElement widget = getHelper(CivilWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnRandomSearchResult(widget);
        return redirectTo(ElpuDocumentPage.class);
    }

    public KlpuLawBasePage checkTaxWidgetIsPresent() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkWidgetIsPresent(widget, "Налоговый");
        return this;
    }

    public KlpuLawBasePage checkTaxWidgetTitleIsPresent() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkTitleIsLink(widget);
        return this;
    }

    public KlpuLawBasePage checkTaxWidgetLinksArePresent() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkLinksArePresent(widget);
        return this;
    }

    public KlpuLawBasePage checkTaxWidgetBlockResized() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkBlockSizeIsChanged(widget);
        return this;
    }

    public KlpuLawBasePage checkTaxWidgetBlockIsNotChanged() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkBlockSizeIsNotChanged(widget);
        return this;
    }

    public KlpuLawBasePage checkTaxWidgetHasSixLinks() {
        getHelper(TaxWidget.class).checkWidgetHasSixLinks();
        return this;
    }

    public KlpuLawBasePage checkTaxWidgetHasTwoLinks() {
        getHelper(TaxWidget.class).checkWidgetHasTwoLinks();
        return this;
    }

    public KlpuLawBasePage checkTaxWidgetLinksAreWorked() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(TaxWidget.class).checkLinksAreWorked(widget);
        return this;
    }

    public KlpuLawBasePage checkSearchTaxWidgetBlockIsPresent() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchWidgetBlockIsPresent(widget);
        return this;
    }

    public KlpuLawBasePage checkTaxWidgetSearchInputHasName() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchInputHasName(widget, "Поиск статей");
        return this;
    }

    public KlpuLawBasePage inputTaxWidgetSearchQuery(String query) {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).inputText(widget, query);
        return this;
    }

    public ElpuDocumentPage clickOnTaxWidgetButtonEnterIntoSearchBox() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnButtonEnterIntoSearchBox(widget);
        return redirectTo(ElpuDocumentPage.class);
    }

    public KlpuLawBasePage checkTaxWidgetSearchResultIsVisible() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsVisible(widget);
        return this;
    }

    public KlpuLawBasePage checkTaxWidgetSearchResultIsNotVisible() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsNotVisible(widget);
        return this;
    }

    public ElpuDocumentPage clickOnTaxWidgetRandomSearchResult() {
        WebElement widget = getHelper(TaxWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnRandomSearchResult(widget);
        return redirectTo(ElpuDocumentPage.class);
    }

    @Override
    public KlpuLawBasePage checkMainLawBasePageIsOpened() {
        getHelper(SearchResultHelper.class).checkMainLawBasePageIsOpened();
        return this;
    }
}
