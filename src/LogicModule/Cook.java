package LogicModule;

import java.util.ArrayList;

public class Cook extends Employee{

	private boolean incomingOrder = false;
	
	/**
	 * Notify new incoming order
	 */
	public void notifyNewOrder(){
		this.incomingOrder = true;
	}
}
