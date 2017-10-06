/**
 * GetMagList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.exportnpdservice;

public class GetMagList  implements java.io.Serializable {
    private org.apache.axis.types.UnsignedByte magazineId;

    private int magazineNumber;

    private java.util.Calendar magazineDate;

    public GetMagList() {
    }

    public GetMagList(
           org.apache.axis.types.UnsignedByte magazineId,
           int magazineNumber,
           java.util.Calendar magazineDate) {
           this.magazineId = magazineId;
           this.magazineNumber = magazineNumber;
           this.magazineDate = magazineDate;
    }


    /**
     * Gets the magazineId value for this GetMagList.
     * 
     * @return magazineId
     */
    public org.apache.axis.types.UnsignedByte getMagazineId() {
        return magazineId;
    }


    /**
     * Sets the magazineId value for this GetMagList.
     * 
     * @param magazineId
     */
    public void setMagazineId(org.apache.axis.types.UnsignedByte magazineId) {
        this.magazineId = magazineId;
    }


    /**
     * Gets the magazineNumber value for this GetMagList.
     * 
     * @return magazineNumber
     */
    public int getMagazineNumber() {
        return magazineNumber;
    }


    /**
     * Sets the magazineNumber value for this GetMagList.
     * 
     * @param magazineNumber
     */
    public void setMagazineNumber(int magazineNumber) {
        this.magazineNumber = magazineNumber;
    }


    /**
     * Gets the magazineDate value for this GetMagList.
     * 
     * @return magazineDate
     */
    public java.util.Calendar getMagazineDate() {
        return magazineDate;
    }


    /**
     * Sets the magazineDate value for this GetMagList.
     * 
     * @param magazineDate
     */
    public void setMagazineDate(java.util.Calendar magazineDate) {
        this.magazineDate = magazineDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetMagList)) return false;
        GetMagList other = (GetMagList) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.magazineId==null && other.getMagazineId()==null) || 
             (this.magazineId!=null &&
              this.magazineId.equals(other.getMagazineId()))) &&
            this.magazineNumber == other.getMagazineNumber() &&
            ((this.magazineDate==null && other.getMagazineDate()==null) || 
             (this.magazineDate!=null &&
              this.magazineDate.equals(other.getMagazineDate())));
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
        if (getMagazineId() != null) {
            _hashCode += getMagazineId().hashCode();
        }
        _hashCode += getMagazineNumber();
        if (getMagazineDate() != null) {
            _hashCode += getMagazineDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetMagList.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", ">GetMagList"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("magazineId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "MagazineId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("magazineNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "MagazineNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("magazineDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "MagazineDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
