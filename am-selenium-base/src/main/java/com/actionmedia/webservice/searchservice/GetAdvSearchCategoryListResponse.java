/**
 * GetAdvSearchCategoryListResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class GetAdvSearchCategoryListResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.searchservice.GetAdvSearchCategoryListResponseGetAdvSearchCategoryListResult getAdvSearchCategoryListResult;

    public GetAdvSearchCategoryListResponse() {
    }

    public GetAdvSearchCategoryListResponse(
           com.actionmedia.webservice.searchservice.GetAdvSearchCategoryListResponseGetAdvSearchCategoryListResult getAdvSearchCategoryListResult) {
           this.getAdvSearchCategoryListResult = getAdvSearchCategoryListResult;
    }


    /**
     * Gets the getAdvSearchCategoryListResult value for this GetAdvSearchCategoryListResponse.
     * 
     * @return getAdvSearchCategoryListResult
     */
    public com.actionmedia.webservice.searchservice.GetAdvSearchCategoryListResponseGetAdvSearchCategoryListResult getGetAdvSearchCategoryListResult() {
        return getAdvSearchCategoryListResult;
    }


    /**
     * Sets the getAdvSearchCategoryListResult value for this GetAdvSearchCategoryListResponse.
     * 
     * @param getAdvSearchCategoryListResult
     */
    public void setGetAdvSearchCategoryListResult(com.actionmedia.webservice.searchservice.GetAdvSearchCategoryListResponseGetAdvSearchCategoryListResult getAdvSearchCategoryListResult) {
        this.getAdvSearchCategoryListResult = getAdvSearchCategoryListResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetAdvSearchCategoryListResponse)) return false;
        GetAdvSearchCategoryListResponse other = (GetAdvSearchCategoryListResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getAdvSearchCategoryListResult==null && other.getGetAdvSearchCategoryListResult()==null) || 
             (this.getAdvSearchCategoryListResult!=null &&
              this.getAdvSearchCategoryListResult.equals(other.getGetAdvSearchCategoryListResult())));
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
        if (getGetAdvSearchCategoryListResult() != null) {
            _hashCode += getGetAdvSearchCategoryListResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetAdvSearchCategoryListResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetAdvSearchCategoryListResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getAdvSearchCategoryListResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetAdvSearchCategoryListResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetAdvSearchCategoryListResponse>GetAdvSearchCategoryListResult"));
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
