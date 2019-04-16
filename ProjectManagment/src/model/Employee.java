package model;

public class Employee {
	
	
	private String empName;
	private long empMobile;
	private int empID;
	private String empPassword;
	private String empEMailID;
	private String empRole;
	private boolean status;
	
	
	public Employee() {
		
	}
	
	public Employee(String empName, long empMobile, int empID, String empPassword, String empEMailID, String empRole,
			boolean status) {
		super();
		this.empName = empName;
		this.empMobile = empMobile;
		this.empID = empID;
		this.empPassword = empPassword;
		this.empEMailID = empEMailID;
		this.empRole = empRole;
		this.status = status;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public long getEmpMobile() {
		return empMobile;
	}

	public void setEmpMobile(long empMobile) {
		this.empMobile = empMobile;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public String getEmpEMailID() {
		return empEMailID;
	}

	public void setEmpEMailID(String empEMailID) {
		this.empEMailID = empEMailID;
	}

	public String getEmpRole() {
		return empRole;
	}

	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}

	public boolean isStatus() {
		return status;
	}
	

	public void setEmpMobile(String parameter) {
		// TODO Auto-generated method stub
		
	}

	public void setEmpID(String parameter) {
		// TODO Auto-generated method stub
		
	}

	public void setStatus(boolean parseBoolean) {
		// TODO Auto-generated method stub
		
	}

	

	
	

}
