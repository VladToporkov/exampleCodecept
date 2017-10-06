package com.actionmedia.components;

/**
 * User: n.tyukavkin
 * Date: 05.08.2014
 * Time: 22:09
 */
public class SearchIndexDocument {

    private int pubId;
    private int pubDivId;
    private int moduleId;
    private int id;
    private int groupId;
    private String request;
    private int[] searchTagList;

    public SearchIndexDocument(int pubId, int pubDivId, int moduleId, int id, int groupId, String request, String searchTagList) {
        this.pubId = pubId;
        this.pubDivId = pubDivId;
        this.moduleId = moduleId;
        this.id = id;
        this.groupId = groupId;
        this.request = request;
        this.searchTagList = searchTagList != null ? getIntArrFromString(searchTagList) : new int[]{};
    }

    public int getPubId() {
        return pubId;
    }

    public int getPubDivId() {
        return pubDivId;
    }

    public int getModuleId() {
        return moduleId;
    }

    public int getId() {
        return id;
    }

    public int getGroupId() {
        return groupId;
    }

    public String getRequest() {
        return request;
    }

    public int[] getSearchTagList() {
        return searchTagList;
    }

    private int[] getIntArrFromString(String text) {
        String[] textArr = text.split(",");
        int[] intArr = new int[textArr.length];
        for (int i = 0; i < textArr.length; i++) {
            intArr[i] = Integer.parseInt(textArr[i]);
        }
        return intArr;
    }
}
