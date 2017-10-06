package com.actionmedia.components.widgets;

import com.actionmedia.autotest.selenium.context.AbstractComponent;
import com.actionmedia.base.BasePage;
import com.actionmedia.pages.helpers.SearchResultHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

/**
 * Created by Pavel on 26/05/16.
 */
@Component
public class SearchWidgetBlock extends BasePage<SearchWidgetBlock> {

    @Step("Проверяется, что поисковая строка отображается")
    public void checkSearchWidgetBlockIsPresent(WebElement widget) {
        WebElement searchBlock = findElementByNoThrow(widget, By.cssSelector("[id*=widget-search]"));
        postponedAssertTrue(searchBlock != null && searchBlock.isDisplayed(), "Поисковая строка не отображается");
    }

    @Step("Проверяется, что поисковая строка имеет название {1}")
    public void checkSearchInputHasName(WebElement widget, String name) {
        WebElement searchBlock = findElementByNoThrow(widget, By.cssSelector("[id*=widget-search]"));
        postponedAssertEquals(searchBlock.getAttribute("value"), name, "Не правильное название в поисковой строке");
    }

    @Step("Ввести текст {1} в поисковую строку")
    public void inputText(WebElement widget, String text) {
        WebElement searchBlock = findElementByNoThrow(widget, By.cssSelector("[id*=widget-search]"));
//        searchBlock.click();
//        executeScript(String.format("arguments[0].setAttribute('value', '%s')", text), searchBlock);
//        searchBlock.click();
        searchBlock.sendKeys(text);
        waitForReloadingPage();
    }

    @Step("Нажать на кнопку Enter поисковой строки")
    public void clickOnButtonEnterIntoSearchBox(WebElement widget) {
        WebElement iconEnter = findElementByNoThrow(widget, By.cssSelector(".ico_content_enter"));
        postponedAssertTrue(iconEnter != null && iconEnter.isDisplayed(),
                "Иконка Enter в поисковой строке не отображается");
        if (iconEnter != null) {
            iconEnter.click();
            waitForReloadingPage();
        }
    }

    @Step("Проверяется, что отображается всплывающая строка с результатами поиска")
    public void checkSearchResultIsVisible(WebElement widget) {
        List<WebElement> autocomplete = findElementsByNoThrow(widget, By.cssSelector(".ui-autocomplete li"));
        int trySize = 0;
        while (autocomplete != null && autocomplete.size() == 0 && trySize < 5) {
            autocomplete = findElementsByNoThrow(widget, By.cssSelector(".ui-autocomplete li"));
            trySize++;
        }
        if (autocomplete != null && autocomplete.size() > 0 && autocomplete.get(0).isDisplayed()) {
            postponedAssertTrue(autocomplete.size() > 0, "Результаты не отображаются");
        } else {
            hookSearchResultVisible();
        }
    }

    @Step("Проверяется, что НЕ отображается всплывающая строка с результатами поиска")
    public void checkSearchResultIsNotVisible(WebElement widget) {
        List<WebElement> autocomplete = findElementsByNoThrow(widget, By.cssSelector(".ui-autocomplete li"));
        if (autocomplete == null || autocomplete.size() == 0 || !autocomplete.get(0).isDisplayed()) {
            postponedAssertTrue(autocomplete.size() == 0, "Результаты поиска отображаются");
        }
    }

    @Step("Нажать на случайную ссылку из результатов поиска")
    public void clickOnRandomSearchResult(WebElement widget) {
        List<WebElement> autocomplete = findElementsByNoThrow(widget, By.cssSelector(".ui-autocomplete li a"));
        if (autocomplete != null && autocomplete.size() > 0) {
            WebElement randomElement = getRandomElementInList(autocomplete);
            report("Выбран элемент:" + randomElement.getText());
            setParameter(SearchResultHelper.DOCUMENT_URL, randomElement.getAttribute("href"));
            randomElement.click();
            waitForReloadingPage();
        } else {
            setPostponedTestFail("Нет ни одного результата поиска");
        }
    }

}
