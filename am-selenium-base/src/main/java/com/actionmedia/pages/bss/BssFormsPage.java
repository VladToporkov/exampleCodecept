package com.actionmedia.pages.bss;

import com.actionmedia.components.Link;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.helpers.FormsPageHelper;
import com.actionmedia.pages.interfaces.IFormsPage;
import com.actionmedia.util.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.*;

/**
 * User: n.tyukavkin
 * Date: 11.10.13
 * Time: 9:35
 */
@Component
public class BssFormsPage extends BssBasePage<BssFormsPage> implements IFormsPage {

    @Step("Проверяются элементы на странице 'Формы'")
    public BssFormsPage checkDefaultStateFormsPage() {
        checkFormsTabIsSelected();
        checkSearchBoxPresentOnFormsPage();
        checkNewsBlockIsPresent();
        checkPopularBlocksIsPresent();
        checkFormPictureIsPresent();
        checkFormsRubricatorButtonIsPresent();
        checkMyFavoritesRubricatorButtonIsPresent();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Формы'")
    public BssFormsPage checkFormsTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.FORMS);
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Формы'")
    public BssFormsPage checkSearchBoxPresentOnFormsPage() {
        checkSearchBoxIsPresent("Поиск форм и образцов");
        return this;
    }

    @Step("Проверяется блок 'Новое' на странице 'Формы'")
    public BssFormsPage checkNewsBlockIsPresent() {
        List<WebElement> newBlocks = findElementsBy(By.cssSelector("[class*='changes']"));
        postponedAssertFalse(newBlocks.isEmpty(), "Блок Новое Отсутствует");
        return this;
    }

    @Step("Проверяется блок 'Популярное' на странице 'Формы'")
    public BssFormsPage checkPopularBlocksIsPresent() {
        List<WebElement> popularBlocks = sidebarElement.findElements(By.cssSelector(".news__item"));
        postponedAssertFalse(popularBlocks.isEmpty(), "Блок Популярное пустой");
        return this;
    }

    @Step("Проверяется что картинка для новой формы отображается")
    public BssFormsPage checkFormPictureIsPresent() {
        WebElement formPicture = findElementByNoThrow(mainLeftElement, By.cssSelector("[class*='form-']"));
        postponedAssertTrue(formPicture != null && formPicture.isDisplayed(), "Картинка с формой не отображается");
        return this;
    }

    @Step("Проверяется что кнопка рубрикатора форм отображается")
    public BssFormsPage checkFormsRubricatorButtonIsPresent() {
        WebElement rubricatorButton = waitForPresenceOfElementLocatedBy(By.id("rubricator-btn"), "Кнопка Все формы не отображается");
        postponedAssertEquals(rubricatorButton.getText(), "Все формы", "Неправильный текст кнопки Все формы");
        return this;
    }

    @Step("Проверяется работа скролла в блоке Новое")
    public BssFormsPage checkNewsBlockScrolling() {
        List<WebElement> newsBeforeScroll = mainLeftElement.findElements(By.cssSelector(".block-changes"));
        postponedAssertFalse(newsBeforeScroll.isEmpty(), "Блок Новое пустой");

        scroll(Period.month, By.cssSelector(".main__in h2"), 1);

        List<WebElement> newsAfterScroll = mainLeftElement.findElements(By.cssSelector(".block-changes"));
        postponedAssertTrue(newsAfterScroll.size() > newsBeforeScroll.size(), "Новости не подгружаются после скролла");
        return this;
    }

    @Step("Проверяется сортировка новостей")
    public BssFormsPage checkDateAreSortedDescending() {
        List<WebElement> dateListElement = mainLeftElement.findElements(By.tagName("h2"));
        dateListElement.remove(0);
        postponedAssertThat(dateListElement, TestUtils.sortedDatesWithoutYearInDescendingOrder(), "Элементы отсортированы в неправильном порядке");
        return this;
    }

    @Step("Проверяется что новости не повторяются")
    public BssFormsPage checkNewsBlockAreNotRepeat() {
        List<WebElement> elementList = mainLeftElement.findElements(By.tagName("*"));
        Map<String, List<String>> newsBlockMap = new HashMap<String, List<String>>();
        for (int i = 0; i < elementList.size(); i++) {
            if ("h2".equals(elementList.get(i).getTagName())) {
                String date = elementList.get(i).getText();
                List<String> newsBlockForDate = new ArrayList<String>();
                while (i + 1 < elementList.size() && !"h2".equals(elementList.get(i + 1).getTagName())) {
                    if (elementList.get(i).getAttribute("class") != null && elementList.get(i).getAttribute("class").contains("block-changes")) {
                        newsBlockForDate.add(elementList.get(i).getText());
                    }
                    i++;
                }
                postponedAssertFalse(newsBlockMap.containsValue(newsBlockForDate), "Блок новостей за '" + date + "' повторяется");
                newsBlockMap.put(date, newsBlockForDate);
            }
        }
        return this;
    }

    @Step("Проверяется работа ссылки для последней формы")
    public BssFormsPage checkLinkForLastForm() {
        WebElement newsElement = mainLeftElement.findElement(By.cssSelector(".block-changes"));
        String url = newsElement.findElement(By.tagName("a")).getAttribute("href");
        String header = newsElement.findElement(By.cssSelector(".b-changes-item-name")).findElement(By.tagName("a")).getText();
        Link link = new Link(url, header);
        checkLinks(Arrays.asList(link));
        return this;
    }

    @Step("Проверяется работа ссылок из блока Популярное")
    public BssFormsPage checkLinksFromPopularBlock() {
        List<WebElement> formElementList = sidebarElement.findElements(By.cssSelector(".forms"));
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement formElement : formElementList) {
            WebElement formLink = formElement.findElement(By.tagName("a"));
            String url = formLink.getAttribute("href");
            String header = formLink.getText();
            Link link = new Link(url, header);
            linkList.add(link);
        }
        checkLinks(linkList);
        return this;
    }

    @Step("Проверяется работа ссылок из блока Новое")
    public BssFormsPage checkLinksFromNewsBlock() {
        List<WebElement> newsElementList = mainLeftElement.findElements(By.cssSelector(".block-changes"));
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement newsElement : newsElementList) {
            WebElement newsLink;
            if (newsElement.getAttribute("class").contains("large")) {
                newsLink = newsElement.findElement(By.cssSelector(".b-changes-item-name")).findElement(By.tagName("a"));
            } else {
                newsLink = newsElement.findElement(By.tagName("a"));
            }
            String url = newsLink.getAttribute("href");
            String header = newsLink.getText();
            Link link = new Link(url, header);
            linkList.add(link);
        }
        checkLinks(linkList);
        return this;
    }

    @Step("Открыть любую Форму из рубрикатора форм")
    public BssDocumentPage openRandomForm() {
        waitForPresenceOfElementLocatedBy(By.id("rubricator-btn")).click();
        waitForVisibilityOfElementLocatedBy(By.id("rubricator"), "Рубрикатор не найден");
        List<WebElement> links = waitForPresenceOfElementLocatedBy(By.cssSelector(".b-rubricator-list")).findElements(By.tagName("li"));
        getRandomElementInList(links).findElement(By.tagName("a")).click();

        WebElement content = waitForPresenceOfElementLocatedBy(By.id("rubricator-right"));
        WebElement link = getRandomElementInList(content.findElements(By.tagName("li"))).findElement(By.tagName("a"));

        String currentUrl = getCurrentUrl();
        String linkUrl = link.getAttribute("href");

        report("Открыта страница: " + currentUrl);
        report("Открывается ссылка: " + linkUrl);

        link.click();
        return redirectTo(BssDocumentPage.class);
    }

    @Step("Открыть любой документ из рубрикатора")
    public BssDocumentPage openModuleByNumber(String moduleNumber) {
        waitForPresenceOfElementLocatedBy(By.id("rubricator-btn")).click();
        waitForVisibilityOfElementLocatedBy(By.id("rubricator"), "Рубрикатор не найден");
        List<WebElement> links = waitForPresenceOfElementLocatedBy(By.cssSelector(".b-rubricator-list")).findElements(By.tagName("li"));
        for (WebElement section : links) {
            section.findElement(By.tagName("a")).click();
            WebElement content = waitForPresenceOfElementLocatedBy(By.id("rubricator-right"));
            List<WebElement> documentLinkList = content.findElements(By.tagName("li"));
            for (WebElement documentLink : documentLinkList) {
                WebElement link = documentLink.findElement(By.tagName("a"));
                String linkUrl = link.getAttribute("href");
                if (linkUrl.contains("/document/" + moduleNumber)) {
                    String currentUrl = getCurrentUrl();
                    report("Открыта страница: " + currentUrl);
                    report("Открывается ссылка: " + linkUrl);
                    link.click();
                    return redirectTo(BssDocumentPage.class);
                }
            }
        }
        fail("Не найден " + moduleNumber + " модуль");
        return redirectTo(BssDocumentPage.class);
    }

    @Step("Открыть последнюю Форму в Новом по клику на картинку Бланка.")
    public BssDocumentPage clickLastForm() {
        WebElement lastForms = mainContentElement.findElement(By.cssSelector(".form-float"));
        lastForms.click();
        return redirectTo(BssDocumentPage.class);
    }

    @Step("Открыть случайную форму из популярного.")
    public BssDocumentPage clickRandomFormFromPopularBlock() {
        WebElement popularBlock = mainContentElement.findElement(By.id("sidebar"));
        List<WebElement> formsList = popularBlock.findElements(By.cssSelector("[href*='/#/document']"));
        List<WebElement> newFormList = new ArrayList<WebElement>();
        for (WebElement form : formsList) {
            if (form.isDisplayed()) {
                newFormList.add(form);
            }
        }
        getRandomElementInList(newFormList).click();
        return redirectTo(BssDocumentPage.class);
    }

    @Step("Открыть случайную форму из Новостей.")
    public BssDocumentPage clickRandomFormFromNewsBlock() {
        List<WebElement> formsList = mainLeftElement.findElements(By.cssSelector("[href*='/#/document']"));
        getRandomElementInList(formsList).click();
        return redirectTo(BssDocumentPage.class);
    }

    @Override
    public BssFormsPage checkTitle(String titleName) {
        getHelper(FormsPageHelper.class).checkTitle(titleName);
        return this;
    }

    @Override
    public BssFormsPage checkNewsBlocksArePresent() {
        getHelper(FormsPageHelper.class).checkNewsBlocksArePresent();
        return this;
    }

    @Override
    public BssFormsPage checkNewsBlocksTitlesArePresent() {
        getHelper(FormsPageHelper.class).checkNewsBlocksTitlesArePresent();
        return this;
    }

    @Override
    public BssFormsPage checkNewsBlocksDatesSortedInDescendingOrder() {
        getHelper(FormsPageHelper.class).checkNewsBlocksDatesSortedInDescendingOrder();
        return this;
    }

    @Override
    public BssFormsPage checkNewsBlocksHaveTitleAndDescription() {
        getHelper(FormsPageHelper.class).checkNewsBlocksHaveTitleAndDescription();
        return this;
    }

    @Override
    public BssFormsPage checkPictureForFirstNewsIsPresent() {
        getHelper(FormsPageHelper.class).checkPictureForFirstNewsIsPresent();
        return this;
    }

    @Override
    public BssFormsPage checkNewsLoadedAfterScrollingDown() {
        getHelper(FormsPageHelper.class).checkNewsLoadedAfterScrollingDown();
        return this;
    }

    @Override
    public BssDocumentPage clickOnRandomLinkFromNewsBlock() {
        getHelper(FormsPageHelper.class).clickOnRandomLinkFromNewsBlock();
        return redirectTo(BssDocumentPage.class);
    }

    @Override
    public BssFormsPage checkPopularBlockIsPresent() {
        getHelper(FormsPageHelper.class).checkPopularBlockIsPresent();
        return this;
    }

    @Override
    public BssFormsPage checkPopularBlockDocumentLinksArePresent() {
        getHelper(FormsPageHelper.class).checkPopularBlockDocumentLinksArePresent();
        return this;
    }

    @Override
    public BssFormsPage checkPopularBlockMarkersArePresent() {
        getHelper(FormsPageHelper.class).checkPopularBlockMarkersArePresent();
        return this;
    }

    @Override
    public BssDocumentPage clickOnRandomLinkFromPopularBlock() {
        getHelper(FormsPageHelper.class).clickOnRandomLinkFromPopularBlock();
        return redirectTo(BssDocumentPage.class);
    }
}
