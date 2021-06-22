package com.ws.codingtest.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.ws.codingtest.model.Node;
import com.ws.codingtest.services.RangeValidatorService;

public class ZipRangeValidatorServiceImpl implements RangeValidatorService{

	
	/*
	 * Logic to minimize the ranges required  to represent the same restricions as input
	 */
	@Override
	public  List<Node> processData(List<Node> sortedInputNodes) {

		List<Node> processedList = new ArrayList<Node>();
		if(!sortedInputNodes.isEmpty()) {
			//default add first from sorted results as a pointer for comparison
			processedList.add(sortedInputNodes.get(0));
			for (int i = 1; i < sortedInputNodes.size(); i++) {
				Node tempCur = sortedInputNodes.get(i);
				for (int j = processedList.size() - 1; j >= 0; j--) {
					if (tempCur.getStartCode() - processedList.get(j).getEndCode() <= 1) {
						if (tempCur.getStartCode() - processedList.get(j).getStartCode() >= 0) {
							processedList.get(j).setEndCode(tempCur.getEndCode());
							break;
						} else {
							processedList.remove(j);
						}
					} else {
						processedList.add(tempCur);
						break;
					}
				}
				if(processedList.size() == 0) {
					processedList.add(tempCur);
				}
			}
		}
		return processedList;
	}

}
