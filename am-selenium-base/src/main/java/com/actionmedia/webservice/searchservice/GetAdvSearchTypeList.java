/**
 * GetAdvSearchTypeList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class GetAdvSearchTypeList  implements java.io.Serializable {
    private org.apache.axis.types.UnsignedByte pubID;

    private java.lang.String csvRegionIDFilter;

    private java.lang.String csvLobbyIDFilter;

    private java.lang.String csvCategoryIDFilter;

    private java.lang.Boolean isActualDocumentOnly;

    private java.lang.Boolean isLucene;

    public GetAdvSearchTypeList() {
    }

    public GetAdvSearchTypeList(
           org.apache.axis.types.UnsignedByte pubID,
           java.lang.String csvRegionIDFilter,
           java.lang.String csvLobbyIDFilter,
           java.lang.String csvCategoryIDFilter,
           java.lang.Boolean isActualDocumentOnly,
           java.lang.Boolean isLucene) {
           this.pubID = pubID;
           this.csvRegionIDFilter = csvRegionIDFilter;
           this.csvLobbyIDFilter = csvLobbyIDFilter;
           this.csvCategoryIDFilter = csvCategoryIDFilter;
           this.isActualDocumentOnly = isActualDocumentOnly;
           this.isLucene = isLucene;
    }


    /**
     * Gets the pubID value for this GetAdvSearchTypeList.
     * 
     * @return pubID
     */
    public org.apache.axis.types.UnsignedByte getPubID() {
        return pubID;
    }


    /**
     * Sets the pubID value for this GetAdvSearchTypeList.
     * 
     * @param pubID
     */
    public void setPubID(org.apache.axis.types.UnsignedByte pubID) {
        this.pubID = pubID;
    }


    /**
     * Gets the csvRegionIDFilter value for this GetAdvSearchTypeList.
     * 
     * @return csvRegionIDFilter
     */
    public java.lang.String getCsvRegionIDFilter() {
        return csvRegionIDFilter;
    }


    /**
     * Sets the csvRegionIDFilter value for this GetAdvSearchTypeList.
     * 
     * @param csvRegionIDFilter
     */
    public void setCsvRegionIDFilter(java.lang.String csvRegionIDFilter) {
        this.csvRegionIDFilter = csvRegionIDFilter;
    }


    /**
     * Gets the csvLobbyIDFilter value for this GetAdvSearchTypeList.
     * 
     * @return csvLobbyIDFilter
     */
    public java.lang.String getCsvLobbyIDFilter() {
        return csvLobbyIDFilter;
    }


    /**
     * Sets the csvLobbyIDFilter value for this GetAdvSearchTypeList.
     * 
     * @param csvLobbyIDFilter
     */
    public void setCsvLobbyIDFilter(java.lang.String csvLobbyIDFilter) {
        this.csvLobbyIDFilter = csvLobbyIDFilter;
    }


    /**
     * Gets the csvCategoryIDFilter value for this GetAdvSearchTypeList.
     * 
     * @return csvCategoryIDFilter
     */
    public java.lang.String getCsvCategoryIDFilter() {
        return csvCategoryIDFilter;
    }


    /**
     * Sets the csvCategoryIDFilter value for this GetAdvSearchTypeList.
     * 
     * @param csvCategoryIDFilter
     */
    public void setCsvCategoryIDFilter(java.lang.String csvCategoryIDFilter) {
        this.csvCategoryIDFilter = csvCategoryIDFilter;
    }


    /**
     * Gets the isActualDocumentOnly value for this GetAdvSearchTypeList.
     * 
     * @return isActualDocumentOnly
     */
    public java.lang.Boolean getIsActualDocumentOnly() {
        return isActualDocumentOnly;
    }


    /**
     * Sets the isActualDocumentOnly value for this GetAdvSearchTypeList.
     * 
     * @param isActualDocumentOnly
     */
    public void setIsActualDocumentOnly(java.lang.Boolean isActualDocumentOnly) {
        this.isActualDocumentOnly = isActualDocumentOnly;
    }


    /**
     * Gets the isLucene value for this GetAdvSearchTypeList.
     * 
     * @return isLucene
     */
    public java.lang.Boolean getIsLucene() {
        return isLucene;
    }


    /**
     * Sets the isLucene value for this GetAdvSearchTypeList.
     * 
     * @param isLucene
     */
    public void setIsLucene(java.lang.Boolean isLucene) {
        this.isLucene = isLucene;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetAdvSearchTypeList)) return false;
        GetAdvSearchTypeList other = (GetAdvSearchTypeList) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.pubID==null && other.getPubID()==null) || 
             (this.pubID!=null &&
              this.pubID.equals(other.getPubID()))) &&
            ((this.csvRegionIDFilter==null && other.getCsvRegionIDFilter()==null) || 
             (this.csvRegionIDFilter!=null &&
              this.csvRegionIDFilter.equals(other.getCsvRegionIDFilter()))) &&
            ((this.csvLobbyIDFilter==null && other.getCsvLobbyIDFilter()==null) || 
             (this.csvLobbyIDFilter!=null &&
              this.csvLobbyIDFilter.equals(other.getCsvLobbyIDFilter()))) &&
            ((this.csvCategoryIDFilter==null && other.getCsvCategoryIDFilter()==null) || 
             (this.csvCategoryIDFilter!=null &&
              this.csvCategoryIDFilter.equals(other.getCsvCategoryIDFilter()))) &&
            ((this.isActualDocumentOnly==null && other.getIsActualDocumentOnly()==null) || 
             (this.isActualDocumentOnly!=null &&
              this.isActualDocumentOnly.equals(other.getIsActualDocumentOnly()))) &&
            ((this.isLucene==null && other.getIsLucene()==null) || 
             (this.isLucene!=null &&
              this.isLucene.equals(other.getIsLucene())));
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
        if (getPubID() != null) {
            _hashCode += getPubID().hashCode();
        }
        if (getCsvRegionIDFilter() != null) {
            _hashCode += getCsvRegionIDFilter().hashCode();
        }
        if (getCsvLobbyIDFilter() != null) {
            _hashCode += getCsvLobbyIDFilter().hashCode();
        }
        if (getCsvCategoryIDFilter() != null) {
            _hashCode += getCsvCategoryIDFilter().hashCode();
        }
        if (getIsActualDocumentOnly() != null) {
            _hashCode += getIsActualDocumentOnly().hashCode();
        }
        if (getIsLucene() != null) {
            _hashCode += getIsLucene().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetAdvSearchTypeList.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetAdvSearchTypeList"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "pubID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csvRegionIDFilter");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "csvRegionIDFilter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csvLobbyIDFilter");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "csvLobbyIDFilter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csvCategoryIDFilter");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "csvCategoryIDFilter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isActualDocumentOnly");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "isActualDocumentOnly"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isLucene");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "isLucene"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
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