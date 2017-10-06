package com.actionmedia.components;

/**
 * User: n.tyukavkin
 * Date: 07.12.2014
 * Time: 21:44
 */
public class Document {

    private int moduleId;
    private int documentId;

    public Document(int moduleId, int documentId) {
        this.moduleId = moduleId;
        this.documentId = documentId;
    }

    public int getModuleId() {
        return moduleId;
    }

    public int getDocumentId() {
        return documentId;
    }
}
