package com.hank.BundleCalculator.hank_BundleCalculator_version3.model;

public class OrderItem {
    private final String MediaType;
    private final int quantityRequired;


    public OrderItem(String MediaType, int quantityRequired){
        this.MediaType = MediaType;
        this.quantityRequired = quantityRequired;
    }

    public String getMediaType() {
        return MediaType;
    }

    public int getQuantityRequired() {
        return quantityRequired;
    }
}
