package com.hank.BundleCalculator.hank_BundleCalculator_version3.Configuration;

import com.hank.BundleCalculator.hank_BundleCalculator_version3.model.FilledBundle;
import com.hank.BundleCalculator.hank_BundleCalculator_version3.model.FilledOrderItem;
import org.junit.Before;
import org.junit.Test;

public class ConfigLoaderTest {
    private ConfigLoader configLoader;



    @Before
    public void setUp() throws Exception {
        configLoader = new ConfigLoader();


    }

    @Test
    public void configLoad() {

        configLoader.configLoad("Config_file.txt");

        System.out.println(configLoader.getFilledOrder().getFilledOrderItems().size());
        for (FilledOrderItem filledOrderItem :configLoader.getFilledOrder().getFilledOrderItems()){
            System.out.println(filledOrderItem.getMediaId() + filledOrderItem.getMediaType());
            for (FilledBundle filledBundle:filledOrderItem.getFilledBundles())
                System.out.println(filledBundle.getBundle().getCost()+"  "+filledBundle.getBundle().getQuantity());
        }




    }
}