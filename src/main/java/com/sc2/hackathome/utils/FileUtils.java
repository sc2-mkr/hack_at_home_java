package com.sc2.hackathome.utils;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class FileUtils {
    private FileUtils() {
    }

    public static String getExtension(String filename) {
        if (filename.contains("."))
            return filename.substring(filename.lastIndexOf('.') + 1);
        return "";
    }

    public static Path getAbsolutePath(String path) {
        return Paths.get(path).toAbsolutePath().normalize();
    }

    public static byte[] toByteArray(Resource resource) {
        try {
            return IOUtils.toByteArray(resource.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException("Could not read resource.", e);
        }
    }
}
