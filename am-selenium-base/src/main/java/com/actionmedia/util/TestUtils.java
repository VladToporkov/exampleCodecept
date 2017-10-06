package com.actionmedia.util;

import com.actionmedia.components.Document;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.jsoup.Jsoup;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

//import java.time.Month;
//import java.time.format.TextStyle;

public final class TestUtils {

    private TestUtils() {
    }

    private static final Logger logger = LoggerFactory.getLogger(TestUtils.class);

    private static final String DEFAULT_PATTERN = "dd MMMM";
    private static final String PATTERN_MONTH_AND_YEAR = "MMMMM yyyy";
    private static final int MAX_DIGIT_COUNT = 10;
    private static String pattern;

    private static List<String> bookmarkIds;

    private static List<Document> futureDocumentsWithoutDate;
    private static List<Document> futureDocumentsWithDate;

    public static String replaceIllegalCharacters(final String string) {
        return string.replace("- ", "").replace("‐", "-").replace("\n", " ").replaceAll(" ", " ");
    }

    public static String getOffset(WebElement element) {
        return element.getAttribute("style").split(":")[1].split("px")[0].trim();
    }

    public static double getHeightFromString(String heightString) {
        return Double.parseDouble(heightString.replace("px", ""));
    }

    public static int romanToDecimalConvert(String roman) {
        int decimal = 0;

        String romanNumeral = roman.toUpperCase();
        for (int x = 0; x < romanNumeral.length(); x++) {
            char convertToDecimal = roman.charAt(x);

            switch (convertToDecimal) {
                case 'M':
                    decimal += 1000;
                    break;

                case 'D':
                    decimal += 500;
                    break;

                case 'C':
                    decimal += 100;
                    break;

                case 'L':
                    decimal += 50;
                    break;

                case 'X':
                    decimal += 10;
                    break;

                case 'V':
                    decimal += 5;
                    break;

                case 'I':
                    decimal += 1;
                    break;
            }
        }
        if (romanNumeral.contains("IV")) {
            decimal -= 2;
        }
        if (romanNumeral.contains("IX")) {
            decimal -= 2;
        }
        if (romanNumeral.contains("XL")) {
            decimal -= 10;
        }
        if (romanNumeral.contains("XC")) {
            decimal -= 10;
        }
        if (romanNumeral.contains("CD")) {
            decimal -= 100;
        }
        if (romanNumeral.contains("CM")) {
            decimal -= 100;
        }
        return decimal;
    }

    public static Matcher<List<WebElement>> sortedInAscendingOrder() {
        return sorted(TextComparator.ASC);
    }

    public static Matcher<List<WebElement>> sortedInDescendingOrder() {
        return sorted(TextComparator.DESC);
    }

    public static Matcher<List<WebElement>> sortedDatesInAscendingOrder() {
        return sortedDates(DateComparator.ASC, DEFAULT_PATTERN);
    }

    public static Matcher<List<WebElement>> sortedDatesInDescendingOrder() {
        return sortedDates(DateComparator.DESC, DEFAULT_PATTERN);
    }

    public static Matcher<List<String>> sortedDatesStringsInDescendingOrder() {
        return sortedDatesStrings(DateComparator.DESC, PATTERN_MONTH_AND_YEAR);
    }

    public static Matcher<List<String>> sortedDatesStringsInDescendingOrderWithoutYear() {
        return sortedDatesStrings(DateComparator.DESC, DEFAULT_PATTERN);
    }

    public static Matcher<List<String>> sortedDatesStringsInDescendingOrder_DefaultPattern() {
        return sortedDatesStrings(DateComparator.DESC, DEFAULT_PATTERN);
    }

    public static Matcher<List<WebElement>> sortedDatesWithoutYearInAscendingOrder() {
        return sortedDates(DateWithoutYearComparator.ASC, DEFAULT_PATTERN);
    }

    public static Matcher<List<WebElement>> sortedDatesWithoutYearInDescendingOrder() {
        return sortedDates(DateWithoutYearComparator.DESC, DEFAULT_PATTERN);
    }

    public static Matcher<List<WebElement>> sorted(final Comparator<String> comparator) {
        return new TypeSafeMatcher<List<WebElement>>() {
            @Override
            protected boolean matchesSafely(final List<WebElement> webElements) {
                return isWebElementsSortedByText(webElements, comparator);
            }

            @Override
            public void describeTo(Description description) {
            }
        };
    }

    private static Matcher<List<WebElement>> sortedDates(final Comparator<String> comparator, final String pattern) {
        return new TypeSafeMatcher<List<WebElement>>() {
            @Override
            protected boolean matchesSafely(final List<WebElement> webElements) {
                synchronized (TestUtils.class) {
                    TestUtils.pattern = pattern;
                    return isWebElementsSortedByText(webElements, comparator);
                }
            }

            @Override
            public void describeTo(Description description) {
            }
        };
    }

    private static Matcher<List<String>> sortedDatesStrings(final Comparator<String> comparator, final String pattern) {
        return new TypeSafeMatcher<List<String>>() {
            @Override
            protected boolean matchesSafely(final List<String> dates) {
                synchronized (TestUtils.class) {
                    TestUtils.pattern = pattern;
                    return isStringsSorted(dates, comparator);
                }
            }

            @Override
            public void describeTo(Description description) {
            }
        };
    }

    public static Date parseDate(String date, String pattern) {
        final SimpleDateFormat sdf = getSimpleDateFormat(pattern);
        try {
            date = replaceString(date);
            return sdf.parse(date);
        } catch (ParseException e) {
            logger.error("ParseException occurs", e);
            return null;
        }
    }

    private enum TextComparator implements Comparator<String> {
        ASC {
            public int compare(String o1, String o2) {
                return getStringForSorting(o1).toLowerCase().compareTo(getStringForSorting(o2).toLowerCase());
            }
        },
        DESC {
            public int compare(String o1, String o2) {
                return -ASC.compare(o1, o2);
            }
        };

        private static String getStringForSorting(String stringForSorting) {
            final Pattern digitsPattern = Pattern.compile("\\d+");
            final java.util.regex.Matcher matcher = digitsPattern.matcher(stringForSorting);
            final StringBuffer buf = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(buf, appendZeros(matcher.group()));
            }
            matcher.appendTail(buf);
            return buf.toString();
        }

        private static String appendZeros(String str) {
            final int length = str.length();
            String result = str;
            if (length < MAX_DIGIT_COUNT) {
                for (int i = 0; i < MAX_DIGIT_COUNT - length; i++) {
                    result = "0" + result;
                }
            }
            return result;
        }

    }

    private enum DateComparator implements Comparator<String> {
        ASC {
            public int compare(String o1, String o2) {
                final DateFormat dateFormat = new SimpleDateFormat(pattern, getLocale());
                final Date date1;
                final Date date2;
                o1 = replaceString(o1);
                o2 = replaceString(o2);
                try {
                    date1 = dateFormat.parse(o1);
                    date2 = dateFormat.parse(o2);
                } catch (ParseException e) {
                    logger.info("ParseException occurs");
                    throw new AssertionError("Incorrect date format " + e);
                }
                return date1.compareTo(date2);
            }
        },
        DESC {
            public int compare(String o1, String o2) {
                return -ASC.compare(o1, o2);
            }
        }
    }

    public enum DateWithoutYearComparator implements Comparator<String> {
        ASC {
            @Override
            public int compare(String o1, String o2) {
                try {
                    int monthCompare;
                    int dayCompare;

                    o1 = replaceString(o1);
                    o2 = replaceString(o2);

                    String[] dateArr1 = o1.split(" ");
                    String[] dateArr2 = o2.split(" ");

                    String month1 = "";
                    String month2 = "";

                    int day1 = 0;
                    int day2 = 0;

                    for (String date : dateArr1) {
                        if (isNumber(date)) {
                            day1 = getNumberFromString(date);
                        } else {
                            month1 = date;
                        }
                    }

                    for (String date : dateArr2) {
                        if (isNumber(date)) {
                            day2 = getNumberFromString(date);
                        } else {
                            month2 = date;
                        }
                    }

                    int montIndex1 = MonthsOrder.fromString(month1).ordinal();
                    int montIndex2 = MonthsOrder.fromString(month2).ordinal();

                    if (montIndex2 == 12 && montIndex1 == 0) {
                        monthCompare = 1;
                    } else {
                        monthCompare = Integer.valueOf(montIndex1).compareTo(montIndex2);
                    }

                    dayCompare = Integer.valueOf(day1).compareTo(day2);

                    if (monthCompare >= 0) {
                        return 1;
                    } else if (monthCompare == 0) {
                        return dayCompare;
                    } else {
                        return -1;
                    }
                } catch (Exception e) {
                    logger.error("Exception occurs", e);
                    return 0;
                }
            }
        },
        DESC {
            @Override
            public int compare(String o1, String o2) {
                try {
                    int monthCompare;
                    int dayCompare;

                    o1 = replaceString(o1);
                    o2 = replaceString(o2);

                    String[] dateArr1 = o1.split(" ");
                    String[] dateArr2 = o2.split(" ");

                    String month1 = "";
                    String month2 = "";

                    int day1 = 0;
                    int day2 = 0;

                    for (String date : dateArr1) {
                        if (isNumber(date)) {
                            day1 = getNumberFromString(date);
                        } else {
                            month1 = date;
                        }
                    }

                    for (String date : dateArr2) {
                        if (isNumber(date)) {
                            day2 = getNumberFromString(date);
                        } else {
                            month2 = date;
                        }
                    }

                    int montIndex1 = MonthsOrder.fromString(month1).ordinal();
                    int montIndex2 = MonthsOrder.fromString(month2).ordinal();

                    if (montIndex2 == 12 && montIndex1 == 0) {
                        monthCompare = -1;
                    } else {
                        monthCompare = Integer.valueOf(montIndex2).compareTo(montIndex1);
                    }

                    dayCompare = Integer.valueOf(day2).compareTo(day1);

                    if (monthCompare < 0) {
                        return -1;
                    } else if (monthCompare == 0) {
                        return dayCompare;
                    } else {
                        return 1;
                    }
                } catch (Exception e) {
                    logger.error("Exception occurs", e);
                    return 0;
                }
            }
        };

        public enum MonthsOrder {
            january("янв"),
            february("фев"),
            march("мар"),
            april("апр"),
            may("май"),
            may1("мая"),
            june("июн"),
            july("июл"),
            august("авг"),
            september("сен"),
            october("окт"),
            november("ноя"),
            december("дек");

            private String text;

            MonthsOrder(String textString) {
                this.text = textString;
            }

            public String getText() {
                return this.text;
            }

            public static MonthsOrder fromString(String text) {
                if (text != null) {
                    for (MonthsOrder monthOrder : MonthsOrder.values()) {
                        if (text.toLowerCase().contains(monthOrder.text)) {
                            return monthOrder;
                        }
                    }
                }
                throw new IllegalArgumentException();
            }
        }
    }

    public static String replaceString(String string) {
        string = string.replaceAll("ря", "рь").replaceAll("ля", "ль").replaceAll("рта", "рт").replaceAll("ня", "нь");
        if (string.toLowerCase().contains("мая")) {
            String[] dayAndMonth = string.split(" ");
            return dayAndMonth[dayAndMonth.length - 2] + " май";
        }
        if (string.contains(",")) {
            return string.split(",")[1].trim();
        }
        return string.trim();
    }

    public static String monthToOriginalForm(String dateText) {
        return dateText.replaceAll("ря", "рь").replaceAll("ня", "нь").replaceAll("ля", "ль").replaceAll("рта", "рт").replaceAll("мая", "май").replaceAll("уста", "уст");
    }

    private static boolean isWebElementsSortedByText(final List<WebElement> webElements, final Comparator<String> comparator) {
        final List<String> elementsTextList = getElementsText(webElements);
        return isStringsSorted(elementsTextList, comparator);
    }

    private static boolean isStringsSorted(List<String> elementsTextList, Comparator<String> comparator) {
        for (int i = 0; i < elementsTextList.size() - 1; i++) {
            if (comparator.compare(elementsTextList.get(i), elementsTextList.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    private static List<String> getElementsText(List<WebElement> webElements) {
        final List<String> elementsTextList = new ArrayList<String>(webElements.size());
        for (WebElement element : webElements) {
            elementsTextList.add(element.getText());
        }
        return elementsTextList;
    }

    private static SimpleDateFormat getSimpleDateFormat(String pattern) {
        return new SimpleDateFormat(pattern, getLocale());
    }

    private static Locale getLocale() {
        return new Locale("ru");
    }

    public static boolean isNumber(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException ignored) {
            return false;
        }
    }

    public static int getNumberFromString(String text) {
        return Integer.parseInt(text);
    }

    public static boolean isElementContainsInArray(String element, String[] array) {
        for (String arrElement : array) {
            if (arrElement.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public static String getCurrentDateString(String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("ru"));
        return simpleDateFormat.format(new Date());
    }

    public static int getWeekNumberForToday() {
        Calendar calendar = new GregorianCalendar();
        Date trialTime = new Date();
        calendar.setTime(trialTime);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    public static String getRandomFutureDocumentWithoutDate() {
        if (futureDocumentsWithoutDate == null) {
            futureDocumentsWithoutDate = DBUtils.getFutureRedactionDocumentsListWithoutDate();
        }

        int number = 0;
        if (futureDocumentsWithoutDate.size() == 10) {
            number = new Random().nextInt(9);

        }
        if (futureDocumentsWithoutDate.isEmpty()) {
            throw new IllegalStateException("Документы из БД не получены. Проверьте доступ к БД и данные внутри таблицы");
        }

        Document document = futureDocumentsWithoutDate.get(number);
        String url = String.format("#/document/%s/%s/", document.getModuleId(), document.getDocumentId());

        return url;
    }

    public static String getRandomFutureDocumentWithDate() {
        if (futureDocumentsWithDate == null) {
            futureDocumentsWithDate = DBUtils.getFutureRedactionDocumentsList();
        }

        int number = 0;
        if (futureDocumentsWithDate.size() == 10) {
            number = new Random().nextInt(9);

        }
        if (futureDocumentsWithDate.isEmpty()) {
            throw new IllegalStateException("Документы из БД не получены. Проверьте доступ к БД и данные внутри таблицы");
        }

        Document document = futureDocumentsWithDate.get(number);
        String url = String.format("#/document/%s/%s/", document.getModuleId(), document.getDocumentId());

        return url;
    }

    public static String getShortDayNameByNumberDayOfWeek(int day) {
        if (day > 7 && day < 1) {
            throw new IllegalArgumentException("Day of week starts from 1, it's sunday," +
                    " and max value is 7, min value's 1");
        }

        switch (day) {
            case 2:
                return DAYOFWEEK.MONDAY.getShortDay();
            case 3:
                return DAYOFWEEK.TUESDAY.getShortDay();
            case 4:
                return DAYOFWEEK.WEDNESDAY.getShortDay();
            case 5:
                return DAYOFWEEK.THURSDAY.getShortDay();
            case 6:
                return DAYOFWEEK.FRIDAY.getShortDay();
            case 7:
                return DAYOFWEEK.SATURDAY.getShortDay();
            case 1:
                return DAYOFWEEK.SUNDAY.getShortDay();
            default:
                return DAYOFWEEK.MONDAY.getShortDay();
        }
    }

    private enum DAYOFWEEK {
        MONDAY("ПН"),
        TUESDAY("ВТ"),
        WEDNESDAY("СР"),
        THURSDAY("ЧТ"),
        FRIDAY("ПТ"),
        SATURDAY("СБ"),
        SUNDAY("ВС");

        private String shortDay;

        DAYOFWEEK(String shortDayOfWeek) {
            shortDay = shortDayOfWeek;
        }

        public String getShortDay() {
            return shortDay;
        }
    }

    /* Works only in java 1.8 */
    public static String getMonthNameInRussian(int numberOfMonth) {
//        Month month = Month.of(numberOfMonth);
//        Locale loc = Locale.forLanguageTag("ru");
//        return month.getDisplayName(TextStyle.FULL_STANDALONE, loc);
        return null;
    }

    public static void addDocumentsToFavorites(String[][] documents, WebDriver driver) throws URISyntaxException, IOException {
        Map<String, String> cookies = getCookiesFromDriver(driver);

        String host = new URI(driver.getCurrentUrl()).getHost();
        bookmarkIds = new ArrayList<String>();

        for (int i = 0; i < documents.length; i++) {
            org.jsoup.nodes.Document document =
                    Jsoup.connect("http://" + host + "/site/favorites/add-bookmark/")
                            .cookies(cookies)
                            .header("X-Requested-With", "XMLHttpRequest")
                            .data("modid", documents[i][0], "docid", documents[i][1], "anchor", "0", "folderid", "0", "snippet", "0")
                            .timeout(30000)
                            .post();
            bookmarkIds.add(document.select("[data-name=bookmarkId]").text());
        }
    }

    public static void removeDocumentsFromFavorites(WebDriver driver) throws URISyntaxException, IOException {
        Map<String, String> cookies = getCookiesFromDriver(driver);

        String host = new URI(driver.getCurrentUrl()).getHost();

        for (int i = 0; i < bookmarkIds.size(); i++) {
            Jsoup.connect("http://" + host +
                    String.format("/site/favorites/delete-bookmark/?bookmarkId=%s", bookmarkIds.get(i)))
                    .cookies(cookies)
                    .timeout(30000)
                    .get();
        }
    }

    private static Map<String, String> getCookiesFromDriver(WebDriver driver) {
        Set<Cookie> cookies = driver.manage().getCookies();
        Map<String, String> cookiesInMap = new HashMap<String, String>();
        Iterator iterator = cookies.iterator();
        while (iterator.hasNext()) {
            Cookie cookie = (Cookie) iterator.next();
            cookiesInMap.put(cookie.getName(), cookie.getValue());
        }
        return cookiesInMap;
    }

    public static int getUrlResponseCode(String url) {
        int responseCode;
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setInstanceFollowRedirects(true);
            con.setConnectTimeout(5000);

            responseCode = con.getResponseCode();
            con.disconnect();
        } catch (IOException e) {
            responseCode = HttpURLConnection.HTTP_INTERNAL_ERROR;
        }
        return responseCode;
    }

    /**
     * Sends the request and gets a response with 150 first items from new shelf on magazines page.
     * Doing that for the test which checks the 150 items contain one book at least. (just only for BSS, KSS, FSS and USS)
     * @param driver - webdriver for getting the host
     * @return string with response, contains first 150 items from new shelf on the magazines page.
     * @throws URISyntaxException
     * @throws IOException
     */
    public static String sendAJAXRequest_Get150MagazinesAndBooksFromPressNewShelf(WebDriver driver)
            throws URISyntaxException, IOException {
        String host = new URI(driver.getCurrentUrl()).getHost();
        return Jsoup.connect("http://" + host +
                "/system/content/press/shelf/?type=news&pos=1&size=150")    // pos=1 - first item in the new shelf
                                                                            // size=150 - count of items which was returned
                .timeout(120000) // timeout for 2 minutes
                .get().body().html(); // returns from 1 to 150 items in the magazines new shelf in html view.
    }
}
