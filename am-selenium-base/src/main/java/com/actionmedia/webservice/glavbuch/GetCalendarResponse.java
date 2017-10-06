/**
 * GetCalendarResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.glavbuch;

public class GetCalendarResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.glavbuch.GetCalendarResponseGetCalendarResult getCalendarResult;

    public GetCalendarResponse() {
    }

    public GetCalendarResponse(
           com.actionmedia.webservice.glavbuch.GetCalendarResponseGetCalendarResult getCalendarResult) {
           this.getCalendarResult = getCalendarResult;
    }


    /**
     * Gets the getCalendarResult value for this GetCalendarResponse.
     * 
     * @return getCalendarResult
     */
    public com.actionmedia.webservice.glavbuch.GetCalendarResponseGetCalendarResult getGetCalendarResult() {
        return getCalendarResult;
    }


    /**
     * Sets the getCalendarResult value for this GetCalendarResponse.
     * 
     * @param getCalendarResult
     */
    public void setGetCalendarResult(com.actionmedia.webservice.glavbuch.GetCalendarResponseGetCalendarResult getCalendarResult) {
        this.getCalendarResult = getCalendarResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetCalendarResponse)) return false;
        GetCalendarResponse other = (GetCalendarResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getCalendarResult==null && other.getGetCalendarResult()==null) || 
             (this.getCalendarResult!=null &&
              this.getCalendarResult.equals(other.getGetCalendarResult())));
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
        if (getGetCalendarResult() != null) {
            _hashCode += getGetCalendarResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetCalendarResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">GetCalendarResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getCalendarResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "GetCalendarResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">>GetCalendarResponse>GetCalendarResult"));
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
