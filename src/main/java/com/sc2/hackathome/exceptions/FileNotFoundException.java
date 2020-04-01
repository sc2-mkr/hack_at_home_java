package com.sc2.hackathome.exceptions;

public class FileNotFoundException extends NotFoundException {
    public FileNotFoundException() {
        super("Could not find requested file");
    }
}
