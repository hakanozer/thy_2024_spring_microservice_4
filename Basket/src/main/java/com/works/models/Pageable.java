package com.works.models;

@lombok.Data
public class Pageable {
    private long pageNumber;
    private long pageSize;
    private Sort sort;
    private long offset;
    private boolean unpaged;
    private boolean paged;
}
