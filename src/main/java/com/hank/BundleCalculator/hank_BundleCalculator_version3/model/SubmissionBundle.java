package com.hank.BundleCalculator.hank_BundleCalculator_version3.model;

import lombok.Data;

@Data
public class SubmissionBundle {
    private final int quantity;
    private final double cost;

    public SubmissionBundle(int quantity, double cost) {
        this.quantity = quantity;
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getCost() {
        return cost;
    }
}


