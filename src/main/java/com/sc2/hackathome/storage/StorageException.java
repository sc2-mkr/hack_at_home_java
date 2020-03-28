package com.sc2.hackathome.storage;

public class StorageException extends RuntimeException {
    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Exception innerException) {
        super(message, innerException);
    }
}
