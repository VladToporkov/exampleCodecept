package com.actionmedia.pages.kss;

import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.components.Link;
import com.actionmedia.components.MainMenuButtons;
import com.actionmedia.util.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KssServicesPage extends KssBasePage<KssServicesPage> {

    @Step("Проверяются элементы на странице 'Сервисы'")
    public KssServicesPage checkDefaultStateServicesPage() {
        checkServicesTabIsSelected();
        checkSearchBoxIsPresentOnServicesPage();
        checkVipHeaderIsPresent();
        checkVipServicesPreviewBlockIsPresent();
        checkSectionIsNotEmpty();
        checkMyFavoritesRubricatorButtonIsPresent();
        return this;
    }

    @Step("Проверяется что в главном меню выбрана страница 'Ответы'")
    public KssServicesPage checkServicesTabIsSelected() {
        checkCurrentItemIsSelected(MainMenuButtons.SERVICES);
        return this;
    }

    @Step("Проверяется поисковая строка на странице 'Ответы'")
    public KssServicesPage checkSearchBoxIsPresentOnServicesPage() {
        checkSearchBoxIsPresent("");
        return this;
    }

    @Step("Проверяется что заголовок VIP-сервисы отображается")
    public KssServicesPage checkVipHeaderIsPresent() {
        WebElement vipHeader = findElementByNoThrow(mainContentElement, By.tagName("h1"));
        postponedAssertNotNull(vipHeader, "Заголовок VIP-сервисы не найден");
        postponedAssertTrue(vipHeader.isDisplayed(), "Заголовок VIP-сервисы не отображается");
        postponedAssertEquals(vipHeader.getText(), "VIP-сервисы", "Непраильнй текст заголовка VIP-сервисы");
        return this;
    }

    @Step("Проверяется что блок превью сервисов отображается")
    public KssServicesPage checkVipServicesPreviewBlockIsPresent() {
        WebElement vipServicesPreviewBlock = findElementBy(mainContentElement, By.cssSelector("[align='center']"));
        postponedAssertNotNull(vipServicesPreviewBlock, "Блок превью сервисов не найден");
        if (vipServicesPreviewBlock != null) {
            postponedAssertTrue(vipServicesPreviewBlock.isDisplayed(), "Блок превью сервисов не отображается");
            List<WebElement> vipServicesList = vipServicesPreviewBlock.findElements(By.cssSelector("[href*='#/document']"));
            postponedAssertFalse(vipServicesList.isEmpty(), "Блок превью сервисов пустой");
        }
        return this;
    }

    @Step("Проверяется что раздел Сервисы не пустой")
    public KssServicesPage checkSectionIsNotEmpty() {
        WebElement docBody = mainContentElement.findElement(By.id("document-body"));
        List<WebElement> sectionTitleList = findElementsByNoThrow(docBody, By.cssSelector(".title"));
        List<WebElement> sectionElementList = findElementsByNoThrow(docBody, By.tagName("span"));
        postponedAssertNotNull(sectionTitleList, "Текст заголовка сервисов в разделе Сервисы не найден");
        postponedAssertNotNull(sectionTitleList, "Текст описания сервисов в разделе Сервисы не найден");
        if (sectionTitleList != null) {
            for (WebElement sectionTitle : sectionTitleList) {
                postponedAssertFalse(sectionTitle.getText().isEmpty(), "Текст заголовка описания сервиса в разделе Сервисы пустой");
            }
        }
        if (sectionElementList != null) {
            for (WebElement sectionElement : sectionElementList) {
                if (getParentElement(getParentElement(sectionElement)).getAttribute("class").contains("incut")) {
                    continue;
                }
                postponedAssertFalse(sectionElement.getText().isEmpty(), "Текст описания сервиса в разделе Сервисы пустой");
            }
        }
        return this;
    }

    @Step("Проверяется что значек 'Rabota.ru' с заголовком 'Подбор персонала' отображается")
    public KssServicesPage checkRabotaRuImage() {
        checkImageBlock(1, "-123906", "Подбор персонала", "Rabota.ru");
        return this;
    }

    @Step("Проверяется что значек 'City Business School' с заголовком 'Курс по управлению персоналом' отображается")
    public KssServicesPage checkBusinessSchoolImage() {
        checkImageBlock(2, "-123907", "Курс по управлению персоналом", "City Business School");
        return this;
    }

    @Step("Проверяется что значек 'Школа Директора по персоналу' с заголовком 'Курс по управлению персоналом' отображается")
    public KssServicesPage checkSchoolDirectorImage() {
        checkImageBlock(3, "-123908", "Курс по управлению персоналом", "Школа Директора по персоналу");
        return this;
    }

    @Step("Проверяется что значек 'Институт Профессионального Кадровика' с заголовком 'Курс по кадровому учету' отображается")
    public KssServicesPage checkKadrovikImage() {
        checkImageBlock(4, "kadrovik.png", "Курс по кадровому учету", "Институт Профессионального Кадровика");
        return this;
    }

    @Step("Проверяется что значек журнала 'Кадровое дело' с заголовком 'Курс по кадровому учету' отображается")
    public KssServicesPage checkKadrovoeDeloImage() {
        checkImageBlock(4, "-123909", "Курс по кадровому учету", "Курс по кадровому учету");
        return this;
    }

    @Step("Проверяется что описание сервиса 'Rabota.ru' отображается")
    public KssServicesPage checkRabotaRuBlock() {
        WebElement sectionTextBlock = mainContentElement.findElement(By.cssSelector(".vip-service-text"));
        WebElement rabotaRuBlock = findElementByNoThrow(sectionTextBlock, By.id("rabota"));
        postponedAssertNotNull(rabotaRuBlock, "Описание сервиса 'Rabota.ru' не найдено");
        if (rabotaRuBlock != null) {
            postponedAssertTrue(rabotaRuBlock.isDisplayed(), "Описание сервиса 'Rabota.ru' не отображается");
            postponedAssertEquals(rabotaRuBlock.getText(), "1. Подбор персонала с RABOTA.RU", "Неправильный текст заголовка описания сервиса 'Rabota.ru'");
            postponedAssertNotNull(getInCutByBlockName("rabota"), "Отсутствует врез 'Как активировать доступ' для сервиса 'Rabota.ru'");
            postponedAssertFalse(getTextFromBlockByName("rabota").isEmpty(), "Описание сервиса 'Rabota.ru' пустое");
        }
        return this;
    }

    @Step("Проверяется что описание сервиса 'City Business School' отображается")
    public KssServicesPage checkBusinessSchoolBlock() {
        WebElement sectionTextBlock = mainContentElement.findElement(By.cssSelector(".vip-service-text"));
        WebElement rabotaRuBlock = findElementByNoThrow(sectionTextBlock, By.id("school"));
        postponedAssertNotNull(rabotaRuBlock, "Описание сервиса 'City Business School' не найдено");
        if (rabotaRuBlock != null) {
            postponedAssertTrue(rabotaRuBlock.isDisplayed(), "Описание сервиса 'City Business School' не отображается");
            postponedAssertEquals(rabotaRuBlock.getText(), "2. Курсы по управлению персоналом, City Business School", "Неправильный текст заголовка описания сервиса 'City Business School'");
            postponedAssertNotNull(getInCutByBlockName("school"), "Отсутствует врез 'Как активировать доступ' для сервиса 'City Business School'");
            postponedAssertFalse(getTextFromBlockByName("school").isEmpty(), "Описание сервиса 'City Business School' пустое");
            checkSimpleInCut();
        }
        return this;
    }

    @Step("Проверяется что описание сервиса 'Школа Директора по персоналу' отображается")
    public KssServicesPage checkSchoolDirectorBlock() {
        WebElement sectionTextBlock = mainContentElement.findElement(By.cssSelector(".vip-service-text"));
        WebElement rabotaRuBlock = findElementByNoThrow(sectionTextBlock, By.id("director"));
        postponedAssertNotNull(rabotaRuBlock, "Описание сервиса 'Школа Директора по персоналу' не найдено");
        if (rabotaRuBlock != null) {
            postponedAssertTrue(rabotaRuBlock.isDisplayed(), "Описание сервиса 'Школа Директора по персоналу' не отображается");
            postponedAssertEquals(rabotaRuBlock.getText(), "3. Курс по управлению персоналом, Школа Директора по персоналу", "Неправильный текст заголовка описания сервиса 'Школа Директора по персоналу'");
            postponedAssertNotNull(getInCutByBlockName("director"), "Отсутствует врез 'Как активировать доступ' для сервиса 'Школа Директора по персоналу'");
            postponedAssertFalse(getTextFromBlockByName("director").isEmpty(), "Описание сервиса 'Школа Директора по персоналу' пустое");
        }
        return this;
    }

    @Step("Проверяется что описание сервиса 'Институт Профессионального Кадровика' отображается")
    public KssServicesPage checkKadrovikBlock() {
        WebElement sectionTextBlock = mainContentElement.findElement(By.cssSelector(".vip-service-text"));
        WebElement rabotaRuBlock = findElementByNoThrow(sectionTextBlock, By.id("kadrovik"));
        postponedAssertNotNull(rabotaRuBlock, "Описание сервиса 'Институт Профессионального Кадровика' не найдено");
        if (rabotaRuBlock != null) {
            postponedAssertTrue(rabotaRuBlock.isDisplayed(), "Описание сервиса 'Институт Профессионального Кадровика' не отображается");
            postponedAssertEquals(rabotaRuBlock.getText(), "4. Курс по кадровому учету, Институт Профессионального Кадровика", "Неправильный текст заголовка описания сервиса 'Институт Профессионального Кадровика'");
            postponedAssertNotNull(getInCutByBlockName("kadrovik"), "Отсутствует врез 'Как активировать доступ' для сервиса 'Институт Профессионального Кадровика'");
            postponedAssertFalse(getTextFromBlockByName("kadrovik").isEmpty(), "Описание сервиса 'Институт Профессионального Кадровика' пустое");
        }
        return this;
    }

    @Step("Проверяется что описание сервиса журнала 'Кадровое дело' отображается")
    public KssServicesPage checkKadrovoeDeloBlock() {
        WebElement sectionTextBlock = mainContentElement.findElement(By.cssSelector(".vip-service-text"));
        WebElement rabotaRuBlock = findElementByNoThrow(sectionTextBlock, By.id("kadrovik"));
        postponedAssertNotNull(rabotaRuBlock, "Описание сервиса журнала 'Кадровое дело' не найдено");
        if (rabotaRuBlock != null) {
            postponedAssertTrue(rabotaRuBlock.isDisplayed(), "Описание сервиса журнала 'Кадровое дело' не отображается");
            postponedAssertEquals(rabotaRuBlock.getText(), "4. Курс по кадровому учету, журнал «Кадровое дело»", "Неправильный текст заголовка описания сервиса журнала 'Кадровое дело'");
            postponedAssertNotNull(getInCutByBlockName("kadrovik"), "Отсутствует врез 'Как активировать доступ' для сервиса журнала 'Кадровое дело'");
            postponedAssertFalse(getTextFromBlockByName("kadrovik").isEmpty(), "Описание сервиса журнала 'Кадровое дело' пустое");
        }
        return this;
    }


    @Step("Проверяется что врезы открываются/закрываются")
    public KssServicesPage checkActivationInCutsWork() {
        checkInCutsWork(By.cssSelector(".vip-service-incut"), false);
        return this;
    }

    @Step("Проверяется что врезы открываются/закрываются")
    public KssServicesPage checkOpenProgramInCutsWork() {
        checkInCutsWork(By.cssSelector(".vip-service-incut-simple"), true);
        return this;
    }

    @Step("Проверяется работа скролла после нажатия на картинку для 'Rabota.ru'")
    public KssServicesPage checkScrollRabotaRuImage() {
        checkScrollByImageClick(By.cssSelector(".logo-rabota"), By.id("rabota"));
        return this;
    }

    @Step("Проверяется работа скролла после нажатия на заголовок для 'Rabota.ru'")
    public KssServicesPage checkScrollRabotaRuTitle() {
        checkScrollByTitleClick(By.cssSelector(".logo-rabota"), By.id("rabota"));
        return this;
    }

    @Step("Проверяется работа скролла после нажатия на картинку для 'City Business School'")
    public KssServicesPage checkScrollBusinessSchoolImage() {
        checkScrollByImageClick(By.cssSelector(".logo-business-school"), By.id("school"));
        return this;
    }

    @Step("Проверяется работа скролла после нажатия на заголовок для 'City Business School'")
    public KssServicesPage checkScrollBusinessSchoolTitle() {
        checkScrollByTitleClick(By.cssSelector(".logo-business-school"), By.id("school"));
        return this;
    }

    @Step("Проверяется работа скролла после нажатия на картинку для 'Школа Директора по персоналу'")
    public KssServicesPage checkScrollSchoolDirectorImage() {
        checkScrollByImageClick(By.cssSelector(".logo-school-director"), By.id("director"));
        return this;
    }

    @Step("Проверяется работа скролла после нажатия на заголовок для 'Школа Директора по персоналу'")
    public KssServicesPage checkScrollSchoolDirectorTitle() {
        checkScrollByTitleClick(By.cssSelector(".logo-school-director"), By.id("director"));
        return this;
    }

    @Step("Проверяется работа скролла после нажатия на картинку для 'Институт Профессионального Кадровика'")
    public KssServicesPage checkScrollKadrovikImage() {
        checkScrollByImageClick(By.cssSelector(".logo-kadrovik"), By.id("kadrovik"));
        return this;
    }

    @Step("Проверяется работа скролла после нажатия на заголовок для 'Институт Профессионального Кадровика'")
    public KssServicesPage checkScrollKadrovikTitle() {
        checkScrollByTitleClick(By.cssSelector(".logo-kadrovik"), By.id("kadrovik"));
        return this;
    }

    @Step("Проверяется работа ссылок")
    public KssServicesPage checkLinksFromPage() {
        WebElement sectionTextBlock = mainContentElement.findElement(By.cssSelector(".vip-service-text"));
        List<WebElement> linkElementList = sectionTextBlock.findElements(By.cssSelector("[href*='http://']"));
        List<Link> linkList = new ArrayList<Link>();
        for (WebElement linkElement : linkElementList) {
            String url = linkElement.getAttribute("href");
            Link link = new Link(url);
            linkList.add(link);
        }

        for (Link link : linkList) {
            openUrl(link.getUrl(), false);
            checkCurrentUrlContainsDocumentUrl(link.getUrl());
        }
        return this;
    }

    private void checkScrollByImageClick(By imageLocator, By sectionLocator) {
        scrollToTop();

        WebElement header = findElementBy(By.id("header"));
        WebElement servicesBlock = mainContentElement.findElement(By.cssSelector(".vip-service-preview"));
        WebElement rabotaRuImage = servicesBlock.findElement(imageLocator);
        WebElement rabotaRuSection = findElementBy(sectionLocator);
        int headerStartPosition = header.getLocation().getY();

        rabotaRuImage.click();
        waitFewSecond(1000);
        int headerEndPosition = header.getLocation().getY();
        int sectionPosition = rabotaRuSection.getLocation().getY();

        postponedAssertTrue(headerStartPosition != headerEndPosition && sectionPosition - headerEndPosition < DOCUMENT_LOCATION, "Документ не проскролился к описанию секции после нажатия на картинку");

        scrollToTop();
    }

    private void checkScrollByTitleClick(By imageLocator, By sectionLocator) {
        scrollToTop();

        WebElement header = findElementBy(By.id("header"));
        WebElement servicesBlock = mainContentElement.findElement(By.cssSelector(".vip-service-preview"));
        WebElement rabotaRuImage = servicesBlock.findElement(imageLocator);
        WebElement rabotaRuSection = findElementBy(sectionLocator);
        int headerStartPosition = header.getLocation().getY();

        WebElement rabotaRuLink = getParentElement(rabotaRuImage).findElement(By.cssSelector(".dashed"));
        rabotaRuLink.click();
        waitFewSecond(1000);
        int headerEndPosition = header.getLocation().getY();
        int sectionPosition = rabotaRuSection.getLocation().getY();

        postponedAssertTrue(headerStartPosition != headerEndPosition && sectionPosition - headerEndPosition < DOCUMENT_LOCATION, "Документ не проскролился к описанию секции после нажатия на заголовок");

        scrollToTop();
    }

    private void checkInCutsWork(By inCutLocator, boolean isSimpleInCut) {
        WebElement sectionTextBlock = mainContentElement.findElement(By.cssSelector(".vip-service-text"));
        List<WebElement> inCutList = sectionTextBlock.findElements(inCutLocator);
        double documentSizeBefore = TestUtils.getHeightFromString(sectionTextBlock.getCssValue("height"));
        for (int i = 0; i < inCutList.size(); i++) {
            WebElement inCut = inCutList.get(i);
            if (isSimpleInCut) {
                String inCutHeader = inCut.findElement(By.cssSelector(".incut-head")).getText();
                report("Проверяется работа вреза для " + inCutHeader);
            } else {
                report("Проверяется работа вреза для " + (i + 1) + " блока");
            }
            WebElement inCutButton = inCut.findElement(By.cssSelector(".incut-head-control"));
            double inCutSizeBefore = TestUtils.getHeightFromString(inCut.getCssValue("height"));
            inCutButton.click();
            double documentSizeAfter = TestUtils.getHeightFromString(sectionTextBlock.getCssValue("height"));
            double inCutSizeAfter = TestUtils.getHeightFromString(inCut.getCssValue("height"));
            WebElement inCutBody = inCut.findElement(By.cssSelector(".incut-body"));
            postponedAssertTrue(inCutBody.isEnabled() && inCutBody.isDisplayed(), "Открытый врез не отображается");
            postponedAssertFalse(inCutBody.getText().isEmpty(), "В открытом врезе отвсутсвует текст");
            postponedAssertTrue(inCutSizeBefore < inCutSizeAfter, "После открытия вреза размер вреза не изменился");
            postponedAssertTrue(documentSizeAfter - documentSizeBefore == inCutSizeAfter - inCutSizeBefore, "После открытия вреза размер документа не изменился");
            inCutButton.click();

            double inCutSizeClosed = TestUtils.getHeightFromString(inCut.getCssValue("height"));
            double documentSizeClosed = TestUtils.getHeightFromString(sectionTextBlock.getCssValue("height"));
            postponedAssertFalse(inCutBody.isDisplayed(), "Врез отображается после закрытия");
            postponedAssertTrue(inCutSizeBefore == inCutSizeClosed, "После закрытия размер вреза не изменился");
            postponedAssertTrue(documentSizeBefore == documentSizeClosed, "После закрытия вреза размер документа не изменился");
        }
    }

    private void checkImageBlock(int blockIndex, String imgSrc, String headerTitle, String blockName) {
        WebElement servicesBlock = mainContentElement.findElement(By.cssSelector("[align='center']"));
        WebElement imageElement = findElementByNoThrow(servicesBlock, By.xpath("table/tbody/tr[1]/td[" + blockIndex + "]"));
        WebElement titleElement = findElementByNoThrow(servicesBlock, By.xpath("table/tbody/tr[2]/td[" + blockIndex + "]"));
        postponedAssertNotNull(imageElement, "Значек '" + blockName + "' не найден");
        if (imageElement != null) {
            WebElement img = imageElement.findElement(By.tagName("img"));
            postponedAssertTrue(img.isDisplayed(), "Значек '" + blockName + "' не отображается");
            postponedAssertTrue(img.getAttribute("src").contains(imgSrc), "Неправильная картинка для значка '" + blockName + "'");
        }

        postponedAssertNotNull(titleElement, "Заголовок '" + headerTitle + "' не найден");
        if (titleElement != null) {
            postponedAssertTrue(titleElement.isDisplayed(), "Заголовок '" + headerTitle + "' не отображается");
            postponedAssertEquals(titleElement.getText(), headerTitle, "Неправильный текст заголовка '" + headerTitle + "'");
        }
    }

    private WebElement getInCutByBlockName(String blockName) {
        WebElement sectionTextBlock = mainContentElement.findElement(By.cssSelector(".vip-service-text"));
        List<WebElement> servicesTextElementList = sectionTextBlock.findElements(By.tagName("*"));
        for (int i = 0; i < servicesTextElementList.size(); i++) {
            if (servicesTextElementList.get(i).getAttribute("id") != null && servicesTextElementList.get(i).getAttribute("id").equals(blockName)) {
                while (i + 1 < servicesTextElementList.size() && servicesTextElementList.get(i + 1).getAttribute("id") == null ||
                        i + 1 < servicesTextElementList.size() && servicesTextElementList.get(i + 1).getAttribute("id").isEmpty()) {
                    if (servicesTextElementList.get(i + 1).getAttribute("class") != null && servicesTextElementList.get(i + 1).getAttribute("class").contains("vip-service-incut")) {
                        return servicesTextElementList.get(i + 1);
                    }
                    i++;
                }
            }
        }
        return null;
    }

    private String getTextFromBlockByName(String blockName) {
        String textBlock = "";
        WebElement sectionTextBlock = mainContentElement.findElement(By.cssSelector(".vip-service-text"));
        List<WebElement> servicesTextElementList = sectionTextBlock.findElements(By.tagName("*"));
        for (int i = 0; i <= servicesTextElementList.size(); i++) {
            if (servicesTextElementList.get(i).getAttribute("id") != null && servicesTextElementList.get(i).getAttribute("id").equals(blockName)) {
                while (i + 1 < servicesTextElementList.size() && servicesTextElementList.get(i + 1).getAttribute("id") == null ||
                        i + 1 < servicesTextElementList.size() && servicesTextElementList.get(i + 1).getAttribute("id").isEmpty()) {
                    textBlock = textBlock + servicesTextElementList.get(i + 1).getText().trim();
                    i++;
                }
                break;
            }
        }
        return textBlock;
    }

    private void checkSimpleInCut() {
        WebElement sectionTextBlock = mainContentElement.findElement(By.cssSelector(".vip-service-text"));
        List<WebElement> simpleInCutList = sectionTextBlock.findElements(By.cssSelector(".vip-service-incut-simple"));
        postponedAssertEquals(simpleInCutList.size(), 4, "Неправильное количество врезов 'Открыть программу'");
    }

    private void scrollToTop() {
        while (!isHeaderInTop()) {
            executeScript("window.scrollTo(" + 0 + ", " + 0 + "); return true;");
        }
    }

    private boolean isHeaderInTop() {
        return findElementBy(By.id("header")).getLocation().getY() == 0;
    }
}
