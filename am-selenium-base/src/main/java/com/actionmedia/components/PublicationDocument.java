package com.actionmedia.components;

import java.util.Date;

public class PublicationDocument {

    private Date publicationDate;
    private int moduleId;
    private int documentId;
    private String dataSource;
    private int pubId;

    public PublicationDocument(Date publicationDate, int moduleId, int documentId, String dataSource, int pubId) {
        this.publicationDate = publicationDate;
        this.moduleId = moduleId;
        this.documentId = documentId;
        this.dataSource = dataSource;
        this.pubId = pubId;
    }

    public PublicationDocument(int moduleId, int documentId) {
        this.moduleId = moduleId;
        this.documentId = documentId;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public int getModuleId() {
        return moduleId;
    }

    public int getDocumentId() {
        return documentId;
    }

    public String getDataSource() {
        return dataSource;
    }

    public int getPubId() {
        return pubId;
    }
}
