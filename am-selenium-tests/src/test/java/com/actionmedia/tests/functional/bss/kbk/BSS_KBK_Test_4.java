package com.actionmedia.tests.functional.bss.kbk;

import com.actionmedia.annotations.BeforeMethodCustom;
import com.actionmedia.autotest.annotations.LoginAs;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.kbk;

/**
 * User: n.tyukavkin
 * Date: 11.12.13
 * Time: 16:21
 */
public class BSS_KBK_Test_4 extends BSS_KBK_Test {

    @BeforeMethodCustom
    @LoginAs(key = "bss.user.kbk.prod")
    public void precondition_kbk() {
        precondition_kbk_test();
    }

    @Test(groups = {kbk})
    @LoginAs(key = "user.kbk")
    public void bss_kbk_test_4() {
        bss_kbk_test(4);
    }
}
