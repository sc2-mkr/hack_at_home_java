package com.sc2.hackathome.exceptions;

import java.text.MessageFormat;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String name, Object id) {
        super(MessageFormat.format("Could not find {0} with id {1}", name, id));
    }
}