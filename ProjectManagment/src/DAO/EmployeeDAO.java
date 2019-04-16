package DAO;

import java.util.List;

import model.Employee;



public interface EmployeeDAO {
	
	List<Employee> readEmployee();
	boolean insertEmployee(Employee emp);
	boolean updateEmployee(Employee emp);
	boolean deleteEmployee(Employee emp);
	//Employee getEmployee(Employee emp);
	 Employee getEmployee(int id);
	String login(Employee emp);
	void empValidate(Employee emp);
	

}
 
