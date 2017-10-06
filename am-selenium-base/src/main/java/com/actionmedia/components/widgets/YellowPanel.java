package com.actionmedia.components.widgets;

import com.actionmedia.autotest.selenium.annotations.Wait;
import com.actionmedia.base.BasePage;
import com.actionmedia.pages.helpers.SearchResultHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

/**
 * Created by Pavel on 11/04/16.
 */
@Component
public class YellowPanel extends BasePage<YellowPanel> {

    final private String[] rubricatorsBssKU = {"Налоги", "Учет", "Отраслевой учет", "Эффективная бухгалтерия",
            "Кадровые вопросы", "Юридические вопросы", "Бухгалтерия ИП", "Личная бухгалтерия"};
    final private String[] rubricatorsBssBU = {"Налоги", "Учет", "Отраслевой учет", "Эффективная бухгалтерия",
             "Госзакупки", "Кадровые вопросы", "Личная бухгалтерия"};
    final private String[] rubricatorsBssUSN = {"Налоги", "Учет", "Отраслевой учет", "Эффективная бухгалтерия",
            "Кадровые вопросы", "Юридические вопросы", "Бухгалтерия ИП", "Личная бухгалтерия"};
    final private String[] rubricatorsBssVIP = {"Налоги", "Учет", "Отраслевой учет", "Эффективная бухгалтерия",
            "Кадровые вопросы", "Юридические вопросы", "Финансовые вопросы", "Бухгалтерия ИП", "Личная бухгалтерия",
            "Налоговое планирование"};

    final private String[] rubricatorsGf = {"Налоги", "Учет", "Отраслевой учет", "Эффективная бухгалтерия",
            "Госзакупки", "Кадровые вопросы", "Личная бухгалтерия"};

    final private String[] rubricatorsUss = {"Изменения в законодательстве", "Общие правила договорной работы",
            "Работа с поставщиками и подрядчиками", "Работа с клиентами", "Трудовое право", "Юридический отдел",
            "Корпоративные отношения", "Ведение дел в арбитражном суде", "Административные процедуры и ответственность",
            "Интеллектуальная собственность"};

    final private String[] rubricatorsUssBu = {"Изменения в законодательстве", "Общие правила договорной работы",
            "Работа с поставщиками и подрядчиками", "Работа с клиентами", "Трудовое право", "Юридический отдел",
            "Ведение дел в арбитражном суде", "Административные процедуры и ответственность",
            "Интеллектуальная собственность"};

    final private String[] rubricatorsFSS = {"Денежные потоки", "Финансовый анализ и оценка", "Бюджетирование",
            "Управленческий учет", "Налоговое планирование", "Стратегия компании", "Организация и менеджмент",
            "Рабочие инструменты", "Контроль и управление рисками", "Отраслевые решения"};

    final private String[] rubricatorsGO = {"Организация закупок", "Планирование закупок", "Конкурсы",
            "Электронный аукцион", "Запрос котировок", "Закупки у единственного поставщика", "Контракт",
            "Контроль и обжалование", "Закупки по 223-ФЗ", "Организация работы поставщика"};

    final private String[] rubricatorsElpu = {"Важные изменения", "Организация деятельности", "Финансирование",
            "План ФХД, смета и расходы", "Госзакупки", "Кадры", "Проверки и санкции"};

    final private String[] rubricatorsKlpu = {"Устройство, размещение, оборудование и содержание", "Уборки",
            "Дезинфекция и стерилизация", "Производственный контроль", "Инфекционная безопасность",
            "Медицинские отходы", "Медизделия", "Лекарственные средства",
            "Наркотические средства и психотропные вещества", "Профессиональное развитие", "Условия труда", "Проверки"} ;

    final private String[] rubricatorsCult = {"Актуально сейчас", "Управление и развитие", "Экономика и финансы",
            "Госзакупки", "Административно-хозяйственная деятельность", "Кадровые вопросы"};

    final private String[] rubricatorsUmd = {"Контроль и надзор", "Общее имущество и общее собрание собственников",
            "Управление многоквартирным домом", "Жилищно-коммунальные услуги", "Деятельность по управлению",
            "Государственная информационная система ЖКХ", "Порядок решения споров"};

    private static int rubricatorId = 0;

    @FindBy(id = "yellow-panel")
    @Wait
    @CacheLookup
    private WebElement widget;

    @Step("Проверяется что виджет Желтая плашка отображается")
    public void checkWidgetIsPresent() {
        postponedAssertTrue(widget.isEnabled() && widget.isDisplayed(), "Виджет Желтая плашка не отображается");
    }

    @Step("Проверяется, что отображается текстовая строка")
    public void checkSearchInputIsPresent() {
        WebElement input = findElementByNoThrow(By.id("search-text"));
        postponedAssertTrue(input != null && input.isDisplayed(), "Текстовая строка не отображается");
    }

    @Step("Проверяется, что отображается текст {0} в поисковой строке")
    public void checkSearchInputPlaceholderTextIsPresent(String text) {
        WebElement input = findElementByNoThrow(By.id("search-text"));
        postponedAssertTrue(input != null && input.isDisplayed(), "В поисковой строке текст не отображается");
        postponedAssertEquals(input.getAttribute("placeholder"), text, "Текст в плейсхолдере не " +
                "совпадает с искомым");
    }

    @Step("Проверяется, что отображается текст в поисковой строке Поиск рекомендаций")
    public void checkSearchInputPlaceholderTextIsPresent() {
        WebElement input = findElementByNoThrow(By.id("search-text"));
        postponedAssertTrue(input != null && input.isDisplayed(), "В поисковой строке текст не отображается");
        postponedAssertEquals(input.getAttribute("placeholder"), "Поиск рекомендаций", "Текст в плейсхолдере не " +
                "совпадает с искомым");
    }

    @Step("Проверяется, что отображается подсказка Задайте вопрос, например:")
    public void checkTipIsPresent() {
        WebElement tip = findElementByNoThrow(widget, By.cssSelector("h1.widget__title .widget__title-prefix"));
        postponedAssertEqualsText(tip, "Задайте вопрос, например:");
    }

    @Step("Проверяется, что отображается пример поискового запроса")
    public void checkTipQueryIsPresent() {
        WebElement tip = findElementByNoThrow(widget, By.cssSelector("h1.widget__title"));
        postponedAssertTrue(tip != null && tip.isDisplayed() && tip.getText().length() != 0, "Пример поискового " +
                "запроса не отображается");
    }

    @Step("Проверяется, что отображается фото автора")
    public void checkAuthorsPhotoIsPresent() {
        WebElement photo = findElementByNoThrow(widget, By.cssSelector(".author__portrait img"));
        postponedAssertTrue(photo != null && photo.isDisplayed(), "Фото автора не отображается");
    }

    @Step("Проверяется, что отображается ФИО автора")
    public void checkAuthorsFullNameIsPresent() {
        WebElement fullName = findElementByNoThrow(widget, By.cssSelector(".author__name"));
        postponedAssertTrue(fullName != null && fullName.isDisplayed() && fullName.getText().length() != 0,
                "ФИО автора не отображается");
    }

    @Step("Проверяется, что отображается Должность автора")
    public void checkAuthorsPositionIsPresent() {
        WebElement fullName = findElementByNoThrow(widget, By.cssSelector(".author__props"));
        postponedAssertTrue(fullName != null && fullName.isDisplayed() && fullName.getText().length() != 0,
                "Должность автора не отображается");
    }

    @Step("Проверяется, что отображается краткое содержание документа")
    public void checkAnswerIsPresent() {
        WebElement fullName = findElementByNoThrow(widget, By.cssSelector(".author-comment__text"));
        postponedAssertTrue(fullName != null && fullName.isDisplayed() && fullName.getText().length() != 0,
                "Краткое содержание документа не отображается");
    }

    @Step("Проверяется, что отображается ссылка на документ Из рекомендации")
    public void checkLinkFromRecomendationIsPresent() {
        WebElement textFromRecomendation = findElementByNoThrow(widget, By.cssSelector(".author-comment__source-prefix"));
        postponedAssertEqualsText(textFromRecomendation, "Из рекомендации ");
        WebElement link = findElementByNoThrow(widget, By.cssSelector(".author-comment__source-text a"));
        postponedAssertTrue(link != null && link.isDisplayed(), "Ссылка на документ отображается");
    }

    @Step("Проверяется, что отображаются ссылки на рубрикаторы")
    public void checkRubricatorLinksArePresent() {
        List<WebElement> rubricatorLinks = findElementsByNoThrow(widget, By.cssSelector(".widget__footer a.link_type_rubric"));
        postponedAssertFalse(rubricatorLinks.isEmpty(), "Ссылки на рубрикаторы на желтой плашке не найдены");
        String[] arrayRubricators = null;
        if (getSettings().isRunBss()) {
            if (getCurrentUrl().contains("vip.") || getCurrentUrl().contains("doc.")) {
                arrayRubricators = rubricatorsBssVIP.clone();
            } else if (getCurrentUrl().contains("bu.") || getCurrentUrl().contains("budget.")) {
                arrayRubricators = rubricatorsBssBU.clone();
            } else if (getCurrentUrl().contains("u.") || getCurrentUrl().contains("usn.")) {
                arrayRubricators = rubricatorsBssUSN.clone();
            } else {
                arrayRubricators = rubricatorsBssKU.clone();
            }
        } else if (getSettings().isRunGf()) {
            arrayRubricators = rubricatorsGf.clone();
        } else if (getSettings().isRunFss()) {
            arrayRubricators = rubricatorsFSS.clone();
        } else if (getSettings().isRunUss()) {
            if (getCurrentUrl().contains("bu.") || getCurrentUrl().contains("budget.")) {
                arrayRubricators = rubricatorsUssBu.clone();
            } else {
                arrayRubricators = rubricatorsUss.clone();
            }
        } else if (getSettings().isRunGo()) {
            arrayRubricators = rubricatorsGO.clone();
        } else if (getSettings().isRunElpu()) {
            arrayRubricators = rubricatorsElpu.clone();
        } else if (getSettings().isRunKlpu()) {
            arrayRubricators = rubricatorsKlpu.clone();
        } else if (getSettings().isRunCult()) {
            arrayRubricators = rubricatorsCult.clone();
        } else if (getSettings().isRunUmd()) {
            arrayRubricators = rubricatorsUmd.clone();
        }
        for (int i = 0; i < rubricatorLinks.size(); i++) {
            postponedAssertEqualsText(rubricatorLinks.get(i), arrayRubricators[i]);
        }
    }

    @Step("Нажимается ссылка рубрикатора")
    public String clickOnNextRubricatorsLink() {
        String nthOfType = String.format("nth-of-type(%s)", rubricatorId++);
        WebElement nextRubricatorLink = findElementByNoThrow(widget, By.cssSelector(".widget__footer a.link_type_rubric:" + nthOfType));
        if (nextRubricatorLink == null) {
            return null;
        } else {
            String name = nextRubricatorLink.getText();
            nextRubricatorLink.click();
            waitForReloadingPage();
            return name;
        }
    }

    @Step("Нажать на ссылку Из рекомендации")
    public void clickOnLinkFromRecomendation() {
        WebElement link = findElementByNoThrow(widget, By.cssSelector(".author-comment__source-text a"));
        postponedAssertTrue(link != null && link.isDisplayed(), "Ссылка на документ отображается");
        setParameter(SearchResultHelper.DOCUMENT_URL, link.getAttribute("href"));
        link.click();
        waitForReloadingPage();
    }
}
