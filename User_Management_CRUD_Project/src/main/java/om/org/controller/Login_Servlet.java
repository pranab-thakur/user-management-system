package om.org.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.User_Dao;
import com.org.dto.User;
@WebServlet("/login")
public class Login_Servlet  extends HttpServlet {	

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	
	User_Dao dao=new User_Dao();
	User user=dao.fetchUserByEmailAndPassword(email, password);
	
	HttpSession session=req.getSession();
	if(user!=null) {
		
		
		session.setAttribute("userobj", user);
		resp.sendRedirect("home.jsp");
	}
	else {
		session.setAttribute("fail", "invalid credentials");
		resp.sendRedirect("login.jsp");
	}
	
	
	
	
}
}
