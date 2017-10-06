package com.actionmedia.components.widgets.recomendation;

import com.actionmedia.autotest.selenium.annotations.Wait;
import com.actionmedia.base.BasePage;
import com.actionmedia.components.Link;
import com.actionmedia.components.widgets.Widget;
import com.actionmedia.pages.helpers.SearchResultHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel on 18/02/16.
 */
@Component
public class LawBaseWidget extends Widget {

    @FindBy(id = "widget-law")
    @Wait
    @CacheLookup
    private WebElement widget;

    private final String[] BSSCodes = {"Налоговый", "Гражданский", "Процессуальный", "Семейный", "Трудовой", "КоАП", "Жилищный", "Уголовный"};
    private final String[] BSSCodes_BU = {"Налоговый", "Гражданский", "Бюджетный", "Семейный", "Трудовой", "КоАП", "Жилищный", "Уголовный"};
    private final String[] GFCodes = {"Налоговый", "Гражданский", "Бюджетный", "Семейный", "Трудовой", "КоАП", "Жилищный", "Уголовный"};
    private final String[] KSSCodes = {"Налоговый", "Гражданский", "Процессуальный", "Семейный", "Трудовой", "КоАП", "Жилищный", "Уголовный"};
    private final String[] FSSCodes = {"Налоговый", "Уголовный", "Гражданский", "КоАП", "Трудовой", "Бюджетный"};
    private final String[] EDUCodes = {"Закон об образовании", "ФГОС дошкольный", "ФГОС начальный", "ФГОС основной"};
    private final String[] USSCodes = {"Гражданский", "Налоговый", "КоАП", "Уголовный", "АПК", "ГПК", "Трудовой", "КАС"};
    private final String[] GOCodes = {"Гражданский", "Бюджетный", "КоАП", "Налоговый", "Градостроительный", "АПК", "Трудовой"};
    private final String[] ELPUCodes = {"ГК РФ", "ТК РФ", "ОМС", "44-ФЗ", "НК РФ", "323-ФЗ", "ПГГ", "Права потребителей"};
    private final String[] KLPUCodes = {"323-ФЗ", "СанПиН 2630-10", "Лексредства", "НСиПВ", "Медотходы", "Иммунопрофилактика", "ИЛП", "ПК"};
    private final String[] CULTCodes = {"Гражданский", "Трудовой", "О культуре", "Об автономных учреждениях", "Налоговый", "КоАП", "О НКО"};
    private final String[] UMDCodes = {"Жилищный", "Гражданский", "КоАП РФ", "Налоговый", "Градостроительный", "Трудовой", "Уголовный", "Семейный"};

    @Step("Проверяется что виджет Правовая база отображается")
    public void checkWidgetIsPresent() {
        postponedAssertTrue(widget.isEnabled() && widget.isDisplayed(), "Виджет Правовая база не отображается");
    }

    @Step("Проверяется контент в блоке 'Правовая база'")
    public void checkContentIsPresent() {
        if (widget != null) {
            WebElement header = widget.findElement(getSettings().isRunKss() ? By.tagName("h3") : By.cssSelector(".title a"));
            String widgetName = header.getText();
            postponedAssertFalse(widgetName.isEmpty(), "Отсутствует заголовок виджета для '" + widget.getAttribute("class") + "'");

            WebElement update = findElementByNoThrow(widget, By.cssSelector(".widget-update"));
            if (update != null) {
                postponedAssertFalse(update.getText().isEmpty(), "Отсутствует текст для количества новых документов в блоке 'Правовая база'");
            }

            List<WebElement> contentList = widget.findElements(By.tagName("li"));
            postponedAssertFalse(contentList.isEmpty(), "Отсутствует контент в блоке 'Правовая база'");
            for (WebElement content : contentList) {
                if (getSettings().isRunKss()) {
                    String contentName = content.getText();
                    WebElement contentLink = findElementByNoThrow(content, By.tagName("a"));
                    postponedAssertNotNull(contentLink, "Отсутствует ссылка для '" + contentName + "' в блоке 'Правовая база'");
                } else {
                    WebElement contentLink = findElementByNoThrow(content, By.tagName("a"));
                    postponedAssertNotNull(contentLink, "Отсутствует ссылка для одного из документов в блоке 'Правовая база'");

                    WebElement img = findElementByNoThrow(content, By.tagName("img"));
                    postponedAssertNotNull(img, "Отсутствует картинка для одного из документов в блоке 'Правовая база'");
                }
            }
        } else {
            setPostponedTestFail("Блок 'Правовая база' не найден");
        }
    }

    @Step("Проверяется, что отображается заголовок виджета")
    public void checkTitleIsPresent() {
        WebElement title = findElementByNoThrow(widget, By.cssSelector(".widget__title-text"));
        String titleText = "Правовая база";
        postponedAssertEquals(title.getText(), titleText, "Текст в заголовке виджета указан неверно");
    }

    @Step("Проверяется, что отображается поисковая строка")
    public void checkSearchInputIsPresent() {
        WebElement searchInput = findElementByNoThrow(widget, By.id("widget-search--text"));
        postponedAssertTrue(searchInput.isDisplayed(), "Поисковая строка не отображена в виджете");
    }

    @Step("Проверяется, что отображается количество новых документов в виджете")
    public void checkNewDocumentCounterIsPresent() {
        WebElement counter = findElementByNoThrow(widget, By.cssSelector(".widget__update"));
        postponedAssertTrue(counter.isDisplayed(), "Количество новых документов в виджете не отображается");
    }

    @Step("Проверяется, что отображаются ссылки на кодексы и они расположены в нужном порядке")
    public void checkCodes() {
        List<WebElement> codesList = widget.findElements(By.tagName("li"));
        String[] expectedCodes;
        if (getSettings().isRunBss()) {
            if (getCurrentUrl().contains("bu.") || getCurrentUrl().contains("budget.")) {
                expectedCodes = BSSCodes_BU;
            } else {
                expectedCodes = BSSCodes;
            }
        } else if (getSettings().isRunKss()) {
            expectedCodes = KSSCodes;
        } else if (getSettings().isRunGf()) {
            expectedCodes = GFCodes;
        } else if (getSettings().isRunUss()){
            expectedCodes = USSCodes;
        } else if (getSettings().isRunFss()){
            expectedCodes = FSSCodes;
        } else if (getSettings().isRunEdu()){
            expectedCodes = EDUCodes;
        } else if (getSettings().isRunGo()){
            expectedCodes = GOCodes;
        } else if (getSettings().isRunElpu()){
            expectedCodes = ELPUCodes;
        } else if (getSettings().isRunKlpu()){
            expectedCodes = KLPUCodes;
        } else if (getSettings().isRunCult()){
            expectedCodes = CULTCodes;
        } else if (getSettings().isRunUmd()){
            expectedCodes = UMDCodes;
        } else {
            expectedCodes = BSSCodes;
        }
        for (int i = 0; i < codesList.size(); i++) {
            postponedAssertEqualsText(codesList.get(i), expectedCodes[i]);
        }
    }

    @Step("Проверяется работа ссылок кодексов правовой базы")
    public void checkLinksCodes() {
        List<WebElement> lawItemList = widget.findElements(By.tagName("li"));
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement lawItem : lawItemList) {
            String url = lawItem.findElement(By.tagName("a")).getAttribute("href");
            String header = lawItem.findElement(By.tagName("a")).getText();
            Link link = new Link(url, header);
            linkList.add(link);
        }
        checkLinks(linkList);
    }

    @Step("Проверяется работа ссылки заголовка Правовая база")
    public void clickLinkTitle() {
        WebElement title = findElementByNoThrow(widget, By.cssSelector(".widget__title-text"));
        title.click();
    }

    @Step("Проверяется работа ссылки Новых документов")
    public void clickLinkNewDocumentCounter() {
        WebElement counter = findElementByNoThrow(widget, By.cssSelector(".widget__update"));
        counter.click();
    }

    @Step("Проверяется работа ссылки Кнопка Enter")
    public void clickLinkEnterIconOnSearchInput() {
        WebElement icon = findElementByNoThrow(widget, By.cssSelector("form > [type='submit']"));
        icon.click();
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
    }

    @Step("Проверить, что нажатие на подсказку в поисковых результатах открывает страницу Правовой базы с выбранным запросом")
    public void clickSearchResultsRandomHintLink() {
        WebElement searchResultList = findElementByNoThrow(widget, By.cssSelector("form > ul"));
        postponedAssertTrue(searchResultList.isDisplayed(), "Поисковые подсказки не появились");
        List<WebElement> menuItems = findElementsByNoThrow(searchResultList, By.xpath("./li[not(contains(@class,'hint-doc'))]"));
        postponedAssertFalse(menuItems.isEmpty(), "Обычные подсказки не найдены");
        WebElement randomHint = getRandomElementInList(menuItems);
        setParameter(SearchResultHelper.HINT_TEXT, randomHint.getText());
        randomHint.click();
    }
}
