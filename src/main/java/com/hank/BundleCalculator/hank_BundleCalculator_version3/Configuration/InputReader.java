package com.hank.BundleCalculator.hank_BundleCalculator_version3.Configuration;

import com.hank.BundleCalculator.hank_BundleCalculator_version3.model.Order;
import com.hank.BundleCalculator.hank_BundleCalculator_version3.model.OrderItem;
import com.hank.BundleCalculator.hank_BundleCalculator_version3.util.ContentsReader;

import java.util.ArrayList;
import java.util.List;

public class InputReader {
    private List<OrderItem> orderItems = new ArrayList<>();

    //----------------读取输入信息----------------------//

    public Order inputRead(String filename){
        Order order = new Order();
        ContentsReader contentsReader = new ContentsReader();

        for (String content:contentsReader.contentsRead(filename)){
            if(content!=null){
                String[] inputData = content.split(" ");
                String MediaType = inputData[1];
                int quantityRequired = Integer.parseInt(inputData[0]);
                order.addItem(new OrderItem(MediaType,quantityRequired));
            }
        }
        return order;
    }

}