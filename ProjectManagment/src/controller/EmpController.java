package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.EmployeeDAO;
import DAOImp.EmployeeDAOImp;
import model.Employee;

@WebServlet(name="/EmpController",urlPatterns={"/"})
public class EmpController extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	EmployeeDAO empdao=new EmployeeDAOImp();
    
	
	
	 
	public void doPost(HttpServletRequest request,HttpServletResponse
	  response)throws ServletException,IOException {
		doGet(request,response);
		}
	
	  public void doGet(HttpServletRequest request,HttpServletResponse
	  response)throws ServletException,IOException {
	  
	  String action=request.getServletPath(); System.out.println(action); 
	  try {
		  
		    switch(action) {
	  
	  case "/":
		  RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/view/index.jsp");
	  		 dispatcher.forward(request, response);
	  break;
	  
	  case "/login":
		  
		  RequestDispatcher dispatcher1=request.getRequestDispatcher("/WEB-INF/view/login.jsp");
	  		 dispatcher1.forward(request, response);
	  		 break;
	  		 
	  case "/loginchek": 
		  login(request,response);
	  break;
	  
	  case "/newEmp":
		  
		  RequestDispatcher dispatcher2=request.getRequestDispatcher("/WEB-INF/view/newemployee.jsp");
	  		 dispatcher2.forward(request, response);
	  		 break;
	  
	  case "/addEmp":
		  addnewEmp(request,response); 
		  break;
		  
	  case "/delete":
		  deleteEmployee(request,response);
	  break;
		  
	  case "/update":
		  updateEmployee(request,response);
		  break;
		  
	  case "/UpdateEmp":
		  newEmpForm(request,response);
		  break;
		  
	  case "/searchEmp":
		  searchForm(request,response);
		  break;
		 
	  case "/logOut":
		  empLogout(request,response);
		  break;
		  
	  case "/list":
		  
		  listEmp(request,response);
		  break;
		  
		  default:
			  listEmp(request,response);
			  break;
		  
	  }
	  }
	  
	 	  
	  catch(Exception e)
	  {  
		  RequestDispatcher dispatcher=request.getRequestDispatcher( "/WEB-INF/view/errorpage.jsp");
		dispatcher.forward(request, response);
		
		System.out.println(e); 
		}
	  
	  }
	 
	
	private void login(HttpServletRequest request, HttpServletResponse response)  {
		
			 Employee emp= new Employee();
		     emp.setEmpEMailID(request.getParameter("uname"));
		     emp.setEmpPassword(request.getParameter("psw"));
		    		     
		     try
		     {
		     String Role=empdao.login(emp);
		     System.out.println(Role);
		     
		     
		 if(Role.equals("admin"))
		 {
			HttpSession session = request.getSession();
			session.setAttribute("admin",emp.getEmpEMailID());
			session.setAttribute("emailId",emp.getEmpEMailID());
			listEmp(request,response);
			
			
		
		 }
		 
		 else if(Role.equals("employee"))
		 {
			 HttpSession session = request.getSession();
			 session.setAttribute("employee",emp.getEmpEMailID());
				session.setAttribute("emailId",emp.getEmpEMailID());
			 RequestDispatcher dispatcher=request.getRequestDispatcher( "/WEB-INF/view/wellcome.jsp");
				dispatcher.forward(request, response);
				//request.getRequestDispatcher("/WEB-INF/view/wellcome.jsp");
		 }
			
			  else if(Role.equals("error"))
				  { 
			  RequestDispatcher dispatcher=request.getRequestDispatcher( "/WEB-INF/view/errorpage.jsp");
			  dispatcher.forward(request, response); 
				  System.out.println( "hjhj");
				 
				  }
				 		     
		}	
		catch(Exception e)
		{
			
			System.out.println(e);
		}
		    
	}

	private void listEmp(HttpServletRequest request,HttpServletResponse response)throws Exception
	{
 		
		List<Employee> listEmp=empdao.readEmployee();
		request.setAttribute("listEmp",listEmp);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher( "/WEB-INF/view/list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void addnewEmp(HttpServletRequest request,HttpServletResponse response)throws Exception
	{
		Employee emp = new Employee();
		emp.setEmpEMailID(request.getParameter("email"));
		emp.setEmpName(request.getParameter("name"));
		emp.setEmpPassword(request.getParameter("pass"));
		emp.setEmpMobile(Long.parseLong(request.getParameter("mob")));
		emp.setEmpRole(request.getParameter("role"));
	//	emp.setEmpEMailID(request.getParameter("status"));
		emp.setEmpID(Integer.parseInt(request.getParameter("id")));
		boolean bol=empdao.insertEmployee(emp);
		System.out.println(bol);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher( "list");
		dispatcher.forward(request, response);
		
		//listEmp(request,response);
	}
	
	private void deleteEmployee(HttpServletRequest request,HttpServletResponse response)throws Exception
	{
		HttpSession session=request.getSession();
		int id = Integer.parseInt(request.getParameter("empID"));
		String page="";
		Employee emp = new Employee();
		emp.setEmpID(id);
		boolean del=empdao.deleteEmployee(emp);
		System.out.println(del);
		/*
		 * if(true) { page="list.jsp"; } else { page="error.jsp"; }
		 */
		//request.getRequestDispatcher(page).forward(request,response); //at last line
		listEmp(request,response);
		// response.sendRedirect("list.jsp");
		 
		
	}
	
	private void updateEmployee(HttpServletRequest request,HttpServletResponse response)throws Exception
	{
		HttpSession session=request.getSession();
		Employee emp = new Employee();
		emp.setEmpEMailID(request.getParameter("email"));
		emp.setEmpName(request.getParameter("name"));
		emp.setEmpPassword(request.getParameter("pass"));
		emp.setEmpMobile(Long.parseLong(request.getParameter("mob")));
		emp.setEmpRole(request.getParameter("role"));
		emp.setEmpID(Integer.parseInt(request.getParameter("id")));
		emp.setStatus(Boolean.parseBoolean(request.getParameter("status")));
		boolean bol=empdao.updateEmployee(emp);
		System.out.println(bol);
		RequestDispatcher dispatcher=request.getRequestDispatcher( "list");
		dispatcher.forward(request, response);
	}
	
	private void newEmpForm(HttpServletRequest request,HttpServletResponse response)throws Exception
	{
		System.out.println("update");
		HttpSession session=request.getSession();
		int id = Integer.parseInt(request.getParameter("empID"));
		Employee emp = empdao.getEmployee(id);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher( "/WEB-INF/view/update.jsp");
		request.setAttribute("emp",emp);
		dispatcher.forward(request, response);
		
		
	}
	private void searchForm(HttpServletRequest request,HttpServletResponse response)throws Exception
	{
		Employee emp = new Employee();
		emp.setEmpEMailID(request.getParameter("email"));
		emp.setEmpName(request.getParameter("name"));
		emp.setEmpPassword(request.getParameter("pass"));
		emp.setEmpMobile(Long.parseLong(request.getParameter("mob")));
		emp.setEmpRole(request.getParameter("role"));
		emp.setEmpID(Integer.parseInt(request.getParameter("id")));
		boolean bol=empdao.updateEmployee(emp);
		System.out.println(bol);
		listEmp(request,response);
	}
	
	private void empLogout(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		 PrintWriter out=response.getWriter();  
         
                  
         HttpSession session=request.getSession();  
         session.invalidate();  
           
        // out.print("You are successfully logged out!");  
           
       //  out.close();  
		
		RequestDispatcher dispatcher=request.getRequestDispatcher( "/WEB-INF/view/index.jsp");
			dispatcher.forward(request, response);
			
			session.removeAttribute("uname");
			session.invalidate();
			
	}
	}

