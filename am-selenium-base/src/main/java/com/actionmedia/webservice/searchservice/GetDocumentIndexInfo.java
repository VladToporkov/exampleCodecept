/**
 * GetDocumentIndexInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class GetDocumentIndexInfo  implements java.io.Serializable {
    private org.apache.axis.types.UnsignedByte pubID;

    private org.apache.axis.types.UnsignedByte moduleID;

    private java.lang.Integer documentID;

    public GetDocumentIndexInfo() {
    }

    public GetDocumentIndexInfo(
           org.apache.axis.types.UnsignedByte pubID,
           org.apache.axis.types.UnsignedByte moduleID,
           java.lang.Integer documentID) {
           this.pubID = pubID;
           this.moduleID = moduleID;
           this.documentID = documentID;
    }


    /**
     * Gets the pubID value for this GetDocumentIndexInfo.
     * 
     * @return pubID
     */
    public org.apache.axis.types.UnsignedByte getPubID() {
        return pubID;
    }


    /**
     * Sets the pubID value for this GetDocumentIndexInfo.
     * 
     * @param pubID
     */
    public void setPubID(org.apache.axis.types.UnsignedByte pubID) {
        this.pubID = pubID;
    }


    /**
     * Gets the moduleID value for this GetDocumentIndexInfo.
     * 
     * @return moduleID
     */
    public org.apache.axis.types.UnsignedByte getModuleID() {
        return moduleID;
    }


    /**
     * Sets the moduleID value for this GetDocumentIndexInfo.
     * 
     * @param moduleID
     */
    public void setModuleID(org.apache.axis.types.UnsignedByte moduleID) {
        this.moduleID = moduleID;
    }


    /**
     * Gets the documentID value for this GetDocumentIndexInfo.
     * 
     * @return documentID
     */
    public java.lang.Integer getDocumentID() {
        return documentID;
    }


    /**
     * Sets the documentID value for this GetDocumentIndexInfo.
     * 
     * @param documentID
     */
    public void setDocumentID(java.lang.Integer documentID) {
        this.documentID = documentID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetDocumentIndexInfo)) return false;
        GetDocumentIndexInfo other = (GetDocumentIndexInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.pubID==null && other.getPubID()==null) || 
             (this.pubID!=null &&
              this.pubID.equals(other.getPubID()))) &&
            ((this.moduleID==null && other.getModuleID()==null) || 
             (this.moduleID!=null &&
              this.moduleID.equals(other.getModuleID()))) &&
            ((this.documentID==null && other.getDocumentID()==null) || 
             (this.documentID!=null &&
              this.documentID.equals(other.getDocumentID())));
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
        if (getPubID() != null) {
            _hashCode += getPubID().hashCode();
        }
        if (getModuleID() != null) {
            _hashCode += getModuleID().hashCode();
        }
        if (getDocumentID() != null) {
            _hashCode += getDocumentID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetDocumentIndexInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetDocumentIndexInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "pubID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moduleID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "moduleID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "documentID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
