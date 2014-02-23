package LogicModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import Controller.OrderController;

public class Main {

	private static OrderController ctl = new OrderController();
	private static Store store = new Store();
	
	public static void main(String[] args) {
		Map<Integer, String> tableStatus = new HashMap<Integer, String>();
		ArrayList<String> FoodCategory = new ArrayList<String>();
		ArrayList<String> itemList = new ArrayList<String>();
		
		//system initia works
		ctl.setTableInstance(store.getTableList());
		ctl.setFoodCategory(store.getFoodCategory());
		ctl.setWaiterList(store.getWaiterList());
		
		//Login test (exit if fail)
		System.out.println("Login test");
		if(store.login("cook1", "123456")) {
			String employeeType = store.getCurrentEmployeeType();
			int employeeID = store.getCurrentEmployeeID();
			if(employeeType.equals("waiter")) {
				ctl.setCurrentWaiter(employeeID);
				System.out.println("waiter, employeeID=" + employeeID + " login");
			}
			if(employeeType.equals("cook")) {
				System.out.println("Cook, employeeID=" + employeeID + " login");
			}
		} else {
			System.out.println("Login failed");
			return;
		}
		
		//waiter start place order
		tableStatus = ctl.displayTableStatus();
		//test for displaying table status
		for(Map.Entry<Integer, String> tableIter : tableStatus.entrySet()) {
			System.out.println(tableIter.getKey());
			System.out.println(tableIter.getValue());
		}
		
		//waiter place order for table 3
		ctl.makeNewOrder(3);
		//system display the food category menu
		FoodCategory = ctl.startAddItem();
		
		//test for diplay the menu data
		for(String iter : FoodCategory) {
			System.out.println(iter);
		}
		//waiter select the foodcategory and system display the item list of that category
		itemList = ctl.chooseFoodCategory("Burgers");
		for(String iter : itemList) {
			System.out.println(iter);
		}
		
		//waiter choose several item and quantity
		ctl.chooseItem("BBQ Ranch Burger", 3);
		ctl.chooseItem("Bacon Cheese Buerger", 2);
		//get currentOrder for testing purpose
		Order testorder = ctl.getCurrentOrder();
		
		//waiter confirm the order
		ctl.confirmOrder();
		
		//cook retrieve the next incoming order
		System.out.println();
		for(OrderLineItem iter : ctl.retrieveNextOrderLineItems()) {
			System.out.print(iter.getItemName());
			System.out.println(iter.getQuantity());
		}
		//cook complete the order
		ctl.orderComplete();
		
		//waiter check the which order is ready
		ArrayList<Integer> completeOrder = ctl.checkCompleteOrder();
		for(Integer iter : completeOrder) {
			System.out.println("Order of table " + iter + " is ready");
		}
	}

}
