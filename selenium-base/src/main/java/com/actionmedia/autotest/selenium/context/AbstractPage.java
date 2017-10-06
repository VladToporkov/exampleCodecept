package com.actionmedia.autotest.selenium.context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import static org.apache.commons.lang.StringUtils.isNotBlank;

public abstract class AbstractPage<P extends AbstractPage> extends AbstractPageElement<P> implements IPage {

    private final Log logger = LogFactory.getLog(getClass());

    private final String path;

    public AbstractPage() {
        path = null;
    }

    public void load() {
        load(path);
    }

    public void load(final String pathString) {
        if (isNotBlank(pathString)) {
            getDriver().get(pathString);
        }
    }

    protected final void log(final String message) {
        Reporter.log(message);
    }

    protected final void log(final String format, final Object... args) {
        log(String.format(format, args));
    }

    public <P extends AbstractPage> P closeCurrentWindow(final Class<P> target) {
        closeBrowserWindow();
        return redirectTo(target);
    }

    protected void switchToMainWindow(){
        String mainWindow = getDriver().getWindowHandles().iterator().next();
        getDriver().switchTo().window(mainWindow);
    }

    protected void maximizeWindow() {
        try {
            getDriver().manage().window().maximize();
        } catch (WebDriverException e) {
            logger.error("WebDriverException occurs", e);
            //If a frame is selected and then browser window is maximized, exception is thrown
            //Selenium bug: Issue 3758: Exception upon maximizing browser window with frame selected
        }
    }

    protected void scrollIntoView(WebElement element) {
        executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void scrollToElementLocation(WebElement element) {
        executeScript("window.scrollTo(" + 0 + ", " + element.getLocation().getY() + "); return true;");
//        executeScript("scroll(" + element.getLocation().getX() + "," + element.getLocation().getY() + ");");
    }

    protected void scrollToElementLocation(WebElement element, WebElement withoutElement) {
        int withoutPx = withoutElement.getLocation().getY();
        int elementPx = element.getLocation().getY();
        int diff = elementPx - withoutPx;
        executeScript("window.scrollTo(" + 0 + ", " + diff + "); return true;");
    }

    /**
     * This method works if the current page contains the header_control_state and
     * do not scroll 200px from the top of the border.
     */
    protected void scrollToElementLocationWithout200px(WebElement element) {
        executeScript("window.scrollTo(" + 0 + ", " + (element.getLocation().getY() - 200) + "); return true;");
    }

    protected void clickUseJS(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
        waitForReloadingPage();
    }
}
