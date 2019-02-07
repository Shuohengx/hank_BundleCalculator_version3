package com.hank.BundleCalculator.hank_BundleCalculator_version3.service;

import com.hank.BundleCalculator.hank_BundleCalculator_version3.model.FilledOrder;
import com.hank.BundleCalculator.hank_BundleCalculator_version3.model.Order;
import com.hank.BundleCalculator.hank_BundleCalculator_version3.model.OrderItem;
import com.hank.BundleCalculator.hank_BundleCalculator_version3.progress.BundleDistributionCalculator;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class OrderFiller {

    public void bundle_num_update(Order order, FilledOrder filledOrder){
        OrderItemFiller orderItemFiller = new OrderItemFiller();
        BundleDistributionCalculator bundleDistributionCalculator = new BundleDistributionCalculator();

        for (OrderItem orderItem:order.getItems()){
            int[] bundleQuantities = orderItemFiller.bundleQuantitiesGet(orderItem,filledOrder);
            int target = orderItem.getQuantityRequired();

            //----------------------------------------
            List<Integer> bundleDistribution = bundleDistributionCalculator.bundleDistributionCalculate(bundleQuantities,target);
            Map<Object, Integer> bundleDistributionMap = new TreeMap<>();
            for (Object k : bundleDistribution) {
                bundleDistributionMap.merge(k, 1, (a, b) -> a + b);
            }
            //---------------------------------------
            orderItemFiller.bundleNumsUpdate(orderItem,filledOrder,bundleDistributionMap);

        }
    }
}
