package com.actionmedia.autotest.spring;

import com.actionmedia.autotest.EnvironmentValue;
import com.actionmedia.autotest.utils.SystemPubs;

import java.util.Properties;

import static com.actionmedia.autotest.utils.SystemPubs.localhost;

public class SeleniumSettings extends Properties {

    private static final String APPLICATION_SELENIUM_DRIVER_PROP_KEY = "application.selenium.driver";
    private static final String RUN_TESTS_WITH_GRID_PROP_KEY = "run.tests.with.grid";
    private static final String GRID_HUB_URL_PROP_KEY = "grid.hub.url";
    private String host = "localhost";

    private String environment;
    private String fileName;
    private CustomPropertyPlaceholderConfigurer propertyConfigurer;

    private static ThreadLocal<SystemPubs> systemPubs = new ThreadLocal<SystemPubs>() {
        @Override
        protected SystemPubs initialValue() {
            return localhost;
        }
    };

    private static ThreadLocal<Boolean> isRunOss = new ThreadLocal<Boolean>() {
        @Override
        protected Boolean initialValue() {
            return false;
        }
    };

    public void init() {
        propertyConfigurer.copyTo(environment, this);
    }

    public boolean getAsBoolean(String name) {
        return Boolean.valueOf(getProperty(name));
    }

    public int getAsInteger(String name) {
        return Integer.valueOf(getProperty(name));
    }

    public String getEnvironment() {
        return environment;
    }

    public void setDriverName(String driverName) {
        setProperty(APPLICATION_SELENIUM_DRIVER_PROP_KEY, driverName);
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public void setPropertyConfigurer(final CustomPropertyPlaceholderConfigurer propertyConfigurer) {
        this.propertyConfigurer = propertyConfigurer;
    }

    public void setRunOss(boolean runOss) {
        isRunOss.set(runOss);
    }

    public String getDriverName() {
        return getProperty(APPLICATION_SELENIUM_DRIVER_PROP_KEY);
    }

    public boolean isRunTestsWithGrid() {
        return getAsBoolean(RUN_TESTS_WITH_GRID_PROP_KEY);
    }

    public String getGridHubUrl() {
        return getProperty(GRID_HUB_URL_PROP_KEY);
    }

    public boolean isRunProduction() {
        return environment.equals("PRODUCTION");
    }

    public boolean isRunTbd() {
        return environment.equals("RT");
    }

    public boolean isRunRT() {
        return environment.equals("RT");
    }

    public boolean isRunWeb13() {
        return environment.equals("CLUSTER")
                || environment.equals("WEB11")
                || environment.equals("WEB12")
                || environment.equals("WEB13")
                || environment.equals("WEB21")
                || environment.equals("WEB22")
                || environment.equals("WEB23");
    }

    public boolean isRunProk1() {
        return environment.equals("PROK");
    }

    public boolean isRunCI() {
        return environment.equals("CI");
    }

    public boolean isRunBss() {
        return systemPubs.get().equals(SystemPubs.bss) ||
                systemPubs.get().equals(SystemPubs.bss_usn) ||
                systemPubs.get().equals(SystemPubs.bss_bu) ||
                systemPubs.get().equals(SystemPubs.bss_vip) ||
                getAsBoolean("run.bss");
    }

    public boolean isRunKss() {
        return systemPubs.get().equals(SystemPubs.kss) ||
                systemPubs.get().equals(SystemPubs.kss_bu) ||
                systemPubs.get().equals(SystemPubs.kss_vip) ||
                getAsBoolean("run.kss");
    }

    public boolean isRunUss() {
        return systemPubs.get().equals(SystemPubs.uss) ||
                systemPubs.get().equals(SystemPubs.uss_bu) ||
                systemPubs.get().equals(SystemPubs.uss_vip) ||
                getAsBoolean("run.uss");
    }

    public boolean isRunFss() {
        return systemPubs.get().equals(SystemPubs.fss) ||
                getAsBoolean("run.fss");
    }

    public boolean isRunGf() {
        return systemPubs.get().equals(SystemPubs.gf) ||
                systemPubs.get().equals(SystemPubs.gf_vip) ||
                getAsBoolean("run.gf");
    }

    public boolean isRunGo() {
        return systemPubs.get().equals(SystemPubs.go) ||
                systemPubs.get().equals(SystemPubs.go_mini) ||
                systemPubs.get().equals(SystemPubs.go_vip) ||
                getAsBoolean("run.go");
    }

    public boolean isRunEhs() {
        return systemPubs.get().equals(SystemPubs.ehs) ||
                systemPubs.get().equals(SystemPubs.ehs_bu) ||
                systemPubs.get().equals(SystemPubs.ehs_mini) ||
                systemPubs.get().equals(SystemPubs.ehs_vip) ||
                getAsBoolean("run.ehs");
    }

    public boolean isRunEdu() {
        return systemPubs.get().equals(SystemPubs.edu) ||
                systemPubs.get().equals(SystemPubs.edu_mini) ||
                systemPubs.get().equals(SystemPubs.edu_vip) ||
                getAsBoolean("run.edu");
    }

    public boolean isRunElpu() {
        return systemPubs.get().equals(SystemPubs.elpu) ||
                systemPubs.get().equals(SystemPubs.elpu_vip) ||
                getAsBoolean("run.elpu");
    }

    public boolean isRunKlpu() {
        return systemPubs.get().equals(SystemPubs.klpu) ||
                systemPubs.get().equals(SystemPubs.klpu_vip) ||
                getAsBoolean("run.klpu");
    }

    public boolean isRunCult() {
        return systemPubs.get().equals(SystemPubs.cult) ||
                systemPubs.get().equals(SystemPubs.cult_vip) ||
                getAsBoolean("run.cult");
    }

    public boolean isRunUmd() {
        return systemPubs.get().equals(SystemPubs.umd) ||
                systemPubs.get().equals(SystemPubs.umd_mini) ||
                systemPubs.get().equals(SystemPubs.umd_vip) ||
                getAsBoolean("run.umd");
    }

    public boolean isRunExpertusK() {
        return systemPubs.get().equals(SystemPubs.expertus_k) ||
                systemPubs.get().equals(SystemPubs.expertus_k_vip) ||
                getAsBoolean("run.expertus_k");
    }

    public boolean isRunExpertusGl() {
        return systemPubs.get().equals(SystemPubs.expertus_gl) ||
                systemPubs.get().equals(SystemPubs.expertus_gl_vip) ||
                getAsBoolean("run.expertus_gl");
    }

    public boolean isRunActualisEdu() {
        return systemPubs.get().equals(SystemPubs.actualis_edu) ||
                systemPubs.get().equals(SystemPubs.actualis_edu_mini) ||
                systemPubs.get().equals(SystemPubs.actualis_edu_vip) ||
                getAsBoolean("run.actualis_edu");
    }

    public boolean isRunActualisK() {
        return systemPubs.get().equals(SystemPubs.actualis_k) ||
                systemPubs.get().equals(SystemPubs.actualis_k_mini) ||
                systemPubs.get().equals(SystemPubs.actualis_k_vip) ||
                getAsBoolean("run.actualis_k");
    }

    public boolean isRunActualisGz() {
        return systemPubs.get().equals(SystemPubs.actualis_gz) ||
                systemPubs.get().equals(SystemPubs.actualis_gz_vip) ||
                systemPubs.get().equals(SystemPubs.actualis_gz_zak) ||
                getAsBoolean("run.actualis_gz");
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setSystemPubs(SystemPubs systemPubs) {
        this.systemPubs.set(systemPubs);
    }

    public void setHost(final String host) {
        this.host = host;
    }

    public String getHost() {
        if (!isRunOss.get() && !getAsBoolean("run.oss")){
            return getHostForNotOss();
        }
        switch (systemPubs.get()) {
            case bss:
                return getProperty("bss.host");
            case bss_bu:
                return getProperty("bss.host");
            case bss_usn:
                return getProperty("bss.host");
            case bss_vip:
                return getProperty("bss.host");
            case kss:
                return getProperty("kss.host");
            case kss_bu:
                return getProperty("kss.host");
            case kss_vip:
                return getProperty("kss.host");
            case uss:
                return getProperty("uss.host");
            case uss_bu:
                return getProperty("uss.host");
            case uss_vip:
                return getProperty("uss.host");
            case fss:
                return getProperty("fss.host");
            case gf:
                return getProperty("gf.host");
            case ehs:
                return getProperty("ehs.host");
            case ehs_bu:
                return getProperty("ehs.host");
            case ehs_mini:
                return getProperty("ehs.host");
            case ehs_vip:
                return getProperty("ehs.host");
            case edu:
                return getProperty("edu.host");
            case edu_mini:
                return getProperty("edu.host");
            case edu_vip:
                return getProperty("edu.host");
            case go:
                return getProperty("go.host");
            case go_mini:
                return getProperty("go.host");
            case go_vip:
                return getProperty("go.host");
            case elpu:
                return getProperty("elpu.host");
            case elpu_vip:
                return getProperty("elpu.host");
            case klpu:
                return getProperty("klpu.host");
            case klpu_vip:
                return getProperty("klpu.host");
            case cult:
                return getProperty("cult.host");
            case cult_vip:
                return getProperty("cult.host");
            case umd:
                return getProperty("umd.host");
            case umd_mini:
                return getProperty("umd.host");
            case umd_vip:
                return getProperty("umd.host");
            case expertus_k:
                return getProperty("expertus_k.host");
            case expertus_k_vip:
                return getProperty("expertus_k.host");
            case expertus_gl:
                return getProperty("expertus_gl.host");
            case expertus_gl_vip:
                return getProperty("expertus_gl.host");
            case actualis_edu:
                return getProperty("actualis_edu.host");
            case actualis_gz:
                return getProperty("actualis_gz.host");
            case actualis_k:
                return getProperty("actualis_k.host");
            case actualis_k_mini:
                return getProperty("actualis_k.host");
            case actualis_k_vip:
                return getProperty("actualis_k.host");
            case localhost:
                return host;
            default:
                return host;
        }
    }

    private String getHostForNotOss() {
        if (getAsBoolean("run.bss")){
            return getProperty("bss.host");
        }
        if (getAsBoolean("run.kss")){
            return getProperty("kss.host");
        }
        if (getAsBoolean("run.uss")){
            return getProperty("uss.host");
        }
        if (getAsBoolean("run.fss")){
            return getProperty("fss.host");
        }
        if (getAsBoolean("run.ehs")){
            return getProperty("ehs.host");
        }
        if (getAsBoolean("run.gf")){
            return getProperty("gf.host");
        }
        if (getAsBoolean("run.go")){
            return getProperty("go.host");
        }
        if (getAsBoolean("run.edu")){
            return getProperty("edu.host");
        }
        if (getAsBoolean("run.elpu")){
            return getProperty("elpu.host");
        }
        if (getAsBoolean("run.klpu")){
            return getProperty("klpu.host");
        }
        if (getAsBoolean("run.cult")){
            return getProperty("cult.host");
        }
        if (getAsBoolean("run.umd")){
            return getProperty("umd.host");
        }
        if (getAsBoolean("run.expertus_k")){
            return getProperty("expertus_k.host");
        }
        if (getAsBoolean("run.expertus_gl")){
            return getProperty("expertus_gl.host");
        }
        if (getAsBoolean("run.actualis_edu")){
            return getProperty("actualis_edu.host");
        }
        if (getAsBoolean("run.actualis_gz")){
            return getProperty("actualis_gz.host");
        }
        if (getAsBoolean("run.actualis_k")){
            return getProperty("actualis_k.host");
        }
        return host;
    }

    public String createUrl() {
        return String.format("http://%s", getHost());
    }

    public String createUrl(EnvironmentValue environmentValue) {
        return String.format("http://%s", getHost(environmentValue));
    }

    public String getHost(EnvironmentValue environmentValue) {
        return "";
    }

    public String getSearchServiceUrl() {
        return getProperty("search.service.url");
    }

    public String getSearchExtendedServiceUrl() {
        return getProtocolPrefix() + getHost() + getProperty("search.extended.service.part.url");
    }

    public String getSearchExtendedServiceUrl(String systemName) {
        if (systemName == null || systemName.isEmpty()) {
            return getSearchExtendedServiceUrl();
        }
        return getProtocolPrefix()  + getProperty(systemName + ".host") + getProperty("search.extended.service.part.url");
    }

    public String getExportNPDServiceUrl() {
        return getProperty("export.npd.service.url");
    }

    public String getGlavbukhServiceUrl() {
        return getProtocolPrefix()  + getHost() + getProperty("glavbukh.service.part.url");
    }

    public String getBuhOnLineServiceUrl() {
        return "http://vip." + getProperty("bss.host") + getProperty("buhonline.service.part.url");
    }

    private String getProtocolPrefix() {
        return isRunProduction() ? "http://www." : "http://";
    }
}
