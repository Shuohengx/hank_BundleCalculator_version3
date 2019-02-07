package com.hank.BundleCalculator.hank_BundleCalculator_version3.model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private List<OrderItem> items = new ArrayList<>();

    public void addItem(OrderItem item){
        this.items.add(item);
    }

    public void deleteItem(OrderItem item){
        this.items.remove(item);
    }

    public List<OrderItem> getItems() {
        return items;
    }

}
