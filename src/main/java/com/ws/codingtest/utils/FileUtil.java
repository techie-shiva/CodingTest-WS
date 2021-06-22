package com.ws.codingtest.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ws.codingtest.model.Node;

public class FileUtil {
	/*
	 * Used this method to read restricted range data from CSV file 
	 */
	public static List<Node> readCSVDataToNode(String filename){
		List<Node> result = new ArrayList<Node>();
		try {
			URL source = FileUtil.class.getResource(filename);
			File file = new File(source.getPath());
			result = Files.readAllLines(Paths.get(file.getPath()))
					.stream()
					.map(line -> convertToNode(line))
					.filter(line -> line != null && filterLine(line, 9999, 999999))
					.collect(Collectors.toList());
			System.out.println("Input restricted range data :"+result);
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Could not load the csv file to load values");
		}
		return result;
	}
	
	//Filtering the length of zipcode from CSV file , We can change the filtering accordingly
	private static boolean filterLine(Node line, int min, int max) {
		boolean isSuccess = false;
		if(line.getStartCode()>min && line.getEndCode()<max) {
			isSuccess = true;
		}
		return isSuccess;
	}

	
	private static Node convertToNode(String line) {
		String[] nums = line != null ? line.split(",") : null;
		//make sure you have both startCode and endCode passed in the input
		if(nums != null && nums.length ==2) {			
			Node node = new Node(Integer.parseInt(nums[0]),Integer.parseInt(nums[1]));
			return node;
		} else  {
			System.out.println("invalid range: "+ line);
			return null;
		}
	}
	
}
