package com.actionmedia.autotest.selenium.elements;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface Select extends Element, EnabledElement {
    void selectByText(String key);

    void selectByIndex(int index);

    void selectByValue(String value);

    void selectByText(String key, String errorMessage);

    void selectByIndex(int index, String errorMessage);

    void selectByValue(String value, String errorMessage);

    void selectByAnotherTextThan(String text);

    void selectRandom();

    void selectRandomByAnotherTextThan(String text);

    void selectByPartialText(String partialText);

    WebElement getSelectedOption();

    String getSelectedText();

    String getSelectedValue();

    List<WebElement> getOptions();

    int getSelectedIndex();

    void deselectAll();
}
