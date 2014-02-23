package LogicModule;

import java.util.ArrayList;

public class Waiter extends Employee{
	
	private ArrayList<Integer> completeOrder = new ArrayList<Integer>();
	
	public Waiter(int waiterID) {
		// TODO Auto-generated constructor stub
		this.employeeID = waiterID;
	}
	
	/**
	 * add tableID of completed order to Waiter object
	 * @param TableID
	 */
	public void notifyOrderComplete(int TableID){
		this.completeOrder.add(Integer.valueOf(TableID));
	}
	/**
	 * return the tableID of completed order.
	 * @return
	 */
	public ArrayList<Integer> checkCompleteOrder() {
		return completeOrder;
	}
	
	public int getWaiterID() {
		return this.employeeID;
	}
	
	
}
