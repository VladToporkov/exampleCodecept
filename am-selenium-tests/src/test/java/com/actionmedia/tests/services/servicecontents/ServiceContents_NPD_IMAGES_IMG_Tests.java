package com.actionmedia.tests.services.servicecontents;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.httpclient.HttpStatus;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.UUID;

import static com.actionmedia.autotest.Group.service;
import static com.actionmedia.autotest.Group.serviceContents;
import static java.util.UUID.randomUUID;

/**
 * User: n.tyukavkin
 * Date: 14.10.2014
 * Time: 22:30
 */
public class ServiceContents_NPD_IMAGES_IMG_Tests extends ServiceContentsBaseTest {

    private static final UUID UUID_DEFAULT = randomUUID();
    private static final UUID UUID_NEW = randomUUID();

    @Test(groups = {service, serviceContents}, priority = 0)
    public void add_img_document_npd_test() throws IOException {
        JSONObject json = new JSONObject();
        json.put("filename", IMG_FILE_NAME).put("mimeType", "image/png").put("etag", UUID_DEFAULT).put("data", getFileContent(IMG_FILE));

        report("Тест для проверки добавления png-файла в хранилище npd_images, раздел по-умолчанию");
        report("filename - " + json.get("filename"));
        report("mimeType - " + json.get("mimeType"));
        report("etag - " + json.get("etag"));
        report("data - " + json.get("data"));

        Client client = Client.create();
        WebResource webResource = client.resource(URL + "storage/npd_images");
        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, json.toString());
        postponedAssertEquals(response.getStatus(), HttpStatus.SC_OK, "Ошибка при добавлении файла. Неправильный статус ответа.");
    }

    @Test(groups = {service, serviceContents}, priority = 1)
    public void add_new_version_img_document_test() throws IOException {
        JSONObject json = new JSONObject();
        json.put("filename", IMG_FILE_NAME).put("mimeType", "image/png").put("etag", UUID_NEW).put("data", getFileContent(IMG_FILE));

        report("Тест для проверки добавления новой версии png-файла в хранилище npd_images");
        report("filename - " + json.get("filename"));
        report("mimeType - " + json.get("mimeType"));
        report("etag - " + json.get("etag"));
        report("data - " + json.get("data"));

        Client client = Client.create();
        WebResource webResource = client.resource(URL + "storage/npd_images");
        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, json.toString());
        postponedAssertEquals(response.getStatus(), HttpStatus.SC_OK, "Ошибка при добавлении новой версии файла. Неправильный статус ответа.");
    }

    @Test(groups = {service, serviceContents}, priority = 2)
    public void get_img_document_info_test() throws IOException {
        report("Тест для проверки получения мета-описания png-файла в хранилище npd_images");
        report("filename - " + IMG_FILE_NAME);

        Client client = Client.create();
        WebResource webResource = client.resource(URL + "storage/npd_images/info/" + IMG_FILE_NAME);
        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        postponedAssertEquals(response.getStatus(), HttpStatus.SC_OK, "Ошибка при получении мета-описания файла. Неправильный статус ответа.");

        String stringResponse = response.getEntity(String.class);
        postponedAssertFalse(stringResponse.isEmpty(), "Ошибка при получении мета-описания файла. Пустое мета-описание");

        try {
            JSONArray jsonArray = (JSONArray) new JSONParser().parse(stringResponse);
            for (Object jsonElement : jsonArray) {
                org.json.simple.JSONObject json = (org.json.simple.JSONObject) jsonElement;
                postponedAssertNotNull(json.get("storageFileName"), "Ошибка при получении мета-описания файла. Отсутствует тэг 'storageFileName' в ответном JSON");
                postponedAssertNotNull(json.get("partition"), "Ошибка при получении мета-описания файла. Отсутствует тэг 'partition' в ответном JSON");
                postponedAssertNotNull(json.get("etag"), "Ошибка при получении мета-описания файла. Отсутствует тэг 'etag' в ответном JSON");
                postponedAssertNotNull(json.get("filename"), "Ошибка при получении мета-описания файла. Отсутствует тэг 'filename' в ответном JSON");
                postponedAssertNotNull(json.get("timeCreated"), "Ошибка при получении мета-описания файла. Отсутствует тэг 'timeCreated' в ответном JSON");
                postponedAssertNotNull(json.get("mimeType"), "Ошибка при получении мета-описания файла. Отсутствует тэг 'mimeType' в ответном JSON");
                postponedAssertNotNull(json.get("storage"), "Ошибка при получении мета-описания файла. Отсутствует тэг 'storage' в ответном JSON");
            }
        } catch (ParseException e) {
            fail("JsonParseException occurs", e);
        }
    }

    @Test(groups = {service, serviceContents}, priority = 3)
    public void get_img_document_file_test() throws IOException {
        report("Тест для проверки получения контента последней версии png-файла в хранилище npd_images");
        report("filename - " + IMG_FILE_NAME);

        Client client = Client.create();
        WebResource webResource = client.resource(URL + "storage/npd_images/file/" + IMG_FILE_NAME);
        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        postponedAssertEquals(response.getStatus(), HttpStatus.SC_OK, "Ошибка при получении контента последней версии файла. Неправильный статус ответа.");

        String stringResponse = response.getEntity(String.class);
        postponedAssertFalse(stringResponse.isEmpty(), "Ошибка при получении контента последней версии файла. Пустой файл");
    }

    @Test(groups = {service, serviceContents}, priority = 4)
    public void get_img_document_file_version_test() throws IOException {
        report("Тест для проверки получения контента версии png-файла в хранилище npd_images");
        report("filename - " + IMG_FILE_NAME);
        report("etag - " + UUID_DEFAULT);

        Client client = Client.create();
        WebResource webResource = client.resource(URL + "storage/npd_images/file/" + IMG_FILE_NAME + "/" + UUID_DEFAULT);
        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        postponedAssertEquals(response.getStatus(), HttpStatus.SC_OK, "Ошибка при получении контента версии файла. Неправильный статус ответа.");

        String stringResponse = response.getEntity(String.class);
        postponedAssertFalse(stringResponse.isEmpty(), "Ошибка при получении контента версии файла. Пустой файл");
    }

    @Test(groups = {service, serviceContents}, priority = 5)
    public void get_img_document_not_included_file_version_test() throws IOException {
        UUID uuid = randomUUID();
        report("Тест для проверки получения контента несуществующей версии png-файла в хранилище npd_images");
        report("filename - " + IMG_FILE_NAME);
        report("etag - " + uuid);

        Client client = Client.create();
        WebResource webResource = client.resource(URL + "storage/npd_images/file/" + IMG_FILE_NAME + "/" + uuid);
        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        postponedAssertEquals(response.getStatus(), HttpStatus.SC_NOT_FOUND, "Ошибка при получении контента несуществующей версии файла. Неправильный статус ответа.");
    }

    @Test(groups = {service, serviceContents}, priority = 6)
    public void delete_img_document_file_version_test() throws IOException {
        report("Тест для проверки удаления версии png-файла в хранилище npd_images");
        report("filename - " + IMG_FILE_NAME);
        report("etag - " + UUID_DEFAULT);

        Client client = Client.create();
        WebResource webResource = client.resource(URL + "storage/npd_images/file/" + IMG_FILE_NAME + "/" + UUID_NEW);
        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).delete(ClientResponse.class);
        int statusCode = response.getStatus();
        postponedAssertEquals(statusCode, HttpStatus.SC_OK, "Ошибка при удалении версии файла. Неправильный статус ответа.");
    }

    @Test(groups = {service, serviceContents}, priority = 7)
    public void delete_img_document_file_test() throws IOException {
        report("Тест для проверки удаления png-файла в хранилище npd_images");
        report("filename - " + IMG_FILE_NAME);

        Client client = Client.create();
        WebResource webResource = client.resource(URL + "storage/npd_images/file/" + IMG_FILE_NAME);
        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).delete(ClientResponse.class);
        int statusCode = response.getStatus();
        postponedAssertEquals(statusCode, HttpStatus.SC_OK, "Ошибка при удалении версии файла. Неправильный статус ответа.");
    }

    @AfterClass
    public void delete(){
        Client client = Client.create();
        WebResource webResource = client.resource(URL + "storage/npd_images/file/" + IMG_FILE_NAME);
        webResource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).delete(ClientResponse.class);
    }
}
