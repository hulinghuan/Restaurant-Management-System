package LogicModule;

public class OrderLineItem {
	private String itemName;
	private int quantity;
	
	public OrderLineItem(String itemName, int quantity){
		this.itemName = itemName;
		this.quantity = quantity;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
}
