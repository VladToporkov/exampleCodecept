package com.actionmedia.tests.experimental.createxml;

import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

public class WarmGenerateXmlListener implements IAlterSuiteListener {

    @Override
    public void alter(List<XmlSuite> list) {
        if (!list.isEmpty()) {
            XmlSuite modifiedSuite = list.get(0);

            int threadCount = 1;
            String threadCountString = getThreadCount();
            if (threadCountString != null && !threadCountString.isEmpty()) {
                threadCount = Integer.parseInt(threadCountString);
            }

            List<XmlTest> defaultTestList = modifiedSuite.getTests();
            XmlTest xmlTest = defaultTestList.get(0);
            List<XmlTest> modifiedTestList = new ArrayList<XmlTest>();
            String name = xmlTest.getName();
            for (int i = 0; i < threadCount; i++) {
                XmlTest modifiedTest = new XmlTest(modifiedSuite);
                modifiedTest.setClasses(xmlTest.getXmlClasses());
                modifiedTest.setName(name + (i + 1));
                modifiedTestList.add(modifiedTest);
            }

            modifiedSuite.setThreadCount(threadCount);
            modifiedSuite.setTests(modifiedTestList);
        }
    }

    private String getThreadCount() {
        return System.getenv("THREAD_COUNT");
    }
}
