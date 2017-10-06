package com.actionmedia.tests.experimental;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.selenium.SeleniumHolder;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import java.util.*;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 29/07/16.
 */
public class LanguageTest extends AbstractDomainTest {
    String[] links = new String[] {
            "#/customer/geo/" ,
//            "#/customer/activate-code/" ,
//            "#/hotline/" ,
            "#/customer/" ,
//            "#/recommendations/" ,
//            "#/law/" ,
            "#/forms/" ,
            "#/handbook/" ,
            "#/press/" ,
//            "#/document/16/4946/" ,
//            "#/rubric/1/94/3408/" ,
//                   "#/rubric/1/94/3478/" ,
//                   "#/rubric/1/94/3484/" ,
//                   "#/rubric/1/94/3497/" ,
//                   "#/rubric/1/94/3507/" ,
//                   "#/rubric/1/94/3544/" ,
//                   "#/rubric/1/94/3553/" ,
//                   "#/rubric/1/94/3559/" ,
//                   "#/document/94/31353/" ,
//                   "#/document/94/30420/" ,
//                   "#/document/94/31355/" ,
//                   "#/document/94/21482/" ,
//            "#/document/118/1068/" ,
//                   "#/document/118/839/" ,
//                   "#/document/118/1089/" ,
//                   "#/document/118/857/" ,
//            "#/document/192/25248/" ,
//                   "#/document/192/25128/" ,
//                   "#/document/192/25108/" ,
//                   "#/document/192/25079/" ,
//                   "#/document/192/25049/" ,
//                   "#/document/192/25046/" ,
//                   "#/document/192/25015/" ,
//            "#/document/190/367/task-0" ,
//            "#/document/117/0/" ,
//                   "#/rubric/2/98//" ,
//            "#/document/190/367/" ,
//            "#/news/" ,
//            "#/document/184/550//" ,
//                   "#/document/184/549//" ,
//                   "#/document/184/548//" ,
//                   "#/document/184/551//" ,
//                   "#/document/184/187//" ,
//                   "#/document/184/150//" ,
//                   "#/document/94/30902//" ,
//                   "#/document/184/297//" ,
//                   "#/document/184/188//" ,
//                   "#/document/184/212//" ,
//                   "#/document/94/31353/" ,
//                   "#/document/94/31353/me1675/" ,
//                   "#/document/94/31353/me3959/" ,
//                   "#/document/94/31353/me6042/" ,
//                   "#/document/94/31353/me7343/" ,
//                   "#/document/94/31353/me9055/" ,
//                   "#/document/94/31353/me11178/" ,
//                   "#/document/94/31353/31353/" ,
//                   "#/document/94/31353/me13389/" ,
//                   "#/document/94/31353/me14249/" ,
//                   "#/document/94/31353/me18371/" ,
//                   "#/document/94/31355/" ,
//                   "#/document/94/31351/" ,
//                   "#/document/94/32548/" ,
//                   "#/document/94/31358/" ,
//                   "#/document/94/31680/" ,
//                   "#/document/94/31360/" ,
//                   "#/document/94/30318/" ,
//                   "#/document/94/31165/" ,
//                   "#/document/94/21507/" ,
//                   "#/document/94/21493/" ,
//                   "#/document/94/21491/" ,
//                   "#/document/94/21492/" ,
//                   "#/document/94/31352/" ,
//                   "#/document/94/30420/" ,
//                   "#/document/94/30327/" ,
//                   "#/document/94/21304/" ,
//                   "#/document/94/21486/" ,
//                   "#/document/94/31529/" ,
//                   "#/document/94/30563/" ,
//                   "#/document/94/30259/" ,
//                   "#/document/94/31372/" ,
//                   "#/document/94/27101/" ,
//                   "#/document/94/20212/" ,
//            "#/news/law/" ,
//                   "#/document/94/32571/" ,
//                   "#/document/94/31765/" ,
//                   "#/document/94/31770/" ,
//                   "#/document/94/30902/" ,
//                   "#/document/118/1088/" ,
//                   "#/document/118/1087/" ,
//                   "#/document/118/1089/" ,
//                   "#/document/118/1086/" ,
//                   "#/document/118/1060/" ,
//                   "#/document/118/1059/" ,
//                   "#/document/118/1063/" ,
//                   "#/document/118/1062/" ,
//                   "#/document/118/1061/" ,
//                   "#/document/118/1066/" ,
//                   "#/document/118/1065/" ,
//                   "#/document/118/1064/" ,
//                   "#/document/118/1068/" ,
//                   "#/document/118/1069/" ,
//                   "#/document/118/1067/" ,
//                   "#/document/190/367/" ,
//                   "#/document/117/28/" ,
//                   "#/document/117/34/" ,
//                   "#/document/94/31839/" ,
//                   "#/document/94/31712/" ,
//                   "#/document/117/44/" ,
//                   "#/document/117/48/" ,
//                   "#/document/117/310/" ,
//                   "#/document/190/367/actual/" ,
//                   "#/document/190/22/actual/" ,
//                   "#/document/192/25248/" ,
//                   "#/document/192/25128/" ,
//                   "#/document/192/25108/" ,
//                   "#/document/192/25079/" ,
//                   "#/document/192/25049/" ,
//                   "#/document/192/25046/" ,
//                   "#/document/192/25015/" ,
//                   "#/document/192/24988/" ,
//                   "#/document/192/24953/" ,
//                   "#/document/192/24945/" ,
//                   "#/document/192/24977/" ,
//                   "#/document/192/24929/" ,
//                   "#/document/192/24940/" ,
//                   "#/document/192/24911/" ,
//                   "#/document/192/24944/" ,
//                   "#/document/192/24948/" ,
//                   "#/document/192/24949/" ,
//                   "#/document/192/24955/" ,
//                   "#/document/192/24965/" ,
//                   "#/document/192/25047/" ,
//                   "#/document/192/25043/" ,
//            "#/document/192/25058/"

    };

    List<String> excludeWords = new ArrayList<String>();

    @Test
    public void checkExpertusLanguage() throws InterruptedException {
        updateSystemInfo(SystemPubs.bss);
        enterToBssWithoutLogin();
        WebDriver driver = SeleniumHolder.getWebDriver();
        String expertusHost = "http://1gl.expertus.ua";
        driver.get(expertusHost + "/");

//        driver.findElement(By.name("login")).sendKeys("bss");
//        driver.findElement(By.name("password")).sendKeys("bss");
//        driver.findElement(By.xpath("//input[@type='submit']")).submit();

        driver.findElement(By.cssSelector(".menu #user-enter a")).click();
        Thread.sleep(5000);
        try {
            if (!driver.findElement(By.cssSelector("#fields-auth #email")).isDisplayed()) {
                driver.findElement(By.id("wf-enter")).click();
                Thread.sleep(2000);
            }
        } catch (ElementNotVisibleException nse) {

        }
        driver.findElement(By.cssSelector("#fields-auth #email")).sendKeys("kupriyanov");
        driver.findElement(By.cssSelector("#fields-auth [name='password']")).sendKeys("aspirine");
        driver.findElement(By.cssSelector("#page-auth #button-enter")).submit();
        Thread.sleep(2000);


        for (int i = 0; i < links.length; i++) {
            driver.get(expertusHost + "/" + links[i]);
            Thread.sleep(5000);
            System.out.println("================ПРОВЕРЯЕМ:" + expertusHost + "/" + links[i] + "===================");
            List<WebElement> links = driver.findElements(By.xpath("//body/descendant::*"));
            List<String> wordsInList = new ArrayList<String>();

            List<WebElement> visibledElements = new ArrayList<WebElement>();
            for (WebElement link : links) {
                try {
                    if (link.isDisplayed()) {
                        visibledElements.add(link);
                    }
                }
                catch (StaleElementReferenceException sere) {

                }
            }


            wordsInList.addAll(checkElementsWithAlt(visibledElements));
            wordsInList.addAll(checkElementsWithTitle(visibledElements));
            wordsInList.addAll(checkElementsWithPlaceHolder(visibledElements));

            List<WebElement> elementsWithText = driver.findElements(By.xpath("//body/descendant::*[text()]"));
            wordsInList.addAll(getTextFromElements(elementsWithText));



            wordsInList = removeElementsWithUkraineLetters(wordsInList);

            excludeWords.addAll(checkLetters(wordsInList));

            wordsInList = parseBySpaces(wordsInList);

            // cleaning
            List<String> finalWords = new ArrayList<String>(wordsInList);
            finalWords.removeAll(Arrays.asList("", null));



            checkLanguage(driver, finalWords);
        }
        System.out.println("ПРОВЕРКА ЗАВЕРШЕНА");
        System.out.println("==================================ВСЕ СЛОВА:");
        Set<String> hs = new HashSet<String>();
        hs.addAll(excludeWords);
        excludeWords.clear();
        excludeWords.addAll(hs);
        for (String excludeWord : excludeWords) {
            System.out.println(excludeWord);
        }
        driver.quit();
    }

    private List<String> parseBySpaces(List<String> wordsInList) {
        List<String> allWords = new ArrayList<String>();
        for (String words: wordsInList) {
            if (words.contains(" ")) {
                allWords.addAll(Arrays.asList(words.split(" ")));
            } else {
                allWords.add(words);
            }
        }
        Set<String> hs = new HashSet<String>();
        hs.addAll(allWords);
        allWords.clear();
        allWords.addAll(hs);
        return allWords;
    }

    private List<String> getTextFromElements(List<WebElement> elementsWithText) {
        List<String> textFromElements = new ArrayList<String>();
        for (WebElement element: elementsWithText) {
            if (element.isDisplayed()) {
                String words = element.getText();
                if (words != null && !words.equals("") && !words.isEmpty()) {
                    textFromElements.add(words);
                }
            }
        }
        return textFromElements;
    }

    private void checkLanguage(WebDriver driver, List<String> wordsInList) {
        for (String word: wordsInList) {
            driver.get("http://gramota.ru/slovari/dic/?lop=x&word=" + word.trim());

            try {
                WebElement whatFound = driver.findElement(By.cssSelector(".gray .block-content > div:nth-of-type(2)"));
                String text = whatFound.getText();
                if (!text.isEmpty() && !text.contains("отсутствует")) {
                    System.out.println("!!!!!!!!!!!!!!!!!!!! НАЙДЕНО ДЛЯ СЛОВА:" + word + " ЗНАЧЕНИЕ:" + text + " !!!!!!!!!!!!!!!!!!!!!");
                    excludeWords.add(word);
                }
            } catch (NoSuchElementException nse) {

            }


        }
    }

    private List<String> checkLetters(List<String> elements) {
        List<String> russianWords = new ArrayList<String>();
        for (String element : elements) {
                if (element.contains("Ё") || element.contains("ё") || element.contains("ъ") || element.contains("ы") || element.contains("Э") || element.contains("э")) {
                    russianWords.add(element);
                }
            }
        return russianWords;
    }

    private List<String> checkElementsWithAlt(List<WebElement> elements) {
        List<String> altWords = new ArrayList<String>();
        for (WebElement element : elements) {
            if (element.getAttribute("alt") != null) {
                altWords.add(element.getAttribute("alt"));
            }
        }
        return altWords;
    }

    private List<String> checkElementsWithTitle(List<WebElement> elements) {
        List<String> altWords = new ArrayList<String>();
        for (WebElement element : elements) {
            if (element.getAttribute("title") != null) {
                altWords.add(element.getAttribute("title"));
            }
        }
        return altWords;
    }

    private List<String> checkElementsWithPlaceHolder(List<WebElement> elements) {
        List<String> altWords = new ArrayList<String>();
        for (WebElement element : elements) {
            if (element.getAttribute("placeholder") != null) {
                altWords.add(element.getAttribute("placeholder"));
            }
        }
        return altWords;
    }

    private List<String> removeElementsWithUkraineLetters(List<String> elements) {
        for (int i = 0; i < elements.size(); i++) {
            String words = elements.get(i);
            if (words != null && !words.equals("") && !words.isEmpty()) {
                if (words.contains("Ґ") || words.contains("ґ") || words.contains("Є") || words.contains("є") || words.contains("І") || words.contains("і")|| words.contains("ї") || words.contains("Ї")) {
                    elements.remove(i);
                }
            } else {
                elements.remove(i);
            }
        }
        return elements;
    }
}
