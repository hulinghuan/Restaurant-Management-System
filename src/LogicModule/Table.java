package LogicModule;

import java.util.ArrayList;

public class Table {
	private String tableStatus;
	private int tableID;
	public Table(int tableID) {
		this.tableStatus = "Free";
		this.tableID = tableID;
	}
	
	/**
	 * change Table status to Ocupied
	 */
	public void changeTabletoOcupied(){
		this.tableStatus = "Ocupied";
	}
	public String getTableStatus(){
		return tableStatus;
	}
	public int getTableID() {
		return tableID;
	}
	
	
}
