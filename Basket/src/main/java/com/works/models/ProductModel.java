package com.works.models;

import java.util.List;

@lombok.Data
public class ProductModel {
    private List<Content> content;
    private Pageable pageable;
    private long totalPages;
    private long totalElements;
    private boolean last;
    private long size;
    private long number;
    private Sort sort;
    private long numberOfElements;
    private boolean first;
    private boolean empty;
}
