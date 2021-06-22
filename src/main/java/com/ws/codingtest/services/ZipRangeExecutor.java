package com.ws.codingtest.services;

import java.util.List;

import com.ws.codingtest.model.Node;
import com.ws.codingtest.services.impl.ZipRangeValidatorServiceImpl;

public class ZipRangeExecutor {
	
	// Execution starts here (main method)
	public static void main(String[] args) {
		//intialize respective Validator services zip/price any
		RangeValidatorService validatorService = new ZipRangeValidatorServiceImpl();
		List<Node> r = validatorService.processData(validatorService.validateAndReadNodes());
		System.out.println("Minimized output Zip range :"+ r);
	}
}
