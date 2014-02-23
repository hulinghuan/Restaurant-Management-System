package LogicModule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//this class is used for initialization
public class Store {
	private ArrayList<Table> tableList = new ArrayList<Table>();
	private FoodCategory foodCategory = new FoodCategory();
	private ArrayList<Waiter> waiterList = new ArrayList<Waiter>();
	private Employee currentEmployee = new Employee();
	
	public Store() {
		for(int IDIter = 1; IDIter < 11; IDIter ++) {
			tableList.add(new Table(IDIter));
		}
		for(int IDIter = 1; IDIter < 4; IDIter ++){
			waiterList.add(new Waiter(IDIter));
		}
	}
	
	/**
	 * login the system with the username and password, and initialize the currentEmployee
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean login(String username, String password) {
		Connection conn = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		String employeeType = "";
		int employeeID;
		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/RMS", "root", "123456");
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select employeeid,employeetype from employeelogin where username='"
			+ username + "' and password='" + password + "';");
			if(rs.next()) {
				employeeType = rs.getString("employeetype");
				employeeID = rs.getInt("employeeid");
				if(employeeType.equals("waiter")) {
					this.currentEmployee.setEmployeeID(employeeID);
					this.currentEmployee.setEmployeeType(employeeType);
					return true;
				}
				if(employeeType.equals("cook")) {
					this.currentEmployee.setEmployeeID(employeeID);
					this.currentEmployee.setEmployeeType(employeeType);
					return true;
				}
			} else {
				return false;
			}
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) { }
				rs = null;
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch(SQLException SQLEx) { }
				stmt = null;
			}	
		}
		return true;
	}
	public ArrayList<Table> getTableList() {
		return tableList;
	}

	public FoodCategory getFoodCategory() {
		return foodCategory;
	}

	public ArrayList<Waiter> getWaiterList() {
		return waiterList;
	}

	public String getCurrentEmployeeType() {
		return currentEmployee.getEmployeeType();
	}
	public int getCurrentEmployeeID() {
		return currentEmployee.getEmployeeID();
	}
}