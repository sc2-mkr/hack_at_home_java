package com.sc2.hackathome.utils;

import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;

import javax.activation.MimetypesFileTypeMap;
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
            return resource.getInputStream().readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException("Could not read resource.", e);
        }
    }
}
