package com.actionmedia.autotest.spring;

import com.actionmedia.autotest.selenium.SeleniumHolder;
import com.actionmedia.autotest.selenium.driver.WebDriverDecorator1;
import com.actionmedia.autotest.utils.OsUtils;
import com.opera.core.systems.OperaDriver;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import static com.actionmedia.autotest.selenium.SeleniumHolder.*;

public final class WebDriverFactory {

    private Log LOGGER = LogFactory.getLog(getClass());
    private static final String FIREFOX = "firefox";
    private static final String CHROME = "chrome";
    private static final String SAFARI = "safari";
    private static final String IE = "ie";
    private static final String IE11 = "ie11";
    private static final String IE10 = "ie10";
    private static final String IE9 = "ie9";
    private static final String OPERA = "opera";
    private static final String ANDROID = "android";
    private static final int MAX_COUNT_TO_TRY_INIT = 5;
    private SeleniumSettings settings;

    private static ThreadLocal<Integer> tryToStartCounter = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public WebDriverFactory(SeleniumSettings settings) {
        this.settings = settings;
    }

    public void createFirefoxOnlyDriver() throws Exception {
        quitWebDriver();
        DesiredCapabilities desiredCapabilities = getFireFoxDesiredCapabilities();
        setDriverName(FIREFOX);
        final EventFiringWebDriver driver;
        if (settings.isRunTestsWithGrid()) {
            driver = new EventFiringWebDriver(new WebDriverDecorator1(new RemoteWebDriver(new URL(settings.getGridHubUrl()), desiredCapabilities)));
        } else {
            driver = new EventFiringWebDriver(new WebDriverDecorator1(firefox()));
        }
        addShutdownHook(driver);
        setWebDriver(driver);
    }

    public void createDriver(boolean isFireFoxOnly) {
        System.setProperty("http.maxConnections", "1000000");
        System.setProperty("http.keepAlive", "false");
        try {
            if (isFireFoxOnly) {
                createFirefoxOnlyDriver();
            } else {

                if (getWebDriver() != null) {
                    quitWebDriver();
                }

                //for set browser from xml parameters
                if (getWebDriver() != null && !getParameterBrowserName().equals("browser") && !getParameterBrowserName().equals(getDriverName())) {
                    quitWebDriver();
                }

                if (getWebDriver() == null) {
                    final EventFiringWebDriver driver = new EventFiringWebDriver(new WebDriverDecorator1(initWebDriver(settings)));
                    addShutdownHook(driver);
                    setWebDriver(driver);
                }
            }
        } catch (Throwable t) {
            LOGGER.error("*****" + t.getClass().toString() + " occurred when initializing webdriver*****", t);
            if (tryToStartCounter.get() < MAX_COUNT_TO_TRY_INIT) {
                tryToStartCounter.set(tryToStartCounter.get() + 1);
                createDriver(isFireFoxOnly);
            }
        }
    }

    private void quitWebDriver() {
        try {
            log("*****Quit webdriver*****");
            getWebDriver().quit();
        } catch (Throwable t) {
            LOGGER.error("*****ERROR***** TRYING TO QUIT DRIVER " + t.getMessage());
        } finally {
            SeleniumHolder.setWebDriver(null);
        }
    }

    private WebDriver initWebDriver(SeleniumSettings settings) throws MalformedURLException {
        String browserName = settings.getDriverName();
        if (settings.isRunTestsWithGrid()) {

            //for set browser from xml parameters
            if (!getParameterBrowserName().equals("browser")) {
                browserName = getParameterBrowserName();
                setParameterBrowserName("browser");
            }

            DesiredCapabilities desiredCapabilities;
            if (StringUtils.equalsIgnoreCase(browserName, CHROME)) {
                desiredCapabilities = getChromeDesiredCapabilities();
                setDriverName(CHROME);
            } else if (StringUtils.equalsIgnoreCase(browserName, IE)) {
                desiredCapabilities = getIEDesiredCapabilities();
                setDriverName(IE);
            } else if (StringUtils.equalsIgnoreCase(browserName, IE11)) {
                desiredCapabilities = getIEDesiredCapabilities("11");
                setDriverName(IE11);
            } else if (StringUtils.equalsIgnoreCase(browserName, IE10)) {
                desiredCapabilities = getIEDesiredCapabilities("10");
                setDriverName(IE10);
            } else if (StringUtils.equalsIgnoreCase(browserName, IE9)) {
                desiredCapabilities = getIEDesiredCapabilities("9");
                setDriverName(IE9);
            } else if (StringUtils.equalsIgnoreCase(browserName, OPERA)) {
                desiredCapabilities = getOperaDesiredCapabilities();
                setDriverName(OPERA);
            } else if (StringUtils.equalsIgnoreCase(browserName, SAFARI)) {
                desiredCapabilities = getSafariDesiredCapabilities();
                setDriverName(SAFARI);
            } else if (StringUtils.equalsIgnoreCase(browserName, ANDROID)) {
                desiredCapabilities = getAndroidDesiredCapabilities();
                setDriverName(ANDROID);
            } else if (StringUtils.equalsIgnoreCase(browserName, FIREFOX)) {
                desiredCapabilities = getFireFoxDesiredCapabilities();
                setDriverName(FIREFOX);
            } else {
                throw new RuntimeException("Not supported browser: " + browserName);
            }

            return new RemoteWebDriver(new URL(settings.getGridHubUrl()), desiredCapabilities);
        } else {

            //for set browser from xml parameters
            if (!getParameterBrowserName().equals("browser")) {
                browserName = getParameterBrowserName();
                setParameterBrowserName("browser");
            }

            if (StringUtils.equalsIgnoreCase(browserName, FIREFOX)) {
                setDriverName(FIREFOX);
                return firefox();
            } else if (StringUtils.equalsIgnoreCase(browserName, CHROME)) {
                setDriverName(CHROME);
                return chrome();
            } else if (StringUtils.equalsIgnoreCase(browserName, IE)) {
                setDriverName(IE);
                return explorer();
            } else if (StringUtils.equalsIgnoreCase(browserName, IE10)) {
                setDriverName(IE10);
                return explorer("10");
            } else if (StringUtils.equalsIgnoreCase(browserName, IE9)) {
                setDriverName(IE9);
                return explorer("9");
            } else if (StringUtils.equalsIgnoreCase(browserName, OPERA)) {
                setDriverName(OPERA);
                return opera();
            } else {
                throw new RuntimeException("Not supported browser: " + browserName);
            }
        }
    }

    private DesiredCapabilities getAndroidDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", "Android");
        capabilities.setCapability("app", "Chrome");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        return capabilities;
    }

    private WebDriver firefox() {
        return new FirefoxDriver(getFireFoxDesiredCapabilities());
    }

    private DesiredCapabilities getFireFoxDesiredCapabilities() {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
        capabilities.setCapability(FirefoxDriver.PROFILE, getFirefoxProfile());

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        logPrefs.enable(LogType.CLIENT, Level.ALL);
        logPrefs.enable(LogType.SERVER, Level.ALL);
        logPrefs.enable(LogType.PROFILER, Level.ALL);
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        return capabilities;
    }

    private DesiredCapabilities getIEDesiredCapabilities() {
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        logPrefs.enable(LogType.CLIENT, Level.ALL);
        logPrefs.enable(LogType.SERVER, Level.ALL);
        logPrefs.enable(LogType.PROFILER, Level.ALL);
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        return capabilities;
    }

    private DesiredCapabilities getIEDesiredCapabilities(String version) {
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
        capabilities.setVersion(version);

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        logPrefs.enable(LogType.CLIENT, Level.ALL);
        logPrefs.enable(LogType.SERVER, Level.ALL);
        logPrefs.enable(LogType.PROFILER, Level.ALL);
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        return capabilities;
    }

    private DesiredCapabilities getOperaDesiredCapabilities() {
        DesiredCapabilities capabilities = DesiredCapabilities.opera();
        capabilities.setJavascriptEnabled(true);

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        logPrefs.enable(LogType.CLIENT, Level.ALL);
        logPrefs.enable(LogType.SERVER, Level.ALL);
        logPrefs.enable(LogType.PROFILER, Level.ALL);
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        return capabilities;
    }

    private DesiredCapabilities getChromeDesiredCapabilities() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("--disable-extensions");
        capabilities.setCapability("chrome.binary", "/drivers/chromedriver.exe");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        logPrefs.enable(LogType.CLIENT, Level.ALL);
        logPrefs.enable(LogType.SERVER, Level.ALL);
        logPrefs.enable(LogType.PROFILER, Level.ALL);
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        return capabilities;
    }

    private DesiredCapabilities getSafariDesiredCapabilities() {
        DesiredCapabilities capabilities = DesiredCapabilities.safari();

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        logPrefs.enable(LogType.CLIENT, Level.ALL);
        logPrefs.enable(LogType.SERVER, Level.ALL);
        logPrefs.enable(LogType.PROFILER, Level.ALL);
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        return capabilities;
    }

    private FirefoxProfile getFirefoxProfile() {
        final FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("dom.max_chrome_script_run_time", 999);
        profile.setPreference("dom.max_script_run_time", 999);
        profile.setPreference("network.cookie.cookieBehavior", 0);
        profile.setPreference("dom.ipc.plugins.enabled", false);
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(true);
        return profile;
    }

    private WebDriver chrome() {
        if (OsUtils.isMac()) {
            System.setProperty("webdriver.chrome.driver", getClass().getResource("/drivers/chromedriver").getFile());
        } else { // thinking that other systems are Windows
            System.setProperty("webdriver.chrome.driver", getClass().getResource("/drivers/chromedriver.exe").getFile());
        }
        return new ChromeDriver(getChromeDesiredCapabilities());
    }

    private WebDriver explorer() {
        System.setProperty("webdriver.ie.driver", getClass().getResource("/drivers/IEDriverServer.exe").getFile());
        return new InternetExplorerDriver(getIEDesiredCapabilities());
    }

    private WebDriver explorer(String version) {
        System.setProperty("webdriver.ie.driver", getClass().getResource("/drivers/IEDriverServer.exe").getFile());
        return new InternetExplorerDriver(getIEDesiredCapabilities(version));
    }

    private WebDriver opera() {
        return new OperaDriver(getOperaDesiredCapabilities());
    }

    private void addShutdownHook(final WebDriver driver) {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    log("Delete cookies");
                    driver.manage().deleteAllCookies();
                    log("Driver quit");
                    driver.quit();
                } catch (Throwable t) {
                    LOGGER.error("Throwable occurs", t);
                } finally {
                    log("Finally driver quit");
                    driver.quit();
                }
            }
        });
    }

    private void log(String log) {
        System.out.println(log);
        LOGGER.info(log);
    }
}
