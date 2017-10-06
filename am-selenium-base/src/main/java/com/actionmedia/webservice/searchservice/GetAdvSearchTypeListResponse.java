/**
 * GetAdvSearchTypeListResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class GetAdvSearchTypeListResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.searchservice.GetAdvSearchTypeListResponseGetAdvSearchTypeListResult getAdvSearchTypeListResult;

    public GetAdvSearchTypeListResponse() {
    }

    public GetAdvSearchTypeListResponse(
           com.actionmedia.webservice.searchservice.GetAdvSearchTypeListResponseGetAdvSearchTypeListResult getAdvSearchTypeListResult) {
           this.getAdvSearchTypeListResult = getAdvSearchTypeListResult;
    }


    /**
     * Gets the getAdvSearchTypeListResult value for this GetAdvSearchTypeListResponse.
     * 
     * @return getAdvSearchTypeListResult
     */
    public com.actionmedia.webservice.searchservice.GetAdvSearchTypeListResponseGetAdvSearchTypeListResult getGetAdvSearchTypeListResult() {
        return getAdvSearchTypeListResult;
    }


    /**
     * Sets the getAdvSearchTypeListResult value for this GetAdvSearchTypeListResponse.
     * 
     * @param getAdvSearchTypeListResult
     */
    public void setGetAdvSearchTypeListResult(com.actionmedia.webservice.searchservice.GetAdvSearchTypeListResponseGetAdvSearchTypeListResult getAdvSearchTypeListResult) {
        this.getAdvSearchTypeListResult = getAdvSearchTypeListResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetAdvSearchTypeListResponse)) return false;
        GetAdvSearchTypeListResponse other = (GetAdvSearchTypeListResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getAdvSearchTypeListResult==null && other.getGetAdvSearchTypeListResult()==null) || 
             (this.getAdvSearchTypeListResult!=null &&
              this.getAdvSearchTypeListResult.equals(other.getGetAdvSearchTypeListResult())));
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
        if (getGetAdvSearchTypeListResult() != null) {
            _hashCode += getGetAdvSearchTypeListResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetAdvSearchTypeListResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetAdvSearchTypeListResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getAdvSearchTypeListResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetAdvSearchTypeListResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetAdvSearchTypeListResponse>GetAdvSearchTypeListResult"));
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
