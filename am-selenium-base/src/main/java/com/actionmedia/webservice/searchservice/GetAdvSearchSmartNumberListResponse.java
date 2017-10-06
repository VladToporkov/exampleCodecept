/**
 * GetAdvSearchSmartNumberListResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class GetAdvSearchSmartNumberListResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.searchservice.GetAdvSearchSmartNumberListResponseGetAdvSearchSmartNumberListResult getAdvSearchSmartNumberListResult;

    public GetAdvSearchSmartNumberListResponse() {
    }

    public GetAdvSearchSmartNumberListResponse(
           com.actionmedia.webservice.searchservice.GetAdvSearchSmartNumberListResponseGetAdvSearchSmartNumberListResult getAdvSearchSmartNumberListResult) {
           this.getAdvSearchSmartNumberListResult = getAdvSearchSmartNumberListResult;
    }


    /**
     * Gets the getAdvSearchSmartNumberListResult value for this GetAdvSearchSmartNumberListResponse.
     * 
     * @return getAdvSearchSmartNumberListResult
     */
    public com.actionmedia.webservice.searchservice.GetAdvSearchSmartNumberListResponseGetAdvSearchSmartNumberListResult getGetAdvSearchSmartNumberListResult() {
        return getAdvSearchSmartNumberListResult;
    }


    /**
     * Sets the getAdvSearchSmartNumberListResult value for this GetAdvSearchSmartNumberListResponse.
     * 
     * @param getAdvSearchSmartNumberListResult
     */
    public void setGetAdvSearchSmartNumberListResult(com.actionmedia.webservice.searchservice.GetAdvSearchSmartNumberListResponseGetAdvSearchSmartNumberListResult getAdvSearchSmartNumberListResult) {
        this.getAdvSearchSmartNumberListResult = getAdvSearchSmartNumberListResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetAdvSearchSmartNumberListResponse)) return false;
        GetAdvSearchSmartNumberListResponse other = (GetAdvSearchSmartNumberListResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getAdvSearchSmartNumberListResult==null && other.getGetAdvSearchSmartNumberListResult()==null) || 
             (this.getAdvSearchSmartNumberListResult!=null &&
              this.getAdvSearchSmartNumberListResult.equals(other.getGetAdvSearchSmartNumberListResult())));
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
        if (getGetAdvSearchSmartNumberListResult() != null) {
            _hashCode += getGetAdvSearchSmartNumberListResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetAdvSearchSmartNumberListResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetAdvSearchSmartNumberListResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getAdvSearchSmartNumberListResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetAdvSearchSmartNumberListResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetAdvSearchSmartNumberListResponse>GetAdvSearchSmartNumberListResult"));
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
