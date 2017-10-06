/**
 * SearchSite.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class SearchSite  implements java.io.Serializable {
    private java.lang.String searchString;

    private org.apache.axis.types.UnsignedByte pubId;

    private int[] moduleList;

    private java.lang.Integer pageNumber;

    private java.lang.Integer pageSize;

    private java.lang.Integer snippetSize;

    private java.lang.Integer searchFlag;

    private java.lang.Integer lingvoFlag;

    private int[] searchTagList;

    public SearchSite() {
    }

    public SearchSite(
           java.lang.String searchString,
           org.apache.axis.types.UnsignedByte pubId,
           int[] moduleList,
           java.lang.Integer pageNumber,
           java.lang.Integer pageSize,
           java.lang.Integer snippetSize,
           java.lang.Integer searchFlag,
           java.lang.Integer lingvoFlag,
           int[] searchTagList) {
           this.searchString = searchString;
           this.pubId = pubId;
           this.moduleList = moduleList;
           this.pageNumber = pageNumber;
           this.pageSize = pageSize;
           this.snippetSize = snippetSize;
           this.searchFlag = searchFlag;
           this.lingvoFlag = lingvoFlag;
           this.searchTagList = searchTagList;
    }


    /**
     * Gets the searchString value for this SearchSite.
     * 
     * @return searchString
     */
    public java.lang.String getSearchString() {
        return searchString;
    }


    /**
     * Sets the searchString value for this SearchSite.
     * 
     * @param searchString
     */
    public void setSearchString(java.lang.String searchString) {
        this.searchString = searchString;
    }


    /**
     * Gets the pubId value for this SearchSite.
     * 
     * @return pubId
     */
    public org.apache.axis.types.UnsignedByte getPubId() {
        return pubId;
    }


    /**
     * Sets the pubId value for this SearchSite.
     * 
     * @param pubId
     */
    public void setPubId(org.apache.axis.types.UnsignedByte pubId) {
        this.pubId = pubId;
    }


    /**
     * Gets the moduleList value for this SearchSite.
     * 
     * @return moduleList
     */
    public int[] getModuleList() {
        return moduleList;
    }


    /**
     * Sets the moduleList value for this SearchSite.
     * 
     * @param moduleList
     */
    public void setModuleList(int[] moduleList) {
        this.moduleList = moduleList;
    }


    /**
     * Gets the pageNumber value for this SearchSite.
     * 
     * @return pageNumber
     */
    public java.lang.Integer getPageNumber() {
        return pageNumber;
    }


    /**
     * Sets the pageNumber value for this SearchSite.
     * 
     * @param pageNumber
     */
    public void setPageNumber(java.lang.Integer pageNumber) {
        this.pageNumber = pageNumber;
    }


    /**
     * Gets the pageSize value for this SearchSite.
     * 
     * @return pageSize
     */
    public java.lang.Integer getPageSize() {
        return pageSize;
    }


    /**
     * Sets the pageSize value for this SearchSite.
     * 
     * @param pageSize
     */
    public void setPageSize(java.lang.Integer pageSize) {
        this.pageSize = pageSize;
    }


    /**
     * Gets the snippetSize value for this SearchSite.
     * 
     * @return snippetSize
     */
    public java.lang.Integer getSnippetSize() {
        return snippetSize;
    }


    /**
     * Sets the snippetSize value for this SearchSite.
     * 
     * @param snippetSize
     */
    public void setSnippetSize(java.lang.Integer snippetSize) {
        this.snippetSize = snippetSize;
    }


    /**
     * Gets the searchFlag value for this SearchSite.
     * 
     * @return searchFlag
     */
    public java.lang.Integer getSearchFlag() {
        return searchFlag;
    }


    /**
     * Sets the searchFlag value for this SearchSite.
     * 
     * @param searchFlag
     */
    public void setSearchFlag(java.lang.Integer searchFlag) {
        this.searchFlag = searchFlag;
    }


    /**
     * Gets the lingvoFlag value for this SearchSite.
     * 
     * @return lingvoFlag
     */
    public java.lang.Integer getLingvoFlag() {
        return lingvoFlag;
    }


    /**
     * Sets the lingvoFlag value for this SearchSite.
     * 
     * @param lingvoFlag
     */
    public void setLingvoFlag(java.lang.Integer lingvoFlag) {
        this.lingvoFlag = lingvoFlag;
    }


    /**
     * Gets the searchTagList value for this SearchSite.
     * 
     * @return searchTagList
     */
    public int[] getSearchTagList() {
        return searchTagList;
    }


    /**
     * Sets the searchTagList value for this SearchSite.
     * 
     * @param searchTagList
     */
    public void setSearchTagList(int[] searchTagList) {
        this.searchTagList = searchTagList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchSite)) return false;
        SearchSite other = (SearchSite) obj;
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
            ((this.moduleList==null && other.getModuleList()==null) || 
             (this.moduleList!=null &&
              java.util.Arrays.equals(this.moduleList, other.getModuleList()))) &&
            ((this.pageNumber==null && other.getPageNumber()==null) || 
             (this.pageNumber!=null &&
              this.pageNumber.equals(other.getPageNumber()))) &&
            ((this.pageSize==null && other.getPageSize()==null) || 
             (this.pageSize!=null &&
              this.pageSize.equals(other.getPageSize()))) &&
            ((this.snippetSize==null && other.getSnippetSize()==null) || 
             (this.snippetSize!=null &&
              this.snippetSize.equals(other.getSnippetSize()))) &&
            ((this.searchFlag==null && other.getSearchFlag()==null) || 
             (this.searchFlag!=null &&
              this.searchFlag.equals(other.getSearchFlag()))) &&
            ((this.lingvoFlag==null && other.getLingvoFlag()==null) || 
             (this.lingvoFlag!=null &&
              this.lingvoFlag.equals(other.getLingvoFlag()))) &&
            ((this.searchTagList==null && other.getSearchTagList()==null) || 
             (this.searchTagList!=null &&
              java.util.Arrays.equals(this.searchTagList, other.getSearchTagList())));
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
        if (getModuleList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getModuleList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getModuleList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPageNumber() != null) {
            _hashCode += getPageNumber().hashCode();
        }
        if (getPageSize() != null) {
            _hashCode += getPageSize().hashCode();
        }
        if (getSnippetSize() != null) {
            _hashCode += getSnippetSize().hashCode();
        }
        if (getSearchFlag() != null) {
            _hashCode += getSearchFlag().hashCode();
        }
        if (getLingvoFlag() != null) {
            _hashCode += getLingvoFlag().hashCode();
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchSite.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SearchSite"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchString");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SearchString"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "PubId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moduleList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ModuleList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pageNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "PageNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pageSize");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "PageSize"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("snippetSize");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SnippetSize"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SearchFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lingvoFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "LingvoFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchTagList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SearchTagList"));
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