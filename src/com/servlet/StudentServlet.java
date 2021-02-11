package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoimpl.StudentDAOImpl;
import com.model.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public StudentServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		
		PrintWriter pw = response.getWriter();
		pw.write("<div style='width:100%; height:100%; background: background: rgb(39,38,61); background: linear-gradient(90deg, rgba(39,38,61,1) 13%, rgba(78,78,126,1) 35%, rgba(112,193,209,1) 91%);'>");
		pw.write("<div style=' display: flex; width:100%; height:90px; align-items: center;  margin: 0px auto; '>");
		pw.write("<a href='#' style='text-decoration:none; background-color: white; border: 2px solid white; border-radius: 5px; margin: 15px; width: 80px; height: 28px; text-align: center; font-size: 20px; padding: 7px;'>Add</a>");
		pw.write("<a href='ViewUserServlet' style='text-decoration:none; background-color: white; border: 2px solid white; border-radius: 5px; margin: 15px; width: 80px; height: 28px; text-align: center; font-size: 20px; padding: 7px;'>View All</a>");
		pw.write("</div>");
		pw.write("<h1 style='text-align:center; color:white; margin:0; font-size:50px;justify-content:center;'>Student Form</h1>");
		pw.write("<form method='post' style='display:flex; flex-direction: column; text-align: center; align-items: center; margin-top: 40px;'>");
		pw.write("<div style='width:100%; height:100%; size:20px; margin: 10px; text-align: center; align-items: center;'><input type='text' name ='rollNo' placeholder='Roll No' style='width:30%; height: 50px; font-size: 18px; padding:8px; border:none; border-radius: 5px'></input></div>");
		pw.write("<div style='width:100%; height:100%; size:20px; margin: 10px; text-align: center; align-items: center;'><input type='text' name ='name' placeholder='Name' style='width:30%; height: 50px; font-size: 18px; padding:8px; border:none; border-radius: 5px'></input></div>");
		pw.write("<div style='width:100%; height:100%; size:20px; margin: 10px; text-align: center; align-items: center;'><input type='text'  name ='contact' placeholder='Contact' style='width:30%; height: 50px; font-size: 18px; padding:8px; border:none; border-radius: 5px'></input></div>");
		pw.write("<div style='width:100%; height:100%; size:20px; margin: 10px; text-align: center; align-items: center;'><input type='email' name ='email' placeholder='Email' style='width:30%; height: 50px; font-size: 18px; padding:8px; border:none; border-radius: 5px'></input></div>");
		pw.write("<input type='submit' value='save' style= 'width:100px; height:50px; font-size: 18px; border:none; border-radius: 5px;'></input>");
		pw.write("</form>");
		
		
		
		String rollNo = request.getParameter("rollNo");
		String name = request.getParameter("name");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		
		StudentDAOImpl sdimpl = new StudentDAOImpl();
		
		if(rollNo !=null && name !=null &&  contact !=null && email!=null) {
			
		Student student = new Student();
		
		student.setName(name);
		student.setRollNo(rollNo);
		student.setContact(contact);
		student.setEmail(email);
		
		
		int result = sdimpl.addStudent(student);
		if(result > 0) {
			response.sendRedirect("ViewUserServlet");
		}
		}
		
		
		pw.write("</div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
