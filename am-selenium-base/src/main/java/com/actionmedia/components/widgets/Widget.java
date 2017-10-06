package com.actionmedia.components.widgets;

import com.actionmedia.base.BasePage;
import com.actionmedia.components.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel on 26/05/16.
 */
@Component
public class Widget extends BasePage<Widget> {

    protected int oldSizeWidget;

    @Step("Проверяется что виджет {1} отображается")
    public void checkWidgetIsPresent(WebElement widget, String widgetName) {
        oldSizeWidget = widget.getSize().getWidth();
        postponedAssertTrue(widget.isEnabled() && widget.isDisplayed(),
                String.format("Виджет не отображается", widgetName));
    }

    @Step("Проверяется, что все блоки на странице не конфликтуют и не наезжают друг на друга")
    public void checkAllWidgetsDontConflictWithEachOther() {
        List<WebElement> wrapper = waitForPresenceOfAllElementsLocatedBy(By.xpath("//div[@class='main__in']/article"), "Блок с кодексами не найден");
        int[][] points = new int[wrapper.size()][4];
        for (int i = 0; i < wrapper.size(); i++) {
            points[i][0] = wrapper.get(i).getLocation().getX();
            points[i][1] = wrapper.get(i).getLocation().getX() + wrapper.get(i).getSize().getWidth();
            points[i][2] = wrapper.get(i).getLocation().getY();
            points[i][3] = wrapper.get(i).getLocation().getY() + wrapper.get(i).getSize().getHeight();
        }
        for (int i = 0; i < wrapper.size(); i++) {
            for (int j = 0; j < wrapper.size(); j++) {
                if (j != i) {
                    postponedAssertFalse((points[i][0] <= points[j][0] && points[i][1] >= points[j][1])
                            && (points[i][2] <= points[j][2] && points[i][3] >= points[j][3]), wrapper.get(i).getText() + " наезжает на остальные");
                }
            }
        }
    }

    @Step("Проверяется, что размер блока изменился")
    public void checkBlockSizeIsChanged(WebElement widget) {
        postponedAssertTrue(oldSizeWidget > widget.getSize().getWidth(), "Размер блока не изменился после ресайза");
    }

    @Step("Проверяется, что размер блока не изменился")
    public void checkBlockSizeIsNotChanged(WebElement widget) {
        postponedAssertTrue(oldSizeWidget == widget.getSize().getWidth(), "Размер блока изменился после ресайза");
    }

    @Step("Проверяется, что заголовок блока отображается с ссылкой на кодекс")
    public void checkTitleIsLink(WebElement widget) {
        WebElement title = findElementByNoThrow(widget, By.cssSelector("h3.widget__title a"));
        postponedAssertTrue(title != null && title.getAttribute("href").contains("/document/99/"),
                "Заголовок блока не является ссылкой и не ведет на документ из модуля 99");
    }

    @Step("Проверяется, что Отображаются ссылки на статьи кодекса")
    public void checkLinksArePresent(WebElement widget) {
        List<WebElement> links = findElementsByNoThrow(widget, By.cssSelector("div > .list li"));
        postponedAssertTrue(links != null && links.size() > 0, "Ни одной ссылки не отображается");
        if (links != null) {
            for (WebElement item : links) {
                WebElement link = findElementByNoThrow(item, By.tagName("a"));
                postponedAssertTrue(link != null && link.isDisplayed(), "Ссылка:" + item.getText() + " не отображается");
            }
        }
    }

    @Step("Проверить, что все ссылки работают")
    public void checkLinksAreWorked(WebElement widget) {
        List<WebElement> links = findElementsByNoThrow(widget, By.cssSelector("div > .list li a"));
        List<Link> listLinks = new ArrayList<Link>();
        for (WebElement link: links) {
            String url = link.getAttribute("href");
            String header = link.getText();
            Link lLink = new Link(url, header);
            listLinks.add(lLink);
        }
        checkLinks(listLinks);
    }

    protected int getVisibleLinks(List<WebElement> links) {
        int countVisibleLinks = 0;
        for (WebElement link: links) {
            if (link.isDisplayed()) {
                countVisibleLinks++;
            }
        }
        return countVisibleLinks;
    }
}
