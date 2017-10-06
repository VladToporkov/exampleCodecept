package com.actionmedia.pages.kss;

import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.components.Link;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.pages.helpers.SearchResultHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KssWizardsPage extends KssBasePage<KssWizardsPage> {

    @Step("Проверяются элементы на странице 'Мастера'")
    public KssWizardsPage checkDefaultStateWizardsPage() {
        checkWizardsTabIsSelected();
        checkSearchBoxPresentOnWizardsPage();
        checkPetalBlocksIsPresent();
        checkWizardsBlockIsPresent();
        checkPopularBlockIsPresent();
        checkWizardsRubricatorButtonIsPresent();
        checkMyFavoritesRubricatorButtonIsPresent();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Мастера'")
    public KssWizardsPage checkWizardsTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.WIZARDS);
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Мастера'")
    public KssWizardsPage checkSearchBoxPresentOnWizardsPage() {
        checkSearchBoxIsPresent("Поиск по мастерам");
        return this;
    }

    @Step("Проверяется что лепестки присутсвуют")
    public KssWizardsPage checkPetalBlocksIsPresent() {
        List<WebElement> petalFrameList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".petals"), "Блок с Лепестками не найден");
        for (WebElement petalFrame : petalFrameList) {
            List<WebElement> petalList = petalFrame.findElements(By.cssSelector("[class*='petal-']"));
            postponedAssertFalse(petalList.isEmpty(), "Блок лепестки пустой");
            postponedAssertTrue(petalList.get(0).isEnabled() && petalList.get(0).isDisplayed(), "Лепесток не отображается");
        }
        return this;
    }

    @Step("Проверяется блока мастеров")
    public KssWizardsPage checkWizardsBlockIsPresent() {
        List<WebElement> wizards = mainLeftElement.findElements(By.tagName("*"));
        for (int i = 0; i < wizards.size(); i++) {
            if ("h2".equals(wizards.get(i).getTagName())) {
                boolean isWizardsBlockEmpty = false;
                while (i + 1 < wizards.size() && !"h2".equals(wizards.get(i + 1).getTagName())) {
                    WebElement wizard = wizards.get(i);
                    if ("ul".equals(wizard.getTagName())) {
                        isWizardsBlockEmpty = true;
                        List<WebElement> links = wizard.findElements(By.tagName("li"));
                        for (WebElement wizardLink : links) {
                            String url = wizardLink.findElement(By.tagName("a")).getAttribute("href");
                            String text = wizardLink.findElement(By.tagName("a")).getText();
                            postponedAssertFalse(url.isEmpty(), "Ссылка для мастера пустая");
                            postponedAssertFalse(text.isEmpty(), "Текст ссылки мастера пустой");
                        }
                    }
                    i++;
                }
                postponedAssertTrue(isWizardsBlockEmpty, "Блок мастеров пустой");
            }
        }
        return this;
    }

    @Step("Проверяется что блок Недавно открытые показан")
    public KssWizardsPage checkPopularBlockIsPresent() {
        WebElement popularBlock = findElementByNoThrow(mainContentElement, By.id("sidebar"));
        postponedAssertNotNull(popularBlock, "Блок Недавно открытые не найден");
        if (popularBlock != null) {
            waitForTextToBePresentIn(popularBlock);
            postponedAssertTrue(popularBlock.isDisplayed(), "Блок Недавно открытые не отображается");
        }
        return this;
    }

    @Step("Проверяется кнопка рубрикатора форм присутсвует")
    public KssWizardsPage checkWizardsRubricatorButtonIsPresent() {
        WebElement rubricatorButton = waitForPresenceOfElementLocatedBy(By.id("rubricator-btn"), "Кнопка Все сервисы Отсутствует");
        postponedAssertEquals(rubricatorButton.getText(), "Все сервисы", "Неправильный текст кнопки Все сервисы");
        return this;
    }

    @Step("Проверяется работа ссылок для блока лепестков")
    public KssWizardsPage checkLinksForPetalBlock() {
        List<WebElement> petalFrameList = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".petals"), "Блок с Лепестками не найден");
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement petalFrame : petalFrameList) {
            List<WebElement> petalList = petalFrame.findElements(By.cssSelector("[class*='petal-']"));
            for (WebElement petal : petalList) {
                if (petal.isDisplayed()) {
                    String url = petal.findElement(By.tagName("a")).getAttribute("href");
                    Link link = new Link(url, "");
                    linkList.add(link);
                }
            }
        }
        checkLinks(linkList);
        return this;
    }

    @Step("Проверяется работа ссылок в блоке Мастера")
    public KssWizardsPage checkLinksForWizardsBlock() {
        List<WebElement> wizards = mainLeftElement.findElements(By.tagName("*"));
        List<Link> linkList = new ArrayList<Link>();
        for (int i = 0; i < wizards.size(); i++) {
            if ("h2".equals(wizards.get(i).getTagName())) {
                boolean isWizardsBlockEmpty = false;
                while (i + 1 < wizards.size() && !"h2".equals(wizards.get(i + 1).getTagName())) {
                    WebElement wizard = wizards.get(i);
                    if ("ul".equals(wizard.getTagName())) {
                        isWizardsBlockEmpty = true;
                        List<WebElement> links = wizard.findElements(By.tagName("li"));
                        for (WebElement wizardLink : links) {
                            String url = wizardLink.findElement(By.tagName("a")).getAttribute("href");
                            String text = wizardLink.findElement(By.tagName("a")).getText();
                            Link link = new Link(url, text);
                            linkList.add(link);
                        }
                    }
                    i++;
                }
                postponedAssertTrue(isWizardsBlockEmpty, "Блок мастеров пустой");
            }
        }
        checkLinks(linkList);
        return this;
    }

    @Step("Проверяется что блок Недавно открытые не пустой")
    public KssWizardsPage checkPopularBlockAreNotEmpty() {
        List<WebElement> popularForms = sidebarElement.findElements(By.cssSelector(".news__item"));
        postponedAssertFalse(popularForms.isEmpty(), "Блок Недавно открытые пуст");

        for (WebElement popularForm : popularForms) {
            postponedAssertFalse(popularForm.getText().isEmpty(), "Отсутствует текст для формы в блоке Недавно открытые");
        }
        return this;
    }

    @Step("Проверяется работа ссылок в блоке Недавно открытые")
    public KssWizardsPage checkPopularWizardsLinks() {
        List<WebElement> popularForms = sidebarElement.findElements(By.cssSelector(".news__item"));
        List<Link> formLinks = new ArrayList<Link>();
        for (WebElement popularForm : popularForms) {
            String url = popularForm.findElement(By.tagName("a")).getAttribute("href");
            String header = popularForm.findElement(By.tagName("a")).getText();
            Link link = new Link(url, header);
            formLinks.add(link);
        }
        checkLinks(formLinks);
        return this;
    }

    @Step("Проверяется что результаты поиска отсутсвуют")
    public KssWizardsPage checkSearchResultIsNotPresentOnWizardsPage() {
        checkSearchResultIsNotPresentOnPage();
        return this;
    }

    @Step("Нажать кнопку Найти")
    public KssWizardsPage clickSearchButtonOnWizardsPage() {
        clickSearchButton();
        return this;
    }

    @Step("Проверяется что поисковые подсказки отображаются")
    public KssWizardsPage checkHintsIsPresent() {
        checkHintListIsPresent();
        return this;
    }

    @Step("Нажать подсказку с прямым переходом")
    public KssSearchResultPage clickHintWithJumpOnWizardsPage() {
        clickHintWithJump();
        return redirectTo(KssSearchResultPage.class);
    }

    @Step("Нажать любую подсказку с переходом")
    public KssSearchResultPage clickRandomHintOnWizardsPage() {
        clickRandomHint();
        return redirectTo(KssSearchResultPage.class);
    }

    @Step("Открыть случайный документ из блока популярное")
    public KssWizardsPage clickRandomDocumentLink() {
        WebElement popularContent = waitForPresenceOfElementLocatedBy(By.cssSelector(".petals-list"));
        List<WebElement> popularNews = new ArrayList<WebElement>();
        for (WebElement petal : popularContent.findElements(By.cssSelector("[class*='petal']"))) {
            if (petal.isDisplayed()) {
                popularNews.add(petal);
            }
        }
        getRandomElementInList(popularNews).findElement(By.tagName("a")).click();
        waitForReloadingPage();
        return this;
    }

    @Step("Открыть несколько мастеров")
    public KssWizardsPage openFewWizards() {
        WebElement popularBlock = findElementByNoThrow(mainContentElement, By.id("sidebar"));

        if (popularBlock != null) {
            List<WebElement> popularForms = popularBlock.findElements(By.cssSelector(".wizards"));
            if (popularForms.isEmpty()) {
                clickRandomDocumentLink();
                returnToBack();
                clickRandomDocumentLink();
                returnToBack();
                clickRandomDocumentLink();
                returnToBack();
            }
        } else {
            fail("Блок Недавно открытые не найден");
        }
        return this;
    }

    @Step("Проверяется работа кнопки Найти на странице Правовая база")
    public KssWizardsPage checkSearchButtonFunctionalityOnSearchBox(String query) {
        setParameter(SearchResultHelper.HINT_TEXT, query);
        return clearSearchBox()
                .clickSearchButtonOnWizardsPage()
                .checkWizardsTabIsSelected()
                .checkSearchResultIsNotPresentOnWizardsPage()

                .clearSearchBox()
                .inputTextInSearchBox(query)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnWizardsPageIsOpened()
                .navigateToWizardsPage();
    }
}
