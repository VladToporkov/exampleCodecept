package com.actionmedia.tests.functional.bss.recomend;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 15.10.13
 * Time: 11:56
 */
public class BSS_102_VerifyRecomendDocuments extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-102", testCaseVersion = "3")
    @LoginAs(key = "bss.user.vip")
    @Version(section = "vip")
    public void bss_102_test() {
        loginBss()
                .navigateToRecomendPage()
                .checkLinkFromYellowPlate()

                .clickRubricatorButton()
                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()
                .checkContentIsPresent()

                .checkContentLinksForModule(getDocumentUrlByKey("bss.111.module"))
                .checkContentLinksForModule(getDocumentUrlByKey("bss.112.module"))
                .checkContentLinksForModule(getDocumentUrlByKey("bss.113.module"))
                .checkContentLinksForModule(getDocumentUrlByKey("bss.197.module"))
                .checkContentLinksForModule(getDocumentUrlByKey("bss.186.module"))
                .checkContentLinksForModule(getDocumentUrlByKey("bss.170.module"))
                .logout();
    }
}
