package com.actionmedia.tests.functional.oss;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.noRT;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 07.12.14
 * Time: 21:48
 */
public class OSS_97_VerifyCertificateBlock extends AbstractDomainTest {

    private static final String COMMENT = "При подписке сообщите менеджеру, что хотите оплатить сертификатом, и назовите номер";

    @Test(groups = {regression, noRT})
    @TestLink(testCaseId = "OSS-97", testCaseVersion = "1")
    public void oss_97_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("user.certificate");
        loginBss()
                .navigateToRecomendPage()
                .clickProfileLink()
                .checkCertificateBlockIsPresent()
                .checkCertificateBlockContent()

                .clickLinkInCertificateBlock()
                .checkTextInCertificateBlockIsPresent(COMMENT)

                .clickLinkInCertificateBlock()
                .checkTextInCertificateBlockIsNotPresent(COMMENT)

                .logout();
        updateLoginAsInfo("bss.user.commercial");
        loginBss()
                .navigateToRecomendPage()
                .clickProfileLink()
                .checkCertificateBlockIsNotPresent()
                .logout();

        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("user.certificate");
        loginKss()
                .navigateToAnswersPage()
                .clickProfileLink()
                .checkCertificateBlockIsPresent()
                .checkCertificateBlockContent()

                .clickLinkInCertificateBlock()
                .checkTextInCertificateBlockIsPresent(COMMENT)

                .clickLinkInCertificateBlock()
                .checkTextInCertificateBlockIsNotPresent(COMMENT)

                .logout();
        updateLoginAsInfo("kss.user.commercial");
        loginKss()
                .navigateToAnswersPage()
                .clickProfileLink()
                .checkCertificateBlockIsNotPresent()
                .logout();

        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("user.certificate");
        loginUss()
                .navigateToRecomendPage()
                .clickProfileLink()
                .checkCertificateBlockIsPresent()
                .checkCertificateBlockContent()

                .clickLinkInCertificateBlock()
                .checkTextInCertificateBlockIsPresent(COMMENT)

                .clickLinkInCertificateBlock()
                .checkTextInCertificateBlockIsNotPresent(COMMENT)

                .logout();
        updateLoginAsInfo("uss.user.commercial");
        loginUss()
                .navigateToRecomendPage()
                .clickProfileLink()
                .checkCertificateBlockIsNotPresent()
                .logout();
    }
}
