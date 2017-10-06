/**
 * ExecuteGetMagListResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.exportnpdservice;

public class ExecuteGetMagListResponse  extends com.actionmedia.webservice.exportnpdservice.ExecuteResponse  implements java.io.Serializable {
    private short magId;

    private java.lang.String magazineNumber;

    private java.lang.String magazineMonth;

    private boolean isMagFound;

    public ExecuteGetMagListResponse() {
    }

    public ExecuteGetMagListResponse(
           long durationInMSec,
           short magId,
           java.lang.String magazineNumber,
           java.lang.String magazineMonth,
           boolean isMagFound) {
        super(
            durationInMSec);
        this.magId = magId;
        this.magazineNumber = magazineNumber;
        this.magazineMonth = magazineMonth;
        this.isMagFound = isMagFound;
    }


    /**
     * Gets the magId value for this ExecuteGetMagListResponse.
     * 
     * @return magId
     */
    public short getMagId() {
        return magId;
    }


    /**
     * Sets the magId value for this ExecuteGetMagListResponse.
     * 
     * @param magId
     */
    public void setMagId(short magId) {
        this.magId = magId;
    }


    /**
     * Gets the magazineNumber value for this ExecuteGetMagListResponse.
     * 
     * @return magazineNumber
     */
    public java.lang.String getMagazineNumber() {
        return magazineNumber;
    }


    /**
     * Sets the magazineNumber value for this ExecuteGetMagListResponse.
     * 
     * @param magazineNumber
     */
    public void setMagazineNumber(java.lang.String magazineNumber) {
        this.magazineNumber = magazineNumber;
    }


    /**
     * Gets the magazineMonth value for this ExecuteGetMagListResponse.
     * 
     * @return magazineMonth
     */
    public java.lang.String getMagazineMonth() {
        return magazineMonth;
    }


    /**
     * Sets the magazineMonth value for this ExecuteGetMagListResponse.
     * 
     * @param magazineMonth
     */
    public void setMagazineMonth(java.lang.String magazineMonth) {
        this.magazineMonth = magazineMonth;
    }


    /**
     * Gets the isMagFound value for this ExecuteGetMagListResponse.
     * 
     * @return isMagFound
     */
    public boolean isIsMagFound() {
        return isMagFound;
    }


    /**
     * Sets the isMagFound value for this ExecuteGetMagListResponse.
     * 
     * @param isMagFound
     */
    public void setIsMagFound(boolean isMagFound) {
        this.isMagFound = isMagFound;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExecuteGetMagListResponse)) return false;
        ExecuteGetMagListResponse other = (ExecuteGetMagListResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.magId == other.getMagId() &&
            ((this.magazineNumber==null && other.getMagazineNumber()==null) || 
             (this.magazineNumber!=null &&
              this.magazineNumber.equals(other.getMagazineNumber()))) &&
            ((this.magazineMonth==null && other.getMagazineMonth()==null) || 
             (this.magazineMonth!=null &&
              this.magazineMonth.equals(other.getMagazineMonth()))) &&
            this.isMagFound == other.isIsMagFound();
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
        _hashCode += getMagId();
        if (getMagazineNumber() != null) {
            _hashCode += getMagazineNumber().hashCode();
        }
        if (getMagazineMonth() != null) {
            _hashCode += getMagazineMonth().hashCode();
        }
        _hashCode += (isIsMagFound() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExecuteGetMagListResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetMagListResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("magId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "MagId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("magazineNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "MagazineNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("magazineMonth");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "MagazineMonth"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isMagFound");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "IsMagFound"));
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
