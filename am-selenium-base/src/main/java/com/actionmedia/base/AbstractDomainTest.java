package com.actionmedia.base;

import com.actionmedia.pages.bss.BssBasePage;
import com.actionmedia.pages.cult.CultBasePage;
import com.actionmedia.pages.edu.EduBasePage;
import com.actionmedia.pages.elpu.ElpuBasePage;
import com.actionmedia.pages.fss.FssBasePage;
import com.actionmedia.pages.gf.GFBasePage;
import com.actionmedia.pages.go.GoBasePage;
import com.actionmedia.pages.id2.Id2BasePage;
import com.actionmedia.pages.klpu.KlpuBasePage;
import com.actionmedia.pages.konsultantplus.KonsultantPlusBasePage;
import com.actionmedia.pages.kss.KssBasePage;
import com.actionmedia.pages.ot.OTBasePage;
import com.actionmedia.pages.umd.UmdBasePage;
import com.actionmedia.pages.uss.UssBasePage;

public class AbstractDomainTest<P extends BaseTest> extends BaseTest<P> {

    protected BssBasePage loginBss() {
        return getLoginPage().login(BssBasePage.class);
    }

    protected KssBasePage loginKss() {
        return getLoginPage().login(KssBasePage.class);
    }

    protected UssBasePage loginUss() {
        return getLoginPage().login(UssBasePage.class);
    }

    protected FssBasePage loginFss() {
        return getLoginPage().login(FssBasePage.class);
    }

    protected BssBasePage enterToBssWithoutLogin() {
        return getBssBasePage();
    }

    protected KssBasePage enterToKssWithoutLogin() {
        return getKssBasePage();
    }

    protected UssBasePage enterToUssWithoutLogin() {
        return getUssBasePage();
    }

    protected FssBasePage enterToFssWithoutLogin() {
        return getFssBasePage();
    }

    protected EduBasePage enterToEduWithoutLogin() {
        return getEduBasePage();
    }

    protected OTBasePage enterToOtWithoutLogin() {
        return getOtBasePage();
    }

    protected GFBasePage enterToGFWithoutLogin() {
        return getGFBasePage();
    }

    protected UmdBasePage enterToUmdWithoutLogin() {
        return getUmdBasePage();
    }

    protected ElpuBasePage enterToElpuWithoutLogin() {
        return getElpuBasePage();
    }

    protected KlpuBasePage enterToKlpuWithoutLogin() {
        return getKlpuBasePage();
    }

    protected CultBasePage enterToCultWithoutLogin() {
        return getCultBasePage();
    }

    protected GoBasePage enterToGoWithoutLogin() {
        return getGoBasePage();
    }

    protected BssBasePage loginToBssWithUrl(String url) {
        return getLoginPage().login(BssBasePage.class, url);
    }

    protected KssBasePage loginToKssWithUrl(String url) {
        return getLoginPage().login(KssBasePage.class, url);
    }

    protected UssBasePage loginToUssWithUrl(String url) {
        return getLoginPage().login(UssBasePage.class, url);
    }

    protected FssBasePage loginToFssWithUrl(String url) {
        return getLoginPage().login(FssBasePage.class, url);
    }

    protected KonsultantPlusBasePage loginToKonsultantPlus(String url, String login, String password) {
        return getLoginPage(url).loginToKonsultantPlus(KonsultantPlusBasePage.class, url, login, password);
    }

    protected Id2BasePage openToId2SiteByUrl(String url) {
        return getLoginPage(url).openUrl(Id2BasePage.class, url);
    }

    protected OTBasePage loginOT() {
        return getLoginPage().login(OTBasePage.class);
    }

    protected GFBasePage loginGF() {
        return getLoginPage().login(GFBasePage.class);
    }

    protected EduBasePage loginEdu() {
        return getLoginPage().login(EduBasePage.class);
    }

    protected GoBasePage loginGo() {
        return getLoginPage().login(GoBasePage.class);
    }

    protected CultBasePage loginCult() {
        return getLoginPage().login(CultBasePage.class);
    }

    protected ElpuBasePage loginElpu() {
        return getLoginPage().login(ElpuBasePage.class);
    }

    protected KlpuBasePage loginKlpu() {
        return getLoginPage().login(KlpuBasePage.class);
    }

    protected UmdBasePage loginUmd() {
        return getLoginPage().login(UmdBasePage.class);
    }
}
