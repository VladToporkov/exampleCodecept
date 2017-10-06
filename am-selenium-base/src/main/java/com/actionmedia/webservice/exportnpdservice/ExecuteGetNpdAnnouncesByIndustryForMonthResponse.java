/**
 * ExecuteGetNpdAnnouncesByIndustryForMonthResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.exportnpdservice;

public class ExecuteGetNpdAnnouncesByIndustryForMonthResponse  extends com.actionmedia.webservice.exportnpdservice.ExecuteResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.exportnpdservice.DocAnnounceWithIndustryFlag[] announceList;

    public ExecuteGetNpdAnnouncesByIndustryForMonthResponse() {
    }

    public ExecuteGetNpdAnnouncesByIndustryForMonthResponse(
           long durationInMSec,
           com.actionmedia.webservice.exportnpdservice.DocAnnounceWithIndustryFlag[] announceList) {
        super(
            durationInMSec);
        this.announceList = announceList;
    }


    /**
     * Gets the announceList value for this ExecuteGetNpdAnnouncesByIndustryForMonthResponse.
     * 
     * @return announceList
     */
    public com.actionmedia.webservice.exportnpdservice.DocAnnounceWithIndustryFlag[] getAnnounceList() {
        return announceList;
    }


    /**
     * Sets the announceList value for this ExecuteGetNpdAnnouncesByIndustryForMonthResponse.
     * 
     * @param announceList
     */
    public void setAnnounceList(com.actionmedia.webservice.exportnpdservice.DocAnnounceWithIndustryFlag[] announceList) {
        this.announceList = announceList;
    }

    public com.actionmedia.webservice.exportnpdservice.DocAnnounceWithIndustryFlag getAnnounceList(int i) {
        return this.announceList[i];
    }

    public void setAnnounceList(int i, com.actionmedia.webservice.exportnpdservice.DocAnnounceWithIndustryFlag _value) {
        this.announceList[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExecuteGetNpdAnnouncesByIndustryForMonthResponse)) return false;
        ExecuteGetNpdAnnouncesByIndustryForMonthResponse other = (ExecuteGetNpdAnnouncesByIndustryForMonthResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.announceList==null && other.getAnnounceList()==null) || 
             (this.announceList!=null &&
              java.util.Arrays.equals(this.announceList, other.getAnnounceList())));
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
        if (getAnnounceList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAnnounceList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAnnounceList(), i);
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
        new org.apache.axis.description.TypeDesc(ExecuteGetNpdAnnouncesByIndustryForMonthResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetNpdAnnouncesByIndustryForMonthResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("announceList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "AnnounceList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "DocAnnounceWithIndustryFlag"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
