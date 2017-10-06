package com.actionmedia.tests.functional.bss.content.otchet;

import com.actionmedia.autotest.listeners.Smsc;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;
import java.util.Map;

public class OtchetTest {

    @Test
    public void test() {
        try {
            Connection.Response res = Jsoup
                    .connect("http://vip.1gl.ru/site/customer/login/")
                    .data("login", "asam")
                    .data("password", "1234")
                    .data("isremember", "no")
                    .ignoreHttpErrors(true)
                    .method(Connection.Method.POST)
                    .timeout(0)
                    .execute();
            Map<String, String> cookies = res.cookies();

            String text = Jsoup
                    .connect("https://otchet.1gl.ru/documents/")
                    .cookies(cookies)
                    .ignoreHttpErrors(true)
                    .ignoreContentType(true)
                    .timeout(0)
                    .get()
                    .text()
                    .trim();
            System.out.println("Текст - " + text);
            report("Текст - " + text);
            if (text.equalsIgnoreCase("500")) {
                sendSms("https://otchet.1gl.ru/documents/ 500 ошибка");
                Assert.assertEquals(text, "null", "https://otchet.1gl.ru/documents/ 500 ошибка");
            }
        } catch (IOException e) {
            System.out.println("IOException occurs " + e.getMessage());
        }
    }

    @Step("{0}")
    private void report(String report) {
        Reporter.log(report);
    }

    @Step("{0}")
    private void sendSms(String message) {
        String login = "aktion";
        String password = "45vb0915";
        String phones = "79250512577,79037419673,79161624521,79153502209,79269185682,79265758279";
        Smsc smsc = new Smsc(login, password);

        /**
         * Отправка SMS
         *
         * @param phones   - список телефонов через запятую или точку с запятой
         * @param message  - отправляемое сообщение
         * @param translit - переводить или нет в транслит (1,2 или 0)
         * @param time     - необходимое время доставки в виде строки (DDMMYYhhmm, h1-h2, 0ts, +m)
         * @param id       - идентификатор сообщения. Представляет собой 32-битное число в диапазоне от 1 до 2147483647.
         * @param format   - формат сообщения (0 - обычное sms, 1 - flash-sms, 2 - wap-push, 3 - hlr, 4 - bin, 5 - bin-hex, 6 - ping-sms)
         * @param sender   - имя отправителя (Sender ID). Для отключения Sender ID по умолчанию необходимо в качестве имени передать пустую строку или точку.
         * @param query    - строка дополнительных параметров, добавляемая в URL-запрос ("valid=01:00&maxsms=3&tz=2")
         * @return array (<id>, <количество sms>, <стоимость>, <баланс>) в случае успешной отправки
         * или массив (<id>, -<код ошибки>) в случае ошибки
         */

        String[] answer = smsc.send_sms(phones, message, 0, "", "", 0, "autotester", "");

        if (answer.length > 2) {
            String id = answer[0];
            String count = answer[1];
            String cost = answer[2];
            String balance = answer[3];

            String response = "Сообщение отправлено. id: " + id + " количество sms: " + count + " стоимость: " + cost + " баланс:" + balance;
            Reporter.log(response);
        } else {
            String id = answer[0];
            String error = answer[1];

            String response = "Сообщение не отправлено. id: " + id + " номер ошибки:" + error;
            Reporter.log(response);
        }
    }
}
