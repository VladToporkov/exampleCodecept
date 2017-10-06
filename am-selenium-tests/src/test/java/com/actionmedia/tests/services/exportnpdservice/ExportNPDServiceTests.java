package com.actionmedia.tests.services.exportnpdservice;

import com.actionmedia.base.AbstractServicesTest;
import com.actionmedia.components.Document;
import com.actionmedia.util.DBUtils;
import com.actionmedia.util.TestUtils;
import com.actionmedia.webservice.exportnpdservice.*;
import org.apache.axis.types.UnsignedByte;
import org.testng.annotations.Test;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.actionmedia.autotest.Group.npd;
import static com.actionmedia.autotest.Group.service;

/**
 * User: n.tyukavkin
 * Date: 03.03.14
 * Time: 15:52
 */
public class ExportNPDServiceTests extends AbstractServicesTest {

    /**
     * Налоговый кодекс РФ Часть первая
     */
    public static final UnsignedByte MODULE_ID = new UnsignedByte(99);
    public static final int DOC_ID = 901919946;

    @Test(groups = {service, npd})
    public void getAnchorsToPartsTest() {
        report("Тест для проверки метода 'GetAnchorsToParts'.");
        report("ModuleId - " + MODULE_ID);
        report("DocId - " + DOC_ID);

        try {
            ExecuteGetAnchorsToPartsResponse response = getExportNPDService().getAnchorsToParts(MODULE_ID, DOC_ID);
            AnchorsToParts[] anchorsToPartsList = response.getAnchorsToPartsList();

            postponedAssertTrue(anchorsToPartsList != null && anchorsToPartsList.length > 0, "Неправильный ответ для метода 'GetAnchorsToParts'. Список значений пустой.");
            if (anchorsToPartsList != null && anchorsToPartsList.length > 0) {
                postponedAssertFalse(anchorsToPartsList[0].getAnchorName().isEmpty(), "Неправильный ответ для метода 'GetAnchorsToParts'. Отсутствует значение для AnchorsToPartsList >> AnchorName");
                checkIntValue(anchorsToPartsList[0].getPartID(), "Неправильный ответ для метода 'GetAnchorsToParts'. Отсутствует значение для AnchorsToPartsList >> PartID");
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        } catch (NullPointerException e) {
            fail("NullPointerException occurs ", e);
        }
    }

    @Test(groups = {service, npd})
    public void getDocAttributesTest() {
        report("Тест для проверки метода 'GetDocAttributes'.");
        report("ModuleId - " + MODULE_ID);
        report("DocId - " + DOC_ID);

        try {
            ExecuteGetDocAttrubutesResponse response = getExportNPDService().getDocAttributes(MODULE_ID, DOC_ID);

            postponedAssertFalse(response.getPubDate().isEmpty(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для PubDate");
            postponedAssertNotNull(response.getStaticImagesDirPath(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для StaticImagesDirPath");
            postponedAssertFalse(response.getVersionDate().isEmpty(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для VersionDate");
            postponedAssertNotNull(response.getFullAttrRow(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для FullAttrRow");

            postponedAssertTrue(response.getAttributeList() != null && response.getAttributeList().length > 0, "Неправильный ответ для метода 'GetDocAttributes'. Список значений 'AttributeList' пустой.");
            postponedAssertTrue(response.getDocChainList() != null && response.getDocChainList().length > 0, "Неправильный ответ для метода 'GetDocAttributes'. Список значений 'DocChainList' пустой.");
            postponedAssertTrue(response.getAttachmentList() != null && response.getAttachmentList().length > 0, "Неправильный ответ для метода 'GetDocAttributes'. Список значений 'AttachmentList' пустой.");

            if (response.getAttributeList() != null && response.getAttributeList().length > 0) {
                DocumentAttribute firstAttributeTag = response.getAttributeList(0);
                postponedAssertFalse(firstAttributeTag.getName().isEmpty(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для AttributeList >> Name");
                postponedAssertFalse(firstAttributeTag.getValue().isEmpty(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для AttributeList >> Value");
            }

            if (response.getDocChainList() != null && response.getDocChainList().length > 0) {
                DocChainRow firstDocChainTag = response.getDocChainList(0);
                postponedAssertNotNull(firstDocChainTag.getModuleID(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для DocChainList >> ModuleID");
                checkIntValue(firstDocChainTag.getID(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для DocChainList >> ID");
                postponedAssertFalse(firstDocChainTag.getBeginDate().isEmpty(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для DocChainList >> BeginDate");
                postponedAssertFalse(firstDocChainTag.getEndDate().isEmpty(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для DocChainList >> EndDate");
            }

            if (response.getAttachmentList() != null && response.getAttachmentList().length > 0) {
                AttachmentRow firstAttachmentTag = response.getAttachmentList(0);
                postponedAssertFalse(firstAttachmentTag.getArtName().isEmpty(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для AttachmentList >> ArtName");
                postponedAssertFalse(firstAttachmentTag.getArtUrl().isEmpty(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для AttachmentList >> ArtUrl");
                postponedAssertNotNull(firstAttachmentTag.getModuleID(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для AttachmentList >> ModuleID");
                checkIntValue(firstAttachmentTag.getID(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для AttachmentList >> ID");
                postponedAssertFalse(firstAttachmentTag.getMimeType().isEmpty(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для AttachmentList >> MimeType");
                postponedAssertNotNull(firstAttachmentTag.getFormNumber(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для AttachmentList >> FormNumber");
                postponedAssertNotNull(firstAttachmentTag.getOKUD(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для AttachmentList >> OKUD");
                postponedAssertNotNull(firstAttachmentTag.getKND(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для AttachmentList >> KND");
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        } catch (NullPointerException e) {
            fail("NullPointerException occurs ", e);
        }
    }

    @Test(groups = {service, npd})
    public void getDocAttributes2Test() {
        report("Тест для проверки метода 'GetDocAttributes2'.");
        report("ModuleId - " + MODULE_ID);
        report("DocId - " + DOC_ID);

        try {
            ExecuteGetDocAttrubutesResponse2 response = getExportNPDService().getDocAttributes2(MODULE_ID, DOC_ID);

            postponedAssertFalse(response.getPubDate().isEmpty(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для PubDate");
            postponedAssertNotNull(response.getStaticImagesDirPath(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для StaticImagesDirPath");
            postponedAssertFalse(response.getVersionDate().isEmpty(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для VersionDate");
            postponedAssertFalse(response.getDocStatus().isEmpty(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для VersionDate");
            postponedAssertNotNull(response.getFullAttrRow(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для FullAttrRow");

            postponedAssertTrue(response.getAttributeList() != null && response.getAttributeList().length > 0, "Неправильный ответ для метода 'GetDocAttributes'. Список значений 'AttributeList' пустой.");
            postponedAssertTrue(response.getDocChainList() != null && response.getDocChainList().length > 0, "Неправильный ответ для метода 'GetDocAttributes'. Список значений 'DocChainList' пустой.");
            postponedAssertTrue(response.getAttachmentList() != null && response.getAttachmentList().length > 0, "Неправильный ответ для метода 'GetDocAttributes'. Список значений 'AttachmentList' пустой.");

            if (response.getAttributeList() != null && response.getAttributeList().length > 0) {
                DocumentAttribute firstDocumentAttributeTag = response.getAttributeList(0);
                postponedAssertFalse(firstDocumentAttributeTag.getName().isEmpty(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для AttributeList >> Name");
                postponedAssertFalse(firstDocumentAttributeTag.getValue().isEmpty(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для AttributeList >> Value");
            }

            if (response.getDocChainList() != null && response.getDocChainList().length > 0) {
                DocChainRow2 firstDocChainTag = response.getDocChainList(0);
                postponedAssertNotNull(firstDocChainTag.getModuleID(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для DocChainList >> ModuleID");
                checkIntValue(firstDocChainTag.getID(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для DocChainList >> ID");
                if (!getSettings().isRunProduction()) {
                    postponedAssertFalse(firstDocChainTag.getDocStatus().isEmpty(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для DocChainList >> DocStatus");
                }
                postponedAssertFalse(firstDocChainTag.getBeginDate().isEmpty(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для DocChainList >> BeginDate");
                if (getSettings().isRunProduction() && (!firstDocChainTag.getDocStatus().equals("Actual") && !firstDocChainTag.getDocStatus().equals("ActualInFuture"))) {
                    postponedAssertFalse(firstDocChainTag.getEndDate().isEmpty(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для DocChainList >> EndDate");
                }
            }

            if (response.getAttachmentList() != null && response.getAttachmentList().length > 0) {
                AttachmentRow firstAttachmentTag = response.getAttachmentList(0);
                postponedAssertFalse(firstAttachmentTag.getArtName().isEmpty(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для AttachmentList >> ArtName");
                postponedAssertFalse(firstAttachmentTag.getArtUrl().isEmpty(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для AttachmentList >> ArtUrl");
                postponedAssertNotNull(firstAttachmentTag.getModuleID(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для AttachmentList >> ModuleID");
                checkIntValue(firstAttachmentTag.getID(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для AttachmentList >> ID");
                postponedAssertFalse(firstAttachmentTag.getMimeType().isEmpty(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для AttachmentList >> MimeType");
                postponedAssertNotNull(firstAttachmentTag.getFormNumber(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для AttachmentList >> FormNumber");
                postponedAssertNotNull(firstAttachmentTag.getOKUD(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для AttachmentList >> OKUD");
                postponedAssertNotNull(firstAttachmentTag.getKND(), "Неправильный ответ для метода 'GetDocAttributes'. Отсутствует значение для AttachmentList >> KND");
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        } catch (NullPointerException e) {
            fail("NullPointerException occurs ", e);
        }
    }

    @Test(groups = {service, npd})
    public void getDocumentPartByIdTest() {
        short partId = 0;
        String hlinkTemplate = "/npd/{mod}/{id}/{anc}?type=template_demo&amp;id=1116549861";

        report("Тест для проверки метода 'GetDocumentPartById'.");
        report("ModuleId - " + MODULE_ID);
        report("DocId - " + DOC_ID);
        report("PartId - " + partId);
        report("HlinkTemplate - " + hlinkTemplate);

        try {
            ExecuteGetDocumentPartByIdResponse response = getExportNPDService().getDocumentPartById(MODULE_ID, DOC_ID, partId, hlinkTemplate);
            checkBooleanValue(response.isDocExists(), "Неправильный ответ для метода 'GetDocumentPartById'. Отсутствует значение для DocExists");
            checkBooleanValue(response.isDocPartExists(), "Неправильный ответ для метода 'GetDocumentPartById'. Отсутствует значение для DocPartExists");
            postponedAssertFalse(response.getContent().isEmpty(), "Неправильный ответ для метода 'GetDocumentPartById'. Отсутствует значение для Content");
            checkBooleanValue(response.isIsExternalContent(), "Неправильный ответ для метода 'GetDocumentPartById'. Отсутствует значение для IsExternalContent");
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        } catch (NullPointerException e) {
            fail("NullPointerException occurs ", e);
        }
    }

    @Test(groups = {service, npd})
    public void getHyperLinkTargetByGuidTest() {
        String guid = "1fe7eab6-23b9-4c59-b46c-b9bb6dc41fe0";

        report("Тест для проверки метода 'GetHyperLinkTargetByGuid'.");
        report("ModuleId - " + MODULE_ID);
        report("DocId - " + DOC_ID);
        report("guid - " + guid);

        try {
            ExecuteGetHyperLinkTargetByGuidResponse response = getExportNPDService().getHyperLinkTargetByGuid(guid);

            checkIntValue(response.getDocumentID(), "Неправильный ответ для метода 'GetHyperLinkTargetByGuid'. Отсутствует значение для DocumentID");
            checkIntValue(response.getModuleID(), "Неправильный ответ для метода 'GetHyperLinkTargetByGuid'. Отсутствует значение для ModuleID");
            checkBooleanValue(response.isTargetExists(), "Неправильный ответ для метода 'GetHyperLinkTargetByGuid'. Отсутствует значение для TargetExists");

            if (response.getAnchor() != null) {
                postponedAssertFalse(response.getAnchor().isEmpty(), "Неправильный ответ для метода 'GetHyperLinkTargetByGuid'. Отсутствует значение для Anchor");
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        } catch (NullPointerException e) {
            fail("NullPointerException occurs ", e);
        }
    }

    @Test(groups = {service, npd})
    public void getHyperlinksTargetsTest() {
        String[] guid = new String[]{"14296e3a-b1e4-4cb1-b2b1-2154b8d74a56", "a2673176-ca1a-47ed-a222-dff85e5aa4e6", "a0af7f12-9bf5-4648-b9aa-8f6f78c73633"};

        report("Тест для проверки метода 'GetHyperlinksTargets'.");
        report("ModuleId - " + MODULE_ID);
        report("DocId - " + DOC_ID);
        report("guid - " + convertArrayToString(guid));

        try {
            ExecuteGetHyperLinksTargetsResponse response = getExportNPDService().getHyperlinksTargets(guid);

            postponedAssertTrue(response.getLinkTargets() != null && response.getLinkTargets().length > 0, "Неправильный ответ для метода 'GetHyperlinksTargets'. Список значений 'LinkTargets' пустой.");
            if (response.getLinkTargets().length > 0) {
                DocumentLinkTargetItem documentLinkTargetItem = response.getLinkTargets()[0];

                postponedAssertNotNull(documentLinkTargetItem.getDocumentID(), "Неправильный ответ для метода 'GetHyperlinksTargets'. Отсутствует значение для LinkTargets >> DocumentID");
                postponedAssertNotNull(documentLinkTargetItem.getModuleID(), "Неправильный ответ для метода 'GetHyperlinksTargets'. Отсутствует значение для LinkTargets >> ModuleID");
                postponedAssertNotNull(documentLinkTargetItem.isIsEmpty(), "Неправильный ответ для метода 'GetHyperlinksTargets'. Отсутствует значение для LinkTargets >> IsEmpty");
                postponedAssertNotNull(documentLinkTargetItem.isTargetExists(), "Неправильный ответ для метода 'GetHyperlinksTargets'. Отсутствует значение для LinkTargets >> TargetExists");
                postponedAssertNotNull(documentLinkTargetItem.getLinkGuid(), "Неправильный ответ для метода 'GetHyperlinksTargets'. Отсутствует значение для LinkTargets >> LinkGuid");
                postponedAssertNotNull(documentLinkTargetItem.getLinkStatusId(), "Неправильный ответ для метода 'GetHyperlinksTargets'. Отсутствует значение для LinkTargets >> LinkStatusId");
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        } catch (NullPointerException e) {
            fail("NullPointerException occurs ", e);
        }
    }

    @Test(groups = {service, npd})
    public void getMagHyperlinksTableTest() {
        short magId = 1101;

        report("Тест для проверки метода 'GetMagHyperlinksTable'.");
        report("MagId - " + magId);

        try {
            ExecuteGetHyperlinksTableResponse response = getExportNPDService().getMagHyperlinksTable(magId, null);

            checkBooleanValue(response.isIsMagFound(), "Неправильный ответ для метода 'GetMagHyperlinksTable'. Отсутствует значение для IsMagFound");
            postponedAssertFalse(response.getEModified().getValue().isEmpty(), "Неправильный ответ для метода 'GetMagHyperlinksTable'. Отсутствует значение для EModified");
            postponedAssertTrue(response.getTimestamp().length > 0, "Неправильный ответ для метода 'GetMagHyperlinksTable'. Отсутствует значение для Timestamp");

            postponedAssertTrue(response.getHyperlinks() != null && response.getHyperlinks().length > 0, "Неправильный ответ для метода 'GetMagHyperlinksTable'. Список значений Hyperlinks пустой");

            if (response.getHyperlinks().length > 0) {
                postponedAssertFalse(response.getHyperlinks()[0].getId().isEmpty(), "Неправильный ответ для метода 'GetMagHyperlinksTable'. Отсутствует значение для Hyperlinks >> Id");
                postponedAssertFalse(response.getHyperlinks()[0].getModuleTo().toString().isEmpty(), "Неправильный ответ для метода 'GetMagHyperlinksTable'. Отсутствует значение для Hyperlinks >> ModuleTo");
                checkIntValue(response.getHyperlinks()[0].getIdTo(), "Неправильный ответ для метода 'GetMagHyperlinksTable'. Отсутствует значение для Hyperlinks >> IdTo");
                postponedAssertNotNull(response.getHyperlinks()[0].getTitle(), "Неправильный ответ для метода 'GetMagHyperlinksTable'. Отсутствует значение для Hyperlinks >> Title");
            }

        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        } catch (NullPointerException e) {
            fail("NullPointerException occurs ", e);
        }
    }

    @Test(groups = {service, npd})
    public void getMagListTest() {
        UnsignedByte magId = new UnsignedByte(1);
        int magNumber = 2;
        Date date = TestUtils.parseDate("2015-01-01", "yyyy-MM-dd");
        Calendar magazineDate = Calendar.getInstance();
        magazineDate.setTime(date);

        report("Тест для проверки метода 'GetMagList'.");
        report("MagId - " + magId);
        report("MagNumber - " + magNumber);
        report("MagazineDate - " + magazineDate.getTime().toString());

        try {
            ExecuteGetMagListResponse response = getExportNPDService().getMagList(magId, magNumber, magazineDate);

            checkIntValue(response.getMagId(), "Неправильный ответ для метода 'GetMagList'. Отсутствует значение для MagId");
            postponedAssertFalse(response.getMagazineNumber().isEmpty(), "Неправильный ответ для метода 'GetMagList'. Отсутствует значение для MagazineNumber");
            postponedAssertFalse(response.getMagazineMonth().isEmpty(), "Неправильный ответ для метода 'GetMagList'. Отсутствует значение для MagazineMonth");
            checkBooleanValue(response.isIsMagFound(), "Неправильный ответ для метода 'GetMagList'. Отсутствует значение для IsMagFound");
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        } catch (NullPointerException e) {
            fail("NullPointerException occurs ", e);
        }
    }

    @Test(groups = {service, npd})
    public void getNpdAnnouncesByIndustryForMonthTest() {
        report("Тест для проверки метода 'GetNpdAnnouncesByIndustryForMonth'.");

        try {
            ExecuteGetNpdAnnouncesByIndustryForMonthResponse response = getExportNPDService().getNpdAnnouncesByIndustryForMonth(new String[]{"Commerce"});

            postponedAssertTrue(response.getAnnounceList() != null && response.getAnnounceList().length > 0, "Неправильный ответ для метода 'GetNpdAnnouncesByIndustryForMonth'. Список значений AnnounceList пустой");
            if (response.getAnnounceList().length > 0) {
                postponedAssertNotNull(response.getAnnounceList()[0].getModuleID(), "Неправильный ответ для метода 'GetNpdAnnouncesByIndustryForMonth'. Отсутствует значение для ModuleID");
                postponedAssertNotNull(response.getAnnounceList()[0].getID(), "Неправильный ответ для метода 'GetNpdAnnouncesByIndustryForMonth'. Отсутствует значение для ID");
                postponedAssertNotNull(response.getAnnounceList()[0].getAnnounceDate(), "Неправильный ответ для метода 'GetNpdAnnouncesByIndustryForMonth'. Отсутствует значение для AnnounceDate");
                postponedAssertFalse(response.getAnnounceList()[0].getAnnounceTitle().isEmpty(), "Неправильный ответ для метода 'GetNpdAnnouncesByIndustryForMonth'. Отсутствует значение для AnnounceTitle");
                postponedAssertFalse(response.getAnnounceList()[0].getAnnounceSnippet().isEmpty(), "Неправильный ответ для метода 'GetNpdAnnouncesByIndustryForMonth'. Отсутствует значение для AnnounceSnippet");
                postponedAssertNotNull(response.getAnnounceList()[0].getAnnounceAnchor(), "Неправильный ответ для метода 'GetNpdAnnouncesByIndustryForMonth'. Отсутствует значение для AnnounceAnchor");
                postponedAssertNotNull(response.getAnnounceList()[0].getIndustryFlags(), "Неправильный ответ для метода 'GetNpdAnnouncesByIndustryForMonth'. Отсутствует значение для IndustryFlags");
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }

    @Test(groups = {service, npd})
    public void getNpdDocumentInfoTest() {
        UnsignedByte pubId = new UnsignedByte(6);
        String anchor = "ZA00M5Q2MK";
        String hlinkTemplate = "/npd/{mod}/{id}/{anc}?type=template_demo&amp;id=1116549861";

        report("Тест для проверки метода 'GetNpdDocumentInfo'.");
        report("PubId - " + pubId);
        report("ModuleId - " + MODULE_ID);
        report("DocId - " + DOC_ID);
        report("Anchor - " + anchor);
        report("HlinkTemplate - " + hlinkTemplate);

        try {
            ExecuteGetNpdDocumentInfoResponse response = getExportNPDService().getNpdDocumentInfo(pubId, MODULE_ID, DOC_ID, anchor, hlinkTemplate);

            checkBooleanValue(response.isDocExists(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для DocExists");
            postponedAssertFalse(response.getDocActualityStatus().getValue().isEmpty(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для DocActualityStatus");
            checkIntValue(response.getDocumentID(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для DocumentID");
            postponedAssertNotNull(response.getModuleID(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для ModuleID");
            postponedAssertFalse(response.getDocumentName() != null && response.getDocumentName().isEmpty(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для DocumentName");
            postponedAssertNotNull(response.getPublicationDate(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для PublicationDate");
            postponedAssertNotNull(response.getAttributes(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для Attributes");
            checkIntValue(response.getOwnedDocumentCount(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для OwnedDocumentCount");
            postponedAssertNotNull(response.getLobbies(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для Lobbies");
            postponedAssertNotNull(response.getNumbers(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для Numbers");
            postponedAssertNotNull(response.getTypes(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для Types");
            postponedAssertFalse(response.getToc() != null && response.getToc().isEmpty(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для Toc");
            postponedAssertFalse(response.getTocXml() != null && response.getTocXml().isEmpty(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для TocXml");
            postponedAssertNotNull(response.getBegDate(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для  BegDate");
//TODO NT: comment by http://rm.1gl.ru/issues/71197
//            postponedAssertNotNull(response.getModifyDate(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для ModifyDate");
            postponedAssertTrue(response.getAttributeList() != null && response.getAttributeList().length > 0, "Неправильный ответ для метода 'GetNpdDocumentInfo'. Список значений для AttributeList пустой");
            postponedAssertFalse(response.getOperInfo() != null && response.getOperInfo().isEmpty(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для OperInfo");
            postponedAssertTrue(response.getAttachments() != null && response.getAttachments().length > 0, "Неправильный ответ для метода 'GetNpdDocumentInfo'. Список значений для Attachment пустой");
            postponedAssertNotNull(response.getAttachBarcodes(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Список значений для AttachBarcodes пустой");
            postponedAssertTrue(response.getParts() != null && response.getParts().length > 0, "Неправильный ответ для метода 'GetNpdDocumentInfo'. Список значений для Parts пустой");
            checkIntValue(response.getAnchoredPart(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для AnchoredPart");
            checkBooleanValue(response.isIsActual(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для IsActual");
            checkIntValue(response.getActualDocId(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для ActualDocId");
            checkIntValue(response.getActualDocModuleId(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для ActualDocModuleId");
            checkBooleanValue(response.isIsDocInActualCheck(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для IsDocInActualCheck");

            if (response.getRegions() != null) {
                postponedAssertTrue(response.getRegions().length > 0, "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для Regions");
            }

            if (response.getAttributeList() != null && response.getAttributeList().length > 0) {
                postponedAssertFalse(response.getAttributeList()[0].getName().isEmpty(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для AttributeList >> Name");
                postponedAssertFalse(response.getAttributeList()[0].getValue().isEmpty(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для AttributeList >> Value");
            }

            if (response.getDocumentChain() != null && response.getDocumentChain().length > 0) {
                postponedAssertNotNull(response.getDocumentChain()[0].getModuleId(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для DocumentChain >> ModuleId");
                postponedAssertNotNull(response.getDocumentChain()[0].getId(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для DocumentChain >> Id");
                postponedAssertFalse(response.getDocumentChain()[0].getStartDate().isEmpty(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для DocumentChain >> StartDate");
                postponedAssertFalse(response.getDocumentChain()[0].getEndDate().isEmpty(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для DocumentChain >> EndDate");
            }

            if (response.getAttachments() != null && response.getAttachments().length > 0) {
                checkIntValue(response.getAttachments()[0].getId(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для Attachment >> Id");
                postponedAssertFalse(response.getAttachments()[0].getName().isEmpty(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для Attachment >> Name");
                postponedAssertFalse(response.getAttachments()[0].getMimeType().isEmpty(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для Attachment >> MimeType");
                postponedAssertNotNull(response.getAttachments()[0].getFormNumber(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для Attachment >> FormNumber");
                postponedAssertNotNull(response.getAttachments()[0].getOkud(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для Attachment >> Okud");
                postponedAssertNotNull(response.getAttachments()[0].getKnd(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для Attachment >> Knd");
            }

            if (response.getAttachBarcodes() != null && response.getAttachBarcodes().length > 0) {
                checkIntValue(response.getAttachBarcodes()[0].getAttachId(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для AttachBarcodes >> AttachBarcode >> AttachId");
                postponedAssertFalse(response.getAttachBarcodes()[0].getBarcode().isEmpty(), "Неправильный ответ для метода 'GetNpdDocumentInfo'. Отсутствует значение для AttachBarcodes >> AttachBarcode >> Barcode");
            }

            if (response.getParts() != null && response.getParts().length > 0) {
                checkIntValue(response.getParts()[0], "Parts >> int");
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        } catch (NullPointerException e) {
            fail("NullPointerException occurs ", e);
        }
    }

    @Test(groups = {service, npd})
    public void getNpdAnnouncesForMonthTest() {
        report("Тест для проверки метода 'GetNpdAnnouncesForMonth'.");

        UnsignedByte[] pubIdList = new UnsignedByte[]{new UnsignedByte(6), new UnsignedByte(11)};
        try {
            ExecuteGetNpdAnnouncesForMonthResponse response = getExportNPDService().getNpdAnnouncesForMonth(pubIdList);

            postponedAssertTrue(response.getAnnounceList() != null && response.getAnnounceList().length > 0, "Неправильный ответ для метода 'GetNpdAnnouncesForMonth'. Список значений AnnounceList пустой");
            if (response.getAnnounceList().length > 0) {
                postponedAssertNotNull(response.getAnnounceList()[0].getModuleID(), "Неправильный ответ для метода 'GetNpdAnnouncesByIndustryForMonth'. Отсутствует значение для ModuleID");
                postponedAssertNotNull(response.getAnnounceList()[0].getID(), "Неправильный ответ для метода 'GetNpdAnnouncesByIndustryForMonth'. Отсутствует значение для ID");
                postponedAssertNotNull(response.getAnnounceList()[0].getAnnounceDate(), "Неправильный ответ для метода 'GetNpdAnnouncesByIndustryForMonth'. Отсутствует значение для AnnounceDate");
                postponedAssertFalse(response.getAnnounceList()[0].getAnnounceTitle().isEmpty(), "Неправильный ответ для метода 'GetNpdAnnouncesByIndustryForMonth'. Отсутствует значение для AnnounceTitle");
                postponedAssertFalse(response.getAnnounceList()[0].getAnnounceSnippet().isEmpty(), "Неправильный ответ для метода 'GetNpdAnnouncesByIndustryForMonth'. Отсутствует значение для AnnounceSnippet");
                postponedAssertNotNull(response.getAnnounceList()[0].getAnnounceAnchor(), "Неправильный ответ для метода 'GetNpdAnnouncesByIndustryForMonth'. Отсутствует значение для AnnounceAnchor");
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }

    @Test(groups = {service, npd})
    public void reduplication_docs_test() {
        report("Тест для проверки редуплицированных документов");
        List<Document> documentList = DBUtils.getReplicationsDocs(getSettings());

        assertFalse(documentList.isEmpty(), "Список редуплицированных документов пуст.");
        for (Document document : documentList) {
            short partId = 1;

            try {
                ExecuteGetDocumentPartByIdResponse response = getExportNPDService().getDocumentPartById(new UnsignedByte(document.getModuleId()), document.getDocumentId(), partId, null);
                String content = response.getContent();
                postponedAssertNotNull(content, "Ошибка при проверке документа moduleId = " + document.getModuleId() + ", docId = " + document.getDocumentId() + ". Тэг 'Content' пустой");
                if (content != null) {
                    postponedAssertFalse(content.isEmpty(), "Неправильный ответ для метода 'GetDocumentPartById'. Отсутствует значение для Content");
                }
            } catch (RemoteException e) {
                setPostponedTestFail("Ошибка при проверке документа moduleId = " + document.getModuleId() + ", docId = " + document.getDocumentId() + ". " + e.getMessage());
            } catch (NullPointerException e) {
                setPostponedTestFail("Ошибка при проверке документа moduleId = " + document.getModuleId() + ", docId = " + document.getDocumentId() + ". " + e.getMessage());
            }
        }
    }

    private void checkIntValue(int value, String errorMessage) {
        try {
            Integer.valueOf(value);
        } catch (NumberFormatException e) {
            setPostponedTestFail(errorMessage);
        } catch (NullPointerException e) {
            setPostponedTestFail(errorMessage);
        }
    }

    private void checkBooleanValue(boolean value, String errorMessage) {
        try {
            Boolean.valueOf(value);
        } catch (NumberFormatException e) {
            setPostponedTestFail(errorMessage);
        } catch (NullPointerException e) {
            setPostponedTestFail(errorMessage);
        }
    }
}
