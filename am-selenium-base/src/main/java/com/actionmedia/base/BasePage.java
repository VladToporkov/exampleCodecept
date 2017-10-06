package com.actionmedia.base;

import com.actionmedia.autotest.selenium.SeleniumHolder;
import com.actionmedia.autotest.selenium.annotations.ErrorMessage;
import com.actionmedia.autotest.selenium.annotations.Wait;
import com.actionmedia.autotest.selenium.context.AbstractPage;
import com.actionmedia.autotest.selenium.context.ComponentProvider;
import com.actionmedia.autotest.selenium.context.Login;
import com.actionmedia.autotest.selenium.elements.TextField;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.components.Link;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.components.popups.PredemoPopup;
import com.actionmedia.components.widgets.YellowPanel;
import com.actionmedia.components.widgets.recomendation.FormsWidget;
import com.actionmedia.components.widgets.recomendation.LawBaseWidget;
import com.actionmedia.pages.ExtendedSearchForm;
import com.actionmedia.pages.LoginPage;
import com.actionmedia.pages.helpers.BackLinksHelper;
import com.actionmedia.pages.helpers.CheckDocumentHelper;
import com.actionmedia.pages.helpers.SearchResultHelper;
import com.actionmedia.pages.interfaces.IBasePage;
import com.actionmedia.util.TestUtils;
import com.actionmedia.webservice.MessageElementConverter;
import com.actionmedia.webservice.NodeElement;
import com.actionmedia.webservice.ServiceResponse;
import com.actionmedia.webservice.glavbuch.GlavbukhLocator;
import com.actionmedia.webservice.glavbuch.GlavbukhSoap_PortType;
import com.actionmedia.webservice.searchservice.ISearchService;
import com.actionmedia.webservice.searchservice.SearchServiceLocator;
import org.apache.axis.message.MessageElement;
import org.apache.axis.types.UnsignedByte;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.rmi.RemoteException;
import java.util.*;
import java.util.logging.Level;

public class BasePage<P extends BasePage> extends AbstractPage<P> implements ComponentProvider, IBasePage {

    public static final String QUERY_URL = "query.url";
    @FindBy(id = "header")
    @Wait
    @CacheLookup
    @ErrorMessage("Не найден элемент с id=header")
    protected WebElement headerElement;

    @FindBy(id = "main-container")
    @Wait
    @CacheLookup
    @ErrorMessage("Не найден элемент с id=main-container")
    protected WebElement mainContentElement;

    @FindBy(id = "main-left")
    @Wait
    @CacheLookup
    @ErrorMessage("Не найден элемент с id=main-left")
    protected WebElement mainLeftElement;

    @FindBy(id = "sidebar")
    @Wait
    @CacheLookup
    @ErrorMessage("Не найден элемент с id=sidebar")
    protected WebElement sidebarElement;

    @FindBy(css = ".btn_type_search")
    @Wait
    protected WebElement searchButton;

    @FindBy(id = "search-text")
    @Wait
    protected TextField searchBox;

    @FindBy(id = "sd-num")
    @Wait
    protected TextField numberField;
    public final int scrollWidth = 34;

    protected static final By DOCUMENT_LOCATOR = By.cssSelector("[href*='#/']");
    protected static final int DOCUMENT_LOCATION = 800;
    protected final Log logger = LogFactory.getLog(getClass());
    protected ExtendedSearchForm extendedSearchForm;
    private static final long TIME_TO_SCROLL = 10000;
    private List<String> checkDocUrlList = new ArrayList<String>();

    private final String directLinkTooltip = "directLinkTooltip";

    public static long timeOperation;

    protected static final ThreadLocal<Login> login = new ThreadLocal<Login>();

    private static Map<String, String> EXCLUDE_RUBRICATOR_NAMES_FROM_YELLOW_PLATE;

    static {
        EXCLUDE_RUBRICATOR_NAMES_FROM_YELLOW_PLATE = new HashMap<String, String>();
        EXCLUDE_RUBRICATOR_NAMES_FROM_YELLOW_PLATE.put("Налоги", "Налоги и взносы");
        EXCLUDE_RUBRICATOR_NAMES_FROM_YELLOW_PLATE.put("Изменения в законодательстве", "Изменения в законах и практике");
    }

    @Override
    public void handleRedirect() {
        super.handleRedirect();
        extendedSearchForm = getHelper(ExtendedSearchForm.class, this);
    }

    protected <T extends AbstractPage> T navigateToBasePage(final Class<T> target) {
        return navigateTo(target);
    }

    public <T extends AbstractPage> T navigateToBasePage(final Login loginParameter, final Class<T> target) {
        maximize();
        this.login.set(loginParameter);
        return navigateTo(target, loginParameter.getUrl());
    }

    public <T extends AbstractPage> T navigateToBasePageSizeWindow(final Login loginParameter, final Class<T> target) {
        return navigateTo(target, loginParameter.getUrl());
    }

    @Step("Delete cookies")
    public P deleteCookies() {
        try {
            getDriver().manage().deleteAllCookies();
            waitFewSecond(1000);
        } catch (Exception e) {
            logger.error("Delete all cookies with errors", e);
            System.out.println("Delete all cookies with errors");
        }
        return (P) this;
    }

    @Step
    public LoginPage reloadPage() {
        try {
            getDriver().navigate().refresh();
        } catch (Exception e) {
            logger.error("Delete all cookies with errors", e);
            System.out.println("Delete all cookies with errors");
        }
        return redirectToWithoutWait(LoginPage.class);
    }

    public String getCurrentHost() {
        return getSettings().getHost();
    }

    protected void maximize() {
        if (!"opera".equals(SeleniumHolder.getDriverName())) {
            try {
                getDriver().manage().window().maximize();
            } catch (WebDriverException ignored) {
            }
        }
    }

    public P setSizeWindows(int width, int height) {
        getDriver().manage().window().setSize(new Dimension(width + scrollWidth, height));
        return (P) this;
    }

    protected void mouseClick(WebElement element) {
        Actions builder = new Actions(getDriver());
        Action actionClick = builder.moveToElement(element).click().build();
        actionClick.perform();
    }

    protected void moveMouseToElement(final WebElement element) {
        Actions builder = new Actions(getDriver());
        builder
                .moveToElement(element)
                .build()
                .perform();
    }

    protected boolean isUserLogged() {
        WebElement header = waitForVisibilityOfElementLocatedBy(By.id("header"), "Заголовок не найден");
        WebElement loginBtn = findElementByNoThrow(header, By.id("user-enter"));
        return loginBtn != null && !loginBtn.getText().equals("Вход и регистрация") && !loginBtn.getText().equals("Вхід і реєстрація");
    }

    @Step("Проскроллить результаты до конца")
    public P scrollToEnd() {
        scroll();
        return (P) this;
    }

    @Step("Проскроллить результаты до конца")
    public P scrollToStart() {
        executeScript("window.scrollTo(" + 0 + ", " + 0 + "); return true;");
        return (P) this;
    }

    @Step("Проскроллить результаты несколько раз")
    public P scrollSeveralTimes(int times) {
        scroll(times);
        return (P) this;
    }

    protected void scroll() {
        boolean readyStateComplete = false;
        Long last = 0L;
        while (!readyStateComplete) {
            waitFewSecond(1500);
            Long current = (Long) executeScript("return document.body.scrollHeight;");
            executeScript("window.scrollTo(" + 0 + ", " + current + "); return true;");
            readyStateComplete = last.equals(current);
            last = current;
        }
    }

    protected void scroll(int iterator) {
        int i = 0;
        while (i < iterator) {
            waitFewSecond(200);
            scrollScript();
            i++;
        }
        findElementBy(By.cssSelector("[class*='footer']")).click();
    }

    protected void scroll(Period period, By dateElementLocator) {
        reportPeriod(period);
        long startTime = new Date().getTime();
        do {
            scrollScript();
            if (new Date().getTime() - startTime > TIME_TO_SCROLL) {
                break;
            }
        } while (!isPeriodCome(period, dateElementLocator));
    }

    protected void scroll(Period period, By dateElementLocator, int dateElementStartIndex) {
        reportPeriod(period);
        long startTime = new Date().getTime();
        do {
            scrollScript();
            if (new Date().getTime() - startTime > TIME_TO_SCROLL) {
                break;
            }
        } while (!isPeriodCome(period, dateElementLocator, dateElementStartIndex));
    }

    public void scrollScript() {
        Long current = (Long) executeScript("return document.body.scrollHeight;");
        executeScript("window.scrollTo(" + 0 + ", " + current + "); return true;");
        try {
            waitForInvisibilityOfElementLocatedBy(By.cssSelector("[class*='load']"));
        } catch (StaleElementReferenceException e) {
            logger.error("StaleElementReferenceException occurs", e);
        } catch (TimeoutException e) {
            logger.error("TimeoutException occurs", e);
        }
    }

    public void scrollScript(int y) {
        executeScript("window.scrollBy(" + 0 + ", " + y + "); return true;");
    }

    private void reportPeriod(Period period) {
        if (period.equals(Period.week)) {
            report("Проскроллить на одну неделю назад");
        } else if (period.equals(Period.twoWeeks)) {
            report("Проскроллить на две недели назад");
        } else if (period.equals(Period.month)) {
            report("Проскроллить на один месяц назад");
        } else if (period.equals(Period.twoMonth)) {
            report("Проскроллить на два месяца назад");
        } else if (period.equals(Period.threeMonth)) {
            report("Проскроллить на три месяца назад");
        } else if (period.equals(Period.sixMonth)) {
            report("Проскроллить на шесть месяцев назад");
        } else if (period.equals(Period.year)) {
            report("Проскроллить на один год назад");
        }
    }

    private boolean isPeriodCome(Period period, By dateElementLocator) {
        List<WebElement> dateElementList = waitForPresenceOfAllElementsLocatedBy(dateElementLocator);

        String fistDateString = dateElementList.get(0).getText();
        Date firstDate = TestUtils.parseDate(fistDateString, "dd MMM");

        for (int i = 1; i < dateElementList.size(); i++) {
            String lastDateString = dateElementList.get(i).getText();
            Date lastDate = TestUtils.parseDate(lastDateString, "dd MMM");
            if (lastDate != null && (firstDate.getTime() - lastDate.getTime() >= period.getPeriod() * 1000)) {
                return true;
            }
        }

        String lastDateString = dateElementList.get(dateElementList.size() - 2).getText();
        Date lastDate = TestUtils.parseDate(lastDateString, "dd MMM");

        return isCycle(dateElementList) ||
                firstDate.getTime() - lastDate.getTime() >= period.getPeriod() * 1000 ||
                isFirstAndLastMonth(fistDateString, lastDateString) == -1;
    }

    private boolean isPeriodCome(Period period, By dateElementLocator, int dateElementStartIndex) {
        List<WebElement> dateElementList = waitForPresenceOfAllElementsLocatedBy(dateElementLocator);

        String fistDateString = dateElementList.get(dateElementStartIndex).getText();
        Date firstDate = TestUtils.parseDate(fistDateString, "dd MMM");

        for (int i = dateElementStartIndex + 1; i < dateElementList.size(); i++) {
            String lastDateString = dateElementList.get(i).getText();
            Date lastDate = TestUtils.parseDate(lastDateString, "dd MMM");
            if (lastDate != null && (firstDate.getTime() - lastDate.getTime() >= period.getPeriod() * 1000)) {
                return true;
            }
        }

        String lastDateString = dateElementList.get(dateElementList.size() - 2).getText();
        Date lastDate = TestUtils.parseDate(lastDateString, "dd MMM");

        return isCycle(dateElementList) ||
                firstDate.getTime() - lastDate.getTime() >= period.getPeriod() * 1000 ||
                isFirstAndLastMonth(fistDateString, lastDateString) == -1;
    }

    private boolean isCycle(List<WebElement> dateElementList) {
        List<String> dateList = new ArrayList<String>();
        for (WebElement dateElement : dateElementList) {
            String dateElementString = dateElement.getText();
            if (dateList.contains(dateElementString)) {
                return true;
            }
            dateList.add(dateElementString);
        }
        return false;
    }

    private int isFirstAndLastMonth(String fistDateString, String lastDateString) {
        int monthCompare;
        int dayCompare;

        String[] dateArr1 = fistDateString.split(" ");
        String[] dateArr2 = lastDateString.split(" ");

        String month1 = "";
        String month2 = "";

        int day1 = 0;
        int day2 = 0;

        for (String date : dateArr1) {
            if (TestUtils.isNumber(date)) {
                day1 = TestUtils.getNumberFromString(date);
            } else {
                month1 = date;
            }
        }

        for (String date : dateArr2) {
            if (TestUtils.isNumber(date)) {
                day2 = TestUtils.getNumberFromString(date);
            } else {
                month2 = date;
            }
        }

        int montIndex1 = TestUtils.DateWithoutYearComparator.MonthsOrder.fromString(month1).ordinal();
        int montIndex2 = TestUtils.DateWithoutYearComparator.MonthsOrder.fromString(month2).ordinal();

        dayCompare = Integer.valueOf(day2).compareTo(day1);

        if (montIndex2 == 12 && montIndex1 == 0) {
            monthCompare = -1;
        } else {
            monthCompare = Integer.valueOf(montIndex2).compareTo(montIndex1);
        }

        if (monthCompare < 0) {
            return dayCompare;
        } else if (monthCompare == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    protected void clickAboutSystemLinkBase() {
        WebElement aboutSystemLink = waitForVisibilityOfElementLocatedBy(By.cssSelector("[href*='/about/']"), "Ссылка 'О системе' не найдена");
//        BrowserMobProxy proxyServer = SeleniumHolder.getServer();
        String linkUrl = aboutSystemLink.getAttribute("href");
//        proxyServer.newHar(linkUrl);
        aboutSystemLink.click();
//        List<HarEntry> harEntryList = proxyServer.getHar().getLog().getEntries();
//        for (HarEntry harEntry : harEntryList) {
//            if (harEntry.getPageref().equals(linkUrl)) {
//                int status = harEntry.getResponse().getStatus();
//                String url = harEntry.getRequest().getUrl();
//                if (status != -999 && status != -998) {
//                    if (!isCorrectResponseCode(status) && !url.contains("/survey/") && !url.contains("/signalr/") && !url.contains("preview_type_videos-play.png") && !url.contains("author-mask.png")) {
//                        setPostponedTestFail("Incorrect http status code: " + status + " url: <a href=" + url + ">" + url + "</a>\n");
//                    }
//                }
//            }
//        }
    }

    protected void clickNewsPageBase() {
        waitForPresenceOfElementLocatedBy(By.cssSelector(".news [href*='/#/news/']"), "Ссылка на новостной блок не найдена").click();
    }

    @Step("Открыть Меню Мое Избранное")
    public P clickMyFavoritesButton() {
        WebElement favoritesButton = findElementBy(By.id("favorites-btn"), "Кнопка Избранное не найдена на странице");
        favoritesButton.click();
        waitForReloadingPage();
//        waitForVisibilityOfElementLocatedBy(By.id("favorites-btn"), "Кнопка 'Мое Избранное' не отображается").click();
//        WebElement favoritesMenu = waitForVisibilityOfElementLocatedBy(By.cssSelector("[class*='bookmarks-content']"), "Меню 'Мое избранное' не открыто");
//        waitForTextToBePresentIn(favoritesMenu, "Избранное");
        return (P) this;
    }

    @Step("Нажать кнопку Найти")
    public P clickSearchButton() {
        if (getSettings().isRunFss()) {
            waitForPresenceOfElementLocatedBy(By.xpath(".//form[@id='search-form']/input[@value='Найти']")).click();
        } else {
            waitForPresenceOfElementLocatedBy(By.cssSelector(".btn_type_search")).click();
        }
        waitForReloadingPage();
        try {
            waitForPresenceOfElementLocatedBy(By.cssSelector(".search-result"));
        } catch (WebDriverException e) {
        }
        return (P) this;
    }

    @Step("Ввести текст в строку поиска")
    public P inputTextInSearchBox(String query) {
        searchBox.clearAndType(query);
        setParameter(SearchResultHelper.HINT_TEXT, query);
        return (P) this;
    }

    @Step("Ввести в поисковую строку запрос")
    public P inputQueryInSearchBox(String query) {
        WebElement searchText = findElementBy(By.id("search-text"));
        searchText.clear();
        searchText.sendKeys(query);
        return (P) this;
    }

    @Step("Ввести текст в строку поиска")
    public P inputTextInSearchBoxForSearchInText(String query) {
        searchBox.clearAndType(query);

        //Workaround for search in text checks
        WebElement search = waitForPresenceOfElementLocatedBy(By.id("search-text"));
        search.sendKeys(Keys.BACK_SPACE);
        search.sendKeys(Keys.BACK_SPACE);
        search.sendKeys(Keys.BACK_SPACE);
        searchBox.clearAndType(query);
        setParameter(SearchResultHelper.HINT_TEXT, query);
        return (P) this;
    }

    @Step("Очистить строку поиска")
    public P clearSearchBox() {
        searchBox.clear();
        return (P) this;
    }

    @Step("Нажать на заголовок документа")
    public P clickHeader() {
        clickUseJS(waitForVisibilityOfElementLocatedBy(By.id("header"), "Заголовок документа не найден"));
        return (P) this;
    }

    @Step("Проверяется работа строки поиска")
    public P checkTextInputInSearchBox() {
        searchBox.clear();
        postponedAssertTrue(searchBox.getText().isEmpty(), "Строка поиска не пустая после очистки");

        String randomString = RandomStringUtils.randomAlphabetic(5);
        searchBox.clearAndType(randomString);
        postponedAssertEquals(searchBox.getText(), randomString, "Неправильный текст в строке поиска после ввода текста");

        searchBox.clear();
        postponedAssertTrue(searchBox.getText().isEmpty(), "Строка поиска не пустая после очистки");
        return (P) this;
    }

    public P clickOnExactPhraseOnExtendedSearchForm() {
        getHelper(SearchResultHelper.class).clickOnExactPhraseOnExtendedSearchForm();
        return (P) this;
    }

    public P switchOnInLawPracticeOnExtendedSearchForm() {
        getHelper(SearchResultHelper.class).switchOnInLawPracticeOnExtendedSearchForm();
        return (P) this;
    }

    public P switchOnInLawOnExtendedSearchForm() {
        getHelper(SearchResultHelper.class).switchOnInLawOnExtendedSearchForm();
        return (P) this;
    }

    @Step("Выбрать дополнительный аттрибут поиска Вид документа")
    public P inputViewInExtendedByName(String viewName) {
        waitForPresenceOfElementLocatedBy(By.name("sd-type")).sendKeys(viewName);
        WebElement viewFilterElement = waitForPresenceOfElementLocatedBy(By.id("typelist"));
        viewFilterElement.findElement(By.xpath("//li[text()='" + viewName + "']")).click();
        return (P) this;
    }

    @Step("Выбрать вид органа власти в дополнительных аттрибутах поиска")
    public P inputDepartmentInExtendedByName(String department) {
        waitForPresenceOfElementLocatedBy(By.name("sd-entity")).sendKeys(department);
        WebElement departmentFilterElement = waitForPresenceOfElementLocatedBy(By.id("lobbylist"));
        departmentFilterElement.findElement(By.xpath("//li[text()='" + department + "']")).click();
        return (P) this;
    }

    @Step("Ввести номер документа в дополнительных аттрибутах поиска")
    public P inputNumberInExtendedByName(String number) {
        numberField.clearAndType(number);
        return (P) this;
    }

    @Step("Очистить все дополнительные аттрибуты поиска")
    public P clearAllExtendedAttributes() {
        waitForVisibilityOfElementLocatedBy(By.id("search-clear-all"), "Кнопка 'Сбросить все' не найдена").click();
        return (P) this;
    }

    @Step("Нажать кнопку Найти в форме дополнительных аттрибутах поиска")
    protected P clickSearchExtendedButtonBase() {
        waitForVisibilityOfElementLocatedBy(By.id("button-searchd"), "Кнопка Найти в дополнительных аттрибутах поиска не найдена").click();
        return (P) this;
    }

    public void clickSearchExtendedButtonNew() {
        extendedSearchForm.clickSearchExtendedButton();
    }

    @Step("Проверяется что пользователь авторизован, в правом верхнем углу отображается его имя и фамилия")
    public P checkUserInfoLinkIsPresent() {
        WebElement header = waitForPresenceOfElementLocatedBy(By.id("header"));
        WebElement userInfoLink = findElementByNoThrow(header, By.cssSelector(".user-link"));
        postponedAssertNotNull(userInfoLink, "");
        return (P) this;
    }

    public P setStartTime(DateTime startTime) {
        startTime = new DateTime();
        return (P) this;
    }

    public P setEndTime(DateTime endTime) {
        endTime = new DateTime();
        return (P) this;
    }

    protected enum Period {
        week(604800),
        twoWeeks(1209600),
        month(2592000),
        twoMonth(5184000),
        threeMonth(7776000),
        sixMonth(15552000),
        year(31104000);

        private long period;

        private Period(long period) {
            this.period = period;
        }

        private long getPeriod() {
            return period;
        }
    }

    protected void checkElementIsDisplayed(WebElement element, String errorReport) {
        if (element != null) {
            postponedAssertTrue(element.isDisplayed(), errorReport);
        }
    }

    protected void checkTextInElement(WebElement element, String expectedText, String errorReport) {
        if (element != null) {
            postponedAssertEquals(element.getText(), expectedText, errorReport);
        }
    }

    @Step("Проверяется работа ссылок")
    public P checkLinks() {
        List<Link> linkList = new ArrayList<Link>();
        List<WebElement> linkElementList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector("[href*='/document/']"));
        for (WebElement linkElement : linkElementList) {
            if (!linkElement.getText().isEmpty()) {
                Link link = new Link(linkElement.getAttribute("href"), linkElement.getText());
                linkList.add(link);
            }
        }
        checkLinks(linkList);
        return (P) this;
    }

    @Step("Проверяется работа ссылок RSS")
    public P checkLinksRSS(int tab) {
        List<Link> linkList = new ArrayList<Link>();
        List<WebElement> linkElementList = waitForPresenceOfAllElementsLocatedBy(By.className("entry"));
        for (WebElement linkElement : linkElementList) {
            if (!linkElement.getText().isEmpty()) {
                Link link = new Link(linkElement.findElement(By.tagName("a")).getAttribute("href"));
                linkList.add(link);
            }
        }
        checkRSSLinks(linkList);

        String toOpen = getRandomElementInList(linkList).getUrl();

        //random link - open
        openUrl(toOpen);
        waitForReloadingPage();

        postponedAssertEquals(getCurrentUrl().toString(), toOpen, "Открыт не тот документ, должен " + toOpen);

        if (tab == 1) {
            postponedAssertTrue((toOpen.contains("/165/") || toOpen.contains("/131/")), "Документ не из раздела рекомендаций");
        }
        if (tab == 3) {
            postponedAssertTrue((toOpen.contains("/96/") || toOpen.contains("/97/") || toOpen.contains("/98/") || toOpen.contains("/99/")), "Документ не из раздела правовой базы");
        }
        if (tab == 7) {
            postponedAssertTrue((toOpen.contains("/118/") || toOpen.contains("/140/")), "Документ не из раздела форм");
        }
        if (tab == 10) {
            postponedAssertTrue((toOpen.contains("/184/")), "Документ не из раздела новости");
        }

        return (P) this;
    }


    @Step("Проверяется работа ссылок RSS")
    public P ossCheckLinksRSS() {
        List<Link> linkList = new ArrayList<Link>();
        List<WebElement> linkElementList = waitForPresenceOfAllElementsLocatedBy(By.className("entry"));
        for (WebElement linkElement : linkElementList) {
            if (!linkElement.getText().isEmpty()) {
                Link link = new Link(linkElement.findElement(By.tagName("a")).getAttribute("href"));
                linkList.add(link);
            }
        }
        checkRSSLinks(linkList);

        return (P) this;
    }

    @Step("Проверяется работа ссылок")
    public void checkRSSLinks(List<Link> linkList) {
        for (Link link : linkList) {
            checkRSSLink(link);
        }
    }

    @Step("Проверяется работа ссылок")
    public void checkLinks(List<Link> linkList) {
//        BrowserMobProxy proxyServer = SeleniumHolder.getServer();
        for (Link link : linkList) {
            checkLink(link);
        }
    }

    @Step("Проверяется работа ссылок")
    protected void checkLinks(List<Link> linkList, int numberOfLinksWillBeChecked) {
//        BrowserMobProxy proxyServer = SeleniumHolder.getServer();
        for (int i = 0; i < numberOfLinksWillBeChecked; i++) {
            checkLink(linkList.get(i));
        }
    }

    protected void checkLink(Link link) {
        String currentUrl = getCurrentUrl().split("\\?step=")[0];

        report("Открыта страница: " + currentUrl);
        report("Открывается ссылка: " + link.getUrl());

        openUrl(link.getUrl());
        waitForReloadingPage();

        postponedAssertTrue(getCurrentUrl().contains(link.getUrl()), "Неправильный урл открытого документа. " +
                "Ожидаемый результат: '" + link.getUrl() + "'. " +
                "Наблюдаемый результат: '" + getCurrentUrl() + "'.");

        checkEmptyDocumentHeader();
        checkEmptyDocument();
        if (getCurrentUrl().contains("#/document/170/")) {
            checkSafetyFunctionalIsPresent();
        }
        if (getCurrentUrl().contains("scheduler")) {
            openUrl(currentUrl);
        } else {
            returnToBack();
        }
    }

    protected void checkRSSLink(Link link) {
        report("Проверяется ссылка: " + link.getUrl());
        if (!link.getUrl().contains("document") && !link.getUrl().contains("from=rss")) {
            setPostponedTestFail("Incorrect http status code:  url: " + link.getUrl());
            report("Неправильная ссылка " + link.getUrl());
        }
    }

    public P checkCurrentUrlContainsDocumentUrl(String url) {
        postponedAssertTrue(getCurrentUrl().contains(url), "Неправильный урл документа." +
                " Актуальный: " + getCurrentUrl() +
                " Ожидаемый: " + url);
        return (P) this;
    }

    public P checkCurrentUrlContainsText(String... texts) {
        for (String url : texts) {
            postponedAssertTrue(getCurrentUrl().contains(url), "Неправильный урл документа." +
                    " Актуальный: " + getCurrentUrl() +
                    " Ожидаемый: " + getSettings().getHost() + url);
        }
        return (P) this;
    }

    public void checkEmptyDocumentHeader() {
        String currentUrl = getCurrentUrl();
        WebElement documentBody = findElementByNoThrow(By.id("document-body"));
        if (documentBody != null) {
            WebElement title = findElementByNoThrow(documentBody, By.tagName("h1"));
            if (title != null) {
                String actualHeader = documentBody.findElement(By.tagName("h1")).getText();
                postponedAssertFalse(isEmptyDocument(actualHeader), "Документ не найден: " + currentUrl);
            }
        }

        WebElement magazineBody = findElementByNoThrow(By.cssSelector(".e-content"));
        if (magazineBody != null) {
            String magazineBodyText = magazineBody.getText();
            postponedAssertFalse(isEmptyDocument(magazineBodyText), "Документ не найден: " + currentUrl);
        }

        WebElement magazineHeader = findElementByNoThrow(By.cssSelector(".e-header"));
        if (magazineHeader != null) {
            String magazineHeaderText = magazineHeader.getText();
            postponedAssertFalse(isEmptyDocument(magazineHeaderText), "Документ не найден: " + currentUrl);
        }
    }

    public void checkDocumentHeader() {
        String currentUrl = getCurrentUrl();
        WebElement documentBody = findElementByNoThrow(By.id("document-body"));
        if (documentBody != null) {
            WebElement title = findElementByNoThrow(documentBody, By.tagName("h1"));
            //WebElement title2 = findElementByNoThrow(documentBody, By.tagName("h2"));
            if (title != null) {
                String actualHeader = documentBody.findElement(By.tagName("h1")).getText();
                //   String actualHeader2 = documentBody.findElement(By.tagName("h2")).getText();
                postponedAssertNotNull(actualHeader, "h1 is null");
            }
        }
    }

    private boolean isEmptyDocument(String elementText) {
        return elementText.contains("Документ не найден") ||
                elementText.contains("Ссылка на документ не работает") ||
                (elementText.contains("Техническая ошибка") && (!elementText.contains("Техническая ошибка и") && !elementText.contains("Техническая ошибка не "))) ||
                elementText.contains("Мы будем благодарны, если Вы сообщите об ошибке по адресу") ||
                elementText.contains("Мы будем благодарны, если Вы сообщите нам о необходимости дополнить базу данных этим документом") ||
                elementText.contains("Сервис временно не работает");
    }

    public void checkSafetyFunctionalIsPresent() {
        WebElement document = getDocumentBodyElement();
        WebElement safetyLight = findElementByNoThrow(document, By.cssSelector(".safety-light"));
        assertNotNull(safetyLight, "Светофор не найден");
        postponedAssertTrue(safetyLight.isEnabled() && safetyLight.isDisplayed(), "Светофор не отображается");

        WebElement footer = waitForVisibilityOfElementLocatedBy(By.id("document-footer"), "Футер не найден");
        WebElement safetyLightSelect = findElementByNoThrow(footer, By.id("traffic-light"));
        postponedAssertNotNull(safetyLightSelect, "Светофор в Оценке риска не найден");
        if (safetyLightSelect != null) {
            postponedAssertTrue(safetyLightSelect.isEnabled() && safetyLightSelect.isDisplayed(), "Светофор в Оценке риска не отображается");
        }

        WebElement commentField = findElementByNoThrow(footer, By.cssSelector(".safety-comment"));
        postponedAssertNotNull(commentField, "Поле для комментариев в Оценке риска не найдено");
        if (commentField != null) {
            postponedAssertTrue(commentField.isEnabled() && commentField.isDisplayed(), "Поле для комментариев в Оценке риска не отображается");
        }

        WebElement submitButton = findElementByNoThrow(footer, By.cssSelector(".button"));
        postponedAssertNotNull(submitButton, "Кнопка Отправить в Оценке риска не найдена");
    }

    private WebElement getDocumentBodyElement() {
        return waitForVisibilityOfElementLocatedBy(By.id("document-body"), "Документ не найден");
    }

    public void checkEmptyDocument() {
        String currentUrl = getCurrentUrl();
        WebElement documentBody = findElementByNoThrow(By.id("document-body"));
        if (documentBody != null) {
            postponedAssertFalse(documentBody.getText().isEmpty(), "Пустой документ: " + currentUrl);
        }
    }

    public void checkDocumentStyle() {
        String currentUrl = getCurrentUrl();
        WebElement documentBody = findElementByNoThrow(By.id("document-body"));
        if (documentBody != null) {
            postponedAssertFalse(documentBody.getText().isEmpty(), "Пустой документ: " + currentUrl);
            postponedAssertTrue(documentBody.getAttribute("class").contains("doc-body"), "Не правильный стиль основного текста");

            WebElement documentHeader = findElementByNoThrow(By.id("document-header"));
            postponedAssertTrue(documentHeader.getAttribute("class").contains("doc-header"), "Не правильный стиль зголовка"); //id="document-header" class="doc doc-header">
        }
    }

    public boolean isCorrectResponseCode(int status) {
        return status == HttpStatus.SC_CONTINUE ||
                status == HttpStatus.SC_SWITCHING_PROTOCOLS ||
                status == HttpStatus.SC_PROCESSING ||
                status == HttpStatus.SC_OK ||
                status == HttpStatus.SC_CREATED ||
                status == HttpStatus.SC_ACCEPTED ||
                status == HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION ||
                status == HttpStatus.SC_NO_CONTENT ||
                status == HttpStatus.SC_RESET_CONTENT ||
                status == HttpStatus.SC_PARTIAL_CONTENT ||
                status == HttpStatus.SC_MULTI_STATUS ||
                status == HttpStatus.SC_MULTIPLE_CHOICES ||
                status == HttpStatus.SC_MOVED_PERMANENTLY ||
                status == HttpStatus.SC_MOVED_TEMPORARILY ||
                status == HttpStatus.SC_SEE_OTHER ||
                status == HttpStatus.SC_NOT_MODIFIED ||
                status == HttpStatus.SC_USE_PROXY ||
                status == HttpStatus.SC_TEMPORARY_REDIRECT ||
                status == HttpStatus.SC_PRECONDITION_FAILED;
    }

    public boolean isMessageContainsIncorrectResponseCode(String error) {
        return error.contains(String.valueOf(HttpStatus.SC_BAD_REQUEST)) ||
                error.contains(String.valueOf(HttpStatus.SC_UNAUTHORIZED)) ||
                error.contains(String.valueOf(HttpStatus.SC_PAYMENT_REQUIRED)) ||
                error.contains(String.valueOf(HttpStatus.SC_FORBIDDEN)) ||
                error.contains(String.valueOf(HttpStatus.SC_NOT_FOUND)) ||
                error.contains(String.valueOf(HttpStatus.SC_METHOD_NOT_ALLOWED)) ||
                error.contains(String.valueOf(HttpStatus.SC_NOT_ACCEPTABLE)) ||
                error.contains(String.valueOf(HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED)) ||
                error.contains(String.valueOf(HttpStatus.SC_REQUEST_TIMEOUT)) ||
                error.contains(String.valueOf(HttpStatus.SC_CONFLICT)) ||
                error.contains(String.valueOf(HttpStatus.SC_GONE)) ||
                error.contains(String.valueOf(HttpStatus.SC_LENGTH_REQUIRED)) ||
                error.contains(String.valueOf(HttpStatus.SC_PRECONDITION_FAILED)) ||
                error.contains(String.valueOf(HttpStatus.SC_REQUEST_TOO_LONG)) ||
                error.contains(String.valueOf(HttpStatus.SC_REQUEST_URI_TOO_LONG)) ||
                error.contains(String.valueOf(HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE)) ||
                error.contains(String.valueOf(HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE)) ||
                error.contains(String.valueOf(HttpStatus.SC_EXPECTATION_FAILED)) ||
                error.contains(String.valueOf(HttpStatus.SC_INSUFFICIENT_SPACE_ON_RESOURCE)) ||
                error.contains(String.valueOf(HttpStatus.SC_METHOD_FAILURE)) ||
                error.contains(String.valueOf(HttpStatus.SC_UNPROCESSABLE_ENTITY)) ||
                error.contains(String.valueOf(HttpStatus.SC_LOCKED)) ||
                error.contains(String.valueOf(HttpStatus.SC_FAILED_DEPENDENCY)) ||
                error.contains(String.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR)) ||
                error.contains(String.valueOf(HttpStatus.SC_NOT_IMPLEMENTED)) ||
                error.contains(String.valueOf(HttpStatus.SC_BAD_GATEWAY)) ||
                error.contains(String.valueOf(HttpStatus.SC_SERVICE_UNAVAILABLE)) ||
                error.contains(String.valueOf(HttpStatus.SC_GATEWAY_TIMEOUT)) ||
                error.contains(String.valueOf(HttpStatus.SC_HTTP_VERSION_NOT_SUPPORTED)) ||
                error.contains(String.valueOf(HttpStatus.SC_INSUFFICIENT_STORAGE));
    }

    @Step("Проверяется строка поиска")
    protected void checkSearchBoxIsPresent(String textInSearchBox) {
        WebElement searchForm = waitForPresenceOfElementLocatedBy(By.id("search-form"), "Строка поиска не найдена");
        WebElement searchBox = findElementByNoThrow(searchForm, By.cssSelector("[type='text']"));
        postponedAssertTrue(searchBox != null && searchBox.isDisplayed(), "Строка поиска не найдена");
        WebElement searchBoxTextElement = findElementBy(By.id("search-text"));

        String valueInSearchBox;
        if (searchBoxTextElement.getAttribute("value").isEmpty() && !textInSearchBox.isEmpty()) {
            valueInSearchBox = searchBoxTextElement.getAttribute("placeholder").toLowerCase();
        } else {
            valueInSearchBox = searchBoxTextElement.getAttribute("value").toLowerCase();
        }

        postponedAssertEquals(valueInSearchBox, textInSearchBox.toLowerCase(), "Неправильный текст в строке поиска");
        postponedAssertTrue(findElementByNoThrow(searchForm, By.cssSelector("[type='submit']")) != null &&
                searchForm.findElement(By.cssSelector("[type='submit']")).isDisplayed(), "Кнопка 'Найти' не найдена");
    }

    @Step("Открыть форму онлайн помощи")
    public P clickOnlineHelpButton() {
        waitForVisibilityOfElementLocatedBy(By.id("assistant-btn"), "Форма онлайн-помощника не найдена").click();
        if (!findElementsBy(By.cssSelector("[alt='Loading']")).isEmpty()) {
            waitForInvisibilityOfElementLocatedBy(By.cssSelector("[alt='Loading']"));
        }
        return (P) this;
    }

    @Step("Ввести текст в форму онлайн помощи")
    public P inputTextInOnlineHelpForm(String message) {
        switchToFrame("lt_embeded_window");
        WebElement questionField = waitForVisibilityOfElementLocatedBy(By.id("question"), "Форма онлайн помощи не найдена");
        TextField textField = getWebElementWrapper(questionField).getTextField();
        textField.clearAndType(message);
        waitForTextToBePresentIn(questionField);
        switchToDefaultContent();
        return (P) this;
    }

    @Step("Ввести текст в форму онлайн помощи")
    public P inputTextInOnlineHelpFormNew(String message) {
        WebElement questionField = waitForVisibilityOfElementLocatedBy(By.id("chat-reply-text"), "Форма онлайн помощи не найдена");
        questionField.click();
        questionField.clear();
        questionField.sendKeys(message);
        return (P) this;
    }

    @Step("Нажать кнопку отправить сообщение")
    public P clickSendButtonNew() {
        waitForVisibilityOfElementLocatedBy(By.id("chat-reply-submit")).click();
        return (P) this;
    }

    @Step("Проверяется статус онлайн помощника")
    public boolean isAssistantOnlineNew() {
        WebElement assistantButton = waitForPresenceOfElementLocatedBy(By.id("assistant-btn"));
        String classAttribute = assistantButton.getAttribute("class");
        if (classAttribute.contains("online")) {
            warning("Помощник онлайн");
            return true;
        } else {
            warning("Помощник оффлайн");
            return false;
        }
    }

    @Step("Проверяется что форма онлайн помощи отображается")
    public P checkFormOnlineHelpIsPresentNew() {
        WebElement body = waitForPresenceOfElementLocatedBy(By.tagName("body"));
        WebElement form = findElementByNoThrow(body, By.id("onlineConsultant"));
        assertNotNull(form, "Форма онлайн помощи не найдена");
        postponedAssertTrue(form.isEnabled() && form.isDisplayed(), "Форма онлайн помощи не отображается");
        return (P) this;
    }

    @Step("Проверяется что сообщение появилось в форме онлайн помощи")
    public P checkMessageIsAppearInFormNew(String message) {
        WebElement chatContent = waitForPresenceOfElementLocatedBy(By.cssSelector(".chat__body"));
        List<WebElement> messageElementList = chatContent.findElements(By.xpath(".//div[contains(@class,'chat-message__text to operator')]"));
        WebElement element = messageElementList.get(messageElementList.size() - 1);
        String messageInForm = element.getText().split("\n")[0];
        postponedAssertTrue(messageInForm.contains(message), "Неправильный текст сообщения в форме онлайн помощи, " +
                "ожидалось: " + message + ", найдено:" + messageInForm);
        return (P) this;
    }

    @Step("Проверяется что контент отображается")
    public P checkContentLinksForModule(String url) {
//        BrowserMobProxy server = SeleniumHolder.getServer();
        Link link = new Link(url);
        checkContentLink(link);
        return (P) this;
    }

    public void checkContentLink(Link link) {
        String currentUrl = getCurrentUrl().split("\\?step=")[0];

//        server.newHar(link.getUrl());

        report("Открыта страница: " + currentUrl);
        report("Открывается ссылка: " + link.getUrl());

        openUrl(link.getUrl());
        waitForReloadingPage();

//        Har har = server.getHar();
//        for (HarEntry harEntry : har.getLog().getEntries()) {
//            if (harEntry.getPageref().equals(link.getUrl())) {
//                int status = harEntry.getResponse().getStatus();
//                String url = harEntry.getRequest().getUrl();
//                if (status != -999 && status != -998) {
//                    if (!isCorrectResponseCode(status)) {
////                    setPostponedTestFail("Incorrect http status code: " + status + " url: <a href=" + url + ">" + url + "</a>\n");
//                    }
//                }
//            }
//        }

        postponedAssertTrue(getCurrentUrl().contains(link.getUrl()), "Неправильный урл открытого документа. " +
                "Ожидаемый результат: '" + link.getUrl() + "'. " +
                "Наблюдаемый результат: '" + getCurrentUrl() + "'.");

        checkEmptyDocumentHeader();
        checkEmptyDocument();
        checkWizardContent();
        if (getCurrentUrl().contains("#/document/170/")) {
            checkSafetyFunctionalIsPresent();
        }
    }

    public void checkWizardContent() {
        if (getCurrentUrl().contains("wizard")) {
            WebElement documentBody = getDocumentBodyElement();
            waitForTextToBePresentIn(documentBody);
            WebElement wizardsQuestions = waitForVisibilityOfElementLocatedBy(By.id("wizards-questions"), "Список вопросов для мастера не найден");
            waitForTextToBePresentInWithErrorMessage(wizardsQuestions, "Список вопросов для мастера пуст");
        }
    }

    protected void waitForHints() {
        String query = String.valueOf(getParameter(SearchResultHelper.HINT_TEXT));
        inputTextInSearchBox(query);
        WebElement searchFiled = findElementBy(By.id("search-text"));
        searchFiled.sendKeys(Keys.ARROW_RIGHT);
        waitFewSecond(2000);
    }

    public P checkActualDocumentCheckBoxIsSelected() {
        extendedSearchForm.checkActualDocumentCheckBoxIsSelected();
        return (P) this;
    }

    public P checkActualDocumentCheckBoxIsNotSelected() {
        extendedSearchForm.checkActualDocumentCheckBoxIsNotSelected();
        return (P) this;
    }

    public P checkOnlyInTitlesCheckBoxIsSelected() {
        extendedSearchForm.checkOnlyInTitlesCheckBoxIsSelected();
        return (P) this;
    }

    public P checkOnlyInTitlesCheckBoxIsNotSelected() {
        extendedSearchForm.checkOnlyInTitlesCheckBoxIsNotSelected();
        return (P) this;
    }

    public P checkOnlyInTitlesCheckBoxIsEnabled() {
        extendedSearchForm.checkOnlyInTitlesCheckBoxIsEnabled();
        return (P) this;
    }

    public P checkOnlyInTitlesCheckBoxIsDisabled() {
        extendedSearchForm.checkOnlyInTitlesCheckBoxIsDisabled();
        return (P) this;
    }

    public P checkSearchExtendedButtonsIsEnabled() {
        extendedSearchForm.checkSearchExtendedButtonsIsEnabled();
        return (P) this;
    }

    public P checkSearchExtendedButtonsIsDisabled() {
        extendedSearchForm.checkSearchExtendedButtonsIsDisabled();
        return (P) this;
    }

    public P checkValuesInFieldIsNotChanged() {
        extendedSearchForm.checkValuesInFieldIsNotChanged();
        return (P) this;
    }

    public P checkSearchBodyResultText() {
        extendedSearchForm.checkSearchBodyResultText();
        return (P) this;
    }

    public P checkAllFieldsDefaultState() {
        extendedSearchForm.checkAllFieldsDefaultState();
        return (P) this;
    }

    public P clearAllFields() {
        extendedSearchForm.clearAllFields();
        return (P) this;
    }

    public P clickClearFields() {
        extendedSearchForm.clickClearFields();
        return (P) this;
    }

    public P inputTextInSearchField(String text) {
        extendedSearchForm.inputTextInSearchField(text);
        return (P) this;
    }

    public P inputTextInNumberField(String text) {
        extendedSearchForm.inputTextInNumberField(text);
        return (P) this;
    }

    public P inputTextInNumberFieldWithoutCloseTheAdviceList(String text) {
        extendedSearchForm.inputTextInNumberFieldWithoutCloseTheAdviceList(text);
        return (P) this;
    }

    public P inputTextInStartDateField(String text) {
        extendedSearchForm.inputTextInStartDateField(text);
        return (P) this;
    }

    public P inputTextInEndDateField(String text) {
        extendedSearchForm.inputTextInEndDateField(text);
        return (P) this;
    }

    public P selectTypeByName(String typeName) {
        extendedSearchForm.selectTypeByName(typeName);
        return (P) this;
    }

    public P selectRandomType() {
        extendedSearchForm.selectRandomType();
        return (P) this;
    }

    public P selectLobbyByName(String lobbyName) {
        extendedSearchForm.selectLobbyByName(lobbyName);
        return (P) this;
    }

    public P selectRandomLobby() {
        extendedSearchForm.selectRandomLobby();
        return (P) this;
    }

    public P selectRandomCategory() {
        extendedSearchForm.selectRandomCategory();
        return (P) this;
    }

    public P selectRegionByName(String regionName) {
        extendedSearchForm.selectRegionByName(regionName);
        return (P) this;
    }

    public P selectRandomRegion() {
        extendedSearchForm.selectRandomRegion();
        return (P) this;
    }

    public P selectActualDocumentCheckBox() {
        extendedSearchForm.selectActualDocumentCheckBox();
        return (P) this;
    }

    public P deSelectActualDocumentCheckBox() {
        extendedSearchForm.deSelectActualDocumentCheckBox();
        return (P) this;
    }

    public P selectOnlyInTitlesCheckBox() {
        extendedSearchForm.selectOnlyInTitlesCheckBox();
        return (P) this;
    }

    public P deSelectOnlyInTitlesCheckBox() {
        extendedSearchForm.deSelectOnlyInTitlesCheckBox();
        return (P) this;
    }

    public P clickInLawBaseButton() {
        extendedSearchForm.clickInLawBaseButton();
        return (P) this;
    }

    public P clickInLawPracticeButton() {
        extendedSearchForm.clickInLawPracticeButton();
        return (P) this;
    }

    @Step("Проверяется что форма расширенного поиска отображается")
    public P checkExtendedSearchFormIsPresent() {
        WebElement form = findElementByNoThrow(headerElement, By.id("search-form-extended"));
        postponedAssertNotNull(form, "Форма расширенного поиска не найдена");
        if (form != null) {
            postponedAssertTrue(form.isDisplayed(), "Форма расширенного поиска не отображается");
        }
        return (P) this;
    }

    @Step("Проверяется наличие поисковых подсказок для фильтра № документа")
    public P checkExtendedSearchAdviceList(String query) {
        extendedSearchForm.checkSearchAdviceListHasLensIcon();
        extendedSearchForm.checkSearchAdviceListHasSearchQuery(query);
        extendedSearchForm.checkSearchAdviceListHasTextGoToTheDocument();
        extendedSearchForm.checkSearchAdviceListHasMax10Advices();
        extendedSearchForm.checkSearchAdviceListHasHints();

        return (P) this;
    }

    @Step("Проверяется лог консоли на наличии ошибок")
    public P checkConsoleLog() {
        LogEntries logEntries = getDriver().manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            if (entry.getLevel().equals(Level.SEVERE)) {
                String error = entry.getMessage();
                if (error.contains("/survey/")) {
                    continue;
                }
                if (isMessageContainsIncorrectResponseCode(error)) {
                    setPostponedTestFail("Ошибка в консоли - " + entry.getMessage());
                }
            }
        }
        return (P) this;
    }

    public List<String> getHighlightsWordListForDocument(String searchWord, int moduleId, int documentId) {
        List<String> highlightsWordList = new ArrayList<String>();
        int pubId = SystemPubs.getPubId(getSettings(), getCurrentUrl());
        try {
            SearchServiceLocator locator = new SearchServiceLocator();
            locator.setBasicHttpBinding_ISearchServiceEndpointAddress(getSettings().getSearchServiceUrl());
            ISearchService service = locator.getBasicHttpBinding_ISearchService();
            MessageElement messageElement = service.getSearchHighlights(new UnsignedByte(pubId), searchWord, new UnsignedByte(moduleId), documentId).get_any()[0];
            ServiceResponse response = new MessageElementConverter(messageElement).getResponse();

            List<NodeElement> nodeElementList = response.getNodeElementListByName("word");
            for (NodeElement nodeElement : nodeElementList) {
                highlightsWordList.add(nodeElement.getValue());
                Collections.addAll(highlightsWordList, nodeElement.getValue().split(" "));
            }
        } catch (ServiceException e) {
            logger.error("SoapException occurs ", e);
        } catch (RemoteException e) {
            logger.error("SoapException occurs ", e);
        }
        return highlightsWordList;
    }

    @Step("Навести мышку и проверить")
    public P checkMoveMouseToElements(String navButtonPartialClassName) {
        closePopUp();
        WebElement elem1 = findElementBy(By.cssSelector(".list_type_nav .btn_content_" + navButtonPartialClassName));
        moveMouseToElement(elem1);
        waitFewSecond(500);
        closePopUp();
        WebElement hoverElement = findElementByNoThrow(By.cssSelector(".btn_type_nav:hover"));
        postponedAssertNotNull(hoverElement, "Не один элемент не выделен");
        if (hoverElement != null) {
            String classAttribute = elem1.getAttribute("class");
            postponedAssertTrue(classAttribute.contains(navButtonPartialClassName), "Выделен неправильный элемент. Ожидаемый - " + navButtonPartialClassName + ", актуальный - " + classAttribute);
        }
        return (P) this;
    }

    public void clickActivate() {
        waitForPresenceOfElementLocatedBy(By.linkText("Активация подписки")).click();
        waitForReloadingPage();
    }

    @Step("Проверяется что открыта нужная ссылка")
    public P checkActivateLink() {
        postponedAssertTrue(getCurrentUrl().contains("activate-code"), "Ссылка должна содержать строку activate-code, ссылка: " + getCurrentUrl());
        return (P) this;
    }


    @Step("Проверка открытия страницы написать эксперту")
    public P checkAskPage() {
        postponedAssertTrue(getCurrentUrl().contains("#/hotline/"), "Ссылка должна содержать hotline, ссылка: " + getCurrentUrl());
        return (P) this;
    }

    @Step("Проверка страницы логина")
    public P checkLoginPage() {
        postponedAssertTrue(getCurrentUrl().contains("#/customer/auth"), "Ссылка должна содержать /customer/auth, ссылка: " + getCurrentUrl());
        String loginTab = findElementBy(By.id("wf-enter")).getAttribute("class");
        postponedAssertEquals(loginTab, "dashed pressed", "Вкладка 'Вход в систему' не открыта");
        return (P) this;
    }

    @Step("Проверка страницы промо")
    public P checkPromoPage() {
        postponedAssertTrue(getCurrentUrl().contains("about"), "Ссылка должна содержать /about/, ссылка: " + getCurrentUrl());
        return (P) this;
    }

    @Step("Перейти на текущий раздел")
    public P goToCurrentTab() {
        waitForPresenceOfElementLocatedBy(By.cssSelector(".btn_state_active")).click();
        return (P) this;
    }

    @Step("Открыть страницу документа")
    public P navigateToDocumentPage() {
        waitForPresenceOfElementLocatedBy(By.cssSelector("[href*='/#/document/']")).click();
        return (P) this;
    }

    @Step("Открыть страницу пользователя")
    public P navigateToCustomerPage() {
        waitForPresenceOfElementLocatedBy(By.cssSelector("[href*='/#/customer/']")).click();
        return (P) this;
    }

    @Step("Перейти на другой раздел")
    public P goToDifferentTab() {
        waitForPresenceOfElementLocatedBy(By.cssSelector(".btn_type_nav:not(.btn_state_active)")).click();
        return (P) this;
    }

    @Step("проверка, что меню открылось")
    public P checkMenuIsOpened() {
        WebElement menu = findElementByNoThrow(By.id("more"));
        // if((menu.findElement(By.cssSelector("[class='link__in']")).getText().trim()!="") && (menu.findElement(By.cssSelector("[class='link__in']")).getText()!=null)) {
        if (!getCurrentHost().contains("1fd") && !getCurrentHost().contains("fss")) {
            postponedAssertEquals(menu.findElement(By.cssSelector("[class='link__in']")).getText(), "свернуть", "Меню свернуто!");
        } else {
            WebElement body = findElementBy(By.tagName("body"));
            postponedAssertTrue(body.getAttribute("class").contains("page_state_extended"), "Меню свернуто!");
        }
        return (P) this;
    }

    @Step("проверка, что меню не открыто")
    public P checkMenuIsNotOpened() {
        WebElement menu = findElementByNoThrow(By.id("more"));
        postponedAssertTrue(!(menu.findElement(By.cssSelector("[class='link__in']")).getText().contains("свернуть")), "Меню не свернуто!");
        return (P) this;
    }

    @Step("нажать по реквизитам")
    public P clickRequisite() {
        waitForPresenceOfElementLocatedBy(By.cssSelector(".btn_viewtype_search-switch")).click();
        waitFewSecond(500);
        return (P) this;
    }

    @Step("проверка, что по реквизитам открылось")
    public P checkRequisite() {
        WebElement req = findElementByNoThrow(By.id("search-extended-wrapper"));
        postponedAssertTrue(req.getAttribute("style").contains("display: block"), "Не показаны реквизиты!");
        return (P) this;
    }

    @Step("проверка, что свернулось правильно")
    public P сheckRollUp() {
        WebElement req = findElementByNoThrow(By.id("search-extended-wrapper"));
        postponedAssertTrue(req.getAttribute("style").contains("display: none"), "Реквизиты показаны, хотя должны быть свернуты!");
        return (P) this;
    }

    @Step("Проверка инфо пользователя")
    public P checkCustomerInfoPage() {
        postponedAssertTrue(getCurrentUrl().contains("#/customer/"), "Ссылка должна содержать customer info, ссылка: " + getCurrentUrl());
        return (P) this;
    }

    public void clickLoginLink() {
        waitForPresenceOfElementLocatedBy(By.linkText("Вход и регистрация")).click();
        waitForReloadingPage();
        if (getSettings().isRunProk1()){
            WebElement tabMenu = waitForVisibilityOfElementLocatedBy(By.cssSelector("#whiteboard [data-tab-name='auth'] span"), "Форма авторизации не найдена");
            tabMenu.click();
        }
    }

    @Step("Проверяется, что отображается блок авторизации")
    public void checkAuthBlockIsPresent() {
        WebElement whiteboard = findElementByNoThrow(By.id("whiteboard"));
        postponedAssertTrue(whiteboard != null && whiteboard.isDisplayed(), "Блок авторизации не отображается");
    }

    @Step("открываем меню, которое было свернуто")
    public P openMenu() {
        waitForPresenceOfElementLocatedBy(By.id("more")).click();
        //WebElement moreButton = findElementByNoThrow(By.cssSelector("#header #more"));
        //moreButton.click();
        return (P) this;
    }

    @Step("Проверяется контент в блоке 'Желтая плашка'")
    public P checkYellowPlateWidget() {
        WebElement widget = findElementByNoThrow(mainContentElement, By.cssSelector(".widget_content_note"));
        if (widget != null) {
            WebElement answer = findElementByNoThrow(widget, By.cssSelector(".widget__answer"));
            postponedAssertNotNull(answer, "Отсутствует ответ в Желтой плашке");
            if (answer != null) {
                postponedAssertFalse(answer.getText().isEmpty(), "Отсутствует текст ответа в Желтой плашке");
            }

            WebElement source = findElementByNoThrow(widget, By.cssSelector(".author-comment__source"));
            postponedAssertNotNull(source, "Отсутствует ссылка на полный ответ в Желтой плашке");
            if (source != null) {
                postponedAssertNotNull(findElementByNoThrow(source, By.tagName("a")), "Отсутствует ссылка на полный ответ в Желтой плашке");
            }

            WebElement img = findElementByNoThrow(widget, By.tagName("img"));
            postponedAssertNotNull(img, "Отсутствует фото автора в Желтой плашке");
        } else {
            setPostponedTestFail("Блок 'Желтая плашка' не найден");
        }
        return (P) this;
    }

    public P checkContentInLawBaseWidgetIsPresent() {
        getHelper(LawBaseWidget.class).checkContentIsPresent();
        return (P) this;
    }

    public P checkFormsWidget() {
        getHelper(FormsWidget.class).checkContentFormsWidget();
        return (P) this;
    }

    @Step("Проверяется контент в блоке 'Журналы и книги'")
    public P checkMagazinesWidget() {
        WebElement widget = findElementByNoThrow(mainContentElement, By.cssSelector(".widget_content_press"));
        if (widget != null) {
            WebElement header = widget.findElement(By.tagName("h3"));
            String widgetName = header.getText();
            postponedAssertFalse(widgetName.isEmpty(), "Отсутствует заголовок виджета для '" + widget.getAttribute("class") + "'");

            if (getSettings().isRunBss()) {
                WebElement count = findElementByNoThrow(widget, By.cssSelector(".widget__count"));
                postponedAssertNotNull(count, "Отсутствует количество документов в блоке 'Журналы и книги'");
                if (count != null) {
                    postponedAssertFalse(count.getText().isEmpty(), "Отсутствует текст для количества документов в блоке 'Журналы и книги'");
                }
            }

            if (getSettings().isRunKss()) {
                WebElement newMagazine = findElementByNoThrow(widget, By.cssSelector(".new"));
                postponedAssertNotNull(newMagazine, "Отсутствует блок 'Свежий номер' в блоке 'Журналы и книги'");
                if (newMagazine != null) {
                    WebElement link = findElementByNoThrow(newMagazine, By.tagName("a"));
                    postponedAssertNotNull(link, "Отсутствует ссылка в блоке 'Свежий номер' в блоке 'Журналы и книги'");
                    postponedAssertFalse(newMagazine.getText().isEmpty(), "Отсутствует текст в блоке 'Свежий номер' в блоке 'Журналы и книги'");
                }
            }

            List<WebElement> contentList = widget.findElements(By.tagName("li"));
            postponedAssertFalse(contentList.isEmpty(), "Отсутствует контент в блоке 'Журналы и книги'");
            for (WebElement content : contentList) {
                WebElement contentLink = findElementByNoThrow(content, By.tagName("a"));
                postponedAssertNotNull(contentLink, "Отсутствует ссылка для одного из документов в блоке 'Правовая база'");

                WebElement img = findElementByNoThrow(content, By.tagName("img"));
                postponedAssertNotNull(img, "Отсутствует картинка для одного из документов в блоке 'Правовая база'");
            }

        } else {
            setPostponedTestFail("Блок 'Журналы и книги' не найден");
        }
        return (P) this;
    }

    @Step("Проверяется контент в блоке 'Справочник'")
    public P checkDictionaryWidget() {
        WebElement widget = findElementByNoThrow(mainContentElement, By.cssSelector(getSettings().isRunKss() ? ".widget-handbook" : ".b-helpers-widget"));
        if (widget != null) {
            WebElement header = widget.findElement(getSettings().isRunKss() ? By.tagName("h3") : By.cssSelector(".title a"));
            String widgetName = header.getText();
            postponedAssertFalse(widgetName.isEmpty(), "Отсутствует заголовок виджета для '" + widget.getAttribute("class") + "'");

            if (!getSettings().isRunUss()) {
                WebElement count = findElementByNoThrow(widget, By.cssSelector(getSettings().isRunKss() ? ".widget__count" : ".title b"));
                postponedAssertNotNull(count, "Отсутствует количество документов в блоке 'Справочник'");
                if (count != null) {
                    postponedAssertFalse(count.getText().isEmpty(), "Отсутствует текст для количества документов в разделе в блоке 'Справочник'");
                }
            }

            WebElement update = findElementByNoThrow(widget, By.cssSelector(".widget-update"));
            if (update != null) {
                postponedAssertFalse(update.getText().isEmpty(), "Отсутствует текст для количества новых документов в разделе в блоке 'Справочник'");
            }

            List<WebElement> contentList = widget.findElements(By.tagName("li"));
            if (!getSettings().isRunKss()) {
                postponedAssertFalse(contentList.isEmpty(), "Отсутствует контент в блоке 'Справочник'");
            }
            for (WebElement content : contentList) {
                String contentName = content.getText();
                WebElement contentLink = findElementByNoThrow(content, By.tagName("a"));
                postponedAssertNotNull(contentLink, "Отсутствует ссылка для '" + contentName + "' в блоке 'Справочник'");
            }

            if (getSettings().isRunBss() || getSettings().isRunUss()) {
                WebElement currency = findElementByNoThrow(widget, By.cssSelector(".paper-green"));
                postponedAssertNotNull(currency, "Отсутствует блок курса валют в блоке 'Справочник'");
                if (currency != null) {
                    postponedAssertFalse(currency.getText().isEmpty(), "Отсутствует текст в блоке курса валют в блоке 'Справочник'");
                }
            }

            if (getSettings().isRunBss()) {
                WebElement mrot = findElementByNoThrow(widget, By.cssSelector(".paper-green"));
                postponedAssertNotNull(mrot, "Отсутствует блок МРОТ в блоке 'Справочник'");
                if (mrot != null) {
                    postponedAssertFalse(mrot.getText().isEmpty(), "Отсутствует текст в блоке МРОТ в блоке 'Справочник'");
                }
            }

            if (getSettings().isRunKss()) {
                WebElement day = findElementByNoThrow(widget, By.cssSelector(".widget-date"));
                postponedAssertNotNull(day, "Отсутствует дата в блоке 'Справочник'");
                if (day != null) {
                    postponedAssertFalse(day.getText().isEmpty(), "Отсутствует текст Даты в блоке 'Справочник'");
                }

                WebElement date = findElementByNoThrow(widget, By.cssSelector(".widget-days"));
                postponedAssertNotNull(date, "Отсутствует дата в блоке 'Справочник'");
                if (day != null) {
                    postponedAssertFalse(date.getText().isEmpty(), "Отсутствует текст Даты в блоке 'Справочник'");
                }

                WebElement currency = findElementByNoThrow(widget, By.cssSelector(".widget-currency"));
                postponedAssertNotNull(currency, "Отсутствует курс валют в блоке 'Справочник'");
                if (day != null) {
                    postponedAssertFalse(currency.getText().isEmpty(), "Отсутствует текст в курсе валют в блоке 'Справочник'");
                }

                WebElement mrot = findElementByNoThrow(widget, By.cssSelector(".widget-wage"));
                postponedAssertNotNull(mrot, "Отсутствует МРОТ в блоке 'Справочник'");
                if (day != null) {
                    postponedAssertFalse(mrot.getText().isEmpty(), "Отсутствует текст МРОТ в блоке 'Справочник'");
                }
            }
        } else {
            setPostponedTestFail("Блок 'Справочник' не найден");
        }
        return (P) this;
    }

    @Step("Проверяется контент в блоке 'Видео'")
    public P checkVideosWidget() {
        WebElement widget = findElementByNoThrow(mainContentElement, By.cssSelector(".widget-videos"));
        if (widget != null) {
            WebElement header = widget.findElement(getSettings().isRunKss() ? By.tagName("h3") : By.cssSelector(".title a"));
            String widgetName = header.getText();
            postponedAssertFalse(widgetName.isEmpty(), "Отсутствует заголовок виджета для '" + widget.getAttribute("class") + "'");

            if (!getSettings().isRunUss()) {
                WebElement count = findElementByNoThrow(widget, By.cssSelector(getSettings().isRunKss() ? ".widget__count" : ".title b"));
                postponedAssertNotNull(count, "Отсутствует количество документов в блоке 'Видео'");
                if (count != null) {
                    postponedAssertFalse(count.getText().isEmpty(), "Отсутствует текст для количества документов в блоке 'Видео'");
                }
            }

            WebElement update = findElementByNoThrow(widget, By.cssSelector(".widget-update"));
            if (update != null) {
                postponedAssertFalse(update.getText().isEmpty(), "Отсутствует текст для количества новых документов в разделе в блоке 'Видео'");
            }

            WebElement preview = findElementByNoThrow(widget, By.cssSelector(".videos-preview"));
            postponedAssertNotNull(preview, "Отсутствует видео превью в блоке 'Видео'");
            if (preview != null) {
                if (getSettings().isRunKss()) {
                    WebElement link = findElementByNoThrow(preview, By.tagName("a"));
                    postponedAssertNotNull(link, "Отсутствует ссылка для видео превью в блоке 'Видео'");
                } else {
                    WebElement link = findElementByNoThrow(getParentElement(preview), By.tagName("a"));
                    postponedAssertNotNull(link, "Отсутствует ссылка для видео превью в блоке 'Видео'");
                }
            }

        } else {
            setPostponedTestFail("Блок 'Видео' не найден");
        }
        return (P) this;
    }

    @Step("Проверяется контент в блоке 'Мастера'")
    public P checkWizardsWidget() {
        WebElement widget = findElementByNoThrow(mainContentElement, By.cssSelector(getSettings().isRunKss() ? ".widget_content_wizards" : ".widget-wizards"));
        if (widget != null) {
            WebElement header = widget.findElement(getSettings().isRunKss() ? By.tagName("h3") : By.cssSelector(".title a"));
            String widgetName = header.getText();
            postponedAssertFalse(widgetName.isEmpty(), "Отсутствует заголовок виджета для '" + widget.getAttribute("class") + "'");

            if (getSettings().isRunKss()) {
                WebElement count = findElementByNoThrow(widget, By.cssSelector(".widget__count"));
                postponedAssertNotNull(count, "Отсутствует количество документов в блоке 'Мастера'");
                if (count != null) {
                    postponedAssertFalse(count.getText().isEmpty(), "Отсутствует текст для количества документов в разделе в блоке 'Мастера'");
                }
            }

            WebElement update = findElementByNoThrow(widget, By.cssSelector(".widget-update"));
            if (update != null) {
                postponedAssertFalse(update.getText().isEmpty(), "Отсутствует текст для количества новых документов в разделе в блоке 'Мастера'");
            }

            List<WebElement> contentList = widget.findElements(By.tagName("li"));
            postponedAssertFalse(contentList.isEmpty(), "Отсутствует контент в блоке 'Мастера'");
            for (WebElement content : contentList) {
                String contentName = content.getText();
                WebElement contentLink = findElementByNoThrow(content, By.tagName("a"));
                postponedAssertNotNull(contentLink, "Отсутствует ссылка для '" + contentName + "' в блоке 'Мастера'");
            }

        } else {
            setPostponedTestFail("Блок 'Мастера' не найден");
        }
        return (P) this;
    }

    @Step("Проверяется контент в блоке 'Баннер'")
    public P checkBannerWidget() {
        WebElement widget = findElementByNoThrow(mainContentElement, By.cssSelector(getSettings().isRunKss() ? "#widgetBanner" : ".novost"));
        if (widget != null) {
            if (getSettings().isRunKss()) {
                WebElement link = findElementByNoThrow(widget, By.tagName("a"));
                postponedAssertNotNull(link, "Отсусвует ссылка в блоке 'Баннер'");
                postponedAssertFalse(widget.getText().isEmpty(), "Отсутствует текст в блоке 'Баннер'");
            } else {
                postponedAssertNotNull(widget.getAttribute("href"), "Отсусвует ссылка в блоке 'Баннер'");
                postponedAssertFalse(widget.getText().isEmpty(), "Отсутствует текст в блоке 'Баннер'");
            }
        } else {
            setPostponedTestFail("Блок 'Баннер' не найден");
        }
        return (P) this;
    }

    @Step("Проверяется контент в блоке 'Договоры'")
    public P checkContractsWidget() {
        WebElement widget = findElementByNoThrow(mainContentElement, By.cssSelector(".b-contracts-widget"));
        if (widget != null) {
            WebElement link = findElementByNoThrow(widget, By.tagName("a"));
            postponedAssertNotNull(link, "Отсусвует ссылка в блоке 'Договоры'");
            postponedAssertFalse(widget.getText().isEmpty(), "Отсутствует текст в блоке 'Договоры'");
        } else {
            setPostponedTestFail("Блок 'Договоры' не найден");
        }
        return (P) this;
    }

    @Step("Проверяется контент в блоке 'Газета'")
    public P checkNewsWidget() {
        WebElement widget = findElementByNoThrow(mainContentElement, getSettings().isRunKss() ? By.xpath(".//*[@id='sidebar']/div[2]") : By.cssSelector(".main-sidebar-content"));
        if (widget != null) {
            List<WebElement> contentList = widget.findElements(By.cssSelector(".newspaper-item"));
            postponedAssertFalse(contentList.isEmpty(), "Отсутствует контент в блоке 'Газета'");
            for (WebElement content : contentList) {
                String contentName = content.getText();
                postponedAssertFalse(contentName.isEmpty(), "Отсутствует текст для новости в блоке 'Газета'");
                WebElement contentLink = findElementByNoThrow(content, By.tagName("a"));
                postponedAssertNotNull(contentLink, "Отсутствует ссылка для новости в блоке 'Газета'");
            }
        } else {
            setPostponedTestFail("Блок 'Газета' не найден");
        }
        return (P) this;
    }

    public void checkDocumentFromStartPages(SystemPubs systemPub) {
        getHelper(CheckDocumentHelper.class).checkDocumentFromStartPages(systemPub);
    }

    public void checkAllNewDocumentsByPubId(SystemPubs systemPub) {
        getHelper(CheckDocumentHelper.class).checkAllNewDocumentsByPubId(systemPub);
    }

    public void checkPublicationBlockInDocuments() {
        getHelper(CheckDocumentHelper.class).checkPublicationBlockInDocuments();
    }

    public void checkBackLinks(SystemPubs systemPub) {
        getHelper(BackLinksHelper.class).checkBackLinks(systemPub);
    }

    @Step("Проверяется отображение кнопка Мое избранное")
    public P checkMyFavoritesRubricatorButtonIsPresent() {
        WebElement rubricatorButton = findElementByNoThrow(By.id("favorites-btn"));
        if (rubricatorButton != null) {
            postponedAssertEquals(rubricatorButton.getText(), "Избранное", "Неправильный текст кнопки Мое избранное");
        } else {
            setPostponedTestFail("Кнопка Мое избранное Отсутствует");
        }
        return (P) this;
    }

    @Step("Проверяется  кнопка Мое избранное отсутствует на странице")
    public P checkMyFavoritesRubricatorButtonIsNotPresent() {
        WebElement rubricatorButton = findElementByNoThrow(By.id("favorites-btn"));
        postponedAssertTrue(rubricatorButton == null || !rubricatorButton.isDisplayed(), "Кнопка Избранное присутствует на странице");
        return (P) this;
    }

    @Step("Проверяется отображение кнопка Помощник ")
    public P checkAssistantButtonIsPresent() {
        WebElement rubricatorButton = waitForPresenceOfElementLocatedBy(By.id("assistant-btn"), "Кнопка Помощник Отсутствует");
        String expectedText;
        if (getSettings().isRunBss() && (getCurrentUrl().contains("budget.") || getCurrentUrl().contains("bu."))) {
            expectedText = "Помощь эксперта";
        } else {
            expectedText = "Помощник";
        }
        postponedAssertEquals(rubricatorButton.getText(), expectedText, "Неправильный текст кнопки Помощник");
        return (P) this;
    }

    @Step("Открыть страницу Личного кабинета")
    public P clickProfileLinkBase() {
        waitForPresenceOfElementLocatedBy(By.cssSelector("[href*='#/customer/']"), "Ссылка 'Личный кабинет' не найдена").click();
        return (P) this;
    }

    @Step("Нажать кнопку 'Выйти из системы'")
    public P logoutBase() {
        clickProfileLinkBase();
        try {
            scrollToStart();
            WebElement logoutButton = waitForPresenceOfElementLocatedBy(By.id("logout-btn"), 10);
            clickUseJS(logoutButton);
        } catch (WebDriverException ignored) {
        }
//        try {
//            logoutBySendPost(getSettings().createUrl() + "/site/customer/logout/");
//        } catch (IOException e) {
//            logger.error(e.getMessage());
//        }
        deleteCookies();
        return (P) this;
    }

    private Map<String, String> getCookies() {
        Map<String, String> cookies = new HashMap<String, String>();
        Iterator iterator = getDriver().manage().getCookies().iterator();
        while (iterator.hasNext()) {
            Cookie cookie = (Cookie) iterator.next();
            if (cookie.getDomain().startsWith(".")) {
                cookies.put(cookie.getName(), cookie.getValue());
            }
        }
        return cookies;
    }

    private Connection.Response logoutBySendPost(String url) throws IOException {
        return Jsoup
                .connect(url)
                .ignoreHttpErrors(true)
                .timeout(0)
                .cookies(getCookies())
                .method(Connection.Method.GET)
                .execute();
    }

    public P inputSearchHistory(String[] texts) {
        for (String text : texts) {
            inputTextInSearchBox(text);
            clickSearchButton();
            waitForReloadingPage();
            returnToBack();
        }
        return (P) this;
    }

    public P checkSearchHistory(String[] queryList) {
        List<WebElement> historyList = getSearchHistory();
        postponedAssertNotNull(historyList, "Поисковые запросы не отобразились");
        postponedAssertTrue(historyList.size() <= 7, "Подсказок больше 7");

        for (int i = 1; i < queryList.length; i++) {
            postponedAssertTrue(getTextFromWebElementList(historyList).contains(queryList[i]), "Выделенная поисковые подсказки не соответсвуют запросу");
        }

        postponedAssertNotNull(historyList.get(0).getCssValue("background-image"), "Не отображается 'Лупа'");
        return (P) this;
    }

    @Step("Проверяется что история поисковых запросов не отображается")
    public P checkSearchHistoryIsNotPresent() {
        postponedAssertTrue(getSearchHistory().isEmpty(), "История поисковых запросов отображается.");
        return (P) this;
    }

    @Step("Проверяется что история поисковых запросов отображается")
    public P checkSearchHistoryIsPresent() {
        postponedAssertFalse(getSearchHistory().isEmpty(), "История поисковых запросов не отображается.");
        return (P) this;
    }

    @Step("Проверяется количество поисковых запросов в истории посика")
    public P checkSearchHistoryQueryCount() {
        int numberTips = 2;
        List<WebElement> historyList = getSearchHistory();
        postponedAssertTrue(historyList.size() <= numberTips, "Подсказок больше " + numberTips);
        return (P) this;
    }

    @Step("Проверяется внещний вид истории поискоых запросов")
    public P checkSearchHistoryLayout() {
        List<WebElement> historyList = getSearchHistory();
        if (!historyList.isEmpty()) {
            postponedAssertNotNull(historyList.get(0).getCssValue("background-image"), "Не отображается 'Лупа'");
        } else {
            setPostponedTestFail("История поисковых запросов не отображается.");
        }
        return (P) this;
    }

    @Step("Проверяется что поиск запущен по запрос из истории запросов")
    public P checkCurrentUrlContainsUrlFirstQueryFromSearchHistory() {
        String expectedUrl = String.valueOf(getParameter(QUERY_URL));
        postponedAssertTrue(getCurrentUrl().contains(expectedUrl), "Открылась не та ссылка");
        return (P) this;
    }

    @Step("Открыть первый запрос из истории")
    public P clickFirstItemFromSearchHistory() {
        WebElement firstQuery = getSearchHistory().get(0);
        String expectedUrl = firstQuery.getAttribute("href");
        setParameter(QUERY_URL, expectedUrl);
        firstQuery.click();
        return (P) this;
    }

    public P checkSearchHistory(boolean isEmptyQuery, String query) {
        int numberTips = 2;
        List<WebElement> historyList = getSearchHistory();
        postponedAssertTrue(historyList.size() <= numberTips, "Подсказок больше " + numberTips);

        if (!isEmptyQuery) {
            for (WebElement tips : historyList) {
                postponedAssertTrue(tips.getText().contains(query), "Выделенная поисковые подсказки не соответсвуют запросу");
            }
        }

        postponedAssertNotNull(historyList.get(0).getCssValue("background-image"), "Не отображается 'Лупа'");

        historyList.get(0).click();
        postponedAssertTrue(getCurrentUrl().contains(historyList.get(0).getAttribute("href")), "Открылась не та ссылка");
        return (P) this;
    }

    public List<WebElement> getTips() {
        findElementBy(By.id("search-text")).sendKeys(Keys.ARROW_RIGHT);
        waitFewSecond(2000);
        WebElement ulTips = findElementBy(By.xpath(".//body/ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']"));
        List<WebElement> li = ulTips.findElements(By.tagName("li"));
        return li;
    }

    public P checkSearchStraightTip() {
        List<WebElement> liTips = getTips();
        int straight = 0;
        int tip = 0;

        for (WebElement li : liTips) {
            if (!(li.getAttribute("class").contains("history-doc"))) {
                if (li.getAttribute("class").contains("hint-doc")) {
                    straight++;
                    String script = "return window.getComputedStyle(document.querySelector('.ui-menu-item.hint-doc a'),':before').getPropertyValue('background-image')";
                    JavascriptExecutor js = (JavascriptExecutor) getDriver();
                    String content = (String) js.executeScript(script);
                    postponedAssertNotEquals(content, "", "В подсказке с прямым переходом не отображается значок раздела");
                    continue;
                }
                if (li.getAttribute("class").contains("ui-menu-item")) {
                    tip++;
                }
            }
        }
        postponedAssertTrue(straight <= 1, "Подказок с прямым переходом больше 1");
        postponedAssertTrue(tip <= 10, "Обычных подсказок больше 10");
        return (P) this;
    }

    private void resetSearchBox() {
        findElementBy(By.id("search-button-reset")).click();
    }

    private List<WebElement> getSearchHistory() {
        findElementBy(By.id("search-text")).sendKeys(Keys.ARROW_RIGHT);
        findElementBy(By.id("search-text")).sendKeys(Keys.ARROW_RIGHT);
        findElementBy(By.id("search-text")).sendKeys(Keys.ARROW_RIGHT);
        findElementBy(By.id("search-text")).sendKeys(Keys.ARROW_RIGHT);
        findElementBy(By.id("search-text")).sendKeys(Keys.ARROW_RIGHT);
        waitFewSecond(2000);

        WebElement downMenu = waitForPresenceOfElementLocatedBy(By.id("ui-id-1"));
        String styleAttribute = downMenu.getAttribute("style").replaceAll("display: block;", "display:;").replaceAll("display: none;", "display:;");
        executeScript("arguments[0].setAttribute('style', '" + styleAttribute + "')", downMenu);

        return findElementsBy(By.xpath(".//li[@class='history-doc ui-menu-item']/a"));
    }

    public P checkQueryIsPresentInSearchHistory(String query) {
        resetSearchBox();
        List<WebElement> historyList = getSearchHistory();

        boolean presentSearchQuery = false;
        for (WebElement tips : historyList) {
            if (!presentSearchQuery && tips.getText().toLowerCase().contains(query.toLowerCase())) {
                presentSearchQuery = true;
                break;
            }
        }
        postponedAssertTrue(presentSearchQuery, "В поисковой истории Отсутствует запрос '" + query + "'");
        return (P) this;
    }

    public P checkQueryIsNotPresentInSearchHistory(String query) {
        resetSearchBox();
        List<WebElement> historyList = getSearchHistory();
        for (WebElement tips : historyList) {
            postponedAssertFalse(tips.getText().contains(query), "В поисковую историю попал неверный запрос '" + query + "'");
        }
        return (P) this;
    }

    public P checkNotPresentSearheQueryInHistory() {
        resetSearchBox();
        List<WebElement> histiryList = getSearchHistory();
        for (WebElement histiry : histiryList) {
            postponedAssertFalse(histiry.isDisplayed(), "Отображаются поисковые подсказки");
        }
        return (P) this;
    }

    @Step("Проверка поиска с фильтром")
    public P checkMainSearchFilter(String query, String type, String city) {
        WebElement form = setExtendedParameters(type, city);

        form.findElement(By.id("button-search-extended")).click();

        waitForReloadingPage();

        findElementBy(By.id("search-button-reset")).click();

        resetSearchBox();
        List<WebElement> histiryList = getSearchHistory();
        postponedAssertTrue(histiryList.get(0).getText().equals(query), "Последний поисковый запрос не соответсвует " + query);
        histiryList.get(0).click();
        List<WebElement> filtrs = findElementsBy(By.xpath(".//div/div[@class='search-extended-string']/span"), "Поисковые реквизиты не найдены");
        postponedAssertTrue(filtrs.get(0).getText().equals("«" + type + "»"), "Фильтр по типам не соответствует. Ожидалось: " + type + " На сайте: " + filtrs.get(0).getText());
        postponedAssertTrue(filtrs.get(1).getText().equals("«" + city + "»"), "Фильтр по регионам не соответствует. Ожидалось: " + city + " На сайте: " + filtrs.get(1).getText());
        return (P) this;
    }

    public WebElement setExtendedParameters(String type, String city) {
        WebElement form = findElementBy(By.id("search-form-extended"));

        findElementBy(By.id("search-button-extended"), "Кнопка поиска по реквизитам не найдена").click();
        List<WebElement> typeList = form.findElement(By.id("typelist")).findElements(By.tagName("li"));
        for (WebElement typeElement : typeList) {
            if (typeElement.getText().equals(type))
                typeElement.click();
        }

        List<WebElement> regionList = form.findElement(By.id("regionlist")).findElements(By.tagName("li"));
        for (WebElement regionElement : regionList) {
            if (regionElement.getText().equals(city))
                regionElement.click();
        }
        return form;
    }

    @Step("Нажать кнопку Найти")
    public SearchResultHelper clickSearchButtonAndNavigateToSearchResultHelper() {
        clickSearchButton();
        return redirectTo(SearchResultHelper.class);
    }

    public P checkSearchBlockNotWidget(String QUERY) {
        inputTextInSearchBox(QUERY);
        clickSearchButtonAndNavigateToSearchResultHelper()
//                .checkAddedSearchResultAtScroll()
                .checkSearchResultBlock(false);
        return (P) this;
    }

    public P checkSearchBlocksArePresentAndNewBlocksAreLoaded(String QUERY) {
        inputTextInSearchBox(QUERY);
        clickSearchButtonAndNavigateToSearchResultHelper()
                .checkAddedSearchResultAtScroll();
        return (P) this;
    }

    public P checkHighlightingRequest(String query) {
        inputTextInSearchBox(query);
        clickSearchButtonAndNavigateToSearchResultHelper()
                .checkSearchQueryIsHighlighted(query)
                .openRandomPhraseSearchDocument()
                .checkDocumentIsNotEmpty()
                .checkHighlightingWordDocument();
        return (P) this;
    }

    public P checkOpenDocument(String query) {
        inputTextInSearchBox(query);
        clickSearchButtonAndNavigateToSearchResultHelper()
                .checkSearchQueryIsHighlighted(query)
                .openRandomSearchDocument()
                .checkDocumentIsNotEmpty()
                .checkHighlightingWordDocument();
        return (P) this;
    }

    public P checkOpenDocumentNotCheckHighlightingWordDocument(String query) {
        inputTextInSearchBox(query);
        clickSearchButtonAndNavigateToSearchResultHelper()
                .openRandomSearchDocument()
                .checkDocumentIsNotEmpty();
        return (P) this;
    }

    public P checkNavigateToDirectLink() {
        List<WebElement> tips = getTips();
        for (WebElement li : tips) {
            if (li.getAttribute("class").contains("hint-doc")) {
                String url = li.findElement(By.tagName("a")).getAttribute("href");
                li.findElement(By.xpath("./a/span")).click();
                String currentUrl = getCurrentUrl().split("#")[1];
                String expectedUrl = url.split("#")[1];
                //example: if current urn is '/?#/document/88/2748183/?step=7', then expected urn is '/#/document/88/2748183'
                //parse uri into urn and find index of that
                postponedAssertTrue(currentUrl.contains(expectedUrl), "Открыт не тот докумет. Ожидалось: " + url + "Открыт : " + getCurrentUrl());
                break;
            }
        }
        returnToBack();
        waitForReloadingPage();
        return (P) this;
    }

    @Step("В выпадающем меню подсказок выбрать подсказку с прямым переходом")
    public P chooseDirectTipFromToolTips() {
        WebElement hintDoc = findElementBy(By.cssSelector(".hint-doc"));
        postponedAssertTrue(hintDoc.isDisplayed(), "Подсказка с прямым переходом не отображается в выпадающем меню");

        List<WebElement> elements = findElementsBy(By.xpath("//body/ul/li"));
//        WebElement tooltips = findElementBy(By.xpath("//body/ul/"));
        boolean isFound = false;

        for (int i = 0; i < 11; i++) { //cycle for tooltips, 11 is maximum of press down key (if tooltip has 10 tips)
            if (elements.get(i).getAttribute("class").contains(".hint-doc")) {
                isFound = true;
                break;
            }
            hintDoc.sendKeys(Keys.ARROW_DOWN);
        }
        postponedAssertTrue(isFound, "Подсказка с прямым переходом не может быть выделена с помощью клавиши Вниз");
        setParameter(directLinkTooltip, hintDoc.getText());
        return (P) this;
    }

    @Step("Нажать на кнопку Enter в меню подсказок")
    public P pressEnterKeyForToolTips() {
        WebElement hintDoc = findElementBy(By.cssSelector(".hint-doc"));
        hintDoc.sendKeys(Keys.ENTER);
        return (P) this;
    }

    @Step("Открывается соответствующий документ")
    public P checkOpenRequiredDocument() {
        postponedAssertEquals(getDriver().getCurrentUrl(), getParameter(directLinkTooltip), "Открыт не тот документ. " +
                "Ожидалось:" + getParameter(directLinkTooltip) + " но открыт:" + getDriver().getCurrentUrl());
        return (P) this;
    }

    public P checkNavigateToLink() {
        List<WebElement> tips = getTips();
        String activeMenu = getActiveMenuName();
        for (WebElement li : tips) {
            if (!li.getAttribute("class").contains("hint-doc") && !li.getAttribute("class").contains("history-doc")) {
                String query = li.findElement(By.tagName("a")).getText();
                li.findElement(By.xpath("./a/span")).click();
                waitForReloadingPage();
                postponedAssertEquals(activeMenu, getActiveMenuName(), "Поиск открыл в разделе:" + getActiveMenuName() + "Ожидалось: " + activeMenu);
                String searchResult = waitForPresenceOfElementLocatedBy(By.xpath(".//div[@class='search-result']/h1"), "Результаты поиска не отображаются").getText();
                postponedAssertEquals(searchResult.toLowerCase(), "«" + query.toLowerCase() + "»", "Поисковая выдача по запросу: " + searchResult + "Ожидалось: " + query);
                break;
            }
        }
        returnToBack();
        return (P) this;
    }

    public String getActiveMenuName() {
        List<WebElement> mainMenuItems = findElementBy(By.id("main-menu")).findElements(By.tagName("li"));
        for (WebElement itemMenu : mainMenuItems) {
            if (itemMenu.getAttribute("class").contains("active"))
                return itemMenu.getText();
        }
        return null;
    }

    public P checkClickKeysInToolTops() {
        List<WebElement> tips = getTips();
        int tip = 0;
        for (int i = 0; i < tips.size(); i++) {
            findElementBy(By.id("search-text")).sendKeys(Keys.ARROW_DOWN);
            waitFewSecond(2000);
            WebElement focusItem = findElementBy(By.cssSelector(".ui-state-focus"));
            String background = focusItem.getCssValue("background-color");
            String color = focusItem.getCssValue("color");
            String focusText = focusItem.getText();
            String textSearchInput = searchBox.getText();
            postponedAssertNotNull(background, "Выбранный элемент не подсвечивается");
            postponedAssertNotNull(color, "Выбранный элемент не изменил цвет");
            postponedAssertEquals(focusText.trim().toLowerCase(), textSearchInput.trim().toLowerCase(), "Выделенный текст: " + focusText + "Текст в поисковой строке: " + textSearchInput);

            if ((!tips.get(i).getAttribute("class").contains("history-doc")) && (!tips.get(i).getAttribute("class").contains("hint-doc"))) {
                tip++;
            }
        }
        findElementBy(By.id("search-text")).sendKeys(Keys.ARROW_UP);
        waitFewSecond(2000);
        findElementBy(By.id("search-text")).sendKeys(Keys.ARROW_DOWN);
        waitFewSecond(2000);
        WebElement focusItem = findElementBy(By.cssSelector(".ui-state-focus"));
        String query = focusItem.getText();
        findElementBy(By.id("search-text")).sendKeys(Keys.ENTER);
        waitForReloadingPage();
        if (tip == 0) {
            String url = focusItem.getAttribute("href");
            postponedAssertTrue(getCurrentUrl().contains(url), "Открыт не тот докумет. Ожидалось: " + url + "Открыт : " + getCurrentUrl());
        } else {
            String activeMenu = getActiveMenuName();
            postponedAssertEquals(activeMenu, getActiveMenuName(), "Поиск открыл в разделе:" + getActiveMenuName() + "Ожидалось: " + activeMenu);
            String searchResult = findElementBy(By.xpath(".//div[@class='search-result']/h1")).getText();
            postponedAssertEquals(searchResult.toLowerCase(), "«" + query.toLowerCase() + "»", "Поисковая выдача по запросу: " + searchResult + "Ожидалось: " + query);
        }
        return (P) this;
    }

    @Step("Нажать два раза кнопку вниз и один раз вверх")
    public P pressKeysDownTwoTimesAndUpOneTime() {
        WebElement toolTipMenu = findElementBy(By.xpath("//body/ul/li[1]/a/span"));
        toolTipMenu.sendKeys(Keys.ARROW_DOWN);
        toolTipMenu.sendKeys(Keys.ARROW_DOWN);
        toolTipMenu.sendKeys(Keys.ARROW_UP);
        return (P) this;
    }

    @Step("Строка с соответствующей подсказкой в списке выделяется желтым")
    public P checkTipIsYellow() {
        WebElement yellowTip = findElementBy(By.cssSelector(".ui-state-focus"));
        postponedAssertTrue(yellowTip.isDisplayed(), "Подсказка не выделяется желтым");
        String actualYellowTip = yellowTip.getText();
        List<WebElement> tips = findElementsBy(By.xpath("//body/ul/li"));
        postponedAssertEquals(actualYellowTip, tips.get(1).getText(), "Выделена желтым не та подсказка");
        return (P) this;
    }

    public P checkNavigateToLinkExtended() {
        List<WebElement> tips = getTips();
        for (WebElement li : tips) {
            if (!li.getAttribute("class").contains("hint-doc") && !li.getAttribute("class").contains("history-doc")) {
                String query = li.findElement(By.tagName("a")).getText();
                li.click();
                postponedAssertNull(findElementByNoThrow(By.xpath(".//div[@class='search-result']/h1")), "Запустился поиск по клику в реквизитах");
                String searchResult = searchBox.getText();
                postponedAssertEquals(searchResult.toLowerCase(), query.toLowerCase(), "В поисковой строке текст: " + searchResult + "Ожидалось: " + query);
                break;
            }
        }
        returnToBack();
        return (P) this;
    }

    public String getPropertyValueElementBefore(String querySelector, String propertyValue) {
        String script = "return window.getComputedStyle(document.querySelector(\"" + querySelector + "\"),':before').getPropertyValue('" + propertyValue + "')";
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return (String) js.executeScript(script);
    }

    public String getPropertyValueElementAfter(String querySelector, String propertyValue) {
        String script = "return window.getComputedStyle(document.querySelector(\"" + querySelector + "\"),':after').getPropertyValue('" + propertyValue + "')";
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return (String) js.executeScript(script);
    }

    public void clickAboutSystem() {
        waitForPresenceOfElementLocatedBy(By.linkText("О системе")).click();
        waitForReloadingPage();
    }

    public P checkSearchMenuDetails() {
        extendedSearchForm.checkOpenedSearchExtended();
        extendedSearchForm.checkNotDisplaySearchButton();
        extendedSearchForm.checkDisplayCheckboxOnlyTitle();
        extendedSearchForm.checkDisplayNumber();
        extendedSearchForm.checkDisplayDate();
        extendedSearchForm.checkDisplayLabelType();
        extendedSearchForm.checkDisplayLabelLobby();
        extendedSearchForm.checkDisplayLabelRegion();
        extendedSearchForm.selectTypeByName("Закон");
        extendedSearchForm.checkSearchDescription();
        extendedSearchForm.checkSearchButtonInExtendedFormIsPresent();
        return (P) this;
    }

    private synchronized GlavbukhSoap_PortType getGlavbukhService() {
        GlavbukhSoap_PortType glavbukhService = null;
        try {
            GlavbukhLocator locator = new GlavbukhLocator();
            locator.setGlavbukhSoapEndpointAddress(getSettings().getGlavbukhServiceUrl());
            locator.setGlavbukhSoap12EndpointAddress(getSettings().getGlavbukhServiceUrl());
            glavbukhService = locator.getGlavbukhSoap();
        } catch (ServiceException e) {
            logger.error("ServiceException occurs", e);
        }
        return glavbukhService;
    }

    /**
     * Позволяет получить список назвнаний рубрик и документов. Порядок документов может отличаться
     * от того, что выведен на сайте. Порядок рубрик должен быть сохранен.
     *
     * @param pubId Ид раздела. 1	Рекомендации    2	Справочная информация    3	Правовая база
     *              5	Журнал    6	Сервисы    7	Формы    8	Видео    9	Мастера
     * @return Список строк - названий.
     */
    public List<String> getRubricatorContent(int pubId) {
        List<String> rubricNames = new ArrayList<String>();
        UnsignedByte pubDivId = new UnsignedByte(pubId);

        GlavbukhSoap_PortType gsp = getGlavbukhService();
        try {
            MessageElement messageElement = gsp.rubricator(pubDivId).get_any()[0];
            ServiceResponse response = new MessageElementConverter(messageElement).getResponse();

            NodeElement rubricList = response.getNodeElementListByName("rubricator").get(0);
            List<NodeElement> names = rubricList.getChildrenListByName("name");

            for (NodeElement name : names) {
                if (!name.getParent().getName().equals("rubricator")) {
//                    rubricNames.add(name.getValue());
                    if (name.getParent().getName().equals("document")) {
                        System.out.print("doc:");
                    }
                    System.out.println(name.getValue()); // name
                }
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
        return rubricNames;
    }

    public P checkSearchFirstBlockResult(int results) {
        getHelper(SearchResultHelper.class).checkSearchBlockResult(1, results);
        return (P) this;
    }

    public P checkWidgetContentAnyTypeArePresent(int minCountWidgets, int maxResultsIntoWidget) {
        getHelper(SearchResultHelper.class).checkWidgetContentAnyTypeArePresent(minCountWidgets, maxResultsIntoWidget);
        return (P) this;
    }

    public P checkSearchSecondBlockResult(int results) {
        getHelper(SearchResultHelper.class).checkSearchBlockResult(2, results);
        return (P) this;
    }

    public P checkSearchThirdBlockResult(int results) {
        getHelper(SearchResultHelper.class).checkSearchBlockResult(3, results);
        return (P) this;
    }

    public P checkSearchPartLoadedBlocksResult(int result) {
        getHelper(SearchResultHelper.class).checkSearchPartLoadedBlocksResult(result);
        return (P) this;
    }

    public P checkSearchLastBlockResult(int maxCountResult) {
        getHelper(SearchResultHelper.class).checkSearchLastBlockResult(maxCountResult);
        return (P) this;
    }

    public P checkSearchResultBeforeShowMoreButton(int blockNumber, int maxCountResult) {
        getHelper(SearchResultHelper.class).checkSearchResultBeforeShowMoreButton(blockNumber, maxCountResult);
        return (P) this;
    }

    public P checkSearchResultAfterShowMoreButton(int blockNumber, int maxCountResult) {
        getHelper(SearchResultHelper.class).checkSearchResultAfterShowMoreButton(blockNumber, maxCountResult);
        return (P) this;
    }

    public P clickShowMoreButton() {
        getHelper(SearchResultHelper.class).clickShowMoreButton();
        return (P) this;
    }

    public P goBack() {
        returnToBack();
        waitForReloadingPage();
        return (P) this;
    }

    public P clickExtendedButtonInSearchBox() {
        WebElement buttonExtended = findElementByNoThrow(By.id("search-button-extended"));
        buttonExtended.click();
        waitForReloadingPage();
        waitForVisibilityOfElementLocatedBy(By.cssSelector("form[id='search-form-extended']"), "Форма расширенного поиска не найдена");
        return (P) this;
    }

    public P checkClearFieldsIsPresent() {
        extendedSearchForm.checkClearFieldsIsPresent();
        return (P) this;
    }

    public P checkExactPhraseIsNotActivated() {
        extendedSearchForm.checkExactPhraseIsNotActivated();
        return (P) this;
    }

    public P checkExactPhraseIsActivated() {
        extendedSearchForm.checkExactPhraseIsActivated();
        return (P) this;
    }

    public P checkExactPhraseIsNotChecked() {
        extendedSearchForm.checkExactPhraseIsNotChecked();
        return (P) this;
    }

    public P inputInTypeTextField(String type) {
        extendedSearchForm.inputInTypeTextField(type);
        return (P) this;
    }

    public P inputInLobbyTextField(String lobby) {
        extendedSearchForm.inputInLobbyTextField(lobby);
        return (P) this;
    }

    public P inputInRegionTextField(String region) {
        extendedSearchForm.inputInRegionTextField(region);
        return (P) this;
    }

    public P checkLobbyListItemsContainText(String lobby) {
        extendedSearchForm.checkLobbyListItemsContainText(lobby);
        return (P) this;
    }

    public P checkSearchBodyResultTextInPractice() {
        extendedSearchForm.checkSearchBodyResultTextInPractice();
        return (P) this;
    }

    @Step("Открыть страницу приложения 'Профиздания'")
    public P checkProfEditionsPage() {
        String currentUrl = getCurrentUrl();
        String appStorePath = "/appstore/about-sys.html";
        openUrl(currentUrl + appStorePath, false);
        waitForPresenceOf(findElementBy(By.xpath("//body/p/strong")));
        String text = findElementBy(By.xpath("//body")).getText();
        text = new String(text.getBytes(Charset.defaultCharset()));
        String actualText = "";
        String resources = "/service/";
        String fileName = "";

        if (getSettings().isRunBss()) {
            fileName = "about_sys_bss.txt";
        } else if (getSettings().isRunUss()) {
            fileName = "about_sys_uss.txt";
        } else if (getSettings().isRunFss()) {
            fileName = "about_sys_fss.txt";
        }
        try {
            actualText = IOUtils.toString(getClass().getResourceAsStream(resources + fileName));
        } catch (IOException e) {
            fail("Не найден файл с текстом страницы для приложения 'Профиздания'");
        }
        postponedAssertEquals(actualText, text, "Текст на странице приложения не совпадает. Должен быть:" + text + ", но имеет значение:" + actualText);
        return (P) this;
    }

    protected void checkTagTitle(String expectedTitle) {
        String title = getDriver().getTitle().replaceAll("\u00A0", " ").replaceAll("  ", " ");
        postponedAssertEquals(title, expectedTitle, "Значение тега title:" + title + " не совпадает с искомым:" + expectedTitle);
    }

    public void closePopUp() {
        WebElement body = waitForVisibilityOfElementLocatedBy(By.tagName("body"), "Страница не найдена");
        List<WebElement> popUpCloseButtonList = findElementsByNoThrow(body, By.cssSelector(".popup-close-rounded"));
        WebElement ussPopUp = findElementByNoThrow(body, By.id("chgk_popup"));
        WebElement survey = findElementByNoThrow(body, By.id("survey-on-exit-close"));
        List<WebElement> popUpCloseList = body.findElements(By.cssSelector("[class*='popup'] [class*='close']"));

        if (popUpCloseButtonList != null) {
            for (WebElement popUpCloseButton : popUpCloseButtonList) {
                if (popUpCloseButton.isDisplayed()) {
                    popUpCloseButton.click();
                }
            }
        }

        if (ussPopUp != null && ussPopUp.isDisplayed()) {
            ussPopUp.findElement(By.cssSelector("[style*='background-image:']")).click();
        }

        if (survey != null && survey.isDisplayed()) {
            survey.click();
        }

        for (WebElement popUpClose : popUpCloseList) {
            if (popUpClose.isDisplayed()) {
                popUpClose.click();
            }
        }

        List<WebElement> popUpCloseList2 = body.findElements(By.cssSelector(".popup__close"));
        for (WebElement popUpClose : popUpCloseList2) {
            if (popUpClose.isDisplayed()) {
                popUpClose.click();
            }
        }

        List<WebElement> popUpCloseList3 = body.findElements(By.cssSelector("[title='Закрыть']"));
        for (WebElement popUpClose : popUpCloseList3) {
            if (popUpClose.isDisplayed()) {
                try {
                    popUpClose.click();
                } catch (WebDriverException ignored) {
                }
            }
        }
    }

    @Step("Проверить что форма Предемо не появляется")
    public P checkPopupPreDemoIsNotPresent() {
        WebElement popupPreDemo = findElementByNoThrow(By.id("popup_content_predemo"));
        postponedAssertTrue(popupPreDemo == null || !popupPreDemo.isDisplayed(), "Форма Предемо отображена");
        return (P) this;
    }

    @Step("Проверить что Появилась форма Предемо")
    public P checkPopupPreDemoIsPresent() {
        WebElement popupPreDemo = findElementByNoThrow(By.id("popup_content_predemo"));
        postponedAssertTrue(popupPreDemo != null && popupPreDemo.isDisplayed(), "Форма Предемо не отображена");
        return (P) this;
    }

    @Step("Нажать на кнопку Закрыть формы Предемо")
    public P clickOnClosePopupPreDemo() {
        WebElement closePreDemo = findElementByNoThrow(By.cssSelector("#popup_content_predemo .popup__close"));
        closePreDemo.click();
        waitForReloadingPage();
        return (P) this;
    }

    @Step("Проверить что форма Предемо не появляется")
    public P checkPopupPredemoIsNotPresent() {
        WebElement popupPredemo = findElementByNoThrow(By.id("popup_content_predemo"));
        postponedAssertTrue(popupPredemo == null || !popupPredemo.isDisplayed(), "Форма Предемо отображена");
        return (P) this;
    }

    public P checkPopupPredemoIsPresent() {
        getHelper(PredemoPopup.class).checkPopupIsPresent();
        return (P) this;
    }

    public P clickOnPopupPredemoIconClose() {
        getHelper(PredemoPopup.class).clickOnIconClose();
        return (P) this;
    }

    public P checkPopupPredemoContentHasText() {
        getHelper(PredemoPopup.class).checkContentHasText();
        return (P) this;
    }

    public P checkPopupPredemoFullNameIsPresent() {
        getHelper(PredemoPopup.class).checkTextFieldFullNameIsPresent();
        return (P) this;
    }

    public P checkPopupPredemoEmailIsPresent() {
        getHelper(PredemoPopup.class).checkTextFieldEmailIsPresent();
        return (P) this;
    }

    public P checkPopupPredemoButtonGetAccessIsPresent() {
        getHelper(PredemoPopup.class).checkButtonGetAccess();
        return (P) this;
    }

    public P checkPopupPredemoButtonCloseIsPresent() {
        getHelper(PredemoPopup.class).checkButtonClose();
        return (P) this;
    }

    public P checkPopupPredemoWithResolution1000x500() {
        setSizeWindows(1000, 500);
        waitForReloadingPage();
        int y = getHelper(PredemoPopup.class).getYPositionForGetAccessButton();
        getHelper(PredemoPopup.class).hookForScrolling();
        postponedAssertTrue(y > getHelper(PredemoPopup.class).getYPositionForGetAccessButton(), "Позиция кнопки Получить доступ после скроллинга не изменилась");
        maximize();
        return (P) this;
    }

    @Step("Перейти по ссылке:{0}")
    public P openPageByUrl(String url) {
        openUrl(url, true);
        return (P) this;
    }

    @Step("Перейти по частичной ссылке:{0}")
    public P openPageByPartUrl(String partUrl) {
        String host = getCurrentUrl().split("#")[0];
        openUrl(host + partUrl, true);
        return (P) this;
    }

    @Step("Проверка выбранного пункта меню")
    public P checkCurrentItemIsSelected(MainMenuButtons mainMenuButton) {
        String actualItemName = waitForPresenceOfElementLocatedBy(By.cssSelector(".btn_state_active"), "Не один раздел не выбран в главном меню").getText();
        postponedAssertEquals(actualItemName, mainMenuButton.getName(), "Выбран неправильный раздел в главном меню");
        return (P) this;
    }

    /**
     * The general way for getting the text of a specific element without including the text of it's children.
     * <p>
     * Returns a {@link String} with the text
     *
     * @param element - {@link WebElement} which contain the text and a children with a text
     */
    protected String hookForGettingTextWithoutIncludingChildElementsText(WebElement element) {
        return (String) executeScript("var parent = arguments[0];" +
                "var child = parent.firstChild;" +
                "var ret = \"\";" +
                "while(child) {" +
                "    if (child.nodeType === Node.TEXT_NODE)" +
                "        ret += child.textContent;" +
                "    child = child.nextSibling;" +
                "}" +
                "return ret;", element);
    }

    @Step("Проверить, что отображается рубрикатор избранного")
    public P checkFavoritesRubricatorIsPresent() {
        WebElement rubricator = findElementByNoThrow(By.id("main-bookmarks"));
        postponedAssertTrue(rubricator != null && rubricator.isDisplayed(), "Рубрикатор избранного не отображается");
        return (P) this;
    }

    @Step("Проверяется что кнопка рубрикатора {0} отображается")
    public P checkRubricatorButtonIsPresent(String buttonName) {
        WebElement rubricatorButton = waitForPresenceOfElementLocatedBy(By.id("rubricator-btn"), "Кнопка '" + buttonName + "' Отсутствует");
        postponedAssertEquals(rubricatorButton.getText(), buttonName, "Неправильный текст кнопки '" + buttonName + "'");
        return (P) this;
    }

    protected void hookSearchResultVisible() {
        executeScript("document.getElementsByClassName('ui-autocomplete')[0].setAttribute('style','display:block;')");
        waitForReloadingPage();
    }

    protected void openDocumentByUrlWithWaiting(String partialDocUrl) {
        String currentUrl = getCurrentUrl().split("#")[0];
        String documentUrl = currentUrl + partialDocUrl;
        report("Открывается ссылка: " + documentUrl);
        openUrl(documentUrl, true);
    }

    protected boolean checkSelectedItemInRubricator(String itemMenu) {
        WebElement rubricator = waitForVisibilityOfElementLocatedBy(By.id("rubricator"), "Рубрикатор для '" + itemMenu + "' не отображается");

        int indexMenuItem = getIndexForMenuItem(itemMenu);

        if (indexMenuItem == -1) {
            setPostponedTestFail("Раздел " + itemMenu + " не найден в рубрикаторе");
            return false;
        }

        List<WebElement> list = getItemsList(rubricator);
        WebElement activeItem = list.get(indexMenuItem).findElements(By.cssSelector(".b-list__item")).get(0);
        String activeItemLink = activeItem.findElement(By.tagName("a")).getAttribute("class");
        postponedAssertTrue(activeItemLink.contains("b-link_state_active"), "Выбран не первый элемент для рубрикатора '" + itemMenu + "'");
        return true;
    }

    private List<WebElement> getItemsList(WebElement rubricator) {
        List<WebElement> itemList = new ArrayList<WebElement>();
        List<WebElement> list = rubricator.findElements(By.cssSelector(".b-list"));
        for (WebElement item : list) {
            if (!item.getAttribute("class").contains("multigroup")) {
                itemList.add(item);
            }
        }
        return itemList;
    }

    private int getIndexForMenuItem(String menuItem) {
        WebElement mainMenu;
        mainMenu = waitForPresenceOfElementLocatedBy(By.cssSelector(".b-rubricator-list"));
        List<WebElement> menuItems = mainMenu.findElements(By.tagName("h3"));
        for (int i = 0; i < menuItems.size(); i++) {
            String menuItemText;
            WebElement menuItemElement = menuItems.get(i);
            WebElement announceElement = findElementByNoThrow(menuItemElement, By.cssSelector(".b-rubricator-list__title-badge"));
            if (announceElement != null) {
                menuItemText = menuItemElement.getText().replace(announceElement.getText(), "");
            } else {
                menuItemText = menuItemElement.getText();
            }
            if (menuItemText.equals(menuItem)) {
                return i;
            } else if (EXCLUDE_RUBRICATOR_NAMES_FROM_YELLOW_PLATE.containsKey(menuItem)) {
                if (menuItemText.contains(EXCLUDE_RUBRICATOR_NAMES_FROM_YELLOW_PLATE.get(menuItem))) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Step("Проверяется работа ссылок на рубрикаторы из желтой плашки")
    public P checkRubricatorLinksFromYellowPlate() {
        String rubricatorName = getHelper(YellowPanel.class).clickOnNextRubricatorsLink();
        while (rubricatorName != null) {
            report("Проверяется работа ссылки для '" + rubricatorName + "'");
            if (checkSelectedItemInRubricator(rubricatorName)) {
                WebElement content = waitForVisibilityOfElementLocatedBy(By.id("rubricator-right"), "Рубрикатор не найден");
                waitForTextToBePresentInWithErrorMessage(content, "Содержание для " + rubricatorName + " Отсутствует");
            }
            waitForPresenceOfElementLocatedBy(By.id("rubricator-close")).click();
            rubricatorName = getHelper(YellowPanel.class).clickOnNextRubricatorsLink();
        }
        return (P) this;
    }

    @Step("Очистить меню 'Мое избранное' от закладок")
    protected P removeAllBookmarksFromMenu() {
        WebElement myFavoritesMenu = waitForVisibilityOfElementLocatedBy(By.id("main-bookmarks"), "Меню 'Мое избранное' не отображается");
        if (findElementByNoThrow(By.id("my-documents-bookmarks-content")) != null) {
            List<WebElement> deleteItems = myFavoritesMenu.findElements(By.cssSelector(".b-info__delete ins"));
            for (int i = 0; i < deleteItems.size(); i++) {
                waitForVisibilityOfElementLocatedBy(By.cssSelector(".b-info__delete ins")).click();
                waitFewSecond(500);
            }
        }
        return (P) this;
    }

    @Step("Убрать все Руки, указывающую на рубрикатор или новости, под которыми могут находиться элементы")
    public P removeAllTrainingHands() {
        List<WebElement> trainingHands = findElementsByNoThrow(By.cssSelector(".training-hand"));
        if (trainingHands != null) {
            for (WebElement hand : trainingHands) {
                if (hand.isDisplayed()) {
                    executeScript("arguments[0].style.display='none';", hand);
                    waitFewSecond(500);
                }
            }
        }
        return (P) this;
    }

    @Step("Закрыть вcплывывающее окно Получить доступ ко всем материалам если окно открыто")
    public P closePopupInviteDemo() {
        waitForReloadingPage();
        waitFewSecond(2000);//waiting for popup is present
        WebElement closePopupInviteIcon = findElementByNoThrow(By.cssSelector("#popup-invite-demo .popup__close"));
        if (closePopupInviteIcon != null && closePopupInviteIcon.isDisplayed()) {
            closePopupInviteIcon.click();
            waitForReloadingPage();
        }
        return (P) this;
    }
}