<?xml version="1.0" encoding="utf-8"?>
<wsdl:definitions xmlns:s="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://schemas.xmlsoap.org/wsdl/soap12/" xmlns:http="http://schemas.xmlsoap.org/wsdl/http/" xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/" xmlns:tns="http://www.1gl.ru/" xmlns:s2="http://www.1gl.ru/AbstractTypes" xmlns:s1="http://microsoft.com/wsdl/types/" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tm="http://microsoft.com/wsdl/mime/textMatching/" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" targetNamespace="http://www.1gl.ru/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
  <wsdl:types>
    <s:schema elementFormDefault="qualified" targetNamespace="http://www.1gl.ru/">
      <s:import namespace="http://microsoft.com/wsdl/types/" />
      <s:element name="GetHyperLinkTargetByGuid">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="LinkGuid" type="s1:guid" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetHyperLinkTargetByGuidResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetHyperLinkTargetByGuidResult" type="tns:ExecuteGetHyperLinkTargetByGuidResponse" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ExecuteGetHyperLinkTargetByGuidResponse">
        <s:complexContent mixed="false">
          <s:extension base="tns:ExecuteResponse">
            <s:sequence>
              <s:element minOccurs="1" maxOccurs="1" name="DocumentID" type="s:int" />
              <s:element minOccurs="1" maxOccurs="1" name="ModuleID" type="s:short" />
              <s:element minOccurs="0" maxOccurs="1" name="Anchor" type="s:string" />
              <s:element minOccurs="1" maxOccurs="1" name="TargetExists" type="s:boolean" />
            </s:sequence>
          </s:extension>
        </s:complexContent>
      </s:complexType>
      <s:complexType name="ExecuteResponse" abstract="true">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="DurationInMSec" type="s:long" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="ExecuteGetNpdAnnouncesByIndustryForMonthResponse">
        <s:complexContent mixed="false">
          <s:extension base="tns:ExecuteResponse">
            <s:sequence>
              <s:element minOccurs="0" maxOccurs="unbounded" name="AnnounceList" type="tns:DocAnnounceWithIndustryFlag" />
            </s:sequence>
          </s:extension>
        </s:complexContent>
      </s:complexType>
      <s:complexType name="DocAnnounceWithIndustryFlag">
        <s:complexContent mixed="false">
          <s:extension base="tns:DocSpecification">
            <s:sequence>
              <s:element minOccurs="1" maxOccurs="1" name="AnnounceDate" type="s:dateTime" />
              <s:element minOccurs="0" maxOccurs="1" name="AnnounceTitle" type="s:string" />
              <s:element minOccurs="0" maxOccurs="1" name="AnnounceSnippet" type="s:string" />
              <s:element minOccurs="0" maxOccurs="1" name="AnnounceAnchor" type="s:string" />
              <s:element minOccurs="1" maxOccurs="1" name="IndustryFlags" type="tns:eIndustryFlags" />
            </s:sequence>
          </s:extension>
        </s:complexContent>
      </s:complexType>
      <s:complexType name="DocSpecification">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="ModuleID" type="s:unsignedByte" />
          <s:element minOccurs="1" maxOccurs="1" name="ID" type="s:int" />
        </s:sequence>
      </s:complexType>
      <s:simpleType name="eIndustryFlags">
        <s:list>
          <s:simpleType>
            <s:restriction base="s:string">
              <s:enumeration value="Empty" />
              <s:enumeration value="Commerce" />
              <s:enumeration value="Budget" />
              <s:enumeration value="SmallBusiness" />
              <s:enumeration value="Luxury" />
              <s:enumeration value="Personnel" />
              <s:enumeration value="Uss" />
              <s:enumeration value="Fss" />
              <s:enumeration value="KssBU" />
              <s:enumeration value="KssLux" />
              <s:enumeration value="All" />
            </s:restriction>
          </s:simpleType>
        </s:list>
      </s:simpleType>
      <s:complexType name="ExecuteGetDocAttrubutesResponse">
        <s:complexContent mixed="false">
          <s:extension base="tns:ExecuteResponse">
            <s:sequence>
              <s:element minOccurs="0" maxOccurs="1" name="PubDate" type="s:string" />
              <s:element minOccurs="0" maxOccurs="1" name="StaticImagesDirPath" type="s:string" />
              <s:element minOccurs="0" maxOccurs="1" name="VersionDate" type="s:string" />
              <s:element minOccurs="0" maxOccurs="1" name="FullAttrRow" type="s:string" />
              <s:element minOccurs="0" maxOccurs="unbounded" name="AttributeList" type="tns:DocumentAttribute" />
              <s:element minOccurs="0" maxOccurs="unbounded" name="DocChainList" type="tns:DocChainRow" />
              <s:element minOccurs="0" maxOccurs="unbounded" name="AttachmentList" type="tns:AttachmentRow" />
            </s:sequence>
          </s:extension>
        </s:complexContent>
      </s:complexType>
      <s:complexType name="DocumentAttribute">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="1" name="Name" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="Value" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="DocChainRow">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="ModuleID" type="s:unsignedByte" />
          <s:element minOccurs="1" maxOccurs="1" name="ID" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="BeginDate" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="EndDate" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="AttachmentRow">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="1" name="ArtName" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="ArtUrl" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="ModuleID" type="s:unsignedByte" />
          <s:element minOccurs="1" maxOccurs="1" name="ID" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="MimeType" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="FormNumber" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="OKUD" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="KND" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:element name="GetNpdAnnouncesForMonth">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="pubIDList" type="tns:ArrayOfUnsignedByte" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ArrayOfUnsignedByte">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="unsignedByte" type="s:unsignedByte" />
        </s:sequence>
      </s:complexType>
      <s:element name="GetNpdAnnouncesForMonthResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetNpdAnnouncesForMonthResult" type="tns:ExecuteGetNpdAnnouncesForMonthResponse" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ExecuteGetNpdAnnouncesForMonthResponse">
        <s:complexContent mixed="false">
          <s:extension base="tns:ExecuteResponse">
            <s:sequence>
              <s:element minOccurs="0" maxOccurs="unbounded" name="AnnounceList" type="tns:DocAnnounce" />
            </s:sequence>
          </s:extension>
        </s:complexContent>
      </s:complexType>
      <s:complexType name="DocAnnounce">
        <s:complexContent mixed="false">
          <s:extension base="tns:DocSpecification">
            <s:sequence>
              <s:element minOccurs="1" maxOccurs="1" name="AnnounceDate" type="s:dateTime" />
              <s:element minOccurs="0" maxOccurs="1" name="AnnounceTitle" type="s:string" />
              <s:element minOccurs="0" maxOccurs="1" name="AnnounceSnippet" type="s:string" />
              <s:element minOccurs="0" maxOccurs="1" name="AnnounceAnchor" type="s:string" />
            </s:sequence>
          </s:extension>
        </s:complexContent>
      </s:complexType>
      <s:element name="GetDocAttributes">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="ModuleID" type="s:unsignedByte" />
            <s:element minOccurs="1" maxOccurs="1" name="ID" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetDocAttributesResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetDocAttributesResult" type="tns:ExecuteGetDocAttrubutesResponse" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ClearCache">
        <s:complexType />
      </s:element>
      <s:element name="ClearCacheResponse">
        <s:complexType />
      </s:element>
      <s:element name="GetDocumentByType">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="TypeID" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="PageNumber" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetDocumentByTypeResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetDocumentByTypeResult">
              <s:complexType mixed="true">
                <s:sequence>
                  <s:any />
                </s:sequence>
              </s:complexType>
            </s:element>
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetMagHyperlinksTable">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="MagId" type="s:short" />
            <s:element minOccurs="0" maxOccurs="1" name="TimeStamp" type="s:base64Binary" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetMagHyperlinksTableResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetMagHyperlinksTableResult" type="tns:ExecuteGetHyperlinksTableResponse" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ExecuteGetHyperlinksTableResponse">
        <s:complexContent mixed="false">
          <s:extension base="tns:ExecuteResponse">
            <s:sequence>
              <s:element minOccurs="1" maxOccurs="1" name="IsMagFound" type="s:boolean" />
              <s:element minOccurs="1" maxOccurs="1" name="EModified" type="tns:EHyperlinksModified" />
              <s:element minOccurs="0" maxOccurs="1" name="Timestamp" type="s:base64Binary" />
              <s:element minOccurs="0" maxOccurs="unbounded" name="Hyperlinks" type="tns:Hyperlink" />
            </s:sequence>
          </s:extension>
        </s:complexContent>
      </s:complexType>
      <s:simpleType name="EHyperlinksModified">
        <s:restriction base="s:string">
          <s:enumeration value="Unknown" />
          <s:enumeration value="Modified" />
          <s:enumeration value="NotModified" />
        </s:restriction>
      </s:simpleType>
      <s:complexType name="Hyperlink">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="Id" type="s1:guid" />
          <s:element minOccurs="1" maxOccurs="1" name="ModuleTo" type="s:unsignedByte" />
          <s:element minOccurs="1" maxOccurs="1" name="IdTo" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="AnchorTo" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="Title" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:element name="GetMagList">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="MagazineId" type="s:unsignedByte" />
            <s:element minOccurs="1" maxOccurs="1" name="MagazineNumber" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="MagazineDate" type="s:dateTime" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetMagListResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetMagListResult" type="tns:ExecuteGetMagListResponse" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ExecuteGetMagListResponse">
        <s:complexContent mixed="false">
          <s:extension base="tns:ExecuteResponse">
            <s:sequence>
              <s:element minOccurs="1" maxOccurs="1" name="MagId" type="s:short" />
              <s:element minOccurs="0" maxOccurs="1" name="MagazineNumber" type="s:string" />
              <s:element minOccurs="0" maxOccurs="1" name="MagazineMonth" type="s:string" />
              <s:element minOccurs="1" maxOccurs="1" name="IsMagFound" type="s:boolean" />
            </s:sequence>
          </s:extension>
        </s:complexContent>
      </s:complexType>
      <s:element name="GetDocumentPartById">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="ModuleID" type="s:unsignedByte" />
            <s:element minOccurs="1" maxOccurs="1" name="ID" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="PartID" type="s:int" />
            <s:element minOccurs="0" maxOccurs="1" name="HlinkTemplate" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetDocumentPartByIdResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetDocumentPartByIdResult" type="tns:ExecuteGetDocumentPartByIdResponse" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ExecuteGetDocumentPartByIdResponse">
        <s:complexContent mixed="false">
          <s:extension base="tns:ExecuteResponse">
            <s:sequence>
              <s:element minOccurs="1" maxOccurs="1" name="DocExists" type="s:boolean" />
              <s:element minOccurs="1" maxOccurs="1" name="DocPartExists" type="s:boolean" />
              <s:element minOccurs="0" maxOccurs="1" name="Content" type="s:string" />
              <s:element minOccurs="1" maxOccurs="1" name="IsExternalContent" type="s:boolean" />
            </s:sequence>
          </s:extension>
        </s:complexContent>
      </s:complexType>
      <s:element name="GetNpdAnnouncesByIndustryForMonth">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="IndustryKind" type="tns:eIndustryFlags" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetNpdAnnouncesByIndustryForMonthResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetNpdAnnouncesByIndustryForMonthResult" type="tns:ExecuteGetNpdAnnouncesByIndustryForMonthResponse" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetNpdDocumentInfo">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="PubId" type="s:unsignedByte" />
            <s:element minOccurs="1" maxOccurs="1" name="ModuleID" type="s:unsignedByte" />
            <s:element minOccurs="1" maxOccurs="1" name="ID" type="s:int" />
            <s:element minOccurs="0" maxOccurs="1" name="Anchor" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="HlinkTemplate" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetNpdDocumentInfoResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetNpdDocumentInfoResult" type="tns:ExecuteGetNpdDocumentInfoResponse" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ExecuteGetNpdDocumentInfoResponse">
        <s:complexContent mixed="false">
          <s:extension base="tns:ExecuteResponse">
            <s:sequence>
              <s:element minOccurs="1" maxOccurs="1" name="DocExists" type="s:boolean" />
              <s:element minOccurs="1" maxOccurs="1" name="DocActualityStatus" type="tns:TimeMachinePosition" />
              <s:element minOccurs="1" maxOccurs="1" name="DocumentID" type="s:int" />
              <s:element minOccurs="1" maxOccurs="1" name="ModuleID" type="s:unsignedByte" />
              <s:element minOccurs="0" maxOccurs="1" name="Anchor" type="s:string" />
              <s:element minOccurs="0" maxOccurs="1" name="DocumentName" type="s:string" />
              <s:element minOccurs="1" maxOccurs="1" name="PublicationDate" type="s:dateTime" />
              <s:element minOccurs="0" maxOccurs="1" name="Attributes" type="s:string" />
              <s:element minOccurs="1" maxOccurs="1" name="OwnedDocumentCount" type="s:int" />
              <s:element minOccurs="0" maxOccurs="unbounded" name="Lobbies" type="s:string" />
              <s:element minOccurs="0" maxOccurs="unbounded" name="Numbers" type="s:string" />
              <s:element minOccurs="0" maxOccurs="unbounded" name="Types" type="tns:DocumentType" />
              <s:element minOccurs="0" maxOccurs="unbounded" name="Regions" type="s:string" />
              <s:element minOccurs="0" maxOccurs="1" name="Toc" type="s:string" />
              <s:element minOccurs="0" maxOccurs="1" name="TocXml" type="s:string" />
              <s:element minOccurs="1" maxOccurs="1" name="BegDate" nillable="true" type="s:dateTime" />
              <s:element minOccurs="1" maxOccurs="1" name="EndDate" nillable="true" type="s:dateTime" />
              <s:element minOccurs="1" maxOccurs="1" name="ModifyDate" nillable="true" type="s:dateTime" />
              <s:element minOccurs="0" maxOccurs="unbounded" name="AttributeList" type="tns:DocumentAttribute" />
              <s:element minOccurs="0" maxOccurs="unbounded" name="DocumentChain" type="tns:DocumentChainItem" />
              <s:element minOccurs="0" maxOccurs="1" name="OperInfo" type="s:string" />
              <s:element minOccurs="0" maxOccurs="1" name="Attachments" type="tns:ArrayOfAttachment" />
              <s:element minOccurs="0" maxOccurs="1" name="AttachBarcodes" type="tns:ArrayOfAttachBarcode" />
              <s:element minOccurs="0" maxOccurs="1" name="Parts" type="tns:ArrayOfInt" />
              <s:element minOccurs="1" maxOccurs="1" name="AnchoredPart" type="s:int" />
              <s:element minOccurs="1" maxOccurs="1" name="IsActual" type="s:boolean" />
              <s:element minOccurs="1" maxOccurs="1" name="ActualDocId" type="s:int" />
              <s:element minOccurs="1" maxOccurs="1" name="ActualDocModuleId" type="s:int" />
              <s:element minOccurs="1" maxOccurs="1" name="IsDocInActualCheck" type="s:boolean" />
            </s:sequence>
          </s:extension>
        </s:complexContent>
      </s:complexType>
      <s:simpleType name="TimeMachinePosition">
        <s:restriction base="s:string">
          <s:enumeration value="BeforeDocumentBegDate" />
          <s:enumeration value="InsideOfDocumentScope" />
          <s:enumeration value="AfterDocumentEndDate" />
          <s:enumeration value="DocumentDatesAreNotValid" />
        </s:restriction>
      </s:simpleType>
      <s:complexType name="DocumentType">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="ID" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="Name" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="DocumentChainItem">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="ModuleId" type="s:unsignedByte" />
          <s:element minOccurs="1" maxOccurs="1" name="Id" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="StartDate" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="EndDate" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="ArrayOfAttachment">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="Attachment" nillable="true" type="tns:Attachment" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="Attachment">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="Id" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="Name" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="MimeType" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="FormNumber" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="Okud" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="Knd" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="ArrayOfAttachBarcode">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="AttachBarcode" nillable="true" type="tns:AttachBarcode" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="AttachBarcode">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="AttachId" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="Barcode" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="ArrayOfInt">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="int" type="s:int" />
        </s:sequence>
      </s:complexType>
      <s:element name="GetDocTypes">
        <s:complexType />
      </s:element>
      <s:element name="GetDocTypesResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetDocTypesResult" type="tns:ExecuteGetDocTypesResponse" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ExecuteGetDocTypesResponse">
        <s:complexContent mixed="false">
          <s:extension base="tns:ExecuteResponse">
            <s:sequence>
              <s:element minOccurs="0" maxOccurs="unbounded" name="DocType" type="tns:DocumentType" />
            </s:sequence>
          </s:extension>
        </s:complexContent>
      </s:complexType>
      <s:element name="GetHyperlinksTargets">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="LinkGuids" type="tns:ArrayOfGuid" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ArrayOfGuid">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="guid" type="s1:guid" />
        </s:sequence>
      </s:complexType>
      <s:element name="GetHyperlinksTargetsResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetHyperlinksTargetsResult" type="tns:ExecuteGetHyperLinksTargetsResponse" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ExecuteGetHyperLinksTargetsResponse">
        <s:complexContent mixed="false">
          <s:extension base="tns:ExecuteResponse">
            <s:sequence>
              <s:element minOccurs="0" maxOccurs="unbounded" name="LinkTargets" type="tns:DocumentLinkTargetItem" />
            </s:sequence>
          </s:extension>
        </s:complexContent>
      </s:complexType>
      <s:complexType name="DocumentLinkTargetItem">
        <s:complexContent mixed="false">
          <s:extension base="tns:DocumentLinkTarget">
            <s:sequence>
              <s:element minOccurs="1" maxOccurs="1" name="LinkGuid" type="s1:guid" />
              <s:element minOccurs="1" maxOccurs="1" name="LinkStatusId" type="s:unsignedByte" />
            </s:sequence>
          </s:extension>
        </s:complexContent>
      </s:complexType>
      <s:complexType name="DocumentLinkTarget">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="DocumentID" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="ModuleID" type="s:short" />
          <s:element minOccurs="0" maxOccurs="1" name="Anchor" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="IsEmpty" type="s:boolean" />
          <s:element minOccurs="1" maxOccurs="1" name="TargetExists" type="s:boolean" />
          <s:element minOccurs="0" maxOccurs="1" name="AttributesRow" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:element name="GetAnchorsToParts">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="ModuleID" type="s:unsignedByte" />
            <s:element minOccurs="1" maxOccurs="1" name="ID" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetAnchorsToPartsResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetAnchorsToPartsResult" type="tns:ExecuteGetAnchorsToPartsResponse" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ExecuteGetAnchorsToPartsResponse">
        <s:complexContent mixed="false">
          <s:extension base="tns:ExecuteResponse">
            <s:sequence>
              <s:element minOccurs="0" maxOccurs="unbounded" name="AnchorsToPartsList" type="tns:AnchorsToParts" />
            </s:sequence>
          </s:extension>
        </s:complexContent>
      </s:complexType>
      <s:complexType name="AnchorsToParts">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="1" name="AnchorName" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="PartID" type="s:int" />
        </s:sequence>
      </s:complexType>
      <s:element name="GetDocAttributes2">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="ModuleID" type="s:unsignedByte" />
            <s:element minOccurs="1" maxOccurs="1" name="ID" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetDocAttributes2Response">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetDocAttributes2Result" type="tns:ExecuteGetDocAttrubutesResponse2" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ExecuteGetDocAttrubutesResponse2">
        <s:complexContent mixed="false">
          <s:extension base="tns:ExecuteResponse">
            <s:sequence>
              <s:element minOccurs="0" maxOccurs="1" name="PubDate" type="s:string" />
              <s:element minOccurs="0" maxOccurs="1" name="StaticImagesDirPath" type="s:string" />
              <s:element minOccurs="0" maxOccurs="1" name="VersionDate" type="s:string" />
              <s:element minOccurs="0" maxOccurs="1" name="DocStatus" type="s:string" />
              <s:element minOccurs="0" maxOccurs="1" name="FullAttrRow" type="s:string" />
              <s:element minOccurs="0" maxOccurs="unbounded" name="AttributeList" type="tns:DocumentAttribute" />
              <s:element minOccurs="0" maxOccurs="unbounded" name="DocChainList" type="tns:DocChainRow2" />
              <s:element minOccurs="0" maxOccurs="unbounded" name="AttachmentList" type="tns:AttachmentRow" />
            </s:sequence>
          </s:extension>
        </s:complexContent>
      </s:complexType>
      <s:complexType name="DocChainRow2">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="ModuleID" type="s:unsignedByte" />
          <s:element minOccurs="1" maxOccurs="1" name="ID" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="BeginDate" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="EndDate" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="VersionDate" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="DocStatus" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:element name="ExecuteGetDocAttrubutesResponse" nillable="true" type="tns:ExecuteGetDocAttrubutesResponse" />
      <s:element name="ExecuteGetHyperlinksTableResponse" nillable="true" type="tns:ExecuteGetHyperlinksTableResponse" />
      <s:element name="ExecuteGetMagListResponse" nillable="true" type="tns:ExecuteGetMagListResponse" />
      <s:element name="ExecuteGetDocumentPartByIdResponse" nillable="true" type="tns:ExecuteGetDocumentPartByIdResponse" />
      <s:element name="ExecuteGetNpdAnnouncesByIndustryForMonthResponse" nillable="true" type="tns:ExecuteGetNpdAnnouncesByIndustryForMonthResponse" />
      <s:element name="ExecuteGetNpdDocumentInfoResponse" nillable="true" type="tns:ExecuteGetNpdDocumentInfoResponse" />
      <s:element name="ExecuteGetDocTypesResponse" nillable="true" type="tns:ExecuteGetDocTypesResponse" />
      <s:element name="ExecuteGetAnchorsToPartsResponse" nillable="true" type="tns:ExecuteGetAnchorsToPartsResponse" />
      <s:element name="ExecuteGetDocAttrubutesResponse2" nillable="true" type="tns:ExecuteGetDocAttrubutesResponse2" />
    </s:schema>
    <s:schema elementFormDefault="qualified" targetNamespace="http://microsoft.com/wsdl/types/">
      <s:simpleType name="guid">
        <s:restriction base="s:string">
          <s:pattern value="[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}" />
        </s:restriction>
      </s:simpleType>
    </s:schema>
    <s:schema targetNamespace="http://www.1gl.ru/AbstractTypes">
      <s:import namespace="http://schemas.xmlsoap.org/soap/encoding/" />
      <s:complexType name="StringArray">
        <s:complexContent mixed="false">
          <s:restriction base="soapenc:Array">
            <s:sequence>
              <s:element minOccurs="0" maxOccurs="unbounded" name="String" type="s:string" />
            </s:sequence>
          </s:restriction>
        </s:complexContent>
      </s:complexType>
    </s:schema>
  </wsdl:types>
  <wsdl:message name="GetHyperLinkTargetByGuidSoapIn">
    <wsdl:part name="parameters" element="tns:GetHyperLinkTargetByGuid" />
  </wsdl:message>
  <wsdl:message name="GetHyperLinkTargetByGuidSoapOut">
    <wsdl:part name="parameters" element="tns:GetHyperLinkTargetByGuidResponse" />
  </wsdl:message>
  <wsdl:message name="GetNpdAnnouncesForMonthSoapIn">
    <wsdl:part name="parameters" element="tns:GetNpdAnnouncesForMonth" />
  </wsdl:message>
  <wsdl:message name="GetNpdAnnouncesForMonthSoapOut">
    <wsdl:part name="parameters" element="tns:GetNpdAnnouncesForMonthResponse" />
  </wsdl:message>
  <wsdl:message name="GetDocAttributesSoapIn">
    <wsdl:part name="parameters" element="tns:GetDocAttributes" />
  </wsdl:message>
  <wsdl:message name="GetDocAttributesSoapOut">
    <wsdl:part name="parameters" element="tns:GetDocAttributesResponse" />
  </wsdl:message>
  <wsdl:message name="ClearCacheSoapIn">
    <wsdl:part name="parameters" element="tns:ClearCache" />
  </wsdl:message>
  <wsdl:message name="ClearCacheSoapOut">
    <wsdl:part name="parameters" element="tns:ClearCacheResponse" />
  </wsdl:message>
  <wsdl:message name="GetDocumentByTypeSoapIn">
    <wsdl:part name="parameters" element="tns:GetDocumentByType" />
  </wsdl:message>
  <wsdl:message name="GetDocumentByTypeSoapOut">
    <wsdl:part name="parameters" element="tns:GetDocumentByTypeResponse" />
  </wsdl:message>
  <wsdl:message name="GetMagHyperlinksTableSoapIn">
    <wsdl:part name="parameters" element="tns:GetMagHyperlinksTable" />
  </wsdl:message>
  <wsdl:message name="GetMagHyperlinksTableSoapOut">
    <wsdl:part name="parameters" element="tns:GetMagHyperlinksTableResponse" />
  </wsdl:message>
  <wsdl:message name="GetMagListSoapIn">
    <wsdl:part name="parameters" element="tns:GetMagList" />
  </wsdl:message>
  <wsdl:message name="GetMagListSoapOut">
    <wsdl:part name="parameters" element="tns:GetMagListResponse" />
  </wsdl:message>
  <wsdl:message name="GetDocumentPartByIdSoapIn">
    <wsdl:part name="parameters" element="tns:GetDocumentPartById" />
  </wsdl:message>
  <wsdl:message name="GetDocumentPartByIdSoapOut">
    <wsdl:part name="parameters" element="tns:GetDocumentPartByIdResponse" />
  </wsdl:message>
  <wsdl:message name="GetNpdAnnouncesByIndustryForMonthSoapIn">
    <wsdl:part name="parameters" element="tns:GetNpdAnnouncesByIndustryForMonth" />
  </wsdl:message>
  <wsdl:message name="GetNpdAnnouncesByIndustryForMonthSoapOut">
    <wsdl:part name="parameters" element="tns:GetNpdAnnouncesByIndustryForMonthResponse" />
  </wsdl:message>
  <wsdl:message name="GetNpdDocumentInfoSoapIn">
    <wsdl:part name="parameters" element="tns:GetNpdDocumentInfo" />
  </wsdl:message>
  <wsdl:message name="GetNpdDocumentInfoSoapOut">
    <wsdl:part name="parameters" element="tns:GetNpdDocumentInfoResponse" />
  </wsdl:message>
  <wsdl:message name="GetDocTypesSoapIn">
    <wsdl:part name="parameters" element="tns:GetDocTypes" />
  </wsdl:message>
  <wsdl:message name="GetDocTypesSoapOut">
    <wsdl:part name="parameters" element="tns:GetDocTypesResponse" />
  </wsdl:message>
  <wsdl:message name="GetHyperlinksTargetsSoapIn">
    <wsdl:part name="parameters" element="tns:GetHyperlinksTargets" />
  </wsdl:message>
  <wsdl:message name="GetHyperlinksTargetsSoapOut">
    <wsdl:part name="parameters" element="tns:GetHyperlinksTargetsResponse" />
  </wsdl:message>
  <wsdl:message name="GetAnchorsToPartsSoapIn">
    <wsdl:part name="parameters" element="tns:GetAnchorsToParts" />
  </wsdl:message>
  <wsdl:message name="GetAnchorsToPartsSoapOut">
    <wsdl:part name="parameters" element="tns:GetAnchorsToPartsResponse" />
  </wsdl:message>
  <wsdl:message name="GetDocAttributes2SoapIn">
    <wsdl:part name="parameters" element="tns:GetDocAttributes2" />
  </wsdl:message>
  <wsdl:message name="GetDocAttributes2SoapOut">
    <wsdl:part name="parameters" element="tns:GetDocAttributes2Response" />
  </wsdl:message>
  <wsdl:message name="GetDocAttributesHttpGetIn">
    <wsdl:part name="ModuleID" type="s:string" />
    <wsdl:part name="ID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetDocAttributesHttpGetOut">
    <wsdl:part name="Body" element="tns:ExecuteGetDocAttrubutesResponse" />
  </wsdl:message>
  <wsdl:message name="ClearCacheHttpGetIn" />
  <wsdl:message name="ClearCacheHttpGetOut" />
  <wsdl:message name="GetDocumentByTypeHttpGetIn">
    <wsdl:part name="TypeID" type="s:string" />
    <wsdl:part name="PageNumber" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetDocumentByTypeHttpGetOut">
    <wsdl:part name="Body" />
  </wsdl:message>
  <wsdl:message name="GetMagHyperlinksTableHttpGetIn">
    <wsdl:part name="MagId" type="s:string" />
    <wsdl:part name="TimeStamp" type="s2:StringArray" />
  </wsdl:message>
  <wsdl:message name="GetMagHyperlinksTableHttpGetOut">
    <wsdl:part name="Body" element="tns:ExecuteGetHyperlinksTableResponse" />
  </wsdl:message>
  <wsdl:message name="GetMagListHttpGetIn">
    <wsdl:part name="MagazineId" type="s:string" />
    <wsdl:part name="MagazineNumber" type="s:string" />
    <wsdl:part name="MagazineDate" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetMagListHttpGetOut">
    <wsdl:part name="Body" element="tns:ExecuteGetMagListResponse" />
  </wsdl:message>
  <wsdl:message name="GetDocumentPartByIdHttpGetIn">
    <wsdl:part name="ModuleID" type="s:string" />
    <wsdl:part name="ID" type="s:string" />
    <wsdl:part name="PartID" type="s:string" />
    <wsdl:part name="HlinkTemplate" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetDocumentPartByIdHttpGetOut">
    <wsdl:part name="Body" element="tns:ExecuteGetDocumentPartByIdResponse" />
  </wsdl:message>
  <wsdl:message name="GetNpdAnnouncesByIndustryForMonthHttpGetIn">
    <wsdl:part name="IndustryKind" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetNpdAnnouncesByIndustryForMonthHttpGetOut">
    <wsdl:part name="Body" element="tns:ExecuteGetNpdAnnouncesByIndustryForMonthResponse" />
  </wsdl:message>
  <wsdl:message name="GetNpdDocumentInfoHttpGetIn">
    <wsdl:part name="PubId" type="s:string" />
    <wsdl:part name="ModuleID" type="s:string" />
    <wsdl:part name="ID" type="s:string" />
    <wsdl:part name="Anchor" type="s:string" />
    <wsdl:part name="HlinkTemplate" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetNpdDocumentInfoHttpGetOut">
    <wsdl:part name="Body" element="tns:ExecuteGetNpdDocumentInfoResponse" />
  </wsdl:message>
  <wsdl:message name="GetDocTypesHttpGetIn" />
  <wsdl:message name="GetDocTypesHttpGetOut">
    <wsdl:part name="Body" element="tns:ExecuteGetDocTypesResponse" />
  </wsdl:message>
  <wsdl:message name="GetAnchorsToPartsHttpGetIn">
    <wsdl:part name="ModuleID" type="s:string" />
    <wsdl:part name="ID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetAnchorsToPartsHttpGetOut">
    <wsdl:part name="Body" element="tns:ExecuteGetAnchorsToPartsResponse" />
  </wsdl:message>
  <wsdl:message name="GetDocAttributes2HttpGetIn">
    <wsdl:part name="ModuleID" type="s:string" />
    <wsdl:part name="ID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetDocAttributes2HttpGetOut">
    <wsdl:part name="Body" element="tns:ExecuteGetDocAttrubutesResponse2" />
  </wsdl:message>
  <wsdl:message name="GetDocAttributesHttpPostIn">
    <wsdl:part name="ModuleID" type="s:string" />
    <wsdl:part name="ID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetDocAttributesHttpPostOut">
    <wsdl:part name="Body" element="tns:ExecuteGetDocAttrubutesResponse" />
  </wsdl:message>
  <wsdl:message name="ClearCacheHttpPostIn" />
  <wsdl:message name="ClearCacheHttpPostOut" />
  <wsdl:message name="GetDocumentByTypeHttpPostIn">
    <wsdl:part name="TypeID" type="s:string" />
    <wsdl:part name="PageNumber" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetDocumentByTypeHttpPostOut">
    <wsdl:part name="Body" />
  </wsdl:message>
  <wsdl:message name="GetMagHyperlinksTableHttpPostIn">
    <wsdl:part name="MagId" type="s:string" />
    <wsdl:part name="TimeStamp" type="s2:StringArray" />
  </wsdl:message>
  <wsdl:message name="GetMagHyperlinksTableHttpPostOut">
    <wsdl:part name="Body" element="tns:ExecuteGetHyperlinksTableResponse" />
  </wsdl:message>
  <wsdl:message name="GetMagListHttpPostIn">
    <wsdl:part name="MagazineId" type="s:string" />
    <wsdl:part name="MagazineNumber" type="s:string" />
    <wsdl:part name="MagazineDate" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetMagListHttpPostOut">
    <wsdl:part name="Body" element="tns:ExecuteGetMagListResponse" />
  </wsdl:message>
  <wsdl:message name="GetDocumentPartByIdHttpPostIn">
    <wsdl:part name="ModuleID" type="s:string" />
    <wsdl:part name="ID" type="s:string" />
    <wsdl:part name="PartID" type="s:string" />
    <wsdl:part name="HlinkTemplate" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetDocumentPartByIdHttpPostOut">
    <wsdl:part name="Body" element="tns:ExecuteGetDocumentPartByIdResponse" />
  </wsdl:message>
  <wsdl:message name="GetNpdAnnouncesByIndustryForMonthHttpPostIn">
    <wsdl:part name="IndustryKind" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetNpdAnnouncesByIndustryForMonthHttpPostOut">
    <wsdl:part name="Body" element="tns:ExecuteGetNpdAnnouncesByIndustryForMonthResponse" />
  </wsdl:message>
  <wsdl:message name="GetNpdDocumentInfoHttpPostIn">
    <wsdl:part name="PubId" type="s:string" />
    <wsdl:part name="ModuleID" type="s:string" />
    <wsdl:part name="ID" type="s:string" />
    <wsdl:part name="Anchor" type="s:string" />
    <wsdl:part name="HlinkTemplate" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetNpdDocumentInfoHttpPostOut">
    <wsdl:part name="Body" element="tns:ExecuteGetNpdDocumentInfoResponse" />
  </wsdl:message>
  <wsdl:message name="GetDocTypesHttpPostIn" />
  <wsdl:message name="GetDocTypesHttpPostOut">
    <wsdl:part name="Body" element="tns:ExecuteGetDocTypesResponse" />
  </wsdl:message>
  <wsdl:message name="GetAnchorsToPartsHttpPostIn">
    <wsdl:part name="ModuleID" type="s:string" />
    <wsdl:part name="ID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetAnchorsToPartsHttpPostOut">
    <wsdl:part name="Body" element="tns:ExecuteGetAnchorsToPartsResponse" />
  </wsdl:message>
  <wsdl:message name="GetDocAttributes2HttpPostIn">
    <wsdl:part name="ModuleID" type="s:string" />
    <wsdl:part name="ID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetDocAttributes2HttpPostOut">
    <wsdl:part name="Body" element="tns:ExecuteGetDocAttrubutesResponse2" />
  </wsdl:message>
  <wsdl:portType name="BSSExportServiceSoap">
    <wsdl:operation name="GetHyperLinkTargetByGuid">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Информация о  цели гиперссылки</wsdl:documentation>
      <wsdl:input message="tns:GetHyperLinkTargetByGuidSoapIn" />
      <wsdl:output message="tns:GetHyperLinkTargetByGuidSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetNpdAnnouncesForMonth">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Получение списка анонсов за последний месяц по списку изданий</wsdl:documentation>
      <wsdl:input message="tns:GetNpdAnnouncesForMonthSoapIn" />
      <wsdl:output message="tns:GetNpdAnnouncesForMonthSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetDocAttributes">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Получение атрибутов документа</wsdl:documentation>
      <wsdl:input message="tns:GetDocAttributesSoapIn" />
      <wsdl:output message="tns:GetDocAttributesSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="ClearCache">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Очистака кэша</wsdl:documentation>
      <wsdl:input message="tns:ClearCacheSoapIn" />
      <wsdl:output message="tns:ClearCacheSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetDocumentByType">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Возвращает список докуменов по типу</wsdl:documentation>
      <wsdl:input message="tns:GetDocumentByTypeSoapIn" />
      <wsdl:output message="tns:GetDocumentByTypeSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetMagHyperlinksTable">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Проверяет, есть ли обновление гиперссылок по номеру журнала с момента последнего запроса. Если изменение произошло, возвращает таблицу гиперссылок по запрошенному номеру журнала.</wsdl:documentation>
      <wsdl:input message="tns:GetMagHyperlinksTableSoapIn" />
      <wsdl:output message="tns:GetMagHyperlinksTableSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetMagList">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Получение информации о номере журнала</wsdl:documentation>
      <wsdl:input message="tns:GetMagListSoapIn" />
      <wsdl:output message="tns:GetMagListSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetDocumentPartById">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Чтение контента части документа НПД</wsdl:documentation>
      <wsdl:input message="tns:GetDocumentPartByIdSoapIn" />
      <wsdl:output message="tns:GetDocumentPartByIdSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetNpdAnnouncesByIndustryForMonth">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Получение списка анонсов за последний месяц по изданиям</wsdl:documentation>
      <wsdl:input message="tns:GetNpdAnnouncesByIndustryForMonthSoapIn" />
      <wsdl:output message="tns:GetNpdAnnouncesByIndustryForMonthSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetNpdDocumentInfo">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Информация об атрибутах документа НПД и список его частей</wsdl:documentation>
      <wsdl:input message="tns:GetNpdDocumentInfoSoapIn" />
      <wsdl:output message="tns:GetNpdDocumentInfoSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetDocTypes">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Возврщает список типов</wsdl:documentation>
      <wsdl:input message="tns:GetDocTypesSoapIn" />
      <wsdl:output message="tns:GetDocTypesSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetHyperlinksTargets">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Массив целей гиперссылок по массиву токенов ссылок.</wsdl:documentation>
      <wsdl:input message="tns:GetHyperlinksTargetsSoapIn" />
      <wsdl:output message="tns:GetHyperlinksTargetsSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetAnchorsToParts">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Список соответствия частей документа якорям.</wsdl:documentation>
      <wsdl:input message="tns:GetAnchorsToPartsSoapIn" />
      <wsdl:output message="tns:GetAnchorsToPartsSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetDocAttributes2">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Получение атрибутов документа</wsdl:documentation>
      <wsdl:input message="tns:GetDocAttributes2SoapIn" />
      <wsdl:output message="tns:GetDocAttributes2SoapOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:portType name="BSSExportServiceHttpGet">
    <wsdl:operation name="GetDocAttributes">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Получение атрибутов документа</wsdl:documentation>
      <wsdl:input message="tns:GetDocAttributesHttpGetIn" />
      <wsdl:output message="tns:GetDocAttributesHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="ClearCache">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Очистака кэша</wsdl:documentation>
      <wsdl:input message="tns:ClearCacheHttpGetIn" />
      <wsdl:output message="tns:ClearCacheHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetDocumentByType">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Возвращает список докуменов по типу</wsdl:documentation>
      <wsdl:input message="tns:GetDocumentByTypeHttpGetIn" />
      <wsdl:output message="tns:GetDocumentByTypeHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetMagHyperlinksTable">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Проверяет, есть ли обновление гиперссылок по номеру журнала с момента последнего запроса. Если изменение произошло, возвращает таблицу гиперссылок по запрошенному номеру журнала.</wsdl:documentation>
      <wsdl:input message="tns:GetMagHyperlinksTableHttpGetIn" />
      <wsdl:output message="tns:GetMagHyperlinksTableHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetMagList">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Получение информации о номере журнала</wsdl:documentation>
      <wsdl:input message="tns:GetMagListHttpGetIn" />
      <wsdl:output message="tns:GetMagListHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetDocumentPartById">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Чтение контента части документа НПД</wsdl:documentation>
      <wsdl:input message="tns:GetDocumentPartByIdHttpGetIn" />
      <wsdl:output message="tns:GetDocumentPartByIdHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetNpdAnnouncesByIndustryForMonth">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Получение списка анонсов за последний месяц по изданиям</wsdl:documentation>
      <wsdl:input message="tns:GetNpdAnnouncesByIndustryForMonthHttpGetIn" />
      <wsdl:output message="tns:GetNpdAnnouncesByIndustryForMonthHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetNpdDocumentInfo">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Информация об атрибутах документа НПД и список его частей</wsdl:documentation>
      <wsdl:input message="tns:GetNpdDocumentInfoHttpGetIn" />
      <wsdl:output message="tns:GetNpdDocumentInfoHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetDocTypes">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Возврщает список типов</wsdl:documentation>
      <wsdl:input message="tns:GetDocTypesHttpGetIn" />
      <wsdl:output message="tns:GetDocTypesHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetAnchorsToParts">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Список соответствия частей документа якорям.</wsdl:documentation>
      <wsdl:input message="tns:GetAnchorsToPartsHttpGetIn" />
      <wsdl:output message="tns:GetAnchorsToPartsHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetDocAttributes2">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Получение атрибутов документа</wsdl:documentation>
      <wsdl:input message="tns:GetDocAttributes2HttpGetIn" />
      <wsdl:output message="tns:GetDocAttributes2HttpGetOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:portType name="BSSExportServiceHttpPost">
    <wsdl:operation name="GetDocAttributes">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Получение атрибутов документа</wsdl:documentation>
      <wsdl:input message="tns:GetDocAttributesHttpPostIn" />
      <wsdl:output message="tns:GetDocAttributesHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="ClearCache">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Очистака кэша</wsdl:documentation>
      <wsdl:input message="tns:ClearCacheHttpPostIn" />
      <wsdl:output message="tns:ClearCacheHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetDocumentByType">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Возвращает список докуменов по типу</wsdl:documentation>
      <wsdl:input message="tns:GetDocumentByTypeHttpPostIn" />
      <wsdl:output message="tns:GetDocumentByTypeHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetMagHyperlinksTable">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Проверяет, есть ли обновление гиперссылок по номеру журнала с момента последнего запроса. Если изменение произошло, возвращает таблицу гиперссылок по запрошенному номеру журнала.</wsdl:documentation>
      <wsdl:input message="tns:GetMagHyperlinksTableHttpPostIn" />
      <wsdl:output message="tns:GetMagHyperlinksTableHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetMagList">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Получение информации о номере журнала</wsdl:documentation>
      <wsdl:input message="tns:GetMagListHttpPostIn" />
      <wsdl:output message="tns:GetMagListHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetDocumentPartById">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Чтение контента части документа НПД</wsdl:documentation>
      <wsdl:input message="tns:GetDocumentPartByIdHttpPostIn" />
      <wsdl:output message="tns:GetDocumentPartByIdHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetNpdAnnouncesByIndustryForMonth">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Получение списка анонсов за последний месяц по изданиям</wsdl:documentation>
      <wsdl:input message="tns:GetNpdAnnouncesByIndustryForMonthHttpPostIn" />
      <wsdl:output message="tns:GetNpdAnnouncesByIndustryForMonthHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetNpdDocumentInfo">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Информация об атрибутах документа НПД и список его частей</wsdl:documentation>
      <wsdl:input message="tns:GetNpdDocumentInfoHttpPostIn" />
      <wsdl:output message="tns:GetNpdDocumentInfoHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetDocTypes">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Возврщает список типов</wsdl:documentation>
      <wsdl:input message="tns:GetDocTypesHttpPostIn" />
      <wsdl:output message="tns:GetDocTypesHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetAnchorsToParts">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Список соответствия частей документа якорям.</wsdl:documentation>
      <wsdl:input message="tns:GetAnchorsToPartsHttpPostIn" />
      <wsdl:output message="tns:GetAnchorsToPartsHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetDocAttributes2">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Получение атрибутов документа</wsdl:documentation>
      <wsdl:input message="tns:GetDocAttributes2HttpPostIn" />
      <wsdl:output message="tns:GetDocAttributes2HttpPostOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:binding name="BSSExportServiceSoap" type="tns:BSSExportServiceSoap">
    <soap:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="GetHyperLinkTargetByGuid">
      <soap:operation soapAction="http://www.1gl.ru/GetHyperLinkTargetByGuid" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetNpdAnnouncesForMonth">
      <soap:operation soapAction="http://www.1gl.ru/GetNpdAnnouncesForMonth" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetDocAttributes">
      <soap:operation soapAction="http://www.1gl.ru/GetDocAttributes" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ClearCache">
      <soap:operation soapAction="http://www.1gl.ru/ClearCache" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetDocumentByType">
      <soap:operation soapAction="http://www.1gl.ru/GetDocumentByType" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMagHyperlinksTable">
      <soap:operation soapAction="http://www.1gl.ru/GetMagHyperlinksTable" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMagList">
      <soap:operation soapAction="http://www.1gl.ru/GetMagList" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetDocumentPartById">
      <soap:operation soapAction="http://www.1gl.ru/GetDocumentPartById" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetNpdAnnouncesByIndustryForMonth">
      <soap:operation soapAction="http://www.1gl.ru/GetNpdAnnouncesByIndustryForMonth" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetNpdDocumentInfo">
      <soap:operation soapAction="http://www.1gl.ru/GetNpdDocumentInfo" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetDocTypes">
      <soap:operation soapAction="http://www.1gl.ru/GetDocTypes" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetHyperlinksTargets">
      <soap:operation soapAction="http://www.1gl.ru/GetHyperlinksTargets" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetAnchorsToParts">
      <soap:operation soapAction="http://www.1gl.ru/GetAnchorsToParts" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetDocAttributes2">
      <soap:operation soapAction="http://www.1gl.ru/GetDocAttributes2" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="BSSExportServiceSoap12" type="tns:BSSExportServiceSoap">
    <soap12:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="GetHyperLinkTargetByGuid">
      <soap12:operation soapAction="http://www.1gl.ru/GetHyperLinkTargetByGuid" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetNpdAnnouncesForMonth">
      <soap12:operation soapAction="http://www.1gl.ru/GetNpdAnnouncesForMonth" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetDocAttributes">
      <soap12:operation soapAction="http://www.1gl.ru/GetDocAttributes" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ClearCache">
      <soap12:operation soapAction="http://www.1gl.ru/ClearCache" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetDocumentByType">
      <soap12:operation soapAction="http://www.1gl.ru/GetDocumentByType" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMagHyperlinksTable">
      <soap12:operation soapAction="http://www.1gl.ru/GetMagHyperlinksTable" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMagList">
      <soap12:operation soapAction="http://www.1gl.ru/GetMagList" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetDocumentPartById">
      <soap12:operation soapAction="http://www.1gl.ru/GetDocumentPartById" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetNpdAnnouncesByIndustryForMonth">
      <soap12:operation soapAction="http://www.1gl.ru/GetNpdAnnouncesByIndustryForMonth" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetNpdDocumentInfo">
      <soap12:operation soapAction="http://www.1gl.ru/GetNpdDocumentInfo" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetDocTypes">
      <soap12:operation soapAction="http://www.1gl.ru/GetDocTypes" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetHyperlinksTargets">
      <soap12:operation soapAction="http://www.1gl.ru/GetHyperlinksTargets" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetAnchorsToParts">
      <soap12:operation soapAction="http://www.1gl.ru/GetAnchorsToParts" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetDocAttributes2">
      <soap12:operation soapAction="http://www.1gl.ru/GetDocAttributes2" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="BSSExportServiceHttpGet" type="tns:BSSExportServiceHttpGet">
    <http:binding verb="GET" />
    <wsdl:operation name="GetDocAttributes">
      <http:operation location="/GetDocAttributes" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ClearCache">
      <http:operation location="/ClearCache" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output />
    </wsdl:operation>
    <wsdl:operation name="GetDocumentByType">
      <http:operation location="/GetDocumentByType" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:content part="Body" type="text/xml" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMagHyperlinksTable">
      <http:operation location="/GetMagHyperlinksTable" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMagList">
      <http:operation location="/GetMagList" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetDocumentPartById">
      <http:operation location="/GetDocumentPartById" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetNpdAnnouncesByIndustryForMonth">
      <http:operation location="/GetNpdAnnouncesByIndustryForMonth" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetNpdDocumentInfo">
      <http:operation location="/GetNpdDocumentInfo" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetDocTypes">
      <http:operation location="/GetDocTypes" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetAnchorsToParts">
      <http:operation location="/GetAnchorsToParts" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetDocAttributes2">
      <http:operation location="/GetDocAttributes2" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="BSSExportServiceHttpPost" type="tns:BSSExportServiceHttpPost">
    <http:binding verb="POST" />
    <wsdl:operation name="GetDocAttributes">
      <http:operation location="/GetDocAttributes" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ClearCache">
      <http:operation location="/ClearCache" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output />
    </wsdl:operation>
    <wsdl:operation name="GetDocumentByType">
      <http:operation location="/GetDocumentByType" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:content part="Body" type="text/xml" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMagHyperlinksTable">
      <http:operation location="/GetMagHyperlinksTable" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMagList">
      <http:operation location="/GetMagList" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetDocumentPartById">
      <http:operation location="/GetDocumentPartById" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetNpdAnnouncesByIndustryForMonth">
      <http:operation location="/GetNpdAnnouncesByIndustryForMonth" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetNpdDocumentInfo">
      <http:operation location="/GetNpdDocumentInfo" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetDocTypes">
      <http:operation location="/GetDocTypes" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetAnchorsToParts">
      <http:operation location="/GetAnchorsToParts" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetDocAttributes2">
      <http:operation location="/GetDocAttributes2" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:service name="BSSExportService">
    <wsdl:port name="BSSExportServiceSoap" binding="tns:BSSExportServiceSoap">
      <soap:address location="http://bssexport.1gl.ru/BssExportService.asmx" />
    </wsdl:port>
    <wsdl:port name="BSSExportServiceSoap12" binding="tns:BSSExportServiceSoap12">
      <soap12:address location="http://bssexport.1gl.ru/BssExportService.asmx" />
    </wsdl:port>
    <wsdl:port name="BSSExportServiceHttpGet" binding="tns:BSSExportServiceHttpGet">
      <http:address location="http://bssexport.1gl.ru/BssExportService.asmx" />
    </wsdl:port>
    <wsdl:port name="BSSExportServiceHttpPost" binding="tns:BSSExportServiceHttpPost">
      <http:address location="http://bssexport.1gl.ru/BssExportService.asmx" />
    </wsdl:port>
  </wsdl:service>
</wsdl:definitions>