package com.sc2.hackathome.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class PagingUtils {
    public PagingUtils() {
    }

    public static Pageable getPageRequest(int page, int size) {
        return PageRequest.of(page, size);
    }
}
