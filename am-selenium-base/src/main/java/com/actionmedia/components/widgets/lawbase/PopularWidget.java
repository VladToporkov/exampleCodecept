package com.actionmedia.components.widgets.lawbase;

import com.actionmedia.autotest.selenium.annotations.Wait;
import com.actionmedia.components.widgets.Widget;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Pavel on 20/06/16.
 */
@Component
public class PopularWidget extends Widget {

    @FindBy(css = ".widget_content_region")
    @Wait
    @CacheLookup
    private WebElement widget;

    public void checkTitleHasWordPopular() {
        WebElement titleElement = findElementByNoThrow(widget, By.cssSelector(".widget__title-text"));
        postponedAssertTrue(titleElement.getText().contains("Популярное в"), "Заголовок: " + titleElement.getText() +
                " не содержит словосочетание Популярное в");
    }

    public void checkLinkChangeRegionIsDisplayed() {
        WebElement changeRegionLink = findElementByNoThrow(widget, By.cssSelector(".region-link"));
        postponedAssertTrue(changeRegionLink != null && changeRegionLink.isDisplayed(),
                "Ссылка Изменить регион не отображена");
    }

    public void checkLinkChangeRegionIsNotDisplayed() {
        WebElement changeRegionLink = findElementByNoThrow(widget, By.cssSelector(".region-link"));
        postponedAssertTrue(changeRegionLink == null || !changeRegionLink.isDisplayed(),
                "Ссылка Изменить регион отображена");
    }

    public void checkPopularWidgetContainsLinksWithDocuments() {
        List<WebElement> links = findElementsByNoThrow(widget, By.cssSelector("div > .list li a"));
        if (links != null) {
            for (int i = 0; i < links.size(); i++) {
                WebElement documentLink = links.get(i);
                postponedAssertTrue(documentLink.isDisplayed(),
                        String.format("Документ: %d находится в списке но не отображается", i));
                String href = documentLink.getAttribute("href");
                postponedAssertTrue(href.contains("document"),
                        String.format("Документ под номером %d не содержит в ссылке слова document: href=%s", i, href));
            }
        } else {
            setPostponedTestFail("Документы в виджете не отображаются");
        }
    }

    public WebElement getWidget() {
        return widget;
    }

}
