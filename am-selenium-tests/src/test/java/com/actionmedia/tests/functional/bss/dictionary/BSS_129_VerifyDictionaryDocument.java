package com.actionmedia.tests.functional.bss.dictionary;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.bss.BssDocumentPage;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 22.04.2014
 * Time: 12:21
 */
public class BSS_129_VerifyDictionaryDocument extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-129", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_129_test() {
        loginBss()
                .navigateToDictionaryPage()
                .clickRandomDocumentFromNewsBlock("Курсы валют")
                .checkDocumentIsNotEmpty()
                .checkDocumentWithNameIsOpened(String.valueOf(getParameter(BssDocumentPage.BOOK_NAME)))
                .checkLinksFromAdditionalBlock()

                .navigateToDictionaryPage()
                .clickDocumentFromNewsBlockWithName("Курсы валют")
                .checkDocumentIsNotEmpty()
                .checkDocumentWithNameIsOpened(String.valueOf(getParameter(BssDocumentPage.BOOK_NAME)))
                .logout();
    }
}
