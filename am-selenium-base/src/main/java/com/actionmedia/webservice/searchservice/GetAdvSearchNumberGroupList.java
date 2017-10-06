/**
 * GetAdvSearchNumberGroupList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class GetAdvSearchNumberGroupList  implements java.io.Serializable {
    private org.apache.axis.types.UnsignedByte pubId;

    private org.apache.axis.types.UnsignedByte moduleID;

    private java.lang.Integer id;

    private java.lang.Boolean isLucene;

    public GetAdvSearchNumberGroupList() {
    }

    public GetAdvSearchNumberGroupList(
           org.apache.axis.types.UnsignedByte pubId,
           org.apache.axis.types.UnsignedByte moduleID,
           java.lang.Integer id,
           java.lang.Boolean isLucene) {
           this.pubId = pubId;
           this.moduleID = moduleID;
           this.id = id;
           this.isLucene = isLucene;
    }


    /**
     * Gets the pubId value for this GetAdvSearchNumberGroupList.
     * 
     * @return pubId
     */
    public org.apache.axis.types.UnsignedByte getPubId() {
        return pubId;
    }


    /**
     * Sets the pubId value for this GetAdvSearchNumberGroupList.
     * 
     * @param pubId
     */
    public void setPubId(org.apache.axis.types.UnsignedByte pubId) {
        this.pubId = pubId;
    }


    /**
     * Gets the moduleID value for this GetAdvSearchNumberGroupList.
     * 
     * @return moduleID
     */
    public org.apache.axis.types.UnsignedByte getModuleID() {
        return moduleID;
    }


    /**
     * Sets the moduleID value for this GetAdvSearchNumberGroupList.
     * 
     * @param moduleID
     */
    public void setModuleID(org.apache.axis.types.UnsignedByte moduleID) {
        this.moduleID = moduleID;
    }


    /**
     * Gets the id value for this GetAdvSearchNumberGroupList.
     * 
     * @return id
     */
    public java.lang.Integer getId() {
        return id;
    }


    /**
     * Sets the id value for this GetAdvSearchNumberGroupList.
     * 
     * @param id
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }


    /**
     * Gets the isLucene value for this GetAdvSearchNumberGroupList.
     * 
     * @return isLucene
     */
    public java.lang.Boolean getIsLucene() {
        return isLucene;
    }


    /**
     * Sets the isLucene value for this GetAdvSearchNumberGroupList.
     * 
     * @param isLucene
     */
    public void setIsLucene(java.lang.Boolean isLucene) {
        this.isLucene = isLucene;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetAdvSearchNumberGroupList)) return false;
        GetAdvSearchNumberGroupList other = (GetAdvSearchNumberGroupList) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.pubId==null && other.getPubId()==null) || 
             (this.pubId!=null &&
              this.pubId.equals(other.getPubId()))) &&
            ((this.moduleID==null && other.getModuleID()==null) || 
             (this.moduleID!=null &&
              this.moduleID.equals(other.getModuleID()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.isLucene==null && other.getIsLucene()==null) || 
             (this.isLucene!=null &&
              this.isLucene.equals(other.getIsLucene())));
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
        if (getPubId() != null) {
            _hashCode += getPubId().hashCode();
        }
        if (getModuleID() != null) {
            _hashCode += getModuleID().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIsLucene() != null) {
            _hashCode += getIsLucene().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetAdvSearchNumberGroupList.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetAdvSearchNumberGroupList"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "pubId"));
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
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isLucene");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "isLucene"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
