package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoimpl.StudentDAOImpl;
import com.model.Student;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DeleteServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
		Student student = null;
		
		System.out.println("Id is "+request.getParameter("id"));
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		System.out.println("Id is "+id);
		
		student = studentDAOImpl.getStudentById(id);
		
		PrintWriter pw = response.getWriter();
		
		if(id != null) {
		
		
		pw.write("<div style='width:100%; height:100%; background: background: rgb(39,38,61); background: linear-gradient(90deg, rgba(39,38,61,1) 13%, rgba(78,78,126,1) 35%, rgba(112,193,209,1) 91%);'>");
		pw.write("<div style=' display: flex; width:100%; height:90px; align-items: center;  margin: 0px auto; '>");
		pw.write("<a href='StudentServlet' style='text-decoration:none; background-color: white; border: 2px solid white; border-radius: 5px; margin: 15px; width: 80px; height: 28px; text-align: center; font-size: 20px; padding: 7px;'>Add</a>");
		pw.write("<a href='ViewUserServlet' style='text-decoration:none; background-color: white; border: 2px solid white; border-radius: 5px; margin: 15px; width: 80px; height: 28px; text-align: center; font-size: 20px; padding: 7px;'>View All</a>");
		pw.write("</div>");
		pw.write("<h1 style='text-align:center; color:white; margin:0; font-size:50px;justify-content:center;'>Delete Student</h1>");
		pw.write("<form method='post' style='display:flex; flex-direction: column; text-align: center; align-items: center; margin-top: 40px;'>");
		pw.write("<div style='width:100%; height:100%; size:20px; margin: 10px; text-align: center; align-items: center;'><input hidden type='text' name ='rollNo' placeholder='Roll No' style='width:30%; height: 50px; font-size: 18px; padding:8px; border:none; border-radius: 5px'></input></div>");
		pw.write("<h3 style='text-align:center; color:white; margin:0; font-size:50px;justify-content:center;'>Do you really want to delete "+student.getName()+"?</h3>");
		pw.write("<input type='submit' value='Delete' style= 'width:100px; height:50px; background-color: red; color: white; cursor: pointer; font-size: 18px; border:none; border-radius: 5px;'></input>");
		pw.write("</form>");
		pw.write("</div>");
		
		
		
		
			
			
//			int result = studentDAOImpl.deleteStudent(id);
//			if(result > 0) {
//				response.sendRedirect("ViewUserServlet");
//			}
		
		
		}else {
			pw.write("<div style='width:100%; height:100%; background: background: rgb(39,38,61); background: linear-gradient(90deg, rgba(39,38,61,1) 13%, rgba(78,78,126,1) 35%, rgba(112,193,209,1) 91%);'>");
			pw.write("<div style=' display: flex; width:100%; height:90px; align-items: center;  margin: 0px auto; '>");
			pw.write("<a href='StudentServlet' style='text-decoration:none; background-color: white; border: 2px solid white; border-radius: 5px; margin: 15px; width: 80px; height: 28px; text-align: center; font-size: 20px; padding: 7px;'>Add</a>");
			pw.write("<a href='#' style='text-decoration:none; background-color: white; border: 2px solid white; border-radius: 5px; margin: 15px; width: 80px; height: 28px; text-align: center; font-size: 20px; padding: 7px;'>Update</a>");
			pw.write("<a href='DeleteServlet' style='text-decoration:none; background-color: white; border: 2px solid white; border-radius: 5px; margin: 15px; width: 80px; height: 28px; text-align: center; font-size: 20px; padding: 7px;'>Delete</a>");
			pw.write("<a href='ViewUserServlet' style='text-decoration:none; background-color: white; border: 2px solid white; border-radius: 5px; margin: 15px; width: 80px; height: 28px; text-align: center; font-size: 20px; padding: 7px;'>View All</a>");
			pw.write("</div>");
			pw.write("<h1 style='text-align:center; color:red; margin:0; font-size:50px;justify-content:center;'>ERROR!</h1>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
