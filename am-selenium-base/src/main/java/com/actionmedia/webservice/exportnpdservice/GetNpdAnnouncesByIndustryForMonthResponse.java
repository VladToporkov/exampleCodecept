/**
 * GetNpdAnnouncesByIndustryForMonthResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.exportnpdservice;

public class GetNpdAnnouncesByIndustryForMonthResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.exportnpdservice.ExecuteGetNpdAnnouncesByIndustryForMonthResponse getNpdAnnouncesByIndustryForMonthResult;

    public GetNpdAnnouncesByIndustryForMonthResponse() {
    }

    public GetNpdAnnouncesByIndustryForMonthResponse(
           com.actionmedia.webservice.exportnpdservice.ExecuteGetNpdAnnouncesByIndustryForMonthResponse getNpdAnnouncesByIndustryForMonthResult) {
           this.getNpdAnnouncesByIndustryForMonthResult = getNpdAnnouncesByIndustryForMonthResult;
    }


    /**
     * Gets the getNpdAnnouncesByIndustryForMonthResult value for this GetNpdAnnouncesByIndustryForMonthResponse.
     * 
     * @return getNpdAnnouncesByIndustryForMonthResult
     */
    public com.actionmedia.webservice.exportnpdservice.ExecuteGetNpdAnnouncesByIndustryForMonthResponse getGetNpdAnnouncesByIndustryForMonthResult() {
        return getNpdAnnouncesByIndustryForMonthResult;
    }


    /**
     * Sets the getNpdAnnouncesByIndustryForMonthResult value for this GetNpdAnnouncesByIndustryForMonthResponse.
     * 
     * @param getNpdAnnouncesByIndustryForMonthResult
     */
    public void setGetNpdAnnouncesByIndustryForMonthResult(com.actionmedia.webservice.exportnpdservice.ExecuteGetNpdAnnouncesByIndustryForMonthResponse getNpdAnnouncesByIndustryForMonthResult) {
        this.getNpdAnnouncesByIndustryForMonthResult = getNpdAnnouncesByIndustryForMonthResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetNpdAnnouncesByIndustryForMonthResponse)) return false;
        GetNpdAnnouncesByIndustryForMonthResponse other = (GetNpdAnnouncesByIndustryForMonthResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getNpdAnnouncesByIndustryForMonthResult==null && other.getGetNpdAnnouncesByIndustryForMonthResult()==null) || 
             (this.getNpdAnnouncesByIndustryForMonthResult!=null &&
              this.getNpdAnnouncesByIndustryForMonthResult.equals(other.getGetNpdAnnouncesByIndustryForMonthResult())));
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
        if (getGetNpdAnnouncesByIndustryForMonthResult() != null) {
            _hashCode += getGetNpdAnnouncesByIndustryForMonthResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetNpdAnnouncesByIndustryForMonthResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", ">GetNpdAnnouncesByIndustryForMonthResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getNpdAnnouncesByIndustryForMonthResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "GetNpdAnnouncesByIndustryForMonthResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetNpdAnnouncesByIndustryForMonthResponse"));
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
