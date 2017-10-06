/**
 * GetAdvSearchNumberGroupListResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class GetAdvSearchNumberGroupListResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.searchservice.GetAdvSearchNumberGroupListResponseGetAdvSearchNumberGroupListResult getAdvSearchNumberGroupListResult;

    public GetAdvSearchNumberGroupListResponse() {
    }

    public GetAdvSearchNumberGroupListResponse(
           com.actionmedia.webservice.searchservice.GetAdvSearchNumberGroupListResponseGetAdvSearchNumberGroupListResult getAdvSearchNumberGroupListResult) {
           this.getAdvSearchNumberGroupListResult = getAdvSearchNumberGroupListResult;
    }


    /**
     * Gets the getAdvSearchNumberGroupListResult value for this GetAdvSearchNumberGroupListResponse.
     * 
     * @return getAdvSearchNumberGroupListResult
     */
    public com.actionmedia.webservice.searchservice.GetAdvSearchNumberGroupListResponseGetAdvSearchNumberGroupListResult getGetAdvSearchNumberGroupListResult() {
        return getAdvSearchNumberGroupListResult;
    }


    /**
     * Sets the getAdvSearchNumberGroupListResult value for this GetAdvSearchNumberGroupListResponse.
     * 
     * @param getAdvSearchNumberGroupListResult
     */
    public void setGetAdvSearchNumberGroupListResult(com.actionmedia.webservice.searchservice.GetAdvSearchNumberGroupListResponseGetAdvSearchNumberGroupListResult getAdvSearchNumberGroupListResult) {
        this.getAdvSearchNumberGroupListResult = getAdvSearchNumberGroupListResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetAdvSearchNumberGroupListResponse)) return false;
        GetAdvSearchNumberGroupListResponse other = (GetAdvSearchNumberGroupListResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getAdvSearchNumberGroupListResult==null && other.getGetAdvSearchNumberGroupListResult()==null) || 
             (this.getAdvSearchNumberGroupListResult!=null &&
              this.getAdvSearchNumberGroupListResult.equals(other.getGetAdvSearchNumberGroupListResult())));
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
        if (getGetAdvSearchNumberGroupListResult() != null) {
            _hashCode += getGetAdvSearchNumberGroupListResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetAdvSearchNumberGroupListResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetAdvSearchNumberGroupListResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getAdvSearchNumberGroupListResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetAdvSearchNumberGroupListResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetAdvSearchNumberGroupListResponse>GetAdvSearchNumberGroupListResult"));
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
