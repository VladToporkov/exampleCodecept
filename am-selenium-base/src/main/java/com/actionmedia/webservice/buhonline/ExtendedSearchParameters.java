/**
 * ExtendedSearchParameters.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.buhonline;

public class ExtendedSearchParameters  implements java.io.Serializable {
    private java.lang.Integer regionID;

    private java.lang.Integer typeID;

    private java.lang.Integer lobbyID;

    private java.lang.String docNumber;

    private java.util.Calendar pubDateStartedOn;

    private java.util.Calendar pubDateEndedOn;

    private boolean isActual;

    public ExtendedSearchParameters() {
    }

    public ExtendedSearchParameters(
           java.lang.Integer regionID,
           java.lang.Integer typeID,
           java.lang.Integer lobbyID,
           java.lang.String docNumber,
           java.util.Calendar pubDateStartedOn,
           java.util.Calendar pubDateEndedOn,
           boolean isActual) {
           this.regionID = regionID;
           this.typeID = typeID;
           this.lobbyID = lobbyID;
           this.docNumber = docNumber;
           this.pubDateStartedOn = pubDateStartedOn;
           this.pubDateEndedOn = pubDateEndedOn;
           this.isActual = isActual;
    }


    /**
     * Gets the regionID value for this ExtendedSearchParameters.
     * 
     * @return regionID
     */
    public java.lang.Integer getRegionID() {
        return regionID;
    }


    /**
     * Sets the regionID value for this ExtendedSearchParameters.
     * 
     * @param regionID
     */
    public void setRegionID(java.lang.Integer regionID) {
        this.regionID = regionID;
    }


    /**
     * Gets the typeID value for this ExtendedSearchParameters.
     * 
     * @return typeID
     */
    public java.lang.Integer getTypeID() {
        return typeID;
    }


    /**
     * Sets the typeID value for this ExtendedSearchParameters.
     * 
     * @param typeID
     */
    public void setTypeID(java.lang.Integer typeID) {
        this.typeID = typeID;
    }


    /**
     * Gets the lobbyID value for this ExtendedSearchParameters.
     * 
     * @return lobbyID
     */
    public java.lang.Integer getLobbyID() {
        return lobbyID;
    }


    /**
     * Sets the lobbyID value for this ExtendedSearchParameters.
     * 
     * @param lobbyID
     */
    public void setLobbyID(java.lang.Integer lobbyID) {
        this.lobbyID = lobbyID;
    }


    /**
     * Gets the docNumber value for this ExtendedSearchParameters.
     * 
     * @return docNumber
     */
    public java.lang.String getDocNumber() {
        return docNumber;
    }


    /**
     * Sets the docNumber value for this ExtendedSearchParameters.
     * 
     * @param docNumber
     */
    public void setDocNumber(java.lang.String docNumber) {
        this.docNumber = docNumber;
    }


    /**
     * Gets the pubDateStartedOn value for this ExtendedSearchParameters.
     * 
     * @return pubDateStartedOn
     */
    public java.util.Calendar getPubDateStartedOn() {
        return pubDateStartedOn;
    }


    /**
     * Sets the pubDateStartedOn value for this ExtendedSearchParameters.
     * 
     * @param pubDateStartedOn
     */
    public void setPubDateStartedOn(java.util.Calendar pubDateStartedOn) {
        this.pubDateStartedOn = pubDateStartedOn;
    }


    /**
     * Gets the pubDateEndedOn value for this ExtendedSearchParameters.
     * 
     * @return pubDateEndedOn
     */
    public java.util.Calendar getPubDateEndedOn() {
        return pubDateEndedOn;
    }


    /**
     * Sets the pubDateEndedOn value for this ExtendedSearchParameters.
     * 
     * @param pubDateEndedOn
     */
    public void setPubDateEndedOn(java.util.Calendar pubDateEndedOn) {
        this.pubDateEndedOn = pubDateEndedOn;
    }


    /**
     * Gets the isActual value for this ExtendedSearchParameters.
     * 
     * @return isActual
     */
    public boolean isIsActual() {
        return isActual;
    }


    /**
     * Sets the isActual value for this ExtendedSearchParameters.
     * 
     * @param isActual
     */
    public void setIsActual(boolean isActual) {
        this.isActual = isActual;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExtendedSearchParameters)) return false;
        ExtendedSearchParameters other = (ExtendedSearchParameters) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.regionID==null && other.getRegionID()==null) || 
             (this.regionID!=null &&
              this.regionID.equals(other.getRegionID()))) &&
            ((this.typeID==null && other.getTypeID()==null) || 
             (this.typeID!=null &&
              this.typeID.equals(other.getTypeID()))) &&
            ((this.lobbyID==null && other.getLobbyID()==null) || 
             (this.lobbyID!=null &&
              this.lobbyID.equals(other.getLobbyID()))) &&
            ((this.docNumber==null && other.getDocNumber()==null) || 
             (this.docNumber!=null &&
              this.docNumber.equals(other.getDocNumber()))) &&
            ((this.pubDateStartedOn==null && other.getPubDateStartedOn()==null) || 
             (this.pubDateStartedOn!=null &&
              this.pubDateStartedOn.equals(other.getPubDateStartedOn()))) &&
            ((this.pubDateEndedOn==null && other.getPubDateEndedOn()==null) || 
             (this.pubDateEndedOn!=null &&
              this.pubDateEndedOn.equals(other.getPubDateEndedOn()))) &&
            this.isActual == other.isIsActual();
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
        if (getRegionID() != null) {
            _hashCode += getRegionID().hashCode();
        }
        if (getTypeID() != null) {
            _hashCode += getTypeID().hashCode();
        }
        if (getLobbyID() != null) {
            _hashCode += getLobbyID().hashCode();
        }
        if (getDocNumber() != null) {
            _hashCode += getDocNumber().hashCode();
        }
        if (getPubDateStartedOn() != null) {
            _hashCode += getPubDateStartedOn().hashCode();
        }
        if (getPubDateEndedOn() != null) {
            _hashCode += getPubDateEndedOn().hashCode();
        }
        _hashCode += (isIsActual() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExtendedSearchParameters.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ExtendedSearchParameters"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("regionID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "RegionID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("typeID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "TypeID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lobbyID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "LobbyID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "DocNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubDateStartedOn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "PubDateStartedOn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubDateEndedOn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "PubDateEndedOn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isActual");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "IsActual"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
