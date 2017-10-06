package com.actionmedia.autotest.utils;

public final class StringUtils {

    /**
     * private constructor for utils class
     */
    private StringUtils() {
    }

    /**
     * Delete hyphens from a string.
     *
     * @param textWithHyphens
     * @return
     */
    public static String deleteHyphens(final String textWithHyphens) {
        return textWithHyphens.replaceAll("\n|\r\n", " ");
    }
}
