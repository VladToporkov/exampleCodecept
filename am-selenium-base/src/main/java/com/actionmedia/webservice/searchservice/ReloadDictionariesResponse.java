/**
 * ReloadDictionariesResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class ReloadDictionariesResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.searchservice.ReloadDictionariesResponseReloadDictionariesResult reloadDictionariesResult;

    public ReloadDictionariesResponse() {
    }

    public ReloadDictionariesResponse(
           com.actionmedia.webservice.searchservice.ReloadDictionariesResponseReloadDictionariesResult reloadDictionariesResult) {
           this.reloadDictionariesResult = reloadDictionariesResult;
    }


    /**
     * Gets the reloadDictionariesResult value for this ReloadDictionariesResponse.
     * 
     * @return reloadDictionariesResult
     */
    public com.actionmedia.webservice.searchservice.ReloadDictionariesResponseReloadDictionariesResult getReloadDictionariesResult() {
        return reloadDictionariesResult;
    }


    /**
     * Sets the reloadDictionariesResult value for this ReloadDictionariesResponse.
     * 
     * @param reloadDictionariesResult
     */
    public void setReloadDictionariesResult(com.actionmedia.webservice.searchservice.ReloadDictionariesResponseReloadDictionariesResult reloadDictionariesResult) {
        this.reloadDictionariesResult = reloadDictionariesResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReloadDictionariesResponse)) return false;
        ReloadDictionariesResponse other = (ReloadDictionariesResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.reloadDictionariesResult==null && other.getReloadDictionariesResult()==null) || 
             (this.reloadDictionariesResult!=null &&
              this.reloadDictionariesResult.equals(other.getReloadDictionariesResult())));
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
        if (getReloadDictionariesResult() != null) {
            _hashCode += getReloadDictionariesResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReloadDictionariesResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ReloadDictionariesResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reloadDictionariesResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ReloadDictionariesResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ReloadDictionariesResponse>ReloadDictionariesResult"));
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
