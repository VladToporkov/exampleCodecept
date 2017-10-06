/**
 * ExecuteGetNpdDocumentInfoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.exportnpdservice;

public class ExecuteGetNpdDocumentInfoResponse  extends com.actionmedia.webservice.exportnpdservice.ExecuteResponse  implements java.io.Serializable {
    private boolean docExists;

    private com.actionmedia.webservice.exportnpdservice.TimeMachinePosition docActualityStatus;

    private int documentID;

    private org.apache.axis.types.UnsignedByte moduleID;

    private java.lang.String anchor;

    private java.lang.String documentName;

    private java.util.Calendar publicationDate;

    private java.lang.String attributes;

    private int ownedDocumentCount;

    private java.lang.String[] lobbies;

    private java.lang.String[] numbers;

    private com.actionmedia.webservice.exportnpdservice.DocumentType[] types;

    private java.lang.String[] regions;

    private java.lang.String toc;

    private java.lang.String tocXml;

    private java.util.Calendar begDate;

    private java.util.Calendar endDate;

    private java.util.Calendar modifyDate;

    private com.actionmedia.webservice.exportnpdservice.DocumentAttribute[] attributeList;

    private com.actionmedia.webservice.exportnpdservice.DocumentChainItem[] documentChain;

    private java.lang.String operInfo;

    private com.actionmedia.webservice.exportnpdservice.Attachment[] attachments;

    private com.actionmedia.webservice.exportnpdservice.AttachBarcode[] attachBarcodes;

    private int[] parts;

    private int anchoredPart;

    private boolean isActual;

    private int actualDocId;

    private int actualDocModuleId;

    private boolean isDocInActualCheck;

    public ExecuteGetNpdDocumentInfoResponse() {
    }

    public ExecuteGetNpdDocumentInfoResponse(
           long durationInMSec,
           boolean docExists,
           com.actionmedia.webservice.exportnpdservice.TimeMachinePosition docActualityStatus,
           int documentID,
           org.apache.axis.types.UnsignedByte moduleID,
           java.lang.String anchor,
           java.lang.String documentName,
           java.util.Calendar publicationDate,
           java.lang.String attributes,
           int ownedDocumentCount,
           java.lang.String[] lobbies,
           java.lang.String[] numbers,
           com.actionmedia.webservice.exportnpdservice.DocumentType[] types,
           java.lang.String[] regions,
           java.lang.String toc,
           java.lang.String tocXml,
           java.util.Calendar begDate,
           java.util.Calendar endDate,
           java.util.Calendar modifyDate,
           com.actionmedia.webservice.exportnpdservice.DocumentAttribute[] attributeList,
           com.actionmedia.webservice.exportnpdservice.DocumentChainItem[] documentChain,
           java.lang.String operInfo,
           com.actionmedia.webservice.exportnpdservice.Attachment[] attachments,
           com.actionmedia.webservice.exportnpdservice.AttachBarcode[] attachBarcodes,
           int[] parts,
           int anchoredPart,
           boolean isActual,
           int actualDocId,
           int actualDocModuleId,
           boolean isDocInActualCheck) {
        super(
            durationInMSec);
        this.docExists = docExists;
        this.docActualityStatus = docActualityStatus;
        this.documentID = documentID;
        this.moduleID = moduleID;
        this.anchor = anchor;
        this.documentName = documentName;
        this.publicationDate = publicationDate;
        this.attributes = attributes;
        this.ownedDocumentCount = ownedDocumentCount;
        this.lobbies = lobbies;
        this.numbers = numbers;
        this.types = types;
        this.regions = regions;
        this.toc = toc;
        this.tocXml = tocXml;
        this.begDate = begDate;
        this.endDate = endDate;
        this.modifyDate = modifyDate;
        this.attributeList = attributeList;
        this.documentChain = documentChain;
        this.operInfo = operInfo;
        this.attachments = attachments;
        this.attachBarcodes = attachBarcodes;
        this.parts = parts;
        this.anchoredPart = anchoredPart;
        this.isActual = isActual;
        this.actualDocId = actualDocId;
        this.actualDocModuleId = actualDocModuleId;
        this.isDocInActualCheck = isDocInActualCheck;
    }


    /**
     * Gets the docExists value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @return docExists
     */
    public boolean isDocExists() {
        return docExists;
    }


    /**
     * Sets the docExists value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @param docExists
     */
    public void setDocExists(boolean docExists) {
        this.docExists = docExists;
    }


    /**
     * Gets the docActualityStatus value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @return docActualityStatus
     */
    public com.actionmedia.webservice.exportnpdservice.TimeMachinePosition getDocActualityStatus() {
        return docActualityStatus;
    }


    /**
     * Sets the docActualityStatus value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @param docActualityStatus
     */
    public void setDocActualityStatus(com.actionmedia.webservice.exportnpdservice.TimeMachinePosition docActualityStatus) {
        this.docActualityStatus = docActualityStatus;
    }


    /**
     * Gets the documentID value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @return documentID
     */
    public int getDocumentID() {
        return documentID;
    }


    /**
     * Sets the documentID value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @param documentID
     */
    public void setDocumentID(int documentID) {
        this.documentID = documentID;
    }


    /**
     * Gets the moduleID value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @return moduleID
     */
    public org.apache.axis.types.UnsignedByte getModuleID() {
        return moduleID;
    }


    /**
     * Sets the moduleID value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @param moduleID
     */
    public void setModuleID(org.apache.axis.types.UnsignedByte moduleID) {
        this.moduleID = moduleID;
    }


    /**
     * Gets the anchor value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @return anchor
     */
    public java.lang.String getAnchor() {
        return anchor;
    }


    /**
     * Sets the anchor value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @param anchor
     */
    public void setAnchor(java.lang.String anchor) {
        this.anchor = anchor;
    }


    /**
     * Gets the documentName value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @return documentName
     */
    public java.lang.String getDocumentName() {
        return documentName;
    }


    /**
     * Sets the documentName value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @param documentName
     */
    public void setDocumentName(java.lang.String documentName) {
        this.documentName = documentName;
    }


    /**
     * Gets the publicationDate value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @return publicationDate
     */
    public java.util.Calendar getPublicationDate() {
        return publicationDate;
    }


    /**
     * Sets the publicationDate value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @param publicationDate
     */
    public void setPublicationDate(java.util.Calendar publicationDate) {
        this.publicationDate = publicationDate;
    }


    /**
     * Gets the attributes value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @return attributes
     */
    public java.lang.String getAttributes() {
        return attributes;
    }


    /**
     * Sets the attributes value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @param attributes
     */
    public void setAttributes(java.lang.String attributes) {
        this.attributes = attributes;
    }


    /**
     * Gets the ownedDocumentCount value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @return ownedDocumentCount
     */
    public int getOwnedDocumentCount() {
        return ownedDocumentCount;
    }


    /**
     * Sets the ownedDocumentCount value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @param ownedDocumentCount
     */
    public void setOwnedDocumentCount(int ownedDocumentCount) {
        this.ownedDocumentCount = ownedDocumentCount;
    }


    /**
     * Gets the lobbies value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @return lobbies
     */
    public java.lang.String[] getLobbies() {
        return lobbies;
    }


    /**
     * Sets the lobbies value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @param lobbies
     */
    public void setLobbies(java.lang.String[] lobbies) {
        this.lobbies = lobbies;
    }

    public java.lang.String getLobbies(int i) {
        return this.lobbies[i];
    }

    public void setLobbies(int i, java.lang.String _value) {
        this.lobbies[i] = _value;
    }


    /**
     * Gets the numbers value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @return numbers
     */
    public java.lang.String[] getNumbers() {
        return numbers;
    }


    /**
     * Sets the numbers value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @param numbers
     */
    public void setNumbers(java.lang.String[] numbers) {
        this.numbers = numbers;
    }

    public java.lang.String getNumbers(int i) {
        return this.numbers[i];
    }

    public void setNumbers(int i, java.lang.String _value) {
        this.numbers[i] = _value;
    }


    /**
     * Gets the types value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @return types
     */
    public com.actionmedia.webservice.exportnpdservice.DocumentType[] getTypes() {
        return types;
    }


    /**
     * Sets the types value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @param types
     */
    public void setTypes(com.actionmedia.webservice.exportnpdservice.DocumentType[] types) {
        this.types = types;
    }

    public com.actionmedia.webservice.exportnpdservice.DocumentType getTypes(int i) {
        return this.types[i];
    }

    public void setTypes(int i, com.actionmedia.webservice.exportnpdservice.DocumentType _value) {
        this.types[i] = _value;
    }


    /**
     * Gets the regions value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @return regions
     */
    public java.lang.String[] getRegions() {
        return regions;
    }


    /**
     * Sets the regions value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @param regions
     */
    public void setRegions(java.lang.String[] regions) {
        this.regions = regions;
    }

    public java.lang.String getRegions(int i) {
        return this.regions[i];
    }

    public void setRegions(int i, java.lang.String _value) {
        this.regions[i] = _value;
    }


    /**
     * Gets the toc value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @return toc
     */
    public java.lang.String getToc() {
        return toc;
    }


    /**
     * Sets the toc value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @param toc
     */
    public void setToc(java.lang.String toc) {
        this.toc = toc;
    }


    /**
     * Gets the tocXml value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @return tocXml
     */
    public java.lang.String getTocXml() {
        return tocXml;
    }


    /**
     * Sets the tocXml value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @param tocXml
     */
    public void setTocXml(java.lang.String tocXml) {
        this.tocXml = tocXml;
    }


    /**
     * Gets the begDate value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @return begDate
     */
    public java.util.Calendar getBegDate() {
        return begDate;
    }


    /**
     * Sets the begDate value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @param begDate
     */
    public void setBegDate(java.util.Calendar begDate) {
        this.begDate = begDate;
    }


    /**
     * Gets the endDate value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @return endDate
     */
    public java.util.Calendar getEndDate() {
        return endDate;
    }


    /**
     * Sets the endDate value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @param endDate
     */
    public void setEndDate(java.util.Calendar endDate) {
        this.endDate = endDate;
    }


    /**
     * Gets the modifyDate value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @return modifyDate
     */
    public java.util.Calendar getModifyDate() {
        return modifyDate;
    }


    /**
     * Sets the modifyDate value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @param modifyDate
     */
    public void setModifyDate(java.util.Calendar modifyDate) {
        this.modifyDate = modifyDate;
    }


    /**
     * Gets the attributeList value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @return attributeList
     */
    public com.actionmedia.webservice.exportnpdservice.DocumentAttribute[] getAttributeList() {
        return attributeList;
    }


    /**
     * Sets the attributeList value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @param attributeList
     */
    public void setAttributeList(com.actionmedia.webservice.exportnpdservice.DocumentAttribute[] attributeList) {
        this.attributeList = attributeList;
    }

    public com.actionmedia.webservice.exportnpdservice.DocumentAttribute getAttributeList(int i) {
        return this.attributeList[i];
    }

    public void setAttributeList(int i, com.actionmedia.webservice.exportnpdservice.DocumentAttribute _value) {
        this.attributeList[i] = _value;
    }


    /**
     * Gets the documentChain value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @return documentChain
     */
    public com.actionmedia.webservice.exportnpdservice.DocumentChainItem[] getDocumentChain() {
        return documentChain;
    }


    /**
     * Sets the documentChain value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @param documentChain
     */
    public void setDocumentChain(com.actionmedia.webservice.exportnpdservice.DocumentChainItem[] documentChain) {
        this.documentChain = documentChain;
    }

    public com.actionmedia.webservice.exportnpdservice.DocumentChainItem getDocumentChain(int i) {
        return this.documentChain[i];
    }

    public void setDocumentChain(int i, com.actionmedia.webservice.exportnpdservice.DocumentChainItem _value) {
        this.documentChain[i] = _value;
    }


    /**
     * Gets the operInfo value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @return operInfo
     */
    public java.lang.String getOperInfo() {
        return operInfo;
    }


    /**
     * Sets the operInfo value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @param operInfo
     */
    public void setOperInfo(java.lang.String operInfo) {
        this.operInfo = operInfo;
    }


    /**
     * Gets the attachments value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @return attachments
     */
    public com.actionmedia.webservice.exportnpdservice.Attachment[] getAttachments() {
        return attachments;
    }


    /**
     * Sets the attachments value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @param attachments
     */
    public void setAttachments(com.actionmedia.webservice.exportnpdservice.Attachment[] attachments) {
        this.attachments = attachments;
    }


    /**
     * Gets the attachBarcodes value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @return attachBarcodes
     */
    public com.actionmedia.webservice.exportnpdservice.AttachBarcode[] getAttachBarcodes() {
        return attachBarcodes;
    }


    /**
     * Sets the attachBarcodes value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @param attachBarcodes
     */
    public void setAttachBarcodes(com.actionmedia.webservice.exportnpdservice.AttachBarcode[] attachBarcodes) {
        this.attachBarcodes = attachBarcodes;
    }


    /**
     * Gets the parts value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @return parts
     */
    public int[] getParts() {
        return parts;
    }


    /**
     * Sets the parts value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @param parts
     */
    public void setParts(int[] parts) {
        this.parts = parts;
    }


    /**
     * Gets the anchoredPart value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @return anchoredPart
     */
    public int getAnchoredPart() {
        return anchoredPart;
    }


    /**
     * Sets the anchoredPart value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @param anchoredPart
     */
    public void setAnchoredPart(int anchoredPart) {
        this.anchoredPart = anchoredPart;
    }


    /**
     * Gets the isActual value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @return isActual
     */
    public boolean isIsActual() {
        return isActual;
    }


    /**
     * Sets the isActual value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @param isActual
     */
    public void setIsActual(boolean isActual) {
        this.isActual = isActual;
    }


    /**
     * Gets the actualDocId value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @return actualDocId
     */
    public int getActualDocId() {
        return actualDocId;
    }


    /**
     * Sets the actualDocId value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @param actualDocId
     */
    public void setActualDocId(int actualDocId) {
        this.actualDocId = actualDocId;
    }


    /**
     * Gets the actualDocModuleId value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @return actualDocModuleId
     */
    public int getActualDocModuleId() {
        return actualDocModuleId;
    }


    /**
     * Sets the actualDocModuleId value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @param actualDocModuleId
     */
    public void setActualDocModuleId(int actualDocModuleId) {
        this.actualDocModuleId = actualDocModuleId;
    }


    /**
     * Gets the isDocInActualCheck value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @return isDocInActualCheck
     */
    public boolean isIsDocInActualCheck() {
        return isDocInActualCheck;
    }


    /**
     * Sets the isDocInActualCheck value for this ExecuteGetNpdDocumentInfoResponse.
     * 
     * @param isDocInActualCheck
     */
    public void setIsDocInActualCheck(boolean isDocInActualCheck) {
        this.isDocInActualCheck = isDocInActualCheck;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExecuteGetNpdDocumentInfoResponse)) return false;
        ExecuteGetNpdDocumentInfoResponse other = (ExecuteGetNpdDocumentInfoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.docExists == other.isDocExists() &&
            ((this.docActualityStatus==null && other.getDocActualityStatus()==null) || 
             (this.docActualityStatus!=null &&
              this.docActualityStatus.equals(other.getDocActualityStatus()))) &&
            this.documentID == other.getDocumentID() &&
            ((this.moduleID==null && other.getModuleID()==null) || 
             (this.moduleID!=null &&
              this.moduleID.equals(other.getModuleID()))) &&
            ((this.anchor==null && other.getAnchor()==null) || 
             (this.anchor!=null &&
              this.anchor.equals(other.getAnchor()))) &&
            ((this.documentName==null && other.getDocumentName()==null) || 
             (this.documentName!=null &&
              this.documentName.equals(other.getDocumentName()))) &&
            ((this.publicationDate==null && other.getPublicationDate()==null) || 
             (this.publicationDate!=null &&
              this.publicationDate.equals(other.getPublicationDate()))) &&
            ((this.attributes==null && other.getAttributes()==null) || 
             (this.attributes!=null &&
              this.attributes.equals(other.getAttributes()))) &&
            this.ownedDocumentCount == other.getOwnedDocumentCount() &&
            ((this.lobbies==null && other.getLobbies()==null) || 
             (this.lobbies!=null &&
              java.util.Arrays.equals(this.lobbies, other.getLobbies()))) &&
            ((this.numbers==null && other.getNumbers()==null) || 
             (this.numbers!=null &&
              java.util.Arrays.equals(this.numbers, other.getNumbers()))) &&
            ((this.types==null && other.getTypes()==null) || 
             (this.types!=null &&
              java.util.Arrays.equals(this.types, other.getTypes()))) &&
            ((this.regions==null && other.getRegions()==null) || 
             (this.regions!=null &&
              java.util.Arrays.equals(this.regions, other.getRegions()))) &&
            ((this.toc==null && other.getToc()==null) || 
             (this.toc!=null &&
              this.toc.equals(other.getToc()))) &&
            ((this.tocXml==null && other.getTocXml()==null) || 
             (this.tocXml!=null &&
              this.tocXml.equals(other.getTocXml()))) &&
            ((this.begDate==null && other.getBegDate()==null) || 
             (this.begDate!=null &&
              this.begDate.equals(other.getBegDate()))) &&
            ((this.endDate==null && other.getEndDate()==null) || 
             (this.endDate!=null &&
              this.endDate.equals(other.getEndDate()))) &&
            ((this.modifyDate==null && other.getModifyDate()==null) || 
             (this.modifyDate!=null &&
              this.modifyDate.equals(other.getModifyDate()))) &&
            ((this.attributeList==null && other.getAttributeList()==null) || 
             (this.attributeList!=null &&
              java.util.Arrays.equals(this.attributeList, other.getAttributeList()))) &&
            ((this.documentChain==null && other.getDocumentChain()==null) || 
             (this.documentChain!=null &&
              java.util.Arrays.equals(this.documentChain, other.getDocumentChain()))) &&
            ((this.operInfo==null && other.getOperInfo()==null) || 
             (this.operInfo!=null &&
              this.operInfo.equals(other.getOperInfo()))) &&
            ((this.attachments==null && other.getAttachments()==null) || 
             (this.attachments!=null &&
              java.util.Arrays.equals(this.attachments, other.getAttachments()))) &&
            ((this.attachBarcodes==null && other.getAttachBarcodes()==null) || 
             (this.attachBarcodes!=null &&
              java.util.Arrays.equals(this.attachBarcodes, other.getAttachBarcodes()))) &&
            ((this.parts==null && other.getParts()==null) || 
             (this.parts!=null &&
              java.util.Arrays.equals(this.parts, other.getParts()))) &&
            this.anchoredPart == other.getAnchoredPart() &&
            this.isActual == other.isIsActual() &&
            this.actualDocId == other.getActualDocId() &&
            this.actualDocModuleId == other.getActualDocModuleId() &&
            this.isDocInActualCheck == other.isIsDocInActualCheck();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        _hashCode += (isDocExists() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getDocActualityStatus() != null) {
            _hashCode += getDocActualityStatus().hashCode();
        }
        _hashCode += getDocumentID();
        if (getModuleID() != null) {
            _hashCode += getModuleID().hashCode();
        }
        if (getAnchor() != null) {
            _hashCode += getAnchor().hashCode();
        }
        if (getDocumentName() != null) {
            _hashCode += getDocumentName().hashCode();
        }
        if (getPublicationDate() != null) {
            _hashCode += getPublicationDate().hashCode();
        }
        if (getAttributes() != null) {
            _hashCode += getAttributes().hashCode();
        }
        _hashCode += getOwnedDocumentCount();
        if (getLobbies() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLobbies());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLobbies(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNumbers() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNumbers());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNumbers(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTypes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTypes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTypes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRegions() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRegions());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRegions(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getToc() != null) {
            _hashCode += getToc().hashCode();
        }
        if (getTocXml() != null) {
            _hashCode += getTocXml().hashCode();
        }
        if (getBegDate() != null) {
            _hashCode += getBegDate().hashCode();
        }
        if (getEndDate() != null) {
            _hashCode += getEndDate().hashCode();
        }
        if (getModifyDate() != null) {
            _hashCode += getModifyDate().hashCode();
        }
        if (getAttributeList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAttributeList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAttributeList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDocumentChain() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDocumentChain());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDocumentChain(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOperInfo() != null) {
            _hashCode += getOperInfo().hashCode();
        }
        if (getAttachments() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAttachments());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAttachments(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAttachBarcodes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAttachBarcodes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAttachBarcodes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getParts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getParts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getParts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getAnchoredPart();
        _hashCode += (isIsActual() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getActualDocId();
        _hashCode += getActualDocModuleId();
        _hashCode += (isIsDocInActualCheck() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExecuteGetNpdDocumentInfoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetNpdDocumentInfoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docExists");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "DocExists"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docActualityStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "DocActualityStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "TimeMachinePosition"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "DocumentID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moduleID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "ModuleID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anchor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "Anchor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "DocumentName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publicationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "PublicationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attributes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "Attributes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownedDocumentCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "OwnedDocumentCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lobbies");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "Lobbies"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numbers");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "Numbers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("types");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "Types"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "DocumentType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("regions");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "Regions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("toc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "Toc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tocXml");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "TocXml"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("begDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "BegDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "EndDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modifyDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "ModifyDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attributeList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "AttributeList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "DocumentAttribute"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentChain");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "DocumentChain"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "DocumentChainItem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "OperInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attachments");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "Attachments"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "Attachment"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.1gl.ru/", "Attachment"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attachBarcodes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "AttachBarcodes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "AttachBarcode"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.1gl.ru/", "AttachBarcode"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parts");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "Parts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.1gl.ru/", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anchoredPart");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "AnchoredPart"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isActual");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "IsActual"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("actualDocId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "ActualDocId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("actualDocModuleId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "ActualDocModuleId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isDocInActualCheck");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "IsDocInActualCheck"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
