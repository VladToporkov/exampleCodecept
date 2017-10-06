package com.actionmedia.components.widgets.recomendation;

import com.actionmedia.autotest.selenium.annotations.Wait;
import com.actionmedia.components.widgets.Widget;
import com.actionmedia.pages.helpers.SearchResultHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

@Component
public class FormsWidget extends Widget {

    @FindBy(id = "widget-form")
    @Wait
    @CacheLookup
    private WebElement widget;

    private final String titleText = "Формы и бланки";

    @Step("Проверяется что виджет Формы и бланки отображается")
    public void checkWidgetIsPresent() {
        postponedAssertTrue(widget.isEnabled() && widget.isDisplayed(), "Виджет Формы и бланки не отображается");
    }

    @Step("Проверяется контент в блоке 'Формы'")
    public void checkContentFormsWidget() {
        WebElement widget = findElementByNoThrow(mainContentElement, By.cssSelector(getSettings().isRunKss() ? ".widget-forms" : ".b-form-widget"));
        if (widget != null) {
            WebElement header = widget.findElement(getSettings().isRunKss() ? By.tagName("h3") : By.cssSelector(".title a"));
            String widgetName = header.getText();
            postponedAssertFalse(widgetName.isEmpty(), "Отсутствует заголовок виджета для '" + widget.getAttribute("class") + "'");

            if (!getSettings().isRunUss()) {
                WebElement count = findElementByNoThrow(widget, By.cssSelector(getSettings().isRunKss() ? ".widget__count" : ".title b"));
                postponedAssertNotNull(count, "Отсутствует количество документов в блоке 'Формы'");
                if (count != null) {
                    postponedAssertFalse(count.getText().isEmpty(), "Отсутствует текст для количества документов в блоке 'Формы'");
                }
            }

            WebElement update = findElementByNoThrow(widget, By.cssSelector(".widget-update"));
            if (update != null) {
                postponedAssertFalse(update.getText().isEmpty(), "Отсутствует текст для количества новых документов в разделе в блоке 'Формы'");
            }

            List<WebElement> contentList = widget.findElements(By.tagName("li"));
            postponedAssertFalse(contentList.isEmpty(), "Отсутствует контент в блоке 'Формы'");
            for (WebElement content : contentList) {
                String contentName = content.getText();
                WebElement contentLink = findElementByNoThrow(content, By.tagName("a"));
                postponedAssertNotNull(contentLink, "Отсутствует ссылка для '" + contentName + "' в блоке 'Формы'");
            }

        } else {
            setPostponedTestFail("Блок 'Формы' не найден");
        }
    }

    @Step("Проверяется что виджет 'Формы и бланки' не пустой")
    public void checkWidgetIsNotEmpty() {
        List<WebElement> formItemList = findElementsByNoThrow(widget, By.tagName("li"));
        postponedAssertFalse(formItemList.isEmpty(), "Виджет 'Формы и бланки' пустой");
    }

    @Step("Нажать на ссылку Формы и бланки")
    public void clickOnTitle() {
        WebElement title = findElementByNoThrow(widget, By.cssSelector(".widget__title-text"));
        title.click();
        waitForReloadingPage();
    }

    @Step("Проверить, что отображается заголовок виджета")
    public void checkTitleIsPresent() {
        String titleText = "";
        if (getSettings().isRunEdu()) {
            titleText = "Шаблоны и примеры";
        } else if (getSettings().isRunUss()) {
            titleText = "Формы";
        } else if (getSettings().isRunFss()) {
            titleText = "Положения и регламенты";
        }  else if (getSettings().isRunGo()) {
            titleText = "Шаблоны и примеры";
        } else if (getSettings().isRunElpu()) {
            titleText = "Формы и бланки";
        } else if (getSettings().isRunKlpu()) {
            titleText = "Шаблоны и образцы";
        } else if (getSettings().isRunCult()) {
            titleText = "Шаблоны";
        } else if (getSettings().isRunUmd()) {
            titleText = "Шаблоны";
        } else {
            titleText = this.titleText;
        }
        WebElement title = findElementByNoThrow(widget, By.cssSelector(".widget__title-text"));
        postponedAssertTrue(title.isDisplayed(), "Заголовок виджета не отображается");
        postponedAssertEquals(title.getText(), titleText, "Название виджета неверное");
    }

    @Step("Проверить, что отображается поисковая строка")
    public void checkSearchInputIsPresent() {
        WebElement searchInput = findElementByNoThrow(widget, By.id("widget-search--text"));
        postponedAssertTrue(searchInput.isDisplayed(), "Поисковая строка не отображена в виджете");
    }

    @Step("Проверяется, что отображается количество новых документов в виджете")
    public void checkNewDocumentCounterIsPresent() {
        WebElement counter = findElementByNoThrow(widget, By.cssSelector(".widget__update"));
        postponedAssertTrue(counter.isDisplayed(), "Количество новых документов в виджете не отображается");
    }

    @Step("Проверяется, что отображается общее количество документов в разделе")
    public void checkExamplesFormsIsPresent() {
        WebElement count = findElementByNoThrow(widget, By.cssSelector(".widget__count"));
        postponedAssertTrue(count.isDisplayed(), "Количество образцов в виджете не отображается");
    }

    @Step("Нажать на первую ссылку в виджете (Красная)")
    public void clickOnRedLink() {
        WebElement link = findElementBy(widget, By.cssSelector("li.list__item_order_1 > a"));
        setParameter(SearchResultHelper.DOCUMENT_URL, link.getAttribute("href"));
        link.click();
        waitForReloadingPage();
    }

    @Step("Нажать на вторую ссылку в виджете (Зеленая)")
    public void clickOnGreenLink() {
        WebElement link = findElementBy(widget, By.cssSelector("li.list__item_order_2 > a"));
        setParameter(SearchResultHelper.DOCUMENT_URL, link.getAttribute("href"));
        link.click();
        waitForReloadingPage();
    }

    @Step("Нажать на третью ссылку в виджете (Синяя)")
    public void clickOnBlueLink() {
        WebElement link = findElementBy(widget, By.cssSelector("li.list__item_order_3 > a"));
        setParameter(SearchResultHelper.DOCUMENT_URL, link.getAttribute("href"));
        link.click();
        waitForReloadingPage();
    }

    @Step("Нажать на четвертая ссылку в виджете (Желтая)")
    public void clickOnYellowLink() {
        WebElement link = findElementBy(widget, By.cssSelector("li.list__item_order_4 > a"));
        setParameter(SearchResultHelper.DOCUMENT_URL, link.getAttribute("href"));
        link.click();
        waitForReloadingPage();
    }

    @Step("Проверяется работа ссылки Новых документов")
    public void clickLinkNewDocumentCounter() {
        WebElement counter = findElementByNoThrow(widget, By.cssSelector(".widget__update"));
        counter.click();
        waitForReloadingPage();
    }

    @Step("Проверяется работа ссылки Кнопка Enter")
    public void clickLinkEnterIconOnSearchInput() {
        WebElement icon = findElementByNoThrow(widget, By.cssSelector("form > [type='submit']"));
        icon.click();
        waitForReloadingPage();
    }

    @Step("Ввести запрос в поисковую строку")
    public void inputInSearch(String query) {
        WebElement inputSearch = findElementByNoThrow(widget, By.id("widget-search--text"));
        inputSearch.clear();
        inputSearch.sendKeys(query);
        waitForReloadingPage();
        WebElement searchResultList = findElementByNoThrow(widget, By.cssSelector("form > ul"));
        if (searchResultList == null || !searchResultList.isDisplayed()) {
            hookSearchResultVisible();
        }
        setParameter(SearchResultHelper.HINT_TEXT, query);
    }

    @Step("Проверить, что появились поисковые подсказки")
    public void checkSearchResultsArePresent() {
        WebElement searchResultList = findElementByNoThrow(widget, By.cssSelector("form > ul"));
        postponedAssertTrue(searchResultList.isDisplayed(), "Поисковые подсказки не появились");
        List<WebElement> searchResults = findElementsByNoThrow(searchResultList, By.tagName("li"));
        postponedAssertTrue(searchResults.size() > 0, "Ни одной поисковой подсказки не отобразилось");
    }

    @Step("Проверить, что подсказка с прямым переходом отображается и по ссылке открывается соответствующий документ")
    public void clickOnSearchResultsDirectDocument() {
        WebElement searchResultList = findElementByNoThrow(widget, By.cssSelector("form > ul"));
        postponedAssertTrue(searchResultList.isDisplayed(), "Поисковые подсказки не появились");
        WebElement directLinkDocument = findElementByNoThrow(searchResultList, By.cssSelector(".hint-doc > a"));
        postponedAssertTrue(directLinkDocument != null && directLinkDocument.isDisplayed(), "Прямая ссылка на документ не отображается");
        setParameter(SearchResultHelper.DOCUMENT_URL, directLinkDocument.getAttribute("href"));
        directLinkDocument.click();
        waitForReloadingPage();
    }

    @Step("Проверить, что нажатие на подсказку в поисковых результатах открывает страницу Правовой базы с выбранным запросом")
    public void clickSearchResultsRandomHintLink() {
        WebElement searchResultList = findElementByNoThrow(widget, By.cssSelector("form > ul"));
        postponedAssertTrue(searchResultList.isDisplayed(), "Поисковые подсказки не появились");
        List<WebElement> menuItems = findElementsByNoThrow(searchResultList, By.xpath("./li[not(contains(@class,'hint-doc'))]"));
        postponedAssertTrue(menuItems.size() > 0, "Обычные подсказки не найдены");
        WebElement randomHint = getRandomElementInList(menuItems);
        setParameter(SearchResultHelper.HINT_TEXT, randomHint.getText());
        randomHint.click();
        waitForReloadingPage();
    }
}
