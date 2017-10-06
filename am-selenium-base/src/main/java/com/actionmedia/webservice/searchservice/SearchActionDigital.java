/**
 * SearchActionDigital.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class SearchActionDigital  implements java.io.Serializable {
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

    private java.lang.Integer pageCount;

    private int[] areaId;

    public SearchActionDigital() {
    }

    public SearchActionDigital(
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
           this.pageCount = pageCount;
           this.areaId = areaId;
    }


    /**
     * Gets the searchString value for this SearchActionDigital.
     * 
     * @return searchString
     */
    public java.lang.String getSearchString() {
        return searchString;
    }


    /**
     * Sets the searchString value for this SearchActionDigital.
     * 
     * @param searchString
     */
    public void setSearchString(java.lang.String searchString) {
        this.searchString = searchString;
    }


    /**
     * Gets the pubId value for this SearchActionDigital.
     * 
     * @return pubId
     */
    public org.apache.axis.types.UnsignedByte getPubId() {
        return pubId;
    }


    /**
     * Sets the pubId value for this SearchActionDigital.
     * 
     * @param pubId
     */
    public void setPubId(org.apache.axis.types.UnsignedByte pubId) {
        this.pubId = pubId;
    }


    /**
     * Gets the pubDivId value for this SearchActionDigital.
     * 
     * @return pubDivId
     */
    public org.apache.axis.types.UnsignedByte getPubDivId() {
        return pubDivId;
    }


    /**
     * Sets the pubDivId value for this SearchActionDigital.
     * 
     * @param pubDivId
     */
    public void setPubDivId(org.apache.axis.types.UnsignedByte pubDivId) {
        this.pubDivId = pubDivId;
    }


    /**
     * Gets the excludedModules value for this SearchActionDigital.
     * 
     * @return excludedModules
     */
    public int[] getExcludedModules() {
        return excludedModules;
    }


    /**
     * Sets the excludedModules value for this SearchActionDigital.
     * 
     * @param excludedModules
     */
    public void setExcludedModules(int[] excludedModules) {
        this.excludedModules = excludedModules;
    }


    /**
     * Gets the searchTagList value for this SearchActionDigital.
     * 
     * @return searchTagList
     */
    public int[] getSearchTagList() {
        return searchTagList;
    }


    /**
     * Sets the searchTagList value for this SearchActionDigital.
     * 
     * @param searchTagList
     */
    public void setSearchTagList(int[] searchTagList) {
        this.searchTagList = searchTagList;
    }


    /**
     * Gets the sortOrder value for this SearchActionDigital.
     * 
     * @return sortOrder
     */
    public org.apache.axis.types.UnsignedByte getSortOrder() {
        return sortOrder;
    }


    /**
     * Sets the sortOrder value for this SearchActionDigital.
     * 
     * @param sortOrder
     */
    public void setSortOrder(org.apache.axis.types.UnsignedByte sortOrder) {
        this.sortOrder = sortOrder;
    }


    /**
     * Gets the searchOptionFlags value for this SearchActionDigital.
     * 
     * @return searchOptionFlags
     */
    public java.lang.Integer getSearchOptionFlags() {
        return searchOptionFlags;
    }


    /**
     * Sets the searchOptionFlags value for this SearchActionDigital.
     * 
     * @param searchOptionFlags
     */
    public void setSearchOptionFlags(java.lang.Integer searchOptionFlags) {
        this.searchOptionFlags = searchOptionFlags;
    }


    /**
     * Gets the snippetSize value for this SearchActionDigital.
     * 
     * @return snippetSize
     */
    public java.lang.Integer getSnippetSize() {
        return snippetSize;
    }


    /**
     * Sets the snippetSize value for this SearchActionDigital.
     * 
     * @param snippetSize
     */
    public void setSnippetSize(java.lang.Integer snippetSize) {
        this.snippetSize = snippetSize;
    }


    /**
     * Gets the docPosition value for this SearchActionDigital.
     * 
     * @return docPosition
     */
    public java.lang.Integer getDocPosition() {
        return docPosition;
    }


    /**
     * Sets the docPosition value for this SearchActionDigital.
     * 
     * @param docPosition
     */
    public void setDocPosition(java.lang.Integer docPosition) {
        this.docPosition = docPosition;
    }


    /**
     * Gets the pageSize value for this SearchActionDigital.
     * 
     * @return pageSize
     */
    public java.lang.Integer getPageSize() {
        return pageSize;
    }


    /**
     * Sets the pageSize value for this SearchActionDigital.
     * 
     * @param pageSize
     */
    public void setPageSize(java.lang.Integer pageSize) {
        this.pageSize = pageSize;
    }


    /**
     * Gets the searchType value for this SearchActionDigital.
     * 
     * @return searchType
     */
    public java.lang.String getSearchType() {
        return searchType;
    }


    /**
     * Sets the searchType value for this SearchActionDigital.
     * 
     * @param searchType
     */
    public void setSearchType(java.lang.String searchType) {
        this.searchType = searchType;
    }


    /**
     * Gets the pageCount value for this SearchActionDigital.
     * 
     * @return pageCount
     */
    public java.lang.Integer getPageCount() {
        return pageCount;
    }


    /**
     * Sets the pageCount value for this SearchActionDigital.
     * 
     * @param pageCount
     */
    public void setPageCount(java.lang.Integer pageCount) {
        this.pageCount = pageCount;
    }


    /**
     * Gets the areaId value for this SearchActionDigital.
     * 
     * @return areaId
     */
    public int[] getAreaId() {
        return areaId;
    }


    /**
     * Sets the areaId value for this SearchActionDigital.
     * 
     * @param areaId
     */
    public void setAreaId(int[] areaId) {
        this.areaId = areaId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchActionDigital)) return false;
        SearchActionDigital other = (SearchActionDigital) obj;
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
        new org.apache.axis.description.TypeDesc(SearchActionDigital.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SearchActionDigital"));
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
