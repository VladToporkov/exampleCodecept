package com.actionmedia.autotest.selenium.elements;

import com.actionmedia.autotest.selenium.ext.ElementFactory;
import com.actionmedia.autotest.selenium.ext.internal.DefaultElementFactory;
import org.openqa.selenium.WebElement;

public class WebElementWrapper {
    private final ElementFactory elementFactory = new DefaultElementFactory();
    private final WebElement webElement;

    public WebElementWrapper(final WebElement webElement) {
        this.webElement = webElement;
    }

    public Select getSelect() {
        return elementFactory.create(Select.class, webElement);
    }

    public TextField getTextField() {
        return elementFactory.create(TextField.class, webElement);
    }

    public RadioButton getRadioButton() {
        return elementFactory.create(RadioButton.class, webElement);
    }

    public CheckBox getCheckBox() {
        return elementFactory.create(CheckBox.class, webElement);
    }

}
