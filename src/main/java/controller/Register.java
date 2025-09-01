package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.registerUser;

import java.io.IOException;

import DAO.daoRegister;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		registerUser user=new registerUser();
		user.setUsername(req.getParameter("username"));
		user.setEmail(req.getParameter("email"));
		user.setPassword(req.getParameter("password"));
		
		daoRegister rg=new daoRegister();
		rg.registerUser(user);
		
		res.sendRedirect("login.html");
		
	
	}

}
