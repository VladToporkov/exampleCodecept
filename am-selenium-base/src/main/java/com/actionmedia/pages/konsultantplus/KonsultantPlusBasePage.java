package com.actionmedia.pages.konsultantplus;

import com.actionmedia.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

/**
 * User: n.tyukavkin
 * Date: 07.09.2014
 * Time: 18:33
 */
@Component
public class KonsultantPlusBasePage<P extends BasePage> extends BasePage<P> {

    public KonsultantPlusBasePage clickQuickSearchButton() {
        WebElement quickSearchButton = waitForPresenceOfElementLocatedBy(By.xpath("//td[text()='Быстрый поиск']"));
        quickSearchButton.click();
        login();
        return this;
    }

    public KonsultantPlusBasePage clickFullSearchButton() {
        login();
        WebElement searchCardButton = waitForPresenceOfElementLocatedBy(By.xpath("//span[text()='Построить полный список']"));
        searchCardButton.click();
        return this;
    }

    public KonsultantPlusBasePage clickSearchButtonInKonsultant() {
        login();
        WebElement quickSearchButton = waitForPresenceOfElementLocatedBy(By.id("btnSRDSearch_text"));
        quickSearchButton.click();
        return this;
    }

    public KonsultantPlusBasePage inputTextInSearchFieldInKonsultant(String query) {
        login();
        WebElement quickSearchButton = waitForPresenceOfElementLocatedBy(By.id("splusFilter"));
        getWebElementWrapper(quickSearchButton).getTextField().clearAndType(query);
        return this;
    }

    public KonsultantPlusBasePage waitForSearchResult() {
        waitForVisibilityOfElementLocatedBy(By.cssSelector(".splusActiveItem"));
        return this;
    }

    public KonsultantPlusBasePage waitForFullSearchResult() {
        waitForVisibilityOfElementLocatedBy(By.cssSelector(".act"));
        return this;
    }

    private void login() {
        WebElement content = waitForPresenceOfElementLocatedBy(By.id("mainContent"));
        WebElement authForm = findElementByNoThrow(content, By.id("authForm"));
        if (authForm != null) {
            WebElement loginField = waitForVisibilityOfElementLocatedBy(By.name("login"));
            WebElement passwordField = waitForVisibilityOfElementLocatedBy(By.name("pwd"));
            WebElement checkBox = waitForVisibilityOfElementLocatedBy(By.id("storepassword"));

            getWebElementWrapper(loginField).getTextField().clearAndType("750526");
            getWebElementWrapper(passwordField).getTextField().clearAndType("VS50SaJm");

            if (!checkBox.isSelected()) {
                checkBox.click();
            }

            WebElement loginButton = waitForVisibilityOfElementLocatedBy(By.id("btnOk"));
            loginButton.click();
        }
    }
}
