package util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileUtil {

    private static String TEMP_DIR = "temp";

    private static void makeTempDir() {
        new File(TEMP_DIR).mkdir();
    }

    public static String addFile(String name, String extension, byte[] data) throws IOException {

        makeTempDir();

        File file = new File(TEMP_DIR, name + "." + extension);

        FileUtils.writeByteArrayToFile(file, data);

        return file.getAbsolutePath();

    }

}
