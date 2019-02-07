package com.hank.BundleCalculator.hank_BundleCalculator_version3.service;

import com.hank.BundleCalculator.hank_BundleCalculator_version3.model.FilledBundle;
import com.hank.BundleCalculator.hank_BundleCalculator_version3.model.FilledOrder;
import com.hank.BundleCalculator.hank_BundleCalculator_version3.model.FilledOrderItem;

import java.io.*;

public class TxtWriter {


    public void write(String filename, FilledOrder filledOrder) throws IOException {
        OrderParser orderParser = new OrderParser();
        try(Writer writer = new FileWriter(new File(filename+".txt")))
        {
            try(BufferedWriter bw = new BufferedWriter(writer))
            {
                for (FilledOrderItem filledOrderItem:filledOrder.getFilledOrderItems()){
                    bw.write(orderParser.firstLineGet(filledOrderItem));
                    bw.newLine();

                    for(FilledBundle filledBundle:filledOrderItem.getFilledBundles()){
                        if (filledBundle.getNumberOfBundle()==0)
                            continue;
                        bw.write(orderParser.DetailGet(filledBundle));
                        bw.newLine();
                    }
                }
            }
        }
    }
}
