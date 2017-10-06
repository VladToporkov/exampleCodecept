package com.actionmedia.tests.functional.oss.registration;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 25/02/16.
 */
public class OSS_966_VerifyFullNameDemoBSS extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-966", testCaseVersion = "1")
    public void oss_966_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверка ФИО при получеии новым пользователем демодоступа БСС КУ");
        test();
    }

    public void test() {
        enterToBssWithoutLogin()
                .navigateToLoginPage()
                .chooseDemoSection()
                .typeEmail("ya152@ya.ru")
                .typePassword("12345")
                .typePhonePrefix("951")
                .typePhoneNumber("0099421")
                .typeSmsCode("3212")
                .clickOnSomeFreePlace()
                .checkGetDemoButtonIsDisabled()

                .clickOnLastNameInput()
                .clickOnSomeFreePlace()
                .checkErrorText("Введите фамилию")

                .clickOnLastNameInput()
                .clickOnFirstNameInput()
                .clickOnSomeFreePlace()
                .checkErrorText("Введите фамилию")

                .clickOnLastNameInput()
                .clickOnFirstNameInput()
                .clickOnSecondNameInput()
                .clickOnSomeFreePlace()
                .checkErrorText("Введите фамилию")

                .typeLastName("Васильев")
                .clickOnFirstNameInput()
                .clickOnSecondNameInput()
                .clickOnSomeFreePlace()
                .checkErrorText("Введите имя")

                .typeFirstName("Василий")
                .clickOnSecondNameInput()
                .clickOnSomeFreePlace()
                .checkErrorText("Введите отчество")

                .clearFieldsFullName()
                .typeLastName("Васильев")
                .typeSecondName("Васильевич")
                .clickOnFirstNameInput()
                .checkErrorText("Введите имя")

                .clearFieldsFullName()
                .typeLastName("Васильев")
                .typeFirstName("Василий")
                .checkGetDemoButtonIsEnabled()

                .clearFieldsFullName()
                .typeLastName("Васильев")
                .typeFirstName("Василий")
                .clickOnSecondNameInput()
                .checkErrorText("Введите отчество")
                .checkGetDemoButtonIsEnabled()

                .clearFieldsFullName()
                .typeLastName("Васильев")
                .typeSecondName("Васильевич")
                .checkErrorText("Введите имя")
                .checkGetDemoButtonIsDisabled()

                .clearFieldsFullName()
                .typeFirstName("Василий")
                .typeSecondName("Васильевич")
                .checkErrorText("Введите фамилию")
                .checkGetDemoButtonIsDisabled()

                .clearFieldsFullName()
                .typeSecondName("Васильевич")
                .checkErrorText("Введите фамилию")
                .checkGetDemoButtonIsDisabled()

                .clearFieldsFullName()
                .typeLastName("Ivanov")
                .clickOnFirstNameInput()
                .clickOnSecondNameInput()
                .clickOnSomeFreePlace()
                .checkErrorText("Просим по возможности использовать русские буквы")
                .checkGetDemoButtonIsDisabled()

                .clearFieldsFullName()
                .typeLastName("Ivanov")
                .typeFirstName("Ivan")
                .clickOnSecondNameInput()
                .clickOnSomeFreePlace()
                .checkErrorText("Просим по возможности использовать русские буквы")
                .checkGetDemoButtonIsEnabled()

                .clearFieldsFullName()
                .typeLastName("Ivanov")
                .typeSecondName("Ivanovich")
                .clickOnFirstNameInput()
                .clickOnSomeFreePlace()
                .checkErrorText("Просим по возможности использовать русские буквы")
                .checkGetDemoButtonIsDisabled()

                .clearFieldsFullName()
                .typeLastName("Iva+nov")
                .clickOnFirstNameInput()
                .clickOnSecondNameInput()
                .clickOnSomeFreePlace()
                .checkErrorText("Введите фамилию без цифр и знаков препинания")
                .checkGetDemoButtonIsDisabled()

                .clearFieldsFullName()
                .typeLastName("Иванов")
                .typeFirstName("Iv.a1n")
                .typeSecondName("IVAnovich123")
                .clickOnSomeFreePlace()
                .checkErrorText("Введите имя без цифр и знаков препинания")
                .checkGetDemoButtonIsDisabled()

                .clearFieldsFullName()
                .typeLastName("Иванов")
                .typeFirstName("Иван")
                .typeSecondName("IVAnovich123")
                .clickOnFirstNameInput()
                .clickOnSomeFreePlace()
                .checkErrorText("Введите отчество без цифр и знаков препинания")
                .checkGetDemoButtonIsDisabled()

                .clearFieldsFullName()
                .typeLastName("иВАНов")
                .typeFirstName("иВаН")
                .typeSecondName("ИВаНОвич")
                .clickOnSomeFreePlace()
                .checkErrorTextIsNotPresent()
                .checkGetDemoButtonIsEnabled()

                .clearFieldsFullName()
                .typeLastName("Петров")
                .typeFirstName("Пётр")
                .typeSecondName("Петрович")
                .clickOnSomeFreePlace()
                .checkErrorTextIsNotPresent()
                .checkGetDemoButtonIsEnabled();
    }
}
