package com.actionmedia.autotest.selenium.context;

import com.actionmedia.autotest.EnvironmentValue;
import com.actionmedia.autotest.spring.SeleniumSettings;
import com.actionmedia.autotest.utils.SystemPubs;

public class Login {
    private String user = null;
    private String password = null;
    private String url = "";
    private String baseUrl = "";
    private SeleniumSettings settings;

    public Login(SeleniumSettings settings) {
        this.settings = settings;
        baseUrl = settings.createUrl();
    }

    public Login(String url) {
        this.baseUrl = url;
    }

    public Login(SeleniumSettings settings, EnvironmentValue environmentValue) {
        baseUrl = settings.createUrl(environmentValue);
    }

    public void setLogin(final String login) {
        if (login != null) {
            final String[] s = login.split("\\|");
            if (s.length == 2) {
                user = s[0];
                password = s[1];
            }
        }
    }

    public String getUrl() {
        if (url.isEmpty()) {
            return baseUrl;
        } else if (settings.isRunExpertusK() && settings.isRunProduction() && url.equals("vip")) {
            return baseUrl.replace("1k", "1k-vip");
        } else if (settings.isRunExpertusGl() && settings.isRunProduction() && url.equals("vip")) {
            return baseUrl.replace("1gl", "1gl-vip");
        } else if (settings.isRunActualisEdu() && settings.isRunProduction()) {
            if (url.equals("vip")) {
                return baseUrl.replace("optimal-edu", "vip-edu");
            } else if (url.equals("mini")) {
                return baseUrl.replace("optimal-edu", "standart-edu");
            } else {
                return baseUrl;
            }
        } else if (settings.isRunActualisK() && settings.isRunProduction()) {
            if (url.equals("vip")) {
                return baseUrl.replace("optimal-kadry", "vip-kadry");
            } else if (url.equals("mini")) {
                return baseUrl.replace("optimal-kadry", "standart-kadry");
            } else {
                return baseUrl;
            }
        } else if (settings.isRunActualisGz()) {
            if (settings.isRunProduction()) {
                if (url.equals("zakaz")) {
                    return baseUrl.replace("postav-gz", "zakaz-gz");
                } else if (url.equals("vip")) {
                    return baseUrl.replace("postav-gz", "vip-gz");
                } else {
                    return baseUrl;
                }
            } else {
                if (url.isEmpty()) {
                    return baseUrl;
                } else {
                    return baseUrl.replace("pos", url);
                }
            }
        } else {
            return baseUrl.replace("http://", "http://" + url + ".");
        }
    }

    public void setUrl(final String urlString) {
        this.url = urlString;
    }

    public void setUrl(SystemPubs systemPubs, SeleniumSettings seleniumSettings) {
        String systemName = systemPubs.toString();
        if (systemName.endsWith("bu")) {
            this.url = seleniumSettings.getProperty("budget");
        } else if (systemName.endsWith("usn")) {
            this.url = seleniumSettings.getProperty("usn");
        } else if (systemName.endsWith("vip")) {
            this.url = seleniumSettings.getProperty("vip");
        } else if (systemName.endsWith("doc")) {
            this.url = seleniumSettings.getProperty("doc");
        } else if (systemName.endsWith("mini")) {
            this.url = seleniumSettings.getProperty("mini");
        } else {
            this.url = "";
        }
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
