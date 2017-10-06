/**
 * GetActualDateResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.currency;

public class GetActualDateResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.currency.GetActualDateResponseGetActualDateResult getActualDateResult;

    public GetActualDateResponse() {
    }

    public GetActualDateResponse(
           com.actionmedia.webservice.currency.GetActualDateResponseGetActualDateResult getActualDateResult) {
           this.getActualDateResult = getActualDateResult;
    }


    /**
     * Gets the getActualDateResult value for this GetActualDateResponse.
     * 
     * @return getActualDateResult
     */
    public com.actionmedia.webservice.currency.GetActualDateResponseGetActualDateResult getGetActualDateResult() {
        return getActualDateResult;
    }


    /**
     * Sets the getActualDateResult value for this GetActualDateResponse.
     * 
     * @param getActualDateResult
     */
    public void setGetActualDateResult(com.actionmedia.webservice.currency.GetActualDateResponseGetActualDateResult getActualDateResult) {
        this.getActualDateResult = getActualDateResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetActualDateResponse)) return false;
        GetActualDateResponse other = (GetActualDateResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getActualDateResult==null && other.getGetActualDateResult()==null) || 
             (this.getActualDateResult!=null &&
              this.getActualDateResult.equals(other.getGetActualDateResult())));
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
        if (getGetActualDateResult() != null) {
            _hashCode += getGetActualDateResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetActualDateResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetActualDateResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getActualDateResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetActualDateResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetActualDateResponse>GetActualDateResult"));
        elemField.setMinOccurs(0);
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
