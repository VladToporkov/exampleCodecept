package com.actionmedia.tests.experimental.createxml;

import com.actionmedia.autotest.Group;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.reflections.Reflections;
import org.testng.IAlterSuiteListener;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;

public class GenerateXmlListener implements IAlterSuiteListener {

    @Override
    public void alter(List<XmlSuite> list) {
        if (!list.isEmpty()) {
            XmlSuite modifiedSuite = list.get(0);

            Map<String, String> testClassPathList;
            if (getTestListById() != null && !getTestListById().isEmpty()) {
                testClassPathList = getTestClassPathListForTestIdList();
            } else {
                testClassPathList = getTestClassPathList();
            }
            String platformParam = getPlatform();
            if (platformParam != null && !platformParam.isEmpty()) {
                List<String> platformList = Arrays.asList(platformParam.split(","));
                Map<String, List<Integer>> testCaseIdByPlatform = getTestCaseIdByPlatform(platformList);
                for (String platform : platformList) {
                    List<Integer> testCaseIdListForPlatform = testCaseIdByPlatform.get(platform);
                    for (Map.Entry<String, String> entry : testClassPathList.entrySet()) {
                        int testCaseId = Integer.parseInt(entry.getKey().split("-")[1]);
                        if (testCaseIdListForPlatform.contains(testCaseId)) {
                            XmlTest xmlTest = new XmlTest(modifiedSuite);
                            xmlTest.setName(platform + ":" + entry.getKey());
                            xmlTest.setXmlClasses(Collections.singletonList(new XmlClass(entry.getValue())));
                            Map<String, String> parameters = new HashMap<String, String>();
                            parameters.put("platform", platform);
                            xmlTest.setParameters(parameters);
                        }
                    }
                }
            } else {
                for (Map.Entry<String, String> entry : testClassPathList.entrySet()) {
                    XmlTest xmlTest = new XmlTest(modifiedSuite);
                    xmlTest.setName(entry.getKey());
                    xmlTest.setXmlClasses(Arrays.asList(new XmlClass(entry.getValue())));
                }
            }
            System.out.println(modifiedSuite.toXml());
        }
    }

    private Map<String, String> getTestClassPathList() {
        Map<String, String> classPathMap = new HashMap<String, String>();
        Reflections reflections = new Reflections("com.actionmedia.tests.functional.oss");
        Set<Class<? extends AbstractDomainTest>> allClasses = reflections.getSubTypesOf(AbstractDomainTest.class);
        Iterator<Class<? extends AbstractDomainTest>> classIterator = allClasses.iterator();
        while (classIterator.hasNext()) {
            Class<? extends AbstractDomainTest> next = classIterator.next();
            Method[] methods = next.getMethods();
            for (Method method : methods) {
                Test testAnnotation = method.getAnnotation(Test.class);
                if (testAnnotation != null) {
                    if (isGroup(testAnnotation.groups())) {
                        TestLink testLinkAnnotation = method.getAnnotation(TestLink.class);
                        if (testLinkAnnotation != null) {
                            classPathMap.put(testLinkAnnotation.testCaseId(), next.getName());
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return classPathMap;
    }

    private Map<String, String> getTestClassPathListForTestIdList() {
        Map<String, String> classPathMap = new HashMap<String, String>();
        Reflections reflections = new Reflections("com.actionmedia.tests.functional.oss");
        Set<Class<? extends AbstractDomainTest>> allClasses = reflections.getSubTypesOf(AbstractDomainTest.class);
        Iterator<Class<? extends AbstractDomainTest>> classIterator = allClasses.iterator();
        List<String> testListById = Arrays.asList(getTestListById().split(";"));
        while (classIterator.hasNext()) {
            Class<? extends AbstractDomainTest> next = classIterator.next();
            Method[] methods = next.getMethods();
            for (Method method : methods) {
                TestLink testLinkAnnotation = method.getAnnotation(TestLink.class);
                if (testLinkAnnotation != null) {
                    if (testListById.contains(testLinkAnnotation.testCaseId())) {
                        if (!classPathMap.containsValue(next.getName())) {
                            classPathMap.put(testLinkAnnotation.testCaseId(), next.getName());
                        }
                    }
                }
            }
        }
        return classPathMap;
    }

    private boolean isGroup(String[] groups) {
        String testPlan = getTestPlan();
        for (String group : groups) {
            if (testPlan.equals(Group.regression) && (group.equals(Group.regression) || group.equals(Group.smoke))) {
                return true;
            }
            if (testPlan.equals(Group.smoke) && group.equals(Group.smoke)) {
                return true;
            }
            if (testPlan.equals(Group.rubricator) && group.equals(Group.rubricator)) {
                return true;
            }
        }
        return false;
    }

    private Map<String, List<Integer>> getTestCaseIdByPlatform(List<String> platformList) {
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://tl.actiondigital.ru:3306/bitnami_testlink?serverTimezone=UTC", "root", "123");

            for (String platform : platformList) {
                List<Integer> testCaseList = new ArrayList<Integer>();

                String query = "SELECT tcversions.tc_external_id\n" +
                        "FROM testplan_tcversions\n" +
                        "  JOIN platforms ON platform_id = platforms.id\n" +
                        "  JOIN testplans ON testplan_id = testplans.id\n" +
                        "  JOIN testprojects ON testplans.testproject_id = testprojects.id\n" +
                        "  JOIN builds ON builds.testplan_id = testplans.id\n" +
                        "  JOIN tcversions ON tcversions.id = testplan_tcversions.tcversion_id\n" +
                        "WHERE testprojects.prefix = 'OSS' AND builds.name = '" + getBuild() + "' AND platforms.name = '" + platform + "'";
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet result = statement.executeQuery();
                while (result.next()) {
                    testCaseList.add(result.getInt(1));
                }

                map.put(platform, testCaseList);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return map;
    }

    private String getTestListById() {
        return System.getenv("TEST_ID_LIST");
    }

    private String getTestPlan() {
        return System.getenv("TEST_PLAN");
    }

    private String getBuild() {
        return System.getenv("OSS_BUILD");
    }

    private String getPlatform() {
        return System.getenv("OSS_PLATFORMS");
    }

//    private String getTestPlan() {
//        return "regression";
//    }
//
//    private String getBuild() {
//        return "_03_TestRun_for_Autotests";
//    }
//
//    private String getPlatform() {
//        return "БСС,Госзаказ,Госфинансы,КЛПУ,КСС,Культура,Образование,Охрана труда,УМД,ФСС,ЭЛПУ,ЮСС";
//    }
}
