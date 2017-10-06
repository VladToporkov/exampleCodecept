package com.actionmedia.pages.ot;

import com.actionmedia.components.widgets.SearchWidgetBlock;
import com.actionmedia.components.widgets.Widget;
import com.actionmedia.components.widgets.lawbase.LaborWidget;
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
public class OtLawBasePage extends OTBasePage<OtLawBasePage> implements ILawBasePage {

    @Step("Проверяется что заголовок раздела отображается")
    public OtLawBasePage checkSectionTitleIsPresent() {
        getHelper(LawBasePageHelper.class).checkSectionTitleIsPresent("Правовая база\n" +
                "Федеральные законы, указы, распоряжения, акты и постановления Правительства РФ, приказы, акты " +
                "органов судебной власти, официальные письма министерств и ведомств");
        return this;
    }

    @Step("Проверяется что блок 'Главные документы' отображается")
    public OtLawBasePage checkMainDocsBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkMainDocsBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Трудовой кодекс' отображается")
    public OtLawBasePage checkLaborKodeksBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkLaborKodeksBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Прочие кодексы' отображается")
    public OtLawBasePage checkOtherKodeksBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkOtherKodeksBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Федеральные законы' отображается")
    public OtLawBasePage checkFederalLawsBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkFederalLawsBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Промышленная безопасность' отображается")
    public OtLawBasePage checkIndustrialSafetyBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkIndustrialSafetyBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Отраслевые документы' отображается")
    public OtLawBasePage checkIndustryDocsBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkIndustryDocsBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Важное' отображается")
    public OtLawBasePage checkLegislationBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkLegislationBlockIsPresent("Важные документы");
        return this;
    }

    @Step("Проверяется что блок 'В регионе' отображается")
    public OtLawBasePage checkRegionBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkRegionBlockIsPresent();
        return this;
    }

    public OtLawBasePage checkLaborWidgetIsPresent() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(LaborWidget.class).checkWidgetIsPresent(widget, "Трудовой");
        return this;
    }

    public OtLawBasePage checkLaborWidgetTitleIsPresent() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(LaborWidget.class).checkTitleIsLink(widget);
        return this;
    }

    public OtLawBasePage checkLaborWidgetLinksArePresent() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(LaborWidget.class).checkLinksArePresent(widget);
        return this;
    }

    public OtLawBasePage checkLaborWidgetBlockResized() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(LaborWidget.class).checkBlockSizeIsChanged(widget);
        return this;
    }

    public OtLawBasePage checkLaborWidgetLinksAreWorked() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(LaborWidget.class).checkLinksAreWorked(widget);
        return this;
    }

    public OtLawBasePage checkLaborWidgetHasTenLinks() {
        getHelper(LaborWidget.class).checkWidgetHasTenLinks();
        return this;
    }

    public OtLawBasePage checkAllWidgetsDontConflictWithEachOther() {
        getHelper(Widget.class).checkAllWidgetsDontConflictWithEachOther();
        return this;
    }

    public OtLawBasePage checkLaborWidgetHasSixLinks() {
        getHelper(LaborWidget.class).checkWidgetHasSixLinks();
        return this;
    }

    public OtLawBasePage checkSearchLaborWidgetBlockIsPresent() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchWidgetBlockIsPresent(widget);
        return this;
    }

    public OtLawBasePage checkLaborWidgetSearchInputHasName() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchInputHasName(widget, "Поиск статей");
        return this;
    }

    public OtLawBasePage inputLaborWidgetSearchQuery(String query) {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).inputText(widget, query);
        return this;
    }

    public OtLawBasePage checkLaborWidgetSearchResultIsVisible() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsVisible(widget);
        return this;
    }

    public OtDocumentPage clickOnLaborWidgetRandomSearchResult() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnRandomSearchResult(widget);
        return redirectTo(OtDocumentPage.class);
    }

    public OtDocumentPage clickOnLaborWidgetButtonEnterIntoSearchBox() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnButtonEnterIntoSearchBox(widget);
        return redirectTo(OtDocumentPage.class);
    }

    public OtLawBasePage checkLaborWidgetSearchResultIsNotVisible() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsNotVisible(widget);
        return this;
    }

    @Override
    public OtLawBasePage checkMainLawBasePageIsOpened() {
        getHelper(SearchResultHelper.class).checkMainLawBasePageIsOpened();
        return this;
    }
}
