package LogicModule;

public class Employee {
	protected int employeeID = 0;
	protected String employeeType = "";
	
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public String getEmployeeType() {
		return employeeType;
	}
}
