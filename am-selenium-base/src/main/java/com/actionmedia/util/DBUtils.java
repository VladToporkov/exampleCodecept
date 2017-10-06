package com.actionmedia.util;

import com.actionmedia.autotest.spring.SeleniumSettings;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.components.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * User: n.tyukavkin
 * Date: 21.02.14
 * Time: 11:17
 */
public final class DBUtils {

    private static final Logger logger = LoggerFactory.getLogger(TestUtils.class);

    private DBUtils() {
    }

    public static List<EventTask> getEventTask() {
        Properties properties = getDBConnectionProperties();
        String connectionUrl = properties.getProperty("event.db.connection.url");
        String driver = properties.getProperty("event.db.connection.Driver");
        String user = properties.getProperty("event.db.connection.username");
        String password = properties.getProperty("event.db.connection.password");

        Connection connection = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        List<EventTask> eventTaskList = new ArrayList<EventTask>();

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(connectionUrl, user, password);

            String query = "SELECT * FROM TASK_QUEUE_2.t_queue.EVENT";
            statement = connection.prepareStatement(query);
            result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt(1);
                String eventTypeId = result.getString(2);
                String userToken = result.getString(3);
                Date date = result.getDate(4);
                int pubId = result.getInt(5);
                String crmCard = result.getString(6);
                String themeId = result.getString(7);
                int letterNumberInTheme = result.getInt(8);
                String parameters = result.getString(9);
                EventTask eventTask = new EventTask(
                        id,
                        eventTypeId,
                        userToken,
                        date,
                        pubId,
                        crmCard,
                        themeId,
                        letterNumberInTheme,
                        parameters);
                eventTaskList.add(eventTask);
            }
        } catch (Exception e) {
            logger.error("Exception occurs", e);
        } finally {
            if (result != null) try {
                result.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
            if (statement != null) try {
                statement.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
            if (connection != null) try {
                connection.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
        }

        return eventTaskList;
    }

    public static List<UnSubscribeEvent> getUnSubscribeEventList() {
        Properties properties = getDBConnectionProperties();
        String connectionUrl = properties.getProperty("event.db.connection.url");
        String driver = properties.getProperty("event.db.connection.Driver");
        String user = properties.getProperty("event.db.connection.username");
        String password = properties.getProperty("event.db.connection.password");

        Connection connection = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        List<UnSubscribeEvent> eventTaskList = new ArrayList<UnSubscribeEvent>();

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(connectionUrl, user, password);

            String query = "SELECT * FROM TASK_QUEUE_2.t_queue.UNSUBSCRIBES";
            statement = connection.prepareStatement(query);
            result = statement.executeQuery();
            while (result.next()) {
                String userToken = result.getString(1);
                String themeId = result.getString(2);
                int pubId = result.getInt(3);
                Date unSubscribeDate = result.getDate(4);
                UnSubscribeEvent event = new UnSubscribeEvent(userToken, themeId, pubId, unSubscribeDate);
                eventTaskList.add(event);
            }
        } catch (Exception e) {
            logger.error("Exception occurs", e);
        } finally {
            if (result != null) try {
                result.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
            if (statement != null) try {
                statement.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
            if (connection != null) try {
                connection.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
        }
        return eventTaskList;
    }

    public static List<PublicationDocument> getNewPublicationDocument(int pub, SeleniumSettings settings) {
        List<PublicationDocument> videoDocumentWithoutParentList = getVideoParentDocument();

        Properties properties = getDBConnectionProperties();
        String connectionUrl = properties.getProperty("pub.db.connection.url");
        String driver = properties.getProperty("pub.db.connection.Driver");
        String user = properties.getProperty("pub.db.connection.username");
        String password = properties.getProperty("pub.db.connection.password");

        Connection connection = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        List<PublicationDocument> publicationDocumentList = new ArrayList<PublicationDocument>();

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(connectionUrl, user, password);

            long oneDay = new Date().getTime() - 1000 * 60 * 60 * 24;

            if (settings.isRunProduction()) {
                String query = "SELECT * FROM KLM_2.dbo.EditPublik WHERE NOT EXISTS " +
                        "(SELECT * FROM klm_2.dbo.Ep_ArtDoc WHERE (klm_2.dbo.Ep_ArtDoc.ID = KLM_2.dbo.EditPublik.ID AND klm_2.dbo.Ep_ArtDoc.ModuleID = KLM_2.dbo.EditPublik.Module) AND klm_2.dbo.Ep_ArtDoc.isPublished='0')" +
                        "AND Datapublik > (?) AND Pub_Id = (?) AND (DataSource = (?) OR DataSource = (?) OR DataSource = (?))";
                statement = connection.prepareStatement(query);
                java.sql.Date yesterday = new java.sql.Date(oneDay);
                statement.setDate(1, yesterday);
                statement.setInt(2, pub);
                statement.setString(3, "SQLD1");
                statement.setString(4, "SQLD2");
                statement.setString(5, "SQLD3");
            } else if (settings.isRunTbd()) {
                String query = "SELECT * FROM KLM_2.dbo.EditPublik WHERE Datapublik > (?) AND Pub_Id = (?) AND DataSource = (?)";
                statement = connection.prepareStatement(query);
                java.sql.Date yesterday = new java.sql.Date(oneDay);
                statement.setDate(1, yesterday);
                statement.setInt(2, pub);
                statement.setString(3, "SRV17");
            } else if (settings.isRunRT()) {
                String query = "SELECT * FROM KLM_2.dbo.EditPublik WHERE Datapublik > (?) AND Pub_Id = (?) AND DataSource = (?)";
                statement = connection.prepareStatement(query);
                java.sql.Date yesterday = new java.sql.Date(oneDay);
                statement.setDate(1, yesterday);
                statement.setInt(2, pub);
                statement.setString(3, "RT");
            } else {
                String query = "SELECT * FROM KLM_2.dbo.EditPublik WHERE Datapublik > (?) AND Pub_Id = (?) AND DataSource = (?)";
                statement = connection.prepareStatement(query);
                java.sql.Date yesterday = new java.sql.Date(oneDay);
                statement.setDate(1, yesterday);
                statement.setInt(2, pub);
                statement.setString(3, "SRV15");
            }

            result = statement.executeQuery();
            while (result.next()) {
                Date publicationDate = result.getDate(1);
                int moduleId = result.getInt(2);
                int documentId = result.getInt(3);
                String dataSource = result.getString(7);
                int pubId = result.getInt(9);

                PublicationDocument document = new PublicationDocument(
                        publicationDate,
                        moduleId,
                        documentId,
                        dataSource,
                        pubId
                );

                if (moduleId == 145) {
                    if (!isVideoParentDocument(videoDocumentWithoutParentList, documentId)) {
                        publicationDocumentList.add(document);
                    }
                } else {
                    publicationDocumentList.add(document);
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurs", e);
        } finally {
            if (result != null) try {
                result.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
            if (statement != null) try {
                statement.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
            if (connection != null) try {
                connection.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
        }

        return publicationDocumentList;
    }

    private static boolean isVideoParentDocument(List<PublicationDocument> videoDocumentWithoutParentList, int documentId) {
        for (PublicationDocument video : videoDocumentWithoutParentList) {
            if (video.getDocumentId() == documentId) {
                return true;
            }
        }
        return false;
    }

    private static List<PublicationDocument> getVideoParentDocument() {
        Properties properties = getDBConnectionProperties();
        String connectionUrl = properties.getProperty("pub.db.connection.url");
        String driver = properties.getProperty("pub.db.connection.Driver");
        String user = properties.getProperty("pub.db.connection.username");
        String password = properties.getProperty("pub.db.connection.password");

        Connection connection = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        List<PublicationDocument> publicationDocumentList = new ArrayList<PublicationDocument>();

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(connectionUrl, user, password);

            String query = "SELECT ModuleID, ID FROM klm_2.dbo.VideoDoc WHERE klm_2.dbo.VideoDoc.ParentModuleID IS NULL AND klm_2.dbo.VideoDoc.ParentID IS NULL";
            statement = connection.prepareStatement(query);
            result = statement.executeQuery();
            while (result.next()) {
                int moduleId = result.getInt(1);
                int documentId = result.getInt(2);

                PublicationDocument document = new PublicationDocument(
                        moduleId,
                        documentId
                );
                publicationDocumentList.add(document);
            }
        } catch (Exception e) {
            logger.error("Exception occurs", e);
        } finally {
            if (result != null) try {
                result.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
            if (statement != null) try {
                statement.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
            if (connection != null) try {
                connection.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
        }

        return publicationDocumentList;
    }

    public static List<SearchIndexDocument> getSearchIndexDocumentList() {
        Properties properties = getDBConnectionProperties();
        String connectionUrl = properties.getProperty("pub.db.connection.url");
        String driver = properties.getProperty("pub.db.connection.Driver");
        String user = properties.getProperty("pub.db.connection.username");
        String password = properties.getProperty("pub.db.connection.password");

        Connection connection = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        List<SearchIndexDocument> searchIndexDocumentList = new ArrayList<SearchIndexDocument>();

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(connectionUrl, user, password);

            String query = "SELECT * FROM KLM_2.dbo.TestAutoModuleSearch";
            statement = connection.prepareStatement(query);

            result = statement.executeQuery();
            while (result.next()) {
                int pubId = result.getInt(1);
                int pubDivId = result.getInt(2);
                int moduleId = result.getInt(3);
                int id = result.getInt(4);
                int groupId = result.getInt(5);
                String request = result.getString(6);
                String searchTagList = result.getString(7);

                SearchIndexDocument document = new SearchIndexDocument(
                        pubId,
                        pubDivId,
                        moduleId,
                        id,
                        groupId,
                        request,
                        searchTagList
                );
                searchIndexDocumentList.add(document);
            }
        } catch (Exception e) {
            logger.error("Exception occurs", e);
        } finally {
            if (result != null) try {
                result.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
            if (statement != null) try {
                statement.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
            if (connection != null) try {
                connection.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
        }
        return searchIndexDocumentList;
    }

    public static List<Document> getDocumentList() {
        Properties properties = getDBConnectionProperties();
        String connectionUrl = properties.getProperty("pub.db.connection.url");
        String driver = properties.getProperty("pub.db.connection.Driver");
        String user = properties.getProperty("pub.db.connection.username");
        String password = properties.getProperty("pub.db.connection.password");

        Connection connection = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        List<Document> documentList = new ArrayList<Document>();

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(connectionUrl, user, password);

            String query = "SELECT * FROM KLM_2.dbo.DocPublickLnk_IgnoreList";
            statement = connection.prepareStatement(query);

            result = statement.executeQuery();
            while (result.next()) {
                int moduleId = result.getInt(4);
                int id = result.getInt(5);
                Document document = new Document(moduleId, id);
                documentList.add(document);
            }
        } catch (Exception e) {
            logger.error("Exception occurs", e);
        } finally {
            if (result != null) try {
                result.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
            if (statement != null) try {
                statement.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
            if (connection != null) try {
                connection.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
        }
        return documentList;
    }

    public static List<Document> getReplicationsDocs(SeleniumSettings settings) {
        Properties properties = getDBConnectionProperties();
        String connectionUrl = null;
        String driver = properties.getProperty("reduplication.srv17.connection.Driver");
        String user = properties.getProperty("reduplication.connection.username");
        String password = properties.getProperty("reduplication.connection.password");

        Connection connection = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        List<Document> documentList = new ArrayList<Document>();

        if (settings.isRunProduction()) {
            connectionUrl = properties.getProperty("reduplication.sqld3.connection.url");
        } else if (settings.isRunRT()) {
            connectionUrl = properties.getProperty("reduplication.srv17.connection.url");
        }

        if (connectionUrl == null) {
            throw new IllegalArgumentException("Адрес базы данных не задан");
        }

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(connectionUrl, user, password);

            String query = "SELECT TOP 1000 * FROM CONTENT_NPD_RU.dbo.Zamena WHERE Modulefrom = 99";
            statement = connection.prepareStatement(query);

            result = statement.executeQuery();
            while (result.next()) {
                int moduleId = result.getInt("Modulefrom");
                int id = result.getInt("IDfrom");
                Document document = new Document(moduleId, id);
                if (!documentList.contains(document)) {
                    documentList.add(document);
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurs", e);
        } finally {
            if (result != null) try {
                result.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
            if (statement != null) try {
                statement.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
            if (connection != null) try {
                connection.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
        }
        return documentList;
    }

    public static List<String> getModuleIdListByPubDibId(String pubDivId, SystemPubs systemPubs) {
        Properties properties = getDBConnectionProperties();
        String connectionUrl = properties.getProperty("srv23.connection.url");
        String driver = properties.getProperty("srv23.connection.Driver");
        String user = properties.getProperty("srv23.connection.username");
        String password = properties.getProperty("srv23.connection.password");

        Connection connection = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        List<String> moduleIdList = new ArrayList<String>();

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(connectionUrl, user, password);

            String query = "SELECT ModuleID FROM " + getTableNameBySystemPub(systemPubs) + ".dbo.PubDivModuleLnk WHERE PubDiv_ID = " + pubDivId;
            statement = connection.prepareStatement(query);
            result = statement.executeQuery();
            while (result.next()) {
                moduleIdList.add(result.getString(1));
            }
        } catch (Exception e) {
            logger.error("Exception occurs", e);
        } finally {
            if (result != null) try {
                result.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
            if (statement != null) try {
                statement.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
            if (connection != null) try {
                connection.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
        }

        return moduleIdList;
    }

    private static String getTableNameBySystemPub(SystemPubs systemPubs) {
        String tableName = "";
        switch (systemPubs) {
            case bss:
                tableName = "Search_BSS_KU";
                break;
            case bss_bu:
                tableName = "Search_BSS_BU";
                break;
            case bss_usn:
                tableName = "Search_BSS_MB";
                break;
            case bss_vip:
                tableName = "Search_BSS_LX";
                break;
            case kss:
                tableName = "Search_KSS_KU";
                break;
            case kss_bu:
                tableName = "Search_KSS_KB";
                break;
            case kss_vip:
                tableName = "Search_KSS_KV";
                break;
            case uss:
                tableName = "Search_USS";
                break;
            case uss_vip:
                tableName = "Search_USS_UV";
                break;
            case fss:
                tableName = "Search_FSS";
                break;
        }
        return tableName;
    }

    public static Properties getDBConnectionProperties() {
        Properties properties = new Properties();
        InputStream input = null;
        try {
            input = DBUtils.class.getClassLoader().getResourceAsStream("properties/hibernate.properties");
            properties.load(input);
        } catch (IOException e) {
            logger.error("IOException occurs", e);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    logger.error("IOException occurs", e);
                }
            }
        }
        return properties;
    }

    public static List<Document> getFutureRedactionDocumentsListWithoutDate() {
        Properties properties = getDBConnectionProperties();
        String connectionUrl = properties.getProperty("content.ku2.connection.url");
        String driver = properties.getProperty("content.ku2.connection.Driver");
        String user = properties.getProperty("content.ku2.connection.username");
        String password = properties.getProperty("content.ku2.connection.password");

        Connection connection = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        List<Document> documentList = new ArrayList<Document>();

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(connectionUrl, user, password);
            //TODO change for to other system: KSS - CONTENT_KSS, USS - CONTENT_USS, FSS - CONTENT_FSS, MCFR - CONTENT_MCFR
            String query = "SELECT TOP 10 [ModuleID], [ID]\n" +
                    "FROM [CONTENT_BSS].[dbo].[CommonTitles]\n" +
                    "WITH(NOLOCK)\n" +
                    "WHERE \n" +
                    "    ModuleID IN (99,97,81,96)\n" +
                    "    AND DocStatusID = 13\n" +
                    "    AND BegDate IS NULL\n" +
                    "    AND IsDocInActualCheck = 0\n" +
                    "ORDER BY ID DESC";
            statement = connection.prepareStatement(query);

            result = statement.executeQuery();
            while (result.next()) {
                int moduleId = result.getInt(1);
                int id = result.getInt(2);
                Document document = new Document(moduleId, id);
                documentList.add(document);
            }
        } catch (Exception e) {
            logger.error("Exception occurs", e);
        } finally {
            if (result != null) try {
                result.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
            if (statement != null) try {
                statement.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
            if (connection != null) try {
                connection.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
        }
        return documentList;
    }

    public static List<Document> getFutureRedactionDocumentsList() {
        Properties properties = getDBConnectionProperties();
        String connectionUrl = properties.getProperty("content.ku2.connection.url");
        String driver = properties.getProperty("content.ku2.connection.Driver");
        String user = properties.getProperty("content.ku2.connection.username");
        String password = properties.getProperty("content.ku2.connection.password");

        Connection connection = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        List<Document> documentList = new ArrayList<Document>();

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(connectionUrl, user, password);
            //TODO change for to other system: KSS - CONTENT_KSS, USS - CONTENT_USS, FSS - CONTENT_FSS, MCFR - CONTENT_MCFR
            String query = "SELECT TOP 10 [ModuleID], [ID]\n" +
                    "FROM [CONTENT_BSS].[dbo].[CommonTitles]\n" +
                    "WITH(NOLOCK)\n" +
                    "WHERE \n" +
                    "    ModuleID IN (99,97,81,96)\n" +
                    "    AND BegDate IS NOT NULL\n" +
                    "    AND DocStatusID = 13\n" +
                    "ORDER BY BegDate DESC";
            statement = connection.prepareStatement(query);

            result = statement.executeQuery();
            while (result.next()) {
                int moduleId = result.getInt(1);
                int id = result.getInt(2);
                Document document = new Document(moduleId, id);
                documentList.add(document);
            }
        } catch (Exception e) {
            logger.error("Exception occurs", e);
        } finally {
            if (result != null) try {
                result.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
            if (statement != null) try {
                statement.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
            if (connection != null) try {
                connection.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
        }
        return documentList;
    }

    public static Document getActualRedactionForDocument(int docModuleId, int docId) {
        Properties properties = getDBConnectionProperties();
        String driver = properties.getProperty("reduplication.srv17.connection.Driver");
        String connectionUrl = properties.getProperty("reduplication.sqld3.connection.url");
        String user = properties.getProperty("reduplication.connection.username");
        String password = properties.getProperty("reduplication.connection.password");

        Connection connection = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(connectionUrl, user, password);

            String query = "USE CONTENT_BSS\n" +
                    "\n" +
                    "DECLARE @module TINYINT = " + docModuleId + ";\n" +
                    "DECLARE @id INT = " + docId + ";\n" +
                    "DECLARE @GroupID INT;\n" +
                    "DECLARE @Today smalldatetime = getdate();\n" +
                    "\n" +
                    "SELECT @GroupID = ct.GroupID\n" +
                    "FROM dbo.CommonTitles AS ct\n" +
                    "WHERE ct.ModuleID=@module AND ct.ID=@id\n" +
                    "\n" +
                    "SELECT ModuleID, ID\n" +
                    "FROM [dbo].[CommonTitles] ct\n" +
                    "WHERE ct.GroupID = @GroupID AND\n" +
                    "((ct.IsDocInActualCheck = 0 AND ct.DocStatusIsActive = 1) OR\n" +
                    "(ct.IsDocInActualCheck IN (1,2) AND @Today BETWEEN ct.BegDate AND ISNULL(ct.EndDate, @Today+1)))";

            statement = connection.prepareStatement(query);

            result = statement.executeQuery();
            while (result.next()) {
                int moduleId = result.getInt(1);
                int id = result.getInt(2);
                return new Document(moduleId, id);
            }
        } catch (Exception e) {
            logger.error("Exception occurs", e);
        } finally {
            if (result != null) try {
                result.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
            if (statement != null) try {
                statement.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
            if (connection != null) try {
                connection.close();
            } catch (Exception e) {
                logger.error("Exception occurs", e);
            }
        }
        return null;
    }
}
