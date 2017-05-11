package com.model.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;
import com.model.bean.UserBean;
import com.util.ValidateUtils;

public class LoginAction implements Action{
	private void logout(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		HttpSession session = request.getSession();
		UserBean userBean = (UserBean) session.getAttribute("userBean");
		if (userBean != null) {
			session.removeAttribute("userBean");
			session.invalidate();
		}
		response.sendRedirect("index.jsp");
	}

	private void login(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		UserBean userBean = new UserDAO().authenticateUser(email,
				ValidateUtils.base64encode(password));
		if (userBean == null) {
			request.setAttribute("msg", "invalid email or password");
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);
			;
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("userBean", userBean);
			response.sendRedirect("userhome");
		}	
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action=request.getParameter("action");
		if (action == null) {
			request.setAttribute("msg", "Invalid Request");
			request.getRequestDispatcher("/register").forward(request,
					response);
		}
		else
		{
			switch (action.toLowerCase()) {
			case "login":
				login(request, response);
				break;
			case "logout":
				logout(request, response);
				break;
			default:
				request.setAttribute("msg", "Invalid Request");
				request.getRequestDispatcher("/register").forward(request,
						response);
				break;
			}
		}
		
	}

}
