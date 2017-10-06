package com.actionmedia.tests.experimental.testlink;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionType;
import br.eti.kinoshita.testlinkjavaapi.constants.TestLinkMethods;
import br.eti.kinoshita.testlinkjavaapi.constants.TestLinkParams;
import br.eti.kinoshita.testlinkjavaapi.model.TestCase;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;
import org.apache.xmlrpc.XmlRpcException;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class AutoAssignmentTestsInTestLink {

    @Test
    public void test() throws MalformedURLException {
        final String url = "http://tl.actiondigital.ru/testlink/lib/api/xmlrpc/v1/xmlrpc.php";
        final String devKey = "7cd149fb4daf199a8a4ff463e344c732";

        URL testLinkURL = new URL(url);
        TestLinkAPI api = new TestLinkAPI(testLinkURL, devKey);

        int projectId = api.getTestProjectByName(getProjectName()).getId();
        int testPlanId = api.getTestPlanByName(getTestPlanName(), getProjectName()).getId();

        try {
            api.createBuild(testPlanId, getBuildName(), "");
        } catch (TestLinkAPIException e) {
            throw new AssertionError("Билд - " + getBuildName() + " для плана - " + getProjectName() + " не создался. " + e.getMessage());
        }

        Integer buildId = api.getLatestBuildForTestPlan(testPlanId).getId();

        List<String> testerList = Arrays.asList(getTesterList().split(";"));

        List<String> keyPlatform = Arrays.asList(getKeyPlatformList().split(";"));

        TestCase[] testCasesForTestPlan = api.getTestCasesForTestPlan(testPlanId, null, buildId, null, null, null, null, null, null, null, null);

        Map<String, List<String>> automatedMap = new HashMap<String, List<String>>();

        Map<String, List<String>> keyPlatformMap = new HashMap<String, List<String>>();

        Map<String, List<String>> uniquePlatformMap = new HashMap<String, List<String>>();

        Map<String, List<String>> uiPlatformMap = new HashMap<String, List<String>>();

        for (TestCase testCase : testCasesForTestPlan) {
            if (testCase.getExecutionType().equals(ExecutionType.AUTOMATED)) {
                List<String> testCaseListForPlatform = automatedMap.get(testCase.getPlatform().getName());
                if (testCaseListForPlatform == null) {
                    testCaseListForPlatform = new ArrayList<String>();
                }
                testCaseListForPlatform.add(testCase.getFullExternalId());
                automatedMap.put(testCase.getPlatform().getName(), testCaseListForPlatform);
                continue;
            }

            if (keyPlatform.contains(testCase.getPlatform().getName())) {
                List<String> testCaseListForPlatform = keyPlatformMap.get(testCase.getPlatform().getName());
                if (testCaseListForPlatform == null) {
                    testCaseListForPlatform = new ArrayList<String>();
                }
                testCaseListForPlatform.add(testCase.getFullExternalId());
                keyPlatformMap.put(testCase.getPlatform().getName(), testCaseListForPlatform);
                continue;
            }

            try {
                Map<String, Object> keywordsExecutionData = new HashMap<String, Object>();
                keywordsExecutionData.put(TestLinkParams.TEST_PROJECT_ID.toString(), projectId);
                keywordsExecutionData.put(TestLinkParams.TEST_CASE_EXTERNAL_ID.toString(), testCase.getFullExternalId());

                Object response = api.executeXmlRpcCall(TestLinkMethods.GET_TEST_CASE_KEYWORDS.toString(), keywordsExecutionData);

                List<String> keywordList = new ArrayList<String>();
                Object map = ((HashMap) response).get(testCase.getFullExternalId());
                if (map instanceof HashMap) {
                    Map<String, String> keywordMap = (HashMap) map;
                    for (Map.Entry<String, String> entry : keywordMap.entrySet()) {
                        keywordList.add(entry.getValue());
                    }
                } else if (map instanceof String && !((String) map).isEmpty()) {
                    keywordList.add(String.valueOf(response));
                }

                if (keywordList.contains("Уникальный")) {
                    List<String> testCaseListForPlatform = uniquePlatformMap.get(testCase.getPlatform().getName());
                    if (testCaseListForPlatform == null) {
                        testCaseListForPlatform = new ArrayList<String>();
                    }
                    testCaseListForPlatform.add(testCase.getFullExternalId());
                    uniquePlatformMap.put(testCase.getPlatform().getName(), testCaseListForPlatform);
                    continue;
                }

                if (keywordList.contains("Верстка")) {
                    List<String> testCaseListForPlatform = uiPlatformMap.get(testCase.getPlatform().getName());
                    if (testCaseListForPlatform == null) {
                        testCaseListForPlatform = new ArrayList<String>();
                    }
                    testCaseListForPlatform.add(testCase.getFullExternalId());
                    uiPlatformMap.put(testCase.getPlatform().getName(), testCaseListForPlatform);
                }

            } catch (XmlRpcException e) {
                e.printStackTrace();
            } catch (TestLinkAPIException e) {
                e.printStackTrace();
            }
        }

        assignToTesters(api, testPlanId, buildId, testerList, keyPlatformMap);

        assignToTesters(api, testPlanId, buildId, testerList, uniquePlatformMap);

        assignToTesters(api, testPlanId, buildId, testerList, uiPlatformMap);

        assignToAutoTester(api, testPlanId, buildId, automatedMap);
    }

    private void assignToTesters(TestLinkAPI api, int testPlanId, Integer buildId, List<String> testerList, Map<String, List<String>> keyPlatformMap) {
        int testCaseCount = 0;
        for (Map.Entry<String, List<String>> entry : keyPlatformMap.entrySet()) {
            testCaseCount += entry.getValue().size();
        }
        int add = testCaseCount % testerList.size();
        int avg = (testCaseCount - add) / testerList.size();

        int assignCount = 0;
        int testerCount = 0;
        for (Map.Entry<String, List<String>> entry : keyPlatformMap.entrySet()) {
            String platformName = entry.getKey();
            List<String> testCaseIdList = entry.getValue();
            for (String testCaseId : testCaseIdList) {
                assignCount++;

                if (assignCount % avg == 0) {
                    testerCount++;
                }

                String tester;
                if (testerCount >= testerList.size()) {
                    tester = testerList.get(0);
                } else {
                    tester = testerList.get(testerCount);
                }

                try {
                    Map<String, Object> assignExecutionData = new HashMap<String, Object>();
                    assignExecutionData.put(TestLinkParams.TEST_PLAN_ID.toString(), testPlanId);
                    assignExecutionData.put(TestLinkParams.TEST_CASE_EXTERNAL_ID.toString(), testCaseId);
                    assignExecutionData.put(TestLinkParams.PLATFORM_NAME.toString(), platformName);
                    assignExecutionData.put(TestLinkParams.USER.toString(), tester.trim());
                    assignExecutionData.put(TestLinkParams.BUILD_ID.toString(), buildId);
                    api.executeXmlRpcCall(TestLinkMethods.ASSIGN_TEST_CASE_EXECUTION_TASK.toString(), assignExecutionData);
                } catch (XmlRpcException e) {
                    e.printStackTrace();
                } catch (TestLinkAPIException e) {
                    System.out.println("testCaseId = [" + testCaseId + "], tester = [" + tester + "]");
                    e.printStackTrace();
                }
            }
        }
    }

    private void assignToAutoTester(TestLinkAPI api, int testPlanId, Integer buildId, Map<String, List<String>> automatedMap) {
        for (Map.Entry<String, List<String>> entry : automatedMap.entrySet()) {
            String platformName = entry.getKey();
            List<String> testCaseIdList = entry.getValue();
            for (String testCaseId : testCaseIdList) {
                try {
                    Map<String, Object> assignExecutionData = new HashMap<String, Object>();
                    assignExecutionData.put(TestLinkParams.TEST_PLAN_ID.toString(), testPlanId);
                    assignExecutionData.put(TestLinkParams.TEST_CASE_EXTERNAL_ID.toString(), testCaseId);
                    assignExecutionData.put(TestLinkParams.PLATFORM_NAME.toString(), platformName);
                    assignExecutionData.put(TestLinkParams.USER.toString(), "autotester");
                    assignExecutionData.put(TestLinkParams.BUILD_ID.toString(), buildId);
                    api.executeXmlRpcCall(TestLinkMethods.ASSIGN_TEST_CASE_EXECUTION_TASK.toString(), assignExecutionData);
                } catch (XmlRpcException e) {
                    e.printStackTrace();
                } catch (TestLinkAPIException e) {
                    System.out.println("testCaseId = [" + testCaseId + "], tester = [autotester]");
                    e.printStackTrace();
                }
            }
        }
    }

    private String getProjectName() {
        return System.getenv("PROJECT_NAME");
    }

    private String getTestPlanName() {
        return System.getenv("PLAN_NAME");
    }

    private String getBuildName() {
        return System.getenv("BUILD_NAME");
    }

    private String getKeyPlatformList() {
        return System.getenv("KEY_PLATFORM_LIST");
    }

    private String getTesterList() {
        return System.getenv("TESTER_LIST");
    }
}
