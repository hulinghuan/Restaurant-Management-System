package LogicModule;

import java.util.ArrayList;

public class FoodCategory {
	
	private ArrayList<String> categoryList = new ArrayList<String>();
	private ArrayList<String> burgers = new ArrayList<String>();
	private ArrayList<String> beverages = new ArrayList<String>();
	private ArrayList<String> salads = new ArrayList<String>();
	private ArrayList<String> snacks = new ArrayList<String>();
	
	public FoodCategory () {
		categoryList.add("Burgers");
		categoryList.add("Beverages");
		categoryList.add("Salads");
		categoryList.add("Snacks");
		
		burgers.add("Cheese Burger");
		burgers.add("Bacon Cheese Buerger");
		burgers.add("BBQ Ranch Burger");
		burgers.add("Classical Chicken");
		beverages.add("Coca-Cola");
		beverages.add("Diet Coke");
		beverages.add("Ice Tea");
		beverages.add("Latte Coffee");
		snacks.add("French Fries");
		snacks.add("Apple Slices");
		salads.add("Bacon Ranch Salad");
		salads.add("Southwest Salad");
		salads.add("Side Salad");
	}
	/**
	 * return the food category
	 * @return the food category
	 */
	public ArrayList<String> getFoodCategory() {
		return categoryList;
	}
	
	/**
	 * 
	 * @param category name
	 * @return the item list of the category
	 */
	public ArrayList<String> getItemList(String category) {
		switch(category) {
		case "Burgers" :
			return this.burgers;
		case "Beverages" :
			return this.beverages;
		case "Salads" :
			return this.salads;
		case "Snacks" :
			return this.snacks;
		}
		return null;
	}
	
}
