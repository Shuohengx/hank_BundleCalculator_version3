package com.hank.BundleCalculator.hank_BundleCalculator_version3.service;

import com.hank.BundleCalculator.hank_BundleCalculator_version3.Configuration.ConfigLoader;
import com.hank.BundleCalculator.hank_BundleCalculator_version3.Configuration.InputReader;
import com.hank.BundleCalculator.hank_BundleCalculator_version3.model.FilledOrder;
import com.hank.BundleCalculator.hank_BundleCalculator_version3.model.Order;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class OrderFillerTest {
    private ConfigLoader configLoader;
    private InputReader inputReader;


    private FilledOrder filledOrder;
    private Order order;

    private OrderFiller orderFiller;


    @Before
    public void setUp() {
        configLoader =new ConfigLoader();
        inputReader = new InputReader();
        filledOrder = new FilledOrder();
        order = new Order();
        orderFiller = new OrderFiller();

    }

    @Test
    public void bundle_num_update() {
        configLoader.configLoad("Config_file.txt");

        filledOrder = configLoader.getFilledOrder();
        order = inputReader.inputRead("input_file.txt");
        //-----------------------------
        orderFiller.bundle_num_update(order,filledOrder);




    }
}