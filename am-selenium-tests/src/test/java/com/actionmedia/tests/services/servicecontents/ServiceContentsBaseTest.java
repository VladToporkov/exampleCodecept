package com.actionmedia.tests.services.servicecontents;

import com.actionmedia.base.AbstractServicesTest;
import org.apache.commons.io.FileUtils;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.IOException;

import static java.util.UUID.randomUUID;

/**
 * User: n.tyukavkin
 * Date: 14.10.2014
 * Time: 22:30
 */
public class ServiceContentsBaseTest extends AbstractServicesTest {

    protected static final String URL = "http://storage.1gl.ru/";

    protected static final String RESOURCES = "/service/";

    protected static final String TXT_FILE = "test_txt.txt";
    protected static final String TXT_FILE_VERSION = "test_version_txt.txt";
    protected static final String IMG_FILE = "test_img.png";

    protected static final String TXT_FILE_NAME = randomUUID() + TXT_FILE;
    protected static final String IMG_FILE_NAME = randomUUID() + IMG_FILE;

    protected String getFileContent(String fileName) {
        File file = new File(ServiceContentsBaseTest.class.getResource(RESOURCES + fileName).getFile());
        try {
            final byte[] byteArray = FileUtils.readFileToByteArray(file);
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(byteArray);
        } catch (IOException e) {
            logger.error("IOException occurs", e);
        }

        return null;
    }
}
