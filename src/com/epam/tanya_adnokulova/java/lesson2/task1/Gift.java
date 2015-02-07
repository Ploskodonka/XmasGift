package com.epam.tanya_adnokulova.java.lesson2.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gift {
	private List<Candy> candyList = new ArrayList<Candy>();
	
	public void addCandy(Candy candy) {
		candyList.add(candy);
	}
	
	public void showGift() {
		if (candyList.isEmpty()) {
			System.out.println("There's no candies yet!");
			return;
		}
		System.out.println("The gift contains:");
		for (Candy i : candyList) 
			System.out.println(i.toString());
	}
	
	public double getTotalWeight() {
		double totalWeight = 0.0;
		for(Candy i : candyList)
			totalWeight += i.getWeight();
		return totalWeight;
	}
	
	public void sortByWeight() {
		Collections.sort(candyList, new WeightComparator());
	}
	
	public void findByName(String name) {
		System.out.println("The search result for candy name '" + name + "':");
		for(Candy i : candyList) {
			if (i.getName().equals(name)) 
				System.out.println(i.getName() + " " + i.getType() + " " + i.getColor() + " " + i.getWeight());
			else
				System.out.println("There's no candies with '" + name + "' name");
		}
	}
	
	public void findByColor(String color) {
		System.out.println("The search result for candy color '" + color + "':");
		for(Candy i : candyList) {
			if (i.getColor().equals(color)) 
				System.out.println(i.getColor() + " " + i.getName() + " " + i.getType() + " " + i.getWeight());
			else
				System.out.println("There's no candies with '" + color + "' color");
		}
	}
	
	public void findByWeight(double lower, double upper) {
		double weight;
		System.out.println("The search result for candy weight from " + lower + " to " + upper + ":");
		for(Candy i : candyList) {
			weight = i.getWeight();
			if (weight >= lower && weight <= upper) 
				System.out.println(i.getWeight() + " " + i.getName() + " " + i.getColor() + " " + i.getType());
			else
				System.out.println("There's no candies with weight range from " + lower + " to " + upper);
		}
	}
	

}
