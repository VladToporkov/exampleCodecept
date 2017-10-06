package com.actionmedia.tests.functional.oss.headers;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;


/**
 * User: n.leontieva
 * Date: 03.02.16
 */
public class OSS_1012_Headers extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1012", testCaseVersion = "1")
    public void oss_1012_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        getKssBasePage()
                .checkMoveMouseToElements("law")
                .checkMoveMouseToElements("handbook")
                .checkMoveMouseToElements("forms")
                .checkMoveMouseToElements("press")
                .checkMoveMouseToElements("videos")
                .checkMoveMouseToElements("services")
                .checkMoveMouseToElements("education")
                .checkMoveMouseToElements("rabotaru")

                .openMenu()

                .checkMoveMouseToElements("law")
                .checkMoveMouseToElements("handbook")
                .checkMoveMouseToElements("forms")
                .checkMoveMouseToElements("press")
                .checkMoveMouseToElements("videos")
                .checkMoveMouseToElements("services")
                .checkMoveMouseToElements("education")
                .checkMoveMouseToElements("rabotaru");

        //навести на все свернутые элементы меню. проверить что подсвечиваются
        updateSystemInfo(SystemPubs.bss);
        getBssBasePage()
                .checkMoveMouseToElements("law")
                .checkMoveMouseToElements("forms")
                .checkMoveMouseToElements("handbook")
                .checkMoveMouseToElements("press")
                .checkMoveMouseToElements("videos")
                .checkMoveMouseToElements("services")

                .openMenu()

                .checkMoveMouseToElements("law")
                .checkMoveMouseToElements("forms")
                .checkMoveMouseToElements("handbook")
                .checkMoveMouseToElements("press")
                .checkMoveMouseToElements("videos")
                .checkMoveMouseToElements("services");

        updateSystemInfo(SystemPubs.uss);
        getUssBasePage()
                .checkMoveMouseToElements("contract")
                .checkMoveMouseToElements("law")
                .checkMoveMouseToElements("lawpractice")
                .checkMoveMouseToElements("handbook")
                .checkMoveMouseToElements("forms")
                .checkMoveMouseToElements("press")
                .checkMoveMouseToElements("videos")
                .checkMoveMouseToElements("services")
                .checkMoveMouseToElements("recommendations")

                .openMenu()

                .checkMoveMouseToElements("contract")
                .checkMoveMouseToElements("law")
                .checkMoveMouseToElements("lawpractice")
                .checkMoveMouseToElements("handbook")
                .checkMoveMouseToElements("forms")
                .checkMoveMouseToElements("press")
                .checkMoveMouseToElements("videos")
                .checkMoveMouseToElements("services")
                .checkMoveMouseToElements("recommendations");

        updateSystemInfo(SystemPubs.fss);
        getFssBasePage()
                .checkMoveMouseToElements("law")
                .checkMoveMouseToElements("solutions")
                .checkMoveMouseToElements("handbook")
                .checkMoveMouseToElements("forms")
                .checkMoveMouseToElements("press")
                .checkMoveMouseToElements("videos")
                .checkMoveMouseToElements("services")

                .openMenu()

                .checkMoveMouseToElements("law")
                .checkMoveMouseToElements("solutions")
                .checkMoveMouseToElements("handbook")
                .checkMoveMouseToElements("forms")
                .checkMoveMouseToElements("press")
                .checkMoveMouseToElements("videos")
                .checkMoveMouseToElements("services");
    }
}