package com.actionmedia.pages.fss;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.components.PersonInfo;
import com.actionmedia.pages.helpers.ProfileBasePageHelper;
import org.springframework.stereotype.Component;

/**
 * User: n.tyukavkin
 * Date: 29.11.13
 * Time: 18:10
 */
@Component
public class FssProfilePage extends FssBasePage<FssProfilePage> {

    @Step("Проверяется что страница Личного кабинета открыта")
    public FssProfilePage checkProfilePageIsOpened() {
        WebElement profile = findElementByNoThrow(mainContentElement, By.id("personal-data"));
        postponedAssertNotNull(profile, "Страница Личного кабинета не открыта");
        return this;
    }

    @Step("Проверяем клик на ссылку 'Изменить регион'")
    public FssProfilePage checkCurrentUrlContainsDocumentUrl() {
        checkCurrentUrlContainsDocumentUrl("/#/customer/geo/");
        return this;
    }

    @Step("Проверяем клик на ссылку 'Изменить регион'")
    public FssProfilePage changeRegion(String region) {
        getHelper(ProfileBasePageHelper.class).changeRegion(region);
        return this;
    }

    @Step("Вернуть определение региона автоматически")
    public FssProfilePage changeCheckboxAutoRegion() {
        getHelper(ProfileBasePageHelper.class).changeCheckboxAutoRegion();
        return this;
    }

    public PersonInfo getPersonInfo(){
        PersonInfo personInfo = getHelper(ProfileBasePageHelper.class).getPersonInfo();
        logout();
        return personInfo;
    }

    public FssProfilePage checkEmail(String email) {
        getHelper(ProfileBasePageHelper.class).checkEmail(email);
        return this;
    }
}
