package com.actionmedia.pages.helpers;


import com.actionmedia.autotest.selenium.annotations.ErrorMessage;
import com.actionmedia.autotest.selenium.annotations.Wait;
import com.actionmedia.base.BasePage;
import com.actionmedia.components.Link;
import com.actionmedia.util.TestUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class DictionaryPageHelper extends BasePage<DictionaryPageHelper> {

    @FindBy(id = "board")
    @Wait
    @CacheLookup
    @ErrorMessage("Не найден элемент с id = board")
    protected WebElement boardContent;

    @FindBy(css = ".widget_content_calendar")
    @Wait
    @CacheLookup
    @ErrorMessage("Не найден элемент с class = widget_content_calendar")
    protected WebElement calendar;

    @FindBy(id = "document-body")
    @Wait
    @CacheLookup
    @ErrorMessage("Не найден элемент с id = documentBody")
    protected WebElement documentBody;

    @FindBy(css = ".calendar__in")
    @Wait
    @CacheLookup
    @ErrorMessage("Не найден элемент с class = calendar__in")
    protected WebElement documentCalendar;

    public void checkDictionaryBoardIsDisplayed() {
        WebElement board = waitForPresenceOfElementLocatedBy(By.id("board"), "Справочная доска не найдена");
        postponedAssertTrue(board.isEnabled() && board.isDisplayed(), "Справочная доска не отображается");
    }

    public void checkCalendarOnDictionaryBoard() {
        postponedAssertTrue(calendar != null && calendar.isDisplayed(), "'Кадендарь' не отображается на справочной доске");
    }

    public void checkDisplayMrotOnDictionaryBoard() {
        WebElement mrot = findElementByNoThrow(boardContent, By.cssSelector(".sticker_content_wage"));
        postponedAssertTrue(mrot != null && mrot.isDisplayed(), "'МРОТ' не отображается на справочной доске");
    }

    public void checkDisplayPostOnDictionaryBoard() {
        WebElement post = findElementByNoThrow(boardContent, By.cssSelector(".sticker_content_post"));
        postponedAssertTrue(post != null && post.isDisplayed(), "'Карточка Должностей' не отображается на справочной доске");
    }

    public void checkDisplayCurrencyOnDictionaryBoard() {
        WebElement currency = findElementByNoThrow(boardContent, By.cssSelector(".sticker_content_currency"));
        assertTrue(currency != null && currency.isDisplayed(), "'Курс валют' не отображается на справочной доске");

        List<Link> links = new ArrayList<Link>();
        WebElement usd = findElementByNoThrow(currency, By.cssSelector(".sticker__text_content_usd"));
        if (usd != null) {
            postponedAssertNotNull(usd.getText(), "Не отображается текуший курс долара");
        } else {
            setPostponedTestFail("Не найден курс USD");
        }

        WebElement eur = findElementByNoThrow(currency, By.cssSelector(".sticker__text_content_eur"));
        if (eur != null) {
            postponedAssertNotNull(eur.getText(), "Не отображается текуший курс евро");
        } else {
            setPostponedTestFail("Не найден курс euro");
        }

        WebElement linkStickerTitle = currency.findElement(By.cssSelector(".sticker__title"));
        WebElement linkExchange = linkStickerTitle.findElement(By.tagName("a"));
        String linkText = linkExchange.getText();
        postponedAssertTrue(linkText.equals("Курсы валют"), "Текс ссылки не соотвествует: " + linkText + "Ожидалось: Курс валют");
        links.add(new Link(linkExchange.getAttribute("href"), linkText));

        String dateText = linkStickerTitle.getText().split("\n")[1];
        DateTime actualDate;
        if (getSettings().isRunFss()) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("dd.MM.yy");
            dateText = TestUtils.monthToOriginalForm(dateText);
            actualDate = dateTimeFormatter.withLocale(new Locale("ru")).parseDateTime(dateText.substring(2).trim());
        } else {
            DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("dd MMMM yyyy");
            actualDate = dateTimeFormatter.withLocale(new Locale("ru")).parseDateTime(dateText);
        }

        DateTime expectedDate = new DateTime().withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0);
        postponedAssertEquals(actualDate, expectedDate, "Неправильная дата в виджете 'Курса валют'");

        checkLinks(links);
    }

    public void checkRefinancingRateOnDictionaryBoard() {
        WebElement currency = boardContent.findElement(By.cssSelector(".sticker_content_refinancing-rate"));
        WebElement sticker = currency.findElement(By.cssSelector(".sticker__in"));
        String refinancingText = sticker.findElement(By.cssSelector(".sticker__text")).getText();
        postponedAssertTrue(refinancingText != null && !refinancingText.isEmpty(), "Ставка рефинансирования не отображается");

        WebElement refinancingLink = sticker.findElement(By.cssSelector(".sticker__title .link"));
        String refinancingUrl = refinancingLink.getAttribute("href");
        String refinancingHeader = refinancingLink.getText();
        postponedAssertEquals(refinancingHeader, "Ключевая ставка и ставка рефинан-\n" +
                "сирования", "Не совпадет текст 'Ставка рефинансирования'");
        List<Link> links = new ArrayList<Link>();
        links.add(new Link(refinancingUrl, refinancingHeader));
        checkLinks(links);
    }

    public void checkDisplayReviewOnDictionaryBoard() {
        WebElement review = findElementByNoThrow(boardContent, By.cssSelector(".sticker_content_review"));
        postponedAssertTrue(review != null && review.isDisplayed(), "'Обзоры' не отображается на справочной доске");
    }

    public void checkDisplayAddressOnDictionaryBoard() {
        WebElement address = findElementByNoThrow(boardContent, By.cssSelector(".sticker_content_address"));
        postponedAssertTrue(address != null && address.isDisplayed(), "'Адреса и телефоны судов' не отображается на справочной доске");
    }

    public void checkDisplayManualOnDictionaryBoard() {
        WebElement manual = findElementByNoThrow(boardContent, By.cssSelector(".sticker_content_manual"));
        postponedAssertTrue(manual != null && manual.isDisplayed(), "'Как работать с системой' не отображается на справочной доске");
    }

    public void checkDisplayKeyRateOnDictionaryBoard() {
        WebElement keyRate = findElementByNoThrow(boardContent, By.cssSelector(".sticker_content_key-rate"));
        postponedAssertTrue(keyRate != null && keyRate.isDisplayed(), "'Ключевая ставка' не отображается на справочной доске");
    }

    public void checkDisplayFormulaOnDictionaryBoard() {
        WebElement formula = findElementByNoThrow(boardContent, By.cssSelector(".sticker_content_formula"));
        postponedAssertTrue(formula != null && formula.isDisplayed(), "'Формула' не отображается на справочной доске");
    }

    public void checkRefinancingRateInCurrencyOnDictionaryBoard() {
        WebElement refinancingCurrency = findElementByNoThrow(boardContent, By.linkText("Ставка рефинансирования"));
        postponedAssertTrue(refinancingCurrency != null && refinancingCurrency.isDisplayed(), "'Ставка Рефинансирования' не отображается в блоке курса валют на справочной доске");
    }

    public void checkDisplayRefinancingRateOnDictionaryBoard() {
        WebElement refinancingRate = findElementByNoThrow(boardContent, By.cssSelector(".sticker_content_refinancing-rate"));
        postponedAssertTrue(refinancingRate != null && refinancingRate.isDisplayed(), "'Ставка Рефинансирования' не отображается на справочной доске");
    }

    public void checkDictionaryNewsBlockIsDisplayed() {
        WebElement board = waitForPresenceOfElementLocatedBy(By.id("main-left"), "Новостная лента не найдена");
        WebElement headline = board.findElement(By.tagName("h1"));
        postponedAssertTrue(board.isEnabled() && board.isDisplayed(), "Новостная лента не отображается");
        if (getSettings().isRunKss() || getSettings().isRunBss()) {
            postponedAssertTrue(headline.getText().contains("Новое в справочниках"), "Заголовок новостной ленты не отображается");
        } else {
            postponedAssertTrue(headline.getText().contains("Новое в справочнике"), "Заголовок новостной ленты не отображается");
        }
    }

    public void checkPopularBlockIsDisplayed() {
        postponedAssertTrue(sidebarElement.isDisplayed() && sidebarElement.isEnabled(), "Блок Популярное не отображается");
        postponedAssertTrue(findElementBy(sidebarElement, By.tagName("h2")).isDisplayed(), "Заголовок блока популярное не отображается");
        postponedAssertTrue(findElementBy(sidebarElement, By.tagName("h2")).getText().contains("Популярн"), "Неправильный заголовок блока популрное");
    }

    public void checkAllDictionaryRubricatorButtonIsPresent() {
        WebElement rubricatorButton = waitForPresenceOfElementLocatedBy(By.id("rubricator-btn"), "Кнопка Весь справочник Отсутствует");
        postponedAssertTrue(rubricatorButton.getText().contains("Весь справочник"), "Неправильный текст кнопки Весь справочник");
    }

    public void checkHelpersIsDisplayed() {
        WebElement kbk = findElementByNoThrow(sidebarElement, By.cssSelector(".ico_content_kbk"));
        WebElement oktmo = findElementByNoThrow(sidebarElement, By.cssSelector(".ico_content_oktmo"));
        postponedAssertTrue(kbk != null && kbk.isDisplayed(), "'Узнай верный КБК' не отображается");
        postponedAssertTrue(oktmo != null && oktmo.isDisplayed(), "'Узнай верный ОКТМО' не отображается");

    }

    public void checkToDayDate() {
        String day = calendar.findElement(By.cssSelector(".day")).getText().trim();
        String month = calendar.findElement(By.cssSelector(".month")).getText().trim();
        String year = calendar.findElement(By.cssSelector(".year")).getText().trim();
        String dayOfWeek = calendar.findElement(By.cssSelector(".day-of-week")).getText().trim();

        postponedAssertFalse(day.isEmpty(), "Отсутствует текст в календаре для поля 'День'");
        postponedAssertFalse(month.isEmpty(), "Отсутствует текст в календаре для поля 'Месяц'");
        postponedAssertFalse(year.isEmpty(), "Отсутствует текст в календаре для поля 'Год'");
        postponedAssertFalse(dayOfWeek.isEmpty(), "Отсутствует текст в календаре для поля 'День недели'");

        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy EEE");
        try {
            Calendar dateStr = Calendar.getInstance();
            dateStr.setTime(formatter.parse(String.format("%s %s %s %s", day, month.substring(0, 3), year, dayOfWeek.substring(0, 3))));
            Calendar currentDate = Calendar.getInstance();
            postponedAssertTrue(dateStr.get(Calendar.DAY_OF_MONTH) == currentDate.get(Calendar.DAY_OF_MONTH), "Неправильный день месяца");
            postponedAssertTrue(dateStr.get(Calendar.MONTH) == currentDate.get(Calendar.MONTH), "Неправильный месяц");
            postponedAssertTrue(dateStr.get(Calendar.YEAR) == currentDate.get(Calendar.YEAR), "Неправильный год");
            postponedAssertTrue(dateStr.get(Calendar.DAY_OF_WEEK) == currentDate.get(Calendar.DAY_OF_WEEK), "Неправильный день");
        } catch (ParseException e) {
            logger.info("ParseException occurs");
        }

        String selectedDay = calendar.findElement(By.cssSelector("[class*='cell_viewtype_current']")).getText().trim();
        postponedAssertEquals(selectedDay, day, "На календаре выделено не правильное число");
    }

    public void checkMonthCalendar() {
        WebElement calendarTable = findElementByNoThrow(calendar, By.cssSelector(".table_content_calendar"));
        postponedAssertTrue(calendarTable != null && calendarTable.isEnabled() && calendarTable.isDisplayed(), "Календарь месяца не отображается");
    }

    public void checkRedDays() {
        WebElement calendarTable = findElementByNoThrow(calendar, By.cssSelector(".table_content_calendar"));
        postponedAssertTrue(calendarTable != null && calendarTable.isEnabled() && calendarTable.isDisplayed(), "Календарь месяца не отображается");
        if (calendarTable != null) {
            List<WebElement> redDays = calendarTable.findElements(By.cssSelector(".red"));
            for (WebElement elem : redDays) {
                postponedAssertTrue(elem.getCssValue("color").contains("rgba(195, 0, 0, 1)"), "Не верный цвет выходного/празднечного дня");
            }
        }
    }

    public void checkMonthDayTable() {
        WebElement monthDayTable = findElementByNoThrow(calendar, By.cssSelector(".month-day-table"));
        WebElement allDays = findElementByNoThrow(monthDayTable, By.cssSelector(".b"));
        WebElement workDay = findElementByNoThrow(monthDayTable, By.cssSelector(".bottom-margin"));
        WebElement holiday = findElementByNoThrow(monthDayTable, By.cssSelector(".red"));

        postponedAssertTrue(allDays != null && allDays.isDisplayed() && findElementBy(allDays, By.cssSelector(".calendar-day-field")).getText() != null, "Не отображается общее количесво дней");
        postponedAssertTrue(workDay != null && workDay.isDisplayed() && findElementBy(workDay, By.cssSelector(".work-day-field")).getText() != null, "Не отображается количесва рабочих дней");
        postponedAssertTrue(holiday != null && holiday.isDisplayed() && findElementBy(holiday, By.cssSelector(".holiday-field")).getText() != null, "Не отображается количесва выходных дней");

        postponedAssertTrue(findElementBy(allDays, By.xpath(".//td")).getText().contains("Календ. дней"), "Неправильный тескт в строке 'Календ. дней'");
        postponedAssertTrue(findElementBy(workDay, By.xpath(".//td")).getText().contains("рабочих"), "Неправильный тескт в строке 'рабочих'");
        postponedAssertTrue(findElementBy(holiday, By.xpath(".//td")).getText().contains("вых. и праздн."), "Неправильный тескт в строке 'вых. и праздн.'");
    }

    public void checkMonthHourTable() {
        WebElement monthHourTable = findElementByNoThrow(calendar, By.cssSelector(".month-hours-table"));
        WebElement workHours = findElementByNoThrow(monthHourTable, By.xpath(".//tr[1]"));
        WebElement hours40 = findElementByNoThrow(monthHourTable, By.xpath(".//tr[2]"));
        WebElement hours36 = findElementByNoThrow(monthHourTable, By.xpath(".//tr[3]"));
        WebElement hours24 = findElementByNoThrow(monthHourTable, By.xpath(".//tr[4]"));

        postponedAssertTrue(workHours != null && workHours.isDisplayed(), "Не отображается строка 'Рабочих часов'");
        postponedAssertTrue(hours40 != null && hours40.isDisplayed() && findElementBy(hours40, By.cssSelector(".hours-40-field")).getText() != null, "Не отображается количесво 40 часовых рабочих часов");
        postponedAssertTrue(hours36 != null && hours36.isDisplayed() && findElementBy(hours36, By.cssSelector(".hours-36-field")).getText() != null, "Не отображается количесво 36 часовых рабочих часов");
        postponedAssertTrue(hours24 != null && hours24.isDisplayed() && findElementBy(hours24, By.cssSelector(".hours-36-field")).getText() != null, "Не отображается количесво 24 часовых рабочих часов");

        postponedAssertTrue(findElementBy(workHours, By.xpath(".//td")).getText().contains("Рабочих часов"), "Неправильный тескт в строке 'Рабочих часов'");
        postponedAssertTrue(findElementBy(hours40, By.xpath(".//td")).getText().contains("40-час нед."), "Неправильный тескт в строке '40-час нед.'");
        postponedAssertTrue(findElementBy(hours36, By.xpath(".//td")).getText().contains("36-час"), "Неправильный тескт в строке '36-час'");
        postponedAssertTrue(findElementBy(hours24, By.xpath(".//td")).getText().contains("24-час"), "Неправильный тескт в строке '24-час'");
    }

    public void checkFactoryCalendar() {
        calendar.findElement(By.cssSelector(".widget__in")).click();
        postponedAssertTrue(getCurrentUrl().contains("#/document/190/"), "Производственный календарь не открылся");
    }

    public void clickFactoryCalendarLink() {
        calendar.findElement(By.cssSelector(".calendar")).click();
        waitForReloadingPage();
    }

    public void checkDatesInDescendingOrderInNewsList() {
        WebElement board = waitForPresenceOfElementLocatedBy(By.id("main-left"), "Новостная лента не найдена");
        List<WebElement> dates = findElementsByNoThrow(board, By.cssSelector(".main__in h2"));

        List<String> blockTitles = new ArrayList<String>();

        if (dates == null || dates.size() == 0) {
            setPostponedTestFail("Не найдено ни одной даты в блоке Справочники в разделе Новое в справочниках");
            return;
        }

        for (WebElement date: dates) {
            String title = date.getText().trim(); // date from the title 'сегодня, 1 августа'
            if (title.contains(",")) {
                title = title.split(",")[1].trim();
            }

            blockTitles.add(title);
        }

        postponedAssertThat(blockTitles, TestUtils.sortedDatesStringsInDescendingOrder_DefaultPattern(), "Элементы отсортированы в неправильном порядке");
    }

    public void checkNewsBlocks() {
        WebElement board = waitForPresenceOfElementLocatedBy(By.id("main-left"), "Новостная лента не найдена");
        List<WebElement> blocksElements = findElementsByNoThrow(board, By.cssSelector(".main__in [class*='block-']"));
        List<Link> referencesFromLinks = new ArrayList<Link>();

        for(WebElement block: blocksElements) {
            WebElement link = findElementByNoThrow(block, By.tagName("a"));
            if (link == null) {
                setPostponedTestFail("Ссылка в блоке:" + block.getText() + " не найдена");
                return;
            }
            referencesFromLinks.add(new Link(link.getAttribute("href")));
            WebElement textSnippet = findElementByNoThrow(link, By.xpath("../following-sibling::*"));
            postponedAssertTrue(textSnippet != null && textSnippet.getText() != null && !textSnippet.getText().isEmpty(),
                    "Краткое описание документа не найдено под ссылкой:" + link.getText());
        }

        checkLinks(referencesFromLinks);
    }

    public void checkPopularFormLinks() {
        List<WebElement> popularForms = sidebarElement.findElements(By.cssSelector(".handbook"));
        List<Link> formLinks = new ArrayList<Link>();
        for (WebElement popularForm : popularForms) {
            String url = popularForm.findElement(By.tagName("a")).getAttribute("href");
            String header = popularForm.findElement(By.tagName("a")).getText();
            Link link = new Link(url, header);
            formLinks.add(link);
            String urlCheck;
            if (getSettings().isRunFss()) {
                urlCheck = popularForm.getCssValue("background-image");
                postponedAssertTrue(urlCheck != null && !urlCheck.isEmpty(), "Отображается Неправильный маркер");
            } else {
                urlCheck = popularForm.getCssValue("background-image");
                postponedAssertTrue(urlCheck != null && !urlCheck.isEmpty(), "Отображается Неправильный маркер");
            }
        }
        checkLinks(formLinks);
        if (getSettings().isRunKss() || getSettings().isRunUss()) {
            postponedAssertTrue(popularForms.size() <= 5, "Слишком много ссылок в блоке популярное");
        } else {
            postponedAssertTrue(popularForms.size() <= 10, "Слишком много ссылок в блоке популярное");
        }
    }

    public void checkTextMrotOnDictionaryBoard() {
        WebElement sticker = findElementByNoThrow(boardContent, By.cssSelector(".sticker_content_wage"));
        if (sticker != null) {
            WebElement mrot = findElementByNoThrow(sticker, By.cssSelector(".sticker__text_content_rub"));
            if (mrot != null)
                postponedAssertTrue(mrot.getText() != null && !mrot.getText().isEmpty(), "Не отображается значение МРОТ");
            else
                setPostponedTestFail("Не найдет элемент отображающий величину МРОТ");

            WebElement yearMROT = sticker.findElement(By.cssSelector(".sticker__title"));
            String yearTextMROT = yearMROT.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            Date currentDate = new Date();
            String trueDateMrot = "МРОТ на " + sdf.format(currentDate) + " год";
            postponedAssertEquals(yearTextMROT, trueDateMrot, "Не текст в виджете: " + yearTextMROT + "Ожидалось: " + trueDateMrot);
            String linkHead = yearMROT.findElement(By.tagName("a")).getText();
            String linkUrl = yearMROT.findElement(By.tagName("a")).getAttribute("href");
            postponedAssertTrue(linkHead != null && !linkHead.isEmpty(), "Не отображается ссылка докумен величина МРОТ");
            Link link = new Link(linkUrl, linkHead);
            checkLink(link);
        }
    }

    public void checkPostOnDictionaryBoard() {
        WebElement widget = boardContent.findElement(By.cssSelector(".sticker_content_post"));
        WebElement linkTitle = widget.findElement(By.cssSelector(".sticker__title")).findElement(By.tagName("a"));
        String linkHead = linkTitle.getText();
        String linkUrl = linkTitle.getAttribute("href");
        Link link = new Link(linkUrl, linkHead);
        postponedAssertEquals(linkHead, "КАРТОЧКИ ДОЛЖНОСТЕЙ", "Не соответсвует текст заголовка");

        String stickerText = widget.findElement(By.cssSelector(".sticker__text")).getText();
        postponedAssertEquals(stickerText, "Все особенности должности в одной карточке", "Не соответвует текс виджета: " + stickerText + "Ожидалось: Все особенности должности в одной карточке");

        String textNew = getPropertyValueElementBefore(".sticker_state_new", "content").replace("\"", "");
        postponedAssertEquals(textNew, "Новое", "Не отображается 'Новое'");
        checkLink(link);
    }

    @Step("Проверяется отображение заголовка документа")
    public void checkTitle() {
        WebElement title = findElementByNoThrow(documentBody, By.cssSelector("#main-left h1"));
        if (title != null) {
            if (getSettings().isRunKss() || getSettings().isRunEhs() || getSettings().isRunEdu() || getSettings().isRunGo()) {
                postponedAssertTrue(title.getText().contains("Профессиональный календарь на"), "Отображается неверный заголовок документа");
            } else if (getSettings().isRunFss()) {
                postponedAssertTrue(title.getText().contains("Календарь финансового директора на"), "Отображается неверный заголовок документа");
            } else if (getSettings().isRunUss()) {
                postponedAssertTrue(title.getText().contains("Юридический календарь на"), "Отображается неверный заголовок документа");
            } else {
                postponedAssertTrue(title.getText().contains("Календарь бухгалтера на"), "Отображается неверный заголовок документа");
            }
        } else {
            setPostponedTestFail("Не найден заголовок документа");
        }
    }

    @Step("Проверяется отображение блока 'Календарь'")
    public void checkCalendarBlock() {
        WebElement calendarBlock = findElementByNoThrow(documentBody, By.cssSelector(".calendar__in"));
        if (calendarBlock != null) {
            postponedAssertTrue(calendarBlock.isDisplayed(), "Блок 'Календарь' не отображается");
        } else {
            setPostponedTestFail("Не найден элемент 'Календарь'");
        }
    }

    @Step("Проверяется отображение блока 'Професиональные празники/Выходные'")
    public void checkHolydays() {
        if (getSettings().isRunKss() || getSettings().isRunUss()) {
            WebElement professionalHolydays = findElementByNoThrow(documentBody, By.id("announce-block"));
            postponedAssertTrue(professionalHolydays.isDisplayed(), "Блок 'Професиональные праздники' не отображается");
        }

        if (!getSettings().isRunKss()) {
            WebElement holydays = findElementByNoThrow(documentBody, By.id("date-comment"));
            postponedAssertTrue(holydays.isDisplayed(), "Блок 'Праздничные-Выходные дни' не отображается");
        }
    }

    @Step("Проверяется отображение заголовка блока 'События'")
    public void checkEventsTitle() {
        WebElement events = findElementByNoThrow(documentBody, By.id("task-block"));
        if (events != null) {
            WebElement eventsTitle = findElementByNoThrow(events, By.xpath(".//h2[2]"));
            postponedAssertTrue(eventsTitle.isDisplayed() && eventsTitle.getText().contains("Весь"), "Заголовок блока 'События' не отображается");
        } else {
            setPostponedTestFail("Не найден заголовок блока 'События'");
        }
    }

    @Step("Проверяется отображение звезд")
    public void checkDisplayStars() {
        WebElement star = findElementByNoThrow(documentBody, By.xpath(".//a[@data-role='phrase-anchor']"));
        if (star != null) {
            moveMouseToElement(findElementBy(documentBody, By.xpath(".//h1")));
            waitForPresenceOf(star);
            postponedAssertTrue(star.isDisplayed(), "Не отображается звезда");
        } else {
            setPostponedTestFail("Не найден элемент звезда");
        }
    }

    @Step("Проверяется 'звездочки' избранного НЕ отображаются около заголовка документа")
    public void checkNotDisplayStars() {
        WebElement star = findElementByNoThrow(documentBody, By.xpath(".//a[@data-role='phrase-anchor']"));
        if (star != null) {
            moveMouseToElement(findElementBy(documentBody, By.xpath(".//h1")));
            postponedAssertFalse(star.isDisplayed(), "'звездочки' избранного отображаются около заголовка документа");
        }
    }

    @Step("Проверяется отображение блоков 'События'")
    public void checkEventsBlock() {
        if (getSettings().isRunBss()) {
            WebElement setting = findElementByNoThrow(By.cssSelector(".calendar__control"));
            if (setting != null && setting.findElement(By.tagName("span")).isDisplayed()) {
                setting.findElement(By.tagName("a")).click();
                waitForReloadingPage();
                findElementBy(By.cssSelector(".calendar-filters__clear")).findElement(By.tagName("a")).click();
            }
        }
        WebElement eventBlocks = findElementByNoThrow(By.cssSelector("#document-body .js-table_content_scheduler-task"));
        List<WebElement> dates = findElementsBy(eventBlocks, By.xpath("//*[contains(@class,'cell_content_task-dat')]/parent::*[not(contains(@class,'no-exact-date'))]"));
        if (dates.size() > 3) {
            dates = dates.subList(0, 3);
        }
        for (WebElement date : dates) {
            String day = date.getText();

            if (!day.isEmpty() || !day.equals("")) {
                postponedAssertNotNull(TestUtils.parseDate(day, "dd MMMM"), "Дата:" + day + " отображена некорректно");
            }

            String urlCheck = date.getCssValue("background-image");
            postponedAssertTrue(urlCheck != null && !urlCheck.isEmpty(), "Разделитель не отображается");
        }
    }

    @Step("Проверяется отображение блока 'Календарь' в документах 190 модуля")
    public void checkFactoryCalendarBlock() {
        WebElement displayedMonth = findElementByNoThrow(documentBody, By.xpath(".//div[contains(@class, 'displayed') and contains(@class, 'month-block')]"));
        WebElement title = findElementByNoThrow(displayedMonth, By.tagName("h4"));
        WebElement calendarDays = findElementByNoThrow(displayedMonth, By.id("daysCalendar"));
        if ((title != null) && (calendarDays != null)) {
            postponedAssertTrue(calendarDays.isDisplayed(), "Блок 'Календарь' не отображается");
            String month = findElementByNoThrow(title, By.id("monthName")).getText();
            String year = findElementByNoThrow(title, By.id("year")).getText();
            SimpleDateFormat dateForm = new SimpleDateFormat("MMMM yyyy");
            Calendar check = Calendar.getInstance();
            try {
                check.setTime(dateForm.parse(String.format("%s %s", month, year)));
            } catch (ParseException e) {
                postponedAssertTrue(false, "Заголовок не является датой");
            }
        } else {
            setPostponedTestFail("Элемент 'Календарь' не найден");
        }
    }

    @Step("Проверяется отображение дат в блоке 'Календарь' в документах 190 модуля")
    public void checkDates() {
        WebElement displayedMonth = findElementByNoThrow(documentCalendar, By.xpath(".//div[contains(@class, 'displayed') and contains(@class, 'month-block')]"));
        WebElement toDay = findElementByNoThrow(displayedMonth, By.xpath(".//td[contains(@class, 'today')]"));
        Calendar now = Calendar.getInstance();
        String nowDay = String.valueOf(now.get(Calendar.DAY_OF_MONTH));
        postponedAssertEquals(toDay.getText(), nowDay, "Выделен неверный день недели");
    }

    @Step("Проверяется отображение блока 'Календ. дней' в документах 190 модуля")
    public void checkCalendarInfoDays() {
        WebElement displayedMonth = findElementByNoThrow(documentCalendar, By.xpath(".//div[contains(@class, 'displayed') and contains(@class, 'month-block')]"));
        WebElement calendarInfoDays = findElementByNoThrow(displayedMonth, By.cssSelector(".b-calendar-info-day"));
        if (calendarInfoDays != null) {
            postponedAssertTrue(calendarInfoDays.isDisplayed(), "Не отображается блок 'Календ. дней'");
        } else setPostponedTestFail("Элемент блок 'Календ. дней' не найден");
    }

    @Step("Проверяется отображение блока 'Рабочих часов' в документах 190 модуля")
    public void checkCalendarInfoHour() {
        WebElement displayedMonth = findElementByNoThrow(documentCalendar, By.xpath(".//div[contains(@class, 'displayed') and contains(@class, 'month-block')]"));
        WebElement calendarInfoHour = findElementByNoThrow(displayedMonth, By.xpath(".//div[contains(@class,'b-calendar-info-hour')]"));
        if (calendarInfoHour != null) {
            postponedAssertTrue(calendarInfoHour.isDisplayed(), "Не отображается блок 'Рабочих часов'");
        } else setPostponedTestFail("Элемент блок 'Рабочих часов' не найден");
    }

    @Step("Проверяется отображение строки '5-дневная рабочая неделя' в документах 190 модуля")
    public void checkCalendarWeekKoment() {
        WebElement displayedMonth = findElementByNoThrow(documentCalendar, By.xpath(".//div[contains(@class, 'displayed') and contains(@class, 'month-block')]"));
        WebElement calendarWeekKoment = findElementByNoThrow(displayedMonth, By.cssSelector(".b-calendar-week-koment"));
        if (calendarWeekKoment != null) {
            postponedAssertTrue(calendarWeekKoment.isDisplayed(), "Не отображается строка '5-дневная рабочая неделя'");
            postponedAssertTrue(calendarWeekKoment.getText().contains("5-дневная рабочая неделя"), "Не верный текст в строке");
        } else setPostponedTestFail("Элемент строка '5-дневная рабочая неделя' не найден");
    }

    @Step("Проверяется отображение кнопок 'Назад' 'Вперед' в документах 190 модуля")
    public void checkNavigationButtons() {
        WebElement forward = findElementByNoThrow(documentCalendar, By.id("forward"));
        WebElement backward = findElementByNoThrow(documentCalendar, By.id("back"));
        if ((forward != null) && (backward != null)) {
            postponedAssertTrue(forward.isEnabled(), "Не отображается  кнопка 'Назад'");
            postponedAssertTrue(backward.isEnabled(), "Не отображается кнопка 'Вперед'");
        } else setPostponedTestFail("Элементы кнопки 'Назад' 'Вперед' не найдены");
    }

    public void checkCalendarNavigation(String urlCheck) {
        WebElement displayedMonth = findElementByNoThrow(documentBody, By.xpath(".//div[contains(@class, 'displayed') and contains(@class, 'month-block')]"));
        WebElement title = findElementByNoThrow(displayedMonth, By.cssSelector(".clearfix"));
        String month = findElementByNoThrow(title, By.id("monthName")).getText().toLowerCase();
        String year = findElementByNoThrow(title, By.id("year")).getText();
        String checkDate = String.format("%s %s", month, year);

        WebElement calendarTitle = findElementByNoThrow(documentBody, By.xpath(".//h1"));
        String dateInTitle = calendarTitle.getText().toLowerCase();
        postponedAssertTrue(dateInTitle.contains(checkDate), "Загаловок не соответствует дате на календаре");

        WebElement noTask = findElementByNoThrow(documentBody, By.id("no-task-dummy"));
        if (!noTask.isDisplayed()) {
            WebElement events = findElementByNoThrow(documentBody, By.id("task-block"));
            WebElement eventsTitle = findElementByNoThrow(events, By.xpath(".//h2[2]"));
            String dateInEvents = eventsTitle.getText().toLowerCase();
            postponedAssertTrue(dateInEvents.contains(month), "Загаловок не соответствует месяцу на календаре");
        } else {
            String taskDummy = noTask.getText();
            postponedAssertTrue(taskDummy.contains("Нет событий") && taskDummy.contains("Для выбранных настроек событий нет"), "Отображается неверный текст в заглушке");
        }
        WebElement rewind = findElementByNoThrow(displayedMonth, By.id("rewind-month"));
        postponedAssertTrue(rewind.isDisplayed(), "Ссылка 'Вернутся к текущей дате' не отображается");
        rewind.click();
        waitForReloadingPage();
        String[] newUrl = getCurrentUrl().split("=");
        postponedAssertEquals(newUrl[0], urlCheck, "Открылся календарь не за текущей месяц");
    }

    @Step("Проверяется отображение событий за день")
    public void checkDailyEvent() {
        WebElement displayedMonth = findElementByNoThrow(documentBody, By.xpath(".//div[contains(@class, 'displayed') and contains(@class, 'month-block')]"));
        List<WebElement> linkedDates = findElementsByNoThrow(displayedMonth, By.cssSelector(".daylink"));
        String[] urlOriginal = getCurrentUrl().split("=");
        for (int i = 0; i < linkedDates.size(); i++) {
            displayedMonth = findElementByNoThrow(documentBody, By.xpath(".//div[contains(@class, 'displayed') and contains(@class, 'month-block')]"));
            linkedDates = findElementsByNoThrow(displayedMonth, By.cssSelector(".daylink"));
            WebElement date = linkedDates.get(i);
            date.click();
            waitForReloadingPage();

            WebElement eventBlock = findElementByNoThrow(documentBody, By.cssSelector(".day-view"));
            WebElement monthTitle = findElementByNoThrow(eventBlock, By.cssSelector(".month-title"));
            WebElement allMonthLink = findElementByNoThrow(eventBlock, By.cssSelector(".dashed"));
            SimpleDateFormat dateForm = new SimpleDateFormat("dd MMMM");
            Calendar check = Calendar.getInstance();
            String day = monthTitle.getText();

            WebElement title = findElementByNoThrow(documentBody, By.tagName("h1"));
            postponedAssertTrue(title.getText().contains(date.getText()), "Заголовок документа не соответствует дате на календаре");
            if (getSettings().isRunKss()) {
                postponedAssertTrue(title.getText().contains("Профессиональный календарь на"), "Отображается неверный заголовок документа");
            } else if (getSettings().isRunBss()) {
                postponedAssertTrue(title.getText().contains("Календарь бухгалтера на"), "Отображается неверный заголовок документа");
            } else if (getSettings().isRunUss()) {
                postponedAssertTrue(title.getText().contains("Юридический календарь на"), "Отображается неверный заголовок документа");
            } else {
                postponedAssertTrue(title.getText().contains("Календарь финансового директора на"), "Отображается неверный заголовок документа");
            }

            try {
                check.setTime(dateForm.parse(day));
            } catch (ParseException e) {
                postponedAssertTrue(false, "Заголовок не является датой");
            }
            List<WebElement> dailyEvents = findElementsByNoThrow(eventBlock, By.cssSelector(".task"));
            postponedAssertTrue(monthTitle.getText().contains(date.getText()), "Заголовок событий не соответствует дате на календаре");
            postponedAssertTrue(!dailyEvents.isEmpty(), "События за день не отображаются");


            if (allMonthLink != null) {
                postponedAssertTrue(allMonthLink.isDisplayed(), "Не отображается ссылка 'Все события <месяца>'");
                allMonthLink.click();
                waitForReloadingPage();
                String[] urlCheck = getCurrentUrl().split("=");
                postponedAssertEquals(urlCheck[0], urlOriginal[0], "Календарь 'Все события <месяца>' не открылся");
            } else {
                date.click();
                waitForReloadingPage();
                String[] urlCheck = getCurrentUrl().split("=");
                postponedAssertEquals(urlCheck[0], urlOriginal[0], "Календарь 'Все события <месяца>' не открылся");
            }
        }
    }

    @Step("Проверяется отображение событий за день")
    public void checkNumberOf() {
        WebElement displayedMonth = findElementByNoThrow(documentBody, By.xpath(".//div[contains(@class, 'displayed') and contains(@class, 'month-block')]"));
        WebElement title = findElementByNoThrow(displayedMonth, By.tagName("h4"));
        WebElement year = findElementByNoThrow(title, By.id("year"));
        if (year != null) {
            String yearCheck = year.getText();
            year.click();
            waitForReloadingPage();

            WebElement yearView = findElementByNoThrow(documentBody, By.id("yearview"));
            String yearInView = findElementByNoThrow(yearView, By.tagName("span")).getText();
            postponedAssertTrue(yearInView.contains(yearCheck), "Год в заголовке не совпадает с выбранным");

            WebElement switcher = findElementByNoThrow(yearView, By.id("clon1"));
            WebElement selected = findElementByNoThrow(switcher, By.xpath(".//li[contains(@class, 'selected')]"));
            postponedAssertTrue(yearView.isDisplayed() && selected.getText().contains("дней"), "Таблица 'Количество рабочих/нерабочих дней' не отобразилась");

            WebElement hours = findElementByNoThrow(switcher, By.xpath(".//a[contains(@class, 'js-switch-to-year-hours')]"));
            if (hours != null) {
                hours.click();
                waitForReloadingPage();
                WebElement selectedHours = findElementByNoThrow(switcher, By.xpath(".//li[contains(@class, 'selected')]"));
                postponedAssertTrue(yearView.isDisplayed() && selectedHours.getText().contains("часов"), "Таблица 'Количество рабочих часов' не отобразилась");

                WebElement linkToMonth = findElementBy(yearView, By.id("year-hours"));
                if (linkToMonth.isDisplayed()) {
                    List<WebElement> months = findElementsByNoThrow(linkToMonth, By.xpath(".//a[contains(@class, 'monthname')]"));
                    List<WebElement> randomMonths = getRandomElementsInList(months, 3);
                    if (randomMonths.size() != 0) {
                        for (WebElement month : randomMonths) {
                            String monthName = month.getAttribute("title").toLowerCase();
                            month.click();
                            waitForReloadingPage();
                            WebElement displayedMonthCheck = findElementByNoThrow(documentBody, By.xpath(".//div[contains(@class, 'displayed') and contains(@class, 'month-block')]"));
                            WebElement titleCheck = findElementByNoThrow(displayedMonthCheck, By.tagName("h4"));
                            String monthCheck = findElementByNoThrow(titleCheck, By.id("monthName")).getText().toLowerCase();
                            postponedAssertTrue(monthCheck.equals(monthName), "Календарь не за выбранный месяц");
                        }
                    }
                } else setPostponedTestFail("Элемент таблица 'Рабочие - выходные дни' не отображена");
            } else setPostponedTestFail("Ссылка 'часов' не найдена");
        } else setPostponedTestFail("Элемент-ссылка 'год' не найдена");
    }

}
