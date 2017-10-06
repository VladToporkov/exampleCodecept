/**
 * SearchLaw.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class SearchLaw  implements java.io.Serializable {
    private java.lang.String searchString;

    private org.apache.axis.types.UnsignedByte pubId;

    private org.apache.axis.types.UnsignedByte pubDivId;

    private int[] excludedModules;

    private int[] searchTagList;

    private org.apache.axis.types.UnsignedByte sortOrder;

    private java.lang.Integer searchOptionFlags;

    private java.lang.Integer snippetSize;

    private java.lang.Integer docPosition;

    private java.lang.Integer pageSize;

    private java.lang.String searchType;

    private org.apache.axis.types.UnsignedByte statusFilter;

    private int[] docRegionIdList;

    private int[] docTypeIdList;

    private int[] docLobbyIdList;

    private int[] docCategoryIdList;

    private java.lang.String docNumber;

    private java.util.Calendar pubDateStartedOn;

    private java.util.Calendar pubDateEndedOn;

    private java.lang.String[] searchPrevStringList;

    private org.apache.axis.types.UnsignedByte moduleIdBacklink;

    private java.lang.Integer idBacklink;

    private java.lang.Integer phraseIdBacklink;

    private java.lang.String userRegionCode;

    private java.lang.Integer pageCount;

    private int[] areaId;

    public SearchLaw() {
    }

    public SearchLaw(
           java.lang.String searchString,
           org.apache.axis.types.UnsignedByte pubId,
           org.apache.axis.types.UnsignedByte pubDivId,
           int[] excludedModules,
           int[] searchTagList,
           org.apache.axis.types.UnsignedByte sortOrder,
           java.lang.Integer searchOptionFlags,
           java.lang.Integer snippetSize,
           java.lang.Integer docPosition,
           java.lang.Integer pageSize,
           java.lang.String searchType,
           org.apache.axis.types.UnsignedByte statusFilter,
           int[] docRegionIdList,
           int[] docTypeIdList,
           int[] docLobbyIdList,
           int[] docCategoryIdList,
           java.lang.String docNumber,
           java.util.Calendar pubDateStartedOn,
           java.util.Calendar pubDateEndedOn,
           java.lang.String[] searchPrevStringList,
           org.apache.axis.types.UnsignedByte moduleIdBacklink,
           java.lang.Integer idBacklink,
           java.lang.Integer phraseIdBacklink,
           java.lang.String userRegionCode,
           java.lang.Integer pageCount,
           int[] areaId) {
           this.searchString = searchString;
           this.pubId = pubId;
           this.pubDivId = pubDivId;
           this.excludedModules = excludedModules;
           this.searchTagList = searchTagList;
           this.sortOrder = sortOrder;
           this.searchOptionFlags = searchOptionFlags;
           this.snippetSize = snippetSize;
           this.docPosition = docPosition;
           this.pageSize = pageSize;
           this.searchType = searchType;
           this.statusFilter = statusFilter;
           this.docRegionIdList = docRegionIdList;
           this.docTypeIdList = docTypeIdList;
           this.docLobbyIdList = docLobbyIdList;
           this.docCategoryIdList = docCategoryIdList;
           this.docNumber = docNumber;
           this.pubDateStartedOn = pubDateStartedOn;
           this.pubDateEndedOn = pubDateEndedOn;
           this.searchPrevStringList = searchPrevStringList;
           this.moduleIdBacklink = moduleIdBacklink;
           this.idBacklink = idBacklink;
           this.phraseIdBacklink = phraseIdBacklink;
           this.userRegionCode = userRegionCode;
           this.pageCount = pageCount;
           this.areaId = areaId;
    }


    /**
     * Gets the searchString value for this SearchLaw.
     * 
     * @return searchString
     */
    public java.lang.String getSearchString() {
        return searchString;
    }


    /**
     * Sets the searchString value for this SearchLaw.
     * 
     * @param searchString
     */
    public void setSearchString(java.lang.String searchString) {
        this.searchString = searchString;
    }


    /**
     * Gets the pubId value for this SearchLaw.
     * 
     * @return pubId
     */
    public org.apache.axis.types.UnsignedByte getPubId() {
        return pubId;
    }


    /**
     * Sets the pubId value for this SearchLaw.
     * 
     * @param pubId
     */
    public void setPubId(org.apache.axis.types.UnsignedByte pubId) {
        this.pubId = pubId;
    }


    /**
     * Gets the pubDivId value for this SearchLaw.
     * 
     * @return pubDivId
     */
    public org.apache.axis.types.UnsignedByte getPubDivId() {
        return pubDivId;
    }


    /**
     * Sets the pubDivId value for this SearchLaw.
     * 
     * @param pubDivId
     */
    public void setPubDivId(org.apache.axis.types.UnsignedByte pubDivId) {
        this.pubDivId = pubDivId;
    }


    /**
     * Gets the excludedModules value for this SearchLaw.
     * 
     * @return excludedModules
     */
    public int[] getExcludedModules() {
        return excludedModules;
    }


    /**
     * Sets the excludedModules value for this SearchLaw.
     * 
     * @param excludedModules
     */
    public void setExcludedModules(int[] excludedModules) {
        this.excludedModules = excludedModules;
    }


    /**
     * Gets the searchTagList value for this SearchLaw.
     * 
     * @return searchTagList
     */
    public int[] getSearchTagList() {
        return searchTagList;
    }


    /**
     * Sets the searchTagList value for this SearchLaw.
     * 
     * @param searchTagList
     */
    public void setSearchTagList(int[] searchTagList) {
        this.searchTagList = searchTagList;
    }


    /**
     * Gets the sortOrder value for this SearchLaw.
     * 
     * @return sortOrder
     */
    public org.apache.axis.types.UnsignedByte getSortOrder() {
        return sortOrder;
    }


    /**
     * Sets the sortOrder value for this SearchLaw.
     * 
     * @param sortOrder
     */
    public void setSortOrder(org.apache.axis.types.UnsignedByte sortOrder) {
        this.sortOrder = sortOrder;
    }


    /**
     * Gets the searchOptionFlags value for this SearchLaw.
     * 
     * @return searchOptionFlags
     */
    public java.lang.Integer getSearchOptionFlags() {
        return searchOptionFlags;
    }


    /**
     * Sets the searchOptionFlags value for this SearchLaw.
     * 
     * @param searchOptionFlags
     */
    public void setSearchOptionFlags(java.lang.Integer searchOptionFlags) {
        this.searchOptionFlags = searchOptionFlags;
    }


    /**
     * Gets the snippetSize value for this SearchLaw.
     * 
     * @return snippetSize
     */
    public java.lang.Integer getSnippetSize() {
        return snippetSize;
    }


    /**
     * Sets the snippetSize value for this SearchLaw.
     * 
     * @param snippetSize
     */
    public void setSnippetSize(java.lang.Integer snippetSize) {
        this.snippetSize = snippetSize;
    }


    /**
     * Gets the docPosition value for this SearchLaw.
     * 
     * @return docPosition
     */
    public java.lang.Integer getDocPosition() {
        return docPosition;
    }


    /**
     * Sets the docPosition value for this SearchLaw.
     * 
     * @param docPosition
     */
    public void setDocPosition(java.lang.Integer docPosition) {
        this.docPosition = docPosition;
    }


    /**
     * Gets the pageSize value for this SearchLaw.
     * 
     * @return pageSize
     */
    public java.lang.Integer getPageSize() {
        return pageSize;
    }


    /**
     * Sets the pageSize value for this SearchLaw.
     * 
     * @param pageSize
     */
    public void setPageSize(java.lang.Integer pageSize) {
        this.pageSize = pageSize;
    }


    /**
     * Gets the searchType value for this SearchLaw.
     * 
     * @return searchType
     */
    public java.lang.String getSearchType() {
        return searchType;
    }


    /**
     * Sets the searchType value for this SearchLaw.
     * 
     * @param searchType
     */
    public void setSearchType(java.lang.String searchType) {
        this.searchType = searchType;
    }


    /**
     * Gets the statusFilter value for this SearchLaw.
     * 
     * @return statusFilter
     */
    public org.apache.axis.types.UnsignedByte getStatusFilter() {
        return statusFilter;
    }


    /**
     * Sets the statusFilter value for this SearchLaw.
     * 
     * @param statusFilter
     */
    public void setStatusFilter(org.apache.axis.types.UnsignedByte statusFilter) {
        this.statusFilter = statusFilter;
    }


    /**
     * Gets the docRegionIdList value for this SearchLaw.
     * 
     * @return docRegionIdList
     */
    public int[] getDocRegionIdList() {
        return docRegionIdList;
    }


    /**
     * Sets the docRegionIdList value for this SearchLaw.
     * 
     * @param docRegionIdList
     */
    public void setDocRegionIdList(int[] docRegionIdList) {
        this.docRegionIdList = docRegionIdList;
    }


    /**
     * Gets the docTypeIdList value for this SearchLaw.
     * 
     * @return docTypeIdList
     */
    public int[] getDocTypeIdList() {
        return docTypeIdList;
    }


    /**
     * Sets the docTypeIdList value for this SearchLaw.
     * 
     * @param docTypeIdList
     */
    public void setDocTypeIdList(int[] docTypeIdList) {
        this.docTypeIdList = docTypeIdList;
    }


    /**
     * Gets the docLobbyIdList value for this SearchLaw.
     * 
     * @return docLobbyIdList
     */
    public int[] getDocLobbyIdList() {
        return docLobbyIdList;
    }


    /**
     * Sets the docLobbyIdList value for this SearchLaw.
     * 
     * @param docLobbyIdList
     */
    public void setDocLobbyIdList(int[] docLobbyIdList) {
        this.docLobbyIdList = docLobbyIdList;
    }


    /**
     * Gets the docCategoryIdList value for this SearchLaw.
     * 
     * @return docCategoryIdList
     */
    public int[] getDocCategoryIdList() {
        return docCategoryIdList;
    }


    /**
     * Sets the docCategoryIdList value for this SearchLaw.
     * 
     * @param docCategoryIdList
     */
    public void setDocCategoryIdList(int[] docCategoryIdList) {
        this.docCategoryIdList = docCategoryIdList;
    }


    /**
     * Gets the docNumber value for this SearchLaw.
     * 
     * @return docNumber
     */
    public java.lang.String getDocNumber() {
        return docNumber;
    }


    /**
     * Sets the docNumber value for this SearchLaw.
     * 
     * @param docNumber
     */
    public void setDocNumber(java.lang.String docNumber) {
        this.docNumber = docNumber;
    }


    /**
     * Gets the pubDateStartedOn value for this SearchLaw.
     * 
     * @return pubDateStartedOn
     */
    public java.util.Calendar getPubDateStartedOn() {
        return pubDateStartedOn;
    }


    /**
     * Sets the pubDateStartedOn value for this SearchLaw.
     * 
     * @param pubDateStartedOn
     */
    public void setPubDateStartedOn(java.util.Calendar pubDateStartedOn) {
        this.pubDateStartedOn = pubDateStartedOn;
    }


    /**
     * Gets the pubDateEndedOn value for this SearchLaw.
     * 
     * @return pubDateEndedOn
     */
    public java.util.Calendar getPubDateEndedOn() {
        return pubDateEndedOn;
    }


    /**
     * Sets the pubDateEndedOn value for this SearchLaw.
     * 
     * @param pubDateEndedOn
     */
    public void setPubDateEndedOn(java.util.Calendar pubDateEndedOn) {
        this.pubDateEndedOn = pubDateEndedOn;
    }


    /**
     * Gets the searchPrevStringList value for this SearchLaw.
     * 
     * @return searchPrevStringList
     */
    public java.lang.String[] getSearchPrevStringList() {
        return searchPrevStringList;
    }


    /**
     * Sets the searchPrevStringList value for this SearchLaw.
     * 
     * @param searchPrevStringList
     */
    public void setSearchPrevStringList(java.lang.String[] searchPrevStringList) {
        this.searchPrevStringList = searchPrevStringList;
    }


    /**
     * Gets the moduleIdBacklink value for this SearchLaw.
     * 
     * @return moduleIdBacklink
     */
    public org.apache.axis.types.UnsignedByte getModuleIdBacklink() {
        return moduleIdBacklink;
    }


    /**
     * Sets the moduleIdBacklink value for this SearchLaw.
     * 
     * @param moduleIdBacklink
     */
    public void setModuleIdBacklink(org.apache.axis.types.UnsignedByte moduleIdBacklink) {
        this.moduleIdBacklink = moduleIdBacklink;
    }


    /**
     * Gets the idBacklink value for this SearchLaw.
     * 
     * @return idBacklink
     */
    public java.lang.Integer getIdBacklink() {
        return idBacklink;
    }


    /**
     * Sets the idBacklink value for this SearchLaw.
     * 
     * @param idBacklink
     */
    public void setIdBacklink(java.lang.Integer idBacklink) {
        this.idBacklink = idBacklink;
    }


    /**
     * Gets the phraseIdBacklink value for this SearchLaw.
     * 
     * @return phraseIdBacklink
     */
    public java.lang.Integer getPhraseIdBacklink() {
        return phraseIdBacklink;
    }


    /**
     * Sets the phraseIdBacklink value for this SearchLaw.
     * 
     * @param phraseIdBacklink
     */
    public void setPhraseIdBacklink(java.lang.Integer phraseIdBacklink) {
        this.phraseIdBacklink = phraseIdBacklink;
    }


    /**
     * Gets the userRegionCode value for this SearchLaw.
     * 
     * @return userRegionCode
     */
    public java.lang.String getUserRegionCode() {
        return userRegionCode;
    }


    /**
     * Sets the userRegionCode value for this SearchLaw.
     * 
     * @param userRegionCode
     */
    public void setUserRegionCode(java.lang.String userRegionCode) {
        this.userRegionCode = userRegionCode;
    }


    /**
     * Gets the pageCount value for this SearchLaw.
     * 
     * @return pageCount
     */
    public java.lang.Integer getPageCount() {
        return pageCount;
    }


    /**
     * Sets the pageCount value for this SearchLaw.
     * 
     * @param pageCount
     */
    public void setPageCount(java.lang.Integer pageCount) {
        this.pageCount = pageCount;
    }


    /**
     * Gets the areaId value for this SearchLaw.
     * 
     * @return areaId
     */
    public int[] getAreaId() {
        return areaId;
    }


    /**
     * Sets the areaId value for this SearchLaw.
     * 
     * @param areaId
     */
    public void setAreaId(int[] areaId) {
        this.areaId = areaId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchLaw)) return false;
        SearchLaw other = (SearchLaw) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.searchString==null && other.getSearchString()==null) || 
             (this.searchString!=null &&
              this.searchString.equals(other.getSearchString()))) &&
            ((this.pubId==null && other.getPubId()==null) || 
             (this.pubId!=null &&
              this.pubId.equals(other.getPubId()))) &&
            ((this.pubDivId==null && other.getPubDivId()==null) || 
             (this.pubDivId!=null &&
              this.pubDivId.equals(other.getPubDivId()))) &&
            ((this.excludedModules==null && other.getExcludedModules()==null) || 
             (this.excludedModules!=null &&
              java.util.Arrays.equals(this.excludedModules, other.getExcludedModules()))) &&
            ((this.searchTagList==null && other.getSearchTagList()==null) || 
             (this.searchTagList!=null &&
              java.util.Arrays.equals(this.searchTagList, other.getSearchTagList()))) &&
            ((this.sortOrder==null && other.getSortOrder()==null) || 
             (this.sortOrder!=null &&
              this.sortOrder.equals(other.getSortOrder()))) &&
            ((this.searchOptionFlags==null && other.getSearchOptionFlags()==null) || 
             (this.searchOptionFlags!=null &&
              this.searchOptionFlags.equals(other.getSearchOptionFlags()))) &&
            ((this.snippetSize==null && other.getSnippetSize()==null) || 
             (this.snippetSize!=null &&
              this.snippetSize.equals(other.getSnippetSize()))) &&
            ((this.docPosition==null && other.getDocPosition()==null) || 
             (this.docPosition!=null &&
              this.docPosition.equals(other.getDocPosition()))) &&
            ((this.pageSize==null && other.getPageSize()==null) || 
             (this.pageSize!=null &&
              this.pageSize.equals(other.getPageSize()))) &&
            ((this.searchType==null && other.getSearchType()==null) || 
             (this.searchType!=null &&
              this.searchType.equals(other.getSearchType()))) &&
            ((this.statusFilter==null && other.getStatusFilter()==null) || 
             (this.statusFilter!=null &&
              this.statusFilter.equals(other.getStatusFilter()))) &&
            ((this.docRegionIdList==null && other.getDocRegionIdList()==null) || 
             (this.docRegionIdList!=null &&
              java.util.Arrays.equals(this.docRegionIdList, other.getDocRegionIdList()))) &&
            ((this.docTypeIdList==null && other.getDocTypeIdList()==null) || 
             (this.docTypeIdList!=null &&
              java.util.Arrays.equals(this.docTypeIdList, other.getDocTypeIdList()))) &&
            ((this.docLobbyIdList==null && other.getDocLobbyIdList()==null) || 
             (this.docLobbyIdList!=null &&
              java.util.Arrays.equals(this.docLobbyIdList, other.getDocLobbyIdList()))) &&
            ((this.docCategoryIdList==null && other.getDocCategoryIdList()==null) || 
             (this.docCategoryIdList!=null &&
              java.util.Arrays.equals(this.docCategoryIdList, other.getDocCategoryIdList()))) &&
            ((this.docNumber==null && other.getDocNumber()==null) || 
             (this.docNumber!=null &&
              this.docNumber.equals(other.getDocNumber()))) &&
            ((this.pubDateStartedOn==null && other.getPubDateStartedOn()==null) || 
             (this.pubDateStartedOn!=null &&
              this.pubDateStartedOn.equals(other.getPubDateStartedOn()))) &&
            ((this.pubDateEndedOn==null && other.getPubDateEndedOn()==null) || 
             (this.pubDateEndedOn!=null &&
              this.pubDateEndedOn.equals(other.getPubDateEndedOn()))) &&
            ((this.searchPrevStringList==null && other.getSearchPrevStringList()==null) || 
             (this.searchPrevStringList!=null &&
              java.util.Arrays.equals(this.searchPrevStringList, other.getSearchPrevStringList()))) &&
            ((this.moduleIdBacklink==null && other.getModuleIdBacklink()==null) || 
             (this.moduleIdBacklink!=null &&
              this.moduleIdBacklink.equals(other.getModuleIdBacklink()))) &&
            ((this.idBacklink==null && other.getIdBacklink()==null) || 
             (this.idBacklink!=null &&
              this.idBacklink.equals(other.getIdBacklink()))) &&
            ((this.phraseIdBacklink==null && other.getPhraseIdBacklink()==null) || 
             (this.phraseIdBacklink!=null &&
              this.phraseIdBacklink.equals(other.getPhraseIdBacklink()))) &&
            ((this.userRegionCode==null && other.getUserRegionCode()==null) || 
             (this.userRegionCode!=null &&
              this.userRegionCode.equals(other.getUserRegionCode()))) &&
            ((this.pageCount==null && other.getPageCount()==null) || 
             (this.pageCount!=null &&
              this.pageCount.equals(other.getPageCount()))) &&
            ((this.areaId==null && other.getAreaId()==null) || 
             (this.areaId!=null &&
              java.util.Arrays.equals(this.areaId, other.getAreaId())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getSearchString() != null) {
            _hashCode += getSearchString().hashCode();
        }
        if (getPubId() != null) {
            _hashCode += getPubId().hashCode();
        }
        if (getPubDivId() != null) {
            _hashCode += getPubDivId().hashCode();
        }
        if (getExcludedModules() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getExcludedModules());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getExcludedModules(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSearchTagList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSearchTagList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSearchTagList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSortOrder() != null) {
            _hashCode += getSortOrder().hashCode();
        }
        if (getSearchOptionFlags() != null) {
            _hashCode += getSearchOptionFlags().hashCode();
        }
        if (getSnippetSize() != null) {
            _hashCode += getSnippetSize().hashCode();
        }
        if (getDocPosition() != null) {
            _hashCode += getDocPosition().hashCode();
        }
        if (getPageSize() != null) {
            _hashCode += getPageSize().hashCode();
        }
        if (getSearchType() != null) {
            _hashCode += getSearchType().hashCode();
        }
        if (getStatusFilter() != null) {
            _hashCode += getStatusFilter().hashCode();
        }
        if (getDocRegionIdList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDocRegionIdList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDocRegionIdList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDocTypeIdList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDocTypeIdList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDocTypeIdList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDocLobbyIdList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDocLobbyIdList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDocLobbyIdList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDocCategoryIdList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDocCategoryIdList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDocCategoryIdList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDocNumber() != null) {
            _hashCode += getDocNumber().hashCode();
        }
        if (getPubDateStartedOn() != null) {
            _hashCode += getPubDateStartedOn().hashCode();
        }
        if (getPubDateEndedOn() != null) {
            _hashCode += getPubDateEndedOn().hashCode();
        }
        if (getSearchPrevStringList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSearchPrevStringList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSearchPrevStringList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getModuleIdBacklink() != null) {
            _hashCode += getModuleIdBacklink().hashCode();
        }
        if (getIdBacklink() != null) {
            _hashCode += getIdBacklink().hashCode();
        }
        if (getPhraseIdBacklink() != null) {
            _hashCode += getPhraseIdBacklink().hashCode();
        }
        if (getUserRegionCode() != null) {
            _hashCode += getUserRegionCode().hashCode();
        }
        if (getPageCount() != null) {
            _hashCode += getPageCount().hashCode();
        }
        if (getAreaId() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAreaId());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAreaId(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchLaw.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SearchLaw"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchString");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "searchString"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "pubId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubDivId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "pubDivId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("excludedModules");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "excludedModules"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchTagList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "searchTagList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sortOrder");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sortOrder"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchOptionFlags");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "searchOptionFlags"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("snippetSize");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "snippetSize"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docPosition");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "docPosition"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pageSize");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "pageSize"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "searchType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statusFilter");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "statusFilter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docRegionIdList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "docRegionIdList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docTypeIdList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "docTypeIdList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docLobbyIdList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "docLobbyIdList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docCategoryIdList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "docCategoryIdList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "docNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubDateStartedOn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "pubDateStartedOn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubDateEndedOn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "pubDateEndedOn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchPrevStringList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "searchPrevStringList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moduleIdBacklink");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "moduleIdBacklink"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idBacklink");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "idBacklink"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phraseIdBacklink");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "phraseIdBacklink"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userRegionCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "userRegionCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pageCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "pageCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("areaId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "areaId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "int"));
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
