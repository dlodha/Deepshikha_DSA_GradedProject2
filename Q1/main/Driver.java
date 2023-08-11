	package com.learning.Q1.main;
	
	import java.util.Arrays;
	import java.util.Scanner;
	import java.util.stream.IntStream;

import com.learning.Q1.Exception.InvalidInputException;
import com.learning.Q1.service.Service;
	
	public class Driver {
		private static Scanner sc= new Scanner(System.in);
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			 System.out.println("Enter number on floors");
			 int noFloor= getUserInput();
			 int[] floorSize = new int[noFloor];
			 try {
			  	 for(int i=0;i<noFloor;i++) {
					 System.out.println("Enter floor size on current Day:" + (i+1));
					 int currInput = getUserInput();
					 if(Arrays.stream(floorSize).anyMatch(s-> s!=0 && s==currInput) ) {
			   			 throw new InvalidInputException("Invalid Input, please input (D)istinct values");
			   		 }
			   		floorSize[i]= currInput;
			   		if(floorSize[i] > noFloor || floorSize[i] < 1) {
			   			throw new InvalidInputException("Invalid Input, please input in the range of 1 and " + noFloor);
			   		}
			   	 }
				 Service service= new Service();
			  	 service.displayFloorPerDay(floorSize);
			 } catch (InvalidInputException ex) {
				 System.out.println(ex.getMessage());
			 }
		}
		
	    public static int getUserInput() {
	   	 int input= sc.nextInt();
	   	 return input;
	    }
	
	}
