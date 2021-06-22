package com.ws.codingtest.model;

public class Node {
	private int startCode;
	private int endCode;
	
	public Node(int start, int end){
		//setting the range by the order
		if(start>end) {
			startCode = end;
			endCode = start;
		} 
		else {
			startCode = start;
			endCode = end;
		}
	}
	
	public void setStartCode(int startCode) {
		this.startCode = startCode;
	}

	public void setEndCode(int endCode) {
		this.endCode = endCode;
	}



	public int getStartCode() {
		return startCode;
	}

	public int getEndCode() {
		return endCode;
	}

	@Override
	public String toString() {
		return "[" + this.startCode + " " + this.endCode + "]";
	}
}
