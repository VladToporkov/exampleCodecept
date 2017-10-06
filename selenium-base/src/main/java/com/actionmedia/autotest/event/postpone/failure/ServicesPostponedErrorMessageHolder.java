package com.actionmedia.autotest.event.postpone.failure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ServicesPostponedErrorMessageHolder {
    private static Map<String, List<String>> pathsHolder = new HashMap<String, List<String>>();

    private ServicesPostponedErrorMessageHolder() {
    }

    public static void addErrorMessageForTest(final String testName, final String message) {
        List<String> errorMessageList;
        if (pathsHolder.containsKey(testName)) {
            errorMessageList = pathsHolder.get(testName);
        } else {
            errorMessageList = new ArrayList<String>();
            pathsHolder.put(testName, errorMessageList);
        }
        errorMessageList.add(message);
    }

    public static List<String> getErrorMessageListForTest(final String testName) {
        List<String> errorMessageList = new ArrayList<String>();
        for (Map.Entry<String, List<String>> entry : pathsHolder.entrySet()) {
            if (testName.contains(entry.getKey())) {
                errorMessageList.addAll(entry.getValue());
            }
        }
        return errorMessageList;
    }

    public static void clear(){
        pathsHolder.clear();
    }
}
