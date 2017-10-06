package com.actionmedia.tests.services.actionbonus;

import com.actionmedia.base.AbstractServicesTest;
import com.actionmedia.webservice.MessageElementConverter;
import com.actionmedia.webservice.NodeElement;
import com.actionmedia.webservice.ServiceResponse;
import com.actionmedia.webservice.actionbonus.proxyservice.ActionBonusServiceLocator;
import com.actionmedia.webservice.actionbonus.proxyservice.GetCertificatesResponseGetCertificatesResult;
import com.actionmedia.webservice.actionbonus.proxyservice.GetPointsResponseGetPointsResult;
import com.actionmedia.webservice.actionbonus.proxyservice.IActionBonusService;
import org.testng.annotations.Test;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;
import java.util.List;

import static com.actionmedia.autotest.Group.bonus;
import static com.actionmedia.autotest.Group.service;

/**
 * User: n.tyukavkin
 * Date: 01.06.2014
 * Time: 11:31
 */
public class BonusServiceTests extends AbstractServicesTest {

    @Test(groups = {bonus, service})
    public void proxy_getPoints_test() {
        String methodName = "Proxy-service >> GetPoints";
        String customerToken = "5fc84202-34d9-41d1-8edf-a15f98eb91bb";

        report("Тест для проверки метода '" + methodName + "'");
        report("customerToken - " + customerToken);
        try {
            for (String url : getUrlForProxyBonusService()) {
                report("Адрес сервиса - " + url);

                ActionBonusServiceLocator locator = new ActionBonusServiceLocator();
                locator.setBasicHttpBinding_IActionBonusServiceEndpointAddress(url);
                IActionBonusService bonusService = locator.getBasicHttpBinding_IActionBonusService();

                GetPointsResponseGetPointsResult getPointsResult = bonusService.getPoints(customerToken);
                ServiceResponse response = new MessageElementConverter(getPointsResult.get_any()[0]).getResponse();

                List<NodeElement> balance = response.getNodeElementListByName("balance");

                checkTagIsPresent(methodName, "balance", balance);
                checkValueIsNotEmpty(methodName, balance);

                checkAttributeValue("type", "electronic", balance.get(0).getAttributes(), methodName);
                if (balance.size() > 1) {
                    checkAttributeValue("type", "printed", balance.get(1).getAttributes(), methodName);
                }
            }
        } catch (ServiceException e) {
            fail("ServiceException occurs ", e);
        } catch (RemoteException e) {
            fail("RemoteException occurs ", e);
        }
    }

    @Test(groups = {bonus, service})
    public void proxy_getCertificates_test() {
        String methodName = "Proxy-service >> GetCertificates";
        String customerToken = "5fc84202-34d9-41d1-8edf-a15f98eb91bb";

        report("Тест для проверки метода '" + methodName + "'");
        report("customerToken - " + customerToken);

        try {
            for (String url : getUrlForProxyBonusService()) {
                report("Адрес сервиса - " + url);

                ActionBonusServiceLocator locator = new ActionBonusServiceLocator();
                locator.setBasicHttpBinding_IActionBonusServiceEndpointAddress(url);
                IActionBonusService bonusService = locator.getBasicHttpBinding_IActionBonusService();

                GetCertificatesResponseGetCertificatesResult certificatesResult = bonusService.getCertificates(customerToken);
                ServiceResponse response = new MessageElementConverter(certificatesResult.get_any()[0]).getResponse();

                List<NodeElement> certificatesElementList = response.getNodeElementListByName("certificates");
                if (!certificatesElementList.isEmpty()) {
                    NodeElement certificates = certificatesElementList.get(0);
                    List<NodeElement> certificateElementList = certificates.getChildrenListByName("certificate");
                    if (!certificateElementList.isEmpty()) {
                        for (NodeElement certificate : certificateElementList) {
                            checkAttributeIsPresent("id", certificate.getAttributes(), methodName);
                            checkAttributeIsPresent("active", certificate.getAttributes(), methodName);

                            List<NodeElement> statusElementList = certificate.getChildrenListByName("status");
                            List<NodeElement> nameElementList = certificate.getChildrenListByName("name");
                            List<NodeElement> numberElementList = certificate.getChildrenListByName("number");
                            List<NodeElement> sumElementList = certificate.getChildrenListByName("sum");
                            List<NodeElement> createdOnElementList = certificate.getChildrenListByName("createdOn");
                            List<NodeElement> expiredOnElementList = certificate.getChildrenListByName("expiredOn");

                            if (!statusElementList.isEmpty()) {
                                checkAttributeIsPresent("id", statusElementList.get(0).getAttributes(), methodName);
                            }

                            checkTagIsPresent(methodName, "status", statusElementList);
                            checkTagIsPresent(methodName, "name", nameElementList);
                            checkTagIsPresent(methodName, "number", numberElementList);
                            checkTagIsPresent(methodName, "sum", sumElementList);
                            checkTagIsPresent(methodName, "createdOn", createdOnElementList);
                            checkTagIsPresent(methodName, "expiredOn", expiredOnElementList);

                            checkValueIsNotEmpty(methodName, statusElementList);
                            checkValueIsNotEmpty(methodName, nameElementList);
                            checkValueIsNotEmpty(methodName, numberElementList);
                            checkValueIsNotEmpty(methodName, sumElementList);
                            checkValueIsNotEmpty(methodName, createdOnElementList);
                            checkValueIsNotEmpty(methodName, expiredOnElementList);
                        }
                    } else {
                        checkTagIsPresent(methodName, "certificate", certificatesElementList);
                    }
                } else {
                    checkTagIsPresent(methodName, "certificates", certificatesElementList);
                }
            }
        } catch (ServiceException e) {
            fail("ServiceException occurs ", e);
        } catch (RemoteException e) {
            fail("RemoteException occurs ", e);
        }
    }

    private String[] getUrlForProxyBonusService() {
        String[] urls = new String[]{};
        if (getSettings().isRunProk1()) {
            urls = new String[]{"http://actionbonus-service-prok.1glp.ru/ActionBonusService.svc/soap"};
        }
        if (getSettings().isRunRT()) {
            urls = new String[]{"http://actionbonus-service-rt/ActionBonusService.svc/soap"};
        }
        if (getSettings().isRunTbd()) {
            urls = new String[]{"http://actionbonus-service.actiondigital.ru/ActionBonusService.svc/soap"};
        }
        if (getSettings().isRunProduction() || getSettings().isRunWeb13()) {
            urls = new String[]{
                    "http://web11.actionbonus-service/ActionBonusService.svc/soap",
                    "http://web12.actionbonus-service/ActionBonusService.svc/soap",
                    "http://web13.actionbonus-service/ActionBonusService.svc/soap"
            };
        }
        return urls;
    }
}
