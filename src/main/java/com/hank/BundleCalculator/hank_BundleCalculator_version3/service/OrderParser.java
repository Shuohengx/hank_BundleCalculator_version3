package com.hank.BundleCalculator.hank_BundleCalculator_version3.service;

import com.hank.BundleCalculator.hank_BundleCalculator_version3.model.FilledBundle;
import com.hank.BundleCalculator.hank_BundleCalculator_version3.model.FilledOrderItem;

public class OrderParser {

    public String firstLineGet(FilledOrderItem filledOrderItem){
        return filledOrderItem.bundleTotalOrderGet()+" "+filledOrderItem.getMediaType()+" $"+filledOrderItem.totalCostGet();
    }

    public String DetailGet(FilledBundle filledBundle){
        return "   "+filledBundle.getNumberOfBundle()+ " * "+ filledBundle.getBundle().getQuantity()+ " $"+filledBundle.costIndividualGet();
    }

}
