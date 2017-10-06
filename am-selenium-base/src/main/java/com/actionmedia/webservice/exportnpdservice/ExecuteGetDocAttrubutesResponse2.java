/**
 * ExecuteGetDocAttrubutesResponse2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.exportnpdservice;

public class ExecuteGetDocAttrubutesResponse2  extends com.actionmedia.webservice.exportnpdservice.ExecuteResponse  implements java.io.Serializable {
    private java.lang.String pubDate;

    private java.lang.String staticImagesDirPath;

    private java.lang.String versionDate;

    private java.lang.String docStatus;

    private java.lang.String fullAttrRow;

    private com.actionmedia.webservice.exportnpdservice.DocumentAttribute[] attributeList;

    private com.actionmedia.webservice.exportnpdservice.DocChainRow2[] docChainList;

    private com.actionmedia.webservice.exportnpdservice.AttachmentRow[] attachmentList;

    public ExecuteGetDocAttrubutesResponse2() {
    }

    public ExecuteGetDocAttrubutesResponse2(
           long durationInMSec,
           java.lang.String pubDate,
           java.lang.String staticImagesDirPath,
           java.lang.String versionDate,
           java.lang.String docStatus,
           java.lang.String fullAttrRow,
           com.actionmedia.webservice.exportnpdservice.DocumentAttribute[] attributeList,
           com.actionmedia.webservice.exportnpdservice.DocChainRow2[] docChainList,
           com.actionmedia.webservice.exportnpdservice.AttachmentRow[] attachmentList) {
        super(
            durationInMSec);
        this.pubDate = pubDate;
        this.staticImagesDirPath = staticImagesDirPath;
        this.versionDate = versionDate;
        this.docStatus = docStatus;
        this.fullAttrRow = fullAttrRow;
        this.attributeList = attributeList;
        this.docChainList = docChainList;
        this.attachmentList = attachmentList;
    }


    /**
     * Gets the pubDate value for this ExecuteGetDocAttrubutesResponse2.
     * 
     * @return pubDate
     */
    public java.lang.String getPubDate() {
        return pubDate;
    }


    /**
     * Sets the pubDate value for this ExecuteGetDocAttrubutesResponse2.
     * 
     * @param pubDate
     */
    public void setPubDate(java.lang.String pubDate) {
        this.pubDate = pubDate;
    }


    /**
     * Gets the staticImagesDirPath value for this ExecuteGetDocAttrubutesResponse2.
     * 
     * @return staticImagesDirPath
     */
    public java.lang.String getStaticImagesDirPath() {
        return staticImagesDirPath;
    }


    /**
     * Sets the staticImagesDirPath value for this ExecuteGetDocAttrubutesResponse2.
     * 
     * @param staticImagesDirPath
     */
    public void setStaticImagesDirPath(java.lang.String staticImagesDirPath) {
        this.staticImagesDirPath = staticImagesDirPath;
    }


    /**
     * Gets the versionDate value for this ExecuteGetDocAttrubutesResponse2.
     * 
     * @return versionDate
     */
    public java.lang.String getVersionDate() {
        return versionDate;
    }


    /**
     * Sets the versionDate value for this ExecuteGetDocAttrubutesResponse2.
     * 
     * @param versionDate
     */
    public void setVersionDate(java.lang.String versionDate) {
        this.versionDate = versionDate;
    }


    /**
     * Gets the docStatus value for this ExecuteGetDocAttrubutesResponse2.
     * 
     * @return docStatus
     */
    public java.lang.String getDocStatus() {
        return docStatus;
    }


    /**
     * Sets the docStatus value for this ExecuteGetDocAttrubutesResponse2.
     * 
     * @param docStatus
     */
    public void setDocStatus(java.lang.String docStatus) {
        this.docStatus = docStatus;
    }


    /**
     * Gets the fullAttrRow value for this ExecuteGetDocAttrubutesResponse2.
     * 
     * @return fullAttrRow
     */
    public java.lang.String getFullAttrRow() {
        return fullAttrRow;
    }


    /**
     * Sets the fullAttrRow value for this ExecuteGetDocAttrubutesResponse2.
     * 
     * @param fullAttrRow
     */
    public void setFullAttrRow(java.lang.String fullAttrRow) {
        this.fullAttrRow = fullAttrRow;
    }


    /**
     * Gets the attributeList value for this ExecuteGetDocAttrubutesResponse2.
     * 
     * @return attributeList
     */
    public com.actionmedia.webservice.exportnpdservice.DocumentAttribute[] getAttributeList() {
        return attributeList;
    }


    /**
     * Sets the attributeList value for this ExecuteGetDocAttrubutesResponse2.
     * 
     * @param attributeList
     */
    public void setAttributeList(com.actionmedia.webservice.exportnpdservice.DocumentAttribute[] attributeList) {
        this.attributeList = attributeList;
    }

    public com.actionmedia.webservice.exportnpdservice.DocumentAttribute getAttributeList(int i) {
        return this.attributeList[i];
    }

    public void setAttributeList(int i, com.actionmedia.webservice.exportnpdservice.DocumentAttribute _value) {
        this.attributeList[i] = _value;
    }


    /**
     * Gets the docChainList value for this ExecuteGetDocAttrubutesResponse2.
     * 
     * @return docChainList
     */
    public com.actionmedia.webservice.exportnpdservice.DocChainRow2[] getDocChainList() {
        return docChainList;
    }


    /**
     * Sets the docChainList value for this ExecuteGetDocAttrubutesResponse2.
     * 
     * @param docChainList
     */
    public void setDocChainList(com.actionmedia.webservice.exportnpdservice.DocChainRow2[] docChainList) {
        this.docChainList = docChainList;
    }

    public com.actionmedia.webservice.exportnpdservice.DocChainRow2 getDocChainList(int i) {
        return this.docChainList[i];
    }

    public void setDocChainList(int i, com.actionmedia.webservice.exportnpdservice.DocChainRow2 _value) {
        this.docChainList[i] = _value;
    }


    /**
     * Gets the attachmentList value for this ExecuteGetDocAttrubutesResponse2.
     * 
     * @return attachmentList
     */
    public com.actionmedia.webservice.exportnpdservice.AttachmentRow[] getAttachmentList() {
        return attachmentList;
    }


    /**
     * Sets the attachmentList value for this ExecuteGetDocAttrubutesResponse2.
     * 
     * @param attachmentList
     */
    public void setAttachmentList(com.actionmedia.webservice.exportnpdservice.AttachmentRow[] attachmentList) {
        this.attachmentList = attachmentList;
    }

    public com.actionmedia.webservice.exportnpdservice.AttachmentRow getAttachmentList(int i) {
        return this.attachmentList[i];
    }

    public void setAttachmentList(int i, com.actionmedia.webservice.exportnpdservice.AttachmentRow _value) {
        this.attachmentList[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExecuteGetDocAttrubutesResponse2)) return false;
        ExecuteGetDocAttrubutesResponse2 other = (ExecuteGetDocAttrubutesResponse2) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.pubDate==null && other.getPubDate()==null) || 
             (this.pubDate!=null &&
              this.pubDate.equals(other.getPubDate()))) &&
            ((this.staticImagesDirPath==null && other.getStaticImagesDirPath()==null) || 
             (this.staticImagesDirPath!=null &&
              this.staticImagesDirPath.equals(other.getStaticImagesDirPath()))) &&
            ((this.versionDate==null && other.getVersionDate()==null) || 
             (this.versionDate!=null &&
              this.versionDate.equals(other.getVersionDate()))) &&
            ((this.docStatus==null && other.getDocStatus()==null) || 
             (this.docStatus!=null &&
              this.docStatus.equals(other.getDocStatus()))) &&
            ((this.fullAttrRow==null && other.getFullAttrRow()==null) || 
             (this.fullAttrRow!=null &&
              this.fullAttrRow.equals(other.getFullAttrRow()))) &&
            ((this.attributeList==null && other.getAttributeList()==null) || 
             (this.attributeList!=null &&
              java.util.Arrays.equals(this.attributeList, other.getAttributeList()))) &&
            ((this.docChainList==null && other.getDocChainList()==null) || 
             (this.docChainList!=null &&
              java.util.Arrays.equals(this.docChainList, other.getDocChainList()))) &&
            ((this.attachmentList==null && other.getAttachmentList()==null) || 
             (this.attachmentList!=null &&
              java.util.Arrays.equals(this.attachmentList, other.getAttachmentList())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getPubDate() != null) {
            _hashCode += getPubDate().hashCode();
        }
        if (getStaticImagesDirPath() != null) {
            _hashCode += getStaticImagesDirPath().hashCode();
        }
        if (getVersionDate() != null) {
            _hashCode += getVersionDate().hashCode();
        }
        if (getDocStatus() != null) {
            _hashCode += getDocStatus().hashCode();
        }
        if (getFullAttrRow() != null) {
            _hashCode += getFullAttrRow().hashCode();
        }
        if (getAttributeList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAttributeList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAttributeList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDocChainList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDocChainList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDocChainList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAttachmentList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAttachmentList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAttachmentList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExecuteGetDocAttrubutesResponse2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetDocAttrubutesResponse2"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "PubDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("staticImagesDirPath");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "StaticImagesDirPath"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("versionDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "VersionDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "DocStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fullAttrRow");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "FullAttrRow"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attributeList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "AttributeList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "DocumentAttribute"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docChainList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "DocChainList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "DocChainRow2"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attachmentList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "AttachmentList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "AttachmentRow"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
