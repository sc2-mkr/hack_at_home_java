package com.sc2.hackathome.utils;

public final class FileUtils {
    private FileUtils() {
    }

    public static String getExtension(String filename) {
        if (filename.contains("."))
            return filename.substring(filename.lastIndexOf('.') + 1);
        return "";
    }
}
