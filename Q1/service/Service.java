	package com.learning.Q1.service;
	
	import java.util.ArrayList;
	import java.util.Comparator;
	import java.util.List;
	import java.util.Scanner;
	import java.util.Stack;
	import java.util.stream.Collectors;
	
	public class Service {
		
		private static Scanner sc= new Scanner(System.in);
	     public void displayFloorPerDay(int[] floorsize) {
	    	 
	    	 Stack<Integer> sizeListStk= new Stack<Integer>();
	    	 int nextFloorSize= floorsize.length;
	    	 for(int i=0,day=i+1;i<floorsize.length;i++,day++) {
	    	     sizeListStk.push(floorsize[i]);
	    		 System.out.println("\nDay : " + day + "\n");
	    		 if(nextFloorSize==floorsize[i]) {
	    	     	 List<Integer> tempArr = new ArrayList<>();
	                 while(!sizeListStk.isEmpty()) {
	                	  tempArr.add(sizeListStk.pop());
	                 }
	                 List<Integer> tempArrSortDesc= tempArr.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	                 int j=0;
	                 if(tempArrSortDesc.size()>1) {
	                   for (j=0;j<tempArrSortDesc.size()-1;j++)
	                	   //checking if reverse sorted elements are sequential with diff of 1
	                 	 if(tempArrSortDesc.get(j)-tempArrSortDesc.get(j+1)==1) {
	                 	  	 nextFloorSize=tempArrSortDesc.get(j+1) - 1;
	                 	 } else {
	                 		nextFloorSize=tempArrSortDesc.get(j) - 1;
	                 	    break;
	                    }
	                   for (int k=j+1;k<tempArrSortDesc.size();k++) {
	                	 //Pushing remaining element again
	                	 sizeListStk.push(tempArrSortDesc.get(k));
	                   }
	                 } else {
	                	 nextFloorSize = tempArrSortDesc.get(j)-1;            
	                 }
	                 tempArrSortDesc.stream().limit(j+1).forEach(s-> System.out.print(" " + s));
	    		 }
	    	 }
	     }
	}
