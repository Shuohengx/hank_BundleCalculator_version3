package com.hank.BundleCalculator.hank_BundleCalculator_version3.model;

import java.util.ArrayList;
import java.util.List;

public class FilledOrder {
    private List<FilledOrderItem> filledOrderItems = new ArrayList<>();

    public void addFilledOrderItem(FilledOrderItem filledOrderItem){
        filledOrderItems.add(filledOrderItem);
    }

    public List<FilledOrderItem> getFilledOrderItems() {
        return filledOrderItems;
    }



}