package com.model.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.model.action.Action;
import com.model.bean.UserBean;
import com.util.ValidateUtils;

public class UserAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			request.setAttribute("msg", "Invalid Request");
			request.getRequestDispatcher("/register").forward(request,
					response);
		} else {
			switch (action.toLowerCase()) {
			case "adduser":
				addUser(request, response);
				break;
			
			default:
				request.setAttribute("msg", "Invalid Request");
				request.getRequestDispatcher("/register").forward(request,
						response);
				break;
			}
		}
	}

	
	

	private void addUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String city = request.getParameter("city");
		String degree = request.getParameter("degree");
		String college = request.getParameter("college");
		if (ValidateUtils.isEmpty(college) || ValidateUtils.isEmpty(degree)
				|| ValidateUtils.isEmpty(city)
				|| ValidateUtils.isEmpty(password)
				|| ValidateUtils.isEmpty(email) || ValidateUtils.isEmpty(name)) {
			request.setAttribute("msg", "All fields are mandatory");
			request.getRequestDispatcher("/register").forward(request,
					response);
		}

		else {
			UserBean userBean = new UserBean();
			userBean.setName(name);
			userBean.setEmail(email);
			userBean.setPassword(ValidateUtils.base64encode(password));
			userBean.setCity(city);
			userBean.setCollege(college);
			userBean.setDegree(degree);
			UserDAO userDAO = new UserDAO();
			boolean flag = userDAO.addUser(userBean);
			String msg = flag ? "succesfully added"
					: "failed,please try again later";
			request.setAttribute("msg", msg);
			if (flag)
				request.getRequestDispatcher("index.jsp").forward(request,
						response);
			else
				request.getRequestDispatcher("/register").forward(request,
						response);
		}
	}

}
