package com.actionmedia.util;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Provides methods for working with SGCRM.
 * Sends requests and returns a {@link org.jsoup.nodes.Document} which created after getting response
 */
public final class SgcrmUtils {

    private static Map<String, String> cookies;

    private static String sgcrmUrl;
    private static String sgcrmLogin;
    private static String sgcrmPass;

    private SgcrmUtils() throws IOException {
        cookies = getCookies();
    }

    public static Map<String, String> getCookies() throws IOException {
        Map<String, String> cookies = new HashMap<String, String>();

        Connection.Response res = Jsoup.connect(sgcrmUrl + "/login.aspx")
                .data("login", sgcrmLogin, "pass", sgcrmPass)
                .method(Connection.Method.POST)
                .execute();

        Document doc = res.parse();
        String sessionId = res.cookie("ASP.NET_SessionId");
        String aspxAuth = res.cookie(".ASPXAUTH");
        if (sessionId.isEmpty()) {
            throw new IllegalStateException("Cookie достать не получилось для sgcrm");
        }
        cookies.put(".ASPXAUTH", aspxAuth);
        cookies.put("ASP.NET_SessionId", sessionId);
        return cookies;
    }

    public static Document getQuestionFromHotline(String id) throws IOException {
        return Jsoup.connect(String.format(sgcrmUrl + "/hotline/get-questions.aspx?noauth=1&qid=%s&page=1&ret=plain", id))
                .cookies(cookies)
                .get();
    }

    public static void removeQuestionFromHotline(String id) throws IOException {
        Jsoup.connect(sgcrmUrl + "/hotline/remove-q.aspx")
                .data("qid", String.format("%s|0", id), "comment", " ")
                .cookies(cookies)
                .post();
    }

    public static void setSgcrmUrl(String sgcrmUrl) {
        SgcrmUtils.sgcrmUrl = sgcrmUrl;
    }

    public static void setSgcrmLogin(String sgcrmLogin) {
        SgcrmUtils.sgcrmLogin = sgcrmLogin;
    }

    public static void setSgcrmPass(String sgcrmPass) {
        SgcrmUtils.sgcrmPass = sgcrmPass;
    }
}
