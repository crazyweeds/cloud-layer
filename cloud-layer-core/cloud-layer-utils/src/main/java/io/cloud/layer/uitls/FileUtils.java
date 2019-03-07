package io.cloud.layer.uitls;

import java.io.File;

/**
 * todo 未完善
 * test see {@link java.io.cloud.layer.FileUtisTest}
 * @author RippleChan
 * @date 2019-03-07 00:28
 */
public class FileUtils {

    /**
     * demo see {@link java.io.cloud.layer.FileUtisTest#getFilesTest()}
     * @param path
     * @return
     */
    public static File[] getFiles(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        return files;
    }

    public static String getFilesNames(String path) {
        File[] files = getFiles(path);
        File file = files[0];
        String name = file.getName();
        return name;
    }

}
