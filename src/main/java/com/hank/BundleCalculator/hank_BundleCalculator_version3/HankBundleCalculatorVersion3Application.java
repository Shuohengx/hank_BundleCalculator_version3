package com.hank.BundleCalculator.hank_BundleCalculator_version3;

import com.hank.BundleCalculator.hank_BundleCalculator_version3.Configuration.ConfigLoader;
import com.hank.BundleCalculator.hank_BundleCalculator_version3.Configuration.InputReader;
import com.hank.BundleCalculator.hank_BundleCalculator_version3.model.FilledOrder;
import com.hank.BundleCalculator.hank_BundleCalculator_version3.model.Order;
import com.hank.BundleCalculator.hank_BundleCalculator_version3.service.OrderFiller;
import com.hank.BundleCalculator.hank_BundleCalculator_version3.service.TxtWriter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class HankBundleCalculatorVersion3Application {

	public static void main(String[] args) {
		SpringApplication.run(HankBundleCalculatorVersion3Application.class, args);

		//-----------------------------------------------
		ConfigLoader configLoader = new ConfigLoader();
		InputReader inputReader = new InputReader();
		FilledOrder filledOrder;
		Order order;
		OrderFiller orderFiller = new OrderFiller();
		TxtWriter txtWriter = new TxtWriter();

		//----------------------------------------------Input+Configuration
		configLoader.configLoad("Config_file.txt");

		filledOrder = configLoader.getFilledOrder();
		order = inputReader.inputRead("input_file.txt");

		//-----------------------------
		orderFiller.bundle_num_update(order,filledOrder);


		//Output
		try {
			txtWriter.write("output_file",filledOrder);
		}catch (IOException ex){
			ex.printStackTrace();
		}
	}

}

