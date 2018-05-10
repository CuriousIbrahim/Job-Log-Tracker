package util;

import java.io.File;

public class FileUtil {

    private static String TEMP_DIR = "/temp";

    private static void makeTempDir() {
        new File(TEMP_DIR).mkdir();
    }

}
