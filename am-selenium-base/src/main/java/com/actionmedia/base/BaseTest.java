package com.actionmedia.base;

import com.actionmedia.annotations.*;
import com.actionmedia.autotest.EnvironmentValue;
import com.actionmedia.autotest.annotations.*;
import com.actionmedia.autotest.selenium.AbstractSeleniumTest;
import com.actionmedia.autotest.selenium.SeleniumHolder;
import com.actionmedia.autotest.selenium.context.Login;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.pages.LoginPage;
import com.actionmedia.pages.bss.BssBasePage;
import com.actionmedia.pages.cult.CultBasePage;
import com.actionmedia.pages.edu.EduBasePage;
import com.actionmedia.pages.elpu.ElpuBasePage;
import com.actionmedia.pages.fss.FssBasePage;
import com.actionmedia.pages.gf.GFBasePage;
import com.actionmedia.pages.go.GoBasePage;
import com.actionmedia.pages.klpu.KlpuBasePage;
import com.actionmedia.pages.kss.KssBasePage;
import com.actionmedia.pages.ot.OTBasePage;
import com.actionmedia.pages.umd.UmdBasePage;
import com.actionmedia.pages.uss.UssBasePage;
import com.actionmedia.service.MethodsInvoker;
import com.actionmedia.util.SgcrmUtils;
import com.actionmedia.util.TestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.ITestContext;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Step;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import static com.actionmedia.autotest.Group.kbk;
import static org.testng.Reporter.log;

@ContextConfiguration(locations = {
        "classpath*:/spring/component-scan.xml"
})
public abstract class BaseTest<P extends BaseTest> extends AbstractSeleniumTest {

    private MethodsInvoker methodsInvoker;

    private static final ThreadLocal<Login> loginHolder = new ThreadLocal<Login>();

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(final ITestContext context) {
        if (methodsInvoker == null) {
            new MethodsInvoker().invokeSuiteMethodsByAnnotation(BeforeSuiteCustom.class, context);
        } else {
            methodsInvoker.invokeSuiteMethodsByAnnotation(BeforeSuiteCustom.class, context);
        }
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite(final ITestContext context) {
        if (methodsInvoker == null) {
            new MethodsInvoker().invokeSuiteMethodsByAnnotation(AfterSuiteCustom.class, context);
        } else {
            methodsInvoker.invokeSuiteMethodsByAnnotation(AfterSuiteCustom.class, context);
        }
    }

    @BeforeClass(alwaysRun = true)
    public final void doBeforeClassMethods() {
        methodsInvoker.invokeMethodsByAnnotation(this, BeforeClassCustom.class);
    }

    @AfterClass(alwaysRun = true)
    public final void doAfterClassMethods() {
        methodsInvoker.invokeMethodsByAnnotation(this, AfterClassCustom.class);
    }

    @BeforeMethod(alwaysRun = true)
    public final void doBeforeMethods(final Method test) {
        methodsInvoker.invokeMethodsByAnnotation(this, BeforeMethodCustom.class);
        getLoginData(test);
        setSgcrmData();
    }

    @AfterMethod(alwaysRun = true)
    public final void doAfterMethods() {
        methodsInvoker.invokeMethodsByAnnotation(this, AfterMethodCustom.class);
        removeLoginData();
        try {
            SeleniumHolder.getWebDriver().manage().deleteAllCookies();
        } catch (Exception e) {
            logger.error("Delete all cookies with errors", e);
            System.out.println("Delete all cookies with errors");
        }
    }

    @BeforeGroups({kbk})
    public final void doBeforeGroups(final ITestContext context) {
        if (methodsInvoker == null) {
            new MethodsInvoker().invokeGroupMethodsByAnnotation(BeforeGroupsCustom.class, context);
        } else {
            methodsInvoker.invokeGroupMethodsByAnnotation(BeforeGroupsCustom.class, context);
        }
    }

    public synchronized void getLoginData(final Method test) {
        final SystemType system = test.getAnnotation(SystemType.class);
        if (system != null) {
            setSystemToSettings(system.systemPubs());
        }

        loginHolder.set(new Login(getSettings()));

        final Environment environment = test.getAnnotation(Environment.class);
        if (environment != null) {
            loginHolder.set(new Login(getSettings(), environment.environment()));
        }

        checkLoginAsAnnotations(test);
        checkLoginToAnnotations(test);
    }

    private void setSystemToSettings(SystemPubs system) {
        getSettings().setRunOss(true);
        getSettings().setSystemPubs(system);
    }

    public synchronized void getLoginData(final String loginAs) {
        loginHolder.set(new Login(getSettings()));
        updateLoginAsInfo(loginAs);
        loginHolder.get().setUrl(getSettings().getHost());
    }

    public synchronized void removeLoginData() {
        loginHolder.set(null);
    }

    protected synchronized KssBasePage getKssBasePage() {
        final KssBasePage basePage = getPage(KssBasePage.class, "");
        basePage.navigateToBasePage(loginHolder.get(), KssBasePage.class);
        return basePage;
    }

    protected synchronized KssBasePage getKssBasePageSizeWindow(int width, int height) {
        final KssBasePage basePage = getPage(KssBasePage.class, "");
        basePage.navigateToBasePageSizeWindow(loginHolder.get(), KssBasePage.class);
        basePage.setSizeWindows(width, height);
        return basePage;
    }

    protected synchronized BssBasePage getBssBasePageSizeWindow(int width, int height) {
        final BssBasePage basePage = getPage(BssBasePage.class, "");
        basePage.navigateToBasePageSizeWindow(loginHolder.get(), BssBasePage.class);
        basePage.setSizeWindows(width, height);
        return basePage;
    }

    protected synchronized UssBasePage getUssBasePageSizeWindow(int width, int height) {
        final UssBasePage basePage = getPage(UssBasePage.class, "");
        basePage.navigateToBasePageSizeWindow(loginHolder.get(), UssBasePage.class);
        basePage.setSizeWindows(width, height);
        return basePage;
    }

    protected synchronized FssBasePage getFssBasePageSizeWindow(int width, int height) {
        final FssBasePage basePage = getPage(FssBasePage.class, "");
        basePage.navigateToBasePageSizeWindow(loginHolder.get(), FssBasePage.class);
        basePage.setSizeWindows(width, height);
        return basePage;
    }

    protected synchronized BssBasePage getBssBasePage() {
        final BssBasePage basePage = getPage(BssBasePage.class, "");
        basePage.navigateToBasePage(loginHolder.get(), BssBasePage.class);
        return basePage;
    }

    protected synchronized UssBasePage getUssBasePage() {
        final UssBasePage basePage = getPage(UssBasePage.class, "");
        basePage.navigateToBasePage(loginHolder.get(), UssBasePage.class);
        return basePage;
    }

    protected synchronized FssBasePage getFssBasePage() {
        final FssBasePage basePage = getPage(FssBasePage.class, "");
        basePage.navigateToBasePage(loginHolder.get(), FssBasePage.class);
        return basePage;
    }

    protected synchronized UmdBasePage getUmdBasePage() {
        final UmdBasePage basePage = getPage(UmdBasePage.class, "");
        basePage.navigateToBasePage(loginHolder.get(), UmdBasePage.class);
        return basePage;
    }

    protected synchronized ElpuBasePage getElpuBasePage() {
        final ElpuBasePage basePage = getPage(ElpuBasePage.class, "");
        basePage.navigateToBasePage(loginHolder.get(), ElpuBasePage.class);
        return basePage;
    }

    protected synchronized KlpuBasePage getKlpuBasePage() {
        final KlpuBasePage basePage = getPage(KlpuBasePage.class, "");
        basePage.navigateToBasePage(loginHolder.get(), KlpuBasePage.class);
        return basePage;
    }

    protected synchronized CultBasePage getCultBasePage() {
        final CultBasePage basePage = getPage(CultBasePage.class, "");
        basePage.navigateToBasePage(loginHolder.get(), CultBasePage.class);
        return basePage;
    }

    protected synchronized EduBasePage getEduBasePage() {
        final EduBasePage basePage = getPage(EduBasePage.class, "");
        basePage.navigateToBasePage(loginHolder.get(), EduBasePage.class);
        return basePage;
    }

    protected synchronized OTBasePage getOtBasePage() {
        final OTBasePage basePage = getPage(OTBasePage.class, "");
        basePage.navigateToBasePage(loginHolder.get(), OTBasePage.class);
        return basePage;
    }

    protected synchronized GFBasePage getGfBasePage() {
        final GFBasePage basePage = getPage(GFBasePage.class, "");
        basePage.navigateToBasePage(loginHolder.get(), GFBasePage.class);
        return basePage;
    }

    protected synchronized GoBasePage getGoBasePage() {
        final GoBasePage basePage = getPage(GoBasePage.class, "");
        basePage.navigateToBasePage(loginHolder.get(), GoBasePage.class);
        return basePage;
    }

    protected synchronized GFBasePage getGFBasePage() {
        final GFBasePage basePage = getPage(GFBasePage.class, "");
        basePage.navigateToBasePage(loginHolder.get(), GFBasePage.class);
        return basePage;
    }

    protected synchronized LoginPage getLoginPage() {
        return navigateToLoginPage();
    }

    protected synchronized LoginPage getLoginPage(String url) {
        return navigateToLoginPage(url);
    }

    protected synchronized LoginPage navigateToLoginPage() {
        final LoginPage loginPage = getPage(LoginPage.class, "");
        loginPage.navigateTo(loginHolder.get(), LoginPage.class);
        return loginPage;
    }

    protected synchronized LoginPage navigateToLoginPage(String url) {
        final LoginPage loginPage = getPage(LoginPage.class, "");
        Login login = new Login(url);
        loginPage.navigateTo(login, LoginPage.class);
        return loginPage;
    }

    private synchronized void checkLoginAsAnnotations(final Method method) {
        final LoginAs loginAs = method.getAnnotation(LoginAs.class);
        final Environment environment = method.getAnnotation(Environment.class);
        if (loginAs != null) {
            updateLoginAsInfo(loginAs.key());
            if (environment != null) {
                updateLoginAsInfo(loginAs.key(), environment.environment());
            }
        }
    }

    private synchronized void checkLoginToAnnotations(final Method method) {
        String url = "";
        final Version version = method.getAnnotation(Version.class);
        final Environment environment = method.getAnnotation(Environment.class);
        if (version != null) {
            url = getSectionFromProperties(version.section());
            if (environment != null) {
                url = getSectionFromProperties(version.section(), environment.environment());
            }
        }
        loginHolder.get().setUrl(url);
    }

    private String getSectionFromProperties(String section) {
        return getSettings().getProperty(section);
    }

    private String getSectionFromProperties(String section, EnvironmentValue environmentValue) {
        return getSettings().getProperty(section);
    }

    protected String getLoginProperties(String key) {
        return getSettings().getProperty(key);
    }

    private String getLoginProperties(String key, EnvironmentValue environmentValue) {
        return getSettings().getProperty(key);
    }

    protected synchronized void updateLoginToInfo(String loginTo) {
//        new WebDriverFactory(getSettings()).createDriver(isFireFoxOnly());
        if (getSettings().isRunUss() && loginTo.equals("vip")) {
            loginTo = "doc";
        } else if (!getSettings().isRunUss() && loginTo.equals("doc")) {
            loginTo = "vip";
        }
        String url = getSectionFromProperties(loginTo) == null ? "" : getSectionFromProperties(loginTo);
        loginHolder.get().setUrl(url);
    }

    protected synchronized void updateLoginToInfo(String loginTo, EnvironmentValue environmentValue) {
//        new WebDriverFactory(getSettings()).createDriver(isFireFoxOnly());
        String url = getSectionFromProperties(loginTo, environmentValue) == null ? "" : getSectionFromProperties(loginTo, environmentValue);
        loginHolder.get().setUrl(url);
    }

    protected synchronized void updateLoginAsInfo(String loginAs) {
        loginHolder.get().setLogin(getLoginProperties(loginAs));
    }

    protected synchronized void updateLoginAsInfo(String loginAs, EnvironmentValue environmentValue) {
        loginHolder.get().setLogin(getLoginProperties(loginAs, environmentValue));
    }

    protected synchronized void updateSystemInfo(SystemPubs system) {
        setSystemToSettings(system);
        report("Тест для " + system.getDescription());
        loginHolder.set(new Login(getSettings()));
        loginHolder.get().setUrl(system, getSettings());
    }

    private boolean isFireFoxOnly() {
        Method[] methods = getClass().getMethods();
        for (Method method : methods) {
            FireFoxOnly fireFoxOnly = method.getAnnotation(FireFoxOnly.class);
            if (fireFoxOnly != null) {
                return true;
            }
        }
        return false;
    }

    protected String getDocumentUrlByKey(final String key) {
        return getSettings().getProperty(key);
    }

    protected String getFullDocumentUrlByKey(final String key) {
        return getSettings().getProperty(key);
    }

    @Step("{0}")
    protected P report(final String message) {
        log(message);
        return (P) this;
    }

    @Autowired
    public void setMethodsInvoker(MethodsInvoker methodsInvokerValue) {
        this.methodsInvoker = methodsInvokerValue;
    }

    protected String getLoginByKey(String key) {
        return getSettings().getProperty(key).split("\\|")[0];
    }

    protected String getPasswordByKey(String key) {
        return getSettings().getProperty(key).split("\\|")[1];
    }

    protected String getCurrentUrl() {
        return SeleniumHolder.getWebDriver().getCurrentUrl();
    }

    private List<String> getAllValuesFromPropertyForSystem(Properties properties, String systemName) {
        String currentUrl = "http://www." + getSettings().getHost();
        List<String> valueList = new ArrayList<String>();
        Enumeration e = properties.propertyNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            if (key.startsWith(systemName) && key.contains(".module")) {
                String value = properties.getProperty(key);
                valueList.add(currentUrl + value.split(".ru")[1]);
            }
        }
        return valueList;
    }

    /**
     * Returns the multiplicity of week number like a system version.
     * Now, one iteration is three week. Uses for test-cases, which
     * should be run for periodic time.
     */
    protected int getMultiplicityOfWeekNumber() {
        return (TestUtils.getWeekNumberForToday() / 3);
    }

    private void setSgcrmData() {
        SgcrmUtils.setSgcrmUrl(getSettings().getProperty("sgcrm.url"));
        SgcrmUtils.setSgcrmLogin(getSettings().getProperty("sgcrm.user").split("\\|")[0]);
        SgcrmUtils.setSgcrmPass(getSettings().getProperty("sgcrm.user").split("\\|")[1]);
    }
}
