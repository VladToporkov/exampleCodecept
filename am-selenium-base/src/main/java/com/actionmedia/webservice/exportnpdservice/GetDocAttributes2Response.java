/**
 * GetDocAttributes2Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.exportnpdservice;

public class GetDocAttributes2Response  implements java.io.Serializable {
    private com.actionmedia.webservice.exportnpdservice.ExecuteGetDocAttrubutesResponse2 getDocAttributes2Result;

    public GetDocAttributes2Response() {
    }

    public GetDocAttributes2Response(
           com.actionmedia.webservice.exportnpdservice.ExecuteGetDocAttrubutesResponse2 getDocAttributes2Result) {
           this.getDocAttributes2Result = getDocAttributes2Result;
    }


    /**
     * Gets the getDocAttributes2Result value for this GetDocAttributes2Response.
     * 
     * @return getDocAttributes2Result
     */
    public com.actionmedia.webservice.exportnpdservice.ExecuteGetDocAttrubutesResponse2 getGetDocAttributes2Result() {
        return getDocAttributes2Result;
    }


    /**
     * Sets the getDocAttributes2Result value for this GetDocAttributes2Response.
     * 
     * @param getDocAttributes2Result
     */
    public void setGetDocAttributes2Result(com.actionmedia.webservice.exportnpdservice.ExecuteGetDocAttrubutesResponse2 getDocAttributes2Result) {
        this.getDocAttributes2Result = getDocAttributes2Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetDocAttributes2Response)) return false;
        GetDocAttributes2Response other = (GetDocAttributes2Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getDocAttributes2Result==null && other.getGetDocAttributes2Result()==null) || 
             (this.getDocAttributes2Result!=null &&
              this.getDocAttributes2Result.equals(other.getGetDocAttributes2Result())));
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
        if (getGetDocAttributes2Result() != null) {
            _hashCode += getGetDocAttributes2Result().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetDocAttributes2Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", ">GetDocAttributes2Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getDocAttributes2Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "GetDocAttributes2Result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetDocAttrubutesResponse2"));
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
