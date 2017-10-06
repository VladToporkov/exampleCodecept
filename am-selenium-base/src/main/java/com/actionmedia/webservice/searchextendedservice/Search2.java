/**
 * Search2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchextendedservice;

public class Search2  implements java.io.Serializable {
    private org.apache.axis.types.UnsignedByte pubDivId;

    private java.lang.String searchString;

    private java.lang.String docRegionIDList;

    private java.lang.String docTypeIDList;

    private java.lang.String docLobbyIDList;

    private java.lang.String docNumber;

    private java.lang.String pubDateStartedOn;

    private java.lang.String pubDateEndedOn;

    private boolean isActual;

    private boolean isExtended;

    public Search2() {
    }

    public Search2(
           org.apache.axis.types.UnsignedByte pubDivId,
           java.lang.String searchString,
           java.lang.String docRegionIDList,
           java.lang.String docTypeIDList,
           java.lang.String docLobbyIDList,
           java.lang.String docNumber,
           java.lang.String pubDateStartedOn,
           java.lang.String pubDateEndedOn,
           boolean isActual,
           boolean isExtended) {
           this.pubDivId = pubDivId;
           this.searchString = searchString;
           this.docRegionIDList = docRegionIDList;
           this.docTypeIDList = docTypeIDList;
           this.docLobbyIDList = docLobbyIDList;
           this.docNumber = docNumber;
           this.pubDateStartedOn = pubDateStartedOn;
           this.pubDateEndedOn = pubDateEndedOn;
           this.isActual = isActual;
           this.isExtended = isExtended;
    }


    /**
     * Gets the pubDivId value for this Search2.
     * 
     * @return pubDivId
     */
    public org.apache.axis.types.UnsignedByte getPubDivId() {
        return pubDivId;
    }


    /**
     * Sets the pubDivId value for this Search2.
     * 
     * @param pubDivId
     */
    public void setPubDivId(org.apache.axis.types.UnsignedByte pubDivId) {
        this.pubDivId = pubDivId;
    }


    /**
     * Gets the searchString value for this Search2.
     * 
     * @return searchString
     */
    public java.lang.String getSearchString() {
        return searchString;
    }


    /**
     * Sets the searchString value for this Search2.
     * 
     * @param searchString
     */
    public void setSearchString(java.lang.String searchString) {
        this.searchString = searchString;
    }


    /**
     * Gets the docRegionIDList value for this Search2.
     * 
     * @return docRegionIDList
     */
    public java.lang.String getDocRegionIDList() {
        return docRegionIDList;
    }


    /**
     * Sets the docRegionIDList value for this Search2.
     * 
     * @param docRegionIDList
     */
    public void setDocRegionIDList(java.lang.String docRegionIDList) {
        this.docRegionIDList = docRegionIDList;
    }


    /**
     * Gets the docTypeIDList value for this Search2.
     * 
     * @return docTypeIDList
     */
    public java.lang.String getDocTypeIDList() {
        return docTypeIDList;
    }


    /**
     * Sets the docTypeIDList value for this Search2.
     * 
     * @param docTypeIDList
     */
    public void setDocTypeIDList(java.lang.String docTypeIDList) {
        this.docTypeIDList = docTypeIDList;
    }


    /**
     * Gets the docLobbyIDList value for this Search2.
     * 
     * @return docLobbyIDList
     */
    public java.lang.String getDocLobbyIDList() {
        return docLobbyIDList;
    }


    /**
     * Sets the docLobbyIDList value for this Search2.
     * 
     * @param docLobbyIDList
     */
    public void setDocLobbyIDList(java.lang.String docLobbyIDList) {
        this.docLobbyIDList = docLobbyIDList;
    }


    /**
     * Gets the docNumber value for this Search2.
     * 
     * @return docNumber
     */
    public java.lang.String getDocNumber() {
        return docNumber;
    }


    /**
     * Sets the docNumber value for this Search2.
     * 
     * @param docNumber
     */
    public void setDocNumber(java.lang.String docNumber) {
        this.docNumber = docNumber;
    }


    /**
     * Gets the pubDateStartedOn value for this Search2.
     * 
     * @return pubDateStartedOn
     */
    public java.lang.String getPubDateStartedOn() {
        return pubDateStartedOn;
    }


    /**
     * Sets the pubDateStartedOn value for this Search2.
     * 
     * @param pubDateStartedOn
     */
    public void setPubDateStartedOn(java.lang.String pubDateStartedOn) {
        this.pubDateStartedOn = pubDateStartedOn;
    }


    /**
     * Gets the pubDateEndedOn value for this Search2.
     * 
     * @return pubDateEndedOn
     */
    public java.lang.String getPubDateEndedOn() {
        return pubDateEndedOn;
    }


    /**
     * Sets the pubDateEndedOn value for this Search2.
     * 
     * @param pubDateEndedOn
     */
    public void setPubDateEndedOn(java.lang.String pubDateEndedOn) {
        this.pubDateEndedOn = pubDateEndedOn;
    }


    /**
     * Gets the isActual value for this Search2.
     * 
     * @return isActual
     */
    public boolean isIsActual() {
        return isActual;
    }


    /**
     * Sets the isActual value for this Search2.
     * 
     * @param isActual
     */
    public void setIsActual(boolean isActual) {
        this.isActual = isActual;
    }


    /**
     * Gets the isExtended value for this Search2.
     * 
     * @return isExtended
     */
    public boolean isIsExtended() {
        return isExtended;
    }


    /**
     * Sets the isExtended value for this Search2.
     * 
     * @param isExtended
     */
    public void setIsExtended(boolean isExtended) {
        this.isExtended = isExtended;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Search2)) return false;
        Search2 other = (Search2) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.pubDivId==null && other.getPubDivId()==null) || 
             (this.pubDivId!=null &&
              this.pubDivId.equals(other.getPubDivId()))) &&
            ((this.searchString==null && other.getSearchString()==null) || 
             (this.searchString!=null &&
              this.searchString.equals(other.getSearchString()))) &&
            ((this.docRegionIDList==null && other.getDocRegionIDList()==null) || 
             (this.docRegionIDList!=null &&
              this.docRegionIDList.equals(other.getDocRegionIDList()))) &&
            ((this.docTypeIDList==null && other.getDocTypeIDList()==null) || 
             (this.docTypeIDList!=null &&
              this.docTypeIDList.equals(other.getDocTypeIDList()))) &&
            ((this.docLobbyIDList==null && other.getDocLobbyIDList()==null) || 
             (this.docLobbyIDList!=null &&
              this.docLobbyIDList.equals(other.getDocLobbyIDList()))) &&
            ((this.docNumber==null && other.getDocNumber()==null) || 
             (this.docNumber!=null &&
              this.docNumber.equals(other.getDocNumber()))) &&
            ((this.pubDateStartedOn==null && other.getPubDateStartedOn()==null) || 
             (this.pubDateStartedOn!=null &&
              this.pubDateStartedOn.equals(other.getPubDateStartedOn()))) &&
            ((this.pubDateEndedOn==null && other.getPubDateEndedOn()==null) || 
             (this.pubDateEndedOn!=null &&
              this.pubDateEndedOn.equals(other.getPubDateEndedOn()))) &&
            this.isActual == other.isIsActual() &&
            this.isExtended == other.isIsExtended();
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
        if (getPubDivId() != null) {
            _hashCode += getPubDivId().hashCode();
        }
        if (getSearchString() != null) {
            _hashCode += getSearchString().hashCode();
        }
        if (getDocRegionIDList() != null) {
            _hashCode += getDocRegionIDList().hashCode();
        }
        if (getDocTypeIDList() != null) {
            _hashCode += getDocTypeIDList().hashCode();
        }
        if (getDocLobbyIDList() != null) {
            _hashCode += getDocLobbyIDList().hashCode();
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
        _hashCode += (isIsExtended() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Search2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">Search2"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubDivId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "pubDivId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchString");
        elemField.setXmlName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "SearchString"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docRegionIDList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "DocRegionIDList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docTypeIDList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "DocTypeIDList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docLobbyIDList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "DocLobbyIDList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "DocNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubDateStartedOn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "PubDateStartedOn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubDateEndedOn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "PubDateEndedOn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isActual");
        elemField.setXmlName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "IsActual"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isExtended");
        elemField.setXmlName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "IsExtended"));
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
