package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserMusicService;
import service.logic.UserMusicServiceLogic;

@WebServlet("/delete.do")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserMusicService service = new UserMusicServiceLogic();
		HttpSession session = request.getSession();
		service.remove((String)session.getAttribute("userId"), Integer.parseInt(request.getParameter("id")));
		response.sendRedirect("myList.do");
	}

}
