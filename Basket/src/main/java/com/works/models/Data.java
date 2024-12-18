package com.works.models;

import java.util.List;

@lombok.Data
public class Data {
    private long id;
    private String title;
    private String description;
    private String category;
    private double price;
    private double discountPercentage;
    private double rating;
    private long stock;
    private List<String> tags;
    private String brand;
    private String sku;
    private long minimumOrderQuantity;
    private List<String> images;
}
