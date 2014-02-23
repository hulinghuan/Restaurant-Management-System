package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import LogicModule.Cook;
import LogicModule.FoodCategory;
import LogicModule.Order;
import LogicModule.OrderLineItem;
import LogicModule.Table;
import LogicModule.Waiter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class OrderController {
	private int orderID = 1;
	private Order currentOrder;
	private Cook currentCook = new Cook();
	private Waiter currentWaiter;
	private ArrayList<Waiter> waiterList = new ArrayList<Waiter>();
	private ArrayList<Table> tableInstance;
	private FoodCategory foodCategory;
	private ArrayList<Order>incompleteOrder = new ArrayList<Order>();
	
	public OrderController() {
		//assume we have 2 waiters totaly
		for(int i = 1; i < 3; i ++)
		this.waiterList.add(new Waiter(3));
	}
	/**
	 * return the latest table status.
	 * @return Map object, Integer is tableID, String is table status.
	 */
	public Map<Integer, String> displayTableStatus(){
		Map<Integer, String> tableStatus = new HashMap<Integer, String>();
		for(int tableIdIter = 0; tableIdIter < tableInstance.size(); tableIdIter++) {
			tableStatus.put(Integer.valueOf(tableInstance.get(tableIdIter).getTableID()),
					tableInstance.get(tableIdIter).getTableStatus());
		}
		return tableStatus;
	}
	
	/**
	 * check the order completed by cook and return the table id of completed orders.
	 * @return The table id of completed orders.
	 */
	public ArrayList<Integer> checkCompleteOrder() {
		return this.currentWaiter.checkCompleteOrder();
	}
	
	/**
	 * Check the incoming new order.
	 * @return the order line items information of the new order
	 */
	public ArrayList<OrderLineItem> retrieveNextOrderLineItems() {
		ArrayList<OrderLineItem> nextOrder = this.incompleteOrder.get(0).getLineItemList();
		return nextOrder;
	}
	
	/*
	 * 
	 */
	public void orderComplete() {
		if(this.incompleteOrder.size() > 0){
			this.incompleteOrder.get(0).orderComplete();
			this.currentWaiter.notifyOrderComplete(this.incompleteOrder.get(0).getTableID());
			this.incompleteOrder.remove(0);
		}
	}

	
	public ArrayList<String> startAddItem(){
		return this.foodCategory.getFoodCategory();
	}
	
	public ArrayList<String> chooseFoodCategory(String FCategory){
		return this.foodCategory.getItemList(FCategory);
	}
	
	public void makeNewOrder(int TableID){
		this.currentOrder = new Order(orderID, TableID, this.currentWaiter.getWaiterID());
		orderID ++;
	}
	
	public void chooseItem(String itemName, int quantity){
		this.currentOrder.insertLineItem(itemName, quantity);
	}
	
	public void confirmOrder(){
		int tableID = currentOrder.getTableID();
		tableInstance.get(tableID).changeTabletoOcupied();
		currentCook.notifyNewOrder();
		incompleteOrder.add(currentOrder);
	}

	public void setTableInstance(ArrayList<Table> tableInstance) {
		this.tableInstance = tableInstance;
	}

	public FoodCategory getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(FoodCategory foodCategory) {
		this.foodCategory = foodCategory;
	}
	

	public Order getCurrentOrder() {
		return currentOrder;
	}

	public Cook getCurrentCook() {
		return currentCook;
	}

	public void setCurrentCook(Cook currentCook) {
		this.currentCook = currentCook;
	}

	public Waiter getCurrentWaiter() {
		return currentWaiter;
	}

	public void setCurrentWaiter(int waiterID) {
		this.currentWaiter = this.waiterList.get(waiterID - 1);
	}

	public void setWaiterList(ArrayList<Waiter> waiterList) {
		this.waiterList = waiterList;
	}
	
}
