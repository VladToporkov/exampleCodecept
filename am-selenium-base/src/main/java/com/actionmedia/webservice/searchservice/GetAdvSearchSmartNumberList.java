/**
 * GetAdvSearchSmartNumberList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class GetAdvSearchSmartNumberList  implements java.io.Serializable {
    private org.apache.axis.types.UnsignedByte pubID;

    private java.lang.String pattern;

    private java.lang.Integer listLength;

    private java.lang.Boolean isLucene;

    public GetAdvSearchSmartNumberList() {
    }

    public GetAdvSearchSmartNumberList(
           org.apache.axis.types.UnsignedByte pubID,
           java.lang.String pattern,
           java.lang.Integer listLength,
           java.lang.Boolean isLucene) {
           this.pubID = pubID;
           this.pattern = pattern;
           this.listLength = listLength;
           this.isLucene = isLucene;
    }


    /**
     * Gets the pubID value for this GetAdvSearchSmartNumberList.
     * 
     * @return pubID
     */
    public org.apache.axis.types.UnsignedByte getPubID() {
        return pubID;
    }


    /**
     * Sets the pubID value for this GetAdvSearchSmartNumberList.
     * 
     * @param pubID
     */
    public void setPubID(org.apache.axis.types.UnsignedByte pubID) {
        this.pubID = pubID;
    }


    /**
     * Gets the pattern value for this GetAdvSearchSmartNumberList.
     * 
     * @return pattern
     */
    public java.lang.String getPattern() {
        return pattern;
    }


    /**
     * Sets the pattern value for this GetAdvSearchSmartNumberList.
     * 
     * @param pattern
     */
    public void setPattern(java.lang.String pattern) {
        this.pattern = pattern;
    }


    /**
     * Gets the listLength value for this GetAdvSearchSmartNumberList.
     * 
     * @return listLength
     */
    public java.lang.Integer getListLength() {
        return listLength;
    }


    /**
     * Sets the listLength value for this GetAdvSearchSmartNumberList.
     * 
     * @param listLength
     */
    public void setListLength(java.lang.Integer listLength) {
        this.listLength = listLength;
    }


    /**
     * Gets the isLucene value for this GetAdvSearchSmartNumberList.
     * 
     * @return isLucene
     */
    public java.lang.Boolean getIsLucene() {
        return isLucene;
    }


    /**
     * Sets the isLucene value for this GetAdvSearchSmartNumberList.
     * 
     * @param isLucene
     */
    public void setIsLucene(java.lang.Boolean isLucene) {
        this.isLucene = isLucene;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetAdvSearchSmartNumberList)) return false;
        GetAdvSearchSmartNumberList other = (GetAdvSearchSmartNumberList) obj;
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
            ((this.pattern==null && other.getPattern()==null) || 
             (this.pattern!=null &&
              this.pattern.equals(other.getPattern()))) &&
            ((this.listLength==null && other.getListLength()==null) || 
             (this.listLength!=null &&
              this.listLength.equals(other.getListLength()))) &&
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
        if (getPattern() != null) {
            _hashCode += getPattern().hashCode();
        }
        if (getListLength() != null) {
            _hashCode += getListLength().hashCode();
        }
        if (getIsLucene() != null) {
            _hashCode += getIsLucene().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetAdvSearchSmartNumberList.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetAdvSearchSmartNumberList"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "pubID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pattern");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "pattern"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listLength");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "listLength"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
