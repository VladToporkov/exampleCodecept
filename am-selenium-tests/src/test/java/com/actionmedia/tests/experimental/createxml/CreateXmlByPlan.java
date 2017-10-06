package com.actionmedia.tests.experimental.createxml;

import com.actionmedia.autotest.Group;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.reflections.Reflections;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CreateXmlByPlan extends CreateXmlBase {

    @Test
    public void createTestNGXml() {
        Map<String, String> classPathList = getTestClassPathList();
        copyTestNGXml(classPathList);
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
}
