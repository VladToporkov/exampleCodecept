package com.actionmedia.pages.edu;

import com.actionmedia.pages.helpers.LawBasePageHelper;
import com.actionmedia.components.widgets.SearchWidgetBlock;
import com.actionmedia.components.widgets.Widget;
import com.actionmedia.components.widgets.lawbase.LaborWidget;
import com.actionmedia.pages.helpers.SearchResultHelper;
import com.actionmedia.pages.interfaces.ILawBasePage;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Pavel on 18/04/16.
 */
@Component
public class EduLawBasePage extends EduBasePage<EduLawBasePage> implements ILawBasePage {

    @Step("Проверяется что заголовок раздела отображается")
    public EduLawBasePage checkSectionTitleIsPresent() {
        getHelper(LawBasePageHelper.class).checkSectionTitleIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Трудовой кодекс' отображается")
    public EduLawBasePage checkLaborKodeksBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkLaborKodeksBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Прочие кодексы' отображается")
    public EduLawBasePage checkOtherKodeksBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkOtherKodeksBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Важное' отображается")
    public EduLawBasePage checkLegislationBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkLegislationBlockIsPresent("Важные документы");
        return this;
    }

    @Step("Проверяется что блок 'Отраслевые документы' отображается")
    public EduLawBasePage checkIndustryDocsBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkIndustryDocsBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Стандарты' отображается")
    public EduLawBasePage checkStandartsBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkStandartsBlockIsPresent();
        return this;
    }

    @Step("Проверяется что блок 'Главные документы' отображается")
    public EduLawBasePage checkMainDocsBlockIsPresent() {
        getHelper(LawBasePageHelper.class).checkMainDocsBlockIsPresent();
        return this;
    }

    @Step("Проверяется кнопка рубрикатора кодексов на странице 'Правовая База'")
    public EduLawBasePage checkAllKodeksBudgetRubricatorButtonIsPresent() {
        getHelper(LawBasePageHelper.class).checkAllKodexRubricatorButtonIsPresent();
        return this;
    }

    public EduLawBasePage checkLaborWidgetIsPresent() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(LaborWidget.class).checkWidgetIsPresent(widget, "Трудовой");
        return this;
    }

    public EduLawBasePage checkLaborWidgetTitleIsPresent() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(LaborWidget.class).checkTitleIsLink(widget);
        return this;
    }

    public EduLawBasePage checkLaborWidgetLinksArePresent() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(LaborWidget.class).checkLinksArePresent(widget);
        return this;
    }

    public EduLawBasePage checkLaborWidgetBlockResized() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(LaborWidget.class).checkBlockSizeIsChanged(widget);
        return this;
    }

    public EduLawBasePage checkLaborWidgetHasTenLinks() {
        getHelper(LaborWidget.class).checkWidgetHasTenLinks();
        return this;
    }

    public EduLawBasePage checkLaborWidgetHasSixLinks() {
        getHelper(LaborWidget.class).checkWidgetHasSixLinks();
        return this;
    }

    public EduLawBasePage checkLaborWidgetLinksAreWorked() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(LaborWidget.class).checkLinksAreWorked(widget);
        return this;
    }

    public EduLawBasePage checkSearchLaborWidgetBlockIsPresent() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchWidgetBlockIsPresent(widget);
        return this;
    }

    public EduLawBasePage checkLaborWidgetSearchInputHasName() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchInputHasName(widget, "Поиск статей");
        return this;
    }

    public EduLawBasePage inputLaborWidgetSearchQuery(String query) {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).inputText(widget, query);
        return this;
    }

    public EduDocumentPage clickOnLaborWidgetButtonEnterIntoSearchBox() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnButtonEnterIntoSearchBox(widget);
        return redirectTo(EduDocumentPage.class);
    }

    public EduLawBasePage checkLaborWidgetSearchResultIsVisible() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsVisible(widget);
        return this;
    }

    public EduLawBasePage checkLaborWidgetSearchResultIsNotVisible() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).checkSearchResultIsNotVisible(widget);
        return this;
    }

    public EduDocumentPage clickOnLaborWidgetRandomSearchResult() {
        WebElement widget = getHelper(LaborWidget.class).getWidget();
        getHelper(SearchWidgetBlock.class).clickOnRandomSearchResult(widget);
        return redirectTo(EduDocumentPage.class);
    }

    public EduLawBasePage checkAllWidgetsDontConflictWithEachOther() {
        getHelper(Widget.class).checkAllWidgetsDontConflictWithEachOther();
        return this;
    }

    public EduLawBasePage checkMainLawBasePageIsOpened() {
        getHelper(SearchResultHelper.class).checkMainLawBasePageIsOpened();
        return this;
    }
}
