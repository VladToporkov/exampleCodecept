/**
 * GetAdvSearchRegionList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class GetAdvSearchRegionList  implements java.io.Serializable {
    private org.apache.axis.types.UnsignedByte pubID;

    private java.lang.String prefferedRegionCode;

    private java.lang.String csvTypeIDFilter;

    private java.lang.String csvLobbyIDFilter;

    private java.lang.Boolean isActualDocumentOnly;

    private java.lang.Boolean isLucene;

    public GetAdvSearchRegionList() {
    }

    public GetAdvSearchRegionList(
           org.apache.axis.types.UnsignedByte pubID,
           java.lang.String prefferedRegionCode,
           java.lang.String csvTypeIDFilter,
           java.lang.String csvLobbyIDFilter,
           java.lang.Boolean isActualDocumentOnly,
           java.lang.Boolean isLucene) {
           this.pubID = pubID;
           this.prefferedRegionCode = prefferedRegionCode;
           this.csvTypeIDFilter = csvTypeIDFilter;
           this.csvLobbyIDFilter = csvLobbyIDFilter;
           this.isActualDocumentOnly = isActualDocumentOnly;
           this.isLucene = isLucene;
    }


    /**
     * Gets the pubID value for this GetAdvSearchRegionList.
     * 
     * @return pubID
     */
    public org.apache.axis.types.UnsignedByte getPubID() {
        return pubID;
    }


    /**
     * Sets the pubID value for this GetAdvSearchRegionList.
     * 
     * @param pubID
     */
    public void setPubID(org.apache.axis.types.UnsignedByte pubID) {
        this.pubID = pubID;
    }


    /**
     * Gets the prefferedRegionCode value for this GetAdvSearchRegionList.
     * 
     * @return prefferedRegionCode
     */
    public java.lang.String getPrefferedRegionCode() {
        return prefferedRegionCode;
    }


    /**
     * Sets the prefferedRegionCode value for this GetAdvSearchRegionList.
     * 
     * @param prefferedRegionCode
     */
    public void setPrefferedRegionCode(java.lang.String prefferedRegionCode) {
        this.prefferedRegionCode = prefferedRegionCode;
    }


    /**
     * Gets the csvTypeIDFilter value for this GetAdvSearchRegionList.
     * 
     * @return csvTypeIDFilter
     */
    public java.lang.String getCsvTypeIDFilter() {
        return csvTypeIDFilter;
    }


    /**
     * Sets the csvTypeIDFilter value for this GetAdvSearchRegionList.
     * 
     * @param csvTypeIDFilter
     */
    public void setCsvTypeIDFilter(java.lang.String csvTypeIDFilter) {
        this.csvTypeIDFilter = csvTypeIDFilter;
    }


    /**
     * Gets the csvLobbyIDFilter value for this GetAdvSearchRegionList.
     * 
     * @return csvLobbyIDFilter
     */
    public java.lang.String getCsvLobbyIDFilter() {
        return csvLobbyIDFilter;
    }


    /**
     * Sets the csvLobbyIDFilter value for this GetAdvSearchRegionList.
     * 
     * @param csvLobbyIDFilter
     */
    public void setCsvLobbyIDFilter(java.lang.String csvLobbyIDFilter) {
        this.csvLobbyIDFilter = csvLobbyIDFilter;
    }


    /**
     * Gets the isActualDocumentOnly value for this GetAdvSearchRegionList.
     * 
     * @return isActualDocumentOnly
     */
    public java.lang.Boolean getIsActualDocumentOnly() {
        return isActualDocumentOnly;
    }


    /**
     * Sets the isActualDocumentOnly value for this GetAdvSearchRegionList.
     * 
     * @param isActualDocumentOnly
     */
    public void setIsActualDocumentOnly(java.lang.Boolean isActualDocumentOnly) {
        this.isActualDocumentOnly = isActualDocumentOnly;
    }


    /**
     * Gets the isLucene value for this GetAdvSearchRegionList.
     * 
     * @return isLucene
     */
    public java.lang.Boolean getIsLucene() {
        return isLucene;
    }


    /**
     * Sets the isLucene value for this GetAdvSearchRegionList.
     * 
     * @param isLucene
     */
    public void setIsLucene(java.lang.Boolean isLucene) {
        this.isLucene = isLucene;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetAdvSearchRegionList)) return false;
        GetAdvSearchRegionList other = (GetAdvSearchRegionList) obj;
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
            ((this.prefferedRegionCode==null && other.getPrefferedRegionCode()==null) || 
             (this.prefferedRegionCode!=null &&
              this.prefferedRegionCode.equals(other.getPrefferedRegionCode()))) &&
            ((this.csvTypeIDFilter==null && other.getCsvTypeIDFilter()==null) || 
             (this.csvTypeIDFilter!=null &&
              this.csvTypeIDFilter.equals(other.getCsvTypeIDFilter()))) &&
            ((this.csvLobbyIDFilter==null && other.getCsvLobbyIDFilter()==null) || 
             (this.csvLobbyIDFilter!=null &&
              this.csvLobbyIDFilter.equals(other.getCsvLobbyIDFilter()))) &&
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
        if (getPrefferedRegionCode() != null) {
            _hashCode += getPrefferedRegionCode().hashCode();
        }
        if (getCsvTypeIDFilter() != null) {
            _hashCode += getCsvTypeIDFilter().hashCode();
        }
        if (getCsvLobbyIDFilter() != null) {
            _hashCode += getCsvLobbyIDFilter().hashCode();
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
        new org.apache.axis.description.TypeDesc(GetAdvSearchRegionList.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetAdvSearchRegionList"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "pubID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prefferedRegionCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "prefferedRegionCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csvTypeIDFilter");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "csvTypeIDFilter"));
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
