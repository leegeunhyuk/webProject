package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.User;
import service.UserService;
import service.logic.UserServiceLogic;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private UserService service;
	private static final long serialVersionUID = 1L;

	public LoginController() {
		service = new UserServiceLogic();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		
		User user = service.find(loginId, password);
		
		HttpSession session = request.getSession();
		try{
			session.setAttribute("userId", user.getLoginId());
			session.setAttribute("name", user.getName());
			response.sendRedirect("list.do");
		}catch(Exception e){
			throw new RuntimeException();
		}
	}

}
