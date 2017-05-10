package com.model.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;
import com.model.action.Action;
import com.model.bean.UserBean;

public class UserAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action==null) {
			request.setAttribute("msg", "Invalid Request");
			request.getRequestDispatcher("registration.jsp").forward(request, response);
		}
		switch (action.toLowerCase()) {
		case "adduser":
				addUser(request, response);
			break;
		case "login":
			login(request, response);
		break;
		case "logout":
			logout(request, response);
		break;
		


		default:
			break;
		}
		
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		UserBean userBean=new UserDAO().authenticateUser(email, password);
		if(userBean==null) {
			request.setAttribute("msg", "invalid email or password");
			request.getRequestDispatcher("login.jsp");
		}
		else
		{
			HttpSession  session=request.getSession();
			session.setAttribute("userBean",userBean);
			response.sendRedirect("home.jsp");
		}
	}
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession  session=request.getSession();
		UserBean userBean=(UserBean) session.getAttribute("userBean");
		if(userBean!=null) {
			session.removeAttribute("userBean");
			session.invalidate();
		}
		response.sendRedirect("index.jsp");
	}

	private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String mobileNo=request.getParameter("mobileNo");
		String city=request.getParameter("city");
		UserBean userBean=new UserBean();
		userBean.setName(name);
		userBean.setEmail(email);
		userBean.setPassword(password);
		userBean.setCity(city);
		userBean.setMobileNo(mobileNo);
		UserDAO userDAO=new UserDAO();
		boolean flag=userDAO.addUser(userBean);
		String msg=flag?"succesfully added":"failed,please try again later";
		request.setAttribute("msg", msg);
		if(flag)
			request.getRequestDispatcher("login.jsp").forward(request, response);
		else
			request.getRequestDispatcher("registration.jsp").forward(request, response);
	}
	

}
