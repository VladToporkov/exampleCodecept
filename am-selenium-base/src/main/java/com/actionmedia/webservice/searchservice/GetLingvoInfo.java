/**
 * GetLingvoInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class GetLingvoInfo  implements java.io.Serializable {
    private org.apache.axis.types.UnsignedByte pubId;

    private java.lang.String searchString;

    private java.lang.Integer lingvoFlag;

    public GetLingvoInfo() {
    }

    public GetLingvoInfo(
           org.apache.axis.types.UnsignedByte pubId,
           java.lang.String searchString,
           java.lang.Integer lingvoFlag) {
           this.pubId = pubId;
           this.searchString = searchString;
           this.lingvoFlag = lingvoFlag;
    }


    /**
     * Gets the pubId value for this GetLingvoInfo.
     * 
     * @return pubId
     */
    public org.apache.axis.types.UnsignedByte getPubId() {
        return pubId;
    }


    /**
     * Sets the pubId value for this GetLingvoInfo.
     * 
     * @param pubId
     */
    public void setPubId(org.apache.axis.types.UnsignedByte pubId) {
        this.pubId = pubId;
    }


    /**
     * Gets the searchString value for this GetLingvoInfo.
     * 
     * @return searchString
     */
    public java.lang.String getSearchString() {
        return searchString;
    }


    /**
     * Sets the searchString value for this GetLingvoInfo.
     * 
     * @param searchString
     */
    public void setSearchString(java.lang.String searchString) {
        this.searchString = searchString;
    }


    /**
     * Gets the lingvoFlag value for this GetLingvoInfo.
     * 
     * @return lingvoFlag
     */
    public java.lang.Integer getLingvoFlag() {
        return lingvoFlag;
    }


    /**
     * Sets the lingvoFlag value for this GetLingvoInfo.
     * 
     * @param lingvoFlag
     */
    public void setLingvoFlag(java.lang.Integer lingvoFlag) {
        this.lingvoFlag = lingvoFlag;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetLingvoInfo)) return false;
        GetLingvoInfo other = (GetLingvoInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.pubId==null && other.getPubId()==null) || 
             (this.pubId!=null &&
              this.pubId.equals(other.getPubId()))) &&
            ((this.searchString==null && other.getSearchString()==null) || 
             (this.searchString!=null &&
              this.searchString.equals(other.getSearchString()))) &&
            ((this.lingvoFlag==null && other.getLingvoFlag()==null) || 
             (this.lingvoFlag!=null &&
              this.lingvoFlag.equals(other.getLingvoFlag())));
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
        if (getPubId() != null) {
            _hashCode += getPubId().hashCode();
        }
        if (getSearchString() != null) {
            _hashCode += getSearchString().hashCode();
        }
        if (getLingvoFlag() != null) {
            _hashCode += getLingvoFlag().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetLingvoInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetLingvoInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "PubId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchString");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SearchString"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lingvoFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "LingvoFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
