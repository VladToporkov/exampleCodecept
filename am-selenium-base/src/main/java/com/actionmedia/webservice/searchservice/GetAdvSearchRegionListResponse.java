/**
 * GetAdvSearchRegionListResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class GetAdvSearchRegionListResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.searchservice.GetAdvSearchRegionListResponseGetAdvSearchRegionListResult getAdvSearchRegionListResult;

    public GetAdvSearchRegionListResponse() {
    }

    public GetAdvSearchRegionListResponse(
           com.actionmedia.webservice.searchservice.GetAdvSearchRegionListResponseGetAdvSearchRegionListResult getAdvSearchRegionListResult) {
           this.getAdvSearchRegionListResult = getAdvSearchRegionListResult;
    }


    /**
     * Gets the getAdvSearchRegionListResult value for this GetAdvSearchRegionListResponse.
     * 
     * @return getAdvSearchRegionListResult
     */
    public com.actionmedia.webservice.searchservice.GetAdvSearchRegionListResponseGetAdvSearchRegionListResult getGetAdvSearchRegionListResult() {
        return getAdvSearchRegionListResult;
    }


    /**
     * Sets the getAdvSearchRegionListResult value for this GetAdvSearchRegionListResponse.
     * 
     * @param getAdvSearchRegionListResult
     */
    public void setGetAdvSearchRegionListResult(com.actionmedia.webservice.searchservice.GetAdvSearchRegionListResponseGetAdvSearchRegionListResult getAdvSearchRegionListResult) {
        this.getAdvSearchRegionListResult = getAdvSearchRegionListResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetAdvSearchRegionListResponse)) return false;
        GetAdvSearchRegionListResponse other = (GetAdvSearchRegionListResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getAdvSearchRegionListResult==null && other.getGetAdvSearchRegionListResult()==null) || 
             (this.getAdvSearchRegionListResult!=null &&
              this.getAdvSearchRegionListResult.equals(other.getGetAdvSearchRegionListResult())));
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
        if (getGetAdvSearchRegionListResult() != null) {
            _hashCode += getGetAdvSearchRegionListResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetAdvSearchRegionListResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetAdvSearchRegionListResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getAdvSearchRegionListResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetAdvSearchRegionListResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetAdvSearchRegionListResponse>GetAdvSearchRegionListResult"));
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