package com.actionmedia.components.popups;

import com.actionmedia.autotest.selenium.context.AbstractComponent;
import com.actionmedia.base.BasePage;
import com.actionmedia.pages.helpers.SearchResultHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

/**
 * Works with popups which is visible after clicking on a back link on the document
 */
@Component
public class NotepadPopup extends BasePage<NotepadPopup> {

    @Step("Проверить, что появилась форма Блокнот")
    public void checkPopupIsPresent() {
        postponedAssertTrue(getPopup().isDisplayed(), "Всплывающее окно Блокнот не отображается");
    }

    @Step("Проверить, что по нажатию на крестик, закрывается всплывающее окно")
    public void checkPopupIsNotPresent() {
        WebElement body = findElementByNoThrow(By.id("references-body"));
        postponedAssertTrue(body == null, "Всплывающее окно Блокнот отображается");
    }

    @Step("Проверить, что заголовок содержит правильное название для якоря{0}")
    public void checkTitle(String dataAnchor) {
        WebElement anchorElement = findElementByNoThrow(By.xpath(String.format("//*[contains(@data-anchor,'%s')]", dataAnchor)));
        WebElement titleNumber = findElementByNoThrow(anchorElement, By.xpath("./../span[contains(@class,'-number')]"));
        WebElement titleName = findElementByNoThrow(anchorElement, By.xpath("./../span[contains(@class,'-name')]"));
        String title = titleNumber.getText() + " " + titleName.getText();
        postponedAssertEquals(getTitle(), title, "Заголовки не совпадают");
    }

    @Step("Проверить, что заголовок содержит правильное название для якоря{0}")
    public void checkTitleContainsWord(String dataAnchor, String word) {
        WebElement anchorElement = findElementByNoThrow(By.xpath(String.format("//*[contains(@data-anchor,'%s')]", dataAnchor)));
        WebElement titleName = findElementByNoThrow(anchorElement, By.xpath("./../span[contains(@class,'-name')]"));
        String actualTitle = getTitle();
        String title = titleName.getText();
        postponedAssertTrue(actualTitle.contains(title), "Заголовок блокнота:" + actualTitle + "не содержит:" + title);
        postponedAssertTrue(actualTitle.contains(word), "Заголовок блокнота:" + actualTitle + "не содержит:" + word);
    }

    @Step("Проверить, что заголовок содержит правильное название для якоря{0}")
    public void checkTitleIsAdditionalInformation() {
        postponedAssertEquals(getTitle(), "Дополнительная информация к документу", "Заголовки не совпадают");
    }

    @Step("Проверить, что блокнот имеет белую шапку")
    public void checkHeaderIsWhite() {
        postponedAssertEquals(getHeaderBackgroundColor(), "rgba(255, 255, 255, 1)", "Блокнот не белый");
    }

    @Step("Проверить, что блокнот имеет желтую основную часть")
    public void checkBodyIsYellow() {
        postponedAssertEquals(getBody().getCssValue("background-color"), "rgba(255, 252, 237, 1)", "Тело блокнота не желтое");
    }

    @Step("Проверить, что вокруг блокнота имеется тень")
    public void checkPopupHasShadow() {
        postponedAssertEquals(getShadowParameters(), "rgba(0, 0, 0, 0.2) 0px 25px 70px 20px", "Блокнот не имеет " +
                "тени или тень установлена с другими параметрами");
    }

    @Step("Проверить, что вокруг блокнота имеется тень")
    public void checkPopupHasShadowFSS() {
        postponedAssertEquals(getShadowParameters(), "rgba(46, 46, 46, 0.2) 0px 25px 70px 20px", "Блокнот не имеет " +
                "тени или тень установлена с другими параметрами");
    }

    @Step("Проверить, что блокнот содержит перечень беклинков")
    public void checkBodyHasBacklinks() {
        postponedAssertFalse(getBody().getText().isEmpty(), "Не найдено ни одного беклинка в документе");
    }

    @Step("Проверить, что блокнот не содержит меню дополнительной навигации")
    public void checkMenuBlockIsNotPresent() {
        postponedAssertFalse(isMenuBlockPresent(), "Блок меню отображается");
    }

    @Step("Проверить, что блокнот содержит меню дополнительной навигации")
    public void checkMenuBlockIsPresent() {
        postponedAssertTrue(isMenuBlockPresent(), "Блок меню не отображается");
    }

    @Step("Проверить, что заголовок присутствует")
    public void checkTitleIsPresent() {
        postponedAssertTrue(isTitlePresent(), "Заголовок не виден");
    }

    @Step("Проверить, что крестик закрытия формы присуствует")
    public void checkCloseIconIsPresent() {
        postponedAssertTrue(isCloseButtonPresent(), "Крестик закрытия формы присутствует");
    }

    @Step("Проверить, что меню доп.навигации содержит разделы по порядку:")
    public void checkMenuItemsInOrder(Item... items) {
        int i = 0;
        for (Item item : items) {
            postponedAssertEquals(getMenuItemInOrder(i), item.getMenuName(), "Заголовок под номером: " + (i + 1) + " не совпадает");
            i++;
        }
    }

    @Step("Проверить, что каждому пункту меню соответствует своя иконка")
    public void checkMenuItemIcon(Item... items) {
        for (Item item : items) {
            postponedAssertTrue(hasItemRightIcon(item), "Иконка не соответствует для пункта меню:" + item.getMenuName());
        }
    }

    @Step("Выбрать пункт меню:{0}")
    public void clickOnMenu(Item item) {
        clickOnMenuItem(item);
    }

    @Step("Проверить, что выбран правильный пункт меню")
    public void checkMenuItemHasRightName(Item item) {
        postponedAssertTrue(hasMenuItemRightName(item), "Данное имя:" + item.getMenuName() + " не найдно в списке меню дополнительной навигации");
    }

    @Step("Проверить, что под названием раздела появилась желтая подсветка")
    public void checkMenuItemIsYellow(Item item) {
        postponedAssertTrue(isItemSelected(item), "Пункт меню:" + item + " отображено без желтой подсветки");
    }

    @Step("Навести указатель на название раздела")
    public void hoverOnMenuItem(Item item) {
        hoverOn(item);
    }

    @Step("Проверить, что появилась красная подсетка для названия раздела")
    public void checkMenuItemIsRed(Item item) {
        postponedAssertEquals(getMenuItemColor(item), "rgba(228, 26, 0, 1)", "Цвет подсветки не красный");
    }

    @Step("Проверить, что появилась оранжевая подсетка для названия раздела") // for fss
    public void checkMenuItemIsOrange(Item item) {
        postponedAssertEquals(getMenuItemColor(item), "rgba(198, 121, 11, 1)", "Цвет подсветки не оранжевый");
    }

    @Step("Проверить, что у раздела нет красной подсветки ")
    public void checkMenuItemIsNotRed(Item item) {
        postponedAssertNotEquals(getMenuItemColor(item), "rgba(228, 26, 0, 1)", "Цвет подсветки красный");
    }

    @Step("Проверить, что у раздела нет оранжевой подсветки ") //for fss
    public void checkMenuItemIsNotOrange(Item item) {
        postponedAssertNotEquals(getMenuItemColor(item), "rgba(198, 121, 11, 1)", "Цвет подсветки оранжевый");
    }

    @Step("Проверить, что блокнот проскролился к нужному разделу {0}")
    public void checkScrollTo(Item item) {
        for (WebElement title : waitForPresenceOfAllElementsLocatedBy(By.cssSelector("#references-body .references__title-section"))) {
            if (title.getText().equals(item.getMenuName())) {
                postponedAssertTrue(title.isDisplayed(), "Документ не проскролился к разделу " + item);
                return;
            }
        }
        setPostponedTestFail("Документ не проскролился к нужному разделу:" + item);
    }

    @Step("Проверить, что после скролла раздел подсвечивается желтым")
    public void checkMenuItemIsSelectedAfterScrolling(Item itemWhichWasSelected) {
        hookForScrolling();
        waitForReloadingPage();
        postponedAssertFalse(isItemSelected(itemWhichWasSelected), "После скролла подсветка заголовка меню:" +
                itemWhichWasSelected + " не поменялась");
    }

    @Step("Проверить, что заголовок блокнота занимает одну строку")
    public void checkTitleHasWhiteSpaceCSSValue() {
        WebElement header = findElementBy(By.cssSelector("#references-in .notepad-header__in"));
        WebElement title = findElementByNoThrow(header, By.cssSelector(".notepad-header__title"));
        postponedAssertEquals(title.getCssValue("white-space"), "nowrap", "У заголовка нет параметра white-space или " +
                "у него неверное значение");
    }

    @Step("Проверить, что Первый документ блока Рекомендации содержит ФИО, фото и должность")
    public void checkRecomendationBlockFirstItemHasPhotoFullNameAndPosition() {
        List<WebElement> recomendationList = findElementsByNoThrow(getPopup(), By.cssSelector(".list_content_recommendations li"));
        postponedAssertNotNull(recomendationList, "Лист рекомендаций не найден");
        WebElement firstItem = recomendationList.get(0);
        WebElement photo = findElementByNoThrow(firstItem, By.cssSelector(".portrait__image"));
        postponedAssertFalse(photo.getAttribute("src") == null || photo.getAttribute("src").isEmpty(), "Фото не найдено");
        WebElement fullNameAndPositionText = findElementByNoThrow(firstItem, By.cssSelector(".list__text"));
        postponedAssertTrue(fullNameAndPositionText != null && !fullNameAndPositionText.getText().isEmpty(),
                "Должность и ФИО автора не найдены");
    }

    @Step("Проверить, что Первый документ блока Решения содержит ФИО и должность")
    public void checkSolutionsBlockFirstItemHasPhotoFullNameAndPosition() {
        List<WebElement> recomendationList = findElementsByNoThrow(getPopup(), By.cssSelector(".list_content_solutions li"));
        postponedAssertNotNull(recomendationList, "Лист решений не найден");
        WebElement firstItem = recomendationList.get(0);
        WebElement fullNameAndPositionText = findElementByNoThrow(firstItem, By.cssSelector(".list__text"));
        postponedAssertTrue(fullNameAndPositionText != null && !fullNameAndPositionText.getText().isEmpty(),
                "Должность и ФИО автора не найдены");
    }

    @Step("Проверить, что Все документы блока рекомендации кроме первого содержат только название и оно занимает " +
            "одну строку (параметр white-space:nowrap;)")
    public void checkRecomendationBlockHasLinks() {
        List<WebElement> block = getRecomendationList();
        if (block.size() > 1) {
            block = block.subList(1, block.size()); // without 1st element
            checkBlockHasLinks(block);
        } // if the block contains only 1 element than do nothing.
    }

    @Step("Проверить, что список блока рекомендаций содержит не более 10 документов. Если больше, то 11 элемент - кнопка")
    public void checkRecomentdationBlockHasNoMoreThan10Links() {
        checkBlockHasNoMoreThen10Links(getRecomendationList());
    }

    @Step("Проверить, что Все документы блока Бланки содержат только название и оно занимает " +
            "одну строку (параметр white-space:nowrap;)")
    public void checkFormsBlockHasLinks() {
        checkBlockHasLinks(getFormsList());
    }

    @Step("Проверить, что список блока Бланки содержит не более 10 документов. Если больше, то 11 элемент - кнопка")
    public void checkFormsBlockHasNoMoreThan10Links() {
        checkBlockHasNoMoreThen10Links(getFormsList());
    }

    @Step("Проверить, что Все документы блока Справки содержат только название и оно занимает " +
            "одну строку (параметр white-space:nowrap;)")
    public void checkHandbookBlockHasLinks() {
        checkBlockHasLinks(getHandbookList());
    }

    @Step("Проверить, что список блока Справки содержит не более 10 документов. Если больше, то 11 элемент - кнопка")
    public void checkHandbookBlockHasNoMoreThan10Links() {
        checkBlockHasNoMoreThen10Links(getHandbookList());
    }

    @Step("Проверить, что Все документы в списке Журналы и книги содержат изображение с обложкой журнала, название " +
            "статьи, название журнала, названия статей имеют ссылочный вид")
    public void checkPressBlockHasItems() {
        List<WebElement> items = findElementsByNoThrow(getPopup(), By.cssSelector(".list_content_press li"));
        for (WebElement item : items) {
            WebElement itemImage = findElementByNoThrow(item, By.cssSelector("[class*=_image]"));
            postponedAssertNotNull(itemImage, "Изображение для журнала/книги: не присутствует на странице");
            if (itemImage != null) {
                postponedAssertTrue(itemImage.isDisplayed(), "Обложка не видна");
            }
            WebElement itemLink = findElementByNoThrow(item, By.cssSelector(".link"));
            postponedAssertTrue(itemLink.getAttribute("href").contains("document"), "Слова document нет в ссылке");
            WebElement itemName = findElementByNoThrow(item, By.cssSelector(".list__text"));
            postponedAssertNotNull(itemName, "Название журнала не найдено");
            if (itemName != null) {
                postponedAssertTrue(itemName.getText() != null && !itemName.getText().isEmpty(), "Название не найдено или " +
                        "пустое");
            }
        }
    }

    @Step("Проверить, что список блока Журналы и книги содержит не более 10 документов. Если больше, то 11 элемент - кнопка")
    public void checkPressBlockHasNoMoreThan10Links() {
        checkBlockHasNoMoreThen10Links(getPressList());
    }

    @Step("Проверить, что Все документы блока Законы и подзаконные акты только название")
    public void checkLawBlockHasLinks() {
        checkBlockHasLinks(getLawList(), false);
    }

    @Step("Проверить, что список блока Законы и подзаконные акты содержит не более 10 документов. Если больше, то 11 элемент - кнопка")
    public void checkLawBlockHasNoMoreThan10Links() {
        checkBlockHasNoMoreThen10Links(getLawList());
    }

    @Step("Проверить, что Все документы блока Судебные решения содержат только название")
    public void checkLawPracticeBlockHasLinks() {
        checkBlockHasLinks(getLawPracticeList(), false);
    }

    @Step("Проверить, что список блока Судебные решения содержит не более 10 документов. Если больше, то 11 элемент - кнопка")
    public void checkLawPracticeBlockHasNoMoreThan10Links() {
        checkBlockHasNoMoreThen10Links(getLawPracticeList());
    }

    @Step("Навести указатель на первую ссылку-название документа в судебных решениях и проверить, что ссылка стала красной")
    public void hoverOnFirstLinkFromLawPractice() {
        List<WebElement> items = getLawPracticeList();
        WebElement item = items.get(0);
        postponedAssertNotNull(item, "Первая ссылка не найдена в судебных решениях");
        if (item != null) {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(item).build().perform();
        }
    }

    @Step("Проверить, что ссылка после наведения на нее курсора стала красной")
    public void checkFirstLinkFromLawPracticeBecomeRedAfterHoverOn() {
        List<WebElement> items = getLawPracticeList();
        WebElement item = findElementByNoThrow(items.get(0), By.cssSelector("u"));
        postponedAssertNotNull(item, "Первая ссылка со статусом hover не найдена в судебных решениях, может быть на " +
                "нее не навели курсор?");
        if (item != null) {
            postponedAssertEquals(item.getCssValue("color"), "rgba(228, 26, 0, 1)", "Цвет ссылки после наведения курсора " +
                    "не красный");
        }
    }

    @Step("Проверить, что ссылка после наведения на нее курсора стала оранжевой")
    public void checkFirstLinkFromLawPracticeBecomeOrangeAfterHoverOn() { // for fss
        List<WebElement> items = getLawPracticeList();
        WebElement item = findElementByNoThrow(items.get(0), By.cssSelector("u"));
        postponedAssertNotNull(item, "Первая ссылка со статусом hover не найдена в судебных решениях, может быть на " +
                "нее не навели курсор?");
        if (item != null) {
            postponedAssertEquals(item.getCssValue("color"), "rgba(198, 121, 11, 1)", "Цвет ссылки после наведения курсора " +
                    "не оранжевый");
        }
    }

    @Step("Нажать на случайную ссылку раздела рекомендаций/ответы")
    public void clickOnRecomendationBlockRandomLink() {
        WebElement randomLink = getRandomElementInList(getListWithout11thElement(getRecomendationList()));
        setParameter(SearchResultHelper.DOCUMENT_URL, randomLink.getAttribute("href"));
        report("Открывается ссылка: " + randomLink.getText() + " " + randomLink.getAttribute("href"));
        executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", randomLink, "target", "_self");
        randomLink.click();
        waitForReloadingPage();
    }

    @Step("Нажать на случайную ссылку раздела блоки")
    public void clickOnFormsBlockRandomLink() {
        WebElement randomLink = getRandomElementInList(getListWithout11thElement(getFormsList()));
        setParameter(SearchResultHelper.DOCUMENT_URL, randomLink.getAttribute("href"));
        report("Открывается ссылка: " + randomLink.getText() + " " + randomLink.getAttribute("href"));
        executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", randomLink, "target", "_self");
        randomLink.click();
        waitForReloadingPage();
    }

    @Step("Нажать на случайную ссылку раздела справки")
    public void clickOnHandbookBlockRandomLink() {
        WebElement randomLink = getRandomElementInList(getListWithout11thElement(getHandbookList()));
        setParameter(SearchResultHelper.DOCUMENT_URL, randomLink.getAttribute("href"));
        report("Открывается ссылка: " + randomLink.getText() + " " + randomLink.getAttribute("href"));
        executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", randomLink, "target", "_self");
        randomLink.click();
        waitForReloadingPage();
    }

    @Step("Нажать на случайную ссылку раздела законы и подзаконные акты")
    public void clickOnLawBlockRandomLink() {
        WebElement randomLink = getRandomElementInList(getListWithout11thElement(getLawList()));
        setParameter(SearchResultHelper.DOCUMENT_URL, randomLink.getAttribute("href"));
        report("Открывается ссылка: " + randomLink.getText() + " " + randomLink.getAttribute("href"));
        executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", randomLink, "target", "_self");
        randomLink.click();
        waitForReloadingPage();
    }

    @Step("Нажать на случайную ссылку раздела журналы и книги")
    public void clickOnPressBlockRandomLink() {
        WebElement randomLink = getRandomElementInList(getListWithout11thElement(getPressList()));
        setParameter(SearchResultHelper.DOCUMENT_URL, randomLink.getAttribute("href"));
        report("Открывается ссылка: " + randomLink.getText() + " " + randomLink.getAttribute("href"));
        executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", randomLink, "target", "_self");
        randomLink.click();
        waitForReloadingPage();
    }

    @Step("Нажать на случайную ссылку раздела судебные решения")
    public void clickOnLawPracticeBlockRandomLink() {
        WebElement randomLink = getRandomElementInList(getListWithout11thElement(getLawPracticeList()));
        setParameter(SearchResultHelper.DOCUMENT_URL, randomLink.getAttribute("href"));
        report("Открывается ссылка: " + randomLink.getText() + " " + randomLink.getAttribute("href"));
        executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", randomLink, "target", "_self");
        randomLink.click();
        waitForReloadingPage();
    }

    @Step("Нажать на случайную ссылку раздела решения")
    public void clickOnSolutionsBlockRandomLink() {
        WebElement randomLink = getRandomElementInList(getListWithout11thElement(getSolutionsList()));
        setParameter(SearchResultHelper.DOCUMENT_URL, randomLink.getAttribute("href"));
        report("Открывается ссылка: " + randomLink.getText() + " " + randomLink.getAttribute("href"));
        executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", randomLink, "target", "_self");
        randomLink.click();
        waitForReloadingPage();
    }

    @Step("Нажать на случайную ссылку из раздела Видео")
    public void clickOnVideosBlockRandomLink() {
        WebElement randomLink = getRandomElementInList(getListWithout11thElement(getVideosList()));
        setParameter(SearchResultHelper.DOCUMENT_URL, randomLink.getAttribute("href"));
        report("Открывается ссылка: " + randomLink.getText() + " " + randomLink.getAttribute("href"));
        executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", randomLink, "target", "_self");
        randomLink.click();
        waitForReloadingPage();
    }

    private List<WebElement> getListWithout11thElement(List<WebElement> list) {
        if (list.size() == 11) {
            return list.subList(0, 10);
        }
        return list;
    }

    private void checkBlockHasLinks(List<WebElement> blockList) {
        checkBlockHasLinks(blockList, true);
    }

    private void checkBlockHasLinks(List<WebElement> blockList, boolean hasNoWrap) {
        List<WebElement> recomendationList = blockList;
        postponedAssertNotNull(recomendationList, "Лист не найден");
        for (int i = 0; i < recomendationList.size() - 1; i++) {
            WebElement link = recomendationList.get(i);
            postponedAssertNotNull(link, "Ссылка в под номером:" + i + " не найдена");
            if (link != null) {
                postponedAssertFalse(link.getText().isEmpty(), "Нет текста у ссылки");
                postponedAssertTrue(link.getAttribute("href").contains("document"), "Слова document нет в ссылке. " +
                        "Может быть ссылка не работает?");
                if (hasNoWrap == true) {
                    postponedAssertEquals(link.getCssValue("white-space"), "nowrap", "Параметр css white-space не " +
                            "установлен или имеет другое значение");
                }
            }
        }
    }

    private void checkBlockHasNoMoreThen10Links(List<WebElement> blockList) {
        List<WebElement> recomendationList = blockList;
        postponedAssertNotNull(recomendationList, "Лист не найден");
        postponedAssertTrue(recomendationList.size() - 1 <= 10, "Блок содержит более 10 документов");
        if (recomendationList.size() == 11) { //if we have eleventh element
            WebElement lastItem = recomendationList.get(10);
            postponedAssertNotNull(lastItem, "Последний элемент списка не ссылка!");
            if (lastItem != null) {
                postponedAssertTrue(lastItem.getAttribute("href").contains("backlink"), "Ссылка не ведет на список " +
                        "backlink");
            }
        }
    }

    private List<WebElement> getRecomendationList() {
        return findElementsByNoThrow(getPopup(), By.cssSelector(".list_content_recommendations li a"));
    }

    private List<WebElement> getHandbookList() {
        return findElementsByNoThrow(getPopup(), By.cssSelector(".list_content_handbook li a"));
    }

    private List<WebElement> getPressList() {
        return findElementsByNoThrow(getPopup(), By.cssSelector(".list_content_press li a"));
    }

    private List<WebElement> getFormsList() {
        return findElementsByNoThrow(getPopup(), By.cssSelector(".list_content_forms li a"));
    }

    private List<WebElement> getLawList() {
        return findElementsByNoThrow(getPopup(), By.cssSelector(".list_content_law li a"));
    }

    private List<WebElement> getLawPracticeList() {
        return findElementsByNoThrow(getPopup(), By.cssSelector(".list_content_lawpractice li a"));
    }

    private List<WebElement> getSolutionsList() {
        return findElementsByNoThrow(getPopup(), By.cssSelector(".list_content_solutions li a"));
    }

    private List<WebElement> getVideosList() {
        return findElementsByNoThrow(getPopup(), By.cssSelector(".list_content_videos li a"));
    }

    private void hookForScrolling() {
        executeScript("arguments[0].scrollTop = arguments[1];", getBody(), 700);
    }

    private String getTitle() {
        return waitForPresenceOfElementLocatedBy(By.cssSelector("#references-in .notepad-header__title"), "Не найден заголовок блокнота").getText();
    }

    private boolean isTitlePresent() {
        WebElement title = findElementByNoThrow(By.cssSelector("#references-in .notepad-header__title"));
        return title != null && title.isDisplayed();
    }

    private boolean isMenuBlockPresent() {
        WebElement menuBlock = findElementByNoThrow(By.cssSelector(".notepad-header__in ul"));
        if (menuBlock == null || !menuBlock.isDisplayed()) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isCloseButtonPresent() {
        WebElement closeButton = findElementByNoThrow(By.id("references-close"));
        return closeButton != null && closeButton.isDisplayed();
    }

    private void clickOnMenuItem(Item item) {
        WebElement menuItem = getMenuItemBy(item);
        menuItem.click();
        waitForReloadingPage();
    }

    private boolean isItemSelected(Item item) {
        WebElement selectedItem = getMenuItemBy(item);
        if (selectedItem.getAttribute("class").contains("state_active")) { //checks that link is active
            if (selectedItem.getCssValue("background-color").equals("rgba(253, 233, 115, 1)")) //checks that link is yellow
                return true;
            else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean hasMenuItemRightName(Item item) {
        WebElement element = getMenuItemBy(item);
        if (element != null) {
            return true; //if the method getMenuItemBy found the WebElement, than return true
        } else {
            return false;
        }
    }

    private String getMenuItemInOrder(int order) {
        List<WebElement> menu = findElementsBy(By.cssSelector("#references-in .notepad-header__in li"));
        WebElement menuItem = menu.get(order);
        return menuItem.getText();
    }

    private boolean hasItemRightIcon(Item item) {
        WebElement selectedItem = getMenuItemBy(item);
        WebElement icon = findElementBy(selectedItem, (By.tagName("ins")));
        if (icon.getAttribute("class").contains(item.getIconName())) {
            return true;
        } else {
            return false;
        }
    }

    private String getHeaderBackgroundColor() {
        WebElement header = findElementBy(By.cssSelector("#references-header"));
        return header.getCssValue("background-color");
    }

    @Step("Нажать на крестик закрытия блокнота")
    public void clickOnCloseButton() {
        findElementBy(By.id("references-close")).click();
        waitForReloadingPage();
    }

    private String getShadowParameters() {
        String shadowParameters = (String) executeScript("return window.getComputedStyle(" +
                "document.querySelector('.notepad-header'),':after').getPropertyValue('box-shadow')");
        return shadowParameters;
    }

    private void hoverOn(Item item) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(getMenuItemBy(item)).build().perform();
        waitFewSecond(1000);
        waitForReloadingPage();
    }

    private String getMenuItemColor(Item item) {
        WebElement selectedItem = getMenuItemBy(item);
        WebElement hover = selectedItem.findElement(By.cssSelector(".btn:hover u"));
        return hover.getCssValue("color");
    }

    private WebElement getMenuItemBy(Item item) {
        WebElement menuItem = findElementByNoThrow(By.cssSelector(String.format("#references-in [data-group-name='%s']", item.getItemName())));
        postponedAssertNotNull(menuItem, "Меню:" + item.getMenuName() + " не найдено");
        return menuItem;
    }

    private WebElement getPopup() {
        return waitForElementToBeClickable(By.id("references-in"), "Всплывающее окно Блокнот не отображается");
    }

    private WebElement getBody() {
        return waitForElementToBeClickable(By.id("references-body"), "Всплывающее окно Блокнот не отображается");
    }

//    /**
//     * Describes the headerPopup in the popup
//     */
//    public class Header extends AbstractComponent<Header> {
//
//
//    }

    public enum Item {
        RECOMMENDATIONS("recommendations", "Рекомендации", "ico_content_recommendations"),
        HANDBOOK("handbook", "Справки", "ico_content_handbook"),
        PRESS("press", "Журналы и книги", "ico_content_press"),
        FORMS("forms", "Бланки", "ico_content_forms"),
        LAWPRACTICE("lawpractice", "Судебные решения", "ico_content_lawpractice"),
        LAW("law", "Законы и подзаконные акты", "ico_content_law"),
        ANSWERS("recommendations", "Ответы", "ico_content_answers"),
        SOLUTIONS("solutions", "Решения", "ico_content_solutions"),
        VIDEOS("videos", "Видео", "ico_content_videos"),
        FORMS_FSS("forms", "Положения и регламенты", "ico_content_forms");

        String itemName;
        String menuName;
        String iconName;

        Item(String itemName, String menuName, String iconName) {
            this.itemName = itemName;
            this.menuName = menuName;
            this.iconName = iconName;
        }

        public String getMenuName() {
            return menuName;
        }

        public String getItemName() {
            return itemName;
        }

        public String getIconName() {
            return iconName;
        }

        @Override
        public String toString() {
            return menuName;
        }
    }
}
