package com.sc2.hackathome.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface StorageService {
    Optional<String> store(MultipartFile file);

    Optional<Resource> loadAsResource(String filename);
}
