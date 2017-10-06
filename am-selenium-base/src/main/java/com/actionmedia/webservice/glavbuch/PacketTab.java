/**
 * PacketTab.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.glavbuch;

public class PacketTab  implements java.io.Serializable {
    private org.apache.axis.types.UnsignedByte pubDivId;

    private java.lang.Integer period;

    private java.util.Calendar date;

    private java.lang.Integer packetId;

    public PacketTab() {
    }

    public PacketTab(
           org.apache.axis.types.UnsignedByte pubDivId,
           java.lang.Integer period,
           java.util.Calendar date,
           java.lang.Integer packetId) {
           this.pubDivId = pubDivId;
           this.period = period;
           this.date = date;
           this.packetId = packetId;
    }


    /**
     * Gets the pubDivId value for this PacketTab.
     * 
     * @return pubDivId
     */
    public org.apache.axis.types.UnsignedByte getPubDivId() {
        return pubDivId;
    }


    /**
     * Sets the pubDivId value for this PacketTab.
     * 
     * @param pubDivId
     */
    public void setPubDivId(org.apache.axis.types.UnsignedByte pubDivId) {
        this.pubDivId = pubDivId;
    }


    /**
     * Gets the period value for this PacketTab.
     * 
     * @return period
     */
    public java.lang.Integer getPeriod() {
        return period;
    }


    /**
     * Sets the period value for this PacketTab.
     * 
     * @param period
     */
    public void setPeriod(java.lang.Integer period) {
        this.period = period;
    }


    /**
     * Gets the date value for this PacketTab.
     * 
     * @return date
     */
    public java.util.Calendar getDate() {
        return date;
    }


    /**
     * Sets the date value for this PacketTab.
     * 
     * @param date
     */
    public void setDate(java.util.Calendar date) {
        this.date = date;
    }


    /**
     * Gets the packetId value for this PacketTab.
     * 
     * @return packetId
     */
    public java.lang.Integer getPacketId() {
        return packetId;
    }


    /**
     * Sets the packetId value for this PacketTab.
     * 
     * @param packetId
     */
    public void setPacketId(java.lang.Integer packetId) {
        this.packetId = packetId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PacketTab)) return false;
        PacketTab other = (PacketTab) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.pubDivId==null && other.getPubDivId()==null) || 
             (this.pubDivId!=null &&
              this.pubDivId.equals(other.getPubDivId()))) &&
            ((this.period==null && other.getPeriod()==null) || 
             (this.period!=null &&
              this.period.equals(other.getPeriod()))) &&
            ((this.date==null && other.getDate()==null) || 
             (this.date!=null &&
              this.date.equals(other.getDate()))) &&
            ((this.packetId==null && other.getPacketId()==null) || 
             (this.packetId!=null &&
              this.packetId.equals(other.getPacketId())));
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
        if (getPubDivId() != null) {
            _hashCode += getPubDivId().hashCode();
        }
        if (getPeriod() != null) {
            _hashCode += getPeriod().hashCode();
        }
        if (getDate() != null) {
            _hashCode += getDate().hashCode();
        }
        if (getPacketId() != null) {
            _hashCode += getPacketId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PacketTab.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">PacketTab"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubDivId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "PubDivId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("period");
        elemField.setXmlName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "Period"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("date");
        elemField.setXmlName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "Date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("packetId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "PacketId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
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
