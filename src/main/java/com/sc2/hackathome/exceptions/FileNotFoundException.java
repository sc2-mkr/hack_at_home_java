package com.sc2.hackathome.exceptions;

import java.text.MessageFormat;

public class FileNotFoundException extends NotFoundException {
    public FileNotFoundException() {
        super("Could not find requested file");
    }
}
