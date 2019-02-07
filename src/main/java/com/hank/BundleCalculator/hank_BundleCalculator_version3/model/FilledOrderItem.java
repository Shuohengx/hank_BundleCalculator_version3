package com.hank.BundleCalculator.hank_BundleCalculator_version3.model;

import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FilledOrderItem {
    //   private OrderItem orderItem;
    private final List<FilledBundle> filledBundles = new ArrayList<>();
    private final String mediaType;
    private final String mediaId;

    public void bundleAdd(FilledBundle bundle){
        this.filledBundles.add(bundle);
    }

    public FilledOrderItem(String mediaType, String mediaId) {
        this.mediaType = mediaType;
        this.mediaId = mediaId;
    }

    public String getMediaType() {
        return mediaType;
    }

    public String getMediaId() {
        return mediaId;
    }

    public List<FilledBundle> getFilledBundles() {
        return filledBundles;
    }


    public int[] bundleQuantitiesGet(){
        List<Integer> bundleQuantities = new ArrayList<>();
        for(FilledBundle filledBundle:this.filledBundles){
            bundleQuantities.add(filledBundle.bundleQuantityGet());
        }
        return bundleQuantities.stream().mapToInt(i -> i).toArray();
    }

    public void bundleNumUpdate(Map<Object, Integer> bundleDistribution){
        int[] bundleQuantity = this.bundleQuantitiesGet();
        for(Object key:bundleDistribution.keySet()){
            for (int i=0;i<bundleQuantitiesGet().length;i++){
                if (bundleQuantity[i] != (int) key)
                    continue;
                this.getFilledBundles().get(i).setNumberOfBundle(bundleDistribution.get(key));
            }
        }
    }

    public int bundleTotalOrderGet(){
        int sum = 0;
        for(FilledBundle filledBundle:this.getFilledBundles()){
            sum = sum + filledBundle.getNumberOfBundle()*filledBundle.getBundle().getQuantity();
        }
        return sum;
    }

    public double totalCostGet(){
        double cost = 0;
        for(FilledBundle filledBundle:this.getFilledBundles()){
            cost = cost + filledBundle.getNumberOfBundle()*filledBundle.getBundle().getCost();
        }
        return cost;
    }
}
