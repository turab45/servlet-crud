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
 * Servlet implementation class ViewUserServlet
 */
@WebServlet("/ViewUserServlet")
public class ViewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ViewUserServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		PrintWriter pw = response.getWriter();
		
		pw.write("<div style='width:100%; height:100%; background: background: rgb(39,38,61); background: linear-gradient(90deg, rgba(39,38,61,1) 13%, rgba(78,78,126,1) 35%, rgba(112,193,209,1) 91%);'>");
		pw.write("<div style=' display: flex; width:100%; height:90px; align-items: center;  margin: 0px auto; '>");
		pw.write("<a href='StudentServlet' style='text-decoration:none; background-color: white; border: 2px solid white; border-radius: 5px; margin: 15px; width: 80px; height: 28px; text-align: center; font-size: 20px; padding: 7px;'>Add</a>");
		pw.write("<a href='#' style='text-decoration:none; background-color: white; border: 2px solid white; border-radius: 5px; margin: 15px; width: 80px; height: 28px; text-align: center; font-size: 20px; padding: 7px;'>View All</a>");
		pw.write("</div>");
		pw.write("<table style='font-family: Arial, Helvetica, sans-serif; border-collapse: collapse; width: 100%; text-align: center; align-items: center;'");
		
		pw.write("<tr style='background-color: #f2f2f2; hover: background-color: #ddd;'>");
		
		pw.write("<th style='padding-top: 12px; text-align: center; padding-bottom: 12px; text-align: left; background-color: #4CAF50; color: white;'>Roll No</th>");
		pw.write("<th style='padding-top: 12px; text-align: center; padding-bottom: 12px; text-align: left; background-color: #4CAF50; color: white;'>Name</th>");
		pw.write("<th style='padding-top: 12px; text-align: center; padding-bottom: 12px; text-align: left; background-color: #4CAF50; color: white;'>Contact</th>");
		pw.write("<th style='padding-top: 12px; text-align: center; padding-bottom: 12px; text-align: left; background-color: #4CAF50; color: white;'>Email</th>");
		pw.write("<th style='padding-top: 12px; text-align: center; padding-bottom: 12px; text-align: left; background-color: #4CAF50; color: white;'>Edit</th>");
		pw.write("<th style='padding-top: 12px; text-align: center; padding-bottom: 12px; text-align: left; background-color: #4CAF50; color: white;'>Delete</th>");
		pw.write("</tr>");
		pw.write("</div>");
		
		StudentDAOImpl sdimpl = new StudentDAOImpl();
		
		ArrayList<Student> allStudents = (ArrayList<Student>) sdimpl.getAllStudent();
		
		if(allStudents.size() > 0){
		
		for(Student s:allStudents) {
			
			pw.write("<tr style='background-color: #f2f2f2; text-align: left; hover: background-color: #ddd;'>");
			pw.write("<td  style='border:  1px solid #ddd; padding: 8px;'>"+s.getRollNo()+"</td>");
			pw.write("<td style='border: 1px solid #ddd; padding: 8px;'>"+s.getName()+"</td>");
			pw.write("<td style='border: 1px solid #ddd; padding: 8px;'>"+s.getContact()+"</td>");
			pw.write("<td style='border: 1px solid #ddd; padding: 8px;'>"+s.getEmail()+"</td>");
			
			
			// href = 'updateServlet?id="++"'
			
			pw.write("<td style='border: 1px solid #ddd; padding: 8px;'><a href='UpdateServlet?id="+s.getId()+"'>Edit</a></td>");
			pw.write("<td style='border: 1px solid #ddd; padding: 8px;'><a href='DeleteServlet?id="+s.getId()+"'>Delete</a></td>");
			pw.write("</tr>");
		}
		}else {
			pw.write("<center><h1 style='color:white'> No Students</h1></center>");
		}
		
		pw.write("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
