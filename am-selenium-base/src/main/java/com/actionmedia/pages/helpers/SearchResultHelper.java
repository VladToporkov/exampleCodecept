package com.actionmedia.pages.helpers;

import com.actionmedia.autotest.selenium.annotations.Wait;
import com.actionmedia.base.BasePage;
import com.actionmedia.components.Link;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.ExtendedSearchForm;
import com.actionmedia.pages.bss.BssLawBasePage;
import com.actionmedia.util.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: n.tyukavkin
 * Date: 22.10.13
 * Time: 14:19
 */
@Component
@SuppressWarnings("unchecked")
public class SearchResultHelper<P extends BasePage> extends BasePage<P> {

    @FindBy(id = "main-left")
    @Wait
    protected WebElement mainLeft;

    public static final String HINT_TEXT = "hint.text";
    public static final String DOCUMENT_URL = "document.url";
    private static final String[] BSS_MAGAZINES_LIST = new String[]{"Все издания", "14 500 проводок", "Главбух", "Зарплата", "Упрощенка", "Вмененка", "Бухгалтерия ИП", "Отраслевые журналы", "Госзакупки", "Книги"};
    private static final String[] BSS_MAGAZINES_VIP_LIST = new String[]{"Все издания", "14 500 проводок", "Главбух", "Зарплата", "Упрощенка", "Учет. Налоги. Право",
            "Российский налоговый курьер", "Кадровое дело", "Охрана труда", "Трудовые споры", "Финансовый директор", "Отраслевые журналы",
            "Вмененка, ИП", "МСФО на практике", "Юрист компании", "Генеральный директор", "Коммерческий директор", "Практическое налоговое планирование", "Госзакупки", "Книги", "Налоговед"};
    private static final String[] BSS_MAGAZINES_USN_LIST = new String[]{"Все издания", "14 500 проводок", "Упрощенка", "Вмененка", "Бухгалтерия ИП", "Учет в сельском хозяйстве", "Книги"};
    private static final String[] BSS_MAGAZINES_BUDGET_LIST = new String[]{"Все издания", "Главбух", "Учет в учреждении", "Зарплата в учреждении", "Отраслевые журналы", "Платные услуги учреждения", "Учет в казенных учреждениях", "Госзакупки", "Справочник руководителя образовательного учреждения", "Книги"};
    private static final String[] KSS_MAGAZINES_LIST = new String[]{"Все издания", "Кадровое дело", "Директор по персоналу", "Трудовые споры", "Зарплата", "Охрана труда", "Охрана труда в вопросах и ответах", "Справочник кадровика", "Справочник специалиста по охране труда", "Книги"};
    private static final String[] KSS_MAGAZINES_BUDGET_LIST = new String[]{"Все издания", "Кадровое дело", "Директор по персоналу", "Трудовые споры", "Зарплата в учреждении", "Охрана труда", "Охрана труда в вопросах и ответах", "Справочник кадровика", "Справочник специалиста по охране труда", "Книги"};
    private static final String[] KSS_MAGAZINES_VIP_LIST = new String[]{"Все издания", "Кадровое дело", "Директор по персоналу", "Трудовые споры", "Генеральный директор", "Зарплата", "Охрана труда", "Справочник специалиста по охране труда", "Охрана труда в вопросах и ответах", "Справочник кадровика", "Книги"};
    private static final String[] USS_MAGAZINES_LIST = new String[]{"Все издания", "Юрист компании", "Трудовые споры", "Коммерческое право", "Арбитражная практика",
            "Арбитражная налоговая практика", "Налоговед", "Уголовный процесс", "Госзакупки", "Книги"};
    private static final String[] FSS_MAGAZINES_LIST = new String[]{"Все издания", "Финансовый директор", "Главбух", "Практическое налоговое планирование", "Арбитражная налоговая практика", "МСФО на практике", "Генеральный директор", "Коммерческий директор", "Учет в учреждении", "Платные услуги учреждения"};
    private static final String[] KSS_ANSWER_LIST = new String[]{"Все темы", "Кадровое дело", "Трудовые споры"};
    private static final String[] KSS_VIP_ANSWER_LIST = new String[]{"Все темы", "Кадровое дело", "Управление персоналом", "Трудовые споры"};
    private static final String[] BSS_RECOMEND_LIST = new String[]{"Все темы", "Проводки"};
    private static final String[] BSS_DICTIONARY_LIST = new String[]{"Весь справочник", "Проводки"};
    private static final String[] FSS_ANSWER_LIST = new String[]{"Все темы", "Денежные потоки", "Финансовый анализ и оценка", "Бюджетирование", "Управленческий учет",
            "Налоговое планирование", "Стратегия компании", "Организация и менеджмент", "Рабочие инструменты", "Контроль и управление рисками", "Отраслевые решения", "Разработка регламентов"};
    private static final String[] FSS_FORMS_TOPIC_LIST = new String[]{"Все формы", "Денежные потоки", "Бюджеты", "Управленческая отчетность", "Финансовая служба", "Риски и внутренний контроль"};
    private static final String[] BSS_BRANCH_FILTER = new String[]{"Все отрасли", "Медицина", "Образование", "Культура", "ЖКХ", "Правопорядок", "Вооруженные силы", "Международное законодательство"};
    private static final String[] FSS_DICTIONARY_FILTER = new String[]{"Весь справочник", "Налоги и взносы", "Нормы и лимиты", "Формулы", "Макро\u00ADэкономические индикаторы", "Производственный календарь",
            "Адреса и телефоны", "Перечни и классификаторы", "Ответственность за нарушение законодательства", "Другая справочная информация"};
    private static final String[] FSS_VIDEO_FILTER = new String[]{"Все видео", "Денежные потоки", "Бюджеты и отчетность", "Стратегия и менеджмент", "Финансовый анализ", "Антикризисное управление"};
    private static final String[] FSS_SERVICES_FILTER = new String[]{"Все мастера", "Финансовый анализ", "Бюджетирование", "Школа Финансового директора"};
    private static final String[] BSS_JUDICIAL_ACTS_FILTER = new String[]{"Судебные акты", "Пленумов", "Коллегий Верховного суда", "Всех арбитражных", "Окружных", "Апелляционных"};
    private static final String[] KSS_JUDICIAL_ACTS_FILTER = new String[]{"Судебные акты", "Пленумов", "Коллегий Верховного суда", "Всех СОЮ", "Всех арбитражных", "Окружных", "Апелляционных"};
    private static final String[] USS_JUDICIAL_ACTS_FILTER = new String[]{"Судебные акты", "Пленумов", "Коллегий Верховного суда", "Всех СОЮ", "Всех арбитражных", "Окружных", "Апелляционных"};
    private static final String[] FSS_JUDICIAL_ACTS_FILTER = new String[]{"Судебные акты", "Пленумов", "Коллегий Верховного суда", "Всех арбитражных", "Окружных", "Апелляционных"};


    //Uses for search block widgets
    private static int lastBlock = 0;

    //The variable m is called as test cases. Uses for search block before and after click on button Show more result
    private int m = 0;


    @Step("Проверяется что подсказка с прямым переходом открывает документ")
    public void checkDocumentIsOpened() {
        waitFewSecond(2000);
        String documentUrl = String.valueOf(getParameter(SearchResultHelper.DOCUMENT_URL));
        postponedAssertTrue(getCurrentUrl().contains(documentUrl), "Документ не открыт");
        WebElement documentBody = findElementByNoThrow(By.id("document-body"));
        assertNotNull(documentBody, "Элемент документа не найден");
        postponedAssertFalse(documentBody.getText().isEmpty(), "Документ пустой");
    }

    @Step("Проверяется что открыта страница Рекомендации с результатами поиска")
    public void checkSearchResultOnRecomendPageIsOpened() {
        checkSearchResultIsPresent("В рекомендациях найден");
    }

    @Step("Проверяется что открыта страница Ответы с результатами поиска")
    public void checkSearchResultOnAnswersPageIsOpened() {
        checkSearchResultIsPresent("В ответах найден");
    }

    @Step("Проверяется что открыта страница Правовая база с результатами поиска")
    public void checkSearchResultOnLawBasePageIsOpened(boolean isDefault) {
        checkSearchResultIsPresent("В законодательстве");
        checkSectionFilter(MainMenuButtons.LAW_BASE); //по разделам
        checkRegionFilter(isDefault);
        checkDepartmentFilter(); // по органам
        if (getSettings().isRunBss() && (getCurrentUrl().contains("vip.") || getCurrentUrl().contains("vip."))) {
            checkBranchFilter();
        }
        checkStatusFilter(); //по статусу
    }

    @Step("Проверяется что открыта страница Правовая база с результатами поиска")
    public void checkSearchResultOnLawBasePageIsOpened(boolean isDefault, String departmentFilter) {
        checkSearchResultIsPresent("В законодательстве");
        checkSectionFilter(MainMenuButtons.LAW_BASE); //по разделам
        checkRegionFilter(isDefault);
        checkDepartmentFilter(departmentFilter); // по органам
        if (getSettings().isRunBss() && (getCurrentUrl().contains("vip.") || getCurrentUrl().contains("vip."))) {
            checkBranchFilter();
        }
        checkStatusFilter(); //по статусу
    }

    @Step("Проверяется открытие результатов поиска в Законодательстве")
    public void checkSearchResultOnLawBasePageIsOpened() {
        checkSearchResultIsPresent("В законодательстве");
    }

    public void checkSearchResultOnLawPracticePageIsOpened() {
        checkSearchResultIsPresent("В судебной практике");
    }

    @Step("Проверяется фильтр по регионам")
    public void checkRegionFilter(boolean isDefault) {
        checkRegionFilter(isDefault, "Москва");
    }

    @Step("Проверяется фильтр по регионам")
    public void checkRegionFilter(boolean isDefault, String region) {
        WebElement statusFilter = waitForVisibilityOfElementLocatedBy(By.cssSelector("[data-filtr-name*='region']"), "Фильтр по регионам не найден");
        List<WebElement> statusFilterValues = statusFilter.findElements(By.tagName("a"));
        postponedAssertEquals(statusFilterValues.get(0).getText(), "Все регионы", "Неправильное значения для фильтра статусов");
        postponedAssertEquals(statusFilterValues.get(1).getText(), region, "Неправильное значения для фильтра статусов");
        if (isDefault) {
            postponedAssertTrue(statusFilterValues.get(0).getAttribute("class").contains("active"), "Выбран не тот фильтр региона по умолчанию");
        }
    }

    @Step("Проверяется фильтр по регионам на наличие")
    public void checkRegionFilterIsPresent() {
        waitForVisibilityOfElementLocatedBy(By.cssSelector("[data-filtr-name*='region']"), "Не найден фильтр по регионам");
    }

    private void clickAllRegionFilter() {
        WebElement regionFilter = waitForVisibilityOfElementLocatedBy(By.cssSelector("[data-filtr-name*='region']"), "Фильтр по регионам не найден");
        List<WebElement> regionFilterValues = regionFilter.findElements(By.tagName("li"));
        regionFilterValues.get(0).click();
    }

    public void clickSecondRegionFilter() {
        WebElement regionFilter = waitForVisibilityOfElementLocatedBy(By.cssSelector("[data-filtr-name*='region']"), "Фильтр по регионам не найден");
        List<WebElement> regionFilterValues = regionFilter.findElements(By.tagName("li"));
        regionFilterValues.get(1).click();
    }

    @Step("Проверяется что открыта страница Формы с результатами поиска")
    public void checkSearchResultOnFormsPageIsOpened() {
        checkSearchResultIsPresent("В формах");
    }

    @Step("Проверяется что открыта страница Шаблоны с результатами поиска")
    public void checkSearchResultOnTemplatesPageIsOpened() {
        checkSearchResultIsPresent("В шаблонах");
    }

    @Step("Проверяется что результаты поиска отсутсвуют на странице Положения и регламенты")
    public void checkSearchResultOnFormsFssPageIsPresent() {
        checkSearchResultIsPresent("В положениях и регламентах");
        checkSectionFilter(MainMenuButtons.FSS_FORMS);
    }

    @Step("Проверяется что открыта страница Справочники с результатами поиска")
    public void checkSearchResultOnDictionaryPageIsOpened(String sectionName, MainMenuButtons mainMenuButtons) {
        checkSearchResultIsPresent(sectionName);
        checkSectionFilter(mainMenuButtons);
    }

    @Step("Проверяется что открыта страница Журналы и книги с результатами поиска")
    public void checkSearchResultOnMagazinesPageIsOpened(String sectionName, boolean isArchive, MainMenuButtons mainMenuButtons) {
        checkSearchResultIsPresent(sectionName);
        checkSectionFilter(mainMenuButtons);
        checkDateFilter();
        checkMagazinesFilter();
        if (isArchive) {
            checkArchiveFilter();
        }
    }

    @Step("Проверяется что открыта страница Видео с результатами поиска")
    public void checkSearchResultOnVideosPageIsOpened() {
        checkSectionFilter(MainMenuButtons.VIDEO);
        checkSearchResultIsPresent("В видео найден");
    }

    @Step("Проверяется что открыта страница Сервисы с результатами поиска")
    public void checkSearchResultOnServicesPageIsOpened() {
        checkSearchResultIsPresent("В сервисах найден");
        checkSectionFilter(MainMenuButtons.SERVICES);
    }

    @Step("Проверяется что открыта страница Мастера с результатами поиска")
    public void checkSearchResultOnWizardsPageIsOpened() {
        checkSearchResultIsPresent("В мастерах найден");
        checkSectionFilter(MainMenuButtons.WIZARDS);
    }

    @Step("Проверяется что результаты поиска отсутсвуют на странице Рекомендации")
    public void checkSearchResultOnRecomendPageIsNotPresent() {
        checkSearchResultIsNotPresent("В рекомендациях", MainMenuButtons.RECOMEND);
        checkSectionFilter(MainMenuButtons.RECOMEND);
    }

    @Step("Проверяется что результаты поиска отсутсвуют на странице Решения")
    public void checkSearchResultOnSolutionPageIsNotPresent() {
        checkSearchResultIsNotPresent("В решениях", MainMenuButtons.FSS_SOLUTIONS);
        checkSectionFilter(MainMenuButtons.FSS_SOLUTIONS);
    }

    @Step("Проверяется что результаты поиска отсутсвуют на странице Ответы")
    public void checkSearchResultOnAnswersPageIsNotPresent() {
        checkSearchResultIsNotPresent("В ответах", MainMenuButtons.ANSWERS);
        checkSectionFilter(MainMenuButtons.ANSWERS);
    }

    @Step("Проверяется что результаты поиска отсутсвуют на странице Правовая база")
    public void checkSearchResultOnLawBasePageIsNotPresent() {
        checkSearchResultIsNotPresent("В правовой базе", MainMenuButtons.LAW_BASE);
        checkSectionFilter(MainMenuButtons.LAW_BASE);
    }

    @Step("Проверяется что результаты поиска отсутсвуют на странице Правовая база/Судебная практика")
    public void checkSearchResultOnLawPracticePageIsNotPresent() {
        checkSearchResultIsNotPresent("В правовой базе", MainMenuButtons.LAW_PRACTICE);
        checkSectionFilter(MainMenuButtons.LAW_PRACTICE);
    }

    @Step("Проверяется что результаты поиска отсутсвуют на странице Формы")
    public void checkSearchResultOnFormsPageIsNotPresent() {
        checkSearchResultIsNotPresent("В формах и образцах", MainMenuButtons.FORMS);
        checkSectionFilter(MainMenuButtons.FORMS);
    }

    @Step("Проверяется что результаты поиска отсутсвуют на странице Положения и регламенты")
    public void checkSearchResultOnFormsFssPageIsNotPresent() {
        checkSearchResultIsNotPresent("В положениях и регламентах", MainMenuButtons.FSS_FORMS);
        checkSectionFilter(MainMenuButtons.FSS_FORMS);
    }

    @Step("Проверяется что результаты поиска отсутсвуют на странице Справочник")
    public void checkSearchResultOnDictionaryPageIsNotPresent() {
        String sectionName;
        if (getSettings().isRunKss() || getSettings().isRunBss()) {
            sectionName = "В справочниках";
        } else {
            sectionName = "В справочнике";
        }
        checkSearchResultIsNotPresent(sectionName, MainMenuButtons.DICTIONARY);
        checkSectionFilter(MainMenuButtons.DICTIONARY);
    }

    @Step("Проверяется что результаты поиска отсутсвуют на странице Справочники")
    public void checkSearchResultOnDictionaryBssPageIsNotPresent() {
        String sectionName;
        if (getSettings().isRunKss() || getSettings().isRunBss()) {
            sectionName = "В справочниках";
        } else {
            sectionName = "В справочнике";
        }
        checkSearchResultIsNotPresent(sectionName, MainMenuButtons.DICTIONARIES);
        checkSectionFilter(MainMenuButtons.DICTIONARIES);
    }

    @Step("Проверяется что результаты поиска отсутсвуют на странице Журналы")
    public void checkSearchResultOnMagazinesPageIsNotPresent(MainMenuButtons mainMenuButtons) {
        String sectionName;
        if (getSettings().isRunKss() || getSettings().isRunBss()) {
            sectionName = "В журналах";
        } else if (getSettings().isRunFss()) {
            sectionName = "В библиотеке";
        } else {
            sectionName = "В журналах и книгах";
        }
        checkSearchResultIsNotPresent(sectionName, mainMenuButtons);
        checkSectionFilter(mainMenuButtons);
    }

    @Step("Проверяется что результаты поиска отсутсвуют на странице Журналы")
    public void checkSearchResultOnMagazinesBssPageIsNotPresent() {
        checkSearchResultIsNotPresent("В журналах", MainMenuButtons.MAGAZINES);
        checkSectionFilter(MainMenuButtons.MAGAZINES);
    }

    @Step("Проверяется что результаты поиска отсутсвуют на странице Библиотеки")
    public void checkSearchResultOnMagazinesFssPageIsNotPresent() {
        checkSearchResultIsNotPresent("В библиотеке", MainMenuButtons.LIBRARY);
        checkSectionFilter(MainMenuButtons.LIBRARY);
    }

    @Step("Проверяется что результаты поиска отсутсвуют на странице Видео")
    public void checkSearchResultOnVideosPageIsNotPresent() {
        checkSearchResultIsNotPresent("В видео", MainMenuButtons.VIDEO);
        checkSectionFilter(MainMenuButtons.VIDEO);
    }

    @Step("Проверяется что результаты поиска отсутсвуют на странице Мастера")
    public void checkSearchResultOnWizardsPageIsNotPresent() {
        checkSearchResultIsNotPresent("В мастерах", MainMenuButtons.WIZARDS);
        checkSectionFilter(MainMenuButtons.WIZARDS);
    }

    @Step("Проверяется что результаты поиска отсутсвуют на странице Сервисы")
    public void checkSearchResultOnServicesPageIsNotPresent() {
        checkSearchResultIsNotPresent("В сервисах", MainMenuButtons.SERVICES);
        checkSectionFilter(MainMenuButtons.SERVICES);
    }

    @Step("Проверяется что в фильтре статусов подсвечен выбранный статус")
    public void checkStatusFilterSelectedByName(String filterName) {
        WebElement statusFilter = waitForVisibilityOfElementLocatedBy(By.cssSelector("[data-filtr-name='status']"), "Фильтр статусов не найден");
        String actualFilter = statusFilter.findElement(By.cssSelector(".btn_state_active")).getText();
        postponedAssertEquals(actualFilter, filterName, "В фильтре статусов подсвечен не правильный элемент");
    }

    @Step("Проверяется что выбрана сортировка 'По соответствию'")
    public void checkRelevanceFilterSelectedByName(String filterName) {
        WebElement relevanceFilter = waitForVisibilityOfElementLocatedBy(By.xpath("//*[contains(@id,'tags-sort-by')]"), "Фильтр 'По соответствию' не найден");
        String actualFilter = relevanceFilter.findElement(By.cssSelector(".btn_state_active")).getText();
        postponedAssertEquals(actualFilter, filterName, "Сортирока 'По соответствию' не выбрана");
    }

    @Step("Проверяется что в фильтре Органов власти подсвечен выбранный орган")
    public void checkDepartmentFilterSelectedByName(String filterName) {
        WebElement departmentFilter = waitForVisibilityOfElementLocatedBy(By.cssSelector("[data-filtr-name='tags']"), "Фильтр 'Органов власти' не найден");
        String actualFilter = departmentFilter.findElement(By.cssSelector(".btn_state_active")).getText();
        postponedAssertEquals(actualFilter, filterName, "В фильтре Органов подсвечен не правильный элемент");
    }

    @Step("Проверяется что документ с заданным текстом присутсвует в поисковой выдаче")
    public void checkDocumentWithTextIsPresent(String documentText) {
        boolean isDocumentPresent = isDocumentPresent(documentText);
        postponedAssertTrue(isDocumentPresent, "Документ с текстом '" + documentText + "' Отсутствует в поисковой выдаче");
        if (isDocumentPresent) {
            report("Документ с текстом '" + documentText + "' присутсвует в поисковой выдаче");
        }
    }

    @Step("Проверяется что страница результатов поиска по реквизитам показана")
    public void checkExtendedSearchResultIsPresent() {
        WebElement header = waitForPresenceOfElementLocatedBy(By.tagName("h1"), "Заголовок результатов поиска не отображаются");
        postponedAssertTrue(header.getText().startsWith("Результаты поиска по реквизитам"), "Неправильный заголовок результатов поиска по реквизитам.");
    }

    @Step("Проверяется что страница результатов поиска по реквизитам показана")
    public void checkExtendedHeaderText() {
        WebElement header = waitForPresenceOfElementLocatedBy(By.tagName("h1"), "Заголовок результатов поиска не отображаются");
        WebElement searchResultString = mainContentElement.findElement(By.cssSelector(".search-extended-string"));
        String actualResultText = header.getText() + searchResultString.getText();
        String expectedResultString = getExpectedResultHeader();
        postponedAssertEquals(actualResultText.toLowerCase().replaceAll(", ", "").replaceAll("  ", " "), expectedResultString.toLowerCase().replaceAll("  ", " "), "Список реквизитов поиска неправильный");

        WebElement counter = mainContentElement.findElements(By.cssSelector(".search-extended-string")).get(1);
        if (getParameter(ExtendedSearchForm.ONLY_IN_TITLES) != null && (Boolean) getParameter(ExtendedSearchForm.ONLY_IN_TITLES)) {
            postponedAssertTrue(counter.getText().contains("Вы искали только в заголовке документов"), "Неправльный текст заголовка результатов поиска. Отсутствует текст 'Вы искали только в заголовке документов'");
        }
    }

    @Step("Проверяется что документы в выдаче отсортированы по дате (от новых к старым)")
    public void checkResultAreSortedDescending() {
        List<WebElement> searchItemHeaders = mainContentElement.findElements(By.cssSelector(".widget-header"));
        List<String> dateStringList = new ArrayList<String>();
        for (WebElement searchItem : searchItemHeaders) {
            String searchItemText = searchItem.getText().toLowerCase();
            if (searchItemText.contains("№")) {
                String date = searchItemText.split("от")[1].split("№")[0].trim().split("\n")[0];
                dateStringList.add(date);
            }
        }

        for (int i = 0; i < dateStringList.size() - 1; i++) {
            Date date1 = TestUtils.parseDate(dateStringList.get(i), "dd.MM.YYYY");
            Date date2 = TestUtils.parseDate(dateStringList.get(i + 1), "dd.MM.YYYY");
            if (date1 != null && date2 != null) {
                postponedAssertTrue(date1.compareTo(date2) >= 0, "Документы отсортированы в неправильном порядке");
            }
        }
    }

    @Step("Проверяется что документы в выдаче отсортированы по дате (от новых к старым), проверяется 5 первых документов")
    public void checkDocumentsInLawPracticePageAreSortedDescending() {
        List<WebElement> searchItemHeaders = mainContentElement.findElements(By.cssSelector(".widget-header"));
        if (searchItemHeaders.size() > 5) {
            searchItemHeaders = searchItemHeaders.subList(0, 5); //first 5 documents
        }
        List<String> dateStringList = new ArrayList<String>();
        for (WebElement searchItem : searchItemHeaders) {
            waitForPresenceOfElementLocatedBy(By.cssSelector(".widget-header"));
            WebElement doc = searchItem.findElement(By.tagName("a"));
            doc.click();
            waitForReloadingPage();

            WebElement help = findElementByNoThrow(By.xpath("//*[@data-rel='infobar-card']/a"));
            help.click();
            waitForReloadingPage();

            WebElement date = waitForPresenceOfElementLocatedBy(By.xpath("//*[@class='document-chain-info']/div/div[4]/p"), "Дата в результатах поиска не отображается");
            dateStringList.add(date.getText().substring(6).trim()); //delete first six letters from String ("Принят 12 мая 2014")

            returnToBack();
            waitForReloadingPage();
            returnToBack();
            waitForReloadingPage();
        }

        for (int i = 0; i < dateStringList.size() - 1; i++) {
            Date date1 = TestUtils.parseDate(dateStringList.get(i), "dd MMM YYYY");
            Date date2 = TestUtils.parseDate(dateStringList.get(i + 1), "dd MMM YYYY");
            if (date1 != null && date2 != null) {
                postponedAssertTrue(date1.compareTo(date2) >= 0, "Документы отсортированы в неправильном порядке");
            }
        }
    }

    @Step("Нажать кнопку Найти")
    public void clickSearchButtonOnSearchPage() {
        WebElement extendedForm = findElementByNoThrow(By.id("search-form-extended"));
        if (extendedForm != null && extendedForm.isDisplayed()) {
            getHelper(BssLawBasePage.class).clickExtendedButtonInSearchBox();
        }
        clickSearchButton();
    }

    @Step("Проверяется что работы ссылок со страницы результатов поиска")
    public void checkLinksFromSearchResultPage() {
        WebElement searchResultWidget = getWidgetSearch();
        List<WebElement> searchResultList = getRandomElementsInList(searchResultWidget.findElements(By.cssSelector(".widget-header")), 5);
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement searchResult : searchResultList) {
            String url = searchResult.findElement(By.tagName("a")).getAttribute("href");
            String header = searchResult.findElement(By.tagName("a")).getText();
            Link link = new Link(url, header);
            linkList.add(link);
        }
        checkLinks(linkList);
    }

    @Step("Проверяется подсветка в поисковой выдачи слов из запроса")
    public SearchResultHelper checkSearchQueryIsHighlighted(String query) {
        WebElement searchResultWidget = getWidgetSearch();

        List<WebElement> documentList = searchResultWidget.findElements(By.cssSelector("[href*='/#']"));
        List<String> expectedHighlightedWordList = new ArrayList<String>();
        for (WebElement document : documentList) {
            String href = document.getAttribute("href").replace("document//", "document/");
            logger.info("href - " + href);
            String[] urlArr = href.split("#")[1].split("\\/");
            int moduleId = Integer.parseInt(urlArr[2]);
            int documentId = Integer.parseInt(urlArr[3]);
            logger.info("moduleId - " + moduleId);
            logger.info("moduleId - " + moduleId);
            expectedHighlightedWordList.addAll(getHighlightsWordListForDocument(query, moduleId, documentId));
        }

        List<WebElement> actualHighlightedWordList = searchResultWidget.findElements(By.tagName("strong"));
        postponedAssertFalse(actualHighlightedWordList.isEmpty(), "Не одно слово в поисковой выдаче не подсвеченно");
        for (WebElement highlightedWordElement : actualHighlightedWordList) {
            if (highlightedWordElement.isDisplayed()) {
                String highlightedWord = highlightedWordElement.getText().toLowerCase();
                postponedAssertTrue(expectedHighlightedWordList.contains(highlightedWord), "Выделено слово не из поискового запроса. Поисковый запрос: '" + query + "' . Выделенное слово: '" + highlightedWord + "'");
            }
        }
        return this;
    }

    @Step("Проверяется что подсветки в документе слов из запроса")
    public void checkSearchQueryIsHighlightedInDocument(String query) {
        checkHighlightedInDocument(query, getRandomDocumentLinkFromSearchResult());
        checkHighlightedInDocument(query, getRandomDocumentLinkFromSearchResult());
        checkHighlightedInDocument(query, getRandomDocumentLinkFromSearchResult());
    }

    @Step("Проверяется работа скроллинга в поисковой выдаче")
    public void checkScrollingSearchResult() {
        int numberOfSearchResult = getNumberOfSearchResult();
        if (numberOfSearchResult > 55) {
            List<WebElement> searchResultListBefore = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются");
            scroll(10);
            getWidgetSearch();
            List<WebElement> searchResultListAfter = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются");
            postponedAssertTrue(searchResultListAfter.size() > searchResultListBefore.size(), "Количество отображаемых документов после скролла равно количеству документов до скролла. " +
                    "До скролла: '" + searchResultListBefore.size() + "' . После скролла: '" + searchResultListAfter.size() + "'");

            report("Проверяется работа ссылок в поисковой выдаче после скролла");
            List<Link> linkList = new ArrayList<Link>();

            WebElement linkElement1 = searchResultListAfter.get(searchResultListBefore.size()).findElement(By.tagName("a"));
            String url1 = linkElement1.getAttribute("href");
            String header1 = linkElement1.getText();
            Link link1 = new Link(url1, header1);
            linkList.add(link1);

            WebElement linkElement2 = searchResultListAfter.get(searchResultListBefore.size() + 1).findElement(By.tagName("a"));
            String url2 = linkElement2.getAttribute("href");
            String header2 = linkElement2.getText();
            Link link2 = new Link(url2, header2);
            linkList.add(link2);

            WebElement linkElement3 = searchResultListAfter.get(searchResultListBefore.size() + 2).findElement(By.tagName("a"));
            String url3 = linkElement3.getAttribute("href");
            String header3 = linkElement3.getText();
            Link link3 = new Link(url3, header3);
            linkList.add(link3);

            checkLinks(linkList);
        } else {
            report("Всего найдено " + numberOfSearchResult + " документов. Проверка скролла невозможна.");
        }
    }

    @Step("Проверяется что ссылки не повторяются в поисковой выдаче")
    public void checkSearchResultAreNotRepeated() {
        List<WebElement> searchResultLinkList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются");
        List<String> linkList = new ArrayList<String>();
        for (int i = 0; i < searchResultLinkList.size(); i++) {
            WebElement searchResult = searchResultLinkList.get(i);
            String link = searchResult.findElement(By.tagName("a")).getAttribute("href");
            String searchResultLinkText = searchResult.findElement(By.tagName("a")).getAttribute("href");
            postponedAssertFalse(linkList.contains(link), "Ссылка '" + searchResultLinkText + "' повторяется");
            linkList.add(searchResultLinkText);
        }
    }

    @Step("Проверяется работа ссылок в заглушке")
    public void checkLinksOnTypo() {
        WebElement typo = waitForVisibilityOfElementLocatedBy(By.cssSelector(".typo"), "Заглушка не найдена").findElement(By.tagName("p"));
        List<WebElement> typoLinks = typo.findElements(By.tagName("a"));
        postponedAssertFalse(typoLinks.isEmpty(), "Не найдены ссылки в заглушки");
        List<String> typoLinkLocatorLinks = new ArrayList<String>();

        for (WebElement typoLink : typoLinks) {
            typoLinkLocatorLinks.add(typoLink.getAttribute("href"));
        }

        for (String typoLinkLocator : typoLinkLocatorLinks) {
            WebElement typoLink = waitForVisibilityOfElementLocatedBy(By.cssSelector("[href*='" + typoLinkLocator.split("#")[1] + "']"), "Ссылка '" + typoLinkLocator + "' не найдена в заглушке");
            String typoLinkText = typoLink.getText();
            if ("рубрикатор".equals(typoLinkText)) {
                typoLink.click();
                WebElement answersRubricator = waitForVisibilityOfElementLocatedBy(By.id("rubricator"), "Рубрикатор ответов не найден");
                answersRubricator.findElement(By.id("rubricator-close")).click();
            } else {
                typoLink.click();
                waitForReloadingPage();
                switch (MainMenuButtons.getSectionByName(typoLinkText)) {
                    case RECOMEND:
                        checkSearchResultOnRecomendPageIsNotPresent();
                        break;
                    case ANSWERS:
                        checkSearchResultOnAnswersPageIsNotPresent();
                        break;
                    case LAW_BASE:
                        checkSearchResultOnLawBasePageIsNotPresent();
                        break;
                    case FORMS:
                        checkSearchResultOnFormsPageIsNotPresent();
                        break;
                    case FSS_FORMS:
                        checkSearchResultOnFormsFssPageIsNotPresent();
                        break;
                    case DICTIONARY:
                        checkSearchResultOnDictionaryPageIsNotPresent();
                        break;
                    case DICTIONARIES:
                        checkSearchResultOnDictionaryBssPageIsNotPresent();
                        break;
                    case MAGAZINES_AND_BOOKS:
                        checkSearchResultOnMagazinesPageIsNotPresent(MainMenuButtons.MAGAZINES_AND_BOOKS);
                        break;
                    case MAGAZINES:
                        checkSearchResultOnMagazinesBssPageIsNotPresent();
                        break;
                    case LIBRARY:
                        checkSearchResultOnMagazinesFssPageIsNotPresent();
                        break;
                    case VIDEO:
                        checkSearchResultOnVideosPageIsNotPresent();
                        break;
                    case WIZARDS:
                        checkSearchResultOnWizardsPageIsNotPresent();
                        break;
                    case SERVICES:
                        checkSearchResultOnServicesPageIsNotPresent();
                        break;
                    case FSS_SOLUTIONS:
                        checkSearchResultOnSolutionPageIsNotPresent();
                        break;
                    default:
                        setPostponedTestFail("Неправильное имя раздела " + typoLinkText);
                }
                returnToBack();
            }
        }
    }

    @Step("Проверяется наличие кнопки рубрикатора")
    public void checkRubricatorButtonsIsPresent() {
        WebElement rubricatorButton = findElementByNoThrow(By.id("rubricator-btn"));
        postponedAssertTrue(rubricatorButton.isDisplayed(), "Кнопка рубрикаторов не видна");
    }

    @Step("Проверяется наличие кнопки рубрикатора Мое избранное для утентифицированного пользователя")
    public void checkRubricatorFavoritesButtonIsPresent() {
        WebElement favoritesButton = findElementByNoThrow(By.id("favorites-btn"));
        postponedAssertTrue(favoritesButton.isDisplayed(), "Кнопка Мое избранное в блоке рубрикаторов не видна");
    }

    @Step("Проверяется работа ссылок в заглушке")
    public void clickLinkOnTypoBySectionType(MainMenuButtons menuButton) {
        WebElement typo = waitForVisibilityOfElementLocatedBy(By.cssSelector(".typo"), "Заглушка не найдена").findElement(By.tagName("p"));
        WebElement typoLink = findElementByNoThrow(typo, menuButton.getLinkInFilterLocator());
        assertNotNull(typoLink, "Ссылка '" + menuButton.getName() + "' не найдена в заглушке");
        waitFewSecond(3000);
        typoLink.click();
        waitForReloadingPage();
    }

    @Step("Проверяется работа ссылки на рубрикатор в заглушке")
    public void checkRubricatorLinkOnTypo() {
        WebElement typo = waitForVisibilityOfElementLocatedBy(By.cssSelector(".typo"), "Заглушка не найдена").findElement(By.tagName("p"));
        WebElement rubricatorLink = findElementByNoThrow(typo, By.cssSelector(".rubric-link"));
        assertNotNull(rubricatorLink, "Ссылки на рубрикатор в заглушке не найдена");
        rubricatorLink.click();
        waitForReloadingPage();
        waitForVisibilityOfElementLocatedBy(By.id("rubricator"), "Рубрикатор не найден");
        waitForVisibilityOfElementLocatedBy(By.id("rubricator-close"), "Кнопка 'Закрыть Рубрикатор' не найдена").click();
    }

    @Step("Проверяется что документ с заданным текстом Отсутствует в поисковой выдаче")
    public void checkDocumentWithTextIsNotPresent(String documentText) {
        boolean isDocumentPresent = isDocumentPresent(documentText);
        postponedAssertFalse(isDocumentPresent, "Документ с текстом '" + documentText + "' присутсвует в поисковой выдаче");
        if (!isDocumentPresent) {
            report("Документ с текстом '" + documentText + "' Отсутствует в поисковой выдаче");
        }
    }

    @Step("Проверяется исправления опечаток/раскладки клавиатуры в поисковом запросе")
    public void checkTypoWasFixed(String typoString, String fixedString) {
        WebElement searchResultHeader = waitForVisibilityOfElementLocatedBy(By.cssSelector(".search-result"), "Заголовок результатов поиска не найден");
        String actualFixedString = searchResultHeader.findElement(By.tagName("h1")).getText().split("«")[1];
        actualFixedString = "«" + actualFixedString;
        postponedAssertEquals(actualFixedString, "«" + fixedString + "»", "Неправильный заголовок результатов поиска");
        postponedAssertEquals(searchResultHeader.findElement(By.tagName("p")).getText(), "Искать вместо этого «" + typoString + "»", "Неправиьный текст заголовка результата поиска с исправленной опечаткой");
        List<WebElement> resultList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются");
        postponedAssertFalse(resultList.isEmpty(), "Отсутсвуют результаты поиска для запроса с опечаткой");
    }

    @Step("Выбрать статус утратившие силу")
    public void clickNotActiveStatus() {
        WebElement statusFilter = waitForVisibilityOfElementLocatedBy(By.cssSelector("[data-filtr-name='status']"), "Фильтр статусов не найден");
        statusFilter.findElement(By.cssSelector("[data-param='expired']")).click();
        waitForReloadingPage();
        waitFewSecond(5);
    }

    @Step("Выбрать фильтр суды")
    public void clickСourtTag() {
        WebElement statusFilter = waitForVisibilityOfElementLocatedBy(By.cssSelector("[data-filtr-name='tags']"), "Фильтр статусов не найден");
        String param;
        if (getSettings().isRunUss()) {
            param = "42";
        } else {
            param = "2";
        }
        statusFilter.findElement(By.cssSelector("[data-param='" + param + "']")).click();
        waitForReloadingPage();
        waitFewSecond(5);
    }

    @Step("Выбрать фильтр тип документы")
    public void clickTypeDocumentFilter(String filterName) {
        WebElement statusFilter = waitForVisibilityOfElementLocatedBy(By.cssSelector("[data-filtr-name='tags']"), "Фильтр 'Тип документа' не найден");
        statusFilter.findElement(By.xpath(".//u[text()='" + filterName + "']")).click();
        waitForReloadingPage();
        waitFewSecond(5);
    }


    @Step("Выбрать фильтр по дате")
    public void clickDateFilter() {
        WebElement statusFilter = waitForVisibilityOfElementLocatedBy(By.cssSelector("[data-filtr-name='sort']"), "Фильтр сортитровки не найден");
        statusFilter.findElement(By.cssSelector("[data-param='6']")).click();
        waitForReloadingPage();
        waitFewSecond(5);
    }

    @Step("Проверяется что чекбокс 'Искать с эталонными запросами' отображается")
    public void checkSearchWithStandardQueryCheckBoxIsPresent() {
        WebElement searchWithStandardQueryCheckBox = findElementByNoThrow(mainLeftElement, By.id("with-etalon"));
        postponedAssertNotNull(searchWithStandardQueryCheckBox, "Чекбокс 'Искать с эталонными запросами' не найден");
        if (searchWithStandardQueryCheckBox != null) {
            postponedAssertTrue(searchWithStandardQueryCheckBox.isDisplayed(), "Чекбокс 'Искать с эталонными запросами' не отображается");
        }
    }

    @Step("Проверяется что чекбокс 'Искать с эталонными запросами' не отображается")
    public void checkSearchWithStandardQueryCheckBoxIsNotPresent() {
        WebElement searchWithStandardQueryCheckBox = findElementByNoThrow(mainLeftElement, By.id("with-etalon"));
        postponedAssertNull(searchWithStandardQueryCheckBox, "Чекбокс 'Искать с эталонными запросами' отображается");
    }

    @Step("Проверяется что чекбокс 'Искать с эталонными запросами' выбран")
    public void checkSearchWithStandardQueryCheckBoxIsSelected() {
        WebElement searchWithStandardQueryCheckBox = findElementByNoThrow(mainLeftElement, By.id("with-etalon"));
        postponedAssertTrue(searchWithStandardQueryCheckBox.isSelected(), "Чекбокс 'Искать с эталонными запросами' не выбран");
    }

    @Step("Проверяется что чекбокс 'Искать с эталонными запросами' не выбран")
    public void checkSearchWithStandardQueryCheckBoxIsNotSelected() {
        WebElement searchWithStandardQueryCheckBox = findElementByNoThrow(mainLeftElement, By.id("with-etalon"));
        postponedAssertFalse(searchWithStandardQueryCheckBox.isSelected(), "Чекбокс 'Искать с эталонными запросами' выбран");
    }

    @Step("Проверяется что ссылка Показать релевантности отображается")
    public void checkShowRelevanceLinkIsPresent() {
        WebElement relevanceLink = findElementByNoThrow(mainLeftElement, By.cssSelector(".show-items-relevance"));
        assertNotNull(relevanceLink, "Ссылка Показать релевантности не найдена");
        postponedAssertTrue(relevanceLink.isEnabled() && relevanceLink.isDisplayed(), "Ссылка Показать релевантности не отображается");
    }

    @Step("Проверяется что ссылка Показать релевантности не отображается")
    public void checkShowRelevanceLinkIsAbsent() {
        WebElement relevanceLink = findElementByNoThrow(mainLeftElement, By.cssSelector(".show-items-relevance"));
        postponedAssertNull(relevanceLink, "Ссылка Показать релевантности отображается");
    }

    @Step("Проверяется что релевантности не отображаются")
    public void checkRelevanceIsAbsent() {
        List<WebElement> relevanceList = mainLeftElement.findElements(By.cssSelector(".item-relevance"));
        postponedAssertTrue(relevanceList.isEmpty(), "Релевантности отображаются");
    }

    @Step("Проверяется работа ссылки Показать релевантности, проверяются первые 5 релевантностей")
    public void checkRelevanceLinkWorks() {
        WebElement relevanceLink = waitForVisibilityOfElementLocatedBy(By.cssSelector(".link_content_search-relevance"), "Ссылка Показать релевантности не найдена");

        report("Нажать линк Показать релевантности");
        relevanceLink.click();

        List<WebElement> relevanceInfoList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".item-relevance"), "Показать релевантности не отображаются");
        relevanceInfoList = relevanceInfoList.subList(0, 5);

        double currentRelevance = 1000000000; // max value for first compare
        double previousRelevance = 0;

        report("Проверяется что релевантности отображаются для первых пяти ссылок");

        for (WebElement relevanceInfo : relevanceInfoList) {
            if (relevanceInfo.isDisplayed()) {
                try {
                    previousRelevance = currentRelevance;
                    if (relevanceInfo.getText().equals("")) {
                        break;
                    }
                    String info = relevanceInfo.getText().split("\\s+")[0].replace(",", ".");
                    currentRelevance = Double.parseDouble(info);
                } catch (NullPointerException npe) {
                    throw new NullPointerException("Exception for parsing Relevance info. Please see the relevance item for " +
                            relevanceInfo.getText() + npe.getStackTrace());
                } catch (NumberFormatException nfe) {
                    throw new NumberFormatException("Exception for parsing Relevance info. Can't parse relevance number:" + relevanceInfo.getText()
                            + " to Double. " + nfe.getStackTrace());
                }

                postponedAssertTrue(previousRelevance >= currentRelevance, "Предыдущая релевантность документа: " + previousRelevance + " не больше, чем" +
                        " релевантность следующего документа:" + currentRelevance + ". Для первой релевантности предыдущая равна по умолчанию целому числу. Если" +
                        " предыдушая релевантность - целое число, и вы видите эту ошибку, проверьте релевантность первого документа.");
            }
        }

        report("Нажать линк Скрыть релевантности");
        relevanceLink.click();

        report("Проверяется что релевантности не отображаются");
        for (WebElement relevanceInfo : relevanceInfoList) {
            postponedAssertFalse(relevanceInfo.isDisplayed(), "Релевантность отображается для '" + relevanceInfo.getText() + "'");
        }
    }

    @Step("Проверяется что релевантности отображаются")
    public void checkRelevanceArePresent() {
        List<SearchItem> searchItemList = getSearchResultItemList();
        for (SearchItem searchItem : searchItemList) {
            String searchType = searchItem.getHeader().findElement(By.cssSelector(".expert-search-type")).getText();
            if (searchType.equalsIgnoreCase("эталон")) {
                continue;
            }
            postponedAssertNotNull(searchItem.getRelevance(), "Релевантности не отображаются");
        }
    }

    @Step("Проверятся что колдунщики Правовой базы отсутсвуют в поисковой выдаче")
    public void checkLawSearchWidgetIsNotPresent() {
        waitForSearchResult();
        List<WebElement> lawSearchWidgetList = mainContentElement.findElements(By.cssSelector(".widget-law"));
        postponedAssertTrue(lawSearchWidgetList.isEmpty(), "Колдунщики Правовой Базы пристутсвуют в поисковой выдаче");
    }

    @Step("Проверятся что колдунщики Правовой базы присутсвуют в поисковой выдаче")
    public void checkLawSearchWidgetIsPresent() {
        waitForSearchResult();
        List<WebElement> lawSearchWidgetList = mainContentElement.findElements(By.cssSelector(".widget-law"));
        postponedAssertFalse(lawSearchWidgetList.isEmpty(), "Колдунщики Правовой Базы отсутсвуют в поисковой выдаче");
    }

    @Step("Проверяется что блок 'В правовой базе' в поисковой выдаче не пустой")
    public void checkLawSearchWidgetIsNotEmpty() {
        checkSearchWidgetByTypeIsNotEmpty(By.cssSelector(".widget-law"), "В правовой базе");
    }

    @Step("Проверятся что колдунщики Форм отсутсвуют в поисковой выдаче")
    public void checkFormsSearchWidgetIsNotPresent() {
        waitForSearchResult();
        List<WebElement> formsSearchWidgetList = mainContentElement.findElements(By.cssSelector(".widget-forms"));
        postponedAssertTrue(formsSearchWidgetList.isEmpty(), "Колдунщики Форм пристутсвуют в поисковой выдаче");
    }

    @Step("Проверятся что колдунщики Форм присутсвуют в поисковой выдаче")
    public void checkFormsSearchWidgetIsPresent() {
        waitForSearchResult();
        List<WebElement> lawSearchWidgetList = mainContentElement.findElements(By.cssSelector(".widget-forms"));
        postponedAssertFalse(lawSearchWidgetList.isEmpty(), "Колдунщики Форм отсутсвуют в поисковой выдаче");
    }

    @Step("Проверяется что блок 'В формах и образцах' в поисковой выдаче не пустой")
    public void checkFormsSearchWidgetIsNotEmpty() {
        checkSearchWidgetByTypeIsNotEmpty(By.cssSelector(".widget-forms"), "В формах и образцах");
    }

    @Step("Проверятся что колдунщики Журналов отсутсвуют в поисковой выдаче")
    public void checkMagazinesSearchWidgetIsNotPresent() {
        waitForSearchResult();
        List<WebElement> magazinesSearchWidgetList = mainContentElement.findElements(By.cssSelector(".widget-press"));
        postponedAssertTrue(magazinesSearchWidgetList.isEmpty(), "Колдунщики Журналов пристутсвуют в поисковой выдаче");
    }

    @Step("Проверятся что колдунщики Журналов присутсвуют в поисковой выдаче")
    public void checkMagazinesSearchWidgetIsPresent() {
        waitForSearchResult();
        List<WebElement> lawSearchWidgetList = mainContentElement.findElements(By.cssSelector(".widget-press"));
        postponedAssertFalse(lawSearchWidgetList.isEmpty(), "Колдунщики Журналов отсутсвуют в поисковой выдаче");
    }

    @Step("Проверяется что блок 'В журналах' в поисковой выдаче не пустой")
    public void checkMagazinesSearchWidgetIsNotEmpty() {
        checkSearchWidgetByTypeIsNotEmpty(By.cssSelector(".widget-press"), "В журналах");
    }

    @Step("Проверятся что колдунщики Видео отсутсвуют в поисковой выдаче")
    public void checkVideoSearchWidgetIsNotPresent() {
        waitForSearchResult();
        List<WebElement> videoSearchWidgetList = mainContentElement.findElements(By.cssSelector(".widget-videos"));
        postponedAssertTrue(videoSearchWidgetList.isEmpty(), "Колдунщики Видео пристутсвуют в поисковой выдаче");
    }

    @Step("Проверятся что колдунщики Видео присутсвуют в поисковой выдаче")
    public void checkVideoSearchWidgetIsPresent() {
        waitForSearchResult();
        List<WebElement> videoSearchWidgetList = mainContentElement.findElements(By.cssSelector(".widget-videos"));
        postponedAssertFalse(videoSearchWidgetList.isEmpty(), "Колдунщики Видео отcутсвуют в поисковой выдаче");
    }

    @Step("Проверяется что блок 'Видео' в поисковой выдаче не пустой")
    public void checkVideoSearchWidgetIsNotEmpty() {
        waitForSearchResult();
        WebElement widget = findElementByNoThrow(mainContentElement, By.cssSelector(".widget-videos"));
        if (widget != null) {
            postponedAssertTrue(widget.isDisplayed(), "Блок 'Видео' не отображается в результатх поиска");
            List<WebElement> links = widget.findElements(By.cssSelector("div a"));
            postponedAssertFalse(links.isEmpty(), "Блок 'Видео' пустой");
        }
    }

    @Step("Проверятся что колдунщики Справочников отсутсвуют в поисковой выдаче")
    public void checkDictionarySearchWidgetIsNotPresent() {
        waitForSearchResult();
        List<WebElement> videoSearchWidgetList = mainContentElement.findElements(By.cssSelector(".widget-handbook"));
        postponedAssertTrue(videoSearchWidgetList.isEmpty(), "Колдунщики Справочников пристутсвуют в поисковой выдаче");
    }

    @Step("Проверятся что колдунщики Правовой базы присутсвуют в поисковой выдаче")
    public void checkDictionarySearchWidgetIsPresent() {
        waitForSearchResult();
        List<WebElement> lawSearchWidgetList = mainContentElement.findElements(By.cssSelector(".widget-handbook"));
        postponedAssertFalse(lawSearchWidgetList.isEmpty(), "Колдунщики Справочников отсутсвуют в поисковой выдаче");
    }

    @Step("Проверяется что блок 'В справочниках' в поисковой выдаче не пустой")
    public void checkDictionarySearchWidgetIsNotEmpty() {
        checkSearchWidgetByTypeIsNotEmpty(By.cssSelector(".widget-handbook"), "В справочниках");
    }

    @Step("Проверятся что колдунщики Коды отсутсвуют в поисковой выдаче")
    public void checkKodySearchWidgetIsNotPresent() {
        waitForSearchResult();
        List<WebElement> videoSearchWidgetList = mainContentElement.findElements(By.cssSelector(".widget-code"));
        postponedAssertTrue(videoSearchWidgetList.isEmpty(), "Колдунщики Коды пристутсвуют в поисковой выдаче");
    }

    @Step("Проверятся что колдунщики Коды присутсвуют в поисковой выдаче")
    public void checkKodySearchWidgetIsPresent() {
        waitForSearchResult();
        List<WebElement> lawSearchWidgetList = mainContentElement.findElements(By.cssSelector(".widget-code"));
        postponedAssertFalse(lawSearchWidgetList.isEmpty(), "Колдунщики Коды отсутсвуют в поисковой выдаче");
    }

    private void waitForSearchResult() {
        try {
            waitForPresenceOfElementLocatedBy(By.cssSelector(".search-result"));
        } catch (WebDriverException e) {
            waitForPresenceOfElementLocatedBy(By.cssSelector(".search-result"));
        }
    }

    @Step("Проверяется что блок 'Коды' в поисковой выдаче не пустой")
    public void checkKodySearchWidgetIsNotEmpty() {
        checkSearchWidgetByTypeIsNotEmpty(By.cssSelector(".widget-code"), "Коды");
    }

    @Step("Проверется что все результаты поиска имеют заголовк, сниппеты, ссылки")
    public void checkSearchResultItemList() {
        List<SearchItem> searchItemList = getSearchResultItemList();

        boolean isStrongInHeader = false;
        boolean isStrongInText = false;
        for (SearchItem searchItem : searchItemList) {
            WebElement header = searchItem.getHeader();
            WebElement text = searchItem.getText();
            WebElement source = searchItem.getSource();

            if (header != null) {
                WebElement status = findElementByNoThrow(header, By.cssSelector(".status"));
                WebElement caps = findElementByNoThrow(header, By.cssSelector(".caps"));
                WebElement link = findElementByNoThrow(header, By.tagName("a"));
                WebElement strong = findElementByNoThrow(header, By.tagName("strong"));

                postponedAssertTrue(status != null || caps != null, "Отсутствует статус документа для результата поиска");
                postponedAssertNotNull(link, "Отсутствует ссылка для результата поиска");
                if (!isStrongInHeader) {
                    isStrongInHeader = strong != null;
                }
            } else {
                setPostponedTestFail("Отсутствует заголовок для результата поиска");
            }
            if (text != null || source != null) {
                WebElement strong = findElementByNoThrow(text, By.tagName("strong"));
                WebElement strongInSourсe = findElementByNoThrow(source, By.tagName("strong"));
                if (!isStrongInText) {
                    if (strong != null || strongInSourсe != null) {
                        isStrongInText = true;
                    }
                }
            } else {
                setPostponedTestFail("Отсутствует сниппет для результата поиска");
            }
        }
        postponedAssertTrue(isStrongInHeader || isStrongInText, "Ни одно слово не выделено в заголовке или в сниппете результата поиска");
    }

    @Step("Проверяются все заголовки и сниппеты")
    public void checkSearchResultDocumentsLinksAndSnippets() {
        List<SearchItem> searchItemList = getSearchResultItemList();

        boolean isStrongInHeader = false;
        boolean isStrongInText = false;
        for (SearchItem searchItem : searchItemList) {
            WebElement header = searchItem.getHeader();
            WebElement text = searchItem.getText();
            WebElement source = searchItem.getSource();

            if (header != null) {
                WebElement status = findElementByNoThrow(header, By.cssSelector(".status"));
                WebElement caps = findElementByNoThrow(header, By.cssSelector(".caps"));
                WebElement link = findElementByNoThrow(header, By.tagName("a"));
                WebElement strong = findElementByNoThrow(header, By.tagName("strong"));

                postponedAssertTrue(status != null || caps != null, "Отсутствует статус документа для результата поиска");
                postponedAssertNotNull(link, "Отсутствует ссылка для результата поиска");
                if (!isStrongInHeader) {
                    isStrongInHeader = strong != null;
                }
            } else {
                setPostponedTestFail("Отсутствует заголовок для результата поиска");
            }
            if (text != null || source != null) {
                WebElement strong = findElementByNoThrow(text, By.tagName("strong"));
                WebElement strongInSourсe = findElementByNoThrow(source, By.tagName("strong"));
                if (!isStrongInText) {
                    if (strong != null || strongInSourсe != null) {
                        isStrongInText = true;
                    }
                }
            } else {
                setPostponedTestFail("Отсутствует сниппет для результата поиска");
            }
        }
    }

    @Step("Выбрать Все статутсы в фильтре статусов")
    public void clickAllStatusInFilter() {
        getStatusFilter(By.cssSelector("[data-param='unknown']")).click();
        waitForReloadingPage();
    }

    @Step("Выбрать Утратившие силу в фильтре статусов")
    public void clickExpiredStatusInFilter() {
        getStatusFilter(By.cssSelector("[data-param='expired']")).click();
        waitForReloadingPage();
    }

    @Step("Выбрать Действующие в фильтре статусов")
    public void clickActualStatusInFilter() {
        getStatusFilter(By.xpath("//*[@data-param='actual'][1]")).click();
        waitForReloadingPage();
    }

    @Step("Выбрать Не вступившие в силу в фильтре статусов")
    public void clickInFutureStatusInFilter() {
        getStatusFilter(By.cssSelector("[data-param='actualinfuture']")).click();
        waitForReloadingPage();
    }

    @Step("Выбрать Рекомендации в результатах поиска")
    public void clickRecomendFilter() {
        getSearchFilter(By.cssSelector(".recommendations")).click();
        waitForReloadingPage();
    }

    @Step("Выбрать Правовая база в результатах поиска")
    public void clickLawBaseFilter() {
        getSearchFilter(By.cssSelector(".law")).click();
        waitForReloadingPage();
    }

    @Step("Выбрать Формы в результатах поиска")
    public void clickFormsFilter() {
        findElementBy(By.xpath("//*[@id='sidebar']//ins[contains(@class,'forms')]/..")).click();
        waitForReloadingPage();
    }

    @Step("Выбрать Справочники в результатах поиска")
    public void clickDictionaryFilter() {
        getSearchFilter(By.cssSelector(".handbook")).click();
        waitForReloadingPage();
    }

    @Step("Выбрать Журналы в результатах поиска")
    public void clickMagazinesFilter() {
        getSearchFilter(By.cssSelector(".press")).click();
        waitForReloadingPage();
    }

    @Step("Выбрать Видео в результатах поиска")
    public void clickVideoFilter() {
        getSearchFilter(By.cssSelector(".videos")).click();
        waitForReloadingPage();
    }

    @Step("Выбрать Сервисы в результатах поиска")
    public void clickServicesFilter() {
        getSearchFilter(By.cssSelector(".services")).click();
        waitForReloadingPage();
    }

    @Step("Открыть случайный документ из поисковой выдачи")
    public void clickRandomDocument() {
        WebElement searchResult = getWidgetSearch();
        List<WebElement> documents = searchResult.findElements(By.cssSelector(".widget-header"));
        WebElement randomDocument = getRandomElementInList(documents);
        report("Открывается " + randomDocument.getText());
        randomDocument.findElement(By.tagName("a")).click();
    }

    @Step("Выбрать Все органы")
    public void clickAllDepartmentsFilter() {
        getDepartmentFilter(By.cssSelector("[data-param='0']")).click();
        waitForReloadingPage();
    }

    @Step("Выбрать Федеральные")
    public void clickFederalDepartmentsFilter() {
        getDepartmentFilter(By.cssSelector("[data-param='11']")).click();
        waitForReloadingPage();
    }

    @Step("Выбрать Региональные")
    public void clickRegionalDepartmentsFilter() {
        getDepartmentFilter(By.cssSelector("[data-param='10']")).click();
        waitForReloadingPage();
    }

    @Step("Выбрать Минфин")
    public void clickMinFinDepartmentsFilter() {
        getDepartmentFilter(By.cssSelector("[data-param='9']")).click();
        waitForReloadingPage();
    }

    @Step("Выбрать ФНС")
    public void clickFNSDepartmentsFilter() {
        getDepartmentFilter(By.cssSelector("[data-param='8']")).click();
        waitForReloadingPage();
    }

    @Step("Выбрать Суды")
    public void clickCourtsDepartmentsFilter() {
        getDepartmentFilter(By.cssSelector("[data-param='2']")).click();
        waitForReloadingPage();
    }

    @Step("Отсортировать результаты поиска по дате")
    public void clickDateSortedFilter() {
        WebElement sortedFilter = waitForVisibilityOfElementLocatedBy(By.xpath("//*[contains(@id,'tags-sort-by')]"), "Фильтр сортировки не найден");
        List<WebElement> items = sortedFilter.findElements(By.tagName("li"));
        items.get(1).findElement(By.tagName("a")).click();
        waitForReloadingPage();
    }

    @Step("Отсортировать результаты поиска по соответсвию")
    public void clickRelevanceSortedFilter() {
        WebElement sortedFilter = waitForVisibilityOfElementLocatedBy(By.xpath("//*[contains(@id,'tags-sort-by')]"), "Фильтр сортировки не найден");
        List<WebElement> items = sortedFilter.findElements(By.tagName("li"));
        items.get(0).findElement(By.tagName("a")).click();
        waitForReloadingPage();
    }

    @Step("Проверить вид поиска")
    public void checkSearchResultType(String type) {
        WebElement searchResult = waitForPresenceOfElementLocatedBy(By.cssSelector(".search-result"), "Результаты поиска не отображаются");
        postponedAssertTrue(searchResult.getText().contains(type), "Тип поиска не задан");
    }

    @Step("Проверить запрос")
    public void checkSearchQuery(String query) {
        WebElement searchResult = waitForPresenceOfElementLocatedBy(By.cssSelector(".search-result"), "Результаты поиска не отображаются");
        WebElement highlight = searchResult.findElement(By.tagName("h1"));
        postponedAssertTrue(highlight.getText().contains("\u00AB" + query + "\u00BB"), "Неверный запрос");
    }

    @Step("Проверить регион")
    public void checkRegion(String region) {
        WebElement searchResult = waitForPresenceOfElementLocatedBy(By.cssSelector(".search-result"), "Результаты поиска не отображаются");
        WebElement filterRegion = searchResult.findElement(By.cssSelector(".search-extended-string"));
        postponedAssertTrue(filterRegion.getText().contains("Регион"), "Неверный фильтр");
        WebElement currentRegion = filterRegion.findElement(By.tagName("span"));
        postponedAssertTrue(currentRegion.getText().contains(region), "Неверный регион");
    }

    public void clickShowRelevanceLink() {
        WebElement relevance = mainLeftElement.findElement(By.cssSelector(".show-items-relevance"));
        WebElement relevanceLink = relevance.findElement(By.tagName("a"));
        relevanceLink.click();
        waitForReloadingPage();
    }

    @Step("Проверяется отображение фильтра разделов")
    public void checkSectionFilter(MainMenuButtons menuButton) {
        List<WebElement> filterElements = findElementsByNoThrow(sidebarElement, By.xpath("//*[@data-filtr-name='pubDiv']"));
        assertNotNull(filterElements, "Не найдены поисковые фильтры по разделам");
        List<WebElement> filterList = new ArrayList<WebElement>();
        for (WebElement filterElement : filterElements) {
            filterList.addAll(filterElement.findElements(By.tagName("li")));
        }
        postponedAssertFalse(filterList.isEmpty(), "Список фильтров по разделам пустой");
        if (getSettings().isRunFss()) {
            assertNotNull(findElementByNoThrow(filterList.get(0), By.cssSelector(".ico_content_solutions")), "Не найден фильтр 'Решения'");
            assertNotNull(findElementByNoThrow(filterList.get(1), By.cssSelector(".ico_content_forms")), "Не найден фильтр 'Положения и регламенты'");
            assertNotNull(findElementByNoThrow(filterList.get(2), By.cssSelector(".ico_content_law")), "Не найден фильтр 'Правовая база'");
            assertNotNull(findElementByNoThrow(filterList.get(3), By.cssSelector(".ico_content_lawpractice")), "Не найден фильтр 'Судебная практика'");
            assertNotNull(findElementByNoThrow(filterList.get(4), By.cssSelector(".ico_content_press")), "Не найден фильтр 'Библиотека'");
            assertNotNull(findElementByNoThrow(filterList.get(5), By.cssSelector(".ico_content_videos")), "Не найден фильтр 'Видео'");
            assertNotNull(findElementByNoThrow(filterList.get(6), By.cssSelector(".ico_content_handbook")), "Не найден фильтр 'Справочники'");
            assertNotNull(findElementByNoThrow(filterList.get(7), By.cssSelector(".ico_content_services")), "Не найден фильтр 'Сервисы'");
        } else if (getSettings().isRunKss()) {
            assertNotNull(findElementByNoThrow(filterList.get(0), By.cssSelector(".ico_content_answers")), "Не найден фильтр 'Ответы'");
            assertNotNull(findElementByNoThrow(filterList.get(1), By.cssSelector(".ico_content_law")), "Не найден фильтр 'Правовая база'");
            assertNotNull(findElementByNoThrow(filterList.get(2), By.cssSelector(".ico_content_lawpractice")), "Не найден фильтр 'Судебная практика'");
            assertNotNull(findElementByNoThrow(filterList.get(3), By.cssSelector(".ico_content_forms")), "Не найден фильтр 'Формы'");
            assertNotNull(findElementByNoThrow(filterList.get(4), By.cssSelector(".ico_content_handbook")), "Не найден фильтр 'Справочник'");
            assertNotNull(findElementByNoThrow(filterList.get(5), By.cssSelector(".ico_content_press")), "Не найден фильтр 'Журналы и книги'");
            assertNotNull(findElementByNoThrow(filterList.get(6), By.cssSelector(".ico_content_videos")), "Не найден фильтр 'Видео'");
            assertNotNull(findElementByNoThrow(filterList.get(7), By.cssSelector(".ico_content_services")), "Не найден фильтр 'Сервисы'");
        } else {
            assertNotNull(findElementByNoThrow(filterList.get(0), By.cssSelector(".ico_content_recommendations")), "Не найден фильтр 'Ответы'");
            assertNotNull(findElementByNoThrow(filterList.get(1), By.cssSelector(".ico_content_law")), "Не найден фильтр 'Правовая база'");
            assertNotNull(findElementByNoThrow(filterList.get(2), By.cssSelector(".ico_content_lawpractice")), "Не найден фильтр 'Судебная практика'");
            assertNotNull(findElementByNoThrow(filterList.get(3), By.cssSelector(".ico_content_forms")), "Не найден фильтр 'Формы'");
            assertNotNull(findElementByNoThrow(filterList.get(4), By.cssSelector(".ico_content_handbook")), "Не найден фильтр 'Справочник'");
            assertNotNull(findElementByNoThrow(filterList.get(5), By.cssSelector(".ico_content_press")), "Не найден фильтр 'Журналы и книги'");
            assertNotNull(findElementByNoThrow(filterList.get(6), By.cssSelector(".ico_content_videos")), "Не найден фильтр 'Видео'");
        }

        if (getSettings().isRunUss()) {
            assertNotNull(findElementByNoThrow(filterList.get(6), By.cssSelector(".ico_content_videos")), "Не найден фильтр 'Видео'");
            assertNotNull(findElementByNoThrow(filterList.get(7), By.cssSelector(".ico_content_services")), "Не найден фильтр 'Сервисы'");
        }

        if (getSettings().isRunBss() && getCurrentUrl().contains("vip.")) {
            assertNotNull(findElementByNoThrow(filterList.get(7), By.cssSelector(".ico_content_services")), "Не найден фильтр 'Сервисы'");
        }

        if (!(menuButton.equals(MainMenuButtons.VIDEO) || menuButton.equals(MainMenuButtons.RABOTARU) || menuButton.equals(MainMenuButtons.KSS_SERVICES))) {
            WebElement activeFilter = findElementByNoThrow(filterElements.get(0), By.cssSelector(".btn_state_active"));
            assertNotNull(activeFilter, "Не один фильтр не выбран");
            postponedAssertEquals(activeFilter.getText(), menuButton.getName(), "Выбран неправильный фильтр");
        }
    }

    @Step("Проверяется наличие фильтра разделов")
    public void checkSectionFilterIsPresent() {
        List<WebElement> filterElements = findElementsByNoThrow(sidebarElement, By.xpath("//*[@data-filtr-name='pubDiv']"));
        assertNotNull(filterElements, "Не найдены поисковые фильтры по разделам");
    }

    @Step("Проверяется отображение картинок фильтра разделов")
    public void checkImgSectionFilter() {
        WebElement sidebar = findElementByNoThrow(By.id("sidebar"));
        if (sidebar != null) {
            WebElement title = findElementByNoThrow(sidebar, By.tagName("h4"));
            if (title != null)
                postponedAssertEqualsText(title, "Результаты:");
            else
                setPostponedTestFail("Не найден элемент 'Результаты:'");

            List<WebElement> filterItems = findElementsBy(sidebar, By.xpath(".//ul[@data-filtr-name='pubDiv']/li/a"));
            for (WebElement item : filterItems) {
                postponedAssertNotEquals(getPropertyValueElementBefore("." + item.getAttribute("class"), "background-image"), "", "Нет картинки у фильтра");
            }
        } else
            setPostponedTestFail("Не найден элемент меню");
    }

    @Step("Проверяется работа фильтра разделов")
    public void checkLinksSectionFilter() {
        List<WebElement> filterItems = findElementsBy(By.xpath(".//ul[@data-filtr-name='pubDiv']/li/a"));
        List<WebElement> searchResultLinkList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются");
        if (filterItems != null) {
            List<String> texts = new ArrayList<String>();
            for (WebElement filterItem : filterItems) {
                texts.add(filterItem.getAttribute("class"));
            }

            for (int i = 1; i < texts.size(); i++) {
                WebElement filterItem = findElementByNoThrow(By.xpath(".//ul[@data-filtr-name='pubDiv']/li[" + (i + 1) + "]/a/ins"));//get icon
                WebElement temp = findElementBy(By.xpath(".//ul[@data-filtr-name='pubDiv']/li[" + i + "]/a"));
                postponedAssertTrue(temp.getAttribute("class").contains("btn_state_active"), "Не подсвечивается выбранный элемент меню:" + temp.getText());
                String text = "";
                try {
                    text = filterItem.getAttribute("class").split("ico_content_")[1];
                } catch (NullPointerException npe) {
                }
                if (getSettings().isRunKss()) {
                    text = text.replace("recommendations", "answers");
                }
                filterItem.click();
                waitForReloadingPage();
                postponedAssertTrue(getCurrentUrl().contains(text), "Не корректный URL");
                postponedAssertFalse(searchResultLinkList.equals(waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются")), "Поисковая выдача не изменилась");
            }
        }
    }

    @Step("Проверяется работа фильтра Утратившие силу")
    public void checkExpiredLinksStatusFilter() {
        List<WebElement> searchResultLinkList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются");
        WebElement expired = findElementByNoThrow(By.cssSelector("[data-param='expired']"));
        scrollIntoView(expired);
        expired.click();
        waitForReloadingPage();
        List<WebElement> searchExpiredResultLinkList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются");
        postponedAssertFalse(searchResultLinkList.equals(searchExpiredResultLinkList), "Поисковая выдача не изменилась");
        for (WebElement searchExpiredResultLink : searchExpiredResultLinkList) {
            if (!searchExpiredResultLink.isDisplayed()) {
                continue;
            }
            WebElement status = findElementByNoThrow(searchExpiredResultLink, By.xpath(".//div[@class='status expired']"));
            postponedAssertNotNull(status, "Не найдена поментка документа 'Не действует'");
            postponedAssertEquals(status.getText(), "Не действует", "Неправильный текст статуса 'Не действует'");
        }

        WebElement statusFilter = waitForVisibilityOfElementLocatedBy(By.cssSelector("[data-filtr-name*='status']"), "Не найден фильтр статусов");
        List<WebElement> statusFilterValues = statusFilter.findElements(By.tagName("a"));
        postponedAssertTrue(statusFilterValues.get(1).getAttribute("class").contains("btn_state_active"), "Выделен не тот фильтр");

    }

    @Step("Проверяется работа фильтра Действующие")
    public void checkActualLinksStatusFilter() {
        List<WebElement> searchResultLinkList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются");
        WebElement expired = findElementByNoThrow(By.cssSelector("[data-param='actual']"));
        scrollIntoView(expired);
        expired.click();
        waitForReloadingPage();
        List<WebElement> searchExpiredResultLinkList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются");
        postponedAssertFalse(searchResultLinkList.equals(searchExpiredResultLinkList), "Поисковая выдача не изменилась");
        for (WebElement searchExpiredResultLink : searchExpiredResultLinkList) {
            if (!searchExpiredResultLink.isDisplayed()) {
                continue;
            }
            WebElement status = findElementByNoThrow(searchExpiredResultLink, By.xpath(".//div[@class='status expired']"));
            postponedAssertNotNull(status, "Не найдена поментка документа 'Не действует'");
            postponedAssertEquals(status.getText(), "", "Неправильный текст статуса 'Действующие'");
        }

        WebElement statusFilter = waitForVisibilityOfElementLocatedBy(By.cssSelector("[data-filtr-name*='status']"), "Не найден фильтр статусов");
        List<WebElement> statusFilterValues = statusFilter.findElements(By.tagName("a"));
        postponedAssertTrue(statusFilterValues.get(2).getAttribute("class").contains("btn_state_active"), "Выделен не тот фильтр");
    }

    @Step("Проверяется работа фильтра Не вступившие в силу")
    public void checkActualInFutureLinksStatusFilter() {
        List<WebElement> searchResultLinkList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются");
        WebElement expired = findElementByNoThrow(By.cssSelector("[data-param='actualinfuture']"));
        scrollIntoView(expired);
        expired.click();
        waitForReloadingPage();
        List<WebElement> searchExpiredResultLinkList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются");
        postponedAssertFalse(searchResultLinkList.equals(searchExpiredResultLinkList), "Поисковая выдача не изменилась");
        for (WebElement searchExpiredResultLink : searchExpiredResultLinkList) {
            if (!searchExpiredResultLink.isDisplayed()) {
                continue;
            }
            WebElement status = findElementByNoThrow(searchExpiredResultLink, By.xpath(".//div[@class='status in-future']"));
            postponedAssertNotNull(status, "Не найдена поментка документа 'Не вступившие в силу'");
            postponedAssertEquals(status.getText(), "Не вступил в силу", "Неправильный текст статуса 'Не вступил в силу'");
        }

        WebElement statusFilter = waitForVisibilityOfElementLocatedBy(By.cssSelector("[data-filtr-name*='status']"), "Не найден фильтр статусов");
        List<WebElement> statusFilterValues = statusFilter.findElements(By.tagName("a"));
        postponedAssertTrue(statusFilterValues.get(3).getAttribute("class").contains("btn_state_active"), "Выделен не тот фильтр");
    }

    @Step("Проверяется работа фильтра Все статусы")
    public void checkUnknownLinksStatusFilter() {
        List<WebElement> searchResultLinkList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются");
        WebElement expired = findElementByNoThrow(By.cssSelector("[data-param='unknown']"));
        scrollIntoView(expired);
        expired.click();
        waitForReloadingPage();
        List<WebElement> searchExpiredResultLinkList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются");
        postponedAssertFalse(searchResultLinkList.equals(searchExpiredResultLinkList), "Поисковая выдача не изменилась");
        int flag = 0;
        List<WebElement> temp1;
        List<WebElement> temp2;
        do {
            temp1 = findElementsBy(By.xpath(".//h3/div[text()='Не действует']"));
            temp2 = findElementsBy(By.xpath(".//div[@class='status in-future']"));
            scrollToEnd();
            flag++;
        } while (temp1.size() == 0 && temp2.size() == 0 && flag < 5);
        postponedAssertTrue(temp1.size() != 0 || temp2.size() != 0, "В выдаче нашлись только действующие документы");

        WebElement statusFilter = waitForVisibilityOfElementLocatedBy(By.cssSelector("[data-filtr-name*='status']"), "Не найден фильтр статусов");
        List<WebElement> statusFilterValues = statusFilter.findElements(By.tagName("a"));
        postponedAssertTrue(statusFilterValues.get(0).getAttribute("class").contains("btn_state_active"), "Выделен не тот фильтр");
    }

    @Step("Проверяется отображение фильтра по соответсвию/дате")
    public void checkDateFilter() {
        WebElement dateFilter = waitForVisibilityOfElementLocatedBy(By.xpath("//*[contains(@id,'tags-sort-by')]"), "Не найден фильтр по соответсвию/дате");
        List<WebElement> dateFilterValues = dateFilter.findElements(By.tagName("a"));
        postponedAssertTrue(dateFilterValues.get(0).getAttribute("class") != null &&
                dateFilterValues.get(0).getAttribute("class").contains("btn_state_active"), "Неправильное значение по-умолчанию фильтра по соответсвию/дате. " +
                "Ожидаемый результат: 'По соответствию'. Наблюдаемый результат: '" + dateFilterValues.get(0).getText() + "'");

        postponedAssertEquals(dateFilterValues.get(0).getText(), "По соответствию", "Неправильное значения фильтра по соответсвию/дате");
        postponedAssertEquals(dateFilterValues.get(1).getText(), "По дате", "Неправильное значения фильтра по соответсвию/дате");
    }

    @Step("Проверяется что в поисковой выдаче результаты отсортированны по дате")
    public void checkSearchResultsDateFilter() {
        List<Date> dates = new ArrayList<Date>();
        for (WebElement widgetHeader : findElementsBy(By.cssSelector(".widget-header"))) {
            WebElement span = findElementByNoThrow(widgetHeader, By.tagName("span"));
            if (span == null) {
                continue;
            }
            String text = span.getText();
            dates.add(parseDate(text, "dd.MM.yyyy"));
        }
        for (int i = 1; i < dates.size(); i++) {
            postponedAssertTrue(dates.get(i).getTime() <= dates.get(i - 1).getTime(), "Даты идут не по порядку");
        }
    }

    @Step("Проверяется что в поисковой выдаче результаты отсортированны по дате начиная с определенной")
    public void checkSearchResultsDateFilterFrom(String date) {
        Date dateFrom = parseDate(date, "dd.MM.yyyy");
        List<Date> dates = new ArrayList<Date>();
        for (WebElement widgetHeader : findElementsBy(By.cssSelector(".widget-header"))) {
            WebElement span = findElementByNoThrow(widgetHeader, By.tagName("span"));
            if (span == null) {
                continue;
            }
            String text = span.getText();
            dates.add(parseDate(text, "dd.MM.yyyy"));
        }
        for (Date dateElement : dates) {
            postponedAssertTrue(dateElement.getTime() >= dateFrom.getTime(), "Дата:" + dateElement + " меньше чем:" + dateFrom);
        }
    }

    @Step("Проверяется что в поисковой выдаче результаты отсортированны по дате между двумя датами")
    public void checkSearchResultsDateFilterBetween(String fromDate, String toDate) {

        Date dateFrom = parseDate(fromDate, "dd.MM.yyyy");
        Date dateTo = parseDate(toDate, "dd.MM.yyyy");
        List<Date> dates = new ArrayList<Date>();

        for (WebElement widgetHeader : findElementsBy(By.cssSelector(".widget-header"))) {
            WebElement span = findElementByNoThrow(widgetHeader, By.tagName("span"));
            if (span == null)
                continue;

            String text = span.getText();

            dates.add(parseDate(text, "dd.MM.yyyy"));

        }
        for (int i = 0; i < dates.size(); i++) {
            postponedAssertTrue(dates.get(i).getTime() >= dateFrom.getTime() && dates.get(i).getTime() <=
                    dateTo.getTime(), "Дата:" + dates.get(i) + " не находится между: " + dateFrom + " < > " + dateTo);
        }
    }

    @Step("Проверяется что в поисковой выдаче результаты отсортированны по дате до определенной")
    public void checkSearchResultsDateFilterTo(String date) {
        Date dateTo = parseDate(date, "dd.MM.yyyy");
        List<Date> dates = new ArrayList<Date>();

        for (WebElement widgetHeader : findElementsBy(By.cssSelector(".widget-header"))) {
            WebElement span = findElementByNoThrow(widgetHeader, By.tagName("span"));
            if (span == null)
                continue;

            String text = span.getText();

            dates.add(parseDate(text, "dd.MM.yyyy"));

        }
        for (int i = 0; i < dates.size(); i++) {
            postponedAssertTrue(dates.get(i).getTime() <= dateTo.getTime(), "Дата:" + dates.get(i) + " больше чем:" + dateTo);
        }
    }

    private Date parseDate(String date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);

        Pattern data = Pattern.compile("\\d{2}\\.\\d{2}\\.\\d{4}");
        Matcher matcher = data.matcher(date);

        Date currentDate = new Date();

        if (matcher.find()) {
            try {
                currentDate = (sdf.parse(matcher.group()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            fail("Дата:" + date + " задана не верно");
        }
        return currentDate;
    }

    @Step("Проверяется что в поисковой выдаче результаты отсортированны по дате")
    public void checkSearchResultsDateFilterMagazines() {
        List<Date> dates = new ArrayList<Date>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        for (WebElement widgetHeader : findElementsBy(By.cssSelector(".widget-header"))) {
            WebElement span = findElementByNoThrow(widgetHeader, By.tagName("span"));
            if (span == null)
                continue;

            String text = span.getText();
            Pattern data = Pattern.compile("\\d{2}\\.\\d{2}\\.\\d{4}");
            Matcher matcher = data.matcher(text);

            if (matcher.find()) {
                try {
                    dates.add(sdf.parse(matcher.group()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        for (int i = 1; i < dates.size(); i++) {
            postponedAssertTrue(dates.get(i).getTime() <= dates.get(i - 1).getTime(), "Даты идут не по порядку");
        }
    }

    public void checkMagazinesFilter() {
        String[] expectedFilterValues = getListMagazines();
        checkSearchFilter(expectedFilterValues, "изданиям");
    }

    private String[] getListTypeDocuments() {
        String[] filterValue;
        if (getSettings().isRunKss()) {
            filterValue = new String[]{"Все документы", "Федеральные", "Региональные", "Минтруд", "Роструд", "Профстандарты", "Пленумов"};
        } else if (getSettings().isRunUss()) {
            filterValue = new String[]{"Все документы", "Федеральные законы", "Подзаконные акты", "Региональные", "Пленумов"};
        } else if (getSettings().isRunFss()) {
            filterValue = new String[]{"Все документы", "Федеральные", "Региональные", "Минфин", "ФНС", "Пленумов"};
        } else {
            filterValue = new String[]{"Все документы", "Федеральные", "Региональные", "Минфин", "ФНС", "Пленумов"};
        }
        return filterValue;
    }

    private String[] getListMagazines() {
        String[] expectedFilterValues = null;
        if (getSettings().isRunKss()) {
            if (getCurrentUrl().contains("://bu")) {
                expectedFilterValues = KSS_MAGAZINES_BUDGET_LIST;
            } else if (getCurrentUrl().contains("vip.")) {
                expectedFilterValues = KSS_MAGAZINES_VIP_LIST;
            } else {
                expectedFilterValues = KSS_MAGAZINES_LIST;
            }
        } else if (getSettings().isRunUss()) {
            expectedFilterValues = USS_MAGAZINES_LIST;
        } else if (getSettings().isRunBss()) {
            if (getCurrentUrl().contains("vip.")) {
                expectedFilterValues = BSS_MAGAZINES_VIP_LIST;
            } else if (getCurrentUrl().contains("://u")) {
                expectedFilterValues = BSS_MAGAZINES_USN_LIST;
            } else if (getCurrentUrl().contains("://bu")) {
                expectedFilterValues = BSS_MAGAZINES_BUDGET_LIST;
            } else {
                expectedFilterValues = BSS_MAGAZINES_LIST;
            }
        } else if (getSettings().isRunFss()) {
            expectedFilterValues = FSS_MAGAZINES_LIST;
        }
        return expectedFilterValues;
    }

    public void checkVideosFilter() {
        String[] expectedFilterValues = FSS_VIDEO_FILTER;
        checkSearchFilter(expectedFilterValues, "видео");
    }

    public void checkTopicFiltersArePresent() {
        WebElement magazinesFilter;
        magazinesFilter = waitForVisibilityOfElementLocatedBy(By.cssSelector("[data-filtr-name='tags']"), "Не найден фильтр по темам");
        List<WebElement> magazinesFilterValues = magazinesFilter.findElements(By.tagName("li"));
        List<WebElement> actualFilterValues = new ArrayList<WebElement>();
        for (WebElement magazineFilter : magazinesFilterValues) {
            if (magazineFilter.isDisplayed() && !magazineFilter.getText().isEmpty()) {
                actualFilterValues.add(magazineFilter);
            }
        }

        postponedAssertFalse(actualFilterValues.isEmpty(), "Фильтр по темам пуст");
    }

    public void checkTopicFilter() {
        String searchType = "темам";
        String[] expectedFilterValues = null;
        if (getSettings().isRunKss()) {
            if (getCurrentUrl().contains("vip")) {
                expectedFilterValues = KSS_VIP_ANSWER_LIST;
            } else {
                expectedFilterValues = KSS_ANSWER_LIST;
            }
        } else if (getSettings().isRunFss()) {
            if (getCurrentUrl().contains("#/solutions/")) {
                expectedFilterValues = FSS_ANSWER_LIST;
            } else if (getCurrentUrl().contains("#/forms/")) {
                expectedFilterValues = FSS_FORMS_TOPIC_LIST;
                searchType = "формы";
            } else if (getCurrentUrl().contains("#/handbook/")) {
                expectedFilterValues = FSS_DICTIONARY_FILTER;
                searchType = "справочник";
            }
        } else if (getSettings().isRunBss()) {
            if (getCurrentUrl().contains("#/recomend/") || getCurrentUrl().contains("#/recommendations")) {
                expectedFilterValues = BSS_RECOMEND_LIST;
            } else if (getCurrentUrl().contains("#/handbook/")) {
                expectedFilterValues = BSS_DICTIONARY_LIST;
                searchType = "справочник";
            }
        }
        checkSearchFilter(expectedFilterValues, searchType);
    }

    private void checkSearchFilter(String[] expectedFilterValues, String searchType) {
        String filterName = "";
        if (searchType.equals("изданиям")) {
            filterName = "Все издания";
        } else if (searchType.equals("темам")) {
            filterName = "Все темы";
        } else if (searchType.equals("видео")) {
            filterName = "Все видео";
        } else if (searchType.equals("справочник")) {
            filterName = "Весь справочник";
        }else if (searchType.equals("формы")){
            filterName = "Все формы";
        }
        WebElement magazinesFilter = waitForVisibilityOfElementLocatedBy(By.xpath("//*[text()='" + filterName + "']/../../.."), "Не найден фильтр по " + searchType);
        List<WebElement> magazinesFilterValues = magazinesFilter.findElements(By.tagName("li"));
        List<WebElement> actualFilterValues = new ArrayList<WebElement>();
        for (WebElement magazineFilter : magazinesFilterValues) {
            if (magazineFilter.isDisplayed() && !magazineFilter.getText().isEmpty()) {
                actualFilterValues.add(magazineFilter);
            }
        }

        postponedAssertFalse(actualFilterValues.isEmpty(), "Фильтр по " + searchType + " пуст");
        String actualClassName = actualFilterValues.get(0).findElement(By.xpath("./a")).getAttribute("class");
        postponedAssertTrue(actualClassName != null && actualClassName.contains("btn_state_active"), "Неправильное значение по-умолчанию фильтра по " + searchType + ".");
        postponedAssertEquals(actualFilterValues.size(), expectedFilterValues.length, "Неправильное количество поисковых фильтров");
        for (int i = 0; i < expectedFilterValues.length; i++) {
            postponedAssertEquals(actualFilterValues.get(i).getText(), expectedFilterValues[i], "Неправильное значения фильтра по " + searchType);
        }
    }


    private void checkArchiveFilter() {
        List<WebElement> filters = mainContentElement.findElements(By.xpath("//*[text()='Весь архив']/../../.."));
        String age = null;
        if (getSettings().isRunBss()) {
            age = "два";
        } else if (getSettings().isRunFss()) {
            age = "три";
        }

        if (!filters.isEmpty()) {
            WebElement archiveFilter = filters.get(0);
            List<WebElement> archiveFilterItems = archiveFilter.findElements(By.tagName("a"));

            postponedAssertTrue(archiveFilterItems.get(1).getAttribute("class") != null &&
                    archiveFilterItems.get(1).getAttribute("class").contains("active"), "Неправильное значение по-умолчанию фильтра по архиву. " +
                    "Ожидаемый результат: 'Последние " + age + " года'. Наблюдаемый результат: '" + archiveFilterItems.get(1).getText() + "'");

            postponedAssertEquals(archiveFilterItems.get(0).getText(), "Весь архив", "Неправильное значения фильтра по архиву");
            postponedAssertEquals(archiveFilterItems.get(1).getText(), "Последние " + age + " года", "Неправильное значения фильтра по архиву");
            postponedAssertEquals(archiveFilterItems.get(2).getText(), "Последние " + age + " месяца", "Неправильное значения фильтра по архиву");
        } else {
            setPostponedTestFail("Отсутствует фильтр по архиву");
        }
    }

    private WebElement getSearchFilter(By by) {
        return waitForPresenceOfElementLocatedBy(By.cssSelector(".search-list"), "Результаты поиска не отображаются").findElement(by);
    }

    public String getExpectedResultHeader() {
        String resultText = "Результаты поиска по реквизитам";

        if (getParameter(ExtendedSearchForm.SEARCH_TEXT) != null) {
            resultText = resultText + ": «" + String.valueOf(getParameter(ExtendedSearchForm.SEARCH_TEXT)) + "»";
        }

        if (getParameter(ExtendedSearchForm.SEARCH_NUMBER) != null) {
            resultText = resultText + "Номер документа —  «" + String.valueOf(getParameter(ExtendedSearchForm.SEARCH_NUMBER)) + "»";
        }

        if (getParameter(ExtendedSearchForm.TYPE_VALUE) != null) {
            resultText = resultText + "вид —  «" + String.valueOf(getParameter(ExtendedSearchForm.TYPE_VALUE)) + "»";
        }

        if (getParameter(ExtendedSearchForm.LOBBY_VALUE) != null) {
            resultText = resultText + "орган —  «" + String.valueOf(getParameter(ExtendedSearchForm.LOBBY_VALUE)) + "»";
        }

        if (getParameter(ExtendedSearchForm.REGION_VALUE) != null && !"РФ".equals(String.valueOf(getParameter(ExtendedSearchForm.REGION_VALUE)))) {
            resultText = resultText + "регион —  «" + String.valueOf(getParameter(ExtendedSearchForm.REGION_VALUE)) + "»";
        }

        if (getParameter(ExtendedSearchForm.START_DATE) != null || getParameter(ExtendedSearchForm.END_DATE) != null) {
            resultText = resultText + "дата принятия:";
        }

        if (getParameter(ExtendedSearchForm.START_DATE_NOT_FORMATTED) != null) {
            resultText = resultText + " с " + String.valueOf(getParameter(ExtendedSearchForm.START_DATE_NOT_FORMATTED));
        }

        if (getParameter(ExtendedSearchForm.END_DATE_NOT_FORMATTED) != null) {
            resultText = resultText + " по " + String.valueOf(getParameter(ExtendedSearchForm.END_DATE_NOT_FORMATTED));
        }
        return resultText;
    }


    private void checkHighlightedInDocument(String query, WebElement randomDocumentLink) {
        String currentUrl = getCurrentUrl().split("\\?step=")[0];
        String documentUrl = randomDocumentLink.getAttribute("href");
        report("Открыта страница: " + currentUrl);
        report("Открывается ссылка: " + documentUrl);
        randomDocumentLink.click();
        waitForReloadingPage();

        List<WebElement> highlightedElementList = mainLeftElement.findElements(By.cssSelector(".search-word"));
        checkEmptyDocumentHeader();
        postponedAssertFalse(highlightedElementList.isEmpty(), "Не одно слово в документе не подсвеченно");

        String url = getCurrentUrl().replace("document//", "document/");
        String[] urlArr = url.split("#")[1].split("\\/");
        int moduleId = Integer.parseInt(urlArr[2]);
        int documentId = Integer.parseInt(urlArr[3]);
        List<String> highlightsWordList = getHighlightsWordListForDocument(query, moduleId, documentId);
        for (WebElement highlightedElement : highlightedElementList) {
            if (highlightedElement.isDisplayed()) {
                String highlightedWord = highlightedElement.getText().toLowerCase();
                postponedAssertTrue(highlightsWordList.contains(highlightedWord),
                        "Выделено слово не из поискового запроса. Поисковый запрос: '" + query + "' . Выделенное слово: '" + highlightedWord + "'");
            }
        }
        returnToBack();
    }

    @Step("Проверяется что результаты поиска отображаются после нажатия кнопки 'Все ...' в блокноте кодекса")
    public void checkSearchResultArePresentAfterClickAllMaterialsInReferences() {
        waitForSearchResult();
        checkSearchBoxIsPresent("Поиск документов");
        WebElement searchResultHeader = findElementByNoThrow(mainLeftElement, By.cssSelector(".search-result"));
        postponedAssertNotNull(searchResultHeader, "Не найден заголовок результатов поиска");
        postponedAssertFalse(getSearchResultItemList().isEmpty(), "Не найдены результаты поиска");
    }

    public void checkSearchResultIsPresent(String sectionSearchResult) {
        String hintText = String.valueOf(getParameter(SearchResultHelper.HINT_TEXT)).toLowerCase();
        checkSearchBoxIsPresent(hintText);
        WebElement searchResultHeader = findElementByNoThrow(mainLeftElement, By.cssSelector(".search-result"));
        assertNotNull(searchResultHeader, "Не найден заголовок результатов поиска");
        String findWord = searchResultHeader.findElement(By.tagName("h1")).getText();
        postponedAssertTrue(findWord.contains("Показаны результаты поиска") ||
                findWord.contains("«" + hintText + "»") ||
                findWord.contains("Результаты поиска по реквизитам: " + "«" + hintText + "»"), "Неправильный заголовок результатов поиска");

        WebElement searchWidget = findElementByNoThrow(mainLeftElement, By.cssSelector(".widget-search"));
        assertNotNull(searchWidget, "Не найдены результаты поиска");
        postponedAssertFalse(searchWidget.getText().isEmpty(), "Результат поиска пуст");

        String searchResultText = searchResultHeader.getText().replace(findWord, "").replace("\n", "");
        postponedAssertTrue(searchResultText.contains(sectionSearchResult),
                "Поиск производится не в той секции. Секция, в которой происходит поиск: " + sectionSearchResult +
                        " Искали вхождение этого названия здесь: " + searchResultText);
        postponedAssertTrue(isNumber(searchResultText), "В строке результатов поиска Отсутствует количество найденных документов. " +
                "Наблюдаемый результат: " + searchResultHeader.getText());
    }

    public void checkSearchResultIsNotPresent(String sectionName, MainMenuButtons menuButton) {
        String hintText = String.valueOf(getParameter(SearchResultHelper.HINT_TEXT));
        checkSearchBoxIsPresent(hintText);

        WebElement searchResultHeader = findElementByNoThrow(mainLeftElement, By.cssSelector(".search-result"));
        assertNotNull(searchResultHeader, "Не найден заголовок результатов поиска");
        String findWord = searchResultHeader.findElement(By.tagName("h1")).getText();
        postponedAssertTrue(findWord.contains("Показаны результаты поиска") ||
                findWord.contains("«" + hintText + "»") ||
                findWord.contains("Результаты поиска по реквизитам: " + "«" + hintText + "»"), "Неправильный заголовок результатов поиска");

        WebElement searchWidget = findElementByNoThrow(mainLeftElement, By.cssSelector(".widget-search"));
        postponedAssertNull(searchWidget, "Результаты поиска отображаются");

        WebElement typo = findElementByNoThrow(searchResultHeader, By.cssSelector(".typo"));
        assertNotNull(typo, "Отсутствует заглушка для пустого результата поиска.");

        boolean isLawBasePage = menuButton.equals(MainMenuButtons.LAW_BASE) || menuButton.equals(MainMenuButtons.LAW_PRACTICE);

        String message = ((isLawBasePage) ? "Ничего не найдено. " : sectionName + " ничего не найдено. ") + "Пожалуйста, посмотрите в других разделах: " +
                getTypoString(menuButton)
                + ((!sectionName.equals("В сервисах") && getSettings().isRunBss() && getCurrentUrl().contains("vip."))
                || (!sectionName.equals("В сервисах") && getSettings().isRunFss()) ? ", Сервисы" : "")
                + (menuButton.equals(MainMenuButtons.LAW_PRACTICE) ? " или переформулируйте запрос." : " или переформулируйте запрос, или поищите через рубрикатор.");
        postponedAssertEquals(typo.getText(), message, "Неправильный текст заглушки в " + menuButton.getName());
    }

    @Step("Проверяется текст в заглушке")
    public void checkTextInTypo(String message) {
        WebElement searchResultHeader = findElementByNoThrow(mainLeftElement, By.cssSelector(".search-result"));
        assertNotNull(searchResultHeader, "Не найден заголовок результатов поиска");
        WebElement typo = findElementByNoThrow(searchResultHeader, By.cssSelector(".typo"));
        assertNotNull(typo, "Отсутствует заглушка для пустого результата поиска.");
        postponedAssertEquals(typo.getText(), message, "Неправильный текст заглушки");
    }

    @Step("Проверяется текст в заглушке")
    public void checkTypoBlockIsPresent() {
        WebElement searchResultHeader = findElementByNoThrow(mainLeftElement, By.cssSelector(".search-result"));
        assertNotNull(searchResultHeader, "Не найден заголовок результатов поиска");
        WebElement typo = findElementByNoThrow(searchResultHeader, By.cssSelector(".typo"));
        postponedAssertNotNull(typo, "Отсутствует заглушка для пустого результата поиска.");
    }

    @Step("Проверяется что название раздела Отсутствует в заглушке")
    public void checkSectionIsNotPresentIn(String sectionName) {
        WebElement searchResultHeader = findElementByNoThrow(mainLeftElement, By.cssSelector(".search-result"));
        WebElement typo = findElementByNoThrow(searchResultHeader, By.cssSelector(".typo"));
        assertNotNull(typo, "Отсутствует заглушка для пустого результата поиска.");
        postponedAssertFalse(typo.getText().contains(sectionName), "В заглушки присутсвует ссылка на раздел '" + sectionName + "'");
    }

    private String getTypoString(MainMenuButtons menuButton) {
        String result = "";

        String recomendPageName;
        if (getSettings().isRunKss()) {
            recomendPageName = "Ответы";
        } else if (getSettings().isRunFss()) {
            recomendPageName = "Решения";
        } else {
            recomendPageName = "Рекомендации";
        }

        if (menuButton.equals(MainMenuButtons.ANSWERS) || menuButton.equals(MainMenuButtons.RECOMEND)) {
            if (getSettings().isRunUss()) {
                result = "Правовая база, Судебная практика, Формы, Справочник, Журналы и книги, Видео, Мастера";
            } else {
                result = "Правовая база, Формы, Справочник, Журналы и книги, Видео, Мастера";
            }
        } else if (menuButton.equals(MainMenuButtons.LAW_BASE)) {
            if (getSettings().isRunFss()) {
                result = "Решения, Положения и регламенты, Библиотека, Видео, Справочник";
            } else if (getSettings().isRunUss()) {
                result = recomendPageName + ", Судебная практика, Формы, Справочник, Журналы и книги, Видео, Мастера";
            } else {
                result = recomendPageName + ", Формы, Справочник, Журналы и книги, Видео, Мастера";
            }
        } else if (menuButton.equals(MainMenuButtons.LAW_PRACTICE)) {
            if (getSettings().isRunFss()) {
                result = "Решения, Положения и регламенты, Правовая база, Библиотека, Видео, Справочник";
            } else {
                result = recomendPageName + ", Правовая база, Формы, Справочник, Журналы и книги, Видео, Мастера";
            }
        } else if (menuButton.equals(MainMenuButtons.FORMS)) {
            result = recomendPageName + ", Правовая база, Справочник, Журналы и книги, Видео, Мастера";
        } else if (menuButton.equals(MainMenuButtons.DICTIONARY)) {
            if (getSettings().isRunFss()) {
                result = "Решения, Положения и регламенты, Правовая база, Библиотека, Видео";
            } else {
                result = recomendPageName + ", Правовая база, Формы, Журналы и книги, Видео, Мастера";
            }
        } else if (menuButton.equals(MainMenuButtons.DICTIONARIES)) {
            result = recomendPageName + ", Правовая база, Формы, Журналы и книги, Видео, Мастера";
        } else if (menuButton.equals(MainMenuButtons.MAGAZINES_AND_BOOKS)) {
            result = recomendPageName + ", Правовая база, Формы, Справочник, Видео, Мастера";
        } else if (menuButton.equals(MainMenuButtons.MAGAZINES)) {
            result = recomendPageName + ", Правовая база, Формы, Справочник, Видео, Мастера";
        } else if (menuButton.equals(MainMenuButtons.VIDEO)) {
            if (getSettings().isRunFss()) {
                result = "Решения, Положения и регламенты, Правовая база, Библиотека, Справочник";
            } else {
                result = recomendPageName + ", Правовая база, Формы, Справочник, Журналы и книги, Мастера";
            }
        } else if (menuButton.equals(MainMenuButtons.WIZARDS)) {
            result = recomendPageName + ", Правовая база, Формы, Справочник, Журналы и книги, Видео";
        } else if (menuButton.equals(MainMenuButtons.FSS_SOLUTIONS)) {
            result = "Положения и регламенты, Правовая база, Библиотека, Видео, Справочник";
        } else if (menuButton.equals(MainMenuButtons.LIBRARY)) {
            result = "Решения, Положения и регламенты, Правовая база, Видео, Справочник";
        } else if (menuButton.equals(MainMenuButtons.FSS_FORMS)) {
            result = "Решения, Правовая база, Библиотека, Видео, Справочник";
        } else if (menuButton.equals(MainMenuButtons.RABOTARU) || (menuButton.equals(MainMenuButtons.KSS_SERVICES))) {
            result = "Ответы, Правовая база, Формы, Справочник, Журналы и книги, Видео, Мастера";
        } else if (menuButton.equals(MainMenuButtons.SERVICES)) {
            if ((getSettings().isRunFss())) {
                result = "Решения, Положения и регламенты, Правовая база, Библиотека, Видео, Справочник";
            } else {
                result = recomendPageName + ", Правовая база, Формы, Справочник, Журналы, Видео";
            }
        }

        if (getSettings().isRunBss()) {
            result = result.replace(", Мастера", "").replace("Журналы и книги", "Журналы").replace("Справочник", "Справочники");
        }

        if (getSettings().isRunKss()) {
            result = result.replace(", Мастера", ", Сервисы").replace("Журналы,", "Журналы и книги,");
        }

        return result;
    }


    @Step("Проверяется фильтр органов")
    public void checkDepartmentFilter() {
        String[] filterValue;
        if (getSettings().isRunKss()) {
            filterValue = new String[]{"Все документы", "Федеральные", "Региональные", "Минтруд", "Роструд", "Пленумов"};
        } else if (getSettings().isRunUss()) {
            filterValue = new String[]{"Все документы", "Федеральные законы", "Подзаконные акты", "Региональные", "Пленумов"};
        } else {
            filterValue = new String[]{"Все документы", "Федеральные", "Региональные", "Минфин", "ФНС", "Пленумов"};
        }

        WebElement departmentFilter = waitForVisibilityOfElementLocatedBy(By.cssSelector("[data-filtr-name='tags']"),
                "Не найден поисковый фильтр: Органов(Все органы, Федеральные, Региональные)");

        List<WebElement> filterList = departmentFilter.findElements(By.cssSelector("li a"));
        postponedAssertFalse(filterList.isEmpty(), "фильтр Органов власти пустой");

        String activeFilterName = "";
        for (WebElement filter : filterList) {
            if (filter.getAttribute("class") != null && filter.getAttribute("class").contains("active")) {
                activeFilterName = filter.getText();
                break;
            }
        }
        postponedAssertEquals(activeFilterName, "Все документы", "Неправильное значение по-умолчанию для фильтра Органов власти.");

        if (filterList.size() == filterValue.length) {
            for (int i = 0; i < filterValue.length; i++) {
                postponedAssertEquals(filterList.get(i).getText(), filterValue[i], "Неправильное значения для фильтра Органов власти");
            }
        }
    }

    private void checkDepartmentFilter(String departmentFilterValue) {
        String[] filterValue;
        if (getSettings().isRunKss()) {
            filterValue = new String[]{"Все документы", "Федеральные", "Региональные", "Минтруд", "Роструд", "Решения судов"};
        } else if (getSettings().isRunUss()) {
            filterValue = new String[]{"Все документы", "Федеральные законы", "Подзаконные акты", "Региональные", "Решения судов"};
        } else {
            filterValue = new String[]{"Все документы", "Федеральные", "Региональные", "Минфин", "ФНС", "Решения судов"};
        }
        WebElement departmentFilter = waitForVisibilityOfElementLocatedBy(By.cssSelector("[data-filtr-name='tags']"), "Не найден поисковый фильтр: Органов(Все органы, Федеральные, Региональные)");

        List<WebElement> filterList = departmentFilter.findElements(By.cssSelector("li a"));
        postponedAssertFalse(filterList.isEmpty(), "фильтр Органов власти пустой");

        String activeFilterName = "";
        for (WebElement filter : filterList) {
            if (filter.getAttribute("class") != null && filter.getAttribute("class").contains("active")) {
                activeFilterName = filter.getText();
                break;
            }
        }
        postponedAssertEquals(activeFilterName, departmentFilterValue, "Неправильное значение по-умолчанию для фильтра Органов власти.");

        if (filterList.size() == filterValue.length) {
            for (int i = 0; i < filterValue.length; i++) {
                postponedAssertEquals(filterList.get(i).getText(), filterValue[i], "Неправильное значения для фильтра Органов власти");
            }
        }
    }

    public void checkStatusFilter() {
        WebElement statusFilter;
        statusFilter = waitForVisibilityOfElementLocatedBy(By.cssSelector("[data-filtr-name*='status']"), "Не найден фильтр статусов");
        List<WebElement> statusFilterValues = statusFilter.findElements(By.tagName("li"));

        postponedAssertEquals(statusFilterValues.get(0).getText(), "Все статусы", "Неправильное значения для фильтра статусов");
        postponedAssertEquals(statusFilterValues.get(1).getText(), "Утратившие силу", "Неправильное значения для фильтра статусов");
        postponedAssertEquals(statusFilterValues.get(2).getText(), "Действующие", "Неправильное значения для фильтра статусов");
        postponedAssertEquals(statusFilterValues.get(3).getText(), "Не вступившие в силу", "Неправильное значения для фильтра статусов");

        postponedAssertTrue(statusFilterValues.get(0).findElement(By.tagName("a")).getAttribute("class").contains("active"), "По умолчанию выбран не тот фильтр. Ожидалось Все статусы");
    }

    @Step("Проверяется фильтр по статусу на наличие")
    public void checkStatusFilterIsPresent() {
        waitForVisibilityOfElementLocatedBy(By.cssSelector("[data-filtr-name*='status']"), "Не найден фильтр статусов");
    }

    @Step("Проверяется что Фильтр по статусам не отображен")
    public void checkStatusFilterIsNotPresent() {
        WebElement statusFilter = findElementByNoThrow(By.cssSelector("[data-filtr-name*='status']"));
        postponedAssertNull(statusFilter, "Фильтр по статусам отображен на странице");
    }

    private boolean isDocumentPresent(String documentText) {
        report("Проверяется что документ с текстом '" + documentText + "' присутсвует в поисковой выдаче");
        WebElement content = getWidgetSearch();
        List<WebElement> resultHeaderList = content.findElements(By.cssSelector(".widget-header"));
        List<WebElement> resultTextList = content.findElements(By.cssSelector(".widget-text"));
        boolean isDocumentPresent = false;

        for (WebElement result : resultHeaderList) {
            if (result.getText().contains(documentText)) {
                isDocumentPresent = true;
                break;
            }
        }

        for (WebElement result : resultTextList) {
            if (result.getText().contains(documentText)) {
                isDocumentPresent = true;
                break;
            }
        }
        return isDocumentPresent;
    }

    private int getNumberFromString(String searchResultCounter) {
        String[] counterStringArray = searchResultCounter.split(" ");
        for (String word : counterStringArray) {
            if (isIntegerParse(word)) {
                return Integer.parseInt(word);
            }
        }
        return -1;
    }

    private boolean isNumber(String searchResultCounter) {
        String[] counterStringArray = searchResultCounter.split(" ");
        for (String word : counterStringArray) {
            if (isIntegerParse(word)) {
                return true;
            }
        }
        return false;
    }

    private boolean isIntegerParse(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException ignored) {
            return false;
        }
    }

    private int getNumberOfSearchResult() {
        WebElement searchResultHeader = waitForVisibilityOfElementLocatedBy(By.cssSelector(".search-result"), "Заголовок результатов поиска не найден");
        String counterString = searchResultHeader.getText();
        return getNumberFromString(counterString);
    }

    private WebElement getRandomDocumentLinkFromSearchResult() {
        WebElement searchResultWidget = getWidgetSearch();
        List<WebElement> searchResultList = searchResultWidget.findElements(By.cssSelector(".widget-header"));
        return getRandomElementInList(searchResultList).findElement(By.tagName("a"));
    }


    public List<SearchItem> getSearchResultItemList() {
        List<SearchItem> searchItemList = new ArrayList<SearchItem>();
        WebElement searchResultWidget = waitForPresenceOfElementLocatedBy(By.id("searchResultsSection"), "Результаты поиска не найдены");
        List<WebElement> header = searchResultWidget.findElements(By.cssSelector(".widget-header"));
        List<WebElement> text = searchResultWidget.findElements(By.cssSelector(".widget-text"));
        List<WebElement> relevance = searchResultWidget.findElements(By.cssSelector(".item-relevance"));
        List<WebElement> source = searchResultWidget.findElements(By.cssSelector(".widget-source"));
        List<WebElement> abbr = searchResultWidget.findElements(By.xpath(".//abbr"));

        for (int i = 0; i < header.size(); i++) {
            SearchItem searchItem = new SearchItem(null, null, null, null);
            try {
                searchItem.header = header.get(i);
            } catch (Exception ex) {
            }
            try {
                searchItem.text = text.get(i);
            } catch (Exception ex) {
            }
            try {
                searchItem.relevance = relevance.get(i);
            } catch (Exception ex) {
            }
            try {
                searchItem.source = source.get(i);
            } catch (Exception ex) {
            }
            try {
                searchItem.abbr = abbr.get(i);
            } catch (Exception ex) {
            }
            searchItemList.add(searchItem);
        }
        return searchItemList;
    }

    private List<SearchItem> getSearchResultItemList(WebElement searchResultWidget) {
        List<SearchItem> searchItemList = new ArrayList<SearchItem>();
        List<WebElement> header = searchResultWidget.findElements(By.className("widget-header"));
        List<WebElement> text = searchResultWidget.findElements(By.cssSelector(".widget-text"));
        List<WebElement> relevance = searchResultWidget.findElements(By.cssSelector(".item-relevance"));
        List<WebElement> source = searchResultWidget.findElements(By.cssSelector(".widget-source"));

        for (int i = 0; i < header.size(); i++) {
            SearchItem searchItem = new SearchItem(null, null, null, null);
            try {
                searchItem.header = header.get(i);
            } catch (Exception ex) {
            }
            try {
                searchItem.text = text.get(i);
            } catch (Exception ex) {
            }
            try {
                searchItem.relevance = relevance.get(i);
            } catch (Exception ex) {
            }
            try {
                searchItem.source = source.get(i);
            } catch (Exception ex) {
            }
            searchItemList.add(searchItem);
        }
        return searchItemList;
    }

    public void mouseHoverFirstItemFormWidget() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(findElementBy(By.cssSelector(".widget-forms li:nth-child(1) a"))).build().perform();
    }

    public void mouseHoverSecondItemFormWidget() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(findElementBy(By.cssSelector(".widget-forms li:nth-child(2) a"))).build().perform();
    }

    public void mouseHoverThirdItemFormWidget() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(findElementBy(By.cssSelector(".widget-forms li:nth-child(3) a"))).build().perform();
    }

    public void checkFirstItemFormWidgetIsRed() {
        String actualColor = findElementBy(By.cssSelector(".widget-forms .widget-list>li:nth-child(1)>a:hover>u")).getCssValue("color");
        postponedAssertEquals(actualColor, "rgba(224, 84, 39, 1)", "Первый элемент Колдунщика форм подкрашен не тем цветом");
    }

    public void checkSecondItemFormWidgetIsGreen() {
        String actualColor = findElementBy(By.cssSelector(".widget-forms .widget-list>li:nth-child(2)>a:hover>u")).getCssValue("color");
        postponedAssertEquals(actualColor, "rgba(92, 146, 27, 1)", "Второй элемент Колдунщика форм подкрашен не тем цветом");
    }

    public void checkThirdItemFormWidgetIsPurple() {
        String actualColor = findElementBy(By.cssSelector(".widget-forms .widget-list>li:nth-child(3)>a:hover>u")).getCssValue("color");
        postponedAssertEquals(actualColor, "rgba(134, 91, 178, 1)", "Третий элемент Колдунщика форм подкрашен не тем цветом");
    }

    @Step("В поисковой выдаче выделены жирным слова")
    public void checkSearchResultHasStrongText() {
        List<WebElement> strongText = findElementsByNoThrow(By.cssSelector("#searchResultsSection u strong"));
        if (strongText.isEmpty()) {
            setPostponedTestFail("В поисковой выдаче не выделены жирным слова");
        }
    }

    @Step("В поисковой выдаче НЕ выделены жирным слова")
    public void checkSearchResultHasNOTStrongText() {
        List<WebElement> strongText = findElementsByNoThrow(By.cssSelector("#searchResultsSection u strong"));
        if (!strongText.isEmpty()) {
            setPostponedTestFail("В поисковой выдаче выделены жирным слова");
        }
    }

    private class SearchItem {
        WebElement header;
        WebElement text;
        WebElement relevance;
        WebElement source;
        WebElement abbr;

        SearchItem(WebElement header, WebElement text, WebElement relevance) {
            this.header = header;
            this.text = text;
            this.relevance = relevance;
            this.source = null;
        }

        SearchItem(WebElement header, WebElement text, WebElement relevance, WebElement source) {
            this.header = header;
            this.text = text;
            this.relevance = relevance;
            this.source = source;
        }

        SearchItem(WebElement header, WebElement text, WebElement relevance, WebElement source, WebElement abbr) {
            this.header = header;
            this.text = text;
            this.relevance = relevance;
            this.source = source;
            this.abbr = abbr;
        }

        public WebElement getHeader() {
            return header;
        }

        public WebElement getText() {
            return text;
        }

        public WebElement getRelevance() {
            return relevance;
        }

        public WebElement getSource() {
            return source;
        }

        public WebElement getAbbr() {
            return abbr;
        }

    }

    private WebElement getWidgetSearch() {
        return waitForVisibilityOfElementLocatedBy(By.cssSelector(".widget-search"), "Резульататы поиска не найдены");
    }

    private WebElement getDepartmentFilter(By by) {
        return waitForVisibilityOfElementLocatedBy(By.cssSelector("[data-filtr-name='tags']"), "Фильтр Органов власти не найден").findElement(by);
    }

    private WebElement getStatusFilter(By by) {
        return waitForVisibilityOfElementLocatedBy(By.cssSelector("[data-filtr-name='status']"), "Фильтр статусов не найден").findElement(by);
    }

    @Step("Проверяется что открыта страница Ответы с результатами поиска")
    public void checkSearchResultOnSolutionsPageIsOpened() {
        checkSectionFilter(MainMenuButtons.FSS_SOLUTIONS);
        checkSearchResultIsPresent("В решениях найдено");
        checkTopicFilter();
    }

    @Step("Проверяется работа ссылок в фильтре ")
    public void checkLinksTopicFilter() {
        String[] filterStringArray = null;
        if (getSettings().isRunKss()) {
            filterStringArray = KSS_ANSWER_LIST;
        } else if (getSettings().isRunFss()) {
            if (getCurrentUrl().contains("#/solutions/")) {
                filterStringArray = FSS_ANSWER_LIST;
            } else if (getCurrentUrl().contains("#/forms/")) {
                filterStringArray = FSS_FORMS_TOPIC_LIST;
            } else if (getCurrentUrl().contains("#/handbook/")) {
                filterStringArray = FSS_DICTIONARY_FILTER;
            }
        } else if (getSettings().isRunBss()) {
            filterStringArray = BSS_RECOMEND_LIST;
        }

        List<WebElement> searchResultLinkList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются");
        if (filterStringArray != null) {
            for (int i = 1; i < filterStringArray.length; i++) {
                WebElement filter = waitForVisibilityOfElementLocatedBy(By.cssSelector("[data-filtr-name='tags']"), "Не найден фильтр по темам");
                WebElement topic = filter.findElement(By.xpath(".//u[text()='" + filterStringArray[i] + "']"));
                String filterNumber = getParentElement(getParentElement(topic)).getAttribute("data-param");
                topic.click();
                waitForReloadingPage();
                postponedAssertTrue(getCurrentUrl().contains("tags=" + filterNumber), "Не корректный URL");
                postponedAssertFalse(searchResultLinkList.equals(waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются")), "Поисковая выдача не изменилась");
            }
        }
    }

    @Step("Проверяется отображение фильтра по Отраслей")
    public void checkBranchFilter() {
        List<WebElement> branchFilters = findElementsBy(By.cssSelector("[data-filtr-name='tags']"), "Не найден фильтр отраслей");
        assertFalse(branchFilters.isEmpty(), "Не найден фильтр отраслей");
        List<WebElement> statusFilterValues = branchFilters.get(1).findElements(By.tagName("li"));

        for (int i = 0; i < statusFilterValues.size(); i++) {
            postponedAssertEquals(statusFilterValues.get(i).getText(), BSS_BRANCH_FILTER[i], "Неправильное значения для фильтра отраслей");
        }
    }

    @Step("Проверяется наличие Поисковых фильтров")
    public void checkBranchFilterIsPresent() {
        postponedAssertNotNull(findElementsByNoThrow(By.cssSelector("[data-filtr-name='tags']")), "Не найдены поисковые фильтры");
    }

    @Step("Проверяется что фильтр по Отраслям в БСС не отображен")
    public void checkBranchFilterIsNotPresent() {
        postponedAssertNotNull(findElementsByNoThrow(By.cssSelector("[data-filtr-name='tags']")), "Не найден фильтр отраслей");
    }

    @Step("Проверяется отображение фильтра по Сервисам")
    public void checkServicesFilter() {
        WebElement servicesFilters = findElementByNoThrow(By.cssSelector("[data-filtr-name='tags']"));
        if (servicesFilters != null) {
            List<WebElement> statusFilterValues = servicesFilters.findElements(By.tagName("li"));

            for (int i = 0; i < statusFilterValues.size(); i++) {
                postponedAssertEquals(statusFilterValues.get(i).getText(), FSS_SERVICES_FILTER[i], "Неправильное значения для фильтра Сервисов");
            }
        } else
            setPostponedTestFail("Не найден фильтр Сервисов");

    }

    @Step("Проверяется работа фильтра По отраслям")
    public void checkLinksServicesFilter() {
        checkLinkInFilters(FSS_SERVICES_FILTER, "по темам");
    }

    @Step("Проверяется работа фильтра По отраслям")
    public void checkLinksBranchFilter() {
        List<WebElement> branchFilters =
                findElementsBy(By.cssSelector("[data-filtr-name='tags']")).get(1).findElements(By.tagName("li"));

        for (int i = 0; i < branchFilters.size(); i++) {
            String tagNumber = branchFilters.get(i).getAttribute("data-param");

            branchFilters.get(i).click();
            waitForReloadingPage();

            postponedAssertTrue(getCurrentUrl().contains(tagNumber), "URL не изменился для фильтра по отраслям");

        }
    }

    @Step("Проверяется свернутый колдунщик")
    public void checkWidgetsFolder() {
        WebElement widget = findElementBy(By.cssSelector(".widget-code"), "Колдунщик ОКОФ не найден");
        postponedAssertTrue(widget.isDisplayed(), "Колдунщик ОКОФ не отображается");
        postponedAssertEquals(widget.findElement(By.tagName("h3")).getText(), "Коды", "Не правильный текст заголовка");
        List<WebElement> listLi = widget.findElements(By.tagName("li"));
        int numberOfLinks = 0;

        for (WebElement li : listLi) {
            postponedAssertNotNull(li.findElement(By.xpath(".//a")).getAttribute("href"), "Не хватает ссылок");
            postponedAssertNotNull(li.findElement(By.xpath(".//span")).getText(), "Нет описания ссылки");
            if (li.isDisplayed()) {
                numberOfLinks++;
            }
        }
        postponedAssertTrue(numberOfLinks > 0 && numberOfLinks <= 3, "Не правильное количество ссылок");
        if (listLi.size() > 3) {
            List<WebElement> hideLinks = widget.findElements(By.className("widget-show-more"));
            for (WebElement hideLink : hideLinks) {
                if (hideLink.isDisplayed()) {
                    postponedAssertEquals(hideLink.findElement(By.xpath(".//a")).getText(), "Показать еще", "Не правильный текст на кпопке 'Показать еще'");
                }
            }
        }
    }

    @Step("Проверяется колдунщик Кодов")
    public void checkWidgetCodeDictionary() {
        WebElement widget = findElementBy(By.cssSelector(".widget-code"), "Колдунщик Кодов не найден");
        postponedAssertTrue(widget.isDisplayed(), "Колдунщик Кодов не отображается");
        postponedAssertEquals(widget.findElement(By.tagName("h3")).getText(), "Коды", "Не правильный текст заголовка");
        List<WebElement> listLi = widget.findElements(By.tagName("li"));
        int numberOfLinks = 0;

        for (WebElement li : listLi) {
//            postponedAssertNotNull(li.findElement(By.xpath(".//a")).getAttribute("href"), "Не хватает ссылок");
            postponedAssertNotNull(li.findElement(By.xpath(".//span")).getText(), "Нет описания ссылки");
            if (li.isDisplayed()) {
                numberOfLinks++;
            }
        }
        postponedAssertTrue(numberOfLinks > 0 && numberOfLinks <= 3, "Не правильное количество кодов КБК");
        postponedAssertNotNull(findElementByNoThrow(By.cssSelector(".widget-kbk-source a")), "Не найден Источник");

        if (listLi.size() > 3) {
            List<WebElement> hideLinks = widget.findElements(By.className("widget-show-more"));
            for (WebElement hideLink : hideLinks) {
                if (hideLink.isDisplayed()) {
                    postponedAssertEquals(hideLink.findElement(By.xpath(".//a")).getText(), "Показать еще", "Не правильный текст на кпопке 'Показать еще'");
                }
            }
        }
    }

    @Step("Проверяется развернутый колдунщик")
    public void checkWidgetsFull() {
        WebElement widget = findElementBy(By.cssSelector(".widget-code"), "Колдунщик ОКОФ не найден");
        postponedAssertTrue(widget.isDisplayed(), "Колдунщик ОКОФ не отображается");
        postponedAssertEquals(widget.findElement(By.tagName("h3")).getText(), "Коды", "Не правильный текст заголовка");
        List<WebElement> listLi = widget.findElements(By.tagName("li"));

        for (WebElement li : listLi) {
            postponedAssertTrue(li.isDisplayed(), "Статья не отображается");
            postponedAssertNotNull(li.findElement(By.xpath(".//a")).getAttribute("href"), "Не хватает ссылок");
            postponedAssertNotNull(li.findElement(By.xpath(".//span")).getText(), "Нет описания ссылки");
        }
        List<WebElement> hideLinks = widget.findElements(By.className("widget-show-more"));
        for (WebElement hideLink : hideLinks) {
            if (hideLink.isDisplayed()) {
                postponedAssertEquals(hideLink.findElement(By.xpath(".//a")).getText(), "Свернуть", "Не правильный текст на кпопке 'Свернуть'");
            }
        }
    }

    @Step("Проверяется развернутый колдунщик")
    public void checkWidgetCodesFull() {
        WebElement widget = findElementBy(By.cssSelector(".widget-code"), "Колдунщик Кодов не найден");
        postponedAssertTrue(widget.isDisplayed(), "Колдунщик Кодов не отображается");
        postponedAssertEquals(widget.findElement(By.tagName("h3")).getText(), "Коды", "Не правильный текст заголовка");
        List<WebElement> listLi = widget.findElements(By.tagName("li"));

        for (WebElement li : listLi) {
            postponedAssertTrue(li.isDisplayed(), "Статья не отображается");
//            postponedAssertNotNull(li.findElement(By.xpath(".//a")).getAttribute("href"), "Не хватает ссылок");
            postponedAssertNotNull(li.findElement(By.xpath(".//span")).getText(), "Нет описания ссылки");
        }
        List<WebElement> hideLinks = widget.findElements(By.className("widget-show-more"));
        for (WebElement hideLink : hideLinks) {
            if (hideLink.isDisplayed()) {
                postponedAssertEquals(hideLink.findElement(By.xpath(".//a")).getText(), "Свернуть", "Не правильный текст на кпопке 'Свернуть'");
            }
        }
    }

    @Step("Кликаем на 'Показать еще' / 'Свернуть' в колдунщике")
    public void clickWidgetShowMore() {
        WebElement widget = findElementBy(By.cssSelector(".widget-code"), "Колдунщик ОКОФ не найден");
        widget.findElement(By.className("widget-show-more")).click();
        waitForReloadingPage();
    }

    @Step("Проверяется общее отображение колдунщика Формы")
    public void checkWidgetFormsPresent() {
        WebElement widget = findElementByNoThrow(By.cssSelector(".widget-forms"));
        checkWidget(widget, "В формах и образцах");
    }

    @Step("Проверяется общее отображение колдунщика В правовой базе")
    public void checkWidgetLawPresent() {
        WebElement widget = findElementByNoThrow(By.cssSelector(".widget-law"));
        checkWidget(widget, "В правовой базе");
    }

    @Step("Проверяется общее отображение колдунщика В справочниках")
    public void checkWidgetDictionaryPresent() {
        WebElement widget = findElementByNoThrow(By.cssSelector(".widget-handbook"));
        checkWidget(widget, "В справочниках");
    }

    public void checkWidget(WebElement widget, String name) {
        if (widget != null) {
            postponedAssertTrue(widget.isDisplayed(), "Колдунщик '" + name + "' не отображается");
            postponedAssertEqualsText(widget.findElement(By.tagName("h3")), name);
            List<WebElement> listLi = widget.findElements(By.tagName("li"));
            int numberOfLinks = 0;

            for (WebElement li : listLi) {
                postponedAssertNotNull(li.findElement(By.xpath(".//a")).getAttribute("href"), "Не хватает ссылок");
                if (li.isDisplayed()) {
                    numberOfLinks++;
                }
            }
            postponedAssertTrue(numberOfLinks > 0 && numberOfLinks <= 3, "Не правильное количество ссылок");
            if (listLi.size() > 3) {
                List<WebElement> hideLinks = widget.findElements(By.className("widget-show-more"));
                for (WebElement hideLink : hideLinks) {
                    if (hideLink.isDisplayed()) {
                        postponedAssertEquals(hideLink.findElement(By.xpath(".//a")).getText(), "Показать еще", "Не правильный текст на кпопке 'Показать еще'");
                    }
                }
            }
        } else {
            setPostponedTestFail("Колдунщик " + name + " не найден");
        }
    }

    @Step("Проверяется общее отображение колдунщика В журналах")
    public void checkMagazinesWidget(String name) {
        WebElement widget = findElementByNoThrow(By.cssSelector(".widget-press"));
        if (widget != null) {
            postponedAssertTrue(widget.isDisplayed(), "Колдунщик '" + name + "' не отображается");
            postponedAssertEqualsText(widget.findElement(By.tagName("h3")), name);
            WebElement book = findElementByNoThrow(widget, By.cssSelector(".magazine"));
            if (book == null) {
                book = findElementByNoThrow(widget, By.cssSelector(".book"));
            }
            if (book != null) {
                postponedAssertTrue(book.isDisplayed(), "Обложка не отображается");
            } else {
                setPostponedTestFail("Обложка не отображается");
            }

            WebElement textElement = findElementByNoThrow(widget, By.cssSelector(".press-text"));
            if (textElement != null) {
                postponedAssertTrue(!textElement.findElement(By.xpath(".//span")).getText().equals("")
                        && textElement.findElement(By.xpath(".//span")).isDisplayed(), "Нет названия книги");
                WebElement link = findElementByNoThrow(textElement, By.tagName("a"));
                if (link != null) {
                    postponedAssertTrue(!link.getText().equals("") && link.isDisplayed(), "Не отображается ссылка о книге");
                } else {
                    setPostponedTestFail("Ссылка 'о книге' не найдена");
                }
                WebElement aboutBookTextElement = findElementByNoThrow(textElement, By.xpath(".//p"));
                if (aboutBookTextElement != null) {
                    postponedAssertTrue(!aboutBookTextElement.getText().isEmpty() && aboutBookTextElement.isDisplayed(), "Не отображается краткое описание");
                }
            } else {
                setPostponedTestFail("Не найден элемент описания книги");
            }
            WebElement hideLink = widget.findElement(By.className("widget-show-more"));
            postponedAssertEquals(hideLink.findElement(By.xpath(".//a")).getText(), "Показать еще", "Не правильный текст на кпопке 'Показать еще'");
        } else {
            setPostponedTestFail("Колдунщик " + name + " не найден");
        }
    }

    @Step("Проверяется общее отображение колдунщика Видео")
    public void checkVideoWidget(String name) {
        WebElement widget = findElementByNoThrow(By.cssSelector(".widget-videos"));
        if (widget != null) {
            postponedAssertTrue(widget.isDisplayed(), "Колдунщик '" + name + "' не отображается");
            postponedAssertEquals(widget.findElement(By.tagName("h3")).getText().toLowerCase(), name.toLowerCase(), "Текст не совпадает");

            WebElement videos = findElementByNoThrow(widget, By.cssSelector(".videos"));
            if (videos != null) {
                postponedAssertTrue(videos.isDisplayed(), "Скриншот видео не отображается");
            } else {
                setPostponedTestFail("Скриншот видео не отображается");
            }
            WebElement textElement = findElementByNoThrow(widget, By.cssSelector(".videos-rim"));
            if (textElement != null) {
                WebElement linkPartVideoWorkshop = findElementByNoThrow(textElement, By.xpath(".//p[1]/a"));
                if (linkPartVideoWorkshop != null) {
                    postponedAssertTrue(!linkPartVideoWorkshop.getText().equals("") && linkPartVideoWorkshop.isDisplayed(), "Не отображается ссылка на часть видеосеминара");
                } else {
                    setPostponedTestFail("Элемент ссылка на часть видеосеминара не найден");
                }
                WebElement linkVideoWorkshop = findElementByNoThrow(textElement, By.xpath(".//p[2]/a"));
                if (linkVideoWorkshop != null) {
                    postponedAssertTrue(!linkVideoWorkshop.getText().equals("") && linkVideoWorkshop.isDisplayed(), "Не отображаетсяОтображается ссылка Из видео (видеосеминар с самого начала)");
                } else {
                    setPostponedTestFail("Элемент Отображается ссылка Из видео (видеосеминар с самого начала) не найден");
                }
            } else {
                setPostponedTestFail("Не найден элемент сылки на видео");
            }
            WebElement hideLink = widget.findElement(By.className("widget-show-more"));
            postponedAssertEquals(hideLink.findElement(By.xpath(".//a")).getText(), "Показать еще", "Не правильный текст на кпопке 'Показать еще'");
        } else {
            setPostponedTestFail("Колдунщик " + name + " не найден");
        }
    }

    @Step("Проверяется работа ссылок 'В правовой базе' и 'Показать еще'")
    public void checkClickInMainLinkInLawWidget() {
        checkClickInMainLinkInWidget(".widget-law", MainMenuButtons.LAW_BASE);
    }

    @Step("Проверяется работа ссылок 'В формах и образцах' и 'Показать еще'")
    public void checkClickInMainLinkInFormsWidget() {
        if (getSettings().isRunFss()) {
            checkClickInMainLinkInWidget(".widget-forms", MainMenuButtons.LAW_BASE);
        } else {
            checkClickInMainLinkInWidget(".widget-forms", MainMenuButtons.FORMS);
        }
    }

    @Step("Проверяется работа ссылок 'В справочниках' и 'Показать еще'")
    public void checkClickInMainLinkInDictionaryWidget() {
        checkClickInMainLinkInWidget(".widget-handbook", MainMenuButtons.LAW_BASE);
    }

    public void checkClickInMainLinkInWidget(String cssSelector, MainMenuButtons menuButtons) {
        WebElement widget;
        widget = findElementByNoThrow(By.cssSelector(cssSelector));
        widget.findElement(By.tagName("h3")).findElement(By.tagName("a")).click();
        waitForReloadingPage();
        checkTabIsSelected(menuButtons);
        checkSectionFilter(menuButtons);
        returnToBack();

        widget = findElementByNoThrow(By.cssSelector(cssSelector));
        WebElement hideLink = findElementByNoThrow(widget, By.cssSelector(".widget-show-more")).findElement(By.tagName("a"));
        hideLink.click();
        waitForReloadingPage();
        checkTabIsSelected(menuButtons);
        checkSectionFilter(menuButtons);
        returnToBack();
    }

    @Step("Проверяется работа ссылок колдунщика В правовой базе")
    public void checkLinksWidgetLawPage() {
        checkLinksInWidget(".widget-law");
    }

    @Step("Проверяется работа ссылок колдунщика Формах")
    public void checkLinksWidgetForms() {
        checkLinksInWidget(".widget-forms");
    }

    @Step("Проверяется работа ссылок колдунщика в справочниках")
    public void checkLinksWidgetDictionary() {
        checkLinksInWidget(".widget-handbook");
    }

    public void checkLinksInWidget(String ccsSelector) {
        WebElement widget = findElementByNoThrow(By.cssSelector(ccsSelector));
        List<WebElement> listLi = widget.findElements(By.tagName("li"));

        List<Link> linkList = new ArrayList<Link>();
        for (WebElement li : listLi) {
            String url = li.findElement(By.tagName("a")).getAttribute("href");
            String header = li.findElement(By.tagName("a")).getText();
            Link link = new Link(url, header);
            linkList.add(link);
        }
        checkLinks(linkList);
    }

    @Step("Проверяется работа ссылок колдунщика ОКОФ")
    public void checkWidgetlsLinks() {
        WebElement widget = findElementBy(By.cssSelector(".widget-code"), "Колдунщик ОКОФ не найден");
        List<WebElement> listLi = widget.findElements(By.tagName("li"));

        List<Link> linkList = new ArrayList<Link>();
        for (WebElement li : listLi) {
            String url = li.findElement(By.tagName("a")).getAttribute("href");
            String header = li.findElement(By.tagName("a")).getText();
            Link link = new Link(url, header);
            linkList.add(link);
        }
        checkLinks(linkList, 2);
    }

    @Step("Проверяется работа ссылки колдунщика Кодов Источник")
    public void checkWidgetCodesSourceLink() {
        WebElement widget = findElementBy(By.cssSelector(".widget-code"), "Колдунщик Кодов не найден");
        WebElement source = widget.findElement(By.cssSelector(".widget-kbk-source"));

        List<Link> linkList = new ArrayList<Link>();

        String url = source.findElement(By.tagName("a")).getAttribute("href");
        String header = source.findElement(By.tagName("a")).getText();
        Link link = new Link(url, header);
        linkList.add(link);
        checkLinks(linkList, 1);
    }

    @Step("Проверяется количество ответов в первых трех блоках выдачи без колдунщиков")
    public SearchResultHelper checkSearchResultBlock(boolean isWidget) {
        int firstBlock;
        int startIndex;
        if (isWidget) {
            firstBlock = 7;
            startIndex = 1;
        } else {
            firstBlock = 10;
            startIndex = 0;
        }

        WebElement searchResultsSection = waitForPresenceOfElementLocatedBy(By.id("searchResultsSection"), "Поисковая выдача не найдена");
        List<WebElement> divs = searchResultsSection.findElements(By.cssSelector(".widget_content_references"));
        ArrayList<Integer> blockSize = new ArrayList<Integer>();
        for (WebElement div : divs) {
            blockSize.add(getSearchResultItemList(div).size());
        }
        if (blockSize.size() >= 4) {
            postponedAssertTrue(blockSize.get(startIndex) == firstBlock, "Первый блок содержит: " + blockSize.get(startIndex) + " элементов. Ожидалсось:" + firstBlock + " элементов");
            postponedAssertTrue(blockSize.get(startIndex + 1) == 40, "Второй блок содержит: " + blockSize.get(startIndex) + " элементов. Ожидалсось:40 элементов");
            postponedAssertTrue(blockSize.get(startIndex + 2) == 50, "Третий блок содержит : " + blockSize.get(startIndex) + " элементов. Ожидалсось: 50 элементов");
            postponedAssertTrue(blockSize.get(startIndex + 3) >= 50, "Четвертый блок содержит : " + blockSize.get(startIndex) + " элементов. Ожидалсось: не более 50 элементов");
        } else {
            setPostponedTestFail("В поисковой выдаче меньше 150 элементов");
        }
        return this;
    }

    @Step("Проверяется что при скроле подгружаются ответы")
    public SearchResultHelper checkAddedSearchResultAtScroll() {
        List<WebElement> searchResultListBefore = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не найдены");
        List<WebElement> div = new ArrayList<WebElement>();

        WebElement showResults = findElementByNoThrow(mainContentElement, By.cssSelector(".widget__clipping-button"));
        if (showResults != null) {
            showResults.click();
        }

        int flag = 0;
        int oldSize;
        do {
            scrollScript(1000);
            waitFewSecond(1000);
            oldSize = div.size();
            div = findElementsBy(By.cssSelector(".widget_content_references"));
            if (oldSize == div.size()) {
                flag++;
            } else {
                flag = 0;
            }
        } while ((div.size() < 4) && flag < 20);

        waitForVisibilityOfElementLocatedBy(By.cssSelector(".widget-search"), "Резульататы поиска не найдены");
        List<WebElement> searchResultListAfter = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются");
        postponedAssertTrue(searchResultListAfter.size() > searchResultListBefore.size(), "Количество отображаемых документов после скролла равно количеству документов до скролла. До скролла: '" + searchResultListBefore.size() + "' . После скролла: '" + searchResultListAfter.size() + "'");
        return this;
    }

    public SearchResultHelper checkMaxSearchResultAtScroll() {
        scrollToEnd();

        postponedAssertTrue(findElementBy(By.xpath(".//div[@class='widget widget-search limit']/div")).isDisplayed(), "Сообщение 'Максимальный предел поисковой выдачи 1000 документов. Попробуйте уточнить запрос.' не отображается");
        WebElement searches = waitForPresenceOfElementLocatedBy(By.id("searchResultsSection"), "Поисковая выдача не найдена");
        List<WebElement> divs = searches.findElements(By.cssSelector(".widget_content_references"));
        int searchResult = 0;
        for (WebElement div : divs) {
            searchResult += getSearchResultItemList(div).size();
        }
        postponedAssertTrue(searchResult == 1000, "Результатов выдачи не 1000");
        return this;
    }

    @Step("Проверяется подстветка запроса в сниппете")
    public SearchResultHelper checkHighlightingRequest() {
        List<SearchItem> searchItemList = getSearchResultItemList();

        for (SearchItem searchItem : searchItemList) {
            WebElement text = searchItem.getText();
            WebElement abbr = searchItem.getAbbr();
            if (abbr != null && abbr.getText().equals("Ф")) {
                if (text != null) {
                    WebElement strong = findElementByNoThrow(text, By.tagName("strong"));
                    postponedAssertNotNull(strong, "Ключевое слово Отсутствует в снипете для результата поиска №: " + searchItem.header.findElement(By.xpath(".//span[@class='expert-list-number']")).getText());
                } else {
                    setPostponedTestFail("Отсутствует сниппет для результата поиска");
                }
            }
        }
        return this;
    }

    @Step("Открывем первый документ из поисковый выдачи найденый фразовым поиском")
    public DocumentHelper openRandomPhraseSearchDocument() {
        List<SearchItem> searchItemList = getSearchResultItemList();

        List<SearchItem> allTypeFSearchItem = new ArrayList<SearchItem>();
        for (SearchItem searchItem : searchItemList) {
            if (searchItem.getAbbr() != null && searchItem.getAbbr().getText().equals("Ф")) {
                allTypeFSearchItem.add(searchItem);
            }
        }

        if (!allTypeFSearchItem.isEmpty()) {
            getRandomElementInList(allTypeFSearchItem).header.findElement(By.tagName("a")).click();
            waitForReloadingPage();
        } else {
            openRandomSearchDocument();
        }
        return redirectTo(DocumentHelper.class);
    }

    @Step("Открывем первый документ из поисковый выдачи найденый фразовым поиском")
    public DocumentHelper openRandomSearchDocument() {
        List<SearchItem> searchItemList = getSearchResultItemList();
        int i = new java.util.Random(System.currentTimeMillis()).nextInt(searchItemList.size());
        WebElement link = searchItemList.get(i).header.findElement(By.tagName("a"));
        String url = link.getAttribute("href");
        link.click();
        waitForReloadingPage();
        //sometimes uri contains "?" before "#", example http://bss-rt.actiondigital.ru/?#/document/184/100/?step=2О
        String currentUrn = "";
        String documentUrn = "";
        try {
            currentUrn = getCurrentUrl().split("#")[1];
            documentUrn = url.split("#")[1];
        } catch (ArrayIndexOutOfBoundsException ex) {
            postponedAssertFalse(true, "Невозможно взять urn из этой ссылки:" + getCurrentUrl() + " Возможно открылся не документ?");
        }
        postponedAssertTrue(currentUrn.contains(documentUrn), "Открылся не тот документ. " + currentUrn + " Ожидалось:" + documentUrn);
        return redirectTo(DocumentHelper.class);
    }

    @Step("Проверяем отображение надписи 'Область поиска: в найденном по запросу'")
    public void checkPresentSearchResultText(String query1, String query2) {
        WebElement searchResultText = findElementByNoThrow(By.xpath(".//div[@class='search-result']"));
        if (searchResultText != null) {
            String h1 = searchResultText.findElement(By.tagName("h1")).getText();
            WebElement pElement = findElementByNoThrow(searchResultText, By.tagName("p"));
            assertNotNull(pElement, "Текст: Область поиска не найден");
            String p = pElement.getText();
            postponedAssertEquals(h1, "«" + query2 + "»", "Не совпадает текст запроса:" + h1 + " Ожидалось:" + "«" + query2 + "»");
            postponedAssertEquals(p, "Область поиска: в найденном по запросу «" + query1 + "»", "Не совпадает текст запроса:" + p + " Ожидалось:" + "Область поиска: в найденном по запросу «" + query1 + "»");
        }
    }

    @Step("Проверяем отображение надписи 'Область поиска: в найденном по запросу'")
    public void checkPresentSearchResultText(String query1, String query2, String query3) {
        WebElement searchResultText = findElementByNoThrow(By.xpath(".//div[@class='search-result']"));
        if (searchResultText != null) {
            String h1 = searchResultText.findElement(By.tagName("h1")).getText();
            String p = searchResultText.findElement(By.tagName("p")).getText();
            postponedAssertEquals(h1, "«" + query3 + "»", "Не совпадает текст запроса:" + h1 + " Ожидалось:" + "«" + query2 + "»");
            postponedAssertEquals(p, "Область поиска: в найденном по запросу «" + query1 + " << " + query2 + "»", "Не совпадает текст запроса:" + p + " Ожидалось:" + "Область поиска: в найденном по запросу «" + query1 + "»");
        }
    }

    @Step("Проверяем что установленные фильтры не сбросились")
    public void checkConditionFilter() {
        List<WebElement> filters = findElementBy(By.id("sidebar")).findElements(By.xpath(".//div/ul"));
        String param;
        if (getSettings().isRunUss()) {
            param = "42";
        } else {
            param = "2";
        }
        boolean flagTags = false;
        for (WebElement filter : filters) {
            String name = filter.getAttribute("data-filtr-name");
            if (name.equals("sort")) {
                postponedAssertEquals(filter.getAttribute("data-current-filtr-state"), "6", "Выбран не тот фильт, ожидалось По дате");
            } else if (name.equals("tags") && !flagTags) {
                postponedAssertEquals(filter.getAttribute("data-current-filtr-state").toString(), param, "Выбран не тот фильт, ожидалось Решение суда");
                flagTags = true;
            } else if (name.equals("status")) {
                postponedAssertEquals(filter.getAttribute("data-current-filtr-state"), "expired", "Выбран не тот фильт, ожидалось Утратившие силу");
            }
        }
    }

    @Step("Проверяется выбранный фильтр сортировки")
    public void checkSortedFilter(String filterName) {
        WebElement sortedFilter = waitForPresenceOfElementLocatedBy(By.xpath("//*[contains(@id,'tags-sort-by')]"), "Фильтр по типу сортировки не найден");
        WebElement activeFilter = sortedFilter.findElement(By.cssSelector(".btn_state_active"));
        postponedAssertEquals(activeFilter.getText(), filterName, "Выбран неправильный фильтр сортировки");
    }

    @Step("Проверяется выбранный фильтр сортировки")
    public void checkActiveSectionFilter(MainMenuButtons filterName) {
        WebElement sortedFilter = waitForPresenceOfElementLocatedBy(By.xpath("//*[@data-filtr-name='pubDiv']"), "Фильтр по разделам не найден");
        WebElement activeFilter = sortedFilter.findElement(By.cssSelector(".btn_state_active"));
        postponedAssertEquals(activeFilter.getText(), filterName.getName(), "Выбран неправильный фильтр по разделам");
    }

    @Step("Проверяется наличие фильтра по типу сортировки")
    public void checkSortingFilter() {
        waitForPresenceOfElementLocatedBy(By.xpath("//*[contains(@id,'tags-sort-by')]"), "Фильтр по типу сортировки не найден");
    }

    @Step("Проверяется выбранный фильтр 'Тип документа'")
    public void checkTypeDocumentFilter(String filterName) {
        WebElement sortedFilter = waitForPresenceOfElementLocatedBy(By.cssSelector("[data-filtr-name='tags']"), "Фильтр 'Тип документа' не найден");
        WebElement activeFilter = sortedFilter.findElement(By.cssSelector(".btn_state_active"));
        postponedAssertEquals(activeFilter.getText(), filterName, "Выбран неправильный фильтр 'Тип документа'");
    }

    @Step("Проверяются фильтры 'Тип документа'")
    public void checkTypeDocumentFilters() {
        List<WebElement> filterItems = findElementsBy(By.xpath(".//ul[@data-filtr-name='tags'][1]/li/a"), "Фильтр 'Тип документа' не найден");
        List<WebElement> searchResultLinkList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются");
        if (filterItems != null) {
            List<String> texts = new ArrayList<String>();
            for (WebElement filterItem : filterItems) {
                texts.add(filterItem.getText());
            }

            for (int i = 1; i < texts.size(); i++) {
                WebElement filterItem = findElementByNoThrow(By.xpath(".//ul[@data-filtr-name='tags']/li[" + (i + 1) + "]/a"));
                WebElement temp = findElementByNoThrow(By.xpath(".//ul[@data-filtr-name='tags']/li[" + i + "]/a"));
                postponedAssertTrue(temp.getAttribute("class").contains("active"), "Не подсвечивается выбранный элемент меню:" + temp.getText());
                String text = "";
                try {
                    text = filterItem.getText();
                } catch (NullPointerException npe) {
                }
                filterItem.click();
                waitForReloadingPage();
                postponedAssertEquals(text, texts.get(i), "Текст активного элемента не совпадает с нужным. Активный: " + text + " Нужный: " + texts.get(i));
                postponedAssertFalse(searchResultLinkList.equals(waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются")), "Поисковая выдача не изменилась");
                searchResultLinkList = findElementsBy(By.cssSelector(".widget-header"));
            }
        }
    }

    @Step("Проверяется наличие фильтра 'Тип документа'")
    public void checkTypeDocumentFilterIsPresent() {
        waitForPresenceOfElementLocatedBy(By.cssSelector("[data-filtr-name='tags']"), "Фильтр по органам не отображается");
    }

    @Step("Проверяется выбранный фильтр 'Статус документа'")
    public void checkStatusFilter(String filterName) {
        WebElement sortedFilter = waitForPresenceOfElementLocatedBy(By.cssSelector("[data-filtr-name='status']"), "Фильтр 'Статус документа' не найден");
        WebElement activeFilter = sortedFilter.findElement(By.cssSelector(".btn_state_active"));
        postponedAssertEquals(activeFilter.getText(), filterName, "Выбран неправильный фильтр 'Статус документа'");
    }

    @Step("Устанавливаем поиск по реквизитам")
    public void setExtended(String type, String lobby, String region) {
        waitFewSecond(2000);
        WebElement form = findElementBy(By.id("search-form-extended"));
        String[] types;
        if (type != null) {
            List<WebElement> typeList = form.findElement(By.id("typelist")).findElements(By.tagName("li"));
            if (type.contains(",")) {
                types = type.split(",");
            } else {
                types = new String[]{type};
            }

            for (WebElement typeElement : typeList) {
                for (String aType : types) {
                    if (typeElement.getText().equals(aType.trim())) {
                        if (!typeElement.getAttribute("class").contains("selected")) {
                            typeElement.click();
                        }
                        break;
                    }
                }
            }
        }

        if (lobby != null) {
            waitFewSecond(1000);
            List<WebElement> lobbyList = form.findElement(By.id("lobbylist")).findElements(By.tagName("li"));
            for (WebElement typeElement : lobbyList) {
                if (typeElement.getText().equals(lobby)) {
                    typeElement.click();
                    break;
                }
            }
        }

        if (region != null) {
            waitFewSecond(1000);
            List<WebElement> regionList = form.findElement(By.id("regionlist")).findElements(By.tagName("li"));
            for (WebElement regionElement : regionList) {
                if (regionElement.getText().equals(region)) {
                    regionElement.click();
                    break;
                }
            }
        }
    }

    @Step("Ставится галочка Только точную фразу в расширенном поиске ")
    public P clickOnExactPhraseOnExtendedSearchForm() {
        WebElement exactPhrase = waitForPresenceOfElementLocatedBy(By.xpath("//*[@for='exactPhrase']"), "Элемент 'Только точную фразу' не виден в расширенном поиске");
        exactPhrase.click();
        return (P) this;
    }

    @Step("Ставится переключатель В судебной практике в расширенном поиске ")
    public P switchOnInLawPracticeOnExtendedSearchForm() {
        WebElement switcherInLaw = waitForPresenceOfElementLocatedBy(By.cssSelector(".in-practice"), "Элемент 'В судебной практике' не виден в расширенном поиске");
        switcherInLaw.click();
        return (P) this;

    }

    @Step("Ставится переключатель В законодательстве в расширенном поиске ")
    public P switchOnInLawOnExtendedSearchForm() {
        WebElement switcherInLaw = waitForPresenceOfElementLocatedBy(By.cssSelector(".in-law"), "Элемент 'В законодательстве' не виден в расширенном поиске");
        switcherInLaw.click();
        return (P) this;
    }

    @Step("Нажимается на кнопку Поиск в расширенной панели")
    public void clickOnButtonSearchOnExtendedForm() {
        WebElement switcherInLaw = waitForPresenceOfElementLocatedBy(By.id("button-search-extended"), "Кнопка 'Поиск' в расширенной панели поиска не видена ");
        switcherInLaw.click();
    }

    @Step("Проверяем результаты поиска по реквизитам")
    public void checkExtendedSearch(String type, String city, String query) {
        WebElement searchResultText = findElementByNoThrow(mainLeft, By.xpath(".//div[@class='search-result']"));
        if (searchResultText != null) {
            String h1 = searchResultText.findElement(By.tagName("h1")).getText().toLowerCase();
            String text = searchResultText.findElement(By.cssSelector(".search-extended-string")).getText().toLowerCase();
            String text2 = "вид — «" + type.toLowerCase() + "», регион — «" + city.toLowerCase() + "»";
            postponedAssertEquals(h1, "результаты поиска по реквизитам: «" + query.toLowerCase() + "»", "Не совпадает текст запроса:" + h1 + " Ожидалось:" + "«" + query + "»");
            postponedAssertEquals(text, text2, "Не совпадает текст запроса:" + text + "Ожидалось: " + text2);
            WebElement regionFilter = findElementBy(By.cssSelector("[data-filtr-name='region']"));
            WebElement activeRegionFilter = findElementByNoThrow(regionFilter, By.xpath(".//*[contains(@class, 'btn_state_active')]"));
            postponedAssertNotNull(activeRegionFilter, "Не один фильтр региона не выбран");
            if (activeRegionFilter != null){
                postponedAssertEquals(activeRegionFilter.findElement(By.xpath(".//..")).getAttribute("data-param"), "77", "Сбросился фильтр региона");
            }
        }
    }

    @Step("Проверяется сбрасывание реквизитов расширенного поиска")
    public void checkExtendedSearchRemoveAllFilters() {
        WebElement searchResultText = findElementByNoThrow(mainLeft, By.cssSelector(".search-extended-string"));
        if (searchResultText == null) {
            postponedAssertNull(searchResultText, "Реквизиты расширенного поиска не сброшены");
        } else {
            if (!searchResultText.getText().equals("") && !searchResultText.getText().contains("50")) {
                //Найдено более 50 документов. Попробуйте уточнить запрос
                setPostponedTestFail("Реквизиты расширенного поиска не сброшены");
            }
        }
    }

    @Step("Проверяется исправление опечатки поискового запроса")
    public SearchResultHelper checkErrataInSearchQuery(String queryTrue, String queryFalse) {
        WebElement headSearch = findElementBy(mainLeft, By.xpath(".//div[@class='search-result']"), "Результаты поиска не отображаются");
        String h1Text = headSearch.findElement(By.tagName("h1")).getText().toLowerCase();
        String expectedH1Text = "показаны результаты по запросу «" + queryTrue + "»";
        postponedAssertEquals(h1Text, expectedH1Text, "Результат поиска:" + h1Text + " Не совпадает с ожидаемым: " + expectedH1Text);

        String pText = headSearch.findElement(By.tagName("p")).getText().toLowerCase();
        String expectedPText = "искать вместо этого «" + queryFalse.toLowerCase() + "»";
        postponedAssertEquals(pText, expectedPText, "Не совпадает тест " + pText + " ожидаемым: " + expectedPText);

        postponedAssertEquals(searchBox.getText().toLowerCase(), queryTrue.toLowerCase(), "Опечатка не исправилась.");
        return this;
    }

    @Step("Проверяется исправление раскладки поискового запроса")
    public SearchResultHelper checkKeyboardLayoutInSearchQuery(String queryTrue, String queryFalse) {
        WebElement headSearch = findElementBy(mainLeft, By.xpath(".//div[@class='search-result']"), "Результаты поиска не отображаются");
        String h1Text = headSearch.findElement(By.tagName("h1")).getText().toLowerCase();
        String expectedH1Text = "показаны результаты по запросу «" + queryTrue + "»";
        postponedAssertEquals(h1Text, expectedH1Text, "Результат посика:" + h1Text + " Не совспадает с ожидаемым: " + expectedH1Text);

        String pText = headSearch.findElement(By.tagName("p")).getText().toLowerCase();
        String expectedPText = "в запросе «" + queryFalse.toLowerCase() + "» исправлена раскладка клавиатуры.";
        postponedAssertEquals(pText, expectedPText, "Не совпадает тест " + pText + " ожидаемым: " + expectedPText);

        postponedAssertEquals(searchBox.getText().toLowerCase(), queryTrue.toLowerCase(), "Опечатка не исправилась.");
        return this;
    }

    @Step("Нажать на ссылку исходного неисправленного запроса")
    public void clickNoFixLink() {
        WebElement link = findElementByNoThrow(By.xpath(".//a[@class='no-fix-link']"));
        if (link != null) {
            link.click();
        } else {
            postponedAssertTrue(false, "Ссылка на поиск по неисправленному запросу не найден");
        }
    }

    @Step("Проверяется что результаты поиска не отображаются")
    public void checkSearchResultIsNotPresent() {
        WebElement p = findElementByNoThrow(By.xpath("#main-left .search-result .search-extended-string"));
        if (p != null) {
            String text = p.getText();
            postponedAssertTrue(text.contains("не найдено"), "Открылась не та страница, ожидалась страница без результатов поиска");
        } else {
            postponedAssertTrue(false, "Не найден текст не найдено, возможно ошибка в локаторе?");
        }
    }

    @Step("Проверяется исправление опечатки поискового запроса при использовании фильтра 'Статус документа'")
    public void checkErrataInSearchQueryAndFilter(String queryTrue, String queryFalse) {
        checkErrataInSearchQuery(queryTrue, queryFalse);
        clickActualStatusInFilter();
        checkErrataInSearchQuery(queryTrue, queryFalse);
    }

    @Step("Проверяется исправление опечатки поискового запроса при использовании фильтра 'Разделы'")
    public void checkErrataInSearchQuerySwitchSection(String queryTrue, String queryFalse) {
        clickDictionaryFilter();
        checkErrataInSearchQuery(queryTrue, queryFalse);
    }

    @Step("Проверяется форма 'Документ за час'")
    public void checkPresentFormsDocumentForHour() {
        String text = mainLeftElement.findElement(By.xpath(".//div/div/p[2]")).getText();
        String trueText = "Или вы можете просто отправить нам сообщение. Мы найдём документ и пришлем вам ссылку по электронной почте в течение часа (сервис работает с 9 до 18 по московскому времени).";
        postponedAssertEquals(text, trueText, "Ожидался текст: " + trueText);
        WebElement form = findElementBy(By.id("widget-user-request")).findElement(By.xpath(".//div/form"));
        if (form != null) {
            postponedAssertTrue(form.isDisplayed(), "Не отображается форма 'Докумен за час'");

            WebElement nameElement = form.findElement(By.xpath(".//div[1]"));
            postponedAssertEquals(nameElement.findElement(By.tagName("label")).getText(), "Ваше имя", "'Ваше имя' не найдено");
            String name = nameElement.findElement(By.tagName("input")).getAttribute("value");
            postponedAssertTrue(name != null && !name.equals("none"), "'Ваше имя' не заполено по умолчанию");

            WebElement emailElement = form.findElement(By.xpath(".//div[2]"));
            postponedAssertEquals(emailElement.findElement(By.tagName("label")).getText(), "Адрес электронной почты", "'Адрес электронной почты' не найдено");
            String email = emailElement.findElement(By.tagName("input")).getAttribute("value");
            postponedAssertTrue(email != null && !email.equals("none"), "'Ваше имя' не заполено по умолчанию");

            WebElement infoElement = form.findElement(By.cssSelector("[for*='info']"));
            postponedAssertTrue(infoElement.getText().contains("Сообщите дополнительную информацию"), "'Сообщите дополнительную информацию..' не найдено");
        }
    }

    @Step("Ввести имя в форме 'Документ за час'")
    public void inputEmailInDocumentForHourForm(String text) {
        WebElement email = findElementByNoThrow(mainLeftElement, By.id("email"));
        if (email != null) {
            email.clear();
            email.sendKeys(text);
        } else {
            setPostponedTestFail("Поле 'Почта' не найдено");
        }
    }

    @Step("Ввести почта в форме 'Документ за час'")
    public void inputNameInDocumentForHourForm(String text) {
        WebElement name = findElementByNoThrow(mainLeftElement, By.id("name"));
        if (name != null) {
            name.clear();
            name.sendKeys(text);
        } else {
            setPostponedTestFail("Поле 'Имя' не найдено");
        }
    }

    @Step("Ввести комментарий в форме 'Документ за час'")
    public void inputCommentInDocumentForHourForm(String text) {
        WebElement comment = findElementByNoThrow(mainLeftElement, By.id("info"));
        if (comment != null) {
            comment.clear();
            comment.sendKeys(text);
        } else {
            setPostponedTestFail("Поле 'Комментарий' не найдено");
        }
    }

    @Step("Нажать кнопку 'Отправить' в форме 'Документ за час'")
    public void clickSendButtonInDocumentForHourForm() {
        WebElement sendButton = findElementByNoThrow(mainLeftElement, By.id("button-send"));
        if (sendButton != null) {
            sendButton.click();
            waitForReloadingPage();
        } else {
            setPostponedTestFail("Кнопка 'Отправить' не найдена");
        }
    }

    @Step("Проверяется текст ошибки 'Введите почту' в форме 'Документ за час'")
    public void checkEmailErrorInDocumentForHourForm(String textError) {
        WebElement emailError = findElementByNoThrow(mainLeftElement, By.id("email-error"));
        if (emailError != null) {
            postponedAssertTrue(emailError.isDisplayed(), "Сообщение 'Введите почту' не отображается");
            postponedAssertEquals(emailError.getText(), textError, "Неправильный текс сообщения");
        } else {
            setPostponedTestFail("Сообщение '" + textError + "' не отображается");
        }
    }

    @Step("Проверяется текст ошибки 'Введите почту' в форме 'Документ за час'")
    public void checkNameErrorInDocumentForHourForm(String expectedText) {
        WebElement nameError = findElementByNoThrow(By.id("name-error"));
        if (nameError != null) {
            postponedAssertTrue(nameError.isDisplayed(), "Сообщение 'Введите имя' не отображается");
            postponedAssertEquals(nameError.getText(), expectedText, "Неправильный текс сообщения");
        } else {
            setPostponedTestFail("Сообщение 'Введите имя' не отображается");
        }
    }

    @Step("Нажать ссылку 'Вернуться в правовую базу'")
    public void clickLinkNavigateToLawPageLink() {
        WebElement link = findElementByNoThrow(mainLeftElement, By.tagName("a"));
        if (link != null) {
            link.click();
        } else {
            setPostponedTestFail("Ссылка 'Вернуться в правовую базу' не найдена");
        }
    }

    @Step("Проверяется отображения сообщения об успешном запросе на документ")
    public void checkInputCorrectlyFormsDocumentForHour() {
        postponedAssertTrue(mainLeftElement.findElement(By.tagName("h1")).getText().contains("Спасибо!"), "Не появилось окно сообщающее об успешкой отправке");
        postponedAssertTrue(mainLeftElement.findElement(By.tagName("p")).getText().contains("Мы получили ваш вопрос"), "Не появилась надпись 'Мы получили ваш вопрос...'");
    }

    @Step("Проверяется, что не отображается форма Документ за час для не зарегестрированного пользователя")
    public void checkNotPresentFormsDocumentHouse() {
        postponedAssertNull(findElementByNoThrow(By.id("widget-user-request")), "Отображается форма документ за час для незарегестрированного пользователя");
    }

    @Step("Проверяется отображение строки 'Результаты поиска по реквизитам...'")
    public void checkDisplaySearchResultsForDetails(String query) {
        WebElement title = findElementByNoThrow(mainLeft, By.xpath(".//div/h1"));
        if (title != null) {
            postponedAssertTrue(title.isDisplayed(), "'Результаты поиска по реквизитам' не отображаются");
            postponedAssertEqualsText(title, "Результаты поиска по реквизитам: «" + query + "»");
        } else {
            setPostponedTestFail("Не найдне элемент 'Результаты поиска по реквизитам'");
        }
    }

    @Step("Проверяется отображение фильтра по Виду")
    public void checkDisplayingSelectedTypeFilters(String type) {
        List<WebElement> texts = findElementsBy(mainLeft, By.xpath(".//div/div[@class='search-extended-string']"));
        if (texts != null) {
            String text = texts.get(0).getText();
            postponedAssertTrue(text.contains("Вид"), "Фильтр не соответсвует выбранному");
            postponedAssertTrue(text.contains(type), "Фильтр не соответсвует выбранному:" + text);
        } else {
            setPostponedTestFail("Не найдне фильтр'");
        }
    }

    @Step("Проверяется отображение фильтра по Региону")
    public void checkDisplayingSelectedRegionFilters(String region) {
        List<WebElement> texts = findElementsBy(mainLeft, By.xpath(".//div/div[@class='search-extended-string']"));
        if (texts != null) {
            String text = texts.get(0).getText();
            postponedAssertTrue(text.contains("регион"), "Фильтр 'регион' не найден");
            postponedAssertTrue(text.contains(region), "Фильтр не соответсвует выбранному:" + text);
        } else {
            setPostponedTestFail("Не найден фильтр'");
        }
    }

    @Step("Проверяется отображение текста при запросе без результатов")
    public void checkDisplayingText(boolean isAuthorized) {
        List<WebElement> texts = findElementsBy(mainLeft, By.xpath(".//div/div[@class='search-extended-string']"));
        if (texts.size() == 2) {
            WebElement text1 = texts.get(1).findElement(By.xpath(".//p[1]"));
            WebElement text2 = texts.get(1).findElement(By.xpath(".//p[2]"));
            postponedAssertEqualsText(text1, "Ничего не найдено, пожалуйста, уточните реквизиты.");
            if (isAuthorized) {
                postponedAssertEqualsText(text2, "Или вы можете просто отправить нам сообщение. Мы найдём документ и пришлем вам ссылку по электронной почте в течение часа (сервис работает с 9 до 18 по московскому времени).");
            } else {
                postponedAssertEqualsText(text2, "Возможно, документ не включен в базу данных. Мы будем благодарны, если вы сообщите нам о том, что он необходим — tp@1gl.ru. Документ будет предоставлен вам в одном из ближайших обновлений.");
            }
        } else {
            setPostponedTestFail("Не найден элемент'");
        }
    }

    @Step("Проверяется работа ссылок в фильтре По архиву")
    public void checkLinksArchiveFilter() {
        String age;
        if (getSettings().isRunBss()) {
            age = "два";
        } else {
            age = "три";
        }
        String[] expectedFilterValues = new String[]{"Весь архив", "Последние " + age + " года", "Последние " + age + " месяца"};
        List<WebElement> searchResultLinkList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются");
        if (expectedFilterValues != null) {
            for (String filterName : expectedFilterValues) {
                WebElement filter = waitForVisibilityOfElementLocatedBy(By.xpath("//*[text()='Весь архив']/../../.."), "Не найден фильтр по темам");
                WebElement topic = filter.findElement(By.xpath(".//u[text()='" + filterName + "']"));
                topic.click();
                waitForReloadingPage();
                postponedAssertFalse(searchResultLinkList.equals(waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются")), "Поисковая выдача не изменилась");
            }
        }
    }

    @Step("Проверяется работа ссылок в фильтре По типу документов")
    public void checkLinksTypeDocumentFilter() {
        String[] expectedFilterValues = getListTypeDocuments();
        checkLinkInFilters(expectedFilterValues, "По типу документов");
    }

    @Step("Проверяется работа ссылок в фильтре По изданиям")
    public void checkLinksMagazinesFilter() {
        String[] expectedFilterValues = getListMagazines();
        List<WebElement> searchResultLinkList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются");
        if (expectedFilterValues != null) {
            for (int i = 1; i < expectedFilterValues.length; i++) {
                WebElement filter = waitForVisibilityOfElementLocatedBy(By.xpath("//*[text()='Все издания']/../../.."), "Не найден фильтр 'По изданиям'");
                WebElement topic = filter.findElement(By.xpath(".//u[text()='" + expectedFilterValues[i] + "']"));
                int tagNumber = Integer.parseInt(topic.findElement(By.xpath("..")).findElement(By.xpath("..")).getAttribute("data-param"));
                topic.click();
                waitForReloadingPage();
                postponedAssertTrue(getCurrentUrl().contains(tagNumber + "/"), "Не корректный URL");
                postponedAssertFalse(searchResultLinkList.equals(waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются")), "Поисковая выдача не изменилась");
            }
        }
    }

    @Step("Проверяется работа ссылок в фильтре По видео")
    public void checkLinksVideoFilter() {
        String[] expectedFilterValues = FSS_VIDEO_FILTER;
        checkLinkInFilters(expectedFilterValues, "По видео");
    }

    private void checkLinkInFilters(String[] expectedFilterValues, final String filterName) {
        List<WebElement> searchResultLinkList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются");
        if (expectedFilterValues != null) {
            for (int i = 1; i < expectedFilterValues.length; i++) {
                WebElement filter = waitForVisibilityOfElementLocatedBy(By.xpath("//*[@data-filtr-name='tags'][1]"), "Не найден фильтр " + filterName);
                WebElement topic = filter.findElement(By.xpath(".//u[text()='" + expectedFilterValues[i] + "']"));
                int tagNumber = Integer.parseInt(topic.findElement(By.xpath("..")).findElement(By.xpath("..")).getAttribute("data-param"));
                topic.click();
                waitForReloadingPage();
                postponedAssertTrue(getCurrentUrl().contains(String.valueOf(tagNumber)), "Не корректный URL");
                postponedAssertFalse(searchResultLinkList.equals(waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются")), "Поисковая выдача не изменилась");
            }
        }
    }

    @Step("Проверяется отобдражение выборки по соответвию")
    public void checkRelevanceFilter() {
        List<WebElement> searchResultLinkList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются");
        clickRelevanceSortedFilter();
        postponedAssertFalse(searchResultLinkList.equals(waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются")), "Поисковая выдача не изменилась");
    }

    @Step("Проверяется отобдражение выборки по московскому региону")
    public void checkMoscowRegionFilter() {
        List<WebElement> searchResultLinkList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются");
        clickSecondRegionFilter();
        List<WebElement> widgetHeaders = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются");
        postponedAssertFalse(searchResultLinkList.equals(widgetHeaders), "Поисковая выдача не изменилась");

        for (WebElement widgetHeader : widgetHeaders) {
            WebElement span = findElementByNoThrow(widgetHeader, By.tagName("span"));
            if (span != null) {
                String text = span.getText();
                postponedAssertTrue(text.contains("МОСКВ") || text.contains(" МО ") || text.contains("МОСГОР"), "Документ не из 'Москвы' или 'Московского региона' Регон докумета: " + text);
            } else
                setPostponedTestFail("Не указан регион докумета");
        }
    }

    @Step("Проверяется отобдражение выборки по калининградской области")
    public void checkRegionInSearchHeader(String partRegionName, final int regionId) {
        List<WebElement> searchResultLinkList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются");
        clickSecondRegionFilter();
        List<WebElement> widgetHeaders = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Не найдены результаты поисковой выдачи");
        postponedAssertFalse(searchResultLinkList.equals(widgetHeaders), "Поисковая выдача не изменилась");

        for (WebElement widgetHeader : widgetHeaders) {
            if (!widgetHeader.isDisplayed()) {
                continue;
            }
            WebElement span = findElementByNoThrow(widgetHeader, By.tagName("span"));
            if (span != null) {
                String text = span.getText().toLowerCase();
                postponedAssertTrue(text.contains(partRegionName), "Документ не из того региона. Регион докумета: " + text);
            } else {
                setPostponedTestFail("Не указан регион докумета");
            }
        }

        postponedAssertTrue(getCurrentUrl().contains("region=" + regionId), "Регион в URL не 125: " + getCurrentUrl());
    }

    @Step("В строке поиска по фильтрам на странице результатов не присутствует фильтрация по региону")
    public void checkRegionFilterInSearchExtendedStringIsNotPresent() {
        WebElement extendedRegionString = findElementByNoThrow(By.xpath("//*[@id='main-left']//div[@class='search-extended-string'][1]"));
        if (extendedRegionString == null) {
            postponedAssertNull(extendedRegionString, "Поиск по региону не производится");
        } else {
            String text = extendedRegionString.getText();
            postponedAssertFalse(text.contains("Регион"), "Поиск произведен по региону");
        }
    }

    @Step("В строке поиска по фильтрам на странице результатов присутствует фильтрация по региону")
    public void checkRegionFilterInSearchExtendedStringIsPresent() {
        WebElement extendedRegionString = findElementByNoThrow(By.xpath("//*[@id='main-left']//div[@class='search-extended-string'][1]"));
        if (extendedRegionString == null) {
            setPostponedTestFail("Поиск по региону не производится");
        } else {
            String text = extendedRegionString.getText();
            postponedAssertTrue(text.contains("Регион"), "Поиск произведен по региону");
        }
    }

    @Step("Проверяется отобдражение выборки по всем регионам")
    public void checkAllRegionFilter() {
        List<WebElement> searchResultLinkList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются");
        clickAllRegionFilter();
        postponedAssertFalse(searchResultLinkList.equals(waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются")), "Поисковая выдача не изменилась");
    }

    @Step("Нажать переключатель 'В судебной практике' и не ожидать появления результатов поиска")
    public void clickInLawPracticeLinkFilterAndDoNotWaitSearchResult() {
        WebElement lawPracticeButton = waitForPresenceOfElementLocatedBy(By.cssSelector("#main-container .law-practice-switch .link-practice"), "Переключатель 'В судебной практике' не найден");
        if (lawPracticeButton != null) {
            lawPracticeButton.click();
            waitForReloadingPage();
        }
    }

    @Step("Нажать переключатель 'В судебной практике' и ожидать появления результатов поиска")
    public void clickInLawPracticeLinkFilter() {
        clickInLawPracticeLinkFilterAndDoNotWaitSearchResult();
        waitForSearchResult();
    }

    @Step("Нажать переключатель 'В законодательстве'")
    public void clickInLawLinkFilter() {
        clickInLawLinkFilterAndDoNotWaitSearchResult();
        waitForSearchResult();
    }

    @Step("Нажать переключатель 'В законодательстве' и не ожидать появления результатов поиска")
    public void clickInLawLinkFilterAndDoNotWaitSearchResult() {
        WebElement lawButton = findElementByNoThrow(mainContentElement, By.cssSelector(".law-practice-switch .link-law"));
        postponedAssertNotNull(lawButton, "Переключатель 'В законодательстве' не найден");
        if (lawButton != null) {
            lawButton.click();
            waitForReloadingPage();
        }
    }

    @Step("Проверяется что кнопки-переключатели 'В законодательств'/'В судебной практике' отображаются")
    public void checkInLawAndInPracticeFilterIsPresent() {
        WebElement lawFilters = findElementByNoThrow(mainContentElement, By.cssSelector(".law-practice-switch"));
        postponedAssertNotNull(lawFilters, "Отсутсвуют кнопки-переключатели 'В законодательстве' и 'В судебной практике'");
        if (lawFilters != null) {
            WebElement law = findElementByNoThrow(lawFilters, By.cssSelector(".link-law"));
            WebElement practice = findElementByNoThrow(lawFilters, By.cssSelector(".link-practice"));
            postponedAssertNotNull(law, "Отсутствует переключатель 'В законодательстве'");
            postponedAssertNotNull(practice, "Отсутствует переключатель 'В судебной практике'");
        }
    }

    @Step("Проверяется что в главном меню выбрана страница")
    public void checkTabIsSelected(MainMenuButtons menuButton) {
        String actualItemName = waitForPresenceOfElementLocatedBy(By.cssSelector(".btn_state_active"), "Не один раздел не выбран в главном меню").getText();
        postponedAssertEquals(actualItemName.toLowerCase(), menuButton.getName().toLowerCase(), "Выбран неправильный раздел в главном меню");
    }

    @Step("Проверяется что чекбокс 'Искать в найденом' отображается")
    public void checkSearchInResultCheckBoxIsPresent() {
        waitForSearchResult();
        WebElement searchForm = waitForVisibilityOfElementLocatedBy(By.id("search-form"), "Форма 'Искать в найденом' не отображается");
        WebElement searchInSearchResultsCheckbox = findElementByNoThrow(searchForm, By.name("holdreq"));
        postponedAssertTrue(searchInSearchResultsCheckbox != null && getParentElement(searchInSearchResultsCheckbox).isDisplayed(), "Чекбокс 'искать в найденном' не отображается");
    }

    @Step("Проверяется что чекбокс 'Искать в найденом' не отображается")
    public void checkSearchInResultCheckBoxIsNotPresent() {
        WebElement searchForm = waitForVisibilityOfElementLocatedBy(By.id("search-form"), "Форма 'Искать в найденом' не отображается");
        WebElement searchInSearchResultsCheckbox = findElementByNoThrow(searchForm, By.name("holdreq"));
        postponedAssertTrue(searchInSearchResultsCheckbox == null || !getParentElement(searchInSearchResultsCheckbox).isDisplayed(), "Чекбокс 'искать в найденном' отображается");
    }

    @Step("Проверяется что чекбокс 'искать в найденном' не выбран")
    public void checkSearchInResultCheckboxIsNoSelected() {
        WebElement searchForm = waitForVisibilityOfElementLocatedBy(By.id("search-form"), "Форма 'Искать в найденом' не отображается");
        WebElement searchInSearchResultsCheckbox = findElementByNoThrow(searchForm, By.name("holdreq"));
        if (searchInSearchResultsCheckbox != null) {
            postponedAssertTrue(searchInSearchResultsCheckbox.isEnabled(), "чекбокс 'искать в найденном' не активен");
            postponedAssertFalse(searchInSearchResultsCheckbox.isSelected(), "чекбокс 'искать в найденном' выбран");
        }
    }

    @Step("Кликаем на чекбокс 'Искать в найдном'")
    public void clickSearchInResultCheckBox() {
        WebElement searchForm = waitForVisibilityOfElementLocatedBy(By.id("search-form"), "Форма 'Искать в найденом' не отображается");
        WebElement searchInSearchResultsCheckbox = findElementByNoThrow(searchForm, By.name("holdreq"));
        if (searchInSearchResultsCheckbox != null) {
            if (!searchInSearchResultsCheckbox.isSelected()) {
                getParentElement(searchInSearchResultsCheckbox).click();
            }
        }
    }

    @Step("Проверяется заголовок результатов поиска")
    public void checkSearchTitle(String expectedTitle) {
        WebElement searchTitle = waitForPresenceOfElementLocatedBy(By.cssSelector(".search-result h1"), "Заголовок результатов поиска с параметрами поиска не найдена");
        postponedAssertEquals(searchTitle.getText(), "«" + expectedTitle + "»", "Неправильный текст в заголовке результатов поиска");
    }

    @Step("Проверяется строка с параметрами поиска")
    public void checkExtendedSearchString(String expectedString) {
        WebElement searchTitle = waitForPresenceOfElementLocatedBy(By.cssSelector(".search-extended-string"), "Строка с параметрами поиска не найдена");
        postponedAssertEquals(searchTitle.getText(), expectedString, "Неправильный текст в строка с параметрами поиска");
    }

    @Step("Проверяется вхождение строки в статусе расширенного поиска")
    public void checkExtendedSearchStringContains(String expectedString) {
        waitForPresenceOfElementLocatedBy(By.cssSelector(".search-extended-string"), "Строка с параметрами поиска не найдена");
        List<WebElement> searchTitle = findElementsBy(By.cssSelector(".search-extended-string"), "Строка с параметрами поиска не найдена");
        String extendedSearchString = "";
        if (searchTitle.size() > 1) {
            Iterator iterator = searchTitle.iterator();
            while (iterator.hasNext()) {
                WebElement nextElement = (WebElement) iterator.next();
                extendedSearchString += nextElement.getText();
            }
        } else {
            extendedSearchString = searchTitle.get(0).getText();
        }
        postponedAssertTrue(extendedSearchString.contains(expectedString), "Неправильный текст в строка с параметрами " +
                "поиска. Ищется строка:" + expectedString + " в строке:" + extendedSearchString);
    }

    @Step("Проверяется фильтр 'Решения судов'")
    public void checkLawPracticeFilter() {
        WebElement lawPracticeFilter = waitForVisibilityOfElementLocatedBy(By.cssSelector("[data-current-filtr-state='420']"), "Не найден фильтр 'Решения судов'");
        List<WebElement> statusFilterValues = lawPracticeFilter.findElements(By.tagName("li"));
        postponedAssertEquals(statusFilterValues.get(0).getText(), "Решения судов", "Неправильное значения для фильтра 'Решения судов'");
        postponedAssertEquals(statusFilterValues.get(1).getText(), "Высших", "Неправильное значения для фильтра 'Решения судов'");
        postponedAssertEquals(statusFilterValues.get(2).getText(), "Пленумов", "Неправильное значения для фильтра 'Решения судов'");
        postponedAssertEquals(statusFilterValues.get(3).getText(), "Окружных", "Неправильное значения для фильтра 'Решения судов'");
        postponedAssertEquals(statusFilterValues.get(4).getText(), "Апелляционных", "Неправильное значения для фильтра 'Решения судов'");
        postponedAssertEquals(statusFilterValues.get(0).getText(), "Решения судов", "Выбран не тот фильтр 'Решения судов' по умолчанию");
    }

    private void checkSearchWidgetByTypeIsNotEmpty(By widgetLocator, String widgetName) {
        waitForSearchResult();
        WebElement widget = findElementByNoThrow(mainContentElement, widgetLocator);
        if (widget != null) {
            postponedAssertTrue(widget.isDisplayed(), "Блок '" + widgetName + "' не отображается в результатх поиска");
            List<WebElement> links = widget.findElements(By.cssSelector(".widget-list a"));
            WebElement widgetText = widget.findElement(By.cssSelector(".widget-list"));
            postponedAssertFalse(links.isEmpty() && widgetText.getText().isEmpty(), "Блок '" + widgetName + "' пустой");
        }
    }

    @Step("Проверяется блок результатов")
    public P checkSearchBlockResult(int blockNumber, int countResult) {
        List<WebElement> blockItems = findElementsBy(By.xpath("//*[@id='searchResultsSection']/div[(contains(@class,'widget_content_references'))][" + blockNumber + "]//h3"));
        int actualResults = blockItems.size();
        postponedAssertEquals(actualResults, countResult, "В " + blockNumber + "ом блоке результатов ожидалось " + countResult +
                " результатов, но было найдено " + actualResults + " результатов.");
        lastBlock++;
        return (P) this;
    }

    @Step("Проверяется первый блок результатов")
    public P checkSearchFirstBlockResult(int countResult) {
        List<WebElement> firstBlockItems = findElementsBy(By.xpath("//*[@id='searchResultsSection']/div[1]//h3"));
        int actualResults = firstBlockItems.size();
        postponedAssertEquals(actualResults, countResult, "В первом блоке результатов ожидалось " + countResult +
                " результатов, но было найжено " + actualResults + " результатов.");
        lastBlock++;
        return (P) this;
    }

    @Step("Проверяется что в результатах поиска есть колдунщики")
    public P checkWidgetContentAnyTypeArePresent(int minNotReferencesForms, int maxSearchResultsForAnyForms) {
        //поиск колдунщиков на странице
        List<WebElement> notReferencesWidgets = findElementsBy(
                By.xpath("//*[@id='searchResultsSection']/div[(not(contains(@class,'widget_content_references'))and(not(contains(@class,'widget__'))))]"));
        postponedAssertFalse(notReferencesWidgets.isEmpty(), "Колдунщики на странице не найдены");
        int notReferencesWidgetsSize = notReferencesWidgets.size();
        postponedAssertTrue(notReferencesWidgetsSize >= minNotReferencesForms, "Количество колдунщиков на странице:" +
                notReferencesWidgetsSize + " , но должно быть больше:" + minNotReferencesForms);
        //поиск количества результатов поиска в каждом колдунщике
        for (int i = 0; i < notReferencesWidgetsSize; i++) {
            WebElement notReferencesWidget = notReferencesWidgets.get(i);
            //если колдунщик форм или справочник
            if (notReferencesWidget.getAttribute("class").contains("widget-forms") ||
                    (notReferencesWidget.getAttribute("class").contains("widget-handbook"))) {
                int linkCountIntoWidget = notReferencesWidgets.get(i).findElements(By.xpath(".//li")).size();
                postponedAssertTrue(linkCountIntoWidget <= maxSearchResultsForAnyForms, "В " + i + "ом виджете колдунщика " +
                        " Форм " + linkCountIntoWidget + " результатов поиска, а должно быть не больше " +
                        maxSearchResultsForAnyForms);
            } else {
                //если колдуншик видео
                if (notReferencesWidget.getAttribute("class").contains("widget-videos")) {
                    int linkCountIntoWidget = notReferencesWidgets.get(i).findElements(By.xpath(".//*[@class='videos-rim']")).size();
                    postponedAssertTrue(linkCountIntoWidget <= maxSearchResultsForAnyForms, "В " + i + "ом виджете колдунщика " +
                            " Форм " + linkCountIntoWidget + " результатов поиска, а должно быть не больше " +
                            maxSearchResultsForAnyForms);
                } else {
                    postponedAssertTrue(false, "На странице отображен неизвестный колдунщик!");
                }
            }
        }
        return (P) this;
    }


    /**
     * Uses after scrollToEnd method!
     */
    @Step("Проверяется частичная подгрузка блоков результатов поиска")
    public P checkSearchPartLoadedBlocksResult(int countResult) {
        int lastBlock = this.lastBlock;

        int allBlocksCount = getCountResultBlocksInSearchResultPage();
//        postponedAssertTrue(allBlocksCount > lastBlock, "Блоки частичной подгрузки результатов поиска не появились на странице!" +
//                " Возможно не был сделан скролл страницы?");

        for (int i = lastBlock + 1; i < allBlocksCount - 1; i++) {
            checkSearchBlockResult(i, countResult);
        }
        this.lastBlock = 0;
        return (P) this;
    }

    /**
     * Uses after scrollToEnd method!
     */
    @Step("Проверяется последний блок результатов поиска")
    public P checkSearchLastBlockResult(int maxCountResult) {
        int lastBlock = getCountResultBlocksInSearchResultPage();
        checkSearchBlockResultNotMoreThan(maxCountResult, lastBlock);
        return (P) this;
    }

    private int getCountResultBlocksInSearchResultPage() {
        List<WebElement> blockItems = findElementsBy(By.xpath("//*[@id='searchResultsSection']/div[(contains(@class,'widget_content_references'))]"));
        return blockItems.size();
    }

    private void checkSearchBlockResultNotMoreThan(int maxCountResult, int blockNumber) {
        List<WebElement> blockItems = findElementsBy(By.xpath("//*[@id='searchResultsSection']/div[(contains(@class,'widget_content_references'))][" + blockNumber + "]//h3"));
        int actualResults = blockItems.size();
        postponedAssertTrue(actualResults <= maxCountResult, "В " + blockNumber + "ом блоке результатов ожидалось не более" +
                maxCountResult + " результатов, но было найдено " + actualResults + " результатов.");
        lastBlock++;
    }

    @Step("Проверяется блок до кнопки Показать еще результаты")
    public P checkSearchResultBeforeShowMoreButton(int blockNumber, int maxCount) {
        List<WebElement> blockItems = findElementsBy(By.xpath("//*[@id='searchResultsSection']/div[(contains(@class,'widget_content_references'))][" + blockNumber + "]//h3"));
        int actualResults = blockItems.size();
        postponedAssertTrue(actualResults <= maxCount, "В " + blockNumber + "ом блоке результатов ожидалось не более" +
                maxCount + " результатов, но было найдено " + actualResults + " результатов. (До кнопки Показать " +
                "еще результаты");
        lastBlock++;
        m = actualResults;
        return (P) this;
    }

    @Step("Проверяется блок после кнопки Показать еще результаты")
    public P checkSearchResultAfterShowMoreButton(int blockNumber, int maxCount) {
        checkSearchBlockResult(blockNumber, maxCount - m);
        return (P) this;
    }

    @Step("Нажать кнопку Показать еще результаты")
    public P clickShowMoreButton() {
        WebElement buttonShowMore = findElementBy(By.cssSelector(".widget__clipping-button"));
        buttonShowMore.click();
        waitForInvisibilityOfElementLocatedBy(buttonShowMore);
        return (P) this;
    }

    @Step("Проверяется что открыта стартовая страница раздела")
    public void checkMainLawBasePageIsOpened() {
        WebElement mainTitle = findElementByNoThrow(By.cssSelector(".main__title"));
        postponedAssertTrue(mainTitle.isDisplayed(), "Не отображается заголовок стартовой страницы раздела");
        postponedAssertFalse(getCurrentUrl().contains("found"), "В строке URL найден аттрибут found");
    }

    @Step("Проверяется состав фильтра По судебным актам")
    public void checkJudicialActsFilter() {
        WebElement judicialActsFilter;
        judicialActsFilter = waitForVisibilityOfElementLocatedBy(By.cssSelector("[data-filtr-name='tags']"), "Не найден фильтр по судебным актам");
        List<WebElement> judicialFilterValues = judicialActsFilter.findElements(By.tagName("li"));
        List<WebElement> actualFilterValues = new ArrayList<WebElement>();
        for (WebElement judicialFilter : judicialFilterValues) {
            if (judicialFilter.isDisplayed() && !judicialFilter.getText().isEmpty()) {
                actualFilterValues.add(judicialFilter);
            }
        }

        List<String> expectedFilterValues;
        if (getSettings().isRunBss()) {
            expectedFilterValues = Arrays.asList(BSS_JUDICIAL_ACTS_FILTER);
        } else if (getSettings().isRunKss()) {
            expectedFilterValues = Arrays.asList(KSS_JUDICIAL_ACTS_FILTER);
        } else if (getSettings().isRunUss()) {
            expectedFilterValues = Arrays.asList(USS_JUDICIAL_ACTS_FILTER);
        } else {
            expectedFilterValues = Arrays.asList(FSS_JUDICIAL_ACTS_FILTER);
        }

        postponedAssertFalse(actualFilterValues.isEmpty(), "Фильтр по судебным актам пуст");
        String actualClassName = actualFilterValues.get(0).findElement(By.xpath("./a")).getAttribute("class");
        postponedAssertTrue(actualClassName != null && actualClassName.contains("active"), "Неправильное значение по-умолчанию фильтра по судебным актам.");
        postponedAssertEquals(expectedFilterValues.size(), actualFilterValues.size(), "Неправильное количество поисковых фильтров");
        for (int i = 0; i < expectedFilterValues.size(); i++) {
            postponedAssertEquals(actualFilterValues.get(i).getText(), expectedFilterValues.get(i), "Неправильное значения фильтра по судебным актам");
        }
    }

    @Step("Проверяется работа ссылок По судебным актам")
    public void checkLinksJudicialActsFilter() {
        List<WebElement> searchResultLinkList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются");
        WebElement judicialActsFilter = waitForVisibilityOfElementLocatedBy(By.cssSelector("[data-filtr-name='tags']"), "Не найден фильтр по судебным актам");
        List<WebElement> judicialFilterValues = judicialActsFilter.findElements(By.tagName("li"));
        for (int i = 0; i < judicialFilterValues.size(); i++) {
            WebElement topic = judicialFilterValues.get(i);
            String filterNumber = topic.getAttribute("data-param");
            topic.click();
            waitForReloadingPage();
            postponedAssertTrue(getCurrentUrl().contains("tags=" + filterNumber), "URL:" + getCurrentUrl() + " не содержит Tag:" + filterNumber);
            postponedAssertFalse(searchResultLinkList.equals(waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".widget-header"), "Результаты поиска не отображаются")), "Поисковая выдача не изменилась");
        }
    }

    @Step("Проверяется что все документы содержат нужны номер из расширенного поиска")
    public void checkSearchResultsHeadersContainDocumentNumber(String documentNumber) {
        List<SearchItem> searchItems = getSearchResultItemList();
        Iterator iterator = searchItems.iterator();
        while (iterator.hasNext()) {
            SearchItem searchItem = (SearchItem) iterator.next();
            String header = searchItem.getHeader().getText();
            postponedAssertTrue(header.contains(documentNumber), "Номер документа:" + documentNumber + " не содержится " +
                    "в заголовке документа:" + header);
        }
    }

    @Step("В поисковой выдаче разные аббревиатуры поиска")
    public void checkSearchResultsForExpersHasDifferentAbbr() {
        List<SearchItem> searchItems = getSearchResultItemList();
        Iterator iterator = searchItems.iterator();
        List<String> abbrList = new ArrayList<String>();
        while (iterator.hasNext()) {
            SearchItem searchItem = (SearchItem) iterator.next();
            String abbr = searchItem.getAbbr().getText();
            abbrList.add(abbr);
        }
        Set<String> setAbbr = new HashSet<String>();
        setAbbr.addAll(abbrList);
        abbrList.clear();
        abbrList.addAll(setAbbr);
        abbrList.removeAll(Arrays.asList(null, ""));
        postponedAssertTrue(abbrList.size() > 1, "В поисковой выдаче найдена только одна аббревиатура:"
                + abbrList.toString() + ", а должно быть несколько");
    }

    @Step("В поисковой выдаче одна аббревиатуры поиска")
    public void checkSearchResultsForExpersHasOneAbbr() {
        List<SearchItem> searchItems = getSearchResultItemList();
        Iterator iterator = searchItems.iterator();
        List<String> abbrList = new ArrayList<String>();
        while (iterator.hasNext()) {
            SearchItem searchItem = (SearchItem) iterator.next();
            String abbr = searchItem.getAbbr().getText();
            abbrList.add(abbr);
        }
        Set<String> setAbbr = new HashSet<String>();
        setAbbr.addAll(abbrList);
        abbrList.clear();
        abbrList.addAll(setAbbr);
        abbrList.removeAll(Arrays.asList(null, ""));
        postponedAssertTrue(abbrList.size() == 1, "В поисковой выдаче найдено несколько аббревиатур:"
                + abbrList.toString() + ", а должна быть одна");
    }

    public void checkSearchErrorIsNotPresent() {
        WebElement errorBlock = findElementByNoThrow(mainContentElement, By.xpath("//h1[text()='При поиске произошла техническая ошибка.']"));
        assertNull(errorBlock, "При поиске произошла техническая ошибка. Урл - " + getCurrentUrl());
    }

    @Step("Проверяется, что отображаются результаты поиска")
    public void checkSearchResultsArePresent() {
        WebElement searchResultsSection = findElementByNoThrow(By.id("searchResultsSection"));
        WebElement wrongRequest = findElementByNoThrow(By.cssSelector("#main-left .widget_type_wrong-request"));
        postponedAssertTrue(searchResultsSection != null && searchResultsSection.isDisplayed() , "Результаты поиска " +
                "не найдены");
        postponedAssertFalse(wrongRequest == null && wrongRequest.isDisplayed(), "Отображается Не нашли нужное");

    }

    @Step("Проверяется, что отображаются ссылки на документы из поисковой выдачи")
    public void checkSearchResultsContainLinksOnDocuments() {
        List<WebElement> documentsLinks = findElementsByNoThrow(By.cssSelector(".widget-header a"));
        postponedAssertTrue(documentsLinks != null && documentsLinks.size() > 0, "Не найдено ни одной ссылки среди " +
                "результатов поиска");
    }

    @Step("Проверяется, что отображается краткое содержание документов")
    public void checkSearchResultsDocumentsContainBriefTextUnderTheLinks() {
        List<WebElement> documentsBrief = findElementsByNoThrow(By.cssSelector("h3.widget-header + p.widget-text"));
        postponedAssertTrue(documentsBrief != null && documentsBrief.size() > 0, "Не найдено ни одного короткого " +
                "содержания в документе. Возможно документы не найдены");
    }

    @Step("Проверяется, что отображается количество найденных документов")
    public void checkSearchResultsExtendedStringIsPresent() {
        WebElement extendedString = findElementByNoThrow(By.cssSelector(".search-result .search-extended-string"));
        postponedAssertTrue(extendedString != null && extendedString.isDisplayed(), "Строка с количеством " +
                "найденных документов не отображается");
    }

    @Step("Проверяется, что фильтр Рекомендации выделен серой полосой")
    public void checkSearchResultRecomendationItemIsActivated() {
        WebElement item = findElementByNoThrow(By.cssSelector("[data-filtr-name='pubDiv'] .btn_state_active"));
        postponedAssertEquals(item.getCssValue("background-color"), "rgba(0, 0, 0, 0.1)", "Цвет выделения " +
                "не серый");
        WebElement icoRecomendation = findElementByNoThrow(By.cssSelector("[data-filtr-name='pubDiv'] " +
                        ".btn_state_active " + ".ico_content_recommendations"));
        postponedAssertNotNull(icoRecomendation, "Выделенный элемент не Рекомендации, а " + item.getText());
    }

    @Step("Проверяется, что фильтр Ответы выделен серой полосой")
    public void checkSearchResultAnswersItemIsActivated() {
        WebElement item = findElementByNoThrow(By.cssSelector("[data-filtr-name='pubDiv'] .btn_state_active"));
        postponedAssertEquals(item.getCssValue("background-color"), "rgba(0, 0, 0, 0.1)", "Цвет выделения " +
                "не серый");
        WebElement icoRecomendation = findElementByNoThrow(By.cssSelector("[data-filtr-name='pubDiv'] " +
                        ".btn_state_active " + ".ico_content_answers"));
        postponedAssertNotNull(icoRecomendation, "Выделенный элемент не Ответы, а " + item.getText());
    }

    @Step("Проверяется, что фильтр Решения выделен серой полосой")
    public void checkSearchResultSolutionsItemIsActivated() {
        WebElement item = findElementByNoThrow(By.cssSelector("[data-filtr-name='pubDiv'] .btn_state_active"));
        postponedAssertEquals(item.getCssValue("background-color"), "rgba(46, 46, 46, 0.0980392)", "Цвет выделения " +
                "не серый");
        WebElement icoRecomendation = findElementByNoThrow(By.cssSelector("[data-filtr-name='pubDiv'] " +
                        ".btn_state_active " + ".ico_content_solutions"));
        postponedAssertNotNull(icoRecomendation, "Выделенный элемент не Решения, а " + item.getText());
    }
}

