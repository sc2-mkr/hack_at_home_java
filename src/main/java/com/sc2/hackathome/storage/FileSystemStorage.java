package com.sc2.hackathome.storage;

import com.sc2.hackathome.utils.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.UUID;

@Service
public class FileSystemStorage implements StorageService {

    @Value("${uploadfile.basepath}")
    private String basePath;

    private final ResourceLoader resourceLoader;

    public FileSystemStorage(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public Optional<String> store(MultipartFile file) {
        if (file.isEmpty()) return Optional.empty();

        String fileExtension = FileUtils.getExtension(file.getOriginalFilename());
        if (!fileExtension.isEmpty()) fileExtension = "." + fileExtension;

        String filename = UUID.randomUUID() + fileExtension;
        Path path = FileUtils.getAbsolutePath(basePath + filename);
        try {
            Files.createDirectories(path.getParent());
            Files.write(path, file.getBytes());
        } catch (IOException e) {
            throw new StorageException("Storing file failed with exception: ", e);
        }

        return Optional.of(filename);
    }

    @Override
    public Optional<Resource> loadAsResource(String filename) {
        String uri = FileUtils.getAbsolutePath(basePath + filename).toUri().toString();
        Resource resource = resourceLoader.getResource(uri);
        return resource.exists() ? Optional.of(resource) : Optional.empty();
    }
}
