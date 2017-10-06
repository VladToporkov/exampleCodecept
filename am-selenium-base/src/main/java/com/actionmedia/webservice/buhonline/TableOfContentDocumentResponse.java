/**
 * TableOfContentDocumentResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.buhonline;

public class TableOfContentDocumentResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.buhonline.TableOfContentDocumentResponseTableOfContentDocumentResult tableOfContentDocumentResult;

    public TableOfContentDocumentResponse() {
    }

    public TableOfContentDocumentResponse(
           com.actionmedia.webservice.buhonline.TableOfContentDocumentResponseTableOfContentDocumentResult tableOfContentDocumentResult) {
           this.tableOfContentDocumentResult = tableOfContentDocumentResult;
    }


    /**
     * Gets the tableOfContentDocumentResult value for this TableOfContentDocumentResponse.
     * 
     * @return tableOfContentDocumentResult
     */
    public com.actionmedia.webservice.buhonline.TableOfContentDocumentResponseTableOfContentDocumentResult getTableOfContentDocumentResult() {
        return tableOfContentDocumentResult;
    }


    /**
     * Sets the tableOfContentDocumentResult value for this TableOfContentDocumentResponse.
     * 
     * @param tableOfContentDocumentResult
     */
    public void setTableOfContentDocumentResult(com.actionmedia.webservice.buhonline.TableOfContentDocumentResponseTableOfContentDocumentResult tableOfContentDocumentResult) {
        this.tableOfContentDocumentResult = tableOfContentDocumentResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TableOfContentDocumentResponse)) return false;
        TableOfContentDocumentResponse other = (TableOfContentDocumentResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.tableOfContentDocumentResult==null && other.getTableOfContentDocumentResult()==null) || 
             (this.tableOfContentDocumentResult!=null &&
              this.tableOfContentDocumentResult.equals(other.getTableOfContentDocumentResult())));
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
        if (getTableOfContentDocumentResult() != null) {
            _hashCode += getTableOfContentDocumentResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TableOfContentDocumentResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">TableOfContentDocumentResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tableOfContentDocumentResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "TableOfContentDocumentResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>TableOfContentDocumentResponse>TableOfContentDocumentResult"));
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
