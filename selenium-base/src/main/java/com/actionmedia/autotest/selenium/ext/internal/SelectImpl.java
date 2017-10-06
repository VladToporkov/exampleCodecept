package com.actionmedia.autotest.selenium.ext.internal;

import com.actionmedia.autotest.selenium.SeleniumHolder;
import com.actionmedia.autotest.selenium.elements.Select;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.util.List;

import static org.apache.commons.lang.math.RandomUtils.nextInt;

class SelectImpl extends AbstractEnabledElement implements Select {

    protected SelectImpl(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public void selectByText(final String text) {
        if ("ie".equals(SeleniumHolder.getDriverName())) {
            getWrappedWebElement().sendKeys(text);
        } else {
            wrappedSelect().selectByVisibleText(text);
        }
    }

    @Override
    public void selectByIndex(final int index) {
        if ("ie".equals(SeleniumHolder.getDriverName())) {
            String value = wrappedSelect().getOptions().get(index).getText();
            selectByText(value);
        } else {
            wrappedSelect().selectByIndex(index);
        }
    }


    @Override
    public void selectByValue(final String value) {
        if ("ie".equals(SeleniumHolder.getDriverName())) {
            for (WebElement element : wrappedSelect().getOptions()) {
                if (value.equals(element.getAttribute("value"))) {
                    selectByText(element.getText());
                    break;
                }
            }
        } else {
            wrappedSelect().selectByValue(value);
        }
    }

    @Override
    public void selectByText(final String text, final String errorMessage) {
        try {
            selectByText(text);
        } catch (NoSuchElementException e) {
            logger.error("NoSuchElementException occurs", e);
            Reporter.log("ERROR: " + errorMessage);
            throw new AssertionError(e);
        }
    }

    @Override
    public void selectByIndex(final int index, final String errorMessage) {
        try {
            selectByIndex(index);
        } catch (NoSuchElementException e) {
            logger.error("NoSuchElementException occurs", e);
            Reporter.log("ERROR: " + errorMessage);
            throw new AssertionError(e);
        }
    }

    @Override
    public void selectByValue(final String value, final String errorMessage) {
        try {
            selectByValue(value);
        } catch (NoSuchElementException e) {
            logger.error("NoSuchElementException occurs", e);
            Reporter.log("ERROR: " + errorMessage);
            throw new AssertionError(e);
        }
    }

    @Override
    public String getText() {
        return wrappedSelect().getFirstSelectedOption().getText();
    }

    @Override
    public WebElement getWrappedWebElement() {
        return getWrappedElement();
    }

    @Override
    public void selectByAnotherTextThan(final String text) {
        final org.openqa.selenium.support.ui.Select select = wrappedSelect();
        final List<WebElement> options = select.getOptions();
        for (int i = options.size() - 1; i >= 0; i--) {
            final WebElement each = options.get(i);
            if (!each.getText().equals(text)) {
                select.selectByIndex(i);
                return;
            }
        }
    }

    @Override
    public void selectRandom() {
        final org.openqa.selenium.support.ui.Select wrapped = wrappedSelect();
        int optionsSize = wrapped.getOptions().size();
        if (optionsSize > 1) {
            int optionIndex = nextInt(optionsSize);
            while (wrapped.getOptions().get(optionIndex).isSelected()) {
                optionIndex = nextInt(optionsSize);
            }
            wrapped.selectByIndex(optionIndex);
        }
    }

    @Override
    public void selectRandomByAnotherTextThan(String text) {
        final org.openqa.selenium.support.ui.Select wrapped = wrappedSelect();
        int optionsSize = wrapped.getOptions().size();
        if (optionsSize > 1) {
            int optionIndex = nextInt(optionsSize);
            while (wrapped.getOptions().get(optionIndex).isSelected() || text.equals(wrapped.getOptions().get(optionIndex).getText())) {
                optionIndex = nextInt(optionsSize);
            }
            wrapped.selectByIndex(optionIndex);
        }
    }

    @Override
    public void selectByPartialText(String partialText) {
        for (WebElement option : wrappedSelect().getOptions()) {
            if (option.getText().contains(partialText)) {
                option.click();
                return;
            }
        }
    }

    private org.openqa.selenium.support.ui.Select wrappedSelect() {
        return new org.openqa.selenium.support.ui.Select(getWrappedElement());
    }

    @Override
    public WebElement getSelectedOption() {
        return wrappedSelect().getFirstSelectedOption();
    }

    @Override
    public String getSelectedText() {
        return wrappedSelect().getFirstSelectedOption().getText();
    }

    @Override
    public String getSelectedValue() {
        return getWrappedElement().getAttribute("value");
    }

    @Override
    public List<WebElement> getOptions() {
        return wrappedSelect().getOptions();
    }


    @Override
    public int getSelectedIndex() {
        return Integer.parseInt(getSelectedOption().getAttribute("index"));
    }

    @Override
    public void deselectAll() {
        wrappedSelect().deselectAll();
    }
}
