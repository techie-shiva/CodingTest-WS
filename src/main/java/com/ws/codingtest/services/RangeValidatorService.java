package com.ws.codingtest.services;

import java.util.Collections;
import java.util.List;

import com.ws.codingtest.model.Node;
import com.ws.codingtest.utils.FileUtil;

public interface RangeValidatorService {
	
	
	default List<Node> validateAndReadNodes() {
		
		List<Node> result = FileUtil.readCSVDataToNode("/RestrictedZipCodeRanges.csv");
		// sort list by comparing range1's start and range2's end
		Collections.sort(result, (r1, r2) -> r1.getStartCode() - r2.getEndCode());
		// System.out.println("sorted List : "+result);
		return result;
	}

	abstract List<Node> processData(List<Node> inputRanges);
}
