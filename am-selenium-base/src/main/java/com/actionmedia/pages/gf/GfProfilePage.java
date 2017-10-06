package com.actionmedia.pages.gf;

import com.actionmedia.pages.helpers.ProfileBasePageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Pavel on 06/04/16.
 */
@Component
public class GfProfilePage extends GFBasePage<GfProfilePage> {

    @Step("Проверяется что открыт личный кабинет")
    public GfProfilePage checkProfilePageIsOpened() {
        WebElement personalInfo = findElementByNoThrow(mainLeftElement, By.cssSelector(".main__title"));
        assertNotNull(personalInfo, "Личный кабинет не отображается");
        postponedAssertEquals(personalInfo.getText(), "Персональные данные", "Неправильный текст загаловка личного кабинета");
        return this;
    }

    @Step("Изменяется регион")
    public GfProfilePage changeRegion(String region) {
        getHelper(ProfileBasePageHelper.class).changeRegion(region);
        return this;
    }

    @Step("Вернуть определение региона автоматически")
    public GfProfilePage changeCheckboxAutoRegion() {
        getHelper(ProfileBasePageHelper.class).changeCheckboxAutoRegion();
        return this;
    }
}
