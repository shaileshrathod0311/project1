package DAOImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbcH2config.H2Config;
import model.Employee;
import DAO.EmployeeDAO;

public class EmployeeDAOImp implements EmployeeDAO {
	
	Connection con;
	private Employee emp;
	
	public EmployeeDAOImp() {
		
		con=H2Config.getConnection();
	}

 	

	@Override
	public boolean insertEmployee(Employee emp) {
		try {
			
		Connection con = H2Config.getConnection();
		  
		  String sql =
		  "insert into Employee(emp_name,emp_id,emp_password,emp_EmailID,emp_Role,status,empmobile) values(?,?,?,?,?,?,?)";
		  
		  PreparedStatement statement = con.prepareStatement(sql);
		  statement.setString(1, emp.getEmpName());
		  statement.setInt(2,emp.getEmpID()); 
		  statement.setString(3, emp.getEmpPassword());
		  statement.setString(4, emp.getEmpEMailID());
		  statement.setString(5, emp.getEmpRole());
		  statement.setBoolean(6, emp.isStatus());
		  statement.setLong(7, emp.getEmpMobile());
		  
		  
		  boolean rowInserted = statement.executeUpdate() > 0; 
		  statement.close();
		  return rowInserted;
		  } 
	catch(Exception e) 
	{
		System.out.println(e); 
	}
			
		return false;
	}

	

	@Override
	public List<Employee> readEmployee() {
		List<Employee> listEmp = new ArrayList<>();
		String sql ="Select * FROM Employee";
		Employee emp;
		try {
			//con=H2Config.getConnection();
			System.out.println(con);
						
			Statement statement = con.createStatement();
			
			ResultSet resultset = statement.executeQuery(sql);
		
		    while(resultset.next())
		    {
		    	String empName = resultset.getString("emp_Name");
		    	int empID = resultset.getInt("emp_ID");
		    	String empPassword = resultset.getString("emp_Password");
		    	String empEmailID = resultset.getString("emp_EmailID");
		    	String empRole = resultset.getString("emp_Role");
		    	boolean status = resultset.getBoolean("status");
		    	long empMobile=resultset.getLong("empMobile");
		    	
		    	    	
		    	 emp = new Employee(empName,empMobile,empID,empPassword,empEmailID,empRole,status);
		        
		    	listEmp.add(emp);
		    	System.out.println(listEmp);
		    
		    }
		  resultset.close();
		   statement.close();
		    return listEmp;
		}
		catch(Exception e)
		{
			System.out.println(e+"o");
		}
		
		return null;
	}	
	

	@Override
	public String login(Employee emp) {
		  
		Statement smt = null;
		String emailid = emp.getEmpEMailID();
		String password = emp.getEmpPassword();
        String Role= null; 
        String emailiddb = null;
        String passworddb = null;
        
		String searchQuery="select emp_emailid,emp_password,emp_role from employee where emp_emailid='"+ emailid + "' AND emp_password='"+ password+"'";
	
	   	System.out.println("Your user name is " + emailid );          
		  System.out.println("Your password is " + password);
	      System.out.println("Query: "+searchQuery);	      
	      
	    	 
		
		try {
			Connection con = H2Config.getConnection();
		
			  smt=con.createStatement();
			  boolean b=smt.execute(searchQuery);
	    	  ResultSet rs = smt.executeQuery(searchQuery);
	    	     		  
	    	  
	    	while(rs.next())
	    	{
	    		emailiddb= rs.getString("emp_emailid");
	    		passworddb=rs.getString("emp_password");
	    		Role=rs.getString("emp_role");
	    	
	    	if(emailiddb.equals(emailid) && passworddb.equals(password) && Role.equals("admin"))
	    	{
	    		return "admin";
	    	}
	    	else if(emailiddb.equals(emailid) && passworddb.equals(password) && Role.equals("employee"))
	    	{
	    		return "employee";
	    	}
	    	
	    	  }
		}
	    			   	  
	      catch(Exception e) {
	    	System.out.println(e);  
	      }
	      
		return "error";
	}



	@Override
	public boolean updateEmployee(Employee emp) {
		 boolean rowupdate=false;
		try {
			
			Connection con = H2Config.getConnection();
			  
			  String sql =
			  "update employee set EMP_NAME=?,EMP_PASSWORD=?,EMP_EMAILID=?,EMP_ROLE=?,STATUS=?,EMPMOBILE=? where EMP_ID=?";
			  
			  PreparedStatement statement = con.prepareStatement(sql);
			  statement.setString(1, emp.getEmpName());
			  statement.setString(2,emp.getEmpPassword()); 
			  statement.setString(3, emp.getEmpEMailID());
			  statement.setString(4, emp.getEmpRole());
			  statement.setBoolean(5, emp.isStatus());
			  statement.setLong(6, emp.getEmpMobile());
			  statement.setInt(7,emp.getEmpID());
			  
			  int i=statement.executeUpdate();
			  
			  System.out.println(i);
			 
			  if (i > 0)
				  rowupdate=true;
			  statement.close();
			 // return rowupdate;
			  } 
		catch(Exception e) 
		{
			System.out.println(e); 
		}
		
		return rowupdate;
		
			}



	@Override
	public boolean deleteEmployee(Employee emp) {
		int status = 0; 
		try {
			  
			  Connection con = H2Config.getConnection();			
			  PreparedStatement ps = con.prepareStatement("Delete from employee where EMP_ID = ?");
			 ps.setInt(1,emp.getEmpID());
			 status=ps.executeUpdate();
			 ps.close();
		       // con.close();
			 if(status>0)
				 return true;
			 
			  } 
		catch(Exception e) 
		{ 
				  System.out.println(e);
		} 
		
		return false; 
		}
				  
		@Override
	public void empValidate(Employee emp) {
		// TODO Auto-generated method stub
		
	}



		@Override
		public Employee getEmployee(int id) {
			
			try {
				
				Connection con = H2Config.getConnection();
				  
				  String sql =
				  "Select *from employee where emp_id='"+ id +"'";
				  
				  Statement statement = con.createStatement();
				  
			
				  ResultSet resultset = statement.executeQuery(sql);
				  while(resultset.next())
				    {
				    	String empName = resultset.getString("emp_Name");
				    	int empID = resultset.getInt("emp_ID");
				    	String empPassword = resultset.getString("emp_Password");
				    	String empEmailID = resultset.getString("emp_EmailID");
				    	String empRole = resultset.getString("emp_Role");
				    	boolean status = resultset.getBoolean("status");
				    	long empMobile=resultset.getLong("empMobile");
				    	
				    	    	
				    	 emp = new Employee(empName,empMobile,empID,empPassword,empEmailID,empRole,status);
				        
				    
				    }
				  
				 
				 return emp;
				  } 
			catch(Exception e) 
			{
				System.out.println(e); 
			}
			
			
			return null;
		}

		
}
