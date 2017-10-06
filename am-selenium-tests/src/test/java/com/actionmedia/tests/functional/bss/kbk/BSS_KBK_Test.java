package com.actionmedia.tests.functional.bss.kbk;

import com.actionmedia.base.AbstractDomainTest;

/**
 * User: n.tyukavkin
 * Date: 11.12.13
 * Time: 16:21
 */
public class BSS_KBK_Test extends AbstractDomainTest {

    protected void precondition_kbk_test() {
        loginToBssWithUrl("1gl.ru")
                .openDocumentByUrl(getFullDocumentUrlByKey("bss.kbk"))
                .parseKbk()
                .logout();
    }

    protected void bss_kbk_test(int sectionNumber) {
        loginBss()
                .navigateToDictionaryPage()
                .clickKBKService()
                .clickFirstTab()
                .checkKBKService(sectionNumber);
    }
}
